/*
 * File			: ExpressionParserTest.java
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

import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.markup.Argument;
import com.uva.se.wparse.model.markup.Attribute;
import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.parser.ArgumentParser;
import com.uva.se.wparse.parser.AttributeParser;
import com.uva.se.wparse.parser.ExpressionParser;
import com.uva.se.wparse.parser.MarkupParser;
import com.uva.se.wparse.parser.TerminalParser;

public class ExpressionParserTest extends TestCase {
	

	Parser<Expression> expParser = null;

	protected void setUp() throws Exception {
		expParser =  ExpressionParser.expression(null);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	
	public void testVarExpression(){
		String source = "var";
		TerminalParser.parse(expParser, source);
	}
	
	public void testIdentExpression(){
		String source = "var.var2";
		TerminalParser.parse(expParser, source);
	}	
	
	public void testBlockExpression(){
		String source = "[var, var2, var3]";
		TerminalParser.parse(expParser, source);
	}
	
	public void testIdentBlockExpression(){
		String source = "[var1, var2, var3].var4";
		TerminalParser.parse(expParser, source);
	}
	
	public void testKeyValueBlockExpression(){
		String source = "{var1:var2, var2:var3, var4:var4}.var6";
		TerminalParser.parse(expParser, source);
	}
	
	public void testKeyValueExpression(){
		String source = "{key:value, key2:value2}";
		TerminalParser.parse(expParser, source);
	}
	
	public void testNaturalExpression(){
		String source = "123456";
		TerminalParser.parse(expParser, source);
	}
	
	public void testStringExpression(){
		String source = "testString";
		TerminalParser.parse(expParser, source);
	}
	
	public void testAdvancedString(){
		String source = "\"test ? with non a-zA-Z chars : & * % $ # @ !, . ( ) ^ 1 2 3 4 5 6 7 8 9 0 \"";
		TerminalParser.parse(expParser, source);
	}
	
	public void testSymbolExpression(){
		String source = "'symbolName";
		TerminalParser.parse(expParser, source);
	}
	



}
