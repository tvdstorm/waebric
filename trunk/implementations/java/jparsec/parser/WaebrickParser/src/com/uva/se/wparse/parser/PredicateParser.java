/*
 * File			: AssignmentParser.java
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

import org.codehaus.jparsec.OperatorTable;
import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.functors.Binary;
import org.codehaus.jparsec.misc.Mapper;

import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.predicate.OperatorPredicate;
import com.uva.se.wparse.model.predicate.NotPredicate;
import com.uva.se.wparse.model.predicate.Predicate;
import com.uva.se.wparse.model.predicate.TypeCheckPredicate;

public final class PredicateParser {

	private static Parser<Predicate> typeCheck(Parser<Expression> expressionParser) {
		return curry(TypeCheckPredicate.class).sequence(
				expressionParser,
				TerminalParser.term(Operator.DOT.toString()),
				Parsers.or(	TerminalParser.term(Keyword.LIST.toString()),
							TerminalParser.term(Keyword.RECORD.toString()),
							TerminalParser.term(Keyword.STRING.toString())).source(),
				TerminalParser.term(Operator.QUESTION.toString())

		);
	}
	
	
	private static Parser<Predicate> notPredicate(Parser<Predicate> predicateParser) {
		return curry(NotPredicate.class).sequence(
				TerminalParser.term(Operator.NOT.toString()), predicateParser );
	}

	public static Parser<Predicate> predicates(Parser<Expression> expressionParser) {
		//create a expression parser that does not parse for the dot operator
		Parser<Expression> expressionParserNoOperators = ExpressionParser.expressionParserNoOperator();
		Parser.Reference<Predicate> ref = Parser.newReference();
		Parser<Predicate> lazy = ref.lazy();
		Parser<Predicate> parser = Parsers.or(
						typeCheck(expressionParserNoOperators),
						notPredicate(lazy));
		
		
		 parser = new OperatorTable<Predicate>()
	        .infixl(binary(Operator.AND), 10)
	        .infixl(binary(Operator.OR), 10)
	        .build(parser);
			ref.set(parser);
		return parser;
	}
	
	
	private static Parser<Binary<Predicate>> binary(Operator op) {
	    return TerminalParser.term(op.toString()).next(curry(OperatorPredicate.class, op).binary());
	}
	
	

	private static Mapper<Predicate> curry(Class<? extends Predicate> clazz, Object... curryArgs) {
		return Mapper.curry(clazz, curryArgs);
	}

}
