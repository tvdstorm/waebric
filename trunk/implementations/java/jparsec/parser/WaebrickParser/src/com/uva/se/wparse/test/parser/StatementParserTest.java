/*
 * File			: StatementParserTest.java
 * Project		: WaebrickParser
 * 				: Waebrick Parser, practicum opdracht Software Construction
 * 
 * Author		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * Description	:
 * 
 * 
 * Change history
 * -----------------------------------------------------------
 * Date			Change				 
 * -----------------------------------------------------------
 * 07-05-2009	Initial version.
 * 
 * 
 */
package com.uva.se.wparse.test.parser;

import junit.framework.TestCase;

import org.codehaus.jparsec.Parser;

import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.markup.Argument;
import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.model.statement.Statement;
import com.uva.se.wparse.parser.ArgumentParser;
import com.uva.se.wparse.parser.ExpressionParser;
import com.uva.se.wparse.parser.MarkupParser;
import com.uva.se.wparse.parser.StatementParser;
import com.uva.se.wparse.parser.TerminalParser;

public class StatementParserTest extends TestCase {

	Parser<Markup> markupParser = null;
	Parser<Expression> expParser = null;
	Parser<Argument> argumentParser = null;
	Parser<Statement> statemenParser = null;

	protected void setUp() throws Exception {
		super.setUp();
		expParser = ExpressionParser.expression(null);
		markupParser = MarkupParser.markup(expParser);
		argumentParser = ArgumentParser.arguments(expParser);
		statemenParser = StatementParser.statement(expParser, markupParser);

	}

	protected void tearDown() throws Exception {
		super.tearDown();
		expParser = null;
	}

	public void testEchoString() {
		String source = "echo \"Hello World!\" ;";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testEchoEmbedSymbolStatement() {
		String source = "echo \"<em 'SYMBOL >\" ;";
		TerminalParser.parse(statemenParser, source);
	}

	public void testEchoEmbedStringStatement() {
		String source = "echo \"<em \"Martin Pieters\">\" ;";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testEchoEmailAddress() {
		String source = "echo \" test@test.nl\";";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testEchoEmbeddedMarkupWithExpression() {
		String source = "echo \"pre text <a (href=\"mailto:mail1@domain1.nl\") \"mail2@domain2.nl\"> post text\";";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testEchoEmbeddedding() {
		String source = "echo \"<b output>\";";
		TerminalParser.parse(statemenParser, source);
	}
	
	
	public void testComment() {
		String source = "comment \"comment line\";";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testCdataString() {
		String source = "cdata \"cdata line\";";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testCdataKeyValueBlock() {
		String source = "cdata {key1:value1, key2:value2};";
		TerminalParser.parse(statemenParser, source);
	}


	public void testMarkupWithEmbedding() {
		String source = "idcon#idcon2 \"<em 'SYMBOL >\" ;";
		TerminalParser.parse(statemenParser, source);
	}

	public void testMarkupStatement() {
		String source = "td img ; ";
		TerminalParser.parse(statemenParser, source);
	}

	public void testBlockSingleStatement() {
		String source = "{ echo \"no nesting here\"; } ";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testBlockMultipleStatement() {
		String source = "{ echo \"no nesting here\";  echo \"still no nesting here\"; } ";
		TerminalParser.parse(statemenParser, source);
	}

	public void testNestedBlockStatement() {
		String source = "{ { echo \"nesting here\"; } } ";
		TerminalParser.parse(statemenParser, source);
	}

	public void testBlockStatementWithMarkup() {
		String source = "td img { echo \"no nesting here\"; } ";
		TerminalParser.parse(statemenParser, source);
	}

	public void testBlockStatementWithMarkupAndNesting() {
		String source = "p1 { p2 { echo \" nesting here\";}  } ";
		TerminalParser.parse(statemenParser, source);
	}

	public void testLetInStatement() {
		String source = "let td(img, alt) = td img(width=\"160\",height=\"160\", alt=alt,src=img) ; "
				+ "in echo \"test\"; end";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testLetInAssignmentStatement() {
		String source = "let var1 = expr2; in yield; end";
		TerminalParser.parse(statemenParser, source);
	}

	public void testMarkupBlockStatement() {
		String source = "td(\"images/lavakaft_14-1.jpg\", \"lava 14-1\");";
		TerminalParser.parse(statemenParser, source);
	}

	public void testLetInAdvancedStatement() {
		String source = "let td(img, alt) = td img(width=\"160\",height=\"160\", alt=alt,src=img); "
				+ "in  tr { td(\"images/lavakaft_13-34.jpg\", \"lava 13-34\"); "
				+ "td(\"images/lavakaft_14-1.jpg\", \"lava 14-1\"); "
				+ "td(\"images/lavakaft_14-2.jpg\", \"lava 14-2\"); } end";

		TerminalParser.parse(statemenParser, source);
	}
	
	public void testLetInComplexAssignment() {
		String source = "let td(img, alt, pdf) = td(width=200) { img@160%160(src=img,alt=alt); " +
						"br; a(href=pdf,target=\"_blank\") yield; } in echo \"in complex let statement\"; end";

		TerminalParser.parse(statemenParser, source);
	}

	public void testMarkupStatementWithEmailAddress() {
		String source = "p \"Stuur korte verhalen, gedichten, graphic stories en illustraties als attachment naar. "
				+ "<a (href=\"mailto:redactie@lavaliterair.nl\") \"redactie@lavaliterair.nl\"> post. end\";";
		TerminalParser.parse(statemenParser, source);
	}

	
	public void testMarkupAndEchoMailtoEmailAddress() {
		String source = "designator#test echo \" mailto:test@test.nl\";";
		TerminalParser.parse(statemenParser, source);
	}

	public void testTextAndMailtoEmailAddress() {
		String source = "echo \"stuur mail naar <a (href=\"mailto:test@test.nl\") \"test@test.nl\"> \"; ";
		TerminalParser.parse(statemenParser, source);
	}

	public void testEmbeddedMarkupStatement() {
		String source = "li \"pre text <a (href=mailto:testtest1.nl) testtest2.nl> post text \";";
		TerminalParser.parse(statemenParser, source);
	}

	public void testEmbeddedMarkupAndExpressionStatement() {
		String source = "li (href=\"mailto:test@test.nl\") \"test@test.nl\" ;";
		TerminalParser.parse(statemenParser, source);
	}

	public void testEmbeddedMarkupWithExpression() {
		String source = "li.td \"pre text <a (href=\"mailto:mail1@domain1.nl\") \"mail2@domain2.nl\"> post text\";";
		TerminalParser.parse(statemenParser, source);
	}


	public void testMarkupWithText() {
		String source = "li \"test text end \";";
		TerminalParser.parse(statemenParser, source);
	}

	public void testMarkupMethodCall() {
		String source = "header(\"Abonnee worden?\");";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testMarkupMethodCallInsideBlock() {
		String source = "{header(\"Abonnee worden?\");}";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testIfPredicateNoElse() {
		String source = "if ( myList.list? ) echo \"myList is a list\" ;";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testIfPredicateElse() {
		String source = "if ( myList.list? ) echo \"myList is a list\"; else echo \"myList is NOT a list\" ;";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testIfPredicateElseWithMarkup() {
		String source = "if ( myList.list? ) markup1; else markup2 ;";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testIfPredicateElseWithMarkupList() {
		String source = "if (mi.kids) menu(mi); else a(href=mi.link) mi.title;";
		TerminalParser.parse(statemenParser, source);
	}
	
	
	
	public void testEach() {
		String source = "each (  var : varExpression ) echo \"do x for each item\";";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testYield() {
		String source = "yield;";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testMarkupMethod(){
		String source = "header (\"Literaire Prijs de Brandende Pen 2007\");";
		TerminalParser.parse(statemenParser, source);
	}
	
	
	public void testMarkupWithUrl(){
		String source = "td a(href=\"http://www.nrcboeken.nl/nieuws/jan-aelberts-wint-brandende-pen\") img(height=30, src=\"images/logos/nrcboeken_logo.gif\");";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testMarkupWithUrlArgument(){
		String source = "td a(href=\"http://www.nrcboeken.nl/nieuws/janaelbertswintbrandendepen\");";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testMarkupList(){
		String source = "td a(href=\"test1\") img(height=\"30\");";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testMarkupWithMultipleArguments(){
		String source = "img(height=30, src=\"images/logos/nrcboeken_logo.gif\");";
		TerminalParser.parse(statemenParser, source);
	}
	
	
	public void testEchoDoubleSlashes(){
		String source = "echo \" //  \";";
		TerminalParser.parse(statemenParser, source);
	}
	

	public void testEchoStringWithLineComment(){
		String source = "echo \"test commentline\";  // this is comment ";
		try {
			TerminalParser.parse(statemenParser, source);
		} catch (Exception e) {
			//failure of parsing the string was required to pass the test.
			assertNull(null);
			return;
		}
		
		assertNotNull(null);
	}
	
	
	public void testEchoStringWithBlockComment(){
		String source = "echo \"test commentline\";  /* this is comment line1 \n comment line2 */ ";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testSingleMarkup(){
		String source = "markuptest;";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testSingleMarkupWithDash(){
		String source = "markuptest-with-dash;";
		TerminalParser.parse(statemenParser, source);
	}

	public void testMarkupBlock() {
		String source = "div.span-getal.colborder { uitreiking09;}";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testMarkupBlockWithNumber() {
		String source = "div.span-getal.part5-555.colborder { uitreiking09;}";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testMarkupEmptyBlock() {
		String source = "markup-prefix { }";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testMarkupLetInBlock() {
		String source = "markup-prefix { let td(img, alt, pdf) = td(width=200) { img@160%160(src=img,alt=alt); " +
		"br; a(href=pdf,target=\"_blank\") yield; } in echo \"in complex let statement\"; end  }";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testMarkupLetInBlockWithOtherStatements() {
		String source = "markup-prefix { let td(img, alt, pdf) = td(width=200) { img@160%160(src=img,alt=alt); " +
		"br; a(href=pdf,target=\"_blank\") yield; } in echo \"test\"; end comment \"test\"; }";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testMarkupSimpleLetInBlockWithOtherStatements() {
		String source = "markup-prefix { let test = \"test2\"; " +
		"in echo \"test\"; end }";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testMarkupBlockNestingWithOtherStatements() {
		String source = "markup-prefix { nested-markup { echo \"nested echo\"; } echo \"in complex let statement\"; yield; }";
		TerminalParser.parse(statemenParser, source);
	}
	
	
	public void testMarkupUrl(){
		String source = "li a(href=\"http://www.crosswinds.net/~rugdichter/\") \"RuGdichters\"; ";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testEchoJavaScript(){
		String source = "echo \" var gaJsHost = ((\"https:\" == document.location.protocol) ? \"https://ssl.\" : \"http://www.\"); " +
						"document.write(unescape(\"%3Cscript src='\" + gaJsHost + \"google-analytics.com/ga.js' " +
						"type='text/javascript'%3E%3C/script%3E\"));  \"; ";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testEchoNestedString(){
		String source = "echo \" begin \" middle \"  end \" ;";
		//source = source.replace("\"", "\\\"");
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testMarkupStatementIfElse(){
		String source = "li if (mi.kids) menu(mi); else a(href=mi.link) mi.title;";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testMarkupExpression(){
		String source = "a(href=mi.link) mi.title;";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testMultipleMarkupExpression(){
		String source = "a(href=mi.link) b(href=mi.link) markup2 mi.title;";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testMultipleMarkupExpression2(){
		String source = "design-pre design0 a(href=mi.link) design1 b(href=mi.link) mi.title;";
		TerminalParser.parse(statemenParser, source);
	}
	public void testMultipleMarkup(){
		String source = "designator1.bla designator2#bla2 designator3$bla3 designator4$bla4;";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testMultipleMarkupFuncCall(){
		String source = "li menu(item);";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testMultipleMarkupBlock(){
		String source = "td img(var = var2, var3 = var4);";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void test2Markup1Expression(){
		String source = "design1#a design1.a \"stringie\"; ";
		TerminalParser.parse(statemenParser, source);
	}
	
	 
	public void testMarkupExpression2(){
		String source = "title title2; ";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testMarkupExpression3(){
		String source = "title title2 title3; ";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testMarkupBlock2(){
		String source = "{ css(\"blueprint.css\", \"screen,projection\"); title title; }  ";
		TerminalParser.parse(statemenParser, source);
	}
	 
	
	
	
	

}
