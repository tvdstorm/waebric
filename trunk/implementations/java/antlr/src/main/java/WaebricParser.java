// $ANTLR 3.1.2 /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g 2009-06-26 16:21:47

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.antlr.runtime.debug.*;
import java.io.IOException;
public class WaebricParser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDCON", "NATCON", "TYPE", "TEXTCHAR", "TEXT", "STRCHAR", "STRCON", "SYMBOLCHAR", "SYMBOLCON", "WHITESPACE", "'module'", "'end'", "'.'", "'import'", "';'", "'site'", "'def'", "'('", "','", "')'", "'#'", "'$'", "':'", "'@'", "'%'", "'if'", "'else'", "'each'", "'let'", "'in'", "'{'", "'}'", "'echo'", "'cdata'", "'yield;'", "'='", "'!'", "'\"'", "'<'", "'>'"
    };
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
    public static final int TEXTCHAR=7;
    public static final int STRCON=10;
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

    public static final String[] ruleNames = new String[] {
        "invalidRule", "synpred16_Waebric", "imprt", "formals", "synpred9_Waebric", 
        "synpred21_Waebric", "synpred38_Waebric", "midtext", "synpred27_Waebric", 
        "assignment", "synpred29_Waebric", "synpred18_Waebric", "synpred45_Waebric", 
        "synpred40_Waebric", "synpred17_Waebric", "synpred41_Waebric", "synpred33_Waebric", 
        "synpred5_Waebric", "synpred37_Waebric", "synpred13_Waebric", "predicate", 
        "synpred15_Waebric", "embedding", "synpred44_Waebric", "synpred6_Waebric", 
        "synpred24_Waebric", "synpred19_Waebric", "synpred36_Waebric", "synpred10_Waebric", 
        "markup", "module", "synpred32_Waebric", "synpred2_Waebric", "embed", 
        "synpred30_Waebric", "statement", "synpred20_Waebric", "synpred43_Waebric", 
        "synpred3_Waebric", "synpred35_Waebric", "synpred1_Waebric", "synpred28_Waebric", 
        "synpred11_Waebric", "synpred22_Waebric", "site", "attribute", "designator", 
        "synpred26_Waebric", "synpred34_Waebric", "posttext", "moduleId", 
        "synpred39_Waebric", "synpred25_Waebric", "synpred12_Waebric", "synpred42_Waebric", 
        "arguments", "synpred7_Waebric", "texttail", "moduleElement", "synpred14_Waebric", 
        "synpred31_Waebric", "function", "expression", "synpred4_Waebric", 
        "argument", "synpred8_Waebric", "pretext", "synpred23_Waebric"
    };
     
        public int ruleLevel = 0;
        public int getRuleLevel() { return ruleLevel; }
        public void incRuleLevel() { ruleLevel++; }
        public void decRuleLevel() { ruleLevel--; }
        public WaebricParser(TokenStream input) {
            this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
        }
        public WaebricParser(TokenStream input, int port, RecognizerSharedState state) {
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
    public WaebricParser(TokenStream input, DebugEventListener dbg) {
        super(input, dbg, new RecognizerSharedState());

    }
    protected boolean evalPredicate(boolean result, String predicate) {
        dbg.semanticPredicate(result, predicate);
        return result;
    }


    public String[] getTokenNames() { return WaebricParser.tokenNames; }
    public String getGrammarFileName() { return "/ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g"; }



    // $ANTLR start "module"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:12:1: module : 'module' moduleId ( moduleElement )* 'end' ;
    public final void module() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "module");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(12, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:12:7: ( 'module' moduleId ( moduleElement )* 'end' )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:12:12: 'module' moduleId ( moduleElement )* 'end'
            {
            dbg.location(12,12);
            match(input,14,FOLLOW_14_in_module27); if (state.failed) return ;
            dbg.location(12,21);
            pushFollow(FOLLOW_moduleId_in_module29);
            moduleId();

            state._fsp--;
            if (state.failed) return ;
            dbg.location(12,30);
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:12:30: ( moduleElement )*
            try { dbg.enterSubRule(1);

            loop1:
            do {
                int alt1=2;
                try { dbg.enterDecision(1);

                int LA1_0 = input.LA(1);

                if ( (LA1_0==17||(LA1_0>=19 && LA1_0<=20)) ) {
                    alt1=1;
                }


                } finally {dbg.exitDecision(1);}

                switch (alt1) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: moduleElement
            	    {
            	    dbg.location(12,30);
            	    pushFollow(FOLLOW_moduleElement_in_module31);
            	    moduleElement();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);
            } finally {dbg.exitSubRule(1);}

            dbg.location(12,45);
            match(input,15,FOLLOW_15_in_module34); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(12, 50);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "module");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "module"


    // $ANTLR start "moduleId"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:13:1: moduleId : IDCON ( '.' IDCON )* ;
    public final void moduleId() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "moduleId");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(13, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:13:9: ( IDCON ( '.' IDCON )* )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:13:12: IDCON ( '.' IDCON )*
            {
            dbg.location(13,12);
            match(input,IDCON,FOLLOW_IDCON_in_moduleId41); if (state.failed) return ;
            dbg.location(13,18);
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:13:18: ( '.' IDCON )*
            try { dbg.enterSubRule(2);

            loop2:
            do {
                int alt2=2;
                try { dbg.enterDecision(2);

                int LA2_0 = input.LA(1);

                if ( (LA2_0==16) ) {
                    alt2=1;
                }


                } finally {dbg.exitDecision(2);}

                switch (alt2) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:13:20: '.' IDCON
            	    {
            	    dbg.location(13,20);
            	    match(input,16,FOLLOW_16_in_moduleId45); if (state.failed) return ;
            	    dbg.location(13,24);
            	    match(input,IDCON,FOLLOW_IDCON_in_moduleId47); if (state.failed) return ;

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
        dbg.location(13, 32);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "moduleId");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "moduleId"


    // $ANTLR start "moduleElement"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:14:1: moduleElement : ( imprt | site | function );
    public final void moduleElement() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "moduleElement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(14, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:14:14: ( imprt | site | function )
            int alt3=3;
            try { dbg.enterDecision(3);

            switch ( input.LA(1) ) {
            case 17:
                {
                alt3=1;
                }
                break;
            case 19:
                {
                alt3=2;
                }
                break;
            case 20:
                {
                alt3=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }

            } finally {dbg.exitDecision(3);}

            switch (alt3) {
                case 1 :
                    dbg.enterAlt(1);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:14:17: imprt
                    {
                    dbg.location(14,17);
                    pushFollow(FOLLOW_imprt_in_moduleElement57);
                    imprt();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:14:25: site
                    {
                    dbg.location(14,25);
                    pushFollow(FOLLOW_site_in_moduleElement61);
                    site();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:14:32: function
                    {
                    dbg.location(14,32);
                    pushFollow(FOLLOW_function_in_moduleElement65);
                    function();

                    state._fsp--;
                    if (state.failed) return ;

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
        dbg.location(14, 40);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "moduleElement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "moduleElement"


    // $ANTLR start "imprt"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:16:1: imprt : 'import' moduleId ';' ;
    public final void imprt() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "imprt");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(16, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:16:6: ( 'import' moduleId ';' )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:16:10: 'import' moduleId ';'
            {
            dbg.location(16,10);
            match(input,17,FOLLOW_17_in_imprt74); if (state.failed) return ;
            dbg.location(16,19);
            pushFollow(FOLLOW_moduleId_in_imprt76);
            moduleId();

            state._fsp--;
            if (state.failed) return ;
            dbg.location(16,28);
            match(input,18,FOLLOW_18_in_imprt78); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(16, 31);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "imprt");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "imprt"


    // $ANTLR start "site"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:17:1: site : 'site' 'end' ;
    public final void site() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "site");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(17, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:17:5: ( 'site' 'end' )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:17:9: 'site' 'end'
            {
            dbg.location(17,9);
            match(input,19,FOLLOW_19_in_site86); if (state.failed) return ;
            dbg.location(17,30);
            match(input,15,FOLLOW_15_in_site90); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(17, 35);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "site");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "site"


    // $ANTLR start "function"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:18:1: function : 'def' IDCON formals ( statement )* 'end' ;
    public final void function() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "function");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(18, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:18:9: ( 'def' IDCON formals ( statement )* 'end' )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:18:12: 'def' IDCON formals ( statement )* 'end'
            {
            dbg.location(18,12);
            match(input,20,FOLLOW_20_in_function97); if (state.failed) return ;
            dbg.location(18,18);
            match(input,IDCON,FOLLOW_IDCON_in_function99); if (state.failed) return ;
            dbg.location(18,24);
            pushFollow(FOLLOW_formals_in_function101);
            formals();

            state._fsp--;
            if (state.failed) return ;
            dbg.location(18,32);
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:18:32: ( statement )*
            try { dbg.enterSubRule(4);

            loop4:
            do {
                int alt4=2;
                try { dbg.enterDecision(4);

                int LA4_0 = input.LA(1);

                if ( (LA4_0==IDCON||LA4_0==29||(LA4_0>=31 && LA4_0<=32)||LA4_0==34||(LA4_0>=36 && LA4_0<=38)) ) {
                    alt4=1;
                }


                } finally {dbg.exitDecision(4);}

                switch (alt4) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: statement
            	    {
            	    dbg.location(18,32);
            	    pushFollow(FOLLOW_statement_in_function103);
            	    statement();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);
            } finally {dbg.exitSubRule(4);}

            dbg.location(18,43);
            match(input,15,FOLLOW_15_in_function106); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(18, 48);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "function");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "function"


    // $ANTLR start "formals"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:19:1: formals : ( '(' ( IDCON )? ( ',' IDCON )* ')' | );
    public final void formals() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "formals");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(19, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:19:8: ( '(' ( IDCON )? ( ',' IDCON )* ')' | )
            int alt7=2;
            try { dbg.enterDecision(7);

            int LA7_0 = input.LA(1);

            if ( (LA7_0==21) ) {
                alt7=1;
            }
            else if ( (LA7_0==IDCON||LA7_0==15||LA7_0==29||(LA7_0>=31 && LA7_0<=32)||LA7_0==34||(LA7_0>=36 && LA7_0<=38)) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(7);}

            switch (alt7) {
                case 1 :
                    dbg.enterAlt(1);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:19:11: '(' ( IDCON )? ( ',' IDCON )* ')'
                    {
                    dbg.location(19,11);
                    match(input,21,FOLLOW_21_in_formals113); if (state.failed) return ;
                    dbg.location(19,15);
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:19:15: ( IDCON )?
                    int alt5=2;
                    try { dbg.enterSubRule(5);
                    try { dbg.enterDecision(5);

                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==IDCON) ) {
                        alt5=1;
                    }
                    } finally {dbg.exitDecision(5);}

                    switch (alt5) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: IDCON
                            {
                            dbg.location(19,15);
                            match(input,IDCON,FOLLOW_IDCON_in_formals115); if (state.failed) return ;

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(5);}

                    dbg.location(19,22);
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:19:22: ( ',' IDCON )*
                    try { dbg.enterSubRule(6);

                    loop6:
                    do {
                        int alt6=2;
                        try { dbg.enterDecision(6);

                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==22) ) {
                            alt6=1;
                        }


                        } finally {dbg.exitDecision(6);}

                        switch (alt6) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:19:24: ',' IDCON
                    	    {
                    	    dbg.location(19,24);
                    	    match(input,22,FOLLOW_22_in_formals120); if (state.failed) return ;
                    	    dbg.location(19,28);
                    	    match(input,IDCON,FOLLOW_IDCON_in_formals122); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(6);}

                    dbg.location(19,37);
                    match(input,23,FOLLOW_23_in_formals127); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:19:43: 
                    {
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
        dbg.location(19, 43);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "formals");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "formals"


    // $ANTLR start "markup"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:21:1: markup : designator ( arguments )? ;
    public final void markup() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "markup");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(21, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:30:7: ( designator ( arguments )? )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:30:11: designator ( arguments )?
            {
            dbg.location(30,11);
            pushFollow(FOLLOW_designator_in_markup143);
            designator();

            state._fsp--;
            if (state.failed) return ;
            dbg.location(30,22);
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:30:22: ( arguments )?
            int alt8=2;
            try { dbg.enterSubRule(8);
            try { dbg.enterDecision(8);

            int LA8_0 = input.LA(1);

            if ( (LA8_0==21) ) {
                alt8=1;
            }
            } finally {dbg.exitDecision(8);}

            switch (alt8) {
                case 1 :
                    dbg.enterAlt(1);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: arguments
                    {
                    dbg.location(30,22);
                    pushFollow(FOLLOW_arguments_in_markup145);
                    arguments();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
            } finally {dbg.exitSubRule(8);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(30, 32);

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:31:1: designator : IDCON ( attribute )* ;
    public final void designator() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "designator");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(31, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:31:11: ( IDCON ( attribute )* )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:31:14: IDCON ( attribute )*
            {
            dbg.location(31,14);
            match(input,IDCON,FOLLOW_IDCON_in_designator153); if (state.failed) return ;
            dbg.location(31,20);
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:31:20: ( attribute )*
            try { dbg.enterSubRule(9);

            loop9:
            do {
                int alt9=2;
                try { dbg.enterDecision(9);

                int LA9_0 = input.LA(1);

                if ( (LA9_0==16||(LA9_0>=24 && LA9_0<=27)) ) {
                    alt9=1;
                }


                } finally {dbg.exitDecision(9);}

                switch (alt9) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: attribute
            	    {
            	    dbg.location(31,20);
            	    pushFollow(FOLLOW_attribute_in_designator155);
            	    attribute();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);
            } finally {dbg.exitSubRule(9);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(31, 30);

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:32:1: attribute : ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON );
    public final void attribute() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "attribute");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(32, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:32:10: ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON )
            int alt10=6;
            try { dbg.enterDecision(10);

            switch ( input.LA(1) ) {
            case 24:
                {
                alt10=1;
                }
                break;
            case 16:
                {
                alt10=2;
                }
                break;
            case 25:
                {
                alt10=3;
                }
                break;
            case 26:
                {
                alt10=4;
                }
                break;
            case 27:
                {
                int LA10_5 = input.LA(2);

                if ( (LA10_5==NATCON) ) {
                    int LA10_6 = input.LA(3);

                    if ( (LA10_6==28) ) {
                        alt10=6;
                    }
                    else if ( (LA10_6==EOF||(LA10_6>=IDCON && LA10_6<=NATCON)||LA10_6==16||LA10_6==18||LA10_6==21||(LA10_6>=24 && LA10_6<=27)||LA10_6==29||(LA10_6>=31 && LA10_6<=32)||LA10_6==34||(LA10_6>=36 && LA10_6<=38)||LA10_6==43) ) {
                        alt10=5;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 6, input);

                        dbg.recognitionException(nvae);
                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 5, input);

                    dbg.recognitionException(nvae);
                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }

            } finally {dbg.exitDecision(10);}

            switch (alt10) {
                case 1 :
                    dbg.enterAlt(1);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:32:13: '#' IDCON
                    {
                    dbg.location(32,13);
                    match(input,24,FOLLOW_24_in_attribute163); if (state.failed) return ;
                    dbg.location(32,17);
                    match(input,IDCON,FOLLOW_IDCON_in_attribute165); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:33:4: '.' IDCON
                    {
                    dbg.location(33,4);
                    match(input,16,FOLLOW_16_in_attribute173); if (state.failed) return ;
                    dbg.location(33,8);
                    match(input,IDCON,FOLLOW_IDCON_in_attribute175); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:34:4: '$' IDCON
                    {
                    dbg.location(34,4);
                    match(input,25,FOLLOW_25_in_attribute183); if (state.failed) return ;
                    dbg.location(34,8);
                    match(input,IDCON,FOLLOW_IDCON_in_attribute185); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:35:4: ':' IDCON
                    {
                    dbg.location(35,4);
                    match(input,26,FOLLOW_26_in_attribute193); if (state.failed) return ;
                    dbg.location(35,8);
                    match(input,IDCON,FOLLOW_IDCON_in_attribute195); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:36:4: '@' NATCON
                    {
                    dbg.location(36,4);
                    match(input,27,FOLLOW_27_in_attribute203); if (state.failed) return ;
                    dbg.location(36,8);
                    match(input,NATCON,FOLLOW_NATCON_in_attribute205); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    dbg.enterAlt(6);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:37:4: '@' NATCON '%' NATCON
                    {
                    dbg.location(37,4);
                    match(input,27,FOLLOW_27_in_attribute213); if (state.failed) return ;
                    dbg.location(37,8);
                    match(input,NATCON,FOLLOW_NATCON_in_attribute215); if (state.failed) return ;
                    dbg.location(37,15);
                    match(input,28,FOLLOW_28_in_attribute217); if (state.failed) return ;
                    dbg.location(37,19);
                    match(input,NATCON,FOLLOW_NATCON_in_attribute219); if (state.failed) return ;

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
        dbg.location(37, 25);

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:38:1: arguments : ( '(' ( argument )? ( ',' argument )* ')' ) ;
    public final void arguments() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "arguments");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(38, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:38:10: ( ( '(' ( argument )? ( ',' argument )* ')' ) )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:38:13: ( '(' ( argument )? ( ',' argument )* ')' )
            {
            dbg.location(38,13);
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:38:13: ( '(' ( argument )? ( ',' argument )* ')' )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:38:14: '(' ( argument )? ( ',' argument )* ')'
            {
            dbg.location(38,14);
            match(input,21,FOLLOW_21_in_arguments227); if (state.failed) return ;
            dbg.location(38,18);
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:38:18: ( argument )?
            int alt11=2;
            try { dbg.enterSubRule(11);
            try { dbg.enterDecision(11);

            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=IDCON && LA11_0<=NATCON)) ) {
                alt11=1;
            }
            } finally {dbg.exitDecision(11);}

            switch (alt11) {
                case 1 :
                    dbg.enterAlt(1);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: argument
                    {
                    dbg.location(38,18);
                    pushFollow(FOLLOW_argument_in_arguments229);
                    argument();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
            } finally {dbg.exitSubRule(11);}

            dbg.location(38,28);
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:38:28: ( ',' argument )*
            try { dbg.enterSubRule(12);

            loop12:
            do {
                int alt12=2;
                try { dbg.enterDecision(12);

                int LA12_0 = input.LA(1);

                if ( (LA12_0==22) ) {
                    alt12=1;
                }


                } finally {dbg.exitDecision(12);}

                switch (alt12) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:38:30: ',' argument
            	    {
            	    dbg.location(38,30);
            	    match(input,22,FOLLOW_22_in_arguments234); if (state.failed) return ;
            	    dbg.location(38,34);
            	    pushFollow(FOLLOW_argument_in_arguments236);
            	    argument();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);
            } finally {dbg.exitSubRule(12);}

            dbg.location(38,47);
            match(input,23,FOLLOW_23_in_arguments242); if (state.failed) return ;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(38, 51);

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:39:1: argument : expression ;
    public final void argument() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "argument");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(39, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:39:9: ( expression )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:39:12: expression
            {
            dbg.location(39,12);
            pushFollow(FOLLOW_expression_in_argument250);
            expression();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(39, 22);

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:42:1: expression : ( IDCON | NATCON );
    public final void expression() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(42, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:42:11: ( IDCON | NATCON )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:
            {
            dbg.location(42,11);
            if ( (input.LA(1)>=IDCON && input.LA(1)<=NATCON) ) {
                input.consume();
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
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
        dbg.location(42, 28);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "expression"


    // $ANTLR start "statement"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:45:1: statement : ( 'if' '(' predicate ')' statement ( 'else' statement )? | 'each' '(' IDCON ':' expression ')' statement | 'let' ( assignment )+ 'in' ( statement )* 'end' | '{' ( statement )* '}' | 'echo' expression ';' | 'cdata' expression ';' | 'yield;' | markup ';' | ( markup )+ statement ';' | ( markup )+ markup ';' | ( markup )+ expression ';' );
    public final void statement() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(45, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:45:10: ( 'if' '(' predicate ')' statement ( 'else' statement )? | 'each' '(' IDCON ':' expression ')' statement | 'let' ( assignment )+ 'in' ( statement )* 'end' | '{' ( statement )* '}' | 'echo' expression ';' | 'cdata' expression ';' | 'yield;' | markup ';' | ( markup )+ statement ';' | ( markup )+ markup ';' | ( markup )+ expression ';' )
            int alt20=11;
            try { dbg.enterDecision(20);

            try {
                isCyclicDecision = true;
                alt20 = dfa20.predict(input);
            }
            catch (NoViableAltException nvae) {
                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(20);}

            switch (alt20) {
                case 1 :
                    dbg.enterAlt(1);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:45:13: 'if' '(' predicate ')' statement ( 'else' statement )?
                    {
                    dbg.location(45,13);
                    match(input,29,FOLLOW_29_in_statement273); if (state.failed) return ;
                    dbg.location(45,18);
                    match(input,21,FOLLOW_21_in_statement275); if (state.failed) return ;
                    dbg.location(45,22);
                    pushFollow(FOLLOW_predicate_in_statement277);
                    predicate();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(45,32);
                    match(input,23,FOLLOW_23_in_statement279); if (state.failed) return ;
                    dbg.location(45,36);
                    pushFollow(FOLLOW_statement_in_statement281);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(45,46);
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:45:46: ( 'else' statement )?
                    int alt13=2;
                    try { dbg.enterSubRule(13);
                    try { dbg.enterDecision(13);

                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==30) ) {
                        int LA13_1 = input.LA(2);

                        if ( (synpred19_Waebric()) ) {
                            alt13=1;
                        }
                    }
                    } finally {dbg.exitDecision(13);}

                    switch (alt13) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:45:47: 'else' statement
                            {
                            dbg.location(45,47);
                            match(input,30,FOLLOW_30_in_statement284); if (state.failed) return ;
                            dbg.location(45,54);
                            pushFollow(FOLLOW_statement_in_statement286);
                            statement();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(13);}


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:46:4: 'each' '(' IDCON ':' expression ')' statement
                    {
                    dbg.location(46,4);
                    match(input,31,FOLLOW_31_in_statement296); if (state.failed) return ;
                    dbg.location(46,11);
                    match(input,21,FOLLOW_21_in_statement298); if (state.failed) return ;
                    dbg.location(46,15);
                    match(input,IDCON,FOLLOW_IDCON_in_statement300); if (state.failed) return ;
                    dbg.location(46,21);
                    match(input,26,FOLLOW_26_in_statement302); if (state.failed) return ;
                    dbg.location(46,25);
                    pushFollow(FOLLOW_expression_in_statement304);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(46,36);
                    match(input,23,FOLLOW_23_in_statement306); if (state.failed) return ;
                    dbg.location(46,40);
                    pushFollow(FOLLOW_statement_in_statement308);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:47:4: 'let' ( assignment )+ 'in' ( statement )* 'end'
                    {
                    dbg.location(47,4);
                    match(input,32,FOLLOW_32_in_statement316); if (state.failed) return ;
                    dbg.location(47,10);
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:47:10: ( assignment )+
                    int cnt14=0;
                    try { dbg.enterSubRule(14);

                    loop14:
                    do {
                        int alt14=2;
                        try { dbg.enterDecision(14);

                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==IDCON) ) {
                            alt14=1;
                        }


                        } finally {dbg.exitDecision(14);}

                        switch (alt14) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: assignment
                    	    {
                    	    dbg.location(47,10);
                    	    pushFollow(FOLLOW_assignment_in_statement318);
                    	    assignment();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt14 >= 1 ) break loop14;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(14, input);
                                dbg.recognitionException(eee);

                                throw eee;
                        }
                        cnt14++;
                    } while (true);
                    } finally {dbg.exitSubRule(14);}

                    dbg.location(47,22);
                    match(input,33,FOLLOW_33_in_statement321); if (state.failed) return ;
                    dbg.location(47,27);
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:47:27: ( statement )*
                    try { dbg.enterSubRule(15);

                    loop15:
                    do {
                        int alt15=2;
                        try { dbg.enterDecision(15);

                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==IDCON||LA15_0==29||(LA15_0>=31 && LA15_0<=32)||LA15_0==34||(LA15_0>=36 && LA15_0<=38)) ) {
                            alt15=1;
                        }


                        } finally {dbg.exitDecision(15);}

                        switch (alt15) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: statement
                    	    {
                    	    dbg.location(47,27);
                    	    pushFollow(FOLLOW_statement_in_statement323);
                    	    statement();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(15);}

                    dbg.location(47,38);
                    match(input,15,FOLLOW_15_in_statement326); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:48:4: '{' ( statement )* '}'
                    {
                    dbg.location(48,4);
                    match(input,34,FOLLOW_34_in_statement333); if (state.failed) return ;
                    dbg.location(48,8);
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:48:8: ( statement )*
                    try { dbg.enterSubRule(16);

                    loop16:
                    do {
                        int alt16=2;
                        try { dbg.enterDecision(16);

                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==IDCON||LA16_0==29||(LA16_0>=31 && LA16_0<=32)||LA16_0==34||(LA16_0>=36 && LA16_0<=38)) ) {
                            alt16=1;
                        }


                        } finally {dbg.exitDecision(16);}

                        switch (alt16) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: statement
                    	    {
                    	    dbg.location(48,8);
                    	    pushFollow(FOLLOW_statement_in_statement335);
                    	    statement();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(16);}

                    dbg.location(48,19);
                    match(input,35,FOLLOW_35_in_statement338); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:50:4: 'echo' expression ';'
                    {
                    dbg.location(50,4);
                    match(input,36,FOLLOW_36_in_statement349); if (state.failed) return ;
                    dbg.location(50,11);
                    pushFollow(FOLLOW_expression_in_statement351);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(50,22);
                    match(input,18,FOLLOW_18_in_statement353); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    dbg.enterAlt(6);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:52:4: 'cdata' expression ';'
                    {
                    dbg.location(52,4);
                    match(input,37,FOLLOW_37_in_statement364); if (state.failed) return ;
                    dbg.location(52,12);
                    pushFollow(FOLLOW_expression_in_statement366);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(52,23);
                    match(input,18,FOLLOW_18_in_statement368); if (state.failed) return ;

                    }
                    break;
                case 7 :
                    dbg.enterAlt(7);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:53:4: 'yield;'
                    {
                    dbg.location(53,4);
                    match(input,38,FOLLOW_38_in_statement376); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    dbg.enterAlt(8);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:54:4: markup ';'
                    {
                    dbg.location(54,4);
                    pushFollow(FOLLOW_markup_in_statement383);
                    markup();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(54,11);
                    match(input,18,FOLLOW_18_in_statement385); if (state.failed) return ;

                    }
                    break;
                case 9 :
                    dbg.enterAlt(9);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:55:4: ( markup )+ statement ';'
                    {
                    dbg.location(55,4);
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:55:4: ( markup )+
                    int cnt17=0;
                    try { dbg.enterSubRule(17);

                    loop17:
                    do {
                        int alt17=2;
                        try { dbg.enterDecision(17);

                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==IDCON) ) {
                            int LA17_2 = input.LA(2);

                            if ( (synpred31_Waebric()) ) {
                                alt17=1;
                            }


                        }


                        } finally {dbg.exitDecision(17);}

                        switch (alt17) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    dbg.location(55,4);
                    	    pushFollow(FOLLOW_markup_in_statement392);
                    	    markup();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt17 >= 1 ) break loop17;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(17, input);
                                dbg.recognitionException(eee);

                                throw eee;
                        }
                        cnt17++;
                    } while (true);
                    } finally {dbg.exitSubRule(17);}

                    dbg.location(55,12);
                    pushFollow(FOLLOW_statement_in_statement395);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(55,22);
                    match(input,18,FOLLOW_18_in_statement397); if (state.failed) return ;

                    }
                    break;
                case 10 :
                    dbg.enterAlt(10);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:56:4: ( markup )+ markup ';'
                    {
                    dbg.location(56,4);
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:56:4: ( markup )+
                    int cnt18=0;
                    try { dbg.enterSubRule(18);

                    loop18:
                    do {
                        int alt18=2;
                        try { dbg.enterDecision(18);

                        try {
                            isCyclicDecision = true;
                            alt18 = dfa18.predict(input);
                        }
                        catch (NoViableAltException nvae) {
                            dbg.recognitionException(nvae);
                            throw nvae;
                        }
                        } finally {dbg.exitDecision(18);}

                        switch (alt18) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    dbg.location(56,4);
                    	    pushFollow(FOLLOW_markup_in_statement404);
                    	    markup();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt18 >= 1 ) break loop18;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(18, input);
                                dbg.recognitionException(eee);

                                throw eee;
                        }
                        cnt18++;
                    } while (true);
                    } finally {dbg.exitSubRule(18);}

                    dbg.location(56,12);
                    pushFollow(FOLLOW_markup_in_statement407);
                    markup();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(56,19);
                    match(input,18,FOLLOW_18_in_statement409); if (state.failed) return ;

                    }
                    break;
                case 11 :
                    dbg.enterAlt(11);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:57:4: ( markup )+ expression ';'
                    {
                    dbg.location(57,4);
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:57:4: ( markup )+
                    int cnt19=0;
                    try { dbg.enterSubRule(19);

                    loop19:
                    do {
                        int alt19=2;
                        try { dbg.enterDecision(19);

                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==IDCON) ) {
                            int LA19_1 = input.LA(2);

                            if ( ((LA19_1>=IDCON && LA19_1<=NATCON)||LA19_1==16||LA19_1==21||(LA19_1>=24 && LA19_1<=27)) ) {
                                alt19=1;
                            }


                        }


                        } finally {dbg.exitDecision(19);}

                        switch (alt19) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    dbg.location(57,4);
                    	    pushFollow(FOLLOW_markup_in_statement416);
                    	    markup();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt19 >= 1 ) break loop19;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(19, input);
                                dbg.recognitionException(eee);

                                throw eee;
                        }
                        cnt19++;
                    } while (true);
                    } finally {dbg.exitSubRule(19);}

                    dbg.location(57,12);
                    pushFollow(FOLLOW_expression_in_statement419);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(57,23);
                    match(input,18,FOLLOW_18_in_statement421); if (state.failed) return ;

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
        dbg.location(57, 27);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "statement"


    // $ANTLR start "assignment"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:58:1: assignment : ( IDCON '=' expression ';' | IDCON formals statement );
    public final void assignment() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "assignment");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(58, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:58:11: ( IDCON '=' expression ';' | IDCON formals statement )
            int alt21=2;
            try { dbg.enterDecision(21);

            int LA21_0 = input.LA(1);

            if ( (LA21_0==IDCON) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==39) ) {
                    alt21=1;
                }
                else if ( (LA21_1==IDCON||LA21_1==21||LA21_1==29||(LA21_1>=31 && LA21_1<=32)||LA21_1==34||(LA21_1>=36 && LA21_1<=38)) ) {
                    alt21=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 1, input);

                    dbg.recognitionException(nvae);
                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(21);}

            switch (alt21) {
                case 1 :
                    dbg.enterAlt(1);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:58:14: IDCON '=' expression ';'
                    {
                    dbg.location(58,14);
                    match(input,IDCON,FOLLOW_IDCON_in_assignment429); if (state.failed) return ;
                    dbg.location(58,20);
                    match(input,39,FOLLOW_39_in_assignment431); if (state.failed) return ;
                    dbg.location(58,24);
                    pushFollow(FOLLOW_expression_in_assignment433);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(58,35);
                    match(input,18,FOLLOW_18_in_assignment435); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:59:4: IDCON formals statement
                    {
                    dbg.location(59,4);
                    match(input,IDCON,FOLLOW_IDCON_in_assignment443); if (state.failed) return ;
                    dbg.location(59,10);
                    pushFollow(FOLLOW_formals_in_assignment445);
                    formals();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(59,18);
                    pushFollow(FOLLOW_statement_in_assignment447);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

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
        dbg.location(59, 27);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "assignment");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "assignment"


    // $ANTLR start "predicate"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:62:1: predicate : ( expression | expression '.' TYPE | '!' predicate );
    public final void predicate() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "predicate");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(62, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:62:10: ( expression | expression '.' TYPE | '!' predicate )
            int alt22=3;
            try { dbg.enterDecision(22);

            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=IDCON && LA22_0<=NATCON)) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==16) ) {
                    alt22=2;
                }
                else if ( (LA22_1==23) ) {
                    alt22=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 1, input);

                    dbg.recognitionException(nvae);
                    throw nvae;
                }
            }
            else if ( (LA22_0==40) ) {
                alt22=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(22);}

            switch (alt22) {
                case 1 :
                    dbg.enterAlt(1);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:62:13: expression
                    {
                    dbg.location(62,13);
                    pushFollow(FOLLOW_expression_in_predicate460);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:62:26: expression '.' TYPE
                    {
                    dbg.location(62,26);
                    pushFollow(FOLLOW_expression_in_predicate464);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(62,37);
                    match(input,16,FOLLOW_16_in_predicate466); if (state.failed) return ;
                    dbg.location(62,41);
                    match(input,TYPE,FOLLOW_TYPE_in_predicate468); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:62:48: '!' predicate
                    {
                    dbg.location(62,48);
                    match(input,40,FOLLOW_40_in_predicate472); if (state.failed) return ;
                    dbg.location(62,52);
                    pushFollow(FOLLOW_predicate_in_predicate474);
                    predicate();

                    state._fsp--;
                    if (state.failed) return ;

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
        dbg.location(62, 62);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "predicate");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "predicate"


    // $ANTLR start "embedding"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:66:1: embedding : pretext embed texttail ;
    public final void embedding() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "embedding");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(66, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:66:10: ( pretext embed texttail )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:66:13: pretext embed texttail
            {
            dbg.location(66,13);
            pushFollow(FOLLOW_pretext_in_embedding492);
            pretext();

            state._fsp--;
            if (state.failed) return ;
            dbg.location(66,21);
            pushFollow(FOLLOW_embed_in_embedding494);
            embed();

            state._fsp--;
            if (state.failed) return ;
            dbg.location(66,27);
            pushFollow(FOLLOW_texttail_in_embedding496);
            texttail();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(66, 35);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "embedding");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "embedding"


    // $ANTLR start "embed"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:67:1: embed : ( ( markup )* expression | ( markup )* markup );
    public final void embed() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "embed");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(67, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:67:6: ( ( markup )* expression | ( markup )* markup )
            int alt25=2;
            try { dbg.enterDecision(25);

            int LA25_0 = input.LA(1);

            if ( (LA25_0==IDCON) ) {
                int LA25_1 = input.LA(2);

                if ( (synpred40_Waebric()) ) {
                    alt25=1;
                }
                else if ( (true) ) {
                    alt25=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 1, input);

                    dbg.recognitionException(nvae);
                    throw nvae;
                }
            }
            else if ( (LA25_0==NATCON) ) {
                alt25=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(25);}

            switch (alt25) {
                case 1 :
                    dbg.enterAlt(1);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:67:10: ( markup )* expression
                    {
                    dbg.location(67,10);
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:67:10: ( markup )*
                    try { dbg.enterSubRule(23);

                    loop23:
                    do {
                        int alt23=2;
                        try { dbg.enterDecision(23);

                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==IDCON) ) {
                            int LA23_1 = input.LA(2);

                            if ( ((LA23_1>=IDCON && LA23_1<=NATCON)||LA23_1==16||LA23_1==21||(LA23_1>=24 && LA23_1<=27)) ) {
                                alt23=1;
                            }


                        }


                        } finally {dbg.exitDecision(23);}

                        switch (alt23) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    dbg.location(67,10);
                    	    pushFollow(FOLLOW_markup_in_embed505);
                    	    markup();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(23);}

                    dbg.location(67,18);
                    pushFollow(FOLLOW_expression_in_embed508);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:68:4: ( markup )* markup
                    {
                    dbg.location(68,4);
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:68:4: ( markup )*
                    try { dbg.enterSubRule(24);

                    loop24:
                    do {
                        int alt24=2;
                        try { dbg.enterDecision(24);

                        try {
                            isCyclicDecision = true;
                            alt24 = dfa24.predict(input);
                        }
                        catch (NoViableAltException nvae) {
                            dbg.recognitionException(nvae);
                            throw nvae;
                        }
                        } finally {dbg.exitDecision(24);}

                        switch (alt24) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    dbg.location(68,4);
                    	    pushFollow(FOLLOW_markup_in_embed515);
                    	    markup();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(24);}

                    dbg.location(68,12);
                    pushFollow(FOLLOW_markup_in_embed518);
                    markup();

                    state._fsp--;
                    if (state.failed) return ;

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
        dbg.location(68, 18);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "embed");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "embed"


    // $ANTLR start "texttail"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:69:1: texttail : ( posttext | midtext embed texttail );
    public final void texttail() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "texttail");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(69, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:69:9: ( posttext | midtext embed texttail )
            int alt26=2;
            try { dbg.enterDecision(26);

            try {
                isCyclicDecision = true;
                alt26 = dfa26.predict(input);
            }
            catch (NoViableAltException nvae) {
                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(26);}

            switch (alt26) {
                case 1 :
                    dbg.enterAlt(1);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:69:12: posttext
                    {
                    dbg.location(69,12);
                    pushFollow(FOLLOW_posttext_in_texttail525);
                    posttext();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:69:23: midtext embed texttail
                    {
                    dbg.location(69,23);
                    pushFollow(FOLLOW_midtext_in_texttail529);
                    midtext();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(69,31);
                    pushFollow(FOLLOW_embed_in_texttail531);
                    embed();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(69,37);
                    pushFollow(FOLLOW_texttail_in_texttail533);
                    texttail();

                    state._fsp--;
                    if (state.failed) return ;

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
        dbg.location(69, 45);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "texttail");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "texttail"


    // $ANTLR start "pretext"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:70:1: pretext : '\"' ( TEXTCHAR )* '<' ;
    public final void pretext() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "pretext");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(70, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:70:8: ( '\"' ( TEXTCHAR )* '<' )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:70:11: '\"' ( TEXTCHAR )* '<'
            {
            dbg.location(70,11);
            match(input,41,FOLLOW_41_in_pretext540); if (state.failed) return ;
            dbg.location(70,15);
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:70:15: ( TEXTCHAR )*
            try { dbg.enterSubRule(27);

            loop27:
            do {
                int alt27=2;
                try { dbg.enterDecision(27);

                int LA27_0 = input.LA(1);

                if ( (LA27_0==TEXTCHAR) ) {
                    alt27=1;
                }


                } finally {dbg.exitDecision(27);}

                switch (alt27) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: TEXTCHAR
            	    {
            	    dbg.location(70,15);
            	    match(input,TEXTCHAR,FOLLOW_TEXTCHAR_in_pretext542); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);
            } finally {dbg.exitSubRule(27);}

            dbg.location(70,25);
            match(input,42,FOLLOW_42_in_pretext545); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(70, 28);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "pretext");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "pretext"


    // $ANTLR start "posttext"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:71:1: posttext : '>' ( TEXTCHAR )* '\"' ;
    public final void posttext() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "posttext");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(71, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:71:9: ( '>' ( TEXTCHAR )* '\"' )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:71:12: '>' ( TEXTCHAR )* '\"'
            {
            dbg.location(71,12);
            match(input,43,FOLLOW_43_in_posttext552); if (state.failed) return ;
            dbg.location(71,16);
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:71:16: ( TEXTCHAR )*
            try { dbg.enterSubRule(28);

            loop28:
            do {
                int alt28=2;
                try { dbg.enterDecision(28);

                int LA28_0 = input.LA(1);

                if ( (LA28_0==TEXTCHAR) ) {
                    alt28=1;
                }


                } finally {dbg.exitDecision(28);}

                switch (alt28) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: TEXTCHAR
            	    {
            	    dbg.location(71,16);
            	    match(input,TEXTCHAR,FOLLOW_TEXTCHAR_in_posttext554); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);
            } finally {dbg.exitSubRule(28);}

            dbg.location(71,26);
            match(input,41,FOLLOW_41_in_posttext557); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(71, 29);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "posttext");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "posttext"


    // $ANTLR start "midtext"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:72:1: midtext : '>' ( TEXTCHAR )* '<' ;
    public final void midtext() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "midtext");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(72, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:72:8: ( '>' ( TEXTCHAR )* '<' )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:72:11: '>' ( TEXTCHAR )* '<'
            {
            dbg.location(72,11);
            match(input,43,FOLLOW_43_in_midtext564); if (state.failed) return ;
            dbg.location(72,15);
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:72:15: ( TEXTCHAR )*
            try { dbg.enterSubRule(29);

            loop29:
            do {
                int alt29=2;
                try { dbg.enterDecision(29);

                int LA29_0 = input.LA(1);

                if ( (LA29_0==TEXTCHAR) ) {
                    alt29=1;
                }


                } finally {dbg.exitDecision(29);}

                switch (alt29) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: TEXTCHAR
            	    {
            	    dbg.location(72,15);
            	    match(input,TEXTCHAR,FOLLOW_TEXTCHAR_in_midtext566); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);
            } finally {dbg.exitSubRule(29);}

            dbg.location(72,25);
            match(input,42,FOLLOW_42_in_midtext569); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(72, 28);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "midtext");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "midtext"

    // $ANTLR start synpred19_Waebric
    public final void synpred19_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:45:47: ( 'else' statement )
        dbg.enterAlt(1);

        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:45:47: 'else' statement
        {
        dbg.location(45,47);
        match(input,30,FOLLOW_30_in_synpred19_Waebric284); if (state.failed) return ;
        dbg.location(45,54);
        pushFollow(FOLLOW_statement_in_synpred19_Waebric286);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_Waebric

    // $ANTLR start synpred31_Waebric
    public final void synpred31_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:55:4: ( markup )
        dbg.enterAlt(1);

        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:55:4: markup
        {
        dbg.location(55,4);
        pushFollow(FOLLOW_markup_in_synpred31_Waebric392);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_Waebric

    // $ANTLR start synpred32_Waebric
    public final void synpred32_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:55:4: ( ( markup )+ statement ';' )
        dbg.enterAlt(1);

        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:55:4: ( markup )+ statement ';'
        {
        dbg.location(55,4);
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:55:4: ( markup )+
        int cnt36=0;
        try { dbg.enterSubRule(36);

        loop36:
        do {
            int alt36=2;
            try { dbg.enterDecision(36);

            int LA36_0 = input.LA(1);

            if ( (LA36_0==IDCON) ) {
                int LA36_2 = input.LA(2);

                if ( (synpred31_Waebric()) ) {
                    alt36=1;
                }


            }


            } finally {dbg.exitDecision(36);}

            switch (alt36) {
        	case 1 :
        	    dbg.enterAlt(1);

        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
        	    {
        	    dbg.location(55,4);
        	    pushFollow(FOLLOW_markup_in_synpred32_Waebric392);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt36 >= 1 ) break loop36;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(36, input);
                    dbg.recognitionException(eee);

                    throw eee;
            }
            cnt36++;
        } while (true);
        } finally {dbg.exitSubRule(36);}

        dbg.location(55,12);
        pushFollow(FOLLOW_statement_in_synpred32_Waebric395);
        statement();

        state._fsp--;
        if (state.failed) return ;
        dbg.location(55,22);
        match(input,18,FOLLOW_18_in_synpred32_Waebric397); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_Waebric

    // $ANTLR start synpred34_Waebric
    public final void synpred34_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:56:4: ( ( markup )+ markup ';' )
        dbg.enterAlt(1);

        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:56:4: ( markup )+ markup ';'
        {
        dbg.location(56,4);
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:56:4: ( markup )+
        int cnt37=0;
        try { dbg.enterSubRule(37);

        loop37:
        do {
            int alt37=2;
            try { dbg.enterDecision(37);

            try {
                isCyclicDecision = true;
                alt37 = dfa37.predict(input);
            }
            catch (NoViableAltException nvae) {
                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(37);}

            switch (alt37) {
        	case 1 :
        	    dbg.enterAlt(1);

        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
        	    {
        	    dbg.location(56,4);
        	    pushFollow(FOLLOW_markup_in_synpred34_Waebric404);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt37 >= 1 ) break loop37;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(37, input);
                    dbg.recognitionException(eee);

                    throw eee;
            }
            cnt37++;
        } while (true);
        } finally {dbg.exitSubRule(37);}

        dbg.location(56,12);
        pushFollow(FOLLOW_markup_in_synpred34_Waebric407);
        markup();

        state._fsp--;
        if (state.failed) return ;
        dbg.location(56,19);
        match(input,18,FOLLOW_18_in_synpred34_Waebric409); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred34_Waebric

    // $ANTLR start synpred40_Waebric
    public final void synpred40_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:67:10: ( ( markup )* expression )
        dbg.enterAlt(1);

        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:67:10: ( markup )* expression
        {
        dbg.location(67,10);
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:67:10: ( markup )*
        try { dbg.enterSubRule(38);

        loop38:
        do {
            int alt38=2;
            try { dbg.enterDecision(38);

            int LA38_0 = input.LA(1);

            if ( (LA38_0==IDCON) ) {
                int LA38_1 = input.LA(2);

                if ( ((LA38_1>=IDCON && LA38_1<=NATCON)||LA38_1==16||LA38_1==21||(LA38_1>=24 && LA38_1<=27)) ) {
                    alt38=1;
                }


            }


            } finally {dbg.exitDecision(38);}

            switch (alt38) {
        	case 1 :
        	    dbg.enterAlt(1);

        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
        	    {
        	    dbg.location(67,10);
        	    pushFollow(FOLLOW_markup_in_synpred40_Waebric505);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop38;
            }
        } while (true);
        } finally {dbg.exitSubRule(38);}

        dbg.location(67,18);
        pushFollow(FOLLOW_expression_in_synpred40_Waebric508);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred40_Waebric

    // Delegated rules

    public final boolean synpred19_Waebric() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred19_Waebric_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        dbg.endBacktrack(state.backtracking, success);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_Waebric() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred34_Waebric_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        dbg.endBacktrack(state.backtracking, success);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_Waebric() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred31_Waebric_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        dbg.endBacktrack(state.backtracking, success);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_Waebric() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred32_Waebric_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        dbg.endBacktrack(state.backtracking, success);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred40_Waebric() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred40_Waebric_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        dbg.endBacktrack(state.backtracking, success);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA20 dfa20 = new DFA20(this);
    protected DFA18 dfa18 = new DFA18(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA26 dfa26 = new DFA26(this);
    protected DFA37 dfa37 = new DFA37(this);
    static final String DFA20_eotS =
        "\15\uffff";
    static final String DFA20_eofS =
        "\15\uffff";
    static final String DFA20_minS =
        "\1\4\7\uffff\1\20\4\uffff";
    static final String DFA20_maxS =
        "\1\46\7\uffff\1\33\4\uffff";
    static final String DFA20_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\10\1\11\1\12\1\13";
    static final String DFA20_specialS =
        "\10\uffff\1\0\4\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\10\30\uffff\1\1\1\uffff\1\2\1\3\1\uffff\1\4\1\uffff\1\5\1"+
            "\6\1\7",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\11\1\uffff\1\11\2\uffff\1\11\2\uffff\4\11",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "45:1: statement : ( 'if' '(' predicate ')' statement ( 'else' statement )? | 'each' '(' IDCON ':' expression ')' statement | 'let' ( assignment )+ 'in' ( statement )* 'end' | '{' ( statement )* '}' | 'echo' expression ';' | 'cdata' expression ';' | 'yield;' | markup ';' | ( markup )+ statement ';' | ( markup )+ markup ';' | ( markup )+ expression ';' );";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA20_8 = input.LA(1);

                         
                        int index20_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_8==16||LA20_8==18||LA20_8==21||(LA20_8>=24 && LA20_8<=27)) ) {s = 9;}

                        else if ( (synpred32_Waebric()) ) {s = 10;}

                        else if ( (synpred34_Waebric()) ) {s = 11;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index20_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 20, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA18_eotS =
        "\25\uffff";
    static final String DFA18_eofS =
        "\25\uffff";
    static final String DFA18_minS =
        "\6\4\1\5\1\4\2\uffff\5\4\1\26\2\4\1\5\1\26\1\4";
    static final String DFA18_maxS =
        "\1\4\1\33\4\4\1\5\1\27\2\uffff\4\33\1\34\1\27\1\5\1\22\1\5\1\27"+
        "\1\33";
    static final String DFA18_acceptS =
        "\10\uffff\1\2\1\1\13\uffff";
    static final String DFA18_specialS =
        "\25\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\1",
            "\1\11\13\uffff\1\3\1\uffff\1\10\2\uffff\1\7\2\uffff\1\2\1\4"+
            "\1\5\1\6",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15",
            "\1\16",
            "\2\17\20\uffff\1\20\1\21",
            "",
            "",
            "\1\11\13\uffff\1\3\1\uffff\1\10\2\uffff\1\7\2\uffff\1\2\1\4"+
            "\1\5\1\6",
            "\1\11\13\uffff\1\3\1\uffff\1\10\2\uffff\1\7\2\uffff\1\2\1\4"+
            "\1\5\1\6",
            "\1\11\13\uffff\1\3\1\uffff\1\10\2\uffff\1\7\2\uffff\1\2\1\4"+
            "\1\5\1\6",
            "\1\11\13\uffff\1\3\1\uffff\1\10\2\uffff\1\7\2\uffff\1\2\1\4"+
            "\1\5\1\6",
            "\1\11\13\uffff\1\3\1\uffff\1\10\2\uffff\1\7\2\uffff\1\2\1\4"+
            "\1\5\1\6\1\22",
            "\1\20\1\21",
            "\2\23",
            "\1\11\15\uffff\1\10",
            "\1\24",
            "\1\20\1\21",
            "\1\11\13\uffff\1\3\1\uffff\1\10\2\uffff\1\7\2\uffff\1\2\1\4"+
            "\1\5\1\6"
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "()+ loopback of 56:4: ( markup )+";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
    static final String DFA24_eotS =
        "\25\uffff";
    static final String DFA24_eofS =
        "\25\uffff";
    static final String DFA24_minS =
        "\6\4\1\5\1\4\2\uffff\5\4\1\26\2\4\1\5\1\26\1\4";
    static final String DFA24_maxS =
        "\1\4\1\53\4\4\1\5\1\27\2\uffff\5\53\1\27\1\5\1\53\1\5\1\27\1\53";
    static final String DFA24_acceptS =
        "\10\uffff\1\2\1\1\13\uffff";
    static final String DFA24_specialS =
        "\25\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\1",
            "\1\11\13\uffff\1\3\4\uffff\1\7\2\uffff\1\2\1\4\1\5\1\6\17\uffff"+
            "\1\10",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15",
            "\1\16",
            "\2\17\20\uffff\1\20\1\21",
            "",
            "",
            "\1\11\13\uffff\1\3\4\uffff\1\7\2\uffff\1\2\1\4\1\5\1\6\17\uffff"+
            "\1\10",
            "\1\11\13\uffff\1\3\4\uffff\1\7\2\uffff\1\2\1\4\1\5\1\6\17\uffff"+
            "\1\10",
            "\1\11\13\uffff\1\3\4\uffff\1\7\2\uffff\1\2\1\4\1\5\1\6\17\uffff"+
            "\1\10",
            "\1\11\13\uffff\1\3\4\uffff\1\7\2\uffff\1\2\1\4\1\5\1\6\17\uffff"+
            "\1\10",
            "\1\11\13\uffff\1\3\4\uffff\1\7\2\uffff\1\2\1\4\1\5\1\6\1\22"+
            "\16\uffff\1\10",
            "\1\20\1\21",
            "\2\23",
            "\1\11\46\uffff\1\10",
            "\1\24",
            "\1\20\1\21",
            "\1\11\13\uffff\1\3\4\uffff\1\7\2\uffff\1\2\1\4\1\5\1\6\17\uffff"+
            "\1\10"
    };

    static final short[] DFA24_eot = DFA.unpackEncodedString(DFA24_eotS);
    static final short[] DFA24_eof = DFA.unpackEncodedString(DFA24_eofS);
    static final char[] DFA24_min = DFA.unpackEncodedStringToUnsignedChars(DFA24_minS);
    static final char[] DFA24_max = DFA.unpackEncodedStringToUnsignedChars(DFA24_maxS);
    static final short[] DFA24_accept = DFA.unpackEncodedString(DFA24_acceptS);
    static final short[] DFA24_special = DFA.unpackEncodedString(DFA24_specialS);
    static final short[][] DFA24_transition;

    static {
        int numStates = DFA24_transitionS.length;
        DFA24_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA24_transition[i] = DFA.unpackEncodedString(DFA24_transitionS[i]);
        }
    }

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = DFA24_eot;
            this.eof = DFA24_eof;
            this.min = DFA24_min;
            this.max = DFA24_max;
            this.accept = DFA24_accept;
            this.special = DFA24_special;
            this.transition = DFA24_transition;
        }
        public String getDescription() {
            return "()* loopback of 68:4: ( markup )*";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
    static final String DFA26_eotS =
        "\5\uffff";
    static final String DFA26_eofS =
        "\5\uffff";
    static final String DFA26_minS =
        "\1\53\2\7\2\uffff";
    static final String DFA26_maxS =
        "\1\53\2\52\2\uffff";
    static final String DFA26_acceptS =
        "\3\uffff\1\1\1\2";
    static final String DFA26_specialS =
        "\5\uffff}>";
    static final String[] DFA26_transitionS = {
            "\1\1",
            "\1\2\41\uffff\1\3\1\4",
            "\1\2\41\uffff\1\3\1\4",
            "",
            ""
    };

    static final short[] DFA26_eot = DFA.unpackEncodedString(DFA26_eotS);
    static final short[] DFA26_eof = DFA.unpackEncodedString(DFA26_eofS);
    static final char[] DFA26_min = DFA.unpackEncodedStringToUnsignedChars(DFA26_minS);
    static final char[] DFA26_max = DFA.unpackEncodedStringToUnsignedChars(DFA26_maxS);
    static final short[] DFA26_accept = DFA.unpackEncodedString(DFA26_acceptS);
    static final short[] DFA26_special = DFA.unpackEncodedString(DFA26_specialS);
    static final short[][] DFA26_transition;

    static {
        int numStates = DFA26_transitionS.length;
        DFA26_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA26_transition[i] = DFA.unpackEncodedString(DFA26_transitionS[i]);
        }
    }

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = DFA26_eot;
            this.eof = DFA26_eof;
            this.min = DFA26_min;
            this.max = DFA26_max;
            this.accept = DFA26_accept;
            this.special = DFA26_special;
            this.transition = DFA26_transition;
        }
        public String getDescription() {
            return "69:1: texttail : ( posttext | midtext embed texttail );";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
    static final String DFA37_eotS =
        "\25\uffff";
    static final String DFA37_eofS =
        "\25\uffff";
    static final String DFA37_minS =
        "\6\4\1\5\1\4\2\uffff\5\4\1\26\2\4\1\5\1\26\1\4";
    static final String DFA37_maxS =
        "\1\4\1\33\4\4\1\5\1\27\2\uffff\4\33\1\34\1\27\1\5\1\22\1\5\1\27"+
        "\1\33";
    static final String DFA37_acceptS =
        "\10\uffff\1\2\1\1\13\uffff";
    static final String DFA37_specialS =
        "\25\uffff}>";
    static final String[] DFA37_transitionS = {
            "\1\1",
            "\1\11\13\uffff\1\3\1\uffff\1\10\2\uffff\1\7\2\uffff\1\2\1\4"+
            "\1\5\1\6",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15",
            "\1\16",
            "\2\17\20\uffff\1\20\1\21",
            "",
            "",
            "\1\11\13\uffff\1\3\1\uffff\1\10\2\uffff\1\7\2\uffff\1\2\1\4"+
            "\1\5\1\6",
            "\1\11\13\uffff\1\3\1\uffff\1\10\2\uffff\1\7\2\uffff\1\2\1\4"+
            "\1\5\1\6",
            "\1\11\13\uffff\1\3\1\uffff\1\10\2\uffff\1\7\2\uffff\1\2\1\4"+
            "\1\5\1\6",
            "\1\11\13\uffff\1\3\1\uffff\1\10\2\uffff\1\7\2\uffff\1\2\1\4"+
            "\1\5\1\6",
            "\1\11\13\uffff\1\3\1\uffff\1\10\2\uffff\1\7\2\uffff\1\2\1\4"+
            "\1\5\1\6\1\22",
            "\1\20\1\21",
            "\2\23",
            "\1\11\15\uffff\1\10",
            "\1\24",
            "\1\20\1\21",
            "\1\11\13\uffff\1\3\1\uffff\1\10\2\uffff\1\7\2\uffff\1\2\1\4"+
            "\1\5\1\6"
    };

    static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
    static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
    static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
    static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
    static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
    static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
    static final short[][] DFA37_transition;

    static {
        int numStates = DFA37_transitionS.length;
        DFA37_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
        }
    }

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = DFA37_eot;
            this.eof = DFA37_eof;
            this.min = DFA37_min;
            this.max = DFA37_max;
            this.accept = DFA37_accept;
            this.special = DFA37_special;
            this.transition = DFA37_transition;
        }
        public String getDescription() {
            return "()+ loopback of 56:4: ( markup )+";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
 

    public static final BitSet FOLLOW_14_in_module27 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_moduleId_in_module29 = new BitSet(new long[]{0x00000000001A8000L});
    public static final BitSet FOLLOW_moduleElement_in_module31 = new BitSet(new long[]{0x00000000001A8000L});
    public static final BitSet FOLLOW_15_in_module34 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_moduleId41 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_moduleId45 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_moduleId47 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_imprt_in_moduleElement57 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_site_in_moduleElement61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_moduleElement65 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_imprt74 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_moduleId_in_imprt76 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_imprt78 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_site86 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_site90 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_function97 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_function99 = new BitSet(new long[]{0x00000075A0208010L});
    public static final BitSet FOLLOW_formals_in_function101 = new BitSet(new long[]{0x00000075A0008010L});
    public static final BitSet FOLLOW_statement_in_function103 = new BitSet(new long[]{0x00000075A0008010L});
    public static final BitSet FOLLOW_15_in_function106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_formals113 = new BitSet(new long[]{0x0000000000C00010L});
    public static final BitSet FOLLOW_IDCON_in_formals115 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_22_in_formals120 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_formals122 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_23_in_formals127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_designator_in_markup143 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_arguments_in_markup145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_designator153 = new BitSet(new long[]{0x000000000F010002L});
    public static final BitSet FOLLOW_attribute_in_designator155 = new BitSet(new long[]{0x000000000F010002L});
    public static final BitSet FOLLOW_24_in_attribute163 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_attribute173 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_attribute183 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_attribute193 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_attribute203 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NATCON_in_attribute205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_attribute213 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NATCON_in_attribute215 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_attribute217 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NATCON_in_attribute219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_arguments227 = new BitSet(new long[]{0x0000000000C00030L});
    public static final BitSet FOLLOW_argument_in_arguments229 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_22_in_arguments234 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_argument_in_arguments236 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_23_in_arguments242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_argument250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_expression0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_statement273 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_statement275 = new BitSet(new long[]{0x0000010000000030L});
    public static final BitSet FOLLOW_predicate_in_statement277 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_statement279 = new BitSet(new long[]{0x00000075A0000010L});
    public static final BitSet FOLLOW_statement_in_statement281 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_statement284 = new BitSet(new long[]{0x00000075A0000010L});
    public static final BitSet FOLLOW_statement_in_statement286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_statement296 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_statement298 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_statement300 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_statement302 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_expression_in_statement304 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_statement306 = new BitSet(new long[]{0x00000075A0000010L});
    public static final BitSet FOLLOW_statement_in_statement308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_statement316 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_assignment_in_statement318 = new BitSet(new long[]{0x0000000200000010L});
    public static final BitSet FOLLOW_33_in_statement321 = new BitSet(new long[]{0x00000075A0008010L});
    public static final BitSet FOLLOW_statement_in_statement323 = new BitSet(new long[]{0x00000075A0008010L});
    public static final BitSet FOLLOW_15_in_statement326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_statement333 = new BitSet(new long[]{0x0000007DA0000010L});
    public static final BitSet FOLLOW_statement_in_statement335 = new BitSet(new long[]{0x0000007DA0000010L});
    public static final BitSet FOLLOW_35_in_statement338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_statement349 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_expression_in_statement351 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_statement353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_statement364 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_expression_in_statement366 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_statement368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_statement376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement383 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_statement385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement392 = new BitSet(new long[]{0x00000075A0000010L});
    public static final BitSet FOLLOW_statement_in_statement395 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_statement397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement404 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_statement407 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_statement409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement416 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_expression_in_statement419 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_statement421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_assignment429 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_assignment431 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_expression_in_assignment433 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_assignment435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_assignment443 = new BitSet(new long[]{0x00000075A0200010L});
    public static final BitSet FOLLOW_formals_in_assignment445 = new BitSet(new long[]{0x00000075A0000010L});
    public static final BitSet FOLLOW_statement_in_assignment447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate464 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_predicate466 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TYPE_in_predicate468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_predicate472 = new BitSet(new long[]{0x0000010000000030L});
    public static final BitSet FOLLOW_predicate_in_predicate474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pretext_in_embedding492 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_embed_in_embedding494 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_texttail_in_embedding496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed505 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_expression_in_embed508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed515 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_embed518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_posttext_in_texttail525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_midtext_in_texttail529 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_embed_in_texttail531 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_texttail_in_texttail533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_pretext540 = new BitSet(new long[]{0x0000040000000080L});
    public static final BitSet FOLLOW_TEXTCHAR_in_pretext542 = new BitSet(new long[]{0x0000040000000080L});
    public static final BitSet FOLLOW_42_in_pretext545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_posttext552 = new BitSet(new long[]{0x0000020000000080L});
    public static final BitSet FOLLOW_TEXTCHAR_in_posttext554 = new BitSet(new long[]{0x0000020000000080L});
    public static final BitSet FOLLOW_41_in_posttext557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_midtext564 = new BitSet(new long[]{0x0000040000000080L});
    public static final BitSet FOLLOW_TEXTCHAR_in_midtext566 = new BitSet(new long[]{0x0000040000000080L});
    public static final BitSet FOLLOW_42_in_midtext569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_synpred19_Waebric284 = new BitSet(new long[]{0x00000075A0000010L});
    public static final BitSet FOLLOW_statement_in_synpred19_Waebric286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred31_Waebric392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred32_Waebric392 = new BitSet(new long[]{0x00000075A0000010L});
    public static final BitSet FOLLOW_statement_in_synpred32_Waebric395 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_synpred32_Waebric397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred34_Waebric404 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_synpred34_Waebric407 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_synpred34_Waebric409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred40_Waebric505 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_expression_in_synpred40_Waebric508 = new BitSet(new long[]{0x0000000000000002L});

}