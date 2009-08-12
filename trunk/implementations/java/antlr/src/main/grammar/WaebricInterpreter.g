tree grammar WaebricInterpreter;

options {
	tokenVocab = Waebric;
	ASTLabelType = CommonTree;
	backtrack = true;
}

scope Environment {
	HashMap<String,CommonTree> functions;
}

@header {
	package org.cwi.waebric;
	import java.util.HashMap;
}

@members {
	public WaebricInterpreter(TreeNodeStream input, HashMap<String,CommonTree> functions) {
		super(input);
		
		Environment_scope base = new Environment_scope();
		base.functions = functions;
		Environment_stack.push(base);
	}
	
	public void interpretProgram() throws RecognitionException {
		CommonTree main = getFunction("main");
		//if(tree != null) { input = main; this.function(); }
	}
	
	private CommonTree getFunction(String name) {
		for(int i=$Environment.size()-1; i>=0; i--) {
			if($Environment[i]::functions.containsKey(name)) {
				return $Environment[i]::functions.get(name); 
			}
		} return null;
	}
}

// $<Module
module: 		^( 'module' moduleId imprt* site* function* 'end' ) ;

moduleId:		IDCON ( '.' e=IDCON )* ;
	
imprt:			'import' moduleId ';' ^ module ;

// $>
// $<Site

site:			'site' mappings 'end' ;

mappings:		mapping? ( ';' mapping )* ;

mapping	:		PATH ':' markup ;

// $>
// $<Markup

markup:			designator arguments? ;

designator:		IDCON attribute* ;

attribute:		'#' IDCON // ID attribute
			| '.' IDCON // Class attribute
			| '$' IDCON // Name attribute
			| ':' IDCON // Type attribute
			| '@' NATCON // Width attribute
			| '@' NATCON '%' NATCON; // Width-height attribute
			
arguments:		'(' argument? ( ',' argument )* ')' ;

argument:		expression ;

// $>
// $<Expressions

expression:		( IDCON | NATCON | TEXT | SYMBOLCON 
				| '[' expression? ( ',' expression )* ']' // List
				| '{' keyValuePair? ( ',' keyValuePair )* '}' // Record
			) ( '+' expression /* Cat */ | '.' IDCON /* Field */ )* ;
			
keyValuePair:		IDCON ':' expression ;

// $>
// $<Function

function:		'def' id=IDCON formals? statement* 'end' ;

formals:		'(' IDCON* ')' ;

// $>

// $<Statements

statement:		'if' '(' predicate ')' statement 'else' statement 
			| 'if' '(' predicate ')' statement 
			| 'each' '(' IDCON ':' expression ')' statement 
			| 'let' assignment+ 'in' statement* 'end' 
			| '{' statement* '}' 
			| 'comment' STRCON ';' 
			| 'echo' expression ';' 
			| 'echo' embedding ';'
			| 'cdata' expression ';' 
			| 'yield;' 
			| markup ';'
			| markup+ ';' expression ';'
			| markup+ ';' statement
			| markup+ embedding ';' 
			| markup+ ';' ;

// $>
// $<Assignments

assignment:		IDCON '=' expression ';' // Variable binding
			| IDCON formals statement ; // Function binding

// $>
// $<Predicates

predicate:		( '!' predicate 
				| expression // Not null
				| expression '.' type // Is type 
			) ( '&&' predicate | '||' predicate )* ;
			
type:			'list' | 'record' | 'string' ;

// $>
// $<Embedding

embedding:		PRETEXT embed textTail ;

embed:			markup* expression | markup* markup ;

textTail:		POSTTEXT | MIDTEXT embed textTail ;
