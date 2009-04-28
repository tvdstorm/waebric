/*
 * File			: MarkupAndStatementStatement.java
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
import com.uva.se.wparse.util.Strings;



public class MarkupAndStatementStatement implements Statement, Markup {

	private List<Markup> markup;
	private Statement statement;

	public MarkupAndStatementStatement(List<Markup> markup, Statement statement){ 
		this.markup = markup;
		this.statement = statement;
		System.out.println("debug -- inside " + this.getClass().getSimpleName() + " constructor");
	}

	@Override
	public String toString() {
		return Strings.join(" ", markup) + " " + statement;
	};
	
	
	
	
	
	
}
