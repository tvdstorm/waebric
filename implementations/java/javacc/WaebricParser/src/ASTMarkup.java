/* Generated By:JJTree: Do not edit this line. ASTMarkup.java Version 4.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY= */
@SuppressWarnings("all")
public class ASTMarkup extends SimpleNode {
  public ASTMarkup(int id) {
    super(id);
  }

  public ASTMarkup(WaebricParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(WaebricParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=ae5e87cd205f9ebac10fad82cd8be71b (do not edit this line) */
