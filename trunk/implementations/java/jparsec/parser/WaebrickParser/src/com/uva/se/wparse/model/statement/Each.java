/*
 * File			: EachStatement.java
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

public final class Each extends ValueObject implements Statement {
	
	public static final String OUTPUT_EACH = "each";

	private static org.apache.log4j.Logger logger = Logger
			.getLogger(Each.class);

	private Identifier identifier;
	private Expression expr;
	private Statement stmt;

	public Each(Identifier identifier, Expression expr, Statement stm) {
		this.identifier = identifier;
		this.expr = expr;
		this.stmt = stm;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("each (").append(identifier).append(": ").append(expr).append(
				") ").append(stmt);
		return builder.toString();
	}
	
	@Override
	public String toTransformerOutput() {
		String ExpressionItem = "";
		if (expr instanceof ValueObject) {
			ExpressionItem = ((ValueObject)expr).toTransformerOutput();
		}
		
		String StatementItem = "";
		if (stmt instanceof ValueObject) {
			StatementItem = ((ValueObject)stmt).toTransformerOutput();
		}
		
		return OUTPUT_EACH + outputBracedBlock( outputQuote( identifier ) + OUTPUT_BLOCK_SEPARATOR + ExpressionItem + OUTPUT_BLOCK_SEPARATOR + StatementItem  );
	}
}
