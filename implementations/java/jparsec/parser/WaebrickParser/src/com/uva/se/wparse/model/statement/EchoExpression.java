/*
 * File			: EchoExpression.java
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
import com.uva.se.wparse.model.expression.Expression;

/**
 * The weabric parse tree node of the weabric 'echo expression' construction. It
 * is an implementation of a statement.
 */
public class EchoExpression extends WaebricParseTreeNode implements Statement {

	/**
	 * OUTPUT_ECHO is used to indicate this option in the output process.
	 */
	private static final String OUTPUT_ECHO = "echo";

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(EchoExpression.class);

	/**
	 * The expression which is used in the echo statement.
	 */
	private Expression expr;

	/**
	 * Constructs a Weabric 'eacho expression' parse tree node.
	 * 
	 * @param expr
	 *            The expression which is used in the echo statement.
	 */
	public EchoExpression(Expression expr) {
		this.expr = expr;
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
		return "echo " + expr.toString();
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		return OUTPUT_ECHO + outputBracedBlock(expr.toTransformerOutput());
	}
}
