/*
 * File			: DeclarationParserTest.java
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

import java.util.regex.Pattern;

import junit.framework.TestCase;

import com.uva.se.wparse.model.module.ModuleDef;
import com.uva.se.wparse.parser.DeclarationParser;

public class DeclarationParserTest extends TestCase {

	

	
	protected void setUp() throws Exception {
		super.setUp();


	}

	protected void tearDown() throws Exception {
		super.tearDown();

	}
	
	public void testEmptyModule(){
		String source = "module myModule";
		DeclarationParser declarationParser = new DeclarationParser();
		ModuleDef md = declarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModuleWith2Imports(){
		String source = "module myModule import myImport1 import myImport2";
		DeclarationParser declarationParser = new DeclarationParser(); 		
		ModuleDef md = declarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModuleWithMethod(){
		String source = "module myModule def myDef() end";
		DeclarationParser declarationParser = new DeclarationParser(); 		
		ModuleDef md = declarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModuleWithMethodParameter(){
		String source = "module myModule def myDef(\"param1\") end";
		DeclarationParser declarationParser = new DeclarationParser(); 		
		ModuleDef md = declarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModuleWith2Methods(){
		String source = "module myModule def myDef end def mydef2() end";
		DeclarationParser declarationParser = new DeclarationParser(); 		
		ModuleDef md = declarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModuleWithEmptySite(){
		String source = "module myModule \n site \n end"; 
		DeclarationParser declarationParser = new DeclarationParser(); 		
		ModuleDef md = declarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModuleWithSite(){
		String source = "module myModule \n site wpath1/xpath2/yfile.ext : idCon#desgn() \n end"; 
		DeclarationParser declarationParser = new DeclarationParser(); 		
		ModuleDef md = declarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModuleWithSiteAndMethod(){
		String source = "module myModule site wpath1/xpath2/yfile.ext : idCon#desgn() end def myMethod() end"; 
		DeclarationParser declarationParser = new DeclarationParser(); 		
		ModuleDef md = declarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModuleWithImportAndSiteAndMethod(){
		String source = "module myModule import package.package2.utils site wpath1/xpath2/yfile.ext : idCon#desgn() end def myMethod() end"; 
		DeclarationParser declarationParser = new DeclarationParser(); 		
		ModuleDef md = declarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModuleWithSiteAndMethodWithParameters(){
		String source = "module myModule site wpath1/xpath2/yfile.ext : idCon#desgn() end def myMethod(param1, param2) end"; 
		DeclarationParser declarationParser = new DeclarationParser(); 		
		ModuleDef md = declarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModulWithSite(){
		String source = "module abon site site2/abonnementen.html: abonnementen() end"; 
		DeclarationParser declarationParser = new DeclarationParser(); 		
		ModuleDef md = declarationParser.parse(source);
		assertNotNull(md);
	}
	
	
	public void testModulWithFunctionAndMarkup(){
		String source = "module brand def func1 header(\"Abonnee worden?\"); end"; 
		DeclarationParser declarationParser = new DeclarationParser(); 		
		ModuleDef md = declarationParser.parse(source);
		assertNotNull(md);
	}
	
	
	public void testModulWithFunctionAndSingleMarkup(){
		String source = "module brand def func1 brandende-pen-500-test-pers; end"; 
		DeclarationParser declarationParser = new DeclarationParser(); 		
		ModuleDef md = declarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModulWithFunctionNameWithDash(){
		String source = "module brand def func1-name-500-func end"; 
		DeclarationParser declarationParser = new DeclarationParser(); 		
		ModuleDef md = declarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testRegexp(){
		boolean b = Pattern.matches("^[A-Za-z][A-Za-z\\-0-9]*", "Test122-blaat");
		assertTrue(b);
	}
	
	
	
	
	
	


}
