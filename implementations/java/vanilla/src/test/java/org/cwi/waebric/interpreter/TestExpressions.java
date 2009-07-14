package org.cwi.waebric.interpreter;

import static org.junit.Assert.assertEquals;

import org.cwi.waebric.parser.ast.basic.IdCon;
import org.cwi.waebric.parser.ast.basic.SymbolCon;
import org.cwi.waebric.parser.ast.expression.Expression;
import org.cwi.waebric.parser.ast.expression.KeyValuePair;
import org.jdom.Document;
import org.junit.Before;
import org.junit.Test;

public class TestExpressions {

	private JDOMVisitor visitor;
	private Document document;

	@Before
	public void setUp() {
		this.document = new Document();
		this.visitor = new JDOMVisitor(document);
	}
	
	@Test
	public void testTextExpression() {
		Expression.TextExpression expr = new Expression.TextExpression("success");
		expr.accept(visitor);
		assertEquals("success", visitor.getText());
	}
	
	@Test
	public void testVarExpression() {
		Expression.VarExpression expr = new Expression.VarExpression(new IdCon("var"));
		visitor.getEnvironment().defineVariable("var", new Expression.TextExpression("success"));
		expr.accept(visitor);
		assertEquals("success", visitor.getText());
	}
	
	@Test
	public void testSymbolExpression() {
		Expression.SymbolExpression expr = new Expression.SymbolExpression();
		expr.setSymbol(new SymbolCon("success"));
		expr.accept(visitor);
		assertEquals("success", visitor.getText());
	}
	
	@Test
	public void testNatExpression() {
		Expression.NatExpression expr = new Expression.NatExpression(1337);
		expr.accept(visitor);
		assertEquals("1337", visitor.getText());
	}
	
	/**
	 * Convert list expression to text, while interpreting elements special attention
	 * is spend on text and symbol expressions as these need to be surrounded by
	 * double quotes.<br><br>
	 * 
	 * <code>["success",1337,['symbol]]</code>
	 */
	@Test
	public void testListExpression() {
		Expression.ListExpression expr = new Expression.ListExpression();
		expr.addExpression(new Expression.TextExpression("success"));
		expr.addExpression(new Expression.NatExpression(1337));
		Expression.ListExpression sub = new Expression.ListExpression();
		sub.addExpression(new Expression.SymbolExpression(new SymbolCon("symbol")));
		expr.addExpression(sub);
		
		expr.accept(visitor);
		assertEquals("[\"success\",1337,[\"symbol\"]]", visitor.getText());
	}
	
	/**
	 * Convert record expression to text, while interpreting pairs special attention
	 * is spend on text and symbol expressions as these need to be surrounded by
	 * double quotes.<br><br>
	 * 
	 * <code>{text:"success",number:1337,list:[],record:{symbol:'symbol}}</code>
	 */
	@Test
	public void testRecordExpression() {
		Expression.RecordExpression expr = new Expression.RecordExpression();
		expr.addKeyValuePair(new KeyValuePair(new IdCon("text"), new Expression.TextExpression("success")));
		expr.addKeyValuePair(new KeyValuePair(new IdCon("number"), new Expression.NatExpression(1337)));
		expr.addKeyValuePair(new KeyValuePair(new IdCon("list"), new Expression.ListExpression()));
		Expression.RecordExpression sub = new Expression.RecordExpression();
		sub.addKeyValuePair(new KeyValuePair(new IdCon("symbol"), new Expression.SymbolExpression(new SymbolCon("symbol"))));
		expr.addKeyValuePair(new KeyValuePair(new IdCon("record"), sub));

		expr.accept(visitor);
		assertEquals("{text:\"success\",number:1337,list:[],record:{symbol:\"symbol\"}}", visitor.getText());
	}
	
	/**
	 * Convert cat expression into text.<br><br>
	 * 
	 * <code>"test" + "has" + "succeeded"<br> -> "test" + "hassucceeded"<br> -> "testhassucceeded"</code>
	 */
	@Test
	public void testCatExpression() {
		Expression.CatExpression expr = new Expression.CatExpression();
		expr.setLeft(new Expression.TextExpression("test"));
		Expression.CatExpression sub = new Expression.CatExpression();
		sub.setLeft(new Expression.TextExpression("has"));
		sub.setRight(new Expression.TextExpression("succeeded"));
		expr.setRight(sub);
		
		expr.accept(visitor);
		assertEquals("testhassucceeded", visitor.getText());
	}
	
	/**
	 * Create field <code>{test:"success"}.test</code> and verify the stored
	 * text value is indeed "success".
	 */
	@Test
	public void testField() {
		Expression.RecordExpression record = new Expression.RecordExpression();
		record.addKeyValuePair(new KeyValuePair(new IdCon("test"), new Expression.TextExpression("success")));
		
		Expression.Field field = new Expression.Field(record, new IdCon("test"));
		field.accept(visitor);
		assertEquals("success", visitor.getText());
	}
	
}