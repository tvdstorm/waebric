/* Generated By:JJTree: Do not edit this line. ASTPath.java Version 4.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY= */
@SuppressWarnings("all")
public class ASTPath extends SimpleNode {
  public ASTPath(int id) {
    super(id);
  }

  public ASTPath(WaebricParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(WaebricParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=3f97e186f2e3f3a7e8fb667dde20589c (do not edit this line) */