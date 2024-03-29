/*
 * Generated by classgen, version 1.5
 * 7/30/09 10:24 AM
 */
package waebric.node;

public class WidthHeight extends Attribuut {

  public Integer w;
  public Integer h;

  public WidthHeight (Integer w, Integer h) {
    this.w = w;
    this.h = h;
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
    buffer.append("WidthHeight(\n");
    buffer.append("  "+tab+w);
    buffer.append("\n");
    buffer.append("  "+tab+h);
    buffer.append("\n");
    buffer.append(tab);
    buffer.append(") [WidthHeight]");
    return buffer.toString();
  }
}
