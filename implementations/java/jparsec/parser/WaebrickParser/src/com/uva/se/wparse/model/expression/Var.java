/*
 * File			: Var.java
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
 * The weabric parse tree node of the weabric 'Var' construction. It is an
 * implementation of an expression.
 */
public class Var extends WaebricParseTreeNode implements Expression {

	/**
	 * OUTPUT_VAR is used to indicate this construction in the output process.
	 */
	public static final String OUTPUT_VAR = "var";

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger.getLogger(Var.class);

	/**
	 * The identifier of the var. 
	 */
	private String identifier;

	/**
	 * Constructs a Weabric 'Var' parse tree node.
	 * @param identifierStart The start part of the identifier of the Var. 
	 * @param identifierEnd The end part of the identifier of the Var. 
	 */
	public Var(String identifierStart, String identifierEnd) {
		this.identifier = identifierStart/* + identifierEnd */;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	/**
	 * Get the identifier of the Var. 
	 * @return The identifier. 
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * Presents this object as a string representation.
	 */
	@Override
	public String toString() {
		return identifier;
	}
	
	/**
	 * Transforms the content of this object to the expected output code. 
	 * If necessary this function constructs also the output of the children. 
	 * (It calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		return OUTPUT_VAR + outputBracedBlock(outputQuote(identifier));
	}
}
