/*
 * File			: BinaryExpression.java
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


public final class BinaryExpression extends ValueObject implements Expression {
  public final Expression left;
  public final Operator op;
  public final Expression right;
  
  public BinaryExpression(Expression left, Operator op, Expression right) {
    this.left = left;
    this.op = op;
    this.right = right;
    System.out.println("debug creating binary expression");
  }
  
  @Override public String toString() {
    return "(" + left + " " + op + " " + right + ")";
  }
}
