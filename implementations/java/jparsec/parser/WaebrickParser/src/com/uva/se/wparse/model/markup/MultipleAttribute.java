/*
 * File			: MultipleAttribute.java
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

public class MultipleAttribute implements Attribute  {

	private String width;
	private String height;
	
	public MultipleAttribute(String width, String height) {
		super();
		this.width = width;
		this.height = height;
	}
	
	@Override
	public String toString() {
		if(height == null){
			return "@" + width;
		}else{
			return "@" + width + "%" + height;
		}
	}
	
	
	
}
