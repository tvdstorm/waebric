/*
 * File			: SymbolConstant.java
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
package com.uva.se.wparse.model.expression;

import java.util.List;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.util.Strings;

/**
 * The weabric parse tree node of the weabric 'SymbolConstant' construction. It
 * is an implementation of an expression.
 */
public class SymbolConstant extends WaebricParseTreeNode implements Expression {

	/**
	 * OUTPUT_SYMBOL is used to indicate this construction in the output
	 * process.
	 */
	private static final String OUTPUT_SYMBOL = "Constant";

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(SymbolConstant.class);

	/**
	 * The symbol itself.
	 */
	private String symbol;

	/**
	 * Constructs a Weabric 'SymbolConstant' parse tree node.
	 * 
	 * @param symbolParts
	 *            The symbols itself.
	 */
	public SymbolConstant(List<String> symbolParts) {
		this.symbol = Strings.join("", symbolParts);
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
		return "'" + symbol.toString();
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		return OUTPUT_SYMBOL + outputBracedBlock(symbol);
	}
}
