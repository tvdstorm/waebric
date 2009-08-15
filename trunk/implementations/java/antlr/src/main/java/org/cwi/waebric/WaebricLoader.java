// $ANTLR 3.1.2 /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g 2009-08-15 11:43:54

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATTRIBUTES", "ARGUMENTS", "MARKUP", "MARKUP_STATEMENT", "IDCON", "PATH", "NATCON", "TEXT", "SYMBOLCON", "STRCON", "PRETEXT", "POSTTEXT", "MIDTEXT", "COMMENT", "SITE", "END", "SEMICOLON", "LETTER", "DIGIT", "HEXADECIMAL", "PATHELEMENT", "FILEEXT", "STRCHAR", "ESCLAYOUT", "DECIMAL", "TEXTCHAR", "ESCQUOTE", "AMP", "CHARREF", "ENTREF", "SYMBOLCHAR", "COMMENTS", "LAYOUT", "'module'", "'.'", "'import'", "':'", "'#'", "'$'", "'@'", "'%'", "'('", "','", "')'", "'='", "'['", "']'", "'{'", "'}'", "'+'", "'def'", "'if'", "'else'", "'each'", "'let'", "'in'", "'echo'", "'cdata'", "'yield;'", "'!'", "'&&'", "'||'", "'list'", "'record'", "'string'"
    };
    public static final int ESCLAYOUT=27;
    public static final int T__42=42;
    public static final int END=19;
    public static final int T__57=57;
    public static final int T__51=51;
    public static final int FILEEXT=25;
    public static final int T__47=47;
    public static final int T__50=50;
    public static final int STRCHAR=26;
    public static final int T__65=65;
    public static final int SYMBOLCON=12;
    public static final int COMMENTS=35;
    public static final int IDCON=8;
    public static final int DECIMAL=28;
    public static final int T__67=67;
    public static final int HEXADECIMAL=23;
    public static final int T__39=39;
    public static final int TEXTCHAR=29;
    public static final int T__52=52;
    public static final int T__46=46;
    public static final int T__68=68;
    public static final int T__62=62;
    public static final int MARKUP=6;
    public static final int STRCON=13;
    public static final int T__49=49;
    public static final int AMP=31;
    public static final int T__61=61;
    public static final int POSTTEXT=15;
    public static final int T__59=59;
    public static final int ATTRIBUTES=4;
    public static final int DIGIT=22;
    public static final int T__48=48;
    public static final int T__54=54;
    public static final int LAYOUT=36;
    public static final int ESCQUOTE=30;
    public static final int PATHELEMENT=24;
    public static final int T__56=56;
    public static final int ENTREF=33;
    public static final int LETTER=21;
    public static final int ARGUMENTS=5;
    public static final int SITE=18;
    public static final int T__58=58;
    public static final int T__64=64;
    public static final int T__44=44;
    public static final int T__66=66;
    public static final int SYMBOLCHAR=34;
    public static final int COMMENT=17;
    public static final int MARKUP_STATEMENT=7;
    public static final int T__55=55;
    public static final int T__45=45;
    public static final int CHARREF=32;
    public static final int MIDTEXT=16;
    public static final int T__63=63;
    public static final int PRETEXT=14;
    public static final int T__43=43;
    public static final int SEMICOLON=20;
    public static final int T__40=40;
    public static final int EOF=-1;
    public static final int T__53=53;
    public static final int TEXT=11;
    public static final int T__38=38;
    public static final int NATCON=10;
    public static final int T__37=37;
    public static final int T__60=60;
    public static final int T__41=41;
    public static final int PATH=9;

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
            string_literal1=(CommonTree)match(input,37,FOLLOW_37_in_module65); if (state.failed) return retval;
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

                if ( (LA1_0==39) ) {
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

                if ( (LA3_0==54) ) {
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

                if ( (LA4_0==38) ) {
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
            	    char_literal6=(CommonTree)match(input,38,FOLLOW_38_in_moduleId107); if (state.failed) return retval;
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
            string_literal7=(CommonTree)match(input,39,FOLLOW_39_in_imprt134); if (state.failed) return retval;
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mapping"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:89:1: mapping : PATH ':' markup ;
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

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:89:8: ( PATH ':' markup )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:89:11: PATH ':' markup
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PATH15=(CommonTree)match(input,PATH,FOLLOW_PATH_in_mapping188); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PATH15_tree = (CommonTree)adaptor.dupNode(PATH15);

            adaptor.addChild(root_0, PATH15_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal16=(CommonTree)match(input,40,FOLLOW_40_in_mapping190); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal16_tree = (CommonTree)adaptor.dupNode(char_literal16);

            adaptor.addChild(root_0, char_literal16_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_markup_in_mapping192);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:97:1: markup : ^( MARKUP IDCON . . ) ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:97:7: ( ^( MARKUP IDCON . . ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:97:11: ^( MARKUP IDCON . . )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            MARKUP18=(CommonTree)match(input,MARKUP,FOLLOW_MARKUP_in_markup212); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MARKUP18_tree = (CommonTree)adaptor.dupNode(MARKUP18);

            root_1 = (CommonTree)adaptor.becomeRoot(MARKUP18_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            IDCON19=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_markup214); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:102:1: expression : ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:102:11: ( ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:102:14: ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:102:14: ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' )
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
            case 49:
                {
                alt11=5;
                }
                break;
            case 51:
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:102:16: IDCON
                    {
                    _last = (CommonTree)input.LT(1);
                    IDCON22=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression234); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON22_tree = (CommonTree)adaptor.dupNode(IDCON22);

                    adaptor.addChild(root_0, IDCON22_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:102:24: NATCON
                    {
                    _last = (CommonTree)input.LT(1);
                    NATCON23=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_expression238); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON23_tree = (CommonTree)adaptor.dupNode(NATCON23);

                    adaptor.addChild(root_0, NATCON23_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:102:33: TEXT
                    {
                    _last = (CommonTree)input.LT(1);
                    TEXT24=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_expression242); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TEXT24_tree = (CommonTree)adaptor.dupNode(TEXT24);

                    adaptor.addChild(root_0, TEXT24_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:102:40: SYMBOLCON
                    {
                    _last = (CommonTree)input.LT(1);
                    SYMBOLCON25=(CommonTree)match(input,SYMBOLCON,FOLLOW_SYMBOLCON_in_expression246); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SYMBOLCON25_tree = (CommonTree)adaptor.dupNode(SYMBOLCON25);

                    adaptor.addChild(root_0, SYMBOLCON25_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:103:7: '[' ( expression )? ( ',' expression )* ']'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal26=(CommonTree)match(input,49,FOLLOW_49_in_expression255); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal26_tree = (CommonTree)adaptor.dupNode(char_literal26);

                    adaptor.addChild(root_0, char_literal26_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:103:11: ( expression )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==IDCON||(LA7_0>=NATCON && LA7_0<=SYMBOLCON)||LA7_0==49||LA7_0==51) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: expression
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_expression_in_expression257);
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

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:103:23: ( ',' expression )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==46) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:103:25: ',' expression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal28=(CommonTree)match(input,46,FOLLOW_46_in_expression262); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal28_tree = (CommonTree)adaptor.dupNode(char_literal28);

                    	    adaptor.addChild(root_0, char_literal28_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_expression_in_expression264);
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
                    char_literal30=(CommonTree)match(input,50,FOLLOW_50_in_expression269); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal30_tree = (CommonTree)adaptor.dupNode(char_literal30);

                    adaptor.addChild(root_0, char_literal30_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:104:7: '{' ( keyValuePair )? ( ',' keyValuePair )* '}'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal31=(CommonTree)match(input,51,FOLLOW_51_in_expression278); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal31_tree = (CommonTree)adaptor.dupNode(char_literal31);

                    adaptor.addChild(root_0, char_literal31_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:104:11: ( keyValuePair )?
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
                            pushFollow(FOLLOW_keyValuePair_in_expression280);
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

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:104:25: ( ',' keyValuePair )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==46) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:104:27: ',' keyValuePair
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal33=(CommonTree)match(input,46,FOLLOW_46_in_expression285); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal33_tree = (CommonTree)adaptor.dupNode(char_literal33);

                    	    adaptor.addChild(root_0, char_literal33_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_keyValuePair_in_expression287);
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
                    char_literal35=(CommonTree)match(input,52,FOLLOW_52_in_expression292); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal35_tree = (CommonTree)adaptor.dupNode(char_literal35);

                    adaptor.addChild(root_0, char_literal35_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:105:6: ( '+' expression | '.' IDCON )*
            loop12:
            do {
                int alt12=3;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==53) ) {
                    int LA12_2 = input.LA(2);

                    if ( (synpred16_WaebricLoader()) ) {
                        alt12=1;
                    }


                }
                else if ( (LA12_0==38) ) {
                    int LA12_3 = input.LA(2);

                    if ( (synpred17_WaebricLoader()) ) {
                        alt12=2;
                    }


                }


                switch (alt12) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:105:8: '+' expression
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal36=(CommonTree)match(input,53,FOLLOW_53_in_expression302); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal36_tree = (CommonTree)adaptor.dupNode(char_literal36);

            	    adaptor.addChild(root_0, char_literal36_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expression_in_expression304);
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
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:105:35: '.' IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal38=(CommonTree)match(input,38,FOLLOW_38_in_expression310); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal38_tree = (CommonTree)adaptor.dupNode(char_literal38);

            	    adaptor.addChild(root_0, char_literal38_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    IDCON39=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression312); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:106:1: keyValuePair : IDCON ':' expression ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:106:13: ( IDCON ':' expression )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:106:16: IDCON ':' expression
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON40=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_keyValuePair325); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON40_tree = (CommonTree)adaptor.dupNode(IDCON40);

            adaptor.addChild(root_0, IDCON40_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal41=(CommonTree)match(input,40,FOLLOW_40_in_keyValuePair327); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal41_tree = (CommonTree)adaptor.dupNode(char_literal41);

            adaptor.addChild(root_0, char_literal41_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_keyValuePair329);
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:111:1: function returns [int args = 0] : 'def' id= IDCON ( formals )? ( statement )* 'end' ;
    public final WaebricLoader.function_return function() throws RecognitionException {
        WaebricLoader.function_return retval = new WaebricLoader.function_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        CommonTree string_literal43=null;
        CommonTree string_literal46=null;
        WaebricLoader.formals_return formals44 = null;

        WaebricLoader.statement_return statement45 = null;


        CommonTree id_tree=null;
        CommonTree string_literal43_tree=null;
        CommonTree string_literal46_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:113:2: ( 'def' id= IDCON ( formals )? ( statement )* 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:113:5: 'def' id= IDCON ( formals )? ( statement )* 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal43=(CommonTree)match(input,54,FOLLOW_54_in_function349); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal43_tree = (CommonTree)adaptor.dupNode(string_literal43);

            adaptor.addChild(root_0, string_literal43_tree);
            }
            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_function353); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (CommonTree)adaptor.dupNode(id);

            adaptor.addChild(root_0, id_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:114:4: ( formals )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==45) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:114:6: formals
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_formals_in_function361);
                    formals44=formals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, formals44.getTree());
                    if ( state.backtracking==0 ) {
                       retval.args = (formals44!=null?formals44.args:0); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:115:4: ( statement )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==MARKUP_STATEMENT||LA14_0==COMMENT||LA14_0==51||LA14_0==55||(LA14_0>=57 && LA14_0<=58)||(LA14_0>=60 && LA14_0<=62)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_function371);
            	    statement45=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, statement45.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            string_literal46=(CommonTree)match(input,END,FOLLOW_END_in_function378); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal46_tree = (CommonTree)adaptor.dupNode(string_literal46);

            adaptor.addChild(root_0, string_literal46_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:125:1: formals returns [int args = 0] : '(' ( IDCON )* ')' ;
    public final WaebricLoader.formals_return formals() throws RecognitionException {
        WaebricLoader.formals_return retval = new WaebricLoader.formals_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal47=null;
        CommonTree IDCON48=null;
        CommonTree char_literal49=null;

        CommonTree char_literal47_tree=null;
        CommonTree IDCON48_tree=null;
        CommonTree char_literal49_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:126:2: ( '(' ( IDCON )* ')' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:126:5: '(' ( IDCON )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            char_literal47=(CommonTree)match(input,45,FOLLOW_45_in_formals399); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal47_tree = (CommonTree)adaptor.dupNode(char_literal47);

            adaptor.addChild(root_0, char_literal47_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:126:9: ( IDCON )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==IDCON) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:126:11: IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    IDCON48=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_formals403); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDCON48_tree = (CommonTree)adaptor.dupNode(IDCON48);

            	    adaptor.addChild(root_0, IDCON48_tree);
            	    }
            	    if ( state.backtracking==0 ) {
            	       retval.args++; 
            	    }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            char_literal49=(CommonTree)match(input,47,FOLLOW_47_in_formals410); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal49_tree = (CommonTree)adaptor.dupNode(char_literal49);

            adaptor.addChild(root_0, char_literal49_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:132:1: statement : ( ^( 'if' '(' predicate ')' statement ( 'else' statement )? ) | ^( 'each' '(' IDCON ':' expression ')' statement ) | ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ^( MARKUP_STATEMENT ( markup )+ statement ) | ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) | ^( MARKUP_STATEMENT ( markup )+ ';' ) );
    public final WaebricLoader.statement_return statement() throws RecognitionException {
        WaebricLoader.statement_return retval = new WaebricLoader.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal50=null;
        CommonTree char_literal51=null;
        CommonTree char_literal53=null;
        CommonTree string_literal55=null;
        CommonTree string_literal57=null;
        CommonTree char_literal58=null;
        CommonTree IDCON59=null;
        CommonTree char_literal60=null;
        CommonTree char_literal62=null;
        CommonTree string_literal64=null;
        CommonTree string_literal66=null;
        CommonTree string_literal68=null;
        CommonTree char_literal69=null;
        CommonTree char_literal71=null;
        CommonTree string_literal72=null;
        CommonTree STRCON73=null;
        CommonTree char_literal74=null;
        CommonTree string_literal75=null;
        CommonTree char_literal77=null;
        CommonTree string_literal78=null;
        CommonTree char_literal80=null;
        CommonTree string_literal81=null;
        CommonTree char_literal83=null;
        CommonTree string_literal84=null;
        CommonTree MARKUP_STATEMENT85=null;
        CommonTree char_literal88=null;
        CommonTree MARKUP_STATEMENT89=null;
        CommonTree MARKUP_STATEMENT92=null;
        CommonTree char_literal95=null;
        CommonTree MARKUP_STATEMENT96=null;
        CommonTree char_literal98=null;
        WaebricLoader.predicate_return predicate52 = null;

        WaebricLoader.statement_return statement54 = null;

        WaebricLoader.statement_return statement56 = null;

        WaebricLoader.expression_return expression61 = null;

        WaebricLoader.statement_return statement63 = null;

        WaebricLoader.assignment_return assignment65 = null;

        WaebricLoader.statement_return statement67 = null;

        WaebricLoader.statement_return statement70 = null;

        WaebricLoader.expression_return expression76 = null;

        WaebricLoader.embedding_return embedding79 = null;

        WaebricLoader.expression_return expression82 = null;

        WaebricLoader.markup_return markup86 = null;

        WaebricLoader.expression_return expression87 = null;

        WaebricLoader.markup_return markup90 = null;

        WaebricLoader.statement_return statement91 = null;

        WaebricLoader.markup_return markup93 = null;

        WaebricLoader.embedding_return embedding94 = null;

        WaebricLoader.markup_return markup97 = null;


        CommonTree string_literal50_tree=null;
        CommonTree char_literal51_tree=null;
        CommonTree char_literal53_tree=null;
        CommonTree string_literal55_tree=null;
        CommonTree string_literal57_tree=null;
        CommonTree char_literal58_tree=null;
        CommonTree IDCON59_tree=null;
        CommonTree char_literal60_tree=null;
        CommonTree char_literal62_tree=null;
        CommonTree string_literal64_tree=null;
        CommonTree string_literal66_tree=null;
        CommonTree string_literal68_tree=null;
        CommonTree char_literal69_tree=null;
        CommonTree char_literal71_tree=null;
        CommonTree string_literal72_tree=null;
        CommonTree STRCON73_tree=null;
        CommonTree char_literal74_tree=null;
        CommonTree string_literal75_tree=null;
        CommonTree char_literal77_tree=null;
        CommonTree string_literal78_tree=null;
        CommonTree char_literal80_tree=null;
        CommonTree string_literal81_tree=null;
        CommonTree char_literal83_tree=null;
        CommonTree string_literal84_tree=null;
        CommonTree MARKUP_STATEMENT85_tree=null;
        CommonTree char_literal88_tree=null;
        CommonTree MARKUP_STATEMENT89_tree=null;
        CommonTree MARKUP_STATEMENT92_tree=null;
        CommonTree char_literal95_tree=null;
        CommonTree MARKUP_STATEMENT96_tree=null;
        CommonTree char_literal98_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:133:2: ( ^( 'if' '(' predicate ')' statement ( 'else' statement )? ) | ^( 'each' '(' IDCON ':' expression ')' statement ) | ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ^( MARKUP_STATEMENT ( markup )+ statement ) | ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) | ^( MARKUP_STATEMENT ( markup )+ ';' ) )
            int alt24=13;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:133:5: ^( 'if' '(' predicate ')' statement ( 'else' statement )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal50=(CommonTree)match(input,55,FOLLOW_55_in_statement427); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal50_tree = (CommonTree)adaptor.dupNode(string_literal50);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal50_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    char_literal51=(CommonTree)match(input,45,FOLLOW_45_in_statement429); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal51_tree = (CommonTree)adaptor.dupNode(char_literal51);

                    adaptor.addChild(root_1, char_literal51_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_statement431);
                    predicate52=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, predicate52.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal53=(CommonTree)match(input,47,FOLLOW_47_in_statement433); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal53_tree = (CommonTree)adaptor.dupNode(char_literal53);

                    adaptor.addChild(root_1, char_literal53_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement435);
                    statement54=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement54.getTree());
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:133:41: ( 'else' statement )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==56) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:133:43: 'else' statement
                            {
                            _last = (CommonTree)input.LT(1);
                            string_literal55=(CommonTree)match(input,56,FOLLOW_56_in_statement439); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal55_tree = (CommonTree)adaptor.dupNode(string_literal55);

                            adaptor.addChild(root_1, string_literal55_tree);
                            }
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_statement_in_statement441);
                            statement56=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, statement56.getTree());

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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:134:6: ^( 'each' '(' IDCON ':' expression ')' statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal57=(CommonTree)match(input,57,FOLLOW_57_in_statement455); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal57_tree = (CommonTree)adaptor.dupNode(string_literal57);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal57_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    char_literal58=(CommonTree)match(input,45,FOLLOW_45_in_statement457); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal58_tree = (CommonTree)adaptor.dupNode(char_literal58);

                    adaptor.addChild(root_1, char_literal58_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON59=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_statement459); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON59_tree = (CommonTree)adaptor.dupNode(IDCON59);

                    adaptor.addChild(root_1, IDCON59_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal60=(CommonTree)match(input,40,FOLLOW_40_in_statement461); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal60_tree = (CommonTree)adaptor.dupNode(char_literal60);

                    adaptor.addChild(root_1, char_literal60_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement463);
                    expression61=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression61.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal62=(CommonTree)match(input,47,FOLLOW_47_in_statement465); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal62_tree = (CommonTree)adaptor.dupNode(char_literal62);

                    adaptor.addChild(root_1, char_literal62_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement467);
                    statement63=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement63.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:135:6: ^( 'let' ( assignment )+ 'in' ( statement )* 'end' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal64=(CommonTree)match(input,58,FOLLOW_58_in_statement478); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal64_tree = (CommonTree)adaptor.dupNode(string_literal64);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal64_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:135:15: ( assignment )+
                    int cnt17=0;
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==IDCON||LA17_0==54) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: assignment
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_assignment_in_statement480);
                    	    assignment65=assignment();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, assignment65.getTree());

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
                    string_literal66=(CommonTree)match(input,59,FOLLOW_59_in_statement483); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal66_tree = (CommonTree)adaptor.dupNode(string_literal66);

                    adaptor.addChild(root_1, string_literal66_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:135:32: ( statement )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==MARKUP_STATEMENT||LA18_0==COMMENT||LA18_0==51||LA18_0==55||(LA18_0>=57 && LA18_0<=58)||(LA18_0>=60 && LA18_0<=62)) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: statement
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_statement_in_statement485);
                    	    statement67=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, statement67.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    string_literal68=(CommonTree)match(input,END,FOLLOW_END_in_statement488); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal68_tree = (CommonTree)adaptor.dupNode(string_literal68);

                    adaptor.addChild(root_1, string_literal68_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:136:6: ^( '{' ( statement )* '}' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal69=(CommonTree)match(input,51,FOLLOW_51_in_statement499); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal69_tree = (CommonTree)adaptor.dupNode(char_literal69);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal69_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:136:13: ( statement )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==MARKUP_STATEMENT||LA19_0==COMMENT||LA19_0==51||LA19_0==55||(LA19_0>=57 && LA19_0<=58)||(LA19_0>=60 && LA19_0<=62)) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: statement
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_statement_in_statement501);
                    	    statement70=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, statement70.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal71=(CommonTree)match(input,52,FOLLOW_52_in_statement504); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal71_tree = (CommonTree)adaptor.dupNode(char_literal71);

                    adaptor.addChild(root_1, char_literal71_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:137:6: ^( 'comment' STRCON ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal72=(CommonTree)match(input,COMMENT,FOLLOW_COMMENT_in_statement515); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal72_tree = (CommonTree)adaptor.dupNode(string_literal72);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal72_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    STRCON73=(CommonTree)match(input,STRCON,FOLLOW_STRCON_in_statement517); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRCON73_tree = (CommonTree)adaptor.dupNode(STRCON73);

                    adaptor.addChild(root_1, STRCON73_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal74=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement519); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal74_tree = (CommonTree)adaptor.dupNode(char_literal74);

                    adaptor.addChild(root_1, char_literal74_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:138:6: ^( 'echo' expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal75=(CommonTree)match(input,60,FOLLOW_60_in_statement530); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal75_tree = (CommonTree)adaptor.dupNode(string_literal75);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal75_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement532);
                    expression76=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression76.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal77=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement534); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal77_tree = (CommonTree)adaptor.dupNode(char_literal77);

                    adaptor.addChild(root_1, char_literal77_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:139:6: ^( 'echo' embedding ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal78=(CommonTree)match(input,60,FOLLOW_60_in_statement545); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal78_tree = (CommonTree)adaptor.dupNode(string_literal78);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal78_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement547);
                    embedding79=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding79.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal80=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement549); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal80_tree = (CommonTree)adaptor.dupNode(char_literal80);

                    adaptor.addChild(root_1, char_literal80_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:140:6: ^( 'cdata' expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal81=(CommonTree)match(input,61,FOLLOW_61_in_statement560); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal81_tree = (CommonTree)adaptor.dupNode(string_literal81);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal81_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement562);
                    expression82=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression82.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal83=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement564); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal83_tree = (CommonTree)adaptor.dupNode(char_literal83);

                    adaptor.addChild(root_1, char_literal83_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:141:6: 'yield;'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal84=(CommonTree)match(input,62,FOLLOW_62_in_statement573); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal84_tree = (CommonTree)adaptor.dupNode(string_literal84);

                    adaptor.addChild(root_0, string_literal84_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:142:6: ^( MARKUP_STATEMENT ( markup )+ expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT85=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement582); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT85_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT85);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT85_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:142:26: ( markup )+
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
                    	    pushFollow(FOLLOW_markup_in_statement584);
                    	    markup86=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup86.getTree());

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
                    pushFollow(FOLLOW_expression_in_statement587);
                    expression87=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression87.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal88=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement589); if (state.failed) return retval;
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
                case 11 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:143:6: ^( MARKUP_STATEMENT ( markup )+ statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT89=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement600); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT89_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT89);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT89_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:143:26: ( markup )+
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
                    	    pushFollow(FOLLOW_markup_in_statement602);
                    	    markup90=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup90.getTree());

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
                    pushFollow(FOLLOW_statement_in_statement605);
                    statement91=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement91.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:144:6: ^( MARKUP_STATEMENT ( markup )+ embedding ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT92=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement616); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT92_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT92);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT92_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:144:26: ( markup )+
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
                    	    pushFollow(FOLLOW_markup_in_statement618);
                    	    markup93=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup93.getTree());

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
                    pushFollow(FOLLOW_embedding_in_statement621);
                    embedding94=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding94.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal95=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement623); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal95_tree = (CommonTree)adaptor.dupNode(char_literal95);

                    adaptor.addChild(root_1, char_literal95_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:145:6: ^( MARKUP_STATEMENT ( markup )+ ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT96=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement634); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT96_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT96);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT96_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:145:26: ( markup )+
                    int cnt23=0;
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
                    	    pushFollow(FOLLOW_markup_in_statement636);
                    	    markup97=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup97.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt23 >= 1 ) break loop23;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(23, input);
                                throw eee;
                        }
                        cnt23++;
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal98=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement639); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal98_tree = (CommonTree)adaptor.dupNode(char_literal98);

                    adaptor.addChild(root_1, char_literal98_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:150:1: assignment : ( IDCON '=' expression ';' | 'def' IDCON formals statement 'end' );
    public final WaebricLoader.assignment_return assignment() throws RecognitionException {
        WaebricLoader.assignment_return retval = new WaebricLoader.assignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON99=null;
        CommonTree char_literal100=null;
        CommonTree char_literal102=null;
        CommonTree string_literal103=null;
        CommonTree IDCON104=null;
        CommonTree string_literal107=null;
        WaebricLoader.expression_return expression101 = null;

        WaebricLoader.formals_return formals105 = null;

        WaebricLoader.statement_return statement106 = null;


        CommonTree IDCON99_tree=null;
        CommonTree char_literal100_tree=null;
        CommonTree char_literal102_tree=null;
        CommonTree string_literal103_tree=null;
        CommonTree IDCON104_tree=null;
        CommonTree string_literal107_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:150:11: ( IDCON '=' expression ';' | 'def' IDCON formals statement 'end' )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==IDCON) ) {
                alt25=1;
            }
            else if ( (LA25_0==54) ) {
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:150:14: IDCON '=' expression ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDCON99=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_assignment653); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON99_tree = (CommonTree)adaptor.dupNode(IDCON99);

                    adaptor.addChild(root_0, IDCON99_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal100=(CommonTree)match(input,48,FOLLOW_48_in_assignment655); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal100_tree = (CommonTree)adaptor.dupNode(char_literal100);

                    adaptor.addChild(root_0, char_literal100_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_assignment657);
                    expression101=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression101.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal102=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_assignment659); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal102_tree = (CommonTree)adaptor.dupNode(char_literal102);

                    adaptor.addChild(root_0, char_literal102_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:151:6: 'def' IDCON formals statement 'end'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal103=(CommonTree)match(input,54,FOLLOW_54_in_assignment667); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal103_tree = (CommonTree)adaptor.dupNode(string_literal103);

                    adaptor.addChild(root_0, string_literal103_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON104=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_assignment669); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON104_tree = (CommonTree)adaptor.dupNode(IDCON104);

                    adaptor.addChild(root_0, IDCON104_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_formals_in_assignment671);
                    formals105=formals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, formals105.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_assignment673);
                    statement106=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, statement106.getTree());
                    _last = (CommonTree)input.LT(1);
                    string_literal107=(CommonTree)match(input,END,FOLLOW_END_in_assignment675); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal107_tree = (CommonTree)adaptor.dupNode(string_literal107);

                    adaptor.addChild(root_0, string_literal107_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:156:1: predicate : ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )* ;
    public final WaebricLoader.predicate_return predicate() throws RecognitionException {
        WaebricLoader.predicate_return retval = new WaebricLoader.predicate_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal108=null;
        CommonTree char_literal112=null;
        CommonTree string_literal114=null;
        CommonTree string_literal116=null;
        WaebricLoader.predicate_return predicate109 = null;

        WaebricLoader.expression_return expression110 = null;

        WaebricLoader.expression_return expression111 = null;

        WaebricLoader.type_return type113 = null;

        WaebricLoader.predicate_return predicate115 = null;

        WaebricLoader.predicate_return predicate117 = null;


        CommonTree char_literal108_tree=null;
        CommonTree char_literal112_tree=null;
        CommonTree string_literal114_tree=null;
        CommonTree string_literal116_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:156:10: ( ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:156:13: ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:156:13: ( '!' predicate | expression | expression '.' type )
            int alt26=3;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:156:15: '!' predicate
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal108=(CommonTree)match(input,63,FOLLOW_63_in_predicate690); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal108_tree = (CommonTree)adaptor.dupNode(char_literal108);

                    adaptor.addChild(root_0, char_literal108_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_predicate692);
                    predicate109=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, predicate109.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:157:7: expression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate701);
                    expression110=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression110.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:158:7: expression '.' type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate710);
                    expression111=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression111.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal112=(CommonTree)match(input,38,FOLLOW_38_in_predicate712); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal112_tree = (CommonTree)adaptor.dupNode(char_literal112);

                    adaptor.addChild(root_0, char_literal112_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_predicate714);
                    type113=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, type113.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:159:6: ( '&&' predicate | '||' predicate )*
            loop27:
            do {
                int alt27=3;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==64) ) {
                    int LA27_2 = input.LA(2);

                    if ( (synpred44_WaebricLoader()) ) {
                        alt27=1;
                    }


                }
                else if ( (LA27_0==65) ) {
                    int LA27_3 = input.LA(2);

                    if ( (synpred45_WaebricLoader()) ) {
                        alt27=2;
                    }


                }


                switch (alt27) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:159:8: '&&' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal114=(CommonTree)match(input,64,FOLLOW_64_in_predicate724); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal114_tree = (CommonTree)adaptor.dupNode(string_literal114);

            	    adaptor.addChild(root_0, string_literal114_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate726);
            	    predicate115=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, predicate115.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:159:25: '||' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal116=(CommonTree)match(input,65,FOLLOW_65_in_predicate730); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal116_tree = (CommonTree)adaptor.dupNode(string_literal116);

            	    adaptor.addChild(root_0, string_literal116_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate732);
            	    predicate117=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, predicate117.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop27;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:160:1: type : ( 'list' | 'record' | 'string' );
    public final WaebricLoader.type_return type() throws RecognitionException {
        WaebricLoader.type_return retval = new WaebricLoader.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set118=null;

        CommonTree set118_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:160:5: ( 'list' | 'record' | 'string' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            set118=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=66 && input.LA(1)<=68) ) {
                input.consume();

                if ( state.backtracking==0 ) {
                set118_tree = (CommonTree)adaptor.dupNode(set118);

                adaptor.addChild(root_0, set118_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:165:1: embedding : PRETEXT embed textTail ;
    public final WaebricLoader.embedding_return embedding() throws RecognitionException {
        WaebricLoader.embedding_return retval = new WaebricLoader.embedding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PRETEXT119=null;
        WaebricLoader.embed_return embed120 = null;

        WaebricLoader.textTail_return textTail121 = null;


        CommonTree PRETEXT119_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:165:10: ( PRETEXT embed textTail )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:165:13: PRETEXT embed textTail
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PRETEXT119=(CommonTree)match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding764); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRETEXT119_tree = (CommonTree)adaptor.dupNode(PRETEXT119);

            adaptor.addChild(root_0, PRETEXT119_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_embed_in_embedding766);
            embed120=embed();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, embed120.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_textTail_in_embedding768);
            textTail121=textTail();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, textTail121.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:166:1: embed : ( ( markup )* expression | ( markup )* markup );
    public final WaebricLoader.embed_return embed() throws RecognitionException {
        WaebricLoader.embed_return retval = new WaebricLoader.embed_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricLoader.markup_return markup122 = null;

        WaebricLoader.expression_return expression123 = null;

        WaebricLoader.markup_return markup124 = null;

        WaebricLoader.markup_return markup125 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:166:6: ( ( markup )* expression | ( markup )* markup )
            int alt30=2;
            alt30 = dfa30.predict(input);
            switch (alt30) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:166:10: ( markup )* expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:166:10: ( markup )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==MARKUP) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed777);
                    	    markup122=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup122.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_embed780);
                    expression123=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression123.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:166:31: ( markup )* markup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:166:31: ( markup )*
                    loop29:
                    do {
                        int alt29=2;
                        alt29 = dfa29.predict(input);
                        switch (alt29) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed784);
                    	    markup124=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup124.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_embed787);
                    markup125=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, markup125.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:167:1: textTail : ( POSTTEXT | MIDTEXT embed textTail );
    public final WaebricLoader.textTail_return textTail() throws RecognitionException {
        WaebricLoader.textTail_return retval = new WaebricLoader.textTail_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POSTTEXT126=null;
        CommonTree MIDTEXT127=null;
        WaebricLoader.embed_return embed128 = null;

        WaebricLoader.textTail_return textTail129 = null;


        CommonTree POSTTEXT126_tree=null;
        CommonTree MIDTEXT127_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:167:9: ( POSTTEXT | MIDTEXT embed textTail )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==POSTTEXT) ) {
                alt31=1;
            }
            else if ( (LA31_0==MIDTEXT) ) {
                alt31=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:167:12: POSTTEXT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    POSTTEXT126=(CommonTree)match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail795); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    POSTTEXT126_tree = (CommonTree)adaptor.dupNode(POSTTEXT126);

                    adaptor.addChild(root_0, POSTTEXT126_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:167:23: MIDTEXT embed textTail
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    MIDTEXT127=(CommonTree)match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail799); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MIDTEXT127_tree = (CommonTree)adaptor.dupNode(MIDTEXT127);

                    adaptor.addChild(root_0, MIDTEXT127_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embed_in_textTail801);
                    embed128=embed();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, embed128.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_textTail_in_textTail803);
                    textTail129=textTail();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, textTail129.getTree());

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
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:105:8: ( '+' expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:105:8: '+' expression
        {
        match(input,53,FOLLOW_53_in_synpred16_WaebricLoader302); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred16_WaebricLoader304);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_WaebricLoader

    // $ANTLR start synpred17_WaebricLoader
    public final void synpred17_WaebricLoader_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:105:35: ( '.' IDCON )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:105:35: '.' IDCON
        {
        match(input,38,FOLLOW_38_in_synpred17_WaebricLoader310); if (state.failed) return ;
        match(input,IDCON,FOLLOW_IDCON_in_synpred17_WaebricLoader312); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_WaebricLoader

    // $ANTLR start synpred43_WaebricLoader
    public final void synpred43_WaebricLoader_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:157:7: ( expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:157:7: expression
        {
        pushFollow(FOLLOW_expression_in_synpred43_WaebricLoader701);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred43_WaebricLoader

    // $ANTLR start synpred44_WaebricLoader
    public final void synpred44_WaebricLoader_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:159:8: ( '&&' predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:159:8: '&&' predicate
        {
        match(input,64,FOLLOW_64_in_synpred44_WaebricLoader724); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred44_WaebricLoader726);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred44_WaebricLoader

    // $ANTLR start synpred45_WaebricLoader
    public final void synpred45_WaebricLoader_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:159:25: ( '||' predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricLoader.g:159:25: '||' predicate
        {
        match(input,65,FOLLOW_65_in_synpred45_WaebricLoader730); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred45_WaebricLoader732);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred45_WaebricLoader

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
    public final boolean synpred45_WaebricLoader() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_WaebricLoader_fragment(); // can never throw exception
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


    protected DFA24 dfa24 = new DFA24(this);
    protected DFA26 dfa26 = new DFA26(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA29 dfa29 = new DFA29(this);
    static final String DFA24_eotS =
        "\37\uffff";
    static final String DFA24_eofS =
        "\37\uffff";
    static final String DFA24_minS =
        "\1\7\5\uffff\1\2\2\uffff\1\2\1\10\1\6\2\uffff\1\2\1\10\1\4\2\2\2"+
        "\4\1\6\2\3\1\uffff\1\2\3\uffff\1\4\1\3";
    static final String DFA24_maxS =
        "\1\76\5\uffff\1\2\2\uffff\1\2\1\63\1\6\2\uffff\1\2\1\10\2\104\1"+
        "\3\2\104\1\76\2\104\1\uffff\1\64\3\uffff\1\104\1\3";
    static final String DFA24_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\11\3\uffff\1\7\1\6\12"+
        "\uffff\1\13\1\uffff\1\15\1\14\1\12\2\uffff";
    static final String DFA24_specialS =
        "\37\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\11\11\uffff\1\5\41\uffff\1\4\3\uffff\1\1\1\uffff\1\2\1\3"+
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
            "\1\15\1\uffff\3\15\1\uffff\1\14\42\uffff\1\15\1\uffff\1\15",
            "\1\16",
            "",
            "",
            "\1\17",
            "\1\20",
            "\101\21",
            "\1\23\1\uffff\101\22",
            "\1\24\1\25",
            "\101\26",
            "\101\27",
            "\1\16\1\30\1\34\1\uffff\3\34\1\uffff\1\33\2\uffff\1\30\2\uffff"+
            "\1\32\34\uffff\1\34\1\uffff\1\31\3\uffff\1\30\1\uffff\2\30\1"+
            "\uffff\3\30",
            "\1\35\101\26",
            "\1\36\101\27",
            "",
            "\1\30\5\uffff\1\34\45\uffff\1\34\5\uffff\1\34",
            "",
            "",
            "",
            "\101\22",
            "\1\25"
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
            return "132:1: statement : ( ^( 'if' '(' predicate ')' statement ( 'else' statement )? ) | ^( 'each' '(' IDCON ':' expression ')' statement ) | ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ^( MARKUP_STATEMENT ( markup )+ statement ) | ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) | ^( MARKUP_STATEMENT ( markup )+ ';' ) );";
        }
    }
    static final String DFA26_eotS =
        "\12\uffff";
    static final String DFA26_eofS =
        "\12\uffff";
    static final String DFA26_minS =
        "\1\10\1\uffff\6\0\2\uffff";
    static final String DFA26_maxS =
        "\1\77\1\uffff\6\0\2\uffff";
    static final String DFA26_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\1\3";
    static final String DFA26_specialS =
        "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\2\uffff}>";
    static final String[] DFA26_transitionS = {
            "\1\2\1\uffff\1\3\1\4\1\5\44\uffff\1\6\1\uffff\1\7\13\uffff\1"+
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

    static final short[] DFA26_eot = DFA.unpackEncodedString(DFA26_eotS);
    static final short[] DFA26_eof = DFA.unpackEncodedString(DFA26_eofS);
    static final char[] DFA26_min = DFA.unpackEncodedStringToUnsignedChars(DFA26_minS);
    static final char[] DFA26_max = DFA.unpackEncodedStringToUnsignedChars(DFA26_maxS);
    static final short[] DFA26_accept = DFA.unpackEncodedString(DFA26_acceptS);
    static final short[] DFA26_special = DFA.unpackEncodedString(DFA26_specialS);
    static final short[][] DFA26_transition;

    static {
        int numStates = DFA26_transitionS.length;
        DFA26_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA26_transition[i] = DFA.unpackEncodedString(DFA26_transitionS[i]);
        }
    }

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = DFA26_eot;
            this.eof = DFA26_eof;
            this.min = DFA26_min;
            this.max = DFA26_max;
            this.accept = DFA26_accept;
            this.special = DFA26_special;
            this.transition = DFA26_transition;
        }
        public String getDescription() {
            return "156:13: ( '!' predicate | expression | expression '.' type )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TreeNodeStream input = (TreeNodeStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA26_2 = input.LA(1);

                         
                        int index26_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_WaebricLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index26_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA26_3 = input.LA(1);

                         
                        int index26_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_WaebricLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index26_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA26_4 = input.LA(1);

                         
                        int index26_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_WaebricLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index26_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA26_5 = input.LA(1);

                         
                        int index26_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_WaebricLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index26_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA26_6 = input.LA(1);

                         
                        int index26_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_WaebricLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index26_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA26_7 = input.LA(1);

                         
                        int index26_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_WaebricLoader()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index26_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 26, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA30_eotS =
        "\17\uffff";
    static final String DFA30_eofS =
        "\17\uffff";
    static final String DFA30_minS =
        "\1\6\1\2\1\uffff\1\10\1\4\2\2\1\4\1\6\1\4\1\3\1\uffff\1\3\1\4\1"+
        "\3";
    static final String DFA30_maxS =
        "\1\63\1\2\1\uffff\1\10\2\104\1\3\1\104\1\63\2\104\1\uffff\2\104"+
        "\1\3";
    static final String DFA30_acceptS =
        "\2\uffff\1\1\10\uffff\1\2\3\uffff";
    static final String DFA30_specialS =
        "\17\uffff}>";
    static final String[] DFA30_transitionS = {
            "\1\1\1\uffff\1\2\1\uffff\3\2\44\uffff\1\2\1\uffff\1\2",
            "\1\3",
            "",
            "\1\4",
            "\101\5",
            "\1\7\1\uffff\101\6",
            "\1\11\1\10",
            "\101\12",
            "\1\1\1\uffff\1\2\1\uffff\3\2\2\uffff\2\13\40\uffff\1\2\1\uffff"+
            "\1\2",
            "\101\14",
            "\1\15\101\12",
            "",
            "\1\16\101\14",
            "\101\6",
            "\1\10"
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
            return "166:1: embed : ( ( markup )* expression | ( markup )* markup );";
        }
    }
    static final String DFA29_eotS =
        "\17\uffff";
    static final String DFA29_eofS =
        "\17\uffff";
    static final String DFA29_minS =
        "\1\6\1\2\1\10\1\4\2\2\2\4\1\6\2\3\2\uffff\1\4\1\3";
    static final String DFA29_maxS =
        "\1\6\1\2\1\10\2\104\1\3\2\104\1\20\2\104\2\uffff\1\104\1\3";
    static final String DFA29_acceptS =
        "\13\uffff\1\1\1\2\2\uffff";
    static final String DFA29_specialS =
        "\17\uffff}>";
    static final String[] DFA29_transitionS = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\101\4",
            "\1\6\1\uffff\101\5",
            "\1\7\1\10",
            "\101\11",
            "\101\12",
            "\1\13\10\uffff\2\14",
            "\1\15\101\11",
            "\1\16\101\12",
            "",
            "",
            "\101\5",
            "\1\10"
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
            return "()* loopback of 166:31: ( markup )*";
        }
    }
 

    public static final BitSet FOLLOW_37_in_module65 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_moduleId_in_module67 = new BitSet(new long[]{0x0040008000040008L});
    public static final BitSet FOLLOW_imprt_in_module69 = new BitSet(new long[]{0x0040008000040008L});
    public static final BitSet FOLLOW_site_in_module72 = new BitSet(new long[]{0x0040000000040008L});
    public static final BitSet FOLLOW_function_in_module75 = new BitSet(new long[]{0x0040000000000008L});
    public static final BitSet FOLLOW_IDCON_in_moduleId101 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_moduleId107 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDCON_in_moduleId111 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_39_in_imprt134 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_moduleId_in_imprt136 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000000000001FL});
    public static final BitSet FOLLOW_SITE_in_site157 = new BitSet(new long[]{0x0000000000180200L});
    public static final BitSet FOLLOW_mappings_in_site159 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_END_in_site161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapping_in_mappings169 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_SEMICOLON_in_mappings174 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_mapping_in_mappings176 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_PATH_in_mapping188 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_mapping190 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_markup_in_mapping192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUP_in_markup212 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_markup214 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000000000001FL});
    public static final BitSet FOLLOW_IDCON_in_expression234 = new BitSet(new long[]{0x0020004000000002L});
    public static final BitSet FOLLOW_NATCON_in_expression238 = new BitSet(new long[]{0x0020004000000002L});
    public static final BitSet FOLLOW_TEXT_in_expression242 = new BitSet(new long[]{0x0020004000000002L});
    public static final BitSet FOLLOW_SYMBOLCON_in_expression246 = new BitSet(new long[]{0x0020004000000002L});
    public static final BitSet FOLLOW_49_in_expression255 = new BitSet(new long[]{0x000E400000001D00L});
    public static final BitSet FOLLOW_expression_in_expression257 = new BitSet(new long[]{0x0004400000000000L});
    public static final BitSet FOLLOW_46_in_expression262 = new BitSet(new long[]{0x000A000000001D00L});
    public static final BitSet FOLLOW_expression_in_expression264 = new BitSet(new long[]{0x0004400000000000L});
    public static final BitSet FOLLOW_50_in_expression269 = new BitSet(new long[]{0x0020004000000002L});
    public static final BitSet FOLLOW_51_in_expression278 = new BitSet(new long[]{0x0010400000000100L});
    public static final BitSet FOLLOW_keyValuePair_in_expression280 = new BitSet(new long[]{0x0010400000000000L});
    public static final BitSet FOLLOW_46_in_expression285 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_keyValuePair_in_expression287 = new BitSet(new long[]{0x0010400000000000L});
    public static final BitSet FOLLOW_52_in_expression292 = new BitSet(new long[]{0x0020004000000002L});
    public static final BitSet FOLLOW_53_in_expression302 = new BitSet(new long[]{0x000A000000001D00L});
    public static final BitSet FOLLOW_expression_in_expression304 = new BitSet(new long[]{0x0020004000000002L});
    public static final BitSet FOLLOW_38_in_expression310 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDCON_in_expression312 = new BitSet(new long[]{0x0020004000000002L});
    public static final BitSet FOLLOW_IDCON_in_keyValuePair325 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_keyValuePair327 = new BitSet(new long[]{0x000A000000001D00L});
    public static final BitSet FOLLOW_expression_in_keyValuePair329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_function349 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDCON_in_function353 = new BitSet(new long[]{0x76882000000A0080L});
    public static final BitSet FOLLOW_formals_in_function361 = new BitSet(new long[]{0x76880000000A0080L});
    public static final BitSet FOLLOW_statement_in_function371 = new BitSet(new long[]{0x76880000000A0080L});
    public static final BitSet FOLLOW_END_in_function378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_formals399 = new BitSet(new long[]{0x0000800000000100L});
    public static final BitSet FOLLOW_IDCON_in_formals403 = new BitSet(new long[]{0x0000800000000100L});
    public static final BitSet FOLLOW_47_in_formals410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_statement427 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_45_in_statement429 = new BitSet(new long[]{0x800A000000001D00L});
    public static final BitSet FOLLOW_predicate_in_statement431 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_statement433 = new BitSet(new long[]{0x7688000000020080L});
    public static final BitSet FOLLOW_statement_in_statement435 = new BitSet(new long[]{0x0100000000000008L});
    public static final BitSet FOLLOW_56_in_statement439 = new BitSet(new long[]{0x7688000000020080L});
    public static final BitSet FOLLOW_statement_in_statement441 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_57_in_statement455 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_45_in_statement457 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDCON_in_statement459 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_statement461 = new BitSet(new long[]{0x000A000000001D00L});
    public static final BitSet FOLLOW_expression_in_statement463 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_statement465 = new BitSet(new long[]{0x7688000000020080L});
    public static final BitSet FOLLOW_statement_in_statement467 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_58_in_statement478 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_assignment_in_statement480 = new BitSet(new long[]{0x0840000000000100L});
    public static final BitSet FOLLOW_59_in_statement483 = new BitSet(new long[]{0x76880000000A0080L});
    public static final BitSet FOLLOW_statement_in_statement485 = new BitSet(new long[]{0x76880000000A0080L});
    public static final BitSet FOLLOW_END_in_statement488 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_51_in_statement499 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statement501 = new BitSet(new long[]{0x7698000000020080L});
    public static final BitSet FOLLOW_52_in_statement504 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COMMENT_in_statement515 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRCON_in_statement517 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement519 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_60_in_statement530 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement532 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement534 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_60_in_statement545 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_statement547 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement549 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_61_in_statement560 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement562 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement564 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_62_in_statement573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement582 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement584 = new BitSet(new long[]{0x000A000000001D40L});
    public static final BitSet FOLLOW_expression_in_statement587 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement589 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement600 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement602 = new BitSet(new long[]{0x76880000000200C0L});
    public static final BitSet FOLLOW_statement_in_statement605 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement616 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement618 = new BitSet(new long[]{0x0000000000004040L});
    public static final BitSet FOLLOW_embedding_in_statement621 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement623 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement634 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement636 = new BitSet(new long[]{0x0000000000100040L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement639 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDCON_in_assignment653 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_assignment655 = new BitSet(new long[]{0x000A000000001D00L});
    public static final BitSet FOLLOW_expression_in_assignment657 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SEMICOLON_in_assignment659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_assignment667 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDCON_in_assignment669 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_formals_in_assignment671 = new BitSet(new long[]{0x7688000000020080L});
    public static final BitSet FOLLOW_statement_in_assignment673 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_END_in_assignment675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_predicate690 = new BitSet(new long[]{0x800A000000001D00L});
    public static final BitSet FOLLOW_predicate_in_predicate692 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000003L});
    public static final BitSet FOLLOW_expression_in_predicate701 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000003L});
    public static final BitSet FOLLOW_expression_in_predicate710 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_predicate712 = new BitSet(new long[]{0x0000000000000000L,0x000000000000001CL});
    public static final BitSet FOLLOW_type_in_predicate714 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000003L});
    public static final BitSet FOLLOW_64_in_predicate724 = new BitSet(new long[]{0x800A000000001D00L});
    public static final BitSet FOLLOW_predicate_in_predicate726 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000003L});
    public static final BitSet FOLLOW_65_in_predicate730 = new BitSet(new long[]{0x800A000000001D00L});
    public static final BitSet FOLLOW_predicate_in_predicate732 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000003L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding764 = new BitSet(new long[]{0x000A000000001D40L});
    public static final BitSet FOLLOW_embed_in_embedding766 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_textTail_in_embedding768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed777 = new BitSet(new long[]{0x000A000000001D40L});
    public static final BitSet FOLLOW_expression_in_embed780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed784 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_markup_in_embed787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail799 = new BitSet(new long[]{0x000A000000001D40L});
    public static final BitSet FOLLOW_embed_in_textTail801 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_textTail_in_textTail803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_synpred16_WaebricLoader302 = new BitSet(new long[]{0x000A000000001D00L});
    public static final BitSet FOLLOW_expression_in_synpred16_WaebricLoader304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_synpred17_WaebricLoader310 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDCON_in_synpred17_WaebricLoader312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred43_WaebricLoader701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_synpred44_WaebricLoader724 = new BitSet(new long[]{0x800A000000001D00L});
    public static final BitSet FOLLOW_predicate_in_synpred44_WaebricLoader726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_synpred45_WaebricLoader730 = new BitSet(new long[]{0x800A000000001D00L});
    public static final BitSet FOLLOW_predicate_in_synpred45_WaebricLoader732 = new BitSet(new long[]{0x0000000000000002L});

}