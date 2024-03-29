/*
 * Generated by classgen, version 1.5
 * 7/30/09 10:24 AM
 */
package waebric.node;

public class FuncBind extends Assignment {

  public String id;
  public FormalList fl;
  public Statement s;

  public FuncBind (String id, FormalList fl, Statement s) {
    this.id = id;
    this.fl = fl;
    if (fl != null) fl.setParent(this);
    this.s = s;
    if (s != null) s.setParent(this);
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  public void childrenAccept(Visitor visitor) {
    if (fl != null) fl.accept(visitor);
    if (s != null) s.accept(visitor);
  }

  public void traverseTopDown(Visitor visitor) {
    accept(visitor);
    if (fl != null) fl.traverseTopDown(visitor);
    if (s != null) s.traverseTopDown(visitor);
  }

  public void traverseBottomUp(Visitor visitor) {
    if (fl != null) fl.traverseBottomUp(visitor);
    if (s != null) s.traverseBottomUp(visitor);
    accept(visitor);
  }

  public String toString(String tab) {
    StringBuffer buffer = new StringBuffer();
    buffer.append(tab);
    buffer.append("FuncBind(\n");
    buffer.append("  "+tab+id);
    buffer.append("\n");
      if (fl != null)
        buffer.append(fl.toString("  "+tab));
      else
        buffer.append(tab+"  null");
    buffer.append("\n");
      if (s != null)
        buffer.append(s.toString("  "+tab));
      else
        buffer.append(tab+"  null");
    buffer.append("\n");
    buffer.append(tab);
    buffer.append(") [FuncBind]");
    return buffer.toString();
  }
}
