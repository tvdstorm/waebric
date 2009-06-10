/*
 * File			: ArgumentParserTest.java
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
import com.uva.se.wparse.model.markup.Argument;
import com.uva.se.wparse.parser.ArgumentParser;
import com.uva.se.wparse.parser.ExpressionParser;
import com.uva.se.wparse.parser.TerminalParser;

/**
 * This is a test class and it checks if a given Waebric input the parser can
 * parse the Waebric code.
 * 
 * The functions aren't documented. There are two reasons for not documenting
 * this tests: - There are some time limits; - The tests are working always in
 * the same manner, so the default pattern is documented above.
 */
public class ArgumentParserTest extends TestCase {
	
	Parser<Expression> expParser = null;
	Parser<Argument> argumentParser = null;

	protected void setUp() throws Exception {
		super.setUp();
		expParser =  ExpressionParser.expression(null);
		argumentParser = ArgumentParser.arguments(expParser);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	

	public void testStringLiteralArgument(){
		String source = "var = \"this is a string\"";
		TerminalParser.parse(argumentParser, source);
	}
	
	public void testIdentifierArgument(){
		String source = "var = var2";
		TerminalParser.parse(argumentParser, source);
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
	
	public void testBlockArgumentStringLiteral(){
		String source = "(var=\"stringliteral\")";
		TerminalParser.parse(argumentParser, source);
	}
	
	public void testBlockStringLiteral(){
		String source = "(\"stringliteral\")";
		TerminalParser.parse(argumentParser, source);
	}
	



}
