/*
 * File			: StatementParser.java
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

import com.uva.se.wparse.model.embedding.Embedding;
import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.model.predicate.Predicate;
import com.uva.se.wparse.model.statement.Assignment;
import com.uva.se.wparse.model.statement.Block;
import com.uva.se.wparse.model.statement.Cdata;
import com.uva.se.wparse.model.statement.Comment;
import com.uva.se.wparse.model.statement.Each;
import com.uva.se.wparse.model.statement.EchoEmbedding;
import com.uva.se.wparse.model.statement.EchoExpression;
import com.uva.se.wparse.model.statement.If;
import com.uva.se.wparse.model.statement.IfElse;
import com.uva.se.wparse.model.statement.LetIn;
import com.uva.se.wparse.model.statement.MarkupAndStatement;
import com.uva.se.wparse.model.statement.MarkupEmbedding;
import com.uva.se.wparse.model.statement.MarkupExpression;
import com.uva.se.wparse.model.statement.SingleMarkup;
import com.uva.se.wparse.model.statement.Statement;
import com.uva.se.wparse.model.statement.Yield;

/**
 * Several Parsers for parsing the statements 
 * of the Waebric language. 
 */
public final class StatementParser {

	/**
	 * Create a Parser of the Statement.
	 * @return A Parser of Statement (This is a class of our ParseTree model). 
	 */
	private static Parser<Statement> comment() {
		return curry(Comment.class).sequence(
		TerminalParser.term(Keyword.COMMENT.toString()),
		ExpressionParser.STRING_LITERAL,
		TerminalParser.term(Operator.SEMI_COLON.toString()));
	}

	/**
	 * Create a Parser of the Statement based on a Parser of Expression. 
	 * @param expressionParser A Parser of Expression (This is a class of our ParseTree model). 
	 * @return A Parser of Statement (This is a class of our ParseTree model). 
	 */
	private static Parser<Statement> echo(Parser<Expression> expressionParser) {
		return curry(EchoExpression.class).sequence(
		TerminalParser.term(Keyword.ECHO.toString()), expressionParser,
		TerminalParser.term(Operator.SEMI_COLON.toString()));
	}

	/**
	 * Create a Parser of the Statement based on a Parser of Embedding. 
	 * @param embedding Parser A Parser of Embedding (This is a class of our ParseTree model). 
	 * @return A Parser of Statement (This is a class of our ParseTree model). 
	 */
	private static Parser<Statement> echoEmbedding(Parser<Embedding> embeddingParser) {
		return curry(EchoEmbedding.class).sequence(
		TerminalParser.term(Keyword.ECHO.toString()),
		TerminalParser.term(Operator.DOUBLE_QUOTE.toString()),
		embeddingParser,
		TerminalParser.term(Operator.DOUBLE_QUOTE.toString()),
		TerminalParser.term(Operator.SEMI_COLON.toString()));
	}

	/**
	 * Create a Parser of the Statement based on a Parser of Expression. 
	 * @param expressionParser A Parser of Expression (This is a class of our ParseTree model). 
	 * @return A Parser of Statement (This is a class of our ParseTree model). 
	 */
	private static Parser<Statement> cdata(Parser<Expression> expressionParser) {
		return curry(Cdata.class).sequence(
		TerminalParser.term(Keyword.CDATA.toString()), expressionParser,
		TerminalParser.term(Operator.SEMI_COLON.toString()));
	}

	/**
	 * Create a Parser of the Statement. 
	 * @return A Parser of Statement (This is a class of our ParseTree model). 
	 */
	private static Parser<Statement> yield() {
		return curry(Yield.class).sequence(
		TerminalParser.term(Keyword.YIELD.toString()).source(),
		TerminalParser.term(Operator.SEMI_COLON.toString()));
	}

	/**
	 * Create a Parser of the Statement based on a Parser of Predicate and Statement. 
	 * @param predicateParser A Parser of Predicate (This is a class of our ParseTree model). 
	 * @param statementParser A Parser of Statement (This is a class of our ParseTree model). 
	 * @return A Parser of Statement (This is a class of our ParseTree model). 
	 */
	private static Parser<Statement> ifStatement(
		Parser<Predicate> predicateParser, Parser<Statement> statementParser) {
		return curry(If.class).sequence(
		TerminalParser.phrase(Keyword.IF.toString() + " "
		+ Operator.ROUND_BRACKET_OPEN.toString()), predicateParser,
		TerminalParser.term(Operator.ROUND_BRACKET_CLOSE.toString()), statementParser)
		.notFollowedBy(TerminalParser.term(Keyword.ELSE.toString()));
	}

	/**
	 * Create a Parser of the Statement based on a Parser of Predicate and Statement. 
	 * @param predicateParser A Parser of Predicate (This is a class of our ParseTree model). 
	 * @param statementParser A Parser of Statement (This is a class of our ParseTree model). 
	 * @return A Parser of Statement (This is a class of our ParseTree model). 
	 */
	private static Parser<Statement> ifElse(Parser<Predicate> predicateParser,
		Parser<Statement> statementParser) {
		return curry(IfElse.class).sequence(
		TerminalParser.phrase(Keyword.IF.toString() + " "
		+ Operator.ROUND_BRACKET_OPEN.toString()), predicateParser,
		TerminalParser.term(Operator.ROUND_BRACKET_CLOSE.toString()), statementParser,
		TerminalParser.term(Keyword.ELSE.toString()), statementParser);
	}

	/**
	 * Create a Parser of the Statement based on a Parser of Expression and Statement. 
	 * @param expressionParser A Parser of Expression (This is a class of our ParseTree model). 
	 * @param statementParser A Parser of Statement (This is a class of our ParseTree model). 
	 * @return A Parser of Statement (This is a class of our ParseTree model). 
	 */
	private static Parser<Statement> each(Parser<Expression> expressionParser,
		Parser<Statement> statementParser) {
		return curry(Each.class).sequence(
		TerminalParser.phrase(Keyword.EACH.toString() + " " +
		Operator.ROUND_BRACKET_OPEN.toString()),
		ExpressionParser.IDENTIFIER,
		TerminalParser.term(Operator.COLON.toString()),
		expressionParser,
		TerminalParser.term(Operator.ROUND_BRACKET_CLOSE.toString()),
		statementParser);
	}

	/**
	 * Create a Parser of the Statement based on a Parser of Statement. 
	 * @param statementParser A Parser of Statement (This is a class of our ParseTree model). 
	 * @return A Parser of Statement (This is a class of our ParseTree model). 
	 */
	private static Parser<Statement> block(Parser<Statement> statementParser) {
		return curry(Block.class).sequence(
		TerminalParser.phrase(Operator.CURLY_BRACKET_OPEN.toString()),
		statementParser.many(),
		TerminalParser.term(Operator.CURLY_BRACKET_CLOSE.toString()));
	}

	/**
	 * Create a Parser of the Statement based on a Parser of Assignment and Statement. 
	 * @param assignmentParser A Parser of Assignment (This is a class of our ParseTree model). 
	 * @param statementParser A Parser of Statement (This is a class of our ParseTree model). 
	 * @return A Parser of Statement (This is a class of our ParseTree model). 
	 */
	private static Parser<Statement> letIn(Parser<Assignment> assignmentParser,
		Parser<Statement> statementParser) {
		return curry(LetIn.class).sequence(
		TerminalParser.term(Keyword.LET.toString()),
		assignmentParser.many1(),
		TerminalParser.term(Keyword.IN.toString()),
		statementParser.many(),
		TerminalParser.term(Keyword.END.toString()));
	}

	/**
	 * Create a Parser of the Statement based on a Parser of Markup. 
	 * @param markupParser A Parser of Markup (This is a class of our ParseTree model). 
	 * @return A Parser of Statement (This is a class of our ParseTree model). 
	 */
	private static Parser<Statement> singleMarkup(Parser<Markup> markupParser) {
		return curry(SingleMarkup.class).sequence(markupParser,
		TerminalParser.term(Operator.SEMI_COLON.toString()));
	}

	/**
	 * Create a Parser of the Statement based on a Parser of Markup and Expression. 
	 * @param markupParser A Parser of Markup (This is a class of our ParseTree model). 
	 * @param expressionParser A Parser of Expression (This is a class of our ParseTree model). 
	 * @return A Parser of Statement (This is a class of our ParseTree model). 
	 */
	private static Parser<Statement> markupExpression(Parser<Markup> markupParser,
		Parser<Expression> expressionParser) {
		return curry(MarkupExpression.class).sequence(
		markupParser.many1(),	 
		expressionParser.optional(),
		TerminalParser.term(Operator.SEMI_COLON.toString()));
	}
	
	/**
	 * Create a Parser of the Statement based on a Parser of Markup and Embedding. 
	 * @param markupParser A Parser of Markup (This is a class of our ParseTree model). 
	 * @param embedding A Parser of Embedding (This is a class of our ParseTree model). 
	 * @return A Parser of Statement (This is a class of our ParseTree model). 
	 */
	private static Parser<Statement> markupEmbedding(Parser<Markup> markupParser,
		Parser<Embedding> embedding) {
		return curry(MarkupEmbedding.class).sequence(markupParser.many1(),
		TerminalParser.term(Operator.DOUBLE_QUOTE.toString()), embedding,
		TerminalParser.term(Operator.DOUBLE_QUOTE.toString()),
		TerminalParser.term(Operator.SEMI_COLON.toString()));
	}

	/**
	 * Create a Parser of the Statement based on a Parser of Markup and Statement. 
	 * @param markupParser A Parser of Markup (This is a class of our ParseTree model). 
	 * @param statementParser A Parser of Statement (This is a class of our ParseTree model). 
	 * @return A Parser of Statement (This is a class of our ParseTree model). 
	 */
	private static Parser<Statement> markupAndStatement(Parser<Markup> markupParser,
		Parser<Statement> statementParser) {
		return curry(MarkupAndStatement.class).sequence(markupParser.many1(), statementParser);
	}

	/**
	 * Create a Statement of the Member based on a Parser of Expression and Markup. 
	 * @param expressionParser A Parser of Expression (This is a class of our ParseTree model). 
	 * @param markupParser A Parser of Markup (This is a class of our ParseTree model). 
	 * @return A Parser of Statement (This is a class of our ParseTree model). 
	 */
	public static Parser<Statement> statement(Parser<Expression> expressionParser, Parser<Markup> markupParser) {
		Parser.Reference<Statement> ref = Parser.newReference();
		Parser<Statement> lazy = ref.lazy();
		Parser<Assignment> assignmentParser =
		AssignmentParser.assignment(lazy, expressionParser);
		Parser<Embedding> embeddingParser =
		EmbeddingParser.getParser(markupParser, expressionParser);
		Parser<Predicate> predicateParser =
		PredicateParser.predicates(expressionParser);

		
		@SuppressWarnings("unchecked")
		Parser<Statement> parser =
		Parsers.or(
		    markupAndStatement(markupParser, lazy),
		    ifElse(predicateParser, lazy),
		    ifStatement(predicateParser,lazy),
		    each(expressionParser, lazy),
		    letIn(assignmentParser, lazy),
		    comment(),
		    singleMarkup(markupParser),		
		    markupExpression(markupParser, expressionParser),
		    markupEmbedding(markupParser,embeddingParser),
		    echoEmbedding(embeddingParser),
		    echo(expressionParser),
		    cdata(expressionParser),
		    yield(),
		    block(lazy));
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
	private static Mapper<Statement> curry(Class<? extends Statement> clazz, Object... curryArgs) {
		return Mapper.curry(clazz, curryArgs);
	}
}
