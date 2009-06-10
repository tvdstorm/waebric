/*
 * File			: StringLiteral.java
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
package com.uva.se.wparse.model.expression;

import java.util.List;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.util.Strings;

/**
 * The weabric parse tree node of the weabric 'StringLiteral' construction. It
 * is an implementation of an expression.
 */
public final class StringLiteral extends WaebricParseTreeNode implements
		Expression {

	/**
	 * OUTPUT_EACH is used to indicate this construction in the output process.
	 */
	private static final String OUTPUT_TEXT = "text";

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(StringLiteral.class);

	/**
	 * The string itself.
	 */
	private String string;

	/**
	 * Constructs a Weabric 'StringLiteral' parse tree node.
	 * 
	 * @param strings
	 *            The string itself.
	 */
	public StringLiteral(List<String> strings) {
		this.string = Strings.join("", strings);
		if (logger.isDebugEnabled()) {
			logger.debug("Creating String literal with value : " + string);
		}
	}

	/**
	 * Presents this object as a string representation.
	 */
	@Override
	public String toString() {
		return string;
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		return OUTPUT_TEXT + outputBracedBlock(outputLiteralQuote(string));
	}
}
