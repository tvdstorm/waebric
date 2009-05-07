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


//	static Parser<Embedding> markupEmbedding(Parser<Markup> markup) {
//		return curry(MarkupEmbed.class).sequence(TerminalParser.term("<"),
//				Terminals.Identifier.PARSER, markup.many(), markup, TerminalParser.term(">"));
//	}
	
	public EmbeddingParser() {

	}

	private Parser<Embedding> markupEmbedding(Parser<Markup> markup, Parser<Expression> expression) {
		return curry(MarkupEmbedding.class).sequence(
				//Terminals.Identifier.PARSER.many(),
				ExpressionParser.TEXT2.many(),
				TerminalParser.term("<"),
				markup.many(),
				Parsers.or(markup, expression),
				TerminalParser.term(">"),
				//Terminals.Identifier.PARSER.many()
				ExpressionParser.TEXT2.many()
				);
	}
	
	private Parser<Embedding> expressionEmbedding(Parser<Markup> markup, Parser<Expression> expression) {
		return curry(MarkupEmbed.class).sequence(TerminalParser.term("<"),
				Terminals.Identifier.PARSER, markup.many(), expression, TerminalParser.term(">"));
	}
//	
//	private Parser<Embedding> markupExpression(Parser<Markup> markup, Parser<Expression> expression) {
//		  return curry( MarkupEmbed.class).sequence(TerminalParser.term("<"),
//				   Terminals.Identifier.PARSER, markup.many(), Parsers.or(markup, expression ),
//				   TerminalParser.term(">"));
//	  }
	  

	
	public Parser<Embedding> getParser(Parser<Markup> markup, Parser<Expression> expression) {
		@SuppressWarnings("unchecked")
		Parser<Embedding> parser = Parsers.or(
				//markupEmbedding(markup),
				markupEmbedding(markup, expression)
				//expressionEmbedding(markup, expression)
				);
		return parser;
	}
	


	private Mapper<Embedding> curry(
			Class<? extends Embedding> clazz, Object... curryArgs) {
		return Mapper.curry(clazz, curryArgs);
	}
}
