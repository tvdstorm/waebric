// $ANTLR 3.1.2 /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g 2009-08-13 14:00:51

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDCON", "PATH", "NATCON", "TEXT", "SYMBOLCON", "STRCON", "PRETEXT", "POSTTEXT", "MIDTEXT", "COMMENT", "SITE", "END", "SEMICOLON", "LETTER", "DIGIT", "HEXADECIMAL", "PATHELEMENT", "FILEEXT", "STRCHAR", "ESCLAYOUT", "DECIMAL", "TEXTCHAR", "ESCQUOTE", "AMP", "CHARREF", "ENTREF", "SYMBOLCHAR", "COMMENTS", "LAYOUT", "'module'", "'.'", "'import'", "':'", "'#'", "'$'", "'@'", "'%'", "'('", "','", "')'", "'['", "']'", "'{'", "'}'", "'+'", "'def'", "'if'", "'else'", "'each'", "'let'", "'in'", "'echo'", "'cdata'", "'yield;'", "'='", "'!'", "'&&'", "'||'", "'list'", "'record'", "'string'"
    };
    public static final int T__64=64;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int LETTER=17;
    public static final int AMP=27;
    public static final int ESCLAYOUT=23;
    public static final int PATHELEMENT=20;
    public static final int PRETEXT=10;
    public static final int STRCON=9;
    public static final int TEXTCHAR=25;
    public static final int T__61=61;
    public static final int POSTTEXT=11;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int FILEEXT=21;
    public static final int T__52=52;
    public static final int COMMENTS=31;
    public static final int CHARREF=28;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int IDCON=4;
    public static final int PATH=5;
    public static final int T__59=59;
    public static final int STRCHAR=22;
    public static final int DIGIT=18;
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
    public static final int HEXADECIMAL=19;
    public static final int SEMICOLON=16;
    public static final int SYMBOLCHAR=30;
    public static final int TEXT=7;
    public static final int LAYOUT=32;
    public static final int NATCON=6;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int DECIMAL=24;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int ENTREF=29;
    public static final int ESCQUOTE=26;
    public static final int END=15;

    // delegates
    // delegators

    protected static class Environment_scope {
        Map<String,CommonTree> functions;
        Map<String,String> variables;
    }
    protected Stack Environment_stack = new Stack();


        public WaebricInterpreter(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public WaebricInterpreter(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return WaebricInterpreter.tokenNames; }
    public String getGrammarFileName() { return "/ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g"; }


    	public static Document document;
    	public static Element current;

    	public WaebricInterpreter(TreeNodeStream input, Map<String,CommonTree> functions) {
    		super(input);
    		document = new Document();
    		
    		// Attach function definitions to environment
    		Environment_scope base = new Environment_scope();
    		base.functions = functions;
    		base.variables = new HashMap<String,String>();
    		Environment_stack.push(base);
    	}
    	
    	private WaebricInterpreter(TreeNodeStream input, Stack environment) {
    		super(input);
    		
    		// Clone first element of environment stack for function definitions
    		this.Environment_stack = environment;
    	}
    	
    	/**
    	 * Interpret program
    	 * @param os: Output stream for interpreting main function
    	 */
    	public void interpretProgram(OutputStream os) throws RecognitionException {
    		// Interpret the main function
    		CommonTree main = getFunction("main");
    		if(main != null) {
    			interpretFunction(main);
    			outputDocument(document, os);
    		}
    	}
    	
    	/**
    	 * Interpret function
    	 * @param function: Function AST
    	 */
    	private void interpretFunction(CommonTree function) throws RecognitionException {
    		WaebricInterpreter instance = new WaebricInterpreter(
    			new CommonTreeNodeStream(function),
    			Environment_stack);
    		instance.function();
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
    	private CommonTree getFunction(String name) {
    		for(int i=Environment_stack.size()-1; i>=0; i--) {
    			if(((Environment_scope)Environment_stack.elementAt(i)).functions.containsKey(name)) {
    				return ((Environment_scope)Environment_stack.elementAt(i)).functions.get(name); 
    			}
    		} return null;
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
    	



    // $ANTLR start "site"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:171:1: site : 'site' mappings 'end' ;
    public final void site() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:171:5: ( 'site' mappings 'end' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:171:9: 'site' mappings 'end'
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:173:1: mappings : ( mapping )? ( ';' mapping )* ;
    public final void mappings() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:173:9: ( ( mapping )? ( ';' mapping )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:173:12: ( mapping )? ( ';' mapping )*
            {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:173:12: ( mapping )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==PATH) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: mapping
                    {
                    pushFollow(FOLLOW_mapping_in_mappings76);
                    mapping();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:173:21: ( ';' mapping )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==SEMICOLON) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:173:23: ';' mapping
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:175:1: mapping : PATH ':' markup ;
    public final void mapping() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:175:9: ( PATH ':' markup )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:175:12: PATH ':' markup
            {
            match(input,PATH,FOLLOW_PATH_in_mapping96); if (state.failed) return ;
            match(input,36,FOLLOW_36_in_mapping98); if (state.failed) return ;
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:180:1: markup : IDCON ( attribute )* ( arguments )? ;
    public final void markup() throws RecognitionException {
        CommonTree IDCON1=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:180:7: ( IDCON ( attribute )* ( arguments )? )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:180:11: IDCON ( attribute )* ( arguments )?
            {
            IDCON1=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_markup113); if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:180:17: ( attribute )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==34||(LA3_0>=36 && LA3_0<=39)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: attribute
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

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:180:28: ( arguments )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==41) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: arguments
                    {
                    pushFollow(FOLLOW_arguments_in_markup118);
                    arguments();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               // Designator lifted as it complicated argument exchange
              				CommonTree call = getFunction(IDCON1.getText());
              				if(call != null) {
              					// Interpret called function
              					interpretFunction(call);
              				} else {
              					// Process markup as XHTML tag
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:191:1: attribute : ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' w= NATCON ( '%' h= NATCON )? );
    public final void attribute() throws RecognitionException {
        CommonTree w=null;
        CommonTree h=null;
        CommonTree IDCON2=null;
        CommonTree IDCON3=null;
        CommonTree IDCON4=null;
        CommonTree IDCON5=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:191:10: ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' w= NATCON ( '%' h= NATCON )? )
            int alt6=5;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt6=1;
                }
                break;
            case 34:
                {
                alt6=2;
                }
                break;
            case 38:
                {
                alt6=3;
                }
                break;
            case 36:
                {
                alt6=4;
                }
                break;
            case 39:
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:191:13: '#' IDCON
                    {
                    match(input,37,FOLLOW_37_in_attribute130); if (state.failed) return ;
                    IDCON2=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute132); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       current.setAttribute("id", IDCON2.getText()); 
                    }

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:192:6: '.' IDCON
                    {
                    match(input,34,FOLLOW_34_in_attribute142); if (state.failed) return ;
                    IDCON3=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute144); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       current.setAttribute("class", IDCON3.getText()); 
                    }

                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:193:6: '$' IDCON
                    {
                    match(input,38,FOLLOW_38_in_attribute154); if (state.failed) return ;
                    IDCON4=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute156); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       current.setAttribute("name", IDCON4.getText()); 
                    }

                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:194:6: ':' IDCON
                    {
                    match(input,36,FOLLOW_36_in_attribute166); if (state.failed) return ;
                    IDCON5=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_attribute168); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       current.setAttribute("type", IDCON5.getText()); 
                    }

                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:195:6: '@' w= NATCON ( '%' h= NATCON )?
                    {
                    match(input,39,FOLLOW_39_in_attribute178); if (state.failed) return ;
                    w=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_attribute182); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       current.setAttribute("width", w.getText()); 
                    }
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:196:5: ( '%' h= NATCON )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==40) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:196:7: '%' h= NATCON
                            {
                            match(input,40,FOLLOW_40_in_attribute193); if (state.failed) return ;
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:198:1: arguments : '(' ( argument )? ( ',' argument )* ')' ;
    public final void arguments() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:198:10: ( '(' ( argument )? ( ',' argument )* ')' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:198:13: '(' ( argument )? ( ',' argument )* ')'
            {
            match(input,41,FOLLOW_41_in_arguments214); if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:198:17: ( argument )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==IDCON||(LA7_0>=NATCON && LA7_0<=SYMBOLCON)||LA7_0==44||LA7_0==46) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: argument
                    {
                    pushFollow(FOLLOW_argument_in_arguments216);
                    argument();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:198:27: ( ',' argument )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==42) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:198:29: ',' argument
            	    {
            	    match(input,42,FOLLOW_42_in_arguments221); if (state.failed) return ;
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

            match(input,43,FOLLOW_43_in_arguments228); if (state.failed) return ;

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:200:1: argument : expression ;
    public final void argument() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:200:9: ( expression )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:200:12: expression
            {
            pushFollow(FOLLOW_expression_in_argument237);
            expression();

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
    // $ANTLR end "argument"


    // $ANTLR start "expression"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:205:1: expression returns [String eval] : (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (p= keyValuePair )? ( ',' p= keyValuePair )* '}' ) ( '+' e= expression | '.' IDCON )* ;
    public final String expression() throws RecognitionException {
        String eval = null;

        CommonTree var=null;
        CommonTree NATCON6=null;
        CommonTree TEXT7=null;
        CommonTree SYMBOLCON8=null;
        String e = null;

        String p = null;


        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:206:2: ( (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (p= keyValuePair )? ( ',' p= keyValuePair )* '}' ) ( '+' e= expression | '.' IDCON )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:206:5: (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (p= keyValuePair )? ( ',' p= keyValuePair )* '}' ) ( '+' e= expression | '.' IDCON )*
            {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:206:5: (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (p= keyValuePair )? ( ',' p= keyValuePair )* '}' )
            int alt13=6;
            switch ( input.LA(1) ) {
            case IDCON:
                {
                alt13=1;
                }
                break;
            case NATCON:
                {
                alt13=2;
                }
                break;
            case TEXT:
                {
                alt13=3;
                }
                break;
            case SYMBOLCON:
                {
                alt13=4;
                }
                break;
            case 44:
                {
                alt13=5;
                }
                break;
            case 46:
                {
                alt13=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return eval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:206:7: var= IDCON
                    {
                    var=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression259); if (state.failed) return eval;
                    if ( state.backtracking==0 ) {
                       eval = getVariable(var.getText()); 
                    }

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:207:7: NATCON
                    {
                    NATCON6=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_expression269); if (state.failed) return eval;
                    if ( state.backtracking==0 ) {
                       eval = NATCON6.getText(); 
                    }

                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:208:7: TEXT
                    {
                    TEXT7=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_expression279); if (state.failed) return eval;
                    if ( state.backtracking==0 ) {
                       eval = TEXT7.getText(); 
                    }

                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:209:7: SYMBOLCON
                    {
                    SYMBOLCON8=(CommonTree)match(input,SYMBOLCON,FOLLOW_SYMBOLCON_in_expression289); if (state.failed) return eval;
                    if ( state.backtracking==0 ) {
                       eval = SYMBOLCON8.getText(); 
                    }

                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:210:7: '[' (e= expression )? ( ',' e= expression )* ']'
                    {
                    match(input,44,FOLLOW_44_in_expression299); if (state.failed) return eval;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:210:11: (e= expression )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==IDCON||(LA9_0>=NATCON && LA9_0<=SYMBOLCON)||LA9_0==44||LA9_0==46) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:210:13: e= expression
                            {
                            pushFollow(FOLLOW_expression_in_expression305);
                            e=expression();

                            state._fsp--;
                            if (state.failed) return eval;
                            if ( state.backtracking==0 ) {
                               eval = e; 
                            }

                            }
                            break;

                    }

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:210:50: ( ',' e= expression )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==42) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:210:52: ',' e= expression
                    	    {
                    	    match(input,42,FOLLOW_42_in_expression314); if (state.failed) return eval;
                    	    pushFollow(FOLLOW_expression_in_expression318);
                    	    e=expression();

                    	    state._fsp--;
                    	    if (state.failed) return eval;
                    	    if ( state.backtracking==0 ) {
                    	       eval += ", " + e ; 
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    match(input,45,FOLLOW_45_in_expression325); if (state.failed) return eval;

                    }
                    break;
                case 6 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:211:7: '{' (p= keyValuePair )? ( ',' p= keyValuePair )* '}'
                    {
                    match(input,46,FOLLOW_46_in_expression333); if (state.failed) return eval;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:211:11: (p= keyValuePair )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==IDCON) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:211:13: p= keyValuePair
                            {
                            pushFollow(FOLLOW_keyValuePair_in_expression339);
                            p=keyValuePair();

                            state._fsp--;
                            if (state.failed) return eval;
                            if ( state.backtracking==0 ) {
                               eval = p; 
                            }

                            }
                            break;

                    }

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:211:52: ( ',' p= keyValuePair )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==42) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:211:54: ',' p= keyValuePair
                    	    {
                    	    match(input,42,FOLLOW_42_in_expression348); if (state.failed) return eval;
                    	    pushFollow(FOLLOW_keyValuePair_in_expression352);
                    	    p=keyValuePair();

                    	    state._fsp--;
                    	    if (state.failed) return eval;
                    	    if ( state.backtracking==0 ) {
                    	       eval += ", " + p ; 
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    match(input,47,FOLLOW_47_in_expression359); if (state.failed) return eval;

                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:212:6: ( '+' e= expression | '.' IDCON )*
            loop14:
            do {
                int alt14=3;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==48) ) {
                    int LA14_2 = input.LA(2);

                    if ( (synpred21_WaebricInterpreter()) ) {
                        alt14=1;
                    }


                }
                else if ( (LA14_0==34) ) {
                    int LA14_3 = input.LA(2);

                    if ( (synpred22_WaebricInterpreter()) ) {
                        alt14=2;
                    }


                }


                switch (alt14) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:212:8: '+' e= expression
            	    {
            	    match(input,48,FOLLOW_48_in_expression369); if (state.failed) return eval;
            	    pushFollow(FOLLOW_expression_in_expression373);
            	    e=expression();

            	    state._fsp--;
            	    if (state.failed) return eval;
            	    if ( state.backtracking==0 ) {
            	       eval += e; 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:212:49: '.' IDCON
            	    {
            	    match(input,34,FOLLOW_34_in_expression379); if (state.failed) return eval;
            	    match(input,IDCON,FOLLOW_IDCON_in_expression381); if (state.failed) return eval;

            	    }
            	    break;

            	default :
            	    break loop14;
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:214:1: keyValuePair returns [String eval] : IDCON ':' e= expression ;
    public final String keyValuePair() throws RecognitionException {
        String eval = null;

        CommonTree IDCON9=null;
        String e = null;


        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:215:2: ( IDCON ':' e= expression )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:215:5: IDCON ':' e= expression
            {
            IDCON9=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_keyValuePair404); if (state.failed) return eval;
            match(input,36,FOLLOW_36_in_keyValuePair406); if (state.failed) return eval;
            pushFollow(FOLLOW_expression_in_keyValuePair410);
            e=expression();

            state._fsp--;
            if (state.failed) return eval;
            if ( state.backtracking==0 ) {
               eval = IDCON9.getText() + ":" + e; 
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:220:1: function : 'def' IDCON ( formals )? ( statement )* 'end' ;
    public final void function() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:220:9: ( 'def' IDCON ( formals )? ( statement )* 'end' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:220:12: 'def' IDCON ( formals )? ( statement )* 'end'
            {
            match(input,49,FOLLOW_49_in_function424); if (state.failed) return ;
            match(input,IDCON,FOLLOW_IDCON_in_function426); if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:220:24: ( formals )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==41) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: formals
                    {
                    pushFollow(FOLLOW_formals_in_function428);
                    formals();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:220:33: ( statement )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==IDCON||LA16_0==COMMENT||LA16_0==46||LA16_0==50||(LA16_0>=52 && LA16_0<=53)||(LA16_0>=55 && LA16_0<=57)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_function431);
            	    statement();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            match(input,END,FOLLOW_END_in_function434); if (state.failed) return ;

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:222:1: formals : '(' ( IDCON )* ')' ;
    public final void formals() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:222:8: ( '(' ( IDCON )* ')' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:222:11: '(' ( IDCON )* ')'
            {
            match(input,41,FOLLOW_41_in_formals443); if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:222:15: ( IDCON )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==IDCON) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: IDCON
            	    {
            	    match(input,IDCON,FOLLOW_IDCON_in_formals445); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            match(input,43,FOLLOW_43_in_formals448); if (state.failed) return ;

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:228:1: statement : ( ^( 'if' '(' predicate ')' t= . ( 'else' f= . )? ) | ^( 'each' '(' IDCON ':' expression ')' statement ) | letStatement | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( markup ( markup )* ';' ) | ^( markup ( markup )* ',' expression ';' ) | ^( markup ( markup )* ',' statement ) | ^( markup ( markup )* embedding ';' ) );
    public final void statement() throws RecognitionException {
        CommonTree STRCON11=null;
        CommonTree t=null;
        CommonTree f=null;
        boolean predicate10 = false;

        String expression12 = null;

        String expression13 = null;

        String expression14 = null;


         int ti = 0; int fi = 0; 
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:230:2: ( ^( 'if' '(' predicate ')' t= . ( 'else' f= . )? ) | ^( 'each' '(' IDCON ':' expression ')' statement ) | letStatement | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( markup ( markup )* ';' ) | ^( markup ( markup )* ',' expression ';' ) | ^( markup ( markup )* ',' statement ) | ^( markup ( markup )* embedding ';' ) )
            int alt24=13;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:230:5: ^( 'if' '(' predicate ')' t= . ( 'else' f= . )? )
                    {
                    match(input,50,FOLLOW_50_in_statement471); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,41,FOLLOW_41_in_statement473); if (state.failed) return ;
                    pushFollow(FOLLOW_predicate_in_statement475);
                    predicate10=predicate();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,43,FOLLOW_43_in_statement477); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       ti = input.index(); 
                    }
                    t=(CommonTree)input.LT(1);
                    matchAny(input); if (state.failed) return ;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:230:60: ( 'else' f= . )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==51) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:230:62: 'else' f= .
                            {
                            match(input,51,FOLLOW_51_in_statement488); if (state.failed) return ;
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
                      				 	if(predicate10) {
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
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:242:6: ^( 'each' '(' IDCON ':' expression ')' statement )
                    {
                    match(input,52,FOLLOW_52_in_statement510); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,41,FOLLOW_41_in_statement512); if (state.failed) return ;
                    match(input,IDCON,FOLLOW_IDCON_in_statement514); if (state.failed) return ;
                    match(input,36,FOLLOW_36_in_statement516); if (state.failed) return ;
                    pushFollow(FOLLOW_expression_in_statement518);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,43,FOLLOW_43_in_statement520); if (state.failed) return ;
                    pushFollow(FOLLOW_statement_in_statement522);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:243:6: letStatement
                    {
                    pushFollow(FOLLOW_letStatement_in_statement531);
                    letStatement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:244:6: ^( '{' ( statement )* '}' )
                    {
                    match(input,46,FOLLOW_46_in_statement540); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:244:13: ( statement )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==IDCON||LA19_0==COMMENT||LA19_0==46||LA19_0==50||(LA19_0>=52 && LA19_0<=53)||(LA19_0>=55 && LA19_0<=57)) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_statement542);
                    	    statement();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);

                    match(input,47,FOLLOW_47_in_statement545); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:245:6: ^( 'comment' STRCON ';' )
                    {
                    match(input,COMMENT,FOLLOW_COMMENT_in_statement556); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    STRCON11=(CommonTree)match(input,STRCON,FOLLOW_STRCON_in_statement558); if (state.failed) return ;
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement560); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					Comment comment = new Comment(STRCON11.getText());
                      					addContent(comment);
                      				
                    }

                    }
                    break;
                case 6 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:249:6: ^( 'echo' expression ';' )
                    {
                    match(input,55,FOLLOW_55_in_statement573); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_expression_in_statement575);
                    expression12=expression();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement577); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					Text text = new Text(expression12);
                      					addContent(text);
                      				
                    }

                    }
                    break;
                case 7 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:253:6: ^( 'echo' embedding ';' )
                    {
                    match(input,55,FOLLOW_55_in_statement590); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_embedding_in_statement592);
                    embedding();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement594); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:254:6: ^( 'cdata' expression ';' )
                    {
                    match(input,56,FOLLOW_56_in_statement605); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_expression_in_statement607);
                    expression13=expression();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement609); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					CDATA cdata = new CDATA(expression13);
                      					addContent(cdata);
                      				
                    }

                    }
                    break;
                case 9 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:258:6: 'yield;'
                    {
                    match(input,57,FOLLOW_57_in_statement620); if (state.failed) return ;

                    }
                    break;
                case 10 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:259:6: ^( markup ( markup )* ';' )
                    {
                    pushFollow(FOLLOW_markup_in_statement629);
                    markup();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:259:16: ( markup )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==IDCON) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_statement631);
                    	    markup();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement634); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;
                case 11 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:260:6: ^( markup ( markup )* ',' expression ';' )
                    {
                    pushFollow(FOLLOW_markup_in_statement645);
                    markup();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:260:16: ( markup )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==IDCON) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_statement647);
                    	    markup();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);

                    match(input,42,FOLLOW_42_in_statement650); if (state.failed) return ;
                    pushFollow(FOLLOW_expression_in_statement652);
                    expression14=expression();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement654); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       
                      					Text text = new Text(expression14);
                      					addContent(text);
                      				
                    }

                    }
                    break;
                case 12 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:264:6: ^( markup ( markup )* ',' statement )
                    {
                    pushFollow(FOLLOW_markup_in_statement667);
                    markup();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:264:16: ( markup )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==IDCON) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_statement669);
                    	    markup();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    match(input,42,FOLLOW_42_in_statement672); if (state.failed) return ;
                    pushFollow(FOLLOW_statement_in_statement674);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;
                case 13 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:265:6: ^( markup ( markup )* embedding ';' )
                    {
                    pushFollow(FOLLOW_markup_in_statement685);
                    markup();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:265:16: ( markup )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==IDCON) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_statement687);
                    	    markup();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);

                    pushFollow(FOLLOW_embedding_in_statement690);
                    embedding();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement692); if (state.failed) return ;

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


    // $ANTLR start "letStatement"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:267:1: letStatement : ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) ;
    public final void letStatement() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:268:2: ( ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:268:5: ^( 'let' ( assignment )+ 'in' ( statement )* 'end' )
            {
            match(input,53,FOLLOW_53_in_letStatement707); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:268:14: ( assignment )+
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
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: assignment
            	    {
            	    pushFollow(FOLLOW_assignment_in_letStatement709);
            	    assignment();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt25 >= 1 ) break loop25;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
            } while (true);

            match(input,54,FOLLOW_54_in_letStatement712); if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:268:31: ( statement )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==IDCON||LA26_0==COMMENT||LA26_0==46||LA26_0==50||(LA26_0>=52 && LA26_0<=53)||(LA26_0>=55 && LA26_0<=57)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_letStatement714);
            	    statement();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            match(input,END,FOLLOW_END_in_letStatement717); if (state.failed) return ;

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:273:1: assignment : ( IDCON '=' expression ';' | IDCON formals statement );
    public final void assignment() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:273:11: ( IDCON '=' expression ';' | IDCON formals statement )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==IDCON) ) {
                int LA27_1 = input.LA(2);

                if ( (LA27_1==58) ) {
                    alt27=1;
                }
                else if ( (LA27_1==41) ) {
                    alt27=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 27, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:273:14: IDCON '=' expression ';'
                    {
                    match(input,IDCON,FOLLOW_IDCON_in_assignment731); if (state.failed) return ;
                    match(input,58,FOLLOW_58_in_assignment733); if (state.failed) return ;
                    pushFollow(FOLLOW_expression_in_assignment735);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_assignment737); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:274:6: IDCON formals statement
                    {
                    match(input,IDCON,FOLLOW_IDCON_in_assignment745); if (state.failed) return ;
                    pushFollow(FOLLOW_formals_in_assignment747);
                    formals();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_statement_in_assignment749);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:279:1: predicate returns [boolean eval] : ( '!' p= predicate | e= expression | e= expression '.' type ) ( '&&' p= predicate | '||' p= predicate )* ;
    public final boolean predicate() throws RecognitionException {
        boolean eval = false;

        boolean p = false;

        String e = null;


        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:280:2: ( ( '!' p= predicate | e= expression | e= expression '.' type ) ( '&&' p= predicate | '||' p= predicate )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:280:5: ( '!' p= predicate | e= expression | e= expression '.' type ) ( '&&' p= predicate | '||' p= predicate )*
            {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:280:5: ( '!' p= predicate | e= expression | e= expression '.' type )
            int alt28=3;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:280:7: '!' p= predicate
                    {
                    match(input,59,FOLLOW_59_in_predicate770); if (state.failed) return eval;
                    pushFollow(FOLLOW_predicate_in_predicate774);
                    p=predicate();

                    state._fsp--;
                    if (state.failed) return eval;
                    if ( state.backtracking==0 ) {
                       eval = ! p; 
                    }

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:281:7: e= expression
                    {
                    pushFollow(FOLLOW_expression_in_predicate786);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return eval;
                    if ( state.backtracking==0 ) {
                       eval = getVariable(e) != null; 
                    }

                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:282:7: e= expression '.' type
                    {
                    pushFollow(FOLLOW_expression_in_predicate799);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return eval;
                    match(input,34,FOLLOW_34_in_predicate801); if (state.failed) return eval;
                    pushFollow(FOLLOW_type_in_predicate803);
                    type();

                    state._fsp--;
                    if (state.failed) return eval;

                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:283:6: ( '&&' p= predicate | '||' p= predicate )*
            loop29:
            do {
                int alt29=3;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==60) ) {
                    int LA29_2 = input.LA(2);

                    if ( (synpred49_WaebricInterpreter()) ) {
                        alt29=1;
                    }


                }
                else if ( (LA29_0==61) ) {
                    int LA29_3 = input.LA(2);

                    if ( (synpred50_WaebricInterpreter()) ) {
                        alt29=2;
                    }


                }


                switch (alt29) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:283:8: '&&' p= predicate
            	    {
            	    match(input,60,FOLLOW_60_in_predicate813); if (state.failed) return eval;
            	    pushFollow(FOLLOW_predicate_in_predicate817);
            	    p=predicate();

            	    state._fsp--;
            	    if (state.failed) return eval;
            	    if ( state.backtracking==0 ) {
            	       eval = eval && p; 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:283:57: '||' p= predicate
            	    {
            	    match(input,61,FOLLOW_61_in_predicate823); if (state.failed) return eval;
            	    pushFollow(FOLLOW_predicate_in_predicate827);
            	    p=predicate();

            	    state._fsp--;
            	    if (state.failed) return eval;
            	    if ( state.backtracking==0 ) {
            	       eval = eval || p; 
            	    }

            	    }
            	    break;

            	default :
            	    break loop29;
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:285:1: type : ( 'list' | 'record' | 'string' );
    public final void type() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:285:5: ( 'list' | 'record' | 'string' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:
            {
            if ( (input.LA(1)>=62 && input.LA(1)<=64) ) {
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:290:1: embedding : PRETEXT embed textTail ;
    public final void embedding() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:290:10: ( PRETEXT embed textTail )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:290:13: PRETEXT embed textTail
            {
            match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding865); if (state.failed) return ;
            pushFollow(FOLLOW_embed_in_embedding867);
            embed();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_textTail_in_embedding869);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:292:1: embed : ( ( markup )* expression | ( markup )* markup );
    public final void embed() throws RecognitionException {
        String expression15 = null;


        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:292:6: ( ( markup )* expression | ( markup )* markup )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==IDCON) ) {
                int LA32_1 = input.LA(2);

                if ( (synpred54_WaebricInterpreter()) ) {
                    alt32=1;
                }
                else if ( (true) ) {
                    alt32=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 32, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA32_0>=NATCON && LA32_0<=SYMBOLCON)||LA32_0==44||LA32_0==46) ) {
                alt32=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:292:10: ( markup )* expression
                    {
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:292:10: ( markup )*
                    loop30:
                    do {
                        int alt30=2;
                        alt30 = dfa30.predict(input);
                        switch (alt30) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_embed879);
                    	    markup();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);

                    pushFollow(FOLLOW_expression_in_embed882);
                    expression15=expression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       
                      					Text text = new Text(expression15);
                      					addContent(text); 
                      				
                    }

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:296:6: ( markup )* markup
                    {
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:296:6: ( markup )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==IDCON) ) {
                            int LA31_1 = input.LA(2);

                            if ( (synpred55_WaebricInterpreter()) ) {
                                alt31=1;
                            }


                        }


                        switch (alt31) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_embed892);
                    	    markup();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);

                    pushFollow(FOLLOW_markup_in_embed895);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:298:1: textTail : ( POSTTEXT | MIDTEXT embed textTail );
    public final void textTail() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:298:9: ( POSTTEXT | MIDTEXT embed textTail )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==POSTTEXT) ) {
                alt33=1;
            }
            else if ( (LA33_0==MIDTEXT) ) {
                alt33=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:298:12: POSTTEXT
                    {
                    match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail904); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:298:23: MIDTEXT embed textTail
                    {
                    match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail908); if (state.failed) return ;
                    pushFollow(FOLLOW_embed_in_textTail910);
                    embed();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_textTail_in_textTail912);
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

    // $ANTLR start synpred21_WaebricInterpreter
    public final void synpred21_WaebricInterpreter_fragment() throws RecognitionException {   
        String e = null;


        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:212:8: ( '+' e= expression )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:212:8: '+' e= expression
        {
        match(input,48,FOLLOW_48_in_synpred21_WaebricInterpreter369); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred21_WaebricInterpreter373);
        e=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_WaebricInterpreter

    // $ANTLR start synpred22_WaebricInterpreter
    public final void synpred22_WaebricInterpreter_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:212:49: ( '.' IDCON )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:212:49: '.' IDCON
        {
        match(input,34,FOLLOW_34_in_synpred22_WaebricInterpreter379); if (state.failed) return ;
        match(input,IDCON,FOLLOW_IDCON_in_synpred22_WaebricInterpreter381); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred22_WaebricInterpreter

    // $ANTLR start synpred33_WaebricInterpreter
    public final void synpred33_WaebricInterpreter_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:249:6: ( ^( 'echo' expression ';' ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:249:6: ^( 'echo' expression ';' )
        {
        match(input,55,FOLLOW_55_in_synpred33_WaebricInterpreter573); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred33_WaebricInterpreter575);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred33_WaebricInterpreter577); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred33_WaebricInterpreter

    // $ANTLR start synpred34_WaebricInterpreter
    public final void synpred34_WaebricInterpreter_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:253:6: ( ^( 'echo' embedding ';' ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:253:6: ^( 'echo' embedding ';' )
        {
        match(input,55,FOLLOW_55_in_synpred34_WaebricInterpreter590); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_embedding_in_synpred34_WaebricInterpreter592);
        embedding();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred34_WaebricInterpreter594); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred34_WaebricInterpreter

    // $ANTLR start synpred38_WaebricInterpreter
    public final void synpred38_WaebricInterpreter_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:259:6: ( ^( markup ( markup )* ';' ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:259:6: ^( markup ( markup )* ';' )
        {
        pushFollow(FOLLOW_markup_in_synpred38_WaebricInterpreter629);
        markup();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:259:16: ( markup )*
        loop38:
        do {
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==IDCON) ) {
                alt38=1;
            }


            switch (alt38) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred38_WaebricInterpreter631);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop38;
            }
        } while (true);

        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred38_WaebricInterpreter634); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred38_WaebricInterpreter

    // $ANTLR start synpred40_WaebricInterpreter
    public final void synpred40_WaebricInterpreter_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:260:6: ( ^( markup ( markup )* ',' expression ';' ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:260:6: ^( markup ( markup )* ',' expression ';' )
        {
        pushFollow(FOLLOW_markup_in_synpred40_WaebricInterpreter645);
        markup();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:260:16: ( markup )*
        loop39:
        do {
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==IDCON) ) {
                alt39=1;
            }


            switch (alt39) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred40_WaebricInterpreter647);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop39;
            }
        } while (true);

        match(input,42,FOLLOW_42_in_synpred40_WaebricInterpreter650); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred40_WaebricInterpreter652);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred40_WaebricInterpreter654); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred40_WaebricInterpreter

    // $ANTLR start synpred42_WaebricInterpreter
    public final void synpred42_WaebricInterpreter_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:264:6: ( ^( markup ( markup )* ',' statement ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:264:6: ^( markup ( markup )* ',' statement )
        {
        pushFollow(FOLLOW_markup_in_synpred42_WaebricInterpreter667);
        markup();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:264:16: ( markup )*
        loop40:
        do {
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==IDCON) ) {
                alt40=1;
            }


            switch (alt40) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred42_WaebricInterpreter669);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop40;
            }
        } while (true);

        match(input,42,FOLLOW_42_in_synpred42_WaebricInterpreter672); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred42_WaebricInterpreter674);
        statement();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred42_WaebricInterpreter

    // $ANTLR start synpred48_WaebricInterpreter
    public final void synpred48_WaebricInterpreter_fragment() throws RecognitionException {   
        String e = null;


        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:281:7: (e= expression )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:281:7: e= expression
        {
        pushFollow(FOLLOW_expression_in_synpred48_WaebricInterpreter786);
        e=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred48_WaebricInterpreter

    // $ANTLR start synpred49_WaebricInterpreter
    public final void synpred49_WaebricInterpreter_fragment() throws RecognitionException {   
        boolean p = false;


        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:283:8: ( '&&' p= predicate )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:283:8: '&&' p= predicate
        {
        match(input,60,FOLLOW_60_in_synpred49_WaebricInterpreter813); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred49_WaebricInterpreter817);
        p=predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred49_WaebricInterpreter

    // $ANTLR start synpred50_WaebricInterpreter
    public final void synpred50_WaebricInterpreter_fragment() throws RecognitionException {   
        boolean p = false;


        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:283:57: ( '||' p= predicate )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:283:57: '||' p= predicate
        {
        match(input,61,FOLLOW_61_in_synpred50_WaebricInterpreter823); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred50_WaebricInterpreter827);
        p=predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred50_WaebricInterpreter

    // $ANTLR start synpred54_WaebricInterpreter
    public final void synpred54_WaebricInterpreter_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:292:10: ( ( markup )* expression )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:292:10: ( markup )* expression
        {
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:292:10: ( markup )*
        loop41:
        do {
            int alt41=2;
            alt41 = dfa41.predict(input);
            switch (alt41) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred54_WaebricInterpreter879);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop41;
            }
        } while (true);

        pushFollow(FOLLOW_expression_in_synpred54_WaebricInterpreter882);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred54_WaebricInterpreter

    // $ANTLR start synpred55_WaebricInterpreter
    public final void synpred55_WaebricInterpreter_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:296:6: ( markup )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:296:6: markup
        {
        pushFollow(FOLLOW_markup_in_synpred55_WaebricInterpreter892);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred55_WaebricInterpreter

    // Delegated rules

    public final boolean synpred54_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_WaebricInterpreter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_WaebricInterpreter_fragment(); // can never throw exception
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
    public final boolean synpred40_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred40_WaebricInterpreter_fragment(); // can never throw exception
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
    public final boolean synpred38_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_WaebricInterpreter_fragment(); // can never throw exception
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


    protected DFA24 dfa24 = new DFA24(this);
    protected DFA28 dfa28 = new DFA28(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA41 dfa41 = new DFA41(this);
    static final String DFA24_eotS =
        "\20\uffff";
    static final String DFA24_eofS =
        "\20\uffff";
    static final String DFA24_minS =
        "\1\4\5\uffff\1\0\2\uffff\1\0\6\uffff";
    static final String DFA24_maxS =
        "\1\71\5\uffff\1\0\2\uffff\1\0\6\uffff";
    static final String DFA24_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\11\1\uffff\1\6\1\7\1"+
        "\12\1\13\1\14\1\15";
    static final String DFA24_specialS =
        "\6\uffff\1\0\2\uffff\1\1\6\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\11\10\uffff\1\5\40\uffff\1\4\3\uffff\1\1\1\uffff\1\2\1\3"+
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
            return "228:1: statement : ( ^( 'if' '(' predicate ')' t= . ( 'else' f= . )? ) | ^( 'each' '(' IDCON ':' expression ')' statement ) | letStatement | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( markup ( markup )* ';' ) | ^( markup ( markup )* ',' expression ';' ) | ^( markup ( markup )* ',' statement ) | ^( markup ( markup )* embedding ';' ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TreeNodeStream input = (TreeNodeStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA24_6 = input.LA(1);

                         
                        int index24_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_WaebricInterpreter()) ) {s = 10;}

                        else if ( (synpred34_WaebricInterpreter()) ) {s = 11;}

                         
                        input.seek(index24_6);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA24_9 = input.LA(1);

                         
                        int index24_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_WaebricInterpreter()) ) {s = 12;}

                        else if ( (synpred40_WaebricInterpreter()) ) {s = 13;}

                        else if ( (synpred42_WaebricInterpreter()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index24_9);
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
        "\12\uffff";
    static final String DFA28_eofS =
        "\12\uffff";
    static final String DFA28_minS =
        "\1\4\1\uffff\6\0\2\uffff";
    static final String DFA28_maxS =
        "\1\73\1\uffff\6\0\2\uffff";
    static final String DFA28_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\1\3";
    static final String DFA28_specialS =
        "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\2\uffff}>";
    static final String[] DFA28_transitionS = {
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
            return "280:5: ( '!' p= predicate | e= expression | e= expression '.' type )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TreeNodeStream input = (TreeNodeStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA28_2 = input.LA(1);

                         
                        int index28_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred48_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index28_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA28_3 = input.LA(1);

                         
                        int index28_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred48_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index28_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA28_4 = input.LA(1);

                         
                        int index28_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred48_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index28_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA28_5 = input.LA(1);

                         
                        int index28_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred48_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index28_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA28_6 = input.LA(1);

                         
                        int index28_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred48_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index28_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA28_7 = input.LA(1);

                         
                        int index28_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred48_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index28_7);
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
    static final String DFA30_eotS =
        "\6\uffff";
    static final String DFA30_eofS =
        "\6\uffff";
    static final String DFA30_minS =
        "\2\4\2\uffff\2\4";
    static final String DFA30_maxS =
        "\1\56\1\60\2\uffff\1\4\1\60";
    static final String DFA30_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA30_specialS =
        "\6\uffff}>";
    static final String[] DFA30_transitionS = {
            "\1\1\1\uffff\3\2\43\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\2\uffff\2\2\25\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\2\uffff\2\2\25\uffff\1\4\1\uffff\4\3\1\uffff"+
            "\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\2"
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
            return "()* loopback of 292:10: ( markup )*";
        }
    }
    static final String DFA41_eotS =
        "\6\uffff";
    static final String DFA41_eofS =
        "\1\uffff\1\2\3\uffff\1\2";
    static final String DFA41_minS =
        "\2\4\2\uffff\2\4";
    static final String DFA41_maxS =
        "\1\56\1\60\2\uffff\1\4\1\60";
    static final String DFA41_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA41_specialS =
        "\6\uffff}>";
    static final String[] DFA41_transitionS = {
            "\1\1\1\uffff\3\2\43\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\31\uffff\1\4\1\uffff\4\3\1\uffff\1\3\2\uffff"+
            "\1\3\1\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\31\uffff\1\4\1\uffff\4\3\1\uffff\1\3\2\uffff"+
            "\1\3\1\uffff\1\3\1\uffff\1\2"
    };

    static final short[] DFA41_eot = DFA.unpackEncodedString(DFA41_eotS);
    static final short[] DFA41_eof = DFA.unpackEncodedString(DFA41_eofS);
    static final char[] DFA41_min = DFA.unpackEncodedStringToUnsignedChars(DFA41_minS);
    static final char[] DFA41_max = DFA.unpackEncodedStringToUnsignedChars(DFA41_maxS);
    static final short[] DFA41_accept = DFA.unpackEncodedString(DFA41_acceptS);
    static final short[] DFA41_special = DFA.unpackEncodedString(DFA41_specialS);
    static final short[][] DFA41_transition;

    static {
        int numStates = DFA41_transitionS.length;
        DFA41_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA41_transition[i] = DFA.unpackEncodedString(DFA41_transitionS[i]);
        }
    }

    class DFA41 extends DFA {

        public DFA41(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 41;
            this.eot = DFA41_eot;
            this.eof = DFA41_eof;
            this.min = DFA41_min;
            this.max = DFA41_max;
            this.accept = DFA41_accept;
            this.special = DFA41_special;
            this.transition = DFA41_transition;
        }
        public String getDescription() {
            return "()* loopback of 292:10: ( markup )*";
        }
    }
 

    public static final BitSet FOLLOW_SITE_in_site63 = new BitSet(new long[]{0x0000000000018020L});
    public static final BitSet FOLLOW_mappings_in_site65 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_END_in_site67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mapping_in_mappings76 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_SEMICOLON_in_mappings81 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_mapping_in_mappings83 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_PATH_in_mapping96 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_mapping98 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_mapping100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_markup113 = new BitSet(new long[]{0x000002F400000002L});
    public static final BitSet FOLLOW_attribute_in_markup115 = new BitSet(new long[]{0x000002F400000002L});
    public static final BitSet FOLLOW_arguments_in_markup118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_attribute130 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_attribute142 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_attribute154 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_attribute166 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_attribute178 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NATCON_in_attribute182 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_attribute193 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NATCON_in_attribute197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_arguments214 = new BitSet(new long[]{0x00005C00000001D0L});
    public static final BitSet FOLLOW_argument_in_arguments216 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_42_in_arguments221 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_argument_in_arguments223 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_43_in_arguments228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_argument237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_expression259 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_NATCON_in_expression269 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_TEXT_in_expression279 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_SYMBOLCON_in_expression289 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_44_in_expression299 = new BitSet(new long[]{0x00007400000001D0L});
    public static final BitSet FOLLOW_expression_in_expression305 = new BitSet(new long[]{0x0000240000000000L});
    public static final BitSet FOLLOW_42_in_expression314 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_expression318 = new BitSet(new long[]{0x0000240000000000L});
    public static final BitSet FOLLOW_45_in_expression325 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_46_in_expression333 = new BitSet(new long[]{0x0000840000000010L});
    public static final BitSet FOLLOW_keyValuePair_in_expression339 = new BitSet(new long[]{0x0000840000000000L});
    public static final BitSet FOLLOW_42_in_expression348 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_keyValuePair_in_expression352 = new BitSet(new long[]{0x0000840000000000L});
    public static final BitSet FOLLOW_47_in_expression359 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_48_in_expression369 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_expression373 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_34_in_expression379 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_expression381 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_IDCON_in_keyValuePair404 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_keyValuePair406 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_keyValuePair410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_function424 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_function426 = new BitSet(new long[]{0x03B442000000A010L});
    public static final BitSet FOLLOW_formals_in_function428 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_statement_in_function431 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_END_in_function434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_formals443 = new BitSet(new long[]{0x0000080000000010L});
    public static final BitSet FOLLOW_IDCON_in_formals445 = new BitSet(new long[]{0x0000080000000010L});
    public static final BitSet FOLLOW_43_in_formals448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_statement471 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_41_in_statement473 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_statement475 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_statement477 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_51_in_statement488 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_52_in_statement510 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_41_in_statement512 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_statement514 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_statement516 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_statement518 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_statement520 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement522 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_letStatement_in_statement531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_statement540 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statement542 = new BitSet(new long[]{0x03B4C00000002010L});
    public static final BitSet FOLLOW_47_in_statement545 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COMMENT_in_statement556 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRCON_in_statement558 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement560 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_55_in_statement573 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement575 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement577 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_55_in_statement590 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_statement592 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement594 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_56_in_statement605 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement607 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement609 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_57_in_statement620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement629 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement631 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement634 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_statement645 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement647 = new BitSet(new long[]{0x0000040000000010L});
    public static final BitSet FOLLOW_42_in_statement650 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_statement652 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement654 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_statement667 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement669 = new BitSet(new long[]{0x0000040000000010L});
    public static final BitSet FOLLOW_42_in_statement672 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement674 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_statement685 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement687 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_embedding_in_statement690 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement692 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_53_in_letStatement707 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_assignment_in_letStatement709 = new BitSet(new long[]{0x0040000000000010L});
    public static final BitSet FOLLOW_54_in_letStatement712 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_statement_in_letStatement714 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_END_in_letStatement717 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDCON_in_assignment731 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_assignment733 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_assignment735 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_assignment737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_assignment745 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_formals_in_assignment747 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_assignment749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_predicate770 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_predicate774 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate786 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate799 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_predicate801 = new BitSet(new long[]{0xC000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_type_in_predicate803 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_60_in_predicate813 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_predicate817 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_61_in_predicate823 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_predicate827 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding865 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_embed_in_embedding867 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_textTail_in_embedding869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed879 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_embed882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed892 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_embed895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail908 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_embed_in_textTail910 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_textTail_in_textTail912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_synpred21_WaebricInterpreter369 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_synpred21_WaebricInterpreter373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_synpred22_WaebricInterpreter379 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_synpred22_WaebricInterpreter381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_synpred33_WaebricInterpreter573 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_synpred33_WaebricInterpreter575 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred33_WaebricInterpreter577 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_55_in_synpred34_WaebricInterpreter590 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_synpred34_WaebricInterpreter592 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred34_WaebricInterpreter594 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_synpred38_WaebricInterpreter629 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred38_WaebricInterpreter631 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred38_WaebricInterpreter634 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_synpred40_WaebricInterpreter645 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred40_WaebricInterpreter647 = new BitSet(new long[]{0x0000040000000010L});
    public static final BitSet FOLLOW_42_in_synpred40_WaebricInterpreter650 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_synpred40_WaebricInterpreter652 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred40_WaebricInterpreter654 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_synpred42_WaebricInterpreter667 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred42_WaebricInterpreter669 = new BitSet(new long[]{0x0000040000000010L});
    public static final BitSet FOLLOW_42_in_synpred42_WaebricInterpreter672 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_synpred42_WaebricInterpreter674 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_synpred48_WaebricInterpreter786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_synpred49_WaebricInterpreter813 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_synpred49_WaebricInterpreter817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred50_WaebricInterpreter823 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_synpred50_WaebricInterpreter827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred54_WaebricInterpreter879 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_synpred54_WaebricInterpreter882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred55_WaebricInterpreter892 = new BitSet(new long[]{0x0000000000000002L});

}