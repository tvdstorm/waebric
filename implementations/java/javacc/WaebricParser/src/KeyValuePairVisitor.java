public class KeyValuePairVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTKeyValuePair node, Object data){
		int numChildren = node.jjtGetNumChildren();
		
		addToAST( "pair(" );
		
		addToAST( node.image + ", " );
		
	  	for ( int currentChild = 0; currentChild < numChildren; currentChild++ ) {
  			// if list
	  		if (currentChild > 0){
  				addToAST( ", " );
  			}
	  		if (node.jjtGetChild(currentChild).toString().equals("Expression")){
	  			ExpressionVisitor expressionVisitor = new ExpressionVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(expressionVisitor, null);
	  			addToAST( expressionVisitor.getAST() );
	  		}
	    }
	  	if (node.parent.toString().equals("Expression")){
	  		// close record
	  		addToAST( "])" );
	  	}
	  	addToAST( ")" );
		return data;
	}
}