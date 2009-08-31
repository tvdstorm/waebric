/*
 * Generated by classgen, version 1.5
 * 7/30/09 10:24 AM
 */
package waebric.node;

public class List extends Expression {

  public ExpressionList expressionList;

  public List (ExpressionList expressionList) {
    this.expressionList = expressionList;
    if (expressionList != null) expressionList.setParent(this);
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  public void childrenAccept(Visitor visitor) {
    if (expressionList != null) expressionList.accept(visitor);
  }

  public void traverseTopDown(Visitor visitor) {
    accept(visitor);
    if (expressionList != null) expressionList.traverseTopDown(visitor);
  }

  public void traverseBottomUp(Visitor visitor) {
    if (expressionList != null) expressionList.traverseBottomUp(visitor);
    accept(visitor);
  }

  public String toString(String tab) {
    StringBuffer buffer = new StringBuffer();
    buffer.append(tab);
    buffer.append("List(\n");
      if (expressionList != null)
        buffer.append(expressionList.toString("  "+tab));
      else
        buffer.append(tab+"  null");
    buffer.append("\n");
    buffer.append(tab);
    buffer.append(") [List]");
    return buffer.toString();
  }
}
