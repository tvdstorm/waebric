package com.uva.se.wparse.model;

import java.util.List;




public final class MappingDef extends ValueObject implements Member {
  
  public final String path;
 // public final List<String> parameters = new ArrayList<String>();
  
  
  
  public MappingDef( String path){ 
    
    this.path = path;

    System.out.println("debug -- inside " + this.getClass().getSimpleName() + " constructor");
  }
  
  @Override public String toString() {
	  return ""; //path;
	  
  }


}
