package org.cwi.waebric.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.cwi.waebric.parser.ast.expression.Expression;
import org.cwi.waebric.parser.ast.expression.Expression.NatExpression;
import org.cwi.waebric.parser.ast.markup.Markup;
import org.cwi.waebric.parser.ast.statement.Assignment;
import org.cwi.waebric.parser.ast.statement.Formals;
import org.cwi.waebric.parser.ast.statement.Statement;
import org.cwi.waebric.parser.ast.statement.Statement.*;
import org.cwi.waebric.parser.ast.statement.embedding.Embed;
import org.cwi.waebric.parser.ast.statement.predicate.Predicate;
import org.cwi.waebric.parser.exception.ParserException;
import org.cwi.waebric.scanner.TestScanner;
import org.cwi.waebric.scanner.token.WaebricTokenIterator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestStatementParser {

	private StatementParser parser;
	
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
	public void testFormals() {
		iterator = TestScanner.quickScan("(var1,var2)");
		parser = new StatementParser(iterator, exceptions);
		
		Formals formals = parser.parseFormals();
		assertEquals(0, exceptions.size());
		assertEquals(2, formals.size());
		assertEquals("var1", formals.get(0).getIdentifier().getLiteral().toString());
		assertEquals("var2", formals.get(1).getIdentifier().getLiteral().toString());
	}
	
	@Test
	public void testVarAssignment() {
		iterator = TestScanner.quickScan("var=100");
		parser = new StatementParser(iterator, exceptions);
		
		Assignment.VarAssignment assignment = parser.parseVarAssignment();
		assertEquals(0, exceptions.size());
		assertEquals("var", assignment.getVar().getIdentifier().getLiteral().toString());
		assertEquals(NatExpression.class, assignment.getExpression().getClass());
	}
	
	@Test
	public void testIdConAssignment() {
		iterator = TestScanner.quickScan("identifier1(var1,var2) = yield;");
		parser = new StatementParser(iterator, exceptions);
		
		Assignment.IdConAssignment assignment = parser.parseIdConAssignment();
		assertEquals(0, exceptions.size());
		assertEquals("identifier1", assignment.getIdentifier().getLiteral().toString());
		assertEquals(2, assignment.getFormals().size());
		assertEquals("var1", assignment.getFormals().get(0).getIdentifier().getLiteral().toString());
		assertEquals("var2", assignment.getFormals().get(1).getIdentifier().getLiteral().toString());
		assertEquals(Statement.YieldStatement.class, assignment.getStatement().getClass());
	}
	
	@Test
	public void testIfStatement() {
		iterator = TestScanner.quickScan("if(123) comment \"succes\"");
		parser = new StatementParser(iterator, exceptions);
		
		IfStatement statement = parser.parseIfStatement();
		assertEquals(0, exceptions.size());
		assertEquals(Predicate.ExpressionPredicate.class, statement.getPredicate().getClass());
		assertEquals(Statement.CommentStatement.class, statement.getStatement().getClass());
	}
	
	@Test
	public void testIfElseStatement() {
		iterator = TestScanner.quickScan("if(123) comment \"succes\" else yield;");
		parser = new StatementParser(iterator, exceptions);
		
		IfElseStatement statement = (IfElseStatement) parser.parseIfStatement();
		assertEquals(0, exceptions.size());
		assertEquals(Predicate.ExpressionPredicate.class, statement.getPredicate().getClass());
		assertEquals(Statement.CommentStatement.class, statement.getStatement().getClass());
		assertEquals(Statement.YieldStatement.class, statement.getElseStatement().getClass());
	}
	
	@Test
	public void testEchoEmbeddingStatement() {
		iterator = TestScanner.quickScan("echo \"<123>\";");
		parser = new StatementParser(iterator, exceptions);
		
		EchoEmbeddingStatement statement = parser.parseEchoEmbeddingStatement();
		assertEquals(0, exceptions.size());
		assertNotNull(statement.getEmbedding());
	}
	
	@Test
	public void testEchoExpressionStatement() {
		iterator = TestScanner.quickScan("echo 10;");
		parser = new StatementParser(iterator, exceptions);
		
		EchoExpressionStatement statement = parser.parseEchoExpressionStatement();
		assertEquals(0, exceptions.size());
		assertEquals(Expression.NatExpression.class, statement.getExpression().getClass());
	}
	
	@Test
	public void testEachStatement() {
		iterator = TestScanner.quickScan("each(var1:10) comment \"test\"");
		parser = new StatementParser(iterator, exceptions);
		
		EachStatement statement = parser.parseEachStatement();
		assertEquals(0, exceptions.size());
		assertEquals("var1", statement.getVar().getIdentifier().getLiteral().toString());
		assertEquals(Expression.NatExpression.class, statement.getExpression().getClass());
		assertEquals(Statement.CommentStatement.class, statement.getStatement().getClass());
	}
	
	@Test
	public void testLetStatement() {
		iterator = TestScanner.quickScan("let var=100 in comment \"test\" end");
		parser = new StatementParser(iterator, exceptions);
		
		LetStatement statement = parser.parseLetStatement();
		assertEquals(0, exceptions.size());
		assertEquals(1, statement.getAssignmentCount());
		assertEquals(Assignment.VarAssignment.class, statement.getAssignment(0).getClass());
		assertEquals(1, statement.getStatementCount());
		assertEquals(Statement.CommentStatement.class, statement.getStatement(0).getClass());
	}
	
	@Test
	public void testCDataStatement() {
		iterator = TestScanner.quickScan("cdata 10;");
		parser = new StatementParser(iterator, exceptions);
		
		CDataStatement statement = parser.parseCDataStatement();
		assertEquals(0, exceptions.size());
		assertEquals(Expression.NatExpression.class, statement.getExpression().getClass());
	}
	
	@Test
	public void testCommentStatement() {
		iterator = TestScanner.quickScan("comment \"OH NOES TEH HAXZOR\";");
		parser = new StatementParser(iterator, exceptions);
		
		CommentStatement statement = parser.parseCommentStatement();
		assertEquals(0, exceptions.size());
		assertEquals("OH NOES TEH HAXZOR", statement.getComment().getLiteral().toString());
	}
	
	@Test
	public void testYieldStatement() {
		iterator = TestScanner.quickScan("yield;");
		parser = new StatementParser(iterator, exceptions);
		
		parser.parseYieldStatement();
		assertEquals(0, exceptions.size());
	}
	
	@Test
	public void testMarkupStatement() {
		iterator = TestScanner.quickScan("func1;");
		parser = new StatementParser(iterator, exceptions);
		
		MarkupStatement statement = (MarkupStatement) parser.parseStatement("", "");
		assertEquals(0, exceptions.size());
		assertEquals(Markup.MarkupWithoutArguments.class, statement.getMarkup().getClass());
	}
	
	@Test
	public void testExpressionMarkupsStatement() {
		iterator = TestScanner.quickScan("func1 123;");
		parser = new StatementParser(iterator, exceptions);
		
		ExpressionMarkupsStatement statement = (ExpressionMarkupsStatement) parser.parseStatement("", "");
		assertEquals(0, exceptions.size());
		assertEquals(1, statement.getMarkupCount());
		assertEquals(Expression.NatExpression.class, statement.getExpression().getClass());
	}
	
	@Test
	public void testEmbeddingMarkupsStatement() {
		iterator = TestScanner.quickScan("func1 \"<123>\";");
		parser = new StatementParser(iterator, exceptions);
		
		EmbeddingMarkupsStatement statement = (EmbeddingMarkupsStatement) parser.parseStatement("", "");
		assertEquals(0, exceptions.size());
		assertEquals(1, statement.getMarkupCount());
		assertEquals(Embed.ExpressionEmbed.class, statement.getEmbedding().getEmbed().getClass());
	}
	
	@Test
	public void testStatementMarkupsStatement() {
		iterator = TestScanner.quickScan("func1 yield;;");
		parser = new StatementParser(iterator, exceptions);
		
		StatementMarkupsStatement statement = (StatementMarkupsStatement) parser.parseStatement("", "");
		assertEquals(0, exceptions.size());
		assertEquals(1, statement.getMarkupCount());
		assertEquals(Statement.YieldStatement.class, statement.getStatement().getClass());
	}
	
	@Test
	public void testMarkupMarkupsStatement() {
		iterator = TestScanner.quickScan("func1 func1;");
		parser = new StatementParser(iterator, exceptions);
		
		MarkupMarkupsStatement statement = (MarkupMarkupsStatement) parser.parseStatement("", "");
		assertEquals(0, exceptions.size());
		assertEquals(1, statement.getMarkupCount());
		assertEquals(Markup.MarkupWithoutArguments.class, statement.getMarkup().getClass());
	}

}