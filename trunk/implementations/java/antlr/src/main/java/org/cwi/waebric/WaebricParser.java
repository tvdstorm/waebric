// $ANTLR 3.1.2 /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g 2009-07-20 14:50:51

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "MODULE", "IMPORT", "SITE", "DEF", "END", "IF", "ELSE", "EACH", "LET", "IN", "COMMENT", "ECHO", "CDATA", "YIELD", "LIST", "RECORD", "STRING", "IDCON", "PATH", "NATCON", "TEXT", "SYMBOLCON", "STRCON", "PRETEXT", "POSTTEXT", "MIDTEXT", "SEMICOLON", "LETTER", "DIGIT", "HEXADECIMAL", "PATHELEMENT", "FILEEXT", "STRCHAR", "ESCLAYOUT", "DECIMAL", "TEXTCHAR", "ESCQUOTE", "AMP", "CHARREF", "ENTREF", "SYMBOLCHAR", "COMMENTS", "LAYOUT", "'.'", "':'", "'#'", "'$'", "'@'", "'%'", "'('", "','", "')'", "'+'", "'['", "']'", "'{'", "'}'", "'yield;'", "'='", "'&&'", "'||'", "'!'"
    };
    public static final int ESCLAYOUT=37;
    public static final int DEF=7;
    public static final int T__57=57;
    public static final int END=8;
    public static final int LIST=18;
    public static final int FILEEXT=35;
    public static final int T__51=51;
    public static final int T__47=47;
    public static final int STRCHAR=36;
    public static final int T__50=50;
    public static final int T__65=65;
    public static final int SYMBOLCON=25;
    public static final int COMMENTS=45;
    public static final int DECIMAL=38;
    public static final int IDCON=21;
    public static final int IMPORT=5;
    public static final int HEXADECIMAL=33;
    public static final int TEXTCHAR=39;
    public static final int T__52=52;
    public static final int ECHO=15;
    public static final int T__62=62;
    public static final int STRCON=26;
    public static final int MODULE=4;
    public static final int T__49=49;
    public static final int AMP=41;
    public static final int T__61=61;
    public static final int POSTTEXT=28;
    public static final int T__59=59;
    public static final int DIGIT=32;
    public static final int RECORD=19;
    public static final int T__54=54;
    public static final int T__48=48;
    public static final int LAYOUT=46;
    public static final int ESCQUOTE=40;
    public static final int PATHELEMENT=34;
    public static final int T__56=56;
    public static final int ENTREF=43;
    public static final int LETTER=31;
    public static final int CDATA=16;
    public static final int SITE=6;
    public static final int T__58=58;
    public static final int STRING=20;
    public static final int T__64=64;
    public static final int SYMBOLCHAR=44;
    public static final int COMMENT=14;
    public static final int YIELD=17;
    public static final int T__55=55;
    public static final int IN=13;
    public static final int CHARREF=42;
    public static final int MIDTEXT=29;
    public static final int T__63=63;
    public static final int ELSE=10;
    public static final int PRETEXT=27;
    public static final int SEMICOLON=30;
    public static final int IF=9;
    public static final int LET=12;
    public static final int EOF=-1;
    public static final int T__53=53;
    public static final int TEXT=24;
    public static final int NATCON=23;
    public static final int T__60=60;
    public static final int EACH=11;
    public static final int PATH=22;

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:60:1: module : 'module' moduleId ( imprt | site | function )* 'end' -> ^( 'module' moduleId ( imprt )* ( site )* ( function )* 'end' ) ;
    public final WaebricParser.module_return module() throws RecognitionException {
        WaebricParser.module_return retval = new WaebricParser.module_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal1=null;
        Token string_literal6=null;
        WaebricParser.moduleId_return moduleId2 = null;

        WaebricParser.imprt_return imprt3 = null;

        WaebricParser.site_return site4 = null;

        WaebricParser.function_return function5 = null;


        Object string_literal1_tree=null;
        Object string_literal6_tree=null;
        RewriteRuleTokenStream stream_END=new RewriteRuleTokenStream(adaptor,"token END");
        RewriteRuleTokenStream stream_MODULE=new RewriteRuleTokenStream(adaptor,"token MODULE");
        RewriteRuleSubtreeStream stream_imprt=new RewriteRuleSubtreeStream(adaptor,"rule imprt");
        RewriteRuleSubtreeStream stream_site=new RewriteRuleSubtreeStream(adaptor,"rule site");
        RewriteRuleSubtreeStream stream_moduleId=new RewriteRuleSubtreeStream(adaptor,"rule moduleId");
        RewriteRuleSubtreeStream stream_function=new RewriteRuleSubtreeStream(adaptor,"rule function");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:60:7: ( 'module' moduleId ( imprt | site | function )* 'end' -> ^( 'module' moduleId ( imprt )* ( site )* ( function )* 'end' ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:60:11: 'module' moduleId ( imprt | site | function )* 'end'
            {
            string_literal1=(Token)match(input,MODULE,FOLLOW_MODULE_in_module236); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_MODULE.add(string_literal1);

            pushFollow(FOLLOW_moduleId_in_module238);
            moduleId2=moduleId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_moduleId.add(moduleId2.getTree());
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:60:29: ( imprt | site | function )*
            loop1:
            do {
                int alt1=4;
                switch ( input.LA(1) ) {
                case IMPORT:
                    {
                    alt1=1;
                    }
                    break;
                case SITE:
                    {
                    alt1=2;
                    }
                    break;
                case DEF:
                    {
                    alt1=3;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:60:31: imprt
            	    {
            	    pushFollow(FOLLOW_imprt_in_module242);
            	    imprt3=imprt();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_imprt.add(imprt3.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:60:39: site
            	    {
            	    pushFollow(FOLLOW_site_in_module246);
            	    site4=site();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_site.add(site4.getTree());

            	    }
            	    break;
            	case 3 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:60:46: function
            	    {
            	    pushFollow(FOLLOW_function_in_module250);
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

            string_literal6=(Token)match(input,END,FOLLOW_END_in_module255); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_END.add(string_literal6);



            // AST REWRITE
            // elements: MODULE, function, END, moduleId, imprt, site
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 61:5: -> ^( 'module' moduleId ( imprt )* ( site )* ( function )* 'end' )
            {
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:61:8: ^( 'module' moduleId ( imprt )* ( site )* ( function )* 'end' )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_MODULE.nextNode(), root_1);

                adaptor.addChild(root_1, stream_moduleId.nextTree());
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:61:29: ( imprt )*
                while ( stream_imprt.hasNext() ) {
                    adaptor.addChild(root_1, stream_imprt.nextTree());

                }
                stream_imprt.reset();
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:61:36: ( site )*
                while ( stream_site.hasNext() ) {
                    adaptor.addChild(root_1, stream_site.nextTree());

                }
                stream_site.reset();
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:61:42: ( function )*
                while ( stream_function.hasNext() ) {
                    adaptor.addChild(root_1, stream_function.nextTree());

                }
                stream_function.reset();
                adaptor.addChild(root_1, stream_END.nextNode());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:63:1: moduleId returns [String path = \"\"] : e= IDCON ( '.' e= IDCON )* -> IDCON ( '.' IDCON )* ;
    public final WaebricParser.moduleId_return moduleId() throws RecognitionException {
        WaebricParser.moduleId_return retval = new WaebricParser.moduleId_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token e=null;
        Token char_literal7=null;

        Object e_tree=null;
        Object char_literal7_tree=null;
        RewriteRuleTokenStream stream_IDCON=new RewriteRuleTokenStream(adaptor,"token IDCON");
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:66:2: (e= IDCON ( '.' e= IDCON )* -> IDCON ( '.' IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:66:5: e= IDCON ( '.' e= IDCON )*
            {
            e=(Token)match(input,IDCON,FOLLOW_IDCON_in_moduleId307); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDCON.add(e);

            if ( state.backtracking==0 ) {
               retval.path += e.getText(); 
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:67:4: ( '.' e= IDCON )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==47) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:67:6: '.' e= IDCON
            	    {
            	    char_literal7=(Token)match(input,47,FOLLOW_47_in_moduleId317); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_47.add(char_literal7);

            	    e=(Token)match(input,IDCON,FOLLOW_IDCON_in_moduleId321); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_IDCON.add(e);

            	    if ( state.backtracking==0 ) {
            	       retval.path += "/" + e.getText(); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);



            // AST REWRITE
            // elements: IDCON, 47, IDCON
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 68:5: -> IDCON ( '.' IDCON )*
            {
                adaptor.addChild(root_0, stream_IDCON.nextNode());
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:68:14: ( '.' IDCON )*
                while ( stream_IDCON.hasNext()||stream_47.hasNext() ) {
                    adaptor.addChild(root_0, stream_47.nextNode());
                    adaptor.addChild(root_0, stream_IDCON.nextNode());

                }
                stream_IDCON.reset();
                stream_47.reset();

            }

            retval.tree = root_0;}
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:70:1: imprt : 'import' id= moduleId ';' -> ^( 'import' moduleId ';' ^() ) ;
    public final WaebricParser.imprt_return imprt() throws RecognitionException {
        WaebricParser.imprt_return retval = new WaebricParser.imprt_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal8=null;
        Token char_literal9=null;
        WaebricParser.moduleId_return id = null;


        Object string_literal8_tree=null;
        Object char_literal9_tree=null;
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_IMPORT=new RewriteRuleTokenStream(adaptor,"token IMPORT");
        RewriteRuleSubtreeStream stream_moduleId=new RewriteRuleSubtreeStream(adaptor,"rule moduleId");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:70:6: ( 'import' id= moduleId ';' -> ^( 'import' moduleId ';' ^() ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:70:10: 'import' id= moduleId ';'
            {
            string_literal8=(Token)match(input,IMPORT,FOLLOW_IMPORT_in_imprt354); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IMPORT.add(string_literal8);

            pushFollow(FOLLOW_moduleId_in_imprt358);
            id=moduleId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_moduleId.add(id.getTree());
            char_literal9=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_imprt360); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal9);



            // AST REWRITE
            // elements: SEMICOLON, IMPORT, moduleId
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 71:5: -> ^( 'import' moduleId ';' ^() )
            {
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:71:8: ^( 'import' moduleId ';' ^() )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_IMPORT.nextNode(), root_1);

                adaptor.addChild(root_1, stream_moduleId.nextTree());
                adaptor.addChild(root_1, stream_SEMICOLON.nextNode());
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:71:33: ^()
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot( parseFile((id!=null?id.path:null)) , root_2);

                adaptor.addChild(root_1, root_2);
                }

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:76:1: site : 'site' mappings 'end' -> ^( 'site' mappings 'end' ) ;
    public final WaebricParser.site_return site() throws RecognitionException {
        WaebricParser.site_return retval = new WaebricParser.site_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal10=null;
        Token string_literal12=null;
        WaebricParser.mappings_return mappings11 = null;


        Object string_literal10_tree=null;
        Object string_literal12_tree=null;
        RewriteRuleTokenStream stream_END=new RewriteRuleTokenStream(adaptor,"token END");
        RewriteRuleTokenStream stream_SITE=new RewriteRuleTokenStream(adaptor,"token SITE");
        RewriteRuleSubtreeStream stream_mappings=new RewriteRuleSubtreeStream(adaptor,"rule mappings");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:76:5: ( 'site' mappings 'end' -> ^( 'site' mappings 'end' ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:76:9: 'site' mappings 'end'
            {
            string_literal10=(Token)match(input,SITE,FOLLOW_SITE_in_site396); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SITE.add(string_literal10);

            pushFollow(FOLLOW_mappings_in_site398);
            mappings11=mappings();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_mappings.add(mappings11.getTree());
            string_literal12=(Token)match(input,END,FOLLOW_END_in_site400); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_END.add(string_literal12);



            // AST REWRITE
            // elements: SITE, END, mappings
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 77:5: -> ^( 'site' mappings 'end' )
            {
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:77:8: ^( 'site' mappings 'end' )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_SITE.nextNode(), root_1);

                adaptor.addChild(root_1, stream_mappings.nextTree());
                adaptor.addChild(root_1, stream_END.nextNode());

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
    // $ANTLR end "site"

    public static class mappings_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mappings"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:79:1: mappings : ( mapping )? ( ';' mapping )* ;
    public final WaebricParser.mappings_return mappings() throws RecognitionException {
        WaebricParser.mappings_return retval = new WaebricParser.mappings_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal14=null;
        WaebricParser.mapping_return mapping13 = null;

        WaebricParser.mapping_return mapping15 = null;


        Object char_literal14_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:79:9: ( ( mapping )? ( ';' mapping )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:79:12: ( mapping )? ( ';' mapping )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:79:12: ( mapping )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==PATH) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: mapping
                    {
                    pushFollow(FOLLOW_mapping_in_mappings429);
                    mapping13=mapping();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, mapping13.getTree());

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:79:21: ( ';' mapping )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==SEMICOLON) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:79:23: ';' mapping
            	    {
            	    char_literal14=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_mappings434); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal14_tree = (Object)adaptor.create(char_literal14);
            	    adaptor.addChild(root_0, char_literal14_tree);
            	    }
            	    pushFollow(FOLLOW_mapping_in_mappings436);
            	    mapping15=mapping();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, mapping15.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:80:1: mapping : PATH ':' markup ;
    public final WaebricParser.mapping_return mapping() throws RecognitionException {
        WaebricParser.mapping_return retval = new WaebricParser.mapping_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PATH16=null;
        Token char_literal17=null;
        WaebricParser.markup_return markup18 = null;


        Object PATH16_tree=null;
        Object char_literal17_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:80:9: ( PATH ':' markup )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:80:12: PATH ':' markup
            {
            root_0 = (Object)adaptor.nil();

            PATH16=(Token)match(input,PATH,FOLLOW_PATH_in_mapping448); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PATH16_tree = (Object)adaptor.create(PATH16);
            adaptor.addChild(root_0, PATH16_tree);
            }
            char_literal17=(Token)match(input,48,FOLLOW_48_in_mapping450); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal17_tree = (Object)adaptor.create(char_literal17);
            adaptor.addChild(root_0, char_literal17_tree);
            }
            pushFollow(FOLLOW_markup_in_mapping452);
            markup18=markup();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, markup18.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:85:1: markup : designator ( arguments )? ;
    public final WaebricParser.markup_return markup() throws RecognitionException {
        WaebricParser.markup_return retval = new WaebricParser.markup_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WaebricParser.designator_return designator19 = null;

        WaebricParser.arguments_return arguments20 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:85:7: ( designator ( arguments )? )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:85:11: designator ( arguments )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_designator_in_markup465);
            designator19=designator();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, designator19.getTree());
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:85:22: ( arguments )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==53) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: arguments
                    {
                    pushFollow(FOLLOW_arguments_in_markup467);
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

    public static class designator_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "designator"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:86:1: designator : IDCON ( attribute )* ;
    public final WaebricParser.designator_return designator() throws RecognitionException {
        WaebricParser.designator_return retval = new WaebricParser.designator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDCON21=null;
        WaebricParser.attribute_return attribute22 = null;


        Object IDCON21_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:86:11: ( IDCON ( attribute )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:86:14: IDCON ( attribute )*
            {
            root_0 = (Object)adaptor.nil();

            IDCON21=(Token)match(input,IDCON,FOLLOW_IDCON_in_designator476); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON21_tree = (Object)adaptor.create(IDCON21);
            adaptor.addChild(root_0, IDCON21_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:86:20: ( attribute )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=47 && LA6_0<=51)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: attribute
            	    {
            	    pushFollow(FOLLOW_attribute_in_designator478);
            	    attribute22=attribute();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, attribute22.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:87:1: attribute : ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON );
    public final WaebricParser.attribute_return attribute() throws RecognitionException {
        WaebricParser.attribute_return retval = new WaebricParser.attribute_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal23=null;
        Token IDCON24=null;
        Token char_literal25=null;
        Token IDCON26=null;
        Token char_literal27=null;
        Token IDCON28=null;
        Token char_literal29=null;
        Token IDCON30=null;
        Token char_literal31=null;
        Token NATCON32=null;
        Token char_literal33=null;
        Token NATCON34=null;
        Token char_literal35=null;
        Token NATCON36=null;

        Object char_literal23_tree=null;
        Object IDCON24_tree=null;
        Object char_literal25_tree=null;
        Object IDCON26_tree=null;
        Object char_literal27_tree=null;
        Object IDCON28_tree=null;
        Object char_literal29_tree=null;
        Object IDCON30_tree=null;
        Object char_literal31_tree=null;
        Object NATCON32_tree=null;
        Object char_literal33_tree=null;
        Object NATCON34_tree=null;
        Object char_literal35_tree=null;
        Object NATCON36_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:87:10: ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON )
            int alt7=6;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt7=1;
                }
                break;
            case 47:
                {
                alt7=2;
                }
                break;
            case 50:
                {
                alt7=3;
                }
                break;
            case 48:
                {
                alt7=4;
                }
                break;
            case 51:
                {
                int LA7_5 = input.LA(2);

                if ( (LA7_5==NATCON) ) {
                    int LA7_6 = input.LA(3);

                    if ( (LA7_6==52) ) {
                        alt7=6;
                    }
                    else if ( (LA7_6==EOF||(LA7_6>=END && LA7_6<=IF)||(LA7_6>=EACH && LA7_6<=LET)||(LA7_6>=COMMENT && LA7_6<=CDATA)||LA7_6==IDCON||(LA7_6>=NATCON && LA7_6<=SYMBOLCON)||(LA7_6>=POSTTEXT && LA7_6<=SEMICOLON)||(LA7_6>=47 && LA7_6<=51)||LA7_6==53||LA7_6==57||LA7_6==59||LA7_6==61) ) {
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:87:13: '#' IDCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal23=(Token)match(input,49,FOLLOW_49_in_attribute487); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal23_tree = (Object)adaptor.create(char_literal23);
                    adaptor.addChild(root_0, char_literal23_tree);
                    }
                    IDCON24=(Token)match(input,IDCON,FOLLOW_IDCON_in_attribute489); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON24_tree = (Object)adaptor.create(IDCON24);
                    adaptor.addChild(root_0, IDCON24_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:87:25: '.' IDCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal25=(Token)match(input,47,FOLLOW_47_in_attribute493); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal25_tree = (Object)adaptor.create(char_literal25);
                    adaptor.addChild(root_0, char_literal25_tree);
                    }
                    IDCON26=(Token)match(input,IDCON,FOLLOW_IDCON_in_attribute495); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON26_tree = (Object)adaptor.create(IDCON26);
                    adaptor.addChild(root_0, IDCON26_tree);
                    }

                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:87:37: '$' IDCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal27=(Token)match(input,50,FOLLOW_50_in_attribute499); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal27_tree = (Object)adaptor.create(char_literal27);
                    adaptor.addChild(root_0, char_literal27_tree);
                    }
                    IDCON28=(Token)match(input,IDCON,FOLLOW_IDCON_in_attribute501); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON28_tree = (Object)adaptor.create(IDCON28);
                    adaptor.addChild(root_0, IDCON28_tree);
                    }

                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:87:49: ':' IDCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal29=(Token)match(input,48,FOLLOW_48_in_attribute505); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal29_tree = (Object)adaptor.create(char_literal29);
                    adaptor.addChild(root_0, char_literal29_tree);
                    }
                    IDCON30=(Token)match(input,IDCON,FOLLOW_IDCON_in_attribute507); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON30_tree = (Object)adaptor.create(IDCON30);
                    adaptor.addChild(root_0, IDCON30_tree);
                    }

                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:88:4: '@' NATCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal31=(Token)match(input,51,FOLLOW_51_in_attribute515); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal31_tree = (Object)adaptor.create(char_literal31);
                    adaptor.addChild(root_0, char_literal31_tree);
                    }
                    NATCON32=(Token)match(input,NATCON,FOLLOW_NATCON_in_attribute517); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON32_tree = (Object)adaptor.create(NATCON32);
                    adaptor.addChild(root_0, NATCON32_tree);
                    }

                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:88:17: '@' NATCON '%' NATCON
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal33=(Token)match(input,51,FOLLOW_51_in_attribute521); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal33_tree = (Object)adaptor.create(char_literal33);
                    adaptor.addChild(root_0, char_literal33_tree);
                    }
                    NATCON34=(Token)match(input,NATCON,FOLLOW_NATCON_in_attribute523); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON34_tree = (Object)adaptor.create(NATCON34);
                    adaptor.addChild(root_0, NATCON34_tree);
                    }
                    char_literal35=(Token)match(input,52,FOLLOW_52_in_attribute525); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal35_tree = (Object)adaptor.create(char_literal35);
                    adaptor.addChild(root_0, char_literal35_tree);
                    }
                    NATCON36=(Token)match(input,NATCON,FOLLOW_NATCON_in_attribute527); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON36_tree = (Object)adaptor.create(NATCON36);
                    adaptor.addChild(root_0, NATCON36_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:89:1: arguments : '(' ( argument )? ( ',' argument )* ')' ;
    public final WaebricParser.arguments_return arguments() throws RecognitionException {
        WaebricParser.arguments_return retval = new WaebricParser.arguments_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal37=null;
        Token char_literal39=null;
        Token char_literal41=null;
        WaebricParser.argument_return argument38 = null;

        WaebricParser.argument_return argument40 = null;


        Object char_literal37_tree=null;
        Object char_literal39_tree=null;
        Object char_literal41_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:89:10: ( '(' ( argument )? ( ',' argument )* ')' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:89:13: '(' ( argument )? ( ',' argument )* ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal37=(Token)match(input,53,FOLLOW_53_in_arguments534); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal37_tree = (Object)adaptor.create(char_literal37);
            adaptor.addChild(root_0, char_literal37_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:89:17: ( argument )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==IDCON||(LA8_0>=NATCON && LA8_0<=SYMBOLCON)||LA8_0==57||LA8_0==59) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: argument
                    {
                    pushFollow(FOLLOW_argument_in_arguments536);
                    argument38=argument();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, argument38.getTree());

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:89:27: ( ',' argument )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==54) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:89:29: ',' argument
            	    {
            	    char_literal39=(Token)match(input,54,FOLLOW_54_in_arguments541); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal39_tree = (Object)adaptor.create(char_literal39);
            	    adaptor.addChild(root_0, char_literal39_tree);
            	    }
            	    pushFollow(FOLLOW_argument_in_arguments543);
            	    argument40=argument();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, argument40.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            char_literal41=(Token)match(input,55,FOLLOW_55_in_arguments548); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal41_tree = (Object)adaptor.create(char_literal41);
            adaptor.addChild(root_0, char_literal41_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:90:1: argument : expression ;
    public final WaebricParser.argument_return argument() throws RecognitionException {
        WaebricParser.argument_return retval = new WaebricParser.argument_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WaebricParser.expression_return expression42 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:90:9: ( expression )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:90:12: expression
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_expression_in_argument556);
            expression42=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression42.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:95:1: expression : ( varExpression | natExpression | textExpression | symbolExpression | listExpression | recordExpression ) ( '+' expression | '.' IDCON )* ;
    public final WaebricParser.expression_return expression() throws RecognitionException {
        WaebricParser.expression_return retval = new WaebricParser.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal49=null;
        Token char_literal51=null;
        Token IDCON52=null;
        WaebricParser.varExpression_return varExpression43 = null;

        WaebricParser.natExpression_return natExpression44 = null;

        WaebricParser.textExpression_return textExpression45 = null;

        WaebricParser.symbolExpression_return symbolExpression46 = null;

        WaebricParser.listExpression_return listExpression47 = null;

        WaebricParser.recordExpression_return recordExpression48 = null;

        WaebricParser.expression_return expression50 = null;


        Object char_literal49_tree=null;
        Object char_literal51_tree=null;
        Object IDCON52_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:95:11: ( ( varExpression | natExpression | textExpression | symbolExpression | listExpression | recordExpression ) ( '+' expression | '.' IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:95:14: ( varExpression | natExpression | textExpression | symbolExpression | listExpression | recordExpression ) ( '+' expression | '.' IDCON )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:95:14: ( varExpression | natExpression | textExpression | symbolExpression | listExpression | recordExpression )
            int alt10=6;
            switch ( input.LA(1) ) {
            case IDCON:
                {
                alt10=1;
                }
                break;
            case NATCON:
                {
                alt10=2;
                }
                break;
            case TEXT:
                {
                alt10=3;
                }
                break;
            case SYMBOLCON:
                {
                alt10=4;
                }
                break;
            case 57:
                {
                alt10=5;
                }
                break;
            case 59:
                {
                alt10=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:95:16: varExpression
                    {
                    pushFollow(FOLLOW_varExpression_in_expression570);
                    varExpression43=varExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, varExpression43.getTree());

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:95:32: natExpression
                    {
                    pushFollow(FOLLOW_natExpression_in_expression574);
                    natExpression44=natExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, natExpression44.getTree());

                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:95:48: textExpression
                    {
                    pushFollow(FOLLOW_textExpression_in_expression578);
                    textExpression45=textExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, textExpression45.getTree());

                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:95:65: symbolExpression
                    {
                    pushFollow(FOLLOW_symbolExpression_in_expression582);
                    symbolExpression46=symbolExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, symbolExpression46.getTree());

                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:95:84: listExpression
                    {
                    pushFollow(FOLLOW_listExpression_in_expression586);
                    listExpression47=listExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, listExpression47.getTree());

                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:95:101: recordExpression
                    {
                    pushFollow(FOLLOW_recordExpression_in_expression590);
                    recordExpression48=recordExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, recordExpression48.getTree());

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:96:4: ( '+' expression | '.' IDCON )*
            loop11:
            do {
                int alt11=3;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==56) ) {
                    int LA11_2 = input.LA(2);

                    if ( (synpred21_Waebric()) ) {
                        alt11=1;
                    }


                }
                else if ( (LA11_0==47) ) {
                    int LA11_3 = input.LA(2);

                    if ( (synpred22_Waebric()) ) {
                        alt11=2;
                    }


                }


                switch (alt11) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:96:6: '+' expression
            	    {
            	    char_literal49=(Token)match(input,56,FOLLOW_56_in_expression599); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal49_tree = (Object)adaptor.create(char_literal49);
            	    adaptor.addChild(root_0, char_literal49_tree);
            	    }
            	    pushFollow(FOLLOW_expression_in_expression601);
            	    expression50=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression50.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:96:44: '.' IDCON
            	    {
            	    char_literal51=(Token)match(input,47,FOLLOW_47_in_expression607); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal51_tree = (Object)adaptor.create(char_literal51);
            	    adaptor.addChild(root_0, char_literal51_tree);
            	    }
            	    IDCON52=(Token)match(input,IDCON,FOLLOW_IDCON_in_expression609); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDCON52_tree = (Object)adaptor.create(IDCON52);
            	    adaptor.addChild(root_0, IDCON52_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop11;
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

    public static class varExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "varExpression"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:97:1: varExpression : IDCON ;
    public final WaebricParser.varExpression_return varExpression() throws RecognitionException {
        WaebricParser.varExpression_return retval = new WaebricParser.varExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDCON53=null;

        Object IDCON53_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:97:14: ( IDCON )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:97:17: IDCON
            {
            root_0 = (Object)adaptor.nil();

            IDCON53=(Token)match(input,IDCON,FOLLOW_IDCON_in_varExpression622); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON53_tree = (Object)adaptor.create(IDCON53);
            adaptor.addChild(root_0, IDCON53_tree);
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
    // $ANTLR end "varExpression"

    public static class natExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "natExpression"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:98:1: natExpression : NATCON ;
    public final WaebricParser.natExpression_return natExpression() throws RecognitionException {
        WaebricParser.natExpression_return retval = new WaebricParser.natExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NATCON54=null;

        Object NATCON54_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:98:14: ( NATCON )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:98:17: NATCON
            {
            root_0 = (Object)adaptor.nil();

            NATCON54=(Token)match(input,NATCON,FOLLOW_NATCON_in_natExpression630); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NATCON54_tree = (Object)adaptor.create(NATCON54);
            adaptor.addChild(root_0, NATCON54_tree);
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
    // $ANTLR end "natExpression"

    public static class textExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "textExpression"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:99:1: textExpression : TEXT ;
    public final WaebricParser.textExpression_return textExpression() throws RecognitionException {
        WaebricParser.textExpression_return retval = new WaebricParser.textExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TEXT55=null;

        Object TEXT55_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:99:15: ( TEXT )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:99:18: TEXT
            {
            root_0 = (Object)adaptor.nil();

            TEXT55=(Token)match(input,TEXT,FOLLOW_TEXT_in_textExpression638); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TEXT55_tree = (Object)adaptor.create(TEXT55);
            adaptor.addChild(root_0, TEXT55_tree);
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
    // $ANTLR end "textExpression"

    public static class symbolExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "symbolExpression"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:100:1: symbolExpression : SYMBOLCON ;
    public final WaebricParser.symbolExpression_return symbolExpression() throws RecognitionException {
        WaebricParser.symbolExpression_return retval = new WaebricParser.symbolExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SYMBOLCON56=null;

        Object SYMBOLCON56_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:100:17: ( SYMBOLCON )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:100:19: SYMBOLCON
            {
            root_0 = (Object)adaptor.nil();

            SYMBOLCON56=(Token)match(input,SYMBOLCON,FOLLOW_SYMBOLCON_in_symbolExpression645); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SYMBOLCON56_tree = (Object)adaptor.create(SYMBOLCON56);
            adaptor.addChild(root_0, SYMBOLCON56_tree);
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
    // $ANTLR end "symbolExpression"

    public static class listExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "listExpression"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:101:1: listExpression : '[' ( expression )? ( ',' expression )* ']' ;
    public final WaebricParser.listExpression_return listExpression() throws RecognitionException {
        WaebricParser.listExpression_return retval = new WaebricParser.listExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal57=null;
        Token char_literal59=null;
        Token char_literal61=null;
        WaebricParser.expression_return expression58 = null;

        WaebricParser.expression_return expression60 = null;


        Object char_literal57_tree=null;
        Object char_literal59_tree=null;
        Object char_literal61_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:101:15: ( '[' ( expression )? ( ',' expression )* ']' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:101:18: '[' ( expression )? ( ',' expression )* ']'
            {
            root_0 = (Object)adaptor.nil();

            char_literal57=(Token)match(input,57,FOLLOW_57_in_listExpression656); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal57_tree = (Object)adaptor.create(char_literal57);
            adaptor.addChild(root_0, char_literal57_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:101:22: ( expression )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==IDCON||(LA12_0>=NATCON && LA12_0<=SYMBOLCON)||LA12_0==57||LA12_0==59) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: expression
                    {
                    pushFollow(FOLLOW_expression_in_listExpression658);
                    expression58=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression58.getTree());

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:101:34: ( ',' expression )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==54) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:101:36: ',' expression
            	    {
            	    char_literal59=(Token)match(input,54,FOLLOW_54_in_listExpression663); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal59_tree = (Object)adaptor.create(char_literal59);
            	    adaptor.addChild(root_0, char_literal59_tree);
            	    }
            	    pushFollow(FOLLOW_expression_in_listExpression665);
            	    expression60=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression60.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            char_literal61=(Token)match(input,58,FOLLOW_58_in_listExpression670); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal61_tree = (Object)adaptor.create(char_literal61);
            adaptor.addChild(root_0, char_literal61_tree);
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
    // $ANTLR end "listExpression"

    public static class recordExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "recordExpression"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:102:1: recordExpression : '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ;
    public final WaebricParser.recordExpression_return recordExpression() throws RecognitionException {
        WaebricParser.recordExpression_return retval = new WaebricParser.recordExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal62=null;
        Token char_literal64=null;
        Token char_literal66=null;
        WaebricParser.keyValuePair_return keyValuePair63 = null;

        WaebricParser.keyValuePair_return keyValuePair65 = null;


        Object char_literal62_tree=null;
        Object char_literal64_tree=null;
        Object char_literal66_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:102:17: ( '{' ( keyValuePair )? ( ',' keyValuePair )* '}' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:102:19: '{' ( keyValuePair )? ( ',' keyValuePair )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal62=(Token)match(input,59,FOLLOW_59_in_recordExpression677); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal62_tree = (Object)adaptor.create(char_literal62);
            adaptor.addChild(root_0, char_literal62_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:102:23: ( keyValuePair )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==IDCON) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: keyValuePair
                    {
                    pushFollow(FOLLOW_keyValuePair_in_recordExpression679);
                    keyValuePair63=keyValuePair();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, keyValuePair63.getTree());

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:102:37: ( ',' keyValuePair )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==54) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:102:39: ',' keyValuePair
            	    {
            	    char_literal64=(Token)match(input,54,FOLLOW_54_in_recordExpression684); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal64_tree = (Object)adaptor.create(char_literal64);
            	    adaptor.addChild(root_0, char_literal64_tree);
            	    }
            	    pushFollow(FOLLOW_keyValuePair_in_recordExpression686);
            	    keyValuePair65=keyValuePair();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, keyValuePair65.getTree());

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            char_literal66=(Token)match(input,60,FOLLOW_60_in_recordExpression691); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal66_tree = (Object)adaptor.create(char_literal66);
            adaptor.addChild(root_0, char_literal66_tree);
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
    // $ANTLR end "recordExpression"

    public static class keyValuePair_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "keyValuePair"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:103:1: keyValuePair : IDCON ':' expression ;
    public final WaebricParser.keyValuePair_return keyValuePair() throws RecognitionException {
        WaebricParser.keyValuePair_return retval = new WaebricParser.keyValuePair_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDCON67=null;
        Token char_literal68=null;
        WaebricParser.expression_return expression69 = null;


        Object IDCON67_tree=null;
        Object char_literal68_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:103:13: ( IDCON ':' expression )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:103:16: IDCON ':' expression
            {
            root_0 = (Object)adaptor.nil();

            IDCON67=(Token)match(input,IDCON,FOLLOW_IDCON_in_keyValuePair699); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON67_tree = (Object)adaptor.create(IDCON67);
            adaptor.addChild(root_0, IDCON67_tree);
            }
            char_literal68=(Token)match(input,48,FOLLOW_48_in_keyValuePair701); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal68_tree = (Object)adaptor.create(char_literal68);
            adaptor.addChild(root_0, char_literal68_tree);
            }
            pushFollow(FOLLOW_expression_in_keyValuePair703);
            expression69=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression69.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:108:1: function : 'def' IDCON ( formals )? ( statement )* 'end' -> ^( 'def' IDCON ( formals )? ( statement )* 'end' ) ;
    public final WaebricParser.function_return function() throws RecognitionException {
        WaebricParser.function_return retval = new WaebricParser.function_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal70=null;
        Token IDCON71=null;
        Token string_literal74=null;
        WaebricParser.formals_return formals72 = null;

        WaebricParser.statement_return statement73 = null;


        Object string_literal70_tree=null;
        Object IDCON71_tree=null;
        Object string_literal74_tree=null;
        RewriteRuleTokenStream stream_DEF=new RewriteRuleTokenStream(adaptor,"token DEF");
        RewriteRuleTokenStream stream_END=new RewriteRuleTokenStream(adaptor,"token END");
        RewriteRuleTokenStream stream_IDCON=new RewriteRuleTokenStream(adaptor,"token IDCON");
        RewriteRuleSubtreeStream stream_formals=new RewriteRuleSubtreeStream(adaptor,"rule formals");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:108:9: ( 'def' IDCON ( formals )? ( statement )* 'end' -> ^( 'def' IDCON ( formals )? ( statement )* 'end' ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:108:12: 'def' IDCON ( formals )? ( statement )* 'end'
            {
            string_literal70=(Token)match(input,DEF,FOLLOW_DEF_in_function715); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DEF.add(string_literal70);

            IDCON71=(Token)match(input,IDCON,FOLLOW_IDCON_in_function717); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDCON.add(IDCON71);

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:108:24: ( formals )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==53) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: formals
                    {
                    pushFollow(FOLLOW_formals_in_function719);
                    formals72=formals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_formals.add(formals72.getTree());

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:108:33: ( statement )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==IF||(LA17_0>=EACH && LA17_0<=LET)||(LA17_0>=COMMENT && LA17_0<=CDATA)||LA17_0==IDCON||LA17_0==59||LA17_0==61) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_function722);
            	    statement73=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statement.add(statement73.getTree());

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            string_literal74=(Token)match(input,END,FOLLOW_END_in_function725); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_END.add(string_literal74);



            // AST REWRITE
            // elements: statement, formals, DEF, END, IDCON
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 109:5: -> ^( 'def' IDCON ( formals )? ( statement )* 'end' )
            {
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:109:8: ^( 'def' IDCON ( formals )? ( statement )* 'end' )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_DEF.nextNode(), root_1);

                adaptor.addChild(root_1, stream_IDCON.nextNode());
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:109:23: ( formals )?
                if ( stream_formals.hasNext() ) {
                    adaptor.addChild(root_1, stream_formals.nextTree());

                }
                stream_formals.reset();
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:109:32: ( statement )*
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:111:1: formals : '(' ( IDCON )? ( ',' IDCON )* ')' -> '(' ( IDCON )* ')' ;
    public final WaebricParser.formals_return formals() throws RecognitionException {
        WaebricParser.formals_return retval = new WaebricParser.formals_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal75=null;
        Token IDCON76=null;
        Token char_literal77=null;
        Token IDCON78=null;
        Token char_literal79=null;

        Object char_literal75_tree=null;
        Object IDCON76_tree=null;
        Object char_literal77_tree=null;
        Object IDCON78_tree=null;
        Object char_literal79_tree=null;
        RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
        RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
        RewriteRuleTokenStream stream_IDCON=new RewriteRuleTokenStream(adaptor,"token IDCON");
        RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:111:8: ( '(' ( IDCON )? ( ',' IDCON )* ')' -> '(' ( IDCON )* ')' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:111:11: '(' ( IDCON )? ( ',' IDCON )* ')'
            {
            char_literal75=(Token)match(input,53,FOLLOW_53_in_formals761); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_53.add(char_literal75);

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:111:15: ( IDCON )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==IDCON) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: IDCON
                    {
                    IDCON76=(Token)match(input,IDCON,FOLLOW_IDCON_in_formals763); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDCON.add(IDCON76);


                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:111:22: ( ',' IDCON )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==54) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:111:24: ',' IDCON
            	    {
            	    char_literal77=(Token)match(input,54,FOLLOW_54_in_formals768); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_54.add(char_literal77);

            	    IDCON78=(Token)match(input,IDCON,FOLLOW_IDCON_in_formals770); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_IDCON.add(IDCON78);


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            char_literal79=(Token)match(input,55,FOLLOW_55_in_formals775); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_55.add(char_literal79);



            // AST REWRITE
            // elements: 53, IDCON, 55
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 112:5: -> '(' ( IDCON )* ')'
            {
                adaptor.addChild(root_0, stream_53.nextNode());
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:112:12: ( IDCON )*
                while ( stream_IDCON.hasNext() ) {
                    adaptor.addChild(root_0, stream_IDCON.nextNode());

                }
                stream_IDCON.reset();
                adaptor.addChild(root_0, stream_55.nextNode());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:118:1: statement : ( ifElseStatement | ifStatement | eachStatement | letStatement | blockStatement | commentStatement | echoStatement | cdataStatement | yieldStatement | markupStatements );
    public final WaebricParser.statement_return statement() throws RecognitionException {
        WaebricParser.statement_return retval = new WaebricParser.statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WaebricParser.ifElseStatement_return ifElseStatement80 = null;

        WaebricParser.ifStatement_return ifStatement81 = null;

        WaebricParser.eachStatement_return eachStatement82 = null;

        WaebricParser.letStatement_return letStatement83 = null;

        WaebricParser.blockStatement_return blockStatement84 = null;

        WaebricParser.commentStatement_return commentStatement85 = null;

        WaebricParser.echoStatement_return echoStatement86 = null;

        WaebricParser.cdataStatement_return cdataStatement87 = null;

        WaebricParser.yieldStatement_return yieldStatement88 = null;

        WaebricParser.markupStatements_return markupStatements89 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:118:10: ( ifElseStatement | ifStatement | eachStatement | letStatement | blockStatement | commentStatement | echoStatement | cdataStatement | yieldStatement | markupStatements )
            int alt20=10;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:118:13: ifElseStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ifElseStatement_in_statement802);
                    ifElseStatement80=ifElseStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ifElseStatement80.getTree());

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:118:31: ifStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ifStatement_in_statement806);
                    ifStatement81=ifStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStatement81.getTree());

                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:118:45: eachStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_eachStatement_in_statement810);
                    eachStatement82=eachStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, eachStatement82.getTree());

                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:118:61: letStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_letStatement_in_statement814);
                    letStatement83=letStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, letStatement83.getTree());

                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:118:76: blockStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_blockStatement_in_statement818);
                    blockStatement84=blockStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, blockStatement84.getTree());

                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:118:93: commentStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_commentStatement_in_statement822);
                    commentStatement85=commentStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, commentStatement85.getTree());

                    }
                    break;
                case 7 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:119:4: echoStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_echoStatement_in_statement829);
                    echoStatement86=echoStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, echoStatement86.getTree());

                    }
                    break;
                case 8 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:119:20: cdataStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_cdataStatement_in_statement833);
                    cdataStatement87=cdataStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cdataStatement87.getTree());

                    }
                    break;
                case 9 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:119:37: yieldStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_yieldStatement_in_statement837);
                    yieldStatement88=yieldStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, yieldStatement88.getTree());

                    }
                    break;
                case 10 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:119:54: markupStatements
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_markupStatements_in_statement841);
                    markupStatements89=markupStatements();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, markupStatements89.getTree());

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

    public static class ifStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ifStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:120:1: ifStatement : 'if' '(' predicate ')' statement ;
    public final WaebricParser.ifStatement_return ifStatement() throws RecognitionException {
        WaebricParser.ifStatement_return retval = new WaebricParser.ifStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal90=null;
        Token char_literal91=null;
        Token char_literal93=null;
        WaebricParser.predicate_return predicate92 = null;

        WaebricParser.statement_return statement94 = null;


        Object string_literal90_tree=null;
        Object char_literal91_tree=null;
        Object char_literal93_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:120:12: ( 'if' '(' predicate ')' statement )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:120:15: 'if' '(' predicate ')' statement
            {
            root_0 = (Object)adaptor.nil();

            string_literal90=(Token)match(input,IF,FOLLOW_IF_in_ifStatement849); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal90_tree = (Object)adaptor.create(string_literal90);
            adaptor.addChild(root_0, string_literal90_tree);
            }
            char_literal91=(Token)match(input,53,FOLLOW_53_in_ifStatement851); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal91_tree = (Object)adaptor.create(char_literal91);
            adaptor.addChild(root_0, char_literal91_tree);
            }
            pushFollow(FOLLOW_predicate_in_ifStatement853);
            predicate92=predicate();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate92.getTree());
            char_literal93=(Token)match(input,55,FOLLOW_55_in_ifStatement855); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal93_tree = (Object)adaptor.create(char_literal93);
            adaptor.addChild(root_0, char_literal93_tree);
            }
            pushFollow(FOLLOW_statement_in_ifStatement857);
            statement94=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement94.getTree());

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
    // $ANTLR end "ifStatement"

    public static class ifElseStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ifElseStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:121:1: ifElseStatement : 'if' '(' predicate ')' statement 'else' statement ;
    public final WaebricParser.ifElseStatement_return ifElseStatement() throws RecognitionException {
        WaebricParser.ifElseStatement_return retval = new WaebricParser.ifElseStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal95=null;
        Token char_literal96=null;
        Token char_literal98=null;
        Token string_literal100=null;
        WaebricParser.predicate_return predicate97 = null;

        WaebricParser.statement_return statement99 = null;

        WaebricParser.statement_return statement101 = null;


        Object string_literal95_tree=null;
        Object char_literal96_tree=null;
        Object char_literal98_tree=null;
        Object string_literal100_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:121:16: ( 'if' '(' predicate ')' statement 'else' statement )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:121:18: 'if' '(' predicate ')' statement 'else' statement
            {
            root_0 = (Object)adaptor.nil();

            string_literal95=(Token)match(input,IF,FOLLOW_IF_in_ifElseStatement864); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal95_tree = (Object)adaptor.create(string_literal95);
            adaptor.addChild(root_0, string_literal95_tree);
            }
            char_literal96=(Token)match(input,53,FOLLOW_53_in_ifElseStatement866); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal96_tree = (Object)adaptor.create(char_literal96);
            adaptor.addChild(root_0, char_literal96_tree);
            }
            pushFollow(FOLLOW_predicate_in_ifElseStatement868);
            predicate97=predicate();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate97.getTree());
            char_literal98=(Token)match(input,55,FOLLOW_55_in_ifElseStatement870); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal98_tree = (Object)adaptor.create(char_literal98);
            adaptor.addChild(root_0, char_literal98_tree);
            }
            pushFollow(FOLLOW_statement_in_ifElseStatement872);
            statement99=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement99.getTree());
            string_literal100=(Token)match(input,ELSE,FOLLOW_ELSE_in_ifElseStatement874); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal100_tree = (Object)adaptor.create(string_literal100);
            adaptor.addChild(root_0, string_literal100_tree);
            }
            pushFollow(FOLLOW_statement_in_ifElseStatement876);
            statement101=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement101.getTree());

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
    // $ANTLR end "ifElseStatement"

    public static class eachStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "eachStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:122:1: eachStatement : 'each' '(' IDCON ':' expression ')' statement ;
    public final WaebricParser.eachStatement_return eachStatement() throws RecognitionException {
        WaebricParser.eachStatement_return retval = new WaebricParser.eachStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal102=null;
        Token char_literal103=null;
        Token IDCON104=null;
        Token char_literal105=null;
        Token char_literal107=null;
        WaebricParser.expression_return expression106 = null;

        WaebricParser.statement_return statement108 = null;


        Object string_literal102_tree=null;
        Object char_literal103_tree=null;
        Object IDCON104_tree=null;
        Object char_literal105_tree=null;
        Object char_literal107_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:122:14: ( 'each' '(' IDCON ':' expression ')' statement )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:122:17: 'each' '(' IDCON ':' expression ')' statement
            {
            root_0 = (Object)adaptor.nil();

            string_literal102=(Token)match(input,EACH,FOLLOW_EACH_in_eachStatement885); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal102_tree = (Object)adaptor.create(string_literal102);
            adaptor.addChild(root_0, string_literal102_tree);
            }
            char_literal103=(Token)match(input,53,FOLLOW_53_in_eachStatement887); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal103_tree = (Object)adaptor.create(char_literal103);
            adaptor.addChild(root_0, char_literal103_tree);
            }
            IDCON104=(Token)match(input,IDCON,FOLLOW_IDCON_in_eachStatement889); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON104_tree = (Object)adaptor.create(IDCON104);
            adaptor.addChild(root_0, IDCON104_tree);
            }
            char_literal105=(Token)match(input,48,FOLLOW_48_in_eachStatement891); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal105_tree = (Object)adaptor.create(char_literal105);
            adaptor.addChild(root_0, char_literal105_tree);
            }
            pushFollow(FOLLOW_expression_in_eachStatement893);
            expression106=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression106.getTree());
            char_literal107=(Token)match(input,55,FOLLOW_55_in_eachStatement895); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal107_tree = (Object)adaptor.create(char_literal107);
            adaptor.addChild(root_0, char_literal107_tree);
            }
            pushFollow(FOLLOW_statement_in_eachStatement897);
            statement108=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement108.getTree());

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
    // $ANTLR end "eachStatement"

    public static class letStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "letStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:123:1: letStatement : 'let' ( assignment )+ 'in' ( statement )* 'end' ;
    public final WaebricParser.letStatement_return letStatement() throws RecognitionException {
        WaebricParser.letStatement_return retval = new WaebricParser.letStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal109=null;
        Token string_literal111=null;
        Token string_literal113=null;
        WaebricParser.assignment_return assignment110 = null;

        WaebricParser.statement_return statement112 = null;


        Object string_literal109_tree=null;
        Object string_literal111_tree=null;
        Object string_literal113_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:123:13: ( 'let' ( assignment )+ 'in' ( statement )* 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:123:16: 'let' ( assignment )+ 'in' ( statement )* 'end'
            {
            root_0 = (Object)adaptor.nil();

            string_literal109=(Token)match(input,LET,FOLLOW_LET_in_letStatement906); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal109_tree = (Object)adaptor.create(string_literal109);
            adaptor.addChild(root_0, string_literal109_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:123:22: ( assignment )+
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
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: assignment
            	    {
            	    pushFollow(FOLLOW_assignment_in_letStatement908);
            	    assignment110=assignment();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignment110.getTree());

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

            string_literal111=(Token)match(input,IN,FOLLOW_IN_in_letStatement911); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal111_tree = (Object)adaptor.create(string_literal111);
            adaptor.addChild(root_0, string_literal111_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:123:39: ( statement )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==IF||(LA22_0>=EACH && LA22_0<=LET)||(LA22_0>=COMMENT && LA22_0<=CDATA)||LA22_0==IDCON||LA22_0==59||LA22_0==61) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_letStatement913);
            	    statement112=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement112.getTree());

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            string_literal113=(Token)match(input,END,FOLLOW_END_in_letStatement916); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal113_tree = (Object)adaptor.create(string_literal113);
            adaptor.addChild(root_0, string_literal113_tree);
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
    // $ANTLR end "letStatement"

    public static class blockStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "blockStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:124:1: blockStatement : '{' ( statement )* '}' ;
    public final WaebricParser.blockStatement_return blockStatement() throws RecognitionException {
        WaebricParser.blockStatement_return retval = new WaebricParser.blockStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal114=null;
        Token char_literal116=null;
        WaebricParser.statement_return statement115 = null;


        Object char_literal114_tree=null;
        Object char_literal116_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:124:15: ( '{' ( statement )* '}' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:124:18: '{' ( statement )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal114=(Token)match(input,59,FOLLOW_59_in_blockStatement924); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal114_tree = (Object)adaptor.create(char_literal114);
            adaptor.addChild(root_0, char_literal114_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:124:22: ( statement )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==IF||(LA23_0>=EACH && LA23_0<=LET)||(LA23_0>=COMMENT && LA23_0<=CDATA)||LA23_0==IDCON||LA23_0==59||LA23_0==61) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_blockStatement926);
            	    statement115=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement115.getTree());

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            char_literal116=(Token)match(input,60,FOLLOW_60_in_blockStatement929); if (state.failed) return retval;
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
    // $ANTLR end "blockStatement"

    public static class commentStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "commentStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:125:1: commentStatement : 'comment' STRCON ';' ;
    public final WaebricParser.commentStatement_return commentStatement() throws RecognitionException {
        WaebricParser.commentStatement_return retval = new WaebricParser.commentStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal117=null;
        Token STRCON118=null;
        Token char_literal119=null;

        Object string_literal117_tree=null;
        Object STRCON118_tree=null;
        Object char_literal119_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:125:17: ( 'comment' STRCON ';' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:125:19: 'comment' STRCON ';'
            {
            root_0 = (Object)adaptor.nil();

            string_literal117=(Token)match(input,COMMENT,FOLLOW_COMMENT_in_commentStatement936); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal117_tree = (Object)adaptor.create(string_literal117);
            adaptor.addChild(root_0, string_literal117_tree);
            }
            STRCON118=(Token)match(input,STRCON,FOLLOW_STRCON_in_commentStatement938); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRCON118_tree = (Object)adaptor.create(STRCON118);
            adaptor.addChild(root_0, STRCON118_tree);
            }
            char_literal119=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_commentStatement940); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal119_tree = (Object)adaptor.create(char_literal119);
            adaptor.addChild(root_0, char_literal119_tree);
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
    // $ANTLR end "commentStatement"

    public static class echoStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "echoStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:126:1: echoStatement : ( 'echo' expression ';' | 'echo' embedding ';' );
    public final WaebricParser.echoStatement_return echoStatement() throws RecognitionException {
        WaebricParser.echoStatement_return retval = new WaebricParser.echoStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal120=null;
        Token char_literal122=null;
        Token string_literal123=null;
        Token char_literal125=null;
        WaebricParser.expression_return expression121 = null;

        WaebricParser.embedding_return embedding124 = null;


        Object string_literal120_tree=null;
        Object char_literal122_tree=null;
        Object string_literal123_tree=null;
        Object char_literal125_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:126:14: ( 'echo' expression ';' | 'echo' embedding ';' )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==ECHO) ) {
                int LA24_1 = input.LA(2);

                if ( (LA24_1==PRETEXT) ) {
                    alt24=2;
                }
                else if ( (LA24_1==IDCON||(LA24_1>=NATCON && LA24_1<=SYMBOLCON)||LA24_1==57||LA24_1==59) ) {
                    alt24=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 24, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:126:17: 'echo' expression ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal120=(Token)match(input,ECHO,FOLLOW_ECHO_in_echoStatement948); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal120_tree = (Object)adaptor.create(string_literal120);
                    adaptor.addChild(root_0, string_literal120_tree);
                    }
                    pushFollow(FOLLOW_expression_in_echoStatement950);
                    expression121=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression121.getTree());
                    char_literal122=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_echoStatement952); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal122_tree = (Object)adaptor.create(char_literal122);
                    adaptor.addChild(root_0, char_literal122_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:126:42: 'echo' embedding ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal123=(Token)match(input,ECHO,FOLLOW_ECHO_in_echoStatement957); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal123_tree = (Object)adaptor.create(string_literal123);
                    adaptor.addChild(root_0, string_literal123_tree);
                    }
                    pushFollow(FOLLOW_embedding_in_echoStatement959);
                    embedding124=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, embedding124.getTree());
                    char_literal125=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_echoStatement961); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal125_tree = (Object)adaptor.create(char_literal125);
                    adaptor.addChild(root_0, char_literal125_tree);
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
    // $ANTLR end "echoStatement"

    public static class cdataStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "cdataStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:127:1: cdataStatement : 'cdata' expression ';' ;
    public final WaebricParser.cdataStatement_return cdataStatement() throws RecognitionException {
        WaebricParser.cdataStatement_return retval = new WaebricParser.cdataStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal126=null;
        Token char_literal128=null;
        WaebricParser.expression_return expression127 = null;


        Object string_literal126_tree=null;
        Object char_literal128_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:127:15: ( 'cdata' expression ';' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:127:18: 'cdata' expression ';'
            {
            root_0 = (Object)adaptor.nil();

            string_literal126=(Token)match(input,CDATA,FOLLOW_CDATA_in_cdataStatement969); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal126_tree = (Object)adaptor.create(string_literal126);
            adaptor.addChild(root_0, string_literal126_tree);
            }
            pushFollow(FOLLOW_expression_in_cdataStatement971);
            expression127=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression127.getTree());
            char_literal128=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_cdataStatement973); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal128_tree = (Object)adaptor.create(char_literal128);
            adaptor.addChild(root_0, char_literal128_tree);
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
    // $ANTLR end "cdataStatement"

    public static class yieldStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "yieldStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:128:1: yieldStatement : 'yield;' ;
    public final WaebricParser.yieldStatement_return yieldStatement() throws RecognitionException {
        WaebricParser.yieldStatement_return retval = new WaebricParser.yieldStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal129=null;

        Object string_literal129_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:128:15: ( 'yield;' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:128:18: 'yield;'
            {
            root_0 = (Object)adaptor.nil();

            string_literal129=(Token)match(input,61,FOLLOW_61_in_yieldStatement981); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal129_tree = (Object)adaptor.create(string_literal129);
            adaptor.addChild(root_0, string_literal129_tree);
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
    // $ANTLR end "yieldStatement"

    public static class markupStatements_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "markupStatements"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:130:1: markupStatements : ( functionCall | markupExpression | markupStatement | markupMarkup );
    public final WaebricParser.markupStatements_return markupStatements() throws RecognitionException {
        WaebricParser.markupStatements_return retval = new WaebricParser.markupStatements_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WaebricParser.functionCall_return functionCall130 = null;

        WaebricParser.markupExpression_return markupExpression131 = null;

        WaebricParser.markupStatement_return markupStatement132 = null;

        WaebricParser.markupMarkup_return markupMarkup133 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:130:17: ( functionCall | markupExpression | markupStatement | markupMarkup )
            int alt25=4;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==IDCON) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==SEMICOLON||(LA25_1>=47 && LA25_1<=51)||LA25_1==53) ) {
                    alt25=1;
                }
                else if ( (synpred45_Waebric()) ) {
                    alt25=2;
                }
                else if ( (synpred46_Waebric()) ) {
                    alt25=3;
                }
                else if ( (true) ) {
                    alt25=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:130:19: functionCall
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_functionCall_in_markupStatements989);
                    functionCall130=functionCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionCall130.getTree());

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:130:34: markupExpression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_markupExpression_in_markupStatements993);
                    markupExpression131=markupExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, markupExpression131.getTree());

                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:130:53: markupStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_markupStatement_in_markupStatements997);
                    markupStatement132=markupStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, markupStatement132.getTree());

                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:130:71: markupMarkup
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_markupMarkup_in_markupStatements1001);
                    markupMarkup133=markupMarkup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, markupMarkup133.getTree());

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
    // $ANTLR end "markupStatements"

    public static class functionCall_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionCall"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:131:1: functionCall : markup ';' ;
    public final WaebricParser.functionCall_return functionCall() throws RecognitionException {
        WaebricParser.functionCall_return retval = new WaebricParser.functionCall_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal135=null;
        WaebricParser.markup_return markup134 = null;


        Object char_literal135_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:131:13: ( markup ';' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:131:16: markup ';'
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_markup_in_functionCall1009);
            markup134=markup();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, markup134.getTree());
            char_literal135=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_functionCall1011); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal135_tree = (Object)adaptor.create(char_literal135);
            adaptor.addChild(root_0, char_literal135_tree);
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
    // $ANTLR end "functionCall"

    public static class markupExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "markupExpression"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:132:1: markupExpression : ( markup )+ expression ';' -> ( markup )+ ';' expression ';' ;
    public final WaebricParser.markupExpression_return markupExpression() throws RecognitionException {
        WaebricParser.markupExpression_return retval = new WaebricParser.markupExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal138=null;
        WaebricParser.markup_return markup136 = null;

        WaebricParser.expression_return expression137 = null;


        Object char_literal138_tree=null;
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_markup=new RewriteRuleSubtreeStream(adaptor,"rule markup");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:132:17: ( ( markup )+ expression ';' -> ( markup )+ ';' expression ';' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:132:19: ( markup )+ expression ';'
            {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:132:19: ( markup )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                alt26 = dfa26.predict(input);
                switch (alt26) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
            	    {
            	    pushFollow(FOLLOW_markup_in_markupExpression1019);
            	    markup136=markup();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_markup.add(markup136.getTree());

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

            pushFollow(FOLLOW_expression_in_markupExpression1022);
            expression137=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expression.add(expression137.getTree());
            char_literal138=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_markupExpression1024); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal138);



            // AST REWRITE
            // elements: SEMICOLON, markup, expression, SEMICOLON
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 132:42: -> ( markup )+ ';' expression ';'
            {
                if ( !(stream_markup.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_markup.hasNext() ) {
                    adaptor.addChild(root_0, stream_markup.nextTree());

                }
                stream_markup.reset();
                adaptor.addChild(root_0, stream_SEMICOLON.nextNode());
                adaptor.addChild(root_0, stream_expression.nextTree());
                adaptor.addChild(root_0, stream_SEMICOLON.nextNode());

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
    // $ANTLR end "markupExpression"

    public static class markupStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "markupStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:133:1: markupStatement : ( markup )+ statement -> ( markup )+ ';' statement ;
    public final WaebricParser.markupStatement_return markupStatement() throws RecognitionException {
        WaebricParser.markupStatement_return retval = new WaebricParser.markupStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WaebricParser.markup_return markup139 = null;

        WaebricParser.statement_return statement140 = null;


        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_markup=new RewriteRuleSubtreeStream(adaptor,"rule markup");
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:133:16: ( ( markup )+ statement -> ( markup )+ ';' statement )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:133:18: ( markup )+ statement
            {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:133:18: ( markup )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==IDCON) ) {
                    int LA27_2 = input.LA(2);

                    if ( (synpred48_Waebric()) ) {
                        alt27=1;
                    }


                }


                switch (alt27) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
            	    {
            	    pushFollow(FOLLOW_markup_in_markupStatement1042);
            	    markup139=markup();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_markup.add(markup139.getTree());

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

            pushFollow(FOLLOW_statement_in_markupStatement1045);
            statement140=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement140.getTree());


            // AST REWRITE
            // elements: SEMICOLON, markup, statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 133:36: -> ( markup )+ ';' statement
            {
                if ( !(stream_markup.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_markup.hasNext() ) {
                    adaptor.addChild(root_0, stream_markup.nextTree());

                }
                stream_markup.reset();
                adaptor.addChild(root_0, (Object)adaptor.create(SEMICOLON, "SEMICOLON"));
                adaptor.addChild(root_0, stream_statement.nextTree());

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
    // $ANTLR end "markupStatement"

    public static class markupMarkup_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "markupMarkup"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:134:1: markupMarkup : ( markup )+ markup ';' ;
    public final WaebricParser.markupMarkup_return markupMarkup() throws RecognitionException {
        WaebricParser.markupMarkup_return retval = new WaebricParser.markupMarkup_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal143=null;
        WaebricParser.markup_return markup141 = null;

        WaebricParser.markup_return markup142 = null;


        Object char_literal143_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:134:13: ( ( markup )+ markup ';' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:134:16: ( markup )+ markup ';'
            {
            root_0 = (Object)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:134:16: ( markup )+
            int cnt28=0;
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==IDCON) ) {
                    int LA28_1 = input.LA(2);

                    if ( (synpred49_Waebric()) ) {
                        alt28=1;
                    }


                }


                switch (alt28) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
            	    {
            	    pushFollow(FOLLOW_markup_in_markupMarkup1062);
            	    markup141=markup();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, markup141.getTree());

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

            pushFollow(FOLLOW_markup_in_markupMarkup1065);
            markup142=markup();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, markup142.getTree());
            char_literal143=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_markupMarkup1067); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal143_tree = (Object)adaptor.create(char_literal143);
            adaptor.addChild(root_0, char_literal143_tree);
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
    // $ANTLR end "markupMarkup"

    public static class assignment_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignment"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:139:1: assignment : ( varBinding | funcBinding );
    public final WaebricParser.assignment_return assignment() throws RecognitionException {
        WaebricParser.assignment_return retval = new WaebricParser.assignment_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WaebricParser.varBinding_return varBinding144 = null;

        WaebricParser.funcBinding_return funcBinding145 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:139:11: ( varBinding | funcBinding )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==IDCON) ) {
                int LA29_1 = input.LA(2);

                if ( (LA29_1==62) ) {
                    alt29=1;
                }
                else if ( (LA29_1==53) ) {
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:139:14: varBinding
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_varBinding_in_assignment1081);
                    varBinding144=varBinding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, varBinding144.getTree());

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:139:27: funcBinding
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_funcBinding_in_assignment1085);
                    funcBinding145=funcBinding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, funcBinding145.getTree());

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

    public static class varBinding_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "varBinding"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:140:1: varBinding : IDCON '=' expression ';' ;
    public final WaebricParser.varBinding_return varBinding() throws RecognitionException {
        WaebricParser.varBinding_return retval = new WaebricParser.varBinding_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDCON146=null;
        Token char_literal147=null;
        Token char_literal149=null;
        WaebricParser.expression_return expression148 = null;


        Object IDCON146_tree=null;
        Object char_literal147_tree=null;
        Object char_literal149_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:140:11: ( IDCON '=' expression ';' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:140:14: IDCON '=' expression ';'
            {
            root_0 = (Object)adaptor.nil();

            IDCON146=(Token)match(input,IDCON,FOLLOW_IDCON_in_varBinding1093); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON146_tree = (Object)adaptor.create(IDCON146);
            adaptor.addChild(root_0, IDCON146_tree);
            }
            char_literal147=(Token)match(input,62,FOLLOW_62_in_varBinding1095); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal147_tree = (Object)adaptor.create(char_literal147);
            adaptor.addChild(root_0, char_literal147_tree);
            }
            pushFollow(FOLLOW_expression_in_varBinding1097);
            expression148=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression148.getTree());
            char_literal149=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_varBinding1099); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal149_tree = (Object)adaptor.create(char_literal149);
            adaptor.addChild(root_0, char_literal149_tree);
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
    // $ANTLR end "varBinding"

    public static class funcBinding_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "funcBinding"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:141:1: funcBinding : IDCON formals statement ;
    public final WaebricParser.funcBinding_return funcBinding() throws RecognitionException {
        WaebricParser.funcBinding_return retval = new WaebricParser.funcBinding_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDCON150=null;
        WaebricParser.formals_return formals151 = null;

        WaebricParser.statement_return statement152 = null;


        Object IDCON150_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:141:12: ( IDCON formals statement )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:141:15: IDCON formals statement
            {
            root_0 = (Object)adaptor.nil();

            IDCON150=(Token)match(input,IDCON,FOLLOW_IDCON_in_funcBinding1107); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON150_tree = (Object)adaptor.create(IDCON150);
            adaptor.addChild(root_0, IDCON150_tree);
            }
            pushFollow(FOLLOW_formals_in_funcBinding1109);
            formals151=formals();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, formals151.getTree());
            pushFollow(FOLLOW_statement_in_funcBinding1111);
            statement152=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement152.getTree());

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
    // $ANTLR end "funcBinding"

    public static class predicate_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "predicate"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:146:1: predicate : ( notPredicate | declaredPredicate | isPredicate ) ( '&&' predicate | '||' predicate )* ;
    public final WaebricParser.predicate_return predicate() throws RecognitionException {
        WaebricParser.predicate_return retval = new WaebricParser.predicate_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal156=null;
        Token string_literal158=null;
        WaebricParser.notPredicate_return notPredicate153 = null;

        WaebricParser.declaredPredicate_return declaredPredicate154 = null;

        WaebricParser.isPredicate_return isPredicate155 = null;

        WaebricParser.predicate_return predicate157 = null;

        WaebricParser.predicate_return predicate159 = null;


        Object string_literal156_tree=null;
        Object string_literal158_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:146:10: ( ( notPredicate | declaredPredicate | isPredicate ) ( '&&' predicate | '||' predicate )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:146:13: ( notPredicate | declaredPredicate | isPredicate ) ( '&&' predicate | '||' predicate )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:146:13: ( notPredicate | declaredPredicate | isPredicate )
            int alt30=3;
            alt30 = dfa30.predict(input);
            switch (alt30) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:146:15: notPredicate
                    {
                    pushFollow(FOLLOW_notPredicate_in_predicate1125);
                    notPredicate153=notPredicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, notPredicate153.getTree());

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:146:30: declaredPredicate
                    {
                    pushFollow(FOLLOW_declaredPredicate_in_predicate1129);
                    declaredPredicate154=declaredPredicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, declaredPredicate154.getTree());

                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:146:50: isPredicate
                    {
                    pushFollow(FOLLOW_isPredicate_in_predicate1133);
                    isPredicate155=isPredicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, isPredicate155.getTree());

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:147:4: ( '&&' predicate | '||' predicate )*
            loop31:
            do {
                int alt31=3;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==63) ) {
                    int LA31_2 = input.LA(2);

                    if ( (synpred53_Waebric()) ) {
                        alt31=1;
                    }


                }
                else if ( (LA31_0==64) ) {
                    int LA31_3 = input.LA(2);

                    if ( (synpred54_Waebric()) ) {
                        alt31=2;
                    }


                }


                switch (alt31) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:147:6: '&&' predicate
            	    {
            	    string_literal156=(Token)match(input,63,FOLLOW_63_in_predicate1143); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal156_tree = (Object)adaptor.create(string_literal156);
            	    adaptor.addChild(root_0, string_literal156_tree);
            	    }
            	    pushFollow(FOLLOW_predicate_in_predicate1145);
            	    predicate157=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate157.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:147:23: '||' predicate
            	    {
            	    string_literal158=(Token)match(input,64,FOLLOW_64_in_predicate1149); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal158_tree = (Object)adaptor.create(string_literal158);
            	    adaptor.addChild(root_0, string_literal158_tree);
            	    }
            	    pushFollow(FOLLOW_predicate_in_predicate1151);
            	    predicate159=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate159.getTree());

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

    public static class notPredicate_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "notPredicate"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:148:1: notPredicate : '!' predicate ;
    public final WaebricParser.notPredicate_return notPredicate() throws RecognitionException {
        WaebricParser.notPredicate_return retval = new WaebricParser.notPredicate_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal160=null;
        WaebricParser.predicate_return predicate161 = null;


        Object char_literal160_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:148:13: ( '!' predicate )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:148:16: '!' predicate
            {
            root_0 = (Object)adaptor.nil();

            char_literal160=(Token)match(input,65,FOLLOW_65_in_notPredicate1163); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal160_tree = (Object)adaptor.create(char_literal160);
            adaptor.addChild(root_0, char_literal160_tree);
            }
            pushFollow(FOLLOW_predicate_in_notPredicate1165);
            predicate161=predicate();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate161.getTree());

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
    // $ANTLR end "notPredicate"

    public static class declaredPredicate_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "declaredPredicate"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:149:1: declaredPredicate : expression ;
    public final WaebricParser.declaredPredicate_return declaredPredicate() throws RecognitionException {
        WaebricParser.declaredPredicate_return retval = new WaebricParser.declaredPredicate_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WaebricParser.expression_return expression162 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:149:18: ( expression )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:149:20: expression
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_expression_in_declaredPredicate1173);
            expression162=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression162.getTree());

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
    // $ANTLR end "declaredPredicate"

    public static class isPredicate_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "isPredicate"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:150:1: isPredicate : expression '.' type ;
    public final WaebricParser.isPredicate_return isPredicate() throws RecognitionException {
        WaebricParser.isPredicate_return retval = new WaebricParser.isPredicate_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal164=null;
        WaebricParser.expression_return expression163 = null;

        WaebricParser.type_return type165 = null;


        Object char_literal164_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:150:12: ( expression '.' type )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:150:15: expression '.' type
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_expression_in_isPredicate1182);
            expression163=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression163.getTree());
            char_literal164=(Token)match(input,47,FOLLOW_47_in_isPredicate1184); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal164_tree = (Object)adaptor.create(char_literal164);
            adaptor.addChild(root_0, char_literal164_tree);
            }
            pushFollow(FOLLOW_type_in_isPredicate1186);
            type165=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, type165.getTree());

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
    // $ANTLR end "isPredicate"

    public static class type_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:151:1: type : ( 'list' | 'record' | 'string' );
    public final WaebricParser.type_return type() throws RecognitionException {
        WaebricParser.type_return retval = new WaebricParser.type_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set166=null;

        Object set166_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:151:5: ( 'list' | 'record' | 'string' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:
            {
            root_0 = (Object)adaptor.nil();

            set166=(Token)input.LT(1);
            if ( (input.LA(1)>=LIST && input.LA(1)<=STRING) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set166));
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:156:1: embedding : PRETEXT embed textTail ;
    public final WaebricParser.embedding_return embedding() throws RecognitionException {
        WaebricParser.embedding_return retval = new WaebricParser.embedding_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PRETEXT167=null;
        WaebricParser.embed_return embed168 = null;

        WaebricParser.textTail_return textTail169 = null;


        Object PRETEXT167_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:156:10: ( PRETEXT embed textTail )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:156:13: PRETEXT embed textTail
            {
            root_0 = (Object)adaptor.nil();

            PRETEXT167=(Token)match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding1216); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRETEXT167_tree = (Object)adaptor.create(PRETEXT167);
            adaptor.addChild(root_0, PRETEXT167_tree);
            }
            pushFollow(FOLLOW_embed_in_embedding1218);
            embed168=embed();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, embed168.getTree());
            pushFollow(FOLLOW_textTail_in_embedding1220);
            textTail169=textTail();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, textTail169.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:157:1: embed : ( ( markup )* expression | ( markup )* markup );
    public final WaebricParser.embed_return embed() throws RecognitionException {
        WaebricParser.embed_return retval = new WaebricParser.embed_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WaebricParser.markup_return markup170 = null;

        WaebricParser.expression_return expression171 = null;

        WaebricParser.markup_return markup172 = null;

        WaebricParser.markup_return markup173 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:157:6: ( ( markup )* expression | ( markup )* markup )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==IDCON) ) {
                int LA34_1 = input.LA(2);

                if ( (synpred58_Waebric()) ) {
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
            else if ( ((LA34_0>=NATCON && LA34_0<=SYMBOLCON)||LA34_0==57||LA34_0==59) ) {
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:157:10: ( markup )* expression
                    {
                    root_0 = (Object)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:157:10: ( markup )*
                    loop32:
                    do {
                        int alt32=2;
                        alt32 = dfa32.predict(input);
                        switch (alt32) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_embed1229);
                    	    markup170=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, markup170.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);

                    pushFollow(FOLLOW_expression_in_embed1232);
                    expression171=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression171.getTree());

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:157:31: ( markup )* markup
                    {
                    root_0 = (Object)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:157:31: ( markup )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==IDCON) ) {
                            int LA33_1 = input.LA(2);

                            if ( (synpred59_Waebric()) ) {
                                alt33=1;
                            }


                        }


                        switch (alt33) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_embed1236);
                    	    markup172=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, markup172.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);

                    pushFollow(FOLLOW_markup_in_embed1239);
                    markup173=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, markup173.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:158:1: textTail : ( POSTTEXT | MIDTEXT embed textTail );
    public final WaebricParser.textTail_return textTail() throws RecognitionException {
        WaebricParser.textTail_return retval = new WaebricParser.textTail_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token POSTTEXT174=null;
        Token MIDTEXT175=null;
        WaebricParser.embed_return embed176 = null;

        WaebricParser.textTail_return textTail177 = null;


        Object POSTTEXT174_tree=null;
        Object MIDTEXT175_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:158:9: ( POSTTEXT | MIDTEXT embed textTail )
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:158:12: POSTTEXT
                    {
                    root_0 = (Object)adaptor.nil();

                    POSTTEXT174=(Token)match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail1247); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    POSTTEXT174_tree = (Object)adaptor.create(POSTTEXT174);
                    adaptor.addChild(root_0, POSTTEXT174_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:158:23: MIDTEXT embed textTail
                    {
                    root_0 = (Object)adaptor.nil();

                    MIDTEXT175=(Token)match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail1251); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MIDTEXT175_tree = (Object)adaptor.create(MIDTEXT175);
                    adaptor.addChild(root_0, MIDTEXT175_tree);
                    }
                    pushFollow(FOLLOW_embed_in_textTail1253);
                    embed176=embed();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, embed176.getTree());
                    pushFollow(FOLLOW_textTail_in_textTail1255);
                    textTail177=textTail();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, textTail177.getTree());

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

    // $ANTLR start synpred21_Waebric
    public final void synpred21_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:96:6: ( '+' expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:96:6: '+' expression
        {
        match(input,56,FOLLOW_56_in_synpred21_Waebric599); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred21_Waebric601);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_Waebric

    // $ANTLR start synpred22_Waebric
    public final void synpred22_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:96:44: ( '.' IDCON )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:96:44: '.' IDCON
        {
        match(input,47,FOLLOW_47_in_synpred22_Waebric607); if (state.failed) return ;
        match(input,IDCON,FOLLOW_IDCON_in_synpred22_Waebric609); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred22_Waebric

    // $ANTLR start synpred31_Waebric
    public final void synpred31_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:118:13: ( ifElseStatement )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:118:13: ifElseStatement
        {
        pushFollow(FOLLOW_ifElseStatement_in_synpred31_Waebric802);
        ifElseStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_Waebric

    // $ANTLR start synpred32_Waebric
    public final void synpred32_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:118:31: ( ifStatement )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:118:31: ifStatement
        {
        pushFollow(FOLLOW_ifStatement_in_synpred32_Waebric806);
        ifStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_Waebric

    // $ANTLR start synpred45_Waebric
    public final void synpred45_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:130:34: ( markupExpression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:130:34: markupExpression
        {
        pushFollow(FOLLOW_markupExpression_in_synpred45_Waebric993);
        markupExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred45_Waebric

    // $ANTLR start synpred46_Waebric
    public final void synpred46_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:130:53: ( markupStatement )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:130:53: markupStatement
        {
        pushFollow(FOLLOW_markupStatement_in_synpred46_Waebric997);
        markupStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_Waebric

    // $ANTLR start synpred48_Waebric
    public final void synpred48_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:133:18: ( markup )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:133:18: markup
        {
        pushFollow(FOLLOW_markup_in_synpred48_Waebric1042);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred48_Waebric

    // $ANTLR start synpred49_Waebric
    public final void synpred49_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:134:16: ( markup )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:134:16: markup
        {
        pushFollow(FOLLOW_markup_in_synpred49_Waebric1062);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred49_Waebric

    // $ANTLR start synpred52_Waebric
    public final void synpred52_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:146:30: ( declaredPredicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:146:30: declaredPredicate
        {
        pushFollow(FOLLOW_declaredPredicate_in_synpred52_Waebric1129);
        declaredPredicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred52_Waebric

    // $ANTLR start synpred53_Waebric
    public final void synpred53_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:147:6: ( '&&' predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:147:6: '&&' predicate
        {
        match(input,63,FOLLOW_63_in_synpred53_Waebric1143); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred53_Waebric1145);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred53_Waebric

    // $ANTLR start synpred54_Waebric
    public final void synpred54_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:147:23: ( '||' predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:147:23: '||' predicate
        {
        match(input,64,FOLLOW_64_in_synpred54_Waebric1149); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred54_Waebric1151);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred54_Waebric

    // $ANTLR start synpred58_Waebric
    public final void synpred58_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:157:10: ( ( markup )* expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:157:10: ( markup )* expression
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:157:10: ( markup )*
        loop36:
        do {
            int alt36=2;
            alt36 = dfa36.predict(input);
            switch (alt36) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred58_Waebric1229);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop36;
            }
        } while (true);

        pushFollow(FOLLOW_expression_in_synpred58_Waebric1232);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred58_Waebric

    // $ANTLR start synpred59_Waebric
    public final void synpred59_Waebric_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:157:31: ( markup )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/Waebric.g:157:31: markup
        {
        pushFollow(FOLLOW_markup_in_synpred59_Waebric1236);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred59_Waebric

    // Delegated rules

    public final boolean synpred21_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_Waebric_fragment(); // can never throw exception
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
    public final boolean synpred22_Waebric() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_Waebric_fragment(); // can never throw exception
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


    protected DFA20 dfa20 = new DFA20(this);
    protected DFA26 dfa26 = new DFA26(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA36 dfa36 = new DFA36(this);
    static final String DFA20_eotS =
        "\14\uffff";
    static final String DFA20_eofS =
        "\14\uffff";
    static final String DFA20_minS =
        "\1\11\1\0\12\uffff";
    static final String DFA20_maxS =
        "\1\75\1\0\12\uffff";
    static final String DFA20_acceptS =
        "\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\1\1\2";
    static final String DFA20_specialS =
        "\1\uffff\1\0\12\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\1\1\uffff\1\2\1\3\1\uffff\1\5\1\6\1\7\4\uffff\1\11\45\uffff"+
            "\1\4\1\uffff\1\10",
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
            return "118:1: statement : ( ifElseStatement | ifStatement | eachStatement | letStatement | blockStatement | commentStatement | echoStatement | cdataStatement | yieldStatement | markupStatements );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA20_1 = input.LA(1);

                         
                        int index20_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_Waebric()) ) {s = 10;}

                        else if ( (synpred32_Waebric()) ) {s = 11;}

                         
                        input.seek(index20_1);
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
    static final String DFA26_eotS =
        "\6\uffff";
    static final String DFA26_eofS =
        "\6\uffff";
    static final String DFA26_minS =
        "\2\25\1\uffff\1\25\1\uffff\1\25";
    static final String DFA26_maxS =
        "\2\73\1\uffff\1\25\1\uffff\1\73";
    static final String DFA26_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String DFA26_specialS =
        "\6\uffff}>";
    static final String[] DFA26_transitionS = {
            "\1\1\1\uffff\3\2\37\uffff\1\2\1\uffff\1\2",
            "\1\4\1\uffff\3\4\4\uffff\1\2\20\uffff\1\3\4\4\1\uffff\1\4\2"+
            "\uffff\1\2\1\4\1\uffff\1\4",
            "",
            "\1\5",
            "",
            "\1\4\1\uffff\3\4\4\uffff\1\2\20\uffff\1\3\4\4\1\uffff\1\4\2"+
            "\uffff\1\2\1\4\1\uffff\1\4"
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
            return "()+ loopback of 132:19: ( markup )+";
        }
    }
    static final String DFA30_eotS =
        "\12\uffff";
    static final String DFA30_eofS =
        "\12\uffff";
    static final String DFA30_minS =
        "\1\25\1\uffff\6\0\2\uffff";
    static final String DFA30_maxS =
        "\1\101\1\uffff\6\0\2\uffff";
    static final String DFA30_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\1\3";
    static final String DFA30_specialS =
        "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\2\uffff}>";
    static final String[] DFA30_transitionS = {
            "\1\2\1\uffff\1\3\1\4\1\5\37\uffff\1\6\1\uffff\1\7\5\uffff\1"+
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
            return "146:13: ( notPredicate | declaredPredicate | isPredicate )";
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
                        if ( (synpred52_Waebric()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index30_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA30_3 = input.LA(1);

                         
                        int index30_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_Waebric()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index30_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA30_4 = input.LA(1);

                         
                        int index30_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_Waebric()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index30_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA30_5 = input.LA(1);

                         
                        int index30_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_Waebric()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index30_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA30_6 = input.LA(1);

                         
                        int index30_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_Waebric()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index30_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA30_7 = input.LA(1);

                         
                        int index30_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_Waebric()) ) {s = 8;}

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
        "\2\25\2\uffff\2\25";
    static final String DFA32_maxS =
        "\2\73\2\uffff\1\25\1\73";
    static final String DFA32_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA32_specialS =
        "\6\uffff}>";
    static final String[] DFA32_transitionS = {
            "\1\1\1\uffff\3\2\37\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\2\uffff\2\2\21\uffff\1\4\4\3\1\uffff\1\3\2"+
            "\uffff\1\2\1\3\1\uffff\1\3",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\2\uffff\2\2\21\uffff\1\4\4\3\1\uffff\1\3\2"+
            "\uffff\1\2\1\3\1\uffff\1\3"
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
            return "()* loopback of 157:10: ( markup )*";
        }
    }
    static final String DFA36_eotS =
        "\6\uffff";
    static final String DFA36_eofS =
        "\1\uffff\1\2\3\uffff\1\2";
    static final String DFA36_minS =
        "\2\25\2\uffff\2\25";
    static final String DFA36_maxS =
        "\2\73\2\uffff\1\25\1\73";
    static final String DFA36_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA36_specialS =
        "\6\uffff}>";
    static final String[] DFA36_transitionS = {
            "\1\1\1\uffff\3\2\37\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\25\uffff\1\4\4\3\1\uffff\1\3\2\uffff\1\2\1"+
            "\3\1\uffff\1\3",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\25\uffff\1\4\4\3\1\uffff\1\3\2\uffff\1\2\1"+
            "\3\1\uffff\1\3"
    };

    static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
    static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
    static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
    static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
    static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
    static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
    static final short[][] DFA36_transition;

    static {
        int numStates = DFA36_transitionS.length;
        DFA36_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = DFA36_eot;
            this.eof = DFA36_eof;
            this.min = DFA36_min;
            this.max = DFA36_max;
            this.accept = DFA36_accept;
            this.special = DFA36_special;
            this.transition = DFA36_transition;
        }
        public String getDescription() {
            return "()* loopback of 157:10: ( markup )*";
        }
    }
 

    public static final BitSet FOLLOW_MODULE_in_module236 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_moduleId_in_module238 = new BitSet(new long[]{0x00000000000001E0L});
    public static final BitSet FOLLOW_imprt_in_module242 = new BitSet(new long[]{0x00000000000001E0L});
    public static final BitSet FOLLOW_site_in_module246 = new BitSet(new long[]{0x00000000000001E0L});
    public static final BitSet FOLLOW_function_in_module250 = new BitSet(new long[]{0x00000000000001E0L});
    public static final BitSet FOLLOW_END_in_module255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_moduleId307 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_47_in_moduleId317 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_IDCON_in_moduleId321 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_IMPORT_in_imprt354 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_moduleId_in_imprt358 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_imprt360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SITE_in_site396 = new BitSet(new long[]{0x0000000040400100L});
    public static final BitSet FOLLOW_mappings_in_site398 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_END_in_site400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapping_in_mappings429 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_mappings434 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_mapping_in_mappings436 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_PATH_in_mapping448 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_mapping450 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_markup_in_mapping452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_designator_in_markup465 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_arguments_in_markup467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_designator476 = new BitSet(new long[]{0x000F800000000002L});
    public static final BitSet FOLLOW_attribute_in_designator478 = new BitSet(new long[]{0x000F800000000002L});
    public static final BitSet FOLLOW_49_in_attribute487 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_IDCON_in_attribute489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_attribute493 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_IDCON_in_attribute495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_attribute499 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_IDCON_in_attribute501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_attribute505 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_IDCON_in_attribute507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_attribute515 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_NATCON_in_attribute517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_attribute521 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_NATCON_in_attribute523 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_attribute525 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_NATCON_in_attribute527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_arguments534 = new BitSet(new long[]{0x0AC0000003A00000L});
    public static final BitSet FOLLOW_argument_in_arguments536 = new BitSet(new long[]{0x00C0000000000000L});
    public static final BitSet FOLLOW_54_in_arguments541 = new BitSet(new long[]{0x0A00000003A00000L});
    public static final BitSet FOLLOW_argument_in_arguments543 = new BitSet(new long[]{0x00C0000000000000L});
    public static final BitSet FOLLOW_55_in_arguments548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_argument556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varExpression_in_expression570 = new BitSet(new long[]{0x0100800000000002L});
    public static final BitSet FOLLOW_natExpression_in_expression574 = new BitSet(new long[]{0x0100800000000002L});
    public static final BitSet FOLLOW_textExpression_in_expression578 = new BitSet(new long[]{0x0100800000000002L});
    public static final BitSet FOLLOW_symbolExpression_in_expression582 = new BitSet(new long[]{0x0100800000000002L});
    public static final BitSet FOLLOW_listExpression_in_expression586 = new BitSet(new long[]{0x0100800000000002L});
    public static final BitSet FOLLOW_recordExpression_in_expression590 = new BitSet(new long[]{0x0100800000000002L});
    public static final BitSet FOLLOW_56_in_expression599 = new BitSet(new long[]{0x0A00000003A00000L});
    public static final BitSet FOLLOW_expression_in_expression601 = new BitSet(new long[]{0x0100800000000002L});
    public static final BitSet FOLLOW_47_in_expression607 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_IDCON_in_expression609 = new BitSet(new long[]{0x0100800000000002L});
    public static final BitSet FOLLOW_IDCON_in_varExpression622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NATCON_in_natExpression630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_textExpression638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYMBOLCON_in_symbolExpression645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_listExpression656 = new BitSet(new long[]{0x0E40000003A00000L});
    public static final BitSet FOLLOW_expression_in_listExpression658 = new BitSet(new long[]{0x0440000000000000L});
    public static final BitSet FOLLOW_54_in_listExpression663 = new BitSet(new long[]{0x0A00000003A00000L});
    public static final BitSet FOLLOW_expression_in_listExpression665 = new BitSet(new long[]{0x0440000000000000L});
    public static final BitSet FOLLOW_58_in_listExpression670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_recordExpression677 = new BitSet(new long[]{0x1040000000200000L});
    public static final BitSet FOLLOW_keyValuePair_in_recordExpression679 = new BitSet(new long[]{0x1040000000000000L});
    public static final BitSet FOLLOW_54_in_recordExpression684 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_keyValuePair_in_recordExpression686 = new BitSet(new long[]{0x1040000000000000L});
    public static final BitSet FOLLOW_60_in_recordExpression691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_keyValuePair699 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_keyValuePair701 = new BitSet(new long[]{0x0A00000003A00000L});
    public static final BitSet FOLLOW_expression_in_keyValuePair703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEF_in_function715 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_IDCON_in_function717 = new BitSet(new long[]{0x282000000021DB00L});
    public static final BitSet FOLLOW_formals_in_function719 = new BitSet(new long[]{0x280000000021DB00L});
    public static final BitSet FOLLOW_statement_in_function722 = new BitSet(new long[]{0x280000000021DB00L});
    public static final BitSet FOLLOW_END_in_function725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_formals761 = new BitSet(new long[]{0x00C0000000200000L});
    public static final BitSet FOLLOW_IDCON_in_formals763 = new BitSet(new long[]{0x00C0000000000000L});
    public static final BitSet FOLLOW_54_in_formals768 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_IDCON_in_formals770 = new BitSet(new long[]{0x00C0000000000000L});
    public static final BitSet FOLLOW_55_in_formals775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifElseStatement_in_statement802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statement806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_eachStatement_in_statement810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_letStatement_in_statement814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blockStatement_in_statement818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_commentStatement_in_statement822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_echoStatement_in_statement829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cdataStatement_in_statement833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_yieldStatement_in_statement837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markupStatements_in_statement841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifStatement849 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ifStatement851 = new BitSet(new long[]{0x0A00000003A00000L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_ifStatement853 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_ifStatement855 = new BitSet(new long[]{0x280000000021DA00L});
    public static final BitSet FOLLOW_statement_in_ifStatement857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifElseStatement864 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ifElseStatement866 = new BitSet(new long[]{0x0A00000003A00000L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_ifElseStatement868 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_ifElseStatement870 = new BitSet(new long[]{0x280000000021DA00L});
    public static final BitSet FOLLOW_statement_in_ifElseStatement872 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ELSE_in_ifElseStatement874 = new BitSet(new long[]{0x280000000021DA00L});
    public static final BitSet FOLLOW_statement_in_ifElseStatement876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EACH_in_eachStatement885 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_eachStatement887 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_IDCON_in_eachStatement889 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_eachStatement891 = new BitSet(new long[]{0x0A00000003A00000L});
    public static final BitSet FOLLOW_expression_in_eachStatement893 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_eachStatement895 = new BitSet(new long[]{0x280000000021DA00L});
    public static final BitSet FOLLOW_statement_in_eachStatement897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LET_in_letStatement906 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_assignment_in_letStatement908 = new BitSet(new long[]{0x0000000000202000L});
    public static final BitSet FOLLOW_IN_in_letStatement911 = new BitSet(new long[]{0x280000000021DB00L});
    public static final BitSet FOLLOW_statement_in_letStatement913 = new BitSet(new long[]{0x280000000021DB00L});
    public static final BitSet FOLLOW_END_in_letStatement916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_blockStatement924 = new BitSet(new long[]{0x380000000021DA00L});
    public static final BitSet FOLLOW_statement_in_blockStatement926 = new BitSet(new long[]{0x380000000021DA00L});
    public static final BitSet FOLLOW_60_in_blockStatement929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMENT_in_commentStatement936 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_STRCON_in_commentStatement938 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_commentStatement940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ECHO_in_echoStatement948 = new BitSet(new long[]{0x0A00000003A00000L});
    public static final BitSet FOLLOW_expression_in_echoStatement950 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_echoStatement952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ECHO_in_echoStatement957 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_embedding_in_echoStatement959 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_echoStatement961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CDATA_in_cdataStatement969 = new BitSet(new long[]{0x0A00000003A00000L});
    public static final BitSet FOLLOW_expression_in_cdataStatement971 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_cdataStatement973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_yieldStatement981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCall_in_markupStatements989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markupExpression_in_markupStatements993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markupStatement_in_markupStatements997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markupMarkup_in_markupStatements1001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_functionCall1009 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_functionCall1011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_markupExpression1019 = new BitSet(new long[]{0x0A00000003A00000L});
    public static final BitSet FOLLOW_expression_in_markupExpression1022 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_markupExpression1024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_markupStatement1042 = new BitSet(new long[]{0x280000000021DA00L});
    public static final BitSet FOLLOW_statement_in_markupStatement1045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_markupMarkup1062 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_markup_in_markupMarkup1065 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_markupMarkup1067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varBinding_in_assignment1081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funcBinding_in_assignment1085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_varBinding1093 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_varBinding1095 = new BitSet(new long[]{0x0A00000003A00000L});
    public static final BitSet FOLLOW_expression_in_varBinding1097 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_varBinding1099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_funcBinding1107 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_formals_in_funcBinding1109 = new BitSet(new long[]{0x280000000021DA00L});
    public static final BitSet FOLLOW_statement_in_funcBinding1111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_notPredicate_in_predicate1125 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_declaredPredicate_in_predicate1129 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_isPredicate_in_predicate1133 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_63_in_predicate1143 = new BitSet(new long[]{0x0A00000003A00000L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_predicate1145 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_predicate1149 = new BitSet(new long[]{0x0A00000003A00000L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_predicate1151 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_65_in_notPredicate1163 = new BitSet(new long[]{0x0A00000003A00000L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_notPredicate1165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_declaredPredicate1173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_isPredicate1182 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_isPredicate1184 = new BitSet(new long[]{0x00000000001C0000L});
    public static final BitSet FOLLOW_type_in_isPredicate1186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding1216 = new BitSet(new long[]{0x0A00000003A00000L});
    public static final BitSet FOLLOW_embed_in_embedding1218 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_textTail_in_embedding1220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed1229 = new BitSet(new long[]{0x0A00000003A00000L});
    public static final BitSet FOLLOW_expression_in_embed1232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed1236 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_markup_in_embed1239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail1247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail1251 = new BitSet(new long[]{0x0A00000003A00000L});
    public static final BitSet FOLLOW_embed_in_textTail1253 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_textTail_in_textTail1255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred21_Waebric599 = new BitSet(new long[]{0x0A00000003A00000L});
    public static final BitSet FOLLOW_expression_in_synpred21_Waebric601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_synpred22_Waebric607 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_IDCON_in_synpred22_Waebric609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifElseStatement_in_synpred31_Waebric802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_synpred32_Waebric806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markupExpression_in_synpred45_Waebric993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markupStatement_in_synpred46_Waebric997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred48_Waebric1042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred49_Waebric1062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaredPredicate_in_synpred52_Waebric1129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_synpred53_Waebric1143 = new BitSet(new long[]{0x0A00000003A00000L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_synpred53_Waebric1145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_synpred54_Waebric1149 = new BitSet(new long[]{0x0A00000003A00000L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_synpred54_Waebric1151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred58_Waebric1229 = new BitSet(new long[]{0x0A00000003A00000L});
    public static final BitSet FOLLOW_expression_in_synpred58_Waebric1232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred59_Waebric1236 = new BitSet(new long[]{0x0000000000000002L});

}