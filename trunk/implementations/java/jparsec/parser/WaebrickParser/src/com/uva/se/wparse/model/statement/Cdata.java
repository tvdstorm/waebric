/*
 * File			: CdataStatement.java
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

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.model.expression.Expression;

public class Cdata extends WaebricParseTreeNode implements Statement {

	private static org.apache.log4j.Logger logger = Logger
			.getLogger(Cdata.class);
	
	public static final String OUTPUT_CDATA = "cdata";

	private Expression expr;

	public Cdata(Expression expr) {
		this.expr = expr;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		return "cdata " + expr.toString();
	}
	
	@Override
	public String toTransformerOutput() {
		return OUTPUT_CDATA + outputBracedBlock( expr.toTransformerOutput() );
	}

}