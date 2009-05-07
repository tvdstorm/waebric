/*
 * File			: IfElseStatement.java
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

package com.uva.se.wparse.model.statement;

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.model.expression.Expression;





public final class IfElseStatement extends ValueObject implements Statement {
	private Expression condition;
	private Statement thenStmt;
	private Statement elseStmt;
  
  public IfElseStatement(Expression condition, Statement thenStmt, Statement elseStmt) {
    this.condition = condition;
    this.thenStmt = thenStmt;
    this.elseStmt = elseStmt;
    System.out.println("debug -- inside " + this.getClass().getSimpleName() + " constructor");
  }
  
  @Override public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("if (").append(condition).append(") ").append(thenStmt).append(" else ").append(elseStmt);
       return builder.toString();
  }
}
