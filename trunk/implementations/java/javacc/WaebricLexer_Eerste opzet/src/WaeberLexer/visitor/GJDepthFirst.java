//
// Generated by JTB 1.3.2
//

package WaeberLexer.visitor;
import WaeberLexer.syntaxtree.*;
import java.util.*;

/**
 * Provides default methods which visit each node in the tree in depth-first
 * order.  Your visitors may extend this class.
 */
@SuppressWarnings("all")
public class GJDepthFirst<R,A> implements GJVisitor<R,A> {
   //
   // Auto class visitors--probably don't need to be overridden.
   //
   public R visit(NodeList n, A argu) {
      R _ret=null;
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this,argu);
         _count++;
      }
      return _ret;
   }

   public R visit(NodeListOptional n, A argu) {
      if ( n.present() ) {
         R _ret=null;
         int _count=0;
         for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this,argu);
            _count++;
         }
         return _ret;
      }
      else
         return null;
   }

   public R visit(NodeOptional n, A argu) {
      if ( n.present() )
         return n.node.accept(this,argu);
      else
         return null;
   }

   public R visit(NodeSequence n, A argu) {
      R _ret=null;
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this,argu);
         _count++;
      }
      return _ret;
   }

   public R visit(NodeToken n, A argu) { return null; }

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> Expression()
    * f1 -> <ENDOFFILE>
    */
   public R visit(Start n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> ( <MODULE> | <SITE> | <END> | <DEF> | <ECHO> | <YIELD> | <EACH> | <IF> | <LET> | <COMMENT> | <CDATA> | <IMPORT> | <IDENTIFIER> | <INTEGER_LITERAL> | <PLUS> | <MINUS> | <IS> | <OPAR> | <CPAR> | <OBRACE> | <CBRACE> | <SLASH> | <DOT> | <COLON> | <QUOTATION> | <SEMICOLON> | <COMMA> | <AMPERSAND> | <FLOATINGPOINT> | <AT> )*
    */
   public R visit(Expression n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
   }

   /**

    */
   public R visit(AdditiveExpression n, A argu) {
      R _ret=null;
      return _ret;
   }

   /**

    */
   public R visit(MultiplicativeExpression n, A argu) {
      R _ret=null;
      return _ret;
   }

   /**

    */
   public R visit(UnaryExpression n, A argu) {
      R _ret=null;
      return _ret;
   }

   /**

    */
   public R visit(Identifier n, A argu) {
      R _ret=null;
      return _ret;
   }

   /**

    */
   public R visit(MyInteger n, A argu) {
      R _ret=null;
      return _ret;
   }

}
