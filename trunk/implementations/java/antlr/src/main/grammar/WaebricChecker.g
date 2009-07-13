tree grammar WaebricChecker;

options {
	tokenVocab = Waebric;
	ASTLabelType = CommonTree;
}

@header {
	package org.cwi.waebric;
	
	import java.util.Set;
	import java.util.HashSet;
}

@rulecatch {
	catch(RecognitionException e) {
		throw e;
	}
}

@members {
	private Set<String> variables = new HashSet<String>();
	private Set<String> functions = new HashSet<String>();
	
    	/**
    	 * If for an import directive import m no corresponding file m.wae 
    	 * can be found, this a an error. [The import directive is skipped]
    	 * 
    	 * @author Jeroen van Schagen
    	 * @date 09-06-2009
    	 */
    	public class NonExistingModuleException extends RecognitionException {

    		/**
    		 * Generated serial ID
    		 */
    		private static final long serialVersionUID = -4503945323554024642L;
    		private CommonTree id;

    		public NonExistingModuleException(IntStream stream, CommonTree id) {
    			super(stream);
    			this.id = id;
    		}
    		
    		@Override
    		public String getMessage() {
    			return "Module identifier at line " + id.getLine() 
    					+ " and character " + id.getCharPositionInLine()
    					+ ", refers to a non-existing module.";
    		}
    		
    	}
}

module:		^( 'module' moduleId imprt* site* function* 'end' );

// Check if module id references to an existing file
moduleId
	@init { String path = ""; }
	:	id=IDCON { path = id.getText();}
		( '.' id=IDCON { path += "/" + id.getText(); } )* {
			path += ".wae"; // Include default extension
			java.io.File file = new java.io.File(path);
			// Check if import references to an existing file
			if(! file.isFile()) {
				throw new NonExistingModuleException(input, $id);
			}
		} ;

imprt:		'import' moduleId ';' ^module ;

// TODO: Unfinished, starting with module
site:		'site' .* 'end' ;
function: 	'def' id=IDCON f=. s=.* 'end' ;
