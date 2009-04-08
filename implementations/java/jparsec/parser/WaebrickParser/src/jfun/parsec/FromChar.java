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
package jfun.parsec;

/**
 * maps char to Object.
 * <p> char -> a
 * @author Ben Yu
 *
 * Nov 20, 2004
 */
public interface FromChar extends java.io.Serializable{
  /**
   * @param from the starting index of this character token.
   * @param len the length of this token.
   * @param c the char
   * @return the object.
   */
  Object fromChar(int from, int len, char c);
}
