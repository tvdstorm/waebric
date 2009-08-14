// $ANTLR 3.1.2 /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g 2009-08-14 13:34:38

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
        Map<String, WaebricLoader.function_return> functions;
        Map<String, String> variables;
    }
    protected Stack Environment_stack = new Stack();


        public WaebricInterpreter(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public WaebricInterpreter(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
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
    			outputDocument(document, os);
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
    		WaebricLoader.function_return function = getFunction(name);
    		if(function != null) {
    			WaebricInterpreter instance = new WaebricInterpreter(new CommonTreeNodeStream(function.tree));
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
    			if(content instanceof Element) {
    				document.setRootElement((Element) content);
    			} else {
    				Element XHTML = createXHTMLTag();
        				document.setRootElement(XHTML);
        				XHTML.addContent(content);
    			}	
        			
    			current = document.getRootElement();
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
    	private WaebricLoader.function_return getFunction(String name) {
    		// Check local environments
    		for(int i=Environment_stack.size()-1; i>=0; i--) {
    			if(((Environment_scope)Environment_stack.elementAt(i)).functions.containsKey(name)) {
    				return ((Environment_scope)Environment_stack.elementAt(i)).functions.get(name); 
    			}
    		} 
    		
    		// Check base environment
    		return functions.containsKey(name) ? functions.get(name) : null ;
    	}
    	
    	/**
    	 * Define function
    	 * @param name: Function name
    	 * @param tree: Function AST
    	 */
    	private void defineFunction(String name, CommonTree tree, boolean yield) {
    		WaebricLoader.function_return val = new WaebricLoader.function_return();
    		val.tree = tree;
    		val.yield = yield;
    		((Environment_scope)Environment_stack.peek()).functions.put(name, val);
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
    	



    // $ANTLR start "site"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:181:1: site : 'site' mappings 'end' ;
    public final void site() throws RecognitionException {
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:181:5: ( 'site' mappings 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:181:9: 'site' mappings 'end'
            {
            match(input,SITE,FOLLOW_SITE_in_site63); if (state.failed) return ;
            pushFollow(FOLLOW_mappings_in_site65);
            mappings();

            state._fsp--;
            if (state.failed) return ;
            match(input,END,FOLLOW_END_in_site67); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "site"


    // $ANTLR start "mappings"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:183:1: mappings : ( mapping )? ( ';' mapping )* ;
    public final void mappings() throws RecognitionException {
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:183:9: ( ( mapping )? ( ';' mapping )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:183:12: ( mapping )? ( ';' mapping )*
            {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:183:12: ( mapping )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==PATH) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: mapping
                    {
                    pushFollow(FOLLOW_mapping_in_mappings76);
                    mapping();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:183:21: ( ';' mapping )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==SEMICOLON) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:183:23: ';' mapping
            	    {
            	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_mappings81); if (state.failed) return ;
            	    pushFollow(FOLLOW_mapping_in_mappings83);
            	    mapping();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "mappings"


    // $ANTLR start "mapping"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:185:1: mapping : PATH ':' markup ;
    public final void mapping() throws RecognitionException {
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:185:9: ( PATH ':' markup )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:185:12: PATH ':' markup
            {
            match(input,PATH,FOLLOW_PATH_in_mapping96); if (state.failed) return ;
            match(input,37,FOLLOW_37_in_mapping98); if (state.failed) return ;
            pushFollow(FOLLOW_markup_in_mapping100);
            markup();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "mapping"


    // $ANTLR start "markup"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:190:1: markup : IDCON ( attribute )* ( arguments )? ;
    public final void markup() throws RecognitionException {
        CommonTree IDCON1=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:190:7: ( IDCON ( attribute )* ( arguments )? )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:190:11: IDCON ( attribute )* ( arguments )?
            {
            IDCON1=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_markup113); if (state.failed) return ;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:190:17: ( attribute )*
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
            	    pushFollow(FOLLOW_attribute_in_markup115);
            	    attribute();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:190:28: ( arguments )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==42) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: arguments
                    {
                    pushFollow(FOLLOW_arguments_in_markup118);
                    arguments();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              				if(! interpretFunction(IDCON1.getText())) {
              					addContent(new Element(IDCON1.getText())); 
              				}
              			
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "markup"


    // $ANTLR start "attribute"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:196:1: attribute : ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' w= NATCON ( '%' h= NATCON )? );
    public final void attribute() throws RecognitionException {
        CommonTree w=null;
        CommonTree h=null;
        CommonTree IDCON2=null;
        CommonTree IDCON3=null;
        CommonTree IDCON4=null;
        CommonTree IDCON5=null;

        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:196:10: ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' w= NATCON ( '%' h= NATCON )? )
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:196:13: '#' IDCON
                    {
                    match(input,38,FOLLOW_38_in_attribute130); if (state.failed) return ;
                    IDCON2=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute132); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       current.setAttribute("id", IDCON2.getText()); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:197:6: '.' IDCON
                    {
                    match(input,35,FOLLOW_35_in_attribute142); if (state.failed) return ;
                    IDCON3=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute144); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       current.setAttribute("class", IDCON3.getText()); 
                    }

                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:198:6: '$' IDCON
                    {
                    match(input,39,FOLLOW_39_in_attribute154); if (state.failed) return ;
                    IDCON4=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute156); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       current.setAttribute("name", IDCON4.getText()); 
                    }

                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:199:6: ':' IDCON
                    {
                    match(input,37,FOLLOW_37_in_attribute166); if (state.failed) return ;
                    IDCON5=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute168); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       current.setAttribute("type", IDCON5.getText()); 
                    }

                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:200:6: '@' w= NATCON ( '%' h= NATCON )?
                    {
                    match(input,40,FOLLOW_40_in_attribute178); if (state.failed) return ;
                    w=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_attribute182); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       current.setAttribute("width", w.getText()); 
                    }
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:201:5: ( '%' h= NATCON )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==41) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:201:7: '%' h= NATCON
                            {
                            match(input,41,FOLLOW_41_in_attribute193); if (state.failed) return ;
                            h=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_attribute197); if (state.failed) return ;
                            if ( state.backtracking==0 ) {
                               current.setAttribute("height", h.getText()); 
                            }

                            }
                            break;

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "attribute"


    // $ANTLR start "arguments"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:203:1: arguments : '(' ( argument )? ( ',' argument )* ')' ;
    public final void arguments() throws RecognitionException {
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:203:10: ( '(' ( argument )? ( ',' argument )* ')' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:203:13: '(' ( argument )? ( ',' argument )* ')'
            {
            match(input,42,FOLLOW_42_in_arguments214); if (state.failed) return ;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:203:17: ( argument )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==IDCON||(LA7_0>=NATCON && LA7_0<=SYMBOLCON)||LA7_0==46||LA7_0==48) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: argument
                    {
                    pushFollow(FOLLOW_argument_in_arguments216);
                    argument();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:203:27: ( ',' argument )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==43) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:203:29: ',' argument
            	    {
            	    match(input,43,FOLLOW_43_in_arguments221); if (state.failed) return ;
            	    pushFollow(FOLLOW_argument_in_arguments223);
            	    argument();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match(input,44,FOLLOW_44_in_arguments228); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "arguments"


    // $ANTLR start "argument"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:205:1: argument : ( expression | IDCON '=' expression );
    public final void argument() throws RecognitionException {
        CommonTree IDCON6=null;
        String expression7 = null;


        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:205:9: ( expression | IDCON '=' expression )
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
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA9_0>=NATCON && LA9_0<=SYMBOLCON)||LA9_0==46||LA9_0==48) ) {
                alt9=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:205:12: expression
                    {
                    pushFollow(FOLLOW_expression_in_argument237);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:206:6: IDCON '=' expression
                    {
                    IDCON6=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_argument244); if (state.failed) return ;
                    match(input,45,FOLLOW_45_in_argument246); if (state.failed) return ;
                    pushFollow(FOLLOW_expression_in_argument248);
                    expression7=expression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       current.setAttribute(IDCON6.getText(), expression7); 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "argument"


    // $ANTLR start "expression"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:211:1: expression returns [String eval] : (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (p= keyValuePair )? ( ',' p= keyValuePair )* '}' ) ( '+' e= expression | '.' IDCON )* ;
    public final String expression() throws RecognitionException {
        String eval = null;

        CommonTree var=null;
        CommonTree NATCON8=null;
        CommonTree TEXT9=null;
        CommonTree SYMBOLCON10=null;
        String e = null;

        String p = null;


        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:212:2: ( (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (p= keyValuePair )? ( ',' p= keyValuePair )* '}' ) ( '+' e= expression | '.' IDCON )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:212:5: (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (p= keyValuePair )? ( ',' p= keyValuePair )* '}' ) ( '+' e= expression | '.' IDCON )*
            {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:212:5: (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (p= keyValuePair )? ( ',' p= keyValuePair )* '}' )
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
                if (state.backtracking>0) {state.failed=true; return eval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:212:7: var= IDCON
                    {
                    var=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression272); if (state.failed) return eval;
                    if ( state.backtracking==0 ) {
                       eval = getVariable(var.getText()); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:213:7: NATCON
                    {
                    NATCON8=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_expression282); if (state.failed) return eval;
                    if ( state.backtracking==0 ) {
                       eval = NATCON8.getText(); 
                    }

                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:214:7: TEXT
                    {
                    TEXT9=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_expression292); if (state.failed) return eval;
                    if ( state.backtracking==0 ) {
                       eval = TEXT9.getText(); 
                    }

                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:215:7: SYMBOLCON
                    {
                    SYMBOLCON10=(CommonTree)match(input,SYMBOLCON,FOLLOW_SYMBOLCON_in_expression302); if (state.failed) return eval;
                    if ( state.backtracking==0 ) {
                       eval = SYMBOLCON10.getText(); 
                    }

                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:216:7: '[' (e= expression )? ( ',' e= expression )* ']'
                    {
                    match(input,46,FOLLOW_46_in_expression312); if (state.failed) return eval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:216:11: (e= expression )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==IDCON||(LA10_0>=NATCON && LA10_0<=SYMBOLCON)||LA10_0==46||LA10_0==48) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:216:13: e= expression
                            {
                            pushFollow(FOLLOW_expression_in_expression318);
                            e=expression();

                            state._fsp--;
                            if (state.failed) return eval;
                            if ( state.backtracking==0 ) {
                               eval = e; 
                            }

                            }
                            break;

                    }

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:216:50: ( ',' e= expression )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==43) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:216:52: ',' e= expression
                    	    {
                    	    match(input,43,FOLLOW_43_in_expression327); if (state.failed) return eval;
                    	    pushFollow(FOLLOW_expression_in_expression331);
                    	    e=expression();

                    	    state._fsp--;
                    	    if (state.failed) return eval;
                    	    if ( state.backtracking==0 ) {
                    	       eval += ", " + e ; 
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    match(input,47,FOLLOW_47_in_expression338); if (state.failed) return eval;

                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:217:7: '{' (p= keyValuePair )? ( ',' p= keyValuePair )* '}'
                    {
                    match(input,48,FOLLOW_48_in_expression346); if (state.failed) return eval;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:217:11: (p= keyValuePair )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==IDCON) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:217:13: p= keyValuePair
                            {
                            pushFollow(FOLLOW_keyValuePair_in_expression352);
                            p=keyValuePair();

                            state._fsp--;
                            if (state.failed) return eval;
                            if ( state.backtracking==0 ) {
                               eval = p; 
                            }

                            }
                            break;

                    }

                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:217:52: ( ',' p= keyValuePair )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==43) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:217:54: ',' p= keyValuePair
                    	    {
                    	    match(input,43,FOLLOW_43_in_expression361); if (state.failed) return eval;
                    	    pushFollow(FOLLOW_keyValuePair_in_expression365);
                    	    p=keyValuePair();

                    	    state._fsp--;
                    	    if (state.failed) return eval;
                    	    if ( state.backtracking==0 ) {
                    	       eval += ", " + p ; 
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    match(input,49,FOLLOW_49_in_expression372); if (state.failed) return eval;

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:218:6: ( '+' e= expression | '.' IDCON )*
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
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:218:8: '+' e= expression
            	    {
            	    match(input,50,FOLLOW_50_in_expression382); if (state.failed) return eval;
            	    pushFollow(FOLLOW_expression_in_expression386);
            	    e=expression();

            	    state._fsp--;
            	    if (state.failed) return eval;
            	    if ( state.backtracking==0 ) {
            	       eval += e; 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:218:49: '.' IDCON
            	    {
            	    match(input,35,FOLLOW_35_in_expression392); if (state.failed) return eval;
            	    match(input,IDCON,FOLLOW_IDCON_in_expression394); if (state.failed) return eval;

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return eval;
    }
    // $ANTLR end "expression"


    // $ANTLR start "keyValuePair"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:220:1: keyValuePair returns [String eval] : IDCON ':' e= expression ;
    public final String keyValuePair() throws RecognitionException {
        String eval = null;

        CommonTree IDCON11=null;
        String e = null;


        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:221:2: ( IDCON ':' e= expression )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:221:5: IDCON ':' e= expression
            {
            IDCON11=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_keyValuePair417); if (state.failed) return eval;
            match(input,37,FOLLOW_37_in_keyValuePair419); if (state.failed) return eval;
            pushFollow(FOLLOW_expression_in_keyValuePair423);
            e=expression();

            state._fsp--;
            if (state.failed) return eval;
            if ( state.backtracking==0 ) {
               eval = IDCON11.getText() + ":" + e; 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return eval;
    }
    // $ANTLR end "keyValuePair"


    // $ANTLR start "function"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:226:1: function : 'def' IDCON ( formals )? ( statement )* 'end' ;
    public final void function() throws RecognitionException {
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:226:9: ( 'def' IDCON ( formals )? ( statement )* 'end' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:226:12: 'def' IDCON ( formals )? ( statement )* 'end'
            {
            match(input,51,FOLLOW_51_in_function437); if (state.failed) return ;
            match(input,IDCON,FOLLOW_IDCON_in_function439); if (state.failed) return ;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:226:24: ( formals )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==42) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: formals
                    {
                    pushFollow(FOLLOW_formals_in_function441);
                    formals();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:226:33: ( statement )*
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
            	    pushFollow(FOLLOW_statement_in_function444);
            	    statement();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            match(input,END,FOLLOW_END_in_function447); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "function"


    // $ANTLR start "formals"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:228:1: formals : '(' ( IDCON )* ')' ;
    public final void formals() throws RecognitionException {
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:228:8: ( '(' ( IDCON )* ')' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:228:11: '(' ( IDCON )* ')'
            {
            match(input,42,FOLLOW_42_in_formals456); if (state.failed) return ;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:228:15: ( IDCON )*
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
            	    match(input,IDCON,FOLLOW_IDCON_in_formals458); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            match(input,44,FOLLOW_44_in_formals461); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "formals"


    // $ANTLR start "statement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:234:1: statement : ( ifStatement | eachStatement | letStatement | blockStatement | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ^( MARKUP_STATEMENT ( markup )+ statement ) | ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) | ^( MARKUP_STATEMENT ( markup )+ ';' ) );
    public final void statement() throws RecognitionException {
        CommonTree STRCON12=null;
        String expression13 = null;

        String expression14 = null;

        String expression15 = null;


        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:235:2: ( ifStatement | eachStatement | letStatement | blockStatement | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ^( MARKUP_STATEMENT ( markup )+ statement ) | ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) | ^( MARKUP_STATEMENT ( markup )+ ';' ) )
            int alt23=13;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:235:5: ifStatement
                    {
                    pushFollow(FOLLOW_ifStatement_in_statement476);
                    ifStatement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:236:6: eachStatement
                    {
                    pushFollow(FOLLOW_eachStatement_in_statement483);
                    eachStatement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:237:6: letStatement
                    {
                    pushFollow(FOLLOW_letStatement_in_statement490);
                    letStatement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:238:6: blockStatement
                    {
                    pushFollow(FOLLOW_blockStatement_in_statement497);
                    blockStatement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:239:6: ^( 'comment' STRCON ';' )
                    {
                    match(input,COMMENT,FOLLOW_COMMENT_in_statement506); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    STRCON12=(CommonTree)match(input,STRCON,FOLLOW_STRCON_in_statement508); if (state.failed) return ;
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement510); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					Comment comment = new Comment(STRCON12.getText());
                      					addContent(comment);
                      				
                    }

                    }
                    break;
                case 6 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:243:6: ^( 'echo' expression ';' )
                    {
                    match(input,57,FOLLOW_57_in_statement523); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_expression_in_statement525);
                    expression13=expression();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement527); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					Text text = new Text(expression13);
                      					addContent(text);
                      				
                    }

                    }
                    break;
                case 7 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:247:6: ^( 'echo' embedding ';' )
                    {
                    match(input,57,FOLLOW_57_in_statement540); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_embedding_in_statement542);
                    embedding();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement544); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:248:6: ^( 'cdata' expression ';' )
                    {
                    match(input,58,FOLLOW_58_in_statement555); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_expression_in_statement557);
                    expression14=expression();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement559); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					CDATA cdata = new CDATA(expression14);
                      					addContent(cdata);
                      				
                    }

                    }
                    break;
                case 9 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:252:6: 'yield;'
                    {
                    match(input,59,FOLLOW_59_in_statement570); if (state.failed) return ;

                    }
                    break;
                case 10 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:253:6: ^( MARKUP_STATEMENT ( markup )+ expression ';' )
                    {
                    match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement579); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:253:26: ( markup )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        alt19 = dfa19.predict(input);
                        switch (alt19) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_statement581);
                    	    markup();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt19 >= 1 ) break loop19;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(19, input);
                                throw eee;
                        }
                        cnt19++;
                    } while (true);

                    pushFollow(FOLLOW_expression_in_statement584);
                    expression15=expression();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement586); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       
                      					Text text = new Text(expression15);
                      					addContent(text);
                      				
                    }

                    }
                    break;
                case 11 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:257:6: ^( MARKUP_STATEMENT ( markup )+ statement )
                    {
                    match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement599); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:257:26: ( markup )+
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
                    	    pushFollow(FOLLOW_markup_in_statement601);
                    	    markup();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt20 >= 1 ) break loop20;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);

                    pushFollow(FOLLOW_statement_in_statement604);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;
                case 12 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:258:6: ^( MARKUP_STATEMENT ( markup )+ embedding ';' )
                    {
                    match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement615); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:258:26: ( markup )+
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
                    	    pushFollow(FOLLOW_markup_in_statement617);
                    	    markup();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt21 >= 1 ) break loop21;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(21, input);
                                throw eee;
                        }
                        cnt21++;
                    } while (true);

                    pushFollow(FOLLOW_embedding_in_statement620);
                    embedding();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement622); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;
                case 13 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:259:6: ^( MARKUP_STATEMENT ( markup )+ ';' )
                    {
                    match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_statement633); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:259:26: ( markup )+
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
                    	    pushFollow(FOLLOW_markup_in_statement635);
                    	    markup();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt22 >= 1 ) break loop22;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(22, input);
                                throw eee;
                        }
                        cnt22++;
                    } while (true);

                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement638); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "statement"


    // $ANTLR start "ifStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:261:1: ifStatement : ^( 'if' '(' predicate ')' t= . ( 'else' f= . )? ) ;
    public final void ifStatement() throws RecognitionException {
        CommonTree t=null;
        CommonTree f=null;
        boolean predicate16 = false;


         int ti = 0; int fi = 0; 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:263:2: ( ^( 'if' '(' predicate ')' t= . ( 'else' f= . )? ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:263:5: ^( 'if' '(' predicate ')' t= . ( 'else' f= . )? )
            {
            match(input,52,FOLLOW_52_in_ifStatement658); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            match(input,42,FOLLOW_42_in_ifStatement660); if (state.failed) return ;
            pushFollow(FOLLOW_predicate_in_ifStatement662);
            predicate16=predicate();

            state._fsp--;
            if (state.failed) return ;
            match(input,44,FOLLOW_44_in_ifStatement664); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               ti = input.index(); 
            }
            t=(CommonTree)input.LT(1);
            matchAny(input); if (state.failed) return ;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:263:60: ( 'else' f= . )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==53) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:263:62: 'else' f= .
                    {
                    match(input,53,FOLLOW_53_in_ifStatement675); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       fi = input.index(); 
                    }
                    f=(CommonTree)input.LT(1);
                    matchAny(input); if (state.failed) return ;

                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              				int curr = input.index();
              				if(predicate16) {
              					input.seek(ti);
              					statement();
              					input.seek(curr);
              				} else if(f != null) {
              					input.seek(fi);
              					statement();
              					input.seek(curr);
              				}
              			
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ifStatement"


    // $ANTLR start "eachStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:276:1: eachStatement : ^( 'each' '(' IDCON ':' expression ')' statement ) ;
    public final void eachStatement() throws RecognitionException {
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:277:2: ( ^( 'each' '(' IDCON ':' expression ')' statement ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:277:5: ^( 'each' '(' IDCON ':' expression ')' statement )
            {
            match(input,54,FOLLOW_54_in_eachStatement704); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            match(input,42,FOLLOW_42_in_eachStatement706); if (state.failed) return ;
            match(input,IDCON,FOLLOW_IDCON_in_eachStatement708); if (state.failed) return ;
            match(input,37,FOLLOW_37_in_eachStatement710); if (state.failed) return ;
            pushFollow(FOLLOW_expression_in_eachStatement712);
            expression();

            state._fsp--;
            if (state.failed) return ;
            match(input,44,FOLLOW_44_in_eachStatement714); if (state.failed) return ;
            pushFollow(FOLLOW_statement_in_eachStatement716);
            statement();

            state._fsp--;
            if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "eachStatement"


    // $ANTLR start "blockStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:279:1: blockStatement : ^( '{' ( statement )* '}' ) ;
    public final void blockStatement() throws RecognitionException {
         Element actual = this.current; 
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:281:2: ( ^( '{' ( statement )* '}' ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:281:5: ^( '{' ( statement )* '}' )
            {
            match(input,48,FOLLOW_48_in_blockStatement737); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:281:12: ( statement )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==MARKUP_STATEMENT||LA25_0==COMMENT||LA25_0==48||LA25_0==52||(LA25_0>=54 && LA25_0<=55)||(LA25_0>=57 && LA25_0<=59)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_blockStatement739);
            	    statement();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               this.current = actual; 
            }
            match(input,49,FOLLOW_49_in_blockStatement744); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "blockStatement"


    // $ANTLR start "letStatement"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:283:1: letStatement : ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) ;
    public final void letStatement() throws RecognitionException {
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:284:2: ( ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:284:5: ^( 'let' ( assignment )+ 'in' ( statement )* 'end' )
            {
            match(input,55,FOLLOW_55_in_letStatement761); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:284:14: ( assignment )+
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
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: assignment
            	    {
            	    pushFollow(FOLLOW_assignment_in_letStatement763);
            	    assignment();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);

            match(input,56,FOLLOW_56_in_letStatement766); if (state.failed) return ;
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:284:31: ( statement )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==MARKUP_STATEMENT||LA27_0==COMMENT||LA27_0==48||LA27_0==52||(LA27_0>=54 && LA27_0<=55)||(LA27_0>=57 && LA27_0<=59)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_letStatement768);
            	    statement();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            match(input,END,FOLLOW_END_in_letStatement771); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "letStatement"


    // $ANTLR start "assignment"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:289:1: assignment : ( IDCON '=' expression ';' | IDCON formals '=' statement );
    public final void assignment() throws RecognitionException {
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:289:11: ( IDCON '=' expression ';' | IDCON formals '=' statement )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==IDCON) ) {
                int LA28_1 = input.LA(2);

                if ( (LA28_1==45) ) {
                    alt28=1;
                }
                else if ( (LA28_1==42) ) {
                    alt28=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:289:14: IDCON '=' expression ';'
                    {
                    match(input,IDCON,FOLLOW_IDCON_in_assignment785); if (state.failed) return ;
                    match(input,45,FOLLOW_45_in_assignment787); if (state.failed) return ;
                    pushFollow(FOLLOW_expression_in_assignment789);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_assignment791); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:290:6: IDCON formals '=' statement
                    {
                    match(input,IDCON,FOLLOW_IDCON_in_assignment799); if (state.failed) return ;
                    pushFollow(FOLLOW_formals_in_assignment801);
                    formals();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,45,FOLLOW_45_in_assignment803); if (state.failed) return ;
                    pushFollow(FOLLOW_statement_in_assignment805);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "assignment"


    // $ANTLR start "predicate"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:295:1: predicate returns [boolean eval] : ( '!' p= predicate | e= expression | e= expression '.' type ) ( '&&' p= predicate | '||' p= predicate )* ;
    public final boolean predicate() throws RecognitionException {
        boolean eval = false;

        boolean p = false;

        String e = null;


        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:296:2: ( ( '!' p= predicate | e= expression | e= expression '.' type ) ( '&&' p= predicate | '||' p= predicate )* )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:296:5: ( '!' p= predicate | e= expression | e= expression '.' type ) ( '&&' p= predicate | '||' p= predicate )*
            {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:296:5: ( '!' p= predicate | e= expression | e= expression '.' type )
            int alt29=3;
            alt29 = dfa29.predict(input);
            switch (alt29) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:296:7: '!' p= predicate
                    {
                    match(input,60,FOLLOW_60_in_predicate826); if (state.failed) return eval;
                    pushFollow(FOLLOW_predicate_in_predicate830);
                    p=predicate();

                    state._fsp--;
                    if (state.failed) return eval;
                    if ( state.backtracking==0 ) {
                       eval = ! p; 
                    }

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:297:7: e= expression
                    {
                    pushFollow(FOLLOW_expression_in_predicate842);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return eval;
                    if ( state.backtracking==0 ) {
                       eval = getVariable(e) != null; 
                    }

                    }
                    break;
                case 3 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:298:7: e= expression '.' type
                    {
                    pushFollow(FOLLOW_expression_in_predicate855);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return eval;
                    match(input,35,FOLLOW_35_in_predicate857); if (state.failed) return eval;
                    pushFollow(FOLLOW_type_in_predicate859);
                    type();

                    state._fsp--;
                    if (state.failed) return eval;

                    }
                    break;

            }

            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:299:6: ( '&&' p= predicate | '||' p= predicate )*
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
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:299:8: '&&' p= predicate
            	    {
            	    match(input,61,FOLLOW_61_in_predicate869); if (state.failed) return eval;
            	    pushFollow(FOLLOW_predicate_in_predicate873);
            	    p=predicate();

            	    state._fsp--;
            	    if (state.failed) return eval;
            	    if ( state.backtracking==0 ) {
            	       eval = eval && p; 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:299:57: '||' p= predicate
            	    {
            	    match(input,62,FOLLOW_62_in_predicate879); if (state.failed) return eval;
            	    pushFollow(FOLLOW_predicate_in_predicate883);
            	    p=predicate();

            	    state._fsp--;
            	    if (state.failed) return eval;
            	    if ( state.backtracking==0 ) {
            	       eval = eval || p; 
            	    }

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return eval;
    }
    // $ANTLR end "predicate"


    // $ANTLR start "type"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:301:1: type : ( 'list' | 'record' | 'string' );
    public final void type() throws RecognitionException {
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:301:5: ( 'list' | 'record' | 'string' )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:
            {
            if ( (input.LA(1)>=63 && input.LA(1)<=65) ) {
                input.consume();
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "type"


    // $ANTLR start "embedding"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:306:1: embedding : PRETEXT embed textTail ;
    public final void embedding() throws RecognitionException {
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:306:10: ( PRETEXT embed textTail )
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:306:13: PRETEXT embed textTail
            {
            match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding921); if (state.failed) return ;
            pushFollow(FOLLOW_embed_in_embedding923);
            embed();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_textTail_in_embedding925);
            textTail();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "embedding"


    // $ANTLR start "embed"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:308:1: embed : ( ( markup )* expression | ( markup )* markup );
    public final void embed() throws RecognitionException {
        String expression17 = null;


        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:308:6: ( ( markup )* expression | ( markup )* markup )
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
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA33_0>=NATCON && LA33_0<=SYMBOLCON)||LA33_0==46||LA33_0==48) ) {
                alt33=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:308:10: ( markup )* expression
                    {
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:308:10: ( markup )*
                    loop31:
                    do {
                        int alt31=2;
                        alt31 = dfa31.predict(input);
                        switch (alt31) {
                    	case 1 :
                    	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_embed935);
                    	    markup();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);

                    pushFollow(FOLLOW_expression_in_embed938);
                    expression17=expression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       
                      					Text text = new Text(expression17);
                      					addContent(text); 
                      				
                    }

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:312:6: ( markup )* markup
                    {
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:312:6: ( markup )*
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
                    	    pushFollow(FOLLOW_markup_in_embed948);
                    	    markup();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);

                    pushFollow(FOLLOW_markup_in_embed951);
                    markup();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "embed"


    // $ANTLR start "textTail"
    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:314:1: textTail : ( POSTTEXT | MIDTEXT embed textTail );
    public final void textTail() throws RecognitionException {
        try {
            // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:314:9: ( POSTTEXT | MIDTEXT embed textTail )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==POSTTEXT) ) {
                alt34=1;
            }
            else if ( (LA34_0==MIDTEXT) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:314:12: POSTTEXT
                    {
                    match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail960); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:314:23: MIDTEXT embed textTail
                    {
                    match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail964); if (state.failed) return ;
                    pushFollow(FOLLOW_embed_in_textTail966);
                    embed();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_textTail_in_textTail968);
                    textTail();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "textTail"

    // $ANTLR start synpred22_WaebricInterpreter
    public final void synpred22_WaebricInterpreter_fragment() throws RecognitionException {   
        String e = null;


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:218:8: ( '+' e= expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:218:8: '+' e= expression
        {
        match(input,50,FOLLOW_50_in_synpred22_WaebricInterpreter382); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred22_WaebricInterpreter386);
        e=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred22_WaebricInterpreter

    // $ANTLR start synpred23_WaebricInterpreter
    public final void synpred23_WaebricInterpreter_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:218:49: ( '.' IDCON )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:218:49: '.' IDCON
        {
        match(input,35,FOLLOW_35_in_synpred23_WaebricInterpreter392); if (state.failed) return ;
        match(input,IDCON,FOLLOW_IDCON_in_synpred23_WaebricInterpreter394); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred23_WaebricInterpreter

    // $ANTLR start synpred32_WaebricInterpreter
    public final void synpred32_WaebricInterpreter_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:243:6: ( ^( 'echo' expression ';' ) )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:243:6: ^( 'echo' expression ';' )
        {
        match(input,57,FOLLOW_57_in_synpred32_WaebricInterpreter523); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred32_WaebricInterpreter525);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred32_WaebricInterpreter527); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_WaebricInterpreter

    // $ANTLR start synpred33_WaebricInterpreter
    public final void synpred33_WaebricInterpreter_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:247:6: ( ^( 'echo' embedding ';' ) )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:247:6: ^( 'echo' embedding ';' )
        {
        match(input,57,FOLLOW_57_in_synpred33_WaebricInterpreter540); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_embedding_in_synpred33_WaebricInterpreter542);
        embedding();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred33_WaebricInterpreter544); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred33_WaebricInterpreter

    // $ANTLR start synpred37_WaebricInterpreter
    public final void synpred37_WaebricInterpreter_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:253:6: ( ^( MARKUP_STATEMENT ( markup )+ expression ';' ) )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:253:6: ^( MARKUP_STATEMENT ( markup )+ expression ';' )
        {
        match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_synpred37_WaebricInterpreter579); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:253:26: ( markup )+
        int cnt37=0;
        loop37:
        do {
            int alt37=2;
            alt37 = dfa37.predict(input);
            switch (alt37) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred37_WaebricInterpreter581);
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

        pushFollow(FOLLOW_expression_in_synpred37_WaebricInterpreter584);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred37_WaebricInterpreter586); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred37_WaebricInterpreter

    // $ANTLR start synpred39_WaebricInterpreter
    public final void synpred39_WaebricInterpreter_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:257:6: ( ^( MARKUP_STATEMENT ( markup )+ statement ) )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:257:6: ^( MARKUP_STATEMENT ( markup )+ statement )
        {
        match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_synpred39_WaebricInterpreter599); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:257:26: ( markup )+
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
        	    pushFollow(FOLLOW_markup_in_synpred39_WaebricInterpreter601);
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

        pushFollow(FOLLOW_statement_in_synpred39_WaebricInterpreter604);
        statement();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_WaebricInterpreter

    // $ANTLR start synpred41_WaebricInterpreter
    public final void synpred41_WaebricInterpreter_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:258:6: ( ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:258:6: ^( MARKUP_STATEMENT ( markup )+ embedding ';' )
        {
        match(input,MARKUP_STATEMENT,FOLLOW_MARKUP_STATEMENT_in_synpred41_WaebricInterpreter615); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:258:26: ( markup )+
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
        	    pushFollow(FOLLOW_markup_in_synpred41_WaebricInterpreter617);
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

        pushFollow(FOLLOW_embedding_in_synpred41_WaebricInterpreter620);
        embedding();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred41_WaebricInterpreter622); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred41_WaebricInterpreter

    // $ANTLR start synpred49_WaebricInterpreter
    public final void synpred49_WaebricInterpreter_fragment() throws RecognitionException {   
        String e = null;


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:297:7: (e= expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:297:7: e= expression
        {
        pushFollow(FOLLOW_expression_in_synpred49_WaebricInterpreter842);
        e=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred49_WaebricInterpreter

    // $ANTLR start synpred50_WaebricInterpreter
    public final void synpred50_WaebricInterpreter_fragment() throws RecognitionException {   
        boolean p = false;


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:299:8: ( '&&' p= predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:299:8: '&&' p= predicate
        {
        match(input,61,FOLLOW_61_in_synpred50_WaebricInterpreter869); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred50_WaebricInterpreter873);
        p=predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred50_WaebricInterpreter

    // $ANTLR start synpred51_WaebricInterpreter
    public final void synpred51_WaebricInterpreter_fragment() throws RecognitionException {   
        boolean p = false;


        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:299:57: ( '||' p= predicate )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:299:57: '||' p= predicate
        {
        match(input,62,FOLLOW_62_in_synpred51_WaebricInterpreter879); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred51_WaebricInterpreter883);
        p=predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred51_WaebricInterpreter

    // $ANTLR start synpred55_WaebricInterpreter
    public final void synpred55_WaebricInterpreter_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:308:10: ( ( markup )* expression )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:308:10: ( markup )* expression
        {
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:308:10: ( markup )*
        loop40:
        do {
            int alt40=2;
            alt40 = dfa40.predict(input);
            switch (alt40) {
        	case 1 :
        	    // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred55_WaebricInterpreter935);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop40;
            }
        } while (true);

        pushFollow(FOLLOW_expression_in_synpred55_WaebricInterpreter938);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred55_WaebricInterpreter

    // $ANTLR start synpred56_WaebricInterpreter
    public final void synpred56_WaebricInterpreter_fragment() throws RecognitionException {   
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:312:6: ( markup )
        // /Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:312:6: markup
        {
        pushFollow(FOLLOW_markup_in_synpred56_WaebricInterpreter948);
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
            return "234:1: statement : ( ifStatement | eachStatement | letStatement | blockStatement | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( MARKUP_STATEMENT ( markup )+ expression ';' ) | ^( MARKUP_STATEMENT ( markup )+ statement ) | ^( MARKUP_STATEMENT ( markup )+ embedding ';' ) | ^( MARKUP_STATEMENT ( markup )+ ';' ) );";
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
            return "()+ loopback of 253:26: ( markup )+";
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
            return "296:5: ( '!' p= predicate | e= expression | e= expression '.' type )";
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
            return "()* loopback of 308:10: ( markup )*";
        }
    }
    static final String DFA37_eotS =
        "\6\uffff";
    static final String DFA37_eofS =
        "\6\uffff";
    static final String DFA37_minS =
        "\2\5\2\uffff\2\5";
    static final String DFA37_maxS =
        "\1\60\1\62\2\uffff\1\5\1\62";
    static final String DFA37_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA37_specialS =
        "\6\uffff}>";
    static final String[] DFA37_transitionS = {
            "\1\1\1\uffff\3\2\44\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\7\uffff\1\2\21\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\3\uffff\1\3\1\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\7\uffff\1\2\21\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\3\uffff\1\3\1\uffff\1\3\1\uffff\1\2"
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
            return "()+ loopback of 253:26: ( markup )+";
        }
    }
    static final String DFA40_eotS =
        "\6\uffff";
    static final String DFA40_eofS =
        "\1\uffff\1\2\3\uffff\1\2";
    static final String DFA40_minS =
        "\2\5\1\uffff\1\5\1\uffff\1\5";
    static final String DFA40_maxS =
        "\1\60\1\62\1\uffff\1\5\1\uffff\1\62";
    static final String DFA40_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String DFA40_specialS =
        "\6\uffff}>";
    static final String[] DFA40_transitionS = {
            "\1\1\1\uffff\3\2\44\uffff\1\2\1\uffff\1\2",
            "\1\4\1\uffff\3\4\31\uffff\1\3\1\uffff\4\4\1\uffff\1\4\3\uffff"+
            "\1\4\1\uffff\1\4\1\uffff\1\2",
            "",
            "\1\5",
            "",
            "\1\4\1\uffff\3\4\31\uffff\1\3\1\uffff\4\4\1\uffff\1\4\3\uffff"+
            "\1\4\1\uffff\1\4\1\uffff\1\2"
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
            return "()* loopback of 308:10: ( markup )*";
        }
    }
 

    public static final BitSet FOLLOW_SITE_in_site63 = new BitSet(new long[]{0x0000000000030040L});
    public static final BitSet FOLLOW_mappings_in_site65 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_END_in_site67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapping_in_mappings76 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_SEMICOLON_in_mappings81 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_mapping_in_mappings83 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_PATH_in_mapping96 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_mapping98 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_markup_in_mapping100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_markup113 = new BitSet(new long[]{0x000005E800000002L});
    public static final BitSet FOLLOW_attribute_in_markup115 = new BitSet(new long[]{0x000005E800000002L});
    public static final BitSet FOLLOW_arguments_in_markup118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_attribute130 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_attribute132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_attribute142 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_attribute144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_attribute154 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_attribute156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_attribute166 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_attribute168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_attribute178 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NATCON_in_attribute182 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_attribute193 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NATCON_in_attribute197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_arguments214 = new BitSet(new long[]{0x00015800000003A0L});
    public static final BitSet FOLLOW_argument_in_arguments216 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_43_in_arguments221 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_argument_in_arguments223 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_44_in_arguments228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_argument237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_argument244 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_argument246 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_argument248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_expression272 = new BitSet(new long[]{0x0004000800000002L});
    public static final BitSet FOLLOW_NATCON_in_expression282 = new BitSet(new long[]{0x0004000800000002L});
    public static final BitSet FOLLOW_TEXT_in_expression292 = new BitSet(new long[]{0x0004000800000002L});
    public static final BitSet FOLLOW_SYMBOLCON_in_expression302 = new BitSet(new long[]{0x0004000800000002L});
    public static final BitSet FOLLOW_46_in_expression312 = new BitSet(new long[]{0x0001C800000003A0L});
    public static final BitSet FOLLOW_expression_in_expression318 = new BitSet(new long[]{0x0000880000000000L});
    public static final BitSet FOLLOW_43_in_expression327 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_expression331 = new BitSet(new long[]{0x0000880000000000L});
    public static final BitSet FOLLOW_47_in_expression338 = new BitSet(new long[]{0x0004000800000002L});
    public static final BitSet FOLLOW_48_in_expression346 = new BitSet(new long[]{0x0002080000000020L});
    public static final BitSet FOLLOW_keyValuePair_in_expression352 = new BitSet(new long[]{0x0002080000000000L});
    public static final BitSet FOLLOW_43_in_expression361 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_keyValuePair_in_expression365 = new BitSet(new long[]{0x0002080000000000L});
    public static final BitSet FOLLOW_49_in_expression372 = new BitSet(new long[]{0x0004000800000002L});
    public static final BitSet FOLLOW_50_in_expression382 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_expression386 = new BitSet(new long[]{0x0004000800000002L});
    public static final BitSet FOLLOW_35_in_expression392 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_expression394 = new BitSet(new long[]{0x0004000800000002L});
    public static final BitSet FOLLOW_IDCON_in_keyValuePair417 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_keyValuePair419 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_keyValuePair423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_function437 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_function439 = new BitSet(new long[]{0x0ED1040000014010L});
    public static final BitSet FOLLOW_formals_in_function441 = new BitSet(new long[]{0x0ED1000000014010L});
    public static final BitSet FOLLOW_statement_in_function444 = new BitSet(new long[]{0x0ED1000000014010L});
    public static final BitSet FOLLOW_END_in_function447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_formals456 = new BitSet(new long[]{0x0000100000000020L});
    public static final BitSet FOLLOW_IDCON_in_formals458 = new BitSet(new long[]{0x0000100000000020L});
    public static final BitSet FOLLOW_44_in_formals461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statement476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_eachStatement_in_statement483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_letStatement_in_statement490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blockStatement_in_statement497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMENT_in_statement506 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRCON_in_statement508 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement510 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_57_in_statement523 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement525 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement527 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_57_in_statement540 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_statement542 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement544 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_58_in_statement555 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement557 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement559 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_59_in_statement570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement579 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement581 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_statement584 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement586 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement599 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement601 = new BitSet(new long[]{0x0ED1000000004030L});
    public static final BitSet FOLLOW_statement_in_statement604 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement615 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement617 = new BitSet(new long[]{0x0000000000000820L});
    public static final BitSet FOLLOW_embedding_in_statement620 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement622 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_statement633 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement635 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement638 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_52_in_ifStatement658 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_42_in_ifStatement660 = new BitSet(new long[]{0x10014000000003A0L});
    public static final BitSet FOLLOW_predicate_in_ifStatement662 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ifStatement664 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_53_in_ifStatement675 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_54_in_eachStatement704 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_42_in_eachStatement706 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_eachStatement708 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_eachStatement710 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_eachStatement712 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_eachStatement714 = new BitSet(new long[]{0x0ED1000000004010L});
    public static final BitSet FOLLOW_statement_in_eachStatement716 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_48_in_blockStatement737 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_blockStatement739 = new BitSet(new long[]{0x0ED3000000004010L});
    public static final BitSet FOLLOW_49_in_blockStatement744 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_55_in_letStatement761 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_assignment_in_letStatement763 = new BitSet(new long[]{0x0100000000000020L});
    public static final BitSet FOLLOW_56_in_letStatement766 = new BitSet(new long[]{0x0ED1000000014010L});
    public static final BitSet FOLLOW_statement_in_letStatement768 = new BitSet(new long[]{0x0ED1000000014010L});
    public static final BitSet FOLLOW_END_in_letStatement771 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDCON_in_assignment785 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_assignment787 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_assignment789 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_assignment791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_assignment799 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_formals_in_assignment801 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_assignment803 = new BitSet(new long[]{0x0ED1000000004010L});
    public static final BitSet FOLLOW_statement_in_assignment805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_predicate826 = new BitSet(new long[]{0x10014000000003A0L});
    public static final BitSet FOLLOW_predicate_in_predicate830 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate842 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate855 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_predicate857 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_type_in_predicate859 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_61_in_predicate869 = new BitSet(new long[]{0x10014000000003A0L});
    public static final BitSet FOLLOW_predicate_in_predicate873 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_62_in_predicate879 = new BitSet(new long[]{0x10014000000003A0L});
    public static final BitSet FOLLOW_predicate_in_predicate883 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding921 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_embed_in_embedding923 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_textTail_in_embedding925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed935 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_embed938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed948 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_markup_in_embed951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail964 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_embed_in_textTail966 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_textTail_in_textTail968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_synpred22_WaebricInterpreter382 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_synpred22_WaebricInterpreter386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_synpred23_WaebricInterpreter392 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDCON_in_synpred23_WaebricInterpreter394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_synpred32_WaebricInterpreter523 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_synpred32_WaebricInterpreter525 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred32_WaebricInterpreter527 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_57_in_synpred33_WaebricInterpreter540 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_synpred33_WaebricInterpreter542 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred33_WaebricInterpreter544 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_synpred37_WaebricInterpreter579 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred37_WaebricInterpreter581 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_synpred37_WaebricInterpreter584 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred37_WaebricInterpreter586 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_synpred39_WaebricInterpreter599 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred39_WaebricInterpreter601 = new BitSet(new long[]{0x0ED1000000004030L});
    public static final BitSet FOLLOW_statement_in_synpred39_WaebricInterpreter604 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MARKUP_STATEMENT_in_synpred41_WaebricInterpreter615 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred41_WaebricInterpreter617 = new BitSet(new long[]{0x0000000000000820L});
    public static final BitSet FOLLOW_embedding_in_synpred41_WaebricInterpreter620 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred41_WaebricInterpreter622 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_synpred49_WaebricInterpreter842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred50_WaebricInterpreter869 = new BitSet(new long[]{0x10014000000003A0L});
    public static final BitSet FOLLOW_predicate_in_synpred50_WaebricInterpreter873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_synpred51_WaebricInterpreter879 = new BitSet(new long[]{0x10014000000003A0L});
    public static final BitSet FOLLOW_predicate_in_synpred51_WaebricInterpreter883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred55_WaebricInterpreter935 = new BitSet(new long[]{0x00014000000003A0L});
    public static final BitSet FOLLOW_expression_in_synpred55_WaebricInterpreter938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred56_WaebricInterpreter948 = new BitSet(new long[]{0x0000000000000002L});

}