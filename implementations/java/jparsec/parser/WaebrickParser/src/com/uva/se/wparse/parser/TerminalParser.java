/*
 * File			: TerminalParser.java
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

import static org.codehaus.jparsec.misc.Mapper._;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.Scanners;
import org.codehaus.jparsec.Terminals;

/**
 * The parsers of all the terminals. 
 */
public final class TerminalParser {

	/**
	 * Keep a global reference to the original input source
	 */
	private static String source = "";

	/**
	 * An array of all the keywords. 
	 */
	private static String[] KEYWORDS = Keyword.toArray();

	/**
	 * An array of all the operators. 
	 */
	private static String[] OPERATORS = Operator.toArray();

	/**
	 * All the terminals consists of identifiers, operators and keywords. 
	 */
	private static Terminals TERMS =
	Terminals.caseSensitive(WaebrickLexer.getIdentifier(), OPERATORS, KEYWORDS);

	/**
	 * The tokenizer of the Waebric language. 
	 */
	private static Parser<?> TOKENIZER =
	Parsers.or(Terminals.IntegerLiteral.TOKENIZER, TERMS.tokenizer());

	/**
	 * Whitespaces and comments are ignored. 
	 */
	private static Parser<Void> IGNORED = Parsers.or(	
			Scanners.JAVA_BLOCK_COMMENT, Scanners.WHITESPACES).skipMany();

	/**
	 * Parse the terminals via the given parameter. 
	 * @param <T> The type of the parser. 
	 * @param parser The parser
	 * @param source The source to parse
	 * @return A parse tree. 
	 */
	public static <T> T parse(Parser<T> parser, String source) {
		setSource(source);
		return parser.from(TOKENIZER, IGNORED.skipMany()).parse(source);
	}

	public static Parser<?> term(String name) {
		return _(TERMS.token(name));
	}

	public static Parser<?> phrase(String phrase) {
		return _(TERMS.phrase(phrase.split("\\s+")));
	}

	/**
	 * Returns the source code. 
	 * @return The source code.
	 */
	public static String getSource() {
		return source;
	}

	/**
	 * The source code. 
	 * @param source The source code. 
	 */
	public static void setSource(String source) {
		TerminalParser.source = source;
	}

}