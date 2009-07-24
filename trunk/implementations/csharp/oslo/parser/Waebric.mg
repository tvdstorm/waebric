/*
    Module Waebric
    This module contains the starting point for this language
*/
module Waebric
{
    //Exports to access this grammar outside this one
    export Waebric, Whitespacing, Comments;
    
    //Language containing IdCon
    language IdentifierCon
    {
        token IdCon = Head Tail* ; 
        
        token Head = 'A'..'Z' | 'a'..'z';
        token Tail = Head | '0'..'9';
    }
    
    //Language containing NatCon
    language NaturalCon
    {
        token NatCon = Digits;
        
        token Digits = Digit+;
        token Digit = '0'..'9';
    }
    
    //Language containing StringCon
    language StringCon
    {
        //token StrCon = " StrChar* ";
    }
    
    //Language containing Text
    language Text
    {
    
    }
    
    //Language containing Whitespace definitions
    language Whitespacing
    {
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
        token WhitespaceCharacter =
            '\u0009'   // Horizontal Tab
            | '\u000B' // Vertical Tab
            | '\u000C' // Form Feed
            | '\u0020' // Space
            | NewLine
        ;
    }
    
    //Language containing Comment definitions
    language Comments
    {
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
    }
    
    //Language containing start point of language
    language Waebric
    {
        //Starting symbol
        syntax Main = m:Modules.Module
            => m;
        
        interleave Whitespace = 
        Whitespacing.Whitespace | Comments.Comment;
    }
    
    //Language containg module
    language Modules
    {
        syntax Import = ImportKeyword m:ModuleId
            => Import[m];
        syntax ModuleElement = 
            Import | Sites.Site;
        
        //{IdCon "."}+
        syntax ModuleId 
            = item:ModuleIdentifier
                => ModuleId[item]
            | list: ModuleId "." item:ModuleIdentifier
                => ModuleId[valuesof(list), item];
                
        syntax Module = ModuleKeyword m:ModuleId e:ModuleElement*
                => Module[m,e];
        
        token ModuleIdentifier = IdentifierCon.IdCon;
        
        //Module Keywords
        @{Classification["Keyword"]} final token ModuleKeyword = "module";
        @{Classification["Keyword"]} final token ImportKeyword = "import";
        @{Classification["Keyword"]} final token DefKeyword = "def";
        @{Classification["Keyword"]} final token EndKeyword = "end";
        @{Classification["Keyword"]} final token SiteKeyword = "site";
    }
    
    //Language containing site
    language Sites
    {
        //site {Mapping ";"}* end
        syntax Site = Modules.SiteKeyword m:Mappings* Modules.EndKeyword
            => Site [valuesof(m)];
        
        syntax Mappings 
            = item:Mapping
                => Mappings[item]
            | list: Mapping ";" item:Mapping
                => Mappings[list, item];
        
        //{Path ":" Markup}* -> Mapping
        syntax Mapping 
            = p:Path ":" m:Markups.Markup
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
        
        //{PathElement "/"}+ -> Directory
        syntax Directory 
            = item:PathElement 
                => item
            | list: PathElement "/" item:PathElement
                => [valuesof(list), item];
        syntax Filename = p:PathElement "." f:FileExt
                => Filename[p,f];
               
        syntax Path = Directory "/" Filename | Filename;
        
        token FileExt = FileExtChars+;
        token FileExtChars = 'a'..'z' | 'A'..'Z' | '0'..'9';
    }
    
    //Language containing markup
    language Markups
    {
        token Markup = 'markup()';
    }
}