package com.uva.se.javacup;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java_cup.runtime.Symbol;


public class Driver {
	
	String[] my_args;
	public static void main(String[] args) {
		Driver d = new Driver(args);
		d.run();
	}
	
	public Driver(String[] args) {
		my_args = args;
	}
	
	public void run() {
		System.out.println("scanning [" + my_args[0] + "]");
		try {
			FileReader fr = new FileReader(new File(my_args[0]));
			WaebricLexer l = new WaebricLexer(fr);
			//Token s = null ;
			Symbol s = null;
			try {				
				do{
					s = l.next_token();
					System.out.println("Symbol: " + s.toString());
				} while (s.sym != sym.EOF);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}
}
