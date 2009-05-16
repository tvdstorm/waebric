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
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.Terminals;
import org.codehaus.jparsec.misc.Mapper;

import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.model.module.Mapping;

public class MappingParser {

	static Parser<Mapping> mappingDef(Parser<Markup> markup) {
		return curry(Mapping.class).sequence(
				//Terminals.Identifier.PARSER.sepBy(TerminalParser.term("/")), // dir
				ExpressionParser.IDENTIFIER2.sepBy(TerminalParser.term("/")).followedBy(TerminalParser.term(".")), // dir
				//TerminalParser.term("."),
				ExpressionParser.FILE_EXT, // extention
				TerminalParser.term(":"),
				markup
				//, TerminalParser.term(";")
				);

	}
	
//	static Parser<Mapping> mappingDef(Parser<Markup> markup) {
//		return curry(Mapping.class).sequence(
//				Terminals.Identifier.PARSER.sepBy(TerminalParser.term("/")), //path
//				Terminals.Identifier.PARSER.source(), //filename
//				TerminalParser.term("."),  
//				Terminals.Identifier.PARSER, //extention
//				TerminalParser.term(":"), 
//				markup						//markup
//				//TerminalParser.term(";")
//				);
//
//	}
//	


	public static Parser<Mapping> mapping(Parser<Markup> markup) {
		Parser.Reference<Mapping> ref = Parser.newReference();
		Parser<Mapping> parser = mappingDef(markup);
		ref.set(parser);
		return parser;
	}

	private static Mapper<Mapping> curry(Class<? extends Mapping> clazz,
			Object... curryArgs) {
		return Mapper.curry(clazz, curryArgs);
	}
}
