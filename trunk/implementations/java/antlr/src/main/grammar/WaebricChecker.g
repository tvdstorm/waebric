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
	void defineFunction(CommonTree id, int args) {
		// Check if function is already defined
		if(isDefinedFunction(id.getText())) {
			exceptions.add(new DuplicateFunctionException(id));
		} else { $Environment::functions.put(id.getText(), args); }
	}

	boolean isDefinedFunction(String id) {
		for(int i=$Environment.size()-1; i>=0; i--) {
			if($Environment[i]::functions.containsKey(id)) {
				return true; 
			}
		} return false;
	}
	
	int getFunctionArgs(String id) {
		for(int i=$Environment.size()-1; i>=0; i--) {
			if($Environment[i]::functions.containsKey(id)) {
				return $Environment[i]::functions.get(id); 
			}
		} return -1;
	}
	
	void defineVariable(CommonTree id) {
		$Environment::variables.add(id.getText());
	}
	
	boolean isDefinedVariable(String id) {
		for(int i=$Environment.size()-1; i>=0; i--) {
			if($Environment[i]::variables.contains(id)) { 
				return true; 
			}
		} return false;
	}

	ArrayList<SemanticException> exceptions;
	public List<SemanticException> checkAST() throws RecognitionException {
		exceptions = new ArrayList<SemanticException>();
		module(); // Start checking
		return exceptions; // Return results
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
				if(! isDefinedFunction($d.tree.getText())) {
					exceptions.add(new UndefinedFunctionException($d.tree));
				} else {
					int expected = getFunctionArgs($d.tree.getText());
					if(args != expected) {
						exceptions.add(new ArityMismatchException($d.tree, expected));
					}
				}
			} ;
			
designator:		IDCON attribute* ;
attribute:		'#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON ( '%' NATCON )?;
			
arguments returns [int args = 0]
	:		'(' ( expression {$args++;} )? ( ',' expression {$args++;} )* ')' ;

// $>

// $<Expressions

expression:		( varExpression | listExpression | recordExpression | . ) ( '+' expression | '.' IDCON )* ;

varExpression:		id=IDCON {
				if(! isDefinedVariable($id.getText())) {
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
		int args = 0; // Argument count
	} :		^( 'def' id=IDCON ( f=formals { args = $f.args; } )? statement* 'end' ) { 
				if(isDefinedFunction(id.getText())) {
					exceptions.add(new DuplicateFunctionException(id));
				} else { $Environment[0]::functions.put(id.getText(), args); }
			} ;
			
formals	returns [int args = 0]
	:		'(' ( id=IDCON { defineVariable($id); $args++; } )? 
			( ',' id=IDCON { defineVariable($id); $args++; } )* ')'  ;

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
	} :		'let' assignment+ 'in' statement* 'end' ;

assignment:		varBinding | funcBinding ;
varBinding:		id=IDCON '=' expression ';' { defineVariable($id); } ;
funcBinding:		id=IDCON f=formals statement { defineFunction($id, $f.args); } ;
