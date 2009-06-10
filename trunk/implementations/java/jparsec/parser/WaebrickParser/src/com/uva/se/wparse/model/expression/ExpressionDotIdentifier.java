/*
 * File			: IdentDotExpression.java
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
package com.uva.se.wparse.model.expression;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.parser.Operator;

/**
 * The weabric parse tree node of the weabric 'ExpressionDotIdentifier'
 * construction. It is an implementation of an expression.
 */
public final class ExpressionDotIdentifier extends WaebricParseTreeNode
		implements Expression {

	/**
	 * OUTPUT_FIELD is used to indicate this construction in the output process.
	 */
	private static final String OUTPUT_FIELD = "field";

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(ExpressionDotIdentifier.class);

	/**
	 * The identifier part of the ExpressionDotIdentifier.
	 */
	private Identifier identifier = null;

	/**
	 * The expression part of the ExpressionDotIdentifier.
	 */
	private Expression expression = null;

	/**
	 * Constructs a Weabric 'Each' parse tree node.
	 * 
	 * @param expression
	 *            The expression part of the ExpressionDotIdentifier.
	 * @param op
	 *            The operator part of the ExpressionDotIdentifier.
	 * @param identifier
	 *            The identifier part of the ExpressionDotIdentifier.
	 */
	public ExpressionDotIdentifier(Expression expression, Operator op,
			Expression identifier) {
		if (identifier instanceof Var) {
			this.identifier = new Identifier(
					((Var) identifier).getIdentifier(), "");
		} else if (identifier instanceof Identifier) {
			this.identifier = (Identifier) identifier;
		}

		this.expression = expression;
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
		return expression + "." + identifier;
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		return OUTPUT_FIELD
				+ outputBracedBlock(expression.toTransformerOutput()
						+ OUTPUT_BLOCK_SEPARATOR
						+ identifier.toTransformerOutput());
	}
}
