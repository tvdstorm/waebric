package com.uva.se.wparse.model.embedding;

import org.apache.log4j.Logger;

import com.uva.se.wparse.util.Strings;

public class MultipleMarkupEmbedding implements Embedding {

	private static org.apache.log4j.Logger logger = Logger.getLogger(MarkupEmbedding.class);
	
	private Embedding embedding = null;

	public MultipleMarkupEmbedding(Embedding embedding) {
		this.embedding = embedding;
		if(logger.isDebugEnabled()){
			logger.debug("Creating " + this.getClass().getSimpleName() + " with values : " + toString());
		}
	}
	
	
	@Override
	public String toString() {
		return Strings.join("", embedding);
	
	}
	
	
}
