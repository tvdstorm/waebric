import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;

import org.cwi.waebric.*;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        WaebricLexer lex = new WaebricLexer(new ANTLRFileStream("/Users/Jeroen/Documents/workspace/WaebricANTLR/src/main/grammar/../java/org/cwi/waebric/__Test___input.txt"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        WaebricParser g = new WaebricParser(tokens, 49100, null);
        try {
            g.module();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}