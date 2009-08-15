// $ANTLR 3.1.2 /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g 2009-08-15 16:06:02

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATTRIBUTES", "ARGUMENTS", "MARKUP", "MARKUP_STATEMENT", "FORMALS", "FUNCTION", "IDCON", "PATH", "NATCON", "TEXT", "SYMBOLCON", "STRCON", "PRETEXT", "POSTTEXT", "MIDTEXT", "COMMENT", "SITE", "END", "SEMICOLON", "LETTER", "DIGIT", "HEXADECIMAL", "PATHELEMENT", "FILEEXT", "STRCHAR", "ESCLAYOUT", "DECIMAL", "TEXTCHAR", "ESCQUOTE", "AMP", "CHARREF", "ENTREF", "SYMBOLCHAR", "COMMENTS", "LAYOUT", "'module'", "'.'", "'import'", "':'", "'#'", "'$'", "'@'", "'%'", "'('", "','", "')'", "'='", "'['", "']'", "'{'", "'}'", "'+'", "'if'", "'else'", "'each'", "'let'", "'in'", "'echo'", "'cdata'", "'yield;'", "'!'", "'&&'", "'||'", "'list'", "'record'", "'string'"
    };
    public static final int ESCLAYOUT=29;
    public static final int T__42=42;
    public static final int END=21;
    public static final int T__57=57;
    public static final int FILEEXT=27;
    public static final int T__51=51;
    public static final int T__47=47;
    public static final int T__69=69;
    public static final int STRCHAR=28;
    public static final int T__50=50;
    public static final int T__65=65;
    public static final int SYMBOLCON=14;
    public static final int COMMENTS=37;
    public static final int DECIMAL=30;
    public static final int IDCON=10;
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
    public static final int SYMBOLCHAR=36;
    public static final int T__66=66;
    public static final int COMMENT=19;
    public static final int MARKUP_STATEMENT=7;
    public static final int FORMALS=8;
    public static final int T__45=45;
    public static final int T__55=55;
    public static final int CHARREF=34;
    public static final int MIDTEXT=18;
    public static final int T__63=63;
    public static final int PRETEXT=16;
    public static final int SEMICOLON=22;
    public static final int T__43=43;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:50:1: module : 'module' moduleId ( imprt | site | function )* -> ^( 'module' moduleId ( imprt )* ( site )* ( function )* ) ;
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
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleSubtreeStream stream_imprt=new RewriteRuleSubtreeStream(adaptor,"rule imprt");
        RewriteRuleSubtreeStream stream_site=new RewriteRuleSubtreeStream(adaptor,"rule site");
        RewriteRuleSubtreeStream stream_moduleId=new RewriteRuleSubtreeStream(adaptor,"rule moduleId");
        RewriteRuleSubtreeStream stream_function=new RewriteRuleSubtreeStream(adaptor,"rule function");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:50:7: ( 'module' moduleId ( imprt | site | function )* -> ^( 'module' moduleId ( imprt )* ( site )* ( function )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:50:11: 'module' moduleId ( imprt | site | function )*
            {
            string_literal1=(Token)match(input,39,FOLLOW_39_in_module125); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_39.add(string_literal1);

            pushFollow(FOLLOW_moduleId_in_module127);
            moduleId2=moduleId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_moduleId.add(moduleId2.getTree());
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:50:29: ( imprt | site | function )*
            loop1:
            do {
                int alt1=4;
                switch ( input.LA(1) ) {
                case 41:
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
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:50:31: imprt
            	    {
            	    pushFollow(FOLLOW_imprt_in_module131);
            	    imprt3=imprt();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_imprt.add(imprt3.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:50:39: site
            	    {
            	    pushFollow(FOLLOW_site_in_module135);
            	    site4=site();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_site.add(site4.getTree());

            	    }
            	    break;
            	case 3 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:50:46: function
            	    {
            	    pushFollow(FOLLOW_function_in_module139);
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
            // elements: 39, site, imprt, function, moduleId
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 51:5: -> ^( 'module' moduleId ( imprt )* ( site )* ( function )* )
            {
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:51:8: ^( 'module' moduleId ( imprt )* ( site )* ( function )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_39.nextNode(), root_1);

                adaptor.addChild(root_1, stream_moduleId.nextTree());
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:51:29: ( imprt )*
                while ( stream_imprt.hasNext() ) {
                    adaptor.addChild(root_1, stream_imprt.nextTree());

                }
                stream_imprt.reset();
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:51:36: ( site )*
                while ( stream_site.hasNext() ) {
                    adaptor.addChild(root_1, stream_site.nextTree());

                }
                stream_site.reset();
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:51:42: ( function )*
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:53:1: moduleId returns [String path = \"\"] : e= IDCON ( '.' e= IDCON )* ;
    public final WaebricParser.moduleId_return moduleId() throws RecognitionException {
        WaebricParser.moduleId_return retval = new WaebricParser.moduleId_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token e=null;
        Token char_literal6=null;

        Object e_tree=null;
        Object char_literal6_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:56:2: (e= IDCON ( '.' e= IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:56:5: e= IDCON ( '.' e= IDCON )*
            {
            root_0 = (Object)adaptor.nil();

            e=(Token)match(input,IDCON,FOLLOW_IDCON_in_moduleId193); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            e_tree = (Object)adaptor.create(e);
            adaptor.addChild(root_0, e_tree);
            }
            if ( state.backtracking==0 ) {
               retval.path += e.getText(); 
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:57:4: ( '.' e= IDCON )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==40) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:57:6: '.' e= IDCON
            	    {
            	    char_literal6=(Token)match(input,40,FOLLOW_40_in_moduleId203); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal6_tree = (Object)adaptor.create(char_literal6);
            	    adaptor.addChild(root_0, char_literal6_tree);
            	    }
            	    e=(Token)match(input,IDCON,FOLLOW_IDCON_in_moduleId207); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:59:1: imprt : 'import' moduleId -> 'import' moduleId ^() ;
    public final WaebricParser.imprt_return imprt() throws RecognitionException {
        WaebricParser.imprt_return retval = new WaebricParser.imprt_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal7=null;
        WaebricParser.moduleId_return moduleId8 = null;


        Object string_literal7_tree=null;
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleSubtreeStream stream_moduleId=new RewriteRuleSubtreeStream(adaptor,"rule moduleId");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:59:6: ( 'import' moduleId -> 'import' moduleId ^() )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:59:10: 'import' moduleId
            {
            string_literal7=(Token)match(input,41,FOLLOW_41_in_imprt223); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_41.add(string_literal7);

            pushFollow(FOLLOW_moduleId_in_imprt225);
            moduleId8=moduleId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_moduleId.add(moduleId8.getTree());


            // AST REWRITE
            // elements: moduleId, 41
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 60:5: -> 'import' moduleId ^()
            {
                adaptor.addChild(root_0, stream_41.nextNode());
                adaptor.addChild(root_0, stream_moduleId.nextTree());
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:60:26: ^()
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot( parseFile((moduleId8!=null?moduleId8.path:null)) , root_1);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:65:1: site : 'site' mappings 'end' ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:65:5: ( 'site' mappings 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:65:9: 'site' mappings 'end'
            {
            root_0 = (Object)adaptor.nil();

            string_literal9=(Token)match(input,SITE,FOLLOW_SITE_in_site254); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal9_tree = (Object)adaptor.create(string_literal9);
            adaptor.addChild(root_0, string_literal9_tree);
            }
            pushFollow(FOLLOW_mappings_in_site256);
            mappings10=mappings();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mappings10.getTree());
            string_literal11=(Token)match(input,END,FOLLOW_END_in_site258); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:66:1: mappings : ( mapping )? ( ';' mapping )* ;
    public final WaebricParser.mappings_return mappings() throws RecognitionException {
        WaebricParser.mappings_return retval = new WaebricParser.mappings_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal13=null;
        WaebricParser.mapping_return mapping12 = null;

        WaebricParser.mapping_return mapping14 = null;


        Object char_literal13_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:66:9: ( ( mapping )? ( ';' mapping )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:66:12: ( mapping )? ( ';' mapping )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:66:12: ( mapping )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==PATH) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: mapping
                    {
                    pushFollow(FOLLOW_mapping_in_mappings266);
                    mapping12=mapping();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, mapping12.getTree());

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:66:21: ( ';' mapping )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==SEMICOLON) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:66:23: ';' mapping
            	    {
            	    char_literal13=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_mappings271); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal13_tree = (Object)adaptor.create(char_literal13);
            	    adaptor.addChild(root_0, char_literal13_tree);
            	    }
            	    pushFollow(FOLLOW_mapping_in_mappings273);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:67:1: mapping : PATH ':' markup ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:67:9: ( PATH ':' markup )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:67:12: PATH ':' markup
            {
            root_0 = (Object)adaptor.nil();

            PATH15=(Token)match(input,PATH,FOLLOW_PATH_in_mapping285); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PATH15_tree = (Object)adaptor.create(PATH15);
            adaptor.addChild(root_0, PATH15_tree);
            }
            char_literal16=(Token)match(input,42,FOLLOW_42_in_mapping287); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal16_tree = (Object)adaptor.create(char_literal16);
            adaptor.addChild(root_0, char_literal16_tree);
            }
            pushFollow(FOLLOW_markup_in_mapping289);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:72:1: markup : IDCON attributes arguments -> ^( MARKUP IDCON attributes arguments ) ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:72:7: ( IDCON attributes arguments -> ^( MARKUP IDCON attributes arguments ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:72:11: IDCON attributes arguments
            {
            IDCON18=(Token)match(input,IDCON,FOLLOW_IDCON_in_markup302); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDCON.add(IDCON18);

            pushFollow(FOLLOW_attributes_in_markup304);
            attributes19=attributes();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_attributes.add(attributes19.getTree());
            pushFollow(FOLLOW_arguments_in_markup306);
            arguments20=arguments();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_arguments.add(arguments20.getTree());


            // AST REWRITE
            // elements: arguments, attributes, IDCON
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 73:5: -> ^( MARKUP IDCON attributes arguments )
            {
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:73:8: ^( MARKUP IDCON attributes arguments )
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:75:1: attributes : ( attribute )* -> ^( ATTRIBUTES ( attribute )* ) ;
    public final WaebricParser.attributes_return attributes() throws RecognitionException {
        WaebricParser.attributes_return retval = new WaebricParser.attributes_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WaebricParser.attribute_return attribute21 = null;


        RewriteRuleSubtreeStream stream_attribute=new RewriteRuleSubtreeStream(adaptor,"rule attribute");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:75:11: ( ( attribute )* -> ^( ATTRIBUTES ( attribute )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:75:14: ( attribute )*
            {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:75:14: ( attribute )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==40||(LA5_0>=42 && LA5_0<=45)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: attribute
            	    {
            	    pushFollow(FOLLOW_attribute_in_attributes337);
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
            // 76:5: -> ^( ATTRIBUTES ( attribute )* )
            {
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:76:8: ^( ATTRIBUTES ( attribute )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ATTRIBUTES, "ATTRIBUTES"), root_1);

                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:76:22: ( attribute )*
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:78:1: attribute : ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON );
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:78:10: ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON )
            int alt6=6;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt6=1;
                }
                break;
            case 40:
                {
                alt6=2;
                }
                break;
            case 44:
                {
                alt6=3;
                }
                break;
            case 42:
                {
                alt6=4;
                }
                break;
            case 45:
                {
                int LA6_5 = input.LA(2);

                if ( (LA6_5==NATCON) ) {
                    int LA6_6 = input.LA(3);

                    if ( (LA6_6==46) ) {
                        alt6=6;
                    }
                    else if ( (LA6_6==EOF||LA6_6==IDCON||(LA6_6>=NATCON && LA6_6<=SYMBOLCON)||(LA6_6>=PRETEXT && LA6_6<=COMMENT)||(LA6_6>=END && LA6_6<=SEMICOLON)||LA6_6==40||(LA6_6>=42 && LA6_6<=45)||LA6_6==47||LA6_6==51||LA6_6==53||LA6_6==56||(LA6_6>=58 && LA6_6<=59)||(LA6_6>=61 && LA6_6<=63)) ) {
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:78:13: '#' IDCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal22=(Token)match(input,43,FOLLOW_43_in_attribute363); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal22_tree = (Object)adaptor.create(char_literal22);
                    adaptor.addChild(root_0, char_literal22_tree);
                    }
                    IDCON23=(Token)match(input,IDCON,FOLLOW_IDCON_in_attribute365); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON23_tree = (Object)adaptor.create(IDCON23);
                    adaptor.addChild(root_0, IDCON23_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:79:6: '.' IDCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal24=(Token)match(input,40,FOLLOW_40_in_attribute373); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal24_tree = (Object)adaptor.create(char_literal24);
                    adaptor.addChild(root_0, char_literal24_tree);
                    }
                    IDCON25=(Token)match(input,IDCON,FOLLOW_IDCON_in_attribute375); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON25_tree = (Object)adaptor.create(IDCON25);
                    adaptor.addChild(root_0, IDCON25_tree);
                    }

                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:80:6: '$' IDCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal26=(Token)match(input,44,FOLLOW_44_in_attribute383); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal26_tree = (Object)adaptor.create(char_literal26);
                    adaptor.addChild(root_0, char_literal26_tree);
                    }
                    IDCON27=(Token)match(input,IDCON,FOLLOW_IDCON_in_attribute385); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON27_tree = (Object)adaptor.create(IDCON27);
                    adaptor.addChild(root_0, IDCON27_tree);
                    }

                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:81:6: ':' IDCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal28=(Token)match(input,42,FOLLOW_42_in_attribute393); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal28_tree = (Object)adaptor.create(char_literal28);
                    adaptor.addChild(root_0, char_literal28_tree);
                    }
                    IDCON29=(Token)match(input,IDCON,FOLLOW_IDCON_in_attribute395); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON29_tree = (Object)adaptor.create(IDCON29);
                    adaptor.addChild(root_0, IDCON29_tree);
                    }

                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:82:6: '@' NATCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal30=(Token)match(input,45,FOLLOW_45_in_attribute403); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal30_tree = (Object)adaptor.create(char_literal30);
                    adaptor.addChild(root_0, char_literal30_tree);
                    }
                    NATCON31=(Token)match(input,NATCON,FOLLOW_NATCON_in_attribute405); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON31_tree = (Object)adaptor.create(NATCON31);
                    adaptor.addChild(root_0, NATCON31_tree);
                    }

                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:83:6: '@' NATCON '%' NATCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal32=(Token)match(input,45,FOLLOW_45_in_attribute413); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal32_tree = (Object)adaptor.create(char_literal32);
                    adaptor.addChild(root_0, char_literal32_tree);
                    }
                    NATCON33=(Token)match(input,NATCON,FOLLOW_NATCON_in_attribute415); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON33_tree = (Object)adaptor.create(NATCON33);
                    adaptor.addChild(root_0, NATCON33_tree);
                    }
                    char_literal34=(Token)match(input,46,FOLLOW_46_in_attribute417); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal34_tree = (Object)adaptor.create(char_literal34);
                    adaptor.addChild(root_0, char_literal34_tree);
                    }
                    NATCON35=(Token)match(input,NATCON,FOLLOW_NATCON_in_attribute419); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:85:1: arguments : ( '(' ( argument )? ( ',' argument )* ')' )? -> ^( ARGUMENTS ( argument )* ) ;
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
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleSubtreeStream stream_argument=new RewriteRuleSubtreeStream(adaptor,"rule argument");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:85:10: ( ( '(' ( argument )? ( ',' argument )* ')' )? -> ^( ARGUMENTS ( argument )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:85:13: ( '(' ( argument )? ( ',' argument )* ')' )?
            {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:85:13: ( '(' ( argument )? ( ',' argument )* ')' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==47) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:85:15: '(' ( argument )? ( ',' argument )* ')'
                    {
                    char_literal36=(Token)match(input,47,FOLLOW_47_in_arguments433); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_47.add(char_literal36);

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:85:19: ( argument )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==IDCON||(LA7_0>=NATCON && LA7_0<=SYMBOLCON)||LA7_0==51||LA7_0==53) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: argument
                            {
                            pushFollow(FOLLOW_argument_in_arguments435);
                            argument37=argument();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_argument.add(argument37.getTree());

                            }
                            break;

                    }

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:85:29: ( ',' argument )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==48) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:85:31: ',' argument
                    	    {
                    	    char_literal38=(Token)match(input,48,FOLLOW_48_in_arguments440); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_48.add(char_literal38);

                    	    pushFollow(FOLLOW_argument_in_arguments442);
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

                    char_literal40=(Token)match(input,49,FOLLOW_49_in_arguments447); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_49.add(char_literal40);


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
            // 86:5: -> ^( ARGUMENTS ( argument )* )
            {
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:86:8: ^( ARGUMENTS ( argument )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARGUMENTS, "ARGUMENTS"), root_1);

                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:86:21: ( argument )*
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:88:1: argument : ( expression | IDCON '=' expression );
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:88:9: ( expression | IDCON '=' expression )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==IDCON) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==50) ) {
                    alt10=2;
                }
                else if ( (LA10_1==EOF||LA10_1==40||(LA10_1>=48 && LA10_1<=49)||LA10_1==55) ) {
                    alt10=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA10_0>=NATCON && LA10_0<=SYMBOLCON)||LA10_0==51||LA10_0==53) ) {
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:88:12: expression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_expression_in_argument478);
                    expression41=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression41.getTree());

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:89:6: IDCON '=' expression
                    {
                    root_0 = (Object)adaptor.nil();

                    IDCON42=(Token)match(input,IDCON,FOLLOW_IDCON_in_argument486); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON42_tree = (Object)adaptor.create(IDCON42);
                    adaptor.addChild(root_0, IDCON42_tree);
                    }
                    char_literal43=(Token)match(input,50,FOLLOW_50_in_argument488); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal43_tree = (Object)adaptor.create(char_literal43);
                    adaptor.addChild(root_0, char_literal43_tree);
                    }
                    pushFollow(FOLLOW_expression_in_argument490);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:94:1: expression : ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:94:11: ( ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:94:14: ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:94:14: ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' )
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
            case 51:
                {
                alt15=5;
                }
                break;
            case 53:
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:94:16: IDCON
                    {
                    IDCON45=(Token)match(input,IDCON,FOLLOW_IDCON_in_expression505); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON45_tree = (Object)adaptor.create(IDCON45);
                    adaptor.addChild(root_0, IDCON45_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:94:24: NATCON
                    {
                    NATCON46=(Token)match(input,NATCON,FOLLOW_NATCON_in_expression509); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON46_tree = (Object)adaptor.create(NATCON46);
                    adaptor.addChild(root_0, NATCON46_tree);
                    }

                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:94:33: TEXT
                    {
                    TEXT47=(Token)match(input,TEXT,FOLLOW_TEXT_in_expression513); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TEXT47_tree = (Object)adaptor.create(TEXT47);
                    adaptor.addChild(root_0, TEXT47_tree);
                    }

                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:94:40: SYMBOLCON
                    {
                    SYMBOLCON48=(Token)match(input,SYMBOLCON,FOLLOW_SYMBOLCON_in_expression517); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SYMBOLCON48_tree = (Object)adaptor.create(SYMBOLCON48);
                    adaptor.addChild(root_0, SYMBOLCON48_tree);
                    }

                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:95:7: '[' ( expression )? ( ',' expression )* ']'
                    {
                    char_literal49=(Token)match(input,51,FOLLOW_51_in_expression526); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal49_tree = (Object)adaptor.create(char_literal49);
                    adaptor.addChild(root_0, char_literal49_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:95:11: ( expression )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==IDCON||(LA11_0>=NATCON && LA11_0<=SYMBOLCON)||LA11_0==51||LA11_0==53) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: expression
                            {
                            pushFollow(FOLLOW_expression_in_expression528);
                            expression50=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression50.getTree());

                            }
                            break;

                    }

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:95:23: ( ',' expression )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==48) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:95:25: ',' expression
                    	    {
                    	    char_literal51=(Token)match(input,48,FOLLOW_48_in_expression533); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal51_tree = (Object)adaptor.create(char_literal51);
                    	    adaptor.addChild(root_0, char_literal51_tree);
                    	    }
                    	    pushFollow(FOLLOW_expression_in_expression535);
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

                    char_literal53=(Token)match(input,52,FOLLOW_52_in_expression540); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal53_tree = (Object)adaptor.create(char_literal53);
                    adaptor.addChild(root_0, char_literal53_tree);
                    }

                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:96:7: '{' ( keyValuePair )? ( ',' keyValuePair )* '}'
                    {
                    char_literal54=(Token)match(input,53,FOLLOW_53_in_expression549); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal54_tree = (Object)adaptor.create(char_literal54);
                    adaptor.addChild(root_0, char_literal54_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:96:11: ( keyValuePair )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==IDCON) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: keyValuePair
                            {
                            pushFollow(FOLLOW_keyValuePair_in_expression551);
                            keyValuePair55=keyValuePair();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, keyValuePair55.getTree());

                            }
                            break;

                    }

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:96:25: ( ',' keyValuePair )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==48) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:96:27: ',' keyValuePair
                    	    {
                    	    char_literal56=(Token)match(input,48,FOLLOW_48_in_expression556); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal56_tree = (Object)adaptor.create(char_literal56);
                    	    adaptor.addChild(root_0, char_literal56_tree);
                    	    }
                    	    pushFollow(FOLLOW_keyValuePair_in_expression558);
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

                    char_literal58=(Token)match(input,54,FOLLOW_54_in_expression563); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal58_tree = (Object)adaptor.create(char_literal58);
                    adaptor.addChild(root_0, char_literal58_tree);
                    }

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:97:6: ( '+' expression | '.' IDCON )*
            loop16:
            do {
                int alt16=3;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==55) ) {
                    int LA16_2 = input.LA(2);

                    if ( (synpred26_Waebric()) ) {
                        alt16=1;
                    }


                }
                else if ( (LA16_0==40) ) {
                    int LA16_3 = input.LA(2);

                    if ( (synpred27_Waebric()) ) {
                        alt16=2;
                    }


                }


                switch (alt16) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:97:8: '+' expression
            	    {
            	    char_literal59=(Token)match(input,55,FOLLOW_55_in_expression573); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal59_tree = (Object)adaptor.create(char_literal59);
            	    adaptor.addChild(root_0, char_literal59_tree);
            	    }
            	    pushFollow(FOLLOW_expression_in_expression575);
            	    expression60=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression60.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:97:35: '.' IDCON
            	    {
            	    char_literal61=(Token)match(input,40,FOLLOW_40_in_expression581); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal61_tree = (Object)adaptor.create(char_literal61);
            	    adaptor.addChild(root_0, char_literal61_tree);
            	    }
            	    IDCON62=(Token)match(input,IDCON,FOLLOW_IDCON_in_expression583); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:98:1: keyValuePair : IDCON ':' expression ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:98:13: ( IDCON ':' expression )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:98:16: IDCON ':' expression
            {
            root_0 = (Object)adaptor.nil();

            IDCON63=(Token)match(input,IDCON,FOLLOW_IDCON_in_keyValuePair596); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON63_tree = (Object)adaptor.create(IDCON63);
            adaptor.addChild(root_0, IDCON63_tree);
            }
            char_literal64=(Token)match(input,42,FOLLOW_42_in_keyValuePair598); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal64_tree = (Object)adaptor.create(char_literal64);
            adaptor.addChild(root_0, char_literal64_tree);
            }
            pushFollow(FOLLOW_expression_in_keyValuePair600);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:103:1: function : 'def' IDCON ( formals )? ( statement )* 'end' -> ^( FUNCTION IDCON ^( FORMALS ( formals )? ) ( statement )* ) ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:103:9: ( 'def' IDCON ( formals )? ( statement )* 'end' -> ^( FUNCTION IDCON ^( FORMALS ( formals )? ) ( statement )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:103:12: 'def' IDCON ( formals )? ( statement )* 'end'
            {
            string_literal66=(Token)match(input,FUNCTION,FOLLOW_FUNCTION_in_function612); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FUNCTION.add(string_literal66);

            IDCON67=(Token)match(input,IDCON,FOLLOW_IDCON_in_function614); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDCON.add(IDCON67);

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:103:24: ( formals )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==47) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: formals
                    {
                    pushFollow(FOLLOW_formals_in_function616);
                    formals68=formals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_formals.add(formals68.getTree());

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:103:33: ( statement )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==IDCON||LA18_0==COMMENT||LA18_0==53||LA18_0==56||(LA18_0>=58 && LA18_0<=59)||(LA18_0>=61 && LA18_0<=63)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_function619);
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

            string_literal70=(Token)match(input,END,FOLLOW_END_in_function622); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_END.add(string_literal70);



            // AST REWRITE
            // elements: statement, formals, IDCON
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 104:5: -> ^( FUNCTION IDCON ^( FORMALS ( formals )? ) ( statement )* )
            {
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:104:8: ^( FUNCTION IDCON ^( FORMALS ( formals )? ) ( statement )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION, "FUNCTION"), root_1);

                adaptor.addChild(root_1, stream_IDCON.nextNode());
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:104:26: ^( FORMALS ( formals )? )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(FORMALS, "FORMALS"), root_2);

                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:104:37: ( formals )?
                if ( stream_formals.hasNext() ) {
                    adaptor.addChild(root_2, stream_formals.nextTree());

                }
                stream_formals.reset();

                adaptor.addChild(root_1, root_2);
                }
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:104:48: ( statement )*
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:106:1: formals : '(' ( IDCON )? ( ',' IDCON )* ')' -> ( IDCON )* ;
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
        RewriteRuleTokenStream stream_IDCON=new RewriteRuleTokenStream(adaptor,"token IDCON");
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:106:8: ( '(' ( IDCON )? ( ',' IDCON )* ')' -> ( IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:106:11: '(' ( IDCON )? ( ',' IDCON )* ')'
            {
            char_literal71=(Token)match(input,47,FOLLOW_47_in_formals659); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_47.add(char_literal71);

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:106:15: ( IDCON )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==IDCON) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: IDCON
                    {
                    IDCON72=(Token)match(input,IDCON,FOLLOW_IDCON_in_formals661); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDCON.add(IDCON72);


                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:106:22: ( ',' IDCON )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==48) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:106:24: ',' IDCON
            	    {
            	    char_literal73=(Token)match(input,48,FOLLOW_48_in_formals666); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_48.add(char_literal73);

            	    IDCON74=(Token)match(input,IDCON,FOLLOW_IDCON_in_formals668); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_IDCON.add(IDCON74);


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            char_literal75=(Token)match(input,49,FOLLOW_49_in_formals673); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_49.add(char_literal75);



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
            // 107:5: -> ( IDCON )*
            {
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:107:8: ( IDCON )*
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:113:1: statement : ( 'if' '(' predicate ')' statement ( 'else' statement )? -> ^( 'if' '(' predicate ')' statement ( 'else' statement )? ) | 'each' '(' IDCON ':' expression ')' statement -> ^( 'each' '(' IDCON ':' expression ')' statement ) | 'let' ( assignment )+ 'in' ( statement )* 'end' -> ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | '{' ( statement )* '}' -> ^( '{' ( statement )* '}' ) | 'comment' STRCON ';' -> ^( 'comment' STRCON ';' ) | 'echo' expression ';' -> ^( 'echo' expression ';' ) | 'echo' embedding ';' -> ^( 'echo' embedding ';' ) | 'cdata' expression ';' -> ^( 'cdata' expression ';' ) | 'yield;' | ( markup )+ expression ';' -> ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ( markup )+ statement -> ^( MARKUP_STATEMENT ( markup )+ statement ) | ( markup )+ embedding ';' -> ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) | ( markup )+ ';' -> ^( MARKUP_STATEMENT ( markup )+ ';' ) );
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
        Token char_literal113=null;
        Token char_literal118=null;
        Token char_literal120=null;
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

        WaebricParser.expression_return expression112 = null;

        WaebricParser.markup_return markup114 = null;

        WaebricParser.statement_return statement115 = null;

        WaebricParser.markup_return markup116 = null;

        WaebricParser.embedding_return embedding117 = null;

        WaebricParser.markup_return markup119 = null;


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
        Object char_literal113_tree=null;
        Object char_literal118_tree=null;
        Object char_literal120_tree=null;
        RewriteRuleTokenStream stream_END=new RewriteRuleTokenStream(adaptor,"token END");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
        RewriteRuleTokenStream stream_STRCON=new RewriteRuleTokenStream(adaptor,"token STRCON");
        RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
        RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
        RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
        RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
        RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
        RewriteRuleTokenStream stream_COMMENT=new RewriteRuleTokenStream(adaptor,"token COMMENT");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
        RewriteRuleTokenStream stream_IDCON=new RewriteRuleTokenStream(adaptor,"token IDCON");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_assignment=new RewriteRuleSubtreeStream(adaptor,"rule assignment");
        RewriteRuleSubtreeStream stream_embedding=new RewriteRuleSubtreeStream(adaptor,"rule embedding");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_predicate=new RewriteRuleSubtreeStream(adaptor,"rule predicate");
        RewriteRuleSubtreeStream stream_markup=new RewriteRuleSubtreeStream(adaptor,"rule markup");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:113:10: ( 'if' '(' predicate ')' statement ( 'else' statement )? -> ^( 'if' '(' predicate ')' statement ( 'else' statement )? ) | 'each' '(' IDCON ':' expression ')' statement -> ^( 'each' '(' IDCON ':' expression ')' statement ) | 'let' ( assignment )+ 'in' ( statement )* 'end' -> ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | '{' ( statement )* '}' -> ^( '{' ( statement )* '}' ) | 'comment' STRCON ';' -> ^( 'comment' STRCON ';' ) | 'echo' expression ';' -> ^( 'echo' expression ';' ) | 'echo' embedding ';' -> ^( 'echo' embedding ';' ) | 'cdata' expression ';' -> ^( 'cdata' expression ';' ) | 'yield;' | ( markup )+ expression ';' -> ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ( markup )+ statement -> ^( MARKUP_STATEMENT ( markup )+ statement ) | ( markup )+ embedding ';' -> ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) | ( markup )+ ';' -> ^( MARKUP_STATEMENT ( markup )+ ';' ) )
            int alt29=13;
            alt29 = dfa29.predict(input);
            switch (alt29) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:113:13: 'if' '(' predicate ')' statement ( 'else' statement )?
                    {
                    string_literal76=(Token)match(input,56,FOLLOW_56_in_statement695); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_56.add(string_literal76);

                    char_literal77=(Token)match(input,47,FOLLOW_47_in_statement697); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_47.add(char_literal77);

                    pushFollow(FOLLOW_predicate_in_statement699);
                    predicate78=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_predicate.add(predicate78.getTree());
                    char_literal79=(Token)match(input,49,FOLLOW_49_in_statement701); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_49.add(char_literal79);

                    pushFollow(FOLLOW_statement_in_statement703);
                    statement80=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement80.getTree());
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:113:46: ( 'else' statement )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==57) ) {
                        int LA21_1 = input.LA(2);

                        if ( (synpred32_Waebric()) ) {
                            alt21=1;
                        }
                    }
                    switch (alt21) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:113:48: 'else' statement
                            {
                            string_literal81=(Token)match(input,57,FOLLOW_57_in_statement707); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_57.add(string_literal81);

                            pushFollow(FOLLOW_statement_in_statement709);
                            statement82=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_statement.add(statement82.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: 49, predicate, statement, 47, 57, statement, 56
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 114:5: -> ^( 'if' '(' predicate ')' statement ( 'else' statement )? )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:114:8: ^( 'if' '(' predicate ')' statement ( 'else' statement )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_56.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_47.nextNode());
                        adaptor.addChild(root_1, stream_predicate.nextTree());
                        adaptor.addChild(root_1, stream_49.nextNode());
                        adaptor.addChild(root_1, stream_statement.nextTree());
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:114:44: ( 'else' statement )?
                        if ( stream_statement.hasNext()||stream_57.hasNext() ) {
                            adaptor.addChild(root_1, stream_57.nextNode());
                            adaptor.addChild(root_1, stream_statement.nextTree());

                        }
                        stream_statement.reset();
                        stream_57.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:115:6: 'each' '(' IDCON ':' expression ')' statement
                    {
                    string_literal83=(Token)match(input,58,FOLLOW_58_in_statement748); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_58.add(string_literal83);

                    char_literal84=(Token)match(input,47,FOLLOW_47_in_statement750); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_47.add(char_literal84);

                    IDCON85=(Token)match(input,IDCON,FOLLOW_IDCON_in_statement752); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDCON.add(IDCON85);

                    char_literal86=(Token)match(input,42,FOLLOW_42_in_statement754); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_42.add(char_literal86);

                    pushFollow(FOLLOW_expression_in_statement756);
                    expression87=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression87.getTree());
                    char_literal88=(Token)match(input,49,FOLLOW_49_in_statement758); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_49.add(char_literal88);

                    pushFollow(FOLLOW_statement_in_statement760);
                    statement89=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement89.getTree());


                    // AST REWRITE
                    // elements: expression, 47, statement, 42, 58, IDCON, 49
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 116:5: -> ^( 'each' '(' IDCON ':' expression ')' statement )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:116:8: ^( 'each' '(' IDCON ':' expression ')' statement )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_58.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_47.nextNode());
                        adaptor.addChild(root_1, stream_IDCON.nextNode());
                        adaptor.addChild(root_1, stream_42.nextNode());
                        adaptor.addChild(root_1, stream_expression.nextTree());
                        adaptor.addChild(root_1, stream_49.nextNode());
                        adaptor.addChild(root_1, stream_statement.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:117:6: 'let' ( assignment )+ 'in' ( statement )* 'end'
                    {
                    string_literal90=(Token)match(input,59,FOLLOW_59_in_statement792); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_59.add(string_literal90);

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:117:12: ( assignment )+
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
                    	    pushFollow(FOLLOW_assignment_in_statement794);
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

                    string_literal92=(Token)match(input,60,FOLLOW_60_in_statement797); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_60.add(string_literal92);

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:117:29: ( statement )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==IDCON||LA23_0==COMMENT||LA23_0==53||LA23_0==56||(LA23_0>=58 && LA23_0<=59)||(LA23_0>=61 && LA23_0<=63)) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_statement799);
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

                    string_literal94=(Token)match(input,END,FOLLOW_END_in_statement802); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_END.add(string_literal94);



                    // AST REWRITE
                    // elements: statement, 60, 59, END, assignment
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 118:5: -> ^( 'let' ( assignment )+ 'in' ( statement )* 'end' )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:118:8: ^( 'let' ( assignment )+ 'in' ( statement )* 'end' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_59.nextNode(), root_1);

                        if ( !(stream_assignment.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_assignment.hasNext() ) {
                            adaptor.addChild(root_1, stream_assignment.nextTree());

                        }
                        stream_assignment.reset();
                        adaptor.addChild(root_1, stream_60.nextNode());
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:118:34: ( statement )*
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:119:6: '{' ( statement )* '}'
                    {
                    char_literal95=(Token)match(input,53,FOLLOW_53_in_statement831); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_53.add(char_literal95);

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:119:10: ( statement )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==IDCON||LA24_0==COMMENT||LA24_0==53||LA24_0==56||(LA24_0>=58 && LA24_0<=59)||(LA24_0>=61 && LA24_0<=63)) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_statement833);
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

                    char_literal97=(Token)match(input,54,FOLLOW_54_in_statement836); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_54.add(char_literal97);



                    // AST REWRITE
                    // elements: 54, 53, statement
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 120:5: -> ^( '{' ( statement )* '}' )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:120:8: ^( '{' ( statement )* '}' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_53.nextNode(), root_1);

                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:120:15: ( statement )*
                        while ( stream_statement.hasNext() ) {
                            adaptor.addChild(root_1, stream_statement.nextTree());

                        }
                        stream_statement.reset();
                        adaptor.addChild(root_1, stream_54.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:121:6: 'comment' STRCON ';'
                    {
                    string_literal98=(Token)match(input,COMMENT,FOLLOW_COMMENT_in_statement860); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COMMENT.add(string_literal98);

                    STRCON99=(Token)match(input,STRCON,FOLLOW_STRCON_in_statement862); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRCON.add(STRCON99);

                    char_literal100=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement864); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal100);



                    // AST REWRITE
                    // elements: SEMICOLON, COMMENT, STRCON
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 122:5: -> ^( 'comment' STRCON ';' )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:122:8: ^( 'comment' STRCON ';' )
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:123:6: 'echo' expression ';'
                    {
                    string_literal101=(Token)match(input,61,FOLLOW_61_in_statement887); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_61.add(string_literal101);

                    pushFollow(FOLLOW_expression_in_statement889);
                    expression102=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression102.getTree());
                    char_literal103=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement891); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal103);



                    // AST REWRITE
                    // elements: expression, 61, SEMICOLON
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 124:5: -> ^( 'echo' expression ';' )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:124:8: ^( 'echo' expression ';' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_61.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_expression.nextTree());
                        adaptor.addChild(root_1, stream_SEMICOLON.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 7 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:125:6: 'echo' embedding ';'
                    {
                    string_literal104=(Token)match(input,61,FOLLOW_61_in_statement914); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_61.add(string_literal104);

                    pushFollow(FOLLOW_embedding_in_statement916);
                    embedding105=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_embedding.add(embedding105.getTree());
                    char_literal106=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement918); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal106);



                    // AST REWRITE
                    // elements: SEMICOLON, 61, embedding
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 126:5: -> ^( 'echo' embedding ';' )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:126:8: ^( 'echo' embedding ';' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_61.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_embedding.nextTree());
                        adaptor.addChild(root_1, stream_SEMICOLON.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 8 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:127:6: 'cdata' expression ';'
                    {
                    string_literal107=(Token)match(input,62,FOLLOW_62_in_statement941); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_62.add(string_literal107);

                    pushFollow(FOLLOW_expression_in_statement943);
                    expression108=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression108.getTree());
                    char_literal109=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement945); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal109);



                    // AST REWRITE
                    // elements: expression, 62, SEMICOLON
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 128:5: -> ^( 'cdata' expression ';' )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:128:8: ^( 'cdata' expression ';' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_62.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_expression.nextTree());
                        adaptor.addChild(root_1, stream_SEMICOLON.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 9 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:129:6: 'yield;'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal110=(Token)match(input,63,FOLLOW_63_in_statement969); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal110_tree = (Object)adaptor.create(string_literal110);
                    adaptor.addChild(root_0, string_literal110_tree);
                    }

                    }
                    break;
                case 10 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:130:6: ( markup )+ expression ';'
                    {
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:130:6: ( markup )+
                    int cnt25=0;
                    loop25:
                    do {
                        int alt25=2;
                        alt25 = dfa25.predict(input);
                        switch (alt25) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_statement976);
                    	    markup111=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_markup.add(markup111.getTree());

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

                    pushFollow(FOLLOW_expression_in_statement979);
                    expression112=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression112.getTree());
                    char_literal113=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement981); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal113);



                    // AST REWRITE
                    // elements: expression, SEMICOLON, markup
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 131:5: -> ^( MARKUP_STATEMENT ( markup )+ expression ';' )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:131:8: ^( MARKUP_STATEMENT ( markup )+ expression ';' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MARKUP_STATEMENT, "MARKUP_STATEMENT"), root_1);

                        if ( !(stream_markup.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_markup.hasNext() ) {
                            adaptor.addChild(root_1, stream_markup.nextTree());

                        }
                        stream_markup.reset();
                        adaptor.addChild(root_1, stream_expression.nextTree());
                        adaptor.addChild(root_1, stream_SEMICOLON.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 11 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:132:6: ( markup )+ statement
                    {
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:132:6: ( markup )+
                    int cnt26=0;
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==IDCON) ) {
                            int LA26_2 = input.LA(2);

                            if ( (synpred47_Waebric()) ) {
                                alt26=1;
                            }


                        }


                        switch (alt26) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_statement1008);
                    	    markup114=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_markup.add(markup114.getTree());

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

                    pushFollow(FOLLOW_statement_in_statement1011);
                    statement115=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement115.getTree());


                    // AST REWRITE
                    // elements: markup, statement
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 133:5: -> ^( MARKUP_STATEMENT ( markup )+ statement )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:133:8: ^( MARKUP_STATEMENT ( markup )+ statement )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MARKUP_STATEMENT, "MARKUP_STATEMENT"), root_1);

                        if ( !(stream_markup.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_markup.hasNext() ) {
                            adaptor.addChild(root_1, stream_markup.nextTree());

                        }
                        stream_markup.reset();
                        adaptor.addChild(root_1, stream_statement.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 12 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:134:6: ( markup )+ embedding ';'
                    {
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:134:6: ( markup )+
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
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_statement1036);
                    	    markup116=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_markup.add(markup116.getTree());

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

                    pushFollow(FOLLOW_embedding_in_statement1039);
                    embedding117=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_embedding.add(embedding117.getTree());
                    char_literal118=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement1041); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal118);



                    // AST REWRITE
                    // elements: embedding, markup, SEMICOLON
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 135:5: -> ^( MARKUP_STATEMENT ( markup )+ embedding ';' )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:135:8: ^( MARKUP_STATEMENT ( markup )+ embedding ';' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MARKUP_STATEMENT, "MARKUP_STATEMENT"), root_1);

                        if ( !(stream_markup.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
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
                case 13 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:136:6: ( markup )+ ';'
                    {
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:136:6: ( markup )+
                    int cnt28=0;
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==IDCON) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_statement1068);
                    	    markup119=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_markup.add(markup119.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt28 >= 1 ) break loop28;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(28, input);
                                throw eee;
                        }
                        cnt28++;
                    } while (true);

                    char_literal120=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement1071); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal120);



                    // AST REWRITE
                    // elements: markup, SEMICOLON
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 137:5: -> ^( MARKUP_STATEMENT ( markup )+ ';' )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:137:8: ^( MARKUP_STATEMENT ( markup )+ ';' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MARKUP_STATEMENT, "MARKUP_STATEMENT"), root_1);

                        if ( !(stream_markup.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:142:1: assignment : ( IDCON '=' expression ';' | IDCON formals '=' statement -> ^( FUNCTION IDCON ^( FORMALS ( formals )? ) statement ) );
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
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
        RewriteRuleTokenStream stream_IDCON=new RewriteRuleTokenStream(adaptor,"token IDCON");
        RewriteRuleSubtreeStream stream_formals=new RewriteRuleSubtreeStream(adaptor,"rule formals");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:142:11: ( IDCON '=' expression ';' | IDCON formals '=' statement -> ^( FUNCTION IDCON ^( FORMALS ( formals )? ) statement ) )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==IDCON) ) {
                int LA30_1 = input.LA(2);

                if ( (LA30_1==50) ) {
                    alt30=1;
                }
                else if ( (LA30_1==47) ) {
                    alt30=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 30, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:142:14: IDCON '=' expression ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    IDCON121=(Token)match(input,IDCON,FOLLOW_IDCON_in_assignment1101); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON121_tree = (Object)adaptor.create(IDCON121);
                    adaptor.addChild(root_0, IDCON121_tree);
                    }
                    char_literal122=(Token)match(input,50,FOLLOW_50_in_assignment1103); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal122_tree = (Object)adaptor.create(char_literal122);
                    adaptor.addChild(root_0, char_literal122_tree);
                    }
                    pushFollow(FOLLOW_expression_in_assignment1105);
                    expression123=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression123.getTree());
                    char_literal124=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_assignment1107); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal124_tree = (Object)adaptor.create(char_literal124);
                    adaptor.addChild(root_0, char_literal124_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:143:6: IDCON formals '=' statement
                    {
                    IDCON125=(Token)match(input,IDCON,FOLLOW_IDCON_in_assignment1115); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDCON.add(IDCON125);

                    pushFollow(FOLLOW_formals_in_assignment1117);
                    formals126=formals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_formals.add(formals126.getTree());
                    char_literal127=(Token)match(input,50,FOLLOW_50_in_assignment1119); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_50.add(char_literal127);

                    pushFollow(FOLLOW_statement_in_assignment1121);
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
                    // 144:5: -> ^( FUNCTION IDCON ^( FORMALS ( formals )? ) statement )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:144:8: ^( FUNCTION IDCON ^( FORMALS ( formals )? ) statement )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION, "FUNCTION"), root_1);

                        adaptor.addChild(root_1, stream_IDCON.nextNode());
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:144:26: ^( FORMALS ( formals )? )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(FORMALS, "FORMALS"), root_2);

                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:144:37: ( formals )?
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:149:1: predicate : ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )* ;
    public final WaebricParser.predicate_return predicate() throws RecognitionException {
        WaebricParser.predicate_return retval = new WaebricParser.predicate_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal129=null;
        Token char_literal133=null;
        Token string_literal135=null;
        Token string_literal137=null;
        WaebricParser.predicate_return predicate130 = null;

        WaebricParser.expression_return expression131 = null;

        WaebricParser.expression_return expression132 = null;

        WaebricParser.type_return type134 = null;

        WaebricParser.predicate_return predicate136 = null;

        WaebricParser.predicate_return predicate138 = null;


        Object char_literal129_tree=null;
        Object char_literal133_tree=null;
        Object string_literal135_tree=null;
        Object string_literal137_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:149:10: ( ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:149:13: ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:149:13: ( '!' predicate | expression | expression '.' type )
            int alt31=3;
            alt31 = dfa31.predict(input);
            switch (alt31) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:149:15: '!' predicate
                    {
                    char_literal129=(Token)match(input,64,FOLLOW_64_in_predicate1162); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal129_tree = (Object)adaptor.create(char_literal129);
                    adaptor.addChild(root_0, char_literal129_tree);
                    }
                    pushFollow(FOLLOW_predicate_in_predicate1164);
                    predicate130=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate130.getTree());

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:150:7: expression
                    {
                    pushFollow(FOLLOW_expression_in_predicate1173);
                    expression131=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression131.getTree());

                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:151:7: expression '.' type
                    {
                    pushFollow(FOLLOW_expression_in_predicate1182);
                    expression132=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression132.getTree());
                    char_literal133=(Token)match(input,40,FOLLOW_40_in_predicate1184); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal133_tree = (Object)adaptor.create(char_literal133);
                    adaptor.addChild(root_0, char_literal133_tree);
                    }
                    pushFollow(FOLLOW_type_in_predicate1186);
                    type134=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, type134.getTree());

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:152:6: ( '&&' predicate | '||' predicate )*
            loop32:
            do {
                int alt32=3;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==65) ) {
                    int LA32_2 = input.LA(2);

                    if ( (synpred55_Waebric()) ) {
                        alt32=1;
                    }


                }
                else if ( (LA32_0==66) ) {
                    int LA32_3 = input.LA(2);

                    if ( (synpred56_Waebric()) ) {
                        alt32=2;
                    }


                }


                switch (alt32) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:152:8: '&&' predicate
            	    {
            	    string_literal135=(Token)match(input,65,FOLLOW_65_in_predicate1196); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal135_tree = (Object)adaptor.create(string_literal135);
            	    adaptor.addChild(root_0, string_literal135_tree);
            	    }
            	    pushFollow(FOLLOW_predicate_in_predicate1198);
            	    predicate136=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate136.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:152:25: '||' predicate
            	    {
            	    string_literal137=(Token)match(input,66,FOLLOW_66_in_predicate1202); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal137_tree = (Object)adaptor.create(string_literal137);
            	    adaptor.addChild(root_0, string_literal137_tree);
            	    }
            	    pushFollow(FOLLOW_predicate_in_predicate1204);
            	    predicate138=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate138.getTree());

            	    }
            	    break;

            	default :
            	    break loop32;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:153:1: type : ( 'list' | 'record' | 'string' );
    public final WaebricParser.type_return type() throws RecognitionException {
        WaebricParser.type_return retval = new WaebricParser.type_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set139=null;

        Object set139_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:153:5: ( 'list' | 'record' | 'string' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:
            {
            root_0 = (Object)adaptor.nil();

            set139=(Token)input.LT(1);
            if ( (input.LA(1)>=67 && input.LA(1)<=69) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set139));
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:158:1: embedding : PRETEXT embed textTail ;
    public final WaebricParser.embedding_return embedding() throws RecognitionException {
        WaebricParser.embedding_return retval = new WaebricParser.embedding_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PRETEXT140=null;
        WaebricParser.embed_return embed141 = null;

        WaebricParser.textTail_return textTail142 = null;


        Object PRETEXT140_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:158:10: ( PRETEXT embed textTail )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:158:13: PRETEXT embed textTail
            {
            root_0 = (Object)adaptor.nil();

            PRETEXT140=(Token)match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding1237); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRETEXT140_tree = (Object)adaptor.create(PRETEXT140);
            adaptor.addChild(root_0, PRETEXT140_tree);
            }
            pushFollow(FOLLOW_embed_in_embedding1239);
            embed141=embed();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, embed141.getTree());
            pushFollow(FOLLOW_textTail_in_embedding1241);
            textTail142=textTail();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, textTail142.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:159:1: embed : ( ( markup )* expression | ( markup )* markup );
    public final WaebricParser.embed_return embed() throws RecognitionException {
        WaebricParser.embed_return retval = new WaebricParser.embed_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WaebricParser.markup_return markup143 = null;

        WaebricParser.expression_return expression144 = null;

        WaebricParser.markup_return markup145 = null;

        WaebricParser.markup_return markup146 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:159:6: ( ( markup )* expression | ( markup )* markup )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==IDCON) ) {
                int LA35_1 = input.LA(2);

                if ( (synpred60_Waebric()) ) {
                    alt35=1;
                }
                else if ( (true) ) {
                    alt35=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA35_0>=NATCON && LA35_0<=SYMBOLCON)||LA35_0==51||LA35_0==53) ) {
                alt35=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:159:10: ( markup )* expression
                    {
                    root_0 = (Object)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:159:10: ( markup )*
                    loop33:
                    do {
                        int alt33=2;
                        alt33 = dfa33.predict(input);
                        switch (alt33) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_embed1250);
                    	    markup143=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, markup143.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);

                    pushFollow(FOLLOW_expression_in_embed1253);
                    expression144=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression144.getTree());

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:159:31: ( markup )* markup
                    {
                    root_0 = (Object)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:159:31: ( markup )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==IDCON) ) {
                            int LA34_1 = input.LA(2);

                            if ( (synpred61_Waebric()) ) {
                                alt34=1;
                            }


                        }


                        switch (alt34) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_embed1257);
                    	    markup145=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, markup145.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);

                    pushFollow(FOLLOW_markup_in_embed1260);
                    markup146=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, markup146.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:160:1: textTail : ( POSTTEXT | MIDTEXT embed textTail );
    public final WaebricParser.textTail_return textTail() throws RecognitionException {
        WaebricParser.textTail_return retval = new WaebricParser.textTail_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token POSTTEXT147=null;
        Token MIDTEXT148=null;
        WaebricParser.embed_return embed149 = null;

        WaebricParser.textTail_return textTail150 = null;


        Object POSTTEXT147_tree=null;
        Object MIDTEXT148_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:160:9: ( POSTTEXT | MIDTEXT embed textTail )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==POSTTEXT) ) {
                alt36=1;
            }
            else if ( (LA36_0==MIDTEXT) ) {
                alt36=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:160:12: POSTTEXT
                    {
                    root_0 = (Object)adaptor.nil();

                    POSTTEXT147=(Token)match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail1268); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    POSTTEXT147_tree = (Object)adaptor.create(POSTTEXT147);
                    adaptor.addChild(root_0, POSTTEXT147_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:160:23: MIDTEXT embed textTail
                    {
                    root_0 = (Object)adaptor.nil();

                    MIDTEXT148=(Token)match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail1272); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MIDTEXT148_tree = (Object)adaptor.create(MIDTEXT148);
                    adaptor.addChild(root_0, MIDTEXT148_tree);
                    }
                    pushFollow(FOLLOW_embed_in_textTail1274);
                    embed149=embed();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, embed149.getTree());
                    pushFollow(FOLLOW_textTail_in_textTail1276);
                    textTail150=textTail();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, textTail150.getTree());

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
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:97:8: ( '+' expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:97:8: '+' expression
        {
        match(input,55,FOLLOW_55_in_synpred26_Waebric573); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred26_Waebric575);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_Waebric

    // $ANTLR start synpred27_Waebric
    public final void synpred27_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:97:35: ( '.' IDCON )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:97:35: '.' IDCON
        {
        match(input,40,FOLLOW_40_in_synpred27_Waebric581); if (state.failed) return ;
        match(input,IDCON,FOLLOW_IDCON_in_synpred27_Waebric583); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred27_Waebric

    // $ANTLR start synpred32_Waebric
    public final void synpred32_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:113:48: ( 'else' statement )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:113:48: 'else' statement
        {
        match(input,57,FOLLOW_57_in_synpred32_Waebric707); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred32_Waebric709);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_Waebric

    // $ANTLR start synpred46_Waebric
    public final void synpred46_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:130:6: ( ( markup )+ expression ';' )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:130:6: ( markup )+ expression ';'
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:130:6: ( markup )+
        int cnt45=0;
        loop45:
        do {
            int alt45=2;
            alt45 = dfa45.predict(input);
            switch (alt45) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred46_Waebric976);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt45 >= 1 ) break loop45;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(45, input);
                    throw eee;
            }
            cnt45++;
        } while (true);

        pushFollow(FOLLOW_expression_in_synpred46_Waebric979);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred46_Waebric981); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_Waebric

    // $ANTLR start synpred47_Waebric
    public final void synpred47_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:132:6: ( markup )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:132:6: markup
        {
        pushFollow(FOLLOW_markup_in_synpred47_Waebric1008);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred47_Waebric

    // $ANTLR start synpred48_Waebric
    public final void synpred48_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:132:6: ( ( markup )+ statement )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:132:6: ( markup )+ statement
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:132:6: ( markup )+
        int cnt46=0;
        loop46:
        do {
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==IDCON) ) {
                int LA46_2 = input.LA(2);

                if ( (synpred47_Waebric()) ) {
                    alt46=1;
                }


            }


            switch (alt46) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred48_Waebric1008);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt46 >= 1 ) break loop46;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(46, input);
                    throw eee;
            }
            cnt46++;
        } while (true);

        pushFollow(FOLLOW_statement_in_synpred48_Waebric1011);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred48_Waebric

    // $ANTLR start synpred50_Waebric
    public final void synpred50_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:134:6: ( ( markup )+ embedding ';' )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:134:6: ( markup )+ embedding ';'
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:134:6: ( markup )+
        int cnt47=0;
        loop47:
        do {
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==IDCON) ) {
                alt47=1;
            }


            switch (alt47) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred50_Waebric1036);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt47 >= 1 ) break loop47;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(47, input);
                    throw eee;
            }
            cnt47++;
        } while (true);

        pushFollow(FOLLOW_embedding_in_synpred50_Waebric1039);
        embedding();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred50_Waebric1041); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred50_Waebric

    // $ANTLR start synpred54_Waebric
    public final void synpred54_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:150:7: ( expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:150:7: expression
        {
        pushFollow(FOLLOW_expression_in_synpred54_Waebric1173);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred54_Waebric

    // $ANTLR start synpred55_Waebric
    public final void synpred55_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:152:8: ( '&&' predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:152:8: '&&' predicate
        {
        match(input,65,FOLLOW_65_in_synpred55_Waebric1196); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred55_Waebric1198);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred55_Waebric

    // $ANTLR start synpred56_Waebric
    public final void synpred56_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:152:25: ( '||' predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:152:25: '||' predicate
        {
        match(input,66,FOLLOW_66_in_synpred56_Waebric1202); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred56_Waebric1204);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred56_Waebric

    // $ANTLR start synpred60_Waebric
    public final void synpred60_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:159:10: ( ( markup )* expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:159:10: ( markup )* expression
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:159:10: ( markup )*
        loop48:
        do {
            int alt48=2;
            alt48 = dfa48.predict(input);
            switch (alt48) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred60_Waebric1250);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop48;
            }
        } while (true);

        pushFollow(FOLLOW_expression_in_synpred60_Waebric1253);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred60_Waebric

    // $ANTLR start synpred61_Waebric
    public final void synpred61_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:159:31: ( markup )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:159:31: markup
        {
        pushFollow(FOLLOW_markup_in_synpred61_Waebric1257);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred61_Waebric

    // Delegated rules

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


    protected DFA29 dfa29 = new DFA29(this);
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA31 dfa31 = new DFA31(this);
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA45 dfa45 = new DFA45(this);
    protected DFA48 dfa48 = new DFA48(this);
    static final String DFA29_eotS =
        "\20\uffff";
    static final String DFA29_eofS =
        "\20\uffff";
    static final String DFA29_minS =
        "\1\12\5\uffff\1\12\2\uffff\1\0\6\uffff";
    static final String DFA29_maxS =
        "\1\77\5\uffff\1\65\2\uffff\1\0\6\uffff";
    static final String DFA29_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\11\1\uffff\1\6\1\7\1"+
        "\12\1\13\1\14\1\15";
    static final String DFA29_specialS =
        "\11\uffff\1\0\6\uffff}>";
    static final String[] DFA29_transitionS = {
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
            "\1\uffff",
            "",
            "",
            "",
            "",
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
            return "113:1: statement : ( 'if' '(' predicate ')' statement ( 'else' statement )? -> ^( 'if' '(' predicate ')' statement ( 'else' statement )? ) | 'each' '(' IDCON ':' expression ')' statement -> ^( 'each' '(' IDCON ':' expression ')' statement ) | 'let' ( assignment )+ 'in' ( statement )* 'end' -> ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | '{' ( statement )* '}' -> ^( '{' ( statement )* '}' ) | 'comment' STRCON ';' -> ^( 'comment' STRCON ';' ) | 'echo' expression ';' -> ^( 'echo' expression ';' ) | 'echo' embedding ';' -> ^( 'echo' embedding ';' ) | 'cdata' expression ';' -> ^( 'cdata' expression ';' ) | 'yield;' | ( markup )+ expression ';' -> ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ( markup )+ statement -> ^( MARKUP_STATEMENT ( markup )+ statement ) | ( markup )+ embedding ';' -> ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) | ( markup )+ ';' -> ^( MARKUP_STATEMENT ( markup )+ ';' ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA29_9 = input.LA(1);

                         
                        int index29_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred46_Waebric()) ) {s = 12;}

                        else if ( (synpred48_Waebric()) ) {s = 13;}

                        else if ( (synpred50_Waebric()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index29_9);
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
    static final String DFA25_eotS =
        "\6\uffff";
    static final String DFA25_eofS =
        "\6\uffff";
    static final String DFA25_minS =
        "\2\12\1\uffff\1\12\1\uffff\1\12";
    static final String DFA25_maxS =
        "\1\65\1\67\1\uffff\1\12\1\uffff\1\67";
    static final String DFA25_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String DFA25_specialS =
        "\6\uffff}>";
    static final String[] DFA25_transitionS = {
            "\1\1\1\uffff\3\2\44\uffff\1\2\1\uffff\1\2",
            "\1\4\1\uffff\3\4\7\uffff\1\2\21\uffff\1\3\1\uffff\4\4\1\uffff"+
            "\1\4\3\uffff\1\4\1\uffff\1\4\1\uffff\1\2",
            "",
            "\1\5",
            "",
            "\1\4\1\uffff\3\4\7\uffff\1\2\21\uffff\1\3\1\uffff\4\4\1\uffff"+
            "\1\4\3\uffff\1\4\1\uffff\1\4\1\uffff\1\2"
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
            return "()+ loopback of 130:6: ( markup )+";
        }
    }
    static final String DFA31_eotS =
        "\12\uffff";
    static final String DFA31_eofS =
        "\12\uffff";
    static final String DFA31_minS =
        "\1\12\1\uffff\6\0\2\uffff";
    static final String DFA31_maxS =
        "\1\100\1\uffff\6\0\2\uffff";
    static final String DFA31_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\1\3";
    static final String DFA31_specialS =
        "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\2\uffff}>";
    static final String[] DFA31_transitionS = {
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
            return "149:13: ( '!' predicate | expression | expression '.' type )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA31_2 = input.LA(1);

                         
                        int index31_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_Waebric()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index31_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA31_3 = input.LA(1);

                         
                        int index31_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_Waebric()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index31_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA31_4 = input.LA(1);

                         
                        int index31_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_Waebric()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index31_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA31_5 = input.LA(1);

                         
                        int index31_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_Waebric()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index31_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA31_6 = input.LA(1);

                         
                        int index31_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_Waebric()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index31_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA31_7 = input.LA(1);

                         
                        int index31_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_Waebric()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index31_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 31, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA33_eotS =
        "\6\uffff";
    static final String DFA33_eofS =
        "\6\uffff";
    static final String DFA33_minS =
        "\2\12\2\uffff\2\12";
    static final String DFA33_maxS =
        "\1\65\1\67\2\uffff\1\12\1\67";
    static final String DFA33_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA33_specialS =
        "\6\uffff}>";
    static final String[] DFA33_transitionS = {
            "\1\1\1\uffff\3\2\44\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\2\uffff\2\2\25\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\3\uffff\1\3\1\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\2\uffff\2\2\25\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\3\uffff\1\3\1\uffff\1\3\1\uffff\1\2"
    };

    static final short[] DFA33_eot = DFA.unpackEncodedString(DFA33_eotS);
    static final short[] DFA33_eof = DFA.unpackEncodedString(DFA33_eofS);
    static final char[] DFA33_min = DFA.unpackEncodedStringToUnsignedChars(DFA33_minS);
    static final char[] DFA33_max = DFA.unpackEncodedStringToUnsignedChars(DFA33_maxS);
    static final short[] DFA33_accept = DFA.unpackEncodedString(DFA33_acceptS);
    static final short[] DFA33_special = DFA.unpackEncodedString(DFA33_specialS);
    static final short[][] DFA33_transition;

    static {
        int numStates = DFA33_transitionS.length;
        DFA33_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA33_transition[i] = DFA.unpackEncodedString(DFA33_transitionS[i]);
        }
    }

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = DFA33_eot;
            this.eof = DFA33_eof;
            this.min = DFA33_min;
            this.max = DFA33_max;
            this.accept = DFA33_accept;
            this.special = DFA33_special;
            this.transition = DFA33_transition;
        }
        public String getDescription() {
            return "()* loopback of 159:10: ( markup )*";
        }
    }
    static final String DFA45_eotS =
        "\6\uffff";
    static final String DFA45_eofS =
        "\6\uffff";
    static final String DFA45_minS =
        "\2\12\2\uffff\2\12";
    static final String DFA45_maxS =
        "\1\65\1\67\2\uffff\1\12\1\67";
    static final String DFA45_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA45_specialS =
        "\6\uffff}>";
    static final String[] DFA45_transitionS = {
            "\1\1\1\uffff\3\2\44\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\7\uffff\1\2\21\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\3\uffff\1\3\1\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\7\uffff\1\2\21\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\3\uffff\1\3\1\uffff\1\3\1\uffff\1\2"
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
            return "()+ loopback of 130:6: ( markup )+";
        }
    }
    static final String DFA48_eotS =
        "\6\uffff";
    static final String DFA48_eofS =
        "\1\uffff\1\2\3\uffff\1\2";
    static final String DFA48_minS =
        "\2\12\2\uffff\2\12";
    static final String DFA48_maxS =
        "\1\65\1\67\2\uffff\1\12\1\67";
    static final String DFA48_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA48_specialS =
        "\6\uffff}>";
    static final String[] DFA48_transitionS = {
            "\1\1\1\uffff\3\2\44\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\31\uffff\1\4\1\uffff\4\3\1\uffff\1\3\3\uffff"+
            "\1\3\1\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\31\uffff\1\4\1\uffff\4\3\1\uffff\1\3\3\uffff"+
            "\1\3\1\uffff\1\3\1\uffff\1\2"
    };

    static final short[] DFA48_eot = DFA.unpackEncodedString(DFA48_eotS);
    static final short[] DFA48_eof = DFA.unpackEncodedString(DFA48_eofS);
    static final char[] DFA48_min = DFA.unpackEncodedStringToUnsignedChars(DFA48_minS);
    static final char[] DFA48_max = DFA.unpackEncodedStringToUnsignedChars(DFA48_maxS);
    static final short[] DFA48_accept = DFA.unpackEncodedString(DFA48_acceptS);
    static final short[] DFA48_special = DFA.unpackEncodedString(DFA48_specialS);
    static final short[][] DFA48_transition;

    static {
        int numStates = DFA48_transitionS.length;
        DFA48_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA48_transition[i] = DFA.unpackEncodedString(DFA48_transitionS[i]);
        }
    }

    class DFA48 extends DFA {

        public DFA48(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 48;
            this.eot = DFA48_eot;
            this.eof = DFA48_eof;
            this.min = DFA48_min;
            this.max = DFA48_max;
            this.accept = DFA48_accept;
            this.special = DFA48_special;
            this.transition = DFA48_transition;
        }
        public String getDescription() {
            return "()* loopback of 159:10: ( markup )*";
        }
    }
 

    public static final BitSet FOLLOW_39_in_module125 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_moduleId_in_module127 = new BitSet(new long[]{0x0000020000100202L});
    public static final BitSet FOLLOW_imprt_in_module131 = new BitSet(new long[]{0x0000020000100202L});
    public static final BitSet FOLLOW_site_in_module135 = new BitSet(new long[]{0x0000020000100202L});
    public static final BitSet FOLLOW_function_in_module139 = new BitSet(new long[]{0x0000020000100202L});
    public static final BitSet FOLLOW_IDCON_in_moduleId193 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_moduleId203 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_moduleId207 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_41_in_imprt223 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_moduleId_in_imprt225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SITE_in_site254 = new BitSet(new long[]{0x0000000000600800L});
    public static final BitSet FOLLOW_mappings_in_site256 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_END_in_site258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapping_in_mappings266 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_SEMICOLON_in_mappings271 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_mapping_in_mappings273 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_PATH_in_mapping285 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_mapping287 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_markup_in_mapping289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_markup302 = new BitSet(new long[]{0x0000BD0000000000L});
    public static final BitSet FOLLOW_attributes_in_markup304 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_arguments_in_markup306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attribute_in_attributes337 = new BitSet(new long[]{0x00003D0000000002L});
    public static final BitSet FOLLOW_43_in_attribute363 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_attribute365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_attribute373 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_attribute375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_attribute383 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_attribute385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_attribute393 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_attribute395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_attribute403 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_NATCON_in_attribute405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_attribute413 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_NATCON_in_attribute415 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_attribute417 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_NATCON_in_attribute419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_arguments433 = new BitSet(new long[]{0x002B000000007400L});
    public static final BitSet FOLLOW_argument_in_arguments435 = new BitSet(new long[]{0x0003000000000000L});
    public static final BitSet FOLLOW_48_in_arguments440 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_argument_in_arguments442 = new BitSet(new long[]{0x0003000000000000L});
    public static final BitSet FOLLOW_49_in_arguments447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_argument478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_argument486 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_argument488 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_argument490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_expression505 = new BitSet(new long[]{0x0080010000000002L});
    public static final BitSet FOLLOW_NATCON_in_expression509 = new BitSet(new long[]{0x0080010000000002L});
    public static final BitSet FOLLOW_TEXT_in_expression513 = new BitSet(new long[]{0x0080010000000002L});
    public static final BitSet FOLLOW_SYMBOLCON_in_expression517 = new BitSet(new long[]{0x0080010000000002L});
    public static final BitSet FOLLOW_51_in_expression526 = new BitSet(new long[]{0x0039000000007400L});
    public static final BitSet FOLLOW_expression_in_expression528 = new BitSet(new long[]{0x0011000000000000L});
    public static final BitSet FOLLOW_48_in_expression533 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_expression535 = new BitSet(new long[]{0x0011000000000000L});
    public static final BitSet FOLLOW_52_in_expression540 = new BitSet(new long[]{0x0080010000000002L});
    public static final BitSet FOLLOW_53_in_expression549 = new BitSet(new long[]{0x0041000000000400L});
    public static final BitSet FOLLOW_keyValuePair_in_expression551 = new BitSet(new long[]{0x0041000000000000L});
    public static final BitSet FOLLOW_48_in_expression556 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_keyValuePair_in_expression558 = new BitSet(new long[]{0x0041000000000000L});
    public static final BitSet FOLLOW_54_in_expression563 = new BitSet(new long[]{0x0080010000000002L});
    public static final BitSet FOLLOW_55_in_expression573 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_expression575 = new BitSet(new long[]{0x0080010000000002L});
    public static final BitSet FOLLOW_40_in_expression581 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_expression583 = new BitSet(new long[]{0x0080010000000002L});
    public static final BitSet FOLLOW_IDCON_in_keyValuePair596 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_keyValuePair598 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_keyValuePair600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_function612 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_function614 = new BitSet(new long[]{0xED20800000280400L});
    public static final BitSet FOLLOW_formals_in_function616 = new BitSet(new long[]{0xED20000000280400L});
    public static final BitSet FOLLOW_statement_in_function619 = new BitSet(new long[]{0xED20000000280400L});
    public static final BitSet FOLLOW_END_in_function622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_formals659 = new BitSet(new long[]{0x0003000000000400L});
    public static final BitSet FOLLOW_IDCON_in_formals661 = new BitSet(new long[]{0x0003000000000000L});
    public static final BitSet FOLLOW_48_in_formals666 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_formals668 = new BitSet(new long[]{0x0003000000000000L});
    public static final BitSet FOLLOW_49_in_formals673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_statement695 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_statement697 = new BitSet(new long[]{0x0028000000007400L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_statement699 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_statement701 = new BitSet(new long[]{0xED20000000080400L});
    public static final BitSet FOLLOW_statement_in_statement703 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_57_in_statement707 = new BitSet(new long[]{0xED20000000080400L});
    public static final BitSet FOLLOW_statement_in_statement709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_statement748 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_statement750 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_statement752 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_statement754 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_statement756 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_statement758 = new BitSet(new long[]{0xED20000000080400L});
    public static final BitSet FOLLOW_statement_in_statement760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_statement792 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_assignment_in_statement794 = new BitSet(new long[]{0x1000000000000400L});
    public static final BitSet FOLLOW_60_in_statement797 = new BitSet(new long[]{0xED20000000280400L});
    public static final BitSet FOLLOW_statement_in_statement799 = new BitSet(new long[]{0xED20000000280400L});
    public static final BitSet FOLLOW_END_in_statement802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_statement831 = new BitSet(new long[]{0xED60000000080400L});
    public static final BitSet FOLLOW_statement_in_statement833 = new BitSet(new long[]{0xED60000000080400L});
    public static final BitSet FOLLOW_54_in_statement836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMENT_in_statement860 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_STRCON_in_statement862 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_statement887 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_statement889 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_statement914 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_embedding_in_statement916 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_statement941 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_statement943 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_statement969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement976 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_statement979 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement1008 = new BitSet(new long[]{0xED20000000080400L});
    public static final BitSet FOLLOW_statement_in_statement1011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement1036 = new BitSet(new long[]{0x0000000000010400L});
    public static final BitSet FOLLOW_embedding_in_statement1039 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement1041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement1068 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement1071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_assignment1101 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_assignment1103 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_assignment1105 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_assignment1107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_assignment1115 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_formals_in_assignment1117 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_assignment1119 = new BitSet(new long[]{0xED20000000080400L});
    public static final BitSet FOLLOW_statement_in_assignment1121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_predicate1162 = new BitSet(new long[]{0x0028000000007400L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_predicate1164 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000006L});
    public static final BitSet FOLLOW_expression_in_predicate1173 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000006L});
    public static final BitSet FOLLOW_expression_in_predicate1182 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_predicate1184 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000038L});
    public static final BitSet FOLLOW_type_in_predicate1186 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000006L});
    public static final BitSet FOLLOW_65_in_predicate1196 = new BitSet(new long[]{0x0028000000007400L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_predicate1198 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000006L});
    public static final BitSet FOLLOW_66_in_predicate1202 = new BitSet(new long[]{0x0028000000007400L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_predicate1204 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000006L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding1237 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_embed_in_embedding1239 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_textTail_in_embedding1241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed1250 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_embed1253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed1257 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_markup_in_embed1260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail1268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail1272 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_embed_in_textTail1274 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_textTail_in_textTail1276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_synpred26_Waebric573 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_synpred26_Waebric575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_synpred27_Waebric581 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_synpred27_Waebric583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_synpred32_Waebric707 = new BitSet(new long[]{0xED20000000080400L});
    public static final BitSet FOLLOW_statement_in_synpred32_Waebric709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred46_Waebric976 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_synpred46_Waebric979 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred46_Waebric981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred47_Waebric1008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred48_Waebric1008 = new BitSet(new long[]{0xED20000000080400L});
    public static final BitSet FOLLOW_statement_in_synpred48_Waebric1011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred50_Waebric1036 = new BitSet(new long[]{0x0000000000010400L});
    public static final BitSet FOLLOW_embedding_in_synpred50_Waebric1039 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred50_Waebric1041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred54_Waebric1173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_synpred55_Waebric1196 = new BitSet(new long[]{0x0028000000007400L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_synpred55_Waebric1198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_synpred56_Waebric1202 = new BitSet(new long[]{0x0028000000007400L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_synpred56_Waebric1204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred60_Waebric1250 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_synpred60_Waebric1253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred61_Waebric1257 = new BitSet(new long[]{0x0000000000000002L});

}