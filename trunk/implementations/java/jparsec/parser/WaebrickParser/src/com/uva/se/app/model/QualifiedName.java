package com.uva.se.app.model;

import java.util.List;


import com.uva.se.app.util.Strings;


public final class QualifiedName extends ValueObject {
  public final List<String> names;

  public QualifiedName(List<String> names) {
    this.names = names;
  }
  
  @Override public String toString() {
    return Strings.join(".", names);
  }
}
