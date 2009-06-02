package com.uva.se.wparse.model.predicate;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.model.expression.Expression;

public class ExpressionPredicate extends ValueObject implements Predicate {
	
	public static final String OUTPUT_PREDICATE = "pred";
	
	private static org.apache.log4j.Logger logger = Logger.getLogger(ExpressionPredicate.class);
	
	private Expression expression = null;
	
	public ExpressionPredicate(Expression expression) {
		this.expression = expression;
		if(logger.isDebugEnabled()){
			logger.debug("Creating " + this.getClass().getSimpleName() + " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		return expression.toString();
	}
	
	@Override
	public String toTransformerOutput() {
		String expressionItem = "";
		if (expression instanceof ValueObject) {
			expressionItem = ((ValueObject)expression).toTransformerOutput();
		}
		return OUTPUT_PREDICATE + outputBracedBlock( expressionItem );
	}

}
