package com.uva.se.app.model;

import java.util.Collections;
import java.util.List;

import com.uva.se.app.util.Strings;



public final class ModuleBody extends ValueObject {
  public final List<Member> members;

  public ModuleBody(List<Member> members) {
    this.members = Collections.unmodifiableList(members);
    System.out.println("debug -- inside " + this.getClass().getName() + " constructor");
  }
  
  @Override public String toString() {
    return Strings.join(" ", members);
  }
}
