/*
 * File			: ExpressionParser.java
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



import org.codehaus.jparsec.OperatorTable;
import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.Terminals;
import org.codehaus.jparsec.Token;
import org.codehaus.jparsec.TokenMap;
import org.codehaus.jparsec.Tokens.Fragment;
import org.codehaus.jparsec.functors.Binary;
import org.codehaus.jparsec.misc.Mapper;

import com.uva.se.wparse.model.declaration.ModuleBody;
import com.uva.se.wparse.model.expression.BinaryExpression;
import com.uva.se.wparse.model.expression.BlockExpression;
import com.uva.se.wparse.model.expression.BlockKeyValueExpression;
import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.expression.IdentDotExpression;
import com.uva.se.wparse.model.expression.Identifier;
import com.uva.se.wparse.model.expression.KeyValuePair;
import com.uva.se.wparse.model.expression.NaturalExpression;
import com.uva.se.wparse.model.expression.Operator;
import com.uva.se.wparse.model.expression.StringLiteral;
import com.uva.se.wparse.model.expression.SymbolConstant;
import com.uva.se.wparse.model.statement.AssignmentNormal;

public class ExpressionParser {

	
	 static final Parser LITERAL_TEXT =
		 Parsers.sequence( //TerminalParser.term("\""),
	Parsers.token(
			 new TokenMap<String>(){

				public String map(Token token) {					
					if( ! token.value().toString().equals("\"")){ 
					//	Fragment fragment = (Fragment) token.value();
						int prefixIndex = token.index() - 1;
						if( prefixIndex > 0 ){
							//get the token to the left of the current token
							char prefixChar = TerminalParser.getSource().charAt(prefixIndex);
							
							if(prefixChar == ' '){
								//is token is prefixed with space char, add space char to the return value
								return " " + token.value().toString();
							}
							//return null;
						}
						//fragment.
						return token.value().toString();
					}
					else{
						return null;
					}
				
				
				
				}
				 
			 }
			
			)); 
	
	
	 
	 static final Parser TEXT2 =
		 Parsers.sequence( //TerminalParser.term("\""),
	Parsers.token(
			 new TokenMap<String>(){

				public String map(Token token) {					
					if( !token.value().toString().equals("\"") &&
						!token.value().toString().equals("<") 	
					){ 
					
						int prefixIndex = token.index() - 1;
						if( prefixIndex > 0 ){
							//get the token to the left of the current token
							char prefixChar = TerminalParser.getSource().charAt(prefixIndex);
							
							if(prefixChar == ' '){
								//is token is prefixed with space char, add space char to the return value
								return " " + token.value().toString();
							}
							//return null;
						}
						//fragment.
						return token.value().toString();
					}
					else{
						return null;
					}
				
				
				
				}
				 
			 }
			
			)); 
	 
	  static final Parser<Expression> IDENTIFIER =
	      curry(Identifier.class).sequence(Terminals.Identifier.PARSER);
	  
	  //TODO: de symbol chars nog aanpassen naar volgens asf+sdf, nu identifier voor gebruikt.
	  static final Parser<Expression> symbolConstant =
	      curry(SymbolConstant.class).sequence(TerminalParser.term("'"), Terminals.Identifier.PARSER);
	
	
	  static final Parser<Expression> STRING_LITERAL = 
	    //  curry(StringLiteral.class).sequence(Terminals.StringLiteral.PARSER);
		  curry(StringLiteral.class).sequence(TerminalParser.term("\""), LITERAL_TEXT.many() , TerminalParser.term("\""));
	  
	  private static Parser<Expression> assignment(Parser<Expression> expr) {
		    return curry(AssignmentNormal.class).sequence(Terminals.Identifier.PARSER, TerminalParser.term("="), expr, TerminalParser.term(";"));
	  }
	  
		static Parser<Expression> blockExpression(Parser<Expression> expr) {
			return curry(BlockExpression.class).sequence(
					TerminalParser.term("["), expr.sepBy(TerminalParser.term(",")),
					TerminalParser.term("]"));
		}
		
		
		static Parser<Expression> blockKeyValueExpression(Parser<Expression> expr) {
			return curry(BlockKeyValueExpression.class).sequence(
					TerminalParser.term("{"), keyValuePairExpression(expr).sepBy(TerminalParser.term(",")),
					TerminalParser.term("}"));
		}
		
		
		
		
		static Parser<Expression> keyValuePairExpression(Parser<Expression> expr) {
			return curry(KeyValuePair.class).sequence(Terminals.Identifier.PARSER,
					TerminalParser.term(":"), expr);
		}
		
		static Parser<Expression> identExpression(Parser<Expression> expr) {
			return curry(IdentDotExpression.class).sequence(expr,TerminalParser.term("."),Terminals.Identifier.PARSER );
		}
		
		static Parser<Expression> numberExpression() {
			return curry(NaturalExpression.class).sequence(Terminals.IntegerLiteral.PARSER);
		}

		
		

	  
	  //de andere expressions nog toevoegen
	  static final Parser<Expression> ATOM = Parsers.or(
	        STRING_LITERAL, IDENTIFIER, symbolConstant, numberExpression());
	  
	  
	  
	  public static Parser<Expression> expression(Parser<Expression> atom, Parser<ModuleBody> moduleBody) {
	    Parser.Reference<Expression> ref = Parser.newReference();
	    Parser<Expression> lazy = ref.lazy();
	    atom = Parsers.or(keyValuePairExpression(lazy), blockExpression(lazy), blockKeyValueExpression(lazy),atom);
	    Parser<Expression> parser = new OperatorTable<Expression>()
	        .infixl(binary(Operator.AND), 20)
	        .infixl(binary(Operator.OR), 10)
	        .infixl(binary(Operator.DOT), 10)
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
	  
  
	  static Mapper<Expression> curry(Class<? extends Expression> clazz, Object... args) {
		    return Mapper.curry(clazz, args);
	  }
	  
	  
	
}
