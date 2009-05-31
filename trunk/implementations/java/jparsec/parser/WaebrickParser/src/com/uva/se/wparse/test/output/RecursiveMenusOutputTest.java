package com.uva.se.wparse.test.output;

import com.uva.se.wparse.model.module.ModuleDef;
import com.uva.se.wparse.output.transformer.OutputTransformer;
import com.uva.se.wparse.parser.ModuleParser;

import junit.framework.TestCase;

public class RecursiveMenusOutputTest extends TestCase {
	
	public static final String OUTPUTTEST_MODULE_EMPTY = 		"module(module-id([\"menus\"]),empty)";
	
	public static final String OUTPUTTEST_MODULE_OPEN = 		"module(module-id([\"menus\"]),[";		
	public static final String OUTPUTTEST_SITE = 				"site([mapping(\"menus.html\",call(tag(\"main\",[]),args([])))])";
	public static final String OUTPUTTEST_FUNCTION_MAIN = 		"def(\"main\",empty,[markup-stat([call(tag(\"layout\",[]),args([text(\"\\\"Recursive Menus\\\"\")]))],block([markup(call(tag(\"the-menu\",[]),args([])))]))])";
	public static final String OUTPUTTEST_FUNCTION_CSS = 		"def(\"css\",formals([\"url\",\"media\"]),[markup(call(tag(\"link\",[]),args([attr(\"rel\",text(\"\\\"stylesheet\\\"\")),attr(\"href\",var(\"url\")),attr(\"type\",text(\"\\\"text/css\\\"\")),attr(\"media\",var(\"media\"))])))])";
	public static final String OUTPUTTEST_FUNCTION_LAYOUT = 	"def(\"layout\",formals([\"title\"]),[markup-stat([tag(\"html\",[])],block([markup-stat([tag(\"head\",[])],block([markup(call(tag(\"css\",[]),args([text(\"\\\"blueprint.css\\\"\"),text(\"\\\"screen,projection\\\"\")]))),markup-exp([tag(\"title\",[])],var(\"title\"))])),markup-stat([tag(\"body\",[])],yield)]))])";
	public static final String OUTPUTTEST_FUNCTION_THE_MENU = 	"def(\"the-menu\",empty,[markup(call(tag(\"menu\",[]),args([record([pair(\"title\",text(\"\\\"Menu\\\"\")),pair(\"kids\",list([record([pair(\"title\",text(\"\\\"Home\\\"\")),pair(\"link\",text(\"\\\"/\\\"\"))]),record([pair(\"title\",text(\"\\\"Misc\\\"\")),pair(\"kids\",list([record([pair(\"title\",text(\"\\\"Contact\\\"\")),pair(\"link\",text(\"\\\"contact.html\\\"\"))]),record([pair(\"title\",text(\"\\\"Links\\\"\")),pair(\"link\",text(\"\\\"links.html\\\"\"))])]))])]))])])))])";
	public static final String OUTPUTTEST_FUNCTION_MENU = 		"def(\"menu\",formals([\"menu\"]),[echo(field(var(\"menu\"),\"title\")),markup-stat([tag(\"ul\",[])],each(\"kid\",field(var(\"menu\"),\"kids\"),markup(call(tag(\"item\",[]),args([var(\"kid\")])))))])";
	public static final String OUTPUTTEST_FUNCTION_ITEM = 		"def(\"item\",formals([\"mi\"]),[markup-stat([tag(\"li\",[])],if-else(field(var(\"mi\"),\"kids\"),markup(call(tag(\"menu\",[]),args([var(\"mi\")]))),markup-exp([call(tag(\"a\",[]),args([attr(\"href\",field(var(\"mi\"),\"link\"))]))],field(var(\"mi\"),\"title\"))))])";	
	public static final String OUTPUTTEST_MODULE_CLOSE = 		"])";
	
	public static final String INPUTTEST_MODULE = 				"module menus";
	public static final String INPUTTEST_SITE = 				" site menus.html: main() end";	
	public static final String INPUTTEST_FUNCTION_MAIN = 		" def main layout(\"Recursive Menus\") { the-menu(); } end";
	public static final String INPUTTEST_FUNCTION_CSS = 		" def css(url, media) link(rel=\"stylesheet\", href=url, type=\"text/css\", media=media); end";
	public static final String INPUTTEST_FUNCTION_LAYOUT = 		" def layout(title) html { head { css(\"blueprint.css\", \"screen,projection\"); title title; } body yield; } end";
	public static final String INPUTTEST_FUNCTION_THE_MENU = 	" def the-menu menu({title: \"Menu\", kids: [{title: \"Home\", link: \"/\"}, {title: \"Misc\", kids: [{title: \"Contact\", link: \"contact.html\"}, {title: \"Links\", link: \"links.html\"}]}]}); end";
	public static final String INPUTTEST_FUNCTION_MENU = 		" def menu(menu) echo menu.title; ul each (kid: menu.kids) item(kid); end";
	public static final String INPUTTEST_FUNCTION_ITEM = 		" def item(mi) li if (mi.kids) menu(mi); else a(href=mi.link) mi.title; end";
		
	public String getModuleParserOutput(String WaebricSource){
		ModuleParser declarationParser = new ModuleParser(); 		
		ModuleDef moduleDef = declarationParser.parse(WaebricSource);
		OutputTransformer outputTransformer = new OutputTransformer();
		return outputTransformer.transform(moduleDef);
	}	
	
	public void testEmptyModuleOutput(){
		String source = INPUTTEST_MODULE;
		
		String expectedOutput = OUTPUTTEST_MODULE_EMPTY;
		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testModuleWithSiteOutput(){
		String source = INPUTTEST_MODULE + INPUTTEST_SITE;
		
		String expectedOutput = OUTPUTTEST_MODULE_OPEN;		
		expectedOutput += OUTPUTTEST_SITE;		
		expectedOutput += OUTPUTTEST_MODULE_CLOSE;
		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testModuleWithFunctionMainOutput(){
		String source = INPUTTEST_MODULE + INPUTTEST_FUNCTION_MAIN;
		
		String expectedOutput = OUTPUTTEST_MODULE_OPEN;		
		expectedOutput += OUTPUTTEST_FUNCTION_MAIN;		
		expectedOutput += OUTPUTTEST_MODULE_CLOSE;
		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testModuleWithFunctionCSSOutput(){
		String source = INPUTTEST_MODULE + INPUTTEST_FUNCTION_CSS;
		
		String expectedOutput = OUTPUTTEST_MODULE_OPEN;		
		expectedOutput += OUTPUTTEST_FUNCTION_CSS;		
		expectedOutput += OUTPUTTEST_MODULE_CLOSE;
		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testModuleWithFunctionLayoutOutput(){
		String source = INPUTTEST_MODULE + INPUTTEST_FUNCTION_LAYOUT;
		
		String expectedOutput = OUTPUTTEST_MODULE_OPEN;		
		expectedOutput += OUTPUTTEST_FUNCTION_LAYOUT;		
		expectedOutput += OUTPUTTEST_MODULE_CLOSE;
		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testModuleWithFunctionTheMenuOutput(){
		String source = INPUTTEST_MODULE + INPUTTEST_FUNCTION_THE_MENU;
		
		String expectedOutput = OUTPUTTEST_MODULE_OPEN;
		expectedOutput += OUTPUTTEST_FUNCTION_THE_MENU;		
		expectedOutput += OUTPUTTEST_MODULE_CLOSE;
		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testModuleWithFunctionMenuOutput(){
		String source = INPUTTEST_MODULE + INPUTTEST_FUNCTION_MENU;
		
		String expectedOutput = OUTPUTTEST_MODULE_OPEN;		
		expectedOutput += OUTPUTTEST_FUNCTION_MENU;		
		expectedOutput += OUTPUTTEST_MODULE_CLOSE;
		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testModuleWithFunctionItemOutput(){
		String source = INPUTTEST_MODULE + INPUTTEST_FUNCTION_ITEM;
		
		String expectedOutput = OUTPUTTEST_MODULE_OPEN;		
		expectedOutput += OUTPUTTEST_FUNCTION_ITEM;		
		expectedOutput += OUTPUTTEST_MODULE_CLOSE;
		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testModuleCompleteMenuOutput(){
		String source = INPUTTEST_MODULE + INPUTTEST_SITE + INPUTTEST_FUNCTION_MAIN + INPUTTEST_FUNCTION_CSS + INPUTTEST_FUNCTION_LAYOUT + INPUTTEST_FUNCTION_THE_MENU + INPUTTEST_FUNCTION_MENU + INPUTTEST_FUNCTION_ITEM;
		
		String expectedOutput = OUTPUTTEST_MODULE_OPEN;		
		expectedOutput += OUTPUTTEST_SITE + ",";
		expectedOutput += OUTPUTTEST_FUNCTION_MAIN + ",";
		expectedOutput += OUTPUTTEST_FUNCTION_LAYOUT + ",";
		expectedOutput += OUTPUTTEST_FUNCTION_THE_MENU + ",";
		expectedOutput += OUTPUTTEST_FUNCTION_MENU + ",";
		expectedOutput += OUTPUTTEST_FUNCTION_ITEM;		
		expectedOutput += OUTPUTTEST_MODULE_CLOSE;
		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}

}
