/*
 * Generated by classgen, version 1.5
 * 6/16/09 8:42 PM
 */
package waebric.node;

public class Opmaak extends Statement {

  public Markup m;

  public Opmaak (Markup m) {
    this.m = m;
    if (m != null) m.setParent(this);
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  public void childrenAccept(Visitor visitor) {
    if (m != null) m.accept(visitor);
  }

  public void traverseTopDown(Visitor visitor) {
    accept(visitor);
    if (m != null) m.traverseTopDown(visitor);
  }

  public void traverseBottomUp(Visitor visitor) {
    if (m != null) m.traverseBottomUp(visitor);
    accept(visitor);
  }

  public String toString(String tab) {
    StringBuffer buffer = new StringBuffer();
    buffer.append(tab);
    buffer.append("Opmaak(\n");
      if (m != null)
        buffer.append(m.toString("  "+tab));
      else
        buffer.append(tab+"  null");
    buffer.append("\n");
    buffer.append(tab);
    buffer.append(") [Opmaak]");
    return buffer.toString();
  }
}