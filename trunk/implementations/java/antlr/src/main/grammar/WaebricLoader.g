tree grammar WaebricLoader;

options {
	tokenVocab = Waebric;
	ASTLabelType = CommonTree;
	backtrack = true;
	output = AST;
}

@header {
	package org.cwi.waebric;
	import antlr.SemanticException;
	import java.util.Map;
	import java.util.List;
	import java.util.HashMap;
	import java.util.ArrayList;
}

@members {
	/**
	 * Semantic exceptions
	 */
	private List<SemanticException> exceptions = new ArrayList<SemanticException>();
	
	/**
	 * Checked modules
	 */
	private List<String> checked = new ArrayList<String>();
	
	/**
	 * Collected function definitions
	 */
	private Map<String, function_return> functions = new HashMap<String, function_return>();
	
	/**
	 * Collected mappings
	 */
	private List<mapping_return> mappings = new ArrayList<mapping_return>();
	
	/**
	 * Walk module to retrieve function definitions and mappings
	 */
	public List<SemanticException> loadModule() throws RecognitionException {
		exceptions.clear();
		functions.clear();
		mappings.clear();
		this.module();
		return exceptions;
	}
	
	/**
	 * Retrieve function definitions
	 */
	public Map<String, function_return> getFunctions() {
		return functions;
	}
	
	/**
	 * Retrieve mappings
	 */
	public List<mapping_return> getMappings() {
		return mappings;
	}
	
}

// $<Module
module: 		^( 'module' moduleId imprt* site* function* ) {
				checked.add($moduleId.name);
			} ;
			
moduleId
	returns [String name = ""]
	:		id=IDCON { $name += $id.getText(); } ( '.' id=IDCON { $name += "." + $id.getText(); } )* ;

imprt
	@init { int start = 0; }
	:			'import' moduleId { start = input.index(); } dependancy=. {
				if(! checked.contains($moduleId.name)) {
					int curr = input.index();
					input.seek(start);
					module();
					input.seek(curr);
				}
			} ;

// $>
// $<Site

site:			'site' mappings 'end' ;
mappings:		mapping? ( ';' mapping )* ;

mapping:		PATH ':' markup ;
	finally {
		mappings.add(retval);
	}

// $>
// $<Markup

markup:			designator arguments? ;
designator:		IDCON attribute* ;
attribute:		'#' IDCON // ID attribute
			| '.' IDCON // Class attribute
			| '$' IDCON // Name attribute
			| ':' IDCON // Type attribute
			| '@' NATCON // Width attribute
			| '@' NATCON '%' NATCON; // Width-height attribute
arguments:		'(' argument? ( ',' argument )* ')' ;
argument:		expression 
			| IDCON '=' expression ;

// $>
// $<Expressions

expression:		( IDCON | NATCON | TEXT | SYMBOLCON 
				| '[' expression? ( ',' expression )* ']' // List
				| '{' keyValuePair? ( ',' keyValuePair )* '}' // Record
			) ( '+' expression /* Cat */ | '.' IDCON /* Field */ )* ;
keyValuePair:		IDCON ':' expression ;

// $>
// $<Function

function 
	returns [int args = 0, boolean yield = false]
	:		'def' id=IDCON 
			( formals { $args = $formals.args; } )?
			( statement { if($statement.yield) { $yield = true; } } )* 
			'end' ;
	finally {
		if(functions.containsKey($id.getText())) {
			exceptions.add(new WaebricChecker.DuplicateFunctionException($id));
		} else {
			functions.put($id.getText(), retval); 
		}
	}

formals returns [int args = 0] 
	:		'(' ( IDCON { $args++; } )* ')' ;

// $>

// $<Statements

statement
	returns [boolean yield = false;]
	:		^( 'if' '(' predicate ')' 
				t=statement { if($t.yield) { $yield = true; } } 
				( 'else' f=statement )? { if($f.yield) { $yield = true; } } )
			| ^( 'each' '(' IDCON ':' expression ')' s=statement { if($s.yield) { $yield = true; } } )
			| ^( 'let' assignment+ 'in' ( s=statement { if($s.yield) { $yield = true; } } )* 'end' )
			| ^( '{' ( s=statement { if($s.yield) { $yield = true; } } )* '}' )
			| ^( 'comment' STRCON ';' )
			| ^( 'echo' expression ';' )
			| ^( 'echo' embedding ';' )
			| ^( 'cdata' expression ';' )
			| 'yield;' { $yield = true; }
			| ^( MARKUP_STATEMENT markup+ expression ';' )
			| ^( MARKUP_STATEMENT markup+ s=statement { if($s.yield) { $yield = true; } } )
			| ^( MARKUP_STATEMENT markup+ embedding ';' )
			| ^( MARKUP_STATEMENT markup+ ';' ) ;

// $>
// $<Assignments

assignment:		IDCON '=' expression ';' // Variable binding
			| IDCON formals '=' statement ; // Function binding

// $>
// $<Predicates

predicate:		( '!' predicate 
				| expression // Not null
				| expression '.' type // Is type 
			) ( '&&' predicate | '||' predicate )* ;
type:			'list' | 'record' | 'string' ;

// $>
// $<Embedding

embedding:		PRETEXT embed textTail ;
embed:			markup* expression | markup* markup ;
textTail:		POSTTEXT | MIDTEXT embed textTail ;
