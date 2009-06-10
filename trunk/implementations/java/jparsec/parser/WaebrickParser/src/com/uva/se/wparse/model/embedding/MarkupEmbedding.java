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
package com.uva.se.wparse.model.embedding;

import java.util.List;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.markup.Designator;
import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.util.ConversionUtil;
import com.uva.se.wparse.util.Strings;

/**
 * The weabric parse tree node of the weabric 'MarkupEmbedding' construction. 
 */
public class MarkupEmbedding extends WaebricParseTreeNode implements Embedding {

	/**
	 * OUTPUT_EXP_EMBEDDING is used to indicate this construction in the output process.
	 */
	private static final String OUTPUT_EXP_EMBEDDING = "exp-embedding";
	
	/**
	 * OUTPUT_MARKUP_EMBEDDING is used to indicate this construction in the output process.
	 */
	private static final String OUTPUT_MARKUP_EMBEDDING = "markup-embedding";
	
	/**
	 * OUTPUT_EMBEDDING_PRE is used to indicate this construction in the output process.
	 */
	private static final String OUTPUT_EMBEDDING_PRE = "pre";
	
	/**
	 * OUTPUT_EMBEDDING_POST is used to indicate this construction in the output process.
	 */
	private static final String OUTPUT_EMBEDDING_POST = "post";
	
	/**
	 * OUTPUT_EMBEDDING_PRE_CODE is used to indicate this construction in the output process.
	 */
	private static final String OUTPUT_EMBEDDING_PRE_CODE = "\"\\\"<\"";

	/**
	 * OUTPUT_EMBEDDING_POST_CODE is used to indicate this construction in the output process.
	 */
	private static final String OUTPUT_EMBEDDING_POST_CODE = "(\">\\\"\")";

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(MarkupEmbedding.class);

	/**
	 * The preText of the MarkupEmbedding. 
	 */
	private String preText = null;
	
	/**
	 * The markup of the MarkupEmbedding.
	 */
	private List<Markup> markup = null;
	
	/**
	 * The postText of the MarkupEmbedding.
	 */
	private String postText = null;

	/**
	 * The expression of the MarkupEmbedding.
	 */
	private Expression expression = null;

	/**
	 * Constructs a Weabric 'MarkupEmbedding' parse tree node.
	 * @param preText The preText of the MarkupEmbedding.
	 * @param markup The markup of the MarkupEmbedding.
	 * @param expression The expression of the MarkupEmbedding.
	 * @param postText The postText of the MarkupEmbedding.
	 */
	public MarkupEmbedding(List<String> preText, List<Markup> markup,
			Object expression, List<String> postText) {
		this.preText = Strings.join("", preText);
		this.markup = markup;
		if (expression instanceof Markup) {
			this.markup.add((Markup) expression);
		} else if (expression instanceof Expression) {
			this.expression = (Expression) expression;
		}

		if (this.markup.size() > 1) {
			Markup lastMarkupItem = this.markup.get(this.markup.size() - 1);
			if (lastMarkupItem instanceof Designator) {

				Designator designator = (Designator) this.markup
						.remove(this.markup.size() - 1);
				this.expression = ConversionUtil
						.designatorToExpression(designator);
			}
		}

		this.postText = Strings.join("", postText);
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
		return preText + " < " + Strings.join(" ", markup) + " " + expression
				+ " > " + postText;
	}

	/**
	 * Transforms the content of this object to the expected output code. 
	 * If necessary this function constructs also the output of the children. 
	 * (It calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {

		String followerItem = "";
		if (expression != null) {
			followerItem = expression.toTransformerOutput();
		} else {
			followerItem = markup.remove(markup.size() - 1)
					.toTransformerOutput();
		}

		String markupList = "";

		for (Markup markupItem : markup) {
			markupList = outputAddToBlock(markupList, markupItem
					.toTransformerOutput());
		}

		if (expression != null) {
			return OUTPUT_EMBEDDING_PRE
					+ outputBracedBlock(OUTPUT_EMBEDDING_PRE_CODE
							+ OUTPUT_BLOCK_SEPARATOR
							+ OUTPUT_EXP_EMBEDDING
							+ outputBracedBlock(outputBracedList(markupList)
									+ OUTPUT_BLOCK_SEPARATOR + followerItem)
							+ OUTPUT_BLOCK_SEPARATOR + OUTPUT_EMBEDDING_POST
							+ OUTPUT_EMBEDDING_POST_CODE);
		} else {
			return OUTPUT_EMBEDDING_PRE
					+ outputBracedBlock(OUTPUT_EMBEDDING_PRE_CODE
							+ OUTPUT_BLOCK_SEPARATOR
							+ OUTPUT_MARKUP_EMBEDDING
							+ outputBracedBlock(outputBracedList(markupList)
									+ OUTPUT_BLOCK_SEPARATOR + followerItem)
							+ OUTPUT_BLOCK_SEPARATOR + OUTPUT_EMBEDDING_POST
							+ OUTPUT_EMBEDDING_POST_CODE);
		}

	}
}
