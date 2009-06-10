/*
 * File			: Designator.java
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
package com.uva.se.wparse.model.markup;

import java.util.List;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;

/**
 * The weabric parse tree node of the weabric 'Designator' construction. It is
 * an implementation of an expression.
 */
public class Designator extends WaebricParseTreeNode implements Markup {

	/**
	 * OUTPUT_EACH is used to indicate this construction in the output process.
	 */
	private static final String OUTPUT_TAG = "tag";

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(Designator.class);

	/**
	 * The identifier part of the Designator.
	 */
	private String identifier;

	/**
	 * The attributes part of the Designator.
	 */
	private List<Attribute> attributes;

	/**
	 * Constructs a Weabric 'Each' parse tree node.
	 * 
	 * @param identifier
	 *            The identifier part of the Designator.
	 * @param attributes
	 *            The attributes part of the Designator.
	 */
	public Designator(String identifier, List<Attribute> attributes) {
		this.identifier = identifier;
		this.attributes = attributes;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	/**
	 * Get all the attributes of the Designator.
	 * 
	 * @return The attributes.
	 */
	public List<Attribute> getAttributes() {
		return attributes;
	}

	/**
	 * Get identifier of the Designator.
	 * 
	 * @return The identifier.
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * Presents this object as a string representation.
	 */
	@Override
	public String toString() {
		return identifier + " " + attributes;
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {

		String AttributeBlock = "";
		for (Attribute attribute : attributes) {
			AttributeBlock = AttributeBlock + attribute.toTransformerOutput();
		}

		String Result = outputQuote(identifier.trim()) + OUTPUT_BLOCK_SEPARATOR
				+ OUTPUT_LIST_BEGIN + AttributeBlock + OUTPUT_LIST_END;

		return OUTPUT_TAG + outputBracedBlock(Result);
	}
}
