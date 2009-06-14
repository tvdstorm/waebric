public class ArgumentVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTArgument node, Object data){
		int numChildren = node.jjtGetNumChildren();
		
		ast += "";
		
	  	for ( int currentChild = 0; currentChild < numChildren; currentChild++ ) {
  			// if list
	  		if (currentChild > 0){
  				ast += ", ";
  			}
	  		if (node.jjtGetChild(currentChild).toString().equals("Var")){
	  			VarVisitor varVisitor = new VarVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(varVisitor, null);
	  			ast += varVisitor.getAST();
	  		}
	  		if (node.jjtGetChild(currentChild).toString().equals("Expression")){
	  			String nodeImage = node.image;
	  			if (!nodeImage.equals("")){
	  				ast += "attr(" + node.image +  ", ";
	  			}
	  			ExpressionVisitor expressionVisitor = new ExpressionVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(expressionVisitor, null);
	  			ast += expressionVisitor.getAST();
	  			if (!nodeImage.equals("")){
	  				ast += ")";
	  			}
	  		}
	    }
	  	
	  	ast += "";
		return data;
	}
}