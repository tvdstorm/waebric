/*
 * Generated by classgen, version 1.5
 * 6/16/09 8:42 PM
 */
package waebric.node;

public class Type extends Attribuut {

  public String idCon;

  public Type (String idCon) {
    this.idCon = idCon;
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
    buffer.append("Type(\n");
    buffer.append("  "+tab+idCon);
    buffer.append("\n");
    buffer.append(tab);
    buffer.append(") [Type]");
    return buffer.toString();
  }
}
