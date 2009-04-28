/*
 * File			: MappingParser.java
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

import com.uva.se.wparse.model.declaration.Mapping;
import com.uva.se.wparse.model.markup.Markup;


public class MappingParser {


	  static Parser<Mapping> mappingDef(Parser<Markup> markup) {
		  return curry( Mapping.class).sequence(
				  Terminals.Identifier.PARSER.sepBy1(TerminalParser.term("/") ),   //dir path
				 TerminalParser.term("."), Terminals.Identifier.PARSER, // extention
				 TerminalParser.term(":"), 
				  markup);

	  }
	  
	  

	public static Parser<Mapping> mapping(Parser<Markup> markup) {
		@SuppressWarnings("unchecked")
		Parser<Mapping> parser = Parsers.or(
				mappingDef(markup)
		);
		return parser;
	}
	
	private static Mapper<Mapping> curry(
			Class<? extends Mapping> clazz, Object... curryArgs) {
		return Mapper.curry(clazz, curryArgs);
	}
}
