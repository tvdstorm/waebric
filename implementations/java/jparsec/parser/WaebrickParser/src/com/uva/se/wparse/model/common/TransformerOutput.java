/*
 * File			: TransformerOutput.java
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
 * This interface indicates that the node which implements this interface can be
 * used for rendering output. Every node of the parse tree renders some output
 * which is used in the process for creating the output.
 */
public interface TransformerOutput {

	/**
	 * Creates an String respresention of the node of the parse tree which is
	 * used in the output.
	 * 
	 * @return The string which is used in the output.
	 */
	public String toTransformerOutput();
}
