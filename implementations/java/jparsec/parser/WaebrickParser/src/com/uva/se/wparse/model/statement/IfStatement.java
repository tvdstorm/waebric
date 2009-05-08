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

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.model.predicate.Predicate;

public final class IfStatement extends ValueObject implements Statement {

	private static org.apache.log4j.Logger logger = Logger
			.getLogger(IfStatement.class);

	private Predicate condition;
	private Statement then;

	public IfStatement(Predicate condition, Statement then) {
		this.condition = condition;
		this.then = then;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("if (").append(condition).append(") ").append(then)
				.append(";");
		return builder.toString();
	}
}
