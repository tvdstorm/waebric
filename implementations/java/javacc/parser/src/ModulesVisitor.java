public class ModulesVisitor extends WaebricParserVisitorAdapter {
	private String ast = "";
	
	public Object visit(ASTModules node, Object data){
		int numChildren = node.jjtGetNumChildren();
		
	  	for ( int currentChild = 0; currentChild < numChildren; currentChild++ ) {
	  		if (node.jjtGetChild(currentChild).toString().equals("Module")){
	  			ModuleVisitor moduleVisitor = new ModuleVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(moduleVisitor, null);
	  			ast += moduleVisitor.getAST();
	  		}
	    }
		return data;
	}
	
	public String getAST(){
		return ast;
	}
}
