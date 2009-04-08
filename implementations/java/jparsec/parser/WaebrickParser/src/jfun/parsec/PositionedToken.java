/*****************************************************************************
 * Copyright (C) Zephyr Business Solutions Corp. All rights reserved.            *
 * ------------------------------------------------------------------------- *
 * The software in this package is published under the terms of the BSD      *
 * style license a copy of which has been included with this distribution in *
 * the LICENSE.txt file.                                                     *
 *****************************************************************************/
/*
 * Created on 2004-11-7
 *
 * Author Ben Yu
 */
package jfun.parsec;

/**
 * This class carries the position information of a token.
 * @author Ben Yu
 *
 * 2004-11-7
 */
public final class PositionedToken implements java.io.Serializable{
  private final int ind;
  private final int len;
  private final Object tok;
  
  /**
   * Gets the length of the token.
   * @return the length of the token.
   */
  public int getLength(){
    return len;
  }
  /**
   * gets the index of the token in the orginal CharSequence.
   * @return the index.
   */
  public int getIndex(){return ind;}
  /**
   * gets the token.
   * @return the token.
   */
  public Object getToken(){return tok;}

  /**
   * Create a PositionedToken object.
   * @param i the starting index.
   * @param l the length of the token.
   * @param tok the token.
   */
  public PositionedToken(final int i, final int l, final Object tok) {
    this.ind = i;
    this.len = l;
    this.tok = tok;
  }
  public String toString(){
    return tok.toString();
  }
}
