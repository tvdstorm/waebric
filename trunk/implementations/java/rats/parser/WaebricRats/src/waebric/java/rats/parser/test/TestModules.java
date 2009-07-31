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
	public void modules() {
		testModule("module Bla");
		testModule("module Bla def f() end");
		testModule("module Bla import foo;");
		testModule("module Bla import foo; def f() end");
	}
	
	@Test
	public void functions() {
		testFunction("def main  layout(\"Recursive Menus\") { the-menu(); } end");
		testFunction("def css(url, media) link(rel=\"stylesheet\", href=url, type=\"text/css\", media=media); end");
		
		testFunction("def layout(title)\n" +
 "		  html {\n" +
 "		    head {\n" +
 "		      css(\"blueprint.css\", \"screen, projection\");      \n" +
 "		      title title;\n" +
 "		    }\n" +
 "		    body yield;\n" +
 "		  }\n" +
 "		end");
		
		testFunction("def the-menu\n" +
 "		  menu({title: \"Menu\", kids: [{title: \"Home\", link: \"/\"}, \n" +
 "		           {title: \"Misc\", kids: \n" +
 "				[{title: \"Contact\", link: \"contact.html\"}, \n" +
 "		                   {title: \"Links\", link: \"links.html\"}]}]});\n" +
 "		end");
		
		testFunction("def menu(menu)\n" +
 "		  echo menu.title;\n" +
 "		  ul\n" +
 "		   each (kid: menu.kids) \n" +
 "		    item(kid);\n" +
 "		end");
		
		testFunction("def item(mi)\n" +
 "		  li if (mi.kids)\n" +
 "		       menu(mi);\n" +
 "		     else \n" +
 "		       a(href=mi.link) mi.title;\n" +
 "		end");
		
		testFunction("def swfobject(url, width, height, id)\n" +
 " object(classid='clsid:D27CDB6E-AE6D-11cf-96B8-444553540000, width=width, height=height) {\n" +
 "    param$movie(url);\n" +
 "    param$quality('high);\n" +
 "    param$bgcolor('#fffce6);\n" +
 "    comment \"[if !IE]>\";\n" +
 "    object(type='application/x-shockwave-flash, data=url, width=width, height=height) {\n" +
 "      param$quality('high);\n" +
 "      param$bgcolor('#fffce6);\n" +
 "      comment \"<![endif]\";\n" +
 "      comment \"[if !IE]>\";\n" +
 "    }      \n" +
 "    comment \"<![endif]\";\n" +
 "  }\n" +
 "end");
	}
}