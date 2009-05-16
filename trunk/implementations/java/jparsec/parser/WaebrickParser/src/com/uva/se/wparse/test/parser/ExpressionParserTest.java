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
import com.uva.se.wparse.parser.ExpressionParser;
import com.uva.se.wparse.parser.TerminalParser;

public class ExpressionParserTest extends TestCase {
	

	Parser<Expression> expressionParser = null;

	protected void setUp() throws Exception {
		expressionParser =  ExpressionParser.expression(null);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	
	public void testVarExpression(){
		String source = "var";
		TerminalParser.parse(expressionParser, source);
	}
	
	public void testIdentifier(){
		String source = "varhead-vartail";
		TerminalParser.parse(expressionParser, source);
	}
	
	public void testIdentifierMultipleDash(){
		String source = "varhead-vartail---vartail2";
		TerminalParser.parse(expressionParser, source);
	}
	
	public void testIdentifierMultipleDashWithNumbers(){
		String source = "div.span-7.colborder";
		TerminalParser.parse(expressionParser, source);
	}
	
	public void testIdentDotExpression(){
		String source = "var.var2";
		TerminalParser.parse(expressionParser, source);
	}	
	
	public void testNaturalDotExpression(){
		String source = "12345.var2";
		TerminalParser.parse(expressionParser, source);
	}
	
	
	public void testNotDotExpression(){
		String source = "myList.list?";
		try {
			TerminalParser.parse(expressionParser, source);
		} catch (Exception e) {
			//failure of parsing the string was required to pass the test.
			assertNull(null);
			return;
		}
		
		assertNotNull(null);
	}
	
	public void testBlockExpression(){
		String source = "[var, var2, var3]";
		TerminalParser.parse(expressionParser, source);
	}
	
	public void testIdentBlockExpression(){
		String source = "[var1, var2, var3].var4";
		TerminalParser.parse(expressionParser, source);
	}
	
	public void testKeyValueBlockExpression(){
		String source = "{var1:var2, var2:var3, var4:var4}.var6";
		TerminalParser.parse(expressionParser, source);
	}
	
	public void testKeyValueExpression(){
		String source = "{key:value, key2:value2}";
		TerminalParser.parse(expressionParser, source);
	}
	
	public void testNaturalExpression(){
		String source = "123456";
		TerminalParser.parse(expressionParser, source);
	}
	
	public void testStringExpression(){
		String source = "testString";
		TerminalParser.parse(expressionParser, source);
	}
	
	public void testAdvancedString(){
		String source = "\"test ? with non a-zA-Z chars : & * % $ # @ !, . ( ) ^ 1 2 3 4 5 6 7 8 9 0 \"";
		TerminalParser.parse(expressionParser, source);
	}
	
	public void testSymbolExpression(){
		String source = "'symbolName";
		TerminalParser.parse(expressionParser, source);
	}
	
	
	//tests for illegal keyword usage
	
	public void testIllegalIf() {
		String source = "if";
		try {
			TerminalParser.parse(expressionParser, source);
		} catch (Exception e) {
			//failure of parsing the string was required to pass the test.
			assertNull(null);
			return;
		}
		assertNotNull(null);
	}
	
	public void testIllegalComment() {
		String source = "comment";
		try {
			TerminalParser.parse(expressionParser, source);
		} catch (Exception e) {
			//failure of parsing the string was required to pass the test.
			assertNull(null);
			return;
		}
		assertNotNull(null);
	}
	
	public void testIllegalEcho() {
		String source = "echo";
		try {
			TerminalParser.parse(expressionParser, source);
		} catch (Exception e) {
			//failure of parsing the string was required to pass the test.
			assertNull(null);
			return;
		}
		assertNotNull(null);
	}
	
	public void testIllegalCdata() {
		String source = "cdata";
		try {
			TerminalParser.parse(expressionParser, source);
		} catch (Exception e) {
			//failure of parsing the string was required to pass the test.
			assertNull(null);
			return;
		}
		assertNotNull(null);
	}
	
	
	public void testIllegalEach() {
		String source = "each";
		try {
			TerminalParser.parse(expressionParser, source);
		} catch (Exception e) {
			//failure of parsing the string was required to pass the test.
			assertNull(null);
			return;
		}
		assertNotNull(null);
	}
	
	public void testIllegalLet() {
		String source = "let";
		try {
			TerminalParser.parse(expressionParser, source);
		} catch (Exception e) {
			//failure of parsing the string was required to pass the test.
			assertNull(null);
			return;
		}
		assertNotNull(null);
	}

	
	public void testIllegalYield() {
		String source = "yield";
		try {
			TerminalParser.parse(expressionParser, source);
		} catch (Exception e) {
			//failure of parsing the string was required to pass the test.
			assertNull(null);
			return;
		}
		assertNotNull(null);
	}
	
	public void testIllegalModule() {
		String source = "module";
		try {
			TerminalParser.parse(expressionParser, source);
		} catch (Exception e) {
			//failure of parsing the string was required to pass the test.
			assertNull(null);
			return;
		}
		assertNotNull(null);
	}
	
	public void testIllegalImport() {
		String source = "import";
		try {
			TerminalParser.parse(expressionParser, source);
		} catch (Exception e) {
			//failure of parsing the string was required to pass the test.
			assertNull(null);
			return;
		}
		assertNotNull(null);
	}
	
	public void testIllegalDef() {
		String source = "def";
		try {
			TerminalParser.parse(expressionParser, source);
		} catch (Exception e) {
			//failure of parsing the string was required to pass the test.
			assertNull(null);
			return;
		}
		assertNotNull(null);
	}
	
	public void testIllegalEnd() {
		String source = "end";
		try {
			TerminalParser.parse(expressionParser, source);
		} catch (Exception e) {
			//failure of parsing the string was required to pass the test.
			assertNull(null);
			return;
		}
		assertNotNull(null);
	}
	
	
	public void testIllegalSite() {
		String source = "site";
		try {
			TerminalParser.parse(expressionParser, source);
		} catch (Exception e) {
			//failure of parsing the string was required to pass the test.
			assertNull(null);
			return;
		}
		assertNotNull(null);
	}



}
