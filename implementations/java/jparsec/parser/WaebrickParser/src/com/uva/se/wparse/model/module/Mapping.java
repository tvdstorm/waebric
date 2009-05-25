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
	
	//\"wpath1/xpath2/yfile.ext\", call(tag(\"site1\")
	@Override
	public String toTransformerOutput() {
		
		String markupOutput = OUTPUT_EMPTY_ELEMENT;
		if (markup instanceof ValueObject) {
			markupOutput = markupOutput + ((ValueObject) markup).toTransformerOutput();
		}
		
		return outputQuote(Strings.join("/", path) + "/" + file + "." + extention) + "," + markupOutput;
	}
}
