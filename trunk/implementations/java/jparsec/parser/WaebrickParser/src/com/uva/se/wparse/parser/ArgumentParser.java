/*
 * File			: ArgumentParser.java
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

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.misc.Mapper;

import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.markup.Argument;
import com.uva.se.wparse.model.markup.AssignmentArgument;
import com.uva.se.wparse.model.markup.BlockArgument;
import com.uva.se.wparse.model.markup.SingleArgument;

public class ArgumentParser {
	

	private static Parser<Argument> assignmentArgument(Parser<Expression> expr) {
		return curry(AssignmentArgument.class).sequence(
				ExpressionParser.IDENTIFIER.source(), TerminalParser.term(Operator.EQUALS.toString()),  expr);
	}
	
	private static Parser<Argument> assignmentArgumentString(Parser<Expression> expr) {
		return curry(AssignmentArgument.class).sequence(
				ExpressionParser.IDENTIFIER.source(), TerminalParser.term(Operator.EQUALS.toString()),
				ExpressionParser.STRING_LITERAL
				);
	}
	
	
	
	private static Parser<Argument> singleArgument(Parser<Expression> expr) {
		return curry(SingleArgument.class).sequence(expr);
	}

	public static Parser<Argument> blockArgument(Parser<Argument> arg) {
		return curry(BlockArgument.class).sequence(
				TerminalParser.term(Operator.ROUND_BRACKET_OPEN.toString()),
				arg.sepBy(TerminalParser.term(Operator.COMMA.toString())),
				TerminalParser.term(Operator.ROUND_BRACKET_CLOSE.toString())
				);
	}
	
	
	public static Parser<Argument> arguments(Parser<Expression> expr) {
		Parser.Reference<Argument> ref = Parser.newReference();
		Parser<Argument> lazy = ref.lazy();

		Parser<Argument> parser = Parsers.or(
				blockArgument(lazy),
				assignmentArgument(expr),
				assignmentArgumentString(expr),
				singleArgument(expr)
				);
		ref.set(parser);
		return parser;
	}
	
	private static Mapper<Argument> curry(
			Class<? extends Argument> clazz, Object... curryArgs) {
		return Mapper.curry(clazz, curryArgs);
	}

}
