/*****************************************************************************
 * Copyright (C) Zephyr Business Solutions Corp. All rights reserved.            *
 * ------------------------------------------------------------------------- *
 * The software in this package is published under the terms of the BSD      *
 * style license a copy of which has been included with this distribution in *
 * the LICENSE.txt file.                                                     *
 *****************************************************************************/
package jfun.parsec;
/**
 * 
 * The class that represents the "unit" concept in functional language.
 * It is the equivalent of haskell ().<br>
 * 
 * This class is a singleton.
 * @author Ben Yu
 *
 * Nov 22, 2004
 */
public final class Unit implements java.io.Serializable{//as the type ()
  private Unit(){}
  public String toString(){return "()";}
  /**
   * Get a Unit instance.
   * @return the singleton object.
   */
  public static Unit instance(){return singleton;}
  private static final Unit singleton = new Unit();
}