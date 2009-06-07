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

public class Var extends WaebricParseTreeNode implements Expression {
	
	public static final String OUTPUT_VAR = "var";

	private static org.apache.log4j.Logger logger = Logger.getLogger(Var.class);

	private String identifier;

	public Var(String identifierStart , String identifierEnd) {
		this.identifier = identifierStart/* + identifierEnd*/;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName() + " with values : " + toString());
		}
	}	

	public String getIdentifier() {
		return identifier;
	}
	
	@Override
	public String toString() {
		return identifier;
	}
	
	@Override
	public String toTransformerOutput() {
		return OUTPUT_VAR +  outputBracedBlock( outputQuote( identifier ) );
	}
}
