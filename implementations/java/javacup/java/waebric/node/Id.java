/*
 * Generated by classgen, version 1.5
 * 7/30/09 10:24 AM
 */
package waebric.node;

public class Id extends Attribuut {

  public String idCon;

  public Id (String idCon) {
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
    buffer.append("Id(\n");
    buffer.append("  "+tab+idCon);
    buffer.append("\n");
    buffer.append(tab);
    buffer.append(") [Id]");
    return buffer.toString();
  }
}
