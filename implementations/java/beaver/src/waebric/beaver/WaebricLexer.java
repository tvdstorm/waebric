/* The following code was generated by JFlex 1.4.3 on 9/1/09 12:13 PM */

/* --------------------------Usercode Section------------------------ */
package waebric.beaver;

import beaver.Symbol;
import beaver.Scanner;

import waebric.beaver.WaebricParser.Terminals;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 9/1/09 12:13 PM from the specification file
 * <tt>/Users/tvdstorm/GLT/WaebricWorkspace/WaebricBeaver/src/waebric/waebric.flex</tt>
 */
public class WaebricLexer extends Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int POSTMIDTEXT = 12;
  public static final int DIRFILE = 14;
  public static final int ARGUMENTS = 16;
  public static final int PRETEXT = 10;
  public static final int STRCON_INIT = 8;
  public static final int STRING = 4;
  public static final int STRCON = 6;
  public static final int YYINITIAL = 0;
  public static final int SITE = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  1,  1,  2,  2,  3,  3,  4,  4,  5,  5,  6,  6, 
     1, 1
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\72\1\11\1\2\1\72\1\10\1\1\22\72\1\3\1\65\1\50"+
    "\1\15\1\70\1\61\1\12\1\71\1\52\1\53\1\5\1\63\1\13"+
    "\1\22\1\25\1\4\12\6\1\60\1\16\1\7\1\67\1\51\1\64"+
    "\1\62\6\20\24\23\1\56\1\24\1\57\1\0\1\21\1\0\1\40"+
    "\1\20\1\30\1\37\1\33\1\27\1\46\1\36\1\26\2\23\1\41"+
    "\1\32\1\34\1\31\1\43\1\23\1\44\1\45\1\35\1\42\2\23"+
    "\1\17\1\47\1\23\1\54\1\66\1\55\2\0\200\14\uff00\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\7\0\1\1\2\2\1\3\1\4\1\1\1\5\1\6"+
    "\1\7\1\10\1\11\11\10\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\1\1\30\1\31\1\32\1\33\1\1"+
    "\1\34\1\1\1\35\1\36\2\33\1\37\1\40\1\41"+
    "\1\42\1\2\1\43\1\42\7\43\1\44\1\2\1\0"+
    "\1\45\1\46\1\10\1\47\16\10\1\50\1\0\1\51"+
    "\1\52\1\53\1\54\2\0\1\55\1\0\1\56\2\0"+
    "\12\43\1\0\5\10\1\57\2\10\1\60\1\10\1\61"+
    "\4\10\4\0\1\62\5\43\1\63\2\43\4\10\1\64"+
    "\1\65\1\66\1\67\1\10\1\70\2\10\1\71\1\0"+
    "\4\43\2\10\1\72\3\10\1\73\1\43\1\74\1\10"+
    "\1\75\1\76\1\77\1\100";

  private static int [] zzUnpackAction() {
    int [] result = new int[172];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\73\0\166\0\261\0\354\0\u0127\0\u0162\0\u019d"+
    "\0\u01d8\0\u019d\0\u0213\0\u024e\0\u0289\0\u019d\0\u019d\0\u019d"+
    "\0\u02c4\0\u019d\0\u02ff\0\u033a\0\u0375\0\u03b0\0\u03eb\0\u0426"+
    "\0\u0461\0\u049c\0\u04d7\0\u019d\0\u019d\0\u019d\0\u019d\0\u019d"+
    "\0\u019d\0\u019d\0\u019d\0\u019d\0\u019d\0\u019d\0\u019d\0\u019d"+
    "\0\u019d\0\u0512\0\u019d\0\u019d\0\u054d\0\u019d\0\u0588\0\u019d"+
    "\0\u0213\0\u019d\0\u019d\0\u05c3\0\u05fe\0\u019d\0\u019d\0\u019d"+
    "\0\u0639\0\u0639\0\u0674\0\u019d\0\u06af\0\u06ea\0\u0725\0\u0760"+
    "\0\u079b\0\u07d6\0\u0811\0\u0639\0\u084c\0\u0887\0\u019d\0\u02c4"+
    "\0\u08c2\0\u02c4\0\u08fd\0\u0938\0\u0973\0\u09ae\0\u09e9\0\u0a24"+
    "\0\u0a5f\0\u0a9a\0\u0ad5\0\u0b10\0\u0b4b\0\u0b86\0\u0bc1\0\u0bfc"+
    "\0\u019d\0\u0c37\0\u019d\0\u019d\0\u019d\0\u019d\0\u0c72\0\u0cad"+
    "\0\u019d\0\u0639\0\u0ce8\0\u0d23\0\u0674\0\u0d5e\0\u0d99\0\u0dd4"+
    "\0\u0e0f\0\u0e4a\0\u0e85\0\u0ec0\0\u0efb\0\u0f36\0\u0f71\0\u0fac"+
    "\0\u0fe7\0\u1022\0\u105d\0\u1098\0\u10d3\0\u02c4\0\u110e\0\u1149"+
    "\0\u02c4\0\u1184\0\u02c4\0\u11bf\0\u11fa\0\u1235\0\u1270\0\u12ab"+
    "\0\u12e6\0\u1321\0\u135c\0\u0d23\0\u1397\0\u13d2\0\u140d\0\u1448"+
    "\0\u1483\0\u0674\0\u14be\0\u14f9\0\u1534\0\u156f\0\u15aa\0\u15e5"+
    "\0\u02c4\0\u02c4\0\u02c4\0\u02c4\0\u1620\0\u02c4\0\u165b\0\u1696"+
    "\0\u019d\0\u16d1\0\u170c\0\u1747\0\u1782\0\u17bd\0\u17f8\0\u1833"+
    "\0\u02c4\0\u186e\0\u18a9\0\u18e4\0\u02c4\0\u191f\0\u02c4\0\u195a"+
    "\0\u02c4\0\u02c4\0\u02c4\0\u02c4";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[172];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\10\1\11\2\12\1\13\1\10\1\14\1\10\2\12"+
    "\1\15\1\16\1\10\1\17\1\20\2\21\2\10\1\21"+
    "\1\10\1\22\1\23\1\21\1\24\1\21\1\25\1\26"+
    "\3\21\1\27\1\21\1\30\2\21\1\31\1\32\1\21"+
    "\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42"+
    "\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52"+
    "\1\53\1\54\1\55\74\10\1\56\2\10\5\56\2\10"+
    "\12\56\1\57\23\56\1\60\21\56\2\10\1\11\2\12"+
    "\1\61\3\10\2\12\36\10\1\62\22\10\7\56\1\63"+
    "\1\10\1\56\1\64\1\56\1\10\7\56\1\65\23\56"+
    "\1\66\21\56\1\10\7\56\1\67\1\10\1\56\1\64"+
    "\1\56\1\10\7\56\1\65\23\56\1\70\21\56\1\10"+
    "\1\71\1\11\2\12\1\13\3\71\1\72\1\12\5\71"+
    "\2\73\2\71\1\73\2\74\1\75\1\73\1\76\1\73"+
    "\1\77\1\100\3\73\1\101\1\73\1\102\3\73\1\103"+
    "\2\73\10\71\1\104\12\71\75\0\1\12\74\0\1\105"+
    "\1\106\73\0\1\14\76\0\1\107\66\0\1\21\10\0"+
    "\2\21\1\0\2\21\2\0\22\21\31\0\1\21\10\0"+
    "\2\21\1\0\2\21\2\0\1\21\1\110\2\21\1\111"+
    "\1\21\1\112\13\21\31\0\1\21\10\0\2\21\1\0"+
    "\2\21\2\0\3\21\1\113\5\21\1\114\10\21\31\0"+
    "\1\21\10\0\2\21\1\0\2\21\2\0\3\21\1\115"+
    "\16\21\31\0\1\21\10\0\2\21\1\0\2\21\2\0"+
    "\2\21\1\116\3\21\1\117\3\21\1\120\1\121\6\21"+
    "\31\0\1\21\10\0\2\21\1\0\2\21\2\0\5\21"+
    "\1\122\14\21\31\0\1\21\10\0\2\21\1\0\2\21"+
    "\2\0\1\123\4\21\1\124\14\21\31\0\1\21\10\0"+
    "\2\21\1\0\2\21\2\0\5\21\1\125\14\21\31\0"+
    "\1\21\10\0\2\21\1\0\2\21\2\0\1\126\6\21"+
    "\1\127\12\21\31\0\1\21\10\0\2\21\1\0\2\21"+
    "\2\0\1\130\21\21\111\0\1\131\4\0\1\55\3\0"+
    "\4\55\2\0\1\55\2\0\1\55\1\0\32\55\1\0"+
    "\1\55\1\0\16\55\7\0\1\132\15\0\1\133\7\0"+
    "\1\134\1\135\12\0\1\136\37\0\1\137\1\0\3\140"+
    "\1\0\1\140\2\0\22\140\10\0\1\140\12\0\2\141"+
    "\1\0\70\141\1\142\3\0\1\143\4\142\1\0\12\142"+
    "\1\0\1\144\46\142\3\0\1\143\1\142\1\73\2\142"+
    "\1\0\5\142\2\73\1\142\2\73\1\0\1\144\22\73"+
    "\24\142\3\0\1\143\1\142\1\73\2\142\1\0\5\142"+
    "\2\73\1\142\2\73\1\0\1\144\1\73\1\145\2\73"+
    "\1\146\15\73\24\142\3\0\1\143\1\142\1\73\2\142"+
    "\1\0\5\142\2\73\1\142\2\73\1\0\1\144\3\73"+
    "\1\147\5\73\1\150\10\73\24\142\3\0\1\143\1\142"+
    "\1\73\2\142\1\0\5\142\2\73\1\142\2\73\1\0"+
    "\1\144\3\73\1\151\16\73\24\142\3\0\1\143\1\142"+
    "\1\73\2\142\1\0\5\142\2\73\1\142\2\73\1\0"+
    "\1\144\2\73\1\152\3\73\1\153\3\73\1\154\7\73"+
    "\24\142\3\0\1\143\1\142\1\73\2\142\1\0\5\142"+
    "\2\73\1\142\2\73\1\0\1\144\5\73\1\155\14\73"+
    "\24\142\3\0\1\143\1\142\1\73\2\142\1\0\5\142"+
    "\2\73\1\142\2\73\1\0\1\144\5\73\1\156\14\73"+
    "\24\142\3\0\1\143\1\142\1\73\2\142\1\0\5\142"+
    "\2\73\1\142\2\73\1\0\1\144\1\157\21\73\23\142"+
    "\1\105\1\11\1\12\70\105\5\106\1\160\65\106\6\0"+
    "\1\21\10\0\2\21\1\0\2\21\2\0\15\21\1\161"+
    "\4\21\31\0\1\21\10\0\2\21\1\0\2\21\2\0"+
    "\4\21\1\162\15\21\31\0\1\21\10\0\2\21\1\0"+
    "\2\21\2\0\12\21\1\163\7\21\31\0\1\21\10\0"+
    "\2\21\1\0\2\21\2\0\11\21\1\164\10\21\31\0"+
    "\1\21\10\0\2\21\1\0\2\21\2\0\10\21\1\165"+
    "\11\21\31\0\1\21\10\0\2\21\1\0\2\21\2\0"+
    "\11\21\1\166\10\21\31\0\1\21\10\0\2\21\1\0"+
    "\2\21\2\0\2\21\1\167\17\21\31\0\1\21\10\0"+
    "\2\21\1\0\2\21\2\0\17\21\1\170\2\21\31\0"+
    "\1\21\10\0\2\21\1\0\2\21\2\0\1\21\1\171"+
    "\20\21\31\0\1\21\10\0\2\21\1\0\2\21\2\0"+
    "\17\21\1\172\2\21\31\0\1\21\10\0\2\21\1\0"+
    "\2\21\2\0\7\21\1\173\12\21\31\0\1\21\10\0"+
    "\2\21\1\0\2\21\2\0\2\21\1\174\17\21\31\0"+
    "\1\21\10\0\2\21\1\0\2\21\2\0\7\21\1\175"+
    "\12\21\31\0\1\21\10\0\2\21\1\0\2\21\2\0"+
    "\16\21\1\176\3\21\31\0\1\21\10\0\2\21\1\0"+
    "\2\21\2\0\5\21\1\177\14\21\31\0\1\200\72\0"+
    "\1\201\10\0\1\202\61\0\1\140\7\0\1\56\5\140"+
    "\1\0\23\140\10\0\1\140\12\0\1\203\4\0\4\203"+
    "\1\0\12\203\2\0\45\203\6\0\1\204\10\0\2\204"+
    "\2\0\1\204\2\0\22\204\23\0\1\142\3\0\1\143"+
    "\1\142\1\73\2\142\1\0\5\142\2\73\1\142\2\73"+
    "\1\0\1\144\15\73\1\205\4\73\24\142\3\0\1\143"+
    "\1\142\1\73\2\142\1\0\5\142\2\73\1\142\2\73"+
    "\1\0\1\144\4\73\1\206\15\73\24\142\3\0\1\143"+
    "\1\142\1\73\2\142\1\0\5\142\2\73\1\142\2\73"+
    "\1\0\1\144\12\73\1\207\7\73\24\142\3\0\1\143"+
    "\1\142\1\73\2\142\1\0\5\142\2\73\1\142\2\73"+
    "\1\0\1\144\11\73\1\210\10\73\24\142\3\0\1\143"+
    "\1\142\1\73\2\142\1\0\5\142\2\73\1\142\2\73"+
    "\1\0\1\144\10\73\1\211\11\73\24\142\3\0\1\143"+
    "\1\142\1\73\2\142\1\0\5\142\2\73\1\142\2\73"+
    "\1\0\1\144\11\73\1\212\10\73\24\142\3\0\1\143"+
    "\1\142\1\73\2\142\1\0\5\142\2\73\1\142\2\73"+
    "\1\0\1\144\2\73\1\213\17\73\24\142\3\0\1\143"+
    "\1\142\1\73\2\142\1\0\5\142\2\73\1\142\2\73"+
    "\1\0\1\144\1\73\1\145\20\73\24\142\3\0\1\143"+
    "\1\142\1\73\2\142\1\0\5\142\2\73\1\142\2\73"+
    "\1\0\1\144\7\73\1\145\12\73\24\142\3\0\1\143"+
    "\1\142\1\73\2\142\1\0\5\142\2\73\1\142\2\73"+
    "\1\0\1\144\7\73\1\214\12\73\23\142\4\106\1\12"+
    "\1\160\65\106\6\0\1\21\10\0\2\21\1\0\2\21"+
    "\2\0\3\21\1\215\16\21\31\0\1\21\10\0\2\21"+
    "\1\0\2\21\2\0\4\21\1\216\15\21\31\0\1\21"+
    "\10\0\2\21\1\0\2\21\2\0\7\21\1\217\12\21"+
    "\31\0\1\21\10\0\2\21\1\0\2\21\2\0\14\21"+
    "\1\220\5\21\31\0\1\21\10\0\2\21\1\0\2\21"+
    "\2\0\3\21\1\221\16\21\31\0\1\21\10\0\2\21"+
    "\1\0\2\21\2\0\10\21\1\222\11\21\31\0\1\21"+
    "\10\0\2\21\1\0\2\21\2\0\5\21\1\223\14\21"+
    "\31\0\1\21\10\0\2\21\1\0\2\21\2\0\7\21"+
    "\1\224\12\21\31\0\1\21\10\0\2\21\1\0\2\21"+
    "\2\0\3\21\1\225\16\21\31\0\1\21\10\0\2\21"+
    "\1\0\2\21\2\0\5\21\1\226\14\21\31\0\1\21"+
    "\10\0\2\21\1\0\2\21\2\0\1\227\21\21\31\0"+
    "\1\21\10\0\2\21\1\0\2\21\2\0\13\21\1\230"+
    "\6\21\31\0\1\231\72\0\1\201\7\0\1\56\62\0"+
    "\1\232\11\0\1\232\6\0\2\232\2\0\1\232\3\0"+
    "\2\232\32\0\1\203\3\0\1\143\4\203\1\0\12\203"+
    "\2\0\45\203\1\142\3\0\1\143\1\142\1\73\2\142"+
    "\1\0\5\142\2\73\1\142\2\73\1\0\1\144\3\73"+
    "\1\233\16\73\24\142\3\0\1\143\1\142\1\73\2\142"+
    "\1\0\5\142\2\73\1\142\2\73\1\0\1\144\4\73"+
    "\1\234\15\73\24\142\3\0\1\143\1\142\1\73\2\142"+
    "\1\0\5\142\2\73\1\142\2\73\1\0\1\144\7\73"+
    "\1\235\12\73\24\142\3\0\1\143\1\142\1\73\2\142"+
    "\1\0\5\142\2\73\1\142\2\73\1\0\1\144\14\73"+
    "\1\236\5\73\24\142\3\0\1\143\1\142\1\73\2\142"+
    "\1\0\5\142\2\73\1\142\2\73\1\0\1\144\3\73"+
    "\1\145\16\73\24\142\3\0\1\143\1\142\1\73\2\142"+
    "\1\0\5\142\2\73\1\142\2\73\1\0\1\144\10\73"+
    "\1\145\11\73\24\142\3\0\1\143\1\142\1\73\2\142"+
    "\1\0\5\142\2\73\1\142\2\73\1\0\1\144\5\73"+
    "\1\145\14\73\23\142\6\0\1\21\10\0\2\21\1\0"+
    "\2\21\2\0\16\21\1\237\3\21\31\0\1\21\10\0"+
    "\2\21\1\0\2\21\2\0\5\21\1\240\14\21\31\0"+
    "\1\21\10\0\2\21\1\0\2\21\2\0\12\21\1\241"+
    "\7\21\31\0\1\21\10\0\2\21\1\0\2\21\2\0"+
    "\13\21\1\242\6\21\31\0\1\21\10\0\2\21\1\0"+
    "\2\21\2\0\16\21\1\243\3\21\31\0\1\21\10\0"+
    "\2\21\1\0\2\21\2\0\6\21\1\244\13\21\31\0"+
    "\1\21\10\0\2\21\1\0\2\21\2\0\11\21\1\245"+
    "\10\21\31\0\1\232\7\0\1\56\1\0\1\232\6\0"+
    "\2\232\2\0\1\232\3\0\2\232\32\0\1\142\3\0"+
    "\1\143\1\142\1\73\2\142\1\0\5\142\2\73\1\142"+
    "\2\73\1\0\1\144\16\73\1\156\3\73\24\142\3\0"+
    "\1\143\1\142\1\73\2\142\1\0\5\142\2\73\1\142"+
    "\2\73\1\0\1\144\5\73\1\246\14\73\24\142\3\0"+
    "\1\143\1\142\1\73\2\142\1\0\5\142\2\73\1\142"+
    "\2\73\1\0\1\144\12\73\1\145\7\73\24\142\3\0"+
    "\1\143\1\142\1\73\2\142\1\0\5\142\2\73\1\142"+
    "\2\73\1\0\1\144\13\73\1\214\6\73\23\142\6\0"+
    "\1\21\10\0\2\21\1\0\2\21\2\0\7\21\1\247"+
    "\12\21\31\0\1\21\10\0\2\21\1\0\2\21\2\0"+
    "\6\21\1\250\13\21\31\0\1\21\10\0\2\21\1\0"+
    "\2\21\2\0\5\21\1\251\14\21\31\0\1\21\10\0"+
    "\2\21\1\0\2\21\2\0\11\21\1\252\10\21\31\0"+
    "\1\21\10\0\2\21\1\0\2\21\2\0\20\21\1\253"+
    "\1\21\23\0\1\142\3\0\1\143\1\142\1\73\2\142"+
    "\1\0\5\142\2\73\1\142\2\73\1\0\1\144\6\73"+
    "\1\156\13\73\23\142\6\0\1\21\10\0\2\21\1\0"+
    "\2\21\2\0\7\21\1\254\12\21\23\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[6549];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\7\0\1\11\1\1\1\11\3\1\3\11\1\1\1\11"+
    "\11\1\16\11\1\1\2\11\1\1\1\11\1\1\1\11"+
    "\1\1\2\11\2\1\3\11\3\1\1\11\11\1\1\0"+
    "\1\11\21\1\1\11\1\0\4\11\2\0\1\11\1\0"+
    "\1\1\2\0\12\1\1\0\17\1\4\0\25\1\1\11"+
    "\1\0\22\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[172];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
	boolean bSITE=false;
	StringBuffer string = new StringBuffer(128);
	private Symbol nextToken(short id)
	{
		return new Symbol(id, yyline + 1, yycolumn + 1, yylength());
	}

	private Symbol nextToken(short id, Object value)
	{
		return new Symbol(id, yyline + 1, yycolumn + 1, yylength(), value);
	}
	
	private void Debug(String text)
	{
		//System.out.println(text);//commentariseer deze regel uit in productie
	}


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public WaebricLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  WaebricLexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 138) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Symbol nextToken() throws java.io.IOException, Scanner.Exception {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 2: 
          { /* ignore */
          }
        case 65: break;
        case 8: 
          { Debug("IDCON " + yytext() ); return nextToken(Terminals.IDCON, yytext());
          }
        case 66: break;
        case 24: 
          { Debug("EQ");return nextToken(Terminals.EQ);
          }
        case 67: break;
        case 31: 
          { Debug("TEXT " + string + yytext() ); yybegin(YYINITIAL); string.append(  yytext() );  return nextToken(Terminals.TEXT,  string.toString() );
          }
        case 68: break;
        case 36: 
          { Debug("COLON "); return nextToken(Terminals.COLON);
          }
        case 69: break;
        case 7: 
          { Debug("SEMICOLON"); if(bSITE){ yybegin(DIRFILE); } return nextToken(Terminals.SEMICOLON);
          }
        case 70: break;
        case 28: 
          { Debug("STRCON " /*+ string.toString()*/ ); yybegin(YYINITIAL); return nextToken(Terminals.STRCON, string.toString() );
          }
        case 71: break;
        case 15: 
          { Debug("RBRACE"); return nextToken(Terminals.RBRACE);
          }
        case 72: break;
        case 45: 
          { string.append( "\\" + yytext() );
          }
        case 73: break;
        case 10: 
          { string.setLength(0); string.append( '\"' ); yybegin(PRETEXT);
          }
        case 74: break;
        case 52: 
          { Debug("ECHO"); return nextToken(Terminals.ECHO);
          }
        case 75: break;
        case 18: 
          { Debug("COLON"); return nextToken(Terminals.COLON);
          }
        case 76: break;
        case 49: 
          { Debug("LET"); return nextToken(Terminals.LET);
          }
        case 77: break;
        case 30: 
          { Debug("PRETEXT " + string+ yytext() ); yybegin(YYINITIAL); string.append(  yytext()  );  return nextToken(Terminals.PRETEXT, string.toString() );
          }
        case 78: break;
        case 43: 
          { string.append( '\t' );
          }
        case 79: break;
        case 19: 
          { Debug("MOD"); return nextToken(Terminals.MOD);
          }
        case 80: break;
        case 21: 
          { Debug("PLUS"); return nextToken(Terminals.PLUS);
          }
        case 81: break;
        case 64: 
          { Debug("COMMENT"); string.setLength(0); yybegin(STRCON_INIT);  return nextToken(Terminals.COMMENT);
          }
        case 82: break;
        case 13: 
          { Debug("RPAREN"); return nextToken(Terminals.RPAREN);
          }
        case 83: break;
        case 62: 
          { Debug("RECORD");  return nextToken(Terminals.RECORD);
          }
        case 84: break;
        case 39: 
          { Debug("IN");  return nextToken(Terminals.IN);
          }
        case 85: break;
        case 61: 
          { Debug("MODULE"); return nextToken(Terminals.MODULE);
          }
        case 86: break;
        case 60: 
          { Debug("IMPORT"); return nextToken(Terminals.IMPORT);
          }
        case 87: break;
        case 55: 
          { Debug("LIST");  return nextToken(Terminals.LIST);
          }
        case 88: break;
        case 53: 
          { Debug("EACH"); return nextToken(Terminals.EACH);
          }
        case 89: break;
        case 51: 
          { Debug("PushBackDirfile:" + yytext() ); yybegin(YYINITIAL); yypushback(3);
          }
        case 90: break;
        case 23: 
          { Debug("NOT"); return nextToken(Terminals.NOT);
          }
        case 91: break;
        case 16: 
          { Debug("LBRACK"); return nextToken(Terminals.LBRACK);
          }
        case 92: break;
        case 47: 
          { bSITE=false;
  									 Debug("END");
                                     return nextToken(Terminals.END);
          }
        case 93: break;
        case 5: 
          { Debug("COMMA"); return nextToken(Terminals.COMMA);
          }
        case 94: break;
        case 38: 
          { Debug("IF");   return nextToken(Terminals.IF);
          }
        case 95: break;
        case 33: 
          { Debug("POSTTEXT " + string + yytext() );  yybegin(YYINITIAL);  string.append( '\"' );  return nextToken(Terminals.POSTTEXT, string.toString() );
          }
        case 96: break;
        case 48: 
          { Debug("DEF"); return nextToken(Terminals.DEF);
          }
        case 97: break;
        case 11: 
          { string.setLength(0);string.append( '>' ); yybegin(POSTMIDTEXT);
          }
        case 98: break;
        case 50: 
          { Debug("FILENAME " + yytext() ); return nextToken(Terminals.FILENAME, yytext());
          }
        case 99: break;
        case 46: 
          // lookahead expression with fixed lookahead length
          yypushback(1);
          { Debug("DIRNAME " + yytext() ); return nextToken(Terminals.DIRNAME, yytext());
          }
        case 100: break;
        case 25: 
          { Debug("DOLLAR"); return nextToken(Terminals.DOLLAR);
          }
        case 101: break;
        case 9: 
          { Debug("DOT"); return nextToken(Terminals.DOT);
          }
        case 102: break;
        case 34: 
          { Debug("PushBackDirfile:" + yytext() ); yybegin(YYINITIAL); yypushback(1);
          }
        case 103: break;
        case 20: 
          { Debug("ADDCHAR"); return nextToken(Terminals.ADDCHAR);
          }
        case 104: break;
        case 59: 
          { Debug("YIELD"); return nextToken(Terminals.YIELD);
          }
        case 105: break;
        case 14: 
          { Debug("LBRACE"); return nextToken(Terminals.LBRACE);
          }
        case 106: break;
        case 44: 
          { string.append( '\"' );
          }
        case 107: break;
        case 58: 
          { Debug("CDATA"); return nextToken(Terminals.CDATA);
          }
        case 108: break;
        case 40: 
          { Debug("OROR"); return nextToken(Terminals.OROR);
          }
        case 109: break;
        case 3: 
          { Debug("DIV"); return nextToken(Terminals.DIV);
          }
        case 110: break;
        case 6: 
          { Debug("HASH"); return nextToken(Terminals.HASH);
          }
        case 111: break;
        case 63: 
          { Debug("STRING");  return nextToken(Terminals.STRING);
          }
        case 112: break;
        case 26: 
          { Debug("SYMBOLCON " + yytext()); return nextToken(Terminals.SYMBOLCON, yytext() );
          }
        case 113: break;
        case 12: 
          { Debug("LPAREN"); return nextToken(Terminals.LPAREN);
          }
        case 114: break;
        case 41: 
          { string.append( '\\' );
          }
        case 115: break;
        case 17: 
          { Debug("RBRACK"); return nextToken(Terminals.RBRACK);
          }
        case 116: break;
        case 35: 
          { Debug("DIRFILE IDCON " + yytext() ); return nextToken(Terminals.IDCON, yytext() );
          }
        case 117: break;
        case 4: 
          { Debug("NATCON " + yytext() ); return nextToken(Terminals.NATCON, yytext());
          }
        case 118: break;
        case 54: 
          { Debug("ELSE");   return nextToken(Terminals.ELSE);
          }
        case 119: break;
        case 1: 
          { throw new Scanner.Exception("Illegal character <"+yytext()+">");
          }
        case 120: break;
        case 56: 
          { Debug("SITE"); bSITE=true; yybegin(DIRFILE); return nextToken(Terminals.SITE);
          }
        case 121: break;
        case 32: 
          { Debug("MIDTEXT " + string + yytext());  yybegin(YYINITIAL);  string.append( yytext());  return nextToken(Terminals.MIDTEXT,  string.toString() );
          }
        case 122: break;
        case 42: 
          { string.append( '\n' );
          }
        case 123: break;
        case 22: 
          { Debug("QUESTION"); return nextToken(Terminals.QUESTION);
          }
        case 124: break;
        case 29: 
          { yybegin(STRCON);
          }
        case 125: break;
        case 57: 
          { String temp = yytext(); string.append( temp.substring(1) );
          }
        case 126: break;
        case 27: 
          { string.append( yytext() );
          }
        case 127: break;
        case 37: 
          { Debug("ANDAND"); return nextToken(Terminals.ANDAND);
          }
        case 128: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
              { 	return nextToken(Terminals.EOF, "end-of-file");
 }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
