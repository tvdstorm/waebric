/*****************************************************************************
 * Copyright (C) Zephyr Business Solutions Corp. All rights reserved.            *
 * ------------------------------------------------------------------------- *
 * The software in this package is published under the terms of the BSD      *
 * style license a copy of which has been included with this distribution in *
 * the LICENSE.txt file.                                                     *
 *****************************************************************************/
/*
 * Created on 2004-11-11
 *
 * Author Ben Yu
 */
package jfun.parsec;


import java.util.ArrayList;
import java.util.List;

/**
 * This class provides general parser combinators that work on both character level and token level. <p>
 * A parser can work on character level or token level.
 * A character level parser that returns a token object is called a lexer. <br>
 * A character level parser that does not return a token object is called a scanner. <br>
 * A token level parser is called a "parser". <br>
 * 
 * For each Parser combinator, we write the signature in a haskellish sytax. <br>
 * A parser that returns an object of type a is denoted as: Parser a. <br>
 * A value of any type is denoted as *. (null is an example, exceptions, errors are all type *)<br>
 * A value of an unknown type is denoted as _. <br>
 * A parser transformer that maps a Parser a to Parser b is denoted as: Parser a -> Parser b. <br>
 * A parser combinator that accepts object of type a and returns a Parser b is denoted as: a -> Parser b. <br>
 * Interface Map is denoted as a -> b. this is because Map will be changed to Map<A,B> once we have generics. <br>
 * Map2 is denoted as a->b->r, Map3 is a->b->c->r, jfun.yan.etc. <br>
 * ToParser is denoted as a -> Parser b. <br>
 * A parser has a user state that can be set and retrieved.
 * Only setState, getState, transformState combinators are user state related.
 * We denote a user state concerned parser as Parser u a,
 * where u is the user state type and a is the return type. <br>
 * An array of element type t, is denoted as [t]. <br>
 * The unit type is denoted as ().
 * @author Ben Yu
 *
 * 2004-11-11
 */
public final class Parsers {
  /**
   * Runs a character level parser with a CharSequence input.
   * @param src the input source.
   * @param p the parser object to run.
   * @param pmap the PositionMap object used to map a character index
   * to line/column number.
   * @param module the module name. Use any name that's meaningful.
   * @return the result object.
   */
  public static Object runParser(final CharSequence src,
      final Parser p,
      final PositionMap pmap, final String module){
    final ScannerState ctxt = new ScannerState(src, 0, module, null);
    return runParser(ctxt, p, pmap);
  }
  /**
   * Runs a character level parser with a CharSequence input.
   * @param src the input source.
   * @param p the parser object to run.
   * @param tabwidth the width of a horizontal tab character.
   * @param module the module name. Use any name that's meaningful.
   * @return the result object.
   */
  public static Object runParser(final CharSequence src,
      final Parser p,
      final int tabwidth, final String module){
    return runParser(src, p, new DefaultPositionMap(src, 1, 1, tabwidth), module);
  }
  /**
   * Runs a token level Parser object with an array of tokens.
   * <p> [PositionedToken] -> int -> Parser a -> ShowToken -> String -> PositionMap -> a
   * @param toks the input tokens
   * @param end_index the index after the last character in the source.
   * @param p the parser object.
   * @param show the object to show the tokens.
   * @param eof_title the name of "end of file". 
   * @param module the module name. Use any name that's meaningful.
   * This value will be shown in any EOF related messages.
   * @param pmap the PositionMap object to map a character index to the line/column number.
   * @return the return value of the Parser object. (returned by retn() function)
   * @throws ParserException when parsing fails.
   */
  public static Object runParser(
      final PositionedToken[] toks, 
      final int end_index, final Parser p, final ShowToken show,
      final String eof_title,
      final PositionMap pmap, final String module)
  throws ParserException{
      final ParserState s0 = 
        new ParserState(null, toks, 0, module, end_index, eof_title, show);
      return runParser(s0, p, pmap);
  }
  private static boolean parseIt(final ParseContext ctxt, 
      final Parser p, final PositionMap pmap){
    try{
      return p.parse(ctxt);
    }
    catch(UserException e){
      final int ind = e.getInd();
      throw new ParserException(e.getMessage(), null,
          ctxt.getModuleName(),
          pmap.getPos(ind>=0?ind:ctxt.getIndex()));
    }
  }
  private static Object runParser(
      final ParseContext ctxt, final Parser p,
      final PositionMap pmap){
    if(!parseIt(ctxt, p, pmap)){
      final AbstractParsecError err = ctxt.getError();
      throw new ParserException(toErrorStr(ctxt), (err==null?null:err.render()), 
          ctxt.getModuleName(), pmap.getPos(ctxt.getIndex()));
    }
    return ctxt.getReturn();
  }
  /**
   * The created parser object will take as input
   * the array of PositionedToken returned from the lexer object,
   * feed it into the Parser object p and run it,
   * return the result from parser p. <br>
   * It fails if the lexer fails or parser p fails. 
   * Parser [PositionedToken] -> Parser a -> Parser a
   * @param lexer the lexer object that returns an array of PositionedToken objects.
   * @param p the token level parser object.
   * @param module the module name. Use any name that's meaningful.
   * that will parse the array of PositionedToken objects.
   * @return the new Parser object.
   */
  public static Parser parseTokens(final Parser lexer, final Parser p,
      final String module){
    return parseTokens("parseTokens", lexer, p, module);
  }
  /**
   * The created parser object will take as input
   * the array of PositionedToken returned from the lexer object,
   * feed it into the Parser object p and run it,
   * return the result from parser p. <br>
   * It fails if the lexer fails or parser p fails. 
   * Parser [PositionedToken] -> Parser a -> Parser a
   * @param name the name of the new Parser object.
   * @param lexer the lexer object that returns an array of PositionedToken objects.
   * @param p the token level parser object.
   * @param module the module name. Use any name that's meaningful.
   * that will parse the array of PositionedToken objects.
   * @return the new Parser object.
   */
  public static Parser parseTokens(final String name,
      final Parser lexer, final Parser p, final String module){
    return parseTokens(name, "EOF", Token2String.instance(),
        lexer, p, module);
  }
  /**
   * The created parser object will take as input
   * the array of PositionedToken returned from the lexer object,
   * feed it into the Parser object p and run it,
   * return the result from parser p. <br>
   * It fails if the lexer fails or parser p fails. 
   * String -> ShowToken -> Parser [PositionedToken] -> Parser a -> Parser a
   * @param eof_title the name of "end of input"
   * @param show the object to transform a token to a string.
   * @param lexer the lexer object that returns an array of PositionedToken objects.
   * @param p the token level parser object.
   * @param module the module name. Use any name that's meaningful.
   * that will parse the array of PositionedToken objects.
   * @return the new Parser object.
   */
  public static Parser parseTokens(final String eof_title,
      final ShowToken show, final Parser lexer, final Parser p, String module){
    return parseTokens("parseTokens", eof_title, show, lexer, p, module);
  }
  /**
   * The created parser object will take as input
   * the array of PositionedToken returned from the lexer object,
   * feed it into the Parser object p and run it,
   * return the result from parser p. <br>
   * It fails if the lexer fails or parser p fails. 
   * String -> ShowToken -> Parser [PositionedToken] -> Parser a -> Parser a
   * @param name the name of the new Parser object.
   * @param eof_title the name of "end of input"
   * @param show the object to transform a token to a string.
   * @param lexer the lexer object that returns an array of PositionedToken objects.
   * @param p the token level parser object
   * @param module the module name. Use any name that's meaningful.
   * that will parse the array of PositionedToken objects.
   * @return the new Parser object.
   */
  public static Parser parseTokens(final String name, 
      final String eof_title, final ShowToken show,
      final Parser lexer, final Parser p, final String module){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){   
        if(!lexer.parse(ctxt)) return false;
        final Object obj = ctxt.getReturn();
        final PositionedToken[] toks = toTokens(obj);
        final ParserState s0 = 
          new ParserState(obj, ctxt.getUserState(), toks, 
              0, module, ctxt.getIndex(), eof_title, show);
        return cont(ctxt, s0, p);
      }
    };
  }
  private static PositionedToken[] toTokens(Object obj){
    if(obj instanceof PositionedToken[]){
      return (PositionedToken[])obj;
    }
    else if(obj instanceof List){
      final List l = (List)obj;
      final PositionedToken[] arr = new PositionedToken[l.size()];
      l.toArray(arr);
      return arr;
    }
    else throw new IllegalParserStateException(
        "an array of PositionedToken objects expected for token level parsing.");
  }
  static boolean cont(final ParseContext ctxt, final ParseContext s0, final Parser p){
    if(!p.parse(s0)){
      ctxt.set(ctxt.getStep(), s0.getIndex(), null, s0.getUserState(), s0.getError());
      return false;
    }
    else{
      ctxt.set(ctxt.getStep()+s0.getStep(), ctxt.getAt(), s0.getReturn(), s0.getUserState(), s0.getError());
      return true;
    }
  }


  /******************** monadic combinators ********************/
  private static final Parser _one = one("one");
  /**
   * The parser that always succeed. It does not consume any input.
   * <p> Parser _
   * @return the Parser object.
   */
  public static Parser one(){return _one;}
  /**
   * The parser that always succeed. It does not consume any input.
   * <p> Parser _
   * @param name the name of the Parser.
   * @return the Parser object.
   */
  public static Parser one(final String name){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){return true;}
      boolean parse(final ParseContext ctxt, final int la){return true;}
    };
  }
  private static final Parser _zero = zero("zero");
  /**
   * The parser that always fails. It does not consume any input.
   * <p> Parser *
   * @return the Parser object.
   */
  public static Parser zero(){return _zero;}
  /**
   * The parser that always fails. It does not consume any input.
   * <p> Parser *
   * @param name the name of the Parser.
   * @return the Parser object.
   */
  public static Parser zero(final String name){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){return false;}
      boolean parse(final ParseContext ctxt, final int la){return false;}
    };
  }
  /**
   * The parser that returns value v. It does not consume any input.
   * <p> a -> Parser a
   * @return the Parser object.
   */
  public static Parser retn(final Object v){
    return retn("return", v);
  }
  /**
   * The parser that returns value v. It does not consume any input.
   * <p> a -> Parser a
   * @param name the name of the Parser.
   * @return the Parser object.
   */
  public static Parser retn(final String name, final Object v){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        ctxt.setReturn(v);
        return true;
      }
    };
  }
  /**
   * First run p, if it succeeds, run ToParser f with the value returned from p.
   * <p> Parser a -> (a->Parser b) -> Parser b
   * @param name the name of the Parser.
   * @param p the first Parser object.
   * @param f the ToParser object to run if the first succeeds.
   * @return the Parser object.
   */
  public static Parser bind(final String name, final Parser p, final ToParser f){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        if(!p.parse(ctxt)) return false;
        return runNext(ctxt, f);
      }
    };
  }
  private static final ToParser _toReturn = toReturn("return");
  /**
   * Returns a ToParser instance that simply returns the previous return value.
   * <p> a -> Parser a
   * @return The ToParser object.
   */
  public static ToParser toReturn(){return _toReturn;}
  /**
   * Returns a ToParser instance that simply returns the previous return value.
   * <p> a -> Parser a
   * @return The ToParser object.
   */
  public static ToParser toReturn(final String name){
    return new ToParser(){
      public Parser toParser(Object v){
        return retn(name, v);
      }
    };
  }
  private static final ToParser _toOne = toOne("one");
  /**
   * Returns a ToParser that ignores the value passed in and simply returns one().
   * <p> _ -> Parser _
   * @return the ToParser object.
   */
  public static ToParser toOne(){return _toOne;}
  /**
   * Returns a ToParser that ignores the value passed in and simply returns one().
   * <p> _ -> Parser _
   * @param name the name of the Parser that ToParser returns.
   * @return the ToParser object.
   */
  public static ToParser toOne(final String name){
    return new ToParser(){
      public Parser toParser(final Object v){
        return one(name);
      }
    };
  }
  private static final ToParser _toZero = toZero("zero");
  /**
   * Returns a ToParser that ignores the value passed in and simply returns zero().
   * <p> _ -> Parser *
   * @return the ToParser object.
   */
  public static ToParser toZero(){return _toZero;}
  /**
   * Returns a ToParser that ignores the value passed in and simply returns zero().
   * <p> _ -> Parser *
   * @param name the name of the Parser that ToParser returns.
   * @return the ToParser object.
   */
  public static ToParser toZero(final String name){
    return new ToParser(){
      public Parser toParser(final Object v){
        return zero(name);
      }
    };
  }
  /**
   * Threads an array of ToParser into a single ToParser.
   * The first return value is passed to the first ToParser,
   * and the result Parser is executed to get the next return value.
   * The return value keeps pass down until all ToParser are called.
   * If any Parser fails, the threading fails.
   * <p> [(a->Parser a)] -> a -> Parser a
   * @param binders all the ToParser objects.
   * @return the new ToParser.
   */
  public static ToParser bindAll(final ToParser[] binders){
    return bindAll("bindAll", binders);
  }
  /**
   * Threads an array of ToParser into a single ToParser.
   * The first return value is passed to the first ToParser,
   * and the result Parser is executed to get the next return value.
   * The return value keeps pass down until all ToParser are called.
   * If any Parser fails, the threading fails.
   * <p> [(a->Parser a)] -> a -> Parser a
   * @param binders all the ToParser objects.
   * @param name the name of the Parser created by the result ToParser.
   * @return the new ToParser.
   */
  public static ToParser bindAll(final String name, final ToParser[] binders){
    return _bindAll(name, copy(binders));
  }
  private static ToParser _bindAll(final String name, final ToParser[] binders){
    if(binders.length == 0) return toReturn();
    if(binders.length == 1) return binders[0];
    return new ToParser(){
      public Parser toParser(final Object v){
        return new Parser(name){
          boolean parse(final ParseContext ctxt){
            Object val = v;
            for(int i=0; i<binders.length; i++){
              final ToParser pb = binders[i];
              if(!pb.toParser(val).parse(ctxt)) return false;
              val = ctxt.getReturn();
            }
            return true;
          }
        };
      }
    };
  }
  /**
   * Sequencing 2 parser objects.
   * The first Parser is executed, if it succeeds, the second Parser is executed.
   * <p> Parser a -> Parser b -> Parser b
   * @param p1 1st Parser.
   * @param p2 2nd Parser.
   * @return the new Parser.
   */
  public static Parser seq(final Parser p1, final Parser p2){
    return seq(">>", p1, p2);
  }
  /**
   * Sequencing 2 parser objects.
   * The first Parser is executed, if it succeeds, the second Parser is executed.
   * <p> Parser a -> Parser b -> Parser b
   * @param name the name of the new Parser object.
   * @param p1 1st Parser.
   * @param p2 2nd Parser.
   * @return the new Parser.
   */
  public static Parser seq(final String name, final Parser p1, final Parser p2){
    //return _seqAll(name, new Parser[]{p1, p2});
    //optimize. inline _seqAll to avoid creating array object.
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        if(!p1.parse(ctxt)) return false;
        return p2.parse(ctxt);
      }
    };
  }
  /**
   * Sequencing 3 parser objects.
   * <p> Parser a -> Parser b -> Parser c -> Parser c
   * @param p1 1st Parser.
   * @param p2 2nd Parser.
   * @param p3 3rd Parser.
   * @return the new Parser.
   */
  public static Parser seq(final Parser p1, final Parser p2, final Parser p3){
    return seq(">>", p1, p2, p3);
  }
  /**
   * Sequencing 3 parser objects.
   * <p> Parser a -> Parser b -> Parser c -> Parser c
   * @param name the name of the new Parser object.
   * @param p1 1st Parser.
   * @param p2 2nd Parser.
   * @param p3 3rd Parser.
   * @return the new Parser.
   */
  public static Parser seq(final String name, final Parser p1, final Parser p2, final Parser p3){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        if(!p1.parse(ctxt)) return false;
        if(!p2.parse(ctxt)) return false;
        return p3.parse(ctxt);
      }
    };
  }
  /**
   * Sequencing 4 parser objects.
   * <p> Parser a -> Parser b -> Parser c -> Parser c -> Parser d -> Parser d
   * @param p1 1st Parser.
   * @param p2 2nd Parser.
   * @param p3 3rd Parser.
   * @param p4 4th Parser.
   * @return the new Parser.
   */
  public static Parser seq(final Parser p1, final Parser p2, final Parser p3, final Parser p4){
    return seq(">>", p1, p2, p3, p4);
  }
  /**
   * Sequencing 4 parser objects.
   * <p> Parser a -> Parser b -> Parser c -> Parser c -> Parser d -> Parser d
   * @param name the name of the new Parser object.
   * @param p1 1st Parser.
   * @param p2 2nd Parser.
   * @param p3 3rd Parser.
   * @param p4 4th Parser.
   * @return the new Parser.
   */
  public static Parser seq(final String name, final Parser p1, final Parser p2, final Parser p3, final Parser p4){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        if(!p1.parse(ctxt)) return false;
        if(!p2.parse(ctxt)) return false;
        if(!p3.parse(ctxt)) return false;
        return p4.parse(ctxt);
      }
    };
  }
  /**
   * Sequencing 5 parser objects.
   * <p> Parser a -> Parser b -> Parser c -> Parser c -> Parser d -> Parser e -> Parser e
   * @param p1 1st Parser.
   * @param p2 2nd Parser.
   * @param p3 3rd Parser.
   * @param p4 4th Parser.
   * @param p5 5th Parser.
   * @return the new Parser.
   */
  public static Parser seq(final Parser p1, final Parser p2, final Parser p3, final Parser p4, final Parser p5){
    return seq(">>", p1, p2, p3, p4, p5);
  }
  /**
   * Sequencing 5 parser objects.
   * <p> Parser a -> Parser b -> Parser c -> Parser c -> Parser d -> Parser e -> Parser e
   * @param name the name of the new Parser object.
   * @param p1 1st Parser.
   * @param p2 2nd Parser.
   * @param p3 3rd Parser.
   * @param p4 4th Parser.
   * @param p5 5th Parser.
   * @return the new Parser.
   */
  public static Parser seq(final String name, final Parser p1, final Parser p2, final Parser p3, final Parser p4, final Parser p5){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        if(!p1.parse(ctxt)) return false;
        if(!p2.parse(ctxt)) return false;
        if(!p3.parse(ctxt)) return false;
        if(!p4.parse(ctxt)) return false;
        return p5.parse(ctxt);
      }
    };
  }
  /**
   * Sequencing of an array of Parser objects.
   * If the array is empty, one() is returned. <br>
   * The array of Parser objects are executed sequentially until an error occured or all the Parsers are executed.
   * Return values are discarded.
   * <p> [Parser _] -> Parser _
   * @param ps the array of Parser objects.
   * @return the new Parser object.
   */
  public static Parser seqAll(final Parser[] ps){
    return seqAll("seqAll", ps);
  }
  /**
   * Sequencing of an array of Parser objects.
   * If the array is empty, one() is returned. <br>
   * The array of Parser objects are executed sequentially until an error occured or all the Parsers are executed.
   * Return values are discarded.
   * <p> [Parser _] -> Parser _
   * @param name the name of the new Parser.
   * @param ps the array of Parser objects.
   * @return the new Parser object.
   */
  public static Parser seqAll(final String name, final Parser[] ps){
    if(ps.length == 0) return one();
    if(ps.length == 1) return ps[0];
    return _seqAll(name, copy(ps));
  }
  private static Parser _seqAll(final String name, final Parser[] ps){
    return new Parser(name){
      boolean parse(ParseContext ctxt){
        for(int i=0; i<ps.length; i++){
          final Parser p = ps[i];
          if(!p.parse(ctxt)) return false;
        }
        return true;
      }
    };
  }
  /**
   * Fails if the return value of the previous parser
   * does not satisify the given predicate.
   * No-op otherwise.
   * @param name the name of the new Parser object.
   * @param op the predicate object.
   * @return the new Parser object.
   */
  public static Parser isReturn(final String name, final ObjectPredicate op){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        final Object r = ctxt.getReturn();
        return op.isObject(r);
      }
    };
  }
  /**
   * The created Parser object will first run parser p,
   * if the return value of parser p does not satisify the given predicate,
   * it fails and the input consumption of parser p is undone.
   * It is an atomic parser.
   * @param name the name of the new Parser object.
   * @param p the parser object to test the return value of.
   * @param op the predicate object.
   * @return the new Parser object.
   */
  public static Parser isReturn(final String name, final Parser p, 
      final ObjectPredicate op){
    return seq(name, p, isReturn(name, op)).atomize(name);
  }
  /**
   * The created Parser object will first run parser p,
   * if the return value of parser p does not satisify the given predicate,
   * it fails and the input consumption of parser p is undone.
   * It is an atomic parser.
   * @param name the name of the new Parser object.
   * @param p the parser object to test the return value of.
   * @param op the predicate object.
   * @param expecting the "expected" error message. 
   * @return the new Parser object.
   */
  public static Parser isReturn(final String name, final Parser p, 
      final ObjectPredicate op, final String expecting){
    return p.seq(name, isReturn(name, op).label(name, expecting)).atomize(name);
  }
  /**
   * Fails if the current user state value does not satisify the given predicate.
   * No-op otherwise.
   * @param op the predicate object.
   * @return the new Parser object.
   */
  public static Parser isState(final ObjectPredicate op){
    return isState("isState", op);
  }
  /**
   * Fails if the current user state value does not satisify the given predicate.
   * No-op otherwise.
   * @param name the name of the new Parser object.
   * @param op the predicate object.
   * @return the new Parser object.
   */
  public static Parser isState(final String name, final ObjectPredicate op){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        final Object r = ctxt.getUserState();
        return op.isObject(r);
      }
    };
  }
  /**
   * lookahead looks at logical steps.
   * step(String, int, Parser) runs this parser
   * and sets the number of logical steps.
   * 
   * @param name the name of the new Parser object.
   * @param n the number logical steps. n>=0 has to be true.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser step(final String name, final int n, final Parser p){
    if(n<0) throw new IllegalArgumentException(""+n+"<0");
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        final int step = ctxt.getStep();
        if(!p.parse(ctxt)) return false;
        ctxt.setStep(step+n);
        return true;
      }
    };
  }
  /**
   * By default, ifelse, plus, sum will not try to run the next branch if the previous branch failed
   * and consumed some input.
   * this is because the default look-ahead token is 1.
   * <br> by using lookahead, this default behavior can be altered.
   * Parsers.plus(p1, p2).lookahead(3)
   * will still try p2 even if p1 fails and consumes one or two inputs.
   * <p> lookahead only affects one nesting level.
   * Parsers.plus(p1,p2).ifelse(yes,no).lookahead(3)
   * will not affect the Parsers.plus(p1,p2) nested within ifelse.
   * <p> lookahead directly on top of lookahead will override the previous lookahead.
   * Parsers.plus(p1,p2).lookahead(3).lookahead(1)
   * is equivalent as Parsers.plus(p1, p2).lookahead(1).
   * <br>
   * lookahead looks at logical step.
   * by default, each terminal is one logical step.
   * atomize() combinator ensures at most 1 logical step for a parser.
   * Use step() combinator to fine control logical steps.
   * @param name the name of the new Parser object.
   * @param toknum the number of tokens to look ahead.
   * @return the new Parser object.
   */
  public static Parser lookahead(final String name, final int toknum, final Parser p){
    if(toknum <= 0) return p;
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        return p.parse(ctxt, toknum);
      }
      boolean parse(final ParseContext ctxt, final int la){
        return p.parse(ctxt, la);
      }
    };
  }

  /**
   * Sequencing of an array of Parser objects.
   * The array of Parser objects are executed sequentially until an error occured or all the Parsers are executed.
   * Return values are collected as a Object[] array and transformed by a Mapn object.
   * <p> [Parser a] -> ([a]->r) -> Parser r
   * @param ps the array of Parser objects.
   * @param mn the Mapn object.
   * @return the new Parser object.
   */
  public static Parser mapn(final Parser[] ps, final Mapn mn){
    return mapn("mapn", ps, mn);
  }
  /**
   * Sequencing of an array of Parser objects.
   * The array of Parser objects are executed sequentially until an error occured or all the Parsers are executed.
   * Return values are collected and returned as an Object[] array and transformed by a Mapn object.
   * <p> [Parser a] -> ([a]->r) -> Parser r
   * @param name the name of the new Parser.
   * @param ps the array of Parser objects.
   * @param mn the Mapn object.
   * @return the new Parser object.
   */
  public static Parser mapn(final String name, final Parser[] ps, final Mapn mn){
    if(ps.length==0) return retn(mn.map(_empty_array));
    return mapn(name, ArrayFactories.defaultFactory(), ps, mn);
  }
  /**
   * Sequencing of an array of Parser objects.
   * The array of Parser objects are executed sequentially until an error occured or all the Parsers are executed.
   * Return values are collected and returned as a T[] array where T is the element type,
   * and then transformed by a Mapn object.
   * <p> [Parser a] -> ([a]->r) -> Parser r
   * @param etype the element type of the return value array.
   * @param ps the array of Parser objects.
   * @param mn the Mapn object.
   * @return the new Parser object.
   */
  public static Parser mapn(final Class etype, final Parser[] ps, final Mapn mn){
    return mapn("mapn", etype, ps, mn);
  }
  /**
   * Sequencing of an array of Parser objects.
   * The array of Parser objects are executed sequentially until an error occured or all the Parsers are executed.
   * Return values are collected and returned as a T[] array where T is the element type,
   * and then transformed by a Mapn object.
   * <p> [Parser a] -> ([a]->r) -> Parser r
   * @param name the name of the new Parser.
   * @param etype the element type of the return value array.
   * @param ps the array of Parser objects.
   * @param mn the Mapn object.
   * @return the new Parser object.
   */
  public static Parser mapn(final String name, final Class etype, final Parser[] ps, final Mapn mn){
    return mapn(name, ArrayFactories.typedFactory(etype), ps, mn);
  }
  /**
   * Sequencing of an array of Parser objects.
   * The array of Parser objects are executed sequentially until an error occured or all the Parsers are executed.
   * Return values are collected and returned as an array created by the ArrayFactory parameter,
   * and then transformed by a Mapn object.
   * <p> [Parser a] -> ([a]->r) -> Parser r
   * @param af the ArrayFactory object.
   * @param ps the array of Parser objects.
   * @param mn the Mapn object.
   * @return the new Parser object.
   */
  public static Parser mapn(final ArrayFactory af, final Parser[] ps, final Mapn mn){
    return mapn("mapn", af, ps, mn);
  }
  /**
   * Sequencing of an array of Parser objects.
   * The array of Parser objects are executed sequentially until an error occured or all the Parsers are executed.
   * Return values are collected and returned as an array created by the ArrayFactory parameter
   * and then transformed by a Mapn object.
   * <p> [Parser a] -> ([a]->r) -> Parser r
   * @param name the name of the new Parser.
   * @param af the ArrayFactory object.
   * @param ps the array of Parser objects.
   * @param mn the Mapn object.
   * @return the new Parser object.
   */
  public static Parser mapn(final String name, final ArrayFactory af, final Parser[] ps, final Mapn mn){
    return _mapn(name, af, copy(ps), mn);
  }
  private static Parser _mapn(final String name, final ArrayFactory af, final Parser[] ps, final Mapn mn){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        final Object[] ret = af.createArray(ps.length);
        for(int i=0; i<ps.length; i++){
          final Parser p = ps[i];
          if(!p.parse(ctxt)) return false;
          ret[i] = ctxt.getReturn();
        }
        ctxt.setReturn(mn.map(ret));
        return true;
      }
    };
  }
  /**
   * A parser that always fail with the given error message.
   * <p> Parser *
   * @param msg the error message.
   * @return the Parser object.
   */
  public static Parser fail(final String msg){
    return fail("fail", msg);
  }
  /**
   * A parser that always fail with the given error message.
   * <p> Parser *
   * @param name the Parser object name.
   * @param msg the error message.
   * @return the Parser object.
   */
  public static Parser fail(final String name, final String msg){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        return raiseRaw(msg, ctxt);
      }
    };
  }
  /**
   * First run Parser p, if it succeeds, thread the return value to ToParser yes;
   * if it fails and no input is consumed, run Parser no;
   * fails if p fails and some input is consumed.
   * <p> Parser a -> (a->Parser b) -> Parser b -> Parser b
   * @param name the name of the new Parser object.
   * @param p the Parser object to test.
   * @param yes the true branch.
   * @param no the false branch.
   * @return the new Parser object.
   */
  public static Parser ifelse(final String name, final Parser p, final ToParser yes, final Parser no){
    return new Parser(name){
      boolean parse(final ParseContext ctxt, final int look_ahead){
        final Object ustate = ctxt.getUserState();
        final Object ret = ctxt.getReturn();
        final int step = ctxt.getStep();
        final int at = ctxt.getAt();
        final AbstractParsecError error = ctxt.getError();
        if(p.parse(ctxt)) return yes.toParser(ctxt.getReturn()).parse(ctxt);
        return recover(look_ahead, no, ctxt, step, at, ret, ustate, error);
      }
      boolean parse(final ParseContext ctxt){return parse(ctxt, 1);}
    };    
  }
  /**
   * First run Parser p, if it succeeds, run Parser yes;
   * if it fails and no input is consumed, run Parser no;
   * fails if p fails and some input is consumed.
   * <p> Parser _ -> Parser b -> Parser b -> Parser b
   * @param name the name of the new Parser object.
   * @param p the Parser object to test.
   * @param yes the true branch.
   * @param no the false branch.
   * @return the new Parser object.
   */
  public static Parser ifelse(final String name, final Parser p, final Parser yes, final Parser no){
    return ifelse(name, p, new ToParser(){
      public Parser toParser(final Object v){return yes;}
    }, no);
    /*
    return new Parser(name){
      boolean parse(final ParserState state){
        final Object ustate = state.getUserState();
        final Object ret = state.getReturn();
        final int at = state.getAt();
        final ParsecError error = state.getError();
        if(p.parse(state)) return yes.parse(state);
        return recover(no, state, at, ret, ustate, error);
      }
    };*/
  }
  /**
   * 2 alternative parser objects.
   * If the first Parser fails with no input consumption, the second one is executed.
   * <p> Parser a -> Parser a -> Parser a
   * @param p1 1st Parser.
   * @param p2 2nd Parser.
   * @return the new Parser.
   */
  public static Parser plus(final Parser p1, final Parser p2){
    return plus("plus", p1, p2);
  }
  /**
   * 2 alternative parser objects.
   * If the first Parser fails with no input consumption, the second one is executed.
   * <p> Parser a -> Parser a -> Parser a
   * @param name the name of the new Parser object.
   * @param p1 1st Parser.
   * @param p2 2nd Parser.
   * @return the new Parser.
   */
  public static Parser plus(final String name, final Parser p1, final Parser p2){
    return _plusAll(name, new Parser[]{p1, p2});
    //special optimize. inline _plusAll rather than creating the array object.
    /*
    return new Parser(name){
      boolean parse(final ParserState state){
        final Object ustate = state.getUserState();
        final Object ret = state.getReturn();
        final int at = state.getAt();
        final ParsecError error = state.getError();
        if(p1.parse(state)) return true;
        return recover(p2, state, at, ret, ustate, error);
      }
    };*/
  }
  /**
   * 3 alternative parser objects.
   * <p> Parser a -> Parser a -> Parser a -> Parser a
   * @param p1 1st Parser.
   * @param p2 2nd Parser.
   * @param p3 3rd Parser.
   * @return the new Parser.
   */
  public static Parser plus(final Parser p1, final Parser p2, final Parser p3){
    return plus("plus", p1, p2, p3);
  }
  /**
   * 3 alternative parser objects.
   * <p> Parser a -> Parser a -> Parser a -> Parser a
   * @param name the name of the new Parser object.
   * @param p1 1st Parser.
   * @param p2 2nd Parser.
   * @param p3 3rd Parser.
   * @return the new Parser.
   */
  public static Parser plus(final String name, final Parser p1, final Parser p2, final Parser p3){
    return _plusAll(name, new Parser[]{p1, p2, p3});
  }
  /**
   * 4 alternative parser objects.
   * <p> Parser a -> Parser a -> Parser a -> Parser a -> Parser a
   * @param p1 1st Parser.
   * @param p2 2nd Parser.
   * @param p3 3rd Parser.
   * @param p4 4th Parser.
   * @return the new Parser.
   */
  public static Parser plus(final Parser p1, final Parser p2, final Parser p3, final Parser p4){
    return plus("plus", p1, p2, p3, p4);
  }
  /**
   * 4 alternative parser objects.
   * <p> Parser a -> Parser a -> Parser a -> Parser a -> Parser a
   * @param name the name of the new Parser object.
   * @param p1 1st Parser.
   * @param p2 2nd Parser.
   * @param p3 3rd Parser.
   * @param p4 4th Parser.
   * @return the new Parser.
   */
  public static Parser plus(final String name, final Parser p1, final Parser p2, final Parser p3, final Parser p4){
    return _plusAll(name, new Parser[]{p1, p2, p3, p4});
  }
  /**
   * 5 alternative parser objects.
   * <p> Parser a -> Parser a -> Parser a -> Parser a -> Parser a -> Parser a
   * @param p1 1st Parser.
   * @param p2 2nd Parser.
   * @param p3 3rd Parser.
   * @param p4 4th Parser.
   * @param p5 5th Parser.
   * @return the new Parser.
   */
  public static Parser plus(final Parser p1, final Parser p2, final Parser p3, final Parser p4, final Parser p5){
    return plus("plus", p1, p2, p3, p4, p5);
  }
  /**
   * 5 alternative parser objects.
   * <p> Parser a -> Parser a -> Parser a -> Parser a -> Parser a -> Parser a
   * @param name the name of the new Parser object.
   * @param p1 1st Parser.
   * @param p2 2nd Parser.
   * @param p3 3rd Parser.
   * @param p4 4th Parser.
   * @param p5 5th Parser.
   * @return the new Parser.
   */
  public static Parser plus(final String name, final Parser p1, final Parser p2, final Parser p3, final Parser p4, final Parser p5){
    return _plusAll(name, new Parser[]{p1, p2, p3, p4, p5});
  }
  /**
   * An array of alternative Parser objects.
   * zero() is returned if the array is empty.
   * the returned Parser object will try the Parser objects in the array one by one,
   * until one of the following conditioins are met:
   * the Parser succeeds, (sum() succeeds) <br>
   * the Parser fails with input consumed (sum() fails with input consumed) <br>
   * the end of array is encountered. (sum() fails with no input consumed).
   * <p> [Parser a] -> Parser a
   * @param ps the array of alternative Parser objects.
   * @return the new Parser object.
   */
  public static Parser sum(final Parser[] ps){
    return sum("sum", ps);
  }
  /**
   * An array of alternative Parser objects.
   * zero() is returned if the array is empty.
   * the returned Parser object will try the Parser objects in the array one by one,
   * until one of the following conditioins are met:
   * the Parser succeeds, (sum() succeeds) <br>
   * the Parser fails with input consumed (sum() fails with input consumed) <br>
   * the end of array is encountered. (sum() fails with no input consumed).
   * <p> [Parser a] -> Parser a
   * @param name the name of the new Parser object.
   * @param ps the array of alternative Parser objects.
   * @return the new Parser object.
   */
  public static Parser sum(final String name, final Parser[] ps){
    if(ps.length == 0) return zero();
    if(ps.length == 1) return ps[0];
    return _plusAll(name, copy(ps));
  }
  /**
   * Runs two alternative parsers.
   * If both succeed, the one with the longer match wins.
   * If both matches the same length, the first one is favored.
   * @param name the name of the new Parser object.
   * @param p1 the 1st alternative parser.
   * @param p2 the 2nd alternative parser.
   * @return the new Parser object.
   */
  public static Parser longer(final String name, final Parser p1, final Parser p2){
    return _longest(name, new Parser[]{p1, p2});
  }
  /**
   * Runs an array of alternative parsers.
   * If more than one succeed, the one with the longest match wins.
   * If two matches have the same length, the first one is favored.
   * @param name the name of the new Parser object.
   * @param ps the array of alternative parsers.
   * @return the new Parser object.
   */

  public static Parser longest(final String name, final Parser[] ps){
    if(ps.length==0) return zero();
    if(ps.length==1) return ps[0];
    return _longest(name, copy(ps));
  }
  /**
   * Runs two alternative parsers.
   * If both succeed, the one with the shorter match wins.
   * If both matches the same length, the first one is favored.
   * @param name the name of the new Parser object.
   * @param p1 the 1st alternative parser.
   * @param p2 the 2nd alternative parser.
   * @return the new Parser object.
   */

  public static Parser shorter(final String name, final Parser p1, final Parser p2){
    return _shortest(name, new Parser[]{p1, p2});
  }
  /**
   * Runs an array of alternative parsers.
   * If more than one succeed, the one with the shortest match wins.
   * If two matches have the same length, the first one is favored.
   * @param name the name of the new Parser object.
   * @param ps the array of alternative parsers.
   * @return the new Parser object.
   */

  public static Parser shortest(final String name, final Parser[] ps){
    if(ps.length==0) return zero();
    if(ps.length==1) return ps[0];
    return _shortest(name, copy(ps));
  }
  private static Parser _shortest(final String name, final Parser[] ps){
    return _alternate(name, ps, IntOrders.lt());
  }
  private static Parser _longest(final String name, final Parser[] ps){
    return _alternate(name, ps, IntOrders.gt());
  }
  /**
   * Runs two alternative parsers.
   * If both succeed, the one with the longer match wins.
   * If both matches the same length, the first one is favored.
   * @param p1 the 1st alternative parser.
   * @param p2 the 2nd alternative parser.
   * @return the new Parser object.
   */
  public static Parser longer(final Parser p1, final Parser p2){
    return longer("longer", p1, p2);
  }
  /**
   * Runs an array of alternative parsers.
   * If more than one succeed, the one with the longest match wins.
   * If two matches have the same length, the first one is favored.
   * @param ps the array of alternative parsers.
   * @return the new Parser object.
   */

  public static Parser longest(final Parser[] ps){
    return longest("longest", ps);
  }
  /**
   * Runs two alternative parsers.
   * If both succeed, the one with the shorter match wins.
   * If both matches the same length, the first one is favored.
   * @param p1 the 1st alternative parser.
   * @param p2 the 2nd alternative parser.
   * @return the new Parser object.
   */

  public static Parser shorter(final Parser p1, final Parser p2){
    return shorter("shorter", p1, p2);
  }
  /**
   * Runs an array of alternative parsers.
   * If more than one succeed, the one with the shortest match wins.
   * If two matches have the same length, the first one is favored.
   * @param ps the array of alternative parsers.
   * @return the new Parser object.
   */

  public static Parser shortest(final Parser[] ps){
    return shortest("shortest", ps);
  }
  private static Parser _plusAll(final String name, final Parser[] ps){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        return parse(ctxt, 1);
      }
      boolean parse(final ParseContext ctxt, final int look_ahead){
        final Object ustate = ctxt.getUserState();
        final Object ret = ctxt.getReturn();
        final int at = ctxt.getAt();
        final int step = ctxt.getStep();
        final AbstractParsecError error = ctxt.getError();
        AbstractParsecError err = error;
        for(int i=0; i<ps.length; i++){
          final Parser p1 = ps[i];
          if(p1.parse(ctxt)) return true;
          if(ctxt.hasException()) return false;
          if(ctxt.getAt() != at && ctxt.getStep() - step >= look_ahead) return false;
          //if(state.getAt() - at >= look_ahead) return false;
          err = AbstractParsecError.mergeError(err, ctxt.getError());
          ctxt.set(step, at, ret, ustate, error);
        }
        ctxt.setError(err);
        return false;
      }
    };
  }
  private static boolean _most(final IntOrder ord,
      final Parser[] ps, final int ind, final ParseContext state, 
      final Object ustate,
      final Object ret, final int step, final int at, 
      final AbstractParsecError err){
    if(ind >= ps.length) return true;
    int most = state.getAt();
    int mstep = state.getStep();
    Object mret = state.getReturn();
    Object mustate = state.getUserState();
    AbstractParsecError merr = state.getError();
    for(int i=ind; i<ps.length; i++){
      state.set(step, at, ret, ustate, err);
      final boolean ok = ps[i].parse(state);
      if(state.hasException())
        return false;
      if(ok){
        final int at2 = state.getAt();
        if(ord.compare(at2, most)){
          most = at2;
          mstep = state.getStep();
          mret = state.getReturn();
          mustate = state.getUserState();
          merr = state.getError();
        }
      }
    }
    state.set(mstep, most, mret, mustate, merr);
    return true;
  }

  private static Parser _alternate(final String name, final Parser[] ps, final IntOrder ord){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        final Object ustate = ctxt.getUserState();
        final Object ret = ctxt.getReturn();
        final int step = ctxt.getStep();
        final int at = ctxt.getAt();
        final AbstractParsecError error = ctxt.getError();
        AbstractParsecError err = error;
        for(int i=0; i<ps.length; i++){
          final Parser p1 = ps[i];
          if(p1.parse(ctxt)){
            return _most(ord, ps, i+1, ctxt, ustate, ret, step, at, error);
          }
          if(ctxt.hasException()) return false;
          //in alternate, we do not care partial match.
          err = AbstractParsecError.mergeError(err, ctxt.getError());
          ctxt.set(step, at, ret, ustate, error);
        }
        ctxt.setError(err);
        return false;
      }
    };
  }
  
  /******************** monadic operations ********************/
  
  
  /******************** additional combinators ********************/
  /**
   * First run the Parser p, if it succeeds with input consumed, isConsumed() succeeds;
   * if it fails or did not consume input, isConsumed() fails.
   * <p> Parser a -> Parser a
   * @param p the Parser object to test.
   * @return the new Parser object.
   */
  public static Parser isConsumed(final Parser p){
    return isConsumed("isConsumed", p);
  }
  /**
   * First run the Parser p, if it succeeds with input consumed, isConsumed() succeeds;
   * if it fails or did not consume input, isConsumed() fails.
   * <p> Parser a -> Parser a
   * @param p the Parser object to test.
   * @param err the error message when p succeeds with no input consumed.
   * @return the new Parser object.
   */
  public static Parser isConsumed(final Parser p, final String err){
    return isConsumed("isConsumed", p, err);
  }
  /**
   * First run the Parser p, if it succeeds with input consumed, isConsumed() succeeds;
   * if it fails or did not consume input, isConsumed() fails.
   * <p> Parser a -> Parser a
   * @param name the name of the new Parser object.
   * @param p the Parser object to test.
   * @return the new Parser object.
   */
  public static Parser isConsumed(final String name, final Parser p){
    return isConsumed(name, p, "input not consumed");
  }
  /**
   * First run the Parser p, if it succeeds with input consumed, isConsumed() succeeds;
   * if it fails or did not consume input, isConsumed() fails.
   * <p> Parser a -> Parser a
   * @param name the name of the new Parser.
   * @param p the Parser object to test.
   * @param err the error message when p succeeds with no input consumed.
   * @return the new Parser object.
   */
  public static Parser isConsumed(final String name, final Parser p, final String err){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        final int at = ctxt.getAt();
        if(!p.parse(ctxt)) return false;
        if(ctxt.getAt() != at) return true;
        return raiseRaw(err, ctxt);
      }
    };
  }
  /**
   * First run the Parser p, if it succeeds with no input consumed, notConsumed() succeeds;
   * if it fails, notConsumed() fails;
   * if it succeeds and consumes input, the input consumption is undone and notConsumed() fails.
   * <p> Parser a -> Parser a
   * @param p the Parser object to test.
   * @return the new Parser object.
   */
  public static Parser notConsumed(final Parser p){
    return notConsumed("notConsumed", p);
  }
  /**
   * First run the Parser p, if it succeeds with no input consumed, notConsumed() succeeds;
   * if it fails, notConsumed() fails;
   * if it succeeds and consumes input, the input consumption is undone and notConsumed() fails.
   * <p> Parser a -> Parser a
   * @param p the Parser object to test.
   * @param err the error message when p succeeds and consumes some input.
   * @return the new Parser object.
   */
  public static Parser notConsumed(final Parser p, final String err){
    return notConsumed("notConsumed", p, err);
  }
  /**
   * First run the Parser p, if it succeeds with no input consumed, notConsumed() succeeds;
   * if it fails, notConsumed() fails;
   * if it succeeds and consumes input, the input consumption is undone and notConsumed() fails.
   * <p> Parser a -> Parser a
   * @param name the name of the new Parser.
   * @param p the Parser object to test.
   * @return the new Parser object.
   */
  public static Parser notConsumed(final String name, final Parser p){
    return notConsumed(name, p, "input consumed");
  }
  /**
   * First run the Parser p, if it succeeds with no input consumed, notConsumed() succeeds;
   * if it fails, notConsumed() fails;
   * if it succeeds and consumes input, the input consumption is undone and notConsumed() fails.
   * <p> Parser a -> Parser a
   * @param name the name of the new Parser.
   * @param p the Parser object to test.
   * @param err the error message when p succeeds and consumes some input.
   * @return the new Parser object.
   */
  public static Parser notConsumed(final String name, final Parser p, final String err){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        final int step = ctxt.getStep();
        final int at = ctxt.getAt();
        if(!p.parse(ctxt)) return false;
        if(ctxt.getAt() == at) return true;
        ctxt.setAt(step, at);
        return raiseRaw(err, ctxt);
      }
    };
  }
  /**
   * Create a lazy evaluated Parser. 
   * the ParserEval object is evaluated only when the Parser is actually executed.
   * <p> Parser a -> Parser a
   * @param p the ParserEval object.
   * @return the Parser object.
   */
  public static Parser lazy(final ParserEval p){
    return lazy("lazy", p);
  }
  /**
   * Create a lazy evaluated Parser. 
   * the ParserEval object is evaluated only when the Parser is actually executed.
   * <p> Parser a -> Parser a
   * @param name the name of the Parser object.
   * @param p the ParserEval object.
   * @return the Parser object.
   */
  public static Parser lazy(final String name, final ParserEval p){
    return LazyParser.instance(name, p);
  }
  private static final Parser _getState = getState("getState");
  /**
   * Retrieves the user state.
   * <p> Parser u u
   * @return the Parser object.
   */
  public static Parser getState(){
    return _getState;
  }
  /**
   * Retrieves the user state.
   * <p> Parser u u
   * @param name the name of the Parser object.
   * @return the Parser object.
   */
  public static Parser getState(final String name){
    return transformState(name, Maps.id());
  }
  /**
   * Updates the user state. The old user state value is returned.
   * <p> Parser u1 u
   * @param s the new user state value.
   * @return the Parser object.
   */
  public static Parser setState(final Object s){
    return setState("setState", s);
  }
  /**
   * Updates the user state.
   * <p> Parser u1 u
   * @param name the name of the Parser object.
   * @param s the new user state value.
   * @return the Parser object.
   */
  public static Parser setState(final String name, final Object s){
    return transformState(name, Maps.cnst(s));
  }
  /**
   * Transforms and updates the user state. The old user state value is returned.
   * <p> (u1->u2) -> Parser u2 u1 
   * @param m the transformation.
   * @return the Parser object.
   */
  public static Parser transformState(final Map m){
    return transformState("transformState", m);
  }
  /**
   * Transforms and updates the user state. The old user state value is returned.
   * <p> (u1->u2) -> Parser u2 u1 
   * @param name the name of the Parser object.
   * @param m the transformation.
   * @return the Parser object.
   */
  public static Parser transformState(final String name, final Map m){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        final Object ustate = ctxt.getUserState();
        ctxt.setUserState(m.map(ustate));
        ctxt.setReturn(ustate);
        return true;
      }
    };
  }
  private static final Parser _getIndex = getIndex("getIndex");
  /**
   * Retrieves the current index in the source.
   * <p> Parser Integer
   * @return the Parser object.
   */
  public static Parser getIndex(){return _getIndex;}
  /**
   * Retrieves the current index in the source.
   * <p> Parser Integer
   * @param name the name of the Parser object.
   * @return the Parser object.
   */
  public static Parser getIndex(final String name){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        ctxt.setReturn(new Integer(ctxt.getIndex()));
        return true;
      }
    };
  }
  /**
   * Look ahead with Parser p. The input consumption is undone.
   * <p> Parser a -> Parser a
   * @param name the name of the new Parser object.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser peek(final String name, final Parser p){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        final int step = ctxt.getStep();
        final int at = ctxt.getAt();
        final boolean r = p.parse(ctxt);
        ctxt.setAt(step, at);
        return r;
      }
    };
  }
  /**
   * Backout input consumption if p fails.
   * The logical step is ensured to be at most 1.
   * <p> Parser a -> Parser a
   * @param name the name of the new Parser object.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser atomize(final String name, final Parser p){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        final int at = ctxt.getAt();
        final int step = ctxt.getStep();
        final boolean r = p.parse(ctxt);
        if(!r) ctxt.setAt(step, at);
        else ctxt.setStep(step+1);
        return r;
      }
    };
  }
  /**
   * if Parser p throws an exception, it is handled by Catch hdl.
   * <p> Parser a -> Parser a
   * @param p the Parser object.
   * @param hdl the exception handler.
   * @return the new Parser object.
   */
  public static Parser tryParser(final Parser p, final Catch hdl){
    return tryParser("try_catch", p, hdl);
  }
  /**
   * if Parser p throws an exception, it is handled by Catch hdl.
   * <p> Parser a -> Parser a
   * @param name the name of the new Parser object.
   * @param p the Parser object.
   * @param hdl the exception handler.
   * @return the new Parser object.
   */
  public static Parser tryParser(final String name, final Parser p, final Catch hdl){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        final AbstractParsecError err0 = ctxt.getError();
        final boolean r = p.parse(ctxt);
        if(!ctxt.hasException()) return r;
        final Parser h = hdl.catchException(ctxt.getReturn(), 
            ctxt.getError().getException());
        ctxt.setError(err0);
        return h.parse(ctxt);
      }
    };
  }
  /**
   * Transform the return value of Parser p to a different value.
   * <p> Parser a -> (a->b) -> Parser b
   * @param name the name of the new Parser object.
   * @param p the Parser object.
   * @param m the Map object.
   * @return the new Parser object.
   */
  public static Parser map(final String name, final Parser p, final Map m){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        final boolean r = p.parse(ctxt);
        if(r){
          ctxt.setReturn(m.map(ctxt.getReturn()));
        }
        return r;
      }
    };
  }
  /**
   * Reports an unexpected error.
   * <p> Parser *
   * @param msg the error message.
   * @return the new Parser object.
   */
  public static Parser unexpected(final String msg){
    return unexpected("unexpected", msg);
  }
  /**
   * Reports an unexpected error.
   * <p> Parser *
   * @param name the name of the new Parser object.
   * @param msg the error message.
   * @return the new Parser object.
   */
  public static Parser unexpected(final String name, final String msg){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        return raiseUnexpected(msg, ctxt);
      }
    };
  }
  /**
   * Token level parser.
   * checks the current token with the FromToken object.
   * If the fromToken() method returns null, a system unexpected token error occurs;
   * if the method returns anything other than null, the token is consumed and token() succeeds.
   * <p> (SourcePos->Token->a) -> Parser a
   * @param ft the FromToken object.
   * @return the new Parser object.
   */
  public static Parser token(final FromToken ft){
    return token("token", ft);
  }
  /**
   * Token level parser.
   * checks the current token with the FromToken object.
   * If the fromToken() method returns null, a system unexpected token error occurs;
   * if the method returns anything other than null, the token is consumed and token() succeeds.
   * <p> (SourcePos->Object->a) -> Parser a
   * @param name the name of the new Parser object.
   * @param ft the FromToken object.
   * @return the new Parser object.
   */
  public static Parser token(final String name, final FromToken ft){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        if(ctxt.isEof()){
          ctxt.setError(ctxt.getSysUnexpected());
          return false;
        }
        final PositionedToken ptok = ctxt.getToken();
        final Object v = ft.fromToken(
            ptok);
        if(v == null){
          ctxt.setError(ctxt.getSysUnexpected());
          return false;
        }
        ctxt.setReturn(v);
        ctxt.next();
        return true;
      }
    };
  }
  /**
   * Token level parser.
   * checks to see if the current token is token t. (using ==).
   * If no, a system unexpected token error occurs;
   * if yes, the token is consumed and token() succeeds.
   * the token is used as the parse result.
   * <p> Object -> Parser SourcePos
   * @param t the expected Token object.
   * @return the new Parser object.
   */
  public static Parser token(final Object t){
    return token("token", t);
  }
  /**
   * Token level parser.
   * checks to see if the current token is token t. (using ==).
   * If no, a system unexpected token error occurs;
   * if yes, the token is consumed and token() succeeds.
   * the token is used as the parse result.
   * <p> Token -> Parser SourcePos
   * @param name the name of the new Parser object.
   * @param t the expected Token object.
   * @return the new Parser object.
   */
  public static Parser token(final String name, final Object t){//the token has to be singleton
    return token(name, IsToken.instance(t));
  }
  /**
   * if Parser p fails and does not consume input, reports an expecting error with the given label.
   * <p> Parser a -> Parser a
   * @param name the name of the new Parser object.
   * @param lbl the label text.
   * @param p the Parser object to label.
   * @return the new Parser object.
   */
  public static Parser label(final String name, final String lbl, final Parser p){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        final int at = ctxt.getAt();
        final boolean r = p.parse(ctxt);
        if(ctxt.getAt() != at) return r;
        if(r) return r;
        return setErrorExpecting(lbl, ctxt);
      }
    };
  }
  /**
   * throws a pseudo-exception.
   * <p> Parser *
   * @param e the exception object.
   * @return the Parser object.
   */
  public static Parser raise(final Object e){
    return raise("raise", e);
  }
  /**
   * throws a pseudo-exception.
   * <p> Parser *
   * @param name the name of the new Parser object.
   * @param e the exception object.
   * @return the Parser object.
   */
  public static Parser raise(final String name, final Object e){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        ctxt.setError(newException(e, ctxt));
        return false;
      }
    };
  }

  /**
   * Greedily runs Parser p repeatedly for at least min times 
   * and collect the result with the Accumulator object created by Accumulatable.
   * Fails if p fails and consumes some input or if p throws a pseudo-exception.
   * <p> Accumulatable a r -> int -> int -> Parser a -> Parser r
   * @param name the name of the new Parser object.
   * @param accm the Accumulatable object.
   * @param min the minimum times to repeat.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser manyAccum(final String name, 
      final Accumulatable accm, final int min,  
      final Parser p){
    if(min<0) throw new IllegalArgumentException("min<0");
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        final Accumulator acc = accm.getAccumulator();
        if(!accm_repeat(acc, min, p, ctxt)) return false;
        if(accm_many(acc, p, ctxt))
          return returnValue(acc.getResult(), ctxt);
        else return false;
      }
    };
  }
  /**
   * Greedily runs Parser p repeatedly for 0 or more times.
   * and collect the result with the Accumulator object created by Accumulatable.
   * Fails if p fails and consumes some input or if p throws a pseudo-exception.
   * <p> Accumulatable a r -> int -> int -> Parser a -> Parser r
   * @param name the name of the new Parser object.
   * @param accm the Accumulatable object.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser manyAccum(final String name, 
      final Accumulatable accm, final Parser p){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        final Accumulator acc = accm.getAccumulator();
        if(accm_many(acc, p, ctxt))
          return returnValue(acc.getResult(), ctxt);
        else return false;
      }
    };
  }
  /**
   * Greedily runs Parser p repeatedly for at least min times and at most max times, 
   * collect the result with the Accumulator object created by Accumulatable.
   * Fails if p fails and consumes some input or if p throws a pseudo-exception.
   * <p> Accumulatable a r -> int -> int -> Parser a -> Parser r
   * @param name the name of the new Parser object.
   * @param accm the Accumulatable object.
   * @param min the minimum times to repeat.
   * @param max the maximum times to repeat.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser someAccum(final String name, 
      final Accumulatable accm, final int min, final int max, 
      final Parser p){
    if(min<0 || max<0 || min>max) throw new IllegalArgumentException();
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        final Accumulator acc = accm.getAccumulator();
        if(!accm_repeat(acc, min, p, ctxt)) return false;
        if(accm_some(acc, max-min, p, ctxt))
          return returnValue(acc.getResult(), ctxt);
        else return false;
      }
    };
  }
  /**
   * Greedily runs Parser p repeatedly for at most max times, 
   * collect the result with the Accumulator object created by Accumulatable.
   * Fails if p fails and consumes some input or if p throws a pseudo-exception.
   * <p> Accumulatable a r -> int -> int -> Parser a -> Parser r
   * @param name the name of the new Parser object.
   * @param accm the Accumulatable object.
   * @param max the maximum times to repeat.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser someAccum(final String name, 
      final Accumulatable accm, final int max, 
      final Parser p){
    if(max<0) throw new IllegalArgumentException("max<0");
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        final Accumulator acc = accm.getAccumulator();
        if(accm_some(acc, max, p, ctxt))
          return returnValue(acc.getResult(), ctxt);
        else return false;
      }
    };
  }
  private static final Parser _eof = eof("EOF");
  /**
   * Asserts eof is met. Fails otherwise.
   * <p> Parser _
   * @return the Parser object.
   */
  public static Parser eof(){
    return _eof;
  }
  /**
   * Asserts eof is met. Fails otherwise.
   * <p> Parser _
   * @param msg the error message if eof is not met.
   * @return the Parser object.
   */
  public static Parser eof(final String msg){
    return eof("eof", msg);
  }
  /**
   * Asserts eof is met. Fails otherwise.
   * <p> Parser _
   * @param name the name of the new Parser object.
   * @param msg the error message if eof is not met.
   * @return the Parser object.
   */
  public static Parser eof(final String name, final String msg){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        if(ctxt.isEof()) return true;
        else{
          final AbstractParsecError expecting = errExpecting(msg, ctxt);
          final AbstractParsecError unexpected = ctxt.getSysUnexpected();
          ctxt.setError(AbstractParsecError
              .mergeError(expecting, unexpected));
          return false;
        }
      }
    };
  }
  /**
   * Succeeds if Parser p fails; Fails otherwise. 
   * Input consumption is undone. 
   * <p> Parser _ -> Parser ()
   * @param name the name of the new Parser object.
   * @param p the Parser to 'not'
   * @return the new Parser object.
   */
  public static Parser not(final String name, final Parser p){
    return not(name, p, p.getName());
  }
  /**
   * Succeeds if Parser p fails; Fails otherwise. 
   * Input consumption is undone. 
   * <p> Parser _ -> Parser ()
   * @param name the name of the new Parser object.
   * @param p the Parser to 'not'
   * @param errmsg the error message if Parser p succeeds.
   * @return the new Parser object.
   */
  public static Parser not(final String name, final Parser p, final String errmsg){
    return ifelse(name, p.peek(), unexpected(errmsg), one());
  }

  /******************** additional combinators ********************/
  

  /**
   * Greedily runs Parser p repeatedly for at least min times
   * and discard the results.
   * <p> int -> Parser a -> Parser ()
   * @param name the name of the new Parser object.
   * @param min the minimal times to run.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser many(final String name, 
      final int min, final Parser p){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        if(!run_repeat(min, p, ctxt)) return false;
        if(run_many(p,ctxt)){
          return returnValue(Unit.instance(), ctxt);
        }
        else return false;
      }
    };
  }
  /**
   * Greedily runs Parser p repeatedly
   * and discard the results.
   * <p> Parser a -> Parser ()
   * @param name the name of the new Parser object.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser many(final String name, final Parser p){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        if(run_many(p,ctxt)){
          return returnValue(Unit.instance(), ctxt);
        }
        else return false;
      }
    };
  }
  /**
   * Greedily runs Parser p repeatedly for at least min times
   * and collect the result in an array whose element type is etype.
   * <p> Class [a] -> int -> Parser a -> Parser [a]
   * @param name the name of the new Parser object.
   * @param etype the array element type.
   * @param min the maximal times to run.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser many(final String name, 
      final Class etype, final int min, final Parser p){
    return many(name, ArrayFactories.typedFactory(etype), min, p);
  }
  /**
   * Greedily runs Parser p repeatedly
   * and collect the result in an array whose element type is etype.
   * <p> Class [a] ->  Parser a -> Parser [a]
   * @param name the name of the new Parser object.
   * @param etype the array element type.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser many(final String name, 
      final Class etype, final Parser p){
    return many(name, ArrayFactories.typedFactory(etype), p);
  }
  /**
   * Greedily runs Parser p repeatedly for at least min times
   * and collect the result in an array created by ArrayFactory object.
   * <p> ArrayFactory a -> int -> Parser a -> Parser [a]
   * @param name the name of the new Parser object.
   * @param af the ArrayFacory object.
   * @param min the maximal times to run.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser many(final String name, 
      final ArrayFactory af, final int min, final Parser p){
    return manyAccum(name, getArrayAccumulatable(af), min, p);
  }
  /**
   * Greedily runs Parser p repeatedly
   * and collect the result in an array created by ArrayFactory object.
   * <p> ArrayFactory a -> Parser a -> Parser [a]
   * @param name the name of the new Parser object.
   * @param af the ArrayFacory object.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser many(final String name, 
      final ArrayFactory af, final Parser p){
    return manyAccum(name, getArrayAccumulatable(af), p);
  }

  /**
   * Greedily runs Parser p repeatedly
   * for at least min times and at most max time.
   * The return values are discarded.
   * <p> int -> int -> Parser a -> Parser ()
   * @param name the name of the new Parser object.
   * @param min the minimal number of times to run.
   * @param max the maximal number of times to run.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser some(final String name, 
      final int min, final int max, final Parser p){
    if(min<0 || max <0 || min>max) throw new IllegalArgumentException();
    if(max==0) return one();
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        if(!run_repeat(min, p, ctxt)) return false;
        if(run_some(max-min,p,ctxt))
          return returnValue(Unit.instance(), ctxt);
        else return false;
      }
    };
  }
  /**
   * Greedily runs Parser p repeatedly
   * for at most max time.
   * The return values are discarded.
   * <p> int -> Parser a -> Parser ()
   * @param name the name of the new Parser object.
   * @param max the maximal number of times to run.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser some(final String name, 
      final int max, final Parser p){
    if(max<0) throw new IllegalArgumentException("max<0");
    if(max==0) return one();
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        if(run_some(max,p,ctxt))
          return returnValue(Unit.instance(), ctxt);
        else return false;
      }
    };
  }
  /**
   * Greedily runs Parser p repeatedly
   * for at least min times and at most max time.
   * The results are collected and returned in an array
   * created by ArrayFactory object.
   * <p> ArrayFactory a -> int -> int -> Parser a -> Parser [a]
   * @param name the name of the new Parser object.
   * @param af the ArrayFacory object.
   * @param min the minimal number of times to run.
   * @param max the maximal number of times to run.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser some(final String name, 
      final ArrayFactory af, final int min, final int max, final Parser p){
    return someAccum(name, getArrayAccumulatable(af), min, max, p);
  }
  /**
   * Greedily runs Parser p repeatedly
   * for at most max time.
   * The results are collected and returned in an array
   * created by ArrayFactory object.
   * <p> ArrayFactory a -> int -> Parser a -> Parser [a]
   * @param name the name of the new Parser object.
   * @param af the ArrayFacory object.
   * @param max the maximal number of times to run.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser some(final String name, 
      final ArrayFactory af, final int max, final Parser p){
    return someAccum(name, getArrayAccumulatable(af), max, p);
  }
  /**
   * Greedily runs Parser p repeatedly for at least min times and at most max times.
   * The return values are collected and returned in an array
   * whose element type is etype.
   * <p> Class -> int -> int -> Parser a -> Parser [Object]
   * @param name the name of the new Parser object.
   * @param etype the array element type.
   * @param min the minimal number of times to run.
   * @param max the maximal number of times to run.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser some(final String name, 
      Class etype, final int min, final int max, final Parser p){
    return some(name, ArrayFactories.typedFactory(etype), min, max, p);
  }

  /**
   * Greedily runs Parser p repeatedly for at most max times.
   * The return values are collected and returned in an array
   * whose element type is etype.
   * <p> Class -> int -> Parser a -> Parser [Object]
   * @param name the name of the new Parser object.
   * @param etype the array element type.
   * @param max the maximal number of times to run.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser some(final String name, 
      Class etype, final int max, final Parser p){
    return some(name, ArrayFactories.typedFactory(etype), max, p);
  }
  
  /**
   * Run 2 Parsers sequentially and transform the return values to a new value.
   * <p> Parser a->Parser b->(a->b->r)->Parser r
   * @param p1 1st parser.
   * @param p2 2nd parser.
   * @param m2 the transformer.
   * @return the new Parser object.
   */
  public static Parser map2(final Parser p1, final Parser p2, final Map2 m2){
    return map2("map2", p1, p2, m2);
  }
  /**
   * Run 2 Parsers sequentially and transform the return values to a new value.
   * <p> Parser a->Parser b->(a->b->r)->Parser r
   * @param name the name of the new Parser object.
   * @param p1 1st parser.
   * @param p2 2nd parser.
   * @param m2 the transformer.
   * @return the new Parser object.
   */
  public static Parser map2(final String name, final Parser p1, final Parser p2
      , final Map2 m2){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        final boolean r1 = p1.parse(ctxt);
        if(!r1) return false;
        final Object o1 = ctxt.getReturn();
        final boolean r2 = p2.parse(ctxt);
        if(!r2) return false;
        final Object o2 = ctxt.getReturn();
        ctxt.setReturn(m2.map(o1,o2));
        return true;
      }
    };
  }
  /**
   * Run 3 Parsers sequentially and transform the return values to a new value.
   * <p> Parser a->Parser b->Parser c->(a->b->c->r)->Parser r
   * @param p1 1st parser.
   * @param p2 2nd parser.
   * @param p3 3rd parser.
   * @param m3 the transformer.
   * @return the new Parser object.
   */
  public static Parser map3(final Parser p1, final Parser p2, final Parser p3
      ,final Map3 m3){
    return map3("map3", p1, p2, p3, m3);
  }
  /**
   * Run 3 Parsers sequentially and transform the return values to a new value.
   * <p> Parser a->Parser b->Parser c->(a->b->c->r)->Parser r
   * @param name the name of the new Parser object.
   * @param p1 1st parser.
   * @param p2 2nd parser.
   * @param p3 3rd parser.
   * @param m3 the transformer.
   * @return the new Parser object.
   */
  public static Parser map3(final String name, 
      final Parser p1, final Parser p2, final Parser p3
      , final Map3 m3){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        final boolean r1 = p1.parse(ctxt);
        if(!r1) return false;
        final Object o1 = ctxt.getReturn();
        final boolean r2 = p2.parse(ctxt);
        if(!r2) return false;
        final Object o2 = ctxt.getReturn();
        final boolean r3 = p3.parse(ctxt);
        if(!r3) return false;
        final Object o3 = ctxt.getReturn();
        ctxt.setReturn(m3.map(o1,o2,o3));
        return true;
      }
    };
  }
  /**
   * Run 4 Parsers sequentially and transform the return values to a new value.
   * <p> Parser a->Parser b->Parser c->Parser d->(a->b->c->d->r)->Parser r
   * @param p1 1st parser.
   * @param p2 2nd parser.
   * @param p3 3rd parser.
   * @param p4 4th parser.
   * @param m4 the transformer.
   * @return the new Parser object.
   */
  public static Parser map4(final Parser p1, final Parser p2,
      final Parser p3, final Parser p4
      , final Map4 m4){
    return map4("map4", p1, p2, p3, p4, m4);
  }
  /**
   * Run 4 Parsers sequentially and transform the return values to a new value.
   * <p> Parser a->Parser b->Parser c->Parser d->(a->b->c->d->r)->Parser r
   * @param name the name of the new Parser object.
   * @param p1 1st parser.
   * @param p2 2nd parser.
   * @param p3 3rd parser.
   * @param p4 4th parser.
   * @param m4 the transformer.
   * @return the new Parser object.
   */
  public static Parser map4(final String name, 
      final Parser p1, final Parser p2,
      final Parser p3, final Parser p4
      ,final Map4 m4){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        final boolean r1 = p1.parse(ctxt);
        if(!r1) return false;
        final Object o1 = ctxt.getReturn();
        final boolean r2 = p2.parse(ctxt);
        if(!r2) return false;
        final Object o2 = ctxt.getReturn();
        final boolean r3 = p3.parse(ctxt);
        if(!r3) return false;
        final Object o3 = ctxt.getReturn();
        final boolean r4 = p4.parse(ctxt);
        if(!r4) return false;
        final Object o4 = ctxt.getReturn();
        ctxt.setReturn(m4.map(o1,o2,o3,o4));
        return true;
      }
    };
  }
  /**
   * Run 5 Parsers sequentially and transform the return values to a new value.
   * <p> Parser a->Parser b->Parser c->Parser d->Parser e->(a->b->c->d->e->r)->Parser r
   * @param p1 1st parser.
   * @param p2 2nd parser.
   * @param p3 3rd parser.
   * @param p4 4th parser.
   * @param p5 5th parser.
   * @param m5 the transformer.
   * @return the new Parser object.
   */
  public static Parser map5(final Parser p1, final Parser p2, final Parser p3,
      final Parser p4, final Parser p5
      ,final Map5 m5){
    return map5("map5", p1, p2, p3, p4, p5, m5);
  }
  /**
   * Run 5 Parsers sequentially and transform the return values to a new value.
   * <p> Parser a->Parser b->Parser c->Parser d->Parser e->(a->b->c->d->e->r)->Parser r
   * @param name the name of the new Parser object.
   * @param p1 1st parser.
   * @param p2 2nd parser.
   * @param p3 3rd parser.
   * @param p4 4th parser.
   * @param p5 5th parser.
   * @param m5 the transformer.
   * @return the new Parser object.
   */
  public static Parser map5(final String name, 
      final Parser p1, final Parser p2, final Parser p3,
      final Parser p4, final Parser p5
      ,final Map5 m5){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        final boolean r1 = p1.parse(ctxt);
        if(!r1) return false;
        final Object o1 = ctxt.getReturn();
        final boolean r2 = p2.parse(ctxt);
        if(!r2) return false;
        final Object o2 = ctxt.getReturn();
        final boolean r3 = p3.parse(ctxt);
        if(!r3) return false;
        final Object o3 = ctxt.getReturn();
        final boolean r4 = p4.parse(ctxt);
        if(!r4) return false;
        final Object o4 = ctxt.getReturn();
        final boolean r5 = p5.parse(ctxt);
        if(!r5) return false;
        final Object o5 = ctxt.getReturn();
        ctxt.setReturn(m5.map(o1,o2,o3,o4,o5));
        return true;
      }
    };
  }
  /**
   * Runs Parser p, if it fails with no input consumed, return default value v instead. <br>
   * plus(p, retn(v))
   * <p> a -> Parser a -> Parser a
   * @param v the default value.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser option(final Object v, final Parser p){
    return option("option", v, p);
  }
  /**
   * Runs Parser p, if it fails with no input consumed, return default value v instead. <br>
   * plus(name, p, retn(v))
   * <p> a -> Parser a -> Parser a
   * @param name the name of the new Parser object.
   * @param v the default value.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser option(final String name, final Object v, final Parser p){
    return plus(name, p, retn(v));
  }
  /**
   * Runs Parser p, if it fails with no input consumed, succeed anyway. <br>
   * plus(p, one())
   * <p> Parser a -> Parser ()
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser optional(final Parser p){
    return optional("optional", p);
  }
  /**
   * Runs Parser p, if it fails with no input consumed, succeed anyway. <br>
   * plus(name, p, one())
   * <p> Parser a -> Parser ()
   * @param name the name of the new Parser object.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser optional(final String name, final Parser p){
    return plus(name, p, one());
  }
  /**
   * Runs a Parser that is between a pair of parsers.
   * First run Parser open, then run Parser p, finally run Parser close. 
   * The return value of p is preserved as the return value. <br>
   * do {open; x<-p; close; return p}
   * <p> Parser _ -> Parser a -> Parser _ -> Parser a
   * @param open the opening parser.
   * @param close the closing parser.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser between(final Parser open, final Parser close, final Parser p){
    return between("between", open, close, p);
  }
  /**
   * runs a Parser that is between a pair of parsers.
   * First run Parser open, then run Parser p, finally run Parser close. 
   * The return value of p is preserved as the return value. <br>
   * do {open; x<-p; close; return p}
   * <p> Parser _ -> Parser a -> Parser _ -> Parser a
   * @param name the name of the new Parser object.
   * @param open the opening parser.
   * @param close the closing parser.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser between(final String name, 
      final Parser open, final Parser close, final Parser p){
    return seq(name, open, p.followedBy(close));
  }
  /**
   * run a series of Parser p pattern that is seperated by Parser sep pattern.
   * <p> Parser p has to succeed at least once. <br>
   * For example: pattern "token, token, token, token" is sepBy1(comma, token). <br> 
   * The return values are discarded.
   * <p> Parser a -> Parser _
   * @param sep the seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser sepBy1(final Parser sep, final Parser p){
    return sepBy1("sepBy1", sep, p);
  }
  /**
   * run a series of Parser p pattern that is seperated by Parser sep pattern.
   * <p> Parser p has to succeed at least once. <br>
   * For example: pattern "token, token, token, token" is sepBy1(comma, token). <br> 
   * The return values are discarded.
   * <p> Parser a -> Parser _
   * @param name the name of the new Parser object.
   * @param sep the seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser sepBy1(final String name, final Parser sep, final Parser p){
    //return sepBy1(name, ArrayFactories.defaultFactory(), sep, p);
    final Parser sepp = seq(sep, p);
    return seq(name, p, sepp.many());
  }
  /**
   * <p> Class -> Parser a -> Parser [Object]. <br>
   * run a series of Parser p pattern that is seperated by Parser sep pattern.
   * <p> Parser p has to succeed at least once. <br>
   * For example: pattern "token, token, token, token" is sepBy1(comma, token). <br> 
   * The return values are collected in an array whose element type is etype.
   * @param etype the array element type.
   * @param sep the seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser sepBy1(final Class etype, final Parser sep, final Parser p){
    return sepBy1("sepBy1", etype, sep, p);
  }
  /**
   * <p> Class -> Parser a -> Parser [Object]. <br>
   * run a series of Parser p pattern that is seperated by Parser sep pattern.
   * <p> Parser p has to succeed at least once. <br>
   * For example: pattern "token, token, token, token" is sepBy1(comma, token). <br> 
   * The return values are collected in an array whose element type is etype.
   * @param name the name of the new Parser object.
   * @param etype the array element type.
   * @param sep the seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser sepBy1(final String name, final Class etype,
      final Parser sep, final Parser p){
    return sepBy1(name, ArrayFactories.typedFactory(etype), sep, p);
  }
  /**
   * run a series of Parser p pattern that is seperated by Parser sep pattern.
   * <p> Parser p has to succeed at least once. <br>
   * For example: pattern "token, token, token, token" is sepBy1(comma, token). <br> 
   * The return values are collected in an array created by the ArrayFactory object af.
   * <p> ArrayFactory a -> Parser a -> Parser [a]
   * @param af the ArrayFacory object.
   * @param sep the seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser sepBy1(final ArrayFactory af,
      final Parser sep, final Parser p){
    return sepBy1("sepBy1", af, sep, p);
  }
  /**
   * run a series of Parser p pattern that is seperated by Parser sep pattern.
   * <p> Parser p has to succeed at least once. <br>
   * For example: pattern "token, token, token, token" is sepBy1(comma, token). <br> 
   * The return values are collected in an array created by the ArrayFactory object af.
   * <p> ArrayFactory a -> Parser a -> Parser [a]
   * @param name the name of the new Parser object.
   * @param af the ArrayFacory object.
   * @param sep the seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser sepBy1(final String name, final ArrayFactory af,
      final Parser sep, final Parser p){
    final Parser sepp = seq(sep, p);
    return bind(name, p, new ToParser(){
      public Parser toParser(final Object v){
        return manyAccum("sepBy1", getArrayAccumulatable(af, v),  
            sepp);
      }
    });
  }

  /**
   * run a series of Parser p pattern that is seperated by Parser sep pattern.
   * <p> Parser p can succeed 0 or more times. <br>
   * For example: pattern "token, token, token, token" is sepBy(comma, token). <br> 
   * The return values are discarded.
   * <p> Parser a -> Parser _
   * @param sep the seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser sepBy(final Parser sep, final Parser p){
    return sepBy("sepBy", sep, p);
  }
  /**
   * run a series of Parser p pattern that is seperated by Parser sep pattern.
   * <p> Parser p can succeed 0 or more times. <br>
   * For example: pattern "token, token, token, token" is sepBy(comma, token). <br> 
   * The return values are discarded.
   * <p> Parser a -> Parser _
   * @param name the name of the new Parser object.
   * @param sep the seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser sepBy(final String name, final Parser sep, final Parser p){
    return plus(name, sepBy1(sep, p), _retn_unit);
  }
  /**
   * run a series of Parser p pattern that is seperated by Parser sep pattern.
   * <p> Parser p can succeed 0 or more times. <br>
   * For example: pattern "token, token, token, token" is sepBy(comma, token). <br> 
   * The return values are collected in an array whose element type is etype.
   * <p> Class -> Parser a -> Parser [Object]
   * @param etype the array element type.
   * @param sep the seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser sepBy(final Class etype, final Parser sep, final Parser p){
    return sepBy("sepBy", etype, sep, p);
  }
  /**
   * run a series of Parser p pattern that is seperated by Parser sep pattern.
   * <p> Parser p can succeed 0 or more times. <br>
   * For example: pattern "token, token, token, token" is sepBy(comma, token). <br> 
   * The return values are collected in an array created by the ArrayFactory object af.
   * <p> ArrayFactory a -> Parser a -> Parser [a]
   * @param af the ArrayFacory object.
   * @param sep the seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser sepBy(final ArrayFactory af, final Parser sep, final Parser p){
    return sepBy("sepBy", af, sep, p);
  }
  /**
   * run a series of Parser p pattern that is seperated by Parser sep pattern.
   * <p> Parser p can succeed 0 or more times. <br>
   * For example: pattern "token, token, token, token" is sepBy(comma, token). <br> 
   * The return values are collected in an array created by the ArrayFactory object af.
   * <p> ArrayFactory a -> Parser a -> Parser [a]
   * @param name the name of the new Parser object.
   * @param af the ArrayFacory object.
   * @param sep the seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser sepBy(final String name, final ArrayFactory af, final Parser sep, final Parser p){
    return option(name, af.createArray(0), sepBy1(af, sep, p));
  }
  /**
   * run a series of Parser p pattern that is seperated by Parser sep pattern.
   * <p> Parser p can succeed 0 or more times. <br>
   * For example: pattern "token, token, token, token" is sepBy(comma, token). <br> 
   * The return values are collected in an array whose element type is etype.
   * <p> Class -> Parser a -> Parser [Object]
   * @param name the name of the new Parser object.
   * @param etype the array element type.
   * @param sep the seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser sepBy(final String name, final Class etype, final Parser sep, final Parser p){
    return sepBy(name, ArrayFactories.typedFactory(etype), sep, p);
  }
  /**
   * First run Parser p, then run Parser sep. The return value of Parser p is preserved as the return value.
   * <br> do{x<-p;sep;return x}.
   * <p> Parser _ -> Parser a -> Parser a 
   * @param name the name of the new Parser object.
   * @param sep the following parser.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser followedBy(final String name, final Parser sep, final Parser p){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        final boolean r1 = p.parse(ctxt);
        if(!r1) return r1;
        final Object ret = ctxt.getReturn();
        if(!sep.parse(ctxt)) return false;
        ctxt.setReturn(ret);
        return true;
      }
    };
  }
  /**
   * run a series of Parser p pattern ended by Parser sep pattern.
   * <p> Parser p can succeed 0 or more times. <br>
   * For example: pattern "token; token; token; token;" is endBy(comma, token). <br> 
   * The return values are discarded.
   * <p> Class -> Parser a -> Parser _
   * @param sep the end seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser endBy(final Parser sep, final Parser p){
    return endBy("endBy", sep, p);
  }
  /**
   * run a series of Parser p pattern ended by Parser sep pattern.
   * <p> Parser p can succeed 0 or more times. <br>
   * For example: pattern "token; token; token; token;" is endBy(comma, token). <br> 
   * The return values are discarded.
   * <p> Class -> Parser a -> Parser _
   * @param name the name of the new Parser object.
   * @param sep the end seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser endBy(final String name, final Parser sep, final Parser p){
    return p.followedBy(sep).many(name);
  }
  /**
   * run a series of Parser p pattern ended by Parser sep pattern.
   * <p> Parser p can succeed 0 or more times. <br>
   * For example: pattern "token; token; token; token;" is endBy(comma, token). <br> 
   * The return values are collected in an array whose element type is etype.
   * <p> Class -> Parser a -> Parser [Object]
   * @param etype array element type.
   * @param sep the end seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser endBy(final Class etype, final Parser sep, final Parser p){
    return endBy("endBy", etype, sep, p);
  }
  /**
   * run a series of Parser p pattern ended by Parser sep pattern.
   * <p> Parser p can succeed 0 or more times. <br>
   * For example: pattern "token; token; token; token;" is endBy(comma, token). <br> 
   * The return values are discarded.
   * <p> ArrayFactory a -> Parser a -> Parser ()
   * @param af the ArrayFacory object.
   * @param sep the end seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser endBy(final ArrayFactory af, final Parser sep, final Parser p){
    return endBy("endBy", af, sep, p);
  }
  /**
   * run a series of Parser p pattern ended by Parser sep pattern.
   * <p> Parser p can succeed 0 or more times. <br>
   * For example: pattern "token; token; token; token;" is endBy(comma, token). <br> 
   * The return values are collected in an array whose element type is etype.
   * <p> Class -> Parser a -> Parser [Object]
   * @param name the name of the new Parser object.
   * @param etype array element type.
   * @param sep the end seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser endBy(final String name, final Class etype, 
      final Parser sep, final Parser p){
    return p.followedBy(sep).many(name, etype);
  }
  /**
   * run a series of Parser p pattern ended by Parser sep pattern.
   * <p> Parser p can succeed 0 or more times. <br>
   * For example: pattern "token; token; token; token;" is endBy(comma, token). <br> 
   * The return values are collected in an array created by the ArrayFactory object af.
   * <p> ArrayFactory a -> Parser a -> Parser [a]
   * @param name the name of the new Parser object.
   * @param af the ArrayFacory object.
   * @param sep the end seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser endBy(final String name, final ArrayFactory af, 
      final Parser sep, final Parser p){
    return p.followedBy(sep).many(name, af);
  }
  /**
   * run a series of Parser p pattern ended by Parser sep pattern.
   * <p> Parser p should succeed for at least once. <br>
   * For example: pattern "token; token; token; token;" is endBy(comma, token). <br> 
   * The return values are discarded.
   * <p> Class -> Parser a -> Parser _
   * @param sep the end seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser endBy1(final Parser sep, final Parser p){
    return endBy1("endBy1", sep, p);
  }
  /**
   * run a series of Parser p pattern ended by Parser sep pattern.
   * <p> Parser p should succeed for at least once. <br>
   * For example: pattern "token; token; token; token;" is endBy(comma, token). <br> 
   * The return values are discarded.
   * <p> Class -> Parser a -> Parser _
   * @param name the name of the new Parser object.
   * @param sep the end seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser endBy1(final String name, final Parser sep, final Parser p){
    return p.followedBy(sep).many1(name);
  }
  /**
   * run a series of Parser p pattern ended by Parser sep pattern.
   * <p> Parser p should succeed for at least once. <br>
   * For example: pattern "token; token; token; token;" is endBy(comma, token). <br> 
   * The return values are collected in an array whose element type is etype.
   * <p> Class -> Parser a -> Parser [Object]
   * @param etype array element type.
   * @param sep the end seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser endBy1(final Class etype, final Parser sep, final Parser p){
    return endBy1("endBy1", etype, sep, p);
  }
  /**
   * run a series of Parser p pattern ended by Parser sep pattern.
   * <p> Parser p should succeed for at least once. <br>
   * For example: pattern "token; token; token; token;" is endBy1(comma, token). <br> 
   * The return values are collected in an array created by the ArrayFactory object af.
   * <p> ArrayFactory a -> Parser a -> Parser [a]
   * @param af the ArrayFacory object.
   * @param sep the end seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser endBy1(final ArrayFactory af, final Parser sep, final Parser p){
    return endBy1("endBy1", af, sep, p);
  }
  /**
   * run a series of Parser p pattern ended by Parser sep pattern.
   * <p> Parser p should succeed for at least once. <br>
   * For example: pattern "token; token; token; token;" is endBy1(comma, token). <br> 
   * The return values are collected in an array created by the ArrayFactory object af.
   * <p> ArrayFactory a -> Parser a -> Parser [a]
   * @param name the name of the new Parser object.
   * @param af the ArrayFacory object.
   * @param sep the end seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser endBy1(final String name, final ArrayFactory af, 
      final Parser sep, final Parser p){
    return p.followedBy(sep).many1(name, af);
  }
  /**
   * run a series of Parser p pattern ended by Parser sep pattern.
   * <p> Parser p should succeed for at least once. <br>
   * For example: pattern "token; token; token; token;" is endBy(comma, token). <br> 
   * The return values are collected in an array whose element type is etype.
   * <p> Class -> Parser a -> Parser [Object]
   * @param name the name of the new Parser object.
   * @param etype array element type.
   * @param sep the end seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser endBy1(final String name, final Class etype, 
      final Parser sep, final Parser p){
    return p.followedBy(sep).many1(name, etype);
  }
  /**
   * run a series of Parser p pattern that is seperated and optionally ended by Parser sep pattern.
   * <p> Parser p may succeed 0 or more times. <br>
   * For example: patterns "token; token; token; token" and "token;" are both sepEndBy(semicolon, token). <br> 
   * The return values are discarded.
   * <p> Class -> Parser a -> Parser _
   * @param sep the end seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser sepEndBy(final Parser sep, final Parser p){
    return sepEndBy("sepEndBy", sep, p);
  }
  /**
   * run a series of Parser p pattern that is seperated and optionally ended by Parser sep pattern.
   * <p> Parser p may succeed 0 or more times. <br>
   * For example: patterns "token; token; token; token" and "token;" are both sepEndBy(semicolon, token). <br> 
   * The return values are collected in an array whose element type is etype.
   * <p> Class -> Parser a -> Parser [Object]
   * @param etype the array element type.
   * @param sep the end seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser sepEndBy(final Class etype, final Parser sep, final Parser p){
    return sepEndBy("sepEndBy", etype, sep, p);
  }
  /**
   * run a series of Parser p pattern that is seperated and optionally ended by Parser sep pattern.
   * <p> Parser p may succeed 0 or more times. <br>
   * For example: patterns "token; token; token; token" and "token;" are both sepEndBy(semicolon, token). <br> 
   * The return values are collected in an array created by the ArrayFactory object af.
   * <p> ArrayFactory a -> Parser a -> Parser [a]
   * @param af the ArrayFacory object.
   * @param sep the end seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser sepEndBy(final ArrayFactory af, final Parser sep, final Parser p){
    return sepEndBy("sepEndBy", af, sep, p);
  }
  /**
   * run a series of Parser p pattern that is seperated and optionally ended by Parser sep pattern.
   * <p> Parser p may succeed 0 or more times. <br>
   * For example: patterns "token; token; token; token" and "token;" are both sepEndBy(semicolon, token). <br> 
   * The return values are discarded.
   * <p> Parser a -> Parser _
   * @param name the name of the new Parser object.
   * @param sep the end seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser sepEndBy(final String name,
      final Parser sep, final Parser p){
    return plus(name, sepEndBy1(sep, p), _retn_unit);
  }
  /**
   * run a series of Parser p pattern that is seperated and optionally ended by Parser sep pattern.
   * <p> Parser p may succeed 0 or more times. <br>
   * For example: patterns "token; token; token; token" and "token;" are both sepEndBy(semicolon, token). <br> 
   * The return values are collected in an array whose element type is etype.
   * <p> Class -> Parser a -> Parser [Object]
   * @param name the name of the new Parser object.
   * @param etype the array element type.
   * @param sep the end seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser sepEndBy(final String name, final Class etype,
      final Parser sep, final Parser p){
    return sepEndBy(name, ArrayFactories.typedFactory(etype), sep, p);
  }
  /**
   * run a series of Parser p pattern that is seperated and optionally ended by Parser sep pattern.
   * <p> Parser p may succeed 0 or more times. <br>
   * For example: patterns "token; token; token; token" and "token;" are both sepEndBy(semicolon, token). <br> 
   * The return values are collected in an array created by the ArrayFactory object af.
   * <p> ArrayFactory a -> Parser a -> Parser [a]
   * @param name the name of the new Parser object.
   * @param af the ArrayFacory object.
   * @param sep the end seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser sepEndBy(final String name, final ArrayFactory af,
      final Parser sep, final Parser p){
    return option(name, af.createArray(0), sepEndBy1(af, sep, p));
  }
  
  /**
   * run a series of Parser p pattern that is seperated and optionally ended by Parser sep pattern.
   * <p> Parser p should succeed at least once. <br>
   * For example: patterns "token; token; token; token" and "token;" are both sepEndBy1(semicolon, token). <br> 
   * The return values are collected in an Object[] array.
   * <p> Parser a -> Parser [Object]
   * @param sep the end seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */  
  public static Parser sepEndBy1(final Parser sep, final Parser p){
    return sepEndBy1("sepEndBy1", sep, p);
  }
  /**
   * run a series of Parser p pattern that is seperated and optionally ended by Parser sep pattern.
   * <p> Parser p should succeed at least once. <br>
   * For example: patterns "token; token; token; token" and "token;" are both sepEndBy1(semicolon, token). <br> 
   * The return values are discarded.
   * <p> Parser a -> Parser _
   * @param name the name of the new Parser object.
   * @param sep the end seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser sepEndBy1(final String name, final Parser sep, final Parser p){
    //return sepEndBy1(name, ArrayFactories.defaultFactory(), sep, p);
    final Object end = new Object();
    final Catch catcher = new Catch1(end);
    final Parser x = seq(sep, plus(p, raise(end)));
    return seq(p, tryParser(x.many(name), catcher));
  }
  /**
   * run a series of Parser p pattern that is seperated and optionally ended by Parser sep pattern.
   * <p> Parser p should succeed at least once. <br>
   * For example: patterns "token; token; token; token" and "token;" are both sepEndBy1(semicolon, token). <br> 
   * The return values are collected in an array whose element type is etype.
   * <p> Class -> Parser a -> Parser [Object]
   * @param etype the array element type.
   * @param sep the end seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser sepEndBy1(final Class etype, final Parser sep, final Parser p){
    return sepEndBy1("sepEndBy1", etype, sep, p);
  }
  /**
   * run a series of Parser p pattern that is seperated and optionally ended by Parser sep pattern.
   * <p> Parser p should succeed at least once. <br>
   * For example: patterns "token; token; token; token" and "token;" are both sepEndBy1(semicolon, token). <br> 
   * The return values are collected in an array created by the ArrayFactory object af.
   * <p> ArrayFactory a -> Parser a -> Parser [a]
   * @param af the ArrayFacory object.
   * @param sep the end seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser sepEndBy1(final ArrayFactory af, final Parser sep, final Parser p){
    return sepEndBy1("sepEndBy1", af, sep, p);
  }
  /**
   * run a series of Parser p pattern that is seperated and optionally ended by Parser sep pattern.
   * <p> Parser p should succeed at least once. <br>
   * For example: patterns "token; token; token; token" and "token;" are both sepEndBy1(semicolon, token). <br> 
   * The return values are collected in an array whose element type is etype.
   * <p> Class -> Parser a -> Parser [Object]
   * @param name the name of the new Parser object.
   * @param etype the array element type.
   * @param sep the end seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser sepEndBy1(final String name, final Class etype, final Parser sep, final Parser p){
    return sepEndBy1(name, ArrayFactories.typedFactory(etype), sep, p);
  }
  /**
   * run a series of Parser p pattern that is seperated and optionally ended by Parser sep pattern.
   * <p> Parser p should succeed at least once. <br>
   * For example: patterns "token; token; token; token" and "token;" are both sepEndBy1(semicolon, token). <br> 
   * The return values are collected in an array created by the ArrayFactory object af.
   * <p> ArrayFactory a -> Parser a -> Parser [a]
   * @param name the name of the new Parser object.
   * @param af the ArrayFacory object.
   * @param sep the end seperator.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser sepEndBy1(final String name, final ArrayFactory af, final Parser sep, final Parser p){
    /*
    final Object end = new Object();
    final Catch catcher = new Catch1(end);
    final Parser x = seq(sep, plus(p, raise(end)));
    return bind(name, p, new ToParser(){
      public Parser toParser(final Object v){
        final Parser rep = manyAccum(name, getArrayAccumulatable(af, v), x);
        return tryParser(rep, catcher);
      }
    });*/
    return bind(name, p, new ToParser(){
      public Parser toParser(final Object v){
        return delimitedBy(name, getArrayAccumulatable(af, v), sep, p);
      }
    });
  }

  private static Parser delimitedBy(final String name, 
      final Accumulatable accm, final Parser delim, final Parser p){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        final Accumulator acc = accm.getAccumulator();
        for(;;){
          final int at0 = ctxt.getAt();
          boolean r = delim.parse(ctxt);
          final int at1 = ctxt.getAt();
          if(!r){
            if(at0 != at1){
              return false;
            }
            return returnValue(acc.getResult(), ctxt);
          }
          r = p.parse(ctxt);
          final int at2 = ctxt.getAt();
          if(!r){
            if(at1 != at2){
              return false;
            }
            return returnValue(acc.getResult(), ctxt);
          }
          if(isInfiniteLoop(at0, at2)){
            return true;
          }
          acc.accumulate(ctxt.getReturn());
        }
      }
    };
  }

  /**
   * Runs Parser p for n times. Return values are discarded.
   * <p> Class -> int -> Parser a -> Parser _
   * @param name the name of the new Parser object.
   * @param n the number of times to run.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser repeat(final String name, final int n, final Parser p){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        if(run_repeat(n, p, ctxt)){
          ctxt.setReturn(Unit.instance());
          return true;
        }
        else return false;
      }
    };
  }
  /**
   * Runs Parser p for n times, collect the return values in an array whose element type is etype.
   * <p> Class -> int -> Parser a -> Parser [Object]
   * @param name the name of the new Parser object.
   * @param etype the array element type.
   * @param n the number of times to run.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser repeat(final String name, final Class etype, final int n, final Parser p){
    return repeat(name, ArrayFactories.typedFactory(etype), n, p);
  }
  /**
   * Runs Parser p for n times, collect the return values in an array created by the ArrayFactory object.
   * <p> ArrayFactory a -> int -> Parser a -> Parser [a]
   * @param name the name of the new Parser object.
   * @param af the ArrayFactory object.
   * @param n the number of times to run.
   * @param p the Parser object.
   * @return the new Parser object.
   */
  public static Parser repeat(final String name, final ArrayFactory af, final int n, final Parser p){
    return new Parser(name){
      boolean parse(final ParseContext ctxt){
        final Object[] ret = af.createArray(n);
        for(int i=0; i<n; i++){
          if(!p.parse(ctxt)) return false;
          ret[i] = ctxt.getReturn();
        }
        ctxt.setReturn(ret);
        return true;
      }
    };
  }

  /**
   * Runs Parser op for 0 or more times greedily. Then run Parser p.
   * The Map object returned from op are applied from right to left to the return value of p. <br>
   * prefix(op, p) is equivalent to op* p in EBNF
   * <p> Parser (a->a) -> Parser a -> Parser a
   * @param op the operator.
   * @param p the operand.
   * @return the new Parser object.
   */
  public static Parser prefix(final Parser op, final Parser p){
    return prefix("prefix", op, p);
  }
  private static Object postfix_thread_maps(Object a, final Map[] ms){
    for(int i=0; i<ms.length; i++){
      final Map m = ms[i];
      a = m.map(a);
    }
    return a;
  }
  private static Object prefix_thread_maps(Object a, final Map[] ms){
    for(int i=ms.length-1; i>=0; i--){
      final Map m = ms[i];
      a = m.map(a);
    }
    return a;
  }
  private static final Map2 _prefix_map2 = new Map2(){
    public Object map(final Object ops, final Object a){
      return prefix_thread_maps(a, (Map[])ops);
    }
  };
  
  /**
   * Runs Parser op for 0 or more times greedily. Then run Parser p.
   * The Map object returned from op are applied from right to left to the return value of p. <br>
   * prefix(op, p) is equivalent to op* p in EBNF
   * <p> Parser (a->a) -> Parser a -> Parser a
   * @param name the name of the new Parser object.
   * @param op the operator.
   * @param p the operand.
   * @return the new Parser object.
   */
  public static Parser prefix(final String name, final Parser op, final Parser p){
    return map2(name, op.many("prefix", Map.class), p, _prefix_map2);
  }
  /**
   * Runs Parser p and then run Parser op for 0 or more times greedily.
   * The Map object returned from op are applied from left to right to the return value of p. <br>
   * postfix(op, p) is equivalent to p op* in EBNF
   * <p> Parser (a->a) -> Parser a -> Parser a
   * @param op the operator.
   * @param p the operand.
   * @return the new Parser object.
   */
  public static Parser postfix(final Parser op, final Parser p){
    return postfix("postfix", op, p);
  }
  private static final Map2 _postfix_map2 = new Map2(){
    public Object map(final Object a, final Object ops){
      return postfix_thread_maps(a, (Map[])ops);
    }
  };
  /**
   * Runs Parser p and then run Parser op for 0 or more times greedily.
   * The Map object returned from op are applied from left to right to the return value of p. <br>
   * postfix(op, p) is equivalent to p op* in EBNF
   * <p> Parser (a->a) -> Parser a -> Parser a
   * @param name the name of the new Parser object.
   * @param op the operator.
   * @param p the operand.
   * @return the new Parser object.
   */
  public static Parser postfix(final String name, final Parser op, final Parser p){
    final Parser ops = op.many(name, Map.class);
    return map2(name, p, ops, _postfix_map2);
  }
  /**
   * Non-associative infix operator.
   * Runs Parser p and then run Parser op and Parser p optionally.
   * The Map2 object returned from op is applied to the return values of the two p pattern, if any. <br>
   * infixn(op, p) is equivalent to p (op p)? in EBNF
   * <p> Parser (a->a->a) -> Parser a -> Parser a
   * @param op the operator.
   * @param operand the operand.
   * @return the new Parser object.
   */
  public static Parser infixn(final Parser op, final Parser operand){
    return infixn("infixn", op, operand);
  }
  /**
   * Non-associative infix operator.
   * Runs Parser p and then run Parser op and Parser p optionally.
   * The Map2 object returned from op is applied to the return values of the two p pattern, if any. <br>
   * infixn(op, p) is equivalent to p (op p)? in EBNF
   * <p> Parser (a->a->a) -> Parser a -> Parser a
   * @param name the name of the new Parser object.
   * @param op the operator.
   * @param operand the operand.
   * @return the new Parser object.
   */
  public static Parser infixn(final String name, final Parser op, final Parser operand){
    return operand.bind(name, new ToParser(){
      public Parser toParser(final Object a){
        return Parsers.plus(
          op.and(operand, new Map2(){
            public Object map(final Object o, final Object b){
              final Map2 m2 = (Map2)o;
              return m2.map(a, b);
            }
          }),
          retn(a));
      }
    });
  }

  /**
   * Left associative infix operator.
   * Runs Parser p and then run Parser op and Parser p for 0 or more times greedily.
   * The Map object returned from op are applied from left to right to the return value of p. <br>
   * for example: a+b+c+d is evaluated as (((a+b)+c)+d). <br>
   * infixl(op, p) is equivalent to p (op p)* in EBNF.
   * <p> Parser (a->a->a) -> Parser a -> Parser a
   * @param op the operator.
   * @param p the operand.
   * @return the new Parser object.
   */
  public static Parser infixl(final Parser op, final Parser p){
    return infixl("infixl", op, p);
  }
  /**
   * Left associative infix operator.
   * Runs Parser p and then run Parser op and Parser p for 0 or more times greedily.
   * The Map object returned from op are applied from left to right to the return values of p. <br>
   * for example: a+b+c+d is evaluated as (((a+b)+c)+d). <br>
   * infixl(op, p) is equivalent to p (op p)* in EBNF.
   * <p> Parser (a->a->a) -> Parser a -> Parser a
   * @param name the name of the new Parser object.
   * @param op the operator.
   * @param p the operand.
   * @return the new Parser object.
   */
  public static Parser infixl(final String name, final Parser op, final Parser p){
    return bind(name, p, new ToParser(){
      public Parser toParser(final Object a){
        return manyAccum("infixl", lassocAccumulatable(a), op_rhs(op, p));
      }
    });
    //return postfix(name, op_rhs(op, p), p); //this uses a temporary array.
  }
  /**
   * Right associative infix operator.
   * Runs Parser p and then run Parser op and Parser p for 0 or more times greedily.
   * The Map object returned from op are applied from right to left to the return values of p. <br>
   * for example: a+b+c+d is evaluated as a+(b+(c+d)). <br>
   * infixr(op, p) is equivalent to p (op p)* in EBNF.
   * <p> Parser (a->a->a) -> Parser a -> Parser a
   * @param op the operator.
   * @param p the operand.
   * @return the new Parser object.
   */
  public static Parser infixr(final Parser op, final Parser p){
    return infixr("infixr", op, p);
  }
  //1+ 1+ 1+ ..... 1
  private static final class Rhs{
    final Map2 op;
    final Object rhs;
    Rhs(final Map2 op, final Object rhs){
      this.op = op;
      this.rhs = rhs;
    }
  }
  private static final Map2 _infixr_map2 = new Map2(){
    public Object map(final Object a, final Object b){
      final Map2 m2 = (Map2)a;
      return new Rhs(m2, b);
    }
  };
  private static final Map2 _calc_infixr = new Map2(){
    public Object map(final Object a, final Object b){
      final Rhs[] tmp = (Rhs[])b;
      if(tmp.length==0) return a;
      Object o2 = tmp[tmp.length-1].rhs;
      for(int i=tmp.length-1; i>0; i--){
        final Map2 m2 = tmp[i].op;
        final Object o1 = tmp[i-1].rhs;
        o2 = m2.map(o1, o2);
      }
      return tmp[0].op.map(a, o2);
    }
  };
  /**
   * Right associative infix operator.
   * Runs Parser p and then run Parser op and Parser p for 0 or more times greedily.
   * The Map object returned from op are applied from right to left to the return values of p. <br>
   * for example: a+b+c+d is evaluated as a+(b+(c+d)). <br>
   * infixr(op, p) is equivalent to p (op p)* in EBNF.
   * <p> Parser (a->a->a) -> Parser a -> Parser a
   * @param name the name of the new Parser object.
   * @param op the operator.
   * @param p the operand.
   * @return the new Parser object.
   */
  public static Parser infixr(final String name, final Parser op, final Parser p){
    final Parser op_rhs2 = map2(op, p, _infixr_map2);
    final Parser tmp = op_rhs2.many(name, Rhs.class);
    return map2(p, tmp, _calc_infixr);
    
  }
  /**
   * Consumes a token. The token is used as the return value of the parser.
   * <p> Parser Token
   * @return the Parser object.
   */
  public static Parser anyToken(){
    return anyToken("anyToken");
  }
  private static final FromToken _any_tok = new FromToken(){
    public Object fromToken(final PositionedToken tok){
      return tok;
    }
  };
  /**
   * Consumes a token. The position of the token is used as the return value of the parser.
   * <p> Parser Token
   * @param name the name of the Parser object.
   * @return the Parser object.
   */
  public static Parser anyToken(final String name){
    return token(name, _any_tok);
  }


  private static Accumulatable lassocAccumulatable(final Object init){
    return new Accumulatable(){
      public Accumulator getAccumulator(){
        return new Accumulator(){
          private Object a = init;
          public void accumulate(final Object o){
            final Map m = (Map)o;
            a = m.map(a);
          }
          public Object getResult(){return a;}
        };
      }
    };
  }
  private static final Map2 _op_rhs_map2 = new Map2(){
    public Object map(final Object o, final Object a){
      final Map2 m2 = (Map2)o;
      return new Map(){
        public Object map(final Object a1){
          return m2.map(a1, a);
        }
      };
    }
  };
  //Parser Map
  private static Parser op_rhs(final Parser op, final Parser rhs){
    return map2(op, rhs, _op_rhs_map2);
  }

  /******************** derived combinators ********************/

  static boolean setErrorExpecting(
      final String s, final ParseContext state){
    final AbstractParsecError err = state.getError();
    if(err==null){
      state.setError(errExpecting(s, state));
    }
    else
      state.setError(err.setExpecting(s));
    return false;
  }
  private static boolean runToParser(final ToParser p, final ParseContext state){
    return p.toParser(state.getReturn()).parse(state);
  }
  private static boolean runNext(final ParseContext s, final ToParser p){
    return runToParser(p, s);
  }
  private static boolean returnValue(final Object v, final ParseContext state){
    state.setError(ParsecError.noError());
    state.setReturn(v);
    return true;
  }
  private static ParsecError newException(final Object e, final ParseContext state){
    return ParsecError.throwException(state.getAt(), e);
  }
  private static Parser[] copy(Parser[] ps){
    return (Parser[])ps.clone();
  }
  private static ToParser[] copy(ToParser[] ps){
    return (ToParser[])ps.clone();
  }
  private static boolean raiseRaw(final String msg, final ParseContext state){
    state.setError(ParsecError.raiseRaw(state.getAt(), msg));
    return false;
  }
  private static boolean raiseUnexpected(final String msg, final ParseContext state){
    state.setError(ParsecError.raiseUnexpected(state.getAt(), msg));
    return false;
  }
  private static ParsecError errExpecting(final String msg, final ParseContext state){
    return ParsecError.raiseExpecting(state.getAt(), msg);
  }
  //performance of this method is insignificant.
  private static String toErrorStr(final ParseContext state){
    final AbstractParsecError aerr = state.getError();
    if(aerr==null){
      return "";
    }
    final ParsecError err = aerr.render();
    if(err.getException() != null){
      return ("User exception: " + err.getException().toString());
    }
    else return "";
  }
  private static Object[] getArrayResult(final ArrayList l, final ArrayFactory af){
    final Object[] arr = af.createArray(l.size());
    try{
      l.toArray(arr);
    }
    catch(ArrayStoreException e){
      final Class etype = arr.getClass().getComponentType();
      for(int i=0; i<l.size(); i++){
        final Object elem = l.get(i);
        if(elem!=null && !etype.isInstance(elem)){
          final String msg = "cannot cast the #"+i+" element: <"+elem+"> of type "
          + elem.getClass().getName() + " to " + etype.getName();
          throw new ClassCastException(msg);
        }
      }
      throw e;
    }
    return arr;
  }
  private static class ArrayAccumulator implements Accumulator{
    public void accumulate(final Object o){
      l.add(o);
    }
    public Object getResult(){
      return getArrayResult(l, af);
    }
    private final java.util.ArrayList l;
    private final ArrayFactory af;
    ArrayAccumulator(final ArrayFactory af, final java.util.ArrayList al){
      this.af = af;
      this.l = al;
    }
  }

  private static Accumulatable getArrayAccumulatable(final ArrayFactory af){
    return new Accumulatable(){
      public Accumulator getAccumulator(){
        return new ArrayAccumulator(af, new java.util.ArrayList());
      }
    };
  }

  private static Accumulatable getArrayAccumulatable(
      final ArrayFactory af, final Object init){
    return new Accumulatable(){
      public Accumulator getAccumulator(){
        final java.util.ArrayList a = new java.util.ArrayList();
        a.add(init);
        return new ArrayAccumulator(af, a);
      }
    };
  }
  private static boolean recover(final int look_ahead, final Parser p,
      final ParseContext state, final int step, final int at, 
      final Object ret, final Object ustate, final AbstractParsecError error){
    if(state.getAt() != at && state.getStep() - step >= look_ahead)
      return false;
    if(state.hasException()) return false;
    state.set(step, at, ret, ustate, error);
    if(p.parse(state)) return true;
    state.setError(AbstractParsecError.mergeError(error, state.getError()));
    return false;    
  }
  private static final Object[] _empty_array = new Object[0];
  private static final Parser _retn_unit = retn(Unit.instance());
  //change the infinite loop handling. don't fail. just stop looping.
  private static boolean isInfiniteLoop(final int at0, final int at1){
    return (at0==at1);
    /*
    if(at0 == at1){
      throw new ParserException("parser accepts an empty input", null, 
          "parsec", null);
    }*/
  }

  
  private static boolean run_repeat(final int n, final Parser p, final ParseContext ctxt){
    for(int i=0; i<n; i++){
      if(!p.parse(ctxt)) return false;
    }
    return true;
  }
  private static boolean run_many(final Parser p, final ParseContext ctxt){
    for(;;){
      final int at = ctxt.getAt();
      final boolean r = p.parse(ctxt);
      if(r){
        if(isInfiniteLoop(at, ctxt.getAt())){
          return true;
        }
        continue;
      }
      else if(ctxt.hasException())
        return false;
      else if(ctxt.getAt() - at >= 1)
        return false;
      else
        return true;
    }
  }
  private static boolean run_some(final int max, final Parser p, final ParseContext ctxt){
    for(int i=0;i<max;i++){
      final int at = ctxt.getAt();
      final boolean r = p.parse(ctxt);
      if(r) continue;
      else if(ctxt.hasException())
        return false;
      else if(ctxt.getAt() - at >= 1)
        return false;
      else
        return true;
    }
    return true;
  }
  private static boolean accm_repeat(final Accumulator acc, final int n,
      final Parser p, final ParseContext ctxt){
    for(int i=0;i<n;i++){
      final boolean r = p.parse(ctxt);
      if(r){
        acc.accumulate(ctxt.getReturn());
        continue;
      }
      else if(ctxt.hasException()){
        ctxt.setReturn(acc.getResult());
        return false;
      }
      else return false;
    }
    return true;
  }
  private static boolean accm_some(final Accumulator acc, final int max,
      final Parser p, final ParseContext ctxt){
    for(int i=0;i<max;i++){
      final int at = ctxt.getAt();
      final boolean r = p.parse(ctxt);
      if(r){
        acc.accumulate(ctxt.getReturn());
        continue;
      }
      else if(ctxt.hasException()){
        ctxt.setReturn(acc.getResult());
        return false;
      }
      else if(ctxt.getAt() - at >= 1){
        return false;
      }
      else{
        break;
      }
    }
    return true;
  }
  private static boolean accm_many(final Accumulator acc,
      final Parser p, final ParseContext ctxt){
    for(;;){
      final int at = ctxt.getAt();
      final boolean r = p.parse(ctxt);
      if(r){
        if(isInfiniteLoop(at, ctxt.getAt())){
          break;
        }
        acc.accumulate(ctxt.getReturn());
        continue;
      }
      else if(ctxt.hasException()){
        ctxt.setReturn(acc.getResult());
        return false;
      }
      else if(ctxt.getAt() - at >= 1) return false;
      else break;
    }
    return true;
  }
}
