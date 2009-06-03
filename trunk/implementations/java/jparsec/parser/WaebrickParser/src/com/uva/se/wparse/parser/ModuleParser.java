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

	private static Parser<Member> methodDef(Parser<Statement> statementParser, Parser<Expression> expressionParser) {
		Parser<Argument> argParser = ArgumentParser.arguments(expressionParser);
		//Parser<Argument> blockArgParser = ArgumentParser.blockArgument(argParser);

		return Mapper.<Member> curry(FunctionDef.class).sequence(
				TerminalParser.term(Keyword.DEF.toString()),
				ExpressionParser.IDENTIFIER.source(),
				//blockArgParser.optional(),
				ArgumentParser.formals(),
				statementParser.many(),
				TerminalParser.term(Keyword.END.toString()));
	}

	private static Parser<Member> siteDef(Parser<Mapping> mappingParser) {
		return Mapper.<Member> curry(SiteDef.class).sequence(
				TerminalParser.term(Keyword.SITE.toString()),
				mappingParser.sepBy(TerminalParser.term(Operator.SEMI_COLON
						.toString())),
				TerminalParser.term(Keyword.END.toString()));
	}

	private static final Parser<QualifiedName> QUALIFIED_NAME = Mapper.curry(
			QualifiedName.class).sequence(
			Terminals.Identifier.PARSER.sepBy1(TerminalParser.term(Operator.DOT
					.toString())));

	private static final Parser<QualifiedName> MODULE = Parsers.sequence(
			TerminalParser.term(Keyword.MODULE.toString()), QUALIFIED_NAME);

	private static final Parser<QualifiedName> importParser = Parsers.sequence(
			TerminalParser.term(Keyword.IMPORT.toString()), QUALIFIED_NAME);

	private static Parser<ModuleDef> module() {
		Parser.Reference<Member> memberRef = Parser.newReference();
		Parser<Expression> expr = ExpressionParser.expression(body(memberRef.lazy()));
		Parser<Markup> markupParser = MarkupParser.markup(expr);
		Parser<Statement> statementParser = StatementParser.statement(expr, markupParser);
		Parser<Mapping> mappingParser = MappingParser.mapping(markupParser);

		return Mapper.curry(ModuleDef.class).sequence(
				MODULE,
				importParser.many(),
				Parsers.or(methodDef(statementParser, expr),
						siteDef(mappingParser)).many());
	}

	public ModuleDef parse(String source) {
		return TerminalParser.parse(ModuleParser.module(), source);
	}

}
