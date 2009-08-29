// $ANTLR 3.1.2 /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g 2009-08-29 17:43:47

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATTRIBUTES", "ARGUMENTS", "MARKUP", "MARKUP_STATEMENT", "MARKUP_CHAIN", "FORMALS", "FUNCTION", "EXPRESSION", "EMBEDDING", "IDCON", "PATH", "NATCON", "TEXT", "SYMBOLCON", "STRCON", "PRETEXT", "POSTTEXT", "MIDTEXT", "COMMENT", "SITE", "END", "SEMICOLON", "LETTER", "DIGIT", "HEXADECIMAL", "PATHELEMENT", "FILEEXT", "STRCHAR", "ESCLAYOUT", "DECIMAL", "TEXTCHAR", "ESCQUOTE", "AMP", "CHARREF", "ENTREF", "SYMBOLCHAR", "COMMENTS", "LAYOUT", "'module'", "'.'", "'import'", "':'", "'#'", "'$'", "'@'", "'%'", "'('", "','", "')'", "'='", "'['", "']'", "'{'", "'}'", "'+'", "'if'", "'else'", "'each'", "'let'", "'in'", "'echo'", "'cdata'", "'yield;'", "'!'", "'?'", "'&&'", "'||'", "'list'", "'record'", "'string'"
    };
    public static final int ESCLAYOUT=32;
    public static final int T__42=42;
    public static final int END=24;
    public static final int T__57=57;
    public static final int T__51=51;
    public static final int FILEEXT=30;
    public static final int T__69=69;
    public static final int T__47=47;
    public static final int T__73=73;
    public static final int T__50=50;
    public static final int STRCHAR=31;
    public static final int T__65=65;
    public static final int SYMBOLCON=17;
    public static final int T__72=72;
    public static final int COMMENTS=40;
    public static final int DECIMAL=33;
    public static final int IDCON=13;
    public static final int T__70=70;
    public static final int T__67=67;
    public static final int HEXADECIMAL=28;
    public static final int TEXTCHAR=34;
    public static final int EXPRESSION=11;
    public static final int T__52=52;
    public static final int T__46=46;
    public static final int T__68=68;
    public static final int FUNCTION=10;
    public static final int EMBEDDING=12;
    public static final int T__62=62;
    public static final int MARKUP=6;
    public static final int STRCON=18;
    public static final int T__49=49;
    public static final int AMP=36;
    public static final int T__61=61;
    public static final int POSTTEXT=20;
    public static final int T__59=59;
    public static final int ATTRIBUTES=4;
    public static final int DIGIT=27;
    public static final int T__54=54;
    public static final int T__48=48;
    public static final int MARKUP_CHAIN=8;
    public static final int ESCQUOTE=35;
    public static final int LAYOUT=41;
    public static final int T__56=56;
    public static final int PATHELEMENT=29;
    public static final int ENTREF=38;
    public static final int LETTER=26;
    public static final int ARGUMENTS=5;
    public static final int SITE=23;
    public static final int T__58=58;
    public static final int T__64=64;
    public static final int T__44=44;
    public static final int T__66=66;
    public static final int SYMBOLCHAR=39;
    public static final int COMMENT=22;
    public static final int MARKUP_STATEMENT=7;
    public static final int FORMALS=9;
    public static final int T__45=45;
    public static final int T__55=55;
    public static final int CHARREF=37;
    public static final int MIDTEXT=21;
    public static final int T__63=63;
    public static final int PRETEXT=19;
    public static final int T__43=43;
    public static final int SEMICOLON=25;
    public static final int EOF=-1;
    public static final int T__53=53;
    public static final int TEXT=16;
    public static final int NATCON=15;
    public static final int T__60=60;
    public static final int T__71=71;
    public static final int PATH=14;

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
            string_literal1=(CommonTree)match(input,42,FOLLOW_42_in_module85); if (state.failed) return retval;
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

                if ( (LA1_0==44) ) {
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:195:1: moduleId : id= IDCON ( '.' id= IDCON )* ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:198:2: (id= IDCON ( '.' id= IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:198:5: id= IDCON ( '.' id= IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_moduleId125); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (CommonTree)adaptor.dupNode(id);

            adaptor.addChild(root_0, id_tree);
            }
            if ( state.backtracking==0 ) {
               path = id.getText(); 
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:199:4: ( '.' id= IDCON )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==43) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:199:6: '.' id= IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal6=(CommonTree)match(input,43,FOLLOW_43_in_moduleId135); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal6_tree = (CommonTree)adaptor.dupNode(char_literal6);

            	    adaptor.addChild(root_0, char_literal6_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_moduleId139); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:207:1: imprt : 'import' moduleId ( module )? ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:207:6: ( 'import' moduleId ( module )? )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:207:10: 'import' moduleId ( module )?
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal7=(CommonTree)match(input,44,FOLLOW_44_in_imprt160); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal7_tree = (CommonTree)adaptor.dupNode(string_literal7);

            adaptor.addChild(root_0, string_literal7_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_moduleId_in_imprt162);
            moduleId8=moduleId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, moduleId8.getTree());
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:207:28: ( module )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==42) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: module
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_module_in_imprt164);
                    module9=module();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, module9.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

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
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==PATH) ) {
                alt6=1;
            }
            switch (alt6) {
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
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==SEMICOLON) ) {
                    alt7=1;
                }


                switch (alt7) {
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
            	    break loop7;
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
            char_literal17=(CommonTree)match(input,45,FOLLOW_45_in_mapping210); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:218:1: markup : ^( MARKUP IDCON . arguments ) ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:218:7: ( ^( MARKUP IDCON . arguments ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:218:11: ^( MARKUP IDCON . arguments )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            MARKUP19=(CommonTree)match(input,MARKUP,FOLLOW_MARKUP_in_markup227); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MARKUP19_tree = (CommonTree)adaptor.dupNode(MARKUP19);

            root_1 = (CommonTree)adaptor.becomeRoot(MARKUP19_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            IDCON20=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_markup229); if (state.failed) return retval;
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
            pushFollow(FOLLOW_arguments_in_markup233);
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
            ARGUMENTS23=(CommonTree)match(input,ARGUMENTS,FOLLOW_ARGUMENTS_in_arguments255); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ARGUMENTS23_tree = (CommonTree)adaptor.dupNode(ARGUMENTS23);

            root_1 = (CommonTree)adaptor.becomeRoot(ARGUMENTS23_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:231:18: ( argument )*
                loop8:
                do {
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==IDCON||(LA8_0>=NATCON && LA8_0<=SYMBOLCON)||LA8_0==54||LA8_0==56) ) {
                        alt8=1;
                    }


                    switch (alt8) {
                	case 1 :
                	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:231:20: argument
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_argument_in_arguments259);
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
                	    break loop8;
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
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==IDCON) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==53) ) {
                    alt9=2;
                }
                else if ( (LA9_1==EOF||LA9_1==UP||LA9_1==IDCON||(LA9_1>=NATCON && LA9_1<=SYMBOLCON)||LA9_1==43||LA9_1==54||LA9_1==56||LA9_1==58) ) {
                    alt9=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA9_0>=NATCON && LA9_0<=SYMBOLCON)||LA9_0==54||LA9_0==56) ) {
                alt9=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:233:12: expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_argument278);
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
                    IDCON26=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_argument282); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON26_tree = (CommonTree)adaptor.dupNode(IDCON26);

                    adaptor.addChild(root_0, IDCON26_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal27=(CommonTree)match(input,53,FOLLOW_53_in_argument284); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal27_tree = (CommonTree)adaptor.dupNode(char_literal27);

                    adaptor.addChild(root_0, char_literal27_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_argument286);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:239:1: expression : (id= IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* ;
    public final WaebricChecker.expression_return expression() throws RecognitionException {
        WaebricChecker.expression_return retval = new WaebricChecker.expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        CommonTree NATCON29=null;
        CommonTree TEXT30=null;
        CommonTree SYMBOLCON31=null;
        CommonTree char_literal32=null;
        CommonTree char_literal34=null;
        CommonTree char_literal36=null;
        CommonTree char_literal37=null;
        CommonTree char_literal39=null;
        CommonTree char_literal41=null;
        CommonTree char_literal42=null;
        CommonTree char_literal44=null;
        CommonTree IDCON45=null;
        WaebricChecker.expression_return expression33 = null;

        WaebricChecker.expression_return expression35 = null;

        WaebricChecker.keyValuePair_return keyValuePair38 = null;

        WaebricChecker.keyValuePair_return keyValuePair40 = null;

        WaebricChecker.expression_return expression43 = null;


        CommonTree id_tree=null;
        CommonTree NATCON29_tree=null;
        CommonTree TEXT30_tree=null;
        CommonTree SYMBOLCON31_tree=null;
        CommonTree char_literal32_tree=null;
        CommonTree char_literal34_tree=null;
        CommonTree char_literal36_tree=null;
        CommonTree char_literal37_tree=null;
        CommonTree char_literal39_tree=null;
        CommonTree char_literal41_tree=null;
        CommonTree char_literal42_tree=null;
        CommonTree char_literal44_tree=null;
        CommonTree IDCON45_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:239:11: ( (id= IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:239:14: (id= IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:239:14: (id= IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' )
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
            case 54:
                {
                alt14=5;
                }
                break;
            case 56:
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:239:16: id= IDCON
                    {
                    _last = (CommonTree)input.LT(1);
                    id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression303); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    id_tree = (CommonTree)adaptor.dupNode(id);

                    adaptor.addChild(root_0, id_tree);
                    }
                    if ( state.backtracking==0 ) {
                       
                      					if(! isDefinedVariable(id.getText())) {
                      						// Verify that all variable references are made to defined variables
                      						exceptions.add(new UndefinedVariableException(id_tree));
                      					} 
                      				
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:245:7: NATCON
                    {
                    _last = (CommonTree)input.LT(1);
                    NATCON29=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_expression314); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON29_tree = (CommonTree)adaptor.dupNode(NATCON29);

                    adaptor.addChild(root_0, NATCON29_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:245:16: TEXT
                    {
                    _last = (CommonTree)input.LT(1);
                    TEXT30=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_expression318); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TEXT30_tree = (CommonTree)adaptor.dupNode(TEXT30);

                    adaptor.addChild(root_0, TEXT30_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:245:23: SYMBOLCON
                    {
                    _last = (CommonTree)input.LT(1);
                    SYMBOLCON31=(CommonTree)match(input,SYMBOLCON,FOLLOW_SYMBOLCON_in_expression322); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SYMBOLCON31_tree = (CommonTree)adaptor.dupNode(SYMBOLCON31);

                    adaptor.addChild(root_0, SYMBOLCON31_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:246:7: '[' ( expression )? ( ',' expression )* ']'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal32=(CommonTree)match(input,54,FOLLOW_54_in_expression331); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal32_tree = (CommonTree)adaptor.dupNode(char_literal32);

                    adaptor.addChild(root_0, char_literal32_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:246:11: ( expression )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==IDCON||(LA10_0>=NATCON && LA10_0<=SYMBOLCON)||LA10_0==54||LA10_0==56) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: expression
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_expression_in_expression333);
                            expression33=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, expression33.getTree());

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:246:23: ( ',' expression )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==51) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:246:25: ',' expression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal34=(CommonTree)match(input,51,FOLLOW_51_in_expression338); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal34_tree = (CommonTree)adaptor.dupNode(char_literal34);

                    	    adaptor.addChild(root_0, char_literal34_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_expression_in_expression340);
                    	    expression35=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, expression35.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal36=(CommonTree)match(input,55,FOLLOW_55_in_expression345); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal36_tree = (CommonTree)adaptor.dupNode(char_literal36);

                    adaptor.addChild(root_0, char_literal36_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:247:7: '{' ( keyValuePair )? ( ',' keyValuePair )* '}'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal37=(CommonTree)match(input,56,FOLLOW_56_in_expression354); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal37_tree = (CommonTree)adaptor.dupNode(char_literal37);

                    adaptor.addChild(root_0, char_literal37_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:247:11: ( keyValuePair )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==IDCON) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: keyValuePair
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_keyValuePair_in_expression356);
                            keyValuePair38=keyValuePair();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, keyValuePair38.getTree());

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:247:25: ( ',' keyValuePair )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==51) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:247:27: ',' keyValuePair
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal39=(CommonTree)match(input,51,FOLLOW_51_in_expression361); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal39_tree = (CommonTree)adaptor.dupNode(char_literal39);

                    	    adaptor.addChild(root_0, char_literal39_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_keyValuePair_in_expression363);
                    	    keyValuePair40=keyValuePair();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, keyValuePair40.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal41=(CommonTree)match(input,57,FOLLOW_57_in_expression368); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal41_tree = (CommonTree)adaptor.dupNode(char_literal41);

                    adaptor.addChild(root_0, char_literal41_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:248:6: ( '+' expression | '.' IDCON )*
            loop15:
            do {
                int alt15=3;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==58) ) {
                    int LA15_2 = input.LA(2);

                    if ( (synpred19_WaebricChecker()) ) {
                        alt15=1;
                    }


                }
                else if ( (LA15_0==43) ) {
                    int LA15_3 = input.LA(2);

                    if ( (synpred20_WaebricChecker()) ) {
                        alt15=2;
                    }


                }


                switch (alt15) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:248:8: '+' expression
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal42=(CommonTree)match(input,58,FOLLOW_58_in_expression378); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal42_tree = (CommonTree)adaptor.dupNode(char_literal42);

            	    adaptor.addChild(root_0, char_literal42_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expression_in_expression380);
            	    expression43=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, expression43.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:248:25: '.' IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal44=(CommonTree)match(input,43,FOLLOW_43_in_expression384); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal44_tree = (CommonTree)adaptor.dupNode(char_literal44);

            	    adaptor.addChild(root_0, char_literal44_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    IDCON45=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression386); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDCON45_tree = (CommonTree)adaptor.dupNode(IDCON45);

            	    adaptor.addChild(root_0, IDCON45_tree);
            	    }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop15;
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

        CommonTree IDCON46=null;
        CommonTree char_literal47=null;
        WaebricChecker.expression_return expression48 = null;


        CommonTree IDCON46_tree=null;
        CommonTree char_literal47_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:250:13: ( IDCON ':' expression )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:250:16: IDCON ':' expression
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON46=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_keyValuePair398); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON46_tree = (CommonTree)adaptor.dupNode(IDCON46);

            adaptor.addChild(root_0, IDCON46_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal47=(CommonTree)match(input,45,FOLLOW_45_in_keyValuePair400); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal47_tree = (CommonTree)adaptor.dupNode(char_literal47);

            adaptor.addChild(root_0, char_literal47_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_keyValuePair402);
            expression48=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, expression48.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:254:1: function : ^( FUNCTION IDCON formals ( statement )* ) ;
    public final WaebricChecker.function_return function() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.function_return retval = new WaebricChecker.function_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNCTION49=null;
        CommonTree IDCON50=null;
        WaebricChecker.formals_return formals51 = null;

        WaebricChecker.statement_return statement52 = null;


        CommonTree FUNCTION49_tree=null;
        CommonTree IDCON50_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new ArrayList<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:259:4: ( ^( FUNCTION IDCON formals ( statement )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:259:7: ^( FUNCTION IDCON formals ( statement )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNCTION49=(CommonTree)match(input,FUNCTION,FOLLOW_FUNCTION_in_function428); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FUNCTION49_tree = (CommonTree)adaptor.dupNode(FUNCTION49);

            root_1 = (CommonTree)adaptor.becomeRoot(FUNCTION49_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            IDCON50=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_function430); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON50_tree = (CommonTree)adaptor.dupNode(IDCON50);

            adaptor.addChild(root_1, IDCON50_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_formals_in_function432);
            formals51=formals();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, formals51.getTree());
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:259:33: ( statement )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==MARKUP_STATEMENT||LA16_0==COMMENT||LA16_0==56||LA16_0==59||(LA16_0>=61 && LA16_0<=62)||(LA16_0>=64 && LA16_0<=66)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_function434);
            	    statement52=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, statement52.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop16;
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
        public int args = 0;;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "formals"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:261:1: formals returns [int args = 0;] : ^( FORMALS ( IDCON )* ) ;
    public final WaebricChecker.formals_return formals() throws RecognitionException {
        WaebricChecker.formals_return retval = new WaebricChecker.formals_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FORMALS53=null;
        CommonTree IDCON54=null;

        CommonTree FORMALS53_tree=null;
        CommonTree IDCON54_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:263:2: ( ^( FORMALS ( IDCON )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:264:4: ^( FORMALS ( IDCON )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FORMALS53=(CommonTree)match(input,FORMALS,FOLLOW_FORMALS_in_formals462); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FORMALS53_tree = (CommonTree)adaptor.dupNode(FORMALS53);

            root_1 = (CommonTree)adaptor.becomeRoot(FORMALS53_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:264:15: ( IDCON )*
                loop17:
                do {
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==IDCON) ) {
                        alt17=1;
                    }


                    switch (alt17) {
                	case 1 :
                	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:264:17: IDCON
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    IDCON54=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_formals466); if (state.failed) return retval;
                	    if ( state.backtracking==0 ) {
                	    IDCON54_tree = (CommonTree)adaptor.dupNode(IDCON54);

                	    adaptor.addChild(root_1, IDCON54_tree);
                	    }
                	    if ( state.backtracking==0 ) {
                	       defineVariable(IDCON54.getText()); retval.args++; 
                	    }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop17;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:268:1: statement : ( ^( 'if' predicate statement ( 'else' statement )? ) | eachStatement | letStatement | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ) | ^( 'echo' expression ) | ^( 'echo' embedding ) | ^( 'cdata' expression ) | 'yield;' | ^( MARKUP_STATEMENT markup markupChain ) );
    public final WaebricChecker.statement_return statement() throws RecognitionException {
        WaebricChecker.statement_return retval = new WaebricChecker.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal55=null;
        CommonTree string_literal58=null;
        CommonTree char_literal62=null;
        CommonTree char_literal64=null;
        CommonTree string_literal65=null;
        CommonTree STRCON66=null;
        CommonTree string_literal67=null;
        CommonTree string_literal69=null;
        CommonTree string_literal71=null;
        CommonTree string_literal73=null;
        CommonTree MARKUP_STATEMENT74=null;
        WaebricChecker.predicate_return predicate56 = null;

        WaebricChecker.statement_return statement57 = null;

        WaebricChecker.statement_return statement59 = null;

        WaebricChecker.eachStatement_return eachStatement60 = null;

        WaebricChecker.letStatement_return letStatement61 = null;

        WaebricChecker.statement_return statement63 = null;

        WaebricChecker.expression_return expression68 = null;

        WaebricChecker.embedding_return embedding70 = null;

        WaebricChecker.expression_return expression72 = null;

        WaebricChecker.markup_return markup75 = null;

        WaebricChecker.markupChain_return markupChain76 = null;


        CommonTree string_literal55_tree=null;
        CommonTree string_literal58_tree=null;
        CommonTree char_literal62_tree=null;
        CommonTree char_literal64_tree=null;
        CommonTree string_literal65_tree=null;
        CommonTree STRCON66_tree=null;
        CommonTree string_literal67_tree=null;
        CommonTree string_literal69_tree=null;
        CommonTree string_literal71_tree=null;
        CommonTree string_literal73_tree=null;
        CommonTree MARKUP_STATEMENT74_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:268:10: ( ^( 'if' predicate statement ( 'else' statement )? ) | eachStatement | letStatement | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ) | ^( 'echo' expression ) | ^( 'echo' embedding ) | ^( 'cdata' expression ) | 'yield;' | ^( MARKUP_STATEMENT markup markupChain ) )
            int alt20=10;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:268:13: ^( 'if' predicate statement ( 'else' statement )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal55=(CommonTree)match(input,59,FOLLOW_59_in_statement486); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal55_tree = (CommonTree)adaptor.dupNode(string_literal55);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal55_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_statement488);
                    predicate56=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, predicate56.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement490);
                    statement57=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement57.getTree());
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:268:41: ( 'else' statement )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==60) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:268:43: 'else' statement
                            {
                            _last = (CommonTree)input.LT(1);
                            string_literal58=(CommonTree)match(input,60,FOLLOW_60_in_statement494); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal58_tree = (CommonTree)adaptor.dupNode(string_literal58);

                            adaptor.addChild(root_1, string_literal58_tree);
                            }
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_statement_in_statement496);
                            statement59=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, statement59.getTree());

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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:269:6: eachStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_eachStatement_in_statement508);
                    eachStatement60=eachStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, eachStatement60.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:270:6: letStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_letStatement_in_statement515);
                    letStatement61=letStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, letStatement61.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:271:6: ^( '{' ( statement )* '}' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal62=(CommonTree)match(input,56,FOLLOW_56_in_statement524); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal62_tree = (CommonTree)adaptor.dupNode(char_literal62);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal62_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:271:13: ( statement )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==MARKUP_STATEMENT||LA19_0==COMMENT||LA19_0==56||LA19_0==59||(LA19_0>=61 && LA19_0<=62)||(LA19_0>=64 && LA19_0<=66)) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: statement
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_statement_in_statement526);
                    	    statement63=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, statement63.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal64=(CommonTree)match(input,57,FOLLOW_57_in_statement529); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal64_tree = (CommonTree)adaptor.dupNode(char_literal64);

                    adaptor.addChild(root_1, char_literal64_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:272:6: ^( 'comment' STRCON )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal65=(CommonTree)match(input,COMMENT,FOLLOW_COMMENT_in_statement540); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal65_tree = (CommonTree)adaptor.dupNode(string_literal65);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal65_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    STRCON66=(CommonTree)match(input,STRCON,FOLLOW_STRCON_in_statement542); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRCON66_tree = (CommonTree)adaptor.dupNode(STRCON66);

                    adaptor.addChild(root_1, STRCON66_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:273:6: ^( 'echo' expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal67=(CommonTree)match(input,64,FOLLOW_64_in_statement553); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal67_tree = (CommonTree)adaptor.dupNode(string_literal67);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal67_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement555);
                    expression68=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression68.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:274:6: ^( 'echo' embedding )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal69=(CommonTree)match(input,64,FOLLOW_64_in_statement566); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal69_tree = (CommonTree)adaptor.dupNode(string_literal69);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal69_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement568);
                    embedding70=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding70.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:275:6: ^( 'cdata' expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal71=(CommonTree)match(input,65,FOLLOW_65_in_statement579); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal71_tree = (CommonTree)adaptor.dupNode(string_literal71);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal71_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement581);
                    expression72=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression72.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:276:6: 'yield;'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal73=(CommonTree)match(input,66,FOLLOW_66_in_statement590); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal73_tree = (CommonTree)adaptor.dupNode(string_literal73);

                    adaptor.addChild(root_0, string_literal73_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:277:6: ^( MARKUP_STATEMENT markup markupChain )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT74=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement599); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT74_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT74);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT74_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_statement601);
                    markup75=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, markup75.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markupChain_in_statement603);
                    markupChain76=markupChain();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, markupChain76.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:279:1: markupChain : ( ^( MARKUP_CHAIN markup markupChain ) | ^( MARKUP_CHAIN expression ) | ^( MARKUP_CHAIN statement ) | ^( MARKUP_CHAIN embedding ) | ';' );
    public final WaebricChecker.markupChain_return markupChain() throws RecognitionException {
        WaebricChecker.markupChain_return retval = new WaebricChecker.markupChain_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MARKUP_CHAIN77=null;
        CommonTree MARKUP_CHAIN80=null;
        CommonTree MARKUP_CHAIN82=null;
        CommonTree MARKUP_CHAIN84=null;
        CommonTree char_literal86=null;
        WaebricChecker.markup_return markup78 = null;

        WaebricChecker.markupChain_return markupChain79 = null;

        WaebricChecker.expression_return expression81 = null;

        WaebricChecker.statement_return statement83 = null;

        WaebricChecker.embedding_return embedding85 = null;


        CommonTree MARKUP_CHAIN77_tree=null;
        CommonTree MARKUP_CHAIN80_tree=null;
        CommonTree MARKUP_CHAIN82_tree=null;
        CommonTree MARKUP_CHAIN84_tree=null;
        CommonTree char_literal86_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:279:12: ( ^( MARKUP_CHAIN markup markupChain ) | ^( MARKUP_CHAIN expression ) | ^( MARKUP_CHAIN statement ) | ^( MARKUP_CHAIN embedding ) | ';' )
            int alt21=5;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==MARKUP_CHAIN) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==DOWN) ) {
                    switch ( input.LA(3) ) {
                    case MARKUP_STATEMENT:
                    case COMMENT:
                    case 59:
                    case 61:
                    case 62:
                    case 64:
                    case 65:
                    case 66:
                        {
                        alt21=3;
                        }
                        break;
                    case 56:
                        {
                        int LA21_5 = input.LA(4);

                        if ( (LA21_5==DOWN) ) {
                            alt21=3;
                        }
                        else if ( (LA21_5==IDCON||LA21_5==51||LA21_5==57) ) {
                            alt21=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 21, 5, input);

                            throw nvae;
                        }
                        }
                        break;
                    case IDCON:
                    case NATCON:
                    case TEXT:
                    case SYMBOLCON:
                    case 54:
                        {
                        alt21=2;
                        }
                        break;
                    case PRETEXT:
                        {
                        alt21=4;
                        }
                        break;
                    case MARKUP:
                        {
                        alt21=1;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 3, input);

                        throw nvae;
                    }

                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA21_0==SEMICOLON) ) {
                alt21=5;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:279:15: ^( MARKUP_CHAIN markup markupChain )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_CHAIN77=(CommonTree)match(input,MARKUP_CHAIN,FOLLOW_MARKUP_CHAIN_in_markupChain619); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_CHAIN77_tree = (CommonTree)adaptor.dupNode(MARKUP_CHAIN77);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_CHAIN77_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_markupChain621);
                    markup78=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, markup78.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markupChain_in_markupChain623);
                    markupChain79=markupChain();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, markupChain79.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:280:6: ^( MARKUP_CHAIN expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_CHAIN80=(CommonTree)match(input,MARKUP_CHAIN,FOLLOW_MARKUP_CHAIN_in_markupChain634); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_CHAIN80_tree = (CommonTree)adaptor.dupNode(MARKUP_CHAIN80);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_CHAIN80_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_markupChain636);
                    expression81=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression81.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:281:6: ^( MARKUP_CHAIN statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_CHAIN82=(CommonTree)match(input,MARKUP_CHAIN,FOLLOW_MARKUP_CHAIN_in_markupChain647); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_CHAIN82_tree = (CommonTree)adaptor.dupNode(MARKUP_CHAIN82);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_CHAIN82_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_markupChain649);
                    statement83=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement83.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:282:6: ^( MARKUP_CHAIN embedding )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_CHAIN84=(CommonTree)match(input,MARKUP_CHAIN,FOLLOW_MARKUP_CHAIN_in_markupChain660); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_CHAIN84_tree = (CommonTree)adaptor.dupNode(MARKUP_CHAIN84);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_CHAIN84_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_markupChain662);
                    embedding85=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding85.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:283:6: ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal86=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_markupChain671); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal86_tree = (CommonTree)adaptor.dupNode(char_literal86);

                    adaptor.addChild(root_0, char_literal86_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:285:1: eachStatement : ^( 'each' '(' IDCON ':' expression ')' statement ) ;
    public final WaebricChecker.eachStatement_return eachStatement() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.eachStatement_return retval = new WaebricChecker.eachStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal87=null;
        CommonTree char_literal88=null;
        CommonTree IDCON89=null;
        CommonTree char_literal90=null;
        CommonTree char_literal92=null;
        WaebricChecker.expression_return expression91 = null;

        WaebricChecker.statement_return statement93 = null;


        CommonTree string_literal87_tree=null;
        CommonTree char_literal88_tree=null;
        CommonTree IDCON89_tree=null;
        CommonTree char_literal90_tree=null;
        CommonTree char_literal92_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new ArrayList<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:290:4: ( ^( 'each' '(' IDCON ':' expression ')' statement ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:290:7: ^( 'each' '(' IDCON ':' expression ')' statement )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal87=(CommonTree)match(input,61,FOLLOW_61_in_eachStatement695); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal87_tree = (CommonTree)adaptor.dupNode(string_literal87);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal87_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            char_literal88=(CommonTree)match(input,50,FOLLOW_50_in_eachStatement697); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal88_tree = (CommonTree)adaptor.dupNode(char_literal88);

            adaptor.addChild(root_1, char_literal88_tree);
            }
            _last = (CommonTree)input.LT(1);
            IDCON89=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_eachStatement699); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON89_tree = (CommonTree)adaptor.dupNode(IDCON89);

            adaptor.addChild(root_1, IDCON89_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal90=(CommonTree)match(input,45,FOLLOW_45_in_eachStatement701); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal90_tree = (CommonTree)adaptor.dupNode(char_literal90);

            adaptor.addChild(root_1, char_literal90_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_eachStatement703);
            expression91=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expression91.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal92=(CommonTree)match(input,52,FOLLOW_52_in_eachStatement705); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal92_tree = (CommonTree)adaptor.dupNode(char_literal92);

            adaptor.addChild(root_1, char_literal92_tree);
            }
            if ( state.backtracking==0 ) {
               
              				defineVariable(IDCON89.getText()); // Define variable before statement is executed
              			
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_eachStatement709);
            statement93=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, statement93.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:294:1: letStatement : ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) ;
    public final WaebricChecker.letStatement_return letStatement() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.letStatement_return retval = new WaebricChecker.letStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal94=null;
        CommonTree string_literal96=null;
        CommonTree string_literal98=null;
        WaebricChecker.assignment_return assignment95 = null;

        WaebricChecker.statement_return statement97 = null;


        CommonTree string_literal94_tree=null;
        CommonTree string_literal96_tree=null;
        CommonTree string_literal98_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new ArrayList<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:299:4: ( ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:299:7: ^( 'let' ( assignment )+ 'in' ( statement )* 'end' )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal94=(CommonTree)match(input,62,FOLLOW_62_in_letStatement735); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal94_tree = (CommonTree)adaptor.dupNode(string_literal94);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal94_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:299:16: ( assignment )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==FUNCTION||LA22_0==IDCON) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: assignment
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_assignment_in_letStatement737);
            	    assignment95=assignment();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, assignment95.getTree());

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
            string_literal96=(CommonTree)match(input,63,FOLLOW_63_in_letStatement740); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal96_tree = (CommonTree)adaptor.dupNode(string_literal96);

            adaptor.addChild(root_1, string_literal96_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:299:33: ( statement )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==MARKUP_STATEMENT||LA23_0==COMMENT||LA23_0==56||LA23_0==59||(LA23_0>=61 && LA23_0<=62)||(LA23_0>=64 && LA23_0<=66)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_letStatement742);
            	    statement97=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, statement97.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            string_literal98=(CommonTree)match(input,END,FOLLOW_END_in_letStatement745); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal98_tree = (CommonTree)adaptor.dupNode(string_literal98);

            adaptor.addChild(root_1, string_literal98_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:301:1: assignment : ( IDCON '=' expression ';' | funcBinding );
    public final WaebricChecker.assignment_return assignment() throws RecognitionException {
        WaebricChecker.assignment_return retval = new WaebricChecker.assignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON99=null;
        CommonTree char_literal100=null;
        CommonTree char_literal102=null;
        WaebricChecker.expression_return expression101 = null;

        WaebricChecker.funcBinding_return funcBinding103 = null;


        CommonTree IDCON99_tree=null;
        CommonTree char_literal100_tree=null;
        CommonTree char_literal102_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:301:11: ( IDCON '=' expression ';' | funcBinding )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==IDCON) ) {
                alt24=1;
            }
            else if ( (LA24_0==FUNCTION) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:301:14: IDCON '=' expression ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDCON99=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_assignment756); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON99_tree = (CommonTree)adaptor.dupNode(IDCON99);

                    adaptor.addChild(root_0, IDCON99_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal100=(CommonTree)match(input,53,FOLLOW_53_in_assignment758); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal100_tree = (CommonTree)adaptor.dupNode(char_literal100);

                    adaptor.addChild(root_0, char_literal100_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_assignment760);
                    expression101=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression101.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal102=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_assignment762); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal102_tree = (CommonTree)adaptor.dupNode(char_literal102);

                    adaptor.addChild(root_0, char_literal102_tree);
                    }
                    if ( state.backtracking==0 ) {
                       
                      				defineVariable(IDCON99.getText()); 
                      			
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:303:8: funcBinding
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_funcBinding_in_assignment768);
                    funcBinding103=funcBinding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, funcBinding103.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:305:1: funcBinding : ^( FUNCTION id= IDCON f= formals statement ) ;
    public final WaebricChecker.funcBinding_return funcBinding() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.funcBinding_return retval = new WaebricChecker.funcBinding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        CommonTree FUNCTION104=null;
        WaebricChecker.formals_return f = null;

        WaebricChecker.statement_return statement105 = null;


        CommonTree id_tree=null;
        CommonTree FUNCTION104_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new ArrayList<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:310:4: ( ^( FUNCTION id= IDCON f= formals statement ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:310:8: ^( FUNCTION id= IDCON f= formals statement )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNCTION104=(CommonTree)match(input,FUNCTION,FOLLOW_FUNCTION_in_funcBinding797); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FUNCTION104_tree = (CommonTree)adaptor.dupNode(FUNCTION104);

            root_1 = (CommonTree)adaptor.becomeRoot(FUNCTION104_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_funcBinding801); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (CommonTree)adaptor.dupNode(id);

            adaptor.addChild(root_1, id_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_formals_in_funcBinding805);
            f=formals();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, f.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_funcBinding807);
            statement105=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, statement105.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:319:1: predicate : ( '!' predicate | expression | expression '.' type '?' ) ( '&&' predicate | '||' predicate )* ;
    public final WaebricChecker.predicate_return predicate() throws RecognitionException {
        WaebricChecker.predicate_return retval = new WaebricChecker.predicate_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal106=null;
        CommonTree char_literal110=null;
        CommonTree char_literal112=null;
        CommonTree string_literal113=null;
        CommonTree string_literal115=null;
        WaebricChecker.predicate_return predicate107 = null;

        WaebricChecker.expression_return expression108 = null;

        WaebricChecker.expression_return expression109 = null;

        WaebricChecker.type_return type111 = null;

        WaebricChecker.predicate_return predicate114 = null;

        WaebricChecker.predicate_return predicate116 = null;


        CommonTree char_literal106_tree=null;
        CommonTree char_literal110_tree=null;
        CommonTree char_literal112_tree=null;
        CommonTree string_literal113_tree=null;
        CommonTree string_literal115_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:319:10: ( ( '!' predicate | expression | expression '.' type '?' ) ( '&&' predicate | '||' predicate )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:319:13: ( '!' predicate | expression | expression '.' type '?' ) ( '&&' predicate | '||' predicate )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:319:13: ( '!' predicate | expression | expression '.' type '?' )
            int alt25=3;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:319:15: '!' predicate
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal106=(CommonTree)match(input,67,FOLLOW_67_in_predicate833); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal106_tree = (CommonTree)adaptor.dupNode(char_literal106);

                    adaptor.addChild(root_0, char_literal106_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_predicate835);
                    predicate107=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, predicate107.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:320:7: expression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate844);
                    expression108=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression108.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:321:7: expression '.' type '?'
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate852);
                    expression109=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression109.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal110=(CommonTree)match(input,43,FOLLOW_43_in_predicate854); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal110_tree = (CommonTree)adaptor.dupNode(char_literal110);

                    adaptor.addChild(root_0, char_literal110_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_predicate856);
                    type111=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, type111.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal112=(CommonTree)match(input,68,FOLLOW_68_in_predicate858); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal112_tree = (CommonTree)adaptor.dupNode(char_literal112);

                    adaptor.addChild(root_0, char_literal112_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:322:6: ( '&&' predicate | '||' predicate )*
            loop26:
            do {
                int alt26=3;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==69) ) {
                    int LA26_2 = input.LA(2);

                    if ( (synpred43_WaebricChecker()) ) {
                        alt26=1;
                    }


                }
                else if ( (LA26_0==70) ) {
                    int LA26_3 = input.LA(2);

                    if ( (synpred44_WaebricChecker()) ) {
                        alt26=2;
                    }


                }


                switch (alt26) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:322:8: '&&' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal113=(CommonTree)match(input,69,FOLLOW_69_in_predicate867); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal113_tree = (CommonTree)adaptor.dupNode(string_literal113);

            	    adaptor.addChild(root_0, string_literal113_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate869);
            	    predicate114=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, predicate114.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:322:25: '||' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal115=(CommonTree)match(input,70,FOLLOW_70_in_predicate873); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal115_tree = (CommonTree)adaptor.dupNode(string_literal115);

            	    adaptor.addChild(root_0, string_literal115_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate875);
            	    predicate116=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, predicate116.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop26;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:323:1: type : ( 'list' | 'record' | 'string' );
    public final WaebricChecker.type_return type() throws RecognitionException {
        WaebricChecker.type_return retval = new WaebricChecker.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set117=null;

        CommonTree set117_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:323:5: ( 'list' | 'record' | 'string' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            set117=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=71 && input.LA(1)<=73) ) {
                input.consume();

                if ( state.backtracking==0 ) {
                set117_tree = (CommonTree)adaptor.dupNode(set117);

                adaptor.addChild(root_0, set117_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:329:1: embedding : PRETEXT embed textTail ;
    public final WaebricChecker.embedding_return embedding() throws RecognitionException {
        WaebricChecker.embedding_return retval = new WaebricChecker.embedding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PRETEXT118=null;
        WaebricChecker.embed_return embed119 = null;

        WaebricChecker.textTail_return textTail120 = null;


        CommonTree PRETEXT118_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:329:10: ( PRETEXT embed textTail )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:329:13: PRETEXT embed textTail
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PRETEXT118=(CommonTree)match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding910); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRETEXT118_tree = (CommonTree)adaptor.dupNode(PRETEXT118);

            adaptor.addChild(root_0, PRETEXT118_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_embed_in_embedding912);
            embed119=embed();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, embed119.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_textTail_in_embedding914);
            textTail120=textTail();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, textTail120.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:330:1: embed : ( ( markup )* expression | ( markup )* markup );
    public final WaebricChecker.embed_return embed() throws RecognitionException {
        WaebricChecker.embed_return retval = new WaebricChecker.embed_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricChecker.markup_return markup121 = null;

        WaebricChecker.expression_return expression122 = null;

        WaebricChecker.markup_return markup123 = null;

        WaebricChecker.markup_return markup124 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:330:6: ( ( markup )* expression | ( markup )* markup )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==MARKUP) ) {
                int LA29_1 = input.LA(2);

                if ( (synpred48_WaebricChecker()) ) {
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
            else if ( (LA29_0==IDCON||(LA29_0>=NATCON && LA29_0<=SYMBOLCON)||LA29_0==54||LA29_0==56) ) {
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:330:10: ( markup )* expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:330:10: ( markup )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==MARKUP) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed923);
                    	    markup121=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup121.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_embed926);
                    expression122=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression122.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:330:31: ( markup )* markup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:330:31: ( markup )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==MARKUP) ) {
                            int LA28_1 = input.LA(2);

                            if ( (synpred49_WaebricChecker()) ) {
                                alt28=1;
                            }


                        }


                        switch (alt28) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed930);
                    	    markup123=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup123.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_embed933);
                    markup124=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, markup124.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:331:1: textTail : ( POSTTEXT | MIDTEXT embed textTail );
    public final WaebricChecker.textTail_return textTail() throws RecognitionException {
        WaebricChecker.textTail_return retval = new WaebricChecker.textTail_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POSTTEXT125=null;
        CommonTree MIDTEXT126=null;
        WaebricChecker.embed_return embed127 = null;

        WaebricChecker.textTail_return textTail128 = null;


        CommonTree POSTTEXT125_tree=null;
        CommonTree MIDTEXT126_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:331:9: ( POSTTEXT | MIDTEXT embed textTail )
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:331:12: POSTTEXT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    POSTTEXT125=(CommonTree)match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail941); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    POSTTEXT125_tree = (CommonTree)adaptor.dupNode(POSTTEXT125);

                    adaptor.addChild(root_0, POSTTEXT125_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:331:23: MIDTEXT embed textTail
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    MIDTEXT126=(CommonTree)match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail945); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MIDTEXT126_tree = (CommonTree)adaptor.dupNode(MIDTEXT126);

                    adaptor.addChild(root_0, MIDTEXT126_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embed_in_textTail947);
                    embed127=embed();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, embed127.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_textTail_in_textTail949);
                    textTail128=textTail();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, textTail128.getTree());

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

    // $ANTLR start synpred19_WaebricChecker
    public final void synpred19_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:248:8: ( '+' expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:248:8: '+' expression
        {
        match(input,58,FOLLOW_58_in_synpred19_WaebricChecker378); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred19_WaebricChecker380);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_WaebricChecker

    // $ANTLR start synpred20_WaebricChecker
    public final void synpred20_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:248:25: ( '.' IDCON )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:248:25: '.' IDCON
        {
        match(input,43,FOLLOW_43_in_synpred20_WaebricChecker384); if (state.failed) return ;
        match(input,IDCON,FOLLOW_IDCON_in_synpred20_WaebricChecker386); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred20_WaebricChecker

    // $ANTLR start synpred42_WaebricChecker
    public final void synpred42_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:320:7: ( expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:320:7: expression
        {
        pushFollow(FOLLOW_expression_in_synpred42_WaebricChecker844);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred42_WaebricChecker

    // $ANTLR start synpred43_WaebricChecker
    public final void synpred43_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:322:8: ( '&&' predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:322:8: '&&' predicate
        {
        match(input,69,FOLLOW_69_in_synpred43_WaebricChecker867); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred43_WaebricChecker869);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred43_WaebricChecker

    // $ANTLR start synpred44_WaebricChecker
    public final void synpred44_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:322:25: ( '||' predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:322:25: '||' predicate
        {
        match(input,70,FOLLOW_70_in_synpred44_WaebricChecker873); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred44_WaebricChecker875);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred44_WaebricChecker

    // $ANTLR start synpred48_WaebricChecker
    public final void synpred48_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:330:10: ( ( markup )* expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:330:10: ( markup )* expression
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:330:10: ( markup )*
        loop35:
        do {
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==MARKUP) ) {
                alt35=1;
            }


            switch (alt35) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred48_WaebricChecker923);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop35;
            }
        } while (true);

        pushFollow(FOLLOW_expression_in_synpred48_WaebricChecker926);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred48_WaebricChecker

    // $ANTLR start synpred49_WaebricChecker
    public final void synpred49_WaebricChecker_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:330:31: ( markup )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:330:31: markup
        {
        pushFollow(FOLLOW_markup_in_synpred49_WaebricChecker930);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred49_WaebricChecker

    // Delegated rules

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


    protected DFA20 dfa20 = new DFA20(this);
    protected DFA25 dfa25 = new DFA25(this);
    static final String DFA20_eotS =
        "\15\uffff";
    static final String DFA20_eofS =
        "\15\uffff";
    static final String DFA20_minS =
        "\1\7\5\uffff\1\2\3\uffff\1\15\2\uffff";
    static final String DFA20_maxS =
        "\1\102\5\uffff\1\2\3\uffff\1\70\2\uffff";
    static final String DFA20_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\11\1\12\1\uffff\1\6"+
        "\1\7";
    static final String DFA20_specialS =
        "\15\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\11\16\uffff\1\5\41\uffff\1\4\2\uffff\1\1\1\uffff\1\2\1\3"+
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
            "\1\13\1\uffff\3\13\1\uffff\1\14\42\uffff\1\13\1\uffff\1\13",
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
            return "268:1: statement : ( ^( 'if' predicate statement ( 'else' statement )? ) | eachStatement | letStatement | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ) | ^( 'echo' expression ) | ^( 'echo' embedding ) | ^( 'cdata' expression ) | 'yield;' | ^( MARKUP_STATEMENT markup markupChain ) );";
        }
    }
    static final String DFA25_eotS =
        "\12\uffff";
    static final String DFA25_eofS =
        "\12\uffff";
    static final String DFA25_minS =
        "\1\15\1\uffff\6\0\2\uffff";
    static final String DFA25_maxS =
        "\1\103\1\uffff\6\0\2\uffff";
    static final String DFA25_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\1\3";
    static final String DFA25_specialS =
        "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\2\uffff}>";
    static final String[] DFA25_transitionS = {
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
            return "319:13: ( '!' predicate | expression | expression '.' type '?' )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TreeNodeStream input = (TreeNodeStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA25_2 = input.LA(1);

                         
                        int index25_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index25_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA25_3 = input.LA(1);

                         
                        int index25_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index25_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA25_4 = input.LA(1);

                         
                        int index25_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index25_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA25_5 = input.LA(1);

                         
                        int index25_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index25_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA25_6 = input.LA(1);

                         
                        int index25_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index25_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA25_7 = input.LA(1);

                         
                        int index25_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index25_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 25, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_42_in_module85 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_moduleId_in_module87 = new BitSet(new long[]{0x0000100000800408L});
    public static final BitSet FOLLOW_imprt_in_module89 = new BitSet(new long[]{0x0000100000800408L});
    public static final BitSet FOLLOW_site_in_module92 = new BitSet(new long[]{0x0000000000800408L});
    public static final BitSet FOLLOW_function_in_module95 = new BitSet(new long[]{0x0000000000000408L});
    public static final BitSet FOLLOW_IDCON_in_moduleId125 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_moduleId135 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_IDCON_in_moduleId139 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_44_in_imprt160 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_moduleId_in_imprt162 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_module_in_imprt164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SITE_in_site177 = new BitSet(new long[]{0x0000000003004000L});
    public static final BitSet FOLLOW_mappings_in_site179 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_END_in_site181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapping_in_mappings189 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_mappings194 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_mapping_in_mappings196 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_PATH_in_mapping208 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_mapping210 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_markup_in_mapping212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUP_in_markup227 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_markup229 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x00000000000003FFL});
    public static final BitSet FOLLOW_arguments_in_markup233 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARGUMENTS_in_arguments255 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_argument_in_arguments259 = new BitSet(new long[]{0x014000000003A008L});
    public static final BitSet FOLLOW_expression_in_argument278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_argument282 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_argument284 = new BitSet(new long[]{0x014000000003A000L});
    public static final BitSet FOLLOW_expression_in_argument286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_expression303 = new BitSet(new long[]{0x0400080000000002L});
    public static final BitSet FOLLOW_NATCON_in_expression314 = new BitSet(new long[]{0x0400080000000002L});
    public static final BitSet FOLLOW_TEXT_in_expression318 = new BitSet(new long[]{0x0400080000000002L});
    public static final BitSet FOLLOW_SYMBOLCON_in_expression322 = new BitSet(new long[]{0x0400080000000002L});
    public static final BitSet FOLLOW_54_in_expression331 = new BitSet(new long[]{0x01C800000003A000L});
    public static final BitSet FOLLOW_expression_in_expression333 = new BitSet(new long[]{0x0088000000000000L});
    public static final BitSet FOLLOW_51_in_expression338 = new BitSet(new long[]{0x014000000003A000L});
    public static final BitSet FOLLOW_expression_in_expression340 = new BitSet(new long[]{0x0088000000000000L});
    public static final BitSet FOLLOW_55_in_expression345 = new BitSet(new long[]{0x0400080000000002L});
    public static final BitSet FOLLOW_56_in_expression354 = new BitSet(new long[]{0x0208000000002000L});
    public static final BitSet FOLLOW_keyValuePair_in_expression356 = new BitSet(new long[]{0x0208000000000000L});
    public static final BitSet FOLLOW_51_in_expression361 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_keyValuePair_in_expression363 = new BitSet(new long[]{0x0208000000000000L});
    public static final BitSet FOLLOW_57_in_expression368 = new BitSet(new long[]{0x0400080000000002L});
    public static final BitSet FOLLOW_58_in_expression378 = new BitSet(new long[]{0x014000000003A000L});
    public static final BitSet FOLLOW_expression_in_expression380 = new BitSet(new long[]{0x0400080000000002L});
    public static final BitSet FOLLOW_43_in_expression384 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_IDCON_in_expression386 = new BitSet(new long[]{0x0400080000000002L});
    public static final BitSet FOLLOW_IDCON_in_keyValuePair398 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_keyValuePair400 = new BitSet(new long[]{0x014000000003A000L});
    public static final BitSet FOLLOW_expression_in_keyValuePair402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_function428 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_function430 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_formals_in_function432 = new BitSet(new long[]{0x6900000000400088L,0x0000000000000007L});
    public static final BitSet FOLLOW_statement_in_function434 = new BitSet(new long[]{0x6900000000400088L,0x0000000000000007L});
    public static final BitSet FOLLOW_FORMALS_in_formals462 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_formals466 = new BitSet(new long[]{0x0000000000002008L});
    public static final BitSet FOLLOW_59_in_statement486 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_predicate_in_statement488 = new BitSet(new long[]{0x6900000000400080L,0x0000000000000007L});
    public static final BitSet FOLLOW_statement_in_statement490 = new BitSet(new long[]{0x1000000000000008L});
    public static final BitSet FOLLOW_60_in_statement494 = new BitSet(new long[]{0x6900000000400080L,0x0000000000000007L});
    public static final BitSet FOLLOW_statement_in_statement496 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_eachStatement_in_statement508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_letStatement_in_statement515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_statement524 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statement526 = new BitSet(new long[]{0x6B00000000400080L,0x0000000000000007L});
    public static final BitSet FOLLOW_57_in_statement529 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COMMENT_in_statement540 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRCON_in_statement542 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_64_in_statement553 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement555 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_64_in_statement566 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_statement568 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_65_in_statement579 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement581 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_66_in_statement590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement599 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement601 = new BitSet(new long[]{0x0000000002000100L});
    public static final BitSet FOLLOW_markupChain_in_statement603 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_CHAIN_in_markupChain619 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_markupChain621 = new BitSet(new long[]{0x0000000002000100L});
    public static final BitSet FOLLOW_markupChain_in_markupChain623 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_CHAIN_in_markupChain634 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_markupChain636 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_CHAIN_in_markupChain647 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_markupChain649 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_CHAIN_in_markupChain660 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_markupChain662 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SEMICOLON_in_markupChain671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_eachStatement695 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_50_in_eachStatement697 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_IDCON_in_eachStatement699 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_eachStatement701 = new BitSet(new long[]{0x014000000003A000L});
    public static final BitSet FOLLOW_expression_in_eachStatement703 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_eachStatement705 = new BitSet(new long[]{0x6900000000400080L,0x0000000000000007L});
    public static final BitSet FOLLOW_statement_in_eachStatement709 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_62_in_letStatement735 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_assignment_in_letStatement737 = new BitSet(new long[]{0x8000000000002400L});
    public static final BitSet FOLLOW_63_in_letStatement740 = new BitSet(new long[]{0x6900000001400080L,0x0000000000000007L});
    public static final BitSet FOLLOW_statement_in_letStatement742 = new BitSet(new long[]{0x6900000001400080L,0x0000000000000007L});
    public static final BitSet FOLLOW_END_in_letStatement745 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDCON_in_assignment756 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_assignment758 = new BitSet(new long[]{0x014000000003A000L});
    public static final BitSet FOLLOW_expression_in_assignment760 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_assignment762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funcBinding_in_assignment768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_funcBinding797 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_funcBinding801 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_formals_in_funcBinding805 = new BitSet(new long[]{0x6900000000400080L,0x0000000000000007L});
    public static final BitSet FOLLOW_statement_in_funcBinding807 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_predicate833 = new BitSet(new long[]{0x014000000003A000L,0x0000000000000008L});
    public static final BitSet FOLLOW_predicate_in_predicate835 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_expression_in_predicate844 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_expression_in_predicate852 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_predicate854 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000380L});
    public static final BitSet FOLLOW_type_in_predicate856 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_predicate858 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_69_in_predicate867 = new BitSet(new long[]{0x014000000003A000L,0x0000000000000008L});
    public static final BitSet FOLLOW_predicate_in_predicate869 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_70_in_predicate873 = new BitSet(new long[]{0x014000000003A000L,0x0000000000000008L});
    public static final BitSet FOLLOW_predicate_in_predicate875 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding910 = new BitSet(new long[]{0x014000000003A040L});
    public static final BitSet FOLLOW_embed_in_embedding912 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_textTail_in_embedding914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed923 = new BitSet(new long[]{0x014000000003A040L});
    public static final BitSet FOLLOW_expression_in_embed926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed930 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_markup_in_embed933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail945 = new BitSet(new long[]{0x014000000003A040L});
    public static final BitSet FOLLOW_embed_in_textTail947 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_textTail_in_textTail949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_synpred19_WaebricChecker378 = new BitSet(new long[]{0x014000000003A000L});
    public static final BitSet FOLLOW_expression_in_synpred19_WaebricChecker380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_synpred20_WaebricChecker384 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_IDCON_in_synpred20_WaebricChecker386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred42_WaebricChecker844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_synpred43_WaebricChecker867 = new BitSet(new long[]{0x014000000003A000L,0x0000000000000008L});
    public static final BitSet FOLLOW_predicate_in_synpred43_WaebricChecker869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_synpred44_WaebricChecker873 = new BitSet(new long[]{0x014000000003A000L,0x0000000000000008L});
    public static final BitSet FOLLOW_predicate_in_synpred44_WaebricChecker875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred48_WaebricChecker923 = new BitSet(new long[]{0x014000000003A040L});
    public static final BitSet FOLLOW_expression_in_synpred48_WaebricChecker926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred49_WaebricChecker930 = new BitSet(new long[]{0x0000000000000002L});

}