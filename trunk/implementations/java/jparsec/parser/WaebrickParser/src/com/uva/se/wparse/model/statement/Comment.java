/*
 * File			: Comment.java
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
import com.uva.se.wparse.model.expression.StringLiteral;

/**
 * The comments which are used in the Weabric code. With comments you can
 * describe the Weabric code.
 */
public class Comment extends WaebricParseTreeNode implements Statement {

	/**
	 * A definition of comments which is used while generating the output of the
	 * parsing process.
	 */
	private static final String OUTPUT_COMMENT = "comment";

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(Comment.class);

	/**
	 * The comments itself.
	 */
	private StringLiteral comment; // TODO: Dit is geen StringLiteral (gewoon

	// een string gebruiken)

	/**
	 * Constructs a Weabric comment node of the parse tree.
	 * 
	 * @param comment
	 *            The comments itself.
	 */
	public Comment(StringLiteral comment) {
		this.comment = comment;
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
		return "comment " + comment;
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		return OUTPUT_COMMENT
				+ outputBracedBlock(outputQuote(comment.toString()));
	}

}
