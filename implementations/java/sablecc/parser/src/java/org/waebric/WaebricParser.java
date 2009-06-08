package org.waebric;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PushbackReader;

import org.sablecc.grammar.waebric.lexer.Lexer;
import org.sablecc.grammar.waebric.node.Start;
import org.sablecc.grammar.waebric.parser.Parser;
import org.waebric.adapter.ASTDisplay;
import org.waebric.adapter.TreeWalker;

/**
 * Parses the file as provided in the argument list.
 */
public class WaebricParser {
    
    /**
     * Returns the parser for the specified filename.
     * 
     * @param filename The name of the file to parse.
     * @return The parser created for parsing the file.
     */
    private static Parser getParser(String filename) throws IOException {
	File inputFile = new File(filename);
	
	if (!inputFile.exists() || inputFile.isDirectory())
	    throw new IllegalArgumentException("Please specify a valid and existing input file");
	    
	BufferedReader fileReader = new BufferedReader(new FileReader(inputFile));
	Lexer lexer = new Lexer(new PushbackReader(fileReader, 1024));

	return new Parser(lexer);
    }
    
    /**
     * Saves the AST Tree to the supplied filename on disc.
     * 
     * @param astTree The AST tree that will be saved.
     * @param filename THe name of the file to save the tree to.
     * @exception IOException Thrown when the AST tree could not be written to disc. 
     */
    private static void saveAstTree(String astTree, String filename) throws IOException {
	OutputStream out = null;
	
	try {
	    File outputFile = new File(filename);
	    out = new BufferedOutputStream(new FileOutputStream(outputFile));
	    out.write(astTree.getBytes());
	} finally {
	    if (out != null) {
		out.close();
	    }
	}
    }
    
    private static void showUsage() {
	StringBuilder sb = new StringBuilder();
	sb.append("Waebric parser build using SableCC\n");
	sb.append("----------------------------------\n\n");
	sb.append("Usage:\n\n");
	sb.append("\tjava WaebricParser inputFile [outputFile]\n\n\n");
	sb.append("- inputFile -> name of the file to parse\n\n");
	sb.append("- outputFile -> (Optional) The name of the file to write the AST tree to");
	
	System.out.println(sb.toString());
    }
    
    public static void main(String args[]) {
	
	if (args.length > 0 && args.length <= 2) {
	    
	    try {
		Parser parser = getParser(args[0]);
        	Start start = parser.parse();
        
        	TreeWalker walker = new TreeWalker();
        	start.apply(walker);
        
        	// Save the output to disc
        	if (args.length == 2)
        	    saveAstTree(walker.getAstTree(), args[1]);
        
        	// Display a visual representation of the tree
        	ASTDisplay ad = new ASTDisplay ();
        	start.apply (ad);
	    } catch (Exception e) {
		// Simple command line tool, so do simple exception handling here
		e.printStackTrace();
	    }
	} else {
	    showUsage();
	}
    }
}
