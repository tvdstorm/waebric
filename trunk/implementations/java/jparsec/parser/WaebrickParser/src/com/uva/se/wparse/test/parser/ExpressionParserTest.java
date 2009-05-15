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
	TerminalParser terminal = null;

	protected void setUp() throws Exception {
		terminal = new TerminalParser();
		expressionParser =  ExpressionParser.expression(null);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	
	public void testVarExpression(){
		String source = "var";
		terminal.parse(expressionParser, source);
	}
	
	public void testIdentifier(){
		String source = "varhead-vartail";
		terminal.parse(expressionParser, source);
	}
	
	public void testIdentifierMultipleDash(){
		String source = "varhead-vartail---vartail2";
		terminal.parse(expressionParser, source);
	}
	
	public void testIdentDotExpression(){
		String source = "var.var2";
		terminal.parse(expressionParser, source);
	}	
	
	public void testNaturalDotExpression(){
		String source = "12345.var2";
		terminal.parse(expressionParser, source);
	}
	
	
	public void testNotDotExpression(){
		String source = "myList.list?";
		try {
			terminal.parse(expressionParser, source);
		} catch (Exception e) {
			//failure of parsing the string was required to pass the test.
			assertNull(null);
			return;
		}
		
		assertNotNull(null);
	}
	
	public void testBlockExpression(){
		String source = "[var, var2, var3]";
		terminal.parse(expressionParser, source);
	}
	
	public void testIdentBlockExpression(){
		String source = "[var1, var2, var3].var4";
		terminal.parse(expressionParser, source);
	}
	
	public void testKeyValueBlockExpression(){
		String source = "{var1:var2, var2:var3, var4:var4}.var6";
		terminal.parse(expressionParser, source);
	}
	
	public void testKeyValueExpression(){
		String source = "{key:value, key2:value2}";
		terminal.parse(expressionParser, source);
	}
	
	public void testNaturalExpression(){
		String source = "123456";
		terminal.parse(expressionParser, source);
	}
	
	public void testStringExpression(){
		String source = "testString";
		terminal.parse(expressionParser, source);
	}
	
	public void testAdvancedString(){
		String source = "\"test ? with non a-zA-Z chars : & * % $ # @ !, . ( ) ^ 1 2 3 4 5 6 7 8 9 0 \"";
		terminal.parse(expressionParser, source);
	}
	
	public void testSymbolExpression(){
		String source = "'symbolName";
		terminal.parse(expressionParser, source);
	}
	
	
	//tests for illegal keyword usage
	
	public void testIllegalIf() {
		String source = "if";
		try {
			terminal.parse(expressionParser, source);
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
			terminal.parse(expressionParser, source);
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
			terminal.parse(expressionParser, source);
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
			terminal.parse(expressionParser, source);
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
			terminal.parse(expressionParser, source);
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
			terminal.parse(expressionParser, source);
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
			terminal.parse(expressionParser, source);
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
			terminal.parse(expressionParser, source);
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
			terminal.parse(expressionParser, source);
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
			terminal.parse(expressionParser, source);
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
			terminal.parse(expressionParser, source);
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
			terminal.parse(expressionParser, source);
		} catch (Exception e) {
			//failure of parsing the string was required to pass the test.
			assertNull(null);
			return;
		}
		assertNotNull(null);
	}



}
