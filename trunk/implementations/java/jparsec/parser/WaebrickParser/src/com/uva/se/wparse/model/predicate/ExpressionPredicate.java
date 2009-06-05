package com.uva.se.wparse.model.predicate;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.model.expression.Expression;

public class ExpressionPredicate extends WaebricParseTreeNode implements Predicate {
	
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
		return expression.toTransformerOutput();
	}

}
