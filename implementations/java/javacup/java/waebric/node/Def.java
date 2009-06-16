/*
 * Generated by classgen, version 1.5
 * 6/16/09 7:49 PM
 */
package waebric.node;

public class Def extends ModuleElement {

  public String id;
  public FormalList formalList;
  public StatementList statementList;

  public Def (String id, FormalList formalList, StatementList statementList) {
    this.id = id;
    this.formalList = formalList;
    if (formalList != null) formalList.setParent(this);
    this.statementList = statementList;
    if (statementList != null) statementList.setParent(this);
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  public void childrenAccept(Visitor visitor) {
    if (formalList != null) formalList.accept(visitor);
    if (statementList != null) statementList.accept(visitor);
  }

  public void traverseTopDown(Visitor visitor) {
    accept(visitor);
    if (formalList != null) formalList.traverseTopDown(visitor);
    if (statementList != null) statementList.traverseTopDown(visitor);
  }

  public void traverseBottomUp(Visitor visitor) {
    if (formalList != null) formalList.traverseBottomUp(visitor);
    if (statementList != null) statementList.traverseBottomUp(visitor);
    accept(visitor);
  }

  public String toString(String tab) {
    StringBuffer buffer = new StringBuffer();
    buffer.append(tab);
    buffer.append("Def(\n");
    buffer.append("  "+tab+id);
    buffer.append("\n");
      if (formalList != null)
        buffer.append(formalList.toString("  "+tab));
      else
        buffer.append(tab+"  null");
    buffer.append("\n");
      if (statementList != null)
        buffer.append(statementList.toString("  "+tab));
      else
        buffer.append(tab+"  null");
    buffer.append("\n");
    buffer.append(tab);
    buffer.append(") [Def]");
    return buffer.toString();
  }
}
