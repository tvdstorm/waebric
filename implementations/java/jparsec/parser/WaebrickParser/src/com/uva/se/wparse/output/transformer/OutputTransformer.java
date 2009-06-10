/*
 * File			: OutputTransformer.java
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
package com.uva.se.wparse.output.transformer;

import com.uva.se.wparse.model.common.WabrickParseTree;
import com.uva.se.wparse.output.WaebricParsetreeTransformer;

/**
 * This class transforms the Weabric tree to the expected output. 
 */
public class OutputTransformer implements WaebricParsetreeTransformer{
	
	/**
	 * Transforms the weabric ParseTree to the expected output. 
	 * @param waebricParseTree The waebric parse tree. 
	 * @return The expected output. 
	 */
	public String transform(WabrickParseTree waebricParseTree){
		
		return waebricParseTree.getTransformerOutput();
	}
}
