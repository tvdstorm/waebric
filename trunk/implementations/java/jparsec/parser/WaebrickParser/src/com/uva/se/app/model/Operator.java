package com.uva.se.app.model;


public enum Operator {
  AND("&&"),
  OR("||");
  
  private final String name;
  
  private Operator(final String name) {
    this.name = name;
  }
  
  @Override public String toString() {
    return name;
  }
}
