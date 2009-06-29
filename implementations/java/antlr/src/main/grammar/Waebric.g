grammar Waebric;

options {
	backtrack=true;
	language=Java;
	output=AST;
}

tokens {
	// Symbols
	COMMA = ',';
	PERIOD = '.';
	PLUS = '+';
	MINUS = '-';
	EQUALS = '=';
	COLON = ':';
	SEMICOLON = ';';
	LPAREN = '(';
	RPARENT = ')';
	LCBRACKET = '{';
	RCBRACKET = '}';
	LBRACKET = '[';
	RBRACKET = ']';
	AT = '@';
	DOLLAR = '$';
	POUND = '#';
	PERCENT = '%';
	AMP = '&';
	LESS_THAN = '<';
	GREATER_THAN = '>';
	
	// Keywords
	MODULE = 'module';
	IMPORT = 'import';
	SITE = 'site';
	DEF = 'def';
	END = 'end';
	
	IF = 'if';
	ELSE = 'else';
	EACH = 'each';
	LET = 'let';
	IN = 'in';
	COMMENT = 'comment';
	ECHO = 'echo';
	CDATA = 'cdata';
	YIELD = 'yield';
	
	LIST = 'list';
	RECORD = 'record';
	STRING = 'string';
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

// Module
module:	 		'module' moduleId moduleElement* 'end' EOF;
moduleId:		IDCON ( '.' IDCON )*;
moduleElement:		imprt | site | function;

imprt:			'import' moduleId ';';
site:			'site' /* mapping */ 'end';
function:		'def' IDCON formals statement* 'end';
formals:		'(' IDCON? ( ',' IDCON )* ')' | ;

/**
mapping	:	path ':' markup;
path:		filename | dirname '/' filename;
dirname:	directory;
directory:	PATHELEMENT ( '/' PATHELEMENT )*;
filename:	PATHELEMENT '.' FILEEXT;
**/

// Markup
markup:			designator arguments?;
designator:		IDCON attribute*;
attribute:		'#' IDCON | 
			'.' IDCON | 
			'$' IDCON | 
			':' IDCON | 
			'@' NATCON | 
			'@' NATCON '%' NATCON;
arguments:		('(' argument? ( ',' argument  )* ')');
argument:		expression;

// Expression
expression:		IDCON | NATCON | SYMBOLCON;	// TODO: Priorities etc

// Statement
statement:		'if' '(' predicate ')' statement ('else' statement)? | 
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
			IDCON formals statement; // Function binding
			
// Predicate
predicate:		expression | expression '.' type | '!' predicate ; 
			//( predicate '||' predicate ) | ( predicate '&&' predicate );
type:			LIST | RECORD | STRING;	
			
// Embedding
embedding:		pretext embed texttail;	
embed:			markup* expression |
			markup* markup;
texttail:		posttext | midtext embed texttail;
pretext:		'"' TEXTCHAR* '<';
posttext:		'>' TEXTCHAR* '"';
midtext:		'>' TEXTCHAR* '<';

/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/
fragment LETTER:	'a'..'z' | 'A'..'Z';
fragment NUMBER:	'0'..'9';
fragment HEXADECIMAL:	( 'a'..'f' | 'A'..'F' | NUMBER )+;

NATCON:			NUMBER+;
IDCON:			LETTER (LETTER | NUMBER)*;
 
// Text
TEXT:			'"' TEXTCHAR* '"';
fragment TEXTCHAR:	'\"' | // Quote
			'\\' | // Slash
			'\&' ~('#' | '0'..'9' | 'a'..'z' | 'A'..'Z' | '_' | ':') | // Amp
			'&#' ('0'..'9')+ ';' | // Text character reference
			'&#x' ('0'..'9' | 'a'..'f' | 'A'..'F')+ ';' | // Text character reference
			'&' ('a'..'z' | 'A'..'Z' | '_' | ':') ('a'..'z' | 'A'..'Z' | '0'..'9' | '.' | '-' | '_' | ':')* ';' ; // Text entity reference

// String
STRCON:			'\"' STRCHAR '\"';
fragment STRCHAR:	'\\n' | '\\t' | '\\\\"' | '\\\\\\\\' |
			'\\' 'a' ('0'..'9') 'b' ('0'..'9') 'c' ('0'..'9') | // Decimal
			~('\n' | '\t' | '"' | '\\'); // TODO: !0..31	

// Symbol
SYMBOLCON:		'\'' SYMBOLCHAR*;
fragment SYMBOLCHAR:	~( ' ' | '\t' | '\n' | '\r' | ';' | ',' | '>' | '}' | ')'); // TODO: !0..31

COMMENTS:		'//' .* '\n' | '/*' .* '*/' { $channel = HIDDEN; };
LAYOUT: 		( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ { $channel = HIDDEN; };
