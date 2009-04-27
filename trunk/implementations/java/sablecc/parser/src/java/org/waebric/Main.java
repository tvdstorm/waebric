package org.waebric;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PushbackReader;

import org.sablecc.grammar.waebric.lexer.Lexer;
import org.sablecc.grammar.waebric.node.Start;
import org.sablecc.grammar.waebric.parser.Parser;
import org.waebric.gui.ASTDisplay;

public class Main {
	public static void main (String args[])
	{
		if (args.length < 1 || !new File(args[0]).exists())
			System.out.println("Please specify a valid waebric file to parse...");
		else
		{
		    try {
		        Lexer l = new Lexer (new PushbackReader (new BufferedReader(new FileReader (new File(args[0]))), 1024));
		        
		        Parser p = new Parser (l);
		        Start start = p.parse ();
		        System.out.println (start.toString());
	
	//	        Calculate calculator = new Calculate ();
	//	        start.apply (calculator);
	
		        ASTDisplay ad = new ASTDisplay ();
		        start.apply (ad);
	
		      } catch (Exception e) {
		        e.printStackTrace();
		      }
		}
	}
}
