/*
 * Generated by classgen, version 1.5
 * 6/16/09 7:49 PM
 */
package waebric.node;

public class Path implements SyntaxNode {

  private SyntaxNode parent;
  public String dir;
  public String filename;

  public Path (String dir, String filename) {
    this.dir = dir;
    this.filename = filename;
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
  }

  public void traverseTopDown(Visitor visitor) {
    accept(visitor);
  }

  public void traverseBottomUp(Visitor visitor) {
    accept(visitor);
  }

  public String toString() {
    return toString("");
  }

  public String toString(String tab) {
    StringBuffer buffer = new StringBuffer();
    buffer.append(tab);
    buffer.append("Path(\n");
    buffer.append("  "+tab+dir);
    buffer.append("\n");
    buffer.append("  "+tab+filename);
    buffer.append("\n");
    buffer.append(tab);
    buffer.append(") [Path]");
    return buffer.toString();
  }
}
