/*
 * File			: SingleAttribute.java
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
package com.uva.se.wparse.model.markup;

import org.codehaus.jparsec.Token;

public class SingleAttribute implements Attribute  {

	private Token prefix;
	private String identifier;
	
	public SingleAttribute(Token prefix, String identifier) {
		super();
		this.prefix = prefix;
		this.identifier = identifier;
	}
	
	@Override
	public String toString() {
		return prefix + identifier;
	}
	
	
	
}
