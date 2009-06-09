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
package com.uva.se.wparse.test.output;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.uva.se.wparse.test.parser.ArgumentParserTest;
import com.uva.se.wparse.test.parser.AssignmentParserTest;
import com.uva.se.wparse.test.parser.AttributeParserTest;
import com.uva.se.wparse.test.parser.EmbeddingParserTest;
import com.uva.se.wparse.test.parser.ExpressionParserTest;
import com.uva.se.wparse.test.parser.MappingParserTest;
import com.uva.se.wparse.test.parser.MarkupParserTest;
import com.uva.se.wparse.test.parser.ModuleParserTest;
import com.uva.se.wparse.test.parser.PredicateParserTest;
import com.uva.se.wparse.test.parser.StatementParserTest;
/**
 * 
 * Test suite that runs all the separate unit test classes in this package
 *
 */
public class AllParserTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("All parser unit tests");
		suite.addTestSuite(StatementParserTest.class);
		suite.addTestSuite(EmbeddingParserTest.class);
		suite.addTestSuite(AttributeParserTest.class);
		suite.addTestSuite(MappingParserTest.class);
		suite.addTestSuite(ModuleParserTest.class);
		suite.addTestSuite(MarkupParserTest.class);
		suite.addTestSuite(ExpressionParserTest.class);
		suite.addTestSuite(ArgumentParserTest.class);
		suite.addTestSuite(AssignmentParserTest.class);
		suite.addTestSuite(PredicateParserTest.class);
		return suite;
	}

}
