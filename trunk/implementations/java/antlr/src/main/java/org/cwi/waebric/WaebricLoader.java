// $ANTLR 3.1.2 /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g 2009-08-13 16:10:19

	package org.cwi.waebric;
	import java.util.HashMap;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class WaebricLoader extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "MARKUP_STATEMENT", "IDCON", "PATH", "NATCON", "TEXT", "SYMBOLCON", "STRCON", "PRETEXT", "POSTTEXT", "MIDTEXT", "COMMENT", "SITE", "END", "SEMICOLON", "LETTER", "DIGIT", "HEXADECIMAL", "PATHELEMENT", "FILEEXT", "STRCHAR", "ESCLAYOUT", "DECIMAL", "TEXTCHAR", "ESCQUOTE", "AMP", "CHARREF", "ENTREF", "SYMBOLCHAR", "COMMENTS", "LAYOUT", "'module'", "'.'", "'import'", "':'", "'#'", "'$'", "'@'", "'%'", "'('", "','", "')'", "'['", "']'", "'{'", "'}'", "'+'", "'def'", "'if'", "'else'", "'each'", "'let'", "'in'", "'echo'", "'cdata'", "'yield;'", "'='", "'!'", "'&&'", "'||'", "'list'", "'record'", "'string'"
    };
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int LETTER=18;
    public static final int AMP=28;
    public static final int ESCLAYOUT=24;
    public static final int PATHELEMENT=21;
    public static final int PRETEXT=11;
    public static final int STRCON=10;
    public static final int TEXTCHAR=26;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int POSTTEXT=12;
    public static final int EOF=-1;
    public static final int MARKUP_STATEMENT=4;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int FILEEXT=22;
    public static final int T__52=52;
    public static final int COMMENTS=32;
    public static final int CHARREF=29;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int IDCON=5;
    public static final int PATH=6;
    public static final int T__59=59;
    public static final int STRCHAR=23;
    public static final int DIGIT=19;
    public static final int COMMENT=14;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int MIDTEXT=13;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int SYMBOLCON=9;
    public static final int SITE=15;
    public static final int HEXADECIMAL=20;
    public static final int SEMICOLON=17;
    public static final int SYMBOLCHAR=31;
    public static final int TEXT=8;
    public static final int LAYOUT=33;
    public static final int NATCON=7;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int DECIMAL=25;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int ENTREF=30;
    public static final int ESCQUOTE=27;
    public static final int END=16;

    // delegates
    // delegators


        public WaebricLoader(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public WaebricLoader(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return WaebricLoader.tokenNames; }
    public String getGrammarFileName() { return "/ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g"; }


    	private final HashMap<String,CommonTree> functions = new HashMap<String,CommonTree>();
    	public HashMap<String,CommonTree> getFunctions() throws RecognitionException {
    		functions.clear();
    		this.module();
    		return functions;
    	}


    public static class module_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "module"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:24:1: module : ^( 'module' moduleId ( imprt )* ( site )* ( function )* ) ;
    public final WaebricLoader.module_return module() throws RecognitionException {
        WaebricLoader.module_return retval = new WaebricLoader.module_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal1=null;
        WaebricLoader.moduleId_return moduleId2 = null;

        WaebricLoader.imprt_return imprt3 = null;

        WaebricLoader.site_return site4 = null;

        WaebricLoader.function_return function5 = null;


        CommonTree string_literal1_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:24:7: ( ^( 'module' moduleId ( imprt )* ( site )* ( function )* ) )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:24:11: ^( 'module' moduleId ( imprt )* ( site )* ( function )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal1=(CommonTree)match(input,34,FOLLOW_34_in_module57); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal1_tree = (CommonTree)adaptor.dupNode(string_literal1);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal1_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_moduleId_in_module59);
            moduleId2=moduleId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, moduleId2.getTree());
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:24:32: ( imprt )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==36) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: imprt
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_imprt_in_module61);
            	    imprt3=imprt();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, imprt3.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:24:39: ( site )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==SITE) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: site
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_site_in_module64);
            	    site4=site();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, site4.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:24:45: ( function )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==50) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: function
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_function_in_module67);
            	    function5=function();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, function5.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "module"

    public static class moduleId_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "moduleId"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:25:1: moduleId : IDCON ( '.' e= IDCON )* ;
    public final WaebricLoader.moduleId_return moduleId() throws RecognitionException {
        WaebricLoader.moduleId_return retval = new WaebricLoader.moduleId_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree e=null;
        CommonTree IDCON6=null;
        CommonTree char_literal7=null;

        CommonTree e_tree=null;
        CommonTree IDCON6_tree=null;
        CommonTree char_literal7_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:25:9: ( IDCON ( '.' e= IDCON )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:25:12: IDCON ( '.' e= IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON6=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_moduleId78); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON6_tree = (CommonTree)adaptor.dupNode(IDCON6);

            adaptor.addChild(root_0, IDCON6_tree);
            }
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:25:18: ( '.' e= IDCON )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==35) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:25:20: '.' e= IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal7=(CommonTree)match(input,35,FOLLOW_35_in_moduleId82); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal7_tree = (CommonTree)adaptor.dupNode(char_literal7);

            	    adaptor.addChild(root_0, char_literal7_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    e=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_moduleId86); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    e_tree = (CommonTree)adaptor.dupNode(e);

            	    adaptor.addChild(root_0, e_tree);
            	    }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "moduleId"

    public static class imprt_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "imprt"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:26:1: imprt : 'import' moduleId ';' module ;
    public final WaebricLoader.imprt_return imprt() throws RecognitionException {
        WaebricLoader.imprt_return retval = new WaebricLoader.imprt_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal8=null;
        CommonTree char_literal10=null;
        WaebricLoader.moduleId_return moduleId9 = null;

        WaebricLoader.module_return module11 = null;


        CommonTree string_literal8_tree=null;
        CommonTree char_literal10_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:26:6: ( 'import' moduleId ';' module )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:26:10: 'import' moduleId ';' module
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal8=(CommonTree)match(input,36,FOLLOW_36_in_imprt98); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal8_tree = (CommonTree)adaptor.dupNode(string_literal8);

            adaptor.addChild(root_0, string_literal8_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_moduleId_in_imprt100);
            moduleId9=moduleId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, moduleId9.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal10=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_imprt102); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal10_tree = (CommonTree)adaptor.dupNode(char_literal10);

            root_0 = (CommonTree)adaptor.becomeRoot(char_literal10_tree, root_0);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_module_in_imprt106);
            module11=module();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, module11.getTree());

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "imprt"

    public static class site_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "site"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:31:1: site : 'site' mappings 'end' ;
    public final WaebricLoader.site_return site() throws RecognitionException {
        WaebricLoader.site_return retval = new WaebricLoader.site_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal12=null;
        CommonTree string_literal14=null;
        WaebricLoader.mappings_return mappings13 = null;


        CommonTree string_literal12_tree=null;
        CommonTree string_literal14_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:31:5: ( 'site' mappings 'end' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:31:9: 'site' mappings 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal12=(CommonTree)match(input,SITE,FOLLOW_SITE_in_site119); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal12_tree = (CommonTree)adaptor.dupNode(string_literal12);

            adaptor.addChild(root_0, string_literal12_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_mappings_in_site121);
            mappings13=mappings();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, mappings13.getTree());
            _last = (CommonTree)input.LT(1);
            string_literal14=(CommonTree)match(input,END,FOLLOW_END_in_site123); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal14_tree = (CommonTree)adaptor.dupNode(string_literal14);

            adaptor.addChild(root_0, string_literal14_tree);
            }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "site"

    public static class mappings_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mappings"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:32:1: mappings : ( mapping )? ( ';' mapping )* ;
    public final WaebricLoader.mappings_return mappings() throws RecognitionException {
        WaebricLoader.mappings_return retval = new WaebricLoader.mappings_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal16=null;
        WaebricLoader.mapping_return mapping15 = null;

        WaebricLoader.mapping_return mapping17 = null;


        CommonTree char_literal16_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:32:9: ( ( mapping )? ( ';' mapping )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:32:12: ( mapping )? ( ';' mapping )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:32:12: ( mapping )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==PATH) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: mapping
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_mapping_in_mappings131);
                    mapping15=mapping();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, mapping15.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:32:21: ( ';' mapping )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==SEMICOLON) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:32:23: ';' mapping
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal16=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_mappings136); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal16_tree = (CommonTree)adaptor.dupNode(char_literal16);

            	    adaptor.addChild(root_0, char_literal16_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_mapping_in_mappings138);
            	    mapping17=mapping();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, mapping17.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "mappings"

    public static class mapping_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mapping"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:33:1: mapping : PATH ':' markup ;
    public final WaebricLoader.mapping_return mapping() throws RecognitionException {
        WaebricLoader.mapping_return retval = new WaebricLoader.mapping_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PATH18=null;
        CommonTree char_literal19=null;
        WaebricLoader.markup_return markup20 = null;


        CommonTree PATH18_tree=null;
        CommonTree char_literal19_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:33:9: ( PATH ':' markup )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:33:12: PATH ':' markup
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PATH18=(CommonTree)match(input,PATH,FOLLOW_PATH_in_mapping150); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PATH18_tree = (CommonTree)adaptor.dupNode(PATH18);

            adaptor.addChild(root_0, PATH18_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal19=(CommonTree)match(input,37,FOLLOW_37_in_mapping152); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal19_tree = (CommonTree)adaptor.dupNode(char_literal19);

            adaptor.addChild(root_0, char_literal19_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_markup_in_mapping154);
            markup20=markup();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, markup20.getTree());

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "mapping"

    public static class markup_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "markup"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:38:1: markup : designator ( arguments )? ;
    public final WaebricLoader.markup_return markup() throws RecognitionException {
        WaebricLoader.markup_return retval = new WaebricLoader.markup_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricLoader.designator_return designator21 = null;

        WaebricLoader.arguments_return arguments22 = null;



        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:38:7: ( designator ( arguments )? )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:38:11: designator ( arguments )?
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_designator_in_markup167);
            designator21=designator();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, designator21.getTree());
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:38:22: ( arguments )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==42) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: arguments
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_arguments_in_markup169);
                    arguments22=arguments();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, arguments22.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "markup"

    public static class designator_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "designator"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:39:1: designator : IDCON ( attribute )* ;
    public final WaebricLoader.designator_return designator() throws RecognitionException {
        WaebricLoader.designator_return retval = new WaebricLoader.designator_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON23=null;
        WaebricLoader.attribute_return attribute24 = null;


        CommonTree IDCON23_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:39:11: ( IDCON ( attribute )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:39:14: IDCON ( attribute )*
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON23=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_designator178); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON23_tree = (CommonTree)adaptor.dupNode(IDCON23);

            adaptor.addChild(root_0, IDCON23_tree);
            }
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:39:20: ( attribute )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==35||(LA8_0>=37 && LA8_0<=40)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: attribute
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_attribute_in_designator180);
            	    attribute24=attribute();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, attribute24.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "designator"

    public static class attribute_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attribute"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:40:1: attribute : ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON );
    public final WaebricLoader.attribute_return attribute() throws RecognitionException {
        WaebricLoader.attribute_return retval = new WaebricLoader.attribute_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal25=null;
        CommonTree IDCON26=null;
        CommonTree char_literal27=null;
        CommonTree IDCON28=null;
        CommonTree char_literal29=null;
        CommonTree IDCON30=null;
        CommonTree char_literal31=null;
        CommonTree IDCON32=null;
        CommonTree char_literal33=null;
        CommonTree NATCON34=null;
        CommonTree char_literal35=null;
        CommonTree NATCON36=null;
        CommonTree char_literal37=null;
        CommonTree NATCON38=null;

        CommonTree char_literal25_tree=null;
        CommonTree IDCON26_tree=null;
        CommonTree char_literal27_tree=null;
        CommonTree IDCON28_tree=null;
        CommonTree char_literal29_tree=null;
        CommonTree IDCON30_tree=null;
        CommonTree char_literal31_tree=null;
        CommonTree IDCON32_tree=null;
        CommonTree char_literal33_tree=null;
        CommonTree NATCON34_tree=null;
        CommonTree char_literal35_tree=null;
        CommonTree NATCON36_tree=null;
        CommonTree char_literal37_tree=null;
        CommonTree NATCON38_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:40:10: ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON )
            int alt9=6;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt9=1;
                }
                break;
            case 35:
                {
                alt9=2;
                }
                break;
            case 39:
                {
                alt9=3;
                }
                break;
            case 37:
                {
                alt9=4;
                }
                break;
            case 40:
                {
                int LA9_5 = input.LA(2);

                if ( (LA9_5==NATCON) ) {
                    int LA9_6 = input.LA(3);

                    if ( (LA9_6==41) ) {
                        alt9=6;
                    }
                    else if ( (LA9_6==EOF||(LA9_6>=MARKUP_STATEMENT && LA9_6<=IDCON)||(LA9_6>=NATCON && LA9_6<=SYMBOLCON)||(LA9_6>=PRETEXT && LA9_6<=COMMENT)||(LA9_6>=END && LA9_6<=SEMICOLON)||LA9_6==35||(LA9_6>=37 && LA9_6<=40)||LA9_6==42||LA9_6==45||LA9_6==47||LA9_6==51||(LA9_6>=53 && LA9_6<=54)||(LA9_6>=56 && LA9_6<=58)) ) {
                        alt9=5;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 5, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:40:13: '#' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal25=(CommonTree)match(input,38,FOLLOW_38_in_attribute189); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal25_tree = (CommonTree)adaptor.dupNode(char_literal25);

                    adaptor.addChild(root_0, char_literal25_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON26=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute191); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON26_tree = (CommonTree)adaptor.dupNode(IDCON26);

                    adaptor.addChild(root_0, IDCON26_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:41:6: '.' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal27=(CommonTree)match(input,35,FOLLOW_35_in_attribute199); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal27_tree = (CommonTree)adaptor.dupNode(char_literal27);

                    adaptor.addChild(root_0, char_literal27_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON28=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute201); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON28_tree = (CommonTree)adaptor.dupNode(IDCON28);

                    adaptor.addChild(root_0, IDCON28_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:42:6: '$' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal29=(CommonTree)match(input,39,FOLLOW_39_in_attribute209); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal29_tree = (CommonTree)adaptor.dupNode(char_literal29);

                    adaptor.addChild(root_0, char_literal29_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON30=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute211); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON30_tree = (CommonTree)adaptor.dupNode(IDCON30);

                    adaptor.addChild(root_0, IDCON30_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:43:6: ':' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal31=(CommonTree)match(input,37,FOLLOW_37_in_attribute219); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal31_tree = (CommonTree)adaptor.dupNode(char_literal31);

                    adaptor.addChild(root_0, char_literal31_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON32=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute221); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON32_tree = (CommonTree)adaptor.dupNode(IDCON32);

                    adaptor.addChild(root_0, IDCON32_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:44:6: '@' NATCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal33=(CommonTree)match(input,40,FOLLOW_40_in_attribute229); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal33_tree = (CommonTree)adaptor.dupNode(char_literal33);

                    adaptor.addChild(root_0, char_literal33_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    NATCON34=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_attribute231); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON34_tree = (CommonTree)adaptor.dupNode(NATCON34);

                    adaptor.addChild(root_0, NATCON34_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:45:6: '@' NATCON '%' NATCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal35=(CommonTree)match(input,40,FOLLOW_40_in_attribute239); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal35_tree = (CommonTree)adaptor.dupNode(char_literal35);

                    adaptor.addChild(root_0, char_literal35_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    NATCON36=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_attribute241); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON36_tree = (CommonTree)adaptor.dupNode(NATCON36);

                    adaptor.addChild(root_0, NATCON36_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal37=(CommonTree)match(input,41,FOLLOW_41_in_attribute243); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal37_tree = (CommonTree)adaptor.dupNode(char_literal37);

                    adaptor.addChild(root_0, char_literal37_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    NATCON38=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_attribute245); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON38_tree = (CommonTree)adaptor.dupNode(NATCON38);

                    adaptor.addChild(root_0, NATCON38_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "attribute"

    public static class arguments_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arguments"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:46:1: arguments : '(' ( argument )? ( ',' argument )* ')' ;
    public final WaebricLoader.arguments_return arguments() throws RecognitionException {
        WaebricLoader.arguments_return retval = new WaebricLoader.arguments_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal39=null;
        CommonTree char_literal41=null;
        CommonTree char_literal43=null;
        WaebricLoader.argument_return argument40 = null;

        WaebricLoader.argument_return argument42 = null;


        CommonTree char_literal39_tree=null;
        CommonTree char_literal41_tree=null;
        CommonTree char_literal43_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:46:10: ( '(' ( argument )? ( ',' argument )* ')' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:46:13: '(' ( argument )? ( ',' argument )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            char_literal39=(CommonTree)match(input,42,FOLLOW_42_in_arguments253); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal39_tree = (CommonTree)adaptor.dupNode(char_literal39);

            adaptor.addChild(root_0, char_literal39_tree);
            }
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:46:17: ( argument )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==IDCON||(LA10_0>=NATCON && LA10_0<=SYMBOLCON)||LA10_0==45||LA10_0==47) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: argument
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_argument_in_arguments255);
                    argument40=argument();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, argument40.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:46:27: ( ',' argument )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==43) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:46:29: ',' argument
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal41=(CommonTree)match(input,43,FOLLOW_43_in_arguments260); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal41_tree = (CommonTree)adaptor.dupNode(char_literal41);

            	    adaptor.addChild(root_0, char_literal41_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_argument_in_arguments262);
            	    argument42=argument();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, argument42.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            char_literal43=(CommonTree)match(input,44,FOLLOW_44_in_arguments267); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal43_tree = (CommonTree)adaptor.dupNode(char_literal43);

            adaptor.addChild(root_0, char_literal43_tree);
            }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "arguments"

    public static class argument_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "argument"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:47:1: argument : expression ;
    public final WaebricLoader.argument_return argument() throws RecognitionException {
        WaebricLoader.argument_return retval = new WaebricLoader.argument_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricLoader.expression_return expression44 = null;



        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:47:9: ( expression )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:47:12: expression
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_argument275);
            expression44=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, expression44.getTree());

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "argument"

    public static class expression_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:52:1: expression : ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* ;
    public final WaebricLoader.expression_return expression() throws RecognitionException {
        WaebricLoader.expression_return retval = new WaebricLoader.expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON45=null;
        CommonTree NATCON46=null;
        CommonTree TEXT47=null;
        CommonTree SYMBOLCON48=null;
        CommonTree char_literal49=null;
        CommonTree char_literal51=null;
        CommonTree char_literal53=null;
        CommonTree char_literal54=null;
        CommonTree char_literal56=null;
        CommonTree char_literal58=null;
        CommonTree char_literal59=null;
        CommonTree char_literal61=null;
        CommonTree IDCON62=null;
        WaebricLoader.expression_return expression50 = null;

        WaebricLoader.expression_return expression52 = null;

        WaebricLoader.keyValuePair_return keyValuePair55 = null;

        WaebricLoader.keyValuePair_return keyValuePair57 = null;

        WaebricLoader.expression_return expression60 = null;


        CommonTree IDCON45_tree=null;
        CommonTree NATCON46_tree=null;
        CommonTree TEXT47_tree=null;
        CommonTree SYMBOLCON48_tree=null;
        CommonTree char_literal49_tree=null;
        CommonTree char_literal51_tree=null;
        CommonTree char_literal53_tree=null;
        CommonTree char_literal54_tree=null;
        CommonTree char_literal56_tree=null;
        CommonTree char_literal58_tree=null;
        CommonTree char_literal59_tree=null;
        CommonTree char_literal61_tree=null;
        CommonTree IDCON62_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:52:11: ( ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:52:14: ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:52:14: ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' )
            int alt16=6;
            switch ( input.LA(1) ) {
            case IDCON:
                {
                alt16=1;
                }
                break;
            case NATCON:
                {
                alt16=2;
                }
                break;
            case TEXT:
                {
                alt16=3;
                }
                break;
            case SYMBOLCON:
                {
                alt16=4;
                }
                break;
            case 45:
                {
                alt16=5;
                }
                break;
            case 47:
                {
                alt16=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:52:16: IDCON
                    {
                    _last = (CommonTree)input.LT(1);
                    IDCON45=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression289); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON45_tree = (CommonTree)adaptor.dupNode(IDCON45);

                    adaptor.addChild(root_0, IDCON45_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:52:24: NATCON
                    {
                    _last = (CommonTree)input.LT(1);
                    NATCON46=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_expression293); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON46_tree = (CommonTree)adaptor.dupNode(NATCON46);

                    adaptor.addChild(root_0, NATCON46_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:52:33: TEXT
                    {
                    _last = (CommonTree)input.LT(1);
                    TEXT47=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_expression297); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TEXT47_tree = (CommonTree)adaptor.dupNode(TEXT47);

                    adaptor.addChild(root_0, TEXT47_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:52:40: SYMBOLCON
                    {
                    _last = (CommonTree)input.LT(1);
                    SYMBOLCON48=(CommonTree)match(input,SYMBOLCON,FOLLOW_SYMBOLCON_in_expression301); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SYMBOLCON48_tree = (CommonTree)adaptor.dupNode(SYMBOLCON48);

                    adaptor.addChild(root_0, SYMBOLCON48_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:53:7: '[' ( expression )? ( ',' expression )* ']'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal49=(CommonTree)match(input,45,FOLLOW_45_in_expression310); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal49_tree = (CommonTree)adaptor.dupNode(char_literal49);

                    adaptor.addChild(root_0, char_literal49_tree);
                    }
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:53:11: ( expression )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==IDCON||(LA12_0>=NATCON && LA12_0<=SYMBOLCON)||LA12_0==45||LA12_0==47) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: expression
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_expression_in_expression312);
                            expression50=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, expression50.getTree());

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:53:23: ( ',' expression )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==43) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:53:25: ',' expression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal51=(CommonTree)match(input,43,FOLLOW_43_in_expression317); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal51_tree = (CommonTree)adaptor.dupNode(char_literal51);

                    	    adaptor.addChild(root_0, char_literal51_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_expression_in_expression319);
                    	    expression52=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, expression52.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal53=(CommonTree)match(input,46,FOLLOW_46_in_expression324); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal53_tree = (CommonTree)adaptor.dupNode(char_literal53);

                    adaptor.addChild(root_0, char_literal53_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:54:7: '{' ( keyValuePair )? ( ',' keyValuePair )* '}'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal54=(CommonTree)match(input,47,FOLLOW_47_in_expression333); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal54_tree = (CommonTree)adaptor.dupNode(char_literal54);

                    adaptor.addChild(root_0, char_literal54_tree);
                    }
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:54:11: ( keyValuePair )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==IDCON) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: keyValuePair
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_keyValuePair_in_expression335);
                            keyValuePair55=keyValuePair();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, keyValuePair55.getTree());

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:54:25: ( ',' keyValuePair )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==43) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:54:27: ',' keyValuePair
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal56=(CommonTree)match(input,43,FOLLOW_43_in_expression340); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal56_tree = (CommonTree)adaptor.dupNode(char_literal56);

                    	    adaptor.addChild(root_0, char_literal56_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_keyValuePair_in_expression342);
                    	    keyValuePair57=keyValuePair();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, keyValuePair57.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal58=(CommonTree)match(input,48,FOLLOW_48_in_expression347); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal58_tree = (CommonTree)adaptor.dupNode(char_literal58);

                    adaptor.addChild(root_0, char_literal58_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:55:6: ( '+' expression | '.' IDCON )*
            loop17:
            do {
                int alt17=3;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==49) ) {
                    int LA17_2 = input.LA(2);

                    if ( (synpred25_WaebricLoader()) ) {
                        alt17=1;
                    }


                }
                else if ( (LA17_0==35) ) {
                    int LA17_3 = input.LA(2);

                    if ( (synpred26_WaebricLoader()) ) {
                        alt17=2;
                    }


                }


                switch (alt17) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:55:8: '+' expression
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal59=(CommonTree)match(input,49,FOLLOW_49_in_expression357); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal59_tree = (CommonTree)adaptor.dupNode(char_literal59);

            	    adaptor.addChild(root_0, char_literal59_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expression_in_expression359);
            	    expression60=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, expression60.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:55:35: '.' IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal61=(CommonTree)match(input,35,FOLLOW_35_in_expression365); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal61_tree = (CommonTree)adaptor.dupNode(char_literal61);

            	    adaptor.addChild(root_0, char_literal61_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    IDCON62=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression367); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDCON62_tree = (CommonTree)adaptor.dupNode(IDCON62);

            	    adaptor.addChild(root_0, IDCON62_tree);
            	    }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expression"

    public static class keyValuePair_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "keyValuePair"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:56:1: keyValuePair : IDCON ':' expression ;
    public final WaebricLoader.keyValuePair_return keyValuePair() throws RecognitionException {
        WaebricLoader.keyValuePair_return retval = new WaebricLoader.keyValuePair_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON63=null;
        CommonTree char_literal64=null;
        WaebricLoader.expression_return expression65 = null;


        CommonTree IDCON63_tree=null;
        CommonTree char_literal64_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:56:13: ( IDCON ':' expression )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:56:16: IDCON ':' expression
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON63=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_keyValuePair380); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON63_tree = (CommonTree)adaptor.dupNode(IDCON63);

            adaptor.addChild(root_0, IDCON63_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal64=(CommonTree)match(input,37,FOLLOW_37_in_keyValuePair382); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal64_tree = (CommonTree)adaptor.dupNode(char_literal64);

            adaptor.addChild(root_0, char_literal64_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_keyValuePair384);
            expression65=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, expression65.getTree());

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "keyValuePair"

    public static class function_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:61:1: function : 'def' id= IDCON formals ( statement )* 'end' ;
    public final WaebricLoader.function_return function() throws RecognitionException {
        WaebricLoader.function_return retval = new WaebricLoader.function_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        CommonTree string_literal66=null;
        CommonTree string_literal69=null;
        WaebricLoader.formals_return formals67 = null;

        WaebricLoader.statement_return statement68 = null;


        CommonTree id_tree=null;
        CommonTree string_literal66_tree=null;
        CommonTree string_literal69_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:61:9: ( 'def' id= IDCON formals ( statement )* 'end' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:61:12: 'def' id= IDCON formals ( statement )* 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal66=(CommonTree)match(input,50,FOLLOW_50_in_function396); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal66_tree = (CommonTree)adaptor.dupNode(string_literal66);

            adaptor.addChild(root_0, string_literal66_tree);
            }
            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_function400); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (CommonTree)adaptor.dupNode(id);

            adaptor.addChild(root_0, id_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_formals_in_function402);
            formals67=formals();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, formals67.getTree());
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:61:35: ( statement )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==MARKUP_STATEMENT||LA18_0==COMMENT||LA18_0==47||LA18_0==51||(LA18_0>=53 && LA18_0<=54)||(LA18_0>=56 && LA18_0<=58)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_function404);
            	    statement68=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, statement68.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            string_literal69=(CommonTree)match(input,END,FOLLOW_END_in_function407); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal69_tree = (CommonTree)adaptor.dupNode(string_literal69);

            adaptor.addChild(root_0, string_literal69_tree);
            }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            		functions.put(id.getText(), ((CommonTree)retval.tree)); 
            	
        }
        return retval;
    }
    // $ANTLR end "function"

    public static class formals_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "formals"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:66:1: formals : ( '(' ( IDCON )* ')' )? ;
    public final WaebricLoader.formals_return formals() throws RecognitionException {
        WaebricLoader.formals_return retval = new WaebricLoader.formals_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal70=null;
        CommonTree IDCON71=null;
        CommonTree char_literal72=null;

        CommonTree char_literal70_tree=null;
        CommonTree IDCON71_tree=null;
        CommonTree char_literal72_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:66:8: ( ( '(' ( IDCON )* ')' )? )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:66:11: ( '(' ( IDCON )* ')' )?
            {
            root_0 = (CommonTree)adaptor.nil();

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:66:11: ( '(' ( IDCON )* ')' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==42) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:66:13: '(' ( IDCON )* ')'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal70=(CommonTree)match(input,42,FOLLOW_42_in_formals423); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal70_tree = (CommonTree)adaptor.dupNode(char_literal70);

                    adaptor.addChild(root_0, char_literal70_tree);
                    }
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:66:17: ( IDCON )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==IDCON) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: IDCON
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    IDCON71=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_formals425); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    IDCON71_tree = (CommonTree)adaptor.dupNode(IDCON71);

                    	    adaptor.addChild(root_0, IDCON71_tree);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal72=(CommonTree)match(input,44,FOLLOW_44_in_formals428); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal72_tree = (CommonTree)adaptor.dupNode(char_literal72);

                    adaptor.addChild(root_0, char_literal72_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "formals"

    public static class statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:72:1: statement : ( ^( 'if' '(' predicate ')' statement ( 'else' statement )? ) | ^( 'each' '(' IDCON ':' expression ')' statement ) | ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ^( MARKUP_STATEMENT ( markup )+ statement ) | ^( MARKUP_STATEMENT ( markup )+ embedding ) | ^( MARKUP_STATEMENT ( markup )+ ';' ) );
    public final WaebricLoader.statement_return statement() throws RecognitionException {
        WaebricLoader.statement_return retval = new WaebricLoader.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal73=null;
        CommonTree char_literal74=null;
        CommonTree char_literal76=null;
        CommonTree string_literal78=null;
        CommonTree string_literal80=null;
        CommonTree char_literal81=null;
        CommonTree IDCON82=null;
        CommonTree char_literal83=null;
        CommonTree char_literal85=null;
        CommonTree string_literal87=null;
        CommonTree string_literal89=null;
        CommonTree string_literal91=null;
        CommonTree char_literal92=null;
        CommonTree char_literal94=null;
        CommonTree string_literal95=null;
        CommonTree STRCON96=null;
        CommonTree char_literal97=null;
        CommonTree string_literal98=null;
        CommonTree char_literal100=null;
        CommonTree string_literal101=null;
        CommonTree char_literal103=null;
        CommonTree string_literal104=null;
        CommonTree char_literal106=null;
        CommonTree string_literal107=null;
        CommonTree MARKUP_STATEMENT108=null;
        CommonTree char_literal111=null;
        CommonTree MARKUP_STATEMENT112=null;
        CommonTree MARKUP_STATEMENT115=null;
        CommonTree MARKUP_STATEMENT118=null;
        CommonTree char_literal120=null;
        WaebricLoader.predicate_return predicate75 = null;

        WaebricLoader.statement_return statement77 = null;

        WaebricLoader.statement_return statement79 = null;

        WaebricLoader.expression_return expression84 = null;

        WaebricLoader.statement_return statement86 = null;

        WaebricLoader.assignment_return assignment88 = null;

        WaebricLoader.statement_return statement90 = null;

        WaebricLoader.statement_return statement93 = null;

        WaebricLoader.expression_return expression99 = null;

        WaebricLoader.embedding_return embedding102 = null;

        WaebricLoader.expression_return expression105 = null;

        WaebricLoader.markup_return markup109 = null;

        WaebricLoader.expression_return expression110 = null;

        WaebricLoader.markup_return markup113 = null;

        WaebricLoader.statement_return statement114 = null;

        WaebricLoader.markup_return markup116 = null;

        WaebricLoader.embedding_return embedding117 = null;

        WaebricLoader.markup_return markup119 = null;


        CommonTree string_literal73_tree=null;
        CommonTree char_literal74_tree=null;
        CommonTree char_literal76_tree=null;
        CommonTree string_literal78_tree=null;
        CommonTree string_literal80_tree=null;
        CommonTree char_literal81_tree=null;
        CommonTree IDCON82_tree=null;
        CommonTree char_literal83_tree=null;
        CommonTree char_literal85_tree=null;
        CommonTree string_literal87_tree=null;
        CommonTree string_literal89_tree=null;
        CommonTree string_literal91_tree=null;
        CommonTree char_literal92_tree=null;
        CommonTree char_literal94_tree=null;
        CommonTree string_literal95_tree=null;
        CommonTree STRCON96_tree=null;
        CommonTree char_literal97_tree=null;
        CommonTree string_literal98_tree=null;
        CommonTree char_literal100_tree=null;
        CommonTree string_literal101_tree=null;
        CommonTree char_literal103_tree=null;
        CommonTree string_literal104_tree=null;
        CommonTree char_literal106_tree=null;
        CommonTree string_literal107_tree=null;
        CommonTree MARKUP_STATEMENT108_tree=null;
        CommonTree char_literal111_tree=null;
        CommonTree MARKUP_STATEMENT112_tree=null;
        CommonTree MARKUP_STATEMENT115_tree=null;
        CommonTree MARKUP_STATEMENT118_tree=null;
        CommonTree char_literal120_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:72:10: ( ^( 'if' '(' predicate ')' statement ( 'else' statement )? ) | ^( 'each' '(' IDCON ':' expression ')' statement ) | ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ^( MARKUP_STATEMENT ( markup )+ statement ) | ^( MARKUP_STATEMENT ( markup )+ embedding ) | ^( MARKUP_STATEMENT ( markup )+ ';' ) )
            int alt29=13;
            alt29 = dfa29.predict(input);
            switch (alt29) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:72:13: ^( 'if' '(' predicate ')' statement ( 'else' statement )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal73=(CommonTree)match(input,51,FOLLOW_51_in_statement446); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal73_tree = (CommonTree)adaptor.dupNode(string_literal73);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal73_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    char_literal74=(CommonTree)match(input,42,FOLLOW_42_in_statement448); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal74_tree = (CommonTree)adaptor.dupNode(char_literal74);

                    adaptor.addChild(root_1, char_literal74_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_statement450);
                    predicate75=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, predicate75.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal76=(CommonTree)match(input,44,FOLLOW_44_in_statement452); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal76_tree = (CommonTree)adaptor.dupNode(char_literal76);

                    adaptor.addChild(root_1, char_literal76_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement454);
                    statement77=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement77.getTree());
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:72:49: ( 'else' statement )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==52) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:72:51: 'else' statement
                            {
                            _last = (CommonTree)input.LT(1);
                            string_literal78=(CommonTree)match(input,52,FOLLOW_52_in_statement458); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal78_tree = (CommonTree)adaptor.dupNode(string_literal78);

                            adaptor.addChild(root_1, string_literal78_tree);
                            }
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_statement_in_statement460);
                            statement79=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, statement79.getTree());

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:73:6: ^( 'each' '(' IDCON ':' expression ')' statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal80=(CommonTree)match(input,53,FOLLOW_53_in_statement474); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal80_tree = (CommonTree)adaptor.dupNode(string_literal80);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal80_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    char_literal81=(CommonTree)match(input,42,FOLLOW_42_in_statement476); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal81_tree = (CommonTree)adaptor.dupNode(char_literal81);

                    adaptor.addChild(root_1, char_literal81_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON82=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_statement478); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON82_tree = (CommonTree)adaptor.dupNode(IDCON82);

                    adaptor.addChild(root_1, IDCON82_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal83=(CommonTree)match(input,37,FOLLOW_37_in_statement480); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal83_tree = (CommonTree)adaptor.dupNode(char_literal83);

                    adaptor.addChild(root_1, char_literal83_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement482);
                    expression84=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression84.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal85=(CommonTree)match(input,44,FOLLOW_44_in_statement484); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal85_tree = (CommonTree)adaptor.dupNode(char_literal85);

                    adaptor.addChild(root_1, char_literal85_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement486);
                    statement86=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement86.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:74:6: ^( 'let' ( assignment )+ 'in' ( statement )* 'end' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal87=(CommonTree)match(input,54,FOLLOW_54_in_statement497); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal87_tree = (CommonTree)adaptor.dupNode(string_literal87);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal87_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:74:15: ( assignment )+
                    int cnt22=0;
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==IDCON) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: assignment
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_assignment_in_statement499);
                    	    assignment88=assignment();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, assignment88.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt22 >= 1 ) break loop22;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(22, input);
                                throw eee;
                        }
                        cnt22++;
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    string_literal89=(CommonTree)match(input,55,FOLLOW_55_in_statement502); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal89_tree = (CommonTree)adaptor.dupNode(string_literal89);

                    adaptor.addChild(root_1, string_literal89_tree);
                    }
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:74:32: ( statement )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==MARKUP_STATEMENT||LA23_0==COMMENT||LA23_0==47||LA23_0==51||(LA23_0>=53 && LA23_0<=54)||(LA23_0>=56 && LA23_0<=58)) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: statement
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_statement_in_statement504);
                    	    statement90=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, statement90.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    string_literal91=(CommonTree)match(input,END,FOLLOW_END_in_statement507); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal91_tree = (CommonTree)adaptor.dupNode(string_literal91);

                    adaptor.addChild(root_1, string_literal91_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:75:6: ^( '{' ( statement )* '}' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal92=(CommonTree)match(input,47,FOLLOW_47_in_statement518); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal92_tree = (CommonTree)adaptor.dupNode(char_literal92);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal92_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:75:13: ( statement )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==MARKUP_STATEMENT||LA24_0==COMMENT||LA24_0==47||LA24_0==51||(LA24_0>=53 && LA24_0<=54)||(LA24_0>=56 && LA24_0<=58)) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: statement
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_statement_in_statement520);
                    	    statement93=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, statement93.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal94=(CommonTree)match(input,48,FOLLOW_48_in_statement523); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal94_tree = (CommonTree)adaptor.dupNode(char_literal94);

                    adaptor.addChild(root_1, char_literal94_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:76:6: ^( 'comment' STRCON ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal95=(CommonTree)match(input,COMMENT,FOLLOW_COMMENT_in_statement534); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal95_tree = (CommonTree)adaptor.dupNode(string_literal95);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal95_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    STRCON96=(CommonTree)match(input,STRCON,FOLLOW_STRCON_in_statement536); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRCON96_tree = (CommonTree)adaptor.dupNode(STRCON96);

                    adaptor.addChild(root_1, STRCON96_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal97=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement538); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal97_tree = (CommonTree)adaptor.dupNode(char_literal97);

                    adaptor.addChild(root_1, char_literal97_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:77:6: ^( 'echo' expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal98=(CommonTree)match(input,56,FOLLOW_56_in_statement549); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal98_tree = (CommonTree)adaptor.dupNode(string_literal98);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal98_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement551);
                    expression99=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression99.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal100=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement553); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal100_tree = (CommonTree)adaptor.dupNode(char_literal100);

                    adaptor.addChild(root_1, char_literal100_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:78:6: ^( 'echo' embedding ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal101=(CommonTree)match(input,56,FOLLOW_56_in_statement564); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal101_tree = (CommonTree)adaptor.dupNode(string_literal101);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal101_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement566);
                    embedding102=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding102.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal103=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement568); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal103_tree = (CommonTree)adaptor.dupNode(char_literal103);

                    adaptor.addChild(root_1, char_literal103_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:79:6: ^( 'cdata' expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal104=(CommonTree)match(input,57,FOLLOW_57_in_statement579); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal104_tree = (CommonTree)adaptor.dupNode(string_literal104);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal104_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement581);
                    expression105=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression105.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal106=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement583); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal106_tree = (CommonTree)adaptor.dupNode(char_literal106);

                    adaptor.addChild(root_1, char_literal106_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:80:6: 'yield;'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal107=(CommonTree)match(input,58,FOLLOW_58_in_statement592); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal107_tree = (CommonTree)adaptor.dupNode(string_literal107);

                    adaptor.addChild(root_0, string_literal107_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:81:6: ^( MARKUP_STATEMENT ( markup )+ expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT108=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement601); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT108_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT108);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT108_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:81:26: ( markup )+
                    int cnt25=0;
                    loop25:
                    do {
                        int alt25=2;
                        alt25 = dfa25.predict(input);
                        switch (alt25) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement603);
                    	    markup109=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup109.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt25 >= 1 ) break loop25;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(25, input);
                                throw eee;
                        }
                        cnt25++;
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement606);
                    expression110=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression110.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal111=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement608); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal111_tree = (CommonTree)adaptor.dupNode(char_literal111);

                    adaptor.addChild(root_1, char_literal111_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:82:6: ^( MARKUP_STATEMENT ( markup )+ statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT112=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement619); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT112_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT112);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT112_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:82:26: ( markup )+
                    int cnt26=0;
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==IDCON) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement621);
                    	    markup113=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup113.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt26 >= 1 ) break loop26;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(26, input);
                                throw eee;
                        }
                        cnt26++;
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement624);
                    statement114=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement114.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:83:6: ^( MARKUP_STATEMENT ( markup )+ embedding )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT115=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement635); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT115_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT115);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT115_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:83:26: ( markup )+
                    int cnt27=0;
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==IDCON) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement637);
                    	    markup116=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup116.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt27 >= 1 ) break loop27;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(27, input);
                                throw eee;
                        }
                        cnt27++;
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement640);
                    embedding117=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding117.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:84:6: ^( MARKUP_STATEMENT ( markup )+ ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT118=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement651); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT118_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT118);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT118_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:84:26: ( markup )+
                    int cnt28=0;
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==IDCON) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement653);
                    	    markup119=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup119.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt28 >= 1 ) break loop28;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(28, input);
                                throw eee;
                        }
                        cnt28++;
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal120=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement656); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal120_tree = (CommonTree)adaptor.dupNode(char_literal120);

                    adaptor.addChild(root_1, char_literal120_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "statement"

    public static class assignment_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignment"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:89:1: assignment : ( IDCON '=' expression ';' | IDCON formals statement );
    public final WaebricLoader.assignment_return assignment() throws RecognitionException {
        WaebricLoader.assignment_return retval = new WaebricLoader.assignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON121=null;
        CommonTree char_literal122=null;
        CommonTree char_literal124=null;
        CommonTree IDCON125=null;
        WaebricLoader.expression_return expression123 = null;

        WaebricLoader.formals_return formals126 = null;

        WaebricLoader.statement_return statement127 = null;


        CommonTree IDCON121_tree=null;
        CommonTree char_literal122_tree=null;
        CommonTree char_literal124_tree=null;
        CommonTree IDCON125_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:89:11: ( IDCON '=' expression ';' | IDCON formals statement )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==IDCON) ) {
                int LA30_1 = input.LA(2);

                if ( (LA30_1==59) ) {
                    alt30=1;
                }
                else if ( (LA30_1==MARKUP_STATEMENT||LA30_1==COMMENT||LA30_1==42||LA30_1==47||LA30_1==51||(LA30_1>=53 && LA30_1<=54)||(LA30_1>=56 && LA30_1<=58)) ) {
                    alt30=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 30, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:89:14: IDCON '=' expression ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDCON121=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_assignment670); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON121_tree = (CommonTree)adaptor.dupNode(IDCON121);

                    adaptor.addChild(root_0, IDCON121_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal122=(CommonTree)match(input,59,FOLLOW_59_in_assignment672); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal122_tree = (CommonTree)adaptor.dupNode(char_literal122);

                    adaptor.addChild(root_0, char_literal122_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_assignment674);
                    expression123=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression123.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal124=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_assignment676); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal124_tree = (CommonTree)adaptor.dupNode(char_literal124);

                    adaptor.addChild(root_0, char_literal124_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:90:6: IDCON formals statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDCON125=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_assignment684); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON125_tree = (CommonTree)adaptor.dupNode(IDCON125);

                    adaptor.addChild(root_0, IDCON125_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_formals_in_assignment686);
                    formals126=formals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, formals126.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_assignment688);
                    statement127=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, statement127.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assignment"

    public static class predicate_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "predicate"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:95:1: predicate : ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )* ;
    public final WaebricLoader.predicate_return predicate() throws RecognitionException {
        WaebricLoader.predicate_return retval = new WaebricLoader.predicate_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal128=null;
        CommonTree char_literal132=null;
        CommonTree string_literal134=null;
        CommonTree string_literal136=null;
        WaebricLoader.predicate_return predicate129 = null;

        WaebricLoader.expression_return expression130 = null;

        WaebricLoader.expression_return expression131 = null;

        WaebricLoader.type_return type133 = null;

        WaebricLoader.predicate_return predicate135 = null;

        WaebricLoader.predicate_return predicate137 = null;


        CommonTree char_literal128_tree=null;
        CommonTree char_literal132_tree=null;
        CommonTree string_literal134_tree=null;
        CommonTree string_literal136_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:95:10: ( ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:95:13: ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:95:13: ( '!' predicate | expression | expression '.' type )
            int alt31=3;
            alt31 = dfa31.predict(input);
            switch (alt31) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:95:15: '!' predicate
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal128=(CommonTree)match(input,60,FOLLOW_60_in_predicate703); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal128_tree = (CommonTree)adaptor.dupNode(char_literal128);

                    adaptor.addChild(root_0, char_literal128_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_predicate705);
                    predicate129=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, predicate129.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:96:7: expression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate714);
                    expression130=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression130.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:97:7: expression '.' type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate723);
                    expression131=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression131.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal132=(CommonTree)match(input,35,FOLLOW_35_in_predicate725); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal132_tree = (CommonTree)adaptor.dupNode(char_literal132);

                    adaptor.addChild(root_0, char_literal132_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_predicate727);
                    type133=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, type133.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:98:6: ( '&&' predicate | '||' predicate )*
            loop32:
            do {
                int alt32=3;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==61) ) {
                    int LA32_2 = input.LA(2);

                    if ( (synpred53_WaebricLoader()) ) {
                        alt32=1;
                    }


                }
                else if ( (LA32_0==62) ) {
                    int LA32_3 = input.LA(2);

                    if ( (synpred54_WaebricLoader()) ) {
                        alt32=2;
                    }


                }


                switch (alt32) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:98:8: '&&' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal134=(CommonTree)match(input,61,FOLLOW_61_in_predicate737); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal134_tree = (CommonTree)adaptor.dupNode(string_literal134);

            	    adaptor.addChild(root_0, string_literal134_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate739);
            	    predicate135=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, predicate135.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:98:25: '||' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal136=(CommonTree)match(input,62,FOLLOW_62_in_predicate743); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal136_tree = (CommonTree)adaptor.dupNode(string_literal136);

            	    adaptor.addChild(root_0, string_literal136_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate745);
            	    predicate137=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, predicate137.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "predicate"

    public static class type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:99:1: type : ( 'list' | 'record' | 'string' );
    public final WaebricLoader.type_return type() throws RecognitionException {
        WaebricLoader.type_return retval = new WaebricLoader.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set138=null;

        CommonTree set138_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:99:5: ( 'list' | 'record' | 'string' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            set138=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=63 && input.LA(1)<=65) ) {
                input.consume();

                if ( state.backtracking==0 ) {
                set138_tree = (CommonTree)adaptor.dupNode(set138);

                adaptor.addChild(root_0, set138_tree);
                }
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "type"

    public static class embedding_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "embedding"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:104:1: embedding : PRETEXT embed textTail ;
    public final WaebricLoader.embedding_return embedding() throws RecognitionException {
        WaebricLoader.embedding_return retval = new WaebricLoader.embedding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PRETEXT139=null;
        WaebricLoader.embed_return embed140 = null;

        WaebricLoader.textTail_return textTail141 = null;


        CommonTree PRETEXT139_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:104:10: ( PRETEXT embed textTail )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:104:13: PRETEXT embed textTail
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PRETEXT139=(CommonTree)match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding777); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRETEXT139_tree = (CommonTree)adaptor.dupNode(PRETEXT139);

            adaptor.addChild(root_0, PRETEXT139_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_embed_in_embedding779);
            embed140=embed();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, embed140.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_textTail_in_embedding781);
            textTail141=textTail();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, textTail141.getTree());

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "embedding"

    public static class embed_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "embed"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:105:1: embed : ( ( markup )* expression | ( markup )* markup );
    public final WaebricLoader.embed_return embed() throws RecognitionException {
        WaebricLoader.embed_return retval = new WaebricLoader.embed_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricLoader.markup_return markup142 = null;

        WaebricLoader.expression_return expression143 = null;

        WaebricLoader.markup_return markup144 = null;

        WaebricLoader.markup_return markup145 = null;



        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:105:6: ( ( markup )* expression | ( markup )* markup )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==IDCON) ) {
                int LA35_1 = input.LA(2);

                if ( (synpred58_WaebricLoader()) ) {
                    alt35=1;
                }
                else if ( (true) ) {
                    alt35=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA35_0>=NATCON && LA35_0<=SYMBOLCON)||LA35_0==45||LA35_0==47) ) {
                alt35=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:105:10: ( markup )* expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:105:10: ( markup )*
                    loop33:
                    do {
                        int alt33=2;
                        alt33 = dfa33.predict(input);
                        switch (alt33) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed790);
                    	    markup142=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup142.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_embed793);
                    expression143=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression143.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:105:31: ( markup )* markup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:105:31: ( markup )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==IDCON) ) {
                            int LA34_1 = input.LA(2);

                            if ( (synpred59_WaebricLoader()) ) {
                                alt34=1;
                            }


                        }


                        switch (alt34) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed797);
                    	    markup144=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup144.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_embed800);
                    markup145=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, markup145.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "embed"

    public static class textTail_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "textTail"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:106:1: textTail : ( POSTTEXT | MIDTEXT embed textTail );
    public final WaebricLoader.textTail_return textTail() throws RecognitionException {
        WaebricLoader.textTail_return retval = new WaebricLoader.textTail_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POSTTEXT146=null;
        CommonTree MIDTEXT147=null;
        WaebricLoader.embed_return embed148 = null;

        WaebricLoader.textTail_return textTail149 = null;


        CommonTree POSTTEXT146_tree=null;
        CommonTree MIDTEXT147_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:106:9: ( POSTTEXT | MIDTEXT embed textTail )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==POSTTEXT) ) {
                alt36=1;
            }
            else if ( (LA36_0==MIDTEXT) ) {
                alt36=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:106:12: POSTTEXT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    POSTTEXT146=(CommonTree)match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail808); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    POSTTEXT146_tree = (CommonTree)adaptor.dupNode(POSTTEXT146);

                    adaptor.addChild(root_0, POSTTEXT146_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:106:23: MIDTEXT embed textTail
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    MIDTEXT147=(CommonTree)match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail812); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MIDTEXT147_tree = (CommonTree)adaptor.dupNode(MIDTEXT147);

                    adaptor.addChild(root_0, MIDTEXT147_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embed_in_textTail814);
                    embed148=embed();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, embed148.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_textTail_in_textTail816);
                    textTail149=textTail();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, textTail149.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "textTail"

    // $ANTLR start synpred25_WaebricLoader
    public final void synpred25_WaebricLoader_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:55:8: ( '+' expression )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:55:8: '+' expression
        {
        match(input,49,FOLLOW_49_in_synpred25_WaebricLoader357); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred25_WaebricLoader359);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_WaebricLoader

    // $ANTLR start synpred26_WaebricLoader
    public final void synpred26_WaebricLoader_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:55:35: ( '.' IDCON )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:55:35: '.' IDCON
        {
        match(input,35,FOLLOW_35_in_synpred26_WaebricLoader365); if (state.failed) return ;
        match(input,IDCON,FOLLOW_IDCON_in_synpred26_WaebricLoader367); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_WaebricLoader

    // $ANTLR start synpred39_WaebricLoader
    public final void synpred39_WaebricLoader_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:77:6: ( ^( 'echo' expression ';' ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:77:6: ^( 'echo' expression ';' )
        {
        match(input,56,FOLLOW_56_in_synpred39_WaebricLoader549); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred39_WaebricLoader551);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred39_WaebricLoader553); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_WaebricLoader

    // $ANTLR start synpred40_WaebricLoader
    public final void synpred40_WaebricLoader_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:78:6: ( ^( 'echo' embedding ';' ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:78:6: ^( 'echo' embedding ';' )
        {
        match(input,56,FOLLOW_56_in_synpred40_WaebricLoader564); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_embedding_in_synpred40_WaebricLoader566);
        embedding();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred40_WaebricLoader568); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred40_WaebricLoader

    // $ANTLR start synpred44_WaebricLoader
    public final void synpred44_WaebricLoader_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:81:6: ( ^( MARKUP_STATEMENT ( markup )+ expression ';' ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:81:6: ^( MARKUP_STATEMENT ( markup )+ expression ';' )
        {
        match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_synpred44_WaebricLoader601); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:81:26: ( markup )+
        int cnt44=0;
        loop44:
        do {
            int alt44=2;
            alt44 = dfa44.predict(input);
            switch (alt44) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred44_WaebricLoader603);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt44 >= 1 ) break loop44;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(44, input);
                    throw eee;
            }
            cnt44++;
        } while (true);

        pushFollow(FOLLOW_expression_in_synpred44_WaebricLoader606);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred44_WaebricLoader608); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred44_WaebricLoader

    // $ANTLR start synpred46_WaebricLoader
    public final void synpred46_WaebricLoader_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:82:6: ( ^( MARKUP_STATEMENT ( markup )+ statement ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:82:6: ^( MARKUP_STATEMENT ( markup )+ statement )
        {
        match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_synpred46_WaebricLoader619); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:82:26: ( markup )+
        int cnt45=0;
        loop45:
        do {
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==IDCON) ) {
                alt45=1;
            }


            switch (alt45) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred46_WaebricLoader621);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt45 >= 1 ) break loop45;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(45, input);
                    throw eee;
            }
            cnt45++;
        } while (true);

        pushFollow(FOLLOW_statement_in_synpred46_WaebricLoader624);
        statement();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_WaebricLoader

    // $ANTLR start synpred48_WaebricLoader
    public final void synpred48_WaebricLoader_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:83:6: ( ^( MARKUP_STATEMENT ( markup )+ embedding ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:83:6: ^( MARKUP_STATEMENT ( markup )+ embedding )
        {
        match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_synpred48_WaebricLoader635); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:83:26: ( markup )+
        int cnt46=0;
        loop46:
        do {
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==IDCON) ) {
                alt46=1;
            }


            switch (alt46) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred48_WaebricLoader637);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt46 >= 1 ) break loop46;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(46, input);
                    throw eee;
            }
            cnt46++;
        } while (true);

        pushFollow(FOLLOW_embedding_in_synpred48_WaebricLoader640);
        embedding();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred48_WaebricLoader

    // $ANTLR start synpred52_WaebricLoader
    public final void synpred52_WaebricLoader_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:96:7: ( expression )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:96:7: expression
        {
        pushFollow(FOLLOW_expression_in_synpred52_WaebricLoader714);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred52_WaebricLoader

    // $ANTLR start synpred53_WaebricLoader
    public final void synpred53_WaebricLoader_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:98:8: ( '&&' predicate )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:98:8: '&&' predicate
        {
        match(input,61,FOLLOW_61_in_synpred53_WaebricLoader737); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred53_WaebricLoader739);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred53_WaebricLoader

    // $ANTLR start synpred54_WaebricLoader
    public final void synpred54_WaebricLoader_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:98:25: ( '||' predicate )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:98:25: '||' predicate
        {
        match(input,62,FOLLOW_62_in_synpred54_WaebricLoader743); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred54_WaebricLoader745);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred54_WaebricLoader

    // $ANTLR start synpred58_WaebricLoader
    public final void synpred58_WaebricLoader_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:105:10: ( ( markup )* expression )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:105:10: ( markup )* expression
        {
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:105:10: ( markup )*
        loop47:
        do {
            int alt47=2;
            alt47 = dfa47.predict(input);
            switch (alt47) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred58_WaebricLoader790);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop47;
            }
        } while (true);

        pushFollow(FOLLOW_expression_in_synpred58_WaebricLoader793);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred58_WaebricLoader

    // $ANTLR start synpred59_WaebricLoader
    public final void synpred59_WaebricLoader_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:105:31: ( markup )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:105:31: markup
        {
        pushFollow(FOLLOW_markup_in_synpred59_WaebricLoader797);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred59_WaebricLoader

    // Delegated rules

    public final boolean synpred48_WaebricLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred48_WaebricLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred46_WaebricLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_WaebricLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred44_WaebricLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_WaebricLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred39_WaebricLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_WaebricLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred58_WaebricLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred58_WaebricLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_WaebricLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_WaebricLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred53_WaebricLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred53_WaebricLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred59_WaebricLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred59_WaebricLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred54_WaebricLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_WaebricLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred40_WaebricLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred40_WaebricLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_WaebricLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_WaebricLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred52_WaebricLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred52_WaebricLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA29 dfa29 = new DFA29(this);
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA31 dfa31 = new DFA31(this);
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA44 dfa44 = new DFA44(this);
    protected DFA47 dfa47 = new DFA47(this);
    static final String DFA29_eotS =
        "\20\uffff";
    static final String DFA29_eofS =
        "\20\uffff";
    static final String DFA29_minS =
        "\1\4\5\uffff\1\0\2\uffff\1\0\6\uffff";
    static final String DFA29_maxS =
        "\1\72\5\uffff\1\0\2\uffff\1\0\6\uffff";
    static final String DFA29_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\11\1\uffff\1\6\1\7\1"+
        "\12\1\13\1\14\1\15";
    static final String DFA29_specialS =
        "\6\uffff\1\0\2\uffff\1\1\6\uffff}>";
    static final String[] DFA29_transitionS = {
            "\1\11\11\uffff\1\5\40\uffff\1\4\3\uffff\1\1\1\uffff\1\2\1\3"+
            "\1\uffff\1\6\1\7\1\10",
            "",
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
            ""
    };

    static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
    static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
    static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
    static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
    static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
    static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
    static final short[][] DFA29_transition;

    static {
        int numStates = DFA29_transitionS.length;
        DFA29_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
        }
    }

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = DFA29_eot;
            this.eof = DFA29_eof;
            this.min = DFA29_min;
            this.max = DFA29_max;
            this.accept = DFA29_accept;
            this.special = DFA29_special;
            this.transition = DFA29_transition;
        }
        public String getDescription() {
            return "72:1: statement : ( ^( 'if' '(' predicate ')' statement ( 'else' statement )? ) | ^( 'each' '(' IDCON ':' expression ')' statement ) | ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ^( MARKUP_STATEMENT ( markup )+ statement ) | ^( MARKUP_STATEMENT ( markup )+ embedding ) | ^( MARKUP_STATEMENT ( markup )+ ';' ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TreeNodeStream input = (TreeNodeStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA29_6 = input.LA(1);

                         
                        int index29_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_WaebricLoader()) ) {s = 10;}

                        else if ( (synpred40_WaebricLoader()) ) {s = 11;}

                         
                        input.seek(index29_6);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA29_9 = input.LA(1);

                         
                        int index29_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred44_WaebricLoader()) ) {s = 12;}

                        else if ( (synpred46_WaebricLoader()) ) {s = 13;}

                        else if ( (synpred48_WaebricLoader()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index29_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 29, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA25_eotS =
        "\6\uffff";
    static final String DFA25_eofS =
        "\6\uffff";
    static final String DFA25_minS =
        "\2\5\2\uffff\2\5";
    static final String DFA25_maxS =
        "\1\57\1\61\2\uffff\1\5\1\61";
    static final String DFA25_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA25_specialS =
        "\6\uffff}>";
    static final String[] DFA25_transitionS = {
            "\1\1\1\uffff\3\2\43\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\7\uffff\1\2\21\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\7\uffff\1\2\21\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\2"
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
            return "()+ loopback of 81:26: ( markup )+";
        }
    }
    static final String DFA31_eotS =
        "\12\uffff";
    static final String DFA31_eofS =
        "\12\uffff";
    static final String DFA31_minS =
        "\1\5\1\uffff\6\0\2\uffff";
    static final String DFA31_maxS =
        "\1\74\1\uffff\6\0\2\uffff";
    static final String DFA31_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\1\3";
    static final String DFA31_specialS =
        "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\2\uffff}>";
    static final String[] DFA31_transitionS = {
            "\1\2\1\uffff\1\3\1\4\1\5\43\uffff\1\6\1\uffff\1\7\14\uffff\1"+
            "\1",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA31_eot = DFA.unpackEncodedString(DFA31_eotS);
    static final short[] DFA31_eof = DFA.unpackEncodedString(DFA31_eofS);
    static final char[] DFA31_min = DFA.unpackEncodedStringToUnsignedChars(DFA31_minS);
    static final char[] DFA31_max = DFA.unpackEncodedStringToUnsignedChars(DFA31_maxS);
    static final short[] DFA31_accept = DFA.unpackEncodedString(DFA31_acceptS);
    static final short[] DFA31_special = DFA.unpackEncodedString(DFA31_specialS);
    static final short[][] DFA31_transition;

    static {
        int numStates = DFA31_transitionS.length;
        DFA31_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA31_transition[i] = DFA.unpackEncodedString(DFA31_transitionS[i]);
        }
    }

    class DFA31 extends DFA {

        public DFA31(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 31;
            this.eot = DFA31_eot;
            this.eof = DFA31_eof;
            this.min = DFA31_min;
            this.max = DFA31_max;
            this.accept = DFA31_accept;
            this.special = DFA31_special;
            this.transition = DFA31_transition;
        }
        public String getDescription() {
            return "95:13: ( '!' predicate | expression | expression '.' type )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TreeNodeStream input = (TreeNodeStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA31_2 = input.LA(1);

                         
                        int index31_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_WaebricLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index31_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA31_3 = input.LA(1);

                         
                        int index31_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_WaebricLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index31_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA31_4 = input.LA(1);

                         
                        int index31_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_WaebricLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index31_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA31_5 = input.LA(1);

                         
                        int index31_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_WaebricLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index31_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA31_6 = input.LA(1);

                         
                        int index31_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_WaebricLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index31_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA31_7 = input.LA(1);

                         
                        int index31_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_WaebricLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index31_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 31, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA33_eotS =
        "\6\uffff";
    static final String DFA33_eofS =
        "\6\uffff";
    static final String DFA33_minS =
        "\2\5\1\uffff\1\5\1\uffff\1\5";
    static final String DFA33_maxS =
        "\1\57\1\61\1\uffff\1\5\1\uffff\1\61";
    static final String DFA33_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String DFA33_specialS =
        "\6\uffff}>";
    static final String[] DFA33_transitionS = {
            "\1\1\1\uffff\3\2\43\uffff\1\2\1\uffff\1\2",
            "\1\4\1\uffff\3\4\2\uffff\2\2\25\uffff\1\3\1\uffff\4\4\1\uffff"+
            "\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\2",
            "",
            "\1\5",
            "",
            "\1\4\1\uffff\3\4\2\uffff\2\2\25\uffff\1\3\1\uffff\4\4\1\uffff"+
            "\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\2"
    };

    static final short[] DFA33_eot = DFA.unpackEncodedString(DFA33_eotS);
    static final short[] DFA33_eof = DFA.unpackEncodedString(DFA33_eofS);
    static final char[] DFA33_min = DFA.unpackEncodedStringToUnsignedChars(DFA33_minS);
    static final char[] DFA33_max = DFA.unpackEncodedStringToUnsignedChars(DFA33_maxS);
    static final short[] DFA33_accept = DFA.unpackEncodedString(DFA33_acceptS);
    static final short[] DFA33_special = DFA.unpackEncodedString(DFA33_specialS);
    static final short[][] DFA33_transition;

    static {
        int numStates = DFA33_transitionS.length;
        DFA33_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA33_transition[i] = DFA.unpackEncodedString(DFA33_transitionS[i]);
        }
    }

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = DFA33_eot;
            this.eof = DFA33_eof;
            this.min = DFA33_min;
            this.max = DFA33_max;
            this.accept = DFA33_accept;
            this.special = DFA33_special;
            this.transition = DFA33_transition;
        }
        public String getDescription() {
            return "()* loopback of 105:10: ( markup )*";
        }
    }
    static final String DFA44_eotS =
        "\6\uffff";
    static final String DFA44_eofS =
        "\6\uffff";
    static final String DFA44_minS =
        "\2\5\1\uffff\1\5\1\uffff\1\5";
    static final String DFA44_maxS =
        "\1\57\1\61\1\uffff\1\5\1\uffff\1\61";
    static final String DFA44_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String DFA44_specialS =
        "\6\uffff}>";
    static final String[] DFA44_transitionS = {
            "\1\1\1\uffff\3\2\43\uffff\1\2\1\uffff\1\2",
            "\1\4\1\uffff\3\4\7\uffff\1\2\21\uffff\1\3\1\uffff\4\4\1\uffff"+
            "\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\2",
            "",
            "\1\5",
            "",
            "\1\4\1\uffff\3\4\7\uffff\1\2\21\uffff\1\3\1\uffff\4\4\1\uffff"+
            "\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\2"
    };

    static final short[] DFA44_eot = DFA.unpackEncodedString(DFA44_eotS);
    static final short[] DFA44_eof = DFA.unpackEncodedString(DFA44_eofS);
    static final char[] DFA44_min = DFA.unpackEncodedStringToUnsignedChars(DFA44_minS);
    static final char[] DFA44_max = DFA.unpackEncodedStringToUnsignedChars(DFA44_maxS);
    static final short[] DFA44_accept = DFA.unpackEncodedString(DFA44_acceptS);
    static final short[] DFA44_special = DFA.unpackEncodedString(DFA44_specialS);
    static final short[][] DFA44_transition;

    static {
        int numStates = DFA44_transitionS.length;
        DFA44_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA44_transition[i] = DFA.unpackEncodedString(DFA44_transitionS[i]);
        }
    }

    class DFA44 extends DFA {

        public DFA44(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 44;
            this.eot = DFA44_eot;
            this.eof = DFA44_eof;
            this.min = DFA44_min;
            this.max = DFA44_max;
            this.accept = DFA44_accept;
            this.special = DFA44_special;
            this.transition = DFA44_transition;
        }
        public String getDescription() {
            return "()+ loopback of 81:26: ( markup )+";
        }
    }
    static final String DFA47_eotS =
        "\6\uffff";
    static final String DFA47_eofS =
        "\1\uffff\1\2\3\uffff\1\2";
    static final String DFA47_minS =
        "\2\5\1\uffff\1\5\1\uffff\1\5";
    static final String DFA47_maxS =
        "\1\57\1\61\1\uffff\1\5\1\uffff\1\61";
    static final String DFA47_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String DFA47_specialS =
        "\6\uffff}>";
    static final String[] DFA47_transitionS = {
            "\1\1\1\uffff\3\2\43\uffff\1\2\1\uffff\1\2",
            "\1\4\1\uffff\3\4\31\uffff\1\3\1\uffff\4\4\1\uffff\1\4\2\uffff"+
            "\1\4\1\uffff\1\4\1\uffff\1\2",
            "",
            "\1\5",
            "",
            "\1\4\1\uffff\3\4\31\uffff\1\3\1\uffff\4\4\1\uffff\1\4\2\uffff"+
            "\1\4\1\uffff\1\4\1\uffff\1\2"
    };

    static final short[] DFA47_eot = DFA.unpackEncodedString(DFA47_eotS);
    static final short[] DFA47_eof = DFA.unpackEncodedString(DFA47_eofS);
    static final char[] DFA47_min = DFA.unpackEncodedStringToUnsignedChars(DFA47_minS);
    static final char[] DFA47_max = DFA.unpackEncodedStringToUnsignedChars(DFA47_maxS);
    static final short[] DFA47_accept = DFA.unpackEncodedString(DFA47_acceptS);
    static final short[] DFA47_special = DFA.unpackEncodedString(DFA47_specialS);
    static final short[][] DFA47_transition;

    static {
        int numStates = DFA47_transitionS.length;
        DFA47_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA47_transition[i] = DFA.unpackEncodedString(DFA47_transitionS[i]);
        }
    }

    class DFA47 extends DFA {

        public DFA47(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 47;
            this.eot = DFA47_eot;
            this.eof = DFA47_eof;
            this.min = DFA47_min;
            this.max = DFA47_max;
            this.accept = DFA47_accept;
            this.special = DFA47_special;
            this.transition = DFA47_transition;
        }
        public String getDescription() {
            return "()* loopback of 105:10: ( markup )*";
        }
    }
 

    public static final BitSet FOLLOW_34_in_module57 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_moduleId_in_module59 = new BitSet(new long[]{0x0004001000008008L});
    public static final BitSet FOLLOW_imprt_in_module61 = new BitSet(new long[]{0x0004001000008008L});
    public static final BitSet FOLLOW_site_in_module64 = new BitSet(new long[]{0x0004000000008008L});
    public static final BitSet FOLLOW_function_in_module67 = new BitSet(new long[]{0x0004000000000008L});
    public static final BitSet FOLLOW_IDCON_in_moduleId78 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_moduleId82 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_moduleId86 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_36_in_imprt98 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_moduleId_in_imprt100 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_imprt102 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_module_in_imprt106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SITE_in_site119 = new BitSet(new long[]{0x0000000000030040L});
    public static final BitSet FOLLOW_mappings_in_site121 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_END_in_site123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapping_in_mappings131 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_SEMICOLON_in_mappings136 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_mapping_in_mappings138 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_PATH_in_mapping150 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_mapping152 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_markup_in_mapping154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_designator_in_markup167 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_arguments_in_markup169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_designator178 = new BitSet(new long[]{0x000001E800000002L});
    public static final BitSet FOLLOW_attribute_in_designator180 = new BitSet(new long[]{0x000001E800000002L});
    public static final BitSet FOLLOW_38_in_attribute189 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_attribute191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_attribute199 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_attribute201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_attribute209 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_attribute211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_attribute219 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_attribute221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_attribute229 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NATCON_in_attribute231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_attribute239 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NATCON_in_attribute241 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_attribute243 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NATCON_in_attribute245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_arguments253 = new BitSet(new long[]{0x0000B800000003A0L});
    public static final BitSet FOLLOW_argument_in_arguments255 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_43_in_arguments260 = new BitSet(new long[]{0x0000A000000003A0L});
    public static final BitSet FOLLOW_argument_in_arguments262 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_44_in_arguments267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_argument275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_expression289 = new BitSet(new long[]{0x0002000800000002L});
    public static final BitSet FOLLOW_NATCON_in_expression293 = new BitSet(new long[]{0x0002000800000002L});
    public static final BitSet FOLLOW_TEXT_in_expression297 = new BitSet(new long[]{0x0002000800000002L});
    public static final BitSet FOLLOW_SYMBOLCON_in_expression301 = new BitSet(new long[]{0x0002000800000002L});
    public static final BitSet FOLLOW_45_in_expression310 = new BitSet(new long[]{0x0000E800000003A0L});
    public static final BitSet FOLLOW_expression_in_expression312 = new BitSet(new long[]{0x0000480000000000L});
    public static final BitSet FOLLOW_43_in_expression317 = new BitSet(new long[]{0x0000A000000003A0L});
    public static final BitSet FOLLOW_expression_in_expression319 = new BitSet(new long[]{0x0000480000000000L});
    public static final BitSet FOLLOW_46_in_expression324 = new BitSet(new long[]{0x0002000800000002L});
    public static final BitSet FOLLOW_47_in_expression333 = new BitSet(new long[]{0x0001080000000020L});
    public static final BitSet FOLLOW_keyValuePair_in_expression335 = new BitSet(new long[]{0x0001080000000000L});
    public static final BitSet FOLLOW_43_in_expression340 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_keyValuePair_in_expression342 = new BitSet(new long[]{0x0001080000000000L});
    public static final BitSet FOLLOW_48_in_expression347 = new BitSet(new long[]{0x0002000800000002L});
    public static final BitSet FOLLOW_49_in_expression357 = new BitSet(new long[]{0x0000A000000003A0L});
    public static final BitSet FOLLOW_expression_in_expression359 = new BitSet(new long[]{0x0002000800000002L});
    public static final BitSet FOLLOW_35_in_expression365 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_expression367 = new BitSet(new long[]{0x0002000800000002L});
    public static final BitSet FOLLOW_IDCON_in_keyValuePair380 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_keyValuePair382 = new BitSet(new long[]{0x0000A000000003A0L});
    public static final BitSet FOLLOW_expression_in_keyValuePair384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_function396 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_function400 = new BitSet(new long[]{0x0768840000014010L});
    public static final BitSet FOLLOW_formals_in_function402 = new BitSet(new long[]{0x0768800000014010L});
    public static final BitSet FOLLOW_statement_in_function404 = new BitSet(new long[]{0x0768800000014010L});
    public static final BitSet FOLLOW_END_in_function407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_formals423 = new BitSet(new long[]{0x0000100000000020L});
    public static final BitSet FOLLOW_IDCON_in_formals425 = new BitSet(new long[]{0x0000100000000020L});
    public static final BitSet FOLLOW_44_in_formals428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_statement446 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_42_in_statement448 = new BitSet(new long[]{0x1000A000000003A0L});
    public static final BitSet FOLLOW_predicate_in_statement450 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_statement452 = new BitSet(new long[]{0x0768800000004010L});
    public static final BitSet FOLLOW_statement_in_statement454 = new BitSet(new long[]{0x0010000000000008L});
    public static final BitSet FOLLOW_52_in_statement458 = new BitSet(new long[]{0x0768800000004010L});
    public static final BitSet FOLLOW_statement_in_statement460 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_53_in_statement474 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_42_in_statement476 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_statement478 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_statement480 = new BitSet(new long[]{0x0000A000000003A0L});
    public static final BitSet FOLLOW_expression_in_statement482 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_statement484 = new BitSet(new long[]{0x0768800000004010L});
    public static final BitSet FOLLOW_statement_in_statement486 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_54_in_statement497 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_assignment_in_statement499 = new BitSet(new long[]{0x0080000000000020L});
    public static final BitSet FOLLOW_55_in_statement502 = new BitSet(new long[]{0x0768800000014010L});
    public static final BitSet FOLLOW_statement_in_statement504 = new BitSet(new long[]{0x0768800000014010L});
    public static final BitSet FOLLOW_END_in_statement507 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_47_in_statement518 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statement520 = new BitSet(new long[]{0x0769800000004010L});
    public static final BitSet FOLLOW_48_in_statement523 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COMMENT_in_statement534 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRCON_in_statement536 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement538 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_56_in_statement549 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement551 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement553 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_56_in_statement564 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_statement566 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement568 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_57_in_statement579 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement581 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement583 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_58_in_statement592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement601 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement603 = new BitSet(new long[]{0x0000A000000003A0L});
    public static final BitSet FOLLOW_expression_in_statement606 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement608 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement619 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement621 = new BitSet(new long[]{0x0768800000004030L});
    public static final BitSet FOLLOW_statement_in_statement624 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement635 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement637 = new BitSet(new long[]{0x0000000000000820L});
    public static final BitSet FOLLOW_embedding_in_statement640 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement651 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement653 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement656 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDCON_in_assignment670 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_assignment672 = new BitSet(new long[]{0x0000A000000003A0L});
    public static final BitSet FOLLOW_expression_in_assignment674 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_assignment676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_assignment684 = new BitSet(new long[]{0x0768840000004010L});
    public static final BitSet FOLLOW_formals_in_assignment686 = new BitSet(new long[]{0x0768800000004010L});
    public static final BitSet FOLLOW_statement_in_assignment688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_predicate703 = new BitSet(new long[]{0x1000A000000003A0L});
    public static final BitSet FOLLOW_predicate_in_predicate705 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate714 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate723 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_predicate725 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_type_in_predicate727 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_61_in_predicate737 = new BitSet(new long[]{0x1000A000000003A0L});
    public static final BitSet FOLLOW_predicate_in_predicate739 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_62_in_predicate743 = new BitSet(new long[]{0x1000A000000003A0L});
    public static final BitSet FOLLOW_predicate_in_predicate745 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding777 = new BitSet(new long[]{0x0000A000000003A0L});
    public static final BitSet FOLLOW_embed_in_embedding779 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_textTail_in_embedding781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed790 = new BitSet(new long[]{0x0000A000000003A0L});
    public static final BitSet FOLLOW_expression_in_embed793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed797 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_markup_in_embed800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail812 = new BitSet(new long[]{0x0000A000000003A0L});
    public static final BitSet FOLLOW_embed_in_textTail814 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_textTail_in_textTail816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_synpred25_WaebricLoader357 = new BitSet(new long[]{0x0000A000000003A0L});
    public static final BitSet FOLLOW_expression_in_synpred25_WaebricLoader359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_synpred26_WaebricLoader365 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_synpred26_WaebricLoader367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred39_WaebricLoader549 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_synpred39_WaebricLoader551 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred39_WaebricLoader553 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_56_in_synpred40_WaebricLoader564 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_synpred40_WaebricLoader566 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred40_WaebricLoader568 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_synpred44_WaebricLoader601 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred44_WaebricLoader603 = new BitSet(new long[]{0x0000A000000003A0L});
    public static final BitSet FOLLOW_expression_in_synpred44_WaebricLoader606 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred44_WaebricLoader608 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_synpred46_WaebricLoader619 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred46_WaebricLoader621 = new BitSet(new long[]{0x0768800000004030L});
    public static final BitSet FOLLOW_statement_in_synpred46_WaebricLoader624 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_synpred48_WaebricLoader635 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred48_WaebricLoader637 = new BitSet(new long[]{0x0000000000000820L});
    public static final BitSet FOLLOW_embedding_in_synpred48_WaebricLoader640 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_synpred52_WaebricLoader714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred53_WaebricLoader737 = new BitSet(new long[]{0x1000A000000003A0L});
    public static final BitSet FOLLOW_predicate_in_synpred53_WaebricLoader739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_synpred54_WaebricLoader743 = new BitSet(new long[]{0x1000A000000003A0L});
    public static final BitSet FOLLOW_predicate_in_synpred54_WaebricLoader745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred58_WaebricLoader790 = new BitSet(new long[]{0x0000A000000003A0L});
    public static final BitSet FOLLOW_expression_in_synpred58_WaebricLoader793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred59_WaebricLoader797 = new BitSet(new long[]{0x0000000000000002L});

}