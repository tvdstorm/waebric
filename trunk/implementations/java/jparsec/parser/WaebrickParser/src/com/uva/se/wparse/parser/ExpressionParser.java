package com.uva.se.wparse.parser;



import org.codehaus.jparsec.OperatorTable;
import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.Terminals;
import org.codehaus.jparsec.functors.Binary;
import org.codehaus.jparsec.misc.Mapper;

import com.uva.se.wparse.model.BinaryExpression;
import com.uva.se.wparse.model.Expression;
import com.uva.se.wparse.model.Identifier;
import com.uva.se.wparse.model.MappingDef;
import com.uva.se.wparse.model.ModuleBody;
import com.uva.se.wparse.model.Operator;
import com.uva.se.wparse.model.StringLiteral;

public class ExpressionParser {

	
	  static final Parser<Expression> IDENTIFIER =
	      curry(Identifier.class).sequence(Terminals.Identifier.PARSER);
	
	
	  static final Parser<Expression> STRING_LITERAL = 
	      curry(StringLiteral.class).sequence(Terminals.StringLiteral.PARSER);
	  
	  

	  
	  
	  //de andere expressions nog toevoegen
	  static final Parser<Expression> ATOM = Parsers.or(
	        STRING_LITERAL, IDENTIFIER);
	  
	  
	  
	  static Parser<Expression> expression(Parser<Expression> atom, Parser<ModuleBody> moduleBody) {
	    Parser.Reference<Expression> ref = Parser.newReference();
	    //Parser<Expression> lazy = ref.lazy();
	    //atom = Parsers.or(//castOrExpression(lazy), simpleNewExpression(lazy, classBody),
	                //newArrayWithExplicitLength(lazy), newArrayWithoutExplicitLength(lazy),
	                //simpleMethodCall(lazy), atom);
	    Parser<Expression> parser = new OperatorTable<Expression>()
	        .infixl(binary(Operator.AND), 20)
	        .infixl(binary(Operator.OR), 10)
	        .build(atom);
	    ref.set(parser);
	    return parser;
	  }
	  
	  public static Parser<Expression> expression(Parser<ModuleBody> moduleBody) {
		    return expression(ATOM, moduleBody);
		  }
	  
	  private static Parser<Binary<Expression>> binary(Operator op) {
		    return TerminalParser.term(op.toString()).next(curry(BinaryExpression.class, op).binary());
	}
	  
//	  private static Parser<Binary<Expression>> binary(Operator op) {
//		    return term(op.toString()).next(curry(BinaryExpression.class, op).binary());
//		  }

	  
	  
	  static Mapper<Expression> curry(Class<? extends Expression> clazz, Object... args) {
		    return Mapper.curry(clazz, args);
	  }
	  
	  
	  
//////////////test lines	  
	  

  private final static String SOURCE = " \"test\" && test2 ";
	
	public void doParse(){
		
		System.out.println("Start parser");

		Parser<Expression> expParser = expression(null);
		TerminalParser.parse(expParser, SOURCE);
		
		System.out.println("End parser");
	}
	
	
	public static void main(String[] args) {
		ExpressionParser ep = new ExpressionParser();
		ep.doParse();

	}
	
}
