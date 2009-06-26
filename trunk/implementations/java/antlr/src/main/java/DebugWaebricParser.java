// $ANTLR 3.1.2 /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g 2009-06-26 15:10:13

import org.antlr.runtime.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.antlr.runtime.debug.*;
import java.io.IOException;
public class DebugWaebricParser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDCON", "NATCON", "TYPE", "WHITESPACE", "'module'", "'end'", "'.'", "'import'", "';'", "'#'", "'$'", "':'", "'@'", "'%'", "'('", "','", "')'", "'def'", "'if'", "'else'", "'each'", "'let'", "'in'", "'{'", "'}'", "'echo'", "'cdata'", "'yield;'", "'='", "'!'"
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
    public static final int WHITESPACE=7;
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int T__8=8;
    public static final int NATCON=5;
    public static final int TYPE=6;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
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
        "invalidRule", "synpred15_DebugWaebric", "synpred31_DebugWaebric", 
        "function", "synpred37_DebugWaebric", "synpred4_DebugWaebric", "synpred19_DebugWaebric", 
        "synpred22_DebugWaebric", "synpred2_DebugWaebric", "synpred17_DebugWaebric", 
        "synpred27_DebugWaebric", "synpred6_DebugWaebric", "synpred33_DebugWaebric", 
        "synpred3_DebugWaebric", "synpred13_DebugWaebric", "synpred7_DebugWaebric", 
        "synpred26_DebugWaebric", "synpred12_DebugWaebric", "synpred35_DebugWaebric", 
        "synpred24_DebugWaebric", "synpred16_DebugWaebric", "attribute", 
        "synpred5_DebugWaebric", "synpred36_DebugWaebric", "synpred21_DebugWaebric", 
        "synpred23_DebugWaebric", "moduleIdentifier", "assignment", "module", 
        "moduleElement", "predicate", "synpred8_DebugWaebric", "synpred32_DebugWaebric", 
        "synpred10_DebugWaebric", "synpred28_DebugWaebric", "synpred11_DebugWaebric", 
        "synpred18_DebugWaebric", "synpred1_DebugWaebric", "synpred20_DebugWaebric", 
        "expression", "moduleImport", "designator", "synpred14_DebugWaebric", 
        "synpred30_DebugWaebric", "synpred34_DebugWaebric", "statement", 
        "argument", "synpred29_DebugWaebric", "arguments", "synpred9_DebugWaebric", 
        "markup", "synpred25_DebugWaebric", "formals"
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:25:1: module : 'module' moduleIdentifier ( moduleElement )* 'end' ;
    public final void module() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "module");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(25, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:25:7: ( 'module' moduleIdentifier ( moduleElement )* 'end' )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:25:12: 'module' moduleIdentifier ( moduleElement )* 'end'
            {
            dbg.location(25,12);
            match(input,8,FOLLOW_8_in_module39); if (state.failed) return ;
            dbg.location(25,21);
            pushFollow(FOLLOW_moduleIdentifier_in_module41);
            moduleIdentifier();

            state._fsp--;
            if (state.failed) return ;
            dbg.location(25,38);
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:25:38: ( moduleElement )*
            try { dbg.enterSubRule(1);

            loop1:
            do {
                int alt1=2;
                try { dbg.enterDecision(1);

                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==21) ) {
                    alt1=1;
                }


                } finally {dbg.exitDecision(1);}

                switch (alt1) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: moduleElement
            	    {
            	    dbg.location(25,38);
            	    pushFollow(FOLLOW_moduleElement_in_module43);
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

            dbg.location(25,53);
            match(input,9,FOLLOW_9_in_module46); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(25, 58);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "module");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "module"


    // $ANTLR start "moduleIdentifier"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:26:1: moduleIdentifier : IDCON ( '.' IDCON )* ;
    public final void moduleIdentifier() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "moduleIdentifier");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(26, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:26:17: ( IDCON ( '.' IDCON )* )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:26:19: IDCON ( '.' IDCON )*
            {
            dbg.location(26,19);
            match(input,IDCON,FOLLOW_IDCON_in_moduleIdentifier52); if (state.failed) return ;
            dbg.location(26,25);
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:26:25: ( '.' IDCON )*
            try { dbg.enterSubRule(2);

            loop2:
            do {
                int alt2=2;
                try { dbg.enterDecision(2);

                int LA2_0 = input.LA(1);

                if ( (LA2_0==10) ) {
                    alt2=1;
                }


                } finally {dbg.exitDecision(2);}

                switch (alt2) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:26:27: '.' IDCON
            	    {
            	    dbg.location(26,27);
            	    match(input,10,FOLLOW_10_in_moduleIdentifier56); if (state.failed) return ;
            	    dbg.location(26,31);
            	    match(input,IDCON,FOLLOW_IDCON_in_moduleIdentifier58); if (state.failed) return ;

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
        dbg.location(26, 39);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "moduleIdentifier");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "moduleIdentifier"


    // $ANTLR start "moduleElement"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:27:1: moduleElement : ( moduleImport | function );
    public final void moduleElement() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "moduleElement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(27, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:27:14: ( moduleImport | function )
            int alt3=2;
            try { dbg.enterDecision(3);

            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            else if ( (LA3_0==21) ) {
                alt3=2;
            }
            else {
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

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:27:17: moduleImport
                    {
                    dbg.location(27,17);
                    pushFollow(FOLLOW_moduleImport_in_moduleElement68);
                    moduleImport();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:27:32: function
                    {
                    dbg.location(27,32);
                    pushFollow(FOLLOW_function_in_moduleElement72);
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
        dbg.location(27, 40);

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:28:1: moduleImport : 'import' moduleIdentifier ';' ;
    public final void moduleImport() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "moduleImport");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(28, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:28:13: ( 'import' moduleIdentifier ';' )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:28:16: 'import' moduleIdentifier ';'
            {
            dbg.location(28,16);
            match(input,11,FOLLOW_11_in_moduleImport79); if (state.failed) return ;
            dbg.location(28,25);
            pushFollow(FOLLOW_moduleIdentifier_in_moduleImport81);
            moduleIdentifier();

            state._fsp--;
            if (state.failed) return ;
            dbg.location(28,42);
            match(input,12,FOLLOW_12_in_moduleImport83); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(28, 45);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "moduleImport");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "moduleImport"


    // $ANTLR start "markup"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:30:1: markup : designator ( arguments )? ;
    public final void markup() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "markup");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(30, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:41:7: ( designator ( arguments )? )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:41:11: designator ( arguments )?
            {
            dbg.location(41,11);
            pushFollow(FOLLOW_designator_in_markup96);
            designator();

            state._fsp--;
            if (state.failed) return ;
            dbg.location(41,22);
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:41:22: ( arguments )?
            int alt4=2;
            try { dbg.enterSubRule(4);
            try { dbg.enterDecision(4);

            int LA4_0 = input.LA(1);

            if ( (LA4_0==18) ) {
                alt4=1;
            }
            } finally {dbg.exitDecision(4);}

            switch (alt4) {
                case 1 :
                    dbg.enterAlt(1);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: arguments
                    {
                    dbg.location(41,22);
                    pushFollow(FOLLOW_arguments_in_markup98);
                    arguments();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
            } finally {dbg.exitSubRule(4);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(41, 32);

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:42:1: designator : IDCON ( attribute )* ;
    public final void designator() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "designator");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(42, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:42:11: ( IDCON ( attribute )* )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:42:14: IDCON ( attribute )*
            {
            dbg.location(42,14);
            match(input,IDCON,FOLLOW_IDCON_in_designator106); if (state.failed) return ;
            dbg.location(42,20);
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:42:20: ( attribute )*
            try { dbg.enterSubRule(5);

            loop5:
            do {
                int alt5=2;
                try { dbg.enterDecision(5);

                int LA5_0 = input.LA(1);

                if ( (LA5_0==10||(LA5_0>=13 && LA5_0<=16)) ) {
                    alt5=1;
                }


                } finally {dbg.exitDecision(5);}

                switch (alt5) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: attribute
            	    {
            	    dbg.location(42,20);
            	    pushFollow(FOLLOW_attribute_in_designator108);
            	    attribute();

            	    state._fsp--;
            	    if (state.failed) return ;

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
        dbg.location(42, 30);

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:43:1: attribute : ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON );
    public final void attribute() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "attribute");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(43, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:43:10: ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON )
            int alt6=6;
            try { dbg.enterDecision(6);

            switch ( input.LA(1) ) {
            case 13:
                {
                alt6=1;
                }
                break;
            case 10:
                {
                alt6=2;
                }
                break;
            case 14:
                {
                alt6=3;
                }
                break;
            case 15:
                {
                alt6=4;
                }
                break;
            case 16:
                {
                int LA6_5 = input.LA(2);

                if ( (LA6_5==NATCON) ) {
                    int LA6_6 = input.LA(3);

                    if ( (LA6_6==17) ) {
                        alt6=6;
                    }
                    else if ( (LA6_6==EOF||(LA6_6>=IDCON && LA6_6<=NATCON)||LA6_6==10||(LA6_6>=12 && LA6_6<=16)||LA6_6==18||LA6_6==22||(LA6_6>=24 && LA6_6<=25)||LA6_6==27||(LA6_6>=29 && LA6_6<=31)) ) {
                        alt6=5;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 6, input);

                        dbg.recognitionException(nvae);
                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 5, input);

                    dbg.recognitionException(nvae);
                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }

            } finally {dbg.exitDecision(6);}

            switch (alt6) {
                case 1 :
                    dbg.enterAlt(1);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:43:13: '#' IDCON
                    {
                    dbg.location(43,13);
                    match(input,13,FOLLOW_13_in_attribute116); if (state.failed) return ;
                    dbg.location(43,17);
                    match(input,IDCON,FOLLOW_IDCON_in_attribute118); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:44:4: '.' IDCON
                    {
                    dbg.location(44,4);
                    match(input,10,FOLLOW_10_in_attribute126); if (state.failed) return ;
                    dbg.location(44,8);
                    match(input,IDCON,FOLLOW_IDCON_in_attribute128); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:45:4: '$' IDCON
                    {
                    dbg.location(45,4);
                    match(input,14,FOLLOW_14_in_attribute136); if (state.failed) return ;
                    dbg.location(45,8);
                    match(input,IDCON,FOLLOW_IDCON_in_attribute138); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:46:4: ':' IDCON
                    {
                    dbg.location(46,4);
                    match(input,15,FOLLOW_15_in_attribute146); if (state.failed) return ;
                    dbg.location(46,8);
                    match(input,IDCON,FOLLOW_IDCON_in_attribute148); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:47:4: '@' NATCON
                    {
                    dbg.location(47,4);
                    match(input,16,FOLLOW_16_in_attribute156); if (state.failed) return ;
                    dbg.location(47,8);
                    match(input,NATCON,FOLLOW_NATCON_in_attribute158); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    dbg.enterAlt(6);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:48:4: '@' NATCON '%' NATCON
                    {
                    dbg.location(48,4);
                    match(input,16,FOLLOW_16_in_attribute166); if (state.failed) return ;
                    dbg.location(48,8);
                    match(input,NATCON,FOLLOW_NATCON_in_attribute168); if (state.failed) return ;
                    dbg.location(48,15);
                    match(input,17,FOLLOW_17_in_attribute170); if (state.failed) return ;
                    dbg.location(48,19);
                    match(input,NATCON,FOLLOW_NATCON_in_attribute172); if (state.failed) return ;

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
        dbg.location(48, 25);

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:49:1: arguments : ( '(' ( argument )? ( ',' argument )* ')' ) ;
    public final void arguments() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "arguments");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(49, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:49:10: ( ( '(' ( argument )? ( ',' argument )* ')' ) )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:49:13: ( '(' ( argument )? ( ',' argument )* ')' )
            {
            dbg.location(49,13);
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:49:13: ( '(' ( argument )? ( ',' argument )* ')' )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:49:14: '(' ( argument )? ( ',' argument )* ')'
            {
            dbg.location(49,14);
            match(input,18,FOLLOW_18_in_arguments180); if (state.failed) return ;
            dbg.location(49,18);
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:49:18: ( argument )?
            int alt7=2;
            try { dbg.enterSubRule(7);
            try { dbg.enterDecision(7);

            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=IDCON && LA7_0<=NATCON)) ) {
                alt7=1;
            }
            } finally {dbg.exitDecision(7);}

            switch (alt7) {
                case 1 :
                    dbg.enterAlt(1);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: argument
                    {
                    dbg.location(49,18);
                    pushFollow(FOLLOW_argument_in_arguments182);
                    argument();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
            } finally {dbg.exitSubRule(7);}

            dbg.location(49,28);
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:49:28: ( ',' argument )*
            try { dbg.enterSubRule(8);

            loop8:
            do {
                int alt8=2;
                try { dbg.enterDecision(8);

                int LA8_0 = input.LA(1);

                if ( (LA8_0==19) ) {
                    alt8=1;
                }


                } finally {dbg.exitDecision(8);}

                switch (alt8) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:49:30: ',' argument
            	    {
            	    dbg.location(49,30);
            	    match(input,19,FOLLOW_19_in_arguments187); if (state.failed) return ;
            	    dbg.location(49,34);
            	    pushFollow(FOLLOW_argument_in_arguments189);
            	    argument();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);
            } finally {dbg.exitSubRule(8);}

            dbg.location(49,47);
            match(input,20,FOLLOW_20_in_arguments195); if (state.failed) return ;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(49, 51);

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:50:1: argument : expression ;
    public final void argument() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "argument");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(50, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:50:9: ( expression )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:50:12: expression
            {
            dbg.location(50,12);
            pushFollow(FOLLOW_expression_in_argument203);
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
        dbg.location(50, 22);

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:53:1: expression : ( IDCON | NATCON );
    public final void expression() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(53, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:53:11: ( IDCON | NATCON )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:
            {
            dbg.location(53,11);
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
        dbg.location(53, 28);

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:56:1: function : 'def' IDCON formals ( statement )* 'end' ;
    public final void function() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "function");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(56, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:56:9: ( 'def' IDCON formals ( statement )* 'end' )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:56:12: 'def' IDCON formals ( statement )* 'end'
            {
            dbg.location(56,12);
            match(input,21,FOLLOW_21_in_function226); if (state.failed) return ;
            dbg.location(56,18);
            match(input,IDCON,FOLLOW_IDCON_in_function228); if (state.failed) return ;
            dbg.location(56,24);
            pushFollow(FOLLOW_formals_in_function230);
            formals();

            state._fsp--;
            if (state.failed) return ;
            dbg.location(56,32);
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:56:32: ( statement )*
            try { dbg.enterSubRule(9);

            loop9:
            do {
                int alt9=2;
                try { dbg.enterDecision(9);

                int LA9_0 = input.LA(1);

                if ( (LA9_0==IDCON||LA9_0==22||(LA9_0>=24 && LA9_0<=25)||LA9_0==27||(LA9_0>=29 && LA9_0<=31)) ) {
                    alt9=1;
                }


                } finally {dbg.exitDecision(9);}

                switch (alt9) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: statement
            	    {
            	    dbg.location(56,32);
            	    pushFollow(FOLLOW_statement_in_function232);
            	    statement();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);
            } finally {dbg.exitSubRule(9);}

            dbg.location(56,43);
            match(input,9,FOLLOW_9_in_function235); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(56, 48);

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:57:1: formals : ( '(' ( IDCON )? ( ',' IDCON )* ')' | );
    public final void formals() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "formals");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(57, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:57:8: ( '(' ( IDCON )? ( ',' IDCON )* ')' | )
            int alt12=2;
            try { dbg.enterDecision(12);

            int LA12_0 = input.LA(1);

            if ( (LA12_0==18) ) {
                alt12=1;
            }
            else if ( (LA12_0==IDCON||LA12_0==9||LA12_0==22||(LA12_0>=24 && LA12_0<=25)||LA12_0==27||(LA12_0>=29 && LA12_0<=31)) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(12);}

            switch (alt12) {
                case 1 :
                    dbg.enterAlt(1);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:57:11: '(' ( IDCON )? ( ',' IDCON )* ')'
                    {
                    dbg.location(57,11);
                    match(input,18,FOLLOW_18_in_formals242); if (state.failed) return ;
                    dbg.location(57,15);
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:57:15: ( IDCON )?
                    int alt10=2;
                    try { dbg.enterSubRule(10);
                    try { dbg.enterDecision(10);

                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==IDCON) ) {
                        alt10=1;
                    }
                    } finally {dbg.exitDecision(10);}

                    switch (alt10) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: IDCON
                            {
                            dbg.location(57,15);
                            match(input,IDCON,FOLLOW_IDCON_in_formals244); if (state.failed) return ;

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(10);}

                    dbg.location(57,22);
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:57:22: ( ',' IDCON )*
                    try { dbg.enterSubRule(11);

                    loop11:
                    do {
                        int alt11=2;
                        try { dbg.enterDecision(11);

                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==19) ) {
                            alt11=1;
                        }


                        } finally {dbg.exitDecision(11);}

                        switch (alt11) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:57:24: ',' IDCON
                    	    {
                    	    dbg.location(57,24);
                    	    match(input,19,FOLLOW_19_in_formals249); if (state.failed) return ;
                    	    dbg.location(57,28);
                    	    match(input,IDCON,FOLLOW_IDCON_in_formals251); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(11);}

                    dbg.location(57,37);
                    match(input,20,FOLLOW_20_in_formals256); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:57:43: 
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
        dbg.location(57, 43);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "formals");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "formals"


    // $ANTLR start "statement"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:60:1: statement : ( 'if' '(' predicate ')' statement ( 'else' statement )? | 'each' '(' IDCON ':' expression ')' statement | 'let' ( assignment )+ 'in' ( statement )* 'end' | '{' ( statement )* '}' | 'echo' expression ';' | 'cdata' expression ';' | 'yield;' | markup ';' | ( markup )+ statement ';' | ( markup )+ markup ';' | ( markup )+ expression ';' );
    public final void statement() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(60, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:60:10: ( 'if' '(' predicate ')' statement ( 'else' statement )? | 'each' '(' IDCON ':' expression ')' statement | 'let' ( assignment )+ 'in' ( statement )* 'end' | '{' ( statement )* '}' | 'echo' expression ';' | 'cdata' expression ';' | 'yield;' | markup ';' | ( markup )+ statement ';' | ( markup )+ markup ';' | ( markup )+ expression ';' )
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

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:60:13: 'if' '(' predicate ')' statement ( 'else' statement )?
                    {
                    dbg.location(60,13);
                    match(input,22,FOLLOW_22_in_statement268); if (state.failed) return ;
                    dbg.location(60,18);
                    match(input,18,FOLLOW_18_in_statement270); if (state.failed) return ;
                    dbg.location(60,22);
                    pushFollow(FOLLOW_predicate_in_statement272);
                    predicate();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(60,32);
                    match(input,20,FOLLOW_20_in_statement274); if (state.failed) return ;
                    dbg.location(60,36);
                    pushFollow(FOLLOW_statement_in_statement276);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(60,46);
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:60:46: ( 'else' statement )?
                    int alt13=2;
                    try { dbg.enterSubRule(13);
                    try { dbg.enterDecision(13);

                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==23) ) {
                        int LA13_1 = input.LA(2);

                        if ( (synpred18_DebugWaebric()) ) {
                            alt13=1;
                        }
                    }
                    } finally {dbg.exitDecision(13);}

                    switch (alt13) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:60:47: 'else' statement
                            {
                            dbg.location(60,47);
                            match(input,23,FOLLOW_23_in_statement279); if (state.failed) return ;
                            dbg.location(60,54);
                            pushFollow(FOLLOW_statement_in_statement281);
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

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:61:4: 'each' '(' IDCON ':' expression ')' statement
                    {
                    dbg.location(61,4);
                    match(input,24,FOLLOW_24_in_statement291); if (state.failed) return ;
                    dbg.location(61,11);
                    match(input,18,FOLLOW_18_in_statement293); if (state.failed) return ;
                    dbg.location(61,15);
                    match(input,IDCON,FOLLOW_IDCON_in_statement295); if (state.failed) return ;
                    dbg.location(61,21);
                    match(input,15,FOLLOW_15_in_statement297); if (state.failed) return ;
                    dbg.location(61,25);
                    pushFollow(FOLLOW_expression_in_statement299);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(61,36);
                    match(input,20,FOLLOW_20_in_statement301); if (state.failed) return ;
                    dbg.location(61,40);
                    pushFollow(FOLLOW_statement_in_statement303);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:62:4: 'let' ( assignment )+ 'in' ( statement )* 'end'
                    {
                    dbg.location(62,4);
                    match(input,25,FOLLOW_25_in_statement311); if (state.failed) return ;
                    dbg.location(62,10);
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:62:10: ( assignment )+
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

                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: assignment
                    	    {
                    	    dbg.location(62,10);
                    	    pushFollow(FOLLOW_assignment_in_statement313);
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

                    dbg.location(62,22);
                    match(input,26,FOLLOW_26_in_statement316); if (state.failed) return ;
                    dbg.location(62,27);
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:62:27: ( statement )*
                    try { dbg.enterSubRule(15);

                    loop15:
                    do {
                        int alt15=2;
                        try { dbg.enterDecision(15);

                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==IDCON||LA15_0==22||(LA15_0>=24 && LA15_0<=25)||LA15_0==27||(LA15_0>=29 && LA15_0<=31)) ) {
                            alt15=1;
                        }


                        } finally {dbg.exitDecision(15);}

                        switch (alt15) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: statement
                    	    {
                    	    dbg.location(62,27);
                    	    pushFollow(FOLLOW_statement_in_statement318);
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

                    dbg.location(62,38);
                    match(input,9,FOLLOW_9_in_statement321); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:63:4: '{' ( statement )* '}'
                    {
                    dbg.location(63,4);
                    match(input,27,FOLLOW_27_in_statement328); if (state.failed) return ;
                    dbg.location(63,8);
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:63:8: ( statement )*
                    try { dbg.enterSubRule(16);

                    loop16:
                    do {
                        int alt16=2;
                        try { dbg.enterDecision(16);

                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==IDCON||LA16_0==22||(LA16_0>=24 && LA16_0<=25)||LA16_0==27||(LA16_0>=29 && LA16_0<=31)) ) {
                            alt16=1;
                        }


                        } finally {dbg.exitDecision(16);}

                        switch (alt16) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: statement
                    	    {
                    	    dbg.location(63,8);
                    	    pushFollow(FOLLOW_statement_in_statement330);
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

                    dbg.location(63,19);
                    match(input,28,FOLLOW_28_in_statement333); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:65:4: 'echo' expression ';'
                    {
                    dbg.location(65,4);
                    match(input,29,FOLLOW_29_in_statement344); if (state.failed) return ;
                    dbg.location(65,11);
                    pushFollow(FOLLOW_expression_in_statement346);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(65,22);
                    match(input,12,FOLLOW_12_in_statement348); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    dbg.enterAlt(6);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:67:4: 'cdata' expression ';'
                    {
                    dbg.location(67,4);
                    match(input,30,FOLLOW_30_in_statement359); if (state.failed) return ;
                    dbg.location(67,12);
                    pushFollow(FOLLOW_expression_in_statement361);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(67,23);
                    match(input,12,FOLLOW_12_in_statement363); if (state.failed) return ;

                    }
                    break;
                case 7 :
                    dbg.enterAlt(7);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:68:4: 'yield;'
                    {
                    dbg.location(68,4);
                    match(input,31,FOLLOW_31_in_statement371); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    dbg.enterAlt(8);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:69:4: markup ';'
                    {
                    dbg.location(69,4);
                    pushFollow(FOLLOW_markup_in_statement378);
                    markup();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(69,11);
                    match(input,12,FOLLOW_12_in_statement380); if (state.failed) return ;

                    }
                    break;
                case 9 :
                    dbg.enterAlt(9);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:70:4: ( markup )+ statement ';'
                    {
                    dbg.location(70,4);
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:70:4: ( markup )+
                    int cnt17=0;
                    try { dbg.enterSubRule(17);

                    loop17:
                    do {
                        int alt17=2;
                        try { dbg.enterDecision(17);

                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==IDCON) ) {
                            int LA17_2 = input.LA(2);

                            if ( (synpred30_DebugWaebric()) ) {
                                alt17=1;
                            }


                        }


                        } finally {dbg.exitDecision(17);}

                        switch (alt17) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: markup
                    	    {
                    	    dbg.location(70,4);
                    	    pushFollow(FOLLOW_markup_in_statement387);
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

                    dbg.location(70,12);
                    pushFollow(FOLLOW_statement_in_statement390);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(70,22);
                    match(input,12,FOLLOW_12_in_statement392); if (state.failed) return ;

                    }
                    break;
                case 10 :
                    dbg.enterAlt(10);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:71:4: ( markup )+ markup ';'
                    {
                    dbg.location(71,4);
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:71:4: ( markup )+
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

                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: markup
                    	    {
                    	    dbg.location(71,4);
                    	    pushFollow(FOLLOW_markup_in_statement399);
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

                    dbg.location(71,12);
                    pushFollow(FOLLOW_markup_in_statement402);
                    markup();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(71,19);
                    match(input,12,FOLLOW_12_in_statement404); if (state.failed) return ;

                    }
                    break;
                case 11 :
                    dbg.enterAlt(11);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:72:4: ( markup )+ expression ';'
                    {
                    dbg.location(72,4);
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:72:4: ( markup )+
                    int cnt19=0;
                    try { dbg.enterSubRule(19);

                    loop19:
                    do {
                        int alt19=2;
                        try { dbg.enterDecision(19);

                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==IDCON) ) {
                            int LA19_1 = input.LA(2);

                            if ( ((LA19_1>=IDCON && LA19_1<=NATCON)||LA19_1==10||(LA19_1>=13 && LA19_1<=16)||LA19_1==18) ) {
                                alt19=1;
                            }


                        }


                        } finally {dbg.exitDecision(19);}

                        switch (alt19) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: markup
                    	    {
                    	    dbg.location(72,4);
                    	    pushFollow(FOLLOW_markup_in_statement411);
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

                    dbg.location(72,12);
                    pushFollow(FOLLOW_expression_in_statement414);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(72,23);
                    match(input,12,FOLLOW_12_in_statement416); if (state.failed) return ;

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
        dbg.location(72, 27);

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:73:1: assignment : ( IDCON '=' expression ';' | IDCON formals statement );
    public final void assignment() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "assignment");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(73, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:73:11: ( IDCON '=' expression ';' | IDCON formals statement )
            int alt21=2;
            try { dbg.enterDecision(21);

            int LA21_0 = input.LA(1);

            if ( (LA21_0==IDCON) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==32) ) {
                    alt21=1;
                }
                else if ( (LA21_1==IDCON||LA21_1==18||LA21_1==22||(LA21_1>=24 && LA21_1<=25)||LA21_1==27||(LA21_1>=29 && LA21_1<=31)) ) {
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

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:73:14: IDCON '=' expression ';'
                    {
                    dbg.location(73,14);
                    match(input,IDCON,FOLLOW_IDCON_in_assignment424); if (state.failed) return ;
                    dbg.location(73,20);
                    match(input,32,FOLLOW_32_in_assignment426); if (state.failed) return ;
                    dbg.location(73,24);
                    pushFollow(FOLLOW_expression_in_assignment428);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(73,35);
                    match(input,12,FOLLOW_12_in_assignment430); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:74:4: IDCON formals statement
                    {
                    dbg.location(74,4);
                    match(input,IDCON,FOLLOW_IDCON_in_assignment438); if (state.failed) return ;
                    dbg.location(74,10);
                    pushFollow(FOLLOW_formals_in_assignment440);
                    formals();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(74,18);
                    pushFollow(FOLLOW_statement_in_assignment442);
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
        dbg.location(74, 27);

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:77:1: predicate : ( expression | expression '.' TYPE | '!' predicate );
    public final void predicate() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "predicate");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(77, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:77:10: ( expression | expression '.' TYPE | '!' predicate )
            int alt22=3;
            try { dbg.enterDecision(22);

            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=IDCON && LA22_0<=NATCON)) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==20) ) {
                    alt22=1;
                }
                else if ( (LA22_1==10) ) {
                    alt22=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 1, input);

                    dbg.recognitionException(nvae);
                    throw nvae;
                }
            }
            else if ( (LA22_0==33) ) {
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

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:77:13: expression
                    {
                    dbg.location(77,13);
                    pushFollow(FOLLOW_expression_in_predicate455);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:77:26: expression '.' TYPE
                    {
                    dbg.location(77,26);
                    pushFollow(FOLLOW_expression_in_predicate459);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(77,37);
                    match(input,10,FOLLOW_10_in_predicate461); if (state.failed) return ;
                    dbg.location(77,41);
                    match(input,TYPE,FOLLOW_TYPE_in_predicate463); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:77:48: '!' predicate
                    {
                    dbg.location(77,48);
                    match(input,33,FOLLOW_33_in_predicate467); if (state.failed) return ;
                    dbg.location(77,52);
                    pushFollow(FOLLOW_predicate_in_predicate469);
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
        dbg.location(77, 62);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "predicate");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "predicate"

    // $ANTLR start synpred18_DebugWaebric
    public final void synpred18_DebugWaebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:60:47: ( 'else' statement )
        dbg.enterAlt(1);

        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:60:47: 'else' statement
        {
        dbg.location(60,47);
        match(input,23,FOLLOW_23_in_synpred18_DebugWaebric279); if (state.failed) return ;
        dbg.location(60,54);
        pushFollow(FOLLOW_statement_in_synpred18_DebugWaebric281);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_DebugWaebric

    // $ANTLR start synpred30_DebugWaebric
    public final void synpred30_DebugWaebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:70:4: ( markup )
        dbg.enterAlt(1);

        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:70:4: markup
        {
        dbg.location(70,4);
        pushFollow(FOLLOW_markup_in_synpred30_DebugWaebric387);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_DebugWaebric

    // $ANTLR start synpred31_DebugWaebric
    public final void synpred31_DebugWaebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:70:4: ( ( markup )+ statement ';' )
        dbg.enterAlt(1);

        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:70:4: ( markup )+ statement ';'
        {
        dbg.location(70,4);
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:70:4: ( markup )+
        int cnt29=0;
        try { dbg.enterSubRule(29);

        loop29:
        do {
            int alt29=2;
            try { dbg.enterDecision(29);

            int LA29_0 = input.LA(1);

            if ( (LA29_0==IDCON) ) {
                int LA29_2 = input.LA(2);

                if ( (synpred30_DebugWaebric()) ) {
                    alt29=1;
                }


            }


            } finally {dbg.exitDecision(29);}

            switch (alt29) {
        	case 1 :
        	    dbg.enterAlt(1);

        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: markup
        	    {
        	    dbg.location(70,4);
        	    pushFollow(FOLLOW_markup_in_synpred31_DebugWaebric387);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt29 >= 1 ) break loop29;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(29, input);
                    dbg.recognitionException(eee);

                    throw eee;
            }
            cnt29++;
        } while (true);
        } finally {dbg.exitSubRule(29);}

        dbg.location(70,12);
        pushFollow(FOLLOW_statement_in_synpred31_DebugWaebric390);
        statement();

        state._fsp--;
        if (state.failed) return ;
        dbg.location(70,22);
        match(input,12,FOLLOW_12_in_synpred31_DebugWaebric392); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_DebugWaebric

    // $ANTLR start synpred33_DebugWaebric
    public final void synpred33_DebugWaebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:71:4: ( ( markup )+ markup ';' )
        dbg.enterAlt(1);

        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:71:4: ( markup )+ markup ';'
        {
        dbg.location(71,4);
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:71:4: ( markup )+
        int cnt30=0;
        try { dbg.enterSubRule(30);

        loop30:
        do {
            int alt30=2;
            try { dbg.enterDecision(30);

            try {
                isCyclicDecision = true;
                alt30 = dfa30.predict(input);
            }
            catch (NoViableAltException nvae) {
                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(30);}

            switch (alt30) {
        	case 1 :
        	    dbg.enterAlt(1);

        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: markup
        	    {
        	    dbg.location(71,4);
        	    pushFollow(FOLLOW_markup_in_synpred33_DebugWaebric399);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt30 >= 1 ) break loop30;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(30, input);
                    dbg.recognitionException(eee);

                    throw eee;
            }
            cnt30++;
        } while (true);
        } finally {dbg.exitSubRule(30);}

        dbg.location(71,12);
        pushFollow(FOLLOW_markup_in_synpred33_DebugWaebric402);
        markup();

        state._fsp--;
        if (state.failed) return ;
        dbg.location(71,19);
        match(input,12,FOLLOW_12_in_synpred33_DebugWaebric404); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred33_DebugWaebric

    // Delegated rules

    public final boolean synpred33_DebugWaebric() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred33_DebugWaebric_fragment(); // can never throw exception
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
    public final boolean synpred18_DebugWaebric() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred18_DebugWaebric_fragment(); // can never throw exception
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
    public final boolean synpred31_DebugWaebric() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred31_DebugWaebric_fragment(); // can never throw exception
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
    public final boolean synpred30_DebugWaebric() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred30_DebugWaebric_fragment(); // can never throw exception
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
    protected DFA30 dfa30 = new DFA30(this);
    static final String DFA20_eotS =
        "\15\uffff";
    static final String DFA20_eofS =
        "\15\uffff";
    static final String DFA20_minS =
        "\1\4\7\uffff\1\12\4\uffff";
    static final String DFA20_maxS =
        "\1\37\7\uffff\1\22\4\uffff";
    static final String DFA20_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\10\1\11\1\12\1\13";
    static final String DFA20_specialS =
        "\10\uffff\1\0\4\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\10\21\uffff\1\1\1\uffff\1\2\1\3\1\uffff\1\4\1\uffff\1\5\1"+
            "\6\1\7",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\11\1\uffff\5\11\1\uffff\1\11",
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
            return "60:1: statement : ( 'if' '(' predicate ')' statement ( 'else' statement )? | 'each' '(' IDCON ':' expression ')' statement | 'let' ( assignment )+ 'in' ( statement )* 'end' | '{' ( statement )* '}' | 'echo' expression ';' | 'cdata' expression ';' | 'yield;' | markup ';' | ( markup )+ statement ';' | ( markup )+ markup ';' | ( markup )+ expression ';' );";
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
                        if ( (LA20_8==10||(LA20_8>=12 && LA20_8<=16)||LA20_8==18) ) {s = 9;}

                        else if ( (synpred31_DebugWaebric()) ) {s = 10;}

                        else if ( (synpred33_DebugWaebric()) ) {s = 11;}

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
        "\6\4\1\5\1\4\2\uffff\5\4\1\23\2\4\1\5\1\23\1\4";
    static final String DFA18_maxS =
        "\1\4\1\22\4\4\1\5\1\24\2\uffff\5\22\1\24\1\5\1\14\1\5\1\24\1\22";
    static final String DFA18_acceptS =
        "\10\uffff\1\2\1\1\13\uffff";
    static final String DFA18_specialS =
        "\25\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\1",
            "\1\11\5\uffff\1\3\1\uffff\1\10\1\2\1\4\1\5\1\6\1\uffff\1\7",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15",
            "\1\16",
            "\2\17\15\uffff\1\20\1\21",
            "",
            "",
            "\1\11\5\uffff\1\3\1\uffff\1\10\1\2\1\4\1\5\1\6\1\uffff\1\7",
            "\1\11\5\uffff\1\3\1\uffff\1\10\1\2\1\4\1\5\1\6\1\uffff\1\7",
            "\1\11\5\uffff\1\3\1\uffff\1\10\1\2\1\4\1\5\1\6\1\uffff\1\7",
            "\1\11\5\uffff\1\3\1\uffff\1\10\1\2\1\4\1\5\1\6\1\uffff\1\7",
            "\1\11\5\uffff\1\3\1\uffff\1\10\1\2\1\4\1\5\1\6\1\22\1\7",
            "\1\20\1\21",
            "\2\23",
            "\1\11\7\uffff\1\10",
            "\1\24",
            "\1\20\1\21",
            "\1\11\5\uffff\1\3\1\uffff\1\10\1\2\1\4\1\5\1\6\1\uffff\1\7"
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
            return "()+ loopback of 71:4: ( markup )+";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
    static final String DFA30_eotS =
        "\25\uffff";
    static final String DFA30_eofS =
        "\25\uffff";
    static final String DFA30_minS =
        "\6\4\1\5\1\4\2\uffff\5\4\1\23\2\4\1\5\1\23\1\4";
    static final String DFA30_maxS =
        "\1\4\1\22\4\4\1\5\1\24\2\uffff\5\22\1\24\1\5\1\14\1\5\1\24\1\22";
    static final String DFA30_acceptS =
        "\10\uffff\1\2\1\1\13\uffff";
    static final String DFA30_specialS =
        "\25\uffff}>";
    static final String[] DFA30_transitionS = {
            "\1\1",
            "\1\11\5\uffff\1\3\1\uffff\1\10\1\2\1\4\1\5\1\6\1\uffff\1\7",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15",
            "\1\16",
            "\2\17\15\uffff\1\20\1\21",
            "",
            "",
            "\1\11\5\uffff\1\3\1\uffff\1\10\1\2\1\4\1\5\1\6\1\uffff\1\7",
            "\1\11\5\uffff\1\3\1\uffff\1\10\1\2\1\4\1\5\1\6\1\uffff\1\7",
            "\1\11\5\uffff\1\3\1\uffff\1\10\1\2\1\4\1\5\1\6\1\uffff\1\7",
            "\1\11\5\uffff\1\3\1\uffff\1\10\1\2\1\4\1\5\1\6\1\uffff\1\7",
            "\1\11\5\uffff\1\3\1\uffff\1\10\1\2\1\4\1\5\1\6\1\22\1\7",
            "\1\20\1\21",
            "\2\23",
            "\1\11\7\uffff\1\10",
            "\1\24",
            "\1\20\1\21",
            "\1\11\5\uffff\1\3\1\uffff\1\10\1\2\1\4\1\5\1\6\1\uffff\1\7"
    };

    static final short[] DFA30_eot = DFA.unpackEncodedString(DFA30_eotS);
    static final short[] DFA30_eof = DFA.unpackEncodedString(DFA30_eofS);
    static final char[] DFA30_min = DFA.unpackEncodedStringToUnsignedChars(DFA30_minS);
    static final char[] DFA30_max = DFA.unpackEncodedStringToUnsignedChars(DFA30_maxS);
    static final short[] DFA30_accept = DFA.unpackEncodedString(DFA30_acceptS);
    static final short[] DFA30_special = DFA.unpackEncodedString(DFA30_specialS);
    static final short[][] DFA30_transition;

    static {
        int numStates = DFA30_transitionS.length;
        DFA30_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA30_transition[i] = DFA.unpackEncodedString(DFA30_transitionS[i]);
        }
    }

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = DFA30_eot;
            this.eof = DFA30_eof;
            this.min = DFA30_min;
            this.max = DFA30_max;
            this.accept = DFA30_accept;
            this.special = DFA30_special;
            this.transition = DFA30_transition;
        }
        public String getDescription() {
            return "()+ loopback of 71:4: ( markup )+";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
 

    public static final BitSet FOLLOW_8_in_module39 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_moduleIdentifier_in_module41 = new BitSet(new long[]{0x0000000000200A00L});
    public static final BitSet FOLLOW_moduleElement_in_module43 = new BitSet(new long[]{0x0000000000200A00L});
    public static final BitSet FOLLOW_9_in_module46 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_moduleIdentifier52 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_10_in_moduleIdentifier56 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_moduleIdentifier58 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_moduleImport_in_moduleElement68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_moduleElement72 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_moduleImport79 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_moduleIdentifier_in_moduleImport81 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_moduleImport83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_designator_in_markup96 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_arguments_in_markup98 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_designator106 = new BitSet(new long[]{0x000000000001E402L});
    public static final BitSet FOLLOW_attribute_in_designator108 = new BitSet(new long[]{0x000000000001E402L});
    public static final BitSet FOLLOW_13_in_attribute116 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_attribute126 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_attribute136 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_attribute146 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_attribute156 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NATCON_in_attribute158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_attribute166 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NATCON_in_attribute168 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_attribute170 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NATCON_in_attribute172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_arguments180 = new BitSet(new long[]{0x0000000000180030L});
    public static final BitSet FOLLOW_argument_in_arguments182 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_19_in_arguments187 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_argument_in_arguments189 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_20_in_arguments195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_argument203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_expression0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_function226 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_function228 = new BitSet(new long[]{0x00000000EB440210L});
    public static final BitSet FOLLOW_formals_in_function230 = new BitSet(new long[]{0x00000000EB400210L});
    public static final BitSet FOLLOW_statement_in_function232 = new BitSet(new long[]{0x00000000EB400210L});
    public static final BitSet FOLLOW_9_in_function235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_formals242 = new BitSet(new long[]{0x0000000000180010L});
    public static final BitSet FOLLOW_IDCON_in_formals244 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_19_in_formals249 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_formals251 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_20_in_formals256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_statement268 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_statement270 = new BitSet(new long[]{0x0000000200000030L});
    public static final BitSet FOLLOW_predicate_in_statement272 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_statement274 = new BitSet(new long[]{0x00000000EB400010L});
    public static final BitSet FOLLOW_statement_in_statement276 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_statement279 = new BitSet(new long[]{0x00000000EB400010L});
    public static final BitSet FOLLOW_statement_in_statement281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_statement291 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_statement293 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_statement295 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_statement297 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_expression_in_statement299 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_statement301 = new BitSet(new long[]{0x00000000EB400010L});
    public static final BitSet FOLLOW_statement_in_statement303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_statement311 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_assignment_in_statement313 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_26_in_statement316 = new BitSet(new long[]{0x00000000EB400210L});
    public static final BitSet FOLLOW_statement_in_statement318 = new BitSet(new long[]{0x00000000EB400210L});
    public static final BitSet FOLLOW_9_in_statement321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_statement328 = new BitSet(new long[]{0x00000000FB400010L});
    public static final BitSet FOLLOW_statement_in_statement330 = new BitSet(new long[]{0x00000000FB400010L});
    public static final BitSet FOLLOW_28_in_statement333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_statement344 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_expression_in_statement346 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_statement348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_statement359 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_expression_in_statement361 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_statement363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_statement371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement378 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_statement380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement387 = new BitSet(new long[]{0x00000000EB400010L});
    public static final BitSet FOLLOW_statement_in_statement390 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_statement392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement399 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_statement402 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_statement404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement411 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_expression_in_statement414 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_statement416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_assignment424 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_assignment426 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_expression_in_assignment428 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_assignment430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_assignment438 = new BitSet(new long[]{0x00000000EB440010L});
    public static final BitSet FOLLOW_formals_in_assignment440 = new BitSet(new long[]{0x00000000EB400010L});
    public static final BitSet FOLLOW_statement_in_assignment442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate459 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_predicate461 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TYPE_in_predicate463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_predicate467 = new BitSet(new long[]{0x0000000200000030L});
    public static final BitSet FOLLOW_predicate_in_predicate469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_synpred18_DebugWaebric279 = new BitSet(new long[]{0x00000000EB400010L});
    public static final BitSet FOLLOW_statement_in_synpred18_DebugWaebric281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred30_DebugWaebric387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred31_DebugWaebric387 = new BitSet(new long[]{0x00000000EB400010L});
    public static final BitSet FOLLOW_statement_in_synpred31_DebugWaebric390 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_synpred31_DebugWaebric392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred33_DebugWaebric399 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_synpred33_DebugWaebric402 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_synpred33_DebugWaebric404 = new BitSet(new long[]{0x0000000000000002L});

}