/*
 * File			: SiteDef.java
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
import com.uva.se.wparse.util.Strings;



public final class SiteDef extends ValueObject implements Member {
  

  private List<Mapping> mappings;
  
  
  public SiteDef(List<Mapping> mappings){
    this.mappings = mappings;
    System.out.println("debug -- inside " + this.getClass().getSimpleName() + " constructor");
  }
  
  @Override public String toString() {
	  return "site " + Strings.join(" ", mappings) + " end";
	  
  }


}
