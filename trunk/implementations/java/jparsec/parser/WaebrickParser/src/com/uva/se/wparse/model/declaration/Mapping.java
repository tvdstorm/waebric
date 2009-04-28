/*
 * File			: Mapping.java
 * Project		: WaebrickParser
 * 				: Practicum opdracht Software Construction
 * 
 * Authors		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * 
 * Description	:
 * 
 */
package com.uva.se.wparse.model.declaration;

import java.util.List;

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.util.Strings;

public class Mapping extends ValueObject {

	private List<String> path;
	private String extention;
	private Markup markup;
	
	
	public Mapping(List<String> path, String extention, Markup markup) {
		super();
		this.path = path;
		this.extention = extention;
		this.markup = markup;
	}


	@Override
	public String toString() {
		return Strings.join("/", path) + extention + ":" + markup;
	}
	
	
	
}
