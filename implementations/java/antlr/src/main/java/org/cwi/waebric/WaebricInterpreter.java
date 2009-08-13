// $ANTLR 3.1.2 /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g 2009-08-13 13:23:16

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


    	private Document document;
    	private Element current;

    	public WaebricInterpreter(TreeNodeStream input, Map<String,CommonTree> functions) {
    		super(input);
    		Environment_scope base = new Environment_scope();
    		base.functions = functions;
    		base.variables = new HashMap<String,String>();
    		Environment_stack.push(base);
    		document = new Document();
    	}
    	
    	private WaebricInterpreter(TreeNodeStream input, Stack environment, Document document, Element current) {
    		super(input);
    		this.Environment_stack = environment;
    		this.document = document;
    		this.current = current;
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
    			Environment_stack,
    			document,
    			current);
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
    				document.setRootElement(createXHTMLTag());
    				document.addContent(content);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:170:1: site : 'site' mappings 'end' ;
    public final void site() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:170:5: ( 'site' mappings 'end' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:170:9: 'site' mappings 'end'
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:172:1: mappings : ( mapping )? ( ';' mapping )* ;
    public final void mappings() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:172:9: ( ( mapping )? ( ';' mapping )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:172:12: ( mapping )? ( ';' mapping )*
            {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:172:12: ( mapping )?
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

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:172:21: ( ';' mapping )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==SEMICOLON) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:172:23: ';' mapping
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:174:1: mapping : PATH ':' markup ;
    public final void mapping() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:174:9: ( PATH ':' markup )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:174:12: PATH ':' markup
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:179:1: markup : IDCON ( attribute )* ( arguments )? ;
    public final void markup() throws RecognitionException {
        CommonTree IDCON1=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:179:7: ( IDCON ( attribute )* ( arguments )? )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:179:11: IDCON ( attribute )* ( arguments )?
            {
            IDCON1=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_markup113); if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:179:17: ( attribute )*
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

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:179:28: ( arguments )?
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:190:1: attribute : ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON );
    public final void attribute() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:190:10: ( '#' IDCON | '.' IDCON | '$' IDCON | ':' IDCON | '@' NATCON | '@' NATCON '%' NATCON )
            int alt5=6;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt5=1;
                }
                break;
            case 34:
                {
                alt5=2;
                }
                break;
            case 38:
                {
                alt5=3;
                }
                break;
            case 36:
                {
                alt5=4;
                }
                break;
            case 39:
                {
                int LA5_5 = input.LA(2);

                if ( (LA5_5==NATCON) ) {
                    int LA5_6 = input.LA(3);

                    if ( (LA5_6==40) ) {
                        alt5=6;
                    }
                    else if ( (LA5_6==EOF||LA5_6==DOWN||LA5_6==IDCON||(LA5_6>=NATCON && LA5_6<=SYMBOLCON)||(LA5_6>=PRETEXT && LA5_6<=MIDTEXT)||(LA5_6>=END && LA5_6<=SEMICOLON)||LA5_6==34||(LA5_6>=36 && LA5_6<=39)||(LA5_6>=41 && LA5_6<=42)||LA5_6==44||LA5_6==46) ) {
                        alt5=5;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 5, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:190:13: '#' IDCON
                    {
                    match(input,37,FOLLOW_37_in_attribute130); if (state.failed) return ;
                    match(input,IDCON,FOLLOW_IDCON_in_attribute132); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:191:6: '.' IDCON
                    {
                    match(input,34,FOLLOW_34_in_attribute140); if (state.failed) return ;
                    match(input,IDCON,FOLLOW_IDCON_in_attribute142); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:192:6: '$' IDCON
                    {
                    match(input,38,FOLLOW_38_in_attribute150); if (state.failed) return ;
                    match(input,IDCON,FOLLOW_IDCON_in_attribute152); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:193:6: ':' IDCON
                    {
                    match(input,36,FOLLOW_36_in_attribute160); if (state.failed) return ;
                    match(input,IDCON,FOLLOW_IDCON_in_attribute162); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:194:6: '@' NATCON
                    {
                    match(input,39,FOLLOW_39_in_attribute170); if (state.failed) return ;
                    match(input,NATCON,FOLLOW_NATCON_in_attribute172); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:195:6: '@' NATCON '%' NATCON
                    {
                    match(input,39,FOLLOW_39_in_attribute180); if (state.failed) return ;
                    match(input,NATCON,FOLLOW_NATCON_in_attribute182); if (state.failed) return ;
                    match(input,40,FOLLOW_40_in_attribute184); if (state.failed) return ;
                    match(input,NATCON,FOLLOW_NATCON_in_attribute186); if (state.failed) return ;

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:197:1: arguments : '(' ( argument )? ( ',' argument )* ')' ;
    public final void arguments() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:197:10: ( '(' ( argument )? ( ',' argument )* ')' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:197:13: '(' ( argument )? ( ',' argument )* ')'
            {
            match(input,41,FOLLOW_41_in_arguments198); if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:197:17: ( argument )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==IDCON||(LA6_0>=NATCON && LA6_0<=SYMBOLCON)||LA6_0==44||LA6_0==46) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: argument
                    {
                    pushFollow(FOLLOW_argument_in_arguments200);
                    argument();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:197:27: ( ',' argument )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==42) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:197:29: ',' argument
            	    {
            	    match(input,42,FOLLOW_42_in_arguments205); if (state.failed) return ;
            	    pushFollow(FOLLOW_argument_in_arguments207);
            	    argument();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match(input,43,FOLLOW_43_in_arguments212); if (state.failed) return ;

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:199:1: argument : expression ;
    public final void argument() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:199:9: ( expression )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:199:12: expression
            {
            pushFollow(FOLLOW_expression_in_argument221);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:204:1: expression returns [String eval] : (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (p= keyValuePair )? ( ',' p= keyValuePair )* '}' ) ( '+' e= expression | '.' IDCON )* ;
    public final String expression() throws RecognitionException {
        String eval = null;

        CommonTree var=null;
        CommonTree NATCON2=null;
        CommonTree TEXT3=null;
        CommonTree SYMBOLCON4=null;
        String e = null;

        String p = null;


        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:205:2: ( (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (p= keyValuePair )? ( ',' p= keyValuePair )* '}' ) ( '+' e= expression | '.' IDCON )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:205:5: (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (p= keyValuePair )? ( ',' p= keyValuePair )* '}' ) ( '+' e= expression | '.' IDCON )*
            {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:205:5: (var= IDCON | NATCON | TEXT | SYMBOLCON | '[' (e= expression )? ( ',' e= expression )* ']' | '{' (p= keyValuePair )? ( ',' p= keyValuePair )* '}' )
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
            case 44:
                {
                alt12=5;
                }
                break;
            case 46:
                {
                alt12=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return eval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:205:7: var= IDCON
                    {
                    var=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_expression243); if (state.failed) return eval;
                    if ( state.backtracking==0 ) {
                       eval = getVariable(var.getText()); 
                    }

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:206:7: NATCON
                    {
                    NATCON2=(CommonTree)match(input,NATCON,FOLLOW_NATCON_in_expression253); if (state.failed) return eval;
                    if ( state.backtracking==0 ) {
                       eval = NATCON2.getText(); 
                    }

                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:207:7: TEXT
                    {
                    TEXT3=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_expression263); if (state.failed) return eval;
                    if ( state.backtracking==0 ) {
                       eval = TEXT3.getText(); 
                    }

                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:208:7: SYMBOLCON
                    {
                    SYMBOLCON4=(CommonTree)match(input,SYMBOLCON,FOLLOW_SYMBOLCON_in_expression273); if (state.failed) return eval;
                    if ( state.backtracking==0 ) {
                       eval = SYMBOLCON4.getText(); 
                    }

                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:209:7: '[' (e= expression )? ( ',' e= expression )* ']'
                    {
                    match(input,44,FOLLOW_44_in_expression283); if (state.failed) return eval;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:209:11: (e= expression )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==IDCON||(LA8_0>=NATCON && LA8_0<=SYMBOLCON)||LA8_0==44||LA8_0==46) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:209:13: e= expression
                            {
                            pushFollow(FOLLOW_expression_in_expression289);
                            e=expression();

                            state._fsp--;
                            if (state.failed) return eval;
                            if ( state.backtracking==0 ) {
                               eval = e; 
                            }

                            }
                            break;

                    }

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:209:50: ( ',' e= expression )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==42) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:209:52: ',' e= expression
                    	    {
                    	    match(input,42,FOLLOW_42_in_expression298); if (state.failed) return eval;
                    	    pushFollow(FOLLOW_expression_in_expression302);
                    	    e=expression();

                    	    state._fsp--;
                    	    if (state.failed) return eval;
                    	    if ( state.backtracking==0 ) {
                    	       eval += ", " + e ; 
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    match(input,45,FOLLOW_45_in_expression309); if (state.failed) return eval;

                    }
                    break;
                case 6 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:210:7: '{' (p= keyValuePair )? ( ',' p= keyValuePair )* '}'
                    {
                    match(input,46,FOLLOW_46_in_expression317); if (state.failed) return eval;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:210:11: (p= keyValuePair )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==IDCON) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:210:13: p= keyValuePair
                            {
                            pushFollow(FOLLOW_keyValuePair_in_expression323);
                            p=keyValuePair();

                            state._fsp--;
                            if (state.failed) return eval;
                            if ( state.backtracking==0 ) {
                               eval = p; 
                            }

                            }
                            break;

                    }

                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:210:52: ( ',' p= keyValuePair )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==42) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:210:54: ',' p= keyValuePair
                    	    {
                    	    match(input,42,FOLLOW_42_in_expression332); if (state.failed) return eval;
                    	    pushFollow(FOLLOW_keyValuePair_in_expression336);
                    	    p=keyValuePair();

                    	    state._fsp--;
                    	    if (state.failed) return eval;
                    	    if ( state.backtracking==0 ) {
                    	       eval += ", " + p ; 
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    match(input,47,FOLLOW_47_in_expression343); if (state.failed) return eval;

                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:211:6: ( '+' e= expression | '.' IDCON )*
            loop13:
            do {
                int alt13=3;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==48) ) {
                    int LA13_2 = input.LA(2);

                    if ( (synpred21_WaebricInterpreter()) ) {
                        alt13=1;
                    }


                }
                else if ( (LA13_0==34) ) {
                    int LA13_3 = input.LA(2);

                    if ( (synpred22_WaebricInterpreter()) ) {
                        alt13=2;
                    }


                }


                switch (alt13) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:211:8: '+' e= expression
            	    {
            	    match(input,48,FOLLOW_48_in_expression353); if (state.failed) return eval;
            	    pushFollow(FOLLOW_expression_in_expression357);
            	    e=expression();

            	    state._fsp--;
            	    if (state.failed) return eval;
            	    if ( state.backtracking==0 ) {
            	       eval += e; 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:211:49: '.' IDCON
            	    {
            	    match(input,34,FOLLOW_34_in_expression363); if (state.failed) return eval;
            	    match(input,IDCON,FOLLOW_IDCON_in_expression365); if (state.failed) return eval;

            	    }
            	    break;

            	default :
            	    break loop13;
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:213:1: keyValuePair returns [String eval] : IDCON ':' e= expression ;
    public final String keyValuePair() throws RecognitionException {
        String eval = null;

        CommonTree IDCON5=null;
        String e = null;


        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:214:2: ( IDCON ':' e= expression )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:214:5: IDCON ':' e= expression
            {
            IDCON5=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_keyValuePair388); if (state.failed) return eval;
            match(input,36,FOLLOW_36_in_keyValuePair390); if (state.failed) return eval;
            pushFollow(FOLLOW_expression_in_keyValuePair394);
            e=expression();

            state._fsp--;
            if (state.failed) return eval;
            if ( state.backtracking==0 ) {
               eval = IDCON5.getText() + ":" + e; 
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:219:1: function : 'def' IDCON ( formals )? ( statement )* 'end' ;
    public final void function() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:219:9: ( 'def' IDCON ( formals )? ( statement )* 'end' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:219:12: 'def' IDCON ( formals )? ( statement )* 'end'
            {
            match(input,49,FOLLOW_49_in_function408); if (state.failed) return ;
            match(input,IDCON,FOLLOW_IDCON_in_function410); if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:219:24: ( formals )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==41) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: formals
                    {
                    pushFollow(FOLLOW_formals_in_function412);
                    formals();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:219:33: ( statement )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==IDCON||LA15_0==COMMENT||LA15_0==46||LA15_0==50||(LA15_0>=52 && LA15_0<=53)||(LA15_0>=55 && LA15_0<=57)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_function415);
            	    statement();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            match(input,END,FOLLOW_END_in_function418); if (state.failed) return ;

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:221:1: formals : '(' ( IDCON )* ')' ;
    public final void formals() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:221:8: ( '(' ( IDCON )* ')' )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:221:11: '(' ( IDCON )* ')'
            {
            match(input,41,FOLLOW_41_in_formals427); if (state.failed) return ;
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:221:15: ( IDCON )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==IDCON) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: IDCON
            	    {
            	    match(input,IDCON,FOLLOW_IDCON_in_formals429); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            match(input,43,FOLLOW_43_in_formals432); if (state.failed) return ;

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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:227:1: statement : ( ^( 'if' '(' predicate ')' t= . ( 'else' f= . )? ) | ^( 'each' '(' IDCON ':' expression ')' statement ) | ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( markup ';' ) | ^( markup ( markup )* ',' expression ';' ) | ^( markup ( markup )* ',' statement ) | ^( markup ( markup )* embedding ';' ) | ^( markup ( markup )* ';' ) );
    public final void statement() throws RecognitionException {
        CommonTree t=null;
        CommonTree f=null;
        boolean predicate6 = false;

        String expression7 = null;

        String expression8 = null;


         int ti = 0; int fi = 0; 
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:229:2: ( ^( 'if' '(' predicate ')' t= . ( 'else' f= . )? ) | ^( 'each' '(' IDCON ':' expression ')' statement ) | ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( markup ';' ) | ^( markup ( markup )* ',' expression ';' ) | ^( markup ( markup )* ',' statement ) | ^( markup ( markup )* embedding ';' ) | ^( markup ( markup )* ';' ) )
            int alt25=14;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:229:5: ^( 'if' '(' predicate ')' t= . ( 'else' f= . )? )
                    {
                    match(input,50,FOLLOW_50_in_statement455); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,41,FOLLOW_41_in_statement457); if (state.failed) return ;
                    pushFollow(FOLLOW_predicate_in_statement459);
                    predicate6=predicate();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,43,FOLLOW_43_in_statement461); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       ti = input.index(); 
                    }
                    t=(CommonTree)input.LT(1);
                    matchAny(input); if (state.failed) return ;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:229:60: ( 'else' f= . )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==51) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:229:62: 'else' f= .
                            {
                            match(input,51,FOLLOW_51_in_statement472); if (state.failed) return ;
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
                      				 	if(predicate6) {
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
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:241:6: ^( 'each' '(' IDCON ':' expression ')' statement )
                    {
                    match(input,52,FOLLOW_52_in_statement494); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,41,FOLLOW_41_in_statement496); if (state.failed) return ;
                    match(input,IDCON,FOLLOW_IDCON_in_statement498); if (state.failed) return ;
                    match(input,36,FOLLOW_36_in_statement500); if (state.failed) return ;
                    pushFollow(FOLLOW_expression_in_statement502);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,43,FOLLOW_43_in_statement504); if (state.failed) return ;
                    pushFollow(FOLLOW_statement_in_statement506);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:242:6: ^( 'let' ( assignment )+ 'in' ( statement )* 'end' )
                    {
                    match(input,53,FOLLOW_53_in_statement517); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:242:15: ( assignment )+
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
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: assignment
                    	    {
                    	    pushFollow(FOLLOW_assignment_in_statement519);
                    	    assignment();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt18 >= 1 ) break loop18;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(18, input);
                                throw eee;
                        }
                        cnt18++;
                    } while (true);

                    match(input,54,FOLLOW_54_in_statement522); if (state.failed) return ;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:242:32: ( statement )*
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
                    	    pushFollow(FOLLOW_statement_in_statement524);
                    	    statement();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);

                    match(input,END,FOLLOW_END_in_statement527); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:243:6: ^( '{' ( statement )* '}' )
                    {
                    match(input,46,FOLLOW_46_in_statement538); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:243:13: ( statement )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==IDCON||LA20_0==COMMENT||LA20_0==46||LA20_0==50||(LA20_0>=52 && LA20_0<=53)||(LA20_0>=55 && LA20_0<=57)) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_statement540);
                    	    statement();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    match(input,47,FOLLOW_47_in_statement543); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:244:6: ^( 'comment' STRCON ';' )
                    {
                    match(input,COMMENT,FOLLOW_COMMENT_in_statement554); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,STRCON,FOLLOW_STRCON_in_statement556); if (state.failed) return ;
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement558); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:245:6: ^( 'echo' expression ';' )
                    {
                    match(input,55,FOLLOW_55_in_statement569); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_expression_in_statement571);
                    expression7=expression();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement573); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       
                      					current.setText(expression7);
                      				
                    }

                    }
                    break;
                case 7 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:248:6: ^( 'echo' embedding ';' )
                    {
                    match(input,55,FOLLOW_55_in_statement586); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_embedding_in_statement588);
                    embedding();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement590); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:249:6: ^( 'cdata' expression ';' )
                    {
                    match(input,56,FOLLOW_56_in_statement601); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_expression_in_statement603);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement605); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;
                case 9 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:250:6: 'yield;'
                    {
                    match(input,57,FOLLOW_57_in_statement614); if (state.failed) return ;

                    }
                    break;
                case 10 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:251:6: ^( markup ';' )
                    {
                    pushFollow(FOLLOW_markup_in_statement623);
                    markup();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement625); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;
                case 11 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:252:6: ^( markup ( markup )* ',' expression ';' )
                    {
                    pushFollow(FOLLOW_markup_in_statement636);
                    markup();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:252:16: ( markup )*
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
                    	    pushFollow(FOLLOW_markup_in_statement638);
                    	    markup();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);

                    match(input,42,FOLLOW_42_in_statement641); if (state.failed) return ;
                    pushFollow(FOLLOW_expression_in_statement643);
                    expression8=expression();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement645); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       
                      					current.setText(expression8);
                      				
                    }

                    }
                    break;
                case 12 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:255:6: ^( markup ( markup )* ',' statement )
                    {
                    pushFollow(FOLLOW_markup_in_statement658);
                    markup();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:255:16: ( markup )*
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
                    	    pushFollow(FOLLOW_markup_in_statement660);
                    	    markup();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    match(input,42,FOLLOW_42_in_statement663); if (state.failed) return ;
                    pushFollow(FOLLOW_statement_in_statement665);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;
                case 13 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:256:6: ^( markup ( markup )* embedding ';' )
                    {
                    pushFollow(FOLLOW_markup_in_statement676);
                    markup();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:256:16: ( markup )*
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
                    	    pushFollow(FOLLOW_markup_in_statement678);
                    	    markup();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);

                    pushFollow(FOLLOW_embedding_in_statement681);
                    embedding();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement683); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;
                case 14 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:257:6: ^( markup ( markup )* ';' )
                    {
                    pushFollow(FOLLOW_markup_in_statement694);
                    markup();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:257:16: ( markup )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==IDCON) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_statement696);
                    	    markup();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement699); if (state.failed) return ;

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


    // $ANTLR start "assignment"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:262:1: assignment : ( IDCON '=' expression ';' | IDCON formals statement );
    public final void assignment() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:262:11: ( IDCON '=' expression ';' | IDCON formals statement )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==IDCON) ) {
                int LA26_1 = input.LA(2);

                if ( (LA26_1==58) ) {
                    alt26=1;
                }
                else if ( (LA26_1==41) ) {
                    alt26=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:262:14: IDCON '=' expression ';'
                    {
                    match(input,IDCON,FOLLOW_IDCON_in_assignment712); if (state.failed) return ;
                    match(input,58,FOLLOW_58_in_assignment714); if (state.failed) return ;
                    pushFollow(FOLLOW_expression_in_assignment716);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_assignment718); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:263:6: IDCON formals statement
                    {
                    match(input,IDCON,FOLLOW_IDCON_in_assignment726); if (state.failed) return ;
                    pushFollow(FOLLOW_formals_in_assignment728);
                    formals();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_statement_in_assignment730);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:268:1: predicate returns [boolean eval] : ( '!' p= predicate | expression | expression '.' type ) ( '&&' p= predicate | '||' p= predicate )* ;
    public final boolean predicate() throws RecognitionException {
        boolean eval = false;

        boolean p = false;


        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:269:2: ( ( '!' p= predicate | expression | expression '.' type ) ( '&&' p= predicate | '||' p= predicate )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:269:5: ( '!' p= predicate | expression | expression '.' type ) ( '&&' p= predicate | '||' p= predicate )*
            {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:269:5: ( '!' p= predicate | expression | expression '.' type )
            int alt27=3;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:269:7: '!' p= predicate
                    {
                    match(input,59,FOLLOW_59_in_predicate751); if (state.failed) return eval;
                    pushFollow(FOLLOW_predicate_in_predicate755);
                    p=predicate();

                    state._fsp--;
                    if (state.failed) return eval;
                    if ( state.backtracking==0 ) {
                       eval = ! p; 
                    }

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:270:7: expression
                    {
                    pushFollow(FOLLOW_expression_in_predicate765);
                    expression();

                    state._fsp--;
                    if (state.failed) return eval;

                    }
                    break;
                case 3 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:271:7: expression '.' type
                    {
                    pushFollow(FOLLOW_expression_in_predicate774);
                    expression();

                    state._fsp--;
                    if (state.failed) return eval;
                    match(input,34,FOLLOW_34_in_predicate776); if (state.failed) return eval;
                    pushFollow(FOLLOW_type_in_predicate778);
                    type();

                    state._fsp--;
                    if (state.failed) return eval;

                    }
                    break;

            }

            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:272:6: ( '&&' p= predicate | '||' p= predicate )*
            loop28:
            do {
                int alt28=3;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==60) ) {
                    int LA28_2 = input.LA(2);

                    if ( (synpred50_WaebricInterpreter()) ) {
                        alt28=1;
                    }


                }
                else if ( (LA28_0==61) ) {
                    int LA28_3 = input.LA(2);

                    if ( (synpred51_WaebricInterpreter()) ) {
                        alt28=2;
                    }


                }


                switch (alt28) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:272:8: '&&' p= predicate
            	    {
            	    match(input,60,FOLLOW_60_in_predicate788); if (state.failed) return eval;
            	    pushFollow(FOLLOW_predicate_in_predicate792);
            	    p=predicate();

            	    state._fsp--;
            	    if (state.failed) return eval;
            	    if ( state.backtracking==0 ) {
            	       eval = eval && p; 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:272:57: '||' p= predicate
            	    {
            	    match(input,61,FOLLOW_61_in_predicate798); if (state.failed) return eval;
            	    pushFollow(FOLLOW_predicate_in_predicate802);
            	    p=predicate();

            	    state._fsp--;
            	    if (state.failed) return eval;
            	    if ( state.backtracking==0 ) {
            	       eval = eval || p; 
            	    }

            	    }
            	    break;

            	default :
            	    break loop28;
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:274:1: type : ( 'list' | 'record' | 'string' );
    public final void type() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:274:5: ( 'list' | 'record' | 'string' )
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:279:1: embedding : PRETEXT embed textTail ;
    public final void embedding() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:279:10: ( PRETEXT embed textTail )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:279:13: PRETEXT embed textTail
            {
            match(input,PRETEXT,FOLLOW_PRETEXT_in_embedding840); if (state.failed) return ;
            pushFollow(FOLLOW_embed_in_embedding842);
            embed();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_textTail_in_embedding844);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:281:1: embed : ( ( markup )* expression | ( markup )* markup );
    public final void embed() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:281:6: ( ( markup )* expression | ( markup )* markup )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==IDCON) ) {
                int LA31_1 = input.LA(2);

                if ( (synpred55_WaebricInterpreter()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA31_0>=NATCON && LA31_0<=SYMBOLCON)||LA31_0==44||LA31_0==46) ) {
                alt31=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:281:10: ( markup )* expression
                    {
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:281:10: ( markup )*
                    loop29:
                    do {
                        int alt29=2;
                        alt29 = dfa29.predict(input);
                        switch (alt29) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_embed854);
                    	    markup();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);

                    pushFollow(FOLLOW_expression_in_embed857);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:281:31: ( markup )* markup
                    {
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:281:31: ( markup )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==IDCON) ) {
                            int LA30_1 = input.LA(2);

                            if ( (synpred56_WaebricInterpreter()) ) {
                                alt30=1;
                            }


                        }


                        switch (alt30) {
                    	case 1 :
                    	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
                    	    {
                    	    pushFollow(FOLLOW_markup_in_embed861);
                    	    markup();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);

                    pushFollow(FOLLOW_markup_in_embed864);
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
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:283:1: textTail : ( POSTTEXT | MIDTEXT embed textTail );
    public final void textTail() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:283:9: ( POSTTEXT | MIDTEXT embed textTail )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==POSTTEXT) ) {
                alt32=1;
            }
            else if ( (LA32_0==MIDTEXT) ) {
                alt32=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:283:12: POSTTEXT
                    {
                    match(input,POSTTEXT,FOLLOW_POSTTEXT_in_textTail873); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:283:23: MIDTEXT embed textTail
                    {
                    match(input,MIDTEXT,FOLLOW_MIDTEXT_in_textTail877); if (state.failed) return ;
                    pushFollow(FOLLOW_embed_in_textTail879);
                    embed();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_textTail_in_textTail881);
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


        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:211:8: ( '+' e= expression )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:211:8: '+' e= expression
        {
        match(input,48,FOLLOW_48_in_synpred21_WaebricInterpreter353); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred21_WaebricInterpreter357);
        e=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_WaebricInterpreter

    // $ANTLR start synpred22_WaebricInterpreter
    public final void synpred22_WaebricInterpreter_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:211:49: ( '.' IDCON )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:211:49: '.' IDCON
        {
        match(input,34,FOLLOW_34_in_synpred22_WaebricInterpreter363); if (state.failed) return ;
        match(input,IDCON,FOLLOW_IDCON_in_synpred22_WaebricInterpreter365); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred22_WaebricInterpreter

    // $ANTLR start synpred35_WaebricInterpreter
    public final void synpred35_WaebricInterpreter_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:245:6: ( ^( 'echo' expression ';' ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:245:6: ^( 'echo' expression ';' )
        {
        match(input,55,FOLLOW_55_in_synpred35_WaebricInterpreter569); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred35_WaebricInterpreter571);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred35_WaebricInterpreter573); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred35_WaebricInterpreter

    // $ANTLR start synpred36_WaebricInterpreter
    public final void synpred36_WaebricInterpreter_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:248:6: ( ^( 'echo' embedding ';' ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:248:6: ^( 'echo' embedding ';' )
        {
        match(input,55,FOLLOW_55_in_synpred36_WaebricInterpreter586); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_embedding_in_synpred36_WaebricInterpreter588);
        embedding();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred36_WaebricInterpreter590); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred36_WaebricInterpreter

    // $ANTLR start synpred39_WaebricInterpreter
    public final void synpred39_WaebricInterpreter_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:251:6: ( ^( markup ';' ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:251:6: ^( markup ';' )
        {
        pushFollow(FOLLOW_markup_in_synpred39_WaebricInterpreter623);
        markup();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred39_WaebricInterpreter625); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_WaebricInterpreter

    // $ANTLR start synpred41_WaebricInterpreter
    public final void synpred41_WaebricInterpreter_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:252:6: ( ^( markup ( markup )* ',' expression ';' ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:252:6: ^( markup ( markup )* ',' expression ';' )
        {
        pushFollow(FOLLOW_markup_in_synpred41_WaebricInterpreter636);
        markup();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:252:16: ( markup )*
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
        	    pushFollow(FOLLOW_markup_in_synpred41_WaebricInterpreter638);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop39;
            }
        } while (true);

        match(input,42,FOLLOW_42_in_synpred41_WaebricInterpreter641); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred41_WaebricInterpreter643);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred41_WaebricInterpreter645); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred41_WaebricInterpreter

    // $ANTLR start synpred43_WaebricInterpreter
    public final void synpred43_WaebricInterpreter_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:255:6: ( ^( markup ( markup )* ',' statement ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:255:6: ^( markup ( markup )* ',' statement )
        {
        pushFollow(FOLLOW_markup_in_synpred43_WaebricInterpreter658);
        markup();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:255:16: ( markup )*
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
        	    pushFollow(FOLLOW_markup_in_synpred43_WaebricInterpreter660);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop40;
            }
        } while (true);

        match(input,42,FOLLOW_42_in_synpred43_WaebricInterpreter663); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred43_WaebricInterpreter665);
        statement();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred43_WaebricInterpreter

    // $ANTLR start synpred45_WaebricInterpreter
    public final void synpred45_WaebricInterpreter_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:256:6: ( ^( markup ( markup )* embedding ';' ) )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:256:6: ^( markup ( markup )* embedding ';' )
        {
        pushFollow(FOLLOW_markup_in_synpred45_WaebricInterpreter676);
        markup();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:256:16: ( markup )*
        loop41:
        do {
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==IDCON) ) {
                alt41=1;
            }


            switch (alt41) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred45_WaebricInterpreter678);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop41;
            }
        } while (true);

        pushFollow(FOLLOW_embedding_in_synpred45_WaebricInterpreter681);
        embedding();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred45_WaebricInterpreter683); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred45_WaebricInterpreter

    // $ANTLR start synpred49_WaebricInterpreter
    public final void synpred49_WaebricInterpreter_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:270:7: ( expression )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:270:7: expression
        {
        pushFollow(FOLLOW_expression_in_synpred49_WaebricInterpreter765);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred49_WaebricInterpreter

    // $ANTLR start synpred50_WaebricInterpreter
    public final void synpred50_WaebricInterpreter_fragment() throws RecognitionException {   
        boolean p = false;


        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:272:8: ( '&&' p= predicate )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:272:8: '&&' p= predicate
        {
        match(input,60,FOLLOW_60_in_synpred50_WaebricInterpreter788); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred50_WaebricInterpreter792);
        p=predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred50_WaebricInterpreter

    // $ANTLR start synpred51_WaebricInterpreter
    public final void synpred51_WaebricInterpreter_fragment() throws RecognitionException {   
        boolean p = false;


        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:272:57: ( '||' p= predicate )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:272:57: '||' p= predicate
        {
        match(input,61,FOLLOW_61_in_synpred51_WaebricInterpreter798); if (state.failed) return ;
        pushFollow(FOLLOW_predicate_in_synpred51_WaebricInterpreter802);
        p=predicate();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred51_WaebricInterpreter

    // $ANTLR start synpred55_WaebricInterpreter
    public final void synpred55_WaebricInterpreter_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:281:10: ( ( markup )* expression )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:281:10: ( markup )* expression
        {
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:281:10: ( markup )*
        loop42:
        do {
            int alt42=2;
            alt42 = dfa42.predict(input);
            switch (alt42) {
        	case 1 :
        	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:0:0: markup
        	    {
        	    pushFollow(FOLLOW_markup_in_synpred55_WaebricInterpreter854);
        	    markup();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop42;
            }
        } while (true);

        pushFollow(FOLLOW_expression_in_synpred55_WaebricInterpreter857);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred55_WaebricInterpreter

    // $ANTLR start synpred56_WaebricInterpreter
    public final void synpred56_WaebricInterpreter_fragment() throws RecognitionException {   
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:281:31: ( markup )
        // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricInterpreter.g:281:31: markup
        {
        pushFollow(FOLLOW_markup_in_synpred56_WaebricInterpreter861);
        markup();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred56_WaebricInterpreter

    // Delegated rules

    public final boolean synpred36_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_WaebricInterpreter_fragment(); // can never throw exception
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
    public final boolean synpred43_WaebricInterpreter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_WaebricInterpreter_fragment(); // can never throw exception
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


    protected DFA25 dfa25 = new DFA25(this);
    protected DFA27 dfa27 = new DFA27(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA42 dfa42 = new DFA42(this);
    static final String DFA25_eotS =
        "\21\uffff";
    static final String DFA25_eofS =
        "\21\uffff";
    static final String DFA25_minS =
        "\1\4\5\uffff\1\0\2\uffff\1\0\7\uffff";
    static final String DFA25_maxS =
        "\1\71\5\uffff\1\0\2\uffff\1\0\7\uffff";
    static final String DFA25_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\11\1\uffff\1\6\1\7\1"+
        "\12\1\13\1\14\1\15\1\16";
    static final String DFA25_specialS =
        "\6\uffff\1\0\2\uffff\1\1\7\uffff}>";
    static final String[] DFA25_transitionS = {
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
            return "227:1: statement : ( ^( 'if' '(' predicate ')' t= . ( 'else' f= . )? ) | ^( 'each' '(' IDCON ':' expression ')' statement ) | ^( 'let' ( assignment )+ 'in' ( statement )* 'end' ) | ^( '{' ( statement )* '}' ) | ^( 'comment' STRCON ';' ) | ^( 'echo' expression ';' ) | ^( 'echo' embedding ';' ) | ^( 'cdata' expression ';' ) | 'yield;' | ^( markup ';' ) | ^( markup ( markup )* ',' expression ';' ) | ^( markup ( markup )* ',' statement ) | ^( markup ( markup )* embedding ';' ) | ^( markup ( markup )* ';' ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TreeNodeStream input = (TreeNodeStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA25_6 = input.LA(1);

                         
                        int index25_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_WaebricInterpreter()) ) {s = 10;}

                        else if ( (synpred36_WaebricInterpreter()) ) {s = 11;}

                         
                        input.seek(index25_6);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA25_9 = input.LA(1);

                         
                        int index25_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_WaebricInterpreter()) ) {s = 12;}

                        else if ( (synpred41_WaebricInterpreter()) ) {s = 13;}

                        else if ( (synpred43_WaebricInterpreter()) ) {s = 14;}

                        else if ( (synpred45_WaebricInterpreter()) ) {s = 15;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index25_9);
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
    static final String DFA27_eotS =
        "\12\uffff";
    static final String DFA27_eofS =
        "\12\uffff";
    static final String DFA27_minS =
        "\1\4\1\uffff\6\0\2\uffff";
    static final String DFA27_maxS =
        "\1\73\1\uffff\6\0\2\uffff";
    static final String DFA27_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\1\3";
    static final String DFA27_specialS =
        "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\2\uffff}>";
    static final String[] DFA27_transitionS = {
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
            return "269:5: ( '!' p= predicate | expression | expression '.' type )";
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
                        if ( (synpred49_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index27_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA27_3 = input.LA(1);

                         
                        int index27_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index27_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA27_4 = input.LA(1);

                         
                        int index27_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index27_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA27_5 = input.LA(1);

                         
                        int index27_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index27_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA27_6 = input.LA(1);

                         
                        int index27_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_WaebricInterpreter()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index27_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA27_7 = input.LA(1);

                         
                        int index27_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_WaebricInterpreter()) ) {s = 8;}

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
        "\2\4\1\uffff\1\4\1\uffff\1\4";
    static final String DFA29_maxS =
        "\1\56\1\60\1\uffff\1\4\1\uffff\1\60";
    static final String DFA29_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String DFA29_specialS =
        "\6\uffff}>";
    static final String[] DFA29_transitionS = {
            "\1\1\1\uffff\3\2\43\uffff\1\2\1\uffff\1\2",
            "\1\4\1\uffff\3\4\2\uffff\2\2\25\uffff\1\3\1\uffff\4\4\1\uffff"+
            "\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\2",
            "",
            "\1\5",
            "",
            "\1\4\1\uffff\3\4\2\uffff\2\2\25\uffff\1\3\1\uffff\4\4\1\uffff"+
            "\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\2"
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
            return "()* loopback of 281:10: ( markup )*";
        }
    }
    static final String DFA42_eotS =
        "\6\uffff";
    static final String DFA42_eofS =
        "\1\uffff\1\2\3\uffff\1\2";
    static final String DFA42_minS =
        "\2\4\2\uffff\2\4";
    static final String DFA42_maxS =
        "\1\56\1\60\2\uffff\1\4\1\60";
    static final String DFA42_acceptS =
        "\2\uffff\1\2\1\1\2\uffff";
    static final String DFA42_specialS =
        "\6\uffff}>";
    static final String[] DFA42_transitionS = {
            "\1\1\1\uffff\3\2\43\uffff\1\2\1\uffff\1\2",
            "\1\3\1\uffff\3\3\31\uffff\1\4\1\uffff\4\3\1\uffff\1\3\2\uffff"+
            "\1\3\1\uffff\1\3\1\uffff\1\2",
            "",
            "",
            "\1\5",
            "\1\3\1\uffff\3\3\31\uffff\1\4\1\uffff\4\3\1\uffff\1\3\2\uffff"+
            "\1\3\1\uffff\1\3\1\uffff\1\2"
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
            return "()* loopback of 281:10: ( markup )*";
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
    public static final BitSet FOLLOW_34_in_attribute140 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_attribute150 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_attribute160 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_attribute162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_attribute170 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NATCON_in_attribute172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_attribute180 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NATCON_in_attribute182 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_attribute184 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NATCON_in_attribute186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_arguments198 = new BitSet(new long[]{0x00005C00000001D0L});
    public static final BitSet FOLLOW_argument_in_arguments200 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_42_in_arguments205 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_argument_in_arguments207 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_43_in_arguments212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_argument221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_expression243 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_NATCON_in_expression253 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_TEXT_in_expression263 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_SYMBOLCON_in_expression273 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_44_in_expression283 = new BitSet(new long[]{0x00007400000001D0L});
    public static final BitSet FOLLOW_expression_in_expression289 = new BitSet(new long[]{0x0000240000000000L});
    public static final BitSet FOLLOW_42_in_expression298 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_expression302 = new BitSet(new long[]{0x0000240000000000L});
    public static final BitSet FOLLOW_45_in_expression309 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_46_in_expression317 = new BitSet(new long[]{0x0000840000000010L});
    public static final BitSet FOLLOW_keyValuePair_in_expression323 = new BitSet(new long[]{0x0000840000000000L});
    public static final BitSet FOLLOW_42_in_expression332 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_keyValuePair_in_expression336 = new BitSet(new long[]{0x0000840000000000L});
    public static final BitSet FOLLOW_47_in_expression343 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_48_in_expression353 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_expression357 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_34_in_expression363 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_expression365 = new BitSet(new long[]{0x0001000400000002L});
    public static final BitSet FOLLOW_IDCON_in_keyValuePair388 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_keyValuePair390 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_keyValuePair394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_function408 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_function410 = new BitSet(new long[]{0x03B442000000A010L});
    public static final BitSet FOLLOW_formals_in_function412 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_statement_in_function415 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_END_in_function418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_formals427 = new BitSet(new long[]{0x0000080000000010L});
    public static final BitSet FOLLOW_IDCON_in_formals429 = new BitSet(new long[]{0x0000080000000010L});
    public static final BitSet FOLLOW_43_in_formals432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_statement455 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_41_in_statement457 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_statement459 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_statement461 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_51_in_statement472 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000001L});
    public static final BitSet FOLLOW_52_in_statement494 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_41_in_statement496 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_statement498 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_statement500 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_statement502 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_statement504 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement506 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_53_in_statement517 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_assignment_in_statement519 = new BitSet(new long[]{0x0040000000000010L});
    public static final BitSet FOLLOW_54_in_statement522 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_statement_in_statement524 = new BitSet(new long[]{0x03B440000000A010L});
    public static final BitSet FOLLOW_END_in_statement527 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_46_in_statement538 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_statement540 = new BitSet(new long[]{0x03B4C00000002010L});
    public static final BitSet FOLLOW_47_in_statement543 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COMMENT_in_statement554 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRCON_in_statement556 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement558 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_55_in_statement569 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement571 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement573 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_55_in_statement586 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_statement588 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement590 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_56_in_statement601 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement603 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement605 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_57_in_statement614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_statement623 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement625 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_statement636 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement638 = new BitSet(new long[]{0x0000040000000010L});
    public static final BitSet FOLLOW_42_in_statement641 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_statement643 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement645 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_statement658 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement660 = new BitSet(new long[]{0x0000040000000010L});
    public static final BitSet FOLLOW_42_in_statement663 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_statement665 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_statement676 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement678 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_embedding_in_statement681 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement683 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_statement694 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_statement696 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement699 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDCON_in_assignment712 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_assignment714 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_assignment716 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_assignment718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_assignment726 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_formals_in_assignment728 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_assignment730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_predicate751 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_predicate755 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate765 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_expression_in_predicate774 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_predicate776 = new BitSet(new long[]{0xC000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_type_in_predicate778 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_60_in_predicate788 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_predicate792 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_61_in_predicate798 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_predicate802 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_set_in_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRETEXT_in_embedding840 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_embed_in_embedding842 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_textTail_in_embedding844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed854 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_embed857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_embed861 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_markup_in_embed864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSTTEXT_in_textTail873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIDTEXT_in_textTail877 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_embed_in_textTail879 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_textTail_in_textTail881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_synpred21_WaebricInterpreter353 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_synpred21_WaebricInterpreter357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_synpred22_WaebricInterpreter363 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDCON_in_synpred22_WaebricInterpreter365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_synpred35_WaebricInterpreter569 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_synpred35_WaebricInterpreter571 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred35_WaebricInterpreter573 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_55_in_synpred36_WaebricInterpreter586 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_embedding_in_synpred36_WaebricInterpreter588 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred36_WaebricInterpreter590 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_synpred39_WaebricInterpreter623 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred39_WaebricInterpreter625 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_synpred41_WaebricInterpreter636 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred41_WaebricInterpreter638 = new BitSet(new long[]{0x0000040000000010L});
    public static final BitSet FOLLOW_42_in_synpred41_WaebricInterpreter641 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_synpred41_WaebricInterpreter643 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred41_WaebricInterpreter645 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_synpred43_WaebricInterpreter658 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred43_WaebricInterpreter660 = new BitSet(new long[]{0x0000040000000010L});
    public static final BitSet FOLLOW_42_in_synpred43_WaebricInterpreter663 = new BitSet(new long[]{0x03B4400000002010L});
    public static final BitSet FOLLOW_statement_in_synpred43_WaebricInterpreter665 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_markup_in_synpred45_WaebricInterpreter676 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_markup_in_synpred45_WaebricInterpreter678 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_embedding_in_synpred45_WaebricInterpreter681 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred45_WaebricInterpreter683 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_synpred49_WaebricInterpreter765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_synpred50_WaebricInterpreter788 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_synpred50_WaebricInterpreter792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred51_WaebricInterpreter798 = new BitSet(new long[]{0x08005000000001D0L});
    public static final BitSet FOLLOW_predicate_in_synpred51_WaebricInterpreter802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred55_WaebricInterpreter854 = new BitSet(new long[]{0x00005000000001D0L});
    public static final BitSet FOLLOW_expression_in_synpred55_WaebricInterpreter857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_markup_in_synpred56_WaebricInterpreter861 = new BitSet(new long[]{0x0000000000000002L});

}