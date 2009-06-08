package org.waebric;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.PushbackReader;

import org.sablecc.grammar.waebric.lexer.Lexer;
import org.sablecc.grammar.waebric.node.Start;
import org.sablecc.grammar.waebric.parser.Parser;
import org.waebric.adapter.ASTDisplay;
import org.waebric.adapter.TreeWalker;

public class Main {
	public static void main (String args[])
	{
		if (args.length < 2 || !new File(args[0]).exists())
			System.out.println("Please specify a valid waebric file to parse...");
		else
		{
		    try {
		        Lexer l = new Lexer (new PushbackReader (new BufferedReader(new FileReader (new File(args[0]))), 1024));
		        
		        Parser p = new Parser (l);
		        Start start = p.parse ();
//		        System.out.println (start.toString());
	
		        TreeWalker walker = new TreeWalker();
		        start.apply(walker);
		        
		        OutputStream out = null;
		        try {
    		        	File f = new File(args[1]);
    		        	out = new BufferedOutputStream(new FileOutputStream(f));
    		        	out.write(walker.getAstTree().getBytes());
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		        }
		        finally {
		            if (out != null)
		        	out.close();
		        }
		        
//		        ASTDisplay ad = new ASTDisplay ();
//		        start.apply (ad);
	
		      } catch (Exception e) {
		        e.printStackTrace();
		      }
		}
	}
}
