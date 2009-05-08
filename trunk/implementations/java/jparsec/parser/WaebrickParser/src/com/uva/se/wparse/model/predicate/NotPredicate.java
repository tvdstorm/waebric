package com.uva.se.wparse.model.predicate;

import org.apache.log4j.Logger;

public class NotPredicate implements Predicate {

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
	
	
	
}
