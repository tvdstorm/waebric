package org.cwi.waebric;
import java.util.ArrayList;
	
public class ParserPreamble {
	/**
	 * Parsed modules
	 */
	private ArrayList<String> modules = new ArrayList<String>();

	public WaebricParser(TokenStream input, ArrayList<String> modules) {
		super(input);
		this.modules = modules;
	}

	/**
	 * Parse file on specified path.
	 * @return AST
	 */
	private CommonTree parseFile(String path) throws RecognitionException {
		try {
			CharStream is = new ANTLRFileStream(path);
			WaebricLexer lexer = new WaebricLexer(is);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
      			WaebricParser parser = new WaebricParser(tokens, modules);
      			return (CommonTree) parser.module().getTree();
      		} catch(java.io.IOException e) { return new CommonTree(); }
	}
}
