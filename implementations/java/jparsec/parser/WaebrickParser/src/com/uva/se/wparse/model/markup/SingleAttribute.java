/*
 * File			: SingleAttribute.java
 * Project		: WaebrickParser
 * 				: Practicum opdracht Software Construction
 * 
 * Authors		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * 
 * Description	:
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
