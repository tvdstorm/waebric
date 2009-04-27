package waebricc;

import lpg.runtime.*;

public class JavaKWLexer extends JavaKWLexerprs implements WaebricParsersym
{
    private char[] inputChars;
    private final int keywordKind[] = new int[13 + 1];

    public int[] getKeywordKinds() { return keywordKind; }

    public int lexer(int curtok, int lasttok)
    {
        int current_kind = getKind(inputChars[curtok]),
            act;

        for (act = tAction(START_STATE, current_kind);
             act > NUM_RULES && act < ACCEPT_ACTION;
             act = tAction(act, current_kind))
        {
            curtok++;
            current_kind = (curtok > lasttok
                                   ? Char_EOF
                                   : getKind(inputChars[curtok]));
        }

        if (act > ERROR_ACTION)
        {
            curtok++;
            act -= ERROR_ACTION;
        }

        return keywordKind[act == ERROR_ACTION  || curtok <= lasttok ? 0 : act];
    }

    public void setInputChars(char[] inputChars) { this.inputChars = inputChars; }


    //
    // Each upper case letter is mapped into is corresponding
    // lower case counterpart. For example, if an 'A' appears
    // in the input, it is mapped into Char_a just like 'a'.
    //
    final static int tokenKind[] = new int[128];
    static
    {
        tokenKind['$'] = Char_DollarSign;
        tokenKind['_'] = Char__;

        tokenKind['a'] = Char_a;
        tokenKind['b'] = Char_b;
        tokenKind['c'] = Char_c;
        tokenKind['d'] = Char_d;
        tokenKind['e'] = Char_e;
        tokenKind['f'] = Char_f;
        tokenKind['g'] = Char_g;
        tokenKind['h'] = Char_h;
        tokenKind['i'] = Char_i;
        tokenKind['j'] = Char_j;
        tokenKind['k'] = Char_k;
        tokenKind['l'] = Char_l;
        tokenKind['m'] = Char_m;
        tokenKind['n'] = Char_n;
        tokenKind['o'] = Char_o;
        tokenKind['p'] = Char_p;
        tokenKind['q'] = Char_q;
        tokenKind['r'] = Char_r;
        tokenKind['s'] = Char_s;
        tokenKind['t'] = Char_t;
        tokenKind['u'] = Char_u;
        tokenKind['v'] = Char_v;
        tokenKind['w'] = Char_w;
        tokenKind['x'] = Char_x;
        tokenKind['y'] = Char_y;
        tokenKind['z'] = Char_z;
    };

    final int getKind(char c)
    {
        return (c < 128 ? tokenKind[c] : 0);
    }


    public JavaKWLexer(char[] inputChars, int identifierKind)
    {
        this.inputChars = inputChars;
        keywordKind[0] = identifierKind;

        //
        // Rule 1:  KeyWord ::= m o d u l e
        //
        keywordKind[1] = (WaebricParsersym.TK_module);
      
    
        //
        // Rule 2:  KeyWord ::= d e f
        //
        keywordKind[2] = (WaebricParsersym.TK_def);
      
    
        //
        // Rule 3:  KeyWord ::= e n d
        //
        keywordKind[3] = (WaebricParsersym.TK_end);
      
    
        //
        // Rule 4:  KeyWord ::= s i t e
        //
        keywordKind[4] = (WaebricParsersym.TK_site);
      
    
        //
        // Rule 5:  KeyWord ::= i f
        //
        keywordKind[5] = (WaebricParsersym.TK_if);
      
    
        //
        // Rule 6:  KeyWord ::= e a c h
        //
        keywordKind[6] = (WaebricParsersym.TK_each);
      
    
        //
        // Rule 7:  KeyWord ::= e l s e
        //
        keywordKind[7] = (WaebricParsersym.TK_else);
      
    
        //
        // Rule 8:  KeyWord ::= l e t
        //
        keywordKind[8] = (WaebricParsersym.TK_let);
      
    
        //
        // Rule 9:  KeyWord ::= i n
        //
        keywordKind[9] = (WaebricParsersym.TK_in);
      
    
        //
        // Rule 10:  KeyWord ::= c o m m e n t
        //
        keywordKind[10] = (WaebricParsersym.TK_comment);
      
    
        //
        // Rule 11:  KeyWord ::= e c h o
        //
        keywordKind[11] = (WaebricParsersym.TK_echo);
      
    
        //
        // Rule 12:  KeyWord ::= c d a t a
        //
        keywordKind[12] = (WaebricParsersym.TK_cdata);
      
    
        //
        // Rule 13:  KeyWord ::= y i e l d
        //
        keywordKind[13] = (WaebricParsersym.TK_yield);
      
    

        for (int i = 0; i < keywordKind.length; i++)
        {
            if (keywordKind[i] == 0)
                keywordKind[i] = identifierKind;
        }
    }
}

