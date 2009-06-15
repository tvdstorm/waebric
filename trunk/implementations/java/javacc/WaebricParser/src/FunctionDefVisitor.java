public class FunctionDefVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTFunctionDef node, Object data){
		int numChildren = node.jjtGetNumChildren();
		
		ast += "def(" + node.image + ", ";
	  	
	  	// Run formal
	  	if (node.jjtGetChild(0).toString().equals("Formals")){
	  		FormalsVisitor formalsVisitor = new FormalsVisitor();
  			node.jjtGetChild(0).jjtAccept(formalsVisitor, null);
  			ast += formalsVisitor.getAST() + ", [";
	  	}else{
	  		ast += "empty, [";
	  	}
	  	
	  	// Iterate through statements
	  	for ( int currentChild = 0; currentChild < numChildren; currentChild++ ) {
	  		if (currentChild > 1){
  				ast += ", ";
  			} 
	  		else 	if ((node.jjtGetChild(0).toString().equals("Statement"))&
	  			(currentChild > 0)){
  				ast += ", ";
  			}
	  		
	  		if (node.jjtGetChild(currentChild).toString().equals("Statement")){
	  			StatementVisitor statementVisitor = new StatementVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(statementVisitor, null);
	  			ast += statementVisitor.getAST();
	  		}
	    }
	  	
	  	ast += "])";
		return data;
	}
}