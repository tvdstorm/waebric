/*****************************************************************************
 * Copyright (C) Zephyr Business Solutions Corp. All rights reserved.            *
 * ------------------------------------------------------------------------- *
 * The software in this package is published under the terms of the BSD      *
 * style license a copy of which has been included with this distribution in *
 * the LICENSE.txt file.                                                     *
 *****************************************************************************/
/*
 * Created on Dec 19, 2004
 *
 * Author Ben Yu
 */
package jfun.parsec;


/**
 * @author Ben Yu
 *
 * Dec 19, 2004
 */
final class WordsData implements java.io.Serializable{
  private final Map toks;
  private final Parser[] lexers;
  
  /**
   * @param parsers
   * @param lexers
   */
  WordsData(final Map toks, final Parser[] lexers) {
    this.toks = toks;
    this.lexers = lexers;
  }
  /**
   * @return Returns the lexers.
   */
  Parser[] getLexers() {
    return lexers;
  }
  /**
   * @return Returns the parsers.
   */
  Map getParsers() {
    return toks;
  }
}
