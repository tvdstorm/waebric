grammar WaebricVanilla ;

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
	import org.cwi.waebric.parser.ast.statement.predicate.*;
	import org.cwi.waebric.parser.ast.statement.embedding.*;
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
	'module' id=moduleId { $result.setIdentifier(id.result); } 
	( 	
		i=imprt { $result.addImport(i.result); } |
		s=site { $result.addSite(s.result); } |
		f=function { $result.addFunctionDef(f.result); }
	)* 
	'end' ;
	
moduleId returns [ModuleId result = new ModuleId()] :
	id=idcon { $result.add(id.result); }
	( '.' id=idcon { $result.add(id.result); } )* ;

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
	id=idcon atts=attributes { $result = new Designator(id.result, atts.result); } ;
	
attributes returns [Attributes result = new Attributes()] :
	( att=attribute { $result.add(att.result); } )*;
	
attribute returns [Attribute result] :
	'#' id=idcon { $result = new Attribute.IdAttribute(id.result); } | 
	'.' id=idcon { $result = new Attribute.ClassAttribute(id.result); } | 
	'$' id=idcon { $result = new Attribute.NameAttribute(id.result); } | 
	':' id=idcon { $result = new Attribute.TypeAttribute(id.result); } | 
	'@' w=natcon { $result = new Attribute.WidthAttribute(w.result); } | 
	'@' w=natcon '%' h=natcon { $result = new Attribute.WidthHeightAttribute(w.result, h.result); } ;
	
arguments returns [Arguments result = new Arguments()] :
	'(' ( arg=argument { $result.add(arg.result); } )? ( ',' arg=argument { $result.add(arg.result); } )* ')' ;

argument returns [Argument result] :
	e=expression { $result = new Argument.RegularArgument(e.result); } | 
	id=idcon '=' e=expression { $result = new Argument.Attr(id.result, e.result); } ;

// language.waebric.expression
expression returns [Expression result] :		
	(
		// Non-recursive expressions
		i=idExpression { $result = i.result; } | 
		n=natExpression { $result = n.result; } |
		s=symbolExpression { $result = s.result; } | 
		t=textExpression { $result = t.result; } |
		l=listExpression { $result = l.result; } | 
		r=recordExpression { $result = r.result; }
	)
	
	(
		// Recursive expressions (see: left-recurssion removal)
		'.' id=idcon { $result = new Expression.Field($result, id.result); } | 
		'+' e=expression { $result = new Expression.CatExpression($result, e.result); }
	)* ;

idExpression returns [Expression.VarExpression result] :
	id=idcon { $result = new Expression.VarExpression(id.result); } ;

natExpression returns [Expression.NatExpression result] :
	n=natcon { $result = new Expression.NatExpression(n.result); } ;
	
symbolExpression returns [Expression.SymbolExpression result] :
	s=symbolcon { $result = new Expression.SymbolExpression(s.result); } ;
	
textExpression returns [Expression.TextExpression result] :
	t=text { $result = new Expression.TextExpression(t.result); } ;

listExpression returns [Expression.ListExpression result = new Expression.ListExpression()] :			
	'[' ( e=expression { $result.addExpression(e.result); } )? 
	( ',' e=expression { $result.addExpression(e.result); } )* ']' ;
	
recordExpression returns [Expression.RecordExpression result = new Expression.RecordExpression()] :			
	'{' ( p=keyvaluepair { $result.addKeyValuePair(p.result); } )? 
	( ',' p=keyvaluepair { $result.addKeyValuePair(p.result); } )* '}' ;
	
keyvaluepair returns [KeyValuePair result = new KeyValuePair()] :
	id=idcon { $result.setIdentifier(id.result); } 
	':' e=expression { $result.setExpression(e.result); } ;

// language.waebric.function
function returns [FunctionDef result = new FunctionDef()] :		
	'def' id=idcon { $result.setIdentifier(id.result); } 
	f=formals { $result.setFormals(f.result); }
	( s=statement { $result.addStatement(s.result); } )* 'end';

formals returns [Formals result] :
	r=regularFormal { $result=r.result; } | e=emptyFormal { $result=e.result; } ;
	
regularFormal returns [Formals.RegularFormal result = new Formals.RegularFormal()] :
	'(' ( id=idcon { $result.addIdentifier(id.result); } )? 
	( ',' id=idcon { $result.addIdentifier(id.result); } )* ')';
	
emptyFormal returns [Formals.EmptyFormal result = new Formals.EmptyFormal()]: ;

// language.waebric.statement
statement returns [Statement result] :
			s=ifElseStatement { $result = s.result; } | 
			s=ifStatement { $result = s.result; } |
			s=eachStatement { $result = s.result; } | 
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
			
ifElseStatement returns [Statement.IfElse result = new Statement.IfElse()] :	
	'if' '(' p=predicate ')' { $result.setPredicate(p.result); }
	t=statement { $result.setTrueStatement(t.result); }
	'else' f=statement { $result.setFalseStatement(f.result); } ;

ifStatement returns [Statement.If result = new Statement.If()] :
	'if' '(' p=predicate ')' { $result.setPredicate(p.result); }
	t=statement { $result.setTrueStatement(t.result); } ;
	
eachStatement returns [Statement.Each result = new Statement.Each()] :
	'each' '(' id=idcon ':' { $result.setVar(id.result); }
	e=expression ')' { $result.setExpression(e.result); }
	s=statement { $result.setStatement(s.result); } ;
			
assignment returns [Assignment result] :	
	a=varBind { $result = a.result; } |
	a=funcBind { $result = a.result; } ;
	
varBind returns [Assignment.VarBind result = new Assignment.VarBind();] :
	id=idcon '=' e=expression ';' {
		$result.setIdentifier(id.result);
		$result.setExpression(e.result);
	} ;
	
funcBind returns [Assignment.FuncBind result = new Assignment.FuncBind();] :
	id=idcon f=regularFormal s=statement {
		$result.setIdentifier(id.result);
		$result.setFormals(f.result);
		$result.setStatement(s.result);
	};

// language.waebric.statement.predicate
predicate returns [Predicate result] :
	( 
		// Non-recursive predicates
		d=declared { $result = d.result; } | 
		n=not { $result = n.result; } |
		i=is { $result = i.result; }
	)	
		
		
	( 
		// Recursive predicates (see: left-recurssion removal)
		'&&' p=predicate { $result = new Predicate.And($result, p.result); } | 
		'||' p=predicate { $result = new Predicate.Or($result, p.result); }
	)* ;
	
declared returns [Predicate.Declared result = new Predicate.Declared()] :
	e=expression { $result.setExpression(e.result); } ;
	
not returns [Predicate.Not result = new Predicate.Not()] :
	'!' p=predicate { $result.setPredicate(p.result); } ;	
		
is returns [Predicate.Is result = new Predicate.Is()] :
	e=expression '.' t=type { 
		$result.setExpression(e.result);
		$result.setType(t.result);
	} ;
	
type returns [Type result] :
	'list' { $result = new Type.ListType(); } | 
	'record' { $result = new Type.RecordType(); } | 
	'string' { $result = new Type.StringType(); } ;

// language.waebric.statement.embedding
embedding returns [Embedding result = new Embedding();] :
	p=PRETEXT e=embed t=texttail {
		$result.setPreText(new PreText($p.getText().substring(1, $p.getText().length()-1)));
		$result.setEmbed(e.result);
		$result.setTextTail(t.result);
	};	
	
embed returns [Embed result] :
	e=expressionEmbed { $result = e.result; } |
	m=markupEmbed { $result = m.result; } ;

expressionEmbed returns [Embed.ExpressionEmbed result = new Embed.ExpressionEmbed();] :
	( m=markup { $result.addMarkup(m.result); } )* 
	e=expression { $result.setExpression(e.result); } ;
	
markupEmbed returns [Embed.MarkupEmbed result = new Embed.MarkupEmbed();] :
	( m=markup { $result.addMarkup(m.result); } )* 
	m=expression { $result.setMarkup(m.result); } ;
			
texttail: ;
			
postTail returns [TextTail.PostTail] :	
	p=POSTTEXT { $result.setPostText(new PostText($p.getText().substring(1, $p.getText().length()-1))); } ;

midTail returns [TextTail.MidTail] :
	m=MIDTEXT e=embed t=texttail {
		$result.setMidText(new MidText($p.getText().substring(1, $p.getText().length()-1)));
		$result.setEmbed(e.result);
		$result.setTextTail(t.result);
	} ;

// language.waebric.basic
idcon returns [IdCon result]:	
	id=IDCON { $result = new IdCon(id.getText(), id.getLine(), id.getCharPositionInLine()); } ;
	
natcon returns [NatCon result]:	
	n=NATCON { $result = new NatCon(n.getText()); } ;

symbolcon returns [SymbolCon result] :	
	s=SYMBOLCON { $result = new SymbolCon(s.getText().substring(1)); } ;

text returns [Text result] :
	t=TEXT { $result = new Text(t.getText()); } ;

string returns [StrCon result] :
	s=STRCON { $result = new StrCon(s.getText()); } ;	
			
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
