/*
 * File			: MarkupStatements.java
 * Project		: WaebrickParser
 * 				: Practicum opdracht Software Construction
 * 
 * Authors		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * 
 * Description	:
 * 
 */
package com.uva.se.wparse.model.statement;

import java.util.List;

import com.uva.se.wparse.model.markup.Markup;

public class MarkupStatements implements Statement, Markup {

	private List<Markup> markup;

	public MarkupStatements(List<Markup> markup){ 
		this.markup = markup;
		System.out.println("debug -- inside " + this.getClass().getSimpleName() + " constructor");
	}

	@Override
	public String toString() {
		return markup.toString();
	};
	
	
	
	
	
	
}
