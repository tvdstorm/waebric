package com.uva.se.wparse.parser;


import java.util.List;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.Terminals;
import org.codehaus.jparsec.functors.Map;
import org.codehaus.jparsec.misc.Mapper;

import com.uva.se.wparse.model.Declaration;
import com.uva.se.wparse.model.Expression;
import com.uva.se.wparse.model.MappingDef;
import com.uva.se.wparse.model.Member;
import com.uva.se.wparse.model.MethodDef;
import com.uva.se.wparse.model.ModuleBody;
import com.uva.se.wparse.model.ModuleDef;
import com.uva.se.wparse.model.QualifiedName;
import com.uva.se.wparse.model.SiteDef;

/**
 * Parses class, interface, enum, annotation declarations.
 * 
 * @author Ben Yu
 */
public final class DeclarationParser {
	
  static Parser<ModuleBody> body(Parser<Member> member) {
    //Parser<Member> empty = term(";").retn(null);
	  //return Mapper.curry(ModuleBody.class).or
	  
    return Mapper.curry(ModuleBody.class).sequence(
        member.many().map(new Map<List<Member>, List<Member>>() {
          public List<Member> map(List<Member> from) {
            //removeNulls(from);
            return from;
          }
        }));
  }

//  static void removeNulls(List<?> list) {
//    for (Iterator<?> it = list.iterator(); it.hasNext();) {
//      if (it.next() == null) {
//        it.remove();
//      }
//    }
//  }
//  
//  static Parser<Member> fieldDef(Parser<Expression> initializer) {
//    return Mapper.<Member>curry(FieldDef.class).sequence(
//        modifier(initializer).many(), TYPE_LITERAL, Terminals.Identifier.PARSER,
//        term("=").next(ExpressionParser.arrayInitializerOrRegularExpression(initializer))
//            .optional(),
//        term(";"));
//  }
//  
//  static final Parser<TypeParameterDef> TYPE_PARAMETER =
//      Mapper.curry(TypeParameterDef.class).sequence(
//          Terminals.Identifier.PARSER, term("extends").next(TypeLiteralParser.TYPE_LITERAL)
//              .optional());
//  
//  static final Parser<List<TypeParameterDef>> TYPE_PARAMETERS =
//      between(term("<"), TYPE_PARAMETER.sepBy1(term(",")), term(">"));
//  
//  static Parser<Member> constructorDef(Parser<Modifier> mod, Parser<Statement> stmt) {
//    return Mapper.<Member>curry(ConstructorDef.class).sequence(
//        mod.many(), Terminals.Identifier.PARSER,
//        term("("), StatementParser.parameter(mod).sepBy(term(",")), term(")"),
//        term("throws").next(ELEMENT_TYPE_LITERAL.sepBy1(term(","))).optional(),
//        StatementParser.blockStatement(stmt));
//  }
  
  static Parser<Member> methodDef( /*Parser<Statement> stmt */) {
    return Mapper.<Member>curry(MethodDef.class).sequence(
        TerminalParser.term("def"), Terminals.Identifier.PARSER,TerminalParser.term("("), Terminals.Identifier.PARSER.optional(),
        Parsers.sequence(TerminalParser.term(","), Terminals.Identifier.PARSER).many() ,TerminalParser.term(")"),
        //add parameter hier nog
        //Parsers.or( /*StatementParser.blockStatement(stmt),*/  TerminalParser.term(";").retn(null)),
        TerminalParser.term("end"));
  }
  
  
  static final Parser<MappingDef> PATH =
      Parsers.<MappingDef>tokenType(MappingDef.class, "Mapping element");
  
  
//  static Parser<MappingDef> mappingDef() {
//	    return Mapper.<MappingDef>curry(MappingDef.class).sequence(
//	        Terminals.Identifier.PARSER, Parsers.sequence(TerminalParser.term("/"), Terminals.Identifier.PARSER.optional() ).many()  );
//
//	  }
  
  static Parser<Member> siteDef( /*Parser<Statement> stmt */) {
	    return Mapper.<Member>curry(SiteDef.class).sequence(
	        TerminalParser.term("site"), Terminals.Identifier.PARSER,
	        PATH.many(),
	        //mappingDef(),
	        TerminalParser.term("end"));
	  }
  
  
  
//  
//  static Parser<Member> initializerDef(Parser<Statement> stmt) {
//    return Mapper.<Member>curry(ClassInitializerDef.class).sequence(
//        term("static").succeeds(), StatementParser.blockStatement(stmt));
//  }
//  
//  static Parser<Member> nestedDef(Parser<Declaration> dec) {
//    return Mapper.<Member>curry(NestedDef.class).sequence(dec);
//  }
//  
//  static Parser<Declaration> classDef(Parser<Modifier> mod, Parser<Member> member) {
//    return curry(ClassDef.class).sequence(
//        mod.many(), term("class"), Terminals.Identifier.PARSER, TYPE_PARAMETERS.optional(),
//        term("extends").next(ELEMENT_TYPE_LITERAL).optional(),
//        term("implements").next(ELEMENT_TYPE_LITERAL.sepBy1(term(","))).optional(),
//        body(member));
//  }
//  
//  static Parser<Declaration> interfaceDef(Parser<Modifier> mod, Parser<Member> member) {
//    return curry(InterfaceDef.class).sequence(
//        mod.many(), term("interface"), Terminals.Identifier.PARSER, TYPE_PARAMETERS.optional(),
//        term("extends").next(ELEMENT_TYPE_LITERAL.sepBy1(term(","))).optional(),
//        body(member));
//  }
//  
//  static Parser<Declaration> annotationDef(Parser<Modifier> mod, Parser<Member> member) {
//    return curry(AnnotationDef.class).sequence(
//        mod.many(), phrase("@ interface"), Terminals.Identifier.PARSER, body(member));
//  }
//  
//  static Parser<Declaration> enumDef(Parser<Expression> expr, Parser<Member> member) {
//    Parser<EnumDef.Value> enumValue = Mapper.curry(EnumDef.Value.class).sequence(
//        Terminals.Identifier.PARSER, between(term("("), expr.sepBy(term(",")), term(")"))
//            .optional(),
//        between(term("{"), member.many(), term("}")).optional());
//    return curry(EnumDef.class).sequence(
//        modifier(expr).many(), term("enum"), Terminals.Identifier.PARSER,
//        term("implements").next(ELEMENT_TYPE_LITERAL.sepBy1(term(","))).optional(),
//        term("{"), enumValue.sepBy(term(",")),term(";").next(member.many()).optional(), term("}"));
//  }
//  
  static final Parser<QualifiedName> QUALIFIED_NAME =
      Mapper.curry(QualifiedName.class).sequence(Terminals.Identifier.PARSER.sepBy1(TerminalParser.term(".")));
  
//  static final Parser<Import> IMPORT = Mapper.curry(Import.class).sequence(
//      term("import"), term("static").succeeds(),
//      QUALIFIED_NAME, phrase(". *").succeeds(), term(";"));
//  
//  static final Parser<QualifiedName> PACKAGE = between(term("package"), QUALIFIED_NAME, term(";"));
  
  static final Parser<QualifiedName> MODULE = Parsers.sequence(TerminalParser.term("module"), QUALIFIED_NAME);
  
  public static Parser<ModuleDef> module() {
    Parser.Reference<Member> memberRef = Parser.newReference();
    Parser<Expression> expr = ExpressionParser.expression(body(memberRef.lazy()));
   // Parser<Statement> stmt = StatementParser.statement(expr); //deze nog maken
    
    
    //Parser<Modifier> mod = modifier(expr);
 //   Parser.Reference<Declaration> decRef = Parser.newReference();
   // Parser<Member> member = Parsers.or(
     //   methodDef() /*mod, expr, stmt)*/
        //initializerDef(stmt), nestedDef(decRef.lazy())
   //     );
//    memberRef.set(member);
//    Parser<Declaration> declaration = Parsers.or(
//        classDef(mod, member), interfaceDef(mod, member),
//        enumDef(expr, member), annotationDef(mod, member));
//    decRef.set(declaration);
    return Mapper.curry(ModuleDef.class).sequence(
    		MODULE, Parsers.or(methodDef(), siteDef(), expr).many() );
  }
  
  /** Parses any Java source.  */
  public static ModuleDef parse(String source) {
    return TerminalParser.parse(module(), source);
  }
  
//  /** Parses source code read from {@code url}. */
//  public static Program parse(URL url) throws IOException {
//    InputStream in = url.openStream();
//    try {
//      return TerminalParser.parse(
//          program(), new InputStreamReader(in, Charset.forName("UTF-8")), url.toString());
//    } finally {
//      in.close();
//    }
//  }
  
  private static Mapper<Declaration> curry(
      Class<? extends Declaration> clazz, Object... curryArgs) {
    return Mapper.curry(clazz, curryArgs);
  }
  
//////////////test lines	  
  
  private final static String SOURCE = "module testModule def myMethod( testp1, testp2, testp3) end site mySite p1/p2/p3 end \"test\" && test2 ";
	
	public void doParse(){
		
		System.out.println("Start parser");
		
		ModuleDef md = parse(SOURCE);
		System.out.println("print objects: " + md.toString());
		System.out.println("End parser");
	}
	
	
	public static void main(String[] args) {
		DeclarationParser dp = new DeclarationParser();
		dp.doParse();

	}
	
  
  
}
