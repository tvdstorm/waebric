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

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.embedding.Embedding;
import com.uva.se.wparse.model.markup.Markup;

public class MarkupEmbedding extends MultipleMarkup implements Statement, Markup {
	
	private static org.apache.log4j.Logger logger = Logger.getLogger(MarkupEmbedding.class);

	private Embedding embedding;

	public MarkupEmbedding(List<Markup> markup, Embedding embedding){
		super(markup);
		this.embedding = embedding;
		if(logger.isDebugEnabled()){
			logger.debug("Creating " + this.getClass().getSimpleName() + " with values : " + super.toString() + " " + embedding );
		}
	}

	@Override
	public String toString() {
		return super.toString() + " " + embedding;
	};
	
	
	@Override
	public String toTransformerOutput() {
		return this.getClass().getName();
		
	}
	
	
	
}
