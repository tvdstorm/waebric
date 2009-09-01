package waebric.analysis.java.runners;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;

import waebric.ast.Cons;
import waebric.ast.TreeWalker;
import waebric.beaver.UnicodeEscapes;
import waebric.beaver.WaebricLexer;
import waebric.beaver.WaebricParser;

public class BeaverRunner implements IParserRunner {

	public String getName() {
		return "beaver";
	}

	public String parse(File filename) {
		try {
			WaebricLexer lexer = new WaebricLexer(new UnicodeEscapes(new FileReader(filename)));
	        WaebricParser parser = new WaebricParser();
			Cons cons = (Cons)parser.parse(lexer);
			if (cons == null) {
				return null;
			}
			ByteArrayOutputStream bytes = new ByteArrayOutputStream();
			PrintStream my = new PrintStream(bytes);
			TreeWalker printer = new TreeWalker(my);
			cons.accept(printer);
			String r = new String(bytes.toByteArray());
			//System.out.println(r);
			return r;
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		} 
		catch (Exception e) {
			return null;
		}
		return null;
	}

}
