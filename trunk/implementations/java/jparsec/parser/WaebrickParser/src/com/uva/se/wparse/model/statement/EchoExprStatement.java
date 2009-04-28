/*
 * File			: EchoExprStatement.java
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

import com.uva.se.wparse.model.expression.Expression;

public class EchoExprStatement implements Statement {

	
	private Expression expr;

	public EchoExprStatement(Expression expr) {
		this.expr = expr;
		System.out.println("debug -- inside " + this.getClass().getSimpleName() + " constructor");
	}

	@Override
	public String toString() {
		return expr.toString();
	}
	
	
}
