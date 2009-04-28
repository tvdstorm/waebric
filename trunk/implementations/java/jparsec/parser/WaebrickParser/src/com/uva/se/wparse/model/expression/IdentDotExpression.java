/*
 * File			: IdentDotExpression.java
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



public final class IdentDotExpression extends ValueObject implements Expression {
	private String ident;
	private Expression expr;

  public IdentDotExpression(String ident, Expression expr) {
    this.ident = ident;
    this.expr = expr;
    System.out.println("debug -- inside Identifier constructor");
  }
  
  @Override public String toString() {
    return expr + "." + ident;
  }
}
