/*
 * Generated by classgen, version 1.5
 * 6/16/09 7:49 PM
 */
package waebric.node;

public class Formal0 extends Formal {

  public String idcon;

  public Formal0 (String idcon) {
    this.idcon = idcon;
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
    buffer.append("Formal0(\n");
    buffer.append("  "+tab+idcon);
    buffer.append("\n");
    buffer.append(tab);
    buffer.append(") [Formal0]");
    return buffer.toString();
  }
}
