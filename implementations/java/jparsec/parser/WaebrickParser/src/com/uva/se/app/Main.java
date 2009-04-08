package com.uva.se.app;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.Scanners;
import org.codehaus.jparsec.Terminals;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int bla(){
		Terminals operators = Terminals.operators(","); // only one operator supported so far
		Parser<?> integerTokenizer = Terminals.IntegerLiteral.TOKENIZER;
		Parser<String> integerSyntacticParser = Terminals.IntegerLiteral.PARSER;
		Parser<?> ignored = Parsers.or(Scanners.JAVA_BLOCK_COMMENT, Scanners.WHITESPACES);
		Parser<?> tokenizer = Parsers.or(operators.tokenizer(), integerTokenizer); // tokenizes the operators and integer
		Parser<List<String>> integers = integerSyntacticParser.sepBy(operators.token(","))
		    .from(tokenizer, ignored.skipMany());
		//assert(Arrays.asList("1", "2", "3"), integers.parse("1, /*this is comment*/2, 3");
		return 1;
	}

	
}
