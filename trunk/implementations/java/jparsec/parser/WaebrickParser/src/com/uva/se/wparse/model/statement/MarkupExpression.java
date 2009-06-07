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

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.expression.ExpressionDotIdentifier;
import com.uva.se.wparse.model.expression.Identifier;
import com.uva.se.wparse.model.expression.NaturalConstant;
import com.uva.se.wparse.model.expression.SymbolConstant;
import com.uva.se.wparse.model.expression.Var;
import com.uva.se.wparse.model.markup.Attribute;
import com.uva.se.wparse.model.markup.Designator;
import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.model.markup.SingleAttribute;
import com.uva.se.wparse.parser.Operator;
import com.uva.se.wparse.util.ConversionUtil;
import com.uva.se.wparse.util.Strings;

/**
 * If expression is not null then the output is a "markup-exp"
 * otherwise the output is a "markup-markup"
 * 
 * @author maarten
 *
 */
public class MarkupExpression extends WaebricParseTreeNode implements Statement, Markup {
	
	public static final String OUTPUT_MARKUP_EXPRESSION = "markup-exp";
	
	public static final String OUTPUT_MARKUP_MARKUP 	= "markup-markup";
	
	private static org.apache.log4j.Logger logger = Logger.getLogger(MarkupExpression.class);

	private Expression expr = null;
	private List<Markup> markupList = new ArrayList<Markup>(); 


	public MarkupExpression(List<Markup> markup, Expression expression){ 
		this.markupList.addAll(markup);
		
		/**
		 * Limitions of Jparsec make it impossible to recognise a list of markup and a following expression
		 * if the expression can also be parsed as a designator
		 * example: "designator1 designator2 var1" in this example Jparsec cannot recognize var1
		 * as a Var ( expression) and will parse as markup
		 * 
		 * The following code checks if the last item in the markup list is a designator
		 * if so then it is converted to a Var.
		 * 
		 */
		if(expression == null){
			//get the last designator and make it a expression var
			Markup lastMarkupItem = this.markupList.get(this.markupList.size()-1);
			if(lastMarkupItem instanceof Designator){
				Designator designator = (Designator) this.markupList.remove(this.markupList.size()-1);
				
				this.expr = ConversionUtil.designatorToExpression( designator);
			}
		}else{
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
		
		String markupItem = "";
		// if this is a markup markup, the last markupItem has to be isolated from the list
		if ( expr == null ) {
			markupItem = markupList.remove( ( markupList.size() - 1 ) ).toTransformerOutput();
		}
		
		String markupBlock = "";
		for (Markup markup: markupList) {
			markupBlock = outputAddToBlock( markupBlock, markup.toTransformerOutput() );
		}

		if ( expr != null ) {			
			return OUTPUT_MARKUP_EXPRESSION + outputBracedBlock( outputAddToBlock( outputBracedList( markupBlock ), expr.toTransformerOutput() ) );
		}
		else {		
			return OUTPUT_MARKUP_MARKUP + outputBracedBlock( outputAddToBlock( outputBracedList( markupBlock ), markupItem ) ); 
		}
	}
	
}
