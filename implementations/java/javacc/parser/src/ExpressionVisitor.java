public class ExpressionVisitor extends WaebricParserVisitorAdapter {
	private String ast = "";
	
	public Object visit(ASTExpression node, Object data){
		int numChildren = node.jjtGetNumChildren();
		
		ast += "";
		
		ast += node.image;
		
	  	for ( int currentChild = 0; currentChild < numChildren; currentChild++ ) {
  			// if list
	  		if (currentChild > 0){
  				ast += ", ";
  			}
	  		if (node.jjtGetChild(currentChild).toString().equals("Var")){
	  			VarVisitor varVisitor = new VarVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(varVisitor, null);
	  			ast += varVisitor.getAST();
	  		} else
	  		if (node.jjtGetChild(currentChild).toString().equals("Expression")){
	  			ExpressionVisitor expressionVisitor = new ExpressionVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(expressionVisitor, null);
	  			ast += expressionVisitor.getAST();
	  		} else 
		  	if (node.jjtGetChild(currentChild).toString().equals("KeyValuePair")){
	  			KeyValuePairVisitor keyValuePairVisitor = new KeyValuePairVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(keyValuePairVisitor, null);
	  			ast += keyValuePairVisitor.getAST();
		  	}
	    }
	  	
	  	if (node.parent.toString().equals("Expression")){
	  		// close list
	  		ast += "])";
	  	}
	  	ast += "";
		return data;
	}
	
	public String getAST(){
		return ast;
	}
}