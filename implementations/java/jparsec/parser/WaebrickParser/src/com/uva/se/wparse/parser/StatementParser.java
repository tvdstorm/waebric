/*
 * File			: StatementParser.java
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
import com.uva.se.wparse.model.statement.IfElse;
import com.uva.se.wparse.model.statement.If;
import com.uva.se.wparse.model.statement.LetIn;
import com.uva.se.wparse.model.statement.MarkupAndStatement;
import com.uva.se.wparse.model.statement.MarkupEmbedding;
import com.uva.se.wparse.model.statement.MarkupExpression;
import com.uva.se.wparse.model.statement.SingleMarkup;
import com.uva.se.wparse.model.statement.MultipleMarkup;
import com.uva.se.wparse.model.statement.Statement;
import com.uva.se.wparse.model.statement.Yield;

public final class StatementParser {

	private static Parser<Statement> comment() {
		return curry(Comment.class).sequence(
		TerminalParser.term(Keyword.COMMENT.toString()),
		ExpressionParser.STRING_LITERAL,
		TerminalParser.term(Operator.SEMI_COLON.toString()));
	}

	private static Parser<Statement> echo(Parser<Expression> expressionParser) {
		return curry(EchoExpression.class).sequence(
		TerminalParser.term(Keyword.ECHO.toString()), expressionParser,
		TerminalParser.term(Operator.SEMI_COLON.toString()));
	}

	private static Parser<Statement> echoEmbedding(Parser<Embedding> embeddingParser) {
		return curry(EchoEmbedding.class).sequence(
		TerminalParser.term(Keyword.ECHO.toString()),
		TerminalParser.term(Operator.DOUBLE_QUOTE.toString()), embeddingParser,
		TerminalParser.term(Operator.DOUBLE_QUOTE.toString()),
		TerminalParser.term(Operator.SEMI_COLON.toString()));
	}

	private static Parser<Statement> cdata(Parser<Expression> expressionParser) {
		return curry(Cdata.class).sequence(
		TerminalParser.term(Keyword.CDATA.toString()), expressionParser,
		TerminalParser.term(Operator.SEMI_COLON.toString()));
	}

	private static Parser<Statement> yield() {
		return curry(Yield.class).sequence(
		TerminalParser.term(Keyword.YIELD.toString()).source(),
		TerminalParser.term(Operator.SEMI_COLON.toString()));
	}

	private static Parser<Statement> ifStatement(
		Parser<Predicate> predicateParser, Parser<Statement> statementParser) {
		return curry(If.class).sequence(
		TerminalParser.phrase(Keyword.IF.toString() + " "
		+ Operator.ROUND_BRACKET_OPEN.toString()), predicateParser,
		TerminalParser.term(Operator.ROUND_BRACKET_CLOSE.toString()), statementParser)
		.notFollowedBy(TerminalParser.term(Keyword.ELSE.toString()));
	}

	private static Parser<Statement> ifElse(Parser<Predicate> predicateParser,
		Parser<Statement> statementParser) {
		return curry(IfElse.class).sequence(
		TerminalParser.phrase(Keyword.IF.toString() + " "
		+ Operator.ROUND_BRACKET_OPEN.toString()), predicateParser,
		TerminalParser.term(Operator.ROUND_BRACKET_CLOSE.toString()), statementParser,
		TerminalParser.term(Keyword.ELSE.toString()), statementParser);
	}

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

	private static Parser<Statement> block(Parser<Statement> statementParser) {
		return curry(Block.class).sequence(
		TerminalParser.phrase(Operator.CURLY_BRACKET_OPEN.toString()),
		statementParser.many(),
		TerminalParser.term(Operator.CURLY_BRACKET_CLOSE.toString()));
	}

	private static Parser<Statement> letIn(Parser<Assignment> assignmentParser,
		Parser<Statement> statementParser) {
		return curry(LetIn.class).sequence(
		TerminalParser.term(Keyword.LET.toString()),
		assignmentParser.many1(),
		TerminalParser.term(Keyword.IN.toString()),
		statementParser.many(),
		TerminalParser.term(Keyword.END.toString()));
	}

	private static Parser<Statement> markup(Parser<Markup> markupParser) {
		return curry(MultipleMarkup.class).sequence(markupParser.atLeast(2), 
		TerminalParser.term(Operator.SEMI_COLON.toString()));
	}

	private static Parser<Statement> singleMarkup(Parser<Markup> markupParser) {
		return curry(SingleMarkup.class).sequence(markupParser,
		TerminalParser.term(Operator.SEMI_COLON.toString()));
	}

	private static Parser<Statement> markupExpression(Parser<Markup> markupParser,
		Parser<Expression> expressionParser) {
		return curry(MarkupExpression.class).sequence(
		markupParser,
		Parsers.or(expressionParser, markupParser.many()).optional(),
		expressionParser.optional(),
		TerminalParser.term(Operator.SEMI_COLON.toString()));
	}

	private static Parser<Statement> markupEmbedding(Parser<Markup> markupParser,
		Parser<Embedding> embedding) {
		return curry(MarkupEmbedding.class).sequence(markupParser.many1(),
		TerminalParser.term(Operator.DOUBLE_QUOTE.toString()), embedding,
		TerminalParser.term(Operator.DOUBLE_QUOTE.toString()),
		TerminalParser.term(Operator.SEMI_COLON.toString()));
	}

	private static Parser<Statement> markupAndStatement(Parser<Markup> markupParser,
		Parser<Statement> statementParser) {
		return curry(MarkupAndStatement.class).sequence(markupParser.many1(), statementParser);
	}

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
		    markupEmbedding(markupParser,embeddingParser),
		    echoEmbedding(embeddingParser),
		    echo(expressionParser),
		    cdata(expressionParser),
		    yield(),
		    markupExpression(markupParser, expressionParser),
		    markup(markupParser),
		    block(lazy));
		ref.set(parser);
		return parser;
	}

	private static Mapper<Statement> curry(Class<? extends Statement> clazz, Object... curryArgs) {
		return Mapper.curry(clazz, curryArgs);
	}

}
