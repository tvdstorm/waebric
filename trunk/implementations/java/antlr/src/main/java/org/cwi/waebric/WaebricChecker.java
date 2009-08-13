// $ANTLR 3.1.2 /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g 2009-08-13 12:05:32

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
    public static final int T__64=64;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int LETTER=17;
    public static final int AMP=27;
    public static final int ESCLAYOUT=23;
    public static final int PATHELEMENT=20;
    public static final int PRETEXT=10;
    public static final int STRCON=9;
    public static final int TEXTCHAR=25;
    public static final int T__61=61;
    public static final int POSTTEXT=11;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int FILEEXT=21;
    public static final int T__52=52;
    public static final int COMMENTS=31;
    public static final int CHARREF=28;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int IDCON=4;
    public static final int PATH=5;
    public static final int T__59=59;
    public static final int STRCHAR=22;
    public static final int DIGIT=18;
    public static final int COMMENT=13;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int MIDTEXT=12;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int SYMBOLCON=8;
    public static final int SITE=14;
    public static final int HEXADECIMAL=19;
    public static final int SEMICOLON=16;
    public static final int SYMBOLCHAR=30;
    public static final int TEXT=7;
    public static final int LAYOUT=32;
    public static final int NATCON=6;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int DECIMAL=24;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int ENTREF=29;
    public static final int ESCQUOTE=26;
    public static final int END=15;

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
    public String getGrammarFileName() { return "/ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g"; }


    	List<SemanticException> exceptions;
    	public List<SemanticException> checkAST() throws RecognitionException {
    		exceptions = new ArrayList<SemanticException>();
    		module(); // Start checking
    		
    		// Process calls after retrieving all function definitions
    		for(Call call: calls) {
    			// Restore call environment
    			Stack actual = Environment_stack;
    			Environment_stack = call.env;
    			
    			if(isDefinedFunction(call.id.getText())) {
    				int args = getFunctionArgs(call.id.getText());
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
    		if(isDefinedFunction(id.getText())) {
    			exceptions.add(new DuplicateFunctionException(id));
    		} else { ((Environment_scope)Environment_stack.elementAt(depth)).functions.put(id.getText(), args); }
    	}

    	/**
    	 * Check if a function is defined
    	 * @param name: Function name
    	 */
    	boolean isDefinedFunction(String name) {
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
    	int getFunctionArgs(String name) {
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:203:1: module : ^( 'module' moduleId ( imprt )* ( site )* ( function )* ) ;
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:208:4: ( ^( 'module' moduleId ( imprt )* ( site )* ( function )* ) )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:208:7: ^( 'module' moduleId ( imprt )* ( site )* ( function )* )
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:208:28: ( imprt )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==35) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: imprt
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

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:208:35: ( site )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==SITE) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: site
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

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:208:41: ( function )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==49) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: function
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:210:1: moduleId : id= IDCON ( '.' id= IDCON )* ;
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:213:2: (id= IDCON ( '.' id= IDCON )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:213:5: id= IDCON ( '.' id= IDCON )*
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:214:4: ( '.' id= IDCON )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==34) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:214:6: '.' id= IDCON
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:223:1: imprt : 'import' moduleId ';' module ;
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:223:6: ( 'import' moduleId ';' module )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:223:10: 'import' moduleId ';' module
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:227:1: site : 'site' mappings 'end' ;
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:227:5: ( 'site' mappings 'end' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:227:9: 'site' mappings 'end'
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:228:1: mappings : ( mapping )? ( ';' mapping )* ;
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:228:9: ( ( mapping )? ( ';' mapping )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:228:12: ( mapping )? ( ';' mapping )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:228:12: ( mapping )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==PATH) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: mapping
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

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:228:21: ( ';' mapping )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==SEMICOLON) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:228:23: ';' mapping
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:229:1: mapping : PATH ':' markup ;
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:229:9: ( PATH ':' markup )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:229:12: PATH ':' markup
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:233:1: markup : designator ( arguments )? ;
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:235:2: ( designator ( arguments )? )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:235:5: designator ( arguments )?
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_designator_in_markup225);
            designator20=designator();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, designator20.getTree());
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:235:16: ( arguments )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==41) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:235:18: arguments
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:244:1: designator : IDCON ( attribute )* ;
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:244:11: ( IDCON ( attribute )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:244:14: IDCON ( attribute )*
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON22=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_designator248); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON22_tree = (CommonTree)adaptor.dupNode(IDCON22);

            adaptor.addChild(root_0, IDCON22_tree);
            }
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:244:20: ( attribute )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==34||(LA8_0>=36 && LA8_0<=39)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: attribute
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:246:1: attribute : ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON ( '%' NATCON )? );
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:246:10: ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON ( '%' NATCON )? )
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:246:13: '#' IDCON
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:247:6: '.' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal26=(CommonTree)match(input,34,FOLLOW_34_in_attribute270); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal26_tree = (CommonTree)adaptor.dupNode(char_literal26);

                    adaptor.addChild(root_0, char_literal26_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON27=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute272); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON27_tree = (CommonTree)adaptor.dupNode(IDCON27);

                    adaptor.addChild(root_0, IDCON27_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:248:6: '$' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal28=(CommonTree)match(input,38,FOLLOW_38_in_attribute280); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal28_tree = (CommonTree)adaptor.dupNode(char_literal28);

                    adaptor.addChild(root_0, char_literal28_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON29=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute282); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON29_tree = (CommonTree)adaptor.dupNode(IDCON29);

                    adaptor.addChild(root_0, IDCON29_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:249:6: ':' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal30=(CommonTree)match(input,36,FOLLOW_36_in_attribute290); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal30_tree = (CommonTree)adaptor.dupNode(char_literal30);

                    adaptor.addChild(root_0, char_literal30_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON31=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute292); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON31_tree = (CommonTree)adaptor.dupNode(IDCON31);

                    adaptor.addChild(root_0, IDCON31_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:250:6: '@' NATCON ( '%' NATCON )?
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal32=(CommonTree)match(input,39,FOLLOW_39_in_attribute300); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal32_tree = (CommonTree)adaptor.dupNode(char_literal32);

                    adaptor.addChild(root_0, char_literal32_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    NATCON33=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_attribute302); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON33_tree = (CommonTree)adaptor.dupNode(NATCON33);

                    adaptor.addChild(root_0, NATCON33_tree);
                    }
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:250:17: ( '%' NATCON )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==40) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:250:19: '%' NATCON
                            {
                            _last = (CommonTree)input.LT(1);
                            char_literal34=(CommonTree)match(input,40,FOLLOW_40_in_attribute306); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal34_tree = (CommonTree)adaptor.dupNode(char_literal34);

                            adaptor.addChild(root_0, char_literal34_tree);
                            }
                            _last = (CommonTree)input.LT(1);
                            NATCON35=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_attribute308); if (state.failed) return retval;
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:252:1: arguments returns [int args = 0] : '(' ( expression )? ( ',' expression )* ')' ;
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:253:2: ( '(' ( expression )? ( ',' expression )* ')' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:253:5: '(' ( expression )? ( ',' expression )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            char_literal36=(CommonTree)match(input,41,FOLLOW_41_in_arguments326); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal36_tree = (CommonTree)adaptor.dupNode(char_literal36);

            adaptor.addChild(root_0, char_literal36_tree);
            }
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:253:9: ( expression )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==IDCON||(LA11_0>=NATCON && LA11_0<=SYMBOLCON)||LA11_0==44||LA11_0==46) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:253:11: expression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_arguments330);
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

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:254:4: ( ',' expression )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==42) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:254:6: ',' expression
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal38=(CommonTree)match(input,42,FOLLOW_42_in_arguments343); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal38_tree = (CommonTree)adaptor.dupNode(char_literal38);

            	    adaptor.addChild(root_0, char_literal38_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expression_in_arguments345);
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
            char_literal40=(CommonTree)match(input,43,FOLLOW_43_in_arguments352); if (state.failed) return retval;
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:260:1: expression : ( varExpression | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* ;
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:260:11: ( ( varExpression | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:260:14: ( varExpression | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:260:14: ( varExpression | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' )
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:260:16: varExpression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_varExpression_in_expression367);
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:260:32: NATCON
                    {
                    _last = (CommonTree)input.LT(1);
                    NATCON42=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_expression371); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON42_tree = (CommonTree)adaptor.dupNode(NATCON42);

                    adaptor.addChild(root_0, NATCON42_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:260:41: TEXT
                    {
                    _last = (CommonTree)input.LT(1);
                    TEXT43=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_expression375); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TEXT43_tree = (CommonTree)adaptor.dupNode(TEXT43);

                    adaptor.addChild(root_0, TEXT43_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:260:48: SYMBOLCON
                    {
                    _last = (CommonTree)input.LT(1);
                    SYMBOLCON44=(CommonTree)match(input,SYMBOLCON,FOLLOW_SYMBOLCON_in_expression379); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SYMBOLCON44_tree = (CommonTree)adaptor.dupNode(SYMBOLCON44);

                    adaptor.addChild(root_0, SYMBOLCON44_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:261:7: '[' ( expression )? ( ',' expression )* ']'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal45=(CommonTree)match(input,44,FOLLOW_44_in_expression388); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal45_tree = (CommonTree)adaptor.dupNode(char_literal45);

                    adaptor.addChild(root_0, char_literal45_tree);
                    }
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:261:11: ( expression )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==IDCON||(LA13_0>=NATCON && LA13_0<=SYMBOLCON)||LA13_0==44||LA13_0==46) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: expression
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_expression_in_expression390);
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

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:261:23: ( ',' expression )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==42) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:261:25: ',' expression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal47=(CommonTree)match(input,42,FOLLOW_42_in_expression395); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal47_tree = (CommonTree)adaptor.dupNode(char_literal47);

                    	    adaptor.addChild(root_0, char_literal47_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_expression_in_expression397);
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
                    char_literal49=(CommonTree)match(input,45,FOLLOW_45_in_expression402); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal49_tree = (CommonTree)adaptor.dupNode(char_literal49);

                    adaptor.addChild(root_0, char_literal49_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:262:7: '{' ( keyValuePair )? ( ',' keyValuePair )* '}'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal50=(CommonTree)match(input,46,FOLLOW_46_in_expression411); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal50_tree = (CommonTree)adaptor.dupNode(char_literal50);

                    adaptor.addChild(root_0, char_literal50_tree);
                    }
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:262:11: ( keyValuePair )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==IDCON) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: keyValuePair
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_keyValuePair_in_expression413);
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

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:262:25: ( ',' keyValuePair )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==42) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:262:27: ',' keyValuePair
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal52=(CommonTree)match(input,42,FOLLOW_42_in_expression418); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal52_tree = (CommonTree)adaptor.dupNode(char_literal52);

                    	    adaptor.addChild(root_0, char_literal52_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_keyValuePair_in_expression420);
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
                    char_literal54=(CommonTree)match(input,47,FOLLOW_47_in_expression425); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal54_tree = (CommonTree)adaptor.dupNode(char_literal54);

                    adaptor.addChild(root_0, char_literal54_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:263:6: ( '+' expression | '.' IDCON )*
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
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:263:8: '+' expression
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal55=(CommonTree)match(input,48,FOLLOW_48_in_expression435); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal55_tree = (CommonTree)adaptor.dupNode(char_literal55);

            	    adaptor.addChild(root_0, char_literal55_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expression_in_expression437);
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
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:263:25: '.' IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal57=(CommonTree)match(input,34,FOLLOW_34_in_expression441); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal57_tree = (CommonTree)adaptor.dupNode(char_literal57);

            	    adaptor.addChild(root_0, char_literal57_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    IDCON58=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression443); if (state.failed) return retval;
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:265:1: varExpression : IDCON ;
    public final WaebricChecker.varExpression_return varExpression() throws RecognitionException {
        WaebricChecker.varExpression_return retval = new WaebricChecker.varExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON59=null;

        CommonTree IDCON59_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:265:14: ( IDCON )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:265:17: IDCON
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON59=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_varExpression455); if (state.failed) return retval;
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:271:1: keyValuePair : IDCON ':' expression ;
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:271:13: ( IDCON ':' expression )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:271:16: IDCON ':' expression
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON60=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_keyValuePair469); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON60_tree = (CommonTree)adaptor.dupNode(IDCON60);

            adaptor.addChild(root_0, IDCON60_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal61=(CommonTree)match(input,36,FOLLOW_36_in_keyValuePair471); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal61_tree = (CommonTree)adaptor.dupNode(char_literal61);

            adaptor.addChild(root_0, char_literal61_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_keyValuePair473);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:275:1: function : 'def' IDCON formals ( statement )* 'end' ;
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:280:4: ( 'def' IDCON formals ( statement )* 'end' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:280:7: 'def' IDCON formals ( statement )* 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal63=(CommonTree)match(input,49,FOLLOW_49_in_function497); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal63_tree = (CommonTree)adaptor.dupNode(string_literal63);

            adaptor.addChild(root_0, string_literal63_tree);
            }
            _last = (CommonTree)input.LT(1);
            IDCON64=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_function499); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON64_tree = (CommonTree)adaptor.dupNode(IDCON64);

            adaptor.addChild(root_0, IDCON64_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_formals_in_function501);
            formals65=formals();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, formals65.getTree());
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:280:27: ( statement )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==IDCON||LA19_0==COMMENT||LA19_0==46||LA19_0==50||(LA19_0>=52 && LA19_0<=53)||(LA19_0>=55 && LA19_0<=57)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_function503);
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
            string_literal67=(CommonTree)match(input,END,FOLLOW_END_in_function506); if (state.failed) return retval;
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:284:1: formals returns [int args = 0] : ( regularFormals | );
    public final WaebricChecker.formals_return formals() throws RecognitionException {
        WaebricChecker.formals_return retval = new WaebricChecker.formals_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricChecker.regularFormals_return regularFormals68 = null;



        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:284:32: ( regularFormals | )
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:285:4: regularFormals
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_regularFormals_in_formals527);
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:285:55: 
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:287:1: regularFormals returns [int args = 0] : '(' ( IDCON )* ')' ;
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:287:38: ( '(' ( IDCON )* ')' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:288:4: '(' ( IDCON )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            char_literal69=(CommonTree)match(input,41,FOLLOW_41_in_regularFormals549); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal69_tree = (CommonTree)adaptor.dupNode(char_literal69);

            adaptor.addChild(root_0, char_literal69_tree);
            }
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:288:8: ( IDCON )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==IDCON) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:288:10: IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    IDCON70=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_regularFormals553); if (state.failed) return retval;
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
            char_literal71=(CommonTree)match(input,43,FOLLOW_43_in_regularFormals560); if (state.failed) return retval;
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:292:1: statement : ( ^( 'if' '(' predicate ')' statement ( 'else' statement )? ) | eachStatement | letStatement | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( markup ';' ) | ^( markup ( markup )* ',' expression ';' ) | ^( markup ( markup )* ',' statement ) | ^( markup ( markup )* embedding ';' ) | ^( markup ( markup )* ';' ) );
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
        CommonTree char_literal81=null;
        CommonTree char_literal83=null;
        CommonTree string_literal84=null;
        CommonTree STRCON85=null;
        CommonTree char_literal86=null;
        CommonTree string_literal87=null;
        CommonTree char_literal89=null;
        CommonTree string_literal90=null;
        CommonTree char_literal92=null;
        CommonTree string_literal93=null;
        CommonTree char_literal95=null;
        CommonTree string_literal96=null;
        CommonTree char_literal98=null;
        CommonTree char_literal101=null;
        CommonTree char_literal103=null;
        CommonTree char_literal106=null;
        CommonTree char_literal111=null;
        CommonTree char_literal114=null;
        WaebricChecker.predicate_return predicate74 = null;

        WaebricChecker.statement_return statement76 = null;

        WaebricChecker.statement_return statement78 = null;

        WaebricChecker.eachStatement_return eachStatement79 = null;

        WaebricChecker.letStatement_return letStatement80 = null;

        WaebricChecker.statement_return statement82 = null;

        WaebricChecker.expression_return expression88 = null;

        WaebricChecker.embedding_return embedding91 = null;

        WaebricChecker.expression_return expression94 = null;

        WaebricChecker.markup_return markup97 = null;

        WaebricChecker.markup_return markup99 = null;

        WaebricChecker.markup_return markup100 = null;

        WaebricChecker.expression_return expression102 = null;

        WaebricChecker.markup_return markup104 = null;

        WaebricChecker.markup_return markup105 = null;

        WaebricChecker.statement_return statement107 = null;

        WaebricChecker.markup_return markup108 = null;

        WaebricChecker.markup_return markup109 = null;

        WaebricChecker.embedding_return embedding110 = null;

        WaebricChecker.markup_return markup112 = null;

        WaebricChecker.markup_return markup113 = null;


        CommonTree string_literal72_tree=null;
        CommonTree char_literal73_tree=null;
        CommonTree char_literal75_tree=null;
        CommonTree string_literal77_tree=null;
        CommonTree char_literal81_tree=null;
        CommonTree char_literal83_tree=null;
        CommonTree string_literal84_tree=null;
        CommonTree STRCON85_tree=null;
        CommonTree char_literal86_tree=null;
        CommonTree string_literal87_tree=null;
        CommonTree char_literal89_tree=null;
        CommonTree string_literal90_tree=null;
        CommonTree char_literal92_tree=null;
        CommonTree string_literal93_tree=null;
        CommonTree char_literal95_tree=null;
        CommonTree string_literal96_tree=null;
        CommonTree char_literal98_tree=null;
        CommonTree char_literal101_tree=null;
        CommonTree char_literal103_tree=null;
        CommonTree char_literal106_tree=null;
        CommonTree char_literal111_tree=null;
        CommonTree char_literal114_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:292:10: ( ^( 'if' '(' predicate ')' statement ( 'else' statement )? ) | eachStatement | letStatement | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( markup ';' ) | ^( markup ( markup )* ',' expression ';' ) | ^( markup ( markup )* ',' statement ) | ^( markup ( markup )* embedding ';' ) | ^( markup ( markup )* ';' ) )
            int alt28=14;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:292:13: ^( 'if' '(' predicate ')' statement ( 'else' statement )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal72=(CommonTree)match(input,50,FOLLOW_50_in_statement573); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal72_tree = (CommonTree)adaptor.dupNode(string_literal72);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal72_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    char_literal73=(CommonTree)match(input,41,FOLLOW_41_in_statement575); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal73_tree = (CommonTree)adaptor.dupNode(char_literal73);

                    adaptor.addChild(root_1, char_literal73_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_statement577);
                    predicate74=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, predicate74.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal75=(CommonTree)match(input,43,FOLLOW_43_in_statement579); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal75_tree = (CommonTree)adaptor.dupNode(char_literal75);

                    adaptor.addChild(root_1, char_literal75_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement581);
                    statement76=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement76.getTree());
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:292:49: ( 'else' statement )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==51) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:292:51: 'else' statement
                            {
                            _last = (CommonTree)input.LT(1);
                            string_literal77=(CommonTree)match(input,51,FOLLOW_51_in_statement585); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal77_tree = (CommonTree)adaptor.dupNode(string_literal77);

                            adaptor.addChild(root_1, string_literal77_tree);
                            }
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_statement_in_statement587);
                            statement78=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, statement78.getTree());

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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:293:6: eachStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_eachStatement_in_statement599);
                    eachStatement79=eachStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, eachStatement79.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:294:6: letStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_letStatement_in_statement606);
                    letStatement80=letStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, letStatement80.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:295:6: ^( '{' ( statement )* '}' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal81=(CommonTree)match(input,46,FOLLOW_46_in_statement615); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal81_tree = (CommonTree)adaptor.dupNode(char_literal81);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal81_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:295:13: ( statement )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==IDCON||LA23_0==COMMENT||LA23_0==46||LA23_0==50||(LA23_0>=52 && LA23_0<=53)||(LA23_0>=55 && LA23_0<=57)) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: statement
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_statement_in_statement617);
                    	    statement82=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, statement82.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal83=(CommonTree)match(input,47,FOLLOW_47_in_statement620); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal83_tree = (CommonTree)adaptor.dupNode(char_literal83);

                    adaptor.addChild(root_1, char_literal83_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:296:6: ^( 'comment' STRCON ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal84=(CommonTree)match(input,COMMENT,FOLLOW_COMMENT_in_statement631); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal84_tree = (CommonTree)adaptor.dupNode(string_literal84);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal84_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    STRCON85=(CommonTree)match(input,STRCON,FOLLOW_STRCON_in_statement633); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRCON85_tree = (CommonTree)adaptor.dupNode(STRCON85);

                    adaptor.addChild(root_1, STRCON85_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal86=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement635); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal86_tree = (CommonTree)adaptor.dupNode(char_literal86);

                    adaptor.addChild(root_1, char_literal86_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:297:6: ^( 'echo' expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal87=(CommonTree)match(input,55,FOLLOW_55_in_statement646); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal87_tree = (CommonTree)adaptor.dupNode(string_literal87);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal87_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement648);
                    expression88=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression88.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal89=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement650); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal89_tree = (CommonTree)adaptor.dupNode(char_literal89);

                    adaptor.addChild(root_1, char_literal89_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:298:6: ^( 'echo' embedding ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal90=(CommonTree)match(input,55,FOLLOW_55_in_statement661); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal90_tree = (CommonTree)adaptor.dupNode(string_literal90);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal90_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement663);
                    embedding91=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding91.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal92=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement665); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal92_tree = (CommonTree)adaptor.dupNode(char_literal92);

                    adaptor.addChild(root_1, char_literal92_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:299:6: ^( 'cdata' expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal93=(CommonTree)match(input,56,FOLLOW_56_in_statement676); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal93_tree = (CommonTree)adaptor.dupNode(string_literal93);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal93_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement678);
                    expression94=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression94.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal95=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement680); if (state.failed) return retval;
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
                case 9 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:300:6: 'yield;'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal96=(CommonTree)match(input,57,FOLLOW_57_in_statement689); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal96_tree = (CommonTree)adaptor.dupNode(string_literal96);

                    adaptor.addChild(root_0, string_literal96_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:301:6: ^( markup ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_statement698);
                    markup97=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(markup97.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    char_literal98=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement700); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal98_tree = (CommonTree)adaptor.dupNode(char_literal98);

                    adaptor.addChild(root_1, char_literal98_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:302:6: ^( markup ( markup )* ',' expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_statement711);
                    markup99=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(markup99.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:302:16: ( markup )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==IDCON) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement713);
                    	    markup100=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup100.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal101=(CommonTree)match(input,42,FOLLOW_42_in_statement716); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal101_tree = (CommonTree)adaptor.dupNode(char_literal101);

                    adaptor.addChild(root_1, char_literal101_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement718);
                    expression102=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression102.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal103=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement720); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal103_tree = (CommonTree)adaptor.dupNode(char_literal103);

                    adaptor.addChild(root_1, char_literal103_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:303:6: ^( markup ( markup )* ',' statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_statement731);
                    markup104=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(markup104.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:303:16: ( markup )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==IDCON) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement733);
                    	    markup105=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup105.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal106=(CommonTree)match(input,42,FOLLOW_42_in_statement736); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal106_tree = (CommonTree)adaptor.dupNode(char_literal106);

                    adaptor.addChild(root_1, char_literal106_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement738);
                    statement107=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement107.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:304:6: ^( markup ( markup )* embedding ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_statement749);
                    markup108=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(markup108.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:304:16: ( markup )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==IDCON) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement751);
                    	    markup109=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup109.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement754);
                    embedding110=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding110.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal111=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement756); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal111_tree = (CommonTree)adaptor.dupNode(char_literal111);

                    adaptor.addChild(root_1, char_literal111_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:305:6: ^( markup ( markup )* ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_statement767);
                    markup112=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(markup112.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:305:16: ( markup )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==IDCON) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement769);
                    	    markup113=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup113.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal114=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement772); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal114_tree = (CommonTree)adaptor.dupNode(char_literal114);

                    adaptor.addChild(root_1, char_literal114_tree);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:307:1: eachStatement : ^( 'each' '(' IDCON ':' expression ')' statement ) ;
    public final WaebricChecker.eachStatement_return eachStatement() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.eachStatement_return retval = new WaebricChecker.eachStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal115=null;
        CommonTree char_literal116=null;
        CommonTree IDCON117=null;
        CommonTree char_literal118=null;
        CommonTree char_literal120=null;
        WaebricChecker.expression_return expression119 = null;

        WaebricChecker.statement_return statement121 = null;


        CommonTree string_literal115_tree=null;
        CommonTree char_literal116_tree=null;
        CommonTree IDCON117_tree=null;
        CommonTree char_literal118_tree=null;
        CommonTree char_literal120_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new HashSet<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:312:4: ( ^( 'each' '(' IDCON ':' expression ')' statement ) )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:312:7: ^( 'each' '(' IDCON ':' expression ')' statement )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal115=(CommonTree)match(input,52,FOLLOW_52_in_eachStatement797); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal115_tree = (CommonTree)adaptor.dupNode(string_literal115);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal115_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            char_literal116=(CommonTree)match(input,41,FOLLOW_41_in_eachStatement799); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal116_tree = (CommonTree)adaptor.dupNode(char_literal116);

            adaptor.addChild(root_1, char_literal116_tree);
            }
            _last = (CommonTree)input.LT(1);
            IDCON117=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_eachStatement801); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON117_tree = (CommonTree)adaptor.dupNode(IDCON117);

            adaptor.addChild(root_1, IDCON117_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal118=(CommonTree)match(input,36,FOLLOW_36_in_eachStatement803); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal118_tree = (CommonTree)adaptor.dupNode(char_literal118);

            adaptor.addChild(root_1, char_literal118_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_eachStatement805);
            expression119=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expression119.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal120=(CommonTree)match(input,43,FOLLOW_43_in_eachStatement807); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal120_tree = (CommonTree)adaptor.dupNode(char_literal120);

            adaptor.addChild(root_1, char_literal120_tree);
            }
            if ( state.backtracking==0 ) {
               
              				defineVariable(IDCON117.getText()); // Define variable before statement is executed
              			
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_eachStatement811);
            statement121=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, statement121.getTree());

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:316:1: letStatement : ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) ;
    public final WaebricChecker.letStatement_return letStatement() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.letStatement_return retval = new WaebricChecker.letStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal122=null;
        CommonTree string_literal124=null;
        CommonTree string_literal126=null;
        WaebricChecker.assignment_return assignment123 = null;

        WaebricChecker.statement_return statement125 = null;


        CommonTree string_literal122_tree=null;
        CommonTree string_literal124_tree=null;
        CommonTree string_literal126_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new HashSet<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:321:4: ( ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:321:7: ^( 'let' ( assignment )+ 'in' ( statement )* 'end' )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal122=(CommonTree)match(input,53,FOLLOW_53_in_letStatement837); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal122_tree = (CommonTree)adaptor.dupNode(string_literal122);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal122_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:321:16: ( assignment )+
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
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: assignment
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_assignment_in_letStatement839);
            	    assignment123=assignment();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, assignment123.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
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

            _last = (CommonTree)input.LT(1);
            string_literal124=(CommonTree)match(input,54,FOLLOW_54_in_letStatement842); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal124_tree = (CommonTree)adaptor.dupNode(string_literal124);

            adaptor.addChild(root_1, string_literal124_tree);
            }
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:321:33: ( statement )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==IDCON||LA30_0==COMMENT||LA30_0==46||LA30_0==50||(LA30_0>=52 && LA30_0<=53)||(LA30_0>=55 && LA30_0<=57)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_letStatement844);
            	    statement125=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, statement125.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            string_literal126=(CommonTree)match(input,END,FOLLOW_END_in_letStatement847); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal126_tree = (CommonTree)adaptor.dupNode(string_literal126);

            adaptor.addChild(root_1, string_literal126_tree);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:323:1: assignment : ( IDCON '=' expression ';' | funcBinding );
    public final WaebricChecker.assignment_return assignment() throws RecognitionException {
        WaebricChecker.assignment_return retval = new WaebricChecker.assignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON127=null;
        CommonTree char_literal128=null;
        CommonTree char_literal130=null;
        WaebricChecker.expression_return expression129 = null;

        WaebricChecker.funcBinding_return funcBinding131 = null;


        CommonTree IDCON127_tree=null;
        CommonTree char_literal128_tree=null;
        CommonTree char_literal130_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:323:11: ( IDCON '=' expression ';' | funcBinding )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==IDCON) ) {
                int LA31_1 = input.LA(2);

                if ( (LA31_1==58) ) {
                    alt31=1;
                }
                else if ( (LA31_1==41) ) {
                    alt31=2;
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:323:14: IDCON '=' expression ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDCON127=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_assignment858); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON127_tree = (CommonTree)adaptor.dupNode(IDCON127);

                    adaptor.addChild(root_0, IDCON127_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal128=(CommonTree)match(input,58,FOLLOW_58_in_assignment860); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal128_tree = (CommonTree)adaptor.dupNode(char_literal128);

                    adaptor.addChild(root_0, char_literal128_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_assignment862);
                    expression129=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression129.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal130=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_assignment864); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal130_tree = (CommonTree)adaptor.dupNode(char_literal130);

                    adaptor.addChild(root_0, char_literal130_tree);
                    }
                    if ( state.backtracking==0 ) {
                       
                      				defineVariable(IDCON127.getText()); 
                      			
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:325:8: funcBinding
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_funcBinding_in_assignment870);
                    funcBinding131=funcBinding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, funcBinding131.getTree());

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:327:1: funcBinding : IDCON regularFormals statement ;
    public final WaebricChecker.funcBinding_return funcBinding() throws RecognitionException {
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
        		int parent = Environment_stack.size()-1;
        	
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:333:4: ( IDCON regularFormals statement )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:333:8: IDCON regularFormals statement
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON132=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_funcBinding897); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON132_tree = (CommonTree)adaptor.dupNode(IDCON132);

            adaptor.addChild(root_0, IDCON132_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_regularFormals_in_funcBinding899);
            regularFormals133=regularFormals();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, regularFormals133.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_funcBinding901);
            statement134=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, statement134.getTree());
            if ( state.backtracking==0 ) {

              				defineFunction(IDCON132, (regularFormals133!=null?regularFormals133.args:0), parent);
              			
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:340:1: predicate : ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )* ;
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:340:10: ( ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:340:13: ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:340:13: ( '!' predicate | expression | expression '.' type )
            int alt32=3;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:340:15: '!' predicate
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal135=(CommonTree)match(input,59,FOLLOW_59_in_predicate922); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal135_tree = (CommonTree)adaptor.dupNode(char_literal135);

                    adaptor.addChild(root_0, char_literal135_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_predicate924);
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:341:7: expression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate933);
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:342:7: expression '.' type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate941);
                    expression138=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression138.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal139=(CommonTree)match(input,34,FOLLOW_34_in_predicate943); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal139_tree = (CommonTree)adaptor.dupNode(char_literal139);

                    adaptor.addChild(root_0, char_literal139_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_predicate945);
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

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:343:6: ( '&&' predicate | '||' predicate )*
            loop33:
            do {
                int alt33=3;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==60) ) {
                    int LA33_2 = input.LA(2);

                    if ( (synpred54_WaebricChecker()) ) {
                        alt33=1;
                    }


                }
                else if ( (LA33_0==61) ) {
                    int LA33_3 = input.LA(2);

                    if ( (synpred55_WaebricChecker()) ) {
                        alt33=2;
                    }


                }


                switch (alt33) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:343:8: '&&' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal141=(CommonTree)match(input,60,FOLLOW_60_in_predicate954); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal141_tree = (CommonTree)adaptor.dupNode(string_literal141);

            	    adaptor.addChild(root_0, string_literal141_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate956);
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
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:343:25: '||' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal143=(CommonTree)match(input,61,FOLLOW_61_in_predicate960); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal143_tree = (CommonTree)adaptor.dupNode(string_literal143);

            	    adaptor.addChild(root_0, string_literal143_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate962);
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
            	    break loop33;
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:344:1: type : ( 'list' | 'record' | 'string' );
    public final WaebricChecker.type_return type() throws RecognitionException {
        WaebricChecker.type_return retval = new WaebricChecker.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set145=null;

        CommonTree set145_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:344:5: ( 'list' | 'record' | 'string' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:350:1: embedding : PRETEXT embed textTail ;
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:350:10: ( PRETEXT embed textTail )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:350:13: PRETEXT embed textTail
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PRETEXT146=(CommonTree)match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding997); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRETEXT146_tree = (CommonTree)adaptor.dupNode(PRETEXT146);

            adaptor.addChild(root_0, PRETEXT146_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_embed_in_embedding999);
            embed147=embed();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, embed147.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_textTail_in_embedding1001);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:351:1: embed : ( ( markup )* expression | ( markup )* markup );
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:351:6: ( ( markup )* expression | ( markup )* markup )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==IDCON) ) {
                int LA36_1 = input.LA(2);

                if ( (synpred59_WaebricChecker()) ) {
                    alt36=1;
                }
                else if ( (true) ) {
                    alt36=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 36, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA36_0>=NATCON && LA36_0<=SYMBOLCON)||LA36_0==44||LA36_0==46) ) {
                alt36=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:351:10: ( markup )* expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:351:10: ( markup )*
                    loop34:
                    do {
                        int alt34=2;
                        alt34 = dfa34.predict(input);
                        switch (alt34) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed1010);
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
                    	    break loop34;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_embed1013);
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:351:31: ( markup )* markup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:351:31: ( markup )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==IDCON) ) {
                            int LA35_1 = input.LA(2);

                            if ( (synpred60_WaebricChecker()) ) {
                                alt35=1;
                            }


                        }


                        switch (alt35) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed1017);
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
                    	    break loop35;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_embed1020);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:352:1: textTail : ( POSTTEXT | MIDTEXT embed textTail );
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:352:9: ( POSTTEXT | MIDTEXT embed textTail )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==POSTTEXT) ) {
                alt37=1;
            }
            else if ( (LA37_0==MIDTEXT) ) {
                alt37=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:352:12: POSTTEXT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    POSTTEXT153=(CommonTree)match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail1028); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    POSTTEXT153_tree = (CommonTree)adaptor.dupNode(POSTTEXT153);

                    adaptor.addChild(root_0, POSTTEXT153_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:352:23: MIDTEXT embed textTail
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    MIDTEXT154=(CommonTree)match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail1032); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MIDTEXT154_tree = (CommonTree)adaptor.dupNode(MIDTEXT154);

                    adaptor.addChild(root_0, MIDTEXT154_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embed_in_textTail1034);
                    embed155=embed();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, embed155.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_textTail_in_textTail1036);
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

    // $ANTLR start synpred25_WaebricChecker
    public final void synpred25_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:263:8: ( '+' expression )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:263:8: '+' expression
        {
        match(input,48,FOLLOW_48_in_synpred25_WaebricChecker435); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred25_WaebricChecker437);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_WaebricChecker

    // $ANTLR start synpred26_WaebricChecker
    public final void synpred26_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:263:25: ( '.' IDCON )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:263:25: '.' IDCON
        {
        match(input,34,FOLLOW_34_in_synpred26_WaebricChecker441); if (state.failed) return ;
        match(input,IDCON,FOLLOW_IDCON_in_synpred26_WaebricChecker443); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_WaebricChecker

    // $ANTLR start synpred37_WaebricChecker
    public final void synpred37_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:297:6: ( ^( 'echo' expression ';' ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:297:6: ^( 'echo' expression ';' )
        {
        match(input,55,FOLLOW_55_in_synpred37_WaebricChecker646); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred37_WaebricChecker648);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred37_WaebricChecker650); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred37_WaebricChecker

    // $ANTLR start synpred38_WaebricChecker
    public final void synpred38_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:298:6: ( ^( 'echo' embedding ';' ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:298:6: ^( 'echo' embedding ';' )
        {
        match(input,55,FOLLOW_55_in_synpred38_WaebricChecker661); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_embedding_in_synpred38_WaebricChecker663);
        embedding();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred38_WaebricChecker665); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred38_WaebricChecker

    // $ANTLR start synpred41_WaebricChecker
    public final void synpred41_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:301:6: ( ^( markup ';' ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:301:6: ^( markup ';' )
        {
        pushFollow(FOLLOW_markup_in_synpred41_WaebricChecker698);
        markup();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred41_WaebricChecker700); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred41_WaebricChecker

    // $ANTLR start synpred43_WaebricChecker
    public final void synpred43_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:302:6: ( ^( markup ( markup )* ',' expression ';' ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:302:6: ^( markup ( markup )* ',' expression ';' )
        {
        pushFollow(FOLLOW_markup_in_synpred43_WaebricChecker711);
        markup();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:302:16: ( markup )*
        loop42:
        do {
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==IDCON) ) {
                alt42=1;
            }


            switch (alt42) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred43_WaebricChecker713);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop42;
            }
        } while (true);

        match(input,42,FOLLOW_42_in_synpred43_WaebricChecker716); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred43_WaebricChecker718);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred43_WaebricChecker720); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred43_WaebricChecker

    // $ANTLR start synpred45_WaebricChecker
    public final void synpred45_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:303:6: ( ^( markup ( markup )* ',' statement ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:303:6: ^( markup ( markup )* ',' statement )
        {
        pushFollow(FOLLOW_markup_in_synpred45_WaebricChecker731);
        markup();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:303:16: ( markup )*
        loop43:
        do {
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==IDCON) ) {
                alt43=1;
            }


            switch (alt43) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred45_WaebricChecker733);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop43;
            }
        } while (true);

        match(input,42,FOLLOW_42_in_synpred45_WaebricChecker736); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred45_WaebricChecker738);
        statement();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred45_WaebricChecker

    // $ANTLR start synpred47_WaebricChecker
    public final void synpred47_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:304:6: ( ^( markup ( markup )* embedding ';' ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:304:6: ^( markup ( markup )* embedding ';' )
        {
        pushFollow(FOLLOW_markup_in_synpred47_WaebricChecker749);
        markup();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:304:16: ( markup )*
        loop44:
        do {
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==IDCON) ) {
                alt44=1;
            }


            switch (alt44) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred47_WaebricChecker751);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop44;
            }
        } while (true);

        pushFollow(FOLLOW_embedding_in_synpred47_WaebricChecker754);
        embedding();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred47_WaebricChecker756); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred47_WaebricChecker

    // $ANTLR start synpred53_WaebricChecker
    public final void synpred53_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:341:7: ( expression )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:341:7: expression
        {
        pushFollow(FOLLOW_expression_in_synpred53_WaebricChecker933);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred53_WaebricChecker

    // $ANTLR start synpred54_WaebricChecker
    public final void synpred54_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:343:8: ( '&&' predicate )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:343:8: '&&' predicate
        {
        match(input,60,FOLLOW_60_in_synpred54_WaebricChecker954); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred54_WaebricChecker956);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred54_WaebricChecker

    // $ANTLR start synpred55_WaebricChecker
    public final void synpred55_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:343:25: ( '||' predicate )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:343:25: '||' predicate
        {
        match(input,61,FOLLOW_61_in_synpred55_WaebricChecker960); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred55_WaebricChecker962);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred55_WaebricChecker

    // $ANTLR start synpred59_WaebricChecker
    public final void synpred59_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:351:10: ( ( markup )* expression )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:351:10: ( markup )* expression
        {
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:351:10: ( markup )*
        loop45:
        do {
            int alt45=2;
            alt45 = dfa45.predict(input);
            switch (alt45) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred59_WaebricChecker1010);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop45;
            }
        } while (true);

        pushFollow(FOLLOW_expression_in_synpred59_WaebricChecker1013);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred59_WaebricChecker

    // $ANTLR start synpred60_WaebricChecker
    public final void synpred60_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:351:31: ( markup )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:351:31: markup
        {
        pushFollow(FOLLOW_markup_in_synpred60_WaebricChecker1017);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred60_WaebricChecker

    // Delegated rules

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
    public final boolean synpred60_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred60_WaebricChecker_fragment(); // can never throw exception
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


    protected DFA28 dfa28 = new DFA28(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA34 dfa34 = new DFA34(this);
    protected DFA45 dfa45 = new DFA45(this);
    static final String DFA28_eotS =
        "\21\uffff";
    static final String DFA28_eofS =
        "\21\uffff";
    static final String DFA28_minS =
        "\1\4\5\uffff\1\0\2\uffff\1\0\7\uffff";
    static final String DFA28_maxS =
        "\1\71\5\uffff\1\0\2\uffff\1\0\7\uffff";
    static final String DFA28_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\11\1\uffff\1\6\1\7\1"+
        "\12\1\13\1\14\1\15\1\16";
    static final String DFA28_specialS =
        "\6\uffff\1\0\2\uffff\1\1\7\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\11\10\uffff\1\5\40\uffff\1\4\3\uffff\1\1\1\uffff\1\2\1\3"+
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
            return "292:1: statement : ( ^( 'if' '(' predicate ')' statement ( 'else' statement )? ) | eachStatement | letStatement | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( markup ';' ) | ^( markup ( markup )* ',' expression ';' ) | ^( markup ( markup )* ',' statement ) | ^( markup ( markup )* embedding ';' ) | ^( markup ( markup )* ';' ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TreeNodeStream input = (TreeNodeStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA28_6 = input.LA(1);

                         
                        int index28_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_WaebricChecker()) ) {s = 10;}

                        else if ( (synpred38_WaebricChecker()) ) {s = 11;}

                         
                        input.seek(index28_6);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA28_9 = input.LA(1);

                         
                        int index28_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred41_WaebricChecker()) ) {s = 12;}

                        else if ( (synpred43_WaebricChecker()) ) {s = 13;}

                        else if ( (synpred45_WaebricChecker()) ) {s = 14;}

                        else if ( (synpred47_WaebricChecker()) ) {s = 15;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index28_9);
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
    static final String DFA32_eotS =
        "\12\uffff";
    static final String DFA32_eofS =
        "\12\uffff";
    static final String DFA32_minS =
        "\1\4\1\uffff\6\0\2\uffff";
    static final String DFA32_maxS =
        "\1\73\1\uffff\6\0\2\uffff";
    static final String DFA32_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\1\3";
    static final String DFA32_specialS =
        "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\2\uffff}>";
    static final String[] DFA32_transitionS = {
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
            return "340:13: ( '!' predicate | expression | expression '.' type )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TreeNodeStream input = (TreeNodeStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA32_2 = input.LA(1);

                         
                        int index32_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred53_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index32_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA32_3 = input.LA(1);

                         
                        int index32_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred53_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index32_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA32_4 = input.LA(1);

                         
                        int index32_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred53_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index32_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA32_5 = input.LA(1);

                         
                        int index32_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred53_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index32_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA32_6 = input.LA(1);

                         
                        int index32_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred53_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index32_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA32_7 = input.LA(1);

                         
                        int index32_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred53_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index32_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 32, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA34_eotS =
        "\6\uffff";
    static final String DFA34_eofS =
        "\6\uffff";
    static final String DFA34_minS =
        "\2\4\2\uffff\2\4";
    static final String DFA34_maxS =
        "\1\56\1\60\2\uffff\1\4\1\60";
    static final String DFA34_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA34_specialS =
        "\6\uffff}>";
    static final String[] DFA34_transitionS = {
            "\1\1\1\uffff\3\2\43\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\2\uffff\2\2\25\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\2\uffff\2\2\25\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\2"
    };

    static final short[] DFA34_eot = DFA.unpackEncodedString(DFA34_eotS);
    static final short[] DFA34_eof = DFA.unpackEncodedString(DFA34_eofS);
    static final char[] DFA34_min = DFA.unpackEncodedStringToUnsignedChars(DFA34_minS);
    static final char[] DFA34_max = DFA.unpackEncodedStringToUnsignedChars(DFA34_maxS);
    static final short[] DFA34_accept = DFA.unpackEncodedString(DFA34_acceptS);
    static final short[] DFA34_special = DFA.unpackEncodedString(DFA34_specialS);
    static final short[][] DFA34_transition;

    static {
        int numStates = DFA34_transitionS.length;
        DFA34_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA34_transition[i] = DFA.unpackEncodedString(DFA34_transitionS[i]);
        }
    }

    class DFA34 extends DFA {

        public DFA34(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 34;
            this.eot = DFA34_eot;
            this.eof = DFA34_eof;
            this.min = DFA34_min;
            this.max = DFA34_max;
            this.accept = DFA34_accept;
            this.special = DFA34_special;
            this.transition = DFA34_transition;
        }
        public String getDescription() {
            return "()* loopback of 351:10: ( markup )*";
        }
    }
    static final String DFA45_eotS =
        "\6\uffff";
    static final String DFA45_eofS =
        "\1\uffff\1\2\3\uffff\1\2";
    static final String DFA45_minS =
        "\2\4\2\uffff\2\4";
    static final String DFA45_maxS =
        "\1\56\1\60\2\uffff\1\4\1\60";
    static final String DFA45_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA45_specialS =
        "\6\uffff}>";
    static final String[] DFA45_transitionS = {
            "\1\1\1\uffff\3\2\43\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\31\uffff\1\4\1\uffff\4\3\1\uffff\1\3\2\uffff"+
            "\1\3\1\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\31\uffff\1\4\1\uffff\4\3\1\uffff\1\3\2\uffff"+
            "\1\3\1\uffff\1\3\1\uffff\1\2"
    };

    static final short[] DFA45_eot = DFA.unpackEncodedString(DFA45_eotS);
    static final short[] DFA45_eof = DFA.unpackEncodedString(DFA45_eofS);
    static final char[] DFA45_min = DFA.unpackEncodedStringToUnsignedChars(DFA45_minS);
    static final char[] DFA45_max = DFA.unpackEncodedStringToUnsignedChars(DFA45_maxS);
    static final short[] DFA45_accept = DFA.unpackEncodedString(DFA45_acceptS);
    static final short[] DFA45_special = DFA.unpackEncodedString(DFA45_specialS);
    static final short[][] DFA45_transition;

    static {
        int numStates = DFA45_transitionS.length;
        DFA45_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA45_transition[i] = DFA.unpackEncodedString(DFA45_transitionS[i]);
        }
    }

    class DFA45 extends DFA {

        public DFA45(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 45;
            this.eot = DFA45_eot;
            this.eof = DFA45_eof;
            this.min = DFA45_min;
            this.max = DFA45_max;
            this.accept = DFA45_accept;
            this.special = DFA45_special;
            this.transition = DFA45_transition;
        }
        public String getDescription() {
            return "()* loopback of 351:10: ( markup )*";
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
    public static final BitSet FOLLOW_34_in_attribute270 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_attribute280 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_attribute290 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_attribute300 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NATCON_in_attribute302 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_attribute306 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NATCON_in_attribute308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_arguments326 = new BitSet(new long[]{0x00005C00000001D0L});
    public static final BitSet FOLLOW_expression_in_arguments330 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_42_in_arguments343 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_arguments345 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_43_in_arguments352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varExpression_in_expression367 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_NATCON_in_expression371 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_TEXT_in_expression375 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_SYMBOLCON_in_expression379 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_44_in_expression388 = new BitSet(new long[]{0x00007400000001D0L});
    public static final BitSet FOLLOW_expression_in_expression390 = new BitSet(new long[]{0x0000240000000000L});
    public static final BitSet FOLLOW_42_in_expression395 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_expression397 = new BitSet(new long[]{0x0000240000000000L});
    public static final BitSet FOLLOW_45_in_expression402 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_46_in_expression411 = new BitSet(new long[]{0x0000840000000010L});
    public static final BitSet FOLLOW_keyValuePair_in_expression413 = new BitSet(new long[]{0x0000840000000000L});
    public static final BitSet FOLLOW_42_in_expression418 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_keyValuePair_in_expression420 = new BitSet(new long[]{0x0000840000000000L});
    public static final BitSet FOLLOW_47_in_expression425 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_48_in_expression435 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_expression437 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_34_in_expression441 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_expression443 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_IDCON_in_varExpression455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_keyValuePair469 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_keyValuePair471 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_keyValuePair473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_function497 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_function499 = new BitSet(new long[]{0x03B442000000A010L});
    public static final BitSet FOLLOW_formals_in_function501 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_statement_in_function503 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_END_in_function506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_regularFormals_in_formals527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_regularFormals549 = new BitSet(new long[]{0x0000080000000010L});
    public static final BitSet FOLLOW_IDCON_in_regularFormals553 = new BitSet(new long[]{0x0000080000000010L});
    public static final BitSet FOLLOW_43_in_regularFormals560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_statement573 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_41_in_statement575 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_statement577 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_statement579 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement581 = new BitSet(new long[]{0x0008000000000008L});
    public static final BitSet FOLLOW_51_in_statement585 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement587 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_eachStatement_in_statement599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_letStatement_in_statement606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_statement615 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statement617 = new BitSet(new long[]{0x03B4C00000002010L});
    public static final BitSet FOLLOW_47_in_statement620 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COMMENT_in_statement631 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRCON_in_statement633 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement635 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_55_in_statement646 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement648 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement650 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_55_in_statement661 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_statement663 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement665 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_56_in_statement676 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement678 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement680 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_57_in_statement689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement698 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement700 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_statement711 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement713 = new BitSet(new long[]{0x0000040000000010L});
    public static final BitSet FOLLOW_42_in_statement716 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_statement718 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement720 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_statement731 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement733 = new BitSet(new long[]{0x0000040000000010L});
    public static final BitSet FOLLOW_42_in_statement736 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement738 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_statement749 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement751 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_embedding_in_statement754 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement756 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_statement767 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement769 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement772 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_52_in_eachStatement797 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_41_in_eachStatement799 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_eachStatement801 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_eachStatement803 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_eachStatement805 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_eachStatement807 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_eachStatement811 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_53_in_letStatement837 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_assignment_in_letStatement839 = new BitSet(new long[]{0x0040000000000010L});
    public static final BitSet FOLLOW_54_in_letStatement842 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_statement_in_letStatement844 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_END_in_letStatement847 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDCON_in_assignment858 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_assignment860 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_assignment862 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_assignment864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funcBinding_in_assignment870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_funcBinding897 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_regularFormals_in_funcBinding899 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_funcBinding901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_predicate922 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_predicate924 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate933 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate941 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_predicate943 = new BitSet(new long[]{0xC000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_type_in_predicate945 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_60_in_predicate954 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_predicate956 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_61_in_predicate960 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_predicate962 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding997 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_embed_in_embedding999 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_textTail_in_embedding1001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed1010 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_embed1013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed1017 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_embed1020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail1028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail1032 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_embed_in_textTail1034 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_textTail_in_textTail1036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_synpred25_WaebricChecker435 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_synpred25_WaebricChecker437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_synpred26_WaebricChecker441 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_synpred26_WaebricChecker443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_synpred37_WaebricChecker646 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_synpred37_WaebricChecker648 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred37_WaebricChecker650 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_55_in_synpred38_WaebricChecker661 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_synpred38_WaebricChecker663 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred38_WaebricChecker665 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_synpred41_WaebricChecker698 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred41_WaebricChecker700 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_synpred43_WaebricChecker711 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred43_WaebricChecker713 = new BitSet(new long[]{0x0000040000000010L});
    public static final BitSet FOLLOW_42_in_synpred43_WaebricChecker716 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_synpred43_WaebricChecker718 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred43_WaebricChecker720 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_synpred45_WaebricChecker731 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred45_WaebricChecker733 = new BitSet(new long[]{0x0000040000000010L});
    public static final BitSet FOLLOW_42_in_synpred45_WaebricChecker736 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_synpred45_WaebricChecker738 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_synpred47_WaebricChecker749 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred47_WaebricChecker751 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_embedding_in_synpred47_WaebricChecker754 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred47_WaebricChecker756 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_synpred53_WaebricChecker933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_synpred54_WaebricChecker954 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_synpred54_WaebricChecker956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred55_WaebricChecker960 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_synpred55_WaebricChecker962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred59_WaebricChecker1010 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_synpred59_WaebricChecker1013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred60_WaebricChecker1017 = new BitSet(new long[]{0x0000000000000002L});

}