
package com.uva.se.wparse.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.Scanners;
import org.codehaus.jparsec.Terminals.IntegerLiteral;
import org.codehaus.jparsec.Terminals.ScientificNumberLiteral;
import org.codehaus.jparsec.misc.Mapper;
import org.codehaus.jparsec.pattern.CharPredicate;
import org.codehaus.jparsec.pattern.Patterns;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.NumberType;
import com.uva.se.wparse.model.MappingDef;

/**
 * Lexer specific for the Java language rules.
 * 
 * @author Ben Yu
 */
public final class WaebrickLexer {
  
//  private static final CharPredicate JAVA_IDENTIFIER_START = new CharPredicate() {
//    public boolean isChar(char c) {
//      return Character.isJavaIdentifierStart(c);
//    }
//  };
//  
//  private static final CharPredicate JAVA_IDENTIFIER_PART = new CharPredicate() {
//    public boolean isChar(char c) {
//      return Character.isJavaIdentifierPart(c);
//    }
//  };
//  
//  static final Parser<String> IDENTIFIER = Scanners.pattern(
//      Patterns.isChar(JAVA_IDENTIFIER_START).next(Patterns.isChar(JAVA_IDENTIFIER_PART).many()),
//      "identifier").source();
//  
//  static final Parser<Void> DECIMAL_POINT_SCANNER =
//      Scanners.pattern(Patterns.INTEGER.optional().next(Patterns.FRACTION),
//          "decimal point number");
	
	
	
	private static final CharPredicate IDENTIFIER_START = new CharPredicate() {
	    public boolean isChar(char c) {
	    	 Pattern p = Pattern.compile("[a-zA-Z]");
	    	 Matcher m = p.matcher(String.valueOf(c));
	    	 return m.matches();
	    }
	  };
	  
	  private static final CharPredicate IDENTIFIER_PART = new CharPredicate() {
	    public boolean isChar(char c) {
	    	Pattern p = Pattern.compile("[a-zA-Z0-9]");
	    	 Matcher m = p.matcher(String.valueOf(c));
	    	 return m.matches();
	    }
	  };
	  

	
	
	
	  private static final CharPredicate PATH_ELEMENT = new CharPredicate() {
		    public boolean isChar(char c) {
		    	Pattern p = Pattern.compile("[a-zA-Z0-9]");
		    	 Matcher m = p.matcher(String.valueOf(c));
		    	 return m.matches();
		    }
		  };
		  
		  
		  private static final CharPredicate PATH_SEPARATOR = new CharPredicate() {
			    public boolean isChar(char c) {
			    
			    	 return '/' == c;
			    }
			  };
			  
			  
			  static final Parser<String> IDENTIFIER = Scanners.pattern(
				      Patterns.isChar(IDENTIFIER_START).next(Patterns.isChar(IDENTIFIER_PART).many()
				      .next(Patterns.isChar(PATH_SEPARATOR).not())     ),
				      "identifier").source();
		  
	  
			 public static final Parser<String> PATH =  Scanners.pattern(
				      Patterns.isChar(PATH_ELEMENT).many().next( Patterns.sequence(Patterns.isChar(PATH_SEPARATOR),
				    		  Patterns.isChar(PATH_ELEMENT).many()).many()  ),"path").source();
  
  static final Parser<MappingDef> MAPPING = Mapper.curry(MappingDef.class).sequence(PATH);
  
//  static final Parser<IntegerLiteral> HEX_INTEGER = new Mapper<IntegerLiteral>() {
//    @SuppressWarnings("unused")
//    IntegerLiteral map(String text, NumberType type) {
//      return new IntegerLiteral(Radix.HEX, text.substring(2), type);
//    }
//  }.sequence(Scanners.HEX_INTEGER.source(), numberType(NumberType.INT));
//  
//  static final Parser<IntegerLiteral> OCT_INTEGER = new Mapper<IntegerLiteral>() {
//    @SuppressWarnings("unused")
//    IntegerLiteral map(String text, NumberType type) {
//      return new IntegerLiteral(Radix.OCT, text.length() == 1 ? text : text.substring(1), type);
//    }
//  }.sequence(Scanners.OCT_INTEGER.source(), numberType(NumberType.INT));
//  
//  static final Parser<IntegerLiteral> DEC_INTEGER =
//      Mapper.curry(IntegerLiteral.class, Radix.DEC)
//      .sequence(Scanners.DEC_INTEGER.source(), numberType(NumberType.INT));
//  
//  static final Parser<IntegerLiteral> INTEGER = Parsers.or(HEX_INTEGER, OCT_INTEGER, DEC_INTEGER);
//  
//  static final Parser<ScientificNumberLiteral> SCIENTIFIC_NUMBER_LITERAL =
//      Mapper.curry(ScientificNumberLiteral.class)
//        .sequence(Scanners.SCIENTIFIC_NOTATION, numberType(NumberType.DOUBLE));
//  
//  static Parser<NumberType> numberType(NumberType defaultType) {
//    return Parsers.or(
//        Scanners.among("lL").retn(NumberType.LONG),
//        Scanners.among("fF").retn(NumberType.FLOAT),
//        Scanners.among("dD").retn(NumberType.DOUBLE),
//        Parsers.constant(defaultType)
//     );
//  }
}
