// $ANTLR 3.1.2 /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g 2009-08-29 16:52:48

	package org.cwi.waebric;
	import antlr.SemanticException;
	import java.util.Map;
	import java.util.HashMap;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


public class WaebricChecker extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATTRIBUTES", "ARGUMENTS", "MARKUP", "MARKUPS", "MARKUP_STATEMENT", "MARKUP_EXPRESSION", "MARKUP_EMBEDDING", "FORMALS", "IDCON", "PATH", "NATCON", "TEXT", "SYMBOLCON", "STRCON", "PRETEXT", "POSTTEXT", "MIDTEXT", "COMMENT", "SITE", "END", "SEMICOLON", "LETTER", "DIGIT", "HEXADECIMAL", "PATHELEMENT", "FILEEXT", "STRCHAR", "ESCLAYOUT", "DECIMAL", "TEXTCHAR", "ESCQUOTE", "AMP", "CHARREF", "ENTREF", "SYMBOLCHAR", "COMMENTS", "LAYOUT", "'module'", "'.'", "'import'", "':'", "'#'", "'$'", "'@'", "'%'", "'('", "','", "')'", "'='", "'['", "']'", "'{'", "'}'", "'+'", "'def'", "'if'", "'else'", "'each'", "'let'", "'in'", "'yield'", "'echo'", "'cdata'", "'!'", "'?'", "'&&'", "'||'", "'list'", "'record'", "'string'"
    };
    public static final int ESCLAYOUT=31;
    public static final int T__42=42;
    public static final int END=23;
    public static final int T__57=57;
    public static final int T__51=51;
    public static final int FILEEXT=29;
    public static final int T__69=69;
    public static final int T__47=47;
    public static final int T__73=73;
    public static final int T__50=50;
    public static final int STRCHAR=30;
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
    public static final int T__56=56;
    public static final int PATHELEMENT=28;
    public static final int ENTREF=37;
    public static final int LETTER=25;
    public static final int ARGUMENTS=5;
    public static final int SITE=22;
    public static final int T__58=58;
    public static final int T__64=64;
    public static final int T__44=44;
    public static final int T__66=66;
    public static final int SYMBOLCHAR=38;
    public static final int COMMENT=21;
    public static final int MARKUP_STATEMENT=8;
    public static final int FORMALS=11;
    public static final int T__45=45;
    public static final int T__55=55;
    public static final int CHARREF=36;
    public static final int MIDTEXT=20;
    public static final int T__63=63;
    public static final int PRETEXT=18;
    public static final int T__43=43;
    public static final int SEMICOLON=24;
    public static final int EOF=-1;
    public static final int T__53=53;
    public static final int TEXT=15;
    public static final int NATCON=14;
    public static final int T__60=60;
    public static final int T__41=41;
    public static final int MARKUP_EMBEDDING=10;
    public static final int T__71=71;
    public static final int PATH=13;

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:188:1: module : ^( 'module' moduleId ( imprt )* ( site )* ( function )* ) ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:193:4: ( ^( 'module' moduleId ( imprt )* ( site )* ( function )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:193:7: ^( 'module' moduleId ( imprt )* ( site )* ( function )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal1=(CommonTree)match(input,41,FOLLOW_41_in_module77); 
            string_literal1_tree = (CommonTree)adaptor.dupNode(string_literal1);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal1_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_moduleId_in_module79);
            moduleId2=moduleId();

            state._fsp--;

            adaptor.addChild(root_1, moduleId2.getTree());
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:193:28: ( imprt )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==43) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:193:28: imprt
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_imprt_in_module81);
            	    imprt3=imprt();

            	    state._fsp--;

            	    adaptor.addChild(root_1, imprt3.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:193:35: ( site )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==SITE) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:193:35: site
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_site_in_module84);
            	    site4=site();

            	    state._fsp--;

            	    adaptor.addChild(root_1, site4.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:193:41: ( function )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==58) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:193:41: function
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_function_in_module87);
            	    function5=function();

            	    state._fsp--;

            	    adaptor.addChild(root_1, function5.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:196:1: moduleId : id= IDCON ( '.' id= IDCON )* ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:199:2: (id= IDCON ( '.' id= IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:199:5: id= IDCON ( '.' id= IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_moduleId117); 
            id_tree = (CommonTree)adaptor.dupNode(id);

            adaptor.addChild(root_0, id_tree);

             path = id.getText(); 
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:200:4: ( '.' id= IDCON )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==42) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:200:6: '.' id= IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal6=(CommonTree)match(input,42,FOLLOW_42_in_moduleId127); 
            	    char_literal6_tree = (CommonTree)adaptor.dupNode(char_literal6);

            	    adaptor.addChild(root_0, char_literal6_tree);

            	    _last = (CommonTree)input.LT(1);
            	    id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_moduleId131); 
            	    id_tree = (CommonTree)adaptor.dupNode(id);

            	    adaptor.addChild(root_0, id_tree);

            	     path += "/" + id.getText(); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

             path += ".wae"; 
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:208:1: imprt : 'import' moduleId ( module )? ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:208:6: ( 'import' moduleId ( module )? )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:208:10: 'import' moduleId ( module )?
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal7=(CommonTree)match(input,43,FOLLOW_43_in_imprt152); 
            string_literal7_tree = (CommonTree)adaptor.dupNode(string_literal7);

            adaptor.addChild(root_0, string_literal7_tree);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_moduleId_in_imprt154);
            moduleId8=moduleId();

            state._fsp--;

            adaptor.addChild(root_0, moduleId8.getTree());
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:208:28: ( module )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==41) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:208:28: module
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_module_in_imprt156);
                    module9=module();

                    state._fsp--;

                    adaptor.addChild(root_0, module9.getTree());

                    }
                    break;

            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:212:1: site : 'site' mappings 'end' ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:212:5: ( 'site' mappings 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:212:9: 'site' mappings 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal10=(CommonTree)match(input,SITE,FOLLOW_SITE_in_site169); 
            string_literal10_tree = (CommonTree)adaptor.dupNode(string_literal10);

            adaptor.addChild(root_0, string_literal10_tree);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_mappings_in_site171);
            mappings11=mappings();

            state._fsp--;

            adaptor.addChild(root_0, mappings11.getTree());
            _last = (CommonTree)input.LT(1);
            string_literal12=(CommonTree)match(input,END,FOLLOW_END_in_site173); 
            string_literal12_tree = (CommonTree)adaptor.dupNode(string_literal12);

            adaptor.addChild(root_0, string_literal12_tree);


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:213:1: mappings : ( mapping )? ( ';' mapping )* ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:213:9: ( ( mapping )? ( ';' mapping )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:213:12: ( mapping )? ( ';' mapping )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:213:12: ( mapping )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==PATH) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:213:12: mapping
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_mapping_in_mappings181);
                    mapping13=mapping();

                    state._fsp--;

                    adaptor.addChild(root_0, mapping13.getTree());

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:213:21: ( ';' mapping )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==SEMICOLON) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:213:23: ';' mapping
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal14=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_mappings186); 
            	    char_literal14_tree = (CommonTree)adaptor.dupNode(char_literal14);

            	    adaptor.addChild(root_0, char_literal14_tree);

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_mapping_in_mappings188);
            	    mapping15=mapping();

            	    state._fsp--;

            	    adaptor.addChild(root_0, mapping15.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:214:1: mapping : PATH ':' markup ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:214:9: ( PATH ':' markup )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:214:12: PATH ':' markup
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PATH16=(CommonTree)match(input,PATH,FOLLOW_PATH_in_mapping200); 
            PATH16_tree = (CommonTree)adaptor.dupNode(PATH16);

            adaptor.addChild(root_0, PATH16_tree);

            _last = (CommonTree)input.LT(1);
            char_literal17=(CommonTree)match(input,44,FOLLOW_44_in_mapping202); 
            char_literal17_tree = (CommonTree)adaptor.dupNode(char_literal17);

            adaptor.addChild(root_0, char_literal17_tree);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_markup_in_mapping204);
            markup18=markup();

            state._fsp--;

            adaptor.addChild(root_0, markup18.getTree());

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:219:1: markup : ^( MARKUP IDCON . arguments ) ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:219:7: ( ^( MARKUP IDCON . arguments ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:219:11: ^( MARKUP IDCON . arguments )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            MARKUP19=(CommonTree)match(input,MARKUP,FOLLOW_MARKUP_in_markup219); 
            MARKUP19_tree = (CommonTree)adaptor.dupNode(MARKUP19);

            root_1 = (CommonTree)adaptor.becomeRoot(MARKUP19_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            IDCON20=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_markup221); 
            IDCON20_tree = (CommonTree)adaptor.dupNode(IDCON20);

            adaptor.addChild(root_1, IDCON20_tree);

            _last = (CommonTree)input.LT(1);
            wildcard21=(CommonTree)input.LT(1);
            matchAny(input); 
            wildcard21_tree = (CommonTree)adaptor.dupTree(wildcard21);
            adaptor.addChild(root_1, wildcard21_tree);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_arguments_in_markup225);
            arguments22=arguments();

            state._fsp--;

            adaptor.addChild(root_1, arguments22.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


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

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:231:1: arguments returns [int args = 0] : ^( ARGUMENTS ( argument )* ) ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:232:2: ( ^( ARGUMENTS ( argument )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:232:5: ^( ARGUMENTS ( argument )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            ARGUMENTS23=(CommonTree)match(input,ARGUMENTS,FOLLOW_ARGUMENTS_in_arguments247); 
            ARGUMENTS23_tree = (CommonTree)adaptor.dupNode(ARGUMENTS23);

            root_1 = (CommonTree)adaptor.becomeRoot(ARGUMENTS23_tree, root_1);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:232:18: ( argument )*
                loop8:
                do {
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==IDCON||(LA8_0>=NATCON && LA8_0<=SYMBOLCON)||LA8_0==53||LA8_0==55) ) {
                        alt8=1;
                    }


                    switch (alt8) {
                	case 1 :
                	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:232:20: argument
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_argument_in_arguments251);
                	    argument24=argument();

                	    state._fsp--;

                	    adaptor.addChild(root_1, argument24.getTree());
                	    retval.args++;

                	    }
                	    break;

                	default :
                	    break loop8;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:234:1: argument : ( expression | IDCON '=' expression );
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:234:9: ( expression | IDCON '=' expression )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==IDCON) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==52) ) {
                    alt9=2;
                }
                else if ( (LA9_1==UP||LA9_1==IDCON||(LA9_1>=NATCON && LA9_1<=SYMBOLCON)||LA9_1==42||LA9_1==53||LA9_1==55||LA9_1==57) ) {
                    alt9=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA9_0>=NATCON && LA9_0<=SYMBOLCON)||LA9_0==53||LA9_0==55) ) {
                alt9=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:234:12: expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_argument270);
                    expression25=expression();

                    state._fsp--;

                    adaptor.addChild(root_0, expression25.getTree());

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:234:25: IDCON '=' expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDCON26=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_argument274); 
                    IDCON26_tree = (CommonTree)adaptor.dupNode(IDCON26);

                    adaptor.addChild(root_0, IDCON26_tree);

                    _last = (CommonTree)input.LT(1);
                    char_literal27=(CommonTree)match(input,52,FOLLOW_52_in_argument276); 
                    char_literal27_tree = (CommonTree)adaptor.dupNode(char_literal27);

                    adaptor.addChild(root_0, char_literal27_tree);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_argument278);
                    expression28=expression();

                    state._fsp--;

                    adaptor.addChild(root_0, expression28.getTree());

                    }
                    break;

            }
            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:240:1: expression : (id= IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:240:11: ( (id= IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:240:14: (id= IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:240:14: (id= IDCON | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' )
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
            case 53:
                {
                alt14=5;
                }
                break;
            case 55:
                {
                alt14=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:240:16: id= IDCON
                    {
                    _last = (CommonTree)input.LT(1);
                    id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression295); 
                    id_tree = (CommonTree)adaptor.dupNode(id);

                    adaptor.addChild(root_0, id_tree);

                     
                    					if(! isDefinedVariable(id.getText())) {
                    						// Verify that all variable references are made to defined variables
                    						exceptions.add(new UndefinedVariableException(id_tree));
                    					} 
                    				

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:246:7: NATCON
                    {
                    _last = (CommonTree)input.LT(1);
                    NATCON29=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_expression306); 
                    NATCON29_tree = (CommonTree)adaptor.dupNode(NATCON29);

                    adaptor.addChild(root_0, NATCON29_tree);


                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:246:16: TEXT
                    {
                    _last = (CommonTree)input.LT(1);
                    TEXT30=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_expression310); 
                    TEXT30_tree = (CommonTree)adaptor.dupNode(TEXT30);

                    adaptor.addChild(root_0, TEXT30_tree);


                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:246:23: SYMBOLCON
                    {
                    _last = (CommonTree)input.LT(1);
                    SYMBOLCON31=(CommonTree)match(input,SYMBOLCON,FOLLOW_SYMBOLCON_in_expression314); 
                    SYMBOLCON31_tree = (CommonTree)adaptor.dupNode(SYMBOLCON31);

                    adaptor.addChild(root_0, SYMBOLCON31_tree);


                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:247:7: '[' ( expression )? ( ',' expression )* ']'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal32=(CommonTree)match(input,53,FOLLOW_53_in_expression323); 
                    char_literal32_tree = (CommonTree)adaptor.dupNode(char_literal32);

                    adaptor.addChild(root_0, char_literal32_tree);

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:247:11: ( expression )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==IDCON||(LA10_0>=NATCON && LA10_0<=SYMBOLCON)||LA10_0==53||LA10_0==55) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:247:11: expression
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_expression_in_expression325);
                            expression33=expression();

                            state._fsp--;

                            adaptor.addChild(root_0, expression33.getTree());

                            }
                            break;

                    }

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:247:23: ( ',' expression )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==50) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:247:25: ',' expression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal34=(CommonTree)match(input,50,FOLLOW_50_in_expression330); 
                    	    char_literal34_tree = (CommonTree)adaptor.dupNode(char_literal34);

                    	    adaptor.addChild(root_0, char_literal34_tree);

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_expression_in_expression332);
                    	    expression35=expression();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, expression35.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal36=(CommonTree)match(input,54,FOLLOW_54_in_expression337); 
                    char_literal36_tree = (CommonTree)adaptor.dupNode(char_literal36);

                    adaptor.addChild(root_0, char_literal36_tree);


                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:248:7: '{' ( keyValuePair )? ( ',' keyValuePair )* '}'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal37=(CommonTree)match(input,55,FOLLOW_55_in_expression346); 
                    char_literal37_tree = (CommonTree)adaptor.dupNode(char_literal37);

                    adaptor.addChild(root_0, char_literal37_tree);

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:248:11: ( keyValuePair )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==IDCON) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:248:11: keyValuePair
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_keyValuePair_in_expression348);
                            keyValuePair38=keyValuePair();

                            state._fsp--;

                            adaptor.addChild(root_0, keyValuePair38.getTree());

                            }
                            break;

                    }

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:248:25: ( ',' keyValuePair )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==50) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:248:27: ',' keyValuePair
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal39=(CommonTree)match(input,50,FOLLOW_50_in_expression353); 
                    	    char_literal39_tree = (CommonTree)adaptor.dupNode(char_literal39);

                    	    adaptor.addChild(root_0, char_literal39_tree);

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_keyValuePair_in_expression355);
                    	    keyValuePair40=keyValuePair();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, keyValuePair40.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal41=(CommonTree)match(input,56,FOLLOW_56_in_expression360); 
                    char_literal41_tree = (CommonTree)adaptor.dupNode(char_literal41);

                    adaptor.addChild(root_0, char_literal41_tree);


                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:249:6: ( '+' expression | '.' IDCON )*
            loop15:
            do {
                int alt15=3;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==57) ) {
                    alt15=1;
                }
                else if ( (LA15_0==42) ) {
                    alt15=2;
                }


                switch (alt15) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:249:8: '+' expression
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal42=(CommonTree)match(input,57,FOLLOW_57_in_expression370); 
            	    char_literal42_tree = (CommonTree)adaptor.dupNode(char_literal42);

            	    adaptor.addChild(root_0, char_literal42_tree);

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expression_in_expression372);
            	    expression43=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expression43.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:249:25: '.' IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal44=(CommonTree)match(input,42,FOLLOW_42_in_expression376); 
            	    char_literal44_tree = (CommonTree)adaptor.dupNode(char_literal44);

            	    adaptor.addChild(root_0, char_literal44_tree);

            	    _last = (CommonTree)input.LT(1);
            	    IDCON45=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression378); 
            	    IDCON45_tree = (CommonTree)adaptor.dupNode(IDCON45);

            	    adaptor.addChild(root_0, IDCON45_tree);


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:251:1: keyValuePair : IDCON ':' expression ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:251:13: ( IDCON ':' expression )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:251:16: IDCON ':' expression
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON46=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_keyValuePair390); 
            IDCON46_tree = (CommonTree)adaptor.dupNode(IDCON46);

            adaptor.addChild(root_0, IDCON46_tree);

            _last = (CommonTree)input.LT(1);
            char_literal47=(CommonTree)match(input,44,FOLLOW_44_in_keyValuePair392); 
            char_literal47_tree = (CommonTree)adaptor.dupNode(char_literal47);

            adaptor.addChild(root_0, char_literal47_tree);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_keyValuePair394);
            expression48=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression48.getTree());

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:255:1: function : ^( 'def' IDCON formals ( statement )* ) ;
    public final WaebricChecker.function_return function() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.function_return retval = new WaebricChecker.function_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal49=null;
        CommonTree IDCON50=null;
        WaebricChecker.formals_return formals51 = null;

        WaebricChecker.statement_return statement52 = null;


        CommonTree string_literal49_tree=null;
        CommonTree IDCON50_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new ArrayList<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:260:4: ( ^( 'def' IDCON formals ( statement )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:260:7: ^( 'def' IDCON formals ( statement )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal49=(CommonTree)match(input,58,FOLLOW_58_in_function420); 
            string_literal49_tree = (CommonTree)adaptor.dupNode(string_literal49);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal49_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            IDCON50=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_function422); 
            IDCON50_tree = (CommonTree)adaptor.dupNode(IDCON50);

            adaptor.addChild(root_1, IDCON50_tree);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_formals_in_function424);
            formals51=formals();

            state._fsp--;

            adaptor.addChild(root_1, formals51.getTree());
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:260:30: ( statement )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=MARKUPS && LA16_0<=MARKUP_EMBEDDING)||LA16_0==COMMENT||LA16_0==55||LA16_0==59||(LA16_0>=61 && LA16_0<=62)||(LA16_0>=64 && LA16_0<=66)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:260:30: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_function426);
            	    statement52=statement();

            	    state._fsp--;

            	    adaptor.addChild(root_1, statement52.getTree());

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:262:1: formals returns [int args = 0;] : ^( FORMALS ( IDCON )* ) ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:264:2: ( ^( FORMALS ( IDCON )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:265:4: ^( FORMALS ( IDCON )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FORMALS53=(CommonTree)match(input,FORMALS,FOLLOW_FORMALS_in_formals454); 
            FORMALS53_tree = (CommonTree)adaptor.dupNode(FORMALS53);

            root_1 = (CommonTree)adaptor.becomeRoot(FORMALS53_tree, root_1);



            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:265:15: ( IDCON )*
                loop17:
                do {
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==IDCON) ) {
                        alt17=1;
                    }


                    switch (alt17) {
                	case 1 :
                	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:265:17: IDCON
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    IDCON54=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_formals458); 
                	    IDCON54_tree = (CommonTree)adaptor.dupNode(IDCON54);

                	    adaptor.addChild(root_1, IDCON54_tree);

                	     defineVariable(IDCON54.getText()); retval.args++; 

                	    }
                	    break;

                	default :
                	    break loop17;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:269:1: statement : ( ^( 'if' predicate statement ( 'else' statement )? ) | ^( 'each' '(' IDCON ':' expression ')' statement ) | ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ) | ^( 'echo' expression ) | ^( 'echo' embedding ) | ^( 'cdata' expression ) | 'yield' | ^( MARKUP_EXPRESSION ( markup )+ expression ) | ^( MARKUP_STATEMENT ( markup )+ statement ) | ^( MARKUP_EMBEDDING ( markup )+ embedding ) | ^( MARKUPS ( markup )+ ) );
    public final WaebricChecker.statement_return statement() throws RecognitionException {
        WaebricChecker.statement_return retval = new WaebricChecker.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal55=null;
        CommonTree string_literal58=null;
        CommonTree string_literal60=null;
        CommonTree char_literal61=null;
        CommonTree IDCON62=null;
        CommonTree char_literal63=null;
        CommonTree char_literal65=null;
        CommonTree string_literal67=null;
        CommonTree string_literal69=null;
        CommonTree string_literal71=null;
        CommonTree char_literal72=null;
        CommonTree char_literal74=null;
        CommonTree string_literal75=null;
        CommonTree STRCON76=null;
        CommonTree string_literal77=null;
        CommonTree string_literal79=null;
        CommonTree string_literal81=null;
        CommonTree string_literal83=null;
        CommonTree MARKUP_EXPRESSION84=null;
        CommonTree MARKUP_STATEMENT87=null;
        CommonTree MARKUP_EMBEDDING90=null;
        CommonTree MARKUPS93=null;
        WaebricChecker.predicate_return predicate56 = null;

        WaebricChecker.statement_return statement57 = null;

        WaebricChecker.statement_return statement59 = null;

        WaebricChecker.expression_return expression64 = null;

        WaebricChecker.statement_return statement66 = null;

        WaebricChecker.assignment_return assignment68 = null;

        WaebricChecker.statement_return statement70 = null;

        WaebricChecker.statement_return statement73 = null;

        WaebricChecker.expression_return expression78 = null;

        WaebricChecker.embedding_return embedding80 = null;

        WaebricChecker.expression_return expression82 = null;

        WaebricChecker.markup_return markup85 = null;

        WaebricChecker.expression_return expression86 = null;

        WaebricChecker.markup_return markup88 = null;

        WaebricChecker.statement_return statement89 = null;

        WaebricChecker.markup_return markup91 = null;

        WaebricChecker.embedding_return embedding92 = null;

        WaebricChecker.markup_return markup94 = null;


        CommonTree string_literal55_tree=null;
        CommonTree string_literal58_tree=null;
        CommonTree string_literal60_tree=null;
        CommonTree char_literal61_tree=null;
        CommonTree IDCON62_tree=null;
        CommonTree char_literal63_tree=null;
        CommonTree char_literal65_tree=null;
        CommonTree string_literal67_tree=null;
        CommonTree string_literal69_tree=null;
        CommonTree string_literal71_tree=null;
        CommonTree char_literal72_tree=null;
        CommonTree char_literal74_tree=null;
        CommonTree string_literal75_tree=null;
        CommonTree STRCON76_tree=null;
        CommonTree string_literal77_tree=null;
        CommonTree string_literal79_tree=null;
        CommonTree string_literal81_tree=null;
        CommonTree string_literal83_tree=null;
        CommonTree MARKUP_EXPRESSION84_tree=null;
        CommonTree MARKUP_STATEMENT87_tree=null;
        CommonTree MARKUP_EMBEDDING90_tree=null;
        CommonTree MARKUPS93_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:269:10: ( ^( 'if' predicate statement ( 'else' statement )? ) | ^( 'each' '(' IDCON ':' expression ')' statement ) | ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ) | ^( 'echo' expression ) | ^( 'echo' embedding ) | ^( 'cdata' expression ) | 'yield' | ^( MARKUP_EXPRESSION ( markup )+ expression ) | ^( MARKUP_STATEMENT ( markup )+ statement ) | ^( MARKUP_EMBEDDING ( markup )+ embedding ) | ^( MARKUPS ( markup )+ ) )
            int alt26=13;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:269:13: ^( 'if' predicate statement ( 'else' statement )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal55=(CommonTree)match(input,59,FOLLOW_59_in_statement478); 
                    string_literal55_tree = (CommonTree)adaptor.dupNode(string_literal55);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal55_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_statement480);
                    predicate56=predicate();

                    state._fsp--;

                    adaptor.addChild(root_1, predicate56.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement482);
                    statement57=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, statement57.getTree());
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:269:41: ( 'else' statement )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==60) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:269:43: 'else' statement
                            {
                            _last = (CommonTree)input.LT(1);
                            string_literal58=(CommonTree)match(input,60,FOLLOW_60_in_statement486); 
                            string_literal58_tree = (CommonTree)adaptor.dupNode(string_literal58);

                            adaptor.addChild(root_1, string_literal58_tree);

                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_statement_in_statement488);
                            statement59=statement();

                            state._fsp--;

                            adaptor.addChild(root_1, statement59.getTree());

                            }
                            break;

                    }


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:270:6: ^( 'each' '(' IDCON ':' expression ')' statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal60=(CommonTree)match(input,61,FOLLOW_61_in_statement503); 
                    string_literal60_tree = (CommonTree)adaptor.dupNode(string_literal60);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal60_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    char_literal61=(CommonTree)match(input,49,FOLLOW_49_in_statement505); 
                    char_literal61_tree = (CommonTree)adaptor.dupNode(char_literal61);

                    adaptor.addChild(root_1, char_literal61_tree);

                    _last = (CommonTree)input.LT(1);
                    IDCON62=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_statement507); 
                    IDCON62_tree = (CommonTree)adaptor.dupNode(IDCON62);

                    adaptor.addChild(root_1, IDCON62_tree);

                    _last = (CommonTree)input.LT(1);
                    char_literal63=(CommonTree)match(input,44,FOLLOW_44_in_statement509); 
                    char_literal63_tree = (CommonTree)adaptor.dupNode(char_literal63);

                    adaptor.addChild(root_1, char_literal63_tree);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement511);
                    expression64=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, expression64.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal65=(CommonTree)match(input,51,FOLLOW_51_in_statement513); 
                    char_literal65_tree = (CommonTree)adaptor.dupNode(char_literal65);

                    adaptor.addChild(root_1, char_literal65_tree);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement515);
                    statement66=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, statement66.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:271:6: ^( 'let' ( assignment )+ 'in' ( statement )* 'end' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal67=(CommonTree)match(input,62,FOLLOW_62_in_statement526); 
                    string_literal67_tree = (CommonTree)adaptor.dupNode(string_literal67);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal67_tree, root_1);



                    match(input, Token.DOWN, null); 
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:271:15: ( assignment )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==IDCON||LA19_0==58) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:271:15: assignment
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_assignment_in_statement528);
                    	    assignment68=assignment();

                    	    state._fsp--;

                    	    adaptor.addChild(root_1, assignment68.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt19 >= 1 ) break loop19;
                                EarlyExitException eee =
                                    new EarlyExitException(19, input);
                                throw eee;
                        }
                        cnt19++;
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    string_literal69=(CommonTree)match(input,63,FOLLOW_63_in_statement531); 
                    string_literal69_tree = (CommonTree)adaptor.dupNode(string_literal69);

                    adaptor.addChild(root_1, string_literal69_tree);

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:271:32: ( statement )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( ((LA20_0>=MARKUPS && LA20_0<=MARKUP_EMBEDDING)||LA20_0==COMMENT||LA20_0==55||LA20_0==59||(LA20_0>=61 && LA20_0<=62)||(LA20_0>=64 && LA20_0<=66)) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:271:32: statement
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_statement_in_statement533);
                    	    statement70=statement();

                    	    state._fsp--;

                    	    adaptor.addChild(root_1, statement70.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    string_literal71=(CommonTree)match(input,END,FOLLOW_END_in_statement536); 
                    string_literal71_tree = (CommonTree)adaptor.dupNode(string_literal71);

                    adaptor.addChild(root_1, string_literal71_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:272:6: ^( '{' ( statement )* '}' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal72=(CommonTree)match(input,55,FOLLOW_55_in_statement547); 
                    char_literal72_tree = (CommonTree)adaptor.dupNode(char_literal72);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal72_tree, root_1);



                    match(input, Token.DOWN, null); 
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:272:13: ( statement )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( ((LA21_0>=MARKUPS && LA21_0<=MARKUP_EMBEDDING)||LA21_0==COMMENT||LA21_0==55||LA21_0==59||(LA21_0>=61 && LA21_0<=62)||(LA21_0>=64 && LA21_0<=66)) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:272:13: statement
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_statement_in_statement549);
                    	    statement73=statement();

                    	    state._fsp--;

                    	    adaptor.addChild(root_1, statement73.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal74=(CommonTree)match(input,56,FOLLOW_56_in_statement552); 
                    char_literal74_tree = (CommonTree)adaptor.dupNode(char_literal74);

                    adaptor.addChild(root_1, char_literal74_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:273:6: ^( 'comment' STRCON )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal75=(CommonTree)match(input,COMMENT,FOLLOW_COMMENT_in_statement563); 
                    string_literal75_tree = (CommonTree)adaptor.dupNode(string_literal75);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal75_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    STRCON76=(CommonTree)match(input,STRCON,FOLLOW_STRCON_in_statement565); 
                    STRCON76_tree = (CommonTree)adaptor.dupNode(STRCON76);

                    adaptor.addChild(root_1, STRCON76_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:274:6: ^( 'echo' expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal77=(CommonTree)match(input,65,FOLLOW_65_in_statement576); 
                    string_literal77_tree = (CommonTree)adaptor.dupNode(string_literal77);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal77_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement578);
                    expression78=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, expression78.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 7 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:275:6: ^( 'echo' embedding )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal79=(CommonTree)match(input,65,FOLLOW_65_in_statement589); 
                    string_literal79_tree = (CommonTree)adaptor.dupNode(string_literal79);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal79_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement591);
                    embedding80=embedding();

                    state._fsp--;

                    adaptor.addChild(root_1, embedding80.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 8 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:276:6: ^( 'cdata' expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal81=(CommonTree)match(input,66,FOLLOW_66_in_statement602); 
                    string_literal81_tree = (CommonTree)adaptor.dupNode(string_literal81);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal81_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement604);
                    expression82=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, expression82.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 9 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:277:6: 'yield'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal83=(CommonTree)match(input,64,FOLLOW_64_in_statement613); 
                    string_literal83_tree = (CommonTree)adaptor.dupNode(string_literal83);

                    adaptor.addChild(root_0, string_literal83_tree);


                    }
                    break;
                case 10 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:278:6: ^( MARKUP_EXPRESSION ( markup )+ expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_EXPRESSION84=(CommonTree)match(input,MARKUP_EXPRESSION,FOLLOW_MARKUP_EXPRESSION_in_statement622); 
                    MARKUP_EXPRESSION84_tree = (CommonTree)adaptor.dupNode(MARKUP_EXPRESSION84);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_EXPRESSION84_tree, root_1);



                    match(input, Token.DOWN, null); 
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:278:27: ( markup )+
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
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:278:27: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement624);
                    	    markup85=markup();

                    	    state._fsp--;

                    	    adaptor.addChild(root_1, markup85.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt22 >= 1 ) break loop22;
                                EarlyExitException eee =
                                    new EarlyExitException(22, input);
                                throw eee;
                        }
                        cnt22++;
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement627);
                    expression86=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, expression86.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 11 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:279:6: ^( MARKUP_STATEMENT ( markup )+ statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT87=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement638); 
                    MARKUP_STATEMENT87_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT87);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT87_tree, root_1);



                    match(input, Token.DOWN, null); 
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:279:26: ( markup )+
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
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:279:26: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement640);
                    	    markup88=markup();

                    	    state._fsp--;

                    	    adaptor.addChild(root_1, markup88.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt23 >= 1 ) break loop23;
                                EarlyExitException eee =
                                    new EarlyExitException(23, input);
                                throw eee;
                        }
                        cnt23++;
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement643);
                    statement89=statement();

                    state._fsp--;

                    adaptor.addChild(root_1, statement89.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 12 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:280:6: ^( MARKUP_EMBEDDING ( markup )+ embedding )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_EMBEDDING90=(CommonTree)match(input,MARKUP_EMBEDDING,FOLLOW_MARKUP_EMBEDDING_in_statement654); 
                    MARKUP_EMBEDDING90_tree = (CommonTree)adaptor.dupNode(MARKUP_EMBEDDING90);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_EMBEDDING90_tree, root_1);



                    match(input, Token.DOWN, null); 
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:280:26: ( markup )+
                    int cnt24=0;
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==MARKUP) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:280:26: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement656);
                    	    markup91=markup();

                    	    state._fsp--;

                    	    adaptor.addChild(root_1, markup91.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt24 >= 1 ) break loop24;
                                EarlyExitException eee =
                                    new EarlyExitException(24, input);
                                throw eee;
                        }
                        cnt24++;
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement659);
                    embedding92=embedding();

                    state._fsp--;

                    adaptor.addChild(root_1, embedding92.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 13 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:281:6: ^( MARKUPS ( markup )+ )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUPS93=(CommonTree)match(input,MARKUPS,FOLLOW_MARKUPS_in_statement670); 
                    MARKUPS93_tree = (CommonTree)adaptor.dupNode(MARKUPS93);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUPS93_tree, root_1);



                    match(input, Token.DOWN, null); 
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:281:17: ( markup )+
                    int cnt25=0;
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==MARKUP) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:281:17: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement672);
                    	    markup94=markup();

                    	    state._fsp--;

                    	    adaptor.addChild(root_1, markup94.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt25 >= 1 ) break loop25;
                                EarlyExitException eee =
                                    new EarlyExitException(25, input);
                                throw eee;
                        }
                        cnt25++;
                    } while (true);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;

            }
            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:283:1: eachStatement : ^( 'each' '(' IDCON ':' expression ')' statement ) ;
    public final WaebricChecker.eachStatement_return eachStatement() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.eachStatement_return retval = new WaebricChecker.eachStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal95=null;
        CommonTree char_literal96=null;
        CommonTree IDCON97=null;
        CommonTree char_literal98=null;
        CommonTree char_literal100=null;
        WaebricChecker.expression_return expression99 = null;

        WaebricChecker.statement_return statement101 = null;


        CommonTree string_literal95_tree=null;
        CommonTree char_literal96_tree=null;
        CommonTree IDCON97_tree=null;
        CommonTree char_literal98_tree=null;
        CommonTree char_literal100_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new ArrayList<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:288:4: ( ^( 'each' '(' IDCON ':' expression ')' statement ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:288:7: ^( 'each' '(' IDCON ':' expression ')' statement )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal95=(CommonTree)match(input,61,FOLLOW_61_in_eachStatement699); 
            string_literal95_tree = (CommonTree)adaptor.dupNode(string_literal95);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal95_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            char_literal96=(CommonTree)match(input,49,FOLLOW_49_in_eachStatement701); 
            char_literal96_tree = (CommonTree)adaptor.dupNode(char_literal96);

            adaptor.addChild(root_1, char_literal96_tree);

            _last = (CommonTree)input.LT(1);
            IDCON97=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_eachStatement703); 
            IDCON97_tree = (CommonTree)adaptor.dupNode(IDCON97);

            adaptor.addChild(root_1, IDCON97_tree);

            _last = (CommonTree)input.LT(1);
            char_literal98=(CommonTree)match(input,44,FOLLOW_44_in_eachStatement705); 
            char_literal98_tree = (CommonTree)adaptor.dupNode(char_literal98);

            adaptor.addChild(root_1, char_literal98_tree);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_eachStatement707);
            expression99=expression();

            state._fsp--;

            adaptor.addChild(root_1, expression99.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal100=(CommonTree)match(input,51,FOLLOW_51_in_eachStatement709); 
            char_literal100_tree = (CommonTree)adaptor.dupNode(char_literal100);

            adaptor.addChild(root_1, char_literal100_tree);

             
            				defineVariable(IDCON97.getText()); // Define variable before statement is executed
            			
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_eachStatement713);
            statement101=statement();

            state._fsp--;

            adaptor.addChild(root_1, statement101.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:292:1: letStatement : ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) ;
    public final WaebricChecker.letStatement_return letStatement() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.letStatement_return retval = new WaebricChecker.letStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal102=null;
        CommonTree string_literal104=null;
        CommonTree string_literal106=null;
        WaebricChecker.assignment_return assignment103 = null;

        WaebricChecker.statement_return statement105 = null;


        CommonTree string_literal102_tree=null;
        CommonTree string_literal104_tree=null;
        CommonTree string_literal106_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new ArrayList<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:297:4: ( ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:297:7: ^( 'let' ( assignment )+ 'in' ( statement )* 'end' )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal102=(CommonTree)match(input,62,FOLLOW_62_in_letStatement739); 
            string_literal102_tree = (CommonTree)adaptor.dupNode(string_literal102);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal102_tree, root_1);



            match(input, Token.DOWN, null); 
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:297:16: ( assignment )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==IDCON||LA27_0==58) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:297:16: assignment
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_assignment_in_letStatement741);
            	    assignment103=assignment();

            	    state._fsp--;

            	    adaptor.addChild(root_1, assignment103.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt27 >= 1 ) break loop27;
                        EarlyExitException eee =
                            new EarlyExitException(27, input);
                        throw eee;
                }
                cnt27++;
            } while (true);

            _last = (CommonTree)input.LT(1);
            string_literal104=(CommonTree)match(input,63,FOLLOW_63_in_letStatement744); 
            string_literal104_tree = (CommonTree)adaptor.dupNode(string_literal104);

            adaptor.addChild(root_1, string_literal104_tree);

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:297:33: ( statement )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=MARKUPS && LA28_0<=MARKUP_EMBEDDING)||LA28_0==COMMENT||LA28_0==55||LA28_0==59||(LA28_0>=61 && LA28_0<=62)||(LA28_0>=64 && LA28_0<=66)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:297:33: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_letStatement746);
            	    statement105=statement();

            	    state._fsp--;

            	    adaptor.addChild(root_1, statement105.getTree());

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            string_literal106=(CommonTree)match(input,END,FOLLOW_END_in_letStatement749); 
            string_literal106_tree = (CommonTree)adaptor.dupNode(string_literal106);

            adaptor.addChild(root_1, string_literal106_tree);


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:299:1: assignment : ( IDCON '=' expression ';' | funcBinding );
    public final WaebricChecker.assignment_return assignment() throws RecognitionException {
        WaebricChecker.assignment_return retval = new WaebricChecker.assignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON107=null;
        CommonTree char_literal108=null;
        CommonTree char_literal110=null;
        WaebricChecker.expression_return expression109 = null;

        WaebricChecker.funcBinding_return funcBinding111 = null;


        CommonTree IDCON107_tree=null;
        CommonTree char_literal108_tree=null;
        CommonTree char_literal110_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:299:11: ( IDCON '=' expression ';' | funcBinding )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==IDCON) ) {
                alt29=1;
            }
            else if ( (LA29_0==58) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:299:14: IDCON '=' expression ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDCON107=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_assignment760); 
                    IDCON107_tree = (CommonTree)adaptor.dupNode(IDCON107);

                    adaptor.addChild(root_0, IDCON107_tree);

                    _last = (CommonTree)input.LT(1);
                    char_literal108=(CommonTree)match(input,52,FOLLOW_52_in_assignment762); 
                    char_literal108_tree = (CommonTree)adaptor.dupNode(char_literal108);

                    adaptor.addChild(root_0, char_literal108_tree);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_assignment764);
                    expression109=expression();

                    state._fsp--;

                    adaptor.addChild(root_0, expression109.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal110=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_assignment766); 
                    char_literal110_tree = (CommonTree)adaptor.dupNode(char_literal110);

                    adaptor.addChild(root_0, char_literal110_tree);

                     
                    				defineVariable(IDCON107.getText()); 
                    			

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:301:8: funcBinding
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_funcBinding_in_assignment772);
                    funcBinding111=funcBinding();

                    state._fsp--;

                    adaptor.addChild(root_0, funcBinding111.getTree());

                    }
                    break;

            }
            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:303:1: funcBinding : ^( 'def' id= IDCON f= formals statement ) ;
    public final WaebricChecker.funcBinding_return funcBinding() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.funcBinding_return retval = new WaebricChecker.funcBinding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        CommonTree string_literal112=null;
        WaebricChecker.formals_return f = null;

        WaebricChecker.statement_return statement113 = null;


        CommonTree id_tree=null;
        CommonTree string_literal112_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new ArrayList<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:308:4: ( ^( 'def' id= IDCON f= formals statement ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:308:8: ^( 'def' id= IDCON f= formals statement )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal112=(CommonTree)match(input,58,FOLLOW_58_in_funcBinding801); 
            string_literal112_tree = (CommonTree)adaptor.dupNode(string_literal112);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal112_tree, root_1);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_funcBinding805); 
            id_tree = (CommonTree)adaptor.dupNode(id);

            adaptor.addChild(root_1, id_tree);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_formals_in_funcBinding809);
            f=formals();

            state._fsp--;

            adaptor.addChild(root_1, f.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_funcBinding811);
            statement113=statement();

            state._fsp--;

            adaptor.addChild(root_1, statement113.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:317:1: predicate : ( '!' )* expression ( '.' type '?' )? ( '&&' predicate | '||' predicate )* ;
    public final WaebricChecker.predicate_return predicate() throws RecognitionException {
        WaebricChecker.predicate_return retval = new WaebricChecker.predicate_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal114=null;
        CommonTree char_literal116=null;
        CommonTree char_literal118=null;
        CommonTree string_literal119=null;
        CommonTree string_literal121=null;
        WaebricChecker.expression_return expression115 = null;

        WaebricChecker.type_return type117 = null;

        WaebricChecker.predicate_return predicate120 = null;

        WaebricChecker.predicate_return predicate122 = null;


        CommonTree char_literal114_tree=null;
        CommonTree char_literal116_tree=null;
        CommonTree char_literal118_tree=null;
        CommonTree string_literal119_tree=null;
        CommonTree string_literal121_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:317:10: ( ( '!' )* expression ( '.' type '?' )? ( '&&' predicate | '||' predicate )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:317:13: ( '!' )* expression ( '.' type '?' )? ( '&&' predicate | '||' predicate )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:317:13: ( '!' )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==67) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:317:13: '!'
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal114=(CommonTree)match(input,67,FOLLOW_67_in_predicate835); 
            	    char_literal114_tree = (CommonTree)adaptor.dupNode(char_literal114);

            	    adaptor.addChild(root_0, char_literal114_tree);


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_predicate838);
            expression115=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression115.getTree());
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:317:29: ( '.' type '?' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==42) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:317:31: '.' type '?'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal116=(CommonTree)match(input,42,FOLLOW_42_in_predicate842); 
                    char_literal116_tree = (CommonTree)adaptor.dupNode(char_literal116);

                    adaptor.addChild(root_0, char_literal116_tree);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_predicate844);
                    type117=type();

                    state._fsp--;

                    adaptor.addChild(root_0, type117.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal118=(CommonTree)match(input,68,FOLLOW_68_in_predicate846); 
                    char_literal118_tree = (CommonTree)adaptor.dupNode(char_literal118);

                    adaptor.addChild(root_0, char_literal118_tree);


                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:318:4: ( '&&' predicate | '||' predicate )*
            loop32:
            do {
                int alt32=3;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==69) ) {
                    alt32=1;
                }
                else if ( (LA32_0==70) ) {
                    alt32=2;
                }


                switch (alt32) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:318:6: '&&' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal119=(CommonTree)match(input,69,FOLLOW_69_in_predicate856); 
            	    string_literal119_tree = (CommonTree)adaptor.dupNode(string_literal119);

            	    adaptor.addChild(root_0, string_literal119_tree);

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate858);
            	    predicate120=predicate();

            	    state._fsp--;

            	    adaptor.addChild(root_0, predicate120.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:318:23: '||' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal121=(CommonTree)match(input,70,FOLLOW_70_in_predicate862); 
            	    string_literal121_tree = (CommonTree)adaptor.dupNode(string_literal121);

            	    adaptor.addChild(root_0, string_literal121_tree);

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate864);
            	    predicate122=predicate();

            	    state._fsp--;

            	    adaptor.addChild(root_0, predicate122.getTree());

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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

        CommonTree set123=null;

        CommonTree set123_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:320:5: ( 'list' | 'record' | 'string' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            set123=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=71 && input.LA(1)<=73) ) {
                input.consume();

                set123_tree = (CommonTree)adaptor.dupNode(set123);

                adaptor.addChild(root_0, set123_tree);

                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

             

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:325:1: embedding : PRETEXT embed textTail ;
    public final WaebricChecker.embedding_return embedding() throws RecognitionException {
        WaebricChecker.embedding_return retval = new WaebricChecker.embedding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PRETEXT124=null;
        WaebricChecker.embed_return embed125 = null;

        WaebricChecker.textTail_return textTail126 = null;


        CommonTree PRETEXT124_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:325:10: ( PRETEXT embed textTail )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:325:13: PRETEXT embed textTail
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PRETEXT124=(CommonTree)match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding900); 
            PRETEXT124_tree = (CommonTree)adaptor.dupNode(PRETEXT124);

            adaptor.addChild(root_0, PRETEXT124_tree);

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_embed_in_embedding902);
            embed125=embed();

            state._fsp--;

            adaptor.addChild(root_0, embed125.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_textTail_in_embedding904);
            textTail126=textTail();

            state._fsp--;

            adaptor.addChild(root_0, textTail126.getTree());

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:326:1: embed : ( ^( MARKUPS ( markup )+ ) | ^( MARKUP_EXPRESSION ( markup )* expression ) );
    public final WaebricChecker.embed_return embed() throws RecognitionException {
        WaebricChecker.embed_return retval = new WaebricChecker.embed_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MARKUPS127=null;
        CommonTree MARKUP_EXPRESSION129=null;
        WaebricChecker.markup_return markup128 = null;

        WaebricChecker.markup_return markup130 = null;

        WaebricChecker.expression_return expression131 = null;


        CommonTree MARKUPS127_tree=null;
        CommonTree MARKUP_EXPRESSION129_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:326:6: ( ^( MARKUPS ( markup )+ ) | ^( MARKUP_EXPRESSION ( markup )* expression ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==MARKUPS) ) {
                alt35=1;
            }
            else if ( (LA35_0==MARKUP_EXPRESSION) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:326:10: ^( MARKUPS ( markup )+ )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUPS127=(CommonTree)match(input,MARKUPS,FOLLOW_MARKUPS_in_embed915); 
                    MARKUPS127_tree = (CommonTree)adaptor.dupNode(MARKUPS127);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUPS127_tree, root_1);



                    match(input, Token.DOWN, null); 
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:326:21: ( markup )+
                    int cnt33=0;
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==MARKUP) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:326:21: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed917);
                    	    markup128=markup();

                    	    state._fsp--;

                    	    adaptor.addChild(root_1, markup128.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt33 >= 1 ) break loop33;
                                EarlyExitException eee =
                                    new EarlyExitException(33, input);
                                throw eee;
                        }
                        cnt33++;
                    } while (true);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:326:33: ^( MARKUP_EXPRESSION ( markup )* expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_EXPRESSION129=(CommonTree)match(input,MARKUP_EXPRESSION,FOLLOW_MARKUP_EXPRESSION_in_embed926); 
                    MARKUP_EXPRESSION129_tree = (CommonTree)adaptor.dupNode(MARKUP_EXPRESSION129);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_EXPRESSION129_tree, root_1);



                    match(input, Token.DOWN, null); 
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:326:54: ( markup )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==MARKUP) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:326:54: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed928);
                    	    markup130=markup();

                    	    state._fsp--;

                    	    adaptor.addChild(root_1, markup130.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_embed931);
                    expression131=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, expression131.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;

            }
            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:327:1: textTail : ( POSTTEXT | MIDTEXT embed textTail );
    public final WaebricChecker.textTail_return textTail() throws RecognitionException {
        WaebricChecker.textTail_return retval = new WaebricChecker.textTail_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POSTTEXT132=null;
        CommonTree MIDTEXT133=null;
        WaebricChecker.embed_return embed134 = null;

        WaebricChecker.textTail_return textTail135 = null;


        CommonTree POSTTEXT132_tree=null;
        CommonTree MIDTEXT133_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:327:9: ( POSTTEXT | MIDTEXT embed textTail )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==POSTTEXT) ) {
                alt36=1;
            }
            else if ( (LA36_0==MIDTEXT) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:327:12: POSTTEXT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    POSTTEXT132=(CommonTree)match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail941); 
                    POSTTEXT132_tree = (CommonTree)adaptor.dupNode(POSTTEXT132);

                    adaptor.addChild(root_0, POSTTEXT132_tree);


                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:327:23: MIDTEXT embed textTail
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    MIDTEXT133=(CommonTree)match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail945); 
                    MIDTEXT133_tree = (CommonTree)adaptor.dupNode(MIDTEXT133);

                    adaptor.addChild(root_0, MIDTEXT133_tree);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embed_in_textTail947);
                    embed134=embed();

                    state._fsp--;

                    adaptor.addChild(root_0, embed134.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_textTail_in_textTail949);
                    textTail135=textTail();

                    state._fsp--;

                    adaptor.addChild(root_0, textTail135.getTree());

                    }
                    break;

            }
            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

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

    // Delegated rules


    protected DFA26 dfa26 = new DFA26(this);
    static final String DFA26_eotS =
        "\20\uffff";
    static final String DFA26_eofS =
        "\20\uffff";
    static final String DFA26_minS =
        "\1\7\5\uffff\1\2\6\uffff\1\14\2\uffff";
    static final String DFA26_maxS =
        "\1\102\5\uffff\1\2\6\uffff\1\67\2\uffff";
    static final String DFA26_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\11\1\12\1\13\1\14\1"+
        "\15\1\uffff\1\6\1\7";
    static final String DFA26_specialS =
        "\20\uffff}>";
    static final String[] DFA26_transitionS = {
            "\1\14\1\12\1\11\1\13\12\uffff\1\5\41\uffff\1\4\3\uffff\1\1\1"+
            "\uffff\1\2\1\3\1\uffff\1\10\1\6\1\7",
            "",
            "",
            "",
            "",
            "",
            "\1\15",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\16\1\uffff\3\16\1\uffff\1\17\42\uffff\1\16\1\uffff\1\16",
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
            return "269:1: statement : ( ^( 'if' predicate statement ( 'else' statement )? ) | ^( 'each' '(' IDCON ':' expression ')' statement ) | ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ) | ^( 'echo' expression ) | ^( 'echo' embedding ) | ^( 'cdata' expression ) | 'yield' | ^( MARKUP_EXPRESSION ( markup )+ expression ) | ^( MARKUP_STATEMENT ( markup )+ statement ) | ^( MARKUP_EMBEDDING ( markup )+ embedding ) | ^( MARKUPS ( markup )+ ) );";
        }
    }
 

    public static final BitSet FOLLOW_41_in_module77 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_moduleId_in_module79 = new BitSet(new long[]{0x0400080000400008L});
    public static final BitSet FOLLOW_imprt_in_module81 = new BitSet(new long[]{0x0400080000400008L});
    public static final BitSet FOLLOW_site_in_module84 = new BitSet(new long[]{0x0400000000400008L});
    public static final BitSet FOLLOW_function_in_module87 = new BitSet(new long[]{0x0400000000000008L});
    public static final BitSet FOLLOW_IDCON_in_moduleId117 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_moduleId127 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_IDCON_in_moduleId131 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_43_in_imprt152 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_moduleId_in_imprt154 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_module_in_imprt156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SITE_in_site169 = new BitSet(new long[]{0x0000000001802000L});
    public static final BitSet FOLLOW_mappings_in_site171 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_END_in_site173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapping_in_mappings181 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_mappings186 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_mapping_in_mappings188 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_PATH_in_mapping200 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_mapping202 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_markup_in_mapping204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUP_in_markup219 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_markup221 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x00000000000003FFL});
    public static final BitSet FOLLOW_arguments_in_markup225 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARGUMENTS_in_arguments247 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_argument_in_arguments251 = new BitSet(new long[]{0x00A000000001D008L});
    public static final BitSet FOLLOW_expression_in_argument270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_argument274 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_argument276 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_argument278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_expression295 = new BitSet(new long[]{0x0200040000000002L});
    public static final BitSet FOLLOW_NATCON_in_expression306 = new BitSet(new long[]{0x0200040000000002L});
    public static final BitSet FOLLOW_TEXT_in_expression310 = new BitSet(new long[]{0x0200040000000002L});
    public static final BitSet FOLLOW_SYMBOLCON_in_expression314 = new BitSet(new long[]{0x0200040000000002L});
    public static final BitSet FOLLOW_53_in_expression323 = new BitSet(new long[]{0x00E400000001D000L});
    public static final BitSet FOLLOW_expression_in_expression325 = new BitSet(new long[]{0x0044000000000000L});
    public static final BitSet FOLLOW_50_in_expression330 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_expression332 = new BitSet(new long[]{0x0044000000000000L});
    public static final BitSet FOLLOW_54_in_expression337 = new BitSet(new long[]{0x0200040000000002L});
    public static final BitSet FOLLOW_55_in_expression346 = new BitSet(new long[]{0x0104000000001000L});
    public static final BitSet FOLLOW_keyValuePair_in_expression348 = new BitSet(new long[]{0x0104000000000000L});
    public static final BitSet FOLLOW_50_in_expression353 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_keyValuePair_in_expression355 = new BitSet(new long[]{0x0104000000000000L});
    public static final BitSet FOLLOW_56_in_expression360 = new BitSet(new long[]{0x0200040000000002L});
    public static final BitSet FOLLOW_57_in_expression370 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_expression372 = new BitSet(new long[]{0x0200040000000002L});
    public static final BitSet FOLLOW_42_in_expression376 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_IDCON_in_expression378 = new BitSet(new long[]{0x0200040000000002L});
    public static final BitSet FOLLOW_IDCON_in_keyValuePair390 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_keyValuePair392 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_keyValuePair394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_function420 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_function422 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_formals_in_function424 = new BitSet(new long[]{0x6880000000200788L,0x0000000000000007L});
    public static final BitSet FOLLOW_statement_in_function426 = new BitSet(new long[]{0x6880000000200788L,0x0000000000000007L});
    public static final BitSet FOLLOW_FORMALS_in_formals454 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_formals458 = new BitSet(new long[]{0x0000000000001008L});
    public static final BitSet FOLLOW_59_in_statement478 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_predicate_in_statement480 = new BitSet(new long[]{0x6880000000200780L,0x0000000000000007L});
    public static final BitSet FOLLOW_statement_in_statement482 = new BitSet(new long[]{0x1000000000000008L});
    public static final BitSet FOLLOW_60_in_statement486 = new BitSet(new long[]{0x6880000000200780L,0x0000000000000007L});
    public static final BitSet FOLLOW_statement_in_statement488 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_61_in_statement503 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_49_in_statement505 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_IDCON_in_statement507 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_statement509 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_statement511 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_statement513 = new BitSet(new long[]{0x6880000000200780L,0x0000000000000007L});
    public static final BitSet FOLLOW_statement_in_statement515 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_62_in_statement526 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_assignment_in_statement528 = new BitSet(new long[]{0x8400000000001000L});
    public static final BitSet FOLLOW_63_in_statement531 = new BitSet(new long[]{0x6880000000A00780L,0x0000000000000007L});
    public static final BitSet FOLLOW_statement_in_statement533 = new BitSet(new long[]{0x6880000000A00780L,0x0000000000000007L});
    public static final BitSet FOLLOW_END_in_statement536 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_55_in_statement547 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statement549 = new BitSet(new long[]{0x6980000000200780L,0x0000000000000007L});
    public static final BitSet FOLLOW_56_in_statement552 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COMMENT_in_statement563 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRCON_in_statement565 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_65_in_statement576 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement578 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_65_in_statement589 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_statement591 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_66_in_statement602 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement604 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_64_in_statement613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUP_EXPRESSION_in_statement622 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement624 = new BitSet(new long[]{0x00A000000001D040L});
    public static final BitSet FOLLOW_expression_in_statement627 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement638 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement640 = new BitSet(new long[]{0x68800000002007C0L,0x0000000000000007L});
    public static final BitSet FOLLOW_statement_in_statement643 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_EMBEDDING_in_statement654 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement656 = new BitSet(new long[]{0x0000000000040040L});
    public static final BitSet FOLLOW_embedding_in_statement659 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUPS_in_statement670 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement672 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_61_in_eachStatement699 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_49_in_eachStatement701 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_IDCON_in_eachStatement703 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_eachStatement705 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_eachStatement707 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_eachStatement709 = new BitSet(new long[]{0x6880000000200780L,0x0000000000000007L});
    public static final BitSet FOLLOW_statement_in_eachStatement713 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_62_in_letStatement739 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_assignment_in_letStatement741 = new BitSet(new long[]{0x8400000000001000L});
    public static final BitSet FOLLOW_63_in_letStatement744 = new BitSet(new long[]{0x6880000000A00780L,0x0000000000000007L});
    public static final BitSet FOLLOW_statement_in_letStatement746 = new BitSet(new long[]{0x6880000000A00780L,0x0000000000000007L});
    public static final BitSet FOLLOW_END_in_letStatement749 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDCON_in_assignment760 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_assignment762 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_assignment764 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_assignment766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funcBinding_in_assignment772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_funcBinding801 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_funcBinding805 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_formals_in_funcBinding809 = new BitSet(new long[]{0x6880000000200780L,0x0000000000000007L});
    public static final BitSet FOLLOW_statement_in_funcBinding811 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_predicate835 = new BitSet(new long[]{0x00A000000001D000L,0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_predicate838 = new BitSet(new long[]{0x0000040000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_42_in_predicate842 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000380L});
    public static final BitSet FOLLOW_type_in_predicate844 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_predicate846 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_69_in_predicate856 = new BitSet(new long[]{0x00A000000001D000L,0x0000000000000008L});
    public static final BitSet FOLLOW_predicate_in_predicate858 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_70_in_predicate862 = new BitSet(new long[]{0x00A000000001D000L,0x0000000000000008L});
    public static final BitSet FOLLOW_predicate_in_predicate864 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding900 = new BitSet(new long[]{0x0000000000000280L});
    public static final BitSet FOLLOW_embed_in_embedding902 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_textTail_in_embedding904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUPS_in_embed915 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_embed917 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_MARKUP_EXPRESSION_in_embed926 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_embed928 = new BitSet(new long[]{0x00A000000001D040L});
    public static final BitSet FOLLOW_expression_in_embed931 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail945 = new BitSet(new long[]{0x0000000000000280L});
    public static final BitSet FOLLOW_embed_in_textTail947 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_textTail_in_textTail949 = new BitSet(new long[]{0x0000000000000002L});

}