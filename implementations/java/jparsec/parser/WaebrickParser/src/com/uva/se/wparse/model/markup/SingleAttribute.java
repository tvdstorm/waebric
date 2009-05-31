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

import com.uva.se.wparse.model.common.ValueObject;

public class SingleAttribute extends ValueObject implements Attribute  {
	
	private static org.apache.log4j.Logger logger = Logger.getLogger(SingleAttribute.class);

	private String symbol; //TODO: symbol vervangen door Enum
	private String identifier;
	
	public SingleAttribute(Token symbolToken, String identifier) {
		this.symbol = symbolToken.toString();
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
	
	@Override
	public String toTransformerOutput() {		
		return outputQuote( identifier );
	}
	
}
