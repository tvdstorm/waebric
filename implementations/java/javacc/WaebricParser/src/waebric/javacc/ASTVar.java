package waebric.javacc;
/* Generated By:JJTree: Do not edit this line. ASTVar.java Version 4.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY= */
@SuppressWarnings("all")
public class ASTVar extends SimpleNode {
  public ASTVar(int id) {
    super(id);
  }

  public ASTVar(WaebricParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(WaebricParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=ede1aedcea9359e3ee4c97997df8ab46 (do not edit this line) */
