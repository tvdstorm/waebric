/*
 * File			: IdentDotExpression.java
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

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.parser.Operator;

public final class ExpressionDotIdentifier extends ValueObject implements Expression {
	
	public static final String OUTPUT_FIELD = "field";

	private static org.apache.log4j.Logger logger = Logger
			.getLogger(ExpressionDotIdentifier.class);
	private Expression identifier;
	private Expression expr;

	public ExpressionDotIdentifier(Expression identifier, Operator op, Expression expr) {
		this.identifier = identifier;
		this.expr = expr;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		return expr + "." + identifier;
	}
	
	@Override
	public String toTransformerOutput() {
		String identifierItem = "";
		if (identifier instanceof ValueObject) {
			identifierItem = ((ValueObject)identifier).toTransformerOutput();
		}		
		
		String expressionItem = "";
		if (expr instanceof ValueObject) {
			expressionItem = ((ValueObject)expr).toTransformerOutput();
		}		
		
		return OUTPUT_FIELD + outputBracedBlock( identifierItem + OUTPUT_BLOCK_SEPARATOR + expressionItem );
	}
}
