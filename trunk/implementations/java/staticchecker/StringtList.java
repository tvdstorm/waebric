package staticchecker;

import java.util.ArrayList;

/**
 *
 * <p>Title: StringList </p>
 * <p>Description: A StringList is an ArrayList of String values.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: University of Amsterdam</p>
 * @author Aart van den Dolder
 * @version 1.0
 */
class StringList extends ArrayList {

  /** Checks if the specified item occurs in this list
   *
   * @param item the requested item
   * @return the result of the check (true/false)
   */
  public boolean itemInList(String item) {
    boolean itemFound = false;
    for (int index = 0; index < this.size(); index++) {
      String listItem = this.getStringValue(index);

      if (listItem.equals(item)) {
        itemFound = true;
        break;
      }
    }
    return itemFound;
  }

  /** Returns the String value of the element at the specified position in this list.
   *
   * @param index position in this list
   * @return String value of the element
   */
  public String getStringValue(int index) {
    return this.get(index).toString();
  }

}
