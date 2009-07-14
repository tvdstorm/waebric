tree grammar WaebricChecker;

options {
	backtrack = true;
	tokenVocab = Waebric;
	ASTLabelType = CommonTree;
}

scope Environment {
	HashSet<String> variables;
	HashMap<String, Integer> functions;
}

@header {
	package org.cwi.waebric;
	
	import java.util.HashMap;
	import java.util.HashSet;
	import java.util.List;
	import java.util.ArrayList;	
}

@members {
	List<SemanticException> exceptions;
	public List<SemanticException> checkAST() throws RecognitionException {
		exceptions = new ArrayList<SemanticException>();
		module(); // Start checking
		
		// Process calls after retrieving all function definitions
		for(Call call: calls) {
			// Restore call environment
			Stack actual = $Environment;
			$Environment = call.env;
			
			if(isDefinedFunction(call.id)) {
				int args = expectedArgs(call.id);
				if(call.args != args) {
					exceptions.add(new ArityMismatchException(call.id, args));
				}
			} else if(! XHTMLTag.isXHTMLTag(call.id.getText())) {
				exceptions.add(new UndefinedFunctionException(call.id));
			}
			
			// Return to actual environment
			$Environment = actual;
		}
		
		return exceptions; // Return results
	}
	
	class Call { public CommonTree id; public int args; public Stack env; }
	List<Call> calls = new ArrayList<Call>();

	void defineFunction(CommonTree id, int args, int depth) {
		// Check if function is already defined
		if(isDefinedFunction(id)) {
			exceptions.add(new DuplicateFunctionException(id));
		} else { $Environment[depth]::functions.put(id.getText(), args); }
	}

	boolean isDefinedFunction(CommonTree id) {
		for(int i=$Environment.size()-1; i>=0; i--) {
			if($Environment[i]::functions.containsKey(id.getText())) {
				return true; 
			}
		} return false;
	}
	
	void defineVariable(CommonTree id) {
		$Environment::variables.add(id.getText());
	}
	
	boolean isDefinedVariable(CommonTree id) {
		for(int i=$Environment.size()-1; i>=0; i--) {
			if($Environment[i]::variables.contains(id.getText())) { 
				return true; 
			}
		} return false;
	}
	
	int expectedArgs(CommonTree id) {
		for(int i=$Environment.size()-1; i>=0; i--) {
			if($Environment[i]::functions.containsKey(id.getText())) {
				return $Environment[i]::functions.get(id.getText()); 
			}
		} return -1;
	}
	
    	public abstract class SemanticException extends Exception { 
			private static final long serialVersionUID = 9032805899029042730L;
			public SemanticException(String message) { super(message); }
    	}
    	
        /**
         * If for an import directive import m no corresponding file m.wae 
         * can be found, this a an error. [The import directive is skipped]
         * 
         * @author Jeroen van Schagen
         * @date 09-06-2009
         */
        class NonExistingModuleException extends SemanticException {
        	private static final long serialVersionUID = -4503945323554024642L;
        	public NonExistingModuleException(CommonTree id) {
        		super("Module identifier at line " + id.getLine() 
        				+ " and character " + id.getCharPositionInLine()
        				+ " refers to a non-existing module.");
       		}
       	}
       	
       /**
	 * If a variable reference x cannot be traced back to an enclosing 
	 * let-definition or function parameter, this is an error. The 
	 * variable x will be undefined and evaluate to the string "undef".
	 * 
	 * @author Jeroen van Schagen
	 * @date 09-06-2009
	 */
       	class UndefinedVariableException extends SemanticException {
       		private static final long serialVersionUID = -4479175462744485497L;
        	public UndefinedVariableException(CommonTree id) {
        		super("Undefined variable " + id.getText() + " at line " + id.getLine() 
        				+ " and character " + id.getCharPositionInLine() + ".");
       		}
       	}
       	
       	/**
	 * If for a markup-call (f) no function definition can be found in 
	 * the current module or one of its (transitive) imports, and, if 
	 * f is not a tag defined in the XHTML 1.0 Transitional standard, 
	 * then this is an error. [f will be interpreted as if it was part 
	 * of XHTML 1.0 transitional.]
	 * 
	 * @author Jeroen van Schagen
	 * @date 09-06-2009
	 */
       	class UndefinedFunctionException extends SemanticException {
       		private static final long serialVersionUID = -4569708425419653397L;
        	public UndefinedFunctionException(CommonTree id) {
        		super("Function call " + id.getText() + " at line " + id.getLine() 
        				+ " and character " + id.getCharPositionInLine()
        				+ ", is made to an undefined function.");
       		}
       	}
       	
	/**
	 * If a function is called with an incorrect number of arguments 
	 * (as follows from its definition), this is an error.
	 * 
	 * @author Jeroen van Schagen
	 * @date 09-06-2009
	 */
	class ArityMismatchException extends SemanticException {
		private static final long serialVersionUID = -954167103131401047L;
		public ArityMismatchException(CommonTree id, int args) {
			super("Arity mismatch at function call " + id.getText() 
					+ " positioned on line " + id.getLine() 
        				+ " and character " + id.getCharPositionInLine()
        				+ ". Use the expected " + args + " argument(s).");
		}
		
	}
	
	/**
	 * Multiple function definitions with the same name are disallowed.
	 * 
	 * @author Jeroen van Schagen
	 * @date 09-06-2009
	 */
	class DuplicateFunctionException extends SemanticException {
		private static final long serialVersionUID = -8833578229100261366L;
		public DuplicateFunctionException(CommonTree id) {
			super("Duplicate definition of function " + id.getText() 
					+ " at line " + id.getLine() 
        				+ " and character " + id.getCharPositionInLine() + ".");
		}
		
	}
}

// $<Modules

module
	scope Environment;
	@init {
		$Environment::variables = new HashSet<String>();
		$Environment::functions = new HashMap<String, Integer>();
	} :		^( 'module' moduleId imprt* site* function* 'end' );

moduleId
	@init { 
		String path = "";
	} :		id=IDCON { path = id.getText();}
			( '.' id=IDCON { path += "/" + id.getText(); } )* {
				path += ".wae"; // Include default extension
				java.io.File file = new java.io.File(path);
				if(! file.isFile()) {
					// Each import reference should be a valid file
					exceptions.add(new NonExistingModuleException($id));
				}
			} ;

imprt:			^( 'import' id=moduleId ';' ^ module ) ;

// $>

site:			^( 'site' mappings 'end' ) ;
mappings:		mapping? ( ';' mapping )* ;
mapping	:		. ':' markup ;

// $<Markups

markup
	@init { int args = 0; }
	:		d=designator ( a=arguments { args = $a.args; } )? {
				// Store function call
				Call call = new Call();
				call.id = $d.tree;
				call.args = args;
				call.env = (Stack) $Environment.clone();
				calls.add(call);
			} ;
			
designator:		IDCON attribute* ;
attribute:		'#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON ( '%' NATCON )?;
			
arguments returns [int args = 0]
	:		'(' ( expression {$args++;} )? ( ',' expression {$args++;} )* ')' ;

// $>

// $<Expressions

expression:		( varExpression | listExpression | recordExpression | . ) ( '+' expression | '.' IDCON )* ;

varExpression:		id=IDCON {
				if(! isDefinedVariable($id)) {
					exceptions.add(new UndefinedVariableException($id));
				}
			} ;
			
listExpression:		'[' expression? ( ',' expression )* ']' ;
recordExpression:	'{' keyValuePair? ( ',' keyValuePair )* '}' ;
keyValuePair:		. ':' expression ;

// $>

function
	scope Environment;
	@init {
		$Environment::variables = new HashSet<String>();
		$Environment::functions = new HashMap<String, Integer>();
	} :		^( 'def' id=IDCON f=formals statement* 'end' ) { 
				defineFunction($id, $f.args, 0);
			} ;
			
formals	returns [int args = 0] 
	:		r=regularFormals { $args = $r.args; } | emptyFormals ;
			
regularFormals returns [int args = 0]
	:		'(' ( id=IDCON { defineVariable($id); $args++; } )* ')' ;

emptyFormals:		/* No formals defined */ ;

// $<Statements

statement:		ifElseStatement | ifStatement | eachStatement | letStatement | blockStatement | 
			commentStatement | echoStatement | cdataStatement | yieldStatement | markupStatements ;

ifElseStatement:	'if' '(' predicate ')' statement 'else' statement ;			
ifStatement:		'if' '(' predicate ')' statement ;

// $<Predicate

predicate:		( notPredicate | declaredPredicate | isPredicate ) ( '&&' predicate | '||' predicate )* ; 
notPredicate:		'!' predicate ;	
declaredPredicate:	expression ;
isPredicate:		expression '.' . ;		

// $>

blockStatement:		'{' statement* '}' ;
commentStatement:	'comment' STRCON ';' ;
echoStatement:		'echo' expression ';'  | 'echo' embedding ';' ;

// $<Embedding

embedding:		PRETEXT embed textTail ;
embed:			markup* expression | markup* markup ;
textTail:		POSTTEXT | MIDTEXT embed textTail ;

// $>

cdataStatement:		'cdata' expression ';' ;
yieldStatement:		'yield;' ;

markupStatements:	functionCall | markupExpression | markupStatement | markupMarkup ;
functionCall:		markup ';' ;	
markupExpression:	markup+ ';' expression ';' ;
markupStatement:	markup+ ';' statement ;
markupMarkup:		markup+ ';' ;

// $<Assignments

eachStatement
	scope Environment;
	@init {
		$Environment::variables = new HashSet<String>();
		$Environment::functions = new HashMap<String, Integer>();
	} :		'each' '(' id=IDCON ':' expression ')' { 
				defineVariable($id); // Define variable before statement is executed
			} statement ;

letStatement
	scope Environment;
	@init {
		$Environment::variables = new HashSet<String>();
		$Environment::functions = new HashMap<String, Integer>();
		int curr = $Environment.size()-1;
	} :		'let' assignment[curr]+ 'in' statement* 'end' ;

assignment [int depth]:	
			varBinding | funcBinding[depth] ;

varBinding:		id=IDCON '=' expression ';' { 
				defineVariable($id); 
			} ;
			
funcBinding [int depth]
	scope Environment;
	@init {
		$Environment::variables = new HashSet<String>();
		$Environment::functions = new HashMap<String, Integer>();
	} :		id=IDCON f=regularFormals statement { defineFunction($id, $f.args, depth); } ;
