/*
 * File			: AllPredicateOutputTest.java
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
public class AllPredicateOutputTest extends TestCase {

	// predicate

	// is-a
	public static final String INPUTTEST_PREDICATE_IS_A_LIST = "module test def main(item) if (item.list?) li menu(item); end";
	public static final String OUTPUTTEST_PREDICATE_IS_A_LIST = "module(module-id([\"test\"]),[def(\"main\",formals([\"item\"]),[if(is-a(var(\"item\"),list-type),markup-markup([tag(\"li\",[])],call(tag(\"menu\",[]),args([var(\"item\")]))),appl(prod([],cf(sort(\"NoElseMayFollow\")),no-attrs),[]))])])";

	public static final String INPUTTEST_PREDICATE_IS_A_RECORD = "module test def main(item) if (item.record?) li menu(item); end";
	public static final String OUTPUTTEST_PREDICATE_IS_A_RECORD = "module(module-id([\"test\"]),[def(\"main\",formals([\"item\"]),[if(is-a(var(\"item\"),record-type),markup-markup([tag(\"li\",[])],call(tag(\"menu\",[]),args([var(\"item\")]))),appl(prod([],cf(sort(\"NoElseMayFollow\")),no-attrs),[]))])])";

	public static final String INPUTTEST_PREDICATE_IS_A_STRING = "module test def main(item) if (item.string?) li menu(item); end";
	public static final String OUTPUTTEST_PREDICATE_IS_A_STRING = "module(module-id([\"test\"]),[def(\"main\",formals([\"item\"]),[if(is-a(var(\"item\"),string-type),markup-markup([tag(\"li\",[])],call(tag(\"menu\",[]),args([var(\"item\")]))),appl(prod([],cf(sort(\"NoElseMayFollow\")),no-attrs),[]))])])";

	// and
	public static final String INPUTTEST_PREDICATE_AND = "module test def main(item1, item2) if (item1.string? && item2.string?) li menu(item1, item2); end";
	public static final String OUTPUTTEST_PREDICATE_AND = "module(module-id([\"test\"]),[def(\"main\",formals([\"item1\",\"item2\"]),[if(and(is-a(var(\"item1\"),string-type),is-a(var(\"item2\"),string-type)),markup-markup([tag(\"li\",[])],call(tag(\"menu\",[]),args([var(\"item1\"),var(\"item2\")]))),appl(prod([],cf(sort(\"NoElseMayFollow\")),no-attrs),[]))])])";

	// or
	public static final String INPUTTEST_PREDICATE_OR = "module test def main(item1, item2) if (item1.string? || item2.string?) li menu(item1, item2); end";
	public static final String OUTPUTTEST_PREDICATE_OR = "module(module-id([\"test\"]),[def(\"main\",formals([\"item1\",\"item2\"]),[if(or(is-a(var(\"item1\"),string-type),is-a(var(\"item2\"),string-type)),markup-markup([tag(\"li\",[])],call(tag(\"menu\",[]),args([var(\"item1\"),var(\"item2\")]))),appl(prod([],cf(sort(\"NoElseMayFollow\")),no-attrs),[]))])])";

	// not
	public static final String INPUTTEST_PREDICATE_NOT = "module test def main(item) if (!item.string?) li menu(item); end";
	public static final String OUTPUTTEST_PREDICATE_NOT = "module(module-id([\"test\"]),[def(\"main\",formals([\"item\"]),[if(not(is-a(var(\"item\"),string-type)),markup-markup([tag(\"li\",[])],call(tag(\"menu\",[]),args([var(\"item\")]))),appl(prod([],cf(sort(\"NoElseMayFollow\")),no-attrs),[]))])])";
	
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
	
	public void testPredicateIsAListOutput(){
		String source = INPUTTEST_PREDICATE_IS_A_LIST;		
		String expectedOutput = OUTPUTTEST_PREDICATE_IS_A_LIST;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testPredicateIsARecordOutput(){
		String source = INPUTTEST_PREDICATE_IS_A_RECORD;		
		String expectedOutput = OUTPUTTEST_PREDICATE_IS_A_RECORD;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testPredicateIsAStringOutput(){
		String source = INPUTTEST_PREDICATE_IS_A_STRING;		
		String expectedOutput = OUTPUTTEST_PREDICATE_IS_A_STRING;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}	
	
	public void testPredicateAndOutput(){
		String source = INPUTTEST_PREDICATE_AND;		
		String expectedOutput = OUTPUTTEST_PREDICATE_AND;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testPredicateOrOutput(){
		String source = INPUTTEST_PREDICATE_OR;		
		String expectedOutput = OUTPUTTEST_PREDICATE_OR;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testPredicateNotOutput(){
		String source = INPUTTEST_PREDICATE_NOT;		
		String expectedOutput = OUTPUTTEST_PREDICATE_NOT;		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
}
