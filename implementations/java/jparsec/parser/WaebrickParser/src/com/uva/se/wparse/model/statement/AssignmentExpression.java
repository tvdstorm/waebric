/*
 * File			: AssignmentNormal.java
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
import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.expression.Identifier;

public final class AssignmentExpression extends ValueObject implements Assignment {
	
	public static final String OUTPUT_ASSIGNMENT = "var-bind";
	
	private static org.apache.log4j.Logger logger = Logger.getLogger(AssignmentExpression.class);
	
	
	private Identifier left;
	private Expression right;

	public AssignmentExpression(Identifier left, Expression right) {
		this.left = left;
		this.right = right;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		return left + " = " + right;
	}
	
	@Override
	public String toTransformerOutput() {
		String rightItem = "";
		if (right instanceof ValueObject) {
			rightItem = ((ValueObject)right).toTransformerOutput();
		}		
		
		return OUTPUT_ASSIGNMENT + outputBracedBlock( outputQuote( left ) + OUTPUT_BLOCK_SEPARATOR + rightItem );
	}
}
