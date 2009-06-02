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


public final class LetIn extends ValueObject implements Statement {
	
	public static final String OUTPUT_LETIN = "letin";
	
	private static org.apache.log4j.Logger logger = Logger.getLogger(LetIn.class);

	private Object expr;
	private ArrayList<Statement> stmt;
  
  public LetIn( Object expr, ArrayList<Statement> stm) {
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
  
  	@Override
  	public String toTransformerOutput() {
  		String expressionItem = "";
  		if (expr instanceof ValueObject) {
  			expressionItem = ((ValueObject)expr).toTransformerOutput();
  		}
  		
  		String statementList = "";
  		for (Statement statement: stmt) {
  			if (statement instanceof ValueObject) {
  				outputAddToList(statementList, ((ValueObject)statement).toTransformerOutput());
  			}
  		}
  		
  		return OUTPUT_LETIN + outputBracedBlock( expressionItem + OUTPUT_BLOCK_SEPARATOR + outputBracedList( statementList ) );	
  	}
}
