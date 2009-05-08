/*
 * File			: AssignmentParser.java
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

import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.statement.Assignment;
import com.uva.se.wparse.model.statement.AssignmentNormal;
import com.uva.se.wparse.model.statement.AssignmentWithFormals;
import com.uva.se.wparse.model.statement.Statement;



public final class AssignmentParser {
	
	  private static Parser<Assignment> assignmentNormal(Parser<Expression> expr) {
		    return curry(AssignmentNormal.class).sequence(Terminals.Identifier.PARSER, TerminalParser.term("="), expr); 
	  }
	  
 
	
	  private static Parser<Assignment> assignmentFormals(Parser<Statement> stmt) {
		    return curry(AssignmentWithFormals.class).sequence(Terminals.Identifier.PARSER, TerminalParser.term("("),
		    		Terminals.Identifier.PARSER.sepBy1(TerminalParser.term(",")),
		    		TerminalParser.term(")"), TerminalParser.term("="), stmt   );
	  }


  public static Parser<Assignment> assignment(Parser<Statement> stmt, Parser<Expression> expr) {
    Parser.Reference<Assignment> ref = Parser.newReference();
    Parser<Assignment> parser = Parsers.or(
    	assignmentFormals(stmt),
    	assignmentNormal(expr)
    	);
    ref.set(parser);
    return parser;
  }
  
  private static Mapper<Assignment> curry(Class<? extends Assignment> clazz, Object... curryArgs) {
    return Mapper.curry(clazz, curryArgs);
  }
  

}
