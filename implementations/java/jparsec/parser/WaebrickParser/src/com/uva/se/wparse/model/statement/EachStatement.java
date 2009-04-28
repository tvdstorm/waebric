/*
 * File			: EachStatement.java
 * Project		: WaebrickParser
 * 				: Practicum opdracht Software Construction
 * 
 * Authors		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * 
 * Description	:
 * 
 */
package com.uva.se.wparse.model.statement;

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.model.expression.Expression;

public final class EachStatement extends ValueObject implements Statement {
	private String var;
	private Expression expr;
	private Statement stmt;

	public EachStatement(String var, Expression expr, Statement stm) {
		this.var = var;
		this.expr = expr;
		this.stmt = stm;
		System.out.println("debug -- inside " + this.getClass().getSimpleName()
				+ " constructor");
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("each (").append(var).append(": ").append(expr).append(") ").append(stmt);
		return builder.toString();
	}
}
