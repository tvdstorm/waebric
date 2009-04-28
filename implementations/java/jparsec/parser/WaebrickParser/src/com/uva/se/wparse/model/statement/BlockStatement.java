/*
 * File			: BlockStatement.java
 * Project		: WaebrickParser
 * 				: Practicum opdracht Software Construction
 * 
 * Authors		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * 
 * Description	:
 * 
 */

package com.uva.se.wparse.model.statement;

import java.util.Collections;
import java.util.List;

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.util.Strings;



public final class BlockStatement extends ValueObject implements Statement {
	private List<Statement> statements;

  public BlockStatement(List<Statement> statements) {
    this.statements = Collections.unmodifiableList(statements);
    System.out.println("debug -- inside " + this.getClass().getSimpleName() + " constructor");
  }
  
  @Override public String toString() {
    return "{" + Strings.join(" ", statements) + "}";
  }
}
