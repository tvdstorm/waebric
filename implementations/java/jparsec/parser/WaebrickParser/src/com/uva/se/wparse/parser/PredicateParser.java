/*
 * File			: PredicateParser.java
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

import org.codehaus.jparsec.OperatorTable;
import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.functors.Binary;
import org.codehaus.jparsec.misc.Mapper;

import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.predicate.OperatorPredicate;
import com.uva.se.wparse.model.predicate.NotPredicate;
import com.uva.se.wparse.model.predicate.Predicate;
import com.uva.se.wparse.model.predicate.ExpressionPredicate;
import com.uva.se.wparse.model.predicate.TypeCheckPredicate;

/**
 * Consists of the Parsers which are used for predicates of the 
 * language Waebric. 
 */
public final class PredicateParser {

	/**
	 * Create a Parser of the Predicate based on a Parser of Expression.
	 * @param expressionParser A Parser of Expression (This is a class of our ParseTree model). 
	 * @return A Parser of Predicate (This is a class of our ParseTree model). 
	 */
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
	
	/**
	 * Create a Parser of the Predicate based on a Parser of Predicate.
	 * @param predicateParser A Parser of Predicate (This is a class of our ParseTree model). 
	 * @return A Parser of Predicate (This is a class of our ParseTree model). 
	 */
	private static Parser<Predicate> notPredicate(Parser<Predicate> predicateParser) {
		return curry(NotPredicate.class).sequence(
				TerminalParser.term(Operator.NOT.toString()), predicateParser );
	}
	
	/**
	 * Create a Parser of the Predicate based on a Parser of Expression.
	 * @param expressionParser A Parser of Expression (This is a class of our ParseTree model). 
	 * @return A Parser of Predicate (This is a class of our ParseTree model). 
	 */
	private static Parser<Predicate> expressionPredicate(Parser<Expression> expressionParser) {
		return curry(ExpressionPredicate.class).sequence(expressionParser);
	}

	/**
	 * Create a Parser of the Predicate based on a Parser of Expression.
	 * @param expressionParser A Parser of Expression (This is a class of our ParseTree model). 
	 * @return A Parser of Predicate (This is a class of our ParseTree model). 
	 */
	public static Parser<Predicate> predicates(Parser<Expression> expressionParser) {
		//create a expression parser that does not parse for the dot operator
		Parser<Expression> expressionParserNoOperators = ExpressionParser.expressionParserNoOperator();
		Parser.Reference<Predicate> ref = Parser.newReference();
		Parser<Predicate> lazy = ref.lazy();
		Parser<Predicate> parser = Parsers.or(
						typeCheck(expressionParserNoOperators),
						notPredicate(lazy),
						expressionPredicate(expressionParser)
						);
		
		
		 parser = new OperatorTable<Predicate>()
	        .infixl(binary(Operator.AND), 10)
	        .infixl(binary(Operator.OR), 10)
	        .build(parser);
			ref.set(parser);
		return parser;
	}
	
	/**
	 * Create a Parser of the BinaryPredicate based on a Operator.
	 * @param operator An Operator (This is a class of our ParseTree model). 
	 * @return A Parser of BinaryPredicate (This is a class of our ParseTree model). 
	 */
	private static Parser<Binary<Predicate>> binary(Operator operator) {
	    return TerminalParser.term(operator.toString()).next(curry(OperatorPredicate.class, operator).binary());
	}
	
	/**
	 * Utility method for construction of model objects for parsed data
	 * @param clazz the model class to load
	 * @param curryArgs the parameters used for the default constructor of the model class identified by
	 * parameter clazz
	 * @return Mapper that maps data to Java object Argument
	 * @see Argument
	 */
	private static Mapper<Predicate> curry(Class<? extends Predicate> clazz, Object... curryArgs) {
		return Mapper.curry(clazz, curryArgs);
	}

}
