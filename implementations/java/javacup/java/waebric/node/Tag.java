/*
 * Generated by classgen, version 1.5
 * 6/16/09 8:42 PM
 */
package waebric.node;

public class Tag extends Designator {

  public String id;
  public AttribuutList attribuutList;

  public Tag (String id, AttribuutList attribuutList) {
    this.id = id;
    this.attribuutList = attribuutList;
    if (attribuutList != null) attribuutList.setParent(this);
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  public void childrenAccept(Visitor visitor) {
    if (attribuutList != null) attribuutList.accept(visitor);
  }

  public void traverseTopDown(Visitor visitor) {
    accept(visitor);
    if (attribuutList != null) attribuutList.traverseTopDown(visitor);
  }

  public void traverseBottomUp(Visitor visitor) {
    if (attribuutList != null) attribuutList.traverseBottomUp(visitor);
    accept(visitor);
  }

  public String toString(String tab) {
    StringBuffer buffer = new StringBuffer();
    buffer.append(tab);
    buffer.append("Tag(\n");
    buffer.append("  "+tab+id);
    buffer.append("\n");
      if (attribuutList != null)
        buffer.append(attribuutList.toString("  "+tab));
      else
        buffer.append(tab+"  null");
    buffer.append("\n");
    buffer.append(tab);
    buffer.append(") [Tag]");
    return buffer.toString();
  }
}
