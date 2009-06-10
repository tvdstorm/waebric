/*
 * File			: Operator.java
 * Project		: WaebrickParser2
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



public enum Operator {
  AND					("&&"),
  OR					("||"),
  DOT					("."),
  EQUALS	 			("="),
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
  DOUBLE_QUOTE 			( "\""),
  QUESTION			 	( "?"),
  AMPERSAND			 	( "&"),
  STAR				 	( "*"),
  NOT				 	( "!"),
  CARET				 	( "^"),
  UNDER_CORE		 	( "_"),
  TILDE				 	( "~"),
    
  ;
  
  private final String name;
  
  private Operator(final String name) {
    this.name = name;
  }
  
  @Override public String toString() {
    return name;
  }
  
  
  /**
   * Convert the enum to a String array
   * 
   * @return an array of Strings with values of the enum elements,
   * returns empty array in case of error.
   */
  public static String[] toArray() {
		try {
			Operator[] operatorArray = values();
			String[] operators = new String[operatorArray.length];

			for (int i = 0; i < operatorArray.length; i++) {
				operators[i] = operatorArray[i].toString();
			}
			return operators;
		} catch (Exception e) {
			// failed to read enum correctly, return empty array.
		}
		return new String[]{};
	}
  
  
}
