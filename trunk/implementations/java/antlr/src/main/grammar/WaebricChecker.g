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
	
	public boolean isVariable(String variable) {
		return variables.contains(variable);
	}
	
	public void declareVariable(String variable) {
		variables.add(variable);
	}
}

module:		MODULE moduleId END;

// Check if module id references to an existing file
moduleId:	id=IDCON {String path = id.getText();} 
		( '.' id=IDCON { path += "/" + id.getText(); } )* 
		{ System.out.println("Checking module: " + path + ".wae"); } ;

imprt:		IMPORT moduleId;
site:		SITE .* END;
function:	DEF .* END;
