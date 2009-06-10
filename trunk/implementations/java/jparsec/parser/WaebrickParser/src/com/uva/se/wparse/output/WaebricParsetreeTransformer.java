/*
 * File			: WaebricParsetreeTransformer.java
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
package com.uva.se.wparse.output;

import com.uva.se.wparse.model.common.WabrickParseTree;

/**
 * The class which implement this interface transforms the Weabric tree 
 * to the expected output. 
 */
public interface WaebricParsetreeTransformer {
	
	/**
	 * Transforms the weabric ParseTree to the expected output. 
	 * @param waebricParseTree The waebric parse tree. 
	 * @return The expected output. 
	 */
	public String transform(WabrickParseTree waebricParseTree);
}