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
        token HT = '\u0009';
        token VT = '\u000B';
        token FF = '\u000C';
        token Space = '\u0020';
        
        
        token WhitespaceCharacter =
            HT   // Horizontal Tab
            | VT // Vertical Tab
            | FF // Form Feed
            | Space // Space
            | NewLine
        ;        
        
        //---IdCon---
        token IdCon = Head Tail*; 
        
        token Head = 'A'..'Z' | 'a'..'z';
        token Tail = Head | '0'..'9';
    
        //---NatCon---
        token NatCon = Digits;
        
        token Digits = Digit+;
        token Digit = '0'..'9';
        
        //---Waebric---
        //Starting symbol
        syntax Main = m:Module
            => m;
        
        interleave Skippable = 
        Whitespace | Comment;
    
        //---Modules---
        syntax Import = "import" m:ModuleId
            => Import[m];
        syntax ModuleElement = 
            Import | Site;// | Functions.FunctionDef;
        
        //{IdCon "."}+
        syntax ModuleId 
            = item:ModuleIdentifier
                => ModuleId[item]
            | list: ModuleId "." item:ModuleIdentifier
                => ModuleId[valuesof(list), item];
                
        syntax Module = "module" m:ModuleId e:ModuleElement*
                => Module[m,e];
        
        token ModuleIdentifier = IdCon;        
        
        //---Sites---
        //site {Mapping ";"}* end
        syntax Site = "site" m:Mappings* "end"
            => Site [valuesof(m)];
        
        //
        syntax Mappings
            = item:Mapping
                => Mappings[item]
            | list: Mapping ";" item:Mapping
                => Mappings[list, item];
        
        //{Path ":" Markup}* -> Mapping
        syntax Mapping 
            = p:Path ":" m:Markup
                => Mapping[p, m];  
        
        // ~[\ \t\n\r\.\/\\]+
        token PathElement = ^(
                '\u0020' | // Space Character
                '\u0009' | // Horizontal tab
                '\u000A' | // New Line
                '\u000D' | // Carriage Return
                '\u002E' | // Point
                '\u005C' | // Backslash
                '\u002F')+ // Slash
        ;
                 
        token Directory
                = item:PathElement
                    => item
                | list:PathElement "/" item:PathElement
                    => [list, item]
        
        ;
        
        token Filename = PathElement "." FileExt;
               
        token Path = Directory "/" Filename | Filename;

        token FileExt = FileExtChars+;
        token FileExtChars = 'a'..'z' | 'A'..'Z' | '0'..'9';
        
        //---Markup---
        token Markup = 'markup()';
        
        
        
        //---Keyword Tokens---
        @{Classification["Keyword"]} final token ModuleKeyword = "module";
        @{Classification["Keyword"]} final token ImportKeyword = "import";
        @{Classification["Keyword"]} final token DefKeyword = "def";
        @{Classification["Keyword"]} final token EndKeyword = "end";
        @{Classification["Keyword"]} final token SiteKeyword = "site";
        @{Classification["keyword"]} final token EchoKeyword = "echo";
        @{Classification["keyword"]} final token EachKeyword = "each";
        @{Classification["keyword"]} final token IfKeyword = "if";
        @{Classification["keyword"]} final token ElseKeyword = "else";
        @{Classification["keyword"]} final token YieldKeyword = "yield";
        @{Classification["keyword"]} final token LetKeyword = "let";
        @{Classification["keyword"]} final token CommentKeyword = "comment";
        @{Classification["keyword"]} final token CDataKeyword = "cdata";
        @{Classification["keyword"]} final token String = "string";
        @{Classification["keyword"]} final token Record = "record";
        @{Classification["keyword"]} final token List = "list";
    }

    
    //language containing functions
    /*language Functions
    {
        //"def" IdCon Formals Statement* "end" -> FunctionDef
        syntax FunctionDef = Modules.DefKeyword i:IdentifierCon.IdCon f:FormalDef? Modules.EndKeyword
            => FunctionDef[i];
                              
        syntax FormalDef = "()" | "(" Formals ")";
        
        syntax Formals 
            = item:IdentifierCon.IdCon
                => item
            | list:IdentifierCon.IdCon "," item:IdentifierCon.IdCon
                => [valuesof(list), item];        
    }*/
    
    //language containing statements
    /*language Statements
    {
        syntax Statement = "stmt";
    }*/
   
}