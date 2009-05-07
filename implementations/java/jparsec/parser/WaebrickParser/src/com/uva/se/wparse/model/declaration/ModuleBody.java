/*
 * File			: ModuleBody.java
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

import java.util.Collections;
import java.util.List;

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.util.Strings;



public final class ModuleBody extends ValueObject {
	private List<Member> members;

  public ModuleBody(List<Member> members) {
    this.members = Collections.unmodifiableList(members);
    System.out.println("debug -- inside " + this.getClass().getName() + " constructor");
  }
  
  @Override public String toString() {
    return Strings.join(" ", members);
  }
}
