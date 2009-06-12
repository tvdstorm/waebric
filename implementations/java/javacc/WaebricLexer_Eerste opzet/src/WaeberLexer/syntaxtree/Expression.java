//
// Generated by JTB 1.3.2
//

package WaeberLexer.syntaxtree;

/**
 * Grammar production:
 * f0 -> ( <MODULE> | <SITE> | <END> | <DEF> | <ECHO> | <YIELD> | <EACH> | <IF> | <LET> | <COMMENT> | <CDATA> | <IMPORT> | <IDENTIFIER> | <INTEGER_LITERAL> | <PLUS> | <MINUS> | <IS> | <OPAR> | <CPAR> | <OBRACE> | <CBRACE> | <SLASH> | <DOT> | <COLON> | <QUOTATION> | <SEMICOLON> | <COMMA> | <AMPERSAND> | <FLOATINGPOINT> | <AT> )*
 */
@SuppressWarnings("all")
public class Expression implements Node {
   public NodeListOptional f0;

   public Expression(NodeListOptional n0) {
      f0 = n0;
   }

   public void accept(WaeberLexer.visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(WaeberLexer.visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(WaeberLexer.visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(WaeberLexer.visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
}
