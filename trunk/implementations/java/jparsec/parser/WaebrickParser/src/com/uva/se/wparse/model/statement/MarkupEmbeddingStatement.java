/*
 * File			: MarkupEmbeddingStatement.java
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

import java.util.List;

import com.uva.se.wparse.model.embedding.Embedding;
import com.uva.se.wparse.model.markup.Markup;

public class MarkupEmbeddingStatement extends MarkupStatements implements Statement, Markup {

	private Embedding embedding;

	public MarkupEmbeddingStatement(List<Markup> markup, Embedding embedding){ 
		super(markup);
		this.embedding = embedding;
		 System.out.println("debug -- inside " + this.getClass().getSimpleName() + " constructor");
	}

	@Override
	public String toString() {
		return super.toString() + " " + embedding;
	};
	
	
	
	
	
	
}
