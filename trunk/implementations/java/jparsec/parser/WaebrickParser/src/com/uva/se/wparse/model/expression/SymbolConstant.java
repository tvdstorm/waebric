/*
 * File			: SymbolConstant.java
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


public class SymbolConstant implements Expression {

	private String symbol;

	public SymbolConstant(String symbol) {
		super();
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}
	
	
}
