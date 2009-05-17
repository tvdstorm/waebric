%options ast_directory=./WaebricAst,automatic_ast=toplevel,var=nt,visitor=default
%options fp=WaebricParser,prefix=TK_
%options programming_language=java
%options package=waebricc
%options template=dtParserTemplateD.g
%options import_terminals=ExprLexer.g
%options lalr=2
%options parent_saved

%Terminals
   
    IDENTIFIER
    --PATHELEMENT
    StringLiteral
    IntegerLiteral
    PreText
    MidText
    PostText
    AND_AND
    OR_OR
           
    module 
    site 
    end 
    def 
    if 
    each 
    else 
    let 
    in 
    comment
    echo
    cdata
    yield
    list
    record
    string
    
    LPAREN    ::= '('
    RPAREN    ::= ')'
    LBRACE    ::= '{'
    RBRACE    ::= '}'
    LBRACKET  ::= '['
    RBRACKET  ::= ']'
    SEMICOLON ::= ';'
    COMMA     ::= ','
--    DOLLAR    ::= '$'
    DOT       ::= '.'
    COLON     ::= ':'
    SLASH     ::= '/'
    SHARP     ::= '#'
    EQUAL     ::= '='
    XOR       ::= '^' 
    NOT       ::= '!'
    AND       ::= '&'
	OR        ::= '|'    
    
%End

%Ast
    /.
        public void visitChildren( AbstractResultVisitor v )
        {
            if(leftIToken == rightIToken)
            {
            	if(leftIToken instanceof IAstToken)
            	{
            		((IAstToken)leftIToken).accept( v );
            	}
            	else
            	{
            	    System.out.println("Crap: " + leftIToken.getClass().getName());
            	}    	
            }
            else
            {
            	if(leftIToken instanceof IAstToken)
            	{
            		((IAstToken)leftIToken).accept( v );
            	}
            	else
            	{
            	    System.out.println("Crap: " + leftIToken.getClass().getName());
            	}    	
            	if(rightIToken instanceof IAstToken)
            	{
            		((IAstToken)rightIToken).accept( v );
            	}
            	else
            	{
            	    System.out.println("Crap: " + leftIToken.getClass().getName());
            	}    	
            }
        }
        
    ./
%End

%Start
    Module
%End

%Rules

    Module ::= 'module' ModuleIds ModuleBlockOpt
    
--        /.
--            private String name;
--            
--            void initialize( )
--            {
--                name = new String(getName().toString());
--            }
--        ./   

    ModuleIds$$ModuleId ::= ModuleId '.' ModuleIds | ModuleId
    
    ModuleId ::= Name
        
    ModuleBlockOpt$$ModuleBlock ::= %empty | ModuleBlocks
    
    ModuleBlocks$$ModuleBlock ::= ModuleBlock ModuleBlocks | ModuleBlock
    
    ModuleBlock ::= Function | Site
    
    Site ::= 'site' MappingsOpt 'end'
    
    
    --
    -- Mapping
    -- 
    
    MappingsOpt$$Mapping ::= %empty | Mappings
    
    Mappings$$Mapping ::= Mapping ';' Mappings | Mapping ';'
    
    Mapping ::= Path ':' Markup
    
    --
    -- Path
    --
    
    Path ::= DirNames FileName | FileName
    
    --Pathelement is nog niet correct gedefinieerd.
    FileName ::= 'IDENTIFIER'$Name '.' 'IDENTIFIER'$Extension
    
    DirNames$$DirName ::= DirName DirNames | DirName 
    
    DirName ::= 'IDENTIFIER'$Name '/'
    
    --
    -- Markup
    --
    
    Markup ::= Designator ArgumentsOpt
    MarkupOpt$$Markup ::= %empty | Markups
    Markups$$Markup ::= Markups Markup | Markup
    
    ArgumentsOpt$$Argument ::= '(' ')' | '(' Arguments ')'
    
    Arguments$$Argument ::= Argument ',' Arguments | Argument
    
    Argument ::= Var '=' Expression | Expression
        
    
    --
    -- Expression
    --
    
    ExpressionOpt$$Expression ::= %empty | Expressions
    
    Expressions$$Expression ::= Expression ',' Expressions | Expression
    
    Expression ::= Var | ExpressionString | ExpressionCollection | ExpressionPair | ExpressionConstant
    
    ExpressionString ::= 'StringLiteral'$String 
    
    ExpressionConstant ::= 'IntegerLiteral'$IntegerString
    
    --ExpressionMember ::= Expression '.' 'IDENTIFIER'$Member
    
    ExpressionCollection ::= '[' ExpressionOpt ']'
    
    ExpressionPair ::= '{' KeyValuePairOpt '}'
    
    
    -- 
    -- KeyValuePair
    --
    
    KeyValuePairOpt$$KeyValuePair ::= %empty | KeyValuePairs
    
    KeyValuePairs$$KeyValuePair ::= KeyValuePair ',' KeyValuePairs | KeyValuePair
    
    KeyValuePair ::= 'IDENTIFIER'$Key ':' Expression
    
    --
    -- Embedding
    --
   
    Embedding ::= 'PreText' Embed TextTail
    TextTail ::= 'MidText' Embed TextTail | 'PostText'
    Embed ::= MarkupOpt Expression
    
    --
    -- Statememt
    --
        
    Statement ::= StatementEach | StatementLet | StatementComment | StatementBlock | StatementEchoExpression | StatementEchoEmbedding | StatementCData | StatementYield | StatementIf | StatementMarkup
    
    StatementIf ::= 'if' '(' Predicate ')' Statement StatementElseOpt
    
    StatementElseOpt ::= %empty | 'else' Statement
    
    StatementEach ::= 'each' '(' Var ':' Expression ')' Statement 
    
    StatementLet ::= 'let' Assignments 'in' StatementOpt 'end'
    
    StatementBlock ::= '{' StatementOpt '}'
    StatementOpt$$Statement ::= %empty | Statements
    Statements$$Statement ::= Statement Statements | Statement
    
    -- TODO: fix StringLiteral
    
    StatementComment ::= 'comment' ExpressionString ';'
    StatementEchoExpression ::= 'echo' Expression ';'
    StatementEchoEmbedding ::= 'echo' Embedding ';'
    StatementCData ::= 'cdata' Expression ';'
    StatementYield ::= 'yield' ';'
    
    StatementMarkup ::= Markup ";"

	--
	-- Type
	--
	
	Type ::= 'list' | 'record' | 'string'
	
    --
    -- Predicate
    --	
    
    Predicate ::= Expression | Expression '.' Type
    
    Predicate ::= '!' Predicate
    -- can not place 2 token next to each other
    Predicate ::= '(' Predicate ')' 'AND_AND'$AndPredicate '(' Predicate ')'
    Predicate ::= '(' Predicate ')' 'OR_OR'$OrPredicate '(' Predicate ')'
    
    --
    -- Var
    --
    
    Var ::= 'IDENTIFIER'$Name
    
    -- 
    -- Assignment
    --
    
    Assignments$$Assignment ::= Assignment Assignments | Assignment
    Assignment ::= Var '=' Expression ';'
    --
    -- Designator
    --
    -- TODO: designator seems not to be completed? (IdCon...)
    Designator ::= 'IDENTIFIER'$Name AttributeOpt
    
    -- 
    -- Attribute
    --
    
    AttributeOpt$$Attribute ::= %empty | Attributes
    
    Attributes$$Attribute ::= Attribute Attributes | Attribute
    
    Attribute ::= '#' 'IDENTIFIER'$Name
    --Attribute ::= '.' 'IDENTIFIER'$Name
    --Attribute ::= '$' 'IDENTIFIER'$Name
    --Attribute ::= ':' 'IDENTIFIER'$Name
    --Attribute ::= '@' 'IDENTIFIER' iets met natcon
    --Attribute ::= '@' 'IDENTIFIER' iets met natcon
    
    
           
    Function ::= 'def' 'IDENTIFIER'$Name '(' ParameterDeclOpt ')' StatementOpt 'end'
    
    ParameterDeclOpt$$ParameterDecl ::= %empty | ParameterDecls
    
    ParameterDecls$$ParameterDecl ::= ParameterDecl ',' ParameterDecls | ParameterDecl
    
    ParameterDecl ::= Name
    
    Name ::= 'IDENTIFIER'$Name
    
    
%End            