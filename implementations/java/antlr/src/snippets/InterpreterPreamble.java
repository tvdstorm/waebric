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
public class InterpreterPreamble {
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
	
}
