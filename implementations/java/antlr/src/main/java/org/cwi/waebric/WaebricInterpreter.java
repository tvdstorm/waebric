// $ANTLR 3.1.2 /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g 2009-08-14 18:15:33

	package org.cwi.waebric;
	
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
    			this.document = new Document();
    			// TODO : Evaluate function and store in file
    		}
    	}
    	
    	/**
    	 * Interpret function
    	 * @param function: Function AST
    	 */
        	private boolean interpretFunction(String name) throws RecognitionException {
        		Integer index = getFunction(name);
        		if(index != -1) {
        			int curr = input.index();
        			input.seek(index);
        			function();
        			input.seek(curr);
        			return true;
        		} else if(functions.containsKey(name)) {
        			CommonTree function = functions.get(name).tree;
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
                		if(content instanceof Element) { current = (Element) content; }
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
    		// Check local environments
    		for(int i=Environment_stack.size()-1; i>=0; i--) {
    			if(((Environment_scope)Environment_stack.elementAt(i)).functions.containsKey(name)) {
    				return ((Environment_scope)Environment_stack.elementAt(i)).functions.get(name); 
    			}
    		} return -1 ;
    	}
    	
    	/**
    	 * Define function
    	 * @param name: Function name
    	 * @param tree: Function AST
    	 */
    	private void defineFunction(String name, Integer input) {
    		((Environment_scope)Environment_stack.peek()).functions.put(name, input);
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
    	


    public static class site_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "site"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:176:1: site : 'site' mappings 'end' ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:176:5: ( 'site' mappings 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:176:9: 'site' mappings 'end'
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:178:1: mappings : ( mapping )? ( ';' mapping )* ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:178:9: ( ( mapping )? ( ';' mapping )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:178:12: ( mapping )? ( ';' mapping )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:178:12: ( mapping )?
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

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:178:21: ( ';' mapping )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==SEMICOLON) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:178:23: ';' mapping
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:180:1: mapping : PATH ':' markup ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:180:9: ( PATH ':' markup )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:180:12: PATH ':' markup
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:185:1: markup : IDCON ( attribute )* ( arguments )? ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:185:7: ( IDCON ( attribute )* ( arguments )? )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:185:11: IDCON ( attribute )* ( arguments )?
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON10=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_markup121); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON10_tree = (CommonTree)adaptor.dupNode(IDCON10);

            adaptor.addChild(root_0, IDCON10_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:185:17: ( attribute )*
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

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:185:28: ( arguments )?
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:191:1: attribute : ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' w= NATCON ( '%' h= NATCON )? );
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:191:10: ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' w= NATCON ( '%' h= NATCON )? )
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:191:13: '#' IDCON
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:192:6: '.' IDCON
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:193:6: '$' IDCON
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:194:6: ':' IDCON
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:195:6: '@' w= NATCON ( '%' h= NATCON )?
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:196:5: ( '%' h= NATCON )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==41) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:196:7: '%' h= NATCON
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:198:1: arguments : '(' ( argument )? ( ',' argument )* ')' ;
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:198:10: ( '(' ( argument )? ( ',' argument )* ')' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:198:13: '(' ( argument )? ( ',' argument )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            char_literal23=(CommonTree)match(input,42,FOLLOW_42_in_arguments222); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal23_tree = (CommonTree)adaptor.dupNode(char_literal23);

            adaptor.addChild(root_0, char_literal23_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:198:17: ( argument )?
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

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:198:27: ( ',' argument )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==43) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:198:29: ',' argument
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:200:1: argument : ( expression | IDCON '=' expression );
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:200:9: ( expression | IDCON '=' expression )
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:200:12: expression
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:201:6: IDCON '=' expression
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
        public int index; 		String eval = "undef";
        public Map<String, expression_return> map = new HashMap<String, expression_return>();
        public Collection<expression_return> collection = new ArrayList();
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:206:1: expression returns [\n\t\tint index; // Used for interpreting a referenced variable\n\t\tString eval = \"undef\", // Evaluation value for printing\n\t\tMap<String, expression_return> map = new HashMap<String, expression_return>(), // Map structure for fields\n\t\tCollection<expression_return> collection = new ArrayList() // List structure for iterations\n\t] : (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (id= IDCON ':' e= expression )? ( ',' id= IDCON ':' e= expression )* '}' ) ( '+' e= expression | '.' id= IDCON )* ;
    public final WaebricInterpreter.expression_return expression() throws RecognitionException {
        WaebricInterpreter.expression_return retval = new WaebricInterpreter.expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree var=null;
        CommonTree id=null;
        CommonTree NATCON32=null;
        CommonTree TEXT33=null;
        CommonTree SYMBOLCON34=null;
        CommonTree char_literal35=null;
        CommonTree char_literal36=null;
        CommonTree char_literal37=null;
        CommonTree char_literal38=null;
        CommonTree char_literal39=null;
        CommonTree char_literal40=null;
        CommonTree char_literal41=null;
        CommonTree char_literal42=null;
        CommonTree char_literal43=null;
        CommonTree char_literal44=null;
        WaebricInterpreter.expression_return e = null;


        CommonTree var_tree=null;
        CommonTree id_tree=null;
        CommonTree NATCON32_tree=null;
        CommonTree TEXT33_tree=null;
        CommonTree SYMBOLCON34_tree=null;
        CommonTree char_literal35_tree=null;
        CommonTree char_literal36_tree=null;
        CommonTree char_literal37_tree=null;
        CommonTree char_literal38_tree=null;
        CommonTree char_literal39_tree=null;
        CommonTree char_literal40_tree=null;
        CommonTree char_literal41_tree=null;
        CommonTree char_literal42_tree=null;
        CommonTree char_literal43_tree=null;
        CommonTree char_literal44_tree=null;

         retval.index = input.index(); 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:212:2: ( (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (id= IDCON ':' e= expression )? ( ',' id= IDCON ':' e= expression )* '}' ) ( '+' e= expression | '.' id= IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:212:7: (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (id= IDCON ':' e= expression )? ( ',' id= IDCON ':' e= expression )* '}' ) ( '+' e= expression | '.' id= IDCON )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:212:7: (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (id= IDCON ':' e= expression )? ( ',' id= IDCON ':' e= expression )* '}' )
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
            case 46:
                {
                alt14=5;
                }
                break;
            case 48:
                {
                alt14=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:213:6: var= IDCON
                    {
                    _last = (CommonTree)input.LT(1);
                    var=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression291); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    var_tree = (CommonTree)adaptor.dupNode(var);

                    adaptor.addChild(root_0, var_tree);
                    }
                    if ( state.backtracking==0 ) {
                       
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:222:8: NATCON
                    {
                    _last = (CommonTree)input.LT(1);
                    NATCON32=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_expression302); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:223:8: TEXT
                    {
                    _last = (CommonTree)input.LT(1);
                    TEXT33=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_expression313); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:224:8: SYMBOLCON
                    {
                    _last = (CommonTree)input.LT(1);
                    SYMBOLCON34=(CommonTree)match(input,SYMBOLCON,FOLLOW_SYMBOLCON_in_expression324); if (state.failed) return retval;
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:225:8: '[' (e= expression )? ( ',' e= expression )* ']'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal35=(CommonTree)match(input,46,FOLLOW_46_in_expression335); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal35_tree = (CommonTree)adaptor.dupNode(char_literal35);

                    adaptor.addChild(root_0, char_literal35_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:225:12: (e= expression )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==IDCON||(LA10_0>=NATCON && LA10_0<=SYMBOLCON)||LA10_0==46||LA10_0==48) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:225:14: e= expression
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_expression_in_expression341);
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

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:226:8: ( ',' e= expression )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==43) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:226:10: ',' e= expression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal36=(CommonTree)match(input,43,FOLLOW_43_in_expression358); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal36_tree = (CommonTree)adaptor.dupNode(char_literal36);

                    	    adaptor.addChild(root_0, char_literal36_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_expression_in_expression362);
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
                    	    break loop11;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal37=(CommonTree)match(input,47,FOLLOW_47_in_expression369); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal37_tree = (CommonTree)adaptor.dupNode(char_literal37);

                    adaptor.addChild(root_0, char_literal37_tree);
                    }
                    if ( state.backtracking==0 ) {

                      						retval.eval += "[";
                      						for(expression_return eret:retval.collection) { retval.eval += eret.eval + ","; }
                      						retval.eval = retval.eval.substring(0,retval.eval.length()); // Clip last character
                      						retval.eval += "]";
                      					
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:232:8: '{' (id= IDCON ':' e= expression )? ( ',' id= IDCON ':' e= expression )* '}'
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal38=(CommonTree)match(input,48,FOLLOW_48_in_expression380); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal38_tree = (CommonTree)adaptor.dupNode(char_literal38);

                    adaptor.addChild(root_0, char_literal38_tree);
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:232:12: (id= IDCON ':' e= expression )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==IDCON) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:232:14: id= IDCON ':' e= expression
                            {
                            _last = (CommonTree)input.LT(1);
                            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression386); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            id_tree = (CommonTree)adaptor.dupNode(id);

                            adaptor.addChild(root_0, id_tree);
                            }
                            _last = (CommonTree)input.LT(1);
                            char_literal39=(CommonTree)match(input,37,FOLLOW_37_in_expression388); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal39_tree = (CommonTree)adaptor.dupNode(char_literal39);

                            adaptor.addChild(root_0, char_literal39_tree);
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

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:233:8: ( ',' id= IDCON ':' e= expression )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==43) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:233:10: ',' id= IDCON ':' e= expression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal40=(CommonTree)match(input,43,FOLLOW_43_in_expression409); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal40_tree = (CommonTree)adaptor.dupNode(char_literal40);

                    	    adaptor.addChild(root_0, char_literal40_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression413); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    id_tree = (CommonTree)adaptor.dupNode(id);

                    	    adaptor.addChild(root_0, id_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    char_literal41=(CommonTree)match(input,37,FOLLOW_37_in_expression415); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal41_tree = (CommonTree)adaptor.dupNode(char_literal41);

                    	    adaptor.addChild(root_0, char_literal41_tree);
                    	    }
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_expression_in_expression419);
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
                    	    break loop13;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    char_literal42=(CommonTree)match(input,49,FOLLOW_49_in_expression426); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal42_tree = (CommonTree)adaptor.dupNode(char_literal42);

                    adaptor.addChild(root_0, char_literal42_tree);
                    }
                    if ( state.backtracking==0 ) {

                      						retval.collection = retval.map.values();
                      						retval.eval += "{";
                      						for(String key:retval.map.keySet()) { retval.eval += key + ":" + retval.map.get(key) + ","; }
                      						retval.eval = retval.eval.substring(0,retval.eval.length()); // Clip last character
                      						retval.eval += "}";
                      					
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:240:7: ( '+' e= expression | '.' id= IDCON )*
            loop15:
            do {
                int alt15=3;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==50) ) {
                    int LA15_2 = input.LA(2);

                    if ( (synpred22_WaebricInterpreter()) ) {
                        alt15=1;
                    }


                }
                else if ( (LA15_0==35) ) {
                    int LA15_3 = input.LA(2);

                    if ( (synpred23_WaebricInterpreter()) ) {
                        alt15=2;
                    }


                }


                switch (alt15) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:241:6: '+' e= expression
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal43=(CommonTree)match(input,50,FOLLOW_50_in_expression444); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal43_tree = (CommonTree)adaptor.dupNode(char_literal43);

            	    adaptor.addChild(root_0, char_literal43_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expression_in_expression448);
            	    e=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, e.getTree());
            	    if ( state.backtracking==0 ) {
            	       
            	      						retval.eval += (e!=null?e.eval:null);
            	      						retval.collection.clear();
            	      						retval.map.clear();
            	      					
            	    }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:246:8: '.' id= IDCON
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    char_literal44=(CommonTree)match(input,35,FOLLOW_35_in_expression460); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal44_tree = (CommonTree)adaptor.dupNode(char_literal44);

            	    adaptor.addChild(root_0, char_literal44_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression464); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    id_tree = (CommonTree)adaptor.dupNode(id);

            	    adaptor.addChild(root_0, id_tree);
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if(retval.map.containsKey(id.getText())) {
            	      							retval = retval.map.get(id.getText()); 
            	      						} else {
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
            	    break loop15;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:260:1: function : 'def' IDCON ( formals )? ( statement )* 'end' ;
    public final WaebricInterpreter.function_return function() throws RecognitionException {
        WaebricInterpreter.function_return retval = new WaebricInterpreter.function_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal45=null;
        CommonTree IDCON46=null;
        CommonTree string_literal49=null;
        WaebricInterpreter.formals_return formals47 = null;

        WaebricInterpreter.statement_return statement48 = null;


        CommonTree string_literal45_tree=null;
        CommonTree IDCON46_tree=null;
        CommonTree string_literal49_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:260:9: ( 'def' IDCON ( formals )? ( statement )* 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:260:12: 'def' IDCON ( formals )? ( statement )* 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal45=(CommonTree)match(input,51,FOLLOW_51_in_function487); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal45_tree = (CommonTree)adaptor.dupNode(string_literal45);

            adaptor.addChild(root_0, string_literal45_tree);
            }
            _last = (CommonTree)input.LT(1);
            IDCON46=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_function489); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON46_tree = (CommonTree)adaptor.dupNode(IDCON46);

            adaptor.addChild(root_0, IDCON46_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:260:24: ( formals )?
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
                    pushFollow(FOLLOW_formals_in_function491);
                    formals47=formals();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, formals47.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:260:33: ( statement )*
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
            	    pushFollow(FOLLOW_statement_in_function494);
            	    statement48=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, statement48.getTree());

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            string_literal49=(CommonTree)match(input,END,FOLLOW_END_in_function497); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal49_tree = (CommonTree)adaptor.dupNode(string_literal49);

            adaptor.addChild(root_0, string_literal49_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:262:1: formals : '(' ( IDCON )* ')' ;
    public final WaebricInterpreter.formals_return formals() throws RecognitionException {
        WaebricInterpreter.formals_return retval = new WaebricInterpreter.formals_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal50=null;
        CommonTree IDCON51=null;
        CommonTree char_literal52=null;

        CommonTree char_literal50_tree=null;
        CommonTree IDCON51_tree=null;
        CommonTree char_literal52_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:262:8: ( '(' ( IDCON )* ')' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:262:11: '(' ( IDCON )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            char_literal50=(CommonTree)match(input,42,FOLLOW_42_in_formals506); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal50_tree = (CommonTree)adaptor.dupNode(char_literal50);

            adaptor.addChild(root_0, char_literal50_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:262:15: ( IDCON )*
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
            	    IDCON51=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_formals508); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDCON51_tree = (CommonTree)adaptor.dupNode(IDCON51);

            	    adaptor.addChild(root_0, IDCON51_tree);
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
            char_literal52=(CommonTree)match(input,44,FOLLOW_44_in_formals511); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal52_tree = (CommonTree)adaptor.dupNode(char_literal52);

            adaptor.addChild(root_0, char_literal52_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:270:1: statement : ( ifStatement | eachStatement | letStatement | blockStatement | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) | ^( MARKUP_STATEMENT ( markup )+ ';' ) | ^( MARKUP_STATEMENT ( markup )+ s= statement ) );
    public final WaebricInterpreter.statement_return statement() throws RecognitionException {
        WaebricInterpreter.statement_return retval = new WaebricInterpreter.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal57=null;
        CommonTree STRCON58=null;
        CommonTree char_literal59=null;
        CommonTree string_literal60=null;
        CommonTree char_literal62=null;
        CommonTree string_literal63=null;
        CommonTree char_literal65=null;
        CommonTree string_literal66=null;
        CommonTree char_literal68=null;
        CommonTree string_literal69=null;
        CommonTree MARKUP_STATEMENT70=null;
        CommonTree char_literal73=null;
        CommonTree MARKUP_STATEMENT74=null;
        CommonTree char_literal77=null;
        CommonTree MARKUP_STATEMENT78=null;
        CommonTree char_literal80=null;
        CommonTree MARKUP_STATEMENT81=null;
        WaebricInterpreter.statement_return s = null;

        WaebricInterpreter.ifStatement_return ifStatement53 = null;

        WaebricInterpreter.eachStatement_return eachStatement54 = null;

        WaebricInterpreter.letStatement_return letStatement55 = null;

        WaebricInterpreter.blockStatement_return blockStatement56 = null;

        WaebricInterpreter.expression_return expression61 = null;

        WaebricInterpreter.embedding_return embedding64 = null;

        WaebricInterpreter.expression_return expression67 = null;

        WaebricInterpreter.markup_return markup71 = null;

        WaebricInterpreter.expression_return expression72 = null;

        WaebricInterpreter.markup_return markup75 = null;

        WaebricInterpreter.embedding_return embedding76 = null;

        WaebricInterpreter.markup_return markup79 = null;

        WaebricInterpreter.markup_return markup82 = null;


        CommonTree string_literal57_tree=null;
        CommonTree STRCON58_tree=null;
        CommonTree char_literal59_tree=null;
        CommonTree string_literal60_tree=null;
        CommonTree char_literal62_tree=null;
        CommonTree string_literal63_tree=null;
        CommonTree char_literal65_tree=null;
        CommonTree string_literal66_tree=null;
        CommonTree char_literal68_tree=null;
        CommonTree string_literal69_tree=null;
        CommonTree MARKUP_STATEMENT70_tree=null;
        CommonTree char_literal73_tree=null;
        CommonTree MARKUP_STATEMENT74_tree=null;
        CommonTree char_literal77_tree=null;
        CommonTree MARKUP_STATEMENT78_tree=null;
        CommonTree char_literal80_tree=null;
        CommonTree MARKUP_STATEMENT81_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:270:10: ( ifStatement | eachStatement | letStatement | blockStatement | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) | ^( MARKUP_STATEMENT ( markup )+ ';' ) | ^( MARKUP_STATEMENT ( markup )+ s= statement ) )
            int alt23=13;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:270:13: ifStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_ifStatement_in_statement526);
                    ifStatement53=ifStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, ifStatement53.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:271:6: eachStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_eachStatement_in_statement533);
                    eachStatement54=eachStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, eachStatement54.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:272:6: letStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_letStatement_in_statement540);
                    letStatement55=letStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, letStatement55.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:273:6: blockStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_blockStatement_in_statement547);
                    blockStatement56=blockStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, blockStatement56.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:274:6: ^( 'comment' STRCON ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal57=(CommonTree)match(input,COMMENT,FOLLOW_COMMENT_in_statement556); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal57_tree = (CommonTree)adaptor.dupNode(string_literal57);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal57_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    STRCON58=(CommonTree)match(input,STRCON,FOLLOW_STRCON_in_statement558); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRCON58_tree = (CommonTree)adaptor.dupNode(STRCON58);

                    adaptor.addChild(root_1, STRCON58_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    char_literal59=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement560); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal59_tree = (CommonTree)adaptor.dupNode(char_literal59);

                    adaptor.addChild(root_1, char_literal59_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                    if ( state.backtracking==0 ) {

                      					Comment comment = new Comment(STRCON58.getText());
                      					addContent(comment);
                      				
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:278:6: ^( 'echo' expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal60=(CommonTree)match(input,57,FOLLOW_57_in_statement573); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal60_tree = (CommonTree)adaptor.dupNode(string_literal60);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal60_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement575);
                    expression61=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression61.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal62=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement577); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal62_tree = (CommonTree)adaptor.dupNode(char_literal62);

                    adaptor.addChild(root_1, char_literal62_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                    if ( state.backtracking==0 ) {

                      					Text text = new Text((expression61!=null?expression61.eval:null));
                      					addContent(text);
                      				
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:282:6: ^( 'echo' embedding ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal63=(CommonTree)match(input,57,FOLLOW_57_in_statement590); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal63_tree = (CommonTree)adaptor.dupNode(string_literal63);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal63_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embedding_in_statement592);
                    embedding64=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding64.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal65=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement594); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal65_tree = (CommonTree)adaptor.dupNode(char_literal65);

                    adaptor.addChild(root_1, char_literal65_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:283:6: ^( 'cdata' expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    string_literal66=(CommonTree)match(input,58,FOLLOW_58_in_statement605); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal66_tree = (CommonTree)adaptor.dupNode(string_literal66);

                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal66_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement607);
                    expression67=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression67.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal68=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement609); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal68_tree = (CommonTree)adaptor.dupNode(char_literal68);

                    adaptor.addChild(root_1, char_literal68_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                    if ( state.backtracking==0 ) {

                      					CDATA cdata = new CDATA((expression67!=null?expression67.eval:null));
                      					addContent(cdata);
                      				
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:287:6: 'yield;'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    string_literal69=(CommonTree)match(input,59,FOLLOW_59_in_statement620); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal69_tree = (CommonTree)adaptor.dupNode(string_literal69);

                    adaptor.addChild(root_0, string_literal69_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:288:6: ^( MARKUP_STATEMENT ( markup )+ expression ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT70=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement629); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT70_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT70);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT70_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:288:26: ( markup )+
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
                    	    pushFollow(FOLLOW_markup_in_statement631);
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
                    	    if ( cnt19 >= 1 ) break loop19;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(19, input);
                                throw eee;
                        }
                        cnt19++;
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_statement634);
                    expression72=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expression72.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal73=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement636); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal73_tree = (CommonTree)adaptor.dupNode(char_literal73);

                    adaptor.addChild(root_1, char_literal73_tree);
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }

                    if ( state.backtracking==0 ) {

                      					Text text = new Text((expression72!=null?expression72.eval:null));
                      					addContent(text);
                      				
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:292:6: ^( MARKUP_STATEMENT ( markup )+ embedding ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT74=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement649); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT74_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT74);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT74_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:292:26: ( markup )+
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
                    	    pushFollow(FOLLOW_markup_in_statement651);
                    	    markup75=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup75.getTree());

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
                    pushFollow(FOLLOW_embedding_in_statement654);
                    embedding76=embedding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, embedding76.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal77=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement656); if (state.failed) return retval;
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
                case 12 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:293:6: ^( MARKUP_STATEMENT ( markup )+ ';' )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT78=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement667); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT78_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT78);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT78_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:293:26: ( markup )+
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
                    	    pushFollow(FOLLOW_markup_in_statement669);
                    	    markup79=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, markup79.getTree());

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
                    char_literal80=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement672); if (state.failed) return retval;
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
                case 13 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:294:6: ^( MARKUP_STATEMENT ( markup )+ s= statement )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    MARKUP_STATEMENT81=(CommonTree)match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement684); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MARKUP_STATEMENT81_tree = (CommonTree)adaptor.dupNode(MARKUP_STATEMENT81);

                    root_1 = (CommonTree)adaptor.becomeRoot(MARKUP_STATEMENT81_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:294:26: ( markup )+
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
                    	    pushFollow(FOLLOW_markup_in_statement686);
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
                    	    if ( cnt22 >= 1 ) break loop22;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(22, input);
                                throw eee;
                        }
                        cnt22++;
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_statement_in_statement691);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:296:1: ifStatement : ^( 'if' '(' predicate ')' t= . ( 'else' f= . )? ) ;
    public final WaebricInterpreter.ifStatement_return ifStatement() throws RecognitionException {
        WaebricInterpreter.ifStatement_return retval = new WaebricInterpreter.ifStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal83=null;
        CommonTree char_literal84=null;
        CommonTree char_literal86=null;
        CommonTree string_literal87=null;
        CommonTree t=null;
        CommonTree f=null;
        WaebricInterpreter.predicate_return predicate85 = null;


        CommonTree string_literal83_tree=null;
        CommonTree char_literal84_tree=null;
        CommonTree char_literal86_tree=null;
        CommonTree string_literal87_tree=null;
        CommonTree t_tree=null;
        CommonTree f_tree=null;

         int ti = 0; int fi = 0; 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:298:2: ( ^( 'if' '(' predicate ')' t= . ( 'else' f= . )? ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:298:5: ^( 'if' '(' predicate ')' t= . ( 'else' f= . )? )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal83=(CommonTree)match(input,52,FOLLOW_52_in_ifStatement711); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal83_tree = (CommonTree)adaptor.dupNode(string_literal83);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal83_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            char_literal84=(CommonTree)match(input,42,FOLLOW_42_in_ifStatement713); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal84_tree = (CommonTree)adaptor.dupNode(char_literal84);

            adaptor.addChild(root_1, char_literal84_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_predicate_in_ifStatement715);
            predicate85=predicate();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, predicate85.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal86=(CommonTree)match(input,44,FOLLOW_44_in_ifStatement717); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal86_tree = (CommonTree)adaptor.dupNode(char_literal86);

            adaptor.addChild(root_1, char_literal86_tree);
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
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:298:60: ( 'else' f= . )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==53) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:298:62: 'else' f= .
                    {
                    _last = (CommonTree)input.LT(1);
                    string_literal87=(CommonTree)match(input,53,FOLLOW_53_in_ifStatement728); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal87_tree = (CommonTree)adaptor.dupNode(string_literal87);

                    adaptor.addChild(root_1, string_literal87_tree);
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
              				if((predicate85!=null?predicate85.eval:false)) {
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:311:1: eachStatement : ^( 'each' '(' IDCON ':' e= expression ')' . ) ;
    public final WaebricInterpreter.eachStatement_return eachStatement() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricInterpreter.eachStatement_return retval = new WaebricInterpreter.eachStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal88=null;
        CommonTree char_literal89=null;
        CommonTree IDCON90=null;
        CommonTree char_literal91=null;
        CommonTree char_literal92=null;
        CommonTree wildcard93=null;
        WaebricInterpreter.expression_return e = null;


        CommonTree string_literal88_tree=null;
        CommonTree char_literal89_tree=null;
        CommonTree IDCON90_tree=null;
        CommonTree char_literal91_tree=null;
        CommonTree char_literal92_tree=null;
        CommonTree wildcard93_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new HashMap<String, Integer>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        		int stm = 0;
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:317:4: ( ^( 'each' '(' IDCON ':' e= expression ')' . ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:317:7: ^( 'each' '(' IDCON ':' e= expression ')' . )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal88=(CommonTree)match(input,54,FOLLOW_54_in_eachStatement768); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal88_tree = (CommonTree)adaptor.dupNode(string_literal88);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal88_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            char_literal89=(CommonTree)match(input,42,FOLLOW_42_in_eachStatement770); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal89_tree = (CommonTree)adaptor.dupNode(char_literal89);

            adaptor.addChild(root_1, char_literal89_tree);
            }
            _last = (CommonTree)input.LT(1);
            IDCON90=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_eachStatement772); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON90_tree = (CommonTree)adaptor.dupNode(IDCON90);

            adaptor.addChild(root_1, IDCON90_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal91=(CommonTree)match(input,37,FOLLOW_37_in_eachStatement774); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal91_tree = (CommonTree)adaptor.dupNode(char_literal91);

            adaptor.addChild(root_1, char_literal91_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_eachStatement778);
            e=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, e.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal92=(CommonTree)match(input,44,FOLLOW_44_in_eachStatement780); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal92_tree = (CommonTree)adaptor.dupNode(char_literal92);

            adaptor.addChild(root_1, char_literal92_tree);
            }
            if ( state.backtracking==0 ) {
               stm = input.index(); 
            }
            _last = (CommonTree)input.LT(1);
            wildcard93=(CommonTree)input.LT(1);
            matchAny(input); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            wildcard93_tree = (CommonTree)adaptor.dupTree(wildcard93);
            adaptor.addChild(root_1, wildcard93_tree);
            }

            match(input, Token.UP, null); if (state.failed) return retval;adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }

            if ( state.backtracking==0 ) {

              				int actualIndex = input.index();
                            			Element actualElement = this.current;
                            			for(expression_return value: e.collection) {
                            				((Environment_scope)Environment_stack.peek()).variables.put(IDCON90.getText(), value.index);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:330:1: blockStatement : ^( '{' (s= statement )* '}' ) ;
    public final WaebricInterpreter.blockStatement_return blockStatement() throws RecognitionException {
        WaebricInterpreter.blockStatement_return retval = new WaebricInterpreter.blockStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal94=null;
        CommonTree char_literal95=null;
        WaebricInterpreter.statement_return s = null;


        CommonTree char_literal94_tree=null;
        CommonTree char_literal95_tree=null;

         Element actual = this.current; 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:332:2: ( ^( '{' (s= statement )* '}' ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:332:5: ^( '{' (s= statement )* '}' )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            char_literal94=(CommonTree)match(input,48,FOLLOW_48_in_blockStatement806); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal94_tree = (CommonTree)adaptor.dupNode(char_literal94);

            root_1 = (CommonTree)adaptor.becomeRoot(char_literal94_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:332:12: (s= statement )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==MARKUP_STATEMENT||LA25_0==COMMENT||LA25_0==48||LA25_0==52||(LA25_0>=54 && LA25_0<=55)||(LA25_0>=57 && LA25_0<=59)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:332:14: s= statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_blockStatement812);
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
            	    break loop25;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               this.current = actual; 
            }
            _last = (CommonTree)input.LT(1);
            char_literal95=(CommonTree)match(input,49,FOLLOW_49_in_blockStatement819); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal95_tree = (CommonTree)adaptor.dupNode(char_literal95);

            adaptor.addChild(root_1, char_literal95_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:334:1: letStatement : ^( 'let' ( assignment )+ 'in' (s= statement )* 'end' ) ;
    public final WaebricInterpreter.letStatement_return letStatement() throws RecognitionException {
        Environment_stack.push(new Environment_scope());

        WaebricInterpreter.letStatement_return retval = new WaebricInterpreter.letStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal96=null;
        CommonTree string_literal98=null;
        CommonTree string_literal99=null;
        WaebricInterpreter.statement_return s = null;

        WaebricInterpreter.assignment_return assignment97 = null;


        CommonTree string_literal96_tree=null;
        CommonTree string_literal98_tree=null;
        CommonTree string_literal99_tree=null;


        		((Environment_scope)Environment_stack.peek()).variables = new HashMap<String, Integer>();
        		((Environment_scope)Environment_stack.peek()).functions = new HashMap<String, Integer>();
        	
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:339:4: ( ^( 'let' ( assignment )+ 'in' (s= statement )* 'end' ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:339:7: ^( 'let' ( assignment )+ 'in' (s= statement )* 'end' )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            string_literal96=(CommonTree)match(input,55,FOLLOW_55_in_letStatement847); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal96_tree = (CommonTree)adaptor.dupNode(string_literal96);

            root_1 = (CommonTree)adaptor.becomeRoot(string_literal96_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:339:16: ( assignment )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==IDCON||LA26_0==51) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: assignment
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_assignment_in_letStatement849);
            	    assignment97=assignment();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, assignment97.getTree());

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
            string_literal98=(CommonTree)match(input,56,FOLLOW_56_in_letStatement852); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal98_tree = (CommonTree)adaptor.dupNode(string_literal98);

            adaptor.addChild(root_1, string_literal98_tree);
            }
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:339:33: (s= statement )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==MARKUP_STATEMENT||LA27_0==COMMENT||LA27_0==48||LA27_0==52||(LA27_0>=54 && LA27_0<=55)||(LA27_0>=57 && LA27_0<=59)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:339:35: s= statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_letStatement858);
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
            	    break loop27;
                }
            } while (true);

            _last = (CommonTree)input.LT(1);
            string_literal99=(CommonTree)match(input,END,FOLLOW_END_in_letStatement863); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal99_tree = (CommonTree)adaptor.dupNode(string_literal99);

            adaptor.addChild(root_1, string_literal99_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:344:1: assignment : ( varBinding | funcBinding );
    public final WaebricInterpreter.assignment_return assignment() throws RecognitionException {
        WaebricInterpreter.assignment_return retval = new WaebricInterpreter.assignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricInterpreter.varBinding_return varBinding100 = null;

        WaebricInterpreter.funcBinding_return funcBinding101 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:344:11: ( varBinding | funcBinding )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==IDCON) ) {
                alt28=1;
            }
            else if ( (LA28_0==51) ) {
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:344:14: varBinding
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_varBinding_in_assignment877);
                    varBinding100=varBinding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, varBinding100.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:345:6: funcBinding
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_funcBinding_in_assignment884);
                    funcBinding101=funcBinding();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, funcBinding101.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:347:1: varBinding : IDCON '=' expression ';' ;
    public final WaebricInterpreter.varBinding_return varBinding() throws RecognitionException {
        WaebricInterpreter.varBinding_return retval = new WaebricInterpreter.varBinding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDCON102=null;
        CommonTree char_literal103=null;
        CommonTree char_literal105=null;
        WaebricInterpreter.expression_return expression104 = null;


        CommonTree IDCON102_tree=null;
        CommonTree char_literal103_tree=null;
        CommonTree char_literal105_tree=null;

         int index = 0; 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:349:2: ( IDCON '=' expression ';' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:349:5: IDCON '=' expression ';'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            IDCON102=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_varBinding902); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON102_tree = (CommonTree)adaptor.dupNode(IDCON102);

            adaptor.addChild(root_0, IDCON102_tree);
            }
            _last = (CommonTree)input.LT(1);
            char_literal103=(CommonTree)match(input,45,FOLLOW_45_in_varBinding904); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal103_tree = (CommonTree)adaptor.dupNode(char_literal103);

            adaptor.addChild(root_0, char_literal103_tree);
            }
            if ( state.backtracking==0 ) {
               index = input.index(); 
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expression_in_varBinding908);
            expression104=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, expression104.getTree());
            _last = (CommonTree)input.LT(1);
            char_literal105=(CommonTree)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_varBinding910); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal105_tree = (CommonTree)adaptor.dupNode(char_literal105);

            adaptor.addChild(root_0, char_literal105_tree);
            }
            if ( state.backtracking==0 ) {

              				defineVariable(IDCON102.getText(), index);
              			
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:353:1: funcBinding : 'def' IDCON formals . 'end' ;
    public final WaebricInterpreter.funcBinding_return funcBinding() throws RecognitionException {
        WaebricInterpreter.funcBinding_return retval = new WaebricInterpreter.funcBinding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal106=null;
        CommonTree IDCON107=null;
        CommonTree wildcard109=null;
        CommonTree string_literal110=null;
        WaebricInterpreter.formals_return formals108 = null;


        CommonTree string_literal106_tree=null;
        CommonTree IDCON107_tree=null;
        CommonTree wildcard109_tree=null;
        CommonTree string_literal110_tree=null;

         int index = input.index(); 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:355:2: ( 'def' IDCON formals . 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:355:5: 'def' IDCON formals . 'end'
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            string_literal106=(CommonTree)match(input,51,FOLLOW_51_in_funcBinding931); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal106_tree = (CommonTree)adaptor.dupNode(string_literal106);

            adaptor.addChild(root_0, string_literal106_tree);
            }
            _last = (CommonTree)input.LT(1);
            IDCON107=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_funcBinding933); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDCON107_tree = (CommonTree)adaptor.dupNode(IDCON107);

            adaptor.addChild(root_0, IDCON107_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_formals_in_funcBinding935);
            formals108=formals();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, formals108.getTree());
            _last = (CommonTree)input.LT(1);
            wildcard109=(CommonTree)input.LT(1);
            matchAny(input); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            wildcard109_tree = (CommonTree)adaptor.dupTree(wildcard109);
            adaptor.addChild(root_0, wildcard109_tree);
            }
            _last = (CommonTree)input.LT(1);
            string_literal110=(CommonTree)match(input,END,FOLLOW_END_in_funcBinding939); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal110_tree = (CommonTree)adaptor.dupNode(string_literal110);

            adaptor.addChild(root_0, string_literal110_tree);
            }
            if ( state.backtracking==0 ) {

              				defineFunction(IDCON107.getText(), index);
              			
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:362:1: predicate returns [boolean eval] : ( '!' p= predicate | e= expression | e= expression '.' type ) ( '&&' p= predicate | '||' p= predicate )* ;
    public final WaebricInterpreter.predicate_return predicate() throws RecognitionException {
        WaebricInterpreter.predicate_return retval = new WaebricInterpreter.predicate_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree char_literal111=null;
        CommonTree char_literal112=null;
        CommonTree string_literal114=null;
        CommonTree string_literal115=null;
        WaebricInterpreter.predicate_return p = null;

        WaebricInterpreter.expression_return e = null;

        WaebricInterpreter.type_return type113 = null;


        CommonTree char_literal111_tree=null;
        CommonTree char_literal112_tree=null;
        CommonTree string_literal114_tree=null;
        CommonTree string_literal115_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:363:2: ( ( '!' p= predicate | e= expression | e= expression '.' type ) ( '&&' p= predicate | '||' p= predicate )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:363:5: ( '!' p= predicate | e= expression | e= expression '.' type ) ( '&&' p= predicate | '||' p= predicate )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:363:5: ( '!' p= predicate | e= expression | e= expression '.' type )
            int alt29=3;
            alt29 = dfa29.predict(input);
            switch (alt29) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:363:7: '!' p= predicate
                    {
                    _last = (CommonTree)input.LT(1);
                    char_literal111=(CommonTree)match(input,60,FOLLOW_60_in_predicate961); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal111_tree = (CommonTree)adaptor.dupNode(char_literal111);

                    adaptor.addChild(root_0, char_literal111_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_predicate965);
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:364:7: e= expression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate977);
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
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:365:7: e= expression '.' type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_predicate990);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, e.getTree());
                    _last = (CommonTree)input.LT(1);
                    char_literal112=(CommonTree)match(input,35,FOLLOW_35_in_predicate992); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal112_tree = (CommonTree)adaptor.dupNode(char_literal112);

                    adaptor.addChild(root_0, char_literal112_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_predicate994);
                    type113=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, type113.getTree());

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:366:6: ( '&&' p= predicate | '||' p= predicate )*
            loop30:
            do {
                int alt30=3;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==61) ) {
                    int LA30_2 = input.LA(2);

                    if ( (synpred50_WaebricInterpreter()) ) {
                        alt30=1;
                    }


                }
                else if ( (LA30_0==62) ) {
                    int LA30_3 = input.LA(2);

                    if ( (synpred51_WaebricInterpreter()) ) {
                        alt30=2;
                    }


                }


                switch (alt30) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:366:8: '&&' p= predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal114=(CommonTree)match(input,61,FOLLOW_61_in_predicate1004); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal114_tree = (CommonTree)adaptor.dupNode(string_literal114);

            	    adaptor.addChild(root_0, string_literal114_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate1008);
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
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:366:57: '||' p= predicate
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    string_literal115=(CommonTree)match(input,62,FOLLOW_62_in_predicate1014); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal115_tree = (CommonTree)adaptor.dupNode(string_literal115);

            	    adaptor.addChild(root_0, string_literal115_tree);
            	    }
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_predicate_in_predicate1018);
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
            	    break loop30;
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:368:1: type : ( 'list' | 'record' | 'string' );
    public final WaebricInterpreter.type_return type() throws RecognitionException {
        WaebricInterpreter.type_return retval = new WaebricInterpreter.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set116=null;

        CommonTree set116_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:368:5: ( 'list' | 'record' | 'string' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            set116=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=63 && input.LA(1)<=65) ) {
                input.consume();

                if ( state.backtracking==0 ) {
                set116_tree = (CommonTree)adaptor.dupNode(set116);

                adaptor.addChild(root_0, set116_tree);
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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:373:1: embedding : PRETEXT embed textTail ;
    public final WaebricInterpreter.embedding_return embedding() throws RecognitionException {
        WaebricInterpreter.embedding_return retval = new WaebricInterpreter.embedding_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PRETEXT117=null;
        WaebricInterpreter.embed_return embed118 = null;

        WaebricInterpreter.textTail_return textTail119 = null;


        CommonTree PRETEXT117_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:373:10: ( PRETEXT embed textTail )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:373:13: PRETEXT embed textTail
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            PRETEXT117=(CommonTree)match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding1056); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PRETEXT117_tree = (CommonTree)adaptor.dupNode(PRETEXT117);

            adaptor.addChild(root_0, PRETEXT117_tree);
            }
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_embed_in_embedding1058);
            embed118=embed();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, embed118.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_textTail_in_embedding1060);
            textTail119=textTail();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, textTail119.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:375:1: embed : ( ( markup )* expression | ( markup )* markup );
    public final WaebricInterpreter.embed_return embed() throws RecognitionException {
        WaebricInterpreter.embed_return retval = new WaebricInterpreter.embed_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        WaebricInterpreter.markup_return markup120 = null;

        WaebricInterpreter.expression_return expression121 = null;

        WaebricInterpreter.markup_return markup122 = null;

        WaebricInterpreter.markup_return markup123 = null;



        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:375:6: ( ( markup )* expression | ( markup )* markup )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==IDCON) ) {
                int LA33_1 = input.LA(2);

                if ( (synpred55_WaebricInterpreter()) ) {
                    alt33=1;
                }
                else if ( (true) ) {
                    alt33=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA33_0>=NATCON && LA33_0<=SYMBOLCON)||LA33_0==46||LA33_0==48) ) {
                alt33=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:375:10: ( markup )* expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:375:10: ( markup )*
                    loop31:
                    do {
                        int alt31=2;
                        alt31 = dfa31.predict(input);
                        switch (alt31) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed1070);
                    	    markup120=markup();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, markup120.getTree());

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_embed1073);
                    expression121=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expression121.getTree());
                    if ( state.backtracking==0 ) {
                       
                      					Text text = new Text((expression121!=null?expression121.eval:null));
                      					addContent(text); 
                      				
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:379:6: ( markup )* markup
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:379:6: ( markup )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==IDCON) ) {
                            int LA32_1 = input.LA(2);

                            if ( (synpred56_WaebricInterpreter()) ) {
                                alt32=1;
                            }


                        }


                        switch (alt32) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_markup_in_embed1083);
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
                    pushFollow(FOLLOW_markup_in_embed1086);
                    markup123=markup();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, markup123.getTree());

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
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:381:1: textTail : ( POSTTEXT | MIDTEXT embed textTail );
    public final WaebricInterpreter.textTail_return textTail() throws RecognitionException {
        WaebricInterpreter.textTail_return retval = new WaebricInterpreter.textTail_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POSTTEXT124=null;
        CommonTree MIDTEXT125=null;
        WaebricInterpreter.embed_return embed126 = null;

        WaebricInterpreter.textTail_return textTail127 = null;


        CommonTree POSTTEXT124_tree=null;
        CommonTree MIDTEXT125_tree=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:381:9: ( POSTTEXT | MIDTEXT embed textTail )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==POSTTEXT) ) {
                alt34=1;
            }
            else if ( (LA34_0==MIDTEXT) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:381:12: POSTTEXT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    POSTTEXT124=(CommonTree)match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail1095); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    POSTTEXT124_tree = (CommonTree)adaptor.dupNode(POSTTEXT124);

                    adaptor.addChild(root_0, POSTTEXT124_tree);
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:381:23: MIDTEXT embed textTail
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    MIDTEXT125=(CommonTree)match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail1099); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MIDTEXT125_tree = (CommonTree)adaptor.dupNode(MIDTEXT125);

                    adaptor.addChild(root_0, MIDTEXT125_tree);
                    }
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_embed_in_textTail1101);
                    embed126=embed();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, embed126.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_textTail_in_textTail1103);
                    textTail127=textTail();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, textTail127.getTree());

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

    // $ANTLR start synpred22_WaebricInterpreter
    public final void synpred22_WaebricInterpreter_fragment() throws RecognitionException {   
        WaebricInterpreter.expression_return e = null;


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:241:6: ( '+' e= expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:241:6: '+' e= expression
        {
        match(input,50,FOLLOW_50_in_synpred22_WaebricInterpreter444); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred22_WaebricInterpreter448);
        e=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred22_WaebricInterpreter

    // $ANTLR start synpred23_WaebricInterpreter
    public final void synpred23_WaebricInterpreter_fragment() throws RecognitionException {   
        CommonTree id=null;

        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:246:8: ( '.' id= IDCON )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:246:8: '.' id= IDCON
        {
        match(input,35,FOLLOW_35_in_synpred23_WaebricInterpreter460); if (state.failed) return ;
        id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_synpred23_WaebricInterpreter464); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred23_WaebricInterpreter

    // $ANTLR start synpred32_WaebricInterpreter
    public final void synpred32_WaebricInterpreter_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:278:6: ( ^( 'echo' expression ';' ) )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:278:6: ^( 'echo' expression ';' )
        {
        match(input,57,FOLLOW_57_in_synpred32_WaebricInterpreter573); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred32_WaebricInterpreter575);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred32_WaebricInterpreter577); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_WaebricInterpreter

    // $ANTLR start synpred33_WaebricInterpreter
    public final void synpred33_WaebricInterpreter_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:282:6: ( ^( 'echo' embedding ';' ) )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:282:6: ^( 'echo' embedding ';' )
        {
        match(input,57,FOLLOW_57_in_synpred33_WaebricInterpreter590); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_embedding_in_synpred33_WaebricInterpreter592);
        embedding();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred33_WaebricInterpreter594); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred33_WaebricInterpreter

    // $ANTLR start synpred37_WaebricInterpreter
    public final void synpred37_WaebricInterpreter_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:288:6: ( ^( MARKUP_STATEMENT ( markup )+ expression ';' ) )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:288:6: ^( MARKUP_STATEMENT ( markup )+ expression ';' )
        {
        match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_synpred37_WaebricInterpreter629); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:288:26: ( markup )+
        int cnt37=0;
        loop37:
        do {
            int alt37=2;
            alt37 = dfa37.predict(input);
            switch (alt37) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred37_WaebricInterpreter631);
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

        pushFollow(FOLLOW_expression_in_synpred37_WaebricInterpreter634);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred37_WaebricInterpreter636); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred37_WaebricInterpreter

    // $ANTLR start synpred39_WaebricInterpreter
    public final void synpred39_WaebricInterpreter_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:292:6: ( ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:292:6: ^( MARKUP_STATEMENT ( markup )+ embedding ';' )
        {
        match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_synpred39_WaebricInterpreter649); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:292:26: ( markup )+
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
        	    pushFollow(FOLLOW_markup_in_synpred39_WaebricInterpreter651);
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

        pushFollow(FOLLOW_embedding_in_synpred39_WaebricInterpreter654);
        embedding();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred39_WaebricInterpreter656); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_WaebricInterpreter

    // $ANTLR start synpred41_WaebricInterpreter
    public final void synpred41_WaebricInterpreter_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:293:6: ( ^( MARKUP_STATEMENT ( markup )+ ';' ) )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:293:6: ^( MARKUP_STATEMENT ( markup )+ ';' )
        {
        match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_synpred41_WaebricInterpreter667); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:293:26: ( markup )+
        int cnt39=0;
        loop39:
        do {
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==IDCON) ) {
                alt39=1;
            }


            switch (alt39) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred41_WaebricInterpreter669);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt39 >= 1 ) break loop39;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(39, input);
                    throw eee;
            }
            cnt39++;
        } while (true);

        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred41_WaebricInterpreter672); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred41_WaebricInterpreter

    // $ANTLR start synpred49_WaebricInterpreter
    public final void synpred49_WaebricInterpreter_fragment() throws RecognitionException {   
        WaebricInterpreter.expression_return e = null;


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:364:7: (e= expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:364:7: e= expression
        {
        pushFollow(FOLLOW_expression_in_synpred49_WaebricInterpreter977);
        e=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred49_WaebricInterpreter

    // $ANTLR start synpred50_WaebricInterpreter
    public final void synpred50_WaebricInterpreter_fragment() throws RecognitionException {   
        WaebricInterpreter.predicate_return p = null;


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:366:8: ( '&&' p= predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:366:8: '&&' p= predicate
        {
        match(input,61,FOLLOW_61_in_synpred50_WaebricInterpreter1004); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred50_WaebricInterpreter1008);
        p=predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred50_WaebricInterpreter

    // $ANTLR start synpred51_WaebricInterpreter
    public final void synpred51_WaebricInterpreter_fragment() throws RecognitionException {   
        WaebricInterpreter.predicate_return p = null;


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:366:57: ( '||' p= predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:366:57: '||' p= predicate
        {
        match(input,62,FOLLOW_62_in_synpred51_WaebricInterpreter1014); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred51_WaebricInterpreter1018);
        p=predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred51_WaebricInterpreter

    // $ANTLR start synpred55_WaebricInterpreter
    public final void synpred55_WaebricInterpreter_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:375:10: ( ( markup )* expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:375:10: ( markup )* expression
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:375:10: ( markup )*
        loop40:
        do {
            int alt40=2;
            alt40 = dfa40.predict(input);
            switch (alt40) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred55_WaebricInterpreter1070);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop40;
            }
        } while (true);

        pushFollow(FOLLOW_expression_in_synpred55_WaebricInterpreter1073);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred55_WaebricInterpreter

    // $ANTLR start synpred56_WaebricInterpreter
    public final void synpred56_WaebricInterpreter_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:379:6: ( markup )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:379:6: markup
        {
        pushFollow(FOLLOW_markup_in_synpred56_WaebricInterpreter1083);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred56_WaebricInterpreter

    // Delegated rules

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
    public final boolean synpred22_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_WaebricInterpreter_fragment(); // can never throw exception
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
    public final boolean synpred23_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_WaebricInterpreter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred55_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred55_WaebricInterpreter_fragment(); // can never throw exception
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
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA31 dfa31 = new DFA31(this);
    protected DFA37 dfa37 = new DFA37(this);
    protected DFA40 dfa40 = new DFA40(this);
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
            return "270:1: statement : ( ifStatement | eachStatement | letStatement | blockStatement | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) | ^( MARKUP_STATEMENT ( markup )+ ';' ) | ^( MARKUP_STATEMENT ( markup )+ s= statement ) );";
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
        "\2\5\2\uffff\2\5";
    static final String DFA19_maxS =
        "\1\60\1\62\2\uffff\1\5\1\62";
    static final String DFA19_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA19_specialS =
        "\6\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\1\1\uffff\3\2\44\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\7\uffff\1\2\21\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\3\uffff\1\3\1\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\7\uffff\1\2\21\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\3\uffff\1\3\1\uffff\1\3\1\uffff\1\2"
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
            return "()+ loopback of 288:26: ( markup )+";
        }
    }
    static final String DFA29_eotS =
        "\12\uffff";
    static final String DFA29_eofS =
        "\12\uffff";
    static final String DFA29_minS =
        "\1\5\1\uffff\6\0\2\uffff";
    static final String DFA29_maxS =
        "\1\74\1\uffff\6\0\2\uffff";
    static final String DFA29_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\1\3";
    static final String DFA29_specialS =
        "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\2\uffff}>";
    static final String[] DFA29_transitionS = {
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
            return "363:5: ( '!' p= predicate | e= expression | e= expression '.' type )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TreeNodeStream input = (TreeNodeStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA29_2 = input.LA(1);

                         
                        int index29_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index29_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA29_3 = input.LA(1);

                         
                        int index29_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index29_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA29_4 = input.LA(1);

                         
                        int index29_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index29_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA29_5 = input.LA(1);

                         
                        int index29_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index29_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA29_6 = input.LA(1);

                         
                        int index29_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index29_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA29_7 = input.LA(1);

                         
                        int index29_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index29_7);
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
    static final String DFA31_eotS =
        "\6\uffff";
    static final String DFA31_eofS =
        "\6\uffff";
    static final String DFA31_minS =
        "\2\5\2\uffff\2\5";
    static final String DFA31_maxS =
        "\1\60\1\62\2\uffff\1\5\1\62";
    static final String DFA31_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA31_specialS =
        "\6\uffff}>";
    static final String[] DFA31_transitionS = {
            "\1\1\1\uffff\3\2\44\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\2\uffff\2\2\25\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\3\uffff\1\3\1\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\2\uffff\2\2\25\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\3\uffff\1\3\1\uffff\1\3\1\uffff\1\2"
    };

    static final short[] DFA31_eot = DFA.unpackEncodedString(DFA31_eotS);
    static final short[] DFA31_eof = DFA.unpackEncodedString(DFA31_eofS);
    static final char[] DFA31_min = DFA.unpackEncodedStringToUnsignedChars(DFA31_minS);
    static final char[] DFA31_max = DFA.unpackEncodedStringToUnsignedChars(DFA31_maxS);
    static final short[] DFA31_accept = DFA.unpackEncodedString(DFA31_acceptS);
    static final short[] DFA31_special = DFA.unpackEncodedString(DFA31_specialS);
    static final short[][] DFA31_transition;

    static {
        int numStates = DFA31_transitionS.length;
        DFA31_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA31_transition[i] = DFA.unpackEncodedString(DFA31_transitionS[i]);
        }
    }

    class DFA31 extends DFA {

        public DFA31(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 31;
            this.eot = DFA31_eot;
            this.eof = DFA31_eof;
            this.min = DFA31_min;
            this.max = DFA31_max;
            this.accept = DFA31_accept;
            this.special = DFA31_special;
            this.transition = DFA31_transition;
        }
        public String getDescription() {
            return "()* loopback of 375:10: ( markup )*";
        }
    }
    static final String DFA37_eotS =
        "\6\uffff";
    static final String DFA37_eofS =
        "\6\uffff";
    static final String DFA37_minS =
        "\2\5\1\uffff\1\5\1\uffff\1\5";
    static final String DFA37_maxS =
        "\1\60\1\62\1\uffff\1\5\1\uffff\1\62";
    static final String DFA37_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String DFA37_specialS =
        "\6\uffff}>";
    static final String[] DFA37_transitionS = {
            "\1\1\1\uffff\3\2\44\uffff\1\2\1\uffff\1\2",
            "\1\4\1\uffff\3\4\7\uffff\1\2\21\uffff\1\3\1\uffff\4\4\1\uffff"+
            "\1\4\3\uffff\1\4\1\uffff\1\4\1\uffff\1\2",
            "",
            "\1\5",
            "",
            "\1\4\1\uffff\3\4\7\uffff\1\2\21\uffff\1\3\1\uffff\4\4\1\uffff"+
            "\1\4\3\uffff\1\4\1\uffff\1\4\1\uffff\1\2"
    };

    static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
    static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
    static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
    static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
    static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
    static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
    static final short[][] DFA37_transition;

    static {
        int numStates = DFA37_transitionS.length;
        DFA37_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
        }
    }

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = DFA37_eot;
            this.eof = DFA37_eof;
            this.min = DFA37_min;
            this.max = DFA37_max;
            this.accept = DFA37_accept;
            this.special = DFA37_special;
            this.transition = DFA37_transition;
        }
        public String getDescription() {
            return "()+ loopback of 288:26: ( markup )+";
        }
    }
    static final String DFA40_eotS =
        "\6\uffff";
    static final String DFA40_eofS =
        "\1\uffff\1\2\3\uffff\1\2";
    static final String DFA40_minS =
        "\2\5\2\uffff\2\5";
    static final String DFA40_maxS =
        "\1\60\1\62\2\uffff\1\5\1\62";
    static final String DFA40_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA40_specialS =
        "\6\uffff}>";
    static final String[] DFA40_transitionS = {
            "\1\1\1\uffff\3\2\44\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\31\uffff\1\4\1\uffff\4\3\1\uffff\1\3\3\uffff"+
            "\1\3\1\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\31\uffff\1\4\1\uffff\4\3\1\uffff\1\3\3\uffff"+
            "\1\3\1\uffff\1\3\1\uffff\1\2"
    };

    static final short[] DFA40_eot = DFA.unpackEncodedString(DFA40_eotS);
    static final short[] DFA40_eof = DFA.unpackEncodedString(DFA40_eofS);
    static final char[] DFA40_min = DFA.unpackEncodedStringToUnsignedChars(DFA40_minS);
    static final char[] DFA40_max = DFA.unpackEncodedStringToUnsignedChars(DFA40_maxS);
    static final short[] DFA40_accept = DFA.unpackEncodedString(DFA40_acceptS);
    static final short[] DFA40_special = DFA.unpackEncodedString(DFA40_specialS);
    static final short[][] DFA40_transition;

    static {
        int numStates = DFA40_transitionS.length;
        DFA40_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA40_transition[i] = DFA.unpackEncodedString(DFA40_transitionS[i]);
        }
    }

    class DFA40 extends DFA {

        public DFA40(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 40;
            this.eot = DFA40_eot;
            this.eof = DFA40_eof;
            this.min = DFA40_min;
            this.max = DFA40_max;
            this.accept = DFA40_accept;
            this.special = DFA40_special;
            this.transition = DFA40_transition;
        }
        public String getDescription() {
            return "()* loopback of 375:10: ( markup )*";
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
    public static final BitSet FOLLOW_IDCON_in_expression291 = new BitSet(new long[]{0x0004000800000002L});
    public static final BitSet FOLLOW_NATCON_in_expression302 = new BitSet(new long[]{0x0004000800000002L});
    public static final BitSet FOLLOW_TEXT_in_expression313 = new BitSet(new long[]{0x0004000800000002L});
    public static final BitSet FOLLOW_SYMBOLCON_in_expression324 = new BitSet(new long[]{0x0004000800000002L});
    public static final BitSet FOLLOW_46_in_expression335 = new BitSet(new long[]{0x0001C800000003A0L});
    public static final BitSet FOLLOW_expression_in_expression341 = new BitSet(new long[]{0x0000880000000000L});
    public static final BitSet FOLLOW_43_in_expression358 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_expression362 = new BitSet(new long[]{0x0000880000000000L});
    public static final BitSet FOLLOW_47_in_expression369 = new BitSet(new long[]{0x0004000800000002L});
    public static final BitSet FOLLOW_48_in_expression380 = new BitSet(new long[]{0x0002080000000020L});
    public static final BitSet FOLLOW_IDCON_in_expression386 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_expression388 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_expression392 = new BitSet(new long[]{0x0002080000000000L});
    public static final BitSet FOLLOW_43_in_expression409 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_expression413 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_expression415 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_expression419 = new BitSet(new long[]{0x0002080000000000L});
    public static final BitSet FOLLOW_49_in_expression426 = new BitSet(new long[]{0x0004000800000002L});
    public static final BitSet FOLLOW_50_in_expression444 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_expression448 = new BitSet(new long[]{0x0004000800000002L});
    public static final BitSet FOLLOW_35_in_expression460 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_expression464 = new BitSet(new long[]{0x0004000800000002L});
    public static final BitSet FOLLOW_51_in_function487 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_function489 = new BitSet(new long[]{0x0ED1040000014010L});
    public static final BitSet FOLLOW_formals_in_function491 = new BitSet(new long[]{0x0ED1000000014010L});
    public static final BitSet FOLLOW_statement_in_function494 = new BitSet(new long[]{0x0ED1000000014010L});
    public static final BitSet FOLLOW_END_in_function497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_formals506 = new BitSet(new long[]{0x0000100000000020L});
    public static final BitSet FOLLOW_IDCON_in_formals508 = new BitSet(new long[]{0x0000100000000020L});
    public static final BitSet FOLLOW_44_in_formals511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statement526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_eachStatement_in_statement533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_letStatement_in_statement540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blockStatement_in_statement547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMENT_in_statement556 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRCON_in_statement558 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement560 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_57_in_statement573 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement575 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement577 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_57_in_statement590 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_statement592 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement594 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_58_in_statement605 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement607 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement609 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_59_in_statement620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement629 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement631 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_statement634 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement636 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement649 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement651 = new BitSet(new long[]{0x0000000000000820L});
    public static final BitSet FOLLOW_embedding_in_statement654 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement656 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement667 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement669 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement672 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement684 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement686 = new BitSet(new long[]{0x0ED1000000004030L});
    public static final BitSet FOLLOW_statement_in_statement691 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_52_in_ifStatement711 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_42_in_ifStatement713 = new BitSet(new long[]{0x10014000000003A0L});
    public static final BitSet FOLLOW_predicate_in_ifStatement715 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ifStatement717 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_53_in_ifStatement728 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_54_in_eachStatement768 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_42_in_eachStatement770 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_eachStatement772 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_eachStatement774 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_eachStatement778 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_eachStatement780 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_48_in_blockStatement806 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_blockStatement812 = new BitSet(new long[]{0x0ED3000000004010L});
    public static final BitSet FOLLOW_49_in_blockStatement819 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_55_in_letStatement847 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_assignment_in_letStatement849 = new BitSet(new long[]{0x0108000000000020L});
    public static final BitSet FOLLOW_56_in_letStatement852 = new BitSet(new long[]{0x0ED1000000014010L});
    public static final BitSet FOLLOW_statement_in_letStatement858 = new BitSet(new long[]{0x0ED1000000014010L});
    public static final BitSet FOLLOW_END_in_letStatement863 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_varBinding_in_assignment877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funcBinding_in_assignment884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_varBinding902 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_varBinding904 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_varBinding908 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_varBinding910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_funcBinding931 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_funcBinding933 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_formals_in_funcBinding935 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_END_in_funcBinding939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_predicate961 = new BitSet(new long[]{0x10014000000003A0L});
    public static final BitSet FOLLOW_predicate_in_predicate965 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate977 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate990 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_predicate992 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_type_in_predicate994 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_61_in_predicate1004 = new BitSet(new long[]{0x10014000000003A0L});
    public static final BitSet FOLLOW_predicate_in_predicate1008 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_62_in_predicate1014 = new BitSet(new long[]{0x10014000000003A0L});
    public static final BitSet FOLLOW_predicate_in_predicate1018 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding1056 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_embed_in_embedding1058 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_textTail_in_embedding1060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed1070 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_embed1073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed1083 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_markup_in_embed1086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail1095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail1099 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_embed_in_textTail1101 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_textTail_in_textTail1103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_synpred22_WaebricInterpreter444 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_synpred22_WaebricInterpreter448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_synpred23_WaebricInterpreter460 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_synpred23_WaebricInterpreter464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_synpred32_WaebricInterpreter573 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_synpred32_WaebricInterpreter575 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred32_WaebricInterpreter577 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_57_in_synpred33_WaebricInterpreter590 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_synpred33_WaebricInterpreter592 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred33_WaebricInterpreter594 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_synpred37_WaebricInterpreter629 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred37_WaebricInterpreter631 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_synpred37_WaebricInterpreter634 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred37_WaebricInterpreter636 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_synpred39_WaebricInterpreter649 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred39_WaebricInterpreter651 = new BitSet(new long[]{0x0000000000000820L});
    public static final BitSet FOLLOW_embedding_in_synpred39_WaebricInterpreter654 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred39_WaebricInterpreter656 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_synpred41_WaebricInterpreter667 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred41_WaebricInterpreter669 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred41_WaebricInterpreter672 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_synpred49_WaebricInterpreter977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred50_WaebricInterpreter1004 = new BitSet(new long[]{0x10014000000003A0L});
    public static final BitSet FOLLOW_predicate_in_synpred50_WaebricInterpreter1008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_synpred51_WaebricInterpreter1014 = new BitSet(new long[]{0x10014000000003A0L});
    public static final BitSet FOLLOW_predicate_in_synpred51_WaebricInterpreter1018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred55_WaebricInterpreter1070 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_synpred55_WaebricInterpreter1073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred56_WaebricInterpreter1083 = new BitSet(new long[]{0x0000000000000002L});

}