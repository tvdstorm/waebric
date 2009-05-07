/*
 * File			: StringLiteral.java
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

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.util.Strings;

public final class StringLiteral extends ValueObject implements Expression {
	
	private static org.apache.log4j.Logger logger = Logger.getLogger(StringLiteral.class);

	private String string;

	public StringLiteral(List<String> strings) {
		this.string = Strings.join("", strings);
		if(logger.isDebugEnabled()){
			logger.debug("Creating String literal with value : " + string);
		}
	}

	@Override
	public String toString() {
		return string;
	}
}
