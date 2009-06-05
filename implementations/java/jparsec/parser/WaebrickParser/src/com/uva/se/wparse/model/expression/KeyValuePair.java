/*
 * File			: KeyValuePair.java
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

public class KeyValuePair extends WaebricParseTreeNode implements Expression {
	public static final String OUTPUT_PAIR = "pair";
	
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(KeyValuePair.class);

	private String key;
	private Expression value;

	public KeyValuePair(String key, Expression value) {
		this.key = key;
		this.value = value;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		return key + ":" + value;
	}
	
	@Override
	public String toTransformerOutput() {
		return OUTPUT_PAIR + outputBracedBlock( outputQuote( key ) + OUTPUT_BLOCK_SEPARATOR + value.toTransformerOutput() );
	}

}
