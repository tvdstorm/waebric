// $ANTLR 3.1.2 /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g 2009-08-20 22:54:14

	package org.cwi.waebric;
	import antlr.SemanticException;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class WaebricLoader extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATTRIBUTES", "ARGUMENTS", "MARKUP", "MARKUP_STATEMENT", "MARKUP_CHAIN", "FORMALS", "FUNCTION", "IDCON", "PATH", "NATCON", "TEXT", "SYMBOLCON", "STRCON", "PRETEXT", "POSTTEXT", "MIDTEXT", "COMMENT", "SITE", "END", "SEMICOLON", "LETTER", "DIGIT", "HEXADECIMAL", "PATHELEMENT", "FILEEXT", "STRCHAR", "ESCLAYOUT", "DECIMAL", "TEXTCHAR", "ESCQUOTE", "AMP", "CHARREF", "ENTREF", "SYMBOLCHAR", "COMMENTS", "LAYOUT", "'module'", "'.'", "'import'", "':'", "'#'", "'$'", "'@'", "'%'", "'('", "','", "')'", "'='", "'['", "']'", "'{'", "'}'", "'+'", "'if'", "'else'", "'each'", "'let'", "'in'", "'echo'", "'cdata'", "'yield;'", "'!'", "'?'", "'&&'", "'||'", "'list'", "'record'", "'string'"
    };
    public static final int ESCLAYOUT=30;
    public static final int T__42=42;
    public static final int END=22;
    public static final int T__57=57;
    public static final int T__51=51;
    public static final int FILEEXT=28;
    public static final int T__69=69;
    public static final int T__47=47;
    public static final int T__50=50;
    public static final int STRCHAR=29;
    public static final int T__65=65;
    public static final int SYMBOLCON=15;
    public static final int COMMENTS=38;
    public static final int IDCON=11;
    public static final int DECIMAL=31;
    public static final int T__70=70;
    public static final int T__67=67;
    public static final int HEXADECIMAL=26;
    public static final int TEXTCHAR=32;
    public static final int T__52=52;
    public static final int T__46=46;
    public static final int T__68=68;
    public static final int FUNCTION=10;
    public static final int T__62=62;
    public static final int MARKUP=6;
    public static final int STRCON=16;
    public static final int T__49=49;
    public static final int AMP=34;
    public static final int T__61=61;
    public static final int POSTTEXT=18;
    public static final int T__59=59;
    public static final int ATTRIBUTES=4;
    public static final int DIGIT=25;
    public static final int T__54=54;
    public static final int T__48=48;
    public static final int MARKUP_CHAIN=8;
    public static final int LAYOUT=39;
    public static final int ESCQUOTE=33;
    public static final int PATHELEMENT=27;
    public static final int T__56=56;
    public static final int ENTREF=36;
    public static final int LETTER=24;
    public static final int ARGUMENTS=5;
    public static final int SITE=21;
    public static final int T__58=58;
    public static final int T__64=64;
    public static final int T__44=44;
    public static final int T__66=66;
    public static final int SYMBOLCHAR=37;
    public static final int COMMENT=20;
    public static final int MARKUP_STATEMENT=7;
    public static final int FORMALS=9;
    public static final int T__45=45;
    public static final int T__55=55;
    public static final int CHARREF=35;
    public static final int MIDTEXT=19;
    public static final int T__63=63;
    public static final int PRETEXT=17;
    public static final int T__43=43;
    public static final int SEMICOLON=23;
    public static final int T__40=40;
    public static final int EOF=-1;
    public static final int T__53=53;
    public static final int TEXT=14;
    public static final int NATCON=13;
    public static final int T__60=60;
    public static final int T__41=41;
    public static final int T__71=71;
    public static final int PATH=12;

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
    public String getGrammarFileName() { return "/Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g"; }


    	private List<SemanticException> exceptions = new ArrayList<SemanticException>();
    	private Map<String, function_return> functions = new HashMap<String, function_return>();
    	private List<mapping_return> mappings = new ArrayList<mapping_return>();
    	private List<Integer> yields = new ArrayList<Integer>();
    	
    	/**
    	 * Walk module to retrieve function definitions and mappings
    	 */
    	public List<SemanticException> loadModule() throws RecognitionException {
    		exceptions.clear();
    		functions.clear();
    		mappings.clear();
    		this.module();
    		return exceptions;
    	}
    		
    	public Map<String, function_return> getFunctions() { return functions; }
    	public List<mapping_return> getMappings() { return mappings; }
    	public List<Integer> getYields() { return yields; }


    public static class module_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "module"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:38:1: module : ^( 'module' moduleId ( imprt )* ( site )* ( function )* ) ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:38:7: ( ^( 'module' moduleId ( imprt )* ( site )* ( function )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:38:11: ^( 'module' moduleId ( imprt )* ( site )* ( function )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal1=(CommonTree)match(input,40,FOLLOW_40_in_module65); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal1_tree = (CommonTree)adaptor.dupNode(string_literal1);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal1_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_moduleId_in_module67);
            moduleId2=moduleId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, moduleId2.getTree());
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:38:32: ( imprt )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==42) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: imprt
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_imprt_in_module69);
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

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:38:39: ( site )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==SITE) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: site
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_site_in_module72);
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

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:38:45: ( function )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==FUNCTION) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: function
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_function_in_module75);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:40:1: moduleId : IDCON ( '.' IDCON )* ;
    public final WaebricLoader.moduleId_return moduleId() throws RecognitionException {
        WaebricLoader.moduleId_return retval = new WaebricLoader.moduleId_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON6=null;
        CommonTree char_literal7=null;
        CommonTree IDCON8=null;

        CommonTree IDCON6_tree=null;
        CommonTree char_literal7_tree=null;
        CommonTree IDCON8_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:40:9: ( IDCON ( '.' IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:40:12: IDCON ( '.' IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON6=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_moduleId90); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON6_tree = (CommonTree)adaptor.dupNode(IDCON6);

            adaptor.addChild(root_0, IDCON6_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:40:18: ( '.' IDCON )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==41) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:40:20: '.' IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal7=(CommonTree)match(input,41,FOLLOW_41_in_moduleId94); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal7_tree = (CommonTree)adaptor.dupNode(char_literal7);

            	    adaptor.addChild(root_0, char_literal7_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    IDCON8=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_moduleId96); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDCON8_tree = (CommonTree)adaptor.dupNode(IDCON8);

            	    adaptor.addChild(root_0, IDCON8_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:42:1: imprt : 'import' moduleId ( module )? ;
    public final WaebricLoader.imprt_return imprt() throws RecognitionException {
        WaebricLoader.imprt_return retval = new WaebricLoader.imprt_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal9=null;
        WaebricLoader.moduleId_return moduleId10 = null;

        WaebricLoader.module_return module11 = null;


        CommonTree string_literal9_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:42:6: ( 'import' moduleId ( module )? )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:42:10: 'import' moduleId ( module )?
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal9=(CommonTree)match(input,42,FOLLOW_42_in_imprt109); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal9_tree = (CommonTree)adaptor.dupNode(string_literal9);

            adaptor.addChild(root_0, string_literal9_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_moduleId_in_imprt111);
            moduleId10=moduleId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, moduleId10.getTree());
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:42:28: ( module )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==40) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: module
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_module_in_imprt113);
                    module11=module();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, module11.getTree());

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
    // $ANTLR end "imprt"

    public static class site_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "site"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:47:1: site : 'site' mappings 'end' ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:47:5: ( 'site' mappings 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:47:9: 'site' mappings 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal12=(CommonTree)match(input,SITE,FOLLOW_SITE_in_site127); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal12_tree = (CommonTree)adaptor.dupNode(string_literal12);

            adaptor.addChild(root_0, string_literal12_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_mappings_in_site129);
            mappings13=mappings();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, mappings13.getTree());
            _last = (CommonTree)input.LT(1);
            string_literal14=(CommonTree)match(input,END,FOLLOW_END_in_site131); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:48:1: mappings : ( mapping )? ( ';' mapping )* ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:48:9: ( ( mapping )? ( ';' mapping )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:48:12: ( mapping )? ( ';' mapping )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:48:12: ( mapping )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==PATH) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: mapping
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_mapping_in_mappings139);
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

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:48:21: ( ';' mapping )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==SEMICOLON) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:48:23: ';' mapping
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal16=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_mappings144); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal16_tree = (CommonTree)adaptor.dupNode(char_literal16);

            	    adaptor.addChild(root_0, char_literal16_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_mapping_in_mappings146);
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
            	    break loop7;
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
        public int index = 0;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mapping"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:50:1: mapping returns [int index = 0] : PATH ':' markup ;
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

         retval.index = input.index(); 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:53:2: ( PATH ':' markup )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:53:5: PATH ':' markup
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PATH18=(CommonTree)match(input,PATH,FOLLOW_PATH_in_mapping171); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PATH18_tree = (CommonTree)adaptor.dupNode(PATH18);

            adaptor.addChild(root_0, PATH18_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal19=(CommonTree)match(input,43,FOLLOW_43_in_mapping173); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal19_tree = (CommonTree)adaptor.dupNode(char_literal19);

            adaptor.addChild(root_0, char_literal19_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_markup_in_mapping175);
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
             mappings.add(retval); 
        }
        return retval;
    }
    // $ANTLR end "mapping"

    public static class markup_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "markup"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:59:1: markup : ^( MARKUP IDCON . . ) ;
    public final WaebricLoader.markup_return markup() throws RecognitionException {
        WaebricLoader.markup_return retval = new WaebricLoader.markup_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MARKUP21=null;
        CommonTree IDCON22=null;
        CommonTree wildcard23=null;
        CommonTree wildcard24=null;

        CommonTree MARKUP21_tree=null;
        CommonTree IDCON22_tree=null;
        CommonTree wildcard23_tree=null;
        CommonTree wildcard24_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:59:7: ( ^( MARKUP IDCON . . ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:59:11: ^( MARKUP IDCON . . )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            MARKUP21=(CommonTree)match(input,MARKUP,FOLLOW_MARKUP_in_markup195); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MARKUP21_tree = (CommonTree)adaptor.dupNode(MARKUP21);

            root_1 = (CommonTree)adaptor.becomeRoot(MARKUP21_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            IDCON22=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_markup197); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON22_tree = (CommonTree)adaptor.dupNode(IDCON22);

            adaptor.addChild(root_1, IDCON22_tree);
            }
            _last = (CommonTree)input.LT(1);
            wildcard23=(CommonTree)input.LT(1);
            matchAny(input); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            wildcard23_tree = (CommonTree)adaptor.dupTree(wildcard23);
            adaptor.addChild(root_1, wildcard23_tree);
            }
            _last = (CommonTree)input.LT(1);
            wildcard24=(CommonTree)input.LT(1);
            matchAny(input); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            wildcard24_tree = (CommonTree)adaptor.dupTree(wildcard24);
            adaptor.addChild(root_1, wildcard24_tree);
            }

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
    // $ANTLR end "markup"

    public static class expression_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:64:1: expression : ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* ;
    public final WaebricLoader.expression_return expression() throws RecognitionException {
        WaebricLoader.expression_return retval = new WaebricLoader.expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON25=null;
        CommonTree NATCON26=null;
        CommonTree TEXT27=null;
        CommonTree SYMBOLCON28=null;
        CommonTree char_literal29=null;
        CommonTree char_literal31=null;
        CommonTree char_literal33=null;
        CommonTree char_literal34=null;
        CommonTree char_literal36=null;
        CommonTree char_literal38=null;
        CommonTree char_literal39=null;
        CommonTree char_literal41=null;
        CommonTree IDCON42=null;
        WaebricLoader.expression_return expression30 = null;

        WaebricLoader.expression_return expression32 = null;

        WaebricLoader.keyValuePair_return keyValuePair35 = null;

        WaebricLoader.keyValuePair_return keyValuePair37 = null;

        WaebricLoader.expression_return expression40 = null;


        CommonTree IDCON25_tree=null;
        CommonTree NATCON26_tree=null;
        CommonTree TEXT27_tree=null;
        CommonTree SYMBOLCON28_tree=null;
        CommonTree char_literal29_tree=null;
        CommonTree char_literal31_tree=null;
        CommonTree char_literal33_tree=null;
        CommonTree char_literal34_tree=null;
        CommonTree char_literal36_tree=null;
        CommonTree char_literal38_tree=null;
        CommonTree char_literal39_tree=null;
        CommonTree char_literal41_tree=null;
        CommonTree IDCON42_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:64:11: ( ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:64:14: ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:64:14: ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' )
            int alt12=6;
            switch ( input.LA(1) ) {
            case IDCON:
                {
                alt12=1;
                }
                break;
            case NATCON:
                {
                alt12=2;
                }
                break;
            case TEXT:
                {
                alt12=3;
                }
                break;
            case SYMBOLCON:
                {
                alt12=4;
                }
                break;
            case 52:
                {
                alt12=5;
                }
                break;
            case 54:
                {
                alt12=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:64:16: IDCON
                    {
                    _last = (CommonTree)input.LT(1);
                    IDCON25=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression217); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON25_tree = (CommonTree)adaptor.dupNode(IDCON25);

                    adaptor.addChild(root_0, IDCON25_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:64:24: NATCON
                    {
                    _last = (CommonTree)input.LT(1);
                    NATCON26=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_expression221); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON26_tree = (CommonTree)adaptor.dupNode(NATCON26);

                    adaptor.addChild(root_0, NATCON26_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:64:33: TEXT
                    {
                    _last = (CommonTree)input.LT(1);
                    TEXT27=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_expression225); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TEXT27_tree = (CommonTree)adaptor.dupNode(TEXT27);

                    adaptor.addChild(root_0, TEXT27_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:64:40: SYMBOLCON
                    {
                    _last = (CommonTree)input.LT(1);
                    SYMBOLCON28=(CommonTree)match(input,SYMBOLCON,FOLLOW_SYMBOLCON_in_expression229); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SYMBOLCON28_tree = (CommonTree)adaptor.dupNode(SYMBOLCON28);

                    adaptor.addChild(root_0, SYMBOLCON28_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:65:7: '[' ( expression )? ( ',' expression )* ']'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal29=(CommonTree)match(input,52,FOLLOW_52_in_expression238); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal29_tree = (CommonTree)adaptor.dupNode(char_literal29);

                    adaptor.addChild(root_0, char_literal29_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:65:11: ( expression )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==IDCON||(LA8_0>=NATCON && LA8_0<=SYMBOLCON)||LA8_0==52||LA8_0==54) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: expression
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_expression_in_expression240);
                            expression30=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, expression30.getTree());

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:65:23: ( ',' expression )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==49) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:65:25: ',' expression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal31=(CommonTree)match(input,49,FOLLOW_49_in_expression245); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal31_tree = (CommonTree)adaptor.dupNode(char_literal31);

                    	    adaptor.addChild(root_0, char_literal31_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_expression_in_expression247);
                    	    expression32=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, expression32.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal33=(CommonTree)match(input,53,FOLLOW_53_in_expression252); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal33_tree = (CommonTree)adaptor.dupNode(char_literal33);

                    adaptor.addChild(root_0, char_literal33_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:66:7: '{' ( keyValuePair )? ( ',' keyValuePair )* '}'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal34=(CommonTree)match(input,54,FOLLOW_54_in_expression261); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal34_tree = (CommonTree)adaptor.dupNode(char_literal34);

                    adaptor.addChild(root_0, char_literal34_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:66:11: ( keyValuePair )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==IDCON) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: keyValuePair
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_keyValuePair_in_expression263);
                            keyValuePair35=keyValuePair();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, keyValuePair35.getTree());

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:66:25: ( ',' keyValuePair )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==49) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:66:27: ',' keyValuePair
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal36=(CommonTree)match(input,49,FOLLOW_49_in_expression268); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal36_tree = (CommonTree)adaptor.dupNode(char_literal36);

                    	    adaptor.addChild(root_0, char_literal36_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_keyValuePair_in_expression270);
                    	    keyValuePair37=keyValuePair();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, keyValuePair37.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal38=(CommonTree)match(input,55,FOLLOW_55_in_expression275); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal38_tree = (CommonTree)adaptor.dupNode(char_literal38);

                    adaptor.addChild(root_0, char_literal38_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:67:6: ( '+' expression | '.' IDCON )*
            loop13:
            do {
                int alt13=3;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==56) ) {
                    int LA13_2 = input.LA(2);

                    if ( (synpred17_WaebricLoader()) ) {
                        alt13=1;
                    }


                }
                else if ( (LA13_0==41) ) {
                    int LA13_3 = input.LA(2);

                    if ( (synpred18_WaebricLoader()) ) {
                        alt13=2;
                    }


                }


                switch (alt13) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:67:8: '+' expression
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal39=(CommonTree)match(input,56,FOLLOW_56_in_expression285); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal39_tree = (CommonTree)adaptor.dupNode(char_literal39);

            	    adaptor.addChild(root_0, char_literal39_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expression_in_expression287);
            	    expression40=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, expression40.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:67:35: '.' IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal41=(CommonTree)match(input,41,FOLLOW_41_in_expression293); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal41_tree = (CommonTree)adaptor.dupNode(char_literal41);

            	    adaptor.addChild(root_0, char_literal41_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    IDCON42=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression295); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDCON42_tree = (CommonTree)adaptor.dupNode(IDCON42);

            	    adaptor.addChild(root_0, IDCON42_tree);
            	    }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop13;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:68:1: keyValuePair : IDCON ':' expression ;
    public final WaebricLoader.keyValuePair_return keyValuePair() throws RecognitionException {
        WaebricLoader.keyValuePair_return retval = new WaebricLoader.keyValuePair_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON43=null;
        CommonTree char_literal44=null;
        WaebricLoader.expression_return expression45 = null;


        CommonTree IDCON43_tree=null;
        CommonTree char_literal44_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:68:13: ( IDCON ':' expression )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:68:16: IDCON ':' expression
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON43=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_keyValuePair308); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON43_tree = (CommonTree)adaptor.dupNode(IDCON43);

            adaptor.addChild(root_0, IDCON43_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal44=(CommonTree)match(input,43,FOLLOW_43_in_keyValuePair310); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal44_tree = (CommonTree)adaptor.dupNode(char_literal44);

            adaptor.addChild(root_0, char_literal44_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_keyValuePair312);
            expression45=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, expression45.getTree());

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
        public int args = 0;
        public int index = 0;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:73:1: function returns [int args = 0, int index = 0] : ^( FUNCTION id= IDCON formals statements ) ;
    public final WaebricLoader.function_return function() throws RecognitionException {
        WaebricLoader.function_return retval = new WaebricLoader.function_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        CommonTree FUNCTION46=null;
        WaebricLoader.formals_return formals47 = null;

        WaebricLoader.statements_return statements48 = null;


        CommonTree id_tree=null;
        CommonTree FUNCTION46_tree=null;

         retval.index = input.index();
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:76:2: ( ^( FUNCTION id= IDCON formals statements ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:76:5: ^( FUNCTION id= IDCON formals statements )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNCTION46=(CommonTree)match(input,FUNCTION,FOLLOW_FUNCTION_in_function340); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FUNCTION46_tree = (CommonTree)adaptor.dupNode(FUNCTION46);

            root_1 = (CommonTree)adaptor.becomeRoot(FUNCTION46_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_function344); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (CommonTree)adaptor.dupNode(id);

            adaptor.addChild(root_1, id_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_formals_in_function350);
            formals47=formals();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, formals47.getTree());
            if ( state.backtracking==0 ) {
               retval.args = (formals47!=null?formals47.args:0); 
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statements_in_function357);
            statements48=statements();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, statements48.getTree());
            if ( state.backtracking==0 ) {
               if((statements48!=null?statements48.yield:false)) { yields.add(retval.index); } 
            }

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

            		if(functions.containsKey(id.getText())) {
            			exceptions.add(new WaebricChecker.DuplicateFunctionException(id));
            		} else { functions.put(id.getText(), retval); }
            	
        }
        return retval;
    }
    // $ANTLR end "function"

    public static class formals_return extends TreeRuleReturnScope {
        public int args = 0;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "formals"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:85:1: formals returns [int args = 0] : ^( FORMALS ( IDCON )* ) ;
    public final WaebricLoader.formals_return formals() throws RecognitionException {
        WaebricLoader.formals_return retval = new WaebricLoader.formals_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FORMALS49=null;
        CommonTree IDCON50=null;

        CommonTree FORMALS49_tree=null;
        CommonTree IDCON50_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:87:2: ( ^( FORMALS ( IDCON )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:87:5: ^( FORMALS ( IDCON )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FORMALS49=(CommonTree)match(input,FORMALS,FOLLOW_FORMALS_in_formals385); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FORMALS49_tree = (CommonTree)adaptor.dupNode(FORMALS49);

            root_1 = (CommonTree)adaptor.becomeRoot(FORMALS49_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:87:16: ( IDCON )*
                loop14:
                do {
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==IDCON) ) {
                        alt14=1;
                    }


                    switch (alt14) {
                	case 1 :
                	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:87:18: IDCON
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    IDCON50=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_formals389); if (state.failed) return retval;
                	    if ( state.backtracking==0 ) {
                	    IDCON50_tree = (CommonTree)adaptor.dupNode(IDCON50);

                	    adaptor.addChild(root_1, IDCON50_tree);
                	    }
                	    if ( state.backtracking==0 ) {
                	       retval.args++; 
                	    }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop14;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }adaptor.addChild(root_0, root_1);_last = _save_last_1;
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

    public static class statements_return extends TreeRuleReturnScope {
        public boolean yield = false;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statements"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:93:1: statements returns [boolean yield = false] : (s= statement )* ;
    public final WaebricLoader.statements_return statements() throws RecognitionException {
        WaebricLoader.statements_return retval = new WaebricLoader.statements_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricLoader.statement_return s = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:95:2: ( (s= statement )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:95:5: (s= statement )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:95:5: (s= statement )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==MARKUP_STATEMENT||LA15_0==COMMENT||LA15_0==54||LA15_0==57||(LA15_0>=59 && LA15_0<=60)||(LA15_0>=62 && LA15_0<=64)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:95:7: s= statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_statements419);
            	    s=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, s.getTree());
            	    if ( state.backtracking==0 ) {
            	       if((s!=null?s.yield:false)) { retval.yield = true; } 
            	    }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop15;
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
    // $ANTLR end "statements"

    public static class statement_return extends TreeRuleReturnScope {
        public boolean yield = false;;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:97:1: statement returns [boolean yield = false;] : ( ^( 'if' '(' predicate ')' t= statement ( 'else' f= statement )? ) | ^( 'each' '(' IDCON ':' expression ')' stm= statement ) | ^( 'let' ( assignment )+ 'in' stms= statements 'end' ) | ^( '{' stms= statements '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT markup markupChain ) );
    public final WaebricLoader.statement_return statement() throws RecognitionException {
        WaebricLoader.statement_return retval = new WaebricLoader.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal51=null;
        CommonTree char_literal52=null;
        CommonTree char_literal54=null;
        CommonTree string_literal55=null;
        CommonTree string_literal56=null;
        CommonTree char_literal57=null;
        CommonTree IDCON58=null;
        CommonTree char_literal59=null;
        CommonTree char_literal61=null;
        CommonTree string_literal62=null;
        CommonTree string_literal64=null;
        CommonTree string_literal65=null;
        CommonTree char_literal66=null;
        CommonTree char_literal67=null;
        CommonTree string_literal68=null;
        CommonTree STRCON69=null;
        CommonTree char_literal70=null;
        CommonTree string_literal71=null;
        CommonTree char_literal73=null;
        CommonTree string_literal74=null;
        CommonTree char_literal76=null;
        CommonTree string_literal77=null;
        CommonTree char_literal79=null;
        CommonTree string_literal80=null;
        CommonTree MARKUP_STATEMENT81=null;
        WaebricLoader.statement_return t = null;

        WaebricLoader.statement_return f = null;

        WaebricLoader.statement_return stm = null;

        WaebricLoader.statements_return stms = null;

        WaebricLoader.predicate_return predicate53 = null;

        WaebricLoader.expression_return expression60 = null;

        WaebricLoader.assignment_return assignment63 = null;

        WaebricLoader.expression_return expression72 = null;

        WaebricLoader.embedding_return embedding75 = null;

        WaebricLoader.expression_return expression78 = null;

        WaebricLoader.markup_return markup82 = null;

        WaebricLoader.markupChain_return markupChain83 = null;


        CommonTree string_literal51_tree=null;
        CommonTree char_literal52_tree=null;
        CommonTree char_literal54_tree=null;
        CommonTree string_literal55_tree=null;
        CommonTree string_literal56_tree=null;
        CommonTree char_literal57_tree=null;
        CommonTree IDCON58_tree=null;
        CommonTree char_literal59_tree=null;
        CommonTree char_literal61_tree=null;
        CommonTree string_literal62_tree=null;
        CommonTree string_literal64_tree=null;
        CommonTree string_literal65_tree=null;
        CommonTree char_literal66_tree=null;
        CommonTree char_literal67_tree=null;
        CommonTree string_literal68_tree=null;
        CommonTree STRCON69_tree=null;
        CommonTree char_literal70_tree=null;
        CommonTree string_literal71_tree=null;
        CommonTree char_literal73_tree=null;
        CommonTree string_literal74_tree=null;
        CommonTree char_literal76_tree=null;
        CommonTree string_literal77_tree=null;
        CommonTree char_literal79_tree=null;
        CommonTree string_literal80_tree=null;
        CommonTree MARKUP_STATEMENT81_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:99:2: ( ^( 'if' '(' predicate ')' t= statement ( 'else' f= statement )? ) | ^( 'each' '(' IDCON ':' expression ')' stm= statement ) | ^( 'let' ( assignment )+ 'in' stms= statements 'end' ) | ^( '{' stms= statements '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT markup markupChain ) )
            int alt18=10;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:99:5: ^( 'if' '(' predicate ')' t= statement ( 'else' f= statement )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal51=(CommonTree)match(input,57,FOLLOW_57_in_statement441); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal51_tree = (CommonTree)adaptor.dupNode(string_literal51);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal51_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    char_literal52=(CommonTree)match(input,48,FOLLOW_48_in_statement443); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal52_tree = (CommonTree)adaptor.dupNode(char_literal52);

                    adaptor.addChild(root_1, char_literal52_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_statement445);
                    predicate53=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, predicate53.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal54=(CommonTree)match(input,50,FOLLOW_50_in_statement447); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal54_tree = (CommonTree)adaptor.dupNode(char_literal54);

                    adaptor.addChild(root_1, char_literal54_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement451);
                    t=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, t.getTree());
                    if ( state.backtracking==0 ) {
                       if((t!=null?t.yield:false)) retval.yield = true; 
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:100:5: ( 'else' f= statement )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==58) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:100:7: 'else' f= statement
                            {
                            _last = (CommonTree)input.LT(1);
                            string_literal55=(CommonTree)match(input,58,FOLLOW_58_in_statement462); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal55_tree = (CommonTree)adaptor.dupNode(string_literal55);

                            adaptor.addChild(root_1, string_literal55_tree);
                            }
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_statement_in_statement466);
                            f=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, f.getTree());
                            if ( state.backtracking==0 ) {
                               if((f!=null?f.yield:false)) retval.yield = true; 
                            }

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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:101:6: ^( 'each' '(' IDCON ':' expression ')' stm= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal56=(CommonTree)match(input,59,FOLLOW_59_in_statement483); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal56_tree = (CommonTree)adaptor.dupNode(string_literal56);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal56_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    char_literal57=(CommonTree)match(input,48,FOLLOW_48_in_statement485); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal57_tree = (CommonTree)adaptor.dupNode(char_literal57);

                    adaptor.addChild(root_1, char_literal57_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON58=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_statement487); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON58_tree = (CommonTree)adaptor.dupNode(IDCON58);

                    adaptor.addChild(root_1, IDCON58_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal59=(CommonTree)match(input,43,FOLLOW_43_in_statement489); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal59_tree = (CommonTree)adaptor.dupNode(char_literal59);

                    adaptor.addChild(root_1, char_literal59_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement491);
                    expression60=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression60.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal61=(CommonTree)match(input,50,FOLLOW_50_in_statement493); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal61_tree = (CommonTree)adaptor.dupNode(char_literal61);

                    adaptor.addChild(root_1, char_literal61_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement497);
                    stm=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, stm.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                    if ( state.backtracking==0 ) {
                       retval.yield = (stm!=null?stm.yield:false); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:102:6: ^( 'let' ( assignment )+ 'in' stms= statements 'end' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal62=(CommonTree)match(input,60,FOLLOW_60_in_statement510); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal62_tree = (CommonTree)adaptor.dupNode(string_literal62);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal62_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:102:15: ( assignment )+
                    int cnt17=0;
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( ((LA17_0>=FUNCTION && LA17_0<=IDCON)) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: assignment
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_assignment_in_statement512);
                    	    assignment63=assignment();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, assignment63.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt17 >= 1 ) break loop17;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(17, input);
                                throw eee;
                        }
                        cnt17++;
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    string_literal64=(CommonTree)match(input,61,FOLLOW_61_in_statement515); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal64_tree = (CommonTree)adaptor.dupNode(string_literal64);

                    adaptor.addChild(root_1, string_literal64_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statements_in_statement519);
                    stms=statements();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, stms.getTree());
                    _last = (CommonTree)input.LT(1);
                    string_literal65=(CommonTree)match(input,END,FOLLOW_END_in_statement521); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal65_tree = (CommonTree)adaptor.dupNode(string_literal65);

                    adaptor.addChild(root_1, string_literal65_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                    if ( state.backtracking==0 ) {
                       retval.yield = (stms!=null?stms.yield:false); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:103:6: ^( '{' stms= statements '}' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal66=(CommonTree)match(input,54,FOLLOW_54_in_statement534); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal66_tree = (CommonTree)adaptor.dupNode(char_literal66);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal66_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_statements_in_statement538);
                        stms=statements();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, stms.getTree());
                        _last = (CommonTree)input.LT(1);
                        char_literal67=(CommonTree)match(input,55,FOLLOW_55_in_statement540); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        char_literal67_tree = (CommonTree)adaptor.dupNode(char_literal67);

                        adaptor.addChild(root_1, char_literal67_tree);
                        }

                        match(input, Token.UP, null); if (state.failed) return retval;
                    }adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                    if ( state.backtracking==0 ) {
                       retval.yield = (stms!=null?stms.yield:false); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:104:6: ^( 'comment' STRCON ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal68=(CommonTree)match(input,COMMENT,FOLLOW_COMMENT_in_statement553); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal68_tree = (CommonTree)adaptor.dupNode(string_literal68);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal68_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    STRCON69=(CommonTree)match(input,STRCON,FOLLOW_STRCON_in_statement555); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRCON69_tree = (CommonTree)adaptor.dupNode(STRCON69);

                    adaptor.addChild(root_1, STRCON69_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal70=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement557); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal70_tree = (CommonTree)adaptor.dupNode(char_literal70);

                    adaptor.addChild(root_1, char_literal70_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:105:6: ^( 'echo' expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal71=(CommonTree)match(input,62,FOLLOW_62_in_statement568); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal71_tree = (CommonTree)adaptor.dupNode(string_literal71);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal71_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement570);
                    expression72=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression72.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal73=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement572); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal73_tree = (CommonTree)adaptor.dupNode(char_literal73);

                    adaptor.addChild(root_1, char_literal73_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:106:6: ^( 'echo' embedding ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal74=(CommonTree)match(input,62,FOLLOW_62_in_statement583); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal74_tree = (CommonTree)adaptor.dupNode(string_literal74);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal74_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement585);
                    embedding75=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding75.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal76=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement587); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal76_tree = (CommonTree)adaptor.dupNode(char_literal76);

                    adaptor.addChild(root_1, char_literal76_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:107:6: ^( 'cdata' expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal77=(CommonTree)match(input,63,FOLLOW_63_in_statement598); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal77_tree = (CommonTree)adaptor.dupNode(string_literal77);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal77_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement600);
                    expression78=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression78.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal79=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement602); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal79_tree = (CommonTree)adaptor.dupNode(char_literal79);

                    adaptor.addChild(root_1, char_literal79_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:108:6: 'yield;'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal80=(CommonTree)match(input,64,FOLLOW_64_in_statement611); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal80_tree = (CommonTree)adaptor.dupNode(string_literal80);

                    adaptor.addChild(root_0, string_literal80_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.yield = true; 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:109:6: ^( MARKUP_STATEMENT markup markupChain )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT81=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement622); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT81_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT81);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT81_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_statement624);
                    markup82=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, markup82.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markupChain_in_statement626);
                    markupChain83=markupChain();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, markupChain83.getTree());
                    if ( state.backtracking==0 ) {
                       retval.yield = (markupChain83!=null?markupChain83.yield:false); 
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

    public static class markupChain_return extends TreeRuleReturnScope {
        public boolean yield = false;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "markupChain"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:111:1: markupChain returns [boolean yield = false] : ( ^( MARKUP_CHAIN markup c= markupChain ) | ^( MARKUP_CHAIN expression ';' ) | ^( MARKUP_CHAIN s= statement ) | ^( MARKUP_CHAIN embedding ';' ) | ^( MARKUP_CHAIN ';' ) );
    public final WaebricLoader.markupChain_return markupChain() throws RecognitionException {
        WaebricLoader.markupChain_return retval = new WaebricLoader.markupChain_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MARKUP_CHAIN84=null;
        CommonTree MARKUP_CHAIN86=null;
        CommonTree char_literal88=null;
        CommonTree MARKUP_CHAIN89=null;
        CommonTree MARKUP_CHAIN90=null;
        CommonTree char_literal92=null;
        CommonTree MARKUP_CHAIN93=null;
        CommonTree char_literal94=null;
        WaebricLoader.markupChain_return c = null;

        WaebricLoader.statement_return s = null;

        WaebricLoader.markup_return markup85 = null;

        WaebricLoader.expression_return expression87 = null;

        WaebricLoader.embedding_return embedding91 = null;


        CommonTree MARKUP_CHAIN84_tree=null;
        CommonTree MARKUP_CHAIN86_tree=null;
        CommonTree char_literal88_tree=null;
        CommonTree MARKUP_CHAIN89_tree=null;
        CommonTree MARKUP_CHAIN90_tree=null;
        CommonTree char_literal92_tree=null;
        CommonTree MARKUP_CHAIN93_tree=null;
        CommonTree char_literal94_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:113:2: ( ^( MARKUP_CHAIN markup c= markupChain ) | ^( MARKUP_CHAIN expression ';' ) | ^( MARKUP_CHAIN s= statement ) | ^( MARKUP_CHAIN embedding ';' ) | ^( MARKUP_CHAIN ';' ) )
            int alt19=5;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==MARKUP_CHAIN) ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==DOWN) ) {
                    switch ( input.LA(3) ) {
                    case SEMICOLON:
                        {
                        alt19=5;
                        }
                        break;
                    case PRETEXT:
                        {
                        alt19=4;
                        }
                        break;
                    case IDCON:
                    case NATCON:
                    case TEXT:
                    case SYMBOLCON:
                    case 52:
                        {
                        alt19=2;
                        }
                        break;
                    case 54:
                        {
                        int LA19_6 = input.LA(4);

                        if ( (LA19_6==DOWN) ) {
                            alt19=3;
                        }
                        else if ( (LA19_6==IDCON||LA19_6==49||LA19_6==55) ) {
                            alt19=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 19, 6, input);

                            throw nvae;
                        }
                        }
                        break;
                    case MARKUP:
                        {
                        alt19=1;
                        }
                        break;
                    case MARKUP_STATEMENT:
                    case COMMENT:
                    case 57:
                    case 59:
                    case 60:
                    case 62:
                    case 63:
                    case 64:
                        {
                        alt19=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 2, input);

                        throw nvae;
                    }

                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:113:5: ^( MARKUP_CHAIN markup c= markupChain )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_CHAIN84=(CommonTree)match(input,MARKUP_CHAIN,FOLLOW_MARKUP_CHAIN_in_markupChain648); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_CHAIN84_tree = (CommonTree)adaptor.dupNode(MARKUP_CHAIN84);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_CHAIN84_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_markupChain650);
                    markup85=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, markup85.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markupChain_in_markupChain654);
                    c=markupChain();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, c.getTree());
                    if ( state.backtracking==0 ) {
                       retval.yield = (c!=null?c.yield:false); 
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:114:6: ^( MARKUP_CHAIN expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_CHAIN86=(CommonTree)match(input,MARKUP_CHAIN,FOLLOW_MARKUP_CHAIN_in_markupChain667); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_CHAIN86_tree = (CommonTree)adaptor.dupNode(MARKUP_CHAIN86);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_CHAIN86_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_markupChain669);
                    expression87=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression87.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal88=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_markupChain671); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal88_tree = (CommonTree)adaptor.dupNode(char_literal88);

                    adaptor.addChild(root_1, char_literal88_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:115:6: ^( MARKUP_CHAIN s= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_CHAIN89=(CommonTree)match(input,MARKUP_CHAIN,FOLLOW_MARKUP_CHAIN_in_markupChain682); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_CHAIN89_tree = (CommonTree)adaptor.dupNode(MARKUP_CHAIN89);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_CHAIN89_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_markupChain686);
                    s=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, s.getTree());
                    if ( state.backtracking==0 ) {
                       retval.yield = (s!=null?s.yield:false); 
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:116:6: ^( MARKUP_CHAIN embedding ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_CHAIN90=(CommonTree)match(input,MARKUP_CHAIN,FOLLOW_MARKUP_CHAIN_in_markupChain699); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_CHAIN90_tree = (CommonTree)adaptor.dupNode(MARKUP_CHAIN90);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_CHAIN90_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_markupChain701);
                    embedding91=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding91.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal92=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_markupChain703); if (state.failed) return retval;
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
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:117:6: ^( MARKUP_CHAIN ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_CHAIN93=(CommonTree)match(input,MARKUP_CHAIN,FOLLOW_MARKUP_CHAIN_in_markupChain714); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_CHAIN93_tree = (CommonTree)adaptor.dupNode(MARKUP_CHAIN93);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_CHAIN93_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    char_literal94=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_markupChain716); if (state.failed) return retval;
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
    // $ANTLR end "markupChain"

    public static class assignment_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignment"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:122:1: assignment : ( IDCON '=' expression ';' | ^( FUNCTION IDCON formals statement ) );
    public final WaebricLoader.assignment_return assignment() throws RecognitionException {
        WaebricLoader.assignment_return retval = new WaebricLoader.assignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON95=null;
        CommonTree char_literal96=null;
        CommonTree char_literal98=null;
        CommonTree FUNCTION99=null;
        CommonTree IDCON100=null;
        WaebricLoader.expression_return expression97 = null;

        WaebricLoader.formals_return formals101 = null;

        WaebricLoader.statement_return statement102 = null;


        CommonTree IDCON95_tree=null;
        CommonTree char_literal96_tree=null;
        CommonTree char_literal98_tree=null;
        CommonTree FUNCTION99_tree=null;
        CommonTree IDCON100_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:122:11: ( IDCON '=' expression ';' | ^( FUNCTION IDCON formals statement ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==IDCON) ) {
                alt20=1;
            }
            else if ( (LA20_0==FUNCTION) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:122:14: IDCON '=' expression ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDCON95=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_assignment733); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON95_tree = (CommonTree)adaptor.dupNode(IDCON95);

                    adaptor.addChild(root_0, IDCON95_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal96=(CommonTree)match(input,51,FOLLOW_51_in_assignment735); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal96_tree = (CommonTree)adaptor.dupNode(char_literal96);

                    adaptor.addChild(root_0, char_literal96_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_assignment737);
                    expression97=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression97.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal98=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_assignment739); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal98_tree = (CommonTree)adaptor.dupNode(char_literal98);

                    adaptor.addChild(root_0, char_literal98_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:123:6: ^( FUNCTION IDCON formals statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    FUNCTION99=(CommonTree)match(input,FUNCTION,FOLLOW_FUNCTION_in_assignment749); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNCTION99_tree = (CommonTree)adaptor.dupNode(FUNCTION99);

                    root_1 = (CommonTree)adaptor.becomeRoot(FUNCTION99_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDCON100=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_assignment751); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON100_tree = (CommonTree)adaptor.dupNode(IDCON100);

                    adaptor.addChild(root_1, IDCON100_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_formals_in_assignment753);
                    formals101=formals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, formals101.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_assignment755);
                    statement102=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement102.getTree());

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
    // $ANTLR end "assignment"

    public static class predicate_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "predicate"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:128:1: predicate : ( '!' predicate | expression | expression '.' type '?' ) ( '&&' predicate | '||' predicate )* ;
    public final WaebricLoader.predicate_return predicate() throws RecognitionException {
        WaebricLoader.predicate_return retval = new WaebricLoader.predicate_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal103=null;
        CommonTree char_literal107=null;
        CommonTree char_literal109=null;
        CommonTree string_literal110=null;
        CommonTree string_literal112=null;
        WaebricLoader.predicate_return predicate104 = null;

        WaebricLoader.expression_return expression105 = null;

        WaebricLoader.expression_return expression106 = null;

        WaebricLoader.type_return type108 = null;

        WaebricLoader.predicate_return predicate111 = null;

        WaebricLoader.predicate_return predicate113 = null;


        CommonTree char_literal103_tree=null;
        CommonTree char_literal107_tree=null;
        CommonTree char_literal109_tree=null;
        CommonTree string_literal110_tree=null;
        CommonTree string_literal112_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:128:10: ( ( '!' predicate | expression | expression '.' type '?' ) ( '&&' predicate | '||' predicate )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:128:13: ( '!' predicate | expression | expression '.' type '?' ) ( '&&' predicate | '||' predicate )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:128:13: ( '!' predicate | expression | expression '.' type '?' )
            int alt21=3;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:128:15: '!' predicate
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal103=(CommonTree)match(input,65,FOLLOW_65_in_predicate772); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal103_tree = (CommonTree)adaptor.dupNode(char_literal103);

                    adaptor.addChild(root_0, char_literal103_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_predicate774);
                    predicate104=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, predicate104.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:129:7: expression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate783);
                    expression105=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression105.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:130:7: expression '.' type '?'
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate792);
                    expression106=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression106.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal107=(CommonTree)match(input,41,FOLLOW_41_in_predicate794); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal107_tree = (CommonTree)adaptor.dupNode(char_literal107);

                    adaptor.addChild(root_0, char_literal107_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_predicate796);
                    type108=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, type108.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal109=(CommonTree)match(input,66,FOLLOW_66_in_predicate798); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal109_tree = (CommonTree)adaptor.dupNode(char_literal109);

                    adaptor.addChild(root_0, char_literal109_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:131:6: ( '&&' predicate | '||' predicate )*
            loop22:
            do {
                int alt22=3;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==67) ) {
                    int LA22_2 = input.LA(2);

                    if ( (synpred39_WaebricLoader()) ) {
                        alt22=1;
                    }


                }
                else if ( (LA22_0==68) ) {
                    int LA22_3 = input.LA(2);

                    if ( (synpred40_WaebricLoader()) ) {
                        alt22=2;
                    }


                }


                switch (alt22) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:131:8: '&&' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal110=(CommonTree)match(input,67,FOLLOW_67_in_predicate808); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal110_tree = (CommonTree)adaptor.dupNode(string_literal110);

            	    adaptor.addChild(root_0, string_literal110_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate810);
            	    predicate111=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, predicate111.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:131:25: '||' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal112=(CommonTree)match(input,68,FOLLOW_68_in_predicate814); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal112_tree = (CommonTree)adaptor.dupNode(string_literal112);

            	    adaptor.addChild(root_0, string_literal112_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate816);
            	    predicate113=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, predicate113.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop22;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:132:1: type : ( 'list' | 'record' | 'string' );
    public final WaebricLoader.type_return type() throws RecognitionException {
        WaebricLoader.type_return retval = new WaebricLoader.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set114=null;

        CommonTree set114_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:132:5: ( 'list' | 'record' | 'string' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            set114=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=69 && input.LA(1)<=71) ) {
                input.consume();

                if ( state.backtracking==0 ) {
                set114_tree = (CommonTree)adaptor.dupNode(set114);

                adaptor.addChild(root_0, set114_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:137:1: embedding : PRETEXT embed textTail ;
    public final WaebricLoader.embedding_return embedding() throws RecognitionException {
        WaebricLoader.embedding_return retval = new WaebricLoader.embedding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PRETEXT115=null;
        WaebricLoader.embed_return embed116 = null;

        WaebricLoader.textTail_return textTail117 = null;


        CommonTree PRETEXT115_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:137:10: ( PRETEXT embed textTail )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:137:13: PRETEXT embed textTail
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PRETEXT115=(CommonTree)match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding848); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRETEXT115_tree = (CommonTree)adaptor.dupNode(PRETEXT115);

            adaptor.addChild(root_0, PRETEXT115_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_embed_in_embedding850);
            embed116=embed();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, embed116.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_textTail_in_embedding852);
            textTail117=textTail();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, textTail117.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:138:1: embed : ( ( markup )* expression | ( markup )* markup );
    public final WaebricLoader.embed_return embed() throws RecognitionException {
        WaebricLoader.embed_return retval = new WaebricLoader.embed_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricLoader.markup_return markup118 = null;

        WaebricLoader.expression_return expression119 = null;

        WaebricLoader.markup_return markup120 = null;

        WaebricLoader.markup_return markup121 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:138:6: ( ( markup )* expression | ( markup )* markup )
            int alt25=2;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:138:10: ( markup )* expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:138:10: ( markup )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==MARKUP) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed861);
                    	    markup118=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup118.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_embed864);
                    expression119=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression119.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:138:31: ( markup )* markup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:138:31: ( markup )*
                    loop24:
                    do {
                        int alt24=2;
                        alt24 = dfa24.predict(input);
                        switch (alt24) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed868);
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
                    	    break loop24;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_embed871);
                    markup121=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, markup121.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:139:1: textTail : ( POSTTEXT | MIDTEXT embed textTail );
    public final WaebricLoader.textTail_return textTail() throws RecognitionException {
        WaebricLoader.textTail_return retval = new WaebricLoader.textTail_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POSTTEXT122=null;
        CommonTree MIDTEXT123=null;
        WaebricLoader.embed_return embed124 = null;

        WaebricLoader.textTail_return textTail125 = null;


        CommonTree POSTTEXT122_tree=null;
        CommonTree MIDTEXT123_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:139:9: ( POSTTEXT | MIDTEXT embed textTail )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==POSTTEXT) ) {
                alt26=1;
            }
            else if ( (LA26_0==MIDTEXT) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:139:12: POSTTEXT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    POSTTEXT122=(CommonTree)match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail879); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    POSTTEXT122_tree = (CommonTree)adaptor.dupNode(POSTTEXT122);

                    adaptor.addChild(root_0, POSTTEXT122_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:139:23: MIDTEXT embed textTail
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    MIDTEXT123=(CommonTree)match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail883); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MIDTEXT123_tree = (CommonTree)adaptor.dupNode(MIDTEXT123);

                    adaptor.addChild(root_0, MIDTEXT123_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embed_in_textTail885);
                    embed124=embed();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, embed124.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_textTail_in_textTail887);
                    textTail125=textTail();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, textTail125.getTree());

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

    // $ANTLR start synpred17_WaebricLoader
    public final void synpred17_WaebricLoader_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:67:8: ( '+' expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:67:8: '+' expression
        {
        match(input,56,FOLLOW_56_in_synpred17_WaebricLoader285); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred17_WaebricLoader287);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_WaebricLoader

    // $ANTLR start synpred18_WaebricLoader
    public final void synpred18_WaebricLoader_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:67:35: ( '.' IDCON )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:67:35: '.' IDCON
        {
        match(input,41,FOLLOW_41_in_synpred18_WaebricLoader293); if (state.failed) return ;
        match(input,IDCON,FOLLOW_IDCON_in_synpred18_WaebricLoader295); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_WaebricLoader

    // $ANTLR start synpred38_WaebricLoader
    public final void synpred38_WaebricLoader_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:129:7: ( expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:129:7: expression
        {
        pushFollow(FOLLOW_expression_in_synpred38_WaebricLoader783);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred38_WaebricLoader

    // $ANTLR start synpred39_WaebricLoader
    public final void synpred39_WaebricLoader_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:131:8: ( '&&' predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:131:8: '&&' predicate
        {
        match(input,67,FOLLOW_67_in_synpred39_WaebricLoader808); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred39_WaebricLoader810);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_WaebricLoader

    // $ANTLR start synpred40_WaebricLoader
    public final void synpred40_WaebricLoader_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:131:25: ( '||' predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:131:25: '||' predicate
        {
        match(input,68,FOLLOW_68_in_synpred40_WaebricLoader814); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred40_WaebricLoader816);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred40_WaebricLoader

    // Delegated rules

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
    public final boolean synpred18_WaebricLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_WaebricLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred38_WaebricLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_WaebricLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_WaebricLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_WaebricLoader_fragment(); // can never throw exception
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


    protected DFA18 dfa18 = new DFA18(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA24 dfa24 = new DFA24(this);
    static final String DFA18_eotS =
        "\15\uffff";
    static final String DFA18_eofS =
        "\15\uffff";
    static final String DFA18_minS =
        "\1\7\5\uffff\1\2\3\uffff\1\13\2\uffff";
    static final String DFA18_maxS =
        "\1\100\5\uffff\1\2\3\uffff\1\66\2\uffff";
    static final String DFA18_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\11\1\12\1\uffff\1\7"+
        "\1\6";
    static final String DFA18_specialS =
        "\15\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\11\14\uffff\1\5\41\uffff\1\4\2\uffff\1\1\1\uffff\1\2\1\3"+
            "\1\uffff\1\6\1\7\1\10",
            "",
            "",
            "",
            "",
            "",
            "\1\12",
            "",
            "",
            "",
            "\1\14\1\uffff\3\14\1\uffff\1\13\42\uffff\1\14\1\uffff\1\14",
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
            return "97:1: statement returns [boolean yield = false;] : ( ^( 'if' '(' predicate ')' t= statement ( 'else' f= statement )? ) | ^( 'each' '(' IDCON ':' expression ')' stm= statement ) | ^( 'let' ( assignment )+ 'in' stms= statements 'end' ) | ^( '{' stms= statements '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT markup markupChain ) );";
        }
    }
    static final String DFA21_eotS =
        "\12\uffff";
    static final String DFA21_eofS =
        "\12\uffff";
    static final String DFA21_minS =
        "\1\13\1\uffff\6\0\2\uffff";
    static final String DFA21_maxS =
        "\1\101\1\uffff\6\0\2\uffff";
    static final String DFA21_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\1\3";
    static final String DFA21_specialS =
        "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\2\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\2\1\uffff\1\3\1\4\1\5\44\uffff\1\6\1\uffff\1\7\12\uffff\1"+
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
            return "128:13: ( '!' predicate | expression | expression '.' type '?' )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TreeNodeStream input = (TreeNodeStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA21_2 = input.LA(1);

                         
                        int index21_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_WaebricLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index21_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA21_3 = input.LA(1);

                         
                        int index21_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_WaebricLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index21_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA21_4 = input.LA(1);

                         
                        int index21_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_WaebricLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index21_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA21_5 = input.LA(1);

                         
                        int index21_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_WaebricLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index21_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA21_6 = input.LA(1);

                         
                        int index21_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_WaebricLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index21_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA21_7 = input.LA(1);

                         
                        int index21_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_WaebricLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index21_7);
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
    static final String DFA25_eotS =
        "\17\uffff";
    static final String DFA25_eofS =
        "\17\uffff";
    static final String DFA25_minS =
        "\1\6\1\2\1\uffff\1\13\1\4\1\2\1\4\1\2\1\3\1\6\2\4\1\uffff\2\3";
    static final String DFA25_maxS =
        "\1\66\1\2\1\uffff\1\13\3\107\1\3\1\107\1\66\2\107\1\uffff\1\107"+
        "\1\3";
    static final String DFA25_acceptS =
        "\2\uffff\1\1\11\uffff\1\2\2\uffff";
    static final String DFA25_specialS =
        "\17\uffff}>";
    static final String[] DFA25_transitionS = {
            "\1\1\4\uffff\1\2\1\uffff\3\2\44\uffff\1\2\1\uffff\1\2",
            "\1\3",
            "",
            "\1\4",
            "\104\5",
            "\1\6\1\uffff\104\7",
            "\104\10",
            "\1\12\1\11",
            "\1\13\104\10",
            "\1\1\4\uffff\1\2\1\uffff\3\2\2\uffff\2\14\40\uffff\1\2\1\uffff"+
            "\1\2",
            "\104\15",
            "\104\7",
            "",
            "\1\16\104\15",
            "\1\11"
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
            return "138:1: embed : ( ( markup )* expression | ( markup )* markup );";
        }
    }
    static final String DFA24_eotS =
        "\17\uffff";
    static final String DFA24_eofS =
        "\17\uffff";
    static final String DFA24_minS =
        "\1\6\1\2\1\13\1\4\1\2\1\4\1\2\1\3\1\6\2\4\2\uffff\2\3";
    static final String DFA24_maxS =
        "\1\6\1\2\1\13\3\107\1\3\1\107\1\23\2\107\2\uffff\1\107\1\3";
    static final String DFA24_acceptS =
        "\13\uffff\1\1\1\2\2\uffff";
    static final String DFA24_specialS =
        "\17\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\104\4",
            "\1\5\1\uffff\104\6",
            "\104\7",
            "\1\11\1\10",
            "\1\12\104\7",
            "\1\13\13\uffff\2\14",
            "\104\15",
            "\104\6",
            "",
            "",
            "\1\16\104\15",
            "\1\10"
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
            return "()* loopback of 138:31: ( markup )*";
        }
    }
 

    public static final BitSet FOLLOW_40_in_module65 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_moduleId_in_module67 = new BitSet(new long[]{0x0000040000200408L});
    public static final BitSet FOLLOW_imprt_in_module69 = new BitSet(new long[]{0x0000040000200408L});
    public static final BitSet FOLLOW_site_in_module72 = new BitSet(new long[]{0x0000000000200408L});
    public static final BitSet FOLLOW_function_in_module75 = new BitSet(new long[]{0x0000000000000408L});
    public static final BitSet FOLLOW_IDCON_in_moduleId90 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_moduleId94 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDCON_in_moduleId96 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_42_in_imprt109 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_moduleId_in_imprt111 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_module_in_imprt113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SITE_in_site127 = new BitSet(new long[]{0x0000000000C01000L});
    public static final BitSet FOLLOW_mappings_in_site129 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_END_in_site131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapping_in_mappings139 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_SEMICOLON_in_mappings144 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_mapping_in_mappings146 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_PATH_in_mapping171 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_mapping173 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_markup_in_mapping175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUP_in_markup195 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_markup197 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x00000000000000FFL});
    public static final BitSet FOLLOW_IDCON_in_expression217 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_NATCON_in_expression221 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_TEXT_in_expression225 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_SYMBOLCON_in_expression229 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_52_in_expression238 = new BitSet(new long[]{0x007200000000E800L});
    public static final BitSet FOLLOW_expression_in_expression240 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_49_in_expression245 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_expression247 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_53_in_expression252 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_54_in_expression261 = new BitSet(new long[]{0x0082000000000800L});
    public static final BitSet FOLLOW_keyValuePair_in_expression263 = new BitSet(new long[]{0x0082000000000000L});
    public static final BitSet FOLLOW_49_in_expression268 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_keyValuePair_in_expression270 = new BitSet(new long[]{0x0082000000000000L});
    public static final BitSet FOLLOW_55_in_expression275 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_56_in_expression285 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_expression287 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_41_in_expression293 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDCON_in_expression295 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_IDCON_in_keyValuePair308 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_keyValuePair310 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_keyValuePair312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_function340 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_function344 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_formals_in_function350 = new BitSet(new long[]{0xDA40000000100088L,0x0000000000000001L});
    public static final BitSet FOLLOW_statements_in_function357 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FORMALS_in_formals385 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_formals389 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_statement_in_statements419 = new BitSet(new long[]{0xDA40000000100082L,0x0000000000000001L});
    public static final BitSet FOLLOW_57_in_statement441 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_48_in_statement443 = new BitSet(new long[]{0x005000000000E800L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_statement445 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_statement447 = new BitSet(new long[]{0xDA40000000100080L,0x0000000000000001L});
    public static final BitSet FOLLOW_statement_in_statement451 = new BitSet(new long[]{0x0400000000000008L});
    public static final BitSet FOLLOW_58_in_statement462 = new BitSet(new long[]{0xDA40000000100080L,0x0000000000000001L});
    public static final BitSet FOLLOW_statement_in_statement466 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_59_in_statement483 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_48_in_statement485 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDCON_in_statement487 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_statement489 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_statement491 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_statement493 = new BitSet(new long[]{0xDA40000000100080L,0x0000000000000001L});
    public static final BitSet FOLLOW_statement_in_statement497 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_60_in_statement510 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_assignment_in_statement512 = new BitSet(new long[]{0x2000000000000C00L});
    public static final BitSet FOLLOW_61_in_statement515 = new BitSet(new long[]{0xDA40000000500080L,0x0000000000000001L});
    public static final BitSet FOLLOW_statements_in_statement519 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_END_in_statement521 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_54_in_statement534 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statements_in_statement538 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_statement540 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COMMENT_in_statement553 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRCON_in_statement555 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement557 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_62_in_statement568 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement570 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement572 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_62_in_statement583 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_statement585 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement587 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_63_in_statement598 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement600 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement602 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_64_in_statement611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement622 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement624 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_markupChain_in_statement626 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_CHAIN_in_markupChain648 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_markupChain650 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_markupChain_in_markupChain654 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_CHAIN_in_markupChain667 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_markupChain669 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_markupChain671 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_CHAIN_in_markupChain682 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_markupChain686 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_CHAIN_in_markupChain699 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_markupChain701 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_markupChain703 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_CHAIN_in_markupChain714 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SEMICOLON_in_markupChain716 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDCON_in_assignment733 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_assignment735 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_assignment737 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_assignment739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_assignment749 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_assignment751 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_formals_in_assignment753 = new BitSet(new long[]{0xDA40000000100080L,0x0000000000000001L});
    public static final BitSet FOLLOW_statement_in_assignment755 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_65_in_predicate772 = new BitSet(new long[]{0x005000000000E800L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_predicate774 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_expression_in_predicate783 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_expression_in_predicate792 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_predicate794 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_type_in_predicate796 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_predicate798 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_67_in_predicate808 = new BitSet(new long[]{0x005000000000E800L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_predicate810 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_68_in_predicate814 = new BitSet(new long[]{0x005000000000E800L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_predicate816 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding848 = new BitSet(new long[]{0x005000000000E840L});
    public static final BitSet FOLLOW_embed_in_embedding850 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_textTail_in_embedding852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed861 = new BitSet(new long[]{0x005000000000E840L});
    public static final BitSet FOLLOW_expression_in_embed864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed868 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_markup_in_embed871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail883 = new BitSet(new long[]{0x005000000000E840L});
    public static final BitSet FOLLOW_embed_in_textTail885 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_textTail_in_textTail887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred17_WaebricLoader285 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_synpred17_WaebricLoader287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_synpred18_WaebricLoader293 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDCON_in_synpred18_WaebricLoader295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred38_WaebricLoader783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_synpred39_WaebricLoader808 = new BitSet(new long[]{0x005000000000E800L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_synpred39_WaebricLoader810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_synpred40_WaebricLoader814 = new BitSet(new long[]{0x005000000000E800L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_synpred40_WaebricLoader816 = new BitSet(new long[]{0x0000000000000002L});

}