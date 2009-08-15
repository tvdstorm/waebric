tree grammar WaebricInterpreter;

options {
	tokenVocab = Waebric;
	ASTLabelType = CommonTree;
	backtrack = true;
	output = AST;
}

scope Environment {
	Map<String, CommonTree> functions;
	Map<String, Integer> variables;
}

@header {
	package org.cwi.waebric;
	
	import java.io.File;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.OutputStream;
	import java.text.SimpleDateFormat;
	
	import java.util.Date;
	import java.util.HashMap;
	import java.util.Map;
	import java.util.Collection;
		
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
	public static Document document;
	public static Element current;
	
	// Additional fields
	public static Stack<Integer> yields;
	public static Map<String, Stack> environments;

	public WaebricInterpreter(TreeNodeStream input, Environment_scope base) {
		super(input);
		Environment_stack.push(base);
	}
	
	/**
	 * Interpret program
	 * @param os: Output stream for interpreting main function
	 */
	public void interpretProgram(OutputStream os, WaebricLoader loader) throws RecognitionException {
		// Store function definitions to allow lazy function binding
		Environment_stack.clear();
		Environment_scope base = new Environment_scope();
		base.functions = new HashMap<String, CommonTree>();
		base.variables = new HashMap<String, Integer>();
		for(String function: loader.getFunctions().keySet()) 
		{ base.functions.put(function, loader.getFunctions().get(function).tree); }
		Environment_stack.push(base);
		
		// Interpret main function
		this.document = new Document();
		if(interpretFunction("main")) {
			if(current != null) { outputDocument(document, os); }
		}
		
		// Interpret mappings
		for(WaebricLoader.mapping_return mapping: loader.getMappings()) {
			WaebricInterpreter instance = new WaebricInterpreter(
    				new CommonTreeNodeStream(mapping.tree),
    				(Environment_scope) Environment_stack.elementAt(0));
    			instance.mapping();
		}
	}
	
	/**
	 * Interpret function
	 * @param name: Function name
	 */
    	private boolean interpretFunction(String name) throws RecognitionException {
    		CommonTree function = getFunction(name);
    		if(function != null) {
    			WaebricInterpreter instance = new WaebricInterpreter(
    				new CommonTreeNodeStream(function),
    				(Environment_scope) Environment_stack.elementAt(0));
    			instance.function(); // Interpret function call in seperate instance, local scope
    			return true;
    		} return false;
    	}
	
	/**
	 * Write document to output stream
	 */
	private void outputDocument(Document document, OutputStream os) {
		try {
			if(os != null) {
				// Brand-mark document
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Comment comment = new Comment("Generated on " + format.format(new Date()));
				document.addContent(0, comment);
		
				// Output document
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
	private CommonTree getFunction(String name) {
		for(int i=$Environment.size()-1; i>=0; i--) {
			if($Environment[i]::functions.containsKey(name)) {
				return $Environment[i]::functions.get(name); 
			}
		} return null ;
	}
	
	/**
	 * Define function
	 * @param name: Function name
	 * @param tree: Function AST
	 */
	private void defineFunction(String name, CommonTree tree) {
		$Environment::functions.put(name, tree);
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
	
	// Create file output stream for path
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
	
}

// $<Site

mapping
	@init { this.document = new Document(); this.current = null; }
	:		PATH ':' markup { 
				try {
					OutputStream os = createOutputStream($PATH.toString());
					outputDocument(document, os);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} ;

// $>
// $<Markup

markup:			^( MARKUP IDCON . . ) {
				if(! interpretFunction($IDCON.getText())) {
					addContent(new Element($IDCON.getText())); 
				}
			} ;
			
attributes:		^( ATTRIBUTES attribute* ) ;

attribute:		'#' IDCON { current.setAttribute("id", $IDCON.getText()); }
			| '.' IDCON { current.setAttribute("class", $IDCON.getText()); }
			| '$' IDCON { current.setAttribute("name", $IDCON.getText()); }
			| ':' IDCON { current.setAttribute("type", $IDCON.getText()); }
			| '@' w=NATCON { current.setAttribute("width", $w.getText()); }
				( '%' h=NATCON{ current.setAttribute("height", $h.getText()); } )? ;
			
arguments:		^( ARGUMENTS argument* ) ;

argument:		expression
			| IDCON '=' expression { current.setAttribute($IDCON.getText(), $expression.eval); } ;

// $>
// $<Expressions

expression returns [
		int index; // Used for interpreting a referenced variable
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
			  		// List
					$eval = "[";
					for(expression_return eret:$collection) { $eval += eret.eval + ","; }
					$eval = $eval.substring(0, $eval.length()); // Clip last character
					$eval += "]";
				}
			| '{' ( id=IDCON ':' e=expression { $map.put($id.getText(), e); } )? 
			  ( ',' id=IDCON ':' e=expression { $map.put($id.getText(), e); } )* '}' {
			  		// Record
					$collection = $map.values();
					$eval = "{";
					for(String key:$map.keySet()) { $eval += key + ":" + $map.get(key).eval + ","; }
					$eval = $eval.substring(0, $eval.length()); // Clip last character
					$eval += "}";
				}
			) 
			
			// Recursive expressions
			( '+' e=expression {
					// Cat
					$eval += $e.eval;
					$collection.clear();
					$map.clear();
				} 
			| '.' id=IDCON {
					// Field
					if($map.containsKey($id.getText())) { retval = $map.get($id.getText()); } 
					else {
						$eval = "undef";
						$collection.clear();
						$map.clear();
					}
				}
			)* ;
	
// $>
// $<Function

function
	@init { Element actual = null; }
	:		^( FUNCTION IDCON 
				formals // TODO: Store formal as variables with called arguments
				( statement { 
					if(actual != null) { this.current = actual; } 
					else { actual = this.current; } 
				} )* // Reset JDOM element
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
			| ^( 'echo' embedding ';' )
			| ^( 'cdata' expression ';' ) {	addContent(new CDATA($expression.eval)); }
			| 'yield;'
			| ^( MARKUP_STATEMENT markup+ expression ';' ) { addContent(new Text($expression.eval)); }
			| ^( MARKUP_STATEMENT markup+ embedding ';' )
			| ^( MARKUP_STATEMENT markup+ ';' ) 
			| ^( MARKUP_STATEMENT markup+ statement ) ;

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
		$Environment::functions = new HashMap<String, CommonTree>();
		int stm = 0;
	} :		^( 'each' '(' IDCON ':' e=expression ')' { stm = input.index(); } . ) {
				int actualIndex = input.index();
              			Element actualElement = this.current;
              			for(expression_return value: e.collection) {
              				$Environment::variables.put($IDCON.getText(), value.index);
              				input.seek(stm);
              				statement();
              				input.seek(actualIndex);	
              				if(actualElement == null) { actualElement = document.getRootElement(); }
              				this.current = actualElement;
              			}
			};

blockStatement
	@init { Element actual = this.current; }
	:		^( '{' ( statement { this.current = actual; } )* '}' ) ;		

letStatement
	scope Environment;
	@init {
		$Environment::variables = new HashMap<String, Integer>();
		$Environment::functions = new HashMap<String, CommonTree>();
		Element actual = this.current;
	} :		^( 'let' assignment+ 'in' 
			( statement { this.current = actual; } )* 
			'end' ) ;

// $>
// $<Assignments

assignment:		varBinding | funcBinding ;
		
varBinding
	@init{ int index = 0; }
	:		IDCON '=' { index = input.index(); } expression ';' {
				defineVariable($IDCON.getText(), index);
			} ;
			
funcBinding :		^( FUNCTION id=IDCON formals stm=. ) ;
	finally {
		defineFunction($id.getText(), $funcBinding.tree);
	}

// $>
// $<Predicates

predicate returns [boolean eval]
	:		( '!' p=predicate { $eval = ! $p.eval; }
				| e=expression { $eval = getVariable($e.eval) != null; } // Not null
				| e=expression '.' type // Is type 
			) ( '&&' p=predicate { $eval = $eval && $p.eval; } | '||' p=predicate { $eval = $eval || $p.eval; } )* ;
			
type:			'list' | 'record' | 'string' ;

// $>
// $<Embedding

embedding:		PRETEXT { addContent(new Text($PRETEXT.getText())); } embed textTail ;

embed:			markup* expression { addContent(new Text($expression.eval)); } 
			| markup+ ;

textTail:		POSTTEXT { addContent(new Text($POSTTEXT.getText())); }
			| MIDTEXT { addContent(new Text($MIDTEXT.getText())); } embed textTail ;
