/*
 * File			: StatementParser.java
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

package com.uva.se.wparse.parser;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.Terminals;
import org.codehaus.jparsec.misc.Mapper;

import com.uva.se.wparse.model.embedding.Embedding;
import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.model.predicate.Predicate;
import com.uva.se.wparse.model.statement.Assignment;
import com.uva.se.wparse.model.statement.Block;
import com.uva.se.wparse.model.statement.Cdata;
import com.uva.se.wparse.model.statement.Comment;
import com.uva.se.wparse.model.statement.Each;
import com.uva.se.wparse.model.statement.EchoEmbedding;
import com.uva.se.wparse.model.statement.EchoExpression;
import com.uva.se.wparse.model.statement.IfElse;
import com.uva.se.wparse.model.statement.If;
import com.uva.se.wparse.model.statement.LetIn;
import com.uva.se.wparse.model.statement.MarkupAndStatement;
import com.uva.se.wparse.model.statement.MarkupEmbedding;
import com.uva.se.wparse.model.statement.MarkupExpression;
import com.uva.se.wparse.model.statement.SingleMarkup;
import com.uva.se.wparse.model.statement.MultipleMarkup;
import com.uva.se.wparse.model.statement.Statement;
import com.uva.se.wparse.model.statement.Yield;


public final class StatementParser {
	
	
	private static Parser<Statement> comment() {
	  return curry( Comment.class).sequence( TerminalParser.term("comment"), ExpressionParser.STRING_LITERAL  ,TerminalParser.term(";") );
	}
	
	private static Parser<Statement> echo(Parser<Expression> expr) {
	  return curry( EchoExpression.class).sequence( TerminalParser.term("echo"), expr  ,TerminalParser.term(";") );
	}
  
	private static Parser<Statement> echoEmbedding(Parser<Embedding> embedding) {
	  return curry( EchoEmbedding.class).sequence( TerminalParser.term("echo"), TerminalParser.term("\""), embedding, TerminalParser.term("\"") ,TerminalParser.term(";") );
	}
  
	private static Parser<Statement> cdata(Parser<Expression> expr) {
	  return curry( Cdata.class).sequence( TerminalParser.term("cdata"), expr  ,TerminalParser.term(";") );
	}
 
	private static Parser<Statement> yield() {
	  return curry( Yield.class).sequence( TerminalParser.term("yield").source(), TerminalParser.term(";") );
	}
  
	private static Parser<Statement> ifStatement(Parser<Predicate> predicateParser, Parser<Statement> stmt) {
		return curry(If.class)
	    .sequence(TerminalParser.phrase("if ("), predicateParser, TerminalParser.term(")"), stmt).notFollowedBy(TerminalParser.term("else"));
	}
	
	private static Parser<Statement> ifElse(Parser<Predicate> predicateParser, Parser<Statement> stmt) {
		return curry(IfElse.class)
		    .sequence(TerminalParser.phrase("if ("), predicateParser, TerminalParser.term(")"), stmt, TerminalParser.term("else"), stmt);
	}
	
	private static Parser<Statement> each(Parser<Expression> expr, Parser<Statement> stmt) {
		return curry(Each.class)
		    .sequence(TerminalParser.phrase("each ("), Terminals.Identifier.PARSER, TerminalParser.term(":"), expr, TerminalParser.term(")"), stmt);
	}
	
	private static Parser<Statement> block(Parser<Statement> stmt) {
		return curry(Block.class)
		    .sequence(TerminalParser.phrase("{"), stmt.many(), TerminalParser.term("}"));
	}
	
	private static Parser<Statement> letIn(Parser<Assignment> ass, Parser<Statement> stmt) {
		return curry(LetIn.class)
		    .sequence(TerminalParser.term("let"), ass.many1(), TerminalParser.term("in"), stmt.many(), TerminalParser.term("end"));
	}
	
	  

	private	static Parser<Statement> markup(Parser<Markup> markup) {
			return curry(MultipleMarkup.class).sequence(markup.atLeast(2), TerminalParser.term(";"));
		}
		
	private	static Parser<Statement> singleMarkup(Parser<Markup> markup) {
			return curry(SingleMarkup.class).sequence(markup, TerminalParser.term(";"));
		}
		
	private	static Parser<Statement> markupExpression(Parser<Markup> markup, Parser<Expression> expr) {
			return curry(MarkupExpression.class).sequence(markup.many1(), expr, TerminalParser.term(";"));
		}
		
	private	static Parser<Statement> markupEmbedding(Parser<Markup> markup, Parser<Embedding> embedding) {
			return curry(MarkupEmbedding.class).sequence(markup.many1(), TerminalParser.term("\""), embedding, TerminalParser.term("\""),  TerminalParser.term(";"));
		}
		
	private	static Parser<Statement> markupAndStatement(Parser<Markup> markup, Parser<Statement> statementParser) {
			return curry(MarkupAndStatement.class).sequence(markup.many1(), statementParser);
		}
		
		

  public static Parser<Statement> statement(Parser<Expression> expressionParser, Parser<Markup> markup) {
    Parser.Reference<Statement> ref = Parser.newReference();
    Parser<Statement> lazy = ref.lazy();
    Parser<Assignment> assignmentParser = AssignmentParser.assignment(lazy, expressionParser);
    Parser<Embedding> embeddingParser = EmbeddingParser.getParser(markup, expressionParser);
    Parser<Predicate> predicateParser = PredicateParser.predicates(expressionParser);
    
    @SuppressWarnings("unchecked")
    Parser<Statement> parser = Parsers.or(
    	ifElse(predicateParser, lazy),
        ifStatement(predicateParser, lazy),
        each(expressionParser, lazy),
        letIn(assignmentParser, lazy),
    	comment(),
    	singleMarkup(markup),
    	markupEmbedding(markup, embeddingParser),
    	echoEmbedding(embeddingParser),
    	echo(expressionParser),
    	cdata(expressionParser),
    	yield(),
    	markup(markup),
    	markupExpression(markup, expressionParser),
     	markupAndStatement(markup, lazy),
     	block(lazy)
    	);
    //Parser<Statement> parser2 = Parsers.or(parser, block(parser));
    
    ref.set(parser);
    return parser;
  }
  
  private static Mapper<Statement> curry(Class<? extends Statement> clazz, Object... curryArgs) {
    return Mapper.curry(clazz, curryArgs);
  }
  

}
