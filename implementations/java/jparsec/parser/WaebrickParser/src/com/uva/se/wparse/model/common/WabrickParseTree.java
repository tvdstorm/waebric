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
