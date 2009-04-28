/*
 * File			: NaturalExpression.java
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



public final class NaturalExpression extends ValueObject implements Expression {
	private String natural;

  public NaturalExpression(String natural) {
    this.natural = natural;
    System.out.println("debug -- inside " + this.getClass().getSimpleName() + " constructor");
  }
  
  @Override public String toString() {
    return natural;
  }
}
