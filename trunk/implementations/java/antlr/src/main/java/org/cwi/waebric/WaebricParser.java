// $ANTLR 3.1.2 /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g 2009-08-13 10:10:33

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDCON", "PATH", "NATCON", "TEXT", "SYMBOLCON", "STRCON", "PRETEXT", "POSTTEXT", "MIDTEXT", "COMMENT", "SITE", "END", "SEMICOLON", "TEXTCHAR", "STRCHAR", "LETTER", "DIGIT", "HEXADECIMAL", "PATHELEMENT", "FILEEXT", "SYMBOLCHAR", "ESCLAYOUT", "DECIMAL", "ESCQUOTE", "AMP", "CHARREF", "ENTREF", "COMMENTS", "LAYOUT", "'module'", "'.'", "'import'", "':'", "'#'", "'$'", "'@'", "'%'", "'('", "','", "')'", "'['", "']'", "'{'", "'}'", "'+'", "'def'", "'if'", "'else'", "'each'", "'let'", "'in'", "'echo'", "'cdata'", "'yield'", "'='", "'!'", "'&&'", "'||'", "'list'", "'record'", "'string'"
    };
    public static final int T__64=64;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int AMP=28;
    public static final int LETTER=19;
    public static final int ESCLAYOUT=25;
    public static final int PATHELEMENT=22;
    public static final int TEXTCHAR=17;
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
    public static final int SITE=14;
    public static final int SYMBOLCON=8;
    public static final int HEXADECIMAL=21;
    public static final int SEMICOLON=16;
    public static final int SYMBOLCHAR=24;
    public static final int TEXT=7;
    public static final int LAYOUT=32;
    public static final int NATCON=6;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int DECIMAL=26;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int ENTREF=30;
    public static final int ESCQUOTE=27;
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
            // elements: function, site, 33, moduleId, imprt
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
            // elements: moduleId, 35, SEMICOLON
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 52:5: -> 'import' moduleId ';' ^()
            {
                adaptor.addChild(root_0, stream_35.nextNode());
                adaptor.addChild(root_0, stream_moduleId.nextTree());
                adaptor.addChild(root_0, stream_SEMICOLON.nextNode());
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:52:30: ^()
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:57:1: site : 'site' mappings 'end' ;
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:57:5: ( 'site' mappings 'end' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:57:9: 'site' mappings 'end'
            {
            root_0 = (Object)adaptor.nil();

            string_literal9=(Token)match(input,SITE,FOLLOW_SITE_in_site212); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal9_tree = (Object)adaptor.create(string_literal9);
            adaptor.addChild(root_0, string_literal9_tree);
            }
            pushFollow(FOLLOW_mappings_in_site214);
            mappings10=mappings();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mappings10.getTree());
            string_literal11=(Token)match(input,END,FOLLOW_END_in_site216); if (state.failed) return retval;
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:58:1: mappings : ( mapping )? ( ';' mapping )* ;
    public final WaebricParser.mappings_return mappings() throws RecognitionException {
        WaebricParser.mappings_return retval = new WaebricParser.mappings_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal13=null;
        WaebricParser.mapping_return mapping12 = null;

        WaebricParser.mapping_return mapping14 = null;


        Object char_literal13_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:58:9: ( ( mapping )? ( ';' mapping )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:58:12: ( mapping )? ( ';' mapping )*
            {
            root_0 = (Object)adaptor.nil();

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:58:12: ( mapping )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==PATH) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: mapping
                    {
                    pushFollow(FOLLOW_mapping_in_mappings224);
                    mapping12=mapping();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, mapping12.getTree());

                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:58:21: ( ';' mapping )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==SEMICOLON) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:58:23: ';' mapping
            	    {
            	    char_literal13=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_mappings229); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal13_tree = (Object)adaptor.create(char_literal13);
            	    adaptor.addChild(root_0, char_literal13_tree);
            	    }
            	    pushFollow(FOLLOW_mapping_in_mappings231);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:59:1: mapping : PATH ':' markup ;
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:59:9: ( PATH ':' markup )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:59:12: PATH ':' markup
            {
            root_0 = (Object)adaptor.nil();

            PATH15=(Token)match(input,PATH,FOLLOW_PATH_in_mapping243); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PATH15_tree = (Object)adaptor.create(PATH15);
            adaptor.addChild(root_0, PATH15_tree);
            }
            char_literal16=(Token)match(input,36,FOLLOW_36_in_mapping245); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal16_tree = (Object)adaptor.create(char_literal16);
            adaptor.addChild(root_0, char_literal16_tree);
            }
            pushFollow(FOLLOW_markup_in_mapping247);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:64:1: markup : designator ( arguments )? ;
    public final WaebricParser.markup_return markup() throws RecognitionException {
        WaebricParser.markup_return retval = new WaebricParser.markup_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WaebricParser.designator_return designator18 = null;

        WaebricParser.arguments_return arguments19 = null;



        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:64:7: ( designator ( arguments )? )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:64:11: designator ( arguments )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_designator_in_markup260);
            designator18=designator();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, designator18.getTree());
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:64:22: ( arguments )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==41) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: arguments
                    {
                    pushFollow(FOLLOW_arguments_in_markup262);
                    arguments19=arguments();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arguments19.getTree());

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

    public static class designator_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "designator"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:65:1: designator : IDCON ( attribute )* ;
    public final WaebricParser.designator_return designator() throws RecognitionException {
        WaebricParser.designator_return retval = new WaebricParser.designator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDCON20=null;
        WaebricParser.attribute_return attribute21 = null;


        Object IDCON20_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:65:11: ( IDCON ( attribute )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:65:14: IDCON ( attribute )*
            {
            root_0 = (Object)adaptor.nil();

            IDCON20=(Token)match(input,IDCON,FOLLOW_IDCON_in_designator271); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON20_tree = (Object)adaptor.create(IDCON20);
            adaptor.addChild(root_0, IDCON20_tree);
            }
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:65:20: ( attribute )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==34||(LA6_0>=36 && LA6_0<=39)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: attribute
            	    {
            	    pushFollow(FOLLOW_attribute_in_designator273);
            	    attribute21=attribute();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, attribute21.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
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
    // $ANTLR end "designator"

    public static class attribute_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attribute"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:66:1: attribute : ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON );
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:66:10: ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON )
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:66:13: '#' IDCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal22=(Token)match(input,37,FOLLOW_37_in_attribute282); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal22_tree = (Object)adaptor.create(char_literal22);
                    adaptor.addChild(root_0, char_literal22_tree);
                    }
                    IDCON23=(Token)match(input,IDCON,FOLLOW_IDCON_in_attribute284); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON23_tree = (Object)adaptor.create(IDCON23);
                    adaptor.addChild(root_0, IDCON23_tree);
                    }

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:67:6: '.' IDCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal24=(Token)match(input,34,FOLLOW_34_in_attribute292); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal24_tree = (Object)adaptor.create(char_literal24);
                    adaptor.addChild(root_0, char_literal24_tree);
                    }
                    IDCON25=(Token)match(input,IDCON,FOLLOW_IDCON_in_attribute294); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON25_tree = (Object)adaptor.create(IDCON25);
                    adaptor.addChild(root_0, IDCON25_tree);
                    }

                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:68:6: '$' IDCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal26=(Token)match(input,38,FOLLOW_38_in_attribute302); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal26_tree = (Object)adaptor.create(char_literal26);
                    adaptor.addChild(root_0, char_literal26_tree);
                    }
                    IDCON27=(Token)match(input,IDCON,FOLLOW_IDCON_in_attribute304); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON27_tree = (Object)adaptor.create(IDCON27);
                    adaptor.addChild(root_0, IDCON27_tree);
                    }

                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:69:6: ':' IDCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal28=(Token)match(input,36,FOLLOW_36_in_attribute312); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal28_tree = (Object)adaptor.create(char_literal28);
                    adaptor.addChild(root_0, char_literal28_tree);
                    }
                    IDCON29=(Token)match(input,IDCON,FOLLOW_IDCON_in_attribute314); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON29_tree = (Object)adaptor.create(IDCON29);
                    adaptor.addChild(root_0, IDCON29_tree);
                    }

                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:70:6: '@' NATCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal30=(Token)match(input,39,FOLLOW_39_in_attribute322); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal30_tree = (Object)adaptor.create(char_literal30);
                    adaptor.addChild(root_0, char_literal30_tree);
                    }
                    NATCON31=(Token)match(input,NATCON,FOLLOW_NATCON_in_attribute324); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON31_tree = (Object)adaptor.create(NATCON31);
                    adaptor.addChild(root_0, NATCON31_tree);
                    }

                    }
                    break;
                case 6 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:71:6: '@' NATCON '%' NATCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal32=(Token)match(input,39,FOLLOW_39_in_attribute332); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal32_tree = (Object)adaptor.create(char_literal32);
                    adaptor.addChild(root_0, char_literal32_tree);
                    }
                    NATCON33=(Token)match(input,NATCON,FOLLOW_NATCON_in_attribute334); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON33_tree = (Object)adaptor.create(NATCON33);
                    adaptor.addChild(root_0, NATCON33_tree);
                    }
                    char_literal34=(Token)match(input,40,FOLLOW_40_in_attribute336); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal34_tree = (Object)adaptor.create(char_literal34);
                    adaptor.addChild(root_0, char_literal34_tree);
                    }
                    NATCON35=(Token)match(input,NATCON,FOLLOW_NATCON_in_attribute338); if (state.failed) return retval;
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:72:1: arguments : '(' ( argument )? ( ',' argument )* ')' ;
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

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:72:10: ( '(' ( argument )? ( ',' argument )* ')' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:72:13: '(' ( argument )? ( ',' argument )* ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal36=(Token)match(input,41,FOLLOW_41_in_arguments346); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal36_tree = (Object)adaptor.create(char_literal36);
            adaptor.addChild(root_0, char_literal36_tree);
            }
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:72:17: ( argument )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==IDCON||(LA8_0>=NATCON && LA8_0<=SYMBOLCON)||LA8_0==44||LA8_0==46) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: argument
                    {
                    pushFollow(FOLLOW_argument_in_arguments348);
                    argument37=argument();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, argument37.getTree());

                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:72:27: ( ',' argument )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==42) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:72:29: ',' argument
            	    {
            	    char_literal38=(Token)match(input,42,FOLLOW_42_in_arguments353); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal38_tree = (Object)adaptor.create(char_literal38);
            	    adaptor.addChild(root_0, char_literal38_tree);
            	    }
            	    pushFollow(FOLLOW_argument_in_arguments355);
            	    argument39=argument();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, argument39.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            char_literal40=(Token)match(input,43,FOLLOW_43_in_arguments360); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal40_tree = (Object)adaptor.create(char_literal40);
            adaptor.addChild(root_0, char_literal40_tree);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:73:1: argument : expression ;
    public final WaebricParser.argument_return argument() throws RecognitionException {
        WaebricParser.argument_return retval = new WaebricParser.argument_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WaebricParser.expression_return expression41 = null;



        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:73:9: ( expression )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:73:12: expression
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_expression_in_argument368);
            expression41=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression41.getTree());

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:78:1: expression : ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* ;
    public final WaebricParser.expression_return expression() throws RecognitionException {
        WaebricParser.expression_return retval = new WaebricParser.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDCON42=null;
        Token NATCON43=null;
        Token TEXT44=null;
        Token SYMBOLCON45=null;
        Token char_literal46=null;
        Token char_literal48=null;
        Token char_literal50=null;
        Token char_literal51=null;
        Token char_literal53=null;
        Token char_literal55=null;
        Token char_literal56=null;
        Token char_literal58=null;
        Token IDCON59=null;
        WaebricParser.expression_return expression47 = null;

        WaebricParser.expression_return expression49 = null;

        WaebricParser.keyValuePair_return keyValuePair52 = null;

        WaebricParser.keyValuePair_return keyValuePair54 = null;

        WaebricParser.expression_return expression57 = null;


        Object IDCON42_tree=null;
        Object NATCON43_tree=null;
        Object TEXT44_tree=null;
        Object SYMBOLCON45_tree=null;
        Object char_literal46_tree=null;
        Object char_literal48_tree=null;
        Object char_literal50_tree=null;
        Object char_literal51_tree=null;
        Object char_literal53_tree=null;
        Object char_literal55_tree=null;
        Object char_literal56_tree=null;
        Object char_literal58_tree=null;
        Object IDCON59_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:78:11: ( ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:78:14: ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )*
            {
            root_0 = (Object)adaptor.nil();

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:78:14: ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' )
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:78:16: IDCON
                    {
                    IDCON42=(Token)match(input,IDCON,FOLLOW_IDCON_in_expression382); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON42_tree = (Object)adaptor.create(IDCON42);
                    adaptor.addChild(root_0, IDCON42_tree);
                    }

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:78:24: NATCON
                    {
                    NATCON43=(Token)match(input,NATCON,FOLLOW_NATCON_in_expression386); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON43_tree = (Object)adaptor.create(NATCON43);
                    adaptor.addChild(root_0, NATCON43_tree);
                    }

                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:78:33: TEXT
                    {
                    TEXT44=(Token)match(input,TEXT,FOLLOW_TEXT_in_expression390); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TEXT44_tree = (Object)adaptor.create(TEXT44);
                    adaptor.addChild(root_0, TEXT44_tree);
                    }

                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:78:40: SYMBOLCON
                    {
                    SYMBOLCON45=(Token)match(input,SYMBOLCON,FOLLOW_SYMBOLCON_in_expression394); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SYMBOLCON45_tree = (Object)adaptor.create(SYMBOLCON45);
                    adaptor.addChild(root_0, SYMBOLCON45_tree);
                    }

                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:79:7: '[' ( expression )? ( ',' expression )* ']'
                    {
                    char_literal46=(Token)match(input,44,FOLLOW_44_in_expression403); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal46_tree = (Object)adaptor.create(char_literal46);
                    adaptor.addChild(root_0, char_literal46_tree);
                    }
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:79:11: ( expression )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==IDCON||(LA10_0>=NATCON && LA10_0<=SYMBOLCON)||LA10_0==44||LA10_0==46) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: expression
                            {
                            pushFollow(FOLLOW_expression_in_expression405);
                            expression47=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression47.getTree());

                            }
                            break;

                    }

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:79:23: ( ',' expression )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==42) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:79:25: ',' expression
                    	    {
                    	    char_literal48=(Token)match(input,42,FOLLOW_42_in_expression410); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal48_tree = (Object)adaptor.create(char_literal48);
                    	    adaptor.addChild(root_0, char_literal48_tree);
                    	    }
                    	    pushFollow(FOLLOW_expression_in_expression412);
                    	    expression49=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression49.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    char_literal50=(Token)match(input,45,FOLLOW_45_in_expression417); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal50_tree = (Object)adaptor.create(char_literal50);
                    adaptor.addChild(root_0, char_literal50_tree);
                    }

                    }
                    break;
                case 6 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:80:7: '{' ( keyValuePair )? ( ',' keyValuePair )* '}'
                    {
                    char_literal51=(Token)match(input,46,FOLLOW_46_in_expression426); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal51_tree = (Object)adaptor.create(char_literal51);
                    adaptor.addChild(root_0, char_literal51_tree);
                    }
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:80:11: ( keyValuePair )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==IDCON) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: keyValuePair
                            {
                            pushFollow(FOLLOW_keyValuePair_in_expression428);
                            keyValuePair52=keyValuePair();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, keyValuePair52.getTree());

                            }
                            break;

                    }

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:80:25: ( ',' keyValuePair )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==42) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:80:27: ',' keyValuePair
                    	    {
                    	    char_literal53=(Token)match(input,42,FOLLOW_42_in_expression433); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal53_tree = (Object)adaptor.create(char_literal53);
                    	    adaptor.addChild(root_0, char_literal53_tree);
                    	    }
                    	    pushFollow(FOLLOW_keyValuePair_in_expression435);
                    	    keyValuePair54=keyValuePair();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, keyValuePair54.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    char_literal55=(Token)match(input,47,FOLLOW_47_in_expression440); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal55_tree = (Object)adaptor.create(char_literal55);
                    adaptor.addChild(root_0, char_literal55_tree);
                    }

                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:81:6: ( '+' expression | '.' IDCON )*
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
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:81:8: '+' expression
            	    {
            	    char_literal56=(Token)match(input,48,FOLLOW_48_in_expression450); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal56_tree = (Object)adaptor.create(char_literal56);
            	    adaptor.addChild(root_0, char_literal56_tree);
            	    }
            	    pushFollow(FOLLOW_expression_in_expression452);
            	    expression57=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression57.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:81:35: '.' IDCON
            	    {
            	    char_literal58=(Token)match(input,34,FOLLOW_34_in_expression458); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal58_tree = (Object)adaptor.create(char_literal58);
            	    adaptor.addChild(root_0, char_literal58_tree);
            	    }
            	    IDCON59=(Token)match(input,IDCON,FOLLOW_IDCON_in_expression460); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDCON59_tree = (Object)adaptor.create(IDCON59);
            	    adaptor.addChild(root_0, IDCON59_tree);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:82:1: keyValuePair : IDCON ':' expression ;
    public final WaebricParser.keyValuePair_return keyValuePair() throws RecognitionException {
        WaebricParser.keyValuePair_return retval = new WaebricParser.keyValuePair_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDCON60=null;
        Token char_literal61=null;
        WaebricParser.expression_return expression62 = null;


        Object IDCON60_tree=null;
        Object char_literal61_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:82:13: ( IDCON ':' expression )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:82:16: IDCON ':' expression
            {
            root_0 = (Object)adaptor.nil();

            IDCON60=(Token)match(input,IDCON,FOLLOW_IDCON_in_keyValuePair473); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON60_tree = (Object)adaptor.create(IDCON60);
            adaptor.addChild(root_0, IDCON60_tree);
            }
            char_literal61=(Token)match(input,36,FOLLOW_36_in_keyValuePair475); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal61_tree = (Object)adaptor.create(char_literal61);
            adaptor.addChild(root_0, char_literal61_tree);
            }
            pushFollow(FOLLOW_expression_in_keyValuePair477);
            expression62=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression62.getTree());

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:87:1: function : 'def' IDCON ( formals )? ( statement )* 'end' ;
    public final WaebricParser.function_return function() throws RecognitionException {
        WaebricParser.function_return retval = new WaebricParser.function_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal63=null;
        Token IDCON64=null;
        Token string_literal67=null;
        WaebricParser.formals_return formals65 = null;

        WaebricParser.statement_return statement66 = null;


        Object string_literal63_tree=null;
        Object IDCON64_tree=null;
        Object string_literal67_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:87:9: ( 'def' IDCON ( formals )? ( statement )* 'end' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:87:12: 'def' IDCON ( formals )? ( statement )* 'end'
            {
            root_0 = (Object)adaptor.nil();

            string_literal63=(Token)match(input,49,FOLLOW_49_in_function489); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal63_tree = (Object)adaptor.create(string_literal63);
            adaptor.addChild(root_0, string_literal63_tree);
            }
            IDCON64=(Token)match(input,IDCON,FOLLOW_IDCON_in_function491); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON64_tree = (Object)adaptor.create(IDCON64);
            adaptor.addChild(root_0, IDCON64_tree);
            }
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:87:24: ( formals )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==41) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: formals
                    {
                    pushFollow(FOLLOW_formals_in_function493);
                    formals65=formals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, formals65.getTree());

                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:87:33: ( statement )*
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
            	    pushFollow(FOLLOW_statement_in_function496);
            	    statement66=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement66.getTree());

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            string_literal67=(Token)match(input,END,FOLLOW_END_in_function499); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal67_tree = (Object)adaptor.create(string_literal67);
            adaptor.addChild(root_0, string_literal67_tree);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:90:1: formals : '(' ( IDCON )? ( ',' IDCON )* ')' -> '(' ( IDCON )* ')' ;
    public final WaebricParser.formals_return formals() throws RecognitionException {
        WaebricParser.formals_return retval = new WaebricParser.formals_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal68=null;
        Token IDCON69=null;
        Token char_literal70=null;
        Token IDCON71=null;
        Token char_literal72=null;

        Object char_literal68_tree=null;
        Object IDCON69_tree=null;
        Object char_literal70_tree=null;
        Object IDCON71_tree=null;
        Object char_literal72_tree=null;
        RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
        RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_IDCON=new RewriteRuleTokenStream(adaptor,"token IDCON");

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:90:8: ( '(' ( IDCON )? ( ',' IDCON )* ')' -> '(' ( IDCON )* ')' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:90:11: '(' ( IDCON )? ( ',' IDCON )* ')'
            {
            char_literal68=(Token)match(input,41,FOLLOW_41_in_formals509); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_41.add(char_literal68);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:90:15: ( IDCON )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==IDCON) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: IDCON
                    {
                    IDCON69=(Token)match(input,IDCON,FOLLOW_IDCON_in_formals511); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDCON.add(IDCON69);


                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:90:22: ( ',' IDCON )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==42) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:90:24: ',' IDCON
            	    {
            	    char_literal70=(Token)match(input,42,FOLLOW_42_in_formals516); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_42.add(char_literal70);

            	    IDCON71=(Token)match(input,IDCON,FOLLOW_IDCON_in_formals518); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_IDCON.add(IDCON71);


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            char_literal72=(Token)match(input,43,FOLLOW_43_in_formals523); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_43.add(char_literal72);



            // AST REWRITE
            // elements: 41, 43, IDCON
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 92:5: -> '(' ( IDCON )* ')'
            {
                adaptor.addChild(root_0, stream_41.nextNode());
                // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:92:12: ( IDCON )*
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:98:1: statement : ( 'if' '(' predicate ')' statement 'else' statement -> ^( 'if' predicate statement 'else' statement ) | 'if' '(' predicate ')' statement -> ^( 'if' predicate statement ) | 'each' '(' IDCON ':' expression ')' statement -> ^( 'each' IDCON expression statement ) | 'let' ( assignment )+ 'in' ( statement )* 'end' -> ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | '{' ( statement )* '}' -> ^( '{' ( statement )* '}' ) | 'comment' STRCON ';' -> ^( 'comment' STRCON ) | 'echo' expression ';' -> ^( 'echo' expression ) | 'echo' embedding ';' -> ^( 'echo' embedding ) | 'cdata' expression ';' -> ^( 'cdata' expression ) | 'yield' ';' -> 'yield' | markup ';' -> markup | ( markup )+ expression ';' -> ^( markup ( markup )* ',' expression ';' ) | ( markup )+ statement -> ^( markup ( markup )* ',' statement ) | ( markup )+ embedding ';' -> ^( markup ( markup )* embedding ';' ) | ( markup )+ markup ';' -> ^( markup ( markup )* ';' ) );
    public final WaebricParser.statement_return statement() throws RecognitionException {
        WaebricParser.statement_return retval = new WaebricParser.statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal73=null;
        Token char_literal74=null;
        Token char_literal76=null;
        Token string_literal78=null;
        Token string_literal80=null;
        Token char_literal81=null;
        Token char_literal83=null;
        Token string_literal85=null;
        Token char_literal86=null;
        Token IDCON87=null;
        Token char_literal88=null;
        Token char_literal90=null;
        Token string_literal92=null;
        Token string_literal94=null;
        Token string_literal96=null;
        Token char_literal97=null;
        Token char_literal99=null;
        Token string_literal100=null;
        Token STRCON101=null;
        Token char_literal102=null;
        Token string_literal103=null;
        Token char_literal105=null;
        Token string_literal106=null;
        Token char_literal108=null;
        Token string_literal109=null;
        Token char_literal111=null;
        Token string_literal112=null;
        Token char_literal113=null;
        Token char_literal115=null;
        Token char_literal118=null;
        Token char_literal123=null;
        Token char_literal126=null;
        WaebricParser.predicate_return predicate75 = null;

        WaebricParser.statement_return statement77 = null;

        WaebricParser.statement_return statement79 = null;

        WaebricParser.predicate_return predicate82 = null;

        WaebricParser.statement_return statement84 = null;

        WaebricParser.expression_return expression89 = null;

        WaebricParser.statement_return statement91 = null;

        WaebricParser.assignment_return assignment93 = null;

        WaebricParser.statement_return statement95 = null;

        WaebricParser.statement_return statement98 = null;

        WaebricParser.expression_return expression104 = null;

        WaebricParser.embedding_return embedding107 = null;

        WaebricParser.expression_return expression110 = null;

        WaebricParser.markup_return markup114 = null;

        WaebricParser.markup_return markup116 = null;

        WaebricParser.expression_return expression117 = null;

        WaebricParser.markup_return markup119 = null;

        WaebricParser.statement_return statement120 = null;

        WaebricParser.markup_return markup121 = null;

        WaebricParser.embedding_return embedding122 = null;

        WaebricParser.markup_return markup124 = null;

        WaebricParser.markup_return markup125 = null;


        Object string_literal73_tree=null;
        Object char_literal74_tree=null;
        Object char_literal76_tree=null;
        Object string_literal78_tree=null;
        Object string_literal80_tree=null;
        Object char_literal81_tree=null;
        Object char_literal83_tree=null;
        Object string_literal85_tree=null;
        Object char_literal86_tree=null;
        Object IDCON87_tree=null;
        Object char_literal88_tree=null;
        Object char_literal90_tree=null;
        Object string_literal92_tree=null;
        Object string_literal94_tree=null;
        Object string_literal96_tree=null;
        Object char_literal97_tree=null;
        Object char_literal99_tree=null;
        Object string_literal100_tree=null;
        Object STRCON101_tree=null;
        Object char_literal102_tree=null;
        Object string_literal103_tree=null;
        Object char_literal105_tree=null;
        Object string_literal106_tree=null;
        Object char_literal108_tree=null;
        Object string_literal109_tree=null;
        Object char_literal111_tree=null;
        Object string_literal112_tree=null;
        Object char_literal113_tree=null;
        Object char_literal115_tree=null;
        Object char_literal118_tree=null;
        Object char_literal123_tree=null;
        Object char_literal126_tree=null;
        RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:98:10: ( 'if' '(' predicate ')' statement 'else' statement -> ^( 'if' predicate statement 'else' statement ) | 'if' '(' predicate ')' statement -> ^( 'if' predicate statement ) | 'each' '(' IDCON ':' expression ')' statement -> ^( 'each' IDCON expression statement ) | 'let' ( assignment )+ 'in' ( statement )* 'end' -> ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | '{' ( statement )* '}' -> ^( '{' ( statement )* '}' ) | 'comment' STRCON ';' -> ^( 'comment' STRCON ) | 'echo' expression ';' -> ^( 'echo' expression ) | 'echo' embedding ';' -> ^( 'echo' embedding ) | 'cdata' expression ';' -> ^( 'cdata' expression ) | 'yield' ';' -> 'yield' | markup ';' -> markup | ( markup )+ expression ';' -> ^( markup ( markup )* ',' expression ';' ) | ( markup )+ statement -> ^( markup ( markup )* ',' statement ) | ( markup )+ embedding ';' -> ^( markup ( markup )* embedding ';' ) | ( markup )+ markup ';' -> ^( markup ( markup )* ';' ) )
            int alt27=15;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:98:13: 'if' '(' predicate ')' statement 'else' statement
                    {
                    string_literal73=(Token)match(input,50,FOLLOW_50_in_statement555); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_50.add(string_literal73);

                    char_literal74=(Token)match(input,41,FOLLOW_41_in_statement557); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal74);

                    pushFollow(FOLLOW_predicate_in_statement559);
                    predicate75=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_predicate.add(predicate75.getTree());
                    char_literal76=(Token)match(input,43,FOLLOW_43_in_statement561); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_43.add(char_literal76);

                    pushFollow(FOLLOW_statement_in_statement563);
                    statement77=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement77.getTree());
                    string_literal78=(Token)match(input,51,FOLLOW_51_in_statement565); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_51.add(string_literal78);

                    pushFollow(FOLLOW_statement_in_statement567);
                    statement79=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement79.getTree());


                    // AST REWRITE
                    // elements: statement, 51, predicate, 50, statement
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 100:5: -> ^( 'if' predicate statement 'else' statement )
                    {
                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:100:8: ^( 'if' predicate statement 'else' statement )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_50.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_predicate.nextTree());
                        adaptor.addChild(root_1, stream_statement.nextTree());
                        adaptor.addChild(root_1, stream_51.nextNode());
                        adaptor.addChild(root_1, stream_statement.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:102:6: 'if' '(' predicate ')' statement
                    {
                    string_literal80=(Token)match(input,50,FOLLOW_50_in_statement604); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_50.add(string_literal80);

                    char_literal81=(Token)match(input,41,FOLLOW_41_in_statement606); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal81);

                    pushFollow(FOLLOW_predicate_in_statement608);
                    predicate82=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_predicate.add(predicate82.getTree());
                    char_literal83=(Token)match(input,43,FOLLOW_43_in_statement610); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_43.add(char_literal83);

                    pushFollow(FOLLOW_statement_in_statement612);
                    statement84=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement84.getTree());


                    // AST REWRITE
                    // elements: statement, predicate, 50
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 103:5: -> ^( 'if' predicate statement )
                    {
                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:103:8: ^( 'if' predicate statement )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_50.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_predicate.nextTree());
                        adaptor.addChild(root_1, stream_statement.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:105:6: 'each' '(' IDCON ':' expression ')' statement
                    {
                    string_literal85=(Token)match(input,52,FOLLOW_52_in_statement640); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_52.add(string_literal85);

                    char_literal86=(Token)match(input,41,FOLLOW_41_in_statement642); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal86);

                    IDCON87=(Token)match(input,IDCON,FOLLOW_IDCON_in_statement644); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDCON.add(IDCON87);

                    char_literal88=(Token)match(input,36,FOLLOW_36_in_statement646); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_36.add(char_literal88);

                    pushFollow(FOLLOW_expression_in_statement648);
                    expression89=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression89.getTree());
                    char_literal90=(Token)match(input,43,FOLLOW_43_in_statement650); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_43.add(char_literal90);

                    pushFollow(FOLLOW_statement_in_statement652);
                    statement91=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement91.getTree());


                    // AST REWRITE
                    // elements: 52, statement, IDCON, expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 106:5: -> ^( 'each' IDCON expression statement )
                    {
                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:106:8: ^( 'each' IDCON expression statement )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_52.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_IDCON.nextNode());
                        adaptor.addChild(root_1, stream_expression.nextTree());
                        adaptor.addChild(root_1, stream_statement.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:107:6: 'let' ( assignment )+ 'in' ( statement )* 'end'
                    {
                    string_literal92=(Token)match(input,53,FOLLOW_53_in_statement677); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_53.add(string_literal92);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:107:12: ( assignment )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==IDCON) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: assignment
                    	    {
                    	    pushFollow(FOLLOW_assignment_in_statement679);
                    	    assignment93=assignment();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_assignment.add(assignment93.getTree());

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

                    string_literal94=(Token)match(input,54,FOLLOW_54_in_statement682); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_54.add(string_literal94);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:107:29: ( statement )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==IDCON||LA21_0==COMMENT||LA21_0==46||LA21_0==50||(LA21_0>=52 && LA21_0<=53)||(LA21_0>=55 && LA21_0<=57)) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_statement684);
                    	    statement95=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_statement.add(statement95.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);

                    string_literal96=(Token)match(input,END,FOLLOW_END_in_statement687); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_END.add(string_literal96);



                    // AST REWRITE
                    // elements: 53, 54, END, assignment, statement
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 108:5: -> ^( 'let' ( assignment )+ 'in' ( statement )* 'end' )
                    {
                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:108:8: ^( 'let' ( assignment )+ 'in' ( statement )* 'end' )
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
                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:108:34: ( statement )*
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
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:109:6: '{' ( statement )* '}'
                    {
                    char_literal97=(Token)match(input,46,FOLLOW_46_in_statement716); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_46.add(char_literal97);

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:109:10: ( statement )*
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
                    	    pushFollow(FOLLOW_statement_in_statement718);
                    	    statement98=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_statement.add(statement98.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    char_literal99=(Token)match(input,47,FOLLOW_47_in_statement721); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_47.add(char_literal99);



                    // AST REWRITE
                    // elements: 47, statement, 46
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 110:5: -> ^( '{' ( statement )* '}' )
                    {
                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:110:8: ^( '{' ( statement )* '}' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_46.nextNode(), root_1);

                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:110:15: ( statement )*
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
                case 6 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:111:6: 'comment' STRCON ';'
                    {
                    string_literal100=(Token)match(input,COMMENT,FOLLOW_COMMENT_in_statement745); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COMMENT.add(string_literal100);

                    STRCON101=(Token)match(input,STRCON,FOLLOW_STRCON_in_statement747); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRCON.add(STRCON101);

                    char_literal102=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement749); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal102);



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
                    // 112:5: -> ^( 'comment' STRCON )
                    {
                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:112:8: ^( 'comment' STRCON )
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
                case 7 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:113:6: 'echo' expression ';'
                    {
                    string_literal103=(Token)match(input,55,FOLLOW_55_in_statement770); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_55.add(string_literal103);

                    pushFollow(FOLLOW_expression_in_statement772);
                    expression104=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression104.getTree());
                    char_literal105=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement774); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal105);



                    // AST REWRITE
                    // elements: expression, 55
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 114:5: -> ^( 'echo' expression )
                    {
                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:114:8: ^( 'echo' expression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_55.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_expression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 8 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:115:6: 'echo' embedding ';'
                    {
                    string_literal106=(Token)match(input,55,FOLLOW_55_in_statement795); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_55.add(string_literal106);

                    pushFollow(FOLLOW_embedding_in_statement797);
                    embedding107=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_embedding.add(embedding107.getTree());
                    char_literal108=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement799); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal108);



                    // AST REWRITE
                    // elements: embedding, 55
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 116:5: -> ^( 'echo' embedding )
                    {
                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:116:8: ^( 'echo' embedding )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_55.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_embedding.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 9 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:117:6: 'cdata' expression ';'
                    {
                    string_literal109=(Token)match(input,56,FOLLOW_56_in_statement820); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_56.add(string_literal109);

                    pushFollow(FOLLOW_expression_in_statement822);
                    expression110=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression110.getTree());
                    char_literal111=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement824); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal111);



                    // AST REWRITE
                    // elements: 56, expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 118:5: -> ^( 'cdata' expression )
                    {
                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:118:8: ^( 'cdata' expression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_56.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_expression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 10 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:119:6: 'yield' ';'
                    {
                    string_literal112=(Token)match(input,57,FOLLOW_57_in_statement845); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_57.add(string_literal112);

                    char_literal113=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement847); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal113);



                    // AST REWRITE
                    // elements: 57
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 119:18: -> 'yield'
                    {
                        adaptor.addChild(root_0, stream_57.nextNode());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 11 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:120:6: markup ';'
                    {
                    pushFollow(FOLLOW_markup_in_statement858);
                    markup114=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_markup.add(markup114.getTree());
                    char_literal115=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement860); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal115);



                    // AST REWRITE
                    // elements: markup
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 120:17: -> markup
                    {
                        adaptor.addChild(root_0, stream_markup.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 12 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:121:6: ( markup )+ expression ';'
                    {
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:121:6: ( markup )+
                    int cnt23=0;
                    loop23:
                    do {
                        int alt23=2;
                        alt23 = dfa23.predict(input);
                        switch (alt23) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_statement871);
                    	    markup116=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_markup.add(markup116.getTree());

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

                    pushFollow(FOLLOW_expression_in_statement874);
                    expression117=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression117.getTree());
                    char_literal118=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement876); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal118);



                    // AST REWRITE
                    // elements: SEMICOLON, expression, markup, markup, 42
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 123:5: -> ^( markup ( markup )* ',' expression ';' )
                    {
                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:123:8: ^( markup ( markup )* ',' expression ';' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_markup.nextNode(), root_1);

                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:123:18: ( markup )*
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
                case 13 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:124:6: ( markup )+ statement
                    {
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:124:6: ( markup )+
                    int cnt24=0;
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==IDCON) ) {
                            int LA24_2 = input.LA(2);

                            if ( (synpred47_Waebric()) ) {
                                alt24=1;
                            }


                        }


                        switch (alt24) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_statement909);
                    	    markup119=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_markup.add(markup119.getTree());

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

                    pushFollow(FOLLOW_statement_in_statement912);
                    statement120=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement120.getTree());


                    // AST REWRITE
                    // elements: markup, statement, 42, markup
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 126:5: -> ^( markup ( markup )* ',' statement )
                    {
                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:126:8: ^( markup ( markup )* ',' statement )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_markup.nextNode(), root_1);

                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:126:18: ( markup )*
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
                case 14 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:127:6: ( markup )+ embedding ';'
                    {
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:127:6: ( markup )+
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
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_statement944);
                    	    markup121=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_markup.add(markup121.getTree());

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

                    pushFollow(FOLLOW_embedding_in_statement947);
                    embedding122=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_embedding.add(embedding122.getTree());
                    char_literal123=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement949); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal123);



                    // AST REWRITE
                    // elements: embedding, markup, SEMICOLON, markup
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 129:5: -> ^( markup ( markup )* embedding ';' )
                    {
                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:129:8: ^( markup ( markup )* embedding ';' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_markup.nextNode(), root_1);

                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:129:18: ( markup )*
                        while ( stream_markup.hasNext() ) {
                            adaptor.addChild(root_1, stream_markup.nextTree());

                        }
                        stream_markup.reset();
                        adaptor.addChild(root_1, stream_embedding.nextTree());
                        adaptor.addChild(root_1, stream_SEMICOLON.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 15 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:130:6: ( markup )+ markup ';'
                    {
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:130:6: ( markup )+
                    int cnt26=0;
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==IDCON) ) {
                            int LA26_1 = input.LA(2);

                            if ( (synpred51_Waebric()) ) {
                                alt26=1;
                            }


                        }


                        switch (alt26) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_statement980);
                    	    markup124=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_markup.add(markup124.getTree());

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

                    pushFollow(FOLLOW_markup_in_statement983);
                    markup125=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_markup.add(markup125.getTree());
                    char_literal126=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement985); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal126);



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
                    // 132:5: -> ^( markup ( markup )* ';' )
                    {
                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:132:8: ^( markup ( markup )* ';' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_markup.nextNode(), root_1);

                        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:132:18: ( markup )*
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:137:1: assignment : ( IDCON '=' expression ';' | IDCON formals statement );
    public final WaebricParser.assignment_return assignment() throws RecognitionException {
        WaebricParser.assignment_return retval = new WaebricParser.assignment_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDCON127=null;
        Token char_literal128=null;
        Token char_literal130=null;
        Token IDCON131=null;
        WaebricParser.expression_return expression129 = null;

        WaebricParser.formals_return formals132 = null;

        WaebricParser.statement_return statement133 = null;


        Object IDCON127_tree=null;
        Object char_literal128_tree=null;
        Object char_literal130_tree=null;
        Object IDCON131_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:137:11: ( IDCON '=' expression ';' | IDCON formals statement )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==IDCON) ) {
                int LA28_1 = input.LA(2);

                if ( (LA28_1==58) ) {
                    alt28=1;
                }
                else if ( (LA28_1==41) ) {
                    alt28=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:137:14: IDCON '=' expression ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    IDCON127=(Token)match(input,IDCON,FOLLOW_IDCON_in_assignment1019); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON127_tree = (Object)adaptor.create(IDCON127);
                    adaptor.addChild(root_0, IDCON127_tree);
                    }
                    char_literal128=(Token)match(input,58,FOLLOW_58_in_assignment1021); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal128_tree = (Object)adaptor.create(char_literal128);
                    adaptor.addChild(root_0, char_literal128_tree);
                    }
                    pushFollow(FOLLOW_expression_in_assignment1023);
                    expression129=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression129.getTree());
                    char_literal130=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_assignment1025); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal130_tree = (Object)adaptor.create(char_literal130);
                    adaptor.addChild(root_0, char_literal130_tree);
                    }

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:138:6: IDCON formals statement
                    {
                    root_0 = (Object)adaptor.nil();

                    IDCON131=(Token)match(input,IDCON,FOLLOW_IDCON_in_assignment1033); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON131_tree = (Object)adaptor.create(IDCON131);
                    adaptor.addChild(root_0, IDCON131_tree);
                    }
                    pushFollow(FOLLOW_formals_in_assignment1035);
                    formals132=formals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, formals132.getTree());
                    pushFollow(FOLLOW_statement_in_assignment1037);
                    statement133=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement133.getTree());

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:143:1: predicate : ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )* ;
    public final WaebricParser.predicate_return predicate() throws RecognitionException {
        WaebricParser.predicate_return retval = new WaebricParser.predicate_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal134=null;
        Token char_literal138=null;
        Token string_literal140=null;
        Token string_literal142=null;
        WaebricParser.predicate_return predicate135 = null;

        WaebricParser.expression_return expression136 = null;

        WaebricParser.expression_return expression137 = null;

        WaebricParser.type_return type139 = null;

        WaebricParser.predicate_return predicate141 = null;

        WaebricParser.predicate_return predicate143 = null;


        Object char_literal134_tree=null;
        Object char_literal138_tree=null;
        Object string_literal140_tree=null;
        Object string_literal142_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:143:10: ( ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:143:13: ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )*
            {
            root_0 = (Object)adaptor.nil();

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:143:13: ( '!' predicate | expression | expression '.' type )
            int alt29=3;
            alt29 = dfa29.predict(input);
            switch (alt29) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:143:15: '!' predicate
                    {
                    char_literal134=(Token)match(input,59,FOLLOW_59_in_predicate1052); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal134_tree = (Object)adaptor.create(char_literal134);
                    adaptor.addChild(root_0, char_literal134_tree);
                    }
                    pushFollow(FOLLOW_predicate_in_predicate1054);
                    predicate135=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate135.getTree());

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:144:7: expression
                    {
                    pushFollow(FOLLOW_expression_in_predicate1063);
                    expression136=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression136.getTree());

                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:145:7: expression '.' type
                    {
                    pushFollow(FOLLOW_expression_in_predicate1072);
                    expression137=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression137.getTree());
                    char_literal138=(Token)match(input,34,FOLLOW_34_in_predicate1074); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal138_tree = (Object)adaptor.create(char_literal138);
                    adaptor.addChild(root_0, char_literal138_tree);
                    }
                    pushFollow(FOLLOW_type_in_predicate1076);
                    type139=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, type139.getTree());

                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:146:6: ( '&&' predicate | '||' predicate )*
            loop30:
            do {
                int alt30=3;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==60) ) {
                    int LA30_2 = input.LA(2);

                    if ( (synpred55_Waebric()) ) {
                        alt30=1;
                    }


                }
                else if ( (LA30_0==61) ) {
                    int LA30_3 = input.LA(2);

                    if ( (synpred56_Waebric()) ) {
                        alt30=2;
                    }


                }


                switch (alt30) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:146:8: '&&' predicate
            	    {
            	    string_literal140=(Token)match(input,60,FOLLOW_60_in_predicate1086); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal140_tree = (Object)adaptor.create(string_literal140);
            	    adaptor.addChild(root_0, string_literal140_tree);
            	    }
            	    pushFollow(FOLLOW_predicate_in_predicate1088);
            	    predicate141=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate141.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:146:25: '||' predicate
            	    {
            	    string_literal142=(Token)match(input,61,FOLLOW_61_in_predicate1092); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal142_tree = (Object)adaptor.create(string_literal142);
            	    adaptor.addChild(root_0, string_literal142_tree);
            	    }
            	    pushFollow(FOLLOW_predicate_in_predicate1094);
            	    predicate143=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate143.getTree());

            	    }
            	    break;

            	default :
            	    break loop30;
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:147:1: type : ( 'list' | 'record' | 'string' );
    public final WaebricParser.type_return type() throws RecognitionException {
        WaebricParser.type_return retval = new WaebricParser.type_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set144=null;

        Object set144_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:147:5: ( 'list' | 'record' | 'string' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:
            {
            root_0 = (Object)adaptor.nil();

            set144=(Token)input.LT(1);
            if ( (input.LA(1)>=62 && input.LA(1)<=64) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set144));
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:152:1: embedding : PRETEXT embed textTail ;
    public final WaebricParser.embedding_return embedding() throws RecognitionException {
        WaebricParser.embedding_return retval = new WaebricParser.embedding_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PRETEXT145=null;
        WaebricParser.embed_return embed146 = null;

        WaebricParser.textTail_return textTail147 = null;


        Object PRETEXT145_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:152:10: ( PRETEXT embed textTail )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:152:13: PRETEXT embed textTail
            {
            root_0 = (Object)adaptor.nil();

            PRETEXT145=(Token)match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding1127); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRETEXT145_tree = (Object)adaptor.create(PRETEXT145);
            adaptor.addChild(root_0, PRETEXT145_tree);
            }
            pushFollow(FOLLOW_embed_in_embedding1129);
            embed146=embed();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, embed146.getTree());
            pushFollow(FOLLOW_textTail_in_embedding1131);
            textTail147=textTail();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, textTail147.getTree());

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:153:1: embed : ( ( markup )* expression | ( markup )* markup );
    public final WaebricParser.embed_return embed() throws RecognitionException {
        WaebricParser.embed_return retval = new WaebricParser.embed_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WaebricParser.markup_return markup148 = null;

        WaebricParser.expression_return expression149 = null;

        WaebricParser.markup_return markup150 = null;

        WaebricParser.markup_return markup151 = null;



        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:153:6: ( ( markup )* expression | ( markup )* markup )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==IDCON) ) {
                int LA33_1 = input.LA(2);

                if ( (synpred60_Waebric()) ) {
                    alt33=1;
                }
                else if ( (true) ) {
                    alt33=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA33_0>=NATCON && LA33_0<=SYMBOLCON)||LA33_0==44||LA33_0==46) ) {
                alt33=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:153:10: ( markup )* expression
                    {
                    root_0 = (Object)adaptor.nil();

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:153:10: ( markup )*
                    loop31:
                    do {
                        int alt31=2;
                        alt31 = dfa31.predict(input);
                        switch (alt31) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_embed1140);
                    	    markup148=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, markup148.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);

                    pushFollow(FOLLOW_expression_in_embed1143);
                    expression149=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression149.getTree());

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:153:31: ( markup )* markup
                    {
                    root_0 = (Object)adaptor.nil();

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:153:31: ( markup )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==IDCON) ) {
                            int LA32_1 = input.LA(2);

                            if ( (synpred61_Waebric()) ) {
                                alt32=1;
                            }


                        }


                        switch (alt32) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_embed1147);
                    	    markup150=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, markup150.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);

                    pushFollow(FOLLOW_markup_in_embed1150);
                    markup151=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, markup151.getTree());

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:154:1: textTail : ( POSTTEXT | MIDTEXT embed textTail );
    public final WaebricParser.textTail_return textTail() throws RecognitionException {
        WaebricParser.textTail_return retval = new WaebricParser.textTail_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token POSTTEXT152=null;
        Token MIDTEXT153=null;
        WaebricParser.embed_return embed154 = null;

        WaebricParser.textTail_return textTail155 = null;


        Object POSTTEXT152_tree=null;
        Object MIDTEXT153_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:154:9: ( POSTTEXT | MIDTEXT embed textTail )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==POSTTEXT) ) {
                alt34=1;
            }
            else if ( (LA34_0==MIDTEXT) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:154:12: POSTTEXT
                    {
                    root_0 = (Object)adaptor.nil();

                    POSTTEXT152=(Token)match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail1158); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    POSTTEXT152_tree = (Object)adaptor.create(POSTTEXT152);
                    adaptor.addChild(root_0, POSTTEXT152_tree);
                    }

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:154:23: MIDTEXT embed textTail
                    {
                    root_0 = (Object)adaptor.nil();

                    MIDTEXT153=(Token)match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail1162); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MIDTEXT153_tree = (Object)adaptor.create(MIDTEXT153);
                    adaptor.addChild(root_0, MIDTEXT153_tree);
                    }
                    pushFollow(FOLLOW_embed_in_textTail1164);
                    embed154=embed();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, embed154.getTree());
                    pushFollow(FOLLOW_textTail_in_textTail1166);
                    textTail155=textTail();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, textTail155.getTree());

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
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:81:8: ( '+' expression )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:81:8: '+' expression
        {
        match(input,48,FOLLOW_48_in_synpred25_Waebric450); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred25_Waebric452);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_Waebric

    // $ANTLR start synpred26_Waebric
    public final void synpred26_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:81:35: ( '.' IDCON )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:81:35: '.' IDCON
        {
        match(input,34,FOLLOW_34_in_synpred26_Waebric458); if (state.failed) return ;
        match(input,IDCON,FOLLOW_IDCON_in_synpred26_Waebric460); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_Waebric

    // $ANTLR start synpred31_Waebric
    public final void synpred31_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:98:13: ( 'if' '(' predicate ')' statement 'else' statement )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:98:13: 'if' '(' predicate ')' statement 'else' statement
        {
        match(input,50,FOLLOW_50_in_synpred31_Waebric555); if (state.failed) return ;
        match(input,41,FOLLOW_41_in_synpred31_Waebric557); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred31_Waebric559);
        predicate();

        state._fsp--;
        if (state.failed) return ;
        match(input,43,FOLLOW_43_in_synpred31_Waebric561); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred31_Waebric563);
        statement();

        state._fsp--;
        if (state.failed) return ;
        match(input,51,FOLLOW_51_in_synpred31_Waebric565); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred31_Waebric567);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_Waebric

    // $ANTLR start synpred32_Waebric
    public final void synpred32_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:102:6: ( 'if' '(' predicate ')' statement )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:102:6: 'if' '(' predicate ')' statement
        {
        match(input,50,FOLLOW_50_in_synpred32_Waebric604); if (state.failed) return ;
        match(input,41,FOLLOW_41_in_synpred32_Waebric606); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred32_Waebric608);
        predicate();

        state._fsp--;
        if (state.failed) return ;
        match(input,43,FOLLOW_43_in_synpred32_Waebric610); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred32_Waebric612);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_Waebric

    // $ANTLR start synpred40_Waebric
    public final void synpred40_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:113:6: ( 'echo' expression ';' )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:113:6: 'echo' expression ';'
        {
        match(input,55,FOLLOW_55_in_synpred40_Waebric770); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred40_Waebric772);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred40_Waebric774); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred40_Waebric

    // $ANTLR start synpred41_Waebric
    public final void synpred41_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:115:6: ( 'echo' embedding ';' )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:115:6: 'echo' embedding ';'
        {
        match(input,55,FOLLOW_55_in_synpred41_Waebric795); if (state.failed) return ;
        pushFollow(FOLLOW_embedding_in_synpred41_Waebric797);
        embedding();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred41_Waebric799); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred41_Waebric

    // $ANTLR start synpred44_Waebric
    public final void synpred44_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:120:6: ( markup ';' )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:120:6: markup ';'
        {
        pushFollow(FOLLOW_markup_in_synpred44_Waebric858);
        markup();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred44_Waebric860); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred44_Waebric

    // $ANTLR start synpred46_Waebric
    public final void synpred46_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:121:6: ( ( markup )+ expression ';' )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:121:6: ( markup )+ expression ';'
        {
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:121:6: ( markup )+
        int cnt40=0;
        loop40:
        do {
            int alt40=2;
            alt40 = dfa40.predict(input);
            switch (alt40) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred46_Waebric871);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt40 >= 1 ) break loop40;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(40, input);
                    throw eee;
            }
            cnt40++;
        } while (true);

        pushFollow(FOLLOW_expression_in_synpred46_Waebric874);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred46_Waebric876); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_Waebric

    // $ANTLR start synpred47_Waebric
    public final void synpred47_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:124:6: ( markup )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:124:6: markup
        {
        pushFollow(FOLLOW_markup_in_synpred47_Waebric909);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred47_Waebric

    // $ANTLR start synpred48_Waebric
    public final void synpred48_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:124:6: ( ( markup )+ statement )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:124:6: ( markup )+ statement
        {
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:124:6: ( markup )+
        int cnt41=0;
        loop41:
        do {
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==IDCON) ) {
                int LA41_2 = input.LA(2);

                if ( (synpred47_Waebric()) ) {
                    alt41=1;
                }


            }


            switch (alt41) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred48_Waebric909);
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

        pushFollow(FOLLOW_statement_in_synpred48_Waebric912);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred48_Waebric

    // $ANTLR start synpred50_Waebric
    public final void synpred50_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:127:6: ( ( markup )+ embedding ';' )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:127:6: ( markup )+ embedding ';'
        {
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:127:6: ( markup )+
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
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred50_Waebric944);
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

        pushFollow(FOLLOW_embedding_in_synpred50_Waebric947);
        embedding();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred50_Waebric949); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred50_Waebric

    // $ANTLR start synpred51_Waebric
    public final void synpred51_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:130:6: ( markup )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:130:6: markup
        {
        pushFollow(FOLLOW_markup_in_synpred51_Waebric980);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred51_Waebric

    // $ANTLR start synpred54_Waebric
    public final void synpred54_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:144:7: ( expression )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:144:7: expression
        {
        pushFollow(FOLLOW_expression_in_synpred54_Waebric1063);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred54_Waebric

    // $ANTLR start synpred55_Waebric
    public final void synpred55_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:146:8: ( '&&' predicate )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:146:8: '&&' predicate
        {
        match(input,60,FOLLOW_60_in_synpred55_Waebric1086); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred55_Waebric1088);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred55_Waebric

    // $ANTLR start synpred56_Waebric
    public final void synpred56_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:146:25: ( '||' predicate )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:146:25: '||' predicate
        {
        match(input,61,FOLLOW_61_in_synpred56_Waebric1092); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred56_Waebric1094);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred56_Waebric

    // $ANTLR start synpred60_Waebric
    public final void synpred60_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:153:10: ( ( markup )* expression )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:153:10: ( markup )* expression
        {
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:153:10: ( markup )*
        loop43:
        do {
            int alt43=2;
            alt43 = dfa43.predict(input);
            switch (alt43) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred60_Waebric1140);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop43;
            }
        } while (true);

        pushFollow(FOLLOW_expression_in_synpred60_Waebric1143);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred60_Waebric

    // $ANTLR start synpred61_Waebric
    public final void synpred61_Waebric_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:153:31: ( markup )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/Waebric.g:153:31: markup
        {
        pushFollow(FOLLOW_markup_in_synpred61_Waebric1147);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred61_Waebric

    // Delegated rules

    public final boolean synpred61_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred61_Waebric_fragment(); // can never throw exception
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
    public final boolean synpred56_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred56_Waebric_fragment(); // can never throw exception
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
    public final boolean synpred44_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_Waebric_fragment(); // can never throw exception
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
    public final boolean synpred41_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred41_Waebric_fragment(); // can never throw exception
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
    public final boolean synpred50_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred50_Waebric_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred40_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred40_Waebric_fragment(); // can never throw exception
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


    protected DFA27 dfa27 = new DFA27(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA31 dfa31 = new DFA31(this);
    protected DFA40 dfa40 = new DFA40(this);
    protected DFA43 dfa43 = new DFA43(this);
    static final String DFA27_eotS =
        "\23\uffff";
    static final String DFA27_eofS =
        "\23\uffff";
    static final String DFA27_minS =
        "\1\4\1\0\4\uffff\1\0\2\uffff\1\0\11\uffff";
    static final String DFA27_maxS =
        "\1\71\1\0\4\uffff\1\0\2\uffff\1\0\11\uffff";
    static final String DFA27_acceptS =
        "\2\uffff\1\3\1\4\1\5\1\6\1\uffff\1\11\1\12\1\uffff\1\1\1\2\1\7\1"+
        "\10\1\13\1\14\1\15\1\16\1\17";
    static final String DFA27_specialS =
        "\1\uffff\1\0\4\uffff\1\1\2\uffff\1\2\11\uffff}>";
    static final String[] DFA27_transitionS = {
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

    static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
    static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
    static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
    static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
    static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
    static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
    static final short[][] DFA27_transition;

    static {
        int numStates = DFA27_transitionS.length;
        DFA27_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = DFA27_eot;
            this.eof = DFA27_eof;
            this.min = DFA27_min;
            this.max = DFA27_max;
            this.accept = DFA27_accept;
            this.special = DFA27_special;
            this.transition = DFA27_transition;
        }
        public String getDescription() {
            return "98:1: statement : ( 'if' '(' predicate ')' statement 'else' statement -> ^( 'if' predicate statement 'else' statement ) | 'if' '(' predicate ')' statement -> ^( 'if' predicate statement ) | 'each' '(' IDCON ':' expression ')' statement -> ^( 'each' IDCON expression statement ) | 'let' ( assignment )+ 'in' ( statement )* 'end' -> ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | '{' ( statement )* '}' -> ^( '{' ( statement )* '}' ) | 'comment' STRCON ';' -> ^( 'comment' STRCON ) | 'echo' expression ';' -> ^( 'echo' expression ) | 'echo' embedding ';' -> ^( 'echo' embedding ) | 'cdata' expression ';' -> ^( 'cdata' expression ) | 'yield' ';' -> 'yield' | markup ';' -> markup | ( markup )+ expression ';' -> ^( markup ( markup )* ',' expression ';' ) | ( markup )+ statement -> ^( markup ( markup )* ',' statement ) | ( markup )+ embedding ';' -> ^( markup ( markup )* embedding ';' ) | ( markup )+ markup ';' -> ^( markup ( markup )* ';' ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA27_1 = input.LA(1);

                         
                        int index27_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_Waebric()) ) {s = 10;}

                        else if ( (synpred32_Waebric()) ) {s = 11;}

                         
                        input.seek(index27_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA27_6 = input.LA(1);

                         
                        int index27_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred40_Waebric()) ) {s = 12;}

                        else if ( (synpred41_Waebric()) ) {s = 13;}

                         
                        input.seek(index27_6);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA27_9 = input.LA(1);

                         
                        int index27_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred44_Waebric()) ) {s = 14;}

                        else if ( (synpred46_Waebric()) ) {s = 15;}

                        else if ( (synpred48_Waebric()) ) {s = 16;}

                        else if ( (synpred50_Waebric()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index27_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 27, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA23_eotS =
        "\6\uffff";
    static final String DFA23_eofS =
        "\6\uffff";
    static final String DFA23_minS =
        "\2\4\2\uffff\2\4";
    static final String DFA23_maxS =
        "\1\56\1\60\2\uffff\1\4\1\60";
    static final String DFA23_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA23_specialS =
        "\6\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\1\1\uffff\3\2\43\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\7\uffff\1\2\21\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\7\uffff\1\2\21\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\2"
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
            return "()+ loopback of 121:6: ( markup )+";
        }
    }
    static final String DFA29_eotS =
        "\12\uffff";
    static final String DFA29_eofS =
        "\12\uffff";
    static final String DFA29_minS =
        "\1\4\1\uffff\6\0\2\uffff";
    static final String DFA29_maxS =
        "\1\73\1\uffff\6\0\2\uffff";
    static final String DFA29_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\1\3";
    static final String DFA29_specialS =
        "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\2\uffff}>";
    static final String[] DFA29_transitionS = {
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
            return "143:13: ( '!' predicate | expression | expression '.' type )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA29_2 = input.LA(1);

                         
                        int index29_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_Waebric()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index29_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA29_3 = input.LA(1);

                         
                        int index29_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_Waebric()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index29_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA29_4 = input.LA(1);

                         
                        int index29_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_Waebric()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index29_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA29_5 = input.LA(1);

                         
                        int index29_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_Waebric()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index29_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA29_6 = input.LA(1);

                         
                        int index29_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_Waebric()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index29_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA29_7 = input.LA(1);

                         
                        int index29_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_Waebric()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index29_7);
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
    static final String DFA31_eotS =
        "\6\uffff";
    static final String DFA31_eofS =
        "\6\uffff";
    static final String DFA31_minS =
        "\2\4\2\uffff\2\4";
    static final String DFA31_maxS =
        "\1\56\1\60\2\uffff\1\4\1\60";
    static final String DFA31_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA31_specialS =
        "\6\uffff}>";
    static final String[] DFA31_transitionS = {
            "\1\1\1\uffff\3\2\43\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\2\uffff\2\2\25\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\2\uffff\2\2\25\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\2"
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
            return "()* loopback of 153:10: ( markup )*";
        }
    }
    static final String DFA40_eotS =
        "\6\uffff";
    static final String DFA40_eofS =
        "\6\uffff";
    static final String DFA40_minS =
        "\2\4\1\uffff\1\4\1\uffff\1\4";
    static final String DFA40_maxS =
        "\1\56\1\60\1\uffff\1\4\1\uffff\1\60";
    static final String DFA40_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String DFA40_specialS =
        "\6\uffff}>";
    static final String[] DFA40_transitionS = {
            "\1\1\1\uffff\3\2\43\uffff\1\2\1\uffff\1\2",
            "\1\4\1\uffff\3\4\7\uffff\1\2\21\uffff\1\3\1\uffff\4\4\1\uffff"+
            "\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\2",
            "",
            "\1\5",
            "",
            "\1\4\1\uffff\3\4\7\uffff\1\2\21\uffff\1\3\1\uffff\4\4\1\uffff"+
            "\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\2"
    };

    static final short[] DFA40_eot = DFA.unpackEncodedString(DFA40_eotS);
    static final short[] DFA40_eof = DFA.unpackEncodedString(DFA40_eofS);
    static final char[] DFA40_min = DFA.unpackEncodedStringToUnsignedChars(DFA40_minS);
    static final char[] DFA40_max = DFA.unpackEncodedStringToUnsignedChars(DFA40_maxS);
    static final short[] DFA40_accept = DFA.unpackEncodedString(DFA40_acceptS);
    static final short[] DFA40_special = DFA.unpackEncodedString(DFA40_specialS);
    static final short[][] DFA40_transition;

    static {
        int numStates = DFA40_transitionS.length;
        DFA40_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA40_transition[i] = DFA.unpackEncodedString(DFA40_transitionS[i]);
        }
    }

    class DFA40 extends DFA {

        public DFA40(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 40;
            this.eot = DFA40_eot;
            this.eof = DFA40_eof;
            this.min = DFA40_min;
            this.max = DFA40_max;
            this.accept = DFA40_accept;
            this.special = DFA40_special;
            this.transition = DFA40_transition;
        }
        public String getDescription() {
            return "()+ loopback of 121:6: ( markup )+";
        }
    }
    static final String DFA43_eotS =
        "\6\uffff";
    static final String DFA43_eofS =
        "\1\uffff\1\2\3\uffff\1\2";
    static final String DFA43_minS =
        "\2\4\2\uffff\2\4";
    static final String DFA43_maxS =
        "\1\56\1\60\2\uffff\1\4\1\60";
    static final String DFA43_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA43_specialS =
        "\6\uffff}>";
    static final String[] DFA43_transitionS = {
            "\1\1\1\uffff\3\2\43\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\31\uffff\1\4\1\uffff\4\3\1\uffff\1\3\2\uffff"+
            "\1\3\1\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\31\uffff\1\4\1\uffff\4\3\1\uffff\1\3\2\uffff"+
            "\1\3\1\uffff\1\3\1\uffff\1\2"
    };

    static final short[] DFA43_eot = DFA.unpackEncodedString(DFA43_eotS);
    static final short[] DFA43_eof = DFA.unpackEncodedString(DFA43_eofS);
    static final char[] DFA43_min = DFA.unpackEncodedStringToUnsignedChars(DFA43_minS);
    static final char[] DFA43_max = DFA.unpackEncodedStringToUnsignedChars(DFA43_maxS);
    static final short[] DFA43_accept = DFA.unpackEncodedString(DFA43_acceptS);
    static final short[] DFA43_special = DFA.unpackEncodedString(DFA43_specialS);
    static final short[][] DFA43_transition;

    static {
        int numStates = DFA43_transitionS.length;
        DFA43_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA43_transition[i] = DFA.unpackEncodedString(DFA43_transitionS[i]);
        }
    }

    class DFA43 extends DFA {

        public DFA43(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 43;
            this.eot = DFA43_eot;
            this.eof = DFA43_eof;
            this.min = DFA43_min;
            this.max = DFA43_max;
            this.accept = DFA43_accept;
            this.special = DFA43_special;
            this.transition = DFA43_transition;
        }
        public String getDescription() {
            return "()* loopback of 153:10: ( markup )*";
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
    public static final BitSet FOLLOW_SITE_in_site212 = new BitSet(new long[]{0x0000000000018020L});
    public static final BitSet FOLLOW_mappings_in_site214 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_END_in_site216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapping_in_mappings224 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_SEMICOLON_in_mappings229 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_mapping_in_mappings231 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_PATH_in_mapping243 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_mapping245 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_mapping247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_designator_in_markup260 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_arguments_in_markup262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_designator271 = new BitSet(new long[]{0x000000F400000002L});
    public static final BitSet FOLLOW_attribute_in_designator273 = new BitSet(new long[]{0x000000F400000002L});
    public static final BitSet FOLLOW_37_in_attribute282 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_attribute292 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_attribute302 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_attribute312 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_attribute322 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NATCON_in_attribute324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_attribute332 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NATCON_in_attribute334 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_attribute336 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NATCON_in_attribute338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_arguments346 = new BitSet(new long[]{0x00005C00000001D0L});
    public static final BitSet FOLLOW_argument_in_arguments348 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_42_in_arguments353 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_argument_in_arguments355 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_43_in_arguments360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_argument368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_expression382 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_NATCON_in_expression386 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_TEXT_in_expression390 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_SYMBOLCON_in_expression394 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_44_in_expression403 = new BitSet(new long[]{0x00007400000001D0L});
    public static final BitSet FOLLOW_expression_in_expression405 = new BitSet(new long[]{0x0000240000000000L});
    public static final BitSet FOLLOW_42_in_expression410 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_expression412 = new BitSet(new long[]{0x0000240000000000L});
    public static final BitSet FOLLOW_45_in_expression417 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_46_in_expression426 = new BitSet(new long[]{0x0000840000000010L});
    public static final BitSet FOLLOW_keyValuePair_in_expression428 = new BitSet(new long[]{0x0000840000000000L});
    public static final BitSet FOLLOW_42_in_expression433 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_keyValuePair_in_expression435 = new BitSet(new long[]{0x0000840000000000L});
    public static final BitSet FOLLOW_47_in_expression440 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_48_in_expression450 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_expression452 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_34_in_expression458 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_expression460 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_IDCON_in_keyValuePair473 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_keyValuePair475 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_keyValuePair477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_function489 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_function491 = new BitSet(new long[]{0x03B442000000A010L});
    public static final BitSet FOLLOW_formals_in_function493 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_statement_in_function496 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_END_in_function499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_formals509 = new BitSet(new long[]{0x00000C0000000010L});
    public static final BitSet FOLLOW_IDCON_in_formals511 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_42_in_formals516 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_formals518 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_43_in_formals523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_statement555 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_statement557 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_statement559 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_statement561 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement563 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_statement565 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_statement604 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_statement606 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_statement608 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_statement610 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_statement640 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_statement642 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_statement644 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_statement646 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_statement648 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_statement650 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_statement677 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_assignment_in_statement679 = new BitSet(new long[]{0x0040000000000010L});
    public static final BitSet FOLLOW_54_in_statement682 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_statement_in_statement684 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_END_in_statement687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_statement716 = new BitSet(new long[]{0x03B4C00000002010L});
    public static final BitSet FOLLOW_statement_in_statement718 = new BitSet(new long[]{0x03B4C00000002010L});
    public static final BitSet FOLLOW_47_in_statement721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMENT_in_statement745 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_STRCON_in_statement747 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_statement770 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_statement772 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_statement795 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_embedding_in_statement797 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_statement820 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_statement822 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_statement845 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement858 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement871 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_statement874 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement909 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement944 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_embedding_in_statement947 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement980 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_statement983 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_assignment1019 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_assignment1021 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_assignment1023 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_assignment1025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_assignment1033 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_formals_in_assignment1035 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_assignment1037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_predicate1052 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_predicate1054 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate1063 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate1072 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_predicate1074 = new BitSet(new long[]{0xC000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_type_in_predicate1076 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_60_in_predicate1086 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_predicate1088 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_61_in_predicate1092 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_predicate1094 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding1127 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_embed_in_embedding1129 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_textTail_in_embedding1131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed1140 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_embed1143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed1147 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_embed1150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail1158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail1162 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_embed_in_textTail1164 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_textTail_in_textTail1166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_synpred25_Waebric450 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_synpred25_Waebric452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_synpred26_Waebric458 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_synpred26_Waebric460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_synpred31_Waebric555 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_synpred31_Waebric557 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_synpred31_Waebric559 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_synpred31_Waebric561 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_synpred31_Waebric563 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_synpred31_Waebric565 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_synpred31_Waebric567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_synpred32_Waebric604 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_synpred32_Waebric606 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_synpred32_Waebric608 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_synpred32_Waebric610 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_synpred32_Waebric612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_synpred40_Waebric770 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_synpred40_Waebric772 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred40_Waebric774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_synpred41_Waebric795 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_embedding_in_synpred41_Waebric797 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred41_Waebric799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred44_Waebric858 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred44_Waebric860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred46_Waebric871 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_synpred46_Waebric874 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred46_Waebric876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred47_Waebric909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred48_Waebric909 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_synpred48_Waebric912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred50_Waebric944 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_embedding_in_synpred50_Waebric947 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred50_Waebric949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred51_Waebric980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred54_Waebric1063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_synpred55_Waebric1086 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_synpred55_Waebric1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred56_Waebric1092 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_synpred56_Waebric1094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred60_Waebric1140 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_synpred60_Waebric1143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred61_Waebric1147 = new BitSet(new long[]{0x0000000000000002L});

}