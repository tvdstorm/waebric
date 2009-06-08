/* --------------------------Usercode Section------------------------ */
package waebric;

import beaver.Symbol;
import beaver.Scanner;

import waebric.WaebricParser.Terminals;
%%

/* -----------------Options and Declarations Section----------------- */

/*
   The name of the class JFlex will create will be Lexer.
   Will write the code to the file Lexer.java.
*/
%class WaebricLexer
%extends Scanner

/*
  The current line number can be accessed with the variable yyline
  and the current column number with the variable yycolumn.
*/
%line
%column

%yylexthrow Scanner.Exception

%function nextToken
%type Symbol

%eofval{
	return nextToken(Terminals.EOF, "end-of-file");
%eofval}


/*
  Declarations

  Code between %{ and %}, both of which must be at the beginning of a
  line, will be copied letter to letter into the lexer class source.
  Here you declare member variables and functions that are used inside
  scanner actions.
*/
%{
	StringBuffer string = new StringBuffer(128);
	private Symbol nextToken(short id)
	{
		return new Symbol(id, yyline + 1, yycolumn + 1, yylength());
	}

	private Symbol nextToken(short id, Object value)
	{
		return new Symbol(id, yyline + 1, yycolumn + 1, yylength(), value);
	}

%}


/*
  Macro Declarations

  These declarations are regular expressions that will be used latter
  in the Lexical Rules Section.
*/

/* A line terminator is a \r (carriage return), \n (line feed), or
   \r\n. */
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]

/* White space is a line terminator, space, tab, or line feed. */
WhiteSpace     = {LineTerminator} | [ \t\f]

/* comments */
Comment = {TraditionalComment} | {EndOfLineComment} |
          {DocumentationComment}

TraditionalComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/*" "*"+ [^/*] ~"*/"

/* A literal integer is is a number beginning with a number between
   one and nine followed by zero or more numbers between zero and nine
   or just a zero.  */
Natcon = [0-9]+

/* A identifier integer is a word beginning a letter between A and
   Z, a and z, or an underscore followed by zero or more letters
   between A and Z, a and z, zero and nine, or an underscore. */
dec_int_id = [A-Za-z_.][A-Za-z_0-9.]*

TextChar = [^\x00-\x1F\&\"\<\x80-\xFF]
SymbolChar = [^\x00-\x1F\)\ \t\n\r\;\,\>\x80-\xFF]


TextCharRef = "&#" [0-9]+ ";" 
TextCharRef = "&#x" [0-9a-fA-F]+ ";"
TextEntityRef  = "&" [a-zA-Z\_\:] [a-zA-Z0-9\.\-\_\:]* ";" 
FileExt = [a-zA-Z0-9]+
PathElement = [^\ \t\n\r\.\/\\]+
Directory = {PathElement} ("/" {PathElement})* 


LetterDigit = [:jletterdigit:]

/* string literals */
StringCharacter = [^\r\n\"\\]


/* identifiers */
Identifier = [A-Za-z][A-Za-z\-0-9]*

SiteFilename = {PathElement} "." {FileExt}




%state SITE,STRING,STRCON,STRCON_INIT, PRETEXT, POSTMIDTEXT

%%
/* ------------------------Lexical Rules Section---------------------- */

/*
   This section contains regular expressions and actions, i.e. Java
   code, that will be executed when the scanner matches the associated
   regular expression. */

   /* YYINITIAL is the state at which the lexer begins scanning.  So
   these regular expressions will only be matched if the scanner is in
   the start state YYINITIAL. */

<YYINITIAL> {
  /* keywords */
  "module"                         { return nextToken(Terminals.MODULE); }
  "import"                         { return nextToken(Terminals.IMPORT); }  
  "def"                            { return nextToken(Terminals.DEF); }
  "end"                            { return nextToken(Terminals.END); }
  "site"                           { yybegin(SITE);  return nextToken(Terminals.SITE); }
  "list"                           {  return nextToken(Terminals.LIST); }
  "record"                         {  return nextToken(Terminals.RECORD); }
  "string"                         {  return nextToken(Terminals.STRING); }
  "if"                             {  return nextToken(Terminals.IF); }
  "comment"                        { string.setLength(0); yybegin(STRCON_INIT);  return nextToken(Terminals.COMMENT);  }
  "echo"                           { return nextToken(Terminals.ECHO); }
  "cdata"                          { return nextToken(Terminals.CDATA); }
  "each"                           {  return nextToken(Terminals.EACH); }
  "let"                            {return nextToken(Terminals.LET); }
  "yield"                          { return nextToken(Terminals.YIELD); }

   "\""                        { string.setLength(0); string.append( '\"' ); yybegin(PRETEXT); }
   ">"                        { string.setLength(0);string.append( '>' ); yybegin(POSTMIDTEXT); }



   
 
    
  /* separators and operators*/
//  "&#x"                          { return nextToken(Terminals.TEXTCHARREF); }
//  "&#"                           { return nextToken(Terminals.TEXTCHARREF); }  
  
  "("                            { return nextToken(Terminals.LPAREN); }
  ")"                            { return nextToken(Terminals.RPAREN); }
  "{"                            { return nextToken(Terminals.LBRACE); }
  "}"                            { return nextToken(Terminals.RBRACE); }
  "["                            { return nextToken(Terminals.LBRACK); }
  "]"                            { return nextToken(Terminals.RBRACK); }
  ";"                            { return nextToken(Terminals.SEMICOLON); }
  ","                            { return nextToken(Terminals.COMMA); }
  "."                            { return nextToken(Terminals.DOT); }
  ":"                            { return nextToken(Terminals.COLON); }
  "%"                            { return nextToken(Terminals.MOD); }
  "@"                            { return nextToken(Terminals.ADDCHAR); }    
  "$"                            { return nextToken(Terminals.DOLLAR); }    
  "#"                            { return nextToken(Terminals.HASH); }  
  "/"                            { return nextToken(Terminals.DIV); }
  "?"                            { return nextToken(Terminals.QUESTION); }
  "!"                            { return nextToken(Terminals.NOT); }
  "&&"                           { return nextToken(Terminals.ANDAND); }
  "||"                           { return nextToken(Terminals.OROR); }
  "="                            { return nextToken(Terminals.EQ); }
  
  "'" {SymbolChar}*              { return nextToken(Terminals.SYMBOLCON, yytext() );}

  /* string literal */
//  \"                             { yybegin(STRING); string.setLength(0); }


  /* comments */
  {Comment}                      { /* ignore */ }

  /* whitespace */
  {WhiteSpace}                   { /* ignore */ }

  /* identifiers */
  {Identifier}                   { return nextToken(Terminals.IDCON, yytext()); }  
  
  /* identifiers */
  "<"{Identifier}                 { String temp = yytext(); return nextToken(Terminals.IDCONDESIGNATOR, temp.substring(1) ); } 
  
  /* identifiers */
  {Identifier}/">"                 { return nextToken(Terminals.IDCONTAIL, yytext()); } 
    
  /* Natural numbers*/
  {Natcon}                       { return nextToken(Terminals.NATCON, yytext()); }  

}

<SITE> {
  {Directory} /"/"               { return nextToken(Terminals.DIRNAME,yytext() ); }
  "/"                            { return nextToken(Terminals.DIV); }
  "end"                          { yybegin(YYINITIAL); return nextToken(Terminals.END ); }
  {SiteFilename}                 { yybegin(YYINITIAL); return nextToken(Terminals.FILENAME,yytext() ); }
 
  /* comments */
  {Comment}                      { /* ignore */ }

  /* whitespace */
  {WhiteSpace}                   { /* ignore */ }
    
}

<STRCON_INIT> {
  "\""                           { yybegin(STRCON);  }
   /* comments */
  {Comment}                      { /* ignore */ }

  /* whitespace */
  {WhiteSpace}                   { /* ignore */ }
}

<STRCON> {

  "\""                           { yybegin(YYINITIAL); return nextToken(Terminals.STRCON, string.toString() ); }	
  "\\t"                          { string.append( '\t' ); }
  "\\n"                          { string.append( '\n' ); }
  "\\\""                         { string.append( '\"' ); }
  "\\\\"                         { string.append( '\\' ); }
  "\\" [0-9][0-9][0-9]           { String temp = yytext(); string.append( temp.substring(1) ); }
  [^\x00-\x1F\n\t\"\\]           { string.append( yytext() ); }
}


<PRETEXT> {
	{TextChar}					{  string.append( yytext() ); }
	{TextChar}/"<"              {  yybegin(YYINITIAL); string.append(  yytext() + '<' );  return nextToken(Terminals.PRETEXT,  string.toString() ); }
}

<POSTMIDTEXT> {
	{TextChar} 					{ string.append( yytext() ); }
	"\""                        {  yybegin(YYINITIAL);  string.append( '\"' );  return nextToken(Terminals.POSTTEXT, string.toString() ); }
	{TextChar}/"<"             	{  yybegin(YYINITIAL);  string.append( yytext() + '<' );  return nextToken(Terminals.MIDTEXT,  string.toString() ); }
}



/* No token was found for the input so through an error.  Print out an
   Illegal character message with the illegal character that was found. */
[^]                    { throw new Scanner.Exception("Illegal character <"+yytext()+">"); }
