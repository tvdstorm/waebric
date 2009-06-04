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

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.model.expression.Identifier;
import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.util.Strings;

public class Mapping extends ValueObject {
	
	public static final String OUTPUT_MAPPING_PATH = "path";
	
	private static org.apache.log4j.Logger logger = Logger.getLogger(Mapping.class);

	private List<Identifier> path = null;
	private Identifier file = null;
	private String extention = "";
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
	
	@Override
	public String toTransformerOutput() {
		
		String filename = file + "." + extention;
		String pathname = Strings.join("/", path);
		String fullfilename = outputQuote( filename );
		if (!pathname.isEmpty()) {
			fullfilename = outputQuote( pathname ) + "," + fullfilename;
		}
		
		String markupOutput = OUTPUT_EMPTY_ELEMENT;
		if (markup instanceof ValueObject) {
			markupOutput = markupOutput + ((ValueObject) markup).toTransformerOutput();
		}
	
		return OUTPUT_MAPPING_PATH + outputBracedBlock( fullfilename ) + OUTPUT_BLOCK_SEPARATOR + markupOutput;
	}
}
