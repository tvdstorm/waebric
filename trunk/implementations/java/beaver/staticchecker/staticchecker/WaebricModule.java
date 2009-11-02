package staticchecker;

import java.io.*;

/**
 *
 * <p>Title: WaebricModule</p>
 * <p>Description: A Waebric Module is the highest level of a Waebric abstract syntax tree.
 * It contains the complete text of the input file. It is assumed that one input file contains at most
 * one module. A Waebric Module consists of multiple Module Elements. Elements can overlap.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: University of Amsterdam </p>
 * @author Aart van den Dolder
 * @version 1.0
 */
public class WaebricModule extends AbstractSyntaxTree {

  private WaebricSystem system;
  private ModuleElementList importList;
  private ModuleElementList functionList;
  private ModuleElementList callList;
  private StringList importedFunctionStringList;

  /**
   * Constructor
   * @param text the module text (an abstract syntax tree)
   */
  public WaebricModule(String text) {
    super(text, ModuleElementType.MODULE);
    system = new WaebricSystem();

    setImports();
    setFunctionDefs();
    setFunctionCalls();
    setImportedFunctionData();
  }

  /**
   * Sets the importList attribute (ArrayList of ModuleElements)
   */
  private void setImports() {
    importList = this.moduleElementList(ModuleElementType.IMPORT);
  }

  /**
   * Sets the functionList attribute (ArrayList of ModuleElements)
   */
  private void setFunctionDefs() {
    functionList = this.moduleElementList(ModuleElementType.DEF);
  }

  /**
   * Sets the callList attribute (ArrayList of ModuleElements)
   */
  private void setFunctionCalls() {
    callList = this.moduleElementList(ModuleElementType.CALL);
  }

  /**
   * Gets the importList attribute
   * @return importList
   */
  public ModuleElementList getImports() {
    return importList;
  }

  /**
   * Gets the functionList attribute
   * @return functionList
   */
  public ModuleElementList getFunctionDefs() {
    return functionList;
  }

  /**
   * Gets the callList attribute
   * @return callList
   */
  public ModuleElementList getFunctionCalls() {
    return callList;
  }

  /**
   * Gets all function calls that are not HTML function calls
   * @return the non-HTML function calls in this module
   */
  public ModuleElementList getNonHTMLFunctionCalls() {
    ModuleElementList outputCallList = new ModuleElementList();

    StringList htmlCallList = system.getHtmlElements();

    for (int callIndex = 0; callIndex < callList.size(); callIndex++) {
      String functionCall = callList.getIdentifier(callIndex);

      if (!htmlCallList.itemInList(functionCall)) {
        outputCallList.add(callList.get(callIndex));
      }
    }
    return outputCallList;
  }

  /**
   * Gets the formals of a given function (def)
   * @param functionIdentifier the function identifier.
   * @return the formals of this function.
   */
  public StringList getFunctionFormals(String functionIdentifier) {
    StringList functionFormalsList = new StringList();

    for (int functionIndex = 0; functionIndex < functionList.size(); functionIndex++) {
      ModuleElement functionElement = (ModuleElement) functionList.get(functionIndex);
      String identifier = functionElement.getIdentifier();

      if (functionIdentifier.equals(identifier)) {
        FunctionDef functionDef = new FunctionDef(functionElement.toString());
        functionFormalsList = functionDef.getFormals();
        break;
      }
    }
    return functionFormalsList;

  }

  /**
   * Sets the attribute importedFunctionStringList.
   * This method reads the content of all files that are listed by the import list.
   * The lines containing a function-def are extracted and put into the attribute.
   *
   * NOTE: this method works under the following assumptions:
   * - 1. every function def declaration starts on a new line
   * - 2. no function def declaration has been commented out
   */
  private void setImportedFunctionData() {
    importedFunctionStringList = new StringList();

    final String DEF_SPACE = "def ";
    final String SPACE_DEF = " def";
    final String SPACE_DEF_LPAREN = "def ";

    for (int importIndex = 0; importIndex < importList.size(); importIndex++) {
      String importedModule = importList.getIdentifier(importIndex);

      String importFileName = system.getWaebricDir() + system.getPathSeparator() + importedModule + system.getWaebricFileExtension();
      StringList linesOfCode = InputFile.textFileToList(importFileName);

      for (int lineIndex = 0; lineIndex < linesOfCode.size(); lineIndex++) {
        String line = linesOfCode.getStringValue(lineIndex);

        if ((line.indexOf(DEF_SPACE) == 0) || (line.indexOf(SPACE_DEF) > 0) || (line.indexOf(SPACE_DEF_LPAREN) > 0)) {
          importedFunctionStringList.add(line);
        }
      }

    }
  }

  /**
   * Extracts the function-def identifiers from the importedFunctionStringList attribute.
   * @return the list of function-def identifiers of all imported modules.
   */
  public StringList getImportedFunctions() {
    StringList functionDefList = new StringList();

    final String DEF_SPACE = "def ";
    final String SPACE_DEF = " def";
    final String LPAREN = "(";

    for (int defIndex = 0; defIndex < importedFunctionStringList.size(); defIndex++) {
      String functionDefString = importedFunctionStringList.getStringValue(defIndex);

      int defKeywordIndex = Math.max(functionDefString.indexOf(DEF_SPACE), functionDefString.indexOf(SPACE_DEF));
      int endIdentifierIndex = functionDefString.indexOf(LPAREN);

      String functionDef = new String();
      if (endIdentifierIndex > defKeywordIndex + DEF_SPACE.length()) {
        functionDef = functionDefString.substring(defKeywordIndex + DEF_SPACE.length(), endIdentifierIndex);
      }
      else {
        functionDef = functionDefString.substring(defKeywordIndex + DEF_SPACE.length());
      }

      functionDefList.add(functionDef.trim());

    }

    return functionDefList;
  }

  /**
   * Extracts the formals of a given imported function from the importedFunctionStringList attribute.
   * @param functionDef the imported function.
   * @return the formals of this function.
   */
  public StringList getImportedFunctionFormals(String functionDef) {
    StringList formalsList = new StringList();

    final String DEF_PREFIX = "def ";
    final char LPAREN = '(';
    final char RPAREN = ')';
    final char COMMA = ',';

    for (int defIndex = 0; defIndex < importedFunctionStringList.size(); defIndex++) {
      String functionDefString = importedFunctionStringList.getStringValue(defIndex);
      String searchString = new String();

      if (functionDefString.indexOf(DEF_PREFIX + functionDef) >= 0) {
        int startFormals = functionDefString.indexOf(LPAREN) + 1;
        int endFormals = functionDefString.indexOf(RPAREN);

        if (startFormals >= 0) {
          searchString = functionDefString.substring(startFormals, endFormals);

          String formal = new String();
          int endFormal = 0;
          do {
            endFormal = searchString.indexOf(COMMA);

            if (endFormal > 0) {
              formal = searchString.substring(0, endFormal);
              formalsList.add(formal.trim());
              searchString = searchString.substring(endFormal + 1);
            }
          }
          while (endFormal > 0);
          formalsList.add(searchString.trim());

        }
        break;
      }
    }
    return formalsList;
  }

}
