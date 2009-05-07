/*
 * File			: MarkupExpressionEmbed.java
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
