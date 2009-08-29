// $ANTLR 3.1.2 /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g 2009-08-29 15:56:06

	package org.cwi.waebric;
	import java.util.ArrayList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class WaebricTestParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATTRIBUTES", "ARGUMENTS", "ARGUMENT", "MARKUP", "MARKUP_STATEMENT", "FORMALS", "IDCON", "PATH", "NATCON", "TEXT", "SYMBOLCON", "STRCON", "PRETEXT", "POSTTEXT", "MIDTEXT", "SITE", "END", "COMMENT", "SEMICOLON", "DIGIT", "LETTER", "SYMBOLCHAR", "HEXADECIMAL", "PATHELEMENT", "FILEEXT", "STRCHAR", "ESCLAYOUT", "DECIMAL", "TEXTCHAR", "ESCQUOTE", "AMP", "CHARREF", "ENTREF", "COMMENTS", "LAYOUT", "'module'", "'.'", "'import'", "':'", "'def'", "'('", "','", "')'", "'#'", "'$'", "'@'", "'%'", "'='", "'['", "']'", "'{'", "'}'", "'+'", "'if'", "'else'", "'each'", "'let'", "'in'", "'yield'", "'echo'", "'cdata'", "'!'", "'?'", "'&&'", "'||'", "'list'", "'record'", "'string'"
    };
    public static final int ESCLAYOUT=30;
    public static final int T__42=42;
    public static final int END=20;
    public static final int T__57=57;
    public static final int FILEEXT=28;
    public static final int T__51=51;
    public static final int T__47=47;
    public static final int T__69=69;
    public static final int STRCHAR=29;
    public static final int T__50=50;
    public static final int T__65=65;
    public static final int SYMBOLCON=14;
    public static final int COMMENTS=37;
    public static final int DECIMAL=31;
    public static final int IDCON=10;
    public static final int T__70=70;
    public static final int T__67=67;
    public static final int HEXADECIMAL=26;
    public static final int T__39=39;
    public static final int TEXTCHAR=32;
    public static final int T__52=52;
    public static final int T__46=46;
    public static final int T__68=68;
    public static final int T__62=62;
    public static final int MARKUP=7;
    public static final int STRCON=15;
    public static final int T__49=49;
    public static final int AMP=34;
    public static final int T__61=61;
    public static final int POSTTEXT=17;
    public static final int T__59=59;
    public static final int ATTRIBUTES=4;
    public static final int DIGIT=23;
    public static final int T__54=54;
    public static final int T__48=48;
    public static final int LAYOUT=38;
    public static final int ESCQUOTE=33;
    public static final int PATHELEMENT=27;
    public static final int T__56=56;
    public static final int ENTREF=36;
    public static final int LETTER=24;
    public static final int ARGUMENTS=5;
    public static final int SITE=19;
    public static final int T__58=58;
    public static final int T__64=64;
    public static final int T__44=44;
    public static final int SYMBOLCHAR=25;
    public static final int T__66=66;
    public static final int COMMENT=21;
    public static final int MARKUP_STATEMENT=8;
    public static final int FORMALS=9;
    public static final int ARGUMENT=6;
    public static final int T__45=45;
    public static final int T__55=55;
    public static final int CHARREF=35;
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
    public static final int T__71=71;
    public static final int PATH=11;

    // delegates
    // delegators


        public WaebricTestParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public WaebricTestParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return WaebricTestParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g"; }


    	/**
    	 * Parsed modules
    	 */
    	private ArrayList<String> modules = new ArrayList<String>();

    	public WaebricTestParser(TokenStream input, ArrayList<String> modules) {
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
    			WaebricTestLexer lexer = new WaebricTestLexer(is);
    			CommonTokenStream tokens = new CommonTokenStream(lexer);
          			WaebricTestParser parser = new WaebricTestParser(tokens, modules);
          			return (CommonTree) parser.module().getTree();
          		} catch(java.io.IOException e) { return new CommonTree(); }
    	}


    public static class module_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "module"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:59:1: module : 'module' moduleId ( imprt | site | function )* -> ^( 'module' moduleId ( imprt )* ( site )* ( function )* ) ;
    public final WaebricTestParser.module_return module() throws RecognitionException {
        WaebricTestParser.module_return retval = new WaebricTestParser.module_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal1=null;
        WaebricTestParser.moduleId_return moduleId2 = null;

        WaebricTestParser.imprt_return imprt3 = null;

        WaebricTestParser.site_return site4 = null;

        WaebricTestParser.function_return function5 = null;


        Object string_literal1_tree=null;
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleSubtreeStream stream_imprt=new RewriteRuleSubtreeStream(adaptor,"rule imprt");
        RewriteRuleSubtreeStream stream_site=new RewriteRuleSubtreeStream(adaptor,"rule site");
        RewriteRuleSubtreeStream stream_moduleId=new RewriteRuleSubtreeStream(adaptor,"rule moduleId");
        RewriteRuleSubtreeStream stream_function=new RewriteRuleSubtreeStream(adaptor,"rule function");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:59:7: ( 'module' moduleId ( imprt | site | function )* -> ^( 'module' moduleId ( imprt )* ( site )* ( function )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:59:11: 'module' moduleId ( imprt | site | function )*
            {
            string_literal1=(Token)match(input,39,FOLLOW_39_in_module117); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_39.add(string_literal1);

            pushFollow(FOLLOW_moduleId_in_module119);
            moduleId2=moduleId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_moduleId.add(moduleId2.getTree());
            if ( state.backtracking==0 ) {
               modules.add((moduleId2!=null?moduleId2.path:null)); 
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:59:62: ( imprt | site | function )*
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
                case 43:
                    {
                    alt1=3;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:59:64: imprt
            	    {
            	    pushFollow(FOLLOW_imprt_in_module125);
            	    imprt3=imprt();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_imprt.add(imprt3.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:59:72: site
            	    {
            	    pushFollow(FOLLOW_site_in_module129);
            	    site4=site();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_site.add(site4.getTree());

            	    }
            	    break;
            	case 3 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:59:79: function
            	    {
            	    pushFollow(FOLLOW_function_in_module133);
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
            // elements: moduleId, 39, function, site, imprt
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 60:5: -> ^( 'module' moduleId ( imprt )* ( site )* ( function )* )
            {
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:60:8: ^( 'module' moduleId ( imprt )* ( site )* ( function )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_39.nextNode(), root_1);

                adaptor.addChild(root_1, stream_moduleId.nextTree());
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:60:29: ( imprt )*
                while ( stream_imprt.hasNext() ) {
                    adaptor.addChild(root_1, stream_imprt.nextTree());

                }
                stream_imprt.reset();
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:60:36: ( site )*
                while ( stream_site.hasNext() ) {
                    adaptor.addChild(root_1, stream_site.nextTree());

                }
                stream_site.reset();
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:60:42: ( function )*
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:62:1: moduleId returns [String path = \"\"] : e= IDCON ( '.' e= IDCON )* ;
    public final WaebricTestParser.moduleId_return moduleId() throws RecognitionException {
        WaebricTestParser.moduleId_return retval = new WaebricTestParser.moduleId_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token e=null;
        Token char_literal6=null;

        Object e_tree=null;
        Object char_literal6_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:65:2: (e= IDCON ( '.' e= IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:65:5: e= IDCON ( '.' e= IDCON )*
            {
            root_0 = (Object)adaptor.nil();

            e=(Token)match(input,IDCON,FOLLOW_IDCON_in_moduleId184); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            e_tree = (Object)adaptor.create(e);
            adaptor.addChild(root_0, e_tree);
            }
            if ( state.backtracking==0 ) {
               retval.path += e.getText(); 
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:66:4: ( '.' e= IDCON )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==40) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:66:6: '.' e= IDCON
            	    {
            	    char_literal6=(Token)match(input,40,FOLLOW_40_in_moduleId194); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal6_tree = (Object)adaptor.create(char_literal6);
            	    adaptor.addChild(root_0, char_literal6_tree);
            	    }
            	    e=(Token)match(input,IDCON,FOLLOW_IDCON_in_moduleId198); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:68:1: imprt : 'import' moduleId -> 'import' moduleId ^() ;
    public final WaebricTestParser.imprt_return imprt() throws RecognitionException {
        WaebricTestParser.imprt_return retval = new WaebricTestParser.imprt_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal7=null;
        WaebricTestParser.moduleId_return moduleId8 = null;


        Object string_literal7_tree=null;
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleSubtreeStream stream_moduleId=new RewriteRuleSubtreeStream(adaptor,"rule moduleId");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:68:6: ( 'import' moduleId -> 'import' moduleId ^() )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:68:10: 'import' moduleId
            {
            string_literal7=(Token)match(input,41,FOLLOW_41_in_imprt214); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_41.add(string_literal7);

            pushFollow(FOLLOW_moduleId_in_imprt216);
            moduleId8=moduleId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_moduleId.add(moduleId8.getTree());
            if ( state.backtracking==0 ) {
               if(modules.contains((moduleId8!=null?moduleId8.path:null))) { return retval; } 
            }


            // AST REWRITE
            // elements: 41, moduleId
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 69:5: -> 'import' moduleId ^()
            {
                adaptor.addChild(root_0, stream_41.nextNode());
                adaptor.addChild(root_0, stream_moduleId.nextTree());
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:69:26: ^()
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:71:1: site : 'site' mappings 'end' ;
    public final WaebricTestParser.site_return site() throws RecognitionException {
        WaebricTestParser.site_return retval = new WaebricTestParser.site_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal9=null;
        Token string_literal11=null;
        WaebricTestParser.mappings_return mappings10 = null;


        Object string_literal9_tree=null;
        Object string_literal11_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:71:5: ( 'site' mappings 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:71:9: 'site' mappings 'end'
            {
            root_0 = (Object)adaptor.nil();

            string_literal9=(Token)match(input,SITE,FOLLOW_SITE_in_site245); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal9_tree = (Object)adaptor.create(string_literal9);
            adaptor.addChild(root_0, string_literal9_tree);
            }
            pushFollow(FOLLOW_mappings_in_site247);
            mappings10=mappings();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mappings10.getTree());
            string_literal11=(Token)match(input,END,FOLLOW_END_in_site249); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:73:1: mappings : ( mapping )? ( ';' mapping )* ;
    public final WaebricTestParser.mappings_return mappings() throws RecognitionException {
        WaebricTestParser.mappings_return retval = new WaebricTestParser.mappings_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal13=null;
        WaebricTestParser.mapping_return mapping12 = null;

        WaebricTestParser.mapping_return mapping14 = null;


        Object char_literal13_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:73:9: ( ( mapping )? ( ';' mapping )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:73:12: ( mapping )? ( ';' mapping )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:73:12: ( mapping )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==PATH) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:73:12: mapping
                    {
                    pushFollow(FOLLOW_mapping_in_mappings258);
                    mapping12=mapping();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, mapping12.getTree());

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:73:21: ( ';' mapping )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==SEMICOLON) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:73:23: ';' mapping
            	    {
            	    char_literal13=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_mappings263); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal13_tree = (Object)adaptor.create(char_literal13);
            	    adaptor.addChild(root_0, char_literal13_tree);
            	    }
            	    pushFollow(FOLLOW_mapping_in_mappings265);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:75:1: mapping : PATH ':' markup ;
    public final WaebricTestParser.mapping_return mapping() throws RecognitionException {
        WaebricTestParser.mapping_return retval = new WaebricTestParser.mapping_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PATH15=null;
        Token char_literal16=null;
        WaebricTestParser.markup_return markup17 = null;


        Object PATH15_tree=null;
        Object char_literal16_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:75:9: ( PATH ':' markup )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:75:12: PATH ':' markup
            {
            root_0 = (Object)adaptor.nil();

            PATH15=(Token)match(input,PATH,FOLLOW_PATH_in_mapping278); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PATH15_tree = (Object)adaptor.create(PATH15);
            adaptor.addChild(root_0, PATH15_tree);
            }
            char_literal16=(Token)match(input,42,FOLLOW_42_in_mapping280); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal16_tree = (Object)adaptor.create(char_literal16);
            adaptor.addChild(root_0, char_literal16_tree);
            }
            pushFollow(FOLLOW_markup_in_mapping282);
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

    public static class function_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:77:1: function : 'def' IDCON ( formals )? ( statement )* 'end' -> ^( 'def' IDCON ^( FORMALS ( formals )? ) ( statement )* ) ;
    public final WaebricTestParser.function_return function() throws RecognitionException {
        WaebricTestParser.function_return retval = new WaebricTestParser.function_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal18=null;
        Token IDCON19=null;
        Token string_literal22=null;
        WaebricTestParser.formals_return formals20 = null;

        WaebricTestParser.statement_return statement21 = null;


        Object string_literal18_tree=null;
        Object IDCON19_tree=null;
        Object string_literal22_tree=null;
        RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
        RewriteRuleTokenStream stream_END=new RewriteRuleTokenStream(adaptor,"token END");
        RewriteRuleTokenStream stream_IDCON=new RewriteRuleTokenStream(adaptor,"token IDCON");
        RewriteRuleSubtreeStream stream_formals=new RewriteRuleSubtreeStream(adaptor,"rule formals");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:77:9: ( 'def' IDCON ( formals )? ( statement )* 'end' -> ^( 'def' IDCON ^( FORMALS ( formals )? ) ( statement )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:77:12: 'def' IDCON ( formals )? ( statement )* 'end'
            {
            string_literal18=(Token)match(input,43,FOLLOW_43_in_function291); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_43.add(string_literal18);

            IDCON19=(Token)match(input,IDCON,FOLLOW_IDCON_in_function293); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDCON.add(IDCON19);

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:77:24: ( formals )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==44) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:77:24: formals
                    {
                    pushFollow(FOLLOW_formals_in_function295);
                    formals20=formals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_formals.add(formals20.getTree());

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:77:33: ( statement )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==IDCON||LA6_0==COMMENT||LA6_0==54||LA6_0==57||(LA6_0>=59 && LA6_0<=60)||(LA6_0>=62 && LA6_0<=64)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:77:33: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_function298);
            	    statement21=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statement.add(statement21.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            string_literal22=(Token)match(input,END,FOLLOW_END_in_function301); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_END.add(string_literal22);



            // AST REWRITE
            // elements: 43, formals, IDCON, statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 78:5: -> ^( 'def' IDCON ^( FORMALS ( formals )? ) ( statement )* )
            {
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:78:8: ^( 'def' IDCON ^( FORMALS ( formals )? ) ( statement )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_43.nextNode(), root_1);

                adaptor.addChild(root_1, stream_IDCON.nextNode());
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:78:23: ^( FORMALS ( formals )? )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(FORMALS, "FORMALS"), root_2);

                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:78:34: ( formals )?
                if ( stream_formals.hasNext() ) {
                    adaptor.addChild(root_2, stream_formals.nextTree());

                }
                stream_formals.reset();

                adaptor.addChild(root_1, root_2);
                }
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:78:45: ( statement )*
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:80:1: formals : '(' ( IDCON )? ( ',' IDCON )* ')' -> ( IDCON )* ;
    public final WaebricTestParser.formals_return formals() throws RecognitionException {
        WaebricTestParser.formals_return retval = new WaebricTestParser.formals_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal23=null;
        Token IDCON24=null;
        Token char_literal25=null;
        Token IDCON26=null;
        Token char_literal27=null;

        Object char_literal23_tree=null;
        Object IDCON24_tree=null;
        Object char_literal25_tree=null;
        Object IDCON26_tree=null;
        Object char_literal27_tree=null;
        RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
        RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
        RewriteRuleTokenStream stream_IDCON=new RewriteRuleTokenStream(adaptor,"token IDCON");
        RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:80:8: ( '(' ( IDCON )? ( ',' IDCON )* ')' -> ( IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:80:11: '(' ( IDCON )? ( ',' IDCON )* ')'
            {
            char_literal23=(Token)match(input,44,FOLLOW_44_in_formals340); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_44.add(char_literal23);

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:80:15: ( IDCON )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==IDCON) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:80:15: IDCON
                    {
                    IDCON24=(Token)match(input,IDCON,FOLLOW_IDCON_in_formals342); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDCON.add(IDCON24);


                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:80:22: ( ',' IDCON )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==45) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:80:24: ',' IDCON
            	    {
            	    char_literal25=(Token)match(input,45,FOLLOW_45_in_formals347); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_45.add(char_literal25);

            	    IDCON26=(Token)match(input,IDCON,FOLLOW_IDCON_in_formals349); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_IDCON.add(IDCON26);


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            char_literal27=(Token)match(input,46,FOLLOW_46_in_formals354); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_46.add(char_literal27);



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
            // 81:5: -> ( IDCON )*
            {
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:81:8: ( IDCON )*
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

    public static class markup_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "markup"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:83:1: markup : IDCON attributes ( arguments )? -> ^( MARKUP IDCON attributes ( arguments )? ) ;
    public final WaebricTestParser.markup_return markup() throws RecognitionException {
        WaebricTestParser.markup_return retval = new WaebricTestParser.markup_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDCON28=null;
        WaebricTestParser.attributes_return attributes29 = null;

        WaebricTestParser.arguments_return arguments30 = null;


        Object IDCON28_tree=null;
        RewriteRuleTokenStream stream_IDCON=new RewriteRuleTokenStream(adaptor,"token IDCON");
        RewriteRuleSubtreeStream stream_arguments=new RewriteRuleSubtreeStream(adaptor,"rule arguments");
        RewriteRuleSubtreeStream stream_attributes=new RewriteRuleSubtreeStream(adaptor,"rule attributes");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:83:7: ( IDCON attributes ( arguments )? -> ^( MARKUP IDCON attributes ( arguments )? ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:83:11: IDCON attributes ( arguments )?
            {
            IDCON28=(Token)match(input,IDCON,FOLLOW_IDCON_in_markup373); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDCON.add(IDCON28);

            pushFollow(FOLLOW_attributes_in_markup375);
            attributes29=attributes();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_attributes.add(attributes29.getTree());
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:83:28: ( arguments )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==44) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:83:28: arguments
                    {
                    pushFollow(FOLLOW_arguments_in_markup377);
                    arguments30=arguments();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_arguments.add(arguments30.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: attributes, IDCON, arguments
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 84:5: -> ^( MARKUP IDCON attributes ( arguments )? )
            {
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:84:8: ^( MARKUP IDCON attributes ( arguments )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MARKUP, "MARKUP"), root_1);

                adaptor.addChild(root_1, stream_IDCON.nextNode());
                adaptor.addChild(root_1, stream_attributes.nextTree());
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:84:35: ( arguments )?
                if ( stream_arguments.hasNext() ) {
                    adaptor.addChild(root_1, stream_arguments.nextTree());

                }
                stream_arguments.reset();

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:86:1: attributes : ( attribute )* -> ^( ATTRIBUTES ( attribute )* ) ;
    public final WaebricTestParser.attributes_return attributes() throws RecognitionException {
        WaebricTestParser.attributes_return retval = new WaebricTestParser.attributes_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WaebricTestParser.attribute_return attribute31 = null;


        RewriteRuleSubtreeStream stream_attribute=new RewriteRuleSubtreeStream(adaptor,"rule attribute");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:86:11: ( ( attribute )* -> ^( ATTRIBUTES ( attribute )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:86:14: ( attribute )*
            {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:86:14: ( attribute )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==40||LA10_0==42||(LA10_0>=47 && LA10_0<=49)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:86:14: attribute
            	    {
            	    pushFollow(FOLLOW_attribute_in_attributes410);
            	    attribute31=attribute();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_attribute.add(attribute31.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
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
            // 87:5: -> ^( ATTRIBUTES ( attribute )* )
            {
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:87:8: ^( ATTRIBUTES ( attribute )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ATTRIBUTES, "ATTRIBUTES"), root_1);

                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:87:22: ( attribute )*
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:89:1: attribute : ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON );
    public final WaebricTestParser.attribute_return attribute() throws RecognitionException {
        WaebricTestParser.attribute_return retval = new WaebricTestParser.attribute_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal32=null;
        Token IDCON33=null;
        Token char_literal34=null;
        Token IDCON35=null;
        Token char_literal36=null;
        Token IDCON37=null;
        Token char_literal38=null;
        Token IDCON39=null;
        Token char_literal40=null;
        Token NATCON41=null;
        Token char_literal42=null;
        Token NATCON43=null;
        Token char_literal44=null;
        Token NATCON45=null;

        Object char_literal32_tree=null;
        Object IDCON33_tree=null;
        Object char_literal34_tree=null;
        Object IDCON35_tree=null;
        Object char_literal36_tree=null;
        Object IDCON37_tree=null;
        Object char_literal38_tree=null;
        Object IDCON39_tree=null;
        Object char_literal40_tree=null;
        Object NATCON41_tree=null;
        Object char_literal42_tree=null;
        Object NATCON43_tree=null;
        Object char_literal44_tree=null;
        Object NATCON45_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:89:10: ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON )
            int alt11=6;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt11=1;
                }
                break;
            case 40:
                {
                alt11=2;
                }
                break;
            case 48:
                {
                alt11=3;
                }
                break;
            case 42:
                {
                alt11=4;
                }
                break;
            case 49:
                {
                int LA11_5 = input.LA(2);

                if ( (LA11_5==NATCON) ) {
                    int LA11_6 = input.LA(3);

                    if ( (LA11_6==50) ) {
                        alt11=6;
                    }
                    else if ( (LA11_6==IDCON||(LA11_6>=NATCON && LA11_6<=SYMBOLCON)||(LA11_6>=POSTTEXT && LA11_6<=MIDTEXT)||LA11_6==END||LA11_6==SEMICOLON||LA11_6==40||LA11_6==42||LA11_6==44||(LA11_6>=47 && LA11_6<=49)||LA11_6==52||LA11_6==54) ) {
                        alt11=5;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 5, input);

                    throw nvae;
                }
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:89:13: '#' IDCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal32=(Token)match(input,47,FOLLOW_47_in_attribute440); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal32_tree = (Object)adaptor.create(char_literal32);
                    adaptor.addChild(root_0, char_literal32_tree);
                    }
                    IDCON33=(Token)match(input,IDCON,FOLLOW_IDCON_in_attribute442); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON33_tree = (Object)adaptor.create(IDCON33);
                    adaptor.addChild(root_0, IDCON33_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:90:6: '.' IDCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal34=(Token)match(input,40,FOLLOW_40_in_attribute450); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal34_tree = (Object)adaptor.create(char_literal34);
                    adaptor.addChild(root_0, char_literal34_tree);
                    }
                    IDCON35=(Token)match(input,IDCON,FOLLOW_IDCON_in_attribute452); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON35_tree = (Object)adaptor.create(IDCON35);
                    adaptor.addChild(root_0, IDCON35_tree);
                    }

                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:91:6: '$' IDCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal36=(Token)match(input,48,FOLLOW_48_in_attribute460); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal36_tree = (Object)adaptor.create(char_literal36);
                    adaptor.addChild(root_0, char_literal36_tree);
                    }
                    IDCON37=(Token)match(input,IDCON,FOLLOW_IDCON_in_attribute462); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON37_tree = (Object)adaptor.create(IDCON37);
                    adaptor.addChild(root_0, IDCON37_tree);
                    }

                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:92:6: ':' IDCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal38=(Token)match(input,42,FOLLOW_42_in_attribute470); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal38_tree = (Object)adaptor.create(char_literal38);
                    adaptor.addChild(root_0, char_literal38_tree);
                    }
                    IDCON39=(Token)match(input,IDCON,FOLLOW_IDCON_in_attribute472); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON39_tree = (Object)adaptor.create(IDCON39);
                    adaptor.addChild(root_0, IDCON39_tree);
                    }

                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:93:6: '@' NATCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal40=(Token)match(input,49,FOLLOW_49_in_attribute480); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal40_tree = (Object)adaptor.create(char_literal40);
                    adaptor.addChild(root_0, char_literal40_tree);
                    }
                    NATCON41=(Token)match(input,NATCON,FOLLOW_NATCON_in_attribute482); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON41_tree = (Object)adaptor.create(NATCON41);
                    adaptor.addChild(root_0, NATCON41_tree);
                    }

                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:94:6: '@' NATCON '%' NATCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal42=(Token)match(input,49,FOLLOW_49_in_attribute490); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal42_tree = (Object)adaptor.create(char_literal42);
                    adaptor.addChild(root_0, char_literal42_tree);
                    }
                    NATCON43=(Token)match(input,NATCON,FOLLOW_NATCON_in_attribute492); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON43_tree = (Object)adaptor.create(NATCON43);
                    adaptor.addChild(root_0, NATCON43_tree);
                    }
                    char_literal44=(Token)match(input,50,FOLLOW_50_in_attribute494); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal44_tree = (Object)adaptor.create(char_literal44);
                    adaptor.addChild(root_0, char_literal44_tree);
                    }
                    NATCON45=(Token)match(input,NATCON,FOLLOW_NATCON_in_attribute496); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON45_tree = (Object)adaptor.create(NATCON45);
                    adaptor.addChild(root_0, NATCON45_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:97:1: arguments : '(' ( argument )? ( ',' argument )* ')' -> ^( ARGUMENTS ( argument )* ) ;
    public final WaebricTestParser.arguments_return arguments() throws RecognitionException {
        WaebricTestParser.arguments_return retval = new WaebricTestParser.arguments_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal46=null;
        Token char_literal48=null;
        Token char_literal50=null;
        WaebricTestParser.argument_return argument47 = null;

        WaebricTestParser.argument_return argument49 = null;


        Object char_literal46_tree=null;
        Object char_literal48_tree=null;
        Object char_literal50_tree=null;
        RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
        RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
        RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
        RewriteRuleSubtreeStream stream_argument=new RewriteRuleSubtreeStream(adaptor,"rule argument");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:97:10: ( '(' ( argument )? ( ',' argument )* ')' -> ^( ARGUMENTS ( argument )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:97:13: '(' ( argument )? ( ',' argument )* ')'
            {
            char_literal46=(Token)match(input,44,FOLLOW_44_in_arguments509); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_44.add(char_literal46);

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:97:17: ( argument )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==IDCON||(LA12_0>=NATCON && LA12_0<=SYMBOLCON)||LA12_0==52||LA12_0==54) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:97:17: argument
                    {
                    pushFollow(FOLLOW_argument_in_arguments511);
                    argument47=argument();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_argument.add(argument47.getTree());

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:97:27: ( ',' argument )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==45) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:97:29: ',' argument
            	    {
            	    char_literal48=(Token)match(input,45,FOLLOW_45_in_arguments516); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_45.add(char_literal48);

            	    pushFollow(FOLLOW_argument_in_arguments518);
            	    argument49=argument();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_argument.add(argument49.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            char_literal50=(Token)match(input,46,FOLLOW_46_in_arguments523); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_46.add(char_literal50);



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
            // 98:5: -> ^( ARGUMENTS ( argument )* )
            {
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:98:8: ^( ARGUMENTS ( argument )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARGUMENTS, "ARGUMENTS"), root_1);

                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:98:21: ( argument )*
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:100:1: argument : ( expression -> ^( ARGUMENT expression ) | IDCON '=' expression -> ^( ARGUMENT IDCON '=' expression ) );
    public final WaebricTestParser.argument_return argument() throws RecognitionException {
        WaebricTestParser.argument_return retval = new WaebricTestParser.argument_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDCON52=null;
        Token char_literal53=null;
        WaebricTestParser.expression_return expression51 = null;

        WaebricTestParser.expression_return expression54 = null;


        Object IDCON52_tree=null;
        Object char_literal53_tree=null;
        RewriteRuleTokenStream stream_IDCON=new RewriteRuleTokenStream(adaptor,"token IDCON");
        RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:100:9: ( expression -> ^( ARGUMENT expression ) | IDCON '=' expression -> ^( ARGUMENT IDCON '=' expression ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==IDCON) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==51) ) {
                    alt14=2;
                }
                else if ( (LA14_1==40||(LA14_1>=45 && LA14_1<=46)||LA14_1==56) ) {
                    alt14=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA14_0>=NATCON && LA14_0<=SYMBOLCON)||LA14_0==52||LA14_0==54) ) {
                alt14=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:100:12: expression
                    {
                    pushFollow(FOLLOW_expression_in_argument547);
                    expression51=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression51.getTree());


                    // AST REWRITE
                    // elements: expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 101:5: -> ^( ARGUMENT expression )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:101:8: ^( ARGUMENT expression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARGUMENT, "ARGUMENT"), root_1);

                        adaptor.addChild(root_1, stream_expression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:102:6: IDCON '=' expression
                    {
                    IDCON52=(Token)match(input,IDCON,FOLLOW_IDCON_in_argument568); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDCON.add(IDCON52);

                    char_literal53=(Token)match(input,51,FOLLOW_51_in_argument570); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_51.add(char_literal53);

                    pushFollow(FOLLOW_expression_in_argument572);
                    expression54=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression54.getTree());


                    // AST REWRITE
                    // elements: 51, IDCON, expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 103:5: -> ^( ARGUMENT IDCON '=' expression )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:103:8: ^( ARGUMENT IDCON '=' expression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARGUMENT, "ARGUMENT"), root_1);

                        adaptor.addChild(root_1, stream_IDCON.nextNode());
                        adaptor.addChild(root_1, stream_51.nextNode());
                        adaptor.addChild(root_1, stream_expression.nextTree());

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
    // $ANTLR end "argument"

    public static class statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:105:1: statement : ( regularStatement | markupStatement );
    public final WaebricTestParser.statement_return statement() throws RecognitionException {
        WaebricTestParser.statement_return retval = new WaebricTestParser.statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WaebricTestParser.regularStatement_return regularStatement55 = null;

        WaebricTestParser.markupStatement_return markupStatement56 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:105:10: ( regularStatement | markupStatement )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==COMMENT||LA15_0==54||LA15_0==57||(LA15_0>=59 && LA15_0<=60)||(LA15_0>=62 && LA15_0<=64)) ) {
                alt15=1;
            }
            else if ( (LA15_0==IDCON) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:105:13: regularStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_regularStatement_in_statement600);
                    regularStatement55=regularStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, regularStatement55.getTree());

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:106:6: markupStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_markupStatement_in_statement607);
                    markupStatement56=markupStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, markupStatement56.getTree());

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

    public static class expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:109:1: expression : ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* ;
    public final WaebricTestParser.expression_return expression() throws RecognitionException {
        WaebricTestParser.expression_return retval = new WaebricTestParser.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDCON57=null;
        Token NATCON58=null;
        Token TEXT59=null;
        Token SYMBOLCON60=null;
        Token char_literal61=null;
        Token char_literal63=null;
        Token char_literal65=null;
        Token char_literal66=null;
        Token char_literal68=null;
        Token char_literal70=null;
        Token char_literal71=null;
        Token char_literal73=null;
        Token IDCON74=null;
        WaebricTestParser.expression_return expression62 = null;

        WaebricTestParser.expression_return expression64 = null;

        WaebricTestParser.keyValuePair_return keyValuePair67 = null;

        WaebricTestParser.keyValuePair_return keyValuePair69 = null;

        WaebricTestParser.expression_return expression72 = null;


        Object IDCON57_tree=null;
        Object NATCON58_tree=null;
        Object TEXT59_tree=null;
        Object SYMBOLCON60_tree=null;
        Object char_literal61_tree=null;
        Object char_literal63_tree=null;
        Object char_literal65_tree=null;
        Object char_literal66_tree=null;
        Object char_literal68_tree=null;
        Object char_literal70_tree=null;
        Object char_literal71_tree=null;
        Object char_literal73_tree=null;
        Object IDCON74_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:109:11: ( ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:109:14: ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:109:14: ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' )
            int alt20=6;
            switch ( input.LA(1) ) {
            case IDCON:
                {
                alt20=1;
                }
                break;
            case NATCON:
                {
                alt20=2;
                }
                break;
            case TEXT:
                {
                alt20=3;
                }
                break;
            case SYMBOLCON:
                {
                alt20=4;
                }
                break;
            case 52:
                {
                alt20=5;
                }
                break;
            case 54:
                {
                alt20=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:109:16: IDCON
                    {
                    IDCON57=(Token)match(input,IDCON,FOLLOW_IDCON_in_expression626); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON57_tree = (Object)adaptor.create(IDCON57);
                    adaptor.addChild(root_0, IDCON57_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:109:24: NATCON
                    {
                    NATCON58=(Token)match(input,NATCON,FOLLOW_NATCON_in_expression630); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON58_tree = (Object)adaptor.create(NATCON58);
                    adaptor.addChild(root_0, NATCON58_tree);
                    }

                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:109:33: TEXT
                    {
                    TEXT59=(Token)match(input,TEXT,FOLLOW_TEXT_in_expression634); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TEXT59_tree = (Object)adaptor.create(TEXT59);
                    adaptor.addChild(root_0, TEXT59_tree);
                    }

                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:109:40: SYMBOLCON
                    {
                    SYMBOLCON60=(Token)match(input,SYMBOLCON,FOLLOW_SYMBOLCON_in_expression638); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SYMBOLCON60_tree = (Object)adaptor.create(SYMBOLCON60);
                    adaptor.addChild(root_0, SYMBOLCON60_tree);
                    }

                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:110:7: '[' ( expression )? ( ',' expression )* ']'
                    {
                    char_literal61=(Token)match(input,52,FOLLOW_52_in_expression647); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal61_tree = (Object)adaptor.create(char_literal61);
                    adaptor.addChild(root_0, char_literal61_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:110:11: ( expression )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==IDCON||(LA16_0>=NATCON && LA16_0<=SYMBOLCON)||LA16_0==52||LA16_0==54) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:110:11: expression
                            {
                            pushFollow(FOLLOW_expression_in_expression649);
                            expression62=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression62.getTree());

                            }
                            break;

                    }

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:110:23: ( ',' expression )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==45) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:110:25: ',' expression
                    	    {
                    	    char_literal63=(Token)match(input,45,FOLLOW_45_in_expression654); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal63_tree = (Object)adaptor.create(char_literal63);
                    	    adaptor.addChild(root_0, char_literal63_tree);
                    	    }
                    	    pushFollow(FOLLOW_expression_in_expression656);
                    	    expression64=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression64.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    char_literal65=(Token)match(input,53,FOLLOW_53_in_expression661); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal65_tree = (Object)adaptor.create(char_literal65);
                    adaptor.addChild(root_0, char_literal65_tree);
                    }

                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:111:7: '{' ( keyValuePair )? ( ',' keyValuePair )* '}'
                    {
                    char_literal66=(Token)match(input,54,FOLLOW_54_in_expression670); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal66_tree = (Object)adaptor.create(char_literal66);
                    adaptor.addChild(root_0, char_literal66_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:111:11: ( keyValuePair )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==IDCON) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:111:11: keyValuePair
                            {
                            pushFollow(FOLLOW_keyValuePair_in_expression672);
                            keyValuePair67=keyValuePair();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, keyValuePair67.getTree());

                            }
                            break;

                    }

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:111:25: ( ',' keyValuePair )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==45) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:111:27: ',' keyValuePair
                    	    {
                    	    char_literal68=(Token)match(input,45,FOLLOW_45_in_expression677); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal68_tree = (Object)adaptor.create(char_literal68);
                    	    adaptor.addChild(root_0, char_literal68_tree);
                    	    }
                    	    pushFollow(FOLLOW_keyValuePair_in_expression679);
                    	    keyValuePair69=keyValuePair();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, keyValuePair69.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);

                    char_literal70=(Token)match(input,55,FOLLOW_55_in_expression684); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal70_tree = (Object)adaptor.create(char_literal70);
                    adaptor.addChild(root_0, char_literal70_tree);
                    }

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:112:6: ( '+' expression | '.' IDCON )*
            loop21:
            do {
                int alt21=3;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==56) ) {
                    alt21=1;
                }
                else if ( (LA21_0==40) ) {
                    alt21=2;
                }


                switch (alt21) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:112:8: '+' expression
            	    {
            	    char_literal71=(Token)match(input,56,FOLLOW_56_in_expression694); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal71_tree = (Object)adaptor.create(char_literal71);
            	    adaptor.addChild(root_0, char_literal71_tree);
            	    }
            	    pushFollow(FOLLOW_expression_in_expression696);
            	    expression72=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression72.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:112:25: '.' IDCON
            	    {
            	    char_literal73=(Token)match(input,40,FOLLOW_40_in_expression700); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal73_tree = (Object)adaptor.create(char_literal73);
            	    adaptor.addChild(root_0, char_literal73_tree);
            	    }
            	    IDCON74=(Token)match(input,IDCON,FOLLOW_IDCON_in_expression702); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDCON74_tree = (Object)adaptor.create(IDCON74);
            	    adaptor.addChild(root_0, IDCON74_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop21;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:114:1: keyValuePair : IDCON ':' expression ;
    public final WaebricTestParser.keyValuePair_return keyValuePair() throws RecognitionException {
        WaebricTestParser.keyValuePair_return retval = new WaebricTestParser.keyValuePair_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDCON75=null;
        Token char_literal76=null;
        WaebricTestParser.expression_return expression77 = null;


        Object IDCON75_tree=null;
        Object char_literal76_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:114:13: ( IDCON ':' expression )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:114:16: IDCON ':' expression
            {
            root_0 = (Object)adaptor.nil();

            IDCON75=(Token)match(input,IDCON,FOLLOW_IDCON_in_keyValuePair717); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON75_tree = (Object)adaptor.create(IDCON75);
            adaptor.addChild(root_0, IDCON75_tree);
            }
            char_literal76=(Token)match(input,42,FOLLOW_42_in_keyValuePair719); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal76_tree = (Object)adaptor.create(char_literal76);
            adaptor.addChild(root_0, char_literal76_tree);
            }
            pushFollow(FOLLOW_expression_in_keyValuePair721);
            expression77=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression77.getTree());

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

    public static class regularStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "regularStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:116:1: regularStatement : ( 'if' '(' predicate ')' statement ( 'else' statement )? -> ^( 'if' predicate statement ( 'else' statement )? ) | 'each' '(' IDCON ':' expression ')' statement -> ^( 'each' '(' IDCON ':' expression ')' statement ) | 'let' ( assignment )+ 'in' ( statement )* 'end' -> ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | '{' ( statement )* '}' -> ^( '{' ( statement )* '}' ) | 'yield' ';' -> ^( 'yield' ) | 'comment' STRCON ';' -> ^( 'comment' STRCON ) | 'echo' expression ';' -> ^( 'echo' expression ) | 'echo' embedding ';' -> ^( 'echo' embedding ) | 'cdata' expression ';' -> ^( 'cdata' expression ) );
    public final WaebricTestParser.regularStatement_return regularStatement() throws RecognitionException {
        WaebricTestParser.regularStatement_return retval = new WaebricTestParser.regularStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal78=null;
        Token char_literal79=null;
        Token char_literal81=null;
        Token string_literal83=null;
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
        Token char_literal101=null;
        Token string_literal102=null;
        Token STRCON103=null;
        Token char_literal104=null;
        Token string_literal105=null;
        Token char_literal107=null;
        Token string_literal108=null;
        Token char_literal110=null;
        Token string_literal111=null;
        Token char_literal113=null;
        WaebricTestParser.predicate_return predicate80 = null;

        WaebricTestParser.statement_return statement82 = null;

        WaebricTestParser.statement_return statement84 = null;

        WaebricTestParser.expression_return expression89 = null;

        WaebricTestParser.statement_return statement91 = null;

        WaebricTestParser.assignment_return assignment93 = null;

        WaebricTestParser.statement_return statement95 = null;

        WaebricTestParser.statement_return statement98 = null;

        WaebricTestParser.expression_return expression106 = null;

        WaebricTestParser.embedding_return embedding109 = null;

        WaebricTestParser.expression_return expression112 = null;


        Object string_literal78_tree=null;
        Object char_literal79_tree=null;
        Object char_literal81_tree=null;
        Object string_literal83_tree=null;
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
        Object char_literal101_tree=null;
        Object string_literal102_tree=null;
        Object STRCON103_tree=null;
        Object char_literal104_tree=null;
        Object string_literal105_tree=null;
        Object char_literal107_tree=null;
        Object string_literal108_tree=null;
        Object char_literal110_tree=null;
        Object string_literal111_tree=null;
        Object char_literal113_tree=null;
        RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
        RewriteRuleTokenStream stream_END=new RewriteRuleTokenStream(adaptor,"token END");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
        RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
        RewriteRuleTokenStream stream_STRCON=new RewriteRuleTokenStream(adaptor,"token STRCON");
        RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
        RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
        RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
        RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
        RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
        RewriteRuleTokenStream stream_COMMENT=new RewriteRuleTokenStream(adaptor,"token COMMENT");
        RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
        RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
        RewriteRuleTokenStream stream_IDCON=new RewriteRuleTokenStream(adaptor,"token IDCON");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_assignment=new RewriteRuleSubtreeStream(adaptor,"rule assignment");
        RewriteRuleSubtreeStream stream_embedding=new RewriteRuleSubtreeStream(adaptor,"rule embedding");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_predicate=new RewriteRuleSubtreeStream(adaptor,"rule predicate");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:116:17: ( 'if' '(' predicate ')' statement ( 'else' statement )? -> ^( 'if' predicate statement ( 'else' statement )? ) | 'each' '(' IDCON ':' expression ')' statement -> ^( 'each' '(' IDCON ':' expression ')' statement ) | 'let' ( assignment )+ 'in' ( statement )* 'end' -> ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | '{' ( statement )* '}' -> ^( '{' ( statement )* '}' ) | 'yield' ';' -> ^( 'yield' ) | 'comment' STRCON ';' -> ^( 'comment' STRCON ) | 'echo' expression ';' -> ^( 'echo' expression ) | 'echo' embedding ';' -> ^( 'echo' embedding ) | 'cdata' expression ';' -> ^( 'cdata' expression ) )
            int alt26=9;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:116:19: 'if' '(' predicate ')' statement ( 'else' statement )?
                    {
                    string_literal78=(Token)match(input,57,FOLLOW_57_in_regularStatement729); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_57.add(string_literal78);

                    char_literal79=(Token)match(input,44,FOLLOW_44_in_regularStatement731); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_44.add(char_literal79);

                    pushFollow(FOLLOW_predicate_in_regularStatement733);
                    predicate80=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_predicate.add(predicate80.getTree());
                    char_literal81=(Token)match(input,46,FOLLOW_46_in_regularStatement735); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_46.add(char_literal81);

                    pushFollow(FOLLOW_statement_in_regularStatement737);
                    statement82=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement82.getTree());
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:116:52: ( 'else' statement )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==58) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:116:54: 'else' statement
                            {
                            string_literal83=(Token)match(input,58,FOLLOW_58_in_regularStatement741); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_58.add(string_literal83);

                            pushFollow(FOLLOW_statement_in_regularStatement743);
                            statement84=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_statement.add(statement84.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: predicate, 57, statement, statement, 58
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 117:5: -> ^( 'if' predicate statement ( 'else' statement )? )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:117:8: ^( 'if' predicate statement ( 'else' statement )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_57.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_predicate.nextTree());
                        adaptor.addChild(root_1, stream_statement.nextTree());
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:117:36: ( 'else' statement )?
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:118:6: 'each' '(' IDCON ':' expression ')' statement
                    {
                    string_literal85=(Token)match(input,59,FOLLOW_59_in_regularStatement778); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_59.add(string_literal85);

                    char_literal86=(Token)match(input,44,FOLLOW_44_in_regularStatement780); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_44.add(char_literal86);

                    IDCON87=(Token)match(input,IDCON,FOLLOW_IDCON_in_regularStatement782); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDCON.add(IDCON87);

                    char_literal88=(Token)match(input,42,FOLLOW_42_in_regularStatement784); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_42.add(char_literal88);

                    pushFollow(FOLLOW_expression_in_regularStatement786);
                    expression89=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression89.getTree());
                    char_literal90=(Token)match(input,46,FOLLOW_46_in_regularStatement788); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_46.add(char_literal90);

                    pushFollow(FOLLOW_statement_in_regularStatement790);
                    statement91=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement91.getTree());


                    // AST REWRITE
                    // elements: 46, expression, IDCON, 59, 42, 44, statement
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 119:5: -> ^( 'each' '(' IDCON ':' expression ')' statement )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:119:8: ^( 'each' '(' IDCON ':' expression ')' statement )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_59.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_44.nextNode());
                        adaptor.addChild(root_1, stream_IDCON.nextNode());
                        adaptor.addChild(root_1, stream_42.nextNode());
                        adaptor.addChild(root_1, stream_expression.nextTree());
                        adaptor.addChild(root_1, stream_46.nextNode());
                        adaptor.addChild(root_1, stream_statement.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:120:6: 'let' ( assignment )+ 'in' ( statement )* 'end'
                    {
                    string_literal92=(Token)match(input,60,FOLLOW_60_in_regularStatement822); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_60.add(string_literal92);

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:120:12: ( assignment )+
                    int cnt23=0;
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==IDCON) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:120:12: assignment
                    	    {
                    	    pushFollow(FOLLOW_assignment_in_regularStatement824);
                    	    assignment93=assignment();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_assignment.add(assignment93.getTree());

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

                    string_literal94=(Token)match(input,61,FOLLOW_61_in_regularStatement827); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_61.add(string_literal94);

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:120:29: ( statement )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==IDCON||LA24_0==COMMENT||LA24_0==54||LA24_0==57||(LA24_0>=59 && LA24_0<=60)||(LA24_0>=62 && LA24_0<=64)) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:120:29: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_regularStatement829);
                    	    statement95=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_statement.add(statement95.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    string_literal96=(Token)match(input,END,FOLLOW_END_in_regularStatement832); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_END.add(string_literal96);



                    // AST REWRITE
                    // elements: statement, assignment, END, 61, 60
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 121:5: -> ^( 'let' ( assignment )+ 'in' ( statement )* 'end' )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:121:8: ^( 'let' ( assignment )+ 'in' ( statement )* 'end' )
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
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:121:34: ( statement )*
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:122:6: '{' ( statement )* '}'
                    {
                    char_literal97=(Token)match(input,54,FOLLOW_54_in_regularStatement861); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_54.add(char_literal97);

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:122:10: ( statement )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==IDCON||LA25_0==COMMENT||LA25_0==54||LA25_0==57||(LA25_0>=59 && LA25_0<=60)||(LA25_0>=62 && LA25_0<=64)) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:122:10: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_regularStatement863);
                    	    statement98=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_statement.add(statement98.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);

                    char_literal99=(Token)match(input,55,FOLLOW_55_in_regularStatement866); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_55.add(char_literal99);



                    // AST REWRITE
                    // elements: statement, 55, 54
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 123:5: -> ^( '{' ( statement )* '}' )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:123:8: ^( '{' ( statement )* '}' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_54.nextNode(), root_1);

                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:123:15: ( statement )*
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:124:6: 'yield' ';'
                    {
                    string_literal100=(Token)match(input,62,FOLLOW_62_in_regularStatement890); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_62.add(string_literal100);

                    char_literal101=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_regularStatement892); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal101);



                    // AST REWRITE
                    // elements: 62
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 125:5: -> ^( 'yield' )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:125:8: ^( 'yield' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_62.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:126:6: 'comment' STRCON ';'
                    {
                    string_literal102=(Token)match(input,COMMENT,FOLLOW_COMMENT_in_regularStatement911); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COMMENT.add(string_literal102);

                    STRCON103=(Token)match(input,STRCON,FOLLOW_STRCON_in_regularStatement913); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRCON.add(STRCON103);

                    char_literal104=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_regularStatement915); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal104);



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
                    // 127:5: -> ^( 'comment' STRCON )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:127:8: ^( 'comment' STRCON )
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:128:6: 'echo' expression ';'
                    {
                    string_literal105=(Token)match(input,63,FOLLOW_63_in_regularStatement936); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_63.add(string_literal105);

                    pushFollow(FOLLOW_expression_in_regularStatement938);
                    expression106=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression106.getTree());
                    char_literal107=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_regularStatement940); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal107);



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
                    // 129:5: -> ^( 'echo' expression )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:129:8: ^( 'echo' expression )
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
                case 8 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:130:6: 'echo' embedding ';'
                    {
                    string_literal108=(Token)match(input,63,FOLLOW_63_in_regularStatement961); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_63.add(string_literal108);

                    pushFollow(FOLLOW_embedding_in_regularStatement963);
                    embedding109=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_embedding.add(embedding109.getTree());
                    char_literal110=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_regularStatement965); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal110);



                    // AST REWRITE
                    // elements: embedding, 63
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 131:5: -> ^( 'echo' embedding )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:131:8: ^( 'echo' embedding )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_63.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_embedding.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 9 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:132:6: 'cdata' expression ';'
                    {
                    string_literal111=(Token)match(input,64,FOLLOW_64_in_regularStatement986); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_64.add(string_literal111);

                    pushFollow(FOLLOW_expression_in_regularStatement988);
                    expression112=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression112.getTree());
                    char_literal113=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_regularStatement990); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal113);



                    // AST REWRITE
                    // elements: 64, expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 133:5: -> ^( 'cdata' expression )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:133:8: ^( 'cdata' expression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_64.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_expression.nextTree());

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
    // $ANTLR end "regularStatement"

    public static class markupStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "markupStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:136:1: markupStatement : ( markup )+ ( ( expression )=> expression ) ';' ;
    public final WaebricTestParser.markupStatement_return markupStatement() throws RecognitionException {
        WaebricTestParser.markupStatement_return retval = new WaebricTestParser.markupStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal116=null;
        WaebricTestParser.markup_return markup114 = null;

        WaebricTestParser.expression_return expression115 = null;


        Object char_literal116_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:136:16: ( ( markup )+ ( ( expression )=> expression ) ';' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:136:18: ( markup )+ ( ( expression )=> expression ) ';'
            {
            root_0 = (Object)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:136:18: ( markup )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                alt27 = dfa27.predict(input);
                switch (alt27) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:136:18: markup
            	    {
            	    pushFollow(FOLLOW_markup_in_markupStatement1018);
            	    markup114=markup();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, markup114.getTree());

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

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:136:26: ( ( expression )=> expression )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:136:28: ( expression )=> expression
            {
            pushFollow(FOLLOW_expression_in_markupStatement1027);
            expression115=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression115.getTree());

            }

            char_literal116=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_markupStatement1031); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal116_tree = (Object)adaptor.create(char_literal116);
            adaptor.addChild(root_0, char_literal116_tree);
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
    // $ANTLR end "markupStatement"

    public static class assignment_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignment"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:138:1: assignment : ( IDCON '=' expression ';' | IDCON formals '=' statement -> ^( 'def' IDCON ^( FORMALS ( formals )? ) statement ) );
    public final WaebricTestParser.assignment_return assignment() throws RecognitionException {
        WaebricTestParser.assignment_return retval = new WaebricTestParser.assignment_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDCON117=null;
        Token char_literal118=null;
        Token char_literal120=null;
        Token IDCON121=null;
        Token char_literal123=null;
        WaebricTestParser.expression_return expression119 = null;

        WaebricTestParser.formals_return formals122 = null;

        WaebricTestParser.statement_return statement124 = null;


        Object IDCON117_tree=null;
        Object char_literal118_tree=null;
        Object char_literal120_tree=null;
        Object IDCON121_tree=null;
        Object char_literal123_tree=null;
        RewriteRuleTokenStream stream_IDCON=new RewriteRuleTokenStream(adaptor,"token IDCON");
        RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
        RewriteRuleSubtreeStream stream_formals=new RewriteRuleSubtreeStream(adaptor,"rule formals");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:138:11: ( IDCON '=' expression ';' | IDCON formals '=' statement -> ^( 'def' IDCON ^( FORMALS ( formals )? ) statement ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==IDCON) ) {
                int LA28_1 = input.LA(2);

                if ( (LA28_1==51) ) {
                    alt28=1;
                }
                else if ( (LA28_1==44) ) {
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:138:14: IDCON '=' expression ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    IDCON117=(Token)match(input,IDCON,FOLLOW_IDCON_in_assignment1040); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON117_tree = (Object)adaptor.create(IDCON117);
                    adaptor.addChild(root_0, IDCON117_tree);
                    }
                    char_literal118=(Token)match(input,51,FOLLOW_51_in_assignment1042); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal118_tree = (Object)adaptor.create(char_literal118);
                    adaptor.addChild(root_0, char_literal118_tree);
                    }
                    pushFollow(FOLLOW_expression_in_assignment1044);
                    expression119=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression119.getTree());
                    char_literal120=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_assignment1046); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal120_tree = (Object)adaptor.create(char_literal120);
                    adaptor.addChild(root_0, char_literal120_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:139:6: IDCON formals '=' statement
                    {
                    IDCON121=(Token)match(input,IDCON,FOLLOW_IDCON_in_assignment1054); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDCON.add(IDCON121);

                    pushFollow(FOLLOW_formals_in_assignment1056);
                    formals122=formals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_formals.add(formals122.getTree());
                    char_literal123=(Token)match(input,51,FOLLOW_51_in_assignment1058); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_51.add(char_literal123);

                    pushFollow(FOLLOW_statement_in_assignment1060);
                    statement124=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement124.getTree());


                    // AST REWRITE
                    // elements: formals, statement, IDCON, 43
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 140:5: -> ^( 'def' IDCON ^( FORMALS ( formals )? ) statement )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:140:8: ^( 'def' IDCON ^( FORMALS ( formals )? ) statement )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(43, "43"), root_1);

                        adaptor.addChild(root_1, stream_IDCON.nextNode());
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:140:23: ^( FORMALS ( formals )? )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(FORMALS, "FORMALS"), root_2);

                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:140:34: ( formals )?
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:142:1: predicate : ( '!' )* expression ( '.' type '?' )? ( '&&' predicate | '||' predicate )* ;
    public final WaebricTestParser.predicate_return predicate() throws RecognitionException {
        WaebricTestParser.predicate_return retval = new WaebricTestParser.predicate_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal125=null;
        Token char_literal127=null;
        Token char_literal129=null;
        Token string_literal130=null;
        Token string_literal132=null;
        WaebricTestParser.expression_return expression126 = null;

        WaebricTestParser.type_return type128 = null;

        WaebricTestParser.predicate_return predicate131 = null;

        WaebricTestParser.predicate_return predicate133 = null;


        Object char_literal125_tree=null;
        Object char_literal127_tree=null;
        Object char_literal129_tree=null;
        Object string_literal130_tree=null;
        Object string_literal132_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:142:10: ( ( '!' )* expression ( '.' type '?' )? ( '&&' predicate | '||' predicate )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:142:13: ( '!' )* expression ( '.' type '?' )? ( '&&' predicate | '||' predicate )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:142:13: ( '!' )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==65) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:142:13: '!'
            	    {
            	    char_literal125=(Token)match(input,65,FOLLOW_65_in_predicate1098); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal125_tree = (Object)adaptor.create(char_literal125);
            	    adaptor.addChild(root_0, char_literal125_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            pushFollow(FOLLOW_expression_in_predicate1101);
            expression126=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression126.getTree());
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:142:29: ( '.' type '?' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==40) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:142:31: '.' type '?'
                    {
                    char_literal127=(Token)match(input,40,FOLLOW_40_in_predicate1105); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal127_tree = (Object)adaptor.create(char_literal127);
                    adaptor.addChild(root_0, char_literal127_tree);
                    }
                    pushFollow(FOLLOW_type_in_predicate1107);
                    type128=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, type128.getTree());
                    char_literal129=(Token)match(input,66,FOLLOW_66_in_predicate1109); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal129_tree = (Object)adaptor.create(char_literal129);
                    adaptor.addChild(root_0, char_literal129_tree);
                    }

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:143:4: ( '&&' predicate | '||' predicate )*
            loop31:
            do {
                int alt31=3;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==67) ) {
                    alt31=1;
                }
                else if ( (LA31_0==68) ) {
                    alt31=2;
                }


                switch (alt31) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:143:6: '&&' predicate
            	    {
            	    string_literal130=(Token)match(input,67,FOLLOW_67_in_predicate1119); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal130_tree = (Object)adaptor.create(string_literal130);
            	    adaptor.addChild(root_0, string_literal130_tree);
            	    }
            	    pushFollow(FOLLOW_predicate_in_predicate1121);
            	    predicate131=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate131.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:143:23: '||' predicate
            	    {
            	    string_literal132=(Token)match(input,68,FOLLOW_68_in_predicate1125); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal132_tree = (Object)adaptor.create(string_literal132);
            	    adaptor.addChild(root_0, string_literal132_tree);
            	    }
            	    pushFollow(FOLLOW_predicate_in_predicate1127);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:145:1: type : ( 'list' | 'record' | 'string' );
    public final WaebricTestParser.type_return type() throws RecognitionException {
        WaebricTestParser.type_return retval = new WaebricTestParser.type_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set134=null;

        Object set134_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:145:5: ( 'list' | 'record' | 'string' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:
            {
            root_0 = (Object)adaptor.nil();

            set134=(Token)input.LT(1);
            if ( (input.LA(1)>=69 && input.LA(1)<=71) ) {
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:150:1: embedding : PRETEXT embed textTail ;
    public final WaebricTestParser.embedding_return embedding() throws RecognitionException {
        WaebricTestParser.embedding_return retval = new WaebricTestParser.embedding_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PRETEXT135=null;
        WaebricTestParser.embed_return embed136 = null;

        WaebricTestParser.textTail_return textTail137 = null;


        Object PRETEXT135_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:150:10: ( PRETEXT embed textTail )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:150:13: PRETEXT embed textTail
            {
            root_0 = (Object)adaptor.nil();

            PRETEXT135=(Token)match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding1172); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRETEXT135_tree = (Object)adaptor.create(PRETEXT135);
            adaptor.addChild(root_0, PRETEXT135_tree);
            }
            pushFollow(FOLLOW_embed_in_embedding1174);
            embed136=embed();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, embed136.getTree());
            pushFollow(FOLLOW_textTail_in_embedding1176);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:152:1: embed : ( markup )+ ;
    public final WaebricTestParser.embed_return embed() throws RecognitionException {
        WaebricTestParser.embed_return retval = new WaebricTestParser.embed_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WaebricTestParser.markup_return markup138 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:152:6: ( ( markup )+ )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:152:10: ( markup )+
            {
            root_0 = (Object)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:152:10: ( markup )+
            int cnt32=0;
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==IDCON) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:152:10: markup
            	    {
            	    pushFollow(FOLLOW_markup_in_embed1186);
            	    markup138=markup();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, markup138.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt32 >= 1 ) break loop32;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
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
    // $ANTLR end "embed"

    public static class textTail_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "textTail"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:154:1: textTail : ( POSTTEXT | MIDTEXT embed textTail );
    public final WaebricTestParser.textTail_return textTail() throws RecognitionException {
        WaebricTestParser.textTail_return retval = new WaebricTestParser.textTail_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token POSTTEXT139=null;
        Token MIDTEXT140=null;
        WaebricTestParser.embed_return embed141 = null;

        WaebricTestParser.textTail_return textTail142 = null;


        Object POSTTEXT139_tree=null;
        Object MIDTEXT140_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:154:9: ( POSTTEXT | MIDTEXT embed textTail )
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:154:12: POSTTEXT
                    {
                    root_0 = (Object)adaptor.nil();

                    POSTTEXT139=(Token)match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail1196); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    POSTTEXT139_tree = (Object)adaptor.create(POSTTEXT139);
                    adaptor.addChild(root_0, POSTTEXT139_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricTest.g:155:6: MIDTEXT embed textTail
                    {
                    root_0 = (Object)adaptor.nil();

                    MIDTEXT140=(Token)match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail1204); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MIDTEXT140_tree = (Object)adaptor.create(MIDTEXT140);
                    adaptor.addChild(root_0, MIDTEXT140_tree);
                    }
                    pushFollow(FOLLOW_embed_in_textTail1206);
                    embed141=embed();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, embed141.getTree());
                    pushFollow(FOLLOW_textTail_in_textTail1208);
                    textTail142=textTail();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, textTail142.getTree());

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

    // Delegated rules


    protected DFA26 dfa26 = new DFA26(this);
    protected DFA27 dfa27 = new DFA27(this);
    static final String DFA26_eotS =
        "\13\uffff";
    static final String DFA26_eofS =
        "\13\uffff";
    static final String DFA26_minS =
        "\1\25\6\uffff\1\12\3\uffff";
    static final String DFA26_maxS =
        "\1\100\6\uffff\1\66\3\uffff";
    static final String DFA26_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\11\1\10\1\7";
    static final String DFA26_specialS =
        "\13\uffff}>";
    static final String[] DFA26_transitionS = {
            "\1\6\40\uffff\1\4\2\uffff\1\1\1\uffff\1\2\1\3\1\uffff\1\5\1"+
            "\7\1\10",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\12\1\uffff\3\12\1\uffff\1\11\43\uffff\1\12\1\uffff\1\12",
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
            return "116:1: regularStatement : ( 'if' '(' predicate ')' statement ( 'else' statement )? -> ^( 'if' predicate statement ( 'else' statement )? ) | 'each' '(' IDCON ':' expression ')' statement -> ^( 'each' '(' IDCON ':' expression ')' statement ) | 'let' ( assignment )+ 'in' ( statement )* 'end' -> ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | '{' ( statement )* '}' -> ^( '{' ( statement )* '}' ) | 'yield' ';' -> ^( 'yield' ) | 'comment' STRCON ';' -> ^( 'comment' STRCON ) | 'echo' expression ';' -> ^( 'echo' expression ) | 'echo' embedding ';' -> ^( 'echo' embedding ) | 'cdata' expression ';' -> ^( 'cdata' expression ) );";
        }
    }
    static final String DFA27_eotS =
        "\6\uffff";
    static final String DFA27_eofS =
        "\6\uffff";
    static final String DFA27_minS =
        "\2\12\1\uffff\1\12\1\uffff\1\12";
    static final String DFA27_maxS =
        "\1\66\1\70\1\uffff\1\12\1\uffff\1\70";
    static final String DFA27_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String DFA27_specialS =
        "\6\uffff}>";
    static final String[] DFA27_transitionS = {
            "\1\1\1\uffff\3\2\45\uffff\1\2\1\uffff\1\2",
            "\1\4\1\uffff\3\4\7\uffff\1\2\21\uffff\1\3\1\uffff\1\4\1\uffff"+
            "\1\4\2\uffff\3\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\2",
            "",
            "\1\5",
            "",
            "\1\4\1\uffff\3\4\7\uffff\1\2\21\uffff\1\3\1\uffff\1\4\1\uffff"+
            "\1\4\2\uffff\3\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\2"
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
            return "()+ loopback of 136:18: ( markup )+";
        }
    }
 

    public static final BitSet FOLLOW_39_in_module117 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_moduleId_in_module119 = new BitSet(new long[]{0x00000A0000080002L});
    public static final BitSet FOLLOW_imprt_in_module125 = new BitSet(new long[]{0x00000A0000080002L});
    public static final BitSet FOLLOW_site_in_module129 = new BitSet(new long[]{0x00000A0000080002L});
    public static final BitSet FOLLOW_function_in_module133 = new BitSet(new long[]{0x00000A0000080002L});
    public static final BitSet FOLLOW_IDCON_in_moduleId184 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_moduleId194 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_moduleId198 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_41_in_imprt214 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_moduleId_in_imprt216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SITE_in_site245 = new BitSet(new long[]{0x0000000000500800L});
    public static final BitSet FOLLOW_mappings_in_site247 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_END_in_site249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapping_in_mappings258 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_SEMICOLON_in_mappings263 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_mapping_in_mappings265 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_PATH_in_mapping278 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_mapping280 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_markup_in_mapping282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_function291 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_function293 = new BitSet(new long[]{0xDA40100000300400L,0x0000000000000001L});
    public static final BitSet FOLLOW_formals_in_function295 = new BitSet(new long[]{0xDA40000000300400L,0x0000000000000001L});
    public static final BitSet FOLLOW_statement_in_function298 = new BitSet(new long[]{0xDA40000000300400L,0x0000000000000001L});
    public static final BitSet FOLLOW_END_in_function301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_formals340 = new BitSet(new long[]{0x0000600000000400L});
    public static final BitSet FOLLOW_IDCON_in_formals342 = new BitSet(new long[]{0x0000600000000000L});
    public static final BitSet FOLLOW_45_in_formals347 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_formals349 = new BitSet(new long[]{0x0000600000000000L});
    public static final BitSet FOLLOW_46_in_formals354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_markup373 = new BitSet(new long[]{0x0003950000000000L});
    public static final BitSet FOLLOW_attributes_in_markup375 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_arguments_in_markup377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attribute_in_attributes410 = new BitSet(new long[]{0x0003850000000002L});
    public static final BitSet FOLLOW_47_in_attribute440 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_attribute442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_attribute450 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_attribute452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_attribute460 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_attribute462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_attribute470 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_attribute472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_attribute480 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_NATCON_in_attribute482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_attribute490 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_NATCON_in_attribute492 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_attribute494 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_NATCON_in_attribute496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_arguments509 = new BitSet(new long[]{0x0050600000007400L});
    public static final BitSet FOLLOW_argument_in_arguments511 = new BitSet(new long[]{0x0000600000000000L});
    public static final BitSet FOLLOW_45_in_arguments516 = new BitSet(new long[]{0x0050000000007400L});
    public static final BitSet FOLLOW_argument_in_arguments518 = new BitSet(new long[]{0x0000600000000000L});
    public static final BitSet FOLLOW_46_in_arguments523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_argument547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_argument568 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_argument570 = new BitSet(new long[]{0x0050000000007400L});
    public static final BitSet FOLLOW_expression_in_argument572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_regularStatement_in_statement600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markupStatement_in_statement607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_expression626 = new BitSet(new long[]{0x0100010000000002L});
    public static final BitSet FOLLOW_NATCON_in_expression630 = new BitSet(new long[]{0x0100010000000002L});
    public static final BitSet FOLLOW_TEXT_in_expression634 = new BitSet(new long[]{0x0100010000000002L});
    public static final BitSet FOLLOW_SYMBOLCON_in_expression638 = new BitSet(new long[]{0x0100010000000002L});
    public static final BitSet FOLLOW_52_in_expression647 = new BitSet(new long[]{0x0070200000007400L});
    public static final BitSet FOLLOW_expression_in_expression649 = new BitSet(new long[]{0x0020200000000000L});
    public static final BitSet FOLLOW_45_in_expression654 = new BitSet(new long[]{0x0050000000007400L});
    public static final BitSet FOLLOW_expression_in_expression656 = new BitSet(new long[]{0x0020200000000000L});
    public static final BitSet FOLLOW_53_in_expression661 = new BitSet(new long[]{0x0100010000000002L});
    public static final BitSet FOLLOW_54_in_expression670 = new BitSet(new long[]{0x0080200000000400L});
    public static final BitSet FOLLOW_keyValuePair_in_expression672 = new BitSet(new long[]{0x0080200000000000L});
    public static final BitSet FOLLOW_45_in_expression677 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_keyValuePair_in_expression679 = new BitSet(new long[]{0x0080200000000000L});
    public static final BitSet FOLLOW_55_in_expression684 = new BitSet(new long[]{0x0100010000000002L});
    public static final BitSet FOLLOW_56_in_expression694 = new BitSet(new long[]{0x0050000000007400L});
    public static final BitSet FOLLOW_expression_in_expression696 = new BitSet(new long[]{0x0100010000000002L});
    public static final BitSet FOLLOW_40_in_expression700 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_expression702 = new BitSet(new long[]{0x0100010000000002L});
    public static final BitSet FOLLOW_IDCON_in_keyValuePair717 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_keyValuePair719 = new BitSet(new long[]{0x0050000000007400L});
    public static final BitSet FOLLOW_expression_in_keyValuePair721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_regularStatement729 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_regularStatement731 = new BitSet(new long[]{0x0050000000007400L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_regularStatement733 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_regularStatement735 = new BitSet(new long[]{0xDA40000000200400L,0x0000000000000001L});
    public static final BitSet FOLLOW_statement_in_regularStatement737 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_58_in_regularStatement741 = new BitSet(new long[]{0xDA40000000200400L,0x0000000000000001L});
    public static final BitSet FOLLOW_statement_in_regularStatement743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_regularStatement778 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_regularStatement780 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_regularStatement782 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_regularStatement784 = new BitSet(new long[]{0x0050000000007400L});
    public static final BitSet FOLLOW_expression_in_regularStatement786 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_regularStatement788 = new BitSet(new long[]{0xDA40000000200400L,0x0000000000000001L});
    public static final BitSet FOLLOW_statement_in_regularStatement790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_regularStatement822 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_assignment_in_regularStatement824 = new BitSet(new long[]{0x2000000000000400L});
    public static final BitSet FOLLOW_61_in_regularStatement827 = new BitSet(new long[]{0xDA40000000300400L,0x0000000000000001L});
    public static final BitSet FOLLOW_statement_in_regularStatement829 = new BitSet(new long[]{0xDA40000000300400L,0x0000000000000001L});
    public static final BitSet FOLLOW_END_in_regularStatement832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_regularStatement861 = new BitSet(new long[]{0xDAC0000000200400L,0x0000000000000001L});
    public static final BitSet FOLLOW_statement_in_regularStatement863 = new BitSet(new long[]{0xDAC0000000200400L,0x0000000000000001L});
    public static final BitSet FOLLOW_55_in_regularStatement866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_regularStatement890 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_regularStatement892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMENT_in_regularStatement911 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_STRCON_in_regularStatement913 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_regularStatement915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_regularStatement936 = new BitSet(new long[]{0x0050000000007400L});
    public static final BitSet FOLLOW_expression_in_regularStatement938 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_regularStatement940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_regularStatement961 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_embedding_in_regularStatement963 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_regularStatement965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_regularStatement986 = new BitSet(new long[]{0x0050000000007400L});
    public static final BitSet FOLLOW_expression_in_regularStatement988 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_regularStatement990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_markupStatement1018 = new BitSet(new long[]{0x0050000000007400L});
    public static final BitSet FOLLOW_expression_in_markupStatement1027 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_markupStatement1031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_assignment1040 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_assignment1042 = new BitSet(new long[]{0x0050000000007400L});
    public static final BitSet FOLLOW_expression_in_assignment1044 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_assignment1046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_assignment1054 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_formals_in_assignment1056 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_assignment1058 = new BitSet(new long[]{0xDA40000000200400L,0x0000000000000001L});
    public static final BitSet FOLLOW_statement_in_assignment1060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_predicate1098 = new BitSet(new long[]{0x0050000000007400L,0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate1101 = new BitSet(new long[]{0x0000010000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_40_in_predicate1105 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_type_in_predicate1107 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_predicate1109 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_67_in_predicate1119 = new BitSet(new long[]{0x0050000000007400L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_predicate1121 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_68_in_predicate1125 = new BitSet(new long[]{0x0050000000007400L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_predicate1127 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding1172 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_embed_in_embedding1174 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_textTail_in_embedding1176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed1186 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail1196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail1204 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_embed_in_textTail1206 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_textTail_in_textTail1208 = new BitSet(new long[]{0x0000000000000002L});

}