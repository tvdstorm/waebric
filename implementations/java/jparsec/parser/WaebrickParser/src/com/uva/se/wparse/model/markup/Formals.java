/*
 * File			: Formals.java
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
import com.uva.se.wparse.model.expression.Identifier;
import com.uva.se.wparse.util.Strings;



public final class Formals extends ValueObject implements Argument {
	
	private static org.apache.log4j.Logger logger = Logger.getLogger(Formals.class);
	
	private List<Identifier> identifierList = null;

  public Formals(List<Identifier> identifierList) {
    this.identifierList = Collections.unmodifiableList(identifierList);
    if (logger.isDebugEnabled()) {
		logger.debug("Creating " + this.getClass().getSimpleName()
				+ " with values : " + toString());
	}
  }
  
  @Override public String toString() {
	  if(identifierList != null){
		  return "(" + Strings.join(" ", identifierList) + ")";
	  }else{
		  return "()";
	  }
  }
  
  @Override
  public String toTransformerOutput() {
	  String Result = "";
	  
	  if (identifierList != null) {
		  	for (Identifier ident: identifierList) {
		  		if (ident instanceof ValueObject) {
		  			Result = outputAddToBlock(Result, ((ValueObject)ident).toTransformerOutput());
		  		}
		  	}
	  }	  
	  return Result;
  }  
}
