/*
 * File			: LetInStatement.java
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

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.ValueObject;


public final class LetInStatement extends ValueObject implements Statement {
	
	private static org.apache.log4j.Logger logger = Logger.getLogger(LetInStatement.class);

	private Object expr;
	private ArrayList<Statement> stmt;
  
  public LetInStatement( Object expr, ArrayList<Statement> stm) {
    this.expr = expr;
    this.stmt = stm;
    if (logger.isDebugEnabled()) {
		logger.debug("Creating " + this.getClass().getSimpleName()
				+ " with values : " + toString());
	}
  }
  
  @Override public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("let ").append(expr).append(" in ").append(stmt).append("end");
    return builder.toString();
  }
}
