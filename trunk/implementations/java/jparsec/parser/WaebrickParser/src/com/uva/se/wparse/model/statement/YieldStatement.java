/*
 * File			: YieldStatement.java
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
