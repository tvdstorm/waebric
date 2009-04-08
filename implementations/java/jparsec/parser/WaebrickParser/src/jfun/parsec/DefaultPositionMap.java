/*****************************************************************************
 * Copyright (C) Zephyr Business Solutions Corp. All rights reserved.            *
 * ------------------------------------------------------------------------- *
 * The software in this package is published under the terms of the BSD      *
 * style license a copy of which has been included with this distribution in *
 * the LICENSE.txt file.                                                     *
 *****************************************************************************/
/*
 * Created on Dec 12, 2004
 *
 * Author Ben Yu
 */
package jfun.parsec;


/**
 * This default implementation of PositionMap.
 * @author Ben Yu
 *
 * Dec 12, 2004
 */
public class DefaultPositionMap implements PositionMap, java.io.Serializable {
  private final CharSequence src;
  private final int lno;
  private final int cno;
  private final int tabwidth;
  /*
   * @see jfun.parsec.scanner.PositionMap#getSourcePos(int)
   */
  public Pos getPos(final int n) {
    return getPos(n, src, lno, cno, tabwidth);
  }
  static Pos getPos(int n,
      final CharSequence src, 
      final int lno, final int cno, final int tabwidth){
    int ln = lno;
    int cn = cno;
    for(int i=0; i<n; i++){
      final char c = src.charAt(i);
      switch(c){
        case '\n' :
          ln++;
          cn = 1;
          break;
        case '\t':
          cn += tabwidth;
          break;
        default:
          cn++;
      }
    }
    return new Pos(ln, cn);
  }
  /**
   * Create a DefaultPositionMap object.
   * @param src the source.
   * @param lno the starting line number.
   * @param cno the starting column number.
   * @param tabwidth the width of a horizontal tab character ('\t').
   */
  public DefaultPositionMap(final CharSequence src, final int lno, final int cno,
      final int tabwidth) {
    this.src = src;
    this.lno = lno;
    this.cno = cno;
    this.tabwidth = tabwidth;
  }

}
