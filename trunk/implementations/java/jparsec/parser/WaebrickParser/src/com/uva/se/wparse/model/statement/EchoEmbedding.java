/*
 * File			: EchoEmbeddingStatement.java
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
package com.uva.se.wparse.model.statement;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.embedding.Embedding;
import com.uva.se.wparse.model.predicate.OperatorPredicate;

public class EchoEmbedding implements Statement {

	private static org.apache.log4j.Logger logger = Logger.getLogger(EchoEmbedding.class);
	
	private Embedding embedding;

	public EchoEmbedding(Embedding embedding) {
		this.embedding = embedding;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		return embedding.toString();
	}
	
	
}
