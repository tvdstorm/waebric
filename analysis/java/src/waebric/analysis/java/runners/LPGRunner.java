package waebric.analysis.java.runners;

import java.io.File;

import waebricc.Option;
import waebricc.PrettyPrintVisitor;
import waebricc.WaebricLexer;
import waebricc.WaebricParser;
import waebricc.WaebricAst.Ast;

public class LPGRunner implements IParserRunner {

	public String getName() {
		return "lpg";
	}

	public String parse(File filename) {
		Option option;
		WaebricLexer Expr_lexer;
		WaebricParser Expr_parser;

		String args[] = { filename.toString() };
		Ast ast;

		try
		{
			option = new Option(args);
			Expr_lexer = new WaebricLexer(option); // Create the lexer
			Expr_parser = new WaebricParser(Expr_lexer);	// Create the parser
			Expr_lexer.lexer(Expr_parser); // Lex the stream to produce the token stream
			ast = Expr_parser.parser(); // Parse the token stream to produce an AST
			if (ast == null) 
				return null;
			else 
			{
				ast.accept(new PrettyPrintVisitor(Expr_parser));
				return ast.toString();
			}

		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

}
