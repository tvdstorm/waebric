/*
 * File			: ArgumentParser.java
 * Project		: WaebrickParser
 * 				: Practicum opdracht Software Construction
 * 
 * Authors		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * 
 * Description	:
 * 
 */
package com.uva.se.wparse.parser;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.Terminals;
import org.codehaus.jparsec.misc.Mapper;

import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.markup.Argument;
import com.uva.se.wparse.model.markup.BlockArgument;
import com.uva.se.wparse.model.markup.SingleArgument;
import com.uva.se.wparse.model.statement.AssignmentArgument;

public class ArgumentParser {

	private static Parser<Argument> assignmentArgument(Parser<Expression> expr) {
		return curry(AssignmentArgument.class).sequence(
				Terminals.Identifier.PARSER, TerminalParser.term("="), expr);
	}
	
	private static Parser<Argument> singleArgument(Parser<Expression> expr) {
		return curry(SingleArgument.class).sequence(expr);
	}

	public static Parser<Argument> blockArgument(Parser<Argument> arg) {
		return curry(BlockArgument.class).sequence(
				TerminalParser.term("("), arg.sepBy(TerminalParser.term(",")),
				TerminalParser.term(")"));
	}

	public static Parser<Argument> arguments(Parser<Expression> expr) {
		Parser.Reference<Argument> ref = Parser.newReference();
		Parser<Argument> lazy = ref.lazy();

		@SuppressWarnings("unchecked")
		Parser<Argument> parser = Parsers.or(
				assignmentArgument(expr),
				blockArgument(lazy),
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
