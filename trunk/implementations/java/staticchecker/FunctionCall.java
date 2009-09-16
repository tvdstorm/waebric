package staticchecker;

/**
 *
 * <p>Title: FunctionCall</p>
 * <p>Description: A FunctionCall module element contains the text of the subtree with keyword "call"</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: University of Amsterdam</p>
 * @author Aart van den Dolder
 * @version 1.0
 */
public class FunctionCall extends ModuleElement {

  private String argumentsString = "";
  private static String ARGS_PREFIX = ModuleElementType.ARGS.prefix();
  private static String ARGS_SUFFIX = ModuleElementType.ARGS.suffix();

  /**
   * Constructor
   * @param text the text of this FunctionCall
   */
  public FunctionCall(String text) {
    super(text, ModuleElementType.CALL);

    setArgumentsString();
  }

  /**
   * Sets the argumentsString attribute.
   * This is the text belonging to the "args" keyword within this FunctionCall.
   */
  private void setArgumentsString() {
    argumentsString = this.stringBetweenPrefixAndSuffix(ModuleElementType.ARGS);
    argumentsString = ARGS_PREFIX + argumentsString + ARGS_SUFFIX;
  }

  /**
   * Gets the individual arguments from the arguments string.
   * @return a list with arguments
   */
  public StringList getArgumentList() {
    StringList argumentList = new StringList();

    final char LPAREN = '(';
    final char RPAREN = ')';
    final char COMMA = ',';

    String searchString = this.stringBetweenPrefixAndSuffix(ModuleElementType.ARGS);

    int endArgument = 0;
    int nestingLevel = 0;

    for (int index = 0; index < searchString.length(); index++) {
      if (searchString.charAt(index) == LPAREN) {
        nestingLevel++;
      }
      if ( searchString.charAt(index) == RPAREN ) {
        nestingLevel--;
      }
      boolean argumentFound = ((searchString.charAt(index) == COMMA) && (nestingLevel == 0));
      if ( argumentFound ) {
        String argument = searchString.substring(endArgument, index).trim();
        argumentList.add( argument );
        endArgument = index + 1;
      }
    }

    if (searchString.length() > 0) {
      String argument = searchString.substring(endArgument).trim();
      argumentList.add( argument );
    }

    return argumentList;
  }

  /**
   * Adjusts the arguments string of this FunctionCall.
   * If there are more arguments than function formals (mismatch > 0) the
   * redundant arguments are removed.
   * If there are less arguments than function formals (mismatch < 0) the
   * formals string is extended with "undefined" arguments.
   * @param mismatch
   */
  public void adjustArgumentsForMismatch(int mismatch) {
    final String UNDEFINED_ARGUMENT = "\"undefined\"";

    StringList arguments = this.getArgumentList();

    int numberArguments = Math.max(arguments.size() - mismatch, 0);

    if (mismatch < 0) {
      // too few arguments: some "undefined" arguments are added
      for (int index = 0; index < Math.abs(mismatch); index++) {
        arguments.add(UNDEFINED_ARGUMENT);
      }
    }

    String newArgumentsString = ARGS_PREFIX;

    for (int index = 0; index < numberArguments; index++) {
      String argument = arguments.getStringValue(index);

      if (index == 0)
        newArgumentsString = newArgumentsString + argument;
      else
        newArgumentsString = newArgumentsString + ", " + argument;
    }

    newArgumentsString = newArgumentsString + ARGS_SUFFIX;
    elementText = elementText.replace(argumentsString,newArgumentsString);
  }

}
