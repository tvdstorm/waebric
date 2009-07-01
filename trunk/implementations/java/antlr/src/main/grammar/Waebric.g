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

@parser::header {
	package org.cwi.waebric;
	
	import org.cwi.waebric.parser.ast.basic.*;
	import org.cwi.waebric.parser.ast.module.*;
	import org.cwi.waebric.parser.ast.module.site.*;
	import org.cwi.waebric.parser.ast.module.function.*;
	import org.cwi.waebric.parser.ast.markup.*;
	import org.cwi.waebric.parser.ast.expression.*;
}

@lexer::header {
	package org.cwi.waebric;
}

@lexer::members {
	// Differentiate between idcon and path
	private boolean inSite = false;
	private boolean inPath = false;
	
	// Differentiate between text and string
	private boolean inString = false;
}

// language.waebric.module
module returns [Module result = new Module()] : 		
	'module' id=moduleId { $result.setIdentifier(id.result); } ( 	
		i=imprt { $result.addImport(i.result); } |
		s=site { $result.addSite(s.result); } |
		f=function {  }
	)* 'end' ;
	
moduleId returns [ModuleId result = new ModuleId()] :
	id = IDCON { $result.add(new IdCon(id.getText())); }
	( '.' id=IDCON { $result.add(new IdCon(id.getText())); } )* ;

imprt returns [Import result = new Import()] :
	'import' id=moduleId ';' { $result.setIdentifier(id.result); } ;

// language.waebric.site
site returns [Site result = new Site()]:
	'site' m=mappings 'end' { $result.setMappings(m.result); } ;

mappings returns [Mappings result = new Mappings()] :
	( m=mapping { $result.add(m.result); } )? ( ';' m=mapping { $result.add(m.result); } )* ;

mapping	returns [Mapping result = new Mapping()] :
	p=PATH { $result.setPath(new Path(p.getText())); } 
	':' m=markup { $result.setMarkup(m.result); } ;

// language.waebric.markup
markup returns [Markup result] :
	d=designator args=arguments { $result = new Markup.Call(d.result, args.result); } | 
	d=designator { $result = new Markup.Tag(d.result); } ;
	
designator returns [Designator result] :
	id=IDCON atts=attributes { $result = new Designator(new IdCon(id.getText()), atts.result); } ;
	
attributes returns [Attributes result = new Attributes()] :
	( att=attribute { $result.add(att.result); } )*;
	
attribute returns [Attribute result] :
	'#' id=IDCON { $result = new Attribute.IdAttribute(new IdCon(id.getText())); } | 
	'.' id=IDCON { $result = new Attribute.ClassAttribute(new IdCon(id.getText())); } | 
	'$' id=IDCON { $result = new Attribute.NameAttribute(new IdCon(id.getText())); } | 
	':' id=IDCON { $result = new Attribute.TypeAttribute(new IdCon(id.getText())); } | 
	'@' w=NATCON { $result = new Attribute.WidthAttribute(new NatCon(w.getText())); } | 
	'@' w=NATCON '%' h=NATCON { $result = new Attribute.WidthHeightAttribute(new NatCon(w.getText()), new NatCon(h.getText())); } ;
	
arguments returns [Arguments result = new Arguments()] :
	'(' ( arg=argument { $result.add(arg.result); } )? ( ',' arg=argument { $result.add(arg.result); } )* ')' ;

argument returns [Argument result] :
	e=expression { $result = new Argument.RegularArgument(e.result); } | 
	id=IDCON '=' e=expression { $result = new Argument.Attr(new IdCon(id.getText()), e.result); } ;

// language.waebric.expression
expression returns [Expression result = null] :		
	( IDCON | NATCON | TEXT | SYMBOLCON | list | record ) ( '.' IDCON | '+' expression )* ;
	
list:			'[' expression? ( ',' expression )* ']' ;
record:			'{' keyvaluepair? ( ',' keyvaluepair )* '}' ;	
keyvaluepair:		IDCON ':' expression ;


// Function
function:		'def' IDCON formals statement* 'end';
formals:		'(' IDCON? ( ',' IDCON )* ')' | ;

statement:		'if' '(' predicate ')' statement 'else' statement | 
			'if' '(' predicate ')' statement |
			'each' '(' IDCON ':' expression ')' statement | 
			'let' assignment+ 'in' statement* 'end' |
			'{' statement* '}' |
			'comment' STRCON ';' |
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

/**
 * Lexer rules
 */
 
COMMENT	:		'comment' { inString = true; } ;
SITE:			'site' { inSite = true; inPath = true; } ;
END:			'end' { inSite = false; inPath = false; } ;
SEMICOLON:		';' { inPath = inSite; } ;			

fragment LETTER:	'a'..'z' | 'A'..'Z' ;
fragment DIGIT:		'0'..'9' ;
fragment HEXADECIMAL:	( 'a'..'f' | 'A'..'F' | DIGIT )+ ;

PATH:			( { inPath }? => ( ( PATHELEMENT '/' )* PATHELEMENT '.' FILEEXT ) { inPath = false; } ) ; 
fragment PATHELEMENT:	( LETTER | DIGIT )+ ; // ~( ' ' | '\t' | '\n' | '\r' | '.' | '/' | '\\' )+ ; Causes java heap exception
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

COMMENTS:		'//' .* '\n' | '/*' .* '*/' { $channel = HIDDEN; } ;
LAYOUT: 		( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ { $channel = HIDDEN; } ;
