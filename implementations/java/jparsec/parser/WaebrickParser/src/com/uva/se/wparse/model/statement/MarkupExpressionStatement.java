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

public class MarkupExpressionStatement extends MarkupStatements implements Statement, Markup {
	
	private static org.apache.log4j.Logger logger = Logger.getLogger(MarkupExpressionStatement.class);

	private Expression expr;

	public MarkupExpressionStatement(List<Markup> markup, Expression expr){ 
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
