package waebric.java.rats.parser.test;

import org.junit.Before;
import org.junit.Test;

public class TestExpressions extends RatsTesting {

	@Test
	public void numbers() {
		testExp("1234");
		testExp("0");
	}


	@Test
	public void symbols() {
		testExp("'1234");
		testExp("'1234abcd-ef/dskjdks ");
		testExp("'askdjhasjd98398723498");
		testExp("'askdjhaskdhuwb&^%^&*#&@*#&@*");
		testExp("'http://www.example.com");
	}

	@Test
	public void identifiers() {
		testExp("a");
		testExp("a-b");
		testExp("abc");
		testExp("ab");
		testExp("aabc-d-efff");
	}

	
	
	@Test
	public void addition() {
		testExp("x + x");
		testExp("x + x + x");
		testExp("x + x.a");
	}
	
	@Test
	public void strings() {
		testExp("\"\"");
		testExp("\"a\"");
		testExp("\"abcd efg\"");
		testExp("\"\\n\\r\\t\\\\\"");
		testExp("\"\n\t\"");
		testExp("\"\\\"\"");
		testExp("\"\\\"abc\"");
	}

	@Test 
	public void records() {
		testExp("{ }");
		testExp("{}");
		testExp("{a: 3}");
		testExp("{a: 123, b: 345}");
		testExp("{a: {b: 123, c: {k: 345}}}");
	}
	
	@Test 
	public void lists() {
		testExp("[ ]");
		testExp("[]");
		testExp("[a]");
		testExp("[a, b, c, 123]");
		testExp("[[]]");
		testExp("[a, [b, c], a]");
		testExp("[a, [b, c], [[[123]]]]");
	}

	
	
}
