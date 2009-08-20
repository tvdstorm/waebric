// $ANTLR 3.1.2 /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g 2009-08-20 22:56:04

	package org.cwi.waebric;
	
	import java.io.File;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.OutputStream;
	import java.text.SimpleDateFormat;
	
	import java.util.HashMap;
	import java.util.Map;
	import java.util.Collection;
		
	import org.jdom.Attribute;
	import org.jdom.CDATA;
	import org.jdom.Comment;
	import org.jdom.Content;
	import org.jdom.Document;
	import org.jdom.Element;
	import org.jdom.Namespace;
	import org.jdom.Text;
	
	import org.jdom.output.Format;
	import org.jdom.output.XMLOutputter;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class WaebricInterpreter extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATTRIBUTES", "ARGUMENTS", "MARKUP", "MARKUP_STATEMENT", "MARKUP_CHAIN", "FORMALS", "FUNCTION", "IDCON", "PATH", "NATCON", "TEXT", "SYMBOLCON", "STRCON", "PRETEXT", "POSTTEXT", "MIDTEXT", "COMMENT", "SITE", "END", "SEMICOLON", "LETTER", "DIGIT", "HEXADECIMAL", "PATHELEMENT", "FILEEXT", "STRCHAR", "ESCLAYOUT", "DECIMAL", "TEXTCHAR", "ESCQUOTE", "AMP", "CHARREF", "ENTREF", "SYMBOLCHAR", "COMMENTS", "LAYOUT", "'module'", "'.'", "'import'", "':'", "'#'", "'$'", "'@'", "'%'", "'('", "','", "')'", "'='", "'['", "']'", "'{'", "'}'", "'+'", "'if'", "'else'", "'each'", "'let'", "'in'", "'echo'", "'cdata'", "'yield;'", "'!'", "'?'", "'&&'", "'||'", "'list'", "'record'", "'string'"
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
    public static final int T__71=71;
    public static final int PATH=12;

    // delegates
    // delegators

    protected static class Environment_scope {
        Map<String, Integer> functions;
        Map<String, Integer> variables;
    }
    protected Stack Environment_stack = new Stack();


        public WaebricInterpreter(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public WaebricInterpreter(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return WaebricInterpreter.tokenNames; }
    public String getGrammarFileName() { return "/Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g"; }


    	// JDOM elements
    	private Document document;
    	private Element current;
    	
    	// Yield related
    	private Stack<Integer> yieldStack = new Stack<Integer>();
    	private List<Integer> yieldLocations = new ArrayList<Integer>();
    	
    	// Personal environments, due to inherited environments on function bindings
    	private Map<String, Stack> environments = new HashMap<String, Stack>();
    	
    	/**
    	 * Interpret program
    	 * @param os: Output stream for interpreting main function
    	 */
    	public void interpretProgram(OutputStream os, WaebricLoader loader) throws RecognitionException {
    		yieldLocations = loader.getYields(); // Store yield information
    	
    		// Store function definitions to allow lazy function binding
    		Environment_stack.clear();
    		Environment_scope base = new Environment_scope();
    		base.functions = new HashMap<String, Integer>();
    		base.variables = new HashMap<String, Integer>();
    		for(String function: loader.getFunctions().keySet()) 
    		{ base.functions.put(function, loader.getFunctions().get(function).index); }
    		Environment_stack.push(base);
    		
    		// Interpret main function with zero arguments
    		this.document = new Document();
    		if(interpretFunction("main", new ArrayList<Integer>())) {
    			if(current != null) { outputDocument(document, os); }
    		}
    		
    		// Interpret mappings
    		for(WaebricLoader.mapping_return mapping: loader.getMappings()) {
    			input.seek(mapping.index);
        			mapping();
    		}
    	}
    	
    	/**
    	 * Interpret function
    	 * @param name: Function name
    	 * @param args: Call arguments
    	 */
        	private boolean interpretFunction(String name, List<Integer> args) throws RecognitionException {
        		int function = getFunction(name);
        		if(function != -1) {
        			// Retrieve function environment
        			Stack environment = cloneEnvironment();
    			Environment_stack = getEnvironment(name);
        		
        			int actual = input.index();
        			input.seek(function);
        			function(args);
        			input.seek(actual);
        			
        			 // Restore environment
        			Environment_stack = environment;
        			
        			return true; // Succesfull interpretation
        		} return false;
        	}
        	
    	/**
    	 * Create file output stream for path
    	 */
    	private OutputStream createOutputStream(String path) throws IOException {
    		int dirLength = path.lastIndexOf("/");
    		
    		// Create directories
    		if(dirLength != -1) {
    			File directory = new File(path.substring(0, dirLength));
    			directory.mkdirs();
    		}
    		
    		// Create file
    		File file = new File(path);
    		file.createNewFile();
    		
    		return new FileOutputStream(path); // Create stream
    	}
    	
    	/**
    	 * Write document to output stream
    	 */
    	private void outputDocument(Document document, OutputStream os) {
    		try {
    			if(os != null) {
    				XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
    				out.output(document, os);
    			}
    		} catch(IOException e) { e.printStackTrace(); }
    	}
    	
        	private void addContent(Content content) {
        		if(current == null) { // Construct root element
            		if(content instanceof Element && ((Element) content).getName().equals("html")) {
            			document.setRootElement((Element) content);
            			current = document.getRootElement();
            		} else {
            			Element XHTML = createXHTMLTag();
                			document.setRootElement(XHTML);
                			XHTML.addContent(content);
                			
                			if(content instanceof Element) { current = (Element) content; }
                			else { current = XHTML; }
            		}	
            	} else {
        			current.addContent(content); // Attach content
        			if(content instanceof Element) { current = (Element) content; }
        		}
        	}
    	
    	private Element createXHTMLTag() {
    		Namespace XHTML = Namespace.getNamespace("xhtml", "http://www.w3.org/1999/xhtml");
    		Element tag = new Element("html", XHTML);
    		tag.setAttribute("lang", "en");
    		return tag;
    	}

    	/**
    	 * Retrieve function
    	 * @param name: Function name
    	 */
    	private Integer getFunction(String name) {
    		for(int i=Environment_stack.size()-1; i>=0; i--) {
    			if(((Environment_scope)Environment_stack.elementAt(i)).functions.containsKey(name)) {
    				return ((Environment_scope)Environment_stack.elementAt(i)).functions.get(name); 
    			}
    		} return -1 ;
    	}
    	
    	private boolean containsFunction(String name) {
    		return getFunction(name) != -1;
    	}
    	
    	private boolean containsYield(String name) {
    		int index = getFunction(name);
    		if(index != -1) { return yieldLocations.contains(index); }
    		return false;
    	}
    	
    	/**
    	 * Define function
    	 * @param name: Function name
    	 * @param index: Function index
    	 */
    	private void defineFunction(String name, Integer index) {
    		((Environment_scope)Environment_stack.peek()).functions.put(name, index);
    	}
    	
    	/**
    	 * Retrieve function environment
    	 * @param name: Function name
    	 */
    	private Stack getEnvironment(String name) {
    		if(environments.containsKey(name)) {
    			return (Stack) environments.get(name).clone();
    		} else {
    			Stack environment = new Stack();
    			environment.push(Environment_stack.elementAt(0));
    			return environment;
    		}
    	}
    	
    	/**
    	 * Retrieve variable
    	 * @param name: Variable name
    	 */
    	private Integer getVariable(String name) {
    		for(int i=Environment_stack.size()-1; i>=0; i--) {
    			if(((Environment_scope)Environment_stack.elementAt(i)).variables.containsKey(name)) {
    				return ((Environment_scope)Environment_stack.elementAt(i)).variables.get(name); 
    			}
    		} return -1;
    	}
    	
    	/**
    	 * Define variable
    	 * @param name: Variable name
    	 * @param eval: Variable evaluation
    	 */
    	private void defineVariable(String name, Integer input) {
    		((Environment_scope)Environment_stack.peek()).variables.put(name, input);
    	}
    	
    	/**
    	 * Clone current environment, regular stack.clone() maintains scopes
    	 */
    	private Stack cloneEnvironment() {
    		Stack result = new Stack();
    		for(int i = 0; i < Environment_stack.size(); i++) {
    			Environment_scope scope = new Environment_scope();
    			scope.functions = new HashMap<String, Integer>();
    			scope.functions.putAll(((Environment_scope)Environment_stack.elementAt(i)).functions);
    			scope.variables = new HashMap<String, Integer>();
    			scope.variables.putAll(((Environment_scope)Environment_stack.elementAt(i)).variables);
    			result.push(scope);
    		}
    		return result;
    	}
    	


    public static class mapping_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mapping"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:249:1: mapping : PATH ':' markup[false] ;
    public final WaebricInterpreter.mapping_return mapping() throws RecognitionException {
        WaebricInterpreter.mapping_return retval = new WaebricInterpreter.mapping_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PATH1=null;
        CommonTree char_literal2=null;
        WaebricInterpreter.markup_return markup3 = null;


        CommonTree PATH1_tree=null;
        CommonTree char_literal2_tree=null;

         this.document = new Document(); this.current = null; 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:251:2: ( PATH ':' markup[false] )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:251:5: PATH ':' markup[false]
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PATH1=(CommonTree)match(input,PATH,FOLLOW_PATH_in_mapping78); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PATH1_tree = (CommonTree)adaptor.dupNode(PATH1);

            adaptor.addChild(root_0, PATH1_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal2=(CommonTree)match(input,43,FOLLOW_43_in_mapping80); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal2_tree = (CommonTree)adaptor.dupNode(char_literal2);

            adaptor.addChild(root_0, char_literal2_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_markup_in_mapping82);
            markup3=markup(false);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, markup3.getTree());
            if ( state.backtracking==0 ) {
               
              				try {
              					OutputStream os = createOutputStream(PATH1.toString());
              					if(current != null) { outputDocument(document, os); }
              				} catch (IOException e) {
              					e.printStackTrace();
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
    // $ANTLR end "mapping"

    public static class markup_return extends TreeRuleReturnScope {
        public boolean yield = false;;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "markup"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:263:1: markup[boolean element] returns [boolean yield = false;] : ^( MARKUP IDCON . . ) ;
    public final WaebricInterpreter.markup_return markup(boolean element) throws RecognitionException {
        WaebricInterpreter.markup_return retval = new WaebricInterpreter.markup_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MARKUP4=null;
        CommonTree IDCON5=null;
        CommonTree wildcard6=null;
        CommonTree wildcard7=null;

        CommonTree MARKUP4_tree=null;
        CommonTree IDCON5_tree=null;
        CommonTree wildcard6_tree=null;
        CommonTree wildcard7_tree=null;

         int start = input.index(); int attr = 0; int args = 0; 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:266:2: ( ^( MARKUP IDCON . . ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:266:5: ^( MARKUP IDCON . . )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            MARKUP4=(CommonTree)match(input,MARKUP,FOLLOW_MARKUP_in_markup113); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MARKUP4_tree = (CommonTree)adaptor.dupNode(MARKUP4);

            root_1 = (CommonTree)adaptor.becomeRoot(MARKUP4_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            IDCON5=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_markup115); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON5_tree = (CommonTree)adaptor.dupNode(IDCON5);

            adaptor.addChild(root_1, IDCON5_tree);
            }
            if ( state.backtracking==0 ) {
               attr = input.index(); 
            }
            _last = (CommonTree)input.LT(1);
            wildcard6=(CommonTree)input.LT(1);
            matchAny(input); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            wildcard6_tree = (CommonTree)adaptor.dupTree(wildcard6);
            adaptor.addChild(root_1, wildcard6_tree);
            }
            if ( state.backtracking==0 ) {
               args = input.index(); 
            }
            _last = (CommonTree)input.LT(1);
            wildcard7=(CommonTree)input.LT(1);
            matchAny(input); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            wildcard7_tree = (CommonTree)adaptor.dupTree(wildcard7);
            adaptor.addChild(root_1, wildcard7_tree);
            }

            match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }

            if ( state.backtracking==0 ) {

              				if(containsFunction(IDCON5.getText())) {		
              					// Process markup as function call
              					int curr = input.index();
              					input.seek(args);
              					List<Integer> eval = arguments(true).args;
              					input.seek(curr);
              					
              					// Store yield arguments
              					if(containsYield(IDCON5.getText()) && element) {
              						yieldStack.add(start);
              						retval.yield = true;
              					}
              					
              					// Start interpreting function
              					interpretFunction(IDCON5.getText(), eval);
              				} else {
              					// Process markup as tag
              					addContent(new Element(IDCON5.getText()));
              					
              					// Process attributes
              					int actual = input.index();
              					input.seek(attr);
              					attributes();
              					arguments(false);
              					input.seek(actual);
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

    public static class attributes_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attributes"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:295:1: attributes : ^( ATTRIBUTES ( attribute )* ) ;
    public final WaebricInterpreter.attributes_return attributes() throws RecognitionException {
        WaebricInterpreter.attributes_return retval = new WaebricInterpreter.attributes_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ATTRIBUTES8=null;
        WaebricInterpreter.attribute_return attribute9 = null;


        CommonTree ATTRIBUTES8_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:295:11: ( ^( ATTRIBUTES ( attribute )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:295:14: ^( ATTRIBUTES ( attribute )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            ATTRIBUTES8=(CommonTree)match(input,ATTRIBUTES,FOLLOW_ATTRIBUTES_in_attributes141); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ATTRIBUTES8_tree = (CommonTree)adaptor.dupNode(ATTRIBUTES8);

            root_1 = (CommonTree)adaptor.becomeRoot(ATTRIBUTES8_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:295:28: ( attribute )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==41||(LA1_0>=43 && LA1_0<=46)) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: attribute
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_attribute_in_attributes143);
                	    attribute9=attribute();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, attribute9.getTree());

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop1;
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
    // $ANTLR end "attributes"

    public static class attribute_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attribute"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:297:1: attribute : ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' w= NATCON ( '%' h= NATCON )? );
    public final WaebricInterpreter.attribute_return attribute() throws RecognitionException {
        WaebricInterpreter.attribute_return retval = new WaebricInterpreter.attribute_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree w=null;
        CommonTree h=null;
        CommonTree char_literal10=null;
        CommonTree IDCON11=null;
        CommonTree char_literal12=null;
        CommonTree IDCON13=null;
        CommonTree char_literal14=null;
        CommonTree IDCON15=null;
        CommonTree char_literal16=null;
        CommonTree IDCON17=null;
        CommonTree char_literal18=null;
        CommonTree char_literal19=null;

        CommonTree w_tree=null;
        CommonTree h_tree=null;
        CommonTree char_literal10_tree=null;
        CommonTree IDCON11_tree=null;
        CommonTree char_literal12_tree=null;
        CommonTree IDCON13_tree=null;
        CommonTree char_literal14_tree=null;
        CommonTree IDCON15_tree=null;
        CommonTree char_literal16_tree=null;
        CommonTree IDCON17_tree=null;
        CommonTree char_literal18_tree=null;
        CommonTree char_literal19_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:297:10: ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' w= NATCON ( '%' h= NATCON )? )
            int alt3=5;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt3=1;
                }
                break;
            case 41:
                {
                alt3=2;
                }
                break;
            case 45:
                {
                alt3=3;
                }
                break;
            case 43:
                {
                alt3=4;
                }
                break;
            case 46:
                {
                alt3=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:297:13: '#' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal10=(CommonTree)match(input,44,FOLLOW_44_in_attribute155); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal10_tree = (CommonTree)adaptor.dupNode(char_literal10);

                    adaptor.addChild(root_0, char_literal10_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON11=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute157); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON11_tree = (CommonTree)adaptor.dupNode(IDCON11);

                    adaptor.addChild(root_0, IDCON11_tree);
                    }
                    if ( state.backtracking==0 ) {
                       current.setAttribute("id", IDCON11.getText()); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:298:6: '.' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal12=(CommonTree)match(input,41,FOLLOW_41_in_attribute166); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal12_tree = (CommonTree)adaptor.dupNode(char_literal12);

                    adaptor.addChild(root_0, char_literal12_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON13=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute168); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON13_tree = (CommonTree)adaptor.dupNode(IDCON13);

                    adaptor.addChild(root_0, IDCON13_tree);
                    }
                    if ( state.backtracking==0 ) {
                       current.setAttribute("class", IDCON13.getText()); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:299:6: '$' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal14=(CommonTree)match(input,45,FOLLOW_45_in_attribute177); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal14_tree = (CommonTree)adaptor.dupNode(char_literal14);

                    adaptor.addChild(root_0, char_literal14_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON15=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute179); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON15_tree = (CommonTree)adaptor.dupNode(IDCON15);

                    adaptor.addChild(root_0, IDCON15_tree);
                    }
                    if ( state.backtracking==0 ) {
                       current.setAttribute("name", IDCON15.getText()); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:300:6: ':' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal16=(CommonTree)match(input,43,FOLLOW_43_in_attribute188); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal16_tree = (CommonTree)adaptor.dupNode(char_literal16);

                    adaptor.addChild(root_0, char_literal16_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON17=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute190); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON17_tree = (CommonTree)adaptor.dupNode(IDCON17);

                    adaptor.addChild(root_0, IDCON17_tree);
                    }
                    if ( state.backtracking==0 ) {
                       current.setAttribute("type", IDCON17.getText()); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:301:6: '@' w= NATCON ( '%' h= NATCON )?
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal18=(CommonTree)match(input,46,FOLLOW_46_in_attribute199); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal18_tree = (CommonTree)adaptor.dupNode(char_literal18);

                    adaptor.addChild(root_0, char_literal18_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    w=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_attribute203); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    w_tree = (CommonTree)adaptor.dupNode(w);

                    adaptor.addChild(root_0, w_tree);
                    }
                    if ( state.backtracking==0 ) {
                       current.setAttribute("width", w.getText()); 
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:302:5: ( '%' h= NATCON )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==47) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:302:7: '%' h= NATCON
                            {
                            _last = (CommonTree)input.LT(1);
                            char_literal19=(CommonTree)match(input,47,FOLLOW_47_in_attribute213); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal19_tree = (CommonTree)adaptor.dupNode(char_literal19);

                            adaptor.addChild(root_0, char_literal19_tree);
                            }
                            _last = (CommonTree)input.LT(1);
                            h=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_attribute217); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            h_tree = (CommonTree)adaptor.dupNode(h);

                            adaptor.addChild(root_0, h_tree);
                            }
                            if ( state.backtracking==0 ) {
                               current.setAttribute("height", h.getText()); 
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
        public List<Integer> args = new ArrayList<Integer>();
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arguments"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:304:1: arguments[boolean call] returns [List<Integer> args = new ArrayList<Integer>()] : ^( ARGUMENTS ( argument[$args, call] )* ) ;
    public final WaebricInterpreter.arguments_return arguments(boolean call) throws RecognitionException {
        WaebricInterpreter.arguments_return retval = new WaebricInterpreter.arguments_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ARGUMENTS20=null;
        WaebricInterpreter.argument_return argument21 = null;


        CommonTree ARGUMENTS20_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:306:2: ( ^( ARGUMENTS ( argument[$args, call] )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:306:5: ^( ARGUMENTS ( argument[$args, call] )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            ARGUMENTS20=(CommonTree)match(input,ARGUMENTS,FOLLOW_ARGUMENTS_in_arguments244); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ARGUMENTS20_tree = (CommonTree)adaptor.dupNode(ARGUMENTS20);

            root_1 = (CommonTree)adaptor.becomeRoot(ARGUMENTS20_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:306:18: ( argument[$args, call] )*
                loop4:
                do {
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==IDCON||(LA4_0>=NATCON && LA4_0<=SYMBOLCON)||LA4_0==52||LA4_0==54) ) {
                        alt4=1;
                    }


                    switch (alt4) {
                	case 1 :
                	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: argument[$args, call]
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_argument_in_arguments246);
                	    argument21=argument(retval.args, call);

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, argument21.getTree());

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop4;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:308:1: argument[List<Integer> args, boolean call] : ( expression | IDCON '=' expression );
    public final WaebricInterpreter.argument_return argument(List<Integer> args, boolean call) throws RecognitionException {
        WaebricInterpreter.argument_return retval = new WaebricInterpreter.argument_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON23=null;
        CommonTree char_literal24=null;
        WaebricInterpreter.expression_return expression22 = null;

        WaebricInterpreter.expression_return expression25 = null;


        CommonTree IDCON23_tree=null;
        CommonTree char_literal24_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:309:2: ( expression | IDCON '=' expression )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==IDCON) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==51) ) {
                    alt5=2;
                }
                else if ( (LA5_1==EOF||LA5_1==UP||LA5_1==IDCON||(LA5_1>=NATCON && LA5_1<=SYMBOLCON)||LA5_1==41||LA5_1==52||LA5_1==54||LA5_1==56) ) {
                    alt5=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA5_0>=NATCON && LA5_0<=SYMBOLCON)||LA5_0==52||LA5_0==54) ) {
                alt5=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:309:5: expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_argument263);
                    expression22=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression22.getTree());
                    if ( state.backtracking==0 ) {

                      				if(call) { 
                      					args.add((expression22!=null?expression22.index:0)); // Add expression index to argument collection
                      				} else {
                      					// Attach argument to value attribute
                      					Attribute attribute = current.getAttribute("value");
                      					String value = (attribute == null) ? "" : attribute.getValue() + ", ";
                      					value += (expression22!=null?expression22.eval:null);
                      					current.setAttribute("value",  value);
                      				}
                      			
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:319:8: IDCON '=' expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDCON23=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_argument269); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON23_tree = (CommonTree)adaptor.dupNode(IDCON23);

                    adaptor.addChild(root_0, IDCON23_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal24=(CommonTree)match(input,51,FOLLOW_51_in_argument271); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal24_tree = (CommonTree)adaptor.dupNode(char_literal24);

                    adaptor.addChild(root_0, char_literal24_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_argument273);
                    expression25=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression25.getTree());
                    if ( state.backtracking==0 ) {

                      				if(call) { 
                      					 // TODO: Figure out what to do
                      				} else { 
                      					if(IDCON23.getText().equals("xmlns")) {
                      						// JDOM won't allow xmlns attributes
                      						current.setNamespace(Namespace.getNamespace("xhtml", "http://www.w3.org/1999/xhtml"));
                      					} else { current.setAttribute(IDCON23.getText(), (expression25!=null?expression25.eval:null)); }
                      				} 
                      			
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
    // $ANTLR end "argument"

    public static class expression_return extends TreeRuleReturnScope {
        public int index = -1;
        public String eval = "undef";
        public Map<String, expression_return> map = new HashMap<String, expression_return>();
        public Collection<expression_return> collection = new ArrayList();
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:333:1: expression returns [\n\t\tint index = -1, // Used for interpreting a referenced variable\n\t\tString eval = \"undef\", // Evaluation value for printing\n\t\tMap<String, expression_return> map = new HashMap<String, expression_return>(), // Map structure for fields\n\t\tCollection<expression_return> collection = new ArrayList() // List structure for iterations\n\t] : (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (id= IDCON ':' e= expression )? ( ',' id= IDCON ':' e= expression )* '}' ) ( '+' e= expression | '.' id= IDCON )* ;
    public final WaebricInterpreter.expression_return expression() throws RecognitionException {
        WaebricInterpreter.expression_return retval = new WaebricInterpreter.expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree var=null;
        CommonTree id=null;
        CommonTree NATCON26=null;
        CommonTree TEXT27=null;
        CommonTree SYMBOLCON28=null;
        CommonTree char_literal29=null;
        CommonTree char_literal30=null;
        CommonTree char_literal31=null;
        CommonTree char_literal32=null;
        CommonTree char_literal33=null;
        CommonTree char_literal34=null;
        CommonTree char_literal35=null;
        CommonTree char_literal36=null;
        CommonTree char_literal37=null;
        CommonTree char_literal38=null;
        WaebricInterpreter.expression_return e = null;


        CommonTree var_tree=null;
        CommonTree id_tree=null;
        CommonTree NATCON26_tree=null;
        CommonTree TEXT27_tree=null;
        CommonTree SYMBOLCON28_tree=null;
        CommonTree char_literal29_tree=null;
        CommonTree char_literal30_tree=null;
        CommonTree char_literal31_tree=null;
        CommonTree char_literal32_tree=null;
        CommonTree char_literal33_tree=null;
        CommonTree char_literal34_tree=null;
        CommonTree char_literal35_tree=null;
        CommonTree char_literal36_tree=null;
        CommonTree char_literal37_tree=null;
        CommonTree char_literal38_tree=null;

         retval.index = input.index(); 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:339:2: ( (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (id= IDCON ':' e= expression )? ( ',' id= IDCON ':' e= expression )* '}' ) ( '+' e= expression | '.' id= IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:340:4: (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (id= IDCON ':' e= expression )? ( ',' id= IDCON ':' e= expression )* '}' ) ( '+' e= expression | '.' id= IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:340:4: (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (id= IDCON ':' e= expression )? ( ',' id= IDCON ':' e= expression )* '}' )
            int alt10=6;
            switch ( input.LA(1) ) {
            case IDCON:
                {
                alt10=1;
                }
                break;
            case NATCON:
                {
                alt10=2;
                }
                break;
            case TEXT:
                {
                alt10=3;
                }
                break;
            case SYMBOLCON:
                {
                alt10=4;
                }
                break;
            case 52:
                {
                alt10=5;
                }
                break;
            case 54:
                {
                alt10=6;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:340:6: var= IDCON
                    {
                    _last = (CommonTree)input.LT(1);
                    var=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression306); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    var_tree = (CommonTree)adaptor.dupNode(var);

                    adaptor.addChild(root_0, var_tree);
                    }
                    if ( state.backtracking==0 ) {

                      					// Reference
                      					int curr = input.index();
                      					int next = getVariable(var.getText());
                      					if(next != -1) {
                      						input.seek(next);
                      						retval = expression();
                      						input.seek(curr);
                      					} 
                      				
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:350:6: NATCON
                    {
                    _last = (CommonTree)input.LT(1);
                    NATCON26=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_expression315); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON26_tree = (CommonTree)adaptor.dupNode(NATCON26);

                    adaptor.addChild(root_0, NATCON26_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.eval = NATCON26.getText(); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:351:6: TEXT
                    {
                    _last = (CommonTree)input.LT(1);
                    TEXT27=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_expression324); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TEXT27_tree = (CommonTree)adaptor.dupNode(TEXT27);

                    adaptor.addChild(root_0, TEXT27_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.eval = TEXT27.getText(); retval.eval = retval.eval.substring(1, retval.eval.length()-1); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:352:6: SYMBOLCON
                    {
                    _last = (CommonTree)input.LT(1);
                    SYMBOLCON28=(CommonTree)match(input,SYMBOLCON,FOLLOW_SYMBOLCON_in_expression333); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SYMBOLCON28_tree = (CommonTree)adaptor.dupNode(SYMBOLCON28);

                    adaptor.addChild(root_0, SYMBOLCON28_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.eval = SYMBOLCON28.getText(); retval.eval = retval.eval.substring(1, retval.eval.length()); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:353:6: '[' (e= expression )? ( ',' e= expression )* ']'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal29=(CommonTree)match(input,52,FOLLOW_52_in_expression342); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal29_tree = (CommonTree)adaptor.dupNode(char_literal29);

                    adaptor.addChild(root_0, char_literal29_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:353:10: (e= expression )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==IDCON||(LA6_0>=NATCON && LA6_0<=SYMBOLCON)||LA6_0==52||LA6_0==54) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:353:12: e= expression
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_expression_in_expression348);
                            e=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, e.getTree());
                            if ( state.backtracking==0 ) {
                               retval.collection.add(e); 
                            }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:354:6: ( ',' e= expression )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==49) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:354:8: ',' e= expression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal30=(CommonTree)match(input,49,FOLLOW_49_in_expression363); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal30_tree = (CommonTree)adaptor.dupNode(char_literal30);

                    	    adaptor.addChild(root_0, char_literal30_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_expression_in_expression367);
                    	    e=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, e.getTree());
                    	    if ( state.backtracking==0 ) {
                    	       retval.collection.add(e); 
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal31=(CommonTree)match(input,53,FOLLOW_53_in_expression374); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal31_tree = (CommonTree)adaptor.dupNode(char_literal31);

                    adaptor.addChild(root_0, char_literal31_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			  		// Build list type string evaluation
                      					retval.eval = "[";
                      					for(expression_return eret:retval.collection) { retval.eval += eret.eval + ","; }
                      					retval.eval = retval.eval.substring(0, retval.eval.length()); // Clip last character
                      					retval.eval += "]";
                      				
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:361:6: '{' (id= IDCON ':' e= expression )? ( ',' id= IDCON ':' e= expression )* '}'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal32=(CommonTree)match(input,54,FOLLOW_54_in_expression383); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal32_tree = (CommonTree)adaptor.dupNode(char_literal32);

                    adaptor.addChild(root_0, char_literal32_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:361:10: (id= IDCON ':' e= expression )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==IDCON) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:361:12: id= IDCON ':' e= expression
                            {
                            _last = (CommonTree)input.LT(1);
                            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression389); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            id_tree = (CommonTree)adaptor.dupNode(id);

                            adaptor.addChild(root_0, id_tree);
                            }
                            _last = (CommonTree)input.LT(1);
                            char_literal33=(CommonTree)match(input,43,FOLLOW_43_in_expression391); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal33_tree = (CommonTree)adaptor.dupNode(char_literal33);

                            adaptor.addChild(root_0, char_literal33_tree);
                            }
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_expression_in_expression395);
                            e=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, e.getTree());
                            if ( state.backtracking==0 ) {
                               retval.map.put(id.getText(), e); 
                            }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:362:6: ( ',' id= IDCON ':' e= expression )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==49) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:362:8: ',' id= IDCON ':' e= expression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal34=(CommonTree)match(input,49,FOLLOW_49_in_expression410); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal34_tree = (CommonTree)adaptor.dupNode(char_literal34);

                    	    adaptor.addChild(root_0, char_literal34_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression414); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    id_tree = (CommonTree)adaptor.dupNode(id);

                    	    adaptor.addChild(root_0, id_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal35=(CommonTree)match(input,43,FOLLOW_43_in_expression416); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal35_tree = (CommonTree)adaptor.dupNode(char_literal35);

                    	    adaptor.addChild(root_0, char_literal35_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_expression_in_expression420);
                    	    e=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, e.getTree());
                    	    if ( state.backtracking==0 ) {
                    	       retval.map.put(id.getText(), e); 
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal36=(CommonTree)match(input,55,FOLLOW_55_in_expression427); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal36_tree = (CommonTree)adaptor.dupNode(char_literal36);

                    adaptor.addChild(root_0, char_literal36_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			  		// Build record type string evaluation
                      					retval.collection = retval.map.values();
                      					retval.eval = "{";
                      					for(String key:retval.map.keySet()) { retval.eval += key + ":" + retval.map.get(key).eval + ","; }
                      					retval.eval = retval.eval.substring(0, retval.eval.length()); // Clip last character
                      					retval.eval += "}";
                      				
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:373:4: ( '+' e= expression | '.' id= IDCON )*
            loop11:
            do {
                int alt11=3;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==56) ) {
                    int LA11_2 = input.LA(2);

                    if ( (synpred18_WaebricInterpreter()) ) {
                        alt11=1;
                    }


                }
                else if ( (LA11_0==41) ) {
                    int LA11_3 = input.LA(2);

                    if ( (synpred19_WaebricInterpreter()) ) {
                        alt11=2;
                    }


                }


                switch (alt11) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:373:6: '+' e= expression
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal37=(CommonTree)match(input,56,FOLLOW_56_in_expression450); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal37_tree = (CommonTree)adaptor.dupNode(char_literal37);

            	    adaptor.addChild(root_0, char_literal37_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expression_in_expression454);
            	    e=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, e.getTree());
            	    if ( state.backtracking==0 ) {

            	      					// Expression combination
            	      					retval.eval += (e!=null?e.eval:null);
            	      					retval.collection.clear();
            	      					retval.map.clear();
            	      				
            	    }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:379:6: '.' id= IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal38=(CommonTree)match(input,41,FOLLOW_41_in_expression464); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal38_tree = (CommonTree)adaptor.dupNode(char_literal38);

            	    adaptor.addChild(root_0, char_literal38_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression468); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    id_tree = (CommonTree)adaptor.dupNode(id);

            	    adaptor.addChild(root_0, id_tree);
            	    }
            	    if ( state.backtracking==0 ) {

            	      					// Record field
            	      					if(retval.map.containsKey(id.getText())) { retval = retval.map.get(id.getText()); } 
            	      					else {
            	      						retval.index = -1;
            	      						retval.eval = "undef";
            	      						retval.collection.clear();
            	      						retval.map.clear();
            	      					}
            	      				
            	    }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop11;
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

    public static class function_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:394:1: function[List<Integer> args] : ^( FUNCTION IDCON ^( FORMALS (id= IDCON )* ) ( statement )* ) ;
    public final WaebricInterpreter.function_return function(List<Integer> args) throws RecognitionException {
        WaebricInterpreter.function_return retval = new WaebricInterpreter.function_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        CommonTree FUNCTION39=null;
        CommonTree IDCON40=null;
        CommonTree FORMALS41=null;
        WaebricInterpreter.statement_return statement42 = null;


        CommonTree id_tree=null;
        CommonTree FUNCTION39_tree=null;
        CommonTree IDCON40_tree=null;
        CommonTree FORMALS41_tree=null;

         Element actual = null; int curr = 0; 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:396:2: ( ^( FUNCTION IDCON ^( FORMALS (id= IDCON )* ) ( statement )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:396:5: ^( FUNCTION IDCON ^( FORMALS (id= IDCON )* ) ( statement )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNCTION39=(CommonTree)match(input,FUNCTION,FOLLOW_FUNCTION_in_function501); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FUNCTION39_tree = (CommonTree)adaptor.dupNode(FUNCTION39);

            root_1 = (CommonTree)adaptor.becomeRoot(FUNCTION39_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            IDCON40=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_function503); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON40_tree = (CommonTree)adaptor.dupNode(IDCON40);

            adaptor.addChild(root_1, IDCON40_tree);
            }
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FORMALS41=(CommonTree)match(input,FORMALS,FOLLOW_FORMALS_in_function517); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FORMALS41_tree = (CommonTree)adaptor.dupNode(FORMALS41);

            root_2 = (CommonTree)adaptor.becomeRoot(FORMALS41_tree, root_2);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:398:16: (id= IDCON )*
                loop12:
                do {
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==IDCON) ) {
                        alt12=1;
                    }


                    switch (alt12) {
                	case 1 :
                	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:398:18: id= IDCON
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_function523); if (state.failed) return retval;
                	    if ( state.backtracking==0 ) {
                	    id_tree = (CommonTree)adaptor.dupNode(id);

                	    adaptor.addChild(root_2, id_tree);
                	    }
                	    if ( state.backtracking==0 ) {
                	      	if(args.size() > curr) { 
                	      					defineVariable(id.getText(), args.get(curr)); curr++;
                	      				} 
                	    }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop12;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:403:5: ( statement )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==MARKUP_STATEMENT||LA13_0==COMMENT||LA13_0==54||LA13_0==57||(LA13_0>=59 && LA13_0<=60)||(LA13_0>=62 && LA13_0<=64)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:403:7: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_function548);
            	    statement42=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, statement42.getTree());
            	    if ( state.backtracking==0 ) {
            	       
            	      					if(actual != null) { this.current = actual; } 
            	      					else { actual = this.current; } 
            	      				
            	    }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop13;
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
        }
        return retval;
    }
    // $ANTLR end "function"

    public static class formals_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "formals"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:409:1: formals : ^( FORMALS ( IDCON )* ) ;
    public final WaebricInterpreter.formals_return formals() throws RecognitionException {
        WaebricInterpreter.formals_return retval = new WaebricInterpreter.formals_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FORMALS43=null;
        CommonTree IDCON44=null;

        CommonTree FORMALS43_tree=null;
        CommonTree IDCON44_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:409:8: ( ^( FORMALS ( IDCON )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:409:11: ^( FORMALS ( IDCON )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FORMALS43=(CommonTree)match(input,FORMALS,FOLLOW_FORMALS_in_formals569); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FORMALS43_tree = (CommonTree)adaptor.dupNode(FORMALS43);

            root_1 = (CommonTree)adaptor.becomeRoot(FORMALS43_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:409:22: ( IDCON )*
                loop14:
                do {
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==IDCON) ) {
                        alt14=1;
                    }


                    switch (alt14) {
                	case 1 :
                	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: IDCON
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    IDCON44=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_formals571); if (state.failed) return retval;
                	    if ( state.backtracking==0 ) {
                	    IDCON44_tree = (CommonTree)adaptor.dupNode(IDCON44);

                	    adaptor.addChild(root_1, IDCON44_tree);
                	    }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop14;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:415:1: statement : ( ifStatement | eachStatement | letStatement | blockStatement | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding[false] ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT markup[true] markupChain ) );
    public final WaebricInterpreter.statement_return statement() throws RecognitionException {
        WaebricInterpreter.statement_return retval = new WaebricInterpreter.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal49=null;
        CommonTree STRCON50=null;
        CommonTree char_literal51=null;
        CommonTree string_literal52=null;
        CommonTree char_literal54=null;
        CommonTree string_literal55=null;
        CommonTree char_literal57=null;
        CommonTree string_literal58=null;
        CommonTree char_literal60=null;
        CommonTree string_literal61=null;
        CommonTree MARKUP_STATEMENT62=null;
        WaebricInterpreter.ifStatement_return ifStatement45 = null;

        WaebricInterpreter.eachStatement_return eachStatement46 = null;

        WaebricInterpreter.letStatement_return letStatement47 = null;

        WaebricInterpreter.blockStatement_return blockStatement48 = null;

        WaebricInterpreter.expression_return expression53 = null;

        WaebricInterpreter.embedding_return embedding56 = null;

        WaebricInterpreter.expression_return expression59 = null;

        WaebricInterpreter.markup_return markup63 = null;

        WaebricInterpreter.markupChain_return markupChain64 = null;


        CommonTree string_literal49_tree=null;
        CommonTree STRCON50_tree=null;
        CommonTree char_literal51_tree=null;
        CommonTree string_literal52_tree=null;
        CommonTree char_literal54_tree=null;
        CommonTree string_literal55_tree=null;
        CommonTree char_literal57_tree=null;
        CommonTree string_literal58_tree=null;
        CommonTree char_literal60_tree=null;
        CommonTree string_literal61_tree=null;
        CommonTree MARKUP_STATEMENT62_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:415:10: ( ifStatement | eachStatement | letStatement | blockStatement | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding[false] ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT markup[true] markupChain ) )
            int alt15=10;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:415:13: ifStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_ifStatement_in_statement587);
                    ifStatement45=ifStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, ifStatement45.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:416:6: eachStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_eachStatement_in_statement594);
                    eachStatement46=eachStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, eachStatement46.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:417:6: letStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_letStatement_in_statement601);
                    letStatement47=letStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, letStatement47.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:418:6: blockStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_blockStatement_in_statement608);
                    blockStatement48=blockStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, blockStatement48.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:419:6: ^( 'comment' STRCON ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal49=(CommonTree)match(input,COMMENT,FOLLOW_COMMENT_in_statement617); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal49_tree = (CommonTree)adaptor.dupNode(string_literal49);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal49_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    STRCON50=(CommonTree)match(input,STRCON,FOLLOW_STRCON_in_statement619); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRCON50_tree = (CommonTree)adaptor.dupNode(STRCON50);

                    adaptor.addChild(root_1, STRCON50_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal51=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement621); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal51_tree = (CommonTree)adaptor.dupNode(char_literal51);

                    adaptor.addChild(root_1, char_literal51_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                    if ( state.backtracking==0 ) {
                       addContent(new Comment(STRCON50.getText())); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:420:6: ^( 'echo' expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal52=(CommonTree)match(input,62,FOLLOW_62_in_statement634); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal52_tree = (CommonTree)adaptor.dupNode(string_literal52);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal52_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement636);
                    expression53=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression53.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal54=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement638); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal54_tree = (CommonTree)adaptor.dupNode(char_literal54);

                    adaptor.addChild(root_1, char_literal54_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                    if ( state.backtracking==0 ) {
                       addContent(new Text((expression53!=null?expression53.eval:null))); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:421:6: ^( 'echo' embedding[false] ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal55=(CommonTree)match(input,62,FOLLOW_62_in_statement651); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal55_tree = (CommonTree)adaptor.dupNode(string_literal55);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal55_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement653);
                    embedding56=embedding(false);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding56.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal57=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement656); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal57_tree = (CommonTree)adaptor.dupNode(char_literal57);

                    adaptor.addChild(root_1, char_literal57_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:422:6: ^( 'cdata' expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal58=(CommonTree)match(input,63,FOLLOW_63_in_statement667); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal58_tree = (CommonTree)adaptor.dupNode(string_literal58);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal58_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement669);
                    expression59=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression59.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal60=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement671); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal60_tree = (CommonTree)adaptor.dupNode(char_literal60);

                    adaptor.addChild(root_1, char_literal60_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                    if ( state.backtracking==0 ) {
                      	addContent(new CDATA((expression59!=null?expression59.eval:null))); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:423:6: 'yield;'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal61=(CommonTree)match(input,64,FOLLOW_64_in_statement682); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal61_tree = (CommonTree)adaptor.dupNode(string_literal61);

                    adaptor.addChild(root_0, string_literal61_tree);
                    }
                    if ( state.backtracking==0 ) {

                      					if(! yieldStack.isEmpty()) {
                      						int curr = input.index();
                      						int index = yieldStack.pop();
                      						Stack clone = (Stack) yieldStack.clone();

                      						input.seek(index);
                      						matchAny(input); // Skip already interpreted markup
                      						markupChain(); // Execute copied markup chain
                      						input.seek(curr);
                      						
                      						yieldStack = clone;
                      					}	
                      				
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:437:6: ^( MARKUP_STATEMENT markup[true] markupChain )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT62=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement693); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT62_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT62);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT62_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_statement695);
                    markup63=markup(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, markup63.getTree());
                    if ( state.backtracking==0 ) {
                       
                      					if((markup63!=null?markup63.yield:false)) { 
                      						matchAny(input); // Match markup chain, without executing
                      						match(input, Token.UP, null); // Match up
                      						return retval; // Quit parsing markup stm
                      					}
                      				
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markupChain_in_statement700);
                    markupChain64=markupChain();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, markupChain64.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:446:1: markupChain : ( ^( MARKUP_CHAIN markup[true] markupChain ) | ^( MARKUP_CHAIN expression ';' ) | ^( MARKUP_CHAIN statement ) | ^( MARKUP_CHAIN embedding[true] ';' ) | ^( MARKUP_CHAIN ';' ) );
    public final WaebricInterpreter.markupChain_return markupChain() throws RecognitionException {
        WaebricInterpreter.markupChain_return retval = new WaebricInterpreter.markupChain_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MARKUP_CHAIN65=null;
        CommonTree MARKUP_CHAIN68=null;
        CommonTree char_literal70=null;
        CommonTree MARKUP_CHAIN71=null;
        CommonTree MARKUP_CHAIN73=null;
        CommonTree char_literal75=null;
        CommonTree MARKUP_CHAIN76=null;
        CommonTree char_literal77=null;
        WaebricInterpreter.markup_return markup66 = null;

        WaebricInterpreter.markupChain_return markupChain67 = null;

        WaebricInterpreter.expression_return expression69 = null;

        WaebricInterpreter.statement_return statement72 = null;

        WaebricInterpreter.embedding_return embedding74 = null;


        CommonTree MARKUP_CHAIN65_tree=null;
        CommonTree MARKUP_CHAIN68_tree=null;
        CommonTree char_literal70_tree=null;
        CommonTree MARKUP_CHAIN71_tree=null;
        CommonTree MARKUP_CHAIN73_tree=null;
        CommonTree char_literal75_tree=null;
        CommonTree MARKUP_CHAIN76_tree=null;
        CommonTree char_literal77_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:446:12: ( ^( MARKUP_CHAIN markup[true] markupChain ) | ^( MARKUP_CHAIN expression ';' ) | ^( MARKUP_CHAIN statement ) | ^( MARKUP_CHAIN embedding[true] ';' ) | ^( MARKUP_CHAIN ';' ) )
            int alt16=5;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==MARKUP_CHAIN) ) {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==DOWN) ) {
                    switch ( input.LA(3) ) {
                    case SEMICOLON:
                        {
                        alt16=5;
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
                        alt16=3;
                        }
                        break;
                    case 54:
                        {
                        int LA16_5 = input.LA(4);

                        if ( (LA16_5==DOWN) ) {
                            alt16=3;
                        }
                        else if ( (LA16_5==IDCON||LA16_5==49||LA16_5==55) ) {
                            alt16=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 16, 5, input);

                            throw nvae;
                        }
                        }
                        break;
                    case PRETEXT:
                        {
                        alt16=4;
                        }
                        break;
                    case IDCON:
                    case NATCON:
                    case TEXT:
                    case SYMBOLCON:
                    case 52:
                        {
                        alt16=2;
                        }
                        break;
                    case MARKUP:
                        {
                        alt16=1;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 16, 2, input);

                        throw nvae;
                    }

                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:446:15: ^( MARKUP_CHAIN markup[true] markupChain )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_CHAIN65=(CommonTree)match(input,MARKUP_CHAIN,FOLLOW_MARKUP_CHAIN_in_markupChain724); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_CHAIN65_tree = (CommonTree)adaptor.dupNode(MARKUP_CHAIN65);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_CHAIN65_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_markupChain726);
                    markup66=markup(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, markup66.getTree());
                    if ( state.backtracking==0 ) {

                      					if((markup66!=null?markup66.yield:false)) { 
                      						matchAny(input); // Match markup chain, without executing
                      						match(input, Token.UP, null); // Match up
                      						return retval; // Quit parsing markup stm
                      					}
                      				
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markupChain_in_markupChain731);
                    markupChain67=markupChain();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, markupChain67.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:453:6: ^( MARKUP_CHAIN expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_CHAIN68=(CommonTree)match(input,MARKUP_CHAIN,FOLLOW_MARKUP_CHAIN_in_markupChain742); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_CHAIN68_tree = (CommonTree)adaptor.dupNode(MARKUP_CHAIN68);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_CHAIN68_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_markupChain744);
                    expression69=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression69.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal70=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_markupChain746); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal70_tree = (CommonTree)adaptor.dupNode(char_literal70);

                    adaptor.addChild(root_1, char_literal70_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                    if ( state.backtracking==0 ) {
                       addContent(new Text((expression69!=null?expression69.eval:null))); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:454:6: ^( MARKUP_CHAIN statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_CHAIN71=(CommonTree)match(input,MARKUP_CHAIN,FOLLOW_MARKUP_CHAIN_in_markupChain759); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_CHAIN71_tree = (CommonTree)adaptor.dupNode(MARKUP_CHAIN71);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_CHAIN71_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_markupChain761);
                    statement72=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement72.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:455:6: ^( MARKUP_CHAIN embedding[true] ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_CHAIN73=(CommonTree)match(input,MARKUP_CHAIN,FOLLOW_MARKUP_CHAIN_in_markupChain772); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_CHAIN73_tree = (CommonTree)adaptor.dupNode(MARKUP_CHAIN73);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_CHAIN73_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_markupChain774);
                    embedding74=embedding(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding74.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal75=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_markupChain777); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal75_tree = (CommonTree)adaptor.dupNode(char_literal75);

                    adaptor.addChild(root_1, char_literal75_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:456:6: ^( MARKUP_CHAIN ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_CHAIN76=(CommonTree)match(input,MARKUP_CHAIN,FOLLOW_MARKUP_CHAIN_in_markupChain788); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_CHAIN76_tree = (CommonTree)adaptor.dupNode(MARKUP_CHAIN76);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_CHAIN76_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    char_literal77=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_markupChain790); if (state.failed) return retval;
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

    public static class ifStatement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ifStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:458:1: ifStatement : ^( 'if' '(' predicate ')' t= . ( 'else' f= . )? ) ;
    public final WaebricInterpreter.ifStatement_return ifStatement() throws RecognitionException {
        WaebricInterpreter.ifStatement_return retval = new WaebricInterpreter.ifStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal78=null;
        CommonTree char_literal79=null;
        CommonTree char_literal81=null;
        CommonTree string_literal82=null;
        CommonTree t=null;
        CommonTree f=null;
        WaebricInterpreter.predicate_return predicate80 = null;


        CommonTree string_literal78_tree=null;
        CommonTree char_literal79_tree=null;
        CommonTree char_literal81_tree=null;
        CommonTree string_literal82_tree=null;
        CommonTree t_tree=null;
        CommonTree f_tree=null;

         int ti = 0; int fi = 0; 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:460:2: ( ^( 'if' '(' predicate ')' t= . ( 'else' f= . )? ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:460:5: ^( 'if' '(' predicate ')' t= . ( 'else' f= . )? )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal78=(CommonTree)match(input,57,FOLLOW_57_in_ifStatement810); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal78_tree = (CommonTree)adaptor.dupNode(string_literal78);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal78_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            char_literal79=(CommonTree)match(input,48,FOLLOW_48_in_ifStatement812); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal79_tree = (CommonTree)adaptor.dupNode(char_literal79);

            adaptor.addChild(root_1, char_literal79_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_predicate_in_ifStatement814);
            predicate80=predicate();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, predicate80.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal81=(CommonTree)match(input,50,FOLLOW_50_in_ifStatement816); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal81_tree = (CommonTree)adaptor.dupNode(char_literal81);

            adaptor.addChild(root_1, char_literal81_tree);
            }
            if ( state.backtracking==0 ) {
               ti = input.index(); 
            }
            _last = (CommonTree)input.LT(1);
            t=(CommonTree)input.LT(1);
            matchAny(input); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            t_tree = (CommonTree)adaptor.dupTree(t);
            adaptor.addChild(root_1, t_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:460:60: ( 'else' f= . )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==58) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:460:62: 'else' f= .
                    {
                    _last = (CommonTree)input.LT(1);
                    string_literal82=(CommonTree)match(input,58,FOLLOW_58_in_ifStatement827); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal82_tree = (CommonTree)adaptor.dupNode(string_literal82);

                    adaptor.addChild(root_1, string_literal82_tree);
                    }
                    if ( state.backtracking==0 ) {
                       fi = input.index(); 
                    }
                    _last = (CommonTree)input.LT(1);
                    f=(CommonTree)input.LT(1);
                    matchAny(input); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    f_tree = (CommonTree)adaptor.dupTree(f);
                    adaptor.addChild(root_1, f_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }

            if ( state.backtracking==0 ) {

              				int curr = input.index();
              				if((predicate80!=null?predicate80.eval:false)) {
              					input.seek(ti);
              					statement();
              					input.seek(curr);
              				} else if(f != null) {
              					input.seek(fi);
              					statement();
              					input.seek(curr);
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
    // $ANTLR end "ifStatement"

    public static class eachStatement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "eachStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:473:1: eachStatement : ^( 'each' '(' IDCON ':' e= expression ')' . ) ;
    public final WaebricInterpreter.eachStatement_return eachStatement() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricInterpreter.eachStatement_return retval = new WaebricInterpreter.eachStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal83=null;
        CommonTree char_literal84=null;
        CommonTree IDCON85=null;
        CommonTree char_literal86=null;
        CommonTree char_literal87=null;
        CommonTree wildcard88=null;
        WaebricInterpreter.expression_return e = null;


        CommonTree string_literal83_tree=null;
        CommonTree char_literal84_tree=null;
        CommonTree IDCON85_tree=null;
        CommonTree char_literal86_tree=null;
        CommonTree char_literal87_tree=null;
        CommonTree wildcard88_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new HashMap<String, Integer>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        		int stm = 0;
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:479:4: ( ^( 'each' '(' IDCON ':' e= expression ')' . ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:479:7: ^( 'each' '(' IDCON ':' e= expression ')' . )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal83=(CommonTree)match(input,59,FOLLOW_59_in_eachStatement867); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal83_tree = (CommonTree)adaptor.dupNode(string_literal83);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal83_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            char_literal84=(CommonTree)match(input,48,FOLLOW_48_in_eachStatement869); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal84_tree = (CommonTree)adaptor.dupNode(char_literal84);

            adaptor.addChild(root_1, char_literal84_tree);
            }
            _last = (CommonTree)input.LT(1);
            IDCON85=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_eachStatement871); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON85_tree = (CommonTree)adaptor.dupNode(IDCON85);

            adaptor.addChild(root_1, IDCON85_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal86=(CommonTree)match(input,43,FOLLOW_43_in_eachStatement873); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal86_tree = (CommonTree)adaptor.dupNode(char_literal86);

            adaptor.addChild(root_1, char_literal86_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_eachStatement877);
            e=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, e.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal87=(CommonTree)match(input,50,FOLLOW_50_in_eachStatement879); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal87_tree = (CommonTree)adaptor.dupNode(char_literal87);

            adaptor.addChild(root_1, char_literal87_tree);
            }
            if ( state.backtracking==0 ) {
               stm = input.index(); 
            }
            _last = (CommonTree)input.LT(1);
            wildcard88=(CommonTree)input.LT(1);
            matchAny(input); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            wildcard88_tree = (CommonTree)adaptor.dupTree(wildcard88);
            adaptor.addChild(root_1, wildcard88_tree);
            }

            match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }

            if ( state.backtracking==0 ) {

              				int actualIndex = input.index();
                            			Element actualElement = this.current;
                            			for(expression_return value: e.collection) {
                            				defineVariable(IDCON85.getText(), value.index);
                            				input.seek(stm);
                            				statement();
                            				input.seek(actualIndex);	
                            				if(actualElement == null) { actualElement = document.getRootElement(); }
                            				this.current = actualElement;
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
            Environment_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "eachStatement"

    public static class blockStatement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "blockStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:492:1: blockStatement : ^( '{' ( statement )* '}' ) ;
    public final WaebricInterpreter.blockStatement_return blockStatement() throws RecognitionException {
        WaebricInterpreter.blockStatement_return retval = new WaebricInterpreter.blockStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal89=null;
        CommonTree char_literal91=null;
        WaebricInterpreter.statement_return statement90 = null;


        CommonTree char_literal89_tree=null;
        CommonTree char_literal91_tree=null;

         Element actual = this.current; 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:494:2: ( ^( '{' ( statement )* '}' ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:494:5: ^( '{' ( statement )* '}' )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            char_literal89=(CommonTree)match(input,54,FOLLOW_54_in_blockStatement905); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal89_tree = (CommonTree)adaptor.dupNode(char_literal89);

            root_1 = (CommonTree)adaptor.becomeRoot(char_literal89_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:494:12: ( statement )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==MARKUP_STATEMENT||LA18_0==COMMENT||LA18_0==54||LA18_0==57||(LA18_0>=59 && LA18_0<=60)||(LA18_0>=62 && LA18_0<=64)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:494:14: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_blockStatement909);
            	    statement90=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, statement90.getTree());
            	    if ( state.backtracking==0 ) {
            	       
            	      					if(actual != null) { this.current = actual; } 
            	      					else { actual = this.current; } 
            	      				
            	    }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            char_literal91=(CommonTree)match(input,55,FOLLOW_55_in_blockStatement916); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal91_tree = (CommonTree)adaptor.dupNode(char_literal91);

            adaptor.addChild(root_1, char_literal91_tree);
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
    // $ANTLR end "blockStatement"

    public static class letStatement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "letStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:499:1: letStatement : ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) ;
    public final WaebricInterpreter.letStatement_return letStatement() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricInterpreter.letStatement_return retval = new WaebricInterpreter.letStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal92=null;
        CommonTree string_literal94=null;
        CommonTree string_literal96=null;
        WaebricInterpreter.assignment_return assignment93 = null;

        WaebricInterpreter.statement_return statement95 = null;


        CommonTree string_literal92_tree=null;
        CommonTree string_literal94_tree=null;
        CommonTree string_literal96_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new HashMap<String, Integer>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        		Element actual = this.current;
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:505:4: ( ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:505:7: ^( 'let' ( assignment )+ 'in' ( statement )* 'end' )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal92=(CommonTree)match(input,60,FOLLOW_60_in_letStatement944); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal92_tree = (CommonTree)adaptor.dupNode(string_literal92);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal92_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:505:16: ( assignment )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=FUNCTION && LA19_0<=IDCON)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: assignment
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_assignment_in_letStatement946);
            	    assignment93=assignment();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, assignment93.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);

            _last = (CommonTree)input.LT(1);
            string_literal94=(CommonTree)match(input,61,FOLLOW_61_in_letStatement949); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal94_tree = (CommonTree)adaptor.dupNode(string_literal94);

            adaptor.addChild(root_1, string_literal94_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:505:33: ( statement )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==MARKUP_STATEMENT||LA20_0==COMMENT||LA20_0==54||LA20_0==57||(LA20_0>=59 && LA20_0<=60)||(LA20_0>=62 && LA20_0<=64)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:505:35: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_letStatement953);
            	    statement95=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, statement95.getTree());
            	    if ( state.backtracking==0 ) {
            	       
            	      					if(actual != null) { this.current = actual; } 
            	      					else { actual = this.current; } 
            	      				
            	    }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            string_literal96=(CommonTree)match(input,END,FOLLOW_END_in_letStatement960); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal96_tree = (CommonTree)adaptor.dupNode(string_literal96);

            adaptor.addChild(root_1, string_literal96_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:513:1: assignment : ( varBinding | funcBinding );
    public final WaebricInterpreter.assignment_return assignment() throws RecognitionException {
        WaebricInterpreter.assignment_return retval = new WaebricInterpreter.assignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricInterpreter.varBinding_return varBinding97 = null;

        WaebricInterpreter.funcBinding_return funcBinding98 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:513:11: ( varBinding | funcBinding )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==IDCON) ) {
                alt21=1;
            }
            else if ( (LA21_0==FUNCTION) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:513:14: varBinding
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_varBinding_in_assignment974);
                    varBinding97=varBinding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, varBinding97.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:513:27: funcBinding
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_funcBinding_in_assignment978);
                    funcBinding98=funcBinding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, funcBinding98.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:515:1: varBinding : IDCON '=' expression ';' ;
    public final WaebricInterpreter.varBinding_return varBinding() throws RecognitionException {
        WaebricInterpreter.varBinding_return retval = new WaebricInterpreter.varBinding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON99=null;
        CommonTree char_literal100=null;
        CommonTree char_literal102=null;
        WaebricInterpreter.expression_return expression101 = null;


        CommonTree IDCON99_tree=null;
        CommonTree char_literal100_tree=null;
        CommonTree char_literal102_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:515:11: ( IDCON '=' expression ';' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:515:14: IDCON '=' expression ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON99=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_varBinding989); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON99_tree = (CommonTree)adaptor.dupNode(IDCON99);

            adaptor.addChild(root_0, IDCON99_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal100=(CommonTree)match(input,51,FOLLOW_51_in_varBinding991); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal100_tree = (CommonTree)adaptor.dupNode(char_literal100);

            adaptor.addChild(root_0, char_literal100_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_varBinding993);
            expression101=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, expression101.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal102=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_varBinding995); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal102_tree = (CommonTree)adaptor.dupNode(char_literal102);

            adaptor.addChild(root_0, char_literal102_tree);
            }
            if ( state.backtracking==0 ) {

              				defineVariable(IDCON99.getText(), (expression101!=null?expression101.index:0));
              			
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:519:1: funcBinding : ^( FUNCTION id= IDCON formals . ) ;
    public final WaebricInterpreter.funcBinding_return funcBinding() throws RecognitionException {
        WaebricInterpreter.funcBinding_return retval = new WaebricInterpreter.funcBinding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        CommonTree FUNCTION103=null;
        CommonTree wildcard105=null;
        WaebricInterpreter.formals_return formals104 = null;


        CommonTree id_tree=null;
        CommonTree FUNCTION103_tree=null;
        CommonTree wildcard105_tree=null;

         int index = input.index(); 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:521:2: ( ^( FUNCTION id= IDCON formals . ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:521:5: ^( FUNCTION id= IDCON formals . )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNCTION103=(CommonTree)match(input,FUNCTION,FOLLOW_FUNCTION_in_funcBinding1019); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FUNCTION103_tree = (CommonTree)adaptor.dupNode(FUNCTION103);

            root_1 = (CommonTree)adaptor.becomeRoot(FUNCTION103_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_funcBinding1023); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (CommonTree)adaptor.dupNode(id);

            adaptor.addChild(root_1, id_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_formals_in_funcBinding1025);
            formals104=formals();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, formals104.getTree());
            _last = (CommonTree)input.LT(1);
            wildcard105=(CommonTree)input.LT(1);
            matchAny(input); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            wildcard105_tree = (CommonTree)adaptor.dupTree(wildcard105);
            adaptor.addChild(root_1, wildcard105_tree);
            }

            match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }

            if ( state.backtracking==0 ) {
               
              				environments.put(id.getText(), cloneEnvironment());
              				defineFunction(id.getText(), index); 
              			
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
    // $ANTLR end "funcBinding"

    public static class predicate_return extends TreeRuleReturnScope {
        public boolean eval;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "predicate"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:529:1: predicate returns [boolean eval] : ( '!' p= predicate | e= expression | e= expression '.' ( 'list' | 'record' | 'string' ) '?' ) ( '&&' p= predicate | '||' p= predicate )* ;
    public final WaebricInterpreter.predicate_return predicate() throws RecognitionException {
        WaebricInterpreter.predicate_return retval = new WaebricInterpreter.predicate_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal106=null;
        CommonTree char_literal107=null;
        CommonTree string_literal108=null;
        CommonTree string_literal109=null;
        CommonTree string_literal110=null;
        CommonTree char_literal111=null;
        CommonTree string_literal112=null;
        CommonTree string_literal113=null;
        WaebricInterpreter.predicate_return p = null;

        WaebricInterpreter.expression_return e = null;


        CommonTree char_literal106_tree=null;
        CommonTree char_literal107_tree=null;
        CommonTree string_literal108_tree=null;
        CommonTree string_literal109_tree=null;
        CommonTree string_literal110_tree=null;
        CommonTree char_literal111_tree=null;
        CommonTree string_literal112_tree=null;
        CommonTree string_literal113_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:530:2: ( ( '!' p= predicate | e= expression | e= expression '.' ( 'list' | 'record' | 'string' ) '?' ) ( '&&' p= predicate | '||' p= predicate )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:530:5: ( '!' p= predicate | e= expression | e= expression '.' ( 'list' | 'record' | 'string' ) '?' ) ( '&&' p= predicate | '||' p= predicate )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:530:5: ( '!' p= predicate | e= expression | e= expression '.' ( 'list' | 'record' | 'string' ) '?' )
            int alt23=3;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:530:7: '!' p= predicate
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal106=(CommonTree)match(input,65,FOLLOW_65_in_predicate1051); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal106_tree = (CommonTree)adaptor.dupNode(char_literal106);

                    adaptor.addChild(root_0, char_literal106_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_predicate1055);
                    p=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, p.getTree());
                    if ( state.backtracking==0 ) {
                       retval.eval = ! (p!=null?p.eval:false); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:531:7: e= expression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate1067);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, e.getTree());
                    if ( state.backtracking==0 ) {
                       retval.eval = (e!=null?e.index:0) != -1; 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:532:7: e= expression '.' ( 'list' | 'record' | 'string' ) '?'
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate1080);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, e.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal107=(CommonTree)match(input,41,FOLLOW_41_in_predicate1082); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal107_tree = (CommonTree)adaptor.dupNode(char_literal107);

                    adaptor.addChild(root_0, char_literal107_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:532:24: ( 'list' | 'record' | 'string' )
                    int alt22=3;
                    switch ( input.LA(1) ) {
                    case 69:
                        {
                        alt22=1;
                        }
                        break;
                    case 70:
                        {
                        alt22=2;
                        }
                        break;
                    case 71:
                        {
                        alt22=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 0, input);

                        throw nvae;
                    }

                    switch (alt22) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:532:26: 'list'
                            {
                            _last = (CommonTree)input.LT(1);
                            string_literal108=(CommonTree)match(input,69,FOLLOW_69_in_predicate1086); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal108_tree = (CommonTree)adaptor.dupNode(string_literal108);

                            adaptor.addChild(root_0, string_literal108_tree);
                            }
                            if ( state.backtracking==0 ) {

                              							retval.eval = (e!=null?e.eval:null).startsWith("[");
                              						 
                            }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:534:12: 'record'
                            {
                            _last = (CommonTree)input.LT(1);
                            string_literal109=(CommonTree)match(input,70,FOLLOW_70_in_predicate1092); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal109_tree = (CommonTree)adaptor.dupNode(string_literal109);

                            adaptor.addChild(root_0, string_literal109_tree);
                            }
                            if ( state.backtracking==0 ) {
                               
                              						 	retval.eval = (e!=null?e.eval:null).startsWith("{");
                              						 
                            }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 3 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:536:12: 'string'
                            {
                            _last = (CommonTree)input.LT(1);
                            string_literal110=(CommonTree)match(input,71,FOLLOW_71_in_predicate1098); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal110_tree = (CommonTree)adaptor.dupNode(string_literal110);

                            adaptor.addChild(root_0, string_literal110_tree);
                            }
                            if ( state.backtracking==0 ) {
                               
                              						 	retval.eval = (e!=null?e.index:0) != -1;
                              						 
                            }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }

                    _last = (CommonTree)input.LT(1);
                    char_literal111=(CommonTree)match(input,66,FOLLOW_66_in_predicate1104); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal111_tree = (CommonTree)adaptor.dupNode(char_literal111);

                    adaptor.addChild(root_0, char_literal111_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:539:6: ( '&&' p= predicate | '||' p= predicate )*
            loop24:
            do {
                int alt24=3;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==67) ) {
                    int LA24_2 = input.LA(2);

                    if ( (synpred45_WaebricInterpreter()) ) {
                        alt24=1;
                    }


                }
                else if ( (LA24_0==68) ) {
                    int LA24_3 = input.LA(2);

                    if ( (synpred46_WaebricInterpreter()) ) {
                        alt24=2;
                    }


                }


                switch (alt24) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:539:8: '&&' p= predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal112=(CommonTree)match(input,67,FOLLOW_67_in_predicate1114); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal112_tree = (CommonTree)adaptor.dupNode(string_literal112);

            	    adaptor.addChild(root_0, string_literal112_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate1118);
            	    p=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, p.getTree());
            	    if ( state.backtracking==0 ) {
            	       retval.eval = retval.eval && (p!=null?p.eval:false); 
            	    }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:539:57: '||' p= predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal113=(CommonTree)match(input,68,FOLLOW_68_in_predicate1124); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal113_tree = (CommonTree)adaptor.dupNode(string_literal113);

            	    adaptor.addChild(root_0, string_literal113_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate1128);
            	    p=predicate();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, p.getTree());
            	    if ( state.backtracking==0 ) {
            	       retval.eval = retval.eval || (p!=null?p.eval:false); 
            	    }

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

    public static class embedding_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "embedding"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:544:1: embedding[boolean element] : PRETEXT embed[element] textTail[element] ;
    public final WaebricInterpreter.embedding_return embedding(boolean element) throws RecognitionException {
        WaebricInterpreter.embedding_return retval = new WaebricInterpreter.embedding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PRETEXT114=null;
        WaebricInterpreter.embed_return embed115 = null;

        WaebricInterpreter.textTail_return textTail116 = null;


        CommonTree PRETEXT114_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:545:2: ( PRETEXT embed[element] textTail[element] )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:545:5: PRETEXT embed[element] textTail[element]
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PRETEXT114=(CommonTree)match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding1151); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRETEXT114_tree = (CommonTree)adaptor.dupNode(PRETEXT114);

            adaptor.addChild(root_0, PRETEXT114_tree);
            }
            if ( state.backtracking==0 ) {
               addContent(new Text(PRETEXT114.getText().substring(1, PRETEXT114.getText().length()-1))); 
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_embed_in_embedding1159);
            embed115=embed(element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, embed115.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_textTail_in_embedding1162);
            textTail116=textTail(element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, textTail116.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:548:1: embed[boolean element] : ( ( markup[element] )+ | ( markup[element] )* expression );
    public final WaebricInterpreter.embed_return embed(boolean element) throws RecognitionException {
        WaebricInterpreter.embed_return retval = new WaebricInterpreter.embed_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricInterpreter.markup_return markup117 = null;

        WaebricInterpreter.markup_return markup118 = null;

        WaebricInterpreter.expression_return expression119 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:549:2: ( ( markup[element] )+ | ( markup[element] )* expression )
            int alt27=2;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:549:5: ( markup[element] )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:549:5: ( markup[element] )+
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
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup[element]
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed1176);
                    	    markup117=markup(element);

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup117.getTree());

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


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:550:6: ( markup[element] )* expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:550:6: ( markup[element] )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==MARKUP) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup[element]
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed1186);
                    	    markup118=markup(element);

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup118.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_embed1190);
                    expression119=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression119.getTree());
                    if ( state.backtracking==0 ) {
                       addContent(new Text((expression119!=null?expression119.eval:null))); 
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
    // $ANTLR end "embed"

    public static class textTail_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "textTail"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:552:1: textTail[boolean element] : ( POSTTEXT | MIDTEXT embed[element] textTail[element] );
    public final WaebricInterpreter.textTail_return textTail(boolean element) throws RecognitionException {
        WaebricInterpreter.textTail_return retval = new WaebricInterpreter.textTail_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POSTTEXT120=null;
        CommonTree MIDTEXT121=null;
        WaebricInterpreter.embed_return embed122 = null;

        WaebricInterpreter.textTail_return textTail123 = null;


        CommonTree POSTTEXT120_tree=null;
        CommonTree MIDTEXT121_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:553:2: ( POSTTEXT | MIDTEXT embed[element] textTail[element] )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==POSTTEXT) ) {
                alt28=1;
            }
            else if ( (LA28_0==MIDTEXT) ) {
                alt28=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:553:5: POSTTEXT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    POSTTEXT120=(CommonTree)match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail1205); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    POSTTEXT120_tree = (CommonTree)adaptor.dupNode(POSTTEXT120);

                    adaptor.addChild(root_0, POSTTEXT120_tree);
                    }
                    if ( state.backtracking==0 ) {
                       addContent(new Text(POSTTEXT120.getText().substring(1, POSTTEXT120.getText().length()-1))); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:554:6: MIDTEXT embed[element] textTail[element]
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    MIDTEXT121=(CommonTree)match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail1214); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MIDTEXT121_tree = (CommonTree)adaptor.dupNode(MIDTEXT121);

                    adaptor.addChild(root_0, MIDTEXT121_tree);
                    }
                    if ( state.backtracking==0 ) {
                       addContent(new Text(MIDTEXT121.getText().substring(1, MIDTEXT121.getText().length()-1))); 
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embed_in_textTail1221);
                    embed122=embed(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, embed122.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_textTail_in_textTail1224);
                    textTail123=textTail(element);

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

    // $ANTLR start synpred18_WaebricInterpreter
    public final void synpred18_WaebricInterpreter_fragment() throws RecognitionException {   
        WaebricInterpreter.expression_return e = null;


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:373:6: ( '+' e= expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:373:6: '+' e= expression
        {
        match(input,56,FOLLOW_56_in_synpred18_WaebricInterpreter450); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred18_WaebricInterpreter454);
        e=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_WaebricInterpreter

    // $ANTLR start synpred19_WaebricInterpreter
    public final void synpred19_WaebricInterpreter_fragment() throws RecognitionException {   
        CommonTree id=null;

        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:379:6: ( '.' id= IDCON )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:379:6: '.' id= IDCON
        {
        match(input,41,FOLLOW_41_in_synpred19_WaebricInterpreter464); if (state.failed) return ;
        id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_synpred19_WaebricInterpreter468); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_WaebricInterpreter

    // $ANTLR start synpred42_WaebricInterpreter
    public final void synpred42_WaebricInterpreter_fragment() throws RecognitionException {   
        WaebricInterpreter.expression_return e = null;


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:531:7: (e= expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:531:7: e= expression
        {
        pushFollow(FOLLOW_expression_in_synpred42_WaebricInterpreter1067);
        e=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred42_WaebricInterpreter

    // $ANTLR start synpred45_WaebricInterpreter
    public final void synpred45_WaebricInterpreter_fragment() throws RecognitionException {   
        WaebricInterpreter.predicate_return p = null;


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:539:8: ( '&&' p= predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:539:8: '&&' p= predicate
        {
        match(input,67,FOLLOW_67_in_synpred45_WaebricInterpreter1114); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred45_WaebricInterpreter1118);
        p=predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred45_WaebricInterpreter

    // $ANTLR start synpred46_WaebricInterpreter
    public final void synpred46_WaebricInterpreter_fragment() throws RecognitionException {   
        WaebricInterpreter.predicate_return p = null;


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:539:57: ( '||' p= predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:539:57: '||' p= predicate
        {
        match(input,68,FOLLOW_68_in_synpred46_WaebricInterpreter1124); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred46_WaebricInterpreter1128);
        p=predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_WaebricInterpreter

    // Delegated rules

    public final boolean synpred46_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_WaebricInterpreter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_WaebricInterpreter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_WaebricInterpreter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred42_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_WaebricInterpreter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred45_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_WaebricInterpreter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA15 dfa15 = new DFA15(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA27 dfa27 = new DFA27(this);
    static final String DFA15_eotS =
        "\15\uffff";
    static final String DFA15_eofS =
        "\15\uffff";
    static final String DFA15_minS =
        "\1\7\5\uffff\1\2\3\uffff\1\13\2\uffff";
    static final String DFA15_maxS =
        "\1\100\5\uffff\1\2\3\uffff\1\66\2\uffff";
    static final String DFA15_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\11\1\12\1\uffff\1\6"+
        "\1\7";
    static final String DFA15_specialS =
        "\15\uffff}>";
    static final String[] DFA15_transitionS = {
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
            "\1\13\1\uffff\3\13\1\uffff\1\14\42\uffff\1\13\1\uffff\1\13",
            "",
            ""
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "415:1: statement : ( ifStatement | eachStatement | letStatement | blockStatement | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding[false] ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT markup[true] markupChain ) );";
        }
    }
    static final String DFA23_eotS =
        "\12\uffff";
    static final String DFA23_eofS =
        "\12\uffff";
    static final String DFA23_minS =
        "\1\13\1\uffff\6\0\2\uffff";
    static final String DFA23_maxS =
        "\1\101\1\uffff\6\0\2\uffff";
    static final String DFA23_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\1\3";
    static final String DFA23_specialS =
        "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\2\uffff}>";
    static final String[] DFA23_transitionS = {
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

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "530:5: ( '!' p= predicate | e= expression | e= expression '.' ( 'list' | 'record' | 'string' ) '?' )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TreeNodeStream input = (TreeNodeStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_2 = input.LA(1);

                         
                        int index23_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index23_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA23_3 = input.LA(1);

                         
                        int index23_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index23_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA23_4 = input.LA(1);

                         
                        int index23_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index23_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA23_5 = input.LA(1);

                         
                        int index23_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index23_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA23_6 = input.LA(1);

                         
                        int index23_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index23_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA23_7 = input.LA(1);

                         
                        int index23_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index23_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 23, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA27_eotS =
        "\17\uffff";
    static final String DFA27_eofS =
        "\17\uffff";
    static final String DFA27_minS =
        "\1\6\1\2\1\uffff\1\13\1\4\2\2\1\4\1\6\1\4\1\3\1\uffff\1\3\1\4\1"+
        "\3";
    static final String DFA27_maxS =
        "\1\66\1\2\1\uffff\1\13\2\107\1\3\1\107\1\66\2\107\1\uffff\2\107"+
        "\1\3";
    static final String DFA27_acceptS =
        "\2\uffff\1\2\10\uffff\1\1\3\uffff";
    static final String DFA27_specialS =
        "\17\uffff}>";
    static final String[] DFA27_transitionS = {
            "\1\1\4\uffff\1\2\1\uffff\3\2\44\uffff\1\2\1\uffff\1\2",
            "\1\3",
            "",
            "\1\4",
            "\104\5",
            "\1\7\1\uffff\104\6",
            "\1\11\1\10",
            "\104\12",
            "\1\1\4\uffff\1\2\1\uffff\3\2\2\uffff\2\13\40\uffff\1\2\1\uffff"+
            "\1\2",
            "\104\14",
            "\1\15\104\12",
            "",
            "\1\16\104\14",
            "\104\6",
            "\1\10"
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
            return "548:1: embed[boolean element] : ( ( markup[element] )+ | ( markup[element] )* expression );";
        }
    }
 

    public static final BitSet FOLLOW_PATH_in_mapping78 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_mapping80 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_markup_in_mapping82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUP_in_markup113 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_markup115 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x00000000000000FFL});
    public static final BitSet FOLLOW_ATTRIBUTES_in_attributes141 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attribute_in_attributes143 = new BitSet(new long[]{0x00007A0000000008L});
    public static final BitSet FOLLOW_44_in_attribute155 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDCON_in_attribute157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_attribute166 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDCON_in_attribute168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_attribute177 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDCON_in_attribute179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_attribute188 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDCON_in_attribute190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_attribute199 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NATCON_in_attribute203 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_47_in_attribute213 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NATCON_in_attribute217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARGUMENTS_in_arguments244 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_argument_in_arguments246 = new BitSet(new long[]{0x005000000000E808L});
    public static final BitSet FOLLOW_expression_in_argument263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_argument269 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_argument271 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_argument273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_expression306 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_NATCON_in_expression315 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_TEXT_in_expression324 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_SYMBOLCON_in_expression333 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_52_in_expression342 = new BitSet(new long[]{0x007200000000E800L});
    public static final BitSet FOLLOW_expression_in_expression348 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_49_in_expression363 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_expression367 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_53_in_expression374 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_54_in_expression383 = new BitSet(new long[]{0x0082000000000800L});
    public static final BitSet FOLLOW_IDCON_in_expression389 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_expression391 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_expression395 = new BitSet(new long[]{0x0082000000000000L});
    public static final BitSet FOLLOW_49_in_expression410 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDCON_in_expression414 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_expression416 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_expression420 = new BitSet(new long[]{0x0082000000000000L});
    public static final BitSet FOLLOW_55_in_expression427 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_56_in_expression450 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_expression454 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_41_in_expression464 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDCON_in_expression468 = new BitSet(new long[]{0x0100020000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_function501 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_function503 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_FORMALS_in_function517 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_function523 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_statement_in_function548 = new BitSet(new long[]{0xDA40000000100088L,0x0000000000000001L});
    public static final BitSet FOLLOW_FORMALS_in_formals569 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_formals571 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_ifStatement_in_statement587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_eachStatement_in_statement594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_letStatement_in_statement601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blockStatement_in_statement608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMENT_in_statement617 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRCON_in_statement619 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement621 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_62_in_statement634 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement636 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement638 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_62_in_statement651 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_statement653 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement656 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_63_in_statement667 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement669 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement671 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_64_in_statement682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement693 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement695 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_markupChain_in_statement700 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_CHAIN_in_markupChain724 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_markupChain726 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_markupChain_in_markupChain731 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_CHAIN_in_markupChain742 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_markupChain744 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_markupChain746 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_CHAIN_in_markupChain759 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_markupChain761 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_CHAIN_in_markupChain772 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_markupChain774 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_markupChain777 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_CHAIN_in_markupChain788 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SEMICOLON_in_markupChain790 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_57_in_ifStatement810 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_48_in_ifStatement812 = new BitSet(new long[]{0x005000000000E800L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_ifStatement814 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_ifStatement816 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x00000000000000FFL});
    public static final BitSet FOLLOW_58_in_ifStatement827 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x00000000000000FFL});
    public static final BitSet FOLLOW_59_in_eachStatement867 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_48_in_eachStatement869 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDCON_in_eachStatement871 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_eachStatement873 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_eachStatement877 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_eachStatement879 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x00000000000000FFL});
    public static final BitSet FOLLOW_54_in_blockStatement905 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_blockStatement909 = new BitSet(new long[]{0xDAC0000000100088L,0x0000000000000001L});
    public static final BitSet FOLLOW_55_in_blockStatement916 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_60_in_letStatement944 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_assignment_in_letStatement946 = new BitSet(new long[]{0x2000000000000C00L});
    public static final BitSet FOLLOW_61_in_letStatement949 = new BitSet(new long[]{0xDA40000000500088L,0x0000000000000001L});
    public static final BitSet FOLLOW_statement_in_letStatement953 = new BitSet(new long[]{0xDA40000000500088L,0x0000000000000001L});
    public static final BitSet FOLLOW_END_in_letStatement960 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_varBinding_in_assignment974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funcBinding_in_assignment978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_varBinding989 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_varBinding991 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_varBinding993 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_varBinding995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_funcBinding1019 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_funcBinding1023 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_formals_in_funcBinding1025 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x00000000000000FFL});
    public static final BitSet FOLLOW_65_in_predicate1051 = new BitSet(new long[]{0x005000000000E800L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_predicate1055 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_expression_in_predicate1067 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_expression_in_predicate1080 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_predicate1082 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_69_in_predicate1086 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_70_in_predicate1092 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_71_in_predicate1098 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_predicate1104 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_67_in_predicate1114 = new BitSet(new long[]{0x005000000000E800L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_predicate1118 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_68_in_predicate1124 = new BitSet(new long[]{0x005000000000E800L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_predicate1128 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding1151 = new BitSet(new long[]{0x005000000000E840L});
    public static final BitSet FOLLOW_embed_in_embedding1159 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_textTail_in_embedding1162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed1176 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_markup_in_embed1186 = new BitSet(new long[]{0x005000000000E840L});
    public static final BitSet FOLLOW_expression_in_embed1190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail1205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail1214 = new BitSet(new long[]{0x005000000000E840L});
    public static final BitSet FOLLOW_embed_in_textTail1221 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_textTail_in_textTail1224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred18_WaebricInterpreter450 = new BitSet(new long[]{0x005000000000E800L});
    public static final BitSet FOLLOW_expression_in_synpred18_WaebricInterpreter454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_synpred19_WaebricInterpreter464 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDCON_in_synpred19_WaebricInterpreter468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred42_WaebricInterpreter1067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_synpred45_WaebricInterpreter1114 = new BitSet(new long[]{0x005000000000E800L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_synpred45_WaebricInterpreter1118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_synpred46_WaebricInterpreter1124 = new BitSet(new long[]{0x005000000000E800L,0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_synpred46_WaebricInterpreter1128 = new BitSet(new long[]{0x0000000000000002L});

}