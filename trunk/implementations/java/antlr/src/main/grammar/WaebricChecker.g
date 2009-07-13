tree grammar WaebricChecker;

options {
	tokenVocab = Waebric;
	ASTLabelType = CommonTree;
}

@header {
	package org.cwi.waebric;
	
	import java.util.Set;
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
	private Set<String> variables = new HashSet<String>();
	private Set<String> functions = new HashSet<String>();
	
	private List<SemanticException> exceptions;
	public List<SemanticException> checkAST() throws RecognitionException {
		exceptions = new ArrayList<SemanticException>();
		module(); // Perform check
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
       	
       	public class UndefinedVariableException extends SemanticException {
        	public UndefinedVariableException(CommonTree id) {
        		super("Variable " + id.getText() + " at line " + id.getLine() 
        				+ " and character " + id.getCharPositionInLine()
        				+ ", is undefined.");
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
				// Check if import references to an existing file
				if(! file.isFile()) {
					exceptions.add(new NonExistingModuleException($id));
				}
			} ;
		
imprt:			'import' id=moduleId ';' ^ module ;

site:			'site' mappings 'end' ;
mappings:		mapping? ( ';' mapping )* ;
mapping	:		PATH ':' markup ;

markup:			designator arguments? ;
designator:		IDCON attribute* ;
attribute:		'#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | 
			'@' NATCON | '@' NATCON '%' NATCON;
arguments:		'(' argument? ( ',' argument )* ')' ;
argument:		expression ;

expression:		varExpression | listExpression | recordExpression | . ;
varExpression:		id=IDCON { 
				if(! variables.contains($id.getText())) { 
					exceptions.add(new UndefinedVariableException($id));
				}
			} ;			
listExpression:		'[' expression? ( ',' expression )* ']' ;
recordExpression:	'{' keyValuePair? ( ',' keyValuePair )* '}' ;
keyValuePair:		IDCON ':' expression ;

function: 		'def' id=IDCON f=. s=.* 'end' ;
