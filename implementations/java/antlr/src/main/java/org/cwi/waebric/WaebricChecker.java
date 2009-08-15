// $ANTLR 3.1.2 /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g 2009-08-15 11:47:37

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATTRIBUTES", "ARGUMENTS", "MARKUP", "MARKUP_STATEMENT", "IDCON", "PATH", "NATCON", "TEXT", "SYMBOLCON", "STRCON", "PRETEXT", "POSTTEXT", "MIDTEXT", "COMMENT", "SITE", "END", "SEMICOLON", "LETTER", "DIGIT", "HEXADECIMAL", "PATHELEMENT", "FILEEXT", "STRCHAR", "ESCLAYOUT", "DECIMAL", "TEXTCHAR", "ESCQUOTE", "AMP", "CHARREF", "ENTREF", "SYMBOLCHAR", "COMMENTS", "LAYOUT", "'module'", "'.'", "'import'", "':'", "'#'", "'$'", "'@'", "'%'", "'('", "','", "')'", "'='", "'['", "']'", "'{'", "'}'", "'+'", "'def'", "'if'", "'else'", "'each'", "'let'", "'in'", "'echo'", "'cdata'", "'yield;'", "'!'", "'&&'", "'||'", "'list'", "'record'", "'string'"
    };
    public static final int ESCLAYOUT=27;
    public static final int T__42=42;
    public static final int END=19;
    public static final int T__57=57;
    public static final int T__51=51;
    public static final int FILEEXT=25;
    public static final int T__47=47;
    public static final int T__50=50;
    public static final int STRCHAR=26;
    public static final int T__65=65;
    public static final int SYMBOLCON=12;
    public static final int COMMENTS=35;
    public static final int IDCON=8;
    public static final int DECIMAL=28;
    public static final int T__67=67;
    public static final int HEXADECIMAL=23;
    public static final int T__39=39;
    public static final int TEXTCHAR=29;
    public static final int T__52=52;
    public static final int T__46=46;
    public static final int T__68=68;
    public static final int T__62=62;
    public static final int MARKUP=6;
    public static final int STRCON=13;
    public static final int T__49=49;
    public static final int AMP=31;
    public static final int T__61=61;
    public static final int POSTTEXT=15;
    public static final int T__59=59;
    public static final int ATTRIBUTES=4;
    public static final int DIGIT=22;
    public static final int T__48=48;
    public static final int T__54=54;
    public static final int LAYOUT=36;
    public static final int ESCQUOTE=30;
    public static final int PATHELEMENT=24;
    public static final int T__56=56;
    public static final int ENTREF=33;
    public static final int LETTER=21;
    public static final int ARGUMENTS=5;
    public static final int SITE=18;
    public static final int T__58=58;
    public static final int T__64=64;
    public static final int T__44=44;
    public static final int T__66=66;
    public static final int SYMBOLCHAR=34;
    public static final int COMMENT=17;
    public static final int MARKUP_STATEMENT=7;
    public static final int T__55=55;
    public static final int T__45=45;
    public static final int CHARREF=32;
    public static final int MIDTEXT=16;
    public static final int T__63=63;
    public static final int PRETEXT=14;
    public static final int T__43=43;
    public static final int SEMICOLON=20;
    public static final int T__40=40;
    public static final int EOF=-1;
    public static final int T__53=53;
    public static final int TEXT=11;
    public static final int T__38=38;
    public static final int NATCON=10;
    public static final int T__37=37;
    public static final int T__60=60;
    public static final int T__41=41;
    public static final int PATH=9;

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
            string_literal1=(CommonTree)match(input,37,FOLLOW_37_in_module85); if (state.failed) return retval;
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

                if ( (LA1_0==39) ) {
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

                if ( (LA3_0==54) ) {
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

                if ( (LA4_0==38) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:198:6: '.' id= IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal6=(CommonTree)match(input,38,FOLLOW_38_in_moduleId134); if (state.failed) return retval;
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
            string_literal7=(CommonTree)match(input,39,FOLLOW_39_in_imprt159); if (state.failed) return retval;
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
            char_literal17=(CommonTree)match(input,40,FOLLOW_40_in_mapping210); if (state.failed) return retval;
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

         int args = 0; 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:219:2: ( ^( MARKUP IDCON . arguments ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:219:5: ^( MARKUP IDCON . arguments )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            MARKUP19=(CommonTree)match(input,MARKUP,FOLLOW_MARKUP_in_markup233); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MARKUP19_tree = (CommonTree)adaptor.dupNode(MARKUP19);

            root_1 = (CommonTree)adaptor.becomeRoot(MARKUP19_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            IDCON20=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_markup235); if (state.failed) return retval;
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
            pushFollow(FOLLOW_arguments_in_markup239);
            arguments22=arguments();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, arguments22.getTree());

            match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }

            if ( state.backtracking==0 ) {

              				if(isDefinedFunction(IDCON20.getText())) {
              					int actual = getFunctionArgs(IDCON20.getText());
              					if(args != actual) {
              						exceptions.add(new ArityMismatchException(IDCON20, args));
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:230:1: arguments returns [int args = 0] : ^( ARGUMENTS ( argument )* ) ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:231:2: ( ^( ARGUMENTS ( argument )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:231:5: ^( ARGUMENTS ( argument )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            ARGUMENTS23=(CommonTree)match(input,ARGUMENTS,FOLLOW_ARGUMENTS_in_arguments261); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ARGUMENTS23_tree = (CommonTree)adaptor.dupNode(ARGUMENTS23);

            root_1 = (CommonTree)adaptor.becomeRoot(ARGUMENTS23_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:231:18: ( argument )*
                loop7:
                do {
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==IDCON||(LA7_0>=NATCON && LA7_0<=SYMBOLCON)||LA7_0==49||LA7_0==51) ) {
                        alt7=1;
                    }


                    switch (alt7) {
                	case 1 :
                	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:231:20: argument
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_argument_in_arguments265);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:233:1: argument : ( expression | IDCON '=' expression );
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:233:9: ( expression | IDCON '=' expression )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==IDCON) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==48) ) {
                    alt8=2;
                }
                else if ( (LA8_1==EOF||LA8_1==UP||LA8_1==IDCON||(LA8_1>=NATCON && LA8_1<=SYMBOLCON)||LA8_1==38||LA8_1==49||LA8_1==51||LA8_1==53) ) {
                    alt8=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA8_0>=NATCON && LA8_0<=SYMBOLCON)||LA8_0==49||LA8_0==51) ) {
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:233:12: expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_argument284);
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:233:25: IDCON '=' expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDCON26=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_argument288); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON26_tree = (CommonTree)adaptor.dupNode(IDCON26);

                    adaptor.addChild(root_0, IDCON26_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal27=(CommonTree)match(input,48,FOLLOW_48_in_argument290); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal27_tree = (CommonTree)adaptor.dupNode(char_literal27);

                    adaptor.addChild(root_0, char_literal27_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_argument292);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:239:1: expression : ( varExpression | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:239:11: ( ( varExpression | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:239:14: ( varExpression | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:239:14: ( varExpression | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' )
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
            case 49:
                {
                alt13=5;
                }
                break;
            case 51:
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:239:16: varExpression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_varExpression_in_expression307);
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:239:32: NATCON
                    {
                    _last = (CommonTree)input.LT(1);
                    NATCON30=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_expression311); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON30_tree = (CommonTree)adaptor.dupNode(NATCON30);

                    adaptor.addChild(root_0, NATCON30_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:239:41: TEXT
                    {
                    _last = (CommonTree)input.LT(1);
                    TEXT31=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_expression315); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TEXT31_tree = (CommonTree)adaptor.dupNode(TEXT31);

                    adaptor.addChild(root_0, TEXT31_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:239:48: SYMBOLCON
                    {
                    _last = (CommonTree)input.LT(1);
                    SYMBOLCON32=(CommonTree)match(input,SYMBOLCON,FOLLOW_SYMBOLCON_in_expression319); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SYMBOLCON32_tree = (CommonTree)adaptor.dupNode(SYMBOLCON32);

                    adaptor.addChild(root_0, SYMBOLCON32_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:240:7: '[' ( expression )? ( ',' expression )* ']'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal33=(CommonTree)match(input,49,FOLLOW_49_in_expression328); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal33_tree = (CommonTree)adaptor.dupNode(char_literal33);

                    adaptor.addChild(root_0, char_literal33_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:240:11: ( expression )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==IDCON||(LA9_0>=NATCON && LA9_0<=SYMBOLCON)||LA9_0==49||LA9_0==51) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: expression
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_expression_in_expression330);
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

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:240:23: ( ',' expression )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==46) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:240:25: ',' expression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal35=(CommonTree)match(input,46,FOLLOW_46_in_expression335); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal35_tree = (CommonTree)adaptor.dupNode(char_literal35);

                    	    adaptor.addChild(root_0, char_literal35_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_expression_in_expression337);
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
                    char_literal37=(CommonTree)match(input,50,FOLLOW_50_in_expression342); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal37_tree = (CommonTree)adaptor.dupNode(char_literal37);

                    adaptor.addChild(root_0, char_literal37_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:241:7: '{' ( keyValuePair )? ( ',' keyValuePair )* '}'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal38=(CommonTree)match(input,51,FOLLOW_51_in_expression351); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal38_tree = (CommonTree)adaptor.dupNode(char_literal38);

                    adaptor.addChild(root_0, char_literal38_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:241:11: ( keyValuePair )?
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
                            pushFollow(FOLLOW_keyValuePair_in_expression353);
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

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:241:25: ( ',' keyValuePair )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==46) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:241:27: ',' keyValuePair
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal40=(CommonTree)match(input,46,FOLLOW_46_in_expression358); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal40_tree = (CommonTree)adaptor.dupNode(char_literal40);

                    	    adaptor.addChild(root_0, char_literal40_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_keyValuePair_in_expression360);
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
                    char_literal42=(CommonTree)match(input,52,FOLLOW_52_in_expression365); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal42_tree = (CommonTree)adaptor.dupNode(char_literal42);

                    adaptor.addChild(root_0, char_literal42_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:242:6: ( '+' expression | '.' IDCON )*
            loop14:
            do {
                int alt14=3;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==53) ) {
                    int LA14_2 = input.LA(2);

                    if ( (synpred18_WaebricChecker()) ) {
                        alt14=1;
                    }


                }
                else if ( (LA14_0==38) ) {
                    int LA14_3 = input.LA(2);

                    if ( (synpred19_WaebricChecker()) ) {
                        alt14=2;
                    }


                }


                switch (alt14) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:242:8: '+' expression
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal43=(CommonTree)match(input,53,FOLLOW_53_in_expression375); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal43_tree = (CommonTree)adaptor.dupNode(char_literal43);

            	    adaptor.addChild(root_0, char_literal43_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expression_in_expression377);
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
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:242:25: '.' IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal45=(CommonTree)match(input,38,FOLLOW_38_in_expression381); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal45_tree = (CommonTree)adaptor.dupNode(char_literal45);

            	    adaptor.addChild(root_0, char_literal45_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    IDCON46=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression383); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:244:1: varExpression : IDCON ;
    public final WaebricChecker.varExpression_return varExpression() throws RecognitionException {
        WaebricChecker.varExpression_return retval = new WaebricChecker.varExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON47=null;

        CommonTree IDCON47_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:244:14: ( IDCON )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:244:17: IDCON
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON47=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_varExpression395); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:250:1: keyValuePair : IDCON ':' expression ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:250:13: ( IDCON ':' expression )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:250:16: IDCON ':' expression
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON48=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_keyValuePair409); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON48_tree = (CommonTree)adaptor.dupNode(IDCON48);

            adaptor.addChild(root_0, IDCON48_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal49=(CommonTree)match(input,40,FOLLOW_40_in_keyValuePair411); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal49_tree = (CommonTree)adaptor.dupNode(char_literal49);

            adaptor.addChild(root_0, char_literal49_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_keyValuePair413);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:254:1: function : 'def' IDCON ( formals )? ( statement )* 'end' ;
    public final WaebricChecker.function_return function() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.function_return retval = new WaebricChecker.function_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal51=null;
        CommonTree IDCON52=null;
        CommonTree string_literal55=null;
        WaebricChecker.formals_return formals53 = null;

        WaebricChecker.statement_return statement54 = null;


        CommonTree string_literal51_tree=null;
        CommonTree IDCON52_tree=null;
        CommonTree string_literal55_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new ArrayList<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:259:4: ( 'def' IDCON ( formals )? ( statement )* 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:259:7: 'def' IDCON ( formals )? ( statement )* 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal51=(CommonTree)match(input,54,FOLLOW_54_in_function437); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal51_tree = (CommonTree)adaptor.dupNode(string_literal51);

            adaptor.addChild(root_0, string_literal51_tree);
            }
            _last = (CommonTree)input.LT(1);
            IDCON52=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_function439); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON52_tree = (CommonTree)adaptor.dupNode(IDCON52);

            adaptor.addChild(root_0, IDCON52_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:259:19: ( formals )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==45) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: formals
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_formals_in_function441);
                    formals53=formals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, formals53.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:259:28: ( statement )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==MARKUP_STATEMENT||LA16_0==COMMENT||LA16_0==51||LA16_0==55||(LA16_0>=57 && LA16_0<=58)||(LA16_0>=60 && LA16_0<=62)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_function444);
            	    statement54=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, statement54.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            string_literal55=(CommonTree)match(input,END,FOLLOW_END_in_function447); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal55_tree = (CommonTree)adaptor.dupNode(string_literal55);

            adaptor.addChild(root_0, string_literal55_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:261:1: formals returns [int args = 0] : '(' ( IDCON )* ')' ;
    public final WaebricChecker.formals_return formals() throws RecognitionException {
        WaebricChecker.formals_return retval = new WaebricChecker.formals_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal56=null;
        CommonTree IDCON57=null;
        CommonTree char_literal58=null;

        CommonTree char_literal56_tree=null;
        CommonTree IDCON57_tree=null;
        CommonTree char_literal58_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:262:2: ( '(' ( IDCON )* ')' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:262:5: '(' ( IDCON )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            char_literal56=(CommonTree)match(input,45,FOLLOW_45_in_formals466); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal56_tree = (CommonTree)adaptor.dupNode(char_literal56);

            adaptor.addChild(root_0, char_literal56_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:262:9: ( IDCON )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==IDCON) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:262:11: IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    IDCON57=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_formals470); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDCON57_tree = (CommonTree)adaptor.dupNode(IDCON57);

            	    adaptor.addChild(root_0, IDCON57_tree);
            	    }
            	    if ( state.backtracking==0 ) {
            	       defineVariable(IDCON57.getText()); retval.args++; 
            	    }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            char_literal58=(CommonTree)match(input,47,FOLLOW_47_in_formals477); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal58_tree = (CommonTree)adaptor.dupNode(char_literal58);

            adaptor.addChild(root_0, char_literal58_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:266:1: statement : ( ^( 'if' '(' predicate ')' statement ( 'else' statement )? ) | eachStatement | letStatement | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ^( MARKUP_STATEMENT ( markup )+ statement ) | ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) | ^( MARKUP_STATEMENT ( markup )+ ';' ) );
    public final WaebricChecker.statement_return statement() throws RecognitionException {
        WaebricChecker.statement_return retval = new WaebricChecker.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal59=null;
        CommonTree char_literal60=null;
        CommonTree char_literal62=null;
        CommonTree string_literal64=null;
        CommonTree char_literal68=null;
        CommonTree char_literal70=null;
        CommonTree string_literal71=null;
        CommonTree STRCON72=null;
        CommonTree char_literal73=null;
        CommonTree string_literal74=null;
        CommonTree char_literal76=null;
        CommonTree string_literal77=null;
        CommonTree char_literal79=null;
        CommonTree string_literal80=null;
        CommonTree char_literal82=null;
        CommonTree string_literal83=null;
        CommonTree MARKUP_STATEMENT84=null;
        CommonTree char_literal87=null;
        CommonTree MARKUP_STATEMENT88=null;
        CommonTree MARKUP_STATEMENT91=null;
        CommonTree char_literal94=null;
        CommonTree MARKUP_STATEMENT95=null;
        CommonTree char_literal97=null;
        WaebricChecker.predicate_return predicate61 = null;

        WaebricChecker.statement_return statement63 = null;

        WaebricChecker.statement_return statement65 = null;

        WaebricChecker.eachStatement_return eachStatement66 = null;

        WaebricChecker.letStatement_return letStatement67 = null;

        WaebricChecker.statement_return statement69 = null;

        WaebricChecker.expression_return expression75 = null;

        WaebricChecker.embedding_return embedding78 = null;

        WaebricChecker.expression_return expression81 = null;

        WaebricChecker.markup_return markup85 = null;

        WaebricChecker.expression_return expression86 = null;

        WaebricChecker.markup_return markup89 = null;

        WaebricChecker.statement_return statement90 = null;

        WaebricChecker.markup_return markup92 = null;

        WaebricChecker.embedding_return embedding93 = null;

        WaebricChecker.markup_return markup96 = null;


        CommonTree string_literal59_tree=null;
        CommonTree char_literal60_tree=null;
        CommonTree char_literal62_tree=null;
        CommonTree string_literal64_tree=null;
        CommonTree char_literal68_tree=null;
        CommonTree char_literal70_tree=null;
        CommonTree string_literal71_tree=null;
        CommonTree STRCON72_tree=null;
        CommonTree char_literal73_tree=null;
        CommonTree string_literal74_tree=null;
        CommonTree char_literal76_tree=null;
        CommonTree string_literal77_tree=null;
        CommonTree char_literal79_tree=null;
        CommonTree string_literal80_tree=null;
        CommonTree char_literal82_tree=null;
        CommonTree string_literal83_tree=null;
        CommonTree MARKUP_STATEMENT84_tree=null;
        CommonTree char_literal87_tree=null;
        CommonTree MARKUP_STATEMENT88_tree=null;
        CommonTree MARKUP_STATEMENT91_tree=null;
        CommonTree char_literal94_tree=null;
        CommonTree MARKUP_STATEMENT95_tree=null;
        CommonTree char_literal97_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:266:10: ( ^( 'if' '(' predicate ')' statement ( 'else' statement )? ) | eachStatement | letStatement | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ^( MARKUP_STATEMENT ( markup )+ statement ) | ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) | ^( MARKUP_STATEMENT ( markup )+ ';' ) )
            int alt24=13;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:266:13: ^( 'if' '(' predicate ')' statement ( 'else' statement )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal59=(CommonTree)match(input,55,FOLLOW_55_in_statement490); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal59_tree = (CommonTree)adaptor.dupNode(string_literal59);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal59_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    char_literal60=(CommonTree)match(input,45,FOLLOW_45_in_statement492); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal60_tree = (CommonTree)adaptor.dupNode(char_literal60);

                    adaptor.addChild(root_1, char_literal60_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_statement494);
                    predicate61=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, predicate61.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal62=(CommonTree)match(input,47,FOLLOW_47_in_statement496); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal62_tree = (CommonTree)adaptor.dupNode(char_literal62);

                    adaptor.addChild(root_1, char_literal62_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement498);
                    statement63=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement63.getTree());
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:266:49: ( 'else' statement )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==56) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:266:51: 'else' statement
                            {
                            _last = (CommonTree)input.LT(1);
                            string_literal64=(CommonTree)match(input,56,FOLLOW_56_in_statement502); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal64_tree = (CommonTree)adaptor.dupNode(string_literal64);

                            adaptor.addChild(root_1, string_literal64_tree);
                            }
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_statement_in_statement504);
                            statement65=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, statement65.getTree());

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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:267:6: eachStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_eachStatement_in_statement516);
                    eachStatement66=eachStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, eachStatement66.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:268:6: letStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_letStatement_in_statement523);
                    letStatement67=letStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, letStatement67.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:269:6: ^( '{' ( statement )* '}' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal68=(CommonTree)match(input,51,FOLLOW_51_in_statement532); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal68_tree = (CommonTree)adaptor.dupNode(char_literal68);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal68_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:269:13: ( statement )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==MARKUP_STATEMENT||LA19_0==COMMENT||LA19_0==51||LA19_0==55||(LA19_0>=57 && LA19_0<=58)||(LA19_0>=60 && LA19_0<=62)) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: statement
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_statement_in_statement534);
                    	    statement69=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, statement69.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal70=(CommonTree)match(input,52,FOLLOW_52_in_statement537); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal70_tree = (CommonTree)adaptor.dupNode(char_literal70);

                    adaptor.addChild(root_1, char_literal70_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:270:6: ^( 'comment' STRCON ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal71=(CommonTree)match(input,COMMENT,FOLLOW_COMMENT_in_statement548); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal71_tree = (CommonTree)adaptor.dupNode(string_literal71);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal71_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    STRCON72=(CommonTree)match(input,STRCON,FOLLOW_STRCON_in_statement550); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRCON72_tree = (CommonTree)adaptor.dupNode(STRCON72);

                    adaptor.addChild(root_1, STRCON72_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal73=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement552); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal73_tree = (CommonTree)adaptor.dupNode(char_literal73);

                    adaptor.addChild(root_1, char_literal73_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:271:6: ^( 'echo' expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal74=(CommonTree)match(input,60,FOLLOW_60_in_statement563); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal74_tree = (CommonTree)adaptor.dupNode(string_literal74);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal74_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement565);
                    expression75=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression75.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal76=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement567); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal76_tree = (CommonTree)adaptor.dupNode(char_literal76);

                    adaptor.addChild(root_1, char_literal76_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:272:6: ^( 'echo' embedding ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal77=(CommonTree)match(input,60,FOLLOW_60_in_statement578); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal77_tree = (CommonTree)adaptor.dupNode(string_literal77);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal77_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement580);
                    embedding78=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding78.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal79=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement582); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal79_tree = (CommonTree)adaptor.dupNode(char_literal79);

                    adaptor.addChild(root_1, char_literal79_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:273:6: ^( 'cdata' expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal80=(CommonTree)match(input,61,FOLLOW_61_in_statement593); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal80_tree = (CommonTree)adaptor.dupNode(string_literal80);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal80_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement595);
                    expression81=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression81.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal82=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement597); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal82_tree = (CommonTree)adaptor.dupNode(char_literal82);

                    adaptor.addChild(root_1, char_literal82_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:274:6: 'yield;'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal83=(CommonTree)match(input,62,FOLLOW_62_in_statement606); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal83_tree = (CommonTree)adaptor.dupNode(string_literal83);

                    adaptor.addChild(root_0, string_literal83_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:275:6: ^( MARKUP_STATEMENT ( markup )+ expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT84=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement615); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT84_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT84);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT84_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:275:26: ( markup )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==MARKUP) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement617);
                    	    markup85=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup85.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
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

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement620);
                    expression86=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression86.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal87=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement622); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal87_tree = (CommonTree)adaptor.dupNode(char_literal87);

                    adaptor.addChild(root_1, char_literal87_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:276:6: ^( MARKUP_STATEMENT ( markup )+ statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT88=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement633); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT88_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT88);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT88_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:276:26: ( markup )+
                    int cnt21=0;
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==MARKUP) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement635);
                    	    markup89=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup89.getTree());

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
                    pushFollow(FOLLOW_statement_in_statement638);
                    statement90=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement90.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:277:6: ^( MARKUP_STATEMENT ( markup )+ embedding ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT91=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement649); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT91_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT91);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT91_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:277:26: ( markup )+
                    int cnt22=0;
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==MARKUP) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement651);
                    	    markup92=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup92.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
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

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement654);
                    embedding93=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding93.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal94=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement656); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal94_tree = (CommonTree)adaptor.dupNode(char_literal94);

                    adaptor.addChild(root_1, char_literal94_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:278:6: ^( MARKUP_STATEMENT ( markup )+ ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT95=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement667); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT95_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT95);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT95_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:278:26: ( markup )+
                    int cnt23=0;
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==MARKUP) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement669);
                    	    markup96=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup96.getTree());

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
                    char_literal97=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement672); if (state.failed) return retval;
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
    // $ANTLR end "statement"

    public static class eachStatement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "eachStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:280:1: eachStatement : ^( 'each' '(' IDCON ':' expression ')' statement ) ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:285:4: ( ^( 'each' '(' IDCON ':' expression ')' statement ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:285:7: ^( 'each' '(' IDCON ':' expression ')' statement )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal98=(CommonTree)match(input,57,FOLLOW_57_in_eachStatement698); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal98_tree = (CommonTree)adaptor.dupNode(string_literal98);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal98_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            char_literal99=(CommonTree)match(input,45,FOLLOW_45_in_eachStatement700); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal99_tree = (CommonTree)adaptor.dupNode(char_literal99);

            adaptor.addChild(root_1, char_literal99_tree);
            }
            _last = (CommonTree)input.LT(1);
            IDCON100=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_eachStatement702); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON100_tree = (CommonTree)adaptor.dupNode(IDCON100);

            adaptor.addChild(root_1, IDCON100_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal101=(CommonTree)match(input,40,FOLLOW_40_in_eachStatement704); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal101_tree = (CommonTree)adaptor.dupNode(char_literal101);

            adaptor.addChild(root_1, char_literal101_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_eachStatement706);
            expression102=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expression102.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal103=(CommonTree)match(input,47,FOLLOW_47_in_eachStatement708); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal103_tree = (CommonTree)adaptor.dupNode(char_literal103);

            adaptor.addChild(root_1, char_literal103_tree);
            }
            if ( state.backtracking==0 ) {
               
              				defineVariable(IDCON100.getText()); // Define variable before statement is executed
              			
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_eachStatement712);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:289:1: letStatement : ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:294:4: ( ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:294:7: ^( 'let' ( assignment )+ 'in' ( statement )* 'end' )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal105=(CommonTree)match(input,58,FOLLOW_58_in_letStatement738); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal105_tree = (CommonTree)adaptor.dupNode(string_literal105);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal105_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:294:16: ( assignment )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==IDCON||LA25_0==54) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: assignment
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_assignment_in_letStatement740);
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
            	    if ( cnt25 >= 1 ) break loop25;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
            } while (true);

            _last = (CommonTree)input.LT(1);
            string_literal107=(CommonTree)match(input,59,FOLLOW_59_in_letStatement743); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal107_tree = (CommonTree)adaptor.dupNode(string_literal107);

            adaptor.addChild(root_1, string_literal107_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:294:33: ( statement )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==MARKUP_STATEMENT||LA26_0==COMMENT||LA26_0==51||LA26_0==55||(LA26_0>=57 && LA26_0<=58)||(LA26_0>=60 && LA26_0<=62)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_letStatement745);
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
            	    break loop26;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            string_literal109=(CommonTree)match(input,END,FOLLOW_END_in_letStatement748); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:296:1: assignment : ( IDCON '=' expression ';' | funcBinding );
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:296:11: ( IDCON '=' expression ';' | funcBinding )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==IDCON) ) {
                alt27=1;
            }
            else if ( (LA27_0==54) ) {
                alt27=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:296:14: IDCON '=' expression ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDCON110=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_assignment759); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON110_tree = (CommonTree)adaptor.dupNode(IDCON110);

                    adaptor.addChild(root_0, IDCON110_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal111=(CommonTree)match(input,48,FOLLOW_48_in_assignment761); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal111_tree = (CommonTree)adaptor.dupNode(char_literal111);

                    adaptor.addChild(root_0, char_literal111_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_assignment763);
                    expression112=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression112.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal113=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_assignment765); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:298:8: funcBinding
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_funcBinding_in_assignment771);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:300:1: funcBinding : 'def' id= IDCON f= formals statement 'end' ;
    public final WaebricChecker.funcBinding_return funcBinding() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.funcBinding_return retval = new WaebricChecker.funcBinding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        CommonTree string_literal115=null;
        CommonTree string_literal117=null;
        WaebricChecker.formals_return f = null;

        WaebricChecker.statement_return statement116 = null;


        CommonTree id_tree=null;
        CommonTree string_literal115_tree=null;
        CommonTree string_literal117_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new ArrayList<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:305:4: ( 'def' id= IDCON f= formals statement 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:305:8: 'def' id= IDCON f= formals statement 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal115=(CommonTree)match(input,54,FOLLOW_54_in_funcBinding798); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal115_tree = (CommonTree)adaptor.dupNode(string_literal115);

            adaptor.addChild(root_0, string_literal115_tree);
            }
            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_funcBinding802); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (CommonTree)adaptor.dupNode(id);

            adaptor.addChild(root_0, id_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_formals_in_funcBinding806);
            f=formals();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, f.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_funcBinding808);
            statement116=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, statement116.getTree());
            _last = (CommonTree)input.LT(1);
            string_literal117=(CommonTree)match(input,END,FOLLOW_END_in_funcBinding810); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal117_tree = (CommonTree)adaptor.dupNode(string_literal117);

            adaptor.addChild(root_0, string_literal117_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:314:1: predicate : ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )* ;
    public final WaebricChecker.predicate_return predicate() throws RecognitionException {
        WaebricChecker.predicate_return retval = new WaebricChecker.predicate_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal118=null;
        CommonTree char_literal122=null;
        CommonTree string_literal124=null;
        CommonTree string_literal126=null;
        WaebricChecker.predicate_return predicate119 = null;

        WaebricChecker.expression_return expression120 = null;

        WaebricChecker.expression_return expression121 = null;

        WaebricChecker.type_return type123 = null;

        WaebricChecker.predicate_return predicate125 = null;

        WaebricChecker.predicate_return predicate127 = null;


        CommonTree char_literal118_tree=null;
        CommonTree char_literal122_tree=null;
        CommonTree string_literal124_tree=null;
        CommonTree string_literal126_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:314:10: ( ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:314:13: ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:314:13: ( '!' predicate | expression | expression '.' type )
            int alt28=3;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:314:15: '!' predicate
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal118=(CommonTree)match(input,63,FOLLOW_63_in_predicate834); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal118_tree = (CommonTree)adaptor.dupNode(char_literal118);

                    adaptor.addChild(root_0, char_literal118_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_predicate836);
                    predicate119=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, predicate119.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:315:7: expression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate845);
                    expression120=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression120.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:316:7: expression '.' type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate853);
                    expression121=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression121.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal122=(CommonTree)match(input,38,FOLLOW_38_in_predicate855); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal122_tree = (CommonTree)adaptor.dupNode(char_literal122);

                    adaptor.addChild(root_0, char_literal122_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_predicate857);
                    type123=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, type123.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:317:6: ( '&&' predicate | '||' predicate )*
            loop29:
            do {
                int alt29=3;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==64) ) {
                    int LA29_2 = input.LA(2);

                    if ( (synpred46_WaebricChecker()) ) {
                        alt29=1;
                    }


                }
                else if ( (LA29_0==65) ) {
                    int LA29_3 = input.LA(2);

                    if ( (synpred47_WaebricChecker()) ) {
                        alt29=2;
                    }


                }


                switch (alt29) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:317:8: '&&' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal124=(CommonTree)match(input,64,FOLLOW_64_in_predicate866); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal124_tree = (CommonTree)adaptor.dupNode(string_literal124);

            	    adaptor.addChild(root_0, string_literal124_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate868);
            	    predicate125=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, predicate125.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:317:25: '||' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal126=(CommonTree)match(input,65,FOLLOW_65_in_predicate872); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal126_tree = (CommonTree)adaptor.dupNode(string_literal126);

            	    adaptor.addChild(root_0, string_literal126_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate874);
            	    predicate127=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, predicate127.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop29;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:318:1: type : ( 'list' | 'record' | 'string' );
    public final WaebricChecker.type_return type() throws RecognitionException {
        WaebricChecker.type_return retval = new WaebricChecker.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set128=null;

        CommonTree set128_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:318:5: ( 'list' | 'record' | 'string' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            set128=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=66 && input.LA(1)<=68) ) {
                input.consume();

                if ( state.backtracking==0 ) {
                set128_tree = (CommonTree)adaptor.dupNode(set128);

                adaptor.addChild(root_0, set128_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:324:1: embedding : PRETEXT embed textTail ;
    public final WaebricChecker.embedding_return embedding() throws RecognitionException {
        WaebricChecker.embedding_return retval = new WaebricChecker.embedding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PRETEXT129=null;
        WaebricChecker.embed_return embed130 = null;

        WaebricChecker.textTail_return textTail131 = null;


        CommonTree PRETEXT129_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:324:10: ( PRETEXT embed textTail )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:324:13: PRETEXT embed textTail
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PRETEXT129=(CommonTree)match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding909); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRETEXT129_tree = (CommonTree)adaptor.dupNode(PRETEXT129);

            adaptor.addChild(root_0, PRETEXT129_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_embed_in_embedding911);
            embed130=embed();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, embed130.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_textTail_in_embedding913);
            textTail131=textTail();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, textTail131.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:325:1: embed : ( ( markup )* expression | ( markup )* markup );
    public final WaebricChecker.embed_return embed() throws RecognitionException {
        WaebricChecker.embed_return retval = new WaebricChecker.embed_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricChecker.markup_return markup132 = null;

        WaebricChecker.expression_return expression133 = null;

        WaebricChecker.markup_return markup134 = null;

        WaebricChecker.markup_return markup135 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:325:6: ( ( markup )* expression | ( markup )* markup )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==MARKUP) ) {
                int LA32_1 = input.LA(2);

                if ( (synpred51_WaebricChecker()) ) {
                    alt32=1;
                }
                else if ( (true) ) {
                    alt32=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 32, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA32_0==IDCON||(LA32_0>=NATCON && LA32_0<=SYMBOLCON)||LA32_0==49||LA32_0==51) ) {
                alt32=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:325:10: ( markup )* expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:325:10: ( markup )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==MARKUP) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed922);
                    	    markup132=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup132.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_embed925);
                    expression133=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression133.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:325:31: ( markup )* markup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:325:31: ( markup )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==MARKUP) ) {
                            int LA31_1 = input.LA(2);

                            if ( (synpred52_WaebricChecker()) ) {
                                alt31=1;
                            }


                        }


                        switch (alt31) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed929);
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
                    	    break loop31;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_embed932);
                    markup135=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, markup135.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:326:1: textTail : ( POSTTEXT | MIDTEXT embed textTail );
    public final WaebricChecker.textTail_return textTail() throws RecognitionException {
        WaebricChecker.textTail_return retval = new WaebricChecker.textTail_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POSTTEXT136=null;
        CommonTree MIDTEXT137=null;
        WaebricChecker.embed_return embed138 = null;

        WaebricChecker.textTail_return textTail139 = null;


        CommonTree POSTTEXT136_tree=null;
        CommonTree MIDTEXT137_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:326:9: ( POSTTEXT | MIDTEXT embed textTail )
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:326:12: POSTTEXT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    POSTTEXT136=(CommonTree)match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail940); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    POSTTEXT136_tree = (CommonTree)adaptor.dupNode(POSTTEXT136);

                    adaptor.addChild(root_0, POSTTEXT136_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:326:23: MIDTEXT embed textTail
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    MIDTEXT137=(CommonTree)match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail944); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MIDTEXT137_tree = (CommonTree)adaptor.dupNode(MIDTEXT137);

                    adaptor.addChild(root_0, MIDTEXT137_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embed_in_textTail946);
                    embed138=embed();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, embed138.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_textTail_in_textTail948);
                    textTail139=textTail();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, textTail139.getTree());

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
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:242:8: ( '+' expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:242:8: '+' expression
        {
        match(input,53,FOLLOW_53_in_synpred18_WaebricChecker375); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred18_WaebricChecker377);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_WaebricChecker

    // $ANTLR start synpred19_WaebricChecker
    public final void synpred19_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:242:25: ( '.' IDCON )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:242:25: '.' IDCON
        {
        match(input,38,FOLLOW_38_in_synpred19_WaebricChecker381); if (state.failed) return ;
        match(input,IDCON,FOLLOW_IDCON_in_synpred19_WaebricChecker383); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_WaebricChecker

    // $ANTLR start synpred30_WaebricChecker
    public final void synpred30_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:271:6: ( ^( 'echo' expression ';' ) )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:271:6: ^( 'echo' expression ';' )
        {
        match(input,60,FOLLOW_60_in_synpred30_WaebricChecker563); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred30_WaebricChecker565);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred30_WaebricChecker567); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_WaebricChecker

    // $ANTLR start synpred31_WaebricChecker
    public final void synpred31_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:272:6: ( ^( 'echo' embedding ';' ) )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:272:6: ^( 'echo' embedding ';' )
        {
        match(input,60,FOLLOW_60_in_synpred31_WaebricChecker578); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_embedding_in_synpred31_WaebricChecker580);
        embedding();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred31_WaebricChecker582); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_WaebricChecker

    // $ANTLR start synpred35_WaebricChecker
    public final void synpred35_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:275:6: ( ^( MARKUP_STATEMENT ( markup )+ expression ';' ) )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:275:6: ^( MARKUP_STATEMENT ( markup )+ expression ';' )
        {
        match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_synpred35_WaebricChecker615); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:275:26: ( markup )+
        int cnt38=0;
        loop38:
        do {
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==MARKUP) ) {
                alt38=1;
            }


            switch (alt38) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred35_WaebricChecker617);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt38 >= 1 ) break loop38;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(38, input);
                    throw eee;
            }
            cnt38++;
        } while (true);

        pushFollow(FOLLOW_expression_in_synpred35_WaebricChecker620);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred35_WaebricChecker622); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred35_WaebricChecker

    // $ANTLR start synpred37_WaebricChecker
    public final void synpred37_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:276:6: ( ^( MARKUP_STATEMENT ( markup )+ statement ) )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:276:6: ^( MARKUP_STATEMENT ( markup )+ statement )
        {
        match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_synpred37_WaebricChecker633); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:276:26: ( markup )+
        int cnt39=0;
        loop39:
        do {
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==MARKUP) ) {
                alt39=1;
            }


            switch (alt39) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred37_WaebricChecker635);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt39 >= 1 ) break loop39;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(39, input);
                    throw eee;
            }
            cnt39++;
        } while (true);

        pushFollow(FOLLOW_statement_in_synpred37_WaebricChecker638);
        statement();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred37_WaebricChecker

    // $ANTLR start synpred39_WaebricChecker
    public final void synpred39_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:277:6: ( ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:277:6: ^( MARKUP_STATEMENT ( markup )+ embedding ';' )
        {
        match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_synpred39_WaebricChecker649); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:277:26: ( markup )+
        int cnt40=0;
        loop40:
        do {
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==MARKUP) ) {
                alt40=1;
            }


            switch (alt40) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred39_WaebricChecker651);
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

        pushFollow(FOLLOW_embedding_in_synpred39_WaebricChecker654);
        embedding();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred39_WaebricChecker656); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_WaebricChecker

    // $ANTLR start synpred45_WaebricChecker
    public final void synpred45_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:315:7: ( expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:315:7: expression
        {
        pushFollow(FOLLOW_expression_in_synpred45_WaebricChecker845);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred45_WaebricChecker

    // $ANTLR start synpred46_WaebricChecker
    public final void synpred46_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:317:8: ( '&&' predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:317:8: '&&' predicate
        {
        match(input,64,FOLLOW_64_in_synpred46_WaebricChecker866); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred46_WaebricChecker868);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_WaebricChecker

    // $ANTLR start synpred47_WaebricChecker
    public final void synpred47_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:317:25: ( '||' predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:317:25: '||' predicate
        {
        match(input,65,FOLLOW_65_in_synpred47_WaebricChecker872); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred47_WaebricChecker874);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred47_WaebricChecker

    // $ANTLR start synpred51_WaebricChecker
    public final void synpred51_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:325:10: ( ( markup )* expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:325:10: ( markup )* expression
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:325:10: ( markup )*
        loop41:
        do {
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==MARKUP) ) {
                alt41=1;
            }


            switch (alt41) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred51_WaebricChecker922);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop41;
            }
        } while (true);

        pushFollow(FOLLOW_expression_in_synpred51_WaebricChecker925);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred51_WaebricChecker

    // $ANTLR start synpred52_WaebricChecker
    public final void synpred52_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:325:31: ( markup )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:325:31: markup
        {
        pushFollow(FOLLOW_markup_in_synpred52_WaebricChecker929);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred52_WaebricChecker

    // Delegated rules

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


    protected DFA24 dfa24 = new DFA24(this);
    protected DFA28 dfa28 = new DFA28(this);
    static final String DFA24_eotS =
        "\20\uffff";
    static final String DFA24_eofS =
        "\20\uffff";
    static final String DFA24_minS =
        "\1\7\5\uffff\1\0\2\uffff\1\0\6\uffff";
    static final String DFA24_maxS =
        "\1\76\5\uffff\1\0\2\uffff\1\0\6\uffff";
    static final String DFA24_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\11\1\uffff\1\6\1\7\1"+
        "\12\1\13\1\14\1\15";
    static final String DFA24_specialS =
        "\6\uffff\1\0\2\uffff\1\1\6\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\11\11\uffff\1\5\41\uffff\1\4\3\uffff\1\1\1\uffff\1\2\1\3"+
            "\1\uffff\1\6\1\7\1\10",
            "",
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
            return "266:1: statement : ( ^( 'if' '(' predicate ')' statement ( 'else' statement )? ) | eachStatement | letStatement | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ^( MARKUP_STATEMENT ( markup )+ statement ) | ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) | ^( MARKUP_STATEMENT ( markup )+ ';' ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TreeNodeStream input = (TreeNodeStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA24_6 = input.LA(1);

                         
                        int index24_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_WaebricChecker()) ) {s = 10;}

                        else if ( (synpred31_WaebricChecker()) ) {s = 11;}

                         
                        input.seek(index24_6);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA24_9 = input.LA(1);

                         
                        int index24_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_WaebricChecker()) ) {s = 12;}

                        else if ( (synpred37_WaebricChecker()) ) {s = 13;}

                        else if ( (synpred39_WaebricChecker()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index24_9);
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
    static final String DFA28_eotS =
        "\12\uffff";
    static final String DFA28_eofS =
        "\12\uffff";
    static final String DFA28_minS =
        "\1\10\1\uffff\6\0\2\uffff";
    static final String DFA28_maxS =
        "\1\77\1\uffff\6\0\2\uffff";
    static final String DFA28_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\1\3";
    static final String DFA28_specialS =
        "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\2\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\2\1\uffff\1\3\1\4\1\5\44\uffff\1\6\1\uffff\1\7\13\uffff\1"+
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
            return "314:13: ( '!' predicate | expression | expression '.' type )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TreeNodeStream input = (TreeNodeStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA28_2 = input.LA(1);

                         
                        int index28_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index28_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA28_3 = input.LA(1);

                         
                        int index28_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index28_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA28_4 = input.LA(1);

                         
                        int index28_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index28_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA28_5 = input.LA(1);

                         
                        int index28_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index28_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA28_6 = input.LA(1);

                         
                        int index28_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index28_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA28_7 = input.LA(1);

                         
                        int index28_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index28_7);
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
 

    public static final BitSet FOLLOW_37_in_module85 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_moduleId_in_module87 = new BitSet(new long[]{0x0040008000040008L});
    public static final BitSet FOLLOW_imprt_in_module89 = new BitSet(new long[]{0x0040008000040008L});
    public static final BitSet FOLLOW_site_in_module92 = new BitSet(new long[]{0x0040000000040008L});
    public static final BitSet FOLLOW_function_in_module95 = new BitSet(new long[]{0x0040000000000008L});
    public static final BitSet FOLLOW_IDCON_in_moduleId124 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_moduleId134 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDCON_in_moduleId138 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_39_in_imprt159 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_moduleId_in_imprt161 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_module_in_imprt165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SITE_in_site177 = new BitSet(new long[]{0x0000000000180200L});
    public static final BitSet FOLLOW_mappings_in_site179 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_END_in_site181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapping_in_mappings189 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_SEMICOLON_in_mappings194 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_mapping_in_mappings196 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_PATH_in_mapping208 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_mapping210 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_markup_in_mapping212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUP_in_markup233 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_markup235 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000000000001FL});
    public static final BitSet FOLLOW_arguments_in_markup239 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARGUMENTS_in_arguments261 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_argument_in_arguments265 = new BitSet(new long[]{0x000A000000001D08L});
    public static final BitSet FOLLOW_expression_in_argument284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_argument288 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_argument290 = new BitSet(new long[]{0x000A000000001D00L});
    public static final BitSet FOLLOW_expression_in_argument292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varExpression_in_expression307 = new BitSet(new long[]{0x0020004000000002L});
    public static final BitSet FOLLOW_NATCON_in_expression311 = new BitSet(new long[]{0x0020004000000002L});
    public static final BitSet FOLLOW_TEXT_in_expression315 = new BitSet(new long[]{0x0020004000000002L});
    public static final BitSet FOLLOW_SYMBOLCON_in_expression319 = new BitSet(new long[]{0x0020004000000002L});
    public static final BitSet FOLLOW_49_in_expression328 = new BitSet(new long[]{0x000E400000001D00L});
    public static final BitSet FOLLOW_expression_in_expression330 = new BitSet(new long[]{0x0004400000000000L});
    public static final BitSet FOLLOW_46_in_expression335 = new BitSet(new long[]{0x000A000000001D00L});
    public static final BitSet FOLLOW_expression_in_expression337 = new BitSet(new long[]{0x0004400000000000L});
    public static final BitSet FOLLOW_50_in_expression342 = new BitSet(new long[]{0x0020004000000002L});
    public static final BitSet FOLLOW_51_in_expression351 = new BitSet(new long[]{0x0010400000000100L});
    public static final BitSet FOLLOW_keyValuePair_in_expression353 = new BitSet(new long[]{0x0010400000000000L});
    public static final BitSet FOLLOW_46_in_expression358 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_keyValuePair_in_expression360 = new BitSet(new long[]{0x0010400000000000L});
    public static final BitSet FOLLOW_52_in_expression365 = new BitSet(new long[]{0x0020004000000002L});
    public static final BitSet FOLLOW_53_in_expression375 = new BitSet(new long[]{0x000A000000001D00L});
    public static final BitSet FOLLOW_expression_in_expression377 = new BitSet(new long[]{0x0020004000000002L});
    public static final BitSet FOLLOW_38_in_expression381 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDCON_in_expression383 = new BitSet(new long[]{0x0020004000000002L});
    public static final BitSet FOLLOW_IDCON_in_varExpression395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_keyValuePair409 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_keyValuePair411 = new BitSet(new long[]{0x000A000000001D00L});
    public static final BitSet FOLLOW_expression_in_keyValuePair413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_function437 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDCON_in_function439 = new BitSet(new long[]{0x76882000000A0080L});
    public static final BitSet FOLLOW_formals_in_function441 = new BitSet(new long[]{0x76880000000A0080L});
    public static final BitSet FOLLOW_statement_in_function444 = new BitSet(new long[]{0x76880000000A0080L});
    public static final BitSet FOLLOW_END_in_function447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_formals466 = new BitSet(new long[]{0x0000800000000100L});
    public static final BitSet FOLLOW_IDCON_in_formals470 = new BitSet(new long[]{0x0000800000000100L});
    public static final BitSet FOLLOW_47_in_formals477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_statement490 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_45_in_statement492 = new BitSet(new long[]{0x800A000000001D00L});
    public static final BitSet FOLLOW_predicate_in_statement494 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_statement496 = new BitSet(new long[]{0x7688000000020080L});
    public static final BitSet FOLLOW_statement_in_statement498 = new BitSet(new long[]{0x0100000000000008L});
    public static final BitSet FOLLOW_56_in_statement502 = new BitSet(new long[]{0x7688000000020080L});
    public static final BitSet FOLLOW_statement_in_statement504 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_eachStatement_in_statement516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_letStatement_in_statement523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_statement532 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statement534 = new BitSet(new long[]{0x7698000000020080L});
    public static final BitSet FOLLOW_52_in_statement537 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COMMENT_in_statement548 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRCON_in_statement550 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement552 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_60_in_statement563 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement565 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement567 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_60_in_statement578 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_statement580 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement582 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_61_in_statement593 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement595 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement597 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_62_in_statement606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement615 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement617 = new BitSet(new long[]{0x000A000000001D40L});
    public static final BitSet FOLLOW_expression_in_statement620 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement622 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement633 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement635 = new BitSet(new long[]{0x76880000000200C0L});
    public static final BitSet FOLLOW_statement_in_statement638 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement649 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement651 = new BitSet(new long[]{0x0000000000004040L});
    public static final BitSet FOLLOW_embedding_in_statement654 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement656 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement667 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement669 = new BitSet(new long[]{0x0000000000100040L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement672 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_57_in_eachStatement698 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_45_in_eachStatement700 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDCON_in_eachStatement702 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_eachStatement704 = new BitSet(new long[]{0x000A000000001D00L});
    public static final BitSet FOLLOW_expression_in_eachStatement706 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_eachStatement708 = new BitSet(new long[]{0x7688000000020080L});
    public static final BitSet FOLLOW_statement_in_eachStatement712 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_58_in_letStatement738 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_assignment_in_letStatement740 = new BitSet(new long[]{0x0840000000000100L});
    public static final BitSet FOLLOW_59_in_letStatement743 = new BitSet(new long[]{0x76880000000A0080L});
    public static final BitSet FOLLOW_statement_in_letStatement745 = new BitSet(new long[]{0x76880000000A0080L});
    public static final BitSet FOLLOW_END_in_letStatement748 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDCON_in_assignment759 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_assignment761 = new BitSet(new long[]{0x000A000000001D00L});
    public static final BitSet FOLLOW_expression_in_assignment763 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SEMICOLON_in_assignment765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funcBinding_in_assignment771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_funcBinding798 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDCON_in_funcBinding802 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_formals_in_funcBinding806 = new BitSet(new long[]{0x7688000000020080L});
    public static final BitSet FOLLOW_statement_in_funcBinding808 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_END_in_funcBinding810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_predicate834 = new BitSet(new long[]{0x800A000000001D00L});
    public static final BitSet FOLLOW_predicate_in_predicate836 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000003L});
    public static final BitSet FOLLOW_expression_in_predicate845 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000003L});
    public static final BitSet FOLLOW_expression_in_predicate853 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_predicate855 = new BitSet(new long[]{0x0000000000000000L,0x000000000000001CL});
    public static final BitSet FOLLOW_type_in_predicate857 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000003L});
    public static final BitSet FOLLOW_64_in_predicate866 = new BitSet(new long[]{0x800A000000001D00L});
    public static final BitSet FOLLOW_predicate_in_predicate868 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000003L});
    public static final BitSet FOLLOW_65_in_predicate872 = new BitSet(new long[]{0x800A000000001D00L});
    public static final BitSet FOLLOW_predicate_in_predicate874 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000003L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding909 = new BitSet(new long[]{0x000A000000001D40L});
    public static final BitSet FOLLOW_embed_in_embedding911 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_textTail_in_embedding913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed922 = new BitSet(new long[]{0x000A000000001D40L});
    public static final BitSet FOLLOW_expression_in_embed925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed929 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_markup_in_embed932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail944 = new BitSet(new long[]{0x000A000000001D40L});
    public static final BitSet FOLLOW_embed_in_textTail946 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_textTail_in_textTail948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_synpred18_WaebricChecker375 = new BitSet(new long[]{0x000A000000001D00L});
    public static final BitSet FOLLOW_expression_in_synpred18_WaebricChecker377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_synpred19_WaebricChecker381 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDCON_in_synpred19_WaebricChecker383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_synpred30_WaebricChecker563 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_synpred30_WaebricChecker565 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred30_WaebricChecker567 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_60_in_synpred31_WaebricChecker578 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_synpred31_WaebricChecker580 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred31_WaebricChecker582 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_synpred35_WaebricChecker615 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred35_WaebricChecker617 = new BitSet(new long[]{0x000A000000001D40L});
    public static final BitSet FOLLOW_expression_in_synpred35_WaebricChecker620 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred35_WaebricChecker622 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_synpred37_WaebricChecker633 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred37_WaebricChecker635 = new BitSet(new long[]{0x76880000000200C0L});
    public static final BitSet FOLLOW_statement_in_synpred37_WaebricChecker638 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_synpred39_WaebricChecker649 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred39_WaebricChecker651 = new BitSet(new long[]{0x0000000000004040L});
    public static final BitSet FOLLOW_embedding_in_synpred39_WaebricChecker654 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred39_WaebricChecker656 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_synpred45_WaebricChecker845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_synpred46_WaebricChecker866 = new BitSet(new long[]{0x800A000000001D00L});
    public static final BitSet FOLLOW_predicate_in_synpred46_WaebricChecker868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_synpred47_WaebricChecker872 = new BitSet(new long[]{0x800A000000001D00L});
    public static final BitSet FOLLOW_predicate_in_synpred47_WaebricChecker874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred51_WaebricChecker922 = new BitSet(new long[]{0x000A000000001D40L});
    public static final BitSet FOLLOW_expression_in_synpred51_WaebricChecker925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred52_WaebricChecker929 = new BitSet(new long[]{0x0000000000000002L});

}