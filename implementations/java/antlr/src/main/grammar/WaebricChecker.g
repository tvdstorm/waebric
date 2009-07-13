tree grammar WaebricChecker;

options {
	tokenVocab = Waebric;
	ASTLabelType = CommonTree;
}

@header {
	package org.cwi.waebric;
	
	import java.util.HashMap;
	import java.util.HashSet;
}

@rulecatch {
	catch(RecognitionException e) {
		throw e;
	}
}

@members {
	private HashSet<String> variables = new HashSet<String>();
	private HashMap<String, Object> functions = new HashMap<String,Object>();
}

module:		MODULE moduleId END;

// Check if module id references to an existing file
moduleId
	@init { String path = ""; }
	@after { System.out.println("Checking module: " + path + ".wae"); }
	:	id=IDCON { path = id.getText();}
		( '.' id=IDCON { path += "/" + id.getText(); } )* ;

imprt:		IMPORT moduleId ;
site:		SITE .* END ;

function: DEF id=IDCON f=. s=.* END { functions.put(id.getText(), s.start.streamIndex); } ;
