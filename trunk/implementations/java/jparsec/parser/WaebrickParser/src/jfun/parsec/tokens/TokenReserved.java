/*****************************************************************************
 * Copyright (C) Zephyr Business Solutions Corp. All rights reserved.            *
 * ------------------------------------------------------------------------- *
 * The software in this package is published under the terms of the BSD      *
 * style license a copy of which has been included with this distribution in *
 * the LICENSE.txt file.                                                     *
 *****************************************************************************/
/*
 * Created on Nov 20, 2004
 *
 * Author Ben Yu
 */
package jfun.parsec.tokens;

/**
 * token for any reserved word.
 * 
 * @author Ben Yu
 *
 * Nov 20, 2004
 */
public class TokenReserved implements java.io.Serializable{
  private final String val;
  public String toString(){return val;}
  /**
   * Get the value of the reserved word.
   * @return the value of the reserved word.
   */
  public final String getValue(){return val;}
  TokenReserved(final String n){this.val = n;}
  
  public boolean equals(Object obj) {
    if(obj instanceof TokenReserved){
      final TokenReserved td2 = (TokenReserved)obj;
      return val.equals(td2.val);
    }
    else return false;
  }
  public int hashCode() {
    return val.hashCode();
  }
}
