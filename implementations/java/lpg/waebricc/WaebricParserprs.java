package waebricc;

public class WaebricParserprs implements lpg.runtime.ParseTable, WaebricParsersym {
    public final static int ERROR_SYMBOL = 60;
    public final int getErrorSymbol() { return ERROR_SYMBOL; }

    public final static int SCOPE_UBOUND = 11;
    public final int getScopeUbound() { return SCOPE_UBOUND; }

    public final static int SCOPE_SIZE = 12;
    public final int getScopeSize() { return SCOPE_SIZE; }

    public final static int MAX_NAME_LENGTH = 31;
    public final int getMaxNameLength() { return MAX_NAME_LENGTH; }

    public final static int NUM_STATES = 134;
    public final int getNumStates() { return NUM_STATES; }

    public final static int NT_OFFSET = 60;
    public final int getNtOffset() { return NT_OFFSET; }

    public final static int LA_STATE_OFFSET = 1072;
    public final int getLaStateOffset() { return LA_STATE_OFFSET; }

    public final static int MAX_LA = 2;
    public final int getMaxLa() { return MAX_LA; }

    public final static int NUM_RULES = 149;
    public final int getNumRules() { return NUM_RULES; }

    public final static int NUM_NONTERMINALS = 72;
    public final int getNumNonterminals() { return NUM_NONTERMINALS; }

    public final static int NUM_SYMBOLS = 132;
    public final int getNumSymbols() { return NUM_SYMBOLS; }

    public final static int SEGMENT_SIZE = 8192;
    public final int getSegmentSize() { return SEGMENT_SIZE; }

    public final static int START_STATE = 192;
    public final int getStartState() { return START_STATE; }

    public final static int IDENTIFIER_SYMBOL = 0;
    public final int getIdentifier_SYMBOL() { return IDENTIFIER_SYMBOL; }

    public final static int EOFT_SYMBOL = 46;
    public final int getEoftSymbol() { return EOFT_SYMBOL; }

    public final static int EOLT_SYMBOL = 46;
    public final int getEoltSymbol() { return EOLT_SYMBOL; }

    public final static int ACCEPT_ACTION = 922;
    public final int getAcceptAction() { return ACCEPT_ACTION; }

    public final static int ERROR_ACTION = 923;
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
            0,0,0,0,0,0,0,0,1,0,
            0,0,0,0,0,0,0,0,0,0,
            0,1,0,0,0,0,0,0,0,0,
            0,0,0,1,0,0,0,1,0,0,
            0,0,0,1,0,1,1,1,0,0,
            0,0
        };
    };
    public final static byte isNullable[] = IsNullable.isNullable;
    public final boolean isNullable(int index) { return isNullable[index] != 0; }

    public interface ProsthesesIndex {
        public final static byte prosthesesIndex[] = {0,
            27,28,31,32,33,34,35,36,37,20,
            21,24,45,46,47,48,50,51,52,55,
            56,57,44,49,54,58,65,7,15,60,
            61,67,59,62,71,72,4,6,39,40,
            41,70,8,9,10,11,12,14,16,17,
            18,19,22,23,25,26,30,38,42,43,
            53,63,69,2,3,5,13,29,64,66,
            68,1
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
            0,0,0,0,0,0,0,0,0,0
        };
    };
    public final static byte isKeyword[] = IsKeyword.isKeyword;
    public final boolean isKeyword(int index) { return isKeyword[index] != 0; }

    public interface BaseCheck {
        public final static short baseCheck[] = {0,
            0,2,3,3,1,1,0,1,2,1,
            1,1,1,3,2,5,4,2,3,3,
            1,1,1,0,1,3,1,3,1,2,
            0,1,2,1,2,3,3,1,3,1,
            0,1,3,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,3,1,
            1,3,3,0,1,3,1,3,3,3,
            1,2,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,5,7,7,7,7,5,3,
            0,1,2,1,3,3,3,3,2,2,
            4,3,3,2,2,1,1,1,1,3,
            2,7,7,1,2,1,4,4,2,0,
            1,2,1,2,2,2,2,2,4,-110,
            0,0,0,0,0,0,0,0,0,0,
            0,-29,0,0,0,0,0,0,0,0,
            0,0,-5,-15,-8,-83,-36,0,-52,0,
            0,-11,-93,0,0,0,0,-12,-95,-2,
            0,-1,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,-13,
            0,0,0,0,0,0,0,-17,0,-27,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,-30,0,0,0,0,0,0,0,
            0,0,-61,-55,0,0,-81,-65,0,0,
            0,-114,-20,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,-128,0,-21,0,0,-119,
            0,-19,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,-133,-24,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,-134,
            0,0,0,0,-25,0,0,-68,-26,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,-14,-97,-28,0,
            0,-3,0,0,-6,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,-66,-33,0,0,0,0,0,
            -34,-35,0,0,0,-18,0,0,0,0,
            0,0,0,-38,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,-22,-39,0,-40,-41,0,-16,-42,
            -43,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,-89,
            -44,0,-45,-46,0,-49,-50,-51,-56,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,-32,-57,0,0,
            0,0,-58,-59,-60,-63,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,-105,-64,-67,-69,-70,-73,-75,
            -76,-77,-78,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            -116,-79,-80,-85,-86,-87,-88,-90,-94,-101,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,-117,-104,-106,
            -107,-108,-109,-111,-112,-113,-115,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,-48,0,0,0,0,0,
            0,0,0,0,-62,0,0,0,0,0,
            0,0,0,0,-102,0,0,0,0,0,
            0,0,0,0,-118,-37,0,0,0,0,
            0,0,0,0,0,-121,-71,0,0,0,
            0,0,0,0,0,0,-122,-123,-9,-124,
            -129,0,0,-130,-131,-132,0,0,0,0,
            0,0,0,0,0,0,0,0,-7,0,
            0,-72,0,0,0,0,0,0,0,0,
            0,-98,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,-10,0,0,-120,
            0,0,0,0,0,0,0,0,0,-125,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,-126,
            0,0,0,0,0,0,0,0,0,-23,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,-74,0,0,
            0,0,0,0,0,0,0,-82,0,0,
            0,0,0,0,0,0,0,-91,0,0,
            0,0,0,0,0,0,0,-92,0,0,
            0,0,0,0,0,0,0,-96,0,0,
            0,0,0,0,0,0,0,-100,0,0,
            0,0,0,0,0,0,0,-103,0,0,
            0,0,0,0,0,0,0,-127,0,0,
            0,0,0,0,0,0,0,-4,-54,-31,
            0,-99,0,0,0,0,-47,0,0,0,
            0,0,0,0,-53,0,0,0,0,0,
            0,0,0,-84,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0
        };
    };
    public final static short baseCheck[] = BaseCheck.baseCheck;
    public final int baseCheck(int index) { return baseCheck[index]; }
    public final static short rhs[] = baseCheck;
    public final int rhs(int index) { return rhs[index]; };

    public interface BaseAction {
        public final static char baseAction[] = {
            64,64,64,65,37,37,38,66,66,43,
            43,44,44,44,46,47,45,45,48,48,
            49,49,50,28,67,67,51,51,52,10,
            10,54,54,12,12,53,53,55,55,56,
            56,68,68,57,57,2,2,2,2,2,
            2,2,9,9,9,9,9,9,3,8,
            6,7,4,5,58,58,39,39,40,41,
            60,60,59,23,23,23,23,23,23,23,
            23,61,61,61,61,61,61,61,25,25,
            25,25,25,33,33,33,33,62,62,62,
            62,69,69,69,20,21,30,22,31,19,
            13,29,29,32,32,16,17,18,14,15,
            24,24,24,24,26,34,71,71,71,27,
            27,27,27,27,1,70,70,63,63,11,
            42,42,35,35,36,36,36,36,36,36,
            21,463,468,461,441,440,437,436,51,464,
            33,179,272,81,82,83,84,85,86,87,
            98,99,100,82,153,126,336,240,517,272,
            102,103,8,129,28,162,33,162,173,216,
            87,467,4,349,162,150,73,74,75,76,
            78,79,80,89,90,91,573,77,104,92,
            44,625,124,94,95,30,572,96,132,125,
            1,463,468,461,441,440,437,436,51,464,
            33,179,543,81,82,83,84,85,86,87,
            98,99,100,178,463,515,461,441,440,437,
            436,51,464,231,95,2,190,71,151,516,
            130,467,71,259,349,162,220,73,74,75,
            76,78,79,80,89,90,91,88,77,114,
            92,97,124,414,496,129,487,261,142,253,
            240,648,6,65,522,349,162,150,73,74,
            75,76,78,79,80,89,90,91,573,77,
            104,92,520,129,155,94,95,69,656,96,
            22,135,70,349,162,150,73,74,75,76,
            78,79,80,89,90,91,573,77,107,92,
            129,401,402,94,95,20,108,96,79,268,
            349,162,150,73,74,75,76,78,79,80,
            89,90,91,573,77,105,92,76,351,227,
            94,95,79,106,96,79,22,349,162,220,
            73,74,75,76,78,79,80,89,90,91,
            88,77,114,92,323,159,218,20,402,487,
            6,279,181,6,141,253,102,66,522,848,
            173,139,15,173,269,406,349,162,220,73,
            74,75,76,78,79,80,89,90,91,88,
            77,114,92,102,280,395,282,284,487,128,
            286,287,548,349,162,220,73,74,75,76,
            78,79,80,89,90,91,88,77,114,92,
            102,290,414,292,296,487,302,304,306,308,
            349,162,220,73,74,75,76,78,79,80,
            89,90,91,88,77,114,92,122,313,569,
            26,210,487,315,317,319,321,349,162,220,
            73,74,75,76,78,79,80,89,90,91,
            88,77,113,92,148,322,270,174,326,327,
            329,330,331,333,349,162,220,73,74,75,
            76,78,79,80,89,90,91,88,77,138,
            92,148,334,335,339,342,340,191,343,344,
            345,349,162,220,73,74,75,76,78,79,
            80,89,90,91,88,77,107,92,148,356,
            361,347,360,362,365,367,170,255,349,162,
            220,73,74,75,76,78,79,80,89,90,
            91,88,77,105,92,224,463,542,461,441,
            440,437,436,51,464,193,547,40,461,441,
            440,437,436,51,464,213,547,40,461,441,
            440,437,436,51,464,366,167,463,519,461,
            441,440,437,436,51,464,368,167,463,519,
            461,441,440,437,436,51,464,369,375,27,
            378,383,42,518,388,390,376,923,923,923,
            545,546,923,523,549,923,923,923,923,70,
            37,546,167,463,519,461,441,440,437,436,
            51,464,213,463,542,461,441,440,437,436,
            51,464,9,649,11,12,13,79,923,131,
            167,463,519,461,441,440,437,436,51,464,
            167,463,519,461,441,440,437,436,51,464,
            25,210,923,923,923,6,923,650,923,923,
            923,923,923,923,4,173,182,651,923,43,
            167,463,519,461,441,440,437,436,51,464,
            213,463,434,461,441,440,437,436,51,464,
            923,923,923,923,923,923,923,654,213,463,
            59,461,441,440,437,436,51,464,213,463,
            72,461,441,440,437,436,51,464,213,463,
            570,461,441,440,437,436,51,464,213,463,
            571,461,441,440,437,436,51,464,213,463,
            68,461,441,440,437,436,51,464,235,463,
            68,461,441,440,437,436,51,464,213,463,
            39,461,441,440,437,436,51,464,213,463,
            655,461,441,440,437,436,51,464,24,310,
            229,516,358,923,923,923,923,300,923,34,
            162,176,34,162,176,189,923,923,923,923,
            923,923,923,923,254,923,923,923,923,923,
            923,923,923,923,923,923,923,923,923,923,
            923,8,649,11,12,13,65,522,923,923,
            141,253,923,778,923,923,778,139,257,141,
            253,262,923,136,3,520,139,923,923,923,
            258,923,923
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,2,0,4,0,1,0,8,9,
            10,6,12,13,14,15,16,17,18,0,
            0,1,2,0,4,0,0,27,8,9,
            10,24,12,13,14,15,16,17,18,0,
            0,1,2,0,4,5,3,27,8,9,
            10,11,33,30,31,32,30,31,32,19,
            20,21,22,0,1,2,0,4,5,0,
            0,8,9,10,11,0,1,2,0,1,
            5,0,19,20,21,22,0,12,13,14,
            15,16,17,18,0,1,2,0,29,0,
            19,0,1,2,34,35,12,13,14,15,
            16,17,18,12,13,14,15,16,17,18,
            26,0,1,2,38,0,1,0,0,1,
            2,0,46,12,13,14,15,16,17,18,
            12,13,14,15,16,17,18,0,1,2,
            0,1,0,1,0,24,29,3,0,12,
            13,14,15,16,17,18,0,1,2,0,
            4,5,0,0,8,9,10,0,1,2,
            0,4,24,11,11,8,9,10,0,39,
            0,3,0,1,2,7,4,7,6,11,
            8,9,10,23,27,36,37,19,20,21,
            22,45,0,1,2,0,4,0,28,0,
            8,9,10,0,1,2,0,4,0,1,
            0,8,9,10,0,1,2,11,4,0,
            1,11,8,9,10,19,20,21,22,19,
            20,21,22,0,0,40,41,42,0,0,
            0,7,3,5,11,5,7,0,0,0,
            3,0,19,20,21,22,5,23,0,0,
            26,0,3,0,6,0,0,0,7,0,
            7,0,7,7,26,0,7,28,7,0,
            1,0,7,0,3,0,3,0,3,0,
            1,4,0,1,0,1,0,1,0,1,
            0,0,0,3,3,0,0,5,0,0,
            0,6,0,0,0,0,1,3,0,0,
            11,0,0,0,0,19,0,6,4,6,
            0,1,6,23,26,0,23,0,1,0,
            0,0,23,3,0,0,0,0,0,5,
            28,5,5,5,0,0,44,0,0,24,
            0,43,0,6,25,11,25,0,6,0,
            25,0,0,6,0,6,0,0,0,0,
            25,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            923,865,254,1,983,923,946,923,981,984,
            595,941,287,263,850,345,243,750,314,923,
            923,865,254,7,983,923,10,849,981,984,
            595,937,575,574,850,345,243,750,314,923,
            31,369,369,27,369,369,439,849,369,369,
            369,369,466,669,175,375,669,175,375,369,
            369,369,369,32,369,369,923,369,369,24,
            923,369,369,369,369,111,369,433,923,946,
            292,5,369,369,369,369,923,287,263,850,
            345,243,750,314,923,874,433,923,188,923,
            697,111,369,433,852,994,287,263,850,345,
            243,750,314,287,263,850,345,243,750,314,
            1332,112,369,433,372,923,367,923,923,369,
            433,923,922,287,263,850,345,243,750,314,
            575,574,850,345,243,750,314,923,369,433,
            923,394,923,369,923,940,188,1042,923,287,
            263,850,345,243,750,314,923,1057,857,923,
            983,637,923,923,981,984,595,923,1057,857,
            21,983,939,174,798,981,984,595,140,460,
            45,134,923,1057,857,134,983,52,958,488,
            981,984,595,348,849,647,636,494,469,493,
            495,672,923,1057,857,923,983,923,828,923,
            981,984,595,41,1057,857,140,983,923,394,
            143,981,984,595,923,577,857,488,983,923,
            1057,488,981,984,595,494,469,493,495,494,
            469,493,495,140,147,1049,1050,1051,923,111,
            923,134,64,177,818,626,64,34,923,923,
            1043,29,494,469,493,495,605,134,923,923,
            134,50,1041,49,942,48,47,923,57,46,
            56,45,55,54,1033,923,53,788,52,64,
            521,923,768,923,1038,923,1046,923,1045,31,
            1113,544,923,1070,923,1069,923,1068,923,1067,
            923,923,134,1040,1039,923,129,292,923,923,
            67,183,923,44,30,32,1136,1044,148,38,
            808,923,923,923,923,189,923,959,1072,576,
            923,521,541,368,986,923,682,31,1113,923,
            923,88,615,1060,923,97,923,923,923,290,
            514,700,710,740,923,923,985,923,923,1032,
            923,550,923,285,568,838,93,923,1056,923,
            101,923,923,1055,923,313,923,923,923,923,
            340
        };
    };
    public final static char termAction[] = TermAction.termAction;
    public final int termAction(int index) { return termAction[index]; }

    public interface Asb {
        public final static char asb[] = {0,
            5,5,129,2,1,129,156,129,2,129,
            32,8,14,22,129,157,32,23,144,154,
            154,92,75,15,20,66,116,59,64,74,
            129,91,32,145,84,129,147,101,15,37,
            37,37,37,37,37,47,100,131,15,15,
            15,115,108,75,92,80,129,129,129,129,
            59,139,15,15,17,34,35,129,8,145,
            147,147,49,75,101,8,52,137,55,66,
            44,75,75,109,58,145,84,82,23,35,
            75,75,121,145,10,75,129,75,75,75,
            80,75,75,32,121,15,145,87,89,116,
            154,154,103,44,106,121,121,89,129,147,
            154,154,8,145,147,147,75,121,145,145,
            145,87,121,121
        };
    };
    public final static char asb[] = Asb.asb;
    public final int asb(int index) { return asb[index]; }

    public interface Asr {
        public final static byte asr[] = {0,
            19,31,30,32,38,46,0,11,0,40,
            41,42,0,24,3,0,1,39,0,33,
            0,5,14,16,1,15,18,17,2,12,
            13,24,0,5,28,0,7,6,26,44,
            3,23,19,34,35,0,7,0,6,19,
            0,26,23,0,44,23,0,43,22,19,
            21,11,20,24,5,12,13,14,15,16,
            17,18,3,27,1,8,10,2,9,4,
            0,7,28,6,23,0,25,0,25,39,
            24,14,16,15,18,17,2,12,13,1,
            26,0,36,37,0,26,23,7,3,22,
            19,21,11,20,5,27,8,10,4,9,
            12,13,14,16,15,18,17,2,1,0,
            1,8,10,2,4,9,44,0,8,10,
            2,4,9,1,6,0,9,4,2,10,
            8,1,45,5,0,24,29,0
        };
    };
    public final static byte asr[] = Asr.asr;
    public final int asr(int index) { return asr[index]; }

    public interface Nasb {
        public final static byte nasb[] = {0,
            20,18,49,56,10,49,54,10,56,49,
            10,10,10,43,30,54,10,33,41,10,
            10,33,4,10,10,10,22,47,11,3,
            61,51,10,10,10,9,4,10,10,10,
            10,10,10,10,10,10,64,4,10,10,
            10,11,47,58,32,10,10,10,10,10,
            47,4,10,10,38,45,10,41,10,10,
            4,4,10,4,10,10,10,10,10,10,
            36,4,30,47,10,10,10,10,33,10,
            4,4,13,10,16,4,64,4,58,4,
            10,4,4,10,51,10,10,10,10,1,
            10,10,10,36,10,51,51,10,9,4,
            10,10,10,10,4,4,4,13,10,10,
            10,10,13,13
        };
    };
    public final static byte nasb[] = Nasb.nasb;
    public final int nasb(int index) { return nasb[index]; }

    public interface Nasr {
        public final static char nasr[] = {0,
            61,11,41,3,4,5,6,7,1,0,
            53,0,23,11,0,71,0,65,0,64,
            0,1,3,4,5,6,7,41,62,11,
            0,40,32,11,0,60,0,1,63,0,
            50,0,32,11,48,0,36,0,38,0,
            11,25,0,52,0,44,0,11,59,0,
            1,70,0,40,0
        };
    };
    public final static char nasr[] = Nasr.nasr;
    public final int nasr(int index) { return nasr[index]; }

    public interface TerminalIndex {
        public final static byte terminalIndex[] = {0,
            19,5,9,22,3,4,17,21,23,7,
            13,34,35,37,39,40,41,42,12,1,
            11,14,10,32,36,6,25,15,20,31,
            33,46,24,26,27,28,29,30,38,43,
            44,45,2,8,16,47,48,49,50,51,
            52,53,54,55,56,57,58,59,60,61
        };
    };
    public final static byte terminalIndex[] = TerminalIndex.terminalIndex;
    public final int terminalIndex(int index) { return terminalIndex[index]; }

    public interface NonterminalIndex {
        public final static byte nonterminalIndex[] = {0,
            78,79,81,82,83,84,85,0,86,72,
            73,75,0,0,0,0,0,0,0,0,
            0,0,92,0,94,0,98,0,0,0,
            0,100,95,0,103,104,63,64,87,88,
            89,0,65,66,0,0,0,67,68,69,
            70,71,74,0,76,77,80,0,90,91,
            93,96,102,0,62,0,0,0,97,99,
            101,0
        };
    };
    public final static byte nonterminalIndex[] = NonterminalIndex.nonterminalIndex;
    public final int nonterminalIndex(int index) { return nonterminalIndex[index]; }

    public interface ScopePrefix {
        public final static byte scopePrefix[] = {
            1,19,51,51,37,32,63,66,44,10,
            10,71
        };
    };
    public final static byte scopePrefix[] = ScopePrefix.scopePrefix;
    public final int scopePrefix(int index) { return scopePrefix[index]; }

    public interface ScopeSuffix {
        public final static byte scopeSuffix[] = {
            8,8,57,60,42,35,35,69,47,13,
            26,73
        };
    };
    public final static byte scopeSuffix[] = ScopeSuffix.scopeSuffix;
    public final int scopeSuffix(int index) { return scopeSuffix[index]; }

    public interface ScopeLhs {
        public final static char scopeLhs[] = {
            27,27,30,21,19,13,5,4,19,27,
            27,8
        };
    };
    public final static char scopeLhs[] = ScopeLhs.scopeLhs;
    public final int scopeLhs(int index) { return scopeLhs[index]; }

    public interface ScopeLa {
        public final static byte scopeLa[] = {
            6,6,25,25,24,26,26,44,39,6,
            6,7
        };
    };
    public final static byte scopeLa[] = ScopeLa.scopeLa;
    public final int scopeLa(int index) { return scopeLa[index]; }

    public interface ScopeStateSet {
        public final static byte scopeStateSet[] = {
            17,17,34,24,24,24,1,1,24,17,
            17,1
        };
    };
    public final static byte scopeStateSet[] = ScopeStateSet.scopeStateSet;
    public final int scopeStateSet(int index) { return scopeStateSet[index]; }

    public interface ScopeRhs {
        public final static char scopeRhs[] = {0,
            87,5,37,6,87,5,0,6,0,87,
            5,0,6,37,5,87,6,0,87,5,
            36,6,87,5,0,6,36,5,87,6,
            0,89,2,0,26,0,89,39,130,14,
            0,24,0,130,14,0,39,89,24,0,
            93,6,87,5,12,0,25,93,0,25,
            85,0,118,2,0,128,10,0,44,0,
            69,0,7,62,0
        };
    };
    public final static char scopeRhs[] = ScopeRhs.scopeRhs;
    public final int scopeRhs(int index) { return scopeRhs[index]; }

    public interface ScopeState {
        public final static char scopeState[] = {0,
            838,150,828,615,818,682,808,798,788,778,
            768,605,595,243,220,750,740,710,700,672,
            637,626,0,568,541,514,460,254,487,220,
            433,406,367,340,313,285,150,183,0
        };
    };
    public final static char scopeState[] = ScopeState.scopeState;
    public final int scopeState(int index) { return scopeState[index]; }

    public interface InSymb {
        public final static char inSymb[] = {0,
            0,124,38,97,98,32,30,31,104,19,
            127,29,112,1,11,3,89,108,5,13,
            12,2,17,18,15,70,72,1,71,16,
            14,92,89,109,110,5,5,89,62,67,
            66,65,64,63,61,69,2,10,33,101,
            62,71,1,27,2,20,11,21,19,22,
            96,5,101,62,130,1,61,23,61,87,
            5,45,62,7,118,1,100,128,62,113,
            119,114,72,1,4,115,116,61,39,108,
            28,11,6,87,19,11,23,23,34,11,
            43,23,28,89,28,62,62,93,83,72,
            13,12,6,119,1,6,25,121,5,5,
            37,36,61,87,5,5,11,6,87,87,
            62,93,6,25
        };
    };
    public final static char inSymb[] = InSymb.inSymb;
    public final int inSymb(int index) { return inSymb[index]; }

    public interface Name {
        public final static String name[] = {
            "",
            "@",
            "%",
            "(",
            ")",
            "{",
            "}",
            "[",
            "]",
            ";",
            ",",
            "$",
            ".",
            ":",
            "#",
            "=",
            "!",
            "+",
            "$empty",
            "IDENTIFIER",
            "Path",
            "StringLiteral",
            "IntegerLiteral",
            "SymbolLiteral",
            "CommentLiteral",
            "PreText",
            "MidText",
            "PostText",
            "AND_AND",
            "OR_OR",
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
            "list",
            "record",
            "string",
            "import",
            "EOF_TOKEN",
            "SlComment",
            "MlComment",
            "DocComment",
            "MINUS",
            "XOR",
            "AND",
            "MULTIPLY",
            "OR",
            "TWIDDLE",
            "GREATER",
            "LESS",
            "QUESTION",
            "SLASH",
            "ERROR_TOKEN",
            "Module",
            "ModuleIds",
            "ModuleId",
            "ModuleBlocks",
            "ModuleBlock",
            "ParameterDeclOpt",
            "ParameterDecls",
            "ParameterDecl",
            "Mappings",
            "Mapping",
            "Markup",
            "Designator",
            "ArgumentsOpt",
            "Markups",
            "Arguments",
            "Argument",
            "Var",
            "Expression",
            "Expressions",
            "ExpressionString",
            "ExpressionCollection",
            "ExpressionPair",
            "ExpressionConstant",
            "ExpressionSymbol",
            "ExpressionNoPlus",
            "KeyValuePairs",
            "KeyValuePair",
            "Embedding",
            "Embed",
            "TextTail",
            "StatementWithoutSubstatement",
            "StatementWithoutSubAndMarkup",
            "Statement",
            "StatementNoShortIf",
            "StatementWithoutMarkup",
            "StatementWithoutMarkupNoShortI" +
            "f",
            "Predicate",
            "Assignments",
            "Statements",
            "Type",
            "Assignment",
            "Attributes",
            "Attribute"
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
