/*
 * File			: FunctionDef.java
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

import java.util.List;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.model.markup.Formals;
import com.uva.se.wparse.model.statement.Statement;

/**
 * The weabric parse tree node of the weabric 'FunctionDef' construction. 
 */
public final class FunctionDef extends WaebricParseTreeNode implements Member {

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(FunctionDef.class);

	/**
	 * The name of a definition of a function.
	 */
	private String name = "";

	/**
	 * The formals of a definition of a function.
	 */
	private Formals formals = null;

	/**
	 * The statements which are nested in a function.
	 */
	private List<Statement> statements = null;

	/**
	 * Constructs a Weabric 'FunctionDef' parse tree node.
	 * 
	 * @param name
	 *            The name of a definition of a function.
	 * @param formals
	 *            The formals of a definition of a function.
	 * @param statements
	 *            The statements which are nested in a function.
	 */
	public FunctionDef(String name, Formals formals, List<Statement> statements) {

		this.name = name.trim();
		this.formals = formals;
		this.statements = statements;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	/**
	 * Get the name of a function.
	 * 
	 * @return The name of the function.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get the formals of a function.
	 * 
	 * @return The formals of a function.
	 */
	public Formals getFormals() {
		return formals;
	}

	/**
	 * Get the statemens of a function.
	 * 
	 * @return The statments of a function.
	 */
	public List<Statement> getStatements() {
		return statements;
	}

	/**
	 * Presents this object as a string representation.
	 */
	@Override
	public String toString() {
		String result = "def " + name + "(";
		if (formals != null) {
			result = result + formals;
		}
		result = result + ")";
		if (statements != null) {
			result = result + statements;
		}

		result = result + " end";
		return result;
	}

	/**
	 * OUTPUT_FUNCTION is used to indicate this construction in the output
	 * process.
	 */
	private static final String OUTPUT_FUNCTION = "def";

	/**
	 * OUTPUT_FORMALS is used to indicate this construction in the output
	 * process.
	 */
	private static final String OUTPUT_FORMALS = "formals";

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		String NameElement = outputQuote(name);
		String formalsOutput = "";
		if (formals != null) {
			formalsOutput = formals.toTransformerOutput();
		}

		String ArgumentsElement = OUTPUT_FORMALS
				+ outputBracedBlock(outputBracedList(formalsOutput, true));

		String StatementsElement = "";
		for (Statement statement : statements) {
			StatementsElement = outputAddToBlock(StatementsElement, statement
					.toTransformerOutput());
		}
		StatementsElement = outputBracedList(StatementsElement, true);

		return OUTPUT_FUNCTION
				+ outputBracedBlock(NameElement + OUTPUT_BLOCK_SEPARATOR
						+ ArgumentsElement + OUTPUT_BLOCK_SEPARATOR
						+ StatementsElement);
	}
}
