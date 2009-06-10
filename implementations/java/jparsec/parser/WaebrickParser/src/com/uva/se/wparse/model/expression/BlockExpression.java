/*
 * File			: BlockExpression.java
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

package com.uva.se.wparse.model.expression;

import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;
import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.util.Strings;

/**
 * The weabric parse tree node of the weabric 'BlockExpression' construction. It
 * is an implementation of an expression.
 */
public final class BlockExpression extends WaebricParseTreeNode implements
		Expression {

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(BlockExpression.class);

	/**
	 * OUTPUT_LIST is used to indicate this construction in the output process.
	 */
	private static final String OUTPUT_LIST = "list";

	/**
	 * A list with the expressions of the BlockExpression.
	 */
	private List<Expression> expr;

	/**
	 * Constructs a Weabric 'BlockExpression' parse tree node.
	 * 
	 * @param expr
	 *            A list with the expressions of the BlockExpression.
	 */
	public BlockExpression(List<Expression> expr) {
		this.expr = Collections.unmodifiableList(expr);
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
		return "[" + Strings.join(" ", expr) + "]";
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		String ListBlock = "";
		for (Expression expression : expr) {
			ListBlock = outputAddToBlock(ListBlock, expression
					.toTransformerOutput());
		}

		return OUTPUT_LIST + outputBracedBlock(outputBracedList(ListBlock));
	}
}
