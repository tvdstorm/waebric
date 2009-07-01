grammar Waebric ;

options {
	backtrack = true ;
	output = AST ;
}

tokens {
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
	
	LPAREN = '(' ;
	RPAREN = ')' ;
	LBRACKET = '[' ;
	RBRACKET = ']' ;
	LCBRACKET = '{' ;
	RCBRACKET = '}' ;	
	LEMBED = '<' ;
	REMBED = '>' ;	
			
	PERIOD = '.' ;	
	COMMA = ',' ;	
	SEMICOLON = ';' ;
	COLON = ':' ;	
	HASH = '#' ;
	AT = '@' ;
	PERCENT = '%' ;
	DOLLAR = '$' ;	
	PLUS = '+' ;
	EQUALS = '=' ;	
	EQCLAMATION = '!' ;	
	DQUOTE = '"' ;
	AND = '&&' ;
	OR = '||' ;	
}

@parser::header {package org.cwi.waebric;}
@lexer::header {package org.cwi.waebric;}
@lexer::members {private boolean inSite = false;}

// Parser rules
module returns [String result="lol "]
	: 		'module' 
			id=moduleId { $result += id.toString(); } 
			( e=moduleElement { $result += e.toString(); } )* 
			'end' ;
	
moduleId:		IDCON ( '.' IDCON )* ;
moduleElement:		imprt | site | function ;
imprt:			'import' moduleId ';' ;

site:			'site' mappings 'end' ;
mappings:		mapping? ( ';' mapping )* ;
mapping	:		PATH ':' markup ;

markup:			designator arguments | designator ;
designator:		IDCON attribute* ;
attribute:		'#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | 
			'@' NATCON | '@' NATCON '%' NATCON;
arguments:		'(' argument? ( ',' argument )* ')' ;
argument:		expression ;

expression:		( IDCON | NATCON | TEXT | SYMBOLCON | list | record ) ( '.' IDCON | '+' expression )* ;
list:			'[' expression? ( ',' expression )* ']' ;
record:			'{' keyvaluepair? ( ',' keyvaluepair )* '}' ;	
keyvaluepair:		IDCON ':' expression ;

function:		'def' IDCON formals statement* 'end';
formals:		'(' IDCON? ( ',' IDCON )* ')' | ;

statement:		'if' '(' predicate ')' statement 'else' statement | 
			'if' '(' predicate ')' statement |
			'each' '(' IDCON ':' expression ')' statement | 
			'let' assignment+ 'in' statement* 'end' |
			'{' statement* '}' |
			STRCON ';' |
			'echo' expression ';' |
			'echo' embedding ';' |
			'cdata' expression ';' | 
			'yield;' |
			markup ';' |
			markup+ statement ';' |
			markup+ markup ';' |
			markup+ expression ';' ;	
assignment:		IDCON '=' expression ';' | // Variable binding
			IDCON formals statement ; // Function binding

predicate:		( expression | not | is ) ( '&&' predicate | '||' predicate )*;
not:			'!' predicate ;		
is:			expression '.' type ;
type:			'list' | 'record' | 'string' ;

embedding:		PRETEXT embed texttail ;	
embed:			markup* expression |
			markup* markup ;
texttail:		POSTTEXT | MIDTEXT embed texttail ;

// Lexical rules
SITE:			'site' { inSite = true; } ;
END:			'end' { inSite = false; } ;	

fragment LETTER:	'a'..'z' | 'A'..'Z' ;
fragment DIGIT:		'0'..'9' ;
fragment HEXADECIMAL:	( 'a'..'f' | 'A'..'F' | DIGIT )+ ;

PATH:			( { inSite }? => ( ( PATHELEMENT '/' )* PATHELEMENT '.' FILEEXT ) ) ; 
fragment PATHELEMENT:	( LETTER | DIGIT )+ ; // ~( ' ' | '\t' | '\n' | '\r' | '.' | '/' | '\\' )+ ; Causes java heap exception
fragment FILEEXT:	( LETTER | DIGIT )+ ;

PRETEXT:		'"' TEXTCHAR* '<' ;
POSTTEXT:		'>' TEXTCHAR* '"' ;
MIDTEXT:		'>' TEXTCHAR* '<' ;				

TEXT:			'\"' TEXTCHAR* '\"' ;
fragment TEXTCHAR:	~( '\u0000'..'\u001F' | '&' | '"' | '<' | '\u0080'..'\uFFFF' ) |
			 '\n' | '\r' | '\t' | ESCQUOTE | AMP | CHARREF | ENTREF ;
fragment ESCQUOTE:	'\\\\' | '\\"' ;		
fragment AMP:		'\&' ~('#' | '0'..'9' | 'a'..'z' | 'A'..'Z' | '_' | ':')+ ;
fragment CHARREF:	'&#' DIGIT+ ';' | '&#x' HEXADECIMAL ';' ;
fragment ENTREF:	'&' ( LETTER | '_' | ':' ) ( LETTER | DIGIT | '.' | '-' | '_' | ':')* ';' ;

SYMBOLCON:		'\'' SYMBOLCHAR* ;
fragment SYMBOLCHAR:	~( '\u0000'..'\u001F' | ' ' | ';' | ',' | '>' | '}' | ')') ;

STRCON:			'comment' LAYOUT '\"' STRCHAR* '\"' ;
fragment STRCHAR:	~( '\u0000'..'\u001F' | '"' | '\\' ) | ESCLAYOUT | DECIMAL ;
fragment ESCLAYOUT:	'\\\\n' | '\\\\t' | '\\\\"' | '\\\\\\\\' ;
fragment DECIMAL:	'\\\\' 'a:' DIGIT 'b:' DIGIT 'c:' DIGIT ;

NATCON:			DIGIT+ ;
IDCON:			LETTER ( LETTER | DIGIT | '-' )+ ;

COMMENTS:		'//' .* '\n' | '/*' .* '*/' { $channel = HIDDEN; } ;
LAYOUT: 		( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ { $channel = HIDDEN; } ;