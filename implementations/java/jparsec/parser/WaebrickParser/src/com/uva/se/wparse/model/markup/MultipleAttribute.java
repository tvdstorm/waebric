/*
 * File			: MultipleAttribute.java
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
package com.uva.se.wparse.model.markup;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;

/**
 * The weabric parse tree node of the weabric 'MultipleAttribute' construction.
 * It is an implementation of an expression.
 */
public class MultipleAttribute extends WaebricParseTreeNode implements
		Attribute {

	/**
	 * OUTPUT_ATTRIBUTE_WIDTH_HEIGTH is used to indicate this construction in
	 * the output process.
	 */
	private static final String OUTPUT_ATTRIBUTE_WIDTH_HEIGTH = "width-height";

	/**
	 * OUTPUT_ATTRIBUTE_WIDTH is used to indicate this construction in the
	 * output process.
	 */
	private static final String OUTPUT_ATTRIBUTE_WIDTH = "height";

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(MultipleAttribute.class);

	/**
	 * The width of the multiple attribute node.
	 */
	private String width;

	/**
	 * The height of the multiple attribute node.
	 */
	private String height;

	/**
	 * Constructs a Weabric 'MultipleAttribute' parse tree node.
	 * 
	 * @param width
	 *            The width of the multiple attribute node.
	 * @param height
	 *            The height of the multiple attribute node.
	 */
	public MultipleAttribute(String width, String height) {
		this.width = width;
		this.height = height;
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
		if (height == null) {
			return "@" + width;
		} else {
			return "@" + width + "%" + height;
		}
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {

		if ((height != null) && !height.isEmpty()) {
			return OUTPUT_ATTRIBUTE_WIDTH_HEIGTH
					+ outputBracedBlock(width + OUTPUT_BLOCK_SEPARATOR + height);
		} else {
			return OUTPUT_ATTRIBUTE_WIDTH + outputBracedBlock(width);
		}
	}
}
