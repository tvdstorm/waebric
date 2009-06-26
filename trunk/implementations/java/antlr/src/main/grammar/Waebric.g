grammar Waebric;

options {
	backtrack=true;
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

// Module
module:	 		'module' moduleId moduleElement* 'end';
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
expression:		IDCON | NATCON;	// TODO: Priorities etc

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
predicate:		expression | expression '.' TYPE | '!' predicate ; 
			//( predicate '||' predicate ) | ( predicate '&&' predicate );
			
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
TYPE:			'string' | 'list' | 'record';

// Text
TEXT:			'"' TEXTCHAR* '"';
TEXTCHAR:		'\"' | // Quote
			'\\' | // Slash
			'\&' ~('#' | '0'..'9' | 'a'..'z' | 'A'..'Z' | '_' | ':') | // Amp
			'&#' ('0'..'9')+ ';' | // Text character reference
			'&#x' ('0'..'9' | 'a'..'f' | 'A'..'F')+ ';' | // Text character reference
			'&' ('a'..'z' | 'A'..'Z' | '_' | ':') ('a'..'z' | 'A'..'Z' | '0'..'9' | '.' | '-' | '_' | ':')* ';' ; // Text entity reference

// String
STRCON:			'"' STRCHAR '"';
STRCHAR:		'\\n' | '\\t' | '\\\\"' | '\\\\\\\\' |
			'\\' 'a' ('0'..'9') 'b' ('0'..'9') 'c' ('0'..'9');// | // Decimal
			//~('\n' | '\t' | '"' | '\\'); // TODO: !0..31	

// Symbol
SYMBOLCON:		'\'' SYMBOLCHAR*;
SYMBOLCHAR:		~( ' ' | '\t' | '\n' | '\r' | ';' | ',' | '>' | '}' | ')'); // TODO: !0..31

// Basic
NATCON:			'0'..'9'+;
IDCON:			('a'..'z' | 'A'..'Z') ('a'..'z' | 'A'..'Z' | '0'..'9')*;

//FILEEXT:		('a'..'z' | 'A'..'Z' | '0'..'9') ('a'..'z' | 'A'..'Z' | '0'..'9')*;
//PATHELEMENT:		~(' '|'\t'|'\n'|'\r'|'.'|'/'|'\\')+;

WHITESPACE: 		( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ { $channel = HIDDEN; };
