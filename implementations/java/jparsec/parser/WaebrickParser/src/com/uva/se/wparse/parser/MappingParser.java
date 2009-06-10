/*
 * File			: MappingParser.java
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
import org.codehaus.jparsec.misc.Mapper;

import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.model.module.Mapping;

/**
 * Create several parsers which constructs parsers of the Waebric language. 
 */
public class MappingParser {

	/**
	 * Create a Parser of the Mapping based on a Parser of Markup. 
	 * @param markupParser A Parser of Member (This is a class of our ParseTree model).  
	 * @return A Parser of Mapping (This is a class of our ParseTree model).  
	 */
	private static Parser<Mapping> mappingDef(Parser<Markup> markupParser) {
		return curry(Mapping.class).sequence(
		ExpressionParser.PATH_ELEMENT.sepBy(
		TerminalParser.term(Operator.SLASH.toString())).followedBy(
		TerminalParser.term(Operator.DOT.toString())), // dir
		ExpressionParser.FILE_EXT, // extention
		TerminalParser.term(Operator.COLON.toString()),
		markupParser // markup function call
		);

	}

	/**
	 * Create a Parser of the Mapping based on a Parser of Markup. 
	 * @param markupParser A Parser of Markup (This is a class of our ParseTree model).  
	 * @return A Parser of Mapping (This is a class of our ParseTree model).  
	 */
	public static Parser<Mapping> mapping(Parser<Markup> markupParser) {
		Parser.Reference<Mapping> ref = Parser.newReference();
		Parser<Mapping> parser = mappingDef(markupParser);
		ref.set(parser);
		return parser;
	}

	/**
	 * Utility method for construction of model objects for parsed data
	 * @param clazz the model class to load
	 * @param curryArgs the parameters used for the default constructor of the model class identified by
	 * parameter clazz
	 * @return Mapper that maps data to Java object Argument
	 * @see Argument
	 */
	private static Mapper<Mapping> curry(Class<? extends Mapping> clazz,
		Object... curryArgs) {
		return Mapper.curry(clazz, curryArgs);
	}
}
