package staticchecker;

import java.io.*;

/**
 *
 * <p>Title: StaticSyntaxChecker</p>
 * <p>Description: Main class of the Waebric static checker. Performs all required checks.
 * See paragraph 3 of {@link http://waebric.googlecode.com/svn/trunk/doc/waebric.pdf}</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: University of Amsterdam</p>
 * @author Aart van den Dolder
 * @version 1.0
 */
class StaticSyntaxChecker {

  private WaebricModule moduleTree;
  private WaebricSystem system;
  private StringList nonExistingModuleList;
  private StringList undefinedFunctionList;

  /**
   * Constructor
   * @param text the module text to be checked
   */
  public StaticSyntaxChecker(String text) {
    system = new WaebricSystem();
    moduleTree = new WaebricModule(text);
    nonExistingModuleList = new StringList();
    undefinedFunctionList = new StringList();
  }

  /**
   * Gets the text from the Waebric module
   * @return the module text
   */
  private String getModuleText(){
    return moduleTree.toString();
  }

  /**
   * Reports the imports that not exist in the Waebric module directory.
   * If a module is not found the import subtree it is removed from the module abstract syntax tree.
   */
  private void checkNonExistingModules() {
    String moduleText = moduleTree.toString();

    ModuleElementList importList = moduleTree.moduleElementList(ModuleElementType.IMPORT);
    StringList moduleList = system.getModuleList();

    for (int importIndex = 0; importIndex < importList.size(); importIndex++) {
      String importedModule = importList.getIdentifier(importIndex);

      boolean moduleFound = moduleList.itemInList(importedModule);

      if (!moduleFound) {
        nonExistingModuleList.add(importedModule);
        System.out.println("Error: Imported module not found: " + importedModule);

        // remove unknown import from the module text, separator included
        String importString = importList.getStringValue(importIndex);
        moduleText = moduleText.replace(importString.toString() + ", ","");
        moduleText = moduleText.replace(importString.toString() + "," ,"");
        moduleText = moduleText.replace(importString.toString()       ,"");

        moduleTree = new WaebricModule(moduleText);
      }
    }

  }

  /**
   * Reports the function def declarations that are not unique.
   */
  private void checkDuplicateDefinitions() {
    ModuleElementList functionList = moduleTree.moduleElementList(ModuleElementType.DEF);

    for (int functionIndex = 0; functionIndex < functionList.size(); functionIndex++) {
      String functionName1 = functionList.getIdentifier(functionIndex);

      // check if a function with the same name occurs in the remainder of the function list
      for (int remainderIndex = functionIndex + 1; remainderIndex < functionList.size(); remainderIndex++) {
        String functionName2 = functionList.getIdentifier(remainderIndex);

        boolean duplicateFound = functionName2.equals(functionName1);

        if (duplicateFound) {
          System.out.println("Error: Not allowed - more than one definition of function: " + functionName1);
        }
      }
    }

  }

  /**
   * Reports the variables that are used but not declared within a function def, a let statement or an
   * each statement.
   */
  private void checkUndfinedVariables() {
    // all function defs are checked
    ModuleElementList functionDefList = moduleTree.moduleElementList(ModuleElementType.DEF);

    for (int functionDefIndex = 0; functionDefIndex < functionDefList.size(); functionDefIndex++) {
      String functionDefString = functionDefList.getStringValue(functionDefIndex);
      FunctionDef functionDef = new FunctionDef(functionDefString);

      StringList formalsList = functionDef.getFormals();

      // all let statements within this function def are checked
      ModuleElementList letList = functionDef.moduleElementList(ModuleElementType.LET);

      for (int letIndex = 0; letIndex < letList.size(); letIndex++) {
        String letElementString = letList.getStringValue(letIndex);
        Statement letStatement = new Statement(letElementString,ModuleElementType.LET);

        StringList letFormalsList = letStatement.getFormals();
        StringList letVarDecList = letStatement.getVariableDeclaratations();
        StringList letVarList = letStatement.getVariables();

        for (int letVarIndex = 0; letVarIndex < letVarList.size(); letVarIndex++) {
          String letVar = letVarList.getStringValue(letVarIndex);

          boolean letFormalFound = letFormalsList.itemInList(letVar);
          boolean letVarDecFound = letVarDecList.itemInList(letVar);
          boolean formalFound = formalsList.itemInList(letVar);

          if (!letFormalFound && !letVarDecFound && !formalFound) {
            System.out.println("Error: Undefined variable in let-statement: " + letVar);
          }
        }
      }

      // all each statements within this function def are checked
      ModuleElementList eachList = functionDef.moduleElementList(ModuleElementType.EACH);

      for (int eachIndex = 0; eachIndex < eachList.size(); eachIndex++) {
        String eachElementString = eachList.getStringValue(eachIndex);
        Statement eachStatement = new Statement(eachElementString,ModuleElementType.EACH);

        StringList eachVarDecList = eachStatement.getVariableDeclaratations();
        StringList eachVarList = eachStatement.getVariables();

        for (int eachVarIndex = 0; eachVarIndex < eachVarList.size(); eachVarIndex++) {
          String eachVar = eachVarList.getStringValue(eachVarIndex);

          boolean eachVarDecFound = eachVarDecList.itemInList(eachVar);
          boolean formalFound = formalsList.itemInList(eachVar);

          if (!eachVarDecFound && !formalFound) {
            System.out.println("Error: Undefined variable in each-statement: " + eachVar);
          }
        }
      }

      // all variables outside let and each statements are checked
      StringList varList = functionDef.getVariables();
      for (int varIndex = 0; varIndex < varList.size(); varIndex++) {
        String var = varList.getStringValue(varIndex);

        boolean formalFound = formalsList.itemInList(var);

        if (!formalFound) {
          System.out.println("Error: Undefined variable: " + var);
        }
      }
    }

  }

  /**
   * Reports all function calls that are not declared within this module and
   * within imported modules. HTML function calls are checked too.
   */
  private void checkUndefinedFunctions() {
    StringList htmlElements = system.getHtmlElements();

    StringList functionDefList = moduleTree.identifierList(ModuleElementType.DEF);
    StringList importedFunctionList = moduleTree.getImportedFunctions();
    StringList functionCallList = moduleTree.identifierList(ModuleElementType.CALL);

    for (int callIndex = 0; callIndex < functionCallList.size(); callIndex++) {
      String functionCall = functionCallList.getStringValue(callIndex);

      boolean functionDefFound = functionDefList.itemInList(functionCall);
      boolean importedFunctionFound = importedFunctionList.itemInList(functionCall);
      boolean htmlFunctionFound = htmlElements.itemInList(functionCall);

      if (!functionDefFound && !importedFunctionFound &&!htmlFunctionFound ) {
        undefinedFunctionList.add(functionCall);
        System.out.println("Error: Called function not found: " + functionCall);
      }
    }

  }

  /**
   * Reports all function calls having a number of arguments that differs from
   * the declared formals. If a difference is found the arguments string is adjusted
   * by adding "undefined" parameters or removing redundant parameters.
   * HTML function calls are excluded from this check.
   */
  private void checkArityMismatches() {
    String moduleText = moduleTree.toString();

    ModuleElementList functionCallList = moduleTree.getNonHTMLFunctionCalls();

    for (int callIndex = 0; callIndex < functionCallList.size(); callIndex++) {
      String callElementString = functionCallList.getStringValue(callIndex);
      FunctionCall functionCall = new FunctionCall(callElementString);
      StringList argumentList = functionCall.getArgumentList();

      String functionCallIdentifier = functionCallList.getIdentifier(callIndex);
      StringList functionFormals = moduleTree.getFunctionFormals(functionCallIdentifier);
      StringList importedFunctionFormals = moduleTree.getImportedFunctionFormals(functionCallIdentifier);

      boolean unknownFunction = (nonExistingModuleList.itemInList(functionCallIdentifier) ||
        undefinedFunctionList.itemInList(functionCallIdentifier));

      if (!unknownFunction) {
        int mismatch = argumentList.size() - functionFormals.size() - importedFunctionFormals.size();

        if ( mismatch > 0 ) {
          System.out.println("Error: Arity mismatch in called function " + functionCallIdentifier + ": too many arguments.");
          functionCall.adjustArgumentsForMismatch(mismatch);
        }
        if ( mismatch < 0 ) {
          System.out.println("Error: Arity mismatch in called function " + functionCallIdentifier + ": too few arguments.");
          functionCall.adjustArgumentsForMismatch(mismatch);
        }
        moduleText = moduleText.replace(callElementString,functionCall.toString());
      }

    }
    moduleTree = new WaebricModule(moduleText);
  }

  /**
   * Main method. The input file is read and its text is checked.
   * After checking the content input file is replaced with the text that
   * has been modified during the checks.
   * @param args the name of the file to be checked
   * @throws IOException when the input file cannot be found.
   */
  public static void main(String[] args) throws IOException {

    InputFile inputFile = new InputFile(args[0]);
    String fileContent = inputFile.getFileContent();

    StaticSyntaxChecker checkedModule = new StaticSyntaxChecker(fileContent);

    System.out.println("Start Waebric static syntax checker....");
    System.out.println();

    checkedModule.checkNonExistingModules();
    checkedModule.checkDuplicateDefinitions();
    checkedModule.checkUndfinedVariables();
    checkedModule.checkUndefinedFunctions();
    checkedModule.checkArityMismatches();

    inputFile.replaceContent(checkedModule.getModuleText());

    System.out.println();
    System.out.println("Syntax check finished.");
  }
}
