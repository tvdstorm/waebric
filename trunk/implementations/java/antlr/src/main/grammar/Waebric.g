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

/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/
TYPE:			'string' | 'list' | 'record';

IDCON:			('a'..'z' | 'A'..'Z') ('a'..'z' | 'A'..'Z' | '0'..'9')*;
NATCON:			'0'..'9'+;

//FILEEXT:		('a'..'z' | 'A'..'Z' | '0'..'9') ('a'..'z' | 'A'..'Z' | '0'..'9')*;
//PATHELEMENT:		~(' '|'\t'|'\n'|'\r'|'.'|'/'|'\\')+;

WHITESPACE: 		( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ { $channel = HIDDEN; };
