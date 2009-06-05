/*
 * File			: ValueObject.java
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
package com.uva.se.wparse.model.common;

import java.util.ArrayList;

/**
 * Base class that implements {@link Object#equals(Object)}, {@link Object#hashCode()} and
 * {@code Object#toString()} on final fields.
 * 
 * @author Ben Yu
 */
public abstract class WaebricParseTreeNode implements TransformerOutput {
	
  public static final String OUTPUT_EMPTY_ELEMENT			= "";  
  
  public static final String OUTPUT_QUOTE_OPEN 				= "\"";
  public static final String OUTPUT_QUOTE_CLOSE				= "\"";
  
  public static final String OUTPUT_LITERAL_QUOTE_OPEN  	= "\"\\\"";
  public static final String OUTPUT_LITERAL_QUOTE_CLOSE  	= "\\\"\""; 
  
  public static final String OUTPUT_BLOCK_BEGIN				= "(";
  public static final String OUTPUT_BLOCK_SEPARATOR			= ",";
  public static final String OUTPUT_BLOCK_END 				= ")";
  
  public static final String OUTPUT_LIST_BEGIN 				= "["; 
  public static final String OUTPUT_LIST_SEPARATOR 			= ",";
  public static final String OUTPUT_LIST_END 				= "]";
  
  public static final String OUTPUT_ARGUMENTS		= "args";
  public static final String OUTPUT_ATTRIBUTE		= "attr";
  
  /* 
  * Code for Output 
  */
  
  /**
   * Returns the contents of this node for the output transformer
   * @return The contents of the current node in the ParserTree (Defaults to OUTPUT_EMPTY_ELEMENT) 
   */
  public String toTransformerOutput() {
	return OUTPUT_EMPTY_ELEMENT;
  }
  
  /**
   * Puts quotes around a text literal.
   * Allows for changing the type of quotes to be used with literals
   * @param textLiteralOutput the literal to be surrounded by quotes
   * @return literal surrounded by quotes
   */
  protected String outputQuote(String textLiteralOutput) {
	return OUTPUT_QUOTE_OPEN + textLiteralOutput + OUTPUT_QUOTE_CLOSE;	  
  }
  
  /**
   * Puts quotes around a text literal.
   * Allows for changing the type of quotes to be used with literals
   * @param textLiteralOutput the literal to be surrounded by quotes
   * @return literal surrounded by quotes
   */
  protected String outputLiteralQuote(String textLiteralOutput) {
	return OUTPUT_LITERAL_QUOTE_OPEN + textLiteralOutput + OUTPUT_LITERAL_QUOTE_CLOSE;	  
  }
  
  /**
   * Puts quotes directly around the contents of a ValueObject
   * @param valueObject the ValueObject having the contents to be quoted
   * @return the ValueObject's contents with quotes
   */
  protected String outputQuote(WaebricParseTreeNode valueObject) {
	return outputQuote(valueObject.toString());	  
  }
  
  /**
   * Adds (a) new element(s) to a list in text form 
   * @param list is an existing list in text form
   * @param newListItem is/are (a) new item(s) to be added in text form
   * @return New list with both the original list and the new item(s)
   */
  /* protected String outputAddToList(String list, String newListItem) {
	if (newListItem == OUTPUT_LIST_EMPTY) {
	  return list;
	}
	if (list == OUTPUT_LIST_EMPTY) {
	  return newListItem;
	}
	return list + OUTPUT_LIST_SEPARATOR + newListItem;		  
  } */
  
  /**
   * puts list type braces around an unbraced list in text form  
   * @param unbracedList list in text form, without braces
   * @return the unbraced list with the begin and end braces for a list
   */
  protected String outputBracedList(String unbracedList) {
	if (!unbracedList.isEmpty()) {  
	  return OUTPUT_LIST_BEGIN + unbracedList + OUTPUT_LIST_END;
	}
	else
	{
	  return unbracedList;	
	}
  }
  
  protected String outputBracedList(String unbracedList, boolean alwaysBrace) {
	  if (alwaysBrace) {
		  return OUTPUT_LIST_BEGIN + unbracedList + OUTPUT_LIST_END;
	  }
	  else {
		  return outputBracedList( unbracedList );
	  }		  
  }
  
  /**
   * Adds (a) new element(s) to a block in text form
   * @param block is an existing block in text form 
   * @param newBlockItem is/are (a) new item(s) to be added in text form
   * @return New block with both the original block and the new item(s)
   */
  protected String outputAddToBlock(String block, String newBlockItem) {
	if ( newBlockItem.isEmpty() ) {
	  return block;
	}
	if ( block.isEmpty() ) {
	  return newBlockItem;
	}
	return block + OUTPUT_BLOCK_SEPARATOR + newBlockItem;
  }
  
  /**
   * Transforms a List of ValueObjects into a block in text form
   * @param blockToTransform List of ValueObjects to be transformed
   * @return block of contents of listToTransform in text form
   */
  protected String blockToTransformerOutput(ArrayList<? extends TransformerOutput> blockToTransform) {
	String Result = "";    
	for (TransformerOutput transformerOutput : blockToTransform) {
	  Result = outputAddToBlock(Result, transformerOutput.toTransformerOutput());
	}	  
	return Result.toString();
  }
 
  /**
   * puts block type braces around an unbraced block in text form  
   * @param unbracedBlock block in text form, without braces
   * @return the unbraced list with the begin and end braces for a block
   */
  protected String outputBracedBlock(String unbracedBlock) {
	  return OUTPUT_BLOCK_BEGIN + unbracedBlock + OUTPUT_BLOCK_END;
  } 
  
}
