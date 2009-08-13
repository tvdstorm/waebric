// $ANTLR 3.1.2 /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g 2009-08-13 15:16:52

	package org.cwi.waebric;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class WaebricLexer extends Lexer {
    public static final int T__64=64;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int LETTER=17;
    public static final int AMP=27;
    public static final int ESCLAYOUT=23;
    public static final int PATHELEMENT=20;
    public static final int PRETEXT=10;
    public static final int STRCON=9;
    public static final int TEXTCHAR=25;
    public static final int T__61=61;
    public static final int POSTTEXT=11;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int FILEEXT=21;
    public static final int T__52=52;
    public static final int COMMENTS=31;
    public static final int CHARREF=28;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int IDCON=4;
    public static final int PATH=5;
    public static final int T__59=59;
    public static final int STRCHAR=22;
    public static final int DIGIT=18;
    public static final int COMMENT=13;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int MIDTEXT=12;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int SYMBOLCON=8;
    public static final int SITE=14;
    public static final int HEXADECIMAL=19;
    public static final int SEMICOLON=16;
    public static final int SYMBOLCHAR=30;
    public static final int TEXT=7;
    public static final int LAYOUT=32;
    public static final int NATCON=6;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int DECIMAL=24;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int ENTREF=29;
    public static final int ESCQUOTE=26;
    public static final int END=15;

    	// Maintain context information
    	private boolean inSite = false;
    	private boolean inPath = false;
    	private boolean inString = false;


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

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:13:7: ( 'module' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:13:9: 'module'
            {
            match("module"); 


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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:14:7: ( '.' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:14:9: '.'
            {
            match('.'); 

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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:15:7: ( 'import' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:15:9: 'import'
            {
            match("import"); 


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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:16:7: ( ':' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:16:9: ':'
            {
            match(':'); 

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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:17:7: ( '#' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:17:9: '#'
            {
            match('#'); 

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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:18:7: ( '$' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:18:9: '$'
            {
            match('$'); 

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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:19:7: ( '@' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:19:9: '@'
            {
            match('@'); 

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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:20:7: ( '%' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:20:9: '%'
            {
            match('%'); 

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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:21:7: ( '(' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:21:9: '('
            {
            match('('); 

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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:22:7: ( ',' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:22:9: ','
            {
            match(','); 

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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:23:7: ( ')' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:23:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:24:7: ( '[' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:24:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:25:7: ( ']' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:25:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:26:7: ( '{' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:26:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:27:7: ( '}' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:27:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:28:7: ( '+' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:28:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:29:7: ( 'def' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:29:9: 'def'
            {
            match("def"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:30:7: ( 'if' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:30:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:31:7: ( 'else' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:31:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:32:7: ( 'each' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:32:9: 'each'
            {
            match("each"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:33:7: ( 'let' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:33:9: 'let'
            {
            match("let"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:34:7: ( 'in' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:34:9: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:35:7: ( 'echo' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:35:9: 'echo'
            {
            match("echo"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:36:7: ( 'cdata' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:36:9: 'cdata'
            {
            match("cdata"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:37:7: ( 'yield;' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:37:9: 'yield;'
            {
            match("yield;"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:38:7: ( '=' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:38:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:39:7: ( '!' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:39:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:40:7: ( '&&' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:40:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:41:7: ( '||' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:41:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:42:7: ( 'list' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:42:9: 'list'
            {
            match("list"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:43:7: ( 'record' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:43:9: 'record'
            {
            match("record"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:44:7: ( 'string' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:44:9: 'string'
            {
            match("string"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:145:9: ( 'comment' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:145:12: 'comment'
            {
            match("comment"); 

             inString = true; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "SITE"
    public final void mSITE() throws RecognitionException {
        try {
            int _type = SITE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:146:5: ( 'site' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:146:9: 'site'
            {
            match("site"); 

             inSite = true; inPath = true; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SITE"

    // $ANTLR start "END"
    public final void mEND() throws RecognitionException {
        try {
            int _type = END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:147:4: ( 'end' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:147:8: 'end'
            {
            match("end"); 

             inSite = false; inPath = false; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "END"

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:148:10: ( ';' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:148:13: ';'
            {
            match(';'); 
             inPath = inSite; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMICOLON"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:150:16: ( 'a' .. 'z' | 'A' .. 'Z' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:151:15: ( '0' .. '9' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:151:18: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "HEXADECIMAL"
    public final void mHEXADECIMAL() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:152:21: ( ( 'a' .. 'f' | 'A' .. 'F' | DIGIT )+ )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:152:23: ( 'a' .. 'f' | 'A' .. 'F' | DIGIT )+
            {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:152:23: ( 'a' .. 'f' | 'A' .. 'F' | DIGIT )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='F')||(LA1_0>='a' && LA1_0<='f')) ) {
                    alt1=1;
                }


                switch (alt1) {
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
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "HEXADECIMAL"

    // $ANTLR start "PATH"
    public final void mPATH() throws RecognitionException {
        try {
            int _type = PATH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:154:5: ({...}? => ( PATHELEMENT '/' )* PATHELEMENT '.' FILEEXT )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:154:9: {...}? => ( PATHELEMENT '/' )* PATHELEMENT '.' FILEEXT
            {
            if ( !(( inPath )) ) {
                throw new FailedPredicateException(input, "PATH", " inPath ");
            }
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:154:24: ( PATHELEMENT '/' )*
            loop2:
            do {
                int alt2=2;
                alt2 = dfa2.predict(input);
                switch (alt2) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:154:26: PATHELEMENT '/'
            	    {
            	    mPATHELEMENT(); 
            	    match('/'); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            mPATHELEMENT(); 
            match('.'); 
            mFILEEXT(); 
             inPath = false; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PATH"

    // $ANTLR start "PATHELEMENT"
    public final void mPATHELEMENT() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:155:21: ( ( LETTER | DIGIT | '%' )+ )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:155:23: ( LETTER | DIGIT | '%' )+
            {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:155:23: ( LETTER | DIGIT | '%' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='%'||(LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:
            	    {
            	    if ( input.LA(1)=='%'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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

        }
        finally {
        }
    }
    // $ANTLR end "PATHELEMENT"

    // $ANTLR start "FILEEXT"
    public final void mFILEEXT() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:156:17: ( ( LETTER | DIGIT )+ )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:156:19: ( LETTER | DIGIT )+
            {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:156:19: ( LETTER | DIGIT )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
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
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "FILEEXT"

    // $ANTLR start "STRCON"
    public final void mSTRCON() throws RecognitionException {
        try {
            int _type = STRCON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:158:7: ({...}? => '\\\"' ( STRCHAR )* '\\\"' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:158:11: {...}? => '\\\"' ( STRCHAR )* '\\\"'
            {
            if ( !(( inString )) ) {
                throw new FailedPredicateException(input, "STRCON", " inString ");
            }
            match('\"'); 
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:158:33: ( STRCHAR )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=' ' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:158:33: STRCHAR
            	    {
            	    mSTRCHAR(); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match('\"'); 
             inString = false; 

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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:159:17: (~ ( '\\u0000' .. '\\u001F' | '\"' | '\\\\' ) | ESCLAYOUT | DECIMAL )
            int alt6=3;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=' ' && LA6_0<='!')||(LA6_0>='#' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFF')) ) {
                alt6=1;
            }
            else if ( (LA6_0=='\\') ) {
                int LA6_2 = input.LA(2);

                if ( (LA6_2=='\\') ) {
                    int LA6_3 = input.LA(3);

                    if ( (LA6_3=='\"'||LA6_3=='\\'||LA6_3=='n'||LA6_3=='t') ) {
                        alt6=2;
                    }
                    else if ( (LA6_3=='a') ) {
                        alt6=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:159:19: ~ ( '\\u0000' .. '\\u001F' | '\"' | '\\\\' )
                    {
                    if ( (input.LA(1)>=' ' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:159:58: ESCLAYOUT
                    {
                    mESCLAYOUT(); 

                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:159:70: DECIMAL
                    {
                    mDECIMAL(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "STRCHAR"

    // $ANTLR start "ESCLAYOUT"
    public final void mESCLAYOUT() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:160:19: ( '\\\\\\\\n' | '\\\\\\\\t' | '\\\\\\\\\"' | '\\\\\\\\\\\\\\\\' )
            int alt7=4;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\\') ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1=='\\') ) {
                    switch ( input.LA(3) ) {
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
                    case '\"':
                        {
                        alt7=3;
                        }
                        break;
                    case '\\':
                        {
                        alt7=4;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 2, input);

                        throw nvae;
                    }

                }
                else {
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:160:21: '\\\\\\\\n'
                    {
                    match("\\\\n"); 


                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:160:31: '\\\\\\\\t'
                    {
                    match("\\\\t"); 


                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:160:41: '\\\\\\\\\"'
                    {
                    match("\\\\\""); 


                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:160:51: '\\\\\\\\\\\\\\\\'
                    {
                    match("\\\\\\\\"); 


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "ESCLAYOUT"

    // $ANTLR start "DECIMAL"
    public final void mDECIMAL() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:161:17: ( '\\\\\\\\' 'a:' DIGIT 'b:' DIGIT 'c:' DIGIT )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:161:19: '\\\\\\\\' 'a:' DIGIT 'b:' DIGIT 'c:' DIGIT
            {
            match("\\\\"); 

            match("a:"); 

            mDIGIT(); 
            match("b:"); 

            mDIGIT(); 
            match("c:"); 

            mDIGIT(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DECIMAL"

    // $ANTLR start "PRETEXT"
    public final void mPRETEXT() throws RecognitionException {
        try {
            int _type = PRETEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:163:8: ( '\"' ( TEXTCHAR )* '<' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:163:11: '\"' ( TEXTCHAR )* '<'
            {
            match('\"'); 
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:163:15: ( TEXTCHAR )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\t' && LA8_0<='\n')||LA8_0=='\r'||(LA8_0>=' ' && LA8_0<='!')||(LA8_0>='#' && LA8_0<=';')||(LA8_0>='=' && LA8_0<='\u007F')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:163:15: TEXTCHAR
            	    {
            	    mTEXTCHAR(); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PRETEXT"

    // $ANTLR start "POSTTEXT"
    public final void mPOSTTEXT() throws RecognitionException {
        try {
            int _type = POSTTEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:164:9: ( '>' ( TEXTCHAR )* '\"' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:164:12: '>' ( TEXTCHAR )* '\"'
            {
            match('>'); 
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:164:16: ( TEXTCHAR )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\t' && LA9_0<='\n')||LA9_0=='\r'||(LA9_0>=' ' && LA9_0<='!')||(LA9_0>='#' && LA9_0<=';')||(LA9_0>='=' && LA9_0<='\u007F')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:164:16: TEXTCHAR
            	    {
            	    mTEXTCHAR(); 

            	    }
            	    break;

            	default :
            	    break loop9;
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
    // $ANTLR end "POSTTEXT"

    // $ANTLR start "MIDTEXT"
    public final void mMIDTEXT() throws RecognitionException {
        try {
            int _type = MIDTEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:165:8: ( '>' ( TEXTCHAR )* '<' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:165:11: '>' ( TEXTCHAR )* '<'
            {
            match('>'); 
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:165:15: ( TEXTCHAR )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\t' && LA10_0<='\n')||LA10_0=='\r'||(LA10_0>=' ' && LA10_0<='!')||(LA10_0>='#' && LA10_0<=';')||(LA10_0>='=' && LA10_0<='\u007F')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:165:15: TEXTCHAR
            	    {
            	    mTEXTCHAR(); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MIDTEXT"

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:167:5: ( '\\\"' ( TEXTCHAR )* '\\\"' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:167:9: '\\\"' ( TEXTCHAR )* '\\\"'
            {
            match('\"'); 
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:167:14: ( TEXTCHAR )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||(LA11_0>=' ' && LA11_0<='!')||(LA11_0>='#' && LA11_0<=';')||(LA11_0>='=' && LA11_0<='\u007F')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:167:14: TEXTCHAR
            	    {
            	    mTEXTCHAR(); 

            	    }
            	    break;

            	default :
            	    break loop11;
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:168:18: (~ ( '\\u0000' .. '\\u001F' | '&' | '\"' | '<' | '\\u0080' .. '\\uFFFF' ) | '\\n' | '\\r' | '\\t' | ESCQUOTE | AMP | CHARREF | ENTREF )
            int alt12=8;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:168:20: ~ ( '\\u0000' .. '\\u001F' | '&' | '\"' | '<' | '\\u0080' .. '\\uFFFF' )
                    {
                    if ( (input.LA(1)>=' ' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='%')||(input.LA(1)>='\'' && input.LA(1)<=';')||(input.LA(1)>='=' && input.LA(1)<='\u007F') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:169:5: '\\n'
                    {
                    match('\n'); 

                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:169:12: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:169:19: '\\t'
                    {
                    match('\t'); 

                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:169:26: ESCQUOTE
                    {
                    mESCQUOTE(); 

                    }
                    break;
                case 6 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:169:37: AMP
                    {
                    mAMP(); 

                    }
                    break;
                case 7 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:169:43: CHARREF
                    {
                    mCHARREF(); 

                    }
                    break;
                case 8 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:169:53: ENTREF
                    {
                    mENTREF(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "TEXTCHAR"

    // $ANTLR start "ESCQUOTE"
    public final void mESCQUOTE() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:170:18: ( '\\\\\\\\' | '\\\\\"' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='\\') ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1=='\\') ) {
                    alt13=1;
                }
                else if ( (LA13_1=='\"') ) {
                    alt13=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:170:20: '\\\\\\\\'
                    {
                    match("\\\\"); 


                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:170:29: '\\\\\"'
                    {
                    match("\\\""); 


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "ESCQUOTE"

    // $ANTLR start "AMP"
    public final void mAMP() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:171:13: ( '\\&' (~ ( '#' | '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' | ':' ) )+ )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:171:16: '\\&' (~ ( '#' | '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' | ':' ) )+
            {
            match('&'); 
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:171:21: (~ ( '#' | '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' | ':' ) )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='\u0000' && LA14_0<='\"')||(LA14_0>='$' && LA14_0<='/')||(LA14_0>=';' && LA14_0<='@')||(LA14_0>='[' && LA14_0<='^')||LA14_0=='`'||(LA14_0>='{' && LA14_0<='\uFFFF')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:171:21: ~ ( '#' | '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' | ':' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\"')||(input.LA(1)>='$' && input.LA(1)<='/')||(input.LA(1)>=';' && input.LA(1)<='@')||(input.LA(1)>='[' && input.LA(1)<='^')||input.LA(1)=='`'||(input.LA(1)>='{' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "AMP"

    // $ANTLR start "CHARREF"
    public final void mCHARREF() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:172:17: ( '&#' ( DIGIT )+ ';' | '&#x' HEXADECIMAL ';' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='&') ) {
                int LA16_1 = input.LA(2);

                if ( (LA16_1=='#') ) {
                    int LA16_2 = input.LA(3);

                    if ( (LA16_2=='x') ) {
                        alt16=2;
                    }
                    else if ( ((LA16_2>='0' && LA16_2<='9')) ) {
                        alt16=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 16, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:172:19: '&#' ( DIGIT )+ ';'
                    {
                    match("&#"); 

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:172:24: ( DIGIT )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>='0' && LA15_0<='9')) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:172:24: DIGIT
                    	    {
                    	    mDIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt15 >= 1 ) break loop15;
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
                    } while (true);

                    match(';'); 

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:172:37: '&#x' HEXADECIMAL ';'
                    {
                    match("&#x"); 

                    mHEXADECIMAL(); 
                    match(';'); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "CHARREF"

    // $ANTLR start "ENTREF"
    public final void mENTREF() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:173:16: ( '&' ( LETTER | '_' | ':' ) ( LETTER | DIGIT | '.' | '-' | '_' | ':' )* ';' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:173:18: '&' ( LETTER | '_' | ':' ) ( LETTER | DIGIT | '.' | '-' | '_' | ':' )* ';'
            {
            match('&'); 
            if ( input.LA(1)==':'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:173:45: ( LETTER | DIGIT | '.' | '-' | '_' | ':' )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>='-' && LA17_0<='.')||(LA17_0>='0' && LA17_0<=':')||(LA17_0>='A' && LA17_0<='Z')||LA17_0=='_'||(LA17_0>='a' && LA17_0<='z')) ) {
                    alt17=1;
                }


                switch (alt17) {
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
            	    break loop17;
                }
            } while (true);

            match(';'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "ENTREF"

    // $ANTLR start "SYMBOLCON"
    public final void mSYMBOLCON() throws RecognitionException {
        try {
            int _type = SYMBOLCON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:175:10: ( '\\'' ( SYMBOLCHAR )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:175:13: '\\'' ( SYMBOLCHAR )*
            {
            match('\''); 
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:175:18: ( SYMBOLCHAR )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>='!' && LA18_0<='(')||(LA18_0>='*' && LA18_0<='+')||(LA18_0>='-' && LA18_0<=':')||(LA18_0>='<' && LA18_0<='=')||(LA18_0>='?' && LA18_0<='|')||(LA18_0>='~' && LA18_0<='\uFFFF')) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:175:18: SYMBOLCHAR
            	    {
            	    mSYMBOLCHAR(); 

            	    }
            	    break;

            	default :
            	    break loop18;
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:176:20: (~ ( '\\u0000' .. '\\u001F' | ' ' | ';' | ',' | '>' | '}' | ')' ) )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:176:22: ~ ( '\\u0000' .. '\\u001F' | ' ' | ';' | ',' | '>' | '}' | ')' )
            {
            if ( (input.LA(1)>='!' && input.LA(1)<='(')||(input.LA(1)>='*' && input.LA(1)<='+')||(input.LA(1)>='-' && input.LA(1)<=':')||(input.LA(1)>='<' && input.LA(1)<='=')||(input.LA(1)>='?' && input.LA(1)<='|')||(input.LA(1)>='~' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:178:7: ( ( DIGIT )+ )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:178:11: ( DIGIT )+
            {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:178:11: ( DIGIT )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>='0' && LA19_0<='9')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:178:11: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:179:6: ( LETTER ( LETTER | DIGIT | '-' )+ )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:179:10: LETTER ( LETTER | DIGIT | '-' )+
            {
            mLETTER(); 
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:179:17: ( LETTER | DIGIT | '-' )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0=='-'||(LA20_0>='0' && LA20_0<='9')||(LA20_0>='A' && LA20_0<='Z')||(LA20_0>='a' && LA20_0<='z')) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDCON"

    // $ANTLR start "COMMENTS"
    public final void mCOMMENTS() throws RecognitionException {
        try {
            int _type = COMMENTS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:181:9: ( '//' ( options {greedy=false; } : . )* '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0=='/') ) {
                int LA23_1 = input.LA(2);

                if ( (LA23_1=='/') ) {
                    alt23=1;
                }
                else if ( (LA23_1=='*') ) {
                    alt23=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:181:12: '//' ( options {greedy=false; } : . )* '\\n'
                    {
                    match("//"); 

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:181:17: ( options {greedy=false; } : . )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0=='\n') ) {
                            alt21=2;
                        }
                        else if ( ((LA21_0>='\u0000' && LA21_0<='\t')||(LA21_0>='\u000B' && LA21_0<='\uFFFF')) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:181:47: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);

                    match('\n'); 

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:182:4: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:182:9: ( options {greedy=false; } : . )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0=='*') ) {
                            int LA22_1 = input.LA(2);

                            if ( (LA22_1=='/') ) {
                                alt22=2;
                            }
                            else if ( ((LA22_1>='\u0000' && LA22_1<='.')||(LA22_1>='0' && LA22_1<='\uFFFF')) ) {
                                alt22=1;
                            }


                        }
                        else if ( ((LA22_0>='\u0000' && LA22_0<=')')||(LA22_0>='+' && LA22_0<='\uFFFF')) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:182:39: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    match("*/"); 

                     skip(); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENTS"

    // $ANTLR start "LAYOUT"
    public final void mLAYOUT() throws RecognitionException {
        try {
            int _type = LAYOUT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:184:7: ( ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+ )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:184:11: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:184:11: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>='\t' && LA24_0<='\n')||(LA24_0>='\f' && LA24_0<='\r')||LA24_0==' ') ) {
                    alt24=1;
                }


                switch (alt24) {
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
            	    if ( cnt24 >= 1 ) break loop24;
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
            } while (true);

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LAYOUT"

    public void mTokens() throws RecognitionException {
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:8: ( T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | COMMENT | SITE | END | SEMICOLON | PATH | STRCON | PRETEXT | POSTTEXT | MIDTEXT | TEXT | SYMBOLCON | NATCON | IDCON | COMMENTS | LAYOUT )
        int alt25=47;
        alt25 = dfa25.predict(input);
        switch (alt25) {
            case 1 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:10: T__33
                {
                mT__33(); 

                }
                break;
            case 2 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:16: T__34
                {
                mT__34(); 

                }
                break;
            case 3 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:22: T__35
                {
                mT__35(); 

                }
                break;
            case 4 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:28: T__36
                {
                mT__36(); 

                }
                break;
            case 5 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:34: T__37
                {
                mT__37(); 

                }
                break;
            case 6 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:40: T__38
                {
                mT__38(); 

                }
                break;
            case 7 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:46: T__39
                {
                mT__39(); 

                }
                break;
            case 8 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:52: T__40
                {
                mT__40(); 

                }
                break;
            case 9 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:58: T__41
                {
                mT__41(); 

                }
                break;
            case 10 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:64: T__42
                {
                mT__42(); 

                }
                break;
            case 11 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:70: T__43
                {
                mT__43(); 

                }
                break;
            case 12 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:76: T__44
                {
                mT__44(); 

                }
                break;
            case 13 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:82: T__45
                {
                mT__45(); 

                }
                break;
            case 14 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:88: T__46
                {
                mT__46(); 

                }
                break;
            case 15 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:94: T__47
                {
                mT__47(); 

                }
                break;
            case 16 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:100: T__48
                {
                mT__48(); 

                }
                break;
            case 17 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:106: T__49
                {
                mT__49(); 

                }
                break;
            case 18 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:112: T__50
                {
                mT__50(); 

                }
                break;
            case 19 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:118: T__51
                {
                mT__51(); 

                }
                break;
            case 20 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:124: T__52
                {
                mT__52(); 

                }
                break;
            case 21 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:130: T__53
                {
                mT__53(); 

                }
                break;
            case 22 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:136: T__54
                {
                mT__54(); 

                }
                break;
            case 23 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:142: T__55
                {
                mT__55(); 

                }
                break;
            case 24 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:148: T__56
                {
                mT__56(); 

                }
                break;
            case 25 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:154: T__57
                {
                mT__57(); 

                }
                break;
            case 26 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:160: T__58
                {
                mT__58(); 

                }
                break;
            case 27 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:166: T__59
                {
                mT__59(); 

                }
                break;
            case 28 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:172: T__60
                {
                mT__60(); 

                }
                break;
            case 29 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:178: T__61
                {
                mT__61(); 

                }
                break;
            case 30 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:184: T__62
                {
                mT__62(); 

                }
                break;
            case 31 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:190: T__63
                {
                mT__63(); 

                }
                break;
            case 32 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:196: T__64
                {
                mT__64(); 

                }
                break;
            case 33 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:202: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 34 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:210: SITE
                {
                mSITE(); 

                }
                break;
            case 35 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:215: END
                {
                mEND(); 

                }
                break;
            case 36 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:219: SEMICOLON
                {
                mSEMICOLON(); 

                }
                break;
            case 37 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:229: PATH
                {
                mPATH(); 

                }
                break;
            case 38 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:234: STRCON
                {
                mSTRCON(); 

                }
                break;
            case 39 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:241: PRETEXT
                {
                mPRETEXT(); 

                }
                break;
            case 40 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:249: POSTTEXT
                {
                mPOSTTEXT(); 

                }
                break;
            case 41 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:258: MIDTEXT
                {
                mMIDTEXT(); 

                }
                break;
            case 42 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:266: TEXT
                {
                mTEXT(); 

                }
                break;
            case 43 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:271: SYMBOLCON
                {
                mSYMBOLCON(); 

                }
                break;
            case 44 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:281: NATCON
                {
                mNATCON(); 

                }
                break;
            case 45 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:288: IDCON
                {
                mIDCON(); 

                }
                break;
            case 46 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:294: COMMENTS
                {
                mCOMMENTS(); 

                }
                break;
            case 47 :
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:303: LAYOUT
                {
                mLAYOUT(); 

                }
                break;

        }

    }


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA12 dfa12 = new DFA12(this);
    protected DFA25 dfa25 = new DFA25(this);
    static final String DFA2_eotS =
        "\4\uffff";
    static final String DFA2_eofS =
        "\4\uffff";
    static final String DFA2_minS =
        "\2\45\2\uffff";
    static final String DFA2_maxS =
        "\2\172\2\uffff";
    static final String DFA2_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA2_specialS =
        "\4\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\1\12\uffff\12\1\7\uffff\32\1\6\uffff\32\1",
            "\1\1\10\uffff\1\2\1\3\12\1\7\uffff\32\1\6\uffff\32\1",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "()* loopback of 154:24: ( PATHELEMENT '/' )*";
        }
    }
    static final String DFA12_eotS =
        "\1\uffff\1\5\11\uffff";
    static final String DFA12_eofS =
        "\13\uffff";
    static final String DFA12_minS =
        "\1\11\1\42\4\uffff\1\0\4\uffff";
    static final String DFA12_maxS =
        "\1\177\1\134\4\uffff\1\uffff\4\uffff";
    static final String DFA12_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\1\1\uffff\1\5\1\7\1\10\1\6";
    static final String DFA12_specialS =
        "\6\uffff\1\0\4\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\4\1\2\2\uffff\1\3\22\uffff\2\5\1\uffff\3\5\1\6\25\5\1\uffff"+
            "\37\5\1\1\43\5",
            "\1\7\71\uffff\1\7",
            "",
            "",
            "",
            "",
            "\43\12\1\10\14\12\12\uffff\1\11\6\12\32\11\4\12\1\11\1\12\32"+
            "\11\uff85\12",
            "",
            "",
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
            return "168:10: fragment TEXTCHAR : (~ ( '\\u0000' .. '\\u001F' | '&' | '\"' | '<' | '\\u0080' .. '\\uFFFF' ) | '\\n' | '\\r' | '\\t' | ESCQUOTE | AMP | CHARREF | ENTREF );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_6 = input.LA(1);

                        s = -1;
                        if ( (LA12_6=='#') ) {s = 8;}

                        else if ( (LA12_6==':'||(LA12_6>='A' && LA12_6<='Z')||LA12_6=='_'||(LA12_6>='a' && LA12_6<='z')) ) {s = 9;}

                        else if ( ((LA12_6>='\u0000' && LA12_6<='\"')||(LA12_6>='$' && LA12_6<='/')||(LA12_6>=';' && LA12_6<='@')||(LA12_6>='[' && LA12_6<='^')||LA12_6=='`'||(LA12_6>='{' && LA12_6<='\uFFFF')) ) {s = 10;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA25_eotS =
        "\10\uffff\1\53\24\uffff\1\71\6\uffff\1\47\1\uffff\1\47\1\uffff\1"+
        "\47\1\115\1\116\1\uffff\15\47\7\uffff\1\151\1\140\11\uffff\2\47"+
        "\2\uffff\1\161\3\47\1\165\1\166\7\47\1\uffff\1\141\7\uffff\1\102"+
        "\5\uffff\1\112\3\uffff\2\47\1\uffff\1\u00a6\1\u00a7\1\u00a8\2\uffff"+
        "\1\u00a9\5\47\1\u00af\2\uffff\1\141\11\uffff\1\141\6\uffff\1\140"+
        "\1\151\3\uffff\1\140\5\uffff\1\111\6\uffff\1\112\2\47\4\uffff\1"+
        "\u00c9\4\47\12\uffff\1\141\5\uffff\1\141\4\uffff\1\112\2\uffff\1"+
        "\u00e2\1\u00e3\1\uffff\1\47\1\uffff\1\u00e5\1\u00e6\1\uffff\1\151"+
        "\24\uffff\1\u00f1\11\uffff\1\151\13\uffff";
    static final String DFA25_eofS =
        "\u00fa\uffff";
    static final String DFA25_minS =
        "\1\11\1\45\1\uffff\1\45\4\uffff\1\45\10\uffff\5\45\4\uffff\2\45"+
        "\1\uffff\1\45\2\11\1\uffff\1\45\2\uffff\1\45\1\uffff\1\45\1\uffff"+
        "\3\45\1\uffff\15\45\1\uffff\5\11\2\0\1\40\1\uffff\5\11\1\0\2\uffff"+
        "\2\45\2\uffff\15\45\3\11\1\0\2\uffff\1\11\2\40\5\0\2\11\1\60\1\55"+
        "\1\0\2\45\1\uffff\3\45\2\uffff\7\45\5\11\1\60\1\55\1\11\3\40\1\11"+
        "\16\0\2\60\1\55\1\11\10\0\2\45\4\uffff\5\45\1\uffff\2\11\2\60\1"+
        "\55\1\11\1\40\1\11\2\0\2\11\1\0\2\11\2\0\1\60\1\11\2\0\2\11\2\45"+
        "\1\uffff\1\45\1\uffff\2\45\3\11\1\60\12\11\1\0\5\11\2\uffff\1\45"+
        "\2\uffff\6\11\2\0\2\11\1\uffff\10\11";
    static final String DFA25_maxS =
        "\1\175\1\172\1\uffff\1\172\4\uffff\1\172\10\uffff\5\172\4\uffff"+
        "\2\172\1\uffff\1\172\1\uffff\1\177\1\uffff\1\172\2\uffff\1\172\1"+
        "\uffff\1\172\1\uffff\3\172\1\uffff\15\172\1\uffff\4\177\2\uffff"+
        "\1\0\1\uffff\1\uffff\5\177\1\uffff\2\uffff\2\172\2\uffff\15\172"+
        "\3\177\1\uffff\2\uffff\1\177\6\uffff\1\0\2\177\1\170\1\172\1\uffff"+
        "\2\172\1\uffff\3\172\2\uffff\7\172\3\uffff\2\177\1\170\1\172\1\177"+
        "\22\uffff\1\146\1\73\1\172\1\177\10\uffff\2\172\4\uffff\5\172\1"+
        "\uffff\1\uffff\1\177\1\146\1\73\1\172\1\177\4\uffff\2\177\5\uffff"+
        "\1\146\1\177\2\uffff\2\177\2\172\1\uffff\1\172\1\uffff\2\172\3\177"+
        "\1\146\1\177\1\uffff\4\177\5\uffff\5\177\2\uffff\1\172\2\uffff\4"+
        "\177\4\uffff\2\177\1\uffff\2\177\1\uffff\4\177\1\uffff";
    static final String DFA25_acceptS =
        "\2\uffff\1\2\1\uffff\1\4\1\5\1\6\1\7\1\uffff\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\1\17\1\20\5\uffff\1\32\1\33\1\34\1\35\2\uffff\1\44\3"+
        "\uffff\1\53\1\uffff\1\56\1\57\1\uffff\1\45\1\uffff\1\55\3\uffff"+
        "\1\10\15\uffff\1\54\10\uffff\1\46\6\uffff\1\51\1\50\2\uffff\1\22"+
        "\1\26\21\uffff\1\47\1\52\17\uffff\1\21\3\uffff\1\43\1\25\57\uffff"+
        "\1\23\1\24\1\27\1\36\5\uffff\1\42\31\uffff\1\30\1\uffff\1\31\26"+
        "\uffff\1\1\1\3\1\uffff\1\37\1\40\12\uffff\1\41\10\uffff";
    static final String DFA25_specialS =
        "\1\uffff\1\137\1\uffff\1\u0086\4\uffff\1\105\10\uffff\1\151\1\22"+
        "\1\164\1\u0081\1\73\4\uffff\1\45\1\136\1\uffff\1\33\1\133\2\uffff"+
        "\1\166\2\uffff\1\23\1\uffff\1\30\1\uffff\1\0\1\67\1\124\1\uffff"+
        "\1\100\1\76\1\110\1\117\1\64\1\102\1\46\1\113\1\55\1\126\1\40\1"+
        "\57\1\70\5\uffff\1\175\1\145\1\uffff\1\147\6\uffff\1\6\2\uffff\1"+
        "\25\1\1\2\uffff\1\66\1\75\1\106\1\111\1\7\1\114\1\44\1\112\1\53"+
        "\1\127\1\41\1\62\1\71\3\uffff\1\5\3\uffff\1\146\1\12\1\174\1\27"+
        "\1\163\1\143\1\120\4\uffff\1\144\1\24\1\2\1\uffff\1\32\1\42\1\77"+
        "\2\uffff\1\162\1\125\1\50\1\121\1\35\1\60\1\4\1\170\1\167\1\65\5"+
        "\uffff\1\15\1\43\1\u0085\1\165\1\74\1\177\1\153\1\155\1\157\1\134"+
        "\1\140\1\132\1\101\1\34\1\11\1\36\1\63\1\61\4\uffff\1\123\1\u0080"+
        "\1\154\1\156\1\160\1\135\1\141\1\115\1\26\1\3\4\uffff\1\103\1\47"+
        "\1\122\1\37\1\56\1\uffff\1\171\5\uffff\1\16\1\u0083\1\131\1\17\2"+
        "\uffff\1\10\1\173\1\31\1\51\1\176\2\uffff\1\130\1\54\2\uffff\1\u0082"+
        "\1\u0084\1\uffff\1\52\1\uffff\1\152\1\150\5\uffff\1\u0087\4\uffff"+
        "\1\21\1\107\1\72\1\172\1\142\7\uffff\1\14\6\uffff\1\20\1\116\1\13"+
        "\1\u0088\5\uffff\1\104\4\uffff\1\161}>";
    static final String[] DFA25_transitionS = {
            "\2\43\1\uffff\2\43\22\uffff\1\43\1\27\1\36\1\5\1\6\1\10\1\30"+
            "\1\40\1\11\1\13\1\uffff\1\20\1\12\1\uffff\1\2\1\42\12\35\1\4"+
            "\1\34\1\uffff\1\26\1\37\1\uffff\1\7\32\41\1\14\1\uffff\1\15"+
            "\3\uffff\2\41\1\24\1\21\1\22\3\41\1\3\2\41\1\23\1\1\4\41\1\32"+
            "\1\33\5\41\1\25\1\41\1\16\1\31\1\17",
            "\1\45\7\uffff\1\47\2\45\12\46\7\uffff\32\46\6\uffff\16\46\1"+
            "\44\13\46",
            "",
            "\1\45\7\uffff\1\47\2\45\12\46\7\uffff\32\46\6\uffff\5\46\1"+
            "\51\6\46\1\50\1\52\14\46",
            "",
            "",
            "",
            "",
            "\1\45\10\uffff\14\45\7\uffff\32\45\6\uffff\32\45",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\45\7\uffff\1\47\2\45\12\46\7\uffff\32\46\6\uffff\4\46\1"+
            "\54\25\46",
            "\1\45\7\uffff\1\47\2\45\12\46\7\uffff\32\46\6\uffff\1\56\1"+
            "\46\1\57\10\46\1\55\1\46\1\60\14\46",
            "\1\45\7\uffff\1\47\2\45\12\46\7\uffff\32\46\6\uffff\4\46\1"+
            "\61\3\46\1\62\21\46",
            "\1\45\7\uffff\1\47\2\45\12\46\7\uffff\32\46\6\uffff\3\46\1"+
            "\63\12\46\1\64\13\46",
            "\1\45\7\uffff\1\47\2\45\12\46\7\uffff\32\46\6\uffff\10\46\1"+
            "\65\21\46",
            "",
            "",
            "",
            "",
            "\1\45\7\uffff\1\47\2\45\12\46\7\uffff\32\46\6\uffff\4\46\1"+
            "\66\25\46",
            "\1\45\7\uffff\1\47\2\45\12\46\7\uffff\32\46\6\uffff\10\46\1"+
            "\70\12\46\1\67\6\46",
            "",
            "\1\45\10\uffff\2\45\12\35\7\uffff\32\45\6\uffff\32\45",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\76\1\100\3\76\1\77\25\76"+
            "\1\101\37\76\1\72\43\76\uff80\102",
            "\1\106\1\104\2\uffff\1\105\22\uffff\2\107\1\112\3\107\1\110"+
            "\25\107\1\111\37\107\1\103\43\107",
            "",
            "\1\45\7\uffff\1\47\2\45\12\46\7\uffff\32\46\6\uffff\32\46",
            "",
            "",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\3\46\1\113"+
            "\26\46",
            "",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\32\46",
            "",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\17\46\1\114"+
            "\12\46",
            "\1\45\7\uffff\1\47\2\45\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\45\7\uffff\1\47\2\45\12\46\7\uffff\32\46\6\uffff\32\46",
            "",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\5\46\1\117"+
            "\24\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\22\46\1\120"+
            "\7\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\2\46\1\121"+
            "\27\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\7\46\1\122"+
            "\22\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\3\46\1\123"+
            "\26\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\23\46\1\124"+
            "\6\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\22\46\1\125"+
            "\7\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\1\126\31\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\14\46\1\127"+
            "\15\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\4\46\1\130"+
            "\25\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\2\46\1\131"+
            "\27\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\21\46\1\132"+
            "\10\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\23\46\1\133"+
            "\6\46",
            "",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\136\1\135\3\136\1\137\25"+
            "\136\1\140\37\136\1\134\43\136",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\136\1\141\3\136\1\137\25"+
            "\136\1\140\37\136\1\142\43\136",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\136\1\141\3\136\1\137\25"+
            "\136\1\140\37\136\1\142\43\136",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\136\1\141\3\136\1\137\25"+
            "\136\1\140\37\136\1\142\43\136",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\76\1\100\3\76\1\77\25\76"+
            "\1\101\37\76\1\72\43\76\uff80\102",
            "\40\150\2\146\1\145\1\143\14\146\12\102\1\144\6\146\32\144"+
            "\1\146\1\147\2\146\1\144\1\146\32\144\uff85\146",
            "\1\uffff",
            "\uffe0\102",
            "",
            "\1\106\1\104\2\uffff\1\105\22\uffff\2\107\1\153\3\107\1\110"+
            "\25\107\1\111\37\107\1\152\43\107",
            "\1\106\1\104\2\uffff\1\105\22\uffff\2\107\1\112\3\107\1\110"+
            "\25\107\1\111\37\107\1\103\43\107",
            "\1\106\1\104\2\uffff\1\105\22\uffff\2\107\1\112\3\107\1\110"+
            "\25\107\1\111\37\107\1\103\43\107",
            "\1\106\1\104\2\uffff\1\105\22\uffff\2\107\1\112\3\107\1\110"+
            "\25\107\1\111\37\107\1\103\43\107",
            "\1\106\1\104\2\uffff\1\105\22\uffff\2\107\1\112\3\107\1\110"+
            "\25\107\1\111\37\107\1\103\43\107",
            "\43\156\1\154\14\156\12\uffff\1\155\6\156\32\155\4\156\1\155"+
            "\1\156\32\155\uff85\156",
            "",
            "",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\24\46\1\157"+
            "\5\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\16\46\1\160"+
            "\13\46",
            "",
            "",
            "\1\45\7\uffff\1\47\2\45\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\4\46\1\162"+
            "\25\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\7\46\1\163"+
            "\22\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\16\46\1\164"+
            "\13\46",
            "\1\45\7\uffff\1\47\2\45\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\45\7\uffff\1\47\2\45\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\23\46\1\167"+
            "\6\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\23\46\1\170"+
            "\6\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\14\46\1\171"+
            "\15\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\13\46\1\172"+
            "\16\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\16\46\1\173"+
            "\13\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\10\46\1\174"+
            "\21\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\4\46\1\175"+
            "\25\46",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\136\1\u0080\3\136\1\137"+
            "\25\136\1\140\37\136\1\u0081\4\136\1\u0082\14\136\1\176\5\136"+
            "\1\177\13\136",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\136\1\uffff\3\136\1\137"+
            "\25\136\1\140\37\136\1\142\43\136",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\136\1\141\3\136\1\137\25"+
            "\136\1\140\37\136\1\142\43\136",
            "\43\150\1\u0083\14\150\12\uffff\1\u0084\6\150\32\u0084\4\150"+
            "\1\u0084\1\150\32\u0084\uff85\150",
            "",
            "",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\136\1\135\3\136\1\137\25"+
            "\136\1\140\37\136\1\u0085\43\136",
            "\20\102\12\u0087\76\102\1\u0086\uff87\102",
            "\15\102\2\u0088\1\102\13\u0088\1\u0089\5\102\32\u0088\4\102"+
            "\1\u0088\1\102\32\u0088\uff85\102",
            "\11\150\1\u008e\1\u008c\2\150\1\u008d\22\150\2\u008f\1\u008a"+
            "\1\136\2\u008f\1\u0090\11\u008f\13\136\1\u008f\1\u0091\4\u008f"+
            "\32\136\1\u008f\1\u008b\2\u008f\1\136\1\u008f\32\136\5\u008f"+
            "\uff80\150",
            "\11\150\1\u008e\1\u008c\2\150\1\u008d\22\150\2\u0094\1\u0092"+
            "\1\76\2\u0094\1\u0095\11\u0094\13\76\1\u0094\1\u0096\4\u0094"+
            "\32\76\1\u0094\1\u0093\2\u0094\1\76\1\u0094\32\76\5\u0094\uff80"+
            "\146",
            "\11\150\1\u008e\1\u008c\2\150\1\u008d\22\150\2\u008f\1\u008a"+
            "\1\136\2\u008f\1\u0090\11\u008f\13\136\1\u008f\1\u0091\4\u008f"+
            "\32\136\1\u008f\1\u0097\2\u008f\1\136\1\u008f\32\136\5\u008f"+
            "\uff80\150",
            "\11\150\1\u008e\1\u008c\2\150\1\u008d\22\150\2\u008f\1\u008a"+
            "\1\136\2\u008f\1\u0090\11\u008f\13\136\1\u008f\1\u0091\4\u008f"+
            "\32\136\1\u008f\1\u008b\2\u008f\1\136\1\u008f\32\136\5\u008f"+
            "\uff80\150",
            "\1\uffff",
            "\1\106\1\104\2\uffff\1\105\22\uffff\2\107\1\153\3\107\1\110"+
            "\25\107\1\111\37\107\1\152\43\107",
            "\1\106\1\104\2\uffff\1\105\22\uffff\2\107\1\uffff\3\107\1\110"+
            "\25\107\1\111\37\107\1\103\43\107",
            "\12\u0099\76\uffff\1\u0098",
            "\2\u009a\1\uffff\13\u009a\1\u009b\5\uffff\32\u009a\4\uffff"+
            "\1\u009a\1\uffff\32\u009a",
            "\11\156\1\u00a0\1\u009e\2\156\1\u009f\22\156\2\u00a1\1\u00a3"+
            "\1\107\2\u00a1\1\u00a2\11\u00a1\13\107\1\u00a1\1\u009c\4\u00a1"+
            "\32\107\1\u00a1\1\u009d\2\u00a1\1\107\1\u00a1\32\107\5\u00a1"+
            "\uff80\156",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\13\46\1\u00a4"+
            "\16\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\21\46\1\u00a5"+
            "\10\46",
            "",
            "\1\45\7\uffff\1\47\2\45\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\45\7\uffff\1\47\2\45\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\45\7\uffff\1\47\2\45\12\46\7\uffff\32\46\6\uffff\32\46",
            "",
            "",
            "\1\45\7\uffff\1\47\2\45\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\1\u00aa\31"+
            "\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\4\46\1\u00ab"+
            "\25\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\3\46\1\u00ac"+
            "\26\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\21\46\1\u00ad"+
            "\10\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\15\46\1\u00ae"+
            "\14\46",
            "\1\45\7\uffff\1\47\2\45\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\76\1\100\3\76\1\77\25\76"+
            "\1\101\37\76\1\72\43\76\uff80\102",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\76\1\100\3\76\1\77\25\76"+
            "\1\101\37\76\1\72\43\76\uff80\102",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\76\1\100\3\76\1\77\25\76"+
            "\1\101\37\76\1\72\43\76\uff80\102",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\136\1\135\3\136\1\137\25"+
            "\136\1\140\37\136\1\u00b0\43\136",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\136\1\141\3\136\1\137\23"+
            "\136\1\u00b1\1\136\1\140\37\136\1\142\43\136",
            "\12\u00b3\76\uffff\1\u00b2",
            "\2\u00b4\1\uffff\13\u00b4\1\u00b5\5\uffff\32\u00b4\4\uffff"+
            "\1\u00b4\1\uffff\32\u00b4",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\136\1\135\3\136\1\137\25"+
            "\136\1\140\37\136\1\u0085\43\136",
            "\20\102\12\u00b6\7\102\6\u00b6\32\102\6\u00b6\uff99\102",
            "\20\102\12\u0087\1\102\1\u00b7\uffc4\102",
            "\15\102\2\u0088\1\102\13\u0088\1\u0089\5\102\32\u0088\4\102"+
            "\1\u0088\1\102\32\u0088\uff85\102",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\76\1\100\3\76\1\77\25\76"+
            "\1\101\37\76\1\72\43\76\uff80\102",
            "\11\150\1\u008e\1\u008c\2\150\1\u008d\22\150\2\u008f\1\u008a"+
            "\1\136\2\u008f\1\u0090\11\u008f\13\136\1\u008f\1\u0091\4\u008f"+
            "\32\136\1\u008f\1\u008b\2\u008f\1\136\1\u008f\32\136\5\u008f"+
            "\uff80\150",
            "\11\150\1\u008e\1\u008c\2\150\1\u008d\22\150\2\u008f\1\u00b9"+
            "\1\136\2\u008f\1\u0090\11\u008f\13\136\1\u008f\1\u0091\4\u008f"+
            "\32\136\1\u008f\1\u00b8\2\u008f\1\136\1\u008f\32\136\5\u008f"+
            "\uff80\150",
            "\11\150\1\u008e\1\u008c\2\150\1\u008d\22\150\2\u008f\1\u008a"+
            "\1\136\2\u008f\1\u0090\11\u008f\13\136\1\u008f\1\u0091\4\u008f"+
            "\32\136\1\u008f\1\u008b\2\u008f\1\136\1\u008f\32\136\5\u008f"+
            "\uff80\150",
            "\11\150\1\u008e\1\u008c\2\150\1\u008d\22\150\2\u008f\1\u008a"+
            "\1\136\2\u008f\1\u0090\11\u008f\13\136\1\u008f\1\u0091\4\u008f"+
            "\32\136\1\u008f\1\u008b\2\u008f\1\136\1\u008f\32\136\5\u008f"+
            "\uff80\150",
            "\11\150\1\u008e\1\u008c\2\150\1\u008d\22\150\2\u008f\1\u008a"+
            "\1\136\2\u008f\1\u0090\11\u008f\13\136\1\u008f\1\u0091\4\u008f"+
            "\32\136\1\u008f\1\u008b\2\u008f\1\136\1\u008f\32\136\5\u008f"+
            "\uff80\150",
            "\11\150\1\u008e\1\u008c\2\150\1\u008d\22\150\2\u008f\1\u008a"+
            "\1\136\2\u008f\1\u0090\11\u008f\13\136\1\u008f\1\u0091\4\u008f"+
            "\32\136\1\u008f\1\u008b\2\u008f\1\136\1\u008f\32\136\5\u008f"+
            "\uff80\150",
            "\11\150\1\u008e\1\u008c\2\150\1\u008d\22\150\2\u008f\1\u008a"+
            "\1\u00ba\2\u008f\1\u0090\11\u008f\12\136\1\u00bb\1\u008f\1\u0091"+
            "\4\u008f\32\u00bb\1\u008f\1\u008b\2\u008f\1\u00bb\1\u008f\32"+
            "\u00bb\5\u008f\uff80\150",
            "\11\150\1\u008e\1\u008c\2\150\1\u008d\22\150\2\u008f\1\u008a"+
            "\1\136\2\u008f\1\u0090\11\u008f\13\136\1\u008f\1\u0091\4\u008f"+
            "\32\136\1\u008f\1\u008b\2\u008f\1\136\1\u008f\32\136\5\u008f"+
            "\uff80\150",
            "\11\150\1\u008e\1\u008c\2\150\1\u008d\22\150\2\u008f\1\u008a"+
            "\1\136\2\u008f\1\u0090\11\u008f\13\136\1\u008f\1\u0091\4\u008f"+
            "\32\136\1\u008f\1\u008b\2\u008f\1\136\1\u008f\32\136\5\u008f"+
            "\uff80\150",
            "\11\150\1\u008e\1\u008c\2\150\1\u008d\22\150\2\u008f\1\u00b9"+
            "\1\136\2\u008f\1\u0090\11\u008f\13\136\1\u008f\1\u0091\4\u008f"+
            "\32\136\1\u008f\1\u00bc\2\u008f\1\136\1\u008f\32\136\5\u008f"+
            "\uff80\150",
            "\11\150\1\u008e\1\u008c\2\150\1\u008d\22\150\2\u0094\1\u0092"+
            "\1\76\2\u0094\1\u0095\11\u0094\13\76\1\u0094\1\u0096\4\u0094"+
            "\32\76\1\u0094\1\u0093\2\u0094\1\76\1\u0094\32\76\5\u0094\uff80"+
            "\146",
            "\11\150\1\u008e\1\u008c\2\150\1\u008d\22\150\2\u0094\1\u0092"+
            "\1\u00bd\2\u0094\1\u0095\11\u0094\12\76\1\u00be\1\u0094\1\u0096"+
            "\4\u0094\32\u00be\1\u0094\1\u0093\2\u0094\1\u00be\1\u0094\32"+
            "\u00be\5\u0094\uff80\146",
            "\11\150\1\u008e\1\u008c\2\150\1\u008d\22\150\2\u0094\1\u0092"+
            "\1\76\2\u0094\1\u0095\11\u0094\13\76\1\u0094\1\u0096\4\u0094"+
            "\32\76\1\u0094\1\u0093\2\u0094\1\76\1\u0094\32\76\5\u0094\uff80"+
            "\146",
            "\11\150\1\u008e\1\u008c\2\150\1\u008d\22\150\2\u008f\1\u00bf"+
            "\1\136\2\u008f\1\u0090\11\u008f\13\136\1\u008f\1\u0091\4\u008f"+
            "\32\136\1\u008f\1\u00c0\2\u008f\1\136\1\u008f\1\u0082\14\136"+
            "\1\176\5\136\1\177\6\136\5\u008f\uff80\150",
            "\12\u00c1\7\uffff\6\u00c1\32\uffff\6\u00c1",
            "\12\u0099\1\uffff\1\u00c2",
            "\2\u009a\1\uffff\13\u009a\1\u009b\5\uffff\32\u009a\4\uffff"+
            "\1\u009a\1\uffff\32\u009a",
            "\1\106\1\104\2\uffff\1\105\22\uffff\2\107\1\112\3\107\1\110"+
            "\25\107\1\111\37\107\1\103\43\107",
            "\11\156\1\u00a0\1\u009e\2\156\1\u009f\22\156\2\u00a1\1\u00a3"+
            "\1\107\2\u00a1\1\u00a2\11\u00a1\13\107\1\u00a1\1\u009c\4\u00a1"+
            "\32\107\1\u00a1\1\u009d\2\u00a1\1\107\1\u00a1\32\107\5\u00a1"+
            "\uff80\156",
            "\11\156\1\u00a0\1\u009e\2\156\1\u009f\22\156\2\u00a1\1\u00c4"+
            "\1\107\2\u00a1\1\u00a2\11\u00a1\13\107\1\u00a1\1\u009c\4\u00a1"+
            "\32\107\1\u00a1\1\u00c3\2\u00a1\1\107\1\u00a1\32\107\5\u00a1"+
            "\uff80\156",
            "\11\156\1\u00a0\1\u009e\2\156\1\u009f\22\156\2\u00a1\1\u00a3"+
            "\1\107\2\u00a1\1\u00a2\11\u00a1\13\107\1\u00a1\1\u009c\4\u00a1"+
            "\32\107\1\u00a1\1\u009d\2\u00a1\1\107\1\u00a1\32\107\5\u00a1"+
            "\uff80\156",
            "\11\156\1\u00a0\1\u009e\2\156\1\u009f\22\156\2\u00a1\1\u00a3"+
            "\1\107\2\u00a1\1\u00a2\11\u00a1\13\107\1\u00a1\1\u009c\4\u00a1"+
            "\32\107\1\u00a1\1\u009d\2\u00a1\1\107\1\u00a1\32\107\5\u00a1"+
            "\uff80\156",
            "\11\156\1\u00a0\1\u009e\2\156\1\u009f\22\156\2\u00a1\1\u00a3"+
            "\1\107\2\u00a1\1\u00a2\11\u00a1\13\107\1\u00a1\1\u009c\4\u00a1"+
            "\32\107\1\u00a1\1\u009d\2\u00a1\1\107\1\u00a1\32\107\5\u00a1"+
            "\uff80\156",
            "\11\156\1\u00a0\1\u009e\2\156\1\u009f\22\156\2\u00a1\1\u00a3"+
            "\1\107\2\u00a1\1\u00a2\11\u00a1\13\107\1\u00a1\1\u009c\4\u00a1"+
            "\32\107\1\u00a1\1\u009d\2\u00a1\1\107\1\u00a1\32\107\5\u00a1"+
            "\uff80\156",
            "\11\156\1\u00a0\1\u009e\2\156\1\u009f\22\156\2\u00a1\1\u00a3"+
            "\1\u00c5\2\u00a1\1\u00a2\11\u00a1\12\107\1\u00c6\1\u00a1\1\u009c"+
            "\4\u00a1\32\u00c6\1\u00a1\1\u009d\2\u00a1\1\u00c6\1\u00a1\32"+
            "\u00c6\5\u00a1\uff80\156",
            "\11\156\1\u00a0\1\u009e\2\156\1\u009f\22\156\2\u00a1\1\u00a3"+
            "\1\107\2\u00a1\1\u00a2\11\u00a1\13\107\1\u00a1\1\u009c\4\u00a1"+
            "\32\107\1\u00a1\1\u009d\2\u00a1\1\107\1\u00a1\32\107\5\u00a1"+
            "\uff80\156",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\4\46\1\u00c7"+
            "\25\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\23\46\1\u00c8"+
            "\6\46",
            "",
            "",
            "",
            "",
            "\1\45\7\uffff\1\47\2\45\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\15\46\1\u00ca"+
            "\14\46",
            "\1\45\10\uffff\2\45\12\46\1\uffff\1\u00cb\5\uffff\32\46\6\uffff"+
            "\32\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\3\46\1\u00cc"+
            "\26\46",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\6\46\1\u00cd"+
            "\23\46",
            "",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\76\1\u00cf\3\76\1\77\25"+
            "\76\1\101\37\76\1\u00ce\43\76\uff80\102",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\136\1\141\3\136\1\137\11"+
            "\136\12\u00d0\2\136\1\140\37\136\1\142\43\136",
            "\12\u00d1\7\uffff\6\u00d1\32\uffff\6\u00d1",
            "\12\u00b3\1\uffff\1\u00d2",
            "\2\u00b4\1\uffff\13\u00b4\1\u00b5\5\uffff\32\u00b4\4\uffff"+
            "\1\u00b4\1\uffff\32\u00b4",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\136\1\141\3\136\1\137\25"+
            "\136\1\140\37\136\1\142\43\136",
            "\20\102\12\u00b6\1\102\1\u00d3\5\102\6\u00b6\32\102\6\u00b6"+
            "\uff99\102",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\76\1\100\3\76\1\77\25\76"+
            "\1\101\37\76\1\72\43\76\uff80\102",
            "\11\150\1\u008e\1\u008c\2\150\1\u008d\22\150\2\u008f\1\u00b9"+
            "\1\136\2\u008f\1\u0090\11\u008f\13\136\1\u008f\1\u0091\4\u008f"+
            "\32\136\1\u008f\1\u00b8\2\u008f\1\136\1\u008f\32\136\5\u008f"+
            "\uff80\150",
            "\11\150\1\u008e\1\u008c\2\150\1\u008d\22\150\2\u008f\1\u008a"+
            "\1\136\2\u008f\1\u0090\11\u008f\13\136\1\u008f\1\u0091\4\u008f"+
            "\32\136\1\u008f\1\u008b\2\u008f\1\136\1\u008f\32\136\5\u008f"+
            "\uff80\150",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\136\1\141\3\136\1\137\11"+
            "\136\12\u00d5\2\136\1\140\37\136\1\142\33\136\1\u00d4\7\136",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\136\1\141\3\136\1\137\6"+
            "\136\2\u00d6\1\136\13\u00d6\1\u00d7\1\140\4\136\32\u00d6\1\136"+
            "\1\142\2\136\1\u00d6\1\136\32\u00d6\5\136",
            "\11\150\1\u008e\1\u008c\2\150\1\u008d\22\150\2\u008f\1\u00bf"+
            "\1\136\2\u008f\1\u0090\11\u008f\13\136\1\u008f\1\u0091\4\u008f"+
            "\32\136\1\u008f\1\u00c0\2\u008f\1\136\1\u008f\1\u0082\14\136"+
            "\1\176\5\136\1\177\6\136\5\u008f\uff80\150",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\76\1\100\3\76\1\77\11\76"+
            "\12\u00d9\2\76\1\101\37\76\1\72\33\76\1\u00d8\7\76\uff80\102",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\76\1\100\3\76\1\77\6\76"+
            "\2\u00da\1\76\13\u00da\1\u00db\1\101\4\76\32\u00da\1\76\1\72"+
            "\2\76\1\u00da\1\76\32\u00da\5\76\uff80\102",
            "\11\150\1\u008e\1\u008c\2\150\1\u008d\22\150\2\u0094\1\u0092"+
            "\1\76\2\u0094\1\u0095\11\u0094\13\76\1\u0094\1\u0096\4\u0094"+
            "\32\76\1\u0094\1\u0093\2\u0094\1\76\1\u0094\32\76\5\u0094\uff80"+
            "\146",
            "\11\150\1\u008e\1\u008c\2\150\1\u008d\22\150\2\u008f\1\u00b9"+
            "\1\136\2\u008f\1\u0090\11\u008f\13\136\1\u008f\1\u0091\4\u008f"+
            "\32\136\1\u008f\1\u00dc\2\u008f\1\136\1\u008f\32\136\5\u008f"+
            "\uff80\150",
            "\12\u00c1\1\uffff\1\u00dd\5\uffff\6\u00c1\32\uffff\6\u00c1",
            "\1\106\1\104\2\uffff\1\105\22\uffff\2\107\1\112\3\107\1\110"+
            "\25\107\1\111\37\107\1\103\43\107",
            "\11\156\1\u00a0\1\u009e\2\156\1\u009f\22\156\2\u00a1\1\u00c4"+
            "\1\107\2\u00a1\1\u00a2\11\u00a1\13\107\1\u00a1\1\u009c\4\u00a1"+
            "\32\107\1\u00a1\1\u00c3\2\u00a1\1\107\1\u00a1\32\107\5\u00a1"+
            "\uff80\156",
            "\11\156\1\u00a0\1\u009e\2\156\1\u009f\22\156\2\u00a1\1\u00a3"+
            "\1\107\2\u00a1\1\u00a2\11\u00a1\13\107\1\u00a1\1\u009c\4\u00a1"+
            "\32\107\1\u00a1\1\u009d\2\u00a1\1\107\1\u00a1\32\107\5\u00a1"+
            "\uff80\156",
            "\1\106\1\104\2\uffff\1\105\22\uffff\2\107\1\112\3\107\1\110"+
            "\11\107\12\u00df\2\107\1\111\37\107\1\103\33\107\1\u00de\7\107",
            "\1\106\1\104\2\uffff\1\105\22\uffff\2\107\1\112\3\107\1\110"+
            "\6\107\2\u00e0\1\107\13\u00e0\1\u00e1\1\111\4\107\32\u00e0\1"+
            "\107\1\103\2\107\1\u00e0\1\107\32\u00e0\5\107",
            "\1\45\7\uffff\1\47\2\45\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\45\7\uffff\1\47\2\45\12\46\7\uffff\32\46\6\uffff\32\46",
            "",
            "\1\45\10\uffff\2\45\12\46\7\uffff\32\46\6\uffff\23\46\1\u00e4"+
            "\6\46",
            "",
            "\1\45\7\uffff\1\47\2\45\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\45\7\uffff\1\47\2\45\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\136\1\135\3\136\1\137\25"+
            "\136\1\140\37\136\1\134\43\136",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\136\1\141\3\136\1\137\25"+
            "\136\1\140\37\136\1\142\43\136",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\136\1\141\3\136\1\137\25"+
            "\136\1\140\37\136\1\142\5\136\1\u00e7\35\136",
            "\12\u00d1\1\uffff\1\u00e8\5\uffff\6\u00d1\32\uffff\6\u00d1",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\136\1\141\3\136\1\137\25"+
            "\136\1\140\37\136\1\142\43\136",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\76\1\100\3\76\1\77\25\76"+
            "\1\101\37\76\1\72\43\76\uff80\102",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\136\1\141\3\136\1\137\11"+
            "\136\12\u00e9\2\136\1\140\4\136\6\u00e9\25\136\1\142\4\136\6"+
            "\u00e9\31\136",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\136\1\141\3\136\1\137\11"+
            "\136\12\u00d5\1\136\1\u00ea\1\140\37\136\1\142\43\136",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\136\1\141\3\136\1\137\6"+
            "\136\2\u00d6\1\136\13\u00d6\1\u00d7\1\140\4\136\32\u00d6\1\136"+
            "\1\142\2\136\1\u00d6\1\136\32\u00d6\5\136",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\136\1\141\3\136\1\137\25"+
            "\136\1\140\37\136\1\142\43\136",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\76\1\100\3\76\1\77\11\76"+
            "\12\u00eb\2\76\1\101\4\76\6\u00eb\25\76\1\72\4\76\6\u00eb\31"+
            "\76\uff80\102",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\76\1\100\3\76\1\77\11\76"+
            "\12\u00d9\1\76\1\u00ec\1\101\37\76\1\72\43\76\uff80\102",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\76\1\100\3\76\1\77\6\76"+
            "\2\u00da\1\76\13\u00da\1\u00db\1\101\4\76\32\u00da\1\76\1\72"+
            "\2\76\1\u00da\1\76\32\u00da\5\76\uff80\102",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\76\1\100\3\76\1\77\25\76"+
            "\1\101\37\76\1\72\43\76\uff80\102",
            "\11\150\1\u008e\1\u008c\2\150\1\u008d\22\150\2\u0094\1\u00ee"+
            "\1\76\2\u0094\1\u0095\11\u0094\13\76\1\u0094\1\u0096\4\u0094"+
            "\32\76\1\u0094\1\u00ed\2\u0094\1\76\1\u0094\32\76\5\u0094\uff80"+
            "\146",
            "\1\106\1\104\2\uffff\1\105\22\uffff\2\107\1\112\3\107\1\110"+
            "\25\107\1\111\37\107\1\103\43\107",
            "\1\106\1\104\2\uffff\1\105\22\uffff\2\107\1\112\3\107\1\110"+
            "\11\107\12\u00ef\2\107\1\111\4\107\6\u00ef\25\107\1\103\4\107"+
            "\6\u00ef\31\107",
            "\1\106\1\104\2\uffff\1\105\22\uffff\2\107\1\112\3\107\1\110"+
            "\11\107\12\u00df\1\107\1\u00f0\1\111\37\107\1\103\43\107",
            "\1\106\1\104\2\uffff\1\105\22\uffff\2\107\1\112\3\107\1\110"+
            "\6\107\2\u00e0\1\107\13\u00e0\1\u00e1\1\111\4\107\32\u00e0\1"+
            "\107\1\103\2\107\1\u00e0\1\107\32\u00e0\5\107",
            "\1\106\1\104\2\uffff\1\105\22\uffff\2\107\1\112\3\107\1\110"+
            "\25\107\1\111\37\107\1\103\43\107",
            "",
            "",
            "\1\45\7\uffff\1\47\2\45\12\46\7\uffff\32\46\6\uffff\32\46",
            "",
            "",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\136\1\141\3\136\1\137\23"+
            "\136\1\u00f2\1\136\1\140\37\136\1\142\43\136",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\136\1\141\3\136\1\137\25"+
            "\136\1\140\37\136\1\142\43\136",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\136\1\141\3\136\1\137\11"+
            "\136\12\u00e9\1\136\1\u00f3\1\140\4\136\6\u00e9\25\136\1\142"+
            "\4\136\6\u00e9\31\136",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\136\1\141\3\136\1\137\25"+
            "\136\1\140\37\136\1\142\43\136",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\76\1\100\3\76\1\77\11\76"+
            "\12\u00eb\1\76\1\u00f4\1\101\4\76\6\u00eb\25\76\1\72\4\76\6"+
            "\u00eb\31\76\uff80\102",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\76\1\100\3\76\1\77\25\76"+
            "\1\101\37\76\1\72\43\76\uff80\102",
            "\11\150\1\u008e\1\u008c\2\150\1\u008d\22\150\2\u008f\1\u00b9"+
            "\1\136\2\u008f\1\u0090\11\u008f\13\136\1\u008f\1\u0091\4\u008f"+
            "\32\136\1\u008f\1\u00bc\2\u008f\1\136\1\u008f\32\136\5\u008f"+
            "\uff80\150",
            "\11\150\1\u008e\1\u008c\2\150\1\u008d\22\150\2\u008f\1\u008a"+
            "\1\136\2\u008f\1\u0090\11\u008f\13\136\1\u008f\1\u0091\4\u008f"+
            "\32\136\1\u008f\1\u008b\2\u008f\1\136\1\u008f\32\136\5\u008f"+
            "\uff80\150",
            "\1\106\1\104\2\uffff\1\105\22\uffff\2\107\1\112\3\107\1\110"+
            "\11\107\12\u00ef\1\107\1\u00f5\1\111\4\107\6\u00ef\25\107\1"+
            "\103\4\107\6\u00ef\31\107",
            "\1\106\1\104\2\uffff\1\105\22\uffff\2\107\1\112\3\107\1\110"+
            "\25\107\1\111\37\107\1\103\43\107",
            "",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\136\1\141\3\136\1\137\11"+
            "\136\12\u00f6\2\136\1\140\37\136\1\142\43\136",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\136\1\141\3\136\1\137\25"+
            "\136\1\140\37\136\1\142\43\136",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\76\1\100\3\76\1\77\25\76"+
            "\1\101\37\76\1\72\43\76\uff80\102",
            "\1\106\1\104\2\uffff\1\105\22\uffff\2\107\1\112\3\107\1\110"+
            "\25\107\1\111\37\107\1\103\43\107",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\136\1\141\3\136\1\137\25"+
            "\136\1\140\37\136\1\142\6\136\1\u00f7\34\136",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\136\1\141\3\136\1\137\23"+
            "\136\1\u00f8\1\136\1\140\37\136\1\142\43\136",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\136\1\141\3\136\1\137\11"+
            "\136\12\u00f9\2\136\1\140\37\136\1\142\43\136",
            "\1\75\1\73\2\uffff\1\74\22\uffff\2\76\1\100\3\76\1\77\25\76"+
            "\1\101\37\76\1\72\43\76\uff80\102"
    };

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | COMMENT | SITE | END | SEMICOLON | PATH | STRCON | PRETEXT | POSTTEXT | MIDTEXT | TEXT | SYMBOLCON | NATCON | IDCON | COMMENTS | LAYOUT );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA25_40 = input.LA(1);

                         
                        int index25_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_40=='p') ) {s = 76;}

                        else if ( ((LA25_40>='0' && LA25_40<='9')||(LA25_40>='A' && LA25_40<='Z')||(LA25_40>='a' && LA25_40<='o')||(LA25_40>='q' && LA25_40<='z')) ) {s = 38;}

                        else if ( (LA25_40=='%'||(LA25_40>='.' && LA25_40<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_40);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA25_76 = input.LA(1);

                         
                        int index25_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_76=='o') ) {s = 112;}

                        else if ( ((LA25_76>='0' && LA25_76<='9')||(LA25_76>='A' && LA25_76<='Z')||(LA25_76>='a' && LA25_76<='n')||(LA25_76>='p' && LA25_76<='z')) ) {s = 38;}

                        else if ( (LA25_76=='%'||(LA25_76>='.' && LA25_76<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_76);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA25_112 = input.LA(1);

                         
                        int index25_112 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_112=='r') ) {s = 165;}

                        else if ( ((LA25_112>='0' && LA25_112<='9')||(LA25_112>='A' && LA25_112<='Z')||(LA25_112>='a' && LA25_112<='q')||(LA25_112>='s' && LA25_112<='z')) ) {s = 38;}

                        else if ( (LA25_112=='%'||(LA25_112>='.' && LA25_112<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_112);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA25_165 = input.LA(1);

                         
                        int index25_165 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_165=='t') ) {s = 200;}

                        else if ( ((LA25_165>='0' && LA25_165<='9')||(LA25_165>='A' && LA25_165<='Z')||(LA25_165>='a' && LA25_165<='s')||(LA25_165>='u' && LA25_165<='z')) ) {s = 38;}

                        else if ( (LA25_165=='%'||(LA25_165>='.' && LA25_165<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_165);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA25_125 = input.LA(1);

                         
                        int index25_125 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_125>='0' && LA25_125<='9')||(LA25_125>='A' && LA25_125<='Z')||(LA25_125>='a' && LA25_125<='z')) ) {s = 38;}

                        else if ( (LA25_125=='%'||(LA25_125>='.' && LA25_125<='/')) && (( inPath ))) {s = 37;}

                        else if ( (LA25_125=='-') ) {s = 39;}

                        else s = 175;

                         
                        input.seek(index25_125);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA25_95 = input.LA(1);

                        s = -1;
                        if ( (LA25_95=='#') ) {s = 131;}

                        else if ( (LA25_95==':'||(LA25_95>='A' && LA25_95<='Z')||LA25_95=='_'||(LA25_95>='a' && LA25_95<='z')) ) {s = 132;}

                        else if ( ((LA25_95>='\u0000' && LA25_95<='\"')||(LA25_95>='$' && LA25_95<='/')||(LA25_95>=';' && LA25_95<='@')||(LA25_95>='[' && LA25_95<='^')||LA25_95=='`'||(LA25_95>='{' && LA25_95<='\uFFFF')) ) {s = 104;}

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA25_72 = input.LA(1);

                        s = -1;
                        if ( (LA25_72=='#') ) {s = 108;}

                        else if ( (LA25_72==':'||(LA25_72>='A' && LA25_72<='Z')||LA25_72=='_'||(LA25_72>='a' && LA25_72<='z')) ) {s = 109;}

                        else if ( ((LA25_72>='\u0000' && LA25_72<='\"')||(LA25_72>='$' && LA25_72<='/')||(LA25_72>=';' && LA25_72<='@')||(LA25_72>='[' && LA25_72<='^')||LA25_72=='`'||(LA25_72>='{' && LA25_72<='\uFFFF')) ) {s = 110;}

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA25_83 = input.LA(1);

                         
                        int index25_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_83>='0' && LA25_83<='9')||(LA25_83>='A' && LA25_83<='Z')||(LA25_83>='a' && LA25_83<='z')) ) {s = 38;}

                        else if ( (LA25_83=='%'||(LA25_83>='.' && LA25_83<='/')) && (( inPath ))) {s = 37;}

                        else if ( (LA25_83=='-') ) {s = 39;}

                        else s = 117;

                         
                        input.seek(index25_83);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA25_188 = input.LA(1);

                        s = -1;
                        if ( (LA25_188=='n') ) {s = 126;}

                        else if ( (LA25_188=='t') ) {s = 127;}

                        else if ( (LA25_188=='\"') ) {s = 191;}

                        else if ( (LA25_188=='\\') ) {s = 192;}

                        else if ( (LA25_188=='a') ) {s = 130;}

                        else if ( ((LA25_188>=' ' && LA25_188<='!')||(LA25_188>='$' && LA25_188<='%')||(LA25_188>='\'' && LA25_188<='/')||LA25_188==';'||(LA25_188>='=' && LA25_188<='@')||LA25_188=='['||(LA25_188>=']' && LA25_188<='^')||LA25_188=='`'||(LA25_188>='{' && LA25_188<='\u007F')) ) {s = 143;}

                        else if ( (LA25_188=='\n') ) {s = 140;}

                        else if ( (LA25_188=='\r') ) {s = 141;}

                        else if ( (LA25_188=='\t') ) {s = 142;}

                        else if ( (LA25_188=='&') ) {s = 144;}

                        else if ( (LA25_188=='#'||(LA25_188>='0' && LA25_188<=':')||(LA25_188>='A' && LA25_188<='Z')||LA25_188=='_'||(LA25_188>='b' && LA25_188<='m')||(LA25_188>='o' && LA25_188<='s')||(LA25_188>='u' && LA25_188<='z')) ) {s = 94;}

                        else if ( (LA25_188=='<') ) {s = 145;}

                        else if ( ((LA25_188>='\u0000' && LA25_188<='\b')||(LA25_188>='\u000B' && LA25_188<='\f')||(LA25_188>='\u000E' && LA25_188<='\u001F')||(LA25_188>='\u0080' && LA25_188<='\uFFFF')) ) {s = 104;}

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA25_148 = input.LA(1);

                        s = -1;
                        if ( (LA25_148=='\"') ) {s = 146;}

                        else if ( (LA25_148=='\\') ) {s = 147;}

                        else if ( (LA25_148=='\n') ) {s = 140;}

                        else if ( (LA25_148=='\r') ) {s = 141;}

                        else if ( (LA25_148=='\t') ) {s = 142;}

                        else if ( ((LA25_148>=' ' && LA25_148<='!')||(LA25_148>='$' && LA25_148<='%')||(LA25_148>='\'' && LA25_148<='/')||LA25_148==';'||(LA25_148>='=' && LA25_148<='@')||LA25_148=='['||(LA25_148>=']' && LA25_148<='^')||LA25_148=='`'||(LA25_148>='{' && LA25_148<='\u007F')) ) {s = 148;}

                        else if ( (LA25_148=='&') ) {s = 149;}

                        else if ( (LA25_148=='#'||(LA25_148>='0' && LA25_148<=':')||(LA25_148>='A' && LA25_148<='Z')||LA25_148=='_'||(LA25_148>='a' && LA25_148<='z')) ) {s = 62;}

                        else if ( (LA25_148=='<') ) {s = 150;}

                        else if ( ((LA25_148>='\u0080' && LA25_148<='\uFFFF')) ) {s = 102;}

                        else if ( ((LA25_148>='\u0000' && LA25_148<='\b')||(LA25_148>='\u000B' && LA25_148<='\f')||(LA25_148>='\u000E' && LA25_148<='\u001F')) ) {s = 104;}

                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA25_100 = input.LA(1);

                         
                        int index25_100 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_100>='-' && LA25_100<='.')||(LA25_100>='0' && LA25_100<=':')||(LA25_100>='A' && LA25_100<='Z')||LA25_100=='_'||(LA25_100>='a' && LA25_100<='z')) ) {s = 136;}

                        else if ( (LA25_100==';') ) {s = 137;}

                        else if ( ((LA25_100>=' ' && LA25_100<=',')||LA25_100=='/'||(LA25_100>='<' && LA25_100<='@')||(LA25_100>='[' && LA25_100<='^')||LA25_100=='`'||(LA25_100>='{' && LA25_100<='\uFFFF')) && (( inString ))) {s = 66;}

                         
                        input.seek(index25_100);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA25_237 = input.LA(1);

                        s = -1;
                        if ( (LA25_237=='\\') ) {s = 188;}

                        else if ( (LA25_237=='\"') ) {s = 185;}

                        else if ( ((LA25_237>=' ' && LA25_237<='!')||(LA25_237>='$' && LA25_237<='%')||(LA25_237>='\'' && LA25_237<='/')||LA25_237==';'||(LA25_237>='=' && LA25_237<='@')||LA25_237=='['||(LA25_237>=']' && LA25_237<='^')||LA25_237=='`'||(LA25_237>='{' && LA25_237<='\u007F')) ) {s = 143;}

                        else if ( (LA25_237=='\n') ) {s = 140;}

                        else if ( (LA25_237=='\r') ) {s = 141;}

                        else if ( (LA25_237=='\t') ) {s = 142;}

                        else if ( (LA25_237=='&') ) {s = 144;}

                        else if ( (LA25_237=='#'||(LA25_237>='0' && LA25_237<=':')||(LA25_237>='A' && LA25_237<='Z')||LA25_237=='_'||(LA25_237>='a' && LA25_237<='z')) ) {s = 94;}

                        else if ( (LA25_237=='<') ) {s = 145;}

                        else if ( ((LA25_237>='\u0000' && LA25_237<='\b')||(LA25_237>='\u000B' && LA25_237<='\f')||(LA25_237>='\u000E' && LA25_237<='\u001F')||(LA25_237>='\u0080' && LA25_237<='\uFFFF')) ) {s = 104;}

                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA25_228 = input.LA(1);

                         
                        int index25_228 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_228>='0' && LA25_228<='9')||(LA25_228>='A' && LA25_228<='Z')||(LA25_228>='a' && LA25_228<='z')) ) {s = 38;}

                        else if ( (LA25_228=='%'||(LA25_228>='.' && LA25_228<='/')) && (( inPath ))) {s = 37;}

                        else if ( (LA25_228=='-') ) {s = 39;}

                        else s = 241;

                         
                        input.seek(index25_228);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA25_134 = input.LA(1);

                         
                        int index25_134 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_134>=' ' && LA25_134<='/')||(LA25_134>=':' && LA25_134<='@')||(LA25_134>='G' && LA25_134<='`')||(LA25_134>='g' && LA25_134<='\uFFFF')) && (( inString ))) {s = 66;}

                        else if ( ((LA25_134>='0' && LA25_134<='9')||(LA25_134>='A' && LA25_134<='F')||(LA25_134>='a' && LA25_134<='f')) ) {s = 182;}

                         
                        input.seek(index25_134);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA25_182 = input.LA(1);

                         
                        int index25_182 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_182==';') ) {s = 211;}

                        else if ( ((LA25_182>='0' && LA25_182<='9')||(LA25_182>='A' && LA25_182<='F')||(LA25_182>='a' && LA25_182<='f')) ) {s = 182;}

                        else if ( ((LA25_182>=' ' && LA25_182<='/')||LA25_182==':'||(LA25_182>='<' && LA25_182<='@')||(LA25_182>='G' && LA25_182<='`')||(LA25_182>='g' && LA25_182<='\uFFFF')) && (( inString ))) {s = 66;}

                         
                        input.seek(index25_182);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA25_185 = input.LA(1);

                        s = -1;
                        if ( (LA25_185=='\"') ) {s = 138;}

                        else if ( (LA25_185=='\\') ) {s = 139;}

                        else if ( (LA25_185=='\n') ) {s = 140;}

                        else if ( (LA25_185=='\r') ) {s = 141;}

                        else if ( (LA25_185=='\t') ) {s = 142;}

                        else if ( ((LA25_185>=' ' && LA25_185<='!')||(LA25_185>='$' && LA25_185<='%')||(LA25_185>='\'' && LA25_185<='/')||LA25_185==';'||(LA25_185>='=' && LA25_185<='@')||LA25_185=='['||(LA25_185>=']' && LA25_185<='^')||LA25_185=='`'||(LA25_185>='{' && LA25_185<='\u007F')) ) {s = 143;}

                        else if ( (LA25_185=='&') ) {s = 144;}

                        else if ( (LA25_185=='#'||(LA25_185>='0' && LA25_185<=':')||(LA25_185>='A' && LA25_185<='Z')||LA25_185=='_'||(LA25_185>='a' && LA25_185<='z')) ) {s = 94;}

                        else if ( (LA25_185=='<') ) {s = 145;}

                        else if ( ((LA25_185>='\u0000' && LA25_185<='\b')||(LA25_185>='\u000B' && LA25_185<='\f')||(LA25_185>='\u000E' && LA25_185<='\u001F')||(LA25_185>='\u0080' && LA25_185<='\uFFFF')) ) {s = 104;}

                        else s = 97;

                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA25_235 = input.LA(1);

                         
                        int index25_235 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_235==';') ) {s = 244;}

                        else if ( ((LA25_235>='0' && LA25_235<='9')||(LA25_235>='A' && LA25_235<='F')||(LA25_235>='a' && LA25_235<='f')) ) {s = 235;}

                        else if ( (LA25_235=='\"') ) {s = 64;}

                        else if ( (LA25_235=='\\') ) {s = 58;}

                        else if ( (LA25_235=='\n') ) {s = 59;}

                        else if ( (LA25_235=='\r') ) {s = 60;}

                        else if ( (LA25_235=='\t') ) {s = 61;}

                        else if ( ((LA25_235>=' ' && LA25_235<='!')||(LA25_235>='#' && LA25_235<='%')||(LA25_235>='\'' && LA25_235<='/')||LA25_235==':'||(LA25_235>='=' && LA25_235<='@')||(LA25_235>='G' && LA25_235<='[')||(LA25_235>=']' && LA25_235<='`')||(LA25_235>='g' && LA25_235<='\u007F')) ) {s = 62;}

                        else if ( (LA25_235=='&') ) {s = 63;}

                        else if ( (LA25_235=='<') ) {s = 65;}

                        else if ( ((LA25_235>='\u0080' && LA25_235<='\uFFFF')) && (( inString ))) {s = 66;}

                         
                        input.seek(index25_235);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA25_216 = input.LA(1);

                         
                        int index25_216 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_216=='\"') ) {s = 64;}

                        else if ( (LA25_216=='\\') ) {s = 58;}

                        else if ( (LA25_216=='\n') ) {s = 59;}

                        else if ( (LA25_216=='\r') ) {s = 60;}

                        else if ( (LA25_216=='\t') ) {s = 61;}

                        else if ( ((LA25_216>='0' && LA25_216<='9')||(LA25_216>='A' && LA25_216<='F')||(LA25_216>='a' && LA25_216<='f')) ) {s = 235;}

                        else if ( (LA25_216=='&') ) {s = 63;}

                        else if ( (LA25_216=='<') ) {s = 65;}

                        else if ( ((LA25_216>=' ' && LA25_216<='!')||(LA25_216>='#' && LA25_216<='%')||(LA25_216>='\'' && LA25_216<='/')||(LA25_216>=':' && LA25_216<=';')||(LA25_216>='=' && LA25_216<='@')||(LA25_216>='G' && LA25_216<='[')||(LA25_216>=']' && LA25_216<='`')||(LA25_216>='g' && LA25_216<='\u007F')) ) {s = 62;}

                        else if ( ((LA25_216>='\u0080' && LA25_216<='\uFFFF')) && (( inString ))) {s = 66;}

                         
                        input.seek(index25_216);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA25_18 = input.LA(1);

                         
                        int index25_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_18=='l') ) {s = 45;}

                        else if ( (LA25_18=='a') ) {s = 46;}

                        else if ( (LA25_18=='c') ) {s = 47;}

                        else if ( (LA25_18=='n') ) {s = 48;}

                        else if ( (LA25_18=='%'||(LA25_18>='.' && LA25_18<='/')) && (( inPath ))) {s = 37;}

                        else if ( ((LA25_18>='0' && LA25_18<='9')||(LA25_18>='A' && LA25_18<='Z')||LA25_18=='b'||(LA25_18>='d' && LA25_18<='k')||LA25_18=='m'||(LA25_18>='o' && LA25_18<='z')) ) {s = 38;}

                        else if ( (LA25_18=='-') ) {s = 39;}

                         
                        input.seek(index25_18);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA25_36 = input.LA(1);

                         
                        int index25_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_36=='d') ) {s = 75;}

                        else if ( ((LA25_36>='0' && LA25_36<='9')||(LA25_36>='A' && LA25_36<='Z')||(LA25_36>='a' && LA25_36<='c')||(LA25_36>='e' && LA25_36<='z')) ) {s = 38;}

                        else if ( (LA25_36=='%'||(LA25_36>='.' && LA25_36<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_36);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA25_111 = input.LA(1);

                         
                        int index25_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_111=='l') ) {s = 164;}

                        else if ( ((LA25_111>='0' && LA25_111<='9')||(LA25_111>='A' && LA25_111<='Z')||(LA25_111>='a' && LA25_111<='k')||(LA25_111>='m' && LA25_111<='z')) ) {s = 38;}

                        else if ( (LA25_111=='%'||(LA25_111>='.' && LA25_111<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_111);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA25_75 = input.LA(1);

                         
                        int index25_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_75=='u') ) {s = 111;}

                        else if ( ((LA25_75>='0' && LA25_75<='9')||(LA25_75>='A' && LA25_75<='Z')||(LA25_75>='a' && LA25_75<='t')||(LA25_75>='v' && LA25_75<='z')) ) {s = 38;}

                        else if ( (LA25_75=='%'||(LA25_75>='.' && LA25_75<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_75);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA25_164 = input.LA(1);

                         
                        int index25_164 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_164=='e') ) {s = 199;}

                        else if ( ((LA25_164>='0' && LA25_164<='9')||(LA25_164>='A' && LA25_164<='Z')||(LA25_164>='a' && LA25_164<='d')||(LA25_164>='f' && LA25_164<='z')) ) {s = 38;}

                        else if ( (LA25_164=='%'||(LA25_164>='.' && LA25_164<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_164);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA25_102 = input.LA(1);

                        s = -1;
                        if ( (LA25_102=='\"') ) {s = 146;}

                        else if ( (LA25_102=='\\') ) {s = 147;}

                        else if ( (LA25_102=='\n') ) {s = 140;}

                        else if ( (LA25_102=='\r') ) {s = 141;}

                        else if ( (LA25_102=='\t') ) {s = 142;}

                        else if ( ((LA25_102>=' ' && LA25_102<='!')||(LA25_102>='$' && LA25_102<='%')||(LA25_102>='\'' && LA25_102<='/')||LA25_102==';'||(LA25_102>='=' && LA25_102<='@')||LA25_102=='['||(LA25_102>=']' && LA25_102<='^')||LA25_102=='`'||(LA25_102>='{' && LA25_102<='\u007F')) ) {s = 148;}

                        else if ( (LA25_102=='&') ) {s = 149;}

                        else if ( (LA25_102=='#'||(LA25_102>='0' && LA25_102<=':')||(LA25_102>='A' && LA25_102<='Z')||LA25_102=='_'||(LA25_102>='a' && LA25_102<='z')) ) {s = 62;}

                        else if ( (LA25_102=='<') ) {s = 150;}

                        else if ( ((LA25_102>='\u0000' && LA25_102<='\b')||(LA25_102>='\u000B' && LA25_102<='\f')||(LA25_102>='\u000E' && LA25_102<='\u001F')) ) {s = 104;}

                        else if ( ((LA25_102>='\u0080' && LA25_102<='\uFFFF')) ) {s = 102;}

                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA25_38 = input.LA(1);

                         
                        int index25_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_38>='0' && LA25_38<='9')||(LA25_38>='A' && LA25_38<='Z')||(LA25_38>='a' && LA25_38<='z')) ) {s = 38;}

                        else if ( (LA25_38=='%'||(LA25_38>='.' && LA25_38<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_38);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA25_190 = input.LA(1);

                         
                        int index25_190 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_190=='\"') ) {s = 64;}

                        else if ( (LA25_190=='\\') ) {s = 58;}

                        else if ( (LA25_190=='\n') ) {s = 59;}

                        else if ( (LA25_190=='\r') ) {s = 60;}

                        else if ( (LA25_190=='\t') ) {s = 61;}

                        else if ( ((LA25_190>='-' && LA25_190<='.')||(LA25_190>='0' && LA25_190<=':')||(LA25_190>='A' && LA25_190<='Z')||LA25_190=='_'||(LA25_190>='a' && LA25_190<='z')) ) {s = 218;}

                        else if ( (LA25_190=='&') ) {s = 63;}

                        else if ( (LA25_190==';') ) {s = 219;}

                        else if ( ((LA25_190>=' ' && LA25_190<='!')||(LA25_190>='#' && LA25_190<='%')||(LA25_190>='\'' && LA25_190<=',')||LA25_190=='/'||(LA25_190>='=' && LA25_190<='@')||LA25_190=='['||(LA25_190>=']' && LA25_190<='^')||LA25_190=='`'||(LA25_190>='{' && LA25_190<='\u007F')) ) {s = 62;}

                        else if ( (LA25_190=='<') ) {s = 65;}

                        else if ( ((LA25_190>='\u0080' && LA25_190<='\uFFFF')) && (( inString ))) {s = 66;}

                         
                        input.seek(index25_190);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA25_114 = input.LA(1);

                         
                        int index25_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_114>='0' && LA25_114<='9')||(LA25_114>='A' && LA25_114<='Z')||(LA25_114>='a' && LA25_114<='z')) ) {s = 38;}

                        else if ( (LA25_114=='%'||(LA25_114>='.' && LA25_114<='/')) && (( inPath ))) {s = 37;}

                        else if ( (LA25_114=='-') ) {s = 39;}

                        else s = 166;

                         
                        input.seek(index25_114);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA25_29 = input.LA(1);

                         
                        int index25_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_29>='0' && LA25_29<='9')) ) {s = 29;}

                        else if ( (LA25_29=='%'||(LA25_29>='.' && LA25_29<='/')||(LA25_29>='A' && LA25_29<='Z')||(LA25_29>='a' && LA25_29<='z')) && (( inPath ))) {s = 37;}

                        else s = 57;

                         
                        input.seek(index25_29);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA25_147 = input.LA(1);

                        s = -1;
                        if ( (LA25_147=='\\') ) {s = 188;}

                        else if ( (LA25_147=='\"') ) {s = 185;}

                        else if ( ((LA25_147>=' ' && LA25_147<='!')||(LA25_147>='$' && LA25_147<='%')||(LA25_147>='\'' && LA25_147<='/')||LA25_147==';'||(LA25_147>='=' && LA25_147<='@')||LA25_147=='['||(LA25_147>=']' && LA25_147<='^')||LA25_147=='`'||(LA25_147>='{' && LA25_147<='\u007F')) ) {s = 143;}

                        else if ( (LA25_147=='\n') ) {s = 140;}

                        else if ( (LA25_147=='\r') ) {s = 141;}

                        else if ( (LA25_147=='\t') ) {s = 142;}

                        else if ( (LA25_147=='&') ) {s = 144;}

                        else if ( (LA25_147=='#'||(LA25_147>='0' && LA25_147<=':')||(LA25_147>='A' && LA25_147<='Z')||LA25_147=='_'||(LA25_147>='a' && LA25_147<='z')) ) {s = 94;}

                        else if ( (LA25_147=='<') ) {s = 145;}

                        else if ( ((LA25_147>='\u0000' && LA25_147<='\b')||(LA25_147>='\u000B' && LA25_147<='\f')||(LA25_147>='\u000E' && LA25_147<='\u001F')||(LA25_147>='\u0080' && LA25_147<='\uFFFF')) ) {s = 104;}

                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA25_123 = input.LA(1);

                         
                        int index25_123 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_123=='r') ) {s = 173;}

                        else if ( ((LA25_123>='0' && LA25_123<='9')||(LA25_123>='A' && LA25_123<='Z')||(LA25_123>='a' && LA25_123<='q')||(LA25_123>='s' && LA25_123<='z')) ) {s = 38;}

                        else if ( (LA25_123=='%'||(LA25_123>='.' && LA25_123<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_123);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA25_149 = input.LA(1);

                        s = -1;
                        if ( (LA25_149=='#') ) {s = 189;}

                        else if ( (LA25_149==':'||(LA25_149>='A' && LA25_149<='Z')||LA25_149=='_'||(LA25_149>='a' && LA25_149<='z')) ) {s = 190;}

                        else if ( (LA25_149=='\"') ) {s = 146;}

                        else if ( (LA25_149=='\\') ) {s = 147;}

                        else if ( (LA25_149=='\n') ) {s = 140;}

                        else if ( (LA25_149=='\r') ) {s = 141;}

                        else if ( (LA25_149=='\t') ) {s = 142;}

                        else if ( ((LA25_149>=' ' && LA25_149<='!')||(LA25_149>='$' && LA25_149<='%')||(LA25_149>='\'' && LA25_149<='/')||LA25_149==';'||(LA25_149>='=' && LA25_149<='@')||LA25_149=='['||(LA25_149>=']' && LA25_149<='^')||LA25_149=='`'||(LA25_149>='{' && LA25_149<='\u007F')) ) {s = 148;}

                        else if ( (LA25_149=='&') ) {s = 149;}

                        else if ( ((LA25_149>='0' && LA25_149<='9')) ) {s = 62;}

                        else if ( (LA25_149=='<') ) {s = 150;}

                        else if ( ((LA25_149>='\u0080' && LA25_149<='\uFFFF')) ) {s = 102;}

                        else if ( ((LA25_149>='\u0000' && LA25_149<='\b')||(LA25_149>='\u000B' && LA25_149<='\f')||(LA25_149>='\u000E' && LA25_149<='\u001F')) ) {s = 104;}

                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA25_173 = input.LA(1);

                         
                        int index25_173 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_173=='d') ) {s = 204;}

                        else if ( ((LA25_173>='0' && LA25_173<='9')||(LA25_173>='A' && LA25_173<='Z')||(LA25_173>='a' && LA25_173<='c')||(LA25_173>='e' && LA25_173<='z')) ) {s = 38;}

                        else if ( (LA25_173=='%'||(LA25_173>='.' && LA25_173<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_173);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA25_54 = input.LA(1);

                         
                        int index25_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_54=='c') ) {s = 89;}

                        else if ( ((LA25_54>='0' && LA25_54<='9')||(LA25_54>='A' && LA25_54<='Z')||(LA25_54>='a' && LA25_54<='b')||(LA25_54>='d' && LA25_54<='z')) ) {s = 38;}

                        else if ( (LA25_54=='%'||(LA25_54>='.' && LA25_54<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_54);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA25_89 = input.LA(1);

                         
                        int index25_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_89=='o') ) {s = 123;}

                        else if ( ((LA25_89>='0' && LA25_89<='9')||(LA25_89>='A' && LA25_89<='Z')||(LA25_89>='a' && LA25_89<='n')||(LA25_89>='p' && LA25_89<='z')) ) {s = 38;}

                        else if ( (LA25_89=='%'||(LA25_89>='.' && LA25_89<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_89);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA25_115 = input.LA(1);

                         
                        int index25_115 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_115>='0' && LA25_115<='9')||(LA25_115>='A' && LA25_115<='Z')||(LA25_115>='a' && LA25_115<='z')) ) {s = 38;}

                        else if ( (LA25_115=='%'||(LA25_115>='.' && LA25_115<='/')) && (( inPath ))) {s = 37;}

                        else if ( (LA25_115=='-') ) {s = 39;}

                        else s = 167;

                         
                        input.seek(index25_115);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA25_135 = input.LA(1);

                         
                        int index25_135 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_135==';') ) {s = 183;}

                        else if ( ((LA25_135>='0' && LA25_135<='9')) ) {s = 135;}

                        else if ( ((LA25_135>=' ' && LA25_135<='/')||LA25_135==':'||(LA25_135>='<' && LA25_135<='\uFFFF')) && (( inString ))) {s = 66;}

                         
                        input.seek(index25_135);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA25_85 = input.LA(1);

                         
                        int index25_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_85=='t') ) {s = 119;}

                        else if ( ((LA25_85>='0' && LA25_85<='9')||(LA25_85>='A' && LA25_85<='Z')||(LA25_85>='a' && LA25_85<='s')||(LA25_85>='u' && LA25_85<='z')) ) {s = 38;}

                        else if ( (LA25_85=='%'||(LA25_85>='.' && LA25_85<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_85);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA25_26 = input.LA(1);

                         
                        int index25_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_26=='e') ) {s = 54;}

                        else if ( (LA25_26=='%'||(LA25_26>='.' && LA25_26<='/')) && (( inPath ))) {s = 37;}

                        else if ( ((LA25_26>='0' && LA25_26<='9')||(LA25_26>='A' && LA25_26<='Z')||(LA25_26>='a' && LA25_26<='d')||(LA25_26>='f' && LA25_26<='z')) ) {s = 38;}

                        else if ( (LA25_26=='-') ) {s = 39;}

                         
                        input.seek(index25_26);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA25_50 = input.LA(1);

                         
                        int index25_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_50=='s') ) {s = 85;}

                        else if ( ((LA25_50>='0' && LA25_50<='9')||(LA25_50>='A' && LA25_50<='Z')||(LA25_50>='a' && LA25_50<='r')||(LA25_50>='t' && LA25_50<='z')) ) {s = 38;}

                        else if ( (LA25_50=='%'||(LA25_50>='.' && LA25_50<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_50);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA25_171 = input.LA(1);

                         
                        int index25_171 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_171=='n') ) {s = 202;}

                        else if ( ((LA25_171>='0' && LA25_171<='9')||(LA25_171>='A' && LA25_171<='Z')||(LA25_171>='a' && LA25_171<='m')||(LA25_171>='o' && LA25_171<='z')) ) {s = 38;}

                        else if ( (LA25_171=='%'||(LA25_171>='.' && LA25_171<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_171);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA25_121 = input.LA(1);

                         
                        int index25_121 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_121=='e') ) {s = 171;}

                        else if ( ((LA25_121>='0' && LA25_121<='9')||(LA25_121>='A' && LA25_121<='Z')||(LA25_121>='a' && LA25_121<='d')||(LA25_121>='f' && LA25_121<='z')) ) {s = 38;}

                        else if ( (LA25_121=='%'||(LA25_121>='.' && LA25_121<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_121);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA25_191 = input.LA(1);

                        s = -1;
                        if ( (LA25_191=='\"') ) {s = 146;}

                        else if ( (LA25_191=='\\') ) {s = 147;}

                        else if ( (LA25_191=='\n') ) {s = 140;}

                        else if ( (LA25_191=='\r') ) {s = 141;}

                        else if ( (LA25_191=='\t') ) {s = 142;}

                        else if ( ((LA25_191>=' ' && LA25_191<='!')||(LA25_191>='$' && LA25_191<='%')||(LA25_191>='\'' && LA25_191<='/')||LA25_191==';'||(LA25_191>='=' && LA25_191<='@')||LA25_191=='['||(LA25_191>=']' && LA25_191<='^')||LA25_191=='`'||(LA25_191>='{' && LA25_191<='\u007F')) ) {s = 148;}

                        else if ( (LA25_191=='&') ) {s = 149;}

                        else if ( (LA25_191=='#'||(LA25_191>='0' && LA25_191<=':')||(LA25_191>='A' && LA25_191<='Z')||LA25_191=='_'||(LA25_191>='a' && LA25_191<='z')) ) {s = 62;}

                        else if ( (LA25_191=='<') ) {s = 150;}

                        else if ( ((LA25_191>='\u0000' && LA25_191<='\b')||(LA25_191>='\u000B' && LA25_191<='\f')||(LA25_191>='\u000E' && LA25_191<='\u001F')) ) {s = 104;}

                        else if ( ((LA25_191>='\u0080' && LA25_191<='\uFFFF')) ) {s = 102;}

                        else s = 97;

                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA25_202 = input.LA(1);

                         
                        int index25_202 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_202=='t') ) {s = 228;}

                        else if ( ((LA25_202>='0' && LA25_202<='9')||(LA25_202>='A' && LA25_202<='Z')||(LA25_202>='a' && LA25_202<='s')||(LA25_202>='u' && LA25_202<='z')) ) {s = 38;}

                        else if ( (LA25_202=='%'||(LA25_202>='.' && LA25_202<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_202);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA25_87 = input.LA(1);

                         
                        int index25_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_87=='m') ) {s = 121;}

                        else if ( ((LA25_87>='0' && LA25_87<='9')||(LA25_87>='A' && LA25_87<='Z')||(LA25_87>='a' && LA25_87<='l')||(LA25_87>='n' && LA25_87<='z')) ) {s = 38;}

                        else if ( (LA25_87=='%'||(LA25_87>='.' && LA25_87<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_87);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA25_196 = input.LA(1);

                        s = -1;
                        if ( (LA25_196=='<') ) {s = 156;}

                        else if ( (LA25_196=='\\') ) {s = 157;}

                        else if ( (LA25_196=='\n') ) {s = 158;}

                        else if ( (LA25_196=='\r') ) {s = 159;}

                        else if ( (LA25_196=='\t') ) {s = 160;}

                        else if ( ((LA25_196>=' ' && LA25_196<='!')||(LA25_196>='$' && LA25_196<='%')||(LA25_196>='\'' && LA25_196<='/')||LA25_196==';'||(LA25_196>='=' && LA25_196<='@')||LA25_196=='['||(LA25_196>=']' && LA25_196<='^')||LA25_196=='`'||(LA25_196>='{' && LA25_196<='\u007F')) ) {s = 161;}

                        else if ( (LA25_196=='&') ) {s = 162;}

                        else if ( (LA25_196=='#'||(LA25_196>='0' && LA25_196<=':')||(LA25_196>='A' && LA25_196<='Z')||LA25_196=='_'||(LA25_196>='a' && LA25_196<='z')) ) {s = 71;}

                        else if ( (LA25_196=='\"') ) {s = 163;}

                        else if ( ((LA25_196>='\u0000' && LA25_196<='\b')||(LA25_196>='\u000B' && LA25_196<='\f')||(LA25_196>='\u000E' && LA25_196<='\u001F')||(LA25_196>='\u0080' && LA25_196<='\uFFFF')) ) {s = 110;}

                        else s = 74;

                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA25_52 = input.LA(1);

                         
                        int index25_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_52=='m') ) {s = 87;}

                        else if ( ((LA25_52>='0' && LA25_52<='9')||(LA25_52>='A' && LA25_52<='Z')||(LA25_52>='a' && LA25_52<='l')||(LA25_52>='n' && LA25_52<='z')) ) {s = 38;}

                        else if ( (LA25_52=='%'||(LA25_52>='.' && LA25_52<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_52);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA25_174 = input.LA(1);

                         
                        int index25_174 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_174=='g') ) {s = 205;}

                        else if ( ((LA25_174>='0' && LA25_174<='9')||(LA25_174>='A' && LA25_174<='Z')||(LA25_174>='a' && LA25_174<='f')||(LA25_174>='h' && LA25_174<='z')) ) {s = 38;}

                        else if ( (LA25_174=='%'||(LA25_174>='.' && LA25_174<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_174);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA25_55 = input.LA(1);

                         
                        int index25_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_55=='r') ) {s = 90;}

                        else if ( ((LA25_55>='0' && LA25_55<='9')||(LA25_55>='A' && LA25_55<='Z')||(LA25_55>='a' && LA25_55<='q')||(LA25_55>='s' && LA25_55<='z')) ) {s = 38;}

                        else if ( (LA25_55=='%'||(LA25_55>='.' && LA25_55<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_55);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA25_124 = input.LA(1);

                         
                        int index25_124 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_124=='n') ) {s = 174;}

                        else if ( ((LA25_124>='0' && LA25_124<='9')||(LA25_124>='A' && LA25_124<='Z')||(LA25_124>='a' && LA25_124<='m')||(LA25_124>='o' && LA25_124<='z')) ) {s = 38;}

                        else if ( (LA25_124=='%'||(LA25_124>='.' && LA25_124<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_124);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA25_151 = input.LA(1);

                        s = -1;
                        if ( (LA25_151=='n') ) {s = 126;}

                        else if ( (LA25_151=='t') ) {s = 127;}

                        else if ( (LA25_151=='\"') ) {s = 191;}

                        else if ( (LA25_151=='\\') ) {s = 192;}

                        else if ( (LA25_151=='a') ) {s = 130;}

                        else if ( ((LA25_151>=' ' && LA25_151<='!')||(LA25_151>='$' && LA25_151<='%')||(LA25_151>='\'' && LA25_151<='/')||LA25_151==';'||(LA25_151>='=' && LA25_151<='@')||LA25_151=='['||(LA25_151>=']' && LA25_151<='^')||LA25_151=='`'||(LA25_151>='{' && LA25_151<='\u007F')) ) {s = 143;}

                        else if ( (LA25_151=='\n') ) {s = 140;}

                        else if ( (LA25_151=='\r') ) {s = 141;}

                        else if ( (LA25_151=='\t') ) {s = 142;}

                        else if ( (LA25_151=='&') ) {s = 144;}

                        else if ( (LA25_151=='#'||(LA25_151>='0' && LA25_151<=':')||(LA25_151>='A' && LA25_151<='Z')||LA25_151=='_'||(LA25_151>='b' && LA25_151<='m')||(LA25_151>='o' && LA25_151<='s')||(LA25_151>='u' && LA25_151<='z')) ) {s = 94;}

                        else if ( (LA25_151=='<') ) {s = 145;}

                        else if ( ((LA25_151>='\u0000' && LA25_151<='\b')||(LA25_151>='\u000B' && LA25_151<='\f')||(LA25_151>='\u000E' && LA25_151<='\u001F')||(LA25_151>='\u0080' && LA25_151<='\uFFFF')) ) {s = 104;}

                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA25_90 = input.LA(1);

                         
                        int index25_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_90=='i') ) {s = 124;}

                        else if ( ((LA25_90>='0' && LA25_90<='9')||(LA25_90>='A' && LA25_90<='Z')||(LA25_90>='a' && LA25_90<='h')||(LA25_90>='j' && LA25_90<='z')) ) {s = 38;}

                        else if ( (LA25_90=='%'||(LA25_90>='.' && LA25_90<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_90);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA25_150 = input.LA(1);

                        s = -1;
                        if ( (LA25_150=='\"') ) {s = 146;}

                        else if ( (LA25_150=='\\') ) {s = 147;}

                        else if ( (LA25_150=='\n') ) {s = 140;}

                        else if ( (LA25_150=='\r') ) {s = 141;}

                        else if ( (LA25_150=='\t') ) {s = 142;}

                        else if ( ((LA25_150>=' ' && LA25_150<='!')||(LA25_150>='$' && LA25_150<='%')||(LA25_150>='\'' && LA25_150<='/')||LA25_150==';'||(LA25_150>='=' && LA25_150<='@')||LA25_150=='['||(LA25_150>=']' && LA25_150<='^')||LA25_150=='`'||(LA25_150>='{' && LA25_150<='\u007F')) ) {s = 148;}

                        else if ( (LA25_150=='&') ) {s = 149;}

                        else if ( (LA25_150=='#'||(LA25_150>='0' && LA25_150<=':')||(LA25_150>='A' && LA25_150<='Z')||LA25_150=='_'||(LA25_150>='a' && LA25_150<='z')) ) {s = 62;}

                        else if ( (LA25_150=='<') ) {s = 150;}

                        else if ( ((LA25_150>='\u0080' && LA25_150<='\uFFFF')) ) {s = 102;}

                        else if ( ((LA25_150>='\u0000' && LA25_150<='\b')||(LA25_150>='\u000B' && LA25_150<='\f')||(LA25_150>='\u000E' && LA25_150<='\u001F')) ) {s = 104;}

                        else s = 96;

                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA25_48 = input.LA(1);

                         
                        int index25_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_48=='d') ) {s = 83;}

                        else if ( ((LA25_48>='0' && LA25_48<='9')||(LA25_48>='A' && LA25_48<='Z')||(LA25_48>='a' && LA25_48<='c')||(LA25_48>='e' && LA25_48<='z')) ) {s = 38;}

                        else if ( (LA25_48=='%'||(LA25_48>='.' && LA25_48<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_48);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA25_128 = input.LA(1);

                         
                        int index25_128 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_128=='\"') ) {s = 64;}

                        else if ( ((LA25_128>=' ' && LA25_128<='!')||(LA25_128>='#' && LA25_128<='%')||(LA25_128>='\'' && LA25_128<=';')||(LA25_128>='=' && LA25_128<='[')||(LA25_128>=']' && LA25_128<='\u007F')) ) {s = 62;}

                        else if ( (LA25_128=='\\') ) {s = 58;}

                        else if ( (LA25_128=='&') ) {s = 63;}

                        else if ( (LA25_128=='\n') ) {s = 59;}

                        else if ( (LA25_128=='\r') ) {s = 60;}

                        else if ( (LA25_128=='\t') ) {s = 61;}

                        else if ( (LA25_128=='<') ) {s = 65;}

                        else if ( ((LA25_128>='\u0080' && LA25_128<='\uFFFF')) && (( inString ))) {s = 66;}

                        else s = 97;

                         
                        input.seek(index25_128);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA25_79 = input.LA(1);

                         
                        int index25_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_79>='0' && LA25_79<='9')||(LA25_79>='A' && LA25_79<='Z')||(LA25_79>='a' && LA25_79<='z')) ) {s = 38;}

                        else if ( (LA25_79=='%'||(LA25_79>='.' && LA25_79<='/')) && (( inPath ))) {s = 37;}

                        else if ( (LA25_79=='-') ) {s = 39;}

                        else s = 113;

                         
                        input.seek(index25_79);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA25_41 = input.LA(1);

                         
                        int index25_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_41>='0' && LA25_41<='9')||(LA25_41>='A' && LA25_41<='Z')||(LA25_41>='a' && LA25_41<='z')) ) {s = 38;}

                        else if ( (LA25_41=='%'||(LA25_41>='.' && LA25_41<='/')) && (( inPath ))) {s = 37;}

                        else if ( (LA25_41=='-') ) {s = 39;}

                        else s = 77;

                         
                        input.seek(index25_41);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA25_56 = input.LA(1);

                         
                        int index25_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_56=='t') ) {s = 91;}

                        else if ( ((LA25_56>='0' && LA25_56<='9')||(LA25_56>='A' && LA25_56<='Z')||(LA25_56>='a' && LA25_56<='s')||(LA25_56>='u' && LA25_56<='z')) ) {s = 38;}

                        else if ( (LA25_56=='%'||(LA25_56>='.' && LA25_56<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_56);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA25_91 = input.LA(1);

                         
                        int index25_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_91=='e') ) {s = 125;}

                        else if ( ((LA25_91>='0' && LA25_91<='9')||(LA25_91>='A' && LA25_91<='Z')||(LA25_91>='a' && LA25_91<='d')||(LA25_91>='f' && LA25_91<='z')) ) {s = 38;}

                        else if ( (LA25_91=='%'||(LA25_91>='.' && LA25_91<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_91);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA25_218 = input.LA(1);

                         
                        int index25_218 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_218==';') ) {s = 219;}

                        else if ( ((LA25_218>='-' && LA25_218<='.')||(LA25_218>='0' && LA25_218<=':')||(LA25_218>='A' && LA25_218<='Z')||LA25_218=='_'||(LA25_218>='a' && LA25_218<='z')) ) {s = 218;}

                        else if ( (LA25_218=='\"') ) {s = 64;}

                        else if ( (LA25_218=='\\') ) {s = 58;}

                        else if ( (LA25_218=='\n') ) {s = 59;}

                        else if ( (LA25_218=='\r') ) {s = 60;}

                        else if ( (LA25_218=='\t') ) {s = 61;}

                        else if ( ((LA25_218>=' ' && LA25_218<='!')||(LA25_218>='#' && LA25_218<='%')||(LA25_218>='\'' && LA25_218<=',')||LA25_218=='/'||(LA25_218>='=' && LA25_218<='@')||LA25_218=='['||(LA25_218>=']' && LA25_218<='^')||LA25_218=='`'||(LA25_218>='{' && LA25_218<='\u007F')) ) {s = 62;}

                        else if ( (LA25_218=='&') ) {s = 63;}

                        else if ( (LA25_218=='<') ) {s = 65;}

                        else if ( ((LA25_218>='\u0080' && LA25_218<='\uFFFF')) && (( inString ))) {s = 66;}

                         
                        input.seek(index25_218);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA25_21 = input.LA(1);

                         
                        int index25_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_21=='i') ) {s = 53;}

                        else if ( (LA25_21=='%'||(LA25_21>='.' && LA25_21<='/')) && (( inPath ))) {s = 37;}

                        else if ( ((LA25_21>='0' && LA25_21<='9')||(LA25_21>='A' && LA25_21<='Z')||(LA25_21>='a' && LA25_21<='h')||(LA25_21>='j' && LA25_21<='z')) ) {s = 38;}

                        else if ( (LA25_21=='-') ) {s = 39;}

                         
                        input.seek(index25_21);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA25_138 = input.LA(1);

                        s = -1;
                        if ( (LA25_138=='\"') ) {s = 138;}

                        else if ( (LA25_138=='\\') ) {s = 139;}

                        else if ( (LA25_138=='\n') ) {s = 140;}

                        else if ( (LA25_138=='\r') ) {s = 141;}

                        else if ( (LA25_138=='\t') ) {s = 142;}

                        else if ( ((LA25_138>=' ' && LA25_138<='!')||(LA25_138>='$' && LA25_138<='%')||(LA25_138>='\'' && LA25_138<='/')||LA25_138==';'||(LA25_138>='=' && LA25_138<='@')||LA25_138=='['||(LA25_138>=']' && LA25_138<='^')||LA25_138=='`'||(LA25_138>='{' && LA25_138<='\u007F')) ) {s = 143;}

                        else if ( (LA25_138=='&') ) {s = 144;}

                        else if ( (LA25_138=='#'||(LA25_138>='0' && LA25_138<=':')||(LA25_138>='A' && LA25_138<='Z')||LA25_138=='_'||(LA25_138>='a' && LA25_138<='z')) ) {s = 94;}

                        else if ( (LA25_138=='<') ) {s = 145;}

                        else if ( ((LA25_138>='\u0000' && LA25_138<='\b')||(LA25_138>='\u000B' && LA25_138<='\f')||(LA25_138>='\u000E' && LA25_138<='\u001F')||(LA25_138>='\u0080' && LA25_138<='\uFFFF')) ) {s = 104;}

                        else s = 97;

                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA25_80 = input.LA(1);

                         
                        int index25_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_80=='e') ) {s = 114;}

                        else if ( ((LA25_80>='0' && LA25_80<='9')||(LA25_80>='A' && LA25_80<='Z')||(LA25_80>='a' && LA25_80<='d')||(LA25_80>='f' && LA25_80<='z')) ) {s = 38;}

                        else if ( (LA25_80=='%'||(LA25_80>='.' && LA25_80<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_80);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA25_45 = input.LA(1);

                         
                        int index25_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_45=='s') ) {s = 80;}

                        else if ( ((LA25_45>='0' && LA25_45<='9')||(LA25_45>='A' && LA25_45<='Z')||(LA25_45>='a' && LA25_45<='r')||(LA25_45>='t' && LA25_45<='z')) ) {s = 38;}

                        else if ( (LA25_45=='%'||(LA25_45>='.' && LA25_45<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_45);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA25_116 = input.LA(1);

                         
                        int index25_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_116>='0' && LA25_116<='9')||(LA25_116>='A' && LA25_116<='Z')||(LA25_116>='a' && LA25_116<='z')) ) {s = 38;}

                        else if ( (LA25_116=='%'||(LA25_116>='.' && LA25_116<='/')) && (( inPath ))) {s = 37;}

                        else if ( (LA25_116=='-') ) {s = 39;}

                        else s = 168;

                         
                        input.seek(index25_116);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA25_44 = input.LA(1);

                         
                        int index25_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_44=='f') ) {s = 79;}

                        else if ( ((LA25_44>='0' && LA25_44<='9')||(LA25_44>='A' && LA25_44<='Z')||(LA25_44>='a' && LA25_44<='e')||(LA25_44>='g' && LA25_44<='z')) ) {s = 38;}

                        else if ( (LA25_44=='%'||(LA25_44>='.' && LA25_44<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_44);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA25_146 = input.LA(1);

                        s = -1;
                        if ( (LA25_146=='\"') ) {s = 138;}

                        else if ( (LA25_146=='\\') ) {s = 139;}

                        else if ( (LA25_146=='\n') ) {s = 140;}

                        else if ( (LA25_146=='\r') ) {s = 141;}

                        else if ( (LA25_146=='\t') ) {s = 142;}

                        else if ( ((LA25_146>=' ' && LA25_146<='!')||(LA25_146>='$' && LA25_146<='%')||(LA25_146>='\'' && LA25_146<='/')||LA25_146==';'||(LA25_146>='=' && LA25_146<='@')||LA25_146=='['||(LA25_146>=']' && LA25_146<='^')||LA25_146=='`'||(LA25_146>='{' && LA25_146<='\u007F')) ) {s = 143;}

                        else if ( (LA25_146=='&') ) {s = 144;}

                        else if ( (LA25_146=='#'||(LA25_146>='0' && LA25_146<=':')||(LA25_146>='A' && LA25_146<='Z')||LA25_146=='_'||(LA25_146>='a' && LA25_146<='z')) ) {s = 94;}

                        else if ( (LA25_146=='<') ) {s = 145;}

                        else if ( ((LA25_146>='\u0000' && LA25_146<='\b')||(LA25_146>='\u000B' && LA25_146<='\f')||(LA25_146>='\u000E' && LA25_146<='\u001F')||(LA25_146>='\u0080' && LA25_146<='\uFFFF')) ) {s = 104;}

                        else s = 105;

                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA25_49 = input.LA(1);

                         
                        int index25_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_49=='t') ) {s = 84;}

                        else if ( ((LA25_49>='0' && LA25_49<='9')||(LA25_49>='A' && LA25_49<='Z')||(LA25_49>='a' && LA25_49<='s')||(LA25_49>='u' && LA25_49<='z')) ) {s = 38;}

                        else if ( (LA25_49=='%'||(LA25_49>='.' && LA25_49<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_49);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA25_170 = input.LA(1);

                         
                        int index25_170 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_170>='0' && LA25_170<='9')||(LA25_170>='A' && LA25_170<='Z')||(LA25_170>='a' && LA25_170<='z')) ) {s = 38;}

                        else if ( (LA25_170=='%'||(LA25_170>='.' && LA25_170<='/')) && (( inPath ))) {s = 37;}

                        else if ( (LA25_170=='-') ) {s = 39;}

                        else s = 201;

                         
                        input.seek(index25_170);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA25_244 = input.LA(1);

                         
                        int index25_244 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_244=='\"') ) {s = 64;}

                        else if ( (LA25_244=='\\') ) {s = 58;}

                        else if ( (LA25_244=='\n') ) {s = 59;}

                        else if ( (LA25_244=='\r') ) {s = 60;}

                        else if ( (LA25_244=='\t') ) {s = 61;}

                        else if ( ((LA25_244>=' ' && LA25_244<='!')||(LA25_244>='#' && LA25_244<='%')||(LA25_244>='\'' && LA25_244<=';')||(LA25_244>='=' && LA25_244<='[')||(LA25_244>=']' && LA25_244<='\u007F')) ) {s = 62;}

                        else if ( (LA25_244=='&') ) {s = 63;}

                        else if ( (LA25_244=='<') ) {s = 65;}

                        else if ( ((LA25_244>='\u0080' && LA25_244<='\uFFFF')) && (( inString ))) {s = 66;}

                         
                        input.seek(index25_244);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA25_8 = input.LA(1);

                         
                        int index25_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_8=='%'||(LA25_8>='.' && LA25_8<='9')||(LA25_8>='A' && LA25_8<='Z')||(LA25_8>='a' && LA25_8<='z')) && (( inPath ))) {s = 37;}

                        else s = 43;

                         
                        input.seek(index25_8);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA25_81 = input.LA(1);

                         
                        int index25_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_81=='h') ) {s = 115;}

                        else if ( ((LA25_81>='0' && LA25_81<='9')||(LA25_81>='A' && LA25_81<='Z')||(LA25_81>='a' && LA25_81<='g')||(LA25_81>='i' && LA25_81<='z')) ) {s = 38;}

                        else if ( (LA25_81=='%'||(LA25_81>='.' && LA25_81<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_81);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA25_217 = input.LA(1);

                         
                        int index25_217 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_217==';') ) {s = 236;}

                        else if ( ((LA25_217>='0' && LA25_217<='9')) ) {s = 217;}

                        else if ( (LA25_217=='\"') ) {s = 64;}

                        else if ( (LA25_217=='\\') ) {s = 58;}

                        else if ( (LA25_217=='\n') ) {s = 59;}

                        else if ( (LA25_217=='\r') ) {s = 60;}

                        else if ( (LA25_217=='\t') ) {s = 61;}

                        else if ( ((LA25_217>=' ' && LA25_217<='!')||(LA25_217>='#' && LA25_217<='%')||(LA25_217>='\'' && LA25_217<='/')||LA25_217==':'||(LA25_217>='=' && LA25_217<='[')||(LA25_217>=']' && LA25_217<='\u007F')) ) {s = 62;}

                        else if ( (LA25_217=='&') ) {s = 63;}

                        else if ( (LA25_217=='<') ) {s = 65;}

                        else if ( ((LA25_217>='\u0080' && LA25_217<='\uFFFF')) && (( inString ))) {s = 66;}

                         
                        input.seek(index25_217);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA25_46 = input.LA(1);

                         
                        int index25_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_46=='c') ) {s = 81;}

                        else if ( ((LA25_46>='0' && LA25_46<='9')||(LA25_46>='A' && LA25_46<='Z')||(LA25_46>='a' && LA25_46<='b')||(LA25_46>='d' && LA25_46<='z')) ) {s = 38;}

                        else if ( (LA25_46=='%'||(LA25_46>='.' && LA25_46<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_46);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA25_82 = input.LA(1);

                         
                        int index25_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_82=='o') ) {s = 116;}

                        else if ( ((LA25_82>='0' && LA25_82<='9')||(LA25_82>='A' && LA25_82<='Z')||(LA25_82>='a' && LA25_82<='n')||(LA25_82>='p' && LA25_82<='z')) ) {s = 38;}

                        else if ( (LA25_82=='%'||(LA25_82>='.' && LA25_82<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_82);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA25_86 = input.LA(1);

                         
                        int index25_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_86=='t') ) {s = 120;}

                        else if ( ((LA25_86>='0' && LA25_86<='9')||(LA25_86>='A' && LA25_86<='Z')||(LA25_86>='a' && LA25_86<='s')||(LA25_86>='u' && LA25_86<='z')) ) {s = 38;}

                        else if ( (LA25_86=='%'||(LA25_86>='.' && LA25_86<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_86);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA25_51 = input.LA(1);

                         
                        int index25_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_51=='a') ) {s = 86;}

                        else if ( ((LA25_51>='0' && LA25_51<='9')||(LA25_51>='A' && LA25_51<='Z')||(LA25_51>='b' && LA25_51<='z')) ) {s = 38;}

                        else if ( (LA25_51=='%'||(LA25_51>='.' && LA25_51<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_51);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA25_84 = input.LA(1);

                         
                        int index25_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_84>='0' && LA25_84<='9')||(LA25_84>='A' && LA25_84<='Z')||(LA25_84>='a' && LA25_84<='z')) ) {s = 38;}

                        else if ( (LA25_84=='%'||(LA25_84>='.' && LA25_84<='/')) && (( inPath ))) {s = 37;}

                        else if ( (LA25_84=='-') ) {s = 39;}

                        else s = 118;

                         
                        input.seek(index25_84);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA25_163 = input.LA(1);

                        s = -1;
                        if ( (LA25_163=='<') ) {s = 156;}

                        else if ( (LA25_163=='\\') ) {s = 157;}

                        else if ( (LA25_163=='\n') ) {s = 158;}

                        else if ( (LA25_163=='\r') ) {s = 159;}

                        else if ( (LA25_163=='\t') ) {s = 160;}

                        else if ( ((LA25_163>=' ' && LA25_163<='!')||(LA25_163>='$' && LA25_163<='%')||(LA25_163>='\'' && LA25_163<='/')||LA25_163==';'||(LA25_163>='=' && LA25_163<='@')||LA25_163=='['||(LA25_163>=']' && LA25_163<='^')||LA25_163=='`'||(LA25_163>='{' && LA25_163<='\u007F')) ) {s = 161;}

                        else if ( (LA25_163=='&') ) {s = 162;}

                        else if ( (LA25_163=='#'||(LA25_163>='0' && LA25_163<=':')||(LA25_163>='A' && LA25_163<='Z')||LA25_163=='_'||(LA25_163>='a' && LA25_163<='z')) ) {s = 71;}

                        else if ( (LA25_163=='\"') ) {s = 163;}

                        else if ( ((LA25_163>='\u0000' && LA25_163<='\b')||(LA25_163>='\u000B' && LA25_163<='\f')||(LA25_163>='\u000E' && LA25_163<='\u001F')||(LA25_163>='\u0080' && LA25_163<='\uFFFF')) ) {s = 110;}

                        else s = 74;

                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA25_236 = input.LA(1);

                         
                        int index25_236 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_236=='\"') ) {s = 64;}

                        else if ( (LA25_236=='\\') ) {s = 58;}

                        else if ( (LA25_236=='\n') ) {s = 59;}

                        else if ( (LA25_236=='\r') ) {s = 60;}

                        else if ( (LA25_236=='\t') ) {s = 61;}

                        else if ( ((LA25_236>=' ' && LA25_236<='!')||(LA25_236>='#' && LA25_236<='%')||(LA25_236>='\'' && LA25_236<=';')||(LA25_236>='=' && LA25_236<='[')||(LA25_236>=']' && LA25_236<='\u007F')) ) {s = 62;}

                        else if ( (LA25_236=='&') ) {s = 63;}

                        else if ( (LA25_236=='<') ) {s = 65;}

                        else if ( ((LA25_236>='\u0080' && LA25_236<='\uFFFF')) && (( inString ))) {s = 66;}

                         
                        input.seek(index25_236);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA25_47 = input.LA(1);

                         
                        int index25_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_47=='h') ) {s = 82;}

                        else if ( ((LA25_47>='0' && LA25_47<='9')||(LA25_47>='A' && LA25_47<='Z')||(LA25_47>='a' && LA25_47<='g')||(LA25_47>='i' && LA25_47<='z')) ) {s = 38;}

                        else if ( (LA25_47=='%'||(LA25_47>='.' && LA25_47<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_47);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA25_105 = input.LA(1);

                         
                        int index25_105 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( inString )) ) {s = 66;}

                        else if ( (true) ) {s = 97;}

                         
                        input.seek(index25_105);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA25_122 = input.LA(1);

                         
                        int index25_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_122=='d') ) {s = 172;}

                        else if ( ((LA25_122>='0' && LA25_122<='9')||(LA25_122>='A' && LA25_122<='Z')||(LA25_122>='a' && LA25_122<='c')||(LA25_122>='e' && LA25_122<='z')) ) {s = 38;}

                        else if ( (LA25_122=='%'||(LA25_122>='.' && LA25_122<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_122);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA25_172 = input.LA(1);

                         
                        int index25_172 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_172==';') ) {s = 203;}

                        else if ( ((LA25_172>='0' && LA25_172<='9')||(LA25_172>='A' && LA25_172<='Z')||(LA25_172>='a' && LA25_172<='z')) ) {s = 38;}

                        else if ( (LA25_172=='%'||(LA25_172>='.' && LA25_172<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_172);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA25_156 = input.LA(1);

                        s = -1;
                        if ( (LA25_156=='<') ) {s = 156;}

                        else if ( (LA25_156=='\\') ) {s = 157;}

                        else if ( (LA25_156=='\n') ) {s = 158;}

                        else if ( (LA25_156=='\r') ) {s = 159;}

                        else if ( (LA25_156=='\t') ) {s = 160;}

                        else if ( ((LA25_156>=' ' && LA25_156<='!')||(LA25_156>='$' && LA25_156<='%')||(LA25_156>='\'' && LA25_156<='/')||LA25_156==';'||(LA25_156>='=' && LA25_156<='@')||LA25_156=='['||(LA25_156>=']' && LA25_156<='^')||LA25_156=='`'||(LA25_156>='{' && LA25_156<='\u007F')) ) {s = 161;}

                        else if ( (LA25_156=='&') ) {s = 162;}

                        else if ( (LA25_156=='#'||(LA25_156>='0' && LA25_156<=':')||(LA25_156>='A' && LA25_156<='Z')||LA25_156=='_'||(LA25_156>='a' && LA25_156<='z')) ) {s = 71;}

                        else if ( (LA25_156=='\"') ) {s = 163;}

                        else if ( ((LA25_156>='\u0000' && LA25_156<='\b')||(LA25_156>='\u000B' && LA25_156<='\f')||(LA25_156>='\u000E' && LA25_156<='\u001F')||(LA25_156>='\u0080' && LA25_156<='\uFFFF')) ) {s = 110;}

                        else s = 73;

                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA25_42 = input.LA(1);

                         
                        int index25_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_42>='0' && LA25_42<='9')||(LA25_42>='A' && LA25_42<='Z')||(LA25_42>='a' && LA25_42<='z')) ) {s = 38;}

                        else if ( (LA25_42=='%'||(LA25_42>='.' && LA25_42<='/')) && (( inPath ))) {s = 37;}

                        else if ( (LA25_42=='-') ) {s = 39;}

                        else s = 78;

                         
                        input.seek(index25_42);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA25_120 = input.LA(1);

                         
                        int index25_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_120=='a') ) {s = 170;}

                        else if ( ((LA25_120>='0' && LA25_120<='9')||(LA25_120>='A' && LA25_120<='Z')||(LA25_120>='b' && LA25_120<='z')) ) {s = 38;}

                        else if ( (LA25_120=='%'||(LA25_120>='.' && LA25_120<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_120);
                        if ( s>=0 ) return s;
                        break;
                    case 86 : 
                        int LA25_53 = input.LA(1);

                         
                        int index25_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_53=='e') ) {s = 88;}

                        else if ( ((LA25_53>='0' && LA25_53<='9')||(LA25_53>='A' && LA25_53<='Z')||(LA25_53>='a' && LA25_53<='d')||(LA25_53>='f' && LA25_53<='z')) ) {s = 38;}

                        else if ( (LA25_53=='%'||(LA25_53>='.' && LA25_53<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_53);
                        if ( s>=0 ) return s;
                        break;
                    case 87 : 
                        int LA25_88 = input.LA(1);

                         
                        int index25_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_88=='l') ) {s = 122;}

                        else if ( ((LA25_88>='0' && LA25_88<='9')||(LA25_88>='A' && LA25_88<='Z')||(LA25_88>='a' && LA25_88<='k')||(LA25_88>='m' && LA25_88<='z')) ) {s = 38;}

                        else if ( (LA25_88=='%'||(LA25_88>='.' && LA25_88<='/')) && (( inPath ))) {s = 37;}

                        else s = 39;

                         
                        input.seek(index25_88);
                        if ( s>=0 ) return s;
                        break;
                    case 88 : 
                        int LA25_195 = input.LA(1);

                        s = -1;
                        if ( (LA25_195=='\\') ) {s = 195;}

                        else if ( (LA25_195=='\"') ) {s = 196;}

                        else if ( ((LA25_195>=' ' && LA25_195<='!')||(LA25_195>='$' && LA25_195<='%')||(LA25_195>='\'' && LA25_195<='/')||LA25_195==';'||(LA25_195>='=' && LA25_195<='@')||LA25_195=='['||(LA25_195>=']' && LA25_195<='^')||LA25_195=='`'||(LA25_195>='{' && LA25_195<='\u007F')) ) {s = 161;}

                        else if ( (LA25_195=='\n') ) {s = 158;}

                        else if ( (LA25_195=='\r') ) {s = 159;}

                        else if ( (LA25_195=='\t') ) {s = 160;}

                        else if ( (LA25_195=='&') ) {s = 162;}

                        else if ( (LA25_195=='<') ) {s = 156;}

                        else if ( (LA25_195=='#'||(LA25_195>='0' && LA25_195<=':')||(LA25_195>='A' && LA25_195<='Z')||LA25_195=='_'||(LA25_195>='a' && LA25_195<='z')) ) {s = 71;}

                        else if ( ((LA25_195>='\u0000' && LA25_195<='\b')||(LA25_195>='\u000B' && LA25_195<='\f')||(LA25_195>='\u000E' && LA25_195<='\u001F')||(LA25_195>='\u0080' && LA25_195<='\uFFFF')) ) {s = 110;}

                        if ( s>=0 ) return s;
                        break;
                    case 89 : 
                        int LA25_184 = input.LA(1);

                        s = -1;
                        if ( (LA25_184=='\\') ) {s = 184;}

                        else if ( (LA25_184=='\"') ) {s = 185;}

                        else if ( ((LA25_184>=' ' && LA25_184<='!')||(LA25_184>='$' && LA25_184<='%')||(LA25_184>='\'' && LA25_184<='/')||LA25_184==';'||(LA25_184>='=' && LA25_184<='@')||LA25_184=='['||(LA25_184>=']' && LA25_184<='^')||LA25_184=='`'||(LA25_184>='{' && LA25_184<='\u007F')) ) {s = 143;}

                        else if ( (LA25_184=='\n') ) {s = 140;}

                        else if ( (LA25_184=='\r') ) {s = 141;}

                        else if ( (LA25_184=='\t') ) {s = 142;}

                        else if ( (LA25_184=='&') ) {s = 144;}

                        else if ( (LA25_184=='#'||(LA25_184>='0' && LA25_184<=':')||(LA25_184>='A' && LA25_184<='Z')||LA25_184=='_'||(LA25_184>='a' && LA25_184<='z')) ) {s = 94;}

                        else if ( (LA25_184=='<') ) {s = 145;}

                        else if ( ((LA25_184>='\u0000' && LA25_184<='\b')||(LA25_184>='\u000B' && LA25_184<='\f')||(LA25_184>='\u000E' && LA25_184<='\u001F')||(LA25_184>='\u0080' && LA25_184<='\uFFFF')) ) {s = 104;}

                        if ( s>=0 ) return s;
                        break;
                    case 90 : 
                        int LA25_145 = input.LA(1);

                        s = -1;
                        if ( (LA25_145=='\"') ) {s = 138;}

                        else if ( (LA25_145=='\\') ) {s = 139;}

                        else if ( (LA25_145=='\n') ) {s = 140;}

                        else if ( (LA25_145=='\r') ) {s = 141;}

                        else if ( (LA25_145=='\t') ) {s = 142;}

                        else if ( ((LA25_145>=' ' && LA25_145<='!')||(LA25_145>='$' && LA25_145<='%')||(LA25_145>='\'' && LA25_145<='/')||LA25_145==';'||(LA25_145>='=' && LA25_145<='@')||LA25_145=='['||(LA25_145>=']' && LA25_145<='^')||LA25_145=='`'||(LA25_145>='{' && LA25_145<='\u007F')) ) {s = 143;}

                        else if ( (LA25_145=='&') ) {s = 144;}

                        else if ( (LA25_145=='#'||(LA25_145>='0' && LA25_145<=':')||(LA25_145>='A' && LA25_145<='Z')||LA25_145=='_'||(LA25_145>='a' && LA25_145<='z')) ) {s = 94;}

                        else if ( (LA25_145=='<') ) {s = 145;}

                        else if ( ((LA25_145>='\u0000' && LA25_145<='\b')||(LA25_145>='\u000B' && LA25_145<='\f')||(LA25_145>='\u000E' && LA25_145<='\u001F')||(LA25_145>='\u0080' && LA25_145<='\uFFFF')) ) {s = 104;}

                        else s = 96;

                        if ( s>=0 ) return s;
                        break;
                    case 91 : 
                        int LA25_30 = input.LA(1);

                         
                        int index25_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_30=='\\') ) {s = 58;}

                        else if ( (LA25_30=='\n') ) {s = 59;}

                        else if ( (LA25_30=='\r') ) {s = 60;}

                        else if ( (LA25_30=='\t') ) {s = 61;}

                        else if ( ((LA25_30>=' ' && LA25_30<='!')||(LA25_30>='#' && LA25_30<='%')||(LA25_30>='\'' && LA25_30<=';')||(LA25_30>='=' && LA25_30<='[')||(LA25_30>=']' && LA25_30<='\u007F')) ) {s = 62;}

                        else if ( (LA25_30=='&') ) {s = 63;}

                        else if ( (LA25_30=='\"') ) {s = 64;}

                        else if ( (LA25_30=='<') ) {s = 65;}

                        else if ( ((LA25_30>='\u0080' && LA25_30<='\uFFFF')) && (( inString ))) {s = 66;}

                         
                        input.seek(index25_30);
                        if ( s>=0 ) return s;
                        break;
                    case 92 : 
                        int LA25_143 = input.LA(1);

                        s = -1;
                        if ( (LA25_143=='\"') ) {s = 138;}

                        else if ( (LA25_143=='\\') ) {s = 139;}

                        else if ( (LA25_143=='\n') ) {s = 140;}

                        else if ( (LA25_143=='\r') ) {s = 141;}

                        else if ( (LA25_143=='\t') ) {s = 142;}

                        else if ( ((LA25_143>=' ' && LA25_143<='!')||(LA25_143>='$' && LA25_143<='%')||(LA25_143>='\'' && LA25_143<='/')||LA25_143==';'||(LA25_143>='=' && LA25_143<='@')||LA25_143=='['||(LA25_143>=']' && LA25_143<='^')||LA25_143=='`'||(LA25_143>='{' && LA25_143<='\u007F')) ) {s = 143;}

                        else if ( (LA25_143=='&') ) {s = 144;}

                        else if ( (LA25_143=='#'||(LA25_143>='0' && LA25_143<=':')||(LA25_143>='A' && LA25_143<='Z')||LA25_143=='_'||(LA25_143>='a' && LA25_143<='z')) ) {s = 94;}

                        else if ( (LA25_143=='<') ) {s = 145;}

                        else if ( ((LA25_143>='\u0000' && LA25_143<='\b')||(LA25_143>='\u000B' && LA25_143<='\f')||(LA25_143>='\u000E' && LA25_143<='\u001F')||(LA25_143>='\u0080' && LA25_143<='\uFFFF')) ) {s = 104;}

                        if ( s>=0 ) return s;
                        break;
                    case 93 : 
                        int LA25_161 = input.LA(1);

                        s = -1;
                        if ( (LA25_161=='\"') ) {s = 163;}

                        else if ( (LA25_161=='\\') ) {s = 157;}

                        else if ( (LA25_161=='\n') ) {s = 158;}

                        else if ( (LA25_161=='\r') ) {s = 159;}

                        else if ( (LA25_161=='\t') ) {s = 160;}

                        else if ( ((LA25_161>=' ' && LA25_161<='!')||(LA25_161>='$' && LA25_161<='%')||(LA25_161>='\'' && LA25_161<='/')||LA25_161==';'||(LA25_161>='=' && LA25_161<='@')||LA25_161=='['||(LA25_161>=']' && LA25_161<='^')||LA25_161=='`'||(LA25_161>='{' && LA25_161<='\u007F')) ) {s = 161;}

                        else if ( (LA25_161=='&') ) {s = 162;}

                        else if ( (LA25_161=='<') ) {s = 156;}

                        else if ( (LA25_161=='#'||(LA25_161>='0' && LA25_161<=':')||(LA25_161>='A' && LA25_161<='Z')||LA25_161=='_'||(LA25_161>='a' && LA25_161<='z')) ) {s = 71;}

                        else if ( ((LA25_161>='\u0000' && LA25_161<='\b')||(LA25_161>='\u000B' && LA25_161<='\f')||(LA25_161>='\u000E' && LA25_161<='\u001F')||(LA25_161>='\u0080' && LA25_161<='\uFFFF')) ) {s = 110;}

                        if ( s>=0 ) return s;
                        break;
                    case 94 : 
                        int LA25_27 = input.LA(1);

                         
                        int index25_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_27=='t') ) {s = 55;}

                        else if ( (LA25_27=='i') ) {s = 56;}

                        else if ( (LA25_27=='%'||(LA25_27>='.' && LA25_27<='/')) && (( inPath ))) {s = 37;}

                        else if ( ((LA25_27>='0' && LA25_27<='9')||(LA25_27>='A' && LA25_27<='Z')||(LA25_27>='a' && LA25_27<='h')||(LA25_27>='j' && LA25_27<='s')||(LA25_27>='u' && LA25_27<='z')) ) {s = 38;}

                        else if ( (LA25_27=='-') ) {s = 39;}

                         
                        input.seek(index25_27);
                        if ( s>=0 ) return s;
                        break;
                    case 95 : 
                        int LA25_1 = input.LA(1);

                         
                        int index25_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_1=='o') ) {s = 36;}

                        else if ( (LA25_1=='%'||(LA25_1>='.' && LA25_1<='/')) && (( inPath ))) {s = 37;}

                        else if ( ((LA25_1>='0' && LA25_1<='9')||(LA25_1>='A' && LA25_1<='Z')||(LA25_1>='a' && LA25_1<='n')||(LA25_1>='p' && LA25_1<='z')) ) {s = 38;}

                        else if ( (LA25_1=='-') ) {s = 39;}

                         
                        input.seek(index25_1);
                        if ( s>=0 ) return s;
                        break;
                    case 96 : 
                        int LA25_144 = input.LA(1);

                        s = -1;
                        if ( (LA25_144=='#') ) {s = 186;}

                        else if ( (LA25_144==':'||(LA25_144>='A' && LA25_144<='Z')||LA25_144=='_'||(LA25_144>='a' && LA25_144<='z')) ) {s = 187;}

                        else if ( (LA25_144=='\"') ) {s = 138;}

                        else if ( (LA25_144=='\\') ) {s = 139;}

                        else if ( (LA25_144=='\n') ) {s = 140;}

                        else if ( (LA25_144=='\r') ) {s = 141;}

                        else if ( (LA25_144=='\t') ) {s = 142;}

                        else if ( ((LA25_144>=' ' && LA25_144<='!')||(LA25_144>='$' && LA25_144<='%')||(LA25_144>='\'' && LA25_144<='/')||LA25_144==';'||(LA25_144>='=' && LA25_144<='@')||LA25_144=='['||(LA25_144>=']' && LA25_144<='^')||LA25_144=='`'||(LA25_144>='{' && LA25_144<='\u007F')) ) {s = 143;}

                        else if ( (LA25_144=='&') ) {s = 144;}

                        else if ( ((LA25_144>='0' && LA25_144<='9')) ) {s = 94;}

                        else if ( (LA25_144=='<') ) {s = 145;}

                        else if ( ((LA25_144>='\u0000' && LA25_144<='\b')||(LA25_144>='\u000B' && LA25_144<='\f')||(LA25_144>='\u000E' && LA25_144<='\u001F')||(LA25_144>='\u0080' && LA25_144<='\uFFFF')) ) {s = 104;}

                        if ( s>=0 ) return s;
                        break;
                    case 97 : 
                        int LA25_162 = input.LA(1);

                        s = -1;
                        if ( (LA25_162=='#') ) {s = 197;}

                        else if ( (LA25_162==':'||(LA25_162>='A' && LA25_162<='Z')||LA25_162=='_'||(LA25_162>='a' && LA25_162<='z')) ) {s = 198;}

                        else if ( (LA25_162=='<') ) {s = 156;}

                        else if ( (LA25_162=='\\') ) {s = 157;}

                        else if ( (LA25_162=='\n') ) {s = 158;}

                        else if ( (LA25_162=='\r') ) {s = 159;}

                        else if ( (LA25_162=='\t') ) {s = 160;}

                        else if ( ((LA25_162>=' ' && LA25_162<='!')||(LA25_162>='$' && LA25_162<='%')||(LA25_162>='\'' && LA25_162<='/')||LA25_162==';'||(LA25_162>='=' && LA25_162<='@')||LA25_162=='['||(LA25_162>=']' && LA25_162<='^')||LA25_162=='`'||(LA25_162>='{' && LA25_162<='\u007F')) ) {s = 161;}

                        else if ( (LA25_162=='&') ) {s = 162;}

                        else if ( ((LA25_162>='0' && LA25_162<='9')) ) {s = 71;}

                        else if ( (LA25_162=='\"') ) {s = 163;}

                        else if ( ((LA25_162>='\u0000' && LA25_162<='\b')||(LA25_162>='\u000B' && LA25_162<='\f')||(LA25_162>='\u000E' && LA25_162<='\u001F')||(LA25_162>='\u0080' && LA25_162<='\uFFFF')) ) {s = 110;}

                        if ( s>=0 ) return s;
                        break;
                    case 98 : 
                        int LA25_220 = input.LA(1);

                        s = -1;
                        if ( (LA25_220=='\\') ) {s = 237;}

                        else if ( (LA25_220=='\"') ) {s = 238;}

                        else if ( ((LA25_220>=' ' && LA25_220<='!')||(LA25_220>='$' && LA25_220<='%')||(LA25_220>='\'' && LA25_220<='/')||LA25_220==';'||(LA25_220>='=' && LA25_220<='@')||LA25_220=='['||(LA25_220>=']' && LA25_220<='^')||LA25_220=='`'||(LA25_220>='{' && LA25_220<='\u007F')) ) {s = 148;}

                        else if ( (LA25_220=='&') ) {s = 149;}

                        else if ( (LA25_220=='\n') ) {s = 140;}

                        else if ( (LA25_220=='\r') ) {s = 141;}

                        else if ( (LA25_220=='\t') ) {s = 142;}

                        else if ( (LA25_220=='<') ) {s = 150;}

                        else if ( (LA25_220=='#'||(LA25_220>='0' && LA25_220<=':')||(LA25_220>='A' && LA25_220<='Z')||LA25_220=='_'||(LA25_220>='a' && LA25_220<='z')) ) {s = 62;}

                        else if ( ((LA25_220>='\u0000' && LA25_220<='\b')||(LA25_220>='\u000B' && LA25_220<='\f')||(LA25_220>='\u000E' && LA25_220<='\u001F')) ) {s = 104;}

                        else if ( ((LA25_220>='\u0080' && LA25_220<='\uFFFF')) ) {s = 102;}

                        if ( s>=0 ) return s;
                        break;
                    case 99 : 
                        int LA25_104 = input.LA(1);

                        s = -1;
                        if ( (LA25_104=='\"') ) {s = 138;}

                        else if ( (LA25_104=='\\') ) {s = 139;}

                        else if ( (LA25_104=='\n') ) {s = 140;}

                        else if ( (LA25_104=='\r') ) {s = 141;}

                        else if ( (LA25_104=='\t') ) {s = 142;}

                        else if ( ((LA25_104>=' ' && LA25_104<='!')||(LA25_104>='$' && LA25_104<='%')||(LA25_104>='\'' && LA25_104<='/')||LA25_104==';'||(LA25_104>='=' && LA25_104<='@')||LA25_104=='['||(LA25_104>=']' && LA25_104<='^')||LA25_104=='`'||(LA25_104>='{' && LA25_104<='\u007F')) ) {s = 143;}

                        else if ( (LA25_104=='&') ) {s = 144;}

                        else if ( (LA25_104=='#'||(LA25_104>='0' && LA25_104<=':')||(LA25_104>='A' && LA25_104<='Z')||LA25_104=='_'||(LA25_104>='a' && LA25_104<='z')) ) {s = 94;}

                        else if ( (LA25_104=='<') ) {s = 145;}

                        else if ( ((LA25_104>='\u0000' && LA25_104<='\b')||(LA25_104>='\u000B' && LA25_104<='\f')||(LA25_104>='\u000E' && LA25_104<='\u001F')||(LA25_104>='\u0080' && LA25_104<='\uFFFF')) ) {s = 104;}

                        if ( s>=0 ) return s;
                        break;
                    case 100 : 
                        int LA25_110 = input.LA(1);

                        s = -1;
                        if ( (LA25_110=='<') ) {s = 156;}

                        else if ( (LA25_110=='\\') ) {s = 157;}

                        else if ( (LA25_110=='\n') ) {s = 158;}

                        else if ( (LA25_110=='\r') ) {s = 159;}

                        else if ( (LA25_110=='\t') ) {s = 160;}

                        else if ( ((LA25_110>=' ' && LA25_110<='!')||(LA25_110>='$' && LA25_110<='%')||(LA25_110>='\'' && LA25_110<='/')||LA25_110==';'||(LA25_110>='=' && LA25_110<='@')||LA25_110=='['||(LA25_110>=']' && LA25_110<='^')||LA25_110=='`'||(LA25_110>='{' && LA25_110<='\u007F')) ) {s = 161;}

                        else if ( (LA25_110=='&') ) {s = 162;}

                        else if ( (LA25_110=='#'||(LA25_110>='0' && LA25_110<=':')||(LA25_110>='A' && LA25_110<='Z')||LA25_110=='_'||(LA25_110>='a' && LA25_110<='z')) ) {s = 71;}

                        else if ( (LA25_110=='\"') ) {s = 163;}

                        else if ( ((LA25_110>='\u0000' && LA25_110<='\b')||(LA25_110>='\u000B' && LA25_110<='\f')||(LA25_110>='\u000E' && LA25_110<='\u001F')||(LA25_110>='\u0080' && LA25_110<='\uFFFF')) ) {s = 110;}

                        if ( s>=0 ) return s;
                        break;
                    case 101 : 
                        int LA25_63 = input.LA(1);

                         
                        int index25_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_63=='#') ) {s = 99;}

                        else if ( (LA25_63==':'||(LA25_63>='A' && LA25_63<='Z')||LA25_63=='_'||(LA25_63>='a' && LA25_63<='z')) ) {s = 100;}

                        else if ( (LA25_63=='\"') ) {s = 101;}

                        else if ( ((LA25_63>=' ' && LA25_63<='!')||(LA25_63>='$' && LA25_63<='/')||(LA25_63>=';' && LA25_63<='@')||LA25_63=='['||(LA25_63>=']' && LA25_63<='^')||LA25_63=='`'||(LA25_63>='{' && LA25_63<='\uFFFF')) ) {s = 102;}

                        else if ( (LA25_63=='\\') ) {s = 103;}

                        else if ( ((LA25_63>='0' && LA25_63<='9')) && (( inString ))) {s = 66;}

                        else if ( ((LA25_63>='\u0000' && LA25_63<='\u001F')) ) {s = 104;}

                         
                        input.seek(index25_63);
                        if ( s>=0 ) return s;
                        break;
                    case 102 : 
                        int LA25_99 = input.LA(1);

                         
                        int index25_99 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_99=='x') ) {s = 134;}

                        else if ( ((LA25_99>='0' && LA25_99<='9')) ) {s = 135;}

                        else if ( ((LA25_99>=' ' && LA25_99<='/')||(LA25_99>=':' && LA25_99<='w')||(LA25_99>='y' && LA25_99<='\uFFFF')) && (( inString ))) {s = 66;}

                         
                        input.seek(index25_99);
                        if ( s>=0 ) return s;
                        break;
                    case 103 : 
                        int LA25_65 = input.LA(1);

                         
                        int index25_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_65>=' ' && LA25_65<='\uFFFF')) && (( inString ))) {s = 66;}

                        else s = 96;

                         
                        input.seek(index25_65);
                        if ( s>=0 ) return s;
                        break;
                    case 104 : 
                        int LA25_205 = input.LA(1);

                         
                        int index25_205 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_205>='0' && LA25_205<='9')||(LA25_205>='A' && LA25_205<='Z')||(LA25_205>='a' && LA25_205<='z')) ) {s = 38;}

                        else if ( (LA25_205=='%'||(LA25_205>='.' && LA25_205<='/')) && (( inPath ))) {s = 37;}

                        else if ( (LA25_205=='-') ) {s = 39;}

                        else s = 230;

                         
                        input.seek(index25_205);
                        if ( s>=0 ) return s;
                        break;
                    case 105 : 
                        int LA25_17 = input.LA(1);

                         
                        int index25_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_17=='e') ) {s = 44;}

                        else if ( (LA25_17=='%'||(LA25_17>='.' && LA25_17<='/')) && (( inPath ))) {s = 37;}

                        else if ( ((LA25_17>='0' && LA25_17<='9')||(LA25_17>='A' && LA25_17<='Z')||(LA25_17>='a' && LA25_17<='d')||(LA25_17>='f' && LA25_17<='z')) ) {s = 38;}

                        else if ( (LA25_17=='-') ) {s = 39;}

                         
                        input.seek(index25_17);
                        if ( s>=0 ) return s;
                        break;
                    case 106 : 
                        int LA25_204 = input.LA(1);

                         
                        int index25_204 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_204>='0' && LA25_204<='9')||(LA25_204>='A' && LA25_204<='Z')||(LA25_204>='a' && LA25_204<='z')) ) {s = 38;}

                        else if ( (LA25_204=='%'||(LA25_204>='.' && LA25_204<='/')) && (( inPath ))) {s = 37;}

                        else if ( (LA25_204=='-') ) {s = 39;}

                        else s = 229;

                         
                        input.seek(index25_204);
                        if ( s>=0 ) return s;
                        break;
                    case 107 : 
                        int LA25_140 = input.LA(1);

                        s = -1;
                        if ( (LA25_140=='\"') ) {s = 138;}

                        else if ( (LA25_140=='\\') ) {s = 139;}

                        else if ( (LA25_140=='\n') ) {s = 140;}

                        else if ( (LA25_140=='\r') ) {s = 141;}

                        else if ( (LA25_140=='\t') ) {s = 142;}

                        else if ( ((LA25_140>=' ' && LA25_140<='!')||(LA25_140>='$' && LA25_140<='%')||(LA25_140>='\'' && LA25_140<='/')||LA25_140==';'||(LA25_140>='=' && LA25_140<='@')||LA25_140=='['||(LA25_140>=']' && LA25_140<='^')||LA25_140=='`'||(LA25_140>='{' && LA25_140<='\u007F')) ) {s = 143;}

                        else if ( (LA25_140=='&') ) {s = 144;}

                        else if ( (LA25_140=='#'||(LA25_140>='0' && LA25_140<=':')||(LA25_140>='A' && LA25_140<='Z')||LA25_140=='_'||(LA25_140>='a' && LA25_140<='z')) ) {s = 94;}

                        else if ( (LA25_140=='<') ) {s = 145;}

                        else if ( ((LA25_140>='\u0000' && LA25_140<='\b')||(LA25_140>='\u000B' && LA25_140<='\f')||(LA25_140>='\u000E' && LA25_140<='\u001F')||(LA25_140>='\u0080' && LA25_140<='\uFFFF')) ) {s = 104;}

                        if ( s>=0 ) return s;
                        break;
                    case 108 : 
                        int LA25_158 = input.LA(1);

                        s = -1;
                        if ( (LA25_158=='<') ) {s = 156;}

                        else if ( (LA25_158=='\\') ) {s = 157;}

                        else if ( (LA25_158=='\n') ) {s = 158;}

                        else if ( (LA25_158=='\r') ) {s = 159;}

                        else if ( (LA25_158=='\t') ) {s = 160;}

                        else if ( ((LA25_158>=' ' && LA25_158<='!')||(LA25_158>='$' && LA25_158<='%')||(LA25_158>='\'' && LA25_158<='/')||LA25_158==';'||(LA25_158>='=' && LA25_158<='@')||LA25_158=='['||(LA25_158>=']' && LA25_158<='^')||LA25_158=='`'||(LA25_158>='{' && LA25_158<='\u007F')) ) {s = 161;}

                        else if ( (LA25_158=='&') ) {s = 162;}

                        else if ( (LA25_158=='#'||(LA25_158>='0' && LA25_158<=':')||(LA25_158>='A' && LA25_158<='Z')||LA25_158=='_'||(LA25_158>='a' && LA25_158<='z')) ) {s = 71;}

                        else if ( (LA25_158=='\"') ) {s = 163;}

                        else if ( ((LA25_158>='\u0000' && LA25_158<='\b')||(LA25_158>='\u000B' && LA25_158<='\f')||(LA25_158>='\u000E' && LA25_158<='\u001F')||(LA25_158>='\u0080' && LA25_158<='\uFFFF')) ) {s = 110;}

                        if ( s>=0 ) return s;
                        break;
                    case 109 : 
                        int LA25_141 = input.LA(1);

                        s = -1;
                        if ( (LA25_141=='\"') ) {s = 138;}

                        else if ( (LA25_141=='\\') ) {s = 139;}

                        else if ( (LA25_141=='\n') ) {s = 140;}

                        else if ( (LA25_141=='\r') ) {s = 141;}

                        else if ( (LA25_141=='\t') ) {s = 142;}

                        else if ( ((LA25_141>=' ' && LA25_141<='!')||(LA25_141>='$' && LA25_141<='%')||(LA25_141>='\'' && LA25_141<='/')||LA25_141==';'||(LA25_141>='=' && LA25_141<='@')||LA25_141=='['||(LA25_141>=']' && LA25_141<='^')||LA25_141=='`'||(LA25_141>='{' && LA25_141<='\u007F')) ) {s = 143;}

                        else if ( (LA25_141=='&') ) {s = 144;}

                        else if ( (LA25_141=='#'||(LA25_141>='0' && LA25_141<=':')||(LA25_141>='A' && LA25_141<='Z')||LA25_141=='_'||(LA25_141>='a' && LA25_141<='z')) ) {s = 94;}

                        else if ( (LA25_141=='<') ) {s = 145;}

                        else if ( ((LA25_141>='\u0000' && LA25_141<='\b')||(LA25_141>='\u000B' && LA25_141<='\f')||(LA25_141>='\u000E' && LA25_141<='\u001F')||(LA25_141>='\u0080' && LA25_141<='\uFFFF')) ) {s = 104;}

                        if ( s>=0 ) return s;
                        break;
                    case 110 : 
                        int LA25_159 = input.LA(1);

                        s = -1;
                        if ( (LA25_159=='<') ) {s = 156;}

                        else if ( (LA25_159=='\\') ) {s = 157;}

                        else if ( (LA25_159=='\n') ) {s = 158;}

                        else if ( (LA25_159=='\r') ) {s = 159;}

                        else if ( (LA25_159=='\t') ) {s = 160;}

                        else if ( ((LA25_159>=' ' && LA25_159<='!')||(LA25_159>='$' && LA25_159<='%')||(LA25_159>='\'' && LA25_159<='/')||LA25_159==';'||(LA25_159>='=' && LA25_159<='@')||LA25_159=='['||(LA25_159>=']' && LA25_159<='^')||LA25_159=='`'||(LA25_159>='{' && LA25_159<='\u007F')) ) {s = 161;}

                        else if ( (LA25_159=='&') ) {s = 162;}

                        else if ( (LA25_159=='#'||(LA25_159>='0' && LA25_159<=':')||(LA25_159>='A' && LA25_159<='Z')||LA25_159=='_'||(LA25_159>='a' && LA25_159<='z')) ) {s = 71;}

                        else if ( (LA25_159=='\"') ) {s = 163;}

                        else if ( ((LA25_159>='\u0000' && LA25_159<='\b')||(LA25_159>='\u000B' && LA25_159<='\f')||(LA25_159>='\u000E' && LA25_159<='\u001F')||(LA25_159>='\u0080' && LA25_159<='\uFFFF')) ) {s = 110;}

                        if ( s>=0 ) return s;
                        break;
                    case 111 : 
                        int LA25_142 = input.LA(1);

                        s = -1;
                        if ( (LA25_142=='\"') ) {s = 138;}

                        else if ( (LA25_142=='\\') ) {s = 139;}

                        else if ( (LA25_142=='\n') ) {s = 140;}

                        else if ( (LA25_142=='\r') ) {s = 141;}

                        else if ( (LA25_142=='\t') ) {s = 142;}

                        else if ( ((LA25_142>=' ' && LA25_142<='!')||(LA25_142>='$' && LA25_142<='%')||(LA25_142>='\'' && LA25_142<='/')||LA25_142==';'||(LA25_142>='=' && LA25_142<='@')||LA25_142=='['||(LA25_142>=']' && LA25_142<='^')||LA25_142=='`'||(LA25_142>='{' && LA25_142<='\u007F')) ) {s = 143;}

                        else if ( (LA25_142=='&') ) {s = 144;}

                        else if ( (LA25_142=='#'||(LA25_142>='0' && LA25_142<=':')||(LA25_142>='A' && LA25_142<='Z')||LA25_142=='_'||(LA25_142>='a' && LA25_142<='z')) ) {s = 94;}

                        else if ( (LA25_142=='<') ) {s = 145;}

                        else if ( ((LA25_142>='\u0000' && LA25_142<='\b')||(LA25_142>='\u000B' && LA25_142<='\f')||(LA25_142>='\u000E' && LA25_142<='\u001F')||(LA25_142>='\u0080' && LA25_142<='\uFFFF')) ) {s = 104;}

                        if ( s>=0 ) return s;
                        break;
                    case 112 : 
                        int LA25_160 = input.LA(1);

                        s = -1;
                        if ( (LA25_160=='<') ) {s = 156;}

                        else if ( (LA25_160=='\\') ) {s = 157;}

                        else if ( (LA25_160=='\n') ) {s = 158;}

                        else if ( (LA25_160=='\r') ) {s = 159;}

                        else if ( (LA25_160=='\t') ) {s = 160;}

                        else if ( ((LA25_160>=' ' && LA25_160<='!')||(LA25_160>='$' && LA25_160<='%')||(LA25_160>='\'' && LA25_160<='/')||LA25_160==';'||(LA25_160>='=' && LA25_160<='@')||LA25_160=='['||(LA25_160>=']' && LA25_160<='^')||LA25_160=='`'||(LA25_160>='{' && LA25_160<='\u007F')) ) {s = 161;}

                        else if ( (LA25_160=='&') ) {s = 162;}

                        else if ( (LA25_160=='#'||(LA25_160>='0' && LA25_160<=':')||(LA25_160>='A' && LA25_160<='Z')||LA25_160=='_'||(LA25_160>='a' && LA25_160<='z')) ) {s = 71;}

                        else if ( (LA25_160=='\"') ) {s = 163;}

                        else if ( ((LA25_160>='\u0000' && LA25_160<='\b')||(LA25_160>='\u000B' && LA25_160<='\f')||(LA25_160>='\u000E' && LA25_160<='\u001F')||(LA25_160>='\u0080' && LA25_160<='\uFFFF')) ) {s = 110;}

                        if ( s>=0 ) return s;
                        break;
                    case 113 : 
                        int LA25_249 = input.LA(1);

                         
                        int index25_249 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_249=='\"') ) {s = 64;}

                        else if ( ((LA25_249>=' ' && LA25_249<='!')||(LA25_249>='#' && LA25_249<='%')||(LA25_249>='\'' && LA25_249<=';')||(LA25_249>='=' && LA25_249<='[')||(LA25_249>=']' && LA25_249<='\u007F')) ) {s = 62;}

                        else if ( (LA25_249=='\\') ) {s = 58;}

                        else if ( (LA25_249=='&') ) {s = 63;}

                        else if ( (LA25_249=='\n') ) {s = 59;}

                        else if ( (LA25_249=='\r') ) {s = 60;}

                        else if ( (LA25_249=='\t') ) {s = 61;}

                        else if ( (LA25_249=='<') ) {s = 65;}

                        else if ( ((LA25_249>='\u0080' && LA25_249<='\uFFFF')) && (( inString ))) {s = 66;}

                         
                        input.seek(index25_249);
                        if ( s>=0 ) return s;
                        break;
                    case 114 : 
                        int LA25_119 = input.LA(1);

                         
                        int index25_119 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_119>='0' && LA25_119<='9')||(LA25_119>='A' && LA25_119<='Z')||(LA25_119>='a' && LA25_119<='z')) ) {s = 38;}

                        else if ( (LA25_119=='%'||(LA25_119>='.' && LA25_119<='/')) && (( inPath ))) {s = 37;}

                        else if ( (LA25_119=='-') ) {s = 39;}

                        else s = 169;

                         
                        input.seek(index25_119);
                        if ( s>=0 ) return s;
                        break;
                    case 115 : 
                        int LA25_103 = input.LA(1);

                        s = -1;
                        if ( (LA25_103=='\\') ) {s = 151;}

                        else if ( (LA25_103=='\"') ) {s = 138;}

                        else if ( ((LA25_103>=' ' && LA25_103<='!')||(LA25_103>='$' && LA25_103<='%')||(LA25_103>='\'' && LA25_103<='/')||LA25_103==';'||(LA25_103>='=' && LA25_103<='@')||LA25_103=='['||(LA25_103>=']' && LA25_103<='^')||LA25_103=='`'||(LA25_103>='{' && LA25_103<='\u007F')) ) {s = 143;}

                        else if ( (LA25_103=='\n') ) {s = 140;}

                        else if ( (LA25_103=='\r') ) {s = 141;}

                        else if ( (LA25_103=='\t') ) {s = 142;}

                        else if ( (LA25_103=='&') ) {s = 144;}

                        else if ( (LA25_103=='#'||(LA25_103>='0' && LA25_103<=':')||(LA25_103>='A' && LA25_103<='Z')||LA25_103=='_'||(LA25_103>='a' && LA25_103<='z')) ) {s = 94;}

                        else if ( (LA25_103=='<') ) {s = 145;}

                        else if ( ((LA25_103>='\u0000' && LA25_103<='\b')||(LA25_103>='\u000B' && LA25_103<='\f')||(LA25_103>='\u000E' && LA25_103<='\u001F')||(LA25_103>='\u0080' && LA25_103<='\uFFFF')) ) {s = 104;}

                        if ( s>=0 ) return s;
                        break;
                    case 116 : 
                        int LA25_19 = input.LA(1);

                         
                        int index25_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_19=='e') ) {s = 49;}

                        else if ( (LA25_19=='i') ) {s = 50;}

                        else if ( (LA25_19=='%'||(LA25_19>='.' && LA25_19<='/')) && (( inPath ))) {s = 37;}

                        else if ( ((LA25_19>='0' && LA25_19<='9')||(LA25_19>='A' && LA25_19<='Z')||(LA25_19>='a' && LA25_19<='d')||(LA25_19>='f' && LA25_19<='h')||(LA25_19>='j' && LA25_19<='z')) ) {s = 38;}

                        else if ( (LA25_19=='-') ) {s = 39;}

                         
                        input.seek(index25_19);
                        if ( s>=0 ) return s;
                        break;
                    case 117 : 
                        int LA25_137 = input.LA(1);

                         
                        int index25_137 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_137=='<') ) {s = 65;}

                        else if ( (LA25_137=='\\') ) {s = 58;}

                        else if ( (LA25_137=='\n') ) {s = 59;}

                        else if ( (LA25_137=='\r') ) {s = 60;}

                        else if ( (LA25_137=='\t') ) {s = 61;}

                        else if ( ((LA25_137>=' ' && LA25_137<='!')||(LA25_137>='#' && LA25_137<='%')||(LA25_137>='\'' && LA25_137<=';')||(LA25_137>='=' && LA25_137<='[')||(LA25_137>=']' && LA25_137<='\u007F')) ) {s = 62;}

                        else if ( (LA25_137=='&') ) {s = 63;}

                        else if ( (LA25_137=='\"') ) {s = 64;}

                        else if ( ((LA25_137>='\u0080' && LA25_137<='\uFFFF')) && (( inString ))) {s = 66;}

                         
                        input.seek(index25_137);
                        if ( s>=0 ) return s;
                        break;
                    case 118 : 
                        int LA25_33 = input.LA(1);

                         
                        int index25_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_33=='%'||(LA25_33>='.' && LA25_33<='/')) && (( inPath ))) {s = 37;}

                        else if ( ((LA25_33>='0' && LA25_33<='9')||(LA25_33>='A' && LA25_33<='Z')||(LA25_33>='a' && LA25_33<='z')) ) {s = 38;}

                        else if ( (LA25_33=='-') ) {s = 39;}

                         
                        input.seek(index25_33);
                        if ( s>=0 ) return s;
                        break;
                    case 119 : 
                        int LA25_127 = input.LA(1);

                         
                        int index25_127 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_127=='\"') ) {s = 64;}

                        else if ( (LA25_127=='\\') ) {s = 58;}

                        else if ( (LA25_127=='\n') ) {s = 59;}

                        else if ( (LA25_127=='\r') ) {s = 60;}

                        else if ( (LA25_127=='\t') ) {s = 61;}

                        else if ( ((LA25_127>=' ' && LA25_127<='!')||(LA25_127>='#' && LA25_127<='%')||(LA25_127>='\'' && LA25_127<=';')||(LA25_127>='=' && LA25_127<='[')||(LA25_127>=']' && LA25_127<='\u007F')) ) {s = 62;}

                        else if ( (LA25_127=='&') ) {s = 63;}

                        else if ( (LA25_127=='<') ) {s = 65;}

                        else if ( ((LA25_127>='\u0080' && LA25_127<='\uFFFF')) && (( inString ))) {s = 66;}

                         
                        input.seek(index25_127);
                        if ( s>=0 ) return s;
                        break;
                    case 120 : 
                        int LA25_126 = input.LA(1);

                         
                        int index25_126 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_126=='\"') ) {s = 64;}

                        else if ( (LA25_126=='\\') ) {s = 58;}

                        else if ( (LA25_126=='\n') ) {s = 59;}

                        else if ( (LA25_126=='\r') ) {s = 60;}

                        else if ( (LA25_126=='\t') ) {s = 61;}

                        else if ( ((LA25_126>=' ' && LA25_126<='!')||(LA25_126>='#' && LA25_126<='%')||(LA25_126>='\'' && LA25_126<=';')||(LA25_126>='=' && LA25_126<='[')||(LA25_126>=']' && LA25_126<='\u007F')) ) {s = 62;}

                        else if ( (LA25_126=='&') ) {s = 63;}

                        else if ( (LA25_126=='<') ) {s = 65;}

                        else if ( ((LA25_126>='\u0080' && LA25_126<='\uFFFF')) && (( inString ))) {s = 66;}

                         
                        input.seek(index25_126);
                        if ( s>=0 ) return s;
                        break;
                    case 121 : 
                        int LA25_176 = input.LA(1);

                         
                        int index25_176 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_176=='\\') ) {s = 206;}

                        else if ( (LA25_176=='\"') ) {s = 207;}

                        else if ( ((LA25_176>=' ' && LA25_176<='!')||(LA25_176>='#' && LA25_176<='%')||(LA25_176>='\'' && LA25_176<=';')||(LA25_176>='=' && LA25_176<='[')||(LA25_176>=']' && LA25_176<='\u007F')) ) {s = 62;}

                        else if ( (LA25_176=='&') ) {s = 63;}

                        else if ( (LA25_176=='\n') ) {s = 59;}

                        else if ( (LA25_176=='\r') ) {s = 60;}

                        else if ( (LA25_176=='\t') ) {s = 61;}

                        else if ( (LA25_176=='<') ) {s = 65;}

                        else if ( ((LA25_176>='\u0080' && LA25_176<='\uFFFF')) && (( inString ))) {s = 66;}

                         
                        input.seek(index25_176);
                        if ( s>=0 ) return s;
                        break;
                    case 122 : 
                        int LA25_219 = input.LA(1);

                         
                        int index25_219 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_219=='\"') ) {s = 64;}

                        else if ( (LA25_219=='\\') ) {s = 58;}

                        else if ( (LA25_219=='\n') ) {s = 59;}

                        else if ( (LA25_219=='\r') ) {s = 60;}

                        else if ( (LA25_219=='\t') ) {s = 61;}

                        else if ( ((LA25_219>=' ' && LA25_219<='!')||(LA25_219>='#' && LA25_219<='%')||(LA25_219>='\'' && LA25_219<=';')||(LA25_219>='=' && LA25_219<='[')||(LA25_219>=']' && LA25_219<='\u007F')) ) {s = 62;}

                        else if ( (LA25_219=='&') ) {s = 63;}

                        else if ( (LA25_219=='<') ) {s = 65;}

                        else if ( ((LA25_219>='\u0080' && LA25_219<='\uFFFF')) && (( inString ))) {s = 66;}

                         
                        input.seek(index25_219);
                        if ( s>=0 ) return s;
                        break;
                    case 123 : 
                        int LA25_189 = input.LA(1);

                         
                        int index25_189 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_189=='x') ) {s = 216;}

                        else if ( ((LA25_189>='0' && LA25_189<='9')) ) {s = 217;}

                        else if ( (LA25_189=='\"') ) {s = 64;}

                        else if ( (LA25_189=='\\') ) {s = 58;}

                        else if ( (LA25_189=='\n') ) {s = 59;}

                        else if ( (LA25_189=='\r') ) {s = 60;}

                        else if ( (LA25_189=='\t') ) {s = 61;}

                        else if ( ((LA25_189>=' ' && LA25_189<='!')||(LA25_189>='#' && LA25_189<='%')||(LA25_189>='\'' && LA25_189<='/')||(LA25_189>=':' && LA25_189<=';')||(LA25_189>='=' && LA25_189<='[')||(LA25_189>=']' && LA25_189<='w')||(LA25_189>='y' && LA25_189<='\u007F')) ) {s = 62;}

                        else if ( (LA25_189=='&') ) {s = 63;}

                        else if ( (LA25_189=='<') ) {s = 65;}

                        else if ( ((LA25_189>='\u0080' && LA25_189<='\uFFFF')) && (( inString ))) {s = 66;}

                         
                        input.seek(index25_189);
                        if ( s>=0 ) return s;
                        break;
                    case 124 : 
                        int LA25_101 = input.LA(1);

                         
                        int index25_101 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_101=='\"') ) {s = 138;}

                        else if ( (LA25_101=='\\') ) {s = 139;}

                        else if ( (LA25_101=='\n') ) {s = 140;}

                        else if ( (LA25_101=='\r') ) {s = 141;}

                        else if ( (LA25_101=='\t') ) {s = 142;}

                        else if ( ((LA25_101>=' ' && LA25_101<='!')||(LA25_101>='$' && LA25_101<='%')||(LA25_101>='\'' && LA25_101<='/')||LA25_101==';'||(LA25_101>='=' && LA25_101<='@')||LA25_101=='['||(LA25_101>=']' && LA25_101<='^')||LA25_101=='`'||(LA25_101>='{' && LA25_101<='\u007F')) ) {s = 143;}

                        else if ( (LA25_101=='&') ) {s = 144;}

                        else if ( (LA25_101=='#'||(LA25_101>='0' && LA25_101<=':')||(LA25_101>='A' && LA25_101<='Z')||LA25_101=='_'||(LA25_101>='a' && LA25_101<='z')) ) {s = 94;}

                        else if ( (LA25_101=='<') ) {s = 145;}

                        else if ( ((LA25_101>='\u0000' && LA25_101<='\b')||(LA25_101>='\u000B' && LA25_101<='\f')||(LA25_101>='\u000E' && LA25_101<='\u001F')||(LA25_101>='\u0080' && LA25_101<='\uFFFF')) ) {s = 104;}

                        else s = 66;

                         
                        input.seek(index25_101);
                        if ( s>=0 ) return s;
                        break;
                    case 125 : 
                        int LA25_62 = input.LA(1);

                         
                        int index25_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_62=='\"') ) {s = 64;}

                        else if ( (LA25_62=='\\') ) {s = 58;}

                        else if ( (LA25_62=='\n') ) {s = 59;}

                        else if ( (LA25_62=='\r') ) {s = 60;}

                        else if ( (LA25_62=='\t') ) {s = 61;}

                        else if ( ((LA25_62>=' ' && LA25_62<='!')||(LA25_62>='#' && LA25_62<='%')||(LA25_62>='\'' && LA25_62<=';')||(LA25_62>='=' && LA25_62<='[')||(LA25_62>=']' && LA25_62<='\u007F')) ) {s = 62;}

                        else if ( (LA25_62=='&') ) {s = 63;}

                        else if ( (LA25_62=='<') ) {s = 65;}

                        else if ( ((LA25_62>='\u0080' && LA25_62<='\uFFFF')) && (( inString ))) {s = 66;}

                         
                        input.seek(index25_62);
                        if ( s>=0 ) return s;
                        break;
                    case 126 : 
                        int LA25_192 = input.LA(1);

                        s = -1;
                        if ( (LA25_192=='\\') ) {s = 220;}

                        else if ( (LA25_192=='\"') ) {s = 185;}

                        else if ( ((LA25_192>=' ' && LA25_192<='!')||(LA25_192>='$' && LA25_192<='%')||(LA25_192>='\'' && LA25_192<='/')||LA25_192==';'||(LA25_192>='=' && LA25_192<='@')||LA25_192=='['||(LA25_192>=']' && LA25_192<='^')||LA25_192=='`'||(LA25_192>='{' && LA25_192<='\u007F')) ) {s = 143;}

                        else if ( (LA25_192=='\n') ) {s = 140;}

                        else if ( (LA25_192=='\r') ) {s = 141;}

                        else if ( (LA25_192=='\t') ) {s = 142;}

                        else if ( (LA25_192=='&') ) {s = 144;}

                        else if ( (LA25_192=='#'||(LA25_192>='0' && LA25_192<=':')||(LA25_192>='A' && LA25_192<='Z')||LA25_192=='_'||(LA25_192>='a' && LA25_192<='z')) ) {s = 94;}

                        else if ( (LA25_192=='<') ) {s = 145;}

                        else if ( ((LA25_192>='\u0000' && LA25_192<='\b')||(LA25_192>='\u000B' && LA25_192<='\f')||(LA25_192>='\u000E' && LA25_192<='\u001F')||(LA25_192>='\u0080' && LA25_192<='\uFFFF')) ) {s = 104;}

                        if ( s>=0 ) return s;
                        break;
                    case 127 : 
                        int LA25_139 = input.LA(1);

                        s = -1;
                        if ( (LA25_139=='\\') ) {s = 184;}

                        else if ( (LA25_139=='\"') ) {s = 185;}

                        else if ( ((LA25_139>=' ' && LA25_139<='!')||(LA25_139>='$' && LA25_139<='%')||(LA25_139>='\'' && LA25_139<='/')||LA25_139==';'||(LA25_139>='=' && LA25_139<='@')||LA25_139=='['||(LA25_139>=']' && LA25_139<='^')||LA25_139=='`'||(LA25_139>='{' && LA25_139<='\u007F')) ) {s = 143;}

                        else if ( (LA25_139=='\n') ) {s = 140;}

                        else if ( (LA25_139=='\r') ) {s = 141;}

                        else if ( (LA25_139=='\t') ) {s = 142;}

                        else if ( (LA25_139=='&') ) {s = 144;}

                        else if ( (LA25_139=='#'||(LA25_139>='0' && LA25_139<=':')||(LA25_139>='A' && LA25_139<='Z')||LA25_139=='_'||(LA25_139>='a' && LA25_139<='z')) ) {s = 94;}

                        else if ( (LA25_139=='<') ) {s = 145;}

                        else if ( ((LA25_139>='\u0000' && LA25_139<='\b')||(LA25_139>='\u000B' && LA25_139<='\f')||(LA25_139>='\u000E' && LA25_139<='\u001F')||(LA25_139>='\u0080' && LA25_139<='\uFFFF')) ) {s = 104;}

                        if ( s>=0 ) return s;
                        break;
                    case 128 : 
                        int LA25_157 = input.LA(1);

                        s = -1;
                        if ( (LA25_157=='\\') ) {s = 195;}

                        else if ( (LA25_157=='\"') ) {s = 196;}

                        else if ( ((LA25_157>=' ' && LA25_157<='!')||(LA25_157>='$' && LA25_157<='%')||(LA25_157>='\'' && LA25_157<='/')||LA25_157==';'||(LA25_157>='=' && LA25_157<='@')||LA25_157=='['||(LA25_157>=']' && LA25_157<='^')||LA25_157=='`'||(LA25_157>='{' && LA25_157<='\u007F')) ) {s = 161;}

                        else if ( (LA25_157=='\n') ) {s = 158;}

                        else if ( (LA25_157=='\r') ) {s = 159;}

                        else if ( (LA25_157=='\t') ) {s = 160;}

                        else if ( (LA25_157=='&') ) {s = 162;}

                        else if ( (LA25_157=='<') ) {s = 156;}

                        else if ( (LA25_157=='#'||(LA25_157>='0' && LA25_157<=':')||(LA25_157>='A' && LA25_157<='Z')||LA25_157=='_'||(LA25_157>='a' && LA25_157<='z')) ) {s = 71;}

                        else if ( ((LA25_157>='\u0000' && LA25_157<='\b')||(LA25_157>='\u000B' && LA25_157<='\f')||(LA25_157>='\u000E' && LA25_157<='\u001F')||(LA25_157>='\u0080' && LA25_157<='\uFFFF')) ) {s = 110;}

                        if ( s>=0 ) return s;
                        break;
                    case 129 : 
                        int LA25_20 = input.LA(1);

                         
                        int index25_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_20=='d') ) {s = 51;}

                        else if ( (LA25_20=='o') ) {s = 52;}

                        else if ( (LA25_20=='%'||(LA25_20>='.' && LA25_20<='/')) && (( inPath ))) {s = 37;}

                        else if ( ((LA25_20>='0' && LA25_20<='9')||(LA25_20>='A' && LA25_20<='Z')||(LA25_20>='a' && LA25_20<='c')||(LA25_20>='e' && LA25_20<='n')||(LA25_20>='p' && LA25_20<='z')) ) {s = 38;}

                        else if ( (LA25_20=='-') ) {s = 39;}

                         
                        input.seek(index25_20);
                        if ( s>=0 ) return s;
                        break;
                    case 130 : 
                        int LA25_199 = input.LA(1);

                         
                        int index25_199 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_199>='0' && LA25_199<='9')||(LA25_199>='A' && LA25_199<='Z')||(LA25_199>='a' && LA25_199<='z')) ) {s = 38;}

                        else if ( (LA25_199=='%'||(LA25_199>='.' && LA25_199<='/')) && (( inPath ))) {s = 37;}

                        else if ( (LA25_199=='-') ) {s = 39;}

                        else s = 226;

                         
                        input.seek(index25_199);
                        if ( s>=0 ) return s;
                        break;
                    case 131 : 
                        int LA25_183 = input.LA(1);

                         
                        int index25_183 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_183=='\"') ) {s = 64;}

                        else if ( (LA25_183=='\\') ) {s = 58;}

                        else if ( (LA25_183=='\n') ) {s = 59;}

                        else if ( (LA25_183=='\r') ) {s = 60;}

                        else if ( (LA25_183=='\t') ) {s = 61;}

                        else if ( ((LA25_183>=' ' && LA25_183<='!')||(LA25_183>='#' && LA25_183<='%')||(LA25_183>='\'' && LA25_183<=';')||(LA25_183>='=' && LA25_183<='[')||(LA25_183>=']' && LA25_183<='\u007F')) ) {s = 62;}

                        else if ( (LA25_183=='&') ) {s = 63;}

                        else if ( (LA25_183=='<') ) {s = 65;}

                        else if ( ((LA25_183>='\u0080' && LA25_183<='\uFFFF')) && (( inString ))) {s = 66;}

                         
                        input.seek(index25_183);
                        if ( s>=0 ) return s;
                        break;
                    case 132 : 
                        int LA25_200 = input.LA(1);

                         
                        int index25_200 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA25_200>='0' && LA25_200<='9')||(LA25_200>='A' && LA25_200<='Z')||(LA25_200>='a' && LA25_200<='z')) ) {s = 38;}

                        else if ( (LA25_200=='%'||(LA25_200>='.' && LA25_200<='/')) && (( inPath ))) {s = 37;}

                        else if ( (LA25_200=='-') ) {s = 39;}

                        else s = 227;

                         
                        input.seek(index25_200);
                        if ( s>=0 ) return s;
                        break;
                    case 133 : 
                        int LA25_136 = input.LA(1);

                         
                        int index25_136 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_136==';') ) {s = 137;}

                        else if ( ((LA25_136>='-' && LA25_136<='.')||(LA25_136>='0' && LA25_136<=':')||(LA25_136>='A' && LA25_136<='Z')||LA25_136=='_'||(LA25_136>='a' && LA25_136<='z')) ) {s = 136;}

                        else if ( ((LA25_136>=' ' && LA25_136<=',')||LA25_136=='/'||(LA25_136>='<' && LA25_136<='@')||(LA25_136>='[' && LA25_136<='^')||LA25_136=='`'||(LA25_136>='{' && LA25_136<='\uFFFF')) && (( inString ))) {s = 66;}

                         
                        input.seek(index25_136);
                        if ( s>=0 ) return s;
                        break;
                    case 134 : 
                        int LA25_3 = input.LA(1);

                         
                        int index25_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_3=='m') ) {s = 40;}

                        else if ( (LA25_3=='f') ) {s = 41;}

                        else if ( (LA25_3=='n') ) {s = 42;}

                        else if ( (LA25_3=='%'||(LA25_3>='.' && LA25_3<='/')) && (( inPath ))) {s = 37;}

                        else if ( ((LA25_3>='0' && LA25_3<='9')||(LA25_3>='A' && LA25_3<='Z')||(LA25_3>='a' && LA25_3<='e')||(LA25_3>='g' && LA25_3<='l')||(LA25_3>='o' && LA25_3<='z')) ) {s = 38;}

                        else if ( (LA25_3=='-') ) {s = 39;}

                         
                        input.seek(index25_3);
                        if ( s>=0 ) return s;
                        break;
                    case 135 : 
                        int LA25_211 = input.LA(1);

                         
                        int index25_211 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_211=='<') ) {s = 65;}

                        else if ( (LA25_211=='\\') ) {s = 58;}

                        else if ( (LA25_211=='\n') ) {s = 59;}

                        else if ( (LA25_211=='\r') ) {s = 60;}

                        else if ( (LA25_211=='\t') ) {s = 61;}

                        else if ( ((LA25_211>=' ' && LA25_211<='!')||(LA25_211>='#' && LA25_211<='%')||(LA25_211>='\'' && LA25_211<=';')||(LA25_211>='=' && LA25_211<='[')||(LA25_211>=']' && LA25_211<='\u007F')) ) {s = 62;}

                        else if ( (LA25_211=='&') ) {s = 63;}

                        else if ( (LA25_211=='\"') ) {s = 64;}

                        else if ( ((LA25_211>='\u0080' && LA25_211<='\uFFFF')) && (( inString ))) {s = 66;}

                         
                        input.seek(index25_211);
                        if ( s>=0 ) return s;
                        break;
                    case 136 : 
                        int LA25_238 = input.LA(1);

                        s = -1;
                        if ( (LA25_238=='\"') ) {s = 138;}

                        else if ( (LA25_238=='\\') ) {s = 139;}

                        else if ( (LA25_238=='\n') ) {s = 140;}

                        else if ( (LA25_238=='\r') ) {s = 141;}

                        else if ( (LA25_238=='\t') ) {s = 142;}

                        else if ( ((LA25_238>=' ' && LA25_238<='!')||(LA25_238>='$' && LA25_238<='%')||(LA25_238>='\'' && LA25_238<='/')||LA25_238==';'||(LA25_238>='=' && LA25_238<='@')||LA25_238=='['||(LA25_238>=']' && LA25_238<='^')||LA25_238=='`'||(LA25_238>='{' && LA25_238<='\u007F')) ) {s = 143;}

                        else if ( (LA25_238=='&') ) {s = 144;}

                        else if ( (LA25_238=='#'||(LA25_238>='0' && LA25_238<=':')||(LA25_238>='A' && LA25_238<='Z')||LA25_238=='_'||(LA25_238>='a' && LA25_238<='z')) ) {s = 94;}

                        else if ( (LA25_238=='<') ) {s = 145;}

                        else if ( ((LA25_238>='\u0000' && LA25_238<='\b')||(LA25_238>='\u000B' && LA25_238<='\f')||(LA25_238>='\u000E' && LA25_238<='\u001F')||(LA25_238>='\u0080' && LA25_238<='\uFFFF')) ) {s = 104;}

                        else s = 105;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 25, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}