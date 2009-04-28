/*
 * File			: EchoEmbeddingStatement.java
 * Project		: WaebrickParser
 * 				: Practicum opdracht Software Construction
 * 
 * Authors		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * 
 * Description	:
 * 
 */
package com.uva.se.wparse.model.statement;

import com.uva.se.wparse.model.embedding.Embedding;

public class EchoEmbeddingStatement implements Statement {

	
	private Embedding embedding;

	public EchoEmbeddingStatement(Embedding embedding) {
		this.embedding = embedding;
		System.out.println("debug -- inside " + this.getClass().getSimpleName() + " constructor");
	}

	@Override
	public String toString() {
		return embedding.toString();
	}
	
	
}
