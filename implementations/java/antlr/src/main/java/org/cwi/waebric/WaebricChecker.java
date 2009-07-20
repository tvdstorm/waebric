// $ANTLR 3.1.2 /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g 2009-07-20 14:51:00

	package org.cwi.waebric;
	
	import java.util.HashMap;
	import java.util.HashSet;
	import java.util.List;
	import java.util.ArrayList;	


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class WaebricChecker extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "MODULE", "IMPORT", "SITE", "DEF", "END", "IF", "ELSE", "EACH", "LET", "IN", "COMMENT", "ECHO", "CDATA", "YIELD", "LIST", "RECORD", "STRING", "IDCON", "PATH", "NATCON", "TEXT", "SYMBOLCON", "STRCON", "PRETEXT", "POSTTEXT", "MIDTEXT", "SEMICOLON", "LETTER", "DIGIT", "HEXADECIMAL", "PATHELEMENT", "FILEEXT", "STRCHAR", "ESCLAYOUT", "DECIMAL", "TEXTCHAR", "ESCQUOTE", "AMP", "CHARREF", "ENTREF", "SYMBOLCHAR", "COMMENTS", "LAYOUT", "'.'", "':'", "'#'", "'$'", "'@'", "'%'", "'('", "','", "')'", "'+'", "'['", "']'", "'{'", "'}'", "'yield;'", "'='", "'&&'", "'||'", "'!'"
    };
    public static final int ESCLAYOUT=37;
    public static final int DEF=7;
    public static final int T__57=57;
    public static final int END=8;
    public static final int LIST=18;
    public static final int T__51=51;
    public static final int FILEEXT=35;
    public static final int T__47=47;
    public static final int T__50=50;
    public static final int STRCHAR=36;
    public static final int T__65=65;
    public static final int SYMBOLCON=25;
    public static final int COMMENTS=45;
    public static final int IDCON=21;
    public static final int DECIMAL=38;
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
    public static final int ELSE=10;
    public static final int T__63=63;
    public static final int PRETEXT=27;
    public static final int SEMICOLON=30;
    public static final int LET=12;
    public static final int IF=9;
    public static final int EOF=-1;
    public static final int T__53=53;
    public static final int TEXT=24;
    public static final int NATCON=23;
    public static final int T__60=60;
    public static final int EACH=11;
    public static final int PATH=22;

    // delegates
    // delegators

    protected static class Environment_scope {
        HashSet<String> variables;
        HashMap<String, Integer> functions;
    }
    protected Stack Environment_stack = new Stack();


        public WaebricChecker(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public WaebricChecker(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return WaebricChecker.tokenNames; }
    public String getGrammarFileName() { return "/Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g"; }


    	List<SemanticException> exceptions;
    	public List<SemanticException> checkAST() throws RecognitionException {
    		exceptions = new ArrayList<SemanticException>();
    		module(); // Start checking
    		
    		// Process calls after retrieving all function definitions
    		for(Call call: calls) {
    			// Restore call environment
    			Stack actual = Environment_stack;
    			Environment_stack = call.env;
    			
    			if(isDefinedFunction(call.id)) {
    				int args = expectedArgs(call.id);
    				if(call.args != args) {
    					exceptions.add(new ArityMismatchException(call.id, args));
    				}
    			} else if(! XHTMLTag.isXHTMLTag(call.id.getText())) {
    				exceptions.add(new UndefinedFunctionException(call.id));
    			}
    			
    			// Return to actual environment
    			Environment_stack = actual;
    		}
    		
    		return exceptions; // Return results
    	}
    	
    	class Call { public CommonTree id; public int args; public Stack env; }
    	List<Call> calls = new ArrayList<Call>();

    	void defineFunction(CommonTree id, int args, int depth) {
    		// Check if function is already defined
    		if(isDefinedFunction(id)) {
    			exceptions.add(new DuplicateFunctionException(id));
    		} else { ((Environment_scope)Environment_stack.elementAt(depth)).functions.put(id.getText(), args); }
    	}

    	boolean isDefinedFunction(CommonTree id) {
    		for(int i=Environment_stack.size()-1; i>=0; i--) {
    			if(((Environment_scope)Environment_stack.elementAt(i)).functions.containsKey(id.getText())) {
    				return true; 
    			}
    		} return false;
    	}
    	
    	void defineVariable(CommonTree id) {
    		((Environment_scope)Environment_stack.peek()).variables.add(id.getText());
    	}
    	
    	boolean isDefinedVariable(CommonTree id) {
    		for(int i=Environment_stack.size()-1; i>=0; i--) {
    			if(((Environment_scope)Environment_stack.elementAt(i)).variables.contains(id.getText())) { 
    				return true; 
    			}
    		} return false;
    	}
    	
    	int expectedArgs(CommonTree id) {
    		for(int i=Environment_stack.size()-1; i>=0; i--) {
    			if(((Environment_scope)Environment_stack.elementAt(i)).functions.containsKey(id.getText())) {
    				return ((Environment_scope)Environment_stack.elementAt(i)).functions.get(id.getText()); 
    			}
    		} return -1;
    	}
    	
        	public abstract class SemanticException extends Exception { 
    			private static final long serialVersionUID = 9032805899029042730L;
    			public SemanticException(String message) { super(message); }
        	}
        	
            /**
             * If for an import directive import m no corresponding file m.wae 
             * can be found, this a an error. [The import directive is skipped]
             * 
             * @author Jeroen van Schagen
             * @date 09-06-2009
             */
            class NonExistingModuleException extends SemanticException {
            	private static final long serialVersionUID = -4503945323554024642L;
            	public NonExistingModuleException(CommonTree id) {
            		super("Module identifier at line " + id.getLine() 
            				+ " and character " + id.getCharPositionInLine()
            				+ " refers to a non-existing module.");
           		}
           	}
           	
           /**
    	 * If a variable reference x cannot be traced back to an enclosing 
    	 * let-definition or function parameter, this is an error. The 
    	 * variable x will be undefined and evaluate to the string "undef".
    	 * 
    	 * @author Jeroen van Schagen
    	 * @date 09-06-2009
    	 */
           	class UndefinedVariableException extends SemanticException {
           		private static final long serialVersionUID = -4479175462744485497L;
            	public UndefinedVariableException(CommonTree id) {
            		super("Undefined variable " + id.getText() + " at line " + id.getLine() 
            				+ " and character " + id.getCharPositionInLine() + ".");
           		}
           	}
           	
           	/**
    	 * If for a markup-call (f) no function definition can be found in 
    	 * the current module or one of its (transitive) imports, and, if 
    	 * f is not a tag defined in the XHTML 1.0 Transitional standard, 
    	 * then this is an error. [f will be interpreted as if it was part 
    	 * of XHTML 1.0 transitional.]
    	 * 
    	 * @author Jeroen van Schagen
    	 * @date 09-06-2009
    	 */
           	class UndefinedFunctionException extends SemanticException {
           		private static final long serialVersionUID = -4569708425419653397L;
            	public UndefinedFunctionException(CommonTree id) {
            		super("Function call " + id.getText() + " at line " + id.getLine() 
            				+ " and character " + id.getCharPositionInLine()
            				+ ", is made to an undefined function.");
           		}
           	}
           	
    	/**
    	 * If a function is called with an incorrect number of arguments 
    	 * (as follows from its definition), this is an error.
    	 * 
    	 * @author Jeroen van Schagen
    	 * @date 09-06-2009
    	 */
    	class ArityMismatchException extends SemanticException {
    		private static final long serialVersionUID = -954167103131401047L;
    		public ArityMismatchException(CommonTree id, int args) {
    			super("Arity mismatch at function call " + id.getText() 
    					+ " positioned on line " + id.getLine() 
            				+ " and character " + id.getCharPositionInLine()
            				+ ". Use the expected " + args + " argument(s).");
    		}
    		
    	}
    	
    	/**
    	 * Multiple function definitions with the same name are disallowed.
    	 * 
    	 * @author Jeroen van Schagen
    	 * @date 09-06-2009
    	 */
    	class DuplicateFunctionException extends SemanticException {
    		private static final long serialVersionUID = -8833578229100261366L;
    		public DuplicateFunctionException(CommonTree id) {
    			super("Duplicate definition of function " + id.getText() 
    					+ " at line " + id.getLine() 
            				+ " and character " + id.getCharPositionInLine() + ".");
    		}
    		
    	}


    public static class module_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "module"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:182:1: module : ^( 'module' moduleId ( imprt )* ( site )* ( function )* 'end' ) ;
    public final WaebricChecker.module_return module() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.module_return retval = new WaebricChecker.module_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal1=null;
        CommonTree string_literal6=null;
        WaebricChecker.moduleId_return moduleId2 = null;

        WaebricChecker.imprt_return imprt3 = null;

        WaebricChecker.site_return site4 = null;

        WaebricChecker.function_return function5 = null;


        CommonTree string_literal1_tree=null;
        CommonTree string_literal6_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new HashSet<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:187:4: ( ^( 'module' moduleId ( imprt )* ( site )* ( function )* 'end' ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:187:7: ^( 'module' moduleId ( imprt )* ( site )* ( function )* 'end' )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal1=(CommonTree)match(input,MODULE,FOLLOW_MODULE_in_module77); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal1_tree = (CommonTree)adaptor.dupNode(string_literal1);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal1_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_moduleId_in_module79);
            moduleId2=moduleId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, moduleId2.getTree());
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:187:28: ( imprt )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==IMPORT) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: imprt
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_imprt_in_module81);
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

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:187:35: ( site )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==SITE) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: site
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_site_in_module84);
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

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:187:41: ( function )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==DEF) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: function
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_function_in_module87);
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

            _last = (CommonTree)input.LT(1);
            string_literal6=(CommonTree)match(input,END,FOLLOW_END_in_module90); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal6_tree = (CommonTree)adaptor.dupNode(string_literal6);

            adaptor.addChild(root_1, string_literal6_tree);
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
            Environment_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "module"

    public static class moduleId_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "moduleId"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:189:1: moduleId : id= IDCON ( '.' id= IDCON )* ;
    public final WaebricChecker.moduleId_return moduleId() throws RecognitionException {
        WaebricChecker.moduleId_return retval = new WaebricChecker.moduleId_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        CommonTree char_literal7=null;

        CommonTree id_tree=null;
        CommonTree char_literal7_tree=null;

         
        		String path = "";
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:192:4: (id= IDCON ( '.' id= IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:192:7: id= IDCON ( '.' id= IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_moduleId109); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (CommonTree)adaptor.dupNode(id);

            adaptor.addChild(root_0, id_tree);
            }
            if ( state.backtracking==0 ) {
               path = id.getText();
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:193:4: ( '.' id= IDCON )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==47) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:193:6: '.' id= IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal7=(CommonTree)match(input,47,FOLLOW_47_in_moduleId118); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal7_tree = (CommonTree)adaptor.dupNode(char_literal7);

            	    adaptor.addChild(root_0, char_literal7_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_moduleId122); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    id_tree = (CommonTree)adaptor.dupNode(id);

            	    adaptor.addChild(root_0, id_tree);
            	    }
            	    if ( state.backtracking==0 ) {
            	       path += "/" + id.getText(); 
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

              				path += ".wae"; // Include default extension
              				java.io.File file = new java.io.File(path);
              				if(! file.isFile()) {
              					// Each import reference should be a valid file
              					exceptions.add(new NonExistingModuleException(id));
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
    // $ANTLR end "moduleId"

    public static class imprt_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "imprt"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:202:1: imprt : ^( 'import' id= moduleId ';' module ) ;
    public final WaebricChecker.imprt_return imprt() throws RecognitionException {
        WaebricChecker.imprt_return retval = new WaebricChecker.imprt_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal8=null;
        CommonTree char_literal9=null;
        WaebricChecker.moduleId_return id = null;

        WaebricChecker.module_return module10 = null;


        CommonTree string_literal8_tree=null;
        CommonTree char_literal9_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:202:6: ( ^( 'import' id= moduleId ';' module ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:202:10: ^( 'import' id= moduleId ';' module )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal8=(CommonTree)match(input,IMPORT,FOLLOW_IMPORT_in_imprt141); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal8_tree = (CommonTree)adaptor.dupNode(string_literal8);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal8_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_moduleId_in_imprt145);
            id=moduleId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, id.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal9=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_imprt147); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal9_tree = (CommonTree)adaptor.dupNode(char_literal9);

            root_1 = (CommonTree)adaptor.becomeRoot(char_literal9_tree, root_1);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_module_in_imprt151);
            module10=module();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, module10.getTree());

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
    // $ANTLR end "imprt"

    public static class site_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "site"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:206:1: site : ^( 'site' mappings 'end' ) ;
    public final WaebricChecker.site_return site() throws RecognitionException {
        WaebricChecker.site_return retval = new WaebricChecker.site_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal11=null;
        CommonTree string_literal13=null;
        WaebricChecker.mappings_return mappings12 = null;


        CommonTree string_literal11_tree=null;
        CommonTree string_literal13_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:206:5: ( ^( 'site' mappings 'end' ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:206:9: ^( 'site' mappings 'end' )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal11=(CommonTree)match(input,SITE,FOLLOW_SITE_in_site167); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal11_tree = (CommonTree)adaptor.dupNode(string_literal11);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal11_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_mappings_in_site169);
            mappings12=mappings();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, mappings12.getTree());
            _last = (CommonTree)input.LT(1);
            string_literal13=(CommonTree)match(input,END,FOLLOW_END_in_site171); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal13_tree = (CommonTree)adaptor.dupNode(string_literal13);

            adaptor.addChild(root_1, string_literal13_tree);
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
    // $ANTLR end "site"

    public static class mappings_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mappings"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:207:1: mappings : ( mapping )? ( ';' mapping )* ;
    public final WaebricChecker.mappings_return mappings() throws RecognitionException {
        WaebricChecker.mappings_return retval = new WaebricChecker.mappings_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal15=null;
        WaebricChecker.mapping_return mapping14 = null;

        WaebricChecker.mapping_return mapping16 = null;


        CommonTree char_literal15_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:207:9: ( ( mapping )? ( ';' mapping )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:207:12: ( mapping )? ( ';' mapping )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:207:12: ( mapping )?
            int alt5=2;
            switch ( input.LA(1) ) {
                case SEMICOLON:
                    {
                    int LA5_1 = input.LA(2);

                    if ( (LA5_1==48) ) {
                        int LA5_4 = input.LA(3);

                        if ( (LA5_4==IDCON) ) {
                            alt5=1;
                        }
                    }
                    else if ( (LA5_1==DOWN) ) {
                        alt5=1;
                    }
                    }
                    break;
                case END:
                    {
                    int LA5_2 = input.LA(2);

                    if ( (LA5_2==DOWN||LA5_2==48) ) {
                        alt5=1;
                    }
                    }
                    break;
                case MODULE:
                case IMPORT:
                case SITE:
                case DEF:
                case IF:
                case ELSE:
                case EACH:
                case LET:
                case IN:
                case COMMENT:
                case ECHO:
                case CDATA:
                case YIELD:
                case LIST:
                case RECORD:
                case STRING:
                case IDCON:
                case PATH:
                case NATCON:
                case TEXT:
                case SYMBOLCON:
                case STRCON:
                case PRETEXT:
                case POSTTEXT:
                case MIDTEXT:
                case LETTER:
                case DIGIT:
                case HEXADECIMAL:
                case PATHELEMENT:
                case FILEEXT:
                case STRCHAR:
                case ESCLAYOUT:
                case DECIMAL:
                case TEXTCHAR:
                case ESCQUOTE:
                case AMP:
                case CHARREF:
                case ENTREF:
                case SYMBOLCHAR:
                case COMMENTS:
                case LAYOUT:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                    {
                    alt5=1;
                    }
                    break;
            }

            switch (alt5) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: mapping
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_mapping_in_mappings181);
                    mapping14=mapping();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, mapping14.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:207:21: ( ';' mapping )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==SEMICOLON) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:207:23: ';' mapping
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal15=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_mappings186); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal15_tree = (CommonTree)adaptor.dupNode(char_literal15);

            	    adaptor.addChild(root_0, char_literal15_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_mapping_in_mappings188);
            	    mapping16=mapping();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, mapping16.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:208:1: mapping : . ':' markup ;
    public final WaebricChecker.mapping_return mapping() throws RecognitionException {
        WaebricChecker.mapping_return retval = new WaebricChecker.mapping_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree wildcard17=null;
        CommonTree char_literal18=null;
        WaebricChecker.markup_return markup19 = null;


        CommonTree wildcard17_tree=null;
        CommonTree char_literal18_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:208:9: ( . ':' markup )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:208:12: . ':' markup
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            wildcard17=(CommonTree)input.LT(1);
            matchAny(input); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            wildcard17_tree = (CommonTree)adaptor.dupTree(wildcard17);
            adaptor.addChild(root_0, wildcard17_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal18=(CommonTree)match(input,48,FOLLOW_48_in_mapping202); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal18_tree = (CommonTree)adaptor.dupNode(char_literal18);

            adaptor.addChild(root_0, char_literal18_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_markup_in_mapping204);
            markup19=markup();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, markup19.getTree());

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
    // $ANTLR end "mapping"

    public static class markup_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "markup"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:212:1: markup : d= designator (a= arguments )? ;
    public final WaebricChecker.markup_return markup() throws RecognitionException {
        WaebricChecker.markup_return retval = new WaebricChecker.markup_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricChecker.designator_return d = null;

        WaebricChecker.arguments_return a = null;



         int args = 0; 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:214:2: (d= designator (a= arguments )? )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:214:5: d= designator (a= arguments )?
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_designator_in_markup225);
            d=designator();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, d.getTree());
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:214:18: (a= arguments )?
            int alt7=2;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:214:20: a= arguments
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_arguments_in_markup231);
                    a=arguments();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, a.getTree());
                    if ( state.backtracking==0 ) {
                       args = (a!=null?a.args:0); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              				// Store function call
              				Call call = new Call();
              				call.id = (d!=null?((CommonTree)d.tree):null);
              				call.args = args;
              				call.env = (Stack) Environment_stack.clone();
              				calls.add(call);
              			
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

    public static class designator_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "designator"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:223:1: designator : IDCON ( attribute )* ;
    public final WaebricChecker.designator_return designator() throws RecognitionException {
        WaebricChecker.designator_return retval = new WaebricChecker.designator_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON20=null;
        WaebricChecker.attribute_return attribute21 = null;


        CommonTree IDCON20_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:223:11: ( IDCON ( attribute )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:223:14: IDCON ( attribute )*
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON20=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_designator250); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON20_tree = (CommonTree)adaptor.dupNode(IDCON20);

            adaptor.addChild(root_0, IDCON20_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:223:20: ( attribute )*
            loop8:
            do {
                int alt8=2;
                switch ( input.LA(1) ) {
                case 49:
                    {
                    int LA8_2 = input.LA(2);

                    if ( (LA8_2==IDCON) ) {
                        alt8=1;
                    }


                    }
                    break;
                case 47:
                    {
                    int LA8_3 = input.LA(2);

                    if ( (LA8_3==IDCON) ) {
                        alt8=1;
                    }


                    }
                    break;
                case 50:
                    {
                    int LA8_4 = input.LA(2);

                    if ( (LA8_4==IDCON) ) {
                        alt8=1;
                    }


                    }
                    break;
                case 48:
                    {
                    int LA8_5 = input.LA(2);

                    if ( (LA8_5==IDCON) ) {
                        alt8=1;
                    }


                    }
                    break;
                case 51:
                    {
                    int LA8_6 = input.LA(2);

                    if ( (LA8_6==NATCON) ) {
                        alt8=1;
                    }


                    }
                    break;

                }

                switch (alt8) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: attribute
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_attribute_in_designator252);
            	    attribute21=attribute();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, attribute21.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop8;
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
    // $ANTLR end "designator"

    public static class attribute_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attribute"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:224:1: attribute : ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON ( '%' NATCON )? );
    public final WaebricChecker.attribute_return attribute() throws RecognitionException {
        WaebricChecker.attribute_return retval = new WaebricChecker.attribute_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal22=null;
        CommonTree IDCON23=null;
        CommonTree char_literal24=null;
        CommonTree IDCON25=null;
        CommonTree char_literal26=null;
        CommonTree IDCON27=null;
        CommonTree char_literal28=null;
        CommonTree IDCON29=null;
        CommonTree char_literal30=null;
        CommonTree NATCON31=null;
        CommonTree char_literal32=null;
        CommonTree NATCON33=null;

        CommonTree char_literal22_tree=null;
        CommonTree IDCON23_tree=null;
        CommonTree char_literal24_tree=null;
        CommonTree IDCON25_tree=null;
        CommonTree char_literal26_tree=null;
        CommonTree IDCON27_tree=null;
        CommonTree char_literal28_tree=null;
        CommonTree IDCON29_tree=null;
        CommonTree char_literal30_tree=null;
        CommonTree NATCON31_tree=null;
        CommonTree char_literal32_tree=null;
        CommonTree NATCON33_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:224:10: ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON ( '%' NATCON )? )
            int alt10=5;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt10=1;
                }
                break;
            case 47:
                {
                alt10=2;
                }
                break;
            case 50:
                {
                alt10=3;
                }
                break;
            case 48:
                {
                alt10=4;
                }
                break;
            case 51:
                {
                alt10=5;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:224:13: '#' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal22=(CommonTree)match(input,49,FOLLOW_49_in_attribute261); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal22_tree = (CommonTree)adaptor.dupNode(char_literal22);

                    adaptor.addChild(root_0, char_literal22_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON23=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute263); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON23_tree = (CommonTree)adaptor.dupNode(IDCON23);

                    adaptor.addChild(root_0, IDCON23_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:224:25: '.' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal24=(CommonTree)match(input,47,FOLLOW_47_in_attribute267); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal24_tree = (CommonTree)adaptor.dupNode(char_literal24);

                    adaptor.addChild(root_0, char_literal24_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON25=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute269); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON25_tree = (CommonTree)adaptor.dupNode(IDCON25);

                    adaptor.addChild(root_0, IDCON25_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:224:37: '$' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal26=(CommonTree)match(input,50,FOLLOW_50_in_attribute273); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal26_tree = (CommonTree)adaptor.dupNode(char_literal26);

                    adaptor.addChild(root_0, char_literal26_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON27=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute275); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON27_tree = (CommonTree)adaptor.dupNode(IDCON27);

                    adaptor.addChild(root_0, IDCON27_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:224:49: ':' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal28=(CommonTree)match(input,48,FOLLOW_48_in_attribute279); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal28_tree = (CommonTree)adaptor.dupNode(char_literal28);

                    adaptor.addChild(root_0, char_literal28_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON29=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute281); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON29_tree = (CommonTree)adaptor.dupNode(IDCON29);

                    adaptor.addChild(root_0, IDCON29_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:224:61: '@' NATCON ( '%' NATCON )?
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal30=(CommonTree)match(input,51,FOLLOW_51_in_attribute285); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal30_tree = (CommonTree)adaptor.dupNode(char_literal30);

                    adaptor.addChild(root_0, char_literal30_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    NATCON31=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_attribute287); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON31_tree = (CommonTree)adaptor.dupNode(NATCON31);

                    adaptor.addChild(root_0, NATCON31_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:224:72: ( '%' NATCON )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==52) ) {
                        int LA9_1 = input.LA(2);

                        if ( (LA9_1==NATCON) ) {
                            alt9=1;
                        }
                    }
                    switch (alt9) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:224:74: '%' NATCON
                            {
                            _last = (CommonTree)input.LT(1);
                            char_literal32=(CommonTree)match(input,52,FOLLOW_52_in_attribute291); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal32_tree = (CommonTree)adaptor.dupNode(char_literal32);

                            adaptor.addChild(root_0, char_literal32_tree);
                            }
                            _last = (CommonTree)input.LT(1);
                            NATCON33=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_attribute293); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NATCON33_tree = (CommonTree)adaptor.dupNode(NATCON33);

                            adaptor.addChild(root_0, NATCON33_tree);
                            }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

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
    // $ANTLR end "attribute"

    public static class arguments_return extends TreeRuleReturnScope {
        public int args = 0;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arguments"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:226:1: arguments returns [int args = 0] : '(' ( expression )? ( ',' expression )* ')' ;
    public final WaebricChecker.arguments_return arguments() throws RecognitionException {
        WaebricChecker.arguments_return retval = new WaebricChecker.arguments_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal34=null;
        CommonTree char_literal36=null;
        CommonTree char_literal38=null;
        WaebricChecker.expression_return expression35 = null;

        WaebricChecker.expression_return expression37 = null;


        CommonTree char_literal34_tree=null;
        CommonTree char_literal36_tree=null;
        CommonTree char_literal38_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:227:2: ( '(' ( expression )? ( ',' expression )* ')' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:227:5: '(' ( expression )? ( ',' expression )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            char_literal34=(CommonTree)match(input,53,FOLLOW_53_in_arguments313); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal34_tree = (CommonTree)adaptor.dupNode(char_literal34);

            adaptor.addChild(root_0, char_literal34_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:227:9: ( expression )?
            int alt11=2;
            switch ( input.LA(1) ) {
                case MODULE:
                case IMPORT:
                case SITE:
                case DEF:
                case END:
                case IF:
                case ELSE:
                case EACH:
                case LET:
                case IN:
                case COMMENT:
                case ECHO:
                case CDATA:
                case YIELD:
                case LIST:
                case RECORD:
                case STRING:
                case IDCON:
                case PATH:
                case NATCON:
                case TEXT:
                case SYMBOLCON:
                case STRCON:
                case PRETEXT:
                case POSTTEXT:
                case MIDTEXT:
                case SEMICOLON:
                case LETTER:
                case DIGIT:
                case HEXADECIMAL:
                case PATHELEMENT:
                case FILEEXT:
                case STRCHAR:
                case ESCLAYOUT:
                case DECIMAL:
                case TEXTCHAR:
                case ESCQUOTE:
                case AMP:
                case CHARREF:
                case ENTREF:
                case SYMBOLCHAR:
                case COMMENTS:
                case LAYOUT:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                    {
                    alt11=1;
                    }
                    break;
                case 54:
                    {
                    int LA11_4 = input.LA(2);

                    if ( (synpred14_WaebricChecker()) ) {
                        alt11=1;
                    }
                    }
                    break;
                case 55:
                    {
                    int LA11_5 = input.LA(2);

                    if ( (synpred14_WaebricChecker()) ) {
                        alt11=1;
                    }
                    }
                    break;
            }

            switch (alt11) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:227:11: expression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_arguments317);
                    expression35=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression35.getTree());
                    if ( state.backtracking==0 ) {
                      retval.args++;
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:227:36: ( ',' expression )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==54) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:227:38: ',' expression
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal36=(CommonTree)match(input,54,FOLLOW_54_in_arguments326); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal36_tree = (CommonTree)adaptor.dupNode(char_literal36);

            	    adaptor.addChild(root_0, char_literal36_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expression_in_arguments328);
            	    expression37=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, expression37.getTree());
            	    if ( state.backtracking==0 ) {
            	      retval.args++;
            	    }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            char_literal38=(CommonTree)match(input,55,FOLLOW_55_in_arguments335); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal38_tree = (CommonTree)adaptor.dupNode(char_literal38);

            adaptor.addChild(root_0, char_literal38_tree);
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
    // $ANTLR end "arguments"

    public static class expression_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:233:1: expression : ( varExpression | listExpression | recordExpression | . ) ( '+' expression | '.' IDCON )* ;
    public final WaebricChecker.expression_return expression() throws RecognitionException {
        WaebricChecker.expression_return retval = new WaebricChecker.expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree wildcard42=null;
        CommonTree char_literal43=null;
        CommonTree char_literal45=null;
        CommonTree IDCON46=null;
        WaebricChecker.varExpression_return varExpression39 = null;

        WaebricChecker.listExpression_return listExpression40 = null;

        WaebricChecker.recordExpression_return recordExpression41 = null;

        WaebricChecker.expression_return expression44 = null;


        CommonTree wildcard42_tree=null;
        CommonTree char_literal43_tree=null;
        CommonTree char_literal45_tree=null;
        CommonTree IDCON46_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:233:11: ( ( varExpression | listExpression | recordExpression | . ) ( '+' expression | '.' IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:233:14: ( varExpression | listExpression | recordExpression | . ) ( '+' expression | '.' IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:233:14: ( varExpression | listExpression | recordExpression | . )
            int alt13=4;
            switch ( input.LA(1) ) {
            case IDCON:
                {
                int LA13_1 = input.LA(2);

                if ( (synpred16_WaebricChecker()) ) {
                    alt13=1;
                }
                else if ( (true) ) {
                    alt13=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
                }
                break;
            case 57:
                {
                int LA13_2 = input.LA(2);

                if ( (synpred17_WaebricChecker()) ) {
                    alt13=2;
                }
                else if ( (true) ) {
                    alt13=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 2, input);

                    throw nvae;
                }
                }
                break;
            case 59:
                {
                int LA13_3 = input.LA(2);

                if ( (synpred18_WaebricChecker()) ) {
                    alt13=3;
                }
                else if ( (true) ) {
                    alt13=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 3, input);

                    throw nvae;
                }
                }
                break;
            case MODULE:
            case IMPORT:
            case SITE:
            case DEF:
            case END:
            case IF:
            case ELSE:
            case EACH:
            case LET:
            case IN:
            case COMMENT:
            case ECHO:
            case CDATA:
            case YIELD:
            case LIST:
            case RECORD:
            case STRING:
            case PATH:
            case NATCON:
            case TEXT:
            case SYMBOLCON:
            case STRCON:
            case PRETEXT:
            case POSTTEXT:
            case MIDTEXT:
            case SEMICOLON:
            case LETTER:
            case DIGIT:
            case HEXADECIMAL:
            case PATHELEMENT:
            case FILEEXT:
            case STRCHAR:
            case ESCLAYOUT:
            case DECIMAL:
            case TEXTCHAR:
            case ESCQUOTE:
            case AMP:
            case CHARREF:
            case ENTREF:
            case SYMBOLCHAR:
            case COMMENTS:
            case LAYOUT:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 58:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
                {
                alt13=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:233:16: varExpression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_varExpression_in_expression350);
                    varExpression39=varExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, varExpression39.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:233:32: listExpression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_listExpression_in_expression354);
                    listExpression40=listExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, listExpression40.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:233:49: recordExpression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_recordExpression_in_expression358);
                    recordExpression41=recordExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, recordExpression41.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:233:68: .
                    {
                    _last = (CommonTree)input.LT(1);
                    wildcard42=(CommonTree)input.LT(1);
                    matchAny(input); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    wildcard42_tree = (CommonTree)adaptor.dupTree(wildcard42);
                    adaptor.addChild(root_0, wildcard42_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:233:72: ( '+' expression | '.' IDCON )*
            loop14:
            do {
                int alt14=3;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==56) ) {
                    int LA14_2 = input.LA(2);

                    if ( (synpred19_WaebricChecker()) ) {
                        alt14=1;
                    }


                }
                else if ( (LA14_0==47) ) {
                    int LA14_3 = input.LA(2);

                    if ( (synpred20_WaebricChecker()) ) {
                        alt14=2;
                    }


                }


                switch (alt14) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:233:74: '+' expression
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal43=(CommonTree)match(input,56,FOLLOW_56_in_expression368); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal43_tree = (CommonTree)adaptor.dupNode(char_literal43);

            	    adaptor.addChild(root_0, char_literal43_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expression_in_expression370);
            	    expression44=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, expression44.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:233:91: '.' IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal45=(CommonTree)match(input,47,FOLLOW_47_in_expression374); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal45_tree = (CommonTree)adaptor.dupNode(char_literal45);

            	    adaptor.addChild(root_0, char_literal45_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    IDCON46=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression376); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDCON46_tree = (CommonTree)adaptor.dupNode(IDCON46);

            	    adaptor.addChild(root_0, IDCON46_tree);
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
    // $ANTLR end "expression"

    public static class varExpression_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "varExpression"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:235:1: varExpression : id= IDCON ;
    public final WaebricChecker.varExpression_return varExpression() throws RecognitionException {
        WaebricChecker.varExpression_return retval = new WaebricChecker.varExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;

        CommonTree id_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:235:14: (id= IDCON )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:235:17: id= IDCON
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_varExpression390); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (CommonTree)adaptor.dupNode(id);

            adaptor.addChild(root_0, id_tree);
            }
            if ( state.backtracking==0 ) {

              				if(! isDefinedVariable(id)) {
              					exceptions.add(new UndefinedVariableException(id));
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
    // $ANTLR end "varExpression"

    public static class listExpression_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "listExpression"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:241:1: listExpression : '[' ( expression )? ( ',' expression )* ']' ;
    public final WaebricChecker.listExpression_return listExpression() throws RecognitionException {
        WaebricChecker.listExpression_return retval = new WaebricChecker.listExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal47=null;
        CommonTree char_literal49=null;
        CommonTree char_literal51=null;
        WaebricChecker.expression_return expression48 = null;

        WaebricChecker.expression_return expression50 = null;


        CommonTree char_literal47_tree=null;
        CommonTree char_literal49_tree=null;
        CommonTree char_literal51_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:241:15: ( '[' ( expression )? ( ',' expression )* ']' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:241:18: '[' ( expression )? ( ',' expression )* ']'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            char_literal47=(CommonTree)match(input,57,FOLLOW_57_in_listExpression404); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal47_tree = (CommonTree)adaptor.dupNode(char_literal47);

            adaptor.addChild(root_0, char_literal47_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:241:22: ( expression )?
            int alt15=2;
            switch ( input.LA(1) ) {
                case MODULE:
                case IMPORT:
                case SITE:
                case DEF:
                case END:
                case IF:
                case ELSE:
                case EACH:
                case LET:
                case IN:
                case COMMENT:
                case ECHO:
                case CDATA:
                case YIELD:
                case LIST:
                case RECORD:
                case STRING:
                case IDCON:
                case PATH:
                case NATCON:
                case TEXT:
                case SYMBOLCON:
                case STRCON:
                case PRETEXT:
                case POSTTEXT:
                case MIDTEXT:
                case SEMICOLON:
                case LETTER:
                case DIGIT:
                case HEXADECIMAL:
                case PATHELEMENT:
                case FILEEXT:
                case STRCHAR:
                case ESCLAYOUT:
                case DECIMAL:
                case TEXTCHAR:
                case ESCQUOTE:
                case AMP:
                case CHARREF:
                case ENTREF:
                case SYMBOLCHAR:
                case COMMENTS:
                case LAYOUT:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 55:
                case 56:
                case 57:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                    {
                    alt15=1;
                    }
                    break;
                case 54:
                    {
                    int LA15_4 = input.LA(2);

                    if ( (synpred21_WaebricChecker()) ) {
                        alt15=1;
                    }
                    }
                    break;
                case 58:
                    {
                    int LA15_5 = input.LA(2);

                    if ( (synpred21_WaebricChecker()) ) {
                        alt15=1;
                    }
                    }
                    break;
            }

            switch (alt15) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: expression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_listExpression406);
                    expression48=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression48.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:241:34: ( ',' expression )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==54) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:241:36: ',' expression
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal49=(CommonTree)match(input,54,FOLLOW_54_in_listExpression411); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal49_tree = (CommonTree)adaptor.dupNode(char_literal49);

            	    adaptor.addChild(root_0, char_literal49_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expression_in_listExpression413);
            	    expression50=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, expression50.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            char_literal51=(CommonTree)match(input,58,FOLLOW_58_in_listExpression418); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal51_tree = (CommonTree)adaptor.dupNode(char_literal51);

            adaptor.addChild(root_0, char_literal51_tree);
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
    // $ANTLR end "listExpression"

    public static class recordExpression_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "recordExpression"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:242:1: recordExpression : '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ;
    public final WaebricChecker.recordExpression_return recordExpression() throws RecognitionException {
        WaebricChecker.recordExpression_return retval = new WaebricChecker.recordExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal52=null;
        CommonTree char_literal54=null;
        CommonTree char_literal56=null;
        WaebricChecker.keyValuePair_return keyValuePair53 = null;

        WaebricChecker.keyValuePair_return keyValuePair55 = null;


        CommonTree char_literal52_tree=null;
        CommonTree char_literal54_tree=null;
        CommonTree char_literal56_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:242:17: ( '{' ( keyValuePair )? ( ',' keyValuePair )* '}' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:242:19: '{' ( keyValuePair )? ( ',' keyValuePair )* '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            char_literal52=(CommonTree)match(input,59,FOLLOW_59_in_recordExpression425); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal52_tree = (CommonTree)adaptor.dupNode(char_literal52);

            adaptor.addChild(root_0, char_literal52_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:242:23: ( keyValuePair )?
            int alt17=2;
            switch ( input.LA(1) ) {
                case 54:
                    {
                    int LA17_1 = input.LA(2);

                    if ( (synpred23_WaebricChecker()) ) {
                        alt17=1;
                    }
                    }
                    break;
                case 60:
                    {
                    int LA17_2 = input.LA(2);

                    if ( (synpred23_WaebricChecker()) ) {
                        alt17=1;
                    }
                    }
                    break;
                case MODULE:
                case IMPORT:
                case SITE:
                case DEF:
                case END:
                case IF:
                case ELSE:
                case EACH:
                case LET:
                case IN:
                case COMMENT:
                case ECHO:
                case CDATA:
                case YIELD:
                case LIST:
                case RECORD:
                case STRING:
                case IDCON:
                case PATH:
                case NATCON:
                case TEXT:
                case SYMBOLCON:
                case STRCON:
                case PRETEXT:
                case POSTTEXT:
                case MIDTEXT:
                case SEMICOLON:
                case LETTER:
                case DIGIT:
                case HEXADECIMAL:
                case PATHELEMENT:
                case FILEEXT:
                case STRCHAR:
                case ESCLAYOUT:
                case DECIMAL:
                case TEXTCHAR:
                case ESCQUOTE:
                case AMP:
                case CHARREF:
                case ENTREF:
                case SYMBOLCHAR:
                case COMMENTS:
                case LAYOUT:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                    {
                    alt17=1;
                    }
                    break;
            }

            switch (alt17) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: keyValuePair
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_keyValuePair_in_recordExpression427);
                    keyValuePair53=keyValuePair();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, keyValuePair53.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:242:37: ( ',' keyValuePair )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==54) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:242:39: ',' keyValuePair
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal54=(CommonTree)match(input,54,FOLLOW_54_in_recordExpression432); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal54_tree = (CommonTree)adaptor.dupNode(char_literal54);

            	    adaptor.addChild(root_0, char_literal54_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_keyValuePair_in_recordExpression434);
            	    keyValuePair55=keyValuePair();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, keyValuePair55.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            char_literal56=(CommonTree)match(input,60,FOLLOW_60_in_recordExpression439); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal56_tree = (CommonTree)adaptor.dupNode(char_literal56);

            adaptor.addChild(root_0, char_literal56_tree);
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
    // $ANTLR end "recordExpression"

    public static class keyValuePair_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "keyValuePair"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:243:1: keyValuePair : . ':' expression ;
    public final WaebricChecker.keyValuePair_return keyValuePair() throws RecognitionException {
        WaebricChecker.keyValuePair_return retval = new WaebricChecker.keyValuePair_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree wildcard57=null;
        CommonTree char_literal58=null;
        WaebricChecker.expression_return expression59 = null;


        CommonTree wildcard57_tree=null;
        CommonTree char_literal58_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:243:13: ( . ':' expression )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:243:16: . ':' expression
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            wildcard57=(CommonTree)input.LT(1);
            matchAny(input); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            wildcard57_tree = (CommonTree)adaptor.dupTree(wildcard57);
            adaptor.addChild(root_0, wildcard57_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal58=(CommonTree)match(input,48,FOLLOW_48_in_keyValuePair449); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal58_tree = (CommonTree)adaptor.dupNode(char_literal58);

            adaptor.addChild(root_0, char_literal58_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_keyValuePair451);
            expression59=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, expression59.getTree());

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:247:1: function : ^( 'def' id= IDCON f= formals ( statement )* 'end' ) ;
    public final WaebricChecker.function_return function() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.function_return retval = new WaebricChecker.function_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        CommonTree string_literal60=null;
        CommonTree string_literal62=null;
        WaebricChecker.formals_return f = null;

        WaebricChecker.statement_return statement61 = null;


        CommonTree id_tree=null;
        CommonTree string_literal60_tree=null;
        CommonTree string_literal62_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new HashSet<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:252:4: ( ^( 'def' id= IDCON f= formals ( statement )* 'end' ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:252:7: ^( 'def' id= IDCON f= formals ( statement )* 'end' )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal60=(CommonTree)match(input,DEF,FOLLOW_DEF_in_function477); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal60_tree = (CommonTree)adaptor.dupNode(string_literal60);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal60_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_function481); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (CommonTree)adaptor.dupNode(id);

            adaptor.addChild(root_1, id_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_formals_in_function485);
            f=formals();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, f.getTree());
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:252:35: ( statement )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==IF||(LA19_0>=EACH && LA19_0<=LET)||(LA19_0>=COMMENT && LA19_0<=CDATA)||LA19_0==IDCON||LA19_0==59||LA19_0==61) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_function487);
            	    statement61=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, statement61.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            string_literal62=(CommonTree)match(input,END,FOLLOW_END_in_function490); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal62_tree = (CommonTree)adaptor.dupNode(string_literal62);

            adaptor.addChild(root_1, string_literal62_tree);
            }

            match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }

            if ( state.backtracking==0 ) {
               
              				defineFunction(id, (f!=null?f.args:0), 0);
              			
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
            Environment_stack.pop();

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:256:1: formals returns [int args = 0] : (r= regularFormals | emptyFormals );
    public final WaebricChecker.formals_return formals() throws RecognitionException {
        WaebricChecker.formals_return retval = new WaebricChecker.formals_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricChecker.regularFormals_return r = null;

        WaebricChecker.emptyFormals_return emptyFormals63 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:257:2: (r= regularFormals | emptyFormals )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==53) ) {
                alt20=1;
            }
            else if ( ((LA20_0>=END && LA20_0<=IF)||(LA20_0>=EACH && LA20_0<=LET)||(LA20_0>=COMMENT && LA20_0<=CDATA)||LA20_0==IDCON||LA20_0==59||LA20_0==61) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:257:5: r= regularFormals
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_regularFormals_in_formals515);
                    r=regularFormals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, r.getTree());
                    if ( state.backtracking==0 ) {
                       retval.args = (r!=null?r.args:0); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:257:45: emptyFormals
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_emptyFormals_in_formals521);
                    emptyFormals63=emptyFormals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, emptyFormals63.getTree());

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
    // $ANTLR end "formals"

    public static class regularFormals_return extends TreeRuleReturnScope {
        public int args = 0;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "regularFormals"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:259:1: regularFormals returns [int args = 0] : '(' (id= IDCON )* ')' ;
    public final WaebricChecker.regularFormals_return regularFormals() throws RecognitionException {
        WaebricChecker.regularFormals_return retval = new WaebricChecker.regularFormals_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        CommonTree char_literal64=null;
        CommonTree char_literal65=null;

        CommonTree id_tree=null;
        CommonTree char_literal64_tree=null;
        CommonTree char_literal65_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:260:2: ( '(' (id= IDCON )* ')' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:260:5: '(' (id= IDCON )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            char_literal64=(CommonTree)match(input,53,FOLLOW_53_in_regularFormals539); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal64_tree = (CommonTree)adaptor.dupNode(char_literal64);

            adaptor.addChild(root_0, char_literal64_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:260:9: (id= IDCON )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==IDCON) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:260:11: id= IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_regularFormals545); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    id_tree = (CommonTree)adaptor.dupNode(id);

            	    adaptor.addChild(root_0, id_tree);
            	    }
            	    if ( state.backtracking==0 ) {
            	       defineVariable(id); retval.args++; 
            	    }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            char_literal65=(CommonTree)match(input,55,FOLLOW_55_in_regularFormals552); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal65_tree = (CommonTree)adaptor.dupNode(char_literal65);

            adaptor.addChild(root_0, char_literal65_tree);
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
    // $ANTLR end "regularFormals"

    public static class emptyFormals_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "emptyFormals"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:262:1: emptyFormals : ;
    public final WaebricChecker.emptyFormals_return emptyFormals() throws RecognitionException {
        WaebricChecker.emptyFormals_return retval = new WaebricChecker.emptyFormals_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:262:13: ()
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:262:41: 
            {
            root_0 = (CommonTree)adaptor.nil();

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "emptyFormals"

    public static class statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:266:1: statement : ( ifElseStatement | ifStatement | eachStatement | letStatement | blockStatement | commentStatement | echoStatement | cdataStatement | yieldStatement | markupStatements );
    public final WaebricChecker.statement_return statement() throws RecognitionException {
        WaebricChecker.statement_return retval = new WaebricChecker.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricChecker.ifElseStatement_return ifElseStatement66 = null;

        WaebricChecker.ifStatement_return ifStatement67 = null;

        WaebricChecker.eachStatement_return eachStatement68 = null;

        WaebricChecker.letStatement_return letStatement69 = null;

        WaebricChecker.blockStatement_return blockStatement70 = null;

        WaebricChecker.commentStatement_return commentStatement71 = null;

        WaebricChecker.echoStatement_return echoStatement72 = null;

        WaebricChecker.cdataStatement_return cdataStatement73 = null;

        WaebricChecker.yieldStatement_return yieldStatement74 = null;

        WaebricChecker.markupStatements_return markupStatements75 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:266:10: ( ifElseStatement | ifStatement | eachStatement | letStatement | blockStatement | commentStatement | echoStatement | cdataStatement | yieldStatement | markupStatements )
            int alt22=10;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:266:13: ifElseStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_ifElseStatement_in_statement572);
                    ifElseStatement66=ifElseStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, ifElseStatement66.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:266:31: ifStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_ifStatement_in_statement576);
                    ifStatement67=ifStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, ifStatement67.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:266:45: eachStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_eachStatement_in_statement580);
                    eachStatement68=eachStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, eachStatement68.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:266:61: letStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_letStatement_in_statement584);
                    letStatement69=letStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, letStatement69.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:266:76: blockStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_blockStatement_in_statement588);
                    blockStatement70=blockStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, blockStatement70.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:267:4: commentStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_commentStatement_in_statement596);
                    commentStatement71=commentStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, commentStatement71.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:267:23: echoStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_echoStatement_in_statement600);
                    echoStatement72=echoStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, echoStatement72.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:267:39: cdataStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cdataStatement_in_statement604);
                    cdataStatement73=cdataStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cdataStatement73.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:267:56: yieldStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_yieldStatement_in_statement608);
                    yieldStatement74=yieldStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, yieldStatement74.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:267:73: markupStatements
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markupStatements_in_statement612);
                    markupStatements75=markupStatements();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, markupStatements75.getTree());

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

    public static class ifElseStatement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ifElseStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:269:1: ifElseStatement : 'if' '(' predicate ')' statement 'else' statement ;
    public final WaebricChecker.ifElseStatement_return ifElseStatement() throws RecognitionException {
        WaebricChecker.ifElseStatement_return retval = new WaebricChecker.ifElseStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal76=null;
        CommonTree char_literal77=null;
        CommonTree char_literal79=null;
        CommonTree string_literal81=null;
        WaebricChecker.predicate_return predicate78 = null;

        WaebricChecker.statement_return statement80 = null;

        WaebricChecker.statement_return statement82 = null;


        CommonTree string_literal76_tree=null;
        CommonTree char_literal77_tree=null;
        CommonTree char_literal79_tree=null;
        CommonTree string_literal81_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:269:16: ( 'if' '(' predicate ')' statement 'else' statement )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:269:18: 'if' '(' predicate ')' statement 'else' statement
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal76=(CommonTree)match(input,IF,FOLLOW_IF_in_ifElseStatement620); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal76_tree = (CommonTree)adaptor.dupNode(string_literal76);

            adaptor.addChild(root_0, string_literal76_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal77=(CommonTree)match(input,53,FOLLOW_53_in_ifElseStatement622); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal77_tree = (CommonTree)adaptor.dupNode(char_literal77);

            adaptor.addChild(root_0, char_literal77_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_predicate_in_ifElseStatement624);
            predicate78=predicate();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, predicate78.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal79=(CommonTree)match(input,55,FOLLOW_55_in_ifElseStatement626); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal79_tree = (CommonTree)adaptor.dupNode(char_literal79);

            adaptor.addChild(root_0, char_literal79_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_ifElseStatement628);
            statement80=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, statement80.getTree());
            _last = (CommonTree)input.LT(1);
            string_literal81=(CommonTree)match(input,ELSE,FOLLOW_ELSE_in_ifElseStatement630); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal81_tree = (CommonTree)adaptor.dupNode(string_literal81);

            adaptor.addChild(root_0, string_literal81_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_ifElseStatement632);
            statement82=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, statement82.getTree());

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
    // $ANTLR end "ifElseStatement"

    public static class ifStatement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ifStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:270:1: ifStatement : 'if' '(' predicate ')' statement ;
    public final WaebricChecker.ifStatement_return ifStatement() throws RecognitionException {
        WaebricChecker.ifStatement_return retval = new WaebricChecker.ifStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal83=null;
        CommonTree char_literal84=null;
        CommonTree char_literal86=null;
        WaebricChecker.predicate_return predicate85 = null;

        WaebricChecker.statement_return statement87 = null;


        CommonTree string_literal83_tree=null;
        CommonTree char_literal84_tree=null;
        CommonTree char_literal86_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:270:12: ( 'if' '(' predicate ')' statement )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:270:15: 'if' '(' predicate ')' statement
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal83=(CommonTree)match(input,IF,FOLLOW_IF_in_ifStatement643); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal83_tree = (CommonTree)adaptor.dupNode(string_literal83);

            adaptor.addChild(root_0, string_literal83_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal84=(CommonTree)match(input,53,FOLLOW_53_in_ifStatement645); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal84_tree = (CommonTree)adaptor.dupNode(char_literal84);

            adaptor.addChild(root_0, char_literal84_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_predicate_in_ifStatement647);
            predicate85=predicate();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, predicate85.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal86=(CommonTree)match(input,55,FOLLOW_55_in_ifStatement649); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal86_tree = (CommonTree)adaptor.dupNode(char_literal86);

            adaptor.addChild(root_0, char_literal86_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_ifStatement651);
            statement87=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, statement87.getTree());

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
    // $ANTLR end "ifStatement"

    public static class predicate_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "predicate"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:274:1: predicate : ( notPredicate | declaredPredicate | isPredicate ) ( '&&' predicate | '||' predicate )* ;
    public final WaebricChecker.predicate_return predicate() throws RecognitionException {
        WaebricChecker.predicate_return retval = new WaebricChecker.predicate_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal91=null;
        CommonTree string_literal93=null;
        WaebricChecker.notPredicate_return notPredicate88 = null;

        WaebricChecker.declaredPredicate_return declaredPredicate89 = null;

        WaebricChecker.isPredicate_return isPredicate90 = null;

        WaebricChecker.predicate_return predicate92 = null;

        WaebricChecker.predicate_return predicate94 = null;


        CommonTree string_literal91_tree=null;
        CommonTree string_literal93_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:274:10: ( ( notPredicate | declaredPredicate | isPredicate ) ( '&&' predicate | '||' predicate )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:274:13: ( notPredicate | declaredPredicate | isPredicate ) ( '&&' predicate | '||' predicate )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:274:13: ( notPredicate | declaredPredicate | isPredicate )
            int alt23=3;
            switch ( input.LA(1) ) {
            case 65:
                {
                int LA23_1 = input.LA(2);

                if ( (synpred37_WaebricChecker()) ) {
                    alt23=1;
                }
                else if ( (synpred38_WaebricChecker()) ) {
                    alt23=2;
                }
                else if ( (true) ) {
                    alt23=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 1, input);

                    throw nvae;
                }
                }
                break;
            case IDCON:
                {
                int LA23_2 = input.LA(2);

                if ( (synpred38_WaebricChecker()) ) {
                    alt23=2;
                }
                else if ( (true) ) {
                    alt23=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 2, input);

                    throw nvae;
                }
                }
                break;
            case 57:
                {
                int LA23_3 = input.LA(2);

                if ( (synpred38_WaebricChecker()) ) {
                    alt23=2;
                }
                else if ( (true) ) {
                    alt23=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 3, input);

                    throw nvae;
                }
                }
                break;
            case 59:
                {
                int LA23_4 = input.LA(2);

                if ( (synpred38_WaebricChecker()) ) {
                    alt23=2;
                }
                else if ( (true) ) {
                    alt23=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 4, input);

                    throw nvae;
                }
                }
                break;
            case MODULE:
            case IMPORT:
            case SITE:
            case DEF:
            case END:
            case IF:
            case ELSE:
            case EACH:
            case LET:
            case IN:
            case COMMENT:
            case ECHO:
            case CDATA:
            case YIELD:
            case LIST:
            case RECORD:
            case STRING:
            case PATH:
            case NATCON:
            case TEXT:
            case SYMBOLCON:
            case STRCON:
            case PRETEXT:
            case POSTTEXT:
            case MIDTEXT:
            case SEMICOLON:
            case LETTER:
            case DIGIT:
            case HEXADECIMAL:
            case PATHELEMENT:
            case FILEEXT:
            case STRCHAR:
            case ESCLAYOUT:
            case DECIMAL:
            case TEXTCHAR:
            case ESCQUOTE:
            case AMP:
            case CHARREF:
            case ENTREF:
            case SYMBOLCHAR:
            case COMMENTS:
            case LAYOUT:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 58:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
                {
                int LA23_5 = input.LA(2);

                if ( (synpred38_WaebricChecker()) ) {
                    alt23=2;
                }
                else if ( (true) ) {
                    alt23=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 5, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:274:15: notPredicate
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_notPredicate_in_predicate664);
                    notPredicate88=notPredicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, notPredicate88.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:274:30: declaredPredicate
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_declaredPredicate_in_predicate668);
                    declaredPredicate89=declaredPredicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, declaredPredicate89.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:274:50: isPredicate
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_isPredicate_in_predicate672);
                    isPredicate90=isPredicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, isPredicate90.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:274:64: ( '&&' predicate | '||' predicate )*
            loop24:
            do {
                int alt24=3;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==63) ) {
                    int LA24_2 = input.LA(2);

                    if ( (synpred39_WaebricChecker()) ) {
                        alt24=1;
                    }


                }
                else if ( (LA24_0==64) ) {
                    int LA24_3 = input.LA(2);

                    if ( (synpred40_WaebricChecker()) ) {
                        alt24=2;
                    }


                }


                switch (alt24) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:274:66: '&&' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal91=(CommonTree)match(input,63,FOLLOW_63_in_predicate678); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal91_tree = (CommonTree)adaptor.dupNode(string_literal91);

            	    adaptor.addChild(root_0, string_literal91_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate680);
            	    predicate92=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, predicate92.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:274:83: '||' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal93=(CommonTree)match(input,64,FOLLOW_64_in_predicate684); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal93_tree = (CommonTree)adaptor.dupNode(string_literal93);

            	    adaptor.addChild(root_0, string_literal93_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate686);
            	    predicate94=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, predicate94.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop24;
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

    public static class notPredicate_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "notPredicate"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:275:1: notPredicate : '!' predicate ;
    public final WaebricChecker.notPredicate_return notPredicate() throws RecognitionException {
        WaebricChecker.notPredicate_return retval = new WaebricChecker.notPredicate_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal95=null;
        WaebricChecker.predicate_return predicate96 = null;


        CommonTree char_literal95_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:275:13: ( '!' predicate )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:275:16: '!' predicate
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            char_literal95=(CommonTree)match(input,65,FOLLOW_65_in_notPredicate698); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal95_tree = (CommonTree)adaptor.dupNode(char_literal95);

            adaptor.addChild(root_0, char_literal95_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_predicate_in_notPredicate700);
            predicate96=predicate();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, predicate96.getTree());

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
    // $ANTLR end "notPredicate"

    public static class declaredPredicate_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "declaredPredicate"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:276:1: declaredPredicate : expression ;
    public final WaebricChecker.declaredPredicate_return declaredPredicate() throws RecognitionException {
        WaebricChecker.declaredPredicate_return retval = new WaebricChecker.declaredPredicate_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricChecker.expression_return expression97 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:276:18: ( expression )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:276:20: expression
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_declaredPredicate708);
            expression97=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, expression97.getTree());

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
    // $ANTLR end "declaredPredicate"

    public static class isPredicate_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "isPredicate"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:277:1: isPredicate : expression '.' . ;
    public final WaebricChecker.isPredicate_return isPredicate() throws RecognitionException {
        WaebricChecker.isPredicate_return retval = new WaebricChecker.isPredicate_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal99=null;
        CommonTree wildcard100=null;
        WaebricChecker.expression_return expression98 = null;


        CommonTree char_literal99_tree=null;
        CommonTree wildcard100_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:277:12: ( expression '.' . )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:277:15: expression '.' .
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_isPredicate716);
            expression98=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, expression98.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal99=(CommonTree)match(input,47,FOLLOW_47_in_isPredicate718); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal99_tree = (CommonTree)adaptor.dupNode(char_literal99);

            adaptor.addChild(root_0, char_literal99_tree);
            }
            _last = (CommonTree)input.LT(1);
            wildcard100=(CommonTree)input.LT(1);
            matchAny(input); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            wildcard100_tree = (CommonTree)adaptor.dupTree(wildcard100);
            adaptor.addChild(root_0, wildcard100_tree);
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
    // $ANTLR end "isPredicate"

    public static class blockStatement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "blockStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:281:1: blockStatement : '{' ( statement )* '}' ;
    public final WaebricChecker.blockStatement_return blockStatement() throws RecognitionException {
        WaebricChecker.blockStatement_return retval = new WaebricChecker.blockStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal101=null;
        CommonTree char_literal103=null;
        WaebricChecker.statement_return statement102 = null;


        CommonTree char_literal101_tree=null;
        CommonTree char_literal103_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:281:15: ( '{' ( statement )* '}' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:281:18: '{' ( statement )* '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            char_literal101=(CommonTree)match(input,59,FOLLOW_59_in_blockStatement733); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal101_tree = (CommonTree)adaptor.dupNode(char_literal101);

            adaptor.addChild(root_0, char_literal101_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:281:22: ( statement )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==IF||(LA25_0>=EACH && LA25_0<=LET)||(LA25_0>=COMMENT && LA25_0<=CDATA)||LA25_0==IDCON||LA25_0==59||LA25_0==61) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_blockStatement735);
            	    statement102=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, statement102.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            char_literal103=(CommonTree)match(input,60,FOLLOW_60_in_blockStatement738); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal103_tree = (CommonTree)adaptor.dupNode(char_literal103);

            adaptor.addChild(root_0, char_literal103_tree);
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
    // $ANTLR end "blockStatement"

    public static class commentStatement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "commentStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:282:1: commentStatement : 'comment' STRCON ';' ;
    public final WaebricChecker.commentStatement_return commentStatement() throws RecognitionException {
        WaebricChecker.commentStatement_return retval = new WaebricChecker.commentStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal104=null;
        CommonTree STRCON105=null;
        CommonTree char_literal106=null;

        CommonTree string_literal104_tree=null;
        CommonTree STRCON105_tree=null;
        CommonTree char_literal106_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:282:17: ( 'comment' STRCON ';' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:282:19: 'comment' STRCON ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal104=(CommonTree)match(input,COMMENT,FOLLOW_COMMENT_in_commentStatement745); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal104_tree = (CommonTree)adaptor.dupNode(string_literal104);

            adaptor.addChild(root_0, string_literal104_tree);
            }
            _last = (CommonTree)input.LT(1);
            STRCON105=(CommonTree)match(input,STRCON,FOLLOW_STRCON_in_commentStatement747); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRCON105_tree = (CommonTree)adaptor.dupNode(STRCON105);

            adaptor.addChild(root_0, STRCON105_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal106=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_commentStatement749); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal106_tree = (CommonTree)adaptor.dupNode(char_literal106);

            adaptor.addChild(root_0, char_literal106_tree);
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
    // $ANTLR end "commentStatement"

    public static class echoStatement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "echoStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:283:1: echoStatement : ( 'echo' expression ';' | 'echo' embedding ';' );
    public final WaebricChecker.echoStatement_return echoStatement() throws RecognitionException {
        WaebricChecker.echoStatement_return retval = new WaebricChecker.echoStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal107=null;
        CommonTree char_literal109=null;
        CommonTree string_literal110=null;
        CommonTree char_literal112=null;
        WaebricChecker.expression_return expression108 = null;

        WaebricChecker.embedding_return embedding111 = null;


        CommonTree string_literal107_tree=null;
        CommonTree char_literal109_tree=null;
        CommonTree string_literal110_tree=null;
        CommonTree char_literal112_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:283:14: ( 'echo' expression ';' | 'echo' embedding ';' )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==ECHO) ) {
                int LA26_1 = input.LA(2);

                if ( (synpred42_WaebricChecker()) ) {
                    alt26=1;
                }
                else if ( (true) ) {
                    alt26=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:283:17: 'echo' expression ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal107=(CommonTree)match(input,ECHO,FOLLOW_ECHO_in_echoStatement757); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal107_tree = (CommonTree)adaptor.dupNode(string_literal107);

                    adaptor.addChild(root_0, string_literal107_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_echoStatement759);
                    expression108=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression108.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal109=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_echoStatement761); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal109_tree = (CommonTree)adaptor.dupNode(char_literal109);

                    adaptor.addChild(root_0, char_literal109_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:283:42: 'echo' embedding ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal110=(CommonTree)match(input,ECHO,FOLLOW_ECHO_in_echoStatement766); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal110_tree = (CommonTree)adaptor.dupNode(string_literal110);

                    adaptor.addChild(root_0, string_literal110_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_echoStatement768);
                    embedding111=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, embedding111.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal112=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_echoStatement770); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal112_tree = (CommonTree)adaptor.dupNode(char_literal112);

                    adaptor.addChild(root_0, char_literal112_tree);
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
    // $ANTLR end "echoStatement"

    public static class embedding_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "embedding"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:287:1: embedding : PRETEXT embed textTail ;
    public final WaebricChecker.embedding_return embedding() throws RecognitionException {
        WaebricChecker.embedding_return retval = new WaebricChecker.embedding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PRETEXT113=null;
        WaebricChecker.embed_return embed114 = null;

        WaebricChecker.textTail_return textTail115 = null;


        CommonTree PRETEXT113_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:287:10: ( PRETEXT embed textTail )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:287:13: PRETEXT embed textTail
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PRETEXT113=(CommonTree)match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding781); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRETEXT113_tree = (CommonTree)adaptor.dupNode(PRETEXT113);

            adaptor.addChild(root_0, PRETEXT113_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_embed_in_embedding783);
            embed114=embed();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, embed114.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_textTail_in_embedding785);
            textTail115=textTail();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, textTail115.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:288:1: embed : ( ( markup )* expression | ( markup )* markup );
    public final WaebricChecker.embed_return embed() throws RecognitionException {
        WaebricChecker.embed_return retval = new WaebricChecker.embed_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricChecker.markup_return markup116 = null;

        WaebricChecker.expression_return expression117 = null;

        WaebricChecker.markup_return markup118 = null;

        WaebricChecker.markup_return markup119 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:288:6: ( ( markup )* expression | ( markup )* markup )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==IDCON) ) {
                int LA29_1 = input.LA(2);

                if ( (synpred44_WaebricChecker()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 29, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA29_0>=MODULE && LA29_0<=STRING)||(LA29_0>=PATH && LA29_0<=65)) ) {
                alt29=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:288:10: ( markup )* expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:288:10: ( markup )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==IDCON) ) {
                            int LA27_1 = input.LA(2);

                            if ( (synpred43_WaebricChecker()) ) {
                                alt27=1;
                            }


                        }


                        switch (alt27) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed794);
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
                    	    break loop27;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_embed797);
                    expression117=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression117.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:288:31: ( markup )* markup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:288:31: ( markup )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==IDCON) ) {
                            int LA28_1 = input.LA(2);

                            if ( (synpred45_WaebricChecker()) ) {
                                alt28=1;
                            }


                        }


                        switch (alt28) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed801);
                    	    markup118=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup118.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_embed804);
                    markup119=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, markup119.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:289:1: textTail : ( POSTTEXT | MIDTEXT embed textTail );
    public final WaebricChecker.textTail_return textTail() throws RecognitionException {
        WaebricChecker.textTail_return retval = new WaebricChecker.textTail_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POSTTEXT120=null;
        CommonTree MIDTEXT121=null;
        WaebricChecker.embed_return embed122 = null;

        WaebricChecker.textTail_return textTail123 = null;


        CommonTree POSTTEXT120_tree=null;
        CommonTree MIDTEXT121_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:289:9: ( POSTTEXT | MIDTEXT embed textTail )
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:289:12: POSTTEXT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    POSTTEXT120=(CommonTree)match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail812); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    POSTTEXT120_tree = (CommonTree)adaptor.dupNode(POSTTEXT120);

                    adaptor.addChild(root_0, POSTTEXT120_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:289:23: MIDTEXT embed textTail
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    MIDTEXT121=(CommonTree)match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail816); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MIDTEXT121_tree = (CommonTree)adaptor.dupNode(MIDTEXT121);

                    adaptor.addChild(root_0, MIDTEXT121_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embed_in_textTail818);
                    embed122=embed();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, embed122.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_textTail_in_textTail820);
                    textTail123=textTail();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, textTail123.getTree());

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

    public static class cdataStatement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "cdataStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:293:1: cdataStatement : 'cdata' expression ';' ;
    public final WaebricChecker.cdataStatement_return cdataStatement() throws RecognitionException {
        WaebricChecker.cdataStatement_return retval = new WaebricChecker.cdataStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal124=null;
        CommonTree char_literal126=null;
        WaebricChecker.expression_return expression125 = null;


        CommonTree string_literal124_tree=null;
        CommonTree char_literal126_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:293:15: ( 'cdata' expression ';' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:293:18: 'cdata' expression ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal124=(CommonTree)match(input,CDATA,FOLLOW_CDATA_in_cdataStatement831); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal124_tree = (CommonTree)adaptor.dupNode(string_literal124);

            adaptor.addChild(root_0, string_literal124_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_cdataStatement833);
            expression125=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, expression125.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal126=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_cdataStatement835); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal126_tree = (CommonTree)adaptor.dupNode(char_literal126);

            adaptor.addChild(root_0, char_literal126_tree);
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
    // $ANTLR end "cdataStatement"

    public static class yieldStatement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "yieldStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:294:1: yieldStatement : 'yield;' ;
    public final WaebricChecker.yieldStatement_return yieldStatement() throws RecognitionException {
        WaebricChecker.yieldStatement_return retval = new WaebricChecker.yieldStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal127=null;

        CommonTree string_literal127_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:294:15: ( 'yield;' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:294:18: 'yield;'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal127=(CommonTree)match(input,61,FOLLOW_61_in_yieldStatement843); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal127_tree = (CommonTree)adaptor.dupNode(string_literal127);

            adaptor.addChild(root_0, string_literal127_tree);
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
    // $ANTLR end "yieldStatement"

    public static class markupStatements_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "markupStatements"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:296:1: markupStatements : ( functionCall | markupExpression | markupStatement | markupMarkup );
    public final WaebricChecker.markupStatements_return markupStatements() throws RecognitionException {
        WaebricChecker.markupStatements_return retval = new WaebricChecker.markupStatements_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricChecker.functionCall_return functionCall128 = null;

        WaebricChecker.markupExpression_return markupExpression129 = null;

        WaebricChecker.markupStatement_return markupStatement130 = null;

        WaebricChecker.markupMarkup_return markupMarkup131 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:296:17: ( functionCall | markupExpression | markupStatement | markupMarkup )
            int alt31=4;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==IDCON) ) {
                int LA31_1 = input.LA(2);

                if ( (synpred47_WaebricChecker()) ) {
                    alt31=1;
                }
                else if ( (synpred48_WaebricChecker()) ) {
                    alt31=2;
                }
                else if ( (synpred49_WaebricChecker()) ) {
                    alt31=3;
                }
                else if ( (true) ) {
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:296:19: functionCall
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_functionCall_in_markupStatements851);
                    functionCall128=functionCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, functionCall128.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:296:34: markupExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markupExpression_in_markupStatements855);
                    markupExpression129=markupExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, markupExpression129.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:296:53: markupStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markupStatement_in_markupStatements859);
                    markupStatement130=markupStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, markupStatement130.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:296:71: markupMarkup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markupMarkup_in_markupStatements863);
                    markupMarkup131=markupMarkup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, markupMarkup131.getTree());

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
    // $ANTLR end "markupStatements"

    public static class functionCall_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionCall"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:297:1: functionCall : markup ';' ;
    public final WaebricChecker.functionCall_return functionCall() throws RecognitionException {
        WaebricChecker.functionCall_return retval = new WaebricChecker.functionCall_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal133=null;
        WaebricChecker.markup_return markup132 = null;


        CommonTree char_literal133_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:297:13: ( markup ';' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:297:16: markup ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_markup_in_functionCall871);
            markup132=markup();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, markup132.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal133=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_functionCall873); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal133_tree = (CommonTree)adaptor.dupNode(char_literal133);

            adaptor.addChild(root_0, char_literal133_tree);
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
    // $ANTLR end "functionCall"

    public static class markupExpression_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "markupExpression"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:298:1: markupExpression : ( markup )+ ';' expression ';' ;
    public final WaebricChecker.markupExpression_return markupExpression() throws RecognitionException {
        WaebricChecker.markupExpression_return retval = new WaebricChecker.markupExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal135=null;
        CommonTree char_literal137=null;
        WaebricChecker.markup_return markup134 = null;

        WaebricChecker.expression_return expression136 = null;


        CommonTree char_literal135_tree=null;
        CommonTree char_literal137_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:298:17: ( ( markup )+ ';' expression ';' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:298:19: ( markup )+ ';' expression ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:298:19: ( markup )+
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
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_markup_in_markupExpression881);
            	    markup134=markup();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, markup134.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
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

            _last = (CommonTree)input.LT(1);
            char_literal135=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_markupExpression884); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal135_tree = (CommonTree)adaptor.dupNode(char_literal135);

            adaptor.addChild(root_0, char_literal135_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_markupExpression886);
            expression136=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, expression136.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal137=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_markupExpression888); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal137_tree = (CommonTree)adaptor.dupNode(char_literal137);

            adaptor.addChild(root_0, char_literal137_tree);
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
    // $ANTLR end "markupExpression"

    public static class markupStatement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "markupStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:299:1: markupStatement : ( markup )+ ';' statement ;
    public final WaebricChecker.markupStatement_return markupStatement() throws RecognitionException {
        WaebricChecker.markupStatement_return retval = new WaebricChecker.markupStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal139=null;
        WaebricChecker.markup_return markup138 = null;

        WaebricChecker.statement_return statement140 = null;


        CommonTree char_literal139_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:299:16: ( ( markup )+ ';' statement )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:299:18: ( markup )+ ';' statement
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:299:18: ( markup )+
            int cnt33=0;
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==IDCON) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_markup_in_markupStatement895);
            	    markup138=markup();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, markup138.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt33 >= 1 ) break loop33;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(33, input);
                        throw eee;
                }
                cnt33++;
            } while (true);

            _last = (CommonTree)input.LT(1);
            char_literal139=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_markupStatement898); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal139_tree = (CommonTree)adaptor.dupNode(char_literal139);

            adaptor.addChild(root_0, char_literal139_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_markupStatement900);
            statement140=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, statement140.getTree());

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
    // $ANTLR end "markupStatement"

    public static class markupMarkup_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "markupMarkup"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:300:1: markupMarkup : ( markup )+ ';' ;
    public final WaebricChecker.markupMarkup_return markupMarkup() throws RecognitionException {
        WaebricChecker.markupMarkup_return retval = new WaebricChecker.markupMarkup_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal142=null;
        WaebricChecker.markup_return markup141 = null;


        CommonTree char_literal142_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:300:13: ( ( markup )+ ';' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:300:16: ( markup )+ ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:300:16: ( markup )+
            int cnt34=0;
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==IDCON) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_markup_in_markupMarkup908);
            	    markup141=markup();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, markup141.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt34 >= 1 ) break loop34;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(34, input);
                        throw eee;
                }
                cnt34++;
            } while (true);

            _last = (CommonTree)input.LT(1);
            char_literal142=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_markupMarkup911); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal142_tree = (CommonTree)adaptor.dupNode(char_literal142);

            adaptor.addChild(root_0, char_literal142_tree);
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
    // $ANTLR end "markupMarkup"

    public static class eachStatement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "eachStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:304:1: eachStatement : 'each' '(' id= IDCON ':' expression ')' statement ;
    public final WaebricChecker.eachStatement_return eachStatement() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.eachStatement_return retval = new WaebricChecker.eachStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        CommonTree string_literal143=null;
        CommonTree char_literal144=null;
        CommonTree char_literal145=null;
        CommonTree char_literal147=null;
        WaebricChecker.expression_return expression146 = null;

        WaebricChecker.statement_return statement148 = null;


        CommonTree id_tree=null;
        CommonTree string_literal143_tree=null;
        CommonTree char_literal144_tree=null;
        CommonTree char_literal145_tree=null;
        CommonTree char_literal147_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new HashSet<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:309:4: ( 'each' '(' id= IDCON ':' expression ')' statement )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:309:7: 'each' '(' id= IDCON ':' expression ')' statement
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal143=(CommonTree)match(input,EACH,FOLLOW_EACH_in_eachStatement935); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal143_tree = (CommonTree)adaptor.dupNode(string_literal143);

            adaptor.addChild(root_0, string_literal143_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal144=(CommonTree)match(input,53,FOLLOW_53_in_eachStatement937); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal144_tree = (CommonTree)adaptor.dupNode(char_literal144);

            adaptor.addChild(root_0, char_literal144_tree);
            }
            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_eachStatement941); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (CommonTree)adaptor.dupNode(id);

            adaptor.addChild(root_0, id_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal145=(CommonTree)match(input,48,FOLLOW_48_in_eachStatement943); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal145_tree = (CommonTree)adaptor.dupNode(char_literal145);

            adaptor.addChild(root_0, char_literal145_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_eachStatement945);
            expression146=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, expression146.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal147=(CommonTree)match(input,55,FOLLOW_55_in_eachStatement947); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal147_tree = (CommonTree)adaptor.dupNode(char_literal147);

            adaptor.addChild(root_0, char_literal147_tree);
            }
            if ( state.backtracking==0 ) {
               
              				defineVariable(id); // Define variable before statement is executed
              			
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_eachStatement951);
            statement148=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, statement148.getTree());

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
            Environment_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "eachStatement"

    public static class letStatement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "letStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:313:1: letStatement : 'let' ( assignment[curr] )+ 'in' ( statement )* 'end' ;
    public final WaebricChecker.letStatement_return letStatement() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.letStatement_return retval = new WaebricChecker.letStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal149=null;
        CommonTree string_literal151=null;
        CommonTree string_literal153=null;
        WaebricChecker.assignment_return assignment150 = null;

        WaebricChecker.statement_return statement152 = null;


        CommonTree string_literal149_tree=null;
        CommonTree string_literal151_tree=null;
        CommonTree string_literal153_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new HashSet<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        		int curr = Environment_stack.size()-1;
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:319:4: ( 'let' ( assignment[curr] )+ 'in' ( statement )* 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:319:7: 'let' ( assignment[curr] )+ 'in' ( statement )* 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal149=(CommonTree)match(input,LET,FOLLOW_LET_in_letStatement973); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal149_tree = (CommonTree)adaptor.dupNode(string_literal149);

            adaptor.addChild(root_0, string_literal149_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:319:13: ( assignment[curr] )+
            int cnt35=0;
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==IDCON) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: assignment[curr]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_assignment_in_letStatement975);
            	    assignment150=assignment(curr);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, assignment150.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt35 >= 1 ) break loop35;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(35, input);
                        throw eee;
                }
                cnt35++;
            } while (true);

            _last = (CommonTree)input.LT(1);
            string_literal151=(CommonTree)match(input,IN,FOLLOW_IN_in_letStatement979); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal151_tree = (CommonTree)adaptor.dupNode(string_literal151);

            adaptor.addChild(root_0, string_literal151_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:319:36: ( statement )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==IF||(LA36_0>=EACH && LA36_0<=LET)||(LA36_0>=COMMENT && LA36_0<=CDATA)||LA36_0==IDCON||LA36_0==59||LA36_0==61) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_letStatement981);
            	    statement152=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, statement152.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            string_literal153=(CommonTree)match(input,END,FOLLOW_END_in_letStatement984); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal153_tree = (CommonTree)adaptor.dupNode(string_literal153);

            adaptor.addChild(root_0, string_literal153_tree);
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
            Environment_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "letStatement"

    public static class assignment_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignment"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:321:1: assignment[int depth] : ( varBinding | funcBinding[depth] );
    public final WaebricChecker.assignment_return assignment(int depth) throws RecognitionException {
        WaebricChecker.assignment_return retval = new WaebricChecker.assignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricChecker.varBinding_return varBinding154 = null;

        WaebricChecker.funcBinding_return funcBinding155 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:321:23: ( varBinding | funcBinding[depth] )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==IDCON) ) {
                int LA37_1 = input.LA(2);

                if ( (LA37_1==62) ) {
                    alt37=1;
                }
                else if ( (LA37_1==53) ) {
                    alt37=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:322:4: varBinding
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_varBinding_in_assignment998);
                    varBinding154=varBinding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, varBinding154.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:322:17: funcBinding[depth]
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_funcBinding_in_assignment1002);
                    funcBinding155=funcBinding(depth);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, funcBinding155.getTree());

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

    public static class varBinding_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "varBinding"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:324:1: varBinding : id= IDCON '=' expression ';' ;
    public final WaebricChecker.varBinding_return varBinding() throws RecognitionException {
        WaebricChecker.varBinding_return retval = new WaebricChecker.varBinding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        CommonTree char_literal156=null;
        CommonTree char_literal158=null;
        WaebricChecker.expression_return expression157 = null;


        CommonTree id_tree=null;
        CommonTree char_literal156_tree=null;
        CommonTree char_literal158_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:324:11: (id= IDCON '=' expression ';' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:324:14: id= IDCON '=' expression ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_varBinding1014); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (CommonTree)adaptor.dupNode(id);

            adaptor.addChild(root_0, id_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal156=(CommonTree)match(input,62,FOLLOW_62_in_varBinding1016); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal156_tree = (CommonTree)adaptor.dupNode(char_literal156);

            adaptor.addChild(root_0, char_literal156_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_varBinding1018);
            expression157=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, expression157.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal158=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_varBinding1020); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal158_tree = (CommonTree)adaptor.dupNode(char_literal158);

            adaptor.addChild(root_0, char_literal158_tree);
            }
            if ( state.backtracking==0 ) {
               
              				defineVariable(id); 
              			
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
    // $ANTLR end "varBinding"

    public static class funcBinding_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "funcBinding"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:328:1: funcBinding[int depth] : id= IDCON f= regularFormals statement ;
    public final WaebricChecker.funcBinding_return funcBinding(int depth) throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.funcBinding_return retval = new WaebricChecker.funcBinding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        WaebricChecker.regularFormals_return f = null;

        WaebricChecker.statement_return statement159 = null;


        CommonTree id_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new HashSet<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:333:4: (id= IDCON f= regularFormals statement )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:333:7: id= IDCON f= regularFormals statement
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_funcBinding1051); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (CommonTree)adaptor.dupNode(id);

            adaptor.addChild(root_0, id_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_regularFormals_in_funcBinding1055);
            f=regularFormals();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, f.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_funcBinding1057);
            statement159=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, statement159.getTree());
            if ( state.backtracking==0 ) {
               defineFunction(id, (f!=null?f.args:0), depth); 
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
            Environment_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "funcBinding"

    // $ANTLR start synpred7_WaebricChecker
    public final void synpred7_WaebricChecker_fragment() throws RecognitionException {   
        WaebricChecker.arguments_return a = null;


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:214:20: (a= arguments )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:214:20: a= arguments
        {
        pushFollow(FOLLOW_arguments_in_synpred7_WaebricChecker231);
        a=arguments();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_WaebricChecker

    // $ANTLR start synpred14_WaebricChecker
    public final void synpred14_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:227:11: ( expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:227:11: expression
        {
        pushFollow(FOLLOW_expression_in_synpred14_WaebricChecker317);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_WaebricChecker

    // $ANTLR start synpred16_WaebricChecker
    public final void synpred16_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:233:16: ( varExpression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:233:16: varExpression
        {
        pushFollow(FOLLOW_varExpression_in_synpred16_WaebricChecker350);
        varExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_WaebricChecker

    // $ANTLR start synpred17_WaebricChecker
    public final void synpred17_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:233:32: ( listExpression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:233:32: listExpression
        {
        pushFollow(FOLLOW_listExpression_in_synpred17_WaebricChecker354);
        listExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_WaebricChecker

    // $ANTLR start synpred18_WaebricChecker
    public final void synpred18_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:233:49: ( recordExpression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:233:49: recordExpression
        {
        pushFollow(FOLLOW_recordExpression_in_synpred18_WaebricChecker358);
        recordExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_WaebricChecker

    // $ANTLR start synpred19_WaebricChecker
    public final void synpred19_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:233:74: ( '+' expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:233:74: '+' expression
        {
        match(input,56,FOLLOW_56_in_synpred19_WaebricChecker368); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred19_WaebricChecker370);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_WaebricChecker

    // $ANTLR start synpred20_WaebricChecker
    public final void synpred20_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:233:91: ( '.' IDCON )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:233:91: '.' IDCON
        {
        match(input,47,FOLLOW_47_in_synpred20_WaebricChecker374); if (state.failed) return ;
        match(input,IDCON,FOLLOW_IDCON_in_synpred20_WaebricChecker376); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred20_WaebricChecker

    // $ANTLR start synpred21_WaebricChecker
    public final void synpred21_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:241:22: ( expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:241:22: expression
        {
        pushFollow(FOLLOW_expression_in_synpred21_WaebricChecker406);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_WaebricChecker

    // $ANTLR start synpred23_WaebricChecker
    public final void synpred23_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:242:23: ( keyValuePair )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:242:23: keyValuePair
        {
        pushFollow(FOLLOW_keyValuePair_in_synpred23_WaebricChecker427);
        keyValuePair();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred23_WaebricChecker

    // $ANTLR start synpred28_WaebricChecker
    public final void synpred28_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:266:13: ( ifElseStatement )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:266:13: ifElseStatement
        {
        pushFollow(FOLLOW_ifElseStatement_in_synpred28_WaebricChecker572);
        ifElseStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred28_WaebricChecker

    // $ANTLR start synpred29_WaebricChecker
    public final void synpred29_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:266:31: ( ifStatement )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:266:31: ifStatement
        {
        pushFollow(FOLLOW_ifStatement_in_synpred29_WaebricChecker576);
        ifStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred29_WaebricChecker

    // $ANTLR start synpred37_WaebricChecker
    public final void synpred37_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:274:15: ( notPredicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:274:15: notPredicate
        {
        pushFollow(FOLLOW_notPredicate_in_synpred37_WaebricChecker664);
        notPredicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred37_WaebricChecker

    // $ANTLR start synpred38_WaebricChecker
    public final void synpred38_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:274:30: ( declaredPredicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:274:30: declaredPredicate
        {
        pushFollow(FOLLOW_declaredPredicate_in_synpred38_WaebricChecker668);
        declaredPredicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred38_WaebricChecker

    // $ANTLR start synpred39_WaebricChecker
    public final void synpred39_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:274:66: ( '&&' predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:274:66: '&&' predicate
        {
        match(input,63,FOLLOW_63_in_synpred39_WaebricChecker678); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred39_WaebricChecker680);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_WaebricChecker

    // $ANTLR start synpred40_WaebricChecker
    public final void synpred40_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:274:83: ( '||' predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:274:83: '||' predicate
        {
        match(input,64,FOLLOW_64_in_synpred40_WaebricChecker684); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred40_WaebricChecker686);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred40_WaebricChecker

    // $ANTLR start synpred42_WaebricChecker
    public final void synpred42_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:283:17: ( 'echo' expression ';' )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:283:17: 'echo' expression ';'
        {
        match(input,ECHO,FOLLOW_ECHO_in_synpred42_WaebricChecker757); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred42_WaebricChecker759);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred42_WaebricChecker761); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred42_WaebricChecker

    // $ANTLR start synpred43_WaebricChecker
    public final void synpred43_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:288:10: ( markup )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:288:10: markup
        {
        pushFollow(FOLLOW_markup_in_synpred43_WaebricChecker794);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred43_WaebricChecker

    // $ANTLR start synpred44_WaebricChecker
    public final void synpred44_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:288:10: ( ( markup )* expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:288:10: ( markup )* expression
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:288:10: ( markup )*
        loop38:
        do {
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==IDCON) ) {
                int LA38_1 = input.LA(2);

                if ( (synpred43_WaebricChecker()) ) {
                    alt38=1;
                }


            }


            switch (alt38) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred44_WaebricChecker794);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop38;
            }
        } while (true);

        pushFollow(FOLLOW_expression_in_synpred44_WaebricChecker797);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred44_WaebricChecker

    // $ANTLR start synpred45_WaebricChecker
    public final void synpred45_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:288:31: ( markup )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:288:31: markup
        {
        pushFollow(FOLLOW_markup_in_synpred45_WaebricChecker801);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred45_WaebricChecker

    // $ANTLR start synpred47_WaebricChecker
    public final void synpred47_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:296:19: ( functionCall )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:296:19: functionCall
        {
        pushFollow(FOLLOW_functionCall_in_synpred47_WaebricChecker851);
        functionCall();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred47_WaebricChecker

    // $ANTLR start synpred48_WaebricChecker
    public final void synpred48_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:296:34: ( markupExpression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:296:34: markupExpression
        {
        pushFollow(FOLLOW_markupExpression_in_synpred48_WaebricChecker855);
        markupExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred48_WaebricChecker

    // $ANTLR start synpred49_WaebricChecker
    public final void synpred49_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:296:53: ( markupStatement )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:296:53: markupStatement
        {
        pushFollow(FOLLOW_markupStatement_in_synpred49_WaebricChecker859);
        markupStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred49_WaebricChecker

    // Delegated rules

    public final boolean synpred29_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_WaebricChecker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_WaebricChecker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred45_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_WaebricChecker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred39_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_WaebricChecker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_WaebricChecker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_WaebricChecker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred49_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred49_WaebricChecker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_WaebricChecker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_WaebricChecker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_WaebricChecker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred44_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_WaebricChecker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_WaebricChecker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred47_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred47_WaebricChecker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_WaebricChecker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred38_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_WaebricChecker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_WaebricChecker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_WaebricChecker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred43_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_WaebricChecker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_WaebricChecker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred40_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred40_WaebricChecker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred48_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred48_WaebricChecker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred42_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_WaebricChecker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA7 dfa7 = new DFA7(this);
    protected DFA22 dfa22 = new DFA22(this);
    static final String DFA7_eotS =
        "\14\uffff";
    static final String DFA7_eofS =
        "\1\2\13\uffff";
    static final String DFA7_minS =
        "\1\4\1\0\12\uffff";
    static final String DFA7_maxS =
        "\1\101\1\0\12\uffff";
    static final String DFA7_acceptS =
        "\2\uffff\1\2\10\uffff\1\1";
    static final String DFA7_specialS =
        "\1\uffff\1\0\12\uffff}>";
    static final String[] DFA7_transitionS = {
            "\61\2\1\1\14\2",
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

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "214:18: (a= arguments )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TreeNodeStream input = (TreeNodeStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA7_1 = input.LA(1);

                         
                        int index7_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_WaebricChecker()) ) {s = 11;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index7_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 7, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA22_eotS =
        "\14\uffff";
    static final String DFA22_eofS =
        "\14\uffff";
    static final String DFA22_minS =
        "\1\11\1\0\12\uffff";
    static final String DFA22_maxS =
        "\1\75\1\0\12\uffff";
    static final String DFA22_acceptS =
        "\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\1\1\2";
    static final String DFA22_specialS =
        "\1\uffff\1\0\12\uffff}>";
    static final String[] DFA22_transitionS = {
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

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "266:1: statement : ( ifElseStatement | ifStatement | eachStatement | letStatement | blockStatement | commentStatement | echoStatement | cdataStatement | yieldStatement | markupStatements );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TreeNodeStream input = (TreeNodeStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA22_1 = input.LA(1);

                         
                        int index22_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_WaebricChecker()) ) {s = 10;}

                        else if ( (synpred29_WaebricChecker()) ) {s = 11;}

                         
                        input.seek(index22_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 22, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_MODULE_in_module77 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_moduleId_in_module79 = new BitSet(new long[]{0x00000000000001E0L});
    public static final BitSet FOLLOW_imprt_in_module81 = new BitSet(new long[]{0x00000000000001E0L});
    public static final BitSet FOLLOW_site_in_module84 = new BitSet(new long[]{0x00000000000001C0L});
    public static final BitSet FOLLOW_function_in_module87 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_END_in_module90 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDCON_in_moduleId109 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_47_in_moduleId118 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_IDCON_in_moduleId122 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_IMPORT_in_imprt141 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_moduleId_in_imprt145 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_imprt147 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_module_in_imprt151 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SITE_in_site167 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_mappings_in_site169 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_END_in_site171 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_mapping_in_mappings181 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_mappings186 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_mapping_in_mappings188 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_48_in_mapping202 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_markup_in_mapping204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_designator_in_markup225 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_arguments_in_markup231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_designator250 = new BitSet(new long[]{0x000F800000000002L});
    public static final BitSet FOLLOW_attribute_in_designator252 = new BitSet(new long[]{0x000F800000000002L});
    public static final BitSet FOLLOW_49_in_attribute261 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_IDCON_in_attribute263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_attribute267 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_IDCON_in_attribute269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_attribute273 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_IDCON_in_attribute275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_attribute279 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_IDCON_in_attribute281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_attribute285 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_NATCON_in_attribute287 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_52_in_attribute291 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_NATCON_in_attribute293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_arguments313 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_expression_in_arguments317 = new BitSet(new long[]{0x00C0000000000000L});
    public static final BitSet FOLLOW_54_in_arguments326 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_expression_in_arguments328 = new BitSet(new long[]{0x00C0000000000000L});
    public static final BitSet FOLLOW_55_in_arguments335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varExpression_in_expression350 = new BitSet(new long[]{0x0100800000000002L});
    public static final BitSet FOLLOW_listExpression_in_expression354 = new BitSet(new long[]{0x0100800000000002L});
    public static final BitSet FOLLOW_recordExpression_in_expression358 = new BitSet(new long[]{0x0100800000000002L});
    public static final BitSet FOLLOW_56_in_expression368 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_expression_in_expression370 = new BitSet(new long[]{0x0100800000000002L});
    public static final BitSet FOLLOW_47_in_expression374 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_IDCON_in_expression376 = new BitSet(new long[]{0x0100800000000002L});
    public static final BitSet FOLLOW_IDCON_in_varExpression390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_listExpression404 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_expression_in_listExpression406 = new BitSet(new long[]{0x0440000000000000L});
    public static final BitSet FOLLOW_54_in_listExpression411 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_expression_in_listExpression413 = new BitSet(new long[]{0x0440000000000000L});
    public static final BitSet FOLLOW_58_in_listExpression418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_recordExpression425 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_keyValuePair_in_recordExpression427 = new BitSet(new long[]{0x1040000000000000L});
    public static final BitSet FOLLOW_54_in_recordExpression432 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_keyValuePair_in_recordExpression434 = new BitSet(new long[]{0x1040000000000000L});
    public static final BitSet FOLLOW_60_in_recordExpression439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_keyValuePair449 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_expression_in_keyValuePair451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEF_in_function477 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_function481 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_formals_in_function485 = new BitSet(new long[]{0x280000000021DB00L});
    public static final BitSet FOLLOW_statement_in_function487 = new BitSet(new long[]{0x280000000021DB00L});
    public static final BitSet FOLLOW_END_in_function490 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_regularFormals_in_formals515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_emptyFormals_in_formals521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_regularFormals539 = new BitSet(new long[]{0x0080000000200000L});
    public static final BitSet FOLLOW_IDCON_in_regularFormals545 = new BitSet(new long[]{0x0080000000200000L});
    public static final BitSet FOLLOW_55_in_regularFormals552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifElseStatement_in_statement572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statement576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_eachStatement_in_statement580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_letStatement_in_statement584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blockStatement_in_statement588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_commentStatement_in_statement596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_echoStatement_in_statement600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cdataStatement_in_statement604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_yieldStatement_in_statement608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markupStatements_in_statement612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifElseStatement620 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ifElseStatement622 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_predicate_in_ifElseStatement624 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_ifElseStatement626 = new BitSet(new long[]{0x280000000021DA00L});
    public static final BitSet FOLLOW_statement_in_ifElseStatement628 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ELSE_in_ifElseStatement630 = new BitSet(new long[]{0x280000000021DA00L});
    public static final BitSet FOLLOW_statement_in_ifElseStatement632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifStatement643 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ifStatement645 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_predicate_in_ifStatement647 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_ifStatement649 = new BitSet(new long[]{0x280000000021DA00L});
    public static final BitSet FOLLOW_statement_in_ifStatement651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_notPredicate_in_predicate664 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_declaredPredicate_in_predicate668 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_isPredicate_in_predicate672 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_63_in_predicate678 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_predicate_in_predicate680 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_predicate684 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_predicate_in_predicate686 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_65_in_notPredicate698 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_predicate_in_notPredicate700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_declaredPredicate708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_isPredicate716 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_isPredicate718 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_59_in_blockStatement733 = new BitSet(new long[]{0x380000000021DA00L});
    public static final BitSet FOLLOW_statement_in_blockStatement735 = new BitSet(new long[]{0x380000000021DA00L});
    public static final BitSet FOLLOW_60_in_blockStatement738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMENT_in_commentStatement745 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_STRCON_in_commentStatement747 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_commentStatement749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ECHO_in_echoStatement757 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_expression_in_echoStatement759 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_echoStatement761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ECHO_in_echoStatement766 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_embedding_in_echoStatement768 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_echoStatement770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding781 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_embed_in_embedding783 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_textTail_in_embedding785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed794 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_expression_in_embed797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed801 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_markup_in_embed804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail816 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_embed_in_textTail818 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_textTail_in_textTail820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CDATA_in_cdataStatement831 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_expression_in_cdataStatement833 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_cdataStatement835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_yieldStatement843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCall_in_markupStatements851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markupExpression_in_markupStatements855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markupStatement_in_markupStatements859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markupMarkup_in_markupStatements863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_functionCall871 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_functionCall873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_markupExpression881 = new BitSet(new long[]{0x0000000040200000L});
    public static final BitSet FOLLOW_SEMICOLON_in_markupExpression884 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_expression_in_markupExpression886 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_markupExpression888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_markupStatement895 = new BitSet(new long[]{0x0000000040200000L});
    public static final BitSet FOLLOW_SEMICOLON_in_markupStatement898 = new BitSet(new long[]{0x280000000021DA00L});
    public static final BitSet FOLLOW_statement_in_markupStatement900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_markupMarkup908 = new BitSet(new long[]{0x0000000040200000L});
    public static final BitSet FOLLOW_SEMICOLON_in_markupMarkup911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EACH_in_eachStatement935 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_eachStatement937 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_IDCON_in_eachStatement941 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_eachStatement943 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_expression_in_eachStatement945 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_eachStatement947 = new BitSet(new long[]{0x280000000021DA00L});
    public static final BitSet FOLLOW_statement_in_eachStatement951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LET_in_letStatement973 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_assignment_in_letStatement975 = new BitSet(new long[]{0x0000000000202000L});
    public static final BitSet FOLLOW_IN_in_letStatement979 = new BitSet(new long[]{0x280000000021DB00L});
    public static final BitSet FOLLOW_statement_in_letStatement981 = new BitSet(new long[]{0x280000000021DB00L});
    public static final BitSet FOLLOW_END_in_letStatement984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varBinding_in_assignment998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funcBinding_in_assignment1002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_varBinding1014 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_varBinding1016 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_expression_in_varBinding1018 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_varBinding1020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_funcBinding1051 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_regularFormals_in_funcBinding1055 = new BitSet(new long[]{0x280000000021DA00L});
    public static final BitSet FOLLOW_statement_in_funcBinding1057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arguments_in_synpred7_WaebricChecker231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred14_WaebricChecker317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varExpression_in_synpred16_WaebricChecker350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listExpression_in_synpred17_WaebricChecker354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_recordExpression_in_synpred18_WaebricChecker358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred19_WaebricChecker368 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_expression_in_synpred19_WaebricChecker370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_synpred20_WaebricChecker374 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_IDCON_in_synpred20_WaebricChecker376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred21_WaebricChecker406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_keyValuePair_in_synpred23_WaebricChecker427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifElseStatement_in_synpred28_WaebricChecker572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_synpred29_WaebricChecker576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_notPredicate_in_synpred37_WaebricChecker664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaredPredicate_in_synpred38_WaebricChecker668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_synpred39_WaebricChecker678 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_predicate_in_synpred39_WaebricChecker680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_synpred40_WaebricChecker684 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_predicate_in_synpred40_WaebricChecker686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ECHO_in_synpred42_WaebricChecker757 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_expression_in_synpred42_WaebricChecker759 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred42_WaebricChecker761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred43_WaebricChecker794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred44_WaebricChecker794 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_expression_in_synpred44_WaebricChecker797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred45_WaebricChecker801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCall_in_synpred47_WaebricChecker851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markupExpression_in_synpred48_WaebricChecker855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markupStatement_in_synpred49_WaebricChecker859 = new BitSet(new long[]{0x0000000000000002L});

}