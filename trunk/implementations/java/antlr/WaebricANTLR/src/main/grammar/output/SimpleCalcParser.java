// $ANTLR 3.1.2 /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g 2009-06-26 09:03:54

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class SimpleCalcParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PLUS", "MINUS", "MULT", "DIV", "NUMBER", "DIGIT", "WHITESPACE"
    };
    public static final int NUMBER=8;
    public static final int WHITESPACE=10;
    public static final int PLUS=4;
    public static final int DIGIT=9;
    public static final int MINUS=5;
    public static final int MULT=6;
    public static final int DIV=7;
    public static final int EOF=-1;

    // delegates
    // delegators


        public SimpleCalcParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public SimpleCalcParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return SimpleCalcParser.tokenNames; }
    public String getGrammarFileName() { return "/ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g"; }


        public static void main(String[] args) throws Exception {
            SimpleCalcLexer lex = new SimpleCalcLexer(new ANTLRFileStream(args[0]));
           	CommonTokenStream tokens = new CommonTokenStream(lex);

            SimpleCalcParser parser = new SimpleCalcParser(tokens);

            try {
                parser.expr();
            } catch (RecognitionException e)  {
                e.printStackTrace();
            }
        }



    // $ANTLR start "expr"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:29:1: expr : term ( ( PLUS | MINUS ) term )* ;
    public final void expr() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:29:6: ( term ( ( PLUS | MINUS ) term )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:29:8: term ( ( PLUS | MINUS ) term )*
            {
            pushFollow(FOLLOW_term_in_expr61);
            term();

            state._fsp--;

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:29:13: ( ( PLUS | MINUS ) term )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=PLUS && LA1_0<=MINUS)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:29:15: ( PLUS | MINUS ) term
            	    {
            	    if ( (input.LA(1)>=PLUS && input.LA(1)<=MINUS) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_term_in_expr76);
            	    term();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "expr"


    // $ANTLR start "term"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:31:1: term : factor ( ( MULT | DIV ) factor )* ;
    public final void term() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:31:6: ( factor ( ( MULT | DIV ) factor )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:31:8: factor ( ( MULT | DIV ) factor )*
            {
            pushFollow(FOLLOW_factor_in_term88);
            factor();

            state._fsp--;

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:31:15: ( ( MULT | DIV ) factor )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=MULT && LA2_0<=DIV)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:31:17: ( MULT | DIV ) factor
            	    {
            	    if ( (input.LA(1)>=MULT && input.LA(1)<=DIV) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_factor_in_term102);
            	    factor();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "term"


    // $ANTLR start "factor"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:33:1: factor : NUMBER ;
    public final void factor() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:33:8: ( NUMBER )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:33:10: NUMBER
            {
            match(input,NUMBER,FOLLOW_NUMBER_in_factor114); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "factor"

    // Delegated rules


 

    public static final BitSet FOLLOW_term_in_expr61 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_set_in_expr65 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_term_in_expr76 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_factor_in_term88 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_set_in_term92 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_factor_in_term102 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_NUMBER_in_factor114 = new BitSet(new long[]{0x0000000000000002L});

}