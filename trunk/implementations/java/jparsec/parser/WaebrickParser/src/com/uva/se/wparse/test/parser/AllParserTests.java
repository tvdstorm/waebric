/*
 * File			: AllParserTests.java
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

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllParserTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for com.uva.se.wparse.test.parser");
		//$JUnit-BEGIN$
		suite.addTestSuite(StatementParserTest.class);
		suite.addTestSuite(EmbeddingParserTest.class);
		suite.addTestSuite(AttributeParserTest.class);
		suite.addTestSuite(MappingParserTest.class);
		suite.addTestSuite(DeclarationParserTest.class);
		suite.addTestSuite(MarkupParserTest.class);
		suite.addTestSuite(ExpressionParserTest.class);
		//$JUnit-END$
		return suite;
	}

}
