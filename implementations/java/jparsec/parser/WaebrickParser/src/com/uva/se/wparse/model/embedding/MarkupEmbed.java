/*
 * File			: MarkupEmbed.java
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
package com.uva.se.wparse.model.embedding;

import java.util.List;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.TransformerOutput;
import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.util.Strings;

/**
 * The weabric parse tree node of the weabric 'MarkupEmbed' construction. It is
 * an implementation of embedding weabric parts.
 */
public class MarkupEmbed extends WaebricParseTreeNode implements Embedding {

	/**
	 * OUTPUT_MARKUPEMBED is used to indicate this construction in the output
	 * process.
	 */
	private static final String OUTPUT_MARKUPEMBED = "markup-embed";

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(MarkupEmbed.class);

	/**
	 * The id part of the embedded markup.
	 */
	private String id;

	/**
	 * The markup part of the embedded markup.
	 */
	private List<Markup> markup;

	/**
	 * The follower part of the embedded markup.
	 */
	private Object follower;

	/**
	 * Constructs a Weabric 'Each' parse tree node.
	 * 
	 * @param id
	 *            The id part of the embedded markup.
	 * @param markup
	 *            The markup part of the embedded markup.
	 * @param follower
	 *            The follower part of the embedded markup.
	 */
	public MarkupEmbed(String id, List<Markup> markup, Object follower) {
		this.id = id;
		this.markup = markup;
		this.follower = follower;
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
		return "<" + id + " " + Strings.join(" ", markup) + " " + follower;

	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {

		String markupList = "";
		for (Markup markupItem : markup) {
			markupList = outputAddToBlock(markupList, markupItem
					.toTransformerOutput());
		}

		String followerItem = "";
		if (follower instanceof TransformerOutput) {
			followerItem = ((TransformerOutput) follower).toTransformerOutput();
		}

		return OUTPUT_MARKUPEMBED
				+ outputBracedBlock(outputQuote(id) + OUTPUT_LIST_SEPARATOR
						+ outputBracedList(markupList) + OUTPUT_LIST_SEPARATOR
						+ followerItem);
	}
}
