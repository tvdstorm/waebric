public class KeyValuePairVisitor extends WaebricParserVisitorAdapter {
	private String ast = "";
	
	public Object visit(ASTKeyValuePair node, Object data){
		int numChildren = node.jjtGetNumChildren();
		
		ast += "pair(";
		
		ast += node.image + ", ";
		
	  	for ( int currentChild = 0; currentChild < numChildren; currentChild++ ) {
  			// if list
	  		if (currentChild > 0){
  				ast += ", ";
  			}
	  		if (node.jjtGetChild(currentChild).toString().equals("Expression")){
	  			ExpressionVisitor expressionVisitor = new ExpressionVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(expressionVisitor, null);
	  			ast += expressionVisitor.getAST();
	  		}
	    }
	  	if (node.parent.toString().equals("Expression")){
	  		// close record
	  		ast += "])";
	  	}
	  	ast += ")";
		return data;
	}
	
	public String getAST(){
		return ast;
	}
}