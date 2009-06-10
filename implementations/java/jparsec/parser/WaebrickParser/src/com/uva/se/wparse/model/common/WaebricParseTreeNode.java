/*
 * File			: WaebricParseTreeNode.java
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
package com.uva.se.wparse.model.common;

import java.util.ArrayList;

/**
 * Base class that is the base for every Waebric parse tree node. This class
 * also contains some constants which are used for the process of creating the
 * output.
 */
public abstract class WaebricParseTreeNode implements TransformerOutput {

	/**
	 * An empty string.
	 */
	public static final String OUTPUT_EMPTY_ELEMENT = "";

	/**
	 * An opening quote "
	 */
	public static final String OUTPUT_QUOTE_OPEN = "\"";

	/**
	 * An closing quote "
	 */
	public static final String OUTPUT_QUOTE_CLOSE = "\"";

	/**
	 * A literal which is opening a quote: "\"
	 */
	public static final String OUTPUT_LITERAL_QUOTE_OPEN = "\"\\\"";

	/**
	 * A literal which is closing a quote: \""
	 */
	public static final String OUTPUT_LITERAL_QUOTE_CLOSE = "\\\"\"";

	/**
	 * Begin a block: (
	 */
	public static final String OUTPUT_BLOCK_BEGIN = "(";
	/**
	 * Seperate a block: ,
	 */
	public static final String OUTPUT_BLOCK_SEPARATOR = ",";

	/**
	 * End a block: )
	 */
	public static final String OUTPUT_BLOCK_END = ")";

	/**
	 * The begin of a list: [
	 */
	public static final String OUTPUT_LIST_BEGIN = "[";

	/**
	 * Seperate a list: ,
	 */
	public static final String OUTPUT_LIST_SEPARATOR = ",";

	/**
	 * End a list: ,
	 */
	public static final String OUTPUT_LIST_END = "]";

	/**
	 * A name of the arguments: args
	 */
	public static final String OUTPUT_ARGUMENTS = "args";

	/**
	 * A name of the attributes: attr
	 */
	public static final String OUTPUT_ATTRIBUTE = "attr";

	/**
	 * Returns the contents of this node for the output transformer
	 * 
	 * @return The contents of the current node in the ParserTree (Defaults to
	 *         OUTPUT_EMPTY_ELEMENT)
	 */
	public String toTransformerOutput() {
		return OUTPUT_EMPTY_ELEMENT;
	}

	/**
	 * Puts quotes around a text literal. Allows for changing the type of quotes
	 * to be used with literals
	 * 
	 * @param textLiteralOutput
	 *            the literal to be surrounded by quotes
	 * @return literal surrounded by quotes
	 */
	protected String outputQuote(String textLiteralOutput) {
		return OUTPUT_QUOTE_OPEN + textLiteralOutput + OUTPUT_QUOTE_CLOSE;
	}

	/**
	 * Puts quotes around a text literal. Allows for changing the type of quotes
	 * to be used with literals
	 * 
	 * @param textLiteralOutput
	 *            the literal to be surrounded by quotes
	 * @return literal surrounded by quotes
	 */
	protected String outputLiteralQuote(String textLiteralOutput) {
		return OUTPUT_LITERAL_QUOTE_OPEN + textLiteralOutput
				+ OUTPUT_LITERAL_QUOTE_CLOSE;
	}

	/**
	 * Puts quotes directly around the contents of a ValueObject
	 * 
	 * @param valueObject
	 *            the ValueObject having the contents to be quoted
	 * @return the ValueObject's contents with quotes
	 */
	protected String outputQuote(WaebricParseTreeNode valueObject) {
		return outputQuote(valueObject.toString());
	}

	/**
	 * Puts list type braces around an unbraced list in text form
	 * 
	 * @param unbracedList
	 *            list in text form, without braces
	 * @return the unbraced list with the begin and end braces for a list
	 */
	protected String outputBracedList(String unbracedList) {
		if (!unbracedList.isEmpty()) {
			return OUTPUT_LIST_BEGIN + unbracedList + OUTPUT_LIST_END;
		} else {
			return unbracedList;
		}
	}

	/**
	 * Create a braced list, also if the unbracedlist is empty.
	 * 
	 * @param unbracedList
	 *            The list which must be braced.
	 * @param alwaysBrace
	 *            Indicates if the list must be braced when the list is empty.
	 * @return
	 */
	protected String outputBracedList(String unbracedList, boolean alwaysBrace) {
		if (alwaysBrace) {
			return OUTPUT_LIST_BEGIN + unbracedList + OUTPUT_LIST_END;
		} else {
			return outputBracedList(unbracedList);
		}
	}

	/**
	 * Adds (a) new element(s) to a block in text form
	 * 
	 * @param block
	 *            is an existing block in text form
	 * @param newBlockItem
	 *            is/are (a) new item(s) to be added in text form
	 * @return New block with both the original block and the new item(s)
	 */
	protected String outputAddToBlock(String block, String newBlockItem) {
		if (newBlockItem.isEmpty()) {
			return block;
		}
		if (block.isEmpty()) {
			return newBlockItem;
		}
		return block + OUTPUT_BLOCK_SEPARATOR + newBlockItem;
	}

	/**
	 * Transforms a List of ValueObjects into a block in text form
	 * 
	 * @param blockToTransform
	 *            List of ValueObjects to be transformed
	 * @return Block of contents of listToTransform in text form
	 */
	protected String blockToTransformerOutput(
			ArrayList<? extends TransformerOutput> blockToTransform) {
		String Result = "";
		for (TransformerOutput transformerOutput : blockToTransform) {
			Result = outputAddToBlock(Result, transformerOutput
					.toTransformerOutput());
		}
		return Result.toString();
	}

	/**
	 * Puts block type braces around an unbraced block in text form
	 * 
	 * @param unbracedBlock
	 *            Block in text form, without braces
	 * @return The unbraced list with the begin and end braces for a block
	 */
	protected String outputBracedBlock(String unbracedBlock) {
		return OUTPUT_BLOCK_BEGIN + unbracedBlock + OUTPUT_BLOCK_END;
	}

}
