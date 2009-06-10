/*
 * File			: Identifier.java
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

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;

/**
 * The weabric parse tree node of the weabric 'each' construction. It is an
 * implementation of an expression.
 */
public class Identifier extends WaebricParseTreeNode implements Expression {

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(Identifier.class);

	/**
	 * The identier itself.
	 */
	private String identifier;

	/**
	 * Constructs a Weabric 'Identifier' parse tree node.
	 * 
	 * @param identifierStart
	 *            The startpart of the identifier.
	 * @param identifierEnd
	 *            The endpart of the identifier.
	 */
	public Identifier(String identifierStart, String identifierEnd) {
		this.identifier = (identifierStart + identifierEnd).trim();
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
		return identifier;
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		return outputQuote(identifier);
	}
}
