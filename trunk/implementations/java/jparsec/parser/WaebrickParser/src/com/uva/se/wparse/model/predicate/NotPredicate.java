package com.uva.se.wparse.model.predicate;

import org.apache.log4j.Logger;
import com.uva.se.wparse.model.common.WaebricParseTreeNode;

public class NotPredicate extends WaebricParseTreeNode implements Predicate {
	
	public static final String OUTPUT_PREDICATE_NEGATION = "not";

	private static org.apache.log4j.Logger logger = Logger.getLogger(NotPredicate.class);
	
	private Predicate predicate;
	
	public NotPredicate(Predicate predicate) {
		this.predicate = predicate;
		if(logger.isDebugEnabled()){
			logger.debug("Creating " + this.getClass().getSimpleName() + " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		return "!" + predicate;
	}
	
	@Override
	public String toTransformerOutput() {
		return OUTPUT_PREDICATE_NEGATION + outputBracedBlock( predicate.toTransformerOutput() );
	}	
}
