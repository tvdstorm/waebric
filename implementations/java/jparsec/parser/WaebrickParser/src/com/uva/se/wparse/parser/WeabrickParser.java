package com.uva.se.wparse.parser;

import com.uva.se.wparse.model.common.WabrickParseTree;

public interface WeabrickParser {

	/**
	 * Main ...
	 * @param sourceCode
	 * @return
	 */
	public WabrickParseTree parse(String sourceCode);
}
