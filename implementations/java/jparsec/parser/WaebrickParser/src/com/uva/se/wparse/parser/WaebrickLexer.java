/*
 * File			: WaebrickLexer.java
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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Scanners;
import org.codehaus.jparsec.pattern.CharPredicate;
import org.codehaus.jparsec.pattern.Patterns;

public class WaebrickLexer {

	private final CharPredicate IDENTIFIER_START = new CharPredicate() {
		public boolean isChar(char c) {
			Pattern p = Pattern.compile("[a-zA-Z]");
			Matcher m = p.matcher(String.valueOf(c));
			return m.matches();
		}
	};

	private final CharPredicate IDENTIFIER_PART = new CharPredicate() {
		public boolean isChar(char c) {
			Pattern p = Pattern.compile("[a-zA-Z0-9]");
			Matcher m = p.matcher(String.valueOf(c));
			return m.matches();
		}
	};

	private Parser<String> IDENTIFIER = Scanners.pattern(
			Patterns.isChar(IDENTIFIER_START).next(
					Patterns.isChar(IDENTIFIER_PART).many()), "identifier").source();

	public Parser<String> getIdentifier() {
		return IDENTIFIER;
	}
	
	

}
