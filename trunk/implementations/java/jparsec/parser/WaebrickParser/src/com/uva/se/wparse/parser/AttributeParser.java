/*
 * File			: AttributeParser.java
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

import com.uva.se.wparse.model.markup.Attribute;
import com.uva.se.wparse.model.markup.MultipleAttribute;
import com.uva.se.wparse.model.markup.SingleAttribute;

public class AttributeParser {
	
	static Parser<Attribute> singleAttribute() {
		return curryAttribute(SingleAttribute.class).sequence(
				Parsers.or(TerminalParser.term("#"), TerminalParser.term("."),
						TerminalParser.term("$"), TerminalParser.term(":")),
				Terminals.Identifier.PARSER);
	}

	static Parser<Attribute> multipleAttribute() {
		return curryAttribute(MultipleAttribute.class).sequence(
				TerminalParser.term("@"),
				Terminals.IntegerLiteral.PARSER, Parsers.sequence(TerminalParser.term("%"),Terminals.IntegerLiteral.PARSER).optional());
	}
	


	public static Parser<Attribute> attributes() {
		@SuppressWarnings("unchecked")
		Parser<Attribute> parser = Parsers.or(
				singleAttribute(),
				multipleAttribute()
				
				);
		return parser;
	}
	
	private static Mapper<Attribute> curryAttribute(
			Class<? extends Attribute> clazz, Object... curryArgs) {
		return Mapper.curry(clazz, curryArgs);
	}

}
