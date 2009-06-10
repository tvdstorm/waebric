/*
 * File			: SiteDef.java
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
package com.uva.se.wparse.model.module;

import java.util.List;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.util.Strings;

/**
 * The definition of the site is stored in this part of the model. A SiteDefinition
 * consists of a set of mappings. 
 */
public final class SiteDef extends WaebricParseTreeNode implements Member {

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(SiteDef.class);

	/**
	 * The set of mappings of the root of the site
	 */
	private List<Mapping> mappings;

	/**
	 * Constructs a definition of the site. 
	 * 
	 * @param mappings The set of mappings of the root of the site. 
	 * 
	 */
	public SiteDef(List<Mapping> mappings) {
		this.mappings = mappings;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	/**
	 * Represents the definition of a function as Weabric code.
	 */
	@Override
	public String toString() {
		return "site " + Strings.join(" ", mappings) + " end";
	}

	/**
	 * The name of the site used in generating the output.
	 */
	private static final String OUTPUT_SITE = "site";

	/**
	 * The name of the mappings used by generating the output.
	 */
	private static final String OUTPUT_MAPPING = "mapping";

	/**
	 * Represents the function as the expection output code.
	 */
	@Override
	public String toTransformerOutput() {
		String MappingBlock = "";
		String Result = "";

		for (Mapping mapping : mappings) {
			MappingBlock = OUTPUT_MAPPING
					+ outputBracedBlock(mapping.toTransformerOutput());
			Result = outputAddToBlock(Result, MappingBlock);
		}

		return OUTPUT_SITE + outputBracedBlock(outputBracedList(Result, true));
	}

}
