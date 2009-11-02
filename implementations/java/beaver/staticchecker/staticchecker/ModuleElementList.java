package staticchecker;

import java.util.ArrayList;

/**
 *
 * <p>Title: ModuleElementList</p>
 * <p>Description: A ModuleElementList is an ArrayList containing ModuleElements.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: University of Amsterdam</p>
 * @author Aart van den Dolder
 * @version 1.0
 */
public class ModuleElementList extends ArrayList {

  /**
   * Gets the identifier of the element at the specified position in this list.
   * @param index position in this list
   * @return the identifier of the module element
   */
  public String getIdentifier(int index) {
    ModuleElement element = (ModuleElement) this.get(index);
    return element.getIdentifier();
  }

  /**
   * Gets the text of the element at the specified position in this list.
   * @param index position in this list
   * @return the text of the module element
   */
  public String getStringValue(int index) {
    ModuleElement element = (ModuleElement) this.get(index);
    return element.toString();
  }

  /**
   * Gets the formals string of the element at the specified position in this list.
   * @param index position in this list
   * @return the formals string of the module element
   */
  public String getFormalsString(int index) {
    ModuleElement element = (ModuleElement) this.get(index);
    return element.getFormalsString();
  }

}
