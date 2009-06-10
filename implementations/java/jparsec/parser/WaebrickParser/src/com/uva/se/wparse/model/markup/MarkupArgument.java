/*
 * File			: MarkupArgument.java
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
package com.uva.se.wparse.model.markup;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.util.Strings;

/**
 * The weabric parse tree node of the weabric 'MarkupArgument' construction. It
 * is an implementation of an expression.
 */
public class MarkupArgument extends WaebricParseTreeNode implements Markup {

	/**
	 * OUTPUT_CALL is used to indicate this construction in the output process.
	 */
	private static final String OUTPUT_CALL = "call";

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(MarkupArgument.class);

	/**
	 * The designator of the MarkupArgument.
	 */
	private Designator designator;

	/**
	 * The arguments of the MarkupArgument.
	 */
	private Argument arguments;

	/**
	 * Constructs a Weabric 'MarkupArgument' parse tree node.
	 * 
	 * @param designator
	 *            The designator of the MarkupArgument.
	 * @param arguments
	 *            The arguments of the MarkupArgument.
	 */
	public MarkupArgument(Designator designator, Argument arguments) {
		this.designator = designator;
		this.arguments = arguments;
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
		return Strings.join(" ", designator) + " " + arguments;
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		String ArgumentBlock = OUTPUT_ARGUMENTS
				+ outputBracedBlock(outputBracedList(arguments
						.toTransformerOutput(), true));
		return OUTPUT_CALL
				+ outputBracedBlock(designator.toTransformerOutput()
						+ OUTPUT_BLOCK_SEPARATOR + ArgumentBlock);
	}

}
