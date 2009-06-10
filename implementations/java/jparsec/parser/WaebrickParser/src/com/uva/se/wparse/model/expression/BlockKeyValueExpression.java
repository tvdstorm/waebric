/*
 * File			: BlockKeyValueExpression.java
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

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.util.Strings;

/**
 * The weabric parse tree node of the weabric 'BlockKeyValueExpression' construction. It is an
 * implementation of an expression. 
 */
public final class BlockKeyValueExpression extends WaebricParseTreeNode implements Expression {
	
	/**
	 * OUTPUT_KEY_VALUE_BLOCK is used to indicate this construction in the output process.
	 */
	private static final String OUTPUT_KEY_VALUE_BLOCK = "record";
	
	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(BlockKeyValueExpression.class);

	/**
	 * The key value pair list of the BlockKeyValueExpression. 
	 */
	private List<KeyValuePair> keyValuePair;

	/**
	 * Constructs a Weabric 'BlockKeyValueExpression' parse tree node.
	 * @param keyValuePair The key value pair list of the BlockKeyValueExpression. 
	 */
	public BlockKeyValueExpression(List<KeyValuePair> keyValuePair) {
		this.keyValuePair = Collections.unmodifiableList(keyValuePair);
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
		return "{" + Strings.join(",", keyValuePair) + "}";
	}
	
	/**
	 * Transforms the content of this object to the expected output code. 
	 * If necessary this function constructs also the output of the children. 
	 * (It calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		String keyValueBlock = "";
		for (KeyValuePair keyValuePairItem: keyValuePair) {
			keyValueBlock = outputAddToBlock( keyValueBlock, keyValuePairItem.toTransformerOutput() );
		}
		return OUTPUT_KEY_VALUE_BLOCK + outputBracedBlock( outputBracedList( keyValueBlock ) );
	}
}
