/*****************************************************************************
 * Copyright (C) Zephyr Business Solutions Corp. All rights reserved.            *
 * ------------------------------------------------------------------------- *
 * The software in this package is published under the terms of the BSD      *
 * style license a copy of which has been included with this distribution in *
 * the LICENSE.txt file.                                                     *
 *****************************************************************************/
/*
 * Created on Nov 19, 2004
 *
 * Author Ben Yu
 */
package jfun.parsec;



/**
 * This class provides some standard Map implementations.
 * @author Ben Yu
 *
 * Nov 19, 2004
 */
public final class Maps {
  private static final Map _id = new Map(){
    public Object map(Object v) {
      return v;
    }
    public String toString(){return "id";}
  };
  private static final Mapn _idn = new Mapn(){
    public Object map(Object[] v){
      return v;
    }
  };
  /**
   * Returns an identity map. map a = a.
   * @return the Map instance.
   */
  public static Map id(){return _id;}
  /**
   * Returns an identity map. map a = a.
   * @return the Mapn instance.
   */  
  public static Mapn idn(){return _idn;}
  /**
   * Creates a map that maps any object to the same object.
   * @param v the object that is gonna be returned from the Map.
   * @return the Map instance.
   */
  public static Map cnst(final Object v){
    return new Map(){
      public Object map(final Object x){return v;}
    };
  }
  /**
   * Adapts a java.util.Map to jfun.util.Map.
   * @param m the java.util.Map object.
   * @return the jfun.util.Map instance.
   */
  public static Map jmap(final java.util.Map m){
    return new Map(){
      public Object map(final Object k){
        return m.get(k);
      }
    };
  }
  
  /**
   * Transform a PositionedToken object to the wrapped token object.
   * @return the Map instance.
   */
  public static Map toToken(){
    return new Map(){
      public Object map(final Object o){
        return ((PositionedToken)o).getToken();
      }
    };
  }
}
