/*
 * Generated by classgen, version 1.5
 * 6/16/09 7:49 PM
 */
package waebric.node;

public abstract class Texttail implements SyntaxNode {

  private SyntaxNode parent;

  public SyntaxNode getParent() {
    return parent;
  }

  public void setParent(SyntaxNode parent) {
    this.parent = parent;
  }

  public abstract void accept(Visitor visitor);
  public abstract void childrenAccept(Visitor visitor);
  public abstract void traverseTopDown(Visitor visitor);
  public abstract void traverseBottomUp(Visitor visitor);
  public String toString() {
    return toString("");
  }

  public abstract String toString(String tab);
}
