// $ANTLR 3.1.2 /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g 2009-08-13 16:06:36

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "MARKUP_STATEMENT", "IDCON", "PATH", "NATCON", "TEXT", "SYMBOLCON", "STRCON", "PRETEXT", "POSTTEXT", "MIDTEXT", "COMMENT", "SITE", "END", "SEMICOLON", "LETTER", "DIGIT", "HEXADECIMAL", "PATHELEMENT", "FILEEXT", "STRCHAR", "ESCLAYOUT", "DECIMAL", "TEXTCHAR", "ESCQUOTE", "AMP", "CHARREF", "ENTREF", "SYMBOLCHAR", "COMMENTS", "LAYOUT", "'module'", "'.'", "'import'", "':'", "'#'", "'$'", "'@'", "'%'", "'('", "','", "')'", "'['", "']'", "'{'", "'}'", "'+'", "'def'", "'if'", "'else'", "'each'", "'let'", "'in'", "'echo'", "'cdata'", "'yield;'", "'='", "'!'", "'&&'", "'||'", "'list'", "'record'", "'string'"
    };
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int LETTER=18;
    public static final int AMP=28;
    public static final int ESCLAYOUT=24;
    public static final int PATHELEMENT=21;
    public static final int PRETEXT=11;
    public static final int STRCON=10;
    public static final int TEXTCHAR=26;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int POSTTEXT=12;
    public static final int EOF=-1;
    public static final int MARKUP_STATEMENT=4;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int FILEEXT=22;
    public static final int T__52=52;
    public static final int COMMENTS=32;
    public static final int CHARREF=29;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int IDCON=5;
    public static final int PATH=6;
    public static final int T__59=59;
    public static final int STRCHAR=23;
    public static final int DIGIT=19;
    public static final int COMMENT=14;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int MIDTEXT=13;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int SYMBOLCON=9;
    public static final int SITE=15;
    public static final int HEXADECIMAL=20;
    public static final int SEMICOLON=17;
    public static final int SYMBOLCHAR=31;
    public static final int TEXT=8;
    public static final int LAYOUT=33;
    public static final int NATCON=7;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int DECIMAL=25;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int ENTREF=30;
    public static final int ESCQUOTE=27;
    public static final int END=16;

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
            string_literal1=(CommonTree)match(input,34,FOLLOW_34_in_module77); if (state.failed) return retval;
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

                if ( (LA1_0==36) ) {
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

                if ( (LA3_0==50) ) {
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

                if ( (LA4_0==35) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:214:6: '.' id= IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal6=(CommonTree)match(input,35,FOLLOW_35_in_moduleId126); if (state.failed) return retval;
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
            string_literal7=(CommonTree)match(input,36,FOLLOW_36_in_imprt151); if (state.failed) return retval;
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
            char_literal18=(CommonTree)match(input,37,FOLLOW_37_in_mapping204); if (state.failed) return retval;
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:233:1: markup : IDCON ( attribute )* ( arguments )? ;
    public final WaebricChecker.markup_return markup() throws RecognitionException {
        WaebricChecker.markup_return retval = new WaebricChecker.markup_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON20=null;
        WaebricChecker.attribute_return attribute21 = null;

        WaebricChecker.arguments_return arguments22 = null;


        CommonTree IDCON20_tree=null;

         int args = 0; 
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:235:2: ( IDCON ( attribute )* ( arguments )? )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:235:5: IDCON ( attribute )* ( arguments )?
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON20=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_markup225); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON20_tree = (CommonTree)adaptor.dupNode(IDCON20);

            adaptor.addChild(root_0, IDCON20_tree);
            }
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:235:11: ( attribute )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==35||(LA7_0>=37 && LA7_0<=40)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: attribute
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_attribute_in_markup227);
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
            	    break loop7;
                }
            } while (true);

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:235:22: ( arguments )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==42) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:235:24: arguments
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_arguments_in_markup232);
                    arguments22=arguments();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, arguments22.getTree());
                    if ( state.backtracking==0 ) {
                       args = (arguments22!=null?arguments22.args:0); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              				// Store function call
              				Call call = new Call();
              				call.id = IDCON20_tree;
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

    public static class attribute_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attribute"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:244:1: attribute : ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON ( '%' NATCON )? );
    public final WaebricChecker.attribute_return attribute() throws RecognitionException {
        WaebricChecker.attribute_return retval = new WaebricChecker.attribute_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal23=null;
        CommonTree IDCON24=null;
        CommonTree char_literal25=null;
        CommonTree IDCON26=null;
        CommonTree char_literal27=null;
        CommonTree IDCON28=null;
        CommonTree char_literal29=null;
        CommonTree IDCON30=null;
        CommonTree char_literal31=null;
        CommonTree NATCON32=null;
        CommonTree char_literal33=null;
        CommonTree NATCON34=null;

        CommonTree char_literal23_tree=null;
        CommonTree IDCON24_tree=null;
        CommonTree char_literal25_tree=null;
        CommonTree IDCON26_tree=null;
        CommonTree char_literal27_tree=null;
        CommonTree IDCON28_tree=null;
        CommonTree char_literal29_tree=null;
        CommonTree IDCON30_tree=null;
        CommonTree char_literal31_tree=null;
        CommonTree NATCON32_tree=null;
        CommonTree char_literal33_tree=null;
        CommonTree NATCON34_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:244:10: ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON ( '%' NATCON )? )
            int alt10=5;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt10=1;
                }
                break;
            case 35:
                {
                alt10=2;
                }
                break;
            case 39:
                {
                alt10=3;
                }
                break;
            case 37:
                {
                alt10=4;
                }
                break;
            case 40:
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:244:13: '#' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal23=(CommonTree)match(input,38,FOLLOW_38_in_attribute250); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal23_tree = (CommonTree)adaptor.dupNode(char_literal23);

                    adaptor.addChild(root_0, char_literal23_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON24=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute252); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON24_tree = (CommonTree)adaptor.dupNode(IDCON24);

                    adaptor.addChild(root_0, IDCON24_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:245:6: '.' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal25=(CommonTree)match(input,35,FOLLOW_35_in_attribute260); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal25_tree = (CommonTree)adaptor.dupNode(char_literal25);

                    adaptor.addChild(root_0, char_literal25_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON26=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute262); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON26_tree = (CommonTree)adaptor.dupNode(IDCON26);

                    adaptor.addChild(root_0, IDCON26_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:246:6: '$' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal27=(CommonTree)match(input,39,FOLLOW_39_in_attribute270); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal27_tree = (CommonTree)adaptor.dupNode(char_literal27);

                    adaptor.addChild(root_0, char_literal27_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON28=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute272); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON28_tree = (CommonTree)adaptor.dupNode(IDCON28);

                    adaptor.addChild(root_0, IDCON28_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:247:6: ':' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal29=(CommonTree)match(input,37,FOLLOW_37_in_attribute280); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal29_tree = (CommonTree)adaptor.dupNode(char_literal29);

                    adaptor.addChild(root_0, char_literal29_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON30=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute282); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON30_tree = (CommonTree)adaptor.dupNode(IDCON30);

                    adaptor.addChild(root_0, IDCON30_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:248:6: '@' NATCON ( '%' NATCON )?
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal31=(CommonTree)match(input,40,FOLLOW_40_in_attribute290); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal31_tree = (CommonTree)adaptor.dupNode(char_literal31);

                    adaptor.addChild(root_0, char_literal31_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    NATCON32=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_attribute292); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON32_tree = (CommonTree)adaptor.dupNode(NATCON32);

                    adaptor.addChild(root_0, NATCON32_tree);
                    }
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:248:17: ( '%' NATCON )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==41) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:248:19: '%' NATCON
                            {
                            _last = (CommonTree)input.LT(1);
                            char_literal33=(CommonTree)match(input,41,FOLLOW_41_in_attribute296); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal33_tree = (CommonTree)adaptor.dupNode(char_literal33);

                            adaptor.addChild(root_0, char_literal33_tree);
                            }
                            _last = (CommonTree)input.LT(1);
                            NATCON34=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_attribute298); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NATCON34_tree = (CommonTree)adaptor.dupNode(NATCON34);

                            adaptor.addChild(root_0, NATCON34_tree);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:250:1: arguments returns [int args = 0] : '(' ( expression )? ( ',' expression )* ')' ;
    public final WaebricChecker.arguments_return arguments() throws RecognitionException {
        WaebricChecker.arguments_return retval = new WaebricChecker.arguments_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal35=null;
        CommonTree char_literal37=null;
        CommonTree char_literal39=null;
        WaebricChecker.expression_return expression36 = null;

        WaebricChecker.expression_return expression38 = null;


        CommonTree char_literal35_tree=null;
        CommonTree char_literal37_tree=null;
        CommonTree char_literal39_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:251:2: ( '(' ( expression )? ( ',' expression )* ')' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:251:5: '(' ( expression )? ( ',' expression )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            char_literal35=(CommonTree)match(input,42,FOLLOW_42_in_arguments316); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal35_tree = (CommonTree)adaptor.dupNode(char_literal35);

            adaptor.addChild(root_0, char_literal35_tree);
            }
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:251:9: ( expression )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==IDCON||(LA11_0>=NATCON && LA11_0<=SYMBOLCON)||LA11_0==45||LA11_0==47) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:251:11: expression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_arguments320);
                    expression36=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression36.getTree());
                    if ( state.backtracking==0 ) {
                      retval.args++;
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:252:4: ( ',' expression )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==43) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:252:6: ',' expression
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal37=(CommonTree)match(input,43,FOLLOW_43_in_arguments333); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal37_tree = (CommonTree)adaptor.dupNode(char_literal37);

            	    adaptor.addChild(root_0, char_literal37_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expression_in_arguments335);
            	    expression38=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, expression38.getTree());
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
            char_literal39=(CommonTree)match(input,44,FOLLOW_44_in_arguments342); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal39_tree = (CommonTree)adaptor.dupNode(char_literal39);

            adaptor.addChild(root_0, char_literal39_tree);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:258:1: expression : ( varExpression | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* ;
    public final WaebricChecker.expression_return expression() throws RecognitionException {
        WaebricChecker.expression_return retval = new WaebricChecker.expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NATCON41=null;
        CommonTree TEXT42=null;
        CommonTree SYMBOLCON43=null;
        CommonTree char_literal44=null;
        CommonTree char_literal46=null;
        CommonTree char_literal48=null;
        CommonTree char_literal49=null;
        CommonTree char_literal51=null;
        CommonTree char_literal53=null;
        CommonTree char_literal54=null;
        CommonTree char_literal56=null;
        CommonTree IDCON57=null;
        WaebricChecker.varExpression_return varExpression40 = null;

        WaebricChecker.expression_return expression45 = null;

        WaebricChecker.expression_return expression47 = null;

        WaebricChecker.keyValuePair_return keyValuePair50 = null;

        WaebricChecker.keyValuePair_return keyValuePair52 = null;

        WaebricChecker.expression_return expression55 = null;


        CommonTree NATCON41_tree=null;
        CommonTree TEXT42_tree=null;
        CommonTree SYMBOLCON43_tree=null;
        CommonTree char_literal44_tree=null;
        CommonTree char_literal46_tree=null;
        CommonTree char_literal48_tree=null;
        CommonTree char_literal49_tree=null;
        CommonTree char_literal51_tree=null;
        CommonTree char_literal53_tree=null;
        CommonTree char_literal54_tree=null;
        CommonTree char_literal56_tree=null;
        CommonTree IDCON57_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:258:11: ( ( varExpression | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:258:14: ( varExpression | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' ) ( '+' expression | '.' IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:258:14: ( varExpression | NATCON | TEXT | SYMBOLCON | '[' ( expression )? ( ',' expression )* ']' | '{' ( keyValuePair )? ( ',' keyValuePair )* '}' )
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
            case 45:
                {
                alt17=5;
                }
                break;
            case 47:
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:258:16: varExpression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_varExpression_in_expression357);
                    varExpression40=varExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, varExpression40.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:258:32: NATCON
                    {
                    _last = (CommonTree)input.LT(1);
                    NATCON41=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_expression361); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON41_tree = (CommonTree)adaptor.dupNode(NATCON41);

                    adaptor.addChild(root_0, NATCON41_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:258:41: TEXT
                    {
                    _last = (CommonTree)input.LT(1);
                    TEXT42=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_expression365); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TEXT42_tree = (CommonTree)adaptor.dupNode(TEXT42);

                    adaptor.addChild(root_0, TEXT42_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:258:48: SYMBOLCON
                    {
                    _last = (CommonTree)input.LT(1);
                    SYMBOLCON43=(CommonTree)match(input,SYMBOLCON,FOLLOW_SYMBOLCON_in_expression369); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SYMBOLCON43_tree = (CommonTree)adaptor.dupNode(SYMBOLCON43);

                    adaptor.addChild(root_0, SYMBOLCON43_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:259:7: '[' ( expression )? ( ',' expression )* ']'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal44=(CommonTree)match(input,45,FOLLOW_45_in_expression378); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal44_tree = (CommonTree)adaptor.dupNode(char_literal44);

                    adaptor.addChild(root_0, char_literal44_tree);
                    }
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:259:11: ( expression )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==IDCON||(LA13_0>=NATCON && LA13_0<=SYMBOLCON)||LA13_0==45||LA13_0==47) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: expression
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_expression_in_expression380);
                            expression45=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, expression45.getTree());

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:259:23: ( ',' expression )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==43) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:259:25: ',' expression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal46=(CommonTree)match(input,43,FOLLOW_43_in_expression385); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal46_tree = (CommonTree)adaptor.dupNode(char_literal46);

                    	    adaptor.addChild(root_0, char_literal46_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_expression_in_expression387);
                    	    expression47=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, expression47.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal48=(CommonTree)match(input,46,FOLLOW_46_in_expression392); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal48_tree = (CommonTree)adaptor.dupNode(char_literal48);

                    adaptor.addChild(root_0, char_literal48_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:260:7: '{' ( keyValuePair )? ( ',' keyValuePair )* '}'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal49=(CommonTree)match(input,47,FOLLOW_47_in_expression401); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal49_tree = (CommonTree)adaptor.dupNode(char_literal49);

                    adaptor.addChild(root_0, char_literal49_tree);
                    }
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:260:11: ( keyValuePair )?
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
                            pushFollow(FOLLOW_keyValuePair_in_expression403);
                            keyValuePair50=keyValuePair();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, keyValuePair50.getTree());

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:260:25: ( ',' keyValuePair )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==43) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:260:27: ',' keyValuePair
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal51=(CommonTree)match(input,43,FOLLOW_43_in_expression408); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal51_tree = (CommonTree)adaptor.dupNode(char_literal51);

                    	    adaptor.addChild(root_0, char_literal51_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_keyValuePair_in_expression410);
                    	    keyValuePair52=keyValuePair();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, keyValuePair52.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal53=(CommonTree)match(input,48,FOLLOW_48_in_expression415); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal53_tree = (CommonTree)adaptor.dupNode(char_literal53);

                    adaptor.addChild(root_0, char_literal53_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:261:6: ( '+' expression | '.' IDCON )*
            loop18:
            do {
                int alt18=3;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==49) ) {
                    int LA18_2 = input.LA(2);

                    if ( (synpred25_WaebricChecker()) ) {
                        alt18=1;
                    }


                }
                else if ( (LA18_0==35) ) {
                    int LA18_3 = input.LA(2);

                    if ( (synpred26_WaebricChecker()) ) {
                        alt18=2;
                    }


                }


                switch (alt18) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:261:8: '+' expression
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal54=(CommonTree)match(input,49,FOLLOW_49_in_expression425); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal54_tree = (CommonTree)adaptor.dupNode(char_literal54);

            	    adaptor.addChild(root_0, char_literal54_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expression_in_expression427);
            	    expression55=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, expression55.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:261:25: '.' IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal56=(CommonTree)match(input,35,FOLLOW_35_in_expression431); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal56_tree = (CommonTree)adaptor.dupNode(char_literal56);

            	    adaptor.addChild(root_0, char_literal56_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    IDCON57=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression433); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDCON57_tree = (CommonTree)adaptor.dupNode(IDCON57);

            	    adaptor.addChild(root_0, IDCON57_tree);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:263:1: varExpression : IDCON ;
    public final WaebricChecker.varExpression_return varExpression() throws RecognitionException {
        WaebricChecker.varExpression_return retval = new WaebricChecker.varExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON58=null;

        CommonTree IDCON58_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:263:14: ( IDCON )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:263:17: IDCON
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON58=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_varExpression445); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON58_tree = (CommonTree)adaptor.dupNode(IDCON58);

            adaptor.addChild(root_0, IDCON58_tree);
            }
            if ( state.backtracking==0 ) {

              				if(! isDefinedVariable(IDCON58.getText())) {
              					exceptions.add(new UndefinedVariableException(IDCON58_tree));
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:269:1: keyValuePair : IDCON ':' expression ;
    public final WaebricChecker.keyValuePair_return keyValuePair() throws RecognitionException {
        WaebricChecker.keyValuePair_return retval = new WaebricChecker.keyValuePair_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON59=null;
        CommonTree char_literal60=null;
        WaebricChecker.expression_return expression61 = null;


        CommonTree IDCON59_tree=null;
        CommonTree char_literal60_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:269:13: ( IDCON ':' expression )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:269:16: IDCON ':' expression
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON59=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_keyValuePair459); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON59_tree = (CommonTree)adaptor.dupNode(IDCON59);

            adaptor.addChild(root_0, IDCON59_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal60=(CommonTree)match(input,37,FOLLOW_37_in_keyValuePair461); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal60_tree = (CommonTree)adaptor.dupNode(char_literal60);

            adaptor.addChild(root_0, char_literal60_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_keyValuePair463);
            expression61=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, expression61.getTree());

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:273:1: function : 'def' IDCON formals ( statement )* 'end' ;
    public final WaebricChecker.function_return function() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.function_return retval = new WaebricChecker.function_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal62=null;
        CommonTree IDCON63=null;
        CommonTree string_literal66=null;
        WaebricChecker.formals_return formals64 = null;

        WaebricChecker.statement_return statement65 = null;


        CommonTree string_literal62_tree=null;
        CommonTree IDCON63_tree=null;
        CommonTree string_literal66_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new HashSet<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:278:4: ( 'def' IDCON formals ( statement )* 'end' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:278:7: 'def' IDCON formals ( statement )* 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal62=(CommonTree)match(input,50,FOLLOW_50_in_function487); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal62_tree = (CommonTree)adaptor.dupNode(string_literal62);

            adaptor.addChild(root_0, string_literal62_tree);
            }
            _last = (CommonTree)input.LT(1);
            IDCON63=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_function489); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON63_tree = (CommonTree)adaptor.dupNode(IDCON63);

            adaptor.addChild(root_0, IDCON63_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_formals_in_function491);
            formals64=formals();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, formals64.getTree());
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:278:27: ( statement )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==MARKUP_STATEMENT||LA19_0==COMMENT||LA19_0==47||LA19_0==51||(LA19_0>=53 && LA19_0<=54)||(LA19_0>=56 && LA19_0<=58)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_function493);
            	    statement65=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, statement65.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            string_literal66=(CommonTree)match(input,END,FOLLOW_END_in_function496); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal66_tree = (CommonTree)adaptor.dupNode(string_literal66);

            adaptor.addChild(root_0, string_literal66_tree);
            }
            if ( state.backtracking==0 ) {
               
              				defineFunction(IDCON63, (formals64!=null?formals64.args:0), 0);
              			
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:282:1: formals returns [int args = 0] : ( regularFormals | );
    public final WaebricChecker.formals_return formals() throws RecognitionException {
        WaebricChecker.formals_return retval = new WaebricChecker.formals_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricChecker.regularFormals_return regularFormals67 = null;



        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:282:32: ( regularFormals | )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==42) ) {
                alt20=1;
            }
            else if ( (LA20_0==MARKUP_STATEMENT||LA20_0==COMMENT||LA20_0==END||LA20_0==47||LA20_0==51||(LA20_0>=53 && LA20_0<=54)||(LA20_0>=56 && LA20_0<=58)) ) {
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:283:4: regularFormals
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_regularFormals_in_formals517);
                    regularFormals67=regularFormals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, regularFormals67.getTree());
                    if ( state.backtracking==0 ) {
                       retval.args = (regularFormals67!=null?regularFormals67.args:0); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:283:55: 
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:285:1: regularFormals returns [int args = 0] : '(' ( IDCON )* ')' ;
    public final WaebricChecker.regularFormals_return regularFormals() throws RecognitionException {
        WaebricChecker.regularFormals_return retval = new WaebricChecker.regularFormals_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal68=null;
        CommonTree IDCON69=null;
        CommonTree char_literal70=null;

        CommonTree char_literal68_tree=null;
        CommonTree IDCON69_tree=null;
        CommonTree char_literal70_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:285:38: ( '(' ( IDCON )* ')' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:286:4: '(' ( IDCON )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            char_literal68=(CommonTree)match(input,42,FOLLOW_42_in_regularFormals539); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal68_tree = (CommonTree)adaptor.dupNode(char_literal68);

            adaptor.addChild(root_0, char_literal68_tree);
            }
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:286:8: ( IDCON )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==IDCON) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:286:10: IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    IDCON69=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_regularFormals543); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDCON69_tree = (CommonTree)adaptor.dupNode(IDCON69);

            	    adaptor.addChild(root_0, IDCON69_tree);
            	    }
            	    if ( state.backtracking==0 ) {
            	       defineVariable(IDCON69.getText()); retval.args++; 
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
            char_literal70=(CommonTree)match(input,44,FOLLOW_44_in_regularFormals550); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal70_tree = (CommonTree)adaptor.dupNode(char_literal70);

            adaptor.addChild(root_0, char_literal70_tree);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:290:1: statement : ( ^( 'if' '(' predicate ')' statement ( 'else' statement )? ) | eachStatement | letStatement | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ^( MARKUP_STATEMENT ( markup )+ statement ) | ^( MARKUP_STATEMENT ( markup )+ embedding ) | ^( MARKUP_STATEMENT ( markup )+ ';' ) );
    public final WaebricChecker.statement_return statement() throws RecognitionException {
        WaebricChecker.statement_return retval = new WaebricChecker.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal71=null;
        CommonTree char_literal72=null;
        CommonTree char_literal74=null;
        CommonTree string_literal76=null;
        CommonTree char_literal80=null;
        CommonTree char_literal82=null;
        CommonTree string_literal83=null;
        CommonTree STRCON84=null;
        CommonTree char_literal85=null;
        CommonTree string_literal86=null;
        CommonTree char_literal88=null;
        CommonTree string_literal89=null;
        CommonTree char_literal91=null;
        CommonTree string_literal92=null;
        CommonTree char_literal94=null;
        CommonTree string_literal95=null;
        CommonTree MARKUP_STATEMENT96=null;
        CommonTree char_literal99=null;
        CommonTree MARKUP_STATEMENT100=null;
        CommonTree MARKUP_STATEMENT103=null;
        CommonTree MARKUP_STATEMENT106=null;
        CommonTree char_literal108=null;
        WaebricChecker.predicate_return predicate73 = null;

        WaebricChecker.statement_return statement75 = null;

        WaebricChecker.statement_return statement77 = null;

        WaebricChecker.eachStatement_return eachStatement78 = null;

        WaebricChecker.letStatement_return letStatement79 = null;

        WaebricChecker.statement_return statement81 = null;

        WaebricChecker.expression_return expression87 = null;

        WaebricChecker.embedding_return embedding90 = null;

        WaebricChecker.expression_return expression93 = null;

        WaebricChecker.markup_return markup97 = null;

        WaebricChecker.expression_return expression98 = null;

        WaebricChecker.markup_return markup101 = null;

        WaebricChecker.statement_return statement102 = null;

        WaebricChecker.markup_return markup104 = null;

        WaebricChecker.embedding_return embedding105 = null;

        WaebricChecker.markup_return markup107 = null;


        CommonTree string_literal71_tree=null;
        CommonTree char_literal72_tree=null;
        CommonTree char_literal74_tree=null;
        CommonTree string_literal76_tree=null;
        CommonTree char_literal80_tree=null;
        CommonTree char_literal82_tree=null;
        CommonTree string_literal83_tree=null;
        CommonTree STRCON84_tree=null;
        CommonTree char_literal85_tree=null;
        CommonTree string_literal86_tree=null;
        CommonTree char_literal88_tree=null;
        CommonTree string_literal89_tree=null;
        CommonTree char_literal91_tree=null;
        CommonTree string_literal92_tree=null;
        CommonTree char_literal94_tree=null;
        CommonTree string_literal95_tree=null;
        CommonTree MARKUP_STATEMENT96_tree=null;
        CommonTree char_literal99_tree=null;
        CommonTree MARKUP_STATEMENT100_tree=null;
        CommonTree MARKUP_STATEMENT103_tree=null;
        CommonTree MARKUP_STATEMENT106_tree=null;
        CommonTree char_literal108_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:290:10: ( ^( 'if' '(' predicate ')' statement ( 'else' statement )? ) | eachStatement | letStatement | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ^( MARKUP_STATEMENT ( markup )+ statement ) | ^( MARKUP_STATEMENT ( markup )+ embedding ) | ^( MARKUP_STATEMENT ( markup )+ ';' ) )
            int alt28=13;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:290:13: ^( 'if' '(' predicate ')' statement ( 'else' statement )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal71=(CommonTree)match(input,51,FOLLOW_51_in_statement563); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal71_tree = (CommonTree)adaptor.dupNode(string_literal71);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal71_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    char_literal72=(CommonTree)match(input,42,FOLLOW_42_in_statement565); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal72_tree = (CommonTree)adaptor.dupNode(char_literal72);

                    adaptor.addChild(root_1, char_literal72_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_statement567);
                    predicate73=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, predicate73.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal74=(CommonTree)match(input,44,FOLLOW_44_in_statement569); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal74_tree = (CommonTree)adaptor.dupNode(char_literal74);

                    adaptor.addChild(root_1, char_literal74_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement571);
                    statement75=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement75.getTree());
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:290:49: ( 'else' statement )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==52) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:290:51: 'else' statement
                            {
                            _last = (CommonTree)input.LT(1);
                            string_literal76=(CommonTree)match(input,52,FOLLOW_52_in_statement575); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal76_tree = (CommonTree)adaptor.dupNode(string_literal76);

                            adaptor.addChild(root_1, string_literal76_tree);
                            }
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_statement_in_statement577);
                            statement77=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, statement77.getTree());

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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:291:6: eachStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_eachStatement_in_statement589);
                    eachStatement78=eachStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, eachStatement78.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:292:6: letStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_letStatement_in_statement596);
                    letStatement79=letStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, letStatement79.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:293:6: ^( '{' ( statement )* '}' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    char_literal80=(CommonTree)match(input,47,FOLLOW_47_in_statement605); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal80_tree = (CommonTree)adaptor.dupNode(char_literal80);

                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal80_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:293:13: ( statement )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==MARKUP_STATEMENT||LA23_0==COMMENT||LA23_0==47||LA23_0==51||(LA23_0>=53 && LA23_0<=54)||(LA23_0>=56 && LA23_0<=58)) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: statement
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_statement_in_statement607);
                    	    statement81=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, statement81.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal82=(CommonTree)match(input,48,FOLLOW_48_in_statement610); if (state.failed) return retval;
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
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:294:6: ^( 'comment' STRCON ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal83=(CommonTree)match(input,COMMENT,FOLLOW_COMMENT_in_statement621); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal83_tree = (CommonTree)adaptor.dupNode(string_literal83);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal83_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    STRCON84=(CommonTree)match(input,STRCON,FOLLOW_STRCON_in_statement623); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRCON84_tree = (CommonTree)adaptor.dupNode(STRCON84);

                    adaptor.addChild(root_1, STRCON84_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal85=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement625); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal85_tree = (CommonTree)adaptor.dupNode(char_literal85);

                    adaptor.addChild(root_1, char_literal85_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:295:6: ^( 'echo' expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal86=(CommonTree)match(input,56,FOLLOW_56_in_statement636); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal86_tree = (CommonTree)adaptor.dupNode(string_literal86);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal86_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement638);
                    expression87=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression87.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal88=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement640); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal88_tree = (CommonTree)adaptor.dupNode(char_literal88);

                    adaptor.addChild(root_1, char_literal88_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:296:6: ^( 'echo' embedding ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal89=(CommonTree)match(input,56,FOLLOW_56_in_statement651); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal89_tree = (CommonTree)adaptor.dupNode(string_literal89);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal89_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement653);
                    embedding90=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding90.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal91=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement655); if (state.failed) return retval;
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
                case 8 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:297:6: ^( 'cdata' expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal92=(CommonTree)match(input,57,FOLLOW_57_in_statement666); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal92_tree = (CommonTree)adaptor.dupNode(string_literal92);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal92_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement668);
                    expression93=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression93.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal94=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement670); if (state.failed) return retval;
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
                case 9 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:298:6: 'yield;'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal95=(CommonTree)match(input,58,FOLLOW_58_in_statement679); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal95_tree = (CommonTree)adaptor.dupNode(string_literal95);

                    adaptor.addChild(root_0, string_literal95_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:299:6: ^( MARKUP_STATEMENT ( markup )+ expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT96=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement688); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT96_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT96);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT96_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:299:26: ( markup )+
                    int cnt24=0;
                    loop24:
                    do {
                        int alt24=2;
                        alt24 = dfa24.predict(input);
                        switch (alt24) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement690);
                    	    markup97=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup97.getTree());

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
                    pushFollow(FOLLOW_expression_in_statement693);
                    expression98=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression98.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal99=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement695); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal99_tree = (CommonTree)adaptor.dupNode(char_literal99);

                    adaptor.addChild(root_1, char_literal99_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:300:6: ^( MARKUP_STATEMENT ( markup )+ statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT100=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement706); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT100_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT100);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT100_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:300:26: ( markup )+
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
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement708);
                    	    markup101=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup101.getTree());

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
                    pushFollow(FOLLOW_statement_in_statement711);
                    statement102=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement102.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:301:6: ^( MARKUP_STATEMENT ( markup )+ embedding )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT103=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement722); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT103_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT103);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT103_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:301:26: ( markup )+
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
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement724);
                    	    markup104=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup104.getTree());

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
                    pushFollow(FOLLOW_embedding_in_statement727);
                    embedding105=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding105.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:302:6: ^( MARKUP_STATEMENT ( markup )+ ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT106=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement738); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT106_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT106);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT106_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:302:26: ( markup )+
                    int cnt27=0;
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
                    	    pushFollow(FOLLOW_markup_in_statement740);
                    	    markup107=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup107.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
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

                    _last = (CommonTree)input.LT(1);
                    char_literal108=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement743); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal108_tree = (CommonTree)adaptor.dupNode(char_literal108);

                    adaptor.addChild(root_1, char_literal108_tree);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:304:1: eachStatement : ^( 'each' '(' IDCON ':' expression ')' statement ) ;
    public final WaebricChecker.eachStatement_return eachStatement() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.eachStatement_return retval = new WaebricChecker.eachStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal109=null;
        CommonTree char_literal110=null;
        CommonTree IDCON111=null;
        CommonTree char_literal112=null;
        CommonTree char_literal114=null;
        WaebricChecker.expression_return expression113 = null;

        WaebricChecker.statement_return statement115 = null;


        CommonTree string_literal109_tree=null;
        CommonTree char_literal110_tree=null;
        CommonTree IDCON111_tree=null;
        CommonTree char_literal112_tree=null;
        CommonTree char_literal114_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new HashSet<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:309:4: ( ^( 'each' '(' IDCON ':' expression ')' statement ) )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:309:7: ^( 'each' '(' IDCON ':' expression ')' statement )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal109=(CommonTree)match(input,53,FOLLOW_53_in_eachStatement769); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal109_tree = (CommonTree)adaptor.dupNode(string_literal109);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal109_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            char_literal110=(CommonTree)match(input,42,FOLLOW_42_in_eachStatement771); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal110_tree = (CommonTree)adaptor.dupNode(char_literal110);

            adaptor.addChild(root_1, char_literal110_tree);
            }
            _last = (CommonTree)input.LT(1);
            IDCON111=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_eachStatement773); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON111_tree = (CommonTree)adaptor.dupNode(IDCON111);

            adaptor.addChild(root_1, IDCON111_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal112=(CommonTree)match(input,37,FOLLOW_37_in_eachStatement775); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal112_tree = (CommonTree)adaptor.dupNode(char_literal112);

            adaptor.addChild(root_1, char_literal112_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_eachStatement777);
            expression113=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expression113.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal114=(CommonTree)match(input,44,FOLLOW_44_in_eachStatement779); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal114_tree = (CommonTree)adaptor.dupNode(char_literal114);

            adaptor.addChild(root_1, char_literal114_tree);
            }
            if ( state.backtracking==0 ) {
               
              				defineVariable(IDCON111.getText()); // Define variable before statement is executed
              			
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_eachStatement783);
            statement115=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, statement115.getTree());

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:313:1: letStatement : ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) ;
    public final WaebricChecker.letStatement_return letStatement() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.letStatement_return retval = new WaebricChecker.letStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal116=null;
        CommonTree string_literal118=null;
        CommonTree string_literal120=null;
        WaebricChecker.assignment_return assignment117 = null;

        WaebricChecker.statement_return statement119 = null;


        CommonTree string_literal116_tree=null;
        CommonTree string_literal118_tree=null;
        CommonTree string_literal120_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new HashSet<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:318:4: ( ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:318:7: ^( 'let' ( assignment )+ 'in' ( statement )* 'end' )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal116=(CommonTree)match(input,54,FOLLOW_54_in_letStatement809); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal116_tree = (CommonTree)adaptor.dupNode(string_literal116);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal116_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:318:16: ( assignment )+
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
            	    pushFollow(FOLLOW_assignment_in_letStatement811);
            	    assignment117=assignment();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, assignment117.getTree());

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
            string_literal118=(CommonTree)match(input,55,FOLLOW_55_in_letStatement814); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal118_tree = (CommonTree)adaptor.dupNode(string_literal118);

            adaptor.addChild(root_1, string_literal118_tree);
            }
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:318:33: ( statement )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==MARKUP_STATEMENT||LA30_0==COMMENT||LA30_0==47||LA30_0==51||(LA30_0>=53 && LA30_0<=54)||(LA30_0>=56 && LA30_0<=58)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_letStatement816);
            	    statement119=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, statement119.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            string_literal120=(CommonTree)match(input,END,FOLLOW_END_in_letStatement819); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal120_tree = (CommonTree)adaptor.dupNode(string_literal120);

            adaptor.addChild(root_1, string_literal120_tree);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:320:1: assignment : ( IDCON '=' expression ';' | funcBinding );
    public final WaebricChecker.assignment_return assignment() throws RecognitionException {
        WaebricChecker.assignment_return retval = new WaebricChecker.assignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON121=null;
        CommonTree char_literal122=null;
        CommonTree char_literal124=null;
        WaebricChecker.expression_return expression123 = null;

        WaebricChecker.funcBinding_return funcBinding125 = null;


        CommonTree IDCON121_tree=null;
        CommonTree char_literal122_tree=null;
        CommonTree char_literal124_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:320:11: ( IDCON '=' expression ';' | funcBinding )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==IDCON) ) {
                int LA31_1 = input.LA(2);

                if ( (LA31_1==59) ) {
                    alt31=1;
                }
                else if ( (LA31_1==42) ) {
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:320:14: IDCON '=' expression ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDCON121=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_assignment830); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON121_tree = (CommonTree)adaptor.dupNode(IDCON121);

                    adaptor.addChild(root_0, IDCON121_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal122=(CommonTree)match(input,59,FOLLOW_59_in_assignment832); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal122_tree = (CommonTree)adaptor.dupNode(char_literal122);

                    adaptor.addChild(root_0, char_literal122_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_assignment834);
                    expression123=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression123.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal124=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_assignment836); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal124_tree = (CommonTree)adaptor.dupNode(char_literal124);

                    adaptor.addChild(root_0, char_literal124_tree);
                    }
                    if ( state.backtracking==0 ) {
                       
                      				defineVariable(IDCON121.getText()); 
                      			
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:322:8: funcBinding
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_funcBinding_in_assignment842);
                    funcBinding125=funcBinding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, funcBinding125.getTree());

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:324:1: funcBinding : IDCON regularFormals statement ;
    public final WaebricChecker.funcBinding_return funcBinding() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricChecker.funcBinding_return retval = new WaebricChecker.funcBinding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON126=null;
        WaebricChecker.regularFormals_return regularFormals127 = null;

        WaebricChecker.statement_return statement128 = null;


        CommonTree IDCON126_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new HashSet<String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        		int parent = Environment_stack.size()-1;
        	
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:330:4: ( IDCON regularFormals statement )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:330:8: IDCON regularFormals statement
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON126=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_funcBinding869); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON126_tree = (CommonTree)adaptor.dupNode(IDCON126);

            adaptor.addChild(root_0, IDCON126_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_regularFormals_in_funcBinding871);
            regularFormals127=regularFormals();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, regularFormals127.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_statement_in_funcBinding873);
            statement128=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, statement128.getTree());
            if ( state.backtracking==0 ) {

              				defineFunction(IDCON126, (regularFormals127!=null?regularFormals127.args:0), parent);
              			
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:337:1: predicate : ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )* ;
    public final WaebricChecker.predicate_return predicate() throws RecognitionException {
        WaebricChecker.predicate_return retval = new WaebricChecker.predicate_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal129=null;
        CommonTree char_literal133=null;
        CommonTree string_literal135=null;
        CommonTree string_literal137=null;
        WaebricChecker.predicate_return predicate130 = null;

        WaebricChecker.expression_return expression131 = null;

        WaebricChecker.expression_return expression132 = null;

        WaebricChecker.type_return type134 = null;

        WaebricChecker.predicate_return predicate136 = null;

        WaebricChecker.predicate_return predicate138 = null;


        CommonTree char_literal129_tree=null;
        CommonTree char_literal133_tree=null;
        CommonTree string_literal135_tree=null;
        CommonTree string_literal137_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:337:10: ( ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:337:13: ( '!' predicate | expression | expression '.' type ) ( '&&' predicate | '||' predicate )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:337:13: ( '!' predicate | expression | expression '.' type )
            int alt32=3;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:337:15: '!' predicate
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal129=(CommonTree)match(input,60,FOLLOW_60_in_predicate894); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal129_tree = (CommonTree)adaptor.dupNode(char_literal129);

                    adaptor.addChild(root_0, char_literal129_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_predicate896);
                    predicate130=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, predicate130.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:338:7: expression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate905);
                    expression131=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression131.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:339:7: expression '.' type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate913);
                    expression132=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression132.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal133=(CommonTree)match(input,35,FOLLOW_35_in_predicate915); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal133_tree = (CommonTree)adaptor.dupNode(char_literal133);

                    adaptor.addChild(root_0, char_literal133_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_predicate917);
                    type134=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, type134.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:340:6: ( '&&' predicate | '||' predicate )*
            loop33:
            do {
                int alt33=3;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==61) ) {
                    int LA33_2 = input.LA(2);

                    if ( (synpred53_WaebricChecker()) ) {
                        alt33=1;
                    }


                }
                else if ( (LA33_0==62) ) {
                    int LA33_3 = input.LA(2);

                    if ( (synpred54_WaebricChecker()) ) {
                        alt33=2;
                    }


                }


                switch (alt33) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:340:8: '&&' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal135=(CommonTree)match(input,61,FOLLOW_61_in_predicate926); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal135_tree = (CommonTree)adaptor.dupNode(string_literal135);

            	    adaptor.addChild(root_0, string_literal135_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate928);
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
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:340:25: '||' predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal137=(CommonTree)match(input,62,FOLLOW_62_in_predicate932); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal137_tree = (CommonTree)adaptor.dupNode(string_literal137);

            	    adaptor.addChild(root_0, string_literal137_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate934);
            	    predicate138=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, predicate138.getTree());

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:341:1: type : ( 'list' | 'record' | 'string' );
    public final WaebricChecker.type_return type() throws RecognitionException {
        WaebricChecker.type_return retval = new WaebricChecker.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set139=null;

        CommonTree set139_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:341:5: ( 'list' | 'record' | 'string' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            set139=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=63 && input.LA(1)<=65) ) {
                input.consume();

                if ( state.backtracking==0 ) {
                set139_tree = (CommonTree)adaptor.dupNode(set139);

                adaptor.addChild(root_0, set139_tree);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:347:1: embedding : PRETEXT embed textTail ;
    public final WaebricChecker.embedding_return embedding() throws RecognitionException {
        WaebricChecker.embedding_return retval = new WaebricChecker.embedding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PRETEXT140=null;
        WaebricChecker.embed_return embed141 = null;

        WaebricChecker.textTail_return textTail142 = null;


        CommonTree PRETEXT140_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:347:10: ( PRETEXT embed textTail )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:347:13: PRETEXT embed textTail
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PRETEXT140=(CommonTree)match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding969); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRETEXT140_tree = (CommonTree)adaptor.dupNode(PRETEXT140);

            adaptor.addChild(root_0, PRETEXT140_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_embed_in_embedding971);
            embed141=embed();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, embed141.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_textTail_in_embedding973);
            textTail142=textTail();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, textTail142.getTree());

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:348:1: embed : ( ( markup )* expression | ( markup )* markup );
    public final WaebricChecker.embed_return embed() throws RecognitionException {
        WaebricChecker.embed_return retval = new WaebricChecker.embed_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricChecker.markup_return markup143 = null;

        WaebricChecker.expression_return expression144 = null;

        WaebricChecker.markup_return markup145 = null;

        WaebricChecker.markup_return markup146 = null;



        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:348:6: ( ( markup )* expression | ( markup )* markup )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==IDCON) ) {
                int LA36_1 = input.LA(2);

                if ( (synpred58_WaebricChecker()) ) {
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
            else if ( ((LA36_0>=NATCON && LA36_0<=SYMBOLCON)||LA36_0==45||LA36_0==47) ) {
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:348:10: ( markup )* expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:348:10: ( markup )*
                    loop34:
                    do {
                        int alt34=2;
                        alt34 = dfa34.predict(input);
                        switch (alt34) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed982);
                    	    markup143=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup143.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_embed985);
                    expression144=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression144.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:348:31: ( markup )* markup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:348:31: ( markup )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==IDCON) ) {
                            int LA35_1 = input.LA(2);

                            if ( (synpred59_WaebricChecker()) ) {
                                alt35=1;
                            }


                        }


                        switch (alt35) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed989);
                    	    markup145=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup145.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop35;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_embed992);
                    markup146=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, markup146.getTree());

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:349:1: textTail : ( POSTTEXT | MIDTEXT embed textTail );
    public final WaebricChecker.textTail_return textTail() throws RecognitionException {
        WaebricChecker.textTail_return retval = new WaebricChecker.textTail_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POSTTEXT147=null;
        CommonTree MIDTEXT148=null;
        WaebricChecker.embed_return embed149 = null;

        WaebricChecker.textTail_return textTail150 = null;


        CommonTree POSTTEXT147_tree=null;
        CommonTree MIDTEXT148_tree=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:349:9: ( POSTTEXT | MIDTEXT embed textTail )
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:349:12: POSTTEXT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    POSTTEXT147=(CommonTree)match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail1000); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    POSTTEXT147_tree = (CommonTree)adaptor.dupNode(POSTTEXT147);

                    adaptor.addChild(root_0, POSTTEXT147_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:349:23: MIDTEXT embed textTail
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    MIDTEXT148=(CommonTree)match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail1004); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MIDTEXT148_tree = (CommonTree)adaptor.dupNode(MIDTEXT148);

                    adaptor.addChild(root_0, MIDTEXT148_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embed_in_textTail1006);
                    embed149=embed();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, embed149.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_textTail_in_textTail1008);
                    textTail150=textTail();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, textTail150.getTree());

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
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:261:8: ( '+' expression )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:261:8: '+' expression
        {
        match(input,49,FOLLOW_49_in_synpred25_WaebricChecker425); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred25_WaebricChecker427);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_WaebricChecker

    // $ANTLR start synpred26_WaebricChecker
    public final void synpred26_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:261:25: ( '.' IDCON )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:261:25: '.' IDCON
        {
        match(input,35,FOLLOW_35_in_synpred26_WaebricChecker431); if (state.failed) return ;
        match(input,IDCON,FOLLOW_IDCON_in_synpred26_WaebricChecker433); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_WaebricChecker

    // $ANTLR start synpred37_WaebricChecker
    public final void synpred37_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:295:6: ( ^( 'echo' expression ';' ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:295:6: ^( 'echo' expression ';' )
        {
        match(input,56,FOLLOW_56_in_synpred37_WaebricChecker636); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred37_WaebricChecker638);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred37_WaebricChecker640); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred37_WaebricChecker

    // $ANTLR start synpred38_WaebricChecker
    public final void synpred38_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:296:6: ( ^( 'echo' embedding ';' ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:296:6: ^( 'echo' embedding ';' )
        {
        match(input,56,FOLLOW_56_in_synpred38_WaebricChecker651); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_embedding_in_synpred38_WaebricChecker653);
        embedding();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred38_WaebricChecker655); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred38_WaebricChecker

    // $ANTLR start synpred42_WaebricChecker
    public final void synpred42_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:299:6: ( ^( MARKUP_STATEMENT ( markup )+ expression ';' ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:299:6: ^( MARKUP_STATEMENT ( markup )+ expression ';' )
        {
        match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_synpred42_WaebricChecker688); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:299:26: ( markup )+
        int cnt42=0;
        loop42:
        do {
            int alt42=2;
            alt42 = dfa42.predict(input);
            switch (alt42) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred42_WaebricChecker690);
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

        pushFollow(FOLLOW_expression_in_synpred42_WaebricChecker693);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred42_WaebricChecker695); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred42_WaebricChecker

    // $ANTLR start synpred44_WaebricChecker
    public final void synpred44_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:300:6: ( ^( MARKUP_STATEMENT ( markup )+ statement ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:300:6: ^( MARKUP_STATEMENT ( markup )+ statement )
        {
        match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_synpred44_WaebricChecker706); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:300:26: ( markup )+
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
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred44_WaebricChecker708);
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

        pushFollow(FOLLOW_statement_in_synpred44_WaebricChecker711);
        statement();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred44_WaebricChecker

    // $ANTLR start synpred46_WaebricChecker
    public final void synpred46_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:301:6: ( ^( MARKUP_STATEMENT ( markup )+ embedding ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:301:6: ^( MARKUP_STATEMENT ( markup )+ embedding )
        {
        match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_synpred46_WaebricChecker722); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:301:26: ( markup )+
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
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred46_WaebricChecker724);
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

        pushFollow(FOLLOW_embedding_in_synpred46_WaebricChecker727);
        embedding();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_WaebricChecker

    // $ANTLR start synpred52_WaebricChecker
    public final void synpred52_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:338:7: ( expression )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:338:7: expression
        {
        pushFollow(FOLLOW_expression_in_synpred52_WaebricChecker905);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred52_WaebricChecker

    // $ANTLR start synpred53_WaebricChecker
    public final void synpred53_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:340:8: ( '&&' predicate )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:340:8: '&&' predicate
        {
        match(input,61,FOLLOW_61_in_synpred53_WaebricChecker926); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred53_WaebricChecker928);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred53_WaebricChecker

    // $ANTLR start synpred54_WaebricChecker
    public final void synpred54_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:340:25: ( '||' predicate )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:340:25: '||' predicate
        {
        match(input,62,FOLLOW_62_in_synpred54_WaebricChecker932); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred54_WaebricChecker934);
        predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred54_WaebricChecker

    // $ANTLR start synpred58_WaebricChecker
    public final void synpred58_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:348:10: ( ( markup )* expression )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:348:10: ( markup )* expression
        {
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:348:10: ( markup )*
        loop45:
        do {
            int alt45=2;
            alt45 = dfa45.predict(input);
            switch (alt45) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred58_WaebricChecker982);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop45;
            }
        } while (true);

        pushFollow(FOLLOW_expression_in_synpred58_WaebricChecker985);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred58_WaebricChecker

    // $ANTLR start synpred59_WaebricChecker
    public final void synpred59_WaebricChecker_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:348:31: ( markup )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:348:31: markup
        {
        pushFollow(FOLLOW_markup_in_synpred59_WaebricChecker989);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred59_WaebricChecker

    // Delegated rules

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


    protected DFA28 dfa28 = new DFA28(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA34 dfa34 = new DFA34(this);
    protected DFA42 dfa42 = new DFA42(this);
    protected DFA45 dfa45 = new DFA45(this);
    static final String DFA28_eotS =
        "\20\uffff";
    static final String DFA28_eofS =
        "\20\uffff";
    static final String DFA28_minS =
        "\1\4\5\uffff\1\0\2\uffff\1\0\6\uffff";
    static final String DFA28_maxS =
        "\1\72\5\uffff\1\0\2\uffff\1\0\6\uffff";
    static final String DFA28_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\11\1\uffff\1\6\1\7\1"+
        "\12\1\13\1\14\1\15";
    static final String DFA28_specialS =
        "\6\uffff\1\0\2\uffff\1\1\6\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\11\11\uffff\1\5\40\uffff\1\4\3\uffff\1\1\1\uffff\1\2\1\3"+
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
            return "290:1: statement : ( ^( 'if' '(' predicate ')' statement ( 'else' statement )? ) | eachStatement | letStatement | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ^( MARKUP_STATEMENT ( markup )+ statement ) | ^( MARKUP_STATEMENT ( markup )+ embedding ) | ^( MARKUP_STATEMENT ( markup )+ ';' ) );";
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
                        if ( (synpred42_WaebricChecker()) ) {s = 12;}

                        else if ( (synpred44_WaebricChecker()) ) {s = 13;}

                        else if ( (synpred46_WaebricChecker()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
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
    static final String DFA24_eotS =
        "\6\uffff";
    static final String DFA24_eofS =
        "\6\uffff";
    static final String DFA24_minS =
        "\2\5\2\uffff\2\5";
    static final String DFA24_maxS =
        "\1\57\1\61\2\uffff\1\5\1\61";
    static final String DFA24_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA24_specialS =
        "\6\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\1\1\uffff\3\2\43\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\7\uffff\1\2\21\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\7\uffff\1\2\21\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\2"
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
            return "()+ loopback of 299:26: ( markup )+";
        }
    }
    static final String DFA32_eotS =
        "\12\uffff";
    static final String DFA32_eofS =
        "\12\uffff";
    static final String DFA32_minS =
        "\1\5\1\uffff\6\0\2\uffff";
    static final String DFA32_maxS =
        "\1\74\1\uffff\6\0\2\uffff";
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
            return "337:13: ( '!' predicate | expression | expression '.' type )";
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
                        if ( (synpred52_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index32_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA32_3 = input.LA(1);

                         
                        int index32_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index32_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA32_4 = input.LA(1);

                         
                        int index32_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index32_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA32_5 = input.LA(1);

                         
                        int index32_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index32_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA32_6 = input.LA(1);

                         
                        int index32_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_WaebricChecker()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index32_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA32_7 = input.LA(1);

                         
                        int index32_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred52_WaebricChecker()) ) {s = 8;}

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
        "\2\5\2\uffff\2\5";
    static final String DFA34_maxS =
        "\1\57\1\61\2\uffff\1\5\1\61";
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
            return "()* loopback of 348:10: ( markup )*";
        }
    }
    static final String DFA42_eotS =
        "\6\uffff";
    static final String DFA42_eofS =
        "\6\uffff";
    static final String DFA42_minS =
        "\2\5\1\uffff\1\5\1\uffff\1\5";
    static final String DFA42_maxS =
        "\1\57\1\61\1\uffff\1\5\1\uffff\1\61";
    static final String DFA42_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String DFA42_specialS =
        "\6\uffff}>";
    static final String[] DFA42_transitionS = {
            "\1\1\1\uffff\3\2\43\uffff\1\2\1\uffff\1\2",
            "\1\4\1\uffff\3\4\7\uffff\1\2\21\uffff\1\3\1\uffff\4\4\1\uffff"+
            "\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\2",
            "",
            "\1\5",
            "",
            "\1\4\1\uffff\3\4\7\uffff\1\2\21\uffff\1\3\1\uffff\4\4\1\uffff"+
            "\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\2"
    };

    static final short[] DFA42_eot = DFA.unpackEncodedString(DFA42_eotS);
    static final short[] DFA42_eof = DFA.unpackEncodedString(DFA42_eofS);
    static final char[] DFA42_min = DFA.unpackEncodedStringToUnsignedChars(DFA42_minS);
    static final char[] DFA42_max = DFA.unpackEncodedStringToUnsignedChars(DFA42_maxS);
    static final short[] DFA42_accept = DFA.unpackEncodedString(DFA42_acceptS);
    static final short[] DFA42_special = DFA.unpackEncodedString(DFA42_specialS);
    static final short[][] DFA42_transition;

    static {
        int numStates = DFA42_transitionS.length;
        DFA42_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA42_transition[i] = DFA.unpackEncodedString(DFA42_transitionS[i]);
        }
    }

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = DFA42_eot;
            this.eof = DFA42_eof;
            this.min = DFA42_min;
            this.max = DFA42_max;
            this.accept = DFA42_accept;
            this.special = DFA42_special;
            this.transition = DFA42_transition;
        }
        public String getDescription() {
            return "()+ loopback of 299:26: ( markup )+";
        }
    }
    static final String DFA45_eotS =
        "\6\uffff";
    static final String DFA45_eofS =
        "\1\uffff\1\2\3\uffff\1\2";
    static final String DFA45_minS =
        "\2\5\2\uffff\2\5";
    static final String DFA45_maxS =
        "\1\57\1\61\2\uffff\1\5\1\61";
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
            return "()* loopback of 348:10: ( markup )*";
        }
    }
 

    public static final BitSet FOLLOW_34_in_module77 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_moduleId_in_module79 = new BitSet(new long[]{0x0004001000008008L});
    public static final BitSet FOLLOW_imprt_in_module81 = new BitSet(new long[]{0x0004001000008008L});
    public static final BitSet FOLLOW_site_in_module84 = new BitSet(new long[]{0x0004000000008008L});
    public static final BitSet FOLLOW_function_in_module87 = new BitSet(new long[]{0x0004000000000008L});
    public static final BitSet FOLLOW_IDCON_in_moduleId116 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_moduleId126 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_moduleId130 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_36_in_imprt151 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_moduleId_in_imprt153 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_imprt155 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_module_in_imprt159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SITE_in_site171 = new BitSet(new long[]{0x0000000000030040L});
    public static final BitSet FOLLOW_mappings_in_site173 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_END_in_site175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapping_in_mappings183 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_SEMICOLON_in_mappings188 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_mapping_in_mappings190 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_PATH_in_mapping202 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_mapping204 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_markup_in_mapping206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_markup225 = new BitSet(new long[]{0x000005E800000002L});
    public static final BitSet FOLLOW_attribute_in_markup227 = new BitSet(new long[]{0x000005E800000002L});
    public static final BitSet FOLLOW_arguments_in_markup232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_attribute250 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_attribute252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_attribute260 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_attribute262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_attribute270 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_attribute272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_attribute280 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_attribute282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_attribute290 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NATCON_in_attribute292 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_attribute296 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NATCON_in_attribute298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_arguments316 = new BitSet(new long[]{0x0000B800000003A0L});
    public static final BitSet FOLLOW_expression_in_arguments320 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_43_in_arguments333 = new BitSet(new long[]{0x0000A000000003A0L});
    public static final BitSet FOLLOW_expression_in_arguments335 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_44_in_arguments342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varExpression_in_expression357 = new BitSet(new long[]{0x0002000800000002L});
    public static final BitSet FOLLOW_NATCON_in_expression361 = new BitSet(new long[]{0x0002000800000002L});
    public static final BitSet FOLLOW_TEXT_in_expression365 = new BitSet(new long[]{0x0002000800000002L});
    public static final BitSet FOLLOW_SYMBOLCON_in_expression369 = new BitSet(new long[]{0x0002000800000002L});
    public static final BitSet FOLLOW_45_in_expression378 = new BitSet(new long[]{0x0000E800000003A0L});
    public static final BitSet FOLLOW_expression_in_expression380 = new BitSet(new long[]{0x0000480000000000L});
    public static final BitSet FOLLOW_43_in_expression385 = new BitSet(new long[]{0x0000A000000003A0L});
    public static final BitSet FOLLOW_expression_in_expression387 = new BitSet(new long[]{0x0000480000000000L});
    public static final BitSet FOLLOW_46_in_expression392 = new BitSet(new long[]{0x0002000800000002L});
    public static final BitSet FOLLOW_47_in_expression401 = new BitSet(new long[]{0x0001080000000020L});
    public static final BitSet FOLLOW_keyValuePair_in_expression403 = new BitSet(new long[]{0x0001080000000000L});
    public static final BitSet FOLLOW_43_in_expression408 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_keyValuePair_in_expression410 = new BitSet(new long[]{0x0001080000000000L});
    public static final BitSet FOLLOW_48_in_expression415 = new BitSet(new long[]{0x0002000800000002L});
    public static final BitSet FOLLOW_49_in_expression425 = new BitSet(new long[]{0x0000A000000003A0L});
    public static final BitSet FOLLOW_expression_in_expression427 = new BitSet(new long[]{0x0002000800000002L});
    public static final BitSet FOLLOW_35_in_expression431 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_expression433 = new BitSet(new long[]{0x0002000800000002L});
    public static final BitSet FOLLOW_IDCON_in_varExpression445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_keyValuePair459 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_keyValuePair461 = new BitSet(new long[]{0x0000A000000003A0L});
    public static final BitSet FOLLOW_expression_in_keyValuePair463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_function487 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_function489 = new BitSet(new long[]{0x0768840000014010L});
    public static final BitSet FOLLOW_formals_in_function491 = new BitSet(new long[]{0x0768800000014010L});
    public static final BitSet FOLLOW_statement_in_function493 = new BitSet(new long[]{0x0768800000014010L});
    public static final BitSet FOLLOW_END_in_function496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_regularFormals_in_formals517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_regularFormals539 = new BitSet(new long[]{0x0000100000000020L});
    public static final BitSet FOLLOW_IDCON_in_regularFormals543 = new BitSet(new long[]{0x0000100000000020L});
    public static final BitSet FOLLOW_44_in_regularFormals550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_statement563 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_42_in_statement565 = new BitSet(new long[]{0x1000A000000003A0L});
    public static final BitSet FOLLOW_predicate_in_statement567 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_statement569 = new BitSet(new long[]{0x0768800000004010L});
    public static final BitSet FOLLOW_statement_in_statement571 = new BitSet(new long[]{0x0010000000000008L});
    public static final BitSet FOLLOW_52_in_statement575 = new BitSet(new long[]{0x0768800000004010L});
    public static final BitSet FOLLOW_statement_in_statement577 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_eachStatement_in_statement589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_letStatement_in_statement596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_statement605 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statement607 = new BitSet(new long[]{0x0769800000004010L});
    public static final BitSet FOLLOW_48_in_statement610 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COMMENT_in_statement621 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRCON_in_statement623 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement625 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_56_in_statement636 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement638 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement640 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_56_in_statement651 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_statement653 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement655 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_57_in_statement666 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement668 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement670 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_58_in_statement679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement688 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement690 = new BitSet(new long[]{0x0000A000000003A0L});
    public static final BitSet FOLLOW_expression_in_statement693 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement695 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement706 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement708 = new BitSet(new long[]{0x0768800000004030L});
    public static final BitSet FOLLOW_statement_in_statement711 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement722 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement724 = new BitSet(new long[]{0x0000000000000820L});
    public static final BitSet FOLLOW_embedding_in_statement727 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement738 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement740 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement743 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_53_in_eachStatement769 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_42_in_eachStatement771 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_eachStatement773 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_eachStatement775 = new BitSet(new long[]{0x0000A000000003A0L});
    public static final BitSet FOLLOW_expression_in_eachStatement777 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_eachStatement779 = new BitSet(new long[]{0x0768800000004010L});
    public static final BitSet FOLLOW_statement_in_eachStatement783 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_54_in_letStatement809 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_assignment_in_letStatement811 = new BitSet(new long[]{0x0080000000000020L});
    public static final BitSet FOLLOW_55_in_letStatement814 = new BitSet(new long[]{0x0768800000014010L});
    public static final BitSet FOLLOW_statement_in_letStatement816 = new BitSet(new long[]{0x0768800000014010L});
    public static final BitSet FOLLOW_END_in_letStatement819 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDCON_in_assignment830 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_assignment832 = new BitSet(new long[]{0x0000A000000003A0L});
    public static final BitSet FOLLOW_expression_in_assignment834 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_assignment836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funcBinding_in_assignment842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_funcBinding869 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_regularFormals_in_funcBinding871 = new BitSet(new long[]{0x0768800000004010L});
    public static final BitSet FOLLOW_statement_in_funcBinding873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_predicate894 = new BitSet(new long[]{0x1000A000000003A0L});
    public static final BitSet FOLLOW_predicate_in_predicate896 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate905 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate913 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_predicate915 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_type_in_predicate917 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_61_in_predicate926 = new BitSet(new long[]{0x1000A000000003A0L});
    public static final BitSet FOLLOW_predicate_in_predicate928 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_62_in_predicate932 = new BitSet(new long[]{0x1000A000000003A0L});
    public static final BitSet FOLLOW_predicate_in_predicate934 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding969 = new BitSet(new long[]{0x0000A000000003A0L});
    public static final BitSet FOLLOW_embed_in_embedding971 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_textTail_in_embedding973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed982 = new BitSet(new long[]{0x0000A000000003A0L});
    public static final BitSet FOLLOW_expression_in_embed985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed989 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_markup_in_embed992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail1000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail1004 = new BitSet(new long[]{0x0000A000000003A0L});
    public static final BitSet FOLLOW_embed_in_textTail1006 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_textTail_in_textTail1008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_synpred25_WaebricChecker425 = new BitSet(new long[]{0x0000A000000003A0L});
    public static final BitSet FOLLOW_expression_in_synpred25_WaebricChecker427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_synpred26_WaebricChecker431 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_synpred26_WaebricChecker433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred37_WaebricChecker636 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_synpred37_WaebricChecker638 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred37_WaebricChecker640 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_56_in_synpred38_WaebricChecker651 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_synpred38_WaebricChecker653 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred38_WaebricChecker655 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_synpred42_WaebricChecker688 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred42_WaebricChecker690 = new BitSet(new long[]{0x0000A000000003A0L});
    public static final BitSet FOLLOW_expression_in_synpred42_WaebricChecker693 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred42_WaebricChecker695 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_synpred44_WaebricChecker706 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred44_WaebricChecker708 = new BitSet(new long[]{0x0768800000004030L});
    public static final BitSet FOLLOW_statement_in_synpred44_WaebricChecker711 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_synpred46_WaebricChecker722 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred46_WaebricChecker724 = new BitSet(new long[]{0x0000000000000820L});
    public static final BitSet FOLLOW_embedding_in_synpred46_WaebricChecker727 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_synpred52_WaebricChecker905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred53_WaebricChecker926 = new BitSet(new long[]{0x1000A000000003A0L});
    public static final BitSet FOLLOW_predicate_in_synpred53_WaebricChecker928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_synpred54_WaebricChecker932 = new BitSet(new long[]{0x1000A000000003A0L});
    public static final BitSet FOLLOW_predicate_in_synpred54_WaebricChecker934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred58_WaebricChecker982 = new BitSet(new long[]{0x0000A000000003A0L});
    public static final BitSet FOLLOW_expression_in_synpred58_WaebricChecker985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred59_WaebricChecker989 = new BitSet(new long[]{0x0000000000000002L});

}