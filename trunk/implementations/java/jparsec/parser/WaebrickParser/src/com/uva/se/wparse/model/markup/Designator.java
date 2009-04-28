/*
 * File			: Designator.java
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
