grammar Waebric ;

options {
	backtrack = true ;
	output = AST ;
}

@parser::header {
	package org.cwi.waebric;
	
	import org.cwi.waebric.parser.ast.basic.*;
	import org.cwi.waebric.parser.ast.module.*;
	import org.cwi.waebric.parser.ast.module.site.*;
	import org.cwi.waebric.parser.ast.module.function.*;
	import org.cwi.waebric.parser.ast.markup.*;
	import org.cwi.waebric.parser.ast.expression.*;
	import org.cwi.waebric.parser.ast.statement.*;
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

// language.waebric.module
module returns [Module result = new Module()] : 		
	'module' id=moduleId { $result.setIdentifier(id.result); } ( 	
		i=imprt { $result.addImport(i.result); } |
		s=site { $result.addSite(s.result); } |
		f=function { $result.addFunctionDef(f.result); }
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
	( 
		id=IDCON { $result = new Expression.VarExpression(new IdCon(id.getText())); } | 
		n=NATCON { $result = new Expression.NatExpression(new NatCon(n.getText())); } | 
		t=TEXT { $result = new Expression.TextExpression(new Text(t.getText())); } | 
		s=SYMBOLCON { $result = new Expression.SymbolExpression(new SymbolCon(s.getText().substring(1))); } | 
		l=list { $result = l.result; } | 
		r=record { $result = r.result; }
	)
	
	(
		'.' id=IDCON { $result = new Expression.Field($result, new IdCon(id.getText())); } | 
		'+' e=expression { $result = new Expression.CatExpression($result, e.result); }
	)* ;
	
list returns [Expression.ListExpression result = new Expression.ListExpression()] :			
	'[' ( e=expression { $result.addExpression(e.result); } )? 
	( ',' e=expression { $result.addExpression(e.result); } )* ']' ;
	
record returns [Expression.RecordExpression result = new Expression.RecordExpression()] :			
	'{' ( p=keyvaluepair { $result.addKeyValuePair(p.result); } )? 
	( ',' p=keyvaluepair { $result.addKeyValuePair(p.result); } )* '}' ;
	
keyvaluepair returns [KeyValuePair result = new KeyValuePair()] :
	id=IDCON { $result.setIdentifier(new IdCon(id.getText())); } 
	':' e=expression { $result.setExpression(e.result); } ;

// Function
function returns [FunctionDef result = new FunctionDef()] :		
	'def' id=IDCON { $result.setIdentifier(new IdCon(id.getText())); } 
	f=formals { $result.setFormals(f.result); }
	( s=statement { $result.addStatement(s.result); } )* 'end';

formals returns [Formals result] :
	r=regularFormal { $result=r.result; } | e=emptyFormal { $result=e.result; } ;
	
regularFormal returns [Formals.RegularFormal result = new Formals.RegularFormal()] :
	'(' ( id=IDCON { $result.addIdentifier(new IdCon(id.getText())); } )? 
	( ',' id=IDCON { $result.addIdentifier(new IdCon(id.getText())); } )* ')';
	
emptyFormal returns [Formals.EmptyFormal result = new Formals.EmptyFormal()]: ;

statement returns [Statement result = null]: // TODO
			'if' '(' predicate ')' statement 'else' statement | 
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
MODULE:			'module' ;
IMPORT:			'import' ;
SITE:			'site' { inSite = true; inPath = true; } ; // Site init
DEF:			'def' ;
END:			'end' { inSite = false; inPath = false; } ; // Site kill

IF:			'if' ;
ELSE:			'else' ;
EACH:			'each' ;
LET:			'let' ;
ECHO:			'echo' ;
CDATA:			'cdata' ;
IN:			'in' ;
YIELD:			'yield' ;
COMMENT	:		'comment' { inString = true; } ;

LIST:			'list' ;
RECORD:			'record' ;
STRING:			'string' ;

SEMICOLON:		';' { inPath = inSite; } ; // Mapping separator
 
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
