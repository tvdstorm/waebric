/*
 * File			: ArgumentParserTest.java
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
import com.uva.se.wparse.model.predicate.Predicate;
import com.uva.se.wparse.parser.ExpressionParser;
import com.uva.se.wparse.parser.PredicateParser;
import com.uva.se.wparse.parser.TerminalParser;

public class PredicateParserTest extends TestCase {
	


	Parser<Expression> expressionParser = null;
	Parser<Predicate> predicateParser = null;

	protected void setUp() throws Exception {
		super.setUp();
		expressionParser = ExpressionParser.expression(null);
		predicateParser = PredicateParser.predicates(expressionParser);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	

	
	public void testListTypeCheck(){
		String source = "myList.list?";
		TerminalParser.parse(predicateParser, source);
	}
	
	public void testRecordTypeCheck(){
		String source = "myRecord.record?";
		TerminalParser.parse(predicateParser, source);
	}
	
	public void testStringTypeCheck(){
		String source = "myString.string?";
		TerminalParser.parse(predicateParser, source);
	}
	
	public void testUnknownypeCheck(){
		String source = "myString.badtype?";
		try {
			TerminalParser.parse(predicateParser, source);
		} catch (Exception e) {
			//failure of parsing the string was required to pass the test.
			assertNull(null);
			return;
		}
		
		assertNotNull(null);
	}
	
	public void testNotPredicate(){
		String source = "!myString.string?";
		TerminalParser.parse(predicateParser, source);
	}
	
	public void testPredicateAndOperatorExpression(){
		String source = "myString.string? && myList.list?";
		TerminalParser.parse(predicateParser, source);
	}
	
	public void testPredicateAndOperatorMultipleExpression(){
		String source = "myString.string? && myList.list? && mylist2.list?";
		TerminalParser.parse(predicateParser, source);
	}
	
	public void testNotLeftPredicateAndOperatorExpression(){
		String source = "!myString.string? && myList.list?";
		TerminalParser.parse(predicateParser, source);
	}
	
	public void testNotRightPredicateAndOperatorExpression(){
		String source = "myString.string? && !myList.list?";
		TerminalParser.parse(predicateParser, source);
	}
	
	public void testNotPredicateAndOperatorExpression(){
		String source = "!myString.string? && !myList.list?";
		TerminalParser.parse(predicateParser, source);
	}
	
	public void testPredicateOrOperatorExpression(){
		String source = "myString.string? || myList.list?";
		TerminalParser.parse(predicateParser, source);
	}
	
	public void testNotLeftPredicateOrOperatorExpression(){
		String source = "!myString.string? || myList.list?";
		TerminalParser.parse(predicateParser, source);
	}
	
	public void testNotRightPredicateOrOperatorExpression(){
		String source = "myString.string? || !myList.list?";
		TerminalParser.parse(predicateParser, source);
	}
	
	public void testNotPredicateOrOperatorExpression(){
		String source = "!myString.string? || !myList.list?";
		TerminalParser.parse(predicateParser, source);
	}
	



}
