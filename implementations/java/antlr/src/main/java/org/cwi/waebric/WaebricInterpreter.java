// $ANTLR 3.1.2 /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g 2009-08-15 12:34:09

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
        Map<String, CommonTree> functions;
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
    	public static Document document;
    	public static Element current;
    	
    	// Additional fields
    	public static Stack<Integer> yields;
    	public static Map<String, Stack> environments;

    	public WaebricInterpreter(TreeNodeStream input, Environment_scope base) {
    		super(input);
    		Environment_stack.push(base);
    	}
    	
    	/**
    	 * Interpret program
    	 * @param os: Output stream for interpreting main function
    	 */
    	public void interpretProgram(OutputStream os, WaebricLoader loader) throws RecognitionException {
    		// Store function definitions to allow lazy function binding
    		Environment_stack.clear();
    		Environment_scope base = new Environment_scope();
    		base.functions = new HashMap<String, CommonTree>();
    		base.variables = new HashMap<String, Integer>();
    		for(String function: loader.getFunctions().keySet()) 
    		{ base.functions.put(function, loader.getFunctions().get(function).tree); }
    		Environment_stack.push(base);
    		
    		// Interpret main function
    		this.document = new Document();
    		if(interpretFunction("main")) {
    			if(current != null) { outputDocument(document, os); }
    		}
    		
    		// Interpret mappings
    		for(WaebricLoader.mapping_return mapping: loader.getMappings()) {
    			WaebricInterpreter instance = new WaebricInterpreter(
        				new CommonTreeNodeStream(mapping.tree),
        				(Environment_scope) Environment_stack.elementAt(0));
        			instance.mapping();
    		}
    	}
    	
    	/**
    	 * Interpret function
    	 * @param name: Function name
    	 */
        	private boolean interpretFunction(String name) throws RecognitionException {
        		CommonTree function = getFunction(name);
        		if(function != null) {
        			WaebricInterpreter instance = new WaebricInterpreter(
        				new CommonTreeNodeStream(function),
        				(Environment_scope) Environment_stack.elementAt(0));
        			instance.function(); // Interpret function call in seperate instance, local scope
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
    	private CommonTree getFunction(String name) {
    		for(int i=Environment_stack.size()-1; i>=0; i--) {
    			if(((Environment_scope)Environment_stack.elementAt(i)).functions.containsKey(name)) {
    				return ((Environment_scope)Environment_stack.elementAt(i)).functions.get(name); 
    			}
    		} return null ;
    	}
    	
    	/**
    	 * Define function
    	 * @param name: Function name
    	 * @param tree: Function AST
    	 */
    	private void defineFunction(String name, CommonTree tree) {
    		((Environment_scope)Environment_stack.peek()).functions.put(name, tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:206:1: mapping : PATH ':' markup ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:208:2: ( PATH ':' markup )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:208:5: PATH ':' markup
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
              					outputDocument(document, os);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:220:1: markup : ^( MARKUP IDCON . . ) ;
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

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:220:7: ( ^( MARKUP IDCON . . ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:220:11: ^( MARKUP IDCON . . )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            MARKUP4=(CommonTree)match(input,MARKUP,FOLLOW_MARKUP_in_markup99); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MARKUP4_tree = (CommonTree)adaptor.dupNode(MARKUP4);

            root_1 = (CommonTree)adaptor.becomeRoot(MARKUP4_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            IDCON5=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_markup101); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON5_tree = (CommonTree)adaptor.dupNode(IDCON5);

            adaptor.addChild(root_1, IDCON5_tree);
            }
            _last = (CommonTree)input.LT(1);
            wildcard6=(CommonTree)input.LT(1);
            matchAny(input); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            wildcard6_tree = (CommonTree)adaptor.dupTree(wildcard6);
            adaptor.addChild(root_1, wildcard6_tree);
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

              				if(! interpretFunction(IDCON5.getText())) {
              					addContent(new Element(IDCON5.getText())); 
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:226:1: attributes : ^( ATTRIBUTES ( attribute )* ) ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:226:11: ( ^( ATTRIBUTES ( attribute )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:226:14: ^( ATTRIBUTES ( attribute )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            ATTRIBUTES8=(CommonTree)match(input,ATTRIBUTES,FOLLOW_ATTRIBUTES_in_attributes123); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ATTRIBUTES8_tree = (CommonTree)adaptor.dupNode(ATTRIBUTES8);

            root_1 = (CommonTree)adaptor.becomeRoot(ATTRIBUTES8_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:226:28: ( attribute )*
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
                	    pushFollow(FOLLOW_attribute_in_attributes125);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:228:1: attribute : ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' w= NATCON ( '%' h= NATCON )? );
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:228:10: ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' w= NATCON ( '%' h= NATCON )? )
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:228:13: '#' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal10=(CommonTree)match(input,43,FOLLOW_43_in_attribute137); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal10_tree = (CommonTree)adaptor.dupNode(char_literal10);

                    adaptor.addChild(root_0, char_literal10_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON11=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute139); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:229:6: '.' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal12=(CommonTree)match(input,40,FOLLOW_40_in_attribute148); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal12_tree = (CommonTree)adaptor.dupNode(char_literal12);

                    adaptor.addChild(root_0, char_literal12_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON13=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute150); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:230:6: '$' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal14=(CommonTree)match(input,44,FOLLOW_44_in_attribute159); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal14_tree = (CommonTree)adaptor.dupNode(char_literal14);

                    adaptor.addChild(root_0, char_literal14_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON15=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute161); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:231:6: ':' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal16=(CommonTree)match(input,42,FOLLOW_42_in_attribute170); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal16_tree = (CommonTree)adaptor.dupNode(char_literal16);

                    adaptor.addChild(root_0, char_literal16_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON17=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute172); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:232:6: '@' w= NATCON ( '%' h= NATCON )?
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal18=(CommonTree)match(input,45,FOLLOW_45_in_attribute181); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal18_tree = (CommonTree)adaptor.dupNode(char_literal18);

                    adaptor.addChild(root_0, char_literal18_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    w=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_attribute185); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    w_tree = (CommonTree)adaptor.dupNode(w);

                    adaptor.addChild(root_0, w_tree);
                    }
                    if ( state.backtracking==0 ) {
                       current.setAttribute("width", w.getText()); 
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:233:5: ( '%' h= NATCON )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==46) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:233:7: '%' h= NATCON
                            {
                            _last = (CommonTree)input.LT(1);
                            char_literal19=(CommonTree)match(input,46,FOLLOW_46_in_attribute195); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal19_tree = (CommonTree)adaptor.dupNode(char_literal19);

                            adaptor.addChild(root_0, char_literal19_tree);
                            }
                            _last = (CommonTree)input.LT(1);
                            h=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_attribute199); if (state.failed) return retval;
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arguments"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:235:1: arguments : ^( ARGUMENTS ( argument )* ) ;
    public final WaebricInterpreter.arguments_return arguments() throws RecognitionException {
        WaebricInterpreter.arguments_return retval = new WaebricInterpreter.arguments_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ARGUMENTS20=null;
        WaebricInterpreter.argument_return argument21 = null;


        CommonTree ARGUMENTS20_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:235:10: ( ^( ARGUMENTS ( argument )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:235:13: ^( ARGUMENTS ( argument )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            ARGUMENTS20=(CommonTree)match(input,ARGUMENTS,FOLLOW_ARGUMENTS_in_arguments217); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ARGUMENTS20_tree = (CommonTree)adaptor.dupNode(ARGUMENTS20);

            root_1 = (CommonTree)adaptor.becomeRoot(ARGUMENTS20_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:235:26: ( argument )*
                loop4:
                do {
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==IDCON||(LA4_0>=NATCON && LA4_0<=SYMBOLCON)||LA4_0==51||LA4_0==53) ) {
                        alt4=1;
                    }


                    switch (alt4) {
                	case 1 :
                	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: argument
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_argument_in_arguments219);
                	    argument21=argument();

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:237:1: argument : ( expression | IDCON '=' expression );
    public final WaebricInterpreter.argument_return argument() throws RecognitionException {
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:237:9: ( expression | IDCON '=' expression )
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:237:12: expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_argument231);
                    expression22=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression22.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:238:6: IDCON '=' expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDCON23=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_argument238); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON23_tree = (CommonTree)adaptor.dupNode(IDCON23);

                    adaptor.addChild(root_0, IDCON23_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal24=(CommonTree)match(input,50,FOLLOW_50_in_argument240); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal24_tree = (CommonTree)adaptor.dupNode(char_literal24);

                    adaptor.addChild(root_0, char_literal24_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_argument242);
                    expression25=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression25.getTree());
                    if ( state.backtracking==0 ) {
                       current.setAttribute(IDCON23.getText(), (expression25!=null?expression25.eval:null)); 
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:243:1: expression returns [\n\t\tint index; // Used for interpreting a referenced variable\n\t\tString eval = \"undef\", // Evaluation value for printing\n\t\tMap<String, expression_return> map = new HashMap<String, expression_return>(), // Map structure for fields\n\t\tCollection<expression_return> collection = new ArrayList() // List structure for iterations\n\t] : (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (id= IDCON ':' e= expression )? ( ',' id= IDCON ':' e= expression )* '}' ) ( '+' e= expression | '.' id= IDCON )* ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:249:2: ( (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (id= IDCON ':' e= expression )? ( ',' id= IDCON ':' e= expression )* '}' ) ( '+' e= expression | '.' id= IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:250:4: (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (id= IDCON ':' e= expression )? ( ',' id= IDCON ':' e= expression )* '}' ) ( '+' e= expression | '.' id= IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:250:4: (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (id= IDCON ':' e= expression )? ( ',' id= IDCON ':' e= expression )* '}' )
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:250:6: var= IDCON
                    {
                    _last = (CommonTree)input.LT(1);
                    var=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression275); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:260:6: NATCON
                    {
                    _last = (CommonTree)input.LT(1);
                    NATCON26=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_expression284); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:261:6: TEXT
                    {
                    _last = (CommonTree)input.LT(1);
                    TEXT27=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_expression293); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:262:6: SYMBOLCON
                    {
                    _last = (CommonTree)input.LT(1);
                    SYMBOLCON28=(CommonTree)match(input,SYMBOLCON,FOLLOW_SYMBOLCON_in_expression302); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:263:6: '[' (e= expression )? ( ',' e= expression )* ']'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal29=(CommonTree)match(input,51,FOLLOW_51_in_expression311); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal29_tree = (CommonTree)adaptor.dupNode(char_literal29);

                    adaptor.addChild(root_0, char_literal29_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:263:10: (e= expression )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==IDCON||(LA6_0>=NATCON && LA6_0<=SYMBOLCON)||LA6_0==51||LA6_0==53) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:263:12: e= expression
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_expression_in_expression317);
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

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:264:6: ( ',' e= expression )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==48) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:264:8: ',' e= expression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal30=(CommonTree)match(input,48,FOLLOW_48_in_expression332); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal30_tree = (CommonTree)adaptor.dupNode(char_literal30);

                    	    adaptor.addChild(root_0, char_literal30_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_expression_in_expression336);
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
                    char_literal31=(CommonTree)match(input,52,FOLLOW_52_in_expression343); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal31_tree = (CommonTree)adaptor.dupNode(char_literal31);

                    adaptor.addChild(root_0, char_literal31_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			  		// List
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:271:6: '{' (id= IDCON ':' e= expression )? ( ',' id= IDCON ':' e= expression )* '}'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal32=(CommonTree)match(input,53,FOLLOW_53_in_expression352); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal32_tree = (CommonTree)adaptor.dupNode(char_literal32);

                    adaptor.addChild(root_0, char_literal32_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:271:10: (id= IDCON ':' e= expression )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==IDCON) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:271:12: id= IDCON ':' e= expression
                            {
                            _last = (CommonTree)input.LT(1);
                            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression358); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            id_tree = (CommonTree)adaptor.dupNode(id);

                            adaptor.addChild(root_0, id_tree);
                            }
                            _last = (CommonTree)input.LT(1);
                            char_literal33=(CommonTree)match(input,42,FOLLOW_42_in_expression360); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal33_tree = (CommonTree)adaptor.dupNode(char_literal33);

                            adaptor.addChild(root_0, char_literal33_tree);
                            }
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_expression_in_expression364);
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

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:272:6: ( ',' id= IDCON ':' e= expression )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==48) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:272:8: ',' id= IDCON ':' e= expression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal34=(CommonTree)match(input,48,FOLLOW_48_in_expression379); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal34_tree = (CommonTree)adaptor.dupNode(char_literal34);

                    	    adaptor.addChild(root_0, char_literal34_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression383); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    id_tree = (CommonTree)adaptor.dupNode(id);

                    	    adaptor.addChild(root_0, id_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal35=(CommonTree)match(input,42,FOLLOW_42_in_expression385); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal35_tree = (CommonTree)adaptor.dupNode(char_literal35);

                    	    adaptor.addChild(root_0, char_literal35_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_expression_in_expression389);
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
                    char_literal36=(CommonTree)match(input,54,FOLLOW_54_in_expression396); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal36_tree = (CommonTree)adaptor.dupNode(char_literal36);

                    adaptor.addChild(root_0, char_literal36_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			  		// Record
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

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:283:4: ( '+' e= expression | '.' id= IDCON )*
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
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:283:6: '+' e= expression
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal37=(CommonTree)match(input,55,FOLLOW_55_in_expression419); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal37_tree = (CommonTree)adaptor.dupNode(char_literal37);

            	    adaptor.addChild(root_0, char_literal37_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expression_in_expression423);
            	    e=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, e.getTree());
            	    if ( state.backtracking==0 ) {

            	      					// Cat
            	      					retval.eval += (e!=null?e.eval:null);
            	      					retval.collection.clear();
            	      					retval.map.clear();
            	      				
            	    }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:289:6: '.' id= IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal38=(CommonTree)match(input,40,FOLLOW_40_in_expression433); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal38_tree = (CommonTree)adaptor.dupNode(char_literal38);

            	    adaptor.addChild(root_0, char_literal38_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression437); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    id_tree = (CommonTree)adaptor.dupNode(id);

            	    adaptor.addChild(root_0, id_tree);
            	    }
            	    if ( state.backtracking==0 ) {

            	      					// Field
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:303:1: function : ^( FUNCTION IDCON formals ( statement )* ) ;
    public final WaebricInterpreter.function_return function() throws RecognitionException {
        WaebricInterpreter.function_return retval = new WaebricInterpreter.function_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNCTION39=null;
        CommonTree IDCON40=null;
        WaebricInterpreter.formals_return formals41 = null;

        WaebricInterpreter.statement_return statement42 = null;


        CommonTree FUNCTION39_tree=null;
        CommonTree IDCON40_tree=null;

         Element actual = null; 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:305:2: ( ^( FUNCTION IDCON formals ( statement )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:305:5: ^( FUNCTION IDCON formals ( statement )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNCTION39=(CommonTree)match(input,FUNCTION,FOLLOW_FUNCTION_in_function468); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FUNCTION39_tree = (CommonTree)adaptor.dupNode(FUNCTION39);

            root_1 = (CommonTree)adaptor.becomeRoot(FUNCTION39_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            IDCON40=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_function470); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON40_tree = (CommonTree)adaptor.dupNode(IDCON40);

            adaptor.addChild(root_1, IDCON40_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_formals_in_function477);
            formals41=formals();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, formals41.getTree());
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:307:5: ( statement )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==MARKUP_STATEMENT||LA12_0==COMMENT||LA12_0==53||LA12_0==56||(LA12_0>=58 && LA12_0<=59)||(LA12_0>=61 && LA12_0<=63)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:307:7: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_function486);
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
            	    break loop12;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:313:1: formals : ^( FORMALS ( IDCON )* ) ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:313:8: ( ^( FORMALS ( IDCON )* ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:313:11: ^( FORMALS ( IDCON )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FORMALS43=(CommonTree)match(input,FORMALS,FOLLOW_FORMALS_in_formals508); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FORMALS43_tree = (CommonTree)adaptor.dupNode(FORMALS43);

            root_1 = (CommonTree)adaptor.becomeRoot(FORMALS43_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:313:22: ( IDCON )*
                loop13:
                do {
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==IDCON) ) {
                        alt13=1;
                    }


                    switch (alt13) {
                	case 1 :
                	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: IDCON
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    IDCON44=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_formals510); if (state.failed) return retval;
                	    if ( state.backtracking==0 ) {
                	    IDCON44_tree = (CommonTree)adaptor.dupNode(IDCON44);

                	    adaptor.addChild(root_1, IDCON44_tree);
                	    }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop13;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:319:1: statement : ( ifStatement | eachStatement | letStatement | blockStatement | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) | ^( MARKUP_STATEMENT ( markup )+ ';' ) | ^( MARKUP_STATEMENT ( markup )+ statement ) );
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:319:10: ( ifStatement | eachStatement | letStatement | blockStatement | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) | ^( MARKUP_STATEMENT ( markup )+ ';' ) | ^( MARKUP_STATEMENT ( markup )+ statement ) )
            int alt18=13;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:319:13: ifStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_ifStatement_in_statement526);
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:320:6: eachStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_eachStatement_in_statement533);
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:321:6: letStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_letStatement_in_statement540);
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:322:6: blockStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_blockStatement_in_statement547);
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:323:6: ^( 'comment' STRCON ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal49=(CommonTree)match(input,COMMENT,FOLLOW_COMMENT_in_statement556); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal49_tree = (CommonTree)adaptor.dupNode(string_literal49);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal49_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    STRCON50=(CommonTree)match(input,STRCON,FOLLOW_STRCON_in_statement558); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRCON50_tree = (CommonTree)adaptor.dupNode(STRCON50);

                    adaptor.addChild(root_1, STRCON50_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal51=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement560); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:324:6: ^( 'echo' expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal52=(CommonTree)match(input,61,FOLLOW_61_in_statement573); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal52_tree = (CommonTree)adaptor.dupNode(string_literal52);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal52_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement575);
                    expression53=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression53.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal54=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement577); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:325:6: ^( 'echo' embedding ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal55=(CommonTree)match(input,61,FOLLOW_61_in_statement590); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal55_tree = (CommonTree)adaptor.dupNode(string_literal55);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal55_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement592);
                    embedding56=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding56.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal57=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement594); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:326:6: ^( 'cdata' expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal58=(CommonTree)match(input,62,FOLLOW_62_in_statement605); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal58_tree = (CommonTree)adaptor.dupNode(string_literal58);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal58_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement607);
                    expression59=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression59.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal60=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement609); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:327:6: 'yield;'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal61=(CommonTree)match(input,63,FOLLOW_63_in_statement620); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal61_tree = (CommonTree)adaptor.dupNode(string_literal61);

                    adaptor.addChild(root_0, string_literal61_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:328:6: ^( MARKUP_STATEMENT ( markup )+ expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT62=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement629); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT62_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT62);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT62_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:328:26: ( markup )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==MARKUP) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement631);
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
                    	    if ( cnt14 >= 1 ) break loop14;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(14, input);
                                throw eee;
                        }
                        cnt14++;
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement634);
                    expression64=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression64.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal65=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement636); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:329:6: ^( MARKUP_STATEMENT ( markup )+ embedding ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT66=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement649); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT66_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT66);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT66_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:329:26: ( markup )+
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
                    	    pushFollow(FOLLOW_markup_in_statement651);
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
                    	    if ( cnt15 >= 1 ) break loop15;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement654);
                    embedding68=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding68.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal69=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement656); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:330:6: ^( MARKUP_STATEMENT ( markup )+ ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT70=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement667); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT70_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT70);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT70_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:330:26: ( markup )+
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
                    	    pushFollow(FOLLOW_markup_in_statement669);
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
                    	    if ( cnt16 >= 1 ) break loop16;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(16, input);
                                throw eee;
                        }
                        cnt16++;
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal72=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement672); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:331:6: ^( MARKUP_STATEMENT ( markup )+ statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT73=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement684); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT73_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT73);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT73_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:331:26: ( markup )+
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
                    	    pushFollow(FOLLOW_markup_in_statement686);
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
                    	    if ( cnt17 >= 1 ) break loop17;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(17, input);
                                throw eee;
                        }
                        cnt17++;
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement689);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:333:1: ifStatement : ^( 'if' '(' predicate ')' t= . ( 'else' f= . )? ) ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:335:2: ( ^( 'if' '(' predicate ')' t= . ( 'else' f= . )? ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:335:5: ^( 'if' '(' predicate ')' t= . ( 'else' f= . )? )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal76=(CommonTree)match(input,56,FOLLOW_56_in_ifStatement709); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal76_tree = (CommonTree)adaptor.dupNode(string_literal76);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal76_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            char_literal77=(CommonTree)match(input,47,FOLLOW_47_in_ifStatement711); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal77_tree = (CommonTree)adaptor.dupNode(char_literal77);

            adaptor.addChild(root_1, char_literal77_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_predicate_in_ifStatement713);
            predicate78=predicate();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, predicate78.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal79=(CommonTree)match(input,49,FOLLOW_49_in_ifStatement715); if (state.failed) return retval;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:335:60: ( 'else' f= . )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==57) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:335:62: 'else' f= .
                    {
                    _last = (CommonTree)input.LT(1);
                    string_literal80=(CommonTree)match(input,57,FOLLOW_57_in_ifStatement726); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:348:1: eachStatement : ^( 'each' '(' IDCON ':' e= expression ')' . ) ;
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
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, CommonTree>();
        		int stm = 0;
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:354:4: ( ^( 'each' '(' IDCON ':' e= expression ')' . ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:354:7: ^( 'each' '(' IDCON ':' e= expression ')' . )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal81=(CommonTree)match(input,58,FOLLOW_58_in_eachStatement766); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal81_tree = (CommonTree)adaptor.dupNode(string_literal81);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal81_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            char_literal82=(CommonTree)match(input,47,FOLLOW_47_in_eachStatement768); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal82_tree = (CommonTree)adaptor.dupNode(char_literal82);

            adaptor.addChild(root_1, char_literal82_tree);
            }
            _last = (CommonTree)input.LT(1);
            IDCON83=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_eachStatement770); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON83_tree = (CommonTree)adaptor.dupNode(IDCON83);

            adaptor.addChild(root_1, IDCON83_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal84=(CommonTree)match(input,42,FOLLOW_42_in_eachStatement772); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal84_tree = (CommonTree)adaptor.dupNode(char_literal84);

            adaptor.addChild(root_1, char_literal84_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_eachStatement776);
            e=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, e.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal85=(CommonTree)match(input,49,FOLLOW_49_in_eachStatement778); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:367:1: blockStatement : ^( '{' ( statement )* '}' ) ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:369:2: ( ^( '{' ( statement )* '}' ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:369:5: ^( '{' ( statement )* '}' )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            char_literal87=(CommonTree)match(input,53,FOLLOW_53_in_blockStatement804); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal87_tree = (CommonTree)adaptor.dupNode(char_literal87);

            root_1 = (CommonTree)adaptor.becomeRoot(char_literal87_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:369:12: ( statement )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==MARKUP_STATEMENT||LA20_0==COMMENT||LA20_0==53||LA20_0==56||(LA20_0>=58 && LA20_0<=59)||(LA20_0>=61 && LA20_0<=63)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:369:14: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_blockStatement808);
            	    statement88=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, statement88.getTree());
            	    if ( state.backtracking==0 ) {
            	       this.current = actual; 
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
            char_literal89=(CommonTree)match(input,54,FOLLOW_54_in_blockStatement815); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:371:1: letStatement : ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) ;
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
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, CommonTree>();
        		Element actual = this.current;
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:377:4: ( ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:377:7: ^( 'let' ( assignment )+ 'in' ( statement )* 'end' )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal90=(CommonTree)match(input,59,FOLLOW_59_in_letStatement843); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal90_tree = (CommonTree)adaptor.dupNode(string_literal90);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal90_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:377:16: ( assignment )+
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
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: assignment
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_assignment_in_letStatement845);
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
            	    if ( cnt21 >= 1 ) break loop21;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);

            _last = (CommonTree)input.LT(1);
            string_literal92=(CommonTree)match(input,60,FOLLOW_60_in_letStatement848); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal92_tree = (CommonTree)adaptor.dupNode(string_literal92);

            adaptor.addChild(root_1, string_literal92_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:378:4: ( statement )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==MARKUP_STATEMENT||LA22_0==COMMENT||LA22_0==53||LA22_0==56||(LA22_0>=58 && LA22_0<=59)||(LA22_0>=61 && LA22_0<=63)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:378:6: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_letStatement856);
            	    statement93=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, statement93.getTree());
            	    if ( state.backtracking==0 ) {
            	       this.current = actual; 
            	    }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            string_literal94=(CommonTree)match(input,END,FOLLOW_END_in_letStatement867); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:384:1: assignment : ( varBinding | funcBinding );
    public final WaebricInterpreter.assignment_return assignment() throws RecognitionException {
        WaebricInterpreter.assignment_return retval = new WaebricInterpreter.assignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricInterpreter.varBinding_return varBinding95 = null;

        WaebricInterpreter.funcBinding_return funcBinding96 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:384:11: ( varBinding | funcBinding )
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:384:14: varBinding
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_varBinding_in_assignment881);
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:384:27: funcBinding
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_funcBinding_in_assignment885);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:386:1: varBinding : IDCON '=' expression ';' ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:388:2: ( IDCON '=' expression ';' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:388:5: IDCON '=' expression ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON97=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_varBinding903); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON97_tree = (CommonTree)adaptor.dupNode(IDCON97);

            adaptor.addChild(root_0, IDCON97_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal98=(CommonTree)match(input,50,FOLLOW_50_in_varBinding905); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal98_tree = (CommonTree)adaptor.dupNode(char_literal98);

            adaptor.addChild(root_0, char_literal98_tree);
            }
            if ( state.backtracking==0 ) {
               index = input.index(); 
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_varBinding909);
            expression99=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, expression99.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal100=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_varBinding911); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:392:1: funcBinding : ^( FUNCTION id= IDCON formals stm= . ) ;
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

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:392:13: ( ^( FUNCTION id= IDCON formals stm= . ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:392:16: ^( FUNCTION id= IDCON formals stm= . )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            FUNCTION101=(CommonTree)match(input,FUNCTION,FOLLOW_FUNCTION_in_funcBinding928); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FUNCTION101_tree = (CommonTree)adaptor.dupNode(FUNCTION101);

            root_1 = (CommonTree)adaptor.becomeRoot(FUNCTION101_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_funcBinding932); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (CommonTree)adaptor.dupNode(id);

            adaptor.addChild(root_1, id_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_formals_in_funcBinding934);
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

            		defineFunction(id.getText(), ((CommonTree)retval.tree));
            	
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:400:1: predicate returns [boolean eval] : ( '!' p= predicate | e= expression | e= expression '.' type ) ( '&&' p= predicate | '||' p= predicate )* ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:401:2: ( ( '!' p= predicate | e= expression | e= expression '.' type ) ( '&&' p= predicate | '||' p= predicate )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:401:5: ( '!' p= predicate | e= expression | e= expression '.' type ) ( '&&' p= predicate | '||' p= predicate )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:401:5: ( '!' p= predicate | e= expression | e= expression '.' type )
            int alt24=3;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:401:7: '!' p= predicate
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal103=(CommonTree)match(input,64,FOLLOW_64_in_predicate965); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal103_tree = (CommonTree)adaptor.dupNode(char_literal103);

                    adaptor.addChild(root_0, char_literal103_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_predicate969);
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:402:7: e= expression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate981);
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:403:7: e= expression '.' type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate994);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, e.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal104=(CommonTree)match(input,40,FOLLOW_40_in_predicate996); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal104_tree = (CommonTree)adaptor.dupNode(char_literal104);

                    adaptor.addChild(root_0, char_literal104_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_predicate998);
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

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:404:6: ( '&&' p= predicate | '||' p= predicate )*
            loop25:
            do {
                int alt25=3;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==65) ) {
                    int LA25_2 = input.LA(2);

                    if ( (synpred45_WaebricInterpreter()) ) {
                        alt25=1;
                    }


                }
                else if ( (LA25_0==66) ) {
                    int LA25_3 = input.LA(2);

                    if ( (synpred46_WaebricInterpreter()) ) {
                        alt25=2;
                    }


                }


                switch (alt25) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:404:8: '&&' p= predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal106=(CommonTree)match(input,65,FOLLOW_65_in_predicate1008); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal106_tree = (CommonTree)adaptor.dupNode(string_literal106);

            	    adaptor.addChild(root_0, string_literal106_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate1012);
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
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:404:57: '||' p= predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal107=(CommonTree)match(input,66,FOLLOW_66_in_predicate1018); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal107_tree = (CommonTree)adaptor.dupNode(string_literal107);

            	    adaptor.addChild(root_0, string_literal107_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate1022);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:406:1: type : ( 'list' | 'record' | 'string' );
    public final WaebricInterpreter.type_return type() throws RecognitionException {
        WaebricInterpreter.type_return retval = new WaebricInterpreter.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set108=null;

        CommonTree set108_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:406:5: ( 'list' | 'record' | 'string' )
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:411:1: embedding : PRETEXT embed textTail ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:411:10: ( PRETEXT embed textTail )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:411:13: PRETEXT embed textTail
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PRETEXT109=(CommonTree)match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding1060); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRETEXT109_tree = (CommonTree)adaptor.dupNode(PRETEXT109);

            adaptor.addChild(root_0, PRETEXT109_tree);
            }
            if ( state.backtracking==0 ) {
               addContent(new Text(PRETEXT109.getText())); 
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_embed_in_embedding1064);
            embed110=embed();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, embed110.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_textTail_in_embedding1066);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:413:1: embed : ( ( markup )* expression | ( markup )+ );
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:413:6: ( ( markup )* expression | ( markup )+ )
            int alt28=2;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:413:10: ( markup )* expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:413:10: ( markup )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==MARKUP) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed1076);
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
                    	    break loop26;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_embed1079);
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:414:6: ( markup )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:414:6: ( markup )+
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
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed1089);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:416:1: textTail : ( POSTTEXT | MIDTEXT embed textTail );
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:416:9: ( POSTTEXT | MIDTEXT embed textTail )
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:416:12: POSTTEXT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    POSTTEXT115=(CommonTree)match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail1099); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:417:6: MIDTEXT embed textTail
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    MIDTEXT116=(CommonTree)match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail1108); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MIDTEXT116_tree = (CommonTree)adaptor.dupNode(MIDTEXT116);

                    adaptor.addChild(root_0, MIDTEXT116_tree);
                    }
                    if ( state.backtracking==0 ) {
                       addContent(new Text(MIDTEXT116.getText())); 
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embed_in_textTail1112);
                    embed117=embed();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, embed117.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_textTail_in_textTail1114);
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


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:283:6: ( '+' e= expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:283:6: '+' e= expression
        {
        match(input,55,FOLLOW_55_in_synpred18_WaebricInterpreter419); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred18_WaebricInterpreter423);
        e=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_WaebricInterpreter

    // $ANTLR start synpred19_WaebricInterpreter
    public final void synpred19_WaebricInterpreter_fragment() throws RecognitionException {   
        CommonTree id=null;

        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:289:6: ( '.' id= IDCON )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:289:6: '.' id= IDCON
        {
        match(input,40,FOLLOW_40_in_synpred19_WaebricInterpreter433); if (state.failed) return ;
        id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_synpred19_WaebricInterpreter437); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_WaebricInterpreter

    // $ANTLR start synpred44_WaebricInterpreter
    public final void synpred44_WaebricInterpreter_fragment() throws RecognitionException {   
        WaebricInterpreter.expression_return e = null;


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:402:7: (e= expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:402:7: e= expression
        {
        pushFollow(FOLLOW_expression_in_synpred44_WaebricInterpreter981);
        e=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred44_WaebricInterpreter

    // $ANTLR start synpred45_WaebricInterpreter
    public final void synpred45_WaebricInterpreter_fragment() throws RecognitionException {   
        WaebricInterpreter.predicate_return p = null;


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:404:8: ( '&&' p= predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:404:8: '&&' p= predicate
        {
        match(input,65,FOLLOW_65_in_synpred45_WaebricInterpreter1008); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred45_WaebricInterpreter1012);
        p=predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred45_WaebricInterpreter

    // $ANTLR start synpred46_WaebricInterpreter
    public final void synpred46_WaebricInterpreter_fragment() throws RecognitionException {   
        WaebricInterpreter.predicate_return p = null;


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:404:57: ( '||' p= predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:404:57: '||' p= predicate
        {
        match(input,66,FOLLOW_66_in_synpred46_WaebricInterpreter1018); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred46_WaebricInterpreter1022);
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


    protected DFA18 dfa18 = new DFA18(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA28 dfa28 = new DFA28(this);
    static final String DFA18_eotS =
        "\37\uffff";
    static final String DFA18_eofS =
        "\37\uffff";
    static final String DFA18_minS =
        "\1\7\5\uffff\1\2\2\uffff\1\2\1\12\1\6\2\uffff\1\2\1\12\1\4\2\2\1"+
        "\4\1\6\1\4\1\3\1\uffff\1\2\3\uffff\1\3\1\4\1\3";
    static final String DFA18_maxS =
        "\1\77\5\uffff\1\2\2\uffff\1\2\1\65\1\6\2\uffff\1\2\1\12\2\105\1"+
        "\3\1\105\1\77\2\105\1\uffff\1\66\3\uffff\2\105\1\3";
    static final String DFA18_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\11\3\uffff\1\7\1\6\11"+
        "\uffff\1\12\1\uffff\1\14\1\15\1\13\3\uffff";
    static final String DFA18_specialS =
        "\37\uffff}>";
    static final String[] DFA18_transitionS = {
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
            "\1\16\1\32\2\uffff\1\27\1\uffff\3\27\1\uffff\1\33\2\uffff\1"+
            "\32\2\uffff\1\31\34\uffff\1\27\1\uffff\1\30\2\uffff\1\32\1\uffff"+
            "\2\32\1\uffff\3\32",
            "\102\34",
            "\1\35\102\26",
            "",
            "\1\32\7\uffff\1\27\45\uffff\1\27\5\uffff\1\27",
            "",
            "",
            "",
            "\1\36\102\34",
            "\102\22",
            "\1\24"
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "319:1: statement : ( ifStatement | eachStatement | letStatement | blockStatement | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) | ^( MARKUP_STATEMENT ( markup )+ ';' ) | ^( MARKUP_STATEMENT ( markup )+ statement ) );";
        }
    }
    static final String DFA24_eotS =
        "\12\uffff";
    static final String DFA24_eofS =
        "\12\uffff";
    static final String DFA24_minS =
        "\1\12\1\uffff\6\0\2\uffff";
    static final String DFA24_maxS =
        "\1\100\1\uffff\6\0\2\uffff";
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
            return "401:5: ( '!' p= predicate | e= expression | e= expression '.' type )";
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
                        if ( (synpred44_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index24_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA24_3 = input.LA(1);

                         
                        int index24_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred44_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index24_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA24_4 = input.LA(1);

                         
                        int index24_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred44_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index24_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA24_5 = input.LA(1);

                         
                        int index24_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred44_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index24_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA24_6 = input.LA(1);

                         
                        int index24_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred44_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index24_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA24_7 = input.LA(1);

                         
                        int index24_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred44_WaebricInterpreter()) ) {s = 8;}

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
    static final String DFA28_eotS =
        "\17\uffff";
    static final String DFA28_eofS =
        "\17\uffff";
    static final String DFA28_minS =
        "\1\6\1\2\1\uffff\1\12\1\4\1\2\1\4\1\2\1\3\1\6\2\4\1\uffff\2\3";
    static final String DFA28_maxS =
        "\1\65\1\2\1\uffff\1\12\3\105\1\3\1\105\1\65\2\105\1\uffff\1\105"+
        "\1\3";
    static final String DFA28_acceptS =
        "\2\uffff\1\1\11\uffff\1\2\2\uffff";
    static final String DFA28_specialS =
        "\17\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\1\3\uffff\1\2\1\uffff\3\2\44\uffff\1\2\1\uffff\1\2",
            "\1\3",
            "",
            "\1\4",
            "\102\5",
            "\1\6\1\uffff\102\7",
            "\102\10",
            "\1\12\1\11",
            "\1\13\102\10",
            "\1\1\3\uffff\1\2\1\uffff\3\2\2\uffff\2\14\40\uffff\1\2\1\uffff"+
            "\1\2",
            "\102\15",
            "\102\7",
            "",
            "\1\16\102\15",
            "\1\11"
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
            return "413:1: embed : ( ( markup )* expression | ( markup )+ );";
        }
    }
 

    public static final BitSet FOLLOW_PATH_in_mapping78 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_mapping80 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_markup_in_mapping82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUP_in_markup99 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_markup101 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000000000003FL});
    public static final BitSet FOLLOW_ATTRIBUTES_in_attributes123 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attribute_in_attributes125 = new BitSet(new long[]{0x00003D0000000008L});
    public static final BitSet FOLLOW_43_in_attribute137 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_attribute139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_attribute148 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_attribute150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_attribute159 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_attribute161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_attribute170 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_attribute172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_attribute181 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_NATCON_in_attribute185 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_46_in_attribute195 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_NATCON_in_attribute199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARGUMENTS_in_arguments217 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_argument_in_arguments219 = new BitSet(new long[]{0x0028000000007408L});
    public static final BitSet FOLLOW_expression_in_argument231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_argument238 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_argument240 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_argument242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_expression275 = new BitSet(new long[]{0x0080010000000002L});
    public static final BitSet FOLLOW_NATCON_in_expression284 = new BitSet(new long[]{0x0080010000000002L});
    public static final BitSet FOLLOW_TEXT_in_expression293 = new BitSet(new long[]{0x0080010000000002L});
    public static final BitSet FOLLOW_SYMBOLCON_in_expression302 = new BitSet(new long[]{0x0080010000000002L});
    public static final BitSet FOLLOW_51_in_expression311 = new BitSet(new long[]{0x0039000000007400L});
    public static final BitSet FOLLOW_expression_in_expression317 = new BitSet(new long[]{0x0011000000000000L});
    public static final BitSet FOLLOW_48_in_expression332 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_expression336 = new BitSet(new long[]{0x0011000000000000L});
    public static final BitSet FOLLOW_52_in_expression343 = new BitSet(new long[]{0x0080010000000002L});
    public static final BitSet FOLLOW_53_in_expression352 = new BitSet(new long[]{0x0041000000000400L});
    public static final BitSet FOLLOW_IDCON_in_expression358 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_expression360 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_expression364 = new BitSet(new long[]{0x0041000000000000L});
    public static final BitSet FOLLOW_48_in_expression379 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_expression383 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_expression385 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_expression389 = new BitSet(new long[]{0x0041000000000000L});
    public static final BitSet FOLLOW_54_in_expression396 = new BitSet(new long[]{0x0080010000000002L});
    public static final BitSet FOLLOW_55_in_expression419 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_expression423 = new BitSet(new long[]{0x0080010000000002L});
    public static final BitSet FOLLOW_40_in_expression433 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_expression437 = new BitSet(new long[]{0x0080010000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_function468 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_function470 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_formals_in_function477 = new BitSet(new long[]{0xED20000000080088L});
    public static final BitSet FOLLOW_statement_in_function486 = new BitSet(new long[]{0xED20000000080088L});
    public static final BitSet FOLLOW_FORMALS_in_formals508 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_formals510 = new BitSet(new long[]{0x0000000000000408L});
    public static final BitSet FOLLOW_ifStatement_in_statement526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_eachStatement_in_statement533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_letStatement_in_statement540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blockStatement_in_statement547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMENT_in_statement556 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRCON_in_statement558 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement560 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_61_in_statement573 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement575 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement577 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_61_in_statement590 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_statement592 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement594 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_62_in_statement605 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement607 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement609 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_63_in_statement620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement629 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement631 = new BitSet(new long[]{0x0028000000007440L});
    public static final BitSet FOLLOW_expression_in_statement634 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement636 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement649 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement651 = new BitSet(new long[]{0x0000000000010040L});
    public static final BitSet FOLLOW_embedding_in_statement654 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement656 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement667 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement669 = new BitSet(new long[]{0x0000000000400040L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement672 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement684 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement686 = new BitSet(new long[]{0xED200000000800C0L});
    public static final BitSet FOLLOW_statement_in_statement689 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_56_in_ifStatement709 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_47_in_ifStatement711 = new BitSet(new long[]{0x0028000000007400L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_ifStatement713 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ifStatement715 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000000000003FL});
    public static final BitSet FOLLOW_57_in_ifStatement726 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000000000003FL});
    public static final BitSet FOLLOW_58_in_eachStatement766 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_47_in_eachStatement768 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_eachStatement770 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_eachStatement772 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_eachStatement776 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_eachStatement778 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000000000003FL});
    public static final BitSet FOLLOW_53_in_blockStatement804 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_blockStatement808 = new BitSet(new long[]{0xED60000000080080L});
    public static final BitSet FOLLOW_54_in_blockStatement815 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_59_in_letStatement843 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_assignment_in_letStatement845 = new BitSet(new long[]{0x1000000000000600L});
    public static final BitSet FOLLOW_60_in_letStatement848 = new BitSet(new long[]{0xED20000000280080L});
    public static final BitSet FOLLOW_statement_in_letStatement856 = new BitSet(new long[]{0xED20000000280080L});
    public static final BitSet FOLLOW_END_in_letStatement867 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_varBinding_in_assignment881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funcBinding_in_assignment885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_varBinding903 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_varBinding905 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_varBinding909 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMICOLON_in_varBinding911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_funcBinding928 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDCON_in_funcBinding932 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_formals_in_funcBinding934 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000000000003FL});
    public static final BitSet FOLLOW_64_in_predicate965 = new BitSet(new long[]{0x0028000000007400L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_predicate969 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000006L});
    public static final BitSet FOLLOW_expression_in_predicate981 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000006L});
    public static final BitSet FOLLOW_expression_in_predicate994 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_predicate996 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000038L});
    public static final BitSet FOLLOW_type_in_predicate998 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000006L});
    public static final BitSet FOLLOW_65_in_predicate1008 = new BitSet(new long[]{0x0028000000007400L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_predicate1012 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000006L});
    public static final BitSet FOLLOW_66_in_predicate1018 = new BitSet(new long[]{0x0028000000007400L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_predicate1022 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000006L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding1060 = new BitSet(new long[]{0x0028000000007440L});
    public static final BitSet FOLLOW_embed_in_embedding1064 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_textTail_in_embedding1066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed1076 = new BitSet(new long[]{0x0028000000007440L});
    public static final BitSet FOLLOW_expression_in_embed1079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed1089 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail1099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail1108 = new BitSet(new long[]{0x0028000000007440L});
    public static final BitSet FOLLOW_embed_in_textTail1112 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_textTail_in_textTail1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_synpred18_WaebricInterpreter419 = new BitSet(new long[]{0x0028000000007400L});
    public static final BitSet FOLLOW_expression_in_synpred18_WaebricInterpreter423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_synpred19_WaebricInterpreter433 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDCON_in_synpred19_WaebricInterpreter437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred44_WaebricInterpreter981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_synpred45_WaebricInterpreter1008 = new BitSet(new long[]{0x0028000000007400L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_synpred45_WaebricInterpreter1012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_synpred46_WaebricInterpreter1018 = new BitSet(new long[]{0x0028000000007400L,0x0000000000000001L});
    public static final BitSet FOLLOW_predicate_in_synpred46_WaebricInterpreter1022 = new BitSet(new long[]{0x0000000000000002L});

}