/*
 * File			: AttributeParser.java
 * Project		: WaebrickParser2
 * 				: Waebrick Parser, practicum opdracht Software Construction
 * 
 * Author		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * Description	:
 * 
 * 
 * Change history
 * -----------------------------------------------------------
 * Date			Change				 
 * -----------------------------------------------------------
 * 07-05-2009	Initial version.
 * 
 * 
 */
package com.uva.se.wparse.parser;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.Terminals;
import org.codehaus.jparsec.misc.Mapper;

import com.uva.se.wparse.model.markup.Attribute;
import com.uva.se.wparse.model.markup.MultipleAttribute;
import com.uva.se.wparse.model.markup.SingleAttribute;

/**
 * Create a parser of attributes. 
 */
public class AttributeParser {

	/**
	 * Create a Parser of the Attribute.
	 * @return A Parser of Attribute (This is a class of our ParseTree model).  
	 */
	private static Parser<Attribute> singleAttribute() {
		return curryAttribute(SingleAttribute.class).sequence(
		Parsers.or(TerminalParser.term(Operator.POUND.toString()),
		TerminalParser.term(Operator.DOT.toString()),
		TerminalParser.term(Operator.DOLLAR.toString()),
		TerminalParser.term(Operator.COLON.toString())),
		ExpressionParser.IDENTIFIER.source());
	}
	/**
	 * Create a Parser of the Attribute.
	 * @return A Parser of Attribute (This is a class of our ParseTree model).  
	 */
	private static Parser<Attribute> multipleAttribute() {
		return curryAttribute(MultipleAttribute.class).sequence(
		TerminalParser.term(Operator.AT.toString()),
		Terminals.IntegerLiteral.PARSER,
		Parsers.sequence(TerminalParser.term(Operator.PERCENT.toString()),
		Terminals.IntegerLiteral.PARSER).optional());
	}
	/**
	 * Create a Parser of the Attribute.
	 * @return A Parser of Attribute (This is a class of our ParseTree model).  
	 */
	public static Parser<Attribute> attributes() {
		return Parsers.or(singleAttribute(), multipleAttribute());
	}
	
	/**
	 * Utility method for construction of model objects for parsed data
	 * @param clazz the model class to load
	 * @param curryArgs the parameters used for the default constructor of the model class identified by
	 * parameter clazz
	 * @return Mapper that maps data to Java object Argument
	 * @see Argument
	 */
	private static Mapper<Attribute> curryAttribute(Class<? extends Attribute> clazz, Object... curryArgs) {
		return Mapper.curry(clazz, curryArgs);
	}

}
