/*
 * File			: ModuleDef.java
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

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.model.common.WabrickParseTree;

public final class ModuleDef extends ValueObject implements WabrickParseTree {
	
	public static final String OUTPUT_MODULE		= "module";
	public static final String OUTPUT_MODULE_ID		= "module-id";
	public static final String OUTPUT_IMPORT		= "import";

	private static org.apache.log4j.Logger logger = Logger
			.getLogger(ModuleDef.class);

	private ArrayList<ModuleBody> body;
	private QualifiedName name;
	private ArrayList<QualifiedName> imports;

	public ModuleDef(QualifiedName name, ArrayList<QualifiedName> imports,
			ArrayList<ModuleBody> body) {
		this.body = body;
		this.name = name;
		this.imports = imports;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		return "module " + name + " \n" + imports + body.toString();
	}
	
	//@Override
	public String getTransformerOutput() {
	  	return toTransformerOutput();
	}
	
	@Override
	public String toTransformerOutput() {
		String moduleId = OUTPUT_MODULE_ID + outputBracedBlock( outputBracedList ( outputQuote(name) ) );
		
		String importList = OUTPUT_LIST_EMPTY;
		if (!imports.isEmpty()){			
			for(QualifiedName importItem: imports) {
				importList = outputAddToList(importList, OUTPUT_IMPORT + importItem.toTransformerOutput());
			}
		}
		
		String moduleElements = outputBracedList ( outputAddToList ( importList, listToTransformerOutput(body) ) ) ;
				
		return OUTPUT_MODULE + outputBracedBlock ( outputAddToBlock ( moduleId, moduleElements ) );
	}
}
