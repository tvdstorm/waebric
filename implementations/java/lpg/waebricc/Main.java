package waebricc;
import waebricc.WaebricAst.*;

public class Main
{
	public static void main(String[] args)
    {
        Option option;
        JavaLexer Expr_lexer;
        WaebricParser Expr_parser;

        Ast ast;

        try
        {
            option = new Option(args);
            Expr_lexer = new JavaLexer(option); // Create the lexer
            Expr_parser = new WaebricParser(Expr_lexer);	// Create the parser
            Expr_lexer.lexer(Expr_parser); // Lex the stream to produce the token stream
            if (option.dumpTokens())
            {
                System.out.println("\n****Output Tokens: \n");
                Expr_parser.dumpTokens();
            }
            ast = Expr_parser.parser(); // Parse the token stream to produce an AST
            if (ast == null) 
                 System.out.println("****Failure");
            else 
            {
            	ast.accept(new PrettyPrintVisitor(Expr_parser));
            }
            

            return;
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}