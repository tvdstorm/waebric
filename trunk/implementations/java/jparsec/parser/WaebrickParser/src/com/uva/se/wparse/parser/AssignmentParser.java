/*
 * File			: AssignmentParser.java
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
import org.codehaus.jparsec.Terminals;
import org.codehaus.jparsec.misc.Mapper;

import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.statement.Assignment;
import com.uva.se.wparse.model.statement.AssignmentExpression;
import com.uva.se.wparse.model.statement.AssignmentFormals;
import com.uva.se.wparse.model.statement.Statement;

/**
 * Parse the Assignments of the Waebric language. 
 */
public final class AssignmentParser {

	/**
	 * Create a Parser of the Assignment based on a Parser of Expression. 
	 * @param expressionParser A Parser of Expression (This is a class of our ParseTree model).  
	 * @return A Parser of Assignment (This is a class of our ParseTree model).  
	 */
	private static Parser<Assignment> assignmentNormal(Parser<Expression> expressionParser) {
		return curry(AssignmentExpression.class).sequence(ExpressionParser.IDENTIFIER,
		TerminalParser.term(Operator.EQUALS.toString()),
		expressionParser,
		TerminalParser.term(Operator.SEMI_COLON.toString()));
	}

	/**
	 * Create a Parser of the Assignment based on a Parser of Statement. 
	 * @param statementParser A Parser of Statement (This is a class of our ParseTree model).  
	 * @return A Parser of Assignment (This is a class of our ParseTree model).  
	 */
	private static Parser<Assignment> assignmentFormals(Parser<Statement> statementParser) {
		return curry(AssignmentFormals.class).sequence(Terminals.Identifier.PARSER,
		TerminalParser.term(Operator.ROUND_BRACKET_OPEN.toString()),
		ExpressionParser.IDENTIFIER.sepBy1(TerminalParser.term(Operator.COMMA.toString())),
		TerminalParser.term(Operator.ROUND_BRACKET_CLOSE.toString()),
		TerminalParser.term(Operator.EQUALS.toString()),
		statementParser);
	}

	/**
	 * Create a Parser of the Assignment based on a Parser of Statement and Expression. 
	 * @param statementParser A Parser of Statement (This is a class of our ParseTree model).  
	 * @param expressionParser A Parser of Expression (This is a class of our ParseTree model).  
	 * @return A Assignment of Member (This is a class of our ParseTree model).  
	 */
	public static Parser<Assignment> assignment(Parser<Statement> statementParser, Parser<Expression> expressionParser) {
 		Parser.Reference<Assignment> ref = Parser.newReference();
		Parser<Assignment> parser = Parsers.or(assignmentFormals(statementParser),
		assignmentNormal(expressionParser));
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
	private static Mapper<Assignment> curry(Class<? extends Assignment> clazz, Object... curryArgs) {
		return Mapper.curry(clazz, curryArgs);
	}
}
