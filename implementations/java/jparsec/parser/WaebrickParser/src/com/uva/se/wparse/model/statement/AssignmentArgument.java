/*
 * File			: AssignmentArgument.java
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

import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.markup.Argument;

public class AssignmentArgument implements Argument {

	private String var;
	private Expression expression;
	
	
	public AssignmentArgument(String var, Expression expression) {
		super();
		this.var = var;
		this.expression = expression;
	}


	@Override
	public String toString() {
		return var + " = " + expression;
	}
	
	
	
}
