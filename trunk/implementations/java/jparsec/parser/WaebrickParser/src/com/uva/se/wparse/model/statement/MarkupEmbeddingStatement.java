/*
 * File			: MarkupEmbeddingStatement.java
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

import java.util.List;

import com.uva.se.wparse.model.embedding.Embedding;
import com.uva.se.wparse.model.markup.Markup;

public class MarkupEmbeddingStatement /*extends MarkupStatements*/ implements Statement, Markup {

	private Embedding embedding;
	private List<Markup> markup;

	public MarkupEmbeddingStatement(List<Markup> markup, Embedding embedding){
	//public MarkupEmbeddingStatement( Embedding embedding){ 
		this.markup = markup;
		this.embedding = embedding;
		 System.out.println("debug -- inside " + this.getClass().getSimpleName() + " constructor");
	}

	@Override
	public String toString() {
		return markup + " " + embedding;
	};
	
	
	
	
	
	
}
