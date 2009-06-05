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

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.model.embedding.Embedding;
import com.uva.se.wparse.model.markup.Markup;

public class MarkupEmbedding extends WaebricParseTreeNode implements Statement, Markup {
	
	public static final String OUTPUT_MARKUP_EMBEDDING = "markup-embedding";
	
	private static org.apache.log4j.Logger logger = Logger.getLogger(MarkupEmbedding.class);

	private List<Markup> markup;
	private Embedding embedding;

	public MarkupEmbedding(List<Markup> markup, Embedding embedding){
		this.markup = markup;
		this.embedding = embedding;
		if(logger.isDebugEnabled()){
			logger.debug("Creating " + this.getClass().getSimpleName() + " with values : " + super.toString() + " " + embedding );
		}
	}

	@Override
	public String toString() {
		return markup.toString() + " " + embedding;
	};
	
	
	@Override
	public String toTransformerOutput() {
		String markupList = "";
		for (Markup markupItem: markup) {
			markupList = outputAddToBlock(markupList, markupItem.toTransformerOutput());
		}
		
		return OUTPUT_MARKUP_EMBEDDING + outputBracedBlock( outputAddToBlock( outputBracedList( markupList ), embedding.toTransformerOutput() ) ); 
	}
	
	
	
}
