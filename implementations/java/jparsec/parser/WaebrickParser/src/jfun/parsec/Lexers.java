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

import jfun.parsec.pattern.Patterns;
import jfun.parsec.tokens.TokenCharLiteral;
import jfun.parsec.tokens.TokenDecimal;
import jfun.parsec.tokens.TokenInteger;
import jfun.parsec.tokens.TokenLong;
import jfun.parsec.tokens.TokenQuoted;
import jfun.parsec.tokens.TokenStringLiteral;
import jfun.parsec.tokens.TokenWord;


/**
 * Provides some predefined basic lexer objects.
 * A lexer is a character level parser that returns a token
 * based on the recognized character range.
 * @author Ben Yu
 *
 * Dec 19, 2004
 */
public final class Lexers {
  private static final Parser _charLiteral = charLiteral("charLiteral");
  /**
   * returns the lexer that's gonna parse single quoted character literal (escaped by '\'),
   * and then converts the character to a Character.
   * @return the lexer.
   */
  public static Parser charLiteral(){
    return _charLiteral;
  }
  /**
   * returns the lexer that's gonna parse single quoted character literal (escaped by '\'),
   * and then converts the character to a Character.
   * @param name the lexer name.
   * @return the lexer.
   */
  public static Parser charLiteral(final String name){
    return Scanners.lexer(name, 
        Scanners.isQuotedChar(),
          TokenCharLiteral.getTokenizer());
  }
  private static final Parser _stringLiteral = stringLiteral("stringLiteral");
  /**
   * returns the lexer that's gonna parse double quoted string literal (escaped by '\'),
   * and convert the string to a String token.
   * @return the lexer.
   */
  public static Parser stringLiteral(){
    return _stringLiteral;
  }
  /**
   * returns the lexer that's gonna parse double quoted string literal (escaped by '\'),
   * and convert the string to a String token.
   * @param name the lexer name.
   * @return the lexer.
   */
  public static Parser stringLiteral(final String name){
    return Scanners.lexer(name,
        Scanners.isQuotedString(),
        TokenStringLiteral.getDoubleQuoteTokenizer()
    );
  }
  private static final Parser _sqlStringLiteral = sqlStringLiteral("string quoted by '");
  /**
   * returns the lexer that's gonna parse single quoted string literal (single quote is escaped with another single quote),
   * and convert the string to a String token.
   * @return the lexer.
   */
  public static Parser sqlStringLiteral(){
    return _sqlStringLiteral;
  }
  /**
   * returns the lexer that's gonna parse single quoted string literal (single quote is escaped with another single quote),
   * and convert the string to a String token.
   * @param name the lexer name.
   * @return the lexer.
   */
  public static Parser sqlStringLiteral(final String name){
    return Scanners.lexer(name,
        Scanners.isSqlString(),
        TokenStringLiteral.getSqlTokenizer()
    );
  }
  private static final Parser _decimal = decimal("decimal");
  /**
   * returns the lexer that's gonna parse a decimal number (valid patterns are: 1, 2.3, 000, 0., .23),
   * and convert the string to a TokenDecimal.
   * @return the lexer.
   */
  public static Parser decimal(){
    return _decimal;
  }
  /**
   * returns the lexer that's gonna parse a decimal number (valid patterns are: 1, 2.3, 000, 0., .23),
   * and convert the string to a TokenDecimal.
   * @param name the lexer name.
   * @return the lexer.
   */
  public static Parser decimal(final String name){
    return Scanners.lexer(name,
        Scanners.delimited(Scanners.isPattern(Patterns.isDecimal(), "decimal number")),
        TokenDecimal.getTokenizer()
    );
  }
  private static final Parser _integer = integer("integer");
  /**
   * returns the lexer that's gonna parse a integer number (valid patterns are: 0, 00, 1, 10),
   * and convert the string to a Long token.
   * The difference between integer() and decInteger() is that decInteger does not allow a number starting with 0.
   * @return the lexer.
   */
  public static Parser integer(){
    return _integer;
  }
  /**
   * returns the lexer that's gonna parse a integer number (valid patterns are: 0, 00, 1, 10),
   * and convert the string to a Long token.
   * The difference between integer() and decInteger() is that decInteger does not allow a number starting with 0.
   * @param name the lexer name.
   * @return the lexer.
   */
  public static Parser integer(final String name){
    return Scanners.lexer(name, Scanners.delimited(
        Scanners.isPattern(Patterns.isInteger(), "integer")),
        TokenInteger.getTokenizer());
  }
  private static final Parser _decInteger = decInteger("decInteger");
  /**
   * returns the lexer that's gonna parse a decimal integer number (valid patterns are: 1, 10, 123),
   * and convert the string to a Long token.
   * The difference between integer() and decInteger() is that decInteger does not allow a number starting with 0.
   * @return the lexer.
   */
  public static Parser decInteger(){
    return _decInteger;
  }
  /**
   * returns the lexer that's gonna parse a decimal integer number (valid patterns are: 1, 10, 123),
   * and convert the string to a Long token.
   * The difference between integer() and decInteger() is that decInteger does not allow a number starting with 0.
   * @param name the lexer name.
   * @return the lexer.
   */
  public static Parser decInteger(final String name){
    return Scanners.lexer(name,
        Scanners.delimited(Scanners.isPattern(Patterns.isDecInteger(),
            "decInteger")), TokenLong.getDecTokenizer());
  }
  private static final Parser _octInteger = octInteger("octInteger");
  /**
   * returns the lexer that's gonna parse a octal integer number (valid patterns are: 0, 07, 017, 0371 jfun.yan.etc.),
   * and convert the string to a Long token.
   * an octal number has to start with 0.
   * @return the lexer.
   */
  public static Parser octInteger(){
    return _octInteger;
  }
  /**
   * returns the lexer that's gonna parse a octal integer number (valid patterns are: 0, 07, 017, 0371 jfun.yan.etc.),
   * and convert the string to a Long token.
   * an octal number has to start with 0.
   * @param name the lexer name.
   * @return the lexer.
   */
  public static Parser octInteger(final String name){
    return Scanners.lexer(name,
        Scanners.delimited(Scanners.isPattern(
            Patterns.isOctInteger(), "octInteger")), TokenLong.getOctTokenizer());
  }
  private static final Parser _hexInteger = hexInteger("hexInteger");
  /**
   * returns the lexer that's gonna parse a hex integer number (valid patterns are: 0x1, 0Xff, 0xFe1 jfun.yan.etc.),
   * and convert the string to a Long token.
   * an hex number has to start with either 0x or 0X.
   * @return the lexer.
   */
  public static Parser hexInteger(){
    return _hexInteger;
  }
  /**
   * returns the lexer that's gonna parse a hex integer number (valid patterns are: 0x1, 0Xff, 0xFe1 jfun.yan.etc.),
   * and convert the string to a Long token.
   * an hex number has to start with either 0x or 0X.
   * @param name the lexer name.
   * @return the lexer.
   */
  public static Parser hexInteger(final String name){
    return Scanners.lexer(name,
        Scanners.delimited(Scanners.isPattern(Patterns.isHexInteger(), "hexInteger"))
        , TokenLong.getHexTokenizer());
  }
  private static final Parser _allInteger = allInteger("allInteger");
  /**
   * returns the lexer that's gonna parse decimal, hex, and octal numbers
   * and convert the string to a Long token.
   * @return the lexer.
   */
  public static Parser allInteger(){
    return _allInteger;
  }
  /**
   * returns the lexer that's gonna parse decimal, hex, and octal numbers
   * and convert the string to a Long token.
   * @param name the lexer name.
   * @return the lexer.
   */
  public static Parser allInteger(final String name){
    return Parsers.plus(name, hexInteger(), decInteger(), octInteger());
  }
  private static final Parser _word = word("word");
  /**
   * returns the lexer that's gonna parse any word.
   * and convert the string to a TokenWord.
   * A word starts with an alphametic character, followed by 0 or more alphanumeric characters.
   * @return the lexer.
   */
  public static Parser word(){
    return _word;
  }
  /**
   * returns the lexer that's gonna parse any word.
   * and convert the string to a TokenWord.
   * A word starts with an alphametic character, followed by 0 or more alphanumeric characters.
   * @param name the lexer name.
   * @return the lexer.
   */
  public static Parser word(final String name){
    return Scanners.lexer(name, Scanners.delimited(
        Scanners.isPattern(Patterns.isWord(), "word")),
        TokenWord.getTokenizer());
  }
  /**
   * Create a lexer that parsers a string literal quoted by open and close,
   * and then converts it to a String token instance.
   * @param name the lexer name.
   * @param open the opening character.
   * @param close the closing character.
   * @return the lexer.
   */
  public static Parser quoted(final String name, final char open, final char close){
    return Scanners.lexer(name, Scanners.quoted(name, open, close), TokenQuoted.getTokenizer(open, close));
  }
  /**
   * Create a lexer that parsers a string literal quoted by open and close,
   * and then converts it to a String token instance.
   * @param open the opening character.
   * @param close the closing character.
   * @return the lexer.
   */
  public static Parser quoted(final char open, final char close){
    return quoted("quoted", open, close);
  }

  /**
   * Creates a Words object for lexing the operators with names specified in ops.
   * Operators are lexed as TokenReserved.
   * @param ops the operator names.
   * @return the Words instance.
   */
  public static Words getOperators(final String[] ops){
    return Words.getOperators(ops);
  }
  /**
   * Creates a Words object for lexing the operators with names specified in ops,
   * and for lexing the keywords case insensitively.
   * Keywords and operators are lexed as TokenReserved.
   * Words that are not among the keywords are lexed as TokenWord. 
   * A word is defined as an alpha numeric string that starts with [_a-zA-Z],
   * with 0 or more [0-9_a-zA-Z] following. 
   * @param ops the operator names.
   * @param keywords the keyword names.
   * @return the Words instance.
   */
  public static Words getCaseInsensitive(
      final String[] ops, final String[] keywords){
    return Words.getCaseInsensitive(ops, keywords);
  }

  /**
   * Creates a Words object for lexing the operators with names specified in ops,
   * and for lexing the keywords case sensitively. 
   * Keywords and operators are lexed as TokenReserved.
   * Words that are not among the keywords are lexed as TokenWord. 
   * A word is defined as an alpha numeric string that starts with [_a-zA-Z],
   * with 0 or more [0-9_a-zA-Z] following.
   * @param ops the operator names.
   * @param keywords the keyword names.
   * @return the Words instance.
   */
  public static Words getCaseSensitive(
      final String[] ops, final String[] keywords){
    return Words.getCaseSensitive(ops, keywords);
  }
  /**
   * Creates a Words object for lexing the operators with names specified in ops,
   * and for lexing the keywords case insensitively.
   * Keywords and operators are lexed as TokenReserved.
   * Words that are not among the keywords are lexed as TokenWord. 
   * @param wscanner the scanner for a word in the language.
   * @param ops the operator names.
   * @param keywords the keyword names.
   * @return the Words instance.
   */
  public static Words getCaseInsensitive(final Parser wscanner, 
      final String[] ops, final String[] keywords){
    return Words.getCaseInsensitive(wscanner, ops, keywords);
  }
  /**
   * Creates a Words object for lexing the operators with names specified in ops,
   * and for lexing the keywords case sensitively. 
   * Keywords and operators are lexed as TokenReserved.
   * Words that are not among the keywords are lexed as TokenWord. 
   * @param wscanner the scanner for a word in the language.
   * @param ops the operator names.
   * @param keywords the keyword names.
   * @return the Words instance.
   */
  public static Words getCaseSensitive(final Parser wscanner,
      final String[] ops, final String[] keywords){
    return Words.getCaseSensitive(wscanner, ops, keywords);
  }

}
