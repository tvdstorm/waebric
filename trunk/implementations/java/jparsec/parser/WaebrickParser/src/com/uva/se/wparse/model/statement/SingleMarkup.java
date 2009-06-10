/*
 * File			: MarkupStatement.java
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
import com.uva.se.wparse.model.markup.Markup;

/**
 * The weabric parse tree node of the weabric 'SingleMarkup' construction. It is
 * an implementation of a statement.
 */
public class SingleMarkup extends WaebricParseTreeNode implements Statement,
		Markup {

	/**
	 * OUTPUT_MARKUP is used to indicate this construction in the output
	 * process.
	 */
	public static final String OUTPUT_MARKUP = "markup";
	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(SingleMarkup.class);

	/**
	 * The markup of the SingleMarkup construction.
	 */
	private Markup markup;

	/**
	 * Constructs a Weabric 'SingleMarkup' parse tree node.
	 * 
	 * @param markup
	 *            The markup of the SingleMarkup construction.
	 */
	public SingleMarkup(Markup markup) {
		this.markup = markup;
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
		return markup.toString();
	};

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		return OUTPUT_MARKUP + outputBracedBlock(markup.toTransformerOutput());
	}
}
