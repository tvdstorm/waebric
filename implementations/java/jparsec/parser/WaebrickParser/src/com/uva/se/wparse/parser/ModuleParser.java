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

import com.uva.se.wparse.model.embedding.Embedding;
import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.markup.Argument;
import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.model.module.FunctionDef;
import com.uva.se.wparse.model.module.Mapping;
import com.uva.se.wparse.model.module.Member;
import com.uva.se.wparse.model.module.ModuleBody;
import com.uva.se.wparse.model.module.ModuleDef;
import com.uva.se.wparse.model.module.QualifiedName;
import com.uva.se.wparse.model.module.SiteDef;
import com.uva.se.wparse.model.statement.Statement;


public final class ModuleParser implements WeabrickParser {
	

	
	private static Parser<ModuleBody> body(Parser<Member> member) {
    return Mapper.curry(ModuleBody.class).sequence(
        member.many().map(new Map<List<Member>, List<Member>>() {
          public List<Member> map(List<Member> from) {
            return from;
          }
        }));
  }

  private static Parser<Member> methodDef( Parser<Statement> statementParser, Parser<Expression> expr,   Parser<Embedding> embedding  ) {
	  Parser<Argument>  argParser = ArgumentParser.arguments(expr);
	  Parser<Argument>  blockArgParser = ArgumentParser.blockArgument(argParser);
	  
    return Mapper.<Member>curry(FunctionDef.class).sequence(
        TerminalParser.term("def"), ExpressionParser.IDENTIFIER.source(),
        blockArgParser.optional(),
        statementParser.many(),  
        TerminalParser.term("end")
        );
  }
  
  
  private static Parser<Member> siteDef( Parser<Mapping> mappingParser) {
	    return Mapper.<Member>curry(SiteDef.class).sequence(
	       TerminalParser.term("site"),
	       mappingParser.sepBy(TerminalParser.term(";")),
	       TerminalParser.term("end")
	       );
	  }
  

  private static final Parser<QualifiedName> QUALIFIED_NAME =
      Mapper.curry(QualifiedName.class).sequence(Terminals.Identifier.PARSER.sepBy1(TerminalParser.term(".")));
 
  
  private static final Parser<QualifiedName> MODULE = Parsers.sequence(TerminalParser.term(Keywords.MODULE.toString()), QUALIFIED_NAME);
  
  private static final Parser<QualifiedName> importParser = Parsers.sequence(TerminalParser.term("import"), QUALIFIED_NAME);
  
  private static Parser<ModuleDef> module() {
    Parser.Reference<Member> memberRef = Parser.newReference();
    Parser<Expression> expr = ExpressionParser.expression(body(memberRef.lazy()));
    Parser<Markup> markup = MarkupParser.markup(expr);
    Parser<Statement> stmt = StatementParser.statement(expr,markup); 
    Parser<Embedding> embeddingParser = EmbeddingParser.getParser(markup, expr);
    
    Parser<Mapping> mappingParser = MappingParser.mapping(markup);
    

    return Mapper.curry(ModuleDef.class).sequence(
    		MODULE, importParser.many(), Parsers.or(methodDef(stmt, expr,embeddingParser), siteDef(mappingParser)).many() );
  }
  
  
  public ModuleDef parse(String source) {
    return TerminalParser.parse( ModuleParser.module(), source);
  }
  
  

}
