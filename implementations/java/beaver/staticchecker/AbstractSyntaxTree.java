package staticchecker;

/**
 *
 * <p>Title: AbstractSyntaxTree</p>
 * <p>Description: The abstract syntax tree representation of a module or part of it.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: University of Amsterdam</p>
 * @author Aart van den Dolder
 * @version 1.0
 */
public class AbstractSyntaxTree {

  protected ModuleElementType elementType;
  protected String elementText;

  /**
   * Constructor
   * @param text the text of the abstract syntax tree to be analyzed
   * @param type the type of tree element to be analyzed
   */
  public AbstractSyntaxTree(String text, ModuleElementType type) {
    elementType = type;
    elementText = text;
  }

  /**
   * Gets the type of the abstract syntax tree (element)
   * @return the type of the abstract syntax tree (element)
   */
  public ModuleElementType getType() {
    return elementType;
  }

  /**
   * Gets the text of the abstract syntax tree (element)
   * @return the text of the abstract syntax tree (element)
   */
  public String toString() {
    return elementText;
  }

  /**
   * Determines a list of all tree elements of a given type within this abstract tree element
   * @param type the requested type of module elements
   * @return a list of all module elements of this type
   */
  public ModuleElementList moduleElementList(ModuleElementType type) {
    ModuleElementList elementList = new ModuleElementList();

    String keyword = type.keyword();

    final char LPAREN = '(';
    final char RPAREN = ')';

    int nestingLevel = 0;
    int charIndex = 0;
    StringBuffer subTreeBuffer = new StringBuffer();

    do {
      if (nestingLevel == 0) {
        subTreeBuffer = new StringBuffer(keyword + LPAREN);
        nestingLevel++;
        charIndex = elementText.indexOf(subTreeBuffer.toString(), charIndex);
        if (charIndex >= 0) {
          charIndex = charIndex + subTreeBuffer.length();
        }
      }

      if (charIndex >= 0) {
        char stringElement = elementText.charAt(charIndex);
        subTreeBuffer = subTreeBuffer.append(stringElement);

        if (stringElement == LPAREN) {
          nestingLevel++;
        }
        if (stringElement == RPAREN) {
          nestingLevel--;

        }
        if (nestingLevel == 0) {
          ModuleElement moduleElement = new ModuleElement(subTreeBuffer.toString(),type);
          elementList.add(moduleElement);

        }
        charIndex++;
      }
    }
    while (0 <= charIndex && charIndex < elementText.length());

    return elementList;
  }

  /**
   * Determines a list of the identifiers of all elements of a given type
   * @param type the requested type of module elements
   * @return a list of all identifiers
   */
  public StringList identifierList(ModuleElementType type) {
    StringList identifierList = new StringList();

    ModuleElementList elementList = this.moduleElementList(type);

    for (int elementIndex = 0; elementIndex < elementList.size(); elementIndex++) {
      String identifier = elementList.getIdentifier(elementIndex);
      identifierList.add(identifier);
    }
    return identifierList;
  }

}

