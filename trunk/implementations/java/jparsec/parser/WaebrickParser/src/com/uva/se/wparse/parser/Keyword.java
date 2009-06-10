/*
 * File			: Keyword.java
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


/**
 * An enumaration with all the keywords which are allowed in the 
 * Weabric language.
 */
public enum Keyword {
	MODULE 	("module"),
	IMPORT 	("import"),
	DEF	 	("def"),
	END	 	("end"),
	SITE 	("site"),
	LIST 	("list"),
	RECORD 	("record"),
	STRING 	("string"),
	COMMENT	("comment"),
	ECHO 	("echo"),
	CDATA 	("cdata"),
	YIELD 	("yield"),
	IF	 	("if"),
	EACH 	("each"),
	LET 	("let"),
	ELSE 	("else"),
	IN	 	("in"),
    
  ;
  
	/**
	 * 
	 */
	private final String name;

	private Keyword(final String name) {
		this.name = name;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return name;
	}

	/**
	 * 
	 * @return
	 */
	public static String[] toArray() {
		try {
			Keyword[] operatorArray = values();
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
