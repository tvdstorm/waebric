/*
 * File			: EmbeddingParser.java
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

import com.uva.se.wparse.model.embedding.Embedding;
import com.uva.se.wparse.model.embedding.MarkupEmbed;
import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.model.statement.MarkupEmbeddingStatement;
import com.uva.se.wparse.model.statement.MarkupExpressionStatement;
import com.uva.se.wparse.model.statement.Statement;


public class EmbeddingParser {


	static Parser<Embedding> markupEmbedding(Parser<Markup> markup) {
		return curry(MarkupEmbed.class).sequence(TerminalParser.term("<"),
				Terminals.Identifier.PARSER, markup.many(), markup, TerminalParser.term(">"));
	}
	
	static Parser<Embedding> expressionEmbedding(Parser<Markup> markup, Parser<Expression> expression) {
		return curry(MarkupEmbed.class).sequence(TerminalParser.term("<"),
				Terminals.Identifier.PARSER, markup.many(), expression, TerminalParser.term(">"));
	}
	
	  static Parser<Embedding> markupExpression(Parser<Markup> markup, Parser<Expression> expression) {
		 // Parser<Markup> markupParser2 = MarkupParser.markup(expression);
		  return curry( MarkupEmbed.class).sequence(TerminalParser.term("<"),
				   Terminals.Identifier.PARSER, markup.many(), Parsers.or(markup, expression ),
				   TerminalParser.term(">"));
	  }
	  

	
	public static Parser<Embedding> embedding(Parser<Markup> markup, Parser<Expression> expression) {
		@SuppressWarnings("unchecked")
		Parser<Embedding> parser = Parsers.or(
				markupEmbedding(markup),
				expressionEmbedding(markup, expression)
				);
		return parser;
	}
	
	private static Mapper<Embedding> curry(
			Class<? extends Embedding> clazz, Object... curryArgs) {
		return Mapper.curry(clazz, curryArgs);
	}
}
