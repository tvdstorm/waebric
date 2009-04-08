/*****************************************************************************
 * Copyright (C) Zephyr Business Solutions Corp. All rights reserved.            *
 * ------------------------------------------------------------------------- *
 * The software in this package is published under the terms of the BSD      *
 * style license a copy of which has been included with this distribution in *
 * the LICENSE.txt file.                                                     *
 *****************************************************************************/
/*
 * Created on 2004-11-14
 *
 * Author Ben Yu
 */
package jfun.parsec;

/**
 * @author Ben Yu
 *
 * 2004-11-14
 */
final class LazyParser extends Parser {

  /*
   * @see jfun.parsec.Parser#parse(jfun.parsec.ParserState)
   */
  boolean parse(ParseContext ctxt) {
    return eval.eval().parse(ctxt);
  }
  boolean parse(ParseContext ctxt, int look_ahead){
    return eval.eval().parse(ctxt, look_ahead);
  }
  private final ParserEval eval;
  
  /**
   * @param eval
   */
  private LazyParser(final String name, final ParserEval eval) {
    super(name);
    this.eval = eval;
  }
  static Parser instance(final String name, final ParserEval e){
    return new LazyParser(name, e);
  }
}
