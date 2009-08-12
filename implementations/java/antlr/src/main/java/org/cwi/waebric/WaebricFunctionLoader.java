// $ANTLR 3.1.2 /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g 2009-08-12 14:01:38

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDCON", "PATH", "NATCON", "TEXT", "SYMBOLCON", "STRCON", "PRETEXT", "POSTTEXT", "MIDTEXT", "COMMENT", "SITE", "END", "SEMICOLON", "LETTER", "DIGIT", "HEXADECIMAL", "PATHELEMENT", "FILEEXT", "STRCHAR", "ESCLAYOUT", "DECIMAL", "TEXTCHAR", "ESCQUOTE", "AMP", "CHARREF", "ENTREF", "SYMBOLCHAR", "COMMENTS", "LAYOUT", "'module'", "'.'", "'import'", "':'", "'#'", "'$'", "'@'", "'%'", "'('", "','", "')'", "'['", "']'", "'{'", "'}'", "'+'", "'def'", "'if'", "'else'", "'each'", "'let'", "'in'", "'echo'", "'cdata'", "'yield;'", "'='", "'!'", "'&&'", "'||'", "'list'", "'record'", "'string'"
    };
    public static final int ESCLAYOUT=23;
    public static final int T__42=42;
    public static final int END=15;
    public static final int T__57=57;
    public static final int T__51=51;
    public static final int FILEEXT=21;
    public static final int T__47=47;
    public static final int T__50=50;
    public static final int STRCHAR=22;
    public static final int SYMBOLCON=8;
    public static final int COMMENTS=31;
    public static final int IDCON=4;
    public static final int DECIMAL=24;
    public static final int HEXADECIMAL=19;
    public static final int T__39=39;
    public static final int TEXTCHAR=25;
    public static final int T__46=46;
    public static final int T__52=52;
    public static final int T__62=62;
    public static final int STRCON=9;
    public static final int T__49=49;
    public static final int AMP=27;
    public static final int T__61=61;
    public static final int POSTTEXT=11;
    public static final int T__59=59;
    public static final int DIGIT=18;
    public static final int T__48=48;
    public static final int T__54=54;
    public static final int T__34=34;
    public static final int LAYOUT=32;
    public static final int ESCQUOTE=26;
    public static final int PATHELEMENT=20;
    public static final int T__56=56;
    public static final int ENTREF=29;
    public static final int LETTER=17;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int SITE=14;
    public static final int T__58=58;
    public static final int T__64=64;
    public static final int T__44=44;
    public static final int SYMBOLCHAR=30;
    public static final int COMMENT=13;
    public static final int T__33=33;
    public static final int T__55=55;
    public static final int T__45=45;
    public static final int CHARREF=28;
    public static final int MIDTEXT=12;
    public static final int T__63=63;
    public static final int PRETEXT=10;
    public static final int T__43=43;
    public static final int SEMICOLON=16;
    public static final int T__40=40;
    public static final int EOF=-1;
    public static final int T__53=53;
    public static final int TEXT=7;
    public static final int T__38=38;
    public static final int NATCON=6;
    public static final int T__37=37;
    public static final int T__60=60;
    public static final int T__41=41;
    public static final int PATH=5;

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
    public String getGrammarFileName() { return "/Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g"; }


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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:24:1: module : ^( 'module' moduleId ( imprt )* ( site )* ( function )* ) ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:24:7: ( ^( 'module' moduleId ( imprt )* ( site )* ( function )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:24:11: ^( 'module' moduleId ( imprt )* ( site )* ( function )* )
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:24:32: ( imprt )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==35) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: imprt
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

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:24:39: ( site )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==SITE) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: site
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

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:24:45: ( function )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==49) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: function
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:26:1: moduleId : IDCON ( '.' e= IDCON )* ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:26:9: ( IDCON ( '.' e= IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:26:12: IDCON ( '.' e= IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON6=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_moduleId79); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON6_tree = (CommonTree)adaptor.dupNode(IDCON6);

            adaptor.addChild(root_0, IDCON6_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:26:18: ( '.' e= IDCON )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==34) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:26:20: '.' e= IDCON
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:28:1: imprt : 'import' moduleId ';' module ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:28:6: ( 'import' moduleId ';' module )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:28:10: 'import' moduleId ';' module
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:33:1: site : 'site' mappings 'end' ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:33:5: ( 'site' mappings 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:33:9: 'site' mappings 'end'
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:35:1: mappings : ( mapping )? ( ';' mapping )* ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:35:9: ( ( mapping )? ( ';' mapping )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:35:12: ( mapping )? ( ';' mapping )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:35:12: ( mapping )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==PATH) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: mapping
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

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:35:21: ( ';' mapping )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==SEMICOLON) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:35:23: ';' mapping
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:37:1: mapping : PATH ':' markup ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:37:9: ( PATH ':' markup )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:37:12: PATH ':' markup
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:42:1: markup : designator ( arguments )? ;
    public final WaebricFunctionLoader.markup_return markup() throws RecognitionException {
        WaebricFunctionLoader.markup_return retval = new WaebricFunctionLoader.markup_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricFunctionLoader.designator_return designator21 = null;

        WaebricFunctionLoader.arguments_return arguments22 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:42:7: ( designator ( arguments )? )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:42:11: designator ( arguments )?
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_designator_in_markup172);
            designator21=designator();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, designator21.getTree());
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:42:22: ( arguments )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==41) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: arguments
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:44:1: designator : IDCON ( attribute )* ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:44:11: ( IDCON ( attribute )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:44:14: IDCON ( attribute )*
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON23=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_designator184); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON23_tree = (CommonTree)adaptor.dupNode(IDCON23);

            adaptor.addChild(root_0, IDCON23_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:44:20: ( attribute )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==34||(LA8_0>=36 && LA8_0<=39)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: attribute
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:46:1: attribute : ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON );
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:46:10: ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON )
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
                    else if ( (LA9_6==EOF||LA9_6==IDCON||(LA9_6>=NATCON && LA9_6<=SYMBOLCON)||(LA9_6>=PRETEXT && LA9_6<=MIDTEXT)||(LA9_6>=END && LA9_6<=SEMICOLON)||LA9_6==34||(LA9_6>=36 && LA9_6<=39)||(LA9_6>=41 && LA9_6<=42)||LA9_6==44||LA9_6==46) ) {
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:46:13: '#' IDCON
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:47:6: '.' IDCON
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:48:6: '$' IDCON
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:49:6: ':' IDCON
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:50:6: '@' NATCON
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:51:6: '@' NATCON '%' NATCON
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:53:1: arguments : '(' ( argument )? ( ',' argument )* ')' ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:53:10: ( '(' ( argument )? ( ',' argument )* ')' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:53:13: '(' ( argument )? ( ',' argument )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            char_literal39=(CommonTree)match(input,41,FOLLOW_41_in_arguments264); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal39_tree = (CommonTree)adaptor.dupNode(char_literal39);

            adaptor.addChild(root_0, char_literal39_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:53:17: ( argument )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==IDCON||(LA10_0>=NATCON && LA10_0<=SYMBOLCON)||LA10_0==44||LA10_0==46) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: argument
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

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:53:27: ( ',' argument )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==42) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:53:29: ',' argument
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:55:1: argument : expression ;
    public final WaebricFunctionLoader.argument_return argument() throws RecognitionException {
        WaebricFunctionLoader.argument_return retval = new WaebricFunctionLoader.argument_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricFunctionLoader.expression_return expression44 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:55:9: ( expression )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:55:12: expression
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:60:1: expression : ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:60:11: ( ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:60:14: ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:60:14: ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' )
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:60:16: IDCON
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:60:24: NATCON
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:60:33: TEXT
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:60:40: SYMBOLCON
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:61:7: '[' ( expression )? ( ',' expression )* ']'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal49=(CommonTree)match(input,44,FOLLOW_44_in_expression322); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal49_tree = (CommonTree)adaptor.dupNode(char_literal49);

                    adaptor.addChild(root_0, char_literal49_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:61:11: ( expression )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==IDCON||(LA12_0>=NATCON && LA12_0<=SYMBOLCON)||LA12_0==44||LA12_0==46) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: expression
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

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:61:23: ( ',' expression )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==42) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:61:25: ',' expression
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:62:7: '{' ( keyValuePair )? ( ',' keyValuePair )* '}'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal54=(CommonTree)match(input,46,FOLLOW_46_in_expression345); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal54_tree = (CommonTree)adaptor.dupNode(char_literal54);

                    adaptor.addChild(root_0, char_literal54_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:62:11: ( keyValuePair )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==IDCON) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: keyValuePair
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

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:62:25: ( ',' keyValuePair )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==42) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:62:27: ',' keyValuePair
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

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:63:6: ( '+' expression | '.' IDCON )*
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
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:63:8: '+' expression
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
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:63:35: '.' IDCON
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:65:1: keyValuePair : IDCON ':' expression ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:65:13: ( IDCON ':' expression )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:65:16: IDCON ':' expression
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:70:1: function : 'def' id= IDCON ( formals )? ( statement )* 'end' ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:70:9: ( 'def' id= IDCON ( formals )? ( statement )* 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:70:12: 'def' id= IDCON ( formals )? ( statement )* 'end'
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:70:27: ( formals )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==41) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: formals
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

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:70:36: ( statement )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==IDCON||LA19_0==COMMENT||LA19_0==46||LA19_0==50||(LA19_0>=52 && LA19_0<=53)||(LA19_0>=55 && LA19_0<=57)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: statement
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:75:1: formals : '(' ( IDCON )* ')' ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:75:8: ( '(' ( IDCON )* ')' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:75:11: '(' ( IDCON )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            char_literal70=(CommonTree)match(input,41,FOLLOW_41_in_formals438); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal70_tree = (CommonTree)adaptor.dupNode(char_literal70);

            adaptor.addChild(root_0, char_literal70_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:75:15: ( IDCON )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==IDCON) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: IDCON
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:81:1: statement : ( 'if' '(' predicate ')' statement 'else' statement | 'if' '(' predicate ')' statement | 'each' '(' IDCON ':' expression ')' statement | 'let' ( assignment )+ 'in' ( statement )* 'end' | '{' ( statement )* '}' | 'comment' STRCON ';' | 'echo' expression ';' | 'echo' embedding ';' | 'cdata' expression ';' | 'yield;' | ( markup )+ ',' expression ';' | ( markup )+ ',' statement | ( markup )+ embedding ';' | ( markup )+ ';' );
    public final WaebricFunctionLoader.statement_return statement() throws RecognitionException {
        WaebricFunctionLoader.statement_return retval = new WaebricFunctionLoader.statement_return();
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
        CommonTree char_literal83=null;
        CommonTree string_literal85=null;
        CommonTree char_literal86=null;
        CommonTree IDCON87=null;
        CommonTree char_literal88=null;
        CommonTree char_literal90=null;
        CommonTree string_literal92=null;
        CommonTree string_literal94=null;
        CommonTree string_literal96=null;
        CommonTree char_literal97=null;
        CommonTree char_literal99=null;
        CommonTree string_literal100=null;
        CommonTree STRCON101=null;
        CommonTree char_literal102=null;
        CommonTree string_literal103=null;
        CommonTree char_literal105=null;
        CommonTree string_literal106=null;
        CommonTree char_literal108=null;
        CommonTree string_literal109=null;
        CommonTree char_literal111=null;
        CommonTree string_literal112=null;
        CommonTree char_literal114=null;
        CommonTree char_literal116=null;
        CommonTree char_literal118=null;
        CommonTree char_literal122=null;
        CommonTree char_literal124=null;
        WaebricFunctionLoader.predicate_return predicate75 = null;

        WaebricFunctionLoader.statement_return statement77 = null;

        WaebricFunctionLoader.statement_return statement79 = null;

        WaebricFunctionLoader.predicate_return predicate82 = null;

        WaebricFunctionLoader.statement_return statement84 = null;

        WaebricFunctionLoader.expression_return expression89 = null;

        WaebricFunctionLoader.statement_return statement91 = null;

        WaebricFunctionLoader.assignment_return assignment93 = null;

        WaebricFunctionLoader.statement_return statement95 = null;

        WaebricFunctionLoader.statement_return statement98 = null;

        WaebricFunctionLoader.expression_return expression104 = null;

        WaebricFunctionLoader.embedding_return embedding107 = null;

        WaebricFunctionLoader.expression_return expression110 = null;

        WaebricFunctionLoader.markup_return markup113 = null;

        WaebricFunctionLoader.expression_return expression115 = null;

        WaebricFunctionLoader.markup_return markup117 = null;

        WaebricFunctionLoader.statement_return statement119 = null;

        WaebricFunctionLoader.markup_return markup120 = null;

        WaebricFunctionLoader.embedding_return embedding121 = null;

        WaebricFunctionLoader.markup_return markup123 = null;


        CommonTree string_literal73_tree=null;
        CommonTree char_literal74_tree=null;
        CommonTree char_literal76_tree=null;
        CommonTree string_literal78_tree=null;
        CommonTree string_literal80_tree=null;
        CommonTree char_literal81_tree=null;
        CommonTree char_literal83_tree=null;
        CommonTree string_literal85_tree=null;
        CommonTree char_literal86_tree=null;
        CommonTree IDCON87_tree=null;
        CommonTree char_literal88_tree=null;
        CommonTree char_literal90_tree=null;
        CommonTree string_literal92_tree=null;
        CommonTree string_literal94_tree=null;
        CommonTree string_literal96_tree=null;
        CommonTree char_literal97_tree=null;
        CommonTree char_literal99_tree=null;
        CommonTree string_literal100_tree=null;
        CommonTree STRCON101_tree=null;
        CommonTree char_literal102_tree=null;
        CommonTree string_literal103_tree=null;
        CommonTree char_literal105_tree=null;
        CommonTree string_literal106_tree=null;
        CommonTree char_literal108_tree=null;
        CommonTree string_literal109_tree=null;
        CommonTree char_literal111_tree=null;
        CommonTree string_literal112_tree=null;
        CommonTree char_literal114_tree=null;
        CommonTree char_literal116_tree=null;
        CommonTree char_literal118_tree=null;
        CommonTree char_literal122_tree=null;
        CommonTree char_literal124_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:81:10: ( 'if' '(' predicate ')' statement 'else' statement | 'if' '(' predicate ')' statement | 'each' '(' IDCON ':' expression ')' statement | 'let' ( assignment )+ 'in' ( statement )* 'end' | '{' ( statement )* '}' | 'comment' STRCON ';' | 'echo' expression ';' | 'echo' embedding ';' | 'cdata' expression ';' | 'yield;' | ( markup )+ ',' expression ';' | ( markup )+ ',' statement | ( markup )+ embedding ';' | ( markup )+ ';' )
            int alt28=14;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:81:13: 'if' '(' predicate ')' statement 'else' statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal73=(CommonTree)match(input,50,FOLLOW_50_in_statement456); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal73_tree = (CommonTree)adaptor.dupNode(string_literal73);

                    adaptor.addChild(root_0, string_literal73_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal74=(CommonTree)match(input,41,FOLLOW_41_in_statement458); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal74_tree = (CommonTree)adaptor.dupNode(char_literal74);

                    adaptor.addChild(root_0, char_literal74_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_statement460);
                    predicate75=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, predicate75.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal76=(CommonTree)match(input,43,FOLLOW_43_in_statement462); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal76_tree = (CommonTree)adaptor.dupNode(char_literal76);

                    adaptor.addChild(root_0, char_literal76_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement464);
                    statement77=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, statement77.getTree());
                    _last = (CommonTree)input.LT(1);
                    string_literal78=(CommonTree)match(input,51,FOLLOW_51_in_statement466); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal78_tree = (CommonTree)adaptor.dupNode(string_literal78);

                    adaptor.addChild(root_0, string_literal78_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement468);
                    statement79=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, statement79.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:82:6: 'if' '(' predicate ')' statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal80=(CommonTree)match(input,50,FOLLOW_50_in_statement476); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal80_tree = (CommonTree)adaptor.dupNode(string_literal80);

                    adaptor.addChild(root_0, string_literal80_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal81=(CommonTree)match(input,41,FOLLOW_41_in_statement478); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal81_tree = (CommonTree)adaptor.dupNode(char_literal81);

                    adaptor.addChild(root_0, char_literal81_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_statement480);
                    predicate82=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, predicate82.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal83=(CommonTree)match(input,43,FOLLOW_43_in_statement482); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal83_tree = (CommonTree)adaptor.dupNode(char_literal83);

                    adaptor.addChild(root_0, char_literal83_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement484);
                    statement84=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, statement84.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:83:6: 'each' '(' IDCON ':' expression ')' statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal85=(CommonTree)match(input,52,FOLLOW_52_in_statement492); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal85_tree = (CommonTree)adaptor.dupNode(string_literal85);

                    adaptor.addChild(root_0, string_literal85_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal86=(CommonTree)match(input,41,FOLLOW_41_in_statement494); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal86_tree = (CommonTree)adaptor.dupNode(char_literal86);

                    adaptor.addChild(root_0, char_literal86_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON87=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_statement496); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON87_tree = (CommonTree)adaptor.dupNode(IDCON87);

                    adaptor.addChild(root_0, IDCON87_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal88=(CommonTree)match(input,36,FOLLOW_36_in_statement498); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal88_tree = (CommonTree)adaptor.dupNode(char_literal88);

                    adaptor.addChild(root_0, char_literal88_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement500);
                    expression89=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression89.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal90=(CommonTree)match(input,43,FOLLOW_43_in_statement502); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal90_tree = (CommonTree)adaptor.dupNode(char_literal90);

                    adaptor.addChild(root_0, char_literal90_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement504);
                    statement91=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, statement91.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:84:6: 'let' ( assignment )+ 'in' ( statement )* 'end'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal92=(CommonTree)match(input,53,FOLLOW_53_in_statement512); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal92_tree = (CommonTree)adaptor.dupNode(string_literal92);

                    adaptor.addChild(root_0, string_literal92_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:84:12: ( assignment )+
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
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: assignment
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_assignment_in_statement514);
                    	    assignment93=assignment();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, assignment93.getTree());

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
                    string_literal94=(CommonTree)match(input,54,FOLLOW_54_in_statement517); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal94_tree = (CommonTree)adaptor.dupNode(string_literal94);

                    adaptor.addChild(root_0, string_literal94_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:84:29: ( statement )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==IDCON||LA22_0==COMMENT||LA22_0==46||LA22_0==50||(LA22_0>=52 && LA22_0<=53)||(LA22_0>=55 && LA22_0<=57)) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: statement
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_statement_in_statement519);
                    	    statement95=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, statement95.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    string_literal96=(CommonTree)match(input,END,FOLLOW_END_in_statement522); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal96_tree = (CommonTree)adaptor.dupNode(string_literal96);

                    adaptor.addChild(root_0, string_literal96_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:85:6: '{' ( statement )* '}'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal97=(CommonTree)match(input,46,FOLLOW_46_in_statement530); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal97_tree = (CommonTree)adaptor.dupNode(char_literal97);

                    adaptor.addChild(root_0, char_literal97_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:85:10: ( statement )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==IDCON||LA23_0==COMMENT||LA23_0==46||LA23_0==50||(LA23_0>=52 && LA23_0<=53)||(LA23_0>=55 && LA23_0<=57)) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: statement
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_statement_in_statement532);
                    	    statement98=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, statement98.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal99=(CommonTree)match(input,47,FOLLOW_47_in_statement535); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal99_tree = (CommonTree)adaptor.dupNode(char_literal99);

                    adaptor.addChild(root_0, char_literal99_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:86:6: 'comment' STRCON ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal100=(CommonTree)match(input,COMMENT,FOLLOW_COMMENT_in_statement543); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal100_tree = (CommonTree)adaptor.dupNode(string_literal100);

                    adaptor.addChild(root_0, string_literal100_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    STRCON101=(CommonTree)match(input,STRCON,FOLLOW_STRCON_in_statement545); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRCON101_tree = (CommonTree)adaptor.dupNode(STRCON101);

                    adaptor.addChild(root_0, STRCON101_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal102=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement547); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal102_tree = (CommonTree)adaptor.dupNode(char_literal102);

                    adaptor.addChild(root_0, char_literal102_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:87:6: 'echo' expression ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal103=(CommonTree)match(input,55,FOLLOW_55_in_statement555); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal103_tree = (CommonTree)adaptor.dupNode(string_literal103);

                    adaptor.addChild(root_0, string_literal103_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement557);
                    expression104=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression104.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal105=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement559); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal105_tree = (CommonTree)adaptor.dupNode(char_literal105);

                    adaptor.addChild(root_0, char_literal105_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:88:6: 'echo' embedding ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal106=(CommonTree)match(input,55,FOLLOW_55_in_statement567); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal106_tree = (CommonTree)adaptor.dupNode(string_literal106);

                    adaptor.addChild(root_0, string_literal106_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement569);
                    embedding107=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, embedding107.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal108=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement571); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal108_tree = (CommonTree)adaptor.dupNode(char_literal108);

                    adaptor.addChild(root_0, char_literal108_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:89:6: 'cdata' expression ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal109=(CommonTree)match(input,56,FOLLOW_56_in_statement578); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal109_tree = (CommonTree)adaptor.dupNode(string_literal109);

                    adaptor.addChild(root_0, string_literal109_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement580);
                    expression110=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression110.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal111=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement582); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal111_tree = (CommonTree)adaptor.dupNode(char_literal111);

                    adaptor.addChild(root_0, char_literal111_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:90:6: 'yield;'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal112=(CommonTree)match(input,57,FOLLOW_57_in_statement590); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal112_tree = (CommonTree)adaptor.dupNode(string_literal112);

                    adaptor.addChild(root_0, string_literal112_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:91:6: ( markup )+ ',' expression ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:91:6: ( markup )+
                    int cnt24=0;
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==IDCON) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement598);
                    	    markup113=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup113.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt24 >= 1 ) break loop24;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(24, input);
                                throw eee;
                        }
                        cnt24++;
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal114=(CommonTree)match(input,42,FOLLOW_42_in_statement601); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal114_tree = (CommonTree)adaptor.dupNode(char_literal114);

                    adaptor.addChild(root_0, char_literal114_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement603);
                    expression115=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression115.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal116=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement605); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal116_tree = (CommonTree)adaptor.dupNode(char_literal116);

                    adaptor.addChild(root_0, char_literal116_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:92:6: ( markup )+ ',' statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:92:6: ( markup )+
                    int cnt25=0;
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==IDCON) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement612);
                    	    markup117=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup117.getTree());

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
                    char_literal118=(CommonTree)match(input,42,FOLLOW_42_in_statement615); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal118_tree = (CommonTree)adaptor.dupNode(char_literal118);

                    adaptor.addChild(root_0, char_literal118_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement617);
                    statement119=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, statement119.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:93:6: ( markup )+ embedding ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:93:6: ( markup )+
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
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement624);
                    	    markup120=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup120.getTree());

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
                    pushFollow(FOLLOW_embedding_in_statement627);
                    embedding121=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, embedding121.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal122=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement629); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal122_tree = (CommonTree)adaptor.dupNode(char_literal122);

                    adaptor.addChild(root_0, char_literal122_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:94:6: ( markup )+ ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:94:6: ( markup )+
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
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement637);
                    	    markup123=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup123.getTree());

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
                    char_literal124=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement640); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal124_tree = (CommonTree)adaptor.dupNode(char_literal124);

                    adaptor.addChild(root_0, char_literal124_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:99:1: assignment : ( IDCON '=' expression ';' | IDCON formals statement );
    public final WaebricFunctionLoader.assignment_return assignment() throws RecognitionException {
        WaebricFunctionLoader.assignment_return retval = new WaebricFunctionLoader.assignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON125=null;
        CommonTree char_literal126=null;
        CommonTree char_literal128=null;
        CommonTree IDCON129=null;
        WaebricFunctionLoader.expression_return expression127 = null;

        WaebricFunctionLoader.formals_return formals130 = null;

        WaebricFunctionLoader.statement_return statement131 = null;


        CommonTree IDCON125_tree=null;
        CommonTree char_literal126_tree=null;
        CommonTree char_literal128_tree=null;
        CommonTree IDCON129_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:99:11: ( IDCON '=' expression ';' | IDCON formals statement )
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:99:14: IDCON '=' expression ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDCON125=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_assignment652); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON125_tree = (CommonTree)adaptor.dupNode(IDCON125);

                    adaptor.addChild(root_0, IDCON125_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal126=(CommonTree)match(input,58,FOLLOW_58_in_assignment654); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal126_tree = (CommonTree)adaptor.dupNode(char_literal126);

                    adaptor.addChild(root_0, char_literal126_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_assignment656);
                    expression127=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression127.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal128=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_assignment658); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal128_tree = (CommonTree)adaptor.dupNode(char_literal128);

                    adaptor.addChild(root_0, char_literal128_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:100:6: IDCON formals statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDCON129=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_assignment666); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON129_tree = (CommonTree)adaptor.dupNode(IDCON129);

                    adaptor.addChild(root_0, IDCON129_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_formals_in_assignment668);
                    formals130=formals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, formals130.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_assignment670);
                    statement131=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, statement131.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:105:1: predicate : ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )* ;
    public final WaebricFunctionLoader.predicate_return predicate() throws RecognitionException {
        WaebricFunctionLoader.predicate_return retval = new WaebricFunctionLoader.predicate_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal132=null;
        CommonTree char_literal136=null;
        CommonTree string_literal138=null;
        CommonTree string_literal140=null;
        WaebricFunctionLoader.predicate_return predicate133 = null;

        WaebricFunctionLoader.expression_return expression134 = null;

        WaebricFunctionLoader.expression_return expression135 = null;

        WaebricFunctionLoader.type_return type137 = null;

        WaebricFunctionLoader.predicate_return predicate139 = null;

        WaebricFunctionLoader.predicate_return predicate141 = null;


        CommonTree char_literal132_tree=null;
        CommonTree char_literal136_tree=null;
        CommonTree string_literal138_tree=null;
        CommonTree string_literal140_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:105:10: ( ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:105:13: ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:105:13: ( '!' predicate | expression | expression '.' type )
            int alt30=3;
            alt30 = dfa30.predict(input);
            switch (alt30) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:105:15: '!' predicate
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal132=(CommonTree)match(input,59,FOLLOW_59_in_predicate685); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal132_tree = (CommonTree)adaptor.dupNode(char_literal132);

                    adaptor.addChild(root_0, char_literal132_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_predicate687);
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:106:7: expression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate696);
                    expression134=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression134.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:107:7: expression '.' type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate705);
                    expression135=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression135.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal136=(CommonTree)match(input,34,FOLLOW_34_in_predicate707); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal136_tree = (CommonTree)adaptor.dupNode(char_literal136);

                    adaptor.addChild(root_0, char_literal136_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_predicate709);
                    type137=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, type137.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:108:6: ( '&&' predicate | '||' predicate )*
            loop31:
            do {
                int alt31=3;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==60) ) {
                    int LA31_2 = input.LA(2);

                    if ( (synpred53_WaebricFunctionLoader()) ) {
                        alt31=1;
                    }


                }
                else if ( (LA31_0==61) ) {
                    int LA31_3 = input.LA(2);

                    if ( (synpred54_WaebricFunctionLoader()) ) {
                        alt31=2;
                    }


                }


                switch (alt31) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:108:8: '&&' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal138=(CommonTree)match(input,60,FOLLOW_60_in_predicate719); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal138_tree = (CommonTree)adaptor.dupNode(string_literal138);

            	    adaptor.addChild(root_0, string_literal138_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate721);
            	    predicate139=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, predicate139.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:108:25: '||' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal140=(CommonTree)match(input,61,FOLLOW_61_in_predicate725); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal140_tree = (CommonTree)adaptor.dupNode(string_literal140);

            	    adaptor.addChild(root_0, string_literal140_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate727);
            	    predicate141=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, predicate141.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:110:1: type : ( 'list' | 'record' | 'string' );
    public final WaebricFunctionLoader.type_return type() throws RecognitionException {
        WaebricFunctionLoader.type_return retval = new WaebricFunctionLoader.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set142=null;

        CommonTree set142_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:110:5: ( 'list' | 'record' | 'string' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            set142=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=62 && input.LA(1)<=64) ) {
                input.consume();

                if ( state.backtracking==0 ) {
                set142_tree = (CommonTree)adaptor.dupNode(set142);

                adaptor.addChild(root_0, set142_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:115:1: embedding : PRETEXT embed textTail ;
    public final WaebricFunctionLoader.embedding_return embedding() throws RecognitionException {
        WaebricFunctionLoader.embedding_return retval = new WaebricFunctionLoader.embedding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PRETEXT143=null;
        WaebricFunctionLoader.embed_return embed144 = null;

        WaebricFunctionLoader.textTail_return textTail145 = null;


        CommonTree PRETEXT143_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:115:10: ( PRETEXT embed textTail )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:115:13: PRETEXT embed textTail
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PRETEXT143=(CommonTree)match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding763); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRETEXT143_tree = (CommonTree)adaptor.dupNode(PRETEXT143);

            adaptor.addChild(root_0, PRETEXT143_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_embed_in_embedding765);
            embed144=embed();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, embed144.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_textTail_in_embedding767);
            textTail145=textTail();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, textTail145.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:117:1: embed : ( ( markup )* expression | ( markup )* markup );
    public final WaebricFunctionLoader.embed_return embed() throws RecognitionException {
        WaebricFunctionLoader.embed_return retval = new WaebricFunctionLoader.embed_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricFunctionLoader.markup_return markup146 = null;

        WaebricFunctionLoader.expression_return expression147 = null;

        WaebricFunctionLoader.markup_return markup148 = null;

        WaebricFunctionLoader.markup_return markup149 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:117:6: ( ( markup )* expression | ( markup )* markup )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==IDCON) ) {
                int LA34_1 = input.LA(2);

                if ( (synpred58_WaebricFunctionLoader()) ) {
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:117:10: ( markup )* expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:117:10: ( markup )*
                    loop32:
                    do {
                        int alt32=2;
                        alt32 = dfa32.predict(input);
                        switch (alt32) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed777);
                    	    markup146=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup146.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_embed780);
                    expression147=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression147.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:117:31: ( markup )* markup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:117:31: ( markup )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==IDCON) ) {
                            int LA33_1 = input.LA(2);

                            if ( (synpred59_WaebricFunctionLoader()) ) {
                                alt33=1;
                            }


                        }


                        switch (alt33) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed784);
                    	    markup148=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup148.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_embed787);
                    markup149=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, markup149.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:119:1: textTail : ( POSTTEXT | MIDTEXT embed textTail );
    public final WaebricFunctionLoader.textTail_return textTail() throws RecognitionException {
        WaebricFunctionLoader.textTail_return retval = new WaebricFunctionLoader.textTail_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POSTTEXT150=null;
        CommonTree MIDTEXT151=null;
        WaebricFunctionLoader.embed_return embed152 = null;

        WaebricFunctionLoader.textTail_return textTail153 = null;


        CommonTree POSTTEXT150_tree=null;
        CommonTree MIDTEXT151_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:119:9: ( POSTTEXT | MIDTEXT embed textTail )
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:119:12: POSTTEXT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    POSTTEXT150=(CommonTree)match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail796); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    POSTTEXT150_tree = (CommonTree)adaptor.dupNode(POSTTEXT150);

                    adaptor.addChild(root_0, POSTTEXT150_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:119:23: MIDTEXT embed textTail
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    MIDTEXT151=(CommonTree)match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail800); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MIDTEXT151_tree = (CommonTree)adaptor.dupNode(MIDTEXT151);

                    adaptor.addChild(root_0, MIDTEXT151_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embed_in_textTail802);
                    embed152=embed();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, embed152.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_textTail_in_textTail804);
                    textTail153=textTail();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, textTail153.getTree());

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
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:63:8: ( '+' expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:63:8: '+' expression
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
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:63:35: ( '.' IDCON )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:63:35: '.' IDCON
        {
        match(input,34,FOLLOW_34_in_synpred26_WaebricFunctionLoader377); if (state.failed) return ;
        match(input,IDCON,FOLLOW_IDCON_in_synpred26_WaebricFunctionLoader379); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_WaebricFunctionLoader

    // $ANTLR start synpred30_WaebricFunctionLoader
    public final void synpred30_WaebricFunctionLoader_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:81:13: ( 'if' '(' predicate ')' statement 'else' statement )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:81:13: 'if' '(' predicate ')' statement 'else' statement
        {
        match(input,50,FOLLOW_50_in_synpred30_WaebricFunctionLoader456); if (state.failed) return ;
        match(input,41,FOLLOW_41_in_synpred30_WaebricFunctionLoader458); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred30_WaebricFunctionLoader460);
        predicate();

        state._fsp--;
        if (state.failed) return ;
        match(input,43,FOLLOW_43_in_synpred30_WaebricFunctionLoader462); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred30_WaebricFunctionLoader464);
        statement();

        state._fsp--;
        if (state.failed) return ;
        match(input,51,FOLLOW_51_in_synpred30_WaebricFunctionLoader466); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred30_WaebricFunctionLoader468);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_WaebricFunctionLoader

    // $ANTLR start synpred31_WaebricFunctionLoader
    public final void synpred31_WaebricFunctionLoader_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:82:6: ( 'if' '(' predicate ')' statement )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:82:6: 'if' '(' predicate ')' statement
        {
        match(input,50,FOLLOW_50_in_synpred31_WaebricFunctionLoader476); if (state.failed) return ;
        match(input,41,FOLLOW_41_in_synpred31_WaebricFunctionLoader478); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred31_WaebricFunctionLoader480);
        predicate();

        state._fsp--;
        if (state.failed) return ;
        match(input,43,FOLLOW_43_in_synpred31_WaebricFunctionLoader482); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred31_WaebricFunctionLoader484);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_WaebricFunctionLoader

    // $ANTLR start synpred39_WaebricFunctionLoader
    public final void synpred39_WaebricFunctionLoader_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:87:6: ( 'echo' expression ';' )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:87:6: 'echo' expression ';'
        {
        match(input,55,FOLLOW_55_in_synpred39_WaebricFunctionLoader555); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred39_WaebricFunctionLoader557);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred39_WaebricFunctionLoader559); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_WaebricFunctionLoader

    // $ANTLR start synpred40_WaebricFunctionLoader
    public final void synpred40_WaebricFunctionLoader_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:88:6: ( 'echo' embedding ';' )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:88:6: 'echo' embedding ';'
        {
        match(input,55,FOLLOW_55_in_synpred40_WaebricFunctionLoader567); if (state.failed) return ;
        pushFollow(FOLLOW_embedding_in_synpred40_WaebricFunctionLoader569);
        embedding();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred40_WaebricFunctionLoader571); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred40_WaebricFunctionLoader

    // $ANTLR start synpred44_WaebricFunctionLoader
    public final void synpred44_WaebricFunctionLoader_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:91:6: ( ( markup )+ ',' expression ';' )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:91:6: ( markup )+ ',' expression ';'
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:91:6: ( markup )+
        int cnt41=0;
        loop41:
        do {
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==IDCON) ) {
                alt41=1;
            }


            switch (alt41) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred44_WaebricFunctionLoader598);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt41 >= 1 ) break loop41;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(41, input);
                    throw eee;
            }
            cnt41++;
        } while (true);

        match(input,42,FOLLOW_42_in_synpred44_WaebricFunctionLoader601); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred44_WaebricFunctionLoader603);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred44_WaebricFunctionLoader605); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred44_WaebricFunctionLoader

    // $ANTLR start synpred46_WaebricFunctionLoader
    public final void synpred46_WaebricFunctionLoader_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:92:6: ( ( markup )+ ',' statement )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:92:6: ( markup )+ ',' statement
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:92:6: ( markup )+
        int cnt42=0;
        loop42:
        do {
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==IDCON) ) {
                alt42=1;
            }


            switch (alt42) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred46_WaebricFunctionLoader612);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt42 >= 1 ) break loop42;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(42, input);
                    throw eee;
            }
            cnt42++;
        } while (true);

        match(input,42,FOLLOW_42_in_synpred46_WaebricFunctionLoader615); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred46_WaebricFunctionLoader617);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_WaebricFunctionLoader

    // $ANTLR start synpred48_WaebricFunctionLoader
    public final void synpred48_WaebricFunctionLoader_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:93:6: ( ( markup )+ embedding ';' )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:93:6: ( markup )+ embedding ';'
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:93:6: ( markup )+
        int cnt43=0;
        loop43:
        do {
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==IDCON) ) {
                alt43=1;
            }


            switch (alt43) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred48_WaebricFunctionLoader624);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt43 >= 1 ) break loop43;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(43, input);
                    throw eee;
            }
            cnt43++;
        } while (true);

        pushFollow(FOLLOW_embedding_in_synpred48_WaebricFunctionLoader627);
        embedding();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred48_WaebricFunctionLoader629); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred48_WaebricFunctionLoader

    // $ANTLR start synpred52_WaebricFunctionLoader
    public final void synpred52_WaebricFunctionLoader_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:106:7: ( expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:106:7: expression
        {
        pushFollow(FOLLOW_expression_in_synpred52_WaebricFunctionLoader696);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred52_WaebricFunctionLoader

    // $ANTLR start synpred53_WaebricFunctionLoader
    public final void synpred53_WaebricFunctionLoader_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:108:8: ( '&&' predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:108:8: '&&' predicate
        {
        match(input,60,FOLLOW_60_in_synpred53_WaebricFunctionLoader719); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred53_WaebricFunctionLoader721);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred53_WaebricFunctionLoader

    // $ANTLR start synpred54_WaebricFunctionLoader
    public final void synpred54_WaebricFunctionLoader_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:108:25: ( '||' predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:108:25: '||' predicate
        {
        match(input,61,FOLLOW_61_in_synpred54_WaebricFunctionLoader725); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred54_WaebricFunctionLoader727);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred54_WaebricFunctionLoader

    // $ANTLR start synpred58_WaebricFunctionLoader
    public final void synpred58_WaebricFunctionLoader_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:117:10: ( ( markup )* expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:117:10: ( markup )* expression
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:117:10: ( markup )*
        loop44:
        do {
            int alt44=2;
            alt44 = dfa44.predict(input);
            switch (alt44) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred58_WaebricFunctionLoader777);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop44;
            }
        } while (true);

        pushFollow(FOLLOW_expression_in_synpred58_WaebricFunctionLoader780);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred58_WaebricFunctionLoader

    // $ANTLR start synpred59_WaebricFunctionLoader
    public final void synpred59_WaebricFunctionLoader_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:117:31: ( markup )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricFunctionLoader.g:117:31: markup
        {
        pushFollow(FOLLOW_markup_in_synpred59_WaebricFunctionLoader784);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred59_WaebricFunctionLoader

    // Delegated rules

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
    public final boolean synpred52_WaebricFunctionLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred52_WaebricFunctionLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred44_WaebricFunctionLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_WaebricFunctionLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred46_WaebricFunctionLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_WaebricFunctionLoader_fragment(); // can never throw exception
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
    public final boolean synpred48_WaebricFunctionLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred48_WaebricFunctionLoader_fragment(); // can never throw exception
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
    public final boolean synpred58_WaebricFunctionLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred58_WaebricFunctionLoader_fragment(); // can never throw exception
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


    protected DFA28 dfa28 = new DFA28(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA44 dfa44 = new DFA44(this);
    static final String DFA28_eotS =
        "\22\uffff";
    static final String DFA28_eofS =
        "\22\uffff";
    static final String DFA28_minS =
        "\1\4\1\0\4\uffff\1\0\2\uffff\1\0\10\uffff";
    static final String DFA28_maxS =
        "\1\71\1\0\4\uffff\1\0\2\uffff\1\0\10\uffff";
    static final String DFA28_acceptS =
        "\2\uffff\1\3\1\4\1\5\1\6\1\uffff\1\11\1\12\1\uffff\1\1\1\2\1\7\1"+
        "\10\1\13\1\14\1\15\1\16";
    static final String DFA28_specialS =
        "\1\uffff\1\0\4\uffff\1\1\2\uffff\1\2\10\uffff}>";
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
            return "81:1: statement : ( 'if' '(' predicate ')' statement 'else' statement | 'if' '(' predicate ')' statement | 'each' '(' IDCON ':' expression ')' statement | 'let' ( assignment )+ 'in' ( statement )* 'end' | '{' ( statement )* '}' | 'comment' STRCON ';' | 'echo' expression ';' | 'echo' embedding ';' | 'cdata' expression ';' | 'yield;' | ( markup )+ ',' expression ';' | ( markup )+ ',' statement | ( markup )+ embedding ';' | ( markup )+ ';' );";
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
                        if ( (synpred44_WaebricFunctionLoader()) ) {s = 14;}

                        else if ( (synpred46_WaebricFunctionLoader()) ) {s = 15;}

                        else if ( (synpred48_WaebricFunctionLoader()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
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
            return "105:13: ( '!' predicate | expression | expression '.' type )";
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
                        if ( (synpred52_WaebricFunctionLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index30_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA30_3 = input.LA(1);

                         
                        int index30_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_WaebricFunctionLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index30_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA30_4 = input.LA(1);

                         
                        int index30_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_WaebricFunctionLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index30_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA30_5 = input.LA(1);

                         
                        int index30_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_WaebricFunctionLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index30_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA30_6 = input.LA(1);

                         
                        int index30_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_WaebricFunctionLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index30_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA30_7 = input.LA(1);

                         
                        int index30_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_WaebricFunctionLoader()) ) {s = 8;}

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
        "\2\4\2\uffff\2\4";
    static final String DFA32_maxS =
        "\1\56\1\60\2\uffff\1\4\1\60";
    static final String DFA32_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA32_specialS =
        "\6\uffff}>";
    static final String[] DFA32_transitionS = {
            "\1\1\1\uffff\3\2\43\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\2\uffff\2\2\25\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\2\uffff\2\2\25\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\2"
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
            return "()* loopback of 117:10: ( markup )*";
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
            return "()* loopback of 117:10: ( markup )*";
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
    public static final BitSet FOLLOW_50_in_statement456 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_statement458 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_statement460 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_statement462 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement464 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_statement466 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_statement476 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_statement478 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_statement480 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_statement482 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_statement492 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_statement494 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_statement496 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_statement498 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_statement500 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_statement502 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_statement512 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_assignment_in_statement514 = new BitSet(new long[]{0x0040000000000010L});
    public static final BitSet FOLLOW_54_in_statement517 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_statement_in_statement519 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_END_in_statement522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_statement530 = new BitSet(new long[]{0x03B4C00000002010L});
    public static final BitSet FOLLOW_statement_in_statement532 = new BitSet(new long[]{0x03B4C00000002010L});
    public static final BitSet FOLLOW_47_in_statement535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMENT_in_statement543 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_STRCON_in_statement545 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_statement555 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_statement557 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_statement567 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_embedding_in_statement569 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_statement578 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_statement580 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_statement590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement598 = new BitSet(new long[]{0x0000040000000010L});
    public static final BitSet FOLLOW_42_in_statement601 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_statement603 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement612 = new BitSet(new long[]{0x0000040000000010L});
    public static final BitSet FOLLOW_42_in_statement615 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement624 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_embedding_in_statement627 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement637 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_assignment652 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_assignment654 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_assignment656 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_assignment658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_assignment666 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_formals_in_assignment668 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_assignment670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_predicate685 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_predicate687 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate696 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate705 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_predicate707 = new BitSet(new long[]{0xC000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_type_in_predicate709 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_60_in_predicate719 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_predicate721 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_61_in_predicate725 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_predicate727 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding763 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_embed_in_embedding765 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_textTail_in_embedding767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed777 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_embed780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed784 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_embed787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail800 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_embed_in_textTail802 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_textTail_in_textTail804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_synpred25_WaebricFunctionLoader369 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_synpred25_WaebricFunctionLoader371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_synpred26_WaebricFunctionLoader377 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_synpred26_WaebricFunctionLoader379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_synpred30_WaebricFunctionLoader456 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_synpred30_WaebricFunctionLoader458 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_synpred30_WaebricFunctionLoader460 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_synpred30_WaebricFunctionLoader462 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_synpred30_WaebricFunctionLoader464 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_synpred30_WaebricFunctionLoader466 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_synpred30_WaebricFunctionLoader468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_synpred31_WaebricFunctionLoader476 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_synpred31_WaebricFunctionLoader478 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_synpred31_WaebricFunctionLoader480 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_synpred31_WaebricFunctionLoader482 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_synpred31_WaebricFunctionLoader484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_synpred39_WaebricFunctionLoader555 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_synpred39_WaebricFunctionLoader557 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred39_WaebricFunctionLoader559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_synpred40_WaebricFunctionLoader567 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_embedding_in_synpred40_WaebricFunctionLoader569 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred40_WaebricFunctionLoader571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred44_WaebricFunctionLoader598 = new BitSet(new long[]{0x0000040000000010L});
    public static final BitSet FOLLOW_42_in_synpred44_WaebricFunctionLoader601 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_synpred44_WaebricFunctionLoader603 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred44_WaebricFunctionLoader605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred46_WaebricFunctionLoader612 = new BitSet(new long[]{0x0000040000000010L});
    public static final BitSet FOLLOW_42_in_synpred46_WaebricFunctionLoader615 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_synpred46_WaebricFunctionLoader617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred48_WaebricFunctionLoader624 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_embedding_in_synpred48_WaebricFunctionLoader627 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred48_WaebricFunctionLoader629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred52_WaebricFunctionLoader696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_synpred53_WaebricFunctionLoader719 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_synpred53_WaebricFunctionLoader721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred54_WaebricFunctionLoader725 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_synpred54_WaebricFunctionLoader727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred58_WaebricFunctionLoader777 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_synpred58_WaebricFunctionLoader780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred59_WaebricFunctionLoader784 = new BitSet(new long[]{0x0000000000000002L});

}