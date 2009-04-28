/*
 * File			: DeclarationParserTest.java
 * Project		: WaebrickParser
 * 				: Practicum opdracht Software Construction
 * 
 * Authors		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * 
 * Description	:
 * 
 */
package com.uva.se.wparse.test.parser;

import junit.framework.TestCase;

import com.uva.se.wparse.model.declaration.ModuleDef;
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
		ModuleDef md = DeclarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModuleWith2Imports(){
		String source = "module myModule import myImport1 import myImport2";
		ModuleDef md = DeclarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModuleWithMethod(){
		String source = "module myModule def myDef end";
		ModuleDef md = DeclarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModuleWith2Methods(){
		String source = "module myModule def myDef end def mydef2() end";
		ModuleDef md = DeclarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModuleWithEmptySite(){
		String source = "module myModule \n site \n end"; 
		ModuleDef md = DeclarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModuleWithSite(){
		String source = "module myModule \n site wpath1/xpath2/yfile.ext : idCon#desgn() \n end"; 
		ModuleDef md = DeclarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModuleWithSiteAndMethod(){
		String source = "module myModule site wpath1/xpath2/yfile.ext : idCon#desgn() end def myMethod() end"; 
		ModuleDef md = DeclarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModuleWithImportAndSiteAndMethod(){
		String source = "module myModule import package.package2.utils site wpath1/xpath2/yfile.ext : idCon#desgn() end def myMethod() end"; 
		ModuleDef md = DeclarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModuleWithSiteAndMethodWithParameters(){
		String source = "module myModule site wpath1/xpath2/yfile.ext : idCon#desgn() end def myMethod(param1, param2) end"; 
		ModuleDef md = DeclarationParser.parse(source);
		assertNotNull(md);
	}
	
	public void testModule(){
		String source = "module abon site site2/abonnementen.html: abonnementen() end"; 
		ModuleDef md = DeclarationParser.parse(source);
		assertNotNull(md);
	}
	
	
	
	
	
	


}
