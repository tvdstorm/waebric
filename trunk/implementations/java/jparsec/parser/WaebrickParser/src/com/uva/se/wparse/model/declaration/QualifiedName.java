/*
 * File			: QualifiedName.java
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
import com.uva.se.wparse.util.Strings;


public final class QualifiedName extends ValueObject {
  private List<String> names;

  public QualifiedName(List<String> names) {
    this.names = names;
  }
  
  @Override public String toString() {
    return Strings.join(".", names);
  }
}
