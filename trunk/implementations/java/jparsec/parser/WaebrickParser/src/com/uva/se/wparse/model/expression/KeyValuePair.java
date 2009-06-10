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

/**
 * The weabric parse tree node of the weabric 'KeyValuePair' construction. It is an
 * implementation of an expression. 
 */
public class KeyValuePair extends WaebricParseTreeNode implements Expression {
	
	/**
	 * OUTPUT_PAIR is used to indicate this construction in the output process.
	 */
	private static final String OUTPUT_PAIR = "pair";
	
	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(KeyValuePair.class);

	/**
	 * The key part of the KeyValuePair.
	 */
	private String key;
	
	/**
	 * The value part of the KeyValuePair.
	 */
	private Expression value;

	/**
	 * Constructs a Weabric 'KeyValuePair' parse tree node.
	 * @param key The key part of the KeyValuePair.
	 * @param value The value part of the KeyValuePair.
	 */
	public KeyValuePair(String key, Expression value) {
		this.key = key;
		this.value = value;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	/**
	 * Presents this object as a string representation.
	 */
	@Override
	public String toString() {
		return key + ":" + value;
	}
	
	/**
	 * Transforms the content of this object to the expected output code. 
	 * If necessary this function constructs also the output of the children. 
	 * (It calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		return OUTPUT_PAIR + outputBracedBlock( outputQuote( key ) + OUTPUT_BLOCK_SEPARATOR + value.toTransformerOutput() );
	}

}
