/*
 * File			: BlockExpression.java
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

import java.util.Collections;
import java.util.List;

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.util.Strings;



public final class BlockExpression extends ValueObject implements Expression {
  private List<Expression> expr;

  public BlockExpression(List<Expression> expr) {
    this.expr = Collections.unmodifiableList(expr);
    System.out.println("debug -- inside " + this.getClass().getSimpleName() + " constructor");
  }
  
  @Override public String toString() {
    return "[" + Strings.join(" ", expr) + "]";
  }
}
