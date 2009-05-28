package org.cwi.waebric.parser;

import java.util.List;

import org.cwi.waebric.WaebricSymbol;
import org.cwi.waebric.parser.ast.StringLiteral;
import org.cwi.waebric.parser.ast.basic.IdCon;
import org.cwi.waebric.parser.ast.basic.NatCon;
import org.cwi.waebric.parser.ast.expressions.Expression;
import org.cwi.waebric.parser.ast.expressions.KeyValuePair;
import org.cwi.waebric.parser.ast.expressions.SymbolCon;
import org.cwi.waebric.parser.ast.expressions.Var;
import org.cwi.waebric.parser.exception.MissingTokenException;
import org.cwi.waebric.parser.exception.ParserException;
import org.cwi.waebric.scanner.token.Token;
import org.cwi.waebric.scanner.token.TokenIterator;
import org.cwi.waebric.scanner.token.TokenSort;

/**
 * module languages/waebric/syntax/Expressions
 * @author schagen
 *
 */
class ExpressionParser extends AbstractParser {

	public ExpressionParser(TokenIterator tokens, List<ParserException> exceptions) {
		super(tokens, exceptions);
	}
	
	public Expression parseExpression(String name, String syntax) {
		if(! tokens.hasNext()) {
			exceptions.add(new MissingTokenException(name, syntax));
			return null;
		}
		
		Expression expression = null;
		Token peek = tokens.peek(1); // Determine expression type based on look-ahead
		Class<? extends Expression> type = getExpressionClass(peek);
		if(type == Expression.VarExpression.class) {
			expression = new Expression.VarExpression();
			parse((Expression.VarExpression) expression);
		} else if(type == Expression.NatExpression.class) {
			expression = new Expression.NatExpression();
			parse((Expression.NatExpression) expression);
		} else if(type == Expression.ListExpression.class) {
			expression = new Expression.ListExpression();
			parse((Expression.ListExpression) expression);
		} else if(type == Expression.IdConExpression.class) {
			expression = new Expression.IdConExpression();
			parse((Expression.IdConExpression) expression);
		} else if(type == Expression.RecordExpression.class) {
			expression = new Expression.RecordExpression();
			parse((Expression.RecordExpression) expression);
		} else if(type == Expression.SymbolExpression.class) {
			expression = new Expression.SymbolExpression();
			parse((Expression.SymbolExpression) expression);
		} else if(type == Expression.TextExpression.class) {
			expression = new Expression.TextExpression();
			parse((Expression.TextExpression) expression);
		}
		
		return expression;
	}
	
	/**
	 * @see Expression.VarExpression
	 * @param expression
	 */
	public void parse(Expression.VarExpression expression) {
		Var var = parseVar("var expression", "expression");
		expression.setVar(var);
	}
	
	/**
	 * 
	 * @param expression
	 */
	public void parse(Expression.NatExpression expression) {
		if(next("natural expression", "natural number", TokenSort.NUMBER)) {
			NatCon natural = new NatCon(current.getLexeme().toString());
			expression.setNatural(natural);
		}
	}
	
	/**
	 * 
	 * @param expression
	 */
	public void parse(Expression.TextExpression expression) {
		if(next("text expression", "\"text\"", TokenSort.TEXT)) {
			expression.setText(new StringLiteral(current.getLexeme().toString()));
		}
	}
	
	/**
	 * 
	 * @param expression
	 */
	public void parse(Expression.SymbolExpression expression) {
		SymbolCon symbol = parseSymbolCon();
		expression.setSymbol(symbol);
	}
	
	/**
	 * 
	 * @param expression
	 */
	public void parse(Expression.IdConExpression expression) {
		// Parse sub expression
		Expression subExpression = parseExpression("expression", "expression \".\" identifier");
		expression.setExpression(subExpression);

		// Parse period separator
		next("period", "expression \".\" identifier", WaebricSymbol.PERIOD);

		// Parse identifier
		if(next("period", "expression \".\" identifier", TokenSort.IDENTIFIER)) {
			IdCon identifier = new IdCon(current.getLexeme().toString());
			expression.setIdentifier(identifier); // Store identifier
		}
	}
	
	/**
	 * 
	 * @param expression
	 */
	public void parse(Expression.ListExpression expression) {
		next("list opening", "\"[\" expressions", WaebricSymbol.LBRACKET);
		
		while(tokens.hasNext()) {
			if(tokens.peek(1).getLexeme().equals(WaebricSymbol.RBRACKET)) {
				break; // End of expression collection found, break while
			}
			
			// Parse sub expression
			Expression subExpression = parseExpression("expression", "\"[\" expression \"]\"");
			expression.addExpression(subExpression);
			
			// While not end of expressions, comma separator is expected
			if(tokens.hasNext() && ! tokens.peek(1).getLexeme().equals(WaebricSymbol.RBRACKET)) {
				next("list element separator", "expression \",\" expression", WaebricSymbol.COMMA);
			}
		}
		
		next("list closure", "expressions \"]\"", WaebricSymbol.RBRACKET);
	}
	
	/**
	 * 
	 * @param expression
	 */
	public void parse(Expression.RecordExpression expression) {
		next("record opening", "\"{\" pairs", WaebricSymbol.LCBRACKET);
		
		while(tokens.hasNext()) {
			if(tokens.peek(1).getLexeme().equals(WaebricSymbol.RCBRACKET)) {
				break; // End of expression collection found, break while
			}
			
			// Parse key value pair
			KeyValuePair pair = new KeyValuePair();
			parse(pair);
			expression.addKeyValuePair(pair);
			
			// While not end of pairs, comma separator is expected
			if(tokens.hasNext() && ! tokens.peek(1).getLexeme().equals(WaebricSymbol.RCBRACKET)) {
				next("record element separator", "key value pair \",\" key value pair", WaebricSymbol.COMMA);
			}
		}
		
		next("record closure", "pairs \"}\"", WaebricSymbol.RCBRACKET);
	}
	
	/**
	 * 
	 * @param pair
	 */
	private void parse(KeyValuePair pair) {
		// Parse identifier
		if(next("identifier", "identifier \":\" expression", TokenSort.IDENTIFIER)) {
			IdCon identifier = new IdCon(current.getLexeme().toString());
			pair.setIdentifier(identifier);
		}
		
		// Parse separator
		next("colon", "identifier \":\" expression", WaebricSymbol.COLON);
		
		// Parse expression
		Expression expression = parseExpression("expression", "identifier \":\" expression");
		pair.setExpression(expression);
	}

	/**
	 * @see SymbolCon
	 * @param symbol
	 */
	private SymbolCon parseSymbolCon() {
		SymbolCon symbol = new SymbolCon();
		
		next("symbol opening quote", "\"'\" characters", WaebricSymbol.SQUOTE);
		
		// TODO: ~[0-31\ \t\n\r\;\,\127-255]
		
		return symbol;
	}

	/**
	 * @see Var
	 * @param var
	 */
	public Var parseVar(String name, String syntax) {
		if(next(name, syntax,TokenSort.IDENTIFIER)) {
			Var var = new Var();
			var.setIdentifier(new IdCon(current.getLexeme().toString()));
			return var;
		}
		
		return null;
	}
	
	/**
	 * Stored in separate method as both mark-up and statement use
	 * expressions in their syntax.
	 * @param token
	 * @return
	 */
	public static Class<? extends Expression> getExpressionClass(Token token) {
		if(token.getLexeme().equals(WaebricSymbol.LBRACKET)) {
			// Expression collections start with a [
			return Expression.ListExpression.class;
		} else if(token.getLexeme().equals(WaebricSymbol.LCBRACKET)) {
			// Key value pair collections start with a {
			return Expression.RecordExpression.class;
		} else if(token.getLexeme().equals(WaebricSymbol.SQUOTE)) {
			// Symbol cons start with a '
			return Expression.SymbolExpression.class;
		} else if(token.getSort().equals(TokenSort.NUMBER)) {
			// Natural expressions consist of a natural
			return Expression.NatExpression.class;
		} else if(token.getSort().equals(TokenSort.TEXT)) {
			// Textual expressions consist of a text
			return Expression.TextExpression.class;
		} else if(token.getSort().equals(TokenSort.IDENTIFIER)) {
			// Variable expressions consist of variable
			return Expression.VarExpression.class;
		} else { // Only remaining alternative: Expression "." IdCon -> Expression
			return Expression.IdConExpression.class;
		}
	}

}