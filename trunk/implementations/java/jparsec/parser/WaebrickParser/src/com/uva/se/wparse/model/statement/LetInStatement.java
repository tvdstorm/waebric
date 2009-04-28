/*
 * File			: LetInStatement.java
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

import java.util.ArrayList;

import com.uva.se.wparse.model.common.ValueObject;


public final class LetInStatement extends ValueObject implements Statement {

	private Object expr;
	private ArrayList<Statement> stmt;
  
  public LetInStatement( Object expr, ArrayList<Statement> stm) {
    this.expr = expr;
    this.stmt = stm;
    System.out.println("debug -- inside " + this.getClass().getSimpleName() + " constructor");
  }
  
  @Override public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("let ").append(expr).append(" in ").append(stmt).append("end");
    return builder.toString();
  }
}
