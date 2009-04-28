/*
 * File			: Operator.java
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


public enum Operator {
  AND("&&"),
  OR("||"),
  EQ("="),
  DOT("."),
  ;
  
  private final String name;
  
  private Operator(final String name) {
    this.name = name;
  }
  
  @Override public String toString() {
    return name;
  }
}
