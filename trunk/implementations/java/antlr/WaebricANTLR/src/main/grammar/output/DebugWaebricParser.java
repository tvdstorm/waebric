// $ANTLR 3.1.2 /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g 2009-06-26 14:09:17

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDCON", "NATCON", "WHITESPACE", "'module'", "'end'", "'.'", "'import'", "';'", "'#'", "'$'", "':'", "'@'", "'%'", "'('", "','", "')'", "'def'", "'if'", "'else'", "'each'", "'{'", "'}'", "'yield;'"
    };
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int WHITESPACE=6;
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int T__8=8;
    public static final int T__7=7;
    public static final int NATCON=5;
    public static final int T__19=19;
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
        "invalidRule", "synpred3_DebugWaebric", "statement", "synpred8_DebugWaebric", 
        "synpred4_DebugWaebric", "function", "argument", "synpred5_DebugWaebric", 
        "synpred12_DebugWaebric", "synpred7_DebugWaebric", "synpred9_DebugWaebric", 
        "synpred26_DebugWaebric", "synpred18_DebugWaebric", "synpred15_DebugWaebric", 
        "synpred24_DebugWaebric", "expression", "synpred17_DebugWaebric", 
        "synpred21_DebugWaebric", "moduleImport", "synpred16_DebugWaebric", 
        "predicate", "moduleIdentifier", "synpred10_DebugWaebric", "arguments", 
        "module", "synpred1_DebugWaebric", "synpred22_DebugWaebric", "synpred19_DebugWaebric", 
        "synpred11_DebugWaebric", "synpred23_DebugWaebric", "markup", "synpred20_DebugWaebric", 
        "synpred14_DebugWaebric", "synpred13_DebugWaebric", "attribute", 
        "synpred6_DebugWaebric", "synpred2_DebugWaebric", "moduleElement", 
        "synpred25_DebugWaebric", "formals", "designator"
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
            match(input,7,FOLLOW_7_in_module39); if (state.failed) return ;
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

                if ( (LA1_0==10||LA1_0==20) ) {
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
            match(input,8,FOLLOW_8_in_module46); if (state.failed) return ;

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

                if ( (LA2_0==9) ) {
                    alt2=1;
                }


                } finally {dbg.exitDecision(2);}

                switch (alt2) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:26:27: '.' IDCON
            	    {
            	    dbg.location(26,27);
            	    match(input,9,FOLLOW_9_in_moduleIdentifier56); if (state.failed) return ;
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

            if ( (LA3_0==10) ) {
                alt3=1;
            }
            else if ( (LA3_0==20) ) {
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
            match(input,10,FOLLOW_10_in_moduleImport79); if (state.failed) return ;
            dbg.location(28,25);
            pushFollow(FOLLOW_moduleIdentifier_in_moduleImport81);
            moduleIdentifier();

            state._fsp--;
            if (state.failed) return ;
            dbg.location(28,42);
            match(input,11,FOLLOW_11_in_moduleImport83); if (state.failed) return ;

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:30:1: markup : ( designator arguments )=> designator ;
    public final void markup() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "markup");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(30, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:41:7: ( ( designator arguments )=> designator )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:41:11: ( designator arguments )=> designator
            {
            dbg.location(41,37);
            pushFollow(FOLLOW_designator_in_markup104);
            designator();

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
        dbg.location(41, 47);

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
            match(input,IDCON,FOLLOW_IDCON_in_designator111); if (state.failed) return ;
            dbg.location(42,20);
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:42:20: ( attribute )*
            try { dbg.enterSubRule(4);

            loop4:
            do {
                int alt4=2;
                try { dbg.enterDecision(4);

                int LA4_0 = input.LA(1);

                if ( (LA4_0==9||(LA4_0>=12 && LA4_0<=15)) ) {
                    alt4=1;
                }


                } finally {dbg.exitDecision(4);}

                switch (alt4) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: attribute
            	    {
            	    dbg.location(42,20);
            	    pushFollow(FOLLOW_attribute_in_designator113);
            	    attribute();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);
            } finally {dbg.exitSubRule(4);}


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
            int alt5=6;
            try { dbg.enterDecision(5);

            switch ( input.LA(1) ) {
            case 12:
                {
                alt5=1;
                }
                break;
            case 9:
                {
                alt5=2;
                }
                break;
            case 13:
                {
                alt5=3;
                }
                break;
            case 14:
                {
                alt5=4;
                }
                break;
            case 15:
                {
                int LA5_5 = input.LA(2);

                if ( (LA5_5==NATCON) ) {
                    int LA5_6 = input.LA(3);

                    if ( (LA5_6==16) ) {
                        alt5=6;
                    }
                    else if ( (LA5_6==EOF||(LA5_6>=IDCON && LA5_6<=NATCON)||LA5_6==9||(LA5_6>=11 && LA5_6<=15)||LA5_6==17||LA5_6==21||(LA5_6>=23 && LA5_6<=24)||LA5_6==26) ) {
                        alt5=5;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 6, input);

                        dbg.recognitionException(nvae);
                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 5, input);

                    dbg.recognitionException(nvae);
                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }

            } finally {dbg.exitDecision(5);}

            switch (alt5) {
                case 1 :
                    dbg.enterAlt(1);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:43:13: '#' IDCON
                    {
                    dbg.location(43,13);
                    match(input,12,FOLLOW_12_in_attribute121); if (state.failed) return ;
                    dbg.location(43,17);
                    match(input,IDCON,FOLLOW_IDCON_in_attribute123); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:43:25: '.' IDCON
                    {
                    dbg.location(43,25);
                    match(input,9,FOLLOW_9_in_attribute127); if (state.failed) return ;
                    dbg.location(43,29);
                    match(input,IDCON,FOLLOW_IDCON_in_attribute129); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:43:37: '$' IDCON
                    {
                    dbg.location(43,37);
                    match(input,13,FOLLOW_13_in_attribute133); if (state.failed) return ;
                    dbg.location(43,41);
                    match(input,IDCON,FOLLOW_IDCON_in_attribute135); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:43:49: ':' IDCON
                    {
                    dbg.location(43,49);
                    match(input,14,FOLLOW_14_in_attribute139); if (state.failed) return ;
                    dbg.location(43,53);
                    match(input,IDCON,FOLLOW_IDCON_in_attribute141); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:44:6: '@' NATCON
                    {
                    dbg.location(44,6);
                    match(input,15,FOLLOW_15_in_attribute148); if (state.failed) return ;
                    dbg.location(44,10);
                    match(input,NATCON,FOLLOW_NATCON_in_attribute150); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    dbg.enterAlt(6);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:44:19: '@' NATCON '%' NATCON
                    {
                    dbg.location(44,19);
                    match(input,15,FOLLOW_15_in_attribute154); if (state.failed) return ;
                    dbg.location(44,23);
                    match(input,NATCON,FOLLOW_NATCON_in_attribute156); if (state.failed) return ;
                    dbg.location(44,30);
                    match(input,16,FOLLOW_16_in_attribute158); if (state.failed) return ;
                    dbg.location(44,34);
                    match(input,NATCON,FOLLOW_NATCON_in_attribute160); if (state.failed) return ;

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
        dbg.location(44, 40);

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:45:1: arguments : '(' argument ( ',' argument )* ')' ;
    public final void arguments() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "arguments");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(45, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:45:10: ( '(' argument ( ',' argument )* ')' )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:45:13: '(' argument ( ',' argument )* ')'
            {
            dbg.location(45,13);
            match(input,17,FOLLOW_17_in_arguments167); if (state.failed) return ;
            dbg.location(45,17);
            pushFollow(FOLLOW_argument_in_arguments169);
            argument();

            state._fsp--;
            if (state.failed) return ;
            dbg.location(45,26);
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:45:26: ( ',' argument )*
            try { dbg.enterSubRule(6);

            loop6:
            do {
                int alt6=2;
                try { dbg.enterDecision(6);

                int LA6_0 = input.LA(1);

                if ( (LA6_0==18) ) {
                    alt6=1;
                }


                } finally {dbg.exitDecision(6);}

                switch (alt6) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:45:28: ',' argument
            	    {
            	    dbg.location(45,28);
            	    match(input,18,FOLLOW_18_in_arguments173); if (state.failed) return ;
            	    dbg.location(45,32);
            	    pushFollow(FOLLOW_argument_in_arguments175);
            	    argument();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);
            } finally {dbg.exitSubRule(6);}

            dbg.location(45,45);
            match(input,19,FOLLOW_19_in_arguments181); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(45, 48);

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:46:1: argument : expression ;
    public final void argument() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "argument");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(46, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:46:9: ( expression )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:46:12: expression
            {
            dbg.location(46,12);
            pushFollow(FOLLOW_expression_in_argument188);
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
        dbg.location(46, 22);

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:49:1: expression : ( IDCON | NATCON );
    public final void expression() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(49, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:49:11: ( IDCON | NATCON )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:
            {
            dbg.location(49,11);
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
        dbg.location(49, 28);

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:52:1: function : 'def' IDCON formals ( statement )* 'end' ;
    public final void function() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "function");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(52, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:52:9: ( 'def' IDCON formals ( statement )* 'end' )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:52:12: 'def' IDCON formals ( statement )* 'end'
            {
            dbg.location(52,12);
            match(input,20,FOLLOW_20_in_function211); if (state.failed) return ;
            dbg.location(52,18);
            match(input,IDCON,FOLLOW_IDCON_in_function213); if (state.failed) return ;
            dbg.location(52,24);
            pushFollow(FOLLOW_formals_in_function215);
            formals();

            state._fsp--;
            if (state.failed) return ;
            dbg.location(52,32);
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:52:32: ( statement )*
            try { dbg.enterSubRule(7);

            loop7:
            do {
                int alt7=2;
                try { dbg.enterDecision(7);

                int LA7_0 = input.LA(1);

                if ( (LA7_0==IDCON||LA7_0==21||(LA7_0>=23 && LA7_0<=24)||LA7_0==26) ) {
                    alt7=1;
                }


                } finally {dbg.exitDecision(7);}

                switch (alt7) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: statement
            	    {
            	    dbg.location(52,32);
            	    pushFollow(FOLLOW_statement_in_function217);
            	    statement();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);
            } finally {dbg.exitSubRule(7);}

            dbg.location(52,43);
            match(input,8,FOLLOW_8_in_function220); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(52, 48);

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:53:1: formals : '(' IDCON ( ',' IDCON )* ')' ;
    public final void formals() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "formals");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(53, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:53:8: ( '(' IDCON ( ',' IDCON )* ')' )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:53:11: '(' IDCON ( ',' IDCON )* ')'
            {
            dbg.location(53,11);
            match(input,17,FOLLOW_17_in_formals227); if (state.failed) return ;
            dbg.location(53,15);
            match(input,IDCON,FOLLOW_IDCON_in_formals229); if (state.failed) return ;
            dbg.location(53,21);
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:53:21: ( ',' IDCON )*
            try { dbg.enterSubRule(8);

            loop8:
            do {
                int alt8=2;
                try { dbg.enterDecision(8);

                int LA8_0 = input.LA(1);

                if ( (LA8_0==18) ) {
                    alt8=1;
                }


                } finally {dbg.exitDecision(8);}

                switch (alt8) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:53:23: ',' IDCON
            	    {
            	    dbg.location(53,23);
            	    match(input,18,FOLLOW_18_in_formals233); if (state.failed) return ;
            	    dbg.location(53,27);
            	    match(input,IDCON,FOLLOW_IDCON_in_formals235); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);
            } finally {dbg.exitSubRule(8);}

            dbg.location(53,36);
            match(input,19,FOLLOW_19_in_formals240); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(53, 39);

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:56:1: statement : ( 'if' '(' predicate ')' statement ( 'else' statement )? | 'each' '(' IDCON ':' expression ')' statement | '{' ( statement )* '}' | 'yield;' | markup ';' | ( markup )+ statement ';' | ( markup )+ markup ';' | ( markup )+ expression ';' );
    public final void statement() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(56, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:56:10: ( 'if' '(' predicate ')' statement ( 'else' statement )? | 'each' '(' IDCON ':' expression ')' statement | '{' ( statement )* '}' | 'yield;' | markup ';' | ( markup )+ statement ';' | ( markup )+ markup ';' | ( markup )+ expression ';' )
            int alt14=8;
            try { dbg.enterDecision(14);

            try {
                isCyclicDecision = true;
                alt14 = dfa14.predict(input);
            }
            catch (NoViableAltException nvae) {
                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(14);}

            switch (alt14) {
                case 1 :
                    dbg.enterAlt(1);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:56:13: 'if' '(' predicate ')' statement ( 'else' statement )?
                    {
                    dbg.location(56,13);
                    match(input,21,FOLLOW_21_in_statement249); if (state.failed) return ;
                    dbg.location(56,18);
                    match(input,17,FOLLOW_17_in_statement251); if (state.failed) return ;
                    dbg.location(56,22);
                    pushFollow(FOLLOW_predicate_in_statement253);
                    predicate();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(56,32);
                    match(input,19,FOLLOW_19_in_statement255); if (state.failed) return ;
                    dbg.location(56,36);
                    pushFollow(FOLLOW_statement_in_statement257);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(56,46);
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:56:46: ( 'else' statement )?
                    int alt9=2;
                    try { dbg.enterSubRule(9);
                    try { dbg.enterDecision(9);

                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==22) ) {
                        int LA9_1 = input.LA(2);

                        if ( (synpred15_DebugWaebric()) ) {
                            alt9=1;
                        }
                    }
                    } finally {dbg.exitDecision(9);}

                    switch (alt9) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:56:47: 'else' statement
                            {
                            dbg.location(56,47);
                            match(input,22,FOLLOW_22_in_statement260); if (state.failed) return ;
                            dbg.location(56,54);
                            pushFollow(FOLLOW_statement_in_statement262);
                            statement();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(9);}


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:57:4: 'each' '(' IDCON ':' expression ')' statement
                    {
                    dbg.location(57,4);
                    match(input,23,FOLLOW_23_in_statement272); if (state.failed) return ;
                    dbg.location(57,11);
                    match(input,17,FOLLOW_17_in_statement274); if (state.failed) return ;
                    dbg.location(57,15);
                    match(input,IDCON,FOLLOW_IDCON_in_statement276); if (state.failed) return ;
                    dbg.location(57,21);
                    match(input,14,FOLLOW_14_in_statement278); if (state.failed) return ;
                    dbg.location(57,25);
                    pushFollow(FOLLOW_expression_in_statement280);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(57,36);
                    match(input,19,FOLLOW_19_in_statement282); if (state.failed) return ;
                    dbg.location(57,40);
                    pushFollow(FOLLOW_statement_in_statement284);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:58:4: '{' ( statement )* '}'
                    {
                    dbg.location(58,4);
                    match(input,24,FOLLOW_24_in_statement292); if (state.failed) return ;
                    dbg.location(58,8);
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:58:8: ( statement )*
                    try { dbg.enterSubRule(10);

                    loop10:
                    do {
                        int alt10=2;
                        try { dbg.enterDecision(10);

                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==IDCON||LA10_0==21||(LA10_0>=23 && LA10_0<=24)||LA10_0==26) ) {
                            alt10=1;
                        }


                        } finally {dbg.exitDecision(10);}

                        switch (alt10) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: statement
                    	    {
                    	    dbg.location(58,8);
                    	    pushFollow(FOLLOW_statement_in_statement294);
                    	    statement();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(10);}

                    dbg.location(58,19);
                    match(input,25,FOLLOW_25_in_statement297); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:59:4: 'yield;'
                    {
                    dbg.location(59,4);
                    match(input,26,FOLLOW_26_in_statement305); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:60:4: markup ';'
                    {
                    dbg.location(60,4);
                    pushFollow(FOLLOW_markup_in_statement312);
                    markup();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(60,11);
                    match(input,11,FOLLOW_11_in_statement314); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    dbg.enterAlt(6);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:61:4: ( markup )+ statement ';'
                    {
                    dbg.location(61,4);
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:61:4: ( markup )+
                    int cnt11=0;
                    try { dbg.enterSubRule(11);

                    loop11:
                    do {
                        int alt11=2;
                        try { dbg.enterDecision(11);

                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==IDCON) ) {
                            int LA11_2 = input.LA(2);

                            if ( (synpred22_DebugWaebric()) ) {
                                alt11=1;
                            }


                        }


                        } finally {dbg.exitDecision(11);}

                        switch (alt11) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: markup
                    	    {
                    	    dbg.location(61,4);
                    	    pushFollow(FOLLOW_markup_in_statement322);
                    	    markup();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt11 >= 1 ) break loop11;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(11, input);
                                dbg.recognitionException(eee);

                                throw eee;
                        }
                        cnt11++;
                    } while (true);
                    } finally {dbg.exitSubRule(11);}

                    dbg.location(61,12);
                    pushFollow(FOLLOW_statement_in_statement325);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(61,22);
                    match(input,11,FOLLOW_11_in_statement327); if (state.failed) return ;

                    }
                    break;
                case 7 :
                    dbg.enterAlt(7);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:62:4: ( markup )+ markup ';'
                    {
                    dbg.location(62,4);
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:62:4: ( markup )+
                    int cnt12=0;
                    try { dbg.enterSubRule(12);

                    loop12:
                    do {
                        int alt12=2;
                        try { dbg.enterDecision(12);

                        try {
                            isCyclicDecision = true;
                            alt12 = dfa12.predict(input);
                        }
                        catch (NoViableAltException nvae) {
                            dbg.recognitionException(nvae);
                            throw nvae;
                        }
                        } finally {dbg.exitDecision(12);}

                        switch (alt12) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: markup
                    	    {
                    	    dbg.location(62,4);
                    	    pushFollow(FOLLOW_markup_in_statement335);
                    	    markup();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt12 >= 1 ) break loop12;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                dbg.recognitionException(eee);

                                throw eee;
                        }
                        cnt12++;
                    } while (true);
                    } finally {dbg.exitSubRule(12);}

                    dbg.location(62,12);
                    pushFollow(FOLLOW_markup_in_statement338);
                    markup();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(62,19);
                    match(input,11,FOLLOW_11_in_statement340); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    dbg.enterAlt(8);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:63:4: ( markup )+ expression ';'
                    {
                    dbg.location(63,4);
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:63:4: ( markup )+
                    int cnt13=0;
                    try { dbg.enterSubRule(13);

                    loop13:
                    do {
                        int alt13=2;
                        try { dbg.enterDecision(13);

                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==IDCON) ) {
                            int LA13_1 = input.LA(2);

                            if ( ((LA13_1>=IDCON && LA13_1<=NATCON)||LA13_1==9||(LA13_1>=12 && LA13_1<=15)) ) {
                                alt13=1;
                            }


                        }


                        } finally {dbg.exitDecision(13);}

                        switch (alt13) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: markup
                    	    {
                    	    dbg.location(63,4);
                    	    pushFollow(FOLLOW_markup_in_statement348);
                    	    markup();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt13 >= 1 ) break loop13;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(13, input);
                                dbg.recognitionException(eee);

                                throw eee;
                        }
                        cnt13++;
                    } while (true);
                    } finally {dbg.exitSubRule(13);}

                    dbg.location(63,12);
                    pushFollow(FOLLOW_expression_in_statement351);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    dbg.location(63,23);
                    match(input,11,FOLLOW_11_in_statement353); if (state.failed) return ;

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
        dbg.location(63, 27);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "statement"


    // $ANTLR start "predicate"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:66:1: predicate : expression ;
    public final void predicate() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "predicate");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(66, 1);

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:66:10: ( expression )
            dbg.enterAlt(1);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:66:13: expression
            {
            dbg.location(66,13);
            pushFollow(FOLLOW_expression_in_predicate366);
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
        dbg.location(66, 23);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "predicate");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "predicate"

    // $ANTLR start synpred15_DebugWaebric
    public final void synpred15_DebugWaebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:56:47: ( 'else' statement )
        dbg.enterAlt(1);

        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:56:47: 'else' statement
        {
        dbg.location(56,47);
        match(input,22,FOLLOW_22_in_synpred15_DebugWaebric260); if (state.failed) return ;
        dbg.location(56,54);
        pushFollow(FOLLOW_statement_in_synpred15_DebugWaebric262);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_DebugWaebric

    // $ANTLR start synpred22_DebugWaebric
    public final void synpred22_DebugWaebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:61:4: ( markup )
        dbg.enterAlt(1);

        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:61:4: markup
        {
        dbg.location(61,4);
        pushFollow(FOLLOW_markup_in_synpred22_DebugWaebric322);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred22_DebugWaebric

    // $ANTLR start synpred23_DebugWaebric
    public final void synpred23_DebugWaebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:61:4: ( ( markup )+ statement ';' )
        dbg.enterAlt(1);

        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:61:4: ( markup )+ statement ';'
        {
        dbg.location(61,4);
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:61:4: ( markup )+
        int cnt17=0;
        try { dbg.enterSubRule(17);

        loop17:
        do {
            int alt17=2;
            try { dbg.enterDecision(17);

            int LA17_0 = input.LA(1);

            if ( (LA17_0==IDCON) ) {
                int LA17_2 = input.LA(2);

                if ( (synpred22_DebugWaebric()) ) {
                    alt17=1;
                }


            }


            } finally {dbg.exitDecision(17);}

            switch (alt17) {
        	case 1 :
        	    dbg.enterAlt(1);

        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: markup
        	    {
        	    dbg.location(61,4);
        	    pushFollow(FOLLOW_markup_in_synpred23_DebugWaebric322);
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

        dbg.location(61,12);
        pushFollow(FOLLOW_statement_in_synpred23_DebugWaebric325);
        statement();

        state._fsp--;
        if (state.failed) return ;
        dbg.location(61,22);
        match(input,11,FOLLOW_11_in_synpred23_DebugWaebric327); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred23_DebugWaebric

    // $ANTLR start synpred25_DebugWaebric
    public final void synpred25_DebugWaebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:62:4: ( ( markup )+ markup ';' )
        dbg.enterAlt(1);

        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:62:4: ( markup )+ markup ';'
        {
        dbg.location(62,4);
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:62:4: ( markup )+
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
        	    dbg.location(62,4);
        	    pushFollow(FOLLOW_markup_in_synpred25_DebugWaebric335);
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

        dbg.location(62,12);
        pushFollow(FOLLOW_markup_in_synpred25_DebugWaebric338);
        markup();

        state._fsp--;
        if (state.failed) return ;
        dbg.location(62,19);
        match(input,11,FOLLOW_11_in_synpred25_DebugWaebric340); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_DebugWaebric

    // Delegated rules

    public final boolean synpred22_DebugWaebric() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred22_DebugWaebric_fragment(); // can never throw exception
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
    public final boolean synpred23_DebugWaebric() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred23_DebugWaebric_fragment(); // can never throw exception
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
    public final boolean synpred25_DebugWaebric() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred25_DebugWaebric_fragment(); // can never throw exception
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
    public final boolean synpred15_DebugWaebric() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred15_DebugWaebric_fragment(); // can never throw exception
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


    protected DFA14 dfa14 = new DFA14(this);
    protected DFA12 dfa12 = new DFA12(this);
    protected DFA18 dfa18 = new DFA18(this);
    static final String DFA14_eotS =
        "\12\uffff";
    static final String DFA14_eofS =
        "\12\uffff";
    static final String DFA14_minS =
        "\1\4\4\uffff\1\11\4\uffff";
    static final String DFA14_maxS =
        "\1\32\4\uffff\1\17\4\uffff";
    static final String DFA14_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\uffff\1\5\1\6\1\7\1\10";
    static final String DFA14_specialS =
        "\5\uffff\1\0\4\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\5\20\uffff\1\1\1\uffff\1\2\1\3\1\uffff\1\4",
            "",
            "",
            "",
            "",
            "\1\6\1\uffff\5\6",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "56:1: statement : ( 'if' '(' predicate ')' statement ( 'else' statement )? | 'each' '(' IDCON ':' expression ')' statement | '{' ( statement )* '}' | 'yield;' | markup ';' | ( markup )+ statement ';' | ( markup )+ markup ';' | ( markup )+ expression ';' );";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_5 = input.LA(1);

                         
                        int index14_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA14_5==9||(LA14_5>=11 && LA14_5<=15)) ) {s = 6;}

                        else if ( (synpred23_DebugWaebric()) ) {s = 7;}

                        else if ( (synpred25_DebugWaebric()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index14_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA12_eotS =
        "\20\uffff";
    static final String DFA12_eofS =
        "\20\uffff";
    static final String DFA12_minS =
        "\6\4\1\5\2\uffff\5\4\1\5\1\4";
    static final String DFA12_maxS =
        "\1\4\1\17\4\4\1\5\2\uffff\4\17\1\20\1\5\1\17";
    static final String DFA12_acceptS =
        "\7\uffff\1\2\1\1\7\uffff";
    static final String DFA12_specialS =
        "\20\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\1",
            "\1\10\4\uffff\1\3\1\uffff\1\7\1\2\1\4\1\5\1\6",
            "\1\11",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15",
            "",
            "",
            "\1\10\4\uffff\1\3\1\uffff\1\7\1\2\1\4\1\5\1\6",
            "\1\10\4\uffff\1\3\1\uffff\1\7\1\2\1\4\1\5\1\6",
            "\1\10\4\uffff\1\3\1\uffff\1\7\1\2\1\4\1\5\1\6",
            "\1\10\4\uffff\1\3\1\uffff\1\7\1\2\1\4\1\5\1\6",
            "\1\10\4\uffff\1\3\1\uffff\1\7\1\2\1\4\1\5\1\6\1\16",
            "\1\17",
            "\1\10\4\uffff\1\3\1\uffff\1\7\1\2\1\4\1\5\1\6"
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
            return "()+ loopback of 62:4: ( markup )+";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
    static final String DFA18_eotS =
        "\20\uffff";
    static final String DFA18_eofS =
        "\20\uffff";
    static final String DFA18_minS =
        "\6\4\1\5\2\uffff\5\4\1\5\1\4";
    static final String DFA18_maxS =
        "\1\4\1\17\4\4\1\5\2\uffff\4\17\1\20\1\5\1\17";
    static final String DFA18_acceptS =
        "\7\uffff\1\1\1\2\7\uffff";
    static final String DFA18_specialS =
        "\20\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\1",
            "\1\7\4\uffff\1\3\1\uffff\1\10\1\2\1\4\1\5\1\6",
            "\1\11",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15",
            "",
            "",
            "\1\7\4\uffff\1\3\1\uffff\1\10\1\2\1\4\1\5\1\6",
            "\1\7\4\uffff\1\3\1\uffff\1\10\1\2\1\4\1\5\1\6",
            "\1\7\4\uffff\1\3\1\uffff\1\10\1\2\1\4\1\5\1\6",
            "\1\7\4\uffff\1\3\1\uffff\1\10\1\2\1\4\1\5\1\6",
            "\1\7\4\uffff\1\3\1\uffff\1\10\1\2\1\4\1\5\1\6\1\16",
            "\1\17",
            "\1\7\4\uffff\1\3\1\uffff\1\10\1\2\1\4\1\5\1\6"
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
            return "()+ loopback of 62:4: ( markup )+";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
 

    public static final BitSet FOLLOW_7_in_module39 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_moduleIdentifier_in_module41 = new BitSet(new long[]{0x0000000000100500L});
    public static final BitSet FOLLOW_moduleElement_in_module43 = new BitSet(new long[]{0x0000000000100500L});
    public static final BitSet FOLLOW_8_in_module46 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_moduleIdentifier52 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_9_in_moduleIdentifier56 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_moduleIdentifier58 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_moduleImport_in_moduleElement68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_moduleElement72 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_moduleImport79 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_moduleIdentifier_in_moduleImport81 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_moduleImport83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_designator_in_markup104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_designator111 = new BitSet(new long[]{0x000000000000F202L});
    public static final BitSet FOLLOW_attribute_in_designator113 = new BitSet(new long[]{0x000000000000F202L});
    public static final BitSet FOLLOW_12_in_attribute121 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_attribute127 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_attribute133 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_attribute139 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_attribute148 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NATCON_in_attribute150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_attribute154 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NATCON_in_attribute156 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_attribute158 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NATCON_in_attribute160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_arguments167 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_argument_in_arguments169 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_arguments173 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_argument_in_arguments175 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_19_in_arguments181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_argument188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_expression0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_function211 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_function213 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_formals_in_function215 = new BitSet(new long[]{0x0000000005A00110L});
    public static final BitSet FOLLOW_statement_in_function217 = new BitSet(new long[]{0x0000000005A00110L});
    public static final BitSet FOLLOW_8_in_function220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_formals227 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_formals229 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_formals233 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_formals235 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_19_in_formals240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_statement249 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_statement251 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_predicate_in_statement253 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_statement255 = new BitSet(new long[]{0x0000000005A00010L});
    public static final BitSet FOLLOW_statement_in_statement257 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_statement260 = new BitSet(new long[]{0x0000000005A00010L});
    public static final BitSet FOLLOW_statement_in_statement262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_statement272 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_statement274 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_statement276 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_statement278 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_expression_in_statement280 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_statement282 = new BitSet(new long[]{0x0000000005A00010L});
    public static final BitSet FOLLOW_statement_in_statement284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_statement292 = new BitSet(new long[]{0x0000000007A00010L});
    public static final BitSet FOLLOW_statement_in_statement294 = new BitSet(new long[]{0x0000000007A00010L});
    public static final BitSet FOLLOW_25_in_statement297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_statement305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement312 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_statement314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement322 = new BitSet(new long[]{0x0000000005A00010L});
    public static final BitSet FOLLOW_statement_in_statement325 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_statement327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement335 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_statement338 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_statement340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement348 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_expression_in_statement351 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_statement353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_synpred15_DebugWaebric260 = new BitSet(new long[]{0x0000000005A00010L});
    public static final BitSet FOLLOW_statement_in_synpred15_DebugWaebric262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred22_DebugWaebric322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred23_DebugWaebric322 = new BitSet(new long[]{0x0000000005A00010L});
    public static final BitSet FOLLOW_statement_in_synpred23_DebugWaebric325 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_synpred23_DebugWaebric327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred25_DebugWaebric335 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_synpred25_DebugWaebric338 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_synpred25_DebugWaebric340 = new BitSet(new long[]{0x0000000000000002L});

}