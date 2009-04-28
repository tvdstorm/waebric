/*
 * File			: MethodDef.java
 * Project		: WaebrickParser
 * 				: Practicum opdracht Software Construction
 * 
 * Authors		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * 
 * Description	:
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
