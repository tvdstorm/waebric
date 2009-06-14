public class FunctionDefVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTFunctionDef node, Object data){
		int numChildren = node.jjtGetNumChildren();
		
		ast += "def(";
		
	  	ast += node.image + ", ";
	  	
	  	// if no formals then set that area to empty
	  	if (numChildren > 0){
	  		
	  		if (!node.jjtGetChild(0).toString().equals("Formals")){
	  			ast += "empty, [";
	  		}
	  	} else {
	  		ast += "empty, [";
	  	}
	  	
	  	for ( int currentChild = 0; currentChild < numChildren; currentChild++ ) {
  			// if list
	  		if (currentChild > 1){
  				ast += ", ";
  			}
	  		if (node.jjtGetChild(currentChild).toString().equals("Formals")){
	  			FormalsVisitor formalsVisitor = new FormalsVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(formalsVisitor, null);
	  			ast += formalsVisitor.getAST() + ", [";
	  		} else
	  		if (node.jjtGetChild(currentChild).toString().equals("Statement")){
	  			StatementVisitor statementVisitor = new StatementVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(statementVisitor, null);
	  			ast += statementVisitor.getAST()+ ")";
	  		}
	    }
	  	
	  	ast += "])";
		return data;
	}
}