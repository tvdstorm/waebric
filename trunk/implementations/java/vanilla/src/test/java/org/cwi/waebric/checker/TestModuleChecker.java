package org.cwi.waebric.checker;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.cwi.waebric.ModuleRegister;
import org.cwi.waebric.TestUtilities;
import org.cwi.waebric.parser.ast.AbstractSyntaxTree;
import org.junit.After;
import org.junit.Test;

public class TestModuleChecker {
	
	private List<SemanticException> exceptions;
	private ModuleChecker checker;
	
	public TestModuleChecker() {
		exceptions = new ArrayList<SemanticException>();
		checker = new ModuleChecker(exceptions);
	}
	
	@After
	public void tearDown() {
		exceptions.clear();
		ModuleRegister.getInstance().clearCache();
	}

	@Test
	public void testInvalidImport() throws FileNotFoundException {
		AbstractSyntaxTree ast = TestUtilities.quickParse("src/test/waebric/mod/invalidimport.wae");
		checker.visit(ast.getRoot());
		assertEquals(1, exceptions.size());
		assertEquals(ModuleChecker.NonExistingModuleException.class, exceptions.get(0).getClass());
	}
	
	@Test
	public void testInfiniteImportLoop() throws FileNotFoundException {
		AbstractSyntaxTree ast = TestUtilities.quickParse("src/test/waebric/mod/selfloop.wae");
		checker.visit(ast.getRoot());
		assertEquals(0, exceptions.size()); // No faults
	}
	
}