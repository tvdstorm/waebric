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
        token Minus = '-';
        token Amp = '&';
        token Esc_Quote = ('\\' | '\"');
        token Str_Char = ('\n' | '\t' | '\"' | '\\' Digit Digit Digit | '\u0020'..'\u0021' | '\u0023'..'\u005C');
        token Input_Chars = '\u0020'..'\u007F';
        
        //---Text Tokens---
        token Text_Chars = ((Input_Chars + (HT + (CR + LF))) - ('"' + '<'));
        token Text_Char_Ref = '&#' Digit+ ';' | '&#x' (Digit|Letter)+ ';';
        token Text_Entity_Ref = '&' (Letter | '_' | '"') (Letter | Digit | '.' | '-' | '_' | ':')* ';';
        token Text_Char = (Text_Chars | Esc_Quote | Amp | Text_Char_Ref | Text_Entity_Ref);
        
        //---Identifier---
        token IdCon = Letter (Letter | Digit | Minus)*;
        token NatCon = Digit+;
        token SymbolCon = '\'' (Input_Chars - (((')' + Space) + (HT + CR)) + ((LF + ';') + (',' + '>'))))*;  
        token StrCon = '"' Str_Char* '"';   
        
        //---Misc---
        token Text = '"' Text_Char* '"';
        token Filename = '[' ((Input_Chars - (((Space - HT) + (LF + CR)) + ('.' + '\\'))))+ '.' (Digit | Letter)+ ']';
        token Pre_Text = '"' Text_Char* '<';
        token Post_Text = '>' Text_Char* '"';
        token Mid_Text = '>' Text_Char* '<';

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
            = item:ModuleIdentifier
                => ModuleId[item]
            | list: ModuleId "." item:ModuleIdentifier
                => ModuleId[valuesof(list), item];
                
        syntax Module = "module" m:ModuleId e:ModuleElement*
                => Module[m,e];
        
        token  ModuleIdentifier = IdCon;
     
        
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
                => Mapping[valuesof(p), m];  
    
                 
        syntax Path = Filename;      
             
        
        //---Functions---
        syntax FunctionDefinition 
            = "def" i:IdCon f:Formals? "end"
                => FunctionDef[i,f];
        
        syntax Formals = Left_Paren f:Formal? Right_Paren
            => Formals[f];
        
        syntax Formal 
            = item: IdCon
                => [item]
            | list: Formal Comma item: IdCon
                => [valuesof(list), item];
       
        //---Markup---
        token Markup = 'markup("text")';
    }
}