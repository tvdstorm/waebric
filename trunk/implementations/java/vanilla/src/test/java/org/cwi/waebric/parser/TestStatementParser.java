package org.cwi.waebric.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.cwi.waebric.parser.ast.AbstractSyntaxNodeList;
import org.cwi.waebric.parser.ast.expression.Expression;
import org.cwi.waebric.parser.ast.expression.Var;
import org.cwi.waebric.parser.ast.expression.Expression.NatExpression;
import org.cwi.waebric.parser.ast.markup.Markup;
import org.cwi.waebric.parser.ast.statement.Assignment;
import org.cwi.waebric.parser.ast.statement.Formals;
import org.cwi.waebric.parser.ast.statement.Statement;
import org.cwi.waebric.parser.ast.statement.Statement.*;
import org.cwi.waebric.parser.ast.statement.embedding.Embed;
import org.cwi.waebric.parser.ast.statement.predicate.Predicate;
import org.cwi.waebric.parser.exception.SyntaxException;
import org.cwi.waebric.scanner.TestScanner;
import org.cwi.waebric.scanner.token.WaebricToken;
import org.cwi.waebric.scanner.token.WaebricTokenIterator;
import org.cwi.waebric.scanner.token.WaebricTokenSort;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestStatementParser {

	private StatementParser parser;
	private AbstractSyntaxNodeList<Var> formals;
	
	private List<SyntaxException> exceptions;
	private WaebricTokenIterator iterator;
	
	@Before
	public void setUp() {
		exceptions = new ArrayList<SyntaxException>();
		formals = new Formals();
		formals.add(new Var("var"));
	}
	
	@After
	public void tearDown() {
		exceptions.clear();
		exceptions = null;
		parser = null;
		iterator = null;
	}
	
	@Test
	public void testFormals() throws SyntaxException {
		iterator = TestScanner.quickScan("(var1,var2)");
		parser = new StatementParser(iterator, exceptions);
		
		Formals formals = parser.parseFormals();
		assertEquals(2, formals.size());
		assertEquals("var1", formals.get(0).getIdentifier().getLiteral().toString());
		assertEquals("var2", formals.get(1).getIdentifier().getLiteral().toString());
	}
	
	@Test
	public void testVarAssignment() throws SyntaxException {
		iterator = TestScanner.quickScan("var=100");
		parser = new StatementParser(iterator, exceptions);
		
		Assignment.VarAssignment assignment = parser.parseVarAssignment();
		assertEquals("var", assignment.getVar().getIdentifier().getLiteral().toString());
		assertEquals(NatExpression.class, assignment.getExpression().getClass());
	}
	
	@Test
	public void testIdConAssignment() throws SyntaxException {
		iterator = TestScanner.quickScan("identifier1(var1,var2) = yield;");
		parser = new StatementParser(iterator, exceptions);
		
		Assignment.IdConAssignment assignment = parser.parseIdConAssignment(formals);
		assertEquals("identifier1", assignment.getIdentifier().getLiteral().toString());
		assertEquals(2, assignment.getFormals().size());
		assertEquals("var1", assignment.getFormals().get(0).getIdentifier().getLiteral().toString());
		assertEquals("var2", assignment.getFormals().get(1).getIdentifier().getLiteral().toString());
		assertEquals(Statement.YieldStatement.class, assignment.getStatement().getClass());
	}
	
	@Test
	public void testIfStatement() throws SyntaxException {
		iterator = TestScanner.quickScan("if(123) comment \"succes\"");
		parser = new StatementParser(iterator, exceptions);
		
		IfStatement statement = parser.parseIfStatement(formals);
		assertEquals(Predicate.ExpressionPredicate.class, statement.getPredicate().getClass());
		assertEquals(Statement.CommentStatement.class, statement.getStatement().getClass());
	}
	
	@Test
	public void testIfElseStatement() throws SyntaxException {
		iterator = TestScanner.quickScan("if(123) comment \"succes\" else yield;");
		parser = new StatementParser(iterator, exceptions);
		
		IfElseStatement statement = (IfElseStatement) parser.parseIfStatement(formals);
		assertEquals(Predicate.ExpressionPredicate.class, statement.getPredicate().getClass());
		assertEquals(Statement.CommentStatement.class, statement.getStatement().getClass());
		assertEquals(Statement.YieldStatement.class, statement.getElseStatement().getClass());
	}
	
	@Test
	public void testEchoEmbeddingStatement() throws SyntaxException {
		iterator = TestScanner.quickScan("echo \"<123>\";");
		parser = new StatementParser(iterator, exceptions);
		
		EchoEmbeddingStatement statement = parser.parseEchoEmbeddingStatement(formals);
		assertNotNull(statement.getEmbedding());
	}
	
	@Test
	public void testEchoExpressionStatement() throws SyntaxException {
		iterator = TestScanner.quickScan("echo 10;");
		parser = new StatementParser(iterator, exceptions);
		
		EchoExpressionStatement statement = parser.parseEchoExpressionStatement();
		assertEquals(Expression.NatExpression.class, statement.getExpression().getClass());
	}
	
	@Test
	public void testEachStatement() throws SyntaxException {
		iterator = TestScanner.quickScan("each(var1:10) comment \"test\"");
		parser = new StatementParser(iterator, exceptions);
		
		EachStatement statement = parser.parseEachStatement(formals);
		assertEquals("var1", statement.getVar().getIdentifier().getLiteral().toString());
		assertEquals(Expression.NatExpression.class, statement.getExpression().getClass());
		assertEquals(Statement.CommentStatement.class, statement.getStatement().getClass());
	}
	
	@Test
	public void testStatementCollection() throws SyntaxException {
		iterator = TestScanner.quickScan("{ yield; comment \"text\" markup1 markup2 var; }");
		parser = new StatementParser(iterator, exceptions);
		
		StatementCollection statement = parser.parseStatementCollection(formals);
		assertEquals(3, statement.getStatementCount());
		assertEquals(Statement.YieldStatement.class, statement.getStatement(0).getClass());
		assertEquals(Statement.CommentStatement.class, statement.getStatement(1).getClass());
		assertEquals(Statement.ExpressionMarkupsStatement.class, statement.getStatement(2).getClass());
	}
	
	@Test
	public void testLetStatement() throws SyntaxException {
		iterator = TestScanner.quickScan("let var=100 in comment \"test\" end");
		parser = new StatementParser(iterator, exceptions);
		
		LetStatement statement = parser.parseLetStatement(formals);
		assertEquals(1, statement.getAssignmentCount());
		assertEquals(Assignment.VarAssignment.class, statement.getAssignment(0).getClass());
		assertEquals(1, statement.getStatementCount());
		assertEquals(Statement.CommentStatement.class, statement.getStatement(0).getClass());
	}
	
	@Test
	public void testCDataStatement() throws SyntaxException {
		iterator = TestScanner.quickScan("cdata 10;");
		parser = new StatementParser(iterator, exceptions);
		
		CDataStatement statement = parser.parseCDataStatement();
		assertEquals(Expression.NatExpression.class, statement.getExpression().getClass());
	}
	
	@Test
	public void testCommentStatement() throws SyntaxException {
		iterator = TestScanner.quickScan("comment \"OH NOES TEH HAXZOR\";");
		parser = new StatementParser(iterator, exceptions);
		
		CommentStatement statement = parser.parseCommentStatement();
		assertEquals("OH NOES TEH HAXZOR", statement.getComment().getLiteral().toString());
	}
	
	@Test
	public void testYieldStatement() throws SyntaxException {
		iterator = TestScanner.quickScan("yield;");
		parser = new StatementParser(iterator, exceptions);
		
		parser.parseYieldStatement();
		assertEquals(0, exceptions.size());
	}
	
	@Test
	public void testMarkupStatement() throws SyntaxException {
		iterator = TestScanner.quickScan("func1;");
		parser = new StatementParser(iterator, exceptions);
		
		MarkupStatement statement = (MarkupStatement) parser.parseStatement(formals);
		assertEquals(Markup.MarkupWithoutArguments.class, statement.getMarkup().getClass());
	}
	
	@Test
	public void testIsMarkup() {
		assertTrue(StatementParser.isMarkup(new WaebricToken("func1", WaebricTokenSort.IDCON, 0, 0), formals)); // Markup
		assertFalse(StatementParser.isMarkup(new WaebricToken("var", WaebricTokenSort.IDCON, 0, 0), formals)); // Arg, part of formals
		assertFalse(StatementParser.isMarkup(new WaebricToken(123, WaebricTokenSort.NATCON, 0, 0), formals)); // Natural
	}
	
	@Test
	public void testExpressionMarkupsStatement() throws SyntaxException {
		// Natural expression (easy example)
		iterator = TestScanner.quickScan("func1 func2 123;");
		parser = new StatementParser(iterator, exceptions);
		
		ExpressionMarkupsStatement natstm = (ExpressionMarkupsStatement) parser.parseMarkupStatements(formals);
		assertEquals(2, natstm.getMarkupCount());
		assertEquals(Expression.NatExpression.class, natstm.getExpression().getClass());
		
		// Var expression (resembles mark-up)
		iterator = TestScanner.quickScan("func1 func2 var;");
		parser = new StatementParser(iterator, exceptions);
		
		ExpressionMarkupsStatement varstm = (ExpressionMarkupsStatement) parser.parseMarkupStatements(formals);
		assertEquals(2, varstm.getMarkupCount());
		assertEquals(Expression.VarExpression.class, varstm.getExpression().getClass());
		
		// Text expression
		iterator = TestScanner.quickScan("func1 func2 \"123\";");
		parser = new StatementParser(iterator, exceptions);
		
		ExpressionMarkupsStatement estatement = (ExpressionMarkupsStatement) parser.parseMarkupStatements(formals);
		assertEquals(2, estatement.getMarkupCount());
		assertEquals(Expression.TextExpression.class, estatement.getExpression().getClass());
	}
	
	@Test
	public void testEmbeddingMarkupsStatement() throws SyntaxException {
		iterator = TestScanner.quickScan("func1 func2 \"<123>\";");
		parser = new StatementParser(iterator, exceptions);
		
		EmbeddingMarkupsStatement statement = (EmbeddingMarkupsStatement) parser.parseMarkupStatements(formals);
		assertEquals(2, statement.getMarkupCount());
		assertEquals(Embed.ExpressionEmbed.class, statement.getEmbedding().getEmbed().getClass());
	}
	
	@Test
	public void testStatementMarkupsStatement() throws SyntaxException {
		iterator = TestScanner.quickScan("func1 func2 yield;;");
		parser = new StatementParser(iterator, exceptions);
		
		StatementMarkupsStatement statement = (StatementMarkupsStatement) parser.parseMarkupStatements(formals);
		assertEquals(2, statement.getMarkupCount());
		assertEquals(Statement.YieldStatement.class, statement.getStatement().getClass());
		
		// Markup statement collection
		iterator = TestScanner.quickScan("markup { func1 func2 var; }");
		parser = new StatementParser(iterator, exceptions);
		
		StatementMarkupsStatement cstatement = (StatementMarkupsStatement) parser.parseMarkupStatements(formals);
		assertEquals(1, cstatement.getMarkupCount());
		assertEquals(Statement.StatementCollection.class, cstatement.getStatement().getClass());
	}
	
	@Test
	public void testMarkupMarkupsStatement() throws SyntaxException {
		iterator = TestScanner.quickScan("func1 func2 func3;");
		parser = new StatementParser(iterator, exceptions);
		
		MarkupMarkupsStatement statement = (MarkupMarkupsStatement) parser.parseMarkupStatements(formals);
		assertEquals(2, statement.getMarkupCount());
		assertEquals(Markup.MarkupWithoutArguments.class, statement.getMarkup().getClass());
	}

}