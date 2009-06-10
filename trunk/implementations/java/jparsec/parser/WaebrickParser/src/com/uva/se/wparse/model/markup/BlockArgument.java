/*
 * File			: BlockArgument.java
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

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.util.Strings;

/**
 * The weabric parse tree node of the weabric 'BlockArgument' construction. It
 * is an implementation of an expression.
 */
public final class BlockArgument extends WaebricParseTreeNode implements
		Argument {

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(BlockArgument.class);

	/**
	 * A list with arguments.
	 */
	private List<Argument> args = null;

	/**
	 * Constructs a Weabric 'BlockArgument' parse tree node.
	 * 
	 * @param args
	 *            A list with arguments.
	 */
	public BlockArgument(List<Argument> args) {
		this.args = Collections.unmodifiableList(args);
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
		if (args != null) {
			return "{" + Strings.join(" ", args) + "}";
		} else {
			return "{ }";
		}
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		String ArgumentBlock = "";
		for (Argument argument : args) {
			ArgumentBlock = outputAddToBlock(ArgumentBlock, argument
					.toTransformerOutput());
		}
		return ArgumentBlock;
	}
}
