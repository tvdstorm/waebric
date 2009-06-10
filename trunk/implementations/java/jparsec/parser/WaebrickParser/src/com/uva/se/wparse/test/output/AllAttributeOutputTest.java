/*
 * File			: AllAttributeOutputTest.java
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
public class AllAttributeOutputTest extends TestCase {
	
	// attributes

	// attr
	public static final String INPUTTEST_ATTRIBUTE = "module test def main() img(src=\"www\"); end";
	public static final String OUTPUTTEST_ATTRIBUTE = "module(module-id([\"test\"]),[def(\"main\",formals([]),[markup(call(tag(\"img\",[]),args([attr(\"src\",text(\"\\\"www\\\"\"))])))])])";

	// id
	public static final String INPUTTEST_ATTRIBUTE_ID = "module test def main() img #bla; end";
	public static final String OUTPUTTEST_ATTRIBUTE_ID = "module(module-id([\"test\"]),[def(\"main\",formals([]),[markup(tag(\"img\",[id(\"bla\")]))])])";

	// class
	public static final String INPUTTEST_ATTRIBUTE_CLASS = "module test def main() img .bla; end";
	public static final String OUTPUTTEST_ATTRIBUTE_CLASS = "module(module-id([\"test\"]),[def(\"main\",formals([]),[markup(tag(\"img\",[class(\"bla\")]))])])";

	// name
	public static final String INPUTTEST_ATTRIBUTE_NAME = "module test def main() img $bla; end";
	public static final String OUTPUTTEST_ATTRIBUTE_NAME = "module(module-id([\"test\"]),[def(\"main\",formals([]),[markup(tag(\"img\",[name(\"bla\")]))])])";

	// type
	public static final String INPUTTEST_ATTRIBUTE_TYPE = "module test def main() img :bla; end";
	public static final String OUTPUTTEST_ATTRIBUTE_TYPE = "module(module-id([\"test\"]),[def(\"main\",formals([]),[markup(tag(\"img\",[type(\"bla\")]))])])";

	// width-height
	public static final String INPUTTEST_ATTRIBUTE_WIDTH_HEIGHT = "module test def main() img @42 %84; end";
	public static final String OUTPUTTEST_ATTRIBUTE_WIDTH_HEIGHT = "module(module-id([\"test\"]),[def(\"main\",formals([]),[markup(tag(\"img\",[width-height(42,84)]))])])";

	// height
	public static final String INPUTTEST_ATTRIBUTE_HEIGHT = "module test def main() img @42; end";
	public static final String OUTPUTTEST_ATTRIBUTE_HEIGHT = "module(module-id([\"test\"]),[def(\"main\",formals([]),[markup(tag(\"img\",[height(42)]))])])";
	
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
	
	public void testAttributeOutput(){
		String source = INPUTTEST_ATTRIBUTE;		
		String expectedOutput = OUTPUTTEST_ATTRIBUTE;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testAttributeIdOutput(){
		String source = INPUTTEST_ATTRIBUTE_ID;		
		String expectedOutput = OUTPUTTEST_ATTRIBUTE_ID;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testAttributeClassOutput(){
		String source = INPUTTEST_ATTRIBUTE_CLASS;		
		String expectedOutput = OUTPUTTEST_ATTRIBUTE_CLASS;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testAttributeNameOutput(){
		String source = INPUTTEST_ATTRIBUTE_NAME;		
		String expectedOutput = OUTPUTTEST_ATTRIBUTE_NAME;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testAttributeTypeOutput(){
		String source = INPUTTEST_ATTRIBUTE_TYPE;		
		String expectedOutput = OUTPUTTEST_ATTRIBUTE_TYPE;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testAttributeWidthHeightOutput(){
		String source = INPUTTEST_ATTRIBUTE_WIDTH_HEIGHT;		
		String expectedOutput = OUTPUTTEST_ATTRIBUTE_WIDTH_HEIGHT;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testAttributeHeightOutput(){
		String source = INPUTTEST_ATTRIBUTE_HEIGHT;		
		String expectedOutput = OUTPUTTEST_ATTRIBUTE_HEIGHT;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}

}
