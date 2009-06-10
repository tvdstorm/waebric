/*
 * File			: NaturalExpression.java
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

/**
 * The weabric parse tree node of the weabric 'NaturalConstant' construction. It
 * is an implementation of an expression.
 */
public final class NaturalConstant extends WaebricParseTreeNode implements
		Expression {

	/**
	 * OUTPUT_NATCON is used to indicate this construction in the output
	 * process.
	 */
	public static final String OUTPUT_NATCON = "num";

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(NaturalConstant.class);

	/**
	 * The natural constant itself.
	 */
	private String natural;

	/**
	 * Constructs a Weabric 'Each' parse tree node.
	 * 
	 * @param natural
	 *            The natural constant itself.
	 */
	public NaturalConstant(String natural) {
		this.natural = natural;
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
		return natural;
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		return OUTPUT_NATCON + outputBracedBlock(natural);
	}
}
