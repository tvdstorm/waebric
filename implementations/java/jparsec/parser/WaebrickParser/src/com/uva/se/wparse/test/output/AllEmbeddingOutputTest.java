package com.uva.se.wparse.test.output;

import com.uva.se.wparse.model.module.ModuleDef;
import com.uva.se.wparse.output.transformer.OutputTransformer;
import com.uva.se.wparse.parser.ModuleParser;

import junit.framework.TestCase;

public class AllEmbeddingOutputTest extends TestCase {
	

	// embedding

	// expression embedding
	public static final String INPUTTEST_EXPRESSION_EMBEDDING = "module test def main() echo \"<b \"bold\">\"; end";
	public static final String OUTPUTTEST_EXPRESSION_EMBEDDING = "module(module-id([\"test\"]),[def(\"main\",formals([]),[echo-embedding(pre(\"\\\"\\\\\\\"<\",exp-embedding([tag(\"b\",[])],text(\"\\\"bold\\\"\")),post(\">\\\\\\\"\\\"\")))])])";

	// markup embedding
	public static final String INPUTTEST_MARKUP_EMBEDDING = "module test def main() echo \"<b() i()>\"; end";
	public static final String OUTPUTTEST_MARKUP_EMBEDDING = "module(module-id([\"test\"]),[def(\"main\",formals([]),[echo-embedding(pre(\"\\\"\\\\\\\"<\",markup-embedding([call(tag(\"b\",[]),args([]))],call(tag(\"i\",[]),args([]))),post(\">\\\\\\\"\\\"\")))])])";
	
	public String getModuleParserOutput(String WaebricSource){
		ModuleParser declarationParser = new ModuleParser(); 		
		ModuleDef moduleDef = declarationParser.parse(WaebricSource);
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
