/*
 * File			: BlockExpression.java
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

package com.uva.se.wparse.model.expression;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.util.Strings;



public final class BlockExpression extends ValueObject implements Expression {
	private static org.apache.log4j.Logger logger = Logger.getLogger(BlockExpression.class);

  public static final String OUTPUT_LIST = "list";	
	
  private List<Expression> expr;

  public BlockExpression(List<Expression> expr) {
    this.expr = Collections.unmodifiableList(expr);
    if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
  }
  
  @Override public String toString() {
    return "[" + Strings.join(" ", expr) + "]";
  }
  
  @Override 
  public String toTransformerOutput() {
	  String ListBlock = OUTPUT_LIST_EMPTY;
	  
	  for (Expression expression: expr) {
		  ListBlock = outputAddToList(ListBlock, ((ValueObject)expression).toTransformerOutput());
	  }  
	  
	  return OUTPUT_LIST + outputBracedBlock( outputBracedList( ListBlock ) );	  
  }
}
