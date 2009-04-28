/*
 * File			: YieldStatement.java
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

import com.uva.se.wparse.model.expression.StringLiteral;

public class YieldStatement implements Statement {

	private StringLiteral yield;

	public YieldStatement(StringLiteral yield) {
		this.yield = yield;
		System.out.println("debug -- inside " + this.getClass().getSimpleName() + " constructor");
	}

	@Override
	public String toString() {
		return yield.toString();
	}
	
	
}
