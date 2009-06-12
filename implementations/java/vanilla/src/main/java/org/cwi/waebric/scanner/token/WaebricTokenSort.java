package org.cwi.waebric.scanner.token;

/**
 * Sorts of available tokens
 * 
 * @author Jeroen van Schagen
 * @date 18-05-2009
 */
public enum WaebricTokenSort {
	
	/**
	 * Identifier tokens are non-keyword words in a structured text.
	 * 
	 * For example, in the below text:<br>
	 * 	<code>module helloworld</code><br>
	 * helloworld is the identifier
	 */
	IDCON,
	
	/**
	 * Number tokens include all characters that represents natural numbers.
	 * @see java.lang.Integer
	 */
	NATCON, 
	
	/**
	 * SymbolCons are a collection of 0..* characters started with a single quote.
	 */
	SYMBOLCON,
	
	/**
	 * Quote token contains characters between two double quotes. Both the Text
	 * and StrCon type in Waebric are forms of quotes.
	 * 
	 * For example:<br>
	 * "This is a quote"
	 */
	QUOTE,
	
	/**
	 * Symbol char tokens are all regular ASCII symbols between the decimal range of 32..126
	 */
	CHARACTER,
	
	/**
	 * Keyword tokens are words that are literally part of the language grammar.<br><br>
	 * 
	 * For example, in the below text:<br>
	 * 	<code>module helloworld</code><br>
	 * module is the keyword.
	 */
	KEYWORD;
	
}