package waebric.analysis.java.runners;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import java_cup.runtime.ComplexSymbolFactory;
import waebric.Lexer;
import waebric.Parser;
import waebric.PrintAST;
import waebric.node.SyntaxNode;

public class JavaCupRunner implements IParserRunner {

	public String getName() {
		return "javacup";
	}

	private static class PrintAST2 extends PrintAST {
		private Writer out;

		public PrintAST2(Writer writer) {
			this.out = writer;
		}
		
		@Override
		protected void cout(Integer i) {
			try {
				out.write(i.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Override
		protected void cout(String s) {
			try {
				out.write(s);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public String parse(File filename) {
		Lexer scanner = null;
		try {
			ComplexSymbolFactory f = new ComplexSymbolFactory();
			scanner = new Lexer(f, new java.io.FileInputStream(filename));
		} catch (java.io.FileNotFoundException e) {
			throw new RuntimeException(e);
		}			
		
		try {
			Parser p = new Parser(scanner);
			SyntaxNode result = (SyntaxNode) p.parse().value;
			
			StringWriter writer = new StringWriter();
			PrintAST past = new PrintAST2(writer);
			result.accept(past);
			return writer.toString(); 
		} catch (java.io.IOException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
