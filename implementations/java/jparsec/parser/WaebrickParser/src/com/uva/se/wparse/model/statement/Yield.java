/*
 * File			: YieldStatement.java
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

/**
 * The weabric parse tree node of the weabric 'yield' construction. It is an
 * implementation of a statement.
 */
public class Yield extends WaebricParseTreeNode implements Statement {

	/**
	 * OUTPUT_YIELD is used to indicate this construction in the output process.
	 */
	public static final String OUTPUT_YIELD = "yield";

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(Each.class);

	/**
	 * The part which is yielded.
	 */
	private String yield;

	/**
	 * Constructs a Weabric 'Yield' parse tree node.
	 * 
	 * @param yield
	 *            The part which is yielded.
	 */
	public Yield(String yield) {
		this.yield = yield;
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
		return yield.toString();
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		return OUTPUT_YIELD;
	}
}
