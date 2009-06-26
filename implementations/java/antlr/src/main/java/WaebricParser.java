// $ANTLR 3.1.2 /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g 2009-06-26 15:19:14

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class WaebricParser extends Parser {
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


        public WaebricParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public WaebricParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return WaebricParser.tokenNames; }
    public String getGrammarFileName() { return "/ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g"; }



    // $ANTLR start "module"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:12:1: module : 'module' moduleIdentifier ( moduleElement )* 'end' ;
    public final void module() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:12:7: ( 'module' moduleIdentifier ( moduleElement )* 'end' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:12:12: 'module' moduleIdentifier ( moduleElement )* 'end'
            {
            match(input,8,FOLLOW_8_in_module27); if (state.failed) return ;
            pushFollow(FOLLOW_moduleIdentifier_in_module29);
            moduleIdentifier();

            state._fsp--;
            if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:12:38: ( moduleElement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==21) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: moduleElement
            	    {
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

            match(input,9,FOLLOW_9_in_module34); if (state.failed) return ;

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:13:1: moduleIdentifier : IDCON ( '.' IDCON )* ;
    public final void moduleIdentifier() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:13:17: ( IDCON ( '.' IDCON )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:13:19: IDCON ( '.' IDCON )*
            {
            match(input,IDCON,FOLLOW_IDCON_in_moduleIdentifier40); if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:13:25: ( '.' IDCON )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==10) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:13:27: '.' IDCON
            	    {
            	    match(input,10,FOLLOW_10_in_moduleIdentifier44); if (state.failed) return ;
            	    match(input,IDCON,FOLLOW_IDCON_in_moduleIdentifier46); if (state.failed) return ;

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:14:1: moduleElement : ( moduleImport | function );
    public final void moduleElement() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:14:14: ( moduleImport | function )
            int alt3=2;
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

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:14:17: moduleImport
                    {
                    pushFollow(FOLLOW_moduleImport_in_moduleElement56);
                    moduleImport();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:14:32: function
                    {
                    pushFollow(FOLLOW_function_in_moduleElement60);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:15:1: moduleImport : 'import' moduleIdentifier ';' ;
    public final void moduleImport() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:15:13: ( 'import' moduleIdentifier ';' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:15:16: 'import' moduleIdentifier ';'
            {
            match(input,11,FOLLOW_11_in_moduleImport67); if (state.failed) return ;
            pushFollow(FOLLOW_moduleIdentifier_in_moduleImport69);
            moduleIdentifier();

            state._fsp--;
            if (state.failed) return ;
            match(input,12,FOLLOW_12_in_moduleImport71); if (state.failed) return ;

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:17:1: markup : designator ( arguments )? ;
    public final void markup() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:28:7: ( designator ( arguments )? )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:28:11: designator ( arguments )?
            {
            pushFollow(FOLLOW_designator_in_markup84);
            designator();

            state._fsp--;
            if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:28:22: ( arguments )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==18) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: arguments
                    {
                    pushFollow(FOLLOW_arguments_in_markup86);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:29:1: designator : IDCON ( attribute )* ;
    public final void designator() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:29:11: ( IDCON ( attribute )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:29:14: IDCON ( attribute )*
            {
            match(input,IDCON,FOLLOW_IDCON_in_designator94); if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:29:20: ( attribute )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==10||(LA5_0>=13 && LA5_0<=16)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: attribute
            	    {
            	    pushFollow(FOLLOW_attribute_in_designator96);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:30:1: attribute : ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON );
    public final void attribute() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:30:10: ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON )
            int alt6=6;
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:30:13: '#' IDCON
                    {
                    match(input,13,FOLLOW_13_in_attribute104); if (state.failed) return ;
                    match(input,IDCON,FOLLOW_IDCON_in_attribute106); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:31:4: '.' IDCON
                    {
                    match(input,10,FOLLOW_10_in_attribute114); if (state.failed) return ;
                    match(input,IDCON,FOLLOW_IDCON_in_attribute116); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:32:4: '$' IDCON
                    {
                    match(input,14,FOLLOW_14_in_attribute124); if (state.failed) return ;
                    match(input,IDCON,FOLLOW_IDCON_in_attribute126); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:33:4: ':' IDCON
                    {
                    match(input,15,FOLLOW_15_in_attribute134); if (state.failed) return ;
                    match(input,IDCON,FOLLOW_IDCON_in_attribute136); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:34:4: '@' NATCON
                    {
                    match(input,16,FOLLOW_16_in_attribute144); if (state.failed) return ;
                    match(input,NATCON,FOLLOW_NATCON_in_attribute146); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:35:4: '@' NATCON '%' NATCON
                    {
                    match(input,16,FOLLOW_16_in_attribute154); if (state.failed) return ;
                    match(input,NATCON,FOLLOW_NATCON_in_attribute156); if (state.failed) return ;
                    match(input,17,FOLLOW_17_in_attribute158); if (state.failed) return ;
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:36:1: arguments : ( '(' ( argument )? ( ',' argument )* ')' ) ;
    public final void arguments() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:36:10: ( ( '(' ( argument )? ( ',' argument )* ')' ) )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:36:13: ( '(' ( argument )? ( ',' argument )* ')' )
            {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:36:13: ( '(' ( argument )? ( ',' argument )* ')' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:36:14: '(' ( argument )? ( ',' argument )* ')'
            {
            match(input,18,FOLLOW_18_in_arguments168); if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:36:18: ( argument )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=IDCON && LA7_0<=NATCON)) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: argument
                    {
                    pushFollow(FOLLOW_argument_in_arguments170);
                    argument();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:36:28: ( ',' argument )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==19) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:36:30: ',' argument
            	    {
            	    match(input,19,FOLLOW_19_in_arguments175); if (state.failed) return ;
            	    pushFollow(FOLLOW_argument_in_arguments177);
            	    argument();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match(input,20,FOLLOW_20_in_arguments183); if (state.failed) return ;

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:37:1: argument : expression ;
    public final void argument() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:37:9: ( expression )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:37:12: expression
            {
            pushFollow(FOLLOW_expression_in_argument191);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:40:1: expression : ( IDCON | NATCON );
    public final void expression() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:40:11: ( IDCON | NATCON )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:43:1: function : 'def' IDCON formals ( statement )* 'end' ;
    public final void function() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:43:9: ( 'def' IDCON formals ( statement )* 'end' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:43:12: 'def' IDCON formals ( statement )* 'end'
            {
            match(input,21,FOLLOW_21_in_function214); if (state.failed) return ;
            match(input,IDCON,FOLLOW_IDCON_in_function216); if (state.failed) return ;
            pushFollow(FOLLOW_formals_in_function218);
            formals();

            state._fsp--;
            if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:43:32: ( statement )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==IDCON||LA9_0==22||(LA9_0>=24 && LA9_0<=25)||LA9_0==27||(LA9_0>=29 && LA9_0<=31)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_function220);
            	    statement();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            match(input,9,FOLLOW_9_in_function223); if (state.failed) return ;

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:44:1: formals : ( '(' ( IDCON )? ( ',' IDCON )* ')' | );
    public final void formals() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:44:8: ( '(' ( IDCON )? ( ',' IDCON )* ')' | )
            int alt12=2;
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

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:44:11: '(' ( IDCON )? ( ',' IDCON )* ')'
                    {
                    match(input,18,FOLLOW_18_in_formals230); if (state.failed) return ;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:44:15: ( IDCON )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==IDCON) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: IDCON
                            {
                            match(input,IDCON,FOLLOW_IDCON_in_formals232); if (state.failed) return ;

                            }
                            break;

                    }

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:44:22: ( ',' IDCON )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==19) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:44:24: ',' IDCON
                    	    {
                    	    match(input,19,FOLLOW_19_in_formals237); if (state.failed) return ;
                    	    match(input,IDCON,FOLLOW_IDCON_in_formals239); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    match(input,20,FOLLOW_20_in_formals244); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:44:43: 
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:47:1: statement : ( 'if' '(' predicate ')' statement ( 'else' statement )? | 'each' '(' IDCON ':' expression ')' statement | 'let' ( assignment )+ 'in' ( statement )* 'end' | '{' ( statement )* '}' | 'echo' expression ';' | 'cdata' expression ';' | 'yield;' | markup ';' | ( markup )+ statement ';' | ( markup )+ markup ';' | ( markup )+ expression ';' );
    public final void statement() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:47:10: ( 'if' '(' predicate ')' statement ( 'else' statement )? | 'each' '(' IDCON ':' expression ')' statement | 'let' ( assignment )+ 'in' ( statement )* 'end' | '{' ( statement )* '}' | 'echo' expression ';' | 'cdata' expression ';' | 'yield;' | markup ';' | ( markup )+ statement ';' | ( markup )+ markup ';' | ( markup )+ expression ';' )
            int alt20=11;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:47:13: 'if' '(' predicate ')' statement ( 'else' statement )?
                    {
                    match(input,22,FOLLOW_22_in_statement256); if (state.failed) return ;
                    match(input,18,FOLLOW_18_in_statement258); if (state.failed) return ;
                    pushFollow(FOLLOW_predicate_in_statement260);
                    predicate();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,20,FOLLOW_20_in_statement262); if (state.failed) return ;
                    pushFollow(FOLLOW_statement_in_statement264);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:47:46: ( 'else' statement )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==23) ) {
                        int LA13_1 = input.LA(2);

                        if ( (synpred18_Waebric()) ) {
                            alt13=1;
                        }
                    }
                    switch (alt13) {
                        case 1 :
                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:47:47: 'else' statement
                            {
                            match(input,23,FOLLOW_23_in_statement267); if (state.failed) return ;
                            pushFollow(FOLLOW_statement_in_statement269);
                            statement();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:48:4: 'each' '(' IDCON ':' expression ')' statement
                    {
                    match(input,24,FOLLOW_24_in_statement279); if (state.failed) return ;
                    match(input,18,FOLLOW_18_in_statement281); if (state.failed) return ;
                    match(input,IDCON,FOLLOW_IDCON_in_statement283); if (state.failed) return ;
                    match(input,15,FOLLOW_15_in_statement285); if (state.failed) return ;
                    pushFollow(FOLLOW_expression_in_statement287);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,20,FOLLOW_20_in_statement289); if (state.failed) return ;
                    pushFollow(FOLLOW_statement_in_statement291);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:49:4: 'let' ( assignment )+ 'in' ( statement )* 'end'
                    {
                    match(input,25,FOLLOW_25_in_statement299); if (state.failed) return ;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:49:10: ( assignment )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==IDCON) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: assignment
                    	    {
                    	    pushFollow(FOLLOW_assignment_in_statement301);
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
                                throw eee;
                        }
                        cnt14++;
                    } while (true);

                    match(input,26,FOLLOW_26_in_statement304); if (state.failed) return ;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:49:27: ( statement )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==IDCON||LA15_0==22||(LA15_0>=24 && LA15_0<=25)||LA15_0==27||(LA15_0>=29 && LA15_0<=31)) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_statement306);
                    	    statement();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    match(input,9,FOLLOW_9_in_statement309); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:50:4: '{' ( statement )* '}'
                    {
                    match(input,27,FOLLOW_27_in_statement316); if (state.failed) return ;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:50:8: ( statement )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==IDCON||LA16_0==22||(LA16_0>=24 && LA16_0<=25)||LA16_0==27||(LA16_0>=29 && LA16_0<=31)) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_statement318);
                    	    statement();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    match(input,28,FOLLOW_28_in_statement321); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:52:4: 'echo' expression ';'
                    {
                    match(input,29,FOLLOW_29_in_statement332); if (state.failed) return ;
                    pushFollow(FOLLOW_expression_in_statement334);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,12,FOLLOW_12_in_statement336); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:54:4: 'cdata' expression ';'
                    {
                    match(input,30,FOLLOW_30_in_statement347); if (state.failed) return ;
                    pushFollow(FOLLOW_expression_in_statement349);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,12,FOLLOW_12_in_statement351); if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:55:4: 'yield;'
                    {
                    match(input,31,FOLLOW_31_in_statement359); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:56:4: markup ';'
                    {
                    pushFollow(FOLLOW_markup_in_statement366);
                    markup();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,12,FOLLOW_12_in_statement368); if (state.failed) return ;

                    }
                    break;
                case 9 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:57:4: ( markup )+ statement ';'
                    {
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:57:4: ( markup )+
                    int cnt17=0;
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==IDCON) ) {
                            int LA17_2 = input.LA(2);

                            if ( (synpred30_Waebric()) ) {
                                alt17=1;
                            }


                        }


                        switch (alt17) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_statement375);
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

                    pushFollow(FOLLOW_statement_in_statement378);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,12,FOLLOW_12_in_statement380); if (state.failed) return ;

                    }
                    break;
                case 10 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:58:4: ( markup )+ markup ';'
                    {
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:58:4: ( markup )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        alt18 = dfa18.predict(input);
                        switch (alt18) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_statement387);
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
                                throw eee;
                        }
                        cnt18++;
                    } while (true);

                    pushFollow(FOLLOW_markup_in_statement390);
                    markup();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,12,FOLLOW_12_in_statement392); if (state.failed) return ;

                    }
                    break;
                case 11 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:59:4: ( markup )+ expression ';'
                    {
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:59:4: ( markup )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==IDCON) ) {
                            int LA19_1 = input.LA(2);

                            if ( ((LA19_1>=IDCON && LA19_1<=NATCON)||LA19_1==10||(LA19_1>=13 && LA19_1<=16)||LA19_1==18) ) {
                                alt19=1;
                            }


                        }


                        switch (alt19) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_statement399);
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
                                throw eee;
                        }
                        cnt19++;
                    } while (true);

                    pushFollow(FOLLOW_expression_in_statement402);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,12,FOLLOW_12_in_statement404); if (state.failed) return ;

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


    // $ANTLR start "assignment"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:60:1: assignment : ( IDCON '=' expression ';' | IDCON formals statement );
    public final void assignment() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:60:11: ( IDCON '=' expression ';' | IDCON formals statement )
            int alt21=2;
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

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:60:14: IDCON '=' expression ';'
                    {
                    match(input,IDCON,FOLLOW_IDCON_in_assignment412); if (state.failed) return ;
                    match(input,32,FOLLOW_32_in_assignment414); if (state.failed) return ;
                    pushFollow(FOLLOW_expression_in_assignment416);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,12,FOLLOW_12_in_assignment418); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:61:4: IDCON formals statement
                    {
                    match(input,IDCON,FOLLOW_IDCON_in_assignment426); if (state.failed) return ;
                    pushFollow(FOLLOW_formals_in_assignment428);
                    formals();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_statement_in_assignment430);
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
        return ;
    }
    // $ANTLR end "assignment"


    // $ANTLR start "predicate"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:64:1: predicate : ( expression | expression '.' TYPE | '!' predicate );
    public final void predicate() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:64:10: ( expression | expression '.' TYPE | '!' predicate )
            int alt22=3;
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

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:64:13: expression
                    {
                    pushFollow(FOLLOW_expression_in_predicate443);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:64:26: expression '.' TYPE
                    {
                    pushFollow(FOLLOW_expression_in_predicate447);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,10,FOLLOW_10_in_predicate449); if (state.failed) return ;
                    match(input,TYPE,FOLLOW_TYPE_in_predicate451); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:64:48: '!' predicate
                    {
                    match(input,33,FOLLOW_33_in_predicate455); if (state.failed) return ;
                    pushFollow(FOLLOW_predicate_in_predicate457);
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
        return ;
    }
    // $ANTLR end "predicate"

    // $ANTLR start synpred18_Waebric
    public final void synpred18_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:47:47: ( 'else' statement )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:47:47: 'else' statement
        {
        match(input,23,FOLLOW_23_in_synpred18_Waebric267); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred18_Waebric269);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_Waebric

    // $ANTLR start synpred30_Waebric
    public final void synpred30_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:57:4: ( markup )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:57:4: markup
        {
        pushFollow(FOLLOW_markup_in_synpred30_Waebric375);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_Waebric

    // $ANTLR start synpred31_Waebric
    public final void synpred31_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:57:4: ( ( markup )+ statement ';' )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:57:4: ( markup )+ statement ';'
        {
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:57:4: ( markup )+
        int cnt29=0;
        loop29:
        do {
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==IDCON) ) {
                int LA29_2 = input.LA(2);

                if ( (synpred30_Waebric()) ) {
                    alt29=1;
                }


            }


            switch (alt29) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred31_Waebric375);
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
                    throw eee;
            }
            cnt29++;
        } while (true);

        pushFollow(FOLLOW_statement_in_synpred31_Waebric378);
        statement();

        state._fsp--;
        if (state.failed) return ;
        match(input,12,FOLLOW_12_in_synpred31_Waebric380); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_Waebric

    // $ANTLR start synpred33_Waebric
    public final void synpred33_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:58:4: ( ( markup )+ markup ';' )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:58:4: ( markup )+ markup ';'
        {
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:58:4: ( markup )+
        int cnt30=0;
        loop30:
        do {
            int alt30=2;
            alt30 = dfa30.predict(input);
            switch (alt30) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred33_Waebric387);
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
                    throw eee;
            }
            cnt30++;
        } while (true);

        pushFollow(FOLLOW_markup_in_synpred33_Waebric390);
        markup();

        state._fsp--;
        if (state.failed) return ;
        match(input,12,FOLLOW_12_in_synpred33_Waebric392); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred33_Waebric

    // Delegated rules

    public final boolean synpred30_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_Waebric_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_Waebric_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_Waebric_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_Waebric_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
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
            return "47:1: statement : ( 'if' '(' predicate ')' statement ( 'else' statement )? | 'each' '(' IDCON ':' expression ')' statement | 'let' ( assignment )+ 'in' ( statement )* 'end' | '{' ( statement )* '}' | 'echo' expression ';' | 'cdata' expression ';' | 'yield;' | markup ';' | ( markup )+ statement ';' | ( markup )+ markup ';' | ( markup )+ expression ';' );";
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

                        else if ( (synpred31_Waebric()) ) {s = 10;}

                        else if ( (synpred33_Waebric()) ) {s = 11;}

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
            return "()+ loopback of 58:4: ( markup )+";
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
            return "()+ loopback of 58:4: ( markup )+";
        }
    }
 

    public static final BitSet FOLLOW_8_in_module27 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_moduleIdentifier_in_module29 = new BitSet(new long[]{0x0000000000200A00L});
    public static final BitSet FOLLOW_moduleElement_in_module31 = new BitSet(new long[]{0x0000000000200A00L});
    public static final BitSet FOLLOW_9_in_module34 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_moduleIdentifier40 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_10_in_moduleIdentifier44 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_moduleIdentifier46 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_moduleImport_in_moduleElement56 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_moduleElement60 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_moduleImport67 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_moduleIdentifier_in_moduleImport69 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_moduleImport71 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_designator_in_markup84 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_arguments_in_markup86 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_designator94 = new BitSet(new long[]{0x000000000001E402L});
    public static final BitSet FOLLOW_attribute_in_designator96 = new BitSet(new long[]{0x000000000001E402L});
    public static final BitSet FOLLOW_13_in_attribute104 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_attribute114 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_attribute124 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_attribute134 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_attribute144 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NATCON_in_attribute146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_attribute154 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NATCON_in_attribute156 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_attribute158 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NATCON_in_attribute160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_arguments168 = new BitSet(new long[]{0x0000000000180030L});
    public static final BitSet FOLLOW_argument_in_arguments170 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_19_in_arguments175 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_argument_in_arguments177 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_20_in_arguments183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_argument191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_expression0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_function214 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_function216 = new BitSet(new long[]{0x00000000EB440210L});
    public static final BitSet FOLLOW_formals_in_function218 = new BitSet(new long[]{0x00000000EB400210L});
    public static final BitSet FOLLOW_statement_in_function220 = new BitSet(new long[]{0x00000000EB400210L});
    public static final BitSet FOLLOW_9_in_function223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_formals230 = new BitSet(new long[]{0x0000000000180010L});
    public static final BitSet FOLLOW_IDCON_in_formals232 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_19_in_formals237 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_formals239 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_20_in_formals244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_statement256 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_statement258 = new BitSet(new long[]{0x0000000200000030L});
    public static final BitSet FOLLOW_predicate_in_statement260 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_statement262 = new BitSet(new long[]{0x00000000EB400010L});
    public static final BitSet FOLLOW_statement_in_statement264 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_statement267 = new BitSet(new long[]{0x00000000EB400010L});
    public static final BitSet FOLLOW_statement_in_statement269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_statement279 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_statement281 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_statement283 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_statement285 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_expression_in_statement287 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_statement289 = new BitSet(new long[]{0x00000000EB400010L});
    public static final BitSet FOLLOW_statement_in_statement291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_statement299 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_assignment_in_statement301 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_26_in_statement304 = new BitSet(new long[]{0x00000000EB400210L});
    public static final BitSet FOLLOW_statement_in_statement306 = new BitSet(new long[]{0x00000000EB400210L});
    public static final BitSet FOLLOW_9_in_statement309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_statement316 = new BitSet(new long[]{0x00000000FB400010L});
    public static final BitSet FOLLOW_statement_in_statement318 = new BitSet(new long[]{0x00000000FB400010L});
    public static final BitSet FOLLOW_28_in_statement321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_statement332 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_expression_in_statement334 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_statement336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_statement347 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_expression_in_statement349 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_statement351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_statement359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement366 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_statement368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement375 = new BitSet(new long[]{0x00000000EB400010L});
    public static final BitSet FOLLOW_statement_in_statement378 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_statement380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement387 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_statement390 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_statement392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement399 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_expression_in_statement402 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_statement404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_assignment412 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_assignment414 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_expression_in_assignment416 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_assignment418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_assignment426 = new BitSet(new long[]{0x00000000EB440010L});
    public static final BitSet FOLLOW_formals_in_assignment428 = new BitSet(new long[]{0x00000000EB400010L});
    public static final BitSet FOLLOW_statement_in_assignment430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate447 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_predicate449 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TYPE_in_predicate451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_predicate455 = new BitSet(new long[]{0x0000000200000030L});
    public static final BitSet FOLLOW_predicate_in_predicate457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_synpred18_Waebric267 = new BitSet(new long[]{0x00000000EB400010L});
    public static final BitSet FOLLOW_statement_in_synpred18_Waebric269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred30_Waebric375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred31_Waebric375 = new BitSet(new long[]{0x00000000EB400010L});
    public static final BitSet FOLLOW_statement_in_synpred31_Waebric378 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_synpred31_Waebric380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred33_Waebric387 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_synpred33_Waebric390 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_synpred33_Waebric392 = new BitSet(new long[]{0x0000000000000002L});

}