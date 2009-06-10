/*
 * File			: MarkupParser.java
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
import org.codehaus.jparsec.misc.Mapper;

import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.markup.Argument;
import com.uva.se.wparse.model.markup.Attribute;
import com.uva.se.wparse.model.markup.Designator;
import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.model.markup.MarkupArgument;

/**
 * Create several Parsers which are related to the Markup
 * of the Waebric language. 
 */
public class MarkupParser {

	/**
	 * Create a Parser of the Markup based on a Parser of Attribute. 
	 * @param attributeParser A Parser of Attribute (This is a class of our ParseTree model).  
	 * @return A Parser of Markup (This is a class of our ParseTree model).  
	 */
	public static Parser<Markup> markupDesignator(Parser<Attribute> attributeParser) {
		return curry(Designator.class).sequence(ExpressionParser.IDENTIFIER.source(), attributeParser.many());
	}
	
	/**
	 * Create a Parser of the Markup based on a Parser of Attribute and Argument. 
	 * @param attributeParser A Parser of Attribute (This is a class of our ParseTree model).  
	 * @param argumentParser A Parser of Argument (This is a class of our ParseTree model).  
	 * @return A Parser of Markup (This is a class of our ParseTree model).  
	 */
	private static Parser<Markup> markupArguments(Parser<Attribute> attributeParser, Parser<Argument> argumentParser) {
		return curry(MarkupArgument.class).sequence(
		markupDesignator(attributeParser), //.many1() ,
		ArgumentParser.blockArgument(argumentParser));
	}
	
	/**
	 * Create a Parser of the Markup based on a Parser of Expressionn. 
	 * @param expressionParser A Parser of Expression (This is a class of our ParseTree model).  
	 * @return A Parser of Markup (This is a class of our ParseTree model).  
	 */
	public static Parser<Markup> markup(Parser<Expression> expressionParser) {
		Parser.Reference<Markup> ref = Parser.newReference();
		Parser<Argument> argParser = ArgumentParser.arguments(expressionParser);
		Parser<Attribute> attributeParser = AttributeParser.attributes();
		Parser<Markup> parser = Parsers.or(
			markupArguments(attributeParser, argParser) ,
			markupDesignator(attributeParser)
		);
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
	private static Mapper<Markup> curry(Class<? extends Markup> clazz, Object... curryArgs) {
		return Mapper.curry(clazz, curryArgs);
	}
}
