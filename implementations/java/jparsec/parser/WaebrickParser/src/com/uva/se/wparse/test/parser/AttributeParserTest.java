/*
 * File			: AttributeParserTest.java
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
import com.uva.se.wparse.parser.ArgumentParser;
import com.uva.se.wparse.parser.AttributeParser;
import com.uva.se.wparse.parser.ExpressionParser;
import com.uva.se.wparse.parser.TerminalParser;

public class AttributeParserTest extends TestCase {
	

	Parser<Attribute> attributeParser = null;
	Parser<Expression> expParser = null;
	Parser<Argument> argumentParser = null;

	protected void setUp() throws Exception {
		super.setUp();
		attributeParser = AttributeParser.attributes();
		expParser =  ExpressionParser.expression(null);
		argumentParser = ArgumentParser.arguments(expParser);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	
	public void testPoundAttribute(){
		String source = "#ident2";
		TerminalParser.parse(attributeParser, source);
	}
	public void testMultipleAttribute(){
		String source = "@100%200";
		TerminalParser.parse(attributeParser, source);
	}
	
	public void testMultipleAttribute2(){
		String source = "@100";
		TerminalParser.parse(attributeParser, source);
	}
	
	
	public void testBlockArguments(){
		String source = "(var = var2, var3 = var4)";
		TerminalParser.parse(argumentParser, source);
	}
	
	public void testBlockArguments2(){
		String source = "(var, var2)";
		TerminalParser.parse(argumentParser, source);
	}
	
	public void testBlockArguments3(){
		String source = "(var, var2, var3 = var4)";
		TerminalParser.parse(argumentParser, source);
	}



}
