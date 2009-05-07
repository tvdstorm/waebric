/*
 * File			: Designator.java
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


public class Designator implements Markup{

	private String identifier;
	private List<Attribute> attributes;
	
	public Designator(String identifier, List<Attribute> attributes) {
		super();
		this.identifier = identifier;
		this.attributes = attributes;
	}
	
	@Override
	public String toString() {
		return identifier + " " + attributes;
	}
	
	
}
