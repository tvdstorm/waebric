public class StatementVisitor extends WaebricParserVisitorAdapter {
	private String ast = "";
	
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
  			ast += "[";
			MarkupVisitor markupVisitor = new MarkupVisitor();
  			node.jjtGetChild(currentChild).jjtAccept(markupVisitor, null);
  			ast += markupVisitor.getAST() + "]";
  		}
		if (node.jjtGetChild(currentChild).toString().equals("Statement")){
  			ast += "";
			StatementVisitor statementVisitor = new StatementVisitor();
  			node.jjtGetChild(currentChild).jjtAccept(statementVisitor, null);
  			ast += statementVisitor.getAST() + "]";
  		}
    }
	  	ast += ")";
		return data;
	}
	
	public String getAST(){
		return ast;
	}
}