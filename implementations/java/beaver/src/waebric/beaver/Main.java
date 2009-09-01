package waebric.beaver;


import java.io.FileReader;
import java.io.IOException;

import waebric.ast.Cons;
import waebric.ast.TreeWalker;
import beaver.Parser;

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
