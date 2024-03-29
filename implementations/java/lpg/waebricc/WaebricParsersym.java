package waebricc;

public interface WaebricParsersym {
    public final static int
      TK_IDENTIFIER = 1,
      TK_AND_AND = 33,
      TK_OR_OR = 34,
      TK_Path = 29,
      TK_StringLiteral = 8,
      TK_IntegerLiteral = 4,
      TK_SymbolLiteral = 9,
      TK_CommentLiteral = 35,
      TK_PreText = 27,
      TK_MidText = 36,
      TK_PostText = 37,
      TK_module = 38,
      TK_site = 30,
      TK_end = 24,
      TK_def = 31,
      TK_if = 12,
      TK_each = 13,
      TK_else = 25,
      TK_let = 14,
      TK_in = 39,
      TK_comment = 15,
      TK_echo = 16,
      TK_cdata = 17,
      TK_yield = 18,
      TK_list = 40,
      TK_record = 41,
      TK_string = 42,
      TK_import = 32,
      TK_AT = 20,
      TK_PERCENT = 43,
      TK_LPAREN = 5,
      TK_RPAREN = 6,
      TK_LBRACE = 2,
      TK_RBRACE = 26,
      TK_LBRACKET = 10,
      TK_RBRACKET = 44,
      TK_SEMICOLON = 3,
      TK_COMMA = 23,
      TK_DOLLAR = 21,
      TK_DOT = 19,
      TK_COLON = 11,
      TK_SHARP = 22,
      TK_EQUAL = 28,
      TK_NOT = 45,
      TK_PLUS = 7,
      TK_EOF_TOKEN = 46,
      TK_SlComment = 47,
      TK_MlComment = 48,
      TK_ERROR_TOKEN = 49;

    public final static String orderedTerminalSymbols[] = {
                 "",
                 "IDENTIFIER",
                 "LBRACE",
                 "SEMICOLON",
                 "IntegerLiteral",
                 "LPAREN",
                 "RPAREN",
                 "PLUS",
                 "StringLiteral",
                 "SymbolLiteral",
                 "LBRACKET",
                 "COLON",
                 "if",
                 "each",
                 "let",
                 "comment",
                 "echo",
                 "cdata",
                 "yield",
                 "DOT",
                 "AT",
                 "DOLLAR",
                 "SHARP",
                 "COMMA",
                 "end",
                 "else",
                 "RBRACE",
                 "PreText",
                 "EQUAL",
                 "Path",
                 "site",
                 "def",
                 "import",
                 "AND_AND",
                 "OR_OR",
                 "CommentLiteral",
                 "MidText",
                 "PostText",
                 "module",
                 "in",
                 "list",
                 "record",
                 "string",
                 "PERCENT",
                 "RBRACKET",
                 "NOT",
                 "EOF_TOKEN",
                 "SlComment",
                 "MlComment",
                 "ERROR_TOKEN"
             };

    public final static int numTokenKinds = orderedTerminalSymbols.length;
    public final static boolean isValidForParser = true;
}
