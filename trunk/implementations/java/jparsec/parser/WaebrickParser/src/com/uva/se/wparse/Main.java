/*
 * File			: Main.java
 * Project		: WaebrickParser
 * 				: Practicum opdracht Software Construction
 * 
 * Authors		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * 
 * Description	:
 * 
 */
package com.uva.se.wparse;
import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.Scanners;
import org.codehaus.jparsec.Terminals;
import org.codehaus.jparsec.functors.Map;


public class Main {


	
	private static final String[] OPERATORS = {
		  "&&", "||" // and all other operators.
		};

	
	private static final String[] KEYWORDS = {
		  "module", "import", "site", "def", "echo", "each" // all other keywords
		};
	
	static final Parser< Void > IGNORED =
		   Parsers.or(Scanners.JAVA_LINE_COMMENT, Scanners.JAVA_BLOCK_COMMENT, Scanners.WHITESPACES).skipMany();
	
	private static final Terminals TERMINALS = Terminals.caseSensitive(OPERATORS, KEYWORDS);

	
	static final Parser<?> TOKENIZER = TERMINALS.tokenizer();
	//static final Parser<?> TOKENIZER = Parsers.or(Keyw)
	
	  static final Parser<String> TOKENS = Parsers.ANY_TOKEN.map(new Map<Object, String>() {
	      public String map(Object s) {
	    	System.out.println("TOKEN FOUND == " + s.toString());
	        return "test";
	      }
	    });

	public static final Parser<String> PARSER = TOKENS.from(TOKENIZER, IGNORED);
	
	

	public static void main(String[] args) {

		Main m = new Main();
		m.doiets();

	}
	
	public void doiets(){
		System.out.println("Start parser");
		PARSER.parse("module import echo");
		//TOKENIZER.parse("module import");
		//PARSER.
		System.out.println("End parser");

	}

	
}
