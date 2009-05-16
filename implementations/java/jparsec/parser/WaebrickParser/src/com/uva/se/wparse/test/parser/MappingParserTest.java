/*
 * File			: MappingParserTest.java
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
import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.model.module.Mapping;
import com.uva.se.wparse.parser.ExpressionParser;
import com.uva.se.wparse.parser.MappingParser;
import com.uva.se.wparse.parser.MarkupParser;
import com.uva.se.wparse.parser.TerminalParser;

public class MappingParserTest extends TestCase {
	
	Parser<Markup> markupParser = null;
	Parser<Expression> expParser = null;
	Parser<Mapping> mappingParser = null;

	protected void setUp() throws Exception {
		expParser =  ExpressionParser.expression(null);
		markupParser = MarkupParser.markup(expParser);
		mappingParser = MappingParser.mapping(markupParser);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	
	public void testMapping(){
		String source = "wpath1/xpath2/yfile.ext : idCon#desgn";
		TerminalParser.parse(mappingParser, source);
	}
	
	public void testMappingWithEmptyArgs(){
		String source = "wpath1/xpath2/yfile.ext : idCon#desgn()";
		TerminalParser.parse(mappingParser, source);
	}
	
	public void testMappingStartsWithSite(){
		String source = "site/xpath2/yfile.ext : idCon#desgn()";
		TerminalParser.parse(mappingParser, source);
	}
	
	public void testMappingStartsWithSiteHtml(){
		String source = "site/brandendepen.html: brandende-pen()";
		TerminalParser.parse(mappingParser, source);
	}
	
	public void testSiteMapping(){
		String source = "site/abonnementen.html: abonnementen()"; 
		TerminalParser.parse(mappingParser, source);
	}
	
	public void testDebug(){
		String source = "wpath1/xpath2/yfile.ext : bla";
		TerminalParser.parse(mappingParser, source);
	}
	
	


}
