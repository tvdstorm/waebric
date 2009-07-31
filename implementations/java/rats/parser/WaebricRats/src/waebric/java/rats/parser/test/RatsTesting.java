package waebric.java.rats.parser.test;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Assert;

import waebric.java.rats.parser.Waebric;
import xtc.parser.ParseError;
import xtc.parser.Result;
import xtc.tree.Node;

public class RatsTesting {
	private boolean logging = true;
	
	public void setLogging(boolean flag) {
		this.logging = flag;
	}
	
	private abstract class Parser {
		protected final Waebric parser;
		private String symbol;
		private String source;

		public Parser(String symbol, String source, String fileName) {
			this.symbol = symbol;
			this.source = source;
			parser = new Waebric(new StringReader(source), fileName);	
		}
		
		public abstract Result parse() throws IOException;
		
		public void run() {
			try {
				Result result = parse(); 
				if (result instanceof ParseError) {
					int pos = result.index;
					String ch = "EOF";
					if (pos < source.length()) {
						ch = "'" + Character.toString(source.charAt(pos)) + "'";
					}
					log(result.parseError().msg + " at " + pos + ": " + ch);
					Assert.fail();
				}
				else {
					log(((Node)result.semanticValue()).get(0));
					Assert.assertTrue(parser.isEOF(result.index));
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		private void log(Object object) {
			if (logging) {
				System.err.println(symbol + " " + source + " ==> " + object);
			}
		}
	}


	
	
	public void testExp(String source) {
		new Parser("Expression", source, this.getClass().getName()) {
			public Result parse() throws IOException {
				return parser.pTestExpression(0);
			}
		}.run();
	}
	
	
	public void testStat(String source) {
		new Parser("Statement", source, this.getClass().getName()) {
			public Result parse() throws IOException {
				return parser.pTestStatement(0);
			}
		}.run();
	}

	public void testModule(String source) {
		new Parser("Module", source, this.getClass().getName()) {
			public Result parse() throws IOException {
				return parser.pModule(0);
			}
		}.run();
	}
	
	public void testSite(String source) {
		new Parser("Site", source, this.getClass().getName()) {
			public Result parse() throws IOException {
				return parser.pTestSite(0);
			}
		}.run();
	}
	
	public void testFunction(String source) {
		new Parser("Function", source, this.getClass().getName()) {
			public Result parse() throws IOException {
				return parser.pTestFunction(0);
			}
		}.run();
	}

}
