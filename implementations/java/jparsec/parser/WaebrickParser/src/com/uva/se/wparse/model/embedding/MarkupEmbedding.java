/*
 * File			: MarkupEmbedding.java
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
package com.uva.se.wparse.model.embedding;

import java.util.List;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.TransformerOutput;
import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.util.Strings;

public class MarkupEmbedding extends WaebricParseTreeNode implements Embedding {
	
	public static final String OUTPUT_EMBEDDING 			= "exp-embedding";
	
	public static final String OUTPUT_EMBEDDING_PRE 		= "pre";
	public static final String OUTPUT_EMBEDDING_POST		= "post";
	
	public static final String OUTPUT_EMBEDDING_PRE_CODE 	= "\"\\\"<\"";
	public static final String OUTPUT_EMBEDDING_POST_CODE	= "(\">\\\"\")";
	
	private static org.apache.log4j.Logger logger = Logger.getLogger(MarkupEmbedding.class);

	private String preText;
	private List<Markup> markup;
	private Object follower;
	private String postText;
	

	public MarkupEmbedding( List<String> preText, List<Markup> markup, Object follower, List<String> postText){ 
		this.preText = Strings.join("", preText);
		this.markup = markup;
		this.follower = follower;
		this.postText = Strings.join("", postText);
		if(logger.isDebugEnabled()){
			logger.debug("Creating " + this.getClass().getSimpleName() + " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		return preText + " < " + Strings.join(" ", markup) + " " + follower + " > " +  postText;	
	}
	
	@Override
	public String toTransformerOutput() {
		String markupList = "";

		for (Markup markupItem: markup) {
			markupList = outputAddToBlock(markupList, markupItem.toTransformerOutput());
		}
		
		String followerItem = "";
		if (follower instanceof TransformerOutput) {
		followerItem = ((TransformerOutput)follower).toTransformerOutput();
		}
		
		return OUTPUT_EMBEDDING_PRE + outputBracedBlock( OUTPUT_EMBEDDING_PRE_CODE + OUTPUT_BLOCK_SEPARATOR + OUTPUT_EMBEDDING + outputBracedBlock( outputBracedList( markupList ) + OUTPUT_BLOCK_SEPARATOR + followerItem ) + OUTPUT_BLOCK_SEPARATOR + OUTPUT_EMBEDDING_POST + OUTPUT_EMBEDDING_POST_CODE )    ;
	}	
}
