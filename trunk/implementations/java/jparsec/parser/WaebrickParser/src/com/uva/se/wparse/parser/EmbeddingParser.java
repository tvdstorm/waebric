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
import org.codehaus.jparsec.misc.Mapper;

import com.uva.se.wparse.model.embedding.Embedding;
import com.uva.se.wparse.model.embedding.MarkupEmbedding;
import com.uva.se.wparse.model.embedding.MarkupEmbeddingList;
import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.markup.Markup;


public class EmbeddingParser {


	private static Parser<Embedding> markupEmbedding(Parser<Markup> markup, Parser<Expression> expression, Parser<Embedding> embeddingParser) {
		return curry(MarkupEmbedding.class).sequence(
				ExpressionParser.EMBEDDED_TEXT.many(),
				TerminalParser.term("<"),
				markup.many(),
				Parsers.or(markup, expression),
				TerminalParser.term(">"),
				ExpressionParser.EMBEDDED_TEXT.many()
				);
	}
	
	private static  Parser<Embedding> multipleEmbedding( Parser<Markup> markup, Parser<Expression> expression, Parser<Embedding> embeddingParser) {
		return curry(MarkupEmbeddingList.class).sequence(markupEmbedding(markup, expression, embeddingParser).many());
	}
	
	public static  Parser<Embedding> getParser(Parser<Markup> markup, Parser<Expression> expression) {
		Parser.Reference<Embedding> ref = Parser.newReference();
		Parser<Embedding> lazy = ref.lazy();
		Parser<Embedding> parser = multipleEmbedding(markup, expression, lazy);
		ref.set(parser);
		return parser;
	}
	


	private static  Mapper<Embedding> curry(
			Class<? extends Embedding> clazz, Object... curryArgs) {
		return Mapper.curry(clazz, curryArgs);
	}
}
