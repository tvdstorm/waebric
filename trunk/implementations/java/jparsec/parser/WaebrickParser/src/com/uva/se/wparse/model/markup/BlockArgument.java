/*
 * File			: BlockArgument.java
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

package com.uva.se.wparse.model.markup;

import java.util.Collections;
import java.util.List;

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.util.Strings;



public final class BlockArgument extends ValueObject implements Argument {
	private List<Argument> args;

  public BlockArgument(List<Argument> args) {
    this.args = Collections.unmodifiableList(args);
    System.out.println("debug -- inside " + this.getClass().getSimpleName() + " constructor");
  }
  
  @Override public String toString() {
    return "{" + Strings.join(" ", args) + "}";
  }
}
