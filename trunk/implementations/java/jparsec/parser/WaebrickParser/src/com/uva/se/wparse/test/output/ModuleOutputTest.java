/*
 * File			: ModuleOutputTest.java
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
import com.uva.se.wparse.parser.ModuleParser;
import com.uva.se.wparse.output.transformer.OutputTransformer;

import junit.framework.TestCase;

public class ModuleOutputTest extends TestCase {
	
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
	
	public void testEmptyModuleOutput(){
		String source = "module myModule";
		String expectedOutput = "module(module-id([\"myModule\"]),[])";
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}	
	
	public void testModuleWithOneImportOutput(){
		String source = "module myModule import myImport";
		String expectedOutput = "module(module-id([\"myModule\"]),[import(module-id([\"myImport\"]))])";		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testModuleWithTwoImportsOutput(){
		String source = "module myModule import myImport1 import myImport2";
		String expectedOutput = "module(module-id([\"myModule\"]),[import(module-id([\"myImport1\"])),import(module-id([\"myImport2\"]))])"; 
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testModuleWithFunctionOutput(){
		String source = "module myModule def myDef() end";
		String expectedOutput = "module(module-id([\"myModule\"]),[def(\"myDef\",formals([]),[])])"; 
		assertEquals(expectedOutput, getModuleParserOutput(source));		
	}
	
	public void testModuleWithMethodParameterOutput(){
		String source = "module myModule def myDef(param1) end";
		String expectedOutput = "module(module-id([\"myModule\"]),[def(\"myDef\",formals([\"param1\"]),[])])"; 
		assertEquals(expectedOutput, getModuleParserOutput(source));		
	}
	
	public void testModuleWithTwoMethodsOutput(){
		String source = "module myModule def my-2-Def() end def mydef-2() end";
		String expectedOutput = "module(module-id([\"myModule\"]),[def(\"my-2-Def\",formals([]),[]),def(\"mydef-2\",formals([]),[])])"; 
		assertEquals(expectedOutput, getModuleParserOutput(source));		
	}

	public void testModuleWithEmptySiteOutput(){
		String source = "module myModule site end";
		String expectedOutput = "module(module-id([\"myModule\"]),[site([])])"; 
		assertEquals(expectedOutput, getModuleParserOutput(source));		
	}
	
	public void testModuleWithSingleSiteOutput(){
		String source = "module myModule site wpath1/xpath2/yfile.ext : idCon#desgn() end";
		String expectedOutput = "module(module-id([\"myModule\"]),[site([mapping(path(\"wpath1/xpath2\",\"yfile.ext\"),call(tag(\"idCon\",[id(\"desgn\")]),args([])))])])"; 
		assertEquals(expectedOutput, getModuleParserOutput(source));		
	}	
	
	public void testModuleWithTwoSitesOutput(){
		String source = "module myModule  site wpath1/xpath2/yfile.ext : site1() ; wpath1/xpath2/yfile.ext : site2() end";
		String expectedOutput = "module(module-id([\"myModule\"]),[site([mapping(path(\"wpath1/xpath2\",\"yfile.ext\"),call(tag(\"site1\",[]),args([]))),mapping(path(\"wpath1/xpath2\",\"yfile.ext\"),call(tag(\"site2\",[]),args([])))])])"; 
		assertEquals(expectedOutput, getModuleParserOutput(source));		
	}	
	
	public void testModuleWithImportSiteAndFunctionOutput(){
		String source = "module myModule import package.package2.utils site wpath1/xpath2/yfile.ext : idCon#desgn() end def myMethod() end";
		String expectedOutput = "module(module-id([\"myModule\"]),[import(module-id([\"package\",\"package2\",\"utils\"])),site([mapping(path(\"wpath1/xpath2\",\"yfile.ext\"),call(tag(\"idCon\",[id(\"desgn\")]),args([])))]),def(\"myMethod\",formals([]),[])])"; 
		assertEquals(expectedOutput, getModuleParserOutput(source));		
	}
	
	public void testModuleWithSiteFunctionAndParametersOutput(){
		String source = "module myModule site wpath1/xpath2/yfile.ext : idCon#desgn() end def myMethod(param1, param2) end";
		String expectedOutput = "module(module-id([\"myModule\"]),[site([mapping(path(\"wpath1/xpath2\",\"yfile.ext\"),call(tag(\"idCon\",[id(\"desgn\")]),args([])))]),def(\"myMethod\",formals([\"param1\",\"param2\"]),[])])"; 
		assertEquals(expectedOutput, getModuleParserOutput(source));		
	}	
	
	public void testModuleWithSiteOutput(){
		String source = "module abon site site/abonnementen.html: abonnementen() end";
		String expectedOutput = "module(module-id([\"abon\"]),[site([mapping(path(\"site\",\"abonnementen.html\"),call(tag(\"abonnementen\",[]),args([])))])])"; 
		assertEquals(expectedOutput, getModuleParserOutput(source));		
	}	
	
	public void testModuleWithFunctionAndMarkupOutput(){
		String source = "module brand def func1() header(\"Abonnee worden?\"); end";
		String expectedOutput = "module(module-id([\"brand\"]),[def(\"func1\",formals([]),[markup(call(tag(\"header\",[]),args([text(\"\\\"Abonnee worden?\\\"\")])))])])"; 
		assertEquals(expectedOutput, getModuleParserOutput(source));		
	}	
	
	public void testModulWithFunctionAndSingleMarkupOutput(){
		String source = "module brand def func1() brandende-pen-500-test-pers; end";
		String expectedOutput = "module(module-id([\"brand\"]),[def(\"func1\",formals([]),[markup(tag(\"brandende-pen-500-test-pers\",[]))])])"; 
		assertEquals(expectedOutput, getModuleParserOutput(source));		
	}
	
	public void testModulWithFunctionNameWithDashOutput(){
		String source = "module brand def func1-name-500-func() end"; 
		String expectedOutput = "module(module-id([\"brand\"]),[def(\"func1-name-500-func\",formals([]),[])])"; 
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}	
	
	
	
	
}
