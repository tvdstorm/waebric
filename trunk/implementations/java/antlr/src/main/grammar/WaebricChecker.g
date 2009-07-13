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

module:		^( 'module' moduleId imprt* site* function* 'end' );

// Check if module id references to an existing file
moduleId
	@init { String path = ""; }
	@after { System.out.println("Checking module: " + path + ".wae"); }
	:	id=IDCON { path = id.getText();}
		( '.' id=IDCON { path += "/" + id.getText(); } )* ;

imprt:		'import' moduleId ';' ^module ;

// TODO: Unfinished, starting with module
site:		'site' .* 'end' ;
function: 	'def' id=IDCON f=. s=.* 'end' ;
