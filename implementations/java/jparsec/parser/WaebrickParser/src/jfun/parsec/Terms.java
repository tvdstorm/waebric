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


import jfun.parsec.tokens.MyToken;
import jfun.parsec.tokens.TokenDecimal;
import jfun.parsec.tokens.TokenQuoted;
import jfun.parsec.tokens.TokenWord;
import jfun.parsec.tokens.TokenInteger;
//import jfun.parsec.scanner.Lexers;



/**
 * This helper class provides convenient api's to build lexer
 * and parsers for terminals.
 * @author Ben Yu
 *
 * Nov 20, 2004
 */
public final class Terms implements java.io.Serializable{
  private final Words words;
  /**
   * gets the parser for the terminals identified by tnames.
   * The PositionedToken object is returned from the result parser.
   * @param tnames the names of the terminals.
   * @return the Parser.
   */
  public Parser getParser(final String[] tnames){
    return getParser(tnames, toLabel(tnames));
  }
  /**
   * gets the parser for the terminals identified by tnames.
   * The PositionedToken object is returned.
   * @param name the name of the parser.
   * @param tnames the names of the terminals.
   * @return the Parser.
   */
  public Parser getParser(final String name, final String[] tnames){
    return getParser(name, tnames, toLabel(tnames));
  }
  /**
   * gets the parser for the terminals identified by tnames.
   * The PositionedToken object is returned from the result parser.
   * @param tnames the names of the terminals.
   * @param expected the label when this parser fails.
   * @return the Parser.
   */
  public Parser getParser(final String[] tnames, final String expected){
    return getParser("term", tnames, expected);
  }
  /**
   * gets the parser for the terminals identified by tnames.
   * The PositionedToken object is returned from the result parser.
   * @param name the name of the parser.
   * @param tnames the names of the terminals.
   * @param expected the label when this parser fails.
   * @return the Parser.
   */
  public Parser getParser(final String name, final String[] tnames, 
      final String expected){
    if(tnames.length == 0) return Parsers.zero(name);
    final Parser[] ps = new Parser[tnames.length];
    for(int i=0; i<tnames.length; i++){
      ps[i] = Parsers.token(isToken(words.getToken(tnames[i])));
    }
    return Parsers.sum(name, ps).label(name, expected);
  }
  /**
   * gets the parser for a terminal identified by tname.
   * The PositionedToken object is returned from the result parser.
   * @param name the name of the parser.
   * @param tname the name of the terminal.
   * @param expected the label when this parser fails.
   * @return the Parser.
   */
  public Parser getParser(final String name, final String tname, 
      final String expected){
    return Parsers.token(name, isToken(words.getToken(tname)))
      .label(name, expected);
  }
  /**
   * gets the parser for a terminal identified by tname.
   * The PositionedToken object is returned from the result parser.
   * @param tname the name of the terminal.
   * @param expected the label when this parser fails.
   * @return the Parser.
   */
  public Parser getParser(final String tname, final String expected){
    return getParser("term", tname, expected);
  }
  /**
   * gets the parser for a terminal identified by tname.
   * The PositionedToken object is returned from the result parser.
   * @param tname the name of the terminal.
   * @return the Parser.
   */
  public Parser getParser(final String tname){
    return getParser(tname, tname);
  }
  /**
   * gets the lexer for the terminals.
   * @return the lexer.
   */
  public Parser getLexer(){
    return words.getLexer();
  }
  /**
   * Creates a Terms object for lexing and parsing the operators with names specified in ops,
   * and for lexing and parsing the keywords case insensitively. 
   * Keywords and operators are lexed as TokenReserved.
   * Words that are not among the keywords are lexed as TokenWord. 
   * A word is defined as an alpha numeric string that starts with [_a-zA-Z],
   * with 0 or more [0-9_a-zA-Z] following.
   * @param ops the operator names.
   * @param keywords the keyword names.
   * @return the Terms instance.
   */
  public static Terms getCaseInsensitive(final String[] ops, final String[] keywords){
    return new Terms(Lexers.getCaseInsensitive(ops, keywords));
  }
  /**
   * Creates a Terms object for lexing and parsing the operators with names specified in ops,
   * and for lexing and parsing the keywords case sensitively. 
   * Keywords and operators are lexed as TokenReserved.
   * Words that are not among the keywords are lexed as TokenWord. 
   * A word is defined as an alpha numeric string that starts with [_a-zA-Z],
   * with 0 or more [0-9_a-zA-Z] following.
   * @param ops the operator names.
   * @param keywords the keyword names.
   * @return the Terms instance.
   */
  public static Terms getCaseSensitive(final String[] ops, final String[] keywords){
    return new Terms(Lexers.getCaseSensitive(ops, keywords));
  }
  /**
   * Creates a Terms object for lexing and parsing the operators with names specified in ops,
   * and for lexing and parsing the keywords case insensitively. 
   * Keywords and operators are lexed as TokenReserved.
   * Words that are not among the keywords are lexed as TokenWord. 
   * @param wscanner the scanner that identifies a word in the language.
   * @param ops the operator names.
   * @param keywords the keyword names.
   * @return the Terms instance.
   */
  public static Terms getCaseInsensitive(final Parser wscanner, final String[] ops, final String[] keywords){
    return new Terms(Lexers.getCaseInsensitive(wscanner, ops, keywords));
  }
  /**
   * Creates a Terms object for lexing and parsing the operators with names specified in ops,
   * and for lexing and parsing the keywords case sensitively. 
   * Keywords and operators are lexed as TokenReserved.
   * Words that are not among the keywords are lexed as TokenWord. 
   * @param wscanner the scanner that identifies a word in the language.
   * @param ops the operator names.
   * @param keywords the keyword names.
   * @return the Terms instance.
   */
  public static Terms getCaseSensitive(final Parser wscanner, final String[] ops, final String[] keywords){
    return new Terms(Lexers.getCaseSensitive(wscanner, ops, keywords));
  }
  /**
   * Creates a Terms object for lexing the operators with names specified in ops.
   * Operators are lexed as TokenReserved.
   * @param ops the operator names.
   * @return the Terms instance.
   */
  public static Terms getOperators(final String[] ops){
    return new Terms(Lexers.getOperators(ops));
  }
  /**
   * gets a Parser object to parse Character token.
   * @param name the parser name.
   * @param fc the mapping to map char to an object returned by the parser.
   * @return the parser
   */
  public static Parser charParser(final String name, final FromChar fc){
    return Parsers.token(name, new FromToken(){
      public Object fromToken(PositionedToken ptok){
        final Object t = ptok.getToken();
        if(t instanceof Character){
          final Character c = (Character)t;
          return fc.fromChar(ptok.getIndex(), ptok.getLength(), c.charValue());
        }
        else return null;
      }
    });
  }
  /**
   * gets a Parser object to parse String token.
   * @param name the parser name.
   * @param fc the mapping to map String to an object returned by the parser.
   * @return the parser
   */
  public static Parser stringParser(final String name, final FromString fc){
    return Parsers.token(name, new FromToken(){
      public Object fromToken(PositionedToken ptok){
        final Object t = ptok.getToken();
        if(t instanceof String){
          return fc.fromString(ptok.getIndex(), ptok.getLength(), t.toString());
        }
        else return null;
      }
    });
  }
  /**
   * gets a Parser object to parse TokenQuoted.
   * @param name the parser name.
   * @param fc the mapping to map the quoted string to an object returned by the parser.
   * @return the parser
   */
  public static Parser quotedWordParser(final String name, final FromString3 fc){
    return Parsers.token(name, new FromToken(){
      public Object fromToken(PositionedToken ptok){
        final Object t = ptok.getToken();
        if(t instanceof TokenQuoted){
          final TokenQuoted c = (TokenQuoted)t;
          return fc.fromString3(ptok.getIndex(), ptok.getLength(),
              c.getOpen(), c.getQuoted(), c.getClose());
        }
        else return null;
      }
    });
  }
  /**
   * gets a Parser object to parse TokenWord.
   * @param name the parser name.
   * @param fc the mapping to map the word to an object returned by the parser.
   * @return the parser
   */
  public static Parser wordParser(final String name, final FromString fc){
    return Parsers.token(name, new FromToken(){
      public Object fromToken(PositionedToken ptok){
        final Object t = ptok.getToken();
        if(t instanceof TokenWord){
          final TokenWord c = (TokenWord)t;
          return fc.fromString(ptok.getIndex(), ptok.getLength(), c.getWord());
        }
        else return null;
      }
    });
  }
  /**
   * Create a parser that recognizes MyToken object.
   * @param fm the FromMyText object to recognize MyToken object.
   * @return the Tokenizer object.
   */
  public static Parser myParser(final FromMyText fm){
    return myParser("myParser", fm);
  }
  /**
   * Create a parser that recognizes MyToken object.
   * @param name the name of the parser object.
   * @param fm the FromMyText object to recognize MyToken object.
   * @return the Tokenizer object.
   */
  public static Parser myParser(final String name, final FromMyText fm){
    return Parsers.token(name, new FromToken(){
      public Object fromToken(PositionedToken ptok){
        final Object t = ptok.getToken();
        if(t instanceof MyToken){
          final MyToken mt = (MyToken)t;
          return fm.fromMyText(ptok.getIndex(), ptok.getLength(), 
              mt.getText(), mt.getKind());
        }
        return null;
      }
    });
  }
  /**
   * Create a parser that recognizes MyToken of a certain kind.
   * @param kind the token kind to recognize.
   * @param fs the FromString object to transform.
   * @return the Parser object.
   */

  public static Parser myParser(final int kind, final FromString fs){
    return myParser("myParser", kind, fs);
  }
  /**
   * Create a parser that recognizes MyToken of a certain kind.
   * @param name the Parser name.
   * @param kind the token kind to recognize.
   * @param fs the FromString object to transform.
   * @return the Parser object.
   */
  public static Parser myParser(final String name, final int kind, final FromString fs){
    return Parsers.token(name, new FromToken(){
      public Object fromToken(PositionedToken ptok){
        final Object t = ptok.getToken();
        if(t instanceof MyToken){
          final MyToken mt = (MyToken)t;
          if(mt.getKind() != kind) return null;
          return fs.fromString(ptok.getIndex(), ptok.getLength(), mt.getText());
        }
        return null;
      }
    });
    
  }
  /**
   * gets a Parser object to parse Long token.
   * @param name the parser name.
   * @param fc the mapping to map the number to an object returned by the parser.
   * @return the parser
   */
  public static Parser integerParser(final String name, final FromLong fc){
    return Parsers.token(name, new FromToken(){
      public Object fromToken(final PositionedToken ptok){
        final Object t = ptok.getToken();
        if(t instanceof Long){
          final Long c = (Long)t;
          return fc.fromLong(ptok.getIndex(), ptok.getLength(), c.longValue());
        }
        else return null;
      }
    });
  }
  /**
   * gets a Parser object to parse token of arbitrary length integer.
   * @param fs the mapping to map the number to an object returned by the parser.
   * @return the parser
   */
  public static Parser integerParser(final FromString fs){
    return integerParser("integerParser", fs);
  }
  /**
   * gets a Parser object to parse token of arbitrary length integer.
   * @param name the parser name.
   * @param fs the mapping to map the number to an object returned by the parser.
   * @return the parser
   */
  public static Parser integerParser(final String name, final FromString fs){
    return Parsers.token(name, new FromToken(){
      public Object fromToken(PositionedToken ptok){
        final Object t = ptok.getToken();
        if(t instanceof TokenInteger){
          final TokenInteger ti = (TokenInteger)t;
          return fs.fromString(ptok.getIndex(), ptok.getLength(), ti.getString());
        }
        else return null;
      }
    });
  }
  /**
   * gets a Parser object to parse TokenDecimal.
   * @param name the parser name.
   * @param fc the mapping to map the decimal to an object returned by the parser.
   * @return the parser
   */
  public static Parser decimalParser(final String name, final FromString fc){
    return Parsers.token(name, new FromToken(){
      public Object fromToken(final PositionedToken ptok){
        final Object t = ptok.getToken();
        if(t instanceof TokenDecimal){
          final TokenDecimal c = (TokenDecimal)t;
          return fc.fromString(ptok.getIndex(), ptok.getLength(), c.getString());
        }
        else return null;
      }
    });
  }
  /**
   * gets a Parser object to parse Character token.
   * @param fc the mapping to map char to an object returned by the parser.
   * @return the parser
   */
  public static Parser charParser(final FromChar fc){
    return charParser("char", fc);
  }
  /**
   * gets a Parser object to parse String token.
   * @param fc the mapping to map String to an object returned by the parser.
   * @return the parser
   */
  public static Parser stringParser(final FromString fc){
    return stringParser("stringLiteral", fc);
  }
  /**
   * gets a Parser object to parse TokenQuoted.
   * @param fc the mapping to map the quoted string to an object returned by the parser.
   * @return the parser
   */
  public static Parser quotedWordParser(final FromString3 fc){
    return quotedWordParser("quotedName", fc);
  }
  /**
   * gets a Parser object to parse TokenWord.
   * @param fc the mapping to map the word to an object returned by the parser.
   * @return the parser
   */
  public static Parser wordParser(final FromString fc){
    return wordParser("name", fc);
  }
  /**
   * gets a Parser object to parse Long token.
   * @param fc the mapping to map the number to an object returned by the parser.
   * @return the parser
   */
  public static Parser integerParser(final FromLong fc){
    return integerParser("integer", fc);
  }
  /**
   * gets a Parser object to parse TokenDecimal.
   * @param fc the mapping to map the decimal to an object returned by the parser.
   * @return the parser
   */
  public static Parser decimalParser(final FromString fc){
    return decimalParser("decimal", fc);
  }
  private Terms(final Words words){
    this.words = words;
  }
  private static FromToken isToken(final Object t){
    return new FromToken(){
      public Object fromToken(PositionedToken ptok){
        final Object obj = ptok.getToken();
        if(obj != t) return null;
        return ptok;
      }
    };
  }
  private static String toLabel(final String[] keys){
    if(keys.length == 0) return "";
    final StringBuffer buf = new StringBuffer();
    buf.append('[').append(keys[0]);
    for(int i=1; i<keys.length; i++){
      buf.append(',').append(keys[i]);
    }
    buf.append(']');
    return buf.toString();
  }
}
