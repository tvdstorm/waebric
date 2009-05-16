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
	
	public static final String KEYWORD_MODULE 		= "module";
	public static final String KEYWORD_IMPORT 		= "import";
	public static final String KEYWORD_DEF	 		= "def";
	public static final String KEYWORD_END	 		= "end";
	public static final String KEYWORD_SITE 		= "site";
	public static final String KEYWORD_LIST 		= "list";
	public static final String KEYWORD_RECORD 		= "record";
	public static final String KEYWORD_STRING 		= "string";
	public static final String KEYWORD_COMMENT 		= "comment";
	public static final String KEYWORD_ECHO 		= "echo";
	public static final String KEYWORD_CDATA 		= "cdata";
	public static final String KEYWORD_YIELD 		= "yield";
	public static final String KEYWORD_IF	 		= "if";
	public static final String KEYWORD_EACH 		= "each";
	public static final String KEYWORD_LET 			= "let";
	public static final String KEYWORD_ELSE 		= "else";
	public static final String KEYWORD_IN	 		= "in";

	
	private static  String[] KEYWORDS = {
		KEYWORD_MODULE, KEYWORD_IMPORT, KEYWORD_DEF, KEYWORD_END , KEYWORD_SITE,
		KEYWORD_LIST, KEYWORD_RECORD, KEYWORD_STRING, KEYWORD_COMMENT, KEYWORD_ECHO,
		KEYWORD_CDATA, KEYWORD_YIELD, KEYWORD_IF, KEYWORD_EACH,KEYWORD_LET, KEYWORD_ELSE,
		KEYWORD_IN, };
	
//	private static String[] OPERATORS2 = {
//		TOKEN_EQUALS, TOKEN_SEMI_COLON, TOKEN_PLUS, TOKEN_AND, TOKEN_OR, TOKEN_ROUND_BRACKET_OPEN,
//		TOKEN_ROUND_BRACKET_CLOSE, TOKEN_SQUARE_BRACKET_OPEN, TOKEN_SQUARE_BRACKET_CLOSE,
//		TOKEN_CURLY_BRACKET_OPEN, TOKEN_CURLY_BRACKET_CLOSE, TOKEN_DOT, TOKEN_COMMA, TOKEN_POUND,
//		TOKEN_DOLLAR, TOKEN_AT, TOKEN_PERCENT, TOKEN_SMALLER_THEN, TOKEN_LARGER_THEN,
//		TOKEN_APOSTROPHE, TOKEN_SLASH, TOKEN_DOUBLE_QUOTE, TOKEN_QUESTION, TOKEN_MINUS,
//		TOKEN_AMPERSAND, TOKEN_STAR, TOKEN_EXCLAMATION, TOKEN_CARET, TOKEN_UNDER_SCORE, };
	
	

	  private static final String[] OPERATORS = {
	    "=", ";", "+", "&&", "||",":",
	    "(", ")", "[", "]", "{", "}",".", ",","#","$","@", "%","<", ">","'","/","\"","?","-",
	    "&", "*", "!", "^", "_", 
	  };
	  

	  

	  private static Terminals TERMS = Terminals.caseSensitive(new WaebrickLexer().getIdentifier(), OPERATORS, KEYWORDS);
	  
	
	  private static Parser<?> TOKENIZER = Parsers.or(
		      Terminals.IntegerLiteral.TOKENIZER, TERMS.tokenizer());  
	  
	  

		
	  private static Parser<Void> IGNORED = Parsers.or( 
			  			/*TODO: removed the java line comment scanner, because of conflict 
			  			with http:// in string literal */
			  			//Scanners.JAVA_LINE_COMMENT,
			  			Scanners.JAVA_BLOCK_COMMENT, Scanners.WHITESPACES).skipMany();

	
	public static <T> T parse(Parser<T> parser, String source) {
		setSource(source);
		return parser.from(TOKENIZER, IGNORED.skipMany()).parse(source);
	}
	

	
	
	  public static Parser<?> term(String name) {
		    return _(TERMS.token(name));
		  }
		  
	  
	  public static  Parser<?> phrase(String phrase) {
		    return _(TERMS.phrase(phrase.split("\\s+")));
		  }
	  
	  
		public static String getSource() {
			return source;
		}

		public static void setSource(String source) {
			TerminalParser.source = source;
		}

}