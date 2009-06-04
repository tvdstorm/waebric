package com.uva.se.wparse.test.output;

import junit.framework.Test;
import junit.framework.TestSuite;

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
