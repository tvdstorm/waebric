/*
 * File			: IfStatement.java
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
