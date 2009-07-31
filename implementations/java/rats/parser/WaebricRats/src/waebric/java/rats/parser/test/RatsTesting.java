package waebric.java.rats.parser.test;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Assert;

import waebric.java.rats.parser.Waebric;
import xtc.parser.Result;

public class RatsTesting {
	private boolean logging = false;
	
	public void setLogging(boolean flag) {
		this.logging = flag;
	}
	
	public void testExp(String s) {
		Waebric parser = new Waebric(new StringReader(s), this.getClass().getName());
		try {
			Result result = parser.pTestExpression(0);
			if (logging) {
				System.err.println(s + ": " + result.semanticValue());
			}
			Assert.assertTrue(parser.isEOF(result.index));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	

}
