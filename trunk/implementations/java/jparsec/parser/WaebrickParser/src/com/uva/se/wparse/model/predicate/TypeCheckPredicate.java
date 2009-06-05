package com.uva.se.wparse.model.predicate;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.model.expression.Expression;

public class TypeCheckPredicate extends WaebricParseTreeNode implements Predicate {
	
	public static final String OUTPUT_PREDICATE_TYPE_CHECK 		= "is-a";
	public static final String OUTPUT_PREDICATE_TYPE_POSTFIX 	= "-type";

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
		return OUTPUT_PREDICATE_TYPE_CHECK + outputBracedBlock( expression.toTransformerOutput() + OUTPUT_BLOCK_SEPARATOR + type + OUTPUT_PREDICATE_TYPE_POSTFIX );
	}
	
	
}
