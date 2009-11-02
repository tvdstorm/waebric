package staticchecker;

/**
 *
 * <p>Title: FormalsString</p>
 * <p>Description: A FormalsString module element contains the text of the subtree with keyword "formals". </p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: University of Amsterdam</p>
 * @author Aart van den Dolder
 * @version 1.0
 */
public class FormalsString extends ModuleElement {

  /**
   * Constructor
   * @param text the text of this FormalsString
   */
  public FormalsString(String text) {
    super(text, ModuleElementType.FORMALS);
  }

  /**
   * Gets the individual formals from this FormalString
   * @return a list with formals
   */
  public StringList getFormalList() {
    StringList formalsList = new StringList();

    String searchString = elementText;

    final String QUOTE = "\"";
    int endFormal = 0;
    int nextFormal = 0;
    do {
      String formal;
      endFormal = searchString.indexOf(QUOTE);
      if (endFormal > 0) {
        formal = searchString.substring(0, endFormal);
        nextFormal = searchString.indexOf(QUOTE, endFormal + 1) + 1;
        if (nextFormal > 0) {
          searchString = searchString.substring(nextFormal);
        }
      }
      else {
        formal = searchString;
      }
      formalsList.add(formal);
    }
    while (endFormal > 0);
    return formalsList;
  }

}
