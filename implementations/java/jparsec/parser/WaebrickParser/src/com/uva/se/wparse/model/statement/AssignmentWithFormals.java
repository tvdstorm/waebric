/*
 * File			: AssignmentWithFormals.java
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

import java.util.ArrayList;

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.util.Strings;

public final class AssignmentWithFormals extends ValueObject implements	Assignment {
	private String identifier;
	private ArrayList<String> formals;
	private Statement statement;

	public AssignmentWithFormals(String identifier, ArrayList<String> formals,
			Statement statement) {
		this.identifier = identifier;
		this.formals = formals;
		this.statement = statement;
		System.out.println("debug -- inside " + this.getClass().getSimpleName()	+ " constructor");
	}

	@Override
	public String toString() {
		return identifier + " ( " + Strings.join(",", formals) + " ) = " + statement;
	}
}
