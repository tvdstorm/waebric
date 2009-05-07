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
