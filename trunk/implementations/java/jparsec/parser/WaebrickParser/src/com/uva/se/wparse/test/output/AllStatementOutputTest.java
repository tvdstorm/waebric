/*
 * File			: AllStatementOutputTest.java
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
package com.uva.se.wparse.test.output;

import com.uva.se.wparse.exception.ParserException;
import com.uva.se.wparse.model.module.ModuleDef;
import com.uva.se.wparse.output.transformer.OutputTransformer;
import com.uva.se.wparse.parser.ModuleParser;

import junit.framework.TestCase;

/**
 * This is a test class and it checks if a given Waebric input the correct output 
 * is generated. This is tested based on the online tool which generates output 
 * based on Weabric. 
 * 
 * The functions aren't documented. There are two reasons for not documenting 
 * this tests: 
 * - There are some time limits;
 * - The tests are working always in the same manner, so the default pattern is 
 *   documented above.  
 */
public class AllStatementOutputTest extends TestCase {
	
	// statements

	// if
	public static final String INPUTTEST_STATEMENT_IF = "module test def main(item) if (item.kids) li menu(item); end";
	public static final String OUTPUTTEST_STATEMENT_IF = "module(module-id([\"test\"]),[def(\"main\",formals([\"item\"]),[if(field(var(\"item\"),\"kids\"),markup-markup([tag(\"li\",[])],call(tag(\"menu\",[]),args([var(\"item\")]))),appl(prod([],cf(sort(\"NoElseMayFollow\")),no-attrs),[]))])])";

	// if-else
	public static final String INPUTTEST_STATEMENT_IF_ELSE = "module test def main(item) if (item.kids) li menu(item); else li a(href=item.link) item.title; end";
	public static final String OUTPUTTEST_STATEMENT_IF_ELSE = "module(module-id([\"test\"]),[def(\"main\",formals([\"item\"]),[if-else(field(var(\"item\"),\"kids\"),markup-markup([tag(\"li\",[])],call(tag(\"menu\",[]),args([var(\"item\")]))),markup-exp([tag(\"li\",[]),call(tag(\"a\",[]),args([attr(\"href\",field(var(\"item\"),\"link\"))]))],field(var(\"item\"),\"title\")))])])";

	// each
	public static final String INPUTTEST_STATEMENT_EACH = "module test def main(menu) each (item : menu) item.increment; end";
	public static final String OUTPUTTEST_STATEMENT_EACH = "module(module-id([\"test\"]),[def(\"main\",formals([\"menu\"]),[each(\"item\",var(\"menu\"),markup(tag(\"item\",[class(\"increment\")])))])])";

	// let
	public static final String INPUTTEST_STATEMENT_LET = "module test def main(item) let a=42; in yield; end end";
	public static final String OUTPUTTEST_STATEMENT_LET = "module(module-id([\"test\"]),[def(\"main\",formals([\"item\"]),[let([var-bind(\"a\",num(42))],[yield])])])";

	// block
	public static final String INPUTTEST_STATEMENT_BLOCK = "module test def main(menu) each (item : menu) {item.increment; item.double;} end";
	public static final String OUTPUTTEST_STATEMENT_BLOCK = "module(module-id([\"test\"]),[def(\"main\",formals([\"menu\"]),[each(\"item\",var(\"menu\"),block([markup(tag(\"item\",[class(\"increment\")])),markup(tag(\"item\",[class(\"double\")]))]))])])";

	// comment
	public static final String INPUTTEST_STATEMENT_COMMENT = "module test def main(menu) comment \"This is comment\"; end";
	public static final String OUTPUTTEST_STATEMENT_COMMENT = "module(module-id([\"test\"]),[def(\"main\",formals([\"menu\"]),[comment(\"This is comment\")])])";

	// echo expression
	public static final String INPUTTEST_STATEMENT_ECHO_EXP_TEXT = "module test def main() echo \"Hello world\"; end";
	public static final String OUTPUTTEST_STATEMENT_ECHO_EXP_TEXT = "module(module-id([\"test\"]),[def(\"main\",formals([]),[echo(text(\"\\\"Hello world\\\"\"))])])";

	public static final String INPUTTEST_STATEMENT_ECHO_EXP_INT = "module test def main() echo 42; end";
	public static final String OUTPUTTEST_STATEMENT_ECHO_EXP_INT = "module(module-id([\"test\"]),[def(\"main\",formals([]),[echo(num(42))])])";

	public static final String INPUTTEST_STATEMENT_ECHO_EXP_VAR = "module test def main() let output = 42; in echo output; end end";
	public static final String OUTPUTTEST_STATEMENT_ECHO_EXP_VAR = "module(module-id([\"test\"]),[def(\"main\",formals([]),[let([var-bind(\"output\",num(42))],[echo(var(\"output\"))])])])";

	// echo embedding
	public static final String INPUTTEST_STATEMENT_ECHO_EMBED_TEXT = "module test def main() echo \"<b \"bold\">\"; end";
	public static final String OUTPUTTEST_STATEMENT_ECHO_EMBED_TEXT = "module(module-id([\"test\"]),[def(\"main\",formals([]),[echo-embedding(pre(\"\\\"<\",exp-embedding([tag(\"b\",[])],text(\"\\\"bold\\\"\")),post(\">\\\"\")))])])";

	public static final String INPUTTEST_STATEMENT_ECHO_EMBED_INT = "module test def main() echo \"<b 42>\"; end";
	public static final String OUTPUTTEST_STATEMENT_ECHO_EMBED_INT = "module(module-id([\"test\"]),[def(\"main\",formals([]),[echo-embedding(pre(\"\\\"<\",exp-embedding([tag(\"b\",[])],num(42)),post(\">\\\"\")))])])";
	
	public static final String INPUTTEST_STATEMENT_ECHO_EMBED_VAR = "module test def main() echo \"<b output>\"; end";
	public static final String OUTPUTTEST_STATEMENT_ECHO_EMBED_VAR = "module(module-id([\"test\"]),[def(\"main\",formals([]),[echo-embedding(pre(\"\\\"<\",exp-embedding([tag(\"b\",[])],var(\"output\")),post(\">\\\"\")))])])";

	// cdata
	public static final String INPUTTEST_STATEMENT_CDATA_TEXT = "module test def main() cdata \"cdata\"; end";
	public static final String OUTPUTTEST_STATEMENT_CDATA_TEXT = "module(module-id([\"test\"]),[def(\"main\",formals([]),[cdata(text(\"\\\"cdata\\\"\"))])])";

	public static final String INPUTTEST_STATEMENT_CDATA_INT = "module test def main() cdata 42; end";
	public static final String OUTPUTTEST_STATEMENT_CDATA_INT = "module(module-id([\"test\"]),[def(\"main\",formals([]),[cdata(num(42))])])";

	public static final String INPUTTEST_STATEMENT_CDATA_VAR = "module test def main() let output = 42; in cdata output; end end";
	public static final String OUTPUTTEST_STATEMENT_CDATA_VAR = "module(module-id([\"test\"]),[def(\"main\",formals([]),[let([var-bind(\"output\",num(42))],[cdata(var(\"output\"))])])])";

	// yield
	public static final String INPUTTEST_STATEMENT_YIELD = "module test def main() yield; end";
	public static final String OUTPUTTEST_STATEMENT_YIELD = "module(module-id([\"test\"]),[def(\"main\",formals([]),[yield])])";

	public String getModuleParserOutput(String WaebricSource){
		ModuleParser declarationParser = new ModuleParser(); 		
		ModuleDef moduleDef = null;
		try {
			moduleDef = declarationParser.parse(WaebricSource);
		} catch (ParserException e) {
			//ignore this
		}
		OutputTransformer outputTransformer = new OutputTransformer();
		return outputTransformer.transform(moduleDef);
	}
	
	public void testStatementIfOutput(){
		String source = INPUTTEST_STATEMENT_IF;		
		String expectedOutput = OUTPUTTEST_STATEMENT_IF;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}

	public void testStatementIfElseOutput(){
		String source = INPUTTEST_STATEMENT_IF_ELSE;		
		String expectedOutput = OUTPUTTEST_STATEMENT_IF_ELSE;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testStatementEachOutput(){
		String source = INPUTTEST_STATEMENT_EACH;		
		String expectedOutput = OUTPUTTEST_STATEMENT_EACH;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testStatementLetOutput(){
		String source = INPUTTEST_STATEMENT_LET;		
		String expectedOutput = OUTPUTTEST_STATEMENT_LET;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testStatementBlockOutput(){
		String source = INPUTTEST_STATEMENT_BLOCK;		
		String expectedOutput = OUTPUTTEST_STATEMENT_BLOCK;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testStatementCommentOutput(){
		String source = INPUTTEST_STATEMENT_COMMENT;		
		String expectedOutput = OUTPUTTEST_STATEMENT_COMMENT;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testStatementEchoExpTextOutput(){
		String source = INPUTTEST_STATEMENT_ECHO_EXP_TEXT;		
		String expectedOutput = OUTPUTTEST_STATEMENT_ECHO_EXP_TEXT;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testStatementEchoExpIntOutput(){
		String source = INPUTTEST_STATEMENT_ECHO_EXP_INT;		
		String expectedOutput = OUTPUTTEST_STATEMENT_ECHO_EXP_INT;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testStatementEchoExpVarOutput(){
		String source = INPUTTEST_STATEMENT_ECHO_EXP_VAR;		
		String expectedOutput = OUTPUTTEST_STATEMENT_ECHO_EXP_VAR;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testStatementEchoEmbedTextOutput(){
		String source = INPUTTEST_STATEMENT_ECHO_EMBED_TEXT;		
		String expectedOutput = OUTPUTTEST_STATEMENT_ECHO_EMBED_TEXT;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testStatementEchoEmbedIntOutput(){
		String source = INPUTTEST_STATEMENT_ECHO_EMBED_INT;		
		String expectedOutput = OUTPUTTEST_STATEMENT_ECHO_EMBED_INT;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testStatementEchoEmbedVarOutput(){
		String source = INPUTTEST_STATEMENT_ECHO_EMBED_VAR;		
		String expectedOutput = OUTPUTTEST_STATEMENT_ECHO_EMBED_VAR;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testStatementCdataTextOutput(){
		String source = INPUTTEST_STATEMENT_CDATA_TEXT;		
		String expectedOutput = OUTPUTTEST_STATEMENT_CDATA_TEXT;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testStatementCdataIntOutput(){
		String source = INPUTTEST_STATEMENT_CDATA_INT;		
		String expectedOutput = OUTPUTTEST_STATEMENT_CDATA_INT;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testStatementCdataVarOutput(){
		String source = INPUTTEST_STATEMENT_CDATA_VAR;		
		String expectedOutput = OUTPUTTEST_STATEMENT_CDATA_VAR;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testStatementYieldOutput(){
		String source = INPUTTEST_STATEMENT_YIELD;		
		String expectedOutput = OUTPUTTEST_STATEMENT_YIELD;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
}
