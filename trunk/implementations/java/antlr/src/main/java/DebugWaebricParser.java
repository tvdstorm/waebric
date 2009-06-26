// $ANTLR 3.1.2 /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g 2009-06-26 14:53:42

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:30:1: markup : designator ( arguments )? ;
    public final void markup() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:41:7: ( designator ( arguments )? )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:41:11: designator ( arguments )?
            {
            pushFollow(FOLLOW_designator_in_markup96);
            designator();

            state._fsp--;
            if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:41:22: ( arguments )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: arguments
                    {
                    pushFollow(FOLLOW_arguments_in_markup98);
                    arguments();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

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
    // $ANTLR end "markup"


    // $ANTLR start "designator"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:42:1: designator : IDCON ( attribute )* ;
    public final void designator() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:42:11: ( IDCON ( attribute )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:42:14: IDCON ( attribute )*
            {
            match(input,IDCON,FOLLOW_IDCON_in_designator106); if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:42:20: ( attribute )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==9||(LA5_0>=12 && LA5_0<=15)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: attribute
            	    {
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
            int alt6=6;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt6=1;
                }
                break;
            case 9:
                {
                alt6=2;
                }
                break;
            case 13:
                {
                alt6=3;
                }
                break;
            case 14:
                {
                alt6=4;
                }
                break;
            case 15:
                {
                int LA6_5 = input.LA(2);

                if ( (LA6_5==NATCON) ) {
                    int LA6_6 = input.LA(3);

                    if ( (LA6_6==16) ) {
                        alt6=6;
                    }
                    else if ( (LA6_6==EOF||(LA6_6>=IDCON && LA6_6<=NATCON)||LA6_6==9||(LA6_6>=11 && LA6_6<=15)||LA6_6==17||LA6_6==21||(LA6_6>=23 && LA6_6<=24)||LA6_6==26) ) {
                        alt6=5;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 5, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:43:13: '#' IDCON
                    {
                    match(input,12,FOLLOW_12_in_attribute116); if (state.failed) return ;
                    match(input,IDCON,FOLLOW_IDCON_in_attribute118); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:44:4: '.' IDCON
                    {
                    match(input,9,FOLLOW_9_in_attribute126); if (state.failed) return ;
                    match(input,IDCON,FOLLOW_IDCON_in_attribute128); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:45:4: '$' IDCON
                    {
                    match(input,13,FOLLOW_13_in_attribute136); if (state.failed) return ;
                    match(input,IDCON,FOLLOW_IDCON_in_attribute138); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:46:4: ':' IDCON
                    {
                    match(input,14,FOLLOW_14_in_attribute146); if (state.failed) return ;
                    match(input,IDCON,FOLLOW_IDCON_in_attribute148); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:47:4: '@' NATCON
                    {
                    match(input,15,FOLLOW_15_in_attribute156); if (state.failed) return ;
                    match(input,NATCON,FOLLOW_NATCON_in_attribute158); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:48:4: '@' NATCON '%' NATCON
                    {
                    match(input,15,FOLLOW_15_in_attribute166); if (state.failed) return ;
                    match(input,NATCON,FOLLOW_NATCON_in_attribute168); if (state.failed) return ;
                    match(input,16,FOLLOW_16_in_attribute170); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "attribute"


    // $ANTLR start "arguments"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:49:1: arguments : ( '(' ( argument )? ( ',' argument )* ')' ) ;
    public final void arguments() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:49:10: ( ( '(' ( argument )? ( ',' argument )* ')' ) )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:49:13: ( '(' ( argument )? ( ',' argument )* ')' )
            {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:49:13: ( '(' ( argument )? ( ',' argument )* ')' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:49:14: '(' ( argument )? ( ',' argument )* ')'
            {
            match(input,17,FOLLOW_17_in_arguments180); if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:49:18: ( argument )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=IDCON && LA7_0<=NATCON)) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: argument
                    {
                    pushFollow(FOLLOW_argument_in_arguments182);
                    argument();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:49:28: ( ',' argument )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==18) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:49:30: ',' argument
            	    {
            	    match(input,18,FOLLOW_18_in_arguments187); if (state.failed) return ;
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

            match(input,19,FOLLOW_19_in_arguments195); if (state.failed) return ;

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
    // $ANTLR end "arguments"


    // $ANTLR start "argument"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:50:1: argument : expression ;
    public final void argument() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:50:9: ( expression )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:50:12: expression
            {
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
        return ;
    }
    // $ANTLR end "argument"


    // $ANTLR start "expression"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:53:1: expression : ( IDCON | NATCON );
    public final void expression() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:53:11: ( IDCON | NATCON )
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:56:1: function : 'def' IDCON formals ( statement )* 'end' ;
    public final void function() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:56:9: ( 'def' IDCON formals ( statement )* 'end' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:56:12: 'def' IDCON formals ( statement )* 'end'
            {
            match(input,20,FOLLOW_20_in_function226); if (state.failed) return ;
            match(input,IDCON,FOLLOW_IDCON_in_function228); if (state.failed) return ;
            pushFollow(FOLLOW_formals_in_function230);
            formals();

            state._fsp--;
            if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:56:32: ( statement )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==IDCON||LA9_0==21||(LA9_0>=23 && LA9_0<=24)||LA9_0==26) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: statement
            	    {
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

            match(input,8,FOLLOW_8_in_function235); if (state.failed) return ;

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:57:1: formals : ( '(' ( IDCON )? ( ',' IDCON )* ')' | );
    public final void formals() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:57:8: ( '(' ( IDCON )? ( ',' IDCON )* ')' | )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==17) ) {
                alt12=1;
            }
            else if ( (LA12_0==IDCON||LA12_0==8||LA12_0==21||(LA12_0>=23 && LA12_0<=24)||LA12_0==26) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:57:11: '(' ( IDCON )? ( ',' IDCON )* ')'
                    {
                    match(input,17,FOLLOW_17_in_formals242); if (state.failed) return ;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:57:15: ( IDCON )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==IDCON) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: IDCON
                            {
                            match(input,IDCON,FOLLOW_IDCON_in_formals244); if (state.failed) return ;

                            }
                            break;

                    }

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:57:22: ( ',' IDCON )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==18) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:57:24: ',' IDCON
                    	    {
                    	    match(input,18,FOLLOW_18_in_formals249); if (state.failed) return ;
                    	    match(input,IDCON,FOLLOW_IDCON_in_formals251); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    match(input,19,FOLLOW_19_in_formals256); if (state.failed) return ;

                    }
                    break;
                case 2 :
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
        return ;
    }
    // $ANTLR end "formals"


    // $ANTLR start "statement"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:60:1: statement : ( 'if' '(' predicate ')' statement ( 'else' statement )? | 'each' '(' IDCON ':' expression ')' statement | '{' ( statement )* '}' | 'yield;' | markup ';' | ( markup )+ statement ';' | ( markup )+ markup ';' | ( markup )+ expression ';' );
    public final void statement() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:60:10: ( 'if' '(' predicate ')' statement ( 'else' statement )? | 'each' '(' IDCON ':' expression ')' statement | '{' ( statement )* '}' | 'yield;' | markup ';' | ( markup )+ statement ';' | ( markup )+ markup ';' | ( markup )+ expression ';' )
            int alt18=8;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:60:13: 'if' '(' predicate ')' statement ( 'else' statement )?
                    {
                    match(input,21,FOLLOW_21_in_statement268); if (state.failed) return ;
                    match(input,17,FOLLOW_17_in_statement270); if (state.failed) return ;
                    pushFollow(FOLLOW_predicate_in_statement272);
                    predicate();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,19,FOLLOW_19_in_statement274); if (state.failed) return ;
                    pushFollow(FOLLOW_statement_in_statement276);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:60:46: ( 'else' statement )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==22) ) {
                        int LA13_1 = input.LA(2);

                        if ( (synpred18_DebugWaebric()) ) {
                            alt13=1;
                        }
                    }
                    switch (alt13) {
                        case 1 :
                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:60:47: 'else' statement
                            {
                            match(input,22,FOLLOW_22_in_statement279); if (state.failed) return ;
                            pushFollow(FOLLOW_statement_in_statement281);
                            statement();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:61:4: 'each' '(' IDCON ':' expression ')' statement
                    {
                    match(input,23,FOLLOW_23_in_statement291); if (state.failed) return ;
                    match(input,17,FOLLOW_17_in_statement293); if (state.failed) return ;
                    match(input,IDCON,FOLLOW_IDCON_in_statement295); if (state.failed) return ;
                    match(input,14,FOLLOW_14_in_statement297); if (state.failed) return ;
                    pushFollow(FOLLOW_expression_in_statement299);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,19,FOLLOW_19_in_statement301); if (state.failed) return ;
                    pushFollow(FOLLOW_statement_in_statement303);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:62:4: '{' ( statement )* '}'
                    {
                    match(input,24,FOLLOW_24_in_statement311); if (state.failed) return ;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:62:8: ( statement )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==IDCON||LA14_0==21||(LA14_0>=23 && LA14_0<=24)||LA14_0==26) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_statement313);
                    	    statement();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    match(input,25,FOLLOW_25_in_statement316); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:63:4: 'yield;'
                    {
                    match(input,26,FOLLOW_26_in_statement324); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:64:4: markup ';'
                    {
                    pushFollow(FOLLOW_markup_in_statement331);
                    markup();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,11,FOLLOW_11_in_statement333); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:65:4: ( markup )+ statement ';'
                    {
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:65:4: ( markup )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==IDCON) ) {
                            int LA15_2 = input.LA(2);

                            if ( (synpred25_DebugWaebric()) ) {
                                alt15=1;
                            }


                        }


                        switch (alt15) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_statement341);
                    	    markup();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt15 >= 1 ) break loop15;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
                    } while (true);

                    pushFollow(FOLLOW_statement_in_statement344);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,11,FOLLOW_11_in_statement346); if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:66:4: ( markup )+ markup ';'
                    {
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:66:4: ( markup )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        alt16 = dfa16.predict(input);
                        switch (alt16) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_statement354);
                    	    markup();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt16 >= 1 ) break loop16;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(16, input);
                                throw eee;
                        }
                        cnt16++;
                    } while (true);

                    pushFollow(FOLLOW_markup_in_statement357);
                    markup();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,11,FOLLOW_11_in_statement359); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:67:4: ( markup )+ expression ';'
                    {
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:67:4: ( markup )+
                    int cnt17=0;
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==IDCON) ) {
                            int LA17_1 = input.LA(2);

                            if ( ((LA17_1>=IDCON && LA17_1<=NATCON)||LA17_1==9||(LA17_1>=12 && LA17_1<=15)||LA17_1==17) ) {
                                alt17=1;
                            }


                        }


                        switch (alt17) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_statement367);
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
                                throw eee;
                        }
                        cnt17++;
                    } while (true);

                    pushFollow(FOLLOW_expression_in_statement370);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,11,FOLLOW_11_in_statement372); if (state.failed) return ;

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


    // $ANTLR start "predicate"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:70:1: predicate : expression ;
    public final void predicate() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:70:10: ( expression )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:70:13: expression
            {
            pushFollow(FOLLOW_expression_in_predicate385);
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
    // $ANTLR end "predicate"

    // $ANTLR start synpred18_DebugWaebric
    public final void synpred18_DebugWaebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:60:47: ( 'else' statement )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:60:47: 'else' statement
        {
        match(input,22,FOLLOW_22_in_synpred18_DebugWaebric279); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred18_DebugWaebric281);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_DebugWaebric

    // $ANTLR start synpred25_DebugWaebric
    public final void synpred25_DebugWaebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:65:4: ( markup )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:65:4: markup
        {
        pushFollow(FOLLOW_markup_in_synpred25_DebugWaebric341);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_DebugWaebric

    // $ANTLR start synpred26_DebugWaebric
    public final void synpred26_DebugWaebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:65:4: ( ( markup )+ statement ';' )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:65:4: ( markup )+ statement ';'
        {
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:65:4: ( markup )+
        int cnt23=0;
        loop23:
        do {
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==IDCON) ) {
                int LA23_2 = input.LA(2);

                if ( (synpred25_DebugWaebric()) ) {
                    alt23=1;
                }


            }


            switch (alt23) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred26_DebugWaebric341);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt23 >= 1 ) break loop23;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(23, input);
                    throw eee;
            }
            cnt23++;
        } while (true);

        pushFollow(FOLLOW_statement_in_synpred26_DebugWaebric344);
        statement();

        state._fsp--;
        if (state.failed) return ;
        match(input,11,FOLLOW_11_in_synpred26_DebugWaebric346); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_DebugWaebric

    // $ANTLR start synpred28_DebugWaebric
    public final void synpred28_DebugWaebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:66:4: ( ( markup )+ markup ';' )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:66:4: ( markup )+ markup ';'
        {
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:66:4: ( markup )+
        int cnt24=0;
        loop24:
        do {
            int alt24=2;
            alt24 = dfa24.predict(input);
            switch (alt24) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/DebugWaebric.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred28_DebugWaebric354);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt24 >= 1 ) break loop24;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(24, input);
                    throw eee;
            }
            cnt24++;
        } while (true);

        pushFollow(FOLLOW_markup_in_synpred28_DebugWaebric357);
        markup();

        state._fsp--;
        if (state.failed) return ;
        match(input,11,FOLLOW_11_in_synpred28_DebugWaebric359); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred28_DebugWaebric

    // Delegated rules

    public final boolean synpred26_DebugWaebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_DebugWaebric_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_DebugWaebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_DebugWaebric_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_DebugWaebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_DebugWaebric_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_DebugWaebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_DebugWaebric_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA18 dfa18 = new DFA18(this);
    protected DFA16 dfa16 = new DFA16(this);
    protected DFA24 dfa24 = new DFA24(this);
    static final String DFA18_eotS =
        "\12\uffff";
    static final String DFA18_eofS =
        "\12\uffff";
    static final String DFA18_minS =
        "\1\4\4\uffff\1\11\4\uffff";
    static final String DFA18_maxS =
        "\1\32\4\uffff\1\21\4\uffff";
    static final String DFA18_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\uffff\1\5\1\6\1\7\1\10";
    static final String DFA18_specialS =
        "\5\uffff\1\0\4\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\5\20\uffff\1\1\1\uffff\1\2\1\3\1\uffff\1\4",
            "",
            "",
            "",
            "",
            "\1\6\1\uffff\5\6\1\uffff\1\6",
            "",
            "",
            "",
            ""
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
            return "60:1: statement : ( 'if' '(' predicate ')' statement ( 'else' statement )? | 'each' '(' IDCON ':' expression ')' statement | '{' ( statement )* '}' | 'yield;' | markup ';' | ( markup )+ statement ';' | ( markup )+ markup ';' | ( markup )+ expression ';' );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA18_5 = input.LA(1);

                         
                        int index18_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA18_5==9||(LA18_5>=11 && LA18_5<=15)||LA18_5==17) ) {s = 6;}

                        else if ( (synpred26_DebugWaebric()) ) {s = 7;}

                        else if ( (synpred28_DebugWaebric()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index18_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 18, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA16_eotS =
        "\25\uffff";
    static final String DFA16_eofS =
        "\25\uffff";
    static final String DFA16_minS =
        "\6\4\1\5\1\4\2\uffff\5\4\1\22\2\4\1\5\1\22\1\4";
    static final String DFA16_maxS =
        "\1\4\1\21\4\4\1\5\1\23\2\uffff\5\21\1\23\1\5\1\13\1\5\1\23\1\21";
    static final String DFA16_acceptS =
        "\10\uffff\1\1\1\2\13\uffff";
    static final String DFA16_specialS =
        "\25\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\1",
            "\1\10\4\uffff\1\3\1\uffff\1\11\1\2\1\4\1\5\1\6\1\uffff\1\7",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15",
            "\1\16",
            "\2\17\14\uffff\1\20\1\21",
            "",
            "",
            "\1\10\4\uffff\1\3\1\uffff\1\11\1\2\1\4\1\5\1\6\1\uffff\1\7",
            "\1\10\4\uffff\1\3\1\uffff\1\11\1\2\1\4\1\5\1\6\1\uffff\1\7",
            "\1\10\4\uffff\1\3\1\uffff\1\11\1\2\1\4\1\5\1\6\1\uffff\1\7",
            "\1\10\4\uffff\1\3\1\uffff\1\11\1\2\1\4\1\5\1\6\1\uffff\1\7",
            "\1\10\4\uffff\1\3\1\uffff\1\11\1\2\1\4\1\5\1\6\1\22\1\7",
            "\1\20\1\21",
            "\2\23",
            "\1\10\6\uffff\1\11",
            "\1\24",
            "\1\20\1\21",
            "\1\10\4\uffff\1\3\1\uffff\1\11\1\2\1\4\1\5\1\6\1\uffff\1\7"
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "()+ loopback of 66:4: ( markup )+";
        }
    }
    static final String DFA24_eotS =
        "\25\uffff";
    static final String DFA24_eofS =
        "\25\uffff";
    static final String DFA24_minS =
        "\6\4\1\5\1\4\2\uffff\5\4\1\22\2\4\1\5\1\22\1\4";
    static final String DFA24_maxS =
        "\1\4\1\21\4\4\1\5\1\23\2\uffff\5\21\1\23\1\5\1\13\1\5\1\23\1\21";
    static final String DFA24_acceptS =
        "\10\uffff\1\2\1\1\13\uffff";
    static final String DFA24_specialS =
        "\25\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\1",
            "\1\11\4\uffff\1\3\1\uffff\1\10\1\2\1\4\1\5\1\6\1\uffff\1\7",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15",
            "\1\16",
            "\2\17\14\uffff\1\20\1\21",
            "",
            "",
            "\1\11\4\uffff\1\3\1\uffff\1\10\1\2\1\4\1\5\1\6\1\uffff\1\7",
            "\1\11\4\uffff\1\3\1\uffff\1\10\1\2\1\4\1\5\1\6\1\uffff\1\7",
            "\1\11\4\uffff\1\3\1\uffff\1\10\1\2\1\4\1\5\1\6\1\uffff\1\7",
            "\1\11\4\uffff\1\3\1\uffff\1\10\1\2\1\4\1\5\1\6\1\uffff\1\7",
            "\1\11\4\uffff\1\3\1\uffff\1\10\1\2\1\4\1\5\1\6\1\22\1\7",
            "\1\20\1\21",
            "\2\23",
            "\1\11\6\uffff\1\10",
            "\1\24",
            "\1\20\1\21",
            "\1\11\4\uffff\1\3\1\uffff\1\10\1\2\1\4\1\5\1\6\1\uffff\1\7"
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
            return "()+ loopback of 66:4: ( markup )+";
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
    public static final BitSet FOLLOW_designator_in_markup96 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_arguments_in_markup98 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_designator106 = new BitSet(new long[]{0x000000000000F202L});
    public static final BitSet FOLLOW_attribute_in_designator108 = new BitSet(new long[]{0x000000000000F202L});
    public static final BitSet FOLLOW_12_in_attribute116 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_attribute126 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_attribute136 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_attribute146 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_attribute156 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NATCON_in_attribute158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_attribute166 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NATCON_in_attribute168 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_attribute170 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NATCON_in_attribute172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_arguments180 = new BitSet(new long[]{0x00000000000C0030L});
    public static final BitSet FOLLOW_argument_in_arguments182 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_arguments187 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_argument_in_arguments189 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_19_in_arguments195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_argument203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_expression0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_function226 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_function228 = new BitSet(new long[]{0x0000000005A20110L});
    public static final BitSet FOLLOW_formals_in_function230 = new BitSet(new long[]{0x0000000005A00110L});
    public static final BitSet FOLLOW_statement_in_function232 = new BitSet(new long[]{0x0000000005A00110L});
    public static final BitSet FOLLOW_8_in_function235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_formals242 = new BitSet(new long[]{0x00000000000C0010L});
    public static final BitSet FOLLOW_IDCON_in_formals244 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_formals249 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_formals251 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_19_in_formals256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_statement268 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_statement270 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_predicate_in_statement272 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_statement274 = new BitSet(new long[]{0x0000000005A00010L});
    public static final BitSet FOLLOW_statement_in_statement276 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_statement279 = new BitSet(new long[]{0x0000000005A00010L});
    public static final BitSet FOLLOW_statement_in_statement281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_statement291 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_statement293 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_statement295 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_statement297 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_expression_in_statement299 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_statement301 = new BitSet(new long[]{0x0000000005A00010L});
    public static final BitSet FOLLOW_statement_in_statement303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_statement311 = new BitSet(new long[]{0x0000000007A00010L});
    public static final BitSet FOLLOW_statement_in_statement313 = new BitSet(new long[]{0x0000000007A00010L});
    public static final BitSet FOLLOW_25_in_statement316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_statement324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement331 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_statement333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement341 = new BitSet(new long[]{0x0000000005A00010L});
    public static final BitSet FOLLOW_statement_in_statement344 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_statement346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement354 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_statement357 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_statement359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement367 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_expression_in_statement370 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_statement372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_synpred18_DebugWaebric279 = new BitSet(new long[]{0x0000000005A00010L});
    public static final BitSet FOLLOW_statement_in_synpred18_DebugWaebric281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred25_DebugWaebric341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred26_DebugWaebric341 = new BitSet(new long[]{0x0000000005A00010L});
    public static final BitSet FOLLOW_statement_in_synpred26_DebugWaebric344 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_synpred26_DebugWaebric346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred28_DebugWaebric354 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_synpred28_DebugWaebric357 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_synpred28_DebugWaebric359 = new BitSet(new long[]{0x0000000000000002L});

}