/*
 * File			: StringLiteral.java
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

import com.uva.se.wparse.model.common.ValueObject;



public final class StringLiteral extends ValueObject implements Expression {
	private String string;

  public StringLiteral(String string) {
    this.string = string;
    System.out.println("debug -- inside stringLiteral constructor");
  }
  
  @Override public String toString() {
    return string;
  }
}
