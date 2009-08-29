grammar Waebric2 ;

options {
	backtrack = true ;
	output = AST ;
}

tokens {
	// Imagionary tokens
	ATTRIBUTES = 'atts';
	ARGUMENTS = 'args';
	MARKUP = 'm';
	MARKUPS = 'mm' ;
	MARKUP_STATEMENT = 'ms';
	MARKUP_EXPRESSION = 'me' ;
	MARKUP_EMBEDDING = 'mb' ;
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

	public Waebric2Parser(TokenStream input, ArrayList<String> modules) {
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
			Waebric2Lexer lexer = new Waebric2Lexer(is);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
      			Waebric2Parser parser = new Waebric2Parser(tokens, modules);
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

// $<Module
module: 		'module' moduleId { modules.add($moduleId.path); } ( imprt | site | function )*
				-> ^( 'module' moduleId imprt* site* function* ) ;

moduleId 
	returns [String path = ""] // Determine physical path of module identifier
	@after { $path += ".wae"; }
	:		e=IDCON { $path += e.getText(); } 
			( '.' e=IDCON { $path += "/" + e.getText(); } )* ;
	
imprt:			'import' moduleId { if(modules.contains($moduleId.path)) { return retval; } } 
				-> 'import' moduleId ^( { parseFile($moduleId.path) } ) ;

// $>
// $<Site

site:			'site' mappings 'end' ;
mappings:		mapping? ( ';' mapping )* ;
mapping	:		PATH ':' markup ;

// $>
// $<Markup

markup:			IDCON attributes arguments
				-> ^( MARKUP IDCON attributes arguments ) ;
				
attributes:		attribute* 
				-> ^( ATTRIBUTES attribute* );	

attribute:		'#' IDCON // ID attribute
			| '.' IDCON // Class attribute
			| '$' IDCON // Name attribute
			| ':' IDCON // Type attribute
			| '@' NATCON // Width attribute
			| '@' NATCON '%' NATCON; // Width-height attribute
			
arguments:		( '(' argument? ( ',' argument )* ')' )?
				-> ^( ARGUMENTS argument* ) ;
				
argument:		expression // Variable definition
			| IDCON '=' expression ;

// $>
// $<Expressions

expression:		( IDCON | NATCON | TEXT | SYMBOLCON 
				| '[' expression? ( ',' expression )* ']' // List
				| '{' keyValuePair? ( ',' keyValuePair )* '}' // Record
			) ( '+' expression /* Cat */ | '.' IDCON /* Field */ )* ;
keyValuePair:		IDCON ':' expression ;

// $>
// $<Function

function:		'def' IDCON formals? statement* 'end'
				-> ^( 'def' IDCON ^( FORMALS formals? ) statement* ) ;
		
formals:		'(' IDCON? ( ',' IDCON )* ')'
				-> IDCON* ;

// $>

// $<Statements

statement:		regularStatement
			| markupStatement 
			;	

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
			
markupStatement:	( markup+ expression ';') => markup+ expression ';'
				-> ^( MARKUP_EXPRESSION markup+ expression )
			| ( markup+ regularStatement ) => markup+ regularStatement
				-> ^( MARKUP_STATEMENT markup+ regularStatement )
			| ( markup+ embedding ';' ) => markup+ embedding ';'
				-> ^( MARKUP_EMBEDDING markup+ embedding )
			| ( markup+ ';') => markup+ ';'
				-> ^( MARKUPS markup+ ) ;

// $>
// $<Assignments

assignment:		IDCON '=' expression ';' // Variable binding
			| IDCON formals '=' statement // Function binding
				-> ^( 'def' IDCON ^( FORMALS formals? ) statement ) ; // Manipulated to represent a function

// $>
// $<Predicates

predicate:		'!'* expression ( '.' type '?' )?
			( '&&' predicate | '||' predicate )* ;
			
type:			'list' 
			| 'record' 
			| 'string' 
			;

// $>
// $<Embedding

embedding:		PRETEXT embed textTail ;

embed:			( markup+ ) => markup+
				-> ^( MARKUPS markup+ )
			| ( markup* expression ) => markup* expression 
				-> ^( MARKUP_EXPRESSION markup* expression ) ;

textTail:		POSTTEXT 
			| MIDTEXT embed textTail 
			;

// $>

// Lexical rules
COMMENT:		'comment' { inString = true; } ;
SITE:			'site' { inSite = true; inPath = true; } ; // Site constructor
END:			'end' { inSite = false; inPath = false; } ; // Site destructor
SEMICOLON:		';' { inPath = inSite; } ; // Mapping separator
 
fragment LETTER:	'a'..'z' | 'A'..'Z' ;
fragment DIGIT:		'0'..'9' ;
fragment HEXADECIMAL:	( 'a'..'f' | 'A'..'F' | DIGIT )+ ;

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

SYMBOLCON:		'\'' SYMBOLCHAR* ;
fragment SYMBOLCHAR:	~( '\u0000'..'\u001F' | ' ' | ';' | ',' | '>' | '}' | ')') ;

NATCON:			DIGIT+ ;
IDCON:			LETTER ( LETTER | DIGIT | '-' )* ;

COMMENTS:		( '//' ( options {greedy=false;} : . )* '\n' 
			| '/*' ( options {greedy=false;} : . )* '*/' )
			{ skip(); } ; // Skip comments to optimze performance
LAYOUT: 		( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ { $channel = HIDDEN; } ;
