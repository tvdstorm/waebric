/*
 * File			: Block.java
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

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.util.Strings;

/**
 * The definition of a block of Weabric code. A block is a set of statements
 * surrounded with { }.
 */
public final class Block extends WaebricParseTreeNode implements Statement {

	/**
	 * A definition of an output block which is used while generating the output
	 * of the parsing process.
	 */
	private static final String OUTPUT_BLOCK = "block";

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(Block.class);

	/**
	 * The set of statements which are nested within the braces.
	 */
	private List<Statement> statements;

	/**
	 * Create a block with several statements.
	 * 
	 * @param statements
	 *            The set of statements which are nested within the braces.
	 */
	public Block(List<Statement> statements) {
		this.statements = Collections.unmodifiableList(statements);
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
		return "{" + Strings.join(" ", statements) + "}";
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		String statementBlock = "";
		for (Statement statement : statements) {
			statementBlock = outputAddToBlock(statementBlock, statement
					.toTransformerOutput());
		}
		return OUTPUT_BLOCK
				+ outputBracedBlock(outputBracedList(statementBlock));
	}
}
