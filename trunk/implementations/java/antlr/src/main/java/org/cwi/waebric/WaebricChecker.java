// $ANTLR 3.1.2 /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g 2009-07-02 15:15:29

	package org.cwi.waebric;
	
	import java.util.Set;
	import java.util.HashSet;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class WaebricChecker extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "MODULE", "IMPORT", "SITE", "DEF", "END", "IF", "ELSE", "EACH", "LET", "IN", "COMMENT", "ECHO", "CDATA", "YIELD", "LIST", "RECORD", "STRING", "IDCON", "PATH", "NATCON", "TEXT", "SYMBOLCON", "STRCON", "PRETEXT", "POSTTEXT", "MIDTEXT", "SEMICOLON", "LETTER", "DIGIT", "HEXADECIMAL", "PATHELEMENT", "FILEEXT", "STRCHAR", "ESCLAYOUT", "DECIMAL", "TEXTCHAR", "ESCQUOTE", "AMP", "CHARREF", "ENTREF", "SYMBOLCHAR", "COMMENTS", "LAYOUT", "'.'", "':'", "'#'", "'$'", "'@'", "'%'", "'('", "','", "')'", "'+'", "'['", "']'", "'{'", "'}'", "'yield;'", "'='", "'&&'", "'||'", "'!'"
    };
    public static final int CDATA=16;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int DEF=7;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int LETTER=31;
    public static final int AMP=41;
    public static final int ESCLAYOUT=37;
    public static final int PATHELEMENT=34;
    public static final int STRCON=26;
    public static final int PRETEXT=27;
    public static final int TEXTCHAR=39;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int POSTTEXT=28;
    public static final int EOF=-1;
    public static final int IF=9;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int IMPORT=5;
    public static final int T__51=51;
    public static final int FILEEXT=35;
    public static final int T__52=52;
    public static final int IN=13;
    public static final int COMMENTS=45;
    public static final int CHARREF=42;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int IDCON=21;
    public static final int PATH=22;
    public static final int T__59=59;
    public static final int STRCHAR=36;
    public static final int YIELD=17;
    public static final int DIGIT=32;
    public static final int EACH=11;
    public static final int COMMENT=14;
    public static final int T__50=50;
    public static final int RECORD=19;
    public static final int T__47=47;
    public static final int MIDTEXT=29;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int ELSE=10;
    public static final int SITE=6;
    public static final int SYMBOLCON=25;
    public static final int HEXADECIMAL=33;
    public static final int SEMICOLON=30;
    public static final int SYMBOLCHAR=44;
    public static final int TEXT=24;
    public static final int MODULE=4;
    public static final int LIST=18;
    public static final int LAYOUT=46;
    public static final int NATCON=23;
    public static final int ECHO=15;
    public static final int DECIMAL=38;
    public static final int ENTREF=43;
    public static final int ESCQUOTE=40;
    public static final int END=8;
    public static final int LET=12;
    public static final int STRING=20;

    // delegates
    // delegators


        public WaebricChecker(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public WaebricChecker(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return WaebricChecker.tokenNames; }
    public String getGrammarFileName() { return "/ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g"; }


    	private Set<String> variables = new HashSet<String>();
    	
    	public boolean isVariable(String variable) {
    		return variables.contains(variable);
    	}
    	
    	public void declareVariable(String variable) {
    		variables.add(variable);
    	}



    // $ANTLR start "module"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:33:1: module : MODULE moduleId END ;
    public final void module() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:33:7: ( MODULE moduleId END )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:33:10: MODULE moduleId END
            {
            match(input,MODULE,FOLLOW_MODULE_in_module51); 
            pushFollow(FOLLOW_moduleId_in_module53);
            moduleId();

            state._fsp--;

            match(input,END,FOLLOW_END_in_module55); 

            }

        }

        	catch(RecognitionException e) {
        		throw e;
        	}
        finally {
        }
        return ;
    }
    // $ANTLR end "module"


    // $ANTLR start "moduleId"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:36:1: moduleId : id= IDCON ( '.' id= IDCON )* ;
    public final void moduleId() throws RecognitionException {
        CommonTree id=null;

        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:36:9: (id= IDCON ( '.' id= IDCON )* )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:36:11: id= IDCON ( '.' id= IDCON )*
            {
            id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_moduleId65); 
            String path = id.getText();
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:37:3: ( '.' id= IDCON )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==47) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:37:5: '.' id= IDCON
            	    {
            	    match(input,47,FOLLOW_47_in_moduleId74); 
            	    id=(CommonTree)match(input,IDCON,FOLLOW_IDCON_in_moduleId78); 
            	     path += "/" + id.getText(); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             System.out.println("Checking module: " + path + ".wae"); 

            }

        }

        	catch(RecognitionException e) {
        		throw e;
        	}
        finally {
        }
        return ;
    }
    // $ANTLR end "moduleId"


    // $ANTLR start "imprt"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:40:1: imprt : IMPORT moduleId ;
    public final void imprt() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:40:6: ( IMPORT moduleId )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:40:9: IMPORT moduleId
            {
            match(input,IMPORT,FOLLOW_IMPORT_in_imprt97); 
            pushFollow(FOLLOW_moduleId_in_imprt99);
            moduleId();

            state._fsp--;


            }

        }

        	catch(RecognitionException e) {
        		throw e;
        	}
        finally {
        }
        return ;
    }
    // $ANTLR end "imprt"


    // $ANTLR start "site"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:41:1: site : SITE ( . )* END ;
    public final void site() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:41:5: ( SITE ( . )* END )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:41:8: SITE ( . )* END
            {
            match(input,SITE,FOLLOW_SITE_in_site106); 
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:41:13: ( . )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==END) ) {
                    alt2=2;
                }
                else if ( ((LA2_0>=MODULE && LA2_0<=DEF)||(LA2_0>=IF && LA2_0<=65)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:41:13: .
            	    {
            	    matchAny(input); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match(input,END,FOLLOW_END_in_site111); 

            }

        }

        	catch(RecognitionException e) {
        		throw e;
        	}
        finally {
        }
        return ;
    }
    // $ANTLR end "site"


    // $ANTLR start "function"
    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:42:1: function : DEF ( . )* END ;
    public final void function() throws RecognitionException {
        try {
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:42:9: ( DEF ( . )* END )
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:42:11: DEF ( . )* END
            {
            match(input,DEF,FOLLOW_DEF_in_function117); 
            // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:42:15: ( . )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==END) ) {
                    alt3=2;
                }
                else if ( ((LA3_0>=MODULE && LA3_0<=DEF)||(LA3_0>=IF && LA3_0<=65)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /ufs/schagen/workspace/WaebricANTLR/src/main/grammar/WaebricChecker.g:42:15: .
            	    {
            	    matchAny(input); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match(input,END,FOLLOW_END_in_function122); 

            }

        }

        	catch(RecognitionException e) {
        		throw e;
        	}
        finally {
        }
        return ;
    }
    // $ANTLR end "function"

    // Delegated rules


 

    public static final BitSet FOLLOW_MODULE_in_module51 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_moduleId_in_module53 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_END_in_module55 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDCON_in_moduleId65 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_47_in_moduleId74 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_IDCON_in_moduleId78 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_IMPORT_in_imprt97 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_moduleId_in_imprt99 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SITE_in_site106 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_END_in_site111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEF_in_function117 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000000003L});
    public static final BitSet FOLLOW_END_in_function122 = new BitSet(new long[]{0x0000000000000002L});

}