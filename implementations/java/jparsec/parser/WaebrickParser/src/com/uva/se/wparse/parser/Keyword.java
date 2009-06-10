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
	 * The name of the enumarion. 
	 */
	private final String name;

	/**
	 * Set the name of an enumarion.
	 * @param name The name.
	 */
	private Keyword(final String name) {
		this.name = name;
	}

	/**
	 * Return the setted name.
	 */
	@Override
	public String toString() {
		return name;
	}

	/**
	 * Return an array with all the properties which are stored in the enumarion.
	 * @return An array with strings with all the keywords.
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
