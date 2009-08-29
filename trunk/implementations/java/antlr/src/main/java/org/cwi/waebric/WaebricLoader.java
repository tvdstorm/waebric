// $ANTLR 3.1.2 /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g 2009-08-29 16:49:44

	package org.cwi.waebric;
	import antlr.SemanticException;
	import java.util.Map;
	import java.util.HashMap;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


public class WaebricLoader extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATTRIBUTES", "ARGUMENTS", "MARKUP", "MARKUPS", "MARKUP_STATEMENT", "MARKUP_EXPRESSION", "MARKUP_EMBEDDING", "FORMALS", "IDCON", "PATH", "NATCON", "TEXT", "SYMBOLCON", "STRCON", "PRETEXT", "POSTTEXT", "MIDTEXT", "COMMENT", "SITE", "END", "SEMICOLON", "LETTER", "DIGIT", "HEXADECIMAL", "PATHELEMENT", "FILEEXT", "STRCHAR", "ESCLAYOUT", "DECIMAL", "TEXTCHAR", "ESCQUOTE", "AMP", "CHARREF", "ENTREF", "SYMBOLCHAR", "COMMENTS", "LAYOUT", "'module'", "'.'", "'import'", "':'", "'#'", "'$'", "'@'", "'%'", "'('", "','", "')'", "'='", "'['", "']'", "'{'", "'}'", "'+'", "'def'", "'if'", "'else'", "'each'", "'let'", "'in'", "'yield'", "'echo'", "'cdata'", "'!'", "'?'", "'&&'", "'||'", "'list'", "'record'", "'string'"
    };
    public static final int ESCLAYOUT=31;
    public static final int T__42=42;
    public static final int END=23;
    public static final int T__57=57;
    public static final int T__51=51;
    public static final int FILEEXT=29;
    public static final int T__69=69;
    public static final int T__47=47;
    public static final int T__73=73;
    public static final int T__50=50;
    public static final int STRCHAR=30;
    public static final int T__65=65;
    public static final int SYMBOLCON=16;
    public static final int T__72=72;
    public static final int COMMENTS=39;
    public static final int DECIMAL=32;
    public static final int IDCON=12;
    public static final int MARKUP_EXPRESSION=9;
    public static final int T__70=70;
    public static final int T__67=67;
    public static final int HEXADECIMAL=27;
    public static final int TEXTCHAR=33;
    public static final int T__52=52;
    public static final int T__46=46;
    public static final int T__68=68;
    public static final int T__62=62;
    public static final int MARKUPS=7;
    public static final int MARKUP=6;
    public static final int STRCON=17;
    public static final int T__49=49;
    public static final int AMP=35;
    public static final int T__61=61;
    public static final int POSTTEXT=19;
    public static final int T__59=59;
    public static final int ATTRIBUTES=4;
    public static final int DIGIT=26;
    public static final int T__54=54;
    public static final int T__48=48;
    public static final int LAYOUT=40;
    public static final int ESCQUOTE=34;
    public static final int T__56=56;
    public static final int PATHELEMENT=28;
    public static final int ENTREF=37;
    public static final int LETTER=25;
    public static final int ARGUMENTS=5;
    public static final int SITE=22;
    public static final int T__58=58;
    public static final int T__64=64;
    public static final int T__44=44;
    public static final int T__66=66;
    public static final int SYMBOLCHAR=38;
    public static final int COMMENT=21;
    public static final int MARKUP_STATEMENT=8;
    public static final int FORMALS=11;
    public static final int T__45=45;
    public static final int T__55=55;
    public static final int CHARREF=36;
    public static final int MIDTEXT=20;
    public static final int T__63=63;
    public static final int PRETEXT=18;
    public static final int T__43=43;
    public static final int SEMICOLON=24;
    public static final int EOF=-1;
    public static final int T__53=53;
    public static final int TEXT=15;
    public static final int NATCON=14;
    public static final int T__60=60;
    public static final int T__41=41;
    public static final int MARKUP_EMBEDDING=10;
    public static final int T__71=71;
    public static final int PATH=13;

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
    		
    	public Map<String, function_return> getFunctions() { 
    		return functions;
    	}
    	
    	public List<mapping_return> getMappings() { 
    		return mappings;
    	}
    	
    	public List<Integer> getYields() {
    		return yields;
    	}


    public static class module_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "module"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:47:1: module : ^( 'module' moduleId ( imprt )* ( site )* ( function )* ) ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:47:7: ( ^( 'module' moduleId ( imprt )* ( site )* ( function )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:47:11: ^( 'module' moduleId ( imprt )* ( site )* ( function )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal1=(CommonTree)match(input,41,FOLLOW_41_in_module57); 
            string_literal1_tree = (CommonTree)adaptor.dupNode(string_literal1);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal1_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_moduleId_in_module59);
            moduleId2=moduleId();

            state._fsp--;

            adaptor.addChild(root_1, moduleId2.getTree());
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:47:32: ( imprt )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==43) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:47:32: imprt
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_imprt_in_module61);
            	    imprt3=imprt();

            	    state._fsp--;

            	    adaptor.addChild(root_1, imprt3.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:47:39: ( site )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==SITE) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:47:39: site
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_site_in_module64);
            	    site4=site();

            	    state._fsp--;

            	    adaptor.addChild(root_1, site4.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:47:45: ( function )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==58) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:47:45: function
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_function_in_module67);
            	    function5=function();

            	    state._fsp--;

            	    adaptor.addChild(root_1, function5.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:49:1: moduleId : IDCON ( '.' IDCON )* ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:49:9: ( IDCON ( '.' IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:49:12: IDCON ( '.' IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON6=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_moduleId82); 
            IDCON6_tree = (CommonTree)adaptor.dupNode(IDCON6);

            adaptor.addChild(root_0, IDCON6_tree);

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:49:18: ( '.' IDCON )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==42) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:49:20: '.' IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal7=(CommonTree)match(input,42,FOLLOW_42_in_moduleId86); 
            	    char_literal7_tree = (CommonTree)adaptor.dupNode(char_literal7);

            	    adaptor.addChild(root_0, char_literal7_tree);

            	    _last = (CommonTree)input.LT(1);
            	    IDCON8=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_moduleId88); 
            	    IDCON8_tree = (CommonTree)adaptor.dupNode(IDCON8);

            	    adaptor.addChild(root_0, IDCON8_tree);


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:51:1: imprt : 'import' moduleId ( module )? ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:51:6: ( 'import' moduleId ( module )? )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:51:10: 'import' moduleId ( module )?
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal9=(CommonTree)match(input,43,FOLLOW_43_in_imprt101); 
            string_literal9_tree = (CommonTree)adaptor.dupNode(string_literal9);

            adaptor.addChild(root_0, string_literal9_tree);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_moduleId_in_imprt103);
            moduleId10=moduleId();

            state._fsp--;

            adaptor.addChild(root_0, moduleId10.getTree());
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:51:28: ( module )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==41) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:51:28: module
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_module_in_imprt105);
                    module11=module();

                    state._fsp--;

                    adaptor.addChild(root_0, module11.getTree());

                    }
                    break;

            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:56:1: site : 'site' mappings 'end' ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:56:5: ( 'site' mappings 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:56:9: 'site' mappings 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal12=(CommonTree)match(input,SITE,FOLLOW_SITE_in_site119); 
            string_literal12_tree = (CommonTree)adaptor.dupNode(string_literal12);

            adaptor.addChild(root_0, string_literal12_tree);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_mappings_in_site121);
            mappings13=mappings();

            state._fsp--;

            adaptor.addChild(root_0, mappings13.getTree());
            _last = (CommonTree)input.LT(1);
            string_literal14=(CommonTree)match(input,END,FOLLOW_END_in_site123); 
            string_literal14_tree = (CommonTree)adaptor.dupNode(string_literal14);

            adaptor.addChild(root_0, string_literal14_tree);


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:58:1: mappings : ( mapping )? ( ';' mapping )* ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:58:9: ( ( mapping )? ( ';' mapping )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:58:12: ( mapping )? ( ';' mapping )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:58:12: ( mapping )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==PATH) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:58:12: mapping
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_mapping_in_mappings132);
                    mapping15=mapping();

                    state._fsp--;

                    adaptor.addChild(root_0, mapping15.getTree());

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:58:21: ( ';' mapping )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==SEMICOLON) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:58:23: ';' mapping
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal16=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_mappings137); 
            	    char_literal16_tree = (CommonTree)adaptor.dupNode(char_literal16);

            	    adaptor.addChild(root_0, char_literal16_tree);

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_mapping_in_mappings139);
            	    mapping17=mapping();

            	    state._fsp--;

            	    adaptor.addChild(root_0, mapping17.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:60:1: mapping returns [int index = 0] : PATH ':' markup ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:63:2: ( PATH ':' markup )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:63:5: PATH ':' markup
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PATH18=(CommonTree)match(input,PATH,FOLLOW_PATH_in_mapping164); 
            PATH18_tree = (CommonTree)adaptor.dupNode(PATH18);

            adaptor.addChild(root_0, PATH18_tree);

            _last = (CommonTree)input.LT(1);
            char_literal19=(CommonTree)match(input,44,FOLLOW_44_in_mapping166); 
            char_literal19_tree = (CommonTree)adaptor.dupNode(char_literal19);

            adaptor.addChild(root_0, char_literal19_tree);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_markup_in_mapping168);
            markup20=markup();

            state._fsp--;

            adaptor.addChild(root_0, markup20.getTree());

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:69:1: markup : ^( MARKUP IDCON . . ) ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:69:7: ( ^( MARKUP IDCON . . ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:69:11: ^( MARKUP IDCON . . )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            MARKUP21=(CommonTree)match(input,MARKUP,FOLLOW_MARKUP_in_markup188); 
            MARKUP21_tree = (CommonTree)adaptor.dupNode(MARKUP21);

            root_1 = (CommonTree)adaptor.becomeRoot(MARKUP21_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            IDCON22=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_markup190); 
            IDCON22_tree = (CommonTree)adaptor.dupNode(IDCON22);

            adaptor.addChild(root_1, IDCON22_tree);

            _last = (CommonTree)input.LT(1);
            wildcard23=(CommonTree)input.LT(1);
            matchAny(input); 
            wildcard23_tree = (CommonTree)adaptor.dupTree(wildcard23);
            adaptor.addChild(root_1, wildcard23_tree);

            _last = (CommonTree)input.LT(1);
            wildcard24=(CommonTree)input.LT(1);
            matchAny(input); 
            wildcard24_tree = (CommonTree)adaptor.dupTree(wildcard24);
            adaptor.addChild(root_1, wildcard24_tree);


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:74:1: expression : ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:74:11: ( ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:74:14: ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:74:14: ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' )
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
            case 53:
                {
                alt12=5;
                }
                break;
            case 55:
                {
                alt12=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:74:16: IDCON
                    {
                    _last = (CommonTree)input.LT(1);
                    IDCON25=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression210); 
                    IDCON25_tree = (CommonTree)adaptor.dupNode(IDCON25);

                    adaptor.addChild(root_0, IDCON25_tree);


                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:74:24: NATCON
                    {
                    _last = (CommonTree)input.LT(1);
                    NATCON26=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_expression214); 
                    NATCON26_tree = (CommonTree)adaptor.dupNode(NATCON26);

                    adaptor.addChild(root_0, NATCON26_tree);


                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:74:33: TEXT
                    {
                    _last = (CommonTree)input.LT(1);
                    TEXT27=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_expression218); 
                    TEXT27_tree = (CommonTree)adaptor.dupNode(TEXT27);

                    adaptor.addChild(root_0, TEXT27_tree);


                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:74:40: SYMBOLCON
                    {
                    _last = (CommonTree)input.LT(1);
                    SYMBOLCON28=(CommonTree)match(input,SYMBOLCON,FOLLOW_SYMBOLCON_in_expression222); 
                    SYMBOLCON28_tree = (CommonTree)adaptor.dupNode(SYMBOLCON28);

                    adaptor.addChild(root_0, SYMBOLCON28_tree);


                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:75:7: '[' ( expression )? ( ',' expression )* ']'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal29=(CommonTree)match(input,53,FOLLOW_53_in_expression231); 
                    char_literal29_tree = (CommonTree)adaptor.dupNode(char_literal29);

                    adaptor.addChild(root_0, char_literal29_tree);

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:75:11: ( expression )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==IDCON||(LA8_0>=NATCON && LA8_0<=SYMBOLCON)||LA8_0==53||LA8_0==55) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:75:11: expression
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_expression_in_expression233);
                            expression30=expression();

                            state._fsp--;

                            adaptor.addChild(root_0, expression30.getTree());

                            }
                            break;

                    }

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:75:23: ( ',' expression )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==50) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:75:25: ',' expression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal31=(CommonTree)match(input,50,FOLLOW_50_in_expression238); 
                    	    char_literal31_tree = (CommonTree)adaptor.dupNode(char_literal31);

                    	    adaptor.addChild(root_0, char_literal31_tree);

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_expression_in_expression240);
                    	    expression32=expression();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, expression32.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal33=(CommonTree)match(input,54,FOLLOW_54_in_expression245); 
                    char_literal33_tree = (CommonTree)adaptor.dupNode(char_literal33);

                    adaptor.addChild(root_0, char_literal33_tree);


                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:76:7: '{' ( keyValuePair )? ( ',' keyValuePair )* '}'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal34=(CommonTree)match(input,55,FOLLOW_55_in_expression254); 
                    char_literal34_tree = (CommonTree)adaptor.dupNode(char_literal34);

                    adaptor.addChild(root_0, char_literal34_tree);

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:76:11: ( keyValuePair )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==IDCON) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:76:11: keyValuePair
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_keyValuePair_in_expression256);
                            keyValuePair35=keyValuePair();

                            state._fsp--;

                            adaptor.addChild(root_0, keyValuePair35.getTree());

                            }
                            break;

                    }

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:76:25: ( ',' keyValuePair )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==50) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:76:27: ',' keyValuePair
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal36=(CommonTree)match(input,50,FOLLOW_50_in_expression261); 
                    	    char_literal36_tree = (CommonTree)adaptor.dupNode(char_literal36);

                    	    adaptor.addChild(root_0, char_literal36_tree);

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_keyValuePair_in_expression263);
                    	    keyValuePair37=keyValuePair();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, keyValuePair37.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal38=(CommonTree)match(input,56,FOLLOW_56_in_expression268); 
                    char_literal38_tree = (CommonTree)adaptor.dupNode(char_literal38);

                    adaptor.addChild(root_0, char_literal38_tree);


                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:77:6: ( '+' expression | '.' IDCON )*
            loop13:
            do {
                int alt13=3;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==57) ) {
                    alt13=1;
                }
                else if ( (LA13_0==42) ) {
                    alt13=2;
                }


                switch (alt13) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:77:8: '+' expression
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal39=(CommonTree)match(input,57,FOLLOW_57_in_expression278); 
            	    char_literal39_tree = (CommonTree)adaptor.dupNode(char_literal39);

            	    adaptor.addChild(root_0, char_literal39_tree);

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expression_in_expression280);
            	    expression40=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expression40.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:77:35: '.' IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal41=(CommonTree)match(input,42,FOLLOW_42_in_expression286); 
            	    char_literal41_tree = (CommonTree)adaptor.dupNode(char_literal41);

            	    adaptor.addChild(root_0, char_literal41_tree);

            	    _last = (CommonTree)input.LT(1);
            	    IDCON42=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression288); 
            	    IDCON42_tree = (CommonTree)adaptor.dupNode(IDCON42);

            	    adaptor.addChild(root_0, IDCON42_tree);


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:79:1: keyValuePair : IDCON ':' expression ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:79:13: ( IDCON ':' expression )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:79:16: IDCON ':' expression
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON43=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_keyValuePair305); 
            IDCON43_tree = (CommonTree)adaptor.dupNode(IDCON43);

            adaptor.addChild(root_0, IDCON43_tree);

            _last = (CommonTree)input.LT(1);
            char_literal44=(CommonTree)match(input,44,FOLLOW_44_in_keyValuePair307); 
            char_literal44_tree = (CommonTree)adaptor.dupNode(char_literal44);

            adaptor.addChild(root_0, char_literal44_tree);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_keyValuePair309);
            expression45=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression45.getTree());

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:84:1: function returns [int args = 0, int index = 0] : ^( 'def' id= IDCON formals statements ) ;
    public final WaebricLoader.function_return function() throws RecognitionException {
        WaebricLoader.function_return retval = new WaebricLoader.function_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        CommonTree string_literal46=null;
        WaebricLoader.formals_return formals47 = null;

        WaebricLoader.statements_return statements48 = null;


        CommonTree id_tree=null;
        CommonTree string_literal46_tree=null;

         retval.index = input.index(); 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:87:2: ( ^( 'def' id= IDCON formals statements ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:87:5: ^( 'def' id= IDCON formals statements )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal46=(CommonTree)match(input,58,FOLLOW_58_in_function337); 
            string_literal46_tree = (CommonTree)adaptor.dupNode(string_literal46);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal46_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_function341); 
            id_tree = (CommonTree)adaptor.dupNode(id);

            adaptor.addChild(root_1, id_tree);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_formals_in_function347);
            formals47=formals();

            state._fsp--;

            adaptor.addChild(root_1, formals47.getTree());
             retval.args = (formals47!=null?formals47.args:0); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statements_in_function354);
            statements48=statements();

            state._fsp--;

            adaptor.addChild(root_1, statements48.getTree());
             if((statements48!=null?statements48.yield:false)) { yields.add(retval.index); } 

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:96:1: formals returns [int args = 0] : ^( FORMALS ( IDCON )* ) ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:98:2: ( ^( FORMALS ( IDCON )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:98:5: ^( FORMALS ( IDCON )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FORMALS49=(CommonTree)match(input,FORMALS,FOLLOW_FORMALS_in_formals382); 
            FORMALS49_tree = (CommonTree)adaptor.dupNode(FORMALS49);

            root_1 = (CommonTree)adaptor.becomeRoot(FORMALS49_tree, root_1);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:98:16: ( IDCON )*
                loop14:
                do {
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==IDCON) ) {
                        alt14=1;
                    }


                    switch (alt14) {
                	case 1 :
                	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:98:18: IDCON
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    IDCON50=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_formals386); 
                	    IDCON50_tree = (CommonTree)adaptor.dupNode(IDCON50);

                	    adaptor.addChild(root_1, IDCON50_tree);

                	     retval.args++; 

                	    }
                	    break;

                	default :
                	    break loop14;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:104:1: statements returns [boolean yield = false] : (s= statement )* ;
    public final WaebricLoader.statements_return statements() throws RecognitionException {
        WaebricLoader.statements_return retval = new WaebricLoader.statements_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricLoader.statement_return s = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:106:2: ( (s= statement )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:106:5: (s= statement )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:106:5: (s= statement )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=MARKUPS && LA15_0<=MARKUP_EMBEDDING)||LA15_0==COMMENT||LA15_0==55||LA15_0==59||(LA15_0>=61 && LA15_0<=62)||(LA15_0>=64 && LA15_0<=66)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:106:7: s= statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_statements416);
            	    s=statement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, s.getTree());
            	     if((s!=null?s.yield:false)) { retval.yield = true; } 

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:108:1: statement returns [boolean yield = false;] : ( ^( 'if' predicate t= statement ( 'else' f= statement )? ) | ^( 'each' '(' IDCON ':' expression ')' stm= statement ) | ^( 'let' ( assignment )+ 'in' stms= statements 'end' ) | ^( '{' stms= statements '}' ) | ^( 'comment' STRCON ) | ^( 'echo' expression ) | ^( 'echo' embedding ) | ^( 'cdata' expression ) | 'yield' | ^( MARKUP_EXPRESSION ( markup )+ expression ) | ^( MARKUP_STATEMENT ( markup )+ stm= statement ) | ^( MARKUP_EMBEDDING ( markup )+ embedding ) | ^( MARKUPS ( markup )+ ) );
    public final WaebricLoader.statement_return statement() throws RecognitionException {
        WaebricLoader.statement_return retval = new WaebricLoader.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal51=null;
        CommonTree string_literal53=null;
        CommonTree string_literal54=null;
        CommonTree char_literal55=null;
        CommonTree IDCON56=null;
        CommonTree char_literal57=null;
        CommonTree char_literal59=null;
        CommonTree string_literal60=null;
        CommonTree string_literal62=null;
        CommonTree string_literal63=null;
        CommonTree char_literal64=null;
        CommonTree char_literal65=null;
        CommonTree string_literal66=null;
        CommonTree STRCON67=null;
        CommonTree string_literal68=null;
        CommonTree string_literal70=null;
        CommonTree string_literal72=null;
        CommonTree string_literal74=null;
        CommonTree MARKUP_EXPRESSION75=null;
        CommonTree MARKUP_STATEMENT78=null;
        CommonTree MARKUP_EMBEDDING80=null;
        CommonTree MARKUPS83=null;
        WaebricLoader.statement_return t = null;

        WaebricLoader.statement_return f = null;

        WaebricLoader.statement_return stm = null;

        WaebricLoader.statements_return stms = null;

        WaebricLoader.predicate_return predicate52 = null;

        WaebricLoader.expression_return expression58 = null;

        WaebricLoader.assignment_return assignment61 = null;

        WaebricLoader.expression_return expression69 = null;

        WaebricLoader.embedding_return embedding71 = null;

        WaebricLoader.expression_return expression73 = null;

        WaebricLoader.markup_return markup76 = null;

        WaebricLoader.expression_return expression77 = null;

        WaebricLoader.markup_return markup79 = null;

        WaebricLoader.markup_return markup81 = null;

        WaebricLoader.embedding_return embedding82 = null;

        WaebricLoader.markup_return markup84 = null;


        CommonTree string_literal51_tree=null;
        CommonTree string_literal53_tree=null;
        CommonTree string_literal54_tree=null;
        CommonTree char_literal55_tree=null;
        CommonTree IDCON56_tree=null;
        CommonTree char_literal57_tree=null;
        CommonTree char_literal59_tree=null;
        CommonTree string_literal60_tree=null;
        CommonTree string_literal62_tree=null;
        CommonTree string_literal63_tree=null;
        CommonTree char_literal64_tree=null;
        CommonTree char_literal65_tree=null;
        CommonTree string_literal66_tree=null;
        CommonTree STRCON67_tree=null;
        CommonTree string_literal68_tree=null;
        CommonTree string_literal70_tree=null;
        CommonTree string_literal72_tree=null;
        CommonTree string_literal74_tree=null;
        CommonTree MARKUP_EXPRESSION75_tree=null;
        CommonTree MARKUP_STATEMENT78_tree=null;
        CommonTree MARKUP_EMBEDDING80_tree=null;
        CommonTree MARKUPS83_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:110:2: ( ^( 'if' predicate t= statement ( 'else' f= statement )? ) | ^( 'each' '(' IDCON ':' expression ')' stm= statement ) | ^( 'let' ( assignment )+ 'in' stms= statements 'end' ) | ^( '{' stms= statements '}' ) | ^( 'comment' STRCON ) | ^( 'echo' expression ) | ^( 'echo' embedding ) | ^( 'cdata' expression ) | 'yield' | ^( MARKUP_EXPRESSION ( markup )+ expression ) | ^( MARKUP_STATEMENT ( markup )+ stm= statement ) | ^( MARKUP_EMBEDDING ( markup )+ embedding ) | ^( MARKUPS ( markup )+ ) )
            int alt22=13;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:110:5: ^( 'if' predicate t= statement ( 'else' f= statement )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal51=(CommonTree)match(input,59,FOLLOW_59_in_statement438); 
                    string_literal51_tree = (CommonTree)adaptor.dupNode(string_literal51);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal51_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_statement440);
                    predicate52=predicate();

                    state._fsp--;

                    adaptor.addChild(root_1, predicate52.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement444);
                    t=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, t.getTree());
                     if((t!=null?t.yield:false)) retval.yield = true; 
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:111:5: ( 'else' f= statement )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==60) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:111:7: 'else' f= statement
                            {
                            _last = (CommonTree)input.LT(1);
                            string_literal53=(CommonTree)match(input,60,FOLLOW_60_in_statement455); 
                            string_literal53_tree = (CommonTree)adaptor.dupNode(string_literal53);

                            adaptor.addChild(root_1, string_literal53_tree);

                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_statement_in_statement459);
                            f=statement();

                            state._fsp--;

                            adaptor.addChild(root_1, f.getTree());
                             if((f!=null?f.yield:false)) retval.yield = true; 

                            }
                            break;

                    }


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:112:6: ^( 'each' '(' IDCON ':' expression ')' stm= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal54=(CommonTree)match(input,61,FOLLOW_61_in_statement476); 
                    string_literal54_tree = (CommonTree)adaptor.dupNode(string_literal54);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal54_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    char_literal55=(CommonTree)match(input,49,FOLLOW_49_in_statement478); 
                    char_literal55_tree = (CommonTree)adaptor.dupNode(char_literal55);

                    adaptor.addChild(root_1, char_literal55_tree);

                    _last = (CommonTree)input.LT(1);
                    IDCON56=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_statement480); 
                    IDCON56_tree = (CommonTree)adaptor.dupNode(IDCON56);

                    adaptor.addChild(root_1, IDCON56_tree);

                    _last = (CommonTree)input.LT(1);
                    char_literal57=(CommonTree)match(input,44,FOLLOW_44_in_statement482); 
                    char_literal57_tree = (CommonTree)adaptor.dupNode(char_literal57);

                    adaptor.addChild(root_1, char_literal57_tree);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement484);
                    expression58=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, expression58.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal59=(CommonTree)match(input,51,FOLLOW_51_in_statement486); 
                    char_literal59_tree = (CommonTree)adaptor.dupNode(char_literal59);

                    adaptor.addChild(root_1, char_literal59_tree);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement490);
                    stm=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, stm.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.yield = (stm!=null?stm.yield:false); 

                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:113:6: ^( 'let' ( assignment )+ 'in' stms= statements 'end' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal60=(CommonTree)match(input,62,FOLLOW_62_in_statement503); 
                    string_literal60_tree = (CommonTree)adaptor.dupNode(string_literal60);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal60_tree, root_1);



                    match(input, Token.DOWN, null); 
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:113:15: ( assignment )+
                    int cnt17=0;
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==IDCON||LA17_0==58) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:113:15: assignment
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_assignment_in_statement505);
                    	    assignment61=assignment();

                    	    state._fsp--;

                    	    adaptor.addChild(root_1, assignment61.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt17 >= 1 ) break loop17;
                                EarlyExitException eee =
                                    new EarlyExitException(17, input);
                                throw eee;
                        }
                        cnt17++;
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    string_literal62=(CommonTree)match(input,63,FOLLOW_63_in_statement508); 
                    string_literal62_tree = (CommonTree)adaptor.dupNode(string_literal62);

                    adaptor.addChild(root_1, string_literal62_tree);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statements_in_statement512);
                    stms=statements();

                    state._fsp--;

                    adaptor.addChild(root_1, stms.getTree());
                    _last = (CommonTree)input.LT(1);
                    string_literal63=(CommonTree)match(input,END,FOLLOW_END_in_statement514); 
                    string_literal63_tree = (CommonTree)adaptor.dupNode(string_literal63);

                    adaptor.addChild(root_1, string_literal63_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.yield = (stms!=null?stms.yield:false); 

                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:114:6: ^( '{' stms= statements '}' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal64=(CommonTree)match(input,55,FOLLOW_55_in_statement527); 
                    char_literal64_tree = (CommonTree)adaptor.dupNode(char_literal64);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal64_tree, root_1);



                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_statements_in_statement531);
                        stms=statements();

                        state._fsp--;

                        adaptor.addChild(root_1, stms.getTree());
                        _last = (CommonTree)input.LT(1);
                        char_literal65=(CommonTree)match(input,56,FOLLOW_56_in_statement533); 
                        char_literal65_tree = (CommonTree)adaptor.dupNode(char_literal65);

                        adaptor.addChild(root_1, char_literal65_tree);


                        match(input, Token.UP, null); 
                    }adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.yield = (stms!=null?stms.yield:false); 

                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:115:6: ^( 'comment' STRCON )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal66=(CommonTree)match(input,COMMENT,FOLLOW_COMMENT_in_statement546); 
                    string_literal66_tree = (CommonTree)adaptor.dupNode(string_literal66);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal66_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    STRCON67=(CommonTree)match(input,STRCON,FOLLOW_STRCON_in_statement548); 
                    STRCON67_tree = (CommonTree)adaptor.dupNode(STRCON67);

                    adaptor.addChild(root_1, STRCON67_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:116:6: ^( 'echo' expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal68=(CommonTree)match(input,65,FOLLOW_65_in_statement559); 
                    string_literal68_tree = (CommonTree)adaptor.dupNode(string_literal68);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal68_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement561);
                    expression69=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, expression69.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 7 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:117:6: ^( 'echo' embedding )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal70=(CommonTree)match(input,65,FOLLOW_65_in_statement572); 
                    string_literal70_tree = (CommonTree)adaptor.dupNode(string_literal70);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal70_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement574);
                    embedding71=embedding();

                    state._fsp--;

                    adaptor.addChild(root_1, embedding71.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 8 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:118:6: ^( 'cdata' expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal72=(CommonTree)match(input,66,FOLLOW_66_in_statement585); 
                    string_literal72_tree = (CommonTree)adaptor.dupNode(string_literal72);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal72_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement587);
                    expression73=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, expression73.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 9 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:119:6: 'yield'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal74=(CommonTree)match(input,64,FOLLOW_64_in_statement596); 
                    string_literal74_tree = (CommonTree)adaptor.dupNode(string_literal74);

                    adaptor.addChild(root_0, string_literal74_tree);

                     retval.yield = true; 

                    }
                    break;
                case 10 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:120:6: ^( MARKUP_EXPRESSION ( markup )+ expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_EXPRESSION75=(CommonTree)match(input,MARKUP_EXPRESSION,FOLLOW_MARKUP_EXPRESSION_in_statement607); 
                    MARKUP_EXPRESSION75_tree = (CommonTree)adaptor.dupNode(MARKUP_EXPRESSION75);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_EXPRESSION75_tree, root_1);



                    match(input, Token.DOWN, null); 
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:120:27: ( markup )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==MARKUP) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:120:27: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement609);
                    	    markup76=markup();

                    	    state._fsp--;

                    	    adaptor.addChild(root_1, markup76.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt18 >= 1 ) break loop18;
                                EarlyExitException eee =
                                    new EarlyExitException(18, input);
                                throw eee;
                        }
                        cnt18++;
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement612);
                    expression77=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, expression77.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 11 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:121:6: ^( MARKUP_STATEMENT ( markup )+ stm= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT78=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement623); 
                    MARKUP_STATEMENT78_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT78);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT78_tree, root_1);



                    match(input, Token.DOWN, null); 
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:121:26: ( markup )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==MARKUP) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:121:26: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement625);
                    	    markup79=markup();

                    	    state._fsp--;

                    	    adaptor.addChild(root_1, markup79.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt19 >= 1 ) break loop19;
                                EarlyExitException eee =
                                    new EarlyExitException(19, input);
                                throw eee;
                        }
                        cnt19++;
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement630);
                    stm=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, stm.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                     retval.yield = (stm!=null?stm.yield:false); 

                    }
                    break;
                case 12 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:122:6: ^( MARKUP_EMBEDDING ( markup )+ embedding )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_EMBEDDING80=(CommonTree)match(input,MARKUP_EMBEDDING,FOLLOW_MARKUP_EMBEDDING_in_statement644); 
                    MARKUP_EMBEDDING80_tree = (CommonTree)adaptor.dupNode(MARKUP_EMBEDDING80);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_EMBEDDING80_tree, root_1);



                    match(input, Token.DOWN, null); 
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:122:26: ( markup )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==MARKUP) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:122:26: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement646);
                    	    markup81=markup();

                    	    state._fsp--;

                    	    adaptor.addChild(root_1, markup81.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt20 >= 1 ) break loop20;
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement649);
                    embedding82=embedding();

                    state._fsp--;

                    adaptor.addChild(root_1, embedding82.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 13 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:123:6: ^( MARKUPS ( markup )+ )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUPS83=(CommonTree)match(input,MARKUPS,FOLLOW_MARKUPS_in_statement660); 
                    MARKUPS83_tree = (CommonTree)adaptor.dupNode(MARKUPS83);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUPS83_tree, root_1);



                    match(input, Token.DOWN, null); 
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:123:17: ( markup )+
                    int cnt21=0;
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==MARKUP) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:123:17: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement662);
                    	    markup84=markup();

                    	    state._fsp--;

                    	    adaptor.addChild(root_1, markup84.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt21 >= 1 ) break loop21;
                                EarlyExitException eee =
                                    new EarlyExitException(21, input);
                                throw eee;
                        }
                        cnt21++;
                    } while (true);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;

            }
            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:128:1: assignment : ( IDCON '=' expression ';' | ^( 'def' IDCON formals statement ) );
    public final WaebricLoader.assignment_return assignment() throws RecognitionException {
        WaebricLoader.assignment_return retval = new WaebricLoader.assignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON85=null;
        CommonTree char_literal86=null;
        CommonTree char_literal88=null;
        CommonTree string_literal89=null;
        CommonTree IDCON90=null;
        WaebricLoader.expression_return expression87 = null;

        WaebricLoader.formals_return formals91 = null;

        WaebricLoader.statement_return statement92 = null;


        CommonTree IDCON85_tree=null;
        CommonTree char_literal86_tree=null;
        CommonTree char_literal88_tree=null;
        CommonTree string_literal89_tree=null;
        CommonTree IDCON90_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:128:11: ( IDCON '=' expression ';' | ^( 'def' IDCON formals statement ) )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==IDCON) ) {
                alt23=1;
            }
            else if ( (LA23_0==58) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:128:14: IDCON '=' expression ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDCON85=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_assignment677); 
                    IDCON85_tree = (CommonTree)adaptor.dupNode(IDCON85);

                    adaptor.addChild(root_0, IDCON85_tree);

                    _last = (CommonTree)input.LT(1);
                    char_literal86=(CommonTree)match(input,52,FOLLOW_52_in_assignment679); 
                    char_literal86_tree = (CommonTree)adaptor.dupNode(char_literal86);

                    adaptor.addChild(root_0, char_literal86_tree);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_assignment681);
                    expression87=expression();

                    state._fsp--;

                    adaptor.addChild(root_0, expression87.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal88=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_assignment683); 
                    char_literal88_tree = (CommonTree)adaptor.dupNode(char_literal88);

                    adaptor.addChild(root_0, char_literal88_tree);


                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:129:6: ^( 'def' IDCON formals statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal89=(CommonTree)match(input,58,FOLLOW_58_in_assignment693); 
                    string_literal89_tree = (CommonTree)adaptor.dupNode(string_literal89);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal89_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    IDCON90=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_assignment695); 
                    IDCON90_tree = (CommonTree)adaptor.dupNode(IDCON90);

                    adaptor.addChild(root_1, IDCON90_tree);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_formals_in_assignment697);
                    formals91=formals();

                    state._fsp--;

                    adaptor.addChild(root_1, formals91.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_assignment699);
                    statement92=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, statement92.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;

            }
            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:135:1: predicate : ( '!' )* expression ( '.' type '?' )? ( '&&' predicate | '||' predicate )* ;
    public final WaebricLoader.predicate_return predicate() throws RecognitionException {
        WaebricLoader.predicate_return retval = new WaebricLoader.predicate_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal93=null;
        CommonTree char_literal95=null;
        CommonTree char_literal97=null;
        CommonTree string_literal98=null;
        CommonTree string_literal100=null;
        WaebricLoader.expression_return expression94 = null;

        WaebricLoader.type_return type96 = null;

        WaebricLoader.predicate_return predicate99 = null;

        WaebricLoader.predicate_return predicate101 = null;


        CommonTree char_literal93_tree=null;
        CommonTree char_literal95_tree=null;
        CommonTree char_literal97_tree=null;
        CommonTree string_literal98_tree=null;
        CommonTree string_literal100_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:135:10: ( ( '!' )* expression ( '.' type '?' )? ( '&&' predicate | '||' predicate )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:135:13: ( '!' )* expression ( '.' type '?' )? ( '&&' predicate | '||' predicate )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:135:13: ( '!' )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==67) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:135:13: '!'
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal93=(CommonTree)match(input,67,FOLLOW_67_in_predicate715); 
            	    char_literal93_tree = (CommonTree)adaptor.dupNode(char_literal93);

            	    adaptor.addChild(root_0, char_literal93_tree);


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_predicate718);
            expression94=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression94.getTree());
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:135:29: ( '.' type '?' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==42) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:135:31: '.' type '?'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal95=(CommonTree)match(input,42,FOLLOW_42_in_predicate722); 
                    char_literal95_tree = (CommonTree)adaptor.dupNode(char_literal95);

                    adaptor.addChild(root_0, char_literal95_tree);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_predicate724);
                    type96=type();

                    state._fsp--;

                    adaptor.addChild(root_0, type96.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal97=(CommonTree)match(input,68,FOLLOW_68_in_predicate726); 
                    char_literal97_tree = (CommonTree)adaptor.dupNode(char_literal97);

                    adaptor.addChild(root_0, char_literal97_tree);


                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:136:4: ( '&&' predicate | '||' predicate )*
            loop26:
            do {
                int alt26=3;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==69) ) {
                    alt26=1;
                }
                else if ( (LA26_0==70) ) {
                    alt26=2;
                }


                switch (alt26) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:136:6: '&&' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal98=(CommonTree)match(input,69,FOLLOW_69_in_predicate736); 
            	    string_literal98_tree = (CommonTree)adaptor.dupNode(string_literal98);

            	    adaptor.addChild(root_0, string_literal98_tree);

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate738);
            	    predicate99=predicate();

            	    state._fsp--;

            	    adaptor.addChild(root_0, predicate99.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:136:23: '||' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal100=(CommonTree)match(input,70,FOLLOW_70_in_predicate742); 
            	    string_literal100_tree = (CommonTree)adaptor.dupNode(string_literal100);

            	    adaptor.addChild(root_0, string_literal100_tree);

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate744);
            	    predicate101=predicate();

            	    state._fsp--;

            	    adaptor.addChild(root_0, predicate101.getTree());

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:138:1: type : ( 'list' | 'record' | 'string' );
    public final WaebricLoader.type_return type() throws RecognitionException {
        WaebricLoader.type_return retval = new WaebricLoader.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set102=null;

        CommonTree set102_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:138:5: ( 'list' | 'record' | 'string' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            set102=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=71 && input.LA(1)<=73) ) {
                input.consume();

                set102_tree = (CommonTree)adaptor.dupNode(set102);

                adaptor.addChild(root_0, set102_tree);

                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

             

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:146:1: embedding : PRETEXT embed textTail ;
    public final WaebricLoader.embedding_return embedding() throws RecognitionException {
        WaebricLoader.embedding_return retval = new WaebricLoader.embedding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PRETEXT103=null;
        WaebricLoader.embed_return embed104 = null;

        WaebricLoader.textTail_return textTail105 = null;


        CommonTree PRETEXT103_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:146:10: ( PRETEXT embed textTail )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:146:13: PRETEXT embed textTail
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PRETEXT103=(CommonTree)match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding792); 
            PRETEXT103_tree = (CommonTree)adaptor.dupNode(PRETEXT103);

            adaptor.addChild(root_0, PRETEXT103_tree);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_embed_in_embedding794);
            embed104=embed();

            state._fsp--;

            adaptor.addChild(root_0, embed104.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_textTail_in_embedding796);
            textTail105=textTail();

            state._fsp--;

            adaptor.addChild(root_0, textTail105.getTree());

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:147:1: embed : ( ^( MARKUPS ( markup )+ ) | ^( MARKUP_EXPRESSION ( markup )* expression ) );
    public final WaebricLoader.embed_return embed() throws RecognitionException {
        WaebricLoader.embed_return retval = new WaebricLoader.embed_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MARKUPS106=null;
        CommonTree MARKUP_EXPRESSION108=null;
        WaebricLoader.markup_return markup107 = null;

        WaebricLoader.markup_return markup109 = null;

        WaebricLoader.expression_return expression110 = null;


        CommonTree MARKUPS106_tree=null;
        CommonTree MARKUP_EXPRESSION108_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:147:6: ( ^( MARKUPS ( markup )+ ) | ^( MARKUP_EXPRESSION ( markup )* expression ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==MARKUPS) ) {
                alt29=1;
            }
            else if ( (LA29_0==MARKUP_EXPRESSION) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:147:10: ^( MARKUPS ( markup )+ )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUPS106=(CommonTree)match(input,MARKUPS,FOLLOW_MARKUPS_in_embed807); 
                    MARKUPS106_tree = (CommonTree)adaptor.dupNode(MARKUPS106);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUPS106_tree, root_1);



                    match(input, Token.DOWN, null); 
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:147:21: ( markup )+
                    int cnt27=0;
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==MARKUP) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:147:21: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed809);
                    	    markup107=markup();

                    	    state._fsp--;

                    	    adaptor.addChild(root_1, markup107.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt27 >= 1 ) break loop27;
                                EarlyExitException eee =
                                    new EarlyExitException(27, input);
                                throw eee;
                        }
                        cnt27++;
                    } while (true);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:148:6: ^( MARKUP_EXPRESSION ( markup )* expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_EXPRESSION108=(CommonTree)match(input,MARKUP_EXPRESSION,FOLLOW_MARKUP_EXPRESSION_in_embed821); 
                    MARKUP_EXPRESSION108_tree = (CommonTree)adaptor.dupNode(MARKUP_EXPRESSION108);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_EXPRESSION108_tree, root_1);



                    match(input, Token.DOWN, null); 
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:148:27: ( markup )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==MARKUP) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:148:27: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed823);
                    	    markup109=markup();

                    	    state._fsp--;

                    	    adaptor.addChild(root_1, markup109.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_embed826);
                    expression110=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, expression110.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;

            }
            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:149:1: textTail : ( POSTTEXT | MIDTEXT embed textTail );
    public final WaebricLoader.textTail_return textTail() throws RecognitionException {
        WaebricLoader.textTail_return retval = new WaebricLoader.textTail_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POSTTEXT111=null;
        CommonTree MIDTEXT112=null;
        WaebricLoader.embed_return embed113 = null;

        WaebricLoader.textTail_return textTail114 = null;


        CommonTree POSTTEXT111_tree=null;
        CommonTree MIDTEXT112_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:149:9: ( POSTTEXT | MIDTEXT embed textTail )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==POSTTEXT) ) {
                alt30=1;
            }
            else if ( (LA30_0==MIDTEXT) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:149:12: POSTTEXT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    POSTTEXT111=(CommonTree)match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail836); 
                    POSTTEXT111_tree = (CommonTree)adaptor.dupNode(POSTTEXT111);

                    adaptor.addChild(root_0, POSTTEXT111_tree);


                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:149:23: MIDTEXT embed textTail
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    MIDTEXT112=(CommonTree)match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail840); 
                    MIDTEXT112_tree = (CommonTree)adaptor.dupNode(MIDTEXT112);

                    adaptor.addChild(root_0, MIDTEXT112_tree);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embed_in_textTail842);
                    embed113=embed();

                    state._fsp--;

                    adaptor.addChild(root_0, embed113.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_textTail_in_textTail844);
                    textTail114=textTail();

                    state._fsp--;

                    adaptor.addChild(root_0, textTail114.getTree());

                    }
                    break;

            }
            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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

    // Delegated rules


    protected DFA22 dfa22 = new DFA22(this);
    static final String DFA22_eotS =
        "\20\uffff";
    static final String DFA22_eofS =
        "\20\uffff";
    static final String DFA22_minS =
        "\1\7\5\uffff\1\2\6\uffff\1\14\2\uffff";
    static final String DFA22_maxS =
        "\1\102\5\uffff\1\2\6\uffff\1\67\2\uffff";
    static final String DFA22_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\11\1\12\1\13\1\14\1"+
        "\15\1\uffff\1\6\1\7";
    static final String DFA22_specialS =
        "\20\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\14\1\12\1\11\1\13\12\uffff\1\5\41\uffff\1\4\3\uffff\1\1\1"+
            "\uffff\1\2\1\3\1\uffff\1\10\1\6\1\7",
            "",
            "",
            "",
            "",
            "",
            "\1\15",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\16\1\uffff\3\16\1\uffff\1\17\42\uffff\1\16\1\uffff\1\16",
            "",
            ""
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "108:1: statement returns [boolean yield = false;] : ( ^( 'if' predicate t= statement ( 'else' f= statement )? ) | ^( 'each' '(' IDCON ':' expression ')' stm= statement ) | ^( 'let' ( assignment )+ 'in' stms= statements 'end' ) | ^( '{' stms= statements '}' ) | ^( 'comment' STRCON ) | ^( 'echo' expression ) | ^( 'echo' embedding ) | ^( 'cdata' expression ) | 'yield' | ^( MARKUP_EXPRESSION ( markup )+ expression ) | ^( MARKUP_STATEMENT ( markup )+ stm= statement ) | ^( MARKUP_EMBEDDING ( markup )+ embedding ) | ^( MARKUPS ( markup )+ ) );";
        }
    }
 

    public static final BitSet FOLLOW_41_in_module57 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_moduleId_in_module59 = new BitSet(new long[]{0x0400080000400008L});
    public static final BitSet FOLLOW_imprt_in_module61 = new BitSet(new long[]{0x0400080000400008L});
    public static final BitSet FOLLOW_site_in_module64 = new BitSet(new long[]{0x0400000000400008L});
    public static final BitSet FOLLOW_function_in_module67 = new BitSet(new long[]{0x0400000000000008L});
    public static final BitSet FOLLOW_IDCON_in_moduleId82 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_moduleId86 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_IDCON_in_moduleId88 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_43_in_imprt101 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_moduleId_in_imprt103 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_module_in_imprt105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SITE_in_site119 = new BitSet(new long[]{0x0000000001802000L});
    public static final BitSet FOLLOW_mappings_in_site121 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_END_in_site123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapping_in_mappings132 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_mappings137 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_mapping_in_mappings139 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_PATH_in_mapping164 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_mapping166 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_markup_in_mapping168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUP_in_markup188 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_markup190 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x00000000000003FFL});
    public static final BitSet FOLLOW_IDCON_in_expression210 = new BitSet(new long[]{0x0200040000000002L});
    public static final BitSet FOLLOW_NATCON_in_expression214 = new BitSet(new long[]{0x0200040000000002L});
    public static final BitSet FOLLOW_TEXT_in_expression218 = new BitSet(new long[]{0x0200040000000002L});
    public static final BitSet FOLLOW_SYMBOLCON_in_expression222 = new BitSet(new long[]{0x0200040000000002L});
    public static final BitSet FOLLOW_53_in_expression231 = new BitSet(new long[]{0x00E400000001D000L});
    public static final BitSet FOLLOW_expression_in_expression233 = new BitSet(new long[]{0x0044000000000000L});
    public static final BitSet FOLLOW_50_in_expression238 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_expression240 = new BitSet(new long[]{0x0044000000000000L});
    public static final BitSet FOLLOW_54_in_expression245 = new BitSet(new long[]{0x0200040000000002L});
    public static final BitSet FOLLOW_55_in_expression254 = new BitSet(new long[]{0x0104000000001000L});
    public static final BitSet FOLLOW_keyValuePair_in_expression256 = new BitSet(new long[]{0x0104000000000000L});
    public static final BitSet FOLLOW_50_in_expression261 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_keyValuePair_in_expression263 = new BitSet(new long[]{0x0104000000000000L});
    public static final BitSet FOLLOW_56_in_expression268 = new BitSet(new long[]{0x0200040000000002L});
    public static final BitSet FOLLOW_57_in_expression278 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_expression280 = new BitSet(new long[]{0x0200040000000002L});
    public static final BitSet FOLLOW_42_in_expression286 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_IDCON_in_expression288 = new BitSet(new long[]{0x0200040000000002L});
    public static final BitSet FOLLOW_IDCON_in_keyValuePair305 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_keyValuePair307 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_keyValuePair309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_function337 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_function341 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_formals_in_function347 = new BitSet(new long[]{0x6880000000200788L,0x0000000000000007L});
    public static final BitSet FOLLOW_statements_in_function354 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FORMALS_in_formals382 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_formals386 = new BitSet(new long[]{0x0000000000001008L});
    public static final BitSet FOLLOW_statement_in_statements416 = new BitSet(new long[]{0x6880000000200782L,0x0000000000000007L});
    public static final BitSet FOLLOW_59_in_statement438 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_predicate_in_statement440 = new BitSet(new long[]{0x6880000000200780L,0x0000000000000007L});
    public static final BitSet FOLLOW_statement_in_statement444 = new BitSet(new long[]{0x1000000000000008L});
    public static final BitSet FOLLOW_60_in_statement455 = new BitSet(new long[]{0x6880000000200780L,0x0000000000000007L});
    public static final BitSet FOLLOW_statement_in_statement459 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_61_in_statement476 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_49_in_statement478 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_IDCON_in_statement480 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_statement482 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_statement484 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_statement486 = new BitSet(new long[]{0x6880000000200780L,0x0000000000000007L});
    public static final BitSet FOLLOW_statement_in_statement490 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_62_in_statement503 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_assignment_in_statement505 = new BitSet(new long[]{0x8400000000001000L});
    public static final BitSet FOLLOW_63_in_statement508 = new BitSet(new long[]{0x6880000000A00780L,0x0000000000000007L});
    public static final BitSet FOLLOW_statements_in_statement512 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_END_in_statement514 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_55_in_statement527 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statements_in_statement531 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_statement533 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COMMENT_in_statement546 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRCON_in_statement548 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_65_in_statement559 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement561 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_65_in_statement572 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_statement574 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_66_in_statement585 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement587 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_64_in_statement596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUP_EXPRESSION_in_statement607 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement609 = new BitSet(new long[]{0x00A000000001D040L});
    public static final BitSet FOLLOW_expression_in_statement612 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement623 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement625 = new BitSet(new long[]{0x68800000002007C0L,0x0000000000000007L});
    public static final BitSet FOLLOW_statement_in_statement630 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_EMBEDDING_in_statement644 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement646 = new BitSet(new long[]{0x0000000000040040L});
    public static final BitSet FOLLOW_embedding_in_statement649 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUPS_in_statement660 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement662 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_IDCON_in_assignment677 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_assignment679 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_assignment681 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_assignment683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_assignment693 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_assignment695 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_formals_in_assignment697 = new BitSet(new long[]{0x6880000000200780L,0x0000000000000007L});
    public static final BitSet FOLLOW_statement_in_assignment699 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_predicate715 = new BitSet(new long[]{0x00A000000001D000L,0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_predicate718 = new BitSet(new long[]{0x0000040000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_42_in_predicate722 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000380L});
    public static final BitSet FOLLOW_type_in_predicate724 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_predicate726 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_69_in_predicate736 = new BitSet(new long[]{0x00A000000001D000L,0x0000000000000008L});
    public static final BitSet FOLLOW_predicate_in_predicate738 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_70_in_predicate742 = new BitSet(new long[]{0x00A000000001D000L,0x0000000000000008L});
    public static final BitSet FOLLOW_predicate_in_predicate744 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding792 = new BitSet(new long[]{0x0000000000000280L});
    public static final BitSet FOLLOW_embed_in_embedding794 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_textTail_in_embedding796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUPS_in_embed807 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_embed809 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_MARKUP_EXPRESSION_in_embed821 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_embed823 = new BitSet(new long[]{0x00A000000001D040L});
    public static final BitSet FOLLOW_expression_in_embed826 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail840 = new BitSet(new long[]{0x0000000000000280L});
    public static final BitSet FOLLOW_embed_in_textTail842 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_textTail_in_textTail844 = new BitSet(new long[]{0x0000000000000002L});

}