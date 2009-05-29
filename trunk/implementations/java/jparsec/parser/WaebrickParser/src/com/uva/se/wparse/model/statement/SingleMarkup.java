/*
 * File			: MarkupStatement.java
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

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.model.markup.Markup;



public class SingleMarkup extends ValueObject implements Statement, Markup {
	
	public static final String OUTPUT_MARKUP = "markup";
	
	private static org.apache.log4j.Logger logger = Logger.getLogger(SingleMarkup.class);

	private Markup markup;

	public SingleMarkup(Markup markup){ 
		this.markup = markup;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		return markup.toString();
	};
	
	@Override
	public String toTransformerOutput() {
        String Result = "";
        if (markup instanceof ValueObject) {
        	Result = ((ValueObject)markup).toTransformerOutput();
        }		
		return OUTPUT_MARKUP + outputBracedBlock( Result );
	} 
	
	
	
	
}
