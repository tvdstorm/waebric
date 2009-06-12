public class ArgumentsVisitor extends WaebricParserVisitorAdapter {
	private String ast = "";
	
	public Object visit(ASTArguments node, Object data){
		int numChildren = node.jjtGetNumChildren();
		
		ast += "args([";
		
	  	for ( int currentChild = 0; currentChild < numChildren; currentChild++ ) {
  			// if list
	  		if (currentChild > 0){
  				ast += ", ";
  			}
	  		if (node.jjtGetChild(currentChild).toString().equals("Argument")){
	  			ArgumentVisitor argumentVisitor = new ArgumentVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(argumentVisitor, null);
	  			ast += argumentVisitor.getAST();
	  		}
	    }
	  	
	  	ast += "])";
		return data;
	}
	
	public String getAST(){
		return ast;
	}
}