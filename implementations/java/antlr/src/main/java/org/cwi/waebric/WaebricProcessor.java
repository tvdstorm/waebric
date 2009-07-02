package org.cwi.waebric;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;

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
			CharStream is;
			if(args.length == 1) {
				is = new ANTLRFileStream(args[0]);
			} else {
				is = new ANTLRInputStream(System.in);
			}

	        long curr = System.currentTimeMillis();
	        WaebricLexer lexer = new WaebricLexer(is);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        long scan_time = System.currentTimeMillis() - curr;
	        System.out.println("Scanned in " + scan_time + "ms.");
	        
	        WaebricParser parser = new WaebricParser(tokens);
	        curr = System.currentTimeMillis();
	        parser.module();
	        long parse_time = System.currentTimeMillis() - curr;
	        System.out.println("Parsed in " + parse_time + "ms.");

	}
		
}