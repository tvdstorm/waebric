/*
 * File			: If.java
 * Project		: WaebrickParser2
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

/**
 * The weabric parse tree node of the weabric 'if' construction. It is an
 * implementation of a statement.
 */
public final class If extends WaebricParseTreeNode implements Statement {

	/**
	 * OUTPUT_IF is used to indicate this option in the output process.
	 */
	private static final String OUTPUT_IF = "if";

	/**
	 * OUTPUT_NO_ELSE is used to indicate this option in the output process.
	 */
	private static final String OUTPUT_NO_ELSE = "appl(prod([],cf(sort(\"NoElseMayFollow\")),no-attrs),[])";

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger.getLogger(If.class);

	/**
	 * The condition of the if statement.
	 */
	private Predicate condition;

	/**
	 * The then part of the if statements.
	 */
	private Statement then;

	/**
	 * Constructs a Weabric 'Each' parse tree node.
	 * 
	 * @param condition
	 *            The condition of the if statement.
	 * @param then
	 *            The then part of the if statements.
	 */
	public If(Predicate condition, Statement then) {
		this.condition = condition;
		this.then = then;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	/**
	 * Presents this object as a string representation.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("if (").append(condition).append(") ").append(then)
				.append(";");
		return builder.toString();
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		return OUTPUT_IF
				+ outputBracedBlock(condition.toTransformerOutput()
						+ OUTPUT_BLOCK_SEPARATOR + then.toTransformerOutput()
						+ OUTPUT_BLOCK_SEPARATOR + OUTPUT_NO_ELSE);
	}

}
