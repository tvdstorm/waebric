/*
 * File			: IdentDotExpression.java
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

public final class IdentDotExpression extends ValueObject implements Expression {

	private static org.apache.log4j.Logger logger = Logger
			.getLogger(IdentDotExpression.class);
	private String ident;
	private Expression expr;

	public IdentDotExpression(String ident, Expression expr) {
		this.ident = ident;
		this.expr = expr;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		return expr + "." + ident;
	}
}
