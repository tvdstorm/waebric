/*
 * File			: MarkupArgument.java
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
