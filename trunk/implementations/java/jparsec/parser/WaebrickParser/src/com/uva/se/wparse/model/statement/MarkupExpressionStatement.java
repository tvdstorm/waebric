/*
 * File			: MarkupExpressionStatement.java
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

import java.util.List;

import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.markup.Markup;

public class MarkupExpressionStatement extends MarkupStatements implements Statement, Markup {

	private Expression expr;

	public MarkupExpressionStatement(List<Markup> markup, Expression expr){ 
		super(markup);
		this.expr = expr;
		System.out.println("debug -- inside " + this.getClass().getSimpleName() + " constructor");
	}

	@Override
	public String toString() {
		return super.toString() + " " + expr;
	};
	
	
	
	
	
	
}
