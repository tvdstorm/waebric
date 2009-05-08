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
import com.uva.se.wparse.model.expression.BinaryExpression;

public class EchoEmbeddingStatement implements Statement {

	private static org.apache.log4j.Logger logger = Logger.getLogger(EchoEmbeddingStatement.class);
	
	private Embedding embedding;

	public EchoEmbeddingStatement(Embedding embedding) {
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
