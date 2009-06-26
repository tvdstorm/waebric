import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        DebugWaebricLexer lex = new DebugWaebricLexer(new ANTLRFileStream("/ufs/schagen/workspace/WaebricANTLR/src/main/grammar/../java/__Test___input.txt"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        DebugWaebricParser g = new DebugWaebricParser(tokens, 49100, null);
        try {
            g.module();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}