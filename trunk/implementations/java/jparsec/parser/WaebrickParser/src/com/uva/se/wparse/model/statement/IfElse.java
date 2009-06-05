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

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.model.predicate.Predicate;

public final class IfElse extends WaebricParseTreeNode implements Statement {
	
	public static final String OUTPUT_IF_ELSE = "if-else";

	private static org.apache.log4j.Logger logger = Logger
			.getLogger(IfElse.class);

	private Predicate condition;
	private Statement thenStatement;
	private Statement elseStatement;

	public IfElse(Predicate condition, Statement thenStatement,
			Statement elseStatement) {
		this.condition = condition;
		this.thenStatement = thenStatement;
		this.elseStatement = elseStatement;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("if (").append(condition).append(") ").append(
				thenStatement).append(" else ").append(elseStatement);
		return builder.toString();
	}
	
	@Override
	public String toTransformerOutput() {
		return OUTPUT_IF_ELSE + outputBracedBlock(condition.toTransformerOutput() + OUTPUT_BLOCK_SEPARATOR + thenStatement.toTransformerOutput() + OUTPUT_BLOCK_SEPARATOR + elseStatement.toTransformerOutput() );		
	}
}
