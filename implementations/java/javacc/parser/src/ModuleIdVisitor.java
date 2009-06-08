public class ModuleIdVisitor extends WaebricParserVisitorAdapter {
  public String moduleIdStr = "";
  private String testx= "";
  public Object visit(ASTModuleId ModuleId, Object data) {
	moduleIdStr += ModuleId.image;
    // Do something before subtrees are visited
	Object obj =  super.visit(ModuleId, data);
    // Do something after subtrees are visited
	testx += "[" + moduleIdStr + "]" + ")";
	moduleIdStr = testx;
    return obj;
  }
}
