package waebric.analysis.java.runners;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

import org.sablecc.grammar.waebric.lexer.Lexer;
import org.sablecc.grammar.waebric.lexer.LexerException;
import org.sablecc.grammar.waebric.node.Start;
import org.sablecc.grammar.waebric.parser.Parser;
import org.sablecc.grammar.waebric.parser.ParserException;
import org.waebric.adapter.TreeWalker;

public class SableCCRunner implements IParserRunner {

	public String getName() {
		return "sablecc";
	}

	public String parse(File filename) {
		BufferedReader fileReader;
		try {
			fileReader = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			return null;
		}
		Lexer lexer = new Lexer(new PushbackReader(fileReader, 1024));
		Parser parser = new Parser(lexer);
		Start start;
		try {
			start = parser.parse();
		} catch (ParserException e) {
			return null;
		} catch (LexerException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
    	TreeWalker walker = new TreeWalker();
    	start.apply(walker);
    	return walker.getAstTree();
	}

}
