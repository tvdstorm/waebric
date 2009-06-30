// $ANTLR 3.1.2 /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g 2009-06-30 13:47:15
 package org.cwi.waebric; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class WaebricParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "MODULE", "IMPORT", "SITE", "DEF", "END", "IF", "ELSE", "EACH", "LET", "IN", "COMMENT", "ECHO", "CDATA", "YIELD", "LIST", "RECORD", "STRING", "IDCON", "PATH", "NATCON", "TEXT", "STRCON", "TEXTCHAR", "LETTER", "DIGIT", "HEXADECIMAL", "PATHELEMENT", "FILEEXT", "SYMBOLCHAR", "SYMBOLCON", "ESCQUOTE", "AMP", "CHARREF", "ENTREF", "LAYOUT", "STRCHAR", "ESCLAYOUT", "DECIMAL", "COMMENTS", "'.'", "';'", "':'", "'#'", "'$'", "'@'", "'%'", "'('", "','", "')'", "'+'", "'['", "']'", "'{'", "'}'", "'yield;'", "'='", "'!'", "'&&'", "'||'", "'\"'", "'<'", "'>'"
    };
    public static final int ESCLAYOUT=40;
    public static final int DEF=7;
    public static final int T__57=57;
    public static final int END=8;
    public static final int LIST=18;
    public static final int FILEEXT=31;
    public static final int T__51=51;
    public static final int T__47=47;
    public static final int STRCHAR=39;
    public static final int T__50=50;
    public static final int T__65=65;
    public static final int SYMBOLCON=33;
    public static final int COMMENTS=42;
    public static final int DECIMAL=41;
    public static final int IDCON=21;
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
    public static final int T__55=55;
    public static final int T__45=45;
    public static final int IN=13;
    public static final int CHARREF=36;
    public static final int T__63=63;
    public static final int ELSE=10;
    public static final int T__43=43;
    public static final int IF=9;
    public static final int LET=12;
    public static final int EOF=-1;
    public static final int T__53=53;
    public static final int TEXT=24;
    public static final int NATCON=23;
    public static final int T__60=60;
    public static final int EACH=11;
    public static final int PATH=22;

    // delegates
    // delegators


        public WaebricParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public WaebricParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return WaebricParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g"; }


    public static class module_return extends ParserRuleReturnScope {
        public String result = "lol ";
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "module"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:34:1: module returns [String result = \"lol \"] : 'module' id= moduleId (e= moduleElement )* 'end' EOF ;
    public final WaebricParser.module_return module() throws RecognitionException {
        WaebricParser.module_return retval = new WaebricParser.module_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal1=null;
        Token string_literal2=null;
        Token EOF3=null;
        WaebricParser.moduleId_return id = null;

        WaebricParser.moduleElement_return e = null;


        Object string_literal1_tree=null;
        Object string_literal2_tree=null;
        Object EOF3_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:35:2: ( 'module' id= moduleId (e= moduleElement )* 'end' EOF )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:35:6: 'module' id= moduleId (e= moduleElement )* 'end' EOF
            {
            root_0 = (Object)adaptor.nil();

            string_literal1=(Token)match(input,MODULE,FOLLOW_MODULE_in_module226); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal1_tree = (Object)adaptor.create(string_literal1);
            adaptor.addChild(root_0, string_literal1_tree);
            }
            pushFollow(FOLLOW_moduleId_in_module236);
            id=moduleId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, id.getTree());
            if ( state.backtracking==0 ) {
               retval.result += id.toString(); 
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:37:4: (e= moduleElement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=IMPORT && LA1_0<=DEF)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:37:6: e= moduleElement
            	    {
            	    pushFollow(FOLLOW_moduleElement_in_module250);
            	    e=moduleElement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            	    if ( state.backtracking==0 ) {
            	       retval.result += e.toString(); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            string_literal2=(Token)match(input,END,FOLLOW_END_in_module261); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal2_tree = (Object)adaptor.create(string_literal2);
            adaptor.addChild(root_0, string_literal2_tree);
            }
            EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_module263); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EOF3_tree = (Object)adaptor.create(EOF3);
            adaptor.addChild(root_0, EOF3_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "module"

    public static class moduleId_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "moduleId"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:40:1: moduleId : IDCON ( '.' IDCON )* ;
    public final WaebricParser.moduleId_return moduleId() throws RecognitionException {
        WaebricParser.moduleId_return retval = new WaebricParser.moduleId_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDCON4=null;
        Token char_literal5=null;
        Token IDCON6=null;

        Object IDCON4_tree=null;
        Object char_literal5_tree=null;
        Object IDCON6_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:40:9: ( IDCON ( '.' IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:40:12: IDCON ( '.' IDCON )*
            {
            root_0 = (Object)adaptor.nil();

            IDCON4=(Token)match(input,IDCON,FOLLOW_IDCON_in_moduleId273); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON4_tree = (Object)adaptor.create(IDCON4);
            adaptor.addChild(root_0, IDCON4_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:40:18: ( '.' IDCON )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==43) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:40:20: '.' IDCON
            	    {
            	    char_literal5=(Token)match(input,43,FOLLOW_43_in_moduleId277); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal5_tree = (Object)adaptor.create(char_literal5);
            	    adaptor.addChild(root_0, char_literal5_tree);
            	    }
            	    IDCON6=(Token)match(input,IDCON,FOLLOW_IDCON_in_moduleId279); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDCON6_tree = (Object)adaptor.create(IDCON6);
            	    adaptor.addChild(root_0, IDCON6_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "moduleId"

    public static class moduleElement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "moduleElement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:41:1: moduleElement : ( imprt | site | function );
    public final WaebricParser.moduleElement_return moduleElement() throws RecognitionException {
        WaebricParser.moduleElement_return retval = new WaebricParser.moduleElement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WaebricParser.imprt_return imprt7 = null;

        WaebricParser.site_return site8 = null;

        WaebricParser.function_return function9 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:41:14: ( imprt | site | function )
            int alt3=3;
            switch ( input.LA(1) ) {
            case IMPORT:
                {
                alt3=1;
                }
                break;
            case SITE:
                {
                alt3=2;
                }
                break;
            case DEF:
                {
                alt3=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:41:17: imprt
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_imprt_in_moduleElement290);
                    imprt7=imprt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, imprt7.getTree());

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:41:25: site
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_site_in_moduleElement294);
                    site8=site();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, site8.getTree());

                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:41:32: function
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_function_in_moduleElement298);
                    function9=function();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, function9.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "moduleElement"

    public static class imprt_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "imprt"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:42:1: imprt : 'import' moduleId ';' ;
    public final WaebricParser.imprt_return imprt() throws RecognitionException {
        WaebricParser.imprt_return retval = new WaebricParser.imprt_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal10=null;
        Token char_literal12=null;
        WaebricParser.moduleId_return moduleId11 = null;


        Object string_literal10_tree=null;
        Object char_literal12_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:42:6: ( 'import' moduleId ';' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:42:10: 'import' moduleId ';'
            {
            root_0 = (Object)adaptor.nil();

            string_literal10=(Token)match(input,IMPORT,FOLLOW_IMPORT_in_imprt307); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal10_tree = (Object)adaptor.create(string_literal10);
            adaptor.addChild(root_0, string_literal10_tree);
            }
            pushFollow(FOLLOW_moduleId_in_imprt309);
            moduleId11=moduleId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, moduleId11.getTree());
            char_literal12=(Token)match(input,44,FOLLOW_44_in_imprt311); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal12_tree = (Object)adaptor.create(char_literal12);
            adaptor.addChild(root_0, char_literal12_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "imprt"

    public static class site_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "site"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:44:1: site : 'site' mappings 'end' ;
    public final WaebricParser.site_return site() throws RecognitionException {
        WaebricParser.site_return retval = new WaebricParser.site_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal13=null;
        Token string_literal15=null;
        WaebricParser.mappings_return mappings14 = null;


        Object string_literal13_tree=null;
        Object string_literal15_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:44:5: ( 'site' mappings 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:44:9: 'site' mappings 'end'
            {
            root_0 = (Object)adaptor.nil();

            string_literal13=(Token)match(input,SITE,FOLLOW_SITE_in_site321); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal13_tree = (Object)adaptor.create(string_literal13);
            adaptor.addChild(root_0, string_literal13_tree);
            }
            pushFollow(FOLLOW_mappings_in_site323);
            mappings14=mappings();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mappings14.getTree());
            string_literal15=(Token)match(input,END,FOLLOW_END_in_site325); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal15_tree = (Object)adaptor.create(string_literal15);
            adaptor.addChild(root_0, string_literal15_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "site"

    public static class mappings_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mappings"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:45:1: mappings : ( mapping )? ( ';' mapping )* ;
    public final WaebricParser.mappings_return mappings() throws RecognitionException {
        WaebricParser.mappings_return retval = new WaebricParser.mappings_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal17=null;
        WaebricParser.mapping_return mapping16 = null;

        WaebricParser.mapping_return mapping18 = null;


        Object char_literal17_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:45:9: ( ( mapping )? ( ';' mapping )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:45:12: ( mapping )? ( ';' mapping )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:45:12: ( mapping )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==PATH) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: mapping
                    {
                    pushFollow(FOLLOW_mapping_in_mappings333);
                    mapping16=mapping();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, mapping16.getTree());

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:45:21: ( ';' mapping )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==44) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:45:23: ';' mapping
            	    {
            	    char_literal17=(Token)match(input,44,FOLLOW_44_in_mappings338); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal17_tree = (Object)adaptor.create(char_literal17);
            	    adaptor.addChild(root_0, char_literal17_tree);
            	    }
            	    pushFollow(FOLLOW_mapping_in_mappings340);
            	    mapping18=mapping();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, mapping18.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "mappings"

    public static class mapping_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mapping"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:46:1: mapping : PATH ':' markup ;
    public final WaebricParser.mapping_return mapping() throws RecognitionException {
        WaebricParser.mapping_return retval = new WaebricParser.mapping_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PATH19=null;
        Token char_literal20=null;
        WaebricParser.markup_return markup21 = null;


        Object PATH19_tree=null;
        Object char_literal20_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:46:9: ( PATH ':' markup )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:46:12: PATH ':' markup
            {
            root_0 = (Object)adaptor.nil();

            PATH19=(Token)match(input,PATH,FOLLOW_PATH_in_mapping352); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PATH19_tree = (Object)adaptor.create(PATH19);
            adaptor.addChild(root_0, PATH19_tree);
            }
            char_literal20=(Token)match(input,45,FOLLOW_45_in_mapping354); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal20_tree = (Object)adaptor.create(char_literal20);
            adaptor.addChild(root_0, char_literal20_tree);
            }
            pushFollow(FOLLOW_markup_in_mapping356);
            markup21=markup();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, markup21.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "mapping"

    public static class markup_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "markup"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:48:1: markup : ( designator arguments | designator );
    public final WaebricParser.markup_return markup() throws RecognitionException {
        WaebricParser.markup_return retval = new WaebricParser.markup_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WaebricParser.designator_return designator22 = null;

        WaebricParser.arguments_return arguments23 = null;

        WaebricParser.designator_return designator24 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:48:7: ( designator arguments | designator )
            int alt6=2;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:48:11: designator arguments
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_designator_in_markup366);
                    designator22=designator();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, designator22.getTree());
                    pushFollow(FOLLOW_arguments_in_markup368);
                    arguments23=arguments();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arguments23.getTree());

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:48:34: designator
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_designator_in_markup372);
                    designator24=designator();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, designator24.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "markup"

    public static class designator_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "designator"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:49:1: designator : IDCON ( attribute )* ;
    public final WaebricParser.designator_return designator() throws RecognitionException {
        WaebricParser.designator_return retval = new WaebricParser.designator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDCON25=null;
        WaebricParser.attribute_return attribute26 = null;


        Object IDCON25_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:49:11: ( IDCON ( attribute )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:49:14: IDCON ( attribute )*
            {
            root_0 = (Object)adaptor.nil();

            IDCON25=(Token)match(input,IDCON,FOLLOW_IDCON_in_designator380); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON25_tree = (Object)adaptor.create(IDCON25);
            adaptor.addChild(root_0, IDCON25_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:49:20: ( attribute )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==43||(LA7_0>=45 && LA7_0<=48)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: attribute
            	    {
            	    pushFollow(FOLLOW_attribute_in_designator382);
            	    attribute26=attribute();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, attribute26.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "designator"

    public static class attribute_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attribute"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:50:1: attribute : ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON );
    public final WaebricParser.attribute_return attribute() throws RecognitionException {
        WaebricParser.attribute_return retval = new WaebricParser.attribute_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal27=null;
        Token IDCON28=null;
        Token char_literal29=null;
        Token IDCON30=null;
        Token char_literal31=null;
        Token IDCON32=null;
        Token char_literal33=null;
        Token IDCON34=null;
        Token char_literal35=null;
        Token NATCON36=null;
        Token char_literal37=null;
        Token NATCON38=null;
        Token char_literal39=null;
        Token NATCON40=null;

        Object char_literal27_tree=null;
        Object IDCON28_tree=null;
        Object char_literal29_tree=null;
        Object IDCON30_tree=null;
        Object char_literal31_tree=null;
        Object IDCON32_tree=null;
        Object char_literal33_tree=null;
        Object IDCON34_tree=null;
        Object char_literal35_tree=null;
        Object NATCON36_tree=null;
        Object char_literal37_tree=null;
        Object NATCON38_tree=null;
        Object char_literal39_tree=null;
        Object NATCON40_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:50:10: ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON )
            int alt8=6;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt8=1;
                }
                break;
            case 43:
                {
                alt8=2;
                }
                break;
            case 47:
                {
                alt8=3;
                }
                break;
            case 45:
                {
                alt8=4;
                }
                break;
            case 48:
                {
                int LA8_5 = input.LA(2);

                if ( (LA8_5==NATCON) ) {
                    int LA8_6 = input.LA(3);

                    if ( (LA8_6==49) ) {
                        alt8=6;
                    }
                    else if ( (LA8_6==EOF||(LA8_6>=END && LA8_6<=IF)||(LA8_6>=EACH && LA8_6<=LET)||(LA8_6>=ECHO && LA8_6<=CDATA)||LA8_6==IDCON||(LA8_6>=NATCON && LA8_6<=STRCON)||(LA8_6>=43 && LA8_6<=48)||LA8_6==50||LA8_6==56||LA8_6==58||LA8_6==65) ) {
                        alt8=5;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 5, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:50:13: '#' IDCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal27=(Token)match(input,46,FOLLOW_46_in_attribute391); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal27_tree = (Object)adaptor.create(char_literal27);
                    adaptor.addChild(root_0, char_literal27_tree);
                    }
                    IDCON28=(Token)match(input,IDCON,FOLLOW_IDCON_in_attribute393); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON28_tree = (Object)adaptor.create(IDCON28);
                    adaptor.addChild(root_0, IDCON28_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:50:25: '.' IDCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal29=(Token)match(input,43,FOLLOW_43_in_attribute397); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal29_tree = (Object)adaptor.create(char_literal29);
                    adaptor.addChild(root_0, char_literal29_tree);
                    }
                    IDCON30=(Token)match(input,IDCON,FOLLOW_IDCON_in_attribute399); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON30_tree = (Object)adaptor.create(IDCON30);
                    adaptor.addChild(root_0, IDCON30_tree);
                    }

                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:50:37: '$' IDCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal31=(Token)match(input,47,FOLLOW_47_in_attribute403); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal31_tree = (Object)adaptor.create(char_literal31);
                    adaptor.addChild(root_0, char_literal31_tree);
                    }
                    IDCON32=(Token)match(input,IDCON,FOLLOW_IDCON_in_attribute405); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON32_tree = (Object)adaptor.create(IDCON32);
                    adaptor.addChild(root_0, IDCON32_tree);
                    }

                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:50:49: ':' IDCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal33=(Token)match(input,45,FOLLOW_45_in_attribute409); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal33_tree = (Object)adaptor.create(char_literal33);
                    adaptor.addChild(root_0, char_literal33_tree);
                    }
                    IDCON34=(Token)match(input,IDCON,FOLLOW_IDCON_in_attribute411); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON34_tree = (Object)adaptor.create(IDCON34);
                    adaptor.addChild(root_0, IDCON34_tree);
                    }

                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:51:4: '@' NATCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal35=(Token)match(input,48,FOLLOW_48_in_attribute419); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal35_tree = (Object)adaptor.create(char_literal35);
                    adaptor.addChild(root_0, char_literal35_tree);
                    }
                    NATCON36=(Token)match(input,NATCON,FOLLOW_NATCON_in_attribute421); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON36_tree = (Object)adaptor.create(NATCON36);
                    adaptor.addChild(root_0, NATCON36_tree);
                    }

                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:51:17: '@' NATCON '%' NATCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal37=(Token)match(input,48,FOLLOW_48_in_attribute425); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal37_tree = (Object)adaptor.create(char_literal37);
                    adaptor.addChild(root_0, char_literal37_tree);
                    }
                    NATCON38=(Token)match(input,NATCON,FOLLOW_NATCON_in_attribute427); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON38_tree = (Object)adaptor.create(NATCON38);
                    adaptor.addChild(root_0, NATCON38_tree);
                    }
                    char_literal39=(Token)match(input,49,FOLLOW_49_in_attribute429); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal39_tree = (Object)adaptor.create(char_literal39);
                    adaptor.addChild(root_0, char_literal39_tree);
                    }
                    NATCON40=(Token)match(input,NATCON,FOLLOW_NATCON_in_attribute431); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON40_tree = (Object)adaptor.create(NATCON40);
                    adaptor.addChild(root_0, NATCON40_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "attribute"

    public static class arguments_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arguments"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:52:1: arguments : '(' ( argument )? ( ',' argument )* ')' ;
    public final WaebricParser.arguments_return arguments() throws RecognitionException {
        WaebricParser.arguments_return retval = new WaebricParser.arguments_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal41=null;
        Token char_literal43=null;
        Token char_literal45=null;
        WaebricParser.argument_return argument42 = null;

        WaebricParser.argument_return argument44 = null;


        Object char_literal41_tree=null;
        Object char_literal43_tree=null;
        Object char_literal45_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:52:10: ( '(' ( argument )? ( ',' argument )* ')' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:52:13: '(' ( argument )? ( ',' argument )* ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal41=(Token)match(input,50,FOLLOW_50_in_arguments438); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal41_tree = (Object)adaptor.create(char_literal41);
            adaptor.addChild(root_0, char_literal41_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:52:17: ( argument )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==IDCON||(LA9_0>=NATCON && LA9_0<=TEXT)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: argument
                    {
                    pushFollow(FOLLOW_argument_in_arguments440);
                    argument42=argument();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, argument42.getTree());

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:52:27: ( ',' argument )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==51) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:52:29: ',' argument
            	    {
            	    char_literal43=(Token)match(input,51,FOLLOW_51_in_arguments445); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal43_tree = (Object)adaptor.create(char_literal43);
            	    adaptor.addChild(root_0, char_literal43_tree);
            	    }
            	    pushFollow(FOLLOW_argument_in_arguments447);
            	    argument44=argument();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, argument44.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            char_literal45=(Token)match(input,52,FOLLOW_52_in_arguments452); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal45_tree = (Object)adaptor.create(char_literal45);
            adaptor.addChild(root_0, char_literal45_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "arguments"

    public static class argument_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "argument"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:53:1: argument : expression ;
    public final WaebricParser.argument_return argument() throws RecognitionException {
        WaebricParser.argument_return retval = new WaebricParser.argument_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WaebricParser.expression_return expression46 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:53:9: ( expression )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:53:12: expression
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_expression_in_argument461);
            expression46=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression46.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "argument"

    public static class expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:55:1: expression : ( IDCON | NATCON | TEXT );
    public final WaebricParser.expression_return expression() throws RecognitionException {
        WaebricParser.expression_return retval = new WaebricParser.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set47=null;

        Object set47_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:55:11: ( IDCON | NATCON | TEXT )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:
            {
            root_0 = (Object)adaptor.nil();

            set47=(Token)input.LT(1);
            if ( input.LA(1)==IDCON||(input.LA(1)>=NATCON && input.LA(1)<=TEXT) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set47));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expression"

    public static class field_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "field"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:56:1: field : expression '.' IDCON ;
    public final WaebricParser.field_return field() throws RecognitionException {
        WaebricParser.field_return retval = new WaebricParser.field_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal49=null;
        Token IDCON50=null;
        WaebricParser.expression_return expression48 = null;


        Object char_literal49_tree=null;
        Object IDCON50_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:56:6: ( expression '.' IDCON )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:56:10: expression '.' IDCON
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_expression_in_field487);
            expression48=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression48.getTree());
            char_literal49=(Token)match(input,43,FOLLOW_43_in_field489); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal49_tree = (Object)adaptor.create(char_literal49);
            adaptor.addChild(root_0, char_literal49_tree);
            }
            IDCON50=(Token)match(input,IDCON,FOLLOW_IDCON_in_field491); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON50_tree = (Object)adaptor.create(IDCON50);
            adaptor.addChild(root_0, IDCON50_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "field"

    public static class cat_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "cat"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:57:1: cat : expression '+' expression ;
    public final WaebricParser.cat_return cat() throws RecognitionException {
        WaebricParser.cat_return retval = new WaebricParser.cat_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal52=null;
        WaebricParser.expression_return expression51 = null;

        WaebricParser.expression_return expression53 = null;


        Object char_literal52_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:57:4: ( expression '+' expression )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:57:8: expression '+' expression
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_expression_in_cat500);
            expression51=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression51.getTree());
            char_literal52=(Token)match(input,53,FOLLOW_53_in_cat502); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal52_tree = (Object)adaptor.create(char_literal52);
            adaptor.addChild(root_0, char_literal52_tree);
            }
            pushFollow(FOLLOW_expression_in_cat504);
            expression53=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression53.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "cat"

    public static class list_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "list"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:58:1: list : '[' expression ( ',' expression ) ']' ;
    public final WaebricParser.list_return list() throws RecognitionException {
        WaebricParser.list_return retval = new WaebricParser.list_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal54=null;
        Token char_literal56=null;
        Token char_literal58=null;
        WaebricParser.expression_return expression55 = null;

        WaebricParser.expression_return expression57 = null;


        Object char_literal54_tree=null;
        Object char_literal56_tree=null;
        Object char_literal58_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:58:5: ( '[' expression ( ',' expression ) ']' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:58:9: '[' expression ( ',' expression ) ']'
            {
            root_0 = (Object)adaptor.nil();

            char_literal54=(Token)match(input,54,FOLLOW_54_in_list513); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal54_tree = (Object)adaptor.create(char_literal54);
            adaptor.addChild(root_0, char_literal54_tree);
            }
            pushFollow(FOLLOW_expression_in_list515);
            expression55=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression55.getTree());
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:58:24: ( ',' expression )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:58:26: ',' expression
            {
            char_literal56=(Token)match(input,51,FOLLOW_51_in_list519); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal56_tree = (Object)adaptor.create(char_literal56);
            adaptor.addChild(root_0, char_literal56_tree);
            }
            pushFollow(FOLLOW_expression_in_list521);
            expression57=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression57.getTree());

            }

            char_literal58=(Token)match(input,55,FOLLOW_55_in_list525); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal58_tree = (Object)adaptor.create(char_literal58);
            adaptor.addChild(root_0, char_literal58_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "list"

    public static class record_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "record"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:59:1: record : '{' keyvaluepair ( ',' keyvaluepair ) '}' ;
    public final WaebricParser.record_return record() throws RecognitionException {
        WaebricParser.record_return retval = new WaebricParser.record_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal59=null;
        Token char_literal61=null;
        Token char_literal63=null;
        WaebricParser.keyvaluepair_return keyvaluepair60 = null;

        WaebricParser.keyvaluepair_return keyvaluepair62 = null;


        Object char_literal59_tree=null;
        Object char_literal61_tree=null;
        Object char_literal63_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:59:7: ( '{' keyvaluepair ( ',' keyvaluepair ) '}' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:59:11: '{' keyvaluepair ( ',' keyvaluepair ) '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal59=(Token)match(input,56,FOLLOW_56_in_record534); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal59_tree = (Object)adaptor.create(char_literal59);
            adaptor.addChild(root_0, char_literal59_tree);
            }
            pushFollow(FOLLOW_keyvaluepair_in_record536);
            keyvaluepair60=keyvaluepair();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, keyvaluepair60.getTree());
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:59:28: ( ',' keyvaluepair )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:59:30: ',' keyvaluepair
            {
            char_literal61=(Token)match(input,51,FOLLOW_51_in_record540); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal61_tree = (Object)adaptor.create(char_literal61);
            adaptor.addChild(root_0, char_literal61_tree);
            }
            pushFollow(FOLLOW_keyvaluepair_in_record542);
            keyvaluepair62=keyvaluepair();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, keyvaluepair62.getTree());

            }

            char_literal63=(Token)match(input,57,FOLLOW_57_in_record546); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal63_tree = (Object)adaptor.create(char_literal63);
            adaptor.addChild(root_0, char_literal63_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "record"

    public static class keyvaluepair_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "keyvaluepair"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:60:1: keyvaluepair : IDCON ':' expression ;
    public final WaebricParser.keyvaluepair_return keyvaluepair() throws RecognitionException {
        WaebricParser.keyvaluepair_return retval = new WaebricParser.keyvaluepair_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDCON64=null;
        Token char_literal65=null;
        WaebricParser.expression_return expression66 = null;


        Object IDCON64_tree=null;
        Object char_literal65_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:60:13: ( IDCON ':' expression )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:60:16: IDCON ':' expression
            {
            root_0 = (Object)adaptor.nil();

            IDCON64=(Token)match(input,IDCON,FOLLOW_IDCON_in_keyvaluepair555); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON64_tree = (Object)adaptor.create(IDCON64);
            adaptor.addChild(root_0, IDCON64_tree);
            }
            char_literal65=(Token)match(input,45,FOLLOW_45_in_keyvaluepair557); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal65_tree = (Object)adaptor.create(char_literal65);
            adaptor.addChild(root_0, char_literal65_tree);
            }
            pushFollow(FOLLOW_expression_in_keyvaluepair559);
            expression66=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression66.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "keyvaluepair"

    public static class function_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:62:1: function : 'def' IDCON formals ( statement )* 'end' ;
    public final WaebricParser.function_return function() throws RecognitionException {
        WaebricParser.function_return retval = new WaebricParser.function_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal67=null;
        Token IDCON68=null;
        Token string_literal71=null;
        WaebricParser.formals_return formals69 = null;

        WaebricParser.statement_return statement70 = null;


        Object string_literal67_tree=null;
        Object IDCON68_tree=null;
        Object string_literal71_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:62:9: ( 'def' IDCON formals ( statement )* 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:62:12: 'def' IDCON formals ( statement )* 'end'
            {
            root_0 = (Object)adaptor.nil();

            string_literal67=(Token)match(input,DEF,FOLLOW_DEF_in_function568); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal67_tree = (Object)adaptor.create(string_literal67);
            adaptor.addChild(root_0, string_literal67_tree);
            }
            IDCON68=(Token)match(input,IDCON,FOLLOW_IDCON_in_function570); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON68_tree = (Object)adaptor.create(IDCON68);
            adaptor.addChild(root_0, IDCON68_tree);
            }
            pushFollow(FOLLOW_formals_in_function572);
            formals69=formals();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, formals69.getTree());
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:62:32: ( statement )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==IF||(LA11_0>=EACH && LA11_0<=LET)||(LA11_0>=ECHO && LA11_0<=CDATA)||LA11_0==IDCON||LA11_0==STRCON||LA11_0==56||LA11_0==58) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_function574);
            	    statement70=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement70.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            string_literal71=(Token)match(input,END,FOLLOW_END_in_function577); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal71_tree = (Object)adaptor.create(string_literal71);
            adaptor.addChild(root_0, string_literal71_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "function"

    public static class formals_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "formals"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:63:1: formals : ( '(' ( IDCON )? ( ',' IDCON )* ')' | );
    public final WaebricParser.formals_return formals() throws RecognitionException {
        WaebricParser.formals_return retval = new WaebricParser.formals_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal72=null;
        Token IDCON73=null;
        Token char_literal74=null;
        Token IDCON75=null;
        Token char_literal76=null;

        Object char_literal72_tree=null;
        Object IDCON73_tree=null;
        Object char_literal74_tree=null;
        Object IDCON75_tree=null;
        Object char_literal76_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:63:8: ( '(' ( IDCON )? ( ',' IDCON )* ')' | )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==50) ) {
                alt14=1;
            }
            else if ( ((LA14_0>=END && LA14_0<=IF)||(LA14_0>=EACH && LA14_0<=LET)||(LA14_0>=ECHO && LA14_0<=CDATA)||LA14_0==IDCON||LA14_0==STRCON||LA14_0==56||LA14_0==58) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:63:11: '(' ( IDCON )? ( ',' IDCON )* ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal72=(Token)match(input,50,FOLLOW_50_in_formals584); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal72_tree = (Object)adaptor.create(char_literal72);
                    adaptor.addChild(root_0, char_literal72_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:63:15: ( IDCON )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==IDCON) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: IDCON
                            {
                            IDCON73=(Token)match(input,IDCON,FOLLOW_IDCON_in_formals586); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            IDCON73_tree = (Object)adaptor.create(IDCON73);
                            adaptor.addChild(root_0, IDCON73_tree);
                            }

                            }
                            break;

                    }

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:63:22: ( ',' IDCON )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==51) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:63:24: ',' IDCON
                    	    {
                    	    char_literal74=(Token)match(input,51,FOLLOW_51_in_formals591); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal74_tree = (Object)adaptor.create(char_literal74);
                    	    adaptor.addChild(root_0, char_literal74_tree);
                    	    }
                    	    IDCON75=(Token)match(input,IDCON,FOLLOW_IDCON_in_formals593); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    IDCON75_tree = (Object)adaptor.create(IDCON75);
                    	    adaptor.addChild(root_0, IDCON75_tree);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    char_literal76=(Token)match(input,52,FOLLOW_52_in_formals598); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal76_tree = (Object)adaptor.create(char_literal76);
                    adaptor.addChild(root_0, char_literal76_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:63:43: 
                    {
                    root_0 = (Object)adaptor.nil();

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "formals"

    public static class statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:65:1: statement : ( 'if' '(' predicate ')' statement 'else' statement | 'if' '(' predicate ')' statement | 'each' '(' IDCON ':' expression ')' statement | 'let' ( assignment )+ 'in' ( statement )* 'end' | '{' ( statement )* '}' | STRCON ';' | 'echo' expression ';' | 'echo' embedding ';' | 'cdata' expression ';' | 'yield;' | markup ';' | ( markup )+ statement ';' | ( markup )+ markup ';' | ( markup )+ expression ';' );
    public final WaebricParser.statement_return statement() throws RecognitionException {
        WaebricParser.statement_return retval = new WaebricParser.statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal77=null;
        Token char_literal78=null;
        Token char_literal80=null;
        Token string_literal82=null;
        Token string_literal84=null;
        Token char_literal85=null;
        Token char_literal87=null;
        Token string_literal89=null;
        Token char_literal90=null;
        Token IDCON91=null;
        Token char_literal92=null;
        Token char_literal94=null;
        Token string_literal96=null;
        Token string_literal98=null;
        Token string_literal100=null;
        Token char_literal101=null;
        Token char_literal103=null;
        Token STRCON104=null;
        Token char_literal105=null;
        Token string_literal106=null;
        Token char_literal108=null;
        Token string_literal109=null;
        Token char_literal111=null;
        Token string_literal112=null;
        Token char_literal114=null;
        Token string_literal115=null;
        Token char_literal117=null;
        Token char_literal120=null;
        Token char_literal123=null;
        Token char_literal126=null;
        WaebricParser.predicate_return predicate79 = null;

        WaebricParser.statement_return statement81 = null;

        WaebricParser.statement_return statement83 = null;

        WaebricParser.predicate_return predicate86 = null;

        WaebricParser.statement_return statement88 = null;

        WaebricParser.expression_return expression93 = null;

        WaebricParser.statement_return statement95 = null;

        WaebricParser.assignment_return assignment97 = null;

        WaebricParser.statement_return statement99 = null;

        WaebricParser.statement_return statement102 = null;

        WaebricParser.expression_return expression107 = null;

        WaebricParser.embedding_return embedding110 = null;

        WaebricParser.expression_return expression113 = null;

        WaebricParser.markup_return markup116 = null;

        WaebricParser.markup_return markup118 = null;

        WaebricParser.statement_return statement119 = null;

        WaebricParser.markup_return markup121 = null;

        WaebricParser.markup_return markup122 = null;

        WaebricParser.markup_return markup124 = null;

        WaebricParser.expression_return expression125 = null;


        Object string_literal77_tree=null;
        Object char_literal78_tree=null;
        Object char_literal80_tree=null;
        Object string_literal82_tree=null;
        Object string_literal84_tree=null;
        Object char_literal85_tree=null;
        Object char_literal87_tree=null;
        Object string_literal89_tree=null;
        Object char_literal90_tree=null;
        Object IDCON91_tree=null;
        Object char_literal92_tree=null;
        Object char_literal94_tree=null;
        Object string_literal96_tree=null;
        Object string_literal98_tree=null;
        Object string_literal100_tree=null;
        Object char_literal101_tree=null;
        Object char_literal103_tree=null;
        Object STRCON104_tree=null;
        Object char_literal105_tree=null;
        Object string_literal106_tree=null;
        Object char_literal108_tree=null;
        Object string_literal109_tree=null;
        Object char_literal111_tree=null;
        Object string_literal112_tree=null;
        Object char_literal114_tree=null;
        Object string_literal115_tree=null;
        Object char_literal117_tree=null;
        Object char_literal120_tree=null;
        Object char_literal123_tree=null;
        Object char_literal126_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:65:10: ( 'if' '(' predicate ')' statement 'else' statement | 'if' '(' predicate ')' statement | 'each' '(' IDCON ':' expression ')' statement | 'let' ( assignment )+ 'in' ( statement )* 'end' | '{' ( statement )* '}' | STRCON ';' | 'echo' expression ';' | 'echo' embedding ';' | 'cdata' expression ';' | 'yield;' | markup ';' | ( markup )+ statement ';' | ( markup )+ markup ';' | ( markup )+ expression ';' )
            int alt21=14;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:65:13: 'if' '(' predicate ')' statement 'else' statement
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal77=(Token)match(input,IF,FOLLOW_IF_in_statement609); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal77_tree = (Object)adaptor.create(string_literal77);
                    adaptor.addChild(root_0, string_literal77_tree);
                    }
                    char_literal78=(Token)match(input,50,FOLLOW_50_in_statement611); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal78_tree = (Object)adaptor.create(char_literal78);
                    adaptor.addChild(root_0, char_literal78_tree);
                    }
                    pushFollow(FOLLOW_predicate_in_statement613);
                    predicate79=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate79.getTree());
                    char_literal80=(Token)match(input,52,FOLLOW_52_in_statement615); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal80_tree = (Object)adaptor.create(char_literal80);
                    adaptor.addChild(root_0, char_literal80_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement617);
                    statement81=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement81.getTree());
                    string_literal82=(Token)match(input,ELSE,FOLLOW_ELSE_in_statement619); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal82_tree = (Object)adaptor.create(string_literal82);
                    adaptor.addChild(root_0, string_literal82_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement621);
                    statement83=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement83.getTree());

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:66:4: 'if' '(' predicate ')' statement
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal84=(Token)match(input,IF,FOLLOW_IF_in_statement629); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal84_tree = (Object)adaptor.create(string_literal84);
                    adaptor.addChild(root_0, string_literal84_tree);
                    }
                    char_literal85=(Token)match(input,50,FOLLOW_50_in_statement631); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal85_tree = (Object)adaptor.create(char_literal85);
                    adaptor.addChild(root_0, char_literal85_tree);
                    }
                    pushFollow(FOLLOW_predicate_in_statement633);
                    predicate86=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate86.getTree());
                    char_literal87=(Token)match(input,52,FOLLOW_52_in_statement635); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal87_tree = (Object)adaptor.create(char_literal87);
                    adaptor.addChild(root_0, char_literal87_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement637);
                    statement88=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement88.getTree());

                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:67:4: 'each' '(' IDCON ':' expression ')' statement
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal89=(Token)match(input,EACH,FOLLOW_EACH_in_statement644); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal89_tree = (Object)adaptor.create(string_literal89);
                    adaptor.addChild(root_0, string_literal89_tree);
                    }
                    char_literal90=(Token)match(input,50,FOLLOW_50_in_statement646); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal90_tree = (Object)adaptor.create(char_literal90);
                    adaptor.addChild(root_0, char_literal90_tree);
                    }
                    IDCON91=(Token)match(input,IDCON,FOLLOW_IDCON_in_statement648); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON91_tree = (Object)adaptor.create(IDCON91);
                    adaptor.addChild(root_0, IDCON91_tree);
                    }
                    char_literal92=(Token)match(input,45,FOLLOW_45_in_statement650); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal92_tree = (Object)adaptor.create(char_literal92);
                    adaptor.addChild(root_0, char_literal92_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement652);
                    expression93=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression93.getTree());
                    char_literal94=(Token)match(input,52,FOLLOW_52_in_statement654); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal94_tree = (Object)adaptor.create(char_literal94);
                    adaptor.addChild(root_0, char_literal94_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement656);
                    statement95=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement95.getTree());

                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:68:4: 'let' ( assignment )+ 'in' ( statement )* 'end'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal96=(Token)match(input,LET,FOLLOW_LET_in_statement664); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal96_tree = (Object)adaptor.create(string_literal96);
                    adaptor.addChild(root_0, string_literal96_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:68:10: ( assignment )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==IDCON) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: assignment
                    	    {
                    	    pushFollow(FOLLOW_assignment_in_statement666);
                    	    assignment97=assignment();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignment97.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt15 >= 1 ) break loop15;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
                    } while (true);

                    string_literal98=(Token)match(input,IN,FOLLOW_IN_in_statement669); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal98_tree = (Object)adaptor.create(string_literal98);
                    adaptor.addChild(root_0, string_literal98_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:68:27: ( statement )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==IF||(LA16_0>=EACH && LA16_0<=LET)||(LA16_0>=ECHO && LA16_0<=CDATA)||LA16_0==IDCON||LA16_0==STRCON||LA16_0==56||LA16_0==58) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_statement671);
                    	    statement99=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement99.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    string_literal100=(Token)match(input,END,FOLLOW_END_in_statement674); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal100_tree = (Object)adaptor.create(string_literal100);
                    adaptor.addChild(root_0, string_literal100_tree);
                    }

                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:69:4: '{' ( statement )* '}'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal101=(Token)match(input,56,FOLLOW_56_in_statement681); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal101_tree = (Object)adaptor.create(char_literal101);
                    adaptor.addChild(root_0, char_literal101_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:69:8: ( statement )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==IF||(LA17_0>=EACH && LA17_0<=LET)||(LA17_0>=ECHO && LA17_0<=CDATA)||LA17_0==IDCON||LA17_0==STRCON||LA17_0==56||LA17_0==58) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_statement683);
                    	    statement102=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement102.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    char_literal103=(Token)match(input,57,FOLLOW_57_in_statement686); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal103_tree = (Object)adaptor.create(char_literal103);
                    adaptor.addChild(root_0, char_literal103_tree);
                    }

                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:70:4: STRCON ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    STRCON104=(Token)match(input,STRCON,FOLLOW_STRCON_in_statement693); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRCON104_tree = (Object)adaptor.create(STRCON104);
                    adaptor.addChild(root_0, STRCON104_tree);
                    }
                    char_literal105=(Token)match(input,44,FOLLOW_44_in_statement695); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal105_tree = (Object)adaptor.create(char_literal105);
                    adaptor.addChild(root_0, char_literal105_tree);
                    }

                    }
                    break;
                case 7 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:71:4: 'echo' expression ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal106=(Token)match(input,ECHO,FOLLOW_ECHO_in_statement702); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal106_tree = (Object)adaptor.create(string_literal106);
                    adaptor.addChild(root_0, string_literal106_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement704);
                    expression107=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression107.getTree());
                    char_literal108=(Token)match(input,44,FOLLOW_44_in_statement706); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal108_tree = (Object)adaptor.create(char_literal108);
                    adaptor.addChild(root_0, char_literal108_tree);
                    }

                    }
                    break;
                case 8 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:72:4: 'echo' embedding ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal109=(Token)match(input,ECHO,FOLLOW_ECHO_in_statement713); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal109_tree = (Object)adaptor.create(string_literal109);
                    adaptor.addChild(root_0, string_literal109_tree);
                    }
                    pushFollow(FOLLOW_embedding_in_statement715);
                    embedding110=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, embedding110.getTree());
                    char_literal111=(Token)match(input,44,FOLLOW_44_in_statement717); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal111_tree = (Object)adaptor.create(char_literal111);
                    adaptor.addChild(root_0, char_literal111_tree);
                    }

                    }
                    break;
                case 9 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:73:4: 'cdata' expression ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal112=(Token)match(input,CDATA,FOLLOW_CDATA_in_statement724); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal112_tree = (Object)adaptor.create(string_literal112);
                    adaptor.addChild(root_0, string_literal112_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement726);
                    expression113=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression113.getTree());
                    char_literal114=(Token)match(input,44,FOLLOW_44_in_statement728); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal114_tree = (Object)adaptor.create(char_literal114);
                    adaptor.addChild(root_0, char_literal114_tree);
                    }

                    }
                    break;
                case 10 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:74:4: 'yield;'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal115=(Token)match(input,58,FOLLOW_58_in_statement736); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal115_tree = (Object)adaptor.create(string_literal115);
                    adaptor.addChild(root_0, string_literal115_tree);
                    }

                    }
                    break;
                case 11 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:75:4: markup ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_markup_in_statement743);
                    markup116=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, markup116.getTree());
                    char_literal117=(Token)match(input,44,FOLLOW_44_in_statement745); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal117_tree = (Object)adaptor.create(char_literal117);
                    adaptor.addChild(root_0, char_literal117_tree);
                    }

                    }
                    break;
                case 12 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:76:4: ( markup )+ statement ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:76:4: ( markup )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==IDCON) ) {
                            int LA18_2 = input.LA(2);

                            if ( (synpred36_Waebric()) ) {
                                alt18=1;
                            }


                        }


                        switch (alt18) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_statement752);
                    	    markup118=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, markup118.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt18 >= 1 ) break loop18;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(18, input);
                                throw eee;
                        }
                        cnt18++;
                    } while (true);

                    pushFollow(FOLLOW_statement_in_statement755);
                    statement119=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement119.getTree());
                    char_literal120=(Token)match(input,44,FOLLOW_44_in_statement757); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal120_tree = (Object)adaptor.create(char_literal120);
                    adaptor.addChild(root_0, char_literal120_tree);
                    }

                    }
                    break;
                case 13 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:77:4: ( markup )+ markup ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:77:4: ( markup )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        alt19 = dfa19.predict(input);
                        switch (alt19) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_statement764);
                    	    markup121=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, markup121.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt19 >= 1 ) break loop19;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(19, input);
                                throw eee;
                        }
                        cnt19++;
                    } while (true);

                    pushFollow(FOLLOW_markup_in_statement767);
                    markup122=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, markup122.getTree());
                    char_literal123=(Token)match(input,44,FOLLOW_44_in_statement769); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal123_tree = (Object)adaptor.create(char_literal123);
                    adaptor.addChild(root_0, char_literal123_tree);
                    }

                    }
                    break;
                case 14 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:78:4: ( markup )+ expression ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:78:4: ( markup )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==IDCON) ) {
                            int LA20_1 = input.LA(2);

                            if ( (LA20_1==IDCON||(LA20_1>=NATCON && LA20_1<=TEXT)||LA20_1==43||(LA20_1>=45 && LA20_1<=48)||LA20_1==50) ) {
                                alt20=1;
                            }


                        }


                        switch (alt20) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_statement776);
                    	    markup124=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, markup124.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt20 >= 1 ) break loop20;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);

                    pushFollow(FOLLOW_expression_in_statement779);
                    expression125=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression125.getTree());
                    char_literal126=(Token)match(input,44,FOLLOW_44_in_statement781); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal126_tree = (Object)adaptor.create(char_literal126);
                    adaptor.addChild(root_0, char_literal126_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "statement"

    public static class assignment_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignment"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:79:1: assignment : ( IDCON '=' expression ';' | IDCON formals statement );
    public final WaebricParser.assignment_return assignment() throws RecognitionException {
        WaebricParser.assignment_return retval = new WaebricParser.assignment_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDCON127=null;
        Token char_literal128=null;
        Token char_literal130=null;
        Token IDCON131=null;
        WaebricParser.expression_return expression129 = null;

        WaebricParser.formals_return formals132 = null;

        WaebricParser.statement_return statement133 = null;


        Object IDCON127_tree=null;
        Object char_literal128_tree=null;
        Object char_literal130_tree=null;
        Object IDCON131_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:79:11: ( IDCON '=' expression ';' | IDCON formals statement )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==IDCON) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==59) ) {
                    alt22=1;
                }
                else if ( (LA22_1==IF||(LA22_1>=EACH && LA22_1<=LET)||(LA22_1>=ECHO && LA22_1<=CDATA)||LA22_1==IDCON||LA22_1==STRCON||LA22_1==50||LA22_1==56||LA22_1==58) ) {
                    alt22=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:79:14: IDCON '=' expression ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    IDCON127=(Token)match(input,IDCON,FOLLOW_IDCON_in_assignment790); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON127_tree = (Object)adaptor.create(IDCON127);
                    adaptor.addChild(root_0, IDCON127_tree);
                    }
                    char_literal128=(Token)match(input,59,FOLLOW_59_in_assignment792); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal128_tree = (Object)adaptor.create(char_literal128);
                    adaptor.addChild(root_0, char_literal128_tree);
                    }
                    pushFollow(FOLLOW_expression_in_assignment794);
                    expression129=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression129.getTree());
                    char_literal130=(Token)match(input,44,FOLLOW_44_in_assignment796); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal130_tree = (Object)adaptor.create(char_literal130);
                    adaptor.addChild(root_0, char_literal130_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:80:4: IDCON formals statement
                    {
                    root_0 = (Object)adaptor.nil();

                    IDCON131=(Token)match(input,IDCON,FOLLOW_IDCON_in_assignment804); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON131_tree = (Object)adaptor.create(IDCON131);
                    adaptor.addChild(root_0, IDCON131_tree);
                    }
                    pushFollow(FOLLOW_formals_in_assignment806);
                    formals132=formals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, formals132.getTree());
                    pushFollow(FOLLOW_statement_in_assignment808);
                    statement133=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement133.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assignment"

    public static class predicate_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "predicate"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:82:1: predicate : ( expression | not | is );
    public final WaebricParser.predicate_return predicate() throws RecognitionException {
        WaebricParser.predicate_return retval = new WaebricParser.predicate_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WaebricParser.expression_return expression134 = null;

        WaebricParser.not_return not135 = null;

        WaebricParser.is_return is136 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:82:10: ( expression | not | is )
            int alt23=3;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==IDCON||(LA23_0>=NATCON && LA23_0<=TEXT)) ) {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==43) ) {
                    alt23=3;
                }
                else if ( (LA23_1==EOF||LA23_1==52||(LA23_1>=61 && LA23_1<=62)) ) {
                    alt23=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA23_0==60) ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:82:13: expression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_expression_in_predicate818);
                    expression134=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression134.getTree());

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:82:26: not
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_not_in_predicate822);
                    not135=not();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, not135.getTree());

                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:82:49: is
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_is_in_predicate828);
                    is136=is();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, is136.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "predicate"

    public static class not_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "not"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:83:1: not : '!' predicate ;
    public final WaebricParser.not_return not() throws RecognitionException {
        WaebricParser.not_return retval = new WaebricParser.not_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal137=null;
        WaebricParser.predicate_return predicate138 = null;


        Object char_literal137_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:83:4: ( '!' predicate )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:83:8: '!' predicate
            {
            root_0 = (Object)adaptor.nil();

            char_literal137=(Token)match(input,60,FOLLOW_60_in_not836); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal137_tree = (Object)adaptor.create(char_literal137);
            adaptor.addChild(root_0, char_literal137_tree);
            }
            pushFollow(FOLLOW_predicate_in_not838);
            predicate138=predicate();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate138.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "not"

    public static class and_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "and"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:84:1: and : ( predicate '&&' ) predicate ;
    public final WaebricParser.and_return and() throws RecognitionException {
        WaebricParser.and_return retval = new WaebricParser.and_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal140=null;
        WaebricParser.predicate_return predicate139 = null;

        WaebricParser.predicate_return predicate141 = null;


        Object string_literal140_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:84:4: ( ( predicate '&&' ) predicate )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:84:8: ( predicate '&&' ) predicate
            {
            root_0 = (Object)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:84:8: ( predicate '&&' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:84:10: predicate '&&'
            {
            pushFollow(FOLLOW_predicate_in_and849);
            predicate139=predicate();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate139.getTree());
            string_literal140=(Token)match(input,61,FOLLOW_61_in_and851); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal140_tree = (Object)adaptor.create(string_literal140);
            adaptor.addChild(root_0, string_literal140_tree);
            }

            }

            pushFollow(FOLLOW_predicate_in_and855);
            predicate141=predicate();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate141.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "and"

    public static class or_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "or"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:85:1: or : ( predicate '||' ) predicate ;
    public final WaebricParser.or_return or() throws RecognitionException {
        WaebricParser.or_return retval = new WaebricParser.or_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal143=null;
        WaebricParser.predicate_return predicate142 = null;

        WaebricParser.predicate_return predicate144 = null;


        Object string_literal143_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:85:3: ( ( predicate '||' ) predicate )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:85:7: ( predicate '||' ) predicate
            {
            root_0 = (Object)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:85:7: ( predicate '||' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:85:9: predicate '||'
            {
            pushFollow(FOLLOW_predicate_in_or866);
            predicate142=predicate();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate142.getTree());
            string_literal143=(Token)match(input,62,FOLLOW_62_in_or868); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal143_tree = (Object)adaptor.create(string_literal143);
            adaptor.addChild(root_0, string_literal143_tree);
            }

            }

            pushFollow(FOLLOW_predicate_in_or872);
            predicate144=predicate();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate144.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "or"

    public static class is_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "is"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:86:1: is : expression '.' type ;
    public final WaebricParser.is_return is() throws RecognitionException {
        WaebricParser.is_return retval = new WaebricParser.is_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal146=null;
        WaebricParser.expression_return expression145 = null;

        WaebricParser.type_return type147 = null;


        Object char_literal146_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:86:3: ( expression '.' type )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:86:7: expression '.' type
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_expression_in_is881);
            expression145=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression145.getTree());
            char_literal146=(Token)match(input,43,FOLLOW_43_in_is883); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal146_tree = (Object)adaptor.create(char_literal146);
            adaptor.addChild(root_0, char_literal146_tree);
            }
            pushFollow(FOLLOW_type_in_is885);
            type147=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, type147.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "is"

    public static class type_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:87:1: type : ( LIST | RECORD | STRING );
    public final WaebricParser.type_return type() throws RecognitionException {
        WaebricParser.type_return retval = new WaebricParser.type_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set148=null;

        Object set148_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:87:5: ( LIST | RECORD | STRING )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:
            {
            root_0 = (Object)adaptor.nil();

            set148=(Token)input.LT(1);
            if ( (input.LA(1)>=LIST && input.LA(1)<=STRING) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set148));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "type"

    public static class embedding_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "embedding"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:89:1: embedding : pretext embed texttail ;
    public final WaebricParser.embedding_return embedding() throws RecognitionException {
        WaebricParser.embedding_return retval = new WaebricParser.embedding_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WaebricParser.pretext_return pretext149 = null;

        WaebricParser.embed_return embed150 = null;

        WaebricParser.texttail_return texttail151 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:89:10: ( pretext embed texttail )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:89:13: pretext embed texttail
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_pretext_in_embedding912);
            pretext149=pretext();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pretext149.getTree());
            pushFollow(FOLLOW_embed_in_embedding914);
            embed150=embed();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, embed150.getTree());
            pushFollow(FOLLOW_texttail_in_embedding916);
            texttail151=texttail();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, texttail151.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "embedding"

    public static class embed_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "embed"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:90:1: embed : ( ( markup )* expression | ( markup )* markup );
    public final WaebricParser.embed_return embed() throws RecognitionException {
        WaebricParser.embed_return retval = new WaebricParser.embed_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WaebricParser.markup_return markup152 = null;

        WaebricParser.expression_return expression153 = null;

        WaebricParser.markup_return markup154 = null;

        WaebricParser.markup_return markup155 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:90:6: ( ( markup )* expression | ( markup )* markup )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==IDCON) ) {
                int LA26_1 = input.LA(2);

                if ( (synpred47_Waebric()) ) {
                    alt26=1;
                }
                else if ( (true) ) {
                    alt26=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA26_0>=NATCON && LA26_0<=TEXT)) ) {
                alt26=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:90:10: ( markup )* expression
                    {
                    root_0 = (Object)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:90:10: ( markup )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==IDCON) ) {
                            int LA24_1 = input.LA(2);

                            if ( (LA24_1==IDCON||(LA24_1>=NATCON && LA24_1<=TEXT)||LA24_1==43||(LA24_1>=45 && LA24_1<=48)||LA24_1==50) ) {
                                alt24=1;
                            }


                        }


                        switch (alt24) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_embed926);
                    	    markup152=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, markup152.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    pushFollow(FOLLOW_expression_in_embed929);
                    expression153=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression153.getTree());

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:91:4: ( markup )* markup
                    {
                    root_0 = (Object)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:91:4: ( markup )*
                    loop25:
                    do {
                        int alt25=2;
                        alt25 = dfa25.predict(input);
                        switch (alt25) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_embed936);
                    	    markup154=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, markup154.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);

                    pushFollow(FOLLOW_markup_in_embed939);
                    markup155=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, markup155.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "embed"

    public static class texttail_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "texttail"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:92:1: texttail : ( posttext | midtext embed texttail );
    public final WaebricParser.texttail_return texttail() throws RecognitionException {
        WaebricParser.texttail_return retval = new WaebricParser.texttail_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WaebricParser.posttext_return posttext156 = null;

        WaebricParser.midtext_return midtext157 = null;

        WaebricParser.embed_return embed158 = null;

        WaebricParser.texttail_return texttail159 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:92:9: ( posttext | midtext embed texttail )
            int alt27=2;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:92:12: posttext
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_posttext_in_texttail947);
                    posttext156=posttext();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, posttext156.getTree());

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:92:23: midtext embed texttail
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_midtext_in_texttail951);
                    midtext157=midtext();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, midtext157.getTree());
                    pushFollow(FOLLOW_embed_in_texttail953);
                    embed158=embed();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, embed158.getTree());
                    pushFollow(FOLLOW_texttail_in_texttail955);
                    texttail159=texttail();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, texttail159.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "texttail"

    public static class pretext_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pretext"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:93:1: pretext : '\"' ( TEXTCHAR )* '<' ;
    public final WaebricParser.pretext_return pretext() throws RecognitionException {
        WaebricParser.pretext_return retval = new WaebricParser.pretext_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal160=null;
        Token TEXTCHAR161=null;
        Token char_literal162=null;

        Object char_literal160_tree=null;
        Object TEXTCHAR161_tree=null;
        Object char_literal162_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:93:8: ( '\"' ( TEXTCHAR )* '<' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:93:11: '\"' ( TEXTCHAR )* '<'
            {
            root_0 = (Object)adaptor.nil();

            char_literal160=(Token)match(input,63,FOLLOW_63_in_pretext963); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal160_tree = (Object)adaptor.create(char_literal160);
            adaptor.addChild(root_0, char_literal160_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:93:15: ( TEXTCHAR )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==TEXTCHAR) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: TEXTCHAR
            	    {
            	    TEXTCHAR161=(Token)match(input,TEXTCHAR,FOLLOW_TEXTCHAR_in_pretext965); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    TEXTCHAR161_tree = (Object)adaptor.create(TEXTCHAR161);
            	    adaptor.addChild(root_0, TEXTCHAR161_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            char_literal162=(Token)match(input,64,FOLLOW_64_in_pretext968); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal162_tree = (Object)adaptor.create(char_literal162);
            adaptor.addChild(root_0, char_literal162_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "pretext"

    public static class posttext_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "posttext"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:94:1: posttext : '>' ( TEXTCHAR )* '\"' ;
    public final WaebricParser.posttext_return posttext() throws RecognitionException {
        WaebricParser.posttext_return retval = new WaebricParser.posttext_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal163=null;
        Token TEXTCHAR164=null;
        Token char_literal165=null;

        Object char_literal163_tree=null;
        Object TEXTCHAR164_tree=null;
        Object char_literal165_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:94:9: ( '>' ( TEXTCHAR )* '\"' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:94:12: '>' ( TEXTCHAR )* '\"'
            {
            root_0 = (Object)adaptor.nil();

            char_literal163=(Token)match(input,65,FOLLOW_65_in_posttext976); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal163_tree = (Object)adaptor.create(char_literal163);
            adaptor.addChild(root_0, char_literal163_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:94:16: ( TEXTCHAR )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==TEXTCHAR) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: TEXTCHAR
            	    {
            	    TEXTCHAR164=(Token)match(input,TEXTCHAR,FOLLOW_TEXTCHAR_in_posttext978); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    TEXTCHAR164_tree = (Object)adaptor.create(TEXTCHAR164);
            	    adaptor.addChild(root_0, TEXTCHAR164_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            char_literal165=(Token)match(input,63,FOLLOW_63_in_posttext981); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal165_tree = (Object)adaptor.create(char_literal165);
            adaptor.addChild(root_0, char_literal165_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "posttext"

    public static class midtext_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "midtext"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:95:1: midtext : '>' ( TEXTCHAR )* '<' ;
    public final WaebricParser.midtext_return midtext() throws RecognitionException {
        WaebricParser.midtext_return retval = new WaebricParser.midtext_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal166=null;
        Token TEXTCHAR167=null;
        Token char_literal168=null;

        Object char_literal166_tree=null;
        Object TEXTCHAR167_tree=null;
        Object char_literal168_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:95:8: ( '>' ( TEXTCHAR )* '<' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:95:11: '>' ( TEXTCHAR )* '<'
            {
            root_0 = (Object)adaptor.nil();

            char_literal166=(Token)match(input,65,FOLLOW_65_in_midtext989); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal166_tree = (Object)adaptor.create(char_literal166);
            adaptor.addChild(root_0, char_literal166_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:95:15: ( TEXTCHAR )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==TEXTCHAR) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: TEXTCHAR
            	    {
            	    TEXTCHAR167=(Token)match(input,TEXTCHAR,FOLLOW_TEXTCHAR_in_midtext991); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    TEXTCHAR167_tree = (Object)adaptor.create(TEXTCHAR167);
            	    adaptor.addChild(root_0, TEXTCHAR167_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            char_literal168=(Token)match(input,64,FOLLOW_64_in_midtext994); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal168_tree = (Object)adaptor.create(char_literal168);
            adaptor.addChild(root_0, char_literal168_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "midtext"

    // $ANTLR start synpred22_Waebric
    public final void synpred22_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:65:13: ( 'if' '(' predicate ')' statement 'else' statement )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:65:13: 'if' '(' predicate ')' statement 'else' statement
        {
        match(input,IF,FOLLOW_IF_in_synpred22_Waebric609); if (state.failed) return ;
        match(input,50,FOLLOW_50_in_synpred22_Waebric611); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred22_Waebric613);
        predicate();

        state._fsp--;
        if (state.failed) return ;
        match(input,52,FOLLOW_52_in_synpred22_Waebric615); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred22_Waebric617);
        statement();

        state._fsp--;
        if (state.failed) return ;
        match(input,ELSE,FOLLOW_ELSE_in_synpred22_Waebric619); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred22_Waebric621);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred22_Waebric

    // $ANTLR start synpred23_Waebric
    public final void synpred23_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:66:4: ( 'if' '(' predicate ')' statement )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:66:4: 'if' '(' predicate ')' statement
        {
        match(input,IF,FOLLOW_IF_in_synpred23_Waebric629); if (state.failed) return ;
        match(input,50,FOLLOW_50_in_synpred23_Waebric631); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred23_Waebric633);
        predicate();

        state._fsp--;
        if (state.failed) return ;
        match(input,52,FOLLOW_52_in_synpred23_Waebric635); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred23_Waebric637);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred23_Waebric

    // $ANTLR start synpred31_Waebric
    public final void synpred31_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:71:4: ( 'echo' expression ';' )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:71:4: 'echo' expression ';'
        {
        match(input,ECHO,FOLLOW_ECHO_in_synpred31_Waebric702); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred31_Waebric704);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,44,FOLLOW_44_in_synpred31_Waebric706); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_Waebric

    // $ANTLR start synpred32_Waebric
    public final void synpred32_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:72:4: ( 'echo' embedding ';' )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:72:4: 'echo' embedding ';'
        {
        match(input,ECHO,FOLLOW_ECHO_in_synpred32_Waebric713); if (state.failed) return ;
        pushFollow(FOLLOW_embedding_in_synpred32_Waebric715);
        embedding();

        state._fsp--;
        if (state.failed) return ;
        match(input,44,FOLLOW_44_in_synpred32_Waebric717); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_Waebric

    // $ANTLR start synpred35_Waebric
    public final void synpred35_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:75:4: ( markup ';' )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:75:4: markup ';'
        {
        pushFollow(FOLLOW_markup_in_synpred35_Waebric743);
        markup();

        state._fsp--;
        if (state.failed) return ;
        match(input,44,FOLLOW_44_in_synpred35_Waebric745); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred35_Waebric

    // $ANTLR start synpred36_Waebric
    public final void synpred36_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:76:4: ( markup )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:76:4: markup
        {
        pushFollow(FOLLOW_markup_in_synpred36_Waebric752);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred36_Waebric

    // $ANTLR start synpred37_Waebric
    public final void synpred37_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:76:4: ( ( markup )+ statement ';' )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:76:4: ( markup )+ statement ';'
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:76:4: ( markup )+
        int cnt36=0;
        loop36:
        do {
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==IDCON) ) {
                int LA36_2 = input.LA(2);

                if ( (synpred36_Waebric()) ) {
                    alt36=1;
                }


            }


            switch (alt36) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred37_Waebric752);
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
                    throw eee;
            }
            cnt36++;
        } while (true);

        pushFollow(FOLLOW_statement_in_synpred37_Waebric755);
        statement();

        state._fsp--;
        if (state.failed) return ;
        match(input,44,FOLLOW_44_in_synpred37_Waebric757); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred37_Waebric

    // $ANTLR start synpred39_Waebric
    public final void synpred39_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:77:4: ( ( markup )+ markup ';' )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:77:4: ( markup )+ markup ';'
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:77:4: ( markup )+
        int cnt37=0;
        loop37:
        do {
            int alt37=2;
            alt37 = dfa37.predict(input);
            switch (alt37) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred39_Waebric764);
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
                    throw eee;
            }
            cnt37++;
        } while (true);

        pushFollow(FOLLOW_markup_in_synpred39_Waebric767);
        markup();

        state._fsp--;
        if (state.failed) return ;
        match(input,44,FOLLOW_44_in_synpred39_Waebric769); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_Waebric

    // $ANTLR start synpred47_Waebric
    public final void synpred47_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:90:10: ( ( markup )* expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:90:10: ( markup )* expression
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:90:10: ( markup )*
        loop38:
        do {
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==IDCON) ) {
                int LA38_1 = input.LA(2);

                if ( (LA38_1==IDCON||(LA38_1>=NATCON && LA38_1<=TEXT)||LA38_1==43||(LA38_1>=45 && LA38_1<=48)||LA38_1==50) ) {
                    alt38=1;
                }


            }


            switch (alt38) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred47_Waebric926);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop38;
            }
        } while (true);

        pushFollow(FOLLOW_expression_in_synpred47_Waebric929);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred47_Waebric

    // Delegated rules

    public final boolean synpred23_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_Waebric_fragment(); // can never throw exception
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
    public final boolean synpred39_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_Waebric_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_Waebric_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_Waebric_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_Waebric_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_Waebric_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred47_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred47_Waebric_fragment(); // can never throw exception
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


    protected DFA6 dfa6 = new DFA6(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA27 dfa27 = new DFA27(this);
    protected DFA37 dfa37 = new DFA37(this);
    static final String DFA6_eotS =
        "\20\uffff";
    static final String DFA6_eofS =
        "\1\uffff\1\7\7\uffff\5\7\1\uffff\1\7";
    static final String DFA6_minS =
        "\1\25\1\10\4\25\1\27\2\uffff\5\10\1\27\1\10";
    static final String DFA6_maxS =
        "\1\25\1\101\4\25\1\27\2\uffff\5\101\1\27\1\101";
    static final String DFA6_acceptS =
        "\7\uffff\1\2\1\1\7\uffff";
    static final String DFA6_specialS =
        "\20\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\1",
            "\2\7\1\uffff\2\7\2\uffff\2\7\4\uffff\1\7\1\uffff\3\7\21\uffff"+
            "\1\3\1\7\1\5\1\2\1\4\1\6\1\uffff\1\10\5\uffff\1\7\1\uffff\1"+
            "\7\6\uffff\1\7",
            "\1\11",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15",
            "",
            "",
            "\2\7\1\uffff\2\7\2\uffff\2\7\4\uffff\1\7\1\uffff\3\7\21\uffff"+
            "\1\3\1\7\1\5\1\2\1\4\1\6\1\uffff\1\10\5\uffff\1\7\1\uffff\1"+
            "\7\6\uffff\1\7",
            "\2\7\1\uffff\2\7\2\uffff\2\7\4\uffff\1\7\1\uffff\3\7\21\uffff"+
            "\1\3\1\7\1\5\1\2\1\4\1\6\1\uffff\1\10\5\uffff\1\7\1\uffff\1"+
            "\7\6\uffff\1\7",
            "\2\7\1\uffff\2\7\2\uffff\2\7\4\uffff\1\7\1\uffff\3\7\21\uffff"+
            "\1\3\1\7\1\5\1\2\1\4\1\6\1\uffff\1\10\5\uffff\1\7\1\uffff\1"+
            "\7\6\uffff\1\7",
            "\2\7\1\uffff\2\7\2\uffff\2\7\4\uffff\1\7\1\uffff\3\7\21\uffff"+
            "\1\3\1\7\1\5\1\2\1\4\1\6\1\uffff\1\10\5\uffff\1\7\1\uffff\1"+
            "\7\6\uffff\1\7",
            "\2\7\1\uffff\2\7\2\uffff\2\7\4\uffff\1\7\1\uffff\3\7\21\uffff"+
            "\1\3\1\7\1\5\1\2\1\4\1\6\1\16\1\10\5\uffff\1\7\1\uffff\1\7\6"+
            "\uffff\1\7",
            "\1\17",
            "\2\7\1\uffff\2\7\2\uffff\2\7\4\uffff\1\7\1\uffff\3\7\21\uffff"+
            "\1\3\1\7\1\5\1\2\1\4\1\6\1\uffff\1\10\5\uffff\1\7\1\uffff\1"+
            "\7\6\uffff\1\7"
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
            return "48:1: markup : ( designator arguments | designator );";
        }
    }
    static final String DFA21_eotS =
        "\22\uffff";
    static final String DFA21_eofS =
        "\22\uffff";
    static final String DFA21_minS =
        "\1\11\1\0\4\uffff\1\0\2\uffff\1\0\10\uffff";
    static final String DFA21_maxS =
        "\1\72\1\0\4\uffff\1\0\2\uffff\1\0\10\uffff";
    static final String DFA21_acceptS =
        "\2\uffff\1\3\1\4\1\5\1\6\1\uffff\1\11\1\12\1\uffff\1\1\1\2\1\7\1"+
        "\10\1\13\1\14\1\15\1\16";
    static final String DFA21_specialS =
        "\1\uffff\1\0\4\uffff\1\1\2\uffff\1\2\10\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\1\1\uffff\1\2\1\3\2\uffff\1\6\1\7\4\uffff\1\11\3\uffff\1"+
            "\5\36\uffff\1\4\1\uffff\1\10",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
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
            return "65:1: statement : ( 'if' '(' predicate ')' statement 'else' statement | 'if' '(' predicate ')' statement | 'each' '(' IDCON ':' expression ')' statement | 'let' ( assignment )+ 'in' ( statement )* 'end' | '{' ( statement )* '}' | STRCON ';' | 'echo' expression ';' | 'echo' embedding ';' | 'cdata' expression ';' | 'yield;' | markup ';' | ( markup )+ statement ';' | ( markup )+ markup ';' | ( markup )+ expression ';' );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA21_1 = input.LA(1);

                         
                        int index21_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_Waebric()) ) {s = 10;}

                        else if ( (synpred23_Waebric()) ) {s = 11;}

                         
                        input.seek(index21_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA21_6 = input.LA(1);

                         
                        int index21_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_Waebric()) ) {s = 12;}

                        else if ( (synpred32_Waebric()) ) {s = 13;}

                         
                        input.seek(index21_6);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA21_9 = input.LA(1);

                         
                        int index21_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_Waebric()) ) {s = 14;}

                        else if ( (synpred37_Waebric()) ) {s = 15;}

                        else if ( (synpred39_Waebric()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index21_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 21, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA19_eotS =
        "\25\uffff";
    static final String DFA19_eofS =
        "\25\uffff";
    static final String DFA19_minS =
        "\6\25\1\27\1\uffff\1\25\1\uffff\5\25\1\63\2\25\1\27\1\63\1\25";
    static final String DFA19_maxS =
        "\1\25\1\62\4\25\1\27\1\uffff\1\64\1\uffff\5\62\1\64\1\30\1\54\1"+
        "\27\1\64\1\62";
    static final String DFA19_acceptS =
        "\7\uffff\1\1\1\uffff\1\2\13\uffff";
    static final String DFA19_specialS =
        "\25\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\1",
            "\1\7\25\uffff\1\3\1\11\1\5\1\2\1\4\1\6\1\uffff\1\10",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15",
            "\1\16",
            "",
            "\1\17\1\uffff\2\17\32\uffff\1\20\1\21",
            "",
            "\1\7\25\uffff\1\3\1\11\1\5\1\2\1\4\1\6\1\uffff\1\10",
            "\1\7\25\uffff\1\3\1\11\1\5\1\2\1\4\1\6\1\uffff\1\10",
            "\1\7\25\uffff\1\3\1\11\1\5\1\2\1\4\1\6\1\uffff\1\10",
            "\1\7\25\uffff\1\3\1\11\1\5\1\2\1\4\1\6\1\uffff\1\10",
            "\1\7\25\uffff\1\3\1\11\1\5\1\2\1\4\1\6\1\22\1\10",
            "\1\20\1\21",
            "\1\23\1\uffff\2\23",
            "\1\7\26\uffff\1\11",
            "\1\24",
            "\1\20\1\21",
            "\1\7\25\uffff\1\3\1\11\1\5\1\2\1\4\1\6\1\uffff\1\10"
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "()+ loopback of 77:4: ( markup )+";
        }
    }
    static final String DFA25_eotS =
        "\25\uffff";
    static final String DFA25_eofS =
        "\25\uffff";
    static final String DFA25_minS =
        "\6\25\1\27\1\25\2\uffff\5\25\1\63\2\25\1\27\1\63\1\25";
    static final String DFA25_maxS =
        "\1\25\1\101\4\25\1\27\1\64\2\uffff\5\101\1\64\1\30\1\101\1\27\1"+
        "\64\1\101";
    static final String DFA25_acceptS =
        "\10\uffff\1\2\1\1\13\uffff";
    static final String DFA25_specialS =
        "\25\uffff}>";
    static final String[] DFA25_transitionS = {
            "\1\1",
            "\1\11\25\uffff\1\3\1\uffff\1\5\1\2\1\4\1\6\1\uffff\1\7\16\uffff"+
            "\1\10",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15",
            "\1\16",
            "\1\17\1\uffff\2\17\32\uffff\1\20\1\21",
            "",
            "",
            "\1\11\25\uffff\1\3\1\uffff\1\5\1\2\1\4\1\6\1\uffff\1\7\16\uffff"+
            "\1\10",
            "\1\11\25\uffff\1\3\1\uffff\1\5\1\2\1\4\1\6\1\uffff\1\7\16\uffff"+
            "\1\10",
            "\1\11\25\uffff\1\3\1\uffff\1\5\1\2\1\4\1\6\1\uffff\1\7\16\uffff"+
            "\1\10",
            "\1\11\25\uffff\1\3\1\uffff\1\5\1\2\1\4\1\6\1\uffff\1\7\16\uffff"+
            "\1\10",
            "\1\11\25\uffff\1\3\1\uffff\1\5\1\2\1\4\1\6\1\22\1\7\16\uffff"+
            "\1\10",
            "\1\20\1\21",
            "\1\23\1\uffff\2\23",
            "\1\11\53\uffff\1\10",
            "\1\24",
            "\1\20\1\21",
            "\1\11\25\uffff\1\3\1\uffff\1\5\1\2\1\4\1\6\1\uffff\1\7\16\uffff"+
            "\1\10"
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
            return "()* loopback of 91:4: ( markup )*";
        }
    }
    static final String DFA27_eotS =
        "\5\uffff";
    static final String DFA27_eofS =
        "\5\uffff";
    static final String DFA27_minS =
        "\1\101\2\32\2\uffff";
    static final String DFA27_maxS =
        "\1\101\2\100\2\uffff";
    static final String DFA27_acceptS =
        "\3\uffff\1\1\1\2";
    static final String DFA27_specialS =
        "\5\uffff}>";
    static final String[] DFA27_transitionS = {
            "\1\1",
            "\1\2\44\uffff\1\3\1\4",
            "\1\2\44\uffff\1\3\1\4",
            "",
            ""
    };

    static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
    static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
    static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
    static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
    static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
    static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
    static final short[][] DFA27_transition;

    static {
        int numStates = DFA27_transitionS.length;
        DFA27_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = DFA27_eot;
            this.eof = DFA27_eof;
            this.min = DFA27_min;
            this.max = DFA27_max;
            this.accept = DFA27_accept;
            this.special = DFA27_special;
            this.transition = DFA27_transition;
        }
        public String getDescription() {
            return "92:1: texttail : ( posttext | midtext embed texttail );";
        }
    }
    static final String DFA37_eotS =
        "\25\uffff";
    static final String DFA37_eofS =
        "\25\uffff";
    static final String DFA37_minS =
        "\6\25\1\27\1\25\2\uffff\5\25\1\63\2\25\1\27\1\63\1\25";
    static final String DFA37_maxS =
        "\1\25\1\62\4\25\1\27\1\64\2\uffff\5\62\1\64\1\30\1\54\1\27\1\64"+
        "\1\62";
    static final String DFA37_acceptS =
        "\10\uffff\1\1\1\2\13\uffff";
    static final String DFA37_specialS =
        "\25\uffff}>";
    static final String[] DFA37_transitionS = {
            "\1\1",
            "\1\10\25\uffff\1\3\1\11\1\5\1\2\1\4\1\6\1\uffff\1\7",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15",
            "\1\16",
            "\1\17\1\uffff\2\17\32\uffff\1\20\1\21",
            "",
            "",
            "\1\10\25\uffff\1\3\1\11\1\5\1\2\1\4\1\6\1\uffff\1\7",
            "\1\10\25\uffff\1\3\1\11\1\5\1\2\1\4\1\6\1\uffff\1\7",
            "\1\10\25\uffff\1\3\1\11\1\5\1\2\1\4\1\6\1\uffff\1\7",
            "\1\10\25\uffff\1\3\1\11\1\5\1\2\1\4\1\6\1\uffff\1\7",
            "\1\10\25\uffff\1\3\1\11\1\5\1\2\1\4\1\6\1\22\1\7",
            "\1\20\1\21",
            "\1\23\1\uffff\2\23",
            "\1\10\26\uffff\1\11",
            "\1\24",
            "\1\20\1\21",
            "\1\10\25\uffff\1\3\1\11\1\5\1\2\1\4\1\6\1\uffff\1\7"
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
            return "()+ loopback of 77:4: ( markup )+";
        }
    }
 

    public static final BitSet FOLLOW_MODULE_in_module226 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_moduleId_in_module236 = new BitSet(new long[]{0x00000000000001E0L});
    public static final BitSet FOLLOW_moduleElement_in_module250 = new BitSet(new long[]{0x00000000000001E0L});
    public static final BitSet FOLLOW_END_in_module261 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_module263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_moduleId273 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_moduleId277 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_IDCON_in_moduleId279 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_imprt_in_moduleElement290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_site_in_moduleElement294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_moduleElement298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_imprt307 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_moduleId_in_imprt309 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_imprt311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SITE_in_site321 = new BitSet(new long[]{0x0000100000400100L});
    public static final BitSet FOLLOW_mappings_in_site323 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_END_in_site325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapping_in_mappings333 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_mappings338 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_mapping_in_mappings340 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_PATH_in_mapping352 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_mapping354 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_markup_in_mapping356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_designator_in_markup366 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_arguments_in_markup368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_designator_in_markup372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_designator380 = new BitSet(new long[]{0x0001E80000000002L});
    public static final BitSet FOLLOW_attribute_in_designator382 = new BitSet(new long[]{0x0001E80000000002L});
    public static final BitSet FOLLOW_46_in_attribute391 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_IDCON_in_attribute393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_attribute397 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_IDCON_in_attribute399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_attribute403 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_IDCON_in_attribute405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_attribute409 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_IDCON_in_attribute411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_attribute419 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_NATCON_in_attribute421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_attribute425 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_NATCON_in_attribute427 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_attribute429 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_NATCON_in_attribute431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_arguments438 = new BitSet(new long[]{0x0018000001A00000L});
    public static final BitSet FOLLOW_argument_in_arguments440 = new BitSet(new long[]{0x0018000000000000L});
    public static final BitSet FOLLOW_51_in_arguments445 = new BitSet(new long[]{0x0000000001A00000L});
    public static final BitSet FOLLOW_argument_in_arguments447 = new BitSet(new long[]{0x0018000000000000L});
    public static final BitSet FOLLOW_52_in_arguments452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_argument461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_expression0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_field487 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_field489 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_IDCON_in_field491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_cat500 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_cat502 = new BitSet(new long[]{0x0000000001A00000L});
    public static final BitSet FOLLOW_expression_in_cat504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_list513 = new BitSet(new long[]{0x0000000001A00000L});
    public static final BitSet FOLLOW_expression_in_list515 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_list519 = new BitSet(new long[]{0x0000000001A00000L});
    public static final BitSet FOLLOW_expression_in_list521 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_list525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_record534 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_keyvaluepair_in_record536 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_record540 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_keyvaluepair_in_record542 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_record546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_keyvaluepair555 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_keyvaluepair557 = new BitSet(new long[]{0x0000000001A00000L});
    public static final BitSet FOLLOW_expression_in_keyvaluepair559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEF_in_function568 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_IDCON_in_function570 = new BitSet(new long[]{0x0504000002219B00L});
    public static final BitSet FOLLOW_formals_in_function572 = new BitSet(new long[]{0x0500000002219B00L});
    public static final BitSet FOLLOW_statement_in_function574 = new BitSet(new long[]{0x0500000002219B00L});
    public static final BitSet FOLLOW_END_in_function577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_formals584 = new BitSet(new long[]{0x0018000000200000L});
    public static final BitSet FOLLOW_IDCON_in_formals586 = new BitSet(new long[]{0x0018000000000000L});
    public static final BitSet FOLLOW_51_in_formals591 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_IDCON_in_formals593 = new BitSet(new long[]{0x0018000000000000L});
    public static final BitSet FOLLOW_52_in_formals598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_statement609 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_statement611 = new BitSet(new long[]{0x1000000001A00000L});
    public static final BitSet FOLLOW_predicate_in_statement613 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_statement615 = new BitSet(new long[]{0x0500000002219A00L});
    public static final BitSet FOLLOW_statement_in_statement617 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ELSE_in_statement619 = new BitSet(new long[]{0x0500000002219A00L});
    public static final BitSet FOLLOW_statement_in_statement621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_statement629 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_statement631 = new BitSet(new long[]{0x1000000001A00000L});
    public static final BitSet FOLLOW_predicate_in_statement633 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_statement635 = new BitSet(new long[]{0x0500000002219A00L});
    public static final BitSet FOLLOW_statement_in_statement637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EACH_in_statement644 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_statement646 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_IDCON_in_statement648 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_statement650 = new BitSet(new long[]{0x0000000001A00000L});
    public static final BitSet FOLLOW_expression_in_statement652 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_statement654 = new BitSet(new long[]{0x0500000002219A00L});
    public static final BitSet FOLLOW_statement_in_statement656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LET_in_statement664 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_assignment_in_statement666 = new BitSet(new long[]{0x0000000000202000L});
    public static final BitSet FOLLOW_IN_in_statement669 = new BitSet(new long[]{0x0500000002219B00L});
    public static final BitSet FOLLOW_statement_in_statement671 = new BitSet(new long[]{0x0500000002219B00L});
    public static final BitSet FOLLOW_END_in_statement674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_statement681 = new BitSet(new long[]{0x0700000002219A00L});
    public static final BitSet FOLLOW_statement_in_statement683 = new BitSet(new long[]{0x0700000002219A00L});
    public static final BitSet FOLLOW_57_in_statement686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRCON_in_statement693 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_statement695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ECHO_in_statement702 = new BitSet(new long[]{0x0000000001A00000L});
    public static final BitSet FOLLOW_expression_in_statement704 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_statement706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ECHO_in_statement713 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_embedding_in_statement715 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_statement717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CDATA_in_statement724 = new BitSet(new long[]{0x0000000001A00000L});
    public static final BitSet FOLLOW_expression_in_statement726 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_statement728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_statement736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement743 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_statement745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement752 = new BitSet(new long[]{0x0500000002219A00L});
    public static final BitSet FOLLOW_statement_in_statement755 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_statement757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement764 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_markup_in_statement767 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_statement769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement776 = new BitSet(new long[]{0x0000000001A00000L});
    public static final BitSet FOLLOW_expression_in_statement779 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_statement781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_assignment790 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_assignment792 = new BitSet(new long[]{0x0000000001A00000L});
    public static final BitSet FOLLOW_expression_in_assignment794 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_assignment796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_assignment804 = new BitSet(new long[]{0x0504000002219A00L});
    public static final BitSet FOLLOW_formals_in_assignment806 = new BitSet(new long[]{0x0500000002219A00L});
    public static final BitSet FOLLOW_statement_in_assignment808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_not_in_predicate822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_is_in_predicate828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_not836 = new BitSet(new long[]{0x1000000001A00000L});
    public static final BitSet FOLLOW_predicate_in_not838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_and849 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_and851 = new BitSet(new long[]{0x1000000001A00000L});
    public static final BitSet FOLLOW_predicate_in_and855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_or866 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_or868 = new BitSet(new long[]{0x1000000001A00000L});
    public static final BitSet FOLLOW_predicate_in_or872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_is881 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_is883 = new BitSet(new long[]{0x00000000001C0000L});
    public static final BitSet FOLLOW_type_in_is885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pretext_in_embedding912 = new BitSet(new long[]{0x0000000001A00000L});
    public static final BitSet FOLLOW_embed_in_embedding914 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_texttail_in_embedding916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed926 = new BitSet(new long[]{0x0000000001A00000L});
    public static final BitSet FOLLOW_expression_in_embed929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed936 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_markup_in_embed939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_posttext_in_texttail947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_midtext_in_texttail951 = new BitSet(new long[]{0x0000000001A00000L});
    public static final BitSet FOLLOW_embed_in_texttail953 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_texttail_in_texttail955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_pretext963 = new BitSet(new long[]{0x0000000004000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_TEXTCHAR_in_pretext965 = new BitSet(new long[]{0x0000000004000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_pretext968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_posttext976 = new BitSet(new long[]{0x8000000004000000L});
    public static final BitSet FOLLOW_TEXTCHAR_in_posttext978 = new BitSet(new long[]{0x8000000004000000L});
    public static final BitSet FOLLOW_63_in_posttext981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_midtext989 = new BitSet(new long[]{0x0000000004000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_TEXTCHAR_in_midtext991 = new BitSet(new long[]{0x0000000004000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_midtext994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_synpred22_Waebric609 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_synpred22_Waebric611 = new BitSet(new long[]{0x1000000001A00000L});
    public static final BitSet FOLLOW_predicate_in_synpred22_Waebric613 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_synpred22_Waebric615 = new BitSet(new long[]{0x0500000002219A00L});
    public static final BitSet FOLLOW_statement_in_synpred22_Waebric617 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ELSE_in_synpred22_Waebric619 = new BitSet(new long[]{0x0500000002219A00L});
    public static final BitSet FOLLOW_statement_in_synpred22_Waebric621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_synpred23_Waebric629 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_synpred23_Waebric631 = new BitSet(new long[]{0x1000000001A00000L});
    public static final BitSet FOLLOW_predicate_in_synpred23_Waebric633 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_synpred23_Waebric635 = new BitSet(new long[]{0x0500000002219A00L});
    public static final BitSet FOLLOW_statement_in_synpred23_Waebric637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ECHO_in_synpred31_Waebric702 = new BitSet(new long[]{0x0000000001A00000L});
    public static final BitSet FOLLOW_expression_in_synpred31_Waebric704 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_synpred31_Waebric706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ECHO_in_synpred32_Waebric713 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_embedding_in_synpred32_Waebric715 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_synpred32_Waebric717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred35_Waebric743 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_synpred35_Waebric745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred36_Waebric752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred37_Waebric752 = new BitSet(new long[]{0x0500000002219A00L});
    public static final BitSet FOLLOW_statement_in_synpred37_Waebric755 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_synpred37_Waebric757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred39_Waebric764 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_markup_in_synpred39_Waebric767 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_synpred39_Waebric769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred47_Waebric926 = new BitSet(new long[]{0x0000000001A00000L});
    public static final BitSet FOLLOW_expression_in_synpred47_Waebric929 = new BitSet(new long[]{0x0000000000000002L});

}