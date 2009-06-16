public class ModulesVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTModules node, Object data){
		int numChildren = node.jjtGetNumChildren();

	  	for ( int currentChild = 0; currentChild < numChildren; currentChild++ ) {
	  		if (node.jjtGetChild(currentChild).toString().equals("Module")){
	  			ModuleVisitor moduleVisitor = new ModuleVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(moduleVisitor, null);
	  			addToAST( moduleVisitor.getAST() );
	  		}
	    }
		return data;
	}
}
