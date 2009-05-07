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

import com.uva.se.wparse.model.markup.Markup;



public class MarkupStatement implements Statement, Markup {

	private Markup markup;

	public MarkupStatement(Markup markup){ 
		this.markup = markup;
		 System.out.println("debug -- inside " + this.getClass().getSimpleName() + " constructor");
	}

	@Override
	public String toString() {
		return markup.toString();
	};
	
	
	
	
	
	
}
