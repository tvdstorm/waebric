/*
 * File			: SiteDef.java
 * Project		: WaebrickParser
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

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.util.Strings;

public final class SiteDef extends ValueObject implements Member {
	
	public static final String OUTPUT_SITE	= "site";
	public static final String OUTPUT_MAPPING	= "mapping";

	private static org.apache.log4j.Logger logger = Logger
			.getLogger(SiteDef.class);
	private List<Mapping> mappings;

	public SiteDef(List<Mapping> mappings) {
		this.mappings = mappings;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		return "site " + Strings.join(" ", mappings) + " end";
	}
	
	@Override
	public String toTransformerOutput() {
		
		//site([mapping(\"wpath1/xpath2/yfile.ext\", call(tag(\"site1\")))]), site([\"wpath1/xpath2/yfile.ext\", call(tag(\"site2\"))])
		
		String MappingBlock = "";
		String OutputBlock = "";
		String Result = "";
		
		for (Mapping mapping: mappings) {
			MappingBlock = OUTPUT_MAPPING + outputBracedBlock( mapping.toTransformerOutput() );
			OutputBlock = OUTPUT_SITE + outputBracedBlock( outputBracedList( MappingBlock ) );
			Result = outputAddToBlock( Result, OutputBlock );			
		}
		
		return Result;
	}

}
