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

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.model.statement.AssignmentWithFormals;
import com.uva.se.wparse.util.Strings;



public final class BlockArgument extends ValueObject implements Argument {
	
	private static org.apache.log4j.Logger logger = Logger.getLogger(BlockArgument.class);
	
	private List<Argument> args;

  public BlockArgument(List<Argument> args) {
    this.args = Collections.unmodifiableList(args);
    if (logger.isDebugEnabled()) {
		logger.debug("Creating " + this.getClass().getSimpleName()
				+ " with values : " + toString());
	}
  }
  
  @Override public String toString() {
    return "{" + Strings.join(" ", args) + "}";
  }
}
