package staticchecker;

/**
 *
 * <p>Title: ModuleElement</p>
 * <p>Description: Part of a module. A ModuleElement has a keyword, a prefix and a suffix.
 * The text between prefix and suffix can be used as an identifier or as a formals string, depending
 * on the element type.
 * Keywords, prefixes and suffixes are described in class ModuleElementType.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: University of Amsterdam</p>
 * @author Aart van den Dolder
 * @version 1.0
 */
public class ModuleElement extends AbstractSyntaxTree {

  private String identifier = "";

  /**
   * Constructor
   * @param text the text of this module element
   * @param type the type of this module element
   */
  public ModuleElement(String text, ModuleElementType type) {
    super(text, type);

    setIdentifier();
  }

  /**
   * Determines the text between the prefix and the suffix.
   * @param type the type of the module element
   * @return an identifier or formals string (depending on the element type)
   */
  public String stringBetweenPrefixAndSuffix(ModuleElementType type) {
    String outputString = "";

    String prefix = type.prefix();
    String suffix = type.suffix();

    int startPrefix = elementText.indexOf(prefix);
    int endPrefix = startPrefix + prefix.length();

    int startSuffix = elementText.indexOf(suffix, endPrefix);

    if (startPrefix >= 0 && startSuffix >= 0) {
      outputString = elementText.substring(endPrefix, startSuffix);
      outputString = outputString.trim();
    }

    return outputString;
  }

  /**
   * Sets the identifier attribute.
   */
  private void setIdentifier() {
    identifier = this.stringBetweenPrefixAndSuffix(elementType);
  }

  /**
   * Gets the identifier attribute.
   * @return the identifier attribute
   */
  public String getIdentifier() {
    return identifier;
  }

  /**
   * Gets the formals string of this module element
   * @return the formals string
   */
  public String getFormalsString() {
    return this.stringBetweenPrefixAndSuffix(elementType);
  }

}
