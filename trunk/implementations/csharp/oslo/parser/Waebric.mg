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
        //token Input_Chars = '\u0020'..'\u007F';
        
        //---Text Tokens---
        token EscQuote = '\\' '\"' => '\\\"';
        token Text_Char_Ref = '&#' Digit+ ';' | '&#x' HexaDecimal+ ';';
        token Text_Entity_Ref = '&' (Letter | '_' | '"') (Letter | Digit | '.' | '-' | '_' | ':')* ';';
        token Text_Char = (TextSymbolChar | Amp | Text_Char_Ref | Text_Entity_Ref | Space | CR | LF | HT);
        token TextSymbolChar = ('\u0020'..'\u0021' | '\u0023'..'\u0025' | '\u0027'..'\u003B' | '\u003D'..'\u007E');
        token Text = '"' t:(Text_Char | EscQuote)* '"' => t;        
        
        //---Identifier---
        token IdCon = Letter (Letter | Digit | Minus)*;
        token NatCon = Digit+;
        token SymbolCon = "'" s:SymbolChar* => s;
        token SymbolChar = ('\u0021'..'\u0028' | '\u002A'..'\u002B' | '\u002D'..'\u003A' | '\u003C'..'\u003D' | '\u003F'..'\u005C' | '\u005E'..'\u007C' | '\u007E'..'\u007F');
        token StrCon = '"' s:Str_Char* '"' => s;   
        
        //---Path---
        //token PathChar = ('\u0021'..'\u0029' | '\u002B'..'\u002D' | '\u0030'..'\u0039' | '\u003B' | '\u003D' | '\u0040'..'\u005B' | '\u005D'..'\u007B' | '\u007D'..'\u007F');
        token PathChar = ('\u0021'..'\u002D' | '\u002F'..'\u005A' | '\u005E'..'\u007E');
        /*token PathElement = PathChar+ "/";
        token Directory = PathElement+;*/
        //token FileExt = (Letter | Digit)+;
        //token PathChar = ('\u0021'..'\u002D');
        token Filename = ('/' | './')  PathChar+ ^('/') '.' (Letter | Digit)+;
        
        //token Filename = '[' ((Input_Chars - (((Space - HT) + (LF + CR)) + ('.' + '\\'))))+ '.' (Digit | Letter)+ ']';
        
        //---Misc---       
        //token IdList = IdCon ("." IdCon)*;

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
        syntax ModuleId  
            = item:IdCon
                => ModuleId[item]
            | list: ModuleId "." item:IdCon
                => ModuleId[valuesof(list), item];
                
        syntax Module = "module" m:ModuleId e:ModuleElement*
                => Module[m,valuesof(e)];
     
        //---Sites---
        //site {Mapping ";"}* end
        syntax Site = "site" m:Mappings "end"
            => Site [valuesof(m)];
        
        //{Mapping ";"}
        syntax Mappings
            = item:Mapping
                => Mappings[item]
            | list: Mappings ";" item:Mapping
                => Mappings[valuesof(list), item];
        
        //{Path ":" Markup}* -> Mapping
        syntax Mapping
            = p:Filename ":" m:Markup
                => Mapping[p, m];   
            
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
            = Statement_No_Markup
            | m:MarkupList s:Statement_No_Markup
                => MarkupStatStatement[m,s]
            | Statement_Markup_No_Statement;
            
        syntax Statement_No_Markup
            = "each" "(" i:IdCon ":" e:Expression ")" s:Statement
                => EachStatement[i,e,valuesof(s)]
            | precedence 2: "if" "(" p:Predicate ")" ts:Statement
                => IfStatement[p,valuesof(ts)]
            | precedence 1: "if" "(" p:Predicate ")" ts:Statement_No_Short_If "else" fs:Statement
                => IfElseStatement[p,valuesof(ts),valuesof(fs)]
            | Statement_No_Markup_No_Short_If;
        
        syntax Statement_No_Short_If
            = Statement_No_Markup_No_Short_If
            | Statement_Markup_No_Statement
            | "if" "(" p:Predicate ")" ts:Statement_No_Short_If "else" fs:Statement_No_Short_If 
                => IfElseStatement[p,valuesof(ts),valuesof(fs)];
        
        syntax Statement_Markup_No_Statement
            = m:Markup ";"
                => MarkupStatement[m]
            | MarkupStatement
           // | ml:MarkupList m:MarkupCall ";"
           //     => MarkupMarkupStatement[ml, m]
           // | ml:MarkupList e:Expression ";"
           //     => MarkupExpressionStatement[ml, e]
            | ml:Markup+ e:Embedding ";"
               => MarkupEmbeddingStatement[ml,e];
                
        syntax MarkupStatement 
            = ml:MarkupList me:MarkupExpression ";" 
                => MarkupStatement[ml, me]
            | m:Markup ";"
                => MarkupStatement[m];        
        syntax MarkupExpression 
            = d:Designator a:Arguments 
                => [d,a]
            | e:Expression
                => [e];
        
        syntax Statement_No_Markup_No_Short_If 
            = "let" a:Assignment+ "in" s:Statement* "end"
                => LetStatement[a,s]
            | "{" s:Statement* "}"
                => BlockStatement[s]
            | "comment" t:Text ";"
                => CommentStatement[t]
            | "echo" e:Expression ";"
                => EchoExpressionStatement[e]
            | "echo" e:Embedding ";"
                => EchoEmbeddingStatement[e]
            | "cdata" e:Expression ";"
                => CDataStatement[e]
            | "yield" ";"
                => YieldStatement[];
                
        syntax MarkupList
            = item:Markup
                => MarkupList[item]
            | list:MarkupList item:Markup
                => MarkupList[valuesof(list),item];
        
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
        
        syntax NotPredicate 
            = Exclam_Mark p:Predicate
                => NotPredicate[p];
                
        syntax AndPredicate 
            = l:Predicate And r:Predicate
                => AndPredicate[l,r];
        
        syntax OrPredicate 
            = l:Predicate Or r:Predicate
                => OrPredicate[l,r]; 
        
        syntax IsAPredicate 
            = e:Expression ":" t:Type "?"
                => IsAPredicate[e,t];
        
        syntax Type = "string" | "record" | "list";

        //---Expressions---
        syntax Expression 
            = Expression_No_Plus
            | l:Expression "+" r:Expression_No_Plus 
                => CatExpression[l,r];
                
        syntax Expression_No_Plus 
            = i:IdCon
                => VarExpression[i]
            | Expression_No_Var;
        
        syntax Expression_No_Var
            = t:Text
                => TextExpression[t]
            | s:SymbolCon 
                => SymbolExpression[s]
            | n:NatCon
                => NatExpression[n]
            | e:Expression_No_Plus "^" i:IdCon
                => FieldExpression[e,i]
            | "[" e:ExpressionList? "]"
                => ListExpression[valuesof(e)]
            | "{" k:KeyValuePairList? "}"
                => RecordExpression[valuesof(k)];
         
        syntax ExpressionList
            = item:Expression
                => [item]
            | list:ExpressionList "," item:Expression
                => [valuesof(list), item];
                
        syntax KeyValuePairList
            = item:KeyValuePair
                => [item]
            | list:KeyValuePairList "," item:KeyValuePair
                => [valuesof(list), item];
        
        syntax KeyValuePair
            = i:IdCon ":" e:Expression
                => KeyValuePair[i,e];
       
        //---Markup---
        syntax Markup 
            = MarkupCall
            | d:Designator
                => MarkupTag[d];
        syntax MarkupCall 
            = d:Designator a:Arguments
                => MarkupCall[d,a];
        
        syntax Arguments 
            = "(" a:ArgumentList? ")"
                => Arguments[a];
                
        syntax ArgumentList 
            = item: Argument
                => [item]
            | list:ArgumentList "," item:Argument
                => [valuesof(list), item];
        
        syntax Argument 
            = i:IdCon "=" e:Expression
                => AttrArgument[i,e]
            | e:Expression
                => ExpressionArgument[e];        
        
        syntax Designator 
            = i:IdCon a:Attribute*
                => Designator[i,Attributes[valuesof(a)]];
        
        syntax Attribute
            = "#" i:IdCon
                => IdAttribute[i]
            | "." i:IdCon
                => ClassAttribute[i]
            | "$" i:IdCon
                => NameAttribute[i]
            | ":" i:IdCon
                => TypeAttribute[i]
            | "@" w:NatCon "%" h:NatCon
                => WidthHeigthAttribute[w,h]
            | "@" w:NatCon
                => WidthAttribute[w];
                
        //---Embedding---
        syntax Embedding 
            = p:Pre_Text e:Embed t:TextTail
                => Embedding[p,e,t];
        
        syntax Embed 
            = Markup+ MarkupCall
            | Markup+ Expression;
            
        syntax TextTail 
            = Post_Text
            | Mid_Text Embed TextTail;
  
    }
}