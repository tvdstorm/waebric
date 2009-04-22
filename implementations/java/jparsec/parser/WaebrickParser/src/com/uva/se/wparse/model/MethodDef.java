package com.uva.se.wparse.model;

import java.util.ArrayList;
import java.util.List;



public final class MethodDef extends ValueObject implements Member {
  
  public final String name;
  public final List<String> parameters = new ArrayList<String>();
  
  
  
  public MethodDef( String name, String firstParameter, List<String> otherParameters){ //, List<String> parameters) {
    
    this.name = name;
    this.parameters.add(firstParameter);
    this.parameters.addAll(otherParameters);
    System.out.println("debug -- inside " + this.getClass().getSimpleName() + " constructor");
  }
  
  @Override public String toString() {
	  return "def " + name + " end";
	  
  }


}
