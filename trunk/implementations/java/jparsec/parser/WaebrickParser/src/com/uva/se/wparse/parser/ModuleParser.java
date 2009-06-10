/*
 * File			: ModuleParser.java
 * Project		: WaebrickParser2
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

import com.uva.se.wparse.exception.ParserException;
import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.markup.Formals;
import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.model.module.FunctionDef;
import com.uva.se.wparse.model.module.Mapping;
import com.uva.se.wparse.model.module.Member;
import com.uva.se.wparse.model.module.ModuleBody;
import com.uva.se.wparse.model.module.ModuleDef;
import com.uva.se.wparse.model.module.QualifiedName;
import com.uva.se.wparse.model.module.SiteDef;
import com.uva.se.wparse.model.statement.Statement;

/**
 * The highest level Parser. The parsing process is like a tree of several 
 * Parsers. All the other parsers all called via the top of the tree, which is 
 * this class. 
 */
public final class ModuleParser implements WeabrickParser {

	/**
	 * Parse the sourcecode and call all the underlying parsers. 
	 */
	public ModuleDef parse(String source)throws ParserException {
		ModuleDef module = null;
		
		try {
			module = TerminalParser.parse(ModuleParser.module(), source);
		} catch (Exception e) {
			throw new ParserException("parser error", e);
		}
		
		return module;
	}
	
	/**
	 * Create a Parser of ModuleDef . 
	 * @return A parser of ModeleDef (This is a class of our ParseTree model). 
	 */
	private static Parser<ModuleDef> module() {
		
		// Create other parsers. 
		Parser.Reference<Member> memberRef = Parser.newReference();
		Parser<Expression> expr = ExpressionParser.expression(body(memberRef
				.lazy()));
		Parser<Markup> markupParser = MarkupParser.markup(expr);
		Parser<Statement> statementParser = StatementParser.statement(expr,
				markupParser);
		Parser<Mapping> mappingParser = MappingParser.mapping(markupParser);

		return Mapper.curry(ModuleDef.class).sequence(
				MODULE,
				importParser.many(),
				Parsers.or(methodDef(statementParser, expr),
						siteDef(mappingParser)).many());
	}
	
	/**
	 * Create a Parser of the ModuleBody based on a Parser of Member. 
	 * @param member A Parser of Member (This is a class of our ParseTree model).  
	 * @return A Parser of ModuleBody (This is a class of our ParseTree model). 
	 */
	private static Parser<ModuleBody> body(Parser<Member> member) {
		return Mapper.curry(ModuleBody.class).sequence(
				member.many().map(new Map<List<Member>, List<Member>>() {
					public List<Member> map(List<Member> from) {
						return from;
					}
				}));
	}

	/**
	 * Create a Parser of Formals. 
	 * @return A Parser of Formals (This is a class of our ParseTree model). 
	 */
	private static Parser<Formals> formals() {
		return curry(Formals.class).sequence(
				TerminalParser.term(Operator.ROUND_BRACKET_OPEN.toString()),
				ExpressionParser.IDENTIFIER.sepBy(TerminalParser
						.term(Operator.COMMA.toString())),
				TerminalParser.term(Operator.ROUND_BRACKET_CLOSE.toString()));
	}

	/**
	 * Create a mapping between the classes of the model and parser process. 
	 * @param clazz The class of the model. 
	 * @param curryArgs The part of the parser process. 
	 * @return A mapper.
	 */
	private static Mapper<Formals> curry(Class<? extends Formals> clazz,
			Object... curryArgs) {
		return Mapper.curry(clazz, curryArgs);
	}

	/**
	 * Create a Parser of the Member based on a Parser of Statement and Expression. 
	 * @param statementParser A Parser of Statement (This is a class of our ParseTree model). 
	 * @param expressionParser A Parser of Expression (This is a class of our ParseTree model). 
	 * @return A Parser of Member (This is a class of our ParseTree model). 
	 */
	private static Parser<Member> methodDef(Parser<Statement> statementParser,
			Parser<Expression> expressionParser) {
		return Mapper.<Member> curry(FunctionDef.class).sequence(
				TerminalParser.term(Keyword.DEF.toString()),
				ExpressionParser.IDENTIFIER.source(), formals().optional(),
				statementParser.many(),
				TerminalParser.term(Keyword.END.toString()));
	}

	/**
	 * Create a Parser of the Member based on a Parser of Mapping.
	 * @param mappingParser A Parser of Mapping (This is a class of our ParseTree model). 
	 * @return A Parser of Member (This is a class of our ParseTree model). 
	 */
	private static Parser<Member> siteDef(Parser<Mapping> mappingParser) {
		return Mapper.<Member> curry(SiteDef.class).sequence(
				TerminalParser.term(Keyword.SITE.toString()),
				mappingParser.sepBy(TerminalParser.term(Operator.SEMI_COLON
						.toString())),
				TerminalParser.term(Keyword.END.toString()));
	}

	/**
	 * The parser which detects a QualifiedName. 
	 */
	private static final Parser<QualifiedName> QUALIFIED_NAME = Mapper.curry(
			QualifiedName.class).sequence(
			Terminals.Identifier.PARSER.sepBy1(TerminalParser.term(Operator.DOT
					.toString())));

	/**
	 * The parser which detects the Module.
	 */
	private static final Parser<QualifiedName> MODULE = Parsers.sequence(
			TerminalParser.term(Keyword.MODULE.toString()), QUALIFIED_NAME);

	/**
	 * The parser which detects the import section. 
	 */
	private static final Parser<QualifiedName> importParser = Parsers.sequence(
			TerminalParser.term(Keyword.IMPORT.toString()), QUALIFIED_NAME);
}
