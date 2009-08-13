// $ANTLR 3.1.2 /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g 2009-08-13 15:43:17

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDCON", "PATH", "NATCON", "TEXT", "SYMBOLCON", "STRCON", "PRETEXT", "POSTTEXT", "MIDTEXT", "COMMENT", "SITE", "END", "SEMICOLON", "LETTER", "DIGIT", "HEXADECIMAL", "PATHELEMENT", "FILEEXT", "STRCHAR", "ESCLAYOUT", "DECIMAL", "TEXTCHAR", "ESCQUOTE", "AMP", "CHARREF", "ENTREF", "SYMBOLCHAR", "COMMENTS", "LAYOUT", "'module'", "'.'", "'import'", "':'", "'#'", "'$'", "'@'", "'%'", "'('", "','", "')'", "'['", "']'", "'{'", "'}'", "'+'", "'def'", "'if'", "'else'", "'each'", "'let'", "'in'", "'echo'", "'cdata'", "'yield;'", "'='", "'!'", "'&&'", "'||'", "'list'", "'record'", "'string'"
    };
    public static final int T__64=64;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int AMP=27;
    public static final int LETTER=17;
    public static final int ESCLAYOUT=23;
    public static final int PATHELEMENT=20;
    public static final int TEXTCHAR=25;
    public static final int STRCON=9;
    public static final int PRETEXT=10;
    public static final int T__61=61;
    public static final int EOF=-1;
    public static final int T__60=60;
    public static final int POSTTEXT=11;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int FILEEXT=21;
    public static final int T__52=52;
    public static final int COMMENTS=31;
    public static final int CHARREF=28;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int IDCON=4;
    public static final int PATH=5;
    public static final int T__59=59;
    public static final int STRCHAR=22;
    public static final int DIGIT=18;
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
    public static final int SITE=14;
    public static final int SYMBOLCON=8;
    public static final int HEXADECIMAL=19;
    public static final int SEMICOLON=16;
    public static final int SYMBOLCHAR=30;
    public static final int TEXT=7;
    public static final int LAYOUT=32;
    public static final int NATCON=6;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int DECIMAL=24;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int ENTREF=29;
    public static final int ESCQUOTE=26;
    public static final int END=15;

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
    public String getGrammarFileName() { return "/ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g"; }


    	/**
    	 * Parse file on specified path.
    	 * @return AST
    	 */
    	private CommonTree parseFile(String path) throws RecognitionException {
    		try {
    			CharStream is = new ANTLRFileStream(path);
    			WaebricLexer lexer = new WaebricLexer(is);
    			CommonTokenStream tokens = new CommonTokenStream(lexer);
          			WaebricParser parser = new WaebricParser(tokens);
          			return (CommonTree) parser.module().getTree();
          		} catch(java.io.IOException e) { return new CommonTree(); }
    	}


    public static class module_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "module"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:41:1: module : 'module' moduleId ( imprt | site | function )* -> ^( 'module' moduleId ( imprt )* ( site )* ( function )* ) ;
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
        RewriteRuleTokenStream stream_33=new RewriteRuleTokenStream(adaptor,"token 33");
        RewriteRuleSubtreeStream stream_site=new RewriteRuleSubtreeStream(adaptor,"rule site");
        RewriteRuleSubtreeStream stream_moduleId=new RewriteRuleSubtreeStream(adaptor,"rule moduleId");
        RewriteRuleSubtreeStream stream_imprt=new RewriteRuleSubtreeStream(adaptor,"rule imprt");
        RewriteRuleSubtreeStream stream_function=new RewriteRuleSubtreeStream(adaptor,"rule function");
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:41:7: ( 'module' moduleId ( imprt | site | function )* -> ^( 'module' moduleId ( imprt )* ( site )* ( function )* ) )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:41:11: 'module' moduleId ( imprt | site | function )*
            {
            string_literal1=(Token)match(input,33,FOLLOW_33_in_module72); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_33.add(string_literal1);

            pushFollow(FOLLOW_moduleId_in_module74);
            moduleId2=moduleId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_moduleId.add(moduleId2.getTree());
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:41:29: ( imprt | site | function )*
            loop1:
            do {
                int alt1=4;
                switch ( input.LA(1) ) {
                case 35:
                    {
                    alt1=1;
                    }
                    break;
                case SITE:
                    {
                    alt1=2;
                    }
                    break;
                case 49:
                    {
                    alt1=3;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:41:31: imprt
            	    {
            	    pushFollow(FOLLOW_imprt_in_module78);
            	    imprt3=imprt();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_imprt.add(imprt3.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:41:39: site
            	    {
            	    pushFollow(FOLLOW_site_in_module82);
            	    site4=site();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_site.add(site4.getTree());

            	    }
            	    break;
            	case 3 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:41:46: function
            	    {
            	    pushFollow(FOLLOW_function_in_module86);
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
            // elements: function, 33, site, imprt, moduleId
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 42:5: -> ^( 'module' moduleId ( imprt )* ( site )* ( function )* )
            {
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:42:8: ^( 'module' moduleId ( imprt )* ( site )* ( function )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_33.nextNode(), root_1);

                adaptor.addChild(root_1, stream_moduleId.nextTree());
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:42:29: ( imprt )*
                while ( stream_imprt.hasNext() ) {
                    adaptor.addChild(root_1, stream_imprt.nextTree());

                }
                stream_imprt.reset();
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:42:36: ( site )*
                while ( stream_site.hasNext() ) {
                    adaptor.addChild(root_1, stream_site.nextTree());

                }
                stream_site.reset();
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:42:42: ( function )*
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:44:1: moduleId returns [String path = \"\"] : e= IDCON ( '.' e= IDCON )* ;
    public final WaebricParser.moduleId_return moduleId() throws RecognitionException {
        WaebricParser.moduleId_return retval = new WaebricParser.moduleId_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token e=null;
        Token char_literal6=null;

        Object e_tree=null;
        Object char_literal6_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:47:2: (e= IDCON ( '.' e= IDCON )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:47:5: e= IDCON ( '.' e= IDCON )*
            {
            root_0 = (Object)adaptor.nil();

            e=(Token)match(input,IDCON,FOLLOW_IDCON_in_moduleId140); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            e_tree = (Object)adaptor.create(e);
            adaptor.addChild(root_0, e_tree);
            }
            if ( state.backtracking==0 ) {
               retval.path += e.getText(); 
            }
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:48:4: ( '.' e= IDCON )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==34) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:48:6: '.' e= IDCON
            	    {
            	    char_literal6=(Token)match(input,34,FOLLOW_34_in_moduleId150); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal6_tree = (Object)adaptor.create(char_literal6);
            	    adaptor.addChild(root_0, char_literal6_tree);
            	    }
            	    e=(Token)match(input,IDCON,FOLLOW_IDCON_in_moduleId154); if (state.failed) return retval;
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:50:1: imprt : 'import' id= moduleId ';' -> 'import' moduleId ';' ^() ;
    public final WaebricParser.imprt_return imprt() throws RecognitionException {
        WaebricParser.imprt_return retval = new WaebricParser.imprt_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal7=null;
        Token char_literal8=null;
        WaebricParser.moduleId_return id = null;


        Object string_literal7_tree=null;
        Object char_literal8_tree=null;
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
        RewriteRuleSubtreeStream stream_moduleId=new RewriteRuleSubtreeStream(adaptor,"rule moduleId");
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:50:6: ( 'import' id= moduleId ';' -> 'import' moduleId ';' ^() )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:50:10: 'import' id= moduleId ';'
            {
            string_literal7=(Token)match(input,35,FOLLOW_35_in_imprt170); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_35.add(string_literal7);

            pushFollow(FOLLOW_moduleId_in_imprt174);
            id=moduleId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_moduleId.add(id.getTree());
            char_literal8=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_imprt176); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal8);



            // AST REWRITE
            // elements: SEMICOLON, moduleId, 35
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 51:5: -> 'import' moduleId ';' ^()
            {
                adaptor.addChild(root_0, stream_35.nextNode());
                adaptor.addChild(root_0, stream_moduleId.nextTree());
                adaptor.addChild(root_0, stream_SEMICOLON.nextNode());
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:51:30: ^()
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot( parseFile((id!=null?id.path:null)) , root_1);

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
    // $ANTLR end "imprt"

    public static class site_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "site"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:56:1: site : 'site' mappings 'end' ;
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:56:5: ( 'site' mappings 'end' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:56:9: 'site' mappings 'end'
            {
            root_0 = (Object)adaptor.nil();

            string_literal9=(Token)match(input,SITE,FOLLOW_SITE_in_site208); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal9_tree = (Object)adaptor.create(string_literal9);
            adaptor.addChild(root_0, string_literal9_tree);
            }
            pushFollow(FOLLOW_mappings_in_site210);
            mappings10=mappings();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mappings10.getTree());
            string_literal11=(Token)match(input,END,FOLLOW_END_in_site212); if (state.failed) return retval;
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:57:1: mappings : ( mapping )? ( ';' mapping )* ;
    public final WaebricParser.mappings_return mappings() throws RecognitionException {
        WaebricParser.mappings_return retval = new WaebricParser.mappings_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal13=null;
        WaebricParser.mapping_return mapping12 = null;

        WaebricParser.mapping_return mapping14 = null;


        Object char_literal13_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:57:9: ( ( mapping )? ( ';' mapping )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:57:12: ( mapping )? ( ';' mapping )*
            {
            root_0 = (Object)adaptor.nil();

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:57:12: ( mapping )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==PATH) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: mapping
                    {
                    pushFollow(FOLLOW_mapping_in_mappings220);
                    mapping12=mapping();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, mapping12.getTree());

                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:57:21: ( ';' mapping )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==SEMICOLON) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:57:23: ';' mapping
            	    {
            	    char_literal13=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_mappings225); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal13_tree = (Object)adaptor.create(char_literal13);
            	    adaptor.addChild(root_0, char_literal13_tree);
            	    }
            	    pushFollow(FOLLOW_mapping_in_mappings227);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:58:1: mapping : PATH ':' markup ;
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:58:9: ( PATH ':' markup )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:58:12: PATH ':' markup
            {
            root_0 = (Object)adaptor.nil();

            PATH15=(Token)match(input,PATH,FOLLOW_PATH_in_mapping239); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PATH15_tree = (Object)adaptor.create(PATH15);
            adaptor.addChild(root_0, PATH15_tree);
            }
            char_literal16=(Token)match(input,36,FOLLOW_36_in_mapping241); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal16_tree = (Object)adaptor.create(char_literal16);
            adaptor.addChild(root_0, char_literal16_tree);
            }
            pushFollow(FOLLOW_markup_in_mapping243);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:63:1: markup : IDCON ( attribute )* ( arguments )? ;
    public final WaebricParser.markup_return markup() throws RecognitionException {
        WaebricParser.markup_return retval = new WaebricParser.markup_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDCON18=null;
        WaebricParser.attribute_return attribute19 = null;

        WaebricParser.arguments_return arguments20 = null;


        Object IDCON18_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:63:7: ( IDCON ( attribute )* ( arguments )? )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:63:11: IDCON ( attribute )* ( arguments )?
            {
            root_0 = (Object)adaptor.nil();

            IDCON18=(Token)match(input,IDCON,FOLLOW_IDCON_in_markup256); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON18_tree = (Object)adaptor.create(IDCON18);
            root_0 = (Object)adaptor.becomeRoot(IDCON18_tree, root_0);
            }
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:63:18: ( attribute )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==34||(LA5_0>=36 && LA5_0<=39)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: attribute
            	    {
            	    pushFollow(FOLLOW_attribute_in_markup259);
            	    attribute19=attribute();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, attribute19.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:63:29: ( arguments )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==41) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: arguments
                    {
                    pushFollow(FOLLOW_arguments_in_markup262);
                    arguments20=arguments();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arguments20.getTree());

                    }
                    break;

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
    // $ANTLR end "markup"

    public static class attribute_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attribute"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:64:1: attribute : ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON );
    public final WaebricParser.attribute_return attribute() throws RecognitionException {
        WaebricParser.attribute_return retval = new WaebricParser.attribute_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal21=null;
        Token IDCON22=null;
        Token char_literal23=null;
        Token IDCON24=null;
        Token char_literal25=null;
        Token IDCON26=null;
        Token char_literal27=null;
        Token IDCON28=null;
        Token char_literal29=null;
        Token NATCON30=null;
        Token char_literal31=null;
        Token NATCON32=null;
        Token char_literal33=null;
        Token NATCON34=null;

        Object char_literal21_tree=null;
        Object IDCON22_tree=null;
        Object char_literal23_tree=null;
        Object IDCON24_tree=null;
        Object char_literal25_tree=null;
        Object IDCON26_tree=null;
        Object char_literal27_tree=null;
        Object IDCON28_tree=null;
        Object char_literal29_tree=null;
        Object NATCON30_tree=null;
        Object char_literal31_tree=null;
        Object NATCON32_tree=null;
        Object char_literal33_tree=null;
        Object NATCON34_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:64:10: ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON )
            int alt7=6;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt7=1;
                }
                break;
            case 34:
                {
                alt7=2;
                }
                break;
            case 38:
                {
                alt7=3;
                }
                break;
            case 36:
                {
                alt7=4;
                }
                break;
            case 39:
                {
                int LA7_5 = input.LA(2);

                if ( (LA7_5==NATCON) ) {
                    int LA7_6 = input.LA(3);

                    if ( (LA7_6==40) ) {
                        alt7=6;
                    }
                    else if ( (LA7_6==EOF||LA7_6==IDCON||(LA7_6>=NATCON && LA7_6<=SYMBOLCON)||(LA7_6>=PRETEXT && LA7_6<=COMMENT)||(LA7_6>=END && LA7_6<=SEMICOLON)||LA7_6==34||(LA7_6>=36 && LA7_6<=39)||LA7_6==41||LA7_6==44||LA7_6==46||LA7_6==50||(LA7_6>=52 && LA7_6<=53)||(LA7_6>=55 && LA7_6<=57)) ) {
                        alt7=5;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 5, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:64:13: '#' IDCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal21=(Token)match(input,37,FOLLOW_37_in_attribute271); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal21_tree = (Object)adaptor.create(char_literal21);
                    adaptor.addChild(root_0, char_literal21_tree);
                    }
                    IDCON22=(Token)match(input,IDCON,FOLLOW_IDCON_in_attribute273); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON22_tree = (Object)adaptor.create(IDCON22);
                    adaptor.addChild(root_0, IDCON22_tree);
                    }

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:65:6: '.' IDCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal23=(Token)match(input,34,FOLLOW_34_in_attribute281); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal23_tree = (Object)adaptor.create(char_literal23);
                    adaptor.addChild(root_0, char_literal23_tree);
                    }
                    IDCON24=(Token)match(input,IDCON,FOLLOW_IDCON_in_attribute283); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON24_tree = (Object)adaptor.create(IDCON24);
                    adaptor.addChild(root_0, IDCON24_tree);
                    }

                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:66:6: '$' IDCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal25=(Token)match(input,38,FOLLOW_38_in_attribute291); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal25_tree = (Object)adaptor.create(char_literal25);
                    adaptor.addChild(root_0, char_literal25_tree);
                    }
                    IDCON26=(Token)match(input,IDCON,FOLLOW_IDCON_in_attribute293); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON26_tree = (Object)adaptor.create(IDCON26);
                    adaptor.addChild(root_0, IDCON26_tree);
                    }

                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:67:6: ':' IDCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal27=(Token)match(input,36,FOLLOW_36_in_attribute301); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal27_tree = (Object)adaptor.create(char_literal27);
                    adaptor.addChild(root_0, char_literal27_tree);
                    }
                    IDCON28=(Token)match(input,IDCON,FOLLOW_IDCON_in_attribute303); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON28_tree = (Object)adaptor.create(IDCON28);
                    adaptor.addChild(root_0, IDCON28_tree);
                    }

                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:68:6: '@' NATCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal29=(Token)match(input,39,FOLLOW_39_in_attribute311); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal29_tree = (Object)adaptor.create(char_literal29);
                    adaptor.addChild(root_0, char_literal29_tree);
                    }
                    NATCON30=(Token)match(input,NATCON,FOLLOW_NATCON_in_attribute313); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON30_tree = (Object)adaptor.create(NATCON30);
                    adaptor.addChild(root_0, NATCON30_tree);
                    }

                    }
                    break;
                case 6 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:69:6: '@' NATCON '%' NATCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal31=(Token)match(input,39,FOLLOW_39_in_attribute321); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal31_tree = (Object)adaptor.create(char_literal31);
                    adaptor.addChild(root_0, char_literal31_tree);
                    }
                    NATCON32=(Token)match(input,NATCON,FOLLOW_NATCON_in_attribute323); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON32_tree = (Object)adaptor.create(NATCON32);
                    adaptor.addChild(root_0, NATCON32_tree);
                    }
                    char_literal33=(Token)match(input,40,FOLLOW_40_in_attribute325); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal33_tree = (Object)adaptor.create(char_literal33);
                    adaptor.addChild(root_0, char_literal33_tree);
                    }
                    NATCON34=(Token)match(input,NATCON,FOLLOW_NATCON_in_attribute327); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON34_tree = (Object)adaptor.create(NATCON34);
                    adaptor.addChild(root_0, NATCON34_tree);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:70:1: arguments : '(' ( argument )? ( ',' argument )* ')' ;
    public final WaebricParser.arguments_return arguments() throws RecognitionException {
        WaebricParser.arguments_return retval = new WaebricParser.arguments_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal35=null;
        Token char_literal37=null;
        Token char_literal39=null;
        WaebricParser.argument_return argument36 = null;

        WaebricParser.argument_return argument38 = null;


        Object char_literal35_tree=null;
        Object char_literal37_tree=null;
        Object char_literal39_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:70:10: ( '(' ( argument )? ( ',' argument )* ')' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:70:13: '(' ( argument )? ( ',' argument )* ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal35=(Token)match(input,41,FOLLOW_41_in_arguments335); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal35_tree = (Object)adaptor.create(char_literal35);
            adaptor.addChild(root_0, char_literal35_tree);
            }
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:70:17: ( argument )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==IDCON||(LA8_0>=NATCON && LA8_0<=SYMBOLCON)||LA8_0==44||LA8_0==46) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: argument
                    {
                    pushFollow(FOLLOW_argument_in_arguments337);
                    argument36=argument();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, argument36.getTree());

                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:70:27: ( ',' argument )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==42) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:70:29: ',' argument
            	    {
            	    char_literal37=(Token)match(input,42,FOLLOW_42_in_arguments342); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal37_tree = (Object)adaptor.create(char_literal37);
            	    adaptor.addChild(root_0, char_literal37_tree);
            	    }
            	    pushFollow(FOLLOW_argument_in_arguments344);
            	    argument38=argument();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, argument38.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            char_literal39=(Token)match(input,43,FOLLOW_43_in_arguments349); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal39_tree = (Object)adaptor.create(char_literal39);
            adaptor.addChild(root_0, char_literal39_tree);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:71:1: argument : expression ;
    public final WaebricParser.argument_return argument() throws RecognitionException {
        WaebricParser.argument_return retval = new WaebricParser.argument_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WaebricParser.expression_return expression40 = null;



        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:71:9: ( expression )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:71:12: expression
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_expression_in_argument357);
            expression40=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression40.getTree());

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:76:1: expression : ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* ;
    public final WaebricParser.expression_return expression() throws RecognitionException {
        WaebricParser.expression_return retval = new WaebricParser.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDCON41=null;
        Token NATCON42=null;
        Token TEXT43=null;
        Token SYMBOLCON44=null;
        Token char_literal45=null;
        Token char_literal47=null;
        Token char_literal49=null;
        Token char_literal50=null;
        Token char_literal52=null;
        Token char_literal54=null;
        Token char_literal55=null;
        Token char_literal57=null;
        Token IDCON58=null;
        WaebricParser.expression_return expression46 = null;

        WaebricParser.expression_return expression48 = null;

        WaebricParser.keyValuePair_return keyValuePair51 = null;

        WaebricParser.keyValuePair_return keyValuePair53 = null;

        WaebricParser.expression_return expression56 = null;


        Object IDCON41_tree=null;
        Object NATCON42_tree=null;
        Object TEXT43_tree=null;
        Object SYMBOLCON44_tree=null;
        Object char_literal45_tree=null;
        Object char_literal47_tree=null;
        Object char_literal49_tree=null;
        Object char_literal50_tree=null;
        Object char_literal52_tree=null;
        Object char_literal54_tree=null;
        Object char_literal55_tree=null;
        Object char_literal57_tree=null;
        Object IDCON58_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:76:11: ( ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:76:14: ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )*
            {
            root_0 = (Object)adaptor.nil();

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:76:14: ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' )
            int alt14=6;
            switch ( input.LA(1) ) {
            case IDCON:
                {
                alt14=1;
                }
                break;
            case NATCON:
                {
                alt14=2;
                }
                break;
            case TEXT:
                {
                alt14=3;
                }
                break;
            case SYMBOLCON:
                {
                alt14=4;
                }
                break;
            case 44:
                {
                alt14=5;
                }
                break;
            case 46:
                {
                alt14=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:76:16: IDCON
                    {
                    IDCON41=(Token)match(input,IDCON,FOLLOW_IDCON_in_expression371); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON41_tree = (Object)adaptor.create(IDCON41);
                    adaptor.addChild(root_0, IDCON41_tree);
                    }

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:76:24: NATCON
                    {
                    NATCON42=(Token)match(input,NATCON,FOLLOW_NATCON_in_expression375); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON42_tree = (Object)adaptor.create(NATCON42);
                    adaptor.addChild(root_0, NATCON42_tree);
                    }

                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:76:33: TEXT
                    {
                    TEXT43=(Token)match(input,TEXT,FOLLOW_TEXT_in_expression379); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TEXT43_tree = (Object)adaptor.create(TEXT43);
                    adaptor.addChild(root_0, TEXT43_tree);
                    }

                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:76:40: SYMBOLCON
                    {
                    SYMBOLCON44=(Token)match(input,SYMBOLCON,FOLLOW_SYMBOLCON_in_expression383); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SYMBOLCON44_tree = (Object)adaptor.create(SYMBOLCON44);
                    adaptor.addChild(root_0, SYMBOLCON44_tree);
                    }

                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:77:7: '[' ( expression )? ( ',' expression )* ']'
                    {
                    char_literal45=(Token)match(input,44,FOLLOW_44_in_expression392); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal45_tree = (Object)adaptor.create(char_literal45);
                    adaptor.addChild(root_0, char_literal45_tree);
                    }
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:77:11: ( expression )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==IDCON||(LA10_0>=NATCON && LA10_0<=SYMBOLCON)||LA10_0==44||LA10_0==46) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: expression
                            {
                            pushFollow(FOLLOW_expression_in_expression394);
                            expression46=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression46.getTree());

                            }
                            break;

                    }

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:77:23: ( ',' expression )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==42) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:77:25: ',' expression
                    	    {
                    	    char_literal47=(Token)match(input,42,FOLLOW_42_in_expression399); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal47_tree = (Object)adaptor.create(char_literal47);
                    	    adaptor.addChild(root_0, char_literal47_tree);
                    	    }
                    	    pushFollow(FOLLOW_expression_in_expression401);
                    	    expression48=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression48.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    char_literal49=(Token)match(input,45,FOLLOW_45_in_expression406); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal49_tree = (Object)adaptor.create(char_literal49);
                    adaptor.addChild(root_0, char_literal49_tree);
                    }

                    }
                    break;
                case 6 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:78:7: '{' ( keyValuePair )? ( ',' keyValuePair )* '}'
                    {
                    char_literal50=(Token)match(input,46,FOLLOW_46_in_expression415); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal50_tree = (Object)adaptor.create(char_literal50);
                    adaptor.addChild(root_0, char_literal50_tree);
                    }
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:78:11: ( keyValuePair )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==IDCON) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: keyValuePair
                            {
                            pushFollow(FOLLOW_keyValuePair_in_expression417);
                            keyValuePair51=keyValuePair();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, keyValuePair51.getTree());

                            }
                            break;

                    }

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:78:25: ( ',' keyValuePair )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==42) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:78:27: ',' keyValuePair
                    	    {
                    	    char_literal52=(Token)match(input,42,FOLLOW_42_in_expression422); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal52_tree = (Object)adaptor.create(char_literal52);
                    	    adaptor.addChild(root_0, char_literal52_tree);
                    	    }
                    	    pushFollow(FOLLOW_keyValuePair_in_expression424);
                    	    keyValuePair53=keyValuePair();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, keyValuePair53.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    char_literal54=(Token)match(input,47,FOLLOW_47_in_expression429); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal54_tree = (Object)adaptor.create(char_literal54);
                    adaptor.addChild(root_0, char_literal54_tree);
                    }

                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:79:6: ( '+' expression | '.' IDCON )*
            loop15:
            do {
                int alt15=3;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==48) ) {
                    int LA15_2 = input.LA(2);

                    if ( (synpred25_Waebric()) ) {
                        alt15=1;
                    }


                }
                else if ( (LA15_0==34) ) {
                    int LA15_3 = input.LA(2);

                    if ( (synpred26_Waebric()) ) {
                        alt15=2;
                    }


                }


                switch (alt15) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:79:8: '+' expression
            	    {
            	    char_literal55=(Token)match(input,48,FOLLOW_48_in_expression439); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal55_tree = (Object)adaptor.create(char_literal55);
            	    adaptor.addChild(root_0, char_literal55_tree);
            	    }
            	    pushFollow(FOLLOW_expression_in_expression441);
            	    expression56=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression56.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:79:35: '.' IDCON
            	    {
            	    char_literal57=(Token)match(input,34,FOLLOW_34_in_expression447); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal57_tree = (Object)adaptor.create(char_literal57);
            	    adaptor.addChild(root_0, char_literal57_tree);
            	    }
            	    IDCON58=(Token)match(input,IDCON,FOLLOW_IDCON_in_expression449); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDCON58_tree = (Object)adaptor.create(IDCON58);
            	    adaptor.addChild(root_0, IDCON58_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop15;
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:80:1: keyValuePair : IDCON ':' expression ;
    public final WaebricParser.keyValuePair_return keyValuePair() throws RecognitionException {
        WaebricParser.keyValuePair_return retval = new WaebricParser.keyValuePair_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDCON59=null;
        Token char_literal60=null;
        WaebricParser.expression_return expression61 = null;


        Object IDCON59_tree=null;
        Object char_literal60_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:80:13: ( IDCON ':' expression )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:80:16: IDCON ':' expression
            {
            root_0 = (Object)adaptor.nil();

            IDCON59=(Token)match(input,IDCON,FOLLOW_IDCON_in_keyValuePair462); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON59_tree = (Object)adaptor.create(IDCON59);
            adaptor.addChild(root_0, IDCON59_tree);
            }
            char_literal60=(Token)match(input,36,FOLLOW_36_in_keyValuePair464); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal60_tree = (Object)adaptor.create(char_literal60);
            adaptor.addChild(root_0, char_literal60_tree);
            }
            pushFollow(FOLLOW_expression_in_keyValuePair466);
            expression61=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression61.getTree());

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:85:1: function : 'def' IDCON ( formals )? ( statement )* 'end' ;
    public final WaebricParser.function_return function() throws RecognitionException {
        WaebricParser.function_return retval = new WaebricParser.function_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal62=null;
        Token IDCON63=null;
        Token string_literal66=null;
        WaebricParser.formals_return formals64 = null;

        WaebricParser.statement_return statement65 = null;


        Object string_literal62_tree=null;
        Object IDCON63_tree=null;
        Object string_literal66_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:85:9: ( 'def' IDCON ( formals )? ( statement )* 'end' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:85:12: 'def' IDCON ( formals )? ( statement )* 'end'
            {
            root_0 = (Object)adaptor.nil();

            string_literal62=(Token)match(input,49,FOLLOW_49_in_function478); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal62_tree = (Object)adaptor.create(string_literal62);
            adaptor.addChild(root_0, string_literal62_tree);
            }
            IDCON63=(Token)match(input,IDCON,FOLLOW_IDCON_in_function480); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON63_tree = (Object)adaptor.create(IDCON63);
            adaptor.addChild(root_0, IDCON63_tree);
            }
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:85:24: ( formals )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==41) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: formals
                    {
                    pushFollow(FOLLOW_formals_in_function482);
                    formals64=formals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, formals64.getTree());

                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:85:33: ( statement )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==IDCON||LA17_0==COMMENT||LA17_0==46||LA17_0==50||(LA17_0>=52 && LA17_0<=53)||(LA17_0>=55 && LA17_0<=57)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_function485);
            	    statement65=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement65.getTree());

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            string_literal66=(Token)match(input,END,FOLLOW_END_in_function488); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal66_tree = (Object)adaptor.create(string_literal66);
            adaptor.addChild(root_0, string_literal66_tree);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:86:1: formals : '(' ( IDCON )? ( ',' IDCON )* ')' -> '(' ( IDCON )* ')' ;
    public final WaebricParser.formals_return formals() throws RecognitionException {
        WaebricParser.formals_return retval = new WaebricParser.formals_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal67=null;
        Token IDCON68=null;
        Token char_literal69=null;
        Token IDCON70=null;
        Token char_literal71=null;

        Object char_literal67_tree=null;
        Object IDCON68_tree=null;
        Object char_literal69_tree=null;
        Object IDCON70_tree=null;
        Object char_literal71_tree=null;
        RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
        RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_IDCON=new RewriteRuleTokenStream(adaptor,"token IDCON");

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:86:8: ( '(' ( IDCON )? ( ',' IDCON )* ')' -> '(' ( IDCON )* ')' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:86:11: '(' ( IDCON )? ( ',' IDCON )* ')'
            {
            char_literal67=(Token)match(input,41,FOLLOW_41_in_formals496); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_41.add(char_literal67);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:86:15: ( IDCON )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==IDCON) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: IDCON
                    {
                    IDCON68=(Token)match(input,IDCON,FOLLOW_IDCON_in_formals498); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDCON.add(IDCON68);


                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:86:22: ( ',' IDCON )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==42) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:86:24: ',' IDCON
            	    {
            	    char_literal69=(Token)match(input,42,FOLLOW_42_in_formals503); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_42.add(char_literal69);

            	    IDCON70=(Token)match(input,IDCON,FOLLOW_IDCON_in_formals505); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_IDCON.add(IDCON70);


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            char_literal71=(Token)match(input,43,FOLLOW_43_in_formals510); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_43.add(char_literal71);



            // AST REWRITE
            // elements: IDCON, 43, 41
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 87:5: -> '(' ( IDCON )* ')'
            {
                adaptor.addChild(root_0, stream_41.nextNode());
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:87:12: ( IDCON )*
                while ( stream_IDCON.hasNext() ) {
                    adaptor.addChild(root_0, stream_IDCON.nextNode());

                }
                stream_IDCON.reset();
                adaptor.addChild(root_0, stream_43.nextNode());

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:93:1: statement : ( 'if' '(' predicate ')' statement ( 'else' statement )? -> ^( 'if' '(' predicate ')' statement ( 'else' statement )? ) | 'each' '(' IDCON ':' expression ')' statement -> ^( 'each' '(' IDCON ':' expression ')' statement ) | 'let' ( assignment )+ 'in' ( statement )* 'end' -> ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | '{' ( statement )* '}' -> ^( '{' ( statement )* '}' ) | 'comment' STRCON ';' -> ^( 'comment' STRCON ';' ) | 'echo' expression ';' -> ^( 'echo' expression ';' ) | 'echo' embedding ';' -> ^( 'echo' embedding ';' ) | 'cdata' expression ';' -> ^( 'cdata' expression ';' ) | 'yield;' | ( markup )+ expression ';' -> ^( markup ( markup )* ',' expression ';' ) | ( markup )+ statement -> ^( markup ( markup )* ',' statement ) | ( markup )+ embedding ';' -> ^( markup ( markup )* ',' embedding ';' ) | ( markup )+ ';' -> ^( markup ( markup )* ';' ) );
    public final WaebricParser.statement_return statement() throws RecognitionException {
        WaebricParser.statement_return retval = new WaebricParser.statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal72=null;
        Token char_literal73=null;
        Token char_literal75=null;
        Token string_literal77=null;
        Token string_literal79=null;
        Token char_literal80=null;
        Token IDCON81=null;
        Token char_literal82=null;
        Token char_literal84=null;
        Token string_literal86=null;
        Token string_literal88=null;
        Token string_literal90=null;
        Token char_literal91=null;
        Token char_literal93=null;
        Token string_literal94=null;
        Token STRCON95=null;
        Token char_literal96=null;
        Token string_literal97=null;
        Token char_literal99=null;
        Token string_literal100=null;
        Token char_literal102=null;
        Token string_literal103=null;
        Token char_literal105=null;
        Token string_literal106=null;
        Token char_literal109=null;
        Token char_literal114=null;
        Token char_literal116=null;
        WaebricParser.predicate_return predicate74 = null;

        WaebricParser.statement_return statement76 = null;

        WaebricParser.statement_return statement78 = null;

        WaebricParser.expression_return expression83 = null;

        WaebricParser.statement_return statement85 = null;

        WaebricParser.assignment_return assignment87 = null;

        WaebricParser.statement_return statement89 = null;

        WaebricParser.statement_return statement92 = null;

        WaebricParser.expression_return expression98 = null;

        WaebricParser.embedding_return embedding101 = null;

        WaebricParser.expression_return expression104 = null;

        WaebricParser.markup_return markup107 = null;

        WaebricParser.expression_return expression108 = null;

        WaebricParser.markup_return markup110 = null;

        WaebricParser.statement_return statement111 = null;

        WaebricParser.markup_return markup112 = null;

        WaebricParser.embedding_return embedding113 = null;

        WaebricParser.markup_return markup115 = null;


        Object string_literal72_tree=null;
        Object char_literal73_tree=null;
        Object char_literal75_tree=null;
        Object string_literal77_tree=null;
        Object string_literal79_tree=null;
        Object char_literal80_tree=null;
        Object IDCON81_tree=null;
        Object char_literal82_tree=null;
        Object char_literal84_tree=null;
        Object string_literal86_tree=null;
        Object string_literal88_tree=null;
        Object string_literal90_tree=null;
        Object char_literal91_tree=null;
        Object char_literal93_tree=null;
        Object string_literal94_tree=null;
        Object STRCON95_tree=null;
        Object char_literal96_tree=null;
        Object string_literal97_tree=null;
        Object char_literal99_tree=null;
        Object string_literal100_tree=null;
        Object char_literal102_tree=null;
        Object string_literal103_tree=null;
        Object char_literal105_tree=null;
        Object string_literal106_tree=null;
        Object char_literal109_tree=null;
        Object char_literal114_tree=null;
        Object char_literal116_tree=null;
        RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
        RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
        RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
        RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
        RewriteRuleTokenStream stream_IDCON=new RewriteRuleTokenStream(adaptor,"token IDCON");
        RewriteRuleTokenStream stream_STRCON=new RewriteRuleTokenStream(adaptor,"token STRCON");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_COMMENT=new RewriteRuleTokenStream(adaptor,"token COMMENT");
        RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
        RewriteRuleTokenStream stream_END=new RewriteRuleTokenStream(adaptor,"token END");
        RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
        RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
        RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_markup=new RewriteRuleSubtreeStream(adaptor,"rule markup");
        RewriteRuleSubtreeStream stream_assignment=new RewriteRuleSubtreeStream(adaptor,"rule assignment");
        RewriteRuleSubtreeStream stream_predicate=new RewriteRuleSubtreeStream(adaptor,"rule predicate");
        RewriteRuleSubtreeStream stream_embedding=new RewriteRuleSubtreeStream(adaptor,"rule embedding");
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:93:10: ( 'if' '(' predicate ')' statement ( 'else' statement )? -> ^( 'if' '(' predicate ')' statement ( 'else' statement )? ) | 'each' '(' IDCON ':' expression ')' statement -> ^( 'each' '(' IDCON ':' expression ')' statement ) | 'let' ( assignment )+ 'in' ( statement )* 'end' -> ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | '{' ( statement )* '}' -> ^( '{' ( statement )* '}' ) | 'comment' STRCON ';' -> ^( 'comment' STRCON ';' ) | 'echo' expression ';' -> ^( 'echo' expression ';' ) | 'echo' embedding ';' -> ^( 'echo' embedding ';' ) | 'cdata' expression ';' -> ^( 'cdata' expression ';' ) | 'yield;' | ( markup )+ expression ';' -> ^( markup ( markup )* ',' expression ';' ) | ( markup )+ statement -> ^( markup ( markup )* ',' statement ) | ( markup )+ embedding ';' -> ^( markup ( markup )* ',' embedding ';' ) | ( markup )+ ';' -> ^( markup ( markup )* ';' ) )
            int alt28=13;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:93:13: 'if' '(' predicate ')' statement ( 'else' statement )?
                    {
                    string_literal72=(Token)match(input,50,FOLLOW_50_in_statement538); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_50.add(string_literal72);

                    char_literal73=(Token)match(input,41,FOLLOW_41_in_statement540); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal73);

                    pushFollow(FOLLOW_predicate_in_statement542);
                    predicate74=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_predicate.add(predicate74.getTree());
                    char_literal75=(Token)match(input,43,FOLLOW_43_in_statement544); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_43.add(char_literal75);

                    pushFollow(FOLLOW_statement_in_statement546);
                    statement76=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement76.getTree());
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:93:46: ( 'else' statement )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==51) ) {
                        int LA20_1 = input.LA(2);

                        if ( (synpred31_Waebric()) ) {
                            alt20=1;
                        }
                    }
                    switch (alt20) {
                        case 1 :
                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:93:48: 'else' statement
                            {
                            string_literal77=(Token)match(input,51,FOLLOW_51_in_statement550); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_51.add(string_literal77);

                            pushFollow(FOLLOW_statement_in_statement552);
                            statement78=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_statement.add(statement78.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: 50, 43, 51, 41, predicate, statement, statement
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 94:5: -> ^( 'if' '(' predicate ')' statement ( 'else' statement )? )
                    {
                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:94:8: ^( 'if' '(' predicate ')' statement ( 'else' statement )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_50.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_41.nextNode());
                        adaptor.addChild(root_1, stream_predicate.nextTree());
                        adaptor.addChild(root_1, stream_43.nextNode());
                        adaptor.addChild(root_1, stream_statement.nextTree());
                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:94:44: ( 'else' statement )?
                        if ( stream_51.hasNext()||stream_statement.hasNext() ) {
                            adaptor.addChild(root_1, stream_51.nextNode());
                            adaptor.addChild(root_1, stream_statement.nextTree());

                        }
                        stream_51.reset();
                        stream_statement.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:95:6: 'each' '(' IDCON ':' expression ')' statement
                    {
                    string_literal79=(Token)match(input,52,FOLLOW_52_in_statement591); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_52.add(string_literal79);

                    char_literal80=(Token)match(input,41,FOLLOW_41_in_statement593); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal80);

                    IDCON81=(Token)match(input,IDCON,FOLLOW_IDCON_in_statement595); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDCON.add(IDCON81);

                    char_literal82=(Token)match(input,36,FOLLOW_36_in_statement597); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_36.add(char_literal82);

                    pushFollow(FOLLOW_expression_in_statement599);
                    expression83=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression83.getTree());
                    char_literal84=(Token)match(input,43,FOLLOW_43_in_statement601); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_43.add(char_literal84);

                    pushFollow(FOLLOW_statement_in_statement603);
                    statement85=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement85.getTree());


                    // AST REWRITE
                    // elements: statement, 36, expression, IDCON, 52, 43, 41
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 96:5: -> ^( 'each' '(' IDCON ':' expression ')' statement )
                    {
                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:96:8: ^( 'each' '(' IDCON ':' expression ')' statement )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_52.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_41.nextNode());
                        adaptor.addChild(root_1, stream_IDCON.nextNode());
                        adaptor.addChild(root_1, stream_36.nextNode());
                        adaptor.addChild(root_1, stream_expression.nextTree());
                        adaptor.addChild(root_1, stream_43.nextNode());
                        adaptor.addChild(root_1, stream_statement.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:97:6: 'let' ( assignment )+ 'in' ( statement )* 'end'
                    {
                    string_literal86=(Token)match(input,53,FOLLOW_53_in_statement635); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_53.add(string_literal86);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:97:12: ( assignment )+
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
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: assignment
                    	    {
                    	    pushFollow(FOLLOW_assignment_in_statement637);
                    	    assignment87=assignment();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_assignment.add(assignment87.getTree());

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

                    string_literal88=(Token)match(input,54,FOLLOW_54_in_statement640); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_54.add(string_literal88);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:97:29: ( statement )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==IDCON||LA22_0==COMMENT||LA22_0==46||LA22_0==50||(LA22_0>=52 && LA22_0<=53)||(LA22_0>=55 && LA22_0<=57)) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_statement642);
                    	    statement89=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_statement.add(statement89.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    string_literal90=(Token)match(input,END,FOLLOW_END_in_statement645); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_END.add(string_literal90);



                    // AST REWRITE
                    // elements: 54, statement, 53, assignment, END
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 98:5: -> ^( 'let' ( assignment )+ 'in' ( statement )* 'end' )
                    {
                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:98:8: ^( 'let' ( assignment )+ 'in' ( statement )* 'end' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_53.nextNode(), root_1);

                        if ( !(stream_assignment.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_assignment.hasNext() ) {
                            adaptor.addChild(root_1, stream_assignment.nextTree());

                        }
                        stream_assignment.reset();
                        adaptor.addChild(root_1, stream_54.nextNode());
                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:98:34: ( statement )*
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:99:6: '{' ( statement )* '}'
                    {
                    char_literal91=(Token)match(input,46,FOLLOW_46_in_statement674); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_46.add(char_literal91);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:99:10: ( statement )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==IDCON||LA23_0==COMMENT||LA23_0==46||LA23_0==50||(LA23_0>=52 && LA23_0<=53)||(LA23_0>=55 && LA23_0<=57)) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_statement676);
                    	    statement92=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_statement.add(statement92.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);

                    char_literal93=(Token)match(input,47,FOLLOW_47_in_statement679); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_47.add(char_literal93);



                    // AST REWRITE
                    // elements: 47, 46, statement
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 100:5: -> ^( '{' ( statement )* '}' )
                    {
                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:100:8: ^( '{' ( statement )* '}' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_46.nextNode(), root_1);

                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:100:15: ( statement )*
                        while ( stream_statement.hasNext() ) {
                            adaptor.addChild(root_1, stream_statement.nextTree());

                        }
                        stream_statement.reset();
                        adaptor.addChild(root_1, stream_47.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:101:6: 'comment' STRCON ';'
                    {
                    string_literal94=(Token)match(input,COMMENT,FOLLOW_COMMENT_in_statement703); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COMMENT.add(string_literal94);

                    STRCON95=(Token)match(input,STRCON,FOLLOW_STRCON_in_statement705); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRCON.add(STRCON95);

                    char_literal96=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement707); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal96);



                    // AST REWRITE
                    // elements: STRCON, COMMENT, SEMICOLON
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 102:5: -> ^( 'comment' STRCON ';' )
                    {
                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:102:8: ^( 'comment' STRCON ';' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_COMMENT.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_STRCON.nextNode());
                        adaptor.addChild(root_1, stream_SEMICOLON.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:103:6: 'echo' expression ';'
                    {
                    string_literal97=(Token)match(input,55,FOLLOW_55_in_statement730); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_55.add(string_literal97);

                    pushFollow(FOLLOW_expression_in_statement732);
                    expression98=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression98.getTree());
                    char_literal99=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement734); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal99);



                    // AST REWRITE
                    // elements: SEMICOLON, 55, expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 104:5: -> ^( 'echo' expression ';' )
                    {
                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:104:8: ^( 'echo' expression ';' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_55.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_expression.nextTree());
                        adaptor.addChild(root_1, stream_SEMICOLON.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 7 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:105:6: 'echo' embedding ';'
                    {
                    string_literal100=(Token)match(input,55,FOLLOW_55_in_statement757); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_55.add(string_literal100);

                    pushFollow(FOLLOW_embedding_in_statement759);
                    embedding101=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_embedding.add(embedding101.getTree());
                    char_literal102=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement761); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal102);



                    // AST REWRITE
                    // elements: embedding, SEMICOLON, 55
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 106:5: -> ^( 'echo' embedding ';' )
                    {
                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:106:8: ^( 'echo' embedding ';' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_55.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_embedding.nextTree());
                        adaptor.addChild(root_1, stream_SEMICOLON.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 8 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:107:6: 'cdata' expression ';'
                    {
                    string_literal103=(Token)match(input,56,FOLLOW_56_in_statement784); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_56.add(string_literal103);

                    pushFollow(FOLLOW_expression_in_statement786);
                    expression104=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression104.getTree());
                    char_literal105=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement788); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal105);



                    // AST REWRITE
                    // elements: SEMICOLON, 56, expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 108:5: -> ^( 'cdata' expression ';' )
                    {
                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:108:8: ^( 'cdata' expression ';' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_56.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_expression.nextTree());
                        adaptor.addChild(root_1, stream_SEMICOLON.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 9 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:109:6: 'yield;'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal106=(Token)match(input,57,FOLLOW_57_in_statement812); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal106_tree = (Object)adaptor.create(string_literal106);
                    adaptor.addChild(root_0, string_literal106_tree);
                    }

                    }
                    break;
                case 10 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:110:6: ( markup )+ expression ';'
                    {
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:110:6: ( markup )+
                    int cnt24=0;
                    loop24:
                    do {
                        int alt24=2;
                        alt24 = dfa24.predict(input);
                        switch (alt24) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_statement819);
                    	    markup107=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_markup.add(markup107.getTree());

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

                    pushFollow(FOLLOW_expression_in_statement822);
                    expression108=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression108.getTree());
                    char_literal109=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement824); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal109);



                    // AST REWRITE
                    // elements: SEMICOLON, markup, expression, 42, markup
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 111:5: -> ^( markup ( markup )* ',' expression ';' )
                    {
                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:111:8: ^( markup ( markup )* ',' expression ';' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_markup.nextNode(), root_1);

                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:111:18: ( markup )*
                        while ( stream_markup.hasNext() ) {
                            adaptor.addChild(root_1, stream_markup.nextTree());

                        }
                        stream_markup.reset();
                        adaptor.addChild(root_1, (Object)adaptor.create(42, "42"));
                        adaptor.addChild(root_1, stream_expression.nextTree());
                        adaptor.addChild(root_1, stream_SEMICOLON.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 11 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:112:6: ( markup )+ statement
                    {
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:112:6: ( markup )+
                    int cnt25=0;
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==IDCON) ) {
                            int LA25_2 = input.LA(2);

                            if ( (synpred46_Waebric()) ) {
                                alt25=1;
                            }


                        }


                        switch (alt25) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_statement853);
                    	    markup110=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_markup.add(markup110.getTree());

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

                    pushFollow(FOLLOW_statement_in_statement856);
                    statement111=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement111.getTree());


                    // AST REWRITE
                    // elements: 42, markup, statement, markup
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 113:5: -> ^( markup ( markup )* ',' statement )
                    {
                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:113:8: ^( markup ( markup )* ',' statement )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_markup.nextNode(), root_1);

                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:113:18: ( markup )*
                        while ( stream_markup.hasNext() ) {
                            adaptor.addChild(root_1, stream_markup.nextTree());

                        }
                        stream_markup.reset();
                        adaptor.addChild(root_1, (Object)adaptor.create(42, "42"));
                        adaptor.addChild(root_1, stream_statement.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 12 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:114:6: ( markup )+ embedding ';'
                    {
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:114:6: ( markup )+
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
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_statement883);
                    	    markup112=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_markup.add(markup112.getTree());

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

                    pushFollow(FOLLOW_embedding_in_statement886);
                    embedding113=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_embedding.add(embedding113.getTree());
                    char_literal114=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement888); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal114);



                    // AST REWRITE
                    // elements: SEMICOLON, markup, 42, markup, embedding
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 115:5: -> ^( markup ( markup )* ',' embedding ';' )
                    {
                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:115:8: ^( markup ( markup )* ',' embedding ';' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_markup.nextNode(), root_1);

                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:115:18: ( markup )*
                        while ( stream_markup.hasNext() ) {
                            adaptor.addChild(root_1, stream_markup.nextTree());

                        }
                        stream_markup.reset();
                        adaptor.addChild(root_1, (Object)adaptor.create(42, "42"));
                        adaptor.addChild(root_1, stream_embedding.nextTree());
                        adaptor.addChild(root_1, stream_SEMICOLON.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 13 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:116:6: ( markup )+ ';'
                    {
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:116:6: ( markup )+
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
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_statement917);
                    	    markup115=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_markup.add(markup115.getTree());

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

                    char_literal116=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement920); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal116);



                    // AST REWRITE
                    // elements: markup, markup, SEMICOLON
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 117:5: -> ^( markup ( markup )* ';' )
                    {
                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:117:8: ^( markup ( markup )* ';' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_markup.nextNode(), root_1);

                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:117:18: ( markup )*
                        while ( stream_markup.hasNext() ) {
                            adaptor.addChild(root_1, stream_markup.nextTree());

                        }
                        stream_markup.reset();
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
    // $ANTLR end "statement"

    public static class assignment_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignment"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:122:1: assignment : ( IDCON '=' expression ';' | IDCON formals statement );
    public final WaebricParser.assignment_return assignment() throws RecognitionException {
        WaebricParser.assignment_return retval = new WaebricParser.assignment_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDCON117=null;
        Token char_literal118=null;
        Token char_literal120=null;
        Token IDCON121=null;
        WaebricParser.expression_return expression119 = null;

        WaebricParser.formals_return formals122 = null;

        WaebricParser.statement_return statement123 = null;


        Object IDCON117_tree=null;
        Object char_literal118_tree=null;
        Object char_literal120_tree=null;
        Object IDCON121_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:122:11: ( IDCON '=' expression ';' | IDCON formals statement )
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:122:14: IDCON '=' expression ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    IDCON117=(Token)match(input,IDCON,FOLLOW_IDCON_in_assignment950); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON117_tree = (Object)adaptor.create(IDCON117);
                    adaptor.addChild(root_0, IDCON117_tree);
                    }
                    char_literal118=(Token)match(input,58,FOLLOW_58_in_assignment952); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal118_tree = (Object)adaptor.create(char_literal118);
                    adaptor.addChild(root_0, char_literal118_tree);
                    }
                    pushFollow(FOLLOW_expression_in_assignment954);
                    expression119=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression119.getTree());
                    char_literal120=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_assignment956); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal120_tree = (Object)adaptor.create(char_literal120);
                    adaptor.addChild(root_0, char_literal120_tree);
                    }

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:123:6: IDCON formals statement
                    {
                    root_0 = (Object)adaptor.nil();

                    IDCON121=(Token)match(input,IDCON,FOLLOW_IDCON_in_assignment964); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON121_tree = (Object)adaptor.create(IDCON121);
                    adaptor.addChild(root_0, IDCON121_tree);
                    }
                    pushFollow(FOLLOW_formals_in_assignment966);
                    formals122=formals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, formals122.getTree());
                    pushFollow(FOLLOW_statement_in_assignment968);
                    statement123=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement123.getTree());

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:128:1: predicate : ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )* ;
    public final WaebricParser.predicate_return predicate() throws RecognitionException {
        WaebricParser.predicate_return retval = new WaebricParser.predicate_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal124=null;
        Token char_literal128=null;
        Token string_literal130=null;
        Token string_literal132=null;
        WaebricParser.predicate_return predicate125 = null;

        WaebricParser.expression_return expression126 = null;

        WaebricParser.expression_return expression127 = null;

        WaebricParser.type_return type129 = null;

        WaebricParser.predicate_return predicate131 = null;

        WaebricParser.predicate_return predicate133 = null;


        Object char_literal124_tree=null;
        Object char_literal128_tree=null;
        Object string_literal130_tree=null;
        Object string_literal132_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:128:10: ( ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:128:13: ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )*
            {
            root_0 = (Object)adaptor.nil();

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:128:13: ( '!' predicate | expression | expression '.' type )
            int alt30=3;
            alt30 = dfa30.predict(input);
            switch (alt30) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:128:15: '!' predicate
                    {
                    char_literal124=(Token)match(input,59,FOLLOW_59_in_predicate983); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal124_tree = (Object)adaptor.create(char_literal124);
                    adaptor.addChild(root_0, char_literal124_tree);
                    }
                    pushFollow(FOLLOW_predicate_in_predicate985);
                    predicate125=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate125.getTree());

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:129:7: expression
                    {
                    pushFollow(FOLLOW_expression_in_predicate994);
                    expression126=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression126.getTree());

                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:130:7: expression '.' type
                    {
                    pushFollow(FOLLOW_expression_in_predicate1003);
                    expression127=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression127.getTree());
                    char_literal128=(Token)match(input,34,FOLLOW_34_in_predicate1005); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal128_tree = (Object)adaptor.create(char_literal128);
                    adaptor.addChild(root_0, char_literal128_tree);
                    }
                    pushFollow(FOLLOW_type_in_predicate1007);
                    type129=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, type129.getTree());

                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:131:6: ( '&&' predicate | '||' predicate )*
            loop31:
            do {
                int alt31=3;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==60) ) {
                    int LA31_2 = input.LA(2);

                    if ( (synpred54_Waebric()) ) {
                        alt31=1;
                    }


                }
                else if ( (LA31_0==61) ) {
                    int LA31_3 = input.LA(2);

                    if ( (synpred55_Waebric()) ) {
                        alt31=2;
                    }


                }


                switch (alt31) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:131:8: '&&' predicate
            	    {
            	    string_literal130=(Token)match(input,60,FOLLOW_60_in_predicate1017); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal130_tree = (Object)adaptor.create(string_literal130);
            	    adaptor.addChild(root_0, string_literal130_tree);
            	    }
            	    pushFollow(FOLLOW_predicate_in_predicate1019);
            	    predicate131=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate131.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:131:25: '||' predicate
            	    {
            	    string_literal132=(Token)match(input,61,FOLLOW_61_in_predicate1023); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal132_tree = (Object)adaptor.create(string_literal132);
            	    adaptor.addChild(root_0, string_literal132_tree);
            	    }
            	    pushFollow(FOLLOW_predicate_in_predicate1025);
            	    predicate133=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate133.getTree());

            	    }
            	    break;

            	default :
            	    break loop31;
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:132:1: type : ( 'list' | 'record' | 'string' );
    public final WaebricParser.type_return type() throws RecognitionException {
        WaebricParser.type_return retval = new WaebricParser.type_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set134=null;

        Object set134_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:132:5: ( 'list' | 'record' | 'string' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:
            {
            root_0 = (Object)adaptor.nil();

            set134=(Token)input.LT(1);
            if ( (input.LA(1)>=62 && input.LA(1)<=64) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set134));
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:137:1: embedding : PRETEXT embed textTail ;
    public final WaebricParser.embedding_return embedding() throws RecognitionException {
        WaebricParser.embedding_return retval = new WaebricParser.embedding_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PRETEXT135=null;
        WaebricParser.embed_return embed136 = null;

        WaebricParser.textTail_return textTail137 = null;


        Object PRETEXT135_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:137:10: ( PRETEXT embed textTail )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:137:13: PRETEXT embed textTail
            {
            root_0 = (Object)adaptor.nil();

            PRETEXT135=(Token)match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding1058); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRETEXT135_tree = (Object)adaptor.create(PRETEXT135);
            adaptor.addChild(root_0, PRETEXT135_tree);
            }
            pushFollow(FOLLOW_embed_in_embedding1060);
            embed136=embed();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, embed136.getTree());
            pushFollow(FOLLOW_textTail_in_embedding1062);
            textTail137=textTail();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, textTail137.getTree());

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:138:1: embed : ( ( markup )* expression | ( markup )* markup );
    public final WaebricParser.embed_return embed() throws RecognitionException {
        WaebricParser.embed_return retval = new WaebricParser.embed_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WaebricParser.markup_return markup138 = null;

        WaebricParser.expression_return expression139 = null;

        WaebricParser.markup_return markup140 = null;

        WaebricParser.markup_return markup141 = null;



        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:138:6: ( ( markup )* expression | ( markup )* markup )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==IDCON) ) {
                int LA34_1 = input.LA(2);

                if ( (synpred59_Waebric()) ) {
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:138:10: ( markup )* expression
                    {
                    root_0 = (Object)adaptor.nil();

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:138:10: ( markup )*
                    loop32:
                    do {
                        int alt32=2;
                        alt32 = dfa32.predict(input);
                        switch (alt32) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_embed1071);
                    	    markup138=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, markup138.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);

                    pushFollow(FOLLOW_expression_in_embed1074);
                    expression139=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression139.getTree());

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:138:31: ( markup )* markup
                    {
                    root_0 = (Object)adaptor.nil();

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:138:31: ( markup )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==IDCON) ) {
                            int LA33_1 = input.LA(2);

                            if ( (synpred60_Waebric()) ) {
                                alt33=1;
                            }


                        }


                        switch (alt33) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_embed1078);
                    	    markup140=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, markup140.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);

                    pushFollow(FOLLOW_markup_in_embed1081);
                    markup141=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, markup141.getTree());

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:139:1: textTail : ( POSTTEXT | MIDTEXT embed textTail );
    public final WaebricParser.textTail_return textTail() throws RecognitionException {
        WaebricParser.textTail_return retval = new WaebricParser.textTail_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token POSTTEXT142=null;
        Token MIDTEXT143=null;
        WaebricParser.embed_return embed144 = null;

        WaebricParser.textTail_return textTail145 = null;


        Object POSTTEXT142_tree=null;
        Object MIDTEXT143_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:139:9: ( POSTTEXT | MIDTEXT embed textTail )
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:139:12: POSTTEXT
                    {
                    root_0 = (Object)adaptor.nil();

                    POSTTEXT142=(Token)match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail1089); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    POSTTEXT142_tree = (Object)adaptor.create(POSTTEXT142);
                    adaptor.addChild(root_0, POSTTEXT142_tree);
                    }

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:139:23: MIDTEXT embed textTail
                    {
                    root_0 = (Object)adaptor.nil();

                    MIDTEXT143=(Token)match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail1093); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MIDTEXT143_tree = (Object)adaptor.create(MIDTEXT143);
                    adaptor.addChild(root_0, MIDTEXT143_tree);
                    }
                    pushFollow(FOLLOW_embed_in_textTail1095);
                    embed144=embed();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, embed144.getTree());
                    pushFollow(FOLLOW_textTail_in_textTail1097);
                    textTail145=textTail();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, textTail145.getTree());

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

    // $ANTLR start synpred25_Waebric
    public final void synpred25_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:79:8: ( '+' expression )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:79:8: '+' expression
        {
        match(input,48,FOLLOW_48_in_synpred25_Waebric439); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred25_Waebric441);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_Waebric

    // $ANTLR start synpred26_Waebric
    public final void synpred26_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:79:35: ( '.' IDCON )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:79:35: '.' IDCON
        {
        match(input,34,FOLLOW_34_in_synpred26_Waebric447); if (state.failed) return ;
        match(input,IDCON,FOLLOW_IDCON_in_synpred26_Waebric449); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_Waebric

    // $ANTLR start synpred31_Waebric
    public final void synpred31_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:93:48: ( 'else' statement )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:93:48: 'else' statement
        {
        match(input,51,FOLLOW_51_in_synpred31_Waebric550); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred31_Waebric552);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_Waebric

    // $ANTLR start synpred45_Waebric
    public final void synpred45_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:110:6: ( ( markup )+ expression ';' )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:110:6: ( markup )+ expression ';'
        {
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:110:6: ( markup )+
        int cnt42=0;
        loop42:
        do {
            int alt42=2;
            alt42 = dfa42.predict(input);
            switch (alt42) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred45_Waebric819);
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

        pushFollow(FOLLOW_expression_in_synpred45_Waebric822);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred45_Waebric824); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred45_Waebric

    // $ANTLR start synpred46_Waebric
    public final void synpred46_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:112:6: ( markup )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:112:6: markup
        {
        pushFollow(FOLLOW_markup_in_synpred46_Waebric853);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_Waebric

    // $ANTLR start synpred47_Waebric
    public final void synpred47_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:112:6: ( ( markup )+ statement )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:112:6: ( markup )+ statement
        {
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:112:6: ( markup )+
        int cnt43=0;
        loop43:
        do {
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==IDCON) ) {
                int LA43_2 = input.LA(2);

                if ( (synpred46_Waebric()) ) {
                    alt43=1;
                }


            }


            switch (alt43) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred47_Waebric853);
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

        pushFollow(FOLLOW_statement_in_synpred47_Waebric856);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred47_Waebric

    // $ANTLR start synpred49_Waebric
    public final void synpred49_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:114:6: ( ( markup )+ embedding ';' )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:114:6: ( markup )+ embedding ';'
        {
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:114:6: ( markup )+
        int cnt44=0;
        loop44:
        do {
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==IDCON) ) {
                alt44=1;
            }


            switch (alt44) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred49_Waebric883);
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

        pushFollow(FOLLOW_embedding_in_synpred49_Waebric886);
        embedding();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred49_Waebric888); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred49_Waebric

    // $ANTLR start synpred53_Waebric
    public final void synpred53_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:129:7: ( expression )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:129:7: expression
        {
        pushFollow(FOLLOW_expression_in_synpred53_Waebric994);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred53_Waebric

    // $ANTLR start synpred54_Waebric
    public final void synpred54_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:131:8: ( '&&' predicate )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:131:8: '&&' predicate
        {
        match(input,60,FOLLOW_60_in_synpred54_Waebric1017); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred54_Waebric1019);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred54_Waebric

    // $ANTLR start synpred55_Waebric
    public final void synpred55_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:131:25: ( '||' predicate )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:131:25: '||' predicate
        {
        match(input,61,FOLLOW_61_in_synpred55_Waebric1023); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred55_Waebric1025);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred55_Waebric

    // $ANTLR start synpred59_Waebric
    public final void synpred59_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:138:10: ( ( markup )* expression )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:138:10: ( markup )* expression
        {
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:138:10: ( markup )*
        loop45:
        do {
            int alt45=2;
            alt45 = dfa45.predict(input);
            switch (alt45) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred59_Waebric1071);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop45;
            }
        } while (true);

        pushFollow(FOLLOW_expression_in_synpred59_Waebric1074);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred59_Waebric

    // $ANTLR start synpred60_Waebric
    public final void synpred60_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:138:31: ( markup )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:138:31: markup
        {
        pushFollow(FOLLOW_markup_in_synpred60_Waebric1078);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred60_Waebric

    // Delegated rules

    public final boolean synpred59_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred59_Waebric_fragment(); // can never throw exception
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
    public final boolean synpred25_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_Waebric_fragment(); // can never throw exception
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
    public final boolean synpred49_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred49_Waebric_fragment(); // can never throw exception
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
    public final boolean synpred55_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred55_Waebric_fragment(); // can never throw exception
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
    public final boolean synpred54_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_Waebric_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
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
    public final boolean synpred60_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred60_Waebric_fragment(); // can never throw exception
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
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA42 dfa42 = new DFA42(this);
    protected DFA45 dfa45 = new DFA45(this);
    static final String DFA28_eotS =
        "\20\uffff";
    static final String DFA28_eofS =
        "\20\uffff";
    static final String DFA28_minS =
        "\1\4\5\uffff\1\4\2\uffff\1\0\6\uffff";
    static final String DFA28_maxS =
        "\1\71\5\uffff\1\56\2\uffff\1\0\6\uffff";
    static final String DFA28_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\11\1\uffff\1\7\1\6\1"+
        "\12\1\13\1\14\1\15";
    static final String DFA28_specialS =
        "\11\uffff\1\0\6\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\11\10\uffff\1\5\40\uffff\1\4\3\uffff\1\1\1\uffff\1\2\1\3"+
            "\1\uffff\1\6\1\7\1\10",
            "",
            "",
            "",
            "",
            "",
            "\1\13\1\uffff\3\13\1\uffff\1\12\41\uffff\1\13\1\uffff\1\13",
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
            return "93:1: statement : ( 'if' '(' predicate ')' statement ( 'else' statement )? -> ^( 'if' '(' predicate ')' statement ( 'else' statement )? ) | 'each' '(' IDCON ':' expression ')' statement -> ^( 'each' '(' IDCON ':' expression ')' statement ) | 'let' ( assignment )+ 'in' ( statement )* 'end' -> ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | '{' ( statement )* '}' -> ^( '{' ( statement )* '}' ) | 'comment' STRCON ';' -> ^( 'comment' STRCON ';' ) | 'echo' expression ';' -> ^( 'echo' expression ';' ) | 'echo' embedding ';' -> ^( 'echo' embedding ';' ) | 'cdata' expression ';' -> ^( 'cdata' expression ';' ) | 'yield;' | ( markup )+ expression ';' -> ^( markup ( markup )* ',' expression ';' ) | ( markup )+ statement -> ^( markup ( markup )* ',' statement ) | ( markup )+ embedding ';' -> ^( markup ( markup )* ',' embedding ';' ) | ( markup )+ ';' -> ^( markup ( markup )* ';' ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA28_9 = input.LA(1);

                         
                        int index28_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_Waebric()) ) {s = 12;}

                        else if ( (synpred47_Waebric()) ) {s = 13;}

                        else if ( (synpred49_Waebric()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
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
    static final String DFA24_eotS =
        "\6\uffff";
    static final String DFA24_eofS =
        "\6\uffff";
    static final String DFA24_minS =
        "\2\4\2\uffff\2\4";
    static final String DFA24_maxS =
        "\1\56\1\60\2\uffff\1\4\1\60";
    static final String DFA24_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA24_specialS =
        "\6\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\1\1\uffff\3\2\43\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\7\uffff\1\2\21\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\7\uffff\1\2\21\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\2"
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
            return "()+ loopback of 110:6: ( markup )+";
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
            return "128:13: ( '!' predicate | expression | expression '.' type )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA30_2 = input.LA(1);

                         
                        int index30_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred53_Waebric()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index30_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA30_3 = input.LA(1);

                         
                        int index30_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred53_Waebric()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index30_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA30_4 = input.LA(1);

                         
                        int index30_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred53_Waebric()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index30_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA30_5 = input.LA(1);

                         
                        int index30_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred53_Waebric()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index30_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA30_6 = input.LA(1);

                         
                        int index30_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred53_Waebric()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index30_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA30_7 = input.LA(1);

                         
                        int index30_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred53_Waebric()) ) {s = 8;}

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
            return "()* loopback of 138:10: ( markup )*";
        }
    }
    static final String DFA42_eotS =
        "\6\uffff";
    static final String DFA42_eofS =
        "\6\uffff";
    static final String DFA42_minS =
        "\2\4\1\uffff\1\4\1\uffff\1\4";
    static final String DFA42_maxS =
        "\1\56\1\60\1\uffff\1\4\1\uffff\1\60";
    static final String DFA42_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String DFA42_specialS =
        "\6\uffff}>";
    static final String[] DFA42_transitionS = {
            "\1\1\1\uffff\3\2\43\uffff\1\2\1\uffff\1\2",
            "\1\4\1\uffff\3\4\7\uffff\1\2\21\uffff\1\3\1\uffff\4\4\1\uffff"+
            "\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\2",
            "",
            "\1\5",
            "",
            "\1\4\1\uffff\3\4\7\uffff\1\2\21\uffff\1\3\1\uffff\4\4\1\uffff"+
            "\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\2"
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
            return "()+ loopback of 110:6: ( markup )+";
        }
    }
    static final String DFA45_eotS =
        "\6\uffff";
    static final String DFA45_eofS =
        "\1\uffff\1\2\3\uffff\1\2";
    static final String DFA45_minS =
        "\2\4\1\uffff\1\4\1\uffff\1\4";
    static final String DFA45_maxS =
        "\1\56\1\60\1\uffff\1\4\1\uffff\1\60";
    static final String DFA45_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String DFA45_specialS =
        "\6\uffff}>";
    static final String[] DFA45_transitionS = {
            "\1\1\1\uffff\3\2\43\uffff\1\2\1\uffff\1\2",
            "\1\4\1\uffff\3\4\31\uffff\1\3\1\uffff\4\4\1\uffff\1\4\2\uffff"+
            "\1\4\1\uffff\1\4\1\uffff\1\2",
            "",
            "\1\5",
            "",
            "\1\4\1\uffff\3\4\31\uffff\1\3\1\uffff\4\4\1\uffff\1\4\2\uffff"+
            "\1\4\1\uffff\1\4\1\uffff\1\2"
    };

    static final short[] DFA45_eot = DFA.unpackEncodedString(DFA45_eotS);
    static final short[] DFA45_eof = DFA.unpackEncodedString(DFA45_eofS);
    static final char[] DFA45_min = DFA.unpackEncodedStringToUnsignedChars(DFA45_minS);
    static final char[] DFA45_max = DFA.unpackEncodedStringToUnsignedChars(DFA45_maxS);
    static final short[] DFA45_accept = DFA.unpackEncodedString(DFA45_acceptS);
    static final short[] DFA45_special = DFA.unpackEncodedString(DFA45_specialS);
    static final short[][] DFA45_transition;

    static {
        int numStates = DFA45_transitionS.length;
        DFA45_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA45_transition[i] = DFA.unpackEncodedString(DFA45_transitionS[i]);
        }
    }

    class DFA45 extends DFA {

        public DFA45(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 45;
            this.eot = DFA45_eot;
            this.eof = DFA45_eof;
            this.min = DFA45_min;
            this.max = DFA45_max;
            this.accept = DFA45_accept;
            this.special = DFA45_special;
            this.transition = DFA45_transition;
        }
        public String getDescription() {
            return "()* loopback of 138:10: ( markup )*";
        }
    }
 

    public static final BitSet FOLLOW_33_in_module72 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_moduleId_in_module74 = new BitSet(new long[]{0x0002000800004002L});
    public static final BitSet FOLLOW_imprt_in_module78 = new BitSet(new long[]{0x0002000800004002L});
    public static final BitSet FOLLOW_site_in_module82 = new BitSet(new long[]{0x0002000800004002L});
    public static final BitSet FOLLOW_function_in_module86 = new BitSet(new long[]{0x0002000800004002L});
    public static final BitSet FOLLOW_IDCON_in_moduleId140 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_moduleId150 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_moduleId154 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_35_in_imprt170 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_moduleId_in_imprt174 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_imprt176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SITE_in_site208 = new BitSet(new long[]{0x0000000000018020L});
    public static final BitSet FOLLOW_mappings_in_site210 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_END_in_site212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapping_in_mappings220 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_SEMICOLON_in_mappings225 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_mapping_in_mappings227 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_PATH_in_mapping239 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_mapping241 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_mapping243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_markup256 = new BitSet(new long[]{0x000002F400000002L});
    public static final BitSet FOLLOW_attribute_in_markup259 = new BitSet(new long[]{0x000002F400000002L});
    public static final BitSet FOLLOW_arguments_in_markup262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_attribute271 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_attribute281 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_attribute291 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_attribute301 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_attribute311 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NATCON_in_attribute313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_attribute321 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NATCON_in_attribute323 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_attribute325 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NATCON_in_attribute327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_arguments335 = new BitSet(new long[]{0x00005C00000001D0L});
    public static final BitSet FOLLOW_argument_in_arguments337 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_42_in_arguments342 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_argument_in_arguments344 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_43_in_arguments349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_argument357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_expression371 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_NATCON_in_expression375 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_TEXT_in_expression379 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_SYMBOLCON_in_expression383 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_44_in_expression392 = new BitSet(new long[]{0x00007400000001D0L});
    public static final BitSet FOLLOW_expression_in_expression394 = new BitSet(new long[]{0x0000240000000000L});
    public static final BitSet FOLLOW_42_in_expression399 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_expression401 = new BitSet(new long[]{0x0000240000000000L});
    public static final BitSet FOLLOW_45_in_expression406 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_46_in_expression415 = new BitSet(new long[]{0x0000840000000010L});
    public static final BitSet FOLLOW_keyValuePair_in_expression417 = new BitSet(new long[]{0x0000840000000000L});
    public static final BitSet FOLLOW_42_in_expression422 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_keyValuePair_in_expression424 = new BitSet(new long[]{0x0000840000000000L});
    public static final BitSet FOLLOW_47_in_expression429 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_48_in_expression439 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_expression441 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_34_in_expression447 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_expression449 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_IDCON_in_keyValuePair462 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_keyValuePair464 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_keyValuePair466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_function478 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_function480 = new BitSet(new long[]{0x03B442000000A010L});
    public static final BitSet FOLLOW_formals_in_function482 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_statement_in_function485 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_END_in_function488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_formals496 = new BitSet(new long[]{0x00000C0000000010L});
    public static final BitSet FOLLOW_IDCON_in_formals498 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_42_in_formals503 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_formals505 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_43_in_formals510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_statement538 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_statement540 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_statement542 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_statement544 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement546 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_51_in_statement550 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_statement591 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_statement593 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_statement595 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_statement597 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_statement599 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_statement601 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_statement635 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_assignment_in_statement637 = new BitSet(new long[]{0x0040000000000010L});
    public static final BitSet FOLLOW_54_in_statement640 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_statement_in_statement642 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_END_in_statement645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_statement674 = new BitSet(new long[]{0x03B4C00000002010L});
    public static final BitSet FOLLOW_statement_in_statement676 = new BitSet(new long[]{0x03B4C00000002010L});
    public static final BitSet FOLLOW_47_in_statement679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMENT_in_statement703 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_STRCON_in_statement705 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_statement730 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_statement732 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_statement757 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_embedding_in_statement759 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_statement784 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_statement786 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_statement812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement819 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_statement822 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement853 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement883 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_embedding_in_statement886 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement917 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_assignment950 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_assignment952 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_assignment954 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_assignment956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_assignment964 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_formals_in_assignment966 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_assignment968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_predicate983 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_predicate985 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate994 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate1003 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_predicate1005 = new BitSet(new long[]{0xC000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_type_in_predicate1007 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_60_in_predicate1017 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_predicate1019 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_61_in_predicate1023 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_predicate1025 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding1058 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_embed_in_embedding1060 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_textTail_in_embedding1062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed1071 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_embed1074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed1078 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_embed1081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail1089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail1093 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_embed_in_textTail1095 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_textTail_in_textTail1097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_synpred25_Waebric439 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_synpred25_Waebric441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_synpred26_Waebric447 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_synpred26_Waebric449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_synpred31_Waebric550 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_synpred31_Waebric552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred45_Waebric819 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_synpred45_Waebric822 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred45_Waebric824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred46_Waebric853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred47_Waebric853 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_synpred47_Waebric856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred49_Waebric883 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_embedding_in_synpred49_Waebric886 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred49_Waebric888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred53_Waebric994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_synpred54_Waebric1017 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_synpred54_Waebric1019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred55_Waebric1023 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_synpred55_Waebric1025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred59_Waebric1071 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_synpred59_Waebric1074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred60_Waebric1078 = new BitSet(new long[]{0x0000000000000002L});

}