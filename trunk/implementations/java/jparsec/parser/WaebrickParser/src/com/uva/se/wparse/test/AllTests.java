package com.uva.se.wparse.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.uva.se.wparse.test.input.InputTest;
import com.uva.se.wparse.test.output.AllOutputTests;
import com.uva.se.wparse.test.output.AllParserTests;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("All unit tests");
		suite.addTest(AllParserTests.suite());
		suite.addTest(AllOutputTests.suite());
		suite.addTestSuite(InputTest.class);
		
		return suite;
	}

}
