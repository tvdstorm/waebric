/*
 * File			: MarkupExpression.java
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

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.markup.Markup;

/**
 * The weabric parse tree node of the weabric 'MarkupExpression' construction. It is an
 * implementation of embedding weabric parts.
 */
public class MarkupExpression extends WaebricParseTreeNode implements Embedding {
	
	/**
	 * OUTPUT_MARKUP_EXPR is used to indicate this construction in the output process.
	 */
	private static final String OUTPUT_MARKUP_EXPR = "markup-expr";
	
	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger.getLogger(MarkupExpression.class);

	/**
	 * The markup part of the markup expression.
	 */
	private Markup markup;
	
	/**
	 * The expression part of the markup expression. 
	 */
	private Expression expr;
	
	/**
	 * Constructs a Weabric 'MarkupExpression' parse tree node.
	 * @param markup The markup part of the markup expression.
	 * @param expr The expression part of the markup expression.
	 */
	public MarkupExpression(Markup markup, Expression expr) {
		this.markup = markup;
		this.expr = expr;
		if(logger.isDebugEnabled()){
			logger.debug("Creating " + this.getClass().getSimpleName() + " with values : " + toString());
		}
	}

	/**
	 * Presents this object as a string representation.
	 */
	@Override
	public String toString() {
		return markup.toString() + " " + expr;
	}
	
	/**
	 * Transforms the content of this object to the expected output code. 
	 * If necessary this function constructs also the output of the children. 
	 * (It calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		return OUTPUT_MARKUP_EXPR + outputBracedBlock( markup.toTransformerOutput() + OUTPUT_BLOCK_SEPARATOR + expr.toTransformerOutput() );
	}
}
