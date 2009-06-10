/*
 * File			: IfElse.java
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
 * The weabric parse tree node of the weabric 'if else' construction. It is an
 * implementation of a statement.
 */
public final class IfElse extends WaebricParseTreeNode implements Statement {

	/**
	 * OUTPUT_IF_ELSE is used to indicate this construction in the output
	 * process.
	 */
	public static final String OUTPUT_IF_ELSE = "if-else";

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(IfElse.class);

	/**
	 * The condition of the if - else construction.
	 */
	private Predicate condition;

	/**
	 * The statement which is executed in the then part.
	 */
	private Statement thenStatement;

	/**
	 * The statement which is executed in the else part.
	 */
	private Statement elseStatement;

	/**
	 * Constructs a Weabric 'Each' parse tree node.
	 * 
	 * @param condition
	 *            The condition of the if - else construction.
	 * @param thenStatement
	 *            The statement which is executed in the then part.
	 * @param elseStatement
	 *            The statement which is executed in the else part.
	 */
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

	/**
	 * Presents this object as a string representation.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("if (").append(condition).append(") ").append(
				thenStatement).append(" else ").append(elseStatement);
		return builder.toString();
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		return OUTPUT_IF_ELSE
				+ outputBracedBlock(condition.toTransformerOutput()
						+ OUTPUT_BLOCK_SEPARATOR
						+ thenStatement.toTransformerOutput()
						+ OUTPUT_BLOCK_SEPARATOR
						+ elseStatement.toTransformerOutput());
	}
}
