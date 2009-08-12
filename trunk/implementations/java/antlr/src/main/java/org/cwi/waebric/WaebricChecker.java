// $ANTLR 3.1.2 /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g 2009-08-12 12:11:29

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

    	/**
    	 * Define function
    	 * @param id: Tree representation of functions IDCON
    	 * @param args: Number of arguments in function
    	 * @param depth: Depth in environment stack
    	 */
    	void defineFunction(CommonTree id, int args, int depth) {
    		// Check if function is already defined
    		if(isDefinedFunction(id)) {
    			exceptions.add(new DuplicateFunctionException(id));
    		} else { ((Environment_scope)Environment_stack.elementAt(depth)).functions.put(id.getText(), args); }
    	}

    	/**
    	 * Check if a function is defined
    	 * @param name: Function name
    	 */
    	boolean isDefinedFunction(CommonTree id) {
    		for(int i=Environment_stack.size()-1; i>=0; i--) {
    			if(((Environment_scope)Environment_stack.elementAt(i)).functions.containsKey(id.getText())) {
    				return true; 
    			}
    		} return false;
    	}
    	
    	/**
    	 * Retrieve excepted function arguments
    	 * @param name: Function name
    	 */
    	int expectedArgs(CommonTree id) {
    		for(int i=Environment_stack.size()-1; i>=0; i--) {
    			if(((Environment_scope)Environment_stack.elementAt(i)).functions.containsKey(id.getText())) {
    				return ((Environment_scope)Environment_stack.elementAt(i)).functions.get(id.getText()); 
    			}
    		} return -1;
    	}
    	
    	/**
    	 * Define variable
    	 * @param name: Variable name
    	 */
    	void defineVariable(String name) {
    		((Environment_scope)Environment_stack.peek()).variables.add(name);
    	}

    	/**
    	 * Check if variable is defined
    	 * @param name: Variable name
    	 */
    	boolean isDefinedVariable(String name) {
    		for(int i=Environment_stack.size()-1; i>=0; i--) {
    			if(((Environment_scope)Environment_stack.elementAt(i)).variables.contains(name)) { 
    				return true; 
    			}
    		} return false;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:203:1: module : ^( 'module' moduleId ( imprt )* ( site )* ( function )* ) ;
    public final WaebricChecker.module_return module() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.module_return retval = new WaebricChecker.module_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal1=null;
        WaebricChecker.moduleId_return moduleId2 = null;

        WaebricChecker.imprt_return imprt3 = null;

        WaebricChecker.site_return site4 = null;

        WaebricChecker.function_return function5 = null;


        CommonTree string_literal1_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new HashSet<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:208:4: ( ^( 'module' moduleId ( imprt )* ( site )* ( function )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:208:7: ^( 'module' moduleId ( imprt )* ( site )* ( function )* )
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:208:28: ( imprt )*
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

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:208:35: ( site )*
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

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:208:41: ( function )*
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:210:1: moduleId : id= IDCON ( '.' id= IDCON )* ;
    public final WaebricChecker.moduleId_return moduleId() throws RecognitionException {
        WaebricChecker.moduleId_return retval = new WaebricChecker.moduleId_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        CommonTree char_literal6=null;

        CommonTree id_tree=null;
        CommonTree char_literal6_tree=null;

         String path = ""; 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:213:2: (id= IDCON ( '.' id= IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:213:5: id= IDCON ( '.' id= IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_moduleId116); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (CommonTree)adaptor.dupNode(id);

            adaptor.addChild(root_0, id_tree);
            }
            if ( state.backtracking==0 ) {
               path = id.getText(); 
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:214:4: ( '.' id= IDCON )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==34) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:214:6: '.' id= IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal6=(CommonTree)match(input,34,FOLLOW_34_in_moduleId126); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal6_tree = (CommonTree)adaptor.dupNode(char_literal6);

            	    adaptor.addChild(root_0, char_literal6_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_moduleId130); if (state.failed) return retval;
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
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }
            if ( state.backtracking==0 ) {
               path += ".wae"; 
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            			java.io.File file = new java.io.File(path);
            			if(! file.isFile()) {
            				// Each import reference should be a valid file
            				exceptions.add(new NonExistingModuleException(((CommonTree)retval.tree)));
            			}
            		
        }
        return retval;
    }
    // $ANTLR end "moduleId"

    public static class imprt_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "imprt"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:223:1: imprt : 'import' moduleId ';' module ;
    public final WaebricChecker.imprt_return imprt() throws RecognitionException {
        WaebricChecker.imprt_return retval = new WaebricChecker.imprt_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal7=null;
        CommonTree char_literal9=null;
        WaebricChecker.moduleId_return moduleId8 = null;

        WaebricChecker.module_return module10 = null;


        CommonTree string_literal7_tree=null;
        CommonTree char_literal9_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:223:6: ( 'import' moduleId ';' module )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:223:10: 'import' moduleId ';' module
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal7=(CommonTree)match(input,35,FOLLOW_35_in_imprt151); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal7_tree = (CommonTree)adaptor.dupNode(string_literal7);

            adaptor.addChild(root_0, string_literal7_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_moduleId_in_imprt153);
            moduleId8=moduleId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, moduleId8.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal9=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_imprt155); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal9_tree = (CommonTree)adaptor.dupNode(char_literal9);

            root_0 = (CommonTree)adaptor.becomeRoot(char_literal9_tree, root_0);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_module_in_imprt159);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:227:1: site : 'site' mappings 'end' ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:227:5: ( 'site' mappings 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:227:9: 'site' mappings 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal11=(CommonTree)match(input,SITE,FOLLOW_SITE_in_site171); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal11_tree = (CommonTree)adaptor.dupNode(string_literal11);

            adaptor.addChild(root_0, string_literal11_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_mappings_in_site173);
            mappings12=mappings();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, mappings12.getTree());
            _last = (CommonTree)input.LT(1);
            string_literal13=(CommonTree)match(input,END,FOLLOW_END_in_site175); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:228:1: mappings : ( mapping )? ( ';' mapping )* ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:228:9: ( ( mapping )? ( ';' mapping )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:228:12: ( mapping )? ( ';' mapping )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:228:12: ( mapping )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==PATH) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: mapping
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_mapping_in_mappings183);
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

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:228:21: ( ';' mapping )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==SEMICOLON) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:228:23: ';' mapping
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal15=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_mappings188); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal15_tree = (CommonTree)adaptor.dupNode(char_literal15);

            	    adaptor.addChild(root_0, char_literal15_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_mapping_in_mappings190);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:229:1: mapping : PATH ':' markup ;
    public final WaebricChecker.mapping_return mapping() throws RecognitionException {
        WaebricChecker.mapping_return retval = new WaebricChecker.mapping_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PATH17=null;
        CommonTree char_literal18=null;
        WaebricChecker.markup_return markup19 = null;


        CommonTree PATH17_tree=null;
        CommonTree char_literal18_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:229:9: ( PATH ':' markup )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:229:12: PATH ':' markup
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PATH17=(CommonTree)match(input,PATH,FOLLOW_PATH_in_mapping202); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PATH17_tree = (CommonTree)adaptor.dupNode(PATH17);

            adaptor.addChild(root_0, PATH17_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal18=(CommonTree)match(input,36,FOLLOW_36_in_mapping204); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal18_tree = (CommonTree)adaptor.dupNode(char_literal18);

            adaptor.addChild(root_0, char_literal18_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_markup_in_mapping206);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:233:1: markup : designator ( arguments )? ;
    public final WaebricChecker.markup_return markup() throws RecognitionException {
        WaebricChecker.markup_return retval = new WaebricChecker.markup_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricChecker.designator_return designator20 = null;

        WaebricChecker.arguments_return arguments21 = null;



         int args = 0; 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:235:2: ( designator ( arguments )? )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:235:5: designator ( arguments )?
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_designator_in_markup225);
            designator20=designator();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, designator20.getTree());
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:235:16: ( arguments )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==41) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:235:18: arguments
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_arguments_in_markup229);
                    arguments21=arguments();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, arguments21.getTree());
                    if ( state.backtracking==0 ) {
                       args = (arguments21!=null?arguments21.args:0); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              				// Store function call
              				Call call = new Call();
              				call.id = (designator20!=null?((CommonTree)designator20.tree):null);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:244:1: designator : IDCON ( attribute )* ;
    public final WaebricChecker.designator_return designator() throws RecognitionException {
        WaebricChecker.designator_return retval = new WaebricChecker.designator_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON22=null;
        WaebricChecker.attribute_return attribute23 = null;


        CommonTree IDCON22_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:244:11: ( IDCON ( attribute )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:244:14: IDCON ( attribute )*
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON22=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_designator248); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON22_tree = (CommonTree)adaptor.dupNode(IDCON22);

            adaptor.addChild(root_0, IDCON22_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:244:20: ( attribute )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==36) ) {
                    int LA8_2 = input.LA(2);

                    if ( (LA8_2==IDCON) ) {
                        int LA8_4 = input.LA(3);

                        if ( (synpred8_WaebricChecker()) ) {
                            alt8=1;
                        }


                    }


                }
                else if ( (LA8_0==34||(LA8_0>=37 && LA8_0<=39)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: attribute
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_attribute_in_designator250);
            	    attribute23=attribute();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, attribute23.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:246:1: attribute : ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON ( '%' NATCON )? );
    public final WaebricChecker.attribute_return attribute() throws RecognitionException {
        WaebricChecker.attribute_return retval = new WaebricChecker.attribute_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal24=null;
        CommonTree IDCON25=null;
        CommonTree char_literal26=null;
        CommonTree IDCON27=null;
        CommonTree char_literal28=null;
        CommonTree IDCON29=null;
        CommonTree char_literal30=null;
        CommonTree IDCON31=null;
        CommonTree char_literal32=null;
        CommonTree NATCON33=null;
        CommonTree char_literal34=null;
        CommonTree NATCON35=null;

        CommonTree char_literal24_tree=null;
        CommonTree IDCON25_tree=null;
        CommonTree char_literal26_tree=null;
        CommonTree IDCON27_tree=null;
        CommonTree char_literal28_tree=null;
        CommonTree IDCON29_tree=null;
        CommonTree char_literal30_tree=null;
        CommonTree IDCON31_tree=null;
        CommonTree char_literal32_tree=null;
        CommonTree NATCON33_tree=null;
        CommonTree char_literal34_tree=null;
        CommonTree NATCON35_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:246:10: ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON ( '%' NATCON )? )
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:246:13: '#' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal24=(CommonTree)match(input,37,FOLLOW_37_in_attribute260); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal24_tree = (CommonTree)adaptor.dupNode(char_literal24);

                    adaptor.addChild(root_0, char_literal24_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON25=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute262); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON25_tree = (CommonTree)adaptor.dupNode(IDCON25);

                    adaptor.addChild(root_0, IDCON25_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:247:7: '.' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal26=(CommonTree)match(input,34,FOLLOW_34_in_attribute271); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal26_tree = (CommonTree)adaptor.dupNode(char_literal26);

                    adaptor.addChild(root_0, char_literal26_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON27=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute273); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON27_tree = (CommonTree)adaptor.dupNode(IDCON27);

                    adaptor.addChild(root_0, IDCON27_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:248:7: '$' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal28=(CommonTree)match(input,38,FOLLOW_38_in_attribute282); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal28_tree = (CommonTree)adaptor.dupNode(char_literal28);

                    adaptor.addChild(root_0, char_literal28_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON29=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute284); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON29_tree = (CommonTree)adaptor.dupNode(IDCON29);

                    adaptor.addChild(root_0, IDCON29_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:249:7: ':' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal30=(CommonTree)match(input,36,FOLLOW_36_in_attribute293); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal30_tree = (CommonTree)adaptor.dupNode(char_literal30);

                    adaptor.addChild(root_0, char_literal30_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON31=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute295); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON31_tree = (CommonTree)adaptor.dupNode(IDCON31);

                    adaptor.addChild(root_0, IDCON31_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:250:7: '@' NATCON ( '%' NATCON )?
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal32=(CommonTree)match(input,39,FOLLOW_39_in_attribute304); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal32_tree = (CommonTree)adaptor.dupNode(char_literal32);

                    adaptor.addChild(root_0, char_literal32_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    NATCON33=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_attribute306); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON33_tree = (CommonTree)adaptor.dupNode(NATCON33);

                    adaptor.addChild(root_0, NATCON33_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:250:18: ( '%' NATCON )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==40) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:250:20: '%' NATCON
                            {
                            _last = (CommonTree)input.LT(1);
                            char_literal34=(CommonTree)match(input,40,FOLLOW_40_in_attribute310); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal34_tree = (CommonTree)adaptor.dupNode(char_literal34);

                            adaptor.addChild(root_0, char_literal34_tree);
                            }
                            _last = (CommonTree)input.LT(1);
                            NATCON35=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_attribute312); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NATCON35_tree = (CommonTree)adaptor.dupNode(NATCON35);

                            adaptor.addChild(root_0, NATCON35_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:252:1: arguments returns [int args = 0] : '(' ( expression )? ( ',' expression )* ')' ;
    public final WaebricChecker.arguments_return arguments() throws RecognitionException {
        WaebricChecker.arguments_return retval = new WaebricChecker.arguments_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal36=null;
        CommonTree char_literal38=null;
        CommonTree char_literal40=null;
        WaebricChecker.expression_return expression37 = null;

        WaebricChecker.expression_return expression39 = null;


        CommonTree char_literal36_tree=null;
        CommonTree char_literal38_tree=null;
        CommonTree char_literal40_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:253:2: ( '(' ( expression )? ( ',' expression )* ')' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:253:5: '(' ( expression )? ( ',' expression )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            char_literal36=(CommonTree)match(input,41,FOLLOW_41_in_arguments330); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal36_tree = (CommonTree)adaptor.dupNode(char_literal36);

            adaptor.addChild(root_0, char_literal36_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:253:9: ( expression )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==IDCON||(LA11_0>=NATCON && LA11_0<=SYMBOLCON)||LA11_0==44||LA11_0==46) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:253:11: expression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_arguments334);
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

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:254:4: ( ',' expression )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==42) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:254:6: ',' expression
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal38=(CommonTree)match(input,42,FOLLOW_42_in_arguments347); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal38_tree = (CommonTree)adaptor.dupNode(char_literal38);

            	    adaptor.addChild(root_0, char_literal38_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expression_in_arguments349);
            	    expression39=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, expression39.getTree());
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
            char_literal40=(CommonTree)match(input,43,FOLLOW_43_in_arguments356); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal40_tree = (CommonTree)adaptor.dupNode(char_literal40);

            adaptor.addChild(root_0, char_literal40_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:260:1: expression : ( varExpression | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* ;
    public final WaebricChecker.expression_return expression() throws RecognitionException {
        WaebricChecker.expression_return retval = new WaebricChecker.expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NATCON42=null;
        CommonTree TEXT43=null;
        CommonTree SYMBOLCON44=null;
        CommonTree char_literal45=null;
        CommonTree char_literal47=null;
        CommonTree char_literal49=null;
        CommonTree char_literal50=null;
        CommonTree char_literal52=null;
        CommonTree char_literal54=null;
        CommonTree char_literal55=null;
        CommonTree char_literal57=null;
        CommonTree IDCON58=null;
        WaebricChecker.varExpression_return varExpression41 = null;

        WaebricChecker.expression_return expression46 = null;

        WaebricChecker.expression_return expression48 = null;

        WaebricChecker.keyValuePair_return keyValuePair51 = null;

        WaebricChecker.keyValuePair_return keyValuePair53 = null;

        WaebricChecker.expression_return expression56 = null;


        CommonTree NATCON42_tree=null;
        CommonTree TEXT43_tree=null;
        CommonTree SYMBOLCON44_tree=null;
        CommonTree char_literal45_tree=null;
        CommonTree char_literal47_tree=null;
        CommonTree char_literal49_tree=null;
        CommonTree char_literal50_tree=null;
        CommonTree char_literal52_tree=null;
        CommonTree char_literal54_tree=null;
        CommonTree char_literal55_tree=null;
        CommonTree char_literal57_tree=null;
        CommonTree IDCON58_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:260:11: ( ( varExpression | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:260:14: ( varExpression | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:260:14: ( varExpression | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' )
            int alt17=6;
            switch ( input.LA(1) ) {
            case IDCON:
                {
                alt17=1;
                }
                break;
            case NATCON:
                {
                alt17=2;
                }
                break;
            case TEXT:
                {
                alt17=3;
                }
                break;
            case SYMBOLCON:
                {
                alt17=4;
                }
                break;
            case 44:
                {
                alt17=5;
                }
                break;
            case 46:
                {
                alt17=6;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:260:16: varExpression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_varExpression_in_expression371);
                    varExpression41=varExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, varExpression41.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:260:32: NATCON
                    {
                    _last = (CommonTree)input.LT(1);
                    NATCON42=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_expression375); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON42_tree = (CommonTree)adaptor.dupNode(NATCON42);

                    adaptor.addChild(root_0, NATCON42_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:260:41: TEXT
                    {
                    _last = (CommonTree)input.LT(1);
                    TEXT43=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_expression379); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TEXT43_tree = (CommonTree)adaptor.dupNode(TEXT43);

                    adaptor.addChild(root_0, TEXT43_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:260:48: SYMBOLCON
                    {
                    _last = (CommonTree)input.LT(1);
                    SYMBOLCON44=(CommonTree)match(input,SYMBOLCON,FOLLOW_SYMBOLCON_in_expression383); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SYMBOLCON44_tree = (CommonTree)adaptor.dupNode(SYMBOLCON44);

                    adaptor.addChild(root_0, SYMBOLCON44_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:261:7: '[' ( expression )? ( ',' expression )* ']'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal45=(CommonTree)match(input,44,FOLLOW_44_in_expression392); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal45_tree = (CommonTree)adaptor.dupNode(char_literal45);

                    adaptor.addChild(root_0, char_literal45_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:261:11: ( expression )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==IDCON||(LA13_0>=NATCON && LA13_0<=SYMBOLCON)||LA13_0==44||LA13_0==46) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: expression
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_expression_in_expression394);
                            expression46=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, expression46.getTree());

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:261:23: ( ',' expression )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==42) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:261:25: ',' expression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal47=(CommonTree)match(input,42,FOLLOW_42_in_expression399); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal47_tree = (CommonTree)adaptor.dupNode(char_literal47);

                    	    adaptor.addChild(root_0, char_literal47_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_expression_in_expression401);
                    	    expression48=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, expression48.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal49=(CommonTree)match(input,45,FOLLOW_45_in_expression406); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal49_tree = (CommonTree)adaptor.dupNode(char_literal49);

                    adaptor.addChild(root_0, char_literal49_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:262:7: '{' ( keyValuePair )? ( ',' keyValuePair )* '}'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal50=(CommonTree)match(input,46,FOLLOW_46_in_expression415); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal50_tree = (CommonTree)adaptor.dupNode(char_literal50);

                    adaptor.addChild(root_0, char_literal50_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:262:11: ( keyValuePair )?
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
                            pushFollow(FOLLOW_keyValuePair_in_expression417);
                            keyValuePair51=keyValuePair();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, keyValuePair51.getTree());

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:262:25: ( ',' keyValuePair )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==42) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:262:27: ',' keyValuePair
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal52=(CommonTree)match(input,42,FOLLOW_42_in_expression422); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal52_tree = (CommonTree)adaptor.dupNode(char_literal52);

                    	    adaptor.addChild(root_0, char_literal52_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_keyValuePair_in_expression424);
                    	    keyValuePair53=keyValuePair();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, keyValuePair53.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal54=(CommonTree)match(input,47,FOLLOW_47_in_expression429); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal54_tree = (CommonTree)adaptor.dupNode(char_literal54);

                    adaptor.addChild(root_0, char_literal54_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:263:6: ( '+' expression | '.' IDCON )*
            loop18:
            do {
                int alt18=3;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==48) ) {
                    int LA18_2 = input.LA(2);

                    if ( (synpred25_WaebricChecker()) ) {
                        alt18=1;
                    }


                }
                else if ( (LA18_0==34) ) {
                    int LA18_3 = input.LA(2);

                    if ( (synpred26_WaebricChecker()) ) {
                        alt18=2;
                    }


                }


                switch (alt18) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:263:8: '+' expression
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal55=(CommonTree)match(input,48,FOLLOW_48_in_expression439); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal55_tree = (CommonTree)adaptor.dupNode(char_literal55);

            	    adaptor.addChild(root_0, char_literal55_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expression_in_expression441);
            	    expression56=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, expression56.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:263:25: '.' IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal57=(CommonTree)match(input,34,FOLLOW_34_in_expression445); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal57_tree = (CommonTree)adaptor.dupNode(char_literal57);

            	    adaptor.addChild(root_0, char_literal57_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    IDCON58=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression447); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDCON58_tree = (CommonTree)adaptor.dupNode(IDCON58);

            	    adaptor.addChild(root_0, IDCON58_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:265:1: varExpression : IDCON ;
    public final WaebricChecker.varExpression_return varExpression() throws RecognitionException {
        WaebricChecker.varExpression_return retval = new WaebricChecker.varExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON59=null;

        CommonTree IDCON59_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:265:14: ( IDCON )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:265:17: IDCON
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON59=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_varExpression459); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON59_tree = (CommonTree)adaptor.dupNode(IDCON59);

            adaptor.addChild(root_0, IDCON59_tree);
            }
            if ( state.backtracking==0 ) {

              				if(! isDefinedVariable(IDCON59.getText())) {
              					exceptions.add(new UndefinedVariableException(IDCON59_tree));
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:271:1: keyValuePair : IDCON ':' expression ;
    public final WaebricChecker.keyValuePair_return keyValuePair() throws RecognitionException {
        WaebricChecker.keyValuePair_return retval = new WaebricChecker.keyValuePair_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON60=null;
        CommonTree char_literal61=null;
        WaebricChecker.expression_return expression62 = null;


        CommonTree IDCON60_tree=null;
        CommonTree char_literal61_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:271:13: ( IDCON ':' expression )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:271:16: IDCON ':' expression
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON60=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_keyValuePair473); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON60_tree = (CommonTree)adaptor.dupNode(IDCON60);

            adaptor.addChild(root_0, IDCON60_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal61=(CommonTree)match(input,36,FOLLOW_36_in_keyValuePair475); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal61_tree = (CommonTree)adaptor.dupNode(char_literal61);

            adaptor.addChild(root_0, char_literal61_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_keyValuePair477);
            expression62=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, expression62.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:275:1: function : 'def' IDCON formals ( statement )* 'end' ;
    public final WaebricChecker.function_return function() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.function_return retval = new WaebricChecker.function_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal63=null;
        CommonTree IDCON64=null;
        CommonTree string_literal67=null;
        WaebricChecker.formals_return formals65 = null;

        WaebricChecker.statement_return statement66 = null;


        CommonTree string_literal63_tree=null;
        CommonTree IDCON64_tree=null;
        CommonTree string_literal67_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new HashSet<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:280:4: ( 'def' IDCON formals ( statement )* 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:280:7: 'def' IDCON formals ( statement )* 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal63=(CommonTree)match(input,49,FOLLOW_49_in_function501); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal63_tree = (CommonTree)adaptor.dupNode(string_literal63);

            adaptor.addChild(root_0, string_literal63_tree);
            }
            _last = (CommonTree)input.LT(1);
            IDCON64=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_function503); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON64_tree = (CommonTree)adaptor.dupNode(IDCON64);

            adaptor.addChild(root_0, IDCON64_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_formals_in_function505);
            formals65=formals();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, formals65.getTree());
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:280:27: ( statement )*
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
            	    pushFollow(FOLLOW_statement_in_function507);
            	    statement66=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, statement66.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            string_literal67=(CommonTree)match(input,END,FOLLOW_END_in_function510); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal67_tree = (CommonTree)adaptor.dupNode(string_literal67);

            adaptor.addChild(root_0, string_literal67_tree);
            }
            if ( state.backtracking==0 ) {
               
              				defineFunction(IDCON64, (formals65!=null?formals65.args:0), 0);
              			
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:284:1: formals returns [int args = 0] : ( regularFormals | );
    public final WaebricChecker.formals_return formals() throws RecognitionException {
        WaebricChecker.formals_return retval = new WaebricChecker.formals_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricChecker.regularFormals_return regularFormals68 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:284:32: ( regularFormals | )
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:285:4: regularFormals
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_regularFormals_in_formals531);
                    regularFormals68=regularFormals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, regularFormals68.getTree());
                    if ( state.backtracking==0 ) {
                       retval.args = (regularFormals68!=null?regularFormals68.args:0); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:286:26: 
                    {
                    root_0 = (CommonTree)adaptor.nil();

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:288:1: regularFormals returns [int args = 0] : '(' ( IDCON )* ')' ;
    public final WaebricChecker.regularFormals_return regularFormals() throws RecognitionException {
        WaebricChecker.regularFormals_return retval = new WaebricChecker.regularFormals_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal69=null;
        CommonTree IDCON70=null;
        CommonTree char_literal71=null;

        CommonTree char_literal69_tree=null;
        CommonTree IDCON70_tree=null;
        CommonTree char_literal71_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:288:38: ( '(' ( IDCON )* ')' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:289:4: '(' ( IDCON )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            char_literal69=(CommonTree)match(input,41,FOLLOW_41_in_regularFormals559); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal69_tree = (CommonTree)adaptor.dupNode(char_literal69);

            adaptor.addChild(root_0, char_literal69_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:289:8: ( IDCON )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==IDCON) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:289:10: IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    IDCON70=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_regularFormals563); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDCON70_tree = (CommonTree)adaptor.dupNode(IDCON70);

            	    adaptor.addChild(root_0, IDCON70_tree);
            	    }
            	    if ( state.backtracking==0 ) {
            	       defineVariable(IDCON70.getText()); retval.args++; 
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
            char_literal71=(CommonTree)match(input,43,FOLLOW_43_in_regularFormals570); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal71_tree = (CommonTree)adaptor.dupNode(char_literal71);

            adaptor.addChild(root_0, char_literal71_tree);
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

    public static class statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:293:1: statement : ( 'if' '(' predicate ')' statement 'else' statement | 'if' '(' predicate ')' statement | eachStatement | letStatement | '{' ( statement )* '}' | 'comment' STRCON ';' | 'echo' expression ';' | 'echo' embedding ';' | 'cdata' expression ';' | 'yield;' | ( markup )+ ':' expression ';' | ( markup )+ ':' statement | ( markup )+ embedding ';' | ( markup )+ ';' );
    public final WaebricChecker.statement_return statement() throws RecognitionException {
        WaebricChecker.statement_return retval = new WaebricChecker.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal72=null;
        CommonTree char_literal73=null;
        CommonTree char_literal75=null;
        CommonTree string_literal77=null;
        CommonTree string_literal79=null;
        CommonTree char_literal80=null;
        CommonTree char_literal82=null;
        CommonTree char_literal86=null;
        CommonTree char_literal88=null;
        CommonTree string_literal89=null;
        CommonTree STRCON90=null;
        CommonTree char_literal91=null;
        CommonTree string_literal92=null;
        CommonTree char_literal94=null;
        CommonTree string_literal95=null;
        CommonTree char_literal97=null;
        CommonTree string_literal98=null;
        CommonTree char_literal100=null;
        CommonTree string_literal101=null;
        CommonTree char_literal103=null;
        CommonTree char_literal105=null;
        CommonTree char_literal107=null;
        CommonTree char_literal111=null;
        CommonTree char_literal113=null;
        WaebricChecker.predicate_return predicate74 = null;

        WaebricChecker.statement_return statement76 = null;

        WaebricChecker.statement_return statement78 = null;

        WaebricChecker.predicate_return predicate81 = null;

        WaebricChecker.statement_return statement83 = null;

        WaebricChecker.eachStatement_return eachStatement84 = null;

        WaebricChecker.letStatement_return letStatement85 = null;

        WaebricChecker.statement_return statement87 = null;

        WaebricChecker.expression_return expression93 = null;

        WaebricChecker.embedding_return embedding96 = null;

        WaebricChecker.expression_return expression99 = null;

        WaebricChecker.markup_return markup102 = null;

        WaebricChecker.expression_return expression104 = null;

        WaebricChecker.markup_return markup106 = null;

        WaebricChecker.statement_return statement108 = null;

        WaebricChecker.markup_return markup109 = null;

        WaebricChecker.embedding_return embedding110 = null;

        WaebricChecker.markup_return markup112 = null;


        CommonTree string_literal72_tree=null;
        CommonTree char_literal73_tree=null;
        CommonTree char_literal75_tree=null;
        CommonTree string_literal77_tree=null;
        CommonTree string_literal79_tree=null;
        CommonTree char_literal80_tree=null;
        CommonTree char_literal82_tree=null;
        CommonTree char_literal86_tree=null;
        CommonTree char_literal88_tree=null;
        CommonTree string_literal89_tree=null;
        CommonTree STRCON90_tree=null;
        CommonTree char_literal91_tree=null;
        CommonTree string_literal92_tree=null;
        CommonTree char_literal94_tree=null;
        CommonTree string_literal95_tree=null;
        CommonTree char_literal97_tree=null;
        CommonTree string_literal98_tree=null;
        CommonTree char_literal100_tree=null;
        CommonTree string_literal101_tree=null;
        CommonTree char_literal103_tree=null;
        CommonTree char_literal105_tree=null;
        CommonTree char_literal107_tree=null;
        CommonTree char_literal111_tree=null;
        CommonTree char_literal113_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:293:10: ( 'if' '(' predicate ')' statement 'else' statement | 'if' '(' predicate ')' statement | eachStatement | letStatement | '{' ( statement )* '}' | 'comment' STRCON ';' | 'echo' expression ';' | 'echo' embedding ';' | 'cdata' expression ';' | 'yield;' | ( markup )+ ':' expression ';' | ( markup )+ ':' statement | ( markup )+ embedding ';' | ( markup )+ ';' )
            int alt27=14;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:293:13: 'if' '(' predicate ')' statement 'else' statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal72=(CommonTree)match(input,50,FOLLOW_50_in_statement581); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal72_tree = (CommonTree)adaptor.dupNode(string_literal72);

                    adaptor.addChild(root_0, string_literal72_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal73=(CommonTree)match(input,41,FOLLOW_41_in_statement583); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal73_tree = (CommonTree)adaptor.dupNode(char_literal73);

                    adaptor.addChild(root_0, char_literal73_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_statement585);
                    predicate74=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, predicate74.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal75=(CommonTree)match(input,43,FOLLOW_43_in_statement587); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal75_tree = (CommonTree)adaptor.dupNode(char_literal75);

                    adaptor.addChild(root_0, char_literal75_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement589);
                    statement76=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, statement76.getTree());
                    _last = (CommonTree)input.LT(1);
                    string_literal77=(CommonTree)match(input,51,FOLLOW_51_in_statement591); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal77_tree = (CommonTree)adaptor.dupNode(string_literal77);

                    adaptor.addChild(root_0, string_literal77_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement593);
                    statement78=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, statement78.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:294:6: 'if' '(' predicate ')' statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal79=(CommonTree)match(input,50,FOLLOW_50_in_statement600); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal79_tree = (CommonTree)adaptor.dupNode(string_literal79);

                    adaptor.addChild(root_0, string_literal79_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal80=(CommonTree)match(input,41,FOLLOW_41_in_statement602); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal80_tree = (CommonTree)adaptor.dupNode(char_literal80);

                    adaptor.addChild(root_0, char_literal80_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_statement604);
                    predicate81=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, predicate81.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal82=(CommonTree)match(input,43,FOLLOW_43_in_statement606); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal82_tree = (CommonTree)adaptor.dupNode(char_literal82);

                    adaptor.addChild(root_0, char_literal82_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement608);
                    statement83=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, statement83.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:295:6: eachStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_eachStatement_in_statement615);
                    eachStatement84=eachStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, eachStatement84.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:296:6: letStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_letStatement_in_statement622);
                    letStatement85=letStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, letStatement85.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:297:6: '{' ( statement )* '}'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal86=(CommonTree)match(input,46,FOLLOW_46_in_statement629); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal86_tree = (CommonTree)adaptor.dupNode(char_literal86);

                    adaptor.addChild(root_0, char_literal86_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:297:10: ( statement )*
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
                    	    pushFollow(FOLLOW_statement_in_statement631);
                    	    statement87=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, statement87.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal88=(CommonTree)match(input,47,FOLLOW_47_in_statement634); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal88_tree = (CommonTree)adaptor.dupNode(char_literal88);

                    adaptor.addChild(root_0, char_literal88_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:298:6: 'comment' STRCON ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal89=(CommonTree)match(input,COMMENT,FOLLOW_COMMENT_in_statement641); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal89_tree = (CommonTree)adaptor.dupNode(string_literal89);

                    adaptor.addChild(root_0, string_literal89_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    STRCON90=(CommonTree)match(input,STRCON,FOLLOW_STRCON_in_statement643); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRCON90_tree = (CommonTree)adaptor.dupNode(STRCON90);

                    adaptor.addChild(root_0, STRCON90_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal91=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement645); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal91_tree = (CommonTree)adaptor.dupNode(char_literal91);

                    adaptor.addChild(root_0, char_literal91_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:299:6: 'echo' expression ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal92=(CommonTree)match(input,55,FOLLOW_55_in_statement652); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal92_tree = (CommonTree)adaptor.dupNode(string_literal92);

                    adaptor.addChild(root_0, string_literal92_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement654);
                    expression93=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression93.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal94=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement656); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal94_tree = (CommonTree)adaptor.dupNode(char_literal94);

                    adaptor.addChild(root_0, char_literal94_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:300:6: 'echo' embedding ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal95=(CommonTree)match(input,55,FOLLOW_55_in_statement663); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal95_tree = (CommonTree)adaptor.dupNode(string_literal95);

                    adaptor.addChild(root_0, string_literal95_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement665);
                    embedding96=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, embedding96.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal97=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement667); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal97_tree = (CommonTree)adaptor.dupNode(char_literal97);

                    adaptor.addChild(root_0, char_literal97_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:301:6: 'cdata' expression ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal98=(CommonTree)match(input,56,FOLLOW_56_in_statement674); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal98_tree = (CommonTree)adaptor.dupNode(string_literal98);

                    adaptor.addChild(root_0, string_literal98_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement676);
                    expression99=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression99.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal100=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement678); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal100_tree = (CommonTree)adaptor.dupNode(char_literal100);

                    adaptor.addChild(root_0, char_literal100_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:302:6: 'yield;'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal101=(CommonTree)match(input,57,FOLLOW_57_in_statement685); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal101_tree = (CommonTree)adaptor.dupNode(string_literal101);

                    adaptor.addChild(root_0, string_literal101_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:303:6: ( markup )+ ':' expression ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:303:6: ( markup )+
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
                    	    pushFollow(FOLLOW_markup_in_statement692);
                    	    markup102=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup102.getTree());

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
                    char_literal103=(CommonTree)match(input,36,FOLLOW_36_in_statement695); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal103_tree = (CommonTree)adaptor.dupNode(char_literal103);

                    adaptor.addChild(root_0, char_literal103_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement697);
                    expression104=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression104.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal105=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement699); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal105_tree = (CommonTree)adaptor.dupNode(char_literal105);

                    adaptor.addChild(root_0, char_literal105_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:304:6: ( markup )+ ':' statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:304:6: ( markup )+
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
                    	    pushFollow(FOLLOW_markup_in_statement706);
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
                    	    if ( cnt24 >= 1 ) break loop24;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(24, input);
                                throw eee;
                        }
                        cnt24++;
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal107=(CommonTree)match(input,36,FOLLOW_36_in_statement709); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal107_tree = (CommonTree)adaptor.dupNode(char_literal107);

                    adaptor.addChild(root_0, char_literal107_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement711);
                    statement108=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, statement108.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:305:6: ( markup )+ embedding ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:305:6: ( markup )+
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
                    	    pushFollow(FOLLOW_markup_in_statement718);
                    	    markup109=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup109.getTree());

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
                    pushFollow(FOLLOW_embedding_in_statement721);
                    embedding110=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, embedding110.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal111=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement723); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal111_tree = (CommonTree)adaptor.dupNode(char_literal111);

                    adaptor.addChild(root_0, char_literal111_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:306:6: ( markup )+ ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:306:6: ( markup )+
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
                    	    pushFollow(FOLLOW_markup_in_statement730);
                    	    markup112=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup112.getTree());

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
                    char_literal113=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement733); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal113_tree = (CommonTree)adaptor.dupNode(char_literal113);

                    adaptor.addChild(root_0, char_literal113_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:308:1: eachStatement : 'each' '(' IDCON ':' expression ')' statement ;
    public final WaebricChecker.eachStatement_return eachStatement() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.eachStatement_return retval = new WaebricChecker.eachStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal114=null;
        CommonTree char_literal115=null;
        CommonTree IDCON116=null;
        CommonTree char_literal117=null;
        CommonTree char_literal119=null;
        WaebricChecker.expression_return expression118 = null;

        WaebricChecker.statement_return statement120 = null;


        CommonTree string_literal114_tree=null;
        CommonTree char_literal115_tree=null;
        CommonTree IDCON116_tree=null;
        CommonTree char_literal117_tree=null;
        CommonTree char_literal119_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new HashSet<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:313:4: ( 'each' '(' IDCON ':' expression ')' statement )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:313:7: 'each' '(' IDCON ':' expression ')' statement
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal114=(CommonTree)match(input,52,FOLLOW_52_in_eachStatement755); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal114_tree = (CommonTree)adaptor.dupNode(string_literal114);

            adaptor.addChild(root_0, string_literal114_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal115=(CommonTree)match(input,41,FOLLOW_41_in_eachStatement757); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal115_tree = (CommonTree)adaptor.dupNode(char_literal115);

            adaptor.addChild(root_0, char_literal115_tree);
            }
            _last = (CommonTree)input.LT(1);
            IDCON116=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_eachStatement759); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON116_tree = (CommonTree)adaptor.dupNode(IDCON116);

            adaptor.addChild(root_0, IDCON116_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal117=(CommonTree)match(input,36,FOLLOW_36_in_eachStatement761); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal117_tree = (CommonTree)adaptor.dupNode(char_literal117);

            adaptor.addChild(root_0, char_literal117_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_eachStatement763);
            expression118=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, expression118.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal119=(CommonTree)match(input,43,FOLLOW_43_in_eachStatement765); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal119_tree = (CommonTree)adaptor.dupNode(char_literal119);

            adaptor.addChild(root_0, char_literal119_tree);
            }
            if ( state.backtracking==0 ) {
               
              				defineVariable(IDCON116.getText()); // Define variable before statement is executed
              			
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_eachStatement769);
            statement120=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, statement120.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:317:1: letStatement : 'let' ( assignment[curr] )+ 'in' ( statement )* 'end' ;
    public final WaebricChecker.letStatement_return letStatement() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.letStatement_return retval = new WaebricChecker.letStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal121=null;
        CommonTree string_literal123=null;
        CommonTree string_literal125=null;
        WaebricChecker.assignment_return assignment122 = null;

        WaebricChecker.statement_return statement124 = null;


        CommonTree string_literal121_tree=null;
        CommonTree string_literal123_tree=null;
        CommonTree string_literal125_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new HashSet<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        		int curr = Environment_stack.size()-1;
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:323:4: ( 'let' ( assignment[curr] )+ 'in' ( statement )* 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:323:7: 'let' ( assignment[curr] )+ 'in' ( statement )* 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal121=(CommonTree)match(input,53,FOLLOW_53_in_letStatement791); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal121_tree = (CommonTree)adaptor.dupNode(string_literal121);

            adaptor.addChild(root_0, string_literal121_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:323:13: ( assignment[curr] )+
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
            	    pushFollow(FOLLOW_assignment_in_letStatement793);
            	    assignment122=assignment(curr);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, assignment122.getTree());

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
            string_literal123=(CommonTree)match(input,54,FOLLOW_54_in_letStatement797); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal123_tree = (CommonTree)adaptor.dupNode(string_literal123);

            adaptor.addChild(root_0, string_literal123_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:323:36: ( statement )*
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
            	    pushFollow(FOLLOW_statement_in_letStatement799);
            	    statement124=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, statement124.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            string_literal125=(CommonTree)match(input,END,FOLLOW_END_in_letStatement802); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal125_tree = (CommonTree)adaptor.dupNode(string_literal125);

            adaptor.addChild(root_0, string_literal125_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:325:1: assignment[int depth] : ( varBinding | funcBinding[depth] );
    public final WaebricChecker.assignment_return assignment(int depth) throws RecognitionException {
        WaebricChecker.assignment_return retval = new WaebricChecker.assignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricChecker.varBinding_return varBinding126 = null;

        WaebricChecker.funcBinding_return funcBinding127 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:325:23: ( varBinding | funcBinding[depth] )
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:326:4: varBinding
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_varBinding_in_assignment816);
                    varBinding126=varBinding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, varBinding126.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:326:17: funcBinding[depth]
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_funcBinding_in_assignment820);
                    funcBinding127=funcBinding(depth);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, funcBinding127.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:328:1: varBinding : IDCON '=' expression ';' ;
    public final WaebricChecker.varBinding_return varBinding() throws RecognitionException {
        WaebricChecker.varBinding_return retval = new WaebricChecker.varBinding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON128=null;
        CommonTree char_literal129=null;
        CommonTree char_literal131=null;
        WaebricChecker.expression_return expression130 = null;


        CommonTree IDCON128_tree=null;
        CommonTree char_literal129_tree=null;
        CommonTree char_literal131_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:328:11: ( IDCON '=' expression ';' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:328:14: IDCON '=' expression ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON128=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_varBinding830); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON128_tree = (CommonTree)adaptor.dupNode(IDCON128);

            adaptor.addChild(root_0, IDCON128_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal129=(CommonTree)match(input,58,FOLLOW_58_in_varBinding832); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal129_tree = (CommonTree)adaptor.dupNode(char_literal129);

            adaptor.addChild(root_0, char_literal129_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_varBinding834);
            expression130=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, expression130.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal131=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_varBinding836); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal131_tree = (CommonTree)adaptor.dupNode(char_literal131);

            adaptor.addChild(root_0, char_literal131_tree);
            }
            if ( state.backtracking==0 ) {
               
              				defineVariable(IDCON128.getText()); 
              			
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:332:1: funcBinding[int depth] : IDCON regularFormals statement ;
    public final WaebricChecker.funcBinding_return funcBinding(int depth) throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.funcBinding_return retval = new WaebricChecker.funcBinding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON132=null;
        WaebricChecker.regularFormals_return regularFormals133 = null;

        WaebricChecker.statement_return statement134 = null;


        CommonTree IDCON132_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new HashSet<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:337:4: ( IDCON regularFormals statement )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:337:7: IDCON regularFormals statement
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON132=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_funcBinding865); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON132_tree = (CommonTree)adaptor.dupNode(IDCON132);

            adaptor.addChild(root_0, IDCON132_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_regularFormals_in_funcBinding867);
            regularFormals133=regularFormals();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, regularFormals133.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_funcBinding869);
            statement134=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, statement134.getTree());
            if ( state.backtracking==0 ) {
               defineFunction(IDCON132, (regularFormals133!=null?regularFormals133.args:0), depth); 
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:341:1: predicate : ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )* ;
    public final WaebricChecker.predicate_return predicate() throws RecognitionException {
        WaebricChecker.predicate_return retval = new WaebricChecker.predicate_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal135=null;
        CommonTree char_literal139=null;
        CommonTree string_literal141=null;
        CommonTree string_literal143=null;
        WaebricChecker.predicate_return predicate136 = null;

        WaebricChecker.expression_return expression137 = null;

        WaebricChecker.expression_return expression138 = null;

        WaebricChecker.type_return type140 = null;

        WaebricChecker.predicate_return predicate142 = null;

        WaebricChecker.predicate_return predicate144 = null;


        CommonTree char_literal135_tree=null;
        CommonTree char_literal139_tree=null;
        CommonTree string_literal141_tree=null;
        CommonTree string_literal143_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:341:10: ( ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:341:13: ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:341:13: ( '!' predicate | expression | expression '.' type )
            int alt31=3;
            alt31 = dfa31.predict(input);
            switch (alt31) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:341:15: '!' predicate
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal135=(CommonTree)match(input,59,FOLLOW_59_in_predicate884); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal135_tree = (CommonTree)adaptor.dupNode(char_literal135);

                    adaptor.addChild(root_0, char_literal135_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_predicate886);
                    predicate136=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, predicate136.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:342:7: expression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate895);
                    expression137=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression137.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:343:7: expression '.' type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate903);
                    expression138=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression138.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal139=(CommonTree)match(input,34,FOLLOW_34_in_predicate905); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal139_tree = (CommonTree)adaptor.dupNode(char_literal139);

                    adaptor.addChild(root_0, char_literal139_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_predicate907);
                    type140=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, type140.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:344:6: ( '&&' predicate | '||' predicate )*
            loop32:
            do {
                int alt32=3;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==60) ) {
                    int LA32_2 = input.LA(2);

                    if ( (synpred53_WaebricChecker()) ) {
                        alt32=1;
                    }


                }
                else if ( (LA32_0==61) ) {
                    int LA32_3 = input.LA(2);

                    if ( (synpred54_WaebricChecker()) ) {
                        alt32=2;
                    }


                }


                switch (alt32) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:344:8: '&&' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal141=(CommonTree)match(input,60,FOLLOW_60_in_predicate916); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal141_tree = (CommonTree)adaptor.dupNode(string_literal141);

            	    adaptor.addChild(root_0, string_literal141_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate918);
            	    predicate142=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, predicate142.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:344:25: '||' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal143=(CommonTree)match(input,61,FOLLOW_61_in_predicate922); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal143_tree = (CommonTree)adaptor.dupNode(string_literal143);

            	    adaptor.addChild(root_0, string_literal143_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate924);
            	    predicate144=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, predicate144.getTree());

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

    public static class type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:345:1: type : ( 'list' | 'record' | 'string' );
    public final WaebricChecker.type_return type() throws RecognitionException {
        WaebricChecker.type_return retval = new WaebricChecker.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set145=null;

        CommonTree set145_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:345:5: ( 'list' | 'record' | 'string' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            set145=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=62 && input.LA(1)<=64) ) {
                input.consume();

                if ( state.backtracking==0 ) {
                set145_tree = (CommonTree)adaptor.dupNode(set145);

                adaptor.addChild(root_0, set145_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:351:1: embedding : PRETEXT embed textTail ;
    public final WaebricChecker.embedding_return embedding() throws RecognitionException {
        WaebricChecker.embedding_return retval = new WaebricChecker.embedding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PRETEXT146=null;
        WaebricChecker.embed_return embed147 = null;

        WaebricChecker.textTail_return textTail148 = null;


        CommonTree PRETEXT146_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:351:10: ( PRETEXT embed textTail )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:351:13: PRETEXT embed textTail
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PRETEXT146=(CommonTree)match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding959); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRETEXT146_tree = (CommonTree)adaptor.dupNode(PRETEXT146);

            adaptor.addChild(root_0, PRETEXT146_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_embed_in_embedding961);
            embed147=embed();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, embed147.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_textTail_in_embedding963);
            textTail148=textTail();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, textTail148.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:352:1: embed : ( ( markup )* expression | ( markup )* markup );
    public final WaebricChecker.embed_return embed() throws RecognitionException {
        WaebricChecker.embed_return retval = new WaebricChecker.embed_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricChecker.markup_return markup149 = null;

        WaebricChecker.expression_return expression150 = null;

        WaebricChecker.markup_return markup151 = null;

        WaebricChecker.markup_return markup152 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:352:6: ( ( markup )* expression | ( markup )* markup )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==IDCON) ) {
                int LA35_1 = input.LA(2);

                if ( (synpred58_WaebricChecker()) ) {
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
            else if ( ((LA35_0>=NATCON && LA35_0<=SYMBOLCON)||LA35_0==44||LA35_0==46) ) {
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:352:10: ( markup )* expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:352:10: ( markup )*
                    loop33:
                    do {
                        int alt33=2;
                        alt33 = dfa33.predict(input);
                        switch (alt33) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed972);
                    	    markup149=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup149.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_embed975);
                    expression150=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression150.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:352:31: ( markup )* markup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:352:31: ( markup )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==IDCON) ) {
                            int LA34_1 = input.LA(2);

                            if ( (synpred59_WaebricChecker()) ) {
                                alt34=1;
                            }


                        }


                        switch (alt34) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed979);
                    	    markup151=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup151.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_embed982);
                    markup152=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, markup152.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:353:1: textTail : ( POSTTEXT | MIDTEXT embed textTail );
    public final WaebricChecker.textTail_return textTail() throws RecognitionException {
        WaebricChecker.textTail_return retval = new WaebricChecker.textTail_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POSTTEXT153=null;
        CommonTree MIDTEXT154=null;
        WaebricChecker.embed_return embed155 = null;

        WaebricChecker.textTail_return textTail156 = null;


        CommonTree POSTTEXT153_tree=null;
        CommonTree MIDTEXT154_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:353:9: ( POSTTEXT | MIDTEXT embed textTail )
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:353:12: POSTTEXT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    POSTTEXT153=(CommonTree)match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail990); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    POSTTEXT153_tree = (CommonTree)adaptor.dupNode(POSTTEXT153);

                    adaptor.addChild(root_0, POSTTEXT153_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:353:23: MIDTEXT embed textTail
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    MIDTEXT154=(CommonTree)match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail994); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MIDTEXT154_tree = (CommonTree)adaptor.dupNode(MIDTEXT154);

                    adaptor.addChild(root_0, MIDTEXT154_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embed_in_textTail996);
                    embed155=embed();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, embed155.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_textTail_in_textTail998);
                    textTail156=textTail();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, textTail156.getTree());

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

    // $ANTLR start synpred8_WaebricChecker
    public final void synpred8_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:244:20: ( attribute )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:244:20: attribute
        {
        pushFollow(FOLLOW_attribute_in_synpred8_WaebricChecker250);
        attribute();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_WaebricChecker

    // $ANTLR start synpred25_WaebricChecker
    public final void synpred25_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:263:8: ( '+' expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:263:8: '+' expression
        {
        match(input,48,FOLLOW_48_in_synpred25_WaebricChecker439); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred25_WaebricChecker441);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_WaebricChecker

    // $ANTLR start synpred26_WaebricChecker
    public final void synpred26_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:263:25: ( '.' IDCON )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:263:25: '.' IDCON
        {
        match(input,34,FOLLOW_34_in_synpred26_WaebricChecker445); if (state.failed) return ;
        match(input,IDCON,FOLLOW_IDCON_in_synpred26_WaebricChecker447); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_WaebricChecker

    // $ANTLR start synpred30_WaebricChecker
    public final void synpred30_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:293:13: ( 'if' '(' predicate ')' statement 'else' statement )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:293:13: 'if' '(' predicate ')' statement 'else' statement
        {
        match(input,50,FOLLOW_50_in_synpred30_WaebricChecker581); if (state.failed) return ;
        match(input,41,FOLLOW_41_in_synpred30_WaebricChecker583); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred30_WaebricChecker585);
        predicate();

        state._fsp--;
        if (state.failed) return ;
        match(input,43,FOLLOW_43_in_synpred30_WaebricChecker587); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred30_WaebricChecker589);
        statement();

        state._fsp--;
        if (state.failed) return ;
        match(input,51,FOLLOW_51_in_synpred30_WaebricChecker591); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred30_WaebricChecker593);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_WaebricChecker

    // $ANTLR start synpred31_WaebricChecker
    public final void synpred31_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:294:6: ( 'if' '(' predicate ')' statement )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:294:6: 'if' '(' predicate ')' statement
        {
        match(input,50,FOLLOW_50_in_synpred31_WaebricChecker600); if (state.failed) return ;
        match(input,41,FOLLOW_41_in_synpred31_WaebricChecker602); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred31_WaebricChecker604);
        predicate();

        state._fsp--;
        if (state.failed) return ;
        match(input,43,FOLLOW_43_in_synpred31_WaebricChecker606); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred31_WaebricChecker608);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_WaebricChecker

    // $ANTLR start synpred37_WaebricChecker
    public final void synpred37_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:299:6: ( 'echo' expression ';' )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:299:6: 'echo' expression ';'
        {
        match(input,55,FOLLOW_55_in_synpred37_WaebricChecker652); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred37_WaebricChecker654);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred37_WaebricChecker656); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred37_WaebricChecker

    // $ANTLR start synpred38_WaebricChecker
    public final void synpred38_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:300:6: ( 'echo' embedding ';' )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:300:6: 'echo' embedding ';'
        {
        match(input,55,FOLLOW_55_in_synpred38_WaebricChecker663); if (state.failed) return ;
        pushFollow(FOLLOW_embedding_in_synpred38_WaebricChecker665);
        embedding();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred38_WaebricChecker667); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred38_WaebricChecker

    // $ANTLR start synpred42_WaebricChecker
    public final void synpred42_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:303:6: ( ( markup )+ ':' expression ';' )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:303:6: ( markup )+ ':' expression ';'
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:303:6: ( markup )+
        int cnt40=0;
        loop40:
        do {
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==IDCON) ) {
                alt40=1;
            }


            switch (alt40) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred42_WaebricChecker692);
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

        match(input,36,FOLLOW_36_in_synpred42_WaebricChecker695); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred42_WaebricChecker697);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred42_WaebricChecker699); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred42_WaebricChecker

    // $ANTLR start synpred44_WaebricChecker
    public final void synpred44_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:304:6: ( ( markup )+ ':' statement )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:304:6: ( markup )+ ':' statement
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:304:6: ( markup )+
        int cnt41=0;
        loop41:
        do {
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==IDCON) ) {
                alt41=1;
            }


            switch (alt41) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred44_WaebricChecker706);
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

        match(input,36,FOLLOW_36_in_synpred44_WaebricChecker709); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred44_WaebricChecker711);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred44_WaebricChecker

    // $ANTLR start synpred46_WaebricChecker
    public final void synpred46_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:305:6: ( ( markup )+ embedding ';' )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:305:6: ( markup )+ embedding ';'
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:305:6: ( markup )+
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
        	    pushFollow(FOLLOW_markup_in_synpred46_WaebricChecker718);
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

        pushFollow(FOLLOW_embedding_in_synpred46_WaebricChecker721);
        embedding();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred46_WaebricChecker723); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_WaebricChecker

    // $ANTLR start synpred52_WaebricChecker
    public final void synpred52_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:342:7: ( expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:342:7: expression
        {
        pushFollow(FOLLOW_expression_in_synpred52_WaebricChecker895);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred52_WaebricChecker

    // $ANTLR start synpred53_WaebricChecker
    public final void synpred53_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:344:8: ( '&&' predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:344:8: '&&' predicate
        {
        match(input,60,FOLLOW_60_in_synpred53_WaebricChecker916); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred53_WaebricChecker918);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred53_WaebricChecker

    // $ANTLR start synpred54_WaebricChecker
    public final void synpred54_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:344:25: ( '||' predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:344:25: '||' predicate
        {
        match(input,61,FOLLOW_61_in_synpred54_WaebricChecker922); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred54_WaebricChecker924);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred54_WaebricChecker

    // $ANTLR start synpred58_WaebricChecker
    public final void synpred58_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:352:10: ( ( markup )* expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:352:10: ( markup )* expression
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:352:10: ( markup )*
        loop43:
        do {
            int alt43=2;
            alt43 = dfa43.predict(input);
            switch (alt43) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred58_WaebricChecker972);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop43;
            }
        } while (true);

        pushFollow(FOLLOW_expression_in_synpred58_WaebricChecker975);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred58_WaebricChecker

    // $ANTLR start synpred59_WaebricChecker
    public final void synpred59_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:352:31: ( markup )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:352:31: markup
        {
        pushFollow(FOLLOW_markup_in_synpred59_WaebricChecker979);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred59_WaebricChecker

    // Delegated rules

    public final boolean synpred30_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_WaebricChecker_fragment(); // can never throw exception
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
    public final boolean synpred59_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred59_WaebricChecker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_WaebricChecker_fragment(); // can never throw exception
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
    public final boolean synpred8_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_WaebricChecker_fragment(); // can never throw exception
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
    public final boolean synpred58_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred58_WaebricChecker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_WaebricChecker_fragment(); // can never throw exception
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
    public final boolean synpred31_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_WaebricChecker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred46_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_WaebricChecker_fragment(); // can never throw exception
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


    protected DFA27 dfa27 = new DFA27(this);
    protected DFA31 dfa31 = new DFA31(this);
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA43 dfa43 = new DFA43(this);
    static final String DFA27_eotS =
        "\22\uffff";
    static final String DFA27_eofS =
        "\22\uffff";
    static final String DFA27_minS =
        "\1\4\1\0\4\uffff\1\0\2\uffff\1\0\10\uffff";
    static final String DFA27_maxS =
        "\1\71\1\0\4\uffff\1\0\2\uffff\1\0\10\uffff";
    static final String DFA27_acceptS =
        "\2\uffff\1\3\1\4\1\5\1\6\1\uffff\1\11\1\12\1\uffff\1\1\1\2\1\7\1"+
        "\10\1\13\1\14\1\15\1\16";
    static final String DFA27_specialS =
        "\1\uffff\1\0\4\uffff\1\1\2\uffff\1\2\10\uffff}>";
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
            return "293:1: statement : ( 'if' '(' predicate ')' statement 'else' statement | 'if' '(' predicate ')' statement | eachStatement | letStatement | '{' ( statement )* '}' | 'comment' STRCON ';' | 'echo' expression ';' | 'echo' embedding ';' | 'cdata' expression ';' | 'yield;' | ( markup )+ ':' expression ';' | ( markup )+ ':' statement | ( markup )+ embedding ';' | ( markup )+ ';' );";
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
                        if ( (synpred30_WaebricChecker()) ) {s = 10;}

                        else if ( (synpred31_WaebricChecker()) ) {s = 11;}

                         
                        input.seek(index27_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA27_6 = input.LA(1);

                         
                        int index27_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_WaebricChecker()) ) {s = 12;}

                        else if ( (synpred38_WaebricChecker()) ) {s = 13;}

                         
                        input.seek(index27_6);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA27_9 = input.LA(1);

                         
                        int index27_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_WaebricChecker()) ) {s = 14;}

                        else if ( (synpred44_WaebricChecker()) ) {s = 15;}

                        else if ( (synpred46_WaebricChecker()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
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
    static final String DFA31_eotS =
        "\12\uffff";
    static final String DFA31_eofS =
        "\12\uffff";
    static final String DFA31_minS =
        "\1\4\1\uffff\6\0\2\uffff";
    static final String DFA31_maxS =
        "\1\73\1\uffff\6\0\2\uffff";
    static final String DFA31_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\1\3";
    static final String DFA31_specialS =
        "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\2\uffff}>";
    static final String[] DFA31_transitionS = {
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
            return "341:13: ( '!' predicate | expression | expression '.' type )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TreeNodeStream input = (TreeNodeStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA31_2 = input.LA(1);

                         
                        int index31_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index31_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA31_3 = input.LA(1);

                         
                        int index31_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index31_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA31_4 = input.LA(1);

                         
                        int index31_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index31_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA31_5 = input.LA(1);

                         
                        int index31_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index31_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA31_6 = input.LA(1);

                         
                        int index31_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index31_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA31_7 = input.LA(1);

                         
                        int index31_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_WaebricChecker()) ) {s = 8;}

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
        "\2\4\1\uffff\1\4\1\uffff\1\4";
    static final String DFA33_maxS =
        "\1\56\1\60\1\uffff\1\4\1\uffff\1\60";
    static final String DFA33_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String DFA33_specialS =
        "\6\uffff}>";
    static final String[] DFA33_transitionS = {
            "\1\1\1\uffff\3\2\43\uffff\1\2\1\uffff\1\2",
            "\1\4\1\uffff\3\4\2\uffff\2\2\25\uffff\1\3\1\uffff\4\4\1\uffff"+
            "\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\2",
            "",
            "\1\5",
            "",
            "\1\4\1\uffff\3\4\2\uffff\2\2\25\uffff\1\3\1\uffff\4\4\1\uffff"+
            "\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\2"
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
            return "()* loopback of 352:10: ( markup )*";
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
            return "()* loopback of 352:10: ( markup )*";
        }
    }
 

    public static final BitSet FOLLOW_33_in_module77 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_moduleId_in_module79 = new BitSet(new long[]{0x0002000800004008L});
    public static final BitSet FOLLOW_imprt_in_module81 = new BitSet(new long[]{0x0002000800004008L});
    public static final BitSet FOLLOW_site_in_module84 = new BitSet(new long[]{0x0002000000004008L});
    public static final BitSet FOLLOW_function_in_module87 = new BitSet(new long[]{0x0002000000000008L});
    public static final BitSet FOLLOW_IDCON_in_moduleId116 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_moduleId126 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_moduleId130 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_35_in_imprt151 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_moduleId_in_imprt153 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_imprt155 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_module_in_imprt159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SITE_in_site171 = new BitSet(new long[]{0x0000000000018020L});
    public static final BitSet FOLLOW_mappings_in_site173 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_END_in_site175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapping_in_mappings183 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_SEMICOLON_in_mappings188 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_mapping_in_mappings190 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_PATH_in_mapping202 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_mapping204 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_mapping206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_designator_in_markup225 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_arguments_in_markup229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_designator248 = new BitSet(new long[]{0x000000F400000002L});
    public static final BitSet FOLLOW_attribute_in_designator250 = new BitSet(new long[]{0x000000F400000002L});
    public static final BitSet FOLLOW_37_in_attribute260 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_attribute271 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_attribute282 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_attribute293 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_attribute304 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NATCON_in_attribute306 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_attribute310 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NATCON_in_attribute312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_arguments330 = new BitSet(new long[]{0x00005C00000001D0L});
    public static final BitSet FOLLOW_expression_in_arguments334 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_42_in_arguments347 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_arguments349 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_43_in_arguments356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varExpression_in_expression371 = new BitSet(new long[]{0x0001000400000002L});
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
    public static final BitSet FOLLOW_34_in_expression445 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_expression447 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_IDCON_in_varExpression459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_keyValuePair473 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_keyValuePair475 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_keyValuePair477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_function501 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_function503 = new BitSet(new long[]{0x03B442000000A010L});
    public static final BitSet FOLLOW_formals_in_function505 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_statement_in_function507 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_END_in_function510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_regularFormals_in_formals531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_regularFormals559 = new BitSet(new long[]{0x0000080000000010L});
    public static final BitSet FOLLOW_IDCON_in_regularFormals563 = new BitSet(new long[]{0x0000080000000010L});
    public static final BitSet FOLLOW_43_in_regularFormals570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_statement581 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_statement583 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_statement585 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_statement587 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement589 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_statement591 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_statement600 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_statement602 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_statement604 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_statement606 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_eachStatement_in_statement615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_letStatement_in_statement622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_statement629 = new BitSet(new long[]{0x03B4C00000002010L});
    public static final BitSet FOLLOW_statement_in_statement631 = new BitSet(new long[]{0x03B4C00000002010L});
    public static final BitSet FOLLOW_47_in_statement634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMENT_in_statement641 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_STRCON_in_statement643 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_statement652 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_statement654 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_statement663 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_embedding_in_statement665 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_statement674 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_statement676 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_statement685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement692 = new BitSet(new long[]{0x0000001000000010L});
    public static final BitSet FOLLOW_36_in_statement695 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_statement697 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement706 = new BitSet(new long[]{0x0000001000000010L});
    public static final BitSet FOLLOW_36_in_statement709 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement718 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_embedding_in_statement721 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement730 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_eachStatement755 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_eachStatement757 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_eachStatement759 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_eachStatement761 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_eachStatement763 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_eachStatement765 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_eachStatement769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_letStatement791 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_assignment_in_letStatement793 = new BitSet(new long[]{0x0040000000000010L});
    public static final BitSet FOLLOW_54_in_letStatement797 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_statement_in_letStatement799 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_END_in_letStatement802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varBinding_in_assignment816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funcBinding_in_assignment820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_varBinding830 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_varBinding832 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_varBinding834 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_varBinding836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_funcBinding865 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_regularFormals_in_funcBinding867 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_funcBinding869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_predicate884 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_predicate886 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate895 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate903 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_predicate905 = new BitSet(new long[]{0xC000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_type_in_predicate907 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_60_in_predicate916 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_predicate918 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_61_in_predicate922 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_predicate924 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding959 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_embed_in_embedding961 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_textTail_in_embedding963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed972 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_embed975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed979 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_embed982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail994 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_embed_in_textTail996 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_textTail_in_textTail998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attribute_in_synpred8_WaebricChecker250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_synpred25_WaebricChecker439 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_synpred25_WaebricChecker441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_synpred26_WaebricChecker445 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_synpred26_WaebricChecker447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_synpred30_WaebricChecker581 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_synpred30_WaebricChecker583 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_synpred30_WaebricChecker585 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_synpred30_WaebricChecker587 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_synpred30_WaebricChecker589 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_synpred30_WaebricChecker591 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_synpred30_WaebricChecker593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_synpred31_WaebricChecker600 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_synpred31_WaebricChecker602 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_synpred31_WaebricChecker604 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_synpred31_WaebricChecker606 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_synpred31_WaebricChecker608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_synpred37_WaebricChecker652 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_synpred37_WaebricChecker654 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred37_WaebricChecker656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_synpred38_WaebricChecker663 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_embedding_in_synpred38_WaebricChecker665 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred38_WaebricChecker667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred42_WaebricChecker692 = new BitSet(new long[]{0x0000001000000010L});
    public static final BitSet FOLLOW_36_in_synpred42_WaebricChecker695 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_synpred42_WaebricChecker697 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred42_WaebricChecker699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred44_WaebricChecker706 = new BitSet(new long[]{0x0000001000000010L});
    public static final BitSet FOLLOW_36_in_synpred44_WaebricChecker709 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_synpred44_WaebricChecker711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred46_WaebricChecker718 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_embedding_in_synpred46_WaebricChecker721 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred46_WaebricChecker723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred52_WaebricChecker895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_synpred53_WaebricChecker916 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_synpred53_WaebricChecker918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred54_WaebricChecker922 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_synpred54_WaebricChecker924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred58_WaebricChecker972 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_synpred58_WaebricChecker975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred59_WaebricChecker979 = new BitSet(new long[]{0x0000000000000002L});

}