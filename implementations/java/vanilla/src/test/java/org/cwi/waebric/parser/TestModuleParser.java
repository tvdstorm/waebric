package org.cwi.waebric.parser;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.cwi.waebric.parser.ast.module.Import;
import org.cwi.waebric.parser.ast.module.Module;
import org.cwi.waebric.parser.ast.module.ModuleId;
import org.cwi.waebric.parser.ast.module.Modules;
import org.cwi.waebric.TestUtilities;
import org.cwi.waebric.scanner.token.TokenIterator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestModuleParser {
	
	private ModuleParser parser;
	
	private List<SyntaxException> exceptions;
	private TokenIterator iterator;
	
	@Before
	public void setUp() {
		exceptions = new ArrayList<SyntaxException>();
	}
	
	@After
	public void tearDown() {
		exceptions.clear();
		exceptions = null;
		parser = null;
		iterator = null;
	}
	
	@Test
	public void testModuleId() throws SyntaxException {
		iterator = TestUtilities.quickScan("org.cwi.waebric.mymodule");
		parser = new ModuleParser(iterator, exceptions);
		
		ModuleId moduleId = parser.parseModuleId();
		
		// Assertions
		assertEquals(7, moduleId.getChildren().length); // Four elements and three period separators
		assertEquals("org", moduleId.get(0).getToken().getLexeme().toString());
		assertEquals("cwi", moduleId.get(1).getToken().getLexeme().toString());
		assertEquals("waebric", moduleId.get(2).getToken().getLexeme().toString());
		assertEquals("mymodule", moduleId.get(3).getToken().getLexeme().toString());
	}
	
	@Test
	public void testModules() throws SyntaxException {
		iterator = TestUtilities.quickScan("module mymodule1\nmodule mymodule2");
		parser = new ModuleParser(iterator, exceptions);
		
		Modules modules = parser.parseModules();
		
		// Assertions
		assertEquals(2, modules.size());
		assertEquals(Module.class, modules.getChildren()[0].getClass());
		assertEquals(Module.class, modules.getChildren()[1].getClass());
	}
	
	@Test
	public void testModule() throws SyntaxException {
		iterator = TestUtilities.quickScan("module mymodule\nimport src.test.waebric.helloworld\nsite\n\tindex.html: home(1)\nend\ndef home\nend");
		parser = new ModuleParser(iterator, exceptions);
		
		Module module = parser.parseModule();
		
		// Assertions
		assertEquals("module", module.getChildren()[0].toString());
		assertEquals(ModuleId.class, module.getChildren()[1].getClass());
		assertEquals(1, module.getImports().size());
		assertEquals(1, module.getSites().size());
		assertEquals(1, module.getFunctionDefinitions().size());
	}
	
	@Test
	public void testImport() throws SyntaxException {
		iterator = TestUtilities.quickScan("org.cwi.waebric.mymodule");
		parser = new ModuleParser(iterator, exceptions);
		
		Import imprt = parser.parseImport();
		
		// Assertions
		assertEquals("import", imprt.getChildren()[0].toString());
		assertEquals(ModuleId.class, imprt.getChildren()[1].getClass());
	}

}