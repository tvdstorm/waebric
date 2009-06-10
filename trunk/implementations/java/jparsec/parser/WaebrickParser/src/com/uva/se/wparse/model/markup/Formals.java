/*
 * File			: Formals.java
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

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.model.expression.Identifier;
import com.uva.se.wparse.util.Strings;

/**
 * The weabric parse tree node of the weabric 'Formals' construction. It is an
 * implementation of an expression.
 */
public final class Formals extends WaebricParseTreeNode {

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(Formals.class);

	/**
	 * An identifier list with all the identifiers.
	 */
	private List<Identifier> identifierList = null;

	/**
	 * Constructs a Weabric 'Each' parse tree node.
	 * 
	 * @param identifierList
	 *            An identifier list with all the identifiers.
	 */
	public Formals(List<Identifier> identifierList) {
		this.identifierList = Collections.unmodifiableList(identifierList);
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
		if (identifierList != null) {
			return "(" + Strings.join(" ", identifierList) + ")";
		} else {
			return "()";
		}
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		String Result = "";

		if (identifierList != null) {
			for (Identifier ident : identifierList) {
				Result = outputAddToBlock(Result, ident.toTransformerOutput());
			}
		}
		return Result;
	}
}
