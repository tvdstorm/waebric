package waebric.java.rats.parser.test;

import org.junit.Before;
import org.junit.Test;

public class TestExpressions extends RatsTesting {

	@Before
	public void setUp() {
		setLogging(true);
	}

	@Test
	public void number() {
		testExp("1234");
	}
	
	@Test
	public void numberZero() {
		testExp("0");
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

	@Test 
	public void recordEmpty() {
		testExp("{ }");
	}

	@Test 
	public void recordEmptyNoWs() {
		testExp("{}");
	}

	@Test 
	public void recordSingle() {
		testExp("{a: 3}");
	}
	
	@Test 
	public void recordMany() {
		testExp("{a: 123, b: 345}");
	}
	
	@Test 
	public void listEmpty() {
		testExp("[ ]");
	}
	
	@Test 
	public void listEmptyNoWs() {
		testExp("[]");
	}

	@Test 
	public void listSingle() {
		testExp("[a]");
	}
	
	
	@Test 
	public void listMany() {
		testExp("[a, b, c, 123]");
	}

	@Test 
	public void listNestingDirectEmpty() {
		testExp("[[]]");
	}

	@Test 
	public void listNesting() {
		testExp("[a, [b, c], a]");
	}

	@Test 
	public void listNestingInject() {
		testExp("[a, [b, c], [[[123]]]]");
	}

	@Test 
	public void recordNesting() {
		testExp("{a: {b: 123, c: {k: 345}}}");
	}
	
	@Test 
	public void variable() {
		testExp("a");
	}
	
	
	
}
