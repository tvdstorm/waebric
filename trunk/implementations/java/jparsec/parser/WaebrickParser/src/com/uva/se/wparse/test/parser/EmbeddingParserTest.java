/*
 * File			: EmbeddingParserTest.java
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
package com.uva.se.wparse.test.parser;

import junit.framework.TestCase;

import org.codehaus.jparsec.Parser;

import com.uva.se.wparse.model.embedding.Embedding;
import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.markup.Markup;
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
		EmbeddingParser embedding = new EmbeddingParser();
		embeddingParser = embedding.getParser(markupParser, expParser);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	public void testMarkupWithString(){
		String source = "<em desigID#part2.part3 \"Martin Pieters\">";
		TerminalParser.parse(embeddingParser, source);
	}

	public void testWithSymbol(){
		String source = "<em 'SYMBOL >";
		TerminalParser.parse(embeddingParser, source);
	}
	
	
	public void testWithString(){
		String source = "<em \"stringie\" >";
		TerminalParser.parse(embeddingParser, source);
	}
	
	public void testWithQuotedString(){
		String source = "<em \"'De Nomadensnaar'\">";
		TerminalParser.parse(embeddingParser, source);
	}
	
	
	 
	
	public void testMarkupWithSymbol(){
		String source = "<em markup1#markup2.markup3 'SYMBOL >";
		TerminalParser.parse(embeddingParser, source);
	}

	public void testEmbeddedWithBlockArgument(){
		String source = "<a (href=\"mailto:test@test.nl\") \"test@test.nl\">";
		TerminalParser.parse(embeddingParser, source);
	}
	
	public void testEmbeddedMarkup(){
		String source = "pre text <a (href=\"mailto:test@test.nl\") \"test@test.nl\"> post text";
		TerminalParser.parse(embeddingParser, source);
	}

}
