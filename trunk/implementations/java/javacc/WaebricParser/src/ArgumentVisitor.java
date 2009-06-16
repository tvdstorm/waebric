public class ArgumentVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTArgument node, Object data){
		int numChildren = node.jjtGetNumChildren();

	  	for ( int currentChild = 0; currentChild < numChildren; currentChild++ ) {
  			// if list
	  		if (currentChild > 0){
  				addToAST(", ");
  			}
			
	  		if (node.jjtGetChild(currentChild).toString().equals("DotIdCon")){
				DotIdConVisitor dotIdConVisitor = new DotIdConVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(dotIdConVisitor, null);
  				addToAST(dotIdConVisitor.getAST());
  			}
	  		
	  		else if (node.jjtGetChild(currentChild).toString().equals("Expression")){
	  			String nodeImage = node.image;
	  			if (!nodeImage.equals("")){
	  				addToAST("attr(" + node.image +  ", ");
	  			}
	  			ExpressionVisitor expressionVisitor = new ExpressionVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(expressionVisitor, null);
	  			addToAST(expressionVisitor.getAST());
	  			if (!nodeImage.equals("")){
	  				addToAST(")");
	  			}
	  		}
	    }
		return data;
	}
}