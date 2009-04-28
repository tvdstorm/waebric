/*
 * File			: SingleArgument.java
 * Project		: WaebrickParser
 * 				: Practicum opdracht Software Construction
 * 
 * Authors		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * 
 * Description	:
 * 
 */
package com.uva.se.wparse.model.markup;

import com.uva.se.wparse.model.expression.Expression;

public class SingleArgument implements Argument {


	private Expression expression;
	
	
	public SingleArgument( Expression expression) {
		super();
		this.expression = expression;
		System.out.println("debug -- inside " + this.getClass().getSimpleName() + " constructor");
	}


	@Override
	public String toString() {
		return expression.toString();
	}
	
	
	
}
