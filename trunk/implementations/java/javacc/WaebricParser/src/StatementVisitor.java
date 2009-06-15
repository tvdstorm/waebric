public class StatementVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTStatement node, Object data){
		int numChildren = node.jjtGetNumChildren();
		
		boolean isBlock = false;
		
		ast += "";
		
		// Make a choice between kinds of statements
		String[] dataFromStatement = node.image.split(":");
	
		if(dataFromStatement[0].equals("block")){
			ast += dataFromStatement[0] + "([";
			isBlock=true;
		}
		else if(dataFromStatement[0].equals("markup")){
			ast += dataFromStatement[0] + "([";
		}
		
		else if(dataFromStatement[0].equals("markup-exp") ||
			dataFromStatement[0].equals("markup-stat") ||
			dataFromStatement[0].equals("markup-embedding") ||
			dataFromStatement[0].equals("markup-markup")){
			
			// May not appear is statement parent has earlier Markup neighbor node
			if(getOwnIndex(node) == 0){
				if(node.jjtGetParent().toString().equals("Statement")){
					if(!doesPreviousExists(node.jjtGetParent(), "Markup")){
						ast += dataFromStatement[0] + "([";
					}
				}
				else{
					ast += dataFromStatement[0] + "([";
				}
			}
		}
		else if(dataFromStatement[0].equals("yield")){
			ast += dataFromStatement[0];
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
		
	  		if (node.jjtGetChild(currentChild).toString().equals("Markup")){
	  			
	  			ast += "";
	  			MarkupVisitor markupVisitor = new MarkupVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(markupVisitor, null);
  			
	  			if (currentChild + 1 < numChildren){
	  				if (node.jjtGetChild(currentChild+1).toString() != "Markup") {
	  					ast += markupVisitor.getAST() + "]";	
	  				} else {
  					ast += markupVisitor.getAST();
	  				}
	  			} else
	  			{
	  				ast += markupVisitor.getAST();
	  			}
	  		}
	  		
	  		if (node.jjtGetChild(currentChild).toString().equals("Statement")){
	  			ast += "";
	  			StatementVisitor statementVisitor = new StatementVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(statementVisitor, null);
	  			ast += statementVisitor.getAST() + "";
	  		}
		
	  		if (node.jjtGetChild(currentChild).toString().equals("Expression")){
	  			ast += "";
	  			ExpressionVisitor expressionVisitor = new ExpressionVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(expressionVisitor, null);
	  			ast += expressionVisitor.getAST() + "";
	  		}
	  	}
	  	if(isBlock)
	  	{
	  		ast += "]";
	  	}
	  	else
	  	{
	  		ast += ")";
	  	}
	  	
		return data;
	}
	
	private int getOwnIndex(Node n)
	{
		int returnInt = 999;
		
		for(int i=0; i < n.jjtGetParent().jjtGetNumChildren() ;i++)
		{
			if(n.jjtGetParent().jjtGetChild(i).equals(n)){
				returnInt = i;
			}
		}
		return returnInt;
	}

	private boolean doesChildExists(Node node, String childName) {
		  for(int i = 0; i < node.jjtGetNumChildren(); i++) {
			  if(node.jjtGetChild(i).toString().equals(childName)) {
				  return true;
			  }
		  }
		  return false;
	  }
	
	private boolean doesPreviousExists(Node node, String childName) {
		  for(int i = 0; i < getOwnIndex(node) -1 ; i++) {
			  if(node.jjtGetChild(i).toString().equals(childName)) {
				  return true;
			  }
		  }
		  return false;
	  }
}