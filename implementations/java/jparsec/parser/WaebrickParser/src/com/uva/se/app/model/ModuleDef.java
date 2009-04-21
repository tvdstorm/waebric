package com.uva.se.app.model;

import java.util.ArrayList;




public final class ModuleDef extends ValueObject {
  public final ArrayList<ModuleBody> body;
  public final QualifiedName name;

  public ModuleDef(QualifiedName name, ArrayList<ModuleBody> body) {
    this.body = body;
    this.name = name;
    System.out.println("debug -- inside " + this.getClass().getName() + " constructor");
  }
  
  @Override public String toString() {
    return "module " + name + " \n" + body.toString();
  }
}
