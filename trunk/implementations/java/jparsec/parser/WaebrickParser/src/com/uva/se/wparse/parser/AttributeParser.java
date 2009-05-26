/*
 * File			: AttributeParser.java
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
import org.codehaus.jparsec.Terminals;
import org.codehaus.jparsec.misc.Mapper;

import com.uva.se.wparse.model.markup.Attribute;
import com.uva.se.wparse.model.markup.MultipleAttribute;
import com.uva.se.wparse.model.markup.SingleAttribute;

public class AttributeParser {

	private static Parser<Attribute> singleAttribute() {
		return curryAttribute(SingleAttribute.class).sequence(
				Parsers.or(TerminalParser.term(Operator.POUND.toString()),
						TerminalParser.term(Operator.DOT.toString()),
						TerminalParser.term(Operator.DOLLAR.toString()),
						TerminalParser.term(Operator.COLON.toString())),
				ExpressionParser.IDENTIFIER.source());
	}

	private static Parser<Attribute> multipleAttribute() {
		return curryAttribute(MultipleAttribute.class).sequence(
				TerminalParser.term(Operator.AT.toString()),
				Terminals.IntegerLiteral.PARSER,
				Parsers.sequence(
						TerminalParser.term(Operator.PERCENT.toString()),
						Terminals.IntegerLiteral.PARSER).optional());
	}

	public static Parser<Attribute> attributes() {
		Parser<Attribute> parser = Parsers.or(singleAttribute(),
				multipleAttribute()

		);
		return parser;
	}

	private static Mapper<Attribute> curryAttribute(
			Class<? extends Attribute> clazz, Object... curryArgs) {
		return Mapper.curry(clazz, curryArgs);
	}

}
