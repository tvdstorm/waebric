tree grammar WaebricChecker;

options {
	tokenVocab = Waebric;
	ASTLabelType = CommonTree;
	backtrack = true;
	output = AST;
}

scope Environment {
	ArrayList<String> variables;
	HashMap<String, Integer> functions;
}

@header {
	package org.cwi.waebric;
	import antlr.SemanticException;
}

@members {
	private List<SemanticException> exceptions;
	
	public WaebricChecker(TreeNodeStream input, List<SemanticException> exceptions) {
		super(input);
		this.exceptions = exceptions;
	}
	
	public void checkAST(WaebricLoader loader) throws RecognitionException {
		// Store function definitions to allow lazy function binding
		Environment_stack.clear();
		Environment_scope base = new Environment_scope();
		base.functions = new HashMap<String, Integer>();
		base.variables = new ArrayList<String>();
		for(String function: loader.getFunctions().keySet()) 
		{ base.functions.put(function, loader.getFunctions().get(function).args); }
		Environment_stack.push(base);
		
		module(); // Check module
	}

	/**
	 * Define function
	 * @param id: Tree representation of functions IDCON
	 * @param args: Number of arguments in function
	 * @param depth: Depth in environment stack
	 */
	private void defineFunction(CommonTree id, int args) {
		// Check if function is already defined
		if(isDefinedFunction(id.getText())) {
			exceptions.add(new DuplicateFunctionException(id));
		} else { $Environment::functions.put(id.getText(), args); }
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
	 * Multiple function definitions with the same name are disallowed.
	 * 
	 * @author Jeroen van Schagen
	 * @date 09-06-2009
	 */
	public static class DuplicateFunctionException extends SemanticException {
		private static final long serialVersionUID = -8833578229100261366L;
		public DuplicateFunctionException(CommonTree id) {
			super("Duplicate definition of function \"" + id.getText() 
					+ "\" at line " + id.getLine() 
        				+ " and character " + id.getCharPositionInLine() + ".");
		}
		
	}
	
        /**
         * If for an import directive import m no corresponding file m.wae 
         * can be found, this a an error. [The import directive is skipped]
         * 
         * @author Jeroen van Schagen
         * @date 09-06-2009
         */
        public static class NonExistingModuleException extends SemanticException {
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
       	public static class UndefinedVariableException extends SemanticException {
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
       	public static class UndefinedFunctionException extends SemanticException {
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
	public static class ArityMismatchException extends SemanticException {
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
		$Environment::variables = new ArrayList<String>();
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

markup:			^( MARKUP IDCON . arguments ) {
				if(isDefinedFunction($IDCON.getText())) {
					int expected = getFunctionArgs($IDCON.getText());
					int actual = $arguments.args;
					if(expected != actual) {
						exceptions.add(new ArityMismatchException($IDCON, expected));
					}
				} else if(! XHTMLTag.isXHTMLTag($IDCON.getText())) {
					exceptions.add(new UndefinedFunctionException($IDCON));
				}
			} ;
	
arguments returns [int args = 0]
	:		^( ARGUMENTS ( argument {$args++;} )* ) ;
			
argument:		expression | IDCON '=' expression ;

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
		$Environment::variables = new ArrayList<String>();
		$Environment::functions = new HashMap<String, Integer>();
	} :		^( FUNCTION IDCON formals statement* ) ;
			
formals returns [int args = 0] 
	:		^( FORMALS ( IDCON { defineVariable($IDCON.getText()); $args++; } )* ) ;

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
			| ^( MARKUP_STATEMENT markup markupChain ) ;
			
markupChain:		^( MARKUP_CHAIN markup markupChain )
			| ^( MARKUP_CHAIN expression ';' )
			| ^( MARKUP_CHAIN statement )
			| ^( MARKUP_CHAIN embedding ';' )
			| ^( MARKUP_CHAIN ';' ) ;

eachStatement
	scope Environment;
	@init {
		$Environment::variables = new ArrayList<String>();
		$Environment::functions = new HashMap<String, Integer>();
	} :		^( 'each' '(' IDCON ':' expression ')' { 
				defineVariable($IDCON.getText()); // Define variable before statement is executed
			} statement ) ;

letStatement
	scope Environment;
	@init {
		$Environment::variables = new ArrayList<String>();
		$Environment::functions = new HashMap<String, Integer>();
	} :		^( 'let' assignment+ 'in' statement* 'end' ) ;

assignment:		IDCON '=' expression ';' { 
				defineVariable($IDCON.getText()); 
			} | funcBinding ;
			
funcBinding // Separated because only function bindings have local scopes
	scope Environment;
	@init {
		$Environment::variables = new ArrayList<String>();
		$Environment::functions = new HashMap<String, Integer>();
	} : 		^( FUNCTION id=IDCON f=formals statement ) ;
	finally {
		// Define function after poping local stack so the definition stays
		defineFunction($id, $f.args);
	}
		
			
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
