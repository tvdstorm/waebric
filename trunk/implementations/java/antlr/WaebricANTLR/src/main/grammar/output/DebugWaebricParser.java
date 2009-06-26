// $ANTLR 3.1.2 /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g 2009-06-26 13:30:44

import org.antlr.runtime.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class DebugWaebricParser extends Parser {
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


        public DebugWaebricParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public DebugWaebricParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
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
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:25:7: ( 'module' moduleIdentifier ( moduleElement )* 'end' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:25:12: 'module' moduleIdentifier ( moduleElement )* 'end'
            {
            match(input,7,FOLLOW_7_in_module39); if (state.failed) return ;
            pushFollow(FOLLOW_moduleIdentifier_in_module41);
            moduleIdentifier();

            state._fsp--;
            if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:25:38: ( moduleElement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==10||LA1_0==20) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: moduleElement
            	    {
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

            match(input,8,FOLLOW_8_in_module46); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "module"


    // $ANTLR start "moduleIdentifier"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:26:1: moduleIdentifier : IDCON ( '.' IDCON )* ;
    public final void moduleIdentifier() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:26:17: ( IDCON ( '.' IDCON )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:26:19: IDCON ( '.' IDCON )*
            {
            match(input,IDCON,FOLLOW_IDCON_in_moduleIdentifier52); if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:26:25: ( '.' IDCON )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==9) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:26:27: '.' IDCON
            	    {
            	    match(input,9,FOLLOW_9_in_moduleIdentifier56); if (state.failed) return ;
            	    match(input,IDCON,FOLLOW_IDCON_in_moduleIdentifier58); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "moduleIdentifier"


    // $ANTLR start "moduleElement"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:27:1: moduleElement : ( moduleImport | function );
    public final void moduleElement() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:27:14: ( moduleImport | function )
            int alt3=2;
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

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:27:17: moduleImport
                    {
                    pushFollow(FOLLOW_moduleImport_in_moduleElement68);
                    moduleImport();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:27:32: function
                    {
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
        return ;
    }
    // $ANTLR end "moduleElement"


    // $ANTLR start "moduleImport"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:28:1: moduleImport : 'import' moduleIdentifier ';' ;
    public final void moduleImport() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:28:13: ( 'import' moduleIdentifier ';' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:28:16: 'import' moduleIdentifier ';'
            {
            match(input,10,FOLLOW_10_in_moduleImport79); if (state.failed) return ;
            pushFollow(FOLLOW_moduleIdentifier_in_moduleImport81);
            moduleIdentifier();

            state._fsp--;
            if (state.failed) return ;
            match(input,11,FOLLOW_11_in_moduleImport83); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "moduleImport"


    // $ANTLR start "markup"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:30:1: markup : ( designator arguments )=> designator ;
    public final void markup() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:41:7: ( ( designator arguments )=> designator )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:41:11: ( designator arguments )=> designator
            {
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
        return ;
    }
    // $ANTLR end "markup"


    // $ANTLR start "designator"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:42:1: designator : IDCON ( attribute )* ;
    public final void designator() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:42:11: ( IDCON ( attribute )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:42:14: IDCON ( attribute )*
            {
            match(input,IDCON,FOLLOW_IDCON_in_designator111); if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:42:20: ( attribute )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==9||(LA4_0>=12 && LA4_0<=15)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: attribute
            	    {
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "designator"


    // $ANTLR start "attribute"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:43:1: attribute : ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON );
    public final void attribute() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:43:10: ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON )
            int alt5=6;
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
                    else if ( (LA5_6==EOF||(LA5_6>=IDCON && LA5_6<=NATCON)||LA5_6==9||(LA5_6>=11 && LA5_6<=15)||LA5_6==17) ) {
                        alt5=5;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 5, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:43:13: '#' IDCON
                    {
                    match(input,12,FOLLOW_12_in_attribute121); if (state.failed) return ;
                    match(input,IDCON,FOLLOW_IDCON_in_attribute123); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:43:25: '.' IDCON
                    {
                    match(input,9,FOLLOW_9_in_attribute127); if (state.failed) return ;
                    match(input,IDCON,FOLLOW_IDCON_in_attribute129); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:43:37: '$' IDCON
                    {
                    match(input,13,FOLLOW_13_in_attribute133); if (state.failed) return ;
                    match(input,IDCON,FOLLOW_IDCON_in_attribute135); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:43:49: ':' IDCON
                    {
                    match(input,14,FOLLOW_14_in_attribute139); if (state.failed) return ;
                    match(input,IDCON,FOLLOW_IDCON_in_attribute141); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:44:6: '@' NATCON
                    {
                    match(input,15,FOLLOW_15_in_attribute148); if (state.failed) return ;
                    match(input,NATCON,FOLLOW_NATCON_in_attribute150); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:44:19: '@' NATCON '%' NATCON
                    {
                    match(input,15,FOLLOW_15_in_attribute154); if (state.failed) return ;
                    match(input,NATCON,FOLLOW_NATCON_in_attribute156); if (state.failed) return ;
                    match(input,16,FOLLOW_16_in_attribute158); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "attribute"


    // $ANTLR start "arguments"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:45:1: arguments : '(' argument ( ',' argument )* ')' ;
    public final void arguments() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:45:10: ( '(' argument ( ',' argument )* ')' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:45:13: '(' argument ( ',' argument )* ')'
            {
            match(input,17,FOLLOW_17_in_arguments167); if (state.failed) return ;
            pushFollow(FOLLOW_argument_in_arguments169);
            argument();

            state._fsp--;
            if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:45:26: ( ',' argument )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:45:28: ',' argument
            	    {
            	    match(input,18,FOLLOW_18_in_arguments173); if (state.failed) return ;
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

            match(input,19,FOLLOW_19_in_arguments181); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "arguments"


    // $ANTLR start "argument"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:46:1: argument : expression ;
    public final void argument() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:46:9: ( expression )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:46:12: expression
            {
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
        return ;
    }
    // $ANTLR end "argument"


    // $ANTLR start "expression"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:49:1: expression : ( IDCON | NATCON );
    public final void expression() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:49:11: ( IDCON | NATCON )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:
            {
            if ( (input.LA(1)>=IDCON && input.LA(1)<=NATCON) ) {
                input.consume();
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
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
        return ;
    }
    // $ANTLR end "expression"


    // $ANTLR start "function"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:52:1: function : 'def' IDCON formals ( statement )* 'end' ;
    public final void function() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:52:9: ( 'def' IDCON formals ( statement )* 'end' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:52:12: 'def' IDCON formals ( statement )* 'end'
            {
            match(input,20,FOLLOW_20_in_function211); if (state.failed) return ;
            match(input,IDCON,FOLLOW_IDCON_in_function213); if (state.failed) return ;
            pushFollow(FOLLOW_formals_in_function215);
            formals();

            state._fsp--;
            if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:52:32: ( statement )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==21||(LA7_0>=23 && LA7_0<=24)||LA7_0==26) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: statement
            	    {
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

            match(input,8,FOLLOW_8_in_function220); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "function"


    // $ANTLR start "formals"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:53:1: formals : '(' IDCON ( ',' IDCON )* ')' ;
    public final void formals() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:53:8: ( '(' IDCON ( ',' IDCON )* ')' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:53:11: '(' IDCON ( ',' IDCON )* ')'
            {
            match(input,17,FOLLOW_17_in_formals227); if (state.failed) return ;
            match(input,IDCON,FOLLOW_IDCON_in_formals229); if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:53:21: ( ',' IDCON )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==18) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:53:23: ',' IDCON
            	    {
            	    match(input,18,FOLLOW_18_in_formals233); if (state.failed) return ;
            	    match(input,IDCON,FOLLOW_IDCON_in_formals235); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match(input,19,FOLLOW_19_in_formals240); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "formals"


    // $ANTLR start "statement"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:56:1: statement : ( ifStatement | ifelseStatement | eachStatement | blockStatement | yieldStatement );
    public final void statement() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:56:10: ( ifStatement | ifelseStatement | eachStatement | blockStatement | yieldStatement )
            int alt9=5;
            switch ( input.LA(1) ) {
            case 21:
                {
                int LA9_1 = input.LA(2);

                if ( (synpred15_DebugWaebric()) ) {
                    alt9=1;
                }
                else if ( (synpred16_DebugWaebric()) ) {
                    alt9=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
                }
                break;
            case 23:
                {
                alt9=3;
                }
                break;
            case 24:
                {
                alt9=4;
                }
                break;
            case 26:
                {
                alt9=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:56:13: ifStatement
                    {
                    pushFollow(FOLLOW_ifStatement_in_statement249);
                    ifStatement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:56:27: ifelseStatement
                    {
                    pushFollow(FOLLOW_ifelseStatement_in_statement253);
                    ifelseStatement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:56:45: eachStatement
                    {
                    pushFollow(FOLLOW_eachStatement_in_statement257);
                    eachStatement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:56:61: blockStatement
                    {
                    pushFollow(FOLLOW_blockStatement_in_statement261);
                    blockStatement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:56:78: yieldStatement
                    {
                    pushFollow(FOLLOW_yieldStatement_in_statement265);
                    yieldStatement();

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
        return ;
    }
    // $ANTLR end "statement"


    // $ANTLR start "ifStatement"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:57:1: ifStatement : 'if' statement ;
    public final void ifStatement() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:57:12: ( 'if' statement )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:57:15: 'if' statement
            {
            match(input,21,FOLLOW_21_in_ifStatement272); if (state.failed) return ;
            pushFollow(FOLLOW_statement_in_ifStatement274);
            statement();

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
        return ;
    }
    // $ANTLR end "ifStatement"


    // $ANTLR start "ifelseStatement"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:58:1: ifelseStatement : 'if' statement 'else' statement ;
    public final void ifelseStatement() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:58:16: ( 'if' statement 'else' statement )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:58:18: 'if' statement 'else' statement
            {
            match(input,21,FOLLOW_21_in_ifelseStatement280); if (state.failed) return ;
            pushFollow(FOLLOW_statement_in_ifelseStatement282);
            statement();

            state._fsp--;
            if (state.failed) return ;
            match(input,22,FOLLOW_22_in_ifelseStatement284); if (state.failed) return ;
            pushFollow(FOLLOW_statement_in_ifelseStatement286);
            statement();

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
        return ;
    }
    // $ANTLR end "ifelseStatement"


    // $ANTLR start "eachStatement"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:59:1: eachStatement : 'each' '(' IDCON ':' expression ')' statement ;
    public final void eachStatement() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:59:14: ( 'each' '(' IDCON ':' expression ')' statement )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:59:17: 'each' '(' IDCON ':' expression ')' statement
            {
            match(input,23,FOLLOW_23_in_eachStatement293); if (state.failed) return ;
            match(input,17,FOLLOW_17_in_eachStatement295); if (state.failed) return ;
            match(input,IDCON,FOLLOW_IDCON_in_eachStatement297); if (state.failed) return ;
            match(input,14,FOLLOW_14_in_eachStatement299); if (state.failed) return ;
            pushFollow(FOLLOW_expression_in_eachStatement301);
            expression();

            state._fsp--;
            if (state.failed) return ;
            match(input,19,FOLLOW_19_in_eachStatement303); if (state.failed) return ;
            pushFollow(FOLLOW_statement_in_eachStatement305);
            statement();

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
        return ;
    }
    // $ANTLR end "eachStatement"


    // $ANTLR start "blockStatement"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:60:1: blockStatement : '{' ( statement )* '}' ;
    public final void blockStatement() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:60:15: ( '{' ( statement )* '}' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:60:18: '{' ( statement )* '}'
            {
            match(input,24,FOLLOW_24_in_blockStatement312); if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:60:22: ( statement )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==21||(LA10_0>=23 && LA10_0<=24)||LA10_0==26) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_blockStatement314);
            	    statement();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            match(input,25,FOLLOW_25_in_blockStatement317); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "blockStatement"


    // $ANTLR start "yieldStatement"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:61:1: yieldStatement : 'yield;' ;
    public final void yieldStatement() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:61:15: ( 'yield;' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:61:18: 'yield;'
            {
            match(input,26,FOLLOW_26_in_yieldStatement324); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "yieldStatement"


    // $ANTLR start "markupStatement"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:62:1: markupStatement : markup ';' ;
    public final void markupStatement() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:62:16: ( markup ';' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:62:18: markup ';'
            {
            pushFollow(FOLLOW_markup_in_markupStatement330);
            markup();

            state._fsp--;
            if (state.failed) return ;
            match(input,11,FOLLOW_11_in_markupStatement332); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "markupStatement"


    // $ANTLR start "markupsMarkup"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:63:1: markupsMarkup : ( markup )+ markup ';' ;
    public final void markupsMarkup() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:63:14: ( ( markup )+ markup ';' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:63:17: ( markup )+ markup ';'
            {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:63:17: ( markup )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                alt11 = dfa11.predict(input);
                switch (alt11) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: markup
            	    {
            	    pushFollow(FOLLOW_markup_in_markupsMarkup339);
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
                        throw eee;
                }
                cnt11++;
            } while (true);

            pushFollow(FOLLOW_markup_in_markupsMarkup342);
            markup();

            state._fsp--;
            if (state.failed) return ;
            match(input,11,FOLLOW_11_in_markupsMarkup344); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "markupsMarkup"


    // $ANTLR start "markupsExpression"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:64:1: markupsExpression : ( markup )+ expression ';' ;
    public final void markupsExpression() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:64:18: ( ( markup )+ expression ';' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:64:20: ( markup )+ expression ';'
            {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:64:20: ( markup )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==IDCON) ) {
                    int LA12_1 = input.LA(2);

                    if ( ((LA12_1>=IDCON && LA12_1<=NATCON)||LA12_1==9||(LA12_1>=12 && LA12_1<=15)) ) {
                        alt12=1;
                    }


                }


                switch (alt12) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: markup
            	    {
            	    pushFollow(FOLLOW_markup_in_markupsExpression351);
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
                        throw eee;
                }
                cnt12++;
            } while (true);

            pushFollow(FOLLOW_expression_in_markupsExpression354);
            expression();

            state._fsp--;
            if (state.failed) return ;
            match(input,11,FOLLOW_11_in_markupsExpression356); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "markupsExpression"


    // $ANTLR start "markupsStatement"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:65:1: markupsStatement : ( markup )+ markup ';' ;
    public final void markupsStatement() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:65:17: ( ( markup )+ markup ';' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:65:19: ( markup )+ markup ';'
            {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:65:19: ( markup )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                alt13 = dfa13.predict(input);
                switch (alt13) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: markup
            	    {
            	    pushFollow(FOLLOW_markup_in_markupsStatement362);
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
                        throw eee;
                }
                cnt13++;
            } while (true);

            pushFollow(FOLLOW_markup_in_markupsStatement365);
            markup();

            state._fsp--;
            if (state.failed) return ;
            match(input,11,FOLLOW_11_in_markupsStatement367); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "markupsStatement"

    // $ANTLR start synpred15_DebugWaebric
    public final void synpred15_DebugWaebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:56:13: ( ifStatement )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:56:13: ifStatement
        {
        pushFollow(FOLLOW_ifStatement_in_synpred15_DebugWaebric249);
        ifStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_DebugWaebric

    // $ANTLR start synpred16_DebugWaebric
    public final void synpred16_DebugWaebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:56:27: ( ifelseStatement )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:56:27: ifelseStatement
        {
        pushFollow(FOLLOW_ifelseStatement_in_synpred16_DebugWaebric253);
        ifelseStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_DebugWaebric

    // Delegated rules

    public final boolean synpred16_DebugWaebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_DebugWaebric_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_DebugWaebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_DebugWaebric_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA11 dfa11 = new DFA11(this);
    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA11_eotS =
        "\20\uffff";
    static final String DFA11_eofS =
        "\20\uffff";
    static final String DFA11_minS =
        "\6\4\1\5\2\uffff\5\4\1\5\1\4";
    static final String DFA11_maxS =
        "\1\4\1\17\4\4\1\5\2\uffff\4\17\1\20\1\5\1\17";
    static final String DFA11_acceptS =
        "\7\uffff\1\2\1\1\7\uffff";
    static final String DFA11_specialS =
        "\20\uffff}>";
    static final String[] DFA11_transitionS = {
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

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "()+ loopback of 63:17: ( markup )+";
        }
    }
    static final String DFA13_eotS =
        "\20\uffff";
    static final String DFA13_eofS =
        "\20\uffff";
    static final String DFA13_minS =
        "\6\4\1\5\2\uffff\5\4\1\5\1\4";
    static final String DFA13_maxS =
        "\1\4\1\17\4\4\1\5\2\uffff\4\17\1\20\1\5\1\17";
    static final String DFA13_acceptS =
        "\7\uffff\1\1\1\2\7\uffff";
    static final String DFA13_specialS =
        "\20\uffff}>";
    static final String[] DFA13_transitionS = {
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

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "()+ loopback of 65:19: ( markup )+";
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
    public static final BitSet FOLLOW_formals_in_function215 = new BitSet(new long[]{0x0000000005A00100L});
    public static final BitSet FOLLOW_statement_in_function217 = new BitSet(new long[]{0x0000000005A00100L});
    public static final BitSet FOLLOW_8_in_function220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_formals227 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_formals229 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_formals233 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_formals235 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_19_in_formals240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statement249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifelseStatement_in_statement253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_eachStatement_in_statement257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blockStatement_in_statement261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_yieldStatement_in_statement265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ifStatement272 = new BitSet(new long[]{0x0000000005A00000L});
    public static final BitSet FOLLOW_statement_in_ifStatement274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ifelseStatement280 = new BitSet(new long[]{0x0000000005A00000L});
    public static final BitSet FOLLOW_statement_in_ifelseStatement282 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ifelseStatement284 = new BitSet(new long[]{0x0000000005A00000L});
    public static final BitSet FOLLOW_statement_in_ifelseStatement286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_eachStatement293 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_eachStatement295 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_eachStatement297 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_eachStatement299 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_expression_in_eachStatement301 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_eachStatement303 = new BitSet(new long[]{0x0000000005A00000L});
    public static final BitSet FOLLOW_statement_in_eachStatement305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_blockStatement312 = new BitSet(new long[]{0x0000000007A00000L});
    public static final BitSet FOLLOW_statement_in_blockStatement314 = new BitSet(new long[]{0x0000000007A00000L});
    public static final BitSet FOLLOW_25_in_blockStatement317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_yieldStatement324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_markupStatement330 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_markupStatement332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_markupsMarkup339 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_markupsMarkup342 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_markupsMarkup344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_markupsExpression351 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_expression_in_markupsExpression354 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_markupsExpression356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_markupsStatement362 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_markupsStatement365 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_markupsStatement367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_synpred15_DebugWaebric249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifelseStatement_in_synpred16_DebugWaebric253 = new BitSet(new long[]{0x0000000000000002L});

}