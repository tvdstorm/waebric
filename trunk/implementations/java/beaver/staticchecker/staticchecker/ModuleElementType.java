package staticchecker;

/**
 *
 * <p>Title: ModuleElementType</p>
 * <p>Description: This class simulates a Java enumerator (not supported by jdk 1.4).
 * For later Java versions this class can be replaced by an enum construct. </p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: University of Amsterdam</p>
 * @author Aart van den Dolder
 * @version 1.0
 */
public class ModuleElementType {

  private static final int MODULE_ID = 1;
  private static final int IMPORT_ID = 2;
  private static final int DEF_ID = 3;
  private static final int FORMALS_ID = 4;
  private static final int VAR_ID = 5;
  private static final int VAR_BIND_ID = 6;
  private static final int LET_ID = 7;
  private static final int EACH_ID = 8;
  private static final int CALL_ID = 9;
  private static final int ARGS_ID = 10;

  private static final String[] moduleData   = {"module"   , "<null>"              , "<null>"};
  private static final String[] importData   = {"import"   , "import(module-id([\"", "\"]))"};
  private static final String[] defData      = {"def"      , "def(\""              , "\""};
  private static final String[] formalsData  = {"formals"  , "formals([\""         , "\"])"};
  private static final String[] varData      = {"var"      , "var(\""              , "\")"};
  private static final String[] varBindData  = {"var-bind" , "var-bind(\""         , "\","};
  private static final String[] letData      = {"let"      , "<null>"              , "<null>"};
  private static final String[] eachData     = {"each"     , "each(\""             , "\","};
  private static final String[] callData     = {"call"     , "call(tag(\""         , "\","};
  private static final String[] argsData     = {"args"     , "args(["              , "])"};

  public static final ModuleElementType MODULE = new ModuleElementType(MODULE_ID);
  public static final ModuleElementType IMPORT = new ModuleElementType(IMPORT_ID);
  public static final ModuleElementType DEF = new ModuleElementType(DEF_ID);
  public static final ModuleElementType FORMALS = new ModuleElementType(FORMALS_ID);
  public static final ModuleElementType VAR = new ModuleElementType(VAR_ID);
  public static final ModuleElementType VAR_BIND = new ModuleElementType(VAR_BIND_ID);
  public static final ModuleElementType LET = new ModuleElementType(LET_ID);
  public static final ModuleElementType EACH = new ModuleElementType(EACH_ID);
  public static final ModuleElementType CALL = new ModuleElementType(CALL_ID);
  public static final ModuleElementType ARGS = new ModuleElementType(ARGS_ID);

  private int typeId;
  private String keyword;
  private String identifierPrefix;
  private String identifierSuffix;

  /**
   * Constructor
   * @param type the integer representation of a ModuleElementType
   */
  private ModuleElementType(int type) {
    this.typeId = type;

    setKeyword();
    setIdentifierPrefix();
    setIdentifierSuffix();
  }

  /**
   * Sets the keyword attribute.
   */
  private void setKeyword() {
    switch(typeId) {
      case MODULE_ID:
        keyword = moduleData[0];
        break;
      case IMPORT_ID:
        keyword = importData[0];
        break;
      case DEF_ID:
        keyword = defData[0];
        break;
      case FORMALS_ID:
        keyword = formalsData[0];
        break;
      case VAR_ID:
        keyword = varData[0];
        break;
      case VAR_BIND_ID:
        keyword = varBindData[0];
        break;
      case LET_ID:
        keyword = letData[0];
        break;
      case EACH_ID:
        keyword = eachData[0];
        break;
      case CALL_ID:
        keyword = callData[0];
        break;
      case ARGS_ID:
        keyword = argsData[0];
    }
  }

  /**
   * Sets the identifierPrefix attribute.
   */
  private void setIdentifierPrefix() {
    switch(typeId) {
      case MODULE_ID:
        identifierPrefix = moduleData[1];
        break;
      case IMPORT_ID:
        identifierPrefix = importData[1];
        break;
      case DEF_ID:
        identifierPrefix = defData[1];
        break;
      case FORMALS_ID:
        identifierPrefix = formalsData[1];
        break;
      case VAR_ID:
        identifierPrefix = varData[1];
        break;
      case VAR_BIND_ID:
        identifierPrefix = varBindData[1];
        break;
      case LET_ID:
        identifierPrefix = letData[1];
        break;
      case EACH_ID:
        identifierPrefix = eachData[1];
        break;
      case CALL_ID:
        identifierPrefix = callData[1];
        break;
      case ARGS_ID:
        identifierPrefix = argsData[1];
    }
  }

  /**
   * Sets the IdentifierSuffix attribute.
   */
  private void setIdentifierSuffix() {
    switch(typeId) {
      case MODULE_ID:
        identifierSuffix = moduleData[2];
        break;
      case IMPORT_ID:
        identifierSuffix = importData[2];
        break;
      case DEF_ID:
        identifierSuffix = defData[2];
        break;
      case FORMALS_ID:
        identifierSuffix = formalsData[2];
        break;
      case VAR_ID:
        identifierSuffix = varData[2];
        break;
      case VAR_BIND_ID:
        identifierSuffix = varBindData[2];
        break;
      case LET_ID:
        identifierSuffix = letData[2];
        break;
      case EACH_ID:
        identifierSuffix = eachData[2];
        break;
      case CALL_ID:
        identifierSuffix = callData[2];
        break;
      case ARGS_ID:
        identifierSuffix = argsData[2];
    }
  }

  /**
   * Gets the keyword attribute
   * @return the keyword attribute
   */
  public String keyword() {
    return keyword;
  }

  /**
   * Gets the identifierPrefix attribute
   * @return the identifierPrefix attribute
   */
  public String prefix() {
    return identifierPrefix;
  }

  /**
   * Gest the identifierSuffix attribute
   * @return the identifierSuffix attribute
   */
  public String suffix() {
    return identifierSuffix;
  }

}
