/*
 * File			: AssignmentNormal.java
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

public final class AssignmentNormal extends ValueObject implements Assignment {
	private String left;
	private Expression right;

	public AssignmentNormal(String left, Expression right) {
		this.left = left;
		this.right = right;
		System.out.println("debug -- inside " + this.getClass().getSimpleName()
				+ " constructor");
	}

	@Override
	public String toString() {
		return left + " = " + right;
	}
}
