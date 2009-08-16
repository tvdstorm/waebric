// $ANTLR 3.1.2 /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g 2009-08-16 10:47:33

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATTRIBUTES", "ARGUMENTS", "MARKUP", "MARKUP_STATEMENT", "MARKUP_CHAIN", "FORMALS", "FUNCTION", "IDCON", "PATH", "NATCON", "TEXT", "SYMBOLCON", "STRCON", "PRETEXT", "POSTTEXT", "MIDTEXT", "COMMENT", "SITE", "END", "SEMICOLON", "LETTER", "DIGIT", "HEXADECIMAL", "PATHELEMENT", "FILEEXT", "STRCHAR", "ESCLAYOUT", "DECIMAL", "TEXTCHAR", "ESCQUOTE", "AMP", "CHARREF", "ENTREF", "SYMBOLCHAR", "COMMENTS", "LAYOUT", "'module'", "'.'", "'import'", "':'", "'#'", "'$'", "'@'", "'%'", "'('", "','", "')'", "'='", "'['", "']'", "'{'", "'}'", "'+'", "'if'", "'else'", "'each'", "'let'", "'in'", "'echo'", "'cdata'", "'yield;'", "'!'", "'&&'", "'||'", "'list'", "'record'", "'string'"
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


    	/**
    	 * Semantic exceptions
    	 */
    	private List<SemanticException> exceptions = new ArrayList<SemanticException>();
    	
    	/**
    	 * Checked modules
    	 */
    	private List<String> checked = new ArrayList<String>();
    	
    	/**
    	 * Detected yield positions
    	 */
    	private List<Integer> yields = new ArrayList<Integer>();
    	
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
    	
    	public List<Integer> getYields() {
    		return yields;
    	}
    	


    public static class module_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "module"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:73:1: module : ^( 'module' moduleId ( imprt )* ( site )* ( function )* ) ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:73:7: ( ^( 'module' moduleId ( imprt )* ( site )* ( function )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:73:11: ^( 'module' moduleId ( imprt )* ( site )* ( function )* )
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:73:32: ( imprt )*
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

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:73:39: ( site )*
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

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:73:45: ( function )*
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:77:1: moduleId returns [String name = \"\"] : id= IDCON ( '.' id= IDCON )* ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:79:2: (id= IDCON ( '.' id= IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:79:5: id= IDCON ( '.' id= IDCON )*
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:79:42: ( '.' id= IDCON )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==41) ) {
                    int LA4_2 = input.LA(2);

                    if ( (LA4_2==IDCON) ) {
                        alt4=1;
                    }


                }


                switch (alt4) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:79:44: '.' id= IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal6=(CommonTree)match(input,41,FOLLOW_41_in_moduleId107); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:81:1: imprt : 'import' moduleId dependancy= . ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:83:2: ( 'import' moduleId dependancy= . )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:83:6: 'import' moduleId dependancy= .
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal7=(CommonTree)match(input,42,FOLLOW_42_in_imprt134); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:95:1: site : 'site' mappings 'end' ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:95:5: ( 'site' mappings 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:95:9: 'site' mappings 'end'
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:96:1: mappings : ( mapping )? ( ';' mapping )* ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:96:9: ( ( mapping )? ( ';' mapping )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:96:12: ( mapping )? ( ';' mapping )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:96:12: ( mapping )?
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

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:96:21: ( ';' mapping )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==SEMICOLON) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:96:23: ';' mapping
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:98:1: mapping returns [int index = 0] : PATH ':' markup ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:101:2: ( PATH ':' markup )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:101:5: PATH ':' markup
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PATH15=(CommonTree)match(input,PATH,FOLLOW_PATH_in_mapping201); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PATH15_tree = (CommonTree)adaptor.dupNode(PATH15);

            adaptor.addChild(root_0, PATH15_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal16=(CommonTree)match(input,43,FOLLOW_43_in_mapping203); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:109:1: markup : ^( MARKUP IDCON . . ) ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:109:7: ( ^( MARKUP IDCON . . ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:109:11: ^( MARKUP IDCON . . )
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:114:1: expression : ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:114:11: ( ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:114:14: ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:114:14: ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' )
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
            case 52:
                {
                alt11=5;
                }
                break;
            case 54:
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:114:16: IDCON
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:114:24: NATCON
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:114:33: TEXT
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:114:40: SYMBOLCON
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:115:7: '[' ( expression )? ( ',' expression )* ']'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal26=(CommonTree)match(input,52,FOLLOW_52_in_expression268); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal26_tree = (CommonTree)adaptor.dupNode(char_literal26);

                    adaptor.addChild(root_0, char_literal26_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:115:11: ( expression )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==IDCON||(LA7_0>=NATCON && LA7_0<=SYMBOLCON)||LA7_0==52||LA7_0==54) ) {
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

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:115:23: ( ',' expression )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==49) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:115:25: ',' expression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal28=(CommonTree)match(input,49,FOLLOW_49_in_expression275); if (state.failed) return retval;
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
                    char_literal30=(CommonTree)match(input,53,FOLLOW_53_in_expression282); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal30_tree = (CommonTree)adaptor.dupNode(char_literal30);

                    adaptor.addChild(root_0, char_literal30_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:116:7: '{' ( keyValuePair )? ( ',' keyValuePair )* '}'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal31=(CommonTree)match(input,54,FOLLOW_54_in_expression291); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal31_tree = (CommonTree)adaptor.dupNode(char_literal31);

                    adaptor.addChild(root_0, char_literal31_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:116:11: ( keyValuePair )?
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

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:116:25: ( ',' keyValuePair )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==49) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:116:27: ',' keyValuePair
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal33=(CommonTree)match(input,49,FOLLOW_49_in_expression298); if (state.failed) return retval;
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
                    char_literal35=(CommonTree)match(input,55,FOLLOW_55_in_expression305); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal35_tree = (CommonTree)adaptor.dupNode(char_literal35);

                    adaptor.addChild(root_0, char_literal35_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:117:6: ( '+' expression | '.' IDCON )*
            loop12:
            do {
                int alt12=3;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==56) ) {
                    int LA12_2 = input.LA(2);

                    if ( (synpred16_WaebricLoader()) ) {
                        alt12=1;
                    }


                }
                else if ( (LA12_0==41) ) {
                    int LA12_3 = input.LA(2);

                    if ( (synpred17_WaebricLoader()) ) {
                        alt12=2;
                    }


                }


                switch (alt12) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:117:8: '+' expression
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal36=(CommonTree)match(input,56,FOLLOW_56_in_expression315); if (state.failed) return retval;
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
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:117:35: '.' IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal38=(CommonTree)match(input,41,FOLLOW_41_in_expression323); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:118:1: keyValuePair : IDCON ':' expression ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:118:13: ( IDCON ':' expression )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:118:16: IDCON ':' expression
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON40=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_keyValuePair338); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON40_tree = (CommonTree)adaptor.dupNode(IDCON40);

            adaptor.addChild(root_0, IDCON40_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal41=(CommonTree)match(input,43,FOLLOW_43_in_keyValuePair340); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:123:1: function returns [int args = 0, int index = 0] : ^( FUNCTION id= IDCON formals statements ) ;
    public final WaebricLoader.function_return function() throws RecognitionException {
        WaebricLoader.function_return retval = new WaebricLoader.function_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        CommonTree FUNCTION43=null;
        WaebricLoader.formals_return formals44 = null;

        WaebricLoader.statements_return statements45 = null;


        CommonTree id_tree=null;
        CommonTree FUNCTION43_tree=null;

         retval.index = input.index();
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:126:2: ( ^( FUNCTION id= IDCON formals statements ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:126:5: ^( FUNCTION id= IDCON formals statements )
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
            pushFollow(FOLLOW_formals_in_function380);
            formals44=formals();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, formals44.getTree());
            if ( state.backtracking==0 ) {
               retval.args = (formals44!=null?formals44.args:0); 
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statements_in_function387);
            statements45=statements();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, statements45.getTree());
            if ( state.backtracking==0 ) {
               if((statements45!=null?statements45.yield:false)) { yields.add(retval.index); } 
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:137:1: formals returns [int args = 0] : ^( FORMALS ( IDCON )* ) ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:138:2: ( ^( FORMALS ( IDCON )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:138:5: ^( FORMALS ( IDCON )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FORMALS46=(CommonTree)match(input,FORMALS,FOLLOW_FORMALS_in_formals413); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FORMALS46_tree = (CommonTree)adaptor.dupNode(FORMALS46);

            root_1 = (CommonTree)adaptor.becomeRoot(FORMALS46_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:138:16: ( IDCON )*
                loop13:
                do {
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==IDCON) ) {
                        alt13=1;
                    }


                    switch (alt13) {
                	case 1 :
                	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:138:18: IDCON
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    IDCON47=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_formals417); if (state.failed) return retval;
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
                	    break loop13;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:144:1: statements returns [boolean yield = false] : (s= statement )* ;
    public final WaebricLoader.statements_return statements() throws RecognitionException {
        WaebricLoader.statements_return retval = new WaebricLoader.statements_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricLoader.statement_return s = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:146:2: ( (s= statement )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:146:5: (s= statement )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:146:5: (s= statement )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==MARKUP_STATEMENT||LA14_0==COMMENT||LA14_0==54||LA14_0==57||(LA14_0>=59 && LA14_0<=60)||(LA14_0>=62 && LA14_0<=64)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:146:7: s= statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_statements447);
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
            	    break loop14;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:148:1: statement returns [boolean yield = false;] : ( ^( 'if' '(' predicate ')' t= statement ( 'else' f= statement )? ) | ^( 'each' '(' IDCON ':' expression ')' stm= statement ) | ^( 'let' ( assignment )+ 'in' stms= statements 'end' ) | ^( '{' stms= statements '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT markup markupChain ) );
    public final WaebricLoader.statement_return statement() throws RecognitionException {
        WaebricLoader.statement_return retval = new WaebricLoader.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal48=null;
        CommonTree char_literal49=null;
        CommonTree char_literal51=null;
        CommonTree string_literal52=null;
        CommonTree string_literal53=null;
        CommonTree char_literal54=null;
        CommonTree IDCON55=null;
        CommonTree char_literal56=null;
        CommonTree char_literal58=null;
        CommonTree string_literal59=null;
        CommonTree string_literal61=null;
        CommonTree string_literal62=null;
        CommonTree char_literal63=null;
        CommonTree char_literal64=null;
        CommonTree string_literal65=null;
        CommonTree STRCON66=null;
        CommonTree char_literal67=null;
        CommonTree string_literal68=null;
        CommonTree char_literal70=null;
        CommonTree string_literal71=null;
        CommonTree char_literal73=null;
        CommonTree string_literal74=null;
        CommonTree char_literal76=null;
        CommonTree string_literal77=null;
        CommonTree MARKUP_STATEMENT78=null;
        WaebricLoader.statement_return t = null;

        WaebricLoader.statement_return f = null;

        WaebricLoader.statement_return stm = null;

        WaebricLoader.statements_return stms = null;

        WaebricLoader.predicate_return predicate50 = null;

        WaebricLoader.expression_return expression57 = null;

        WaebricLoader.assignment_return assignment60 = null;

        WaebricLoader.expression_return expression69 = null;

        WaebricLoader.embedding_return embedding72 = null;

        WaebricLoader.expression_return expression75 = null;

        WaebricLoader.markup_return markup79 = null;

        WaebricLoader.markupChain_return markupChain80 = null;


        CommonTree string_literal48_tree=null;
        CommonTree char_literal49_tree=null;
        CommonTree char_literal51_tree=null;
        CommonTree string_literal52_tree=null;
        CommonTree string_literal53_tree=null;
        CommonTree char_literal54_tree=null;
        CommonTree IDCON55_tree=null;
        CommonTree char_literal56_tree=null;
        CommonTree char_literal58_tree=null;
        CommonTree string_literal59_tree=null;
        CommonTree string_literal61_tree=null;
        CommonTree string_literal62_tree=null;
        CommonTree char_literal63_tree=null;
        CommonTree char_literal64_tree=null;
        CommonTree string_literal65_tree=null;
        CommonTree STRCON66_tree=null;
        CommonTree char_literal67_tree=null;
        CommonTree string_literal68_tree=null;
        CommonTree char_literal70_tree=null;
        CommonTree string_literal71_tree=null;
        CommonTree char_literal73_tree=null;
        CommonTree string_literal74_tree=null;
        CommonTree char_literal76_tree=null;
        CommonTree string_literal77_tree=null;
        CommonTree MARKUP_STATEMENT78_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:150:2: ( ^( 'if' '(' predicate ')' t= statement ( 'else' f= statement )? ) | ^( 'each' '(' IDCON ':' expression ')' stm= statement ) | ^( 'let' ( assignment )+ 'in' stms= statements 'end' ) | ^( '{' stms= statements '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT markup markupChain ) )
            int alt17=10;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:150:5: ^( 'if' '(' predicate ')' t= statement ( 'else' f= statement )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal48=(CommonTree)match(input,57,FOLLOW_57_in_statement469); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal48_tree = (CommonTree)adaptor.dupNode(string_literal48);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal48_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    char_literal49=(CommonTree)match(input,48,FOLLOW_48_in_statement471); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal49_tree = (CommonTree)adaptor.dupNode(char_literal49);

                    adaptor.addChild(root_1, char_literal49_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_statement473);
                    predicate50=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, predicate50.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal51=(CommonTree)match(input,50,FOLLOW_50_in_statement475); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal51_tree = (CommonTree)adaptor.dupNode(char_literal51);

                    adaptor.addChild(root_1, char_literal51_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement479);
                    t=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, t.getTree());
                    if ( state.backtracking==0 ) {
                       if((t!=null?t.yield:false)) retval.yield = true; 
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:151:5: ( 'else' f= statement )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==58) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:151:7: 'else' f= statement
                            {
                            _last = (CommonTree)input.LT(1);
                            string_literal52=(CommonTree)match(input,58,FOLLOW_58_in_statement490); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal52_tree = (CommonTree)adaptor.dupNode(string_literal52);

                            adaptor.addChild(root_1, string_literal52_tree);
                            }
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_statement_in_statement494);
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:152:6: ^( 'each' '(' IDCON ':' expression ')' stm= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal53=(CommonTree)match(input,59,FOLLOW_59_in_statement511); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal53_tree = (CommonTree)adaptor.dupNode(string_literal53);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal53_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    char_literal54=(CommonTree)match(input,48,FOLLOW_48_in_statement513); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal54_tree = (CommonTree)adaptor.dupNode(char_literal54);

                    adaptor.addChild(root_1, char_literal54_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON55=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_statement515); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON55_tree = (CommonTree)adaptor.dupNode(IDCON55);

                    adaptor.addChild(root_1, IDCON55_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal56=(CommonTree)match(input,43,FOLLOW_43_in_statement517); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal56_tree = (CommonTree)adaptor.dupNode(char_literal56);

                    adaptor.addChild(root_1, char_literal56_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement519);
                    expression57=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression57.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal58=(CommonTree)match(input,50,FOLLOW_50_in_statement521); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal58_tree = (CommonTree)adaptor.dupNode(char_literal58);

                    adaptor.addChild(root_1, char_literal58_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement525);
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:153:6: ^( 'let' ( assignment )+ 'in' stms= statements 'end' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal59=(CommonTree)match(input,60,FOLLOW_60_in_statement538); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal59_tree = (CommonTree)adaptor.dupNode(string_literal59);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal59_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:153:15: ( assignment )+
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
                    	    pushFollow(FOLLOW_assignment_in_statement540);
                    	    assignment60=assignment();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, assignment60.getTree());

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
                    string_literal61=(CommonTree)match(input,61,FOLLOW_61_in_statement543); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal61_tree = (CommonTree)adaptor.dupNode(string_literal61);

                    adaptor.addChild(root_1, string_literal61_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statements_in_statement547);
                    stms=statements();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, stms.getTree());
                    _last = (CommonTree)input.LT(1);
                    string_literal62=(CommonTree)match(input,END,FOLLOW_END_in_statement549); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal62_tree = (CommonTree)adaptor.dupNode(string_literal62);

                    adaptor.addChild(root_1, string_literal62_tree);
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:154:6: ^( '{' stms= statements '}' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal63=(CommonTree)match(input,54,FOLLOW_54_in_statement562); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal63_tree = (CommonTree)adaptor.dupNode(char_literal63);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal63_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_statements_in_statement566);
                        stms=statements();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, stms.getTree());
                        _last = (CommonTree)input.LT(1);
                        char_literal64=(CommonTree)match(input,55,FOLLOW_55_in_statement568); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        char_literal64_tree = (CommonTree)adaptor.dupNode(char_literal64);

                        adaptor.addChild(root_1, char_literal64_tree);
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:155:6: ^( 'comment' STRCON ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal65=(CommonTree)match(input,COMMENT,FOLLOW_COMMENT_in_statement581); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal65_tree = (CommonTree)adaptor.dupNode(string_literal65);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal65_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    STRCON66=(CommonTree)match(input,STRCON,FOLLOW_STRCON_in_statement583); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRCON66_tree = (CommonTree)adaptor.dupNode(STRCON66);

                    adaptor.addChild(root_1, STRCON66_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal67=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement585); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal67_tree = (CommonTree)adaptor.dupNode(char_literal67);

                    adaptor.addChild(root_1, char_literal67_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:156:6: ^( 'echo' expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal68=(CommonTree)match(input,62,FOLLOW_62_in_statement596); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal68_tree = (CommonTree)adaptor.dupNode(string_literal68);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal68_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement598);
                    expression69=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression69.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal70=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement600); if (state.failed) return retval;
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
                case 7 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:157:6: ^( 'echo' embedding ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal71=(CommonTree)match(input,62,FOLLOW_62_in_statement611); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal71_tree = (CommonTree)adaptor.dupNode(string_literal71);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal71_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement613);
                    embedding72=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding72.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal73=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement615); if (state.failed) return retval;
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
                case 8 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:158:6: ^( 'cdata' expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal74=(CommonTree)match(input,63,FOLLOW_63_in_statement626); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal74_tree = (CommonTree)adaptor.dupNode(string_literal74);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal74_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement628);
                    expression75=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression75.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal76=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement630); if (state.failed) return retval;
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
                case 9 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:159:6: 'yield;'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal77=(CommonTree)match(input,64,FOLLOW_64_in_statement639); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal77_tree = (CommonTree)adaptor.dupNode(string_literal77);

                    adaptor.addChild(root_0, string_literal77_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.yield = true; 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:160:6: ^( MARKUP_STATEMENT markup markupChain )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT78=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement650); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT78_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT78);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT78_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_statement652);
                    markup79=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, markup79.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markupChain_in_statement654);
                    markupChain80=markupChain();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, markupChain80.getTree());
                    if ( state.backtracking==0 ) {
                       retval.yield = (markupChain80!=null?markupChain80.yield:false); 
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:162:1: markupChain returns [boolean yield = false] : ( ^( MARKUP_CHAIN markup c= markupChain ) | ^( MARKUP_CHAIN expression ';' ) | ^( MARKUP_CHAIN s= statement ) | ^( MARKUP_CHAIN embedding ';' ) | ^( MARKUP_CHAIN ';' ) );
    public final WaebricLoader.markupChain_return markupChain() throws RecognitionException {
        WaebricLoader.markupChain_return retval = new WaebricLoader.markupChain_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MARKUP_CHAIN81=null;
        CommonTree MARKUP_CHAIN83=null;
        CommonTree char_literal85=null;
        CommonTree MARKUP_CHAIN86=null;
        CommonTree MARKUP_CHAIN87=null;
        CommonTree char_literal89=null;
        CommonTree MARKUP_CHAIN90=null;
        CommonTree char_literal91=null;
        WaebricLoader.markupChain_return c = null;

        WaebricLoader.statement_return s = null;

        WaebricLoader.markup_return markup82 = null;

        WaebricLoader.expression_return expression84 = null;

        WaebricLoader.embedding_return embedding88 = null;


        CommonTree MARKUP_CHAIN81_tree=null;
        CommonTree MARKUP_CHAIN83_tree=null;
        CommonTree char_literal85_tree=null;
        CommonTree MARKUP_CHAIN86_tree=null;
        CommonTree MARKUP_CHAIN87_tree=null;
        CommonTree char_literal89_tree=null;
        CommonTree MARKUP_CHAIN90_tree=null;
        CommonTree char_literal91_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:164:2: ( ^( MARKUP_CHAIN markup c= markupChain ) | ^( MARKUP_CHAIN expression ';' ) | ^( MARKUP_CHAIN s= statement ) | ^( MARKUP_CHAIN embedding ';' ) | ^( MARKUP_CHAIN ';' ) )
            int alt18=5;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==MARKUP_CHAIN) ) {
                int LA18_1 = input.LA(2);

                if ( (LA18_1==DOWN) ) {
                    switch ( input.LA(3) ) {
                    case SEMICOLON:
                        {
                        alt18=5;
                        }
                        break;
                    case IDCON:
                    case NATCON:
                    case TEXT:
                    case SYMBOLCON:
                    case 52:
                        {
                        alt18=2;
                        }
                        break;
                    case 54:
                        {
                        int LA18_5 = input.LA(4);

                        if ( (LA18_5==DOWN) ) {
                            alt18=3;
                        }
                        else if ( (LA18_5==IDCON||LA18_5==49||LA18_5==55) ) {
                            alt18=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 18, 5, input);

                            throw nvae;
                        }
                        }
                        break;
                    case MARKUP:
                        {
                        alt18=1;
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
                        alt18=3;
                        }
                        break;
                    case PRETEXT:
                        {
                        alt18=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 2, input);

                        throw nvae;
                    }

                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:164:5: ^( MARKUP_CHAIN markup c= markupChain )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_CHAIN81=(CommonTree)match(input,MARKUP_CHAIN,FOLLOW_MARKUP_CHAIN_in_markupChain676); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_CHAIN81_tree = (CommonTree)adaptor.dupNode(MARKUP_CHAIN81);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_CHAIN81_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_markupChain678);
                    markup82=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, markup82.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markupChain_in_markupChain682);
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:165:6: ^( MARKUP_CHAIN expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_CHAIN83=(CommonTree)match(input,MARKUP_CHAIN,FOLLOW_MARKUP_CHAIN_in_markupChain695); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_CHAIN83_tree = (CommonTree)adaptor.dupNode(MARKUP_CHAIN83);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_CHAIN83_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_markupChain697);
                    expression84=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression84.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal85=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_markupChain699); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal85_tree = (CommonTree)adaptor.dupNode(char_literal85);

                    adaptor.addChild(root_1, char_literal85_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:166:6: ^( MARKUP_CHAIN s= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_CHAIN86=(CommonTree)match(input,MARKUP_CHAIN,FOLLOW_MARKUP_CHAIN_in_markupChain710); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_CHAIN86_tree = (CommonTree)adaptor.dupNode(MARKUP_CHAIN86);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_CHAIN86_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_markupChain714);
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:167:6: ^( MARKUP_CHAIN embedding ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_CHAIN87=(CommonTree)match(input,MARKUP_CHAIN,FOLLOW_MARKUP_CHAIN_in_markupChain727); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_CHAIN87_tree = (CommonTree)adaptor.dupNode(MARKUP_CHAIN87);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_CHAIN87_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_markupChain729);
                    embedding88=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding88.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal89=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_markupChain731); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal89_tree = (CommonTree)adaptor.dupNode(char_literal89);

                    adaptor.addChild(root_1, char_literal89_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:168:6: ^( MARKUP_CHAIN ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_CHAIN90=(CommonTree)match(input,MARKUP_CHAIN,FOLLOW_MARKUP_CHAIN_in_markupChain742); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_CHAIN90_tree = (CommonTree)adaptor.dupNode(MARKUP_CHAIN90);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_CHAIN90_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    char_literal91=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_markupChain744); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal91_tree = (CommonTree)adaptor.dupNode(char_literal91);

                    adaptor.addChild(root_1, char_literal91_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:173:1: assignment : ( IDCON '=' expression ';' | ^( FUNCTION IDCON formals statement ) );
    public final WaebricLoader.assignment_return assignment() throws RecognitionException {
        WaebricLoader.assignment_return retval = new WaebricLoader.assignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON92=null;
        CommonTree char_literal93=null;
        CommonTree char_literal95=null;
        CommonTree FUNCTION96=null;
        CommonTree IDCON97=null;
        WaebricLoader.expression_return expression94 = null;

        WaebricLoader.formals_return formals98 = null;

        WaebricLoader.statement_return statement99 = null;


        CommonTree IDCON92_tree=null;
        CommonTree char_literal93_tree=null;
        CommonTree char_literal95_tree=null;
        CommonTree FUNCTION96_tree=null;
        CommonTree IDCON97_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:173:11: ( IDCON '=' expression ';' | ^( FUNCTION IDCON formals statement ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==IDCON) ) {
                alt19=1;
            }
            else if ( (LA19_0==FUNCTION) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:173:14: IDCON '=' expression ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDCON92=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_assignment761); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON92_tree = (CommonTree)adaptor.dupNode(IDCON92);

                    adaptor.addChild(root_0, IDCON92_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal93=(CommonTree)match(input,51,FOLLOW_51_in_assignment763); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal93_tree = (CommonTree)adaptor.dupNode(char_literal93);

                    adaptor.addChild(root_0, char_literal93_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_assignment765);
                    expression94=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression94.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal95=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_assignment767); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal95_tree = (CommonTree)adaptor.dupNode(char_literal95);

                    adaptor.addChild(root_0, char_literal95_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:174:6: ^( FUNCTION IDCON formals statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    FUNCTION96=(CommonTree)match(input,FUNCTION,FOLLOW_FUNCTION_in_assignment777); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNCTION96_tree = (CommonTree)adaptor.dupNode(FUNCTION96);

                    root_1 = (CommonTree)adaptor.becomeRoot(FUNCTION96_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDCON97=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_assignment779); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON97_tree = (CommonTree)adaptor.dupNode(IDCON97);

                    adaptor.addChild(root_1, IDCON97_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_formals_in_assignment781);
                    formals98=formals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, formals98.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_assignment783);
                    statement99=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement99.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:179:1: predicate : ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )* ;
    public final WaebricLoader.predicate_return predicate() throws RecognitionException {
        WaebricLoader.predicate_return retval = new WaebricLoader.predicate_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal100=null;
        CommonTree char_literal104=null;
        CommonTree string_literal106=null;
        CommonTree string_literal108=null;
        WaebricLoader.predicate_return predicate101 = null;

        WaebricLoader.expression_return expression102 = null;

        WaebricLoader.expression_return expression103 = null;

        WaebricLoader.type_return type105 = null;

        WaebricLoader.predicate_return predicate107 = null;

        WaebricLoader.predicate_return predicate109 = null;


        CommonTree char_literal100_tree=null;
        CommonTree char_literal104_tree=null;
        CommonTree string_literal106_tree=null;
        CommonTree string_literal108_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:179:10: ( ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:179:13: ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:179:13: ( '!' predicate | expression | expression '.' type )
            int alt20=3;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:179:15: '!' predicate
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal100=(CommonTree)match(input,65,FOLLOW_65_in_predicate800); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal100_tree = (CommonTree)adaptor.dupNode(char_literal100);

                    adaptor.addChild(root_0, char_literal100_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_predicate802);
                    predicate101=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, predicate101.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:180:7: expression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate811);
                    expression102=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression102.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:181:7: expression '.' type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate820);
                    expression103=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression103.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal104=(CommonTree)match(input,41,FOLLOW_41_in_predicate822); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal104_tree = (CommonTree)adaptor.dupNode(char_literal104);

                    adaptor.addChild(root_0, char_literal104_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_predicate824);
                    type105=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, type105.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:182:6: ( '&&' predicate | '||' predicate )*
            loop21:
            do {
                int alt21=3;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==66) ) {
                    int LA21_2 = input.LA(2);

                    if ( (synpred38_WaebricLoader()) ) {
                        alt21=1;
                    }


                }
                else if ( (LA21_0==67) ) {
                    int LA21_3 = input.LA(2);

                    if ( (synpred39_WaebricLoader()) ) {
                        alt21=2;
                    }


                }


                switch (alt21) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:182:8: '&&' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal106=(CommonTree)match(input,66,FOLLOW_66_in_predicate834); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal106_tree = (CommonTree)adaptor.dupNode(string_literal106);

            	    adaptor.addChild(root_0, string_literal106_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate836);
            	    predicate107=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, predicate107.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:182:25: '||' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal108=(CommonTree)match(input,67,FOLLOW_67_in_predicate840); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal108_tree = (CommonTree)adaptor.dupNode(string_literal108);

            	    adaptor.addChild(root_0, string_literal108_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate842);
            	    predicate109=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, predicate109.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop21;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:183:1: type : ( 'list' | 'record' | 'string' );
    public final WaebricLoader.type_return type() throws RecognitionException {
        WaebricLoader.type_return retval = new WaebricLoader.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set110=null;

        CommonTree set110_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:183:5: ( 'list' | 'record' | 'string' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            set110=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=68 && input.LA(1)<=70) ) {
                input.consume();

                if ( state.backtracking==0 ) {
                set110_tree = (CommonTree)adaptor.dupNode(set110);

                adaptor.addChild(root_0, set110_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:188:1: embedding : PRETEXT embed textTail ;
    public final WaebricLoader.embedding_return embedding() throws RecognitionException {
        WaebricLoader.embedding_return retval = new WaebricLoader.embedding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PRETEXT111=null;
        WaebricLoader.embed_return embed112 = null;

        WaebricLoader.textTail_return textTail113 = null;


        CommonTree PRETEXT111_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:188:10: ( PRETEXT embed textTail )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:188:13: PRETEXT embed textTail
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PRETEXT111=(CommonTree)match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding874); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRETEXT111_tree = (CommonTree)adaptor.dupNode(PRETEXT111);

            adaptor.addChild(root_0, PRETEXT111_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_embed_in_embedding876);
            embed112=embed();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, embed112.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_textTail_in_embedding878);
            textTail113=textTail();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, textTail113.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:189:1: embed : ( ( markup )* expression | ( markup )* markup );
    public final WaebricLoader.embed_return embed() throws RecognitionException {
        WaebricLoader.embed_return retval = new WaebricLoader.embed_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricLoader.markup_return markup114 = null;

        WaebricLoader.expression_return expression115 = null;

        WaebricLoader.markup_return markup116 = null;

        WaebricLoader.markup_return markup117 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:189:6: ( ( markup )* expression | ( markup )* markup )
            int alt24=2;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:189:10: ( markup )* expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:189:10: ( markup )*
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
                    	    pushFollow(FOLLOW_markup_in_embed887);
                    	    markup114=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup114.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_embed890);
                    expression115=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression115.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:189:31: ( markup )* markup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:189:31: ( markup )*
                    loop23:
                    do {
                        int alt23=2;
                        alt23 = dfa23.predict(input);
                        switch (alt23) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed894);
                    	    markup116=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup116.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_embed897);
                    markup117=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, markup117.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:190:1: textTail : ( POSTTEXT | MIDTEXT embed textTail );
    public final WaebricLoader.textTail_return textTail() throws RecognitionException {
        WaebricLoader.textTail_return retval = new WaebricLoader.textTail_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POSTTEXT118=null;
        CommonTree MIDTEXT119=null;
        WaebricLoader.embed_return embed120 = null;

        WaebricLoader.textTail_return textTail121 = null;


        CommonTree POSTTEXT118_tree=null;
        CommonTree MIDTEXT119_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:190:9: ( POSTTEXT | MIDTEXT embed textTail )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==POSTTEXT) ) {
                alt25=1;
            }
            else if ( (LA25_0==MIDTEXT) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:190:12: POSTTEXT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    POSTTEXT118=(CommonTree)match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail905); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    POSTTEXT118_tree = (CommonTree)adaptor.dupNode(POSTTEXT118);

                    adaptor.addChild(root_0, POSTTEXT118_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:190:23: MIDTEXT embed textTail
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    MIDTEXT119=(CommonTree)match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail909); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MIDTEXT119_tree = (CommonTree)adaptor.dupNode(MIDTEXT119);

                    adaptor.addChild(root_0, MIDTEXT119_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embed_in_textTail911);
                    embed120=embed();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, embed120.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_textTail_in_textTail913);
                    textTail121=textTail();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, textTail121.getTree());

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
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:117:8: ( '+' expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:117:8: '+' expression
        {
        match(input,56,FOLLOW_56_in_synpred16_WaebricLoader315); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred16_WaebricLoader317);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_WaebricLoader

    // $ANTLR start synpred17_WaebricLoader
    public final void synpred17_WaebricLoader_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:117:35: ( '.' IDCON )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:117:35: '.' IDCON
        {
        match(input,41,FOLLOW_41_in_synpred17_WaebricLoader323); if (state.failed) return ;
        match(input,IDCON,FOLLOW_IDCON_in_synpred17_WaebricLoader325); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_WaebricLoader

    // $ANTLR start synpred37_WaebricLoader
    public final void synpred37_WaebricLoader_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:180:7: ( expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:180:7: expression
        {
        pushFollow(FOLLOW_expression_in_synpred37_WaebricLoader811);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred37_WaebricLoader

    // $ANTLR start synpred38_WaebricLoader
    public final void synpred38_WaebricLoader_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:182:8: ( '&&' predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:182:8: '&&' predicate
        {
        match(input,66,FOLLOW_66_in_synpred38_WaebricLoader834); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred38_WaebricLoader836);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred38_WaebricLoader

    // $ANTLR start synpred39_WaebricLoader
    public final void synpred39_WaebricLoader_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:182:25: ( '||' predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:182:25: '||' predicate
        {
        match(input,67,FOLLOW_67_in_synpred39_WaebricLoader840); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred39_WaebricLoader842);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_WaebricLoader

    // Delegated rules

    public final boolean synpred37_WaebricLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_WaebricLoader_fragment(); // can never throw exception
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


    protected DFA17 dfa17 = new DFA17(this);
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA23 dfa23 = new DFA23(this);
    static final String DFA17_eotS =
        "\15\uffff";
    static final String DFA17_eofS =
        "\15\uffff";
    static final String DFA17_minS =
        "\1\7\5\uffff\1\2\3\uffff\1\13\2\uffff";
    static final String DFA17_maxS =
        "\1\100\5\uffff\1\2\3\uffff\1\66\2\uffff";
    static final String DFA17_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\11\1\12\1\uffff\1\7"+
        "\1\6";
    static final String DFA17_specialS =
        "\15\uffff}>";
    static final String[] DFA17_transitionS = {
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

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "148:1: statement returns [boolean yield = false;] : ( ^( 'if' '(' predicate ')' t= statement ( 'else' f= statement )? ) | ^( 'each' '(' IDCON ':' expression ')' stm= statement ) | ^( 'let' ( assignment )+ 'in' stms= statements 'end' ) | ^( '{' stms= statements '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT markup markupChain ) );";
        }
    }
    static final String DFA20_eotS =
        "\12\uffff";
    static final String DFA20_eofS =
        "\12\uffff";
    static final String DFA20_minS =
        "\1\13\1\uffff\6\0\2\uffff";
    static final String DFA20_maxS =
        "\1\101\1\uffff\6\0\2\uffff";
    static final String DFA20_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\1\3";
    static final String DFA20_specialS =
        "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\2\uffff}>";
    static final String[] DFA20_transitionS = {
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
            return "179:13: ( '!' predicate | expression | expression '.' type )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TreeNodeStream input = (TreeNodeStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA20_2 = input.LA(1);

                         
                        int index20_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_WaebricLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index20_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA20_3 = input.LA(1);

                         
                        int index20_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_WaebricLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index20_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA20_4 = input.LA(1);

                         
                        int index20_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_WaebricLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index20_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA20_5 = input.LA(1);

                         
                        int index20_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_WaebricLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index20_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA20_6 = input.LA(1);

                         
                        int index20_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_WaebricLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index20_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA20_7 = input.LA(1);

                         
                        int index20_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_WaebricLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index20_7);
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
    static final String DFA24_eotS =
        "\17\uffff";
    static final String DFA24_eofS =
        "\17\uffff";
    static final String DFA24_minS =
        "\1\6\1\2\1\uffff\1\13\1\4\1\2\1\4\1\2\1\3\1\6\2\4\1\uffff\2\3";
    static final String DFA24_maxS =
        "\1\66\1\2\1\uffff\1\13\3\106\1\3\1\106\1\66\2\106\1\uffff\1\106"+
        "\1\3";
    static final String DFA24_acceptS =
        "\2\uffff\1\1\11\uffff\1\2\2\uffff";
    static final String DFA24_specialS =
        "\17\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\1\4\uffff\1\2\1\uffff\3\2\44\uffff\1\2\1\uffff\1\2",
            "\1\3",
            "",
            "\1\4",
            "\103\5",
            "\1\6\1\uffff\103\7",
            "\103\10",
            "\1\12\1\11",
            "\1\13\103\10",
            "\1\1\4\uffff\1\2\1\uffff\3\2\2\uffff\2\14\40\uffff\1\2\1\uffff"+
            "\1\2",
            "\103\15",
            "\103\7",
            "",
            "\1\16\103\15",
            "\1\11"
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
            return "189:1: embed : ( ( markup )* expression | ( markup )* markup );";
        }
    }
    static final String DFA23_eotS =
        "\17\uffff";
    static final String DFA23_eofS =
        "\17\uffff";
    static final String DFA23_minS =
        "\1\6\1\2\1\13\1\4\1\2\1\4\1\2\1\3\1\4\1\6\1\4\1\3\2\uffff\1\3";
    static final String DFA23_maxS =
        "\1\6\1\2\1\13\3\106\1\3\2\106\1\23\2\106\2\uffff\1\3";
    static final String DFA23_acceptS =
        "\14\uffff\1\1\1\2\1\uffff";
    static final String DFA23_specialS =
        "\17\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\103\4",
            "\1\5\1\uffff\103\6",
            "\103\7",
            "\1\10\1\11",
            "\1\12\103\7",
            "\103\13",
            "\1\14\13\uffff\2\15",
            "\103\6",
            "\1\16\103\13",
            "",
            "",
            "\1\11"
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
            return "()* loopback of 189:31: ( markup )*";
        }
    }
 

    public static final BitSet FOLLOW_40_in_module65 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_moduleId_in_module67 = new BitSet(new long[]{0x0000040000200408L});
    public static final BitSet FOLLOW_imprt_in_module69 = new BitSet(new long[]{0x0000040000200408L});
    public static final BitSet FOLLOW_site_in_module72 = new BitSet(new long[]{0x0000000000200408L});
    public static final BitSet FOLLOW_function_in_module75 = new BitSet(new long[]{0x0000000000000408L});
    public static final BitSet FOLLOW_IDCON_in_moduleId101 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_moduleId107 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDCON_in_moduleId111 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_42_in_imprt134 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_moduleId_in_imprt136 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000000000007FL});
    public static final BitSet FOLLOW_SITE_in_site157 = new BitSet(new long[]{0x0000000000C01000L});
    public static final BitSet FOLLOW_mappings_in_site159 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_END_in_site161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapping_in_mappings169 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_SEMICOLON_in_mappings174 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_mapping_in_mappings176 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_PATH_in_mapping201 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_mapping203 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_markup_in_mapping205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUP_in_markup225 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_markup227 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000000000007FL});
    public static final BitSet FOLLOW_IDCON_in_expression247 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_NATCON_in_expression251 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_TEXT_in_expression255 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_SYMBOLCON_in_expression259 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_52_in_expression268 = new BitSet(new long[]{0x007200000000E800L});
    public static final BitSet FOLLOW_expression_in_expression270 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_49_in_expression275 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_expression277 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_53_in_expression282 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_54_in_expression291 = new BitSet(new long[]{0x0082000000000800L});
    public static final BitSet FOLLOW_keyValuePair_in_expression293 = new BitSet(new long[]{0x0082000000000000L});
    public static final BitSet FOLLOW_49_in_expression298 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_keyValuePair_in_expression300 = new BitSet(new long[]{0x0082000000000000L});
    public static final BitSet FOLLOW_55_in_expression305 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_56_in_expression315 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_expression317 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_41_in_expression323 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDCON_in_expression325 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_IDCON_in_keyValuePair338 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_keyValuePair340 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_keyValuePair342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_function370 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_function374 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_formals_in_function380 = new BitSet(new long[]{0xDA40000000100088L,0x0000000000000001L});
    public static final BitSet FOLLOW_statements_in_function387 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FORMALS_in_formals413 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_formals417 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_statement_in_statements447 = new BitSet(new long[]{0xDA40000000100082L,0x0000000000000001L});
    public static final BitSet FOLLOW_57_in_statement469 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_48_in_statement471 = new BitSet(new long[]{0x005000000000E800L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_statement473 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_statement475 = new BitSet(new long[]{0xDA40000000100080L,0x0000000000000001L});
    public static final BitSet FOLLOW_statement_in_statement479 = new BitSet(new long[]{0x0400000000000008L});
    public static final BitSet FOLLOW_58_in_statement490 = new BitSet(new long[]{0xDA40000000100080L,0x0000000000000001L});
    public static final BitSet FOLLOW_statement_in_statement494 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_59_in_statement511 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_48_in_statement513 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDCON_in_statement515 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_statement517 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_statement519 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_statement521 = new BitSet(new long[]{0xDA40000000100080L,0x0000000000000001L});
    public static final BitSet FOLLOW_statement_in_statement525 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_60_in_statement538 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_assignment_in_statement540 = new BitSet(new long[]{0x2000000000000C00L});
    public static final BitSet FOLLOW_61_in_statement543 = new BitSet(new long[]{0xDA40000000500080L,0x0000000000000001L});
    public static final BitSet FOLLOW_statements_in_statement547 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_END_in_statement549 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_54_in_statement562 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statements_in_statement566 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_statement568 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COMMENT_in_statement581 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRCON_in_statement583 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement585 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_62_in_statement596 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement598 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement600 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_62_in_statement611 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_statement613 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement615 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_63_in_statement626 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement628 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement630 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_64_in_statement639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement650 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement652 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_markupChain_in_statement654 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_CHAIN_in_markupChain676 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_markupChain678 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_markupChain_in_markupChain682 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_CHAIN_in_markupChain695 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_markupChain697 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_markupChain699 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_CHAIN_in_markupChain710 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_markupChain714 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_CHAIN_in_markupChain727 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_markupChain729 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_markupChain731 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_CHAIN_in_markupChain742 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SEMICOLON_in_markupChain744 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDCON_in_assignment761 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_assignment763 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_assignment765 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_assignment767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_assignment777 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_assignment779 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_formals_in_assignment781 = new BitSet(new long[]{0xDA40000000100080L,0x0000000000000001L});
    public static final BitSet FOLLOW_statement_in_assignment783 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_65_in_predicate800 = new BitSet(new long[]{0x005000000000E800L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_predicate802 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000CL});
    public static final BitSet FOLLOW_expression_in_predicate811 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000CL});
    public static final BitSet FOLLOW_expression_in_predicate820 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_predicate822 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000070L});
    public static final BitSet FOLLOW_type_in_predicate824 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000CL});
    public static final BitSet FOLLOW_66_in_predicate834 = new BitSet(new long[]{0x005000000000E800L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_predicate836 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000CL});
    public static final BitSet FOLLOW_67_in_predicate840 = new BitSet(new long[]{0x005000000000E800L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_predicate842 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000CL});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding874 = new BitSet(new long[]{0x005000000000E840L});
    public static final BitSet FOLLOW_embed_in_embedding876 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_textTail_in_embedding878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed887 = new BitSet(new long[]{0x005000000000E840L});
    public static final BitSet FOLLOW_expression_in_embed890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed894 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_markup_in_embed897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail909 = new BitSet(new long[]{0x005000000000E840L});
    public static final BitSet FOLLOW_embed_in_textTail911 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_textTail_in_textTail913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred16_WaebricLoader315 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_synpred16_WaebricLoader317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_synpred17_WaebricLoader323 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDCON_in_synpred17_WaebricLoader325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred37_WaebricLoader811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_synpred38_WaebricLoader834 = new BitSet(new long[]{0x005000000000E800L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_synpred38_WaebricLoader836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_synpred39_WaebricLoader840 = new BitSet(new long[]{0x005000000000E800L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_synpred39_WaebricLoader842 = new BitSet(new long[]{0x0000000000000002L});

}