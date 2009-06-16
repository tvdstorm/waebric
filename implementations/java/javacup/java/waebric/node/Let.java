/*
 * Generated by classgen, version 1.5
 * 6/16/09 7:49 PM
 */
package waebric.node;

public class Let extends Statement {

  public AssignmentList ap;
  public StatementList as;

  public Let (AssignmentList ap, StatementList as) {
    this.ap = ap;
    if (ap != null) ap.setParent(this);
    this.as = as;
    if (as != null) as.setParent(this);
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  public void childrenAccept(Visitor visitor) {
    if (ap != null) ap.accept(visitor);
    if (as != null) as.accept(visitor);
  }

  public void traverseTopDown(Visitor visitor) {
    accept(visitor);
    if (ap != null) ap.traverseTopDown(visitor);
    if (as != null) as.traverseTopDown(visitor);
  }

  public void traverseBottomUp(Visitor visitor) {
    if (ap != null) ap.traverseBottomUp(visitor);
    if (as != null) as.traverseBottomUp(visitor);
    accept(visitor);
  }

  public String toString(String tab) {
    StringBuffer buffer = new StringBuffer();
    buffer.append(tab);
    buffer.append("Let(\n");
      if (ap != null)
        buffer.append(ap.toString("  "+tab));
      else
        buffer.append(tab+"  null");
    buffer.append("\n");
      if (as != null)
        buffer.append(as.toString("  "+tab));
      else
        buffer.append(tab+"  null");
    buffer.append("\n");
    buffer.append(tab);
    buffer.append(") [Let]");
    return buffer.toString();
  }
}
