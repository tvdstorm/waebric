package staticchecker;

/**
 *
 * <p>Title: Statement</p>
 * <p>Description: A Statement module element contains the text of a let or each statement subtree.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: University of Amsterdam</p>
 * @author Aart van den Dolder
 * @version 1.0
 */
public class Statement extends ModuleElement {

  /**
   * Constructor
   * @param text the text of this statement
   * @param type the type of this statement
   */
  public Statement(String text, ModuleElementType type) {
    super(text, type);
  }

  /**
   * Gets a list of all variable declarations of this statement
   * @return a list with variable names
   */
  public StringList getVariableDeclaratations() {
    return this.identifierList(ModuleElementType.VAR_BIND);
  }

  /**
   * Gets a list of all used variables within this statement
   * @return a list with variable names
   */
  public StringList getVariables() {
    return this.identifierList(ModuleElementType.VAR);
  }

  /**
   * Gets a list of all formals of this statement. (Only applicable to
   * a let statement.)
   * @return a list with formals
   */
  public StringList getFormals() {
    StringList formalsList = new StringList();

    final String FUNC_BIND = "[func-bind(";
    final String COMMA = ",";
    final String LBRACK = "[";
    final String RBRACK = "]";
    final String QUOTE = "\"";

    String searchString = elementText;

    int startSearch = 0;
    startSearch = searchString.indexOf(FUNC_BIND, startSearch);
    startSearch = searchString.indexOf(COMMA, startSearch);
    startSearch = searchString.indexOf(LBRACK, startSearch);

    int endSearch = searchString.indexOf(RBRACK, startSearch);

    searchString = searchString.substring(startSearch, endSearch);

    int firstQuote = searchString.indexOf(QUOTE);
    searchString = searchString.substring(firstQuote + 1);

    int lastQuote = 0;
    int nextQuote = searchString.indexOf(QUOTE);
    while (nextQuote > 0) {
      lastQuote = nextQuote;
      nextQuote = searchString.indexOf(QUOTE, lastQuote + 1);
    }

    searchString = searchString.substring(0, lastQuote);

    FormalsString formalsString = new FormalsString(searchString);
    formalsList = formalsString.getFormalList();

    return formalsList;

  }

}
