// $ANTLR 3.1.2 /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g 2009-06-26 12:00:21

import org.antlr.runtime.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
public class DebugWaebricParser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDCON", "FILEEXT", "NATCON", "PATHELEMENT", "WHITESPACE", "'module'", "'end'", "'.'", "'import'", "';'", "'site'", "':'", "'/'", "'#'", "'$'", "'@'", "'%'", "'('", "','", "')'", "'def'"
    };
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
    public static final int IDCON=4;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__10=10;

    // delegates
    // delegators

    public static final String[] ruleNames = new String[] {
        "invalidRule", "moduleElement", "markup", "moduleID", "filename", 
        "designator", "argument", "arguments", "module", "mapping", "path", 
        "expression", "directory", "site", "attribute", "function", "moduleImport", 
        "dirname"
    };
     
        public int ruleLevel = 0;
        public int getRuleLevel() { return ruleLevel; }
        public void incRuleLevel() { ruleLevel++; }
        public void decRuleLevel() { ruleLevel--; }
        public DebugWaebricParser(TokenStream input) {
            this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
        }
        public DebugWaebricParser(TokenStream input, int port, RecognizerSharedState state) {
            super(input, state);
            DebugEventSocketProxy proxy =
                new DebugEventSocketProxy(this, port, null);
            setDebugListener(proxy);
            try {
                proxy.handshake();
            }
            catch (IOException ioe) {
                reportError(ioe);
            }
        }
    public DebugWaebricParser(TokenStream input, DebugEventListener dbg) {
        super(input, dbg, new RecognizerSharedState());

    }
    protected boolean evalPredicate(boolean result, String predicate) {
        dbg.semanticPredicate(result, predicate);
        return result;
    }


    public String[] getTokenNames() { return DebugWaebricParser.tokenNames; }
    public String getGrammarFileName() { return "/ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g"; }


    public static void main(String[] args) throws Exception {
            ANTLRInputStream input = new ANTLRInputStream(System.in);
            DebugWaebricLexer lexer = new DebugWaebricLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            DebugWaebricParser parser = new DebugWaebricParser(tokens);
            parser.module();
    }


    // $ANTLR start "module"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:19:1: module : 'module' moduleID ( moduleElement )* 'end' ;
    public final void module() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "module");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(19, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:19:7: ( 'module' moduleID ( moduleElement )* 'end' )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:19:11: 'module' moduleID ( moduleElement )* 'end'
            {
            dbg.location(19,11);
            match(input,9,FOLLOW_9_in_module25); 
            dbg.location(19,20);
            pushFollow(FOLLOW_moduleID_in_module27);
            moduleID();

            state._fsp--;

            dbg.location(19,29);
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:19:29: ( moduleElement )*
            try { dbg.enterSubRule(1);

            loop1:
            do {
                int alt1=2;
                try { dbg.enterDecision(1);

                int LA1_0 = input.LA(1);

                if ( (LA1_0==12||LA1_0==14||LA1_0==24) ) {
                    alt1=1;
                }


                } finally {dbg.exitDecision(1);}

                switch (alt1) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:19:29: moduleElement
            	    {
            	    dbg.location(19,29);
            	    pushFollow(FOLLOW_moduleElement_in_module29);
            	    moduleElement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);
            } finally {dbg.exitSubRule(1);}

            dbg.location(19,44);
            match(input,10,FOLLOW_10_in_module32); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(19, 49);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "module");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "module"


    // $ANTLR start "moduleID"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:20:1: moduleID : IDCON ( '.' IDCON )* ;
    public final void moduleID() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "moduleID");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(20, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:20:9: ( IDCON ( '.' IDCON )* )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:20:11: IDCON ( '.' IDCON )*
            {
            dbg.location(20,11);
            match(input,IDCON,FOLLOW_IDCON_in_moduleID38); 
            dbg.location(20,17);
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:20:17: ( '.' IDCON )*
            try { dbg.enterSubRule(2);

            loop2:
            do {
                int alt2=2;
                try { dbg.enterDecision(2);

                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }


                } finally {dbg.exitDecision(2);}

                switch (alt2) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:20:19: '.' IDCON
            	    {
            	    dbg.location(20,19);
            	    match(input,11,FOLLOW_11_in_moduleID42); 
            	    dbg.location(20,23);
            	    match(input,IDCON,FOLLOW_IDCON_in_moduleID44); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);
            } finally {dbg.exitSubRule(2);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(20, 31);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "moduleID");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "moduleID"


    // $ANTLR start "moduleElement"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:21:1: moduleElement : ( moduleImport | site | function );
    public final void moduleElement() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "moduleElement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(21, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:21:14: ( moduleImport | site | function )
            int alt3=3;
            try { dbg.enterDecision(3);

            switch ( input.LA(1) ) {
            case 12:
                {
                alt3=1;
                }
                break;
            case 14:
                {
                alt3=2;
                }
                break;
            case 24:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }

            } finally {dbg.exitDecision(3);}

            switch (alt3) {
                case 1 :
                    dbg.enterAlt(1);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:21:16: moduleImport
                    {
                    dbg.location(21,16);
                    pushFollow(FOLLOW_moduleImport_in_moduleElement53);
                    moduleImport();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:21:31: site
                    {
                    dbg.location(21,31);
                    pushFollow(FOLLOW_site_in_moduleElement57);
                    site();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:21:38: function
                    {
                    dbg.location(21,38);
                    pushFollow(FOLLOW_function_in_moduleElement61);
                    function();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(21, 46);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "moduleElement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "moduleElement"


    // $ANTLR start "moduleImport"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:22:1: moduleImport : 'import' moduleID ';' ;
    public final void moduleImport() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "moduleImport");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(22, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:22:13: ( 'import' moduleID ';' )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:22:15: 'import' moduleID ';'
            {
            dbg.location(22,15);
            match(input,12,FOLLOW_12_in_moduleImport67); 
            dbg.location(22,24);
            pushFollow(FOLLOW_moduleID_in_moduleImport69);
            moduleID();

            state._fsp--;

            dbg.location(22,33);
            match(input,13,FOLLOW_13_in_moduleImport71); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(22, 36);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "moduleImport");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "moduleImport"


    // $ANTLR start "site"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:24:1: site : 'site' mapping 'end' ;
    public final void site() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "site");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(24, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:24:5: ( 'site' mapping 'end' )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:24:8: 'site' mapping 'end'
            {
            dbg.location(24,8);
            match(input,14,FOLLOW_14_in_site79); 
            dbg.location(24,15);
            pushFollow(FOLLOW_mapping_in_site81);
            mapping();

            state._fsp--;

            dbg.location(24,23);
            match(input,10,FOLLOW_10_in_site83); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(24, 28);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "site");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "site"


    // $ANTLR start "mapping"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:25:1: mapping : path ':' markup ;
    public final void mapping() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "mapping");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(25, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:25:9: ( path ':' markup )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:25:11: path ':' markup
            {
            dbg.location(25,11);
            pushFollow(FOLLOW_path_in_mapping90);
            path();

            state._fsp--;

            dbg.location(25,16);
            match(input,15,FOLLOW_15_in_mapping92); 
            dbg.location(25,20);
            pushFollow(FOLLOW_markup_in_mapping94);
            markup();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(25, 26);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "mapping");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "mapping"


    // $ANTLR start "path"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:26:1: path : ( filename | dirname '/' filename );
    public final void path() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "path");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(26, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:26:5: ( filename | dirname '/' filename )
            int alt4=2;
            try { dbg.enterDecision(4);

            int LA4_0 = input.LA(1);

            if ( (LA4_0==IDCON) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==11) ) {
                    alt4=1;
                }
                else if ( (LA4_1==16) ) {
                    alt4=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    dbg.recognitionException(nvae);
                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(4);}

            switch (alt4) {
                case 1 :
                    dbg.enterAlt(1);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:26:8: filename
                    {
                    dbg.location(26,8);
                    pushFollow(FOLLOW_filename_in_path101);
                    filename();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:26:19: dirname '/' filename
                    {
                    dbg.location(26,19);
                    pushFollow(FOLLOW_dirname_in_path105);
                    dirname();

                    state._fsp--;

                    dbg.location(26,27);
                    match(input,16,FOLLOW_16_in_path107); 
                    dbg.location(26,31);
                    pushFollow(FOLLOW_filename_in_path109);
                    filename();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(26, 39);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "path");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "path"


    // $ANTLR start "dirname"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:27:1: dirname : directory ;
    public final void dirname() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "dirname");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(27, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:27:8: ( directory )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:27:10: directory
            {
            dbg.location(27,10);
            pushFollow(FOLLOW_directory_in_dirname115);
            directory();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(27, 19);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "dirname");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "dirname"


    // $ANTLR start "directory"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:28:1: directory : IDCON ( '/' IDCON )* ;
    public final void directory() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "directory");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(28, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:28:10: ( IDCON ( '/' IDCON )* )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:28:12: IDCON ( '/' IDCON )*
            {
            dbg.location(28,12);
            match(input,IDCON,FOLLOW_IDCON_in_directory121); 
            dbg.location(28,18);
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:28:18: ( '/' IDCON )*
            try { dbg.enterSubRule(5);

            loop5:
            do {
                int alt5=2;
                try { dbg.enterDecision(5);

                int LA5_0 = input.LA(1);

                if ( (LA5_0==16) ) {
                    int LA5_1 = input.LA(2);

                    if ( (LA5_1==IDCON) ) {
                        int LA5_2 = input.LA(3);

                        if ( (LA5_2==16) ) {
                            alt5=1;
                        }


                    }


                }


                } finally {dbg.exitDecision(5);}

                switch (alt5) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:28:20: '/' IDCON
            	    {
            	    dbg.location(28,20);
            	    match(input,16,FOLLOW_16_in_directory125); 
            	    dbg.location(28,24);
            	    match(input,IDCON,FOLLOW_IDCON_in_directory127); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);
            } finally {dbg.exitSubRule(5);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(28, 32);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "directory");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "directory"


    // $ANTLR start "filename"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:29:1: filename : IDCON '.' ( IDCON | FILEEXT ) ;
    public final void filename() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "filename");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(29, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:29:9: ( IDCON '.' ( IDCON | FILEEXT ) )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:29:11: IDCON '.' ( IDCON | FILEEXT )
            {
            dbg.location(29,11);
            match(input,IDCON,FOLLOW_IDCON_in_filename136); 
            dbg.location(29,17);
            match(input,11,FOLLOW_11_in_filename138); 
            dbg.location(29,21);
            if ( (input.LA(1)>=IDCON && input.LA(1)<=FILEEXT) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(29, 38);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "filename");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "filename"


    // $ANTLR start "markup"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:31:1: markup : ( designator | designator arguments );
    public final void markup() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "markup");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(31, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:31:7: ( designator | designator arguments )
            int alt6=2;
            try { dbg.enterDecision(6);

            try {
                isCyclicDecision = true;
                alt6 = dfa6.predict(input);
            }
            catch (NoViableAltException nvae) {
                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(6);}

            switch (alt6) {
                case 1 :
                    dbg.enterAlt(1);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:31:10: designator
                    {
                    dbg.location(31,10);
                    pushFollow(FOLLOW_designator_in_markup155);
                    designator();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:31:23: designator arguments
                    {
                    dbg.location(31,23);
                    pushFollow(FOLLOW_designator_in_markup159);
                    designator();

                    state._fsp--;

                    dbg.location(31,34);
                    pushFollow(FOLLOW_arguments_in_markup161);
                    arguments();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(31, 43);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "markup");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "markup"


    // $ANTLR start "designator"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:32:1: designator : IDCON ( attribute )* ;
    public final void designator() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "designator");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(32, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:32:11: ( IDCON ( attribute )* )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:32:13: IDCON ( attribute )*
            {
            dbg.location(32,13);
            match(input,IDCON,FOLLOW_IDCON_in_designator167); 
            dbg.location(32,19);
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:32:19: ( attribute )*
            try { dbg.enterSubRule(7);

            loop7:
            do {
                int alt7=2;
                try { dbg.enterDecision(7);

                int LA7_0 = input.LA(1);

                if ( (LA7_0==11||LA7_0==15||(LA7_0>=17 && LA7_0<=19)) ) {
                    alt7=1;
                }


                } finally {dbg.exitDecision(7);}

                switch (alt7) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:32:19: attribute
            	    {
            	    dbg.location(32,19);
            	    pushFollow(FOLLOW_attribute_in_designator169);
            	    attribute();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);
            } finally {dbg.exitSubRule(7);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(32, 29);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "designator");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "designator"


    // $ANTLR start "attribute"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:33:1: attribute : ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON );
    public final void attribute() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "attribute");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(33, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:33:10: ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON )
            int alt8=6;
            try { dbg.enterDecision(8);

            switch ( input.LA(1) ) {
            case 17:
                {
                alt8=1;
                }
                break;
            case 11:
                {
                alt8=2;
                }
                break;
            case 18:
                {
                alt8=3;
                }
                break;
            case 15:
                {
                alt8=4;
                }
                break;
            case 19:
                {
                int LA8_5 = input.LA(2);

                if ( (LA8_5==NATCON) ) {
                    int LA8_6 = input.LA(3);

                    if ( (LA8_6==20) ) {
                        alt8=6;
                    }
                    else if ( ((LA8_6>=10 && LA8_6<=11)||LA8_6==15||(LA8_6>=17 && LA8_6<=19)||LA8_6==21) ) {
                        alt8=5;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 6, input);

                        dbg.recognitionException(nvae);
                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 5, input);

                    dbg.recognitionException(nvae);
                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }

            } finally {dbg.exitDecision(8);}

            switch (alt8) {
                case 1 :
                    dbg.enterAlt(1);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:33:12: '#' IDCON
                    {
                    dbg.location(33,12);
                    match(input,17,FOLLOW_17_in_attribute176); 
                    dbg.location(33,16);
                    match(input,IDCON,FOLLOW_IDCON_in_attribute178); 

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:33:24: '.' IDCON
                    {
                    dbg.location(33,24);
                    match(input,11,FOLLOW_11_in_attribute182); 
                    dbg.location(33,28);
                    match(input,IDCON,FOLLOW_IDCON_in_attribute184); 

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:33:36: '$' IDCON
                    {
                    dbg.location(33,36);
                    match(input,18,FOLLOW_18_in_attribute188); 
                    dbg.location(33,40);
                    match(input,IDCON,FOLLOW_IDCON_in_attribute190); 

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:33:48: ':' IDCON
                    {
                    dbg.location(33,48);
                    match(input,15,FOLLOW_15_in_attribute194); 
                    dbg.location(33,52);
                    match(input,IDCON,FOLLOW_IDCON_in_attribute196); 

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:34:5: '@' NATCON
                    {
                    dbg.location(34,5);
                    match(input,19,FOLLOW_19_in_attribute202); 
                    dbg.location(34,9);
                    match(input,NATCON,FOLLOW_NATCON_in_attribute204); 

                    }
                    break;
                case 6 :
                    dbg.enterAlt(6);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:34:18: '@' NATCON '%' NATCON
                    {
                    dbg.location(34,18);
                    match(input,19,FOLLOW_19_in_attribute208); 
                    dbg.location(34,22);
                    match(input,NATCON,FOLLOW_NATCON_in_attribute210); 
                    dbg.location(34,29);
                    match(input,20,FOLLOW_20_in_attribute212); 
                    dbg.location(34,33);
                    match(input,NATCON,FOLLOW_NATCON_in_attribute214); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(34, 39);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "attribute");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "attribute"


    // $ANTLR start "arguments"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:35:1: arguments : '(' argument ( ',' argument )* ')' ;
    public final void arguments() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "arguments");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(35, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:35:10: ( '(' argument ( ',' argument )* ')' )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:35:12: '(' argument ( ',' argument )* ')'
            {
            dbg.location(35,12);
            match(input,21,FOLLOW_21_in_arguments220); 
            dbg.location(35,16);
            pushFollow(FOLLOW_argument_in_arguments222);
            argument();

            state._fsp--;

            dbg.location(35,25);
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:35:25: ( ',' argument )*
            try { dbg.enterSubRule(9);

            loop9:
            do {
                int alt9=2;
                try { dbg.enterDecision(9);

                int LA9_0 = input.LA(1);

                if ( (LA9_0==22) ) {
                    alt9=1;
                }


                } finally {dbg.exitDecision(9);}

                switch (alt9) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:35:27: ',' argument
            	    {
            	    dbg.location(35,27);
            	    match(input,22,FOLLOW_22_in_arguments226); 
            	    dbg.location(35,31);
            	    pushFollow(FOLLOW_argument_in_arguments228);
            	    argument();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);
            } finally {dbg.exitSubRule(9);}

            dbg.location(35,44);
            match(input,23,FOLLOW_23_in_arguments234); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(35, 47);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "arguments");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "arguments"


    // $ANTLR start "argument"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:36:1: argument : expression ;
    public final void argument() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "argument");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(36, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:36:9: ( expression )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:36:11: expression
            {
            dbg.location(36,11);
            pushFollow(FOLLOW_expression_in_argument240);
            expression();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(36, 21);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "argument");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "argument"


    // $ANTLR start "expression"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:38:1: expression : ( IDCON | NATCON );
    public final void expression() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(38, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:38:11: ( IDCON | NATCON )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:
            {
            dbg.location(38,11);
            if ( input.LA(1)==IDCON||input.LA(1)==NATCON ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(38, 27);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "expression"


    // $ANTLR start "function"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:40:1: function : 'def' IDCON 'end' ;
    public final void function() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "function");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(40, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:40:9: ( 'def' IDCON 'end' )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:40:11: 'def' IDCON 'end'
            {
            dbg.location(40,11);
            match(input,24,FOLLOW_24_in_function259); 
            dbg.location(40,17);
            match(input,IDCON,FOLLOW_IDCON_in_function261); 
            dbg.location(40,23);
            match(input,10,FOLLOW_10_in_function263); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(40, 28);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "function");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "function"

    // Delegated rules


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\20\uffff";
    static final String DFA6_eofS =
        "\20\uffff";
    static final String DFA6_minS =
        "\1\4\1\12\4\4\1\6\2\uffff\5\12\1\6\1\12";
    static final String DFA6_maxS =
        "\1\4\1\25\4\4\1\6\2\uffff\5\25\1\6\1\25";
    static final String DFA6_acceptS =
        "\7\uffff\1\1\1\2\7\uffff";
    static final String DFA6_specialS =
        "\20\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\1",
            "\1\7\1\3\3\uffff\1\5\1\uffff\1\2\1\4\1\6\1\uffff\1\10",
            "\1\11",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15",
            "",
            "",
            "\1\7\1\3\3\uffff\1\5\1\uffff\1\2\1\4\1\6\1\uffff\1\10",
            "\1\7\1\3\3\uffff\1\5\1\uffff\1\2\1\4\1\6\1\uffff\1\10",
            "\1\7\1\3\3\uffff\1\5\1\uffff\1\2\1\4\1\6\1\uffff\1\10",
            "\1\7\1\3\3\uffff\1\5\1\uffff\1\2\1\4\1\6\1\uffff\1\10",
            "\1\7\1\3\3\uffff\1\5\1\uffff\1\2\1\4\1\6\1\16\1\10",
            "\1\17",
            "\1\7\1\3\3\uffff\1\5\1\uffff\1\2\1\4\1\6\1\uffff\1\10"
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
            return "31:1: markup : ( designator | designator arguments );";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
 

    public static final BitSet FOLLOW_9_in_module25 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_moduleID_in_module27 = new BitSet(new long[]{0x0000000001005400L});
    public static final BitSet FOLLOW_moduleElement_in_module29 = new BitSet(new long[]{0x0000000001005400L});
    public static final BitSet FOLLOW_10_in_module32 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_moduleID38 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_11_in_moduleID42 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_moduleID44 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_moduleImport_in_moduleElement53 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_site_in_moduleElement57 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_moduleElement61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_moduleImport67 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_moduleID_in_moduleImport69 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_moduleImport71 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_site79 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_mapping_in_site81 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_site83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_path_in_mapping90 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_mapping92 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_mapping94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filename_in_path101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dirname_in_path105 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_path107 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_filename_in_path109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_directory_in_dirname115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_directory121 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_directory125 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_directory127 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_IDCON_in_filename136 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_filename138 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_set_in_filename140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_designator_in_markup155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_designator_in_markup159 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_arguments_in_markup161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_designator167 = new BitSet(new long[]{0x00000000000E8802L});
    public static final BitSet FOLLOW_attribute_in_designator169 = new BitSet(new long[]{0x00000000000E8802L});
    public static final BitSet FOLLOW_17_in_attribute176 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_attribute182 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_attribute188 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_attribute194 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_attribute202 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NATCON_in_attribute204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_attribute208 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NATCON_in_attribute210 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_attribute212 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NATCON_in_attribute214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_arguments220 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_argument_in_arguments222 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_22_in_arguments226 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_argument_in_arguments228 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_23_in_arguments234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_argument240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_expression0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_function259 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_function261 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_function263 = new BitSet(new long[]{0x0000000000000002L});

}