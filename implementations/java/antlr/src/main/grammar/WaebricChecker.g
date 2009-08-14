tree grammar WaebricChecker;

options {
	tokenVocab = Waebric;
	ASTLabelType = CommonTree;
	backtrack = true;
}

scope Environment {
	HashSet<String> variables;
	HashMap<String, Integer> functions;
}

@header {
	package org.cwi.waebric;
	import antlr.SemanticException;
	import java.util.HashMap;
	import java.util.HashSet;
	import java.util.List;
	import java.util.ArrayList;	
}

@members {
	List<SemanticException> exceptions;
	
	public WaebricChecker(TreeNodeStream input, List<SemanticException> exceptions) {
		super(input);
		this.exceptions = exceptions;
	}
	
	public void checkAST() throws RecognitionException {
		module();
	}

	/**
	 * Define function
	 * @param id: Tree representation of functions IDCON
	 * @param args: Number of arguments in function
	 * @param depth: Depth in environment stack
	 */
	private void defineFunction(CommonTree id, int args, int depth) {
		// Check if function is already defined
		if(isDefinedFunction(id.getText())) {
			exceptions.add(new DuplicateFunctionException(id));
		} else { $Environment[depth]::functions.put(id.getText(), args); }
	}

	/**
	 * Check if a function is defined
	 * @param name: Function name
	 */
	private boolean isDefinedFunction(String name) {
		for(int i=$Environment.size()-1; i>=0; i--) {
			if($Environment[i]::functions.containsKey(name)) {
				return true; 
			}
		} return false;
	}
	
	/**
	 * Retrieve excepted function arguments
	 * @param name: Function name
	 */
	private int getFunctionArgs(String name) {
		for(int i=$Environment.size()-1; i>=0; i--) {
			if($Environment[i]::functions.containsKey(name)) {
				return $Environment[i]::functions.get(name); 
			}
		} return -1;
	}
	
	/**
	 * Define variable
	 * @param name: Variable name
	 */
	private void defineVariable(String name) {
		$Environment::variables.add(name);
	}

	/**
	 * Check if variable is defined
	 * @param name: Variable name
	 */
	private boolean isDefinedVariable(String name) {
		for(int i=$Environment.size()-1; i>=0; i--) {
			if($Environment[i]::variables.contains(name)) { 
				return true; 
			}
		} return false;
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
        		super("Module identifier \"" + id.getText() + "\" at line " + id.getLine() 
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
        		super("Undefined variable \"" + id.getText() + "\" at line " + id.getLine() 
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
        		super("Function call \"" + id.getText() + "\" at line " + id.getLine() 
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
			super("Arity mismatch at function call \"" + id.getText() 
					+ "\" positioned on line " + id.getLine() 
        				+ " and character " + id.getCharPositionInLine()
        				+ ". Use the expected " + args + " argument(s).");
		}
		
	}
	
}

// $<Modules

module
	scope Environment;
	@init {
		$Environment::variables = new HashSet<String>();
		$Environment::functions = new HashMap<String, Integer>();
	} :		^( 'module' moduleId imprt* site* function* );

moduleId
	@init { String path = ""; } 
	@after { path += ".wae"; } // Include default extension
	:		id=IDCON { path = $id.getText(); } 
			( '.' id=IDCON { path += "/" + $id.getText(); } )* ;
		finally {
			java.io.File file = new java.io.File(path);
			if(! file.isFile()) {
				// Each import reference should be a valid file
				exceptions.add(new NonExistingModuleException($moduleId.tree));
			}
		}

imprt:			'import' moduleId ^ module ;

// $>

site:			'site' mappings 'end' ;
mappings:		mapping? ( ';' mapping )* ;
mapping	:		PATH ':' markup ;

// $<Markups

markup
	@init { int args = 0; }
	:		IDCON attribute* ( arguments { args = $arguments.args; } )? {
				if(isDefinedFunction($IDCON.getText())) {
					int actual = getFunctionArgs($IDCON.getText());
					if(args != actual) {
						exceptions.add(new ArityMismatchException($IDCON, args));
					}
				} else if(! XHTMLTag.isXHTMLTag($IDCON.getText())) {
					exceptions.add(new UndefinedFunctionException($IDCON));
				}
			} ;
		
attribute:		'#' IDCON 
			| '.' IDCON 
			| '$' IDCON 
			| ':' IDCON 
			| '@' NATCON ( '%' NATCON )?;
	
arguments returns [int args = 0]
	:		'(' ( argument {$args++;} )? 
			( ',' argument {$args++;} )* ')' ;
			
argument:		expression
			| IDCON '=' expression ;

// $>

// $<Expressions

expression:		( varExpression | NATCON | TEXT | SYMBOLCON 
				| '[' expression? ( ',' expression )* ']' 
				| '{' keyValuePair? ( ',' keyValuePair )* '}' 
			) ( '+' expression | '.' IDCON )* ;

varExpression:		IDCON {
				if(! isDefinedVariable($IDCON.getText())) {
					exceptions.add(new UndefinedVariableException($IDCON.tree));
				}
			} ;
			
keyValuePair:		IDCON ':' expression ;

// $>

function
	scope Environment;
	@init {
		$Environment::variables = new HashSet<String>();
		$Environment::functions = new HashMap<String, Integer>();
	} :		'def' IDCON formals statement* 'end' { 
				defineFunction($IDCON, $formals.args, 0);
			} ;
			
formals	returns [int args = 0] :
			regularFormals { $args = $regularFormals.args; } | ;
			
regularFormals returns [int args = 0]:
			'(' ( IDCON { defineVariable($IDCON.getText()); $args++; } )* ')' ;

// $<Statements

statement:		^( 'if' '(' predicate ')' statement ( 'else' statement )? )
			| eachStatement
			| letStatement
			| ^( '{' statement* '}' )
			| ^( 'comment' STRCON ';' )
			| ^( 'echo' expression ';' )
			| ^( 'echo' embedding ';' )
			| ^( 'cdata' expression ';' )
			| 'yield;'
			| ^( MARKUP_STATEMENT markup+ expression ';' )
			| ^( MARKUP_STATEMENT markup+ statement )
			| ^( MARKUP_STATEMENT markup+ embedding ';' )
			| ^( MARKUP_STATEMENT markup+ ';' ) ;

eachStatement
	scope Environment;
	@init {
		$Environment::variables = new HashSet<String>();
		$Environment::functions = new HashMap<String, Integer>();
	} :		^( 'each' '(' IDCON ':' expression ')' { 
				defineVariable($IDCON.getText()); // Define variable before statement is executed
			} statement ) ;

letStatement
	scope Environment;
	@init {
		$Environment::variables = new HashSet<String>();
		$Environment::functions = new HashMap<String, Integer>();
	} :		^( 'let' assignment+ 'in' statement* 'end' ) ;

assignment:		IDCON '=' expression ';' { 
				defineVariable($IDCON.getText()); 
			} | funcBinding ;
			
funcBinding // Separated because only function bindings have local scopes
	scope Environment;
	@init {
		$Environment::variables = new HashSet<String>();
		$Environment::functions = new HashMap<String, Integer>();
		int parent = $Environment.size()-1;
	} : 		IDCON regularFormals '=' statement {
				defineFunction($IDCON, $regularFormals.args, parent);
			} ;
		
			
// $<Predicate

predicate:		( '!' predicate 
				| expression
				| expression '.' type
			) ( '&&' predicate | '||' predicate )* ;
type:			'list' | 'record' | 'string' ;		

// $>

// $<Embedding

embedding:		PRETEXT embed textTail ;
embed:			markup* expression | markup* markup ;
textTail:		POSTTEXT | MIDTEXT embed textTail ;
