/*
 * File			: IfElseStatement.java
 * Project		: WaebrickParser
 * 				: Practicum opdracht Software Construction
 * 
 * Authors		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * 
 * Description	:
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
