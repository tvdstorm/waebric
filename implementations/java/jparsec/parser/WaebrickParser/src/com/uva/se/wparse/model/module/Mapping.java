/*
 * File			: Mapping.java
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

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.model.expression.Identifier;
import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.util.Strings;

/**
 * A Weabric mapping consists of a
 * - Set of identifiers;
 * - File;
 * - Extension;
 * - Markup;
 */
public class Mapping extends WaebricParseTreeNode {
	
	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger.getLogger(Mapping.class);

	/**
	 * 
	 */
	private List<Identifier> path = null;
	
	/**
	 * 
	 */
	private Identifier file = null;
	
	/**
	 * 
	 */
	private String extention = "";
	
	/**
	 * 
	 */
	private Markup markup = null;
	
	
	public Mapping(List<Identifier> path, String extention, Markup markup) {
		this.file = path.remove(path.size()-1);
		this.path = path;
		this.extention = extention;
		this.markup = markup;
		 if(logger.isDebugEnabled()){
				logger.debug("Creating " + this.getClass().getSimpleName() + " with values : " + toString());
			}
	}


	@Override
	public String toString() {
		return Strings.join("/", path) + "/" + file + "." + extention + ":" + markup;
	}
	
	
	private static final String OUTPUT_MAPPING_PATH = "path";
	
	@Override
	public String toTransformerOutput() {
		
		String filename = file + "." + extention;
		String pathname = Strings.join("/", path);
		String fullfilename = outputQuote( filename );
		if (!pathname.isEmpty()) {
			fullfilename = OUTPUT_MAPPING_PATH + outputBracedBlock( outputQuote( pathname ) + "," + fullfilename );
		}
		
		return  fullfilename + OUTPUT_BLOCK_SEPARATOR + markup.toTransformerOutput();
	}
}
