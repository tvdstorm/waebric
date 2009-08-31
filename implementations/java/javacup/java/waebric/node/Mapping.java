/*
 * Generated by classgen, version 1.5
 * 7/30/09 10:24 AM
 */
package waebric.node;

public class Mapping implements SyntaxNode {

  private SyntaxNode parent;
  public Path path;
  public Markup markup;

  public Mapping (Path path, Markup markup) {
    this.path = path;
    if (path != null) path.setParent(this);
    this.markup = markup;
    if (markup != null) markup.setParent(this);
  }

  public SyntaxNode getParent() {
    return parent;
  }

  public void setParent(SyntaxNode parent) {
    this.parent = parent;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  public void childrenAccept(Visitor visitor) {
    if (path != null) path.accept(visitor);
    if (markup != null) markup.accept(visitor);
  }

  public void traverseTopDown(Visitor visitor) {
    accept(visitor);
    if (path != null) path.traverseTopDown(visitor);
    if (markup != null) markup.traverseTopDown(visitor);
  }

  public void traverseBottomUp(Visitor visitor) {
    if (path != null) path.traverseBottomUp(visitor);
    if (markup != null) markup.traverseBottomUp(visitor);
    accept(visitor);
  }

  public String toString() {
    return toString("");
  }

  public String toString(String tab) {
    StringBuffer buffer = new StringBuffer();
    buffer.append(tab);
    buffer.append("Mapping(\n");
      if (path != null)
        buffer.append(path.toString("  "+tab));
      else
        buffer.append(tab+"  null");
    buffer.append("\n");
      if (markup != null)
        buffer.append(markup.toString("  "+tab));
      else
        buffer.append(tab+"  null");
    buffer.append("\n");
    buffer.append(tab);
    buffer.append(") [Mapping]");
    return buffer.toString();
  }
}
