tree grammar WaebricInterpreter;

options {
	tokenVocab = Waebric;
	ASTLabelType = CommonTree;
	backtrack = true;
}

scope Environment {
	Map<String,CommonTree> functions;
	Map<String,String> variables;
}

@header {
	package org.cwi.waebric;
	
	import java.io.IOException;
	import java.io.OutputStream;
	import java.text.SimpleDateFormat;
	
	import java.util.Date;
	import java.util.HashMap;
	import java.util.Map;
		
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
	public static Document document;
	public static Element current;

	public WaebricInterpreter(TreeNodeStream input, Map<String,CommonTree> functions) {
		super(input);
		document = new Document();
		
		// Attach function definitions to environment
		Environment_scope base = new Environment_scope();
		base.functions = functions;
		base.variables = new HashMap<String,String>();
		Environment_stack.push(base);
	}
	
	private WaebricInterpreter(TreeNodeStream input, Stack environment) {
		super(input);
		
		// Clone first element of environment stack for function definitions
		this.Environment_stack = environment;
	}
	
	/**
	 * Interpret program
	 * @param os: Output stream for interpreting main function
	 */
	public void interpretProgram(OutputStream os) throws RecognitionException {
		// Interpret the main function
		CommonTree main = getFunction("main");
		if(main != null) {
			interpretFunction(main);
			outputDocument(document, os);
		}
	}
	
	/**
	 * Interpret function
	 * @param function: Function AST
	 */
	private void interpretFunction(CommonTree function) throws RecognitionException {
		WaebricInterpreter instance = new WaebricInterpreter(
			new CommonTreeNodeStream(function),
			Environment_stack);
		instance.function();
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
			if(content instanceof Element) {
				document.setRootElement((Element) content);
			} else {
				Element XHTML = createXHTMLTag();
    				document.setRootElement(XHTML);
    				XHTML.addContent(content);
			}	
    			
			current = document.getRootElement();
		} else { // Add content to current element
			current.addContent(content); // Attach content
			if(content instanceof Element) { current = (Element) content; } // Update current
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
		} return null;
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
	private String getVariable(String name) {
		for(int i=$Environment.size()-1; i>=0; i--) {
			if($Environment[i]::variables.containsKey(name)) {
				return $Environment[i]::variables.get(name); 
			}
		} return "undef";
	}
	
	/**
	 * Define variable
	 * @param name: Variable name
	 * @param eval: Variable evaluation
	 */
	private void defineVariable(String name, String eval) {
		$Environment::variables.put(name, eval);
	}
	
}

// $<Site

site:			'site' mappings 'end' ;

mappings:		mapping? ( ';' mapping )* ;

mapping	:		PATH ':' markup ;

// $>
// $<Markup

markup:			IDCON attribute* arguments? { // Designator lifted as it complicated argument exchange
				CommonTree call = getFunction($IDCON.getText());
				if(call != null) {
					// Interpret called function
					interpretFunction(call);
				} else {
					// Process markup as XHTML tag
					addContent(new Element($IDCON.getText())); 
				}
			} ;

attribute:		'#' IDCON // ID attribute
			| '.' IDCON // Class attribute
			| '$' IDCON // Name attribute
			| ':' IDCON // Type attribute
			| '@' NATCON // Width attribute
			| '@' NATCON '%' NATCON; // Width-height attribute
			
arguments:		'(' argument? ( ',' argument )* ')' ;

argument:		expression ;

// $>
// $<Expressions

expression returns [String eval]
	: 	( var=IDCON { $eval = getVariable($var.getText()); }
				| NATCON { $eval = $NATCON.getText(); }
				| TEXT { $eval = $TEXT.getText(); }
				| SYMBOLCON { $eval = $SYMBOLCON.getText(); }
				| '[' ( e=expression { $eval = $e.eval; } )? ( ',' e=expression { $eval += ", " + $e.eval ; } )* ']'
				| '{' ( p=keyValuePair { $eval = $p.eval; } )? ( ',' p=keyValuePair { $eval += ", " + $p.eval ; } )* '}' 
			) ( '+' e=expression { $eval += $e.eval; } | '.' IDCON /* Field */ )* ;
			
keyValuePair returns [String eval]
	:		IDCON ':' e=expression { $eval = $IDCON.getText() + ":" + $e.eval; } ;

// $>
// $<Function

function:		'def' IDCON formals? statement* 'end' ;

formals:		'(' IDCON* ')' ;

// $>

// $<Statements

statement
	@init{ int ti = 0; int fi = 0; } // Initialize local variables
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
				}
			| ^( 'each' '(' IDCON ':' expression ')' statement )
			| letStatement
			| ^( '{' statement* '}' )
			| ^( 'comment' STRCON ';' ) {
					Comment comment = new Comment($STRCON.getText());
					addContent(comment);
				}
			| ^( 'echo' expression ';' ) {
					Text text = new Text($expression.eval);
					addContent(text);
				}
			| ^( 'echo' embedding ';' )
			| ^( 'cdata' expression ';' ) {
					CDATA cdata = new CDATA($expression.eval);
					addContent(cdata);
				}
			| 'yield;'
			| ^( markup ';' )
			| ^( markup markup* ',' expression ';' ) { 
					Text text = new Text($expression.eval);
					addContent(text);
				}
			| ^( markup markup* ',' statement )
			| ^( markup markup* embedding ';' )
			| ^( markup markup* ';' );

letStatement
	:		^( 'let' assignment+ 'in' statement* 'end' ) ;

// $>
// $<Assignments

assignment:		IDCON '=' expression ';' // Variable binding
			| IDCON formals statement ; // Function binding

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

embedding:		PRETEXT embed textTail ;

embed:			markup* expression { 
					Text text = new Text($expression.eval);
					addContent(text); 
				} 
			| markup* markup ;

textTail:		POSTTEXT | MIDTEXT embed textTail ;
