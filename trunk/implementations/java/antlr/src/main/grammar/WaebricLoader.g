tree grammar WaebricLoader;

options {
	tokenVocab = Waebric;
	ASTLabelType = CommonTree;
	backtrack = true;
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
	private List<SemanticException> exceptions;
	private Map<String, function_return> functions = new HashMap<String, function_return>();
	private List<mapping_return> mappings = new ArrayList<mapping_return>();
	
	public WaebricLoader(TreeNodeStream input, List<SemanticException> exceptions) {
		super(input);
		this.exceptions = exceptions;
	}
	
	public void loadModule() throws RecognitionException {
		functions.clear();
		mappings.clear();
		this.module();
	}
	
	public Map<String, function_return> getFunctions() {
		return functions;
	}
	
	public List<mapping_return> getMappings() {
		return mappings;
	}
	
	/**
	 * Multiple function definitions with the same name are disallowed.
	 * 
	 * @author Jeroen van Schagen
	 * @date 09-06-2009
	 */
	class DuplicateFunctionException extends SemanticException {
		private static final long serialVersionUID = -8833578229100261366L;
		public DuplicateFunctionException(CommonTree id) {
			super("Duplicate definition of function \"" + id.getText() 
					+ "\" at line " + id.getLine() 
        				+ " and character " + id.getCharPositionInLine() + ".");
		}
		
	}
	
}

// $<Module
module: 		^( 'module' moduleId imprt* site* function* ) ;
moduleId:		IDCON ( '.' e=IDCON )* ;
imprt:			'import' moduleId ^ module ;

// $>
// $<Site

site:			'site' mappings 'end' ;
mappings:		mapping? ( ';' mapping )* ;
mapping	:		PATH ':' markup ;
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

function returns [int args = 0]
	:		'def' id=IDCON formals statement* 'end' ;
	finally {
		if(functions.containsKey($id.getText())) {
			exceptions.add(new DuplicateFunctionException($id.tree));
		} else {
			functions.put($id.getText(), retval); 
		}
	}

formals:		( '(' IDCON* ')' )? ;

// $>

// $<Statements

statement:		^( 'if' '(' predicate ')' statement ( 'else' statement )? )
			| ^( 'each' '(' IDCON ':' expression ')' statement )
			| ^( 'let' assignment+ 'in' statement* 'end' )
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

// $>
// $<Assignments

assignment:		IDCON '=' expression ';' // Variable binding
			| IDCON formals statement ; // Function binding

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
