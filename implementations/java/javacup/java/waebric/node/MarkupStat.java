/*
 * Generated by classgen, version 1.5
 * 6/16/09 7:49 PM
 */
package waebric.node;

public class MarkupStat extends Statement {

  public MarkupList ml;
  public Statement s;

  public MarkupStat (MarkupList ml, Statement s) {
    this.ml = ml;
    if (ml != null) ml.setParent(this);
    this.s = s;
    if (s != null) s.setParent(this);
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  public void childrenAccept(Visitor visitor) {
    if (ml != null) ml.accept(visitor);
    if (s != null) s.accept(visitor);
  }

  public void traverseTopDown(Visitor visitor) {
    accept(visitor);
    if (ml != null) ml.traverseTopDown(visitor);
    if (s != null) s.traverseTopDown(visitor);
  }

  public void traverseBottomUp(Visitor visitor) {
    if (ml != null) ml.traverseBottomUp(visitor);
    if (s != null) s.traverseBottomUp(visitor);
    accept(visitor);
  }

  public String toString(String tab) {
    StringBuffer buffer = new StringBuffer();
    buffer.append(tab);
    buffer.append("MarkupStat(\n");
      if (ml != null)
        buffer.append(ml.toString("  "+tab));
      else
        buffer.append(tab+"  null");
    buffer.append("\n");
      if (s != null)
        buffer.append(s.toString("  "+tab));
      else
        buffer.append(tab+"  null");
    buffer.append("\n");
    buffer.append(tab);
    buffer.append(") [MarkupStat]");
    return buffer.toString();
  }
}
