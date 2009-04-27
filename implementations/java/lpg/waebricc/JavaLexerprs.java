package waebricc;

public class JavaLexerprs implements lpg.runtime.ParseTable, JavaLexersym {
    public final static int ERROR_SYMBOL = 0;
    public final int getErrorSymbol() { return ERROR_SYMBOL; }

    public final static int SCOPE_UBOUND = 0;
    public final int getScopeUbound() { return SCOPE_UBOUND; }

    public final static int SCOPE_SIZE = 0;
    public final int getScopeSize() { return SCOPE_SIZE; }

    public final static int MAX_NAME_LENGTH = 0;
    public final int getMaxNameLength() { return MAX_NAME_LENGTH; }

    public final static int NUM_STATES = 64;
    public final int getNumStates() { return NUM_STATES; }

    public final static int NT_OFFSET = 102;
    public final int getNtOffset() { return NT_OFFSET; }

    public final static int LA_STATE_OFFSET = 915;
    public final int getLaStateOffset() { return LA_STATE_OFFSET; }

    public final static int MAX_LA = 1;
    public final int getMaxLa() { return MAX_LA; }

    public final static int NUM_RULES = 348;
    public final int getNumRules() { return NUM_RULES; }

    public final static int NUM_NONTERMINALS = 40;
    public final int getNumNonterminals() { return NUM_NONTERMINALS; }

    public final static int NUM_SYMBOLS = 142;
    public final int getNumSymbols() { return NUM_SYMBOLS; }

    public final static int SEGMENT_SIZE = 8192;
    public final int getSegmentSize() { return SEGMENT_SIZE; }

    public final static int START_STATE = 349;
    public final int getStartState() { return START_STATE; }

    public final static int IDENTIFIER_SYMBOL = 0;
    public final int getIdentifier_SYMBOL() { return IDENTIFIER_SYMBOL; }

    public final static int EOFT_SYMBOL = 77;
    public final int getEoftSymbol() { return EOFT_SYMBOL; }

    public final static int EOLT_SYMBOL = 103;
    public final int getEoltSymbol() { return EOLT_SYMBOL; }

    public final static int ACCEPT_ACTION = 566;
    public final int getAcceptAction() { return ACCEPT_ACTION; }

    public final static int ERROR_ACTION = 567;
    public final int getErrorAction() { return ERROR_ACTION; }

    public final static boolean BACKTRACK = false;
    public final boolean getBacktrack() { return BACKTRACK; }

    public final int getStartSymbol() { return lhs(0); }
    public final boolean isValidForParser() { return JavaLexersym.isValidForParser; }


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
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,1,0,0,0,0,
            0,0,0,0,1,0,0,0,0,1,
            0,0,0,0,0,0,0,0,0,0,
            0,0
        };
    };
    public final static byte isNullable[] = IsNullable.isNullable;
    public final boolean isNullable(int index) { return isNullable[index] != 0; }

    public interface ProsthesesIndex {
        public final static byte prosthesesIndex[] = {0,
            26,27,34,30,31,32,14,33,19,21,
            29,40,38,5,15,20,22,25,28,37,
            2,3,4,6,7,8,9,10,11,12,
            13,16,17,18,23,24,35,36,39,1
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
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0
        };
    };
    public final static byte isKeyword[] = IsKeyword.isKeyword;
    public final boolean isKeyword(int index) { return isKeyword[index] != 0; }

    public interface BaseCheck {
        public final static byte baseCheck[] = {0,
            1,3,3,3,3,3,1,1,1,5,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,2,3,
            4,1,2,2,3,2,3,2,2,3,
            3,2,3,2,2,0,1,2,2,2,
            0,2,0,2,1,2,1,2,2,2,
            3,2,3,3,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,2,
            3,1,1,1,1,1,1,1,1,1,
            1,1,2,1,2,2,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,6,2,
            1,1,1,1,1,1,1,1,1,6,
            2,1,1,1,1,1,1,1,6,2,
            2,2,2,2,2,2,2,2
        };
    };
    public final static byte baseCheck[] = BaseCheck.baseCheck;
    public final int baseCheck(int index) { return baseCheck[index]; }
    public final static byte rhs[] = baseCheck;
    public final int rhs(int index) { return rhs[index]; };

    public interface BaseAction {
        public final static char baseAction[] = {
            21,21,21,21,21,21,21,21,21,21,
            21,21,21,21,21,21,21,21,21,21,
            21,21,21,21,21,21,21,21,21,21,
            21,21,21,21,21,21,21,21,25,25,
            25,25,27,27,27,27,27,27,27,26,
            26,26,26,28,28,28,28,29,29,30,
            30,23,23,14,14,7,7,33,33,34,
            34,34,16,16,16,11,11,11,11,11,
            4,4,4,4,4,5,5,5,5,5,
            5,5,5,5,5,5,5,5,5,5,
            5,5,5,5,5,5,5,5,5,5,
            5,6,6,6,6,6,6,6,6,6,
            6,6,6,6,6,6,6,6,6,6,
            6,6,6,6,6,6,6,1,1,1,
            1,1,1,1,1,1,1,8,8,8,
            8,8,8,8,8,3,3,3,3,3,
            3,3,3,3,3,3,3,2,2,37,
            37,37,9,9,10,10,15,15,19,19,
            32,32,31,31,22,22,22,38,38,38,
            38,38,38,38,38,38,38,38,38,38,
            38,38,38,38,38,38,38,38,38,38,
            38,38,38,38,38,38,20,20,20,20,
            20,20,20,20,20,20,20,20,20,20,
            20,20,20,20,20,20,20,20,20,20,
            20,20,20,20,13,13,13,13,13,13,
            13,13,13,13,13,13,13,13,13,13,
            13,13,13,13,13,13,13,13,13,13,
            13,13,39,39,39,39,39,39,39,39,
            39,39,39,39,39,39,39,39,39,39,
            39,39,39,39,39,39,39,39,39,39,
            17,17,17,17,35,35,35,35,35,35,
            35,35,36,36,36,36,36,36,36,36,
            36,18,18,18,18,18,18,18,18,18,
            18,18,24,24,24,24,24,24,24,24,
            24,12,12,12,12,12,12,12,12,612,
            464,1347,459,447,447,447,452,1247,459,1251,
            555,103,55,1253,1246,55,55,55,45,50,
            364,473,55,837,7,8,9,396,55,445,
            444,55,180,456,1254,384,1234,714,385,403,
            437,385,385,385,407,1255,1,64,412,385,
            64,64,64,916,419,419,419,1455,64,64,
            361,385,410,64,64,550,64,64,64,886,
            68,68,68,340,64,64,385,512,62,1256,
            64,62,62,62,41,78,419,205,53,62,
            62,53,53,53,1474,307,60,1402,53,60,
            60,60,1215,66,53,183,1473,53,427,1358,
            66,48,52,62,1403,43,49,39,534,1336,
            481,469,359,814,186,469,481,185,185,185,
            60,1411,66,60,939,488,488,488,962,500,
            500,500,985,504,504,504,1008,508,508,508,
            1031,512,512,512,1054,516,516,516,1077,520,
            520,520,1100,339,339,339,1123,524,524,524,
            1146,528,528,528,1169,330,330,330,1192,319,
            319,319,1369,548,1285,1380,551,1268,1302,548,
            1391,553,551,47,51,331,320,553,1422,66,
            1464,1433,66,1444,66,1404,1288,1289,171,1475,
            1476,1477,1478,1482,1483,567,567
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,2,3,4,5,6,7,8,9,
            10,11,12,13,14,15,16,17,18,19,
            20,21,22,23,24,25,26,27,28,29,
            30,31,32,33,34,35,36,37,38,39,
            40,41,42,43,44,45,46,47,48,49,
            50,51,52,53,54,55,56,57,58,59,
            60,61,62,63,64,65,66,67,68,69,
            70,71,72,73,74,75,76,0,78,79,
            80,81,82,83,84,85,86,87,88,89,
            90,91,92,93,94,95,96,97,98,99,
            100,101,0,1,2,3,4,5,6,7,
            8,9,10,11,12,13,14,15,16,17,
            18,19,20,21,22,23,24,25,26,27,
            28,29,30,31,32,33,34,35,36,37,
            38,39,40,41,42,43,44,45,46,47,
            48,49,50,51,52,53,54,55,56,57,
            58,59,60,61,62,63,64,65,66,67,
            68,69,70,71,72,73,74,75,76,0,
            78,79,80,81,82,83,84,85,86,87,
            88,89,90,91,92,93,94,95,96,97,
            98,99,100,101,0,1,2,3,4,5,
            6,7,8,9,10,11,12,13,14,15,
            16,17,18,19,20,21,22,23,24,25,
            26,27,28,29,30,31,32,33,34,35,
            36,37,38,39,40,41,42,43,44,45,
            46,47,48,49,50,51,52,53,54,55,
            56,57,58,59,60,61,62,63,64,65,
            66,67,68,69,70,71,72,73,74,75,
            76,0,78,79,80,81,82,83,84,85,
            86,87,88,89,90,91,92,93,94,95,
            96,97,98,99,100,101,0,1,2,3,
            4,5,6,7,8,9,10,11,12,13,
            14,15,16,17,18,19,20,21,22,23,
            24,25,26,27,28,29,30,31,32,33,
            34,35,36,37,38,39,40,41,42,43,
            44,45,46,47,48,49,50,51,52,53,
            54,55,56,57,58,59,60,61,62,63,
            64,65,66,67,68,69,70,71,72,73,
            74,75,76,0,78,79,80,81,82,83,
            84,85,86,87,88,89,90,91,92,93,
            94,95,96,97,98,99,23,0,102,0,
            1,2,3,4,5,6,7,8,9,10,
            11,12,13,14,15,16,17,18,19,20,
            21,22,23,24,25,26,27,28,29,30,
            31,0,33,34,35,36,37,38,39,40,
            41,42,43,44,45,46,47,48,49,50,
            51,52,53,54,55,56,57,58,59,60,
            61,62,63,64,65,66,67,68,69,70,
            71,72,73,74,75,76,0,78,79,80,
            81,82,83,84,85,86,87,88,89,90,
            91,92,93,94,95,96,97,98,99,100,
            101,0,1,2,3,4,5,6,7,8,
            9,10,11,12,13,14,15,16,17,18,
            19,20,21,22,23,24,25,26,27,28,
            29,30,31,32,33,34,35,36,37,38,
            39,40,41,42,43,44,45,46,47,48,
            49,50,51,52,53,54,55,56,57,58,
            59,60,61,62,63,64,65,66,67,68,
            69,70,71,72,73,74,75,76,0,78,
            79,80,81,82,83,84,85,86,87,88,
            89,90,91,92,93,94,95,96,97,98,
            99,0,1,2,3,4,5,6,7,8,
            9,10,11,12,13,14,15,16,17,18,
            19,20,21,22,23,24,25,26,27,28,
            29,30,31,32,0,34,35,36,37,38,
            39,40,41,42,43,44,45,46,47,48,
            49,50,51,52,53,54,55,56,57,58,
            59,60,61,62,63,64,65,66,67,68,
            69,70,71,72,73,74,75,76,0,78,
            79,80,81,82,83,84,85,86,87,88,
            89,90,91,92,93,94,95,96,97,0,
            0,100,101,0,1,2,3,4,5,6,
            7,8,9,10,11,12,13,14,15,16,
            17,18,19,20,21,22,0,24,25,26,
            27,28,29,30,31,32,33,34,35,36,
            37,38,39,40,41,42,43,44,45,46,
            47,48,49,50,51,52,53,54,55,56,
            57,58,59,60,61,62,63,64,65,66,
            67,68,69,70,71,72,73,74,75,76,
            0,78,79,80,81,82,83,84,85,86,
            87,88,89,90,91,92,93,94,95,96,
            97,98,99,0,1,2,3,4,5,6,
            7,8,9,10,11,12,13,14,15,16,
            17,18,19,20,21,22,0,24,25,26,
            27,28,29,30,31,0,0,0,0,36,
            37,38,39,40,41,42,43,44,45,46,
            47,48,49,50,51,52,53,54,55,56,
            57,58,59,60,61,62,63,64,65,66,
            67,68,69,0,71,0,1,2,3,4,
            5,6,7,8,9,10,11,12,13,14,
            15,16,17,18,19,20,21,22,0,0,
            0,75,76,28,29,0,1,2,3,4,
            5,6,7,8,9,10,11,12,13,14,
            15,16,17,18,19,20,21,22,0,1,
            2,3,4,5,6,7,8,9,10,11,
            12,13,14,15,16,17,18,19,20,21,
            22,0,1,2,3,4,5,6,7,8,
            9,10,11,12,13,14,15,16,17,18,
            19,20,21,22,0,1,2,3,4,5,
            6,7,8,9,10,11,12,13,14,15,
            16,17,18,19,20,21,22,0,1,2,
            3,4,5,6,7,8,9,10,11,12,
            13,14,15,16,17,18,19,20,21,22,
            0,1,2,3,4,5,6,7,8,9,
            10,11,12,13,14,15,16,17,18,19,
            20,21,22,0,1,2,3,4,5,6,
            7,8,9,10,11,12,13,14,15,16,
            17,18,19,20,21,22,0,1,2,3,
            4,5,6,7,8,9,10,11,12,13,
            14,15,16,17,18,19,20,21,22,0,
            1,2,3,4,5,6,7,8,9,10,
            11,12,13,14,15,16,17,18,19,20,
            21,22,0,1,2,3,4,5,6,7,
            8,9,10,11,12,13,14,15,16,17,
            18,19,20,21,22,0,1,2,3,4,
            5,6,7,8,9,10,11,12,13,14,
            15,16,17,18,19,20,21,22,0,1,
            2,3,4,5,6,7,8,9,10,11,
            12,13,14,15,16,17,18,19,20,21,
            22,0,1,2,3,4,5,6,7,8,
            9,10,11,12,13,14,15,16,17,18,
            19,20,21,22,0,1,2,3,4,5,
            6,7,8,9,10,11,12,13,14,0,
            16,17,0,0,1,2,3,4,5,6,
            7,8,28,29,11,0,0,0,15,0,
            0,0,0,0,0,0,23,24,25,26,
            27,11,12,13,14,32,33,0,1,2,
            3,4,5,6,7,8,30,31,11,0,
            0,0,15,0,0,0,72,0,0,0,
            23,24,25,26,27,11,12,13,14,32,
            33,0,1,2,3,4,5,6,7,8,
            23,23,11,0,0,0,15,0,0,0,
            0,0,77,77,23,24,25,26,27,77,
            77,77,77,32,33,0,1,2,3,4,
            5,6,7,8,9,10,0,1,2,3,
            4,5,6,7,8,9,10,0,1,2,
            3,4,5,6,7,8,9,10,0,1,
            2,3,4,5,6,7,8,9,10,0,
            1,2,3,4,5,6,7,8,9,10,
            0,1,2,3,4,5,6,7,8,9,
            10,0,0,0,0,0,0,0,73,74,
            0,1,2,3,4,5,6,7,8,9,
            10,0,1,2,3,4,5,6,7,8,
            9,10,0,1,2,3,4,5,6,7,
            8,9,10,0,1,2,3,4,5,6,
            7,8,9,10,0,1,2,3,4,5,
            6,7,8,0,1,2,3,4,5,6,
            7,8,0,0,0,0,0,0,77,77,
            77,0,0,11,12,13,14,0,16,17,
            0,0,0,0,0,0,0,23,23,23,
            23,0,0,0,23,23,0,34,35,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,70,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,100,101,0,0,0,0,0,
            0,0,0,0,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            567,631,631,631,631,631,631,631,631,631,
            631,631,631,631,631,631,631,631,631,631,
            631,631,631,631,631,631,631,631,631,631,
            631,631,571,537,631,631,631,631,631,631,
            631,631,631,631,631,631,631,631,631,631,
            631,631,631,631,631,631,631,631,631,631,
            631,631,631,631,631,631,631,631,631,631,
            631,631,631,631,631,631,631,61,631,631,
            631,631,631,631,631,631,631,631,631,631,
            631,631,631,395,631,631,631,631,631,631,
            631,631,567,622,622,622,622,622,622,622,
            622,622,622,622,622,622,622,622,622,622,
            622,622,622,622,622,622,622,622,622,622,
            622,622,622,622,622,622,622,622,622,622,
            622,622,622,622,622,622,622,622,622,622,
            622,622,622,622,622,622,622,622,622,622,
            622,622,622,622,622,622,622,622,622,622,
            622,622,622,622,622,622,622,621,437,56,
            622,622,622,622,622,622,622,622,622,622,
            622,622,622,622,622,622,622,622,622,622,
            622,622,622,622,567,620,620,620,620,620,
            620,620,620,620,620,620,620,620,620,620,
            620,620,620,620,620,620,620,620,620,620,
            620,620,620,620,620,620,620,620,620,620,
            620,620,620,620,620,620,620,620,620,620,
            620,620,620,620,620,620,620,620,620,620,
            620,620,620,620,620,620,620,620,620,620,
            620,620,620,620,620,620,620,620,620,577,
            625,567,620,620,620,620,620,620,620,620,
            620,620,620,620,620,620,620,620,620,620,
            620,620,620,620,620,620,11,627,627,627,
            627,627,627,627,627,627,627,627,627,627,
            627,627,627,627,627,627,627,627,627,627,
            627,627,627,627,627,627,627,627,627,627,
            627,627,627,627,627,627,627,627,627,627,
            627,627,627,627,627,627,627,627,627,627,
            627,627,627,627,627,627,627,627,627,627,
            627,627,627,627,627,627,627,627,627,627,
            627,627,627,567,627,627,627,627,627,627,
            627,627,627,627,627,627,627,627,627,627,
            627,627,627,627,627,627,573,567,627,567,
            631,631,631,631,631,631,631,631,631,631,
            631,631,631,631,631,631,631,631,631,631,
            631,631,631,631,631,631,631,631,631,631,
            631,567,537,631,631,631,631,631,631,631,
            631,631,631,631,631,631,631,631,631,631,
            631,631,631,631,631,631,631,631,631,631,
            631,631,631,631,631,631,631,631,631,631,
            631,631,631,631,631,631,567,631,631,631,
            631,631,631,631,631,631,631,631,631,631,
            631,631,429,631,631,631,631,631,631,631,
            631,567,629,629,629,629,629,629,629,629,
            629,629,629,629,629,629,629,629,629,629,
            629,629,629,629,629,629,629,629,629,629,
            629,629,629,569,538,629,629,629,629,629,
            629,629,629,629,629,629,629,629,629,629,
            629,629,629,629,629,629,629,629,629,629,
            629,629,629,629,629,629,629,629,629,629,
            629,629,629,629,629,629,629,629,567,629,
            629,629,629,629,629,629,629,629,629,629,
            629,629,629,629,629,629,629,629,629,629,
            629,567,357,464,464,464,464,464,464,464,
            464,464,447,447,447,447,447,447,447,447,
            447,447,447,447,387,447,447,447,447,447,
            447,447,447,435,567,555,555,447,447,447,
            447,447,447,447,447,447,447,447,447,447,
            447,447,447,447,447,447,447,447,447,447,
            447,447,447,447,447,447,447,447,447,447,
            447,555,447,351,580,581,373,582,567,591,
            594,384,593,590,595,589,587,588,602,603,
            600,601,604,586,596,363,583,584,585,567,
            567,555,555,567,385,385,385,385,385,385,
            385,385,385,385,385,385,385,385,385,385,
            385,385,385,385,385,385,567,385,385,385,
            385,385,385,385,385,385,386,385,385,385,
            385,385,385,385,385,385,385,385,385,385,
            385,385,385,385,385,385,385,385,385,385,
            385,385,385,385,385,385,385,385,385,385,
            385,385,385,385,385,385,385,385,385,385,
            567,385,385,385,385,385,385,385,385,385,
            385,385,385,385,385,385,385,385,385,385,
            385,385,385,1,753,753,753,753,753,753,
            753,753,753,753,752,752,752,752,752,752,
            752,752,752,752,752,752,25,752,752,752,
            752,752,752,752,752,567,567,567,567,752,
            752,752,752,752,752,752,752,752,752,752,
            752,752,752,752,752,752,752,752,752,752,
            752,752,752,752,752,752,752,752,752,752,
            752,752,752,567,752,40,635,635,635,635,
            635,635,635,635,635,635,635,635,635,635,
            635,635,635,635,635,635,635,635,567,567,
            567,626,382,608,608,567,419,419,419,419,
            419,419,419,419,419,419,419,419,419,419,
            419,419,419,419,419,419,419,419,567,488,
            488,488,488,488,488,488,488,488,488,488,
            488,488,488,488,488,488,488,488,488,488,
            488,567,500,500,500,500,500,500,500,500,
            500,500,500,500,500,500,500,500,500,500,
            500,500,500,500,567,504,504,504,504,504,
            504,504,504,504,504,504,504,504,504,504,
            504,504,504,504,504,504,504,567,508,508,
            508,508,508,508,508,508,508,508,508,508,
            508,508,508,508,508,508,508,508,508,508,
            567,512,512,512,512,512,512,512,512,512,
            512,512,512,512,512,512,512,512,512,512,
            512,512,512,567,516,516,516,516,516,516,
            516,516,516,516,516,516,516,516,516,516,
            516,516,516,516,516,516,567,520,520,520,
            520,520,520,520,520,520,520,520,520,520,
            520,520,520,520,520,520,520,520,520,567,
            906,906,906,906,906,906,906,906,906,906,
            906,906,906,906,906,906,906,906,906,906,
            906,906,567,524,524,524,524,524,524,524,
            524,524,524,524,524,524,524,524,524,524,
            524,524,524,524,524,567,528,528,528,528,
            528,528,528,528,528,528,528,528,528,528,
            528,528,528,528,528,528,528,528,567,897,
            897,897,897,897,897,897,897,897,897,897,
            897,897,897,897,897,897,897,897,897,897,
            897,567,886,886,886,886,886,886,886,886,
            886,886,886,886,886,886,886,886,886,886,
            886,886,886,886,7,633,633,633,633,633,
            633,633,633,633,633,619,615,615,619,567,
            469,469,567,567,556,557,559,560,561,562,
            563,564,606,606,911,567,65,567,908,567,
            44,567,63,63,323,323,914,910,912,909,
            484,617,612,612,617,913,915,567,898,898,
            898,898,898,898,898,898,403,403,911,567,
            567,567,908,567,46,567,532,147,148,567,
            914,910,912,909,492,618,614,614,618,913,
            915,567,887,887,887,887,887,887,887,887,
            169,169,911,567,567,567,908,567,567,567,
            567,567,566,7,914,910,912,909,496,30,
            32,5,3,913,915,567,481,481,481,481,
            481,481,481,481,481,481,31,459,459,459,
            459,459,459,459,459,459,459,69,633,633,
            633,633,633,633,633,633,633,633,70,548,
            548,548,548,548,548,548,548,548,548,567,
            551,551,551,551,551,551,551,551,551,551,
            567,553,553,553,553,553,553,553,553,553,
            553,184,65,182,567,567,567,567,535,540,
            72,633,633,633,633,633,633,633,633,633,
            633,71,633,633,633,633,633,633,633,633,
            633,633,74,633,633,633,633,633,633,633,
            633,633,633,73,633,633,633,633,633,633,
            633,633,633,633,169,550,550,550,550,550,
            550,550,550,170,738,738,738,738,738,738,
            738,738,9,12,149,150,151,152,1,7,
            12,153,154,616,610,610,616,567,469,469,
            567,567,567,567,567,567,567,169,169,169,
            169,567,567,567,169,169,567,750,750,567,
            567,567,567,567,567,567,567,567,567,567,
            567,567,567,567,567,567,567,567,567,567,
            567,567,567,567,567,567,567,567,567,567,
            567,567,567,750,567,567,567,567,567,567,
            567,567,567,567,567,567,567,567,567,567,
            567,567,567,567,567,567,567,567,567,567,
            567,567,567,750,750
        };
    };
    public final static char termAction[] = TermAction.termAction;
    public final int termAction(int index) { return termAction[index]; }
    public final int asb(int index) { return 0; }
    public final int asr(int index) { return 0; }
    public final int nasb(int index) { return 0; }
    public final int nasr(int index) { return 0; }
    public final int terminalIndex(int index) { return 0; }
    public final int nonterminalIndex(int index) { return 0; }
    public final int scopePrefix(int index) { return 0;}
    public final int scopeSuffix(int index) { return 0;}
    public final int scopeLhs(int index) { return 0;}
    public final int scopeLa(int index) { return 0;}
    public final int scopeStateSet(int index) { return 0;}
    public final int scopeRhs(int index) { return 0;}
    public final int scopeState(int index) { return 0;}
    public final int inSymb(int index) { return 0;}
    public final String name(int index) { return null; }
    public final int originalState(int state) { return 0; }
    public final int asi(int state) { return 0; }
    public final int nasi(int state) { return 0; }
    public final int inSymbol(int state) { return 0; }

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
