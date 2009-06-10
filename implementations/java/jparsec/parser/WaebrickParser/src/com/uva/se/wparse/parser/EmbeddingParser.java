/*
 * File			: EmbeddingParser.java
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
import com.uva.se.wparse.model.embedding.MarkupEmbedding;
import com.uva.se.wparse.model.embedding.MarkupEmbeddingList;
import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.markup.Markup;

/**
 * Create a Parser of embedding code. 
 */
public class EmbeddingParser {

	/**
	 * Create a Embedding of the Member based on a Parser of Embedding, Markup and Expression. 
	 * @param markupParser A Parser of Markup (This is a class of our ParseTree model).  
	 * @param expressionParser A Parser of Expression (This is a class of our ParseTree model).  
	 * @param embeddingParser A Parser of Embedding (This is a class of our ParseTree model).  
	 * @return A Parser of Embedding (This is a class of our ParseTree model).  
	 */
	private static Parser<Embedding> markupEmbedding(Parser<Markup> markupParser, Parser<Expression> expressionParser,
		Parser<Embedding> embeddingParser) {
		return curry(MarkupEmbedding.class).sequence(
		ExpressionParser.EMBEDDED_TEXT.many(),
		TerminalParser.term(Operator.SMALLER_THEN.toString()),
		markupParser.many(),
		Parsers.or(markupParser, expressionParser).optional(),
		TerminalParser.term(Operator.LARGER_THEN.toString()),
		ExpressionParser.EMBEDDED_TEXT.many());
	}
	
	/**
	 * Create a Embedding of the Member based on a Parser of Embedding, Markup and Expression. 
	 * @param markupParser A Parser of Markup (This is a class of our ParseTree model).  
	 * @param expressionParser A Parser of Expression (This is a class of our ParseTree model).  
	 * @param embeddingParser A Parser of Embedding (This is a class of our ParseTree model).  
	 * @return A Parser of Embedding (This is a class of our ParseTree model).  
	 */
	private static  Parser<Embedding> multipleEmbedding( Parser<Markup> markupParser, Parser<Expression> expressionParser,
		Parser<Embedding> embeddingParser) {
		return curry(MarkupEmbeddingList.class).sequence(markupEmbedding(markupParser, expressionParser,
		embeddingParser).many());
	}
	
	/**
	 * Create a Embedding of the Member based on a Parser of Markup and Expression. 
	 * @param markupParser A Parser of Markup (This is a class of our ParseTree model).  
	 * @param expressionParser A Parser of Expression (This is a class of our ParseTree model).  
	 * @return A Parser of Embedding (This is a class of our ParseTree model).  
	 */
	public static  Parser<Embedding> getParser(Parser<Markup> markupParser, Parser<Expression> expressionParser) {
		Parser.Reference<Embedding> ref = Parser.newReference();
		Parser<Embedding> lazy = ref.lazy();
		Parser<Embedding> parser = multipleEmbedding(markupParser, expressionParser, lazy);
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
	private static  Mapper<Embedding> curry(Class<? extends Embedding> clazz, Object... curryArgs) {
		return Mapper.curry(clazz, curryArgs);
	}
}
