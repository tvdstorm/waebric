tree grammar WaebricInterpreter;

options {
	tokenVocab = Waebric;
	ASTLabelType = CommonTree;
	backtrack = true;
	output = AST;
}

scope Environment {
	Map<String, Integer> functions;
	Map<String, Integer> variables;
}

@header {
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
}

@members {
	// JDOM elements
	private Document document;
	private Element current;
	
	// Yield related
	private Stack<Integer> yieldStack = new Stack<Integer>();
	private List<Integer> yieldLocations = new ArrayList<Integer>();
	
	// Personal environments, due to inherited environments on function bindings
	private Map<String, Stack> environments = new HashMap<String, Stack>();
	
	/**
	 * Interpret program
	 * @param os: Output stream for interpreting main function
	 */
	public void interpretProgram(OutputStream os, WaebricLoader loader) throws RecognitionException {
		yieldLocations = loader.getYields(); // Store yield information
	
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
			if(current != null) { outputDocument(document, os); }
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
				XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
				out.output(document, os);
			}
		} catch(IOException e) { e.printStackTrace(); }
	}
	
    	private void addContent(Content content) {
    		if(current == null) { // Construct root element
        		if(content instanceof Element && ((Element) content).getName().equals("html")) {
        			document.setRootElement((Element) content);
        			current = document.getRootElement();
        		} else {
        			Element XHTML = createXHTMLTag();
            			document.setRootElement(XHTML);
            			XHTML.addContent(content);
            			
            			if(content instanceof Element) { current = (Element) content; }
            			else { current = XHTML; }
        		}	
        	} else {
    			current.addContent(content); // Attach content
    			if(content instanceof Element) { current = (Element) content; }
    		}
    	}
	
	private Element createXHTMLTag() {
		Namespace XHTML = Namespace.getNamespace("xhtml", "http://www.w3.org/1999/xhtml");
		Element tag = new Element("html", XHTML);
		tag.setAttribute("lang", "en");
		return tag;
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
		if(index != -1) { return yieldLocations.contains(index); }
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
	
}

// $<Site

mapping
	@init { this.document = new Document(); this.current = null; }
	:		PATH ':' markup[false] { 
				try {
					OutputStream os = createOutputStream($PATH.toString());
					if(current != null) { outputDocument(document, os); }
				} catch (IOException e) {
					e.printStackTrace();
				}
			} ;

// $>
// $<Markup

markup [boolean element]
	returns[boolean yield = false;]
	@init { int start = input.index(); int attr = 0; int args = 0; }
	:		^( MARKUP IDCON { attr = input.index(); } . { args = input.index(); } . ) {
				if(containsFunction($IDCON.getText())) {		
					// Process markup as function call
					int curr = input.index();
					input.seek(args);
					List<Integer> eval = arguments(true).args;
					input.seek(curr);
					
					// Store yield arguments
					if(containsYield($IDCON.getText()) && element) {
						yieldStack.add(start);
						$yield = true;
					}
					
					// Start interpreting function
					interpretFunction($IDCON.getText(), eval);
				} else {
					// Process markup as tag
					addContent(new Element($IDCON.getText()));
					
					// Process attributes
					int actual = input.index();
					input.seek(attr);
					attributes();
					arguments(false);
					input.seek(actual);
				}
			} ;
			
attributes:		^( ATTRIBUTES attribute* ) ;

attribute:		'#' IDCON { current.setAttribute("id", $IDCON.getText()); }
			| '.' IDCON { current.setAttribute("class", $IDCON.getText()); }
			| '$' IDCON { current.setAttribute("name", $IDCON.getText()); }
			| ':' IDCON { current.setAttribute("type", $IDCON.getText()); }
			| '@' w=NATCON { current.setAttribute("width", $w.getText()); }
				( '%' h=NATCON{ current.setAttribute("height", $h.getText()); } )? ;
			
arguments [boolean call]
	returns [List<Integer> args = new ArrayList<Integer>()]
	:		^( ARGUMENTS argument[$args, call]* ) ;

argument [List<Integer> args, boolean call]
	:		expression {
				if(call) { 
					args.add($expression.index); // Add expression index to argument collection
				} else {
					// Attach argument to value attribute
					Attribute attribute = current.getAttribute("value");
					String value = (attribute == null) ? "" : attribute.getValue() + ", ";
					value += $expression.eval;
					current.setAttribute("value",  value);
				}
			} | IDCON '=' expression {
				if(call) { 
					 // TODO: Figure out what to do
				} else { 
					if($IDCON.getText().equals("xmlns")) {
						// JDOM won't allow xmlns attributes
						current.setNamespace(Namespace.getNamespace("xhtml", "http://www.w3.org/1999/xhtml"));
					} else { current.setAttribute($IDCON.getText(), $expression.eval); }
				} 
			} ;

// $>
// $<Expressions

expression returns [
		int index = -1, // Used for interpreting a referenced variable
		String eval = "undef", // Evaluation value for printing
		Map<String, expression_return> map = new HashMap<String, expression_return>(), // Map structure for fields
		Collection<expression_return> collection = new ArrayList() // List structure for iterations
	] @init{ retval.index = input.index(); }
	: 		// Non-recursive expressions
			( var=IDCON {
					// Reference
					int curr = input.index();
					int next = getVariable($var.getText());
					if(next != -1) {
						input.seek(next);
						retval = expression();
						input.seek(curr);
					} 
				}
			| NATCON { $eval = $NATCON.getText(); }
			| TEXT { $eval = $TEXT.getText(); $eval = $eval.substring(1, $eval.length()-1); }
			| SYMBOLCON { $eval = $SYMBOLCON.getText(); $eval = $eval.substring(1, $eval.length()); }
			| '[' ( e=expression { $collection.add(e); } )? 
			  ( ',' e=expression { $collection.add(e); } )* ']' {
			  		// Build list type string evaluation
					$eval = "[";
					for(expression_return eret:$collection) { $eval += eret.eval + ","; }
					$eval = $eval.substring(0, $eval.length()); // Clip last character
					$eval += "]";
				}
			| '{' ( id=IDCON ':' e=expression { $map.put($id.getText(), e); } )? 
			  ( ',' id=IDCON ':' e=expression { $map.put($id.getText(), e); } )* '}' {
			  		// Build record type string evaluation
					$collection = $map.values();
					$eval = "{";
					for(String key:$map.keySet()) { $eval += key + ":" + $map.get(key).eval + ","; }
					$eval = $eval.substring(0, $eval.length()); // Clip last character
					$eval += "}";
				}
			) 
			
			// Recursive expressions
			( '+' e=expression {
					// Expression combination
					$eval += $e.eval;
					$collection.clear();
					$map.clear();
				} 
			| '.' id=IDCON {
					// Record field
					if($map.containsKey($id.getText())) { retval = $map.get($id.getText()); } 
					else {
						$index = -1;
						$eval = "undef";
						$collection.clear();
						$map.clear();
					}
				}
			)* ;
	
// $>
// $<Function

function [List<Integer> args]
	@init { Element actual = null; int curr = 0; }
	:		^( FUNCTION IDCON 
				// Store formals as variable with corresponding argument
				^( FORMALS ( id=IDCON {	if($args.size() > curr) { 
					defineVariable($id.getText(), $args.get(curr)); curr++;
				} } )* )
				
				// Execute each statement and reset JDOM element
				( statement { 
					if(actual != null) { this.current = actual; } 
					else { actual = this.current; } 
				} )*
			) ;

formals:		^( FORMALS IDCON* ) ;

// $>

// $<Statements

statement:		ifStatement
			| eachStatement
			| letStatement
			| blockStatement
			| ^( 'comment' STRCON ';' ) { addContent(new Comment($STRCON.getText())); }
			| ^( 'echo' expression ';' ) { addContent(new Text($expression.eval)); }
			| ^( 'echo' embedding[false] ';' )
			| ^( 'cdata' expression ';' ) {	addContent(new CDATA($expression.eval)); }
			| 'yield;' {
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
				}
			| ^( MARKUP_STATEMENT markup[true] { 
					if($markup.yield) { 
						matchAny(input); // Match markup chain, without executing
						match(input, Token.UP, null); // Match up
						return retval; // Quit parsing markup stm
					}
				} markupChain ) ;
					
					
markupChain:		^( MARKUP_CHAIN markup[true] {
					if($markup.yield) { 
						matchAny(input); // Match markup chain, without executing
						match(input, Token.UP, null); // Match up
						return retval; // Quit parsing markup stm
					}
				} markupChain )
			| ^( MARKUP_CHAIN expression ';' ) { addContent(new Text($expression.eval)); }
			| ^( MARKUP_CHAIN statement )
			| ^( MARKUP_CHAIN embedding[true] ';' )
			| ^( MARKUP_CHAIN ';' ) ;

ifStatement
	@init{ int ti = 0; int fi = 0; }
	:		^( 'if' '(' predicate ')' { ti = input.index(); } t=.  ( 'else' { fi = input.index(); } f=. )? ) {
				int curr = input.index();
				if($predicate.eval) {
					input.seek(ti);
					statement();
					input.seek(curr);
				} else if(f != null) {
					input.seek(fi);
					statement();
					input.seek(curr);
				}
			} ;
			
eachStatement
	scope Environment;
	@init {
		$Environment::variables = new HashMap<String, Integer>();
		$Environment::functions = new HashMap<String, Integer>();
		int stm = 0;
	} :		^( 'each' '(' IDCON ':' e=expression ')' { stm = input.index(); } . ) {
				int actualIndex = input.index();
              			Element actualElement = this.current;
              			for(expression_return value: e.collection) {
              				defineVariable($IDCON.getText(), value.index);
              				input.seek(stm);
              				statement();
              				input.seek(actualIndex);	
              				if(actualElement == null) { actualElement = document.getRootElement(); }
              				this.current = actualElement;
              			}
			};

blockStatement
	@init { Element actual = this.current; }
	:		^( '{' ( statement { 
					if(actual != null) { this.current = actual; } 
					else { actual = this.current; } 
				} )* '}' ) ;		

letStatement
	scope Environment;
	@init {
		$Environment::variables = new HashMap<String, Integer>();
		$Environment::functions = new HashMap<String, Integer>();
		Element actual = this.current;
	} :		^( 'let' assignment+ 'in' ( statement { 
					if(actual != null) { this.current = actual; } 
					else { actual = this.current; } 
				} )* 'end' ) ;

// $>
// $<Assignments

assignment:		varBinding | funcBinding ;
		
varBinding:		IDCON '=' expression ';' {
				defineVariable($IDCON.getText(), $expression.index);
			} ;
			
funcBinding
	@init { int index = input.index(); }
	:		^( FUNCTION id=IDCON formals . ) { 
				environments.put($id.getText(), cloneEnvironment());
				defineFunction($id.getText(), index); 
			} ;

// $>
// $<Predicates

predicate returns [boolean eval]
	:		( '!' p=predicate { $eval = ! $p.eval; }
				| e=expression { $eval = $e.index != -1; } // Is defined
				| e=expression '.' ( 'list' {
							$eval = $e.eval.startsWith("[");
						 } | 'record' { 
						 	$eval = $e.eval.startsWith("{");
						 } | 'string' { 
						 	$eval = $e.index != -1;
						 } ) '?' // Is type 
			) ( '&&' p=predicate { $eval = $eval && $p.eval; } | '||' p=predicate { $eval = $eval || $p.eval; } )* ;
		
// $>
// $<Embedding

embedding [boolean element]
	:		PRETEXT { addContent(new Text($PRETEXT.getText().substring(1, $PRETEXT.getText().length()-1))); } 
			embed[element] textTail[element] ;

embed [boolean element]
	:		markup[element]+ 
			| markup[element]* expression { addContent(new Text($expression.eval)); } ;

textTail [boolean element]
	:		POSTTEXT { addContent(new Text($POSTTEXT.getText().substring(1, $POSTTEXT.getText().length()-1))); }
			| MIDTEXT { addContent(new Text($MIDTEXT.getText().substring(1, $MIDTEXT.getText().length()-1))); } embed[element] textTail[element] ;
