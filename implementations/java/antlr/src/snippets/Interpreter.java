package org.cwi.waebric;
	
	import java.io.File;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.OutputStream;
	import java.text.SimpleDateFormat;
	
	import java.util.HashMap;
	import java.util.Map;
	import java.util.Collection;
		
	import org.jdom.Attribute;
	import org.jdom.CDATA;
	import org.jdom.Comment;
	import org.jdom.Content;
	import org.jdom.Document;
	import org.jdom.Element;
	import org.jdom.Namespace;
	import org.jdom.Text;
	
	import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import InterpreterAction.Environment;
import InterpreterPreamble.Yieldable;
	
public class Interpreter {
	// JDOM elements
	private Document document;
	private Element current;
	private int depth = 0;
	
	// Yield stack
	private Stack<Yieldable> yieldStack = new Stack<Yieldable>();
	public class Yieldable {
		public Integer index;
		public Stack environment;
	}
	
	// Personal environments, due to inherited environments on function bindings
	private Map<String, Stack> environments = new HashMap<String, Stack>();
	
	// WAEBRIC loader
	private WaebricLoader loader;
	
	/**
	 * Interpret program
	 * @param os: Output stream for interpreting main function
	 */
	public void interpretProgram(OutputStream os, WaebricLoader loader) throws RecognitionException {
		this.loader = loader;
	
		// Store function definitions to allow lazy function binding
		Environment_stack.clear();
		Environment_scope base = new Environment_scope();
		base.functions = new HashMap<String, Integer>();
		base.variables = new HashMap<String, Integer>();
		for(String function: loader.getFunctions().keySet()) 
		{ base.functions.put(function, loader.getFunctions().get(function).index); }
		Environment_stack.push(base);
		
		// Interpret main function with zero arguments
		this.document = new Document();
		if(interpretFunction("main", new ArrayList<Integer>())) {
			outputDocument(document, os);
		}
		
		// Interpret mappings
		for(WaebricLoader.mapping_return mapping: loader.getMappings()) {
			input.seek(mapping.index);
    			mapping();
		}
	}
	
	/**
	 * Interpret function
	 * @param name: Function name
	 * @param args: Call arguments
	 */
    	private boolean interpretFunction(String name, List<Integer> args) throws RecognitionException {
    		int function = getFunction(name);
    		if(function != -1) {
    			// Retrieve function environment
    			Stack environment = cloneEnvironment();
			Environment_stack = getEnvironment(name);
    		
    			int actual = input.index();
    			input.seek(function);
    			function(args);
    			input.seek(actual);
    			
    			 // Restore environment
    			Environment_stack = environment;
    			
    			return true; // Succesfull interpretation
    		} return false;
    	}
    	
	/**
	 * Create file output stream for path
	 */
	private OutputStream createOutputStream(String path) throws IOException {
		int dirLength = path.lastIndexOf("/");
		
		// Create directories
		if(dirLength != -1) {
			File directory = new File(path.substring(0, dirLength));
			directory.mkdirs();
		}
		
		// Create file
		File file = new File(path);
		file.createNewFile();
		
		return new FileOutputStream(path); // Create stream
	}
	
	/**
	 * Write document to output stream
	 */
	private void outputDocument(Document document, OutputStream os) {
		try {
			if(os != null) {
				XMLOutputter out = new XMLOutputter(Format.getRawFormat());
				if(! document.hasRootElement()) { createXHTMLRoot(false); }
				out.output(document, os);
			}
		} catch(IOException e) { e.printStackTrace(); }
	}
	
	/**
	 * Attach content to current element, in-case element
	 * does not exist create root element.
	 * @param content
	 */
	private void addContent(Content content) {
		// Update JDOM objects
		if(current == null) {
			if(content instanceof Element) {
				document.setRootElement((Element) content);
			} else {
				createXHTMLRoot(false);
				document.getRootElement().addContent(content);
			}
		} else { current.addContent(content); }

		// Maintain field information
		if(content instanceof Element) {
			current = (Element) content;
			depth++;
		}
	}
	
	/**
	 * Create default XHTML root tag
	 * @return
	 */
	private void createXHTMLRoot(boolean namespace) {
		Element html;
		if(namespace) {
			Namespace XHTML = Namespace.getNamespace("xhtml", "http://www.w3.org/1999/xhtml");
			html = new Element("html", XHTML);
			html.setAttribute("lang", "en");
		} else { html = new Element("html"); }
		document.setRootElement(html);
		current = html;
	}
	
	/**
	 * Attach attribute value to current element
	 * @param att Attribute name
	 * @param value Added value
	 */
	private void addAttributeValue(String att, String value) {
		org.jdom.Attribute attribute = current.getAttribute(att);
		
		String actual = "";
		if(attribute != null) { actual = attribute.getValue() + " "; }
		current.setAttribute(att, actual + value);
	}

	/**
	 * Retrieve function
	 * @param name: Function name
	 */
	private Integer getFunction(String name) {
		for(int i=$Environment.size()-1; i>=0; i--) {
			if($Environment[i]::functions.containsKey(name)) {
				return $Environment[i]::functions.get(name); 
			}
		} return -1 ;
	}
	
	private boolean containsFunction(String name) {
		return getFunction(name) != -1;
	}
	
	private boolean containsYield(String name) {
		int index = getFunction(name);
		if(index != -1) { return loader.hasYield(index); }
		return false;
	}
	
	/**
	 * Define function
	 * @param name: Function name
	 * @param index: Function index
	 */
	private void defineFunction(String name, Integer index) {
		$Environment::functions.put(name, index);
	}
	
	/**
	 * Retrieve function environment
	 * @param name: Function name
	 */
	private Stack getEnvironment(String name) {
		if(environments.containsKey(name)) {
			return (Stack) environments.get(name).clone();
		} else {
			Stack environment = new Stack();
			environment.push(Environment_stack.elementAt(0));
			return environment;
		}
	}
	
	/**
	 * Retrieve variable
	 * @param name: Variable name
	 */
	private Integer getVariable(String name) {
		for(int i=$Environment.size()-1; i>=0; i--) {
			if($Environment[i]::variables.containsKey(name)) {
				return $Environment[i]::variables.get(name); 
			}
		} return -1;
	}
	
	/**
	 * Define variable
	 * @param name: Variable name
	 * @param eval: Variable evaluation
	 */
	private void defineVariable(String name, Integer input) {
		$Environment::variables.put(name, input);
	}
	
	/**
	 * Clone current environment, regular stack.clone() maintains scopes
	 */
	private Stack cloneEnvironment() {
		Stack result = new Stack();
		for(int i = 0; i < $Environment.size(); i++) {
			Environment_scope scope = new Environment_scope();
			scope.functions = new HashMap<String, Integer>();
			scope.functions.putAll($Environment[i]::functions);
			scope.variables = new HashMap<String, Integer>();
			scope.variables.putAll($Environment[i]::variables);
			result.push(scope);
		}
		return result;
	}
	
	private void restoreCurrent(int arg) {
		for(int i = 0; depth > arg; i++) {
			current = current.getParentElement();
			depth--;
		}
	}

	public void addYield(Integer index) {
		Yieldable element = new Yieldable();
		element.index = index;
		element.environment = cloneEnvironment();
		yieldStack.push(element);
	}
	
	Object input;
	
	public class Environment {
		public static Map<String, Integer> functions;
		public static Map<String, Integer> variables;
	 }
	
	public void mapping() {
		Object PATH;
		this.document = new Document(); this.current = null;
		try {
			OutputStream os = createOutputStream(PATH.toString());
			outputDocument(document, os);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void markup() {
		Object IDCON;
		boolean element;
		boolean yield = false;
		int start = input.index(); int attr = 0; int args = 0;
		attr = input.index();
		args = input.index();
		if(containsFunction(IDCON.getText())) {		
			// Process markup as function call
			int curr = input.index();
			input.seek(args);
			List<Integer> eval = arguments(true).args;
			input.seek(curr);
			
			// Store yield arguments
			if(containsYield(IDCON.getText()) && element) {
				yieldStack.add(start);
				yield = true;
			}
			
			// Start interpreting function
			interpretFunction(IDCON.getText(), eval);
		} else {
			// Process markup as tag
			addContent(new Element(IDCON.getText()));
			
			// Process attributes
			int actual = input.index();
			input.seek(attr);
			attributes();
			arguments(false);
			input.seek(actual);
		}
	}
	
	public void attribute() {
		Object IDCON,w,h;
		addAttributeValue("id", IDCON.getText());
		addAttributeValue("class", IDCON.getText());
		addAttributeValue("name", IDCON.getText());
		addAttributeValue("type", IDCON.getText());
		addAttributeValue("width", w.getText());
		addAttributeValue("height", h.getText());
	}
	
	public void arguments() {
		boolean call;
		List<Integer> args = new ArrayList<Integer>();
	}
	
	public void argument() {
		List<Integer> args;
		String IDCON;
		String expression;
		boolean call;
		if(call) { 
			args.add(expression.index); // Add expression index to argument collection
		} else {
			// Attach argument to value attribute
			Attribute attribute = current.getAttribute("value");
			String value = (attribute == null) ? "" : attribute.getValue() + ", ";
			value += expression.eval;
			current.setAttribute("value",  value);
		}
		if(call) {
			if(! Environment.variables.containsKey(IDCON.toString())) {
				defineVariable(IDCON.getText(), expression.toString());
			} args.add(expression.toString()); // Add expression index to argument collection
		} else { 
			if(IDCON.toString().equals("xmlns")) {
				// JDOM won't allow xmlns attributes
				current.setNamespace(Namespace.getNamespace("xhtml", "http://www.w3.org/1999/xhtml"));
			} else { addAttributeValue(IDCON.getText(), expression.toString()); }
		}
	}
	
	public void expression() {
		int index = -1; // Used for interpreting a referenced variable
		String eval = "undef"; // Evaluation value for printing
		Map<String, expression_return> map = new HashMap<String, expression_return>(); // Map structure for fields
		Collection<expression_return> collection = new ArrayList(); // List structure for iterations
		index = input.index();
		// Reference
		int curr = input.index();
		int next = getVariable($var.getText());
		if(next != -1) {
			input.seek(next);
			retval = expression();
			input.seek(curr);
		} 
		Object NATCON, TEXT, SYMBOLCON, id;
		eval = NATCON.getText();
		eval = TEXT.getText(); eval = eval.substring(1, eval.length()-1);
		eval = SYMBOLCON.getText(); eval = eval.substring(1, eval.length());
		collection.add(e);
		collection.add(e);
		eval = "[";
		for(expression_return eret:collection) { eval += eret.eval + ","; }
		eval = eval.substring(0, eval.length()); // Clip last character
		eval += "]";
		map.put(id.getText(), e);
		map.put(id.getText(), e);
		// Build record type string evaluation
		eval = "{";
		for(String key:map.keySet()) { eval += key + ":" + map.get(key).eval + ","; }
		eval = eval.substring(0, eval.length()); // Clip last character
		eval += "}";
		// Expression combination
		eval += e.eval;
		collection.clear();
		map.clear();
		if(map.containsKey(id.getText())) { retval = map.get(id.getText()); } 
		else {
			index = -1;
			eval = "undef";
			collection.clear();
			map.clear();
		}
	}
	
	public void function() {
		List<Integer> args;
		Object id;
		Element actual = null; int i = 0;
		if(args.size() > i) { 
	    	defineVariable(id.getText(), args.get(i));
	    	i++; // Increment counter
	    } else {
	    	defineVariable(id.getText(), -1);
	    }
	}
	
	public void statements() {
			int stms = loader.getStatementCount(input.index());
			if(stms > 1 && ! document.hasRootElement()) {
				createXHTMLRoot(false); 
			}
			
			int depth = this.depth;
		restoreCurrent(depth);
	}
	
	public void statement() {
		Object STRCON, expression, markup;
		addContent(new Comment(STRCON.getText().substring(1,STRCON.getText().length()-1)));
		addContent(new Text(expression.eval));
		addContent(new CDATA(expression.eval));
		if(! yieldStack.isEmpty()) {
			int curr = input.index();
			int index = yieldStack.pop();
			Stack clone = (Stack) yieldStack.clone();

			input.seek(index);
			matchAny(input); // Skip already interpreted markup
			markupChain(); // Execute copied markup chain
			input.seek(curr);
			
			yieldStack = clone;
		}
		if(markup.yield) { 
			matchAny(input); // Match markup chain, without executing
			match(input, Token.UP, null); // Match up
			return retval; // Quit parsing markup stm
		}
	}
	
	public void markupChain() {
		Object markup, expression, retval;
		if(markup.yield) { 
			matchAny(input); // Match markup chain, without executing
			match(input, Token.UP, null); // Match up
			return retval; // Quit parsing markup stm
		}
		addContent(new Text(expression.eval));
	}
	
	public void ifStatement() {
		Object predicate;
		int ti = 0; int fi = 0;
		ti = input.index();
		fi = input.index();
		int curr = input.index();
		if(predicate.eval) {
			input.seek(ti);
			statement();
			input.seek(curr);
		} else if(f != null) {
			input.seek(fi);
			statement();
			input.seek(curr);
		}
	}
	
	public void eachStatement() {
		Object IDCON;
		Environment.variables = new HashMap<String, Integer>();
		Environment.functions = new HashMap<String, Integer>();
		if(! document.hasRootElement()) { createXHTMLRoot(false); }
		int index = input.index();
		int depth = this.depth;
		int actual = input.index();
      			for(expression_return value: e.collection) {
      				defineVariable(IDCON.getText(), value.index);
      				input.seek(index);
      				statement();
      				input.seek(actual);	
      				restoreCurrent(depth);
      			}
	}
	
	public void blockStatement() {
		Element actual = this.current;
		if(actual != null) { this.current = actual; } 
		else { actual = this.current; } 
	}
	
	public void letStatement() {
		Environment.variables = new HashMap<String, Integer>();
		Environment.functions = new HashMap<String, Integer>();
		Element actual = this.current;
		if(actual != null) { this.current = actual; } 
		else { actual = this.current; } 
	}
	
	public void varBinding() {
		Object IDCON, expression;
		defineVariable(IDCON.getText(), expression.index);
	}
	
	public void funcBinding() {
		Object id;
		int index = input.index();
		environments.put(id.getText(), cloneEnvironment());
		defineFunction(id.getText(), index); 
	}
	
	public void predicate() {
		Object e,p;
		boolean eval;
		eval = ! p.eval;
		eval = e.index != -1;
		eval = e.eval.startsWith("[");
		eval = e.eval.startsWith("{");
		eval = e.index != -1;
		eval = eval && p.eval;
		eval = eval || p.eval;
	}
	
	public void embedding() {
		Object PRETEXT;
		addContent(new Text(PRETEXT.getText().substring(1, PRETEXT.getText().length()-1)));
	}
	
	public void embed() {
		int depth = this.depth;
		addContent(new Text(expression.eval));
		restoreCurrent(depth);
	}
	
	public void textTail() {
		int depth = this.depth;
		Object POSTTEXT, MIDTEXT;
		addContent(new Text(POSTTEXT.getText().substring(1, POSTTEXT.getText().length()-1)));
		addContent(new Text(MIDTEXT.getText().substring(1, MIDTEXT.getText().length()-1)));
		restoreCurrent(depth);
	}
}
