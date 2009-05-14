/*
 * File			: MarkupExpressionStatement.java
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

import java.util.List;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.markup.Markup;

public class MarkupExpression extends MultipleMarkup implements Statement, Markup {
	
	private static org.apache.log4j.Logger logger = Logger.getLogger(MarkupExpression.class);

	private Expression expr;

	public MarkupExpression(List<Markup> markup, Expression expr){ 
		super(markup);
		this.expr = expr;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		return super.toString() + " " + expr;
	};
	
	
	
	
	
	
}
