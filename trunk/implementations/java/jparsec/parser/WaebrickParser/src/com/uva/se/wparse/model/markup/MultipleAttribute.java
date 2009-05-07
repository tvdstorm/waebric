/*
 * File			: MultipleAttribute.java
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
