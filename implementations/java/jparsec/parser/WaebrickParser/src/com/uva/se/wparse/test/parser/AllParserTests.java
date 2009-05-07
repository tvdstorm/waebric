/*
 * File			: AllParserTests.java
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
		suite.addTestSuite(ArgumentParserTest.class);
		
		//$JUnit-END$
		return suite;
	}

}
