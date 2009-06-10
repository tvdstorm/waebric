/*
 * File			: ExpressionParser.java
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

import java.util.regex.Pattern;

import org.codehaus.jparsec.OperatorTable;
import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.Terminals;
import org.codehaus.jparsec.Token;
import org.codehaus.jparsec.TokenMap;
import org.codehaus.jparsec.functors.Binary;
import org.codehaus.jparsec.misc.Mapper;

import com.uva.se.wparse.model.expression.BlockExpression;
import com.uva.se.wparse.model.expression.BlockKeyValueExpression;
import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.expression.ExpressionDotIdentifier;
import com.uva.se.wparse.model.expression.Identifier;
import com.uva.se.wparse.model.expression.KeyValuePair;
import com.uva.se.wparse.model.expression.NaturalConstant;
import com.uva.se.wparse.model.expression.StringLiteral;
import com.uva.se.wparse.model.expression.SymbolConstant;
import com.uva.se.wparse.model.expression.Var;
import com.uva.se.wparse.model.module.ModuleBody;

/**
 * Create several Parsers for recognizing expressions. For the definitions of the 
 * names see ASF+SDF. 
 */
public class ExpressionParser {

	/**
	 * The parser which detects a Literal in de code. 
	 */
	@SuppressWarnings("unchecked")
	public static Parser LITERAL_TEXT = Parsers.sequence(Parsers.token(new TokenMap<String>() {
				public String map(Token token) {
					String value = token.value().toString();
					if (!value.equals(Operator.DOUBLE_QUOTE.toString())) {
						int prefixIndex = token.index() - 1;
						if (prefixIndex > 0) {
							// get the token to the left of the current token
							char prefixChar = TerminalParser.getSource()
									.charAt(prefixIndex);
							if (prefixChar == ' ') {
								// is token is prefixed with space char, add
								// space char to the return value
								return " " + value;
							}
						}
						return value.toString();
					} else {
						return null;
					}
				}
			}
	));

	/**
	 * The parser which detects a embedd text. 
	 */
	@SuppressWarnings("unchecked")
	public static Parser EMBEDDED_TEXT = Parsers.sequence(Parsers.token(new TokenMap<String>() {
				public String map(Token token) {
					if (!token.value().toString().equals(Operator.DOUBLE_QUOTE.toString())
							&& !token.value().toString().equals(Operator.SMALLER_THEN.toString())
							&& !token.value().toString().equals(Operator.LARGER_THEN.toString())) {
						int prefixIndex = token.index() - 1;
						if (prefixIndex > 0) {
							// get the token to the left of the current token
							char prefixChar = TerminalParser.getSource()
									.charAt(prefixIndex);
							if (prefixChar == ' ') {
								// is token is prefixed with space char, add
								// space char to the return value
								return " " + token.value().toString();
							}
						}
						return token.value().toString();
					} else {
						return null;
					}
				}

			}

			));
	
	/**
	 * The parser which detects a Symbol Text. 
	 */
	@SuppressWarnings("unchecked")
	public static Parser SYMBOL_TEXT = Parsers.sequence(Parsers.token(new TokenMap<String>() {
				public String map(Token token) {
					String value = token.value().toString();
					char[] chars = value.toCharArray();
					for (int i = 0; i < chars.length; i++) {
						if ((chars[i] < 31) || (chars[i] > 127)
								|| (chars[i] == '\t') || (chars[i] == '\n')
								|| (chars[i] == '\r') || (chars[i] == ';')
								|| (chars[i] == ',') || (chars[i] == '>')
								|| (chars[i] == ')')
						) {
							// the control and extend ascii chars are not
							// supported.
							return null;
						}
					}
					return token.value().toString();
				}
			}
	));
	
	/**
	 * The parser which detects a Id Constant. 
	 */
	@SuppressWarnings("unchecked")
	public static Parser ID_CON = Parsers.sequence(Parsers.token(new TokenMap<String>() {
		public String map(Token token) {
					int prefixIndex = token.index() - 1;
					if (prefixIndex > 0) {
						// get the token to the left of the current token
						char prefixChar = TerminalParser.getSource().charAt(prefixIndex);
						if (prefixChar == ' ') {
							return null; 
						}
					}
					String value = token.value().toString();
					boolean isIdentifier = Pattern.matches("[A-Za-z\\-0-9]*", value);
					if(!isIdentifier){
						return null;
					}
					return token.value().toString().trim();
				}
		}
	));

	/**
	 * The parser which detects a start of an Id Con. 
	 */
	@SuppressWarnings("unchecked")
	public static Parser ID_CON_START = Parsers.sequence(Parsers.token(new TokenMap<String>() {
		public String map(Token token) {
			String value = token.value().toString();
			//check for reserved keyword, if detected then the token
			//cannot be a identifier.
			if( Keyword.YIELD.equals(value) ||
					Keyword.ECHO.toString().equals(value) ||
					Keyword.IF.toString().equals(value) ||
					Keyword.COMMENT.toString().equals(value) ||
					Keyword.CDATA.toString().equals(value) ||
					Keyword.EACH.toString().equals(value) ||
					Keyword.LET.toString().equals(value) ||
					Keyword.YIELD.toString().equals(value) ||
					Keyword.MODULE.toString().equals(value) ||
					Keyword.IMPORT.toString().equals(value) ||
					Keyword.DEF.toString().equals(value) ||
					Keyword.END.toString().equals(value) ||
					Keyword.SITE.toString().equals(value)
				){
				return null;
			}
			boolean isIdentifier = Pattern.matches("^[A-Za-z].*", value);
			if(!isIdentifier){
				return null;
			}
			return token.value().toString();
			}
		}
	));
	
	/**
	 * The parser which detects a ext of a file. 
	 */
	@SuppressWarnings("unchecked")
	public static Parser FILE_EXT = Parsers.sequence(Parsers.token(new TokenMap<String>() {
			public String map(Token token) {
					String value = token.value().toString();
					boolean isIdentifier = Pattern.matches("[A-Za-z0-9]*",
							value);
					if (!isIdentifier) {
						return null;
					}
					return token.value().toString();
				}
			}
	));
	
	/**
	 * The parser which detects a element of a path. 
	 */
	@SuppressWarnings("unchecked")
	public static Parser PATH_ELEMENT_TEXT = Parsers.sequence(Parsers.token(new TokenMap<String>() {
				public String map(Token token) {
					String value = token.value().toString();
					char[] chars = value.toCharArray();
					for (int i = 0; i < chars.length; i++) {
						if ((chars[i] < 31) || (chars[i] > 127)
								|| (chars[i] == '\t') || (chars[i] == '\n')
								|| (chars[i] == '\r') || (chars[i] == ' ')
								|| (chars[i] == '.') || (chars[i] == '/')
								|| (chars[i] == '\\')
						) {
							// the control and extend ascii chars are not
							// supported.
							return null;
						}
					}
					return token.value().toString();
				}
			}
	));
		
	/**
	 * The parser which detects a Identifier. 
	 */
	public static Parser<Expression> IDENTIFIER = curry(Identifier.class).sequence(
		ID_CON_START.source(),
		ID_CON.many().source()
	);
	
	/**
	 * The parser which detects a var.  
	 */
	public static Parser<Expression> VAR = curry(Var.class).sequence(
	   ID_CON_START.source(),
	   ID_CON.many().source()
   );
	
	/**
	 * The parser which detects an element of a path. 
	 */
	public static Parser<Expression> PATH_ELEMENT = curry(Identifier.class).sequence(
		PATH_ELEMENT_TEXT.source(),
		ID_CON.many().source()
	);
	
	/**
	 * Not allowed are control characters 0-31, and extended ascii 127-255
	 */
	@SuppressWarnings("unchecked")
	private static Parser<Expression> symbolConstant = curry(
		SymbolConstant.class).sequence(TerminalParser.term("'"),Parsers.or(SYMBOL_TEXT.many())
	);

	/**
	 * The parser which detects a string literal. 
	 */
	public static Parser<Expression> STRING_LITERAL = curry(
		StringLiteral.class).sequence(
		TerminalParser.term(Operator.DOUBLE_QUOTE.toString()),
		LITERAL_TEXT.many(),
		TerminalParser.term(Operator.DOUBLE_QUOTE.toString())
	);

	/**
	 * Create a Parser of the Expression based on a Parser of Expression. 
	 * @param expressionParser A Parser of Expression (This is a class of our ParseTree model)
	 * @return A Parser of Expression (This is a class of our ParseTree model)
	 */
	private static Parser<Expression> blockExpression(Parser<Expression> expressionParser) {
		return curry(BlockExpression.class).sequence(TerminalParser.term(Operator.SQUARE_BRACKET_OPEN.toString()),
				expressionParser.sepBy(TerminalParser.term(Operator.COMMA.toString())), TerminalParser.term(Operator.SQUARE_BRACKET_CLOSE.toString()));
	}

	/**
	 * Create a Parser of the Expression based on a Parser of Expression. 
	 * @param expressionParser A Parser of Expression (This is a class of our ParseTree model)
	 * @return A Parser of Expression (This is a class of our ParseTree model)
	 */
	private static Parser<Expression> blockKeyValueExpression(Parser<Expression> expressionParser) {
		return curry(BlockKeyValueExpression.class).sequence(
				TerminalParser.term(Operator.CURLY_BRACKET_OPEN.toString()),
				keyValuePairExpression(expressionParser).sepBy(TerminalParser.term(Operator.COMMA.toString())),
				TerminalParser.term(Operator.CURLY_BRACKET_CLOSE.toString()));
	}

	/**
	 * Create a Parser of the Expression based on a Parser of Expression. 
	 * @param expressionParser A Parser of Expression (This is a class of our ParseTree model)
	 * @return A Parser of Expression (This is a class of our ParseTree model)
	 */
	private static Parser<Expression> keyValuePairExpression(Parser<Expression> expressionParser) {
		return curry(KeyValuePair.class).sequence(Terminals.Identifier.PARSER,
				TerminalParser.term(Operator.COLON.toString()), expressionParser);
	}

	/**
	 * Create a Parser of the Expression. 
	 * @return A Parser of Expression (This is a class of our ParseTree model)
	 */
	private static Parser<Expression> numberExpression() {
		return curry(NaturalConstant.class).sequence(
				Terminals.IntegerLiteral.PARSER);
	}

	/**
	 * The parser which detects a Atom. 
	 */
	private static Parser<Expression> ATOM = Parsers.or(STRING_LITERAL,
	/*IDENTIFIER,*/ VAR, symbolConstant, numberExpression());

	/**
	 * Create a Parser of the Expression based on a Parser of ModuleBody and Expression. 
	 * @param expressionParser A Parser of Expression (This is a class of our ParseTree model)
	 * @param moduleBody A Parser of ModuleBody (This is a class of our ParseTree model)
	 * @return A Parser of Expression (This is a class of our ParseTree model)
	 */ 
	private static Parser<Expression> expression(Parser<Expression> expressionParser, Parser<ModuleBody> moduleBody) {
		Parser.Reference<Expression> ref = Parser.newReference();
		Parser<Expression> lazy = ref.lazy();
		expressionParser = Parsers.or(keyValuePairExpression(lazy),
						  blockExpression(lazy),
						  blockKeyValueExpression(lazy),
						  expressionParser);
		Parser<Expression> parser = new OperatorTable<Expression>().infixl(binary(Operator.DOT), 10).build(expressionParser);
		ref.set(parser);
		return parser;
	}

	/**
	 * Create a Parser of the Expression. 
	 * @return A Parser of Expression (This is a class of our ParseTree model)
	 */
	public static Parser<Expression> expressionParserNoOperator() {
		Parser<Expression> parser = ATOM;
		Parser.Reference<Expression> ref = Parser.newReference();
		Parser<Expression> lazy = ref.lazy();
		parser = Parsers.or(keyValuePairExpression(lazy),
				blockExpression(lazy),
				blockKeyValueExpression(lazy),
				parser);
		ref.set(parser);
		return parser;
	}

	/**
	 * Create a Parser of the Expression based on a Parser of ModuleBody. 
	 * @param moduleBody A Parser of ModuleBody (This is a class of our ParseTree model)
	 * @return A Parser of Expression (This is a class of our ParseTree model)
	 */
	public static Parser<Expression> expression(Parser<ModuleBody> moduleBody) {
		return expression(ATOM, moduleBody);
	}

	/**
	 * Create a Parser of the BinaryExpression based on a Operator. 
	 * @param op A Operator (This is a class of our ParseTree model)
	 * @return A Parser of BinaryExpression (This is a class of our ParseTree model)
	 */
	private static Parser<Binary<Expression>> binary(Operator op) {
		return TerminalParser.term(op.toString()).next(curry(ExpressionDotIdentifier.class, op).binary());
	}
	/**
	 * Utility method for construction of model objects for parsed data
	 * @param clazz the model class to load
	 * @param curryArgs the parameters used for the default constructor of the model class identified by
	 * parameter clazz
	 * @return Mapper that maps data to Java object Argument
	 * @see Argument
	 */
	private static Mapper<Expression> curry(Class<? extends Expression> clazz, Object... args) {
		return Mapper.curry(clazz, args);
	}

}

