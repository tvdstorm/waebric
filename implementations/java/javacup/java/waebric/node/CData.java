/*
 * Generated by classgen, version 1.5
 * 6/16/09 8:42 PM
 */
package waebric.node;

public class CData extends Statement {

  public Expression e;

  public CData (Expression e) {
    this.e = e;
    if (e != null) e.setParent(this);
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  public void childrenAccept(Visitor visitor) {
    if (e != null) e.accept(visitor);
  }

  public void traverseTopDown(Visitor visitor) {
    accept(visitor);
    if (e != null) e.traverseTopDown(visitor);
  }

  public void traverseBottomUp(Visitor visitor) {
    if (e != null) e.traverseBottomUp(visitor);
    accept(visitor);
  }

  public String toString(String tab) {
    StringBuffer buffer = new StringBuffer();
    buffer.append(tab);
    buffer.append("CData(\n");
      if (e != null)
        buffer.append(e.toString("  "+tab));
      else
        buffer.append(tab+"  null");
    buffer.append("\n");
    buffer.append(tab);
    buffer.append(") [CData]");
    return buffer.toString();
  }
}