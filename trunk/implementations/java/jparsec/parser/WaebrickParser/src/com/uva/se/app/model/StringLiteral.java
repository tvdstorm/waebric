package com.uva.se.app.model;



public final class StringLiteral extends ValueObject implements Expression {
  public final String string;

  public StringLiteral(String string) {
    this.string = string;
    System.out.println("debug -- inside stringLiteral constructor");
  }
  
  @Override public String toString() {
    return string;
  }
}
