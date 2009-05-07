/*
 * File			: MarkupEmbed.java
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

public class MarkupEmbed implements Embedding {

	private String id;
	private List<Markup> markup;
	private Object follower;

	public MarkupEmbed(String id, List<Markup> markup, Object follower){ 
		this.id =id;
		this.markup = markup;
		this.follower = follower;
	}

	@Override
	public String toString() {
		return "<" + id + " " + Strings.join(" ", markup) + " " + follower;
	
	}
}
