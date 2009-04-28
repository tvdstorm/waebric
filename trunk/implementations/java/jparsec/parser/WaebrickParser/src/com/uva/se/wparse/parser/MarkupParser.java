/*
 * File			: MarkupParser.java
 * Project		: WaebrickParser
 * 				: Practicum opdracht Software Construction
 * 
 * Authors		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * 
 * Description	:
 * 
 */
package com.uva.se.wparse.parser;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.Terminals;
import org.codehaus.jparsec.misc.Mapper;

import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.markup.Argument;
import com.uva.se.wparse.model.markup.Attribute;
import com.uva.se.wparse.model.markup.Designator;
import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.model.markup.MarkupArgument;

public class MarkupParser {


	public static Parser<Markup> markupDesignator(Parser<Attribute> attributeParser) {
		return curry(Designator.class).sequence(Terminals.Identifier.PARSER, 
				attributeParser.many());
	}
	static Parser<Markup> markupArguments(Parser<Attribute> attribute, Parser<Argument> argumentParser) {
		return curry(MarkupArgument.class).sequence(markupDesignator(attribute).many1() ,  argumentParser	);
	}
	
	
	public static Parser<Markup> markup(Parser<Expression> expr) {
		Parser.Reference<Markup> ref = Parser.newReference();
		Parser<Markup> lazy = ref.lazy();
		Parser<Argument> argumentParser = ArgumentParser.arguments(expr);
		Parser<Attribute> attributeParser = AttributeParser.attributes();
		@SuppressWarnings("unchecked")
		Parser<Markup> parser = Parsers.or(
			markupArguments(attributeParser, argumentParser) ,
			markupDesignator(attributeParser)
		);
		ref.set(parser);
		return parser;
	}

	private static Mapper<Markup> curry(Class<? extends Markup> clazz,
			Object... curryArgs) {
		return Mapper.curry(clazz, curryArgs);
	}



}
