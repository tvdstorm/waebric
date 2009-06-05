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

import java.util.List;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;


public final class LetIn extends WaebricParseTreeNode implements Statement {
	
	public static final String OUTPUT_LETIN = "let";
	
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
  		for (Assignment assignment: assignmentList) {  		
			expressionItem = assignment.toTransformerOutput();
  		}
  		
  		String statementListString = "";
  		for (Statement statement: statementList) {
  			statementListString = outputAddToBlock(statementListString, statement.toTransformerOutput());
  		}
  		
  		return OUTPUT_LETIN + outputBracedBlock( outputBracedList( expressionItem ) + OUTPUT_BLOCK_SEPARATOR + outputBracedList( statementListString ) );	
  	}
}
