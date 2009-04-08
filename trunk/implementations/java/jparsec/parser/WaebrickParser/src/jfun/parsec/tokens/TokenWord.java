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
package jfun.parsec.tokens;

import jfun.parsec.Tokenizer;

/**
 * Represents a word.
 * @author Ben Yu
 *
 * 2004-11-7
 */
public class TokenWord implements java.io.Serializable{
  private final String name;
  /**
   * equals when the word value are equal.
   * @see java.lang.Object#equals(java.lang.Object)
   */
  public boolean equals(final Object v){
    if(v instanceof TokenWord){
      return name.equals(((TokenWord)v).name);
    }
    else return false;
  }
  
  public int hashCode() {
    return name.hashCode();
  }
  public String toString(){return name;}
  /**
   * gets the word value.
   * @return the word value.
   */
  public final String getWord(){return name;}
  TokenWord(final String n){this.name = n;}
  private static final Tokenizer nTokenizer = new Tokenizer(){
    public Object toToken(final CharSequence cs, final int from, final int len){
      return new TokenWord(cs.subSequence(from, from+len).toString());
    }
  };
  /**
   * gets an instance of TokenWord that parses a input range to a TokenWord.
   * @return the tokenizer instance.
   */
  public static Tokenizer getTokenizer(){return nTokenizer;}
}
