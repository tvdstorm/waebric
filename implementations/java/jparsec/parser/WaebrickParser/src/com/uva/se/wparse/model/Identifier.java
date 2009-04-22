package com.uva.se.wparse.model;



public final class Identifier extends ValueObject implements Expression {
  public final String name;

  public Identifier(String name) {
    this.name = name;
    System.out.println("debug -- inside Identifier constructor");
  }
  
  @Override public String toString() {
    return name;
  }
}
