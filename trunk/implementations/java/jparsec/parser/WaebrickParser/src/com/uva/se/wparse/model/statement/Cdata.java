/*
 * File			: Cdata.java
 * Project		: WaebrickParser2
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

/**
 * Create a CData object. The contents of a CData object is ignored by the
 * parser.
 */
public class Cdata extends WaebricParseTreeNode implements Statement {

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(Cdata.class);

	/**
	 * A description of output cdata which is used while generating the output
	 * of the parsing process.
	 */
	private static final String OUTPUT_CDATA = "cdata";

	/**
	 * The contents of the CData object.
	 */
	private Expression expr;

	/**
	 * Constructs a Cdata object with the contents.
	 * 
	 * @param expr
	 *            The contents of the CData object.
	 */
	public Cdata(Expression expr) {
		this.expr = expr;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	/**
	 * Presents this object as a string representation.
	 */
	@Override
	public String toString() {
		return "cdata " + expr.toString();
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		return OUTPUT_CDATA + outputBracedBlock(expr.toTransformerOutput());
	}

}
