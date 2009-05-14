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

import java.util.List;

import org.apache.log4j.Logger;

import com.uva.se.wparse.util.Strings;


public class SymbolConstant implements Expression {
	
	private static org.apache.log4j.Logger logger = Logger.getLogger(SymbolConstant.class);

	private String symbol;

	public SymbolConstant(List<String> symbolParts) {
		this.symbol = Strings.join("", symbolParts);
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName() + " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		return "'" + symbol.toString();
	}
	
	
}
