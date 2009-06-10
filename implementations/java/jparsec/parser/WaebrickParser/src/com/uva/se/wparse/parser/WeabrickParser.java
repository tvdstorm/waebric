/*
 * File			: WeabrickParser.java
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
package com.uva.se.wparse.parser;

import com.uva.se.wparse.exception.ParserException;
import com.uva.se.wparse.model.common.WabrickParseTree;

public interface WeabrickParser {

	/**
	 * Main ...
	 * @param sourceCode
	 * @return
	 */
	public WabrickParseTree parse(String sourceCode) throws ParserException;
}
