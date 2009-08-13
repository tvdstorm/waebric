// $ANTLR 3.1.2 /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g 2009-08-13 10:11:09

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDCON", "PATH", "NATCON", "TEXT", "SYMBOLCON", "STRCON", "PRETEXT", "POSTTEXT", "MIDTEXT", "COMMENT", "SITE", "END", "SEMICOLON", "TEXTCHAR", "STRCHAR", "LETTER", "DIGIT", "HEXADECIMAL", "PATHELEMENT", "FILEEXT", "SYMBOLCHAR", "ESCLAYOUT", "DECIMAL", "ESCQUOTE", "AMP", "CHARREF", "ENTREF", "COMMENTS", "LAYOUT", "'module'", "'.'", "'import'", "':'", "'#'", "'$'", "'@'", "'%'", "'('", "','", "')'", "'['", "']'", "'{'", "'}'", "'+'", "'def'", "'if'", "'else'", "'each'", "'let'", "'in'", "'echo'", "'cdata'", "'yield'", "'='", "'!'", "'&&'", "'||'", "'list'", "'record'", "'string'"
    };
    public static final int T__64=64;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int LETTER=19;
    public static final int AMP=28;
    public static final int ESCLAYOUT=25;
    public static final int PATHELEMENT=22;
    public static final int PRETEXT=10;
    public static final int STRCON=9;
    public static final int TEXTCHAR=17;
    public static final int T__61=61;
    public static final int POSTTEXT=11;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int FILEEXT=23;
    public static final int T__52=52;
    public static final int COMMENTS=31;
    public static final int CHARREF=29;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int IDCON=4;
    public static final int PATH=5;
    public static final int T__59=59;
    public static final int STRCHAR=18;
    public static final int DIGIT=20;
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
    public static final int HEXADECIMAL=21;
    public static final int SEMICOLON=16;
    public static final int SYMBOLCHAR=24;
    public static final int TEXT=7;
    public static final int LAYOUT=32;
    public static final int NATCON=6;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int DECIMAL=26;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int ENTREF=30;
    public static final int ESCQUOTE=27;
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:286:26: 
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:288:1: regularFormals returns [int args = 0] : '(' ( IDCON )* ')' ;
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:288:38: ( '(' ( IDCON )* ')' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:289:4: '(' ( IDCON )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            char_literal69=(CommonTree)match(input,41,FOLLOW_41_in_regularFormals555); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal69_tree = (CommonTree)adaptor.dupNode(char_literal69);

            adaptor.addChild(root_0, char_literal69_tree);
            }
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:289:8: ( IDCON )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==IDCON) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:289:10: IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    IDCON70=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_regularFormals559); if (state.failed) return retval;
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
            char_literal71=(CommonTree)match(input,43,FOLLOW_43_in_regularFormals566); if (state.failed) return retval;
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:293:1: statement : ( ^( 'if' predicate statement 'else' statement ) | ^( 'if' predicate statement ) | ^( 'each' IDCON expression statement ) | ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ) | ^( 'echo' expression ) | ^( 'echo' embedding ) | ^( 'cdata' expression ) | 'yield' | markup | ^( markup ( markup )* ',' expression ';' ) | ^( markup ( markup )* ',' statement ) | ^( markup ( markup )* embedding ';' ) | ^( markup ( markup )* ';' ) );
    public final WaebricChecker.statement_return statement() throws RecognitionException {
        WaebricChecker.statement_return retval = new WaebricChecker.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal72=null;
        CommonTree string_literal75=null;
        CommonTree string_literal77=null;
        CommonTree string_literal80=null;
        CommonTree IDCON81=null;
        CommonTree string_literal84=null;
        CommonTree string_literal86=null;
        CommonTree string_literal88=null;
        CommonTree char_literal89=null;
        CommonTree char_literal91=null;
        CommonTree string_literal92=null;
        CommonTree STRCON93=null;
        CommonTree string_literal94=null;
        CommonTree string_literal96=null;
        CommonTree string_literal98=null;
        CommonTree string_literal100=null;
        CommonTree char_literal104=null;
        CommonTree char_literal106=null;
        CommonTree char_literal109=null;
        CommonTree char_literal114=null;
        CommonTree char_literal117=null;
        WaebricChecker.predicate_return predicate73 = null;

        WaebricChecker.statement_return statement74 = null;

        WaebricChecker.statement_return statement76 = null;

        WaebricChecker.predicate_return predicate78 = null;

        WaebricChecker.statement_return statement79 = null;

        WaebricChecker.expression_return expression82 = null;

        WaebricChecker.statement_return statement83 = null;

        WaebricChecker.assignment_return assignment85 = null;

        WaebricChecker.statement_return statement87 = null;

        WaebricChecker.statement_return statement90 = null;

        WaebricChecker.expression_return expression95 = null;

        WaebricChecker.embedding_return embedding97 = null;

        WaebricChecker.expression_return expression99 = null;

        WaebricChecker.markup_return markup101 = null;

        WaebricChecker.markup_return markup102 = null;

        WaebricChecker.markup_return markup103 = null;

        WaebricChecker.expression_return expression105 = null;

        WaebricChecker.markup_return markup107 = null;

        WaebricChecker.markup_return markup108 = null;

        WaebricChecker.statement_return statement110 = null;

        WaebricChecker.markup_return markup111 = null;

        WaebricChecker.markup_return markup112 = null;

        WaebricChecker.embedding_return embedding113 = null;

        WaebricChecker.markup_return markup115 = null;

        WaebricChecker.markup_return markup116 = null;


        CommonTree string_literal72_tree=null;
        CommonTree string_literal75_tree=null;
        CommonTree string_literal77_tree=null;
        CommonTree string_literal80_tree=null;
        CommonTree IDCON81_tree=null;
        CommonTree string_literal84_tree=null;
        CommonTree string_literal86_tree=null;
        CommonTree string_literal88_tree=null;
        CommonTree char_literal89_tree=null;
        CommonTree char_literal91_tree=null;
        CommonTree string_literal92_tree=null;
        CommonTree STRCON93_tree=null;
        CommonTree string_literal94_tree=null;
        CommonTree string_literal96_tree=null;
        CommonTree string_literal98_tree=null;
        CommonTree string_literal100_tree=null;
        CommonTree char_literal104_tree=null;
        CommonTree char_literal106_tree=null;
        CommonTree char_literal109_tree=null;
        CommonTree char_literal114_tree=null;
        CommonTree char_literal117_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:293:10: ( ^( 'if' predicate statement 'else' statement ) | ^( 'if' predicate statement ) | ^( 'each' IDCON expression statement ) | ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ) | ^( 'echo' expression ) | ^( 'echo' embedding ) | ^( 'cdata' expression ) | 'yield' | markup | ^( markup ( markup )* ',' expression ';' ) | ^( markup ( markup )* ',' statement ) | ^( markup ( markup )* embedding ';' ) | ^( markup ( markup )* ';' ) )
            int alt29=15;
            alt29 = dfa29.predict(input);
            switch (alt29) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:293:13: ^( 'if' predicate statement 'else' statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal72=(CommonTree)match(input,50,FOLLOW_50_in_statement579); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal72_tree = (CommonTree)adaptor.dupNode(string_literal72);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal72_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_statement581);
                    predicate73=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, predicate73.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement583);
                    statement74=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement74.getTree());
                    _last = (CommonTree)input.LT(1);
                    string_literal75=(CommonTree)match(input,51,FOLLOW_51_in_statement585); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal75_tree = (CommonTree)adaptor.dupNode(string_literal75);

                    adaptor.addChild(root_1, string_literal75_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement587);
                    statement76=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement76.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:294:6: ^( 'if' predicate statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal77=(CommonTree)match(input,50,FOLLOW_50_in_statement598); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal77_tree = (CommonTree)adaptor.dupNode(string_literal77);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal77_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_statement600);
                    predicate78=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, predicate78.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement602);
                    statement79=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement79.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:295:6: ^( 'each' IDCON expression statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal80=(CommonTree)match(input,52,FOLLOW_52_in_statement613); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal80_tree = (CommonTree)adaptor.dupNode(string_literal80);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal80_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDCON81=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_statement615); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON81_tree = (CommonTree)adaptor.dupNode(IDCON81);

                    adaptor.addChild(root_1, IDCON81_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement617);
                    expression82=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression82.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement619);
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:296:6: ^( 'let' ( assignment )+ 'in' ( statement )* 'end' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal84=(CommonTree)match(input,53,FOLLOW_53_in_statement630); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal84_tree = (CommonTree)adaptor.dupNode(string_literal84);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal84_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:296:15: ( assignment )+
                    int cnt22=0;
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==IDCON) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: assignment
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_assignment_in_statement632);
                    	    assignment85=assignment();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, assignment85.getTree());

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
                    string_literal86=(CommonTree)match(input,54,FOLLOW_54_in_statement635); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal86_tree = (CommonTree)adaptor.dupNode(string_literal86);

                    adaptor.addChild(root_1, string_literal86_tree);
                    }
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:296:32: ( statement )*
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
                    	    pushFollow(FOLLOW_statement_in_statement637);
                    	    statement87=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, statement87.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    string_literal88=(CommonTree)match(input,END,FOLLOW_END_in_statement640); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal88_tree = (CommonTree)adaptor.dupNode(string_literal88);

                    adaptor.addChild(root_1, string_literal88_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:297:6: ^( '{' ( statement )* '}' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal89=(CommonTree)match(input,46,FOLLOW_46_in_statement651); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal89_tree = (CommonTree)adaptor.dupNode(char_literal89);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal89_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:297:13: ( statement )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==IDCON||LA24_0==COMMENT||LA24_0==46||LA24_0==50||(LA24_0>=52 && LA24_0<=53)||(LA24_0>=55 && LA24_0<=57)) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: statement
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_statement_in_statement653);
                    	    statement90=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, statement90.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal91=(CommonTree)match(input,47,FOLLOW_47_in_statement656); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal91_tree = (CommonTree)adaptor.dupNode(char_literal91);

                    adaptor.addChild(root_1, char_literal91_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:298:6: ^( 'comment' STRCON )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal92=(CommonTree)match(input,COMMENT,FOLLOW_COMMENT_in_statement667); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal92_tree = (CommonTree)adaptor.dupNode(string_literal92);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal92_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    STRCON93=(CommonTree)match(input,STRCON,FOLLOW_STRCON_in_statement669); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRCON93_tree = (CommonTree)adaptor.dupNode(STRCON93);

                    adaptor.addChild(root_1, STRCON93_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:299:6: ^( 'echo' expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal94=(CommonTree)match(input,55,FOLLOW_55_in_statement680); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal94_tree = (CommonTree)adaptor.dupNode(string_literal94);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal94_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement682);
                    expression95=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression95.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:300:6: ^( 'echo' embedding )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal96=(CommonTree)match(input,55,FOLLOW_55_in_statement693); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal96_tree = (CommonTree)adaptor.dupNode(string_literal96);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal96_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement695);
                    embedding97=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding97.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:301:6: ^( 'cdata' expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal98=(CommonTree)match(input,56,FOLLOW_56_in_statement706); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal98_tree = (CommonTree)adaptor.dupNode(string_literal98);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal98_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement708);
                    expression99=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression99.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:302:6: 'yield'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal100=(CommonTree)match(input,57,FOLLOW_57_in_statement717); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal100_tree = (CommonTree)adaptor.dupNode(string_literal100);

                    adaptor.addChild(root_0, string_literal100_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:303:6: markup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_statement724);
                    markup101=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, markup101.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:304:6: ^( markup ( markup )* ',' expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_statement733);
                    markup102=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(markup102.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:304:16: ( markup )*
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
                    	    pushFollow(FOLLOW_markup_in_statement735);
                    	    markup103=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup103.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal104=(CommonTree)match(input,42,FOLLOW_42_in_statement738); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal104_tree = (CommonTree)adaptor.dupNode(char_literal104);

                    adaptor.addChild(root_1, char_literal104_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement740);
                    expression105=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression105.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal106=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement742); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal106_tree = (CommonTree)adaptor.dupNode(char_literal106);

                    adaptor.addChild(root_1, char_literal106_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:305:6: ^( markup ( markup )* ',' statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_statement753);
                    markup107=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(markup107.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:305:16: ( markup )*
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
                    	    pushFollow(FOLLOW_markup_in_statement755);
                    	    markup108=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup108.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal109=(CommonTree)match(input,42,FOLLOW_42_in_statement758); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal109_tree = (CommonTree)adaptor.dupNode(char_literal109);

                    adaptor.addChild(root_1, char_literal109_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement760);
                    statement110=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement110.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:306:6: ^( markup ( markup )* embedding ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_statement771);
                    markup111=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(markup111.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:306:16: ( markup )*
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
                    	    pushFollow(FOLLOW_markup_in_statement773);
                    	    markup112=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup112.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement776);
                    embedding113=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding113.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal114=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement778); if (state.failed) return retval;
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
                case 15 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:307:6: ^( markup ( markup )* ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_statement789);
                    markup115=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(markup115.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:307:16: ( markup )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==IDCON) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement791);
                    	    markup116=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup116.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal117=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement794); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal117_tree = (CommonTree)adaptor.dupNode(char_literal117);

                    adaptor.addChild(root_1, char_literal117_tree);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:309:1: eachStatement : 'each' IDCON expression statement ;
    public final WaebricChecker.eachStatement_return eachStatement() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.eachStatement_return retval = new WaebricChecker.eachStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal118=null;
        CommonTree IDCON119=null;
        WaebricChecker.expression_return expression120 = null;

        WaebricChecker.statement_return statement121 = null;


        CommonTree string_literal118_tree=null;
        CommonTree IDCON119_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new HashSet<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:314:4: ( 'each' IDCON expression statement )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:314:7: 'each' IDCON expression statement
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal118=(CommonTree)match(input,52,FOLLOW_52_in_eachStatement818); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal118_tree = (CommonTree)adaptor.dupNode(string_literal118);

            adaptor.addChild(root_0, string_literal118_tree);
            }
            _last = (CommonTree)input.LT(1);
            IDCON119=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_eachStatement820); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON119_tree = (CommonTree)adaptor.dupNode(IDCON119);

            adaptor.addChild(root_0, IDCON119_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_eachStatement822);
            expression120=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(expression120.getTree(), root_0);
            if ( state.backtracking==0 ) {
               
              				defineVariable(IDCON119.getText()); // Define variable before statement is executed
              			
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_eachStatement828);
            statement121=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, statement121.getTree());

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:318:1: letStatement : 'let' ( assignment )+ 'in' ( statement )* 'end' ;
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:323:4: ( 'let' ( assignment )+ 'in' ( statement )* 'end' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:323:7: 'let' ( assignment )+ 'in' ( statement )* 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal122=(CommonTree)match(input,53,FOLLOW_53_in_letStatement850); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal122_tree = (CommonTree)adaptor.dupNode(string_literal122);

            adaptor.addChild(root_0, string_literal122_tree);
            }
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:323:13: ( assignment )+
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
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: assignment
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_assignment_in_letStatement852);
            	    assignment123=assignment();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, assignment123.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
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

            _last = (CommonTree)input.LT(1);
            string_literal124=(CommonTree)match(input,54,FOLLOW_54_in_letStatement855); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal124_tree = (CommonTree)adaptor.dupNode(string_literal124);

            adaptor.addChild(root_0, string_literal124_tree);
            }
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:323:30: ( statement )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==IDCON||LA31_0==COMMENT||LA31_0==46||LA31_0==50||(LA31_0>=52 && LA31_0<=53)||(LA31_0>=55 && LA31_0<=57)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_letStatement857);
            	    statement125=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, statement125.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            string_literal126=(CommonTree)match(input,END,FOLLOW_END_in_letStatement860); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal126_tree = (CommonTree)adaptor.dupNode(string_literal126);

            adaptor.addChild(root_0, string_literal126_tree);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:325:1: assignment : ( IDCON '=' expression ';' | funcBinding );
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:325:11: ( IDCON '=' expression ';' | funcBinding )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==IDCON) ) {
                int LA32_1 = input.LA(2);

                if ( (LA32_1==58) ) {
                    alt32=1;
                }
                else if ( (LA32_1==41) ) {
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:325:14: IDCON '=' expression ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDCON127=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_assignment869); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON127_tree = (CommonTree)adaptor.dupNode(IDCON127);

                    adaptor.addChild(root_0, IDCON127_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal128=(CommonTree)match(input,58,FOLLOW_58_in_assignment871); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal128_tree = (CommonTree)adaptor.dupNode(char_literal128);

                    adaptor.addChild(root_0, char_literal128_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_assignment873);
                    expression129=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression129.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal130=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_assignment875); if (state.failed) return retval;
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:327:8: funcBinding
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_funcBinding_in_assignment881);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:329:1: funcBinding : IDCON regularFormals statement ;
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:335:4: ( IDCON regularFormals statement )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:335:8: IDCON regularFormals statement
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON132=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_funcBinding908); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON132_tree = (CommonTree)adaptor.dupNode(IDCON132);

            adaptor.addChild(root_0, IDCON132_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_regularFormals_in_funcBinding910);
            regularFormals133=regularFormals();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, regularFormals133.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_funcBinding912);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:342:1: predicate : ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )* ;
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:342:10: ( ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:342:13: ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:342:13: ( '!' predicate | expression | expression '.' type )
            int alt33=3;
            alt33 = dfa33.predict(input);
            switch (alt33) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:342:15: '!' predicate
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal135=(CommonTree)match(input,59,FOLLOW_59_in_predicate933); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal135_tree = (CommonTree)adaptor.dupNode(char_literal135);

                    adaptor.addChild(root_0, char_literal135_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_predicate935);
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:343:7: expression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate944);
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:344:7: expression '.' type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate952);
                    expression138=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression138.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal139=(CommonTree)match(input,34,FOLLOW_34_in_predicate954); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal139_tree = (CommonTree)adaptor.dupNode(char_literal139);

                    adaptor.addChild(root_0, char_literal139_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_predicate956);
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

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:345:6: ( '&&' predicate | '||' predicate )*
            loop34:
            do {
                int alt34=3;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==60) ) {
                    int LA34_2 = input.LA(2);

                    if ( (synpred56_WaebricChecker()) ) {
                        alt34=1;
                    }


                }
                else if ( (LA34_0==61) ) {
                    int LA34_3 = input.LA(2);

                    if ( (synpred57_WaebricChecker()) ) {
                        alt34=2;
                    }


                }


                switch (alt34) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:345:8: '&&' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal141=(CommonTree)match(input,60,FOLLOW_60_in_predicate965); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal141_tree = (CommonTree)adaptor.dupNode(string_literal141);

            	    adaptor.addChild(root_0, string_literal141_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate967);
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
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:345:25: '||' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal143=(CommonTree)match(input,61,FOLLOW_61_in_predicate971); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal143_tree = (CommonTree)adaptor.dupNode(string_literal143);

            	    adaptor.addChild(root_0, string_literal143_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate973);
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
            	    break loop34;
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:346:1: type : ( 'list' | 'record' | 'string' );
    public final WaebricChecker.type_return type() throws RecognitionException {
        WaebricChecker.type_return retval = new WaebricChecker.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set145=null;

        CommonTree set145_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:346:5: ( 'list' | 'record' | 'string' )
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:352:1: embedding : PRETEXT embed textTail ;
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:352:10: ( PRETEXT embed textTail )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:352:13: PRETEXT embed textTail
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PRETEXT146=(CommonTree)match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding1008); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRETEXT146_tree = (CommonTree)adaptor.dupNode(PRETEXT146);

            adaptor.addChild(root_0, PRETEXT146_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_embed_in_embedding1010);
            embed147=embed();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, embed147.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_textTail_in_embedding1012);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:353:1: embed : ( ( markup )* expression | ( markup )* markup );
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:353:6: ( ( markup )* expression | ( markup )* markup )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==IDCON) ) {
                int LA37_1 = input.LA(2);

                if ( (synpred61_WaebricChecker()) ) {
                    alt37=1;
                }
                else if ( (true) ) {
                    alt37=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA37_0>=NATCON && LA37_0<=SYMBOLCON)||LA37_0==44||LA37_0==46) ) {
                alt37=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:353:10: ( markup )* expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:353:10: ( markup )*
                    loop35:
                    do {
                        int alt35=2;
                        alt35 = dfa35.predict(input);
                        switch (alt35) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed1021);
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
                    	    break loop35;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_embed1024);
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:353:31: ( markup )* markup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:353:31: ( markup )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==IDCON) ) {
                            int LA36_1 = input.LA(2);

                            if ( (synpred62_WaebricChecker()) ) {
                                alt36=1;
                            }


                        }


                        switch (alt36) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed1028);
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
                    	    break loop36;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_embed1031);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:354:1: textTail : ( POSTTEXT | MIDTEXT embed textTail );
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
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:354:9: ( POSTTEXT | MIDTEXT embed textTail )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==POSTTEXT) ) {
                alt38=1;
            }
            else if ( (LA38_0==MIDTEXT) ) {
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:354:12: POSTTEXT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    POSTTEXT153=(CommonTree)match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail1039); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    POSTTEXT153_tree = (CommonTree)adaptor.dupNode(POSTTEXT153);

                    adaptor.addChild(root_0, POSTTEXT153_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:354:23: MIDTEXT embed textTail
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    MIDTEXT154=(CommonTree)match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail1043); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MIDTEXT154_tree = (CommonTree)adaptor.dupNode(MIDTEXT154);

                    adaptor.addChild(root_0, MIDTEXT154_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embed_in_textTail1045);
                    embed155=embed();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, embed155.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_textTail_in_textTail1047);
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

    // $ANTLR start synpred30_WaebricChecker
    public final void synpred30_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:293:13: ( ^( 'if' predicate statement 'else' statement ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:293:13: ^( 'if' predicate statement 'else' statement )
        {
        match(input,50,FOLLOW_50_in_synpred30_WaebricChecker579); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred30_WaebricChecker581);
        predicate();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred30_WaebricChecker583);
        statement();

        state._fsp--;
        if (state.failed) return ;
        match(input,51,FOLLOW_51_in_synpred30_WaebricChecker585); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred30_WaebricChecker587);
        statement();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_WaebricChecker

    // $ANTLR start synpred31_WaebricChecker
    public final void synpred31_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:294:6: ( ^( 'if' predicate statement ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:294:6: ^( 'if' predicate statement )
        {
        match(input,50,FOLLOW_50_in_synpred31_WaebricChecker598); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred31_WaebricChecker600);
        predicate();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred31_WaebricChecker602);
        statement();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_WaebricChecker

    // $ANTLR start synpred39_WaebricChecker
    public final void synpred39_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:299:6: ( ^( 'echo' expression ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:299:6: ^( 'echo' expression )
        {
        match(input,55,FOLLOW_55_in_synpred39_WaebricChecker680); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred39_WaebricChecker682);
        expression();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_WaebricChecker

    // $ANTLR start synpred40_WaebricChecker
    public final void synpred40_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:300:6: ( ^( 'echo' embedding ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:300:6: ^( 'echo' embedding )
        {
        match(input,55,FOLLOW_55_in_synpred40_WaebricChecker693); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_embedding_in_synpred40_WaebricChecker695);
        embedding();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred40_WaebricChecker

    // $ANTLR start synpred43_WaebricChecker
    public final void synpred43_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:303:6: ( markup )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:303:6: markup
        {
        pushFollow(FOLLOW_markup_in_synpred43_WaebricChecker724);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred43_WaebricChecker

    // $ANTLR start synpred45_WaebricChecker
    public final void synpred45_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:304:6: ( ^( markup ( markup )* ',' expression ';' ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:304:6: ^( markup ( markup )* ',' expression ';' )
        {
        pushFollow(FOLLOW_markup_in_synpred45_WaebricChecker733);
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
        	    pushFollow(FOLLOW_markup_in_synpred45_WaebricChecker735);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop44;
            }
        } while (true);

        match(input,42,FOLLOW_42_in_synpred45_WaebricChecker738); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred45_WaebricChecker740);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred45_WaebricChecker742); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred45_WaebricChecker

    // $ANTLR start synpred47_WaebricChecker
    public final void synpred47_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:305:6: ( ^( markup ( markup )* ',' statement ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:305:6: ^( markup ( markup )* ',' statement )
        {
        pushFollow(FOLLOW_markup_in_synpred47_WaebricChecker753);
        markup();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:305:16: ( markup )*
        loop45:
        do {
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==IDCON) ) {
                alt45=1;
            }


            switch (alt45) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred47_WaebricChecker755);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop45;
            }
        } while (true);

        match(input,42,FOLLOW_42_in_synpred47_WaebricChecker758); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred47_WaebricChecker760);
        statement();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred47_WaebricChecker

    // $ANTLR start synpred49_WaebricChecker
    public final void synpred49_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:306:6: ( ^( markup ( markup )* embedding ';' ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:306:6: ^( markup ( markup )* embedding ';' )
        {
        pushFollow(FOLLOW_markup_in_synpred49_WaebricChecker771);
        markup();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:306:16: ( markup )*
        loop46:
        do {
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==IDCON) ) {
                alt46=1;
            }


            switch (alt46) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred49_WaebricChecker773);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop46;
            }
        } while (true);

        pushFollow(FOLLOW_embedding_in_synpred49_WaebricChecker776);
        embedding();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred49_WaebricChecker778); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred49_WaebricChecker

    // $ANTLR start synpred55_WaebricChecker
    public final void synpred55_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:343:7: ( expression )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:343:7: expression
        {
        pushFollow(FOLLOW_expression_in_synpred55_WaebricChecker944);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred55_WaebricChecker

    // $ANTLR start synpred56_WaebricChecker
    public final void synpred56_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:345:8: ( '&&' predicate )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:345:8: '&&' predicate
        {
        match(input,60,FOLLOW_60_in_synpred56_WaebricChecker965); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred56_WaebricChecker967);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred56_WaebricChecker

    // $ANTLR start synpred57_WaebricChecker
    public final void synpred57_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:345:25: ( '||' predicate )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:345:25: '||' predicate
        {
        match(input,61,FOLLOW_61_in_synpred57_WaebricChecker971); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred57_WaebricChecker973);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred57_WaebricChecker

    // $ANTLR start synpred61_WaebricChecker
    public final void synpred61_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:353:10: ( ( markup )* expression )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:353:10: ( markup )* expression
        {
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:353:10: ( markup )*
        loop47:
        do {
            int alt47=2;
            alt47 = dfa47.predict(input);
            switch (alt47) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred61_WaebricChecker1021);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop47;
            }
        } while (true);

        pushFollow(FOLLOW_expression_in_synpred61_WaebricChecker1024);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred61_WaebricChecker

    // $ANTLR start synpred62_WaebricChecker
    public final void synpred62_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:353:31: ( markup )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:353:31: markup
        {
        pushFollow(FOLLOW_markup_in_synpred62_WaebricChecker1028);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred62_WaebricChecker

    // Delegated rules

    public final boolean synpred62_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred62_WaebricChecker_fragment(); // can never throw exception
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
    public final boolean synpred57_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred57_WaebricChecker_fragment(); // can never throw exception
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
    public final boolean synpred61_WaebricChecker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred61_WaebricChecker_fragment(); // can never throw exception
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


    protected DFA29 dfa29 = new DFA29(this);
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA35 dfa35 = new DFA35(this);
    protected DFA47 dfa47 = new DFA47(this);
    static final String DFA29_eotS =
        "\23\uffff";
    static final String DFA29_eofS =
        "\23\uffff";
    static final String DFA29_minS =
        "\1\4\1\0\4\uffff\1\0\2\uffff\1\0\11\uffff";
    static final String DFA29_maxS =
        "\1\71\1\0\4\uffff\1\0\2\uffff\1\0\11\uffff";
    static final String DFA29_acceptS =
        "\2\uffff\1\3\1\4\1\5\1\6\1\uffff\1\11\1\12\1\uffff\1\1\1\2\1\7\1"+
        "\10\1\13\1\14\1\15\1\16\1\17";
    static final String DFA29_specialS =
        "\1\uffff\1\0\4\uffff\1\1\2\uffff\1\2\11\uffff}>";
    static final String[] DFA29_transitionS = {
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

    static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
    static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
    static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
    static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
    static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
    static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
    static final short[][] DFA29_transition;

    static {
        int numStates = DFA29_transitionS.length;
        DFA29_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
        }
    }

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = DFA29_eot;
            this.eof = DFA29_eof;
            this.min = DFA29_min;
            this.max = DFA29_max;
            this.accept = DFA29_accept;
            this.special = DFA29_special;
            this.transition = DFA29_transition;
        }
        public String getDescription() {
            return "293:1: statement : ( ^( 'if' predicate statement 'else' statement ) | ^( 'if' predicate statement ) | ^( 'each' IDCON expression statement ) | ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ) | ^( 'echo' expression ) | ^( 'echo' embedding ) | ^( 'cdata' expression ) | 'yield' | markup | ^( markup ( markup )* ',' expression ';' ) | ^( markup ( markup )* ',' statement ) | ^( markup ( markup )* embedding ';' ) | ^( markup ( markup )* ';' ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TreeNodeStream input = (TreeNodeStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA29_1 = input.LA(1);

                         
                        int index29_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_WaebricChecker()) ) {s = 10;}

                        else if ( (synpred31_WaebricChecker()) ) {s = 11;}

                         
                        input.seek(index29_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA29_6 = input.LA(1);

                         
                        int index29_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_WaebricChecker()) ) {s = 12;}

                        else if ( (synpred40_WaebricChecker()) ) {s = 13;}

                         
                        input.seek(index29_6);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA29_9 = input.LA(1);

                         
                        int index29_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_WaebricChecker()) ) {s = 14;}

                        else if ( (synpred45_WaebricChecker()) ) {s = 15;}

                        else if ( (synpred47_WaebricChecker()) ) {s = 16;}

                        else if ( (synpred49_WaebricChecker()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index29_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 29, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA33_eotS =
        "\12\uffff";
    static final String DFA33_eofS =
        "\12\uffff";
    static final String DFA33_minS =
        "\1\4\1\uffff\6\0\2\uffff";
    static final String DFA33_maxS =
        "\1\73\1\uffff\6\0\2\uffff";
    static final String DFA33_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\1\3";
    static final String DFA33_specialS =
        "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\2\uffff}>";
    static final String[] DFA33_transitionS = {
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
            return "342:13: ( '!' predicate | expression | expression '.' type )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TreeNodeStream input = (TreeNodeStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA33_2 = input.LA(1);

                         
                        int index33_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred55_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index33_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA33_3 = input.LA(1);

                         
                        int index33_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred55_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index33_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA33_4 = input.LA(1);

                         
                        int index33_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred55_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index33_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA33_5 = input.LA(1);

                         
                        int index33_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred55_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index33_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA33_6 = input.LA(1);

                         
                        int index33_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred55_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index33_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA33_7 = input.LA(1);

                         
                        int index33_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred55_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index33_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 33, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA35_eotS =
        "\6\uffff";
    static final String DFA35_eofS =
        "\6\uffff";
    static final String DFA35_minS =
        "\2\4\2\uffff\2\4";
    static final String DFA35_maxS =
        "\1\56\1\60\2\uffff\1\4\1\60";
    static final String DFA35_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA35_specialS =
        "\6\uffff}>";
    static final String[] DFA35_transitionS = {
            "\1\1\1\uffff\3\2\43\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\2\uffff\2\2\25\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\2\uffff\2\2\25\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\2"
    };

    static final short[] DFA35_eot = DFA.unpackEncodedString(DFA35_eotS);
    static final short[] DFA35_eof = DFA.unpackEncodedString(DFA35_eofS);
    static final char[] DFA35_min = DFA.unpackEncodedStringToUnsignedChars(DFA35_minS);
    static final char[] DFA35_max = DFA.unpackEncodedStringToUnsignedChars(DFA35_maxS);
    static final short[] DFA35_accept = DFA.unpackEncodedString(DFA35_acceptS);
    static final short[] DFA35_special = DFA.unpackEncodedString(DFA35_specialS);
    static final short[][] DFA35_transition;

    static {
        int numStates = DFA35_transitionS.length;
        DFA35_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA35_transition[i] = DFA.unpackEncodedString(DFA35_transitionS[i]);
        }
    }

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = DFA35_eot;
            this.eof = DFA35_eof;
            this.min = DFA35_min;
            this.max = DFA35_max;
            this.accept = DFA35_accept;
            this.special = DFA35_special;
            this.transition = DFA35_transition;
        }
        public String getDescription() {
            return "()* loopback of 353:10: ( markup )*";
        }
    }
    static final String DFA47_eotS =
        "\6\uffff";
    static final String DFA47_eofS =
        "\1\uffff\1\2\3\uffff\1\2";
    static final String DFA47_minS =
        "\2\4\2\uffff\2\4";
    static final String DFA47_maxS =
        "\1\56\1\60\2\uffff\1\4\1\60";
    static final String DFA47_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA47_specialS =
        "\6\uffff}>";
    static final String[] DFA47_transitionS = {
            "\1\1\1\uffff\3\2\43\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\31\uffff\1\4\1\uffff\4\3\1\uffff\1\3\2\uffff"+
            "\1\3\1\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\31\uffff\1\4\1\uffff\4\3\1\uffff\1\3\2\uffff"+
            "\1\3\1\uffff\1\3\1\uffff\1\2"
    };

    static final short[] DFA47_eot = DFA.unpackEncodedString(DFA47_eotS);
    static final short[] DFA47_eof = DFA.unpackEncodedString(DFA47_eofS);
    static final char[] DFA47_min = DFA.unpackEncodedStringToUnsignedChars(DFA47_minS);
    static final char[] DFA47_max = DFA.unpackEncodedStringToUnsignedChars(DFA47_maxS);
    static final short[] DFA47_accept = DFA.unpackEncodedString(DFA47_acceptS);
    static final short[] DFA47_special = DFA.unpackEncodedString(DFA47_specialS);
    static final short[][] DFA47_transition;

    static {
        int numStates = DFA47_transitionS.length;
        DFA47_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA47_transition[i] = DFA.unpackEncodedString(DFA47_transitionS[i]);
        }
    }

    class DFA47 extends DFA {

        public DFA47(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 47;
            this.eot = DFA47_eot;
            this.eof = DFA47_eof;
            this.min = DFA47_min;
            this.max = DFA47_max;
            this.accept = DFA47_accept;
            this.special = DFA47_special;
            this.transition = DFA47_transition;
        }
        public String getDescription() {
            return "()* loopback of 353:10: ( markup )*";
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
    public static final BitSet FOLLOW_41_in_regularFormals555 = new BitSet(new long[]{0x0000080000000010L});
    public static final BitSet FOLLOW_IDCON_in_regularFormals559 = new BitSet(new long[]{0x0000080000000010L});
    public static final BitSet FOLLOW_43_in_regularFormals566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_statement579 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_predicate_in_statement581 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement583 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_statement585 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement587 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_50_in_statement598 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_predicate_in_statement600 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement602 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_52_in_statement613 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_statement615 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_statement617 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement619 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_53_in_statement630 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_assignment_in_statement632 = new BitSet(new long[]{0x0040000000000010L});
    public static final BitSet FOLLOW_54_in_statement635 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_statement_in_statement637 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_END_in_statement640 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_46_in_statement651 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statement653 = new BitSet(new long[]{0x03B4C00000002010L});
    public static final BitSet FOLLOW_47_in_statement656 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COMMENT_in_statement667 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRCON_in_statement669 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_55_in_statement680 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement682 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_55_in_statement693 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_statement695 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_56_in_statement706 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement708 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_57_in_statement717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement733 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement735 = new BitSet(new long[]{0x0000040000000010L});
    public static final BitSet FOLLOW_42_in_statement738 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_statement740 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement742 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_statement753 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement755 = new BitSet(new long[]{0x0000040000000010L});
    public static final BitSet FOLLOW_42_in_statement758 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement760 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_statement771 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement773 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_embedding_in_statement776 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement778 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_statement789 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement791 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement794 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_52_in_eachStatement818 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_eachStatement820 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_eachStatement822 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_eachStatement828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_letStatement850 = new BitSet(new long[]{0x0040000000000010L});
    public static final BitSet FOLLOW_assignment_in_letStatement852 = new BitSet(new long[]{0x0040000000000010L});
    public static final BitSet FOLLOW_54_in_letStatement855 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_statement_in_letStatement857 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_END_in_letStatement860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_assignment869 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_assignment871 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_assignment873 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_assignment875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funcBinding_in_assignment881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_funcBinding908 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_regularFormals_in_funcBinding910 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_funcBinding912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_predicate933 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_predicate935 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate944 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate952 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_predicate954 = new BitSet(new long[]{0xC000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_type_in_predicate956 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_60_in_predicate965 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_predicate967 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_61_in_predicate971 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_predicate973 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding1008 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_embed_in_embedding1010 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_textTail_in_embedding1012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed1021 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_embed1024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed1028 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_embed1031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail1039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail1043 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_embed_in_textTail1045 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_textTail_in_textTail1047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_synpred25_WaebricChecker435 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_synpred25_WaebricChecker437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_synpred26_WaebricChecker441 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_synpred26_WaebricChecker443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_synpred30_WaebricChecker579 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_predicate_in_synpred30_WaebricChecker581 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_synpred30_WaebricChecker583 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_synpred30_WaebricChecker585 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_synpred30_WaebricChecker587 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_50_in_synpred31_WaebricChecker598 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_predicate_in_synpred31_WaebricChecker600 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_synpred31_WaebricChecker602 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_55_in_synpred39_WaebricChecker680 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_synpred39_WaebricChecker682 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_55_in_synpred40_WaebricChecker693 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_synpred40_WaebricChecker695 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_synpred43_WaebricChecker724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred45_WaebricChecker733 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred45_WaebricChecker735 = new BitSet(new long[]{0x0000040000000010L});
    public static final BitSet FOLLOW_42_in_synpred45_WaebricChecker738 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_synpred45_WaebricChecker740 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred45_WaebricChecker742 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_synpred47_WaebricChecker753 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred47_WaebricChecker755 = new BitSet(new long[]{0x0000040000000010L});
    public static final BitSet FOLLOW_42_in_synpred47_WaebricChecker758 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_synpred47_WaebricChecker760 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_synpred49_WaebricChecker771 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred49_WaebricChecker773 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_embedding_in_synpred49_WaebricChecker776 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred49_WaebricChecker778 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_synpred55_WaebricChecker944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_synpred56_WaebricChecker965 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_synpred56_WaebricChecker967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred57_WaebricChecker971 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_synpred57_WaebricChecker973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred61_WaebricChecker1021 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_synpred61_WaebricChecker1024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred62_WaebricChecker1028 = new BitSet(new long[]{0x0000000000000002L});

}