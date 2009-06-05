package com.uva.se.wparse.test.output;

import com.uva.se.wparse.model.module.ModuleDef;
import com.uva.se.wparse.output.transformer.OutputTransformer;
import com.uva.se.wparse.parser.ModuleParser;

import junit.framework.TestCase;

public class AllMarkupOutputTest extends TestCase {
	// markup

	// markup
	public static final String INPUTTEST_MARKUP_TAG = "module test def main() br; end";
	public static final String OUTPUTTEST_MARKUP_TAG = "module(module-id([\"test\"]),[def(\"main\",formals([]),[markup(tag(\"br\",[]))])])";

	public static final String INPUTTEST_MARKUP_CALL_TAG = "module test def main() br(); end";
	public static final String OUTPUTTEST_MARKUP_CALL_TAG = "module(module-id([\"test\"]),[def(\"main\",formals([]),[markup(call(tag(\"br\",[]),args([])))])])";

	// markup statement
	public static final String INPUTTEST_MARKUP_STATEMENT_TAG = "module test def main() br yield; end";
	public static final String OUTPUTTEST_MARKUP_STATEMENT_TAG = "module(module-id([\"test\"]),[def(\"main\",formals([]),[markup-stat([tag(\"br\",[])],yield)])])";

	public static final String INPUTTEST_MARKUP_STATEMENT_CALL_TAG = "module test def main() br() yield; end";
	public static final String OUTPUTTEST_MARKUP_STATEMENT_CALL_TAG = "module(module-id([\"test\"]),[def(\"main\",formals([]),[markup-stat([call(tag(\"br\",[]),args([]))],yield)])])";

	// markup markup
	public static final String INPUTTEST_MARKUP_MARKUP_TAG = "module test def main() b br(); end";
	public static final String OUTPUTTEST_MARKUP_MARKUP_TAG = "module(module-id([\"test\"]),[def(\"main\",formals([]),[markup-markup([tag(\"b\",[])],call(tag(\"br\",[]),args([])))])])";

	public static final String INPUTTEST_MARKUP_MARKUP_CALL_TAG = "module test def main() b() br(); end";
	public static final String OUTPUTTEST_MARKUP_MARKUP_CALL_TAG = "module(module-id([\"test\"]),[def(\"main\",formals([]),[markup-markup([call(tag(\"b\",[]),args([]))],call(tag(\"br\",[]),args([])))])])";
	
	public static final String INPUTTEST_MARKUP_MARKUP_MULTIPLE = "module test def main() li ul() menu(); end";
	public static final String OUTPUTTEST_MARKUP_MARKUP_MULTIPLE = "module(module-id([\"test\"]),[def(\"main\",formals([]),[markup-markup([tag(\"li\",[]),call(tag(\"ul\",[]),args([]))],call(tag(\"menu\",[]),args([])))])])";

	// markup expression
	public static final String INPUTTEST_MARKUP_EXPRESSION_TAG = "module test def main() b \"blaat\"; end";
	public static final String OUTPUTTEST_MARKUP_EXPRESSION_TAG = "module(module-id([\"test\"]),[def(\"main\",formals([]),[markup-exp([tag(\"b\",[])],text(\"\\\"blaat\\\"\"))])])";

	public static final String INPUTTEST_MARKUP_EXPRESSION_CALL_TAG = "module test def main() b() \"blaat\"; end";
	public static final String OUTPUTTEST_MARKUP_EXPRESSION_CALL_TAG = "module(module-id([\"test\"]),[def(\"main\",formals([]),[markup-exp([call(tag(\"b\",[]),args([]))],text(\"\\\"blaat\\\"\"))])])";

	// markup embedding
	public static final String INPUTTEST_MARKUP_EMBEDDING_TAG = "module test def main() b \"<i \"bold\">\"; end";
	public static final String OUTPUTTEST_MARKUP_EMBEDDING_TAG = "module(module-id([\"test\"]),[def(\"main\",formals([]),[markup-embedding([tag(\"b\",[])],pre(\"\\\"<\",exp-embedding([tag(\"i\",[])],text(\"\\\"bold\\\"\")),post(\">\\\"\")))])])";

	public static final String INPUTTEST_MARKUP_EMBEDDING_CALL_TAG = "module test def main() b() \"<i \"bold\">\"; end";
	public static final String OUTPUTTEST_MARKUP_EMBEDDING_CALL_TAG = "module(module-id([\"test\"]),[def(\"main\",formals([]),[markup-embedding([call(tag(\"b\",[]),args([]))],pre(\"\\\"<\",exp-embedding([tag(\"i\",[])],text(\"\\\"bold\\\"\")),post(\">\\\"\")))])])";

	public String getModuleParserOutput(String WaebricSource){
		ModuleParser declarationParser = new ModuleParser(); 		
		ModuleDef moduleDef = declarationParser.parse(WaebricSource);
		OutputTransformer outputTransformer = new OutputTransformer();
		return outputTransformer.transform(moduleDef);
	}
	
	public void testMarkupTagOutput(){
		String source = INPUTTEST_MARKUP_TAG;		
		String expectedOutput = OUTPUTTEST_MARKUP_TAG;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}

	public void testMarkupCallTagOutput(){
		String source = INPUTTEST_MARKUP_CALL_TAG;		
		String expectedOutput = OUTPUTTEST_MARKUP_CALL_TAG;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testMarkupStatementTagOutput(){
		String source = INPUTTEST_MARKUP_STATEMENT_TAG;		
		String expectedOutput = OUTPUTTEST_MARKUP_STATEMENT_TAG;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}

	public void testMarkupStatementCallTagOutput(){
		String source = INPUTTEST_MARKUP_STATEMENT_CALL_TAG;		
		String expectedOutput = OUTPUTTEST_MARKUP_STATEMENT_CALL_TAG;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testMarkupMarkupTagOutput(){
		String source = INPUTTEST_MARKUP_MARKUP_TAG;		
		String expectedOutput = OUTPUTTEST_MARKUP_MARKUP_TAG;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}

	public void testMarkupMarkupCallTagOutput(){
		String source = INPUTTEST_MARKUP_MARKUP_CALL_TAG;		
		String expectedOutput = OUTPUTTEST_MARKUP_MARKUP_CALL_TAG;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testMarkupMarkupMultipleOutput(){
		String source = INPUTTEST_MARKUP_MARKUP_MULTIPLE;		
		String expectedOutput = OUTPUTTEST_MARKUP_MARKUP_MULTIPLE;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testMarkupExpressionTagOutput(){
		String source = INPUTTEST_MARKUP_EXPRESSION_TAG;		
		String expectedOutput = OUTPUTTEST_MARKUP_EXPRESSION_TAG;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}

	public void testMarkupExpressionCallTagOutput(){
		String source = INPUTTEST_MARKUP_EXPRESSION_CALL_TAG;		
		String expectedOutput = OUTPUTTEST_MARKUP_EXPRESSION_CALL_TAG;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testMarkupEmbeddingTagOutput(){
		String source = INPUTTEST_MARKUP_EMBEDDING_TAG;		
		String expectedOutput = OUTPUTTEST_MARKUP_EMBEDDING_TAG;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}

	public void testMarkupEmbeddingCallTagOutput(){
		String source = INPUTTEST_MARKUP_EMBEDDING_CALL_TAG;		
		String expectedOutput = OUTPUTTEST_MARKUP_EMBEDDING_CALL_TAG;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
}
