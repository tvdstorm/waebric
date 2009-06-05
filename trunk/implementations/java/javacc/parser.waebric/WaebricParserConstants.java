/* Generated By:JJTree&JavaCC: Do not edit this line. WaebricParserConstants.java */

/** 
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
@SuppressWarnings("all")
public interface WaebricParserConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int MODULE = 7;
  /** RegularExpression Id. */
  int IMPORT = 8;
  /** RegularExpression Id. */
  int SITE = 9;
  /** RegularExpression Id. */
  int END = 10;
  /** RegularExpression Id. */
  int DEF = 11;
  /** RegularExpression Id. */
  int IF = 12;
  /** RegularExpression Id. */
  int ELSE = 13;
  /** RegularExpression Id. */
  int EACH = 14;
  /** RegularExpression Id. */
  int LET = 15;
  /** RegularExpression Id. */
  int IN = 16;
  /** RegularExpression Id. */
  int YIELD = 17;
  /** RegularExpression Id. */
  int COMMENT = 18;
  /** RegularExpression Id. */
  int ECHO = 19;
  /** RegularExpression Id. */
  int CDATA = 20;
  /** RegularExpression Id. */
  int LIST = 21;
  /** RegularExpression Id. */
  int RECORD = 22;
  /** RegularExpression Id. */
  int STRING = 23;
  /** RegularExpression Id. */
  int LPAREN = 24;
  /** RegularExpression Id. */
  int RPAREN = 25;
  /** RegularExpression Id. */
  int LBRACKET = 26;
  /** RegularExpression Id. */
  int RBRACKET = 27;
  /** RegularExpression Id. */
  int LBRACE = 28;
  /** RegularExpression Id. */
  int RBRACE = 29;
  /** RegularExpression Id. */
  int SEMICOLON = 30;
  /** RegularExpression Id. */
  int COLON = 31;
  /** RegularExpression Id. */
  int COMMA = 32;
  /** RegularExpression Id. */
  int DOT = 33;
  /** RegularExpression Id. */
  int DOLLAR_SIGN = 34;
  /** RegularExpression Id. */
  int NUMBER_SIGN = 35;
  /** RegularExpression Id. */
  int ASSIGN = 36;
  /** RegularExpression Id. */
  int AT = 37;
  /** RegularExpression Id. */
  int QUESTIONMARK = 38;
  /** RegularExpression Id. */
  int EXCLAMATION = 39;
  /** RegularExpression Id. */
  int PERCENT = 40;
  /** RegularExpression Id. */
  int ModuleId = 41;
  /** RegularExpression Id. */
  int PathElement = 42;
  /** RegularExpression Id. */
  int FileName = 43;
  /** RegularExpression Id. */
  int FileExt = 44;
  /** RegularExpression Id. */
  int DirName = 45;
  /** RegularExpression Id. */
  int Directory = 46;
  /** RegularExpression Id. */
  int IdCon = 47;
  /** RegularExpression Id. */
  int NatCon = 48;
  /** RegularExpression Id. */
  int SymbolCon = 49;
  /** RegularExpression Id. */
  int SymbolChar = 50;
  /** RegularExpression Id. */
  int Text = 51;
  /** RegularExpression Id. */
  int TextChar = 52;
  /** RegularExpression Id. */
  int TextCharRef = 53;
  /** RegularExpression Id. */
  int EscQuote = 54;
  /** RegularExpression Id. */
  int Amp = 55;
  /** RegularExpression Id. */
  int TextEntityRef = 56;
  /** RegularExpression Id. */
  int StrCon = 57;
  /** RegularExpression Id. */
  int StrChar = 58;
  /** RegularExpression Id. */
  int Type = 59;
  /** RegularExpression Id. */
  int PreText = 60;
  /** RegularExpression Id. */
  int PostText = 61;
  /** RegularExpression Id. */
  int MidText = 62;

  /** Lexical state. */
  int IN_STRCON = 0;
  /** Lexical state. */
  int IN_NO_IDCON = 1;
  /** Lexical state. */
  int IN_PATH = 2;
  /** Lexical state. */
  int IN_NO_MODULEID = 3;
  /** Lexical state. */
  int DEFAULT = 4;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\t\"",
    "\"\\n\"",
    "\"\\r\"",
    "<token of kind 5>",
    "<token of kind 6>",
    "\"module\"",
    "\"import\"",
    "\"site\"",
    "\"end\"",
    "\"def\"",
    "\"if\"",
    "\"else\"",
    "\"each\"",
    "\"let\"",
    "\"in\"",
    "\"yield\"",
    "\"comment\"",
    "\"echo\"",
    "\"cdata\"",
    "\"list\"",
    "\"record\"",
    "\"string\"",
    "\"(\"",
    "\")\"",
    "\"[\"",
    "\"]\"",
    "\"{\"",
    "\"}\"",
    "\";\"",
    "\":\"",
    "\",\"",
    "\".\"",
    "\"$\"",
    "\"#\"",
    "\"=\"",
    "\"@\"",
    "\"?\"",
    "\"!\"",
    "\"%\"",
    "<ModuleId>",
    "<PathElement>",
    "<FileName>",
    "<FileExt>",
    "<DirName>",
    "<Directory>",
    "<IdCon>",
    "<NatCon>",
    "<SymbolCon>",
    "<SymbolChar>",
    "<Text>",
    "<TextChar>",
    "<TextCharRef>",
    "<EscQuote>",
    "<Amp>",
    "<TextEntityRef>",
    "<StrCon>",
    "<StrChar>",
    "<Type>",
    "<PreText>",
    "<PostText>",
    "<MidText>",
  };

}
