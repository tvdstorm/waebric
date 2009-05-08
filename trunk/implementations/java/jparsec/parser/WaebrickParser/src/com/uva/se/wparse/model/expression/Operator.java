/*
 * File			: Operator.java
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
package com.uva.se.wparse.model.expression;



public enum Operator {
  AND					("&&"),
  OR					("||"),
  EQ					("="),
  DOT					("."),
  TOKEN_EQUALS 			("="),
  SEMI_COLON			( ";"),
  PLUS	 				( "+"),
  MINUS				 	( "-"),
  COLON	 				( ":"),
  ROUND_BRACKET_OPEN 	( "("),
  ROUND_BRACKET_CLOSE 	( ")"),
  SQUARE_BRACKET_OPEN	( "["),
  SQUARE_BRACKET_CLOSE 	( "]"),
  CURLY_BRACKET_OPEN 	( "{"),
  CURLY_BRACKET_CLOSE 	( "}"),
  COMMA				 	( ","),
  POUND				 	( "#"),
  DOLLAR			 	( "$"),
  AT				 	( "@"),
  PERCENT			 	( "%"),
  SMALLER_THEN		 	( "<"),
  LARGER_THEN		 	( ">"),
  APOSTROPHE		 	( "'"),
  SLASH				 	( "/"),
  DOUBLE_QUOTE 			( "\\\""),
  QUESTION			 	( "?"),
  AMPERSAND			 	( "&"),
  STAR				 	( "*"),
  EXCLAMATION		 	( "!"),
  CARET				 	( "^"),
  UNDER_SCORE		 	( "_"),
    
  ;
  
  private final String name;
  
  private Operator(final String name) {
    this.name = name;
  }
  
  @Override public String toString() {
    return name;
  }
  
  
  public static String[] toArray() {
		try {
			// Class<?> c = Class.forName("Operator.class");
			Operator[] operatorArray = values();
			String[] operators = new String[operatorArray.length];

			for (int i = 0; i < operatorArray.length; i++) {
				operators[i] = operatorArray[i].toString();
			}
			return operators;
			// c.getEnumConstants()
		} catch (Exception e) {
			// failed to read enum correctly, return empty array.
		}
		return null;
	}
  
  
}
