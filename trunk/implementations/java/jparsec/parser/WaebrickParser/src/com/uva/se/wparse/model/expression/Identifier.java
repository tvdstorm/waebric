/*
 * File			: Identifier.java
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

public class Identifier extends WaebricParseTreeNode implements Expression {

	private static org.apache.log4j.Logger logger = Logger.getLogger(Identifier.class);

	private String identifier;

	public Identifier(String identifierStart , String identifierEnd) {
		this.identifier = (identifierStart + identifierEnd).trim();
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName() + " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		return identifier;
	}
	
	@Override
	public String toTransformerOutput() {
		return outputQuote(identifier);
	}
}