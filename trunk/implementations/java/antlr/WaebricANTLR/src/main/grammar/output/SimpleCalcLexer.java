// $ANTLR 3.1.2 /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g 2009-06-26 09:17:42

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class SimpleCalcLexer extends Lexer {
    public static final int NUMBER=8;
    public static final int WHITESPACE=10;
    public static final int PLUS=4;
    public static final int DIGIT=9;
    public static final int DIV=7;
    public static final int MULT=6;
    public static final int MINUS=5;
    public static final int EOF=-1;

    // delegates
    // delegators

    public SimpleCalcLexer() {;} 
    public SimpleCalcLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public SimpleCalcLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g"; }

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:3:6: ( '+' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:3:8: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:4:7: ( '-' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:4:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "MULT"
    public final void mMULT() throws RecognitionException {
        try {
            int _type = MULT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:5:6: ( '*' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:5:8: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MULT"

    // $ANTLR start "DIV"
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:6:5: ( '/' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:6:7: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIV"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:40:8: ( ( DIGIT )+ )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:40:10: ( DIGIT )+
            {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:40:10: ( DIGIT )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:40:11: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NUMBER"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:42:12: ( ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+ )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:42:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:42:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\t' && LA2_0<='\n')||(LA2_0>='\f' && LA2_0<='\r')||LA2_0==' ') ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:44:16: ( '0' .. '9' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:44:18: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    public void mTokens() throws RecognitionException {
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:1:8: ( PLUS | MINUS | MULT | DIV | NUMBER | WHITESPACE )
        int alt3=6;
        switch ( input.LA(1) ) {
        case '+':
            {
            alt3=1;
            }
            break;
        case '-':
            {
            alt3=2;
            }
            break;
        case '*':
            {
            alt3=3;
            }
            break;
        case '/':
            {
            alt3=4;
            }
            break;
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt3=5;
            }
            break;
        case '\t':
        case '\n':
        case '\f':
        case '\r':
        case ' ':
            {
            alt3=6;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 3, 0, input);

            throw nvae;
        }

        switch (alt3) {
            case 1 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:1:10: PLUS
                {
                mPLUS(); 

                }
                break;
            case 2 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:1:15: MINUS
                {
                mMINUS(); 

                }
                break;
            case 3 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:1:21: MULT
                {
                mMULT(); 

                }
                break;
            case 4 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:1:26: DIV
                {
                mDIV(); 

                }
                break;
            case 5 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:1:30: NUMBER
                {
                mNUMBER(); 

                }
                break;
            case 6 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/SimpleCalc.g:1:37: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;

        }

    }


 

}