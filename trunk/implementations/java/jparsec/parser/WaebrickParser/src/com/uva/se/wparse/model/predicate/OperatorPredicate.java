/*
 * File			: BinaryExpression.java
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
package com.uva.se.wparse.model.predicate;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.parser.Operator;

public final class OperatorPredicate extends WaebricParseTreeNode implements Expression, Predicate {
	
	public static final String OUTPUT_OPERATOR_PREDICATE 		= "pred-op";
	
	public static final String OUTPUT_OPERATOR_PREDICATE_AND 	= "and";
	public static final String OUTPUT_OPERATOR_PREDICATE_OR 	= "or";

	private static org.apache.log4j.Logger logger = Logger.getLogger(OperatorPredicate.class);

	public final Predicate left;
	public final Operator op;
	public final Predicate right;

	public OperatorPredicate(Predicate left, Operator op, Predicate right) {
		this.left = left;
		this.op = op;
		this.right = right;
		if(logger.isDebugEnabled()){
			logger.debug("Creating " + this.getClass().getSimpleName() + " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		return left.toString() + " " + op.toString() + " " + right.toString();
	}
	
	@Override
	public String toTransformerOutput() {
		String outputType = "";
		
		switch (op) {
			case AND:
				outputType = OUTPUT_OPERATOR_PREDICATE_AND;
				break;
			case OR:
				outputType = OUTPUT_OPERATOR_PREDICATE_OR;
				break;
			default:
				outputType = OUTPUT_OPERATOR_PREDICATE;
				break;	
		}		
		
		return outputType + outputBracedBlock(left.toTransformerOutput() + OUTPUT_BLOCK_SEPARATOR + right.toTransformerOutput());
	}
}