// $ANTLR 3.1.2 /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g 2009-08-15 16:19:04

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATTRIBUTES", "ARGUMENTS", "MARKUP", "MARKUP_STATEMENT", "FORMALS", "FUNCTION", "IDCON", "PATH", "NATCON", "TEXT", "SYMBOLCON", "STRCON", "PRETEXT", "POSTTEXT", "MIDTEXT", "COMMENT", "SITE", "END", "SEMICOLON", "LETTER", "DIGIT", "HEXADECIMAL", "PATHELEMENT", "FILEEXT", "STRCHAR", "ESCLAYOUT", "DECIMAL", "TEXTCHAR", "ESCQUOTE", "AMP", "CHARREF", "ENTREF", "SYMBOLCHAR", "COMMENTS", "LAYOUT", "'module'", "'.'", "'import'", "':'", "'#'", "'$'", "'@'", "'%'", "'('", "','", "')'", "'='", "'['", "']'", "'{'", "'}'", "'+'", "'if'", "'else'", "'each'", "'let'", "'in'", "'echo'", "'cdata'", "'yield;'", "'!'", "'&&'", "'||'", "'list'", "'record'", "'string'"
    };
    public static final int ESCLAYOUT=29;
    public static final int T__42=42;
    public static final int END=21;
    public static final int T__57=57;
    public static final int T__51=51;
    public static final int FILEEXT=27;
    public static final int T__69=69;
    public static final int T__47=47;
    public static final int T__50=50;
    public static final int STRCHAR=28;
    public static final int T__65=65;
    public static final int SYMBOLCON=14;
    public static final int COMMENTS=37;
    public static final int IDCON=10;
    public static final int DECIMAL=30;
    public static final int T__67=67;
    public static final int HEXADECIMAL=25;
    public static final int T__39=39;
    public static final int TEXTCHAR=31;
    public static final int T__52=52;
    public static final int T__46=46;
    public static final int T__68=68;
    public static final int FUNCTION=9;
    public static final int T__62=62;
    public static final int MARKUP=6;
    public static final int STRCON=15;
    public static final int T__49=49;
    public static final int AMP=33;
    public static final int T__61=61;
    public static final int POSTTEXT=17;
    public static final int T__59=59;
    public static final int ATTRIBUTES=4;
    public static final int DIGIT=24;
    public static final int T__54=54;
    public static final int T__48=48;
    public static final int LAYOUT=38;
    public static final int ESCQUOTE=32;
    public static final int PATHELEMENT=26;
    public static final int T__56=56;
    public static final int ENTREF=35;
    public static final int LETTER=23;
    public static final int ARGUMENTS=5;
    public static final int SITE=20;
    public static final int T__58=58;
    public static final int T__64=64;
    public static final int T__44=44;
    public static final int T__66=66;
    public static final int SYMBOLCHAR=36;
    public static final int COMMENT=19;
    public static final int MARKUP_STATEMENT=7;
    public static final int FORMALS=8;
    public static final int T__55=55;
    public static final int T__45=45;
    public static final int CHARREF=34;
    public static final int MIDTEXT=18;
    public static final int T__63=63;
    public static final int PRETEXT=16;
    public static final int T__43=43;
    public static final int SEMICOLON=22;
    public static final int T__40=40;
    public static final int EOF=-1;
    public static final int T__53=53;
    public static final int TEXT=13;
    public static final int NATCON=12;
    public static final int T__60=60;
    public static final int T__41=41;
    public static final int PATH=11;

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


    	/**
    	 * Semantic exceptions
    	 */
    	private List<SemanticException> exceptions = new ArrayList<SemanticException>();
    	
    	/**
    	 * Checked modules
    	 */
    	private List<String> checked = new ArrayList<String>();
    	
    	/**
    	 * Collected function definitions
    	 */
    	private Map<String, function_return> functions = new HashMap<String, function_return>();
    	
    	/**
    	 * Collected mappings
    	 */
    	private List<mapping_return> mappings = new ArrayList<mapping_return>();
    	
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
    	
    	/**
    	 * Retrieve function definitions
    	 */
    	public Map<String, function_return> getFunctions() {
    		return functions;
    	}
    	
    	/**
    	 * Retrieve mappings
    	 */
    	public List<mapping_return> getMappings() {
    		return mappings;
    	}
    	


    public static class module_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "module"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:64:1: module : ^( 'module' moduleId ( imprt )* ( site )* ( function )* ) ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:64:7: ( ^( 'module' moduleId ( imprt )* ( site )* ( function )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:64:11: ^( 'module' moduleId ( imprt )* ( site )* ( function )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal1=(CommonTree)match(input,39,FOLLOW_39_in_module65); if (state.failed) return retval;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:64:32: ( imprt )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==41) ) {
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

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:64:39: ( site )*
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

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:64:45: ( function )*
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

              				checked.add((moduleId2!=null?moduleId2.name:null));
              			
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
        public String name = "";
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "moduleId"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:68:1: moduleId returns [String name = \"\"] : id= IDCON ( '.' id= IDCON )* ;
    public final WaebricLoader.moduleId_return moduleId() throws RecognitionException {
        WaebricLoader.moduleId_return retval = new WaebricLoader.moduleId_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        CommonTree char_literal6=null;

        CommonTree id_tree=null;
        CommonTree char_literal6_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:70:2: (id= IDCON ( '.' id= IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:70:5: id= IDCON ( '.' id= IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_moduleId101); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (CommonTree)adaptor.dupNode(id);

            adaptor.addChild(root_0, id_tree);
            }
            if ( state.backtracking==0 ) {
               retval.name += id.getText(); 
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:70:42: ( '.' id= IDCON )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==40) ) {
                    int LA4_2 = input.LA(2);

                    if ( (LA4_2==IDCON) ) {
                        alt4=1;
                    }


                }


                switch (alt4) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:70:44: '.' id= IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal6=(CommonTree)match(input,40,FOLLOW_40_in_moduleId107); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal6_tree = (CommonTree)adaptor.dupNode(char_literal6);

            	    adaptor.addChild(root_0, char_literal6_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_moduleId111); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    id_tree = (CommonTree)adaptor.dupNode(id);

            	    adaptor.addChild(root_0, id_tree);
            	    }
            	    if ( state.backtracking==0 ) {
            	       retval.name += "." + id.getText(); 
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:72:1: imprt : 'import' moduleId dependancy= . ;
    public final WaebricLoader.imprt_return imprt() throws RecognitionException {
        WaebricLoader.imprt_return retval = new WaebricLoader.imprt_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal7=null;
        CommonTree dependancy=null;
        WaebricLoader.moduleId_return moduleId8 = null;


        CommonTree string_literal7_tree=null;
        CommonTree dependancy_tree=null;

         int start = 0; 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:74:2: ( 'import' moduleId dependancy= . )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:74:6: 'import' moduleId dependancy= .
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal7=(CommonTree)match(input,41,FOLLOW_41_in_imprt134); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal7_tree = (CommonTree)adaptor.dupNode(string_literal7);

            adaptor.addChild(root_0, string_literal7_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_moduleId_in_imprt136);
            moduleId8=moduleId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, moduleId8.getTree());
            if ( state.backtracking==0 ) {
               start = input.index(); 
            }
            _last = (CommonTree)input.LT(1);
            dependancy=(CommonTree)input.LT(1);
            matchAny(input); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            dependancy_tree = (CommonTree)adaptor.dupTree(dependancy);
            adaptor.addChild(root_0, dependancy_tree);
            }
            if ( state.backtracking==0 ) {

              				if(! checked.contains((moduleId8!=null?moduleId8.name:null))) {
              					int curr = input.index();
              					input.seek(start);
              					module();
              					input.seek(curr);
              				}
              			
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:86:1: site : 'site' mappings 'end' ;
    public final WaebricLoader.site_return site() throws RecognitionException {
        WaebricLoader.site_return retval = new WaebricLoader.site_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal9=null;
        CommonTree string_literal11=null;
        WaebricLoader.mappings_return mappings10 = null;


        CommonTree string_literal9_tree=null;
        CommonTree string_literal11_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:86:5: ( 'site' mappings 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:86:9: 'site' mappings 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal9=(CommonTree)match(input,SITE,FOLLOW_SITE_in_site157); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal9_tree = (CommonTree)adaptor.dupNode(string_literal9);

            adaptor.addChild(root_0, string_literal9_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_mappings_in_site159);
            mappings10=mappings();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, mappings10.getTree());
            _last = (CommonTree)input.LT(1);
            string_literal11=(CommonTree)match(input,END,FOLLOW_END_in_site161); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal11_tree = (CommonTree)adaptor.dupNode(string_literal11);

            adaptor.addChild(root_0, string_literal11_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:87:1: mappings : ( mapping )? ( ';' mapping )* ;
    public final WaebricLoader.mappings_return mappings() throws RecognitionException {
        WaebricLoader.mappings_return retval = new WaebricLoader.mappings_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal13=null;
        WaebricLoader.mapping_return mapping12 = null;

        WaebricLoader.mapping_return mapping14 = null;


        CommonTree char_literal13_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:87:9: ( ( mapping )? ( ';' mapping )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:87:12: ( mapping )? ( ';' mapping )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:87:12: ( mapping )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==PATH) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: mapping
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_mapping_in_mappings169);
                    mapping12=mapping();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, mapping12.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:87:21: ( ';' mapping )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==SEMICOLON) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:87:23: ';' mapping
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal13=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_mappings174); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal13_tree = (CommonTree)adaptor.dupNode(char_literal13);

            	    adaptor.addChild(root_0, char_literal13_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_mapping_in_mappings176);
            	    mapping14=mapping();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, mapping14.getTree());

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
        public int index = 0;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mapping"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:89:1: mapping returns [int index = 0] : PATH ':' markup ;
    public final WaebricLoader.mapping_return mapping() throws RecognitionException {
        WaebricLoader.mapping_return retval = new WaebricLoader.mapping_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PATH15=null;
        CommonTree char_literal16=null;
        WaebricLoader.markup_return markup17 = null;


        CommonTree PATH15_tree=null;
        CommonTree char_literal16_tree=null;

         retval.index = input.index(); 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:92:2: ( PATH ':' markup )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:92:5: PATH ':' markup
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PATH15=(CommonTree)match(input,PATH,FOLLOW_PATH_in_mapping201); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PATH15_tree = (CommonTree)adaptor.dupNode(PATH15);

            adaptor.addChild(root_0, PATH15_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal16=(CommonTree)match(input,42,FOLLOW_42_in_mapping203); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal16_tree = (CommonTree)adaptor.dupNode(char_literal16);

            adaptor.addChild(root_0, char_literal16_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_markup_in_mapping205);
            markup17=markup();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, markup17.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:100:1: markup : ^( MARKUP IDCON . . ) ;
    public final WaebricLoader.markup_return markup() throws RecognitionException {
        WaebricLoader.markup_return retval = new WaebricLoader.markup_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MARKUP18=null;
        CommonTree IDCON19=null;
        CommonTree wildcard20=null;
        CommonTree wildcard21=null;

        CommonTree MARKUP18_tree=null;
        CommonTree IDCON19_tree=null;
        CommonTree wildcard20_tree=null;
        CommonTree wildcard21_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:100:7: ( ^( MARKUP IDCON . . ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:100:11: ^( MARKUP IDCON . . )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            MARKUP18=(CommonTree)match(input,MARKUP,FOLLOW_MARKUP_in_markup225); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MARKUP18_tree = (CommonTree)adaptor.dupNode(MARKUP18);

            root_1 = (CommonTree)adaptor.becomeRoot(MARKUP18_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            IDCON19=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_markup227); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON19_tree = (CommonTree)adaptor.dupNode(IDCON19);

            adaptor.addChild(root_1, IDCON19_tree);
            }
            _last = (CommonTree)input.LT(1);
            wildcard20=(CommonTree)input.LT(1);
            matchAny(input); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            wildcard20_tree = (CommonTree)adaptor.dupTree(wildcard20);
            adaptor.addChild(root_1, wildcard20_tree);
            }
            _last = (CommonTree)input.LT(1);
            wildcard21=(CommonTree)input.LT(1);
            matchAny(input); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            wildcard21_tree = (CommonTree)adaptor.dupTree(wildcard21);
            adaptor.addChild(root_1, wildcard21_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:105:1: expression : ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* ;
    public final WaebricLoader.expression_return expression() throws RecognitionException {
        WaebricLoader.expression_return retval = new WaebricLoader.expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON22=null;
        CommonTree NATCON23=null;
        CommonTree TEXT24=null;
        CommonTree SYMBOLCON25=null;
        CommonTree char_literal26=null;
        CommonTree char_literal28=null;
        CommonTree char_literal30=null;
        CommonTree char_literal31=null;
        CommonTree char_literal33=null;
        CommonTree char_literal35=null;
        CommonTree char_literal36=null;
        CommonTree char_literal38=null;
        CommonTree IDCON39=null;
        WaebricLoader.expression_return expression27 = null;

        WaebricLoader.expression_return expression29 = null;

        WaebricLoader.keyValuePair_return keyValuePair32 = null;

        WaebricLoader.keyValuePair_return keyValuePair34 = null;

        WaebricLoader.expression_return expression37 = null;


        CommonTree IDCON22_tree=null;
        CommonTree NATCON23_tree=null;
        CommonTree TEXT24_tree=null;
        CommonTree SYMBOLCON25_tree=null;
        CommonTree char_literal26_tree=null;
        CommonTree char_literal28_tree=null;
        CommonTree char_literal30_tree=null;
        CommonTree char_literal31_tree=null;
        CommonTree char_literal33_tree=null;
        CommonTree char_literal35_tree=null;
        CommonTree char_literal36_tree=null;
        CommonTree char_literal38_tree=null;
        CommonTree IDCON39_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:105:11: ( ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:105:14: ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:105:14: ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' )
            int alt11=6;
            switch ( input.LA(1) ) {
            case IDCON:
                {
                alt11=1;
                }
                break;
            case NATCON:
                {
                alt11=2;
                }
                break;
            case TEXT:
                {
                alt11=3;
                }
                break;
            case SYMBOLCON:
                {
                alt11=4;
                }
                break;
            case 51:
                {
                alt11=5;
                }
                break;
            case 53:
                {
                alt11=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:105:16: IDCON
                    {
                    _last = (CommonTree)input.LT(1);
                    IDCON22=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression247); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON22_tree = (CommonTree)adaptor.dupNode(IDCON22);

                    adaptor.addChild(root_0, IDCON22_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:105:24: NATCON
                    {
                    _last = (CommonTree)input.LT(1);
                    NATCON23=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_expression251); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON23_tree = (CommonTree)adaptor.dupNode(NATCON23);

                    adaptor.addChild(root_0, NATCON23_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:105:33: TEXT
                    {
                    _last = (CommonTree)input.LT(1);
                    TEXT24=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_expression255); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TEXT24_tree = (CommonTree)adaptor.dupNode(TEXT24);

                    adaptor.addChild(root_0, TEXT24_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:105:40: SYMBOLCON
                    {
                    _last = (CommonTree)input.LT(1);
                    SYMBOLCON25=(CommonTree)match(input,SYMBOLCON,FOLLOW_SYMBOLCON_in_expression259); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SYMBOLCON25_tree = (CommonTree)adaptor.dupNode(SYMBOLCON25);

                    adaptor.addChild(root_0, SYMBOLCON25_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:106:7: '[' ( expression )? ( ',' expression )* ']'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal26=(CommonTree)match(input,51,FOLLOW_51_in_expression268); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal26_tree = (CommonTree)adaptor.dupNode(char_literal26);

                    adaptor.addChild(root_0, char_literal26_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:106:11: ( expression )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==IDCON||(LA7_0>=NATCON && LA7_0<=SYMBOLCON)||LA7_0==51||LA7_0==53) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: expression
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_expression_in_expression270);
                            expression27=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, expression27.getTree());

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:106:23: ( ',' expression )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==48) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:106:25: ',' expression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal28=(CommonTree)match(input,48,FOLLOW_48_in_expression275); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal28_tree = (CommonTree)adaptor.dupNode(char_literal28);

                    	    adaptor.addChild(root_0, char_literal28_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_expression_in_expression277);
                    	    expression29=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, expression29.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal30=(CommonTree)match(input,52,FOLLOW_52_in_expression282); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal30_tree = (CommonTree)adaptor.dupNode(char_literal30);

                    adaptor.addChild(root_0, char_literal30_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:107:7: '{' ( keyValuePair )? ( ',' keyValuePair )* '}'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal31=(CommonTree)match(input,53,FOLLOW_53_in_expression291); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal31_tree = (CommonTree)adaptor.dupNode(char_literal31);

                    adaptor.addChild(root_0, char_literal31_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:107:11: ( keyValuePair )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==IDCON) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: keyValuePair
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_keyValuePair_in_expression293);
                            keyValuePair32=keyValuePair();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, keyValuePair32.getTree());

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:107:25: ( ',' keyValuePair )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==48) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:107:27: ',' keyValuePair
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal33=(CommonTree)match(input,48,FOLLOW_48_in_expression298); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal33_tree = (CommonTree)adaptor.dupNode(char_literal33);

                    	    adaptor.addChild(root_0, char_literal33_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_keyValuePair_in_expression300);
                    	    keyValuePair34=keyValuePair();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, keyValuePair34.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal35=(CommonTree)match(input,54,FOLLOW_54_in_expression305); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal35_tree = (CommonTree)adaptor.dupNode(char_literal35);

                    adaptor.addChild(root_0, char_literal35_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:108:6: ( '+' expression | '.' IDCON )*
            loop12:
            do {
                int alt12=3;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==55) ) {
                    int LA12_2 = input.LA(2);

                    if ( (synpred16_WaebricLoader()) ) {
                        alt12=1;
                    }


                }
                else if ( (LA12_0==40) ) {
                    int LA12_3 = input.LA(2);

                    if ( (synpred17_WaebricLoader()) ) {
                        alt12=2;
                    }


                }


                switch (alt12) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:108:8: '+' expression
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal36=(CommonTree)match(input,55,FOLLOW_55_in_expression315); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal36_tree = (CommonTree)adaptor.dupNode(char_literal36);

            	    adaptor.addChild(root_0, char_literal36_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expression_in_expression317);
            	    expression37=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, expression37.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:108:35: '.' IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal38=(CommonTree)match(input,40,FOLLOW_40_in_expression323); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal38_tree = (CommonTree)adaptor.dupNode(char_literal38);

            	    adaptor.addChild(root_0, char_literal38_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    IDCON39=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression325); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDCON39_tree = (CommonTree)adaptor.dupNode(IDCON39);

            	    adaptor.addChild(root_0, IDCON39_tree);
            	    }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop12;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:109:1: keyValuePair : IDCON ':' expression ;
    public final WaebricLoader.keyValuePair_return keyValuePair() throws RecognitionException {
        WaebricLoader.keyValuePair_return retval = new WaebricLoader.keyValuePair_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON40=null;
        CommonTree char_literal41=null;
        WaebricLoader.expression_return expression42 = null;


        CommonTree IDCON40_tree=null;
        CommonTree char_literal41_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:109:13: ( IDCON ':' expression )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:109:16: IDCON ':' expression
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON40=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_keyValuePair338); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON40_tree = (CommonTree)adaptor.dupNode(IDCON40);

            adaptor.addChild(root_0, IDCON40_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal41=(CommonTree)match(input,42,FOLLOW_42_in_keyValuePair340); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal41_tree = (CommonTree)adaptor.dupNode(char_literal41);

            adaptor.addChild(root_0, char_literal41_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_keyValuePair342);
            expression42=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, expression42.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:114:1: function returns [int args = 0, int index = 0] : ^( FUNCTION id= IDCON formals ( statement )* ) ;
    public final WaebricLoader.function_return function() throws RecognitionException {
        WaebricLoader.function_return retval = new WaebricLoader.function_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        CommonTree FUNCTION43=null;
        WaebricLoader.formals_return formals44 = null;

        WaebricLoader.statement_return statement45 = null;


        CommonTree id_tree=null;
        CommonTree FUNCTION43_tree=null;

         retval.index = input.index(); 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:117:2: ( ^( FUNCTION id= IDCON formals ( statement )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:117:5: ^( FUNCTION id= IDCON formals ( statement )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNCTION43=(CommonTree)match(input,FUNCTION,FOLLOW_FUNCTION_in_function370); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FUNCTION43_tree = (CommonTree)adaptor.dupNode(FUNCTION43);

            root_1 = (CommonTree)adaptor.becomeRoot(FUNCTION43_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_function374); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (CommonTree)adaptor.dupNode(id);

            adaptor.addChild(root_1, id_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_formals_in_function376);
            formals44=formals();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, formals44.getTree());
            if ( state.backtracking==0 ) {
               retval.args = (formals44!=null?formals44.args:0); 
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:117:61: ( statement )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==MARKUP_STATEMENT||LA13_0==COMMENT||LA13_0==53||LA13_0==56||(LA13_0>=58 && LA13_0<=59)||(LA13_0>=61 && LA13_0<=63)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_function380);
            	    statement45=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, statement45.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop13;
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

            		if(functions.containsKey(id.getText())) {
            			exceptions.add(new WaebricChecker.DuplicateFunctionException(id));
            		} else {
            			functions.put(id.getText(), retval); 
            		}
            	
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:126:1: formals returns [int args = 0] : ^( FORMALS ( IDCON )* ) ;
    public final WaebricLoader.formals_return formals() throws RecognitionException {
        WaebricLoader.formals_return retval = new WaebricLoader.formals_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FORMALS46=null;
        CommonTree IDCON47=null;

        CommonTree FORMALS46_tree=null;
        CommonTree IDCON47_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:127:2: ( ^( FORMALS ( IDCON )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:127:5: ^( FORMALS ( IDCON )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FORMALS46=(CommonTree)match(input,FORMALS,FOLLOW_FORMALS_in_formals406); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FORMALS46_tree = (CommonTree)adaptor.dupNode(FORMALS46);

            root_1 = (CommonTree)adaptor.becomeRoot(FORMALS46_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:127:16: ( IDCON )*
                loop14:
                do {
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==IDCON) ) {
                        alt14=1;
                    }


                    switch (alt14) {
                	case 1 :
                	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:127:18: IDCON
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    IDCON47=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_formals410); if (state.failed) return retval;
                	    if ( state.backtracking==0 ) {
                	    IDCON47_tree = (CommonTree)adaptor.dupNode(IDCON47);

                	    adaptor.addChild(root_1, IDCON47_tree);
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

    public static class statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:133:1: statement : ( ^( 'if' '(' predicate ')' statement ( 'else' statement )? ) | ^( 'each' '(' IDCON ':' expression ')' statement ) | ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ^( MARKUP_STATEMENT ( markup )+ statement ) | ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) | ^( MARKUP_STATEMENT ( markup )+ ';' ) );
    public final WaebricLoader.statement_return statement() throws RecognitionException {
        WaebricLoader.statement_return retval = new WaebricLoader.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal48=null;
        CommonTree char_literal49=null;
        CommonTree char_literal51=null;
        CommonTree string_literal53=null;
        CommonTree string_literal55=null;
        CommonTree char_literal56=null;
        CommonTree IDCON57=null;
        CommonTree char_literal58=null;
        CommonTree char_literal60=null;
        CommonTree string_literal62=null;
        CommonTree string_literal64=null;
        CommonTree string_literal66=null;
        CommonTree char_literal67=null;
        CommonTree char_literal69=null;
        CommonTree string_literal70=null;
        CommonTree STRCON71=null;
        CommonTree char_literal72=null;
        CommonTree string_literal73=null;
        CommonTree char_literal75=null;
        CommonTree string_literal76=null;
        CommonTree char_literal78=null;
        CommonTree string_literal79=null;
        CommonTree char_literal81=null;
        CommonTree string_literal82=null;
        CommonTree MARKUP_STATEMENT83=null;
        CommonTree char_literal86=null;
        CommonTree MARKUP_STATEMENT87=null;
        CommonTree MARKUP_STATEMENT90=null;
        CommonTree char_literal93=null;
        CommonTree MARKUP_STATEMENT94=null;
        CommonTree char_literal96=null;
        WaebricLoader.predicate_return predicate50 = null;

        WaebricLoader.statement_return statement52 = null;

        WaebricLoader.statement_return statement54 = null;

        WaebricLoader.expression_return expression59 = null;

        WaebricLoader.statement_return statement61 = null;

        WaebricLoader.assignment_return assignment63 = null;

        WaebricLoader.statement_return statement65 = null;

        WaebricLoader.statement_return statement68 = null;

        WaebricLoader.expression_return expression74 = null;

        WaebricLoader.embedding_return embedding77 = null;

        WaebricLoader.expression_return expression80 = null;

        WaebricLoader.markup_return markup84 = null;

        WaebricLoader.expression_return expression85 = null;

        WaebricLoader.markup_return markup88 = null;

        WaebricLoader.statement_return statement89 = null;

        WaebricLoader.markup_return markup91 = null;

        WaebricLoader.embedding_return embedding92 = null;

        WaebricLoader.markup_return markup95 = null;


        CommonTree string_literal48_tree=null;
        CommonTree char_literal49_tree=null;
        CommonTree char_literal51_tree=null;
        CommonTree string_literal53_tree=null;
        CommonTree string_literal55_tree=null;
        CommonTree char_literal56_tree=null;
        CommonTree IDCON57_tree=null;
        CommonTree char_literal58_tree=null;
        CommonTree char_literal60_tree=null;
        CommonTree string_literal62_tree=null;
        CommonTree string_literal64_tree=null;
        CommonTree string_literal66_tree=null;
        CommonTree char_literal67_tree=null;
        CommonTree char_literal69_tree=null;
        CommonTree string_literal70_tree=null;
        CommonTree STRCON71_tree=null;
        CommonTree char_literal72_tree=null;
        CommonTree string_literal73_tree=null;
        CommonTree char_literal75_tree=null;
        CommonTree string_literal76_tree=null;
        CommonTree char_literal78_tree=null;
        CommonTree string_literal79_tree=null;
        CommonTree char_literal81_tree=null;
        CommonTree string_literal82_tree=null;
        CommonTree MARKUP_STATEMENT83_tree=null;
        CommonTree char_literal86_tree=null;
        CommonTree MARKUP_STATEMENT87_tree=null;
        CommonTree MARKUP_STATEMENT90_tree=null;
        CommonTree char_literal93_tree=null;
        CommonTree MARKUP_STATEMENT94_tree=null;
        CommonTree char_literal96_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:134:2: ( ^( 'if' '(' predicate ')' statement ( 'else' statement )? ) | ^( 'each' '(' IDCON ':' expression ')' statement ) | ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ^( MARKUP_STATEMENT ( markup )+ statement ) | ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) | ^( MARKUP_STATEMENT ( markup )+ ';' ) )
            int alt23=13;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:134:5: ^( 'if' '(' predicate ')' statement ( 'else' statement )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal48=(CommonTree)match(input,56,FOLLOW_56_in_statement434); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal48_tree = (CommonTree)adaptor.dupNode(string_literal48);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal48_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    char_literal49=(CommonTree)match(input,47,FOLLOW_47_in_statement436); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal49_tree = (CommonTree)adaptor.dupNode(char_literal49);

                    adaptor.addChild(root_1, char_literal49_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_statement438);
                    predicate50=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, predicate50.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal51=(CommonTree)match(input,49,FOLLOW_49_in_statement440); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal51_tree = (CommonTree)adaptor.dupNode(char_literal51);

                    adaptor.addChild(root_1, char_literal51_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement442);
                    statement52=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement52.getTree());
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:134:41: ( 'else' statement )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==57) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:134:43: 'else' statement
                            {
                            _last = (CommonTree)input.LT(1);
                            string_literal53=(CommonTree)match(input,57,FOLLOW_57_in_statement446); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal53_tree = (CommonTree)adaptor.dupNode(string_literal53);

                            adaptor.addChild(root_1, string_literal53_tree);
                            }
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_statement_in_statement448);
                            statement54=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, statement54.getTree());

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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:135:6: ^( 'each' '(' IDCON ':' expression ')' statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal55=(CommonTree)match(input,58,FOLLOW_58_in_statement462); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal55_tree = (CommonTree)adaptor.dupNode(string_literal55);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal55_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    char_literal56=(CommonTree)match(input,47,FOLLOW_47_in_statement464); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal56_tree = (CommonTree)adaptor.dupNode(char_literal56);

                    adaptor.addChild(root_1, char_literal56_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON57=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_statement466); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON57_tree = (CommonTree)adaptor.dupNode(IDCON57);

                    adaptor.addChild(root_1, IDCON57_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal58=(CommonTree)match(input,42,FOLLOW_42_in_statement468); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal58_tree = (CommonTree)adaptor.dupNode(char_literal58);

                    adaptor.addChild(root_1, char_literal58_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement470);
                    expression59=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression59.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal60=(CommonTree)match(input,49,FOLLOW_49_in_statement472); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal60_tree = (CommonTree)adaptor.dupNode(char_literal60);

                    adaptor.addChild(root_1, char_literal60_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement474);
                    statement61=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement61.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:136:6: ^( 'let' ( assignment )+ 'in' ( statement )* 'end' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal62=(CommonTree)match(input,59,FOLLOW_59_in_statement485); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal62_tree = (CommonTree)adaptor.dupNode(string_literal62);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal62_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:136:15: ( assignment )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( ((LA16_0>=FUNCTION && LA16_0<=IDCON)) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: assignment
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_assignment_in_statement487);
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
                    	    if ( cnt16 >= 1 ) break loop16;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(16, input);
                                throw eee;
                        }
                        cnt16++;
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    string_literal64=(CommonTree)match(input,60,FOLLOW_60_in_statement490); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal64_tree = (CommonTree)adaptor.dupNode(string_literal64);

                    adaptor.addChild(root_1, string_literal64_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:136:32: ( statement )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==MARKUP_STATEMENT||LA17_0==COMMENT||LA17_0==53||LA17_0==56||(LA17_0>=58 && LA17_0<=59)||(LA17_0>=61 && LA17_0<=63)) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: statement
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_statement_in_statement492);
                    	    statement65=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, statement65.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    string_literal66=(CommonTree)match(input,END,FOLLOW_END_in_statement495); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal66_tree = (CommonTree)adaptor.dupNode(string_literal66);

                    adaptor.addChild(root_1, string_literal66_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:137:6: ^( '{' ( statement )* '}' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal67=(CommonTree)match(input,53,FOLLOW_53_in_statement506); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal67_tree = (CommonTree)adaptor.dupNode(char_literal67);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal67_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:137:13: ( statement )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==MARKUP_STATEMENT||LA18_0==COMMENT||LA18_0==53||LA18_0==56||(LA18_0>=58 && LA18_0<=59)||(LA18_0>=61 && LA18_0<=63)) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: statement
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_statement_in_statement508);
                    	    statement68=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, statement68.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal69=(CommonTree)match(input,54,FOLLOW_54_in_statement511); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal69_tree = (CommonTree)adaptor.dupNode(char_literal69);

                    adaptor.addChild(root_1, char_literal69_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:138:6: ^( 'comment' STRCON ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal70=(CommonTree)match(input,COMMENT,FOLLOW_COMMENT_in_statement522); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal70_tree = (CommonTree)adaptor.dupNode(string_literal70);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal70_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    STRCON71=(CommonTree)match(input,STRCON,FOLLOW_STRCON_in_statement524); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRCON71_tree = (CommonTree)adaptor.dupNode(STRCON71);

                    adaptor.addChild(root_1, STRCON71_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal72=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement526); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal72_tree = (CommonTree)adaptor.dupNode(char_literal72);

                    adaptor.addChild(root_1, char_literal72_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:139:6: ^( 'echo' expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal73=(CommonTree)match(input,61,FOLLOW_61_in_statement537); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal73_tree = (CommonTree)adaptor.dupNode(string_literal73);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal73_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement539);
                    expression74=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression74.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal75=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement541); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal75_tree = (CommonTree)adaptor.dupNode(char_literal75);

                    adaptor.addChild(root_1, char_literal75_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:140:6: ^( 'echo' embedding ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal76=(CommonTree)match(input,61,FOLLOW_61_in_statement552); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal76_tree = (CommonTree)adaptor.dupNode(string_literal76);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal76_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement554);
                    embedding77=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding77.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal78=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement556); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal78_tree = (CommonTree)adaptor.dupNode(char_literal78);

                    adaptor.addChild(root_1, char_literal78_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:141:6: ^( 'cdata' expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal79=(CommonTree)match(input,62,FOLLOW_62_in_statement567); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal79_tree = (CommonTree)adaptor.dupNode(string_literal79);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal79_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement569);
                    expression80=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression80.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal81=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement571); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal81_tree = (CommonTree)adaptor.dupNode(char_literal81);

                    adaptor.addChild(root_1, char_literal81_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:142:6: 'yield;'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal82=(CommonTree)match(input,63,FOLLOW_63_in_statement580); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal82_tree = (CommonTree)adaptor.dupNode(string_literal82);

                    adaptor.addChild(root_0, string_literal82_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:143:6: ^( MARKUP_STATEMENT ( markup )+ expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT83=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement589); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT83_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT83);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT83_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:143:26: ( markup )+
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
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement591);
                    	    markup84=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup84.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
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

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement594);
                    expression85=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression85.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal86=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement596); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal86_tree = (CommonTree)adaptor.dupNode(char_literal86);

                    adaptor.addChild(root_1, char_literal86_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:144:6: ^( MARKUP_STATEMENT ( markup )+ statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT87=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement607); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT87_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT87);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT87_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:144:26: ( markup )+
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
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement609);
                    	    markup88=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup88.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
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

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement612);
                    statement89=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement89.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:145:6: ^( MARKUP_STATEMENT ( markup )+ embedding ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT90=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement623); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT90_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT90);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT90_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:145:26: ( markup )+
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
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement625);
                    	    markup91=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup91.getTree());

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
                    pushFollow(FOLLOW_embedding_in_statement628);
                    embedding92=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding92.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal93=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement630); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal93_tree = (CommonTree)adaptor.dupNode(char_literal93);

                    adaptor.addChild(root_1, char_literal93_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:146:6: ^( MARKUP_STATEMENT ( markup )+ ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT94=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement641); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT94_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT94);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT94_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:146:26: ( markup )+
                    int cnt22=0;
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==MARKUP) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement643);
                    	    markup95=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup95.getTree());

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
                    char_literal96=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement646); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal96_tree = (CommonTree)adaptor.dupNode(char_literal96);

                    adaptor.addChild(root_1, char_literal96_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:151:1: assignment : ( IDCON '=' expression ';' | ^( FUNCTION IDCON formals statement ) );
    public final WaebricLoader.assignment_return assignment() throws RecognitionException {
        WaebricLoader.assignment_return retval = new WaebricLoader.assignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON97=null;
        CommonTree char_literal98=null;
        CommonTree char_literal100=null;
        CommonTree FUNCTION101=null;
        CommonTree IDCON102=null;
        WaebricLoader.expression_return expression99 = null;

        WaebricLoader.formals_return formals103 = null;

        WaebricLoader.statement_return statement104 = null;


        CommonTree IDCON97_tree=null;
        CommonTree char_literal98_tree=null;
        CommonTree char_literal100_tree=null;
        CommonTree FUNCTION101_tree=null;
        CommonTree IDCON102_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:151:11: ( IDCON '=' expression ';' | ^( FUNCTION IDCON formals statement ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==IDCON) ) {
                alt24=1;
            }
            else if ( (LA24_0==FUNCTION) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:151:14: IDCON '=' expression ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDCON97=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_assignment660); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON97_tree = (CommonTree)adaptor.dupNode(IDCON97);

                    adaptor.addChild(root_0, IDCON97_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal98=(CommonTree)match(input,50,FOLLOW_50_in_assignment662); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal98_tree = (CommonTree)adaptor.dupNode(char_literal98);

                    adaptor.addChild(root_0, char_literal98_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_assignment664);
                    expression99=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression99.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal100=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_assignment666); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal100_tree = (CommonTree)adaptor.dupNode(char_literal100);

                    adaptor.addChild(root_0, char_literal100_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:152:6: ^( FUNCTION IDCON formals statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    FUNCTION101=(CommonTree)match(input,FUNCTION,FOLLOW_FUNCTION_in_assignment676); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNCTION101_tree = (CommonTree)adaptor.dupNode(FUNCTION101);

                    root_1 = (CommonTree)adaptor.becomeRoot(FUNCTION101_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDCON102=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_assignment678); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON102_tree = (CommonTree)adaptor.dupNode(IDCON102);

                    adaptor.addChild(root_1, IDCON102_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_formals_in_assignment680);
                    formals103=formals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, formals103.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_assignment682);
                    statement104=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement104.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:157:1: predicate : ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )* ;
    public final WaebricLoader.predicate_return predicate() throws RecognitionException {
        WaebricLoader.predicate_return retval = new WaebricLoader.predicate_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal105=null;
        CommonTree char_literal109=null;
        CommonTree string_literal111=null;
        CommonTree string_literal113=null;
        WaebricLoader.predicate_return predicate106 = null;

        WaebricLoader.expression_return expression107 = null;

        WaebricLoader.expression_return expression108 = null;

        WaebricLoader.type_return type110 = null;

        WaebricLoader.predicate_return predicate112 = null;

        WaebricLoader.predicate_return predicate114 = null;


        CommonTree char_literal105_tree=null;
        CommonTree char_literal109_tree=null;
        CommonTree string_literal111_tree=null;
        CommonTree string_literal113_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:157:10: ( ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:157:13: ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:157:13: ( '!' predicate | expression | expression '.' type )
            int alt25=3;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:157:15: '!' predicate
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal105=(CommonTree)match(input,64,FOLLOW_64_in_predicate699); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal105_tree = (CommonTree)adaptor.dupNode(char_literal105);

                    adaptor.addChild(root_0, char_literal105_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_predicate701);
                    predicate106=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, predicate106.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:158:7: expression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate710);
                    expression107=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression107.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:159:7: expression '.' type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate719);
                    expression108=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression108.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal109=(CommonTree)match(input,40,FOLLOW_40_in_predicate721); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal109_tree = (CommonTree)adaptor.dupNode(char_literal109);

                    adaptor.addChild(root_0, char_literal109_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_predicate723);
                    type110=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, type110.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:160:6: ( '&&' predicate | '||' predicate )*
            loop26:
            do {
                int alt26=3;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==65) ) {
                    int LA26_2 = input.LA(2);

                    if ( (synpred43_WaebricLoader()) ) {
                        alt26=1;
                    }


                }
                else if ( (LA26_0==66) ) {
                    int LA26_3 = input.LA(2);

                    if ( (synpred44_WaebricLoader()) ) {
                        alt26=2;
                    }


                }


                switch (alt26) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:160:8: '&&' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal111=(CommonTree)match(input,65,FOLLOW_65_in_predicate733); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal111_tree = (CommonTree)adaptor.dupNode(string_literal111);

            	    adaptor.addChild(root_0, string_literal111_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate735);
            	    predicate112=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, predicate112.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:160:25: '||' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal113=(CommonTree)match(input,66,FOLLOW_66_in_predicate739); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal113_tree = (CommonTree)adaptor.dupNode(string_literal113);

            	    adaptor.addChild(root_0, string_literal113_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate741);
            	    predicate114=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, predicate114.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop26;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:161:1: type : ( 'list' | 'record' | 'string' );
    public final WaebricLoader.type_return type() throws RecognitionException {
        WaebricLoader.type_return retval = new WaebricLoader.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set115=null;

        CommonTree set115_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:161:5: ( 'list' | 'record' | 'string' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            set115=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=67 && input.LA(1)<=69) ) {
                input.consume();

                if ( state.backtracking==0 ) {
                set115_tree = (CommonTree)adaptor.dupNode(set115);

                adaptor.addChild(root_0, set115_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:166:1: embedding : PRETEXT embed textTail ;
    public final WaebricLoader.embedding_return embedding() throws RecognitionException {
        WaebricLoader.embedding_return retval = new WaebricLoader.embedding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PRETEXT116=null;
        WaebricLoader.embed_return embed117 = null;

        WaebricLoader.textTail_return textTail118 = null;


        CommonTree PRETEXT116_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:166:10: ( PRETEXT embed textTail )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:166:13: PRETEXT embed textTail
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PRETEXT116=(CommonTree)match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding773); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRETEXT116_tree = (CommonTree)adaptor.dupNode(PRETEXT116);

            adaptor.addChild(root_0, PRETEXT116_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_embed_in_embedding775);
            embed117=embed();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, embed117.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_textTail_in_embedding777);
            textTail118=textTail();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, textTail118.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:167:1: embed : ( ( markup )* expression | ( markup )* markup );
    public final WaebricLoader.embed_return embed() throws RecognitionException {
        WaebricLoader.embed_return retval = new WaebricLoader.embed_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricLoader.markup_return markup119 = null;

        WaebricLoader.expression_return expression120 = null;

        WaebricLoader.markup_return markup121 = null;

        WaebricLoader.markup_return markup122 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:167:6: ( ( markup )* expression | ( markup )* markup )
            int alt29=2;
            alt29 = dfa29.predict(input);
            switch (alt29) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:167:10: ( markup )* expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:167:10: ( markup )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==MARKUP) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed786);
                    	    markup119=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup119.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_embed789);
                    expression120=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression120.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:167:31: ( markup )* markup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:167:31: ( markup )*
                    loop28:
                    do {
                        int alt28=2;
                        alt28 = dfa28.predict(input);
                        switch (alt28) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed793);
                    	    markup121=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup121.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_embed796);
                    markup122=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, markup122.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:168:1: textTail : ( POSTTEXT | MIDTEXT embed textTail );
    public final WaebricLoader.textTail_return textTail() throws RecognitionException {
        WaebricLoader.textTail_return retval = new WaebricLoader.textTail_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POSTTEXT123=null;
        CommonTree MIDTEXT124=null;
        WaebricLoader.embed_return embed125 = null;

        WaebricLoader.textTail_return textTail126 = null;


        CommonTree POSTTEXT123_tree=null;
        CommonTree MIDTEXT124_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:168:9: ( POSTTEXT | MIDTEXT embed textTail )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==POSTTEXT) ) {
                alt30=1;
            }
            else if ( (LA30_0==MIDTEXT) ) {
                alt30=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:168:12: POSTTEXT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    POSTTEXT123=(CommonTree)match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail804); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    POSTTEXT123_tree = (CommonTree)adaptor.dupNode(POSTTEXT123);

                    adaptor.addChild(root_0, POSTTEXT123_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:168:23: MIDTEXT embed textTail
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    MIDTEXT124=(CommonTree)match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail808); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MIDTEXT124_tree = (CommonTree)adaptor.dupNode(MIDTEXT124);

                    adaptor.addChild(root_0, MIDTEXT124_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embed_in_textTail810);
                    embed125=embed();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, embed125.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_textTail_in_textTail812);
                    textTail126=textTail();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, textTail126.getTree());

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

    // $ANTLR start synpred16_WaebricLoader
    public final void synpred16_WaebricLoader_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:108:8: ( '+' expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:108:8: '+' expression
        {
        match(input,55,FOLLOW_55_in_synpred16_WaebricLoader315); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred16_WaebricLoader317);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_WaebricLoader

    // $ANTLR start synpred17_WaebricLoader
    public final void synpred17_WaebricLoader_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:108:35: ( '.' IDCON )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:108:35: '.' IDCON
        {
        match(input,40,FOLLOW_40_in_synpred17_WaebricLoader323); if (state.failed) return ;
        match(input,IDCON,FOLLOW_IDCON_in_synpred17_WaebricLoader325); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_WaebricLoader

    // $ANTLR start synpred42_WaebricLoader
    public final void synpred42_WaebricLoader_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:158:7: ( expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:158:7: expression
        {
        pushFollow(FOLLOW_expression_in_synpred42_WaebricLoader710);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred42_WaebricLoader

    // $ANTLR start synpred43_WaebricLoader
    public final void synpred43_WaebricLoader_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:160:8: ( '&&' predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:160:8: '&&' predicate
        {
        match(input,65,FOLLOW_65_in_synpred43_WaebricLoader733); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred43_WaebricLoader735);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred43_WaebricLoader

    // $ANTLR start synpred44_WaebricLoader
    public final void synpred44_WaebricLoader_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:160:25: ( '||' predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:160:25: '||' predicate
        {
        match(input,66,FOLLOW_66_in_synpred44_WaebricLoader739); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred44_WaebricLoader741);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred44_WaebricLoader

    // Delegated rules

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
    public final boolean synpred42_WaebricLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_WaebricLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_WaebricLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_WaebricLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred43_WaebricLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_WaebricLoader_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA23 dfa23 = new DFA23(this);
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA28 dfa28 = new DFA28(this);
    static final String DFA23_eotS =
        "\37\uffff";
    static final String DFA23_eofS =
        "\37\uffff";
    static final String DFA23_minS =
        "\1\7\5\uffff\1\2\2\uffff\1\2\1\12\1\6\2\uffff\1\2\1\12\1\4\1\2\1"+
        "\4\1\2\1\3\1\4\1\6\1\4\1\3\1\uffff\1\2\3\uffff\1\3";
    static final String DFA23_maxS =
        "\1\77\5\uffff\1\2\2\uffff\1\2\1\65\1\6\2\uffff\1\2\1\12\3\105\1"+
        "\3\2\105\1\77\2\105\1\uffff\1\66\3\uffff\1\3";
    static final String DFA23_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\11\3\uffff\1\6\1\7\13"+
        "\uffff\1\12\1\uffff\1\14\1\15\1\13\1\uffff";
    static final String DFA23_specialS =
        "\37\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\11\13\uffff\1\5\41\uffff\1\4\2\uffff\1\1\1\uffff\1\2\1\3"+
            "\1\uffff\1\6\1\7\1\10",
            "",
            "",
            "",
            "",
            "",
            "\1\12",
            "",
            "",
            "\1\13",
            "\1\14\1\uffff\3\14\1\uffff\1\15\42\uffff\1\14\1\uffff\1\14",
            "\1\16",
            "",
            "",
            "\1\17",
            "\1\20",
            "\102\21",
            "\1\22\1\uffff\102\23",
            "\102\24",
            "\1\25\1\26",
            "\1\27\102\24",
            "\102\30",
            "\1\16\1\35\2\uffff\1\31\1\uffff\3\31\1\uffff\1\33\2\uffff\1"+
            "\35\2\uffff\1\34\34\uffff\1\31\1\uffff\1\32\2\uffff\1\35\1\uffff"+
            "\2\35\1\uffff\3\35",
            "\102\23",
            "\1\36\102\30",
            "",
            "\1\35\7\uffff\1\31\45\uffff\1\31\5\uffff\1\31",
            "",
            "",
            "",
            "\1\26"
    };

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "133:1: statement : ( ^( 'if' '(' predicate ')' statement ( 'else' statement )? ) | ^( 'each' '(' IDCON ':' expression ')' statement ) | ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ^( MARKUP_STATEMENT ( markup )+ statement ) | ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) | ^( MARKUP_STATEMENT ( markup )+ ';' ) );";
        }
    }
    static final String DFA25_eotS =
        "\12\uffff";
    static final String DFA25_eofS =
        "\12\uffff";
    static final String DFA25_minS =
        "\1\12\1\uffff\6\0\2\uffff";
    static final String DFA25_maxS =
        "\1\100\1\uffff\6\0\2\uffff";
    static final String DFA25_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\1\3";
    static final String DFA25_specialS =
        "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\2\uffff}>";
    static final String[] DFA25_transitionS = {
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
            return "157:13: ( '!' predicate | expression | expression '.' type )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TreeNodeStream input = (TreeNodeStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA25_2 = input.LA(1);

                         
                        int index25_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_WaebricLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index25_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA25_3 = input.LA(1);

                         
                        int index25_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_WaebricLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index25_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA25_4 = input.LA(1);

                         
                        int index25_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_WaebricLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index25_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA25_5 = input.LA(1);

                         
                        int index25_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_WaebricLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index25_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA25_6 = input.LA(1);

                         
                        int index25_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_WaebricLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index25_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA25_7 = input.LA(1);

                         
                        int index25_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_WaebricLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index25_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 25, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA29_eotS =
        "\17\uffff";
    static final String DFA29_eofS =
        "\17\uffff";
    static final String DFA29_minS =
        "\1\6\1\2\1\uffff\1\12\1\4\2\2\2\4\1\6\2\3\1\uffff\1\4\1\3";
    static final String DFA29_maxS =
        "\1\65\1\2\1\uffff\1\12\2\105\1\3\2\105\1\65\2\105\1\uffff\1\105"+
        "\1\3";
    static final String DFA29_acceptS =
        "\2\uffff\1\1\11\uffff\1\2\2\uffff";
    static final String DFA29_specialS =
        "\17\uffff}>";
    static final String[] DFA29_transitionS = {
            "\1\1\3\uffff\1\2\1\uffff\3\2\44\uffff\1\2\1\uffff\1\2",
            "\1\3",
            "",
            "\1\4",
            "\102\5",
            "\1\7\1\uffff\102\6",
            "\1\10\1\11",
            "\102\12",
            "\102\13",
            "\1\1\3\uffff\1\2\1\uffff\3\2\2\uffff\2\14\40\uffff\1\2\1\uffff"+
            "\1\2",
            "\1\15\102\12",
            "\1\16\102\13",
            "",
            "\102\6",
            "\1\11"
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
            return "167:1: embed : ( ( markup )* expression | ( markup )* markup );";
        }
    }
    static final String DFA28_eotS =
        "\17\uffff";
    static final String DFA28_eofS =
        "\17\uffff";
    static final String DFA28_minS =
        "\1\6\1\2\1\12\1\4\2\2\1\4\1\6\1\4\1\3\2\uffff\1\3\1\4\1\3";
    static final String DFA28_maxS =
        "\1\6\1\2\1\12\2\105\1\3\1\105\1\22\2\105\2\uffff\2\105\1\3";
    static final String DFA28_acceptS =
        "\12\uffff\1\2\1\1\3\uffff";
    static final String DFA28_specialS =
        "\17\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\102\4",
            "\1\6\1\uffff\102\5",
            "\1\10\1\7",
            "\102\11",
            "\1\13\12\uffff\2\12",
            "\102\14",
            "\1\15\102\11",
            "",
            "",
            "\1\16\102\14",
            "\102\5",
            "\1\7"
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
            return "()* loopback of 167:31: ( markup )*";
        }
    }
 

    public static final BitSet FOLLOW_39_in_module65 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_moduleId_in_module67 = new BitSet(new long[]{0x0000020000100208L});
    public static final BitSet FOLLOW_imprt_in_module69 = new BitSet(new long[]{0x0000020000100208L});
    public static final BitSet FOLLOW_site_in_module72 = new BitSet(new long[]{0x0000000000100208L});
    public static final BitSet FOLLOW_function_in_module75 = new BitSet(new long[]{0x0000000000000208L});
    public static final BitSet FOLLOW_IDCON_in_moduleId101 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_moduleId107 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_moduleId111 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_41_in_imprt134 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_moduleId_in_imprt136 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000000000003FL});
    public static final BitSet FOLLOW_SITE_in_site157 = new BitSet(new long[]{0x0000000000600800L});
    public static final BitSet FOLLOW_mappings_in_site159 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_END_in_site161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapping_in_mappings169 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_SEMICOLON_in_mappings174 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_mapping_in_mappings176 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_PATH_in_mapping201 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_mapping203 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_markup_in_mapping205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUP_in_markup225 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_markup227 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000000000003FL});
    public static final BitSet FOLLOW_IDCON_in_expression247 = new BitSet(new long[]{0x0080010000000002L});
    public static final BitSet FOLLOW_NATCON_in_expression251 = new BitSet(new long[]{0x0080010000000002L});
    public static final BitSet FOLLOW_TEXT_in_expression255 = new BitSet(new long[]{0x0080010000000002L});
    public static final BitSet FOLLOW_SYMBOLCON_in_expression259 = new BitSet(new long[]{0x0080010000000002L});
    public static final BitSet FOLLOW_51_in_expression268 = new BitSet(new long[]{0x0039000000007400L});
    public static final BitSet FOLLOW_expression_in_expression270 = new BitSet(new long[]{0x0011000000000000L});
    public static final BitSet FOLLOW_48_in_expression275 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_expression277 = new BitSet(new long[]{0x0011000000000000L});
    public static final BitSet FOLLOW_52_in_expression282 = new BitSet(new long[]{0x0080010000000002L});
    public static final BitSet FOLLOW_53_in_expression291 = new BitSet(new long[]{0x0041000000000400L});
    public static final BitSet FOLLOW_keyValuePair_in_expression293 = new BitSet(new long[]{0x0041000000000000L});
    public static final BitSet FOLLOW_48_in_expression298 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_keyValuePair_in_expression300 = new BitSet(new long[]{0x0041000000000000L});
    public static final BitSet FOLLOW_54_in_expression305 = new BitSet(new long[]{0x0080010000000002L});
    public static final BitSet FOLLOW_55_in_expression315 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_expression317 = new BitSet(new long[]{0x0080010000000002L});
    public static final BitSet FOLLOW_40_in_expression323 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_expression325 = new BitSet(new long[]{0x0080010000000002L});
    public static final BitSet FOLLOW_IDCON_in_keyValuePair338 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_keyValuePair340 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_keyValuePair342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_function370 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_function374 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_formals_in_function376 = new BitSet(new long[]{0xED20000000080088L});
    public static final BitSet FOLLOW_statement_in_function380 = new BitSet(new long[]{0xED20000000080088L});
    public static final BitSet FOLLOW_FORMALS_in_formals406 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_formals410 = new BitSet(new long[]{0x0000000000000408L});
    public static final BitSet FOLLOW_56_in_statement434 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_47_in_statement436 = new BitSet(new long[]{0x0028000000007400L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_statement438 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_statement440 = new BitSet(new long[]{0xED20000000080080L});
    public static final BitSet FOLLOW_statement_in_statement442 = new BitSet(new long[]{0x0200000000000008L});
    public static final BitSet FOLLOW_57_in_statement446 = new BitSet(new long[]{0xED20000000080080L});
    public static final BitSet FOLLOW_statement_in_statement448 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_58_in_statement462 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_47_in_statement464 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_statement466 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_statement468 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_statement470 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_statement472 = new BitSet(new long[]{0xED20000000080080L});
    public static final BitSet FOLLOW_statement_in_statement474 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_59_in_statement485 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_assignment_in_statement487 = new BitSet(new long[]{0x1000000000000600L});
    public static final BitSet FOLLOW_60_in_statement490 = new BitSet(new long[]{0xED20000000280080L});
    public static final BitSet FOLLOW_statement_in_statement492 = new BitSet(new long[]{0xED20000000280080L});
    public static final BitSet FOLLOW_END_in_statement495 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_53_in_statement506 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statement508 = new BitSet(new long[]{0xED60000000080080L});
    public static final BitSet FOLLOW_54_in_statement511 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COMMENT_in_statement522 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRCON_in_statement524 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement526 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_61_in_statement537 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement539 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement541 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_61_in_statement552 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_statement554 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement556 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_62_in_statement567 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement569 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement571 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_63_in_statement580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement589 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement591 = new BitSet(new long[]{0x0028000000007440L});
    public static final BitSet FOLLOW_expression_in_statement594 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement596 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement607 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement609 = new BitSet(new long[]{0xED200000000800C0L});
    public static final BitSet FOLLOW_statement_in_statement612 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement623 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement625 = new BitSet(new long[]{0x0000000000010040L});
    public static final BitSet FOLLOW_embedding_in_statement628 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement630 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement641 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement643 = new BitSet(new long[]{0x0000000000400040L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement646 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDCON_in_assignment660 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_assignment662 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_assignment664 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_assignment666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_assignment676 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_assignment678 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_formals_in_assignment680 = new BitSet(new long[]{0xED20000000080080L});
    public static final BitSet FOLLOW_statement_in_assignment682 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_64_in_predicate699 = new BitSet(new long[]{0x0028000000007400L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_predicate701 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000006L});
    public static final BitSet FOLLOW_expression_in_predicate710 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000006L});
    public static final BitSet FOLLOW_expression_in_predicate719 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_predicate721 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000038L});
    public static final BitSet FOLLOW_type_in_predicate723 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000006L});
    public static final BitSet FOLLOW_65_in_predicate733 = new BitSet(new long[]{0x0028000000007400L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_predicate735 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000006L});
    public static final BitSet FOLLOW_66_in_predicate739 = new BitSet(new long[]{0x0028000000007400L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_predicate741 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000006L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding773 = new BitSet(new long[]{0x0028000000007440L});
    public static final BitSet FOLLOW_embed_in_embedding775 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_textTail_in_embedding777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed786 = new BitSet(new long[]{0x0028000000007440L});
    public static final BitSet FOLLOW_expression_in_embed789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed793 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_markup_in_embed796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail808 = new BitSet(new long[]{0x0028000000007440L});
    public static final BitSet FOLLOW_embed_in_textTail810 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_textTail_in_textTail812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_synpred16_WaebricLoader315 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_synpred16_WaebricLoader317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_synpred17_WaebricLoader323 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_synpred17_WaebricLoader325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred42_WaebricLoader710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_synpred43_WaebricLoader733 = new BitSet(new long[]{0x0028000000007400L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_synpred43_WaebricLoader735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_synpred44_WaebricLoader739 = new BitSet(new long[]{0x0028000000007400L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_synpred44_WaebricLoader741 = new BitSet(new long[]{0x0000000000000002L});

}