/*
 * File			: AssignmentFormals.java
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

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.util.Strings;

/**
 * The definition of assignment of the formals.
 */
public final class AssignmentFormals extends WaebricParseTreeNode 
	implements Assignment {

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(AssignmentFormals.class);

	/**
	 * A definition of an output assignment which is used while generating the
	 * output of the parsing process.
	 */
	private static final String OUTPUT_ASSIGNMENT_FORMALS = "func-bind";

	/**
	 * An identifier which belongs to the formals.
	 */
	private String identifier;

	/**
	 * The left part of the assignment, a set of formals.
	 */
	private ArrayList<String> formals;

	/**
	 * The right part of the assignment, a statement.
	 */
	private Statement statement;

	/**
	 * Create the definition of a AssignmentFormal.
	 * 
	 * @param identifier
	 *            The identifier of this object.
	 * @param formals
	 *            The left part of the assignment in the form of formals.
	 * @param statement
	 *            The right part of the assignment.
	 */
	public AssignmentFormals(String identifier, ArrayList<String> formals,
			Statement statement) {
		this.identifier = identifier;
		this.formals = formals;
		this.statement = statement;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	/**
	 * Represents the string representation of this object.
	 */
	@Override
	public String toString() {
		return identifier + " ( " + Strings.join(",", formals) + " ) = "
				+ statement;
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		return OUTPUT_ASSIGNMENT_FORMALS
				+ outputBracedBlock(identifier
						+ OUTPUT_BLOCK_SEPARATOR
						+ outputBracedList(Strings.join(OUTPUT_LIST_SEPARATOR,
								formals)) + OUTPUT_BLOCK_SEPARATOR
						+ statement.toTransformerOutput());
	}
}
