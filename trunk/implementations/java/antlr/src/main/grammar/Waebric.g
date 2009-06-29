grammar Waebric ;

options {
	backtrack=true ;
	language=Java ;
	output=AST ;
}

tokens {
	// Keywords
	MODULE = 'module' ;
	IMPORT = 'import' ;
	SITE = 'site' ;
	DEF = 'def' ;
	END = 'end' ;
	
	IF = 'if' ;
	ELSE = 'else' ;
	EACH = 'each' ;
	LET = 'let' ;
	IN = 'in' ;
	COMMENT = 'comment' ;
	ECHO = 'echo' ;
	CDATA = 'cdata' ;
	YIELD = 'yield' ;
	
	LIST = 'list' ;
	RECORD = 'record' ;
	STRING = 'string' ;
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

// Module definition
module:	 		'module' moduleId moduleElement* 'end' EOF ;
moduleId:		IDCON ( '.' IDCON )* ;
moduleElement:		imprt | site | function ;
imprt:			'import' moduleId ';' ;

// Site definition
site:			'site' mappings 'end' ;
mappings:		mapping? ( ';' mapping )* ;
mapping	:		PATH ':' markup ;

// Markup
markup:			designator arguments? ;
designator:		IDCON attribute* ;
attribute:		'#' IDCON | 
			'.' IDCON | 
			'$' IDCON | 
			':' IDCON | 
			'@' NATCON | 
			'@' NATCON '%' NATCON;
arguments:		('(' argument? ( ',' argument  )* ')') ;
argument:		expression ;

// Expression
expression:		IDCON | NATCON | SYMBOLCON ;

// Function definition
function:		'def' IDCON formals statement* 'end';
formals:		'(' IDCON? ( ',' IDCON )* ')' | ;

// Statement
statement:		'if' '(' predicate ')' statement 'else' statement | 
			'if' '(' predicate ')' statement |
			'each' '(' IDCON ':' expression ')' statement | 
			'let' assignment+ 'in' statement* 'end' |
			'{' statement* '}' |
			//'comment' STRCON ';' |
			'echo' expression ';' |
			//'echo' embedding ';' |
			'cdata' expression ';' | 
			'yield;' |
			markup ';' |
			markup+ statement ';' |
			markup+ markup ';' |
			markup+ expression ';' ;
assignment:		IDCON '=' expression ';' | // Variable binding
			IDCON formals statement ; // Function binding
			
// Predicate
predicate:		expression | expression '.' type | '!' predicate ; 
			//( predicate '||' predicate ) | ( predicate '&&' predicate );
type:			LIST | RECORD | STRING ;	
			
// Embedding
embedding:		pretext embed texttail ;	
embed:			markup* expression |
			markup* markup ;
texttail:		posttext | midtext embed texttail ;
pretext:		'"' TEXTCHAR* '<' ;
posttext:		'>' TEXTCHAR* '"' ;
midtext:		'>' TEXTCHAR* '<' ;

/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/
fragment LETTER:	'a'..'z' | 'A'..'Z' ;
fragment DIGIT:		'0'..'9' ;
fragment HEXADECIMAL:	( 'a'..'f' | 'A'..'F' | DIGIT )+ ;

// File
PATH:			PATHELEMENT ( '/' PATHELEMENT )* '/' FILENAME | FILENAME ;
fragment PATHELEMENT:	~( ' ' | '\t' | '\n' | '\r' | '.' | '/' | '\\' )+ ;
fragment FILENAME:	PATHELEMENT '.' FILEEXT ;		
fragment FILEEXT:	( LETTER | DIGIT )+ ;
 
// Text
TEXT:			'"' TEXTCHAR* '"' ;
fragment TEXTCHAR:	~( '\u0000'..'\u001F' | '&' | '"' | '\u0080'..'\uFFFF' ) |
			'\n' | '\r' | '\t' | ESCQUOTE | AMP | CHARREF | ENTREF ;
fragment ESCQUOTE:	'\\' | '\"' ;		
fragment AMP:		'\&' ~('#' | '0'..'9' | 'a'..'z' | 'A'..'Z' | '_' | ':') ;
fragment CHARREF:	'&#' DIGIT+ ';' | '&#x' HEXADECIMAL ';' ;
fragment ENTREF:	'&' ( LETTER | '_' | ':' ) ( LETTER | DIGIT | '.' | '-' | '_' | ':')* ';' ;

// String
STRCON:			'\"' STRCHAR* '\"' ;
fragment STRCHAR:	~( '\u0000'..'\u001F' | '"' | '\\' ) | ESCLAYOUT | DECIMAL ;
fragment ESCLAYOUT:	'\\n' | '\\t' | '\\\\"' | '\\\\\\\\' ;
fragment DECIMAL:	'\\' 'a' ('0'..'9') 'b' ('0'..'9') 'c' ('0'..'9') ;		

// Symbol
SYMBOLCON:		'\'' SYMBOLCHAR* ;
fragment SYMBOLCHAR:	~( '\u0000'..'\u001F' | ' ' | ';' | ',' | '>' | '}' | ')') ;

// Basic
NATCON:			DIGIT+ ;
IDCON:			LETTER ( LETTER | DIGIT | '-' )* ;

// Layout
COMMENTS:		'//' .* '\n' | '/*' .* '*/' { $channel = HIDDEN; } ;
LAYOUT: 		( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ { $channel = HIDDEN; } ;
