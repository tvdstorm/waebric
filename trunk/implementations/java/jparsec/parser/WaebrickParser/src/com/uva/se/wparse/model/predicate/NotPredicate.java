package com.uva.se.wparse.model.predicate;

import org.apache.log4j.Logger;
import com.uva.se.wparse.model.common.WaebricParseTreeNode;

/**
 * The weabric parse tree node of the weabric 'not predicate' construction. It
 * is an implementation of a predicate
 */
public class NotPredicate extends WaebricParseTreeNode implements Predicate {

	/**
	 * OUTPUT_PREDICATE_NEGATION is used to indicate this construction in the output process.
	 */
	private static final String OUTPUT_PREDICATE_NEGATION = "not";

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(NotPredicate.class);

	/**
	 * The predicate which is negated.
	 */
	private Predicate predicate;

	/**
	 * Constructs a Weabric 'NotPredicate' parse tree node.
	 * 
	 * @param predicate
	 *            The predicate which is negated.
	 */
	public NotPredicate(Predicate predicate) {
		this.predicate = predicate;
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
		return "!" + predicate;
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		return OUTPUT_PREDICATE_NEGATION
				+ outputBracedBlock(predicate.toTransformerOutput());
	}
}
