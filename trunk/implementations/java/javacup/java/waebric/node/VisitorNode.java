/*
 * Generated by classgen, version 1.5
 * 6/16/09 7:49 PM
 */

package waebric.node;

public interface VisitorNode {
  public void accept(Visitor visitor);

  public void childrenAccept(Visitor visitor);
  public void traverseBottomUp(Visitor visitor);
  public void traverseTopDown(Visitor visitor);
}
