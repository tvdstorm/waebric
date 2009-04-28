/*
 * File			: MarkupArgument.java
 * Project		: WaebrickParser
 * 				: Practicum opdracht Software Construction
 * 
 * Authors		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * 
 * Description	:
 * 
 */
package com.uva.se.wparse.model.markup;

import java.util.List;

import com.uva.se.wparse.util.Strings;


public class MarkupArgument implements Markup {

	private List<Designator> designator;
	private Argument arguments;
	
	public MarkupArgument(List<Designator> designator, Argument arguments) {
		super();
		this.designator = designator;
		this.arguments = arguments;
	}


	@Override
	public String toString() {
		return Strings.join(" ", designator) + " " + arguments;
	}
	
	
	
}
