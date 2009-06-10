/*
 * File			: AllEmbeddingOutputTest.java
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
public class AllEmbeddingOutputTest extends TestCase {
	

	// embedding

	// expression embedding
	public static final String INPUTTEST_EXPRESSION_EMBEDDING = "module test def main() echo \"<b \"bold\">\"; end";
	public static final String OUTPUTTEST_EXPRESSION_EMBEDDING = "module(module-id([\"test\"]),[def(\"main\",formals([]),[echo-embedding(pre(\"\\\"<\",exp-embedding([tag(\"b\",[])],text(\"\\\"bold\\\"\")),post(\">\\\"\")))])])";

	// markup embedding
	public static final String INPUTTEST_MARKUP_EMBEDDING = "module test def main() echo \"<b() i()>\"; end";
	public static final String OUTPUTTEST_MARKUP_EMBEDDING = "module(module-id([\"test\"]),[def(\"main\",formals([]),[echo-embedding(pre(\"\\\"<\",markup-embedding([call(tag(\"b\",[]),args([]))],call(tag(\"i\",[]),args([]))),post(\">\\\"\")))])])";
	
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
	
	public void testExpressionEmbeddingOutput(){
		String source = INPUTTEST_EXPRESSION_EMBEDDING;		
		String expectedOutput = OUTPUTTEST_EXPRESSION_EMBEDDING;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}

	public void testMarkupEmbeddingOutput(){
		String source = INPUTTEST_MARKUP_EMBEDDING;		
		String expectedOutput = OUTPUTTEST_MARKUP_EMBEDDING;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}

}
