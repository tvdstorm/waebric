/*
 * File			: SingleArgument.java
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

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.model.expression.Expression;

public class SingleArgument extends ValueObject implements Argument {

	private static org.apache.log4j.Logger logger = Logger.getLogger(SingleArgument.class);
	private Expression expression;
	
	
	public SingleArgument( Expression expression) {
		this.expression = expression;
		 if (logger.isDebugEnabled()) {
				logger.debug("Creating " + this.getClass().getSimpleName()
						+ " with values : " + toString());
			}
	}


	@Override
	public String toString() {
		return expression.toString();
	}
	
	@Override
	public String toTransformerOutput() {
		String Result = "";
		if (expression instanceof ValueObject) {
			Result = ((ValueObject)expression).toTransformerOutput();			
		}		
		
		return Result;
	} 	
	
}
