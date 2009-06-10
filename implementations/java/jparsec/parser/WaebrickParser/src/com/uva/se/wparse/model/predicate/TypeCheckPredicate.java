/*
 * File			: TypeCheckPredicate.java
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
package com.uva.se.wparse.model.predicate;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.model.expression.Expression;

/**
 * The weabric parse tree node of the weabric 'TypeCheckPredicate' construction.
 * It is an implementation of a predicate
 */
public class TypeCheckPredicate extends WaebricParseTreeNode implements
		Predicate {

	/**
	 * OUTPUT_PREDICATE_TYPE_CHECK is used to indicate this construction in the
	 * output process.
	 */
	private static final String OUTPUT_PREDICATE_TYPE_CHECK = "is-a";

	/**
	 * OUTPUT_PREDICATE_TYPE_POSTFIX is used to indicate this construction in
	 * the output process.
	 */
	private static final String OUTPUT_PREDICATE_TYPE_POSTFIX = "-type";

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(TypeCheckPredicate.class);

	/**
	 * The type of the type check predicate.
	 */
	private String type;

	/**
	 * The expression part of the type check predicate.
	 */
	private Expression expression;

	/**
	 * Constructs a Weabric 'Each' parse tree node.
	 * 
	 * @param expression
	 *            The expression part of the type check predicate.
	 * @param type
	 *            The type of the type check predicate.
	 */
	public TypeCheckPredicate(Expression expression, String type) {
		this.type = type;
		this.expression = expression;
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
		return expression + "." + type;
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		return OUTPUT_PREDICATE_TYPE_CHECK
				+ outputBracedBlock(expression.toTransformerOutput()
						+ OUTPUT_BLOCK_SEPARATOR + type
						+ OUTPUT_PREDICATE_TYPE_POSTFIX);
	}

}
