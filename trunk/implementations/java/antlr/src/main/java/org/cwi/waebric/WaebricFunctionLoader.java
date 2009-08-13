// $ANTLR 3.1.2 /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g 2009-08-13 10:09:16

	package org.cwi.waebric;
	import java.util.HashMap;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class WaebricFunctionLoader extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDCON", "PATH", "NATCON", "TEXT", "SYMBOLCON", "STRCON", "PRETEXT", "POSTTEXT", "MIDTEXT", "COMMENT", "SITE", "END", "SEMICOLON", "TEXTCHAR", "STRCHAR", "LETTER", "DIGIT", "HEXADECIMAL", "PATHELEMENT", "FILEEXT", "SYMBOLCHAR", "ESCLAYOUT", "DECIMAL", "ESCQUOTE", "AMP", "CHARREF", "ENTREF", "COMMENTS", "LAYOUT", "'module'", "'.'", "'import'", "':'", "'#'", "'$'", "'@'", "'%'", "'('", "','", "')'", "'['", "']'", "'{'", "'}'", "'+'", "'def'", "'if'", "'else'", "'each'", "'let'", "'in'", "'echo'", "'cdata'", "'yield'", "'='", "'!'", "'&&'", "'||'", "'list'", "'record'", "'string'"
    };
    public static final int T__64=64;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int LETTER=19;
    public static final int AMP=28;
    public static final int ESCLAYOUT=25;
    public static final int PATHELEMENT=22;
    public static final int PRETEXT=10;
    public static final int STRCON=9;
    public static final int TEXTCHAR=17;
    public static final int T__61=61;
    public static final int POSTTEXT=11;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int FILEEXT=23;
    public static final int T__52=52;
    public static final int COMMENTS=31;
    public static final int CHARREF=29;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int IDCON=4;
    public static final int PATH=5;
    public static final int T__59=59;
    public static final int STRCHAR=18;
    public static final int DIGIT=20;
    public static final int COMMENT=13;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int MIDTEXT=12;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int SYMBOLCON=8;
    public static final int SITE=14;
    public static final int HEXADECIMAL=21;
    public static final int SEMICOLON=16;
    public static final int SYMBOLCHAR=24;
    public static final int TEXT=7;
    public static final int LAYOUT=32;
    public static final int NATCON=6;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int DECIMAL=26;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int ENTREF=30;
    public static final int ESCQUOTE=27;
    public static final int END=15;

    // delegates
    // delegators


        public WaebricFunctionLoader(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public WaebricFunctionLoader(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return WaebricFunctionLoader.tokenNames; }
    public String getGrammarFileName() { return "/ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g"; }


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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:24:1: module : ^( 'module' moduleId ( imprt )* ( site )* ( function )* ) ;
    public final WaebricFunctionLoader.module_return module() throws RecognitionException {
        WaebricFunctionLoader.module_return retval = new WaebricFunctionLoader.module_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal1=null;
        WaebricFunctionLoader.moduleId_return moduleId2 = null;

        WaebricFunctionLoader.imprt_return imprt3 = null;

        WaebricFunctionLoader.site_return site4 = null;

        WaebricFunctionLoader.function_return function5 = null;


        CommonTree string_literal1_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:24:7: ( ^( 'module' moduleId ( imprt )* ( site )* ( function )* ) )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:24:11: ^( 'module' moduleId ( imprt )* ( site )* ( function )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal1=(CommonTree)match(input,33,FOLLOW_33_in_module57); if (state.failed) return retval;
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:24:32: ( imprt )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==35) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: imprt
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

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:24:39: ( site )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==SITE) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: site
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

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:24:45: ( function )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==49) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: function
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:26:1: moduleId : IDCON ( '.' e= IDCON )* ;
    public final WaebricFunctionLoader.moduleId_return moduleId() throws RecognitionException {
        WaebricFunctionLoader.moduleId_return retval = new WaebricFunctionLoader.moduleId_return();
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:26:9: ( IDCON ( '.' e= IDCON )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:26:12: IDCON ( '.' e= IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON6=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_moduleId79); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON6_tree = (CommonTree)adaptor.dupNode(IDCON6);

            adaptor.addChild(root_0, IDCON6_tree);
            }
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:26:18: ( '.' e= IDCON )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==34) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:26:20: '.' e= IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal7=(CommonTree)match(input,34,FOLLOW_34_in_moduleId83); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal7_tree = (CommonTree)adaptor.dupNode(char_literal7);

            	    adaptor.addChild(root_0, char_literal7_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    e=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_moduleId87); if (state.failed) return retval;
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:28:1: imprt : 'import' moduleId ';' module ;
    public final WaebricFunctionLoader.imprt_return imprt() throws RecognitionException {
        WaebricFunctionLoader.imprt_return retval = new WaebricFunctionLoader.imprt_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal8=null;
        CommonTree char_literal10=null;
        WaebricFunctionLoader.moduleId_return moduleId9 = null;

        WaebricFunctionLoader.module_return module11 = null;


        CommonTree string_literal8_tree=null;
        CommonTree char_literal10_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:28:6: ( 'import' moduleId ';' module )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:28:10: 'import' moduleId ';' module
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal8=(CommonTree)match(input,35,FOLLOW_35_in_imprt101); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal8_tree = (CommonTree)adaptor.dupNode(string_literal8);

            adaptor.addChild(root_0, string_literal8_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_moduleId_in_imprt103);
            moduleId9=moduleId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, moduleId9.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal10=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_imprt105); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal10_tree = (CommonTree)adaptor.dupNode(char_literal10);

            root_0 = (CommonTree)adaptor.becomeRoot(char_literal10_tree, root_0);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_module_in_imprt109);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:33:1: site : 'site' mappings 'end' ;
    public final WaebricFunctionLoader.site_return site() throws RecognitionException {
        WaebricFunctionLoader.site_return retval = new WaebricFunctionLoader.site_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal12=null;
        CommonTree string_literal14=null;
        WaebricFunctionLoader.mappings_return mappings13 = null;


        CommonTree string_literal12_tree=null;
        CommonTree string_literal14_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:33:5: ( 'site' mappings 'end' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:33:9: 'site' mappings 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal12=(CommonTree)match(input,SITE,FOLLOW_SITE_in_site122); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal12_tree = (CommonTree)adaptor.dupNode(string_literal12);

            adaptor.addChild(root_0, string_literal12_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_mappings_in_site124);
            mappings13=mappings();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, mappings13.getTree());
            _last = (CommonTree)input.LT(1);
            string_literal14=(CommonTree)match(input,END,FOLLOW_END_in_site126); if (state.failed) return retval;
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:35:1: mappings : ( mapping )? ( ';' mapping )* ;
    public final WaebricFunctionLoader.mappings_return mappings() throws RecognitionException {
        WaebricFunctionLoader.mappings_return retval = new WaebricFunctionLoader.mappings_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal16=null;
        WaebricFunctionLoader.mapping_return mapping15 = null;

        WaebricFunctionLoader.mapping_return mapping17 = null;


        CommonTree char_literal16_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:35:9: ( ( mapping )? ( ';' mapping )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:35:12: ( mapping )? ( ';' mapping )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:35:12: ( mapping )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==PATH) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: mapping
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_mapping_in_mappings135);
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

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:35:21: ( ';' mapping )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==SEMICOLON) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:35:23: ';' mapping
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal16=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_mappings140); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal16_tree = (CommonTree)adaptor.dupNode(char_literal16);

            	    adaptor.addChild(root_0, char_literal16_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_mapping_in_mappings142);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:37:1: mapping : PATH ':' markup ;
    public final WaebricFunctionLoader.mapping_return mapping() throws RecognitionException {
        WaebricFunctionLoader.mapping_return retval = new WaebricFunctionLoader.mapping_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PATH18=null;
        CommonTree char_literal19=null;
        WaebricFunctionLoader.markup_return markup20 = null;


        CommonTree PATH18_tree=null;
        CommonTree char_literal19_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:37:9: ( PATH ':' markup )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:37:12: PATH ':' markup
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PATH18=(CommonTree)match(input,PATH,FOLLOW_PATH_in_mapping155); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PATH18_tree = (CommonTree)adaptor.dupNode(PATH18);

            adaptor.addChild(root_0, PATH18_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal19=(CommonTree)match(input,36,FOLLOW_36_in_mapping157); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal19_tree = (CommonTree)adaptor.dupNode(char_literal19);

            adaptor.addChild(root_0, char_literal19_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_markup_in_mapping159);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:42:1: markup : designator ( arguments )? ;
    public final WaebricFunctionLoader.markup_return markup() throws RecognitionException {
        WaebricFunctionLoader.markup_return retval = new WaebricFunctionLoader.markup_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricFunctionLoader.designator_return designator21 = null;

        WaebricFunctionLoader.arguments_return arguments22 = null;



        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:42:7: ( designator ( arguments )? )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:42:11: designator ( arguments )?
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_designator_in_markup172);
            designator21=designator();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, designator21.getTree());
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:42:22: ( arguments )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==41) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: arguments
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_arguments_in_markup174);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:44:1: designator : IDCON ( attribute )* ;
    public final WaebricFunctionLoader.designator_return designator() throws RecognitionException {
        WaebricFunctionLoader.designator_return retval = new WaebricFunctionLoader.designator_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON23=null;
        WaebricFunctionLoader.attribute_return attribute24 = null;


        CommonTree IDCON23_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:44:11: ( IDCON ( attribute )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:44:14: IDCON ( attribute )*
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON23=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_designator184); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON23_tree = (CommonTree)adaptor.dupNode(IDCON23);

            adaptor.addChild(root_0, IDCON23_tree);
            }
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:44:20: ( attribute )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==34||(LA8_0>=36 && LA8_0<=39)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: attribute
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_attribute_in_designator186);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:46:1: attribute : ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON );
    public final WaebricFunctionLoader.attribute_return attribute() throws RecognitionException {
        WaebricFunctionLoader.attribute_return retval = new WaebricFunctionLoader.attribute_return();
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:46:10: ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON )
            int alt9=6;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt9=1;
                }
                break;
            case 34:
                {
                alt9=2;
                }
                break;
            case 38:
                {
                alt9=3;
                }
                break;
            case 36:
                {
                alt9=4;
                }
                break;
            case 39:
                {
                int LA9_5 = input.LA(2);

                if ( (LA9_5==NATCON) ) {
                    int LA9_6 = input.LA(3);

                    if ( (LA9_6==40) ) {
                        alt9=6;
                    }
                    else if ( (LA9_6==EOF||(LA9_6>=DOWN && LA9_6<=IDCON)||(LA9_6>=NATCON && LA9_6<=SYMBOLCON)||(LA9_6>=PRETEXT && LA9_6<=COMMENT)||(LA9_6>=END && LA9_6<=SEMICOLON)||LA9_6==34||(LA9_6>=36 && LA9_6<=39)||(LA9_6>=41 && LA9_6<=42)||LA9_6==44||(LA9_6>=46 && LA9_6<=47)||(LA9_6>=50 && LA9_6<=57)) ) {
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:46:13: '#' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal25=(CommonTree)match(input,37,FOLLOW_37_in_attribute196); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal25_tree = (CommonTree)adaptor.dupNode(char_literal25);

                    adaptor.addChild(root_0, char_literal25_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON26=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute198); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON26_tree = (CommonTree)adaptor.dupNode(IDCON26);

                    adaptor.addChild(root_0, IDCON26_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:47:6: '.' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal27=(CommonTree)match(input,34,FOLLOW_34_in_attribute206); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal27_tree = (CommonTree)adaptor.dupNode(char_literal27);

                    adaptor.addChild(root_0, char_literal27_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON28=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute208); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON28_tree = (CommonTree)adaptor.dupNode(IDCON28);

                    adaptor.addChild(root_0, IDCON28_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:48:6: '$' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal29=(CommonTree)match(input,38,FOLLOW_38_in_attribute216); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal29_tree = (CommonTree)adaptor.dupNode(char_literal29);

                    adaptor.addChild(root_0, char_literal29_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON30=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute218); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON30_tree = (CommonTree)adaptor.dupNode(IDCON30);

                    adaptor.addChild(root_0, IDCON30_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:49:6: ':' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal31=(CommonTree)match(input,36,FOLLOW_36_in_attribute226); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal31_tree = (CommonTree)adaptor.dupNode(char_literal31);

                    adaptor.addChild(root_0, char_literal31_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON32=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute228); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON32_tree = (CommonTree)adaptor.dupNode(IDCON32);

                    adaptor.addChild(root_0, IDCON32_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:50:6: '@' NATCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal33=(CommonTree)match(input,39,FOLLOW_39_in_attribute236); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal33_tree = (CommonTree)adaptor.dupNode(char_literal33);

                    adaptor.addChild(root_0, char_literal33_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    NATCON34=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_attribute238); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON34_tree = (CommonTree)adaptor.dupNode(NATCON34);

                    adaptor.addChild(root_0, NATCON34_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:51:6: '@' NATCON '%' NATCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal35=(CommonTree)match(input,39,FOLLOW_39_in_attribute246); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal35_tree = (CommonTree)adaptor.dupNode(char_literal35);

                    adaptor.addChild(root_0, char_literal35_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    NATCON36=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_attribute248); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON36_tree = (CommonTree)adaptor.dupNode(NATCON36);

                    adaptor.addChild(root_0, NATCON36_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal37=(CommonTree)match(input,40,FOLLOW_40_in_attribute250); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal37_tree = (CommonTree)adaptor.dupNode(char_literal37);

                    adaptor.addChild(root_0, char_literal37_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    NATCON38=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_attribute252); if (state.failed) return retval;
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:53:1: arguments : '(' ( argument )? ( ',' argument )* ')' ;
    public final WaebricFunctionLoader.arguments_return arguments() throws RecognitionException {
        WaebricFunctionLoader.arguments_return retval = new WaebricFunctionLoader.arguments_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal39=null;
        CommonTree char_literal41=null;
        CommonTree char_literal43=null;
        WaebricFunctionLoader.argument_return argument40 = null;

        WaebricFunctionLoader.argument_return argument42 = null;


        CommonTree char_literal39_tree=null;
        CommonTree char_literal41_tree=null;
        CommonTree char_literal43_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:53:10: ( '(' ( argument )? ( ',' argument )* ')' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:53:13: '(' ( argument )? ( ',' argument )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            char_literal39=(CommonTree)match(input,41,FOLLOW_41_in_arguments264); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal39_tree = (CommonTree)adaptor.dupNode(char_literal39);

            adaptor.addChild(root_0, char_literal39_tree);
            }
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:53:17: ( argument )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==IDCON||(LA10_0>=NATCON && LA10_0<=SYMBOLCON)||LA10_0==44||LA10_0==46) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: argument
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_argument_in_arguments266);
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

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:53:27: ( ',' argument )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==42) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:53:29: ',' argument
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal41=(CommonTree)match(input,42,FOLLOW_42_in_arguments271); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal41_tree = (CommonTree)adaptor.dupNode(char_literal41);

            	    adaptor.addChild(root_0, char_literal41_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_argument_in_arguments273);
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
            char_literal43=(CommonTree)match(input,43,FOLLOW_43_in_arguments278); if (state.failed) return retval;
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:55:1: argument : expression ;
    public final WaebricFunctionLoader.argument_return argument() throws RecognitionException {
        WaebricFunctionLoader.argument_return retval = new WaebricFunctionLoader.argument_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricFunctionLoader.expression_return expression44 = null;



        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:55:9: ( expression )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:55:12: expression
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_argument287);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:60:1: expression : ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* ;
    public final WaebricFunctionLoader.expression_return expression() throws RecognitionException {
        WaebricFunctionLoader.expression_return retval = new WaebricFunctionLoader.expression_return();
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
        WaebricFunctionLoader.expression_return expression50 = null;

        WaebricFunctionLoader.expression_return expression52 = null;

        WaebricFunctionLoader.keyValuePair_return keyValuePair55 = null;

        WaebricFunctionLoader.keyValuePair_return keyValuePair57 = null;

        WaebricFunctionLoader.expression_return expression60 = null;


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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:60:11: ( ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:60:14: ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:60:14: ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' )
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
            case 44:
                {
                alt16=5;
                }
                break;
            case 46:
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:60:16: IDCON
                    {
                    _last = (CommonTree)input.LT(1);
                    IDCON45=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression301); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON45_tree = (CommonTree)adaptor.dupNode(IDCON45);

                    adaptor.addChild(root_0, IDCON45_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:60:24: NATCON
                    {
                    _last = (CommonTree)input.LT(1);
                    NATCON46=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_expression305); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON46_tree = (CommonTree)adaptor.dupNode(NATCON46);

                    adaptor.addChild(root_0, NATCON46_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:60:33: TEXT
                    {
                    _last = (CommonTree)input.LT(1);
                    TEXT47=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_expression309); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TEXT47_tree = (CommonTree)adaptor.dupNode(TEXT47);

                    adaptor.addChild(root_0, TEXT47_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:60:40: SYMBOLCON
                    {
                    _last = (CommonTree)input.LT(1);
                    SYMBOLCON48=(CommonTree)match(input,SYMBOLCON,FOLLOW_SYMBOLCON_in_expression313); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SYMBOLCON48_tree = (CommonTree)adaptor.dupNode(SYMBOLCON48);

                    adaptor.addChild(root_0, SYMBOLCON48_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:61:7: '[' ( expression )? ( ',' expression )* ']'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal49=(CommonTree)match(input,44,FOLLOW_44_in_expression322); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal49_tree = (CommonTree)adaptor.dupNode(char_literal49);

                    adaptor.addChild(root_0, char_literal49_tree);
                    }
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:61:11: ( expression )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==IDCON||(LA12_0>=NATCON && LA12_0<=SYMBOLCON)||LA12_0==44||LA12_0==46) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: expression
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_expression_in_expression324);
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

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:61:23: ( ',' expression )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==42) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:61:25: ',' expression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal51=(CommonTree)match(input,42,FOLLOW_42_in_expression329); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal51_tree = (CommonTree)adaptor.dupNode(char_literal51);

                    	    adaptor.addChild(root_0, char_literal51_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_expression_in_expression331);
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
                    char_literal53=(CommonTree)match(input,45,FOLLOW_45_in_expression336); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal53_tree = (CommonTree)adaptor.dupNode(char_literal53);

                    adaptor.addChild(root_0, char_literal53_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:62:7: '{' ( keyValuePair )? ( ',' keyValuePair )* '}'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal54=(CommonTree)match(input,46,FOLLOW_46_in_expression345); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal54_tree = (CommonTree)adaptor.dupNode(char_literal54);

                    adaptor.addChild(root_0, char_literal54_tree);
                    }
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:62:11: ( keyValuePair )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==IDCON) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: keyValuePair
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_keyValuePair_in_expression347);
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

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:62:25: ( ',' keyValuePair )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==42) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:62:27: ',' keyValuePair
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal56=(CommonTree)match(input,42,FOLLOW_42_in_expression352); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal56_tree = (CommonTree)adaptor.dupNode(char_literal56);

                    	    adaptor.addChild(root_0, char_literal56_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_keyValuePair_in_expression354);
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
                    char_literal58=(CommonTree)match(input,47,FOLLOW_47_in_expression359); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal58_tree = (CommonTree)adaptor.dupNode(char_literal58);

                    adaptor.addChild(root_0, char_literal58_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:63:6: ( '+' expression | '.' IDCON )*
            loop17:
            do {
                int alt17=3;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==48) ) {
                    int LA17_2 = input.LA(2);

                    if ( (synpred25_WaebricFunctionLoader()) ) {
                        alt17=1;
                    }


                }
                else if ( (LA17_0==34) ) {
                    int LA17_3 = input.LA(2);

                    if ( (synpred26_WaebricFunctionLoader()) ) {
                        alt17=2;
                    }


                }


                switch (alt17) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:63:8: '+' expression
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal59=(CommonTree)match(input,48,FOLLOW_48_in_expression369); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal59_tree = (CommonTree)adaptor.dupNode(char_literal59);

            	    adaptor.addChild(root_0, char_literal59_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expression_in_expression371);
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
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:63:35: '.' IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal61=(CommonTree)match(input,34,FOLLOW_34_in_expression377); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal61_tree = (CommonTree)adaptor.dupNode(char_literal61);

            	    adaptor.addChild(root_0, char_literal61_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    IDCON62=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression379); if (state.failed) return retval;
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:65:1: keyValuePair : IDCON ':' expression ;
    public final WaebricFunctionLoader.keyValuePair_return keyValuePair() throws RecognitionException {
        WaebricFunctionLoader.keyValuePair_return retval = new WaebricFunctionLoader.keyValuePair_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON63=null;
        CommonTree char_literal64=null;
        WaebricFunctionLoader.expression_return expression65 = null;


        CommonTree IDCON63_tree=null;
        CommonTree char_literal64_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:65:13: ( IDCON ':' expression )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:65:16: IDCON ':' expression
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON63=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_keyValuePair396); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON63_tree = (CommonTree)adaptor.dupNode(IDCON63);

            adaptor.addChild(root_0, IDCON63_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal64=(CommonTree)match(input,36,FOLLOW_36_in_keyValuePair398); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal64_tree = (CommonTree)adaptor.dupNode(char_literal64);

            adaptor.addChild(root_0, char_literal64_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_keyValuePair400);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:70:1: function : 'def' id= IDCON ( formals )? ( statement )* 'end' ;
    public final WaebricFunctionLoader.function_return function() throws RecognitionException {
        WaebricFunctionLoader.function_return retval = new WaebricFunctionLoader.function_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        CommonTree string_literal66=null;
        CommonTree string_literal69=null;
        WaebricFunctionLoader.formals_return formals67 = null;

        WaebricFunctionLoader.statement_return statement68 = null;


        CommonTree id_tree=null;
        CommonTree string_literal66_tree=null;
        CommonTree string_literal69_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:70:9: ( 'def' id= IDCON ( formals )? ( statement )* 'end' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:70:12: 'def' id= IDCON ( formals )? ( statement )* 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal66=(CommonTree)match(input,49,FOLLOW_49_in_function412); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal66_tree = (CommonTree)adaptor.dupNode(string_literal66);

            adaptor.addChild(root_0, string_literal66_tree);
            }
            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_function416); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (CommonTree)adaptor.dupNode(id);

            adaptor.addChild(root_0, id_tree);
            }
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:70:27: ( formals )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==41) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: formals
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_formals_in_function418);
                    formals67=formals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, formals67.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:70:36: ( statement )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==IDCON||LA19_0==COMMENT||LA19_0==46||LA19_0==50||(LA19_0>=52 && LA19_0<=53)||(LA19_0>=55 && LA19_0<=57)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_function421);
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
            	    break loop19;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            string_literal69=(CommonTree)match(input,END,FOLLOW_END_in_function424); if (state.failed) return retval;
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:75:1: formals : '(' ( IDCON )* ')' ;
    public final WaebricFunctionLoader.formals_return formals() throws RecognitionException {
        WaebricFunctionLoader.formals_return retval = new WaebricFunctionLoader.formals_return();
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:75:8: ( '(' ( IDCON )* ')' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:75:11: '(' ( IDCON )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            char_literal70=(CommonTree)match(input,41,FOLLOW_41_in_formals438); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal70_tree = (CommonTree)adaptor.dupNode(char_literal70);

            adaptor.addChild(root_0, char_literal70_tree);
            }
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:75:15: ( IDCON )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==IDCON) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    IDCON71=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_formals440); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDCON71_tree = (CommonTree)adaptor.dupNode(IDCON71);

            	    adaptor.addChild(root_0, IDCON71_tree);
            	    }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            char_literal72=(CommonTree)match(input,43,FOLLOW_43_in_formals443); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal72_tree = (CommonTree)adaptor.dupNode(char_literal72);

            adaptor.addChild(root_0, char_literal72_tree);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:81:1: statement : ( ^( 'if' predicate statement 'else' statement ) | ^( 'if' predicate statement ) | ^( 'each' IDCON expression statement ) | ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ) | ^( 'echo' expression ) | ^( 'echo' embedding ) | ^( 'cdata' expression ) | 'yield' | markup | ^( markup ( markup )* ',' expression ';' ) | ^( markup ( markup )* ',' statement ) | ^( markup ( markup )* embedding ';' ) | ^( markup ( markup )* ';' ) );
    public final WaebricFunctionLoader.statement_return statement() throws RecognitionException {
        WaebricFunctionLoader.statement_return retval = new WaebricFunctionLoader.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal73=null;
        CommonTree string_literal76=null;
        CommonTree string_literal78=null;
        CommonTree string_literal81=null;
        CommonTree IDCON82=null;
        CommonTree string_literal85=null;
        CommonTree string_literal87=null;
        CommonTree string_literal89=null;
        CommonTree char_literal90=null;
        CommonTree char_literal92=null;
        CommonTree string_literal93=null;
        CommonTree STRCON94=null;
        CommonTree string_literal95=null;
        CommonTree string_literal97=null;
        CommonTree string_literal99=null;
        CommonTree string_literal101=null;
        CommonTree char_literal105=null;
        CommonTree char_literal107=null;
        CommonTree char_literal110=null;
        CommonTree char_literal115=null;
        CommonTree char_literal118=null;
        WaebricFunctionLoader.predicate_return predicate74 = null;

        WaebricFunctionLoader.statement_return statement75 = null;

        WaebricFunctionLoader.statement_return statement77 = null;

        WaebricFunctionLoader.predicate_return predicate79 = null;

        WaebricFunctionLoader.statement_return statement80 = null;

        WaebricFunctionLoader.expression_return expression83 = null;

        WaebricFunctionLoader.statement_return statement84 = null;

        WaebricFunctionLoader.assignment_return assignment86 = null;

        WaebricFunctionLoader.statement_return statement88 = null;

        WaebricFunctionLoader.statement_return statement91 = null;

        WaebricFunctionLoader.expression_return expression96 = null;

        WaebricFunctionLoader.embedding_return embedding98 = null;

        WaebricFunctionLoader.expression_return expression100 = null;

        WaebricFunctionLoader.markup_return markup102 = null;

        WaebricFunctionLoader.markup_return markup103 = null;

        WaebricFunctionLoader.markup_return markup104 = null;

        WaebricFunctionLoader.expression_return expression106 = null;

        WaebricFunctionLoader.markup_return markup108 = null;

        WaebricFunctionLoader.markup_return markup109 = null;

        WaebricFunctionLoader.statement_return statement111 = null;

        WaebricFunctionLoader.markup_return markup112 = null;

        WaebricFunctionLoader.markup_return markup113 = null;

        WaebricFunctionLoader.embedding_return embedding114 = null;

        WaebricFunctionLoader.markup_return markup116 = null;

        WaebricFunctionLoader.markup_return markup117 = null;


        CommonTree string_literal73_tree=null;
        CommonTree string_literal76_tree=null;
        CommonTree string_literal78_tree=null;
        CommonTree string_literal81_tree=null;
        CommonTree IDCON82_tree=null;
        CommonTree string_literal85_tree=null;
        CommonTree string_literal87_tree=null;
        CommonTree string_literal89_tree=null;
        CommonTree char_literal90_tree=null;
        CommonTree char_literal92_tree=null;
        CommonTree string_literal93_tree=null;
        CommonTree STRCON94_tree=null;
        CommonTree string_literal95_tree=null;
        CommonTree string_literal97_tree=null;
        CommonTree string_literal99_tree=null;
        CommonTree string_literal101_tree=null;
        CommonTree char_literal105_tree=null;
        CommonTree char_literal107_tree=null;
        CommonTree char_literal110_tree=null;
        CommonTree char_literal115_tree=null;
        CommonTree char_literal118_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:81:10: ( ^( 'if' predicate statement 'else' statement ) | ^( 'if' predicate statement ) | ^( 'each' IDCON expression statement ) | ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ) | ^( 'echo' expression ) | ^( 'echo' embedding ) | ^( 'cdata' expression ) | 'yield' | markup | ^( markup ( markup )* ',' expression ';' ) | ^( markup ( markup )* ',' statement ) | ^( markup ( markup )* embedding ';' ) | ^( markup ( markup )* ';' ) )
            int alt28=15;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:81:13: ^( 'if' predicate statement 'else' statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal73=(CommonTree)match(input,50,FOLLOW_50_in_statement458); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal73_tree = (CommonTree)adaptor.dupNode(string_literal73);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal73_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_statement460);
                    predicate74=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, predicate74.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement462);
                    statement75=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement75.getTree());
                    _last = (CommonTree)input.LT(1);
                    string_literal76=(CommonTree)match(input,51,FOLLOW_51_in_statement464); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal76_tree = (CommonTree)adaptor.dupNode(string_literal76);

                    adaptor.addChild(root_1, string_literal76_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement466);
                    statement77=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement77.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:82:6: ^( 'if' predicate statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal78=(CommonTree)match(input,50,FOLLOW_50_in_statement477); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal78_tree = (CommonTree)adaptor.dupNode(string_literal78);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal78_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_statement479);
                    predicate79=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, predicate79.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement481);
                    statement80=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement80.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:83:6: ^( 'each' IDCON expression statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal81=(CommonTree)match(input,52,FOLLOW_52_in_statement492); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal81_tree = (CommonTree)adaptor.dupNode(string_literal81);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal81_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDCON82=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_statement494); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON82_tree = (CommonTree)adaptor.dupNode(IDCON82);

                    adaptor.addChild(root_1, IDCON82_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement496);
                    expression83=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression83.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement498);
                    statement84=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement84.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:84:6: ^( 'let' ( assignment )+ 'in' ( statement )* 'end' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal85=(CommonTree)match(input,53,FOLLOW_53_in_statement509); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal85_tree = (CommonTree)adaptor.dupNode(string_literal85);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal85_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:84:15: ( assignment )+
                    int cnt21=0;
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==IDCON) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: assignment
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_assignment_in_statement511);
                    	    assignment86=assignment();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, assignment86.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt21 >= 1 ) break loop21;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(21, input);
                                throw eee;
                        }
                        cnt21++;
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    string_literal87=(CommonTree)match(input,54,FOLLOW_54_in_statement514); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal87_tree = (CommonTree)adaptor.dupNode(string_literal87);

                    adaptor.addChild(root_1, string_literal87_tree);
                    }
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:84:32: ( statement )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==IDCON||LA22_0==COMMENT||LA22_0==46||LA22_0==50||(LA22_0>=52 && LA22_0<=53)||(LA22_0>=55 && LA22_0<=57)) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: statement
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_statement_in_statement516);
                    	    statement88=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, statement88.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    string_literal89=(CommonTree)match(input,END,FOLLOW_END_in_statement519); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal89_tree = (CommonTree)adaptor.dupNode(string_literal89);

                    adaptor.addChild(root_1, string_literal89_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:85:6: ^( '{' ( statement )* '}' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal90=(CommonTree)match(input,46,FOLLOW_46_in_statement530); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal90_tree = (CommonTree)adaptor.dupNode(char_literal90);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal90_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:85:13: ( statement )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==IDCON||LA23_0==COMMENT||LA23_0==46||LA23_0==50||(LA23_0>=52 && LA23_0<=53)||(LA23_0>=55 && LA23_0<=57)) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: statement
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_statement_in_statement532);
                    	    statement91=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, statement91.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal92=(CommonTree)match(input,47,FOLLOW_47_in_statement535); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal92_tree = (CommonTree)adaptor.dupNode(char_literal92);

                    adaptor.addChild(root_1, char_literal92_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:86:6: ^( 'comment' STRCON )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal93=(CommonTree)match(input,COMMENT,FOLLOW_COMMENT_in_statement546); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal93_tree = (CommonTree)adaptor.dupNode(string_literal93);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal93_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    STRCON94=(CommonTree)match(input,STRCON,FOLLOW_STRCON_in_statement548); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRCON94_tree = (CommonTree)adaptor.dupNode(STRCON94);

                    adaptor.addChild(root_1, STRCON94_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:87:6: ^( 'echo' expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal95=(CommonTree)match(input,55,FOLLOW_55_in_statement559); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal95_tree = (CommonTree)adaptor.dupNode(string_literal95);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal95_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement561);
                    expression96=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression96.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:88:6: ^( 'echo' embedding )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal97=(CommonTree)match(input,55,FOLLOW_55_in_statement572); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal97_tree = (CommonTree)adaptor.dupNode(string_literal97);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal97_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement574);
                    embedding98=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding98.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:89:6: ^( 'cdata' expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal99=(CommonTree)match(input,56,FOLLOW_56_in_statement585); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal99_tree = (CommonTree)adaptor.dupNode(string_literal99);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal99_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement587);
                    expression100=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression100.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:90:6: 'yield'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal101=(CommonTree)match(input,57,FOLLOW_57_in_statement596); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal101_tree = (CommonTree)adaptor.dupNode(string_literal101);

                    adaptor.addChild(root_0, string_literal101_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:91:6: markup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_statement603);
                    markup102=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, markup102.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:92:6: ^( markup ( markup )* ',' expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_statement612);
                    markup103=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(markup103.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:92:16: ( markup )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==IDCON) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement614);
                    	    markup104=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup104.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal105=(CommonTree)match(input,42,FOLLOW_42_in_statement617); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal105_tree = (CommonTree)adaptor.dupNode(char_literal105);

                    adaptor.addChild(root_1, char_literal105_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement619);
                    expression106=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression106.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal107=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement621); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal107_tree = (CommonTree)adaptor.dupNode(char_literal107);

                    adaptor.addChild(root_1, char_literal107_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:93:6: ^( markup ( markup )* ',' statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_statement632);
                    markup108=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(markup108.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:93:16: ( markup )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==IDCON) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement634);
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
                    	    break loop25;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal110=(CommonTree)match(input,42,FOLLOW_42_in_statement637); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal110_tree = (CommonTree)adaptor.dupNode(char_literal110);

                    adaptor.addChild(root_1, char_literal110_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement639);
                    statement111=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement111.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:94:6: ^( markup ( markup )* embedding ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_statement650);
                    markup112=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(markup112.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:94:16: ( markup )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==IDCON) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement652);
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
                    	    break loop26;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement655);
                    embedding114=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding114.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal115=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement657); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal115_tree = (CommonTree)adaptor.dupNode(char_literal115);

                    adaptor.addChild(root_1, char_literal115_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:95:6: ^( markup ( markup )* ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_statement668);
                    markup116=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(markup116.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:95:16: ( markup )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==IDCON) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement670);
                    	    markup117=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup117.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal118=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement673); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal118_tree = (CommonTree)adaptor.dupNode(char_literal118);

                    adaptor.addChild(root_1, char_literal118_tree);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:100:1: assignment : ( IDCON '=' expression ';' | IDCON formals statement );
    public final WaebricFunctionLoader.assignment_return assignment() throws RecognitionException {
        WaebricFunctionLoader.assignment_return retval = new WaebricFunctionLoader.assignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON119=null;
        CommonTree char_literal120=null;
        CommonTree char_literal122=null;
        CommonTree IDCON123=null;
        WaebricFunctionLoader.expression_return expression121 = null;

        WaebricFunctionLoader.formals_return formals124 = null;

        WaebricFunctionLoader.statement_return statement125 = null;


        CommonTree IDCON119_tree=null;
        CommonTree char_literal120_tree=null;
        CommonTree char_literal122_tree=null;
        CommonTree IDCON123_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:100:11: ( IDCON '=' expression ';' | IDCON formals statement )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==IDCON) ) {
                int LA29_1 = input.LA(2);

                if ( (LA29_1==58) ) {
                    alt29=1;
                }
                else if ( (LA29_1==41) ) {
                    alt29=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 29, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:100:14: IDCON '=' expression ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDCON119=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_assignment687); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON119_tree = (CommonTree)adaptor.dupNode(IDCON119);

                    adaptor.addChild(root_0, IDCON119_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal120=(CommonTree)match(input,58,FOLLOW_58_in_assignment689); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal120_tree = (CommonTree)adaptor.dupNode(char_literal120);

                    adaptor.addChild(root_0, char_literal120_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_assignment691);
                    expression121=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression121.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal122=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_assignment693); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal122_tree = (CommonTree)adaptor.dupNode(char_literal122);

                    adaptor.addChild(root_0, char_literal122_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:101:6: IDCON formals statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDCON123=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_assignment701); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON123_tree = (CommonTree)adaptor.dupNode(IDCON123);

                    adaptor.addChild(root_0, IDCON123_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_formals_in_assignment703);
                    formals124=formals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, formals124.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_assignment705);
                    statement125=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, statement125.getTree());

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:106:1: predicate : ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )* ;
    public final WaebricFunctionLoader.predicate_return predicate() throws RecognitionException {
        WaebricFunctionLoader.predicate_return retval = new WaebricFunctionLoader.predicate_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal126=null;
        CommonTree char_literal130=null;
        CommonTree string_literal132=null;
        CommonTree string_literal134=null;
        WaebricFunctionLoader.predicate_return predicate127 = null;

        WaebricFunctionLoader.expression_return expression128 = null;

        WaebricFunctionLoader.expression_return expression129 = null;

        WaebricFunctionLoader.type_return type131 = null;

        WaebricFunctionLoader.predicate_return predicate133 = null;

        WaebricFunctionLoader.predicate_return predicate135 = null;


        CommonTree char_literal126_tree=null;
        CommonTree char_literal130_tree=null;
        CommonTree string_literal132_tree=null;
        CommonTree string_literal134_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:106:10: ( ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:106:13: ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:106:13: ( '!' predicate | expression | expression '.' type )
            int alt30=3;
            alt30 = dfa30.predict(input);
            switch (alt30) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:106:15: '!' predicate
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal126=(CommonTree)match(input,59,FOLLOW_59_in_predicate720); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal126_tree = (CommonTree)adaptor.dupNode(char_literal126);

                    adaptor.addChild(root_0, char_literal126_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_predicate722);
                    predicate127=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, predicate127.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:107:7: expression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate731);
                    expression128=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression128.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:108:7: expression '.' type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate740);
                    expression129=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression129.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal130=(CommonTree)match(input,34,FOLLOW_34_in_predicate742); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal130_tree = (CommonTree)adaptor.dupNode(char_literal130);

                    adaptor.addChild(root_0, char_literal130_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_predicate744);
                    type131=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, type131.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:109:6: ( '&&' predicate | '||' predicate )*
            loop31:
            do {
                int alt31=3;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==60) ) {
                    int LA31_2 = input.LA(2);

                    if ( (synpred54_WaebricFunctionLoader()) ) {
                        alt31=1;
                    }


                }
                else if ( (LA31_0==61) ) {
                    int LA31_3 = input.LA(2);

                    if ( (synpred55_WaebricFunctionLoader()) ) {
                        alt31=2;
                    }


                }


                switch (alt31) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:109:8: '&&' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal132=(CommonTree)match(input,60,FOLLOW_60_in_predicate754); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal132_tree = (CommonTree)adaptor.dupNode(string_literal132);

            	    adaptor.addChild(root_0, string_literal132_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate756);
            	    predicate133=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, predicate133.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:109:25: '||' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal134=(CommonTree)match(input,61,FOLLOW_61_in_predicate760); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal134_tree = (CommonTree)adaptor.dupNode(string_literal134);

            	    adaptor.addChild(root_0, string_literal134_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate762);
            	    predicate135=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, predicate135.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop31;
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:111:1: type : ( 'list' | 'record' | 'string' );
    public final WaebricFunctionLoader.type_return type() throws RecognitionException {
        WaebricFunctionLoader.type_return retval = new WaebricFunctionLoader.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set136=null;

        CommonTree set136_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:111:5: ( 'list' | 'record' | 'string' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            set136=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=62 && input.LA(1)<=64) ) {
                input.consume();

                if ( state.backtracking==0 ) {
                set136_tree = (CommonTree)adaptor.dupNode(set136);

                adaptor.addChild(root_0, set136_tree);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:116:1: embedding : PRETEXT embed textTail ;
    public final WaebricFunctionLoader.embedding_return embedding() throws RecognitionException {
        WaebricFunctionLoader.embedding_return retval = new WaebricFunctionLoader.embedding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PRETEXT137=null;
        WaebricFunctionLoader.embed_return embed138 = null;

        WaebricFunctionLoader.textTail_return textTail139 = null;


        CommonTree PRETEXT137_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:116:10: ( PRETEXT embed textTail )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:116:13: PRETEXT embed textTail
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PRETEXT137=(CommonTree)match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding798); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRETEXT137_tree = (CommonTree)adaptor.dupNode(PRETEXT137);

            adaptor.addChild(root_0, PRETEXT137_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_embed_in_embedding800);
            embed138=embed();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, embed138.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_textTail_in_embedding802);
            textTail139=textTail();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, textTail139.getTree());

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:118:1: embed : ( ( markup )* expression | ( markup )* markup );
    public final WaebricFunctionLoader.embed_return embed() throws RecognitionException {
        WaebricFunctionLoader.embed_return retval = new WaebricFunctionLoader.embed_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricFunctionLoader.markup_return markup140 = null;

        WaebricFunctionLoader.expression_return expression141 = null;

        WaebricFunctionLoader.markup_return markup142 = null;

        WaebricFunctionLoader.markup_return markup143 = null;



        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:118:6: ( ( markup )* expression | ( markup )* markup )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==IDCON) ) {
                int LA34_1 = input.LA(2);

                if ( (synpred59_WaebricFunctionLoader()) ) {
                    alt34=1;
                }
                else if ( (true) ) {
                    alt34=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 34, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA34_0>=NATCON && LA34_0<=SYMBOLCON)||LA34_0==44||LA34_0==46) ) {
                alt34=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:118:10: ( markup )* expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:118:10: ( markup )*
                    loop32:
                    do {
                        int alt32=2;
                        alt32 = dfa32.predict(input);
                        switch (alt32) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed812);
                    	    markup140=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup140.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_embed815);
                    expression141=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression141.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:118:31: ( markup )* markup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:118:31: ( markup )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==IDCON) ) {
                            int LA33_1 = input.LA(2);

                            if ( (synpred60_WaebricFunctionLoader()) ) {
                                alt33=1;
                            }


                        }


                        switch (alt33) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed819);
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
                    pushFollow(FOLLOW_markup_in_embed822);
                    markup143=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, markup143.getTree());

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:120:1: textTail : ( POSTTEXT | MIDTEXT embed textTail );
    public final WaebricFunctionLoader.textTail_return textTail() throws RecognitionException {
        WaebricFunctionLoader.textTail_return retval = new WaebricFunctionLoader.textTail_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POSTTEXT144=null;
        CommonTree MIDTEXT145=null;
        WaebricFunctionLoader.embed_return embed146 = null;

        WaebricFunctionLoader.textTail_return textTail147 = null;


        CommonTree POSTTEXT144_tree=null;
        CommonTree MIDTEXT145_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:120:9: ( POSTTEXT | MIDTEXT embed textTail )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==POSTTEXT) ) {
                alt35=1;
            }
            else if ( (LA35_0==MIDTEXT) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:120:12: POSTTEXT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    POSTTEXT144=(CommonTree)match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail831); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    POSTTEXT144_tree = (CommonTree)adaptor.dupNode(POSTTEXT144);

                    adaptor.addChild(root_0, POSTTEXT144_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:120:23: MIDTEXT embed textTail
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    MIDTEXT145=(CommonTree)match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail835); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MIDTEXT145_tree = (CommonTree)adaptor.dupNode(MIDTEXT145);

                    adaptor.addChild(root_0, MIDTEXT145_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embed_in_textTail837);
                    embed146=embed();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, embed146.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_textTail_in_textTail839);
                    textTail147=textTail();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, textTail147.getTree());

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

    // $ANTLR start synpred25_WaebricFunctionLoader
    public final void synpred25_WaebricFunctionLoader_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:63:8: ( '+' expression )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:63:8: '+' expression
        {
        match(input,48,FOLLOW_48_in_synpred25_WaebricFunctionLoader369); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred25_WaebricFunctionLoader371);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_WaebricFunctionLoader

    // $ANTLR start synpred26_WaebricFunctionLoader
    public final void synpred26_WaebricFunctionLoader_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:63:35: ( '.' IDCON )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:63:35: '.' IDCON
        {
        match(input,34,FOLLOW_34_in_synpred26_WaebricFunctionLoader377); if (state.failed) return ;
        match(input,IDCON,FOLLOW_IDCON_in_synpred26_WaebricFunctionLoader379); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_WaebricFunctionLoader

    // $ANTLR start synpred30_WaebricFunctionLoader
    public final void synpred30_WaebricFunctionLoader_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:81:13: ( ^( 'if' predicate statement 'else' statement ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:81:13: ^( 'if' predicate statement 'else' statement )
        {
        match(input,50,FOLLOW_50_in_synpred30_WaebricFunctionLoader458); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred30_WaebricFunctionLoader460);
        predicate();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred30_WaebricFunctionLoader462);
        statement();

        state._fsp--;
        if (state.failed) return ;
        match(input,51,FOLLOW_51_in_synpred30_WaebricFunctionLoader464); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred30_WaebricFunctionLoader466);
        statement();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_WaebricFunctionLoader

    // $ANTLR start synpred31_WaebricFunctionLoader
    public final void synpred31_WaebricFunctionLoader_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:82:6: ( ^( 'if' predicate statement ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:82:6: ^( 'if' predicate statement )
        {
        match(input,50,FOLLOW_50_in_synpred31_WaebricFunctionLoader477); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred31_WaebricFunctionLoader479);
        predicate();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred31_WaebricFunctionLoader481);
        statement();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_WaebricFunctionLoader

    // $ANTLR start synpred39_WaebricFunctionLoader
    public final void synpred39_WaebricFunctionLoader_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:87:6: ( ^( 'echo' expression ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:87:6: ^( 'echo' expression )
        {
        match(input,55,FOLLOW_55_in_synpred39_WaebricFunctionLoader559); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred39_WaebricFunctionLoader561);
        expression();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_WaebricFunctionLoader

    // $ANTLR start synpred40_WaebricFunctionLoader
    public final void synpred40_WaebricFunctionLoader_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:88:6: ( ^( 'echo' embedding ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:88:6: ^( 'echo' embedding )
        {
        match(input,55,FOLLOW_55_in_synpred40_WaebricFunctionLoader572); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_embedding_in_synpred40_WaebricFunctionLoader574);
        embedding();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred40_WaebricFunctionLoader

    // $ANTLR start synpred43_WaebricFunctionLoader
    public final void synpred43_WaebricFunctionLoader_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:91:6: ( markup )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:91:6: markup
        {
        pushFollow(FOLLOW_markup_in_synpred43_WaebricFunctionLoader603);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred43_WaebricFunctionLoader

    // $ANTLR start synpred45_WaebricFunctionLoader
    public final void synpred45_WaebricFunctionLoader_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:92:6: ( ^( markup ( markup )* ',' expression ';' ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:92:6: ^( markup ( markup )* ',' expression ';' )
        {
        pushFollow(FOLLOW_markup_in_synpred45_WaebricFunctionLoader612);
        markup();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:92:16: ( markup )*
        loop41:
        do {
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==IDCON) ) {
                alt41=1;
            }


            switch (alt41) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred45_WaebricFunctionLoader614);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop41;
            }
        } while (true);

        match(input,42,FOLLOW_42_in_synpred45_WaebricFunctionLoader617); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred45_WaebricFunctionLoader619);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred45_WaebricFunctionLoader621); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred45_WaebricFunctionLoader

    // $ANTLR start synpred47_WaebricFunctionLoader
    public final void synpred47_WaebricFunctionLoader_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:93:6: ( ^( markup ( markup )* ',' statement ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:93:6: ^( markup ( markup )* ',' statement )
        {
        pushFollow(FOLLOW_markup_in_synpred47_WaebricFunctionLoader632);
        markup();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:93:16: ( markup )*
        loop42:
        do {
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==IDCON) ) {
                alt42=1;
            }


            switch (alt42) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred47_WaebricFunctionLoader634);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop42;
            }
        } while (true);

        match(input,42,FOLLOW_42_in_synpred47_WaebricFunctionLoader637); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred47_WaebricFunctionLoader639);
        statement();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred47_WaebricFunctionLoader

    // $ANTLR start synpred49_WaebricFunctionLoader
    public final void synpred49_WaebricFunctionLoader_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:94:6: ( ^( markup ( markup )* embedding ';' ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:94:6: ^( markup ( markup )* embedding ';' )
        {
        pushFollow(FOLLOW_markup_in_synpred49_WaebricFunctionLoader650);
        markup();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:94:16: ( markup )*
        loop43:
        do {
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==IDCON) ) {
                alt43=1;
            }


            switch (alt43) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred49_WaebricFunctionLoader652);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop43;
            }
        } while (true);

        pushFollow(FOLLOW_embedding_in_synpred49_WaebricFunctionLoader655);
        embedding();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred49_WaebricFunctionLoader657); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred49_WaebricFunctionLoader

    // $ANTLR start synpred53_WaebricFunctionLoader
    public final void synpred53_WaebricFunctionLoader_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:107:7: ( expression )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:107:7: expression
        {
        pushFollow(FOLLOW_expression_in_synpred53_WaebricFunctionLoader731);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred53_WaebricFunctionLoader

    // $ANTLR start synpred54_WaebricFunctionLoader
    public final void synpred54_WaebricFunctionLoader_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:109:8: ( '&&' predicate )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:109:8: '&&' predicate
        {
        match(input,60,FOLLOW_60_in_synpred54_WaebricFunctionLoader754); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred54_WaebricFunctionLoader756);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred54_WaebricFunctionLoader

    // $ANTLR start synpred55_WaebricFunctionLoader
    public final void synpred55_WaebricFunctionLoader_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:109:25: ( '||' predicate )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:109:25: '||' predicate
        {
        match(input,61,FOLLOW_61_in_synpred55_WaebricFunctionLoader760); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred55_WaebricFunctionLoader762);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred55_WaebricFunctionLoader

    // $ANTLR start synpred59_WaebricFunctionLoader
    public final void synpred59_WaebricFunctionLoader_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:118:10: ( ( markup )* expression )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:118:10: ( markup )* expression
        {
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:118:10: ( markup )*
        loop44:
        do {
            int alt44=2;
            alt44 = dfa44.predict(input);
            switch (alt44) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred59_WaebricFunctionLoader812);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop44;
            }
        } while (true);

        pushFollow(FOLLOW_expression_in_synpred59_WaebricFunctionLoader815);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred59_WaebricFunctionLoader

    // $ANTLR start synpred60_WaebricFunctionLoader
    public final void synpred60_WaebricFunctionLoader_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:118:31: ( markup )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:118:31: markup
        {
        pushFollow(FOLLOW_markup_in_synpred60_WaebricFunctionLoader819);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred60_WaebricFunctionLoader

    // Delegated rules

    public final boolean synpred43_WaebricFunctionLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_WaebricFunctionLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_WaebricFunctionLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_WaebricFunctionLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred45_WaebricFunctionLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_WaebricFunctionLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred54_WaebricFunctionLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_WaebricFunctionLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred47_WaebricFunctionLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred47_WaebricFunctionLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_WaebricFunctionLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_WaebricFunctionLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred60_WaebricFunctionLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred60_WaebricFunctionLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_WaebricFunctionLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_WaebricFunctionLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_WaebricFunctionLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_WaebricFunctionLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred59_WaebricFunctionLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred59_WaebricFunctionLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred40_WaebricFunctionLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred40_WaebricFunctionLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred53_WaebricFunctionLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred53_WaebricFunctionLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred49_WaebricFunctionLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred49_WaebricFunctionLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred39_WaebricFunctionLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_WaebricFunctionLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred55_WaebricFunctionLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred55_WaebricFunctionLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA28 dfa28 = new DFA28(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA44 dfa44 = new DFA44(this);
    static final String DFA28_eotS =
        "\23\uffff";
    static final String DFA28_eofS =
        "\23\uffff";
    static final String DFA28_minS =
        "\1\4\1\0\4\uffff\1\0\2\uffff\1\0\11\uffff";
    static final String DFA28_maxS =
        "\1\71\1\0\4\uffff\1\0\2\uffff\1\0\11\uffff";
    static final String DFA28_acceptS =
        "\2\uffff\1\3\1\4\1\5\1\6\1\uffff\1\11\1\12\1\uffff\1\1\1\2\1\7\1"+
        "\10\1\13\1\14\1\15\1\16\1\17";
    static final String DFA28_specialS =
        "\1\uffff\1\0\4\uffff\1\1\2\uffff\1\2\11\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\11\10\uffff\1\5\40\uffff\1\4\3\uffff\1\1\1\uffff\1\2\1\3"+
            "\1\uffff\1\6\1\7\1\10",
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
            "",
            ""
    };

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "81:1: statement : ( ^( 'if' predicate statement 'else' statement ) | ^( 'if' predicate statement ) | ^( 'each' IDCON expression statement ) | ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ) | ^( 'echo' expression ) | ^( 'echo' embedding ) | ^( 'cdata' expression ) | 'yield' | markup | ^( markup ( markup )* ',' expression ';' ) | ^( markup ( markup )* ',' statement ) | ^( markup ( markup )* embedding ';' ) | ^( markup ( markup )* ';' ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TreeNodeStream input = (TreeNodeStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA28_1 = input.LA(1);

                         
                        int index28_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_WaebricFunctionLoader()) ) {s = 10;}

                        else if ( (synpred31_WaebricFunctionLoader()) ) {s = 11;}

                         
                        input.seek(index28_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA28_6 = input.LA(1);

                         
                        int index28_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_WaebricFunctionLoader()) ) {s = 12;}

                        else if ( (synpred40_WaebricFunctionLoader()) ) {s = 13;}

                         
                        input.seek(index28_6);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA28_9 = input.LA(1);

                         
                        int index28_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_WaebricFunctionLoader()) ) {s = 14;}

                        else if ( (synpred45_WaebricFunctionLoader()) ) {s = 15;}

                        else if ( (synpred47_WaebricFunctionLoader()) ) {s = 16;}

                        else if ( (synpred49_WaebricFunctionLoader()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index28_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 28, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA30_eotS =
        "\12\uffff";
    static final String DFA30_eofS =
        "\12\uffff";
    static final String DFA30_minS =
        "\1\4\1\uffff\6\0\2\uffff";
    static final String DFA30_maxS =
        "\1\73\1\uffff\6\0\2\uffff";
    static final String DFA30_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\1\3";
    static final String DFA30_specialS =
        "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\2\uffff}>";
    static final String[] DFA30_transitionS = {
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
            return "106:13: ( '!' predicate | expression | expression '.' type )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TreeNodeStream input = (TreeNodeStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA30_2 = input.LA(1);

                         
                        int index30_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred53_WaebricFunctionLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index30_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA30_3 = input.LA(1);

                         
                        int index30_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred53_WaebricFunctionLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index30_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA30_4 = input.LA(1);

                         
                        int index30_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred53_WaebricFunctionLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index30_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA30_5 = input.LA(1);

                         
                        int index30_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred53_WaebricFunctionLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index30_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA30_6 = input.LA(1);

                         
                        int index30_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred53_WaebricFunctionLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index30_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA30_7 = input.LA(1);

                         
                        int index30_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred53_WaebricFunctionLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index30_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 30, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA32_eotS =
        "\6\uffff";
    static final String DFA32_eofS =
        "\6\uffff";
    static final String DFA32_minS =
        "\2\4\1\uffff\1\4\1\uffff\1\4";
    static final String DFA32_maxS =
        "\1\56\1\60\1\uffff\1\4\1\uffff\1\60";
    static final String DFA32_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String DFA32_specialS =
        "\6\uffff}>";
    static final String[] DFA32_transitionS = {
            "\1\1\1\uffff\3\2\43\uffff\1\2\1\uffff\1\2",
            "\1\4\1\uffff\3\4\2\uffff\2\2\25\uffff\1\3\1\uffff\4\4\1\uffff"+
            "\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\2",
            "",
            "\1\5",
            "",
            "\1\4\1\uffff\3\4\2\uffff\2\2\25\uffff\1\3\1\uffff\4\4\1\uffff"+
            "\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\2"
    };

    static final short[] DFA32_eot = DFA.unpackEncodedString(DFA32_eotS);
    static final short[] DFA32_eof = DFA.unpackEncodedString(DFA32_eofS);
    static final char[] DFA32_min = DFA.unpackEncodedStringToUnsignedChars(DFA32_minS);
    static final char[] DFA32_max = DFA.unpackEncodedStringToUnsignedChars(DFA32_maxS);
    static final short[] DFA32_accept = DFA.unpackEncodedString(DFA32_acceptS);
    static final short[] DFA32_special = DFA.unpackEncodedString(DFA32_specialS);
    static final short[][] DFA32_transition;

    static {
        int numStates = DFA32_transitionS.length;
        DFA32_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA32_transition[i] = DFA.unpackEncodedString(DFA32_transitionS[i]);
        }
    }

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = DFA32_eot;
            this.eof = DFA32_eof;
            this.min = DFA32_min;
            this.max = DFA32_max;
            this.accept = DFA32_accept;
            this.special = DFA32_special;
            this.transition = DFA32_transition;
        }
        public String getDescription() {
            return "()* loopback of 118:10: ( markup )*";
        }
    }
    static final String DFA44_eotS =
        "\6\uffff";
    static final String DFA44_eofS =
        "\1\uffff\1\2\3\uffff\1\2";
    static final String DFA44_minS =
        "\2\4\2\uffff\2\4";
    static final String DFA44_maxS =
        "\1\56\1\60\2\uffff\1\4\1\60";
    static final String DFA44_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA44_specialS =
        "\6\uffff}>";
    static final String[] DFA44_transitionS = {
            "\1\1\1\uffff\3\2\43\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\31\uffff\1\4\1\uffff\4\3\1\uffff\1\3\2\uffff"+
            "\1\3\1\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\31\uffff\1\4\1\uffff\4\3\1\uffff\1\3\2\uffff"+
            "\1\3\1\uffff\1\3\1\uffff\1\2"
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
            return "()* loopback of 118:10: ( markup )*";
        }
    }
 

    public static final BitSet FOLLOW_33_in_module57 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_moduleId_in_module59 = new BitSet(new long[]{0x0002000800004008L});
    public static final BitSet FOLLOW_imprt_in_module61 = new BitSet(new long[]{0x0002000800004008L});
    public static final BitSet FOLLOW_site_in_module64 = new BitSet(new long[]{0x0002000000004008L});
    public static final BitSet FOLLOW_function_in_module67 = new BitSet(new long[]{0x0002000000000008L});
    public static final BitSet FOLLOW_IDCON_in_moduleId79 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_moduleId83 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_moduleId87 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_35_in_imprt101 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_moduleId_in_imprt103 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_imprt105 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_module_in_imprt109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SITE_in_site122 = new BitSet(new long[]{0x0000000000018020L});
    public static final BitSet FOLLOW_mappings_in_site124 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_END_in_site126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapping_in_mappings135 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_SEMICOLON_in_mappings140 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_mapping_in_mappings142 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_PATH_in_mapping155 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_mapping157 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_mapping159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_designator_in_markup172 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_arguments_in_markup174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_designator184 = new BitSet(new long[]{0x000000F400000002L});
    public static final BitSet FOLLOW_attribute_in_designator186 = new BitSet(new long[]{0x000000F400000002L});
    public static final BitSet FOLLOW_37_in_attribute196 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_attribute206 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_attribute216 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_attribute226 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_attribute236 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NATCON_in_attribute238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_attribute246 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NATCON_in_attribute248 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_attribute250 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NATCON_in_attribute252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_arguments264 = new BitSet(new long[]{0x00005C00000001D0L});
    public static final BitSet FOLLOW_argument_in_arguments266 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_42_in_arguments271 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_argument_in_arguments273 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_43_in_arguments278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_argument287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_expression301 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_NATCON_in_expression305 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_TEXT_in_expression309 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_SYMBOLCON_in_expression313 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_44_in_expression322 = new BitSet(new long[]{0x00007400000001D0L});
    public static final BitSet FOLLOW_expression_in_expression324 = new BitSet(new long[]{0x0000240000000000L});
    public static final BitSet FOLLOW_42_in_expression329 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_expression331 = new BitSet(new long[]{0x0000240000000000L});
    public static final BitSet FOLLOW_45_in_expression336 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_46_in_expression345 = new BitSet(new long[]{0x0000840000000010L});
    public static final BitSet FOLLOW_keyValuePair_in_expression347 = new BitSet(new long[]{0x0000840000000000L});
    public static final BitSet FOLLOW_42_in_expression352 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_keyValuePair_in_expression354 = new BitSet(new long[]{0x0000840000000000L});
    public static final BitSet FOLLOW_47_in_expression359 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_48_in_expression369 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_expression371 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_34_in_expression377 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_expression379 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_IDCON_in_keyValuePair396 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_keyValuePair398 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_keyValuePair400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_function412 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_function416 = new BitSet(new long[]{0x03B442000000A010L});
    public static final BitSet FOLLOW_formals_in_function418 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_statement_in_function421 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_END_in_function424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_formals438 = new BitSet(new long[]{0x0000080000000010L});
    public static final BitSet FOLLOW_IDCON_in_formals440 = new BitSet(new long[]{0x0000080000000010L});
    public static final BitSet FOLLOW_43_in_formals443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_statement458 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_predicate_in_statement460 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement462 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_statement464 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement466 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_50_in_statement477 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_predicate_in_statement479 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement481 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_52_in_statement492 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_statement494 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_statement496 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement498 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_53_in_statement509 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_assignment_in_statement511 = new BitSet(new long[]{0x0040000000000010L});
    public static final BitSet FOLLOW_54_in_statement514 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_statement_in_statement516 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_END_in_statement519 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_46_in_statement530 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statement532 = new BitSet(new long[]{0x03B4C00000002010L});
    public static final BitSet FOLLOW_47_in_statement535 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COMMENT_in_statement546 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRCON_in_statement548 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_55_in_statement559 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement561 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_55_in_statement572 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_statement574 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_56_in_statement585 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement587 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_57_in_statement596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement612 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement614 = new BitSet(new long[]{0x0000040000000010L});
    public static final BitSet FOLLOW_42_in_statement617 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_statement619 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement621 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_statement632 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement634 = new BitSet(new long[]{0x0000040000000010L});
    public static final BitSet FOLLOW_42_in_statement637 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement639 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_statement650 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement652 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_embedding_in_statement655 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement657 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_statement668 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement670 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement673 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDCON_in_assignment687 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_assignment689 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_assignment691 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_assignment693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_assignment701 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_formals_in_assignment703 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_assignment705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_predicate720 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_predicate722 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate731 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate740 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_predicate742 = new BitSet(new long[]{0xC000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_type_in_predicate744 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_60_in_predicate754 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_predicate756 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_61_in_predicate760 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_predicate762 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding798 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_embed_in_embedding800 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_textTail_in_embedding802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed812 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_embed815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed819 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_embed822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail835 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_embed_in_textTail837 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_textTail_in_textTail839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_synpred25_WaebricFunctionLoader369 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_synpred25_WaebricFunctionLoader371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_synpred26_WaebricFunctionLoader377 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_synpred26_WaebricFunctionLoader379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_synpred30_WaebricFunctionLoader458 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_predicate_in_synpred30_WaebricFunctionLoader460 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_synpred30_WaebricFunctionLoader462 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_synpred30_WaebricFunctionLoader464 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_synpred30_WaebricFunctionLoader466 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_50_in_synpred31_WaebricFunctionLoader477 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_predicate_in_synpred31_WaebricFunctionLoader479 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_synpred31_WaebricFunctionLoader481 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_55_in_synpred39_WaebricFunctionLoader559 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_synpred39_WaebricFunctionLoader561 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_55_in_synpred40_WaebricFunctionLoader572 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_synpred40_WaebricFunctionLoader574 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_synpred43_WaebricFunctionLoader603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred45_WaebricFunctionLoader612 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred45_WaebricFunctionLoader614 = new BitSet(new long[]{0x0000040000000010L});
    public static final BitSet FOLLOW_42_in_synpred45_WaebricFunctionLoader617 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_synpred45_WaebricFunctionLoader619 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred45_WaebricFunctionLoader621 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_synpred47_WaebricFunctionLoader632 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred47_WaebricFunctionLoader634 = new BitSet(new long[]{0x0000040000000010L});
    public static final BitSet FOLLOW_42_in_synpred47_WaebricFunctionLoader637 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_synpred47_WaebricFunctionLoader639 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_synpred49_WaebricFunctionLoader650 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred49_WaebricFunctionLoader652 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_embedding_in_synpred49_WaebricFunctionLoader655 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred49_WaebricFunctionLoader657 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_synpred53_WaebricFunctionLoader731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_synpred54_WaebricFunctionLoader754 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_synpred54_WaebricFunctionLoader756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred55_WaebricFunctionLoader760 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_synpred55_WaebricFunctionLoader762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred59_WaebricFunctionLoader812 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_synpred59_WaebricFunctionLoader815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred60_WaebricFunctionLoader819 = new BitSet(new long[]{0x0000000000000002L});

}