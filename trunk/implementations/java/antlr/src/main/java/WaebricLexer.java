// $ANTLR 3.1.2 /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g 2009-06-26 15:25:12

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class WaebricLexer extends Lexer {
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int WHITESPACE=7;
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int T__8=8;
    public static final int NATCON=5;
    public static final int TYPE=6;
    public static final int T__19=19;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__16=16;
    public static final int T__33=33;
    public static final int T__15=15;
    public static final int T__34=34;
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

    public WaebricLexer() {;} 
    public WaebricLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public WaebricLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g"; }

    // $ANTLR start "T__8"
    public final void mT__8() throws RecognitionException {
        try {
            int _type = T__8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:3:6: ( 'module' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:3:8: 'module'
            {
            match("module"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__8"

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:4:6: ( 'end' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:4:8: 'end'
            {
            match("end"); 


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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:5:7: ( '.' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:5:9: '.'
            {
            match('.'); 

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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:6:7: ( 'import' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:6:9: 'import'
            {
            match("import"); 


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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:7:7: ( ';' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:7:9: ';'
            {
            match(';'); 

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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:8:7: ( 'site' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:8:9: 'site'
            {
            match("site"); 


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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:9:7: ( 'def' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:9:9: 'def'
            {
            match("def"); 


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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:10:7: ( '(' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:10:9: '('
            {
            match('('); 

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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:11:7: ( ',' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:11:9: ','
            {
            match(','); 

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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:12:7: ( ')' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:12:9: ')'
            {
            match(')'); 

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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:13:7: ( '#' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:13:9: '#'
            {
            match('#'); 

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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:14:7: ( '$' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:14:9: '$'
            {
            match('$'); 

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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:15:7: ( ':' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:15:9: ':'
            {
            match(':'); 

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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:16:7: ( '@' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:16:9: '@'
            {
            match('@'); 

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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:17:7: ( '%' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:17:9: '%'
            {
            match('%'); 

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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:18:7: ( 'if' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:18:9: 'if'
            {
            match("if"); 


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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:19:7: ( 'else' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:19:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:20:7: ( 'each' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:20:9: 'each'
            {
            match("each"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:21:7: ( 'let' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:21:9: 'let'
            {
            match("let"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:22:7: ( 'in' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:22:9: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:23:7: ( '{' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:23:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:24:7: ( '}' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:24:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:25:7: ( 'echo' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:25:9: 'echo'
            {
            match("echo"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:26:7: ( 'cdata' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:26:9: 'cdata'
            {
            match("cdata"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:27:7: ( 'yield;' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:27:9: 'yield;'
            {
            match("yield;"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:28:7: ( '=' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:28:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:29:7: ( '!' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:29:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "TYPE"
    public final void mTYPE() throws RecognitionException {
        try {
            int _type = TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:68:5: ( 'string' | 'list' | 'record' )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 's':
                {
                alt1=1;
                }
                break;
            case 'l':
                {
                alt1=2;
                }
                break;
            case 'r':
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:68:9: 'string'
                    {
                    match("string"); 


                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:68:20: 'list'
                    {
                    match("list"); 


                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:68:29: 'record'
                    {
                    match("record"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TYPE"

    // $ANTLR start "IDCON"
    public final void mIDCON() throws RecognitionException {
        try {
            int _type = IDCON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:70:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:70:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:70:32: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:
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
            	    break loop2;
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:71:7: ( ( '0' .. '9' )+ )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:71:11: ( '0' .. '9' )+
            {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:71:11: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:71:11: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NATCON"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:76:11: ( ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+ )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:76:15: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:76:15: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='\t' && LA4_0<='\n')||(LA4_0>='\f' && LA4_0<='\r')||LA4_0==' ') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:
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
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
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
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:8: ( T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | TYPE | IDCON | NATCON | WHITESPACE )
        int alt5=31;
        alt5 = dfa5.predict(input);
        switch (alt5) {
            case 1 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:10: T__8
                {
                mT__8(); 

                }
                break;
            case 2 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:15: T__9
                {
                mT__9(); 

                }
                break;
            case 3 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:20: T__10
                {
                mT__10(); 

                }
                break;
            case 4 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:26: T__11
                {
                mT__11(); 

                }
                break;
            case 5 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:32: T__12
                {
                mT__12(); 

                }
                break;
            case 6 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:38: T__13
                {
                mT__13(); 

                }
                break;
            case 7 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:44: T__14
                {
                mT__14(); 

                }
                break;
            case 8 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:50: T__15
                {
                mT__15(); 

                }
                break;
            case 9 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:56: T__16
                {
                mT__16(); 

                }
                break;
            case 10 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:62: T__17
                {
                mT__17(); 

                }
                break;
            case 11 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:68: T__18
                {
                mT__18(); 

                }
                break;
            case 12 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:74: T__19
                {
                mT__19(); 

                }
                break;
            case 13 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:80: T__20
                {
                mT__20(); 

                }
                break;
            case 14 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:86: T__21
                {
                mT__21(); 

                }
                break;
            case 15 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:92: T__22
                {
                mT__22(); 

                }
                break;
            case 16 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:98: T__23
                {
                mT__23(); 

                }
                break;
            case 17 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:104: T__24
                {
                mT__24(); 

                }
                break;
            case 18 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:110: T__25
                {
                mT__25(); 

                }
                break;
            case 19 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:116: T__26
                {
                mT__26(); 

                }
                break;
            case 20 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:122: T__27
                {
                mT__27(); 

                }
                break;
            case 21 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:128: T__28
                {
                mT__28(); 

                }
                break;
            case 22 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:134: T__29
                {
                mT__29(); 

                }
                break;
            case 23 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:140: T__30
                {
                mT__30(); 

                }
                break;
            case 24 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:146: T__31
                {
                mT__31(); 

                }
                break;
            case 25 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:152: T__32
                {
                mT__32(); 

                }
                break;
            case 26 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:158: T__33
                {
                mT__33(); 

                }
                break;
            case 27 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:164: T__34
                {
                mT__34(); 

                }
                break;
            case 28 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:170: TYPE
                {
                mTYPE(); 

                }
                break;
            case 29 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:175: IDCON
                {
                mIDCON(); 

                }
                break;
            case 30 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:181: NATCON
                {
                mNATCON(); 

                }
                break;
            case 31 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:188: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;

        }

    }


    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA5_eotS =
        "\1\uffff\2\30\1\uffff\1\30\1\uffff\2\30\10\uffff\1\30\2\uffff\2"+
        "\30\2\uffff\1\30\3\uffff\6\30\1\61\1\62\11\30\1\74\4\30\2\uffff"+
        "\2\30\1\103\1\104\5\30\1\uffff\1\112\1\113\1\114\1\30\1\116\1\30"+
        "\2\uffff\1\120\4\30\3\uffff\1\30\1\uffff\1\30\1\uffff\1\127\2\30"+
        "\1\132\1\133\1\120\2\uffff\1\120\2\uffff";
    static final String DFA5_eofS =
        "\134\uffff";
    static final String DFA5_minS =
        "\1\11\1\157\1\141\1\uffff\1\146\1\uffff\1\151\1\145\10\uffff\1\145"+
        "\2\uffff\1\144\1\151\2\uffff\1\145\3\uffff\2\144\1\163\1\143\1\150"+
        "\1\160\2\60\1\164\1\162\1\146\1\164\1\163\1\141\1\145\1\143\1\165"+
        "\1\60\1\145\1\150\2\157\2\uffff\1\145\1\151\2\60\2\164\1\154\1\157"+
        "\1\154\1\uffff\3\60\1\162\1\60\1\156\2\uffff\1\60\1\141\1\144\1"+
        "\162\1\145\3\uffff\1\164\1\uffff\1\147\1\uffff\1\60\1\73\1\144\3"+
        "\60\2\uffff\1\60\2\uffff";
    static final String DFA5_maxS =
        "\1\175\1\157\1\156\1\uffff\1\156\1\uffff\1\164\1\145\10\uffff\1"+
        "\151\2\uffff\1\144\1\151\2\uffff\1\145\3\uffff\2\144\1\163\1\143"+
        "\1\150\1\160\2\172\1\164\1\162\1\146\1\164\1\163\1\141\1\145\1\143"+
        "\1\165\1\172\1\145\1\150\2\157\2\uffff\1\145\1\151\2\172\2\164\1"+
        "\154\1\157\1\154\1\uffff\3\172\1\162\1\172\1\156\2\uffff\1\172\1"+
        "\141\1\144\1\162\1\145\3\uffff\1\164\1\uffff\1\147\1\uffff\1\172"+
        "\1\73\1\144\3\172\2\uffff\1\172\2\uffff";
    static final String DFA5_acceptS =
        "\3\uffff\1\3\1\uffff\1\5\2\uffff\1\10\1\11\1\12\1\13\1\14\1\15\1"+
        "\16\1\17\1\uffff\1\25\1\26\2\uffff\1\32\1\33\1\uffff\1\35\1\36\1"+
        "\37\26\uffff\1\20\1\24\11\uffff\1\2\6\uffff\1\7\1\23\5\uffff\1\21"+
        "\1\22\1\27\1\uffff\1\6\1\uffff\1\34\6\uffff\1\30\1\31\1\uffff\1"+
        "\1\1\4";
    static final String DFA5_specialS =
        "\134\uffff}>";
    static final String[] DFA5_transitionS = {
            "\2\32\1\uffff\2\32\22\uffff\1\32\1\26\1\uffff\1\13\1\14\1\17"+
            "\2\uffff\1\10\1\12\2\uffff\1\11\1\uffff\1\3\1\uffff\12\31\1"+
            "\15\1\5\1\uffff\1\25\2\uffff\1\16\32\30\6\uffff\2\30\1\23\1"+
            "\7\1\2\3\30\1\4\2\30\1\20\1\1\4\30\1\27\1\6\5\30\1\24\1\30\1"+
            "\21\1\uffff\1\22",
            "\1\33",
            "\1\36\1\uffff\1\37\10\uffff\1\35\1\uffff\1\34",
            "",
            "\1\41\6\uffff\1\40\1\42",
            "",
            "\1\43\12\uffff\1\44",
            "\1\45",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\46\3\uffff\1\47",
            "",
            "",
            "\1\50",
            "\1\51",
            "",
            "",
            "\1\52",
            "",
            "",
            "",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\60",
            "\12\30\7\uffff\32\30\6\uffff\32\30",
            "\12\30\7\uffff\32\30\6\uffff\32\30",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\12\30\7\uffff\32\30\6\uffff\32\30",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "",
            "",
            "\1\101",
            "\1\102",
            "\12\30\7\uffff\32\30\6\uffff\32\30",
            "\12\30\7\uffff\32\30\6\uffff\32\30",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "",
            "\12\30\7\uffff\32\30\6\uffff\32\30",
            "\12\30\7\uffff\32\30\6\uffff\32\30",
            "\12\30\7\uffff\32\30\6\uffff\32\30",
            "\1\115",
            "\12\30\7\uffff\32\30\6\uffff\32\30",
            "\1\117",
            "",
            "",
            "\12\30\7\uffff\32\30\6\uffff\32\30",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "",
            "",
            "",
            "\1\125",
            "",
            "\1\126",
            "",
            "\12\30\7\uffff\32\30\6\uffff\32\30",
            "\1\130",
            "\1\131",
            "\12\30\7\uffff\32\30\6\uffff\32\30",
            "\12\30\7\uffff\32\30\6\uffff\32\30",
            "\12\30\7\uffff\32\30\6\uffff\32\30",
            "",
            "",
            "\12\30\7\uffff\32\30\6\uffff\32\30",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | TYPE | IDCON | NATCON | WHITESPACE );";
        }
    }
 

}