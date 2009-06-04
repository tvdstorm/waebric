package org.cwi.waebric.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.cwi.waebric.parser.ast.markup.Markup;
import org.cwi.waebric.parser.ast.module.site.DirName;
import org.cwi.waebric.parser.ast.module.site.Directory;
import org.cwi.waebric.parser.ast.module.site.FileName;
import org.cwi.waebric.parser.ast.module.site.Mapping;
import org.cwi.waebric.parser.ast.module.site.Mappings;
import org.cwi.waebric.parser.ast.module.site.Path;
import org.cwi.waebric.parser.ast.module.site.Site;
import org.cwi.waebric.parser.exception.ParserException;
import org.cwi.waebric.scanner.TestScanner;
import org.cwi.waebric.scanner.token.WaebricTokenIterator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSiteParser {

	private SiteParser parser;
	
	private List<ParserException> exceptions;
	private WaebricTokenIterator iterator;
	
	@Before
	public void setUp() {
		exceptions = new ArrayList<ParserException>();
	}
	
	@After
	public void tearDown() {
		exceptions.clear();
		exceptions = null;
		parser = null;
		iterator = null;
	}
	
	@Test
	public void testSite() {
		iterator = TestScanner.quickScan("index1.html:function1(1);index2.html:function2 end");
		parser = new SiteParser(iterator, exceptions);
		
		Site site = parser.parseSite();
		assertEquals(0, exceptions.size());
		assertEquals(2, site.getMappings().size());
	}
	
	@Test
	public void testMappings() {
		iterator = TestScanner.quickScan("index1.html:function1(1);index2.html:function2");
		parser = new SiteParser(iterator, exceptions);
		
		Mappings mappings = parser.parseMappings();
		assertEquals(0, exceptions.size());
		assertEquals(2, mappings.size());
	}
	
	@Test
	public void testMapping() {
		Mapping mapping = null;
		
		// Path with directory, mapping with arguments
		iterator = TestScanner.quickScan("home/index.html: home(\"Hello world!\")");
		parser = new SiteParser(iterator, exceptions);
		
		mapping = parser.parseMapping();
		assertEquals(0, exceptions.size());
		assertTrue(mapping.getPath() instanceof Path.PathWithDir);
		assertTrue(mapping.getMarkup() instanceof Markup.MarkupWithArguments);
		
		// Path without directory, mapping without arguments
		iterator = TestScanner.quickScan("index.html: home");
		parser = new SiteParser(iterator, exceptions);
		
		mapping = parser.parseMapping();
		assertEquals(0, exceptions.size());
		assertTrue(mapping.getPath() instanceof Path.PathWithoutDir);
		assertTrue(mapping.getMarkup() instanceof Markup.MarkupWithoutArguments);
	}
	
	@Test
	public void testPath() {
		// Path with directory
		iterator = TestScanner.quickScan("org/cwi/waebric/java/vanilla/myfile.wae");
		parser = new SiteParser(iterator, exceptions);
		
		Path.PathWithDir pathdf = (Path.PathWithDir) parser.parsePath();
		assertTrue(exceptions.size() == 0);
		assertNotNull(pathdf.getDirName());
		assertNotNull(pathdf.getFileName());
		
		// Path without directory
		iterator = TestScanner.quickScan("myfile.wae");
		parser = new SiteParser(iterator, exceptions);
		
		Path.PathWithoutDir pathf = (Path.PathWithoutDir) parser.parsePath();
		assertEquals(0, exceptions.size());
		assertNotNull(pathf.getFileName());
	}
	
	@Test
	public void testDirName() {
		iterator = TestScanner.quickScan("org/cwi/waebric/java/vanilla");
		parser = new SiteParser(iterator, exceptions);
		
		DirName dirName = parser.parseDirName();
		assertEquals(0, exceptions.size());
		assertEquals(Directory.class, dirName.getDirectory().getClass());
	}

	@Test
	public void testFileName() {
		iterator = TestScanner.quickScan("myfile.wae");
		parser = new SiteParser(iterator, exceptions);
		
		FileName name = parser.parseFileName();
		assertEquals(0, exceptions.size());
		assertEquals("myfile", name.getName().toString());
		assertEquals("wae", name.getExt().toString());
	}
	
	@Test
	public void testDirectory() {
		iterator = TestScanner.quickScan("org/cwi/waebric/java/vanilla");
		parser = new SiteParser(iterator, exceptions);
		
		Directory directory = parser.parseDirectory();
		assertEquals(0, exceptions.size());
		assertEquals(5, directory.getElements().length);
		assertEquals("org", directory.getElements()[0].toString());
		assertEquals("cwi", directory.getElements()[1].toString());
		assertEquals("waebric", directory.getElements()[2].toString());
		assertEquals("java", directory.getElements()[3].toString());
		assertEquals("vanilla", directory.getElements()[4].toString());
	}
	
	@Test
	public void testIsPathElement() {
		assertTrue(SiteParser.isPathElement("directory"));
		assertTrue(SiteParser.isPathElement("directory123"));
		assertTrue(SiteParser.isPathElement("directory%20%123"));
		assertTrue(SiteParser.isPathElement("directory\123"));
		assertFalse(SiteParser.isPathElement("directory 123"));
		assertFalse(SiteParser.isPathElement("directory\t123"));
		assertFalse(SiteParser.isPathElement("directory\n123"));
		assertFalse(SiteParser.isPathElement("directory\t123"));
		assertFalse(SiteParser.isPathElement("directory.123"));
		assertFalse(SiteParser.isPathElement("directory/123"));
		assertFalse(SiteParser.isPathElement("directory\\123"));
	}

}