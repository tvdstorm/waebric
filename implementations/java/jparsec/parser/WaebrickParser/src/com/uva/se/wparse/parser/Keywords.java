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
package com.uva.se.wparse.parser;



public enum Keywords {
	KEYWORD_MODULE 	("module"),
	KEYWORD_IMPORT 	("import"),
	KEYWORD_DEF	 	("def"),
	KEYWORD_END	 	("end"),
	KEYWORD_SITE 	("site"),
	KEYWORD_LIST 	("list"),
	KEYWORD_RECORD 	("record"),
	KEYWORD_STRING 	("string"),
	KEYWORD_COMMENT	("comment"),
	KEYWORD_ECHO 	("echo"),
	KEYWORD_CDATA 	("cdata"),
	KEYWORD_YIELD 	("yield"),
	KEYWORD_IF	 	("if"),
	KEYWORD_EACH 	("each"),
	KEYWORD_LET 	("let"),
	KEYWORD_ELSE 	("else"),
	KEYWORD_IN	 	("in"),
    
  ;
  
  private final String name;
  
  private Keywords(final String name) {
    this.name = name;
  }
  
  @Override public String toString() {
    return name;
  }
  
  
  public static String[] toArray() {
		try {
			Keywords[] operatorArray = values();
			String[] operators = new String[operatorArray.length];

			for (int i = 0; i < operatorArray.length; i++) {
				operators[i] = operatorArray[i].toString();
			}
			return operators;
		} catch (Exception e) {
			// failed to read enum correctly, return empty array.
		}
		return null;
	}
  
  
}
