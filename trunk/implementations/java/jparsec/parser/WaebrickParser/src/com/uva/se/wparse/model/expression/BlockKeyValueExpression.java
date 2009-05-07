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

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.util.Strings;

public final class BlockKeyValueExpression extends ValueObject implements
		Expression {

	private static org.apache.log4j.Logger logger = Logger
			.getLogger(BlockKeyValueExpression.class);

	private List<KeyValuePair> keyValuePair;

	public BlockKeyValueExpression(List<KeyValuePair> keyValuePair) {
		this.keyValuePair = Collections.unmodifiableList(keyValuePair);
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		return "{" + Strings.join(",", keyValuePair) + "}";
	}
}
