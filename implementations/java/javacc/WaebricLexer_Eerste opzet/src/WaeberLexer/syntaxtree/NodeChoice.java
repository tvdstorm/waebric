//
// Generated by JTB 1.3.2
//

package WaeberLexer.syntaxtree;

/**
 * Represents a grammar choice, e.g. ( A | B )
 */
@SuppressWarnings("all")
public class NodeChoice implements Node {
   public NodeChoice(Node node) {
      this(node, -1);
   }

   public NodeChoice(Node node, int whichChoice) {
      choice = node;
      which = whichChoice;
   }

   public void accept(WaeberLexer.visitor.Visitor v) {
      choice.accept(v);
   }
   public <R,A> R accept(WaeberLexer.visitor.GJVisitor<R,A> v, A argu) {
      return choice.accept(v,argu);
   }
   public <R> R accept(WaeberLexer.visitor.GJNoArguVisitor<R> v) {
      return choice.accept(v);
   }
   public <A> void accept(WaeberLexer.visitor.GJVoidVisitor<A> v, A argu) {
      choice.accept(v,argu);
   }

   public Node choice;
   public int which;
}
