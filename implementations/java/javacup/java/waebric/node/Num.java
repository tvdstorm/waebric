/*
 * Generated by classgen, version 1.5
 * 6/16/09 8:42 PM
 */
package waebric.node;

public class Num extends Expression {

  public String id;

  public Num (String id) {
    this.id = id;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  public void childrenAccept(Visitor visitor) {
  }

  public void traverseTopDown(Visitor visitor) {
    accept(visitor);
  }

  public void traverseBottomUp(Visitor visitor) {
    accept(visitor);
  }

  public String toString(String tab) {
    StringBuffer buffer = new StringBuffer();
    buffer.append(tab);
    buffer.append("Num(\n");
    buffer.append("  "+tab+id);
    buffer.append("\n");
    buffer.append(tab);
    buffer.append(") [Num]");
    return buffer.toString();
  }
}