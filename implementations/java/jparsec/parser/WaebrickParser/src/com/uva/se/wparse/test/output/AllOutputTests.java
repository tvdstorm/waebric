package com.uva.se.wparse.test.output;

import com.uva.se.wparse.test.parser.StatementParserTest;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllOutputTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("All output unit tests");
		suite.addTestSuite(ModuleOutputTest.class);
		return suite;
	}

}
