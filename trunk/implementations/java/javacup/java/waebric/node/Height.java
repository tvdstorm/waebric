/*
 * Generated by classgen, version 1.5
 * 6/16/09 8:42 PM
 */
package waebric.node;

public class Height extends Attribuut {

  public Integer num;

  public Height (Integer num) {
    this.num = num;
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
    buffer.append("Height(\n");
    buffer.append("  "+tab+num);
    buffer.append("\n");
    buffer.append(tab);
    buffer.append(") [Height]");
    return buffer.toString();
  }
}