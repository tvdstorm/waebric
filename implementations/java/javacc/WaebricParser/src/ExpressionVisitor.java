public class ExpressionVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTExpression node, Object data){
		int numChildren = node.jjtGetNumChildren();
		
		ast += "";
		
		// Make a choice between kinds of statements
		String[] dataFromStatement = node.image.split(":");
		
		if(	dataFromStatement[0].equals("sym")) {
				ast += dataFromStatement[0] + "(\"" + dataFromStatement[1] + "\")";
		}
		
		else if(dataFromStatement[0].equals("text")){
			ast += dataFromStatement[0] + "(\"\\\"" + dataFromStatement[1] + "\\\"\")";
		}
		
		else if(dataFromStatement[0].equals("num")){
			ast += dataFromStatement[0] + "(" + dataFromStatement[1] + ")";
		}
		
		else if(dataFromStatement[0].equals("list") ||
					dataFromStatement[0].equals("record")){
			ast += dataFromStatement[0] + "([" + dataFromStatement[1];
		}
		else {
			ast += node.image;
		}
		// end choice
		
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
	
	private String addBackslash(String text)
	{
		return text.replaceAll("\"", "\\\"");
	}
}