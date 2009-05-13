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
		String source = "module myModule def myDef end";
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
	
	public void testModulWithSitee(){
		String source = "module abon site site2/abonnementen.html: abonnementen() end"; 
		DeclarationParser declarationParser = new DeclarationParser(); 		
		ModuleDef md = declarationParser.parse(source);
		assertNotNull(md);
	}
	
	
	
	
	
	


}
