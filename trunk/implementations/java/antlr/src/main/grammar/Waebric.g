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
	import java.util.ArrayList;
}

@parser::members {
	private CommonTree parseFile(String path) throws RecognitionException {
		try {
			CharStream is = new ANTLRFileStream(path);
			WaebricLexer lexer = new WaebricLexer(is);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
      			WaebricParser parser = new WaebricParser(tokens);
      			return (CommonTree) parser.module().getTree();
      		} catch(java.io.IOException e) { return new CommonTree(); }
	}
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

// $<Module
module: 		'module' moduleId ( imprt | site | function )* 'end'
				-> ^( 'module' moduleId imprt* site* function* 'end' ) ;

moduleId 
	returns [String path = ""] // Determine physical path of module identifier
	@after { $path += ".wae"; } // Each reference ends with waebric extension
	:		e=IDCON { $path += e.getText(); } 
			( '.' e=IDCON { $path += "/" + e.getText(); } )*
				-> IDCON ( '.' IDCON )* ;
	
imprt:			'import' id=moduleId ';' 
				-> ^( 'import' moduleId ';' ^( { parseFile($id.path) } ) ) ;

// $>
// $<Site

site:			'site' mappings 'end'
				-> ^( 'site' mappings 'end' ) ;
				
mappings:		mapping? ( ';' mapping )* ;
mapping	:		PATH ':' markup ;

// $>
// $<Markup

markup:			designator arguments? ;
designator:		IDCON attribute* ;
attribute:		'#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | 
			'@' NATCON | '@' NATCON '%' NATCON;
arguments:		'(' argument? ( ',' argument )* ')' ;
argument:		expression ;

// $>
// $<Expressions

expression:		( varExpression | natExpression | textExpression | symbolExpression | listExpression | recordExpression )
			( '+' expression /* Cat expression */ | '.' IDCON /* Field expression */ )* ;
varExpression:		IDCON ;
natExpression:		NATCON ;
textExpression:		TEXT ;
symbolExpression:	SYMBOLCON ;			
listExpression:		'[' expression? ( ',' expression )* ']' ;
recordExpression:	'{' keyValuePair? ( ',' keyValuePair )* '}' ;
keyValuePair:		IDCON ':' expression ;

// $>
// $<Function

function:		'def' IDCON formals? statement* 'end' 
				-> ^( 'def' IDCON formals? statement* 'end' ) ;
				
formals:		'(' IDCON? ( ',' IDCON )* ')' 
				-> '(' IDCON* ')' ;

// $>

// $<Statements

statement:		ifElseStatement | ifStatement | eachStatement | letStatement | blockStatement | commentStatement |
			echoStatement | cdataStatement | yieldStatement | markupStatements ;
ifStatement:		'if' '(' predicate ')' statement ; // TODO: Look-ahead no else
ifElseStatement:	'if' '(' predicate ')' statement 'else' statement ;	
eachStatement:		'each' '(' IDCON ':' expression ')' statement ;	
letStatement:		'let' assignment+ 'in' statement* 'end' ;
blockStatement:		'{' statement* '}' ;
commentStatement:	'comment' STRCON ';' ;
echoStatement:		'echo' expression ';'  | 'echo' embedding ';' ;
cdataStatement:		'cdata' expression ';' ;
yieldStatement:		'yield;' ;

markupStatements:	functionCall | markupExpression | markupStatement | markupMarkup ;
functionCall:		markup ';' ;	
markupExpression:	markup+ expression ';' -> markup+ ';' expression ';' ;
markupStatement:	markup+ statement -> markup+ ';' statement ;
markupMarkup:		markup+ markup ';' ;		

// $>
// $<Assignments

assignment:		varBinding | funcBinding ;
varBinding:		IDCON '=' expression ';' ;
funcBinding:		IDCON formals statement ;

// $>
// $<Predicates

predicate:		( notPredicate | declaredPredicate | isPredicate ) 
			( '&&' predicate | '||' predicate )* ; // Left-recussion removal
notPredicate:		'!' predicate ;	
declaredPredicate:	expression ; // Check expression declaration (not null)
isPredicate:		expression '.' type ; // Check expression type
type:			'list' | 'record' | 'string' ;

// $>
// $<Embedding

embedding:		PRETEXT embed textTail ;
embed:			markup* expression | markup* markup ;
textTail:		POSTTEXT | MIDTEXT embed textTail ;

// $>

// Lexical rules
COMMENT	:		'comment' { inString = true; } ;
SITE:			'site' { inSite = true; inPath = true; } ; // Site constructor
END:			'end' { inSite = false; inPath = false; } ; // Site destructor
SEMICOLON:		';' { inPath = inSite; } ; // Mapping separator
 
fragment LETTER:	'a'..'z' | 'A'..'Z' ;
fragment DIGIT:		'0'..'9' ;
fragment HEXADECIMAL:	( 'a'..'f' | 'A'..'F' | DIGIT )+ ;

PATH:			{ inPath }? => ( PATHELEMENT '/' )* PATHELEMENT '.' FILEEXT { inPath = false; } ; 
fragment PATHELEMENT:	( LETTER | DIGIT )+ ; // ~( ' ' | '\t' | '\n' | '\r' | '.' | '/' | '\\' | '!'..'+' )+ ; // '!'..'+' causes java heap exception
fragment FILEEXT:	( LETTER | DIGIT )+ ;

STRCON:			{ inString }? => '\"' STRCHAR* '\"' { inString = false; } ;
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
