package waebric.java.rats.parser.test;

import org.junit.Test;

public class TestModules extends RatsTesting {

	@Test
	public void sites() {
		testSite("site end");
		testSite("site x.txt: f() end");
		testSite("site index.html: home() end");
		testSite("site /dev/null.x: home() end");
		testSite("site ./home/index.html: home() end");
		testSite("site a/b/c.c: home(); a.yy: main() end");
		testSite("site a/b/c.c: home(); index.html: main() end");
		testSite("site a/b/c.c: home(); /dev/null.xml: main() end");
	}
	
	@Test
	public void functions() {
		testFunction("def main  layout(\"Recursive Menus\") { the-menu(); } end");
		testFunction("def css(url, media) link(rel=\"stylesheet\", href=url, type=\"text/css\", media=media); end");
	}
	
}
