grammar Waebric;

@header {
	import org.antlr.runtime.*:
}

@members {
	public static void main(String[] args) throws Exception {
	        ANTLRInputStream input = new ANTLRInputStream(System.in);
	        WaebricLexer lexer = new WaebricLexer(input);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        WaebricParser parser = new WaebricParser(tokens);
	        parser.modules();
    	}
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/
Module:		'module' ModuleId ModuleElement*;
ModuleId:	( IDCON '.' )+;
ModuleElement:	Import | FunctionDef | Site;

Import:		'import' ModuleId;

Site:	 	'site' /*( Mapping ';' )**/ 'end';
//Mapping:	Path ':' Markup;
//Path:		DirName '/' FileName | FileName;
//DirName:	Directory;
//Directory:	( PATHELEMENT '/')+;
//FileName:	PATHELEMENT '.' FILEEXT;

Markup:		Designator Arguments | Designator;
Designator:	IDCON Attribute*;
Attribute:	'#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON
		| '@' NATCON | '@' NATCON '%' NATCON;
Arguments:	'(' ( Argument ',' )* ')';
Argument:	Expression;

Expression:	IDCON | NATCON;	// TODO: Priorities etc

FunctionDef:	'def' IDCON Formals Statement* 'end';
Formals:	'(' ( IDCON ',' )* ')' | ;

Statement:	'if' | 'if' 'else' | 'each' | 'let' | '{' '}' | 'comment' | 'echo' | 'cdata' | 'yield';

/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/
IDCON:		('a'..'z'|'A'..'Z')+;
NATCON:		'0'..'9'+;

//PATHELEMENT:	!(' '|'\t'|'\n'|'\r'|'.'|'/'|'\\')+;
//FILEEXT:	('a'..'z'|'A'..'Z'|'0'..'9')+;
