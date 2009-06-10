/*
 * File			: MarkupParserTest.java
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
package com.uva.se.wparse.test.parser;

import junit.framework.TestCase;

import org.codehaus.jparsec.Parser;

import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.parser.ExpressionParser;
import com.uva.se.wparse.parser.MarkupParser;
import com.uva.se.wparse.parser.TerminalParser;

public class MarkupParserTest extends TestCase {
	

	Parser<Markup> markupParser = null;
	Parser<Expression> expParser = null;


	protected void setUp() throws Exception {
		super.setUp();
		expParser =  ExpressionParser.expression(null);
		markupParser = MarkupParser.markup(expParser);

	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	public void testMarkupDesignator(){
		String source = "desigID@100%200";
		TerminalParser.parse(markupParser, source);
	}
	
	public void testMarkupComplexDesignator(){
		String source = "desigID@100%200#part2.part3";
		TerminalParser.parse(markupParser, source);
	}
	
	public void testMarkupDesignatorPound(){
		String source = "desigID#part2";
		TerminalParser.parse(markupParser, source);
	}
	
	public void testMarkupName(){
		String source = "markup-with-dash";
		TerminalParser.parse(markupParser, source);
	}
	
	/**
	 * This test must fail to succeed.
	 */
	public void testMarkupDesignatorDotMustFail(){
		String source = "desigID.part2 \"test test2\"";
		try {
			TerminalParser.parse(markupParser, source);
		} catch (Exception e) {
			//exception is expected for this method, if no exception
			//occurs then the unit test must fail.
			return;
		}
		//no error occurred, return fail status for test
		assertNotNull(null);
	}
	

	public void testMarkupDesignatorDot(){
		String source = "desigID.part2 ";
		TerminalParser.parse(markupParser, source);
	}
	
	
	public void testMarkupArguments(){
		String source = "desigID#test (var = var2)";
		TerminalParser.parse(markupParser, source);
	}
	
	public void testDesignatorAndArgumentBlock(){
		String source = "img(var = var2, var3 = var4)";
		TerminalParser.parse(markupParser, source);
	}
	
	public void testEmbeddedMarkup(){
		String source = "test (href=\"mailto:test@test.nl\")";
		TerminalParser.parse(markupParser, source);
	}
	
	public void testMarkupMethodCall(){
		String source = "header(\"Abonnee worden?\")";
		TerminalParser.parse(markupParser, source);
	}
	
	public void testMarkupMethodCall2(){
		String source = "header(\"Literaire Prijs de Brandende Pen 2007\")";
		TerminalParser.parse(markupParser, source);
	}
	
	
	public void testMarkDiffArgumentTypes(){
		String source = "table(border='0#4, width='800, summary=\"Brandende Pen 2006 in de pers\")";
		TerminalParser.parse(markupParser, source);
	}
	
	public void testMarkupWithSymbolArgument(){
		String source = "markup('symbol)";
		TerminalParser.parse(markupParser, source);
	}
	
	public void testMarkupWithAdvancedSymbolArgument(){
		String source = "markup('images/brpen06_christiaanweijts.jpg)";
		TerminalParser.parse(markupParser, source);
	}
	



	
	
	
	
	
	
	
	 
	
	


}
