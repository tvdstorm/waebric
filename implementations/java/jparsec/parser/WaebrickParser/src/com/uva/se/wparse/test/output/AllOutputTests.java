package com.uva.se.wparse.test.output;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllOutputTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("All output unit tests");
		suite.addTestSuite(ModuleOutputTest.class);
		suite.addTestSuite(RecursiveMenusOutputTest.class);
		return suite;
	}

}
