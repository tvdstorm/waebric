// $ANTLR 3.1.2 /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g 2009-06-30 13:47:16
 package org.cwi.waebric; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class WaebricLexer extends Lexer {
    public static final int ESCLAYOUT=40;
    public static final int DEF=7;
    public static final int T__57=57;
    public static final int END=8;
    public static final int LIST=18;
    public static final int T__51=51;
    public static final int FILEEXT=31;
    public static final int T__47=47;
    public static final int T__50=50;
    public static final int STRCHAR=39;
    public static final int T__65=65;
    public static final int SYMBOLCON=33;
    public static final int COMMENTS=42;
    public static final int IDCON=21;
    public static final int DECIMAL=41;
    public static final int IMPORT=5;
    public static final int HEXADECIMAL=29;
    public static final int TEXTCHAR=26;
    public static final int T__52=52;
    public static final int T__46=46;
    public static final int ECHO=15;
    public static final int T__62=62;
    public static final int STRCON=25;
    public static final int MODULE=4;
    public static final int T__49=49;
    public static final int AMP=35;
    public static final int T__61=61;
    public static final int T__59=59;
    public static final int DIGIT=28;
    public static final int RECORD=19;
    public static final int T__54=54;
    public static final int T__48=48;
    public static final int LAYOUT=38;
    public static final int ESCQUOTE=34;
    public static final int PATHELEMENT=30;
    public static final int T__56=56;
    public static final int ENTREF=37;
    public static final int LETTER=27;
    public static final int CDATA=16;
    public static final int SITE=6;
    public static final int T__58=58;
    public static final int STRING=20;
    public static final int T__64=64;
    public static final int T__44=44;
    public static final int SYMBOLCHAR=32;
    public static final int COMMENT=14;
    public static final int YIELD=17;
    public static final int T__45=45;
    public static final int T__55=55;
    public static final int IN=13;
    public static final int CHARREF=36;
    public static final int ELSE=10;
    public static final int T__63=63;
    public static final int T__43=43;
    public static final int LET=12;
    public static final int IF=9;
    public static final int EOF=-1;
    public static final int T__53=53;
    public static final int TEXT=24;
    public static final int NATCON=23;
    public static final int T__60=60;
    public static final int EACH=11;
    public static final int PATH=22;

    // delegates
    // delegators

    public WaebricLexer() {;} 
    public WaebricLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public WaebricLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g"; }

    // $ANTLR start "MODULE"
    public final void mMODULE() throws RecognitionException {
        try {
            int _type = MODULE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:9:8: ( 'module' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:9:10: 'module'
            {
            match("module"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MODULE"

    // $ANTLR start "IMPORT"
    public final void mIMPORT() throws RecognitionException {
        try {
            int _type = IMPORT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:10:8: ( 'import' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:10:10: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IMPORT"

    // $ANTLR start "SITE"
    public final void mSITE() throws RecognitionException {
        try {
            int _type = SITE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:11:6: ( 'site' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:11:8: 'site'
            {
            match("site"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SITE"

    // $ANTLR start "DEF"
    public final void mDEF() throws RecognitionException {
        try {
            int _type = DEF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:12:5: ( 'def' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:12:7: 'def'
            {
            match("def"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEF"

    // $ANTLR start "END"
    public final void mEND() throws RecognitionException {
        try {
            int _type = END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:13:5: ( 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:13:7: 'end'
            {
            match("end"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "END"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:14:4: ( 'if' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:14:6: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "ELSE"
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:15:6: ( 'else' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:15:8: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ELSE"

    // $ANTLR start "EACH"
    public final void mEACH() throws RecognitionException {
        try {
            int _type = EACH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:16:6: ( 'each' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:16:8: 'each'
            {
            match("each"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EACH"

    // $ANTLR start "LET"
    public final void mLET() throws RecognitionException {
        try {
            int _type = LET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:17:5: ( 'let' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:17:7: 'let'
            {
            match("let"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LET"

    // $ANTLR start "IN"
    public final void mIN() throws RecognitionException {
        try {
            int _type = IN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:18:4: ( 'in' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:18:6: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IN"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:19:9: ( 'comment' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:19:11: 'comment'
            {
            match("comment"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "ECHO"
    public final void mECHO() throws RecognitionException {
        try {
            int _type = ECHO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:20:6: ( 'echo' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:20:8: 'echo'
            {
            match("echo"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ECHO"

    // $ANTLR start "CDATA"
    public final void mCDATA() throws RecognitionException {
        try {
            int _type = CDATA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:21:7: ( 'cdata' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:21:9: 'cdata'
            {
            match("cdata"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CDATA"

    // $ANTLR start "YIELD"
    public final void mYIELD() throws RecognitionException {
        try {
            int _type = YIELD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:22:7: ( 'yield' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:22:9: 'yield'
            {
            match("yield"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "YIELD"

    // $ANTLR start "LIST"
    public final void mLIST() throws RecognitionException {
        try {
            int _type = LIST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:23:6: ( 'list' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:23:8: 'list'
            {
            match("list"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LIST"

    // $ANTLR start "RECORD"
    public final void mRECORD() throws RecognitionException {
        try {
            int _type = RECORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:24:8: ( 'record' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:24:10: 'record'
            {
            match("record"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RECORD"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:25:8: ( 'string' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:25:10: 'string'
            {
            match("string"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:26:7: ( '.' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:26:9: '.'
            {
            match('.'); 

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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:27:7: ( ';' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:27:9: ';'
            {
            match(';'); 

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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:28:7: ( ':' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:28:9: ':'
            {
            match(':'); 

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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:29:7: ( '#' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:29:9: '#'
            {
            match('#'); 

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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:30:7: ( '$' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:30:9: '$'
            {
            match('$'); 

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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:31:7: ( '@' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:31:9: '@'
            {
            match('@'); 

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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:32:7: ( '%' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:32:9: '%'
            {
            match('%'); 

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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:33:7: ( '(' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:33:9: '('
            {
            match('('); 

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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:34:7: ( ',' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:34:9: ','
            {
            match(','); 

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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:35:7: ( ')' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:35:9: ')'
            {
            match(')'); 

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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:36:7: ( '+' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:36:9: '+'
            {
            match('+'); 

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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:37:7: ( '[' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:37:9: '['
            {
            match('['); 

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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:38:7: ( ']' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:38:9: ']'
            {
            match(']'); 

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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:39:7: ( '{' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:39:9: '{'
            {
            match('{'); 

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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:40:7: ( '}' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:40:9: '}'
            {
            match('}'); 

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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:41:7: ( 'yield;' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:41:9: 'yield;'
            {
            match("yield;"); 


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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:42:7: ( '=' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:42:9: '='
            {
            match('='); 

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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:43:7: ( '!' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:43:9: '!'
            {
            match('!'); 

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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:44:7: ( '&&' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:44:9: '&&'
            {
            match("&&"); 


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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:45:7: ( '||' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:45:9: '||'
            {
            match("||"); 


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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:46:7: ( '\"' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:46:9: '\"'
            {
            match('\"'); 

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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:47:7: ( '<' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:47:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:48:7: ( '>' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:48:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:97:16: ( 'a' .. 'z' | 'A' .. 'Z' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:98:15: ( '0' .. '9' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:98:18: '0' .. '9'
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:99:21: ( ( 'a' .. 'f' | 'A' .. 'F' | DIGIT )+ )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:99:23: ( 'a' .. 'f' | 'A' .. 'F' | DIGIT )+
            {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:99:23: ( 'a' .. 'f' | 'A' .. 'F' | DIGIT )+
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
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:101:5: ( ( PATHELEMENT '/' )* PATHELEMENT '.' FILEEXT )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:101:9: ( PATHELEMENT '/' )* PATHELEMENT '.' FILEEXT
            {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:101:9: ( PATHELEMENT '/' )*
            loop2:
            do {
                int alt2=2;
                alt2 = dfa2.predict(input);
                switch (alt2) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:101:11: PATHELEMENT '/'
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:102:21: ( ( LETTER | DIGIT )+ )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:102:23: ( LETTER | DIGIT )+
            {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:102:23: ( LETTER | DIGIT )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:103:17: ( ( LETTER | DIGIT )+ )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:103:19: ( LETTER | DIGIT )+
            {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:103:19: ( LETTER | DIGIT )+
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
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:
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

    // $ANTLR start "NATCON"
    public final void mNATCON() throws RecognitionException {
        try {
            int _type = NATCON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:105:7: ( ( DIGIT )+ )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:105:11: ( DIGIT )+
            {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:105:11: ( DIGIT )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:105:11: DIGIT
            	    {
            	    mDIGIT(); 

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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:106:6: ( LETTER ( LETTER | DIGIT | '-' )+ )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:106:10: LETTER ( LETTER | DIGIT | '-' )+
            {
            mLETTER(); 
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:106:17: ( LETTER | DIGIT | '-' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='-'||(LA6_0>='0' && LA6_0<='9')||(LA6_0>='A' && LA6_0<='Z')||(LA6_0>='a' && LA6_0<='z')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:
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
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDCON"

    // $ANTLR start "SYMBOLCON"
    public final void mSYMBOLCON() throws RecognitionException {
        try {
            int _type = SYMBOLCON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:108:10: ( '\\'' ( SYMBOLCHAR )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:108:13: '\\'' ( SYMBOLCHAR )*
            {
            match('\''); 
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:108:18: ( SYMBOLCHAR )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='!' && LA7_0<='(')||(LA7_0>='*' && LA7_0<='+')||(LA7_0>='-' && LA7_0<=':')||(LA7_0>='<' && LA7_0<='=')||(LA7_0>='?' && LA7_0<='|')||(LA7_0>='~' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:108:18: SYMBOLCHAR
            	    {
            	    mSYMBOLCHAR(); 

            	    }
            	    break;

            	default :
            	    break loop7;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:109:20: (~ ( '\\u0000' .. '\\u001F' | ' ' | ';' | ',' | '>' | '}' | ')' ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:109:22: ~ ( '\\u0000' .. '\\u001F' | ' ' | ';' | ',' | '>' | '}' | ')' )
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

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:111:5: ( '\\\"' ( TEXTCHAR )* '\\\"' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:111:9: '\\\"' ( TEXTCHAR )* '\\\"'
            {
            match('\"'); 
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:111:14: ( TEXTCHAR )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='\"') ) {
                    int LA8_1 = input.LA(2);

                    if ( ((LA8_1>='\t' && LA8_1<='\n')||LA8_1=='\r'||(LA8_1>=' ' && LA8_1<='\u007F')) ) {
                        alt8=1;
                    }


                }
                else if ( ((LA8_0>='\t' && LA8_0<='\n')||LA8_0=='\r'||(LA8_0>=' ' && LA8_0<='!')||(LA8_0>='#' && LA8_0<='\u007F')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:111:14: TEXTCHAR
            	    {
            	    mTEXTCHAR(); 

            	    }
            	    break;

            	default :
            	    break loop8;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:112:18: (~ ( '\\u0000' .. '\\u001F' | '&' | '\"' | '\\u0080' .. '\\uFFFF' ) | '\\n' | '\\r' | '\\t' | ESCQUOTE | AMP | CHARREF | ENTREF )
            int alt9=8;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:112:20: ~ ( '\\u0000' .. '\\u001F' | '&' | '\"' | '\\u0080' .. '\\uFFFF' )
                    {
                    if ( (input.LA(1)>=' ' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='%')||(input.LA(1)>='\'' && input.LA(1)<='\u007F') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:113:5: '\\n'
                    {
                    match('\n'); 

                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:113:12: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:113:19: '\\t'
                    {
                    match('\t'); 

                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:113:26: ESCQUOTE
                    {
                    mESCQUOTE(); 

                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:113:37: AMP
                    {
                    mAMP(); 

                    }
                    break;
                case 7 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:113:43: CHARREF
                    {
                    mCHARREF(); 

                    }
                    break;
                case 8 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:113:53: ENTREF
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:114:18: ( '\\\\' | '\\\"' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:
            {
            if ( input.LA(1)=='\"'||input.LA(1)=='\\' ) {
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
    // $ANTLR end "ESCQUOTE"

    // $ANTLR start "AMP"
    public final void mAMP() throws RecognitionException {
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:115:13: ( '\\&' (~ ( '#' | '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' | ':' ) )+ )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:115:16: '\\&' (~ ( '#' | '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' | ':' ) )+
            {
            match('&'); 
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:115:21: (~ ( '#' | '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' | ':' ) )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\"')||(LA10_0>='$' && LA10_0<='/')||(LA10_0>=';' && LA10_0<='@')||(LA10_0>='[' && LA10_0<='^')||LA10_0=='`'||(LA10_0>='{' && LA10_0<='\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:115:21: ~ ( '#' | '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' | ':' )
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
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:116:17: ( '&#' ( DIGIT )+ ';' | '&#x' HEXADECIMAL ';' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='&') ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1=='#') ) {
                    int LA12_2 = input.LA(3);

                    if ( (LA12_2=='x') ) {
                        alt12=2;
                    }
                    else if ( ((LA12_2>='0' && LA12_2<='9')) ) {
                        alt12=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:116:19: '&#' ( DIGIT )+ ';'
                    {
                    match("&#"); 

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:116:24: ( DIGIT )+
                    int cnt11=0;
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:116:24: DIGIT
                    	    {
                    	    mDIGIT(); 

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

                    match(';'); 

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:116:37: '&#x' HEXADECIMAL ';'
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:117:16: ( '&' ( LETTER | '_' | ':' ) ( LETTER | DIGIT | '.' | '-' | '_' | ':' )* ';' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:117:18: '&' ( LETTER | '_' | ':' ) ( LETTER | DIGIT | '.' | '-' | '_' | ':' )* ';'
            {
            match('&'); 
            if ( input.LA(1)==':'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:117:45: ( LETTER | DIGIT | '.' | '-' | '_' | ':' )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='-' && LA13_0<='.')||(LA13_0>='0' && LA13_0<=':')||(LA13_0>='A' && LA13_0<='Z')||LA13_0=='_'||(LA13_0>='a' && LA13_0<='z')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:
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
            	    break loop13;
                }
            } while (true);

            match(';'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "ENTREF"

    // $ANTLR start "STRCON"
    public final void mSTRCON() throws RecognitionException {
        try {
            int _type = STRCON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:119:7: ( 'comment' LAYOUT '\\\"' ( STRCHAR )* '\\\"' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:119:11: 'comment' LAYOUT '\\\"' ( STRCHAR )* '\\\"'
            {
            match("comment"); 

            mLAYOUT(); 
            match('\"'); 
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:119:33: ( STRCHAR )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=' ' && LA14_0<='!')||(LA14_0>='#' && LA14_0<='\uFFFF')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:119:33: STRCHAR
            	    {
            	    mSTRCHAR(); 

            	    }
            	    break;

            	default :
            	    break loop14;
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
    // $ANTLR end "STRCON"

    // $ANTLR start "STRCHAR"
    public final void mSTRCHAR() throws RecognitionException {
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:120:17: (~ ( '\\u0000' .. '\\u001F' | '\"' | '\\\\' ) | ESCLAYOUT | DECIMAL )
            int alt15=3;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=' ' && LA15_0<='!')||(LA15_0>='#' && LA15_0<='[')||(LA15_0>=']' && LA15_0<='\uFFFF')) ) {
                alt15=1;
            }
            else if ( (LA15_0=='\\') ) {
                int LA15_2 = input.LA(2);

                if ( (LA15_2=='\\') ) {
                    int LA15_3 = input.LA(3);

                    if ( (LA15_3=='\"'||LA15_3=='\\'||LA15_3=='n'||LA15_3=='t') ) {
                        alt15=2;
                    }
                    else if ( (LA15_3=='a') ) {
                        alt15=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:120:19: ~ ( '\\u0000' .. '\\u001F' | '\"' | '\\\\' )
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:120:58: ESCLAYOUT
                    {
                    mESCLAYOUT(); 

                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:120:70: DECIMAL
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:121:19: ( '\\\\\\\\n' | '\\\\\\\\t' | '\\\\\\\\\"' | '\\\\\\\\\\\\\\\\' )
            int alt16=4;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='\\') ) {
                int LA16_1 = input.LA(2);

                if ( (LA16_1=='\\') ) {
                    switch ( input.LA(3) ) {
                    case 'n':
                        {
                        alt16=1;
                        }
                        break;
                    case 't':
                        {
                        alt16=2;
                        }
                        break;
                    case '\"':
                        {
                        alt16=3;
                        }
                        break;
                    case '\\':
                        {
                        alt16=4;
                        }
                        break;
                    default:
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:121:21: '\\\\\\\\n'
                    {
                    match("\\\\n"); 


                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:121:31: '\\\\\\\\t'
                    {
                    match("\\\\t"); 


                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:121:41: '\\\\\\\\\"'
                    {
                    match("\\\\\""); 


                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:121:51: '\\\\\\\\\\\\\\\\'
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:122:17: ( '\\\\\\\\' 'a:' DIGIT 'b:' DIGIT 'c:' DIGIT )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:122:19: '\\\\\\\\' 'a:' DIGIT 'b:' DIGIT 'c:' DIGIT
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

    // $ANTLR start "COMMENTS"
    public final void mCOMMENTS() throws RecognitionException {
        try {
            int _type = COMMENTS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:124:9: ( '//' ( . )* '\\n' | '/*' ( . )* '*/' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='/') ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1=='/') ) {
                    alt19=1;
                }
                else if ( (LA19_1=='*') ) {
                    alt19=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:124:12: '//' ( . )* '\\n'
                    {
                    match("//"); 

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:124:17: ( . )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0=='\n') ) {
                            alt17=2;
                        }
                        else if ( ((LA17_0>='\u0000' && LA17_0<='\t')||(LA17_0>='\u000B' && LA17_0<='\uFFFF')) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:124:17: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    match('\n'); 

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:124:27: '/*' ( . )* '*/'
                    {
                    match("/*"); 

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:124:32: ( . )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0=='*') ) {
                            int LA18_1 = input.LA(2);

                            if ( (LA18_1=='/') ) {
                                alt18=2;
                            }
                            else if ( ((LA18_1>='\u0000' && LA18_1<='.')||(LA18_1>='0' && LA18_1<='\uFFFF')) ) {
                                alt18=1;
                            }


                        }
                        else if ( ((LA18_0>='\u0000' && LA18_0<=')')||(LA18_0>='+' && LA18_0<='\uFFFF')) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:124:32: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);

                    match("*/"); 

                     _channel = HIDDEN; 

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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:125:7: ( ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+ )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:125:11: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:125:11: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>='\t' && LA20_0<='\n')||(LA20_0>='\f' && LA20_0<='\r')||LA20_0==' ') ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:
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
            	    if ( cnt20 >= 1 ) break loop20;
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
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
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:8: ( MODULE | IMPORT | SITE | DEF | END | IF | ELSE | EACH | LET | IN | COMMENT | ECHO | CDATA | YIELD | LIST | RECORD | STRING | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | PATH | NATCON | IDCON | SYMBOLCON | TEXT | STRCON | COMMENTS | LAYOUT )
        int alt21=48;
        alt21 = dfa21.predict(input);
        switch (alt21) {
            case 1 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:10: MODULE
                {
                mMODULE(); 

                }
                break;
            case 2 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:17: IMPORT
                {
                mIMPORT(); 

                }
                break;
            case 3 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:24: SITE
                {
                mSITE(); 

                }
                break;
            case 4 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:29: DEF
                {
                mDEF(); 

                }
                break;
            case 5 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:33: END
                {
                mEND(); 

                }
                break;
            case 6 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:37: IF
                {
                mIF(); 

                }
                break;
            case 7 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:40: ELSE
                {
                mELSE(); 

                }
                break;
            case 8 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:45: EACH
                {
                mEACH(); 

                }
                break;
            case 9 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:50: LET
                {
                mLET(); 

                }
                break;
            case 10 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:54: IN
                {
                mIN(); 

                }
                break;
            case 11 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:57: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 12 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:65: ECHO
                {
                mECHO(); 

                }
                break;
            case 13 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:70: CDATA
                {
                mCDATA(); 

                }
                break;
            case 14 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:76: YIELD
                {
                mYIELD(); 

                }
                break;
            case 15 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:82: LIST
                {
                mLIST(); 

                }
                break;
            case 16 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:87: RECORD
                {
                mRECORD(); 

                }
                break;
            case 17 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:94: STRING
                {
                mSTRING(); 

                }
                break;
            case 18 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:101: T__43
                {
                mT__43(); 

                }
                break;
            case 19 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:107: T__44
                {
                mT__44(); 

                }
                break;
            case 20 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:113: T__45
                {
                mT__45(); 

                }
                break;
            case 21 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:119: T__46
                {
                mT__46(); 

                }
                break;
            case 22 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:125: T__47
                {
                mT__47(); 

                }
                break;
            case 23 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:131: T__48
                {
                mT__48(); 

                }
                break;
            case 24 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:137: T__49
                {
                mT__49(); 

                }
                break;
            case 25 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:143: T__50
                {
                mT__50(); 

                }
                break;
            case 26 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:149: T__51
                {
                mT__51(); 

                }
                break;
            case 27 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:155: T__52
                {
                mT__52(); 

                }
                break;
            case 28 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:161: T__53
                {
                mT__53(); 

                }
                break;
            case 29 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:167: T__54
                {
                mT__54(); 

                }
                break;
            case 30 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:173: T__55
                {
                mT__55(); 

                }
                break;
            case 31 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:179: T__56
                {
                mT__56(); 

                }
                break;
            case 32 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:185: T__57
                {
                mT__57(); 

                }
                break;
            case 33 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:191: T__58
                {
                mT__58(); 

                }
                break;
            case 34 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:197: T__59
                {
                mT__59(); 

                }
                break;
            case 35 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:203: T__60
                {
                mT__60(); 

                }
                break;
            case 36 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:209: T__61
                {
                mT__61(); 

                }
                break;
            case 37 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:215: T__62
                {
                mT__62(); 

                }
                break;
            case 38 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:221: T__63
                {
                mT__63(); 

                }
                break;
            case 39 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:227: T__64
                {
                mT__64(); 

                }
                break;
            case 40 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:233: T__65
                {
                mT__65(); 

                }
                break;
            case 41 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:239: PATH
                {
                mPATH(); 

                }
                break;
            case 42 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:244: NATCON
                {
                mNATCON(); 

                }
                break;
            case 43 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:251: IDCON
                {
                mIDCON(); 

                }
                break;
            case 44 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:257: SYMBOLCON
                {
                mSYMBOLCON(); 

                }
                break;
            case 45 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:267: TEXT
                {
                mTEXT(); 

                }
                break;
            case 46 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:272: STRCON
                {
                mSTRCON(); 

                }
                break;
            case 47 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:279: COMMENTS
                {
                mCOMMENTS(); 

                }
                break;
            case 48 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:1:288: LAYOUT
                {
                mLAYOUT(); 

                }
                break;

        }

    }


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA9 dfa9 = new DFA9(this);
    protected DFA21 dfa21 = new DFA21(this);
    static final String DFA2_eotS =
        "\4\uffff";
    static final String DFA2_eofS =
        "\4\uffff";
    static final String DFA2_minS =
        "\1\60\1\56\2\uffff";
    static final String DFA2_maxS =
        "\2\172\2\uffff";
    static final String DFA2_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA2_specialS =
        "\4\uffff}>";
    static final String[] DFA2_transitionS = {
            "\12\1\7\uffff\32\1\6\uffff\32\1",
            "\1\2\1\3\12\1\7\uffff\32\1\6\uffff\32\1",
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
            return "()* loopback of 101:9: ( PATHELEMENT '/' )*";
        }
    }
    static final String DFA9_eotS =
        "\12\uffff";
    static final String DFA9_eofS =
        "\12\uffff";
    static final String DFA9_minS =
        "\1\11\5\uffff\1\0\3\uffff";
    static final String DFA9_maxS =
        "\1\177\5\uffff\1\uffff\3\uffff";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\7\1\10\1\6";
    static final String DFA9_specialS =
        "\6\uffff\1\0\3\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\4\1\2\2\uffff\1\3\22\uffff\2\1\1\5\3\1\1\6\131\1",
            "",
            "",
            "",
            "",
            "",
            "\43\11\1\7\14\11\12\uffff\1\10\6\11\32\10\4\11\1\10\1\11\32"+
            "\10\uff85\11",
            "",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "112:10: fragment TEXTCHAR : (~ ( '\\u0000' .. '\\u001F' | '&' | '\"' | '\\u0080' .. '\\uFFFF' ) | '\\n' | '\\r' | '\\t' | ESCQUOTE | AMP | CHARREF | ENTREF );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA9_6 = input.LA(1);

                        s = -1;
                        if ( (LA9_6=='#') ) {s = 7;}

                        else if ( (LA9_6==':'||(LA9_6>='A' && LA9_6<='Z')||LA9_6=='_'||(LA9_6>='a' && LA9_6<='z')) ) {s = 8;}

                        else if ( ((LA9_6>='\u0000' && LA9_6<='\"')||(LA9_6>='$' && LA9_6<='/')||(LA9_6>=';' && LA9_6<='@')||(LA9_6>='[' && LA9_6<='^')||LA9_6=='`'||(LA9_6>='{' && LA9_6<='\uFFFF')) ) {s = 9;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 9, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA21_eotS =
        "\35\uffff\1\71\2\uffff\1\73\4\uffff\1\50\1\uffff\1\50\1\uffff\1"+
        "\50\1\76\1\77\15\50\3\uffff\2\50\2\uffff\2\50\1\121\1\122\3\50\1"+
        "\126\7\50\1\136\1\50\2\uffff\1\140\1\141\1\142\1\uffff\1\143\6\50"+
        "\1\uffff\1\50\4\uffff\1\50\1\154\1\156\1\50\1\160\1\161\1\162\1"+
        "\50\3\uffff\1\164\3\uffff\1\165\3\uffff";
    static final String DFA21_eofS =
        "\167\uffff";
    static final String DFA21_minS =
        "\1\11\11\55\23\uffff\1\11\2\uffff\1\56\1\55\3\uffff\1\56\1\uffff"+
        "\1\56\1\uffff\1\56\2\55\15\56\3\uffff\2\56\2\uffff\2\56\2\55\3\56"+
        "\1\55\7\56\1\55\1\56\2\uffff\3\55\1\uffff\1\55\6\56\1\uffff\1\56"+
        "\4\uffff\1\56\2\55\1\56\3\55\1\56\3\uffff\1\55\3\uffff\1\11\3\uffff";
    static final String DFA21_maxS =
        "\1\175\11\172\23\uffff\1\177\2\uffff\2\172\3\uffff\1\172\1\uffff"+
        "\1\172\1\uffff\20\172\3\uffff\2\172\2\uffff\21\172\2\uffff\3\172"+
        "\1\uffff\7\172\1\uffff\1\172\4\uffff\10\172\3\uffff\1\172\3\uffff"+
        "\1\172\3\uffff";
    static final String DFA21_acceptS =
        "\12\uffff\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34"+
        "\1\35\1\36\1\37\1\40\1\42\1\43\1\44\1\45\1\uffff\1\47\1\50\2\uffff"+
        "\1\54\1\57\1\60\1\uffff\1\51\1\uffff\1\53\20\uffff\1\46\1\55\1\52"+
        "\2\uffff\1\6\1\12\21\uffff\1\4\1\5\3\uffff\1\11\7\uffff\1\3\1\uffff"+
        "\1\7\1\10\1\14\1\17\10\uffff\1\15\1\41\1\16\1\uffff\1\1\1\2\1\21"+
        "\1\uffff\1\20\1\13\1\56";
    static final String DFA21_specialS =
        "\167\uffff}>";
    static final String[] DFA21_transitionS = {
            "\2\44\1\uffff\2\44\22\uffff\1\44\1\32\1\35\1\15\1\16\1\20\1"+
            "\33\1\42\1\21\1\23\1\uffff\1\24\1\22\1\uffff\1\12\1\43\12\40"+
            "\1\14\1\13\1\36\1\31\1\37\1\uffff\1\17\32\41\1\25\1\uffff\1"+
            "\26\3\uffff\2\41\1\7\1\4\1\5\3\41\1\2\2\41\1\6\1\1\4\41\1\11"+
            "\1\3\5\41\1\10\1\41\1\27\1\34\1\30",
            "\1\50\2\46\12\47\7\uffff\32\47\6\uffff\16\47\1\45\13\47",
            "\1\50\2\46\12\47\7\uffff\32\47\6\uffff\5\47\1\52\6\47\1\51"+
            "\1\53\14\47",
            "\1\50\2\46\12\47\7\uffff\32\47\6\uffff\10\47\1\54\12\47\1\55"+
            "\6\47",
            "\1\50\2\46\12\47\7\uffff\32\47\6\uffff\4\47\1\56\25\47",
            "\1\50\2\46\12\47\7\uffff\32\47\6\uffff\1\61\1\47\1\62\10\47"+
            "\1\60\1\47\1\57\14\47",
            "\1\50\2\46\12\47\7\uffff\32\47\6\uffff\4\47\1\63\3\47\1\64"+
            "\21\47",
            "\1\50\2\46\12\47\7\uffff\32\47\6\uffff\3\47\1\66\12\47\1\65"+
            "\13\47",
            "\1\50\2\46\12\47\7\uffff\32\47\6\uffff\10\47\1\67\21\47",
            "\1\50\2\46\12\47\7\uffff\32\47\6\uffff\4\47\1\70\25\47",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\2\72\2\uffff\1\72\22\uffff\140\72",
            "",
            "",
            "\2\46\12\40\7\uffff\32\46\6\uffff\32\46",
            "\1\50\2\46\12\47\7\uffff\32\47\6\uffff\32\47",
            "",
            "",
            "",
            "\2\46\12\47\7\uffff\32\47\6\uffff\3\47\1\74\26\47",
            "",
            "\2\46\12\47\7\uffff\32\47\6\uffff\32\47",
            "",
            "\2\46\12\47\7\uffff\32\47\6\uffff\17\47\1\75\12\47",
            "\1\50\2\46\12\47\7\uffff\32\47\6\uffff\32\47",
            "\1\50\2\46\12\47\7\uffff\32\47\6\uffff\32\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\23\47\1\100\6\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\21\47\1\101\10\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\5\47\1\102\24\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\3\47\1\103\26\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\22\47\1\104\7\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\2\47\1\105\27\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\7\47\1\106\22\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\23\47\1\107\6\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\22\47\1\110\7\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\14\47\1\111\15\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\1\112\31\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\4\47\1\113\25\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\2\47\1\114\27\47",
            "",
            "",
            "",
            "\2\46\12\47\7\uffff\32\47\6\uffff\24\47\1\115\5\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\16\47\1\116\13\47",
            "",
            "",
            "\2\46\12\47\7\uffff\32\47\6\uffff\4\47\1\117\25\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\10\47\1\120\21\47",
            "\1\50\2\46\12\47\7\uffff\32\47\6\uffff\32\47",
            "\1\50\2\46\12\47\7\uffff\32\47\6\uffff\32\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\4\47\1\123\25\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\7\47\1\124\22\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\16\47\1\125\13\47",
            "\1\50\2\46\12\47\7\uffff\32\47\6\uffff\32\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\23\47\1\127\6\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\14\47\1\130\15\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\23\47\1\131\6\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\13\47\1\132\16\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\16\47\1\133\13\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\13\47\1\134\16\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\21\47\1\135\10\47",
            "\1\50\2\46\12\47\7\uffff\32\47\6\uffff\32\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\15\47\1\137\14\47",
            "",
            "",
            "\1\50\2\46\12\47\7\uffff\32\47\6\uffff\32\47",
            "\1\50\2\46\12\47\7\uffff\32\47\6\uffff\32\47",
            "\1\50\2\46\12\47\7\uffff\32\47\6\uffff\32\47",
            "",
            "\1\50\2\46\12\47\7\uffff\32\47\6\uffff\32\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\4\47\1\144\25\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\1\145\31\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\3\47\1\146\26\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\21\47\1\147\10\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\4\47\1\150\25\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\23\47\1\151\6\47",
            "",
            "\2\46\12\47\7\uffff\32\47\6\uffff\6\47\1\152\23\47",
            "",
            "",
            "",
            "",
            "\2\46\12\47\7\uffff\32\47\6\uffff\15\47\1\153\14\47",
            "\1\50\2\46\12\47\7\uffff\32\47\6\uffff\32\47",
            "\1\50\2\46\12\47\1\uffff\1\155\5\uffff\32\47\6\uffff\32\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\3\47\1\157\26\47",
            "\1\50\2\46\12\47\7\uffff\32\47\6\uffff\32\47",
            "\1\50\2\46\12\47\7\uffff\32\47\6\uffff\32\47",
            "\1\50\2\46\12\47\7\uffff\32\47\6\uffff\32\47",
            "\2\46\12\47\7\uffff\32\47\6\uffff\23\47\1\163\6\47",
            "",
            "",
            "",
            "\1\50\2\46\12\47\7\uffff\32\47\6\uffff\32\47",
            "",
            "",
            "",
            "\2\166\1\uffff\2\166\22\uffff\1\166\14\uffff\1\50\2\46\12\47"+
            "\7\uffff\32\47\6\uffff\32\47",
            "",
            "",
            ""
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( MODULE | IMPORT | SITE | DEF | END | IF | ELSE | EACH | LET | IN | COMMENT | ECHO | CDATA | YIELD | LIST | RECORD | STRING | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | PATH | NATCON | IDCON | SYMBOLCON | TEXT | STRCON | COMMENTS | LAYOUT );";
        }
    }
 

}