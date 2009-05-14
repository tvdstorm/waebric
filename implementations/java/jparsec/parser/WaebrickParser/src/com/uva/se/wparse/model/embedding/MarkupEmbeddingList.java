package com.uva.se.wparse.model.embedding;

import java.util.List;

import org.apache.log4j.Logger;

import com.uva.se.wparse.util.Strings;

public class MarkupEmbeddingList implements Embedding {

	private static org.apache.log4j.Logger logger = Logger.getLogger(MarkupEmbeddingList.class);
	
	/*contains a list of MarkupEmbedding objects, if there are more then
	 * 1 items in the list the postText property of the objects ( instead of the last object in the list)
	 * must be treated as midtext.
	 */
	
	private List<Embedding> embedding = null;

	public MarkupEmbeddingList(List<Embedding> embedding) {
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
