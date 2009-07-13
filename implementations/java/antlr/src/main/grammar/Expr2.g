grammar Expr2;

options {
    output=AST;
    ASTLabelType=CommonTree;
}

tokens {
    // define pseudo-operations
    FUNC;
    CALL;
}

// START:stat
prog: ( stat )*
    ;

stat:   expr NEWLINE                    -> expr
    |   ID '=' expr NEWLINE             -> ^('=' ID expr)
    |   func NEWLINE                    -> func
    |   NEWLINE                         -> // ignore
    ;

func:   ID  '(' formalPar ')' '=' expr  -> ^(FUNC ID formalPar expr)
    ;

formalPar
    :   ID
	|   INT
	;

// END:stat

// START:expr
expr:   multExpr (('+'^|'-'^) multExpr)*
    ;

multExpr
    :   atom (('*'|'/'|'%')^ atom)*
    ;

atom:   INT
    |   ID
    |   '(' expr ')'    -> expr
    |   ID '(' expr ')' -> ^(CALL ID expr)
    ;
// END:expr

// START:tokens
ID  :   ('a'..'z'|'A'..'Z')+
	;

INT :   '0'..'9'+
    ;

NEWLINE
    :	'\r'? '\n'
    ;

WS  :   (' '|'\t')+ { skip(); }
    ;
// END:tokens
