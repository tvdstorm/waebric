package waebric;


import java.io.IOException;
import java.io.StringReader;
import java.io.FileReader;

import beaver.Symbol;
import beaver.Scanner;
import beaver.Parser;

import waebric.ast.*;

class Main
{
	static public void main(String[] args) throws IOException, Parser.Exception
	{
		WaebricLexer lexer = new WaebricLexer(new UnicodeEscapes(new FileReader(args[0])));
        WaebricParser parser = new WaebricParser();
		Cons cons = (Cons)parser.parse(lexer);
		TreeWalker printer = new TreeWalker();
		cons.accept(printer);
	}
}
