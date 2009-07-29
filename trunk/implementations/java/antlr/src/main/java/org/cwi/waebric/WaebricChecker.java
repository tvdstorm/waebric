// $ANTLR 3.1.2 /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g 2009-07-29 09:47:21

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDCON", "PATH", "NATCON", "TEXT", "SYMBOLCON", "STRCON", "PRETEXT", "POSTTEXT", "MIDTEXT", "COMMENT", "SITE", "END", "SEMICOLON", "LETTER", "DIGIT", "HEXADECIMAL", "PATHELEMENT", "FILEEXT", "STRCHAR", "ESCLAYOUT", "DECIMAL", "TEXTCHAR", "ESCQUOTE", "AMP", "CHARREF", "ENTREF", "SYMBOLCHAR", "COMMENTS", "LAYOUT", "'module'", "'.'", "'import'", "':'", "'#'", "'$'", "'@'", "'%'", "'('", "','", "')'", "'['", "']'", "'{'", "'}'", "'+'", "'def'", "'if'", "'else'", "'each'", "'let'", "'in'", "'echo'", "'cdata'", "'yield;'", "'='", "'!'", "'&&'", "'||'", "'list'", "'record'", "'string'"
    };
    public static final int ESCLAYOUT=23;
    public static final int T__42=42;
    public static final int END=15;
    public static final int T__57=57;
    public static final int T__51=51;
    public static final int FILEEXT=21;
    public static final int T__47=47;
    public static final int T__50=50;
    public static final int STRCHAR=22;
    public static final int SYMBOLCON=8;
    public static final int COMMENTS=31;
    public static final int IDCON=4;
    public static final int DECIMAL=24;
    public static final int HEXADECIMAL=19;
    public static final int T__39=39;
    public static final int TEXTCHAR=25;
    public static final int T__46=46;
    public static final int T__52=52;
    public static final int T__62=62;
    public static final int STRCON=9;
    public static final int T__49=49;
    public static final int AMP=27;
    public static final int T__61=61;
    public static final int POSTTEXT=11;
    public static final int T__59=59;
    public static final int DIGIT=18;
    public static final int T__48=48;
    public static final int T__54=54;
    public static final int T__34=34;
    public static final int LAYOUT=32;
    public static final int ESCQUOTE=26;
    public static final int PATHELEMENT=20;
    public static final int T__56=56;
    public static final int ENTREF=29;
    public static final int LETTER=17;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int SITE=14;
    public static final int T__58=58;
    public static final int T__64=64;
    public static final int T__44=44;
    public static final int SYMBOLCHAR=30;
    public static final int COMMENT=13;
    public static final int T__33=33;
    public static final int T__55=55;
    public static final int T__45=45;
    public static final int CHARREF=28;
    public static final int MIDTEXT=12;
    public static final int T__63=63;
    public static final int PRETEXT=10;
    public static final int T__43=43;
    public static final int SEMICOLON=16;
    public static final int T__40=40;
    public static final int EOF=-1;
    public static final int T__53=53;
    public static final int TEXT=7;
    public static final int T__38=38;
    public static final int NATCON=6;
    public static final int T__37=37;
    public static final int T__60=60;
    public static final int T__41=41;
    public static final int PATH=5;

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
            		super("Module identifier \"" + id.getText() + "\" at line " + id.getLine() 
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
            		super("Undefined variable \"" + id.getText() + "\" at line " + id.getLine() 
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
            		super("Function call \"" + id.getText() + "\" at line " + id.getLine() 
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
    			super("Arity mismatch at function call \"" + id.getText() 
    					+ "\" positioned on line " + id.getLine() 
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
    			super("Duplicate definition of function \"" + id.getText() 
    					+ "\" at line " + id.getLine() 
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
            string_literal1=(CommonTree)match(input,33,FOLLOW_33_in_module77); if (state.failed) return retval;
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

                if ( (LA1_0==35) ) {
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

                if ( (LA3_0==49) ) {
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

                if ( (LA4_0==34) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:193:6: '.' id= IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal7=(CommonTree)match(input,34,FOLLOW_34_in_moduleId118); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:202:1: imprt : 'import' id= moduleId ';' module ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:202:6: ( 'import' id= moduleId ';' module )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:202:10: 'import' id= moduleId ';' module
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal8=(CommonTree)match(input,35,FOLLOW_35_in_imprt139); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal8_tree = (CommonTree)adaptor.dupNode(string_literal8);

            adaptor.addChild(root_0, string_literal8_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_moduleId_in_imprt143);
            id=moduleId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, id.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal9=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_imprt145); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal9_tree = (CommonTree)adaptor.dupNode(char_literal9);

            root_0 = (CommonTree)adaptor.becomeRoot(char_literal9_tree, root_0);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_module_in_imprt148);
            module10=module();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, module10.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:206:1: site : 'site' mappings 'end' ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:206:5: ( 'site' mappings 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:206:9: 'site' mappings 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal11=(CommonTree)match(input,SITE,FOLLOW_SITE_in_site160); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal11_tree = (CommonTree)adaptor.dupNode(string_literal11);

            adaptor.addChild(root_0, string_literal11_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_mappings_in_site162);
            mappings12=mappings();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, mappings12.getTree());
            _last = (CommonTree)input.LT(1);
            string_literal13=(CommonTree)match(input,END,FOLLOW_END_in_site164); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal13_tree = (CommonTree)adaptor.dupNode(string_literal13);

            adaptor.addChild(root_0, string_literal13_tree);
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

                    if ( (LA5_1==36) ) {
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

                    if ( (LA5_2==DOWN||LA5_2==36) ) {
                        alt5=1;
                    }
                    }
                    break;
                case IDCON:
                case PATH:
                case NATCON:
                case TEXT:
                case SYMBOLCON:
                case STRCON:
                case PRETEXT:
                case POSTTEXT:
                case MIDTEXT:
                case COMMENT:
                case SITE:
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
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
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
                    pushFollow(FOLLOW_mapping_in_mappings172);
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
            	    char_literal15=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_mappings177); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal15_tree = (CommonTree)adaptor.dupNode(char_literal15);

            	    adaptor.addChild(root_0, char_literal15_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_mapping_in_mappings179);
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
            char_literal18=(CommonTree)match(input,36,FOLLOW_36_in_mapping193); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal18_tree = (CommonTree)adaptor.dupNode(char_literal18);

            adaptor.addChild(root_0, char_literal18_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_markup_in_mapping195);
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
            pushFollow(FOLLOW_designator_in_markup216);
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
                    pushFollow(FOLLOW_arguments_in_markup222);
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
            IDCON20=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_designator241); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON20_tree = (CommonTree)adaptor.dupNode(IDCON20);

            adaptor.addChild(root_0, IDCON20_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:223:20: ( attribute )*
            loop8:
            do {
                int alt8=2;
                switch ( input.LA(1) ) {
                case 37:
                    {
                    int LA8_2 = input.LA(2);

                    if ( (LA8_2==IDCON) ) {
                        alt8=1;
                    }


                    }
                    break;
                case 34:
                    {
                    int LA8_3 = input.LA(2);

                    if ( (LA8_3==IDCON) ) {
                        alt8=1;
                    }


                    }
                    break;
                case 38:
                    {
                    int LA8_4 = input.LA(2);

                    if ( (LA8_4==IDCON) ) {
                        alt8=1;
                    }


                    }
                    break;
                case 36:
                    {
                    int LA8_5 = input.LA(2);

                    if ( (LA8_5==IDCON) ) {
                        alt8=1;
                    }


                    }
                    break;
                case 39:
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
            	    pushFollow(FOLLOW_attribute_in_designator243);
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
            case 37:
                {
                alt10=1;
                }
                break;
            case 34:
                {
                alt10=2;
                }
                break;
            case 38:
                {
                alt10=3;
                }
                break;
            case 36:
                {
                alt10=4;
                }
                break;
            case 39:
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
                    char_literal22=(CommonTree)match(input,37,FOLLOW_37_in_attribute252); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal22_tree = (CommonTree)adaptor.dupNode(char_literal22);

                    adaptor.addChild(root_0, char_literal22_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON23=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute254); if (state.failed) return retval;
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
                    char_literal24=(CommonTree)match(input,34,FOLLOW_34_in_attribute258); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal24_tree = (CommonTree)adaptor.dupNode(char_literal24);

                    adaptor.addChild(root_0, char_literal24_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON25=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute260); if (state.failed) return retval;
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
                    char_literal26=(CommonTree)match(input,38,FOLLOW_38_in_attribute264); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal26_tree = (CommonTree)adaptor.dupNode(char_literal26);

                    adaptor.addChild(root_0, char_literal26_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON27=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute266); if (state.failed) return retval;
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
                    char_literal28=(CommonTree)match(input,36,FOLLOW_36_in_attribute270); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal28_tree = (CommonTree)adaptor.dupNode(char_literal28);

                    adaptor.addChild(root_0, char_literal28_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON29=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute272); if (state.failed) return retval;
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
                    char_literal30=(CommonTree)match(input,39,FOLLOW_39_in_attribute276); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal30_tree = (CommonTree)adaptor.dupNode(char_literal30);

                    adaptor.addChild(root_0, char_literal30_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    NATCON31=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_attribute278); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON31_tree = (CommonTree)adaptor.dupNode(NATCON31);

                    adaptor.addChild(root_0, NATCON31_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:224:72: ( '%' NATCON )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==40) ) {
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
                            char_literal32=(CommonTree)match(input,40,FOLLOW_40_in_attribute282); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal32_tree = (CommonTree)adaptor.dupNode(char_literal32);

                            adaptor.addChild(root_0, char_literal32_tree);
                            }
                            _last = (CommonTree)input.LT(1);
                            NATCON33=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_attribute284); if (state.failed) return retval;
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
            char_literal34=(CommonTree)match(input,41,FOLLOW_41_in_arguments302); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal34_tree = (CommonTree)adaptor.dupNode(char_literal34);

            adaptor.addChild(root_0, char_literal34_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:227:9: ( expression )?
            int alt11=2;
            switch ( input.LA(1) ) {
                case IDCON:
                case PATH:
                case NATCON:
                case TEXT:
                case SYMBOLCON:
                case STRCON:
                case PRETEXT:
                case POSTTEXT:
                case MIDTEXT:
                case COMMENT:
                case SITE:
                case END:
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
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 44:
                case 45:
                case 46:
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
                    {
                    alt11=1;
                    }
                    break;
                case 42:
                    {
                    int LA11_4 = input.LA(2);

                    if ( (synpred14_WaebricChecker()) ) {
                        alt11=1;
                    }
                    }
                    break;
                case 43:
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
                    pushFollow(FOLLOW_expression_in_arguments306);
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

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:228:4: ( ',' expression )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==42) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:228:6: ',' expression
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal36=(CommonTree)match(input,42,FOLLOW_42_in_arguments319); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal36_tree = (CommonTree)adaptor.dupNode(char_literal36);

            	    adaptor.addChild(root_0, char_literal36_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expression_in_arguments321);
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
            char_literal38=(CommonTree)match(input,43,FOLLOW_43_in_arguments328); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:234:1: expression : ( varExpression | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' | . ) ( '+' expression | '.' IDCON )* ;
    public final WaebricChecker.expression_return expression() throws RecognitionException {
        WaebricChecker.expression_return retval = new WaebricChecker.expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal40=null;
        CommonTree char_literal42=null;
        CommonTree char_literal44=null;
        CommonTree char_literal45=null;
        CommonTree char_literal47=null;
        CommonTree char_literal49=null;
        CommonTree wildcard50=null;
        CommonTree char_literal51=null;
        CommonTree char_literal53=null;
        CommonTree IDCON54=null;
        WaebricChecker.varExpression_return varExpression39 = null;

        WaebricChecker.expression_return expression41 = null;

        WaebricChecker.expression_return expression43 = null;

        WaebricChecker.keyValuePair_return keyValuePair46 = null;

        WaebricChecker.keyValuePair_return keyValuePair48 = null;

        WaebricChecker.expression_return expression52 = null;


        CommonTree char_literal40_tree=null;
        CommonTree char_literal42_tree=null;
        CommonTree char_literal44_tree=null;
        CommonTree char_literal45_tree=null;
        CommonTree char_literal47_tree=null;
        CommonTree char_literal49_tree=null;
        CommonTree wildcard50_tree=null;
        CommonTree char_literal51_tree=null;
        CommonTree char_literal53_tree=null;
        CommonTree IDCON54_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:234:11: ( ( varExpression | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' | . ) ( '+' expression | '.' IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:234:14: ( varExpression | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' | . ) ( '+' expression | '.' IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:234:14: ( varExpression | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' | . )
            int alt17=4;
            switch ( input.LA(1) ) {
            case IDCON:
                {
                int LA17_1 = input.LA(2);

                if ( (synpred16_WaebricChecker()) ) {
                    alt17=1;
                }
                else if ( (true) ) {
                    alt17=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;
                }
                }
                break;
            case 44:
                {
                int LA17_2 = input.LA(2);

                if ( (synpred19_WaebricChecker()) ) {
                    alt17=2;
                }
                else if ( (true) ) {
                    alt17=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 2, input);

                    throw nvae;
                }
                }
                break;
            case 46:
                {
                int LA17_3 = input.LA(2);

                if ( (synpred22_WaebricChecker()) ) {
                    alt17=3;
                }
                else if ( (true) ) {
                    alt17=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 3, input);

                    throw nvae;
                }
                }
                break;
            case PATH:
            case NATCON:
            case TEXT:
            case SYMBOLCON:
            case STRCON:
            case PRETEXT:
            case POSTTEXT:
            case MIDTEXT:
            case COMMENT:
            case SITE:
            case END:
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
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 45:
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
                {
                alt17=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:234:16: varExpression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_varExpression_in_expression343);
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:235:7: '[' ( expression )? ( ',' expression )* ']'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal40=(CommonTree)match(input,44,FOLLOW_44_in_expression352); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal40_tree = (CommonTree)adaptor.dupNode(char_literal40);

                    adaptor.addChild(root_0, char_literal40_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:235:11: ( expression )?
                    int alt13=2;
                    switch ( input.LA(1) ) {
                        case IDCON:
                        case PATH:
                        case NATCON:
                        case TEXT:
                        case SYMBOLCON:
                        case STRCON:
                        case PRETEXT:
                        case POSTTEXT:
                        case MIDTEXT:
                        case COMMENT:
                        case SITE:
                        case END:
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
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 43:
                        case 44:
                        case 46:
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
                            {
                            alt13=1;
                            }
                            break;
                        case 42:
                            {
                            int LA13_4 = input.LA(2);

                            if ( (synpred17_WaebricChecker()) ) {
                                alt13=1;
                            }
                            }
                            break;
                        case 45:
                            {
                            int LA13_5 = input.LA(2);

                            if ( (synpred17_WaebricChecker()) ) {
                                alt13=1;
                            }
                            }
                            break;
                    }

                    switch (alt13) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: expression
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_expression_in_expression354);
                            expression41=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, expression41.getTree());

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:235:23: ( ',' expression )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==42) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:235:25: ',' expression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal42=(CommonTree)match(input,42,FOLLOW_42_in_expression359); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal42_tree = (CommonTree)adaptor.dupNode(char_literal42);

                    	    adaptor.addChild(root_0, char_literal42_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_expression_in_expression361);
                    	    expression43=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, expression43.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal44=(CommonTree)match(input,45,FOLLOW_45_in_expression366); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal44_tree = (CommonTree)adaptor.dupNode(char_literal44);

                    adaptor.addChild(root_0, char_literal44_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:236:7: '{' ( keyValuePair )? ( ',' keyValuePair )* '}'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal45=(CommonTree)match(input,46,FOLLOW_46_in_expression375); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal45_tree = (CommonTree)adaptor.dupNode(char_literal45);

                    adaptor.addChild(root_0, char_literal45_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:236:11: ( keyValuePair )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==IDCON) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: keyValuePair
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_keyValuePair_in_expression377);
                            keyValuePair46=keyValuePair();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, keyValuePair46.getTree());

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:236:25: ( ',' keyValuePair )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==42) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:236:27: ',' keyValuePair
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal47=(CommonTree)match(input,42,FOLLOW_42_in_expression382); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal47_tree = (CommonTree)adaptor.dupNode(char_literal47);

                    	    adaptor.addChild(root_0, char_literal47_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_keyValuePair_in_expression384);
                    	    keyValuePair48=keyValuePair();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, keyValuePair48.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal49=(CommonTree)match(input,47,FOLLOW_47_in_expression389); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal49_tree = (CommonTree)adaptor.dupNode(char_literal49);

                    adaptor.addChild(root_0, char_literal49_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:237:7: .
                    {
                    _last = (CommonTree)input.LT(1);
                    wildcard50=(CommonTree)input.LT(1);
                    matchAny(input); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    wildcard50_tree = (CommonTree)adaptor.dupTree(wildcard50);
                    adaptor.addChild(root_0, wildcard50_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:238:6: ( '+' expression | '.' IDCON )*
            loop18:
            do {
                int alt18=3;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==48) ) {
                    int LA18_2 = input.LA(2);

                    if ( (synpred23_WaebricChecker()) ) {
                        alt18=1;
                    }


                }
                else if ( (LA18_0==34) ) {
                    int LA18_3 = input.LA(2);

                    if ( (synpred24_WaebricChecker()) ) {
                        alt18=2;
                    }


                }


                switch (alt18) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:238:8: '+' expression
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal51=(CommonTree)match(input,48,FOLLOW_48_in_expression408); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal51_tree = (CommonTree)adaptor.dupNode(char_literal51);

            	    adaptor.addChild(root_0, char_literal51_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expression_in_expression410);
            	    expression52=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, expression52.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:238:25: '.' IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal53=(CommonTree)match(input,34,FOLLOW_34_in_expression414); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal53_tree = (CommonTree)adaptor.dupNode(char_literal53);

            	    adaptor.addChild(root_0, char_literal53_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    IDCON54=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression416); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDCON54_tree = (CommonTree)adaptor.dupNode(IDCON54);

            	    adaptor.addChild(root_0, IDCON54_tree);
            	    }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop18;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:240:1: varExpression : id= IDCON ;
    public final WaebricChecker.varExpression_return varExpression() throws RecognitionException {
        WaebricChecker.varExpression_return retval = new WaebricChecker.varExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;

        CommonTree id_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:240:14: (id= IDCON )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:240:17: id= IDCON
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_varExpression430); if (state.failed) return retval;
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

    public static class keyValuePair_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "keyValuePair"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:246:1: keyValuePair : IDCON ':' expression ;
    public final WaebricChecker.keyValuePair_return keyValuePair() throws RecognitionException {
        WaebricChecker.keyValuePair_return retval = new WaebricChecker.keyValuePair_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON55=null;
        CommonTree char_literal56=null;
        WaebricChecker.expression_return expression57 = null;


        CommonTree IDCON55_tree=null;
        CommonTree char_literal56_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:246:13: ( IDCON ':' expression )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:246:16: IDCON ':' expression
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON55=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_keyValuePair444); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON55_tree = (CommonTree)adaptor.dupNode(IDCON55);

            adaptor.addChild(root_0, IDCON55_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal56=(CommonTree)match(input,36,FOLLOW_36_in_keyValuePair446); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal56_tree = (CommonTree)adaptor.dupNode(char_literal56);

            adaptor.addChild(root_0, char_literal56_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_keyValuePair448);
            expression57=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, expression57.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:250:1: function : 'def' id= IDCON f= formals ( statement )* 'end' ;
    public final WaebricChecker.function_return function() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.function_return retval = new WaebricChecker.function_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        CommonTree string_literal58=null;
        CommonTree string_literal60=null;
        WaebricChecker.formals_return f = null;

        WaebricChecker.statement_return statement59 = null;


        CommonTree id_tree=null;
        CommonTree string_literal58_tree=null;
        CommonTree string_literal60_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new HashSet<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:255:4: ( 'def' id= IDCON f= formals ( statement )* 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:255:7: 'def' id= IDCON f= formals ( statement )* 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal58=(CommonTree)match(input,49,FOLLOW_49_in_function472); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal58_tree = (CommonTree)adaptor.dupNode(string_literal58);

            adaptor.addChild(root_0, string_literal58_tree);
            }
            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_function476); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (CommonTree)adaptor.dupNode(id);

            adaptor.addChild(root_0, id_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_formals_in_function480);
            f=formals();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, f.getTree());
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:255:32: ( statement )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==IDCON||LA19_0==COMMENT||LA19_0==46||LA19_0==50||(LA19_0>=52 && LA19_0<=53)||(LA19_0>=55 && LA19_0<=57)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_function482);
            	    statement59=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, statement59.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            string_literal60=(CommonTree)match(input,END,FOLLOW_END_in_function485); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal60_tree = (CommonTree)adaptor.dupNode(string_literal60);

            adaptor.addChild(root_0, string_literal60_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:259:1: formals returns [int args = 0] : (r= regularFormals | emptyFormals );
    public final WaebricChecker.formals_return formals() throws RecognitionException {
        WaebricChecker.formals_return retval = new WaebricChecker.formals_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricChecker.regularFormals_return r = null;

        WaebricChecker.emptyFormals_return emptyFormals61 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:260:2: (r= regularFormals | emptyFormals )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==41) ) {
                alt20=1;
            }
            else if ( (LA20_0==IDCON||LA20_0==COMMENT||LA20_0==END||LA20_0==46||LA20_0==50||(LA20_0>=52 && LA20_0<=53)||(LA20_0>=55 && LA20_0<=57)) ) {
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:260:5: r= regularFormals
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_regularFormals_in_formals508);
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:260:45: emptyFormals
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_emptyFormals_in_formals514);
                    emptyFormals61=emptyFormals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, emptyFormals61.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:262:1: regularFormals returns [int args = 0] : '(' (id= IDCON )* ')' ;
    public final WaebricChecker.regularFormals_return regularFormals() throws RecognitionException {
        WaebricChecker.regularFormals_return retval = new WaebricChecker.regularFormals_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        CommonTree char_literal62=null;
        CommonTree char_literal63=null;

        CommonTree id_tree=null;
        CommonTree char_literal62_tree=null;
        CommonTree char_literal63_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:263:2: ( '(' (id= IDCON )* ')' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:263:5: '(' (id= IDCON )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            char_literal62=(CommonTree)match(input,41,FOLLOW_41_in_regularFormals532); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal62_tree = (CommonTree)adaptor.dupNode(char_literal62);

            adaptor.addChild(root_0, char_literal62_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:263:9: (id= IDCON )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==IDCON) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:263:11: id= IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_regularFormals538); if (state.failed) return retval;
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
            char_literal63=(CommonTree)match(input,43,FOLLOW_43_in_regularFormals545); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal63_tree = (CommonTree)adaptor.dupNode(char_literal63);

            adaptor.addChild(root_0, char_literal63_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:265:1: emptyFormals : ;
    public final WaebricChecker.emptyFormals_return emptyFormals() throws RecognitionException {
        WaebricChecker.emptyFormals_return retval = new WaebricChecker.emptyFormals_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:265:13: ()
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:265:41: 
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:269:1: statement : ( 'if' '(' predicate ')' statement 'else' statement | 'if' '(' predicate ')' statement | eachStatement | letStatement | '{' ( statement )* '}' | 'comment' STRCON ';' | 'echo' expression ';' | 'echo' embedding ';' | 'cdata' expression ';' | 'yield;' | markup ';' | ( markup )+ ';' expression ';' | ( markup )+ ';' statement | ( markup )+ embedding ';' | ( markup )+ ';' );
    public final WaebricChecker.statement_return statement() throws RecognitionException {
        WaebricChecker.statement_return retval = new WaebricChecker.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal64=null;
        CommonTree char_literal65=null;
        CommonTree char_literal67=null;
        CommonTree string_literal69=null;
        CommonTree string_literal71=null;
        CommonTree char_literal72=null;
        CommonTree char_literal74=null;
        CommonTree char_literal78=null;
        CommonTree char_literal80=null;
        CommonTree string_literal81=null;
        CommonTree STRCON82=null;
        CommonTree char_literal83=null;
        CommonTree string_literal84=null;
        CommonTree char_literal86=null;
        CommonTree string_literal87=null;
        CommonTree char_literal89=null;
        CommonTree string_literal90=null;
        CommonTree char_literal92=null;
        CommonTree string_literal93=null;
        CommonTree char_literal95=null;
        CommonTree char_literal97=null;
        CommonTree char_literal99=null;
        CommonTree char_literal101=null;
        CommonTree char_literal105=null;
        CommonTree char_literal107=null;
        WaebricChecker.predicate_return predicate66 = null;

        WaebricChecker.statement_return statement68 = null;

        WaebricChecker.statement_return statement70 = null;

        WaebricChecker.predicate_return predicate73 = null;

        WaebricChecker.statement_return statement75 = null;

        WaebricChecker.eachStatement_return eachStatement76 = null;

        WaebricChecker.letStatement_return letStatement77 = null;

        WaebricChecker.statement_return statement79 = null;

        WaebricChecker.expression_return expression85 = null;

        WaebricChecker.embedding_return embedding88 = null;

        WaebricChecker.expression_return expression91 = null;

        WaebricChecker.markup_return markup94 = null;

        WaebricChecker.markup_return markup96 = null;

        WaebricChecker.expression_return expression98 = null;

        WaebricChecker.markup_return markup100 = null;

        WaebricChecker.statement_return statement102 = null;

        WaebricChecker.markup_return markup103 = null;

        WaebricChecker.embedding_return embedding104 = null;

        WaebricChecker.markup_return markup106 = null;


        CommonTree string_literal64_tree=null;
        CommonTree char_literal65_tree=null;
        CommonTree char_literal67_tree=null;
        CommonTree string_literal69_tree=null;
        CommonTree string_literal71_tree=null;
        CommonTree char_literal72_tree=null;
        CommonTree char_literal74_tree=null;
        CommonTree char_literal78_tree=null;
        CommonTree char_literal80_tree=null;
        CommonTree string_literal81_tree=null;
        CommonTree STRCON82_tree=null;
        CommonTree char_literal83_tree=null;
        CommonTree string_literal84_tree=null;
        CommonTree char_literal86_tree=null;
        CommonTree string_literal87_tree=null;
        CommonTree char_literal89_tree=null;
        CommonTree string_literal90_tree=null;
        CommonTree char_literal92_tree=null;
        CommonTree string_literal93_tree=null;
        CommonTree char_literal95_tree=null;
        CommonTree char_literal97_tree=null;
        CommonTree char_literal99_tree=null;
        CommonTree char_literal101_tree=null;
        CommonTree char_literal105_tree=null;
        CommonTree char_literal107_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:269:10: ( 'if' '(' predicate ')' statement 'else' statement | 'if' '(' predicate ')' statement | eachStatement | letStatement | '{' ( statement )* '}' | 'comment' STRCON ';' | 'echo' expression ';' | 'echo' embedding ';' | 'cdata' expression ';' | 'yield;' | markup ';' | ( markup )+ ';' expression ';' | ( markup )+ ';' statement | ( markup )+ embedding ';' | ( markup )+ ';' )
            int alt27=15;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:269:13: 'if' '(' predicate ')' statement 'else' statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal64=(CommonTree)match(input,50,FOLLOW_50_in_statement565); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal64_tree = (CommonTree)adaptor.dupNode(string_literal64);

                    adaptor.addChild(root_0, string_literal64_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal65=(CommonTree)match(input,41,FOLLOW_41_in_statement567); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal65_tree = (CommonTree)adaptor.dupNode(char_literal65);

                    adaptor.addChild(root_0, char_literal65_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_statement569);
                    predicate66=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, predicate66.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal67=(CommonTree)match(input,43,FOLLOW_43_in_statement571); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal67_tree = (CommonTree)adaptor.dupNode(char_literal67);

                    adaptor.addChild(root_0, char_literal67_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement573);
                    statement68=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, statement68.getTree());
                    _last = (CommonTree)input.LT(1);
                    string_literal69=(CommonTree)match(input,51,FOLLOW_51_in_statement575); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal69_tree = (CommonTree)adaptor.dupNode(string_literal69);

                    adaptor.addChild(root_0, string_literal69_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement577);
                    statement70=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, statement70.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:270:6: 'if' '(' predicate ')' statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal71=(CommonTree)match(input,50,FOLLOW_50_in_statement584); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal71_tree = (CommonTree)adaptor.dupNode(string_literal71);

                    adaptor.addChild(root_0, string_literal71_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal72=(CommonTree)match(input,41,FOLLOW_41_in_statement586); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal72_tree = (CommonTree)adaptor.dupNode(char_literal72);

                    adaptor.addChild(root_0, char_literal72_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_statement588);
                    predicate73=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, predicate73.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal74=(CommonTree)match(input,43,FOLLOW_43_in_statement590); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal74_tree = (CommonTree)adaptor.dupNode(char_literal74);

                    adaptor.addChild(root_0, char_literal74_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement592);
                    statement75=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, statement75.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:271:6: eachStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_eachStatement_in_statement599);
                    eachStatement76=eachStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, eachStatement76.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:272:6: letStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_letStatement_in_statement606);
                    letStatement77=letStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, letStatement77.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:273:6: '{' ( statement )* '}'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal78=(CommonTree)match(input,46,FOLLOW_46_in_statement613); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal78_tree = (CommonTree)adaptor.dupNode(char_literal78);

                    adaptor.addChild(root_0, char_literal78_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:273:10: ( statement )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==IDCON||LA22_0==COMMENT||LA22_0==46||LA22_0==50||(LA22_0>=52 && LA22_0<=53)||(LA22_0>=55 && LA22_0<=57)) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: statement
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_statement_in_statement615);
                    	    statement79=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, statement79.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal80=(CommonTree)match(input,47,FOLLOW_47_in_statement618); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal80_tree = (CommonTree)adaptor.dupNode(char_literal80);

                    adaptor.addChild(root_0, char_literal80_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:274:6: 'comment' STRCON ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal81=(CommonTree)match(input,COMMENT,FOLLOW_COMMENT_in_statement625); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal81_tree = (CommonTree)adaptor.dupNode(string_literal81);

                    adaptor.addChild(root_0, string_literal81_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    STRCON82=(CommonTree)match(input,STRCON,FOLLOW_STRCON_in_statement627); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRCON82_tree = (CommonTree)adaptor.dupNode(STRCON82);

                    adaptor.addChild(root_0, STRCON82_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal83=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement629); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal83_tree = (CommonTree)adaptor.dupNode(char_literal83);

                    adaptor.addChild(root_0, char_literal83_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:275:6: 'echo' expression ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal84=(CommonTree)match(input,55,FOLLOW_55_in_statement636); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal84_tree = (CommonTree)adaptor.dupNode(string_literal84);

                    adaptor.addChild(root_0, string_literal84_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement638);
                    expression85=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression85.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal86=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement640); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal86_tree = (CommonTree)adaptor.dupNode(char_literal86);

                    adaptor.addChild(root_0, char_literal86_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:276:6: 'echo' embedding ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal87=(CommonTree)match(input,55,FOLLOW_55_in_statement647); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal87_tree = (CommonTree)adaptor.dupNode(string_literal87);

                    adaptor.addChild(root_0, string_literal87_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement649);
                    embedding88=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, embedding88.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal89=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement651); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal89_tree = (CommonTree)adaptor.dupNode(char_literal89);

                    adaptor.addChild(root_0, char_literal89_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:277:6: 'cdata' expression ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal90=(CommonTree)match(input,56,FOLLOW_56_in_statement658); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal90_tree = (CommonTree)adaptor.dupNode(string_literal90);

                    adaptor.addChild(root_0, string_literal90_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement660);
                    expression91=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression91.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal92=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement662); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal92_tree = (CommonTree)adaptor.dupNode(char_literal92);

                    adaptor.addChild(root_0, char_literal92_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:278:6: 'yield;'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal93=(CommonTree)match(input,57,FOLLOW_57_in_statement669); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal93_tree = (CommonTree)adaptor.dupNode(string_literal93);

                    adaptor.addChild(root_0, string_literal93_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:279:6: markup ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_statement676);
                    markup94=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, markup94.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal95=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement678); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal95_tree = (CommonTree)adaptor.dupNode(char_literal95);

                    adaptor.addChild(root_0, char_literal95_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:280:6: ( markup )+ ';' expression ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:280:6: ( markup )+
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
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement685);
                    	    markup96=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup96.getTree());

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
                    char_literal97=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement688); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal97_tree = (CommonTree)adaptor.dupNode(char_literal97);

                    adaptor.addChild(root_0, char_literal97_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement690);
                    expression98=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression98.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal99=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement692); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal99_tree = (CommonTree)adaptor.dupNode(char_literal99);

                    adaptor.addChild(root_0, char_literal99_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:281:6: ( markup )+ ';' statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:281:6: ( markup )+
                    int cnt24=0;
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==IDCON) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement699);
                    	    markup100=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup100.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
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

                    _last = (CommonTree)input.LT(1);
                    char_literal101=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement702); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal101_tree = (CommonTree)adaptor.dupNode(char_literal101);

                    adaptor.addChild(root_0, char_literal101_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement704);
                    statement102=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, statement102.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:282:6: ( markup )+ embedding ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:282:6: ( markup )+
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
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement711);
                    	    markup103=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup103.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
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

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement714);
                    embedding104=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, embedding104.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal105=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement716); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal105_tree = (CommonTree)adaptor.dupNode(char_literal105);

                    adaptor.addChild(root_0, char_literal105_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:283:6: ( markup )+ ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:283:6: ( markup )+
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
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement723);
                    	    markup106=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup106.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
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

                    _last = (CommonTree)input.LT(1);
                    char_literal107=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement726); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal107_tree = (CommonTree)adaptor.dupNode(char_literal107);

                    adaptor.addChild(root_0, char_literal107_tree);
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

    public static class eachStatement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "eachStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:285:1: eachStatement : 'each' '(' id= IDCON ':' expression ')' statement ;
    public final WaebricChecker.eachStatement_return eachStatement() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.eachStatement_return retval = new WaebricChecker.eachStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        CommonTree string_literal108=null;
        CommonTree char_literal109=null;
        CommonTree char_literal110=null;
        CommonTree char_literal112=null;
        WaebricChecker.expression_return expression111 = null;

        WaebricChecker.statement_return statement113 = null;


        CommonTree id_tree=null;
        CommonTree string_literal108_tree=null;
        CommonTree char_literal109_tree=null;
        CommonTree char_literal110_tree=null;
        CommonTree char_literal112_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new HashSet<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:290:4: ( 'each' '(' id= IDCON ':' expression ')' statement )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:290:7: 'each' '(' id= IDCON ':' expression ')' statement
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal108=(CommonTree)match(input,52,FOLLOW_52_in_eachStatement748); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal108_tree = (CommonTree)adaptor.dupNode(string_literal108);

            adaptor.addChild(root_0, string_literal108_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal109=(CommonTree)match(input,41,FOLLOW_41_in_eachStatement750); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal109_tree = (CommonTree)adaptor.dupNode(char_literal109);

            adaptor.addChild(root_0, char_literal109_tree);
            }
            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_eachStatement754); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (CommonTree)adaptor.dupNode(id);

            adaptor.addChild(root_0, id_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal110=(CommonTree)match(input,36,FOLLOW_36_in_eachStatement756); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal110_tree = (CommonTree)adaptor.dupNode(char_literal110);

            adaptor.addChild(root_0, char_literal110_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_eachStatement758);
            expression111=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, expression111.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal112=(CommonTree)match(input,43,FOLLOW_43_in_eachStatement760); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal112_tree = (CommonTree)adaptor.dupNode(char_literal112);

            adaptor.addChild(root_0, char_literal112_tree);
            }
            if ( state.backtracking==0 ) {
               
              				defineVariable(id); // Define variable before statement is executed
              			
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_eachStatement764);
            statement113=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, statement113.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:294:1: letStatement : 'let' ( assignment[curr] )+ 'in' ( statement )* 'end' ;
    public final WaebricChecker.letStatement_return letStatement() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.letStatement_return retval = new WaebricChecker.letStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal114=null;
        CommonTree string_literal116=null;
        CommonTree string_literal118=null;
        WaebricChecker.assignment_return assignment115 = null;

        WaebricChecker.statement_return statement117 = null;


        CommonTree string_literal114_tree=null;
        CommonTree string_literal116_tree=null;
        CommonTree string_literal118_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new HashSet<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        		int curr = Environment_stack.size()-1;
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:300:4: ( 'let' ( assignment[curr] )+ 'in' ( statement )* 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:300:7: 'let' ( assignment[curr] )+ 'in' ( statement )* 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal114=(CommonTree)match(input,53,FOLLOW_53_in_letStatement786); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal114_tree = (CommonTree)adaptor.dupNode(string_literal114);

            adaptor.addChild(root_0, string_literal114_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:300:13: ( assignment[curr] )+
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
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: assignment[curr]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_assignment_in_letStatement788);
            	    assignment115=assignment(curr);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, assignment115.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
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

            _last = (CommonTree)input.LT(1);
            string_literal116=(CommonTree)match(input,54,FOLLOW_54_in_letStatement792); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal116_tree = (CommonTree)adaptor.dupNode(string_literal116);

            adaptor.addChild(root_0, string_literal116_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:300:36: ( statement )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==IDCON||LA29_0==COMMENT||LA29_0==46||LA29_0==50||(LA29_0>=52 && LA29_0<=53)||(LA29_0>=55 && LA29_0<=57)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_letStatement794);
            	    statement117=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, statement117.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            string_literal118=(CommonTree)match(input,END,FOLLOW_END_in_letStatement797); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal118_tree = (CommonTree)adaptor.dupNode(string_literal118);

            adaptor.addChild(root_0, string_literal118_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:302:1: assignment[int depth] : ( varBinding | funcBinding[depth] );
    public final WaebricChecker.assignment_return assignment(int depth) throws RecognitionException {
        WaebricChecker.assignment_return retval = new WaebricChecker.assignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricChecker.varBinding_return varBinding119 = null;

        WaebricChecker.funcBinding_return funcBinding120 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:302:23: ( varBinding | funcBinding[depth] )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==IDCON) ) {
                int LA30_1 = input.LA(2);

                if ( (LA30_1==58) ) {
                    alt30=1;
                }
                else if ( (LA30_1==41) ) {
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:303:4: varBinding
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_varBinding_in_assignment811);
                    varBinding119=varBinding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, varBinding119.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:303:17: funcBinding[depth]
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_funcBinding_in_assignment815);
                    funcBinding120=funcBinding(depth);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, funcBinding120.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:305:1: varBinding : id= IDCON '=' expression ';' ;
    public final WaebricChecker.varBinding_return varBinding() throws RecognitionException {
        WaebricChecker.varBinding_return retval = new WaebricChecker.varBinding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        CommonTree char_literal121=null;
        CommonTree char_literal123=null;
        WaebricChecker.expression_return expression122 = null;


        CommonTree id_tree=null;
        CommonTree char_literal121_tree=null;
        CommonTree char_literal123_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:305:11: (id= IDCON '=' expression ';' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:305:14: id= IDCON '=' expression ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_varBinding827); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (CommonTree)adaptor.dupNode(id);

            adaptor.addChild(root_0, id_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal121=(CommonTree)match(input,58,FOLLOW_58_in_varBinding829); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal121_tree = (CommonTree)adaptor.dupNode(char_literal121);

            adaptor.addChild(root_0, char_literal121_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_varBinding831);
            expression122=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, expression122.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal123=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_varBinding833); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal123_tree = (CommonTree)adaptor.dupNode(char_literal123);

            adaptor.addChild(root_0, char_literal123_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:309:1: funcBinding[int depth] : id= IDCON f= regularFormals statement ;
    public final WaebricChecker.funcBinding_return funcBinding(int depth) throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.funcBinding_return retval = new WaebricChecker.funcBinding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        WaebricChecker.regularFormals_return f = null;

        WaebricChecker.statement_return statement124 = null;


        CommonTree id_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new HashSet<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:314:4: (id= IDCON f= regularFormals statement )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:314:7: id= IDCON f= regularFormals statement
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_funcBinding864); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (CommonTree)adaptor.dupNode(id);

            adaptor.addChild(root_0, id_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_regularFormals_in_funcBinding868);
            f=regularFormals();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, f.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_funcBinding870);
            statement124=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, statement124.getTree());
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

    public static class predicate_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "predicate"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:318:1: predicate : ( '!' predicate | expression | expression '.' . ) ( '&&' predicate | '||' predicate )* ;
    public final WaebricChecker.predicate_return predicate() throws RecognitionException {
        WaebricChecker.predicate_return retval = new WaebricChecker.predicate_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal125=null;
        CommonTree char_literal129=null;
        CommonTree wildcard130=null;
        CommonTree string_literal131=null;
        CommonTree string_literal133=null;
        WaebricChecker.predicate_return predicate126 = null;

        WaebricChecker.expression_return expression127 = null;

        WaebricChecker.expression_return expression128 = null;

        WaebricChecker.predicate_return predicate132 = null;

        WaebricChecker.predicate_return predicate134 = null;


        CommonTree char_literal125_tree=null;
        CommonTree char_literal129_tree=null;
        CommonTree wildcard130_tree=null;
        CommonTree string_literal131_tree=null;
        CommonTree string_literal133_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:318:10: ( ( '!' predicate | expression | expression '.' . ) ( '&&' predicate | '||' predicate )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:318:13: ( '!' predicate | expression | expression '.' . ) ( '&&' predicate | '||' predicate )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:318:13: ( '!' predicate | expression | expression '.' . )
            int alt31=3;
            switch ( input.LA(1) ) {
            case 59:
                {
                int LA31_1 = input.LA(2);

                if ( (synpred50_WaebricChecker()) ) {
                    alt31=1;
                }
                else if ( (synpred51_WaebricChecker()) ) {
                    alt31=2;
                }
                else if ( (true) ) {
                    alt31=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 1, input);

                    throw nvae;
                }
                }
                break;
            case IDCON:
                {
                int LA31_2 = input.LA(2);

                if ( (synpred51_WaebricChecker()) ) {
                    alt31=2;
                }
                else if ( (true) ) {
                    alt31=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 2, input);

                    throw nvae;
                }
                }
                break;
            case 44:
                {
                int LA31_3 = input.LA(2);

                if ( (synpred51_WaebricChecker()) ) {
                    alt31=2;
                }
                else if ( (true) ) {
                    alt31=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 3, input);

                    throw nvae;
                }
                }
                break;
            case 46:
                {
                int LA31_4 = input.LA(2);

                if ( (synpred51_WaebricChecker()) ) {
                    alt31=2;
                }
                else if ( (true) ) {
                    alt31=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 4, input);

                    throw nvae;
                }
                }
                break;
            case PATH:
            case NATCON:
            case TEXT:
            case SYMBOLCON:
            case STRCON:
            case PRETEXT:
            case POSTTEXT:
            case MIDTEXT:
            case COMMENT:
            case SITE:
            case END:
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
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 45:
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
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
                {
                int LA31_5 = input.LA(2);

                if ( (synpred51_WaebricChecker()) ) {
                    alt31=2;
                }
                else if ( (true) ) {
                    alt31=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 5, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:318:15: '!' predicate
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal125=(CommonTree)match(input,59,FOLLOW_59_in_predicate885); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal125_tree = (CommonTree)adaptor.dupNode(char_literal125);

                    adaptor.addChild(root_0, char_literal125_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_predicate887);
                    predicate126=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, predicate126.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:319:7: expression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate896);
                    expression127=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression127.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:320:7: expression '.' .
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate904);
                    expression128=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression128.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal129=(CommonTree)match(input,34,FOLLOW_34_in_predicate906); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal129_tree = (CommonTree)adaptor.dupNode(char_literal129);

                    adaptor.addChild(root_0, char_literal129_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    wildcard130=(CommonTree)input.LT(1);
                    matchAny(input); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    wildcard130_tree = (CommonTree)adaptor.dupTree(wildcard130);
                    adaptor.addChild(root_0, wildcard130_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:321:6: ( '&&' predicate | '||' predicate )*
            loop32:
            do {
                int alt32=3;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==60) ) {
                    int LA32_2 = input.LA(2);

                    if ( (synpred52_WaebricChecker()) ) {
                        alt32=1;
                    }


                }
                else if ( (LA32_0==61) ) {
                    int LA32_3 = input.LA(2);

                    if ( (synpred53_WaebricChecker()) ) {
                        alt32=2;
                    }


                }


                switch (alt32) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:321:8: '&&' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal131=(CommonTree)match(input,60,FOLLOW_60_in_predicate917); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal131_tree = (CommonTree)adaptor.dupNode(string_literal131);

            	    adaptor.addChild(root_0, string_literal131_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate919);
            	    predicate132=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, predicate132.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:321:25: '||' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal133=(CommonTree)match(input,61,FOLLOW_61_in_predicate923); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal133_tree = (CommonTree)adaptor.dupNode(string_literal133);

            	    adaptor.addChild(root_0, string_literal133_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate925);
            	    predicate134=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, predicate134.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop32;
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

    public static class embedding_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "embedding"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:327:1: embedding : PRETEXT embed textTail ;
    public final WaebricChecker.embedding_return embedding() throws RecognitionException {
        WaebricChecker.embedding_return retval = new WaebricChecker.embedding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PRETEXT135=null;
        WaebricChecker.embed_return embed136 = null;

        WaebricChecker.textTail_return textTail137 = null;


        CommonTree PRETEXT135_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:327:10: ( PRETEXT embed textTail )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:327:13: PRETEXT embed textTail
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PRETEXT135=(CommonTree)match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding943); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRETEXT135_tree = (CommonTree)adaptor.dupNode(PRETEXT135);

            adaptor.addChild(root_0, PRETEXT135_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_embed_in_embedding945);
            embed136=embed();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, embed136.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_textTail_in_embedding947);
            textTail137=textTail();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, textTail137.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:328:1: embed : ( ( markup )* expression | ( markup )* markup );
    public final WaebricChecker.embed_return embed() throws RecognitionException {
        WaebricChecker.embed_return retval = new WaebricChecker.embed_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricChecker.markup_return markup138 = null;

        WaebricChecker.expression_return expression139 = null;

        WaebricChecker.markup_return markup140 = null;

        WaebricChecker.markup_return markup141 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:328:6: ( ( markup )* expression | ( markup )* markup )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==IDCON) ) {
                int LA35_1 = input.LA(2);

                if ( (synpred55_WaebricChecker()) ) {
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
            else if ( ((LA35_0>=PATH && LA35_0<=64)) ) {
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:328:10: ( markup )* expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:328:10: ( markup )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==IDCON) ) {
                            int LA33_1 = input.LA(2);

                            if ( (synpred54_WaebricChecker()) ) {
                                alt33=1;
                            }


                        }


                        switch (alt33) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed956);
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
                    	    break loop33;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_embed959);
                    expression139=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression139.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:328:31: ( markup )* markup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:328:31: ( markup )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==IDCON) ) {
                            int LA34_1 = input.LA(2);

                            if ( (synpred56_WaebricChecker()) ) {
                                alt34=1;
                            }


                        }


                        switch (alt34) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed963);
                    	    markup140=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup140.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_embed966);
                    markup141=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, markup141.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:329:1: textTail : ( POSTTEXT | MIDTEXT embed textTail );
    public final WaebricChecker.textTail_return textTail() throws RecognitionException {
        WaebricChecker.textTail_return retval = new WaebricChecker.textTail_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POSTTEXT142=null;
        CommonTree MIDTEXT143=null;
        WaebricChecker.embed_return embed144 = null;

        WaebricChecker.textTail_return textTail145 = null;


        CommonTree POSTTEXT142_tree=null;
        CommonTree MIDTEXT143_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:329:9: ( POSTTEXT | MIDTEXT embed textTail )
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:329:12: POSTTEXT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    POSTTEXT142=(CommonTree)match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail974); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    POSTTEXT142_tree = (CommonTree)adaptor.dupNode(POSTTEXT142);

                    adaptor.addChild(root_0, POSTTEXT142_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:329:23: MIDTEXT embed textTail
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    MIDTEXT143=(CommonTree)match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail978); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MIDTEXT143_tree = (CommonTree)adaptor.dupNode(MIDTEXT143);

                    adaptor.addChild(root_0, MIDTEXT143_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embed_in_textTail980);
                    embed144=embed();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, embed144.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_textTail_in_textTail982);
                    textTail145=textTail();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, textTail145.getTree());

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

    // $ANTLR start synpred7_WaebricChecker
    public final void synpred7_WaebricChecker_fragment() throws RecognitionException {   
        WaebricChecker.arguments_return a = null;


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:214:20: (a= arguments )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:214:20: a= arguments
        {
        pushFollow(FOLLOW_arguments_in_synpred7_WaebricChecker222);
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
        pushFollow(FOLLOW_expression_in_synpred14_WaebricChecker306);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_WaebricChecker

    // $ANTLR start synpred16_WaebricChecker
    public final void synpred16_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:234:16: ( varExpression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:234:16: varExpression
        {
        pushFollow(FOLLOW_varExpression_in_synpred16_WaebricChecker343);
        varExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_WaebricChecker

    // $ANTLR start synpred17_WaebricChecker
    public final void synpred17_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:235:11: ( expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:235:11: expression
        {
        pushFollow(FOLLOW_expression_in_synpred17_WaebricChecker354);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_WaebricChecker

    // $ANTLR start synpred19_WaebricChecker
    public final void synpred19_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:235:7: ( '[' ( expression )? ( ',' expression )* ']' )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:235:7: '[' ( expression )? ( ',' expression )* ']'
        {
        match(input,44,FOLLOW_44_in_synpred19_WaebricChecker352); if (state.failed) return ;
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:235:11: ( expression )?
        int alt37=2;
        switch ( input.LA(1) ) {
            case IDCON:
            case PATH:
            case NATCON:
            case TEXT:
            case SYMBOLCON:
            case STRCON:
            case PRETEXT:
            case POSTTEXT:
            case MIDTEXT:
            case COMMENT:
            case SITE:
            case END:
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
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 43:
            case 44:
            case 46:
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
                {
                alt37=1;
                }
                break;
            case 42:
                {
                int LA37_4 = input.LA(2);

                if ( (synpred17_WaebricChecker()) ) {
                    alt37=1;
                }
                }
                break;
            case 45:
                {
                int LA37_5 = input.LA(2);

                if ( (synpred17_WaebricChecker()) ) {
                    alt37=1;
                }
                }
                break;
        }

        switch (alt37) {
            case 1 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: expression
                {
                pushFollow(FOLLOW_expression_in_synpred19_WaebricChecker354);
                expression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }

        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:235:23: ( ',' expression )*
        loop38:
        do {
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==42) ) {
                alt38=1;
            }


            switch (alt38) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:235:25: ',' expression
        	    {
        	    match(input,42,FOLLOW_42_in_synpred19_WaebricChecker359); if (state.failed) return ;
        	    pushFollow(FOLLOW_expression_in_synpred19_WaebricChecker361);
        	    expression();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop38;
            }
        } while (true);

        match(input,45,FOLLOW_45_in_synpred19_WaebricChecker366); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_WaebricChecker

    // $ANTLR start synpred22_WaebricChecker
    public final void synpred22_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:236:7: ( '{' ( keyValuePair )? ( ',' keyValuePair )* '}' )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:236:7: '{' ( keyValuePair )? ( ',' keyValuePair )* '}'
        {
        match(input,46,FOLLOW_46_in_synpred22_WaebricChecker375); if (state.failed) return ;
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:236:11: ( keyValuePair )?
        int alt39=2;
        int LA39_0 = input.LA(1);

        if ( (LA39_0==IDCON) ) {
            alt39=1;
        }
        switch (alt39) {
            case 1 :
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: keyValuePair
                {
                pushFollow(FOLLOW_keyValuePair_in_synpred22_WaebricChecker377);
                keyValuePair();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }

        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:236:25: ( ',' keyValuePair )*
        loop40:
        do {
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==42) ) {
                alt40=1;
            }


            switch (alt40) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:236:27: ',' keyValuePair
        	    {
        	    match(input,42,FOLLOW_42_in_synpred22_WaebricChecker382); if (state.failed) return ;
        	    pushFollow(FOLLOW_keyValuePair_in_synpred22_WaebricChecker384);
        	    keyValuePair();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop40;
            }
        } while (true);

        match(input,47,FOLLOW_47_in_synpred22_WaebricChecker389); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred22_WaebricChecker

    // $ANTLR start synpred23_WaebricChecker
    public final void synpred23_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:238:8: ( '+' expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:238:8: '+' expression
        {
        match(input,48,FOLLOW_48_in_synpred23_WaebricChecker408); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred23_WaebricChecker410);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred23_WaebricChecker

    // $ANTLR start synpred24_WaebricChecker
    public final void synpred24_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:238:25: ( '.' IDCON )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:238:25: '.' IDCON
        {
        match(input,34,FOLLOW_34_in_synpred24_WaebricChecker414); if (state.failed) return ;
        match(input,IDCON,FOLLOW_IDCON_in_synpred24_WaebricChecker416); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred24_WaebricChecker

    // $ANTLR start synpred28_WaebricChecker
    public final void synpred28_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:269:13: ( 'if' '(' predicate ')' statement 'else' statement )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:269:13: 'if' '(' predicate ')' statement 'else' statement
        {
        match(input,50,FOLLOW_50_in_synpred28_WaebricChecker565); if (state.failed) return ;
        match(input,41,FOLLOW_41_in_synpred28_WaebricChecker567); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred28_WaebricChecker569);
        predicate();

        state._fsp--;
        if (state.failed) return ;
        match(input,43,FOLLOW_43_in_synpred28_WaebricChecker571); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred28_WaebricChecker573);
        statement();

        state._fsp--;
        if (state.failed) return ;
        match(input,51,FOLLOW_51_in_synpred28_WaebricChecker575); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred28_WaebricChecker577);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred28_WaebricChecker

    // $ANTLR start synpred29_WaebricChecker
    public final void synpred29_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:270:6: ( 'if' '(' predicate ')' statement )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:270:6: 'if' '(' predicate ')' statement
        {
        match(input,50,FOLLOW_50_in_synpred29_WaebricChecker584); if (state.failed) return ;
        match(input,41,FOLLOW_41_in_synpred29_WaebricChecker586); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred29_WaebricChecker588);
        predicate();

        state._fsp--;
        if (state.failed) return ;
        match(input,43,FOLLOW_43_in_synpred29_WaebricChecker590); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred29_WaebricChecker592);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred29_WaebricChecker

    // $ANTLR start synpred35_WaebricChecker
    public final void synpred35_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:275:6: ( 'echo' expression ';' )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:275:6: 'echo' expression ';'
        {
        match(input,55,FOLLOW_55_in_synpred35_WaebricChecker636); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred35_WaebricChecker638);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred35_WaebricChecker640); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred35_WaebricChecker

    // $ANTLR start synpred36_WaebricChecker
    public final void synpred36_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:276:6: ( 'echo' embedding ';' )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:276:6: 'echo' embedding ';'
        {
        match(input,55,FOLLOW_55_in_synpred36_WaebricChecker647); if (state.failed) return ;
        pushFollow(FOLLOW_embedding_in_synpred36_WaebricChecker649);
        embedding();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred36_WaebricChecker651); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred36_WaebricChecker

    // $ANTLR start synpred39_WaebricChecker
    public final void synpred39_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:279:6: ( markup ';' )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:279:6: markup ';'
        {
        pushFollow(FOLLOW_markup_in_synpred39_WaebricChecker676);
        markup();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred39_WaebricChecker678); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_WaebricChecker

    // $ANTLR start synpred41_WaebricChecker
    public final void synpred41_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:280:6: ( ( markup )+ ';' expression ';' )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:280:6: ( markup )+ ';' expression ';'
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:280:6: ( markup )+
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
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred41_WaebricChecker685);
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

        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred41_WaebricChecker688); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred41_WaebricChecker690);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred41_WaebricChecker692); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred41_WaebricChecker

    // $ANTLR start synpred43_WaebricChecker
    public final void synpred43_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:281:6: ( ( markup )+ ';' statement )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:281:6: ( markup )+ ';' statement
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:281:6: ( markup )+
        int cnt43=0;
        loop43:
        do {
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==IDCON) ) {
                alt43=1;
            }


            switch (alt43) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred43_WaebricChecker699);
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

        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred43_WaebricChecker702); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred43_WaebricChecker704);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred43_WaebricChecker

    // $ANTLR start synpred45_WaebricChecker
    public final void synpred45_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:282:6: ( ( markup )+ embedding ';' )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:282:6: ( markup )+ embedding ';'
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:282:6: ( markup )+
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
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred45_WaebricChecker711);
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

        pushFollow(FOLLOW_embedding_in_synpred45_WaebricChecker714);
        embedding();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred45_WaebricChecker716); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred45_WaebricChecker

    // $ANTLR start synpred50_WaebricChecker
    public final void synpred50_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:318:15: ( '!' predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:318:15: '!' predicate
        {
        match(input,59,FOLLOW_59_in_synpred50_WaebricChecker885); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred50_WaebricChecker887);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred50_WaebricChecker

    // $ANTLR start synpred51_WaebricChecker
    public final void synpred51_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:319:7: ( expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:319:7: expression
        {
        pushFollow(FOLLOW_expression_in_synpred51_WaebricChecker896);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred51_WaebricChecker

    // $ANTLR start synpred52_WaebricChecker
    public final void synpred52_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:321:8: ( '&&' predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:321:8: '&&' predicate
        {
        match(input,60,FOLLOW_60_in_synpred52_WaebricChecker917); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred52_WaebricChecker919);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred52_WaebricChecker

    // $ANTLR start synpred53_WaebricChecker
    public final void synpred53_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:321:25: ( '||' predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:321:25: '||' predicate
        {
        match(input,61,FOLLOW_61_in_synpred53_WaebricChecker923); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred53_WaebricChecker925);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred53_WaebricChecker

    // $ANTLR start synpred54_WaebricChecker
    public final void synpred54_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:328:10: ( markup )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:328:10: markup
        {
        pushFollow(FOLLOW_markup_in_synpred54_WaebricChecker956);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred54_WaebricChecker

    // $ANTLR start synpred55_WaebricChecker
    public final void synpred55_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:328:10: ( ( markup )* expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:328:10: ( markup )* expression
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:328:10: ( markup )*
        loop45:
        do {
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==IDCON) ) {
                int LA45_1 = input.LA(2);

                if ( (synpred54_WaebricChecker()) ) {
                    alt45=1;
                }


            }


            switch (alt45) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred55_WaebricChecker956);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop45;
            }
        } while (true);

        pushFollow(FOLLOW_expression_in_synpred55_WaebricChecker959);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred55_WaebricChecker

    // $ANTLR start synpred56_WaebricChecker
    public final void synpred56_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:328:31: ( markup )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:328:31: markup
        {
        pushFollow(FOLLOW_markup_in_synpred56_WaebricChecker963);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred56_WaebricChecker

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
    public final boolean synpred53_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred53_WaebricChecker_fragment(); // can never throw exception
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
    public final boolean synpred36_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_WaebricChecker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred54_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_WaebricChecker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred52_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred52_WaebricChecker_fragment(); // can never throw exception
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
    public final boolean synpred35_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_WaebricChecker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred55_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred55_WaebricChecker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred56_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred56_WaebricChecker_fragment(); // can never throw exception
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
    public final boolean synpred24_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_WaebricChecker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred51_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred51_WaebricChecker_fragment(); // can never throw exception
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
    public final boolean synpred41_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred41_WaebricChecker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_WaebricChecker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred50_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred50_WaebricChecker_fragment(); // can never throw exception
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
    protected DFA27 dfa27 = new DFA27(this);
    static final String DFA7_eotS =
        "\15\uffff";
    static final String DFA7_eofS =
        "\1\2\14\uffff";
    static final String DFA7_minS =
        "\1\4\1\0\13\uffff";
    static final String DFA7_maxS =
        "\1\100\1\0\13\uffff";
    static final String DFA7_acceptS =
        "\2\uffff\1\2\11\uffff\1\1";
    static final String DFA7_specialS =
        "\1\uffff\1\0\13\uffff}>";
    static final String[] DFA7_transitionS = {
            "\45\2\1\1\27\2",
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
                        if ( (synpred7_WaebricChecker()) ) {s = 12;}

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
            return "269:1: statement : ( 'if' '(' predicate ')' statement 'else' statement | 'if' '(' predicate ')' statement | eachStatement | letStatement | '{' ( statement )* '}' | 'comment' STRCON ';' | 'echo' expression ';' | 'echo' embedding ';' | 'cdata' expression ';' | 'yield;' | markup ';' | ( markup )+ ';' expression ';' | ( markup )+ ';' statement | ( markup )+ embedding ';' | ( markup )+ ';' );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TreeNodeStream input = (TreeNodeStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA27_1 = input.LA(1);

                         
                        int index27_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_WaebricChecker()) ) {s = 10;}

                        else if ( (synpred29_WaebricChecker()) ) {s = 11;}

                         
                        input.seek(index27_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA27_6 = input.LA(1);

                         
                        int index27_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_WaebricChecker()) ) {s = 12;}

                        else if ( (synpred36_WaebricChecker()) ) {s = 13;}

                         
                        input.seek(index27_6);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA27_9 = input.LA(1);

                         
                        int index27_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_WaebricChecker()) ) {s = 14;}

                        else if ( (synpred41_WaebricChecker()) ) {s = 15;}

                        else if ( (synpred43_WaebricChecker()) ) {s = 16;}

                        else if ( (synpred45_WaebricChecker()) ) {s = 17;}

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
 

    public static final BitSet FOLLOW_33_in_module77 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_moduleId_in_module79 = new BitSet(new long[]{0x000200080000C000L});
    public static final BitSet FOLLOW_imprt_in_module81 = new BitSet(new long[]{0x000200080000C000L});
    public static final BitSet FOLLOW_site_in_module84 = new BitSet(new long[]{0x000200000000C000L});
    public static final BitSet FOLLOW_function_in_module87 = new BitSet(new long[]{0x0002000000008000L});
    public static final BitSet FOLLOW_END_in_module90 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDCON_in_moduleId109 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_moduleId118 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_moduleId122 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_35_in_imprt139 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_moduleId_in_imprt143 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_imprt145 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_module_in_imprt148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SITE_in_site160 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_mappings_in_site162 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_END_in_site164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapping_in_mappings172 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_SEMICOLON_in_mappings177 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_mapping_in_mappings179 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_36_in_mapping193 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_mapping195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_designator_in_markup216 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_arguments_in_markup222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_designator241 = new BitSet(new long[]{0x000000F400000002L});
    public static final BitSet FOLLOW_attribute_in_designator243 = new BitSet(new long[]{0x000000F400000002L});
    public static final BitSet FOLLOW_37_in_attribute252 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_attribute258 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_attribute264 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_attribute270 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_attribute276 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NATCON_in_attribute278 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_attribute282 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NATCON_in_attribute284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_arguments302 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_expression_in_arguments306 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_42_in_arguments319 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_expression_in_arguments321 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_43_in_arguments328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varExpression_in_expression343 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_44_in_expression352 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_expression_in_expression354 = new BitSet(new long[]{0x0000240000000000L});
    public static final BitSet FOLLOW_42_in_expression359 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_expression_in_expression361 = new BitSet(new long[]{0x0000240000000000L});
    public static final BitSet FOLLOW_45_in_expression366 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_46_in_expression375 = new BitSet(new long[]{0x0000840000000010L});
    public static final BitSet FOLLOW_keyValuePair_in_expression377 = new BitSet(new long[]{0x0000840000000000L});
    public static final BitSet FOLLOW_42_in_expression382 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_keyValuePair_in_expression384 = new BitSet(new long[]{0x0000840000000000L});
    public static final BitSet FOLLOW_47_in_expression389 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_48_in_expression408 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_expression_in_expression410 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_34_in_expression414 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_expression416 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_IDCON_in_varExpression430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_keyValuePair444 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_keyValuePair446 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_expression_in_keyValuePair448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_function472 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_function476 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_formals_in_function480 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_statement_in_function482 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_END_in_function485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_regularFormals_in_formals508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_emptyFormals_in_formals514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_regularFormals532 = new BitSet(new long[]{0x0000080000000010L});
    public static final BitSet FOLLOW_IDCON_in_regularFormals538 = new BitSet(new long[]{0x0000080000000010L});
    public static final BitSet FOLLOW_43_in_regularFormals545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_statement565 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_statement567 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_statement569 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_statement571 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement573 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_statement575 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_statement584 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_statement586 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_statement588 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_statement590 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_eachStatement_in_statement599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_letStatement_in_statement606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_statement613 = new BitSet(new long[]{0x03B4C00000002010L});
    public static final BitSet FOLLOW_statement_in_statement615 = new BitSet(new long[]{0x03B4C00000002010L});
    public static final BitSet FOLLOW_47_in_statement618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMENT_in_statement625 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_STRCON_in_statement627 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_statement636 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_expression_in_statement638 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_statement647 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_embedding_in_statement649 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_statement658 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_expression_in_statement660 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_statement669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement676 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement685 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement688 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_expression_in_statement690 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement699 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement702 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement711 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_embedding_in_statement714 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement723 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_eachStatement748 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_eachStatement750 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_eachStatement754 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_eachStatement756 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_expression_in_eachStatement758 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_eachStatement760 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_eachStatement764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_letStatement786 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_assignment_in_letStatement788 = new BitSet(new long[]{0x0040000000000010L});
    public static final BitSet FOLLOW_54_in_letStatement792 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_statement_in_letStatement794 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_END_in_letStatement797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varBinding_in_assignment811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funcBinding_in_assignment815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_varBinding827 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_varBinding829 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_expression_in_varBinding831 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_varBinding833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_funcBinding864 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_regularFormals_in_funcBinding868 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_funcBinding870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_predicate885 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_predicate887 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate896 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate904 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_predicate906 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_60_in_predicate917 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_predicate919 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_61_in_predicate923 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_predicate925 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding943 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_embed_in_embedding945 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_textTail_in_embedding947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed956 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_expression_in_embed959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed963 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_embed966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail978 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_embed_in_textTail980 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_textTail_in_textTail982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arguments_in_synpred7_WaebricChecker222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred14_WaebricChecker306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varExpression_in_synpred16_WaebricChecker343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred17_WaebricChecker354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_synpred19_WaebricChecker352 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_expression_in_synpred19_WaebricChecker354 = new BitSet(new long[]{0x0000240000000000L});
    public static final BitSet FOLLOW_42_in_synpred19_WaebricChecker359 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_expression_in_synpred19_WaebricChecker361 = new BitSet(new long[]{0x0000240000000000L});
    public static final BitSet FOLLOW_45_in_synpred19_WaebricChecker366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_synpred22_WaebricChecker375 = new BitSet(new long[]{0x0000840000000010L});
    public static final BitSet FOLLOW_keyValuePair_in_synpred22_WaebricChecker377 = new BitSet(new long[]{0x0000840000000000L});
    public static final BitSet FOLLOW_42_in_synpred22_WaebricChecker382 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_keyValuePair_in_synpred22_WaebricChecker384 = new BitSet(new long[]{0x0000840000000000L});
    public static final BitSet FOLLOW_47_in_synpred22_WaebricChecker389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_synpred23_WaebricChecker408 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_expression_in_synpred23_WaebricChecker410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_synpred24_WaebricChecker414 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_synpred24_WaebricChecker416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_synpred28_WaebricChecker565 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_synpred28_WaebricChecker567 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_synpred28_WaebricChecker569 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_synpred28_WaebricChecker571 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_synpred28_WaebricChecker573 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_synpred28_WaebricChecker575 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_synpred28_WaebricChecker577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_synpred29_WaebricChecker584 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_synpred29_WaebricChecker586 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_synpred29_WaebricChecker588 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_synpred29_WaebricChecker590 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_synpred29_WaebricChecker592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_synpred35_WaebricChecker636 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_expression_in_synpred35_WaebricChecker638 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred35_WaebricChecker640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_synpred36_WaebricChecker647 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_embedding_in_synpred36_WaebricChecker649 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred36_WaebricChecker651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred39_WaebricChecker676 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred39_WaebricChecker678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred41_WaebricChecker685 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred41_WaebricChecker688 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_expression_in_synpred41_WaebricChecker690 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred41_WaebricChecker692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred43_WaebricChecker699 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred43_WaebricChecker702 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_synpred43_WaebricChecker704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred45_WaebricChecker711 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_embedding_in_synpred45_WaebricChecker714 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred45_WaebricChecker716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_synpred50_WaebricChecker885 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_synpred50_WaebricChecker887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred51_WaebricChecker896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_synpred52_WaebricChecker917 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_synpred52_WaebricChecker919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred53_WaebricChecker923 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_synpred53_WaebricChecker925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred54_WaebricChecker956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred55_WaebricChecker956 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_expression_in_synpred55_WaebricChecker959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred56_WaebricChecker963 = new BitSet(new long[]{0x0000000000000002L});

}