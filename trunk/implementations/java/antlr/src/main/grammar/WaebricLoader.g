tree grammar WaebricLoader;

options {
	tokenVocab = Waebric;
	ASTLabelType = CommonTree;
	backtrack = true;
	output = AST;
}

@header {
	package org.cwi.waebric;
	import antlr.SemanticException;
}

@members {
	/**
	 * Semantic exceptions
	 */
	private List<SemanticException> exceptions = new ArrayList<SemanticException>();
	
	/**
	 * Checked modules
	 */
	private List<String> checked = new ArrayList<String>();
	
	/**
	 * Detected yield positions
	 */
	private List<Integer> yields = new ArrayList<Integer>();
	
	/**
	 * Collected function definitions
	 */
	private Map<String, function_return> functions = new HashMap<String, function_return>();
	
	/**
	 * Collected mappings
	 */
	private List<mapping_return> mappings = new ArrayList<mapping_return>();
	
	/**
	 * Walk module to retrieve function definitions and mappings
	 */
	public List<SemanticException> loadModule() throws RecognitionException {
		exceptions.clear();
		functions.clear();
		mappings.clear();
		this.module();
		return exceptions;
	}
	
	/**
	 * Retrieve function definitions
	 */
	public Map<String, function_return> getFunctions() {
		return functions;
	}
	
	/**
	 * Retrieve mappings
	 */
	public List<mapping_return> getMappings() {
		return mappings;
	}
	
	public List<Integer> getYields() {
		return yields;
	}
	
}

// $<Module
module: 		^( 'module' moduleId imprt* site* function* ) {
				checked.add($moduleId.name);
			} ;
			
moduleId
	returns [String name = ""]
	:		id=IDCON { $name += $id.getText(); } ( '.' id=IDCON { $name += "." + $id.getText(); } )* ;

imprt
	@init { int start = 0; }
	:			'import' moduleId { start = input.index(); } dependancy=. {
				if(! checked.contains($moduleId.name)) {
					int curr = input.index();
					input.seek(start);
					module();
					input.seek(curr);
				}
			} ;

// $>
// $<Site

site:			'site' mappings 'end' ;
mappings:		mapping? ( ';' mapping )* ;

mapping
	returns [int index = 0]
	@init { $index = input.index(); }
	:		PATH ':' markup ;
	finally {
		mappings.add(retval);
	}

// $>
// $<Markup

markup:			^( MARKUP IDCON . . ) ;

// $>
// $<Expressions

expression:		( IDCON | NATCON | TEXT | SYMBOLCON 
				| '[' expression? ( ',' expression )* ']' // List
				| '{' keyValuePair? ( ',' keyValuePair )* '}' // Record
			) ( '+' expression /* Cat */ | '.' IDCON /* Field */ )* ;
keyValuePair:		IDCON ':' expression ;

// $>
// $<Function

function 
	returns [int args = 0, int index = 0]
	@init { $index = input.index();}
	:		^( FUNCTION id=IDCON 
			formals { $args = $formals.args; }
			statements { if($statements.yield) { yields.add($index); } } );
	finally {
		if(functions.containsKey($id.getText())) {
			exceptions.add(new WaebricChecker.DuplicateFunctionException($id));
		} else {
			functions.put($id.getText(), retval); 
		}
	}

formals returns [int args = 0] 
	:		^( FORMALS ( IDCON { $args++; } )* ) ;

// $>

// $<Statements

statements
	returns[boolean yield = false]
	:		( s=statement { if($s.yield) { $yield = true; } } )* ;

statement
	returns[boolean yield = false;]
	:		^( 'if' '(' predicate ')' t=statement { if($t.yield) $yield = true; } 
				( 'else' f=statement { if($f.yield) $yield = true; } )? ) 
			| ^( 'each' '(' IDCON ':' expression ')' stm=statement ) { $yield = $stm.yield; }
			| ^( 'let' assignment+ 'in' stms=statements 'end' ) { $yield = $stms.yield; }
			| ^( '{' stms=statements '}' ) { $yield = $stms.yield; }
			| ^( 'comment' STRCON ';' )
			| ^( 'echo' expression ';' )
			| ^( 'echo' embedding ';' )
			| ^( 'cdata' expression ';' )
			| 'yield;' { $yield = true; }
			| ^( MARKUP_STATEMENT markup+ expression ';' )
			| ^( MARKUP_STATEMENT markup+ stm=statement ) { $yield = $stm.yield; }
			| ^( MARKUP_STATEMENT markup+ embedding ';' )
			| ^( MARKUP_STATEMENT markup+ ';' ) ;

// $>
// $<Assignments

assignment:		IDCON '=' expression ';' // Variable binding
			| ^( FUNCTION IDCON formals statement ) ; // Function binding

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
