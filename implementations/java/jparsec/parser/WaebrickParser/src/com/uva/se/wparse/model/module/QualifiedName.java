/*
 * File			: QualifiedName.java
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
package com.uva.se.wparse.model.module;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.util.Strings;

/**
 * The weabric parse tree node of the weabric 'each' construction.
 */
public final class QualifiedName extends WaebricParseTreeNode {

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(QualifiedName.class);

	/**
	 * The names of the qualified name.
	 */
	private List<String> names;

	/**
	 * Constructs a Weabric 'QualifiedName' parse tree node.
	 * 
	 * @param names
	 *            The names of the qualified name.
	 */
	public QualifiedName(List<String> names) {
		this.names = names;
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
		return Strings.join(".", names);
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		List<String> quotedNames = new ArrayList<String>();
		for (String name : names) {
			quotedNames.add(outputQuote(name));
		}

		return Strings.join(OUTPUT_BLOCK_SEPARATOR, quotedNames);
	}
}
