/*
 * File			: MarkupParserTest.java
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

import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.markup.Argument;
import com.uva.se.wparse.model.markup.Attribute;
import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.parser.ArgumentParser;
import com.uva.se.wparse.parser.AttributeParser;
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
	
	public void testMarkupDesignator2(){
		String source = "desigID@100%200#part2.part3";
		TerminalParser.parse(markupParser, source);
	}
	
	public void testMarkupDesignator3(){
		String source = "desigID#part2";
		TerminalParser.parse(markupParser, source);
	}
	
	
	public void testMarkupArguments(){
		String source = "desigID#test (var = var2)";
		TerminalParser.parse(markupParser, source);
	}
	
	
	public void test2DesignatorAndArgumentBlock(){
		String source = "td img(var = var2, var3 = var4)";
		TerminalParser.parse(markupParser, source);
	}
	
	public void testDesignatorAndArgumentBlock(){
		String source = "img(var = var2, var3 = var4)";
		TerminalParser.parse(markupParser, source);
	}
	
	
	public void testMarkupList(){
		String source = "img(var = var2, var3 = var4) img2(var = var5, var6 = var7)";
		TerminalParser.parse(markupParser, source);
	}


}
