// $ANTLR 3.1.2 /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g 2009-08-20 23:15:23

	package org.cwi.waebric;
	import java.util.ArrayList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class WaebricParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATTRIBUTES", "ARGUMENTS", "MARKUP", "MARKUP_STATEMENT", "MARKUP_CHAIN", "FORMALS", "FUNCTION", "IDCON", "PATH", "NATCON", "TEXT", "SYMBOLCON", "STRCON", "PRETEXT", "POSTTEXT", "MIDTEXT", "COMMENT", "SITE", "END", "SEMICOLON", "LETTER", "DIGIT", "HEXADECIMAL", "PATHELEMENT", "FILEEXT", "STRCHAR", "ESCLAYOUT", "DECIMAL", "TEXTCHAR", "ESCQUOTE", "AMP", "CHARREF", "ENTREF", "SYMBOLCHAR", "COMMENTS", "LAYOUT", "'module'", "'.'", "'import'", "':'", "'#'", "'$'", "'@'", "'%'", "'('", "','", "')'", "'='", "'['", "']'", "'{'", "'}'", "'+'", "'if'", "'else'", "'each'", "'let'", "'in'", "'echo'", "'cdata'", "'yield;'", "'!'", "'?'", "'&&'", "'||'", "'list'", "'record'", "'string'"
    };
    public static final int ESCLAYOUT=30;
    public static final int T__42=42;
    public static final int END=22;
    public static final int T__57=57;
    public static final int FILEEXT=28;
    public static final int T__51=51;
    public static final int T__47=47;
    public static final int T__69=69;
    public static final int STRCHAR=29;
    public static final int T__50=50;
    public static final int T__65=65;
    public static final int SYMBOLCON=15;
    public static final int COMMENTS=38;
    public static final int DECIMAL=31;
    public static final int IDCON=11;
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
    public static final int SYMBOLCHAR=37;
    public static final int T__66=66;
    public static final int COMMENT=20;
    public static final int MARKUP_STATEMENT=7;
    public static final int FORMALS=9;
    public static final int T__55=55;
    public static final int T__45=45;
    public static final int CHARREF=35;
    public static final int MIDTEXT=19;
    public static final int T__63=63;
    public static final int PRETEXT=17;
    public static final int SEMICOLON=23;
    public static final int T__43=43;
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


    	/**
    	 * Parsed modules
    	 */
    	private ArrayList<String> modules = new ArrayList<String>();

    	public WaebricParser(TokenStream input, ArrayList<String> modules) {
    		super(input);
    		this.modules = modules;
    	}

    	/**
    	 * Parse file on specified path.
    	 * @return AST
    	 */
    	private CommonTree parseFile(String path) throws RecognitionException {
    		try {
    			CharStream is = new ANTLRFileStream(path);
    			WaebricLexer lexer = new WaebricLexer(is);
    			CommonTokenStream tokens = new CommonTokenStream(lexer);
          			WaebricParser parser = new WaebricParser(tokens, modules);
          			return (CommonTree) parser.module().getTree();
          		} catch(java.io.IOException e) { return new CommonTree(); }
    	}


    public static class module_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "module"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:62:1: module : 'module' moduleId ( imprt | site | function )* -> ^( 'module' moduleId ( imprt )* ( site )* ( function )* ) ;
    public final WaebricParser.module_return module() throws RecognitionException {
        WaebricParser.module_return retval = new WaebricParser.module_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal1=null;
        WaebricParser.moduleId_return moduleId2 = null;

        WaebricParser.imprt_return imprt3 = null;

        WaebricParser.site_return site4 = null;

        WaebricParser.function_return function5 = null;


        Object string_literal1_tree=null;
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleSubtreeStream stream_imprt=new RewriteRuleSubtreeStream(adaptor,"rule imprt");
        RewriteRuleSubtreeStream stream_site=new RewriteRuleSubtreeStream(adaptor,"rule site");
        RewriteRuleSubtreeStream stream_moduleId=new RewriteRuleSubtreeStream(adaptor,"rule moduleId");
        RewriteRuleSubtreeStream stream_function=new RewriteRuleSubtreeStream(adaptor,"rule function");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:62:7: ( 'module' moduleId ( imprt | site | function )* -> ^( 'module' moduleId ( imprt )* ( site )* ( function )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:62:11: 'module' moduleId ( imprt | site | function )*
            {
            string_literal1=(Token)match(input,40,FOLLOW_40_in_module135); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_40.add(string_literal1);

            pushFollow(FOLLOW_moduleId_in_module137);
            moduleId2=moduleId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_moduleId.add(moduleId2.getTree());
            if ( state.backtracking==0 ) {
               modules.add((moduleId2!=null?moduleId2.path:null)); 
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:62:62: ( imprt | site | function )*
            loop1:
            do {
                int alt1=4;
                switch ( input.LA(1) ) {
                case 42:
                    {
                    alt1=1;
                    }
                    break;
                case SITE:
                    {
                    alt1=2;
                    }
                    break;
                case FUNCTION:
                    {
                    alt1=3;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:62:64: imprt
            	    {
            	    pushFollow(FOLLOW_imprt_in_module143);
            	    imprt3=imprt();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_imprt.add(imprt3.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:62:72: site
            	    {
            	    pushFollow(FOLLOW_site_in_module147);
            	    site4=site();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_site.add(site4.getTree());

            	    }
            	    break;
            	case 3 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:62:79: function
            	    {
            	    pushFollow(FOLLOW_function_in_module151);
            	    function5=function();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_function.add(function5.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);



            // AST REWRITE
            // elements: 40, function, site, imprt, moduleId
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 63:5: -> ^( 'module' moduleId ( imprt )* ( site )* ( function )* )
            {
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:63:8: ^( 'module' moduleId ( imprt )* ( site )* ( function )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_40.nextNode(), root_1);

                adaptor.addChild(root_1, stream_moduleId.nextTree());
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:63:29: ( imprt )*
                while ( stream_imprt.hasNext() ) {
                    adaptor.addChild(root_1, stream_imprt.nextTree());

                }
                stream_imprt.reset();
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:63:36: ( site )*
                while ( stream_site.hasNext() ) {
                    adaptor.addChild(root_1, stream_site.nextTree());

                }
                stream_site.reset();
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:63:42: ( function )*
                while ( stream_function.hasNext() ) {
                    adaptor.addChild(root_1, stream_function.nextTree());

                }
                stream_function.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
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
        public String path = "";
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "moduleId"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:65:1: moduleId returns [String path = \"\"] : e= IDCON ( '.' e= IDCON )* ;
    public final WaebricParser.moduleId_return moduleId() throws RecognitionException {
        WaebricParser.moduleId_return retval = new WaebricParser.moduleId_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token e=null;
        Token char_literal6=null;

        Object e_tree=null;
        Object char_literal6_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:68:2: (e= IDCON ( '.' e= IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:68:5: e= IDCON ( '.' e= IDCON )*
            {
            root_0 = (Object)adaptor.nil();

            e=(Token)match(input,IDCON,FOLLOW_IDCON_in_moduleId203); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            e_tree = (Object)adaptor.create(e);
            adaptor.addChild(root_0, e_tree);
            }
            if ( state.backtracking==0 ) {
               retval.path += e.getText(); 
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:69:4: ( '.' e= IDCON )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==41) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:69:6: '.' e= IDCON
            	    {
            	    char_literal6=(Token)match(input,41,FOLLOW_41_in_moduleId213); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal6_tree = (Object)adaptor.create(char_literal6);
            	    adaptor.addChild(root_0, char_literal6_tree);
            	    }
            	    e=(Token)match(input,IDCON,FOLLOW_IDCON_in_moduleId217); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    e_tree = (Object)adaptor.create(e);
            	    adaptor.addChild(root_0, e_tree);
            	    }
            	    if ( state.backtracking==0 ) {
            	       retval.path += "/" + e.getText(); 
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
            if ( state.backtracking==0 ) {
               retval.path += ".wae"; 
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

    public static class imprt_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "imprt"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:71:1: imprt : 'import' moduleId ;
    public final WaebricParser.imprt_return imprt() throws RecognitionException {
        WaebricParser.imprt_return retval = new WaebricParser.imprt_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal7=null;
        WaebricParser.moduleId_return moduleId8 = null;


        Object string_literal7_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:71:6: ( 'import' moduleId )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:71:10: 'import' moduleId
            {
            root_0 = (Object)adaptor.nil();

            string_literal7=(Token)match(input,42,FOLLOW_42_in_imprt233); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal7_tree = (Object)adaptor.create(string_literal7);
            adaptor.addChild(root_0, string_literal7_tree);
            }
            pushFollow(FOLLOW_moduleId_in_imprt235);
            moduleId8=moduleId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, moduleId8.getTree());
            if ( state.backtracking==0 ) {

              					if(! modules.contains((moduleId8!=null?moduleId8.path:null))) {
              						Object dependancy = adaptor.becomeRoot(parseFile((moduleId8!=null?moduleId8.path:null)), (Object) adaptor.nil());
              						adaptor.addChild(root_0, dependancy);
              					}
              				
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:81:1: site : 'site' mappings 'end' ;
    public final WaebricParser.site_return site() throws RecognitionException {
        WaebricParser.site_return retval = new WaebricParser.site_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal9=null;
        Token string_literal11=null;
        WaebricParser.mappings_return mappings10 = null;


        Object string_literal9_tree=null;
        Object string_literal11_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:81:5: ( 'site' mappings 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:81:9: 'site' mappings 'end'
            {
            root_0 = (Object)adaptor.nil();

            string_literal9=(Token)match(input,SITE,FOLLOW_SITE_in_site251); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal9_tree = (Object)adaptor.create(string_literal9);
            adaptor.addChild(root_0, string_literal9_tree);
            }
            pushFollow(FOLLOW_mappings_in_site253);
            mappings10=mappings();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mappings10.getTree());
            string_literal11=(Token)match(input,END,FOLLOW_END_in_site255); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal11_tree = (Object)adaptor.create(string_literal11);
            adaptor.addChild(root_0, string_literal11_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:82:1: mappings : ( mapping )? ( ';' mapping )* ;
    public final WaebricParser.mappings_return mappings() throws RecognitionException {
        WaebricParser.mappings_return retval = new WaebricParser.mappings_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal13=null;
        WaebricParser.mapping_return mapping12 = null;

        WaebricParser.mapping_return mapping14 = null;


        Object char_literal13_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:82:9: ( ( mapping )? ( ';' mapping )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:82:12: ( mapping )? ( ';' mapping )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:82:12: ( mapping )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==PATH) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: mapping
                    {
                    pushFollow(FOLLOW_mapping_in_mappings263);
                    mapping12=mapping();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, mapping12.getTree());

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:82:21: ( ';' mapping )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==SEMICOLON) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:82:23: ';' mapping
            	    {
            	    char_literal13=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_mappings268); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal13_tree = (Object)adaptor.create(char_literal13);
            	    adaptor.addChild(root_0, char_literal13_tree);
            	    }
            	    pushFollow(FOLLOW_mapping_in_mappings270);
            	    mapping14=mapping();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, mapping14.getTree());

            	    }
            	    break;

            	default :
            	    break loop4;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:83:1: mapping : PATH ':' markup ;
    public final WaebricParser.mapping_return mapping() throws RecognitionException {
        WaebricParser.mapping_return retval = new WaebricParser.mapping_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PATH15=null;
        Token char_literal16=null;
        WaebricParser.markup_return markup17 = null;


        Object PATH15_tree=null;
        Object char_literal16_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:83:9: ( PATH ':' markup )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:83:12: PATH ':' markup
            {
            root_0 = (Object)adaptor.nil();

            PATH15=(Token)match(input,PATH,FOLLOW_PATH_in_mapping282); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PATH15_tree = (Object)adaptor.create(PATH15);
            adaptor.addChild(root_0, PATH15_tree);
            }
            char_literal16=(Token)match(input,43,FOLLOW_43_in_mapping284); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal16_tree = (Object)adaptor.create(char_literal16);
            adaptor.addChild(root_0, char_literal16_tree);
            }
            pushFollow(FOLLOW_markup_in_mapping286);
            markup17=markup();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, markup17.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:88:1: markup : IDCON attributes arguments -> ^( MARKUP IDCON attributes arguments ) ;
    public final WaebricParser.markup_return markup() throws RecognitionException {
        WaebricParser.markup_return retval = new WaebricParser.markup_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDCON18=null;
        WaebricParser.attributes_return attributes19 = null;

        WaebricParser.arguments_return arguments20 = null;


        Object IDCON18_tree=null;
        RewriteRuleTokenStream stream_IDCON=new RewriteRuleTokenStream(adaptor,"token IDCON");
        RewriteRuleSubtreeStream stream_arguments=new RewriteRuleSubtreeStream(adaptor,"rule arguments");
        RewriteRuleSubtreeStream stream_attributes=new RewriteRuleSubtreeStream(adaptor,"rule attributes");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:88:7: ( IDCON attributes arguments -> ^( MARKUP IDCON attributes arguments ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:88:11: IDCON attributes arguments
            {
            IDCON18=(Token)match(input,IDCON,FOLLOW_IDCON_in_markup299); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDCON.add(IDCON18);

            pushFollow(FOLLOW_attributes_in_markup301);
            attributes19=attributes();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_attributes.add(attributes19.getTree());
            pushFollow(FOLLOW_arguments_in_markup303);
            arguments20=arguments();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_arguments.add(arguments20.getTree());


            // AST REWRITE
            // elements: arguments, IDCON, attributes
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 89:5: -> ^( MARKUP IDCON attributes arguments )
            {
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:89:8: ^( MARKUP IDCON attributes arguments )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MARKUP, "MARKUP"), root_1);

                adaptor.addChild(root_1, stream_IDCON.nextNode());
                adaptor.addChild(root_1, stream_attributes.nextTree());
                adaptor.addChild(root_1, stream_arguments.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
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

    public static class attributes_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributes"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:91:1: attributes : ( attribute )* -> ^( ATTRIBUTES ( attribute )* ) ;
    public final WaebricParser.attributes_return attributes() throws RecognitionException {
        WaebricParser.attributes_return retval = new WaebricParser.attributes_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WaebricParser.attribute_return attribute21 = null;


        RewriteRuleSubtreeStream stream_attribute=new RewriteRuleSubtreeStream(adaptor,"rule attribute");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:91:11: ( ( attribute )* -> ^( ATTRIBUTES ( attribute )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:91:14: ( attribute )*
            {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:91:14: ( attribute )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==41||(LA5_0>=43 && LA5_0<=46)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: attribute
            	    {
            	    pushFollow(FOLLOW_attribute_in_attributes334);
            	    attribute21=attribute();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_attribute.add(attribute21.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);



            // AST REWRITE
            // elements: attribute
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 92:5: -> ^( ATTRIBUTES ( attribute )* )
            {
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:92:8: ^( ATTRIBUTES ( attribute )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ATTRIBUTES, "ATTRIBUTES"), root_1);

                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:92:22: ( attribute )*
                while ( stream_attribute.hasNext() ) {
                    adaptor.addChild(root_1, stream_attribute.nextTree());

                }
                stream_attribute.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
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
    // $ANTLR end "attributes"

    public static class attribute_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attribute"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:94:1: attribute : ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON );
    public final WaebricParser.attribute_return attribute() throws RecognitionException {
        WaebricParser.attribute_return retval = new WaebricParser.attribute_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal22=null;
        Token IDCON23=null;
        Token char_literal24=null;
        Token IDCON25=null;
        Token char_literal26=null;
        Token IDCON27=null;
        Token char_literal28=null;
        Token IDCON29=null;
        Token char_literal30=null;
        Token NATCON31=null;
        Token char_literal32=null;
        Token NATCON33=null;
        Token char_literal34=null;
        Token NATCON35=null;

        Object char_literal22_tree=null;
        Object IDCON23_tree=null;
        Object char_literal24_tree=null;
        Object IDCON25_tree=null;
        Object char_literal26_tree=null;
        Object IDCON27_tree=null;
        Object char_literal28_tree=null;
        Object IDCON29_tree=null;
        Object char_literal30_tree=null;
        Object NATCON31_tree=null;
        Object char_literal32_tree=null;
        Object NATCON33_tree=null;
        Object char_literal34_tree=null;
        Object NATCON35_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:94:10: ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON )
            int alt6=6;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt6=1;
                }
                break;
            case 41:
                {
                alt6=2;
                }
                break;
            case 45:
                {
                alt6=3;
                }
                break;
            case 43:
                {
                alt6=4;
                }
                break;
            case 46:
                {
                int LA6_5 = input.LA(2);

                if ( (LA6_5==NATCON) ) {
                    int LA6_6 = input.LA(3);

                    if ( (LA6_6==47) ) {
                        alt6=6;
                    }
                    else if ( (LA6_6==EOF||LA6_6==IDCON||(LA6_6>=NATCON && LA6_6<=SYMBOLCON)||(LA6_6>=PRETEXT && LA6_6<=COMMENT)||(LA6_6>=END && LA6_6<=SEMICOLON)||LA6_6==41||(LA6_6>=43 && LA6_6<=46)||LA6_6==48||LA6_6==52||LA6_6==54||LA6_6==57||(LA6_6>=59 && LA6_6<=60)||(LA6_6>=62 && LA6_6<=64)) ) {
                        alt6=5;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 5, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:94:13: '#' IDCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal22=(Token)match(input,44,FOLLOW_44_in_attribute360); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal22_tree = (Object)adaptor.create(char_literal22);
                    adaptor.addChild(root_0, char_literal22_tree);
                    }
                    IDCON23=(Token)match(input,IDCON,FOLLOW_IDCON_in_attribute362); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON23_tree = (Object)adaptor.create(IDCON23);
                    adaptor.addChild(root_0, IDCON23_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:95:6: '.' IDCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal24=(Token)match(input,41,FOLLOW_41_in_attribute370); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal24_tree = (Object)adaptor.create(char_literal24);
                    adaptor.addChild(root_0, char_literal24_tree);
                    }
                    IDCON25=(Token)match(input,IDCON,FOLLOW_IDCON_in_attribute372); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON25_tree = (Object)adaptor.create(IDCON25);
                    adaptor.addChild(root_0, IDCON25_tree);
                    }

                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:96:6: '$' IDCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal26=(Token)match(input,45,FOLLOW_45_in_attribute380); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal26_tree = (Object)adaptor.create(char_literal26);
                    adaptor.addChild(root_0, char_literal26_tree);
                    }
                    IDCON27=(Token)match(input,IDCON,FOLLOW_IDCON_in_attribute382); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON27_tree = (Object)adaptor.create(IDCON27);
                    adaptor.addChild(root_0, IDCON27_tree);
                    }

                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:97:6: ':' IDCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal28=(Token)match(input,43,FOLLOW_43_in_attribute390); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal28_tree = (Object)adaptor.create(char_literal28);
                    adaptor.addChild(root_0, char_literal28_tree);
                    }
                    IDCON29=(Token)match(input,IDCON,FOLLOW_IDCON_in_attribute392); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON29_tree = (Object)adaptor.create(IDCON29);
                    adaptor.addChild(root_0, IDCON29_tree);
                    }

                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:98:6: '@' NATCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal30=(Token)match(input,46,FOLLOW_46_in_attribute400); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal30_tree = (Object)adaptor.create(char_literal30);
                    adaptor.addChild(root_0, char_literal30_tree);
                    }
                    NATCON31=(Token)match(input,NATCON,FOLLOW_NATCON_in_attribute402); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON31_tree = (Object)adaptor.create(NATCON31);
                    adaptor.addChild(root_0, NATCON31_tree);
                    }

                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:99:6: '@' NATCON '%' NATCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal32=(Token)match(input,46,FOLLOW_46_in_attribute410); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal32_tree = (Object)adaptor.create(char_literal32);
                    adaptor.addChild(root_0, char_literal32_tree);
                    }
                    NATCON33=(Token)match(input,NATCON,FOLLOW_NATCON_in_attribute412); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON33_tree = (Object)adaptor.create(NATCON33);
                    adaptor.addChild(root_0, NATCON33_tree);
                    }
                    char_literal34=(Token)match(input,47,FOLLOW_47_in_attribute414); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal34_tree = (Object)adaptor.create(char_literal34);
                    adaptor.addChild(root_0, char_literal34_tree);
                    }
                    NATCON35=(Token)match(input,NATCON,FOLLOW_NATCON_in_attribute416); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON35_tree = (Object)adaptor.create(NATCON35);
                    adaptor.addChild(root_0, NATCON35_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:101:1: arguments : ( '(' ( argument )? ( ',' argument )* ')' )? -> ^( ARGUMENTS ( argument )* ) ;
    public final WaebricParser.arguments_return arguments() throws RecognitionException {
        WaebricParser.arguments_return retval = new WaebricParser.arguments_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal36=null;
        Token char_literal38=null;
        Token char_literal40=null;
        WaebricParser.argument_return argument37 = null;

        WaebricParser.argument_return argument39 = null;


        Object char_literal36_tree=null;
        Object char_literal38_tree=null;
        Object char_literal40_tree=null;
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleSubtreeStream stream_argument=new RewriteRuleSubtreeStream(adaptor,"rule argument");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:101:10: ( ( '(' ( argument )? ( ',' argument )* ')' )? -> ^( ARGUMENTS ( argument )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:101:13: ( '(' ( argument )? ( ',' argument )* ')' )?
            {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:101:13: ( '(' ( argument )? ( ',' argument )* ')' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==48) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:101:15: '(' ( argument )? ( ',' argument )* ')'
                    {
                    char_literal36=(Token)match(input,48,FOLLOW_48_in_arguments430); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_48.add(char_literal36);

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:101:19: ( argument )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==IDCON||(LA7_0>=NATCON && LA7_0<=SYMBOLCON)||LA7_0==52||LA7_0==54) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: argument
                            {
                            pushFollow(FOLLOW_argument_in_arguments432);
                            argument37=argument();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_argument.add(argument37.getTree());

                            }
                            break;

                    }

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:101:29: ( ',' argument )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==49) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:101:31: ',' argument
                    	    {
                    	    char_literal38=(Token)match(input,49,FOLLOW_49_in_arguments437); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_49.add(char_literal38);

                    	    pushFollow(FOLLOW_argument_in_arguments439);
                    	    argument39=argument();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_argument.add(argument39.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    char_literal40=(Token)match(input,50,FOLLOW_50_in_arguments444); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_50.add(char_literal40);


                    }
                    break;

            }



            // AST REWRITE
            // elements: argument
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 102:5: -> ^( ARGUMENTS ( argument )* )
            {
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:102:8: ^( ARGUMENTS ( argument )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARGUMENTS, "ARGUMENTS"), root_1);

                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:102:21: ( argument )*
                while ( stream_argument.hasNext() ) {
                    adaptor.addChild(root_1, stream_argument.nextTree());

                }
                stream_argument.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:104:1: argument : ( expression | IDCON '=' expression );
    public final WaebricParser.argument_return argument() throws RecognitionException {
        WaebricParser.argument_return retval = new WaebricParser.argument_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDCON42=null;
        Token char_literal43=null;
        WaebricParser.expression_return expression41 = null;

        WaebricParser.expression_return expression44 = null;


        Object IDCON42_tree=null;
        Object char_literal43_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:104:9: ( expression | IDCON '=' expression )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==IDCON) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==51) ) {
                    alt10=2;
                }
                else if ( (LA10_1==EOF||LA10_1==41||(LA10_1>=49 && LA10_1<=50)||LA10_1==56) ) {
                    alt10=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA10_0>=NATCON && LA10_0<=SYMBOLCON)||LA10_0==52||LA10_0==54) ) {
                alt10=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:104:12: expression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_expression_in_argument475);
                    expression41=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression41.getTree());

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:105:6: IDCON '=' expression
                    {
                    root_0 = (Object)adaptor.nil();

                    IDCON42=(Token)match(input,IDCON,FOLLOW_IDCON_in_argument483); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON42_tree = (Object)adaptor.create(IDCON42);
                    adaptor.addChild(root_0, IDCON42_tree);
                    }
                    char_literal43=(Token)match(input,51,FOLLOW_51_in_argument485); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal43_tree = (Object)adaptor.create(char_literal43);
                    adaptor.addChild(root_0, char_literal43_tree);
                    }
                    pushFollow(FOLLOW_expression_in_argument487);
                    expression44=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression44.getTree());

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
    // $ANTLR end "argument"

    public static class expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:110:1: expression : ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* ;
    public final WaebricParser.expression_return expression() throws RecognitionException {
        WaebricParser.expression_return retval = new WaebricParser.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDCON45=null;
        Token NATCON46=null;
        Token TEXT47=null;
        Token SYMBOLCON48=null;
        Token char_literal49=null;
        Token char_literal51=null;
        Token char_literal53=null;
        Token char_literal54=null;
        Token char_literal56=null;
        Token char_literal58=null;
        Token char_literal59=null;
        Token char_literal61=null;
        Token IDCON62=null;
        WaebricParser.expression_return expression50 = null;

        WaebricParser.expression_return expression52 = null;

        WaebricParser.keyValuePair_return keyValuePair55 = null;

        WaebricParser.keyValuePair_return keyValuePair57 = null;

        WaebricParser.expression_return expression60 = null;


        Object IDCON45_tree=null;
        Object NATCON46_tree=null;
        Object TEXT47_tree=null;
        Object SYMBOLCON48_tree=null;
        Object char_literal49_tree=null;
        Object char_literal51_tree=null;
        Object char_literal53_tree=null;
        Object char_literal54_tree=null;
        Object char_literal56_tree=null;
        Object char_literal58_tree=null;
        Object char_literal59_tree=null;
        Object char_literal61_tree=null;
        Object IDCON62_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:110:11: ( ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:110:14: ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:110:14: ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' )
            int alt15=6;
            switch ( input.LA(1) ) {
            case IDCON:
                {
                alt15=1;
                }
                break;
            case NATCON:
                {
                alt15=2;
                }
                break;
            case TEXT:
                {
                alt15=3;
                }
                break;
            case SYMBOLCON:
                {
                alt15=4;
                }
                break;
            case 52:
                {
                alt15=5;
                }
                break;
            case 54:
                {
                alt15=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:110:16: IDCON
                    {
                    IDCON45=(Token)match(input,IDCON,FOLLOW_IDCON_in_expression502); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON45_tree = (Object)adaptor.create(IDCON45);
                    adaptor.addChild(root_0, IDCON45_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:110:24: NATCON
                    {
                    NATCON46=(Token)match(input,NATCON,FOLLOW_NATCON_in_expression506); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON46_tree = (Object)adaptor.create(NATCON46);
                    adaptor.addChild(root_0, NATCON46_tree);
                    }

                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:110:33: TEXT
                    {
                    TEXT47=(Token)match(input,TEXT,FOLLOW_TEXT_in_expression510); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TEXT47_tree = (Object)adaptor.create(TEXT47);
                    adaptor.addChild(root_0, TEXT47_tree);
                    }

                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:110:40: SYMBOLCON
                    {
                    SYMBOLCON48=(Token)match(input,SYMBOLCON,FOLLOW_SYMBOLCON_in_expression514); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SYMBOLCON48_tree = (Object)adaptor.create(SYMBOLCON48);
                    adaptor.addChild(root_0, SYMBOLCON48_tree);
                    }

                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:111:7: '[' ( expression )? ( ',' expression )* ']'
                    {
                    char_literal49=(Token)match(input,52,FOLLOW_52_in_expression523); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal49_tree = (Object)adaptor.create(char_literal49);
                    adaptor.addChild(root_0, char_literal49_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:111:11: ( expression )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==IDCON||(LA11_0>=NATCON && LA11_0<=SYMBOLCON)||LA11_0==52||LA11_0==54) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: expression
                            {
                            pushFollow(FOLLOW_expression_in_expression525);
                            expression50=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression50.getTree());

                            }
                            break;

                    }

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:111:23: ( ',' expression )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==49) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:111:25: ',' expression
                    	    {
                    	    char_literal51=(Token)match(input,49,FOLLOW_49_in_expression530); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal51_tree = (Object)adaptor.create(char_literal51);
                    	    adaptor.addChild(root_0, char_literal51_tree);
                    	    }
                    	    pushFollow(FOLLOW_expression_in_expression532);
                    	    expression52=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression52.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    char_literal53=(Token)match(input,53,FOLLOW_53_in_expression537); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal53_tree = (Object)adaptor.create(char_literal53);
                    adaptor.addChild(root_0, char_literal53_tree);
                    }

                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:112:7: '{' ( keyValuePair )? ( ',' keyValuePair )* '}'
                    {
                    char_literal54=(Token)match(input,54,FOLLOW_54_in_expression546); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal54_tree = (Object)adaptor.create(char_literal54);
                    adaptor.addChild(root_0, char_literal54_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:112:11: ( keyValuePair )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==IDCON) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: keyValuePair
                            {
                            pushFollow(FOLLOW_keyValuePair_in_expression548);
                            keyValuePair55=keyValuePair();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, keyValuePair55.getTree());

                            }
                            break;

                    }

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:112:25: ( ',' keyValuePair )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==49) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:112:27: ',' keyValuePair
                    	    {
                    	    char_literal56=(Token)match(input,49,FOLLOW_49_in_expression553); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal56_tree = (Object)adaptor.create(char_literal56);
                    	    adaptor.addChild(root_0, char_literal56_tree);
                    	    }
                    	    pushFollow(FOLLOW_keyValuePair_in_expression555);
                    	    keyValuePair57=keyValuePair();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, keyValuePair57.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    char_literal58=(Token)match(input,55,FOLLOW_55_in_expression560); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal58_tree = (Object)adaptor.create(char_literal58);
                    adaptor.addChild(root_0, char_literal58_tree);
                    }

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:113:6: ( '+' expression | '.' IDCON )*
            loop16:
            do {
                int alt16=3;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==56) ) {
                    int LA16_2 = input.LA(2);

                    if ( (synpred26_Waebric()) ) {
                        alt16=1;
                    }


                }
                else if ( (LA16_0==41) ) {
                    int LA16_3 = input.LA(2);

                    if ( (synpred27_Waebric()) ) {
                        alt16=2;
                    }


                }


                switch (alt16) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:113:8: '+' expression
            	    {
            	    char_literal59=(Token)match(input,56,FOLLOW_56_in_expression570); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal59_tree = (Object)adaptor.create(char_literal59);
            	    adaptor.addChild(root_0, char_literal59_tree);
            	    }
            	    pushFollow(FOLLOW_expression_in_expression572);
            	    expression60=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression60.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:113:35: '.' IDCON
            	    {
            	    char_literal61=(Token)match(input,41,FOLLOW_41_in_expression578); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal61_tree = (Object)adaptor.create(char_literal61);
            	    adaptor.addChild(root_0, char_literal61_tree);
            	    }
            	    IDCON62=(Token)match(input,IDCON,FOLLOW_IDCON_in_expression580); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDCON62_tree = (Object)adaptor.create(IDCON62);
            	    adaptor.addChild(root_0, IDCON62_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop16;
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
    // $ANTLR end "expression"

    public static class keyValuePair_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "keyValuePair"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:114:1: keyValuePair : IDCON ':' expression ;
    public final WaebricParser.keyValuePair_return keyValuePair() throws RecognitionException {
        WaebricParser.keyValuePair_return retval = new WaebricParser.keyValuePair_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDCON63=null;
        Token char_literal64=null;
        WaebricParser.expression_return expression65 = null;


        Object IDCON63_tree=null;
        Object char_literal64_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:114:13: ( IDCON ':' expression )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:114:16: IDCON ':' expression
            {
            root_0 = (Object)adaptor.nil();

            IDCON63=(Token)match(input,IDCON,FOLLOW_IDCON_in_keyValuePair593); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON63_tree = (Object)adaptor.create(IDCON63);
            adaptor.addChild(root_0, IDCON63_tree);
            }
            char_literal64=(Token)match(input,43,FOLLOW_43_in_keyValuePair595); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal64_tree = (Object)adaptor.create(char_literal64);
            adaptor.addChild(root_0, char_literal64_tree);
            }
            pushFollow(FOLLOW_expression_in_keyValuePair597);
            expression65=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression65.getTree());

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
    // $ANTLR end "keyValuePair"

    public static class function_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:119:1: function : 'def' IDCON ( formals )? ( statement )* 'end' -> ^( FUNCTION IDCON ^( FORMALS ( formals )? ) ( statement )* ) ;
    public final WaebricParser.function_return function() throws RecognitionException {
        WaebricParser.function_return retval = new WaebricParser.function_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal66=null;
        Token IDCON67=null;
        Token string_literal70=null;
        WaebricParser.formals_return formals68 = null;

        WaebricParser.statement_return statement69 = null;


        Object string_literal66_tree=null;
        Object IDCON67_tree=null;
        Object string_literal70_tree=null;
        RewriteRuleTokenStream stream_FUNCTION=new RewriteRuleTokenStream(adaptor,"token FUNCTION");
        RewriteRuleTokenStream stream_END=new RewriteRuleTokenStream(adaptor,"token END");
        RewriteRuleTokenStream stream_IDCON=new RewriteRuleTokenStream(adaptor,"token IDCON");
        RewriteRuleSubtreeStream stream_formals=new RewriteRuleSubtreeStream(adaptor,"rule formals");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:119:9: ( 'def' IDCON ( formals )? ( statement )* 'end' -> ^( FUNCTION IDCON ^( FORMALS ( formals )? ) ( statement )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:119:12: 'def' IDCON ( formals )? ( statement )* 'end'
            {
            string_literal66=(Token)match(input,FUNCTION,FOLLOW_FUNCTION_in_function609); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FUNCTION.add(string_literal66);

            IDCON67=(Token)match(input,IDCON,FOLLOW_IDCON_in_function611); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDCON.add(IDCON67);

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:119:24: ( formals )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==48) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: formals
                    {
                    pushFollow(FOLLOW_formals_in_function613);
                    formals68=formals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_formals.add(formals68.getTree());

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:119:33: ( statement )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==IDCON||LA18_0==COMMENT||LA18_0==54||LA18_0==57||(LA18_0>=59 && LA18_0<=60)||(LA18_0>=62 && LA18_0<=64)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_function616);
            	    statement69=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statement.add(statement69.getTree());

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            string_literal70=(Token)match(input,END,FOLLOW_END_in_function619); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_END.add(string_literal70);



            // AST REWRITE
            // elements: IDCON, formals, statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 120:5: -> ^( FUNCTION IDCON ^( FORMALS ( formals )? ) ( statement )* )
            {
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:120:8: ^( FUNCTION IDCON ^( FORMALS ( formals )? ) ( statement )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION, "FUNCTION"), root_1);

                adaptor.addChild(root_1, stream_IDCON.nextNode());
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:120:26: ^( FORMALS ( formals )? )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(FORMALS, "FORMALS"), root_2);

                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:120:37: ( formals )?
                if ( stream_formals.hasNext() ) {
                    adaptor.addChild(root_2, stream_formals.nextTree());

                }
                stream_formals.reset();

                adaptor.addChild(root_1, root_2);
                }
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:120:48: ( statement )*
                while ( stream_statement.hasNext() ) {
                    adaptor.addChild(root_1, stream_statement.nextTree());

                }
                stream_statement.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:122:1: formals : '(' ( IDCON )? ( ',' IDCON )* ')' -> ( IDCON )* ;
    public final WaebricParser.formals_return formals() throws RecognitionException {
        WaebricParser.formals_return retval = new WaebricParser.formals_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal71=null;
        Token IDCON72=null;
        Token char_literal73=null;
        Token IDCON74=null;
        Token char_literal75=null;

        Object char_literal71_tree=null;
        Object IDCON72_tree=null;
        Object char_literal73_tree=null;
        Object IDCON74_tree=null;
        Object char_literal75_tree=null;
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
        RewriteRuleTokenStream stream_IDCON=new RewriteRuleTokenStream(adaptor,"token IDCON");
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:122:8: ( '(' ( IDCON )? ( ',' IDCON )* ')' -> ( IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:122:11: '(' ( IDCON )? ( ',' IDCON )* ')'
            {
            char_literal71=(Token)match(input,48,FOLLOW_48_in_formals656); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_48.add(char_literal71);

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:122:15: ( IDCON )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==IDCON) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: IDCON
                    {
                    IDCON72=(Token)match(input,IDCON,FOLLOW_IDCON_in_formals658); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDCON.add(IDCON72);


                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:122:22: ( ',' IDCON )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==49) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:122:24: ',' IDCON
            	    {
            	    char_literal73=(Token)match(input,49,FOLLOW_49_in_formals663); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_49.add(char_literal73);

            	    IDCON74=(Token)match(input,IDCON,FOLLOW_IDCON_in_formals665); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_IDCON.add(IDCON74);


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            char_literal75=(Token)match(input,50,FOLLOW_50_in_formals670); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_50.add(char_literal75);



            // AST REWRITE
            // elements: IDCON
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 123:5: -> ( IDCON )*
            {
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:123:8: ( IDCON )*
                while ( stream_IDCON.hasNext() ) {
                    adaptor.addChild(root_0, stream_IDCON.nextNode());

                }
                stream_IDCON.reset();

            }

            retval.tree = root_0;}
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:129:1: statement : ( 'if' '(' predicate ')' statement ( 'else' statement )? -> ^( 'if' predicate statement ( 'else' statement )? ) | 'each' '(' IDCON ':' expression ')' statement -> ^( 'each' '(' IDCON ':' expression ')' statement ) | 'let' ( assignment )+ 'in' ( statement )* 'end' -> ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | '{' ( statement )* '}' -> ^( '{' ( statement )* '}' ) | 'comment' STRCON ';' -> ^( 'comment' STRCON ) | 'echo' expression ';' -> ^( 'echo' expression ) | 'echo' embedding ';' -> ^( 'echo' embedding ) | 'cdata' expression ';' -> ^( 'cdata' expression ) | 'yield;' | markup markupChain -> ^( MARKUP_STATEMENT markup markupChain ) );
    public final WaebricParser.statement_return statement() throws RecognitionException {
        WaebricParser.statement_return retval = new WaebricParser.statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal76=null;
        Token char_literal77=null;
        Token char_literal79=null;
        Token string_literal81=null;
        Token string_literal83=null;
        Token char_literal84=null;
        Token IDCON85=null;
        Token char_literal86=null;
        Token char_literal88=null;
        Token string_literal90=null;
        Token string_literal92=null;
        Token string_literal94=null;
        Token char_literal95=null;
        Token char_literal97=null;
        Token string_literal98=null;
        Token STRCON99=null;
        Token char_literal100=null;
        Token string_literal101=null;
        Token char_literal103=null;
        Token string_literal104=null;
        Token char_literal106=null;
        Token string_literal107=null;
        Token char_literal109=null;
        Token string_literal110=null;
        WaebricParser.predicate_return predicate78 = null;

        WaebricParser.statement_return statement80 = null;

        WaebricParser.statement_return statement82 = null;

        WaebricParser.expression_return expression87 = null;

        WaebricParser.statement_return statement89 = null;

        WaebricParser.assignment_return assignment91 = null;

        WaebricParser.statement_return statement93 = null;

        WaebricParser.statement_return statement96 = null;

        WaebricParser.expression_return expression102 = null;

        WaebricParser.embedding_return embedding105 = null;

        WaebricParser.expression_return expression108 = null;

        WaebricParser.markup_return markup111 = null;

        WaebricParser.markupChain_return markupChain112 = null;


        Object string_literal76_tree=null;
        Object char_literal77_tree=null;
        Object char_literal79_tree=null;
        Object string_literal81_tree=null;
        Object string_literal83_tree=null;
        Object char_literal84_tree=null;
        Object IDCON85_tree=null;
        Object char_literal86_tree=null;
        Object char_literal88_tree=null;
        Object string_literal90_tree=null;
        Object string_literal92_tree=null;
        Object string_literal94_tree=null;
        Object char_literal95_tree=null;
        Object char_literal97_tree=null;
        Object string_literal98_tree=null;
        Object STRCON99_tree=null;
        Object char_literal100_tree=null;
        Object string_literal101_tree=null;
        Object char_literal103_tree=null;
        Object string_literal104_tree=null;
        Object char_literal106_tree=null;
        Object string_literal107_tree=null;
        Object char_literal109_tree=null;
        Object string_literal110_tree=null;
        RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
        RewriteRuleTokenStream stream_END=new RewriteRuleTokenStream(adaptor,"token END");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_STRCON=new RewriteRuleTokenStream(adaptor,"token STRCON");
        RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
        RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
        RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
        RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
        RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
        RewriteRuleTokenStream stream_COMMENT=new RewriteRuleTokenStream(adaptor,"token COMMENT");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
        RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
        RewriteRuleTokenStream stream_IDCON=new RewriteRuleTokenStream(adaptor,"token IDCON");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_assignment=new RewriteRuleSubtreeStream(adaptor,"rule assignment");
        RewriteRuleSubtreeStream stream_markupChain=new RewriteRuleSubtreeStream(adaptor,"rule markupChain");
        RewriteRuleSubtreeStream stream_embedding=new RewriteRuleSubtreeStream(adaptor,"rule embedding");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_predicate=new RewriteRuleSubtreeStream(adaptor,"rule predicate");
        RewriteRuleSubtreeStream stream_markup=new RewriteRuleSubtreeStream(adaptor,"rule markup");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:129:10: ( 'if' '(' predicate ')' statement ( 'else' statement )? -> ^( 'if' predicate statement ( 'else' statement )? ) | 'each' '(' IDCON ':' expression ')' statement -> ^( 'each' '(' IDCON ':' expression ')' statement ) | 'let' ( assignment )+ 'in' ( statement )* 'end' -> ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | '{' ( statement )* '}' -> ^( '{' ( statement )* '}' ) | 'comment' STRCON ';' -> ^( 'comment' STRCON ) | 'echo' expression ';' -> ^( 'echo' expression ) | 'echo' embedding ';' -> ^( 'echo' embedding ) | 'cdata' expression ';' -> ^( 'cdata' expression ) | 'yield;' | markup markupChain -> ^( MARKUP_STATEMENT markup markupChain ) )
            int alt25=10;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:129:13: 'if' '(' predicate ')' statement ( 'else' statement )?
                    {
                    string_literal76=(Token)match(input,57,FOLLOW_57_in_statement692); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_57.add(string_literal76);

                    char_literal77=(Token)match(input,48,FOLLOW_48_in_statement694); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_48.add(char_literal77);

                    pushFollow(FOLLOW_predicate_in_statement696);
                    predicate78=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_predicate.add(predicate78.getTree());
                    char_literal79=(Token)match(input,50,FOLLOW_50_in_statement698); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_50.add(char_literal79);

                    pushFollow(FOLLOW_statement_in_statement700);
                    statement80=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement80.getTree());
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:129:46: ( 'else' statement )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==58) ) {
                        int LA21_1 = input.LA(2);

                        if ( (synpred32_Waebric()) ) {
                            alt21=1;
                        }
                    }
                    switch (alt21) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:129:48: 'else' statement
                            {
                            string_literal81=(Token)match(input,58,FOLLOW_58_in_statement704); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_58.add(string_literal81);

                            pushFollow(FOLLOW_statement_in_statement706);
                            statement82=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_statement.add(statement82.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: 57, predicate, statement, 58, statement
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 130:5: -> ^( 'if' predicate statement ( 'else' statement )? )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:130:8: ^( 'if' predicate statement ( 'else' statement )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_57.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_predicate.nextTree());
                        adaptor.addChild(root_1, stream_statement.nextTree());
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:130:36: ( 'else' statement )?
                        if ( stream_statement.hasNext()||stream_58.hasNext() ) {
                            adaptor.addChild(root_1, stream_58.nextNode());
                            adaptor.addChild(root_1, stream_statement.nextTree());

                        }
                        stream_statement.reset();
                        stream_58.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:131:6: 'each' '(' IDCON ':' expression ')' statement
                    {
                    string_literal83=(Token)match(input,59,FOLLOW_59_in_statement741); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_59.add(string_literal83);

                    char_literal84=(Token)match(input,48,FOLLOW_48_in_statement743); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_48.add(char_literal84);

                    IDCON85=(Token)match(input,IDCON,FOLLOW_IDCON_in_statement745); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDCON.add(IDCON85);

                    char_literal86=(Token)match(input,43,FOLLOW_43_in_statement747); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_43.add(char_literal86);

                    pushFollow(FOLLOW_expression_in_statement749);
                    expression87=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression87.getTree());
                    char_literal88=(Token)match(input,50,FOLLOW_50_in_statement751); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_50.add(char_literal88);

                    pushFollow(FOLLOW_statement_in_statement753);
                    statement89=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement89.getTree());


                    // AST REWRITE
                    // elements: 43, IDCON, 59, 50, 48, statement, expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 132:5: -> ^( 'each' '(' IDCON ':' expression ')' statement )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:132:8: ^( 'each' '(' IDCON ':' expression ')' statement )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_59.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_48.nextNode());
                        adaptor.addChild(root_1, stream_IDCON.nextNode());
                        adaptor.addChild(root_1, stream_43.nextNode());
                        adaptor.addChild(root_1, stream_expression.nextTree());
                        adaptor.addChild(root_1, stream_50.nextNode());
                        adaptor.addChild(root_1, stream_statement.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:133:6: 'let' ( assignment )+ 'in' ( statement )* 'end'
                    {
                    string_literal90=(Token)match(input,60,FOLLOW_60_in_statement785); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_60.add(string_literal90);

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:133:12: ( assignment )+
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
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: assignment
                    	    {
                    	    pushFollow(FOLLOW_assignment_in_statement787);
                    	    assignment91=assignment();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_assignment.add(assignment91.getTree());

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

                    string_literal92=(Token)match(input,61,FOLLOW_61_in_statement790); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_61.add(string_literal92);

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:133:29: ( statement )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==IDCON||LA23_0==COMMENT||LA23_0==54||LA23_0==57||(LA23_0>=59 && LA23_0<=60)||(LA23_0>=62 && LA23_0<=64)) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_statement792);
                    	    statement93=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_statement.add(statement93.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);

                    string_literal94=(Token)match(input,END,FOLLOW_END_in_statement795); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_END.add(string_literal94);



                    // AST REWRITE
                    // elements: statement, END, assignment, 61, 60
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 134:5: -> ^( 'let' ( assignment )+ 'in' ( statement )* 'end' )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:134:8: ^( 'let' ( assignment )+ 'in' ( statement )* 'end' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_60.nextNode(), root_1);

                        if ( !(stream_assignment.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_assignment.hasNext() ) {
                            adaptor.addChild(root_1, stream_assignment.nextTree());

                        }
                        stream_assignment.reset();
                        adaptor.addChild(root_1, stream_61.nextNode());
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:134:34: ( statement )*
                        while ( stream_statement.hasNext() ) {
                            adaptor.addChild(root_1, stream_statement.nextTree());

                        }
                        stream_statement.reset();
                        adaptor.addChild(root_1, stream_END.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:135:6: '{' ( statement )* '}'
                    {
                    char_literal95=(Token)match(input,54,FOLLOW_54_in_statement824); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_54.add(char_literal95);

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:135:10: ( statement )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==IDCON||LA24_0==COMMENT||LA24_0==54||LA24_0==57||(LA24_0>=59 && LA24_0<=60)||(LA24_0>=62 && LA24_0<=64)) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_statement826);
                    	    statement96=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_statement.add(statement96.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    char_literal97=(Token)match(input,55,FOLLOW_55_in_statement829); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_55.add(char_literal97);



                    // AST REWRITE
                    // elements: 54, 55, statement
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 136:5: -> ^( '{' ( statement )* '}' )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:136:8: ^( '{' ( statement )* '}' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_54.nextNode(), root_1);

                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:136:15: ( statement )*
                        while ( stream_statement.hasNext() ) {
                            adaptor.addChild(root_1, stream_statement.nextTree());

                        }
                        stream_statement.reset();
                        adaptor.addChild(root_1, stream_55.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:137:6: 'comment' STRCON ';'
                    {
                    string_literal98=(Token)match(input,COMMENT,FOLLOW_COMMENT_in_statement853); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COMMENT.add(string_literal98);

                    STRCON99=(Token)match(input,STRCON,FOLLOW_STRCON_in_statement855); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRCON.add(STRCON99);

                    char_literal100=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement857); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal100);



                    // AST REWRITE
                    // elements: STRCON, COMMENT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 138:5: -> ^( 'comment' STRCON )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:138:8: ^( 'comment' STRCON )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_COMMENT.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_STRCON.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:139:6: 'echo' expression ';'
                    {
                    string_literal101=(Token)match(input,62,FOLLOW_62_in_statement878); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_62.add(string_literal101);

                    pushFollow(FOLLOW_expression_in_statement880);
                    expression102=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression102.getTree());
                    char_literal103=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement882); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal103);



                    // AST REWRITE
                    // elements: expression, 62
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 140:5: -> ^( 'echo' expression )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:140:8: ^( 'echo' expression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_62.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_expression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 7 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:141:6: 'echo' embedding ';'
                    {
                    string_literal104=(Token)match(input,62,FOLLOW_62_in_statement903); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_62.add(string_literal104);

                    pushFollow(FOLLOW_embedding_in_statement905);
                    embedding105=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_embedding.add(embedding105.getTree());
                    char_literal106=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement907); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal106);



                    // AST REWRITE
                    // elements: embedding, 62
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 142:5: -> ^( 'echo' embedding )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:142:8: ^( 'echo' embedding )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_62.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_embedding.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 8 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:143:6: 'cdata' expression ';'
                    {
                    string_literal107=(Token)match(input,63,FOLLOW_63_in_statement928); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_63.add(string_literal107);

                    pushFollow(FOLLOW_expression_in_statement930);
                    expression108=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression108.getTree());
                    char_literal109=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement932); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal109);



                    // AST REWRITE
                    // elements: expression, 63
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 144:5: -> ^( 'cdata' expression )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:144:8: ^( 'cdata' expression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_63.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_expression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 9 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:145:6: 'yield;'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal110=(Token)match(input,64,FOLLOW_64_in_statement954); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal110_tree = (Object)adaptor.create(string_literal110);
                    adaptor.addChild(root_0, string_literal110_tree);
                    }

                    }
                    break;
                case 10 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:146:6: markup markupChain
                    {
                    pushFollow(FOLLOW_markup_in_statement961);
                    markup111=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_markup.add(markup111.getTree());
                    pushFollow(FOLLOW_markupChain_in_statement963);
                    markupChain112=markupChain();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_markupChain.add(markupChain112.getTree());


                    // AST REWRITE
                    // elements: markup, markupChain
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 147:5: -> ^( MARKUP_STATEMENT markup markupChain )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:147:8: ^( MARKUP_STATEMENT markup markupChain )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MARKUP_STATEMENT, "MARKUP_STATEMENT"), root_1);

                        adaptor.addChild(root_1, stream_markup.nextTree());
                        adaptor.addChild(root_1, stream_markupChain.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
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

    public static class markupChain_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "markupChain"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:149:1: markupChain : ( expression ';' -> ^( MARKUP_CHAIN expression ';' ) | statement -> ^( MARKUP_CHAIN statement ) | embedding ';' -> ^( MARKUP_CHAIN embedding ';' ) | markup markupChain -> ^( MARKUP_CHAIN markup markupChain ) | ';' -> ^( MARKUP_CHAIN ';' ) );
    public final WaebricParser.markupChain_return markupChain() throws RecognitionException {
        WaebricParser.markupChain_return retval = new WaebricParser.markupChain_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal114=null;
        Token char_literal117=null;
        Token char_literal120=null;
        WaebricParser.expression_return expression113 = null;

        WaebricParser.statement_return statement115 = null;

        WaebricParser.embedding_return embedding116 = null;

        WaebricParser.markup_return markup118 = null;

        WaebricParser.markupChain_return markupChain119 = null;


        Object char_literal114_tree=null;
        Object char_literal117_tree=null;
        Object char_literal120_tree=null;
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_markupChain=new RewriteRuleSubtreeStream(adaptor,"rule markupChain");
        RewriteRuleSubtreeStream stream_embedding=new RewriteRuleSubtreeStream(adaptor,"rule embedding");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_markup=new RewriteRuleSubtreeStream(adaptor,"rule markup");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:149:12: ( expression ';' -> ^( MARKUP_CHAIN expression ';' ) | statement -> ^( MARKUP_CHAIN statement ) | embedding ';' -> ^( MARKUP_CHAIN embedding ';' ) | markup markupChain -> ^( MARKUP_CHAIN markup markupChain ) | ';' -> ^( MARKUP_CHAIN ';' ) )
            int alt26=5;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:149:15: expression ';'
                    {
                    pushFollow(FOLLOW_expression_in_markupChain987);
                    expression113=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression113.getTree());
                    char_literal114=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_markupChain989); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal114);



                    // AST REWRITE
                    // elements: SEMICOLON, expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 150:5: -> ^( MARKUP_CHAIN expression ';' )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:150:8: ^( MARKUP_CHAIN expression ';' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MARKUP_CHAIN, "MARKUP_CHAIN"), root_1);

                        adaptor.addChild(root_1, stream_expression.nextTree());
                        adaptor.addChild(root_1, stream_SEMICOLON.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:151:6: statement
                    {
                    pushFollow(FOLLOW_statement_in_markupChain1013);
                    statement115=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement115.getTree());


                    // AST REWRITE
                    // elements: statement
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 152:5: -> ^( MARKUP_CHAIN statement )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:152:8: ^( MARKUP_CHAIN statement )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MARKUP_CHAIN, "MARKUP_CHAIN"), root_1);

                        adaptor.addChild(root_1, stream_statement.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:153:6: embedding ';'
                    {
                    pushFollow(FOLLOW_embedding_in_markupChain1036);
                    embedding116=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_embedding.add(embedding116.getTree());
                    char_literal117=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_markupChain1038); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal117);



                    // AST REWRITE
                    // elements: SEMICOLON, embedding
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 154:5: -> ^( MARKUP_CHAIN embedding ';' )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:154:8: ^( MARKUP_CHAIN embedding ';' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MARKUP_CHAIN, "MARKUP_CHAIN"), root_1);

                        adaptor.addChild(root_1, stream_embedding.nextTree());
                        adaptor.addChild(root_1, stream_SEMICOLON.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:155:6: markup markupChain
                    {
                    pushFollow(FOLLOW_markup_in_markupChain1062);
                    markup118=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_markup.add(markup118.getTree());
                    pushFollow(FOLLOW_markupChain_in_markupChain1064);
                    markupChain119=markupChain();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_markupChain.add(markupChain119.getTree());


                    // AST REWRITE
                    // elements: markupChain, markup
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 156:5: -> ^( MARKUP_CHAIN markup markupChain )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:156:8: ^( MARKUP_CHAIN markup markupChain )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MARKUP_CHAIN, "MARKUP_CHAIN"), root_1);

                        adaptor.addChild(root_1, stream_markup.nextTree());
                        adaptor.addChild(root_1, stream_markupChain.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:157:6: ';'
                    {
                    char_literal120=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_markupChain1088); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal120);



                    // AST REWRITE
                    // elements: SEMICOLON
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 158:5: -> ^( MARKUP_CHAIN ';' )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:158:8: ^( MARKUP_CHAIN ';' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MARKUP_CHAIN, "MARKUP_CHAIN"), root_1);

                        adaptor.addChild(root_1, stream_SEMICOLON.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
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
    // $ANTLR end "markupChain"

    public static class assignment_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignment"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:163:1: assignment : ( IDCON '=' expression ';' | IDCON formals '=' statement -> ^( FUNCTION IDCON ^( FORMALS ( formals )? ) statement ) );
    public final WaebricParser.assignment_return assignment() throws RecognitionException {
        WaebricParser.assignment_return retval = new WaebricParser.assignment_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDCON121=null;
        Token char_literal122=null;
        Token char_literal124=null;
        Token IDCON125=null;
        Token char_literal127=null;
        WaebricParser.expression_return expression123 = null;

        WaebricParser.formals_return formals126 = null;

        WaebricParser.statement_return statement128 = null;


        Object IDCON121_tree=null;
        Object char_literal122_tree=null;
        Object char_literal124_tree=null;
        Object IDCON125_tree=null;
        Object char_literal127_tree=null;
        RewriteRuleTokenStream stream_IDCON=new RewriteRuleTokenStream(adaptor,"token IDCON");
        RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
        RewriteRuleSubtreeStream stream_formals=new RewriteRuleSubtreeStream(adaptor,"rule formals");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:163:11: ( IDCON '=' expression ';' | IDCON formals '=' statement -> ^( FUNCTION IDCON ^( FORMALS ( formals )? ) statement ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==IDCON) ) {
                int LA27_1 = input.LA(2);

                if ( (LA27_1==51) ) {
                    alt27=1;
                }
                else if ( (LA27_1==48) ) {
                    alt27=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 27, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:163:14: IDCON '=' expression ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    IDCON121=(Token)match(input,IDCON,FOLLOW_IDCON_in_assignment1115); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON121_tree = (Object)adaptor.create(IDCON121);
                    adaptor.addChild(root_0, IDCON121_tree);
                    }
                    char_literal122=(Token)match(input,51,FOLLOW_51_in_assignment1117); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal122_tree = (Object)adaptor.create(char_literal122);
                    adaptor.addChild(root_0, char_literal122_tree);
                    }
                    pushFollow(FOLLOW_expression_in_assignment1119);
                    expression123=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression123.getTree());
                    char_literal124=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_assignment1121); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal124_tree = (Object)adaptor.create(char_literal124);
                    adaptor.addChild(root_0, char_literal124_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:164:6: IDCON formals '=' statement
                    {
                    IDCON125=(Token)match(input,IDCON,FOLLOW_IDCON_in_assignment1129); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDCON.add(IDCON125);

                    pushFollow(FOLLOW_formals_in_assignment1131);
                    formals126=formals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_formals.add(formals126.getTree());
                    char_literal127=(Token)match(input,51,FOLLOW_51_in_assignment1133); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_51.add(char_literal127);

                    pushFollow(FOLLOW_statement_in_assignment1135);
                    statement128=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement128.getTree());


                    // AST REWRITE
                    // elements: formals, statement, IDCON
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 165:5: -> ^( FUNCTION IDCON ^( FORMALS ( formals )? ) statement )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:165:8: ^( FUNCTION IDCON ^( FORMALS ( formals )? ) statement )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION, "FUNCTION"), root_1);

                        adaptor.addChild(root_1, stream_IDCON.nextNode());
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:165:26: ^( FORMALS ( formals )? )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(FORMALS, "FORMALS"), root_2);

                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:165:37: ( formals )?
                        if ( stream_formals.hasNext() ) {
                            adaptor.addChild(root_2, stream_formals.nextTree());

                        }
                        stream_formals.reset();

                        adaptor.addChild(root_1, root_2);
                        }
                        adaptor.addChild(root_1, stream_statement.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:170:1: predicate : ( '!' predicate | expression | expression '.' type '?' ) ( '&&' predicate | '||' predicate )* ;
    public final WaebricParser.predicate_return predicate() throws RecognitionException {
        WaebricParser.predicate_return retval = new WaebricParser.predicate_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal129=null;
        Token char_literal133=null;
        Token char_literal135=null;
        Token string_literal136=null;
        Token string_literal138=null;
        WaebricParser.predicate_return predicate130 = null;

        WaebricParser.expression_return expression131 = null;

        WaebricParser.expression_return expression132 = null;

        WaebricParser.type_return type134 = null;

        WaebricParser.predicate_return predicate137 = null;

        WaebricParser.predicate_return predicate139 = null;


        Object char_literal129_tree=null;
        Object char_literal133_tree=null;
        Object char_literal135_tree=null;
        Object string_literal136_tree=null;
        Object string_literal138_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:170:10: ( ( '!' predicate | expression | expression '.' type '?' ) ( '&&' predicate | '||' predicate )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:170:13: ( '!' predicate | expression | expression '.' type '?' ) ( '&&' predicate | '||' predicate )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:170:13: ( '!' predicate | expression | expression '.' type '?' )
            int alt28=3;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:170:15: '!' predicate
                    {
                    char_literal129=(Token)match(input,65,FOLLOW_65_in_predicate1176); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal129_tree = (Object)adaptor.create(char_literal129);
                    adaptor.addChild(root_0, char_literal129_tree);
                    }
                    pushFollow(FOLLOW_predicate_in_predicate1178);
                    predicate130=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate130.getTree());

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:171:7: expression
                    {
                    pushFollow(FOLLOW_expression_in_predicate1187);
                    expression131=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression131.getTree());

                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:172:7: expression '.' type '?'
                    {
                    pushFollow(FOLLOW_expression_in_predicate1196);
                    expression132=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression132.getTree());
                    char_literal133=(Token)match(input,41,FOLLOW_41_in_predicate1198); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal133_tree = (Object)adaptor.create(char_literal133);
                    adaptor.addChild(root_0, char_literal133_tree);
                    }
                    pushFollow(FOLLOW_type_in_predicate1200);
                    type134=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, type134.getTree());
                    char_literal135=(Token)match(input,66,FOLLOW_66_in_predicate1202); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal135_tree = (Object)adaptor.create(char_literal135);
                    adaptor.addChild(root_0, char_literal135_tree);
                    }

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:173:6: ( '&&' predicate | '||' predicate )*
            loop29:
            do {
                int alt29=3;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==67) ) {
                    int LA29_2 = input.LA(2);

                    if ( (synpred52_Waebric()) ) {
                        alt29=1;
                    }


                }
                else if ( (LA29_0==68) ) {
                    int LA29_3 = input.LA(2);

                    if ( (synpred53_Waebric()) ) {
                        alt29=2;
                    }


                }


                switch (alt29) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:173:8: '&&' predicate
            	    {
            	    string_literal136=(Token)match(input,67,FOLLOW_67_in_predicate1212); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal136_tree = (Object)adaptor.create(string_literal136);
            	    adaptor.addChild(root_0, string_literal136_tree);
            	    }
            	    pushFollow(FOLLOW_predicate_in_predicate1214);
            	    predicate137=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate137.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:173:25: '||' predicate
            	    {
            	    string_literal138=(Token)match(input,68,FOLLOW_68_in_predicate1218); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal138_tree = (Object)adaptor.create(string_literal138);
            	    adaptor.addChild(root_0, string_literal138_tree);
            	    }
            	    pushFollow(FOLLOW_predicate_in_predicate1220);
            	    predicate139=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate139.getTree());

            	    }
            	    break;

            	default :
            	    break loop29;
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
    // $ANTLR end "predicate"

    public static class type_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:174:1: type : ( 'list' | 'record' | 'string' );
    public final WaebricParser.type_return type() throws RecognitionException {
        WaebricParser.type_return retval = new WaebricParser.type_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set140=null;

        Object set140_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:174:5: ( 'list' | 'record' | 'string' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:
            {
            root_0 = (Object)adaptor.nil();

            set140=(Token)input.LT(1);
            if ( (input.LA(1)>=69 && input.LA(1)<=71) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set140));
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:179:1: embedding : PRETEXT embed textTail ;
    public final WaebricParser.embedding_return embedding() throws RecognitionException {
        WaebricParser.embedding_return retval = new WaebricParser.embedding_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PRETEXT141=null;
        WaebricParser.embed_return embed142 = null;

        WaebricParser.textTail_return textTail143 = null;


        Object PRETEXT141_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:179:10: ( PRETEXT embed textTail )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:179:13: PRETEXT embed textTail
            {
            root_0 = (Object)adaptor.nil();

            PRETEXT141=(Token)match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding1253); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRETEXT141_tree = (Object)adaptor.create(PRETEXT141);
            adaptor.addChild(root_0, PRETEXT141_tree);
            }
            pushFollow(FOLLOW_embed_in_embedding1255);
            embed142=embed();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, embed142.getTree());
            pushFollow(FOLLOW_textTail_in_embedding1257);
            textTail143=textTail();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, textTail143.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:180:1: embed : ( ( markup )* expression | ( markup )* markup );
    public final WaebricParser.embed_return embed() throws RecognitionException {
        WaebricParser.embed_return retval = new WaebricParser.embed_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WaebricParser.markup_return markup144 = null;

        WaebricParser.expression_return expression145 = null;

        WaebricParser.markup_return markup146 = null;

        WaebricParser.markup_return markup147 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:180:6: ( ( markup )* expression | ( markup )* markup )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==IDCON) ) {
                int LA32_1 = input.LA(2);

                if ( (synpred57_Waebric()) ) {
                    alt32=1;
                }
                else if ( (true) ) {
                    alt32=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 32, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA32_0>=NATCON && LA32_0<=SYMBOLCON)||LA32_0==52||LA32_0==54) ) {
                alt32=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:180:10: ( markup )* expression
                    {
                    root_0 = (Object)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:180:10: ( markup )*
                    loop30:
                    do {
                        int alt30=2;
                        alt30 = dfa30.predict(input);
                        switch (alt30) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_embed1266);
                    	    markup144=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, markup144.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);

                    pushFollow(FOLLOW_expression_in_embed1269);
                    expression145=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression145.getTree());

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:180:31: ( markup )* markup
                    {
                    root_0 = (Object)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:180:31: ( markup )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==IDCON) ) {
                            int LA31_1 = input.LA(2);

                            if ( (synpred58_Waebric()) ) {
                                alt31=1;
                            }


                        }


                        switch (alt31) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_embed1273);
                    	    markup146=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, markup146.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);

                    pushFollow(FOLLOW_markup_in_embed1276);
                    markup147=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, markup147.getTree());

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

    public static class textTail_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "textTail"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:181:1: textTail : ( POSTTEXT | MIDTEXT embed textTail );
    public final WaebricParser.textTail_return textTail() throws RecognitionException {
        WaebricParser.textTail_return retval = new WaebricParser.textTail_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token POSTTEXT148=null;
        Token MIDTEXT149=null;
        WaebricParser.embed_return embed150 = null;

        WaebricParser.textTail_return textTail151 = null;


        Object POSTTEXT148_tree=null;
        Object MIDTEXT149_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:181:9: ( POSTTEXT | MIDTEXT embed textTail )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==POSTTEXT) ) {
                alt33=1;
            }
            else if ( (LA33_0==MIDTEXT) ) {
                alt33=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:181:12: POSTTEXT
                    {
                    root_0 = (Object)adaptor.nil();

                    POSTTEXT148=(Token)match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail1284); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    POSTTEXT148_tree = (Object)adaptor.create(POSTTEXT148);
                    adaptor.addChild(root_0, POSTTEXT148_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:181:23: MIDTEXT embed textTail
                    {
                    root_0 = (Object)adaptor.nil();

                    MIDTEXT149=(Token)match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail1288); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MIDTEXT149_tree = (Object)adaptor.create(MIDTEXT149);
                    adaptor.addChild(root_0, MIDTEXT149_tree);
                    }
                    pushFollow(FOLLOW_embed_in_textTail1290);
                    embed150=embed();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, embed150.getTree());
                    pushFollow(FOLLOW_textTail_in_textTail1292);
                    textTail151=textTail();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, textTail151.getTree());

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
    // $ANTLR end "textTail"

    // $ANTLR start synpred26_Waebric
    public final void synpred26_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:113:8: ( '+' expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:113:8: '+' expression
        {
        match(input,56,FOLLOW_56_in_synpred26_Waebric570); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred26_Waebric572);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_Waebric

    // $ANTLR start synpred27_Waebric
    public final void synpred27_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:113:35: ( '.' IDCON )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:113:35: '.' IDCON
        {
        match(input,41,FOLLOW_41_in_synpred27_Waebric578); if (state.failed) return ;
        match(input,IDCON,FOLLOW_IDCON_in_synpred27_Waebric580); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred27_Waebric

    // $ANTLR start synpred32_Waebric
    public final void synpred32_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:129:48: ( 'else' statement )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:129:48: 'else' statement
        {
        match(input,58,FOLLOW_58_in_synpred32_Waebric704); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred32_Waebric706);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_Waebric

    // $ANTLR start synpred45_Waebric
    public final void synpred45_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:149:15: ( expression ';' )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:149:15: expression ';'
        {
        pushFollow(FOLLOW_expression_in_synpred45_Waebric987);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred45_Waebric989); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred45_Waebric

    // $ANTLR start synpred46_Waebric
    public final void synpred46_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:151:6: ( statement )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:151:6: statement
        {
        pushFollow(FOLLOW_statement_in_synpred46_Waebric1013);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_Waebric

    // $ANTLR start synpred48_Waebric
    public final void synpred48_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:155:6: ( markup markupChain )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:155:6: markup markupChain
        {
        pushFollow(FOLLOW_markup_in_synpred48_Waebric1062);
        markup();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_markupChain_in_synpred48_Waebric1064);
        markupChain();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred48_Waebric

    // $ANTLR start synpred51_Waebric
    public final void synpred51_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:171:7: ( expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:171:7: expression
        {
        pushFollow(FOLLOW_expression_in_synpred51_Waebric1187);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred51_Waebric

    // $ANTLR start synpred52_Waebric
    public final void synpred52_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:173:8: ( '&&' predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:173:8: '&&' predicate
        {
        match(input,67,FOLLOW_67_in_synpred52_Waebric1212); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred52_Waebric1214);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred52_Waebric

    // $ANTLR start synpred53_Waebric
    public final void synpred53_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:173:25: ( '||' predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:173:25: '||' predicate
        {
        match(input,68,FOLLOW_68_in_synpred53_Waebric1218); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred53_Waebric1220);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred53_Waebric

    // $ANTLR start synpred57_Waebric
    public final void synpred57_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:180:10: ( ( markup )* expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:180:10: ( markup )* expression
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:180:10: ( markup )*
        loop42:
        do {
            int alt42=2;
            alt42 = dfa42.predict(input);
            switch (alt42) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred57_Waebric1266);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop42;
            }
        } while (true);

        pushFollow(FOLLOW_expression_in_synpred57_Waebric1269);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred57_Waebric

    // $ANTLR start synpred58_Waebric
    public final void synpred58_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:180:31: ( markup )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:180:31: markup
        {
        pushFollow(FOLLOW_markup_in_synpred58_Waebric1273);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred58_Waebric

    // Delegated rules

    public final boolean synpred45_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_Waebric_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred46_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_Waebric_fragment(); // can never throw exception
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
    public final boolean synpred27_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_Waebric_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred57_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred57_Waebric_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred48_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred48_Waebric_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred58_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred58_Waebric_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred52_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred52_Waebric_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_Waebric_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred51_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred51_Waebric_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred53_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred53_Waebric_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA25 dfa25 = new DFA25(this);
    protected DFA26 dfa26 = new DFA26(this);
    protected DFA28 dfa28 = new DFA28(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA42 dfa42 = new DFA42(this);
    static final String DFA25_eotS =
        "\14\uffff";
    static final String DFA25_eofS =
        "\14\uffff";
    static final String DFA25_minS =
        "\1\13\5\uffff\1\13\5\uffff";
    static final String DFA25_maxS =
        "\1\100\5\uffff\1\66\5\uffff";
    static final String DFA25_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\11\1\12\1\6\1\7";
    static final String DFA25_specialS =
        "\14\uffff}>";
    static final String[] DFA25_transitionS = {
            "\1\11\10\uffff\1\5\41\uffff\1\4\2\uffff\1\1\1\uffff\1\2\1\3"+
            "\1\uffff\1\6\1\7\1\10",
            "",
            "",
            "",
            "",
            "",
            "\1\12\1\uffff\3\12\1\uffff\1\13\42\uffff\1\12\1\uffff\1\12",
            "",
            "",
            "",
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
            return "129:1: statement : ( 'if' '(' predicate ')' statement ( 'else' statement )? -> ^( 'if' predicate statement ( 'else' statement )? ) | 'each' '(' IDCON ':' expression ')' statement -> ^( 'each' '(' IDCON ':' expression ')' statement ) | 'let' ( assignment )+ 'in' ( statement )* 'end' -> ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | '{' ( statement )* '}' -> ^( '{' ( statement )* '}' ) | 'comment' STRCON ';' -> ^( 'comment' STRCON ) | 'echo' expression ';' -> ^( 'echo' expression ) | 'echo' embedding ';' -> ^( 'echo' embedding ) | 'cdata' expression ';' -> ^( 'cdata' expression ) | 'yield;' | markup markupChain -> ^( MARKUP_STATEMENT markup markupChain ) );";
        }
    }
    static final String DFA26_eotS =
        "\21\uffff";
    static final String DFA26_eofS =
        "\21\uffff";
    static final String DFA26_minS =
        "\1\13\1\0\4\uffff\1\0\12\uffff";
    static final String DFA26_maxS =
        "\1\100\1\0\4\uffff\1\0\12\uffff";
    static final String DFA26_acceptS =
        "\2\uffff\1\1\4\uffff\1\2\6\uffff\1\3\1\5\1\4";
    static final String DFA26_specialS =
        "\1\uffff\1\0\4\uffff\1\1\12\uffff}>";
    static final String[] DFA26_transitionS = {
            "\1\1\1\uffff\3\2\1\uffff\1\16\2\uffff\1\7\2\uffff\1\17\34\uffff"+
            "\1\2\1\uffff\1\6\2\uffff\1\7\1\uffff\2\7\1\uffff\3\7",
            "\1\uffff",
            "",
            "",
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
            return "149:1: markupChain : ( expression ';' -> ^( MARKUP_CHAIN expression ';' ) | statement -> ^( MARKUP_CHAIN statement ) | embedding ';' -> ^( MARKUP_CHAIN embedding ';' ) | markup markupChain -> ^( MARKUP_CHAIN markup markupChain ) | ';' -> ^( MARKUP_CHAIN ';' ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA26_1 = input.LA(1);

                         
                        int index26_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_Waebric()) ) {s = 2;}

                        else if ( (synpred46_Waebric()) ) {s = 7;}

                        else if ( (synpred48_Waebric()) ) {s = 16;}

                         
                        input.seek(index26_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA26_6 = input.LA(1);

                         
                        int index26_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_Waebric()) ) {s = 2;}

                        else if ( (synpred46_Waebric()) ) {s = 7;}

                         
                        input.seek(index26_6);
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
    static final String DFA28_eotS =
        "\12\uffff";
    static final String DFA28_eofS =
        "\12\uffff";
    static final String DFA28_minS =
        "\1\13\1\uffff\6\0\2\uffff";
    static final String DFA28_maxS =
        "\1\101\1\uffff\6\0\2\uffff";
    static final String DFA28_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\1\3";
    static final String DFA28_specialS =
        "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\2\uffff}>";
    static final String[] DFA28_transitionS = {
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
            return "170:13: ( '!' predicate | expression | expression '.' type '?' )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA28_2 = input.LA(1);

                         
                        int index28_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_Waebric()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index28_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA28_3 = input.LA(1);

                         
                        int index28_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_Waebric()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index28_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA28_4 = input.LA(1);

                         
                        int index28_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_Waebric()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index28_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA28_5 = input.LA(1);

                         
                        int index28_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_Waebric()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index28_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA28_6 = input.LA(1);

                         
                        int index28_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_Waebric()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index28_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA28_7 = input.LA(1);

                         
                        int index28_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_Waebric()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index28_7);
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
        "\6\uffff";
    static final String DFA30_eofS =
        "\6\uffff";
    static final String DFA30_minS =
        "\2\13\2\uffff\2\13";
    static final String DFA30_maxS =
        "\1\66\1\70\2\uffff\1\13\1\70";
    static final String DFA30_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA30_specialS =
        "\6\uffff}>";
    static final String[] DFA30_transitionS = {
            "\1\1\1\uffff\3\2\44\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\2\uffff\2\2\25\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\3\uffff\1\3\1\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\2\uffff\2\2\25\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\3\uffff\1\3\1\uffff\1\3\1\uffff\1\2"
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
            return "()* loopback of 180:10: ( markup )*";
        }
    }
    static final String DFA42_eotS =
        "\6\uffff";
    static final String DFA42_eofS =
        "\1\uffff\1\2\3\uffff\1\2";
    static final String DFA42_minS =
        "\2\13\2\uffff\2\13";
    static final String DFA42_maxS =
        "\1\66\1\70\2\uffff\1\13\1\70";
    static final String DFA42_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA42_specialS =
        "\6\uffff}>";
    static final String[] DFA42_transitionS = {
            "\1\1\1\uffff\3\2\44\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\31\uffff\1\4\1\uffff\4\3\1\uffff\1\3\3\uffff"+
            "\1\3\1\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\31\uffff\1\4\1\uffff\4\3\1\uffff\1\3\3\uffff"+
            "\1\3\1\uffff\1\3\1\uffff\1\2"
    };

    static final short[] DFA42_eot = DFA.unpackEncodedString(DFA42_eotS);
    static final short[] DFA42_eof = DFA.unpackEncodedString(DFA42_eofS);
    static final char[] DFA42_min = DFA.unpackEncodedStringToUnsignedChars(DFA42_minS);
    static final char[] DFA42_max = DFA.unpackEncodedStringToUnsignedChars(DFA42_maxS);
    static final short[] DFA42_accept = DFA.unpackEncodedString(DFA42_acceptS);
    static final short[] DFA42_special = DFA.unpackEncodedString(DFA42_specialS);
    static final short[][] DFA42_transition;

    static {
        int numStates = DFA42_transitionS.length;
        DFA42_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA42_transition[i] = DFA.unpackEncodedString(DFA42_transitionS[i]);
        }
    }

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = DFA42_eot;
            this.eof = DFA42_eof;
            this.min = DFA42_min;
            this.max = DFA42_max;
            this.accept = DFA42_accept;
            this.special = DFA42_special;
            this.transition = DFA42_transition;
        }
        public String getDescription() {
            return "()* loopback of 180:10: ( markup )*";
        }
    }
 

    public static final BitSet FOLLOW_40_in_module135 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_moduleId_in_module137 = new BitSet(new long[]{0x0000040000200402L});
    public static final BitSet FOLLOW_imprt_in_module143 = new BitSet(new long[]{0x0000040000200402L});
    public static final BitSet FOLLOW_site_in_module147 = new BitSet(new long[]{0x0000040000200402L});
    public static final BitSet FOLLOW_function_in_module151 = new BitSet(new long[]{0x0000040000200402L});
    public static final BitSet FOLLOW_IDCON_in_moduleId203 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_moduleId213 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDCON_in_moduleId217 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_42_in_imprt233 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_moduleId_in_imprt235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SITE_in_site251 = new BitSet(new long[]{0x0000000000C01000L});
    public static final BitSet FOLLOW_mappings_in_site253 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_END_in_site255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapping_in_mappings263 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_SEMICOLON_in_mappings268 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_mapping_in_mappings270 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_PATH_in_mapping282 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_mapping284 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_markup_in_mapping286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_markup299 = new BitSet(new long[]{0x00017A0000000000L});
    public static final BitSet FOLLOW_attributes_in_markup301 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_arguments_in_markup303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attribute_in_attributes334 = new BitSet(new long[]{0x00007A0000000002L});
    public static final BitSet FOLLOW_44_in_attribute360 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDCON_in_attribute362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_attribute370 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDCON_in_attribute372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_attribute380 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDCON_in_attribute382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_attribute390 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDCON_in_attribute392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_attribute400 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NATCON_in_attribute402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_attribute410 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NATCON_in_attribute412 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_attribute414 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NATCON_in_attribute416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_arguments430 = new BitSet(new long[]{0x005600000000E800L});
    public static final BitSet FOLLOW_argument_in_arguments432 = new BitSet(new long[]{0x0006000000000000L});
    public static final BitSet FOLLOW_49_in_arguments437 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_argument_in_arguments439 = new BitSet(new long[]{0x0006000000000000L});
    public static final BitSet FOLLOW_50_in_arguments444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_argument475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_argument483 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_argument485 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_argument487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_expression502 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_NATCON_in_expression506 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_TEXT_in_expression510 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_SYMBOLCON_in_expression514 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_52_in_expression523 = new BitSet(new long[]{0x007200000000E800L});
    public static final BitSet FOLLOW_expression_in_expression525 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_49_in_expression530 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_expression532 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_53_in_expression537 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_54_in_expression546 = new BitSet(new long[]{0x0082000000000800L});
    public static final BitSet FOLLOW_keyValuePair_in_expression548 = new BitSet(new long[]{0x0082000000000000L});
    public static final BitSet FOLLOW_49_in_expression553 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_keyValuePair_in_expression555 = new BitSet(new long[]{0x0082000000000000L});
    public static final BitSet FOLLOW_55_in_expression560 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_56_in_expression570 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_expression572 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_41_in_expression578 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDCON_in_expression580 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_IDCON_in_keyValuePair593 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_keyValuePair595 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_keyValuePair597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_function609 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDCON_in_function611 = new BitSet(new long[]{0xDA41000000500800L,0x0000000000000001L});
    public static final BitSet FOLLOW_formals_in_function613 = new BitSet(new long[]{0xDA40000000500800L,0x0000000000000001L});
    public static final BitSet FOLLOW_statement_in_function616 = new BitSet(new long[]{0xDA40000000500800L,0x0000000000000001L});
    public static final BitSet FOLLOW_END_in_function619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_formals656 = new BitSet(new long[]{0x0006000000000800L});
    public static final BitSet FOLLOW_IDCON_in_formals658 = new BitSet(new long[]{0x0006000000000000L});
    public static final BitSet FOLLOW_49_in_formals663 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDCON_in_formals665 = new BitSet(new long[]{0x0006000000000000L});
    public static final BitSet FOLLOW_50_in_formals670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_statement692 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_statement694 = new BitSet(new long[]{0x005000000000E800L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_statement696 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_statement698 = new BitSet(new long[]{0xDA40000000100800L,0x0000000000000001L});
    public static final BitSet FOLLOW_statement_in_statement700 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_58_in_statement704 = new BitSet(new long[]{0xDA40000000100800L,0x0000000000000001L});
    public static final BitSet FOLLOW_statement_in_statement706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_statement741 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_statement743 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDCON_in_statement745 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_statement747 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_statement749 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_statement751 = new BitSet(new long[]{0xDA40000000100800L,0x0000000000000001L});
    public static final BitSet FOLLOW_statement_in_statement753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_statement785 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_assignment_in_statement787 = new BitSet(new long[]{0x2000000000000800L});
    public static final BitSet FOLLOW_61_in_statement790 = new BitSet(new long[]{0xDA40000000500800L,0x0000000000000001L});
    public static final BitSet FOLLOW_statement_in_statement792 = new BitSet(new long[]{0xDA40000000500800L,0x0000000000000001L});
    public static final BitSet FOLLOW_END_in_statement795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_statement824 = new BitSet(new long[]{0xDAC0000000100800L,0x0000000000000001L});
    public static final BitSet FOLLOW_statement_in_statement826 = new BitSet(new long[]{0xDAC0000000100800L,0x0000000000000001L});
    public static final BitSet FOLLOW_55_in_statement829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMENT_in_statement853 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_STRCON_in_statement855 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_statement878 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_statement880 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_statement903 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_embedding_in_statement905 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_statement928 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_statement930 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_statement954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement961 = new BitSet(new long[]{0xDA5000000092E800L,0x0000000000000001L});
    public static final BitSet FOLLOW_markupChain_in_statement963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_markupChain987 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_markupChain989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_markupChain1013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_embedding_in_markupChain1036 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_markupChain1038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_markupChain1062 = new BitSet(new long[]{0xDA5000000092E800L,0x0000000000000001L});
    public static final BitSet FOLLOW_markupChain_in_markupChain1064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_markupChain1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_assignment1115 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_assignment1117 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_assignment1119 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_assignment1121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_assignment1129 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_formals_in_assignment1131 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_assignment1133 = new BitSet(new long[]{0xDA40000000100800L,0x0000000000000001L});
    public static final BitSet FOLLOW_statement_in_assignment1135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_predicate1176 = new BitSet(new long[]{0x005000000000E800L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_predicate1178 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_expression_in_predicate1187 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_expression_in_predicate1196 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_predicate1198 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_type_in_predicate1200 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_predicate1202 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_67_in_predicate1212 = new BitSet(new long[]{0x005000000000E800L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_predicate1214 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_68_in_predicate1218 = new BitSet(new long[]{0x005000000000E800L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_predicate1220 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding1253 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_embed_in_embedding1255 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_textTail_in_embedding1257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed1266 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_embed1269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed1273 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_markup_in_embed1276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail1284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail1288 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_embed_in_textTail1290 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_textTail_in_textTail1292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred26_Waebric570 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_synpred26_Waebric572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_synpred27_Waebric578 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDCON_in_synpred27_Waebric580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_synpred32_Waebric704 = new BitSet(new long[]{0xDA40000000100800L,0x0000000000000001L});
    public static final BitSet FOLLOW_statement_in_synpred32_Waebric706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred45_Waebric987 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred45_Waebric989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_synpred46_Waebric1013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred48_Waebric1062 = new BitSet(new long[]{0xDA5000000092E800L,0x0000000000000001L});
    public static final BitSet FOLLOW_markupChain_in_synpred48_Waebric1064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred51_Waebric1187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_synpred52_Waebric1212 = new BitSet(new long[]{0x005000000000E800L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_synpred52_Waebric1214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_synpred53_Waebric1218 = new BitSet(new long[]{0x005000000000E800L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_synpred53_Waebric1220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred57_Waebric1266 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_synpred57_Waebric1269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred58_Waebric1273 = new BitSet(new long[]{0x0000000000000002L});

}