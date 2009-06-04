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

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.util.Strings;


public class MarkupArgument extends ValueObject implements Markup {
	
	public static final String OUTPUT_CALL		= "call";
	private static org.apache.log4j.Logger logger = Logger.getLogger(MarkupArgument.class);

	private List<Designator> designator;
	private Argument arguments;
	
	public MarkupArgument(List<Designator> designator, Argument arguments) {
		this.designator = designator;
		this.arguments = arguments;
		 if (logger.isDebugEnabled()) {
				logger.debug("Creating " + this.getClass().getSimpleName()
						+ " with values : " + toString());
			}
	}


	@Override
	public String toString() {
		return Strings.join(" ", designator) + " " + arguments;
	}
	
	@Override
	public String toTransformerOutput() {		
		
		String DesignatorBlock = "";
		for (Designator designatorItem: designator){
			if (designatorItem instanceof ValueObject) {
				DesignatorBlock = DesignatorBlock + ((ValueObject)designatorItem).toTransformerOutput();
			}
		}
		
		String ArgumentBlock = "";
		if (arguments instanceof ValueObject) {
			ArgumentBlock = ((ValueObject)arguments).toTransformerOutput();
		}
		ArgumentBlock = OUTPUT_ARGUMENTS + outputBracedBlock( OUTPUT_LIST_BEGIN + ArgumentBlock + OUTPUT_LIST_END );
		
		return OUTPUT_CALL + outputBracedBlock( DesignatorBlock + OUTPUT_BLOCK_SEPARATOR + ArgumentBlock );		
	}	
	
}
