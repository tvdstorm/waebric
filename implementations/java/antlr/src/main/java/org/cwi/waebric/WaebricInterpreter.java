// $ANTLR 3.1.2 /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g 2009-08-15 11:11:58

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "MARKUP_STATEMENT", "IDCON", "PATH", "NATCON", "TEXT", "SYMBOLCON", "STRCON", "PRETEXT", "POSTTEXT", "MIDTEXT", "COMMENT", "SITE", "END", "SEMICOLON", "LETTER", "DIGIT", "HEXADECIMAL", "PATHELEMENT", "FILEEXT", "STRCHAR", "ESCLAYOUT", "DECIMAL", "TEXTCHAR", "ESCQUOTE", "AMP", "CHARREF", "ENTREF", "SYMBOLCHAR", "COMMENTS", "LAYOUT", "'module'", "'.'", "'import'", "':'", "'#'", "'$'", "'@'", "'%'", "'('", "','", "')'", "'='", "'['", "']'", "'{'", "'}'", "'+'", "'def'", "'if'", "'else'", "'each'", "'let'", "'in'", "'echo'", "'cdata'", "'yield;'", "'!'", "'&&'", "'||'", "'list'", "'record'", "'string'"
    };
    public static final int ESCLAYOUT=24;
    public static final int T__42=42;
    public static final int END=16;
    public static final int T__57=57;
    public static final int T__51=51;
    public static final int FILEEXT=22;
    public static final int T__47=47;
    public static final int T__50=50;
    public static final int STRCHAR=23;
    public static final int T__65=65;
    public static final int SYMBOLCON=9;
    public static final int COMMENTS=32;
    public static final int IDCON=5;
    public static final int DECIMAL=25;
    public static final int HEXADECIMAL=20;
    public static final int T__39=39;
    public static final int TEXTCHAR=26;
    public static final int T__46=46;
    public static final int T__52=52;
    public static final int T__62=62;
    public static final int STRCON=10;
    public static final int T__49=49;
    public static final int AMP=28;
    public static final int T__61=61;
    public static final int POSTTEXT=12;
    public static final int T__59=59;
    public static final int DIGIT=19;
    public static final int T__48=48;
    public static final int T__54=54;
    public static final int T__34=34;
    public static final int LAYOUT=33;
    public static final int ESCQUOTE=27;
    public static final int PATHELEMENT=21;
    public static final int T__56=56;
    public static final int ENTREF=30;
    public static final int LETTER=18;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int SITE=15;
    public static final int T__58=58;
    public static final int T__64=64;
    public static final int T__44=44;
    public static final int SYMBOLCHAR=31;
    public static final int COMMENT=14;
    public static final int MARKUP_STATEMENT=4;
    public static final int T__55=55;
    public static final int T__45=45;
    public static final int CHARREF=29;
    public static final int MIDTEXT=13;
    public static final int T__63=63;
    public static final int PRETEXT=11;
    public static final int T__43=43;
    public static final int SEMICOLON=17;
    public static final int T__40=40;
    public static final int EOF=-1;
    public static final int T__53=53;
    public static final int TEXT=8;
    public static final int T__38=38;
    public static final int NATCON=7;
    public static final int T__37=37;
    public static final int T__60=60;
    public static final int T__41=41;
    public static final int PATH=6;

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
            char_literal2=(CommonTree)match(input,37,FOLLOW_37_in_mapping80); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:220:1: markup : IDCON attributes ( arguments )? ;
    public final WaebricInterpreter.markup_return markup() throws RecognitionException {
        WaebricInterpreter.markup_return retval = new WaebricInterpreter.markup_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON4=null;
        WaebricInterpreter.attributes_return attributes5 = null;

        WaebricInterpreter.arguments_return arguments6 = null;


        CommonTree IDCON4_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:220:7: ( IDCON attributes ( arguments )? )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:220:11: IDCON attributes ( arguments )?
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON4=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_markup97); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON4_tree = (CommonTree)adaptor.dupNode(IDCON4);

            adaptor.addChild(root_0, IDCON4_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_attributes_in_markup99);
            attributes5=attributes();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, attributes5.getTree());
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:220:28: ( arguments )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==42) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: arguments
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_arguments_in_markup101);
                    arguments6=arguments();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, arguments6.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              				if(! interpretFunction(IDCON4.getText())) {
              					addContent(new Element(IDCON4.getText())); 
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:226:1: attributes : ( attribute )* ;
    public final WaebricInterpreter.attributes_return attributes() throws RecognitionException {
        WaebricInterpreter.attributes_return retval = new WaebricInterpreter.attributes_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricInterpreter.attribute_return attribute7 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:226:11: ( ( attribute )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:226:14: ( attribute )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:226:14: ( attribute )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==35||(LA2_0>=37 && LA2_0<=40)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: attribute
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_attribute_in_attributes116);
            	    attribute7=attribute();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, attribute7.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop2;
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
        CommonTree char_literal8=null;
        CommonTree IDCON9=null;
        CommonTree char_literal10=null;
        CommonTree IDCON11=null;
        CommonTree char_literal12=null;
        CommonTree IDCON13=null;
        CommonTree char_literal14=null;
        CommonTree IDCON15=null;
        CommonTree char_literal16=null;
        CommonTree char_literal17=null;

        CommonTree w_tree=null;
        CommonTree h_tree=null;
        CommonTree char_literal8_tree=null;
        CommonTree IDCON9_tree=null;
        CommonTree char_literal10_tree=null;
        CommonTree IDCON11_tree=null;
        CommonTree char_literal12_tree=null;
        CommonTree IDCON13_tree=null;
        CommonTree char_literal14_tree=null;
        CommonTree IDCON15_tree=null;
        CommonTree char_literal16_tree=null;
        CommonTree char_literal17_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:228:10: ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' w= NATCON ( '%' h= NATCON )? )
            int alt4=5;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt4=1;
                }
                break;
            case 35:
                {
                alt4=2;
                }
                break;
            case 39:
                {
                alt4=3;
                }
                break;
            case 37:
                {
                alt4=4;
                }
                break;
            case 40:
                {
                alt4=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:228:13: '#' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal8=(CommonTree)match(input,38,FOLLOW_38_in_attribute126); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal8_tree = (CommonTree)adaptor.dupNode(char_literal8);

                    adaptor.addChild(root_0, char_literal8_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON9=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute128); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON9_tree = (CommonTree)adaptor.dupNode(IDCON9);

                    adaptor.addChild(root_0, IDCON9_tree);
                    }
                    if ( state.backtracking==0 ) {
                       current.setAttribute("id", IDCON9.getText()); 
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
                    char_literal10=(CommonTree)match(input,35,FOLLOW_35_in_attribute138); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal10_tree = (CommonTree)adaptor.dupNode(char_literal10);

                    adaptor.addChild(root_0, char_literal10_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON11=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute140); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON11_tree = (CommonTree)adaptor.dupNode(IDCON11);

                    adaptor.addChild(root_0, IDCON11_tree);
                    }
                    if ( state.backtracking==0 ) {
                       current.setAttribute("class", IDCON11.getText()); 
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
                    char_literal12=(CommonTree)match(input,39,FOLLOW_39_in_attribute150); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal12_tree = (CommonTree)adaptor.dupNode(char_literal12);

                    adaptor.addChild(root_0, char_literal12_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON13=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute152); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON13_tree = (CommonTree)adaptor.dupNode(IDCON13);

                    adaptor.addChild(root_0, IDCON13_tree);
                    }
                    if ( state.backtracking==0 ) {
                       current.setAttribute("name", IDCON13.getText()); 
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
                    char_literal14=(CommonTree)match(input,37,FOLLOW_37_in_attribute162); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal14_tree = (CommonTree)adaptor.dupNode(char_literal14);

                    adaptor.addChild(root_0, char_literal14_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON15=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute164); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON15_tree = (CommonTree)adaptor.dupNode(IDCON15);

                    adaptor.addChild(root_0, IDCON15_tree);
                    }
                    if ( state.backtracking==0 ) {
                       current.setAttribute("type", IDCON15.getText()); 
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
                    char_literal16=(CommonTree)match(input,40,FOLLOW_40_in_attribute174); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal16_tree = (CommonTree)adaptor.dupNode(char_literal16);

                    adaptor.addChild(root_0, char_literal16_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    w=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_attribute178); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    w_tree = (CommonTree)adaptor.dupNode(w);

                    adaptor.addChild(root_0, w_tree);
                    }
                    if ( state.backtracking==0 ) {
                       current.setAttribute("width", w.getText()); 
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:233:5: ( '%' h= NATCON )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==41) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:233:7: '%' h= NATCON
                            {
                            _last = (CommonTree)input.LT(1);
                            char_literal17=(CommonTree)match(input,41,FOLLOW_41_in_attribute189); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal17_tree = (CommonTree)adaptor.dupNode(char_literal17);

                            adaptor.addChild(root_0, char_literal17_tree);
                            }
                            _last = (CommonTree)input.LT(1);
                            h=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_attribute193); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:235:1: arguments : '(' ( argument )? ( ',' argument )* ')' ;
    public final WaebricInterpreter.arguments_return arguments() throws RecognitionException {
        WaebricInterpreter.arguments_return retval = new WaebricInterpreter.arguments_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal18=null;
        CommonTree char_literal20=null;
        CommonTree char_literal22=null;
        WaebricInterpreter.argument_return argument19 = null;

        WaebricInterpreter.argument_return argument21 = null;


        CommonTree char_literal18_tree=null;
        CommonTree char_literal20_tree=null;
        CommonTree char_literal22_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:235:10: ( '(' ( argument )? ( ',' argument )* ')' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:235:13: '(' ( argument )? ( ',' argument )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            char_literal18=(CommonTree)match(input,42,FOLLOW_42_in_arguments210); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal18_tree = (CommonTree)adaptor.dupNode(char_literal18);

            adaptor.addChild(root_0, char_literal18_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:235:17: ( argument )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==IDCON||(LA5_0>=NATCON && LA5_0<=SYMBOLCON)||LA5_0==46||LA5_0==48) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: argument
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_argument_in_arguments212);
                    argument19=argument();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, argument19.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:235:27: ( ',' argument )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==43) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:235:29: ',' argument
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal20=(CommonTree)match(input,43,FOLLOW_43_in_arguments217); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal20_tree = (CommonTree)adaptor.dupNode(char_literal20);

            	    adaptor.addChild(root_0, char_literal20_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_argument_in_arguments219);
            	    argument21=argument();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, argument21.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            char_literal22=(CommonTree)match(input,44,FOLLOW_44_in_arguments224); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal22_tree = (CommonTree)adaptor.dupNode(char_literal22);

            adaptor.addChild(root_0, char_literal22_tree);
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

        CommonTree IDCON24=null;
        CommonTree char_literal25=null;
        WaebricInterpreter.expression_return expression23 = null;

        WaebricInterpreter.expression_return expression26 = null;


        CommonTree IDCON24_tree=null;
        CommonTree char_literal25_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:237:9: ( expression | IDCON '=' expression )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==IDCON) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==45) ) {
                    alt7=2;
                }
                else if ( (LA7_1==EOF||LA7_1==35||(LA7_1>=43 && LA7_1<=44)||LA7_1==50) ) {
                    alt7=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA7_0>=NATCON && LA7_0<=SYMBOLCON)||LA7_0==46||LA7_0==48) ) {
                alt7=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:237:12: expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_argument233);
                    expression23=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression23.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:238:6: IDCON '=' expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDCON24=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_argument240); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON24_tree = (CommonTree)adaptor.dupNode(IDCON24);

                    adaptor.addChild(root_0, IDCON24_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal25=(CommonTree)match(input,45,FOLLOW_45_in_argument242); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal25_tree = (CommonTree)adaptor.dupNode(char_literal25);

                    adaptor.addChild(root_0, char_literal25_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_argument244);
                    expression26=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression26.getTree());
                    if ( state.backtracking==0 ) {
                       current.setAttribute(IDCON24.getText(), (expression26!=null?expression26.eval:null)); 
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
        CommonTree NATCON27=null;
        CommonTree TEXT28=null;
        CommonTree SYMBOLCON29=null;
        CommonTree char_literal30=null;
        CommonTree char_literal31=null;
        CommonTree char_literal32=null;
        CommonTree char_literal33=null;
        CommonTree char_literal34=null;
        CommonTree char_literal35=null;
        CommonTree char_literal36=null;
        CommonTree char_literal37=null;
        CommonTree char_literal38=null;
        CommonTree char_literal39=null;
        WaebricInterpreter.expression_return e = null;


        CommonTree var_tree=null;
        CommonTree id_tree=null;
        CommonTree NATCON27_tree=null;
        CommonTree TEXT28_tree=null;
        CommonTree SYMBOLCON29_tree=null;
        CommonTree char_literal30_tree=null;
        CommonTree char_literal31_tree=null;
        CommonTree char_literal32_tree=null;
        CommonTree char_literal33_tree=null;
        CommonTree char_literal34_tree=null;
        CommonTree char_literal35_tree=null;
        CommonTree char_literal36_tree=null;
        CommonTree char_literal37_tree=null;
        CommonTree char_literal38_tree=null;
        CommonTree char_literal39_tree=null;

         retval.index = input.index(); 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:249:2: ( (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (id= IDCON ':' e= expression )? ( ',' id= IDCON ':' e= expression )* '}' ) ( '+' e= expression | '.' id= IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:250:4: (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (id= IDCON ':' e= expression )? ( ',' id= IDCON ':' e= expression )* '}' ) ( '+' e= expression | '.' id= IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:250:4: (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (id= IDCON ':' e= expression )? ( ',' id= IDCON ':' e= expression )* '}' )
            int alt12=6;
            switch ( input.LA(1) ) {
            case IDCON:
                {
                alt12=1;
                }
                break;
            case NATCON:
                {
                alt12=2;
                }
                break;
            case TEXT:
                {
                alt12=3;
                }
                break;
            case SYMBOLCON:
                {
                alt12=4;
                }
                break;
            case 46:
                {
                alt12=5;
                }
                break;
            case 48:
                {
                alt12=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:250:6: var= IDCON
                    {
                    _last = (CommonTree)input.LT(1);
                    var=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression277); if (state.failed) return retval;
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
                    NATCON27=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_expression286); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON27_tree = (CommonTree)adaptor.dupNode(NATCON27);

                    adaptor.addChild(root_0, NATCON27_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.eval = NATCON27.getText(); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:261:6: TEXT
                    {
                    _last = (CommonTree)input.LT(1);
                    TEXT28=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_expression295); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TEXT28_tree = (CommonTree)adaptor.dupNode(TEXT28);

                    adaptor.addChild(root_0, TEXT28_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.eval = TEXT28.getText(); retval.eval = retval.eval.substring(1, retval.eval.length()-1); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:262:6: SYMBOLCON
                    {
                    _last = (CommonTree)input.LT(1);
                    SYMBOLCON29=(CommonTree)match(input,SYMBOLCON,FOLLOW_SYMBOLCON_in_expression304); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SYMBOLCON29_tree = (CommonTree)adaptor.dupNode(SYMBOLCON29);

                    adaptor.addChild(root_0, SYMBOLCON29_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.eval = SYMBOLCON29.getText(); retval.eval = retval.eval.substring(1, retval.eval.length()); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:263:6: '[' (e= expression )? ( ',' e= expression )* ']'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal30=(CommonTree)match(input,46,FOLLOW_46_in_expression313); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal30_tree = (CommonTree)adaptor.dupNode(char_literal30);

                    adaptor.addChild(root_0, char_literal30_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:263:10: (e= expression )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==IDCON||(LA8_0>=NATCON && LA8_0<=SYMBOLCON)||LA8_0==46||LA8_0==48) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:263:12: e= expression
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_expression_in_expression319);
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
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==43) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:264:8: ',' e= expression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal31=(CommonTree)match(input,43,FOLLOW_43_in_expression334); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal31_tree = (CommonTree)adaptor.dupNode(char_literal31);

                    	    adaptor.addChild(root_0, char_literal31_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_expression_in_expression338);
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
                    	    break loop9;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal32=(CommonTree)match(input,47,FOLLOW_47_in_expression345); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal32_tree = (CommonTree)adaptor.dupNode(char_literal32);

                    adaptor.addChild(root_0, char_literal32_tree);
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
                    char_literal33=(CommonTree)match(input,48,FOLLOW_48_in_expression354); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal33_tree = (CommonTree)adaptor.dupNode(char_literal33);

                    adaptor.addChild(root_0, char_literal33_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:271:10: (id= IDCON ':' e= expression )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==IDCON) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:271:12: id= IDCON ':' e= expression
                            {
                            _last = (CommonTree)input.LT(1);
                            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression360); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            id_tree = (CommonTree)adaptor.dupNode(id);

                            adaptor.addChild(root_0, id_tree);
                            }
                            _last = (CommonTree)input.LT(1);
                            char_literal34=(CommonTree)match(input,37,FOLLOW_37_in_expression362); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal34_tree = (CommonTree)adaptor.dupNode(char_literal34);

                            adaptor.addChild(root_0, char_literal34_tree);
                            }
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_expression_in_expression366);
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
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==43) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:272:8: ',' id= IDCON ':' e= expression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal35=(CommonTree)match(input,43,FOLLOW_43_in_expression381); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal35_tree = (CommonTree)adaptor.dupNode(char_literal35);

                    	    adaptor.addChild(root_0, char_literal35_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression385); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    id_tree = (CommonTree)adaptor.dupNode(id);

                    	    adaptor.addChild(root_0, id_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal36=(CommonTree)match(input,37,FOLLOW_37_in_expression387); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal36_tree = (CommonTree)adaptor.dupNode(char_literal36);

                    	    adaptor.addChild(root_0, char_literal36_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_expression_in_expression391);
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
                    	    break loop11;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal37=(CommonTree)match(input,49,FOLLOW_49_in_expression398); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal37_tree = (CommonTree)adaptor.dupNode(char_literal37);

                    adaptor.addChild(root_0, char_literal37_tree);
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
            loop13:
            do {
                int alt13=3;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==50) ) {
                    int LA13_2 = input.LA(2);

                    if ( (synpred20_WaebricInterpreter()) ) {
                        alt13=1;
                    }


                }
                else if ( (LA13_0==35) ) {
                    int LA13_3 = input.LA(2);

                    if ( (synpred21_WaebricInterpreter()) ) {
                        alt13=2;
                    }


                }


                switch (alt13) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:283:6: '+' e= expression
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal38=(CommonTree)match(input,50,FOLLOW_50_in_expression421); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal38_tree = (CommonTree)adaptor.dupNode(char_literal38);

            	    adaptor.addChild(root_0, char_literal38_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expression_in_expression425);
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
            	    char_literal39=(CommonTree)match(input,35,FOLLOW_35_in_expression435); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal39_tree = (CommonTree)adaptor.dupNode(char_literal39);

            	    adaptor.addChild(root_0, char_literal39_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression439); if (state.failed) return retval;
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
            	    break loop13;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:303:1: function : 'def' IDCON ( formals )? ( statement )* 'end' ;
    public final WaebricInterpreter.function_return function() throws RecognitionException {
        WaebricInterpreter.function_return retval = new WaebricInterpreter.function_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal40=null;
        CommonTree IDCON41=null;
        CommonTree string_literal44=null;
        WaebricInterpreter.formals_return formals42 = null;

        WaebricInterpreter.statement_return statement43 = null;


        CommonTree string_literal40_tree=null;
        CommonTree IDCON41_tree=null;
        CommonTree string_literal44_tree=null;

         Element actual = null; 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:305:2: ( 'def' IDCON ( formals )? ( statement )* 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:305:5: 'def' IDCON ( formals )? ( statement )* 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal40=(CommonTree)match(input,51,FOLLOW_51_in_function468); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal40_tree = (CommonTree)adaptor.dupNode(string_literal40);

            adaptor.addChild(root_0, string_literal40_tree);
            }
            _last = (CommonTree)input.LT(1);
            IDCON41=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_function474); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON41_tree = (CommonTree)adaptor.dupNode(IDCON41);

            adaptor.addChild(root_0, IDCON41_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:307:4: ( formals )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==42) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: formals
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_formals_in_function480);
                    formals42=formals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, formals42.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:308:4: ( statement )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==MARKUP_STATEMENT||LA15_0==COMMENT||LA15_0==48||LA15_0==52||(LA15_0>=54 && LA15_0<=55)||(LA15_0>=57 && LA15_0<=59)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:308:6: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_function489);
            	    statement43=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, statement43.getTree());
            	    if ( state.backtracking==0 ) {
            	       
            	      				if(actual != null) { this.current = actual; }
            	      				else { actual = this.current; }
            	      			
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
            string_literal44=(CommonTree)match(input,END,FOLLOW_END_in_function496); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal44_tree = (CommonTree)adaptor.dupNode(string_literal44);

            adaptor.addChild(root_0, string_literal44_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:313:1: formals : '(' ( IDCON )* ')' ;
    public final WaebricInterpreter.formals_return formals() throws RecognitionException {
        WaebricInterpreter.formals_return retval = new WaebricInterpreter.formals_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal45=null;
        CommonTree IDCON46=null;
        CommonTree char_literal47=null;

        CommonTree char_literal45_tree=null;
        CommonTree IDCON46_tree=null;
        CommonTree char_literal47_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:313:8: ( '(' ( IDCON )* ')' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:313:12: '(' ( IDCON )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            char_literal45=(CommonTree)match(input,42,FOLLOW_42_in_formals506); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal45_tree = (CommonTree)adaptor.dupNode(char_literal45);

            adaptor.addChild(root_0, char_literal45_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:313:16: ( IDCON )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==IDCON) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    IDCON46=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_formals508); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDCON46_tree = (CommonTree)adaptor.dupNode(IDCON46);

            	    adaptor.addChild(root_0, IDCON46_tree);
            	    }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            char_literal47=(CommonTree)match(input,44,FOLLOW_44_in_formals511); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal47_tree = (CommonTree)adaptor.dupNode(char_literal47);

            adaptor.addChild(root_0, char_literal47_tree);
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

        CommonTree string_literal52=null;
        CommonTree STRCON53=null;
        CommonTree char_literal54=null;
        CommonTree string_literal55=null;
        CommonTree char_literal57=null;
        CommonTree string_literal58=null;
        CommonTree char_literal60=null;
        CommonTree string_literal61=null;
        CommonTree char_literal63=null;
        CommonTree string_literal64=null;
        CommonTree MARKUP_STATEMENT65=null;
        CommonTree char_literal68=null;
        CommonTree MARKUP_STATEMENT69=null;
        CommonTree char_literal72=null;
        CommonTree MARKUP_STATEMENT73=null;
        CommonTree char_literal75=null;
        CommonTree MARKUP_STATEMENT76=null;
        WaebricInterpreter.ifStatement_return ifStatement48 = null;

        WaebricInterpreter.eachStatement_return eachStatement49 = null;

        WaebricInterpreter.letStatement_return letStatement50 = null;

        WaebricInterpreter.blockStatement_return blockStatement51 = null;

        WaebricInterpreter.expression_return expression56 = null;

        WaebricInterpreter.embedding_return embedding59 = null;

        WaebricInterpreter.expression_return expression62 = null;

        WaebricInterpreter.markup_return markup66 = null;

        WaebricInterpreter.expression_return expression67 = null;

        WaebricInterpreter.markup_return markup70 = null;

        WaebricInterpreter.embedding_return embedding71 = null;

        WaebricInterpreter.markup_return markup74 = null;

        WaebricInterpreter.markup_return markup77 = null;

        WaebricInterpreter.statement_return statement78 = null;


        CommonTree string_literal52_tree=null;
        CommonTree STRCON53_tree=null;
        CommonTree char_literal54_tree=null;
        CommonTree string_literal55_tree=null;
        CommonTree char_literal57_tree=null;
        CommonTree string_literal58_tree=null;
        CommonTree char_literal60_tree=null;
        CommonTree string_literal61_tree=null;
        CommonTree char_literal63_tree=null;
        CommonTree string_literal64_tree=null;
        CommonTree MARKUP_STATEMENT65_tree=null;
        CommonTree char_literal68_tree=null;
        CommonTree MARKUP_STATEMENT69_tree=null;
        CommonTree char_literal72_tree=null;
        CommonTree MARKUP_STATEMENT73_tree=null;
        CommonTree char_literal75_tree=null;
        CommonTree MARKUP_STATEMENT76_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:319:10: ( ifStatement | eachStatement | letStatement | blockStatement | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) | ^( MARKUP_STATEMENT ( markup )+ ';' ) | ^( MARKUP_STATEMENT ( markup )+ statement ) )
            int alt21=13;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:319:13: ifStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_ifStatement_in_statement523);
                    ifStatement48=ifStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, ifStatement48.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:320:6: eachStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_eachStatement_in_statement530);
                    eachStatement49=eachStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, eachStatement49.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:321:6: letStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_letStatement_in_statement537);
                    letStatement50=letStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, letStatement50.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:322:6: blockStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_blockStatement_in_statement544);
                    blockStatement51=blockStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, blockStatement51.getTree());

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
                    string_literal52=(CommonTree)match(input,COMMENT,FOLLOW_COMMENT_in_statement553); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal52_tree = (CommonTree)adaptor.dupNode(string_literal52);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal52_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    STRCON53=(CommonTree)match(input,STRCON,FOLLOW_STRCON_in_statement555); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRCON53_tree = (CommonTree)adaptor.dupNode(STRCON53);

                    adaptor.addChild(root_1, STRCON53_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal54=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement557); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal54_tree = (CommonTree)adaptor.dupNode(char_literal54);

                    adaptor.addChild(root_1, char_literal54_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                    if ( state.backtracking==0 ) {
                       addContent(new Comment(STRCON53.getText())); 
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
                    string_literal55=(CommonTree)match(input,57,FOLLOW_57_in_statement570); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal55_tree = (CommonTree)adaptor.dupNode(string_literal55);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal55_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement572);
                    expression56=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression56.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal57=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement574); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal57_tree = (CommonTree)adaptor.dupNode(char_literal57);

                    adaptor.addChild(root_1, char_literal57_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                    if ( state.backtracking==0 ) {
                       addContent(new Text((expression56!=null?expression56.eval:null))); 
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
                    string_literal58=(CommonTree)match(input,57,FOLLOW_57_in_statement587); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal58_tree = (CommonTree)adaptor.dupNode(string_literal58);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal58_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement589);
                    embedding59=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding59.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal60=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement591); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal60_tree = (CommonTree)adaptor.dupNode(char_literal60);

                    adaptor.addChild(root_1, char_literal60_tree);
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
                    string_literal61=(CommonTree)match(input,58,FOLLOW_58_in_statement602); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal61_tree = (CommonTree)adaptor.dupNode(string_literal61);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal61_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement604);
                    expression62=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression62.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal63=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement606); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal63_tree = (CommonTree)adaptor.dupNode(char_literal63);

                    adaptor.addChild(root_1, char_literal63_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                    if ( state.backtracking==0 ) {
                      	addContent(new CDATA((expression62!=null?expression62.eval:null))); 
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
                    string_literal64=(CommonTree)match(input,59,FOLLOW_59_in_statement617); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal64_tree = (CommonTree)adaptor.dupNode(string_literal64);

                    adaptor.addChild(root_0, string_literal64_tree);
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
                    MARKUP_STATEMENT65=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement626); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT65_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT65);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT65_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:328:26: ( markup )+
                    int cnt17=0;
                    loop17:
                    do {
                        int alt17=2;
                        alt17 = dfa17.predict(input);
                        switch (alt17) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement628);
                    	    markup66=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup66.getTree());

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
                    pushFollow(FOLLOW_expression_in_statement631);
                    expression67=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression67.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal68=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement633); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal68_tree = (CommonTree)adaptor.dupNode(char_literal68);

                    adaptor.addChild(root_1, char_literal68_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                    if ( state.backtracking==0 ) {
                       addContent(new Text((expression67!=null?expression67.eval:null))); 
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
                    MARKUP_STATEMENT69=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement646); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT69_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT69);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT69_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:329:26: ( markup )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==IDCON) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement648);
                    	    markup70=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup70.getTree());

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
                    pushFollow(FOLLOW_embedding_in_statement651);
                    embedding71=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding71.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal72=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement653); if (state.failed) return retval;
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
                case 12 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:330:6: ^( MARKUP_STATEMENT ( markup )+ ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT73=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement664); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT73_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT73);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT73_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:330:26: ( markup )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==IDCON) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement666);
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
                    	    if ( cnt19 >= 1 ) break loop19;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(19, input);
                                throw eee;
                        }
                        cnt19++;
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal75=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement669); if (state.failed) return retval;
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
                case 13 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:331:6: ^( MARKUP_STATEMENT ( markup )+ statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT76=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement681); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT76_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT76);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT76_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:331:26: ( markup )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==IDCON) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement683);
                    	    markup77=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup77.getTree());

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
                    pushFollow(FOLLOW_statement_in_statement686);
                    statement78=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, statement78.getTree());

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

        CommonTree string_literal79=null;
        CommonTree char_literal80=null;
        CommonTree char_literal82=null;
        CommonTree string_literal83=null;
        CommonTree t=null;
        CommonTree f=null;
        WaebricInterpreter.predicate_return predicate81 = null;


        CommonTree string_literal79_tree=null;
        CommonTree char_literal80_tree=null;
        CommonTree char_literal82_tree=null;
        CommonTree string_literal83_tree=null;
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
            string_literal79=(CommonTree)match(input,52,FOLLOW_52_in_ifStatement706); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal79_tree = (CommonTree)adaptor.dupNode(string_literal79);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal79_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            char_literal80=(CommonTree)match(input,42,FOLLOW_42_in_ifStatement708); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal80_tree = (CommonTree)adaptor.dupNode(char_literal80);

            adaptor.addChild(root_1, char_literal80_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_predicate_in_ifStatement710);
            predicate81=predicate();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, predicate81.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal82=(CommonTree)match(input,44,FOLLOW_44_in_ifStatement712); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal82_tree = (CommonTree)adaptor.dupNode(char_literal82);

            adaptor.addChild(root_1, char_literal82_tree);
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
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==53) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:335:62: 'else' f= .
                    {
                    _last = (CommonTree)input.LT(1);
                    string_literal83=(CommonTree)match(input,53,FOLLOW_53_in_ifStatement723); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal83_tree = (CommonTree)adaptor.dupNode(string_literal83);

                    adaptor.addChild(root_1, string_literal83_tree);
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
              				if((predicate81!=null?predicate81.eval:false)) {
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

        CommonTree string_literal84=null;
        CommonTree char_literal85=null;
        CommonTree IDCON86=null;
        CommonTree char_literal87=null;
        CommonTree char_literal88=null;
        CommonTree wildcard89=null;
        WaebricInterpreter.expression_return e = null;


        CommonTree string_literal84_tree=null;
        CommonTree char_literal85_tree=null;
        CommonTree IDCON86_tree=null;
        CommonTree char_literal87_tree=null;
        CommonTree char_literal88_tree=null;
        CommonTree wildcard89_tree=null;


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
            string_literal84=(CommonTree)match(input,54,FOLLOW_54_in_eachStatement763); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal84_tree = (CommonTree)adaptor.dupNode(string_literal84);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal84_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            char_literal85=(CommonTree)match(input,42,FOLLOW_42_in_eachStatement765); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal85_tree = (CommonTree)adaptor.dupNode(char_literal85);

            adaptor.addChild(root_1, char_literal85_tree);
            }
            _last = (CommonTree)input.LT(1);
            IDCON86=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_eachStatement767); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON86_tree = (CommonTree)adaptor.dupNode(IDCON86);

            adaptor.addChild(root_1, IDCON86_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal87=(CommonTree)match(input,37,FOLLOW_37_in_eachStatement769); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal87_tree = (CommonTree)adaptor.dupNode(char_literal87);

            adaptor.addChild(root_1, char_literal87_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_eachStatement773);
            e=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, e.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal88=(CommonTree)match(input,44,FOLLOW_44_in_eachStatement775); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal88_tree = (CommonTree)adaptor.dupNode(char_literal88);

            adaptor.addChild(root_1, char_literal88_tree);
            }
            if ( state.backtracking==0 ) {
               stm = input.index(); 
            }
            _last = (CommonTree)input.LT(1);
            wildcard89=(CommonTree)input.LT(1);
            matchAny(input); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            wildcard89_tree = (CommonTree)adaptor.dupTree(wildcard89);
            adaptor.addChild(root_1, wildcard89_tree);
            }

            match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }

            if ( state.backtracking==0 ) {

              				int actualIndex = input.index();
                            			Element actualElement = this.current;
                            			for(expression_return value: e.collection) {
                            				((Environment_scope)Environment_stack.peek()).variables.put(IDCON86.getText(), value.index);
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

        CommonTree char_literal90=null;
        CommonTree char_literal92=null;
        WaebricInterpreter.statement_return statement91 = null;


        CommonTree char_literal90_tree=null;
        CommonTree char_literal92_tree=null;

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
            char_literal90=(CommonTree)match(input,48,FOLLOW_48_in_blockStatement801); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal90_tree = (CommonTree)adaptor.dupNode(char_literal90);

            root_1 = (CommonTree)adaptor.becomeRoot(char_literal90_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:369:12: ( statement )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==MARKUP_STATEMENT||LA23_0==COMMENT||LA23_0==48||LA23_0==52||(LA23_0>=54 && LA23_0<=55)||(LA23_0>=57 && LA23_0<=59)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:369:14: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_blockStatement805);
            	    statement91=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, statement91.getTree());
            	    if ( state.backtracking==0 ) {
            	       this.current = actual; 
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
            char_literal92=(CommonTree)match(input,49,FOLLOW_49_in_blockStatement812); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal92_tree = (CommonTree)adaptor.dupNode(char_literal92);

            adaptor.addChild(root_1, char_literal92_tree);
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

        CommonTree string_literal93=null;
        CommonTree string_literal95=null;
        CommonTree string_literal97=null;
        WaebricInterpreter.assignment_return assignment94 = null;

        WaebricInterpreter.statement_return statement96 = null;


        CommonTree string_literal93_tree=null;
        CommonTree string_literal95_tree=null;
        CommonTree string_literal97_tree=null;


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
            string_literal93=(CommonTree)match(input,55,FOLLOW_55_in_letStatement840); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal93_tree = (CommonTree)adaptor.dupNode(string_literal93);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal93_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:377:16: ( assignment )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==IDCON||LA24_0==51) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: assignment
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_assignment_in_letStatement842);
            	    assignment94=assignment();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, assignment94.getTree());

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
            string_literal95=(CommonTree)match(input,56,FOLLOW_56_in_letStatement845); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal95_tree = (CommonTree)adaptor.dupNode(string_literal95);

            adaptor.addChild(root_1, string_literal95_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:378:4: ( statement )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==MARKUP_STATEMENT||LA25_0==COMMENT||LA25_0==48||LA25_0==52||(LA25_0>=54 && LA25_0<=55)||(LA25_0>=57 && LA25_0<=59)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:378:6: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_letStatement853);
            	    statement96=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, statement96.getTree());
            	    if ( state.backtracking==0 ) {
            	       this.current = actual; 
            	    }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            string_literal97=(CommonTree)match(input,END,FOLLOW_END_in_letStatement864); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal97_tree = (CommonTree)adaptor.dupNode(string_literal97);

            adaptor.addChild(root_1, string_literal97_tree);
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

        WaebricInterpreter.varBinding_return varBinding98 = null;

        WaebricInterpreter.funcBinding_return funcBinding99 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:384:11: ( varBinding | funcBinding )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==IDCON) ) {
                alt26=1;
            }
            else if ( (LA26_0==51) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:384:14: varBinding
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_varBinding_in_assignment878);
                    varBinding98=varBinding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, varBinding98.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:384:27: funcBinding
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_funcBinding_in_assignment882);
                    funcBinding99=funcBinding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, funcBinding99.getTree());

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

        CommonTree IDCON100=null;
        CommonTree char_literal101=null;
        CommonTree char_literal103=null;
        WaebricInterpreter.expression_return expression102 = null;


        CommonTree IDCON100_tree=null;
        CommonTree char_literal101_tree=null;
        CommonTree char_literal103_tree=null;

         int index = 0; 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:388:2: ( IDCON '=' expression ';' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:388:5: IDCON '=' expression ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON100=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_varBinding900); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON100_tree = (CommonTree)adaptor.dupNode(IDCON100);

            adaptor.addChild(root_0, IDCON100_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal101=(CommonTree)match(input,45,FOLLOW_45_in_varBinding902); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal101_tree = (CommonTree)adaptor.dupNode(char_literal101);

            adaptor.addChild(root_0, char_literal101_tree);
            }
            if ( state.backtracking==0 ) {
               index = input.index(); 
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_varBinding906);
            expression102=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, expression102.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal103=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_varBinding908); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal103_tree = (CommonTree)adaptor.dupNode(char_literal103);

            adaptor.addChild(root_0, char_literal103_tree);
            }
            if ( state.backtracking==0 ) {

              				defineVariable(IDCON100.getText(), index);
              			
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:392:1: funcBinding : 'def' id= IDCON formals . 'end' ;
    public final WaebricInterpreter.funcBinding_return funcBinding() throws RecognitionException {
        WaebricInterpreter.funcBinding_return retval = new WaebricInterpreter.funcBinding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        CommonTree string_literal104=null;
        CommonTree wildcard106=null;
        CommonTree string_literal107=null;
        WaebricInterpreter.formals_return formals105 = null;


        CommonTree id_tree=null;
        CommonTree string_literal104_tree=null;
        CommonTree wildcard106_tree=null;
        CommonTree string_literal107_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:392:13: ( 'def' id= IDCON formals . 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:392:16: 'def' id= IDCON formals . 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal104=(CommonTree)match(input,51,FOLLOW_51_in_funcBinding923); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal104_tree = (CommonTree)adaptor.dupNode(string_literal104);

            adaptor.addChild(root_0, string_literal104_tree);
            }
            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_funcBinding927); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (CommonTree)adaptor.dupNode(id);

            adaptor.addChild(root_0, id_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_formals_in_funcBinding929);
            formals105=formals();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, formals105.getTree());
            _last = (CommonTree)input.LT(1);
            wildcard106=(CommonTree)input.LT(1);
            matchAny(input); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            wildcard106_tree = (CommonTree)adaptor.dupTree(wildcard106);
            adaptor.addChild(root_0, wildcard106_tree);
            }
            _last = (CommonTree)input.LT(1);
            string_literal107=(CommonTree)match(input,END,FOLLOW_END_in_funcBinding933); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal107_tree = (CommonTree)adaptor.dupNode(string_literal107);

            adaptor.addChild(root_0, string_literal107_tree);
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

        CommonTree char_literal108=null;
        CommonTree char_literal109=null;
        CommonTree string_literal111=null;
        CommonTree string_literal112=null;
        WaebricInterpreter.predicate_return p = null;

        WaebricInterpreter.expression_return e = null;

        WaebricInterpreter.type_return type110 = null;


        CommonTree char_literal108_tree=null;
        CommonTree char_literal109_tree=null;
        CommonTree string_literal111_tree=null;
        CommonTree string_literal112_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:401:2: ( ( '!' p= predicate | e= expression | e= expression '.' type ) ( '&&' p= predicate | '||' p= predicate )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:401:5: ( '!' p= predicate | e= expression | e= expression '.' type ) ( '&&' p= predicate | '||' p= predicate )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:401:5: ( '!' p= predicate | e= expression | e= expression '.' type )
            int alt27=3;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:401:7: '!' p= predicate
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal108=(CommonTree)match(input,60,FOLLOW_60_in_predicate958); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal108_tree = (CommonTree)adaptor.dupNode(char_literal108);

                    adaptor.addChild(root_0, char_literal108_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_predicate962);
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
                    pushFollow(FOLLOW_expression_in_predicate974);
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
                    pushFollow(FOLLOW_expression_in_predicate987);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, e.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal109=(CommonTree)match(input,35,FOLLOW_35_in_predicate989); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal109_tree = (CommonTree)adaptor.dupNode(char_literal109);

                    adaptor.addChild(root_0, char_literal109_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_predicate991);
                    type110=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, type110.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:404:6: ( '&&' p= predicate | '||' p= predicate )*
            loop28:
            do {
                int alt28=3;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==61) ) {
                    int LA28_2 = input.LA(2);

                    if ( (synpred48_WaebricInterpreter()) ) {
                        alt28=1;
                    }


                }
                else if ( (LA28_0==62) ) {
                    int LA28_3 = input.LA(2);

                    if ( (synpred49_WaebricInterpreter()) ) {
                        alt28=2;
                    }


                }


                switch (alt28) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:404:8: '&&' p= predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal111=(CommonTree)match(input,61,FOLLOW_61_in_predicate1001); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal111_tree = (CommonTree)adaptor.dupNode(string_literal111);

            	    adaptor.addChild(root_0, string_literal111_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate1005);
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
            	    string_literal112=(CommonTree)match(input,62,FOLLOW_62_in_predicate1011); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal112_tree = (CommonTree)adaptor.dupNode(string_literal112);

            	    adaptor.addChild(root_0, string_literal112_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate1015);
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
            	    break loop28;
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

        CommonTree set113=null;

        CommonTree set113_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:406:5: ( 'list' | 'record' | 'string' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            set113=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=63 && input.LA(1)<=65) ) {
                input.consume();

                if ( state.backtracking==0 ) {
                set113_tree = (CommonTree)adaptor.dupNode(set113);

                adaptor.addChild(root_0, set113_tree);
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

        CommonTree PRETEXT114=null;
        WaebricInterpreter.embed_return embed115 = null;

        WaebricInterpreter.textTail_return textTail116 = null;


        CommonTree PRETEXT114_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:411:10: ( PRETEXT embed textTail )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:411:13: PRETEXT embed textTail
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PRETEXT114=(CommonTree)match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding1053); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRETEXT114_tree = (CommonTree)adaptor.dupNode(PRETEXT114);

            adaptor.addChild(root_0, PRETEXT114_tree);
            }
            if ( state.backtracking==0 ) {
               addContent(new Text(PRETEXT114.getText())); 
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_embed_in_embedding1057);
            embed115=embed();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, embed115.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_textTail_in_embedding1059);
            textTail116=textTail();

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:413:1: embed : ( ( markup )* expression | ( markup )+ );
    public final WaebricInterpreter.embed_return embed() throws RecognitionException {
        WaebricInterpreter.embed_return retval = new WaebricInterpreter.embed_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricInterpreter.markup_return markup117 = null;

        WaebricInterpreter.expression_return expression118 = null;

        WaebricInterpreter.markup_return markup119 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:413:6: ( ( markup )* expression | ( markup )+ )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==IDCON) ) {
                int LA31_1 = input.LA(2);

                if ( (synpred53_WaebricInterpreter()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA31_0>=NATCON && LA31_0<=SYMBOLCON)||LA31_0==46||LA31_0==48) ) {
                alt31=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:413:10: ( markup )* expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:413:10: ( markup )*
                    loop29:
                    do {
                        int alt29=2;
                        alt29 = dfa29.predict(input);
                        switch (alt29) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed1069);
                    	    markup117=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup117.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_embed1072);
                    expression118=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression118.getTree());
                    if ( state.backtracking==0 ) {
                       addContent(new Text((expression118!=null?expression118.eval:null))); 
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
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed1082);
                    	    markup119=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup119.getTree());

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

        CommonTree POSTTEXT120=null;
        CommonTree MIDTEXT121=null;
        WaebricInterpreter.embed_return embed122 = null;

        WaebricInterpreter.textTail_return textTail123 = null;


        CommonTree POSTTEXT120_tree=null;
        CommonTree MIDTEXT121_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:416:9: ( POSTTEXT | MIDTEXT embed textTail )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==POSTTEXT) ) {
                alt32=1;
            }
            else if ( (LA32_0==MIDTEXT) ) {
                alt32=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:416:12: POSTTEXT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    POSTTEXT120=(CommonTree)match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail1092); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    POSTTEXT120_tree = (CommonTree)adaptor.dupNode(POSTTEXT120);

                    adaptor.addChild(root_0, POSTTEXT120_tree);
                    }
                    if ( state.backtracking==0 ) {
                       addContent(new Text(POSTTEXT120.getText())); 
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
                    MIDTEXT121=(CommonTree)match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail1101); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MIDTEXT121_tree = (CommonTree)adaptor.dupNode(MIDTEXT121);

                    adaptor.addChild(root_0, MIDTEXT121_tree);
                    }
                    if ( state.backtracking==0 ) {
                       addContent(new Text(MIDTEXT121.getText())); 
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embed_in_textTail1105);
                    embed122=embed();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, embed122.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_textTail_in_textTail1107);
                    textTail123=textTail();

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

    // $ANTLR start synpred20_WaebricInterpreter
    public final void synpred20_WaebricInterpreter_fragment() throws RecognitionException {   
        WaebricInterpreter.expression_return e = null;


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:283:6: ( '+' e= expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:283:6: '+' e= expression
        {
        match(input,50,FOLLOW_50_in_synpred20_WaebricInterpreter421); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred20_WaebricInterpreter425);
        e=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred20_WaebricInterpreter

    // $ANTLR start synpred21_WaebricInterpreter
    public final void synpred21_WaebricInterpreter_fragment() throws RecognitionException {   
        CommonTree id=null;

        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:289:6: ( '.' id= IDCON )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:289:6: '.' id= IDCON
        {
        match(input,35,FOLLOW_35_in_synpred21_WaebricInterpreter435); if (state.failed) return ;
        id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_synpred21_WaebricInterpreter439); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_WaebricInterpreter

    // $ANTLR start synpred30_WaebricInterpreter
    public final void synpred30_WaebricInterpreter_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:324:6: ( ^( 'echo' expression ';' ) )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:324:6: ^( 'echo' expression ';' )
        {
        match(input,57,FOLLOW_57_in_synpred30_WaebricInterpreter570); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred30_WaebricInterpreter572);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred30_WaebricInterpreter574); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_WaebricInterpreter

    // $ANTLR start synpred31_WaebricInterpreter
    public final void synpred31_WaebricInterpreter_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:325:6: ( ^( 'echo' embedding ';' ) )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:325:6: ^( 'echo' embedding ';' )
        {
        match(input,57,FOLLOW_57_in_synpred31_WaebricInterpreter587); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_embedding_in_synpred31_WaebricInterpreter589);
        embedding();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred31_WaebricInterpreter591); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_WaebricInterpreter

    // $ANTLR start synpred35_WaebricInterpreter
    public final void synpred35_WaebricInterpreter_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:328:6: ( ^( MARKUP_STATEMENT ( markup )+ expression ';' ) )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:328:6: ^( MARKUP_STATEMENT ( markup )+ expression ';' )
        {
        match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_synpred35_WaebricInterpreter626); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:328:26: ( markup )+
        int cnt35=0;
        loop35:
        do {
            int alt35=2;
            alt35 = dfa35.predict(input);
            switch (alt35) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred35_WaebricInterpreter628);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt35 >= 1 ) break loop35;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(35, input);
                    throw eee;
            }
            cnt35++;
        } while (true);

        pushFollow(FOLLOW_expression_in_synpred35_WaebricInterpreter631);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred35_WaebricInterpreter633); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred35_WaebricInterpreter

    // $ANTLR start synpred37_WaebricInterpreter
    public final void synpred37_WaebricInterpreter_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:329:6: ( ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:329:6: ^( MARKUP_STATEMENT ( markup )+ embedding ';' )
        {
        match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_synpred37_WaebricInterpreter646); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:329:26: ( markup )+
        int cnt36=0;
        loop36:
        do {
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==IDCON) ) {
                alt36=1;
            }


            switch (alt36) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred37_WaebricInterpreter648);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt36 >= 1 ) break loop36;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(36, input);
                    throw eee;
            }
            cnt36++;
        } while (true);

        pushFollow(FOLLOW_embedding_in_synpred37_WaebricInterpreter651);
        embedding();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred37_WaebricInterpreter653); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred37_WaebricInterpreter

    // $ANTLR start synpred39_WaebricInterpreter
    public final void synpred39_WaebricInterpreter_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:330:6: ( ^( MARKUP_STATEMENT ( markup )+ ';' ) )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:330:6: ^( MARKUP_STATEMENT ( markup )+ ';' )
        {
        match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_synpred39_WaebricInterpreter664); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:330:26: ( markup )+
        int cnt37=0;
        loop37:
        do {
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==IDCON) ) {
                alt37=1;
            }


            switch (alt37) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred39_WaebricInterpreter666);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt37 >= 1 ) break loop37;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(37, input);
                    throw eee;
            }
            cnt37++;
        } while (true);

        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred39_WaebricInterpreter669); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_WaebricInterpreter

    // $ANTLR start synpred47_WaebricInterpreter
    public final void synpred47_WaebricInterpreter_fragment() throws RecognitionException {   
        WaebricInterpreter.expression_return e = null;


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:402:7: (e= expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:402:7: e= expression
        {
        pushFollow(FOLLOW_expression_in_synpred47_WaebricInterpreter974);
        e=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred47_WaebricInterpreter

    // $ANTLR start synpred48_WaebricInterpreter
    public final void synpred48_WaebricInterpreter_fragment() throws RecognitionException {   
        WaebricInterpreter.predicate_return p = null;


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:404:8: ( '&&' p= predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:404:8: '&&' p= predicate
        {
        match(input,61,FOLLOW_61_in_synpred48_WaebricInterpreter1001); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred48_WaebricInterpreter1005);
        p=predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred48_WaebricInterpreter

    // $ANTLR start synpred49_WaebricInterpreter
    public final void synpred49_WaebricInterpreter_fragment() throws RecognitionException {   
        WaebricInterpreter.predicate_return p = null;


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:404:57: ( '||' p= predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:404:57: '||' p= predicate
        {
        match(input,62,FOLLOW_62_in_synpred49_WaebricInterpreter1011); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred49_WaebricInterpreter1015);
        p=predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred49_WaebricInterpreter

    // $ANTLR start synpred53_WaebricInterpreter
    public final void synpred53_WaebricInterpreter_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:413:10: ( ( markup )* expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:413:10: ( markup )* expression
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:413:10: ( markup )*
        loop38:
        do {
            int alt38=2;
            alt38 = dfa38.predict(input);
            switch (alt38) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred53_WaebricInterpreter1069);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop38;
            }
        } while (true);

        pushFollow(FOLLOW_expression_in_synpred53_WaebricInterpreter1072);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred53_WaebricInterpreter

    // Delegated rules

    public final boolean synpred30_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_WaebricInterpreter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_WaebricInterpreter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred39_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_WaebricInterpreter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_WaebricInterpreter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_WaebricInterpreter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred53_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred53_WaebricInterpreter_fragment(); // can never throw exception
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
    public final boolean synpred35_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_WaebricInterpreter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred49_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred49_WaebricInterpreter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_WaebricInterpreter_fragment(); // can never throw exception
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


    protected DFA21 dfa21 = new DFA21(this);
    protected DFA17 dfa17 = new DFA17(this);
    protected DFA27 dfa27 = new DFA27(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA35 dfa35 = new DFA35(this);
    protected DFA38 dfa38 = new DFA38(this);
    static final String DFA21_eotS =
        "\20\uffff";
    static final String DFA21_eofS =
        "\20\uffff";
    static final String DFA21_minS =
        "\1\4\5\uffff\1\0\2\uffff\1\0\6\uffff";
    static final String DFA21_maxS =
        "\1\73\5\uffff\1\0\2\uffff\1\0\6\uffff";
    static final String DFA21_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\11\1\uffff\1\6\1\7\1"+
        "\12\1\13\1\14\1\15";
    static final String DFA21_specialS =
        "\6\uffff\1\0\2\uffff\1\1\6\uffff}>";
    static final String[] DFA21_transitionS = {
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

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "319:1: statement : ( ifStatement | eachStatement | letStatement | blockStatement | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) | ^( MARKUP_STATEMENT ( markup )+ ';' ) | ^( MARKUP_STATEMENT ( markup )+ statement ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TreeNodeStream input = (TreeNodeStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA21_6 = input.LA(1);

                         
                        int index21_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_WaebricInterpreter()) ) {s = 10;}

                        else if ( (synpred31_WaebricInterpreter()) ) {s = 11;}

                         
                        input.seek(index21_6);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA21_9 = input.LA(1);

                         
                        int index21_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_WaebricInterpreter()) ) {s = 12;}

                        else if ( (synpred37_WaebricInterpreter()) ) {s = 13;}

                        else if ( (synpred39_WaebricInterpreter()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index21_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 21, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA17_eotS =
        "\6\uffff";
    static final String DFA17_eofS =
        "\6\uffff";
    static final String DFA17_minS =
        "\2\5\2\uffff\2\5";
    static final String DFA17_maxS =
        "\1\60\1\62\2\uffff\1\5\1\62";
    static final String DFA17_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA17_specialS =
        "\6\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\1\1\uffff\3\2\44\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\7\uffff\1\2\21\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\3\uffff\1\3\1\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\7\uffff\1\2\21\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\3\uffff\1\3\1\uffff\1\3\1\uffff\1\2"
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "()+ loopback of 328:26: ( markup )+";
        }
    }
    static final String DFA27_eotS =
        "\12\uffff";
    static final String DFA27_eofS =
        "\12\uffff";
    static final String DFA27_minS =
        "\1\5\1\uffff\6\0\2\uffff";
    static final String DFA27_maxS =
        "\1\74\1\uffff\6\0\2\uffff";
    static final String DFA27_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\1\3";
    static final String DFA27_specialS =
        "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\2\uffff}>";
    static final String[] DFA27_transitionS = {
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
            return "401:5: ( '!' p= predicate | e= expression | e= expression '.' type )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TreeNodeStream input = (TreeNodeStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA27_2 = input.LA(1);

                         
                        int index27_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred47_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index27_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA27_3 = input.LA(1);

                         
                        int index27_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred47_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index27_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA27_4 = input.LA(1);

                         
                        int index27_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred47_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index27_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA27_5 = input.LA(1);

                         
                        int index27_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred47_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index27_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA27_6 = input.LA(1);

                         
                        int index27_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred47_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index27_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA27_7 = input.LA(1);

                         
                        int index27_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred47_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index27_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 27, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA29_eotS =
        "\6\uffff";
    static final String DFA29_eofS =
        "\6\uffff";
    static final String DFA29_minS =
        "\2\5\1\uffff\1\5\1\uffff\1\5";
    static final String DFA29_maxS =
        "\1\60\1\62\1\uffff\1\5\1\uffff\1\62";
    static final String DFA29_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String DFA29_specialS =
        "\6\uffff}>";
    static final String[] DFA29_transitionS = {
            "\1\1\1\uffff\3\2\44\uffff\1\2\1\uffff\1\2",
            "\1\4\1\uffff\3\4\2\uffff\2\2\25\uffff\1\3\1\uffff\4\4\1\uffff"+
            "\1\4\3\uffff\1\4\1\uffff\1\4\1\uffff\1\2",
            "",
            "\1\5",
            "",
            "\1\4\1\uffff\3\4\2\uffff\2\2\25\uffff\1\3\1\uffff\4\4\1\uffff"+
            "\1\4\3\uffff\1\4\1\uffff\1\4\1\uffff\1\2"
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
            return "()* loopback of 413:10: ( markup )*";
        }
    }
    static final String DFA35_eotS =
        "\6\uffff";
    static final String DFA35_eofS =
        "\6\uffff";
    static final String DFA35_minS =
        "\2\5\2\uffff\2\5";
    static final String DFA35_maxS =
        "\1\60\1\62\2\uffff\1\5\1\62";
    static final String DFA35_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA35_specialS =
        "\6\uffff}>";
    static final String[] DFA35_transitionS = {
            "\1\1\1\uffff\3\2\44\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\7\uffff\1\2\21\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\3\uffff\1\3\1\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\7\uffff\1\2\21\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\3\uffff\1\3\1\uffff\1\3\1\uffff\1\2"
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
            return "()+ loopback of 328:26: ( markup )+";
        }
    }
    static final String DFA38_eotS =
        "\6\uffff";
    static final String DFA38_eofS =
        "\1\uffff\1\2\3\uffff\1\2";
    static final String DFA38_minS =
        "\2\5\1\uffff\1\5\1\uffff\1\5";
    static final String DFA38_maxS =
        "\1\60\1\62\1\uffff\1\5\1\uffff\1\62";
    static final String DFA38_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String DFA38_specialS =
        "\6\uffff}>";
    static final String[] DFA38_transitionS = {
            "\1\1\1\uffff\3\2\44\uffff\1\2\1\uffff\1\2",
            "\1\4\1\uffff\3\4\31\uffff\1\3\1\uffff\4\4\1\uffff\1\4\3\uffff"+
            "\1\4\1\uffff\1\4\1\uffff\1\2",
            "",
            "\1\5",
            "",
            "\1\4\1\uffff\3\4\31\uffff\1\3\1\uffff\4\4\1\uffff\1\4\3\uffff"+
            "\1\4\1\uffff\1\4\1\uffff\1\2"
    };

    static final short[] DFA38_eot = DFA.unpackEncodedString(DFA38_eotS);
    static final short[] DFA38_eof = DFA.unpackEncodedString(DFA38_eofS);
    static final char[] DFA38_min = DFA.unpackEncodedStringToUnsignedChars(DFA38_minS);
    static final char[] DFA38_max = DFA.unpackEncodedStringToUnsignedChars(DFA38_maxS);
    static final short[] DFA38_accept = DFA.unpackEncodedString(DFA38_acceptS);
    static final short[] DFA38_special = DFA.unpackEncodedString(DFA38_specialS);
    static final short[][] DFA38_transition;

    static {
        int numStates = DFA38_transitionS.length;
        DFA38_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA38_transition[i] = DFA.unpackEncodedString(DFA38_transitionS[i]);
        }
    }

    class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = DFA38_eot;
            this.eof = DFA38_eof;
            this.min = DFA38_min;
            this.max = DFA38_max;
            this.accept = DFA38_accept;
            this.special = DFA38_special;
            this.transition = DFA38_transition;
        }
        public String getDescription() {
            return "()* loopback of 413:10: ( markup )*";
        }
    }
 

    public static final BitSet FOLLOW_PATH_in_mapping78 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_mapping80 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_markup_in_mapping82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_markup97 = new BitSet(new long[]{0x000005E800000000L});
    public static final BitSet FOLLOW_attributes_in_markup99 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_arguments_in_markup101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attribute_in_attributes116 = new BitSet(new long[]{0x000001E800000002L});
    public static final BitSet FOLLOW_38_in_attribute126 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_attribute128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_attribute138 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_attribute140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_attribute150 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_attribute152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_attribute162 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_attribute164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_attribute174 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NATCON_in_attribute178 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_attribute189 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NATCON_in_attribute193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_arguments210 = new BitSet(new long[]{0x00015800000003A0L});
    public static final BitSet FOLLOW_argument_in_arguments212 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_43_in_arguments217 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_argument_in_arguments219 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_44_in_arguments224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_argument233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_argument240 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_argument242 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_argument244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_expression277 = new BitSet(new long[]{0x0004000800000002L});
    public static final BitSet FOLLOW_NATCON_in_expression286 = new BitSet(new long[]{0x0004000800000002L});
    public static final BitSet FOLLOW_TEXT_in_expression295 = new BitSet(new long[]{0x0004000800000002L});
    public static final BitSet FOLLOW_SYMBOLCON_in_expression304 = new BitSet(new long[]{0x0004000800000002L});
    public static final BitSet FOLLOW_46_in_expression313 = new BitSet(new long[]{0x0001C800000003A0L});
    public static final BitSet FOLLOW_expression_in_expression319 = new BitSet(new long[]{0x0000880000000000L});
    public static final BitSet FOLLOW_43_in_expression334 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_expression338 = new BitSet(new long[]{0x0000880000000000L});
    public static final BitSet FOLLOW_47_in_expression345 = new BitSet(new long[]{0x0004000800000002L});
    public static final BitSet FOLLOW_48_in_expression354 = new BitSet(new long[]{0x0002080000000020L});
    public static final BitSet FOLLOW_IDCON_in_expression360 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_expression362 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_expression366 = new BitSet(new long[]{0x0002080000000000L});
    public static final BitSet FOLLOW_43_in_expression381 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_expression385 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_expression387 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_expression391 = new BitSet(new long[]{0x0002080000000000L});
    public static final BitSet FOLLOW_49_in_expression398 = new BitSet(new long[]{0x0004000800000002L});
    public static final BitSet FOLLOW_50_in_expression421 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_expression425 = new BitSet(new long[]{0x0004000800000002L});
    public static final BitSet FOLLOW_35_in_expression435 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_expression439 = new BitSet(new long[]{0x0004000800000002L});
    public static final BitSet FOLLOW_51_in_function468 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_function474 = new BitSet(new long[]{0x0ED1040000014010L});
    public static final BitSet FOLLOW_formals_in_function480 = new BitSet(new long[]{0x0ED1000000014010L});
    public static final BitSet FOLLOW_statement_in_function489 = new BitSet(new long[]{0x0ED1000000014010L});
    public static final BitSet FOLLOW_END_in_function496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_formals506 = new BitSet(new long[]{0x0000100000000020L});
    public static final BitSet FOLLOW_IDCON_in_formals508 = new BitSet(new long[]{0x0000100000000020L});
    public static final BitSet FOLLOW_44_in_formals511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statement523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_eachStatement_in_statement530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_letStatement_in_statement537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blockStatement_in_statement544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMENT_in_statement553 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRCON_in_statement555 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement557 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_57_in_statement570 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement572 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement574 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_57_in_statement587 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_statement589 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement591 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_58_in_statement602 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement604 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement606 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_59_in_statement617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement626 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement628 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_statement631 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement633 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement646 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement648 = new BitSet(new long[]{0x0000000000000820L});
    public static final BitSet FOLLOW_embedding_in_statement651 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement653 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement664 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement666 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement669 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement681 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement683 = new BitSet(new long[]{0x0ED1000000004030L});
    public static final BitSet FOLLOW_statement_in_statement686 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_52_in_ifStatement706 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_42_in_ifStatement708 = new BitSet(new long[]{0x10014000000003A0L});
    public static final BitSet FOLLOW_predicate_in_ifStatement710 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ifStatement712 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_53_in_ifStatement723 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_54_in_eachStatement763 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_42_in_eachStatement765 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_eachStatement767 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_eachStatement769 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_eachStatement773 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_eachStatement775 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_48_in_blockStatement801 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_blockStatement805 = new BitSet(new long[]{0x0ED3000000004010L});
    public static final BitSet FOLLOW_49_in_blockStatement812 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_55_in_letStatement840 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_assignment_in_letStatement842 = new BitSet(new long[]{0x0108000000000020L});
    public static final BitSet FOLLOW_56_in_letStatement845 = new BitSet(new long[]{0x0ED1000000014010L});
    public static final BitSet FOLLOW_statement_in_letStatement853 = new BitSet(new long[]{0x0ED1000000014010L});
    public static final BitSet FOLLOW_END_in_letStatement864 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_varBinding_in_assignment878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funcBinding_in_assignment882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_varBinding900 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_varBinding902 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_varBinding906 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_varBinding908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_funcBinding923 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_funcBinding927 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_formals_in_funcBinding929 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_END_in_funcBinding933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_predicate958 = new BitSet(new long[]{0x10014000000003A0L});
    public static final BitSet FOLLOW_predicate_in_predicate962 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate974 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate987 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_predicate989 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_type_in_predicate991 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_61_in_predicate1001 = new BitSet(new long[]{0x10014000000003A0L});
    public static final BitSet FOLLOW_predicate_in_predicate1005 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_62_in_predicate1011 = new BitSet(new long[]{0x10014000000003A0L});
    public static final BitSet FOLLOW_predicate_in_predicate1015 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding1053 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_embed_in_embedding1057 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_textTail_in_embedding1059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed1069 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_embed1072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed1082 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail1092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail1101 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_embed_in_textTail1105 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_textTail_in_textTail1107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_synpred20_WaebricInterpreter421 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_synpred20_WaebricInterpreter425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_synpred21_WaebricInterpreter435 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_synpred21_WaebricInterpreter439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_synpred30_WaebricInterpreter570 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_synpred30_WaebricInterpreter572 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred30_WaebricInterpreter574 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_57_in_synpred31_WaebricInterpreter587 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_synpred31_WaebricInterpreter589 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred31_WaebricInterpreter591 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_synpred35_WaebricInterpreter626 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred35_WaebricInterpreter628 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_synpred35_WaebricInterpreter631 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred35_WaebricInterpreter633 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_synpred37_WaebricInterpreter646 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred37_WaebricInterpreter648 = new BitSet(new long[]{0x0000000000000820L});
    public static final BitSet FOLLOW_embedding_in_synpred37_WaebricInterpreter651 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred37_WaebricInterpreter653 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_synpred39_WaebricInterpreter664 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred39_WaebricInterpreter666 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred39_WaebricInterpreter669 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_synpred47_WaebricInterpreter974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred48_WaebricInterpreter1001 = new BitSet(new long[]{0x10014000000003A0L});
    public static final BitSet FOLLOW_predicate_in_synpred48_WaebricInterpreter1005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_synpred49_WaebricInterpreter1011 = new BitSet(new long[]{0x10014000000003A0L});
    public static final BitSet FOLLOW_predicate_in_synpred49_WaebricInterpreter1015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred53_WaebricInterpreter1069 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_synpred53_WaebricInterpreter1072 = new BitSet(new long[]{0x0000000000000002L});

}