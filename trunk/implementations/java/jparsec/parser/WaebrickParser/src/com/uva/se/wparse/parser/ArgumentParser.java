/*
 * File			: ArgumentParser.java
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

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.misc.Mapper;

import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.markup.Argument;
import com.uva.se.wparse.model.markup.AssignmentArgument;
import com.uva.se.wparse.model.markup.BlockArgument;
import com.uva.se.wparse.model.markup.SingleArgument;

/**
 * Parsers the arguments of the Waebric language. 
 */
public class ArgumentParser {
	
	/**
	 * Create a Parser of the Argument based on a Parser of Expression. 
	 * @param expressionParser A Parser of Member (This is a class of our ParseTree model)
	 * @return A Parser of Member (This is a class of our ParseTree model)
	 */
	private static Parser<Argument> assignmentArgument(Parser<Expression> expressionParser) {
		return curry(AssignmentArgument.class).sequence(
		ExpressionParser.IDENTIFIER,
		TerminalParser.term(Operator.EQUALS.toString()),
		expressionParser);
	}
	
	/**
	 * Create a Parser of the Argument.
	 * @return A Parser of Argument (This is a class of our ParseTree model)
	 */
	private static Parser<Argument> assignmentArgumentString() {
		return curry(AssignmentArgument.class).sequence(
		ExpressionParser.IDENTIFIER,
		TerminalParser.term(Operator.EQUALS.toString()),
		ExpressionParser.STRING_LITERAL);
	}
	
	/**
	 * Create a Parser of the Argument based on a Parser of Expression 
	 * @param expressionParser A Parser of Expression (This is a class of our ParseTree model).  
	 * @return A Parser of Argument (This is a class of our ParseTree model).  
	 */
	private static Parser<Argument> singleArgument(Parser<Expression> expressionParser) {
		return curry(SingleArgument.class).sequence(expressionParser);
	}

	/**
	 * Create a Parser of the Argument based on a Parser of Argument 
	 * @param argumentParser A Parser of Argument (This is a class of our ParseTree model).  
	 * @return A Parser of Argument (This is a class of our ParseTree model).  
	 */ 
	public static Parser<Argument> blockArgument(Parser<Argument> argumentParser) {
		return curry(BlockArgument.class).sequence(
		TerminalParser.term(Operator.ROUND_BRACKET_OPEN.toString()),
		argumentParser.sepBy(TerminalParser.term(Operator.COMMA.toString())),
		TerminalParser.term(Operator.ROUND_BRACKET_CLOSE.toString()));
	}
	
	/**
	 * Create a Parser of the Argument based on a Parser of Expression. 
	 * @param expressionParser A Parser of Expression (This is a class of our ParseTree model).  
	 * @return A Parser of Argument (This is a class of our ParseTree model).  
	 */
	public static Parser<Argument> arguments(Parser<Expression> expressionParser) {
		Parser.Reference<Argument> ref = Parser.newReference();
		Parser<Argument> lazy = ref.lazy();
		Parser<Argument> parser = Parsers.or(
				blockArgument(lazy),
				assignmentArgument(expressionParser),
				assignmentArgumentString(),
				singleArgument(expressionParser)
				);
		ref.set(parser);
		return parser;
	}
	
	/**
	 * Utility method for construction of model objects for parsed data
	 * @param clazz the model class to load
	 * @param curryArgs the parameters used for the default constructor of the model class identified by
	 * parameter clazz
	 * @return Mapper that maps data to Java object Argument
	 * @see Argument
	 */
	private static Mapper<Argument> curry(Class<? extends Argument> clazz, Object... curryArgs) {
		return Mapper.curry(clazz, curryArgs);
	}
}
