/*
 * File			: Designator.java
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

import com.uva.se.wparse.model.statement.AssignmentFormals;


public class Designator implements Markup{
	
	private static org.apache.log4j.Logger logger = Logger.getLogger(Designator.class);

	private String identifier;
	private List<Attribute> attributes;
	
	public Designator(String identifier, List<Attribute> attributes) {
		this.identifier = identifier;
		this.attributes = attributes;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}
	
	@Override
	public String toString() {
		return identifier + " " + attributes;
	}
	
	
}
