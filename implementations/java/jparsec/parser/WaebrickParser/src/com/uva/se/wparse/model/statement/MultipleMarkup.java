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

	private List<Markup> markupList;
	private Markup markup;
	
	public MultipleMarkup(List<List<Markup>> markupList){ 
		// TODO: Add Assert to check markupList.size() >= 2
		
		// Definition is "Markup+ Markup"
		// Split off last Markup
		this.markupList = markupList.get( 0 );
		this.markup = this.markupList.remove( this.markupList.size() - 1 ); 

		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		return markupList.toString() + "," + markup.toString();
	}

	@Override
	public String toTransformerOutput() {
		String MarkupBlock = "";
		for (Markup markupItem: markupList) {			
			if (markupItem instanceof ValueObject) {
				MarkupBlock = outputAddToBlock(MarkupBlock, ((ValueObject)markupItem).toTransformerOutput());
			}			
		}
		
		String markupItem = "";
		if (markup instanceof ValueObject) {
			markupItem = ((ValueObject)markup).toTransformerOutput();
		}
		
		return OUTPUT_MARKUP_MULTIPLE + outputBracedBlock( outputBracedList( MarkupBlock ) + OUTPUT_BLOCK_SEPARATOR + markupItem );
	}	
}
