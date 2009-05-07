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
import com.uva.se.wparse.model.markup.Attribute;
import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.model.statement.Statement;
import com.uva.se.wparse.parser.ArgumentParser;
import com.uva.se.wparse.parser.AttributeParser;
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
		ArgumentParser argParser = new ArgumentParser();
		argumentParser = argParser.arguments(expParser);
		statemenParser = StatementParser.statement(expParser, markupParser);

	}

	protected void tearDown() throws Exception {
		super.tearDown();
		expParser = null;
	}

	public void testEchoEmbedSymbolStatement() {
		String source = "echo \"<em 'SYMBOL >\" ;";
		TerminalParser.parse(statemenParser, source);
	}

	public void testEchoEmbedStringStatement() {
		String source = "echo \"<em \"Martin Pieters\">\" ;";
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

	public void testBlockStatement() {
		String source = "{ echo \"no nesting here\"; } ";
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

	public void testMarkupStatementWithEmailAddress() {
		String source = "p \"Stuur korte verhalen, gedichten, graphic stories en illustraties als attachment naar. "
				+ "<a (href=\"mailto:redactie@lavaliterair.nl\") \"redactie@lavaliterair.nl\"> post. end\";";
		TerminalParser.parse(statemenParser, source);
	}

	public void testEchoEmailAddress() {
		String source = "echo \" test@test.nl\";";
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

	public void testEchoEmbeddedMarkupWithExpression() {
		String source = "echo \"pre text <a (href=\"mailto:mail1@domain1.nl\") \"mail2@domain2.nl\"> post text\";";
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

}
