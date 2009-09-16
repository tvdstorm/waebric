package staticchecker;

/**
 *
 * <p>Title: FunctionDef</p>
 * <p>Description: A FunctionDef module element contains the text of the subtree with keyword "def".</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: University of Amsterdam</p>
 * @author Aart van den Dolder
 * @version 1.0
 */
public class FunctionDef  extends ModuleElement {

  /**
   * Constructor
   * @param text the text of this FunctionDef
   */
  public FunctionDef(String text) {
    super(text, ModuleElementType.DEF);
  }

  /**
   * Gets the individual formals of this FunctionDef
   * @return a list with formals
   */
  public StringList getFormals() {
    StringList formalsList = new StringList();

    ModuleElementList formalsElementList = this.moduleElementList(ModuleElementType.FORMALS);

    if (formalsElementList.size() > 0) {
      // A function cannot have more than one formals element
      FormalsString formalsString = new FormalsString(formalsElementList.getFormalsString(0));
      formalsList = formalsString.getFormalList();
    }

    return formalsList;
  }

  /**
   * Gets the variables of this function def that are not used within let- and each-statements.
   * @return a list with varable names
   */
  public StringList getVariables() {
    this.removeStatements(ModuleElementType.LET);
    this.removeStatements(ModuleElementType.EACH);

    return this.identifierList(ModuleElementType.VAR);
  }

  /**
   * Removes a statement text from this FunctionDef
   * @param type the type of statement to be removed
   */
  private void removeStatements(ModuleElementType type) {
    ModuleElementList elementList = this.moduleElementList(type);

    for (int elementIndex = 0; elementIndex < elementList.size(); elementIndex++) {
      String elementString = elementList.getStringValue(elementIndex);
      elementText = elementText.replace(elementString, "");
    }

  }

}
