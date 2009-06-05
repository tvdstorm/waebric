package org.cwi.waebric.parser;

import java.util.List;

import org.cwi.waebric.WaebricKeyword;
import org.cwi.waebric.WaebricSymbol;
import org.cwi.waebric.parser.ast.basic.IdCon;
import org.cwi.waebric.parser.ast.module.FunctionDef;
import org.cwi.waebric.parser.ast.statement.Formals;
import org.cwi.waebric.parser.ast.statement.Statement;
import org.cwi.waebric.parser.exception.ParserException;
import org.cwi.waebric.scanner.token.WaebricTokenIterator;
import org.cwi.waebric.scanner.token.WaebricTokenSort;

/**
 * Function parser
 * 
 * module languages/waebric/syntax/Functions
 * 
 * @author Jeroen van Schagen
 * @date 27-05-2009
 */
class FunctionParser extends AbstractParser {

	private final StatementParser statementParser;
	
	public FunctionParser(WaebricTokenIterator tokens, List<ParserException> exceptions) {
		super(tokens, exceptions);
		
		// Construct sub parser
		statementParser = new StatementParser(tokens, exceptions);
	}

	/**
	 * @see FunctionDef
	 * @param def
	 */
	public FunctionDef parseFunctionDef() {
		FunctionDef def = new FunctionDef();
		
		// Parse function identifier
		if(next("function identifier", "identifier", WaebricTokenSort.IDCON)) {
			IdCon identifier = new IdCon(current.getLexeme().toString());
			def.setIdentifier(identifier);
		} else {
			return null; // Invalid function syntax, quit parsing
		}
		
		// Parse formals (optional)
		if(tokens.hasNext() && tokens.peek(1).getLexeme().equals(WaebricSymbol.LPARANTHESIS)) {
			def.setFormals(parseFormals());
		}
		
		// Parse statements
		while(tokens.hasNext() && ! tokens.peek(1).getLexeme().equals(WaebricKeyword.END)) {
			Statement subStatement = parseStatement(def.getFormals());
			def.addStatement(subStatement);
		}
		
		// Parse function closure
		if(! next("function end", "end", WaebricKeyword.END)) {
			return null; // Invalid function syntax, return empty node
		}
		
		return def;
	}
	
	/**
	 * 
	 * @param formals
	 */
	public Formals parseFormals() {
		return statementParser.parseFormals();
	}
	
	/**
	 * 
	 * @param statement
	 */
	public Statement parseStatement(Formals formals) {
		return statementParser.parseStatement(formals);
	}

}