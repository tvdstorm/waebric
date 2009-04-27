package waebricc;

public class WaebricParserprs implements lpg.runtime.ParseTable, WaebricParsersym {
    public final static int ERROR_SYMBOL = 53;
    public final int getErrorSymbol() { return ERROR_SYMBOL; }

    public final static int SCOPE_UBOUND = 1;
    public final int getScopeUbound() { return SCOPE_UBOUND; }

    public final static int SCOPE_SIZE = 2;
    public final int getScopeSize() { return SCOPE_SIZE; }

    public final static int MAX_NAME_LENGTH = 20;
    public final int getMaxNameLength() { return MAX_NAME_LENGTH; }

    public final static int NUM_STATES = 53;
    public final int getNumStates() { return NUM_STATES; }

    public final static int NT_OFFSET = 53;
    public final int getNtOffset() { return NT_OFFSET; }

    public final static int LA_STATE_OFFSET = 350;
    public final int getLaStateOffset() { return LA_STATE_OFFSET; }

    public final static int MAX_LA = 2;
    public final int getMaxLa() { return MAX_LA; }

    public final static int NUM_RULES = 96;
    public final int getNumRules() { return NUM_RULES; }

    public final static int NUM_NONTERMINALS = 58;
    public final int getNumNonterminals() { return NUM_NONTERMINALS; }

    public final static int NUM_SYMBOLS = 111;
    public final int getNumSymbols() { return NUM_SYMBOLS; }

    public final static int SEGMENT_SIZE = 8192;
    public final int getSegmentSize() { return SEGMENT_SIZE; }

    public final static int START_STATE = 114;
    public final int getStartState() { return START_STATE; }

    public final static int IDENTIFIER_SYMBOL = 0;
    public final int getIdentifier_SYMBOL() { return IDENTIFIER_SYMBOL; }

    public final static int EOFT_SYMBOL = 21;
    public final int getEoftSymbol() { return EOFT_SYMBOL; }

    public final static int EOLT_SYMBOL = 21;
    public final int getEoltSymbol() { return EOLT_SYMBOL; }

    public final static int ACCEPT_ACTION = 253;
    public final int getAcceptAction() { return ACCEPT_ACTION; }

    public final static int ERROR_ACTION = 254;
    public final int getErrorAction() { return ERROR_ACTION; }

    public final static boolean BACKTRACK = false;
    public final boolean getBacktrack() { return BACKTRACK; }

    public final int getStartSymbol() { return lhs(0); }
    public final boolean isValidForParser() { return WaebricParsersym.isValidForParser; }


    public interface IsNullable {
        public final static byte isNullable[] = {0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,1,1,0,0,0,1,1,
            1,1,0,1,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,1,0,
            0
        };
    };
    public final static byte isNullable[] = IsNullable.isNullable;
    public final boolean isNullable(int index) { return isNullable[index] != 0; }

    public interface ProsthesesIndex {
        public final static byte prosthesesIndex[] = {0,
            25,26,29,30,31,32,33,6,16,17,
            18,3,5,7,8,9,10,12,13,14,
            23,24,28,35,36,54,55,57,58,2,
            4,11,15,19,20,27,34,53,56,1,
            21,22,37,38,39,40,41,42,43,44,
            45,46,47,48,49,50,51,52
        };
    };
    public final static byte prosthesesIndex[] = ProsthesesIndex.prosthesesIndex;
    public final int prosthesesIndex(int index) { return prosthesesIndex[index]; }

    public interface IsKeyword {
        public final static byte isKeyword[] = {0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0
        };
    };
    public final static byte isKeyword[] = IsKeyword.isKeyword;
    public final boolean isKeyword(int index) { return isKeyword[index] != 0; }

    public interface BaseCheck {
        public final static byte baseCheck[] = {0,
            3,3,1,1,0,1,2,1,1,1,
            3,0,1,3,2,3,2,1,3,2,
            1,2,2,0,1,2,1,2,3,3,
            1,3,1,0,1,3,1,1,1,1,
            1,1,1,1,1,3,3,3,0,1,
            3,1,3,3,3,1,2,1,1,1,
            1,1,1,1,1,7,5,3,0,1,
            2,1,3,3,3,3,2,1,2,1,
            4,2,0,1,2,1,2,2,2,7,
            0,1,3,1,1,1,-27,0,0,0,
            0,0,0,0,-37,0,0,0,0,0,
            0,0,-2,-1,-36,-32,0,0,0,-51,
            0,0,0,0,0,0,0,0,-41,0,
            0,0,0,0,0,0,-6,-5,0,0,
            0,-50,0,0,-7,0,0,0,-10,0,
            0,0,-24,-11,0,0,0,-48,0,0,
            0,0,0,0,0,0,0,-4,0,-49,
            0,0,0,0,0,0,0,-21,0,0,
            -12,0,0,0,0,-8,0,0,0,0,
            0,0,-17,-23,-31,0,0,0,0,0,
            0,0,0,-22,-3,-33,-9,-13,-15,-16,
            -18,0,0,0,0,-19,0,0,0,0,
            0,0,-20,-25,-26,0,0,-14,0,-28,
            -29,0,0,0,0,-30,-34,0,-35,-38,
            -39,-40,0,-42,-43,-44,-45,-46,-47,-52,
            -53,0
        };
    };
    public final static byte baseCheck[] = BaseCheck.baseCheck;
    public final int baseCheck(int index) { return baseCheck[index]; }
    public final static byte rhs[] = baseCheck;
    public final int rhs(int index) { return rhs[index]; };

    public interface BaseAction {
        public final static char baseAction[] = {
            30,30,12,12,13,31,31,14,14,15,
            15,17,32,32,18,18,19,20,20,10,
            9,9,11,33,41,41,42,42,35,35,
            21,21,22,22,36,36,23,23,2,2,
            2,2,2,2,3,7,4,5,6,37,
            37,24,24,25,43,45,45,44,46,46,
            46,46,46,46,46,46,47,48,50,56,
            56,57,57,49,51,52,53,54,1,55,
            55,58,34,38,38,26,26,27,27,27,
            16,39,39,28,28,29,8,1,241,240,
            39,40,41,42,43,11,38,248,39,40,
            41,42,43,4,38,95,91,242,237,239,
            21,38,248,39,40,41,42,43,35,21,
            241,240,39,40,41,42,43,23,49,50,
            246,247,113,36,113,44,228,18,181,52,
            30,239,244,31,53,13,209,154,21,38,
            250,39,40,41,42,43,51,246,28,149,
            21,38,251,39,40,41,42,43,72,84,
            195,55,6,186,9,10,37,228,18,181,
            20,82,181,62,70,32,14,209,154,1,
            7,186,9,10,77,14,14,14,3,60,
            61,66,95,4,95,4,67,168,138,2,
            138,85,195,69,74,80,16,194,58,23,
            85,87,92,225,93,225,89,93,17,94,
            99,82,98,224,103,104,106,105,40,111,
            115,116,254,254
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,0,0,2,5,6,7,8,9,
            0,1,10,0,1,5,6,0,8,9,
            0,1,0,1,21,5,6,0,8,9,
            0,0,2,2,4,4,0,0,11,0,
            13,2,3,0,1,15,15,11,0,13,
            2,0,0,16,0,1,4,0,1,0,
            0,0,1,12,0,0,0,1,0,0,
            2,0,1,0,14,10,0,1,19,0,
            7,0,3,14,0,1,0,1,0,1,
            0,1,0,0,0,1,3,0,0,7,
            2,20,0,0,0,0,0,4,3,12,
            0,1,0,1,0,0,2,2,0,17,
            0,0,18,0,0,0,0,0,10,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            254,332,254,254,216,298,299,282,115,105,
            34,332,276,254,350,298,299,254,115,105,
            254,332,12,208,253,298,299,5,115,105,
            83,86,231,231,230,230,8,254,137,37,
            145,249,120,254,210,236,236,137,3,145,
            207,254,254,205,254,469,193,254,223,254,
            254,254,153,265,254,254,254,273,254,254,
            216,15,208,254,204,276,91,350,178,94,
            116,38,206,97,254,343,254,342,254,341,
            254,332,254,31,49,245,129,254,33,283,
            249,158,254,254,254,52,254,170,142,344,
            254,300,254,245,32,53,249,249,21,302,
            254,254,301,254,254,254,254,254,211
        };
    };
    public final static char termAction[] = TermAction.termAction;
    public final int termAction(int index) { return termAction[index]; }

    public interface Asb {
        public final static byte asb[] = {0,
            15,26,13,24,23,20,13,24,13,21,
            33,13,35,13,38,40,13,36,13,31,
            20,5,40,28,6,44,1,13,13,13,
            28,13,13,6,44,17,8,43,42,21,
            9,53,33,52,49,47,13,9,9,13,
            9,43,51
        };
    };
    public final static byte asb[] = Asb.asb;
    public final int asb(int index) { return asb[index]; }

    public interface Asr {
        public final static byte asr[] = {0,
            5,9,8,6,1,7,0,18,5,9,
            8,6,1,0,16,0,17,1,0,1,
            12,0,2,13,11,21,0,14,15,4,
            2,0,4,0,2,10,0,19,0,14,
            0,20,2,7,3,0,3,2,18,0,
            2,3,17,0
        };
    };
    public final static byte asr[] = Asr.asr;
    public final int asr(int index) { return asr[index]; }

    public interface Nasb {
        public final static byte nasb[] = {0,
            5,22,30,16,22,9,22,16,30,22,
            22,21,22,32,22,22,23,22,22,22,
            18,28,26,14,22,22,1,22,22,22,
            14,1,28,22,22,7,3,22,22,22,
            1,22,22,22,22,22,22,3,3,7,
            3,22,22
        };
    };
    public final static byte nasb[] = Nasb.nasb;
    public final int nasb(int index) { return nasb[index]; }

    public interface Nasr {
        public final static byte nasr[] = {0,
            1,0,2,0,30,0,25,0,19,11,
            20,32,0,27,0,15,0,20,19,18,
            11,0,34,33,0,35,0,29,0,13,
            0,10,0
        };
    };
    public final static byte nasr[] = Nasr.nasr;
    public final int nasr(int index) { return nasr[index]; }

    public interface TerminalIndex {
        public final static byte terminalIndex[] = {0,
            16,9,8,10,17,18,2,3,5,11,
            23,24,25,1,12,22,4,6,7,13,
            35,19,20,21,26,27,28,29,30,31,
            32,33,34,14,36,37,38,39,40,41,
            42,43,44,45,46,47,48,49,50,51,
            52,53,54
        };
    };
    public final static byte terminalIndex[] = TerminalIndex.terminalIndex;
    public final int terminalIndex(int index) { return terminalIndex[index]; }

    public interface NonterminalIndex {
        public final static byte nonterminalIndex[] = {0,
            71,72,0,0,0,0,0,0,64,65,
            66,56,57,58,59,0,0,60,61,62,
            69,70,73,74,75,76,77,78,79,55,
            0,0,63,67,68,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0
        };
    };
    public final static byte nonterminalIndex[] = NonterminalIndex.nonterminalIndex;
    public final int nonterminalIndex(int index) { return nonterminalIndex[index]; }

    public interface ScopePrefix {
        public final static byte scopePrefix[] = {
            1,6
        };
    };
    public final static byte scopePrefix[] = ScopePrefix.scopePrefix;
    public final int scopePrefix(int index) { return scopePrefix[index]; }

    public interface ScopeSuffix {
        public final static byte scopeSuffix[] = {
            4,9
        };
    };
    public final static byte scopeSuffix[] = ScopeSuffix.scopeSuffix;
    public final int scopeSuffix(int index) { return scopeSuffix[index]; }

    public interface ScopeLhs {
        public final static byte scopeLhs[] = {
            6,5
        };
    };
    public final static byte scopeLhs[] = ScopeLhs.scopeLhs;
    public final int scopeLhs(int index) { return scopeLhs[index]; }

    public interface ScopeLa {
        public final static byte scopeLa[] = {
            17,18
        };
    };
    public final static byte scopeLa[] = ScopeLa.scopeLa;
    public final int scopeLa(int index) { return scopeLa[index]; }

    public interface ScopeStateSet {
        public final static byte scopeStateSet[] = {
            1,1
        };
    };
    public final static byte scopeStateSet[] = ScopeStateSet.scopeStateSet;
    public final int scopeStateSet(int index) { return scopeStateSet[index]; }

    public interface ScopeRhs {
        public final static byte scopeRhs[] = {0,
            90,8,0,17,0,89,9,0,18,0
        };
    };
    public final static byte scopeRhs[] = ScopeRhs.scopeRhs;
    public final int scopeRhs(int index) { return scopeRhs[index]; }

    public interface ScopeState {
        public final static char scopeState[] = {0,
            120,170,158,129,105,97,0
        };
    };
    public final static char scopeState[] = ScopeState.scopeState;
    public final int scopeState(int index) { return scopeState[index]; }

    public interface InSymb {
        public final static byte inSymb[] = {0,
            0,83,16,65,66,11,13,68,2,85,
            73,64,1,62,72,1,4,1,2,1,
            19,14,87,1,92,82,14,4,2,15,
            80,7,3,74,75,8,9,55,54,54,
            3,90,1,78,89,55,2,20,4,3,
            3,55,55
        };
    };
    public final static byte inSymb[] = InSymb.inSymb;
    public final int inSymb(int index) { return inSymb[index]; }

    public interface Name {
        public final static String name[] = {
            "",
            "(",
            ")",
            "{",
            "}",
            "[",
            "]",
            ";",
            ",",
            ".",
            ":",
            "/",
            "#",
            "=",
            "^",
            "$empty",
            "IDENTIFIER",
            "StringLiteral",
            "IntegerLiteral",
            "PreText",
            "MidText",
            "PostText",
            "module",
            "site",
            "end",
            "def",
            "if",
            "each",
            "else",
            "let",
            "in",
            "comment",
            "echo",
            "cdata",
            "yield",
            "EOF_TOKEN",
            "SlComment",
            "MlComment",
            "DocComment",
            "LongLiteral",
            "FloatingPointLiteral",
            "DoubleLiteral",
            "CharacterLiteral",
            "PLUS",
            "MINUS",
            "NOT",
            "REMAINDER",
            "AND",
            "MULTIPLY",
            "OR",
            "TWIDDLE",
            "GREATER",
            "LESS",
            "QUESTION",
            "ERROR_TOKEN",
            "Module",
            "ModuleIds",
            "ModuleId",
            "ModuleBlocks",
            "ModuleBlock",
            "Mappings",
            "Mapping",
            "Path",
            "Markup",
            "DirNames",
            "FileName",
            "DirName",
            "Designator",
            "ArgumentsOpt",
            "Arguments",
            "Argument",
            "Var",
            "Expression",
            "Expressions",
            "KeyValuePairs",
            "KeyValuePair",
            "Attributes",
            "Attribute",
            "ParameterDecls",
            "ParameterDecl"
        };
    };
    public final static String name[] = Name.name;
    public final String name(int index) { return name[index]; }

    public final int originalState(int state) {
        return -baseCheck[state];
    }
    public final int asi(int state) {
        return asb[originalState(state)];
    }
    public final int nasi(int state) {
        return nasb[originalState(state)];
    }
    public final int inSymbol(int state) {
        return inSymb[originalState(state)];
    }

    /**
     * assert(! goto_default);
     */
    public final int ntAction(int state, int sym) {
        return baseAction[state + sym];
    }

    /**
     * assert(! shift_default);
     */
    public final int tAction(int state, int sym) {
        int i = baseAction[state],
            k = i + sym;
        return termAction[termCheck[k] == sym ? k : i];
    }
    public final int lookAhead(int la_state, int sym) {
        int k = la_state + sym;
        return termAction[termCheck[k] == sym ? k : la_state];
    }
}
