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

public final class TerminalParser {

	// keep a global reference to the original input source
	private static String source = "";

	private static String[] KEYWORDS = Keyword.toArray();

	private static String[] OPERATORS = Operator.toArray();

	private static Terminals TERMS =
	Terminals.caseSensitive(WaebrickLexer.getIdentifier(), OPERATORS, KEYWORDS);

	private static Parser<?> TOKENIZER =
	Parsers.or(Terminals.IntegerLiteral.TOKENIZER, TERMS.tokenizer());

	private static Parser<Void> IGNORED = Parsers.or(
	/*
	 * TODO: removed the java line comment scanner, because of conflict with
	 * http:// in string literal
	 */
	// Scanners.JAVA_LINE_COMMENT,
	Scanners.JAVA_BLOCK_COMMENT, Scanners.WHITESPACES).skipMany();

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

	public static String getSource() {
		return source;
	}

	public static void setSource(String source) {
		TerminalParser.source = source;
	}

}