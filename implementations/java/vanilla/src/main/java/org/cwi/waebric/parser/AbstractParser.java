package org.cwi.waebric.parser;

import java.util.List;

import org.cwi.waebric.scanner.token.Token;
import org.cwi.waebric.scanner.token.TokenIterator;
import org.cwi.waebric.scanner.token.TokenSort;
import org.cwi.waebric.parser.exception.MissingTokenException;
import org.cwi.waebric.parser.exception.ParserException;
import org.cwi.waebric.parser.exception.UnexpectedTokenException;

/**
 * Parser abstraction, which lays the foundation for all
 * concrete (sub) parser implementations.
 * 
 * @author Jeroen van Schagen
 * @data 19-05-2009
 */
public abstract class AbstractParser {

	protected final List<ParserException> exceptions;
	protected final TokenIterator tokens;
	protected Token current;
	
	public AbstractParser(TokenIterator tokens, List<ParserException> exceptions) {
		this.exceptions = exceptions;
		this.tokens = tokens;
	}
	
	/**
	 * Retrieve next token from iterator.
	 * 
	 * @throws MissingTokenException Thrown when no more tokens are available
	 * 
	 * @param name Name of expected token, used for error reporting
	 * @param syntax Grammar of expected token, used for error reporting
	 * @return Success status of finding next token.
	 */
	protected boolean next(String name, String syntax) {
		if(tokens.hasNext()) {
			current = tokens.next(); // Retrieve next token in stream
			return true;
		} else {
			if(current != null) { 
				// Throw missing token exception, with current token
				exceptions.add(new MissingTokenException(current, name, syntax));
			} else {
				// Throw missing token exception
				exceptions.add(new MissingTokenException(name, syntax));
			}
			return false;
		}
	}
	
	/**
	 * Retrieve next token from iterator and check sort.
	 * 
	 * @throws MissingTokenException Thrown when no more tokens are available
	 * @throws UnexpectedTokenException Thrown when next token does not match expected sort
	 * 
	 * @param name Name of expected token, used for error reporting
	 * @param syntax Grammar of expected token, used for error reporting
	 * @param sort Expected token sort, used for type checking
	 * @return Success status of finding and type-checking next token.
	 */
	protected boolean next(String name, String syntax, TokenSort sort) {
		if(next(name, syntax)) {
			if(current.getSort() == sort) {
				return true; // Token has been verified
			} else {
				// Throw unexpected token exception
				exceptions.add(new UnexpectedTokenException(current, name, syntax));
			}
		}
		
		return false;
	}
	
	/**
	 * Retrieve next token from iterator and check lexeme.
	 * 
	 * @throws MissingTokenException Thrown when no more tokens are available
	 * @throws UnexpectedTokenException Thrown when next token does not match expected lexeme
	 * 
	 * @param name Name of expected token, used for error reporting
	 * @param syntax Grammar of expected token, used for error reporting
	 * @param lexeme Expected token lexeme, used for type checking
	 * @return Success status of finding and type-checking next token.
	 */
	protected boolean next(String name, String syntax, Object lexeme) {
		if(next(name, syntax)) {
			if(current.getLexeme().equals(lexeme)) {
				return true; // Token has been verified
			} else {
				// Throw unexpected token exception
				exceptions.add(new UnexpectedTokenException(current, name, syntax));
			}
		}
		
		return false;
	}
	
}