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
package com.uva.se.wparse.model.markup;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.expression.Identifier;

public class AssignmentArgument extends WaebricParseTreeNode implements Argument {

	private static org.apache.log4j.Logger logger = Logger.getLogger(AssignmentArgument.class);
	
	public static final String OUTPUT_ASSIGNMENT = "var-bind";
	
	private Identifier identifier;
	private Expression expression;
	
	
	public AssignmentArgument(Identifier identifier, Expression expression) {
		this.identifier = identifier;
		this.expression = expression;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}


	@Override
	public String toString() {
		return identifier + " = " + expression;
	}
	
	@Override
	public String toTransformerOutput() {
		String expressionItem = expression.toTransformerOutput();
		if (expression instanceof Identifier){
			expressionItem = outputBracedBlock( expressionItem );
		}
		
		return OUTPUT_ATTRIBUTE + outputBracedBlock( outputQuote( identifier ) + OUTPUT_BLOCK_SEPARATOR + expressionItem );
	}
	
	
	
}
