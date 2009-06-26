// $ANTLR 3.1.2 /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g 2009-06-26 12:00:21

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class DebugWaebricLexer extends Lexer {
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int PATHELEMENT=7;
    public static final int WHITESPACE=8;
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int NATCON=6;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int FILEEXT=5;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int IDCON=4;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__10=10;

    // delegates
    // delegators

    public DebugWaebricLexer() {;} 
    public DebugWaebricLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public DebugWaebricLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g"; }

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:3:6: ( 'module' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:3:8: 'module'
            {
            match("module"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:4:7: ( 'end' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:4:9: 'end'
            {
            match("end"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:5:7: ( '.' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:5:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:6:7: ( 'import' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:6:9: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:7:7: ( ';' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:7:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:8:7: ( 'site' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:8:9: 'site'
            {
            match("site"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:9:7: ( ':' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:9:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:10:7: ( '/' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:10:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:11:7: ( '#' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:11:9: '#'
            {
            match('#'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:12:7: ( '$' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:12:9: '$'
            {
            match('$'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:13:7: ( '@' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:13:9: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:14:7: ( '%' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:14:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:15:7: ( '(' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:15:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:16:7: ( ',' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:16:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:17:7: ( ')' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:17:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:18:7: ( 'def' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:18:9: 'def'
            {
            match("def"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "IDCON"
    public final void mIDCON() throws RecognitionException {
        try {
            int _type = IDCON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:45:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:45:9: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:45:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDCON"

    // $ANTLR start "NATCON"
    public final void mNATCON() throws RecognitionException {
        try {
            int _type = NATCON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:46:7: ( ( '0' .. '9' )+ )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:46:10: ( '0' .. '9' )+
            {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:46:10: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:46:10: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NATCON"

    // $ANTLR start "FILEEXT"
    public final void mFILEEXT() throws RecognitionException {
        try {
            int _type = FILEEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:48:8: ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:48:10: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:48:43: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FILEEXT"

    // $ANTLR start "PATHELEMENT"
    public final void mPATHELEMENT() throws RecognitionException {
        try {
            int _type = PATHELEMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:49:12: ( (~ ( ' ' | '\\t' | '\\n' | '\\r' | '.' | '/' | '\\\\' ) )+ )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:49:14: (~ ( ' ' | '\\t' | '\\n' | '\\r' | '.' | '/' | '\\\\' ) )+
            {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:49:14: (~ ( ' ' | '\\t' | '\\n' | '\\r' | '.' | '/' | '\\\\' ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='\u0000' && LA4_0<='\b')||(LA4_0>='\u000B' && LA4_0<='\f')||(LA4_0>='\u000E' && LA4_0<='\u001F')||(LA4_0>='!' && LA4_0<='-')||(LA4_0>='0' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:49:14: ~ ( ' ' | '\\t' | '\\n' | '\\r' | '.' | '/' | '\\\\' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||(input.LA(1)>='!' && input.LA(1)<='-')||(input.LA(1)>='0' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PATHELEMENT"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:52:11: ( ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+ )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:52:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:52:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='\t' && LA5_0<='\n')||(LA5_0>='\f' && LA5_0<='\r')||LA5_0==' ') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:
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
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
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

    public void mTokens() throws RecognitionException {
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:1:8: ( T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | IDCON | NATCON | FILEEXT | PATHELEMENT | WHITESPACE )
        int alt6=21;
        alt6 = dfa6.predict(input);
        switch (alt6) {
            case 1 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:1:10: T__9
                {
                mT__9(); 

                }
                break;
            case 2 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:1:15: T__10
                {
                mT__10(); 

                }
                break;
            case 3 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:1:21: T__11
                {
                mT__11(); 

                }
                break;
            case 4 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:1:27: T__12
                {
                mT__12(); 

                }
                break;
            case 5 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:1:33: T__13
                {
                mT__13(); 

                }
                break;
            case 6 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:1:39: T__14
                {
                mT__14(); 

                }
                break;
            case 7 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:1:45: T__15
                {
                mT__15(); 

                }
                break;
            case 8 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:1:51: T__16
                {
                mT__16(); 

                }
                break;
            case 9 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:1:57: T__17
                {
                mT__17(); 

                }
                break;
            case 10 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:1:63: T__18
                {
                mT__18(); 

                }
                break;
            case 11 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:1:69: T__19
                {
                mT__19(); 

                }
                break;
            case 12 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:1:75: T__20
                {
                mT__20(); 

                }
                break;
            case 13 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:1:81: T__21
                {
                mT__21(); 

                }
                break;
            case 14 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:1:87: T__22
                {
                mT__22(); 

                }
                break;
            case 15 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:1:93: T__23
                {
                mT__23(); 

                }
                break;
            case 16 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:1:99: T__24
                {
                mT__24(); 

                }
                break;
            case 17 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:1:105: IDCON
                {
                mIDCON(); 

                }
                break;
            case 18 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:1:111: NATCON
                {
                mNATCON(); 

                }
                break;
            case 19 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:1:118: FILEEXT
                {
                mFILEEXT(); 

                }
                break;
            case 20 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:1:126: PATHELEMENT
                {
                mPATHELEMENT(); 

                }
                break;
            case 21 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:1:138: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;

        }

    }


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\1\uffff\2\27\1\uffff\1\27\1\33\1\27\1\35\1\uffff\1\36\1\37\1\40"+
        "\1\41\1\42\1\43\1\44\2\27\1\46\1\24\2\uffff\1\27\1\uffff\3\27\1"+
        "\uffff\1\27\10\uffff\1\27\1\uffff\1\46\1\56\1\27\1\60\2\27\1\63"+
        "\1\uffff\1\27\1\uffff\1\27\1\66\1\uffff\2\27\1\uffff\1\71\1\72\2"+
        "\uffff";
    static final String DFA6_eofS =
        "\73\uffff";
    static final String DFA6_minS =
        "\3\0\1\uffff\4\0\1\uffff\12\0\1\11\2\uffff\1\0\1\uffff\3\0\1\uffff"+
        "\1\0\10\uffff\1\0\1\uffff\7\0\1\uffff\1\0\1\uffff\2\0\1\uffff\2"+
        "\0\1\uffff\2\0\2\uffff";
    static final String DFA6_maxS =
        "\3\uffff\1\uffff\4\uffff\1\uffff\12\uffff\1\40\2\uffff\1\uffff\1"+
        "\uffff\3\uffff\1\uffff\1\uffff\10\uffff\1\uffff\1\uffff\7\uffff"+
        "\1\uffff\1\uffff\1\uffff\2\uffff\1\uffff\2\uffff\1\uffff\2\uffff"+
        "\2\uffff";
    static final String DFA6_acceptS =
        "\3\uffff\1\3\4\uffff\1\10\13\uffff\1\24\1\25\1\uffff\1\21\3\uffff"+
        "\1\5\1\uffff\1\7\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\uffff\1\22"+
        "\7\uffff\1\23\1\uffff\1\2\2\uffff\1\20\2\uffff\1\6\2\uffff\1\1\1"+
        "\4";
    static final String DFA6_specialS =
        "\1\33\1\22\1\4\1\uffff\1\2\1\15\1\13\1\43\1\uffff\1\32\1\34\1\21"+
        "\1\26\1\1\1\7\1\16\1\31\1\30\1\23\3\uffff\1\35\1\uffff\1\20\1\44"+
        "\1\11\1\uffff\1\3\10\uffff\1\24\1\uffff\1\40\1\41\1\36\1\25\1\12"+
        "\1\0\1\17\1\uffff\1\37\1\uffff\1\5\1\10\1\uffff\1\42\1\6\1\uffff"+
        "\1\27\1\14\2\uffff}>";
    static final String[] DFA6_transitionS = {
            "\11\24\2\25\1\24\1\23\1\25\22\24\1\25\2\24\1\11\1\12\1\14\2"+
            "\24\1\15\1\17\2\24\1\16\1\24\1\3\1\10\12\22\1\7\1\5\4\24\1\13"+
            "\32\21\1\24\1\uffff\4\24\3\21\1\20\1\2\3\21\1\4\3\21\1\1\5\21"+
            "\1\6\7\21\uff85\24",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\12"+
            "\30\7\24\32\30\1\24\1\uffff\4\24\16\30\1\26\13\30\uff85\24",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\12"+
            "\30\7\24\32\30\1\24\1\uffff\4\24\15\30\1\31\14\30\uff85\24",
            "",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\12"+
            "\30\7\24\32\30\1\24\1\uffff\4\24\14\30\1\32\15\30\uff85\24",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\54"+
            "\24\1\uffff\uffa3\24",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\12"+
            "\30\7\24\32\30\1\24\1\uffff\4\24\10\30\1\34\21\30\uff85\24",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\54"+
            "\24\1\uffff\uffa3\24",
            "",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\54"+
            "\24\1\uffff\uffa3\24",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\54"+
            "\24\1\uffff\uffa3\24",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\54"+
            "\24\1\uffff\uffa3\24",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\54"+
            "\24\1\uffff\uffa3\24",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\54"+
            "\24\1\uffff\uffa3\24",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\54"+
            "\24\1\uffff\uffa3\24",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\54"+
            "\24\1\uffff\uffa3\24",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\12"+
            "\30\7\24\32\30\1\24\1\uffff\4\24\4\30\1\45\25\30\uff85\24",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\12"+
            "\30\7\24\32\30\1\24\1\uffff\4\24\32\30\uff85\24",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\12"+
            "\47\7\24\32\50\1\24\1\uffff\4\24\32\50\uff85\24",
            "\2\25\1\uffff\1\23\1\25\22\uffff\1\25",
            "",
            "",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\12"+
            "\30\7\24\32\30\1\24\1\uffff\4\24\3\30\1\51\26\30\uff85\24",
            "",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\12"+
            "\30\7\24\32\30\1\24\1\uffff\4\24\32\30\uff85\24",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\12"+
            "\30\7\24\32\30\1\24\1\uffff\4\24\3\30\1\52\26\30\uff85\24",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\12"+
            "\30\7\24\32\30\1\24\1\uffff\4\24\17\30\1\53\12\30\uff85\24",
            "",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\12"+
            "\30\7\24\32\30\1\24\1\uffff\4\24\23\30\1\54\6\30\uff85\24",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\12"+
            "\30\7\24\32\30\1\24\1\uffff\4\24\5\30\1\55\24\30\uff85\24",
            "",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\12"+
            "\47\7\24\32\50\1\24\1\uffff\4\24\32\50\uff85\24",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\12"+
            "\50\7\24\32\50\1\24\1\uffff\4\24\32\50\uff85\24",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\12"+
            "\30\7\24\32\30\1\24\1\uffff\4\24\24\30\1\57\5\30\uff85\24",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\12"+
            "\30\7\24\32\30\1\24\1\uffff\4\24\32\30\uff85\24",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\12"+
            "\30\7\24\32\30\1\24\1\uffff\4\24\16\30\1\61\13\30\uff85\24",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\12"+
            "\30\7\24\32\30\1\24\1\uffff\4\24\4\30\1\62\25\30\uff85\24",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\12"+
            "\30\7\24\32\30\1\24\1\uffff\4\24\32\30\uff85\24",
            "",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\12"+
            "\30\7\24\32\30\1\24\1\uffff\4\24\13\30\1\64\16\30\uff85\24",
            "",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\12"+
            "\30\7\24\32\30\1\24\1\uffff\4\24\21\30\1\65\10\30\uff85\24",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\12"+
            "\30\7\24\32\30\1\24\1\uffff\4\24\32\30\uff85\24",
            "",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\12"+
            "\30\7\24\32\30\1\24\1\uffff\4\24\4\30\1\67\25\30\uff85\24",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\12"+
            "\30\7\24\32\30\1\24\1\uffff\4\24\23\30\1\70\6\30\uff85\24",
            "",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\12"+
            "\30\7\24\32\30\1\24\1\uffff\4\24\32\30\uff85\24",
            "\11\24\2\uffff\2\24\1\uffff\22\24\1\uffff\15\24\2\uffff\12"+
            "\30\7\24\32\30\1\24\1\uffff\4\24\32\30\uff85\24",
            "",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | IDCON | NATCON | FILEEXT | PATHELEMENT | WHITESPACE );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA6_44 = input.LA(1);

                        s = -1;
                        if ( (LA6_44=='e') ) {s = 50;}

                        else if ( ((LA6_44>='0' && LA6_44<='9')||(LA6_44>='A' && LA6_44<='Z')||(LA6_44>='a' && LA6_44<='d')||(LA6_44>='f' && LA6_44<='z')) ) {s = 24;}

                        else if ( ((LA6_44>='\u0000' && LA6_44<='\b')||(LA6_44>='\u000B' && LA6_44<='\f')||(LA6_44>='\u000E' && LA6_44<='\u001F')||(LA6_44>='!' && LA6_44<='-')||(LA6_44>=':' && LA6_44<='@')||LA6_44=='['||(LA6_44>=']' && LA6_44<='`')||(LA6_44>='{' && LA6_44<='\uFFFF')) ) {s = 20;}

                        else s = 23;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA6_13 = input.LA(1);

                        s = -1;
                        if ( ((LA6_13>='\u0000' && LA6_13<='\b')||(LA6_13>='\u000B' && LA6_13<='\f')||(LA6_13>='\u000E' && LA6_13<='\u001F')||(LA6_13>='!' && LA6_13<='-')||(LA6_13>='0' && LA6_13<='[')||(LA6_13>=']' && LA6_13<='\uFFFF')) ) {s = 20;}

                        else s = 34;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA6_4 = input.LA(1);

                        s = -1;
                        if ( (LA6_4=='m') ) {s = 26;}

                        else if ( ((LA6_4>='0' && LA6_4<='9')||(LA6_4>='A' && LA6_4<='Z')||(LA6_4>='a' && LA6_4<='l')||(LA6_4>='n' && LA6_4<='z')) ) {s = 24;}

                        else if ( ((LA6_4>='\u0000' && LA6_4<='\b')||(LA6_4>='\u000B' && LA6_4<='\f')||(LA6_4>='\u000E' && LA6_4<='\u001F')||(LA6_4>='!' && LA6_4<='-')||(LA6_4>=':' && LA6_4<='@')||LA6_4=='['||(LA6_4>=']' && LA6_4<='`')||(LA6_4>='{' && LA6_4<='\uFFFF')) ) {s = 20;}

                        else s = 23;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA6_28 = input.LA(1);

                        s = -1;
                        if ( (LA6_28=='t') ) {s = 44;}

                        else if ( ((LA6_28>='0' && LA6_28<='9')||(LA6_28>='A' && LA6_28<='Z')||(LA6_28>='a' && LA6_28<='s')||(LA6_28>='u' && LA6_28<='z')) ) {s = 24;}

                        else if ( ((LA6_28>='\u0000' && LA6_28<='\b')||(LA6_28>='\u000B' && LA6_28<='\f')||(LA6_28>='\u000E' && LA6_28<='\u001F')||(LA6_28>='!' && LA6_28<='-')||(LA6_28>=':' && LA6_28<='@')||LA6_28=='['||(LA6_28>=']' && LA6_28<='`')||(LA6_28>='{' && LA6_28<='\uFFFF')) ) {s = 20;}

                        else s = 23;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA6_2 = input.LA(1);

                        s = -1;
                        if ( (LA6_2=='n') ) {s = 25;}

                        else if ( ((LA6_2>='0' && LA6_2<='9')||(LA6_2>='A' && LA6_2<='Z')||(LA6_2>='a' && LA6_2<='m')||(LA6_2>='o' && LA6_2<='z')) ) {s = 24;}

                        else if ( ((LA6_2>='\u0000' && LA6_2<='\b')||(LA6_2>='\u000B' && LA6_2<='\f')||(LA6_2>='\u000E' && LA6_2<='\u001F')||(LA6_2>='!' && LA6_2<='-')||(LA6_2>=':' && LA6_2<='@')||LA6_2=='['||(LA6_2>=']' && LA6_2<='`')||(LA6_2>='{' && LA6_2<='\uFFFF')) ) {s = 20;}

                        else s = 23;

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA6_49 = input.LA(1);

                        s = -1;
                        if ( (LA6_49=='r') ) {s = 53;}

                        else if ( ((LA6_49>='0' && LA6_49<='9')||(LA6_49>='A' && LA6_49<='Z')||(LA6_49>='a' && LA6_49<='q')||(LA6_49>='s' && LA6_49<='z')) ) {s = 24;}

                        else if ( ((LA6_49>='\u0000' && LA6_49<='\b')||(LA6_49>='\u000B' && LA6_49<='\f')||(LA6_49>='\u000E' && LA6_49<='\u001F')||(LA6_49>='!' && LA6_49<='-')||(LA6_49>=':' && LA6_49<='@')||LA6_49=='['||(LA6_49>=']' && LA6_49<='`')||(LA6_49>='{' && LA6_49<='\uFFFF')) ) {s = 20;}

                        else s = 23;

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA6_53 = input.LA(1);

                        s = -1;
                        if ( (LA6_53=='t') ) {s = 56;}

                        else if ( ((LA6_53>='0' && LA6_53<='9')||(LA6_53>='A' && LA6_53<='Z')||(LA6_53>='a' && LA6_53<='s')||(LA6_53>='u' && LA6_53<='z')) ) {s = 24;}

                        else if ( ((LA6_53>='\u0000' && LA6_53<='\b')||(LA6_53>='\u000B' && LA6_53<='\f')||(LA6_53>='\u000E' && LA6_53<='\u001F')||(LA6_53>='!' && LA6_53<='-')||(LA6_53>=':' && LA6_53<='@')||LA6_53=='['||(LA6_53>=']' && LA6_53<='`')||(LA6_53>='{' && LA6_53<='\uFFFF')) ) {s = 20;}

                        else s = 23;

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA6_14 = input.LA(1);

                        s = -1;
                        if ( ((LA6_14>='\u0000' && LA6_14<='\b')||(LA6_14>='\u000B' && LA6_14<='\f')||(LA6_14>='\u000E' && LA6_14<='\u001F')||(LA6_14>='!' && LA6_14<='-')||(LA6_14>='0' && LA6_14<='[')||(LA6_14>=']' && LA6_14<='\uFFFF')) ) {s = 20;}

                        else s = 35;

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA6_50 = input.LA(1);

                        s = -1;
                        if ( ((LA6_50>='0' && LA6_50<='9')||(LA6_50>='A' && LA6_50<='Z')||(LA6_50>='a' && LA6_50<='z')) ) {s = 24;}

                        else if ( ((LA6_50>='\u0000' && LA6_50<='\b')||(LA6_50>='\u000B' && LA6_50<='\f')||(LA6_50>='\u000E' && LA6_50<='\u001F')||(LA6_50>='!' && LA6_50<='-')||(LA6_50>=':' && LA6_50<='@')||LA6_50=='['||(LA6_50>=']' && LA6_50<='`')||(LA6_50>='{' && LA6_50<='\uFFFF')) ) {s = 20;}

                        else s = 54;

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA6_26 = input.LA(1);

                        s = -1;
                        if ( (LA6_26=='p') ) {s = 43;}

                        else if ( ((LA6_26>='0' && LA6_26<='9')||(LA6_26>='A' && LA6_26<='Z')||(LA6_26>='a' && LA6_26<='o')||(LA6_26>='q' && LA6_26<='z')) ) {s = 24;}

                        else if ( ((LA6_26>='\u0000' && LA6_26<='\b')||(LA6_26>='\u000B' && LA6_26<='\f')||(LA6_26>='\u000E' && LA6_26<='\u001F')||(LA6_26>='!' && LA6_26<='-')||(LA6_26>=':' && LA6_26<='@')||LA6_26=='['||(LA6_26>=']' && LA6_26<='`')||(LA6_26>='{' && LA6_26<='\uFFFF')) ) {s = 20;}

                        else s = 23;

                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA6_43 = input.LA(1);

                        s = -1;
                        if ( (LA6_43=='o') ) {s = 49;}

                        else if ( ((LA6_43>='0' && LA6_43<='9')||(LA6_43>='A' && LA6_43<='Z')||(LA6_43>='a' && LA6_43<='n')||(LA6_43>='p' && LA6_43<='z')) ) {s = 24;}

                        else if ( ((LA6_43>='\u0000' && LA6_43<='\b')||(LA6_43>='\u000B' && LA6_43<='\f')||(LA6_43>='\u000E' && LA6_43<='\u001F')||(LA6_43>='!' && LA6_43<='-')||(LA6_43>=':' && LA6_43<='@')||LA6_43=='['||(LA6_43>=']' && LA6_43<='`')||(LA6_43>='{' && LA6_43<='\uFFFF')) ) {s = 20;}

                        else s = 23;

                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA6_6 = input.LA(1);

                        s = -1;
                        if ( (LA6_6=='i') ) {s = 28;}

                        else if ( ((LA6_6>='0' && LA6_6<='9')||(LA6_6>='A' && LA6_6<='Z')||(LA6_6>='a' && LA6_6<='h')||(LA6_6>='j' && LA6_6<='z')) ) {s = 24;}

                        else if ( ((LA6_6>='\u0000' && LA6_6<='\b')||(LA6_6>='\u000B' && LA6_6<='\f')||(LA6_6>='\u000E' && LA6_6<='\u001F')||(LA6_6>='!' && LA6_6<='-')||(LA6_6>=':' && LA6_6<='@')||LA6_6=='['||(LA6_6>=']' && LA6_6<='`')||(LA6_6>='{' && LA6_6<='\uFFFF')) ) {s = 20;}

                        else s = 23;

                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA6_56 = input.LA(1);

                        s = -1;
                        if ( ((LA6_56>='0' && LA6_56<='9')||(LA6_56>='A' && LA6_56<='Z')||(LA6_56>='a' && LA6_56<='z')) ) {s = 24;}

                        else if ( ((LA6_56>='\u0000' && LA6_56<='\b')||(LA6_56>='\u000B' && LA6_56<='\f')||(LA6_56>='\u000E' && LA6_56<='\u001F')||(LA6_56>='!' && LA6_56<='-')||(LA6_56>=':' && LA6_56<='@')||LA6_56=='['||(LA6_56>=']' && LA6_56<='`')||(LA6_56>='{' && LA6_56<='\uFFFF')) ) {s = 20;}

                        else s = 58;

                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA6_5 = input.LA(1);

                        s = -1;
                        if ( ((LA6_5>='\u0000' && LA6_5<='\b')||(LA6_5>='\u000B' && LA6_5<='\f')||(LA6_5>='\u000E' && LA6_5<='\u001F')||(LA6_5>='!' && LA6_5<='-')||(LA6_5>='0' && LA6_5<='[')||(LA6_5>=']' && LA6_5<='\uFFFF')) ) {s = 20;}

                        else s = 27;

                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA6_15 = input.LA(1);

                        s = -1;
                        if ( ((LA6_15>='\u0000' && LA6_15<='\b')||(LA6_15>='\u000B' && LA6_15<='\f')||(LA6_15>='\u000E' && LA6_15<='\u001F')||(LA6_15>='!' && LA6_15<='-')||(LA6_15>='0' && LA6_15<='[')||(LA6_15>=']' && LA6_15<='\uFFFF')) ) {s = 20;}

                        else s = 36;

                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA6_45 = input.LA(1);

                        s = -1;
                        if ( ((LA6_45>='0' && LA6_45<='9')||(LA6_45>='A' && LA6_45<='Z')||(LA6_45>='a' && LA6_45<='z')) ) {s = 24;}

                        else if ( ((LA6_45>='\u0000' && LA6_45<='\b')||(LA6_45>='\u000B' && LA6_45<='\f')||(LA6_45>='\u000E' && LA6_45<='\u001F')||(LA6_45>='!' && LA6_45<='-')||(LA6_45>=':' && LA6_45<='@')||LA6_45=='['||(LA6_45>=']' && LA6_45<='`')||(LA6_45>='{' && LA6_45<='\uFFFF')) ) {s = 20;}

                        else s = 51;

                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA6_24 = input.LA(1);

                        s = -1;
                        if ( ((LA6_24>='0' && LA6_24<='9')||(LA6_24>='A' && LA6_24<='Z')||(LA6_24>='a' && LA6_24<='z')) ) {s = 24;}

                        else if ( ((LA6_24>='\u0000' && LA6_24<='\b')||(LA6_24>='\u000B' && LA6_24<='\f')||(LA6_24>='\u000E' && LA6_24<='\u001F')||(LA6_24>='!' && LA6_24<='-')||(LA6_24>=':' && LA6_24<='@')||LA6_24=='['||(LA6_24>=']' && LA6_24<='`')||(LA6_24>='{' && LA6_24<='\uFFFF')) ) {s = 20;}

                        else s = 23;

                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA6_11 = input.LA(1);

                        s = -1;
                        if ( ((LA6_11>='\u0000' && LA6_11<='\b')||(LA6_11>='\u000B' && LA6_11<='\f')||(LA6_11>='\u000E' && LA6_11<='\u001F')||(LA6_11>='!' && LA6_11<='-')||(LA6_11>='0' && LA6_11<='[')||(LA6_11>=']' && LA6_11<='\uFFFF')) ) {s = 20;}

                        else s = 32;

                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA6_1 = input.LA(1);

                        s = -1;
                        if ( (LA6_1=='o') ) {s = 22;}

                        else if ( ((LA6_1>='0' && LA6_1<='9')||(LA6_1>='A' && LA6_1<='Z')||(LA6_1>='a' && LA6_1<='n')||(LA6_1>='p' && LA6_1<='z')) ) {s = 24;}

                        else if ( ((LA6_1>='\u0000' && LA6_1<='\b')||(LA6_1>='\u000B' && LA6_1<='\f')||(LA6_1>='\u000E' && LA6_1<='\u001F')||(LA6_1>='!' && LA6_1<='-')||(LA6_1>=':' && LA6_1<='@')||LA6_1=='['||(LA6_1>=']' && LA6_1<='`')||(LA6_1>='{' && LA6_1<='\uFFFF')) ) {s = 20;}

                        else s = 23;

                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA6_18 = input.LA(1);

                        s = -1;
                        if ( ((LA6_18>='0' && LA6_18<='9')) ) {s = 39;}

                        else if ( ((LA6_18>='A' && LA6_18<='Z')||(LA6_18>='a' && LA6_18<='z')) ) {s = 40;}

                        else if ( ((LA6_18>='\u0000' && LA6_18<='\b')||(LA6_18>='\u000B' && LA6_18<='\f')||(LA6_18>='\u000E' && LA6_18<='\u001F')||(LA6_18>='!' && LA6_18<='-')||(LA6_18>=':' && LA6_18<='@')||LA6_18=='['||(LA6_18>=']' && LA6_18<='`')||(LA6_18>='{' && LA6_18<='\uFFFF')) ) {s = 20;}

                        else s = 38;

                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA6_37 = input.LA(1);

                        s = -1;
                        if ( (LA6_37=='f') ) {s = 45;}

                        else if ( ((LA6_37>='0' && LA6_37<='9')||(LA6_37>='A' && LA6_37<='Z')||(LA6_37>='a' && LA6_37<='e')||(LA6_37>='g' && LA6_37<='z')) ) {s = 24;}

                        else if ( ((LA6_37>='\u0000' && LA6_37<='\b')||(LA6_37>='\u000B' && LA6_37<='\f')||(LA6_37>='\u000E' && LA6_37<='\u001F')||(LA6_37>='!' && LA6_37<='-')||(LA6_37>=':' && LA6_37<='@')||LA6_37=='['||(LA6_37>=']' && LA6_37<='`')||(LA6_37>='{' && LA6_37<='\uFFFF')) ) {s = 20;}

                        else s = 23;

                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA6_42 = input.LA(1);

                        s = -1;
                        if ( ((LA6_42>='0' && LA6_42<='9')||(LA6_42>='A' && LA6_42<='Z')||(LA6_42>='a' && LA6_42<='z')) ) {s = 24;}

                        else if ( ((LA6_42>='\u0000' && LA6_42<='\b')||(LA6_42>='\u000B' && LA6_42<='\f')||(LA6_42>='\u000E' && LA6_42<='\u001F')||(LA6_42>='!' && LA6_42<='-')||(LA6_42>=':' && LA6_42<='@')||LA6_42=='['||(LA6_42>=']' && LA6_42<='`')||(LA6_42>='{' && LA6_42<='\uFFFF')) ) {s = 20;}

                        else s = 48;

                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA6_12 = input.LA(1);

                        s = -1;
                        if ( ((LA6_12>='\u0000' && LA6_12<='\b')||(LA6_12>='\u000B' && LA6_12<='\f')||(LA6_12>='\u000E' && LA6_12<='\u001F')||(LA6_12>='!' && LA6_12<='-')||(LA6_12>='0' && LA6_12<='[')||(LA6_12>=']' && LA6_12<='\uFFFF')) ) {s = 20;}

                        else s = 33;

                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA6_55 = input.LA(1);

                        s = -1;
                        if ( ((LA6_55>='0' && LA6_55<='9')||(LA6_55>='A' && LA6_55<='Z')||(LA6_55>='a' && LA6_55<='z')) ) {s = 24;}

                        else if ( ((LA6_55>='\u0000' && LA6_55<='\b')||(LA6_55>='\u000B' && LA6_55<='\f')||(LA6_55>='\u000E' && LA6_55<='\u001F')||(LA6_55>='!' && LA6_55<='-')||(LA6_55>=':' && LA6_55<='@')||LA6_55=='['||(LA6_55>=']' && LA6_55<='`')||(LA6_55>='{' && LA6_55<='\uFFFF')) ) {s = 20;}

                        else s = 57;

                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA6_17 = input.LA(1);

                        s = -1;
                        if ( ((LA6_17>='0' && LA6_17<='9')||(LA6_17>='A' && LA6_17<='Z')||(LA6_17>='a' && LA6_17<='z')) ) {s = 24;}

                        else if ( ((LA6_17>='\u0000' && LA6_17<='\b')||(LA6_17>='\u000B' && LA6_17<='\f')||(LA6_17>='\u000E' && LA6_17<='\u001F')||(LA6_17>='!' && LA6_17<='-')||(LA6_17>=':' && LA6_17<='@')||LA6_17=='['||(LA6_17>=']' && LA6_17<='`')||(LA6_17>='{' && LA6_17<='\uFFFF')) ) {s = 20;}

                        else s = 23;

                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA6_16 = input.LA(1);

                        s = -1;
                        if ( (LA6_16=='e') ) {s = 37;}

                        else if ( ((LA6_16>='0' && LA6_16<='9')||(LA6_16>='A' && LA6_16<='Z')||(LA6_16>='a' && LA6_16<='d')||(LA6_16>='f' && LA6_16<='z')) ) {s = 24;}

                        else if ( ((LA6_16>='\u0000' && LA6_16<='\b')||(LA6_16>='\u000B' && LA6_16<='\f')||(LA6_16>='\u000E' && LA6_16<='\u001F')||(LA6_16>='!' && LA6_16<='-')||(LA6_16>=':' && LA6_16<='@')||LA6_16=='['||(LA6_16>=']' && LA6_16<='`')||(LA6_16>='{' && LA6_16<='\uFFFF')) ) {s = 20;}

                        else s = 23;

                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA6_9 = input.LA(1);

                        s = -1;
                        if ( ((LA6_9>='\u0000' && LA6_9<='\b')||(LA6_9>='\u000B' && LA6_9<='\f')||(LA6_9>='\u000E' && LA6_9<='\u001F')||(LA6_9>='!' && LA6_9<='-')||(LA6_9>='0' && LA6_9<='[')||(LA6_9>=']' && LA6_9<='\uFFFF')) ) {s = 20;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA6_0 = input.LA(1);

                        s = -1;
                        if ( (LA6_0=='m') ) {s = 1;}

                        else if ( (LA6_0=='e') ) {s = 2;}

                        else if ( (LA6_0=='.') ) {s = 3;}

                        else if ( (LA6_0=='i') ) {s = 4;}

                        else if ( (LA6_0==';') ) {s = 5;}

                        else if ( (LA6_0=='s') ) {s = 6;}

                        else if ( (LA6_0==':') ) {s = 7;}

                        else if ( (LA6_0=='/') ) {s = 8;}

                        else if ( (LA6_0=='#') ) {s = 9;}

                        else if ( (LA6_0=='$') ) {s = 10;}

                        else if ( (LA6_0=='@') ) {s = 11;}

                        else if ( (LA6_0=='%') ) {s = 12;}

                        else if ( (LA6_0=='(') ) {s = 13;}

                        else if ( (LA6_0==',') ) {s = 14;}

                        else if ( (LA6_0==')') ) {s = 15;}

                        else if ( (LA6_0=='d') ) {s = 16;}

                        else if ( ((LA6_0>='A' && LA6_0<='Z')||(LA6_0>='a' && LA6_0<='c')||(LA6_0>='f' && LA6_0<='h')||(LA6_0>='j' && LA6_0<='l')||(LA6_0>='n' && LA6_0<='r')||(LA6_0>='t' && LA6_0<='z')) ) {s = 17;}

                        else if ( ((LA6_0>='0' && LA6_0<='9')) ) {s = 18;}

                        else if ( (LA6_0=='\f') ) {s = 19;}

                        else if ( ((LA6_0>='\u0000' && LA6_0<='\b')||LA6_0=='\u000B'||(LA6_0>='\u000E' && LA6_0<='\u001F')||(LA6_0>='!' && LA6_0<='\"')||(LA6_0>='&' && LA6_0<='\'')||(LA6_0>='*' && LA6_0<='+')||LA6_0=='-'||(LA6_0>='<' && LA6_0<='?')||LA6_0=='['||(LA6_0>=']' && LA6_0<='`')||(LA6_0>='{' && LA6_0<='\uFFFF')) ) {s = 20;}

                        else if ( ((LA6_0>='\t' && LA6_0<='\n')||LA6_0=='\r'||LA6_0==' ') ) {s = 21;}

                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA6_10 = input.LA(1);

                        s = -1;
                        if ( ((LA6_10>='\u0000' && LA6_10<='\b')||(LA6_10>='\u000B' && LA6_10<='\f')||(LA6_10>='\u000E' && LA6_10<='\u001F')||(LA6_10>='!' && LA6_10<='-')||(LA6_10>='0' && LA6_10<='[')||(LA6_10>=']' && LA6_10<='\uFFFF')) ) {s = 20;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA6_22 = input.LA(1);

                        s = -1;
                        if ( (LA6_22=='d') ) {s = 41;}

                        else if ( ((LA6_22>='0' && LA6_22<='9')||(LA6_22>='A' && LA6_22<='Z')||(LA6_22>='a' && LA6_22<='c')||(LA6_22>='e' && LA6_22<='z')) ) {s = 24;}

                        else if ( ((LA6_22>='\u0000' && LA6_22<='\b')||(LA6_22>='\u000B' && LA6_22<='\f')||(LA6_22>='\u000E' && LA6_22<='\u001F')||(LA6_22>='!' && LA6_22<='-')||(LA6_22>=':' && LA6_22<='@')||LA6_22=='['||(LA6_22>=']' && LA6_22<='`')||(LA6_22>='{' && LA6_22<='\uFFFF')) ) {s = 20;}

                        else s = 23;

                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA6_41 = input.LA(1);

                        s = -1;
                        if ( (LA6_41=='u') ) {s = 47;}

                        else if ( ((LA6_41>='0' && LA6_41<='9')||(LA6_41>='A' && LA6_41<='Z')||(LA6_41>='a' && LA6_41<='t')||(LA6_41>='v' && LA6_41<='z')) ) {s = 24;}

                        else if ( ((LA6_41>='\u0000' && LA6_41<='\b')||(LA6_41>='\u000B' && LA6_41<='\f')||(LA6_41>='\u000E' && LA6_41<='\u001F')||(LA6_41>='!' && LA6_41<='-')||(LA6_41>=':' && LA6_41<='@')||LA6_41=='['||(LA6_41>=']' && LA6_41<='`')||(LA6_41>='{' && LA6_41<='\uFFFF')) ) {s = 20;}

                        else s = 23;

                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA6_47 = input.LA(1);

                        s = -1;
                        if ( (LA6_47=='l') ) {s = 52;}

                        else if ( ((LA6_47>='0' && LA6_47<='9')||(LA6_47>='A' && LA6_47<='Z')||(LA6_47>='a' && LA6_47<='k')||(LA6_47>='m' && LA6_47<='z')) ) {s = 24;}

                        else if ( ((LA6_47>='\u0000' && LA6_47<='\b')||(LA6_47>='\u000B' && LA6_47<='\f')||(LA6_47>='\u000E' && LA6_47<='\u001F')||(LA6_47>='!' && LA6_47<='-')||(LA6_47>=':' && LA6_47<='@')||LA6_47=='['||(LA6_47>=']' && LA6_47<='`')||(LA6_47>='{' && LA6_47<='\uFFFF')) ) {s = 20;}

                        else s = 23;

                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA6_39 = input.LA(1);

                        s = -1;
                        if ( ((LA6_39>='0' && LA6_39<='9')) ) {s = 39;}

                        else if ( ((LA6_39>='A' && LA6_39<='Z')||(LA6_39>='a' && LA6_39<='z')) ) {s = 40;}

                        else if ( ((LA6_39>='\u0000' && LA6_39<='\b')||(LA6_39>='\u000B' && LA6_39<='\f')||(LA6_39>='\u000E' && LA6_39<='\u001F')||(LA6_39>='!' && LA6_39<='-')||(LA6_39>=':' && LA6_39<='@')||LA6_39=='['||(LA6_39>=']' && LA6_39<='`')||(LA6_39>='{' && LA6_39<='\uFFFF')) ) {s = 20;}

                        else s = 38;

                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA6_40 = input.LA(1);

                        s = -1;
                        if ( ((LA6_40>='0' && LA6_40<='9')||(LA6_40>='A' && LA6_40<='Z')||(LA6_40>='a' && LA6_40<='z')) ) {s = 40;}

                        else if ( ((LA6_40>='\u0000' && LA6_40<='\b')||(LA6_40>='\u000B' && LA6_40<='\f')||(LA6_40>='\u000E' && LA6_40<='\u001F')||(LA6_40>='!' && LA6_40<='-')||(LA6_40>=':' && LA6_40<='@')||LA6_40=='['||(LA6_40>=']' && LA6_40<='`')||(LA6_40>='{' && LA6_40<='\uFFFF')) ) {s = 20;}

                        else s = 46;

                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA6_52 = input.LA(1);

                        s = -1;
                        if ( (LA6_52=='e') ) {s = 55;}

                        else if ( ((LA6_52>='0' && LA6_52<='9')||(LA6_52>='A' && LA6_52<='Z')||(LA6_52>='a' && LA6_52<='d')||(LA6_52>='f' && LA6_52<='z')) ) {s = 24;}

                        else if ( ((LA6_52>='\u0000' && LA6_52<='\b')||(LA6_52>='\u000B' && LA6_52<='\f')||(LA6_52>='\u000E' && LA6_52<='\u001F')||(LA6_52>='!' && LA6_52<='-')||(LA6_52>=':' && LA6_52<='@')||LA6_52=='['||(LA6_52>=']' && LA6_52<='`')||(LA6_52>='{' && LA6_52<='\uFFFF')) ) {s = 20;}

                        else s = 23;

                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA6_7 = input.LA(1);

                        s = -1;
                        if ( ((LA6_7>='\u0000' && LA6_7<='\b')||(LA6_7>='\u000B' && LA6_7<='\f')||(LA6_7>='\u000E' && LA6_7<='\u001F')||(LA6_7>='!' && LA6_7<='-')||(LA6_7>='0' && LA6_7<='[')||(LA6_7>=']' && LA6_7<='\uFFFF')) ) {s = 20;}

                        else s = 29;

                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA6_25 = input.LA(1);

                        s = -1;
                        if ( (LA6_25=='d') ) {s = 42;}

                        else if ( ((LA6_25>='0' && LA6_25<='9')||(LA6_25>='A' && LA6_25<='Z')||(LA6_25>='a' && LA6_25<='c')||(LA6_25>='e' && LA6_25<='z')) ) {s = 24;}

                        else if ( ((LA6_25>='\u0000' && LA6_25<='\b')||(LA6_25>='\u000B' && LA6_25<='\f')||(LA6_25>='\u000E' && LA6_25<='\u001F')||(LA6_25>='!' && LA6_25<='-')||(LA6_25>=':' && LA6_25<='@')||LA6_25=='['||(LA6_25>=']' && LA6_25<='`')||(LA6_25>='{' && LA6_25<='\uFFFF')) ) {s = 20;}

                        else s = 23;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 6, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}