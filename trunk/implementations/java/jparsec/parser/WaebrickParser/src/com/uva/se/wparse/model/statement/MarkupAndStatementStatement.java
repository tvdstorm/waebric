/*
 * File			: MarkupAndStatementStatement.java
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

import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.util.Strings;



public class MarkupAndStatementStatement implements Statement, Markup {

	private static org.apache.log4j.Logger logger = Logger.getLogger(MarkupAndStatementStatement.class);
	
	private List<Markup> markup;
	private Statement statement;

	public MarkupAndStatementStatement(List<Markup> markup, Statement statement){ 
		this.markup = markup;
		this.statement = statement;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		return Strings.join(" ", markup) + " " + statement;
	};
	
	
	
	
	
	
}
