package waebric.java.rats.parser.test;

import org.junit.Before;
import org.junit.Test;

public class TestExpressions extends RatsTesting {

	@Before
	public void setUp() {
		setLogging(true);
	}

	@Test
	public void addition() {
		testExp("x + x");
	}

	@Test
	public void additionLeft() {
		testExp("x + x + x");
	}

	@Test
	public void additionWithDot() {
		testExp("x + x.a");
	}
	
	@Test
	public void stringLiteralEmpty() {
		testExp("\"\"");
	}

	@Test
	public void stringLiteralSingle() {
		testExp("\"a\"");
	}
	
	@Test
	public void stringLiteralMany() {
		testExp("\"abcd efg\"");
	}
	
	@Test 
	public void stringLiteralEscapes() {
		testExp("\"\\n\\r\\t\\\\\"");
	}

	@Test 
	public void stringLiteralNewline() {
		testExp("\"\n\t\"");
	}

	@Test 
	public void stringLiteralDQuoteSingle() {
		testExp("\"\\\"\"");
	}

	@Test 
	public void stringLiteralDQuote() {
		testExp("\"\\\"abc\"");
	}

}
