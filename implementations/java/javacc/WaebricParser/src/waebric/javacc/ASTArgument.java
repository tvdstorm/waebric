package waebric.javacc;
/* Generated By:JJTree: Do not edit this line. ASTArgument.java Version 4.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY= */
@SuppressWarnings("all")
public class ASTArgument extends SimpleNode {
  public ASTArgument(int id) {
    super(id);
  }

  public ASTArgument(WaebricParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(WaebricParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=514893ccf70853fa4685a69ca8fec94f (do not edit this line) */
