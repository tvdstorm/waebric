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
import java.util.List;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.ValueObject;


public final class LetIn extends ValueObject implements Statement {
	
	public static final String OUTPUT_LETIN = "letin";
	
	private static org.apache.log4j.Logger logger = Logger.getLogger(LetIn.class);

	private List<Assignment> assignmentList;
	private List<Statement> statementList;
  
  public LetIn( List<Assignment> assignmentList, List<Statement> statementList) {
    this.assignmentList = assignmentList;
    this.statementList = statementList;
    if (logger.isDebugEnabled()) {
		logger.debug("Creating " + this.getClass().getSimpleName()
				+ " with values : " + toString());
	}
  }
  
  @Override public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("let ").append(assignmentList).append(" in ").append(statementList).append("end");
    return builder.toString();
  }
  
  	@Override
  	public String toTransformerOutput() {
  		String expressionItem = "";
  		if (assignmentList instanceof ValueObject) {
  			expressionItem = ((ValueObject)assignmentList).toTransformerOutput();
  		}
  		
  		String statementListString = "";
  		for (Statement statement: statementList) {
  			if (statement instanceof ValueObject) {
  				outputAddToList(statementListString, ((ValueObject)statement).toTransformerOutput());
  			}
  		}
  		
  		return OUTPUT_LETIN + outputBracedBlock( expressionItem + OUTPUT_BLOCK_SEPARATOR + outputBracedList( statementListString ) );	
  	}
}
