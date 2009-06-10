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

/**
 * This interface indicates the main Parser of the Waebric language.
 * It converts the sourcecode to a Weabric Parse Tree. 
 */
public interface WeabrickParser {

	/**
	 * Converts the sourcecode to a Weabric Parse Tree. 
	 * @param sourceCode The Waebric sourcecode. 
	 * @return The Waebric parse tree.
	 */
	public WabrickParseTree parse(String sourceCode) throws ParserException;
}
