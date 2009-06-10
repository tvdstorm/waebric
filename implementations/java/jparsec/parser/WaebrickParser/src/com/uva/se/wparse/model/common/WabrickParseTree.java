/*
 * File			: WabrickParseTree.java
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

/**
 * Indicates that it is the root of the Weabric parse tree. This function
 * constructs the output of the parse tree.
 */
public interface WabrickParseTree {

	/**
	 * Method to get the output for the Output Transformer
	 * 
	 * @return the output of the transformation process
	 */
	public String getTransformerOutput();
}
