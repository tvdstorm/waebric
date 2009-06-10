package com.uva.se.wparse.model.predicate;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.model.expression.Expression;

/**
 * The weabric parse tree node of the weabric 'WaebricParseTreeNode'
 * construction. It is an implementation of a predicate.
 */
public class ExpressionPredicate extends WaebricParseTreeNode implements
		Predicate {

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(ExpressionPredicate.class);

	/**
	 * The expression which is used in the Predicate.
	 */
	private Expression expression = null;

	/**
	 * Constructs a Weabric 'Each' parse tree node.
	 * 
	 * @param expression
	 *            The expression which is used in the Predicate.
	 */
	public ExpressionPredicate(Expression expression) {
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
		return expression.toString();
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		return expression.toTransformerOutput();
	}

}
