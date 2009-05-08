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

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.model.expression.Expression;

public final class IfElseStatement extends ValueObject implements Statement {

	private static org.apache.log4j.Logger logger = Logger
			.getLogger(IfElseStatement.class);

	private Expression condition;
	private Statement thenStatement;
	private Statement elseStatement;

	public IfElseStatement(Expression condition, Statement thenStatement,
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
}
