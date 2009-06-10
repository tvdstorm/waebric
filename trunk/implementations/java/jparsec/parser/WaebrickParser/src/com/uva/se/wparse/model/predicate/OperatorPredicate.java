/*
 * File			: OperatorPredicate.java
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
package com.uva.se.wparse.model.predicate;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.parser.Operator;

/**
 * The weabric parse tree node of the weabric 'operator predicate' construction.
 * It is an implementation of a predicate
 */
public final class OperatorPredicate extends WaebricParseTreeNode implements
		Expression, Predicate {

	/**
	 * OUTPUT_OPERATOR_PREDICATE is used to indicate this construction in the
	 * output process.
	 */
	private static final String OUTPUT_OPERATOR_PREDICATE = "pred-op";

	/**
	 * OUTPUT_OPERATOR_PREDICATE_AND is used to indicate this construction in
	 * the output process.
	 */
	private static final String OUTPUT_OPERATOR_PREDICATE_AND = "and";

	/**
	 * OUTPUT_OPERATOR_PREDICATE_OR is used to indicate this construction in the
	 * output process.
	 */
	private static final String OUTPUT_OPERATOR_PREDICATE_OR = "or";

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(OperatorPredicate.class);

	/**
	 * The left part of the predicate.
	 */
	private final Predicate left;

	/**
	 * The operator part of the predicate.
	 */
	private final Operator op;

	/**
	 * The right part of the predicate.
	 */
	private final Predicate right;

	/**
	 * Constructs a Weabric 'Each' parse tree node.
	 * 
	 * @param left
	 *            The left part of the predicate.
	 * @param op
	 *            The operator part of the predicate.
	 * @param right
	 *            The right part of the predicate.
	 */
	public OperatorPredicate(Predicate left, Operator op, Predicate right) {
		this.left = left;
		this.op = op;
		this.right = right;
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
		return left.toString() + " " + op.toString() + " " + right.toString();
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		String outputType = "";

		switch (op) {
		case AND:
			outputType = OUTPUT_OPERATOR_PREDICATE_AND;
			break;
		case OR:
			outputType = OUTPUT_OPERATOR_PREDICATE_OR;
			break;
		default:
			outputType = OUTPUT_OPERATOR_PREDICATE;
			break;
		}

		return outputType
				+ outputBracedBlock(left.toTransformerOutput()
						+ OUTPUT_BLOCK_SEPARATOR + right.toTransformerOutput());
	}
}
