/*
 * File			: QualifiedName.java
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
import java.util.List;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.util.Strings;

public final class QualifiedName extends ValueObject {
	
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(QualifiedName.class);
	private List<String> names;

	public QualifiedName(List<String> names) {
		this.names = names;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		return Strings.join(".", names);
	}

	@Override
	public String toTransformerOutput() {
		List<String> quotedNames = new ArrayList<String>();
		for (String name: names) {
			quotedNames.add( outputQuote( name ) );
		}
		
		return Strings.join(",", quotedNames );
	}
}
