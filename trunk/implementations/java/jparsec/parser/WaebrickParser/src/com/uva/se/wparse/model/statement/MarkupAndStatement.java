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

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.util.Strings;



public class MarkupAndStatement extends ValueObject implements Statement, Markup {

	private static org.apache.log4j.Logger logger = Logger.getLogger(MarkupAndStatement.class);
	
	private List<Markup> markup;
	private Statement statement;

	public MarkupAndStatement(List<Markup> markup, Statement statement){ 
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
	
	  @Override
	  public String toTransformerOutput() {
		  String Result = "MarkupAndStatement";
		  return Result;
	  } 	
	
	
	
	
}
