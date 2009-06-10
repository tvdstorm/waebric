/*
 * File			: WaebrickLexer.java
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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Scanners;
import org.codehaus.jparsec.pattern.CharPredicate;
import org.codehaus.jparsec.pattern.Patterns;

/**
 * The lexer of the Weabric language, searching for the identifiers.
 */
public class WaebrickLexer {

	/**
	 * Indicates how an identifier should start. 
	 */
	private static final CharPredicate IDENTIFIER_START = new CharPredicate() {
		public boolean isChar(char c) {
			Pattern p = Pattern.compile("[a-zA-Z]");
			Matcher m = p.matcher(String.valueOf(c));
			return m.matches();
		}
	};

	/**
	 * Indicates what's part of an identifier.
	 */
	private static final CharPredicate IDENTIFIER_PART = new CharPredicate() {
		public boolean isChar(char c) {
			Pattern p = Pattern.compile("[a-zA-Z0-9]");
			Matcher m = p.matcher(String.valueOf(c));
			return m.matches();
		}
	};

	/**
	 * Identifies all the identifiers of the Weabric language.
	 */
	private static Parser<String> IDENTIFIER = Scanners.pattern(
			Patterns.isChar(IDENTIFIER_START).next(
					Patterns.isChar(IDENTIFIER_PART).many()), "identifier").source();

	/**
	 * Returns an identifier.
	 * @return The identifier.
	 */
	public static Parser<String> getIdentifier() {
		return IDENTIFIER;
	}
	
}
