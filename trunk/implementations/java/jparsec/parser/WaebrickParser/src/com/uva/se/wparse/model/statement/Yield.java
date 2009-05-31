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

import com.uva.se.wparse.model.common.ValueObject;

public class Yield extends ValueObject implements Statement {
	
	private static org.apache.log4j.Logger logger = Logger
	.getLogger(Each.class);

	private String yield;

	public Yield(String yield) {
		this.yield = yield;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		return yield.toString();
	}
	
	@Override
	public String toTransformerOutput() {
		return yield;		
	}
	
	
}
