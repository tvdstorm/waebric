/*
 * File			: AssignmentExpression.java
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
import com.uva.se.wparse.model.expression.Identifier;

/**
 * Represents the definition of the assignment expression.
 */
public final class AssignmentExpression extends WaebricParseTreeNode 
	implements Assignment {

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(AssignmentExpression.class);

	/**
	 * A definition of an output assignment which is used while generating the
	 * output of the parsing process.
	 */
	private static final String OUTPUT_ASSIGNMENT = "var-bind";
	
	/**
	 * The left part of an expression.
	 */
	private Identifier left;

	/**
	 * The right part of an expression.
	 */
	private Expression right;

	/**
	 * Constructs an AssignmentExpression based on the left and the right part
	 * of an expression.
	 * 
	 * @param left
	 *            The left part of an expression.
	 * @param right
	 *            The right part of an expression.
	 */
	public AssignmentExpression(Identifier left, Expression right) {
		this.left = left;
		this.right = right;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	/**
	 * Represents the definition of this object as Weabric code. If children
	 * exists it displays also the children in this string representation.
	 */
	@Override
	public String toString() {
		return left + " = " + right;
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		return OUTPUT_ASSIGNMENT
				+ outputBracedBlock(outputQuote(left) + OUTPUT_BLOCK_SEPARATOR
						+ right.toTransformerOutput());
	}
}
