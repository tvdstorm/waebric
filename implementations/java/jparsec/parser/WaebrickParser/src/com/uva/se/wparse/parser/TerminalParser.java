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
	    "=", ";", "+", "&&", "||",
	    "(", ")", "[", "]", "{", "}",".", ",","/",
	  };
	  
	  private static final String[] KEYWORDS = {
	    "module", "import", "def", "end", "site", "list", "record",
	    "string", "comment", "echo", "cdata", "yield", "if", "each", "let",
	  };
	  
	  
		
	  
		  
//		  private static final CharPredicate PATH_ELEMENT = new CharPredicate() {
//			    public boolean isChar(char c) {
//			    	Pattern p = Pattern.compile("[a-zA-Z0-9]");
//			    	 Matcher m = p.matcher(String.valueOf(c));
//			    	 return m.matches();
//			    }
//			  };
//			  
//			  
//			  private static final CharPredicate PATH_SEPARATOR = new CharPredicate() {
//				    public boolean isChar(char c) {
//				    
//				    	 return '/' == c;
//				    }
//				  };
//			  
//		  
//				 public static final Parser<String> PATH = Scanners.pattern(
//					      Patterns.isChar(PATH_ELEMENT).many().next( Patterns.sequence(Patterns.isChar(PATH_SEPARATOR),  Patterns.isChar(PATH_ELEMENT).many()).many()  ),
//					      "path").source();
	
				  
	  //static final Parser<String>  tokenParser = Parsers.or(PATH, IDENTIFIER);
	  private static final Terminals TERMS = Terminals.caseSensitive(WaebrickLexer.IDENTIFIER, OPERATORS, KEYWORDS);
	  
	  static final Parser<?> TOKENIZER = Parsers.or(
		      //JavaLexer.SCIENTIFIC_NUMBER_LITERAL,
		      Terminals.StringLiteral.DOUBLE_QUOTE_TOKENIZER,
		      Terminals.CharLiteral.SINGLE_QUOTE_TOKENIZER,
		      TERMS.tokenizer() 
		    ,WaebrickLexer.MAPPING
	  		);  //, JavaLexer.DECIMAL_POINT_NUMBER, JavaLexer.INTEGER);
	  
	  
	  
	  static final Parser<Object> TEST = Parsers.ANY_TOKEN.map(new Map<Object, Object>() {
	      public Object map(Object obj) {
	    	  if(obj instanceof Fragment){
	    		  System.out.println("Found fragment: " + ((Fragment)obj).tag());
	    	  }
	    	  System.out.println("value : " + obj.toString() );
	        return "";
	      }
	    });



	  private final static String SOURCE = " path1/path2/path3  hoi123 && begin || /*this is comment*/module && end";
	
	public void doParse(){
		
		System.out.println("Start parser");
		
		
		//Terminals operators = Terminals.operators("+", "-", "*", "&&"); // only one operator supported so far
		//Parser<?> TOKENIZER = KEYWORDS.tokenizer();
		Parser<Object> integerSyntacticParser = TEST; 
		//Parser<?> ignored = Parsers.or(Scanners.JAVA_BLOCK_COMMENT, Scanners.WHITESPACES);
		//Parser<?> tokenizer = Parsers.or(operators.tokenizer(), TOKENIZER); // tokenizes the operators and integer
		
		//Parser<List<Object>> integers = integerSyntacticParser.sepBy(TERMS.token("||", "&&"))
	    //.from(TOKENIZER, IGNORED.skipMany());
		//integers.parse(SOURCE);
		
		
		integerSyntacticParser.many1().from(TOKENIZER, IGNORED.skipMany()).parse(SOURCE);
			
		
		System.out.println("End parser");
	}
	
	  static <T> T parse(Parser<T> parser, String source) {
		    return parser.from(TOKENIZER, IGNORED.skipMany()).parse(source);
		  }
	
	public static void main(String[] args) {
		TerminalParser mp = new TerminalParser();
		mp.doParse();

	}
	
	
	  public static Parser<?> term(String name) {
//		    if (name.equals(">>")) {
//		      // manually do the exclusion so that ">>>" never gets interpreted partially as ">>",
//		      // even if it can be interpreted as ">" followed by ">>" or three ">"s.
//		      return adjacent(">>>").not().next(adjacent(">>"));
//		    }
//		    if (name.equals("<<") || name.equals(">>>")) {
//		      return adjacent(name);
//		    }
		    return _(TERMS.token(name));
		  }
		  

}
