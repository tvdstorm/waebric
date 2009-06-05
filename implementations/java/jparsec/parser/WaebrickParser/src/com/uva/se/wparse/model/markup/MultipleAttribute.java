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

import com.uva.se.wparse.model.common.WaebricParseTreeNode;

public class MultipleAttribute extends WaebricParseTreeNode implements Attribute  {
	
	public static final String OUTPUT_ATTRIBUTE_WIDTH_HEIGTH = "width-height";
	public static final String OUTPUT_ATTRIBUTE_WIDTH = "height";
	
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
		
		if ( ( height != null ) && !height.isEmpty() ) {			
			return OUTPUT_ATTRIBUTE_WIDTH_HEIGTH + outputBracedBlock(width + OUTPUT_BLOCK_SEPARATOR + height);
		}
		else
		{
			return OUTPUT_ATTRIBUTE_WIDTH + outputBracedBlock( width );
		}
	} 
}
