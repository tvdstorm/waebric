/*
 * File			: MappingParser.java
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
import org.codehaus.jparsec.misc.Mapper;

import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.model.module.Mapping;

public class MappingParser {

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

	public static Parser<Mapping> mapping(Parser<Markup> markupParser) {
		Parser.Reference<Mapping> ref = Parser.newReference();
		Parser<Mapping> parser = mappingDef(markupParser);
		ref.set(parser);
		return parser;
	}

	private static Mapper<Mapping> curry(Class<? extends Mapping> clazz,
		Object... curryArgs) {
		return Mapper.curry(clazz, curryArgs);
	}
}
