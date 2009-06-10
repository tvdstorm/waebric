/*
 * File			: MarkupAndStatement.java
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

import java.util.List;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.util.Strings;

/**
 * The weabric parse tree node of the weabric 'markup and statement'
 * construction. It is an implementation of a statement.
 */
public class MarkupAndStatement extends WaebricParseTreeNode implements
		Statement, Markup {

	/**
	 * OUTPUT_MARKUPSTAT is used to indicate this construction in the output
	 * process.
	 */
	public static final String OUTPUT_MARKUPSTAT = "markup-stat";

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(MarkupAndStatement.class);

	/**
	 * The list with all the markup.
	 */
	private List<Markup> markup;

	/**
	 * The statement which belongs to the markup.
	 */
	private Statement statement;

	/**
	 * Constructs a Weabric 'Each' parse tree node.
	 * 
	 * @param markup
	 *            The list with all the markup.
	 * @param statement
	 *            The statement which belongs to the markup.
	 */
	public MarkupAndStatement(List<Markup> markup, Statement statement) {
		this.markup = markup;
		this.statement = statement;
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
		return Strings.join(" ", markup) + " " + statement;
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		String MarkupBlock = "";
		for (Markup markupItem : markup) {
			MarkupBlock = outputAddToBlock(MarkupBlock, markupItem
					.toTransformerOutput());
		}

		return OUTPUT_MARKUPSTAT
				+ outputBracedBlock(outputBracedList(MarkupBlock)
						+ OUTPUT_BLOCK_SEPARATOR
						+ statement.toTransformerOutput());
	}
}
