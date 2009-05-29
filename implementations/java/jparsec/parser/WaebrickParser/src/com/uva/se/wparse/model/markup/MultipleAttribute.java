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

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.ValueObject;

public class MultipleAttribute extends ValueObject implements Attribute  {
	
	private static org.apache.log4j.Logger logger = Logger.getLogger(MultipleAttribute.class);

	private String width;
	private String height;
	
	public MultipleAttribute(String width, String height) {
		this.width = width;
		this.height = height;
		 if (logger.isDebugEnabled()) {
				logger.debug("Creating " + this.getClass().getSimpleName()
						+ " with values : " + toString());
			}
	}
	
	@Override
	public String toString() {
		if(height == null){
			return "@" + width;
		}else{
			return "@" + width + "%" + height;
		}
	}
	
	@Override
	public String toTransformerOutput() {

		return "MultipleAttribute";
	} 
}
