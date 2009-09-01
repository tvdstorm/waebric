package org.cwi.waebric;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;

import antlr.SemanticException;

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
			CharStream is; // Input stream
			OutputStream os = System.out;
			
			if(args.length > 0) {
				is = new ANTLRFileStream(args[0]);
				System.out.println("Processing... " + args[0]);
				if(args.length > 1) {
					try {
						os = getOutputStream(args[1]);
						System.out.println("Storing... " + args[1]);
					} catch(IOException e) {
						e.printStackTrace();
						System.out.println("Could not write to " + args[1] + " writing to console instead.");
					}
				}
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
	        WaebricParser.module_return result = parser.module();
	        long parse_time = System.currentTimeMillis() - curr;
	        System.out.println("Parsed in " + parse_time + "ms.");
	        
	        CommonTree tree = (CommonTree) result.getTree();
	        System.out.println(tree.toStringTree());
	        
	        WaebricLoader loader = new WaebricLoader(new CommonTreeNodeStream(tree));
	        curr = System.currentTimeMillis();
	        List<SemanticException> se = loader.loadModule();
	        long load_time = System.currentTimeMillis() - curr;
	        System.out.println("Loaded in " + load_time + "ms.");
	        System.out.println(loader.getFunctions().keySet().toString());
	        System.out.println(loader.getYields().toString());
	        
	        WaebricChecker checker = new WaebricChecker(
	        			new CommonTreeNodeStream(tree), // Input tokens
	        			se // Caught exceptions while loading functions
	        		);
	        curr = System.currentTimeMillis();
	        checker.checkAST(loader);
	        long check_time = System.currentTimeMillis() - curr;
	        System.out.println("Checked in " + check_time + "ms, with " + se.size() + " semantic exceptions");
	        
	        for(SemanticException e: se) {
	        	e.printStackTrace();
	        }
	     
	        WaebricInterpreter interpreter = new WaebricInterpreter(new CommonTreeNodeStream(tree));
	        curr = System.currentTimeMillis();
	        interpreter.interpretProgram(os, loader);
	        long inter_time = System.currentTimeMillis() - curr;
	        System.out.println("Interpreted in " + inter_time + "ms");
	}
	
	/**
	 * Convert requested output file path into output stream. In case
	 * the interpreted was construct with an output stream, this stream
	 * will be returned instead.
	 * 
	 * When a directory or file in the specified path does not exist
	 * they will be created, this might result in an IOException.
	 * 
	 * @param module
	 * @return
	 * @throws IOException
	 */
	public static OutputStream getOutputStream(String path) throws IOException {
		int dirLength = path.lastIndexOf("/");
		
		// Create directories
		if(dirLength != -1) {
			File directory = new File(path.substring(0, dirLength));
			directory.mkdirs();
		}
		
		// Create file
		File file = new File(path);
		file.createNewFile(); // Create new file
		
		return new FileOutputStream(path);
	}
		
}