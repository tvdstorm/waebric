package com.uva.se.app;
import jfun.parsec.Lexers;
import jfun.parsec.Parser;
import jfun.parsec.Words;


public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int bla(){
		final Words ops = Lexers.getOperators(new String[]{"+","-","*","/", "(", ")"}); 
		final Parser l_ops = ops.getLexer(); 
		return 1;
	}

	
}
