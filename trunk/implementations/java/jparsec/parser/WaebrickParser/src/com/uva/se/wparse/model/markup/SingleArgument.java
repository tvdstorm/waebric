/*
 * File			: SingleArgument.java
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
package com.uva.se.wparse.model.markup;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.model.expression.Expression;

/**
 * The weabric parse tree node of the weabric 'SingleArgument' construction. It
 * is an implementation of an expression.
 */
public class SingleArgument extends WaebricParseTreeNode implements Argument {

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(SingleArgument.class);

	/**
	 * The expression of the SingleArgument.
	 */
	private Expression expression;

	/**
	 * Constructs a Weabric 'SingleArgument' parse tree node.
	 * 
	 * @param expression
	 *            The expression of the SingleArgument.
	 */
	public SingleArgument(Expression expression) {
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
