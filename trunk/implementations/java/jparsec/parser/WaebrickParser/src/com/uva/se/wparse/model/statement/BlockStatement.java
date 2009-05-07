/*
 * File			: BlockStatement.java
 * Project		: WaebrickParser
 * 				: Waebrick Parser, practicum opdracht Software Construction
 * 
 * Author		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * Description	:
 * 
 * 
 * Change history
 * -----------------------------------------------------------
 * Date			Change				 
 * -----------------------------------------------------------
 * 07-05-2009	Initial version.
 * 
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
