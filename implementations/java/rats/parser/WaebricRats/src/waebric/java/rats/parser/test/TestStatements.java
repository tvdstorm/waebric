package waebric.java.rats.parser.test;

import org.junit.Before;
import org.junit.Test;

public class TestStatements extends RatsTesting {

	@Before
	public void setup() {
		setLogging(true);
	}
	
	@Test
	public void echo() {
		testStat("echo a;");
		testStat("echo \"\";");
		testStat("echo \"abc\";");
		testStat("echo 3;");
		testStat("echo a + b;");
		testStat("echo a + b.c;");
		testStat("echo a.c;");
	}
	
	@Test
	public void echoList() {
		testStat("echo [1,3,4];");
		testStat("echo [];");
	}
	
	@Test
	public void echoRecord() {
		testStat("echo { };");
		testStat("echo {};");
		testStat("echo {a: 3, b: 4};");		
	}
	
	@Test
	public void yield() {
		testStat("yield;");
	}

	@Test
	public void ifThenElse() {
		testStat("if (a) echo a;");
		testStat("if (a) { echo a; }");
		testStat("if (a) { echo a; echo b; }");
		testStat("if (a) echo a; else echo b;");
		testStat("if (a) { echo a; } else echo b;");
		testStat("if (a) { echo a; } else { echo b; }");
		testStat("if (a) { echo a; } else { echo b; echo c; }");
		testStat("if (a) echo z; else { echo a; echo b; } ");

		
		// Nesting!
		testStat("if (z) if (a) echo a;");
		testStat("if (z) if (a) { echo a; }");
		testStat("if (z) if (a) { echo a; echo b; }");
		testStat("if (z) if (a) echo a; else echo b;");
		testStat("if (z) if (a) { echo a; } else echo b;");
		testStat("if (z) if (a) { echo a; } else { echo b; }");
		testStat("if (z) if (a) { echo a; } else { echo b; echo c; }");
		testStat("if (z) if (a) echo z; else { echo a; echo b; } ");
		
		testStat("if (a) if (a) b;");
		testStat("if (a) { if (a) b; }");
		testStat("if (a) { if (a) b; echo b; }");
		testStat("if (a) if (a) b; else echo b;");
		testStat("if (a) { if (a) b; } else echo b;");
		testStat("if (a) { if (a) b; } else { echo b; }");
		testStat("if (a) { if (a) b; } else { echo b; echo c; }");
		testStat("if (a) echo z; else { if (a) b; echo b; } ");
		
		// Dangling else
		testStat("if (a) if (b) c; else d;");
	}

	@Test
	public void each() {
		testStat("each(x: y) echo x;");
		testStat("each(x: y) { echo x; echo x; }");
		testStat("each(x: [ ]) echo x;");
		testStat("each(x: [1, 2, 3]) { echo x; echo x; }");
	}

	@Test
	public void blocks() {
		testStat("{/*abc*/}");
		testStat("{}");
		testStat("{ }");
		testStat("{\n}");
		testStat("{//\n}");
		testStat("{ \n }");
		testStat("{ echo a; }");
		testStat("{ a; }");
		testStat("{ echo a; a; }");
		testStat("{ a; a; a; }");
		testStat("{ echo a;{ a;} }");
		testStat("{ a; { a; a; } }");
	}
	
	@Test
	public void markup() {
		testStat("a;");
		testStat("a b;");
		testStat("a b c;");
		testStat("a b();");
		testStat("a b c();");
		testStat("a.b;");
		testStat("a#c;");
		testStat("a$b;");
		testStat("a@34;");
		testStat("a@100%200;");
		testStat("a.a.b;");
		testStat("a.a#c;");
		testStat("a.a$b;");
		testStat("a.a@34;");
		testStat("a.a@100%200;");
		testStat("c#a.a.b;");
		testStat("c#a.a#c;");
		testStat("c#a.a$b;");
		testStat("c#a.a@34;");
		testStat("c#a.a@100%200;");

		testStat("a#c z;");
		testStat("a$b z;");
		testStat("a@34 z;");
		testStat("a@100%200 z;");
		testStat("a.a.b z;");
		testStat("a.a#c z;");
		testStat("a.a$b z;");
		testStat("a.a@34 z;");
		testStat("a.a@100%200 z;");
		testStat("c#a.a.b z;");
		testStat("c#a.a#c z;");
		testStat("c#a.a$b z;");
		testStat("c#a.a@34 z;");
		testStat("c#a.a@100%200 z;");
		
		testStat("a#c a#c;");
		testStat("a$b a$b;");
		testStat("a@34 a@34;");
		testStat("a@100%200 a@100%200;");
		testStat("a.a.b a.a.b;");
		testStat("a.a#c a.a#c;");
		testStat("a.a$b a.a$b;");
		testStat("a.a@34 a.a@34;");
		testStat("a.a@100%200 a.a@100%200;");
		testStat("c#a.a.b c#a.a.b;");
		testStat("c#a.a#c c#a.a#c;");
		testStat("c#a.a$b c#a.a$b;");
		testStat("c#a.a@34 c#a.a@34;");
		testStat("c#a.a@100%200 c#a.a@100%200;");
		
		
		testStat("a echo x;");
		testStat("a echo x;");
		testStat("a b echo x;");
		testStat("a b() echo x;");
		testStat("a b c() echo x;");

		
		testStat("a if (x) echo y; else  echo z;");
		testStat("a if (x) echo y; else  echo z;");
		testStat("a b if (x) echo y; else  echo z;");
		testStat("a b() if (x) echo y; else  echo z;");
		testStat("a b c() if (x) echo y; else  echo z;");

		
		
//		
//		testStat("");
//		testStat("");
//		testStat("");
//		testStat("");
//		testStat("");
//		testStat("");
//		testStat("");
//		testStat("");
//		testStat("");
//		testStat("");
//
//		testStat("a.b$b");
		
	}
	
	
}
