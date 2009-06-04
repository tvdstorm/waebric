package com.uva.se.wparse.model.predicate;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.model.expression.Expression;

public class TypeCheckPredicate extends ValueObject implements Predicate {
	
	public static final String OUTPUT_PREDICATE_TYPE_CHECK = "is-a";

	private static org.apache.log4j.Logger logger = Logger.getLogger(TypeCheckPredicate.class);
	
	private String type;
	private Expression expression;
	
	public TypeCheckPredicate(Expression expression, String type) {
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
	
	@Override
	public String toTransformerOutput() {
		String expressionItem = "";
		if (expression instanceof ValueObject) {
			expressionItem = ((ValueObject)expression).toTransformerOutput();
		}		
		
		return OUTPUT_PREDICATE_TYPE_CHECK + outputBracedBlock( expressionItem + OUTPUT_BLOCK_SEPARATOR + type + "-type" );
	}
	
	
}
