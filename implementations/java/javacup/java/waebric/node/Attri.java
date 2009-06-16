/*
 * Generated by classgen, version 1.5
 * 6/16/09 7:49 PM
 */
package waebric.node;

public class Attri extends Argument {

  public String id;
  public Expression expr;

  public Attri (String id, Expression expr) {
    this.id = id;
    this.expr = expr;
    if (expr != null) expr.setParent(this);
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  public void childrenAccept(Visitor visitor) {
    if (expr != null) expr.accept(visitor);
  }

  public void traverseTopDown(Visitor visitor) {
    accept(visitor);
    if (expr != null) expr.traverseTopDown(visitor);
  }

  public void traverseBottomUp(Visitor visitor) {
    if (expr != null) expr.traverseBottomUp(visitor);
    accept(visitor);
  }

  public String toString(String tab) {
    StringBuffer buffer = new StringBuffer();
    buffer.append(tab);
    buffer.append("Attri(\n");
    buffer.append("  "+tab+id);
    buffer.append("\n");
      if (expr != null)
        buffer.append(expr.toString("  "+tab));
      else
        buffer.append(tab+"  null");
    buffer.append("\n");
    buffer.append(tab);
    buffer.append(") [Attri]");
    return buffer.toString();
  }
}
