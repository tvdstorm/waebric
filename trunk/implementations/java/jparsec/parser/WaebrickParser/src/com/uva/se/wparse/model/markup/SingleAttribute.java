/*
 * File			: SingleAttribute.java
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

import org.apache.log4j.Logger;
import org.codehaus.jparsec.Token;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.parser.Operator;

/**
 * The weabric parse tree node of the weabric 'SingleAttribute' construction. It
 * is an implementation of an expression.
 */
public class SingleAttribute extends WaebricParseTreeNode implements Attribute {

	/**
	 * OUTPUT_ATRIBUTE_ID is used to indicate this construction in the output
	 * process.
	 */
	private static final String OUTPUT_ATRIBUTE_ID = "id";

	/**
	 * OUTPUT_ATRIBUTE_CLASS is used to indicate this construction in the output
	 * process.
	 */
	private static final String OUTPUT_ATRIBUTE_CLASS = "class";

	/**
	 * OUTPUT_ATRIBUTE_NAME is used to indicate this construction in the output
	 * process.
	 */
	private static final String OUTPUT_ATRIBUTE_NAME = "name";

	/**
	 * OUTPUT_ATRIBUTE_TYPE is used to indicate this construction in the output
	 * process.
	 */
	private static final String OUTPUT_ATRIBUTE_TYPE = "type";

	/**
	 * OUTPUT_ATRIBUTE_HEIGHT is used to indicate this construction in the
	 * output process.
	 */
	private static final String OUTPUT_ATRIBUTE_HEIGHT = "height";

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(SingleAttribute.class);

	/**
	 * The symbol of the SingleAttribute.
	 */
	private Operator symbol;

	/**
	 * The identifier of the SingleAttribute.
	 */
	private String identifier;

	/**
	 * Constructs a Weabric 'SingleAttribute' parse tree node.
	 * 
	 * @param symbolToken
	 *            The symbol of the SingleAttribute.
	 * @param identifier
	 *            The identifier of the SingleAttribute.
	 */
	public SingleAttribute(Token symbolToken, String identifier) {
		this.symbol = getSymbol(symbolToken.toString());
		this.identifier = identifier;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	/**
	 * Returns the symbol of the SingleAttribute.
	 * 
	 * @return The symbol of the the SingleAttribute.
	 */
	public Operator getSymbol() {
		return symbol;
	}

	/**
	 * Returns the identifier of the SingleAttribute.
	 * 
	 * @return The identifier of the the SingleAttribute.
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * Convert a symbol to an operator.
	 * 
	 * @param symbol
	 *            The symbol to convert
	 * @return The converted operator.
	 */
	public Operator getSymbol(String symbol) {
		if (Operator.POUND.toString().equals(symbol)) {
			return Operator.POUND;
		} else if (Operator.DOT.toString().equals(symbol)) {
			return Operator.DOT;
		}
		if (Operator.DOLLAR.toString().equals(symbol)) {
			return Operator.DOLLAR;
		}
		if (Operator.COLON.toString().equals(symbol)) {
			return Operator.COLON;
		}

		// default, return null
		return null;
	}

	/**
	 * Presents this object as a string representation.
	 */
	@Override
	public String toString() {
		return symbol + identifier;
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		String Result = outputQuote(identifier);

		switch (symbol) {
		case POUND:
			Result = OUTPUT_ATRIBUTE_ID + outputBracedBlock(Result);
			break;
		case DOT:
			Result = OUTPUT_ATRIBUTE_CLASS + outputBracedBlock(Result);
			break;
		case DOLLAR:
			Result = OUTPUT_ATRIBUTE_NAME + outputBracedBlock(Result);
			break;
		case COLON:
			Result = OUTPUT_ATRIBUTE_TYPE + outputBracedBlock(Result);
			break;
		case AT:
			Result = OUTPUT_ATRIBUTE_HEIGHT + outputBracedBlock(Result);
			break;
		}

		return Result;
	}

}
