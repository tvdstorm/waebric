/*
 * File			: Mapping.java
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
