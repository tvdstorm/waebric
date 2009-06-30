lexer grammar WaebricLexer;

@header {
	package org.cwi.waebric;
}

/**
MODULE:			'module' ;
IMPORT:			'import' ;
SITE:			'site' ;
DEF:			'def' ;
END:			'end' ;

IF:			'if' ;
ELSE:			'else' ;
EACH:			'each' ;
LET:			'let' ;
IN:			'in' ;
COMMENT:		'comment' ;
ECHO:			'echo' ;
CDATA:			'cdata' ;
YIELD:			'yield' ;

LIST:			'list' ;
RECORD:			'record' ;
STRING:			'string' ;
**/

fragment LETTER:	'a'..'z' | 'A'..'Z' ;
fragment DIGIT:		'0'..'9' ;
fragment HEXADECIMAL:	( 'a'..'f' | 'A'..'F' | DIGIT )+ ;

SYMBOLCON:		'\'' SYMBOLCHAR* ;
fragment SYMBOLCHAR:	~( '\u0000'..'\u001F' | ' ' | ';' | ',' | '>' | '}' | ')') ;

TEXT: 			( '"' TEXTCHAR* '"' )? ;
fragment TEXTCHAR: 	~( '\u0000'..'\u001F' | '&' | '"' | '\u0080'..'\uFFFF' ) |
			'\n' | '\r' | '\t' | AMP | CHARREF | ENTREF | ESCQUOTE ;
fragment ESCQUOTE:	'\\\\' | '\\\"' ;		
fragment AMP:		'\&' ~('#' | '0'..'9' | 'a'..'z' | 'A'..'Z' | '_' | ':')+ ;
fragment CHARREF:	'&#' DIGIT+ ';' | '&#x' HEXADECIMAL ';' ;
fragment ENTREF:	'&' ( LETTER | '_' | ':' ) ( LETTER | DIGIT | '.' | '-' | '_' | ':')* ';' ;

STRCON:			'comment' LAYOUT '\"' STRCHAR* '\"' LAYOUT? ';' ;
fragment STRCHAR:	~( '\u0000'..'\u001F' | '"' | '\\' ) | ESCLAYOUT | DECIMAL ;
fragment ESCLAYOUT:	'\\\\n' | '\\\\t' | '\\\\"' | '\\\\\\\\' ;
fragment DECIMAL:	'\\\\' 'a:' DIGIT 'b:' DIGIT 'c:' DIGIT ;

NATCON:			DIGIT+ ;
IDCON:			LETTER ( LETTER | DIGIT | '-' )+ ;

COMMENTS:		'//' .* '\n' | '/*' .* '*/' { $channel = HIDDEN; } ;
LAYOUT: 		( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ { $channel = HIDDEN; } ;
