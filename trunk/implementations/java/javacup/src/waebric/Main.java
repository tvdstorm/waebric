package waebric;

import waebric.node.*;
import java_cup.runtime.Symbol;
import java_cup.runtime.ComplexSymbolFactory;

public class Main {

	/**
	 * Runs the parser on an input file.
	 * 
	 * @param argv
	 *            the command line, argv[0] is the filename to run the parser
	 *            on.
	 */
	public static void main(String argv[]) throws java.io.IOException,
			java.lang.Exception {
		Lexer scanner = null;
		Symbol eofSymbol = null;
		try {
			ComplexSymbolFactory f = new ComplexSymbolFactory();
			eofSymbol = f.newSymbol("EOF", sym.EOF);
			scanner = new Lexer(f, new java.io.FileInputStream(argv[0]));
		} catch (java.io.FileNotFoundException e) {
			System.out.println("File not found : \"" + argv[0] + "\"");
			System.exit(1);
		} catch (java.io.IOException e) {
			System.out.println("Error opening file \"" + argv[0] + "\"");
			System.exit(1);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Usage : java Main <inputfile>");
			System.exit(1);
		}
			
//		Symbol symbol= scanner.next_token();
//		while(symbol.sym != sym.EOF)
//		{
//			if (symbol != null)
//				System.out.println(symbol.toString());
//			symbol = scanner.next_token();
//		}
		
		try {
			Parser p = new Parser(scanner);
			SyntaxNode result = (SyntaxNode) p.parse().value;
			
			PrintAST past = new PrintAST();
			result.accept(past);
			// TODO en nu het echte werk...
		} catch (java.io.IOException e) {
			System.out.println("An I/O error occured while parsing : \n" + e);
			System.exit(1);
		}
	}
}
