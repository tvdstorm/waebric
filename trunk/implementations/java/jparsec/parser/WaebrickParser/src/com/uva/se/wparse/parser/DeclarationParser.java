/*
 * File			: DeclarationParser.java
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


import java.util.List;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.Terminals;
import org.codehaus.jparsec.functors.Map;
import org.codehaus.jparsec.misc.Mapper;

import com.uva.se.wparse.model.declaration.Mapping;
import com.uva.se.wparse.model.declaration.Member;
import com.uva.se.wparse.model.declaration.MethodDef;
import com.uva.se.wparse.model.declaration.ModuleBody;
import com.uva.se.wparse.model.declaration.ModuleDef;
import com.uva.se.wparse.model.declaration.QualifiedName;
import com.uva.se.wparse.model.declaration.SiteDef;
import com.uva.se.wparse.model.embedding.Embedding;
import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.markup.Argument;
import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.model.statement.Statement;


public final class DeclarationParser {
	

	
  static Parser<ModuleBody> body(Parser<Member> member) {
    return Mapper.curry(ModuleBody.class).sequence(
        member.many().map(new Map<List<Member>, List<Member>>() {
          public List<Member> map(List<Member> from) {
            return from;
          }
        }));
  }

  static Parser<Member> methodDef( Parser<Statement> stmt, Parser<Expression> expr,   Parser<Embedding> embedding  ) {
	  ArgumentParser argumentParser = new ArgumentParser();
	  Parser<Argument>  argParser = argumentParser.arguments(expr);
	  Parser<Argument>  blockArgParser = argumentParser.blockArgument(argParser);
	  
    return Mapper.<Member>curry(MethodDef.class).sequence(
        TerminalParser.term("def"), Terminals.Identifier.PARSER,
        blockArgParser.optional(),
        Parsers.or(stmt, expr, embedding).many(),
        TerminalParser.term("end"));
  }
  
  
  static Parser<Member> siteDef( Parser<Mapping> mappingParser) {
	    return Mapper.<Member>curry(SiteDef.class).sequence(
	        TerminalParser.term("site"),
	        mappingParser.many(),
	        TerminalParser.term("end"));
	  }
  

  static final Parser<QualifiedName> QUALIFIED_NAME =
      Mapper.curry(QualifiedName.class).sequence(Terminals.Identifier.PARSER.sepBy1(TerminalParser.term(".")));
 
  
  static final Parser<QualifiedName> MODULE = Parsers.sequence(TerminalParser.term(TerminalParser.KEYWORD_MODULE), QUALIFIED_NAME);
  
  static final Parser<QualifiedName> importParser = Parsers.sequence(TerminalParser.term("import"), QUALIFIED_NAME);
  
  private static Parser<ModuleDef> module() {
    Parser.Reference<Member> memberRef = Parser.newReference();
    Parser<Expression> expr = ExpressionParser.expression(body(memberRef.lazy()));
    Parser<Markup> markup = MarkupParser.markup(expr);
    Parser<Statement> stmt = StatementParser.statement(expr,markup); 
    EmbeddingParser embedding = new EmbeddingParser();
    Parser<Embedding> embeddingParser = embedding.getParser(markup, expr);
    
    Parser<Mapping> mappingParser = MappingParser.mapping(markup);
    

    return Mapper.curry(ModuleDef.class).sequence(
    		MODULE, importParser.many(), Parsers.or(methodDef(stmt, expr,embeddingParser), siteDef(mappingParser)).many() );
  }
  
  
  public ModuleDef parse(String source) {
    return TerminalParser.parse(module(), source);
  }
  
  

}
