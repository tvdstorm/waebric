package com.uva.se.wparse.test.output;

import junit.framework.TestCase;

public class AllStatementOutputTest extends TestCase {
	
	public static final String OUTPUTTEST_MODULE_OPEN = 		"module(module-id([\"menus\"]),[";		
	public static final String OUTPUTTEST_STATEMENT_ASSIGNMENT ="def(\"main\",empty,[markup-stat([call(tag(\"layout\",[]),args([text(\"\\\"Recursive Menus\\\"\")]))],block([markup(call(tag(\"the-menu\",[]),args([])))]))])";
	public static final String OUTPUTTEST_FUNCTION_CSS = 		"def(\"css\",formals([\"url\",\"media\"]),[markup(call(tag(\"link\",[]),args([attr(\"rel\",text(\"\\\"stylesheet\\\"\")),attr(\"href\",var(\"url\")),attr(\"type\",text(\"\\\"text/css\\\"\")),attr(\"media\",var(\"media\"))])))])";
	public static final String OUTPUTTEST_FUNCTION_LAYOUT = 	"def(\"layout\",formals([\"title\"]),[markup-stat([tag(\"html\",[])],block([markup-stat([tag(\"head\",[])],block([markup(call(tag(\"css\",[]),args([text(\"\\\"blueprint.css\\\"\"),text(\"\\\"screen,projection\\\"\")]))),markup-exp([tag(\"title\",[])],var(\"title\"))])),markup-stat([tag(\"body\",[])],yield)]))])";
	public static final String OUTPUTTEST_FUNCTION_THE_MENU = 	"def(\"the-menu\",empty,[markup(call(tag(\"menu\",[]),args([record([pair(\"title\",text(\"\\\"Menu\\\"\")),pair(\"kids\",list([record([pair(\"title\",text(\"\\\"Home\\\"\")),pair(\"link\",text(\"\\\"/\\\"\"))]),record([pair(\"title\",text(\"\\\"Misc\\\"\")),pair(\"kids\",list([record([pair(\"title\",text(\"\\\"Contact\\\"\")),pair(\"link\",text(\"\\\"contact.html\\\"\"))]),record([pair(\"title\",text(\"\\\"Links\\\"\")),pair(\"link\",text(\"\\\"links.html\\\"\"))])]))])]))])])))])";
	public static final String OUTPUTTEST_FUNCTION_MENU = 		"def(\"menu\",formals([\"menu\"]),[echo(field(var(\"menu\"),\"title\")),markup-stat([tag(\"ul\",[])],each(\"kid\",field(var(\"menu\"),\"kids\"),markup(call(tag(\"item\",[]),args([var(\"kid\")])))))])";
	public static final String OUTPUTTEST_FUNCTION_ITEM = 		"def(\"item\",formals([\"mi\"]),[markup-stat([tag(\"li\",[])],if-else(field(var(\"mi\"),\"kids\"),markup(call(tag(\"menu\",[]),args([var(\"mi\")]))),markup-exp([call(tag(\"a\",[]),args([attr(\"href\",field(var(\"mi\"),\"link\"))]))],field(var(\"mi\"),\"title\"))))])";	
	public static final String OUTPUTTEST_MODULE_CLOSE = 		"])";
	
	public static final String INPUTTEST_MODULE 				= "module menus";
	public static final String INPUTTEST_STATEMENT_ASSIGNMENT 	= " site menus.html: main() end";
	
	
	
	public static final String INPUTTEST_SITE = 				" site menus.html: main() end";	
	public static final String INPUTTEST_FUNCTION_MAIN = 		" def main layout(\"Recursive Menus\") { the-menu(); } end";
	public static final String INPUTTEST_FUNCTION_CSS = 		" def css(url, media) link(rel=\"stylesheet\", href=url, type=\"text/css\", media=media); end";
	public static final String INPUTTEST_FUNCTION_LAYOUT = 		" def layout(title) html { head { css(\"blueprint.css\", \"screen,projection\"); title title; } body yield; } end";
	public static final String INPUTTEST_FUNCTION_THE_MENU = 	" def the-menu menu({title: \"Menu\", kids: [{title: \"Home\", link: \"/\"}, {title: \"Misc\", kids: [{title: \"Contact\", link: \"contact.html\"}, {title: \"Links\", link: \"links.html\"}]}]}); end";
	public static final String INPUTTEST_FUNCTION_MENU = 		" def menu(menu) echo menu.title; ul each (kid: menu.kids) item(kid); end";
	public static final String INPUTTEST_FUNCTION_ITEM = 		" def item(mi) li; if (mi.kids) menu(mi); else a(href=mi.link) mi.title; end";
	

}
