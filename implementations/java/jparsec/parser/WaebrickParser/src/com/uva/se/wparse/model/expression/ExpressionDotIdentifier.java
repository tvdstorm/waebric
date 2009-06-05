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

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.parser.Operator;

public final class ExpressionDotIdentifier extends WaebricParseTreeNode implements Expression {
	
	public static final String OUTPUT_FIELD = "field";

	private static org.apache.log4j.Logger logger = Logger.getLogger(ExpressionDotIdentifier.class);
	
	private Identifier identifier = null;
	private Expression expression = null;

	public ExpressionDotIdentifier(Expression expression, Operator op, Expression identifier) {
		if(identifier instanceof Var){
			this.identifier = new Identifier( ((Var)identifier).getIdentifier(), "");	
		}
		
		this.expression = expression;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		return expression + "." + identifier;
	}
	
	@Override
	public String toTransformerOutput() {
		return OUTPUT_FIELD + outputBracedBlock( expression.toTransformerOutput() + OUTPUT_BLOCK_SEPARATOR + identifier.toTransformerOutput() );
	}
}
