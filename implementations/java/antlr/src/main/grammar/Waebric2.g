grammar Waebric2;

options {
	output = AST;
}

module: 		'module' moduleId ( imprt | site | function )* EOF ;
moduleId:		IDCON ( '.' IDCON ) ;

imprt:			'import' moduleId ;

site:			'site' mappings 'end' ;
mappings:		mapping? ( ';' mapping )* ;
mapping	:		PATH ':' markup ;

function:		'def' IDCON formals? statement* 'end' ;
formals:		'(' IDCON? ( ',' IDCON )* ')' ;

markup:			IDCON attributes arguments? ;
attributes:		attribute* ;
attribute:		'#' IDCON // ID attribute
			| '.' IDCON // Class attribute
			| '$' IDCON // Name attribute
			| ':' IDCON // Type attribute
			| '@' NATCON // Width attribute
			| '@' NATCON '%' NATCON // Width-height attribute
			;

arguments:		'(' argument? ( ',' argument )* ')' ;
argument:		expression 
			| IDCON '=' expression 
			;
			
expression:		IDCON 
			| '[' expression? ( ',' expression ']' )*
			;

statement:		'if' '(' predicate ')' statement ( 'else' statement )?
			| 'each' '(' IDCON ':' expression ')' statement 
			| 'let' assignment+ 'in' statement* 'end'
			| '{' statement* '}'
			| 'yield;'
			| 'comment' STRCON ';'
			| 'echo' expression ';'
			| 'echo' embedding ';'
			| 'cdata' expression ';' 
			;
			
assignment:		IDCON '=' expression ';' // Variable binding
			| IDCON formals '=' statement // Function binding
			;
			
predicate:		'!'* expression ( '.' type '?' )?
			( '&&' predicate | '||' predicate )* ;
type:			'list' 
			| 'record' 
			| 'string' 
			;

embedding:		PRETEXT embed textTail ;
embed:			markup* expression ; // How to add markup+ ?
textTail:		POSTTEXT 
			| MIDTEXT embed textTail 
			;		

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
