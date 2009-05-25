package org.cwi.waebric.parser;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.cwi.waebric.parser.ast.expressions.Var;
import org.cwi.waebric.parser.ast.markup.Attribute;
import org.cwi.waebric.parser.ast.markup.Attribute.AttributeDoubleNatCon;
import org.cwi.waebric.parser.ast.markup.Attribute.AttributeIdCon;
import org.cwi.waebric.parser.ast.markup.Attribute.AttributeNatCon;
import org.cwi.waebric.parser.exception.ParserException;
import org.cwi.waebric.scanner.TestScanner;
import org.cwi.waebric.scanner.token.TokenIterator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMarkupParser {

	private MarkupParser parser;
	
	private List<ParserException> exceptions;
	private TokenIterator iterator;
	
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
	public void testMarkup() {
		// TODO
	}
	
	@Test
	public void testDesignator() {
		// TODO
	}
	
	@Test
	public void testAttributes() {
		// TODO
	}
	
	@Test
	public void testAttribute() {
		// Identifier attribute
		iterator = TestScanner.quickScan("#myattribute");
		parser = new MarkupParser(iterator, exceptions);
		
		AttributeIdCon attributei = new Attribute.AttributeIdCon('#');
		parser.visit(attributei);
		
		assertTrue(exceptions.size() == 0);
		assertTrue(attributei.getIdentifier().equals("myattribute"));
		
		// Regular natural attribute
		iterator = TestScanner.quickScan("@99");
		parser = new MarkupParser(iterator, exceptions);
		
		AttributeNatCon attributen = new Attribute.AttributeNatCon();
		parser.visit(attributen);
		
		assertTrue(exceptions.size() == 0);
		assertTrue(attributen.getNumber().equals(99));
		
		// Double natural attribute
		iterator = TestScanner.quickScan("@99%12");
		parser = new MarkupParser(iterator, exceptions);
		
		AttributeDoubleNatCon attributedn = new Attribute.AttributeDoubleNatCon();
		parser.visit(attributedn);
		
		assertTrue(exceptions.size() == 0);
		assertTrue(attributedn.getNumber().equals(99));
		assertTrue(attributedn.getSecondNumber().equals(12));
	}
	
	@Test
	public void testArguments() {
		// TODO
	}
	
	@Test
	public void testArgument() {
		// TODO		
	}
	
	@Test
	public void testVar() {
		iterator = TestScanner.quickScan("var1");
		parser = new MarkupParser(iterator, exceptions);
		
		Var var = new Var();
		parser.visit(var);
		
		// Assertions
		assertTrue(exceptions.size() == 0);
		assertTrue(var.getIdentifier().equals("var1"));
	}

}