// $ANTLR 3.1.2 /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g 2009-08-29 17:40:51

	package org.cwi.waebric;
	import java.util.ArrayList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class Waebric2Parser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATTRIBUTES", "ARGUMENTS", "MARKUP", "MARKUPS", "MARKUP_STATEMENT", "MARKUP_EXPRESSION", "MARKUP_EMBEDDING", "FORMALS", "IDCON", "PATH", "NATCON", "TEXT", "SYMBOLCON", "STRCON", "PRETEXT", "POSTTEXT", "MIDTEXT", "COMMENT", "SITE", "END", "SEMICOLON", "LETTER", "DIGIT", "HEXADECIMAL", "PATHELEMENT", "FILEEXT", "STRCHAR", "ESCLAYOUT", "DECIMAL", "TEXTCHAR", "ESCQUOTE", "AMP", "CHARREF", "ENTREF", "SYMBOLCHAR", "COMMENTS", "LAYOUT", "'module'", "'.'", "'import'", "':'", "'#'", "'$'", "'@'", "'%'", "'('", "','", "')'", "'='", "'['", "']'", "'{'", "'}'", "'+'", "'def'", "'if'", "'else'", "'each'", "'let'", "'in'", "'yield'", "'echo'", "'cdata'", "'!'", "'?'", "'&&'", "'||'", "'list'", "'record'", "'string'"
    };
    public static final int ESCLAYOUT=31;
    public static final int T__42=42;
    public static final int END=23;
    public static final int T__57=57;
    public static final int FILEEXT=29;
    public static final int T__51=51;
    public static final int T__47=47;
    public static final int T__69=69;
    public static final int T__73=73;
    public static final int STRCHAR=30;
    public static final int T__50=50;
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
    public static final int PATHELEMENT=28;
    public static final int T__56=56;
    public static final int ENTREF=37;
    public static final int LETTER=25;
    public static final int ARGUMENTS=5;
    public static final int SITE=22;
    public static final int T__58=58;
    public static final int T__64=64;
    public static final int T__44=44;
    public static final int SYMBOLCHAR=38;
    public static final int T__66=66;
    public static final int COMMENT=21;
    public static final int MARKUP_STATEMENT=8;
    public static final int FORMALS=11;
    public static final int T__55=55;
    public static final int T__45=45;
    public static final int CHARREF=36;
    public static final int MIDTEXT=20;
    public static final int T__63=63;
    public static final int PRETEXT=18;
    public static final int SEMICOLON=24;
    public static final int T__43=43;
    public static final int EOF=-1;
    public static final int T__53=53;
    public static final int TEXT=15;
    public static final int NATCON=14;
    public static final int T__60=60;
    public static final int T__41=41;
    public static final int T__71=71;
    public static final int MARKUP_EMBEDDING=10;
    public static final int PATH=13;

    // delegates
    // delegators


        public Waebric2Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public Waebric2Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return Waebric2Parser.tokenNames; }
    public String getGrammarFileName() { return "/Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g"; }


    	/**
    	 * Parsed modules
    	 */
    	private ArrayList<String> modules = new ArrayList<String>();

    	public Waebric2Parser(TokenStream input, ArrayList<String> modules) {
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
    			Waebric2Lexer lexer = new Waebric2Lexer(is);
    			CommonTokenStream tokens = new CommonTokenStream(lexer);
          			Waebric2Parser parser = new Waebric2Parser(tokens, modules);
          			return (CommonTree) parser.module().getTree();
          		} catch(java.io.IOException e) { return new CommonTree(); }
    	}


    public static class module_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "module"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:63:1: module : 'module' moduleId ( imprt | site | function )* -> ^( 'module' moduleId ( imprt )* ( site )* ( function )* ) ;
    public final Waebric2Parser.module_return module() throws RecognitionException {
        Waebric2Parser.module_return retval = new Waebric2Parser.module_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal1=null;
        Waebric2Parser.moduleId_return moduleId2 = null;

        Waebric2Parser.imprt_return imprt3 = null;

        Waebric2Parser.site_return site4 = null;

        Waebric2Parser.function_return function5 = null;


        Object string_literal1_tree=null;
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleSubtreeStream stream_imprt=new RewriteRuleSubtreeStream(adaptor,"rule imprt");
        RewriteRuleSubtreeStream stream_site=new RewriteRuleSubtreeStream(adaptor,"rule site");
        RewriteRuleSubtreeStream stream_moduleId=new RewriteRuleSubtreeStream(adaptor,"rule moduleId");
        RewriteRuleSubtreeStream stream_function=new RewriteRuleSubtreeStream(adaptor,"rule function");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:63:7: ( 'module' moduleId ( imprt | site | function )* -> ^( 'module' moduleId ( imprt )* ( site )* ( function )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:63:11: 'module' moduleId ( imprt | site | function )*
            {
            string_literal1=(Token)match(input,41,FOLLOW_41_in_module146); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_41.add(string_literal1);

            pushFollow(FOLLOW_moduleId_in_module148);
            moduleId2=moduleId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_moduleId.add(moduleId2.getTree());
            if ( state.backtracking==0 ) {
               modules.add((moduleId2!=null?moduleId2.path:null)); 
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:63:62: ( imprt | site | function )*
            loop1:
            do {
                int alt1=4;
                switch ( input.LA(1) ) {
                case 43:
                    {
                    alt1=1;
                    }
                    break;
                case SITE:
                    {
                    alt1=2;
                    }
                    break;
                case 58:
                    {
                    alt1=3;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:63:64: imprt
            	    {
            	    pushFollow(FOLLOW_imprt_in_module154);
            	    imprt3=imprt();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_imprt.add(imprt3.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:63:72: site
            	    {
            	    pushFollow(FOLLOW_site_in_module158);
            	    site4=site();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_site.add(site4.getTree());

            	    }
            	    break;
            	case 3 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:63:79: function
            	    {
            	    pushFollow(FOLLOW_function_in_module162);
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
            // elements: 41, imprt, moduleId, site, function
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 64:5: -> ^( 'module' moduleId ( imprt )* ( site )* ( function )* )
            {
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:64:8: ^( 'module' moduleId ( imprt )* ( site )* ( function )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_41.nextNode(), root_1);

                adaptor.addChild(root_1, stream_moduleId.nextTree());
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:64:29: ( imprt )*
                while ( stream_imprt.hasNext() ) {
                    adaptor.addChild(root_1, stream_imprt.nextTree());

                }
                stream_imprt.reset();
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:64:36: ( site )*
                while ( stream_site.hasNext() ) {
                    adaptor.addChild(root_1, stream_site.nextTree());

                }
                stream_site.reset();
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:64:42: ( function )*
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:66:1: moduleId returns [String path = \"\"] : e= IDCON ( '.' e= IDCON )* ;
    public final Waebric2Parser.moduleId_return moduleId() throws RecognitionException {
        Waebric2Parser.moduleId_return retval = new Waebric2Parser.moduleId_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token e=null;
        Token char_literal6=null;

        Object e_tree=null;
        Object char_literal6_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:69:2: (e= IDCON ( '.' e= IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:69:5: e= IDCON ( '.' e= IDCON )*
            {
            root_0 = (Object)adaptor.nil();

            e=(Token)match(input,IDCON,FOLLOW_IDCON_in_moduleId214); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            e_tree = (Object)adaptor.create(e);
            adaptor.addChild(root_0, e_tree);
            }
            if ( state.backtracking==0 ) {
               retval.path += e.getText(); 
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:70:4: ( '.' e= IDCON )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==42) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:70:6: '.' e= IDCON
            	    {
            	    char_literal6=(Token)match(input,42,FOLLOW_42_in_moduleId224); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal6_tree = (Object)adaptor.create(char_literal6);
            	    adaptor.addChild(root_0, char_literal6_tree);
            	    }
            	    e=(Token)match(input,IDCON,FOLLOW_IDCON_in_moduleId228); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:72:1: imprt : 'import' moduleId -> 'import' moduleId ^() ;
    public final Waebric2Parser.imprt_return imprt() throws RecognitionException {
        Waebric2Parser.imprt_return retval = new Waebric2Parser.imprt_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal7=null;
        Waebric2Parser.moduleId_return moduleId8 = null;


        Object string_literal7_tree=null;
        RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
        RewriteRuleSubtreeStream stream_moduleId=new RewriteRuleSubtreeStream(adaptor,"rule moduleId");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:72:6: ( 'import' moduleId -> 'import' moduleId ^() )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:72:10: 'import' moduleId
            {
            string_literal7=(Token)match(input,43,FOLLOW_43_in_imprt244); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_43.add(string_literal7);

            pushFollow(FOLLOW_moduleId_in_imprt246);
            moduleId8=moduleId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_moduleId.add(moduleId8.getTree());
            if ( state.backtracking==0 ) {
               if(modules.contains((moduleId8!=null?moduleId8.path:null))) { return retval; } 
            }


            // AST REWRITE
            // elements: 43, moduleId
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 73:5: -> 'import' moduleId ^()
            {
                adaptor.addChild(root_0, stream_43.nextNode());
                adaptor.addChild(root_0, stream_moduleId.nextTree());
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:73:26: ^()
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:78:1: site : 'site' mappings 'end' ;
    public final Waebric2Parser.site_return site() throws RecognitionException {
        Waebric2Parser.site_return retval = new Waebric2Parser.site_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal9=null;
        Token string_literal11=null;
        Waebric2Parser.mappings_return mappings10 = null;


        Object string_literal9_tree=null;
        Object string_literal11_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:78:5: ( 'site' mappings 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:78:9: 'site' mappings 'end'
            {
            root_0 = (Object)adaptor.nil();

            string_literal9=(Token)match(input,SITE,FOLLOW_SITE_in_site278); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal9_tree = (Object)adaptor.create(string_literal9);
            adaptor.addChild(root_0, string_literal9_tree);
            }
            pushFollow(FOLLOW_mappings_in_site280);
            mappings10=mappings();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mappings10.getTree());
            string_literal11=(Token)match(input,END,FOLLOW_END_in_site282); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:79:1: mappings : ( mapping )? ( ';' mapping )* ;
    public final Waebric2Parser.mappings_return mappings() throws RecognitionException {
        Waebric2Parser.mappings_return retval = new Waebric2Parser.mappings_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal13=null;
        Waebric2Parser.mapping_return mapping12 = null;

        Waebric2Parser.mapping_return mapping14 = null;


        Object char_literal13_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:79:9: ( ( mapping )? ( ';' mapping )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:79:12: ( mapping )? ( ';' mapping )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:79:12: ( mapping )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==PATH) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:0:0: mapping
                    {
                    pushFollow(FOLLOW_mapping_in_mappings290);
                    mapping12=mapping();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, mapping12.getTree());

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:79:21: ( ';' mapping )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==SEMICOLON) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:79:23: ';' mapping
            	    {
            	    char_literal13=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_mappings295); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal13_tree = (Object)adaptor.create(char_literal13);
            	    adaptor.addChild(root_0, char_literal13_tree);
            	    }
            	    pushFollow(FOLLOW_mapping_in_mappings297);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:80:1: mapping : PATH ':' markup ;
    public final Waebric2Parser.mapping_return mapping() throws RecognitionException {
        Waebric2Parser.mapping_return retval = new Waebric2Parser.mapping_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PATH15=null;
        Token char_literal16=null;
        Waebric2Parser.markup_return markup17 = null;


        Object PATH15_tree=null;
        Object char_literal16_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:80:9: ( PATH ':' markup )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:80:12: PATH ':' markup
            {
            root_0 = (Object)adaptor.nil();

            PATH15=(Token)match(input,PATH,FOLLOW_PATH_in_mapping309); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PATH15_tree = (Object)adaptor.create(PATH15);
            adaptor.addChild(root_0, PATH15_tree);
            }
            char_literal16=(Token)match(input,44,FOLLOW_44_in_mapping311); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal16_tree = (Object)adaptor.create(char_literal16);
            adaptor.addChild(root_0, char_literal16_tree);
            }
            pushFollow(FOLLOW_markup_in_mapping313);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:85:1: markup : IDCON attributes arguments -> ^( MARKUP IDCON attributes arguments ) ;
    public final Waebric2Parser.markup_return markup() throws RecognitionException {
        Waebric2Parser.markup_return retval = new Waebric2Parser.markup_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDCON18=null;
        Waebric2Parser.attributes_return attributes19 = null;

        Waebric2Parser.arguments_return arguments20 = null;


        Object IDCON18_tree=null;
        RewriteRuleTokenStream stream_IDCON=new RewriteRuleTokenStream(adaptor,"token IDCON");
        RewriteRuleSubtreeStream stream_arguments=new RewriteRuleSubtreeStream(adaptor,"rule arguments");
        RewriteRuleSubtreeStream stream_attributes=new RewriteRuleSubtreeStream(adaptor,"rule attributes");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:85:7: ( IDCON attributes arguments -> ^( MARKUP IDCON attributes arguments ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:85:11: IDCON attributes arguments
            {
            IDCON18=(Token)match(input,IDCON,FOLLOW_IDCON_in_markup326); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDCON.add(IDCON18);

            pushFollow(FOLLOW_attributes_in_markup328);
            attributes19=attributes();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_attributes.add(attributes19.getTree());
            pushFollow(FOLLOW_arguments_in_markup330);
            arguments20=arguments();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_arguments.add(arguments20.getTree());


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
            // 86:5: -> ^( MARKUP IDCON attributes arguments )
            {
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:86:8: ^( MARKUP IDCON attributes arguments )
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:88:1: attributes : ( attribute )* -> ^( ATTRIBUTES ( attribute )* ) ;
    public final Waebric2Parser.attributes_return attributes() throws RecognitionException {
        Waebric2Parser.attributes_return retval = new Waebric2Parser.attributes_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Waebric2Parser.attribute_return attribute21 = null;


        RewriteRuleSubtreeStream stream_attribute=new RewriteRuleSubtreeStream(adaptor,"rule attribute");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:88:11: ( ( attribute )* -> ^( ATTRIBUTES ( attribute )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:88:14: ( attribute )*
            {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:88:14: ( attribute )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==42||(LA5_0>=44 && LA5_0<=47)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:0:0: attribute
            	    {
            	    pushFollow(FOLLOW_attribute_in_attributes361);
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
            // 89:5: -> ^( ATTRIBUTES ( attribute )* )
            {
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:89:8: ^( ATTRIBUTES ( attribute )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ATTRIBUTES, "ATTRIBUTES"), root_1);

                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:89:22: ( attribute )*
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:91:1: attribute : ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON );
    public final Waebric2Parser.attribute_return attribute() throws RecognitionException {
        Waebric2Parser.attribute_return retval = new Waebric2Parser.attribute_return();
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:91:10: ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON )
            int alt6=6;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt6=1;
                }
                break;
            case 42:
                {
                alt6=2;
                }
                break;
            case 46:
                {
                alt6=3;
                }
                break;
            case 44:
                {
                alt6=4;
                }
                break;
            case 47:
                {
                int LA6_5 = input.LA(2);

                if ( (LA6_5==NATCON) ) {
                    int LA6_6 = input.LA(3);

                    if ( (LA6_6==48) ) {
                        alt6=6;
                    }
                    else if ( (LA6_6==EOF||LA6_6==IDCON||(LA6_6>=NATCON && LA6_6<=SYMBOLCON)||(LA6_6>=PRETEXT && LA6_6<=COMMENT)||(LA6_6>=END && LA6_6<=SEMICOLON)||LA6_6==42||(LA6_6>=44 && LA6_6<=47)||LA6_6==49||LA6_6==53||LA6_6==55||LA6_6==59||(LA6_6>=61 && LA6_6<=62)||(LA6_6>=64 && LA6_6<=66)) ) {
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:91:13: '#' IDCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal22=(Token)match(input,45,FOLLOW_45_in_attribute387); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal22_tree = (Object)adaptor.create(char_literal22);
                    adaptor.addChild(root_0, char_literal22_tree);
                    }
                    IDCON23=(Token)match(input,IDCON,FOLLOW_IDCON_in_attribute389); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON23_tree = (Object)adaptor.create(IDCON23);
                    adaptor.addChild(root_0, IDCON23_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:92:6: '.' IDCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal24=(Token)match(input,42,FOLLOW_42_in_attribute397); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal24_tree = (Object)adaptor.create(char_literal24);
                    adaptor.addChild(root_0, char_literal24_tree);
                    }
                    IDCON25=(Token)match(input,IDCON,FOLLOW_IDCON_in_attribute399); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON25_tree = (Object)adaptor.create(IDCON25);
                    adaptor.addChild(root_0, IDCON25_tree);
                    }

                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:93:6: '$' IDCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal26=(Token)match(input,46,FOLLOW_46_in_attribute407); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal26_tree = (Object)adaptor.create(char_literal26);
                    adaptor.addChild(root_0, char_literal26_tree);
                    }
                    IDCON27=(Token)match(input,IDCON,FOLLOW_IDCON_in_attribute409); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON27_tree = (Object)adaptor.create(IDCON27);
                    adaptor.addChild(root_0, IDCON27_tree);
                    }

                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:94:6: ':' IDCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal28=(Token)match(input,44,FOLLOW_44_in_attribute417); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal28_tree = (Object)adaptor.create(char_literal28);
                    adaptor.addChild(root_0, char_literal28_tree);
                    }
                    IDCON29=(Token)match(input,IDCON,FOLLOW_IDCON_in_attribute419); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON29_tree = (Object)adaptor.create(IDCON29);
                    adaptor.addChild(root_0, IDCON29_tree);
                    }

                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:95:6: '@' NATCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal30=(Token)match(input,47,FOLLOW_47_in_attribute427); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal30_tree = (Object)adaptor.create(char_literal30);
                    adaptor.addChild(root_0, char_literal30_tree);
                    }
                    NATCON31=(Token)match(input,NATCON,FOLLOW_NATCON_in_attribute429); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON31_tree = (Object)adaptor.create(NATCON31);
                    adaptor.addChild(root_0, NATCON31_tree);
                    }

                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:96:6: '@' NATCON '%' NATCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal32=(Token)match(input,47,FOLLOW_47_in_attribute437); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal32_tree = (Object)adaptor.create(char_literal32);
                    adaptor.addChild(root_0, char_literal32_tree);
                    }
                    NATCON33=(Token)match(input,NATCON,FOLLOW_NATCON_in_attribute439); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON33_tree = (Object)adaptor.create(NATCON33);
                    adaptor.addChild(root_0, NATCON33_tree);
                    }
                    char_literal34=(Token)match(input,48,FOLLOW_48_in_attribute441); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal34_tree = (Object)adaptor.create(char_literal34);
                    adaptor.addChild(root_0, char_literal34_tree);
                    }
                    NATCON35=(Token)match(input,NATCON,FOLLOW_NATCON_in_attribute443); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:98:1: arguments : ( '(' ( argument )? ( ',' argument )* ')' )? -> ^( ARGUMENTS ( argument )* ) ;
    public final Waebric2Parser.arguments_return arguments() throws RecognitionException {
        Waebric2Parser.arguments_return retval = new Waebric2Parser.arguments_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal36=null;
        Token char_literal38=null;
        Token char_literal40=null;
        Waebric2Parser.argument_return argument37 = null;

        Waebric2Parser.argument_return argument39 = null;


        Object char_literal36_tree=null;
        Object char_literal38_tree=null;
        Object char_literal40_tree=null;
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
        RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleSubtreeStream stream_argument=new RewriteRuleSubtreeStream(adaptor,"rule argument");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:98:10: ( ( '(' ( argument )? ( ',' argument )* ')' )? -> ^( ARGUMENTS ( argument )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:98:13: ( '(' ( argument )? ( ',' argument )* ')' )?
            {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:98:13: ( '(' ( argument )? ( ',' argument )* ')' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==49) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:98:15: '(' ( argument )? ( ',' argument )* ')'
                    {
                    char_literal36=(Token)match(input,49,FOLLOW_49_in_arguments457); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_49.add(char_literal36);

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:98:19: ( argument )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==IDCON||(LA7_0>=NATCON && LA7_0<=SYMBOLCON)||LA7_0==53||LA7_0==55) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:0:0: argument
                            {
                            pushFollow(FOLLOW_argument_in_arguments459);
                            argument37=argument();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_argument.add(argument37.getTree());

                            }
                            break;

                    }

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:98:29: ( ',' argument )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==50) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:98:31: ',' argument
                    	    {
                    	    char_literal38=(Token)match(input,50,FOLLOW_50_in_arguments464); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_50.add(char_literal38);

                    	    pushFollow(FOLLOW_argument_in_arguments466);
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

                    char_literal40=(Token)match(input,51,FOLLOW_51_in_arguments471); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_51.add(char_literal40);


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
            // 99:5: -> ^( ARGUMENTS ( argument )* )
            {
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:99:8: ^( ARGUMENTS ( argument )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARGUMENTS, "ARGUMENTS"), root_1);

                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:99:21: ( argument )*
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:101:1: argument : ( expression | IDCON '=' expression );
    public final Waebric2Parser.argument_return argument() throws RecognitionException {
        Waebric2Parser.argument_return retval = new Waebric2Parser.argument_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDCON42=null;
        Token char_literal43=null;
        Waebric2Parser.expression_return expression41 = null;

        Waebric2Parser.expression_return expression44 = null;


        Object IDCON42_tree=null;
        Object char_literal43_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:101:9: ( expression | IDCON '=' expression )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==IDCON) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==52) ) {
                    alt10=2;
                }
                else if ( (LA10_1==EOF||LA10_1==42||(LA10_1>=50 && LA10_1<=51)||LA10_1==57) ) {
                    alt10=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA10_0>=NATCON && LA10_0<=SYMBOLCON)||LA10_0==53||LA10_0==55) ) {
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:101:12: expression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_expression_in_argument502);
                    expression41=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression41.getTree());

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:102:6: IDCON '=' expression
                    {
                    root_0 = (Object)adaptor.nil();

                    IDCON42=(Token)match(input,IDCON,FOLLOW_IDCON_in_argument510); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON42_tree = (Object)adaptor.create(IDCON42);
                    adaptor.addChild(root_0, IDCON42_tree);
                    }
                    char_literal43=(Token)match(input,52,FOLLOW_52_in_argument512); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal43_tree = (Object)adaptor.create(char_literal43);
                    adaptor.addChild(root_0, char_literal43_tree);
                    }
                    pushFollow(FOLLOW_expression_in_argument514);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:107:1: expression : ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* ;
    public final Waebric2Parser.expression_return expression() throws RecognitionException {
        Waebric2Parser.expression_return retval = new Waebric2Parser.expression_return();
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
        Waebric2Parser.expression_return expression50 = null;

        Waebric2Parser.expression_return expression52 = null;

        Waebric2Parser.keyValuePair_return keyValuePair55 = null;

        Waebric2Parser.keyValuePair_return keyValuePair57 = null;

        Waebric2Parser.expression_return expression60 = null;


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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:107:11: ( ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:107:14: ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:107:14: ( IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' )
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
            case 53:
                {
                alt15=5;
                }
                break;
            case 55:
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:107:16: IDCON
                    {
                    IDCON45=(Token)match(input,IDCON,FOLLOW_IDCON_in_expression528); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON45_tree = (Object)adaptor.create(IDCON45);
                    adaptor.addChild(root_0, IDCON45_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:107:24: NATCON
                    {
                    NATCON46=(Token)match(input,NATCON,FOLLOW_NATCON_in_expression532); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON46_tree = (Object)adaptor.create(NATCON46);
                    adaptor.addChild(root_0, NATCON46_tree);
                    }

                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:107:33: TEXT
                    {
                    TEXT47=(Token)match(input,TEXT,FOLLOW_TEXT_in_expression536); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TEXT47_tree = (Object)adaptor.create(TEXT47);
                    adaptor.addChild(root_0, TEXT47_tree);
                    }

                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:107:40: SYMBOLCON
                    {
                    SYMBOLCON48=(Token)match(input,SYMBOLCON,FOLLOW_SYMBOLCON_in_expression540); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SYMBOLCON48_tree = (Object)adaptor.create(SYMBOLCON48);
                    adaptor.addChild(root_0, SYMBOLCON48_tree);
                    }

                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:108:7: '[' ( expression )? ( ',' expression )* ']'
                    {
                    char_literal49=(Token)match(input,53,FOLLOW_53_in_expression549); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal49_tree = (Object)adaptor.create(char_literal49);
                    adaptor.addChild(root_0, char_literal49_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:108:11: ( expression )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==IDCON||(LA11_0>=NATCON && LA11_0<=SYMBOLCON)||LA11_0==53||LA11_0==55) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:0:0: expression
                            {
                            pushFollow(FOLLOW_expression_in_expression551);
                            expression50=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression50.getTree());

                            }
                            break;

                    }

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:108:23: ( ',' expression )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==50) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:108:25: ',' expression
                    	    {
                    	    char_literal51=(Token)match(input,50,FOLLOW_50_in_expression556); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal51_tree = (Object)adaptor.create(char_literal51);
                    	    adaptor.addChild(root_0, char_literal51_tree);
                    	    }
                    	    pushFollow(FOLLOW_expression_in_expression558);
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

                    char_literal53=(Token)match(input,54,FOLLOW_54_in_expression563); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal53_tree = (Object)adaptor.create(char_literal53);
                    adaptor.addChild(root_0, char_literal53_tree);
                    }

                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:109:7: '{' ( keyValuePair )? ( ',' keyValuePair )* '}'
                    {
                    char_literal54=(Token)match(input,55,FOLLOW_55_in_expression572); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal54_tree = (Object)adaptor.create(char_literal54);
                    adaptor.addChild(root_0, char_literal54_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:109:11: ( keyValuePair )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==IDCON) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:0:0: keyValuePair
                            {
                            pushFollow(FOLLOW_keyValuePair_in_expression574);
                            keyValuePair55=keyValuePair();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, keyValuePair55.getTree());

                            }
                            break;

                    }

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:109:25: ( ',' keyValuePair )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==50) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:109:27: ',' keyValuePair
                    	    {
                    	    char_literal56=(Token)match(input,50,FOLLOW_50_in_expression579); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal56_tree = (Object)adaptor.create(char_literal56);
                    	    adaptor.addChild(root_0, char_literal56_tree);
                    	    }
                    	    pushFollow(FOLLOW_keyValuePair_in_expression581);
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

                    char_literal58=(Token)match(input,56,FOLLOW_56_in_expression586); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal58_tree = (Object)adaptor.create(char_literal58);
                    adaptor.addChild(root_0, char_literal58_tree);
                    }

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:110:6: ( '+' expression | '.' IDCON )*
            loop16:
            do {
                int alt16=3;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==57) ) {
                    int LA16_2 = input.LA(2);

                    if ( (synpred26_Waebric2()) ) {
                        alt16=1;
                    }


                }
                else if ( (LA16_0==42) ) {
                    int LA16_3 = input.LA(2);

                    if ( (synpred27_Waebric2()) ) {
                        alt16=2;
                    }


                }


                switch (alt16) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:110:8: '+' expression
            	    {
            	    char_literal59=(Token)match(input,57,FOLLOW_57_in_expression596); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal59_tree = (Object)adaptor.create(char_literal59);
            	    adaptor.addChild(root_0, char_literal59_tree);
            	    }
            	    pushFollow(FOLLOW_expression_in_expression598);
            	    expression60=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression60.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:110:35: '.' IDCON
            	    {
            	    char_literal61=(Token)match(input,42,FOLLOW_42_in_expression604); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal61_tree = (Object)adaptor.create(char_literal61);
            	    adaptor.addChild(root_0, char_literal61_tree);
            	    }
            	    IDCON62=(Token)match(input,IDCON,FOLLOW_IDCON_in_expression606); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:111:1: keyValuePair : IDCON ':' expression ;
    public final Waebric2Parser.keyValuePair_return keyValuePair() throws RecognitionException {
        Waebric2Parser.keyValuePair_return retval = new Waebric2Parser.keyValuePair_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDCON63=null;
        Token char_literal64=null;
        Waebric2Parser.expression_return expression65 = null;


        Object IDCON63_tree=null;
        Object char_literal64_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:111:13: ( IDCON ':' expression )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:111:16: IDCON ':' expression
            {
            root_0 = (Object)adaptor.nil();

            IDCON63=(Token)match(input,IDCON,FOLLOW_IDCON_in_keyValuePair619); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON63_tree = (Object)adaptor.create(IDCON63);
            adaptor.addChild(root_0, IDCON63_tree);
            }
            char_literal64=(Token)match(input,44,FOLLOW_44_in_keyValuePair621); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal64_tree = (Object)adaptor.create(char_literal64);
            adaptor.addChild(root_0, char_literal64_tree);
            }
            pushFollow(FOLLOW_expression_in_keyValuePair623);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:116:1: function : 'def' IDCON ( formals )? ( statement )* 'end' -> ^( 'def' IDCON ^( FORMALS ( formals )? ) ( statement )* ) ;
    public final Waebric2Parser.function_return function() throws RecognitionException {
        Waebric2Parser.function_return retval = new Waebric2Parser.function_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal66=null;
        Token IDCON67=null;
        Token string_literal70=null;
        Waebric2Parser.formals_return formals68 = null;

        Waebric2Parser.statement_return statement69 = null;


        Object string_literal66_tree=null;
        Object IDCON67_tree=null;
        Object string_literal70_tree=null;
        RewriteRuleTokenStream stream_END=new RewriteRuleTokenStream(adaptor,"token END");
        RewriteRuleTokenStream stream_IDCON=new RewriteRuleTokenStream(adaptor,"token IDCON");
        RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
        RewriteRuleSubtreeStream stream_formals=new RewriteRuleSubtreeStream(adaptor,"rule formals");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:116:9: ( 'def' IDCON ( formals )? ( statement )* 'end' -> ^( 'def' IDCON ^( FORMALS ( formals )? ) ( statement )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:116:12: 'def' IDCON ( formals )? ( statement )* 'end'
            {
            string_literal66=(Token)match(input,58,FOLLOW_58_in_function635); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_58.add(string_literal66);

            IDCON67=(Token)match(input,IDCON,FOLLOW_IDCON_in_function637); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDCON.add(IDCON67);

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:116:24: ( formals )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==49) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:0:0: formals
                    {
                    pushFollow(FOLLOW_formals_in_function639);
                    formals68=formals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_formals.add(formals68.getTree());

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:116:33: ( statement )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==IDCON||LA18_0==COMMENT||LA18_0==55||LA18_0==59||(LA18_0>=61 && LA18_0<=62)||(LA18_0>=64 && LA18_0<=66)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:0:0: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_function642);
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

            string_literal70=(Token)match(input,END,FOLLOW_END_in_function645); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_END.add(string_literal70);



            // AST REWRITE
            // elements: statement, formals, 58, IDCON
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 117:5: -> ^( 'def' IDCON ^( FORMALS ( formals )? ) ( statement )* )
            {
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:117:8: ^( 'def' IDCON ^( FORMALS ( formals )? ) ( statement )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_58.nextNode(), root_1);

                adaptor.addChild(root_1, stream_IDCON.nextNode());
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:117:23: ^( FORMALS ( formals )? )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(FORMALS, "FORMALS"), root_2);

                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:117:34: ( formals )?
                if ( stream_formals.hasNext() ) {
                    adaptor.addChild(root_2, stream_formals.nextTree());

                }
                stream_formals.reset();

                adaptor.addChild(root_1, root_2);
                }
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:117:45: ( statement )*
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:119:1: formals : '(' ( IDCON )? ( ',' IDCON )* ')' -> ( IDCON )* ;
    public final Waebric2Parser.formals_return formals() throws RecognitionException {
        Waebric2Parser.formals_return retval = new Waebric2Parser.formals_return();
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
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
        RewriteRuleTokenStream stream_IDCON=new RewriteRuleTokenStream(adaptor,"token IDCON");
        RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:119:8: ( '(' ( IDCON )? ( ',' IDCON )* ')' -> ( IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:119:11: '(' ( IDCON )? ( ',' IDCON )* ')'
            {
            char_literal71=(Token)match(input,49,FOLLOW_49_in_formals682); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_49.add(char_literal71);

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:119:15: ( IDCON )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==IDCON) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:0:0: IDCON
                    {
                    IDCON72=(Token)match(input,IDCON,FOLLOW_IDCON_in_formals684); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDCON.add(IDCON72);


                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:119:22: ( ',' IDCON )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==50) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:119:24: ',' IDCON
            	    {
            	    char_literal73=(Token)match(input,50,FOLLOW_50_in_formals689); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_50.add(char_literal73);

            	    IDCON74=(Token)match(input,IDCON,FOLLOW_IDCON_in_formals691); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_IDCON.add(IDCON74);


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            char_literal75=(Token)match(input,51,FOLLOW_51_in_formals696); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_51.add(char_literal75);



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
            // 120:5: -> ( IDCON )*
            {
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:120:8: ( IDCON )*
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:126:1: statement : ( regularStatement | markupStatement );
    public final Waebric2Parser.statement_return statement() throws RecognitionException {
        Waebric2Parser.statement_return retval = new Waebric2Parser.statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Waebric2Parser.regularStatement_return regularStatement76 = null;

        Waebric2Parser.markupStatement_return markupStatement77 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:126:10: ( regularStatement | markupStatement )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==COMMENT||LA21_0==55||LA21_0==59||(LA21_0>=61 && LA21_0<=62)||(LA21_0>=64 && LA21_0<=66)) ) {
                alt21=1;
            }
            else if ( (LA21_0==IDCON) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:126:13: regularStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_regularStatement_in_statement718);
                    regularStatement76=regularStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, regularStatement76.getTree());

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:127:6: markupStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_markupStatement_in_statement725);
                    markupStatement77=markupStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, markupStatement77.getTree());

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

    public static class regularStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "regularStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:130:1: regularStatement : ( 'if' '(' predicate ')' statement ( 'else' statement )? -> ^( 'if' predicate statement ( 'else' statement )? ) | 'each' '(' IDCON ':' expression ')' statement -> ^( 'each' '(' IDCON ':' expression ')' statement ) | 'let' ( assignment )+ 'in' ( statement )* 'end' -> ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | '{' ( statement )* '}' -> ^( '{' ( statement )* '}' ) | 'yield' ';' -> ^( 'yield' ) | 'comment' STRCON ';' -> ^( 'comment' STRCON ) | 'echo' expression ';' -> ^( 'echo' expression ) | 'echo' embedding ';' -> ^( 'echo' embedding ) | 'cdata' expression ';' -> ^( 'cdata' expression ) );
    public final Waebric2Parser.regularStatement_return regularStatement() throws RecognitionException {
        Waebric2Parser.regularStatement_return retval = new Waebric2Parser.regularStatement_return();
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
        Waebric2Parser.predicate_return predicate80 = null;

        Waebric2Parser.statement_return statement82 = null;

        Waebric2Parser.statement_return statement84 = null;

        Waebric2Parser.expression_return expression89 = null;

        Waebric2Parser.statement_return statement91 = null;

        Waebric2Parser.assignment_return assignment93 = null;

        Waebric2Parser.statement_return statement95 = null;

        Waebric2Parser.statement_return statement98 = null;

        Waebric2Parser.expression_return expression106 = null;

        Waebric2Parser.embedding_return embedding109 = null;

        Waebric2Parser.expression_return expression112 = null;


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
        RewriteRuleTokenStream stream_STRCON=new RewriteRuleTokenStream(adaptor,"token STRCON");
        RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
        RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
        RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
        RewriteRuleTokenStream stream_COMMENT=new RewriteRuleTokenStream(adaptor,"token COMMENT");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
        RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
        RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
        RewriteRuleTokenStream stream_IDCON=new RewriteRuleTokenStream(adaptor,"token IDCON");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
        RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_assignment=new RewriteRuleSubtreeStream(adaptor,"rule assignment");
        RewriteRuleSubtreeStream stream_embedding=new RewriteRuleSubtreeStream(adaptor,"rule embedding");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_predicate=new RewriteRuleSubtreeStream(adaptor,"rule predicate");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:130:17: ( 'if' '(' predicate ')' statement ( 'else' statement )? -> ^( 'if' predicate statement ( 'else' statement )? ) | 'each' '(' IDCON ':' expression ')' statement -> ^( 'each' '(' IDCON ':' expression ')' statement ) | 'let' ( assignment )+ 'in' ( statement )* 'end' -> ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | '{' ( statement )* '}' -> ^( '{' ( statement )* '}' ) | 'yield' ';' -> ^( 'yield' ) | 'comment' STRCON ';' -> ^( 'comment' STRCON ) | 'echo' expression ';' -> ^( 'echo' expression ) | 'echo' embedding ';' -> ^( 'echo' embedding ) | 'cdata' expression ';' -> ^( 'cdata' expression ) )
            int alt26=9;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:130:19: 'if' '(' predicate ')' statement ( 'else' statement )?
                    {
                    string_literal78=(Token)match(input,59,FOLLOW_59_in_regularStatement738); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_59.add(string_literal78);

                    char_literal79=(Token)match(input,49,FOLLOW_49_in_regularStatement740); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_49.add(char_literal79);

                    pushFollow(FOLLOW_predicate_in_regularStatement742);
                    predicate80=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_predicate.add(predicate80.getTree());
                    char_literal81=(Token)match(input,51,FOLLOW_51_in_regularStatement744); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_51.add(char_literal81);

                    pushFollow(FOLLOW_statement_in_regularStatement746);
                    statement82=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement82.getTree());
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:130:52: ( 'else' statement )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==60) ) {
                        int LA22_1 = input.LA(2);

                        if ( (synpred33_Waebric2()) ) {
                            alt22=1;
                        }
                    }
                    switch (alt22) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:130:54: 'else' statement
                            {
                            string_literal83=(Token)match(input,60,FOLLOW_60_in_regularStatement750); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_60.add(string_literal83);

                            pushFollow(FOLLOW_statement_in_regularStatement752);
                            statement84=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_statement.add(statement84.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: statement, 60, 59, statement, predicate
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 131:5: -> ^( 'if' predicate statement ( 'else' statement )? )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:131:8: ^( 'if' predicate statement ( 'else' statement )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_59.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_predicate.nextTree());
                        adaptor.addChild(root_1, stream_statement.nextTree());
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:131:36: ( 'else' statement )?
                        if ( stream_60.hasNext()||stream_statement.hasNext() ) {
                            adaptor.addChild(root_1, stream_60.nextNode());
                            adaptor.addChild(root_1, stream_statement.nextTree());

                        }
                        stream_60.reset();
                        stream_statement.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:132:6: 'each' '(' IDCON ':' expression ')' statement
                    {
                    string_literal85=(Token)match(input,61,FOLLOW_61_in_regularStatement787); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_61.add(string_literal85);

                    char_literal86=(Token)match(input,49,FOLLOW_49_in_regularStatement789); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_49.add(char_literal86);

                    IDCON87=(Token)match(input,IDCON,FOLLOW_IDCON_in_regularStatement791); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDCON.add(IDCON87);

                    char_literal88=(Token)match(input,44,FOLLOW_44_in_regularStatement793); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_44.add(char_literal88);

                    pushFollow(FOLLOW_expression_in_regularStatement795);
                    expression89=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression89.getTree());
                    char_literal90=(Token)match(input,51,FOLLOW_51_in_regularStatement797); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_51.add(char_literal90);

                    pushFollow(FOLLOW_statement_in_regularStatement799);
                    statement91=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement91.getTree());


                    // AST REWRITE
                    // elements: statement, 61, 44, expression, 49, 51, IDCON
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 133:5: -> ^( 'each' '(' IDCON ':' expression ')' statement )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:133:8: ^( 'each' '(' IDCON ':' expression ')' statement )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_61.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_49.nextNode());
                        adaptor.addChild(root_1, stream_IDCON.nextNode());
                        adaptor.addChild(root_1, stream_44.nextNode());
                        adaptor.addChild(root_1, stream_expression.nextTree());
                        adaptor.addChild(root_1, stream_51.nextNode());
                        adaptor.addChild(root_1, stream_statement.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:134:6: 'let' ( assignment )+ 'in' ( statement )* 'end'
                    {
                    string_literal92=(Token)match(input,62,FOLLOW_62_in_regularStatement831); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_62.add(string_literal92);

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:134:12: ( assignment )+
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
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:0:0: assignment
                    	    {
                    	    pushFollow(FOLLOW_assignment_in_regularStatement833);
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

                    string_literal94=(Token)match(input,63,FOLLOW_63_in_regularStatement836); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_63.add(string_literal94);

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:134:29: ( statement )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==IDCON||LA24_0==COMMENT||LA24_0==55||LA24_0==59||(LA24_0>=61 && LA24_0<=62)||(LA24_0>=64 && LA24_0<=66)) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:0:0: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_regularStatement838);
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

                    string_literal96=(Token)match(input,END,FOLLOW_END_in_regularStatement841); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_END.add(string_literal96);



                    // AST REWRITE
                    // elements: 63, statement, END, assignment, 62
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 135:5: -> ^( 'let' ( assignment )+ 'in' ( statement )* 'end' )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:135:8: ^( 'let' ( assignment )+ 'in' ( statement )* 'end' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_62.nextNode(), root_1);

                        if ( !(stream_assignment.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_assignment.hasNext() ) {
                            adaptor.addChild(root_1, stream_assignment.nextTree());

                        }
                        stream_assignment.reset();
                        adaptor.addChild(root_1, stream_63.nextNode());
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:135:34: ( statement )*
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:136:6: '{' ( statement )* '}'
                    {
                    char_literal97=(Token)match(input,55,FOLLOW_55_in_regularStatement870); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_55.add(char_literal97);

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:136:10: ( statement )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==IDCON||LA25_0==COMMENT||LA25_0==55||LA25_0==59||(LA25_0>=61 && LA25_0<=62)||(LA25_0>=64 && LA25_0<=66)) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:0:0: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_regularStatement872);
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

                    char_literal99=(Token)match(input,56,FOLLOW_56_in_regularStatement875); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_56.add(char_literal99);



                    // AST REWRITE
                    // elements: statement, 56, 55
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 137:5: -> ^( '{' ( statement )* '}' )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:137:8: ^( '{' ( statement )* '}' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_55.nextNode(), root_1);

                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:137:15: ( statement )*
                        while ( stream_statement.hasNext() ) {
                            adaptor.addChild(root_1, stream_statement.nextTree());

                        }
                        stream_statement.reset();
                        adaptor.addChild(root_1, stream_56.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:138:6: 'yield' ';'
                    {
                    string_literal100=(Token)match(input,64,FOLLOW_64_in_regularStatement899); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_64.add(string_literal100);

                    char_literal101=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_regularStatement901); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal101);



                    // AST REWRITE
                    // elements: 64
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 139:5: -> ^( 'yield' )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:139:8: ^( 'yield' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_64.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:140:6: 'comment' STRCON ';'
                    {
                    string_literal102=(Token)match(input,COMMENT,FOLLOW_COMMENT_in_regularStatement920); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COMMENT.add(string_literal102);

                    STRCON103=(Token)match(input,STRCON,FOLLOW_STRCON_in_regularStatement922); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRCON.add(STRCON103);

                    char_literal104=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_regularStatement924); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal104);



                    // AST REWRITE
                    // elements: COMMENT, STRCON
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 141:5: -> ^( 'comment' STRCON )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:141:8: ^( 'comment' STRCON )
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:142:6: 'echo' expression ';'
                    {
                    string_literal105=(Token)match(input,65,FOLLOW_65_in_regularStatement945); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_65.add(string_literal105);

                    pushFollow(FOLLOW_expression_in_regularStatement947);
                    expression106=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression106.getTree());
                    char_literal107=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_regularStatement949); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal107);



                    // AST REWRITE
                    // elements: expression, 65
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 143:5: -> ^( 'echo' expression )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:143:8: ^( 'echo' expression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_65.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_expression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 8 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:144:6: 'echo' embedding ';'
                    {
                    string_literal108=(Token)match(input,65,FOLLOW_65_in_regularStatement970); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_65.add(string_literal108);

                    pushFollow(FOLLOW_embedding_in_regularStatement972);
                    embedding109=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_embedding.add(embedding109.getTree());
                    char_literal110=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_regularStatement974); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal110);



                    // AST REWRITE
                    // elements: embedding, 65
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 145:5: -> ^( 'echo' embedding )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:145:8: ^( 'echo' embedding )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_65.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_embedding.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 9 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:146:6: 'cdata' expression ';'
                    {
                    string_literal111=(Token)match(input,66,FOLLOW_66_in_regularStatement995); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_66.add(string_literal111);

                    pushFollow(FOLLOW_expression_in_regularStatement997);
                    expression112=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression112.getTree());
                    char_literal113=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_regularStatement999); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal113);



                    // AST REWRITE
                    // elements: 66, expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 147:5: -> ^( 'cdata' expression )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:147:8: ^( 'cdata' expression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_66.nextNode(), root_1);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:150:1: markupStatement : ( ( ( markup )+ expression ';' )=> ( markup )+ expression ';' -> ^( MARKUP_EXPRESSION ( markup )+ expression ) | ( ( markup )+ regularStatement )=> ( markup )+ regularStatement -> ^( MARKUP_STATEMENT ( markup )+ regularStatement ) | ( ( markup )+ embedding ';' )=> ( markup )+ embedding ';' -> ^( MARKUP_EMBEDDING ( markup )+ embedding ) | ( ( markup )+ ';' )=> ( markup )+ ';' -> ^( MARKUPS ( markup )+ ) );
    public final Waebric2Parser.markupStatement_return markupStatement() throws RecognitionException {
        Waebric2Parser.markupStatement_return retval = new Waebric2Parser.markupStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal116=null;
        Token char_literal121=null;
        Token char_literal123=null;
        Waebric2Parser.markup_return markup114 = null;

        Waebric2Parser.expression_return expression115 = null;

        Waebric2Parser.markup_return markup117 = null;

        Waebric2Parser.regularStatement_return regularStatement118 = null;

        Waebric2Parser.markup_return markup119 = null;

        Waebric2Parser.embedding_return embedding120 = null;

        Waebric2Parser.markup_return markup122 = null;


        Object char_literal116_tree=null;
        Object char_literal121_tree=null;
        Object char_literal123_tree=null;
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleSubtreeStream stream_embedding=new RewriteRuleSubtreeStream(adaptor,"rule embedding");
        RewriteRuleSubtreeStream stream_regularStatement=new RewriteRuleSubtreeStream(adaptor,"rule regularStatement");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_markup=new RewriteRuleSubtreeStream(adaptor,"rule markup");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:150:16: ( ( ( markup )+ expression ';' )=> ( markup )+ expression ';' -> ^( MARKUP_EXPRESSION ( markup )+ expression ) | ( ( markup )+ regularStatement )=> ( markup )+ regularStatement -> ^( MARKUP_STATEMENT ( markup )+ regularStatement ) | ( ( markup )+ embedding ';' )=> ( markup )+ embedding ';' -> ^( MARKUP_EMBEDDING ( markup )+ embedding ) | ( ( markup )+ ';' )=> ( markup )+ ';' -> ^( MARKUPS ( markup )+ ) )
            int alt31=4;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==IDCON) ) {
                int LA31_1 = input.LA(2);

                if ( (synpred46_Waebric2()) ) {
                    alt31=1;
                }
                else if ( (synpred49_Waebric2()) ) {
                    alt31=2;
                }
                else if ( (synpred52_Waebric2()) ) {
                    alt31=3;
                }
                else if ( (synpred55_Waebric2()) ) {
                    alt31=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:150:18: ( ( markup )+ expression ';' )=> ( markup )+ expression ';'
                    {
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:150:47: ( markup )+
                    int cnt27=0;
                    loop27:
                    do {
                        int alt27=2;
                        alt27 = dfa27.predict(input);
                        switch (alt27) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_markupStatement1039);
                    	    markup114=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_markup.add(markup114.getTree());

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

                    pushFollow(FOLLOW_expression_in_markupStatement1042);
                    expression115=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression115.getTree());
                    char_literal116=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_markupStatement1044); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal116);



                    // AST REWRITE
                    // elements: expression, markup
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 151:5: -> ^( MARKUP_EXPRESSION ( markup )+ expression )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:151:8: ^( MARKUP_EXPRESSION ( markup )+ expression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MARKUP_EXPRESSION, "MARKUP_EXPRESSION"), root_1);

                        if ( !(stream_markup.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_markup.hasNext() ) {
                            adaptor.addChild(root_1, stream_markup.nextTree());

                        }
                        stream_markup.reset();
                        adaptor.addChild(root_1, stream_expression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:152:6: ( ( markup )+ regularStatement )=> ( markup )+ regularStatement
                    {
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:152:38: ( markup )+
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
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_markupStatement1079);
                    	    markup117=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_markup.add(markup117.getTree());

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

                    pushFollow(FOLLOW_regularStatement_in_markupStatement1082);
                    regularStatement118=regularStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_regularStatement.add(regularStatement118.getTree());


                    // AST REWRITE
                    // elements: regularStatement, markup
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 153:5: -> ^( MARKUP_STATEMENT ( markup )+ regularStatement )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:153:8: ^( MARKUP_STATEMENT ( markup )+ regularStatement )
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
                        adaptor.addChild(root_1, stream_regularStatement.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:154:6: ( ( markup )+ embedding ';' )=> ( markup )+ embedding ';'
                    {
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:154:35: ( markup )+
                    int cnt29=0;
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==IDCON) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_markupStatement1119);
                    	    markup119=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_markup.add(markup119.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt29 >= 1 ) break loop29;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(29, input);
                                throw eee;
                        }
                        cnt29++;
                    } while (true);

                    pushFollow(FOLLOW_embedding_in_markupStatement1122);
                    embedding120=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_embedding.add(embedding120.getTree());
                    char_literal121=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_markupStatement1124); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal121);



                    // AST REWRITE
                    // elements: markup, embedding
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 155:5: -> ^( MARKUP_EMBEDDING ( markup )+ embedding )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:155:8: ^( MARKUP_EMBEDDING ( markup )+ embedding )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MARKUP_EMBEDDING, "MARKUP_EMBEDDING"), root_1);

                        if ( !(stream_markup.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_markup.hasNext() ) {
                            adaptor.addChild(root_1, stream_markup.nextTree());

                        }
                        stream_markup.reset();
                        adaptor.addChild(root_1, stream_embedding.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:156:6: ( ( markup )+ ';' )=> ( markup )+ ';'
                    {
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:156:24: ( markup )+
                    int cnt30=0;
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==IDCON) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_markupStatement1158);
                    	    markup122=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_markup.add(markup122.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt30 >= 1 ) break loop30;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(30, input);
                                throw eee;
                        }
                        cnt30++;
                    } while (true);

                    char_literal123=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_markupStatement1161); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal123);



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
                    // 157:5: -> ^( MARKUPS ( markup )+ )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:157:8: ^( MARKUPS ( markup )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MARKUPS, "MARKUPS"), root_1);

                        if ( !(stream_markup.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_markup.hasNext() ) {
                            adaptor.addChild(root_1, stream_markup.nextTree());

                        }
                        stream_markup.reset();

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
    // $ANTLR end "markupStatement"

    public static class assignment_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignment"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:162:1: assignment : ( IDCON '=' expression ';' | IDCON formals '=' statement -> ^( 'def' IDCON ^( FORMALS ( formals )? ) statement ) );
    public final Waebric2Parser.assignment_return assignment() throws RecognitionException {
        Waebric2Parser.assignment_return retval = new Waebric2Parser.assignment_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDCON124=null;
        Token char_literal125=null;
        Token char_literal127=null;
        Token IDCON128=null;
        Token char_literal130=null;
        Waebric2Parser.expression_return expression126 = null;

        Waebric2Parser.formals_return formals129 = null;

        Waebric2Parser.statement_return statement131 = null;


        Object IDCON124_tree=null;
        Object char_literal125_tree=null;
        Object char_literal127_tree=null;
        Object IDCON128_tree=null;
        Object char_literal130_tree=null;
        RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
        RewriteRuleTokenStream stream_IDCON=new RewriteRuleTokenStream(adaptor,"token IDCON");
        RewriteRuleSubtreeStream stream_formals=new RewriteRuleSubtreeStream(adaptor,"rule formals");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:162:11: ( IDCON '=' expression ';' | IDCON formals '=' statement -> ^( 'def' IDCON ^( FORMALS ( formals )? ) statement ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==IDCON) ) {
                int LA32_1 = input.LA(2);

                if ( (LA32_1==52) ) {
                    alt32=1;
                }
                else if ( (LA32_1==49) ) {
                    alt32=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 32, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:162:14: IDCON '=' expression ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    IDCON124=(Token)match(input,IDCON,FOLLOW_IDCON_in_assignment1188); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON124_tree = (Object)adaptor.create(IDCON124);
                    adaptor.addChild(root_0, IDCON124_tree);
                    }
                    char_literal125=(Token)match(input,52,FOLLOW_52_in_assignment1190); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal125_tree = (Object)adaptor.create(char_literal125);
                    adaptor.addChild(root_0, char_literal125_tree);
                    }
                    pushFollow(FOLLOW_expression_in_assignment1192);
                    expression126=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression126.getTree());
                    char_literal127=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_assignment1194); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal127_tree = (Object)adaptor.create(char_literal127);
                    adaptor.addChild(root_0, char_literal127_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:163:6: IDCON formals '=' statement
                    {
                    IDCON128=(Token)match(input,IDCON,FOLLOW_IDCON_in_assignment1202); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDCON.add(IDCON128);

                    pushFollow(FOLLOW_formals_in_assignment1204);
                    formals129=formals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_formals.add(formals129.getTree());
                    char_literal130=(Token)match(input,52,FOLLOW_52_in_assignment1206); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_52.add(char_literal130);

                    pushFollow(FOLLOW_statement_in_assignment1208);
                    statement131=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement131.getTree());


                    // AST REWRITE
                    // elements: statement, IDCON, formals, 58
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 164:5: -> ^( 'def' IDCON ^( FORMALS ( formals )? ) statement )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:164:8: ^( 'def' IDCON ^( FORMALS ( formals )? ) statement )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(58, "58"), root_1);

                        adaptor.addChild(root_1, stream_IDCON.nextNode());
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:164:23: ^( FORMALS ( formals )? )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(FORMALS, "FORMALS"), root_2);

                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:164:34: ( formals )?
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:169:1: predicate : ( '!' )* expression ( '.' type '?' )? ( '&&' predicate | '||' predicate )* ;
    public final Waebric2Parser.predicate_return predicate() throws RecognitionException {
        Waebric2Parser.predicate_return retval = new Waebric2Parser.predicate_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal132=null;
        Token char_literal134=null;
        Token char_literal136=null;
        Token string_literal137=null;
        Token string_literal139=null;
        Waebric2Parser.expression_return expression133 = null;

        Waebric2Parser.type_return type135 = null;

        Waebric2Parser.predicate_return predicate138 = null;

        Waebric2Parser.predicate_return predicate140 = null;


        Object char_literal132_tree=null;
        Object char_literal134_tree=null;
        Object char_literal136_tree=null;
        Object string_literal137_tree=null;
        Object string_literal139_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:169:10: ( ( '!' )* expression ( '.' type '?' )? ( '&&' predicate | '||' predicate )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:169:13: ( '!' )* expression ( '.' type '?' )? ( '&&' predicate | '||' predicate )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:169:13: ( '!' )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==67) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:0:0: '!'
            	    {
            	    char_literal132=(Token)match(input,67,FOLLOW_67_in_predicate1247); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal132_tree = (Object)adaptor.create(char_literal132);
            	    adaptor.addChild(root_0, char_literal132_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            pushFollow(FOLLOW_expression_in_predicate1250);
            expression133=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression133.getTree());
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:169:29: ( '.' type '?' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==42) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:169:31: '.' type '?'
                    {
                    char_literal134=(Token)match(input,42,FOLLOW_42_in_predicate1254); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal134_tree = (Object)adaptor.create(char_literal134);
                    adaptor.addChild(root_0, char_literal134_tree);
                    }
                    pushFollow(FOLLOW_type_in_predicate1256);
                    type135=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, type135.getTree());
                    char_literal136=(Token)match(input,68,FOLLOW_68_in_predicate1258); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal136_tree = (Object)adaptor.create(char_literal136);
                    adaptor.addChild(root_0, char_literal136_tree);
                    }

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:170:4: ( '&&' predicate | '||' predicate )*
            loop35:
            do {
                int alt35=3;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==69) ) {
                    int LA35_2 = input.LA(2);

                    if ( (synpred60_Waebric2()) ) {
                        alt35=1;
                    }


                }
                else if ( (LA35_0==70) ) {
                    int LA35_3 = input.LA(2);

                    if ( (synpred61_Waebric2()) ) {
                        alt35=2;
                    }


                }


                switch (alt35) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:170:6: '&&' predicate
            	    {
            	    string_literal137=(Token)match(input,69,FOLLOW_69_in_predicate1268); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal137_tree = (Object)adaptor.create(string_literal137);
            	    adaptor.addChild(root_0, string_literal137_tree);
            	    }
            	    pushFollow(FOLLOW_predicate_in_predicate1270);
            	    predicate138=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate138.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:170:23: '||' predicate
            	    {
            	    string_literal139=(Token)match(input,70,FOLLOW_70_in_predicate1274); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal139_tree = (Object)adaptor.create(string_literal139);
            	    adaptor.addChild(root_0, string_literal139_tree);
            	    }
            	    pushFollow(FOLLOW_predicate_in_predicate1276);
            	    predicate140=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate140.getTree());

            	    }
            	    break;

            	default :
            	    break loop35;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:172:1: type : ( 'list' | 'record' | 'string' );
    public final Waebric2Parser.type_return type() throws RecognitionException {
        Waebric2Parser.type_return retval = new Waebric2Parser.type_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set141=null;

        Object set141_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:172:5: ( 'list' | 'record' | 'string' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:
            {
            root_0 = (Object)adaptor.nil();

            set141=(Token)input.LT(1);
            if ( (input.LA(1)>=71 && input.LA(1)<=73) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set141));
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:180:1: embedding : PRETEXT embed textTail ;
    public final Waebric2Parser.embedding_return embedding() throws RecognitionException {
        Waebric2Parser.embedding_return retval = new Waebric2Parser.embedding_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PRETEXT142=null;
        Waebric2Parser.embed_return embed143 = null;

        Waebric2Parser.textTail_return textTail144 = null;


        Object PRETEXT142_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:180:10: ( PRETEXT embed textTail )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:180:13: PRETEXT embed textTail
            {
            root_0 = (Object)adaptor.nil();

            PRETEXT142=(Token)match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding1324); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRETEXT142_tree = (Object)adaptor.create(PRETEXT142);
            adaptor.addChild(root_0, PRETEXT142_tree);
            }
            pushFollow(FOLLOW_embed_in_embedding1326);
            embed143=embed();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, embed143.getTree());
            pushFollow(FOLLOW_textTail_in_embedding1328);
            textTail144=textTail();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, textTail144.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:182:1: embed : ( ( ( markup )+ )=> ( markup )+ -> ^( MARKUPS ( markup )+ ) | ( ( markup )* expression )=> ( markup )* expression -> ^( MARKUP_EXPRESSION ( markup )* expression ) );
    public final Waebric2Parser.embed_return embed() throws RecognitionException {
        Waebric2Parser.embed_return retval = new Waebric2Parser.embed_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Waebric2Parser.markup_return markup145 = null;

        Waebric2Parser.markup_return markup146 = null;

        Waebric2Parser.expression_return expression147 = null;


        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_markup=new RewriteRuleSubtreeStream(adaptor,"rule markup");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:182:6: ( ( ( markup )+ )=> ( markup )+ -> ^( MARKUPS ( markup )+ ) | ( ( markup )* expression )=> ( markup )* expression -> ^( MARKUP_EXPRESSION ( markup )* expression ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==IDCON) ) {
                int LA38_1 = input.LA(2);

                if ( (synpred65_Waebric2()) ) {
                    alt38=1;
                }
                else if ( (synpred68_Waebric2()) ) {
                    alt38=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA38_0==NATCON) && (synpred68_Waebric2())) {
                alt38=2;
            }
            else if ( (LA38_0==TEXT) && (synpred68_Waebric2())) {
                alt38=2;
            }
            else if ( (LA38_0==SYMBOLCON) && (synpred68_Waebric2())) {
                alt38=2;
            }
            else if ( (LA38_0==53) && (synpred68_Waebric2())) {
                alt38=2;
            }
            else if ( (LA38_0==55) && (synpred68_Waebric2())) {
                alt38=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:182:10: ( ( markup )+ )=> ( markup )+
                    {
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:182:25: ( markup )+
                    int cnt36=0;
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==IDCON) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_embed1347);
                    	    markup145=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_markup.add(markup145.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt36 >= 1 ) break loop36;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(36, input);
                                throw eee;
                        }
                        cnt36++;
                    } while (true);



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
                    // 183:5: -> ^( MARKUPS ( markup )+ )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:183:8: ^( MARKUPS ( markup )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MARKUPS, "MARKUPS"), root_1);

                        if ( !(stream_markup.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_markup.hasNext() ) {
                            adaptor.addChild(root_1, stream_markup.nextTree());

                        }
                        stream_markup.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:184:6: ( ( markup )* expression )=> ( markup )* expression
                    {
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:184:32: ( markup )*
                    loop37:
                    do {
                        int alt37=2;
                        alt37 = dfa37.predict(input);
                        switch (alt37) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_embed1381);
                    	    markup146=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_markup.add(markup146.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop37;
                        }
                    } while (true);

                    pushFollow(FOLLOW_expression_in_embed1384);
                    expression147=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression147.getTree());


                    // AST REWRITE
                    // elements: markup, expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 185:5: -> ^( MARKUP_EXPRESSION ( markup )* expression )
                    {
                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:185:8: ^( MARKUP_EXPRESSION ( markup )* expression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MARKUP_EXPRESSION, "MARKUP_EXPRESSION"), root_1);

                        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:185:29: ( markup )*
                        while ( stream_markup.hasNext() ) {
                            adaptor.addChild(root_1, stream_markup.nextTree());

                        }
                        stream_markup.reset();
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
    // $ANTLR end "embed"

    public static class textTail_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "textTail"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:187:1: textTail : ( POSTTEXT | MIDTEXT embed textTail );
    public final Waebric2Parser.textTail_return textTail() throws RecognitionException {
        Waebric2Parser.textTail_return retval = new Waebric2Parser.textTail_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token POSTTEXT148=null;
        Token MIDTEXT149=null;
        Waebric2Parser.embed_return embed150 = null;

        Waebric2Parser.textTail_return textTail151 = null;


        Object POSTTEXT148_tree=null;
        Object MIDTEXT149_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:187:9: ( POSTTEXT | MIDTEXT embed textTail )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==POSTTEXT) ) {
                alt39=1;
            }
            else if ( (LA39_0==MIDTEXT) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:187:12: POSTTEXT
                    {
                    root_0 = (Object)adaptor.nil();

                    POSTTEXT148=(Token)match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail1411); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    POSTTEXT148_tree = (Object)adaptor.create(POSTTEXT148);
                    adaptor.addChild(root_0, POSTTEXT148_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:188:6: MIDTEXT embed textTail
                    {
                    root_0 = (Object)adaptor.nil();

                    MIDTEXT149=(Token)match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail1419); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MIDTEXT149_tree = (Object)adaptor.create(MIDTEXT149);
                    adaptor.addChild(root_0, MIDTEXT149_tree);
                    }
                    pushFollow(FOLLOW_embed_in_textTail1421);
                    embed150=embed();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, embed150.getTree());
                    pushFollow(FOLLOW_textTail_in_textTail1423);
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

    // $ANTLR start synpred26_Waebric2
    public final void synpred26_Waebric2_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:110:8: ( '+' expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:110:8: '+' expression
        {
        match(input,57,FOLLOW_57_in_synpred26_Waebric2596); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred26_Waebric2598);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_Waebric2

    // $ANTLR start synpred27_Waebric2
    public final void synpred27_Waebric2_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:110:35: ( '.' IDCON )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:110:35: '.' IDCON
        {
        match(input,42,FOLLOW_42_in_synpred27_Waebric2604); if (state.failed) return ;
        match(input,IDCON,FOLLOW_IDCON_in_synpred27_Waebric2606); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred27_Waebric2

    // $ANTLR start synpred33_Waebric2
    public final void synpred33_Waebric2_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:130:54: ( 'else' statement )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:130:54: 'else' statement
        {
        match(input,60,FOLLOW_60_in_synpred33_Waebric2750); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred33_Waebric2752);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred33_Waebric2

    // $ANTLR start synpred46_Waebric2
    public final void synpred46_Waebric2_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:150:18: ( ( markup )+ expression ';' )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:150:20: ( markup )+ expression ';'
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:150:20: ( markup )+
        int cnt48=0;
        loop48:
        do {
            int alt48=2;
            alt48 = dfa48.predict(input);
            switch (alt48) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred46_Waebric21029);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt48 >= 1 ) break loop48;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(48, input);
                    throw eee;
            }
            cnt48++;
        } while (true);

        pushFollow(FOLLOW_expression_in_synpred46_Waebric21032);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred46_Waebric21034); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_Waebric2

    // $ANTLR start synpred49_Waebric2
    public final void synpred49_Waebric2_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:152:6: ( ( markup )+ regularStatement )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:152:8: ( markup )+ regularStatement
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:152:8: ( markup )+
        int cnt49=0;
        loop49:
        do {
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==IDCON) ) {
                alt49=1;
            }


            switch (alt49) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred49_Waebric21070);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt49 >= 1 ) break loop49;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(49, input);
                    throw eee;
            }
            cnt49++;
        } while (true);

        pushFollow(FOLLOW_regularStatement_in_synpred49_Waebric21073);
        regularStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred49_Waebric2

    // $ANTLR start synpred52_Waebric2
    public final void synpred52_Waebric2_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:154:6: ( ( markup )+ embedding ';' )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:154:8: ( markup )+ embedding ';'
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:154:8: ( markup )+
        int cnt50=0;
        loop50:
        do {
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==IDCON) ) {
                alt50=1;
            }


            switch (alt50) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred52_Waebric21108);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt50 >= 1 ) break loop50;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(50, input);
                    throw eee;
            }
            cnt50++;
        } while (true);

        pushFollow(FOLLOW_embedding_in_synpred52_Waebric21111);
        embedding();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred52_Waebric21113); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred52_Waebric2

    // $ANTLR start synpred55_Waebric2
    public final void synpred55_Waebric2_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:156:6: ( ( markup )+ ';' )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:156:8: ( markup )+ ';'
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:156:8: ( markup )+
        int cnt51=0;
        loop51:
        do {
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==IDCON) ) {
                alt51=1;
            }


            switch (alt51) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred55_Waebric21150);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt51 >= 1 ) break loop51;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(51, input);
                    throw eee;
            }
            cnt51++;
        } while (true);

        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred55_Waebric21153); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred55_Waebric2

    // $ANTLR start synpred60_Waebric2
    public final void synpred60_Waebric2_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:170:6: ( '&&' predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:170:6: '&&' predicate
        {
        match(input,69,FOLLOW_69_in_synpred60_Waebric21268); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred60_Waebric21270);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred60_Waebric2

    // $ANTLR start synpred61_Waebric2
    public final void synpred61_Waebric2_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:170:23: ( '||' predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:170:23: '||' predicate
        {
        match(input,70,FOLLOW_70_in_synpred61_Waebric21274); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred61_Waebric21276);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred61_Waebric2

    // $ANTLR start synpred65_Waebric2
    public final void synpred65_Waebric2_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:182:10: ( ( markup )+ )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:182:12: ( markup )+
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:182:12: ( markup )+
        int cnt52=0;
        loop52:
        do {
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==IDCON) ) {
                alt52=1;
            }


            switch (alt52) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred65_Waebric21340);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt52 >= 1 ) break loop52;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(52, input);
                    throw eee;
            }
            cnt52++;
        } while (true);


        }
    }
    // $ANTLR end synpred65_Waebric2

    // $ANTLR start synpred68_Waebric2
    public final void synpred68_Waebric2_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:184:6: ( ( markup )* expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:184:8: ( markup )* expression
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:184:8: ( markup )*
        loop53:
        do {
            int alt53=2;
            alt53 = dfa53.predict(input);
            switch (alt53) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric2.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred68_Waebric21372);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop53;
            }
        } while (true);

        pushFollow(FOLLOW_expression_in_synpred68_Waebric21375);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred68_Waebric2

    // Delegated rules

    public final boolean synpred26_Waebric2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_Waebric2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred55_Waebric2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred55_Waebric2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred65_Waebric2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred65_Waebric2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred46_Waebric2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_Waebric2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred61_Waebric2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred61_Waebric2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred60_Waebric2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred60_Waebric2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred68_Waebric2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred68_Waebric2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_Waebric2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_Waebric2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred49_Waebric2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred49_Waebric2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred52_Waebric2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred52_Waebric2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_Waebric2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_Waebric2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA26 dfa26 = new DFA26(this);
    protected DFA27 dfa27 = new DFA27(this);
    protected DFA37 dfa37 = new DFA37(this);
    protected DFA48 dfa48 = new DFA48(this);
    protected DFA53 dfa53 = new DFA53(this);
    static final String DFA26_eotS =
        "\13\uffff";
    static final String DFA26_eofS =
        "\13\uffff";
    static final String DFA26_minS =
        "\1\25\6\uffff\1\14\3\uffff";
    static final String DFA26_maxS =
        "\1\102\6\uffff\1\67\3\uffff";
    static final String DFA26_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\11\1\7\1\10";
    static final String DFA26_specialS =
        "\13\uffff}>";
    static final String[] DFA26_transitionS = {
            "\1\6\41\uffff\1\4\3\uffff\1\1\1\uffff\1\2\1\3\1\uffff\1\5\1"+
            "\7\1\10",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\11\1\uffff\3\11\1\uffff\1\12\42\uffff\1\11\1\uffff\1\11",
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
            return "130:1: regularStatement : ( 'if' '(' predicate ')' statement ( 'else' statement )? -> ^( 'if' predicate statement ( 'else' statement )? ) | 'each' '(' IDCON ':' expression ')' statement -> ^( 'each' '(' IDCON ':' expression ')' statement ) | 'let' ( assignment )+ 'in' ( statement )* 'end' -> ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | '{' ( statement )* '}' -> ^( '{' ( statement )* '}' ) | 'yield' ';' -> ^( 'yield' ) | 'comment' STRCON ';' -> ^( 'comment' STRCON ) | 'echo' expression ';' -> ^( 'echo' expression ) | 'echo' embedding ';' -> ^( 'echo' embedding ) | 'cdata' expression ';' -> ^( 'cdata' expression ) );";
        }
    }
    static final String DFA27_eotS =
        "\6\uffff";
    static final String DFA27_eofS =
        "\6\uffff";
    static final String DFA27_minS =
        "\2\14\2\uffff\2\14";
    static final String DFA27_maxS =
        "\1\67\1\71\2\uffff\1\14\1\71";
    static final String DFA27_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA27_specialS =
        "\6\uffff}>";
    static final String[] DFA27_transitionS = {
            "\1\1\1\uffff\3\2\44\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\7\uffff\1\2\21\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\3\uffff\1\3\1\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\7\uffff\1\2\21\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\3\uffff\1\3\1\uffff\1\3\1\uffff\1\2"
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
            return "()+ loopback of 150:47: ( markup )+";
        }
    }
    static final String DFA37_eotS =
        "\6\uffff";
    static final String DFA37_eofS =
        "\6\uffff";
    static final String DFA37_minS =
        "\2\14\1\uffff\1\14\1\uffff\1\14";
    static final String DFA37_maxS =
        "\1\67\1\71\1\uffff\1\14\1\uffff\1\71";
    static final String DFA37_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String DFA37_specialS =
        "\6\uffff}>";
    static final String[] DFA37_transitionS = {
            "\1\1\1\uffff\3\2\44\uffff\1\2\1\uffff\1\2",
            "\1\4\1\uffff\3\4\2\uffff\2\2\25\uffff\1\3\1\uffff\4\4\1\uffff"+
            "\1\4\3\uffff\1\4\1\uffff\1\4\1\uffff\1\2",
            "",
            "\1\5",
            "",
            "\1\4\1\uffff\3\4\2\uffff\2\2\25\uffff\1\3\1\uffff\4\4\1\uffff"+
            "\1\4\3\uffff\1\4\1\uffff\1\4\1\uffff\1\2"
    };

    static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
    static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
    static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
    static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
    static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
    static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
    static final short[][] DFA37_transition;

    static {
        int numStates = DFA37_transitionS.length;
        DFA37_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
        }
    }

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = DFA37_eot;
            this.eof = DFA37_eof;
            this.min = DFA37_min;
            this.max = DFA37_max;
            this.accept = DFA37_accept;
            this.special = DFA37_special;
            this.transition = DFA37_transition;
        }
        public String getDescription() {
            return "()* loopback of 184:32: ( markup )*";
        }
    }
    static final String DFA48_eotS =
        "\6\uffff";
    static final String DFA48_eofS =
        "\6\uffff";
    static final String DFA48_minS =
        "\2\14\2\uffff\2\14";
    static final String DFA48_maxS =
        "\1\67\1\71\2\uffff\1\14\1\71";
    static final String DFA48_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA48_specialS =
        "\6\uffff}>";
    static final String[] DFA48_transitionS = {
            "\1\1\1\uffff\3\2\44\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\7\uffff\1\2\21\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\3\uffff\1\3\1\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\7\uffff\1\2\21\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\3\uffff\1\3\1\uffff\1\3\1\uffff\1\2"
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
            return "()+ loopback of 150:20: ( markup )+";
        }
    }
    static final String DFA53_eotS =
        "\6\uffff";
    static final String DFA53_eofS =
        "\1\uffff\1\2\3\uffff\1\2";
    static final String DFA53_minS =
        "\2\14\2\uffff\2\14";
    static final String DFA53_maxS =
        "\1\67\1\71\2\uffff\1\14\1\71";
    static final String DFA53_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA53_specialS =
        "\6\uffff}>";
    static final String[] DFA53_transitionS = {
            "\1\1\1\uffff\3\2\44\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\31\uffff\1\4\1\uffff\4\3\1\uffff\1\3\3\uffff"+
            "\1\3\1\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\31\uffff\1\4\1\uffff\4\3\1\uffff\1\3\3\uffff"+
            "\1\3\1\uffff\1\3\1\uffff\1\2"
    };

    static final short[] DFA53_eot = DFA.unpackEncodedString(DFA53_eotS);
    static final short[] DFA53_eof = DFA.unpackEncodedString(DFA53_eofS);
    static final char[] DFA53_min = DFA.unpackEncodedStringToUnsignedChars(DFA53_minS);
    static final char[] DFA53_max = DFA.unpackEncodedStringToUnsignedChars(DFA53_maxS);
    static final short[] DFA53_accept = DFA.unpackEncodedString(DFA53_acceptS);
    static final short[] DFA53_special = DFA.unpackEncodedString(DFA53_specialS);
    static final short[][] DFA53_transition;

    static {
        int numStates = DFA53_transitionS.length;
        DFA53_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA53_transition[i] = DFA.unpackEncodedString(DFA53_transitionS[i]);
        }
    }

    class DFA53 extends DFA {

        public DFA53(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 53;
            this.eot = DFA53_eot;
            this.eof = DFA53_eof;
            this.min = DFA53_min;
            this.max = DFA53_max;
            this.accept = DFA53_accept;
            this.special = DFA53_special;
            this.transition = DFA53_transition;
        }
        public String getDescription() {
            return "()* loopback of 184:8: ( markup )*";
        }
    }
 

    public static final BitSet FOLLOW_41_in_module146 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_moduleId_in_module148 = new BitSet(new long[]{0x0400080000400002L});
    public static final BitSet FOLLOW_imprt_in_module154 = new BitSet(new long[]{0x0400080000400002L});
    public static final BitSet FOLLOW_site_in_module158 = new BitSet(new long[]{0x0400080000400002L});
    public static final BitSet FOLLOW_function_in_module162 = new BitSet(new long[]{0x0400080000400002L});
    public static final BitSet FOLLOW_IDCON_in_moduleId214 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_moduleId224 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_IDCON_in_moduleId228 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_43_in_imprt244 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_moduleId_in_imprt246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SITE_in_site278 = new BitSet(new long[]{0x0000000001802000L});
    public static final BitSet FOLLOW_mappings_in_site280 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_END_in_site282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapping_in_mappings290 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_mappings295 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_mapping_in_mappings297 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_PATH_in_mapping309 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_mapping311 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_markup_in_mapping313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_markup326 = new BitSet(new long[]{0x0002F40000000000L});
    public static final BitSet FOLLOW_attributes_in_markup328 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_arguments_in_markup330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attribute_in_attributes361 = new BitSet(new long[]{0x0000F40000000002L});
    public static final BitSet FOLLOW_45_in_attribute387 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_IDCON_in_attribute389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_attribute397 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_IDCON_in_attribute399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_attribute407 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_IDCON_in_attribute409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_attribute417 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_IDCON_in_attribute419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_attribute427 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NATCON_in_attribute429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_attribute437 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NATCON_in_attribute439 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_attribute441 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NATCON_in_attribute443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_arguments457 = new BitSet(new long[]{0x00AC00000001D000L});
    public static final BitSet FOLLOW_argument_in_arguments459 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_50_in_arguments464 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_argument_in_arguments466 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_51_in_arguments471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_argument502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_argument510 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_argument512 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_argument514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_expression528 = new BitSet(new long[]{0x0200040000000002L});
    public static final BitSet FOLLOW_NATCON_in_expression532 = new BitSet(new long[]{0x0200040000000002L});
    public static final BitSet FOLLOW_TEXT_in_expression536 = new BitSet(new long[]{0x0200040000000002L});
    public static final BitSet FOLLOW_SYMBOLCON_in_expression540 = new BitSet(new long[]{0x0200040000000002L});
    public static final BitSet FOLLOW_53_in_expression549 = new BitSet(new long[]{0x00E400000001D000L});
    public static final BitSet FOLLOW_expression_in_expression551 = new BitSet(new long[]{0x0044000000000000L});
    public static final BitSet FOLLOW_50_in_expression556 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_expression558 = new BitSet(new long[]{0x0044000000000000L});
    public static final BitSet FOLLOW_54_in_expression563 = new BitSet(new long[]{0x0200040000000002L});
    public static final BitSet FOLLOW_55_in_expression572 = new BitSet(new long[]{0x0104000000001000L});
    public static final BitSet FOLLOW_keyValuePair_in_expression574 = new BitSet(new long[]{0x0104000000000000L});
    public static final BitSet FOLLOW_50_in_expression579 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_keyValuePair_in_expression581 = new BitSet(new long[]{0x0104000000000000L});
    public static final BitSet FOLLOW_56_in_expression586 = new BitSet(new long[]{0x0200040000000002L});
    public static final BitSet FOLLOW_57_in_expression596 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_expression598 = new BitSet(new long[]{0x0200040000000002L});
    public static final BitSet FOLLOW_42_in_expression604 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_IDCON_in_expression606 = new BitSet(new long[]{0x0200040000000002L});
    public static final BitSet FOLLOW_IDCON_in_keyValuePair619 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_keyValuePair621 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_keyValuePair623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_function635 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_IDCON_in_function637 = new BitSet(new long[]{0x6882000000A01000L,0x0000000000000007L});
    public static final BitSet FOLLOW_formals_in_function639 = new BitSet(new long[]{0x6880000000A01000L,0x0000000000000007L});
    public static final BitSet FOLLOW_statement_in_function642 = new BitSet(new long[]{0x6880000000A01000L,0x0000000000000007L});
    public static final BitSet FOLLOW_END_in_function645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_formals682 = new BitSet(new long[]{0x000C000000001000L});
    public static final BitSet FOLLOW_IDCON_in_formals684 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_50_in_formals689 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_IDCON_in_formals691 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_51_in_formals696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_regularStatement_in_statement718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markupStatement_in_statement725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_regularStatement738 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_regularStatement740 = new BitSet(new long[]{0x00A000000001D000L,0x0000000000000008L});
    public static final BitSet FOLLOW_predicate_in_regularStatement742 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_regularStatement744 = new BitSet(new long[]{0x6880000000201000L,0x0000000000000007L});
    public static final BitSet FOLLOW_statement_in_regularStatement746 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_60_in_regularStatement750 = new BitSet(new long[]{0x6880000000201000L,0x0000000000000007L});
    public static final BitSet FOLLOW_statement_in_regularStatement752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_regularStatement787 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_regularStatement789 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_IDCON_in_regularStatement791 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_regularStatement793 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_regularStatement795 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_regularStatement797 = new BitSet(new long[]{0x6880000000201000L,0x0000000000000007L});
    public static final BitSet FOLLOW_statement_in_regularStatement799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_regularStatement831 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_assignment_in_regularStatement833 = new BitSet(new long[]{0x8000000000001000L});
    public static final BitSet FOLLOW_63_in_regularStatement836 = new BitSet(new long[]{0x6880000000A01000L,0x0000000000000007L});
    public static final BitSet FOLLOW_statement_in_regularStatement838 = new BitSet(new long[]{0x6880000000A01000L,0x0000000000000007L});
    public static final BitSet FOLLOW_END_in_regularStatement841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_regularStatement870 = new BitSet(new long[]{0x6980000000201000L,0x0000000000000007L});
    public static final BitSet FOLLOW_statement_in_regularStatement872 = new BitSet(new long[]{0x6980000000201000L,0x0000000000000007L});
    public static final BitSet FOLLOW_56_in_regularStatement875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_regularStatement899 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_regularStatement901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMENT_in_regularStatement920 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_STRCON_in_regularStatement922 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_regularStatement924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_regularStatement945 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_regularStatement947 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_regularStatement949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_regularStatement970 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_embedding_in_regularStatement972 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_regularStatement974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_regularStatement995 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_regularStatement997 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_regularStatement999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_markupStatement1039 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_markupStatement1042 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_markupStatement1044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_markupStatement1079 = new BitSet(new long[]{0x6880000000201000L,0x0000000000000007L});
    public static final BitSet FOLLOW_regularStatement_in_markupStatement1082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_markupStatement1119 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_embedding_in_markupStatement1122 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_markupStatement1124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_markupStatement1158 = new BitSet(new long[]{0x0000000001001000L});
    public static final BitSet FOLLOW_SEMICOLON_in_markupStatement1161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_assignment1188 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_assignment1190 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_assignment1192 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_assignment1194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_assignment1202 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_formals_in_assignment1204 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_assignment1206 = new BitSet(new long[]{0x6880000000201000L,0x0000000000000007L});
    public static final BitSet FOLLOW_statement_in_assignment1208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_predicate1247 = new BitSet(new long[]{0x00A000000001D000L,0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_predicate1250 = new BitSet(new long[]{0x0000040000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_42_in_predicate1254 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000380L});
    public static final BitSet FOLLOW_type_in_predicate1256 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_predicate1258 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_69_in_predicate1268 = new BitSet(new long[]{0x00A000000001D000L,0x0000000000000008L});
    public static final BitSet FOLLOW_predicate_in_predicate1270 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_70_in_predicate1274 = new BitSet(new long[]{0x00A000000001D000L,0x0000000000000008L});
    public static final BitSet FOLLOW_predicate_in_predicate1276 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding1324 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_embed_in_embedding1326 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_textTail_in_embedding1328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed1347 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_markup_in_embed1381 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_embed1384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail1411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail1419 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_embed_in_textTail1421 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_textTail_in_textTail1423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_synpred26_Waebric2596 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_synpred26_Waebric2598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_synpred27_Waebric2604 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_IDCON_in_synpred27_Waebric2606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_synpred33_Waebric2750 = new BitSet(new long[]{0x6880000000201000L,0x0000000000000007L});
    public static final BitSet FOLLOW_statement_in_synpred33_Waebric2752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred46_Waebric21029 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_synpred46_Waebric21032 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred46_Waebric21034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred49_Waebric21070 = new BitSet(new long[]{0x6880000000201000L,0x0000000000000007L});
    public static final BitSet FOLLOW_regularStatement_in_synpred49_Waebric21073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred52_Waebric21108 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_embedding_in_synpred52_Waebric21111 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred52_Waebric21113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred55_Waebric21150 = new BitSet(new long[]{0x0000000001001000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred55_Waebric21153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_synpred60_Waebric21268 = new BitSet(new long[]{0x00A000000001D000L,0x0000000000000008L});
    public static final BitSet FOLLOW_predicate_in_synpred60_Waebric21270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_synpred61_Waebric21274 = new BitSet(new long[]{0x00A000000001D000L,0x0000000000000008L});
    public static final BitSet FOLLOW_predicate_in_synpred61_Waebric21276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred65_Waebric21340 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_markup_in_synpred68_Waebric21372 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_synpred68_Waebric21375 = new BitSet(new long[]{0x0000000000000002L});

}