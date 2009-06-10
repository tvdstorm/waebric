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

public class OutputTransformer implements WaebricParsetreeTransformer{
	
	public String transform(WabrickParseTree waebricParseTree){
		
		return waebricParseTree.getTransformerOutput();
	}
}
