package org.cwi.waebric;
	import antlr.SemanticException;
	
public class CheckerPreamble {
private List<SemanticException> exceptions;
	
	public CheckerPreamble(TreeNodeStream input, List<SemanticException> exceptions) {
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
		} else { Environment.functions.put(id.getText(), args); }
	}

	/**
	 * Check if a function is defined
	 * @param name: Function name
	 */
	private boolean isDefinedFunction(String name) {
		for(int i=Environment.size()-1; i>=0; i--) {
			if(Environment[i].functions.containsKey(name)) {
				return true; 
			}
		} return false;
	}
	
	/**
	 * Retrieve excepted function arguments
	 * @param name: Function name
	 */
	private int getFunctionArgs(String name) {
		for(int i=Environment.size()-1; i>=0; i--) {
			if(Environment[i].functions.containsKey(name)) {
				return Environment[i].functions.get(name); 
			}
		} return -1;
	}
	
	/**
	 * Define variable
	 * @param name: Variable name
	 */
	private void defineVariable(String name) {
		Environment.variables.add(name);
	}

	/**
	 * Check if variable is defined
	 * @param name: Variable name
	 */
	private boolean isDefinedVariable(String name) {
		for(int i=Environment.size()-1; i>=0; i--) {
			if(Environment[i].variables.contains(name)) { 
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
