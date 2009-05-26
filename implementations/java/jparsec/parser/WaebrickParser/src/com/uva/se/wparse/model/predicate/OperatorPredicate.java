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

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.parser.Operator;

public final class OperatorPredicate extends ValueObject implements Expression, Predicate {

	private static org.apache.log4j.Logger logger = Logger.getLogger(OperatorPredicate.class);

	public final Expression left;
	public final Operator op;
	public final Expression right;

	public OperatorPredicate(Expression left, Operator op, Expression right) {
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
}
