/*
 * File			: IfStatement.java
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


public final class IfStatement extends ValueObject implements Statement {
	private Expression condition;
	private Statement then;

  
  public IfStatement(Expression condition, Statement then) {
    this.condition = condition;
    this.then = then;

  }
  
  @Override public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("if (").append(condition).append(") ").append(then);
    return builder.toString();
  }
}
