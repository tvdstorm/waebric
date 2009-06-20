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
	boolean bDEF = false;
	boolean bSITE = false;

      int bLETFALSE=0;
	int bLETBEFOREIN=1;
	int bLETAFTERIN=2;
	int bLETAFTERINDESIGNATOR=3;
	
      int bLET = bLETFALSE;
    int formalTestCount=0;
    
      boolean bFunctionId = false;
      int nestingLevel = 0;
	StringBuffer string = new StringBuffer(128);
	private Symbol nextToken(short id)
	{
		return new Symbol(id, yyline + 1, yycolumn + 1, yylength());
	}

	private Symbol nextToken(short id, Object value)
	{
		return new Symbol(id, yyline + 1, yycolumn + 1, yylength(), value);
	}
	
	private void Debug(String text)
	{
		System.out.println(text);//commentariseer deze regel uit in productie
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


TextChar = [^\x00-\x1F\&\"\<\x80-\xFF] | [\n\r\t] | {TextCharRefA} | {TextCharRefB} | {TextEntityRef} | [&]
SymbolChar = [^\x00-\x1F\)\ \t\n\r\;\,\>\x80-\xFF]


TextCharRefA = "&#" [0-9]+ ";" 
TextCharRefB = "&#x" [0-9a-fA-F]+ ";"
TextEntityRef  = "&" [a-zA-Z\_\:] [a-zA-Z0-9\.\-\_\:]* ";" 
FileExt = [a-zA-Z0-9]+
PathElement = [^\ \t\n\r\.\/\\]+
Directory = {PathElement} ("/" {PathElement})* 



/* identifiers */
Identifier = [A-Za-z][A-Za-z\-0-9]*

SiteFilename = {PathElement} "." {FileExt}




%state SITE,STRING,STRCON,STRCON_INIT, PRETEXT, POSTMIDTEXT, ATTRIBUTES,DIRFILE, ARGUMENTS

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
  "module"                         { Debug("MODULE"); return nextToken(Terminals.MODULE); }
  "import"                         { Debug("IMPORT"); return nextToken(Terminals.IMPORT); }  
  "def"                            { Debug("DEF"); bDEF=true; bFunctionId=true; return nextToken(Terminals.DEF); }
  "end"                            { if(bSITE && bLET==bLETFALSE) {
                                       Debug("END SITE");
                                       bSITE=false;
                                     }else if(bDEF && bLET==bLETFALSE) {
                                       Debug("END DEF"); 
                                       bDEF=false;
                                     }
                                     else if(bLET>=bLETFALSE) {
                                       Debug("END LET");
                                       bLET=bLETFALSE;
                                     }
                                     return nextToken(Terminals.END);
                                   }
  "site"                           { Debug("SITE"); yybegin(DIRFILE); bSITE=true; return nextToken(Terminals.SITE); }
  "list"                           { Debug("LIST");  return nextToken(Terminals.LIST); }
  "record"                         { Debug("RECORD");  return nextToken(Terminals.RECORD); }
  "string"                         { Debug("STRING");  return nextToken(Terminals.STRING); }
  "if"                             { Debug("IF");   return nextToken(Terminals.IF); }
  "in"				               { Debug("IN"); bLET=bLETAFTERIN;  return nextToken(Terminals.IN); }
  "in"/{WhiteSpace}*{Identifier}                { Debug("IN (FOLLOWING DESIGNATOR)"); bLET=bLETAFTERINDESIGNATOR;  return nextToken(Terminals.IN); }
  
  "comment"                        { Debug("COMMENT"); string.setLength(0); yybegin(STRCON_INIT);  return nextToken(Terminals.COMMENT);  }
  "echo"                           { Debug("ECHO"); return nextToken(Terminals.ECHO); }
  "cdata"                          { Debug("CDATA"); return nextToken(Terminals.CDATA); }
  "each"                           { Debug("EACH"); return nextToken(Terminals.EACH); }
  "let"                            { Debug("LET"); bLET=bLETBEFOREIN; return nextToken(Terminals.LET); }
  "yield"                          { Debug("YIELD"); return nextToken(Terminals.YIELD); }

   "\""                        { string.setLength(0); string.append( '\"' ); yybegin(PRETEXT); }
   ">"                        { string.setLength(0);string.append( '>' ); yybegin(POSTMIDTEXT); }

 
    
  /* separators and operators*/
//  "&#x"                          { return nextToken(Terminals.TEXTCHARREF); }
//  "&#"                           { return nextToken(Terminals.TEXTCHARREF); }  
  
  "("                            { Debug("LPAREN"); if(bLET==bLETBEFOREIN){ formalTestCount++;} nestingLevel++; return nextToken(Terminals.LPAREN); }
  ")"                            { Debug("RPAREN"); if(bLET==bLETBEFOREIN){ formalTestCount++;} nestingLevel--; return nextToken(Terminals.RPAREN); }
  "{"                            { Debug("LBRACE"); return nextToken(Terminals.LBRACE); }
  "}"                            { Debug("RBRACE"); return nextToken(Terminals.RBRACE); }
  "["                            { Debug("LBRACK"); return nextToken(Terminals.LBRACK); }
  "]"                            { Debug("RBRACK"); return nextToken(Terminals.RBRACK); }
  ";"                            { Debug("SEMICOLON"); if(bSITE){ yybegin(DIRFILE); } return nextToken(Terminals.SEMICOLON); }
  ","                            { Debug("COMMA"); return nextToken(Terminals.COMMA); }
  "."                            { Debug("DOT"); return nextToken(Terminals.DOT); }
  ":"                            { Debug("COLON"); return nextToken(Terminals.COLON); }
  "%"                            { Debug("MOD"); return nextToken(Terminals.MOD); }
  "@"                            { Debug("ADDCHAR"); return nextToken(Terminals.ADDCHAR); }    
  "/"                            { Debug("DIV"); return nextToken(Terminals.DIV); }
  "?"                            { Debug("QUESTION"); return nextToken(Terminals.QUESTION); }
  "!"                            { Debug("NOT"); return nextToken(Terminals.NOT); }
  "&&"                           { Debug("ANDAND"); return nextToken(Terminals.ANDAND); }
  "||"                           { Debug("OROR"); return nextToken(Terminals.OROR); }
  "="                            { Debug("EQ"); if(bLET==bLETBEFOREIN){ formalTestCount++;} return nextToken(Terminals.EQ); }
  
  "'" {SymbolChar}*              { Debug("SYMBOLCON " + yytext()); return nextToken(Terminals.SYMBOLCON, yytext() );}


  /* comments */
  {Comment}                      { /* ignore */ }

  /* whitespace */
  {WhiteSpace}                   { /* ignore */ }

  /* identifiers */
  {Identifier}                   {if( bLET==bLETAFTERINDESIGNATOR  )
  									{
  									//	bLET=bLETAFTERIN;
  					  	              Debug("IDCONDESIGNATOR (bLET)" + yytext() );
                                      return nextToken(Terminals.IDCONDESIGNATOR, yytext());					
  									}
  									else if( bLET==bLETBEFOREIN && formalTestCount==3)
  									{
  					  	              Debug("IDCONDESIGNATOR (bLET)" + yytext() );
                                      return nextToken(Terminals.IDCONDESIGNATOR, yytext());					
  									}
  									else if(bLET>bLETFALSE) {
  	                                  Debug("IDCON " + yytext() );
                                      return nextToken(Terminals.IDCON, yytext());
  									}
  									else if ( bDEF && bFunctionId ) {
                                      Debug("IDCON " + yytext() );
                                      bFunctionId = false;
                                      return nextToken(Terminals.IDCON, yytext());
                                    }
                                    else if ( nestingLevel == 0 && bDEF && !bFunctionId ) {
                                      yybegin(ATTRIBUTES);
                                      Debug("MAIN IDCONDESIGNATOR " + yytext() );
                                      return nextToken(Terminals.IDCONDESIGNATOR, yytext());
                                      }
                                    else {
                                      Debug("IDCON " + yytext() );
                                      return nextToken(Terminals.IDCON, yytext());
                                    }
                                 }

  
  /* identifiers */
  "<"{Identifier}                { yybegin(ATTRIBUTES); String temp = yytext(); return nextToken(Terminals.IDCONDESIGNATOR, temp.substring(1) ); } 
  
  /* identifiers */
  {Identifier}/">"               { return nextToken(Terminals.IDCONTAIL, yytext()); } 
    
  /* Natural numbers*/
  {Natcon}                       { return nextToken(Terminals.NATCON, yytext()); }  

}

<DIRFILE> {
  {Directory} /"/"               { Debug("DIRNAME " + yytext() ); return nextToken(Terminals.DIRNAME, yytext()); }
  "/"                            { Debug("DIV"); return nextToken(Terminals.DIV); }
  {SiteFilename}                 { Debug("FILENAME " + yytext() ); return nextToken(Terminals.FILENAME, yytext()); }
  ":"                            { Debug("COLON "); return nextToken(Terminals.COLON); }
  {Identifier}     	 	   { Debug("DIRFILE IDCONDESIGNATOR " + yytext() );  yybegin(ATTRIBUTES); return nextToken(Terminals.IDCONDESIGNATOR, yytext() ); } 
 
  /* comments */
  {Comment}                      { /* ignore */ }

  /* whitespace */
  {WhiteSpace}                   { /* ignore */ }
  
  .					   {  Debug("PushBackDirfile:" + yytext() ); yybegin(YYINITIAL); yypushback(1); }
    
}

<STRCON_INIT> {
  "\""                           { yybegin(STRCON);  }
   /* comments */
  {Comment}                      { /* ignore */ }

  /* whitespace */
  {WhiteSpace}                   { /* ignore */ }
}

<STRCON> {

  "\""                           { Debug("STRCON " /*+ string.toString()*/ ); yybegin(YYINITIAL); return nextToken(Terminals.STRCON, string.toString() ); }	
  "\\t"                          { string.append( '\t' ); }
  "\\n"                          { string.append( '\n' ); }
  "\\\""                         { string.append( '\"' ); }
  "\\\\"                         { string.append( '\\' ); }
  "\\" [0-9][0-9][0-9]           { String temp = yytext(); string.append( temp.substring(1) ); }
  [^\x00-\x1F\n\t\"\\]           { string.append( yytext() ); }
}


<PRETEXT> {
	{TextChar}			   { string.append( yytext() ); }
      "\""                       { Debug("TEXT " + string + yytext() ); yybegin(YYINITIAL); string.append(  yytext() );  return nextToken(Terminals.TEXT,  string.toString() ); }
	{TextChar}/"<"             { Debug("PRETEXT " + string+ yytext() ); yybegin(YYINITIAL); string.append(  yytext() + '<' );  return nextToken(Terminals.PRETEXT,  string.toString() ); }
}

<POSTMIDTEXT> {
	{TextChar} 			   { string.append( yytext() ); }
	"\""                       { Debug("POSTTEXT " + string + yytext() );  yybegin(YYINITIAL);  string.append( '\"' );  return nextToken(Terminals.POSTTEXT, string.toString() ); }
	{TextChar}/"<"             { Debug("MIDTEXT " + string + yytext());  yybegin(YYINITIAL);  string.append( yytext() + '<' );  return nextToken(Terminals.MIDTEXT,  string.toString() ); }
}

<ATTRIBUTES> {
	  "#"{Identifier}                         { String temp = yytext(); return nextToken(Terminals.HASHIDCON, temp.substring(1) ); }
	  "."{Identifier}                         { String temp = yytext(); return nextToken(Terminals.ATTDOTIDCON, temp.substring(1) ); }
	  "$"{Identifier}                         { String temp = yytext(); return nextToken(Terminals.ATTDOLLARIDCON, temp.substring(1) ); }
	  ":"{Identifier}                         { String temp = yytext(); return nextToken(Terminals.ATTCOLONIDCON, temp.substring(1) ); }
	  "@"{Natcon}                	            { String temp = yytext(); return nextToken(Terminals.ADDCHARNATCON, temp.substring(1) ); }
	  {Identifier}/{WhiteSpace}{Identifier}	{ return nextToken(Terminals.IDCONDESIGNATOR, yytext() ); } 
	  {Identifier}/{WhiteSpace}{Natcon}		{ return nextToken(Terminals.IDCONDESIGNATOR, yytext() ); } 
	  {Identifier}/{WhiteSpace}*"["		{ return nextToken(Terminals.IDCONDESIGNATOR, yytext() ); } 
	  {Identifier}/{WhiteSpace}*"{"		{ return nextToken(Terminals.IDCONDESIGNATOR, yytext() ); } 
  	  {Identifier}/{WhiteSpace}*"'"  	{ return nextToken(Terminals.IDCONDESIGNATOR, yytext() ); } 	  	  
	  {Identifier}/{WhiteSpace}*"("	 	{ return nextToken(Terminals.IDCONDESIGNATOR, yytext() ); } 
	  {Comment}                      		{ /* ignore */ }
      {WhiteSpace}                   		{ /* ignore */ }
  	  .							{ yybegin(YYINITIAL); yypushback(1); bFunctionId=false;}
}

 

/* No token was found for the input so through an error.  Print out an
   Illegal character message with the illegal character that was found. */
[^]                    { throw new Scanner.Exception("Illegal character <"+yytext()+">"); }
