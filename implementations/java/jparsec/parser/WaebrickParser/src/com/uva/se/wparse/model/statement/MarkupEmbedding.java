/*
 * File			: MarkupEmbedding.java
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
import com.uva.se.wparse.model.embedding.Embedding;
import com.uva.se.wparse.model.markup.Markup;

/**
 * The weabric parse tree node of the weabric 'markup and embedding'
 * construction. It is an implementation of a statement.
 */
public class MarkupEmbedding extends WaebricParseTreeNode implements Statement,
		Markup {

	/**
	 * OUTPUT_MARKUP_EMBEDDING is used to indicate this construction in the
	 * output process.
	 */
	private static final String OUTPUT_MARKUP_EMBEDDING = "markup-embedding";

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(MarkupEmbedding.class);

	/**
	 * The markup of the markup and embedding construction.
	 */
	private List<Markup> markup;

	/**
	 * The embedding of the markup and embedding construction.
	 */
	private Embedding embedding;

	/**
	 * Constructs a Weabric 'MarkupEmbedding' parse tree node.
	 * 
	 * @param markup
	 *            The markup of the markup and embedding construction.
	 * @param embedding
	 *            The embedding of the markup and embedding construction.
	 */
	public MarkupEmbedding(List<Markup> markup, Embedding embedding) {
		this.markup = markup;
		this.embedding = embedding;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + super.toString() + " " + embedding);
		}
	}

	/**
	 * Presents this object as a string representation.
	 */
	@Override
	public String toString() {
		return markup.toString() + " " + embedding;
	};

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

		return OUTPUT_MARKUP_EMBEDDING
				+ outputBracedBlock(outputAddToBlock(
						outputBracedList(markupList), embedding
								.toTransformerOutput()));
	}

}
