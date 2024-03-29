/*
 * Generated by classgen, version 1.5
 * 7/30/09 10:24 AM
 */
package waebric.node;

public class Each extends Statement {

  public String id;
  public Expression e;
  public Statement s;

  public Each (String id, Expression e, Statement s) {
    this.id = id;
    this.e = e;
    if (e != null) e.setParent(this);
    this.s = s;
    if (s != null) s.setParent(this);
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  public void childrenAccept(Visitor visitor) {
    if (e != null) e.accept(visitor);
    if (s != null) s.accept(visitor);
  }

  public void traverseTopDown(Visitor visitor) {
    accept(visitor);
    if (e != null) e.traverseTopDown(visitor);
    if (s != null) s.traverseTopDown(visitor);
  }

  public void traverseBottomUp(Visitor visitor) {
    if (e != null) e.traverseBottomUp(visitor);
    if (s != null) s.traverseBottomUp(visitor);
    accept(visitor);
  }

  public String toString(String tab) {
    StringBuffer buffer = new StringBuffer();
    buffer.append(tab);
    buffer.append("Each(\n");
    buffer.append("  "+tab+id);
    buffer.append("\n");
      if (e != null)
        buffer.append(e.toString("  "+tab));
      else
        buffer.append(tab+"  null");
    buffer.append("\n");
      if (s != null)
        buffer.append(s.toString("  "+tab));
      else
        buffer.append(tab+"  null");
    buffer.append("\n");
    buffer.append(tab);
    buffer.append(") [Each]");
    return buffer.toString();
  }
}
