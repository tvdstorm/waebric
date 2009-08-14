// $ANTLR 3.1.2 /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g 2009-08-14 16:15:44

	package org.cwi.waebric;
	
	import java.io.IOException;
	import java.io.OutputStream;
	import java.text.SimpleDateFormat;
	
	import java.util.Date;
	import java.util.HashMap;
	import java.util.Map;
		
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
        Map<String, String> variables;
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
    	
    	// Base functions
    	public static Map<String, WaebricLoader.function_return> functions;

    	
    	/**
    	 * Interpret program
    	 * @param os: Output stream for interpreting main function
    	 */
    	public void interpretProgram(OutputStream os, WaebricLoader loader) throws RecognitionException {
    		this.functions = loader.getFunctions();
    		
    		this.document = new Document();
    		if(interpretFunction("main")) {
    			if(current != null) { outputDocument(document, os); }
    		}
    		
    		for(WaebricLoader.mapping_return mapping: loader.getMappings()) {
    			// TODO : Evaluate function and store in file
    		}
    	}
    	
    	/**
    	 * Interpret function
    	 * @param function: Function AST
    	 */
    	private boolean interpretFunction(String name) throws RecognitionException {
    		CommonTree function = getFunction(name);
    		if(function != null) {
    			WaebricInterpreter instance = new WaebricInterpreter(new CommonTreeNodeStream(function));
    			instance.function();
    			return true;
    		}
    		return false;
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
            			current = (Element) content;
        			}	
        		} else { // Add content to current element
    			current.addContent(content); // Attach content
    			if(content instanceof Element) { current = (Element) content; } // Update current
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
    		// Check local environments
    		for(int i=Environment_stack.size()-1; i>=0; i--) {
    			if(((Environment_scope)Environment_stack.elementAt(i)).functions.containsKey(name)) {
    				return ((Environment_scope)Environment_stack.elementAt(i)).functions.get(name); 
    			}
    		} 
    		
    		// Check base environment
    		return functions.containsKey(name) ? functions.get(name).tree : null ;
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
    	private String getVariable(String name) {
    		for(int i=Environment_stack.size()-1; i>=0; i--) {
    			if(((Environment_scope)Environment_stack.elementAt(i)).variables.containsKey(name)) {
    				return ((Environment_scope)Environment_stack.elementAt(i)).variables.get(name); 
    			}
    		} return "undef";
    	}
    	
    	/**
    	 * Define variable
    	 * @param name: Variable name
    	 * @param eval: Variable evaluation
    	 */
    	private void defineVariable(String name, String eval) {
    		((Environment_scope)Environment_stack.peek()).variables.put(name, eval);
    	}
    	
    	/**
    	 * Create new environment with cloned base
    	 */
    	private Stack newEnvironment() {
    		Stack env = new Stack();
    		env.push(Environment_stack.elementAt(0));
    		return env;
    	}
    	


    public static class site_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "site"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:179:1: site : 'site' mappings 'end' ;
    public final WaebricInterpreter.site_return site() throws RecognitionException {
        WaebricInterpreter.site_return retval = new WaebricInterpreter.site_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal1=null;
        CommonTree string_literal3=null;
        WaebricInterpreter.mappings_return mappings2 = null;


        CommonTree string_literal1_tree=null;
        CommonTree string_literal3_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:179:5: ( 'site' mappings 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:179:9: 'site' mappings 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal1=(CommonTree)match(input,SITE,FOLLOW_SITE_in_site71); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal1_tree = (CommonTree)adaptor.dupNode(string_literal1);

            adaptor.addChild(root_0, string_literal1_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_mappings_in_site73);
            mappings2=mappings();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, mappings2.getTree());
            _last = (CommonTree)input.LT(1);
            string_literal3=(CommonTree)match(input,END,FOLLOW_END_in_site75); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal3_tree = (CommonTree)adaptor.dupNode(string_literal3);

            adaptor.addChild(root_0, string_literal3_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:181:1: mappings : ( mapping )? ( ';' mapping )* ;
    public final WaebricInterpreter.mappings_return mappings() throws RecognitionException {
        WaebricInterpreter.mappings_return retval = new WaebricInterpreter.mappings_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal5=null;
        WaebricInterpreter.mapping_return mapping4 = null;

        WaebricInterpreter.mapping_return mapping6 = null;


        CommonTree char_literal5_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:181:9: ( ( mapping )? ( ';' mapping )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:181:12: ( mapping )? ( ';' mapping )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:181:12: ( mapping )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==PATH) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: mapping
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_mapping_in_mappings84);
                    mapping4=mapping();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, mapping4.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:181:21: ( ';' mapping )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==SEMICOLON) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:181:23: ';' mapping
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal5=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_mappings89); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal5_tree = (CommonTree)adaptor.dupNode(char_literal5);

            	    adaptor.addChild(root_0, char_literal5_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_mapping_in_mappings91);
            	    mapping6=mapping();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, mapping6.getTree());

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
    // $ANTLR end "mappings"

    public static class mapping_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mapping"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:183:1: mapping : PATH ':' markup ;
    public final WaebricInterpreter.mapping_return mapping() throws RecognitionException {
        WaebricInterpreter.mapping_return retval = new WaebricInterpreter.mapping_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PATH7=null;
        CommonTree char_literal8=null;
        WaebricInterpreter.markup_return markup9 = null;


        CommonTree PATH7_tree=null;
        CommonTree char_literal8_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:183:9: ( PATH ':' markup )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:183:12: PATH ':' markup
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PATH7=(CommonTree)match(input,PATH,FOLLOW_PATH_in_mapping104); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PATH7_tree = (CommonTree)adaptor.dupNode(PATH7);

            adaptor.addChild(root_0, PATH7_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal8=(CommonTree)match(input,37,FOLLOW_37_in_mapping106); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal8_tree = (CommonTree)adaptor.dupNode(char_literal8);

            adaptor.addChild(root_0, char_literal8_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_markup_in_mapping108);
            markup9=markup();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, markup9.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:188:1: markup : IDCON ( attribute )* ( arguments )? ;
    public final WaebricInterpreter.markup_return markup() throws RecognitionException {
        WaebricInterpreter.markup_return retval = new WaebricInterpreter.markup_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON10=null;
        WaebricInterpreter.attribute_return attribute11 = null;

        WaebricInterpreter.arguments_return arguments12 = null;


        CommonTree IDCON10_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:188:7: ( IDCON ( attribute )* ( arguments )? )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:188:11: IDCON ( attribute )* ( arguments )?
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON10=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_markup121); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON10_tree = (CommonTree)adaptor.dupNode(IDCON10);

            adaptor.addChild(root_0, IDCON10_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:188:17: ( attribute )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==35||(LA3_0>=37 && LA3_0<=40)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: attribute
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_attribute_in_markup123);
            	    attribute11=attribute();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, attribute11.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:188:28: ( arguments )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==42) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: arguments
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_arguments_in_markup126);
                    arguments12=arguments();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, arguments12.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              				if(! interpretFunction(IDCON10.getText())) {
              					addContent(new Element(IDCON10.getText())); 
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

    public static class attribute_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attribute"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:194:1: attribute : ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' w= NATCON ( '%' h= NATCON )? );
    public final WaebricInterpreter.attribute_return attribute() throws RecognitionException {
        WaebricInterpreter.attribute_return retval = new WaebricInterpreter.attribute_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree w=null;
        CommonTree h=null;
        CommonTree char_literal13=null;
        CommonTree IDCON14=null;
        CommonTree char_literal15=null;
        CommonTree IDCON16=null;
        CommonTree char_literal17=null;
        CommonTree IDCON18=null;
        CommonTree char_literal19=null;
        CommonTree IDCON20=null;
        CommonTree char_literal21=null;
        CommonTree char_literal22=null;

        CommonTree w_tree=null;
        CommonTree h_tree=null;
        CommonTree char_literal13_tree=null;
        CommonTree IDCON14_tree=null;
        CommonTree char_literal15_tree=null;
        CommonTree IDCON16_tree=null;
        CommonTree char_literal17_tree=null;
        CommonTree IDCON18_tree=null;
        CommonTree char_literal19_tree=null;
        CommonTree IDCON20_tree=null;
        CommonTree char_literal21_tree=null;
        CommonTree char_literal22_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:194:10: ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' w= NATCON ( '%' h= NATCON )? )
            int alt6=5;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt6=1;
                }
                break;
            case 35:
                {
                alt6=2;
                }
                break;
            case 39:
                {
                alt6=3;
                }
                break;
            case 37:
                {
                alt6=4;
                }
                break;
            case 40:
                {
                alt6=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:194:13: '#' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal13=(CommonTree)match(input,38,FOLLOW_38_in_attribute138); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal13_tree = (CommonTree)adaptor.dupNode(char_literal13);

                    adaptor.addChild(root_0, char_literal13_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON14=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute140); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON14_tree = (CommonTree)adaptor.dupNode(IDCON14);

                    adaptor.addChild(root_0, IDCON14_tree);
                    }
                    if ( state.backtracking==0 ) {
                       current.setAttribute("id", IDCON14.getText()); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:195:6: '.' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal15=(CommonTree)match(input,35,FOLLOW_35_in_attribute150); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal15_tree = (CommonTree)adaptor.dupNode(char_literal15);

                    adaptor.addChild(root_0, char_literal15_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON16=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute152); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON16_tree = (CommonTree)adaptor.dupNode(IDCON16);

                    adaptor.addChild(root_0, IDCON16_tree);
                    }
                    if ( state.backtracking==0 ) {
                       current.setAttribute("class", IDCON16.getText()); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:196:6: '$' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal17=(CommonTree)match(input,39,FOLLOW_39_in_attribute162); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal17_tree = (CommonTree)adaptor.dupNode(char_literal17);

                    adaptor.addChild(root_0, char_literal17_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON18=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute164); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON18_tree = (CommonTree)adaptor.dupNode(IDCON18);

                    adaptor.addChild(root_0, IDCON18_tree);
                    }
                    if ( state.backtracking==0 ) {
                       current.setAttribute("name", IDCON18.getText()); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:197:6: ':' IDCON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal19=(CommonTree)match(input,37,FOLLOW_37_in_attribute174); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal19_tree = (CommonTree)adaptor.dupNode(char_literal19);

                    adaptor.addChild(root_0, char_literal19_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    IDCON20=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute176); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON20_tree = (CommonTree)adaptor.dupNode(IDCON20);

                    adaptor.addChild(root_0, IDCON20_tree);
                    }
                    if ( state.backtracking==0 ) {
                       current.setAttribute("type", IDCON20.getText()); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:198:6: '@' w= NATCON ( '%' h= NATCON )?
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    char_literal21=(CommonTree)match(input,40,FOLLOW_40_in_attribute186); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal21_tree = (CommonTree)adaptor.dupNode(char_literal21);

                    adaptor.addChild(root_0, char_literal21_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    w=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_attribute190); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    w_tree = (CommonTree)adaptor.dupNode(w);

                    adaptor.addChild(root_0, w_tree);
                    }
                    if ( state.backtracking==0 ) {
                       current.setAttribute("width", w.getText()); 
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:199:5: ( '%' h= NATCON )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==41) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:199:7: '%' h= NATCON
                            {
                            _last = (CommonTree)input.LT(1);
                            char_literal22=(CommonTree)match(input,41,FOLLOW_41_in_attribute201); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal22_tree = (CommonTree)adaptor.dupNode(char_literal22);

                            adaptor.addChild(root_0, char_literal22_tree);
                            }
                            _last = (CommonTree)input.LT(1);
                            h=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_attribute205); if (state.failed) return retval;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:201:1: arguments : '(' ( argument )? ( ',' argument )* ')' ;
    public final WaebricInterpreter.arguments_return arguments() throws RecognitionException {
        WaebricInterpreter.arguments_return retval = new WaebricInterpreter.arguments_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal23=null;
        CommonTree char_literal25=null;
        CommonTree char_literal27=null;
        WaebricInterpreter.argument_return argument24 = null;

        WaebricInterpreter.argument_return argument26 = null;


        CommonTree char_literal23_tree=null;
        CommonTree char_literal25_tree=null;
        CommonTree char_literal27_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:201:10: ( '(' ( argument )? ( ',' argument )* ')' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:201:13: '(' ( argument )? ( ',' argument )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            char_literal23=(CommonTree)match(input,42,FOLLOW_42_in_arguments222); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal23_tree = (CommonTree)adaptor.dupNode(char_literal23);

            adaptor.addChild(root_0, char_literal23_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:201:17: ( argument )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==IDCON||(LA7_0>=NATCON && LA7_0<=SYMBOLCON)||LA7_0==46||LA7_0==48) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: argument
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_argument_in_arguments224);
                    argument24=argument();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, argument24.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:201:27: ( ',' argument )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==43) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:201:29: ',' argument
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal25=(CommonTree)match(input,43,FOLLOW_43_in_arguments229); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal25_tree = (CommonTree)adaptor.dupNode(char_literal25);

            	    adaptor.addChild(root_0, char_literal25_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_argument_in_arguments231);
            	    argument26=argument();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, argument26.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            char_literal27=(CommonTree)match(input,44,FOLLOW_44_in_arguments236); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal27_tree = (CommonTree)adaptor.dupNode(char_literal27);

            adaptor.addChild(root_0, char_literal27_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:203:1: argument : ( expression | IDCON '=' expression );
    public final WaebricInterpreter.argument_return argument() throws RecognitionException {
        WaebricInterpreter.argument_return retval = new WaebricInterpreter.argument_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON29=null;
        CommonTree char_literal30=null;
        WaebricInterpreter.expression_return expression28 = null;

        WaebricInterpreter.expression_return expression31 = null;


        CommonTree IDCON29_tree=null;
        CommonTree char_literal30_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:203:9: ( expression | IDCON '=' expression )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==IDCON) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==45) ) {
                    alt9=2;
                }
                else if ( (LA9_1==EOF||LA9_1==35||(LA9_1>=43 && LA9_1<=44)||LA9_1==50) ) {
                    alt9=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA9_0>=NATCON && LA9_0<=SYMBOLCON)||LA9_0==46||LA9_0==48) ) {
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:203:12: expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_argument245);
                    expression28=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression28.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:204:6: IDCON '=' expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDCON29=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_argument252); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON29_tree = (CommonTree)adaptor.dupNode(IDCON29);

                    adaptor.addChild(root_0, IDCON29_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal30=(CommonTree)match(input,45,FOLLOW_45_in_argument254); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal30_tree = (CommonTree)adaptor.dupNode(char_literal30);

                    adaptor.addChild(root_0, char_literal30_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_argument256);
                    expression31=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression31.getTree());
                    if ( state.backtracking==0 ) {
                       current.setAttribute(IDCON29.getText(), (expression31!=null?expression31.eval:null)); 
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
        public String eval;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:209:1: expression returns [String eval] : (var= IDCON | NATCON | TEXT | SYMBOLCON | listExpression | recordExpression ) ( '+' e= expression | '.' IDCON )* ;
    public final WaebricInterpreter.expression_return expression() throws RecognitionException {
        WaebricInterpreter.expression_return retval = new WaebricInterpreter.expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree var=null;
        CommonTree NATCON32=null;
        CommonTree TEXT33=null;
        CommonTree SYMBOLCON34=null;
        CommonTree char_literal37=null;
        CommonTree char_literal38=null;
        CommonTree IDCON39=null;
        WaebricInterpreter.expression_return e = null;

        WaebricInterpreter.listExpression_return listExpression35 = null;

        WaebricInterpreter.recordExpression_return recordExpression36 = null;


        CommonTree var_tree=null;
        CommonTree NATCON32_tree=null;
        CommonTree TEXT33_tree=null;
        CommonTree SYMBOLCON34_tree=null;
        CommonTree char_literal37_tree=null;
        CommonTree char_literal38_tree=null;
        CommonTree IDCON39_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:211:2: ( (var= IDCON | NATCON | TEXT | SYMBOLCON | listExpression | recordExpression ) ( '+' e= expression | '.' IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:211:6: (var= IDCON | NATCON | TEXT | SYMBOLCON | listExpression | recordExpression ) ( '+' e= expression | '.' IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:211:6: (var= IDCON | NATCON | TEXT | SYMBOLCON | listExpression | recordExpression )
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
            case 46:
                {
                alt10=5;
                }
                break;
            case 48:
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:211:8: var= IDCON
                    {
                    _last = (CommonTree)input.LT(1);
                    var=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression283); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    var_tree = (CommonTree)adaptor.dupNode(var);

                    adaptor.addChild(root_0, var_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.eval = getVariable(var.getText()); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:212:7: NATCON
                    {
                    _last = (CommonTree)input.LT(1);
                    NATCON32=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_expression293); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NATCON32_tree = (CommonTree)adaptor.dupNode(NATCON32);

                    adaptor.addChild(root_0, NATCON32_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.eval = NATCON32.getText(); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:213:7: TEXT
                    {
                    _last = (CommonTree)input.LT(1);
                    TEXT33=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_expression303); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TEXT33_tree = (CommonTree)adaptor.dupNode(TEXT33);

                    adaptor.addChild(root_0, TEXT33_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.eval = TEXT33.getText(); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:214:7: SYMBOLCON
                    {
                    _last = (CommonTree)input.LT(1);
                    SYMBOLCON34=(CommonTree)match(input,SYMBOLCON,FOLLOW_SYMBOLCON_in_expression313); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SYMBOLCON34_tree = (CommonTree)adaptor.dupNode(SYMBOLCON34);

                    adaptor.addChild(root_0, SYMBOLCON34_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.eval = SYMBOLCON34.getText(); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:215:7: listExpression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_listExpression_in_expression323);
                    listExpression35=listExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, listExpression35.getTree());
                    if ( state.backtracking==0 ) {
                       retval.eval = (listExpression35!=null?listExpression35.data:null).toString(); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:216:7: recordExpression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_recordExpression_in_expression333);
                    recordExpression36=recordExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, recordExpression36.getTree());
                    if ( state.backtracking==0 ) {
                       retval.eval = (recordExpression36!=null?recordExpression36.data:null).toString(); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:217:6: ( '+' e= expression | '.' IDCON )*
            loop11:
            do {
                int alt11=3;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==50) ) {
                    int LA11_2 = input.LA(2);

                    if ( (synpred18_WaebricInterpreter()) ) {
                        alt11=1;
                    }


                }
                else if ( (LA11_0==35) ) {
                    int LA11_3 = input.LA(2);

                    if ( (synpred19_WaebricInterpreter()) ) {
                        alt11=2;
                    }


                }


                switch (alt11) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:217:8: '+' e= expression
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal37=(CommonTree)match(input,50,FOLLOW_50_in_expression344); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal37_tree = (CommonTree)adaptor.dupNode(char_literal37);

            	    adaptor.addChild(root_0, char_literal37_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expression_in_expression348);
            	    e=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, e.getTree());
            	    if ( state.backtracking==0 ) {
            	       retval.eval += (e!=null?e.eval:null); 
            	    }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:217:49: '.' IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal38=(CommonTree)match(input,35,FOLLOW_35_in_expression354); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal38_tree = (CommonTree)adaptor.dupNode(char_literal38);

            	    adaptor.addChild(root_0, char_literal38_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    IDCON39=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression356); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDCON39_tree = (CommonTree)adaptor.dupNode(IDCON39);

            	    adaptor.addChild(root_0, IDCON39_tree);
            	    }
            	    if ( state.backtracking==0 ) {
            	       /* TODO: Field */ 
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

    public static class listExpression_return extends TreeRuleReturnScope {
        public List<String> data = new ArrayList<String>();
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "listExpression"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:219:1: listExpression returns [List<String> data = new ArrayList<String>()] : '[' (e= expression )? ( ',' e= expression )* ']' ;
    public final WaebricInterpreter.listExpression_return listExpression() throws RecognitionException {
        WaebricInterpreter.listExpression_return retval = new WaebricInterpreter.listExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal40=null;
        CommonTree char_literal41=null;
        CommonTree char_literal42=null;
        WaebricInterpreter.expression_return e = null;


        CommonTree char_literal40_tree=null;
        CommonTree char_literal41_tree=null;
        CommonTree char_literal42_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:221:2: ( '[' (e= expression )? ( ',' e= expression )* ']' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:221:6: '[' (e= expression )? ( ',' e= expression )* ']'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            char_literal40=(CommonTree)match(input,46,FOLLOW_46_in_listExpression382); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal40_tree = (CommonTree)adaptor.dupNode(char_literal40);

            adaptor.addChild(root_0, char_literal40_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:221:10: (e= expression )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==IDCON||(LA12_0>=NATCON && LA12_0<=SYMBOLCON)||LA12_0==46||LA12_0==48) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:221:12: e= expression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_listExpression388);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, e.getTree());
                    if ( state.backtracking==0 ) {
                       retval.data.add((e!=null?e.eval:null)); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:222:5: ( ',' e= expression )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==43) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:222:7: ',' e= expression
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal41=(CommonTree)match(input,43,FOLLOW_43_in_listExpression402); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal41_tree = (CommonTree)adaptor.dupNode(char_literal41);

            	    adaptor.addChild(root_0, char_literal41_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expression_in_listExpression406);
            	    e=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, e.getTree());
            	    if ( state.backtracking==0 ) {
            	       retval.data.add((e!=null?e.eval:null)); 
            	    }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            char_literal42=(CommonTree)match(input,47,FOLLOW_47_in_listExpression413); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal42_tree = (CommonTree)adaptor.dupNode(char_literal42);

            adaptor.addChild(root_0, char_literal42_tree);
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
    // $ANTLR end "listExpression"

    public static class recordExpression_return extends TreeRuleReturnScope {
        public Map<String, String> data = new HashMap<String, String>();
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "recordExpression"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:224:1: recordExpression returns [Map<String, String> data = new HashMap<String, String>()] : '{' (id= IDCON ':' e= expression )? ( ',' id= IDCON ':' e= expression )* '}' ;
    public final WaebricInterpreter.recordExpression_return recordExpression() throws RecognitionException {
        WaebricInterpreter.recordExpression_return retval = new WaebricInterpreter.recordExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        CommonTree char_literal43=null;
        CommonTree char_literal44=null;
        CommonTree char_literal45=null;
        CommonTree char_literal46=null;
        CommonTree char_literal47=null;
        WaebricInterpreter.expression_return e = null;


        CommonTree id_tree=null;
        CommonTree char_literal43_tree=null;
        CommonTree char_literal44_tree=null;
        CommonTree char_literal45_tree=null;
        CommonTree char_literal46_tree=null;
        CommonTree char_literal47_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:226:2: ( '{' (id= IDCON ':' e= expression )? ( ',' id= IDCON ':' e= expression )* '}' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:226:6: '{' (id= IDCON ':' e= expression )? ( ',' id= IDCON ':' e= expression )* '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            char_literal43=(CommonTree)match(input,48,FOLLOW_48_in_recordExpression434); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal43_tree = (CommonTree)adaptor.dupNode(char_literal43);

            adaptor.addChild(root_0, char_literal43_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:226:10: (id= IDCON ':' e= expression )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==IDCON) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:226:12: id= IDCON ':' e= expression
                    {
                    _last = (CommonTree)input.LT(1);
                    id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_recordExpression440); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    id_tree = (CommonTree)adaptor.dupNode(id);

                    adaptor.addChild(root_0, id_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal44=(CommonTree)match(input,37,FOLLOW_37_in_recordExpression442); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal44_tree = (CommonTree)adaptor.dupNode(char_literal44);

                    adaptor.addChild(root_0, char_literal44_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_recordExpression446);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, e.getTree());
                    if ( state.backtracking==0 ) {
                       retval.data.put(id.getText(), (e!=null?e.eval:null)); 
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:227:5: ( ',' id= IDCON ':' e= expression )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==43) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:227:7: ',' id= IDCON ':' e= expression
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal45=(CommonTree)match(input,43,FOLLOW_43_in_recordExpression460); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal45_tree = (CommonTree)adaptor.dupNode(char_literal45);

            	    adaptor.addChild(root_0, char_literal45_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_recordExpression464); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    id_tree = (CommonTree)adaptor.dupNode(id);

            	    adaptor.addChild(root_0, id_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    char_literal46=(CommonTree)match(input,37,FOLLOW_37_in_recordExpression466); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal46_tree = (CommonTree)adaptor.dupNode(char_literal46);

            	    adaptor.addChild(root_0, char_literal46_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expression_in_recordExpression470);
            	    e=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, e.getTree());
            	    if ( state.backtracking==0 ) {
            	       retval.data.put(id.getText(), (e!=null?e.eval:null)); 
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
            char_literal47=(CommonTree)match(input,49,FOLLOW_49_in_recordExpression477); if (state.failed) return retval;
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
    // $ANTLR end "recordExpression"

    public static class function_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:232:1: function : 'def' IDCON ( formals )? ( statement )* 'end' ;
    public final WaebricInterpreter.function_return function() throws RecognitionException {
        WaebricInterpreter.function_return retval = new WaebricInterpreter.function_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal48=null;
        CommonTree IDCON49=null;
        CommonTree string_literal52=null;
        WaebricInterpreter.formals_return formals50 = null;

        WaebricInterpreter.statement_return statement51 = null;


        CommonTree string_literal48_tree=null;
        CommonTree IDCON49_tree=null;
        CommonTree string_literal52_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:232:9: ( 'def' IDCON ( formals )? ( statement )* 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:232:12: 'def' IDCON ( formals )? ( statement )* 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal48=(CommonTree)match(input,51,FOLLOW_51_in_function489); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal48_tree = (CommonTree)adaptor.dupNode(string_literal48);

            adaptor.addChild(root_0, string_literal48_tree);
            }
            _last = (CommonTree)input.LT(1);
            IDCON49=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_function491); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON49_tree = (CommonTree)adaptor.dupNode(IDCON49);

            adaptor.addChild(root_0, IDCON49_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:232:24: ( formals )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==42) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: formals
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_formals_in_function493);
                    formals50=formals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, formals50.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:232:33: ( statement )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==MARKUP_STATEMENT||LA17_0==COMMENT||LA17_0==48||LA17_0==52||(LA17_0>=54 && LA17_0<=55)||(LA17_0>=57 && LA17_0<=59)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_function496);
            	    statement51=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, statement51.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            string_literal52=(CommonTree)match(input,END,FOLLOW_END_in_function499); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal52_tree = (CommonTree)adaptor.dupNode(string_literal52);

            adaptor.addChild(root_0, string_literal52_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:234:1: formals : '(' ( IDCON )* ')' ;
    public final WaebricInterpreter.formals_return formals() throws RecognitionException {
        WaebricInterpreter.formals_return retval = new WaebricInterpreter.formals_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal53=null;
        CommonTree IDCON54=null;
        CommonTree char_literal55=null;

        CommonTree char_literal53_tree=null;
        CommonTree IDCON54_tree=null;
        CommonTree char_literal55_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:234:8: ( '(' ( IDCON )* ')' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:234:11: '(' ( IDCON )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            char_literal53=(CommonTree)match(input,42,FOLLOW_42_in_formals508); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal53_tree = (CommonTree)adaptor.dupNode(char_literal53);

            adaptor.addChild(root_0, char_literal53_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:234:15: ( IDCON )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==IDCON) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    IDCON54=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_formals510); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDCON54_tree = (CommonTree)adaptor.dupNode(IDCON54);

            	    adaptor.addChild(root_0, IDCON54_tree);
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
            char_literal55=(CommonTree)match(input,44,FOLLOW_44_in_formals513); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal55_tree = (CommonTree)adaptor.dupNode(char_literal55);

            adaptor.addChild(root_0, char_literal55_tree);
            }
            if ( state.backtracking==0 ) {

              				// TODO: Store argument + called expression in variable env
              			
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:242:1: statement : ( ifStatement | eachStatement | letStatement | blockStatement | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) | ^( MARKUP_STATEMENT ( markup )+ ';' ) | ^( MARKUP_STATEMENT ( markup )+ s= statement ) );
    public final WaebricInterpreter.statement_return statement() throws RecognitionException {
        WaebricInterpreter.statement_return retval = new WaebricInterpreter.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal60=null;
        CommonTree STRCON61=null;
        CommonTree char_literal62=null;
        CommonTree string_literal63=null;
        CommonTree char_literal65=null;
        CommonTree string_literal66=null;
        CommonTree char_literal68=null;
        CommonTree string_literal69=null;
        CommonTree char_literal71=null;
        CommonTree string_literal72=null;
        CommonTree MARKUP_STATEMENT73=null;
        CommonTree char_literal76=null;
        CommonTree MARKUP_STATEMENT77=null;
        CommonTree char_literal80=null;
        CommonTree MARKUP_STATEMENT81=null;
        CommonTree char_literal83=null;
        CommonTree MARKUP_STATEMENT84=null;
        WaebricInterpreter.statement_return s = null;

        WaebricInterpreter.ifStatement_return ifStatement56 = null;

        WaebricInterpreter.eachStatement_return eachStatement57 = null;

        WaebricInterpreter.letStatement_return letStatement58 = null;

        WaebricInterpreter.blockStatement_return blockStatement59 = null;

        WaebricInterpreter.expression_return expression64 = null;

        WaebricInterpreter.embedding_return embedding67 = null;

        WaebricInterpreter.expression_return expression70 = null;

        WaebricInterpreter.markup_return markup74 = null;

        WaebricInterpreter.expression_return expression75 = null;

        WaebricInterpreter.markup_return markup78 = null;

        WaebricInterpreter.embedding_return embedding79 = null;

        WaebricInterpreter.markup_return markup82 = null;

        WaebricInterpreter.markup_return markup85 = null;


        CommonTree string_literal60_tree=null;
        CommonTree STRCON61_tree=null;
        CommonTree char_literal62_tree=null;
        CommonTree string_literal63_tree=null;
        CommonTree char_literal65_tree=null;
        CommonTree string_literal66_tree=null;
        CommonTree char_literal68_tree=null;
        CommonTree string_literal69_tree=null;
        CommonTree char_literal71_tree=null;
        CommonTree string_literal72_tree=null;
        CommonTree MARKUP_STATEMENT73_tree=null;
        CommonTree char_literal76_tree=null;
        CommonTree MARKUP_STATEMENT77_tree=null;
        CommonTree char_literal80_tree=null;
        CommonTree MARKUP_STATEMENT81_tree=null;
        CommonTree char_literal83_tree=null;
        CommonTree MARKUP_STATEMENT84_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:242:10: ( ifStatement | eachStatement | letStatement | blockStatement | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) | ^( MARKUP_STATEMENT ( markup )+ ';' ) | ^( MARKUP_STATEMENT ( markup )+ s= statement ) )
            int alt23=13;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:242:13: ifStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_ifStatement_in_statement528);
                    ifStatement56=ifStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, ifStatement56.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:243:6: eachStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_eachStatement_in_statement535);
                    eachStatement57=eachStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, eachStatement57.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:244:6: letStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_letStatement_in_statement542);
                    letStatement58=letStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, letStatement58.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:245:6: blockStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_blockStatement_in_statement549);
                    blockStatement59=blockStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, blockStatement59.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:246:6: ^( 'comment' STRCON ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal60=(CommonTree)match(input,COMMENT,FOLLOW_COMMENT_in_statement558); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal60_tree = (CommonTree)adaptor.dupNode(string_literal60);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal60_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    STRCON61=(CommonTree)match(input,STRCON,FOLLOW_STRCON_in_statement560); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRCON61_tree = (CommonTree)adaptor.dupNode(STRCON61);

                    adaptor.addChild(root_1, STRCON61_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal62=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement562); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal62_tree = (CommonTree)adaptor.dupNode(char_literal62);

                    adaptor.addChild(root_1, char_literal62_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                    if ( state.backtracking==0 ) {

                      					Comment comment = new Comment(STRCON61.getText());
                      					addContent(comment);
                      				
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:250:6: ^( 'echo' expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal63=(CommonTree)match(input,57,FOLLOW_57_in_statement575); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal63_tree = (CommonTree)adaptor.dupNode(string_literal63);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal63_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement577);
                    expression64=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression64.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal65=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement579); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal65_tree = (CommonTree)adaptor.dupNode(char_literal65);

                    adaptor.addChild(root_1, char_literal65_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                    if ( state.backtracking==0 ) {

                      					Text text = new Text((expression64!=null?expression64.eval:null));
                      					addContent(text);
                      				
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:254:6: ^( 'echo' embedding ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal66=(CommonTree)match(input,57,FOLLOW_57_in_statement592); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal66_tree = (CommonTree)adaptor.dupNode(string_literal66);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal66_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement594);
                    embedding67=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding67.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal68=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement596); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal68_tree = (CommonTree)adaptor.dupNode(char_literal68);

                    adaptor.addChild(root_1, char_literal68_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:255:6: ^( 'cdata' expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal69=(CommonTree)match(input,58,FOLLOW_58_in_statement607); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal69_tree = (CommonTree)adaptor.dupNode(string_literal69);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal69_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement609);
                    expression70=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression70.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal71=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement611); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal71_tree = (CommonTree)adaptor.dupNode(char_literal71);

                    adaptor.addChild(root_1, char_literal71_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                    if ( state.backtracking==0 ) {

                      					CDATA cdata = new CDATA((expression70!=null?expression70.eval:null));
                      					addContent(cdata);
                      				
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:259:6: 'yield;'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal72=(CommonTree)match(input,59,FOLLOW_59_in_statement622); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal72_tree = (CommonTree)adaptor.dupNode(string_literal72);

                    adaptor.addChild(root_0, string_literal72_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:260:6: ^( MARKUP_STATEMENT ( markup )+ expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT73=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement631); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT73_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT73);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT73_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:260:26: ( markup )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        alt19 = dfa19.predict(input);
                        switch (alt19) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement633);
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
                    pushFollow(FOLLOW_expression_in_statement636);
                    expression75=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression75.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal76=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement638); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal76_tree = (CommonTree)adaptor.dupNode(char_literal76);

                    adaptor.addChild(root_1, char_literal76_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                    if ( state.backtracking==0 ) {

                      					Text text = new Text((expression75!=null?expression75.eval:null));
                      					addContent(text);
                      				
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:264:6: ^( MARKUP_STATEMENT ( markup )+ embedding ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT77=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement651); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT77_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT77);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT77_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:264:26: ( markup )+
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
                    	    pushFollow(FOLLOW_markup_in_statement653);
                    	    markup78=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup78.getTree());

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
                    pushFollow(FOLLOW_embedding_in_statement656);
                    embedding79=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding79.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal80=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement658); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal80_tree = (CommonTree)adaptor.dupNode(char_literal80);

                    adaptor.addChild(root_1, char_literal80_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:265:6: ^( MARKUP_STATEMENT ( markup )+ ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT81=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement669); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT81_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT81);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT81_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:265:26: ( markup )+
                    int cnt21=0;
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==IDCON) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement671);
                    	    markup82=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup82.getTree());

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
                    char_literal83=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement674); if (state.failed) return retval;
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
                case 13 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:266:6: ^( MARKUP_STATEMENT ( markup )+ s= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT84=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement686); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT84_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT84);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT84_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:266:26: ( markup )+
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
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_statement688);
                    	    markup85=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup85.getTree());

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
                    pushFollow(FOLLOW_statement_in_statement693);
                    s=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, s.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:268:1: ifStatement : ^( 'if' '(' predicate ')' t= . ( 'else' f= . )? ) ;
    public final WaebricInterpreter.ifStatement_return ifStatement() throws RecognitionException {
        WaebricInterpreter.ifStatement_return retval = new WaebricInterpreter.ifStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal86=null;
        CommonTree char_literal87=null;
        CommonTree char_literal89=null;
        CommonTree string_literal90=null;
        CommonTree t=null;
        CommonTree f=null;
        WaebricInterpreter.predicate_return predicate88 = null;


        CommonTree string_literal86_tree=null;
        CommonTree char_literal87_tree=null;
        CommonTree char_literal89_tree=null;
        CommonTree string_literal90_tree=null;
        CommonTree t_tree=null;
        CommonTree f_tree=null;

         int ti = 0; int fi = 0; 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:270:2: ( ^( 'if' '(' predicate ')' t= . ( 'else' f= . )? ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:270:5: ^( 'if' '(' predicate ')' t= . ( 'else' f= . )? )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal86=(CommonTree)match(input,52,FOLLOW_52_in_ifStatement713); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal86_tree = (CommonTree)adaptor.dupNode(string_literal86);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal86_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            char_literal87=(CommonTree)match(input,42,FOLLOW_42_in_ifStatement715); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal87_tree = (CommonTree)adaptor.dupNode(char_literal87);

            adaptor.addChild(root_1, char_literal87_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_predicate_in_ifStatement717);
            predicate88=predicate();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, predicate88.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal89=(CommonTree)match(input,44,FOLLOW_44_in_ifStatement719); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal89_tree = (CommonTree)adaptor.dupNode(char_literal89);

            adaptor.addChild(root_1, char_literal89_tree);
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:270:60: ( 'else' f= . )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==53) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:270:62: 'else' f= .
                    {
                    _last = (CommonTree)input.LT(1);
                    string_literal90=(CommonTree)match(input,53,FOLLOW_53_in_ifStatement730); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal90_tree = (CommonTree)adaptor.dupNode(string_literal90);

                    adaptor.addChild(root_1, string_literal90_tree);
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
              				if((predicate88!=null?predicate88.eval:false)) {
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:283:1: eachStatement : ^( 'each' '(' IDCON ':' (l= listExpression | expression ) ')' . ) ;
    public final WaebricInterpreter.eachStatement_return eachStatement() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricInterpreter.eachStatement_return retval = new WaebricInterpreter.eachStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal91=null;
        CommonTree char_literal92=null;
        CommonTree IDCON93=null;
        CommonTree char_literal94=null;
        CommonTree char_literal96=null;
        CommonTree wildcard97=null;
        WaebricInterpreter.listExpression_return l = null;

        WaebricInterpreter.expression_return expression95 = null;


        CommonTree string_literal91_tree=null;
        CommonTree char_literal92_tree=null;
        CommonTree IDCON93_tree=null;
        CommonTree char_literal94_tree=null;
        CommonTree char_literal96_tree=null;
        CommonTree wildcard97_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new HashMap<String, String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, CommonTree>();
        		int start = 0;
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:289:4: ( ^( 'each' '(' IDCON ':' (l= listExpression | expression ) ')' . ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:289:7: ^( 'each' '(' IDCON ':' (l= listExpression | expression ) ')' . )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal91=(CommonTree)match(input,54,FOLLOW_54_in_eachStatement770); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal91_tree = (CommonTree)adaptor.dupNode(string_literal91);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal91_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            char_literal92=(CommonTree)match(input,42,FOLLOW_42_in_eachStatement772); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal92_tree = (CommonTree)adaptor.dupNode(char_literal92);

            adaptor.addChild(root_1, char_literal92_tree);
            }
            _last = (CommonTree)input.LT(1);
            IDCON93=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_eachStatement774); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON93_tree = (CommonTree)adaptor.dupNode(IDCON93);

            adaptor.addChild(root_1, IDCON93_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal94=(CommonTree)match(input,37,FOLLOW_37_in_eachStatement776); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal94_tree = (CommonTree)adaptor.dupNode(char_literal94);

            adaptor.addChild(root_1, char_literal94_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:289:31: (l= listExpression | expression )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==46) ) {
                int LA25_1 = input.LA(2);

                if ( (synpred44_WaebricInterpreter()) ) {
                    alt25=1;
                }
                else if ( (true) ) {
                    alt25=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA25_0==IDCON||(LA25_0>=NATCON && LA25_0<=SYMBOLCON)||LA25_0==48) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:289:33: l= listExpression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_listExpression_in_eachStatement782);
                    l=listExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, l.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:289:52: expression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_eachStatement786);
                    expression95=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression95.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            _last = (CommonTree)input.LT(1);
            char_literal96=(CommonTree)match(input,44,FOLLOW_44_in_eachStatement790); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal96_tree = (CommonTree)adaptor.dupNode(char_literal96);

            adaptor.addChild(root_1, char_literal96_tree);
            }
            if ( state.backtracking==0 ) {
               start = input.index(); 
            }
            _last = (CommonTree)input.LT(1);
            wildcard97=(CommonTree)input.LT(1);
            matchAny(input); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            wildcard97_tree = (CommonTree)adaptor.dupTree(wildcard97);
            adaptor.addChild(root_1, wildcard97_tree);
            }

            match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }

            if ( state.backtracking==0 ) {

              				if(l != null) {
              					int actualIndex = input.index();
                            				Element actualElement = this.current;
                            				for(String value: l.data) {
                            					((Environment_scope)Environment_stack.peek()).variables.put(IDCON93.getText(), value);
                            					input.seek(start);
                            					statement();
                            					input.seek(actualIndex);	
                            					if(actualElement == null) { actualElement = document.getRootElement(); }
                            					this.current = actualElement;
                            				}
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:304:1: blockStatement : ^( '{' (s= statement )* '}' ) ;
    public final WaebricInterpreter.blockStatement_return blockStatement() throws RecognitionException {
        WaebricInterpreter.blockStatement_return retval = new WaebricInterpreter.blockStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal98=null;
        CommonTree char_literal99=null;
        WaebricInterpreter.statement_return s = null;


        CommonTree char_literal98_tree=null;
        CommonTree char_literal99_tree=null;

         Element actual = this.current; 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:306:2: ( ^( '{' (s= statement )* '}' ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:306:5: ^( '{' (s= statement )* '}' )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            char_literal98=(CommonTree)match(input,48,FOLLOW_48_in_blockStatement816); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal98_tree = (CommonTree)adaptor.dupNode(char_literal98);

            root_1 = (CommonTree)adaptor.becomeRoot(char_literal98_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:306:12: (s= statement )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==MARKUP_STATEMENT||LA26_0==COMMENT||LA26_0==48||LA26_0==52||(LA26_0>=54 && LA26_0<=55)||(LA26_0>=57 && LA26_0<=59)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:306:14: s= statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_blockStatement822);
            	    s=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, s.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               this.current = actual; 
            }
            _last = (CommonTree)input.LT(1);
            char_literal99=(CommonTree)match(input,49,FOLLOW_49_in_blockStatement829); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal99_tree = (CommonTree)adaptor.dupNode(char_literal99);

            adaptor.addChild(root_1, char_literal99_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:308:1: letStatement : ^( 'let' ( assignment )+ 'in' (s= statement )* 'end' ) ;
    public final WaebricInterpreter.letStatement_return letStatement() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricInterpreter.letStatement_return retval = new WaebricInterpreter.letStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal100=null;
        CommonTree string_literal102=null;
        CommonTree string_literal103=null;
        WaebricInterpreter.statement_return s = null;

        WaebricInterpreter.assignment_return assignment101 = null;


        CommonTree string_literal100_tree=null;
        CommonTree string_literal102_tree=null;
        CommonTree string_literal103_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new HashMap<String, String>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, CommonTree>();
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:313:4: ( ^( 'let' ( assignment )+ 'in' (s= statement )* 'end' ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:313:7: ^( 'let' ( assignment )+ 'in' (s= statement )* 'end' )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal100=(CommonTree)match(input,55,FOLLOW_55_in_letStatement857); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal100_tree = (CommonTree)adaptor.dupNode(string_literal100);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal100_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:313:16: ( assignment )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==IDCON||LA27_0==51) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: assignment
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_assignment_in_letStatement859);
            	    assignment101=assignment();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, assignment101.getTree());

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
            string_literal102=(CommonTree)match(input,56,FOLLOW_56_in_letStatement862); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal102_tree = (CommonTree)adaptor.dupNode(string_literal102);

            adaptor.addChild(root_1, string_literal102_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:313:33: (s= statement )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==MARKUP_STATEMENT||LA28_0==COMMENT||LA28_0==48||LA28_0==52||(LA28_0>=54 && LA28_0<=55)||(LA28_0>=57 && LA28_0<=59)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:313:35: s= statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_letStatement868);
            	    s=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, s.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            string_literal103=(CommonTree)match(input,END,FOLLOW_END_in_letStatement873); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal103_tree = (CommonTree)adaptor.dupNode(string_literal103);

            adaptor.addChild(root_1, string_literal103_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:318:1: assignment : ( IDCON '=' expression ';' | funcBinding );
    public final WaebricInterpreter.assignment_return assignment() throws RecognitionException {
        WaebricInterpreter.assignment_return retval = new WaebricInterpreter.assignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON104=null;
        CommonTree char_literal105=null;
        CommonTree char_literal107=null;
        WaebricInterpreter.expression_return expression106 = null;

        WaebricInterpreter.funcBinding_return funcBinding108 = null;


        CommonTree IDCON104_tree=null;
        CommonTree char_literal105_tree=null;
        CommonTree char_literal107_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:318:11: ( IDCON '=' expression ';' | funcBinding )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==IDCON) ) {
                alt29=1;
            }
            else if ( (LA29_0==51) ) {
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:318:14: IDCON '=' expression ';'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    IDCON104=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_assignment887); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDCON104_tree = (CommonTree)adaptor.dupNode(IDCON104);

                    adaptor.addChild(root_0, IDCON104_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal105=(CommonTree)match(input,45,FOLLOW_45_in_assignment889); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal105_tree = (CommonTree)adaptor.dupNode(char_literal105);

                    adaptor.addChild(root_0, char_literal105_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_assignment891);
                    expression106=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression106.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal107=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_assignment893); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal107_tree = (CommonTree)adaptor.dupNode(char_literal107);

                    adaptor.addChild(root_0, char_literal107_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:319:6: funcBinding
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_funcBinding_in_assignment901);
                    funcBinding108=funcBinding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, funcBinding108.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:321:1: funcBinding : 'def' id= IDCON formals . 'end' ;
    public final WaebricInterpreter.funcBinding_return funcBinding() throws RecognitionException {
        WaebricInterpreter.funcBinding_return retval = new WaebricInterpreter.funcBinding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id=null;
        CommonTree string_literal109=null;
        CommonTree wildcard111=null;
        CommonTree string_literal112=null;
        WaebricInterpreter.formals_return formals110 = null;


        CommonTree id_tree=null;
        CommonTree string_literal109_tree=null;
        CommonTree wildcard111_tree=null;
        CommonTree string_literal112_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:322:2: ( 'def' id= IDCON formals . 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:322:5: 'def' id= IDCON formals . 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal109=(CommonTree)match(input,51,FOLLOW_51_in_funcBinding915); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal109_tree = (CommonTree)adaptor.dupNode(string_literal109);

            adaptor.addChild(root_0, string_literal109_tree);
            }
            _last = (CommonTree)input.LT(1);
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_funcBinding919); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            id_tree = (CommonTree)adaptor.dupNode(id);

            adaptor.addChild(root_0, id_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_formals_in_funcBinding921);
            formals110=formals();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, formals110.getTree());
            _last = (CommonTree)input.LT(1);
            wildcard111=(CommonTree)input.LT(1);
            matchAny(input); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            wildcard111_tree = (CommonTree)adaptor.dupTree(wildcard111);
            adaptor.addChild(root_0, wildcard111_tree);
            }
            _last = (CommonTree)input.LT(1);
            string_literal112=(CommonTree)match(input,END,FOLLOW_END_in_funcBinding925); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal112_tree = (CommonTree)adaptor.dupNode(string_literal112);

            adaptor.addChild(root_0, string_literal112_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:330:1: predicate returns [boolean eval] : ( '!' p= predicate | e= expression | e= expression '.' type ) ( '&&' p= predicate | '||' p= predicate )* ;
    public final WaebricInterpreter.predicate_return predicate() throws RecognitionException {
        WaebricInterpreter.predicate_return retval = new WaebricInterpreter.predicate_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal113=null;
        CommonTree char_literal114=null;
        CommonTree string_literal116=null;
        CommonTree string_literal117=null;
        WaebricInterpreter.predicate_return p = null;

        WaebricInterpreter.expression_return e = null;

        WaebricInterpreter.type_return type115 = null;


        CommonTree char_literal113_tree=null;
        CommonTree char_literal114_tree=null;
        CommonTree string_literal116_tree=null;
        CommonTree string_literal117_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:331:2: ( ( '!' p= predicate | e= expression | e= expression '.' type ) ( '&&' p= predicate | '||' p= predicate )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:331:5: ( '!' p= predicate | e= expression | e= expression '.' type ) ( '&&' p= predicate | '||' p= predicate )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:331:5: ( '!' p= predicate | e= expression | e= expression '.' type )
            int alt30=3;
            alt30 = dfa30.predict(input);
            switch (alt30) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:331:7: '!' p= predicate
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal113=(CommonTree)match(input,60,FOLLOW_60_in_predicate951); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal113_tree = (CommonTree)adaptor.dupNode(char_literal113);

                    adaptor.addChild(root_0, char_literal113_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_predicate955);
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:332:7: e= expression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate967);
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:333:7: e= expression '.' type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate980);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, e.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal114=(CommonTree)match(input,35,FOLLOW_35_in_predicate982); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal114_tree = (CommonTree)adaptor.dupNode(char_literal114);

                    adaptor.addChild(root_0, char_literal114_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_predicate984);
                    type115=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, type115.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:334:6: ( '&&' p= predicate | '||' p= predicate )*
            loop31:
            do {
                int alt31=3;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==61) ) {
                    int LA31_2 = input.LA(2);

                    if ( (synpred51_WaebricInterpreter()) ) {
                        alt31=1;
                    }


                }
                else if ( (LA31_0==62) ) {
                    int LA31_3 = input.LA(2);

                    if ( (synpred52_WaebricInterpreter()) ) {
                        alt31=2;
                    }


                }


                switch (alt31) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:334:8: '&&' p= predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal116=(CommonTree)match(input,61,FOLLOW_61_in_predicate994); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal116_tree = (CommonTree)adaptor.dupNode(string_literal116);

            	    adaptor.addChild(root_0, string_literal116_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate998);
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
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:334:57: '||' p= predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal117=(CommonTree)match(input,62,FOLLOW_62_in_predicate1004); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal117_tree = (CommonTree)adaptor.dupNode(string_literal117);

            	    adaptor.addChild(root_0, string_literal117_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate1008);
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
            	    break loop31;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:336:1: type : ( 'list' | 'record' | 'string' );
    public final WaebricInterpreter.type_return type() throws RecognitionException {
        WaebricInterpreter.type_return retval = new WaebricInterpreter.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set118=null;

        CommonTree set118_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:336:5: ( 'list' | 'record' | 'string' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            set118=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=63 && input.LA(1)<=65) ) {
                input.consume();

                if ( state.backtracking==0 ) {
                set118_tree = (CommonTree)adaptor.dupNode(set118);

                adaptor.addChild(root_0, set118_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:341:1: embedding : PRETEXT embed textTail ;
    public final WaebricInterpreter.embedding_return embedding() throws RecognitionException {
        WaebricInterpreter.embedding_return retval = new WaebricInterpreter.embedding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PRETEXT119=null;
        WaebricInterpreter.embed_return embed120 = null;

        WaebricInterpreter.textTail_return textTail121 = null;


        CommonTree PRETEXT119_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:341:10: ( PRETEXT embed textTail )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:341:13: PRETEXT embed textTail
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PRETEXT119=(CommonTree)match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding1046); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRETEXT119_tree = (CommonTree)adaptor.dupNode(PRETEXT119);

            adaptor.addChild(root_0, PRETEXT119_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_embed_in_embedding1048);
            embed120=embed();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, embed120.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_textTail_in_embedding1050);
            textTail121=textTail();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, textTail121.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:343:1: embed : ( ( markup )* expression | ( markup )* markup );
    public final WaebricInterpreter.embed_return embed() throws RecognitionException {
        WaebricInterpreter.embed_return retval = new WaebricInterpreter.embed_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricInterpreter.markup_return markup122 = null;

        WaebricInterpreter.expression_return expression123 = null;

        WaebricInterpreter.markup_return markup124 = null;

        WaebricInterpreter.markup_return markup125 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:343:6: ( ( markup )* expression | ( markup )* markup )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==IDCON) ) {
                int LA34_1 = input.LA(2);

                if ( (synpred56_WaebricInterpreter()) ) {
                    alt34=1;
                }
                else if ( (true) ) {
                    alt34=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 34, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA34_0>=NATCON && LA34_0<=SYMBOLCON)||LA34_0==46||LA34_0==48) ) {
                alt34=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:343:10: ( markup )* expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:343:10: ( markup )*
                    loop32:
                    do {
                        int alt32=2;
                        alt32 = dfa32.predict(input);
                        switch (alt32) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed1060);
                    	    markup122=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup122.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_embed1063);
                    expression123=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression123.getTree());
                    if ( state.backtracking==0 ) {
                       
                      					Text text = new Text((expression123!=null?expression123.eval:null));
                      					addContent(text); 
                      				
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:347:6: ( markup )* markup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:347:6: ( markup )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==IDCON) ) {
                            int LA33_1 = input.LA(2);

                            if ( (synpred57_WaebricInterpreter()) ) {
                                alt33=1;
                            }


                        }


                        switch (alt33) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed1073);
                    	    markup124=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup124.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_markup_in_embed1076);
                    markup125=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, markup125.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:349:1: textTail : ( POSTTEXT | MIDTEXT embed textTail );
    public final WaebricInterpreter.textTail_return textTail() throws RecognitionException {
        WaebricInterpreter.textTail_return retval = new WaebricInterpreter.textTail_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POSTTEXT126=null;
        CommonTree MIDTEXT127=null;
        WaebricInterpreter.embed_return embed128 = null;

        WaebricInterpreter.textTail_return textTail129 = null;


        CommonTree POSTTEXT126_tree=null;
        CommonTree MIDTEXT127_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:349:9: ( POSTTEXT | MIDTEXT embed textTail )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==POSTTEXT) ) {
                alt35=1;
            }
            else if ( (LA35_0==MIDTEXT) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:349:12: POSTTEXT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    POSTTEXT126=(CommonTree)match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail1085); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    POSTTEXT126_tree = (CommonTree)adaptor.dupNode(POSTTEXT126);

                    adaptor.addChild(root_0, POSTTEXT126_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:349:23: MIDTEXT embed textTail
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    MIDTEXT127=(CommonTree)match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail1089); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MIDTEXT127_tree = (CommonTree)adaptor.dupNode(MIDTEXT127);

                    adaptor.addChild(root_0, MIDTEXT127_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embed_in_textTail1091);
                    embed128=embed();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, embed128.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_textTail_in_textTail1093);
                    textTail129=textTail();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, textTail129.getTree());

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


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:217:8: ( '+' e= expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:217:8: '+' e= expression
        {
        match(input,50,FOLLOW_50_in_synpred18_WaebricInterpreter344); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred18_WaebricInterpreter348);
        e=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_WaebricInterpreter

    // $ANTLR start synpred19_WaebricInterpreter
    public final void synpred19_WaebricInterpreter_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:217:49: ( '.' IDCON )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:217:49: '.' IDCON
        {
        match(input,35,FOLLOW_35_in_synpred19_WaebricInterpreter354); if (state.failed) return ;
        match(input,IDCON,FOLLOW_IDCON_in_synpred19_WaebricInterpreter356); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_WaebricInterpreter

    // $ANTLR start synpred32_WaebricInterpreter
    public final void synpred32_WaebricInterpreter_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:250:6: ( ^( 'echo' expression ';' ) )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:250:6: ^( 'echo' expression ';' )
        {
        match(input,57,FOLLOW_57_in_synpred32_WaebricInterpreter575); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred32_WaebricInterpreter577);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred32_WaebricInterpreter579); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_WaebricInterpreter

    // $ANTLR start synpred33_WaebricInterpreter
    public final void synpred33_WaebricInterpreter_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:254:6: ( ^( 'echo' embedding ';' ) )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:254:6: ^( 'echo' embedding ';' )
        {
        match(input,57,FOLLOW_57_in_synpred33_WaebricInterpreter592); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_embedding_in_synpred33_WaebricInterpreter594);
        embedding();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred33_WaebricInterpreter596); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred33_WaebricInterpreter

    // $ANTLR start synpred37_WaebricInterpreter
    public final void synpred37_WaebricInterpreter_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:260:6: ( ^( MARKUP_STATEMENT ( markup )+ expression ';' ) )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:260:6: ^( MARKUP_STATEMENT ( markup )+ expression ';' )
        {
        match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_synpred37_WaebricInterpreter631); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:260:26: ( markup )+
        int cnt36=0;
        loop36:
        do {
            int alt36=2;
            alt36 = dfa36.predict(input);
            switch (alt36) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred37_WaebricInterpreter633);
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

        pushFollow(FOLLOW_expression_in_synpred37_WaebricInterpreter636);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred37_WaebricInterpreter638); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred37_WaebricInterpreter

    // $ANTLR start synpred39_WaebricInterpreter
    public final void synpred39_WaebricInterpreter_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:264:6: ( ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:264:6: ^( MARKUP_STATEMENT ( markup )+ embedding ';' )
        {
        match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_synpred39_WaebricInterpreter651); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:264:26: ( markup )+
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
        	    pushFollow(FOLLOW_markup_in_synpred39_WaebricInterpreter653);
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

        pushFollow(FOLLOW_embedding_in_synpred39_WaebricInterpreter656);
        embedding();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred39_WaebricInterpreter658); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_WaebricInterpreter

    // $ANTLR start synpred41_WaebricInterpreter
    public final void synpred41_WaebricInterpreter_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:265:6: ( ^( MARKUP_STATEMENT ( markup )+ ';' ) )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:265:6: ^( MARKUP_STATEMENT ( markup )+ ';' )
        {
        match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_synpred41_WaebricInterpreter669); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:265:26: ( markup )+
        int cnt38=0;
        loop38:
        do {
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==IDCON) ) {
                alt38=1;
            }


            switch (alt38) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred41_WaebricInterpreter671);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt38 >= 1 ) break loop38;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(38, input);
                    throw eee;
            }
            cnt38++;
        } while (true);

        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred41_WaebricInterpreter674); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred41_WaebricInterpreter

    // $ANTLR start synpred44_WaebricInterpreter
    public final void synpred44_WaebricInterpreter_fragment() throws RecognitionException {   
        WaebricInterpreter.listExpression_return l = null;


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:289:33: (l= listExpression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:289:33: l= listExpression
        {
        pushFollow(FOLLOW_listExpression_in_synpred44_WaebricInterpreter782);
        l=listExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred44_WaebricInterpreter

    // $ANTLR start synpred50_WaebricInterpreter
    public final void synpred50_WaebricInterpreter_fragment() throws RecognitionException {   
        WaebricInterpreter.expression_return e = null;


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:332:7: (e= expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:332:7: e= expression
        {
        pushFollow(FOLLOW_expression_in_synpred50_WaebricInterpreter967);
        e=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred50_WaebricInterpreter

    // $ANTLR start synpred51_WaebricInterpreter
    public final void synpred51_WaebricInterpreter_fragment() throws RecognitionException {   
        WaebricInterpreter.predicate_return p = null;


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:334:8: ( '&&' p= predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:334:8: '&&' p= predicate
        {
        match(input,61,FOLLOW_61_in_synpred51_WaebricInterpreter994); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred51_WaebricInterpreter998);
        p=predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred51_WaebricInterpreter

    // $ANTLR start synpred52_WaebricInterpreter
    public final void synpred52_WaebricInterpreter_fragment() throws RecognitionException {   
        WaebricInterpreter.predicate_return p = null;


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:334:57: ( '||' p= predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:334:57: '||' p= predicate
        {
        match(input,62,FOLLOW_62_in_synpred52_WaebricInterpreter1004); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred52_WaebricInterpreter1008);
        p=predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred52_WaebricInterpreter

    // $ANTLR start synpred56_WaebricInterpreter
    public final void synpred56_WaebricInterpreter_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:343:10: ( ( markup )* expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:343:10: ( markup )* expression
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:343:10: ( markup )*
        loop39:
        do {
            int alt39=2;
            alt39 = dfa39.predict(input);
            switch (alt39) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred56_WaebricInterpreter1060);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop39;
            }
        } while (true);

        pushFollow(FOLLOW_expression_in_synpred56_WaebricInterpreter1063);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred56_WaebricInterpreter

    // $ANTLR start synpred57_WaebricInterpreter
    public final void synpred57_WaebricInterpreter_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:347:6: ( markup )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:347:6: markup
        {
        pushFollow(FOLLOW_markup_in_synpred57_WaebricInterpreter1073);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred57_WaebricInterpreter

    // Delegated rules

    public final boolean synpred52_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred52_WaebricInterpreter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_WaebricInterpreter_fragment(); // can never throw exception
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
    public final boolean synpred57_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred57_WaebricInterpreter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_WaebricInterpreter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred41_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred41_WaebricInterpreter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred50_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred50_WaebricInterpreter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred56_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred56_WaebricInterpreter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred51_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred51_WaebricInterpreter_fragment(); // can never throw exception
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


    protected DFA23 dfa23 = new DFA23(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA36 dfa36 = new DFA36(this);
    protected DFA39 dfa39 = new DFA39(this);
    static final String DFA23_eotS =
        "\20\uffff";
    static final String DFA23_eofS =
        "\20\uffff";
    static final String DFA23_minS =
        "\1\4\5\uffff\1\0\2\uffff\1\0\6\uffff";
    static final String DFA23_maxS =
        "\1\73\5\uffff\1\0\2\uffff\1\0\6\uffff";
    static final String DFA23_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\11\1\uffff\1\6\1\7\1"+
        "\12\1\13\1\14\1\15";
    static final String DFA23_specialS =
        "\6\uffff\1\0\2\uffff\1\1\6\uffff}>";
    static final String[] DFA23_transitionS = {
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
            return "242:1: statement : ( ifStatement | eachStatement | letStatement | blockStatement | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) | ^( MARKUP_STATEMENT ( markup )+ ';' ) | ^( MARKUP_STATEMENT ( markup )+ s= statement ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TreeNodeStream input = (TreeNodeStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_6 = input.LA(1);

                         
                        int index23_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_WaebricInterpreter()) ) {s = 10;}

                        else if ( (synpred33_WaebricInterpreter()) ) {s = 11;}

                         
                        input.seek(index23_6);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA23_9 = input.LA(1);

                         
                        int index23_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_WaebricInterpreter()) ) {s = 12;}

                        else if ( (synpred39_WaebricInterpreter()) ) {s = 13;}

                        else if ( (synpred41_WaebricInterpreter()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index23_9);
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
    static final String DFA19_eotS =
        "\6\uffff";
    static final String DFA19_eofS =
        "\6\uffff";
    static final String DFA19_minS =
        "\2\5\1\uffff\1\5\1\uffff\1\5";
    static final String DFA19_maxS =
        "\1\60\1\62\1\uffff\1\5\1\uffff\1\62";
    static final String DFA19_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String DFA19_specialS =
        "\6\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\1\1\uffff\3\2\44\uffff\1\2\1\uffff\1\2",
            "\1\4\1\uffff\3\4\7\uffff\1\2\21\uffff\1\3\1\uffff\4\4\1\uffff"+
            "\1\4\3\uffff\1\4\1\uffff\1\4\1\uffff\1\2",
            "",
            "\1\5",
            "",
            "\1\4\1\uffff\3\4\7\uffff\1\2\21\uffff\1\3\1\uffff\4\4\1\uffff"+
            "\1\4\3\uffff\1\4\1\uffff\1\4\1\uffff\1\2"
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
            return "()+ loopback of 260:26: ( markup )+";
        }
    }
    static final String DFA30_eotS =
        "\12\uffff";
    static final String DFA30_eofS =
        "\12\uffff";
    static final String DFA30_minS =
        "\1\5\1\uffff\6\0\2\uffff";
    static final String DFA30_maxS =
        "\1\74\1\uffff\6\0\2\uffff";
    static final String DFA30_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\1\3";
    static final String DFA30_specialS =
        "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\2\uffff}>";
    static final String[] DFA30_transitionS = {
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

    static final short[] DFA30_eot = DFA.unpackEncodedString(DFA30_eotS);
    static final short[] DFA30_eof = DFA.unpackEncodedString(DFA30_eofS);
    static final char[] DFA30_min = DFA.unpackEncodedStringToUnsignedChars(DFA30_minS);
    static final char[] DFA30_max = DFA.unpackEncodedStringToUnsignedChars(DFA30_maxS);
    static final short[] DFA30_accept = DFA.unpackEncodedString(DFA30_acceptS);
    static final short[] DFA30_special = DFA.unpackEncodedString(DFA30_specialS);
    static final short[][] DFA30_transition;

    static {
        int numStates = DFA30_transitionS.length;
        DFA30_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA30_transition[i] = DFA.unpackEncodedString(DFA30_transitionS[i]);
        }
    }

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = DFA30_eot;
            this.eof = DFA30_eof;
            this.min = DFA30_min;
            this.max = DFA30_max;
            this.accept = DFA30_accept;
            this.special = DFA30_special;
            this.transition = DFA30_transition;
        }
        public String getDescription() {
            return "331:5: ( '!' p= predicate | e= expression | e= expression '.' type )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TreeNodeStream input = (TreeNodeStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA30_2 = input.LA(1);

                         
                        int index30_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index30_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA30_3 = input.LA(1);

                         
                        int index30_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index30_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA30_4 = input.LA(1);

                         
                        int index30_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index30_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA30_5 = input.LA(1);

                         
                        int index30_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index30_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA30_6 = input.LA(1);

                         
                        int index30_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index30_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA30_7 = input.LA(1);

                         
                        int index30_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index30_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 30, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA32_eotS =
        "\6\uffff";
    static final String DFA32_eofS =
        "\6\uffff";
    static final String DFA32_minS =
        "\2\5\2\uffff\2\5";
    static final String DFA32_maxS =
        "\1\60\1\62\2\uffff\1\5\1\62";
    static final String DFA32_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA32_specialS =
        "\6\uffff}>";
    static final String[] DFA32_transitionS = {
            "\1\1\1\uffff\3\2\44\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\2\uffff\2\2\25\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\3\uffff\1\3\1\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\2\uffff\2\2\25\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\3\uffff\1\3\1\uffff\1\3\1\uffff\1\2"
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
            return "()* loopback of 343:10: ( markup )*";
        }
    }
    static final String DFA36_eotS =
        "\6\uffff";
    static final String DFA36_eofS =
        "\6\uffff";
    static final String DFA36_minS =
        "\2\5\1\uffff\1\5\1\uffff\1\5";
    static final String DFA36_maxS =
        "\1\60\1\62\1\uffff\1\5\1\uffff\1\62";
    static final String DFA36_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String DFA36_specialS =
        "\6\uffff}>";
    static final String[] DFA36_transitionS = {
            "\1\1\1\uffff\3\2\44\uffff\1\2\1\uffff\1\2",
            "\1\4\1\uffff\3\4\7\uffff\1\2\21\uffff\1\3\1\uffff\4\4\1\uffff"+
            "\1\4\3\uffff\1\4\1\uffff\1\4\1\uffff\1\2",
            "",
            "\1\5",
            "",
            "\1\4\1\uffff\3\4\7\uffff\1\2\21\uffff\1\3\1\uffff\4\4\1\uffff"+
            "\1\4\3\uffff\1\4\1\uffff\1\4\1\uffff\1\2"
    };

    static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
    static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
    static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
    static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
    static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
    static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
    static final short[][] DFA36_transition;

    static {
        int numStates = DFA36_transitionS.length;
        DFA36_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = DFA36_eot;
            this.eof = DFA36_eof;
            this.min = DFA36_min;
            this.max = DFA36_max;
            this.accept = DFA36_accept;
            this.special = DFA36_special;
            this.transition = DFA36_transition;
        }
        public String getDescription() {
            return "()+ loopback of 260:26: ( markup )+";
        }
    }
    static final String DFA39_eotS =
        "\6\uffff";
    static final String DFA39_eofS =
        "\1\uffff\1\2\3\uffff\1\2";
    static final String DFA39_minS =
        "\2\5\2\uffff\2\5";
    static final String DFA39_maxS =
        "\1\60\1\62\2\uffff\1\5\1\62";
    static final String DFA39_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA39_specialS =
        "\6\uffff}>";
    static final String[] DFA39_transitionS = {
            "\1\1\1\uffff\3\2\44\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\31\uffff\1\4\1\uffff\4\3\1\uffff\1\3\3\uffff"+
            "\1\3\1\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\31\uffff\1\4\1\uffff\4\3\1\uffff\1\3\3\uffff"+
            "\1\3\1\uffff\1\3\1\uffff\1\2"
    };

    static final short[] DFA39_eot = DFA.unpackEncodedString(DFA39_eotS);
    static final short[] DFA39_eof = DFA.unpackEncodedString(DFA39_eofS);
    static final char[] DFA39_min = DFA.unpackEncodedStringToUnsignedChars(DFA39_minS);
    static final char[] DFA39_max = DFA.unpackEncodedStringToUnsignedChars(DFA39_maxS);
    static final short[] DFA39_accept = DFA.unpackEncodedString(DFA39_acceptS);
    static final short[] DFA39_special = DFA.unpackEncodedString(DFA39_specialS);
    static final short[][] DFA39_transition;

    static {
        int numStates = DFA39_transitionS.length;
        DFA39_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA39_transition[i] = DFA.unpackEncodedString(DFA39_transitionS[i]);
        }
    }

    class DFA39 extends DFA {

        public DFA39(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 39;
            this.eot = DFA39_eot;
            this.eof = DFA39_eof;
            this.min = DFA39_min;
            this.max = DFA39_max;
            this.accept = DFA39_accept;
            this.special = DFA39_special;
            this.transition = DFA39_transition;
        }
        public String getDescription() {
            return "()* loopback of 343:10: ( markup )*";
        }
    }
 

    public static final BitSet FOLLOW_SITE_in_site71 = new BitSet(new long[]{0x0000000000030040L});
    public static final BitSet FOLLOW_mappings_in_site73 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_END_in_site75 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapping_in_mappings84 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_SEMICOLON_in_mappings89 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_mapping_in_mappings91 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_PATH_in_mapping104 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_mapping106 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_markup_in_mapping108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_markup121 = new BitSet(new long[]{0x000005E800000002L});
    public static final BitSet FOLLOW_attribute_in_markup123 = new BitSet(new long[]{0x000005E800000002L});
    public static final BitSet FOLLOW_arguments_in_markup126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_attribute138 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_attribute140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_attribute150 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_attribute152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_attribute162 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_attribute164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_attribute174 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_attribute176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_attribute186 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NATCON_in_attribute190 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_attribute201 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NATCON_in_attribute205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_arguments222 = new BitSet(new long[]{0x00015800000003A0L});
    public static final BitSet FOLLOW_argument_in_arguments224 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_43_in_arguments229 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_argument_in_arguments231 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_44_in_arguments236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_argument245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_argument252 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_argument254 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_argument256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_expression283 = new BitSet(new long[]{0x0004000800000002L});
    public static final BitSet FOLLOW_NATCON_in_expression293 = new BitSet(new long[]{0x0004000800000002L});
    public static final BitSet FOLLOW_TEXT_in_expression303 = new BitSet(new long[]{0x0004000800000002L});
    public static final BitSet FOLLOW_SYMBOLCON_in_expression313 = new BitSet(new long[]{0x0004000800000002L});
    public static final BitSet FOLLOW_listExpression_in_expression323 = new BitSet(new long[]{0x0004000800000002L});
    public static final BitSet FOLLOW_recordExpression_in_expression333 = new BitSet(new long[]{0x0004000800000002L});
    public static final BitSet FOLLOW_50_in_expression344 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_expression348 = new BitSet(new long[]{0x0004000800000002L});
    public static final BitSet FOLLOW_35_in_expression354 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_expression356 = new BitSet(new long[]{0x0004000800000002L});
    public static final BitSet FOLLOW_46_in_listExpression382 = new BitSet(new long[]{0x0001C800000003A0L});
    public static final BitSet FOLLOW_expression_in_listExpression388 = new BitSet(new long[]{0x0000880000000000L});
    public static final BitSet FOLLOW_43_in_listExpression402 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_listExpression406 = new BitSet(new long[]{0x0000880000000000L});
    public static final BitSet FOLLOW_47_in_listExpression413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_recordExpression434 = new BitSet(new long[]{0x0002080000000020L});
    public static final BitSet FOLLOW_IDCON_in_recordExpression440 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_recordExpression442 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_recordExpression446 = new BitSet(new long[]{0x0002080000000000L});
    public static final BitSet FOLLOW_43_in_recordExpression460 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_recordExpression464 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_recordExpression466 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_recordExpression470 = new BitSet(new long[]{0x0002080000000000L});
    public static final BitSet FOLLOW_49_in_recordExpression477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_function489 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_function491 = new BitSet(new long[]{0x0ED1040000014010L});
    public static final BitSet FOLLOW_formals_in_function493 = new BitSet(new long[]{0x0ED1000000014010L});
    public static final BitSet FOLLOW_statement_in_function496 = new BitSet(new long[]{0x0ED1000000014010L});
    public static final BitSet FOLLOW_END_in_function499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_formals508 = new BitSet(new long[]{0x0000100000000020L});
    public static final BitSet FOLLOW_IDCON_in_formals510 = new BitSet(new long[]{0x0000100000000020L});
    public static final BitSet FOLLOW_44_in_formals513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statement528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_eachStatement_in_statement535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_letStatement_in_statement542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blockStatement_in_statement549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMENT_in_statement558 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRCON_in_statement560 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement562 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_57_in_statement575 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement577 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement579 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_57_in_statement592 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_statement594 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement596 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_58_in_statement607 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement609 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement611 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_59_in_statement622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement631 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement633 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_statement636 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement638 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement651 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement653 = new BitSet(new long[]{0x0000000000000820L});
    public static final BitSet FOLLOW_embedding_in_statement656 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement658 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement669 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement671 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement674 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement686 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement688 = new BitSet(new long[]{0x0ED1000000004030L});
    public static final BitSet FOLLOW_statement_in_statement693 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_52_in_ifStatement713 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_42_in_ifStatement715 = new BitSet(new long[]{0x10014000000003A0L});
    public static final BitSet FOLLOW_predicate_in_ifStatement717 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ifStatement719 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_53_in_ifStatement730 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_54_in_eachStatement770 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_42_in_eachStatement772 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_eachStatement774 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_eachStatement776 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_listExpression_in_eachStatement782 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_expression_in_eachStatement786 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_eachStatement790 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_48_in_blockStatement816 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_blockStatement822 = new BitSet(new long[]{0x0ED3000000004010L});
    public static final BitSet FOLLOW_49_in_blockStatement829 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_55_in_letStatement857 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_assignment_in_letStatement859 = new BitSet(new long[]{0x0108000000000020L});
    public static final BitSet FOLLOW_56_in_letStatement862 = new BitSet(new long[]{0x0ED1000000014010L});
    public static final BitSet FOLLOW_statement_in_letStatement868 = new BitSet(new long[]{0x0ED1000000014010L});
    public static final BitSet FOLLOW_END_in_letStatement873 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDCON_in_assignment887 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_assignment889 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_assignment891 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_assignment893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funcBinding_in_assignment901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_funcBinding915 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_funcBinding919 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_formals_in_funcBinding921 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_END_in_funcBinding925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_predicate951 = new BitSet(new long[]{0x10014000000003A0L});
    public static final BitSet FOLLOW_predicate_in_predicate955 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate967 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate980 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_predicate982 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_type_in_predicate984 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_61_in_predicate994 = new BitSet(new long[]{0x10014000000003A0L});
    public static final BitSet FOLLOW_predicate_in_predicate998 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_62_in_predicate1004 = new BitSet(new long[]{0x10014000000003A0L});
    public static final BitSet FOLLOW_predicate_in_predicate1008 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding1046 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_embed_in_embedding1048 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_textTail_in_embedding1050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed1060 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_embed1063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed1073 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_markup_in_embed1076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail1085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail1089 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_embed_in_textTail1091 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_textTail_in_textTail1093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_synpred18_WaebricInterpreter344 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_synpred18_WaebricInterpreter348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_synpred19_WaebricInterpreter354 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_synpred19_WaebricInterpreter356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_synpred32_WaebricInterpreter575 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_synpred32_WaebricInterpreter577 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred32_WaebricInterpreter579 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_57_in_synpred33_WaebricInterpreter592 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_synpred33_WaebricInterpreter594 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred33_WaebricInterpreter596 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_synpred37_WaebricInterpreter631 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred37_WaebricInterpreter633 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_synpred37_WaebricInterpreter636 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred37_WaebricInterpreter638 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_synpred39_WaebricInterpreter651 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred39_WaebricInterpreter653 = new BitSet(new long[]{0x0000000000000820L});
    public static final BitSet FOLLOW_embedding_in_synpred39_WaebricInterpreter656 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred39_WaebricInterpreter658 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_synpred41_WaebricInterpreter669 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred41_WaebricInterpreter671 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred41_WaebricInterpreter674 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_listExpression_in_synpred44_WaebricInterpreter782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred50_WaebricInterpreter967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred51_WaebricInterpreter994 = new BitSet(new long[]{0x10014000000003A0L});
    public static final BitSet FOLLOW_predicate_in_synpred51_WaebricInterpreter998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_synpred52_WaebricInterpreter1004 = new BitSet(new long[]{0x10014000000003A0L});
    public static final BitSet FOLLOW_predicate_in_synpred52_WaebricInterpreter1008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred56_WaebricInterpreter1060 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_synpred56_WaebricInterpreter1063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred57_WaebricInterpreter1073 = new BitSet(new long[]{0x0000000000000002L});

}