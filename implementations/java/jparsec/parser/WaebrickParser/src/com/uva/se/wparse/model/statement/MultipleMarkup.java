/*
 * File			: MarkupStatements.java
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
package com.uva.se.wparse.model.statement;

import java.util.List;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.model.markup.Markup;

public class MultipleMarkup extends ValueObject implements Statement, Markup {
	
	public static final String OUTPUT_MARKUP_MULTIPLE 	= "markup-markup";
	
	private static org.apache.log4j.Logger logger = Logger.getLogger(MultipleMarkup.class);

	private List<Markup> markup;

	public MultipleMarkup(List<Markup> markup){ 
		this.markup = markup;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}
	
	

	@Override
	public String toString() {
		return markup.toString();
	}



	@Override
	public String toTransformerOutput() {
		String MarkupBlock = "";		
		for (Markup markupItem: markup) {
			if (markupItem instanceof ValueObject) {
				MarkupBlock = outputAddToBlock(MarkupBlock, ((ValueObject)markupItem).toTransformerOutput());
			}
		}
		
		return OUTPUT_MARKUP_MULTIPLE + outputBracedBlock( outputBracedList( MarkupBlock ) );
	}
	
}
