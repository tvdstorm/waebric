// $ANTLR 3.1.2 /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g 2009-08-16 10:41:55

	package org.cwi.waebric;
	import antlr.SemanticException;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class WaebricChecker extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATTRIBUTES", "ARGUMENTS", "MARKUP", "MARKUP_STATEMENT", "MARKUP_CHAIN", "FORMALS", "FUNCTION", "IDCON", "PATH", "NATCON", "TEXT", "SYMBOLCON", "STRCON", "PRETEXT", "POSTTEXT", "MIDTEXT", "COMMENT", "SITE", "END", "SEMICOLON", "LETTER", "DIGIT", "HEXADECIMAL", "PATHELEMENT", "FILEEXT", "STRCHAR", "ESCLAYOUT", "DECIMAL", "TEXTCHAR", "ESCQUOTE", "AMP", "CHARREF", "ENTREF", "SYMBOLCHAR", "COMMENTS", "LAYOUT", "'module'", "'.'", "'import'", "':'", "'#'", "'$'", "'@'", "'%'", "'('", "','", "')'", "'='", "'['", "']'", "'{'", "'}'", "'+'", "'if'", "'else'", "'each'", "'let'", "'in'", "'echo'", "'cdata'", "'yield;'", "'!'", "'&&'", "'||'", "'list'", "'record'", "'string'"
    };
    public static final int ESCLAYOUT=30;
    public static final int T__42=42;
    public static final int END=22;
    public static final int T__57=57;
    public static final int T__51=51;
    public static final int FILEEXT=28;
    public static final int T__69=69;
    public static final int T__47=47;
    public static final int T__50=50;
    public static final int STRCHAR=29;
    public static final int T__65=65;
    public static final int SYMBOLCON=15;
    public static final int COMMENTS=38;
    public static final int IDCON=11;
    public static final int DECIMAL=31;
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
    public static final int T__66=66;
    public static final int SYMBOLCHAR=37;
    public static final int COMMENT=20;
    public static final int MARKUP_STATEMENT=7;
    public static final int FORMALS=9;
    public static final int T__45=45;
    public static final int T__55=55;
    public static final int CHARREF=35;
    public static final int MIDTEXT=19;
    public static final int T__63=63;
    public static final int PRETEXT=17;
    public static final int T__43=43;
    public static final int SEMICOLON=23;
    public static final int T__40=40;
    public static final int EOF=-1;
    public static final int T__53=53;
    public static final int TEXT=14;
    public static final int NATCON=13;
    public static final int T__60=60;
    public static final int T__41=41;
    public static final int PATH=12;

    // delegates
    // delegators

    protected static class Environment_scope {
        ArrayList<String> variables;
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


    	private List<SemanticException> exceptions;
    	
    	public WaebricChecker(TreeNodeStream input, List<SemanticException> exceptions) {
    		super(input);
    		this.exceptions = exceptions;
    	}
    	
    	public void checkAST(WaebricLoader loader) throws RecognitionException {
    		// Store function definitions to allow lazy function binding
    		Environment_stack.clear();
    		Environment_scope base = new Environment_scope();
    		base.functions = new HashMap<String, Integer>();
    		base.variables = new ArrayList<String>();
    		for(String function: loader.getFunctions().keySet()) 
    		{ base.functions.put(function, loader.getFunctions().get(function).args); }
    		Environment_stack.push(base);
    		
    		module(); // Check module
    	}

    	/**
    	 * Define function
    	 * @param id: Tree representation of functions IDCON
    	 * @param args: Number of arguments in function
    	 * @param depth: Depth in environment stack
    	 */
    	private void defineFunction(CommonTree id, int args) {
    		// Check if function is already defined
    		if(isDefinedFunction(id.getText())) {
    			exceptions.add(new DuplicateFunctionException(id));
    		} else { ((Environment_scope)Environment_stack.peek()).functions.put(id.getText(), args); }
    	}

    	/**
    	 * Check if a function is defined
    	 * @param name: Function name
    	 */
    	private boolean isDefinedFunction(String name) {
    		for(int i=Environment_stack.size()-1; i>=0; i--) {
    			if(((Environment_scope)Environment_stack.elementAt(i)).functions.containsKey(name)) {
    				return true; 
    			}
    		} return false;
    	}
    	
    	/**
    	 * Retrieve excepted function arguments
    	 * @param name: Function name
    	 */
    	private int getFunctionArgs(String name) {
    		for(int i=Environment_stack.size()-1; i>=0; i--) {
    			if(((Environment_scope)Environment_stack.elementAt(i)).functions.containsKey(name)) {
    				return ((Environment_scope)Environment_stack.elementAt(i)).functions.get(name); 
    			}
    		} return -1;
    	}
    	
    	/**
    	 * Define variable
    	 * @param name: Variable name
    	 */
    	private void defineVariable(String name) {
    		((Environment_scope)Environment_stack.peek()).variables.add(name);
    	}

    	/**
    	 * Check if variable is defined
    	 * @param name: Variable name
    	 */
    	private boolean isDefinedVariable(String name) {
    		for(int i=Environment_stack.size()-1; i>=0; i--) {
    			if(((Environment_scope)Environment_stack.elementAt(i)).variables.contains(name)) { 
    				return true; 
    			}
    		} return false;
    	}
    	
    		/**
    	 * Multiple function definitions with the same name are disallowed.
    	 * 
    	 * @author Jeroen van Schagen
    	 * @date 09-06-2009
    	 */
    	public static class DuplicateFunctionException extends SemanticException {
    		private static final long serialVersionUID = -8833578229100261366L;
    		public DuplicateFunctionException(CommonTree id) {
    			super("Duplicate definition of function \"" + id.getText() 
    					+ "\" at line " + id.getLine() 
            				+ " and character " + id.getCharPositionInLine() + ".");
    		}
    		
    	}
    	
            /**
             * If for an import directive import m no corresponding file m.wae 
             * can be found, this a an error. [The import directive is skipped]
             * 
             * @author Jeroen van Schagen
             * @date 09-06-2009
             */
            public static class NonExistingModuleException extends SemanticException {
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
           	public static class UndefinedVariableException extends SemanticException {
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
           	public static class UndefinedFunctionException extends SemanticException {
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
    	public static class ArityMismatchException extends SemanticException {
    		private static final long serialVersionUID = -954167103131401047L;
    		public ArityMismatchException(CommonTree id, int args) {
    			super("Arity mismatch at function call \"" + id.getText() 
    					+ "\" positioned on line " + id.getLine() 
            				+ " and character " + id.getCharPositionInLine()
            				+ ". Use the expected " + args + " argument(s).");
    		}
    		
    	}
    	


    public static class module_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "module"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:187:1: module : ^( 'module' moduleId ( imprt )* ( site )* ( function )* ) ;
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


        		((Environment_scope)Environment_stack.peek()).variables = new ArrayList<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:192:4: ( ^( 'module' moduleId ( imprt )* ( site )* ( function )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:192:7: ^( 'module' moduleId ( imprt )* ( site )* ( function )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal1=(CommonTree)match(input,40,FOLLOW_40_in_module85); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal1_tree = (CommonTree)adaptor.dupNode(string_literal1);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal1_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_moduleId_in_module87);
            moduleId2=moduleId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, moduleId2.getTree());
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:192:28: ( imprt )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==42) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: imprt
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_imprt_in_module89);
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

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:192:35: ( site )*
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
            	    pushFollow(FOLLOW_site_in_module92);
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

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:192:41: ( function )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==FUNCTION) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: function
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_function_in_module95);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:194:1: moduleId : id= IDCON ( '.' id= IDCON )* ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:197:2: (id= IDCON ( '.' id= IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:197:5: id= IDCON ( '.' id= IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_moduleId124); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (CommonTree)adaptor.dupNode(id);

            adaptor.addChild(root_0, id_tree);
            }
            if ( state.backtracking==0 ) {
               path = id.getText(); 
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:198:4: ( '.' id= IDCON )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==41) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:198:6: '.' id= IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal6=(CommonTree)match(input,41,FOLLOW_41_in_moduleId134); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal6_tree = (CommonTree)adaptor.dupNode(char_literal6);

            	    adaptor.addChild(root_0, char_literal6_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_moduleId138); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:207:1: imprt : 'import' moduleId module ;
    public final WaebricChecker.imprt_return imprt() throws RecognitionException {
        WaebricChecker.imprt_return retval = new WaebricChecker.imprt_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal7=null;
        WaebricChecker.moduleId_return moduleId8 = null;

        WaebricChecker.module_return module9 = null;


        CommonTree string_literal7_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:207:6: ( 'import' moduleId module )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:207:10: 'import' moduleId module
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal7=(CommonTree)match(input,42,FOLLOW_42_in_imprt159); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal7_tree = (CommonTree)adaptor.dupNode(string_literal7);

            adaptor.addChild(root_0, string_literal7_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_moduleId_in_imprt161);
            moduleId8=moduleId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(moduleId8.getTree(), root_0);
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_module_in_imprt165);
            module9=module();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, module9.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:211:1: site : 'site' mappings 'end' ;
    public final WaebricChecker.site_return site() throws RecognitionException {
        WaebricChecker.site_return retval = new WaebricChecker.site_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal10=null;
        CommonTree string_literal12=null;
        WaebricChecker.mappings_return mappings11 = null;


        CommonTree string_literal10_tree=null;
        CommonTree string_literal12_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:211:5: ( 'site' mappings 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:211:9: 'site' mappings 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal10=(CommonTree)match(input,SITE,FOLLOW_SITE_in_site177); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal10_tree = (CommonTree)adaptor.dupNode(string_literal10);

            adaptor.addChild(root_0, string_literal10_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_mappings_in_site179);
            mappings11=mappings();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, mappings11.getTree());
            _last = (CommonTree)input.LT(1);
            string_literal12=(CommonTree)match(input,END,FOLLOW_END_in_site181); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal12_tree = (CommonTree)adaptor.dupNode(string_literal12);

            adaptor.addChild(root_0, string_literal12_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:212:1: mappings : ( mapping )? ( ';' mapping )* ;
    public final WaebricChecker.mappings_return mappings() throws RecognitionException {
        WaebricChecker.mappings_return retval = new WaebricChecker.mappings_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal14=null;
        WaebricChecker.mapping_return mapping13 = null;

        WaebricChecker.mapping_return mapping15 = null;


        CommonTree char_literal14_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:212:9: ( ( mapping )? ( ';' mapping )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:212:12: ( mapping )? ( ';' mapping )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:212:12: ( mapping )?
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
                    pushFollow(FOLLOW_mapping_in_mappings189);
                    mapping13=mapping();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, mapping13.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:212:21: ( ';' mapping )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==SEMICOLON) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:212:23: ';' mapping
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal14=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_mappings194); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal14_tree = (CommonTree)adaptor.dupNode(char_literal14);

            	    adaptor.addChild(root_0, char_literal14_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_mapping_in_mappings196);
            	    mapping15=mapping();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, mapping15.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:213:1: mapping : PATH ':' markup ;
    public final WaebricChecker.mapping_return mapping() throws RecognitionException {
        WaebricChecker.mapping_return retval = new WaebricChecker.mapping_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PATH16=null;
        CommonTree char_literal17=null;
        WaebricChecker.markup_return markup18 = null;


        CommonTree PATH16_tree=null;
        CommonTree char_literal17_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:213:9: ( PATH ':' markup )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:213:12: PATH ':' markup
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PATH16=(CommonTree)match(input,PATH,FOLLOW_PATH_in_mapping208); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PATH16_tree = (CommonTree)adaptor.dupNode(PATH16);

            adaptor.addChild(root_0, PATH16_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal17=(CommonTree)match(input,43,FOLLOW_43_in_mapping210); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal17_tree = (CommonTree)adaptor.dupNode(char_literal17);

            adaptor.addChild(root_0, char_literal17_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_markup_in_mapping212);
            markup18=markup();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, markup18.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:217:1: markup : ^( MARKUP IDCON . arguments ) ;
    public final WaebricChecker.markup_return markup() throws RecognitionException {
        WaebricChecker.markup_return retval = new WaebricChecker.markup_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MARKUP19=null;
        CommonTree IDCON20=null;
        CommonTree wildcard21=null;
        WaebricChecker.arguments_return arguments22 = null;


        CommonTree MARKUP19_tree=null;
        CommonTree IDCON20_tree=null;
        CommonTree wildcard21_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:217:7: ( ^( MARKUP IDCON . arguments ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:217:11: ^( MARKUP IDCON . arguments )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            MARKUP19=(CommonTree)match(input,MARKUP,FOLLOW_MARKUP_in_markup226); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MARKUP19_tree = (CommonTree)adaptor.dupNode(MARKUP19);

            root_1 = (CommonTree)adaptor.becomeRoot(MARKUP19_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            IDCON20=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_markup228); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON20_tree = (CommonTree)adaptor.dupNode(IDCON20);

            adaptor.addChild(root_1, IDCON20_tree);
            }
            _last = (CommonTree)input.LT(1);
            wildcard21=(CommonTree)input.LT(1);
            matchAny(input); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            wildcard21_tree = (CommonTree)adaptor.dupTree(wildcard21);
            adaptor.addChild(root_1, wildcard21_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_arguments_in_markup232);
            arguments22=arguments();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, arguments22.getTree());

            match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }

            if ( state.backtracking==0 ) {

              				if(isDefinedFunction(IDCON20.getText())) {
              					int expected = getFunctionArgs(IDCON20.getText());
              					int actual = (arguments22!=null?arguments22.args:0);
              					if(expected != actual) {
              						exceptions.add(new ArityMismatchException(IDCON20, expected));
              					}
              				} else if(! XHTMLTag.isXHTMLTag(IDCON20.getText())) {
              					exceptions.add(new UndefinedFunctionException(IDCON20));
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
    // $ANTLR end "markup"

    public static class arguments_return extends TreeRuleReturnScope {
        public int args = 0;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arguments"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:229:1: arguments returns [int args = 0] : ^( ARGUMENTS ( argument )* ) ;
    public final WaebricChecker.arguments_return arguments() throws RecognitionException {
        WaebricChecker.arguments_return retval = new WaebricChecker.arguments_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ARGUMENTS23=null;
        WaebricChecker.argument_return argument24 = null;


        CommonTree ARGUMENTS23_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:230:2: ( ^( ARGUMENTS ( argument )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:230:5: ^( ARGUMENTS ( argument )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            ARGUMENTS23=(CommonTree)match(input,ARGUMENTS,FOLLOW_ARGUMENTS_in_arguments254); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ARGUMENTS23_tree = (CommonTree)adaptor.dupNode(ARGUMENTS23);

            root_1 = (CommonTree)adaptor.becomeRoot(ARGUMENTS23_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:230:18: ( argument )*
                loop7:
                do {
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==IDCON||(LA7_0>=NATCON && LA7_0<=SYMBOLCON)||LA7_0==52||LA7_0==54) ) {
                        alt7=1;
                    }


                    switch (alt7) {
                	case 1 :
                	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:230:20: argument
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_argument_in_arguments258);
                	    argument24=argument();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, argument24.getTree());
                	    if ( state.backtracking==0 ) {
                	      retval.args++;
                	    }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop7;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }adaptor.addChild(root_0, root_1);_last = _save_last_1;
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

    public static class argument_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "argument"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:232:1: argument : ( expression | IDCON '=' expression );
    public final WaebricChecker.argument_return argument() throws RecognitionException {
        WaebricChecker.argument_return retval = new WaebricChecker.argument_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON26=null;
        CommonTree char_literal27=null;
        WaebricChecker.expression_return expression25 = null;

        WaebricChecker.expression_return expression28 = null;


        CommonTree IDCON26_tree=null;
        CommonTree char_literal27_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:232:9: ( expression | IDCON '=' expression )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==IDCON) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==51) ) {
                    alt8=2;
                }
                else if ( (LA8_1==EOF||LA8_1==UP||LA8_1==IDCON||(LA8_1>=NATCON && LA8_1<=SYMBOLCON)||LA8_1==41||LA8_1==52||LA8_1==54||LA8_1==56) ) {
                    alt8=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA8_0>=NATCON && LA8_0<=SYMBOLCON)||LA8_0==52||LA8_0==54) ) {
                alt8=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:232:12: expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_argument277);
                    expression25=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression25.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:232:25: IDCON '=' expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDCON26=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_argument281); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON26_tree = (CommonTree)adaptor.dupNode(IDCON26);

                    adaptor.addChild(root_0, IDCON26_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal27=(CommonTree)match(input,51,FOLLOW_51_in_argument283); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal27_tree = (CommonTree)adaptor.dupNode(char_literal27);

                    adaptor.addChild(root_0, char_literal27_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_argument285);
                    expression28=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression28.getTree());

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
    // $ANTLR end "argument"

    public static class expression_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:238:1: expression : ( varExpression | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* ;
    public final WaebricChecker.expression_return expression() throws RecognitionException {
        WaebricChecker.expression_return retval = new WaebricChecker.expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NATCON30=null;
        CommonTree TEXT31=null;
        CommonTree SYMBOLCON32=null;
        CommonTree char_literal33=null;
        CommonTree char_literal35=null;
        CommonTree char_literal37=null;
        CommonTree char_literal38=null;
        CommonTree char_literal40=null;
        CommonTree char_literal42=null;
        CommonTree char_literal43=null;
        CommonTree char_literal45=null;
        CommonTree IDCON46=null;
        WaebricChecker.varExpression_return varExpression29 = null;

        WaebricChecker.expression_return expression34 = null;

        WaebricChecker.expression_return expression36 = null;

        WaebricChecker.keyValuePair_return keyValuePair39 = null;

        WaebricChecker.keyValuePair_return keyValuePair41 = null;

        WaebricChecker.expression_return expression44 = null;


        CommonTree NATCON30_tree=null;
        CommonTree TEXT31_tree=null;
        CommonTree SYMBOLCON32_tree=null;
        CommonTree char_literal33_tree=null;
        CommonTree char_literal35_tree=null;
        CommonTree char_literal37_tree=null;
        CommonTree char_literal38_tree=null;
        CommonTree char_literal40_tree=null;
        CommonTree char_literal42_tree=null;
        CommonTree char_literal43_tree=null;
        CommonTree char_literal45_tree=null;
        CommonTree IDCON46_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:238:11: ( ( varExpression | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:238:14: ( varExpression | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:238:14: ( varExpression | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' )
            int alt13=6;
            switch ( input.LA(1) ) {
            case IDCON:
                {
                alt13=1;
                }
                break;
            case NATCON:
                {
                alt13=2;
                }
                break;
            case TEXT:
                {
                alt13=3;
                }
                break;
            case SYMBOLCON:
                {
                alt13=4;
                }
                break;
            case 52:
                {
                alt13=5;
                }
                break;
            case 54:
                {
                alt13=6;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:238:16: varExpression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_varExpression_in_expression300);
                    varExpression29=varExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, varExpression29.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:238:32: NATCON
                    {
                    _last = (CommonTree)input.LT(1);
                    NATCON30=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_expression304); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON30_tree = (CommonTree)adaptor.dupNode(NATCON30);

                    adaptor.addChild(root_0, NATCON30_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:238:41: TEXT
                    {
                    _last = (CommonTree)input.LT(1);
                    TEXT31=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_expression308); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TEXT31_tree = (CommonTree)adaptor.dupNode(TEXT31);

                    adaptor.addChild(root_0, TEXT31_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:238:48: SYMBOLCON
                    {
                    _last = (CommonTree)input.LT(1);
                    SYMBOLCON32=(CommonTree)match(input,SYMBOLCON,FOLLOW_SYMBOLCON_in_expression312); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SYMBOLCON32_tree = (CommonTree)adaptor.dupNode(SYMBOLCON32);

                    adaptor.addChild(root_0, SYMBOLCON32_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:239:7: '[' ( expression )? ( ',' expression )* ']'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal33=(CommonTree)match(input,52,FOLLOW_52_in_expression321); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal33_tree = (CommonTree)adaptor.dupNode(char_literal33);

                    adaptor.addChild(root_0, char_literal33_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:239:11: ( expression )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==IDCON||(LA9_0>=NATCON && LA9_0<=SYMBOLCON)||LA9_0==52||LA9_0==54) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: expression
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_expression_in_expression323);
                            expression34=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, expression34.getTree());

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:239:23: ( ',' expression )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==49) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:239:25: ',' expression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal35=(CommonTree)match(input,49,FOLLOW_49_in_expression328); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal35_tree = (CommonTree)adaptor.dupNode(char_literal35);

                    	    adaptor.addChild(root_0, char_literal35_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_expression_in_expression330);
                    	    expression36=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, expression36.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal37=(CommonTree)match(input,53,FOLLOW_53_in_expression335); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal37_tree = (CommonTree)adaptor.dupNode(char_literal37);

                    adaptor.addChild(root_0, char_literal37_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:240:7: '{' ( keyValuePair )? ( ',' keyValuePair )* '}'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal38=(CommonTree)match(input,54,FOLLOW_54_in_expression344); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal38_tree = (CommonTree)adaptor.dupNode(char_literal38);

                    adaptor.addChild(root_0, char_literal38_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:240:11: ( keyValuePair )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==IDCON) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: keyValuePair
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_keyValuePair_in_expression346);
                            keyValuePair39=keyValuePair();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, keyValuePair39.getTree());

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:240:25: ( ',' keyValuePair )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==49) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:240:27: ',' keyValuePair
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal40=(CommonTree)match(input,49,FOLLOW_49_in_expression351); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal40_tree = (CommonTree)adaptor.dupNode(char_literal40);

                    	    adaptor.addChild(root_0, char_literal40_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_keyValuePair_in_expression353);
                    	    keyValuePair41=keyValuePair();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, keyValuePair41.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal42=(CommonTree)match(input,55,FOLLOW_55_in_expression358); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal42_tree = (CommonTree)adaptor.dupNode(char_literal42);

                    adaptor.addChild(root_0, char_literal42_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:241:6: ( '+' expression | '.' IDCON )*
            loop14:
            do {
                int alt14=3;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==56) ) {
                    int LA14_2 = input.LA(2);

                    if ( (synpred18_WaebricChecker()) ) {
                        alt14=1;
                    }


                }
                else if ( (LA14_0==41) ) {
                    int LA14_3 = input.LA(2);

                    if ( (synpred19_WaebricChecker()) ) {
                        alt14=2;
                    }


                }


                switch (alt14) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:241:8: '+' expression
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
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:241:25: '.' IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal45=(CommonTree)match(input,41,FOLLOW_41_in_expression374); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:243:1: varExpression : IDCON ;
    public final WaebricChecker.varExpression_return varExpression() throws RecognitionException {
        WaebricChecker.varExpression_return retval = new WaebricChecker.varExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON47=null;

        CommonTree IDCON47_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:243:14: ( IDCON )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:243:17: IDCON
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON47=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_varExpression388); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON47_tree = (CommonTree)adaptor.dupNode(IDCON47);

            adaptor.addChild(root_0, IDCON47_tree);
            }
            if ( state.backtracking==0 ) {

              				if(! isDefinedVariable(IDCON47.getText())) {
              					exceptions.add(new UndefinedVariableException(IDCON47_tree));
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:249:1: keyValuePair : IDCON ':' expression ;
    public final WaebricChecker.keyValuePair_return keyValuePair() throws RecognitionException {
        WaebricChecker.keyValuePair_return retval = new WaebricChecker.keyValuePair_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON48=null;
        CommonTree char_literal49=null;
        WaebricChecker.expression_return expression50 = null;


        CommonTree IDCON48_tree=null;
        CommonTree char_literal49_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:249:13: ( IDCON ':' expression )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:249:16: IDCON ':' expression
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON48=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_keyValuePair402); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON48_tree = (CommonTree)adaptor.dupNode(IDCON48);

            adaptor.addChild(root_0, IDCON48_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal49=(CommonTree)match(input,43,FOLLOW_43_in_keyValuePair404); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal49_tree = (CommonTree)adaptor.dupNode(char_literal49);

            adaptor.addChild(root_0, char_literal49_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_keyValuePair406);
            expression50=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, expression50.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:253:1: function : ^( FUNCTION IDCON formals ( statement )* ) ;
    public final WaebricChecker.function_return function() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.function_return retval = new WaebricChecker.function_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNCTION51=null;
        CommonTree IDCON52=null;
        WaebricChecker.formals_return formals53 = null;

        WaebricChecker.statement_return statement54 = null;


        CommonTree FUNCTION51_tree=null;
        CommonTree IDCON52_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new ArrayList<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:258:4: ( ^( FUNCTION IDCON formals ( statement )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:258:7: ^( FUNCTION IDCON formals ( statement )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNCTION51=(CommonTree)match(input,FUNCTION,FOLLOW_FUNCTION_in_function432); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FUNCTION51_tree = (CommonTree)adaptor.dupNode(FUNCTION51);

            root_1 = (CommonTree)adaptor.becomeRoot(FUNCTION51_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            IDCON52=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_function434); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON52_tree = (CommonTree)adaptor.dupNode(IDCON52);

            adaptor.addChild(root_1, IDCON52_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_formals_in_function436);
            formals53=formals();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, formals53.getTree());
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:258:33: ( statement )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==MARKUP_STATEMENT||LA15_0==COMMENT||LA15_0==54||LA15_0==57||(LA15_0>=59 && LA15_0<=60)||(LA15_0>=62 && LA15_0<=64)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_function438);
            	    statement54=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, statement54.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop15;
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
    // $ANTLR end "function"

    public static class formals_return extends TreeRuleReturnScope {
        public int args = 0;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "formals"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:260:1: formals returns [int args = 0] : ^( FORMALS ( IDCON )* ) ;
    public final WaebricChecker.formals_return formals() throws RecognitionException {
        WaebricChecker.formals_return retval = new WaebricChecker.formals_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FORMALS55=null;
        CommonTree IDCON56=null;

        CommonTree FORMALS55_tree=null;
        CommonTree IDCON56_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:261:2: ( ^( FORMALS ( IDCON )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:261:5: ^( FORMALS ( IDCON )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FORMALS55=(CommonTree)match(input,FORMALS,FOLLOW_FORMALS_in_formals462); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FORMALS55_tree = (CommonTree)adaptor.dupNode(FORMALS55);

            root_1 = (CommonTree)adaptor.becomeRoot(FORMALS55_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:261:16: ( IDCON )*
                loop16:
                do {
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==IDCON) ) {
                        alt16=1;
                    }


                    switch (alt16) {
                	case 1 :
                	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:261:18: IDCON
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    IDCON56=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_formals466); if (state.failed) return retval;
                	    if ( state.backtracking==0 ) {
                	    IDCON56_tree = (CommonTree)adaptor.dupNode(IDCON56);

                	    adaptor.addChild(root_1, IDCON56_tree);
                	    }
                	    if ( state.backtracking==0 ) {
                	       defineVariable(IDCON56.getText()); retval.args++; 
                	    }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop16;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }adaptor.addChild(root_0, root_1);_last = _save_last_1;
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
    // $ANTLR end "formals"

    public static class statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:265:1: statement : ( ^( 'if' '(' predicate ')' statement ( 'else' statement )? ) | eachStatement | letStatement | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT markup markupChain ) );
    public final WaebricChecker.statement_return statement() throws RecognitionException {
        WaebricChecker.statement_return retval = new WaebricChecker.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal57=null;
        CommonTree char_literal58=null;
        CommonTree char_literal60=null;
        CommonTree string_literal62=null;
        CommonTree char_literal66=null;
        CommonTree char_literal68=null;
        CommonTree string_literal69=null;
        CommonTree STRCON70=null;
        CommonTree char_literal71=null;
        CommonTree string_literal72=null;
        CommonTree char_literal74=null;
        CommonTree string_literal75=null;
        CommonTree char_literal77=null;
        CommonTree string_literal78=null;
        CommonTree char_literal80=null;
        CommonTree string_literal81=null;
        CommonTree MARKUP_STATEMENT82=null;
        WaebricChecker.predicate_return predicate59 = null;

        WaebricChecker.statement_return statement61 = null;

        WaebricChecker.statement_return statement63 = null;

        WaebricChecker.eachStatement_return eachStatement64 = null;

        WaebricChecker.letStatement_return letStatement65 = null;

        WaebricChecker.statement_return statement67 = null;

        WaebricChecker.expression_return expression73 = null;

        WaebricChecker.embedding_return embedding76 = null;

        WaebricChecker.expression_return expression79 = null;

        WaebricChecker.markup_return markup83 = null;

        WaebricChecker.markupChain_return markupChain84 = null;


        CommonTree string_literal57_tree=null;
        CommonTree char_literal58_tree=null;
        CommonTree char_literal60_tree=null;
        CommonTree string_literal62_tree=null;
        CommonTree char_literal66_tree=null;
        CommonTree char_literal68_tree=null;
        CommonTree string_literal69_tree=null;
        CommonTree STRCON70_tree=null;
        CommonTree char_literal71_tree=null;
        CommonTree string_literal72_tree=null;
        CommonTree char_literal74_tree=null;
        CommonTree string_literal75_tree=null;
        CommonTree char_literal77_tree=null;
        CommonTree string_literal78_tree=null;
        CommonTree char_literal80_tree=null;
        CommonTree string_literal81_tree=null;
        CommonTree MARKUP_STATEMENT82_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:265:10: ( ^( 'if' '(' predicate ')' statement ( 'else' statement )? ) | eachStatement | letStatement | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT markup markupChain ) )
            int alt19=10;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:265:13: ^( 'if' '(' predicate ')' statement ( 'else' statement )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal57=(CommonTree)match(input,57,FOLLOW_57_in_statement486); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal57_tree = (CommonTree)adaptor.dupNode(string_literal57);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal57_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    char_literal58=(CommonTree)match(input,48,FOLLOW_48_in_statement488); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal58_tree = (CommonTree)adaptor.dupNode(char_literal58);

                    adaptor.addChild(root_1, char_literal58_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_statement490);
                    predicate59=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, predicate59.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal60=(CommonTree)match(input,50,FOLLOW_50_in_statement492); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal60_tree = (CommonTree)adaptor.dupNode(char_literal60);

                    adaptor.addChild(root_1, char_literal60_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement494);
                    statement61=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement61.getTree());
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:265:49: ( 'else' statement )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==58) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:265:51: 'else' statement
                            {
                            _last = (CommonTree)input.LT(1);
                            string_literal62=(CommonTree)match(input,58,FOLLOW_58_in_statement498); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal62_tree = (CommonTree)adaptor.dupNode(string_literal62);

                            adaptor.addChild(root_1, string_literal62_tree);
                            }
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_statement_in_statement500);
                            statement63=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, statement63.getTree());

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:266:6: eachStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_eachStatement_in_statement512);
                    eachStatement64=eachStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, eachStatement64.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:267:6: letStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_letStatement_in_statement519);
                    letStatement65=letStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, letStatement65.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:268:6: ^( '{' ( statement )* '}' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal66=(CommonTree)match(input,54,FOLLOW_54_in_statement528); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal66_tree = (CommonTree)adaptor.dupNode(char_literal66);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal66_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:268:13: ( statement )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==MARKUP_STATEMENT||LA18_0==COMMENT||LA18_0==54||LA18_0==57||(LA18_0>=59 && LA18_0<=60)||(LA18_0>=62 && LA18_0<=64)) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: statement
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_statement_in_statement530);
                    	    statement67=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, statement67.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal68=(CommonTree)match(input,55,FOLLOW_55_in_statement533); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal68_tree = (CommonTree)adaptor.dupNode(char_literal68);

                    adaptor.addChild(root_1, char_literal68_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:269:6: ^( 'comment' STRCON ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal69=(CommonTree)match(input,COMMENT,FOLLOW_COMMENT_in_statement544); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal69_tree = (CommonTree)adaptor.dupNode(string_literal69);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal69_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    STRCON70=(CommonTree)match(input,STRCON,FOLLOW_STRCON_in_statement546); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRCON70_tree = (CommonTree)adaptor.dupNode(STRCON70);

                    adaptor.addChild(root_1, STRCON70_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal71=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement548); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal71_tree = (CommonTree)adaptor.dupNode(char_literal71);

                    adaptor.addChild(root_1, char_literal71_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:270:6: ^( 'echo' expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal72=(CommonTree)match(input,62,FOLLOW_62_in_statement559); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal72_tree = (CommonTree)adaptor.dupNode(string_literal72);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal72_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement561);
                    expression73=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression73.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal74=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement563); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal74_tree = (CommonTree)adaptor.dupNode(char_literal74);

                    adaptor.addChild(root_1, char_literal74_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:271:6: ^( 'echo' embedding ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal75=(CommonTree)match(input,62,FOLLOW_62_in_statement574); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal75_tree = (CommonTree)adaptor.dupNode(string_literal75);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal75_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement576);
                    embedding76=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding76.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal77=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement578); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal77_tree = (CommonTree)adaptor.dupNode(char_literal77);

                    adaptor.addChild(root_1, char_literal77_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:272:6: ^( 'cdata' expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal78=(CommonTree)match(input,63,FOLLOW_63_in_statement589); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal78_tree = (CommonTree)adaptor.dupNode(string_literal78);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal78_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement591);
                    expression79=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression79.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal80=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement593); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal80_tree = (CommonTree)adaptor.dupNode(char_literal80);

                    adaptor.addChild(root_1, char_literal80_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:273:6: 'yield;'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal81=(CommonTree)match(input,64,FOLLOW_64_in_statement602); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal81_tree = (CommonTree)adaptor.dupNode(string_literal81);

                    adaptor.addChild(root_0, string_literal81_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:274:6: ^( MARKUP_STATEMENT markup markupChain )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT82=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement611); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT82_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT82);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT82_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_statement613);
                    markup83=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, markup83.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markupChain_in_statement615);
                    markupChain84=markupChain();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, markupChain84.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
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

    public static class markupChain_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "markupChain"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:276:1: markupChain : ( ^( MARKUP_CHAIN markup markupChain ) | ^( MARKUP_CHAIN expression ';' ) | ^( MARKUP_CHAIN statement ) | ^( MARKUP_CHAIN embedding ';' ) | ^( MARKUP_CHAIN ';' ) );
    public final WaebricChecker.markupChain_return markupChain() throws RecognitionException {
        WaebricChecker.markupChain_return retval = new WaebricChecker.markupChain_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MARKUP_CHAIN85=null;
        CommonTree MARKUP_CHAIN88=null;
        CommonTree char_literal90=null;
        CommonTree MARKUP_CHAIN91=null;
        CommonTree MARKUP_CHAIN93=null;
        CommonTree char_literal95=null;
        CommonTree MARKUP_CHAIN96=null;
        CommonTree char_literal97=null;
        WaebricChecker.markup_return markup86 = null;

        WaebricChecker.markupChain_return markupChain87 = null;

        WaebricChecker.expression_return expression89 = null;

        WaebricChecker.statement_return statement92 = null;

        WaebricChecker.embedding_return embedding94 = null;


        CommonTree MARKUP_CHAIN85_tree=null;
        CommonTree MARKUP_CHAIN88_tree=null;
        CommonTree char_literal90_tree=null;
        CommonTree MARKUP_CHAIN91_tree=null;
        CommonTree MARKUP_CHAIN93_tree=null;
        CommonTree char_literal95_tree=null;
        CommonTree MARKUP_CHAIN96_tree=null;
        CommonTree char_literal97_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:276:12: ( ^( MARKUP_CHAIN markup markupChain ) | ^( MARKUP_CHAIN expression ';' ) | ^( MARKUP_CHAIN statement ) | ^( MARKUP_CHAIN embedding ';' ) | ^( MARKUP_CHAIN ';' ) )
            int alt20=5;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==MARKUP_CHAIN) ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==DOWN) ) {
                    switch ( input.LA(3) ) {
                    case SEMICOLON:
                        {
                        alt20=5;
                        }
                        break;
                    case MARKUP:
                        {
                        alt20=1;
                        }
                        break;
                    case IDCON:
                    case NATCON:
                    case TEXT:
                    case SYMBOLCON:
                    case 52:
                        {
                        alt20=2;
                        }
                        break;
                    case 54:
                        {
                        int LA20_6 = input.LA(4);

                        if ( (LA20_6==DOWN) ) {
                            alt20=3;
                        }
                        else if ( (LA20_6==IDCON||LA20_6==49||LA20_6==55) ) {
                            alt20=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 20, 6, input);

                            throw nvae;
                        }
                        }
                        break;
                    case MARKUP_STATEMENT:
                    case COMMENT:
                    case 57:
                    case 59:
                    case 60:
                    case 62:
                    case 63:
                    case 64:
                        {
                        alt20=3;
                        }
                        break;
                    case PRETEXT:
                        {
                        alt20=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 20, 2, input);

                        throw nvae;
                    }

                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:276:15: ^( MARKUP_CHAIN markup markupChain )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_CHAIN85=(CommonTree)match(input,MARKUP_CHAIN,FOLLOW_MARKUP_CHAIN_in_markupChain631); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_CHAIN85_tree = (CommonTree)adaptor.dupNode(MARKUP_CHAIN85);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_CHAIN85_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_markupChain633);
                    markup86=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, markup86.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markupChain_in_markupChain635);
                    markupChain87=markupChain();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, markupChain87.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:277:6: ^( MARKUP_CHAIN expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_CHAIN88=(CommonTree)match(input,MARKUP_CHAIN,FOLLOW_MARKUP_CHAIN_in_markupChain646); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_CHAIN88_tree = (CommonTree)adaptor.dupNode(MARKUP_CHAIN88);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_CHAIN88_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_markupChain648);
                    expression89=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression89.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal90=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_markupChain650); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal90_tree = (CommonTree)adaptor.dupNode(char_literal90);

                    adaptor.addChild(root_1, char_literal90_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:278:6: ^( MARKUP_CHAIN statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_CHAIN91=(CommonTree)match(input,MARKUP_CHAIN,FOLLOW_MARKUP_CHAIN_in_markupChain661); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_CHAIN91_tree = (CommonTree)adaptor.dupNode(MARKUP_CHAIN91);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_CHAIN91_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_markupChain663);
                    statement92=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement92.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:279:6: ^( MARKUP_CHAIN embedding ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_CHAIN93=(CommonTree)match(input,MARKUP_CHAIN,FOLLOW_MARKUP_CHAIN_in_markupChain674); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_CHAIN93_tree = (CommonTree)adaptor.dupNode(MARKUP_CHAIN93);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_CHAIN93_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_markupChain676);
                    embedding94=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding94.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal95=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_markupChain678); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal95_tree = (CommonTree)adaptor.dupNode(char_literal95);

                    adaptor.addChild(root_1, char_literal95_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:280:6: ^( MARKUP_CHAIN ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_CHAIN96=(CommonTree)match(input,MARKUP_CHAIN,FOLLOW_MARKUP_CHAIN_in_markupChain689); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_CHAIN96_tree = (CommonTree)adaptor.dupNode(MARKUP_CHAIN96);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_CHAIN96_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    char_literal97=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_markupChain691); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal97_tree = (CommonTree)adaptor.dupNode(char_literal97);

                    adaptor.addChild(root_1, char_literal97_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
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
    // $ANTLR end "markupChain"

    public static class eachStatement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "eachStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:282:1: eachStatement : ^( 'each' '(' IDCON ':' expression ')' statement ) ;
    public final WaebricChecker.eachStatement_return eachStatement() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.eachStatement_return retval = new WaebricChecker.eachStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal98=null;
        CommonTree char_literal99=null;
        CommonTree IDCON100=null;
        CommonTree char_literal101=null;
        CommonTree char_literal103=null;
        WaebricChecker.expression_return expression102 = null;

        WaebricChecker.statement_return statement104 = null;


        CommonTree string_literal98_tree=null;
        CommonTree char_literal99_tree=null;
        CommonTree IDCON100_tree=null;
        CommonTree char_literal101_tree=null;
        CommonTree char_literal103_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new ArrayList<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:287:4: ( ^( 'each' '(' IDCON ':' expression ')' statement ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:287:7: ^( 'each' '(' IDCON ':' expression ')' statement )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal98=(CommonTree)match(input,59,FOLLOW_59_in_eachStatement717); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal98_tree = (CommonTree)adaptor.dupNode(string_literal98);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal98_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            char_literal99=(CommonTree)match(input,48,FOLLOW_48_in_eachStatement719); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal99_tree = (CommonTree)adaptor.dupNode(char_literal99);

            adaptor.addChild(root_1, char_literal99_tree);
            }
            _last = (CommonTree)input.LT(1);
            IDCON100=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_eachStatement721); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON100_tree = (CommonTree)adaptor.dupNode(IDCON100);

            adaptor.addChild(root_1, IDCON100_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal101=(CommonTree)match(input,43,FOLLOW_43_in_eachStatement723); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal101_tree = (CommonTree)adaptor.dupNode(char_literal101);

            adaptor.addChild(root_1, char_literal101_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_eachStatement725);
            expression102=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expression102.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal103=(CommonTree)match(input,50,FOLLOW_50_in_eachStatement727); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal103_tree = (CommonTree)adaptor.dupNode(char_literal103);

            adaptor.addChild(root_1, char_literal103_tree);
            }
            if ( state.backtracking==0 ) {
               
              				defineVariable(IDCON100.getText()); // Define variable before statement is executed
              			
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_eachStatement731);
            statement104=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, statement104.getTree());

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
    // $ANTLR end "eachStatement"

    public static class letStatement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "letStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:291:1: letStatement : ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) ;
    public final WaebricChecker.letStatement_return letStatement() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.letStatement_return retval = new WaebricChecker.letStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal105=null;
        CommonTree string_literal107=null;
        CommonTree string_literal109=null;
        WaebricChecker.assignment_return assignment106 = null;

        WaebricChecker.statement_return statement108 = null;


        CommonTree string_literal105_tree=null;
        CommonTree string_literal107_tree=null;
        CommonTree string_literal109_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new ArrayList<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:296:4: ( ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:296:7: ^( 'let' ( assignment )+ 'in' ( statement )* 'end' )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal105=(CommonTree)match(input,60,FOLLOW_60_in_letStatement757); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal105_tree = (CommonTree)adaptor.dupNode(string_literal105);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal105_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:296:16: ( assignment )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=FUNCTION && LA21_0<=IDCON)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: assignment
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_assignment_in_letStatement759);
            	    assignment106=assignment();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, assignment106.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
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

            _last = (CommonTree)input.LT(1);
            string_literal107=(CommonTree)match(input,61,FOLLOW_61_in_letStatement762); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal107_tree = (CommonTree)adaptor.dupNode(string_literal107);

            adaptor.addChild(root_1, string_literal107_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:296:33: ( statement )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==MARKUP_STATEMENT||LA22_0==COMMENT||LA22_0==54||LA22_0==57||(LA22_0>=59 && LA22_0<=60)||(LA22_0>=62 && LA22_0<=64)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_letStatement764);
            	    statement108=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, statement108.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            string_literal109=(CommonTree)match(input,END,FOLLOW_END_in_letStatement767); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal109_tree = (CommonTree)adaptor.dupNode(string_literal109);

            adaptor.addChild(root_1, string_literal109_tree);
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
    // $ANTLR end "letStatement"

    public static class assignment_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignment"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:298:1: assignment : ( IDCON '=' expression ';' | funcBinding );
    public final WaebricChecker.assignment_return assignment() throws RecognitionException {
        WaebricChecker.assignment_return retval = new WaebricChecker.assignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON110=null;
        CommonTree char_literal111=null;
        CommonTree char_literal113=null;
        WaebricChecker.expression_return expression112 = null;

        WaebricChecker.funcBinding_return funcBinding114 = null;


        CommonTree IDCON110_tree=null;
        CommonTree char_literal111_tree=null;
        CommonTree char_literal113_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:298:11: ( IDCON '=' expression ';' | funcBinding )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==IDCON) ) {
                alt23=1;
            }
            else if ( (LA23_0==FUNCTION) ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:298:14: IDCON '=' expression ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDCON110=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_assignment778); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON110_tree = (CommonTree)adaptor.dupNode(IDCON110);

                    adaptor.addChild(root_0, IDCON110_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal111=(CommonTree)match(input,51,FOLLOW_51_in_assignment780); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal111_tree = (CommonTree)adaptor.dupNode(char_literal111);

                    adaptor.addChild(root_0, char_literal111_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_assignment782);
                    expression112=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression112.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal113=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_assignment784); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal113_tree = (CommonTree)adaptor.dupNode(char_literal113);

                    adaptor.addChild(root_0, char_literal113_tree);
                    }
                    if ( state.backtracking==0 ) {
                       
                      				defineVariable(IDCON110.getText()); 
                      			
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:300:8: funcBinding
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_funcBinding_in_assignment790);
                    funcBinding114=funcBinding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, funcBinding114.getTree());

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

    public static class funcBinding_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "funcBinding"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:302:1: funcBinding : ^( FUNCTION id= IDCON f= formals statement ) ;
    public final WaebricChecker.funcBinding_return funcBinding() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.funcBinding_return retval = new WaebricChecker.funcBinding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        CommonTree FUNCTION115=null;
        WaebricChecker.formals_return f = null;

        WaebricChecker.statement_return statement116 = null;


        CommonTree id_tree=null;
        CommonTree FUNCTION115_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new ArrayList<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:307:4: ( ^( FUNCTION id= IDCON f= formals statement ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:307:8: ^( FUNCTION id= IDCON f= formals statement )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNCTION115=(CommonTree)match(input,FUNCTION,FOLLOW_FUNCTION_in_funcBinding819); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FUNCTION115_tree = (CommonTree)adaptor.dupNode(FUNCTION115);

            root_1 = (CommonTree)adaptor.becomeRoot(FUNCTION115_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_funcBinding823); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (CommonTree)adaptor.dupNode(id);

            adaptor.addChild(root_1, id_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_formals_in_funcBinding827);
            f=formals();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, f.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_funcBinding829);
            statement116=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, statement116.getTree());

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


            		// Define function after poping local stack so the definition stays
            		defineFunction(id, (f!=null?f.args:0));
            	
        }
        return retval;
    }
    // $ANTLR end "funcBinding"

    public static class predicate_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "predicate"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:316:1: predicate : ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )* ;
    public final WaebricChecker.predicate_return predicate() throws RecognitionException {
        WaebricChecker.predicate_return retval = new WaebricChecker.predicate_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal117=null;
        CommonTree char_literal121=null;
        CommonTree string_literal123=null;
        CommonTree string_literal125=null;
        WaebricChecker.predicate_return predicate118 = null;

        WaebricChecker.expression_return expression119 = null;

        WaebricChecker.expression_return expression120 = null;

        WaebricChecker.type_return type122 = null;

        WaebricChecker.predicate_return predicate124 = null;

        WaebricChecker.predicate_return predicate126 = null;


        CommonTree char_literal117_tree=null;
        CommonTree char_literal121_tree=null;
        CommonTree string_literal123_tree=null;
        CommonTree string_literal125_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:316:10: ( ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:316:13: ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:316:13: ( '!' predicate | expression | expression '.' type )
            int alt24=3;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:316:15: '!' predicate
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal117=(CommonTree)match(input,65,FOLLOW_65_in_predicate855); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal117_tree = (CommonTree)adaptor.dupNode(char_literal117);

                    adaptor.addChild(root_0, char_literal117_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_predicate857);
                    predicate118=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, predicate118.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:317:7: expression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate866);
                    expression119=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression119.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:318:7: expression '.' type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate874);
                    expression120=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression120.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal121=(CommonTree)match(input,41,FOLLOW_41_in_predicate876); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal121_tree = (CommonTree)adaptor.dupNode(char_literal121);

                    adaptor.addChild(root_0, char_literal121_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_predicate878);
                    type122=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, type122.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:319:6: ( '&&' predicate | '||' predicate )*
            loop25:
            do {
                int alt25=3;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==66) ) {
                    int LA25_2 = input.LA(2);

                    if ( (synpred42_WaebricChecker()) ) {
                        alt25=1;
                    }


                }
                else if ( (LA25_0==67) ) {
                    int LA25_3 = input.LA(2);

                    if ( (synpred43_WaebricChecker()) ) {
                        alt25=2;
                    }


                }


                switch (alt25) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:319:8: '&&' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal123=(CommonTree)match(input,66,FOLLOW_66_in_predicate887); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal123_tree = (CommonTree)adaptor.dupNode(string_literal123);

            	    adaptor.addChild(root_0, string_literal123_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate889);
            	    predicate124=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, predicate124.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:319:25: '||' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal125=(CommonTree)match(input,67,FOLLOW_67_in_predicate893); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal125_tree = (CommonTree)adaptor.dupNode(string_literal125);

            	    adaptor.addChild(root_0, string_literal125_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate895);
            	    predicate126=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, predicate126.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop25;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:320:1: type : ( 'list' | 'record' | 'string' );
    public final WaebricChecker.type_return type() throws RecognitionException {
        WaebricChecker.type_return retval = new WaebricChecker.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set127=null;

        CommonTree set127_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:320:5: ( 'list' | 'record' | 'string' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            set127=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=68 && input.LA(1)<=70) ) {
                input.consume();

                if ( state.backtracking==0 ) {
                set127_tree = (CommonTree)adaptor.dupNode(set127);

                adaptor.addChild(root_0, set127_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:326:1: embedding : PRETEXT embed textTail ;
    public final WaebricChecker.embedding_return embedding() throws RecognitionException {
        WaebricChecker.embedding_return retval = new WaebricChecker.embedding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PRETEXT128=null;
        WaebricChecker.embed_return embed129 = null;

        WaebricChecker.textTail_return textTail130 = null;


        CommonTree PRETEXT128_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:326:10: ( PRETEXT embed textTail )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:326:13: PRETEXT embed textTail
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PRETEXT128=(CommonTree)match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding930); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRETEXT128_tree = (CommonTree)adaptor.dupNode(PRETEXT128);

            adaptor.addChild(root_0, PRETEXT128_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_embed_in_embedding932);
            embed129=embed();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, embed129.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_textTail_in_embedding934);
            textTail130=textTail();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, textTail130.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:327:1: embed : ( ( markup )* expression | ( markup )* markup );
    public final WaebricChecker.embed_return embed() throws RecognitionException {
        WaebricChecker.embed_return retval = new WaebricChecker.embed_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricChecker.markup_return markup131 = null;

        WaebricChecker.expression_return expression132 = null;

        WaebricChecker.markup_return markup133 = null;

        WaebricChecker.markup_return markup134 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:327:6: ( ( markup )* expression | ( markup )* markup )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==MARKUP) ) {
                int LA28_1 = input.LA(2);

                if ( (synpred47_WaebricChecker()) ) {
                    alt28=1;
                }
                else if ( (true) ) {
                    alt28=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA28_0==IDCON||(LA28_0>=NATCON && LA28_0<=SYMBOLCON)||LA28_0==52||LA28_0==54) ) {
                alt28=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:327:10: ( markup )* expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:327:10: ( markup )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==MARKUP) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed943);
                    	    markup131=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup131.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_embed946);
                    expression132=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression132.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:327:31: ( markup )* markup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:327:31: ( markup )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==MARKUP) ) {
                            int LA27_1 = input.LA(2);

                            if ( (synpred48_WaebricChecker()) ) {
                                alt27=1;
                            }


                        }


                        switch (alt27) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed950);
                    	    markup133=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup133.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_embed953);
                    markup134=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, markup134.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:328:1: textTail : ( POSTTEXT | MIDTEXT embed textTail );
    public final WaebricChecker.textTail_return textTail() throws RecognitionException {
        WaebricChecker.textTail_return retval = new WaebricChecker.textTail_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POSTTEXT135=null;
        CommonTree MIDTEXT136=null;
        WaebricChecker.embed_return embed137 = null;

        WaebricChecker.textTail_return textTail138 = null;


        CommonTree POSTTEXT135_tree=null;
        CommonTree MIDTEXT136_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:328:9: ( POSTTEXT | MIDTEXT embed textTail )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==POSTTEXT) ) {
                alt29=1;
            }
            else if ( (LA29_0==MIDTEXT) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:328:12: POSTTEXT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    POSTTEXT135=(CommonTree)match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail961); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    POSTTEXT135_tree = (CommonTree)adaptor.dupNode(POSTTEXT135);

                    adaptor.addChild(root_0, POSTTEXT135_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:328:23: MIDTEXT embed textTail
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    MIDTEXT136=(CommonTree)match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail965); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MIDTEXT136_tree = (CommonTree)adaptor.dupNode(MIDTEXT136);

                    adaptor.addChild(root_0, MIDTEXT136_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embed_in_textTail967);
                    embed137=embed();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, embed137.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_textTail_in_textTail969);
                    textTail138=textTail();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, textTail138.getTree());

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

    // $ANTLR start synpred18_WaebricChecker
    public final void synpred18_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:241:8: ( '+' expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:241:8: '+' expression
        {
        match(input,56,FOLLOW_56_in_synpred18_WaebricChecker368); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred18_WaebricChecker370);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_WaebricChecker

    // $ANTLR start synpred19_WaebricChecker
    public final void synpred19_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:241:25: ( '.' IDCON )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:241:25: '.' IDCON
        {
        match(input,41,FOLLOW_41_in_synpred19_WaebricChecker374); if (state.failed) return ;
        match(input,IDCON,FOLLOW_IDCON_in_synpred19_WaebricChecker376); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_WaebricChecker

    // $ANTLR start synpred41_WaebricChecker
    public final void synpred41_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:317:7: ( expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:317:7: expression
        {
        pushFollow(FOLLOW_expression_in_synpred41_WaebricChecker866);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred41_WaebricChecker

    // $ANTLR start synpred42_WaebricChecker
    public final void synpred42_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:319:8: ( '&&' predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:319:8: '&&' predicate
        {
        match(input,66,FOLLOW_66_in_synpred42_WaebricChecker887); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred42_WaebricChecker889);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred42_WaebricChecker

    // $ANTLR start synpred43_WaebricChecker
    public final void synpred43_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:319:25: ( '||' predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:319:25: '||' predicate
        {
        match(input,67,FOLLOW_67_in_synpred43_WaebricChecker893); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred43_WaebricChecker895);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred43_WaebricChecker

    // $ANTLR start synpred47_WaebricChecker
    public final void synpred47_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:327:10: ( ( markup )* expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:327:10: ( markup )* expression
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:327:10: ( markup )*
        loop34:
        do {
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==MARKUP) ) {
                alt34=1;
            }


            switch (alt34) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred47_WaebricChecker943);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop34;
            }
        } while (true);

        pushFollow(FOLLOW_expression_in_synpred47_WaebricChecker946);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred47_WaebricChecker

    // $ANTLR start synpred48_WaebricChecker
    public final void synpred48_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:327:31: ( markup )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:327:31: markup
        {
        pushFollow(FOLLOW_markup_in_synpred48_WaebricChecker950);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred48_WaebricChecker

    // Delegated rules

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


    protected DFA19 dfa19 = new DFA19(this);
    protected DFA24 dfa24 = new DFA24(this);
    static final String DFA19_eotS =
        "\15\uffff";
    static final String DFA19_eofS =
        "\15\uffff";
    static final String DFA19_minS =
        "\1\7\5\uffff\1\2\3\uffff\1\13\2\uffff";
    static final String DFA19_maxS =
        "\1\100\5\uffff\1\2\3\uffff\1\66\2\uffff";
    static final String DFA19_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\11\1\12\1\uffff\1\7"+
        "\1\6";
    static final String DFA19_specialS =
        "\15\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\11\14\uffff\1\5\41\uffff\1\4\2\uffff\1\1\1\uffff\1\2\1\3"+
            "\1\uffff\1\6\1\7\1\10",
            "",
            "",
            "",
            "",
            "",
            "\1\12",
            "",
            "",
            "",
            "\1\14\1\uffff\3\14\1\uffff\1\13\42\uffff\1\14\1\uffff\1\14",
            "",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "265:1: statement : ( ^( 'if' '(' predicate ')' statement ( 'else' statement )? ) | eachStatement | letStatement | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT markup markupChain ) );";
        }
    }
    static final String DFA24_eotS =
        "\12\uffff";
    static final String DFA24_eofS =
        "\12\uffff";
    static final String DFA24_minS =
        "\1\13\1\uffff\6\0\2\uffff";
    static final String DFA24_maxS =
        "\1\101\1\uffff\6\0\2\uffff";
    static final String DFA24_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\1\3";
    static final String DFA24_specialS =
        "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\2\uffff}>";
    static final String[] DFA24_transitionS = {
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
            return "316:13: ( '!' predicate | expression | expression '.' type )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TreeNodeStream input = (TreeNodeStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA24_2 = input.LA(1);

                         
                        int index24_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred41_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index24_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA24_3 = input.LA(1);

                         
                        int index24_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred41_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index24_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA24_4 = input.LA(1);

                         
                        int index24_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred41_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index24_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA24_5 = input.LA(1);

                         
                        int index24_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred41_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index24_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA24_6 = input.LA(1);

                         
                        int index24_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred41_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index24_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA24_7 = input.LA(1);

                         
                        int index24_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred41_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index24_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 24, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_40_in_module85 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_moduleId_in_module87 = new BitSet(new long[]{0x0000040000200408L});
    public static final BitSet FOLLOW_imprt_in_module89 = new BitSet(new long[]{0x0000040000200408L});
    public static final BitSet FOLLOW_site_in_module92 = new BitSet(new long[]{0x0000000000200408L});
    public static final BitSet FOLLOW_function_in_module95 = new BitSet(new long[]{0x0000000000000408L});
    public static final BitSet FOLLOW_IDCON_in_moduleId124 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_moduleId134 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDCON_in_moduleId138 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_42_in_imprt159 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_moduleId_in_imprt161 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_module_in_imprt165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SITE_in_site177 = new BitSet(new long[]{0x0000000000C01000L});
    public static final BitSet FOLLOW_mappings_in_site179 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_END_in_site181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapping_in_mappings189 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_SEMICOLON_in_mappings194 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_mapping_in_mappings196 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_PATH_in_mapping208 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_mapping210 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_markup_in_mapping212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUP_in_markup226 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_markup228 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000000000007FL});
    public static final BitSet FOLLOW_arguments_in_markup232 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARGUMENTS_in_arguments254 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_argument_in_arguments258 = new BitSet(new long[]{0x005000000000E808L});
    public static final BitSet FOLLOW_expression_in_argument277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_argument281 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_argument283 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_argument285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varExpression_in_expression300 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_NATCON_in_expression304 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_TEXT_in_expression308 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_SYMBOLCON_in_expression312 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_52_in_expression321 = new BitSet(new long[]{0x007200000000E800L});
    public static final BitSet FOLLOW_expression_in_expression323 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_49_in_expression328 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_expression330 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_53_in_expression335 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_54_in_expression344 = new BitSet(new long[]{0x0082000000000800L});
    public static final BitSet FOLLOW_keyValuePair_in_expression346 = new BitSet(new long[]{0x0082000000000000L});
    public static final BitSet FOLLOW_49_in_expression351 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_keyValuePair_in_expression353 = new BitSet(new long[]{0x0082000000000000L});
    public static final BitSet FOLLOW_55_in_expression358 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_56_in_expression368 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_expression370 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_41_in_expression374 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDCON_in_expression376 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_IDCON_in_varExpression388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_keyValuePair402 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_keyValuePair404 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_keyValuePair406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_function432 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_function434 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_formals_in_function436 = new BitSet(new long[]{0xDA40000000100088L,0x0000000000000001L});
    public static final BitSet FOLLOW_statement_in_function438 = new BitSet(new long[]{0xDA40000000100088L,0x0000000000000001L});
    public static final BitSet FOLLOW_FORMALS_in_formals462 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_formals466 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_57_in_statement486 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_48_in_statement488 = new BitSet(new long[]{0x005000000000E800L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_statement490 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_statement492 = new BitSet(new long[]{0xDA40000000100080L,0x0000000000000001L});
    public static final BitSet FOLLOW_statement_in_statement494 = new BitSet(new long[]{0x0400000000000008L});
    public static final BitSet FOLLOW_58_in_statement498 = new BitSet(new long[]{0xDA40000000100080L,0x0000000000000001L});
    public static final BitSet FOLLOW_statement_in_statement500 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_eachStatement_in_statement512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_letStatement_in_statement519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_statement528 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statement530 = new BitSet(new long[]{0xDAC0000000100080L,0x0000000000000001L});
    public static final BitSet FOLLOW_55_in_statement533 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COMMENT_in_statement544 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRCON_in_statement546 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement548 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_62_in_statement559 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement561 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement563 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_62_in_statement574 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_statement576 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement578 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_63_in_statement589 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement591 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement593 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_64_in_statement602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement611 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement613 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_markupChain_in_statement615 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_CHAIN_in_markupChain631 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_markupChain633 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_markupChain_in_markupChain635 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_CHAIN_in_markupChain646 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_markupChain648 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_markupChain650 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_CHAIN_in_markupChain661 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_markupChain663 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_CHAIN_in_markupChain674 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_markupChain676 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_markupChain678 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_CHAIN_in_markupChain689 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SEMICOLON_in_markupChain691 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_59_in_eachStatement717 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_48_in_eachStatement719 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDCON_in_eachStatement721 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_eachStatement723 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_eachStatement725 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_eachStatement727 = new BitSet(new long[]{0xDA40000000100080L,0x0000000000000001L});
    public static final BitSet FOLLOW_statement_in_eachStatement731 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_60_in_letStatement757 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_assignment_in_letStatement759 = new BitSet(new long[]{0x2000000000000C00L});
    public static final BitSet FOLLOW_61_in_letStatement762 = new BitSet(new long[]{0xDA40000000500080L,0x0000000000000001L});
    public static final BitSet FOLLOW_statement_in_letStatement764 = new BitSet(new long[]{0xDA40000000500080L,0x0000000000000001L});
    public static final BitSet FOLLOW_END_in_letStatement767 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDCON_in_assignment778 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_assignment780 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_assignment782 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_assignment784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funcBinding_in_assignment790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_funcBinding819 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_funcBinding823 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_formals_in_funcBinding827 = new BitSet(new long[]{0xDA40000000100080L,0x0000000000000001L});
    public static final BitSet FOLLOW_statement_in_funcBinding829 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_65_in_predicate855 = new BitSet(new long[]{0x005000000000E800L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_predicate857 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000CL});
    public static final BitSet FOLLOW_expression_in_predicate866 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000CL});
    public static final BitSet FOLLOW_expression_in_predicate874 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_predicate876 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000070L});
    public static final BitSet FOLLOW_type_in_predicate878 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000CL});
    public static final BitSet FOLLOW_66_in_predicate887 = new BitSet(new long[]{0x005000000000E800L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_predicate889 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000CL});
    public static final BitSet FOLLOW_67_in_predicate893 = new BitSet(new long[]{0x005000000000E800L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_predicate895 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000CL});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding930 = new BitSet(new long[]{0x005000000000E840L});
    public static final BitSet FOLLOW_embed_in_embedding932 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_textTail_in_embedding934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed943 = new BitSet(new long[]{0x005000000000E840L});
    public static final BitSet FOLLOW_expression_in_embed946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed950 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_markup_in_embed953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail965 = new BitSet(new long[]{0x005000000000E840L});
    public static final BitSet FOLLOW_embed_in_textTail967 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_textTail_in_textTail969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred18_WaebricChecker368 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_synpred18_WaebricChecker370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_synpred19_WaebricChecker374 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDCON_in_synpred19_WaebricChecker376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred41_WaebricChecker866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_synpred42_WaebricChecker887 = new BitSet(new long[]{0x005000000000E800L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_synpred42_WaebricChecker889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_synpred43_WaebricChecker893 = new BitSet(new long[]{0x005000000000E800L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_synpred43_WaebricChecker895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred47_WaebricChecker943 = new BitSet(new long[]{0x005000000000E840L});
    public static final BitSet FOLLOW_expression_in_synpred47_WaebricChecker946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred48_WaebricChecker950 = new BitSet(new long[]{0x0000000000000002L});

}