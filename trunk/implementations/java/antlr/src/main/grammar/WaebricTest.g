grammar WaebricTest;

options {
	output = AST ;
}

tokens {
	// Imagionary tokens
	ATTRIBUTES = 'atts';
	ARGUMENTS = 'args';
	ARGUMENT = 'arg' ;
	MARKUP = 'm';
	MARKUP_STATEMENT = 'mstm';
	FORMALS = 'f';
}

@parser::header {
	package org.cwi.waebric;
	import java.util.ArrayList;
}

@parser::members {
	/**
	 * Parsed modules
	 */
	private ArrayList<String> modules = new ArrayList<String>();

	public WaebricTestParser(TokenStream input, ArrayList<String> modules) {
		super(input);
		this.modules = modules;
	}

	/**
	 * Parse file on specified path.
	 * @return AST
	 */
	private CommonTree parseFile(String path) throws RecognitionException {
		try {
			CharStream is = new ANTLRFileStream(path);
			WaebricTestLexer lexer = new WaebricTestLexer(is);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
      			WaebricTestParser parser = new WaebricTestParser(tokens, modules);
      			return (CommonTree) parser.module().getTree();
      		} catch(java.io.IOException e) { return new CommonTree(); }
	}
}

@lexer::header {
	package org.cwi.waebric;
}

@lexer::members {
	// Maintain context information
	private boolean inSite = false;
	private boolean inPath = false;
	private boolean inString = false;
}

module: 		'module' moduleId { modules.add($moduleId.path); } ( imprt | site | function )*
				-> ^( 'module' moduleId imprt* site* function* ) ;

moduleId 
	returns [String path = ""]
	@after { $path += ".wae"; }
	:		e=IDCON { $path += e.getText(); } 
			( '.' e=IDCON { $path += "/" + e.getText(); } )* ;
	
imprt:			'import' moduleId { if(modules.contains($moduleId.path)) { return retval; } } 
				-> 'import' moduleId ^( { parseFile($moduleId.path) } ) ;

site:			'site' mappings 'end' ;

mappings:		mapping? ( ';' mapping )* ;

mapping	:		PATH ':' markup ;

function:		'def' IDCON formals? statement* 'end'
				-> ^( FUNCTION IDCON ^( FORMALS formals? ) statement* ) ;
				
formals:		'(' IDCON? ( ',' IDCON )* ')'
				-> IDCON* ;

markup:			IDCON attributes arguments?
				-> ^( MARKUP IDCON attributes arguments? ) ;
				
attributes:		attribute* 
				-> ^( ATTRIBUTES attribute* );	
				
attribute:		'#' IDCON // ID attribute
			| '.' IDCON // Class attribute
			| '$' IDCON // Name attribute
			| ':' IDCON // Type attribute
			| '@' NATCON // Width attribute
			| '@' NATCON '%' NATCON // Width-height attribute
			;

arguments:		'(' argument? ( ',' argument )* ')'
				-> ^( ARGUMENTS argument* ) ;

argument:		expression
				-> ^( ARGUMENT expression )
			| IDCON '=' expression 
				-> ^( ARGUMENT IDCON '=' expression ) ;

statement:		regularStatement
			| markupStatement 
			;	
			
expression:		( IDCON | NATCON | TEXT | SYMBOLCON 
				| '[' expression? ( ',' expression )* ']' // List
				| '{' keyValuePair? ( ',' keyValuePair )* '}' // Record
			) ( '+' expression | '.' IDCON )* ;
			
keyValuePair:		IDCON ':' expression ;

regularStatement:	'if' '(' predicate ')' statement ( 'else' statement )?
				-> ^( 'if' predicate statement ( 'else' statement )? )
			| 'each' '(' IDCON ':' expression ')' statement 
				-> ^( 'each' '(' IDCON ':' expression ')' statement )
			| 'let' assignment+ 'in' statement* 'end'
				-> ^( 'let' assignment+ 'in' statement* 'end' )
			| '{' statement* '}'
				-> ^( '{' statement* '}' )
			| 'yield' ';'
				-> ^( 'yield' )
			| 'comment' STRCON ';'
				-> ^( 'comment' STRCON )
			| 'echo' expression ';'
				-> ^( 'echo' expression )
			| 'echo' embedding ';'
				-> ^( 'echo' embedding )
			| 'cdata' expression ';'
				-> ^( 'cdata' expression )
			;
			
markupStatement:	( options {greedy=false;} : markup )+ 
			( expression ';' | regularStatement | embedding ';' | ';' ) 
				-> ^( MARKUP_STATEMENT markup+ expression? regularStatement? embedding? ) ;

assignment:		IDCON '=' expression ';' // Variable binding
			| IDCON formals '=' statement // Function binding
				-> ^( FUNCTION IDCON ^( FORMALS formals? ) statement ) ;
			
predicate:		'!'* expression ( '.' type '?' )?
			( '&&' predicate | '||' predicate )* ;
			
type:			'list' 
			| 'record' 
			| 'string' 
			;

embedding:		PRETEXT embed textTail ;

embed:			markup+ ;

textTail:		POSTTEXT 
			| MIDTEXT embed textTail 
			;		

// Lexical rules
MODULE:			'module' ;
IMPORT:			'import' ;	
SITE:			'site' { inSite = true; inPath = true; } ;
FUNCTION:	 	'def' ;
END:			'end' { inSite = false; inPath = false; } ;

IF:			'if' ;
ELSE:			'else' ;
LET:			'let' ;
IN:			'in' ;	
EACH:			'each' ;
YIELD:			'yield' ;
CDATA:			'cdata' ;
ECHO:			'echo' ;	
COMMENT:		'comment' { inString = true; } ;

LIST:			'list' ;
RECORD:			'record' ;
STRING:			'string' ;			

SEMICOLON:		';' { inPath = inSite; } ;
 
NATCON:			DIGIT+ ;
IDCON:			LETTER ( LETTER | DIGIT | '-' )* ;
SYMBOLCON:		'\'' SYMBOLCHAR* ;

fragment LETTER:	'a'..'z' | 'A'..'Z' ;
fragment DIGIT:		'0'..'9' ;
fragment HEXADECIMAL:	( 'a'..'f' | 'A'..'F' | DIGIT )+ ;
fragment SYMBOLCHAR:	~( '\u0000'..'\u001F' | ' ' | ';' | ',' | '>' | '}' | ')') ;

PATH:			{ inPath }? => ( PATHELEMENT '/' )* PATHELEMENT '.' FILEEXT { inPath = false; } ; 
fragment PATHELEMENT:	( LETTER | DIGIT | '%' )+ ; // '!'..'+' causes java heap exception
fragment FILEEXT:	( LETTER | DIGIT )+ ;

STRCON:			{ inString }? => '\"' STRCHAR* '\"' { inString = false; } ;
fragment STRCHAR:	~( '\u0000'..'\u001F' | '"' | '\\' ) | ESCLAYOUT | DECIMAL ;
fragment ESCLAYOUT:	'\\n' | '\\t' | '\\"' | '\\\\' ;
fragment DECIMAL:	'\\\\' 'a:' DIGIT 'b:' DIGIT 'c:' DIGIT ;				

TEXT:			{ ! inString }? => '\"' TEXTCHAR* '\"' ;
fragment TEXTCHAR:	~( '\u0000'..'\u001F' | '&' | '"' | '<' | '\u0080'..'\uFFFF' ) |
			 '\n' | '\r' | '\t' | ESCQUOTE | AMP | CHARREF | ENTREF ;
fragment ESCQUOTE:	'\\\\' | '\\"' ;		
fragment AMP:		'\&' ~('#' | '0'..'9' | 'a'..'z' | 'A'..'Z' | '_' | ':')+ ;
fragment CHARREF:	'&#' DIGIT+ ';' | '&#x' HEXADECIMAL ';' ;
fragment ENTREF:	'&' ( LETTER | '_' | ':' ) ( LETTER | DIGIT | '.' | '-' | '_' | ':')* ';' ;

PRETEXT:		'"' TEXTCHAR* '<' ;
POSTTEXT:		'>' TEXTCHAR* '"' ;
MIDTEXT:		'>' TEXTCHAR* '<' ;

COMMENTS:		( '//' ( options {greedy=false;} : . )* '\n' 
			| '/*' ( options {greedy=false;} : . )* '*/' )
			{ skip(); } ; // Skip comments to optimze performance
LAYOUT: 		( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ { $channel = HIDDEN; } ;
