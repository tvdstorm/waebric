/*
 * Generated by classgen, version 1.5
 * 7/30/09 10:24 AM
 */
package waebric.node;

public class Not extends Predicate {

  public Predicate p;

  public Not (Predicate p) {
    this.p = p;
    if (p != null) p.setParent(this);
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  public void childrenAccept(Visitor visitor) {
    if (p != null) p.accept(visitor);
  }

  public void traverseTopDown(Visitor visitor) {
    accept(visitor);
    if (p != null) p.traverseTopDown(visitor);
  }

  public void traverseBottomUp(Visitor visitor) {
    if (p != null) p.traverseBottomUp(visitor);
    accept(visitor);
  }

  public String toString(String tab) {
    StringBuffer buffer = new StringBuffer();
    buffer.append(tab);
    buffer.append("Not(\n");
      if (p != null)
        buffer.append(p.toString("  "+tab));
      else
        buffer.append(tab+"  null");
    buffer.append("\n");
    buffer.append(tab);
    buffer.append(") [Not]");
    return buffer.toString();
  }
}
