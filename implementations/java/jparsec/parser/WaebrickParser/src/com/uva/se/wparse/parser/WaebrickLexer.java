/*
 * File			: WaebrickLexer.java
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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Scanners;
import org.codehaus.jparsec.pattern.CharPredicate;
import org.codehaus.jparsec.pattern.Patterns;


public final class WaebrickLexer {
  
	
	private static final CharPredicate IDENTIFIER_START = new CharPredicate() {
	    public boolean isChar(char c) {
	    	 Pattern p = Pattern.compile("[a-zA-Z]");
	    	 Matcher m = p.matcher(String.valueOf(c));
	    	 return m.matches();
	    }
	  };
	  
	  private static final CharPredicate IDENTIFIER_PART = new CharPredicate() {
	    public boolean isChar(char c) {
	    	Pattern p = Pattern.compile("[a-zA-Z0-9]");
	    	 Matcher m = p.matcher(String.valueOf(c));
	    	 return m.matches();
	    }
	  };
	  

	
	
	
	  private static final CharPredicate PATH_ELEMENT = new CharPredicate() {
		    public boolean isChar(char c) {
		    	Pattern p = Pattern.compile("[a-zA-Z0-9]");
		    	 Matcher m = p.matcher(String.valueOf(c));
		    	 return m.matches();
		    }
		  };
		  
		  
		  private static final CharPredicate PATH_SEPARATOR = new CharPredicate() {
			    public boolean isChar(char c) {
			    
			    	 return '/' == c;
			    }
			  };
			  
			  
			  static final Parser<String> IDENTIFIER = Scanners.pattern(
				      Patterns.isChar(IDENTIFIER_START).next(Patterns.isChar(IDENTIFIER_PART).many() ),
				      "identifier").source();
		  
	  
			 public static final Parser<String> PATH =  Scanners.pattern(
				      Patterns.isChar(PATH_ELEMENT).many().next( Patterns.sequence(Patterns.isChar(PATH_SEPARATOR),
				    		  Patterns.isChar(PATH_ELEMENT).many()).many()  ),"path").source();
  

}
