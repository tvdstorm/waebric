tree grammar WaebricChecker;

options {
	backtrack = true;
	tokenVocab = Waebric;
	ASTLabelType = CommonTree;
}

@header {
	package org.cwi.waebric;
	
	import java.util.HashMap;
	import java.util.HashSet;
	import java.util.List;
	import java.util.ArrayList;	
}

@rulecatch {
	catch(RecognitionException e) {
		throw e;
	}
}

@members {
	private HashSet<String> variables = new HashSet<String>();
	private HashMap<String, Integer> functions = new HashMap<String, Integer>();
	private HashMap<CommonTree, Integer> calls = new HashMap<CommonTree, Integer>();

	private ArrayList<SemanticException> exceptions;
	public List<SemanticException> checkAST() throws RecognitionException {
		exceptions = new ArrayList<SemanticException>();
		module(); // Start checking
		
		for(CommonTree e: calls.keySet()) {
			// Check if function is defined
			if(! functions.containsKey(e.getText())) {
				exceptions.add(new UndefinedFunctionException(e));
			} else {
				int expectedArgs = functions.get(e.getText());
				if(expectedArgs != calls.get(e)) {
					exceptions.add(new ArityMismatchException(e, expectedArgs));
				} 
			}
		}
		
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
        public class NonExistingModuleException extends SemanticException {
        	private static final long serialVersionUID = -4503945323554024642L;
        	public NonExistingModuleException(CommonTree id) {
        		super("Module identifier at line " + id.getLine() 
        				+ " and character " + id.getCharPositionInLine()
        				+ ", refers to a non-existing module.");
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
       	public class UndefinedVariableException extends SemanticException {
       		private static final long serialVersionUID = -4479175462744485497L;
        	public UndefinedVariableException(CommonTree id) {
        		super("Variable " + id.getText() + " at line " + id.getLine() 
        				+ " and character " + id.getCharPositionInLine()
        				+ ", is undefined.");
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
       	public class UndefinedFunctionException extends SemanticException {
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
	public class ArityMismatchException extends SemanticException {
		private static final long serialVersionUID = -954167103131401047L;
		public ArityMismatchException(CommonTree id, int args) {
			super("Function call " + id.getText() + " at line " + id.getLine() 
        				+ " and character " + id.getCharPositionInLine()
        				+ ", is made to an arity mismatch."
        				+ " Use the expected " + args + " argument(s).");
		}
		
	}
	
	/**
	 * Multiple function definitions with the same name are disallowed.
	 * 
	 * @author Jeroen van Schagen
	 * @date 09-06-2009
	 */
	public class DuplicateFunctionException extends SemanticException {
		private static final long serialVersionUID = -8833578229100261366L;
		public DuplicateFunctionException(CommonTree id) {
			super("Function " + id.getText() + " at line " + id.getLine() 
        				+ " and character " + id.getCharPositionInLine()
					+ " has a duplicate definition.");
		}
		
	}
}

module:			^( 'module' moduleId imprt* site* function* 'end' );

// Check if module id references to an existing file
moduleId
	@init { String path = ""; }
	:		id=IDCON { path = id.getText();}
			( '.' id=IDCON { path += "/" + id.getText(); } )* {
				path += ".wae"; // Include default extension
				java.io.File file = new java.io.File(path);
				if(! file.isFile()) {
					exceptions.add(new NonExistingModuleException($id));
				}
			} ;
		
imprt:			^( 'import' id=moduleId ';' ^module ) ;

site:			^( 'site' mappings 'end' ) ;
mappings:		mapping? ( ';' mapping )* ;
mapping	:		. ':' markup ;

markup
	@init { int args = 0; }
	:		d=designator ( a=arguments { args = $a.args; } )? {
				calls.put($d.tree, args); // Store call and argument count
			} ;
			
designator:		IDCON attribute* ;
attribute:		'#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | 
			'@' NATCON | '@' NATCON '%' NATCON;
arguments returns [int args = 0]
	:		'(' ( argument {$args++;} )? ( ',' argument {$args++;} )* ')' ;
argument:		expression ;

expression:		( varExpression | listExpression | recordExpression | . ) ( '+' expression | '.' IDCON )* ;
varExpression:		id=IDCON {
				// Check if referenced variable is defined
				if(! variables.contains($id.getText())) { 
					exceptions.add(new UndefinedVariableException($id));
				}
			} ;			
listExpression:		'[' expression? ( ',' expression )* ']' ;
recordExpression:	'{' keyValuePair? ( ',' keyValuePair )* '}' ;
keyValuePair:		. ':' expression ;

function
	@init{ int args = 0; }
	:		 ^( 'def' id=IDCON (f=formals {args=$f.args;})? statement* 'end' ) {
				if(functions.containsKey($id.getText())) {
					exceptions.add(new DuplicateFunctionException($id));
				} else {
					functions.put($id.getText(),args);
				}
			} ;
	
formals	returns [int args = 0]
	:		{ variables.clear(); } // Store formal as variables
			'(' ( id=IDCON { variables.add($id.getText()); $args++; } )? 
			( ',' id=IDCON { variables.add($id.getText()); $args++; } )* ')'  ;

statement:		ifElseStatement | ifStatement | eachStatement | letStatement | blockStatement | commentStatement |
			echoStatement | cdataStatement | yieldStatement | markupStatements ;
ifStatement:		'if' '(' predicate ')' statement ; // TODO: Look-ahead no else
ifElseStatement:	'if' '(' predicate ')' statement 'else' statement ;	
eachStatement:		'each' '(' IDCON ':' expression ')' statement ;	
letStatement:		'let' assignment+ 'in' statement* 'end' ;
blockStatement:		'{' statement* '}' ;
commentStatement:	'comment' STRCON ';' ;
echoStatement:		'echo' expression ';'  | 'echo' . ';' ;
cdataStatement:		'cdata' expression ';' ;
yieldStatement:		'yield;' ;

markupStatements:	functionCall | markupExpression | markupStatement | markupMarkup ;
functionCall:		markup ';' ;	
markupExpression:	expression markup+ ';' ;
markupStatement:	markup+ statement ;
markupMarkup:		markup+ ';' ;

predicate:		( notPredicate | declaredPredicate | isPredicate ) ( '&&' predicate | '||' predicate )* ; 
notPredicate:		'!' predicate ;	
declaredPredicate:	expression ;
isPredicate:		expression '.' . ;	

assignment:		varBinding | funcBinding ;
varBinding:		id=IDCON '=' expression ';' {
				variables.add($id.getText());
			} ;
funcBinding:		id=IDCON f=formals statement {
				if(functions.containsKey($id.getText())) {
					exceptions.add(new DuplicateFunctionException($id));
				} else { functions.put($id.getText(), $f.args); }
			} ;
