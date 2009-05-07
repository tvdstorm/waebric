/*
 * File			: MethodDef.java
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
package com.uva.se.wparse.model.declaration;

import java.util.List;

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.model.markup.Argument;
import com.uva.se.wparse.model.statement.Statement;



public final class MethodDef extends ValueObject implements Member {
  
  private String name;
  private Argument arguments;
  private List<Statement> statements;
  
  
  public MethodDef( String name,  Argument arguments,  List<Statement> statements){ 
    
    this.name = name;
    this.arguments = arguments;
    this.statements = statements;
    System.out.println("debug -- inside " + this.getClass().getSimpleName() + " constructor");
  }
  
  @Override public String toString() {
	  return "def " + name + "("  + arguments + ")" + statements + " end";
	  
  }


}
