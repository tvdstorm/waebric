// $ANTLR 3.1.2 /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g 2009-09-02 13:45:10

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATTRIBUTES", "ARGUMENTS", "MARKUP", "MARKUP_STATEMENT", "MARKUP_CHAIN", "FUNCTION", "EXPRESSION", "EMBEDDING", "IDCON", "PATH", "NATCON", "TEXT", "SYMBOLCON", "STRCON", "PRETEXT", "POSTTEXT", "MIDTEXT", "COMMENT", "SITE", "END", "SEMICOLON", "LETTER", "DIGIT", "HEXADECIMAL", "PATHELEMENT", "FILEEXT", "STRCHAR", "ESCLAYOUT", "DECIMAL", "TEXTCHAR", "ESCQUOTE", "AMP", "CHARREF", "ENTREF", "SYMBOLCHAR", "COMMENTS", "LAYOUT", "'module'", "'.'", "'import'", "':'", "'#'", "'$'", "'@'", "'%'", "'('", "','", "')'", "'='", "'['", "']'", "'{'", "'}'", "'+'", "'if'", "'else'", "'each'", "'let'", "'in'", "'echo'", "'cdata'", "'yield;'", "'!'", "'?'", "'&&'", "'||'", "'list'", "'record'", "'string'"
    };
    public static final int ESCLAYOUT=31;
    public static final int T__42=42;
    public static final int END=23;
    public static final int T__57=57;
    public static final int T__51=51;
    public static final int FILEEXT=29;
    public static final int T__69=69;
    public static final int T__47=47;
    public static final int T__50=50;
    public static final int STRCHAR=30;
    public static final int T__65=65;
    public static final int SYMBOLCON=16;
    public static final int T__72=72;
    public static final int COMMENTS=39;
    public static final int IDCON=12;
    public static final int DECIMAL=32;
    public static final int T__70=70;
    public static final int T__67=67;
    public static final int HEXADECIMAL=27;
    public static final int TEXTCHAR=33;
    public static final int EXPRESSION=10;
    public static final int T__52=52;
    public static final int T__46=46;
    public static final int T__68=68;
    public static final int FUNCTION=9;
    public static final int T__62=62;
    public static final int EMBEDDING=11;
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
    public static final int MARKUP_CHAIN=8;
    public static final int ESCQUOTE=34;
    public static final int LAYOUT=40;
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
    public static final int MARKUP_STATEMENT=7;
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
    public static final int T__71=71;
    public static final int PATH=13;

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
    	private int depth = 0;
    	
    	// Yield stack
    	private Stack<Yieldable> yieldStack = new Stack<Yieldable>();
    	public class Yieldable {
    		public Integer index;
    		public Stack environment;
    	}
    	
    	// Functions with yield statements
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
    			outputDocument(document, os);
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
    				if(! document.hasRootElement()) { createXHTMLRoot(false); }
    				XMLOutputter out = new XMLOutputter(Format.getRawFormat());
    				out.output(document, os);
    			}
    		} catch(IOException e) { e.printStackTrace(); }
    	}
    	
    	/**
    	 * Attach content to current element, in-case element
    	 * does not exist create root element.
    	 * @param content
    	 */
    	private void addContent(Content content) {
    		// Update JDOM objects
    		if(current == null) {
    			if(content instanceof Element) {
    				document.setRootElement((Element) content);
    			} else {
    				createXHTMLRoot(false);
    				document.getRootElement().addContent(content);
    			}
    		} else { current.addContent(content); }

    		// Maintain field information
    		if(content instanceof Element) {
    			current = (Element) content;
    			depth++;
    		}
    	}
    	
    	/**
    	 * Create default XHTML root tag
    	 * @return
    	 */
    	private void createXHTMLRoot(boolean namespace) {
    		Element html;
    		if(namespace) {
    			Namespace XHTML = Namespace.getNamespace("xhtml", "http://www.w3.org/1999/xhtml");
    			html = new Element("html", XHTML);
    			html.setAttribute("lang", "en");
    		} else { html = new Element("html"); }
    		document.setRootElement(html);
    		current = html;
    	}
    	
    	/**
    	 * Attach attribute value to current element
    	 * @param att Attribute name
    	 * @param value Added value
    	 */
    	private void addAttributeValue(String att, String value) {
    		org.jdom.Attribute attribute = current.getAttribute(att);
    		
    		String actual = "";
    		if(attribute != null) { actual = attribute.getValue() + " "; }
    		current.setAttribute(att, actual + value);
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
    	
    	private void restoreCurrent(int arg) {
    		for(int i = 0; depth > arg; i++) {
    			current = current.getParentElement();
    			depth--;
    		}
    	}

    	public void addYield(Integer index) {
    		Yieldable element = new Yieldable();
    		element.index = index;
    		element.environment = cloneEnvironment();
    		yieldStack.push(element);
    	}
    	


    public static class mapping_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mapping"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:296:1: mapping : PATH ':' markup[false] ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:298:2: ( PATH ':' markup[false] )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:298:5: PATH ':' markup[false]
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PATH1=(CommonTree)match(input,PATH,FOLLOW_PATH_in_mapping78); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PATH1_tree = (CommonTree)adaptor.dupNode(PATH1);

            adaptor.addChild(root_0, PATH1_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal2=(CommonTree)match(input,44,FOLLOW_44_in_mapping80); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:310:1: markup[boolean element] returns [boolean yield = false;] : ^( MARKUP IDCON . . ) ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:313:2: ( ^( MARKUP IDCON . . ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:313:5: ^( MARKUP IDCON . . )
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
              						addYield(start);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:342:1: attributes : ^( ATTRIBUTES ( attribute )* ) ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:342:11: ( ^( ATTRIBUTES ( attribute )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:342:14: ^( ATTRIBUTES ( attribute )* )
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
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:342:28: ( attribute )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==42||(LA1_0>=44 && LA1_0<=47)) ) {
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:344:1: attribute : ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' w= NATCON ( '%' h= NATCON )? );
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:344:10: ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' w= NATCON ( '%' h= NATCON )? )
            int alt3=5;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt3=1;
                }
                break;
            case 42:
                {
                alt3=2;
                }
                break;
            case 46:
                {
                alt3=3;
                }
                break;
            case 44:
                {
                alt3=4;
                }
                break;
            case 47:
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:344:13: '#' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal10=(CommonTree)match(input,45,FOLLOW_45_in_attribute155); if (state.failed) return retval;
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
                       addAttributeValue("id", IDCON11.getText()); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:345:6: '.' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal12=(CommonTree)match(input,42,FOLLOW_42_in_attribute166); if (state.failed) return retval;
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
                       addAttributeValue("class", IDCON13.getText()); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:346:6: '$' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal14=(CommonTree)match(input,46,FOLLOW_46_in_attribute177); if (state.failed) return retval;
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
                       addAttributeValue("name", IDCON15.getText()); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:347:6: ':' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal16=(CommonTree)match(input,44,FOLLOW_44_in_attribute188); if (state.failed) return retval;
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
                       addAttributeValue("type", IDCON17.getText()); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:348:6: '@' w= NATCON ( '%' h= NATCON )?
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal18=(CommonTree)match(input,47,FOLLOW_47_in_attribute199); if (state.failed) return retval;
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
                       addAttributeValue("width", w.getText()); 
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:349:5: ( '%' h= NATCON )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==48) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:349:7: '%' h= NATCON
                            {
                            _last = (CommonTree)input.LT(1);
                            char_literal19=(CommonTree)match(input,48,FOLLOW_48_in_attribute213); if (state.failed) return retval;
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
                               addAttributeValue("height", h.getText()); 
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:351:1: arguments[boolean call] returns [List<Integer> args = new ArrayList<Integer>()] : ^( ARGUMENTS ( argument[$args, call] )* ) ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:353:2: ( ^( ARGUMENTS ( argument[$args, call] )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:353:5: ^( ARGUMENTS ( argument[$args, call] )* )
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
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:353:18: ( argument[$args, call] )*
                loop4:
                do {
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==IDCON||(LA4_0>=NATCON && LA4_0<=SYMBOLCON)||LA4_0==53||LA4_0==55) ) {
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:355:1: argument[List<Integer> args, boolean call] : ( expression | IDCON '=' expression );
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:356:2: ( expression | IDCON '=' expression )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==IDCON) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==52) ) {
                    alt5=2;
                }
                else if ( (LA5_1==EOF||LA5_1==UP||LA5_1==IDCON||(LA5_1>=NATCON && LA5_1<=SYMBOLCON)||LA5_1==42||LA5_1==53||LA5_1==55||LA5_1==57) ) {
                    alt5=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA5_0>=NATCON && LA5_0<=SYMBOLCON)||LA5_0==53||LA5_0==55) ) {
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:356:5: expression
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:366:8: IDCON '=' expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDCON23=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_argument269); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON23_tree = (CommonTree)adaptor.dupNode(IDCON23);

                    adaptor.addChild(root_0, IDCON23_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal24=(CommonTree)match(input,52,FOLLOW_52_in_argument271); if (state.failed) return retval;
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
                      					} else { addAttributeValue(IDCON23.getText(), (expression25!=null?expression25.eval:null)); }
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:380:1: expression returns [\n\t\tint index = -1, // Used for interpreting a referenced variable\n\t\tString eval = \"undef\", // Evaluation value for printing\n\t\tMap<String, expression_return> map = new HashMap<String, expression_return>(), // Map structure for fields\n\t\tCollection<expression_return> collection = new ArrayList() // List structure for iterations\n\t] : (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (id= IDCON ':' e= expression )? ( ',' id= IDCON ':' e= expression )* '}' ) ( '+' e= expression | '.' id= IDCON )* ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:386:2: ( (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (id= IDCON ':' e= expression )? ( ',' id= IDCON ':' e= expression )* '}' ) ( '+' e= expression | '.' id= IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:387:4: (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (id= IDCON ':' e= expression )? ( ',' id= IDCON ':' e= expression )* '}' ) ( '+' e= expression | '.' id= IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:387:4: (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (id= IDCON ':' e= expression )? ( ',' id= IDCON ':' e= expression )* '}' )
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
            case 53:
                {
                alt10=5;
                }
                break;
            case 55:
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:387:6: var= IDCON
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
                      					} else { retval.index = -1; } // Undefined variable
                      				
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:397:6: NATCON
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:398:6: TEXT
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:399:6: SYMBOLCON
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:400:6: '[' (e= expression )? ( ',' e= expression )* ']'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal29=(CommonTree)match(input,53,FOLLOW_53_in_expression342); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal29_tree = (CommonTree)adaptor.dupNode(char_literal29);

                    adaptor.addChild(root_0, char_literal29_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:400:10: (e= expression )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==IDCON||(LA6_0>=NATCON && LA6_0<=SYMBOLCON)||LA6_0==53||LA6_0==55) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:400:12: e= expression
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

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:401:6: ( ',' e= expression )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==50) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:401:8: ',' e= expression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal30=(CommonTree)match(input,50,FOLLOW_50_in_expression363); if (state.failed) return retval;
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
                    char_literal31=(CommonTree)match(input,54,FOLLOW_54_in_expression374); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:408:6: '{' (id= IDCON ':' e= expression )? ( ',' id= IDCON ':' e= expression )* '}'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal32=(CommonTree)match(input,55,FOLLOW_55_in_expression383); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal32_tree = (CommonTree)adaptor.dupNode(char_literal32);

                    adaptor.addChild(root_0, char_literal32_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:408:10: (id= IDCON ':' e= expression )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==IDCON) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:408:12: id= IDCON ':' e= expression
                            {
                            _last = (CommonTree)input.LT(1);
                            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression389); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            id_tree = (CommonTree)adaptor.dupNode(id);

                            adaptor.addChild(root_0, id_tree);
                            }
                            _last = (CommonTree)input.LT(1);
                            char_literal33=(CommonTree)match(input,44,FOLLOW_44_in_expression391); if (state.failed) return retval;
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

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:409:6: ( ',' id= IDCON ':' e= expression )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==50) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:409:8: ',' id= IDCON ':' e= expression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal34=(CommonTree)match(input,50,FOLLOW_50_in_expression410); if (state.failed) return retval;
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
                    	    char_literal35=(CommonTree)match(input,44,FOLLOW_44_in_expression416); if (state.failed) return retval;
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
                    char_literal36=(CommonTree)match(input,56,FOLLOW_56_in_expression427); if (state.failed) return retval;
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

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:420:4: ( '+' e= expression | '.' id= IDCON )*
            loop11:
            do {
                int alt11=3;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==57) ) {
                    int LA11_2 = input.LA(2);

                    if ( (synpred18_WaebricInterpreter()) ) {
                        alt11=1;
                    }


                }
                else if ( (LA11_0==42) ) {
                    int LA11_3 = input.LA(2);

                    if ( (synpred19_WaebricInterpreter()) ) {
                        alt11=2;
                    }


                }


                switch (alt11) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:420:6: '+' e= expression
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal37=(CommonTree)match(input,57,FOLLOW_57_in_expression450); if (state.failed) return retval;
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
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:426:6: '.' id= IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal38=(CommonTree)match(input,42,FOLLOW_42_in_expression464); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:441:1: function[List<Integer> args] : ^( FUNCTION IDCON ( '(' (id= IDCON )* ')' )? ( statement )* ) ;
    public final WaebricInterpreter.function_return function(List<Integer> args) throws RecognitionException {
        WaebricInterpreter.function_return retval = new WaebricInterpreter.function_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        CommonTree FUNCTION39=null;
        CommonTree IDCON40=null;
        CommonTree char_literal41=null;
        CommonTree char_literal42=null;
        WaebricInterpreter.statement_return statement43 = null;


        CommonTree id_tree=null;
        CommonTree FUNCTION39_tree=null;
        CommonTree IDCON40_tree=null;
        CommonTree char_literal41_tree=null;
        CommonTree char_literal42_tree=null;

         Element actual = null; int curr = 0; 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:443:2: ( ^( FUNCTION IDCON ( '(' (id= IDCON )* ')' )? ( statement )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:443:5: ^( FUNCTION IDCON ( '(' (id= IDCON )* ')' )? ( statement )* )
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:445:5: ( '(' (id= IDCON )* ')' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==49) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:445:7: '(' (id= IDCON )* ')'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal41=(CommonTree)match(input,49,FOLLOW_49_in_function517); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal41_tree = (CommonTree)adaptor.dupNode(char_literal41);

                    adaptor.addChild(root_1, char_literal41_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:445:11: (id= IDCON )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==IDCON) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:445:13: id= IDCON
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_function523); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    id_tree = (CommonTree)adaptor.dupNode(id);

                    	    adaptor.addChild(root_1, id_tree);
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      					if(args.size() > curr) { 
                    	      						defineVariable(id.getText(), args.get(curr)); 
                    	      						curr++; 
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

                    _last = (CommonTree)input.LT(1);
                    char_literal42=(CommonTree)match(input,51,FOLLOW_51_in_function530); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal42_tree = (CommonTree)adaptor.dupNode(char_literal42);

                    adaptor.addChild(root_1, char_literal42_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:453:5: ( statement )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==MARKUP_STATEMENT||LA14_0==COMMENT||LA14_0==55||LA14_0==58||(LA14_0>=60 && LA14_0<=61)||(LA14_0>=63 && LA14_0<=65)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:453:7: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_function551);
            	    statement43=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, statement43.getTree());
            	    if ( state.backtracking==0 ) {
            	       
            	      					if(actual != null) { this.current = actual; } 
            	      					else { actual = this.current; } 
            	      				
            	    }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop14;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:459:1: formals : '(' ( IDCON )* ')' ;
    public final WaebricInterpreter.formals_return formals() throws RecognitionException {
        WaebricInterpreter.formals_return retval = new WaebricInterpreter.formals_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal44=null;
        CommonTree IDCON45=null;
        CommonTree char_literal46=null;

        CommonTree char_literal44_tree=null;
        CommonTree IDCON45_tree=null;
        CommonTree char_literal46_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:459:8: ( '(' ( IDCON )* ')' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:459:11: '(' ( IDCON )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            char_literal44=(CommonTree)match(input,49,FOLLOW_49_in_formals570); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal44_tree = (CommonTree)adaptor.dupNode(char_literal44);

            adaptor.addChild(root_0, char_literal44_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:459:15: ( IDCON )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==IDCON) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    IDCON45=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_formals572); if (state.failed) return retval;
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

            _last = (CommonTree)input.LT(1);
            char_literal46=(CommonTree)match(input,51,FOLLOW_51_in_formals575); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal46_tree = (CommonTree)adaptor.dupNode(char_literal46);

            adaptor.addChild(root_0, char_literal46_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:465:1: statement : ( ifStatement | eachStatement | letStatement | blockStatement | ^( 'comment' STRCON ) | ^( 'echo' expression ) | ^( 'echo' embedding[false] ) | ^( 'cdata' expression ) | 'yield;' | ^( MARKUP_STATEMENT markup[true] markupChain ) );
    public final WaebricInterpreter.statement_return statement() throws RecognitionException {
        WaebricInterpreter.statement_return retval = new WaebricInterpreter.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal51=null;
        CommonTree STRCON52=null;
        CommonTree string_literal53=null;
        CommonTree string_literal55=null;
        CommonTree string_literal57=null;
        CommonTree string_literal59=null;
        CommonTree MARKUP_STATEMENT60=null;
        WaebricInterpreter.ifStatement_return ifStatement47 = null;

        WaebricInterpreter.eachStatement_return eachStatement48 = null;

        WaebricInterpreter.letStatement_return letStatement49 = null;

        WaebricInterpreter.blockStatement_return blockStatement50 = null;

        WaebricInterpreter.expression_return expression54 = null;

        WaebricInterpreter.embedding_return embedding56 = null;

        WaebricInterpreter.expression_return expression58 = null;

        WaebricInterpreter.markup_return markup61 = null;

        WaebricInterpreter.markupChain_return markupChain62 = null;


        CommonTree string_literal51_tree=null;
        CommonTree STRCON52_tree=null;
        CommonTree string_literal53_tree=null;
        CommonTree string_literal55_tree=null;
        CommonTree string_literal57_tree=null;
        CommonTree string_literal59_tree=null;
        CommonTree MARKUP_STATEMENT60_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:465:10: ( ifStatement | eachStatement | letStatement | blockStatement | ^( 'comment' STRCON ) | ^( 'echo' expression ) | ^( 'echo' embedding[false] ) | ^( 'cdata' expression ) | 'yield;' | ^( MARKUP_STATEMENT markup[true] markupChain ) )
            int alt16=10;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:465:13: ifStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_ifStatement_in_statement588);
                    ifStatement47=ifStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, ifStatement47.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:466:6: eachStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_eachStatement_in_statement595);
                    eachStatement48=eachStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, eachStatement48.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:467:6: letStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_letStatement_in_statement602);
                    letStatement49=letStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, letStatement49.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:468:6: blockStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_blockStatement_in_statement609);
                    blockStatement50=blockStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, blockStatement50.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:469:6: ^( 'comment' STRCON )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal51=(CommonTree)match(input,COMMENT,FOLLOW_COMMENT_in_statement618); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal51_tree = (CommonTree)adaptor.dupNode(string_literal51);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal51_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    STRCON52=(CommonTree)match(input,STRCON,FOLLOW_STRCON_in_statement620); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRCON52_tree = (CommonTree)adaptor.dupNode(STRCON52);

                    adaptor.addChild(root_1, STRCON52_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                    if ( state.backtracking==0 ) {
                       addContent(new Comment(STRCON52.getText())); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:470:6: ^( 'echo' expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal53=(CommonTree)match(input,63,FOLLOW_63_in_statement633); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal53_tree = (CommonTree)adaptor.dupNode(string_literal53);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal53_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement635);
                    expression54=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression54.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                    if ( state.backtracking==0 ) {
                       addContent(new Text((expression54!=null?expression54.eval:null))); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:471:6: ^( 'echo' embedding[false] )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal55=(CommonTree)match(input,63,FOLLOW_63_in_statement648); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal55_tree = (CommonTree)adaptor.dupNode(string_literal55);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal55_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement650);
                    embedding56=embedding(false);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding56.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:472:6: ^( 'cdata' expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal57=(CommonTree)match(input,64,FOLLOW_64_in_statement662); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal57_tree = (CommonTree)adaptor.dupNode(string_literal57);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal57_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement664);
                    expression58=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression58.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                    if ( state.backtracking==0 ) {
                      	addContent(new CDATA((expression58!=null?expression58.eval:null))); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:473:6: 'yield;'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal59=(CommonTree)match(input,65,FOLLOW_65_in_statement675); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal59_tree = (CommonTree)adaptor.dupNode(string_literal59);

                    adaptor.addChild(root_0, string_literal59_tree);
                    }
                    if ( state.backtracking==0 ) {

                      					if(! yieldStack.isEmpty()) {
                      						Yieldable e = yieldStack.pop();
                      						Stack clone = (Stack) yieldStack.clone();
                      						
                      						Stack actual = cloneEnvironment();
                      						Environment_stack = e.environment;
                      						
                      						int curr = input.index();
                      						input.seek(e.index);
                      						matchAny(input); // Skip already interpreted markup
                      						markupChain(); // Execute copied markup chain
                      						input.seek(curr);
                      						
                      						Environment_stack = actual;
                      						yieldStack = clone;
                      					}	
                      				
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:491:6: ^( MARKUP_STATEMENT markup[true] markupChain )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT60=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement686); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT60_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT60);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT60_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_statement688);
                    markup61=markup(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, markup61.getTree());
                    if ( state.backtracking==0 ) {
                       
                      					if((markup61!=null?markup61.yield:false)) { 
                      						matchAny(input); // Match markup chain, without executing
                      						match(input, Token.UP, null); // Match up
                      						return retval; // Quit parsing markup stm
                      					}
                      				
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markupChain_in_statement693);
                    markupChain62=markupChain();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, markupChain62.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:500:1: markupChain : ( ^( MARKUP_CHAIN markup[true] markupChain ) | ^( MARKUP_CHAIN expression ) | ^( MARKUP_CHAIN statement ) | ^( MARKUP_CHAIN embedding[true] ) | ';' );
    public final WaebricInterpreter.markupChain_return markupChain() throws RecognitionException {
        WaebricInterpreter.markupChain_return retval = new WaebricInterpreter.markupChain_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MARKUP_CHAIN63=null;
        CommonTree MARKUP_CHAIN66=null;
        CommonTree MARKUP_CHAIN68=null;
        CommonTree MARKUP_CHAIN70=null;
        CommonTree char_literal72=null;
        WaebricInterpreter.markup_return markup64 = null;

        WaebricInterpreter.markupChain_return markupChain65 = null;

        WaebricInterpreter.expression_return expression67 = null;

        WaebricInterpreter.statement_return statement69 = null;

        WaebricInterpreter.embedding_return embedding71 = null;


        CommonTree MARKUP_CHAIN63_tree=null;
        CommonTree MARKUP_CHAIN66_tree=null;
        CommonTree MARKUP_CHAIN68_tree=null;
        CommonTree MARKUP_CHAIN70_tree=null;
        CommonTree char_literal72_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:500:12: ( ^( MARKUP_CHAIN markup[true] markupChain ) | ^( MARKUP_CHAIN expression ) | ^( MARKUP_CHAIN statement ) | ^( MARKUP_CHAIN embedding[true] ) | ';' )
            int alt17=5;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==MARKUP_CHAIN) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==DOWN) ) {
                    switch ( input.LA(3) ) {
                    case IDCON:
                    case NATCON:
                    case TEXT:
                    case SYMBOLCON:
                    case 53:
                        {
                        alt17=2;
                        }
                        break;
                    case 55:
                        {
                        int LA17_5 = input.LA(4);

                        if ( (LA17_5==DOWN) ) {
                            alt17=3;
                        }
                        else if ( (LA17_5==IDCON||LA17_5==50||LA17_5==56) ) {
                            alt17=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 17, 5, input);

                            throw nvae;
                        }
                        }
                        break;
                    case PRETEXT:
                        {
                        alt17=4;
                        }
                        break;
                    case MARKUP_STATEMENT:
                    case COMMENT:
                    case 58:
                    case 60:
                    case 61:
                    case 63:
                    case 64:
                    case 65:
                        {
                        alt17=3;
                        }
                        break;
                    case MARKUP:
                        {
                        alt17=1;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 3, input);

                        throw nvae;
                    }

                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA17_0==SEMICOLON) ) {
                alt17=5;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:500:15: ^( MARKUP_CHAIN markup[true] markupChain )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_CHAIN63=(CommonTree)match(input,MARKUP_CHAIN,FOLLOW_MARKUP_CHAIN_in_markupChain717); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_CHAIN63_tree = (CommonTree)adaptor.dupNode(MARKUP_CHAIN63);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_CHAIN63_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_markupChain719);
                    markup64=markup(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, markup64.getTree());
                    if ( state.backtracking==0 ) {

                      					if((markup64!=null?markup64.yield:false)) { 
                      						matchAny(input); // Match markup chain, without executing
                      						match(input, Token.UP, null); // Match up
                      						return retval; // Quit parsing markup stm
                      					}
                      				
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markupChain_in_markupChain724);
                    markupChain65=markupChain();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, markupChain65.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:507:6: ^( MARKUP_CHAIN expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_CHAIN66=(CommonTree)match(input,MARKUP_CHAIN,FOLLOW_MARKUP_CHAIN_in_markupChain735); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_CHAIN66_tree = (CommonTree)adaptor.dupNode(MARKUP_CHAIN66);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_CHAIN66_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_markupChain737);
                    expression67=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression67.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                    if ( state.backtracking==0 ) {
                       addContent(new Text((expression67!=null?expression67.eval:null))); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:508:6: ^( MARKUP_CHAIN statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_CHAIN68=(CommonTree)match(input,MARKUP_CHAIN,FOLLOW_MARKUP_CHAIN_in_markupChain750); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_CHAIN68_tree = (CommonTree)adaptor.dupNode(MARKUP_CHAIN68);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_CHAIN68_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_markupChain752);
                    statement69=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement69.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:509:6: ^( MARKUP_CHAIN embedding[true] )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_CHAIN70=(CommonTree)match(input,MARKUP_CHAIN,FOLLOW_MARKUP_CHAIN_in_markupChain763); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_CHAIN70_tree = (CommonTree)adaptor.dupNode(MARKUP_CHAIN70);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_CHAIN70_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_markupChain765);
                    embedding71=embedding(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding71.getTree());

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:510:6: ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal72=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_markupChain775); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal72_tree = (CommonTree)adaptor.dupNode(char_literal72);

                    adaptor.addChild(root_0, char_literal72_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:512:1: ifStatement : ^( 'if' predicate t= . ( 'else' f= . )? ) ;
    public final WaebricInterpreter.ifStatement_return ifStatement() throws RecognitionException {
        WaebricInterpreter.ifStatement_return retval = new WaebricInterpreter.ifStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal73=null;
        CommonTree string_literal75=null;
        CommonTree t=null;
        CommonTree f=null;
        WaebricInterpreter.predicate_return predicate74 = null;


        CommonTree string_literal73_tree=null;
        CommonTree string_literal75_tree=null;
        CommonTree t_tree=null;
        CommonTree f_tree=null;

         int ti = 0; int fi = 0; 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:514:2: ( ^( 'if' predicate t= . ( 'else' f= . )? ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:514:5: ^( 'if' predicate t= . ( 'else' f= . )? )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal73=(CommonTree)match(input,58,FOLLOW_58_in_ifStatement793); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal73_tree = (CommonTree)adaptor.dupNode(string_literal73);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal73_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_predicate_in_ifStatement795);
            predicate74=predicate();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, predicate74.getTree());
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:514:52: ( 'else' f= . )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==59) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:514:54: 'else' f= .
                    {
                    _last = (CommonTree)input.LT(1);
                    string_literal75=(CommonTree)match(input,59,FOLLOW_59_in_ifStatement806); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal75_tree = (CommonTree)adaptor.dupNode(string_literal75);

                    adaptor.addChild(root_1, string_literal75_tree);
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
              				if((predicate74!=null?predicate74.eval:false)) {
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:527:1: eachStatement : ^( 'each' '(' IDCON ':' e= expression ')' . ) ;
    public final WaebricInterpreter.eachStatement_return eachStatement() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricInterpreter.eachStatement_return retval = new WaebricInterpreter.eachStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal76=null;
        CommonTree char_literal77=null;
        CommonTree IDCON78=null;
        CommonTree char_literal79=null;
        CommonTree char_literal80=null;
        CommonTree wildcard81=null;
        WaebricInterpreter.expression_return e = null;


        CommonTree string_literal76_tree=null;
        CommonTree char_literal77_tree=null;
        CommonTree IDCON78_tree=null;
        CommonTree char_literal79_tree=null;
        CommonTree char_literal80_tree=null;
        CommonTree wildcard81_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new HashMap<String, Integer>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        		int index = 0;
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:533:4: ( ^( 'each' '(' IDCON ':' e= expression ')' . ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:533:7: ^( 'each' '(' IDCON ':' e= expression ')' . )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal76=(CommonTree)match(input,60,FOLLOW_60_in_eachStatement846); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal76_tree = (CommonTree)adaptor.dupNode(string_literal76);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal76_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            char_literal77=(CommonTree)match(input,49,FOLLOW_49_in_eachStatement848); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal77_tree = (CommonTree)adaptor.dupNode(char_literal77);

            adaptor.addChild(root_1, char_literal77_tree);
            }
            _last = (CommonTree)input.LT(1);
            IDCON78=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_eachStatement850); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON78_tree = (CommonTree)adaptor.dupNode(IDCON78);

            adaptor.addChild(root_1, IDCON78_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal79=(CommonTree)match(input,44,FOLLOW_44_in_eachStatement852); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal79_tree = (CommonTree)adaptor.dupNode(char_literal79);

            adaptor.addChild(root_1, char_literal79_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_eachStatement856);
            e=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, e.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal80=(CommonTree)match(input,51,FOLLOW_51_in_eachStatement858); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal80_tree = (CommonTree)adaptor.dupNode(char_literal80);

            adaptor.addChild(root_1, char_literal80_tree);
            }
            if ( state.backtracking==0 ) {
               index = input.index(); 
            }
            _last = (CommonTree)input.LT(1);
            wildcard81=(CommonTree)input.LT(1);
            matchAny(input); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            wildcard81_tree = (CommonTree)adaptor.dupTree(wildcard81);
            adaptor.addChild(root_1, wildcard81_tree);
            }

            match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }

            if ( state.backtracking==0 ) {

              				if(! document.hasRootElement()) { createXHTMLRoot(false); }
              				int depth = this.depth;
              	
              				int actual = input.index();
                            			for(expression_return value: e.collection) {
                            				defineVariable(IDCON78.getText(), value.index);
                            				input.seek(index);
                            				statement();
                            				input.seek(actual);	
                            				restoreCurrent(depth);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:547:1: blockStatement : ^( '{' ( statement )* '}' ) ;
    public final WaebricInterpreter.blockStatement_return blockStatement() throws RecognitionException {
        WaebricInterpreter.blockStatement_return retval = new WaebricInterpreter.blockStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal82=null;
        CommonTree char_literal84=null;
        WaebricInterpreter.statement_return statement83 = null;


        CommonTree char_literal82_tree=null;
        CommonTree char_literal84_tree=null;

         Element actual = this.current; 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:549:2: ( ^( '{' ( statement )* '}' ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:549:5: ^( '{' ( statement )* '}' )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            char_literal82=(CommonTree)match(input,55,FOLLOW_55_in_blockStatement884); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal82_tree = (CommonTree)adaptor.dupNode(char_literal82);

            root_1 = (CommonTree)adaptor.becomeRoot(char_literal82_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:549:12: ( statement )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==MARKUP_STATEMENT||LA19_0==COMMENT||LA19_0==55||LA19_0==58||(LA19_0>=60 && LA19_0<=61)||(LA19_0>=63 && LA19_0<=65)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:549:14: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_blockStatement888);
            	    statement83=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, statement83.getTree());
            	    if ( state.backtracking==0 ) {
            	       
            	      					if(actual != null) { this.current = actual; } 
            	      					else { actual = this.current; } 
            	      				
            	    }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            char_literal84=(CommonTree)match(input,56,FOLLOW_56_in_blockStatement895); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal84_tree = (CommonTree)adaptor.dupNode(char_literal84);

            adaptor.addChild(root_1, char_literal84_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:554:1: letStatement : ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) ;
    public final WaebricInterpreter.letStatement_return letStatement() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricInterpreter.letStatement_return retval = new WaebricInterpreter.letStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal85=null;
        CommonTree string_literal87=null;
        CommonTree string_literal89=null;
        WaebricInterpreter.assignment_return assignment86 = null;

        WaebricInterpreter.statement_return statement88 = null;


        CommonTree string_literal85_tree=null;
        CommonTree string_literal87_tree=null;
        CommonTree string_literal89_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new HashMap<String, Integer>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        		Element actual = this.current;
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:560:4: ( ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:560:7: ^( 'let' ( assignment )+ 'in' ( statement )* 'end' )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal85=(CommonTree)match(input,61,FOLLOW_61_in_letStatement923); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal85_tree = (CommonTree)adaptor.dupNode(string_literal85);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal85_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:560:16: ( assignment )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==FUNCTION||LA20_0==IDCON) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: assignment
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_assignment_in_letStatement925);
            	    assignment86=assignment();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, assignment86.getTree());

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
            string_literal87=(CommonTree)match(input,62,FOLLOW_62_in_letStatement928); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal87_tree = (CommonTree)adaptor.dupNode(string_literal87);

            adaptor.addChild(root_1, string_literal87_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:560:33: ( statement )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==MARKUP_STATEMENT||LA21_0==COMMENT||LA21_0==55||LA21_0==58||(LA21_0>=60 && LA21_0<=61)||(LA21_0>=63 && LA21_0<=65)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:560:35: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_letStatement932);
            	    statement88=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, statement88.getTree());
            	    if ( state.backtracking==0 ) {
            	       
            	      					if(actual != null) { this.current = actual; } 
            	      					else { actual = this.current; } 
            	      				
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
            string_literal89=(CommonTree)match(input,END,FOLLOW_END_in_letStatement939); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal89_tree = (CommonTree)adaptor.dupNode(string_literal89);

            adaptor.addChild(root_1, string_literal89_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:568:1: assignment : ( varBinding | funcBinding );
    public final WaebricInterpreter.assignment_return assignment() throws RecognitionException {
        WaebricInterpreter.assignment_return retval = new WaebricInterpreter.assignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricInterpreter.varBinding_return varBinding90 = null;

        WaebricInterpreter.funcBinding_return funcBinding91 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:568:11: ( varBinding | funcBinding )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==IDCON) ) {
                alt22=1;
            }
            else if ( (LA22_0==FUNCTION) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:568:14: varBinding
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_varBinding_in_assignment953);
                    varBinding90=varBinding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, varBinding90.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:569:6: funcBinding
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_funcBinding_in_assignment961);
                    funcBinding91=funcBinding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, funcBinding91.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:571:1: varBinding : IDCON '=' expression ';' ;
    public final WaebricInterpreter.varBinding_return varBinding() throws RecognitionException {
        WaebricInterpreter.varBinding_return retval = new WaebricInterpreter.varBinding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON92=null;
        CommonTree char_literal93=null;
        CommonTree char_literal95=null;
        WaebricInterpreter.expression_return expression94 = null;


        CommonTree IDCON92_tree=null;
        CommonTree char_literal93_tree=null;
        CommonTree char_literal95_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:571:11: ( IDCON '=' expression ';' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:571:14: IDCON '=' expression ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON92=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_varBinding972); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON92_tree = (CommonTree)adaptor.dupNode(IDCON92);

            adaptor.addChild(root_0, IDCON92_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal93=(CommonTree)match(input,52,FOLLOW_52_in_varBinding974); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal93_tree = (CommonTree)adaptor.dupNode(char_literal93);

            adaptor.addChild(root_0, char_literal93_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_varBinding976);
            expression94=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, expression94.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal95=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_varBinding978); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal95_tree = (CommonTree)adaptor.dupNode(char_literal95);

            adaptor.addChild(root_0, char_literal95_tree);
            }
            if ( state.backtracking==0 ) {

              				defineVariable(IDCON92.getText(), (expression94!=null?expression94.index:0));
              			
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:575:1: funcBinding : ^( FUNCTION id= IDCON ( formals )? . ) ;
    public final WaebricInterpreter.funcBinding_return funcBinding() throws RecognitionException {
        WaebricInterpreter.funcBinding_return retval = new WaebricInterpreter.funcBinding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        CommonTree FUNCTION96=null;
        CommonTree wildcard98=null;
        WaebricInterpreter.formals_return formals97 = null;


        CommonTree id_tree=null;
        CommonTree FUNCTION96_tree=null;
        CommonTree wildcard98_tree=null;

         int index = input.index(); 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:577:2: ( ^( FUNCTION id= IDCON ( formals )? . ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:577:5: ^( FUNCTION id= IDCON ( formals )? . )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNCTION96=(CommonTree)match(input,FUNCTION,FOLLOW_FUNCTION_in_funcBinding1002); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FUNCTION96_tree = (CommonTree)adaptor.dupNode(FUNCTION96);

            root_1 = (CommonTree)adaptor.becomeRoot(FUNCTION96_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_funcBinding1006); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (CommonTree)adaptor.dupNode(id);

            adaptor.addChild(root_1, id_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:577:26: ( formals )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==49) ) {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==IDCON||LA23_1==51) ) {
                    alt23=1;
                }
            }
            switch (alt23) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: formals
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_formals_in_funcBinding1008);
                    formals97=formals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, formals97.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            _last = (CommonTree)input.LT(1);
            wildcard98=(CommonTree)input.LT(1);
            matchAny(input); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            wildcard98_tree = (CommonTree)adaptor.dupTree(wildcard98);
            adaptor.addChild(root_1, wildcard98_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:585:1: predicate returns [boolean eval] : ( '!' p= predicate | e= expression | e= expression '.' ( 'list' | 'record' | 'string' ) '?' ) ( '&&' p= predicate | '||' p= predicate )* ;
    public final WaebricInterpreter.predicate_return predicate() throws RecognitionException {
        WaebricInterpreter.predicate_return retval = new WaebricInterpreter.predicate_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal99=null;
        CommonTree char_literal100=null;
        CommonTree string_literal101=null;
        CommonTree string_literal102=null;
        CommonTree string_literal103=null;
        CommonTree char_literal104=null;
        CommonTree string_literal105=null;
        CommonTree string_literal106=null;
        WaebricInterpreter.predicate_return p = null;

        WaebricInterpreter.expression_return e = null;


        CommonTree char_literal99_tree=null;
        CommonTree char_literal100_tree=null;
        CommonTree string_literal101_tree=null;
        CommonTree string_literal102_tree=null;
        CommonTree string_literal103_tree=null;
        CommonTree char_literal104_tree=null;
        CommonTree string_literal105_tree=null;
        CommonTree string_literal106_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:586:2: ( ( '!' p= predicate | e= expression | e= expression '.' ( 'list' | 'record' | 'string' ) '?' ) ( '&&' p= predicate | '||' p= predicate )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:586:5: ( '!' p= predicate | e= expression | e= expression '.' ( 'list' | 'record' | 'string' ) '?' ) ( '&&' p= predicate | '||' p= predicate )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:586:5: ( '!' p= predicate | e= expression | e= expression '.' ( 'list' | 'record' | 'string' ) '?' )
            int alt25=3;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:586:7: '!' p= predicate
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal99=(CommonTree)match(input,66,FOLLOW_66_in_predicate1035); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal99_tree = (CommonTree)adaptor.dupNode(char_literal99);

                    adaptor.addChild(root_0, char_literal99_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_predicate1039);
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:587:7: e= expression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate1051);
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:588:7: e= expression '.' ( 'list' | 'record' | 'string' ) '?'
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate1064);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, e.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal100=(CommonTree)match(input,42,FOLLOW_42_in_predicate1066); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal100_tree = (CommonTree)adaptor.dupNode(char_literal100);

                    adaptor.addChild(root_0, char_literal100_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:588:24: ( 'list' | 'record' | 'string' )
                    int alt24=3;
                    switch ( input.LA(1) ) {
                    case 70:
                        {
                        alt24=1;
                        }
                        break;
                    case 71:
                        {
                        alt24=2;
                        }
                        break;
                    case 72:
                        {
                        alt24=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 24, 0, input);

                        throw nvae;
                    }

                    switch (alt24) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:588:26: 'list'
                            {
                            _last = (CommonTree)input.LT(1);
                            string_literal101=(CommonTree)match(input,70,FOLLOW_70_in_predicate1070); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal101_tree = (CommonTree)adaptor.dupNode(string_literal101);

                            adaptor.addChild(root_0, string_literal101_tree);
                            }
                            if ( state.backtracking==0 ) {

                              							retval.eval = (e!=null?e.eval:null).startsWith("[");
                              						 
                            }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:590:12: 'record'
                            {
                            _last = (CommonTree)input.LT(1);
                            string_literal102=(CommonTree)match(input,71,FOLLOW_71_in_predicate1076); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal102_tree = (CommonTree)adaptor.dupNode(string_literal102);

                            adaptor.addChild(root_0, string_literal102_tree);
                            }
                            if ( state.backtracking==0 ) {
                               
                              						 	retval.eval = (e!=null?e.eval:null).startsWith("{");
                              						 
                            }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 3 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:592:12: 'string'
                            {
                            _last = (CommonTree)input.LT(1);
                            string_literal103=(CommonTree)match(input,72,FOLLOW_72_in_predicate1082); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal103_tree = (CommonTree)adaptor.dupNode(string_literal103);

                            adaptor.addChild(root_0, string_literal103_tree);
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
                    char_literal104=(CommonTree)match(input,67,FOLLOW_67_in_predicate1088); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal104_tree = (CommonTree)adaptor.dupNode(char_literal104);

                    adaptor.addChild(root_0, char_literal104_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:595:6: ( '&&' p= predicate | '||' p= predicate )*
            loop26:
            do {
                int alt26=3;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==68) ) {
                    int LA26_1 = input.LA(2);

                    if ( (synpred47_WaebricInterpreter()) ) {
                        alt26=1;
                    }


                }
                else if ( (LA26_0==69) ) {
                    int LA26_2 = input.LA(2);

                    if ( (synpred48_WaebricInterpreter()) ) {
                        alt26=2;
                    }


                }


                switch (alt26) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:595:8: '&&' p= predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal105=(CommonTree)match(input,68,FOLLOW_68_in_predicate1098); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal105_tree = (CommonTree)adaptor.dupNode(string_literal105);

            	    adaptor.addChild(root_0, string_literal105_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate1102);
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
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:595:57: '||' p= predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal106=(CommonTree)match(input,69,FOLLOW_69_in_predicate1108); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal106_tree = (CommonTree)adaptor.dupNode(string_literal106);

            	    adaptor.addChild(root_0, string_literal106_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate1112);
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

    public static class embedding_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "embedding"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:600:1: embedding[boolean element] : PRETEXT embed[element] textTail[element] ;
    public final WaebricInterpreter.embedding_return embedding(boolean element) throws RecognitionException {
        WaebricInterpreter.embedding_return retval = new WaebricInterpreter.embedding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PRETEXT107=null;
        WaebricInterpreter.embed_return embed108 = null;

        WaebricInterpreter.textTail_return textTail109 = null;


        CommonTree PRETEXT107_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:601:2: ( PRETEXT embed[element] textTail[element] )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:601:5: PRETEXT embed[element] textTail[element]
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PRETEXT107=(CommonTree)match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding1135); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRETEXT107_tree = (CommonTree)adaptor.dupNode(PRETEXT107);

            adaptor.addChild(root_0, PRETEXT107_tree);
            }
            if ( state.backtracking==0 ) {
               addContent(new Text(PRETEXT107.getText().substring(1, PRETEXT107.getText().length()-1))); 
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_embed_in_embedding1143);
            embed108=embed(element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, embed108.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_textTail_in_embedding1146);
            textTail109=textTail(element);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, textTail109.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:604:1: embed[boolean element] : ( ( markup[element] )+ | ( markup[element] )* expression );
    public final WaebricInterpreter.embed_return embed(boolean element) throws RecognitionException {
        WaebricInterpreter.embed_return retval = new WaebricInterpreter.embed_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricInterpreter.markup_return markup110 = null;

        WaebricInterpreter.markup_return markup111 = null;

        WaebricInterpreter.expression_return expression112 = null;



         int depth = this.depth; 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:607:2: ( ( markup[element] )+ | ( markup[element] )* expression )
            int alt29=2;
            alt29 = dfa29.predict(input);
            switch (alt29) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:607:5: ( markup[element] )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:607:5: ( markup[element] )+
                    int cnt27=0;
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==MARKUP) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup[element]
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed1172);
                    	    markup110=markup(element);

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup110.getTree());

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


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:608:6: ( markup[element] )* expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:608:6: ( markup[element] )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==MARKUP) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup[element]
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed1182);
                    	    markup111=markup(element);

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup111.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_embed1186);
                    expression112=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression112.getTree());
                    if ( state.backtracking==0 ) {
                       addContent(new Text((expression112!=null?expression112.eval:null))); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }
            if ( state.backtracking==0 ) {
               restoreCurrent(depth); 
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:610:1: textTail[boolean element] : ( POSTTEXT | MIDTEXT embed[element] textTail[element] );
    public final WaebricInterpreter.textTail_return textTail(boolean element) throws RecognitionException {
        WaebricInterpreter.textTail_return retval = new WaebricInterpreter.textTail_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POSTTEXT113=null;
        CommonTree MIDTEXT114=null;
        WaebricInterpreter.embed_return embed115 = null;

        WaebricInterpreter.textTail_return textTail116 = null;


        CommonTree POSTTEXT113_tree=null;
        CommonTree MIDTEXT114_tree=null;

         int depth = this.depth; 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:613:2: ( POSTTEXT | MIDTEXT embed[element] textTail[element] )
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:613:5: POSTTEXT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    POSTTEXT113=(CommonTree)match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail1213); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    POSTTEXT113_tree = (CommonTree)adaptor.dupNode(POSTTEXT113);

                    adaptor.addChild(root_0, POSTTEXT113_tree);
                    }
                    if ( state.backtracking==0 ) {
                       addContent(new Text(POSTTEXT113.getText().substring(1, POSTTEXT113.getText().length()-1))); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:614:6: MIDTEXT embed[element] textTail[element]
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    MIDTEXT114=(CommonTree)match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail1222); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MIDTEXT114_tree = (CommonTree)adaptor.dupNode(MIDTEXT114);

                    adaptor.addChild(root_0, MIDTEXT114_tree);
                    }
                    if ( state.backtracking==0 ) {
                       addContent(new Text(MIDTEXT114.getText().substring(1, MIDTEXT114.getText().length()-1))); 
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embed_in_textTail1226);
                    embed115=embed(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, embed115.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_textTail_in_textTail1229);
                    textTail116=textTail(element);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, textTail116.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }
            if ( state.backtracking==0 ) {
               restoreCurrent(depth); 
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


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:420:6: ( '+' e= expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:420:6: '+' e= expression
        {
        match(input,57,FOLLOW_57_in_synpred18_WaebricInterpreter450); if (state.failed) return ;
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

        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:426:6: ( '.' id= IDCON )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:426:6: '.' id= IDCON
        {
        match(input,42,FOLLOW_42_in_synpred19_WaebricInterpreter464); if (state.failed) return ;
        id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_synpred19_WaebricInterpreter468); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_WaebricInterpreter

    // $ANTLR start synpred44_WaebricInterpreter
    public final void synpred44_WaebricInterpreter_fragment() throws RecognitionException {   
        WaebricInterpreter.expression_return e = null;


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:587:7: (e= expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:587:7: e= expression
        {
        pushFollow(FOLLOW_expression_in_synpred44_WaebricInterpreter1051);
        e=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred44_WaebricInterpreter

    // $ANTLR start synpred47_WaebricInterpreter
    public final void synpred47_WaebricInterpreter_fragment() throws RecognitionException {   
        WaebricInterpreter.predicate_return p = null;


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:595:8: ( '&&' p= predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:595:8: '&&' p= predicate
        {
        match(input,68,FOLLOW_68_in_synpred47_WaebricInterpreter1098); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred47_WaebricInterpreter1102);
        p=predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred47_WaebricInterpreter

    // $ANTLR start synpred48_WaebricInterpreter
    public final void synpred48_WaebricInterpreter_fragment() throws RecognitionException {   
        WaebricInterpreter.predicate_return p = null;


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:595:57: ( '||' p= predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:595:57: '||' p= predicate
        {
        match(input,69,FOLLOW_69_in_synpred48_WaebricInterpreter1108); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred48_WaebricInterpreter1112);
        p=predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred48_WaebricInterpreter

    // Delegated rules

    public final boolean synpred44_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_WaebricInterpreter_fragment(); // can never throw exception
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
    public final boolean synpred47_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred47_WaebricInterpreter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred48_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred48_WaebricInterpreter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA16 dfa16 = new DFA16(this);
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA29 dfa29 = new DFA29(this);
    static final String DFA16_eotS =
        "\15\uffff";
    static final String DFA16_eofS =
        "\15\uffff";
    static final String DFA16_minS =
        "\1\7\5\uffff\1\2\3\uffff\1\14\2\uffff";
    static final String DFA16_maxS =
        "\1\101\5\uffff\1\2\3\uffff\1\67\2\uffff";
    static final String DFA16_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\11\1\12\1\uffff\1\7"+
        "\1\6";
    static final String DFA16_specialS =
        "\15\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\11\15\uffff\1\5\41\uffff\1\4\2\uffff\1\1\1\uffff\1\2\1\3"+
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

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "465:1: statement : ( ifStatement | eachStatement | letStatement | blockStatement | ^( 'comment' STRCON ) | ^( 'echo' expression ) | ^( 'echo' embedding[false] ) | ^( 'cdata' expression ) | 'yield;' | ^( MARKUP_STATEMENT markup[true] markupChain ) );";
        }
    }
    static final String DFA25_eotS =
        "\12\uffff";
    static final String DFA25_eofS =
        "\12\uffff";
    static final String DFA25_minS =
        "\1\14\1\uffff\6\0\2\uffff";
    static final String DFA25_maxS =
        "\1\102\1\uffff\6\0\2\uffff";
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
            return "586:5: ( '!' p= predicate | e= expression | e= expression '.' ( 'list' | 'record' | 'string' ) '?' )";
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
                        if ( (synpred44_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index25_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA25_3 = input.LA(1);

                         
                        int index25_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred44_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index25_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA25_4 = input.LA(1);

                         
                        int index25_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred44_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index25_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA25_5 = input.LA(1);

                         
                        int index25_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred44_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index25_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA25_6 = input.LA(1);

                         
                        int index25_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred44_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index25_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA25_7 = input.LA(1);

                         
                        int index25_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred44_WaebricInterpreter()) ) {s = 8;}

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
    static final String DFA29_eotS =
        "\17\uffff";
    static final String DFA29_eofS =
        "\17\uffff";
    static final String DFA29_minS =
        "\1\6\1\2\1\uffff\1\14\1\4\1\2\1\4\1\2\1\3\1\6\2\4\1\uffff\2\3";
    static final String DFA29_maxS =
        "\1\67\1\2\1\uffff\1\14\3\110\1\3\1\110\1\67\2\110\1\uffff\1\110"+
        "\1\3";
    static final String DFA29_acceptS =
        "\2\uffff\1\2\11\uffff\1\1\2\uffff";
    static final String DFA29_specialS =
        "\17\uffff}>";
    static final String[] DFA29_transitionS = {
            "\1\1\5\uffff\1\2\1\uffff\3\2\44\uffff\1\2\1\uffff\1\2",
            "\1\3",
            "",
            "\1\4",
            "\105\5",
            "\1\6\1\uffff\105\7",
            "\105\10",
            "\1\12\1\11",
            "\1\13\105\10",
            "\1\1\5\uffff\1\2\1\uffff\3\2\2\uffff\2\14\40\uffff\1\2\1\uffff"+
            "\1\2",
            "\105\15",
            "\105\7",
            "",
            "\1\16\105\15",
            "\1\11"
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
            return "604:1: embed[boolean element] : ( ( markup[element] )+ | ( markup[element] )* expression );";
        }
    }
 

    public static final BitSet FOLLOW_PATH_in_mapping78 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_mapping80 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_markup_in_mapping82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUP_in_markup113 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_markup115 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x00000000000001FFL});
    public static final BitSet FOLLOW_ATTRIBUTES_in_attributes141 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attribute_in_attributes143 = new BitSet(new long[]{0x0000F40000000008L});
    public static final BitSet FOLLOW_45_in_attribute155 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_IDCON_in_attribute157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_attribute166 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_IDCON_in_attribute168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_attribute177 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_IDCON_in_attribute179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_attribute188 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_IDCON_in_attribute190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_attribute199 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NATCON_in_attribute203 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_48_in_attribute213 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_NATCON_in_attribute217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARGUMENTS_in_arguments244 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_argument_in_arguments246 = new BitSet(new long[]{0x00A000000001D008L});
    public static final BitSet FOLLOW_expression_in_argument263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_argument269 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_argument271 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_argument273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_expression306 = new BitSet(new long[]{0x0200040000000002L});
    public static final BitSet FOLLOW_NATCON_in_expression315 = new BitSet(new long[]{0x0200040000000002L});
    public static final BitSet FOLLOW_TEXT_in_expression324 = new BitSet(new long[]{0x0200040000000002L});
    public static final BitSet FOLLOW_SYMBOLCON_in_expression333 = new BitSet(new long[]{0x0200040000000002L});
    public static final BitSet FOLLOW_53_in_expression342 = new BitSet(new long[]{0x00E400000001D000L});
    public static final BitSet FOLLOW_expression_in_expression348 = new BitSet(new long[]{0x0044000000000000L});
    public static final BitSet FOLLOW_50_in_expression363 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_expression367 = new BitSet(new long[]{0x0044000000000000L});
    public static final BitSet FOLLOW_54_in_expression374 = new BitSet(new long[]{0x0200040000000002L});
    public static final BitSet FOLLOW_55_in_expression383 = new BitSet(new long[]{0x0104000000001000L});
    public static final BitSet FOLLOW_IDCON_in_expression389 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_expression391 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_expression395 = new BitSet(new long[]{0x0104000000000000L});
    public static final BitSet FOLLOW_50_in_expression410 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_IDCON_in_expression414 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_expression416 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_expression420 = new BitSet(new long[]{0x0104000000000000L});
    public static final BitSet FOLLOW_56_in_expression427 = new BitSet(new long[]{0x0200040000000002L});
    public static final BitSet FOLLOW_57_in_expression450 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_expression454 = new BitSet(new long[]{0x0200040000000002L});
    public static final BitSet FOLLOW_42_in_expression464 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_IDCON_in_expression468 = new BitSet(new long[]{0x0200040000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_function501 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_function503 = new BitSet(new long[]{0xB482000000200088L,0x0000000000000003L});
    public static final BitSet FOLLOW_49_in_function517 = new BitSet(new long[]{0x0008000000001000L});
    public static final BitSet FOLLOW_IDCON_in_function523 = new BitSet(new long[]{0x0008000000001000L});
    public static final BitSet FOLLOW_51_in_function530 = new BitSet(new long[]{0xB480000000200088L,0x0000000000000003L});
    public static final BitSet FOLLOW_statement_in_function551 = new BitSet(new long[]{0xB480000000200088L,0x0000000000000003L});
    public static final BitSet FOLLOW_49_in_formals570 = new BitSet(new long[]{0x0008000000001000L});
    public static final BitSet FOLLOW_IDCON_in_formals572 = new BitSet(new long[]{0x0008000000001000L});
    public static final BitSet FOLLOW_51_in_formals575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statement588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_eachStatement_in_statement595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_letStatement_in_statement602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blockStatement_in_statement609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMENT_in_statement618 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRCON_in_statement620 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_63_in_statement633 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement635 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_63_in_statement648 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_statement650 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_64_in_statement662 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement664 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_65_in_statement675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement686 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement688 = new BitSet(new long[]{0x0000000001000100L});
    public static final BitSet FOLLOW_markupChain_in_statement693 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_CHAIN_in_markupChain717 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_markupChain719 = new BitSet(new long[]{0x0000000001000100L});
    public static final BitSet FOLLOW_markupChain_in_markupChain724 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_CHAIN_in_markupChain735 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_markupChain737 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_CHAIN_in_markupChain750 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_markupChain752 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_CHAIN_in_markupChain763 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_markupChain765 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SEMICOLON_in_markupChain775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ifStatement793 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_predicate_in_ifStatement795 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x00000000000001FFL});
    public static final BitSet FOLLOW_59_in_ifStatement806 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x00000000000001FFL});
    public static final BitSet FOLLOW_60_in_eachStatement846 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_49_in_eachStatement848 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_IDCON_in_eachStatement850 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_eachStatement852 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_eachStatement856 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_eachStatement858 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x00000000000001FFL});
    public static final BitSet FOLLOW_55_in_blockStatement884 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_blockStatement888 = new BitSet(new long[]{0xB580000000200080L,0x0000000000000003L});
    public static final BitSet FOLLOW_56_in_blockStatement895 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_61_in_letStatement923 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_assignment_in_letStatement925 = new BitSet(new long[]{0x4000000000001200L});
    public static final BitSet FOLLOW_62_in_letStatement928 = new BitSet(new long[]{0xB480000000A00080L,0x0000000000000003L});
    public static final BitSet FOLLOW_statement_in_letStatement932 = new BitSet(new long[]{0xB480000000A00080L,0x0000000000000003L});
    public static final BitSet FOLLOW_END_in_letStatement939 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_varBinding_in_assignment953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funcBinding_in_assignment961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_varBinding972 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_varBinding974 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_varBinding976 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_varBinding978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_funcBinding1002 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_funcBinding1006 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x00000000000001FFL});
    public static final BitSet FOLLOW_formals_in_funcBinding1008 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x00000000000001FFL});
    public static final BitSet FOLLOW_66_in_predicate1035 = new BitSet(new long[]{0x00A000000001D000L,0x0000000000000004L});
    public static final BitSet FOLLOW_predicate_in_predicate1039 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000030L});
    public static final BitSet FOLLOW_expression_in_predicate1051 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000030L});
    public static final BitSet FOLLOW_expression_in_predicate1064 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_predicate1066 = new BitSet(new long[]{0x0000000000000000L,0x00000000000001C0L});
    public static final BitSet FOLLOW_70_in_predicate1070 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_71_in_predicate1076 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_72_in_predicate1082 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_predicate1088 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000030L});
    public static final BitSet FOLLOW_68_in_predicate1098 = new BitSet(new long[]{0x00A000000001D000L,0x0000000000000004L});
    public static final BitSet FOLLOW_predicate_in_predicate1102 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000030L});
    public static final BitSet FOLLOW_69_in_predicate1108 = new BitSet(new long[]{0x00A000000001D000L,0x0000000000000004L});
    public static final BitSet FOLLOW_predicate_in_predicate1112 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000030L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding1135 = new BitSet(new long[]{0x00A000000001D040L});
    public static final BitSet FOLLOW_embed_in_embedding1143 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_textTail_in_embedding1146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed1172 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_markup_in_embed1182 = new BitSet(new long[]{0x00A000000001D040L});
    public static final BitSet FOLLOW_expression_in_embed1186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail1213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail1222 = new BitSet(new long[]{0x00A000000001D040L});
    public static final BitSet FOLLOW_embed_in_textTail1226 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_textTail_in_textTail1229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_synpred18_WaebricInterpreter450 = new BitSet(new long[]{0x00A000000001D000L});
    public static final BitSet FOLLOW_expression_in_synpred18_WaebricInterpreter454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_synpred19_WaebricInterpreter464 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_IDCON_in_synpred19_WaebricInterpreter468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred44_WaebricInterpreter1051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_synpred47_WaebricInterpreter1098 = new BitSet(new long[]{0x00A000000001D000L,0x0000000000000004L});
    public static final BitSet FOLLOW_predicate_in_synpred47_WaebricInterpreter1102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_synpred48_WaebricInterpreter1108 = new BitSet(new long[]{0x00A000000001D000L,0x0000000000000004L});
    public static final BitSet FOLLOW_predicate_in_synpred48_WaebricInterpreter1112 = new BitSet(new long[]{0x0000000000000002L});

}