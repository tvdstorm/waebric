/*
    Module Waebric
    This module contains the starting point for this language
*/
module Waebric
{
    export Waebric;
    
    
    language Waebric
    {
               
        //---Comments---
        @{Classification["Comment"]}
        token Comment = CommentMultipleLine | CommentLine;
        
        token CommentLine = "//" CommentLineContent*;
        
        token CommentLineContent = ^(
                '\u000A' | // New Line
                '\u000D' | // Carriage Return
                '\u0085' | // Next Line
                '\u2028' | // Line Separator
                '\u2029') // Paragraph Separator
        ;
        token CommentMultipleLine = "/*" CommentMultipleLineContent* "*/";
        token CommentMultipleLineContent = 
            ^('*') 
            | '*'  ^('/')
        ;
        
        //---WhiteSpace---
        token NewLine =
            '\u000A'   // New Line
            | '\u000D' // Carriage Return
            | '\u000D' '\u000A' 
            | '\u0085' // Next Line
            | '\u2028' // Line Separator
            | '\u2029' // Paragraph Separator
        ;

        @{Classification["Whitespace"]}
        token Whitespace = WhitespaceCharacter+;
        token CR = '\u000D';    //Carriage Return
        token LF = '\u000A';    //Line Feed
        token HT = '\u0009';    //Horizontal Tab
        token VT = '\u000B';    //Vertical Tab
        token FF = '\u000C';    //Form Feed
        token Space = '\u0020'; //Space
        token Spaces = Space* | HT*;
        
        
        token WhitespaceCharacter =
            HT   // Horizontal Tab
            | VT // Vertical Tab
            | FF // Form Feed
            | Space // Space
            | NewLine
        ;     
        
        //---Separators---
        token Left_Paren = '(';
        token Right_Paren = ')';
        token Left_Brace = '{';
        token Right_Brace = '}';
        token Left_Bracket = '[';
        token Right_Bracket = ']';
        token Semi_Colon = ';';
        token Comma = ',';
        token Dot = '.';
        token Caret = '^';
        token Number_Sign = '#';
        token Dollar_Sign = '$';
        token At_Sign = '@';
        token Percent_Sign = '%';
        token Question_Mark = '?';
        token Exclam_Mark = '!';
        token And = '&&';
        token Or = '||';
           
        //---Operators---
        token Colon = ':';
        token Assign = '=';
        token Slash = '/';
        token Plus = '+';
        
        //---Helping Tokens---
        token Letter = 'a'..'z' | 'A'..'Z';
        token Digit = '0'..'9';
        token HexaDecimal = '0'..'9' | 'A'..'F' | 'a'..'f';
        token Minus = '-';
        token Amp = '&';
        token Esc_Quote = ('\\' | '\"');
        token Str_Char = ('\n' | '\t' | '\"' | '\\' Digit Digit Digit | '\u0020'..'\u0021' | '\u0023'..'\u005C');
        token Input_Chars = '\u0020'..'\u007F';
        
        //---Text Tokens---
        token EscQuote = '\\' '\"' => '\\\"';
        token Text_Char_Ref = '&#' Digit+ ';' | '&#x' HexaDecimal+ ';';
        token Text_Entity_Ref = '&' (Letter | '_' | '"') (Letter | Digit | '.' | '-' | '_' | ':')* ';';
        token Text_Char = (TextSymbolChar | Amp | Text_Char_Ref | Text_Entity_Ref | Space);
        token TextSymbolChar = ('\u0020'..'\u0021' | '\u0023'..'\u0025' | '\u0027'..'\u003B' | '\u003D'..'\u007E');
        token Text = '"' t:(Text_Char | EscQuote)* '"' => t;        
        
        //---Identifier---
        token IdCon = Letter (Letter | Digit | Minus)*;
        token NatCon = Digit+;
        token SymbolCon = "'" s:SymbolChar* => s;
        token SymbolChar = ('\u0021'..'\u0028' | '\u002A'..'\u002B' | '\u002D'..'\u003A' | '\u003C'..'\u003D' | '\u003F'..'\u005C' | '\u005E'..'\u007C' | '\u007E'..'\u007F');
        token StrCon = '"' s:Str_Char* '"' => s;   
        
        //---Path---
        token PathChar = ('\u0021'..'\u002D' | '\u0030'..'\u005B' | '\u005D'..'\u007E');
        token PathElement = PathChar+ "/";
        token Directory = PathElement+;
        token FileExt = (Letter | Digit)+;
        token Filename = PathChar+ "." FileExt;
        
        //---Misc---       
        token IdList = IdCon ("." IdCon)*;

        //token Filename = '[' ((Input_Chars - (((Space - HT) + (LF + CR)) + ('.' + '\\'))))+ '.' (Digit | Letter)+ ']';
        token Pre_Text = '"' t:Text_Char* '<';
        token Post_Text = '>' t:Text_Char* '"';
        token Mid_Text = '>' t:Text_Char* '<';

        //---Keyword Tokens---
        @{Classification["Keyword"]} token ModuleKeyword = "module";
        @{Classification["Keyword"]} token ImportKeyword = "import";
        @{Classification["Keyword"]} token DefKeyword = "def";
        @{Classification["Keyword"]} token EndKeyword = "end";
        @{Classification["Keyword"]} token SiteKeyword = "site";
        @{Classification["keyword"]} token EchoKeyword = "echo";
        @{Classification["keyword"]} token EachKeyword = "each";
        @{Classification["keyword"]} token IfKeyword = "if";
        @{Classification["keyword"]} token ElseKeyword = "else";
        @{Classification["keyword"]} token YieldKeyword = "yield";
        @{Classification["keyword"]} token LetKeyword = "let";
        @{Classification["keyword"]} token CommentKeyword = "comment";
        @{Classification["keyword"]} token CDataKeyword = "cdata";
        @{Classification["keyword"]} token String = "string";
        @{Classification["keyword"]} token Record = "record";
        @{Classification["keyword"]} token List = "list";
        
        //---Waebric---
        //Starting symbol
        syntax Main 
            = m:Module
                => m;
        
        interleave Skippable 
            = Whitespace | Comment;
    
        //---Modules---
        syntax Import 
            = "import" m:ModuleId
                => Import[m];
        
        syntax ModuleElement 
            = Import | Site | FunctionDefinition;
        
        //{IdCon "."}+
        syntax ModuleId = IdList;
            /*= item:ModuleIdentifier
                => ModuleId[item]
            | list: ModuleId "." item:ModuleIdentifier
                => ModuleId[valuesof(list), item];*/
                
        syntax Module = "module" m:ModuleId e:ModuleElement*
                => Module[m,valuesof(e)];
        
        //token  ModuleIdentifier = IdCon;
     
        
        //---Sites---
        //site {Mapping ";"}* end
        syntax Site = "site" m:Mappings* "end"
            => Site [valuesof(m)];
        
        //{Mapping ";"}
        syntax Mappings
            = item:Mapping
                => Mappings[item]
            | list: Mappings ";" item:Mapping
                => Mappings[valuesof(list), item];
        
        //{Path ":" Markup}* -> Mapping
        syntax Mapping 
            = p:Path ":" m:Markup
                => Mapping[p, m];  
    
                 
        syntax Path 
            = d:Directory f:Filename 
               => Path[d,f]
            | f:Filename
                => Path[f];      
            
        //---Functions---
        syntax FunctionDefinition 
            = "def" i:IdCon f:Formals? s:Statement* "end"
                => FunctionDef[i,f,Statements[valuesof(s)]];
        
        syntax Formals = "(" f:Formal? ")"
            => Formals[valuesof(f)];
        
        syntax Formal 
            = item: IdCon
                => [item]
            | list: Formal "," item: IdCon
                => [valuesof(list), item];
       
        //---Statements
        syntax Statement 
            = IfStatement
            | IfElseStatement
            | EachStatement
            | LetStatement
            | BlockStatement
            | EchoStatement
            //| EchoEmbeddingStatement
            | CommentStatement
            | CDataStatement
            | YieldStatement;
        
        syntax IfStatement 
            = "if" "(" p:Predicate ")" t:Statement
                => IfStatement[p,t];
        
        syntax IfElseStatement 
            = "if" "(" p:Predicate ")" t:Statement "else" f:Statement
                => IfElseStatement[p,t,f];
        
        syntax EachStatement 
            = "each" "(" i:IdCon ":" e:Expression ")" s:Statement
               => EachStatement[i,e,s];
               
        syntax LetStatement 
            = "let" a:Assignment+ "in" s:Statement* "end"
                => LetStatement[a,s];
                
        syntax BlockStatement = "{" s:Statement* "}" => BlockStatement[valuesof(s)];
        //syntax EchoEmbeddingStatement = "echo" e:Embedding ";";
        syntax EchoStatement = "echo" e:Expression ";" => EchoStatement[e];
        syntax CommentStatement = "comment" c:StrCon ";" => CommentStatement[c];
        syntax CDataStatement = "cdata" e:Expression ";" => CDataStatement[e];
        syntax YieldStatement = "yield" ";" => YieldStatement[];
        
        syntax Assignment 
                = FuncBindAssignment
                |VarBindAssignment
                ;
                
        syntax VarBindAssignment 
            = i:IdCon "=" e:Expression ";"
                => VarBindAssignment[i,e];
                
        syntax FuncBindAssignment 
            = i:IdCon f:Formals "=" s:Statement ";"
                => FuncBindAssignment[i,f,s];
        
        //---Predicates---
        syntax Predicate 
            = NotPredicate
            | AndPredicate
            | OrPredicate
            | IsAPredicate
            | Expression;
        
        syntax NotPredicate = Exclam_Mark Predicate;
        syntax AndPredicate = Predicate And Predicate;
        syntax OrPredicate = Predicate Or Predicate; 
        syntax IsAPredicate = Expression "." Type "?";
        
        syntax Type = "string" | "record" | "list";

        //---Expressions---
        syntax Expression
            = //FieldExpression
             TextExpression
            | CatExpression
            | TextExpression
            | VarExpression
            | NatExpression
            | SymbolExpression
            | ListExpression
            | RecordExpression;
        
        //syntax FieldExpression = Expression "." IdCon ^('?');
        syntax TextExpression = Text;
        
        syntax SymbolExpression 
            = s:SymbolCon
                => SymbolExpression[s];
        
        syntax VarExpression 
            = i:IdCon
                => VarExpression[i];
        
        syntax NatExpression 
            = n:NatCon
                => NatExpression[n];
        
        syntax CatExpression 
            = l:Expression "+" r:Expression;
        
        syntax ListExpression
            = "[" e:ExpressionList* "]"
                => ListExpression[valuesof(e)];
        
        syntax ExpressionList 
            = item: Expression
                => Expressions[item]    
            | list:ExpressionList "," item:Expression
                => Expressions[valuesof(list),item];
            
        syntax RecordExpression
            = "{" r:RecordList* "}"
                => RecordExpression[valuesof(r)];
        
        syntax RecordList 
            = item : KeyValuePair
                => Records[item]
            | list: RecordList "," item:KeyValuePair
                => Records[valuesof(list),item];     
            
        syntax KeyValuePair 
            = i:IdCon ":" e:Expression
                => KeyValuePair[i,e];
       
        //---Markup---
        
    }
}