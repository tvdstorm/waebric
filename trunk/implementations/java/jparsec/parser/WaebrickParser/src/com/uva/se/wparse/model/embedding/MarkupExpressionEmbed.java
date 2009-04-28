/*
 * File			: MarkupExpressionEmbed.java
 * Project		: WaebrickParser
 * 				: Practicum opdracht Software Construction
 * 
 * Authors		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * 
 * Description	:
 * 
 */
package com.uva.se.wparse.model.embedding;

import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.markup.Markup;

public class MarkupExpressionEmbed implements Embedding {

	private Markup markup;
	private Expression expr;
	
	
	public MarkupExpressionEmbed(Markup markup, Expression expr) {
		super();
		this.markup = markup;
		this.expr = expr;
	}


	@Override
	public String toString() {
		return markup.toString() + " " + expr;
	}
	
	
}
