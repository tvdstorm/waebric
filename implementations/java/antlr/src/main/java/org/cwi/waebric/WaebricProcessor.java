package org.cwi.waebric;

import org.antlr.runtime.*;

/**
 * Waebric compiler
 * @author Jeroen van Schagen
 * @date 26-06-2009
 */
public class WaebricProcessor {

	/**
	 * Convert program in AST.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
	        ANTLRInputStream input = new ANTLRInputStream(System.in);
	        WaebricLexer lexer = new WaebricLexer(input);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        WaebricParser parser = new WaebricParser(tokens);
	        System.out.println(parser.module().result);
	}
		
}