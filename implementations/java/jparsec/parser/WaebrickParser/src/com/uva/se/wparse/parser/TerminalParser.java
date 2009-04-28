/*
 * File			: TerminalParser.java
 * Project		: WaebrickParser
 * 				: Practicum opdracht Software Construction
 * 
 * Authors		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * 
 * Description	:
 * 
 */
package com.uva.se.wparse.parser;
import static org.codehaus.jparsec.misc.Mapper._;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.Scanners;
import org.codehaus.jparsec.Terminals;
import org.codehaus.jparsec.Tokens.Fragment;
import org.codehaus.jparsec.functors.Map;
import org.codehaus.jparsec.pattern.CharPredicate;
import org.codehaus.jparsec.pattern.Patterns;

import sun.misc.JavaLangAccess;



public final class TerminalParser {

	
	static final Parser<Void> IGNORED =
		   Parsers.or(Scanners.JAVA_LINE_COMMENT, Scanners.JAVA_BLOCK_COMMENT, Scanners.WHITESPACES).skipMany();
	
	

	  private static final String[] OPERATORS = {
	    "=", ";", "+", "&&", "||",":",
	    "(", ")", "[", "]", "{", "}",".", ",","#","$","@", "%","<", ">","'","/",
	  };
	  
	  private static final String[] KEYWORDS = {
	    "module", "import", "def", "end", "site", "list", "record",
	    "string", "comment", "echo", "cdata", "yield", "if", "each", "let", "else","in",
	  };
	  
	  

	  private static final Terminals TERMS = Terminals.caseSensitive(WaebrickLexer.IDENTIFIER, OPERATORS, KEYWORDS);
	  
	  static final Parser<?> TOKENIZER = Parsers.or(
		      Terminals.StringLiteral.DOUBLE_QUOTE_TOKENIZER,
		      Terminals.CharLiteral.SINGLE_QUOTE_TOKENIZER,
		      Terminals.IntegerLiteral.TOKENIZER,
		      TERMS.tokenizer()
	  		);  
	  
	  


	
	public static <T> T parse(Parser<T> parser, String source) {
		    return parser.from(TOKENIZER, IGNORED.skipMany()).parse(source);
		  }
	

	
	
	  public static Parser<?> term(String name) {
		    return _(TERMS.token(name));
		  }
		  
	  
	  public static Parser<?> phrase(String phrase) {
		    return _(TERMS.phrase(phrase.split("\\s+")));
		  }

}
