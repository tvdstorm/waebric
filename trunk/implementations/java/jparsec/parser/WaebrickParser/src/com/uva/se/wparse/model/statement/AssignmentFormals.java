/*
 * File			: AssignmentWithFormals.java
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

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.util.Strings;

public final class AssignmentFormals extends ValueObject implements	Assignment {
	
	private static org.apache.log4j.Logger logger = Logger.getLogger(AssignmentFormals.class);
	
	
	private String identifier;
	private ArrayList<String> formals;
	private Statement statement;

	public AssignmentFormals(String identifier, ArrayList<String> formals,
			Statement statement) {
		this.identifier = identifier;
		this.formals = formals;
		this.statement = statement;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		return identifier + " ( " + Strings.join(",", formals) + " ) = " + statement;
	}
	
	@Override
	public String toTransformerOutput() {
		return "AssignmentFormals";
	}
}
