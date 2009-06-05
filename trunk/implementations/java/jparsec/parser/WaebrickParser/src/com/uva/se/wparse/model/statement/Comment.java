/*
 * File			: CommentStatement.java
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
import com.uva.se.wparse.model.expression.StringLiteral;


public class Comment extends WaebricParseTreeNode implements Statement {
	
	public static final String OUTPUT_COMMENT = "comment";

	private static org.apache.log4j.Logger logger = Logger
			.getLogger(Comment.class);

	private StringLiteral comment; // TODO: Dit is geen StringLiteral (gewoon een string gebruiken)

	public Comment(StringLiteral comment) {
		this.comment = comment;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		return "comment " + comment;
	}
	
	@Override
	public String toTransformerOutput() {
		return OUTPUT_COMMENT + outputBracedBlock( outputQuote( comment.toString() ) );
	}

}
