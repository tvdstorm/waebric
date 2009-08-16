grammar Waebric ;

options {
	backtrack = true ;
	output = AST ;
}

tokens {
	ATTRIBUTES = 'atts';
	ARGUMENTS = 'args';
	MARKUP = 'mrku';
	MARKUP_STATEMENT = 'mstm';
	MARKUP_CHAIN = 'mc';
	FORMALS = 'fmls';
	FUNCTION = 'def';
}

@parser::header {
	package org.cwi.waebric;
	import java.util.ArrayList;
}

@parser::members {
	/**
	 * Parse file on specified path.
	 * @return AST
	 */
	private CommonTree parseFile(String path) throws RecognitionException {
		try {
			CharStream is = new ANTLRFileStream(path);
			WaebricLexer lexer = new WaebricLexer(is);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
      			WaebricParser parser = new WaebricParser(tokens);
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
module: 		'module' moduleId ( imprt | site | function )*
				-> ^( 'module' moduleId imprt* site* function* ) ; // Requires root node

moduleId 
	returns [String path = ""] // Determine physical path of module identifier
	@after { $path += ".wae"; } // Each reference ends with waebric extension
	:		e=IDCON { $path += e.getText(); } 
			( '.' e=IDCON { $path += "/" + e.getText(); } )* ;
	
imprt:			'import' moduleId
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
			| IDCON '=' expression ; // Attribute definition

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
				-> ^( FUNCTION IDCON ^( FORMALS formals? ) statement* ) ;
		
formals:		'(' IDCON? ( ',' IDCON )* ')'
				-> IDCON* ;

// $>

// $<Statements

statement:		'if' '(' predicate ')' statement ( 'else' statement )?
				-> ^( 'if' '(' predicate ')' statement ( 'else' statement )? )
			| 'each' '(' IDCON ':' expression ')' statement 
				-> ^( 'each' '(' IDCON ':' expression ')' statement )
			| 'let' assignment+ 'in' statement* 'end'
				-> ^( 'let' assignment+ 'in' statement* 'end' )
			| '{' statement* '}'
				-> ^( '{' statement* '}' )
			| 'comment' STRCON ';'
				-> ^( 'comment' STRCON ';' )
			| 'echo' expression ';'
				-> ^( 'echo' expression ';' )
			| 'echo' embedding ';'
				-> ^( 'echo' embedding ';' )
			| 'cdata' expression ';' 
				-> ^( 'cdata' expression ';' )
			| 'yield;'
			| markup markupChain
				-> ^( MARKUP_STATEMENT markup markupChain );

markupChain:		markup markupChain 
				-> ^( MARKUP_CHAIN markup markupChain )
			| expression ';' 
				-> ^( MARKUP_CHAIN expression ';' )
			| statement  
				-> ^( MARKUP_CHAIN statement )
			| embedding ';' 
				-> ^( MARKUP_CHAIN embedding ';' )
			| ';' 
				-> ^( MARKUP_CHAIN ';' ) ;

// $>
// $<Assignments

assignment:		IDCON '=' expression ';' // Variable binding
			| IDCON formals '=' statement // Function binding
				-> ^( FUNCTION IDCON ^( FORMALS formals? ) statement ) ; // Manipulated to represent a function

// $>
// $<Predicates

predicate:		( '!' predicate 
				| expression // Not null
				| expression '.' type // Is type 
			) ( '&&' predicate | '||' predicate )* ; // Left-recussion removal
type:			'list' | 'record' | 'string' ;

// $>
// $<Embedding

embedding:		PRETEXT embed textTail ;
embed:			markup* expression | markup* markup ;
textTail:		POSTTEXT | MIDTEXT embed textTail ;

// $>

// Lexical rules
COMMENT	:		'comment' { inString = true; } ;
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
