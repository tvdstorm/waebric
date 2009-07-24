/*
    Module Waebric
    This module contains the starting point for this language
*/
module Waebric
{
    //Exports to access this grammar outside this one
    export Waebric, Whitespace, Comments;
    
    //Language containing Whitespace definitions
    language Whitespace
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
        syntax Main = "module test";
        
        interleave Whitespace = 
        Whitespace.Whitespace | Comments.Comment;
    }
}