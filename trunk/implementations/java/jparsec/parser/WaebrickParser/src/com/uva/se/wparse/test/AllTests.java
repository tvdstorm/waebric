/*
 * File			: AllTests.java
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
package com.uva.se.wparse.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.uva.se.wparse.test.input.InputTest;
import com.uva.se.wparse.test.output.AllOutputTests;
import com.uva.se.wparse.test.output.AllParserTests;

/**
 * This is a test class and it calls all test which are 
 * made in this project. 
 * 
 * The functions aren't documented. There are two reasons for not documenting 
 * this tests: 
 * - There are some time limits;
 * - The tests are working always in the same manner, so the default pattern is 
 *   documented above.  
 */
public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("All unit tests");
		suite.addTest(AllParserTests.suite());
		suite.addTest(AllOutputTests.suite());
		suite.addTestSuite(InputTest.class);
		
		return suite;
	}

}
