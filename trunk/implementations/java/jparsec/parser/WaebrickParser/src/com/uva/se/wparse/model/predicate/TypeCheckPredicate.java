package com.uva.se.wparse.model.predicate;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.expression.Expression;

public class TypeCheckPredicate implements Predicate {

	private static org.apache.log4j.Logger logger = Logger.getLogger(TypeCheckPredicate.class);
	
	private String type;
	private Expression expression;
	
	public TypeCheckPredicate(Expression expression, String type) {
		super();
		this.type = type;
		this.expression = expression;
		if(logger.isDebugEnabled()){
			logger.debug("Creating " + this.getClass().getSimpleName() + " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		return expression + "." + type;
	}
	
	
	
}
