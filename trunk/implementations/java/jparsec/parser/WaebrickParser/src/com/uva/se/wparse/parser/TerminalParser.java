/*
 * File			: TerminalParser.java
 * Project		: WaebrickParser
 * 				: Waebrick Parser, practicum opdracht Software Construction
 * 
 * Author		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * Description	:
 * 
 * 
 * Change history
 * -----------------------------------------------------------
 * Date			Change				 
 * -----------------------------------------------------------
 * 07-05-2009	Initial version.
 * 
 * 
 */
package com.uva.se.wparse.parser;
import static org.codehaus.jparsec.misc.Mapper._;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.Scanners;
import org.codehaus.jparsec.Terminals;



public final class TerminalParser {
	
	//keep a global reference to the original input source
	private static String source = "";
	
	public static String getSource() {
		return source;
	}

	public static void setSource(String source) {
		TerminalParser.source = source;
	}
	
	static final Parser<Void> IGNORED =
		   Parsers.or(Scanners.JAVA_LINE_COMMENT, Scanners.JAVA_BLOCK_COMMENT, Scanners.WHITESPACES).skipMany();
	
	

	  private static final String[] OPERATORS = {
	    "=", ";", "+", "&&", "||",":",
	    "(", ")", "[", "]", "{", "}",".", ",","#","$","@", "%","<", ">","'","/","\"","?","-", "&", "*", "!", "^", "_",
	  };
	  
	  //zA-Z chars : & * % $ # @ !, . ( ) ^\
	  
	  private static final String[] KEYWORDS = {
	    "module", "import", "def", "end", "site", "list", "record",
	    "string", "comment", "echo", "cdata", "yield", "if", "each", "let", "else","in", 
	  };
	  
	  

	  private static final Terminals TERMS = Terminals.caseSensitive(WaebrickLexer.IDENTIFIER, OPERATORS, KEYWORDS);
	  
	  static final Parser<?> TOKENIZER = Parsers.or(
		      //Terminals.StringLiteral.DOUBLE_QUOTE_TOKENIZER,
		      //Terminals.CharLiteral.SINGLE_QUOTE_TOKENIZER,
		      Terminals.IntegerLiteral.TOKENIZER,
		      TERMS.tokenizer()
	  		);  
	  
	  


	
	public static <T> T parse(Parser<T> parser, String source) {
		setSource(source);
		return parser.from(TOKENIZER, IGNORED.skipMany()).parse(source);
	}
	

	
	
	  public static Parser<?> term(String name) {
		    return _(TERMS.token(name));
		  }
		  
	  
	  public static Parser<?> phrase(String phrase) {
		    return _(TERMS.phrase(phrase.split("\\s+")));
		  }

}
