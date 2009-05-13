/*
 * File			: EmbeddingParser.java
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
import org.codehaus.jparsec.Terminals;
import org.codehaus.jparsec.misc.Mapper;

import com.uva.se.wparse.model.embedding.Embedding;
import com.uva.se.wparse.model.embedding.MarkupEmbed;
import com.uva.se.wparse.model.embedding.MarkupEmbedding;
import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.markup.Markup;


public class EmbeddingParser {


	private Parser<Embedding> markupEmbedding(Parser<Markup> markup, Parser<Expression> expression, Parser<Embedding> embeddingParser) {
		return curry(MarkupEmbedding.class).sequence(
				ExpressionParser.EMBEDDED_TEXT.many(),
				TerminalParser.term("<"),
				markup.many(),
				Parsers.or(markup, expression),
				TerminalParser.term(">"),
				//Parsers.or(ExpressionParser.EMBEDDED_TEXT.many(), embeddingParser)
				ExpressionParser.EMBEDDED_TEXT.many()
				);
	}
	
	private Parser<Embedding> multipleEmbedding( Parser<Embedding> embeddingParser) {
		return curry(MarkupEmbedding.class).sequence(embeddingParser.many1());
	}
	
	private Parser<Embedding> expressionEmbedding(Parser<Markup> markup, Parser<Expression> expression) {
		return curry(MarkupEmbed.class).sequence(TerminalParser.term("<"),
				Terminals.Identifier.PARSER, markup.many(), expression, TerminalParser.term(">"));
	}
	
	public Parser<Embedding> getParser(Parser<Markup> markup, Parser<Expression> expression) {
		@SuppressWarnings("unchecked")
		Parser.Reference<Embedding> ref = Parser.newReference();
		Parser<Embedding> lazy = ref.lazy();
		Parser<Embedding> parser = Parsers.or(
				//markupEmbedding(markup),
				//multipleEmbedding(lazy),
				markupEmbedding(markup, expression, lazy)
				//expressionEmbedding(markup, expression)
				);
		ref.set(parser);
		return parser;
	}
	


	private Mapper<Embedding> curry(
			Class<? extends Embedding> clazz, Object... curryArgs) {
		return Mapper.curry(clazz, curryArgs);
	}
}
