/*
 * File			: SymbolConstant.java
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


public class SymbolConstant implements Expression {
	
	private static org.apache.log4j.Logger logger = Logger.getLogger(SymbolConstant.class);

	private Object symbol;

	public SymbolConstant(Object symbol) {
		this.symbol = symbol;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName() + " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		return "'" + symbol.toString();
	}
	
	
}
