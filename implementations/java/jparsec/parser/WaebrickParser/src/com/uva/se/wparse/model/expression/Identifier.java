/*
 * File			: Identifier.java
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



public final class Identifier extends ValueObject implements Expression {
	private String name;

  public Identifier(String name) {
    this.name = name;
    System.out.println("debug -- inside " + this.getClass().getSimpleName() + " constructor");
  }
  
  @Override public String toString() {
    return name;
  }
}
