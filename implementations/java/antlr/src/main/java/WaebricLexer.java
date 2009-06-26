// $ANTLR 3.1.2 /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g 2009-06-26 16:21:48

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
    public static final int STRCON=10;
    public static final int TEXTCHAR=7;
    public static final int EOF=-1;
    public static final int TYPE=6;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int IDCON=4;
    public static final int T__14=14;
    public static final int STRCHAR=9;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int SYMBOLCON=12;
    public static final int WHITESPACE=13;
    public static final int SYMBOLCHAR=11;
    public static final int TEXT=8;
    public static final int NATCON=5;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;

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

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:3:7: ( 'module' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:3:9: 'module'
            {
            match("module"); 


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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:4:7: ( 'end' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:4:9: 'end'
            {
            match("end"); 


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
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
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
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
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
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
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
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
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
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
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
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
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
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
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
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
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
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
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
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
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
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
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
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
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
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
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
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
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
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
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
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
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
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
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
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
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
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
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
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
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
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
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
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
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
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
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
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
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
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:30:7: ( '\"' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:30:9: '\"'
            {
            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:31:7: ( '<' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:31:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:32:7: ( '>' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:32:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "TYPE"
    public final void mTYPE() throws RecognitionException {
        try {
            int _type = TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:77:5: ( 'string' | 'list' | 'record' )
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:77:9: 'string'
                    {
                    match("string"); 


                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:77:20: 'list'
                    {
                    match("list"); 


                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:77:29: 'record'
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

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:80:5: ( '\"' ( TEXTCHAR )* '\"' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:80:9: '\"' ( TEXTCHAR )* '\"'
            {
            match('\"'); 
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:80:13: ( TEXTCHAR )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='\"') ) {
                    int LA2_1 = input.LA(2);

                    if ( (LA2_1=='\"'||LA2_1=='&'||LA2_1=='\\') ) {
                        alt2=1;
                    }


                }
                else if ( (LA2_0=='&'||LA2_0=='\\') ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:80:13: TEXTCHAR
            	    {
            	    mTEXTCHAR(); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TEXT"

    // $ANTLR start "TEXTCHAR"
    public final void mTEXTCHAR() throws RecognitionException {
        try {
            int _type = TEXTCHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:81:9: ( '\\\"' | '\\\\' | '\\&' ~ ( '#' | '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' | ':' ) | '&#' ( '0' .. '9' )+ ';' | '&#x' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ ';' | '&' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | ':' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' | '-' | '_' | ':' )* ';' )
            int alt6=6;
            switch ( input.LA(1) ) {
            case '\"':
                {
                alt6=1;
                }
                break;
            case '\\':
                {
                alt6=2;
                }
                break;
            case '&':
                {
                int LA6_3 = input.LA(2);

                if ( ((LA6_3>='\u0000' && LA6_3<='\"')||(LA6_3>='$' && LA6_3<='/')||(LA6_3>=';' && LA6_3<='@')||(LA6_3>='[' && LA6_3<='^')||LA6_3=='`'||(LA6_3>='{' && LA6_3<='\uFFFF')) ) {
                    alt6=3;
                }
                else if ( (LA6_3=='#') ) {
                    int LA6_5 = input.LA(3);

                    if ( (LA6_5=='x') ) {
                        alt6=5;
                    }
                    else if ( ((LA6_5>='0' && LA6_5<='9')) ) {
                        alt6=4;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 5, input);

                        throw nvae;
                    }
                }
                else if ( (LA6_3==':'||(LA6_3>='A' && LA6_3<='Z')||LA6_3=='_'||(LA6_3>='a' && LA6_3<='z')) ) {
                    alt6=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:81:12: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:82:4: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:83:4: '\\&' ~ ( '#' | '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' | ':' )
                    {
                    match('&'); 
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\"')||(input.LA(1)>='$' && input.LA(1)<='/')||(input.LA(1)>=';' && input.LA(1)<='@')||(input.LA(1)>='[' && input.LA(1)<='^')||input.LA(1)=='`'||(input.LA(1)>='{' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:84:4: '&#' ( '0' .. '9' )+ ';'
                    {
                    match("&#"); 

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:84:9: ( '0' .. '9' )+
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
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:84:10: '0' .. '9'
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

                    match(';'); 

                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:85:4: '&#x' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ ';'
                    {
                    match("&#x"); 

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:85:10: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='F')||(LA4_0>='a' && LA4_0<='f')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:
                    	    {
                    	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
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

                    match(';'); 

                    }
                    break;
                case 6 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:86:4: '&' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | ':' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' | '-' | '_' | ':' )* ';'
                    {
                    match('&'); 
                    if ( input.LA(1)==':'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:86:42: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' | '-' | '_' | ':' )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='-' && LA5_0<='.')||(LA5_0>='0' && LA5_0<=':')||(LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:
                    	    {
                    	    if ( (input.LA(1)>='-' && input.LA(1)<='.')||(input.LA(1)>='0' && input.LA(1)<=':')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    match(';'); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TEXTCHAR"

    // $ANTLR start "STRCON"
    public final void mSTRCON() throws RecognitionException {
        try {
            int _type = STRCON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:89:7: ( '\"' STRCHAR '\"' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:89:11: '\"' STRCHAR '\"'
            {
            match('\"'); 
            mSTRCHAR(); 
            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRCON"

    // $ANTLR start "STRCHAR"
    public final void mSTRCHAR() throws RecognitionException {
        try {
            int _type = STRCHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:90:8: ( '\\\\n' | '\\\\t' | '\\\\\\\\\"' | '\\\\\\\\\\\\\\\\' | '\\\\' 'a' ( '0' .. '9' ) 'b' ( '0' .. '9' ) 'c' ( '0' .. '9' ) )
            int alt7=5;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\\') ) {
                switch ( input.LA(2) ) {
                case 'n':
                    {
                    alt7=1;
                    }
                    break;
                case 't':
                    {
                    alt7=2;
                    }
                    break;
                case '\\':
                    {
                    int LA7_4 = input.LA(3);

                    if ( (LA7_4=='\"') ) {
                        alt7=3;
                    }
                    else if ( (LA7_4=='\\') ) {
                        alt7=4;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case 'a':
                    {
                    alt7=5;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:90:11: '\\\\n'
                    {
                    match("\\n"); 


                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:90:19: '\\\\t'
                    {
                    match("\\t"); 


                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:90:27: '\\\\\\\\\"'
                    {
                    match("\\\\\""); 


                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:90:37: '\\\\\\\\\\\\\\\\'
                    {
                    match("\\\\\\\\"); 


                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:91:4: '\\\\' 'a' ( '0' .. '9' ) 'b' ( '0' .. '9' ) 'c' ( '0' .. '9' )
                    {
                    match('\\'); 
                    match('a'); 
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:91:13: ( '0' .. '9' )
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:91:14: '0' .. '9'
                    {
                    matchRange('0','9'); 

                    }

                    match('b'); 
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:91:28: ( '0' .. '9' )
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:91:29: '0' .. '9'
                    {
                    matchRange('0','9'); 

                    }

                    match('c'); 
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:91:43: ( '0' .. '9' )
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:91:44: '0' .. '9'
                    {
                    matchRange('0','9'); 

                    }


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRCHAR"

    // $ANTLR start "SYMBOLCON"
    public final void mSYMBOLCON() throws RecognitionException {
        try {
            int _type = SYMBOLCON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:95:10: ( '\\'' ( SYMBOLCHAR )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:95:13: '\\'' ( SYMBOLCHAR )*
            {
            match('\''); 
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:95:18: ( SYMBOLCHAR )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\b')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\u001F')||(LA8_0>='!' && LA8_0<='(')||(LA8_0>='*' && LA8_0<='+')||(LA8_0>='-' && LA8_0<=':')||(LA8_0>='<' && LA8_0<='=')||(LA8_0>='?' && LA8_0<='|')||(LA8_0>='~' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:95:18: SYMBOLCHAR
            	    {
            	    mSYMBOLCHAR(); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SYMBOLCON"

    // $ANTLR start "SYMBOLCHAR"
    public final void mSYMBOLCHAR() throws RecognitionException {
        try {
            int _type = SYMBOLCHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:96:11: (~ ( ' ' | '\\t' | '\\n' | '\\r' | ';' | ',' | '>' | '}' | ')' ) )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:96:14: ~ ( ' ' | '\\t' | '\\n' | '\\r' | ';' | ',' | '>' | '}' | ')' )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\b')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||(input.LA(1)>='!' && input.LA(1)<='(')||(input.LA(1)>='*' && input.LA(1)<='+')||(input.LA(1)>='-' && input.LA(1)<=':')||(input.LA(1)>='<' && input.LA(1)<='=')||(input.LA(1)>='?' && input.LA(1)<='|')||(input.LA(1)>='~' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SYMBOLCHAR"

    // $ANTLR start "NATCON"
    public final void mNATCON() throws RecognitionException {
        try {
            int _type = NATCON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:99:7: ( ( '0' .. '9' )+ )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:99:11: ( '0' .. '9' )+
            {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:99:11: ( '0' .. '9' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:99:11: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NATCON"

    // $ANTLR start "IDCON"
    public final void mIDCON() throws RecognitionException {
        try {
            int _type = IDCON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:100:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:100:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:100:32: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='0' && LA10_0<='9')||(LA10_0>='A' && LA10_0<='Z')||(LA10_0>='a' && LA10_0<='z')) ) {
                    alt10=1;
                }


                switch (alt10) {
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
            	    break loop10;
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

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:105:11: ( ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+ )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:105:15: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:105:15: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\t' && LA11_0<='\n')||(LA11_0>='\f' && LA11_0<='\r')||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
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
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
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
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:8: ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | TYPE | TEXT | TEXTCHAR | STRCON | STRCHAR | SYMBOLCON | SYMBOLCHAR | NATCON | IDCON | WHITESPACE )
        int alt12=40;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:10: T__14
                {
                mT__14(); 

                }
                break;
            case 2 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:16: T__15
                {
                mT__15(); 

                }
                break;
            case 3 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:22: T__16
                {
                mT__16(); 

                }
                break;
            case 4 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:28: T__17
                {
                mT__17(); 

                }
                break;
            case 5 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:34: T__18
                {
                mT__18(); 

                }
                break;
            case 6 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:40: T__19
                {
                mT__19(); 

                }
                break;
            case 7 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:46: T__20
                {
                mT__20(); 

                }
                break;
            case 8 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:52: T__21
                {
                mT__21(); 

                }
                break;
            case 9 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:58: T__22
                {
                mT__22(); 

                }
                break;
            case 10 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:64: T__23
                {
                mT__23(); 

                }
                break;
            case 11 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:70: T__24
                {
                mT__24(); 

                }
                break;
            case 12 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:76: T__25
                {
                mT__25(); 

                }
                break;
            case 13 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:82: T__26
                {
                mT__26(); 

                }
                break;
            case 14 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:88: T__27
                {
                mT__27(); 

                }
                break;
            case 15 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:94: T__28
                {
                mT__28(); 

                }
                break;
            case 16 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:100: T__29
                {
                mT__29(); 

                }
                break;
            case 17 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:106: T__30
                {
                mT__30(); 

                }
                break;
            case 18 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:112: T__31
                {
                mT__31(); 

                }
                break;
            case 19 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:118: T__32
                {
                mT__32(); 

                }
                break;
            case 20 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:124: T__33
                {
                mT__33(); 

                }
                break;
            case 21 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:130: T__34
                {
                mT__34(); 

                }
                break;
            case 22 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:136: T__35
                {
                mT__35(); 

                }
                break;
            case 23 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:142: T__36
                {
                mT__36(); 

                }
                break;
            case 24 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:148: T__37
                {
                mT__37(); 

                }
                break;
            case 25 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:154: T__38
                {
                mT__38(); 

                }
                break;
            case 26 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:160: T__39
                {
                mT__39(); 

                }
                break;
            case 27 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:166: T__40
                {
                mT__40(); 

                }
                break;
            case 28 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:172: T__41
                {
                mT__41(); 

                }
                break;
            case 29 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:178: T__42
                {
                mT__42(); 

                }
                break;
            case 30 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:184: T__43
                {
                mT__43(); 

                }
                break;
            case 31 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:190: TYPE
                {
                mTYPE(); 

                }
                break;
            case 32 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:195: TEXT
                {
                mTEXT(); 

                }
                break;
            case 33 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:200: TEXTCHAR
                {
                mTEXTCHAR(); 

                }
                break;
            case 34 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:209: STRCON
                {
                mSTRCON(); 

                }
                break;
            case 35 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:216: STRCHAR
                {
                mSTRCHAR(); 

                }
                break;
            case 36 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:224: SYMBOLCON
                {
                mSYMBOLCON(); 

                }
                break;
            case 37 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:234: SYMBOLCHAR
                {
                mSYMBOLCHAR(); 

                }
                break;
            case 38 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:245: NATCON
                {
                mNATCON(); 

                }
                break;
            case 39 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:252: IDCON
                {
                mIDCON(); 

                }
                break;
            case 40 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:258: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\2\41\1\uffff\1\41\1\uffff\2\41\10\uffff\1\41\2\uffff\2"+
        "\41\2\uffff\1\76\2\uffff\1\41\1\103\1\41\1\uffff\3\41\2\uffff\1"+
        "\44\1\uffff\4\44\1\uffff\1\44\1\114\1\115\3\44\6\uffff\2\44\1\uffff"+
        "\2\44\6\uffff\1\44\4\uffff\1\44\1\131\4\44\2\uffff\2\44\1\140\1"+
        "\141\3\44\2\uffff\2\44\1\uffff\1\151\1\152\1\153\1\44\1\155\1\44"+
        "\2\uffff\1\157\2\44\1\77\1\uffff\2\44\3\uffff\1\44\1\uffff\1\44"+
        "\1\uffff\1\170\1\44\2\uffff\1\44\1\173\1\174\1\157\2\uffff\1\157"+
        "\2\uffff";
    static final String DFA12_eofS =
        "\175\uffff";
    static final String DFA12_minS =
        "\1\0\2\60\1\uffff\1\60\1\uffff\2\60\10\uffff\1\60\2\uffff\2\60\2"+
        "\uffff\1\42\2\uffff\1\60\1\134\1\0\1\uffff\2\60\1\11\2\uffff\1\144"+
        "\1\uffff\1\144\1\163\1\143\1\150\1\uffff\1\160\2\60\1\164\1\162"+
        "\1\146\6\uffff\1\164\1\163\1\uffff\1\141\1\145\2\uffff\1\42\3\uffff"+
        "\1\143\4\uffff\1\165\1\60\1\145\1\150\2\157\2\uffff\1\145\1\151"+
        "\2\60\2\164\1\154\1\uffff\1\42\1\157\1\154\1\uffff\3\60\1\162\1"+
        "\60\1\156\2\uffff\1\60\1\141\1\144\2\42\1\162\1\145\3\uffff\1\164"+
        "\1\uffff\1\147\1\uffff\1\60\1\73\1\uffff\1\42\1\144\3\60\2\uffff"+
        "\1\60\2\uffff";
    static final String DFA12_maxS =
        "\1\uffff\2\172\1\uffff\1\172\1\uffff\2\172\10\uffff\1\172\2\uffff"+
        "\2\172\2\uffff\1\134\2\uffff\1\172\1\164\1\uffff\1\uffff\1\71\1"+
        "\172\1\40\2\uffff\1\144\1\uffff\1\144\1\163\1\143\1\150\1\uffff"+
        "\1\160\2\172\1\164\1\162\1\146\6\uffff\1\164\1\163\1\uffff\1\141"+
        "\1\145\2\uffff\1\164\3\uffff\1\143\4\uffff\1\165\1\172\1\145\1\150"+
        "\2\157\2\uffff\1\145\1\151\2\172\2\164\1\154\1\uffff\1\134\1\157"+
        "\1\154\1\uffff\3\172\1\162\1\172\1\156\2\uffff\1\172\1\141\1\144"+
        "\1\42\1\134\1\162\1\145\3\uffff\1\164\1\uffff\1\147\1\uffff\1\172"+
        "\1\73\1\uffff\1\134\1\144\3\172\2\uffff\1\172\2\uffff";
    static final String DFA12_acceptS =
        "\3\uffff\1\3\1\uffff\1\5\2\uffff\1\10\1\11\1\12\1\13\1\14\1\15\1"+
        "\16\1\17\1\uffff\1\25\1\26\2\uffff\1\32\1\33\1\uffff\1\35\1\36\3"+
        "\uffff\1\44\3\uffff\1\45\1\50\1\uffff\1\47\4\uffff\1\3\6\uffff\1"+
        "\10\1\13\1\14\1\15\1\16\1\17\2\uffff\1\25\2\uffff\1\32\1\33\1\uffff"+
        "\1\34\1\40\1\35\1\uffff\1\43\1\41\1\44\1\46\6\uffff\1\20\1\24\7"+
        "\uffff\1\42\3\uffff\1\2\6\uffff\1\7\1\23\7\uffff\1\21\1\22\1\27"+
        "\1\uffff\1\6\1\uffff\1\37\2\uffff\1\40\5\uffff\1\30\1\31\1\uffff"+
        "\1\1\1\4";
    static final String DFA12_specialS =
        "\1\1\33\uffff\1\0\140\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\41\2\42\1\41\1\40\1\42\22\41\1\42\1\26\1\27\1\13\1\14\1"+
            "\17\1\34\1\35\1\10\1\12\2\41\1\11\1\41\1\3\1\41\12\36\1\15\1"+
            "\5\1\30\1\25\1\31\1\41\1\16\32\37\1\41\1\33\4\41\2\37\1\23\1"+
            "\7\1\2\3\37\1\4\2\37\1\20\1\1\4\37\1\32\1\6\5\37\1\24\1\37\1"+
            "\21\1\41\1\22\uff82\41",
            "\12\44\7\uffff\32\44\6\uffff\16\44\1\43\13\44",
            "\12\44\7\uffff\32\44\6\uffff\1\47\1\44\1\50\10\44\1\46\1\44"+
            "\1\45\14\44",
            "",
            "\12\44\7\uffff\32\44\6\uffff\5\44\1\53\6\44\1\52\1\54\14\44",
            "",
            "\12\44\7\uffff\32\44\6\uffff\10\44\1\55\12\44\1\56\6\44",
            "\12\44\7\uffff\32\44\6\uffff\4\44\1\57\25\44",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\44\7\uffff\32\44\6\uffff\4\44\1\66\3\44\1\67\21\44",
            "",
            "",
            "\12\44\7\uffff\32\44\6\uffff\3\44\1\71\26\44",
            "\12\44\7\uffff\32\44\6\uffff\10\44\1\72\21\44",
            "",
            "",
            "\1\77\3\uffff\1\77\65\uffff\1\75",
            "",
            "",
            "\12\44\7\uffff\32\44\6\uffff\4\44\1\101\25\44",
            "\1\102\4\uffff\1\102\14\uffff\1\102\5\uffff\1\102",
            "\60\103\12\uffff\uffc6\103",
            "",
            "\12\105",
            "\12\44\7\uffff\32\44\6\uffff\32\44",
            "\2\42\1\uffff\2\42\22\uffff\1\42",
            "",
            "",
            "\1\106",
            "",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "",
            "\1\113",
            "\12\44\7\uffff\32\44\6\uffff\32\44",
            "\12\44\7\uffff\32\44\6\uffff\32\44",
            "\1\116",
            "\1\117",
            "\1\120",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\121",
            "\1\122",
            "",
            "\1\123",
            "\1\124",
            "",
            "",
            "\1\77\3\uffff\1\77\65\uffff\1\126\4\uffff\1\125\14\uffff\1"+
            "\125\5\uffff\1\125",
            "",
            "",
            "",
            "\1\127",
            "",
            "",
            "",
            "",
            "\1\130",
            "\12\44\7\uffff\32\44\6\uffff\32\44",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "",
            "",
            "\1\136",
            "\1\137",
            "\12\44\7\uffff\32\44\6\uffff\32\44",
            "\12\44\7\uffff\32\44\6\uffff\32\44",
            "\1\142",
            "\1\143",
            "\1\144",
            "",
            "\1\145\3\uffff\1\77\65\uffff\1\146",
            "\1\147",
            "\1\150",
            "",
            "\12\44\7\uffff\32\44\6\uffff\32\44",
            "\12\44\7\uffff\32\44\6\uffff\32\44",
            "\12\44\7\uffff\32\44\6\uffff\32\44",
            "\1\154",
            "\12\44\7\uffff\32\44\6\uffff\32\44",
            "\1\156",
            "",
            "",
            "\12\44\7\uffff\32\44\6\uffff\32\44",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\77\3\uffff\1\77\65\uffff\1\163",
            "\1\164",
            "\1\165",
            "",
            "",
            "",
            "\1\166",
            "",
            "\1\167",
            "",
            "\12\44\7\uffff\32\44\6\uffff\32\44",
            "\1\171",
            "",
            "\1\162\3\uffff\1\77\65\uffff\1\77",
            "\1\172",
            "\12\44\7\uffff\32\44\6\uffff\32\44",
            "\12\44\7\uffff\32\44\6\uffff\32\44",
            "\12\44\7\uffff\32\44\6\uffff\32\44",
            "",
            "",
            "\12\44\7\uffff\32\44\6\uffff\32\44",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | TYPE | TEXT | TEXTCHAR | STRCON | STRCHAR | SYMBOLCON | SYMBOLCHAR | NATCON | IDCON | WHITESPACE );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_28 = input.LA(1);

                        s = -1;
                        if ( ((LA12_28>='\u0000' && LA12_28<='/')||(LA12_28>=':' && LA12_28<='\uFFFF')) ) {s = 67;}

                        else s = 33;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_0 = input.LA(1);

                        s = -1;
                        if ( (LA12_0=='m') ) {s = 1;}

                        else if ( (LA12_0=='e') ) {s = 2;}

                        else if ( (LA12_0=='.') ) {s = 3;}

                        else if ( (LA12_0=='i') ) {s = 4;}

                        else if ( (LA12_0==';') ) {s = 5;}

                        else if ( (LA12_0=='s') ) {s = 6;}

                        else if ( (LA12_0=='d') ) {s = 7;}

                        else if ( (LA12_0=='(') ) {s = 8;}

                        else if ( (LA12_0==',') ) {s = 9;}

                        else if ( (LA12_0==')') ) {s = 10;}

                        else if ( (LA12_0=='#') ) {s = 11;}

                        else if ( (LA12_0=='$') ) {s = 12;}

                        else if ( (LA12_0==':') ) {s = 13;}

                        else if ( (LA12_0=='@') ) {s = 14;}

                        else if ( (LA12_0=='%') ) {s = 15;}

                        else if ( (LA12_0=='l') ) {s = 16;}

                        else if ( (LA12_0=='{') ) {s = 17;}

                        else if ( (LA12_0=='}') ) {s = 18;}

                        else if ( (LA12_0=='c') ) {s = 19;}

                        else if ( (LA12_0=='y') ) {s = 20;}

                        else if ( (LA12_0=='=') ) {s = 21;}

                        else if ( (LA12_0=='!') ) {s = 22;}

                        else if ( (LA12_0=='\"') ) {s = 23;}

                        else if ( (LA12_0=='<') ) {s = 24;}

                        else if ( (LA12_0=='>') ) {s = 25;}

                        else if ( (LA12_0=='r') ) {s = 26;}

                        else if ( (LA12_0=='\\') ) {s = 27;}

                        else if ( (LA12_0=='&') ) {s = 28;}

                        else if ( (LA12_0=='\'') ) {s = 29;}

                        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {s = 30;}

                        else if ( ((LA12_0>='A' && LA12_0<='Z')||(LA12_0>='a' && LA12_0<='b')||(LA12_0>='f' && LA12_0<='h')||(LA12_0>='j' && LA12_0<='k')||(LA12_0>='n' && LA12_0<='q')||(LA12_0>='t' && LA12_0<='x')||LA12_0=='z') ) {s = 31;}

                        else if ( (LA12_0=='\f') ) {s = 32;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||LA12_0=='\u000B'||(LA12_0>='\u000E' && LA12_0<='\u001F')||(LA12_0>='*' && LA12_0<='+')||LA12_0=='-'||LA12_0=='/'||LA12_0=='?'||LA12_0=='['||(LA12_0>=']' && LA12_0<='`')||LA12_0=='|'||(LA12_0>='~' && LA12_0<='\uFFFF')) ) {s = 33;}

                        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {s = 34;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}