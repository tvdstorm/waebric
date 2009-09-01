package waebric.analysis.java.runners;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import waebric.javacc.ParseException;
import waebric.javacc.WaebricParser;

public class JavaCCRunner implements IParserRunner {
	private WaebricParser parser = new WaebricParser((Reader)null);
	
	public String parse(File file)  {
		try {
			FileReader reader = new FileReader(file);
			WaebricParser.ReInit(reader);
			try {
				String ast = parser.buildAST(parser.Modules(), 0);
				System.err.println(ast);
				return ast;
			} catch (ParseException e) {
				//e.printStackTrace();
				return null;
			}
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public String getName() {
		return "javacc";
	}


}
