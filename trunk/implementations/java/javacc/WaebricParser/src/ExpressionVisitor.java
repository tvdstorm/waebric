public class ExpressionVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTExpression node, Object data){
		
		// Make a choice between kinds of expressions
		String[] dataFromJjt = node.image.split(":");
		
		if(	dataFromJjt[0].equals("sym")) {
			ast += dataFromJjt[0] + "(\"" + safeGetStr(dataFromJjt, 1) + "\")";
		}
		
		else if(dataFromJjt[0].equals("text")){
			if (dataFromJjt.length > 1){
				ast += dataFromJjt[0] + "(\"\\\"" + safeGetStr(dataFromJjt, 1) + "\\\"\")";
			}
		}
		
		else if(dataFromJjt[0].equals("num")){
			ast += dataFromJjt[0] + "(" + safeGetStr(dataFromJjt, 1) + ")";
		}
		
		else if(dataFromJjt[0].equals("list") || dataFromJjt[0].equals("record")) {
			ast += dataFromJjt[0] + "([";
			processChildren(node);
			ast += "])";
		}

		else if(dataFromJjt[0].equals("var")){
			VarVisitor varVisitor = new VarVisitor();
  			node.jjtGetChild(0).jjtAccept(varVisitor, null);
  			ast += varVisitor.getAST();
		}
		
		return data;
	}
	
	private void processChildren(ASTExpression node) {
		int numberOfChildren = node.jjtGetNumChildren();
		
		for ( int currentChild = 0; currentChild < numberOfChildren; currentChild++ ) {
			if (node.jjtGetChild(currentChild).toString().equals("Expression")){
  				ExpressionVisitor expressionVisitor = new ExpressionVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(expressionVisitor, null);
  				ast += expressionVisitor.getAST();
  			}
			
			else if (node.jjtGetChild(currentChild).toString().equals("DotIdCon")){
				DotIdConVisitor dotIdConVisitor = new DotIdConVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(dotIdConVisitor, null);
  				ast += dotIdConVisitor.getAST();
  			}

			else if (node.jjtGetChild(currentChild).toString().equals("KeyValuePair")){
	  			KeyValuePairVisitor keyValuePairVisitor = new KeyValuePairVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(keyValuePairVisitor, null);
	  			ast += keyValuePairVisitor.getAST();
		  	}
		}
	}
}