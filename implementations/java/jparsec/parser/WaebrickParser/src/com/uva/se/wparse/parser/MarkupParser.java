/*
 * File			: MarkupParser.java
 * Project		: WaebrickParser
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

public class MarkupParser {


	public static Parser<Markup> markupDesignator(Parser<Attribute> attributeParser) {
		return curry(Designator.class).sequence(ExpressionParser.IDENTIFIER.source(), attributeParser.many());
	}
	
	//this method is used for arguments that are quoted
	private static Parser<Markup> markupArguments(Parser<Attribute> attributeParser, Parser<Argument> argumentParser) {
		return curry(MarkupArgument.class).sequence(
		markupDesignator(attributeParser), //.many1() ,
		ArgumentParser.blockArgument(argumentParser));
	}
	
	
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

	private static Mapper<Markup> curry(Class<? extends Markup> clazz, Object... curryArgs) {
		return Mapper.curry(clazz, curryArgs);
	}



}
