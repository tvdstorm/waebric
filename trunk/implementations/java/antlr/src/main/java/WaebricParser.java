// $ANTLR 3.1.2 /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g 2009-06-26 15:25:12

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class WaebricParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDCON", "NATCON", "TYPE", "WHITESPACE", "'module'", "'end'", "'.'", "'import'", "';'", "'site'", "'def'", "'('", "','", "')'", "'#'", "'$'", "':'", "'@'", "'%'", "'if'", "'else'", "'each'", "'let'", "'in'", "'{'", "'}'", "'echo'", "'cdata'", "'yield;'", "'='", "'!'"
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
    public static final int T__34=34;
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:12:1: module : 'module' moduleId ( moduleElement )* 'end' ;
    public final void module() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:12:7: ( 'module' moduleId ( moduleElement )* 'end' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:12:12: 'module' moduleId ( moduleElement )* 'end'
            {
            match(input,8,FOLLOW_8_in_module27); if (state.failed) return ;
            pushFollow(FOLLOW_moduleId_in_module29);
            moduleId();

            state._fsp--;
            if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:12:30: ( moduleElement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||(LA1_0>=13 && LA1_0<=14)) ) {
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


    // $ANTLR start "moduleId"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:13:1: moduleId : IDCON ( '.' IDCON )* ;
    public final void moduleId() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:13:9: ( IDCON ( '.' IDCON )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:13:12: IDCON ( '.' IDCON )*
            {
            match(input,IDCON,FOLLOW_IDCON_in_moduleId41); if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:13:18: ( '.' IDCON )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==10) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:13:20: '.' IDCON
            	    {
            	    match(input,10,FOLLOW_10_in_moduleId45); if (state.failed) return ;
            	    match(input,IDCON,FOLLOW_IDCON_in_moduleId47); if (state.failed) return ;

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
    // $ANTLR end "moduleId"


    // $ANTLR start "moduleElement"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:14:1: moduleElement : ( imprt | site | function );
    public final void moduleElement() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:14:14: ( imprt | site | function )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt3=1;
                }
                break;
            case 13:
                {
                alt3=2;
                }
                break;
            case 14:
                {
                alt3=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:14:17: imprt
                    {
                    pushFollow(FOLLOW_imprt_in_moduleElement57);
                    imprt();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:14:25: site
                    {
                    pushFollow(FOLLOW_site_in_moduleElement61);
                    site();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:14:32: function
                    {
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
        return ;
    }
    // $ANTLR end "moduleElement"


    // $ANTLR start "imprt"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:16:1: imprt : 'import' moduleId ';' ;
    public final void imprt() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:16:6: ( 'import' moduleId ';' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:16:10: 'import' moduleId ';'
            {
            match(input,11,FOLLOW_11_in_imprt74); if (state.failed) return ;
            pushFollow(FOLLOW_moduleId_in_imprt76);
            moduleId();

            state._fsp--;
            if (state.failed) return ;
            match(input,12,FOLLOW_12_in_imprt78); if (state.failed) return ;

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
    // $ANTLR end "imprt"


    // $ANTLR start "site"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:17:1: site : 'site' 'end' ;
    public final void site() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:17:5: ( 'site' 'end' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:17:9: 'site' 'end'
            {
            match(input,13,FOLLOW_13_in_site86); if (state.failed) return ;
            match(input,9,FOLLOW_9_in_site90); if (state.failed) return ;

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
    // $ANTLR end "site"


    // $ANTLR start "function"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:18:1: function : 'def' IDCON formals ( statement )* 'end' ;
    public final void function() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:18:9: ( 'def' IDCON formals ( statement )* 'end' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:18:12: 'def' IDCON formals ( statement )* 'end'
            {
            match(input,14,FOLLOW_14_in_function97); if (state.failed) return ;
            match(input,IDCON,FOLLOW_IDCON_in_function99); if (state.failed) return ;
            pushFollow(FOLLOW_formals_in_function101);
            formals();

            state._fsp--;
            if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:18:32: ( statement )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==IDCON||LA4_0==23||(LA4_0>=25 && LA4_0<=26)||LA4_0==28||(LA4_0>=30 && LA4_0<=32)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: statement
            	    {
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

            match(input,9,FOLLOW_9_in_function106); if (state.failed) return ;

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:19:1: formals : ( '(' ( IDCON )? ( ',' IDCON )* ')' | );
    public final void formals() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:19:8: ( '(' ( IDCON )? ( ',' IDCON )* ')' | )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==15) ) {
                alt7=1;
            }
            else if ( (LA7_0==IDCON||LA7_0==9||LA7_0==23||(LA7_0>=25 && LA7_0<=26)||LA7_0==28||(LA7_0>=30 && LA7_0<=32)) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:19:11: '(' ( IDCON )? ( ',' IDCON )* ')'
                    {
                    match(input,15,FOLLOW_15_in_formals113); if (state.failed) return ;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:19:15: ( IDCON )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==IDCON) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: IDCON
                            {
                            match(input,IDCON,FOLLOW_IDCON_in_formals115); if (state.failed) return ;

                            }
                            break;

                    }

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:19:22: ( ',' IDCON )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==16) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:19:24: ',' IDCON
                    	    {
                    	    match(input,16,FOLLOW_16_in_formals120); if (state.failed) return ;
                    	    match(input,IDCON,FOLLOW_IDCON_in_formals122); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    match(input,17,FOLLOW_17_in_formals127); if (state.failed) return ;

                    }
                    break;
                case 2 :
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
        return ;
    }
    // $ANTLR end "formals"


    // $ANTLR start "markup"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:21:1: markup : designator ( arguments )? ;
    public final void markup() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:30:7: ( designator ( arguments )? )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:30:11: designator ( arguments )?
            {
            pushFollow(FOLLOW_designator_in_markup143);
            designator();

            state._fsp--;
            if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:30:22: ( arguments )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==15) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: arguments
                    {
                    pushFollow(FOLLOW_arguments_in_markup145);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:31:1: designator : IDCON ( attribute )* ;
    public final void designator() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:31:11: ( IDCON ( attribute )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:31:14: IDCON ( attribute )*
            {
            match(input,IDCON,FOLLOW_IDCON_in_designator153); if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:31:20: ( attribute )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==10||(LA9_0>=18 && LA9_0<=21)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: attribute
            	    {
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:32:1: attribute : ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON );
    public final void attribute() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:32:10: ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON )
            int alt10=6;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt10=1;
                }
                break;
            case 10:
                {
                alt10=2;
                }
                break;
            case 19:
                {
                alt10=3;
                }
                break;
            case 20:
                {
                alt10=4;
                }
                break;
            case 21:
                {
                int LA10_5 = input.LA(2);

                if ( (LA10_5==NATCON) ) {
                    int LA10_6 = input.LA(3);

                    if ( (LA10_6==22) ) {
                        alt10=6;
                    }
                    else if ( (LA10_6==EOF||(LA10_6>=IDCON && LA10_6<=NATCON)||LA10_6==10||LA10_6==12||LA10_6==15||(LA10_6>=18 && LA10_6<=21)||LA10_6==23||(LA10_6>=25 && LA10_6<=26)||LA10_6==28||(LA10_6>=30 && LA10_6<=32)) ) {
                        alt10=5;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 5, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:32:13: '#' IDCON
                    {
                    match(input,18,FOLLOW_18_in_attribute163); if (state.failed) return ;
                    match(input,IDCON,FOLLOW_IDCON_in_attribute165); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:33:4: '.' IDCON
                    {
                    match(input,10,FOLLOW_10_in_attribute173); if (state.failed) return ;
                    match(input,IDCON,FOLLOW_IDCON_in_attribute175); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:34:4: '$' IDCON
                    {
                    match(input,19,FOLLOW_19_in_attribute183); if (state.failed) return ;
                    match(input,IDCON,FOLLOW_IDCON_in_attribute185); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:35:4: ':' IDCON
                    {
                    match(input,20,FOLLOW_20_in_attribute193); if (state.failed) return ;
                    match(input,IDCON,FOLLOW_IDCON_in_attribute195); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:36:4: '@' NATCON
                    {
                    match(input,21,FOLLOW_21_in_attribute203); if (state.failed) return ;
                    match(input,NATCON,FOLLOW_NATCON_in_attribute205); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:37:4: '@' NATCON '%' NATCON
                    {
                    match(input,21,FOLLOW_21_in_attribute213); if (state.failed) return ;
                    match(input,NATCON,FOLLOW_NATCON_in_attribute215); if (state.failed) return ;
                    match(input,22,FOLLOW_22_in_attribute217); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "attribute"


    // $ANTLR start "arguments"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:38:1: arguments : ( '(' ( argument )? ( ',' argument )* ')' ) ;
    public final void arguments() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:38:10: ( ( '(' ( argument )? ( ',' argument )* ')' ) )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:38:13: ( '(' ( argument )? ( ',' argument )* ')' )
            {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:38:13: ( '(' ( argument )? ( ',' argument )* ')' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:38:14: '(' ( argument )? ( ',' argument )* ')'
            {
            match(input,15,FOLLOW_15_in_arguments227); if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:38:18: ( argument )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=IDCON && LA11_0<=NATCON)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: argument
                    {
                    pushFollow(FOLLOW_argument_in_arguments229);
                    argument();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:38:28: ( ',' argument )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==16) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:38:30: ',' argument
            	    {
            	    match(input,16,FOLLOW_16_in_arguments234); if (state.failed) return ;
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

            match(input,17,FOLLOW_17_in_arguments242); if (state.failed) return ;

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:39:1: argument : expression ;
    public final void argument() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:39:9: ( expression )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:39:12: expression
            {
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
        return ;
    }
    // $ANTLR end "argument"


    // $ANTLR start "expression"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:42:1: expression : ( IDCON | NATCON );
    public final void expression() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:42:11: ( IDCON | NATCON )
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


    // $ANTLR start "statement"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:45:1: statement : ( 'if' '(' predicate ')' statement ( 'else' statement )? | 'each' '(' IDCON ':' expression ')' statement | 'let' ( assignment )+ 'in' ( statement )* 'end' | '{' ( statement )* '}' | 'echo' expression ';' | 'cdata' expression ';' | 'yield;' | markup ';' | ( markup )+ statement ';' | ( markup )+ markup ';' | ( markup )+ expression ';' );
    public final void statement() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:45:10: ( 'if' '(' predicate ')' statement ( 'else' statement )? | 'each' '(' IDCON ':' expression ')' statement | 'let' ( assignment )+ 'in' ( statement )* 'end' | '{' ( statement )* '}' | 'echo' expression ';' | 'cdata' expression ';' | 'yield;' | markup ';' | ( markup )+ statement ';' | ( markup )+ markup ';' | ( markup )+ expression ';' )
            int alt20=11;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:45:13: 'if' '(' predicate ')' statement ( 'else' statement )?
                    {
                    match(input,23,FOLLOW_23_in_statement273); if (state.failed) return ;
                    match(input,15,FOLLOW_15_in_statement275); if (state.failed) return ;
                    pushFollow(FOLLOW_predicate_in_statement277);
                    predicate();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,17,FOLLOW_17_in_statement279); if (state.failed) return ;
                    pushFollow(FOLLOW_statement_in_statement281);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:45:46: ( 'else' statement )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==24) ) {
                        int LA13_1 = input.LA(2);

                        if ( (synpred19_Waebric()) ) {
                            alt13=1;
                        }
                    }
                    switch (alt13) {
                        case 1 :
                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:45:47: 'else' statement
                            {
                            match(input,24,FOLLOW_24_in_statement284); if (state.failed) return ;
                            pushFollow(FOLLOW_statement_in_statement286);
                            statement();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:46:4: 'each' '(' IDCON ':' expression ')' statement
                    {
                    match(input,25,FOLLOW_25_in_statement296); if (state.failed) return ;
                    match(input,15,FOLLOW_15_in_statement298); if (state.failed) return ;
                    match(input,IDCON,FOLLOW_IDCON_in_statement300); if (state.failed) return ;
                    match(input,20,FOLLOW_20_in_statement302); if (state.failed) return ;
                    pushFollow(FOLLOW_expression_in_statement304);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,17,FOLLOW_17_in_statement306); if (state.failed) return ;
                    pushFollow(FOLLOW_statement_in_statement308);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:47:4: 'let' ( assignment )+ 'in' ( statement )* 'end'
                    {
                    match(input,26,FOLLOW_26_in_statement316); if (state.failed) return ;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:47:10: ( assignment )+
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
                                throw eee;
                        }
                        cnt14++;
                    } while (true);

                    match(input,27,FOLLOW_27_in_statement321); if (state.failed) return ;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:47:27: ( statement )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==IDCON||LA15_0==23||(LA15_0>=25 && LA15_0<=26)||LA15_0==28||(LA15_0>=30 && LA15_0<=32)) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: statement
                    	    {
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

                    match(input,9,FOLLOW_9_in_statement326); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:48:4: '{' ( statement )* '}'
                    {
                    match(input,28,FOLLOW_28_in_statement333); if (state.failed) return ;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:48:8: ( statement )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==IDCON||LA16_0==23||(LA16_0>=25 && LA16_0<=26)||LA16_0==28||(LA16_0>=30 && LA16_0<=32)) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: statement
                    	    {
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

                    match(input,29,FOLLOW_29_in_statement338); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:50:4: 'echo' expression ';'
                    {
                    match(input,30,FOLLOW_30_in_statement349); if (state.failed) return ;
                    pushFollow(FOLLOW_expression_in_statement351);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,12,FOLLOW_12_in_statement353); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:52:4: 'cdata' expression ';'
                    {
                    match(input,31,FOLLOW_31_in_statement364); if (state.failed) return ;
                    pushFollow(FOLLOW_expression_in_statement366);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,12,FOLLOW_12_in_statement368); if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:53:4: 'yield;'
                    {
                    match(input,32,FOLLOW_32_in_statement376); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:54:4: markup ';'
                    {
                    pushFollow(FOLLOW_markup_in_statement383);
                    markup();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,12,FOLLOW_12_in_statement385); if (state.failed) return ;

                    }
                    break;
                case 9 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:55:4: ( markup )+ statement ';'
                    {
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:55:4: ( markup )+
                    int cnt17=0;
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==IDCON) ) {
                            int LA17_2 = input.LA(2);

                            if ( (synpred31_Waebric()) ) {
                                alt17=1;
                            }


                        }


                        switch (alt17) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
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
                                throw eee;
                        }
                        cnt17++;
                    } while (true);

                    pushFollow(FOLLOW_statement_in_statement395);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,12,FOLLOW_12_in_statement397); if (state.failed) return ;

                    }
                    break;
                case 10 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:56:4: ( markup )+ markup ';'
                    {
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:56:4: ( markup )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        alt18 = dfa18.predict(input);
                        switch (alt18) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
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
                                throw eee;
                        }
                        cnt18++;
                    } while (true);

                    pushFollow(FOLLOW_markup_in_statement407);
                    markup();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,12,FOLLOW_12_in_statement409); if (state.failed) return ;

                    }
                    break;
                case 11 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:57:4: ( markup )+ expression ';'
                    {
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:57:4: ( markup )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==IDCON) ) {
                            int LA19_1 = input.LA(2);

                            if ( ((LA19_1>=IDCON && LA19_1<=NATCON)||LA19_1==10||LA19_1==15||(LA19_1>=18 && LA19_1<=21)) ) {
                                alt19=1;
                            }


                        }


                        switch (alt19) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
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
                                throw eee;
                        }
                        cnt19++;
                    } while (true);

                    pushFollow(FOLLOW_expression_in_statement419);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,12,FOLLOW_12_in_statement421); if (state.failed) return ;

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:58:1: assignment : ( IDCON '=' expression ';' | IDCON formals statement );
    public final void assignment() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:58:11: ( IDCON '=' expression ';' | IDCON formals statement )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==IDCON) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==33) ) {
                    alt21=1;
                }
                else if ( (LA21_1==IDCON||LA21_1==15||LA21_1==23||(LA21_1>=25 && LA21_1<=26)||LA21_1==28||(LA21_1>=30 && LA21_1<=32)) ) {
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:58:14: IDCON '=' expression ';'
                    {
                    match(input,IDCON,FOLLOW_IDCON_in_assignment429); if (state.failed) return ;
                    match(input,33,FOLLOW_33_in_assignment431); if (state.failed) return ;
                    pushFollow(FOLLOW_expression_in_assignment433);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,12,FOLLOW_12_in_assignment435); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:59:4: IDCON formals statement
                    {
                    match(input,IDCON,FOLLOW_IDCON_in_assignment443); if (state.failed) return ;
                    pushFollow(FOLLOW_formals_in_assignment445);
                    formals();

                    state._fsp--;
                    if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "assignment"


    // $ANTLR start "predicate"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:62:1: predicate : ( expression | expression '.' TYPE | '!' predicate );
    public final void predicate() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:62:10: ( expression | expression '.' TYPE | '!' predicate )
            int alt22=3;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=IDCON && LA22_0<=NATCON)) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==10) ) {
                    alt22=2;
                }
                else if ( (LA22_1==17) ) {
                    alt22=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA22_0==34) ) {
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:62:13: expression
                    {
                    pushFollow(FOLLOW_expression_in_predicate460);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:62:26: expression '.' TYPE
                    {
                    pushFollow(FOLLOW_expression_in_predicate464);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,10,FOLLOW_10_in_predicate466); if (state.failed) return ;
                    match(input,TYPE,FOLLOW_TYPE_in_predicate468); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:62:48: '!' predicate
                    {
                    match(input,34,FOLLOW_34_in_predicate472); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "predicate"

    // $ANTLR start synpred19_Waebric
    public final void synpred19_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:45:47: ( 'else' statement )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:45:47: 'else' statement
        {
        match(input,24,FOLLOW_24_in_synpred19_Waebric284); if (state.failed) return ;
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
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:55:4: markup
        {
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
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:55:4: ( markup )+ statement ';'
        {
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:55:4: ( markup )+
        int cnt29=0;
        loop29:
        do {
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==IDCON) ) {
                int LA29_2 = input.LA(2);

                if ( (synpred31_Waebric()) ) {
                    alt29=1;
                }


            }


            switch (alt29) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred32_Waebric392);
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

        pushFollow(FOLLOW_statement_in_synpred32_Waebric395);
        statement();

        state._fsp--;
        if (state.failed) return ;
        match(input,12,FOLLOW_12_in_synpred32_Waebric397); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_Waebric

    // $ANTLR start synpred34_Waebric
    public final void synpred34_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:56:4: ( ( markup )+ markup ';' )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:56:4: ( markup )+ markup ';'
        {
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:56:4: ( markup )+
        int cnt30=0;
        loop30:
        do {
            int alt30=2;
            alt30 = dfa30.predict(input);
            switch (alt30) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred34_Waebric404);
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

        pushFollow(FOLLOW_markup_in_synpred34_Waebric407);
        markup();

        state._fsp--;
        if (state.failed) return ;
        match(input,12,FOLLOW_12_in_synpred34_Waebric409); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred34_Waebric

    // Delegated rules

    public final boolean synpred19_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_Waebric_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_Waebric_fragment(); // can never throw exception
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
    public final boolean synpred32_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_Waebric_fragment(); // can never throw exception
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
        "\1\40\7\uffff\1\25\4\uffff";
    static final String DFA20_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\10\1\11\1\12\1\13";
    static final String DFA20_specialS =
        "\10\uffff\1\0\4\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\10\22\uffff\1\1\1\uffff\1\2\1\3\1\uffff\1\4\1\uffff\1\5\1"+
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
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA20_8 = input.LA(1);

                         
                        int index20_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_8==10||LA20_8==12||LA20_8==15||(LA20_8>=18 && LA20_8<=21)) ) {s = 9;}

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
        "\6\4\1\5\1\4\2\uffff\5\4\1\20\2\4\1\5\1\20\1\4";
    static final String DFA18_maxS =
        "\1\4\1\25\4\4\1\5\1\21\2\uffff\4\25\1\26\1\21\1\5\1\14\1\5\1\21"+
        "\1\25";
    static final String DFA18_acceptS =
        "\10\uffff\1\2\1\1\13\uffff";
    static final String DFA18_specialS =
        "\25\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\1",
            "\1\11\5\uffff\1\3\1\uffff\1\10\2\uffff\1\7\2\uffff\1\2\1\4"+
            "\1\5\1\6",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15",
            "\1\16",
            "\2\17\12\uffff\1\20\1\21",
            "",
            "",
            "\1\11\5\uffff\1\3\1\uffff\1\10\2\uffff\1\7\2\uffff\1\2\1\4"+
            "\1\5\1\6",
            "\1\11\5\uffff\1\3\1\uffff\1\10\2\uffff\1\7\2\uffff\1\2\1\4"+
            "\1\5\1\6",
            "\1\11\5\uffff\1\3\1\uffff\1\10\2\uffff\1\7\2\uffff\1\2\1\4"+
            "\1\5\1\6",
            "\1\11\5\uffff\1\3\1\uffff\1\10\2\uffff\1\7\2\uffff\1\2\1\4"+
            "\1\5\1\6",
            "\1\11\5\uffff\1\3\1\uffff\1\10\2\uffff\1\7\2\uffff\1\2\1\4"+
            "\1\5\1\6\1\22",
            "\1\20\1\21",
            "\2\23",
            "\1\11\7\uffff\1\10",
            "\1\24",
            "\1\20\1\21",
            "\1\11\5\uffff\1\3\1\uffff\1\10\2\uffff\1\7\2\uffff\1\2\1\4"+
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
    }
    static final String DFA30_eotS =
        "\25\uffff";
    static final String DFA30_eofS =
        "\25\uffff";
    static final String DFA30_minS =
        "\6\4\1\5\1\4\2\uffff\5\4\1\20\2\4\1\5\1\20\1\4";
    static final String DFA30_maxS =
        "\1\4\1\25\4\4\1\5\1\21\2\uffff\4\25\1\26\1\21\1\5\1\14\1\5\1\21"+
        "\1\25";
    static final String DFA30_acceptS =
        "\10\uffff\1\2\1\1\13\uffff";
    static final String DFA30_specialS =
        "\25\uffff}>";
    static final String[] DFA30_transitionS = {
            "\1\1",
            "\1\11\5\uffff\1\3\1\uffff\1\10\2\uffff\1\7\2\uffff\1\2\1\4"+
            "\1\5\1\6",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15",
            "\1\16",
            "\2\17\12\uffff\1\20\1\21",
            "",
            "",
            "\1\11\5\uffff\1\3\1\uffff\1\10\2\uffff\1\7\2\uffff\1\2\1\4"+
            "\1\5\1\6",
            "\1\11\5\uffff\1\3\1\uffff\1\10\2\uffff\1\7\2\uffff\1\2\1\4"+
            "\1\5\1\6",
            "\1\11\5\uffff\1\3\1\uffff\1\10\2\uffff\1\7\2\uffff\1\2\1\4"+
            "\1\5\1\6",
            "\1\11\5\uffff\1\3\1\uffff\1\10\2\uffff\1\7\2\uffff\1\2\1\4"+
            "\1\5\1\6",
            "\1\11\5\uffff\1\3\1\uffff\1\10\2\uffff\1\7\2\uffff\1\2\1\4"+
            "\1\5\1\6\1\22",
            "\1\20\1\21",
            "\2\23",
            "\1\11\7\uffff\1\10",
            "\1\24",
            "\1\20\1\21",
            "\1\11\5\uffff\1\3\1\uffff\1\10\2\uffff\1\7\2\uffff\1\2\1\4"+
            "\1\5\1\6"
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
            return "()+ loopback of 56:4: ( markup )+";
        }
    }
 

    public static final BitSet FOLLOW_8_in_module27 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_moduleId_in_module29 = new BitSet(new long[]{0x0000000000006A00L});
    public static final BitSet FOLLOW_moduleElement_in_module31 = new BitSet(new long[]{0x0000000000006A00L});
    public static final BitSet FOLLOW_9_in_module34 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_moduleId41 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_10_in_moduleId45 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_moduleId47 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_imprt_in_moduleElement57 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_site_in_moduleElement61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_moduleElement65 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_imprt74 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_moduleId_in_imprt76 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_imprt78 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_site86 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_site90 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_function97 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_function99 = new BitSet(new long[]{0x00000001D6808210L});
    public static final BitSet FOLLOW_formals_in_function101 = new BitSet(new long[]{0x00000001D6800210L});
    public static final BitSet FOLLOW_statement_in_function103 = new BitSet(new long[]{0x00000001D6800210L});
    public static final BitSet FOLLOW_9_in_function106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_formals113 = new BitSet(new long[]{0x0000000000030010L});
    public static final BitSet FOLLOW_IDCON_in_formals115 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_formals120 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_formals122 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_17_in_formals127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_designator_in_markup143 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_arguments_in_markup145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_designator153 = new BitSet(new long[]{0x00000000003C0402L});
    public static final BitSet FOLLOW_attribute_in_designator155 = new BitSet(new long[]{0x00000000003C0402L});
    public static final BitSet FOLLOW_18_in_attribute163 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_attribute173 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_attribute183 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_attribute193 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_attribute203 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NATCON_in_attribute205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_attribute213 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NATCON_in_attribute215 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_attribute217 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NATCON_in_attribute219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_arguments227 = new BitSet(new long[]{0x0000000000030030L});
    public static final BitSet FOLLOW_argument_in_arguments229 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_arguments234 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_argument_in_arguments236 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_17_in_arguments242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_argument250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_expression0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_statement273 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_statement275 = new BitSet(new long[]{0x0000000400000030L});
    public static final BitSet FOLLOW_predicate_in_statement277 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_statement279 = new BitSet(new long[]{0x00000001D6800010L});
    public static final BitSet FOLLOW_statement_in_statement281 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_statement284 = new BitSet(new long[]{0x00000001D6800010L});
    public static final BitSet FOLLOW_statement_in_statement286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_statement296 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_statement298 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_statement300 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_statement302 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_expression_in_statement304 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_statement306 = new BitSet(new long[]{0x00000001D6800010L});
    public static final BitSet FOLLOW_statement_in_statement308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_statement316 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_assignment_in_statement318 = new BitSet(new long[]{0x0000000008000010L});
    public static final BitSet FOLLOW_27_in_statement321 = new BitSet(new long[]{0x00000001D6800210L});
    public static final BitSet FOLLOW_statement_in_statement323 = new BitSet(new long[]{0x00000001D6800210L});
    public static final BitSet FOLLOW_9_in_statement326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_statement333 = new BitSet(new long[]{0x00000001F6800010L});
    public static final BitSet FOLLOW_statement_in_statement335 = new BitSet(new long[]{0x00000001F6800010L});
    public static final BitSet FOLLOW_29_in_statement338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_statement349 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_expression_in_statement351 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_statement353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_statement364 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_expression_in_statement366 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_statement368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_statement376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement383 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_statement385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement392 = new BitSet(new long[]{0x00000001D6800010L});
    public static final BitSet FOLLOW_statement_in_statement395 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_statement397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement404 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_statement407 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_statement409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement416 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_expression_in_statement419 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_statement421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_assignment429 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_assignment431 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_expression_in_assignment433 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_assignment435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_assignment443 = new BitSet(new long[]{0x00000001D6808010L});
    public static final BitSet FOLLOW_formals_in_assignment445 = new BitSet(new long[]{0x00000001D6800010L});
    public static final BitSet FOLLOW_statement_in_assignment447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate464 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_predicate466 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TYPE_in_predicate468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_predicate472 = new BitSet(new long[]{0x0000000400000030L});
    public static final BitSet FOLLOW_predicate_in_predicate474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_synpred19_Waebric284 = new BitSet(new long[]{0x00000001D6800010L});
    public static final BitSet FOLLOW_statement_in_synpred19_Waebric286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred31_Waebric392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred32_Waebric392 = new BitSet(new long[]{0x00000001D6800010L});
    public static final BitSet FOLLOW_statement_in_synpred32_Waebric395 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_synpred32_Waebric397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred34_Waebric404 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_synpred34_Waebric407 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_synpred34_Waebric409 = new BitSet(new long[]{0x0000000000000002L});

}