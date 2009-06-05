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

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.util.Strings;


public class MarkupArgument extends WaebricParseTreeNode implements Markup {
	
	public static final String OUTPUT_CALL		= "call";
	private static org.apache.log4j.Logger logger = Logger.getLogger(MarkupArgument.class);

	private Designator designator;
	private Argument arguments;
	
	public MarkupArgument(Designator designator, Argument arguments) {
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
		String ArgumentBlock = OUTPUT_ARGUMENTS + outputBracedBlock( outputBracedList( arguments.toTransformerOutput(), true ) );		
		return OUTPUT_CALL + outputBracedBlock( designator.toTransformerOutput() + OUTPUT_BLOCK_SEPARATOR + ArgumentBlock );		
	}	
	
}
