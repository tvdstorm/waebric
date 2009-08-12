tree grammar WaebricInterpreter;

options {
	tokenVocab = Waebric;
	ASTLabelType = CommonTree;
	backtrack = true;
}

scope Environment {
	Map<String,CommonTree> functions;
	Map<String,CommonTree> variables;
}

@header {
	package org.cwi.waebric;
	
	import java.io.IOException;
	import java.io.OutputStream;
	import java.text.SimpleDateFormat;
	import java.util.Date;
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
	private Document document;
	private Element current;

	public WaebricInterpreter(TreeNodeStream input, Map<String,CommonTree> functions) {
		super(input);
		Environment_scope base = new Environment_scope();
		base.functions = functions;
		Environment_stack.push(base);
		document = new Document();
	}
	
	private WaebricInterpreter(TreeNodeStream input, Stack environment, Document document) {
		super(input);
		this.Environment_stack = environment;
		this.document = document;
	}
	
	/**
	 * Interpret program
	 * @param os: Output stream for interpreting main function
	 */
	public void interpretProgram(OutputStream os) throws RecognitionException {
		CommonTree main = getFunction("main");
		if(main != null) {
			WaebricInterpreter sub = new WaebricInterpreter( 
				new CommonTreeNodeStream(main),
				Environment_stack,
				document);
			sub.function(); // Interpret function and fill document
			outputDocument(document, os);
		} 
	}
	
	/**
	 * Write document to output stream
	 */
	private void outputDocument(Document document, OutputStream os) {
		try {
			if(os == null) { return; }
			
			// Brand-mark document
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Comment comment = new Comment("Generated on " + format.format(new Date()));
			document.addContent(0, comment);
		
			// Output document
			XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
			out.output(document, os);
		} catch(IOException e) { e.printStackTrace(); }
	}
	
	private void addContent(Content content) {
		// Construct root element
		if(current == null) {
			if(content instanceof Element) {
				Element rootElement = (Element) content;
				document.setRootElement(rootElement);
				current = rootElement;
				return; // Content added, quit function
			} else {
				Element XHTML = createXHTMLTag();
				document.setRootElement(XHTML);
				current = XHTML;
			}
		}
		
		current.addContent(content); // Attach content
		if(content instanceof Element) { current = (Element) content; } // Update current
	}
	
	private Element createXHTMLTag() {
		Namespace XHTML = Namespace.getNamespace("xhtml", "http://www.w3.org/1999/xhtml");
		Element tag = new Element("html", XHTML);
		tag.setAttribute("lang", "en");
		return tag;
	}
	
	/**
	 * Retrieve function
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
	 */
	private void defineFunction(String name, CommonTree tree) {
		$Environment::functions.put(name, tree);
	}
	
	/**
	 * Retrieve variable
	 */
	private CommonTree getVariable(String name) {
		for(int i=$Environment.size()-1; i>=0; i--) {
			if($Environment[i]::variables.containsKey(name)) {
				return $Environment[i]::variables.get(name); 
			}
		} return null;
	}
	
	/**
	 * Define variable
	 */
	private void defineVariable(String name, CommonTree tree) {
		$Environment::variables.put(name, tree);
	}
	
}

// $<Module
module: 		^( 'module' moduleId imprt* site* function* ) ;

moduleId:		IDCON ( '.' e=IDCON )* ;
	
imprt:			'import' moduleId ';' ^ module ;

// $>
// $<Site

site:			'site' mappings 'end' ;

mappings:		mapping? ( ';' mapping )* ;

mapping	:		PATH ':' markup ;

// $>
// $<Markup

markup:			IDCON attribute* arguments? { // Designator lifted as it complicated argument exchange
				CommonTree func = getFunction($IDCON.getText());
				if(func != null) {
					WaebricInterpreter sub = new WaebricInterpreter( 
						new CommonTreeNodeStream(func),
						Environment_stack,
						document);
					sub.function(); // Walk called function
				} else {
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
	: 	( var=IDCON { $eval = $var.getText(); }
				| NATCON { $eval = $NATCON.getText(); }
				| TEXT { $eval = $TEXT.getText(); }
				| SYMBOLCON { $eval = $SYMBOLCON.getText(); }
				| '[' ( e=expression { $eval = $e.eval; } )? ( ',' e=expression { $eval += ", " + $e.eval ; } )* ']'
				| '{' ( p=keyValuePair { $eval = $p.eval; } )? ( ',' p=keyValuePair { $eval += ", " + $p.eval ; } )* '}' 
			) ( '+' e=expression { $eval += $e.eval; } | '.' IDCON /* Field */ )* 	;
			
keyValuePair returns [String eval]
	:		IDCON ':' e=expression { $eval = $IDCON.getText() + ":" + $e.eval; } ;

// $>
// $<Function

function:		'def' IDCON formals? { 
				System.out.println("Walking function " + $IDCON.getText() + "! WOAAA.." );
			} statement* 'end' ;

formals:		'(' IDCON* ')' ;

// $>

// $<Statements

statement:		'if' '(' predicate ')' statement 'else' statement 
			| 'if' '(' predicate ')' statement 
			| 'each' '(' IDCON ':' expression ')' statement 
			| 'let' assignment+ 'in' statement* 'end' 
			| '{' statement* '}' 
			| 'comment' STRCON ';' 
			| 'echo' expression ';' 
			| 'echo' embedding ';'
			| 'cdata' expression ';' 
			| 'yield;' 
			| markup+ ',' expression ';'
			| markup+ ',' statement
			| markup+ embedding ';' 
			| markup+ ';' ;

// $>
// $<Assignments

assignment:		IDCON '=' expression ';' // Variable binding
			| IDCON formals statement ; // Function binding

// $>
// $<Predicates

predicate returns [boolean eval]
	:		( '!' p=predicate { $eval = ! $p.eval; }
				| expression // Not null
				| expression '.' type // Is type 
			) ( '&&' p=predicate { $eval = $eval && $p.eval; } | '||' p=predicate { $eval = $eval || $p.eval; } )* ;
			
type:			'list' | 'record' | 'string' ;

// $>
// $<Embedding

embedding:		PRETEXT embed textTail ;

embed:			markup* expression | markup* markup ;

textTail:		POSTTEXT | MIDTEXT embed textTail ;
