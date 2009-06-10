/*
 * File			: AssignmentArgument.java
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
package com.uva.se.wparse.model.markup;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.expression.Identifier;

/**
 * The weabric parse tree node of the weabric 'AssignmentArgument' construction.
 * It is an implementation of an Argument.
 */
public class AssignmentArgument extends WaebricParseTreeNode implements
		Argument {

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(AssignmentArgument.class);

	/**
	 * The identifier part of the AssignmentArgument.
	 */
	private Identifier identifier;

	/**
	 * The expression part of the AssignmentArgument.
	 */
	private Expression expression;

	/**
	 * Constructs a Weabric 'AssignmentArgument' parse tree node.
	 * 
	 * @param identifier
	 *            The identifier part of the AssignmentArgument.
	 * @param expression
	 *            The expression part of the AssignmentArgument.
	 */
	public AssignmentArgument(Identifier identifier, Expression expression) {
		this.identifier = identifier;
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
		return identifier + " = " + expression;
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		String expressionItem = expression.toTransformerOutput();
		if (expression instanceof Identifier) {
			expressionItem = outputBracedBlock(expressionItem);
		}

		return OUTPUT_ATTRIBUTE
				+ outputBracedBlock(outputAddToBlock(outputQuote(identifier),
						expressionItem));
	}

}
