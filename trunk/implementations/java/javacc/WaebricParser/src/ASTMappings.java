/* Generated By:JJTree: Do not edit this line. ASTMappings.java Version 4.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY= */
@SuppressWarnings("all")
public class ASTMappings extends SimpleNode {
  public ASTMappings(int id) {
    super(id);
  }

  public ASTMappings(WaebricParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(WaebricParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=698c6726525ec41bdf82f3e04d38456c (do not edit this line) */