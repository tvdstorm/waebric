/*
 * File			: StatementParserTest.java
 * Project		: WaebrickParser
 * 				: Practicum opdracht Software Construction
 * 
 * Authors		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * 
 * Description	:
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

	//Parser<Attribute> attributeParser = null;
	Parser<Markup> markupParser = null;
	Parser<Expression> expParser = null;
	 Parser<Argument> argumentParser = null;
	 Parser<Statement> statemenParser = null;

	
	protected void setUp() throws Exception {
		super.setUp();
		//attributeParser = AttributeParser.attributes();
		expParser =  ExpressionParser.expression(null);
		markupParser = MarkupParser.markup(expParser);
		argumentParser = ArgumentParser.arguments(expParser);
		statemenParser = StatementParser.statement(expParser, markupParser);

	}

	protected void tearDown() throws Exception {
		super.tearDown();
		expParser = null;
	}
	
	public void testEchoEmbedSymbolStatement(){
		String source = "echo <em 'SYMBOL > ;";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testEchoEmbedStringStatement(){
		String source = "echo <em \"Martin Pieters\"> ;";
		TerminalParser.parse(statemenParser, source);
	}
	
	
	public void testMarkupWithEmbedding(){
		String source = "idcon#idcon2 <em 'SYMBOL > ;";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testMarkupWithEmbedding2(){
		String source = "idcon#idcon2 <em 'SYMBOL > ;";
		TerminalParser.parse(statemenParser, source);
	}
	
	
	public void testLetInStatement(){
		String source = "let td(img, alt) = td img(width=\"160\",height=\"160\", alt=alt,src=img) ; " +
		"in echo \"test\"; end";
    
   
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testMarkupStatement(){
		String source = "td img ; ";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testBlockStatement(){
		String source = "{ echo \"no nesting here\"; } ";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testNestedBlockStatement(){
		String source = "{ { echo \"nesting here\"; } } ";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testBlockStatementWithMarkup(){
		String source = "td img { echo \"no nesting here\"; } ";
		TerminalParser.parse(statemenParser, source);
	}
	
	public void testBlockStatementWithMarkupAndNesting(){
		String source = "p1 { p2 { echo \" nesting here\";}  } ";
		TerminalParser.parse(statemenParser, source);
	}
	
	
	
	
	public void testLetInAdvancedStatement(){
		String source = "let td(img, alt) = td img(width=\"160\",height=\"160\", alt=alt,src=img); " +
		"in  tr { td(\"images/lavakaft_13-34.jpg\", \"lava 13-34\"); "+
	     "td(\"images/lavakaft_14-1.jpg\", \"lava 14-1\"); " +
	     "td(\"images/lavakaft_14-2.jpg\", \"lava 14-2\"); } end";
    
   
		TerminalParser.parse(statemenParser, source);
	}
	
	
	public void testMarkupStatementWithEmailAddress(){
		String source = "p \"Stuur korte verhalen, gedichten, graphic stories en illustraties als attachment naar .\" " +
		"<a(href=\"mailto_redactie_lavaliterair.nl\") \"redactie_lavaliterair.nl\">	;";
		TerminalParser.parse(statemenParser, source);
	}
    
	
	

}
