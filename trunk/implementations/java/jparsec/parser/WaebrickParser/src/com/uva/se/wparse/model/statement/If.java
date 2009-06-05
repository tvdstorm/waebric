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

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.model.predicate.Predicate;

public final class If extends WaebricParseTreeNode implements Statement {
	
	public static final String OUTPUT_IF = "if";
	public static final String OUTPUT_NO_ELSE = "appl(prod([],cf(sort(\"NoElseMayFollow\")),no-attrs),[])";

	private static org.apache.log4j.Logger logger = Logger
			.getLogger(If.class);

	private Predicate condition;
	private Statement then;

	public If(Predicate condition, Statement then) {
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
	
	@Override
	public String toTransformerOutput() {
		return OUTPUT_IF + outputBracedBlock(condition.toTransformerOutput() + OUTPUT_BLOCK_SEPARATOR + then.toTransformerOutput() + OUTPUT_BLOCK_SEPARATOR + OUTPUT_NO_ELSE);
	}
	
}
