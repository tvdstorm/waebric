lexer grammar WaebricLexer;

@header {
	package org.cwi.waebric;
}

MODULE:			'module' ;
IMPORT:			'import' ;
SITE:			'site' ;
DEF:			'def' ;
END:			'end' ;

IF:			'if' ;
ELSE:			'else' ;
EACH:			'each' ;
LET:			'let' ;
ECHO:			'echo' ;
CDATA:			'cdata' ;
IN:			'in' ;
YIELD:			'yield' ;								

LPAREN:			'(' ;
RPAREN:			')' ;
LBRACKET:		'[' ;
RBRACKET:		']' ;
LCBRACKET:		'{' ;
RCBRACKET:		'}' ;	
LEMBED:			'<' ;
REMBED:			'>' ;			

PERIOD:			'.' ;	
COMMA:			',' ;	
SEMICOLON:		';' ;
COLON:			':' ;	
HASH:			'#' ;
AT:			'@' ;
PERCENT	:		'%' ;
DOLLAR:			'$' ;	
PLUS:			'+' ;
EQUALS:			'=' ;	
EQCLAMATION:		'!' ;	
DQUOTE:			'"' ;

AND:			'&&' ;
OR:			'||' ;					

fragment LETTER:	'a'..'z' | 'A'..'Z' ;
fragment DIGIT:		'0'..'9' ;
fragment HEXADECIMAL:	( 'a'..'f' | 'A'..'F' | DIGIT )+ ;

PATH:			( PATHELEMENT '/' )* PATHELEMENT '.' FILEEXT ;
fragment PATHELEMENT:	( LETTER | DIGIT )+ ; // ~( ' ' | '\t' | '\n' | '\r' | '.' | '/' | '\\' )+ ; // Causes java heap exception
fragment FILEEXT:	( LETTER | DIGIT )+ ;

NATCON:			DIGIT+ ;
IDCON:			LETTER ( LETTER | DIGIT | '-' )+ ;

SYMBOLCON:		'\'' SYMBOLCHAR* ;
fragment SYMBOLCHAR:	~( '\u0000'..'\u001F' | ' ' | ';' | ',' | '>' | '}' | ')') ;

TEXT:			'\"' TEXTCHAR* '\"' ;
fragment TEXTCHAR:	~( '\u0000'..'\u001F' | '&' | '"' | '\u0080'..'\uFFFF' ) |
			 '\n' | '\r' | '\t' | ESCQUOTE | AMP | CHARREF | ENTREF ;
fragment ESCQUOTE:	'\\\\' | '\\"' ;		
fragment AMP:		'\&' ~('#' | '0'..'9' | 'a'..'z' | 'A'..'Z' | '_' | ':')+ ;
fragment CHARREF:	'&#' DIGIT+ ';' | '&#x' HEXADECIMAL ';' ;
fragment ENTREF:	'&' ( LETTER | '_' | ':' ) ( LETTER | DIGIT | '.' | '-' | '_' | ':')* ';' ;

STRCON:			'comment' LAYOUT '\"' STRCHAR* '\"' ;
fragment STRCHAR:	~( '\u0000'..'\u001F' | '"' | '\\' ) | ESCLAYOUT | DECIMAL ;
fragment ESCLAYOUT:	'\\\\n' | '\\\\t' | '\\\\"' | '\\\\\\\\' ;
fragment DECIMAL:	'\\\\' 'a:' DIGIT 'b:' DIGIT 'c:' DIGIT ;

COMMENTS:		'//' .* '\n' | '/*' .* '*/' { $channel = HIDDEN; } ;
LAYOUT: 		( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ { $channel = HIDDEN; } ;
