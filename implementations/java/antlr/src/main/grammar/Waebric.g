grammar Waebric ;

options {
	backtrack = true ;
	output = AST ;
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

@parser::header {
	package org.cwi.waebric;
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

// Parser rules
module: 		'module' moduleId ( imprt | site | function )* 'end';
moduleId:		IDCON ( '.' IDCON )* ;
imprt:			'import' moduleId ';' ;

site:			'site' mappings 'end' ;
mappings:		mapping? ( ';' mapping )* ;
mapping	:		PATH ':' markup ;

markup:			designator arguments? ;
designator:		IDCON attribute* ;
attribute:		'#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | 
			'@' NATCON | '@' NATCON '%' NATCON;
arguments:		'(' argument? ( ',' argument )* ')' ;
argument:		expression ;

expression:		( idExpr | natExpr | textExpr | symbolExpr | listExpr | recordExpr ) 
			( '.' IDCON | '+' expression )* ; // Left-recusion removal
idExpr:			IDCON;	
natExpr:		NATCON;
textExpr:		TEXT;
symbolExpr:		SYMBOLCON;			
listExpr:		'[' expression? ( ',' expression )* ']' ;
recordExpr:		'{' keyvaluepair? ( ',' keyvaluepair )* '}' ;	
keyvaluepair:		IDCON ':' expression ;

function:		'def' IDCON formals statement* 'end';
formals:		'(' IDCON? ( ',' IDCON )* ')' | ;

statement:		ifElseStm | ifStm | eachStm | letStm | blockStm | 
			commentStm | echoStm | cdataStm | yieldStm | markupStm;	
ifStm:			'if' '(' predicate ')' statement ; // TODO: Look-ahead no else
ifElseStm:		'if' '(' predicate ')' statement 'else' statement ;	
eachStm:		'each' '(' IDCON ':' expression ')' statement ;	
letStm:			'let' assignment+ 'in' statement* 'end' ;
blockStm:		'{' statement* '}' ;
commentStm:		'comment' STRCON ';' ;
echoStm:		'echo' expression ';'  | 'echo' embedding ';' ;
cdataStm:		'cdata' expression ';' ;
yieldStm:		'yield;' ;
markupStm:		markup ';' | markup+ statement ';' | markup+ markup ';' | markup+ expression ';' ;
assignment:		IDCON '=' expression ';' | // Variable binding
			IDCON formals statement ; // Function binding

predicate:		( notPredicate | declaredPredicate | isPredicate ) 
			( '&&' predicate | '||' predicate )* ; // Left-recussion removal 
notPredicate:		'!' predicate ;	
declaredPredicate:	expression ; // Check expression declaration (not null)
isPredicate:		expression '.' type ; // Check expression type
type:			'list' | 'record' | 'string' ;

embedding:		PRETEXT embed texttail ;	
embed:			markup* expression | markup* markup ;
texttail:		POSTTEXT | MIDTEXT embed texttail ;

// Lexical rules
COMMENT	:		'comment' { inString = true; } ;
SITE:			'site' { inSite = true; inPath = true; } ; // Site constructor
END:			'end' { inSite = false; inPath = false; } ; // Site destructor
SEMICOLON:		';' { inPath = inSite; } ; // Mapping separator
 
fragment LETTER:	'a'..'z' | 'A'..'Z' ;
fragment DIGIT:		'0'..'9' ;
fragment HEXADECIMAL:	( 'a'..'f' | 'A'..'F' | DIGIT )+ ;

PATH:			( { inPath }? => ( ( PATHELEMENT '/' )* PATHELEMENT '.' FILEEXT ) { inPath = false; } ) ; 
fragment PATHELEMENT:	~( ' ' | '\t' | '\n' | '\r' | '.' | '/' | '\\' | '!'..'+' )+ ; // '!'..'+' causes java heap exception
fragment FILEEXT:	( LETTER | DIGIT )+ ;

STRCON:			( { inString }? => ( '\"' STRCHAR* '\"' ) { inString = false; } ) ;
fragment STRCHAR:	~( '\u0000'..'\u001F' | '"' | '\\' ) | ESCLAYOUT | DECIMAL ;
fragment ESCLAYOUT:	'\\\\n' | '\\\\t' | '\\\\"' | '\\\\\\\\' ;
fragment DECIMAL:	'\\\\' 'a:' DIGIT 'b:' DIGIT 'c:' DIGIT ;

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

NATCON:			DIGIT+ ;
IDCON:			LETTER ( LETTER | DIGIT | '-' )+ ;

COMMENTS:		'//' .* '\n' | '/*' .* '*/' { skip(); } ;
LAYOUT: 		( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ { skip(); } ;
