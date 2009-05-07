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

import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.util.Strings;

public class MarkupEmbedding implements Embedding {

	private String preText;
	private List<Markup> markup;
	private Object follower;
	//private Expression expression;
	private String postText;
	
//	private Object dummy1;
//	private Object dummy2;

	public MarkupEmbedding( List<String> preText, List<Markup> markup, Object follower, List<String> postText){ 
		this.preText = Strings.join("", preText);
		this.markup = markup;
		this.follower = follower;
		//this.expression = expression;
		this.postText = Strings.join("", postText);
		System.out.println("debug -- inside " + this.getClass().getSimpleName() + " constructor");
	}

	@Override
	public String toString() {
		return Strings.join(" " + preText) + " < " + Strings.join(" ", markup) + " " + follower + " > " +  Strings.join(" " + postText);
	
	}
}
