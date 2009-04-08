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

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

import jfun.parsec.tokens.Tokens;


/**
 * @author Ben Yu
 *
 * Dec 19, 2004
 */
final class Keywords implements java.io.Serializable{
  private interface String2Token{
    public Object toToken(String s);
  }
  private interface StringCase {
    Comparator getComparator();
    String getKey(String k);
    jfun.parsec.Map getMap(java.util.Map m);
  }
  private static final StringCase case_sensitive = new CaseSensitive();
  private static final StringCase case_insensitive = new CaseInsensitive();
  private static final class CaseSensitive implements StringCase{
    private static final Comparator comparator = new Comparator(){
      public int compare(Object a, Object b){
        if(a==b) return 0;
        else if(a==null) return -1;
        else if(b==null) return 1;
        else return a.toString().compareTo(b.toString());
      }
    };
    public Comparator getComparator(){return comparator;}
    public String getKey(final String k){return k;}
    public jfun.parsec.Map getMap(final java.util.Map m){
      return Maps.jmap(m);
    }
  };
  private static final class CaseInsensitive implements StringCase{
    private static final Comparator comparator = new Comparator(){
      public int compare(Object a, Object b){
        if(a==b) return 0;
        else if(a==null) return -1;
        else if(b==null) return 1;
        else return a.toString().compareToIgnoreCase(b.toString());
      }
    };
    public Comparator getComparator(){return comparator;}
    public String getKey(final String k){return k.toLowerCase();}
    public jfun.parsec.Map getMap(final java.util.Map m){
      return new jfun.parsec.Map(){
        public Object map(final Object k){
          final String key = (String)k;
          return m.get(key.toLowerCase());
        }
      };
    }
  };
  private static StringCase getStringCase(boolean cs){
    return cs?case_sensitive:case_insensitive;
  }
  private static String[] nub(final String[] names, Comparator c){
    final TreeSet set = new TreeSet(c);
    set.addAll(Arrays.asList(names));
    final String[] _names = new String[set.size()];
    set.toArray(_names);
    return _names;
  }
  /*
  //this method tries each keyword sequentially. while getInstance() scans a word and then lookup in a hash table.
  static WordsData instance(final String[] names, boolean cs){
    final StringCase scase = getStringCase(cs);
    final String[] _names = nub(names, scase.getComparator());
    final HashMap map = new HashMap();
    final Lexer[] lxs = new Lexer[_names.length];
    for(int i=0; i<_names.length; i++){
      final String n = _names[i];
      final Token tok = new TokenReserved(n);
      map.put(scase.getKey(n), tok);
      final Parser kw = cs?Scanners.isString(n):Scanners.isStringCI(n);
      final Lexer lx = Lexers.toLexer(
          Scanners.delimited(kw), ConstTokenizer.instance(tok)
      );
      lxs[i] = lx;
    }
    return new WordsData(scase.getMap(map), lxs);
  }*/
  static WordsData getWordsInstance(final Parser wscanner, final String[] keywords, boolean cs){
    return getWordsInstance("words", wscanner, keywords, cs);
  }
  static WordsData getKeywordsInstance(final Parser wscanner, final String[] keywords, boolean cs){
    return getKeywordsInstance("keywords", wscanner, keywords, cs);
  }
  private static final String2Token _as_word = new String2Token(){
    public Object toToken(String s){return Tokens.word(s);}
  };
  private static final String2Token _unknown_keyword = new String2Token(){
    public Object toToken(String s){return null;}
  };  
  static WordsData getWordsInstance(final String name, final Parser wscanner, final String[] keywords, boolean cs){
    return getInstance(name, wscanner, keywords, cs, _as_word);
  }
  static WordsData getKeywordsInstance(final String name, final Parser wscanner, final String[] keywords, boolean cs){
    return getInstance(name, wscanner, keywords, cs, _unknown_keyword);
  }
  private static WordsData getInstance(final String name, final Parser wscanner, final String[] names, boolean cs,
      final String2Token stok){
    final StringCase scase = getStringCase(cs);
    final String[] _names = nub(names, scase.getComparator());
    final HashMap map = new HashMap();
    for(int i=0; i<_names.length; i++){
      final String n = _names[i];
      final Object tok = Tokens.reserved(n);
      map.put(scase.getKey(n), tok);
    }
    final jfun.parsec.Map fmap = scase.getMap(map);
    final Tokenizer tn = new Tokenizer(){
      public Object toToken(final CharSequence cs,
          final int from, final int len){
        final String txt = cs.subSequence(from, from+len).toString();
        final Object t = fmap.map(txt);
        if(t!=null) return t;
        else return stok.toToken(txt);
      }
    };
    final Parser lx = Scanners.lexer(name, wscanner, tn);
    return new WordsData(fmap, new Parser[]{lx});    
  }
}
