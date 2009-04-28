/*
 * File			: StatementParser.java
 * Project		: WaebrickParser
 * 				: Practicum opdracht Software Construction
 * 
 * Authors		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * 
 * Description	:
 * 
 */

package com.uva.se.wparse.parser;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.Terminals;
import org.codehaus.jparsec.misc.Mapper;

import com.uva.se.wparse.model.embedding.Embedding;
import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.markup.Argument;
import com.uva.se.wparse.model.markup.Attribute;
import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.model.statement.Assignment;
import com.uva.se.wparse.model.statement.AssignmentWithFormals;
import com.uva.se.wparse.model.statement.BlockStatement;
import com.uva.se.wparse.model.statement.CdataStatement;
import com.uva.se.wparse.model.statement.CommentStatement;
import com.uva.se.wparse.model.statement.EachStatement;
import com.uva.se.wparse.model.statement.EchoEmbeddingStatement;
import com.uva.se.wparse.model.statement.EchoExprStatement;
import com.uva.se.wparse.model.statement.IfElseStatement;
import com.uva.se.wparse.model.statement.IfStatement;
import com.uva.se.wparse.model.statement.LetInStatement;
import com.uva.se.wparse.model.statement.MarkupAndStatementStatement;
import com.uva.se.wparse.model.statement.MarkupEmbeddingStatement;
import com.uva.se.wparse.model.statement.MarkupExpressionStatement;
import com.uva.se.wparse.model.statement.MarkupStatement;
import com.uva.se.wparse.model.statement.MarkupStatements;
import com.uva.se.wparse.model.statement.Statement;
import com.uva.se.wparse.model.statement.YieldStatement;


public final class StatementParser {
	
	
  static Parser<Statement> comment() {
	  return curry( CommentStatement.class).sequence( TerminalParser.term("comment"),  Terminals.StringLiteral.PARSER  ,TerminalParser.term(";") );
  }
	
  static Parser<Statement> echo(Parser<Expression> expr) {
	  return curry( EchoExprStatement.class).sequence( TerminalParser.term("echo"), expr  ,TerminalParser.term(";") );
  }
  
  static Parser<Statement> echoEmbedding(Parser<Embedding> embedding) {
	  return curry( EchoEmbeddingStatement.class).sequence( TerminalParser.term("echo"), embedding  ,TerminalParser.term(";") );
  }
  
  static Parser<Statement> cdata(Parser<Expression> expr) {
	  return curry( CdataStatement.class).sequence( TerminalParser.term("cdata"), expr  ,TerminalParser.term(";") );
  }
 
  static Parser<Statement> yield() {
	  return curry( YieldStatement.class).sequence( TerminalParser.term("yield").source(), TerminalParser.term(";") );
  }
  
	static Parser<Statement> ifStatement(Parser<Expression> expr, Parser<Statement> stmt) {
	return curry(IfStatement.class)
	    .sequence(TerminalParser.phrase("if ("), expr, TerminalParser.term(")"), stmt).notFollowedBy(TerminalParser.term("else"));
	}
	
	static Parser<Statement> ifElseStatement(Parser<Expression> expr, Parser<Statement> stmt) {
		return curry(IfElseStatement.class)
		    .sequence(TerminalParser.phrase("if ("), expr, TerminalParser.term(")"), stmt, TerminalParser.term("else"), stmt);
	}
	
	static Parser<Statement> eachStatement(Parser<Expression> expr, Parser<Statement> stmt) {
		return curry(EachStatement.class)
		    .sequence(TerminalParser.phrase("each ("), Terminals.Identifier.PARSER, TerminalParser.term(":"), expr, TerminalParser.term(")"), stmt);
	}
	
	static Parser<Statement> blockStatement(Parser<Statement> stmt) {
		return curry(BlockStatement.class)
		    .sequence(TerminalParser.phrase("{"), stmt.many(), TerminalParser.term("}"));
	}
	
	static Parser<Statement> letInStatement(Parser<Assignment> ass, Parser<Statement> stmt) {
		return curry(LetInStatement.class)
		    .sequence(TerminalParser.term("let"), ass.many1(), TerminalParser.term("in"), stmt.many(), TerminalParser.term("end"));
	}
	
	  
		static Parser<Statement> letInStatement2(Parser<Assignment> ass, Parser<Statement> stmt) {
			return curry(LetInStatement.class)
			    .sequence(TerminalParser.term("let"), ass, TerminalParser.term("in"), stmt.many(), TerminalParser.term("end"));
		}

		static Parser<Statement> markupStatement(Parser<Markup> markup) {
			return curry(MarkupStatements.class).sequence(markup.atLeast(2), TerminalParser.term(";"));
		}
		
		static Parser<Statement> singleMarkupStatement(Parser<Markup> markup) {
			return curry(MarkupStatement.class).sequence(markup, TerminalParser.term(";"));
		}
		
		static Parser<Statement> markupExpressionStatement(Parser<Markup> markup, Parser<Expression> expr) {
			return curry(MarkupExpressionStatement.class).sequence(markup.many1(), expr, TerminalParser.term(";"));
		}
		
		static Parser<Statement> markupEmbeddingStatement(Parser<Markup> markup, Parser<Embedding> embedding) {
			return curry(MarkupEmbeddingStatement.class).sequence(markup.many1(), embedding, TerminalParser.term(";"));
		}
		
		static Parser<Statement> markupAndStatementStatement(Parser<Markup> markup, Parser<Statement> statementParser) {
			return curry(MarkupAndStatementStatement.class).sequence(markup.many1(), statementParser);
		}
		
		

  public static Parser<Statement> statement(Parser<Expression> expr, Parser<Markup> markup) {
    Parser.Reference<Statement> ref = Parser.newReference();
    Parser<Statement> lazy = ref.lazy();
    Parser<Assignment> assignmentParser = AssignmentParser.assignment(lazy, expr);
    Parser<Embedding> embeddingParser = EmbeddingParser.embedding(markup, expr);
    @SuppressWarnings("unchecked")
    Parser<Statement> parser = Parsers.or(
        ifStatement(expr, lazy),
        ifElseStatement(expr, lazy),
        eachStatement(expr, lazy),
        blockStatement(lazy),
        letInStatement(assignmentParser, lazy),
        letInStatement2(assignmentParser, lazy),
    	comment(),
    	echo(expr),
    	echoEmbedding(embeddingParser),
    	cdata(expr),
    	yield(),
    	singleMarkupStatement(markup),
    	markupStatement(markup),
    	markupExpressionStatement(markup, expr),
    	markupEmbeddingStatement(markup, embeddingParser),
    	markupAndStatementStatement(markup, lazy)
    	);
    ref.set(parser);
    return parser;
  }
  
  private static Mapper<Statement> curry(Class<? extends Statement> clazz, Object... curryArgs) {
    return Mapper.curry(clazz, curryArgs);
  }
  

}
