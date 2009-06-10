/*
 * File			: EachStatement.java
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
import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.expression.Identifier;

/**
 * The weabric parse tree node of the weabric 'each' construction. It is an
 * implementation of a statement.
 */
public final class Each extends WaebricParseTreeNode implements Statement {

	/**
	 * OUTPUT_EACH is used to indicate this option in the output process.
	 */
	private static final String OUTPUT_EACH = "each";

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(Each.class);

	/**
	 * The identifier of the each construct.
	 */
	private Identifier identifier;

	/**
	 * The expression of the each construct.
	 */
	private Expression expr;

	/**
	 * The statement which is executed.
	 */
	private Statement stmt;

	/**
	 * Constructs a Weabric 'Each' parse tree node.
	 * 
	 * @param identifier
	 *            The identifier of the each construct.
	 * @param expr
	 *            The expression of the each construct
	 * @param stm
	 *            The statement which is executed.
	 */
	public Each(Identifier identifier, Expression expr, Statement stm) {
		this.identifier = identifier;
		this.expr = expr;
		this.stmt = stm;
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
		builder.append("each (").append(identifier).append(": ").append(expr)
				.append(") ").append(stmt);
		return builder.toString();
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		return OUTPUT_EACH
				+ outputBracedBlock(outputQuote(identifier)
						+ OUTPUT_BLOCK_SEPARATOR + expr.toTransformerOutput()
						+ OUTPUT_BLOCK_SEPARATOR + stmt.toTransformerOutput());
	}
}
