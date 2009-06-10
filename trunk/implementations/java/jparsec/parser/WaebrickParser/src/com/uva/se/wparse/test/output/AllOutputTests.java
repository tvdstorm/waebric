/*
 * File			: AllOutputTests.java
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
package com.uva.se.wparse.test.output;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * This test class calls output tests. 
 * 
 * The functions aren't documented. There are two reasons for not documenting 
 * this tests: 
 * - There are some time limits;
 * - The tests are working always in the same manner, so the default pattern is 
 *   documented above.  
 */
public class AllOutputTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("All output unit tests");
		suite.addTestSuite(ModuleOutputTest.class);
		suite.addTestSuite(RecursiveMenusOutputTest.class);
		suite.addTestSuite(AllStatementOutputTest.class);
		suite.addTestSuite(AllAttributeOutputTest.class);
		suite.addTestSuite(AllEmbeddingOutputTest.class);
		suite.addTestSuite(AllMarkupOutputTest.class);
		suite.addTestSuite(AllPredicateOutputTest.class);
		return suite;
	}

}
