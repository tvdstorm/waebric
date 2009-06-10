/*
 * File			: AssignmentParserTest.java
 * Project		: WaebrickParser2
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
import com.uva.se.wparse.model.statement.Assignment;
import com.uva.se.wparse.model.statement.Statement;
import com.uva.se.wparse.parser.ArgumentParser;
import com.uva.se.wparse.parser.AssignmentParser;
import com.uva.se.wparse.parser.ExpressionParser;
import com.uva.se.wparse.parser.MarkupParser;
import com.uva.se.wparse.parser.StatementParser;
import com.uva.se.wparse.parser.TerminalParser;

/**
 * This is a test class and it checks if a given Waebric input the parser can
 * parse the Waebric code.
 * 
 * The functions aren't documented. There are two reasons for not documenting
 * this tests: - There are some time limits; - The tests are working always in
 * the same manner, so the default pattern is documented above.
 */
public class AssignmentParserTest extends TestCase {

	Parser<Markup> markupParser = null;
	Parser<Expression> expParser = null;
	Parser<Argument> argumentParser = null;
	Parser<Statement> statemenParser = null;
	Parser<Assignment> assignmentParser = null;

	protected void setUp() throws Exception {
		super.setUp();
		expParser = ExpressionParser.expression(null);
		markupParser = MarkupParser.markup(expParser);
		argumentParser = ArgumentParser.arguments(expParser);
		statemenParser = StatementParser.statement(expParser, markupParser);

		// AssignmentParser assParser = new AssignmentParser();
		assignmentParser = AssignmentParser.assignment(statemenParser,
				expParser);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testAssignmentNormal() {
		String source = "var = testvalue;";
		TerminalParser.parse(assignmentParser, source);
	}

	public void testAssignmentFormals() {
		String source = "idCon ( var1, var2, var3) = echo \"dummy statement\";";
		TerminalParser.parse(assignmentParser, source);
	}

	public void testAssignmentWithRul() {
		String source = "link = \"http://www.vpro.nl/programma/deavonden/afleveringen/34639264/items/35915764/media/35915897/\";";
		TerminalParser.parse(assignmentParser, source);
	}

}
