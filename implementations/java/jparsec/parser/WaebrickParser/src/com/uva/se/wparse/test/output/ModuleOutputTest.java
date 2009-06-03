package com.uva.se.wparse.test.output;

import com.uva.se.wparse.model.module.ModuleDef;
import com.uva.se.wparse.parser.ModuleParser;
import com.uva.se.wparse.output.transformer.OutputTransformer;

import junit.framework.TestCase;

public class ModuleOutputTest extends TestCase {
	
	public String getModuleParserOutput(String WaebricSource){
		ModuleParser declarationParser = new ModuleParser(); 		
		ModuleDef moduleDef = declarationParser.parse(WaebricSource);
		OutputTransformer outputTransformer = new OutputTransformer();
		return outputTransformer.transform(moduleDef);
	}	
	
	public void testEmptyModuleOutput(){
		String source = "module myModule";
		String expectedOutput = "module(module-id([\"myModule\"]),empty)";
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}	
	
	public void testModuleWithOneImportOutput(){
		String source = "module myModule import myImport";
		String expectedOutput = "module(module-id([\"myModule\"]),[import(\"myImport\")])";		
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testModuleWithTwoImportsOutput(){
		String source = "module myModule import myImport1 import myImport2";
		String expectedOutput = "module(module-id([\"myModule\"]),[import(\"myImport1\"),import(\"myImport2\")])"; 
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}
	
	public void testModuleWithFunctionOutput(){
		String source = "module myModule def myDef() end";
		String expectedOutput = "module(module-id([\"myModule\"]),[def(\"myDef\",formals([]),[])])"; 
		assertEquals(expectedOutput, getModuleParserOutput(source));		
	}
	
	public void testModuleWithMethodParameterOutput(){
		String source = "module myModule def myDef(param1) end";
		String expectedOutput = "module(module-id([\"myModule\"]),[def(\"myDef\",formals([\"param1\"]),empty)])"; 
		assertEquals(expectedOutput, getModuleParserOutput(source));		
	}
	
	public void testModuleWithTwoMethodsOutput(){
		String source = "module myModule def my-2-Def end def mydef-2() end";
		String expectedOutput = "module(module-id([\"myModule\"]),[def(\"my-2-Def\",empty,empty),def(\"mydef-2\",empty,empty)])"; 
		assertEquals(expectedOutput, getModuleParserOutput(source));		
	}

	public void testModuleWithEmptySiteOutput(){
		String source = "module myModule site end";
		String expectedOutput = "module(module-id([\"myModule\"]),[site(empty)])"; 
		assertEquals(expectedOutput, getModuleParserOutput(source));		
	}
	
/*	public void testModuleWithSiteOutput(){
		String source = "module myModule site wpath1/xpath2/yfile.ext : idCon#desgn() end";
		String expectedOutput = "module(module-id([\"myModule\"]),[site(mapping([\"wpath1/xpath2/yfile.ext\", ]))])"; 
		assertEquals(expectedOutput, getModuleParserOutput(source));		
	}	*/
	
	public void testModuleWithTwoSitesOutput(){
		String source = "module myModule  site wpath1/xpath2/yfile.ext : site1() ; wpath1/xpath2/yfile.ext : site2() end";
		String expectedOutput = "module(module-id([\"myModule\"]),[site([mapping(\"wpath1/xpath2/yfile.ext\",call(tag(\"site1\")))]),site([mapping(\"wpath1/xpath2/yfile.ext\",call(tag(\"site2\")))])])"; 
		assertEquals(expectedOutput, getModuleParserOutput(source));		
	}	
	
	public void testModuleWithImportSiteAndFunctionOutput(){
		String source = "module myModule import package.package2.utils site wpath1/xpath2/yfile.ext : idCon#desgn() end def myMethod() end";
		String expectedOutput = "module(module-id([\"myModule\"]),[import(\"package.package2.utils\"),site([mapping(\"wpath1/xpath2/yfile.ext\",args([attr(\"id\",text(\"desgn\"))])))]),def(\"myMethod\",empty,empty)])"; 
		assertEquals(expectedOutput, getModuleParserOutput(source));		
	}
	
	public void testModuleWithSiteFunctionAndParametersOutput(){
		String source = "module myModule site wpath1/xpath2/yfile.ext : idCon#desgn() end def myMethod(param1, param2) end";
		String expectedOutput = "module(module-id([\"myModule\"]),[site([mapping(\"wpath1/xpath2/yfile.ext\",args([attr(\"id\",text(\"desgn\"))]))]),def(\"myMethod\",formals([\"param1\",\"param2\"]),empty)])"; 
		assertEquals(expectedOutput, getModuleParserOutput(source));		
	}	
	
	public void testModuleWithSiteOutput(){
		String source = "module abon site site/abonnementen.html: abonnementen() end";
		String expectedOutput = "module(module-id([\"abon\"]),[site([mapping(\"site/abonnementen.html\", call(tag(\"abonnementen\")))])])"; 
		assertEquals(expectedOutput, getModuleParserOutput(source));		
	}	
	
	public void testModuleWithFunctionAndMarkupOutput(){
		String source = "module brand def func1 header(\"Abonnee worden?\"); end";
		String expectedOutput = "module(module-id([\"brand\"]),[def(\"func1\",empty,[markup(call(tag(\"header\",[]),args([text(\"Abonnee worden?\")])))])])"; 
		assertEquals(expectedOutput, getModuleParserOutput(source));		
	}	
	
	public void testModulWithFunctionAndSingleMarkupOutput(){
		String source = "module brand def func1 brandende-pen-500-test-pers; end";
		String expectedOutput = "module(module-id([\"brand\"]),[def(\"func1\",empty,[markup-stat([header(text(\"brandende-pen-500-test-pers\"))])])])"; 
		assertEquals(expectedOutput, getModuleParserOutput(source));		
	}
	
	public void testModulWithFunctionNameWithDashOutput(){
		String source = "module brand def func1-name-500-func end"; 
		String expectedOutput = "module(module-id([\"brand\"]),[def(\"func1-name-500-func\",empty,empty)])"; 
		assertEquals(expectedOutput, getModuleParserOutput(source));
	}	
	
	
	
	
}
