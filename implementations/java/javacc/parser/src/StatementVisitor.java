public class StatementVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTStatement node, Object data){
		int numChildren = node.jjtGetNumChildren();
		ast += "";
		
		ast += node.image;
  	
	  	for ( int currentChild = 0; currentChild < numChildren; currentChild++ ) {
  			// if list
	  		if (currentChild > 0){
  				ast += ", ";
  			}		
		if (node.jjtGetChild(currentChild).toString().equals("Markup")){
  			ast += "";
			MarkupVisitor markupVisitor = new MarkupVisitor();
  			node.jjtGetChild(currentChild).jjtAccept(markupVisitor, null);
  			
  			if (node.jjtGetChild(currentChild+1).toString() != "Markup") {
  	  			ast += markupVisitor.getAST() + "]";	
  			} else {
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
	  	ast += ")";
		return data;
	}
}