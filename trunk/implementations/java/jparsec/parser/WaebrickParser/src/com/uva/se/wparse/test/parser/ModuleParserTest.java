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

import junit.framework.TestCase;

import com.uva.se.wparse.model.module.ModuleDef;
import com.uva.se.wparse.parser.ModuleParser;

public class ModuleParserTest extends TestCase {

	

	
	protected void setUp() throws Exception {
		super.setUp();


	}

	protected void tearDown() throws Exception {
		super.tearDown();

	}
	
	public void testEmptyModule(){
		String source = "module myModule";
		ModuleParser declarationParser = new ModuleParser();
		ModuleDef md = declarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModuleWith2Imports(){
		String source = "module myModule import myImport1 import myImport2";
		ModuleParser declarationParser = new ModuleParser(); 		
		ModuleDef md = declarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModuleWithMethod(){
		String source = "module myModule def myDef() end";
		ModuleParser declarationParser = new ModuleParser(); 		
		ModuleDef md = declarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModuleWithMethodParameter(){
		String source = "module myModule def myDef(param1) end";
		ModuleParser declarationParser = new ModuleParser(); 		
		ModuleDef md = declarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModuleWith2Methods(){
		String source = "module myModule def my-2-Def() end def mydef-2() end";
		ModuleParser declarationParser = new ModuleParser(); 		
		ModuleDef md = declarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModuleWithEmptySite(){
		String source = "module myModule site end"; 
		ModuleParser declarationParser = new ModuleParser(); 		
		ModuleDef md = declarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModuleWithSite(){
		String source = "module myModule site wpath1/xpath2/yfile.ext : idCon#desgn() end"; 
		ModuleParser declarationParser = new ModuleParser(); 		
		ModuleDef md = declarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModuleWith2Sites(){
		String source = "module myModule  site wpath1/xpath2/yfile.ext : site1() ; wpath1/xpath2/yfile.ext : site2() end";
		ModuleParser declarationParser = new ModuleParser(); 		
		ModuleDef md = declarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModuleWithSiteAndMethod(){
		String source = "module myModule site wpath1/xpath2/yfile.ext : idCon#desgn() end def myMethod() end"; 
		ModuleParser declarationParser = new ModuleParser(); 		
		ModuleDef md = declarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModuleWithImportAndSiteAndMethod(){
		String source = "module myModule import package.package2.utils site wpath1/xpath2/yfile.ext : idCon#desgn() end def myMethod() end"; 
		ModuleParser declarationParser = new ModuleParser(); 		
		ModuleDef md = declarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModuleWithSiteAndMethodWithParameters(){
		String source = "module myModule site wpath1/xpath2/yfile.ext : idCon#desgn() end def myMethod(param1, param2) end"; 
		ModuleParser declarationParser = new ModuleParser(); 		
		ModuleDef md = declarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModulWithSite(){
		String source = "module abon site site/abonnementen.html: abonnementen() end"; 
		ModuleParser declarationParser = new ModuleParser(); 		
		ModuleDef md = declarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModulWithSiteMapping(){
		String source = "module abon site site/abonnementen.html: abonnementen() end"; 
		ModuleParser declarationParser = new ModuleParser(); 		
		ModuleDef md = declarationParser.parse(source);
		assertNotNull(md);
	}
	
	
	public void testModulWithFunctionAndMarkup(){
		String source = "module brand def func1() header(\"Abonnee worden?\"); end"; 
		ModuleParser declarationParser = new ModuleParser(); 		
		ModuleDef md = declarationParser.parse(source);
		assertNotNull(md);
	}
	
	
	public void testModulWithFunctionAndSingleMarkup(){
		String source = "module brand def func1() brandende-pen-500-test-pers; end"; 
		ModuleParser declarationParser = new ModuleParser(); 		
		ModuleDef md = declarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModulWithFunctionNameWithDash(){
		String source = "module brand def func1-name-500-func() end"; 
		ModuleParser declarationParser = new ModuleParser(); 		
		ModuleDef md = declarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModulWithFunctionAndIfElse(){
		String source = "module brand def item(mi) li if (mi.kids) menu(mi); else a(href=mi.link) mi.title; end"; 
		ModuleParser declarationParser = new ModuleParser(); 		
		ModuleDef md = declarationParser.parse(source);
		assertNotNull(md);
	}
	
	
	


}