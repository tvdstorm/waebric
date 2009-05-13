/*
 * File			: SingleAttribute.java
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
package com.uva.se.wparse.model.markup;

import org.apache.log4j.Logger;
import org.codehaus.jparsec.Token;

public class SingleAttribute implements Attribute  {
	
	private static org.apache.log4j.Logger logger = Logger.getLogger(SingleAttribute.class);

	private String symbol;
	private String identifier;
	
	public SingleAttribute(Token symbolToken, String identifier) {
		this.symbol = symbolToken.toString();
		//this.symbol = symbol;
		this.identifier = identifier;
		 if (logger.isDebugEnabled()) {
				logger.debug("Creating " + this.getClass().getSimpleName()
						+ " with values : " + toString());
			}
	}
	
	@Override
	public String toString() {
		return symbol + identifier;
	}
	
	
	
}
