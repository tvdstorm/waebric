package org.cwi.waebric;

import java.util.List;
import java.util.Map;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.cwi.waebric.WaebricChecker.SemanticException;

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
			
			System.out.println("Processing...");

	        long curr = System.currentTimeMillis();
	        WaebricLexer lexer = new WaebricLexer(is);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        long scan_time = System.currentTimeMillis() - curr;
	        System.out.println("Scanned in " + scan_time + "ms.");

	        WaebricParser parser = new WaebricParser(tokens);
	        curr = System.currentTimeMillis();
	        WaebricParser.module_return result = parser.module();
	        long parse_time = System.currentTimeMillis() - curr;
	        System.out.println("Parsed in " + parse_time + "ms.");
	        
	        CommonTree tree = (CommonTree) result.getTree();
	        System.out.println(tree.toStringTree());
	        
	        WaebricChecker checker = new WaebricChecker(new CommonTreeNodeStream(tree));
	        curr = System.currentTimeMillis();
	        List<SemanticException> se = checker.checkAST();
	        long check_time = System.currentTimeMillis() - curr;
	        System.out.println("Checked in " + check_time + "ms, with " + se.size() + " semantic exceptions");
	        
	        for(SemanticException e: se) {
	        	e.printStackTrace();
	        }
	        
	        WaebricLoader loader = new WaebricLoader(new CommonTreeNodeStream(tree));
	        Map<String,CommonTree> functions = loader.getFunctions();
	        
	        WaebricInterpreter interpreter = new WaebricInterpreter(new CommonTreeNodeStream(tree), functions);
	        curr = System.currentTimeMillis();
	        interpreter.interpretProgram(System.out);
	        long inter_time = System.currentTimeMillis() - curr;
	        System.out.println("Interpreted in " + inter_time + "ms");
	}
		
}