/*****************************************************************************
 * Copyright (C) Zephyr Business Solutions Corp. All rights reserved.            *
 * ------------------------------------------------------------------------- *
 * The software in this package is published under the terms of the BSD      *
 * style license a copy of which has been included with this distribution in *
 * the LICENSE.txt file.                                                     *
 *****************************************************************************/
/*
 * Created on Dec 16, 2004
 *
 * Author Ben Yu
 */
package jfun.parsec.pattern;

import java.util.regex.Matcher;


/**
 * This class provides all the basic Pattern implementations and all Pattern combinators.
 * @author Ben Yu
 *
 * Dec 16, 2004
 */
public final class Patterns {
  /**
   * Ensures the input has at least l characters left.
   * match length is l if succeed.
   * @param l the number of characters.
   * @return the Pattern object.
   */
  public static Pattern chars_ge(final int l){
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        if(from+l > len) return Pattern.MISMATCH;
        else return l;
      }
    };
  }
  /**
   * Ensures the input has exactly l characters left.
   * match length is l if succeed.
   * @param l the number of characters.
   * @return the Pattern object.
   */
  public static Pattern chars_eq(final int l){
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        if(from+l != len) return Pattern.MISMATCH;
        else return l;
      }
    };
  }
  /**
   * Ensures the input has no character left.
   * match length is 0 if succeed.
   * @return the Pattern object.
   */
  public static Pattern eof(){
    return chars_eq(0);
  }
  /**
   * Succeed with match length 1
   * if the current character in the input is same as character c.
   * Mismatch otherwise.
   * @param c the character to compare with.
   * @return the Pattern object.
   */
  public static Pattern isChar(final char c){
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        if(from>=len) return Pattern.MISMATCH;
        else if(src.charAt(from) != c) return Pattern.MISMATCH;
        else return 1; 
      }
    };
  }
  /**
   * Succeed with match length 1
   * if the current character in the input is between character c1 and c2.
   * @param c1 the first character.
   * @param c2 the second character.
   * @return the Pattern object.
   */
  public static Pattern range(final char c1, final char c2){
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        if(from>=len) return Pattern.MISMATCH;
        final char c = src.charAt(from);
        if(c >= c1 && c <= c2) return 1;
        else return Pattern.MISMATCH; 
      }
    };
  }
  /**
   * Succeed with match length 1
   * if the current character in the input is not between character c1 and c2.
   * @param c1 the first character.
   * @param c2 the second character.
   * @return the Pattern object.
   */
  public static Pattern notRange(final char c1, final char c2){
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        if(from>=len) return Pattern.MISMATCH;
        final char c = src.charAt(from);
        if(c >= c1 && c <= c2) return Pattern.MISMATCH;
        else return 1; 
      }
    };
  }
  /**
   * Succeed with match length 1
   * if the current character in the input is among the given characters.
   * @param cs the characters to compare with.
   * @return the Pattern object.
   */
  public static Pattern among(final char[] cs){
    return isChar(CharPredicates.among(cs));
  }
  /**
   * Succeed with match length 1
   * if the current character in the input is not among the given characters.
   * @param cs the characters to compare with.
   * @return the Pattern object.
   */
  public static Pattern notAmong(final char[] cs){
    return isChar(CharPredicates.notAmong(cs));
  }
  /**
   * Succeed with match length 1
   * if the current character in the input is not the same as character c.
   * Mismatch otherwise.
   * @param c the character to compare with.
   * @return the Pattern object.
   */
  public static Pattern notChar(final char c){
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        if(from>=len) return Pattern.MISMATCH;
        else if(src.charAt(from) == c) return Pattern.MISMATCH;
        else return 1; 
      }
    };
  }
  /**
   * Succeed with match length 1
   * if the current character in the input satisfies the given predicate.
   * Mismatch otherwise.
   * @param cp the predicate object.
   * @return the Pattern object.
   */
  public static Pattern isChar(final CharPredicate cp){
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        if(from>=len) return Pattern.MISMATCH;
        else if(cp.isChar(src.charAt(from))) return 1;
        else return Pattern.MISMATCH; 
      }
      public String toString(){
        return ""+cp;
      }
    };
  }
  /**
   * Succeed with match length 2
   * if there are at least 2 characters in the input and the first character is '\'
   * Mismatch otherwise.
   * @return the Pattern object.
   */
  public static Pattern isEscaped(){
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        if(from>=len-1) return Pattern.MISMATCH;
        else if(src.charAt(from)=='\\') return 2;
        else return Pattern.MISMATCH;
      }
    };
  }

  /**
   * Matches a line comment that starts with a string
   * and end with EOF or Line Feed character.
   * @param open the line comment starting string.
   * @return the Pattern object.
   */
  public static Pattern isLineComment(final String open){
    return seq(isString(open), many(CharPredicates.notChar('\n')));
  }
  /**
   * Matches a string.
   * @return the Pattern object.
   */
  public static Pattern isString(final String str){
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        if(len - from < str.length()) return MISMATCH;
        return matchString(str, src, len, from);
      }
      public String toString(){
        return str;
      }
    };
  }
  /**
   * Matches a string case insensitively.
   * @return the Pattern object.
   */
  public static Pattern isStringCI(final String str){
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        if(len - from < str.length()) return MISMATCH;
        return matchStringCI(str, src, len, from);
      }
    };
  }
  /**
   * Matches a character if the input has at least 1 character 
   * and does not match the given string.
   * @return the Pattern object.
   */
  public static Pattern notString(final String str){
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        if(from >= len) return MISMATCH;
        if(matchString(str, src, len, from) == Pattern.MISMATCH)
          return 1;
        else return MISMATCH;
      }
    };
  }
  /**
   * Matches a character if the input has at least 1 character 
   * and does not match the given string case insensitively.
   * @return the Pattern object.
   */
  public static Pattern notStringCI(final String str){
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        if(from >= len) return MISMATCH;
        if(matchStringCI(str, src, len, from) == Pattern.MISMATCH)
          return 1;
        else return MISMATCH;
      }
    };
  }

  private static boolean compareIgnoreCase(final char a, final char b){
    return Character.toLowerCase(a) == Character.toLowerCase(b);
  }

  private static int matchString(String str,
      final CharSequence src, final int len, 
      final int from){
    final int slen = str.length();
    if(len - from < slen) return Pattern.MISMATCH;
    for(int i=0; i<slen; i++){
      final char exp = str.charAt(i);
      final char enc = src.charAt(from+i);
      if(exp != enc){
        return Pattern.MISMATCH;
      }
    }
    return slen;
  }

  private static int matchStringCI(String str,
      final CharSequence src, final int len, 
      final int from){
    final int slen = str.length();
    if(len - from < slen) return Pattern.MISMATCH;
    for(int i=0; i<slen; i++){
      final char exp = str.charAt(i);
      final char enc = src.charAt(from+i);
      if(!compareIgnoreCase(exp, enc)){
        return Pattern.MISMATCH;
      }
    }
    return slen;
  }

  /**
   * Matches with match length 0 if the Pattern object pp mismatch.
   * Mismatch otherwise.
   * @param pp the Pattern object.
   * @return the new Pattern object.
   */
  public static Pattern not(final Pattern pp){
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        if(pp.match(src,len,from)!=Pattern.MISMATCH) return Pattern.MISMATCH;
        else return 0;
      }
    };
  }
  /**
   * Matches with match length 0 if the Pattern object pp matches.
   * Mismatch otherwise.
   * @param pp the Pattern object.
   * @return the new Pattern object.
   */
  public static Pattern peek(final Pattern pp){
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        if(pp.match(src,len,from)==Pattern.MISMATCH) return Pattern.MISMATCH;
        else return 0;
      }
    };
  }
  /**
   * if the first Pattern object pp1 mismatches, try the second Pattern object pp2.
   * @param pp1 the 1st Pattern object.
   * @param pp2 the 2nd Pattern object.
   * @return the new Pattern object.
   */
  public static Pattern or(final Pattern pp1, final Pattern pp2){
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        final int l1 = pp1.match(src,len,from);
        if(l1!=Pattern.MISMATCH) return l1;
        else return pp2.match(src, len, from);
      }
    };
  }
  /**
   * try 3 Pattern objects subsequently until one matches.
   * @param p1 the 1st Pattern object.
   * @param p2 the 2nd Pattern object.
   * @param p3 the 3rd Pattern object.
   * @return the new Pattern object.
   */
  public static Pattern or(final Pattern p1, final Pattern p2,
      final Pattern p3){
    return _or(new Pattern[]{p1,p2,p3});
  }
  /**
   * try 4 Pattern objects subsequently until one matches.
   * @param p1 the 1st Pattern object.
   * @param p2 the 2nd Pattern object.
   * @param p3 the 3rd Pattern object.
   * @param p4 the 4th Pattern object.
   * @return the new Pattern object.
   */
  public static Pattern or(final Pattern p1, final Pattern p2,
      final Pattern p3, final Pattern p4){
    return _or(new Pattern[]{p1,p2,p3,p4});
  }
  /**
   * try 5 Pattern objects subsequently until one matches.
   * @param p1 the 1st Pattern object.
   * @param p2 the 2nd Pattern object.
   * @param p3 the 3rd Pattern object.
   * @param p4 the 4th Pattern object.
   * @param p5 the 5th Pattern object.
   * @return the new Pattern object.
   */
  public static Pattern or(final Pattern p1, final Pattern p2,
      final Pattern p3, final Pattern p4, final Pattern p5){
    return _or(new Pattern[]{p1,p2,p3,p4,p5});
  }
  /**
   * Find the match length that matches
   * both pattern p1 and pattern p2.
   * Mismatch if either mismatches.
   * @param p1 the 1st pattern.
   * @param p2 the 2nd pattern.
   * @return the new Pattern object.
   */
  public static Pattern and(final Pattern p1, final Pattern p2){
    return _and(new Pattern[]{p1,p2});
  }
  /**
   * Find the match length that matches
   * the 3 given patterns
   * Mismatch if any one mismatches.
   * @param p1 the 1st pattern.
   * @param p2 the 2nd pattern.
   * @param p3 the 3rd pattern.
   * @return the new Pattern object.
   */
  public static Pattern and(
      final Pattern p1, final Pattern p2, final Pattern p3){
    return _and(new Pattern[]{p1,p2,p3});
  }
  /**
   * Find the match length that matches
   * the 4 given patterns
   * Mismatch if any one mismatches.
   * @param p1 the 1st pattern.
   * @param p2 the 2nd pattern.
   * @param p3 the 3rd pattern.
   * @param p4 the 4th pattern.
   * @return the new Pattern object.
   */
  public static Pattern and(final Pattern p1, 
      final Pattern p2, final Pattern p3, final Pattern p4){
    return _and(new Pattern[]{p1,p2,p3,p4});
  }
  /**
   * Find the match length that matches
   * the 5 given patterns
   * Mismatch if any one mismatches.
   * @param p1 the 1st pattern.
   * @param p2 the 2nd pattern.
   * @param p3 the 3rd pattern.
   * @param p4 the 4th pattern.
   * @param p5 the 5th pattern.
   * @return the new Pattern object.
   */
  public static Pattern and(final Pattern p1,
      final Pattern p2, final Pattern p3,
      final Pattern p4, final Pattern p5){
    return _and(new Pattern[]{p1,p2,p3,p4,p5});
  }
  /**
   * Find the match length that matches
   * all of the patterns in the given Pattern object array.
   * Mismatch if any one mismatches.
   * @param pps the Pattern array.
   * @return the new Pattern object.
   */
  public static Pattern and(final Pattern[] pps){
    if(pps.length==0) return always();
    if(pps.length==1) return pps[0];
    return _and(copy(pps));
  }
  /**
   * First matches Pattern object pp1. 
   * If succeed, match the remaining input against Pattern pp2.
   * Fails if either pp1 or pp2 fails.
   * Succeed with the entire match length,
   * which is the sum of the match length of pp1 and pp2.
   * @param pp1 the 1st Pattern object to match.
   * @param pp2 the 2nd Pattern object to match.
   * @return the new Pattern object.
   */
  public static Pattern seq(final Pattern pp1, final Pattern pp2){
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        final int l1 = pp1.match(src,len,from);
        if(l1==Pattern.MISMATCH) return l1;
        final int l2 = pp2.match(src, len, from+l1);
        if(l2==Pattern.MISMATCH) return l2;
        return l1+l2;
      }
    };
  }
  /**
   * Match 3 Pattern objects subsequently until one mismatches.
   * Return the sum of the match length if all succeed.
   * @param p1 the 1st Pattern object to match.
   * @param p2 the 2nd Pattern object to match.
   * @param p3 the 3rd Pattern object to match.
   * @return the new Pattern object.
   */
  public static Pattern seq(final Pattern p1, final Pattern p2,
      final Pattern p3){
    return _seq(new Pattern[]{p1,p2,p3});
  }
  /**
   * Match 4 Pattern objects subsequently until one mismatches.
   * Return the sum of the match length if all succeed.
   * @param p1 the 1st Pattern object to match.
   * @param p2 the 2nd Pattern object to match.
   * @param p3 the 3rd Pattern object to match.
   * @param p4 the 4th Pattern object to match.
   * @return the new Pattern object.
   */
  public static Pattern seq(final Pattern p1, final Pattern p2,
      final Pattern p3, final Pattern p4){
    return _seq(new Pattern[]{p1,p2,p3,p4});
  }
  /**
   * Match 5 Pattern objects subsequently until one mismatches.
   * Return the sum of the match length if all succeed.
   * @param p1 the 1st Pattern object to match.
   * @param p2 the 2nd Pattern object to match.
   * @param p3 the 3rd Pattern object to match.
   * @param p4 the 4th Pattern object to match.
   * @param p5 the 5th Pattern object to match.
   * @return the new Pattern object.
   */
  public static Pattern seq(final Pattern p1, final Pattern p2,
      final Pattern p3, final Pattern p4, final Pattern p5){
    return _seq(new Pattern[]{p1,p2,p3,p4,p5});
  }
  /**
   * try an array of Pattern objects subsequently until one matches.
   * Mismatch if the array is empty.
   * @param pps the Pattern object array.
   * @return the new Pattern object.
   */
  public static Pattern or(final Pattern[] pps){
    if(pps.length==0) return never();
    else if(pps.length==1) return pps[0];
    final Pattern[] cpps = copy(pps);
    return _or(cpps);
  }

  /**
   * Runs an array of Pattern objects subsequently until one mismatches.
   * Return the total match length if all succeed.
   * @param pps the Pattern object array.
   * @return the new Pattern object.
   */
  public static Pattern seq(final Pattern[] pps){
    if(pps.length==0) return always();
    else if(pps.length==1) return pps[0];
    final Pattern[] cpps = copy(pps);
    return _seq(cpps);
  }
  private static Pattern[] copy(final Pattern[] a){
    final Pattern[] ret = new Pattern[a.length];
    for(int i=0; i<a.length; i++){
      ret[i] = a[i];
    }
    return ret;
  }

  /**
   * Matches if the input has at least n characters
   * and the first n characters all satisfy the given predicate.
   * @param n the number of characters to test.
   * @param cp the predicate object.
   * @return the Pattern object.
   */
  public static Pattern repeat(final int n, final CharPredicate cp){
    if(n==0) return always();
    if(n==1) return isChar(cp);
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        return match_repeat(n, cp, src, len, from, 0);
      }
    };
  }
  /**
   * Matches if the input n occurrences of Pattern pp.
   * @param n the number of occurrences.
   * @param pp the Pattern object.
   * @return the new Pattern object.
   */
  public static Pattern repeat(final int n, final Pattern pp){
    if(n==0) return always();
    if(n==1) return pp;
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        return match_repeat(n, pp, src, len, from, 0);
      }
    };
  }
  private static int min(int a, int b){
    return a>b?b:a;
  }
  /**
   * Matches if the input starts with min or more characters
   * that all satisfy the given predicate,
   * mismatch otherwise.
   * @param min the minimal number of characters to match.
   * @param cp the predicate.
   * @return the Pattern object.
   */
  public static Pattern many(final int min, final CharPredicate cp){
    if(min<0) throw new IllegalArgumentException("min<0");
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        final int minlen = match_repeat(min, cp, src, len, from, 0);
        if(minlen==MISMATCH) return MISMATCH;
        return match_many(cp, src, len, from+minlen, minlen);
      }
    };
  }
  /**
   * Matches 0 or more characters that all satisfy the given predicate.
   * @param cp the predicate.
   * @return the Pattern object.
   */
  public static Pattern many(final CharPredicate cp){
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        return match_many(cp, src, len, from, 0);
      }
    };
  }
  /**
   * Matches if the input starts with min or more occurrences of
   * patterns recognized by Pattern object pp,
   * mismatch otherwise.
   * @param min the minimal number of occurrences to match.
   * @param pp the Pattern object.
   * @return the new Pattern object.
   */
  public static Pattern many(final int min, final Pattern pp){
    if(min<0) throw new IllegalArgumentException("min<0");
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        final int minlen = match_repeat(min, pp, src, len, from, 0);
        if(MISMATCH==minlen) return MISMATCH;
        return match_many(pp, src, len, from+minlen, minlen);
      }
    };
  }
  /**
   * Matches 0 or more occurrences of
   * patterns recognized by Pattern object pp.
   * @param pp the Pattern object.
   * @return the new Pattern object.
   */
  public static Pattern many(final Pattern pp){
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        return match_many(pp, src, len, from, 0);
      }
    };
  }
  /**
   * Matches at least min and at most max number of characters
   * that satisfies the given predicate,
   * mismatch otherwise.
   * @param min the minimal number of characters.
   * @param max the maximal number of characters.
   * @param cp the predicate.
   * @return the Pattern object.
   */
  public static Pattern some(final int min, final int max, final CharPredicate cp){
    if(max<0 || min <0 || min > max) throw new IllegalArgumentException();
    if(max == 0) return always();
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        final int minlen = match_repeat(min, cp, src, len, from, 0);
        if(minlen==MISMATCH) return MISMATCH;
        return match_some(max-min, cp, src, len, from+minlen, minlen);
      }
    };
  }
  /**
   * Matches at most max number of characters
   * that satisfies the given predicate.
   * @param max the maximal number of characters.
   * @param cp the predicate.
   * @return the Pattern object.
   */
  public static Pattern some(final int max, final CharPredicate cp){
    if(max < 0) throw new IllegalArgumentException("max<0");
    if(max == 0) return always();
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        return match_some(max, cp, src, len, from, 0);
      }
    };
  }
  /**
   * Matches at least min and at most max number of occurrences
   * of pattern recognized by Pattern object pp,
   * mismatch otherwise.
   * @param min the minimal number of occurrences of pattern.
   * @param max the maximal number of occurrences of pattern.
   * @param pp the Pattern object.
   * @return the new Pattern object.
   */
  public static Pattern some(final int min, final int max, final Pattern pp){
    if(min<0 || max<0 || min>max) throw new IllegalArgumentException();
    if(max == 0) return always();
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        final int minlen = match_repeat(min, pp, src, len, from, 0);
        if(MISMATCH==minlen) return MISMATCH;
        return match_some(max-min, pp, src, len, from+minlen, minlen);
      }
    };
  }
  /**
   * Matches at most max number of occurrences
   * of pattern recognized by Pattern object pp.
   * @param max the maximal number of occurrences of pattern.
   * @param pp the Pattern object.
   * @return the new Pattern object.
   */
  public static Pattern some(final int max, final Pattern pp){
    if(max<0) throw new IllegalArgumentException("max<0");
    if(max == 0) return always();
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        return match_some(max, pp, src, len, from, 0);
      }
    };
  }
  /**
   * Try two pattern objects, pick the one with the longer match length.
   * If two pattern objects have the same length, the first one is favored.
   * @param p1 the 1st pattern object.
   * @param p2 the 2nd pattern object.
   * @return the new Pattern object.
   */
  public static Pattern longer(final Pattern p1, final Pattern p2){
    return longest(new Pattern[]{p1, p2});
  }
  /**
   * Try an array of pattern objects, pick the one with the longest match length.
   * If two pattern objects have the same length, the first one is favored.
   * @param pps the array of Pattern objects.
   * @return the new Pattern object.
   */
  public static Pattern longest(final Pattern pps[]){
    if(pps.length==0) return never();
    if(pps.length==1) return pps[0];
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        int r = MISMATCH;
        for(int i=0;i<pps.length;i++){
          final int l = pps[i].match(src,len,from);
          if(l > r) r = l;
        }
        return r;
      }
    };
  }
  /**
   * Try two pattern objects, pick the one with the shorter match length.
   * If two pattern objects have the same length, the first one is favored.
   * @param p1 the 1st pattern object.
   * @param p2 the 2nd pattern object.
   * @return the new Pattern object.
   */
  public static Pattern shorter(final Pattern p1, final Pattern p2){
    return shortest(new Pattern[]{p1, p2});
  }
  /**
   * Try an array of pattern objects, pick the one with the shortest match length.
   * If two pattern objects have the same length, the first one is favored.
   * @param pps the array of Pattern objects.
   * @return the new Pattern object.
   */
  public static Pattern shortest(final Pattern pps[]){
    if(pps.length==0) return never();
    if(pps.length==1) return pps[0];
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        int r = MISMATCH;
        for(int i=0;i<pps.length;i++){
          final int l = pps[i].match(src,len,from);
          if(l != MISMATCH){
            if(r==MISMATCH || l < r)
              r = l;
          }
        }
        return r;
      }
    };
  }
  /**
   * If the condiction Pattern object cond matches,
   * match the remaining input against Pattern object yes.
   * Otherwise, match the input against Pattern object no.
   * @param cond the condition Pattern.
   * @param yes the true Pattern.
   * @param no the false Pattern.
   * @return the new Pattern object.
   */
  public static Pattern ifelse(final Pattern cond, final Pattern yes, final Pattern no){
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        final int lc = cond.match(src, len, from);
        if(lc==MISMATCH){
          return no.match(src, len, from);
        }
        else{
          final int ly = yes.match(src, len, from+lc);
          if(ly==MISMATCH) return MISMATCH;
          else return lc+ly;
        }
      }
    };
  }
  /**
   * Matches characters that satisfies the given predicate
   * for 1 or more times.
   * Return the total match length.
   * @return the new Pattern object.
   */
  public static Pattern many1(final CharPredicate cp){
    return many(1, cp);
  }
  /**
   * Match with 0 length even if Pattern object pp mismatches.
   * @return the new Pattern object.
   */
  public static Pattern optional(final Pattern pp){
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        final int l= pp.match(src, len, from);
        return (l==Pattern.MISMATCH)?0:l;
      }
    };
  }

  /**
   * A Pattern object that always returns MISMATCH.
   * @return the Pattern object.
   */
  public static Pattern never(){
    return _never;
  }
  /**
   * A Pattern object that always matches with 0 length.
   * @return the Pattern object.
   */
  public static Pattern always(){
    return _always;
  }
  
  
  
  /**
   * a decimal number that has at least one number before the decimal point.
   * the decimal point and the numbers to the right are optional.
   * 0, 11., 2.3 are all good candidates. While .1, . are not.
   * @return the Pattern object.
   */
  public static Pattern isDecimalL(){
    final CharPredicate cp = CharPredicates.isDigit(); 
    return seq(many1(cp),
        optional(
            seq(isChar('.'), many(cp))
        )
    );
  }
  /**
   * Recognizes a decimal point and 1 or more digits after it.
   * @return the Pattern object.
   */
  public static Pattern isDecimalR(){
    return seq(isChar('.'), many1(CharPredicates.isDigit()));
  }
  /**
   * Recognizes a decimal number that can start with a decimal point.
   * @return the Pattern object.
   */
  public static Pattern isDecimal(){
    return or(isDecimalL(), isDecimalR());
  }
  /**
   * a pattern for a standard english word.
   * it starts with an underscore or an alphametic character, followed by 0 or more alphanumeric characters.
   * @return the Pattern object.
   */
  public static Pattern isWord(){
    /*
    return seq(isChar(CharPredicates.isAlpha_()), 
        many(CharPredicates.isAlphaNumeric()));
    */
    return regex("[a-zA-Z_][0-9a-zA-Z_]*");
  }
  /**
   * pattern for an integer. ([0-9]+) 
   * @return the Pattern object.
   */
  public static Pattern isInteger(){
    return many1(CharPredicates.isDigit());
  }
  /**
   * pattern for a octal integer that starts with a 0 and followed by 0 or more [0-7] characters.
   * @return the Pattern object.
   */
  public static Pattern isOctInteger(){
    return seq(isChar('0'), many(CharPredicates.range('0','7')));
  }
  /**
   * pattern for a decimal integer. 
   * It starts with a non-zero digit and followed by 0 or more digits.
   * @return the Pattern object.
   */
  public static Pattern isDecInteger(){
    return seq(range('1', '9'), many(CharPredicates.isDigit()));
  }
  /**
   * pattern for a hex integer. 
   * It starts with a 0x or 0X, followed by 1 or more hex digits.
   * @return the Pattern object.
   */
  public static Pattern isHexInteger(){
    return seq(or(isString("0x"), isString("0X")), 
        many1(CharPredicates.isHexDigit()));
  }
  /**
   * Recognizes a the exponent part of a scientific number notation.
   * It can be e12, E-1, jfun.yan.etc.
   * @return the Pattern object.
   */
  public static Pattern isExponential(){
    return seq(
        among(new char[]{'e','E'}),
        optional(isChar('-')),
        isInteger()
    );
  }
  /**
   * Adapt a regular expression pattern to a jfun.parsec.pattern.Pattern;
   * @param p the regular expression pattern.
   * @return the jfun.parsec.pattern.Pattern object.
   */
  public static Pattern regex(final java.util.regex.Pattern p){
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        if(from > len) return Pattern.MISMATCH;
        final Matcher matcher = p.matcher(src.subSequence(from, len));
        if(matcher.lookingAt()){
          return matcher.end();
        }
        else return Pattern.MISMATCH;
      }
    };
  }
  /**
   * Adapt a regular expression pattern string to a jfun.parsec.pattern.Pattern;
   * @param s the regular expression pattern string.
   * @return the jfun.parsec.pattern.Pattern object.
   */
  public static Pattern regex(String s){
    return regex(java.util.regex.Pattern.compile(s));
  }
  private static final Pattern _never = new Pattern(){
    public int match(final CharSequence src, final int len, 
        final int from){
      return Pattern.MISMATCH;
    }
  };
  private static final Pattern _always = new Pattern(){
    public int match(final CharSequence src, final int len, 
        final int from){
      return 0;
    }
  };
  
  private static int match_repeat(final int n, final CharPredicate cp,
      final CharSequence src, final int len, final int from, final int acc){
    final int tail = from + n;
    if(tail > len) return Pattern.MISMATCH;
    for(int i=from;i<tail;i++){
      if(!cp.isChar(src.charAt(i))) return Pattern.MISMATCH;
    }
    return n+acc;
  }
  private static int match_repeat(final int n, final Pattern pp,
      final CharSequence src, final int len, final int from, final int acc){
    int end = from;
    for(int i=0;i<n;i++){
      final int l = pp.match(src,len,end);
      if(l==Pattern.MISMATCH) return Pattern.MISMATCH;
      end += l;
    }
    return end-from+acc;
  }
  private static int match_some(final int max, final CharPredicate cp,
      final CharSequence src, final int len, final int from, final int acc){
    final int k = min(max+from, len);
    for(int i=from;i<k;i++){
      if(!cp.isChar(src.charAt(i))) return i-from+acc;
    }
    return k-from+acc;
  }
  private static int match_some(final int max, final Pattern pp,
      final CharSequence src, final int len, final int from, final int acc){
    int begin = from;
    for(int i=0;i<max;i++){
      final int l = pp.match(src, len, begin);
      if(Pattern.MISMATCH==l) return begin-from+acc;
      begin+=l;
    }
    return begin-from+acc;
  }
  private static int match_many(final CharPredicate cp,
      final CharSequence src, final int len, final int from, final int acc){
    for(int i=from;i<len;i++){
      if(!cp.isChar(src.charAt(i))) return i-from+acc;
    }
    return len-from+acc;
  }
  private static int match_many(final Pattern pp,
      final CharSequence src, final int len, final int from, final int acc){
    for(int i=from;;){
      final int l = pp.match(src,len,i);
      if(Pattern.MISMATCH==l) return i-from+acc;
      //we simply stop the loop when infinity is found. this may make the parser more user-friendly.
      if(l==0) return i-from+acc;//throw new IllegalStateException("infinite loop");
      i += l;
    }
  }
  private static Pattern _or(final Pattern[] pps){
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        for(int i=0;i<pps.length;i++){
          final int l = pps[i].match(src,len,from);
          if(l!=Pattern.MISMATCH) return l;
        }
        return Pattern.MISMATCH;
      }
    };
  }
  private static Pattern _seq(final Pattern[] pps){
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        int end = from;
        for(int i=0;i<pps.length;i++){
          final int l = pps[i].match(src,len,end);
          if(l==Pattern.MISMATCH) return l;
          end += l;
        }
        return end-from;
      }
    };
  }
  private static Pattern _and(final Pattern[] pps){
    return new Pattern(){
      public int match(final CharSequence src, final int len, 
          final int from){
        int ret = 0;
        for(int i=0;i<pps.length;i++){
          final int l = pps[i].match(src,len,from);
          if(l==MISMATCH) return MISMATCH;
          if(l>ret) ret=l;
        }
        return ret;
      }
    };
  }
}
