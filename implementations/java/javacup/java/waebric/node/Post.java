/*
 * Generated by classgen, version 1.5
 * 7/30/09 10:24 AM
 */
package waebric.node;

public class Post extends Texttail {

  public String text;

  public Post (String text) {
    this.text = text;
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
    buffer.append("Post(\n");
    buffer.append("  "+tab+text);
    buffer.append("\n");
    buffer.append(tab);
    buffer.append(") [Post]");
    return buffer.toString();
  }
}
