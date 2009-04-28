/*
 * File			: BlockArgument.java
 * Project		: WaebrickParser
 * 				: Practicum opdracht Software Construction
 * 
 * Authors		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * 
 * Description	:
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
