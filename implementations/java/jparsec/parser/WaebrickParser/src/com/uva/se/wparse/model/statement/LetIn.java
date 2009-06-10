/*
 * File			: LetIn.java
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

import java.util.List;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;

/**
 * The weabric parse tree node of the weabric 'let in' construction. It is an
 * implementation of a statement.
 */
public final class LetIn extends WaebricParseTreeNode implements Statement {

	/**
	 * OUTPUT_LETIN is used to indicate this construction in the output process.
	 */
	public static final String OUTPUT_LETIN = "let";

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(LetIn.class);

	/**
	 * The list of assignments of the let in statement.
	 */
	private List<Assignment> assignmentList;

	/**
	 * The list of statements of the let in statement.
	 */
	private List<Statement> statementList;

	/**
	 * Constructs a Weabric 'Each' parse tree node.
	 * 
	 * @param assignmentList
	 *            The list of assignments.
	 * @param statementList
	 *            The list of statements.
	 */
	public LetIn(List<Assignment> assignmentList, List<Statement> statementList) {
		this.assignmentList = assignmentList;
		this.statementList = statementList;
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
		StringBuilder builder = new StringBuilder();
		builder.append("let ").append(assignmentList).append(" in ").append(
				statementList).append("end");
		return builder.toString();
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		String expressionItem = "";
		for (Assignment assignment : assignmentList) {
			expressionItem = assignment.toTransformerOutput();
		}

		String statementListString = "";
		for (Statement statement : statementList) {
			statementListString = outputAddToBlock(statementListString,
					statement.toTransformerOutput());
		}

		return OUTPUT_LETIN
				+ outputBracedBlock(outputBracedList(expressionItem)
						+ OUTPUT_BLOCK_SEPARATOR
						+ outputBracedList(statementListString));
	}
}
