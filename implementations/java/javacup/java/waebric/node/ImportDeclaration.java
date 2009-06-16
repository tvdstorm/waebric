/*
 * Generated by classgen, version 1.5
 * 6/16/09 8:42 PM
 */
package waebric.node;

public class ImportDeclaration extends ModuleElement {

  public ModuleId id;

  public ImportDeclaration (ModuleId id) {
    this.id = id;
    if (id != null) id.setParent(this);
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  public void childrenAccept(Visitor visitor) {
    if (id != null) id.accept(visitor);
  }

  public void traverseTopDown(Visitor visitor) {
    accept(visitor);
    if (id != null) id.traverseTopDown(visitor);
  }

  public void traverseBottomUp(Visitor visitor) {
    if (id != null) id.traverseBottomUp(visitor);
    accept(visitor);
  }

  public String toString(String tab) {
    StringBuffer buffer = new StringBuffer();
    buffer.append(tab);
    buffer.append("ImportDeclaration(\n");
      if (id != null)
        buffer.append(id.toString("  "+tab));
      else
        buffer.append(tab+"  null");
    buffer.append("\n");
    buffer.append(tab);
    buffer.append(") [ImportDeclaration]");
    return buffer.toString();
  }
}
