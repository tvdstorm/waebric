/*
 * File			: ExpressionParser.java
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

import java.util.regex.Pattern;

import org.apache.log4j.Logger;
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
import com.uva.se.wparse.model.expression.Operator;
import com.uva.se.wparse.model.expression.StringLiteral;
import com.uva.se.wparse.model.expression.SymbolConstant;
import com.uva.se.wparse.model.module.ModuleBody;
import com.uva.se.wparse.model.statement.SingleMarkup;

public class ExpressionParser {

	private static org.apache.log4j.Logger logger = Logger.getLogger(ExpressionParser.class);
	
	@SuppressWarnings("unchecked")
	public static Parser LITERAL_TEXT = Parsers.sequence(Parsers
			.token(new TokenMap<String>() {
				public String map(Token token) {
					///char[] data = token.value().toString().toCharArray();
					String value = token.value().toString();
//					if("\"".equals(value)){
//						value = "\\" + value;
//					}
					if (!value.equals("\"")) {
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

	@SuppressWarnings("unchecked")
	public static Parser EMBEDDED_TEXT = Parsers.sequence(Parsers
			.token(new TokenMap<String>() {

				public String map(Token token) {
					if (!token.value().toString().equals("\"")
							&& !token.value().toString().equals("<")
							&& !token.value().toString().equals(">")) {
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
	
	
	@SuppressWarnings("unchecked")
	public static Parser SYMBOL_TEXT = Parsers.sequence(Parsers
			.token(new TokenMap<String>() {

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
	
	@SuppressWarnings("unchecked")
	public static Parser ID_CON = Parsers.sequence(Parsers.token(new TokenMap<String>() {

				public String map(Token token) {
					
					int prefixIndex = token.index() - 1;
					if (prefixIndex > 0) {
						// get the token to the left of the current token
						char prefixChar = TerminalParser.getSource()
								.charAt(prefixIndex);
						if (prefixChar == ' ') {
							return null; 
						}
					}
					
					String value = token.value().toString();
					boolean isIdentifier = Pattern.matches("[A-Za-z\\-0-9]*", value);
					if(!isIdentifier){
						return null;
					}
					return token.value().toString();
				}

			}

			));
	@SuppressWarnings("unchecked")
	public static Parser ID_CON_START = Parsers.sequence(Parsers.token(new TokenMap<String>() {

		public String map(Token token) {

			
			String value = token.value().toString();
			//check for reserved keyword, if detected then the token
			//cannot be a identifier.
			if( TerminalParser.KEYWORD_YIELD.equals(value) ||
				TerminalParser.KEYWORD_ECHO.equals(value) ||
				TerminalParser.KEYWORD_COMMENT.equals(value) ||
				TerminalParser.KEYWORD_CDATA.equals(value) ||
				TerminalParser.KEYWORD_EACH.equals(value) ||
				TerminalParser.KEYWORD_LET.equals(value) ||
				TerminalParser.KEYWORD_YIELD.equals(value) ||
				TerminalParser.KEYWORD_MODULE.equals(value) ||
				TerminalParser.KEYWORD_IMPORT.equals(value) ||
				TerminalParser.KEYWORD_DEF.equals(value) ||
				TerminalParser.KEYWORD_END.equals(value) ||
				TerminalParser.KEYWORD_SITE.equals(value)
					
			){
//				if (logger.isDebugEnabled()) {
//					logger.debug("Illegal identifier < reserved keyword>: " + value );
//				}
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
	
	@SuppressWarnings("unchecked")
	public static Parser FILE_EXT = Parsers.sequence(Parsers.token(new TokenMap<String>() {

		public String map(Token token) {
			
			String value = token.value().toString();
			boolean isIdentifier = Pattern.matches("[A-Za-z0-9]*", value);
			if(!isIdentifier){
				return null;
			}
			return token.value().toString();
		}

	}

	));
	
	@SuppressWarnings("unchecked")
	public static Parser PATH_ELEMENT_TEXT = Parsers.sequence(Parsers
			.token(new TokenMap<String>() {

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
	
	//public static Parser<Expression> IDENTIFIER = curry(Identifier.class).sequence(Terminals.Identifier.PARSER, ID_CON.many().source());
	
	public static Parser<Expression> IDENTIFIER = curry(Identifier.class).sequence(ID_CON_START.source(), ID_CON.many().source());
	
	public static Parser<Expression> PATH_ELEMENT = curry(Identifier.class).sequence(PATH_ELEMENT_TEXT.source(), ID_CON.many().source());
	

	/**
	 * Not allowed are control characters 0-31, and extended ascii 127-255
	 */
	@SuppressWarnings("unchecked")
	private static Parser<Expression> symbolConstant = curry(
			SymbolConstant.class).sequence(TerminalParser.term("'"),
					Parsers.or(SYMBOL_TEXT.many())
			);

	public static Parser<Expression> STRING_LITERAL = curry(
			StringLiteral.class).sequence(
					TerminalParser.term("\""),
					LITERAL_TEXT.many(),
					TerminalParser.term("\"")
					);

	private static Parser<Expression> blockExpression(Parser<Expression> expr) {
		return curry(BlockExpression.class).sequence(TerminalParser.term("["),
				expr.sepBy(TerminalParser.term(",")), TerminalParser.term("]"));
	}

	private static Parser<Expression> blockKeyValueExpression(
			Parser<Expression> expr) {
		return curry(BlockKeyValueExpression.class).sequence(
				TerminalParser.term("{"),
				keyValuePairExpression(expr).sepBy(TerminalParser.term(",")),
				TerminalParser.term("}"));
	}

	private static Parser<Expression> keyValuePairExpression(
			Parser<Expression> expr) {
		return curry(KeyValuePair.class).sequence(Terminals.Identifier.PARSER,
				TerminalParser.term(":"), expr);
	}

	private static Parser<Expression> numberExpression() {
		return curry(NaturalConstant.class).sequence(
				Terminals.IntegerLiteral.PARSER);
	}

	private static Parser<Expression> ATOM = Parsers.or(STRING_LITERAL,
			IDENTIFIER, symbolConstant, numberExpression());

	private static Parser<Expression> expression(Parser<Expression> atom, Parser<ModuleBody> moduleBody) {
		Parser.Reference<Expression> ref = Parser.newReference();
		Parser<Expression> lazy = ref.lazy();
		atom = Parsers.or(keyValuePairExpression(lazy),
						  blockExpression(lazy),
						  blockKeyValueExpression(lazy),
						  atom);
		Parser<Expression> parser = new OperatorTable<Expression>().infixl(
				binary(Operator.DOT), 10).build(atom);
		ref.set(parser);
		return parser;
	}

	public static Parser<Expression> expressionParserNoOperator() {
		Parser<Expression> parser = ATOM;
		Parser.Reference<Expression> ref = Parser.newReference();
		Parser<Expression> lazy = ref.lazy();
		parser = Parsers.or(keyValuePairExpression(lazy),
				blockExpression(lazy), blockKeyValueExpression(lazy), parser);

		ref.set(parser);
		return parser;
	}

	public static Parser<Expression> expression(Parser<ModuleBody> moduleBody) {
		return expression(ATOM, moduleBody);
	}

	private static Parser<Binary<Expression>> binary(Operator op) {
		return TerminalParser.term(op.toString()).next(
				curry(ExpressionDotIdentifier.class, op).binary());
	}

	private static Mapper<Expression> curry(Class<? extends Expression> clazz,
			Object... args) {
		return Mapper.curry(clazz, args);
	}

}

