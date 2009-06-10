/*
 * File			: MarkupEmbedding.java
 * Project		: WaebrickParser2
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

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.markup.Designator;
import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.util.ConversionUtil;
import com.uva.se.wparse.util.Strings;

public class MarkupEmbedding extends WaebricParseTreeNode implements Embedding {
	
	public static final String OUTPUT_EXP_EMBEDDING 		= "exp-embedding";
	public static final String OUTPUT_MARKUP_EMBEDDING 		= "markup-embedding";
	
	public static final String OUTPUT_EMBEDDING_PRE 		= "pre";
	public static final String OUTPUT_EMBEDDING_POST		= "post";
	
	public static final String OUTPUT_EMBEDDING_PRE_CODE 	= "\"\\\"<\"";
	public static final String OUTPUT_EMBEDDING_POST_CODE	= "(\">\\\"\")";
	
	private static org.apache.log4j.Logger logger = Logger.getLogger(MarkupEmbedding.class);

	private String preText = null;
	private List<Markup> markup = null;
	private String postText = null;
	
	private Expression expression = null;
	

	public MarkupEmbedding( List<String> preText, List<Markup> markup, Object follower, List<String> postText){ 
		this.preText = Strings.join("", preText);
		this.markup = markup;
		if(follower instanceof Markup){
			this.markup.add( (Markup) follower);
		}else if(follower instanceof Expression){
			this.expression = (Expression) follower;
		}
		
		if(this.markup.size() > 1){
			Markup lastMarkupItem = this.markup.get(this.markup.size()-1);
			if(lastMarkupItem instanceof Designator){
				
				Designator designator = (Designator) this.markup.remove(this.markup.size()-1);
				this.expression = ConversionUtil.designatorToExpression( designator);
			}
		}
		
		this.postText = Strings.join("", postText);
		if(logger.isDebugEnabled()){
			logger.debug("Creating " + this.getClass().getSimpleName() + " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		return preText + " < " + Strings.join(" ", markup) + " " + expression + " > " +  postText;	
	}
	
	@Override
	public String toTransformerOutput() {

		
		String followerItem = "";
		if (expression != null){
			followerItem = expression.toTransformerOutput();
		}
		else {
			followerItem = markup.remove( markup.size() - 1 ).toTransformerOutput();
		}
		
		String markupList = "";

		for (Markup markupItem: markup) {
			markupList = outputAddToBlock(markupList, markupItem.toTransformerOutput());
		}
		
		
		if ( expression != null ) {			
			return OUTPUT_EMBEDDING_PRE + outputBracedBlock( OUTPUT_EMBEDDING_PRE_CODE + OUTPUT_BLOCK_SEPARATOR + OUTPUT_EXP_EMBEDDING + outputBracedBlock( outputBracedList( markupList ) + OUTPUT_BLOCK_SEPARATOR + followerItem ) + OUTPUT_BLOCK_SEPARATOR + OUTPUT_EMBEDDING_POST + OUTPUT_EMBEDDING_POST_CODE )    ;
		}
		else {		
			return OUTPUT_EMBEDDING_PRE + outputBracedBlock( OUTPUT_EMBEDDING_PRE_CODE + OUTPUT_BLOCK_SEPARATOR + OUTPUT_MARKUP_EMBEDDING + outputBracedBlock( outputBracedList( markupList ) + OUTPUT_BLOCK_SEPARATOR + followerItem ) + OUTPUT_BLOCK_SEPARATOR + OUTPUT_EMBEDDING_POST + OUTPUT_EMBEDDING_POST_CODE )    ; 
		}
		
	}	
}
