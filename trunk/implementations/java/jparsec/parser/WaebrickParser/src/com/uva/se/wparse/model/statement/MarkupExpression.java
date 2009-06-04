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

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.util.Strings;

public class MarkupExpression extends ValueObject implements Statement, Markup {
	
	public static final String OUTPUT_MARKUP_EXPRESSION = "markup-exp";
	
	private static org.apache.log4j.Logger logger = Logger.getLogger(MarkupExpression.class);

	private Expression expr = null;
	private List<Markup> markupList = new ArrayList<Markup>(); 

	public MarkupExpression(Markup markup, Object tail, Expression expression){ 
		this.markupList.add(markup);
		if(tail instanceof List){
			 List<Markup> tailList = ((List<Markup>)tail); 
			markupList.addAll(tailList);
		}else if(tail instanceof Expression){
			this.expr = (Expression)tail;
		}
		
		if(expression != null){
			this.expr = expression;
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		return Strings.join(" ", markupList) + " " + expr;
	};
	
	@Override
	public String toTransformerOutput() {
		String markupBlock = "";
		for (Markup markupItem: markupList) {
			if (markupItem instanceof ValueObject) {
				markupBlock = outputAddToBlock( markupBlock, ((ValueObject)markupItem).toTransformerOutput() );
			}
		}		
		
		String expressionItem = "";
		if (expr instanceof ValueObject) {
			expressionItem = ((ValueObject)expr).toTransformerOutput();
		}
		
		return OUTPUT_MARKUP_EXPRESSION + outputBracedBlock( outputAddToBlock( outputBracedList( markupBlock ), expressionItem ) ); 
	}
	
	
	
	
}
