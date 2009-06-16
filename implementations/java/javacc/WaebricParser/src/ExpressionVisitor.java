public class ExpressionVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTExpression node, Object data){
		
		// Make a choice between kinds of expressions
		String[] dataFromJjt = node.image.split(":");
		
		if(	dataFromJjt[0].equals("sym")) {
			addToAST( dataFromJjt[0] + "(\"" + safeGetStr(dataFromJjt, 1) + "\")" );
		}
		
		else if(dataFromJjt[0].equals("text")){
			addToAST( dataFromJjt[0] + "(\"\\\"" + safeGetStr(dataFromJjt, 1) + "\\\"\")" );
		}
		
		else if(dataFromJjt[0].equals("num")){
			addToAST( dataFromJjt[0] + "(" + safeGetStr(dataFromJjt, 1) + ")" );
		}
		
		else if(dataFromJjt[0].equals("list") || dataFromJjt[0].equals("record")) {
			addToAST( dataFromJjt[0] + "([" );
			processChildren(node);
			addToAST( "])" );
		}

		else if(dataFromJjt[0].equals("var")){
			VarVisitor varVisitor = new VarVisitor();
  			node.jjtGetChild(0).jjtAccept(varVisitor, null);
  			addToAST( varVisitor.getAST() );
		}
		
		return data;
	}
	
	private void processChildren(ASTExpression node) {
		int numberOfChildren = node.jjtGetNumChildren();
		
		for ( int currentChild = 0; currentChild < numberOfChildren; currentChild++ ) {
			if (node.jjtGetChild(currentChild).toString().equals("Expression")){
  				ExpressionVisitor expressionVisitor = new ExpressionVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(expressionVisitor, null);
  				addToAST( expressionVisitor.getAST() );
  			}
			
			else if (node.jjtGetChild(currentChild).toString().equals("DotIdCon")){
				DotIdConVisitor dotIdConVisitor = new DotIdConVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(dotIdConVisitor, null);
  				addToAST( dotIdConVisitor.getAST() );
  			}

			else if (node.jjtGetChild(currentChild).toString().equals("KeyValuePair")){
	  			KeyValuePairVisitor keyValuePairVisitor = new KeyValuePairVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(keyValuePairVisitor, null);
	  			addToAST( keyValuePairVisitor.getAST() );
		  	}
		}
	}
}