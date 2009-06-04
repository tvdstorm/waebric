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

import com.uva.se.wparse.model.common.ValueObject;

public final class NaturalConstant extends ValueObject implements Expression {
	
	public static final String OUTPUT_NATCON = "num"; 

	private static org.apache.log4j.Logger logger = Logger
			.getLogger(NaturalConstant.class);
	private String natural;

	public NaturalConstant(String natural) {
		this.natural = natural;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		return natural;
	}
	
	@Override
	public String toTransformerOutput() {
		return OUTPUT_NATCON + outputBracedBlock( natural );
	}
}
