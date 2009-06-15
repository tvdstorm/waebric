public class ArgumentVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTArgument node, Object data){
		int numChildren = node.jjtGetNumChildren();
		
		ast += "";
		
	  	for ( int currentChild = 0; currentChild < numChildren; currentChild++ ) {
  			// if list
	  		if (currentChild > 0){
  				ast += ", ";
  			}
			
	  		if (node.jjtGetChild(currentChild).toString().equals("DotIdCon")){
				DotIdConVisitor dotIdConVisitor = new DotIdConVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(dotIdConVisitor, null);
  				ast += dotIdConVisitor.getAST();
  			}
	  		
	  		else if (node.jjtGetChild(currentChild).toString().equals("Expression")){
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