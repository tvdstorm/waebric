// $ANTLR 3.1.2 /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g 2009-08-15 17:35:01

	package org.cwi.waebric;
	
	import java.io.File;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.OutputStream;
	import java.text.SimpleDateFormat;
	
	import java.util.Date;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATTRIBUTES", "ARGUMENTS", "MARKUP", "MARKUP_STATEMENT", "FORMALS", "FUNCTION", "IDCON", "PATH", "NATCON", "TEXT", "SYMBOLCON", "STRCON", "PRETEXT", "POSTTEXT", "MIDTEXT", "COMMENT", "SITE", "END", "SEMICOLON", "LETTER", "DIGIT", "HEXADECIMAL", "PATHELEMENT", "FILEEXT", "STRCHAR", "ESCLAYOUT", "DECIMAL", "TEXTCHAR", "ESCQUOTE", "AMP", "CHARREF", "ENTREF", "SYMBOLCHAR", "COMMENTS", "LAYOUT", "'module'", "'.'", "'import'", "':'", "'#'", "'$'", "'@'", "'%'", "'('", "','", "')'", "'='", "'['", "']'", "'{'", "'}'", "'+'", "'if'", "'else'", "'each'", "'let'", "'in'", "'echo'", "'cdata'", "'yield;'", "'!'", "'&&'", "'||'", "'list'", "'record'", "'string'"
    };
    public static final int ESCLAYOUT=29;
    public static final int T__42=42;
    public static final int END=21;
    public static final int T__57=57;
    public static final int T__51=51;
    public static final int FILEEXT=27;
    public static final int T__69=69;
    public static final int T__47=47;
    public static final int T__50=50;
    public static final int STRCHAR=28;
    public static final int T__65=65;
    public static final int SYMBOLCON=14;
    public static final int COMMENTS=37;
    public static final int IDCON=10;
    public static final int DECIMAL=30;
    public static final int T__67=67;
    public static final int HEXADECIMAL=25;
    public static final int T__39=39;
    public static final int TEXTCHAR=31;
    public static final int T__52=52;
    public static final int T__46=46;
    public static final int T__68=68;
    public static final int FUNCTION=9;
    public static final int T__62=62;
    public static final int MARKUP=6;
    public static final int STRCON=15;
    public static final int T__49=49;
    public static final int AMP=33;
    public static final int T__61=61;
    public static final int POSTTEXT=17;
    public static final int T__59=59;
    public static final int ATTRIBUTES=4;
    public static final int DIGIT=24;
    public static final int T__54=54;
    public static final int T__48=48;
    public static final int LAYOUT=38;
    public static final int ESCQUOTE=32;
    public static final int PATHELEMENT=26;
    public static final int T__56=56;
    public static final int ENTREF=35;
    public static final int LETTER=23;
    public static final int ARGUMENTS=5;
    public static final int SITE=20;
    public static final int T__58=58;
    public static final int T__64=64;
    public static final int T__44=44;
    public static final int T__66=66;
    public static final int SYMBOLCHAR=36;
    public static final int COMMENT=19;
    public static final int MARKUP_STATEMENT=7;
    public static final int FORMALS=8;
    public static final int T__55=55;
    public static final int T__45=45;
    public static final int CHARREF=34;
    public static final int MIDTEXT=18;
    public static final int T__63=63;
    public static final int PRETEXT=16;
    public static final int T__43=43;
    public static final int SEMICOLON=22;
    public static final int T__40=40;
    public static final int EOF=-1;
    public static final int T__53=53;
    public static final int TEXT=13;
    public static final int NATCON=12;
    public static final int T__60=60;
    public static final int T__41=41;
    public static final int PATH=11;

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
    	
    	// Location of yield arguments
    	private Stack<Integer> yields = new Stack<Integer>();
    	
    	// Personal environments, due to inherited environments on function bindings
    	private Map<String, Stack> environments = new HashMap<String, Stack>();
    	
    	/**
    	 * Interpret program
    	 * @param os: Output stream for interpreting main function
    	 */
    	public void interpretProgram(OutputStream os, WaebricLoader loader) throws RecognitionException {
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
        			int actual = input.index();
        			input.seek(function);
        			function(args);
        			input.seek(actual);
        			return true;
        		} return false;
        	}
    	
    	/**
    	 * Write document to output stream
    	 */
    	private void outputDocument(Document document, OutputStream os) {
    		try {
    			if(os != null) {
    				// Brand-mark document
    				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    				Comment comment = new Comment("Generated on " + format.format(new Date()));
    				document.addContent(0, comment);
    		
    				// Output document
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
    	
    	// Create file output stream for path
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
    	


    public static class mapping_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mapping"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:221:1: mapping : PATH ':' markup ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:223:2: ( PATH ':' markup )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:223:5: PATH ':' markup
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PATH1=(CommonTree)match(input,PATH,FOLLOW_PATH_in_mapping78); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PATH1_tree = (CommonTree)adaptor.dupNode(PATH1);

            adaptor.addChild(root_0, PATH1_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal2=(CommonTree)match(input,42,FOLLOW_42_in_mapping80); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal2_tree = (CommonTree)adaptor.dupNode(char_literal2);

            adaptor.addChild(root_0, char_literal2_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_markup_in_mapping82);
            markup3=markup();

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "markup"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:235:1: markup : ^( MARKUP IDCON . . ) ;
    public final WaebricInterpreter.markup_return markup() throws RecognitionException {
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

         int attr = 0; int args = 0; 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:237:2: ( ^( MARKUP IDCON . . ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:237:5: ^( MARKUP IDCON . . )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            MARKUP4=(CommonTree)match(input,MARKUP,FOLLOW_MARKUP_in_markup106); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MARKUP4_tree = (CommonTree)adaptor.dupNode(MARKUP4);

            root_1 = (CommonTree)adaptor.becomeRoot(MARKUP4_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            IDCON5=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_markup108); if (state.failed) return retval;
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
              					Stack actualEnvironment = Environment_stack;
              					Environment_stack = getEnvironment(IDCON5.getText());
              					
              					//  Process arguments
              					int actualIndex = input.index();
              					input.seek(args);
              					List<Integer> eval = arguments(true).args;
              					input.seek(actualIndex);
              					
              					interpretFunction(IDCON5.getText(), eval); // Interpret function
              					Environment_stack = actualEnvironment; // Restore environment
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:264:1: attributes : ^( ATTRIBUTES ( attribute )* ) ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:264:11: ( ^( ATTRIBUTES ( attribute )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:264:14: ^( ATTRIBUTES ( attribute )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            ATTRIBUTES8=(CommonTree)match(input,ATTRIBUTES,FOLLOW_ATTRIBUTES_in_attributes134); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ATTRIBUTES8_tree = (CommonTree)adaptor.dupNode(ATTRIBUTES8);

            root_1 = (CommonTree)adaptor.becomeRoot(ATTRIBUTES8_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:264:28: ( attribute )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==40||(LA1_0>=42 && LA1_0<=45)) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: attribute
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_attribute_in_attributes136);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:266:1: attribute : ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' w= NATCON ( '%' h= NATCON )? );
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:266:10: ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' w= NATCON ( '%' h= NATCON )? )
            int alt3=5;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt3=1;
                }
                break;
            case 40:
                {
                alt3=2;
                }
                break;
            case 44:
                {
                alt3=3;
                }
                break;
            case 42:
                {
                alt3=4;
                }
                break;
            case 45:
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:266:13: '#' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal10=(CommonTree)match(input,43,FOLLOW_43_in_attribute148); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal10_tree = (CommonTree)adaptor.dupNode(char_literal10);

                    adaptor.addChild(root_0, char_literal10_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON11=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute150); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:267:6: '.' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal12=(CommonTree)match(input,40,FOLLOW_40_in_attribute159); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal12_tree = (CommonTree)adaptor.dupNode(char_literal12);

                    adaptor.addChild(root_0, char_literal12_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON13=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute161); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:268:6: '$' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal14=(CommonTree)match(input,44,FOLLOW_44_in_attribute170); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal14_tree = (CommonTree)adaptor.dupNode(char_literal14);

                    adaptor.addChild(root_0, char_literal14_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON15=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute172); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:269:6: ':' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal16=(CommonTree)match(input,42,FOLLOW_42_in_attribute181); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal16_tree = (CommonTree)adaptor.dupNode(char_literal16);

                    adaptor.addChild(root_0, char_literal16_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON17=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute183); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:270:6: '@' w= NATCON ( '%' h= NATCON )?
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal18=(CommonTree)match(input,45,FOLLOW_45_in_attribute192); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal18_tree = (CommonTree)adaptor.dupNode(char_literal18);

                    adaptor.addChild(root_0, char_literal18_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    w=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_attribute196); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    w_tree = (CommonTree)adaptor.dupNode(w);

                    adaptor.addChild(root_0, w_tree);
                    }
                    if ( state.backtracking==0 ) {
                       current.setAttribute("width", w.getText()); 
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:271:5: ( '%' h= NATCON )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==46) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:271:7: '%' h= NATCON
                            {
                            _last = (CommonTree)input.LT(1);
                            char_literal19=(CommonTree)match(input,46,FOLLOW_46_in_attribute206); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal19_tree = (CommonTree)adaptor.dupNode(char_literal19);

                            adaptor.addChild(root_0, char_literal19_tree);
                            }
                            _last = (CommonTree)input.LT(1);
                            h=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_attribute210); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:273:1: arguments[boolean call] returns [List<Integer> args = new ArrayList<Integer>()] : ^( ARGUMENTS ( argument[$args, call] )* ) ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:275:2: ( ^( ARGUMENTS ( argument[$args, call] )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:275:5: ^( ARGUMENTS ( argument[$args, call] )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            ARGUMENTS20=(CommonTree)match(input,ARGUMENTS,FOLLOW_ARGUMENTS_in_arguments236); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ARGUMENTS20_tree = (CommonTree)adaptor.dupNode(ARGUMENTS20);

            root_1 = (CommonTree)adaptor.becomeRoot(ARGUMENTS20_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:275:18: ( argument[$args, call] )*
                loop4:
                do {
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==IDCON||(LA4_0>=NATCON && LA4_0<=SYMBOLCON)||LA4_0==51||LA4_0==53) ) {
                        alt4=1;
                    }


                    switch (alt4) {
                	case 1 :
                	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: argument[$args, call]
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_argument_in_arguments238);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:277:1: argument[List<Integer> args, boolean call] : ( expression | IDCON '=' expression );
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

         int index = input.index(); 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:279:2: ( expression | IDCON '=' expression )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==IDCON) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==50) ) {
                    alt5=2;
                }
                else if ( (LA5_1==EOF||LA5_1==UP||LA5_1==IDCON||(LA5_1>=NATCON && LA5_1<=SYMBOLCON)||LA5_1==40||LA5_1==51||LA5_1==53||LA5_1==55) ) {
                    alt5=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA5_0>=NATCON && LA5_0<=SYMBOLCON)||LA5_0==51||LA5_0==53) ) {
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:279:5: expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_argument260);
                    expression22=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression22.getTree());
                    if ( state.backtracking==0 ) {

                      				if(call) { 
                      					args.add(index); // Add expression index to argument collection
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:289:8: IDCON '=' expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDCON23=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_argument266); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON23_tree = (CommonTree)adaptor.dupNode(IDCON23);

                    adaptor.addChild(root_0, IDCON23_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal24=(CommonTree)match(input,50,FOLLOW_50_in_argument268); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal24_tree = (CommonTree)adaptor.dupNode(char_literal24);

                    adaptor.addChild(root_0, char_literal24_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_argument270);
                    expression25=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression25.getTree());
                    if ( state.backtracking==0 ) {

                      				if(call) { 
                      					 // TODO: Figure out what to do
                      				} else { current.setAttribute(IDCON23.getText(), (expression25!=null?expression25.eval:null)); } 
                      			
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
        public int index; 		String eval = "undef";
        public Map<String, expression_return> map = new HashMap<String, expression_return>();
        public Collection<expression_return> collection = new ArrayList();
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:298:1: expression returns [\n\t\tint index; // Used for interpreting a referenced variable\n\t\tString eval = \"undef\", // Evaluation value for printing\n\t\tMap<String, expression_return> map = new HashMap<String, expression_return>(), // Map structure for fields\n\t\tCollection<expression_return> collection = new ArrayList() // List structure for iterations\n\t] : (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (id= IDCON ':' e= expression )? ( ',' id= IDCON ':' e= expression )* '}' ) ( '+' e= expression | '.' id= IDCON )* ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:304:2: ( (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (id= IDCON ':' e= expression )? ( ',' id= IDCON ':' e= expression )* '}' ) ( '+' e= expression | '.' id= IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:305:4: (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (id= IDCON ':' e= expression )? ( ',' id= IDCON ':' e= expression )* '}' ) ( '+' e= expression | '.' id= IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:305:4: (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (id= IDCON ':' e= expression )? ( ',' id= IDCON ':' e= expression )* '}' )
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
            case 51:
                {
                alt10=5;
                }
                break;
            case 53:
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:305:6: var= IDCON
                    {
                    _last = (CommonTree)input.LT(1);
                    var=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression303); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:315:6: NATCON
                    {
                    _last = (CommonTree)input.LT(1);
                    NATCON26=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_expression312); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:316:6: TEXT
                    {
                    _last = (CommonTree)input.LT(1);
                    TEXT27=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_expression321); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:317:6: SYMBOLCON
                    {
                    _last = (CommonTree)input.LT(1);
                    SYMBOLCON28=(CommonTree)match(input,SYMBOLCON,FOLLOW_SYMBOLCON_in_expression330); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:318:6: '[' (e= expression )? ( ',' e= expression )* ']'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal29=(CommonTree)match(input,51,FOLLOW_51_in_expression339); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal29_tree = (CommonTree)adaptor.dupNode(char_literal29);

                    adaptor.addChild(root_0, char_literal29_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:318:10: (e= expression )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==IDCON||(LA6_0>=NATCON && LA6_0<=SYMBOLCON)||LA6_0==51||LA6_0==53) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:318:12: e= expression
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_expression_in_expression345);
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

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:319:6: ( ',' e= expression )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==48) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:319:8: ',' e= expression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal30=(CommonTree)match(input,48,FOLLOW_48_in_expression360); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal30_tree = (CommonTree)adaptor.dupNode(char_literal30);

                    	    adaptor.addChild(root_0, char_literal30_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_expression_in_expression364);
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
                    char_literal31=(CommonTree)match(input,52,FOLLOW_52_in_expression371); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:326:6: '{' (id= IDCON ':' e= expression )? ( ',' id= IDCON ':' e= expression )* '}'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal32=(CommonTree)match(input,53,FOLLOW_53_in_expression380); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal32_tree = (CommonTree)adaptor.dupNode(char_literal32);

                    adaptor.addChild(root_0, char_literal32_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:326:10: (id= IDCON ':' e= expression )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==IDCON) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:326:12: id= IDCON ':' e= expression
                            {
                            _last = (CommonTree)input.LT(1);
                            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression386); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            id_tree = (CommonTree)adaptor.dupNode(id);

                            adaptor.addChild(root_0, id_tree);
                            }
                            _last = (CommonTree)input.LT(1);
                            char_literal33=(CommonTree)match(input,42,FOLLOW_42_in_expression388); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal33_tree = (CommonTree)adaptor.dupNode(char_literal33);

                            adaptor.addChild(root_0, char_literal33_tree);
                            }
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_expression_in_expression392);
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

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:327:6: ( ',' id= IDCON ':' e= expression )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==48) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:327:8: ',' id= IDCON ':' e= expression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal34=(CommonTree)match(input,48,FOLLOW_48_in_expression407); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal34_tree = (CommonTree)adaptor.dupNode(char_literal34);

                    	    adaptor.addChild(root_0, char_literal34_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression411); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    id_tree = (CommonTree)adaptor.dupNode(id);

                    	    adaptor.addChild(root_0, id_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal35=(CommonTree)match(input,42,FOLLOW_42_in_expression413); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal35_tree = (CommonTree)adaptor.dupNode(char_literal35);

                    	    adaptor.addChild(root_0, char_literal35_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_expression_in_expression417);
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
                    char_literal36=(CommonTree)match(input,54,FOLLOW_54_in_expression424); if (state.failed) return retval;
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

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:338:4: ( '+' e= expression | '.' id= IDCON )*
            loop11:
            do {
                int alt11=3;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==55) ) {
                    int LA11_2 = input.LA(2);

                    if ( (synpred18_WaebricInterpreter()) ) {
                        alt11=1;
                    }


                }
                else if ( (LA11_0==40) ) {
                    int LA11_3 = input.LA(2);

                    if ( (synpred19_WaebricInterpreter()) ) {
                        alt11=2;
                    }


                }


                switch (alt11) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:338:6: '+' e= expression
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal37=(CommonTree)match(input,55,FOLLOW_55_in_expression447); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal37_tree = (CommonTree)adaptor.dupNode(char_literal37);

            	    adaptor.addChild(root_0, char_literal37_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expression_in_expression451);
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
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:344:6: '.' id= IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal38=(CommonTree)match(input,40,FOLLOW_40_in_expression461); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal38_tree = (CommonTree)adaptor.dupNode(char_literal38);

            	    adaptor.addChild(root_0, char_literal38_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression465); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    id_tree = (CommonTree)adaptor.dupNode(id);

            	    adaptor.addChild(root_0, id_tree);
            	    }
            	    if ( state.backtracking==0 ) {

            	      					// Record field
            	      					if(retval.map.containsKey(id.getText())) { retval = retval.map.get(id.getText()); } 
            	      					else {
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:358:1: function[List<Integer> args] : ^( FUNCTION IDCON ^( FORMALS (id= IDCON )* ) ( statement )* ) ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:360:2: ( ^( FUNCTION IDCON ^( FORMALS (id= IDCON )* ) ( statement )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:360:5: ^( FUNCTION IDCON ^( FORMALS (id= IDCON )* ) ( statement )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNCTION39=(CommonTree)match(input,FUNCTION,FOLLOW_FUNCTION_in_function497); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FUNCTION39_tree = (CommonTree)adaptor.dupNode(FUNCTION39);

            root_1 = (CommonTree)adaptor.becomeRoot(FUNCTION39_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            IDCON40=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_function499); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON40_tree = (CommonTree)adaptor.dupNode(IDCON40);

            adaptor.addChild(root_1, IDCON40_tree);
            }
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FORMALS41=(CommonTree)match(input,FORMALS,FOLLOW_FORMALS_in_function513); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FORMALS41_tree = (CommonTree)adaptor.dupNode(FORMALS41);

            root_2 = (CommonTree)adaptor.becomeRoot(FORMALS41_tree, root_2);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:362:16: (id= IDCON )*
                loop12:
                do {
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==IDCON) ) {
                        alt12=1;
                    }


                    switch (alt12) {
                	case 1 :
                	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:362:18: id= IDCON
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_function519); if (state.failed) return retval;
                	    if ( state.backtracking==0 ) {
                	    id_tree = (CommonTree)adaptor.dupNode(id);

                	    adaptor.addChild(root_2, id_tree);
                	    }
                	    if ( state.backtracking==0 ) {
                	      	if(args.size() > curr) { 
                	      					defineVariable(id.getText(), args.get(curr)); 
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

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:367:5: ( statement )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==MARKUP_STATEMENT||LA13_0==COMMENT||LA13_0==53||LA13_0==56||(LA13_0>=58 && LA13_0<=59)||(LA13_0>=61 && LA13_0<=63)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:367:7: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_function544);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:373:1: formals : ^( FORMALS ( IDCON )* ) ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:373:8: ( ^( FORMALS ( IDCON )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:373:11: ^( FORMALS ( IDCON )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FORMALS43=(CommonTree)match(input,FORMALS,FOLLOW_FORMALS_in_formals565); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FORMALS43_tree = (CommonTree)adaptor.dupNode(FORMALS43);

            root_1 = (CommonTree)adaptor.becomeRoot(FORMALS43_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:373:22: ( IDCON )*
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
                	    IDCON44=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_formals567); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:379:1: statement : ( ifStatement | eachStatement | letStatement | blockStatement | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) | ^( MARKUP_STATEMENT ( markup )+ ';' ) | ^( MARKUP_STATEMENT ( markup )+ statement ) );
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
        CommonTree char_literal65=null;
        CommonTree MARKUP_STATEMENT66=null;
        CommonTree char_literal69=null;
        CommonTree MARKUP_STATEMENT70=null;
        CommonTree char_literal72=null;
        CommonTree MARKUP_STATEMENT73=null;
        WaebricInterpreter.ifStatement_return ifStatement45 = null;

        WaebricInterpreter.eachStatement_return eachStatement46 = null;

        WaebricInterpreter.letStatement_return letStatement47 = null;

        WaebricInterpreter.blockStatement_return blockStatement48 = null;

        WaebricInterpreter.expression_return expression53 = null;

        WaebricInterpreter.embedding_return embedding56 = null;

        WaebricInterpreter.expression_return expression59 = null;

        WaebricInterpreter.markup_return markup63 = null;

        WaebricInterpreter.expression_return expression64 = null;

        WaebricInterpreter.markup_return markup67 = null;

        WaebricInterpreter.embedding_return embedding68 = null;

        WaebricInterpreter.markup_return markup71 = null;

        WaebricInterpreter.markup_return markup74 = null;

        WaebricInterpreter.statement_return statement75 = null;


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
        CommonTree char_literal65_tree=null;
        CommonTree MARKUP_STATEMENT66_tree=null;
        CommonTree char_literal69_tree=null;
        CommonTree MARKUP_STATEMENT70_tree=null;
        CommonTree char_literal72_tree=null;
        CommonTree MARKUP_STATEMENT73_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:379:10: ( ifStatement | eachStatement | letStatement | blockStatement | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) | ^( MARKUP_STATEMENT ( markup )+ ';' ) | ^( MARKUP_STATEMENT ( markup )+ statement ) )
            int alt19=13;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:379:13: ifStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_ifStatement_in_statement583);
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:380:6: eachStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_eachStatement_in_statement590);
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:381:6: letStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_letStatement_in_statement597);
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:382:6: blockStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_blockStatement_in_statement604);
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:383:6: ^( 'comment' STRCON ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal49=(CommonTree)match(input,COMMENT,FOLLOW_COMMENT_in_statement613); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal49_tree = (CommonTree)adaptor.dupNode(string_literal49);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal49_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    STRCON50=(CommonTree)match(input,STRCON,FOLLOW_STRCON_in_statement615); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRCON50_tree = (CommonTree)adaptor.dupNode(STRCON50);

                    adaptor.addChild(root_1, STRCON50_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal51=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement617); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:384:6: ^( 'echo' expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal52=(CommonTree)match(input,61,FOLLOW_61_in_statement630); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal52_tree = (CommonTree)adaptor.dupNode(string_literal52);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal52_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement632);
                    expression53=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression53.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal54=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement634); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:385:6: ^( 'echo' embedding ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal55=(CommonTree)match(input,61,FOLLOW_61_in_statement647); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal55_tree = (CommonTree)adaptor.dupNode(string_literal55);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal55_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement649);
                    embedding56=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding56.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal57=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement651); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:386:6: ^( 'cdata' expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal58=(CommonTree)match(input,62,FOLLOW_62_in_statement662); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal58_tree = (CommonTree)adaptor.dupNode(string_literal58);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal58_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement664);
                    expression59=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression59.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal60=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement666); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:387:6: 'yield;'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal61=(CommonTree)match(input,63,FOLLOW_63_in_statement677); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal61_tree = (CommonTree)adaptor.dupNode(string_literal61);

                    adaptor.addChild(root_0, string_literal61_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:388:6: ^( MARKUP_STATEMENT ( markup )+ expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT62=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement686); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT62_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT62);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT62_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:388:26: ( markup )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==MARKUP) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement688);
                    	    markup63=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup63.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt15 >= 1 ) break loop15;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement691);
                    expression64=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression64.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal65=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement693); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal65_tree = (CommonTree)adaptor.dupNode(char_literal65);

                    adaptor.addChild(root_1, char_literal65_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                    if ( state.backtracking==0 ) {
                       addContent(new Text((expression64!=null?expression64.eval:null))); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:389:6: ^( MARKUP_STATEMENT ( markup )+ embedding ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT66=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement706); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT66_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT66);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT66_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:389:26: ( markup )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==MARKUP) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement708);
                    	    markup67=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup67.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt16 >= 1 ) break loop16;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(16, input);
                                throw eee;
                        }
                        cnt16++;
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement711);
                    embedding68=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding68.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal69=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement713); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal69_tree = (CommonTree)adaptor.dupNode(char_literal69);

                    adaptor.addChild(root_1, char_literal69_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:390:6: ^( MARKUP_STATEMENT ( markup )+ ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT70=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement724); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT70_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT70);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT70_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:390:26: ( markup )+
                    int cnt17=0;
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==MARKUP) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement726);
                    	    markup71=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup71.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt17 >= 1 ) break loop17;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(17, input);
                                throw eee;
                        }
                        cnt17++;
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal72=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement729); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal72_tree = (CommonTree)adaptor.dupNode(char_literal72);

                    adaptor.addChild(root_1, char_literal72_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:391:6: ^( MARKUP_STATEMENT ( markup )+ statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT73=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement741); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT73_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT73);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT73_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:391:26: ( markup )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==MARKUP) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement743);
                    	    markup74=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup74.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt18 >= 1 ) break loop18;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(18, input);
                                throw eee;
                        }
                        cnt18++;
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement746);
                    statement75=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement75.getTree());

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

    public static class ifStatement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ifStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:393:1: ifStatement : ^( 'if' '(' predicate ')' t= . ( 'else' f= . )? ) ;
    public final WaebricInterpreter.ifStatement_return ifStatement() throws RecognitionException {
        WaebricInterpreter.ifStatement_return retval = new WaebricInterpreter.ifStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal76=null;
        CommonTree char_literal77=null;
        CommonTree char_literal79=null;
        CommonTree string_literal80=null;
        CommonTree t=null;
        CommonTree f=null;
        WaebricInterpreter.predicate_return predicate78 = null;


        CommonTree string_literal76_tree=null;
        CommonTree char_literal77_tree=null;
        CommonTree char_literal79_tree=null;
        CommonTree string_literal80_tree=null;
        CommonTree t_tree=null;
        CommonTree f_tree=null;

         int ti = 0; int fi = 0; 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:395:2: ( ^( 'if' '(' predicate ')' t= . ( 'else' f= . )? ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:395:5: ^( 'if' '(' predicate ')' t= . ( 'else' f= . )? )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal76=(CommonTree)match(input,56,FOLLOW_56_in_ifStatement766); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal76_tree = (CommonTree)adaptor.dupNode(string_literal76);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal76_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            char_literal77=(CommonTree)match(input,47,FOLLOW_47_in_ifStatement768); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal77_tree = (CommonTree)adaptor.dupNode(char_literal77);

            adaptor.addChild(root_1, char_literal77_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_predicate_in_ifStatement770);
            predicate78=predicate();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, predicate78.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal79=(CommonTree)match(input,49,FOLLOW_49_in_ifStatement772); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal79_tree = (CommonTree)adaptor.dupNode(char_literal79);

            adaptor.addChild(root_1, char_literal79_tree);
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:395:60: ( 'else' f= . )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==57) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:395:62: 'else' f= .
                    {
                    _last = (CommonTree)input.LT(1);
                    string_literal80=(CommonTree)match(input,57,FOLLOW_57_in_ifStatement783); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal80_tree = (CommonTree)adaptor.dupNode(string_literal80);

                    adaptor.addChild(root_1, string_literal80_tree);
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
              				if((predicate78!=null?predicate78.eval:false)) {
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:408:1: eachStatement : ^( 'each' '(' IDCON ':' e= expression ')' . ) ;
    public final WaebricInterpreter.eachStatement_return eachStatement() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricInterpreter.eachStatement_return retval = new WaebricInterpreter.eachStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal81=null;
        CommonTree char_literal82=null;
        CommonTree IDCON83=null;
        CommonTree char_literal84=null;
        CommonTree char_literal85=null;
        CommonTree wildcard86=null;
        WaebricInterpreter.expression_return e = null;


        CommonTree string_literal81_tree=null;
        CommonTree char_literal82_tree=null;
        CommonTree IDCON83_tree=null;
        CommonTree char_literal84_tree=null;
        CommonTree char_literal85_tree=null;
        CommonTree wildcard86_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new HashMap<String, Integer>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        		int stm = 0;
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:414:4: ( ^( 'each' '(' IDCON ':' e= expression ')' . ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:414:7: ^( 'each' '(' IDCON ':' e= expression ')' . )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal81=(CommonTree)match(input,58,FOLLOW_58_in_eachStatement823); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal81_tree = (CommonTree)adaptor.dupNode(string_literal81);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal81_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            char_literal82=(CommonTree)match(input,47,FOLLOW_47_in_eachStatement825); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal82_tree = (CommonTree)adaptor.dupNode(char_literal82);

            adaptor.addChild(root_1, char_literal82_tree);
            }
            _last = (CommonTree)input.LT(1);
            IDCON83=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_eachStatement827); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON83_tree = (CommonTree)adaptor.dupNode(IDCON83);

            adaptor.addChild(root_1, IDCON83_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal84=(CommonTree)match(input,42,FOLLOW_42_in_eachStatement829); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal84_tree = (CommonTree)adaptor.dupNode(char_literal84);

            adaptor.addChild(root_1, char_literal84_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_eachStatement833);
            e=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, e.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal85=(CommonTree)match(input,49,FOLLOW_49_in_eachStatement835); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal85_tree = (CommonTree)adaptor.dupNode(char_literal85);

            adaptor.addChild(root_1, char_literal85_tree);
            }
            if ( state.backtracking==0 ) {
               stm = input.index(); 
            }
            _last = (CommonTree)input.LT(1);
            wildcard86=(CommonTree)input.LT(1);
            matchAny(input); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            wildcard86_tree = (CommonTree)adaptor.dupTree(wildcard86);
            adaptor.addChild(root_1, wildcard86_tree);
            }

            match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }

            if ( state.backtracking==0 ) {

              				int actualIndex = input.index();
                            			Element actualElement = this.current;
                            			for(expression_return value: e.collection) {
                            				((Environment_scope)Environment_stack.peek()).variables.put(IDCON83.getText(), value.index);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:427:1: blockStatement : ^( '{' ( statement )* '}' ) ;
    public final WaebricInterpreter.blockStatement_return blockStatement() throws RecognitionException {
        WaebricInterpreter.blockStatement_return retval = new WaebricInterpreter.blockStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal87=null;
        CommonTree char_literal89=null;
        WaebricInterpreter.statement_return statement88 = null;


        CommonTree char_literal87_tree=null;
        CommonTree char_literal89_tree=null;

         Element actual = this.current; 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:429:2: ( ^( '{' ( statement )* '}' ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:429:5: ^( '{' ( statement )* '}' )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            char_literal87=(CommonTree)match(input,53,FOLLOW_53_in_blockStatement861); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal87_tree = (CommonTree)adaptor.dupNode(char_literal87);

            root_1 = (CommonTree)adaptor.becomeRoot(char_literal87_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:429:12: ( statement )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==MARKUP_STATEMENT||LA21_0==COMMENT||LA21_0==53||LA21_0==56||(LA21_0>=58 && LA21_0<=59)||(LA21_0>=61 && LA21_0<=63)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:429:14: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_blockStatement865);
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
            char_literal89=(CommonTree)match(input,54,FOLLOW_54_in_blockStatement872); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal89_tree = (CommonTree)adaptor.dupNode(char_literal89);

            adaptor.addChild(root_1, char_literal89_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:434:1: letStatement : ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) ;
    public final WaebricInterpreter.letStatement_return letStatement() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricInterpreter.letStatement_return retval = new WaebricInterpreter.letStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal90=null;
        CommonTree string_literal92=null;
        CommonTree string_literal94=null;
        WaebricInterpreter.assignment_return assignment91 = null;

        WaebricInterpreter.statement_return statement93 = null;


        CommonTree string_literal90_tree=null;
        CommonTree string_literal92_tree=null;
        CommonTree string_literal94_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new HashMap<String, Integer>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        		Element actual = this.current;
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:440:4: ( ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:440:7: ^( 'let' ( assignment )+ 'in' ( statement )* 'end' )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal90=(CommonTree)match(input,59,FOLLOW_59_in_letStatement900); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal90_tree = (CommonTree)adaptor.dupNode(string_literal90);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal90_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:440:16: ( assignment )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=FUNCTION && LA22_0<=IDCON)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: assignment
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_assignment_in_letStatement902);
            	    assignment91=assignment();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, assignment91.getTree());

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
            string_literal92=(CommonTree)match(input,60,FOLLOW_60_in_letStatement905); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal92_tree = (CommonTree)adaptor.dupNode(string_literal92);

            adaptor.addChild(root_1, string_literal92_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:440:33: ( statement )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==MARKUP_STATEMENT||LA23_0==COMMENT||LA23_0==53||LA23_0==56||(LA23_0>=58 && LA23_0<=59)||(LA23_0>=61 && LA23_0<=63)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:440:35: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_letStatement909);
            	    statement93=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, statement93.getTree());
            	    if ( state.backtracking==0 ) {
            	       
            	      					if(actual != null) { this.current = actual; } 
            	      					else { actual = this.current; } 
            	      				
            	    }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            string_literal94=(CommonTree)match(input,END,FOLLOW_END_in_letStatement916); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal94_tree = (CommonTree)adaptor.dupNode(string_literal94);

            adaptor.addChild(root_1, string_literal94_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:448:1: assignment : ( varBinding | funcBinding );
    public final WaebricInterpreter.assignment_return assignment() throws RecognitionException {
        WaebricInterpreter.assignment_return retval = new WaebricInterpreter.assignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricInterpreter.varBinding_return varBinding95 = null;

        WaebricInterpreter.funcBinding_return funcBinding96 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:448:11: ( varBinding | funcBinding )
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:448:14: varBinding
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_varBinding_in_assignment930);
                    varBinding95=varBinding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, varBinding95.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:448:27: funcBinding
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_funcBinding_in_assignment934);
                    funcBinding96=funcBinding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, funcBinding96.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:450:1: varBinding : IDCON '=' expression ';' ;
    public final WaebricInterpreter.varBinding_return varBinding() throws RecognitionException {
        WaebricInterpreter.varBinding_return retval = new WaebricInterpreter.varBinding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON97=null;
        CommonTree char_literal98=null;
        CommonTree char_literal100=null;
        WaebricInterpreter.expression_return expression99 = null;


        CommonTree IDCON97_tree=null;
        CommonTree char_literal98_tree=null;
        CommonTree char_literal100_tree=null;

         int index = 0; 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:452:2: ( IDCON '=' expression ';' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:452:5: IDCON '=' expression ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON97=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_varBinding952); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON97_tree = (CommonTree)adaptor.dupNode(IDCON97);

            adaptor.addChild(root_0, IDCON97_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal98=(CommonTree)match(input,50,FOLLOW_50_in_varBinding954); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal98_tree = (CommonTree)adaptor.dupNode(char_literal98);

            adaptor.addChild(root_0, char_literal98_tree);
            }
            if ( state.backtracking==0 ) {
               index = input.index(); 
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_varBinding958);
            expression99=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, expression99.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal100=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_varBinding960); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal100_tree = (CommonTree)adaptor.dupNode(char_literal100);

            adaptor.addChild(root_0, char_literal100_tree);
            }
            if ( state.backtracking==0 ) {

              				defineVariable(IDCON97.getText(), index);
              			
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:456:1: funcBinding : ^( FUNCTION id= IDCON formals stm= . ) ;
    public final WaebricInterpreter.funcBinding_return funcBinding() throws RecognitionException {
        WaebricInterpreter.funcBinding_return retval = new WaebricInterpreter.funcBinding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        CommonTree FUNCTION101=null;
        CommonTree stm=null;
        WaebricInterpreter.formals_return formals102 = null;


        CommonTree id_tree=null;
        CommonTree FUNCTION101_tree=null;
        CommonTree stm_tree=null;

         int index = input.index(); 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:458:2: ( ^( FUNCTION id= IDCON formals stm= . ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:458:5: ^( FUNCTION id= IDCON formals stm= . )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNCTION101=(CommonTree)match(input,FUNCTION,FOLLOW_FUNCTION_in_funcBinding984); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FUNCTION101_tree = (CommonTree)adaptor.dupNode(FUNCTION101);

            root_1 = (CommonTree)adaptor.becomeRoot(FUNCTION101_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_funcBinding988); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (CommonTree)adaptor.dupNode(id);

            adaptor.addChild(root_1, id_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_formals_in_funcBinding990);
            formals102=formals();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, formals102.getTree());
            _last = (CommonTree)input.LT(1);
            stm=(CommonTree)input.LT(1);
            matchAny(input); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            stm_tree = (CommonTree)adaptor.dupTree(stm);
            adaptor.addChild(root_1, stm_tree);
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

            		defineFunction(id.getText(), index);
            		environments.put(id.getText(), (Stack) Environment_stack.clone());
            	
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:467:1: predicate returns [boolean eval] : ( '!' p= predicate | e= expression | e= expression '.' type ) ( '&&' p= predicate | '||' p= predicate )* ;
    public final WaebricInterpreter.predicate_return predicate() throws RecognitionException {
        WaebricInterpreter.predicate_return retval = new WaebricInterpreter.predicate_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal103=null;
        CommonTree char_literal104=null;
        CommonTree string_literal106=null;
        CommonTree string_literal107=null;
        WaebricInterpreter.predicate_return p = null;

        WaebricInterpreter.expression_return e = null;

        WaebricInterpreter.type_return type105 = null;


        CommonTree char_literal103_tree=null;
        CommonTree char_literal104_tree=null;
        CommonTree string_literal106_tree=null;
        CommonTree string_literal107_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:468:2: ( ( '!' p= predicate | e= expression | e= expression '.' type ) ( '&&' p= predicate | '||' p= predicate )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:468:5: ( '!' p= predicate | e= expression | e= expression '.' type ) ( '&&' p= predicate | '||' p= predicate )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:468:5: ( '!' p= predicate | e= expression | e= expression '.' type )
            int alt25=3;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:468:7: '!' p= predicate
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal103=(CommonTree)match(input,64,FOLLOW_64_in_predicate1021); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal103_tree = (CommonTree)adaptor.dupNode(char_literal103);

                    adaptor.addChild(root_0, char_literal103_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_predicate1025);
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:469:7: e= expression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate1037);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, e.getTree());
                    if ( state.backtracking==0 ) {
                       retval.eval = getVariable((e!=null?e.eval:null)) != null; 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:470:7: e= expression '.' type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate1050);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, e.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal104=(CommonTree)match(input,40,FOLLOW_40_in_predicate1052); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal104_tree = (CommonTree)adaptor.dupNode(char_literal104);

                    adaptor.addChild(root_0, char_literal104_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_predicate1054);
                    type105=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, type105.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:471:6: ( '&&' p= predicate | '||' p= predicate )*
            loop26:
            do {
                int alt26=3;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==65) ) {
                    int LA26_2 = input.LA(2);

                    if ( (synpred46_WaebricInterpreter()) ) {
                        alt26=1;
                    }


                }
                else if ( (LA26_0==66) ) {
                    int LA26_3 = input.LA(2);

                    if ( (synpred47_WaebricInterpreter()) ) {
                        alt26=2;
                    }


                }


                switch (alt26) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:471:8: '&&' p= predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal106=(CommonTree)match(input,65,FOLLOW_65_in_predicate1064); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal106_tree = (CommonTree)adaptor.dupNode(string_literal106);

            	    adaptor.addChild(root_0, string_literal106_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate1068);
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
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:471:57: '||' p= predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal107=(CommonTree)match(input,66,FOLLOW_66_in_predicate1074); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal107_tree = (CommonTree)adaptor.dupNode(string_literal107);

            	    adaptor.addChild(root_0, string_literal107_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate1078);
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

    public static class type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:473:1: type : ( 'list' | 'record' | 'string' );
    public final WaebricInterpreter.type_return type() throws RecognitionException {
        WaebricInterpreter.type_return retval = new WaebricInterpreter.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set108=null;

        CommonTree set108_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:473:5: ( 'list' | 'record' | 'string' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            set108=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=67 && input.LA(1)<=69) ) {
                input.consume();

                if ( state.backtracking==0 ) {
                set108_tree = (CommonTree)adaptor.dupNode(set108);

                adaptor.addChild(root_0, set108_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:478:1: embedding : PRETEXT embed textTail ;
    public final WaebricInterpreter.embedding_return embedding() throws RecognitionException {
        WaebricInterpreter.embedding_return retval = new WaebricInterpreter.embedding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PRETEXT109=null;
        WaebricInterpreter.embed_return embed110 = null;

        WaebricInterpreter.textTail_return textTail111 = null;


        CommonTree PRETEXT109_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:478:10: ( PRETEXT embed textTail )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:478:13: PRETEXT embed textTail
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PRETEXT109=(CommonTree)match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding1116); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRETEXT109_tree = (CommonTree)adaptor.dupNode(PRETEXT109);

            adaptor.addChild(root_0, PRETEXT109_tree);
            }
            if ( state.backtracking==0 ) {
               addContent(new Text(PRETEXT109.getText())); 
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_embed_in_embedding1120);
            embed110=embed();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, embed110.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_textTail_in_embedding1122);
            textTail111=textTail();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, textTail111.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:480:1: embed : ( ( markup )* expression | ( markup )+ );
    public final WaebricInterpreter.embed_return embed() throws RecognitionException {
        WaebricInterpreter.embed_return retval = new WaebricInterpreter.embed_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricInterpreter.markup_return markup112 = null;

        WaebricInterpreter.expression_return expression113 = null;

        WaebricInterpreter.markup_return markup114 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:480:6: ( ( markup )* expression | ( markup )+ )
            int alt29=2;
            alt29 = dfa29.predict(input);
            switch (alt29) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:480:10: ( markup )* expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:480:10: ( markup )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==MARKUP) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed1132);
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
                    	    break loop27;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_embed1135);
                    expression113=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression113.getTree());
                    if ( state.backtracking==0 ) {
                       addContent(new Text((expression113!=null?expression113.eval:null))); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:481:6: ( markup )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:481:6: ( markup )+
                    int cnt28=0;
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==MARKUP) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed1145);
                    	    markup114=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup114.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:483:1: textTail : ( POSTTEXT | MIDTEXT embed textTail );
    public final WaebricInterpreter.textTail_return textTail() throws RecognitionException {
        WaebricInterpreter.textTail_return retval = new WaebricInterpreter.textTail_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POSTTEXT115=null;
        CommonTree MIDTEXT116=null;
        WaebricInterpreter.embed_return embed117 = null;

        WaebricInterpreter.textTail_return textTail118 = null;


        CommonTree POSTTEXT115_tree=null;
        CommonTree MIDTEXT116_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:483:9: ( POSTTEXT | MIDTEXT embed textTail )
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:483:12: POSTTEXT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    POSTTEXT115=(CommonTree)match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail1155); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    POSTTEXT115_tree = (CommonTree)adaptor.dupNode(POSTTEXT115);

                    adaptor.addChild(root_0, POSTTEXT115_tree);
                    }
                    if ( state.backtracking==0 ) {
                       addContent(new Text(POSTTEXT115.getText())); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:484:6: MIDTEXT embed textTail
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    MIDTEXT116=(CommonTree)match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail1164); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MIDTEXT116_tree = (CommonTree)adaptor.dupNode(MIDTEXT116);

                    adaptor.addChild(root_0, MIDTEXT116_tree);
                    }
                    if ( state.backtracking==0 ) {
                       addContent(new Text(MIDTEXT116.getText())); 
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embed_in_textTail1168);
                    embed117=embed();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, embed117.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_textTail_in_textTail1170);
                    textTail118=textTail();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, textTail118.getTree());

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


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:338:6: ( '+' e= expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:338:6: '+' e= expression
        {
        match(input,55,FOLLOW_55_in_synpred18_WaebricInterpreter447); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred18_WaebricInterpreter451);
        e=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_WaebricInterpreter

    // $ANTLR start synpred19_WaebricInterpreter
    public final void synpred19_WaebricInterpreter_fragment() throws RecognitionException {   
        CommonTree id=null;

        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:344:6: ( '.' id= IDCON )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:344:6: '.' id= IDCON
        {
        match(input,40,FOLLOW_40_in_synpred19_WaebricInterpreter461); if (state.failed) return ;
        id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_synpred19_WaebricInterpreter465); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_WaebricInterpreter

    // $ANTLR start synpred45_WaebricInterpreter
    public final void synpred45_WaebricInterpreter_fragment() throws RecognitionException {   
        WaebricInterpreter.expression_return e = null;


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:469:7: (e= expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:469:7: e= expression
        {
        pushFollow(FOLLOW_expression_in_synpred45_WaebricInterpreter1037);
        e=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred45_WaebricInterpreter

    // $ANTLR start synpred46_WaebricInterpreter
    public final void synpred46_WaebricInterpreter_fragment() throws RecognitionException {   
        WaebricInterpreter.predicate_return p = null;


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:471:8: ( '&&' p= predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:471:8: '&&' p= predicate
        {
        match(input,65,FOLLOW_65_in_synpred46_WaebricInterpreter1064); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred46_WaebricInterpreter1068);
        p=predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_WaebricInterpreter

    // $ANTLR start synpred47_WaebricInterpreter
    public final void synpred47_WaebricInterpreter_fragment() throws RecognitionException {   
        WaebricInterpreter.predicate_return p = null;


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:471:57: ( '||' p= predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:471:57: '||' p= predicate
        {
        match(input,66,FOLLOW_66_in_synpred47_WaebricInterpreter1074); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred47_WaebricInterpreter1078);
        p=predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred47_WaebricInterpreter

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


    protected DFA19 dfa19 = new DFA19(this);
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA29 dfa29 = new DFA29(this);
    static final String DFA19_eotS =
        "\37\uffff";
    static final String DFA19_eofS =
        "\37\uffff";
    static final String DFA19_minS =
        "\1\7\5\uffff\1\2\2\uffff\1\2\1\12\1\6\2\uffff\1\2\1\12\1\4\2\2\1"+
        "\4\1\6\1\4\1\3\1\uffff\1\2\3\uffff\1\3\1\4\1\3";
    static final String DFA19_maxS =
        "\1\77\5\uffff\1\2\2\uffff\1\2\1\65\1\6\2\uffff\1\2\1\12\2\105\1"+
        "\3\1\105\1\77\2\105\1\uffff\1\66\3\uffff\2\105\1\3";
    static final String DFA19_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\11\3\uffff\1\7\1\6\11"+
        "\uffff\1\12\1\uffff\1\15\1\13\1\14\3\uffff";
    static final String DFA19_specialS =
        "\37\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\11\13\uffff\1\5\41\uffff\1\4\2\uffff\1\1\1\uffff\1\2\1\3"+
            "\1\uffff\1\6\1\7\1\10",
            "",
            "",
            "",
            "",
            "",
            "\1\12",
            "",
            "",
            "\1\13",
            "\1\15\1\uffff\3\15\1\uffff\1\14\42\uffff\1\15\1\uffff\1\15",
            "\1\16",
            "",
            "",
            "\1\17",
            "\1\20",
            "\102\21",
            "\1\23\1\uffff\102\22",
            "\1\25\1\24",
            "\102\26",
            "\1\16\1\31\2\uffff\1\27\1\uffff\3\27\1\uffff\1\32\2\uffff\1"+
            "\31\2\uffff\1\33\34\uffff\1\27\1\uffff\1\30\2\uffff\1\31\1\uffff"+
            "\2\31\1\uffff\3\31",
            "\102\34",
            "\1\35\102\26",
            "",
            "\1\31\7\uffff\1\27\45\uffff\1\27\5\uffff\1\27",
            "",
            "",
            "",
            "\1\36\102\34",
            "\102\22",
            "\1\24"
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
            return "379:1: statement : ( ifStatement | eachStatement | letStatement | blockStatement | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) | ^( MARKUP_STATEMENT ( markup )+ ';' ) | ^( MARKUP_STATEMENT ( markup )+ statement ) );";
        }
    }
    static final String DFA25_eotS =
        "\12\uffff";
    static final String DFA25_eofS =
        "\12\uffff";
    static final String DFA25_minS =
        "\1\12\1\uffff\6\0\2\uffff";
    static final String DFA25_maxS =
        "\1\100\1\uffff\6\0\2\uffff";
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
            return "468:5: ( '!' p= predicate | e= expression | e= expression '.' type )";
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
                        if ( (synpred45_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index25_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA25_3 = input.LA(1);

                         
                        int index25_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index25_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA25_4 = input.LA(1);

                         
                        int index25_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index25_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA25_5 = input.LA(1);

                         
                        int index25_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index25_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA25_6 = input.LA(1);

                         
                        int index25_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index25_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA25_7 = input.LA(1);

                         
                        int index25_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_WaebricInterpreter()) ) {s = 8;}

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
        "\1\6\1\2\1\uffff\1\12\1\4\2\2\1\4\1\6\1\4\1\3\1\uffff\1\3\1\4\1"+
        "\3";
    static final String DFA29_maxS =
        "\1\65\1\2\1\uffff\1\12\2\105\1\3\1\105\1\65\2\105\1\uffff\2\105"+
        "\1\3";
    static final String DFA29_acceptS =
        "\2\uffff\1\1\10\uffff\1\2\3\uffff";
    static final String DFA29_specialS =
        "\17\uffff}>";
    static final String[] DFA29_transitionS = {
            "\1\1\3\uffff\1\2\1\uffff\3\2\44\uffff\1\2\1\uffff\1\2",
            "\1\3",
            "",
            "\1\4",
            "\102\5",
            "\1\7\1\uffff\102\6",
            "\1\11\1\10",
            "\102\12",
            "\1\1\3\uffff\1\2\1\uffff\3\2\2\uffff\2\13\40\uffff\1\2\1\uffff"+
            "\1\2",
            "\102\14",
            "\1\15\102\12",
            "",
            "\1\16\102\14",
            "\102\6",
            "\1\10"
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
            return "480:1: embed : ( ( markup )* expression | ( markup )+ );";
        }
    }
 

    public static final BitSet FOLLOW_PATH_in_mapping78 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_mapping80 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_markup_in_mapping82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUP_in_markup106 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_markup108 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000000000003FL});
    public static final BitSet FOLLOW_ATTRIBUTES_in_attributes134 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attribute_in_attributes136 = new BitSet(new long[]{0x00003D0000000008L});
    public static final BitSet FOLLOW_43_in_attribute148 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_attribute150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_attribute159 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_attribute161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_attribute170 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_attribute172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_attribute181 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_attribute183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_attribute192 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_NATCON_in_attribute196 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_46_in_attribute206 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_NATCON_in_attribute210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARGUMENTS_in_arguments236 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_argument_in_arguments238 = new BitSet(new long[]{0x0028000000007408L});
    public static final BitSet FOLLOW_expression_in_argument260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_argument266 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_argument268 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_argument270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_expression303 = new BitSet(new long[]{0x0080010000000002L});
    public static final BitSet FOLLOW_NATCON_in_expression312 = new BitSet(new long[]{0x0080010000000002L});
    public static final BitSet FOLLOW_TEXT_in_expression321 = new BitSet(new long[]{0x0080010000000002L});
    public static final BitSet FOLLOW_SYMBOLCON_in_expression330 = new BitSet(new long[]{0x0080010000000002L});
    public static final BitSet FOLLOW_51_in_expression339 = new BitSet(new long[]{0x0039000000007400L});
    public static final BitSet FOLLOW_expression_in_expression345 = new BitSet(new long[]{0x0011000000000000L});
    public static final BitSet FOLLOW_48_in_expression360 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_expression364 = new BitSet(new long[]{0x0011000000000000L});
    public static final BitSet FOLLOW_52_in_expression371 = new BitSet(new long[]{0x0080010000000002L});
    public static final BitSet FOLLOW_53_in_expression380 = new BitSet(new long[]{0x0041000000000400L});
    public static final BitSet FOLLOW_IDCON_in_expression386 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_expression388 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_expression392 = new BitSet(new long[]{0x0041000000000000L});
    public static final BitSet FOLLOW_48_in_expression407 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_expression411 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_expression413 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_expression417 = new BitSet(new long[]{0x0041000000000000L});
    public static final BitSet FOLLOW_54_in_expression424 = new BitSet(new long[]{0x0080010000000002L});
    public static final BitSet FOLLOW_55_in_expression447 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_expression451 = new BitSet(new long[]{0x0080010000000002L});
    public static final BitSet FOLLOW_40_in_expression461 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_expression465 = new BitSet(new long[]{0x0080010000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_function497 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_function499 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_FORMALS_in_function513 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_function519 = new BitSet(new long[]{0x0000000000000408L});
    public static final BitSet FOLLOW_statement_in_function544 = new BitSet(new long[]{0xED20000000080088L});
    public static final BitSet FOLLOW_FORMALS_in_formals565 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_formals567 = new BitSet(new long[]{0x0000000000000408L});
    public static final BitSet FOLLOW_ifStatement_in_statement583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_eachStatement_in_statement590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_letStatement_in_statement597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blockStatement_in_statement604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMENT_in_statement613 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRCON_in_statement615 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement617 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_61_in_statement630 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement632 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement634 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_61_in_statement647 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_statement649 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement651 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_62_in_statement662 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement664 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement666 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_63_in_statement677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement686 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement688 = new BitSet(new long[]{0x0028000000007440L});
    public static final BitSet FOLLOW_expression_in_statement691 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement693 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement706 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement708 = new BitSet(new long[]{0x0000000000010040L});
    public static final BitSet FOLLOW_embedding_in_statement711 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement713 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement724 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement726 = new BitSet(new long[]{0x0000000000400040L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement729 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement741 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement743 = new BitSet(new long[]{0xED200000000800C8L});
    public static final BitSet FOLLOW_statement_in_statement746 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_56_in_ifStatement766 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_47_in_ifStatement768 = new BitSet(new long[]{0x0028000000007400L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_ifStatement770 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ifStatement772 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000000000003FL});
    public static final BitSet FOLLOW_57_in_ifStatement783 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000000000003FL});
    public static final BitSet FOLLOW_58_in_eachStatement823 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_47_in_eachStatement825 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_eachStatement827 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_eachStatement829 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_eachStatement833 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_eachStatement835 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000000000003FL});
    public static final BitSet FOLLOW_53_in_blockStatement861 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_blockStatement865 = new BitSet(new long[]{0xED60000000080088L});
    public static final BitSet FOLLOW_54_in_blockStatement872 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_59_in_letStatement900 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_assignment_in_letStatement902 = new BitSet(new long[]{0x1000000000000600L});
    public static final BitSet FOLLOW_60_in_letStatement905 = new BitSet(new long[]{0xED20000000280088L});
    public static final BitSet FOLLOW_statement_in_letStatement909 = new BitSet(new long[]{0xED20000000280088L});
    public static final BitSet FOLLOW_END_in_letStatement916 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_varBinding_in_assignment930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funcBinding_in_assignment934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_varBinding952 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_varBinding954 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_varBinding958 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_varBinding960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_funcBinding984 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_funcBinding988 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_formals_in_funcBinding990 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000000000003FL});
    public static final BitSet FOLLOW_64_in_predicate1021 = new BitSet(new long[]{0x0028000000007400L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_predicate1025 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000006L});
    public static final BitSet FOLLOW_expression_in_predicate1037 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000006L});
    public static final BitSet FOLLOW_expression_in_predicate1050 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_predicate1052 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000038L});
    public static final BitSet FOLLOW_type_in_predicate1054 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000006L});
    public static final BitSet FOLLOW_65_in_predicate1064 = new BitSet(new long[]{0x0028000000007400L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_predicate1068 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000006L});
    public static final BitSet FOLLOW_66_in_predicate1074 = new BitSet(new long[]{0x0028000000007400L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_predicate1078 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000006L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding1116 = new BitSet(new long[]{0x0028000000007440L});
    public static final BitSet FOLLOW_embed_in_embedding1120 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_textTail_in_embedding1122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed1132 = new BitSet(new long[]{0x0028000000007440L});
    public static final BitSet FOLLOW_expression_in_embed1135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed1145 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail1155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail1164 = new BitSet(new long[]{0x0028000000007440L});
    public static final BitSet FOLLOW_embed_in_textTail1168 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_textTail_in_textTail1170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_synpred18_WaebricInterpreter447 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_synpred18_WaebricInterpreter451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_synpred19_WaebricInterpreter461 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_synpred19_WaebricInterpreter465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred45_WaebricInterpreter1037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_synpred46_WaebricInterpreter1064 = new BitSet(new long[]{0x0028000000007400L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_synpred46_WaebricInterpreter1068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_synpred47_WaebricInterpreter1074 = new BitSet(new long[]{0x0028000000007400L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_synpred47_WaebricInterpreter1078 = new BitSet(new long[]{0x0000000000000002L});

}