/*
 * File			: KeyValuePair.java
 * Project		: WaebrickParser
 * 				: Practicum opdracht Software Construction
 * 
 * Authors		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * 
 * Description	:
 * 
 */
package com.uva.se.wparse.model.expression;


public class KeyValuePair implements Expression {

	private String key;
	private Expression value;
	
	
	public KeyValuePair(String key, Expression value) {
		this.key = key;
		this.value = value;
	}


	@Override
	public String toString() {
		return key + ":" + value;
	}
	
	
	
	
}
