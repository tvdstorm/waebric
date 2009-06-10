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

public interface WaebricParsetreeTransformer {
	public String transform(WabrickParseTree waebricParseTree);
}
