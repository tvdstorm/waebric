/*
 * File			: EmbeddingParserTest.java
 * Project		: WaebrickParser
 * 				: Practicum opdracht Software Construction
 * 
 * Authors		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * 
 * Description	:
 * 
 */
package com.uva.se.wparse.test.parser;

import junit.framework.TestCase;

import org.codehaus.jparsec.Parser;

import com.uva.se.wparse.model.embedding.Embedding;
import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.markup.Argument;
import com.uva.se.wparse.model.markup.Attribute;
import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.parser.ArgumentParser;
import com.uva.se.wparse.parser.AttributeParser;
import com.uva.se.wparse.parser.EmbeddingParser;
import com.uva.se.wparse.parser.ExpressionParser;
import com.uva.se.wparse.parser.MarkupParser;
import com.uva.se.wparse.parser.TerminalParser;

public class EmbeddingParserTest extends TestCase {
	
	Parser<Markup> markupParser = null;
	Parser<Expression> expParser = null;
	Parser<Embedding> embeddingParser = null;

	protected void setUp() throws Exception {
		expParser =  ExpressionParser.expression(null);
		markupParser = MarkupParser.markup(expParser);
		embeddingParser = EmbeddingParser.embedding(markupParser, expParser);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	
	public void testMarkupIdent(){
		String source = "<em blaat >";
		TerminalParser.parse(embeddingParser, source);
	}
	
	public void testMarkupWithIdent(){
		String source = "<em desigID#part2.part3 blaat.de blaat>";
		TerminalParser.parse(embeddingParser, source);
	}
	
	public void testMarkupWithString(){
		String source = "<em desigID#part2.part3 \"Martin Pieters\">";
		TerminalParser.parse(embeddingParser, source);
	}
	
	public void testMarkupWithExpression(){
		String source = "<em desigID#part2.part3 blaat.de >";
		TerminalParser.parse(embeddingParser, source);
	}
	
	public void testWithSymbol(){
		String source = "<em 'SYMBOL >";
		TerminalParser.parse(embeddingParser, source);
	}
	
	public void testNOTSymbol(){
		String source = "<em ident.test NOTSYMBOL >";
		TerminalParser.parse(embeddingParser, source);
	}
	
	public void testWithString(){
		String source = "<em \"stringie\" >";
		TerminalParser.parse(embeddingParser, source);
	}
	
	public void testMarkupWithSymbol(){
		String source = "<em markup1#markup2.markup3 'SYMBOL >";
		TerminalParser.parse(embeddingParser, source);
	}


}
