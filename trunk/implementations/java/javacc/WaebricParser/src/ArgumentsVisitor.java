public class ArgumentsVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTArguments node, Object data){
		int numChildren = node.jjtGetNumChildren();
		
		addToAST( "args([" );
		node.value = "";
	  	for ( int currentChild = 0; currentChild < numChildren; currentChild++ ) {
  			// if list
	  		if (currentChild > 0){
  				addToAST( ", " );
  			}
	  		if (node.jjtGetChild(currentChild).toString().equals("Argument")){
	  			ArgumentVisitor argumentVisitor = new ArgumentVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(argumentVisitor, null);
	  			addToAST( argumentVisitor.getAST() );
	  		}
	    }
	  	
	  	addToAST( "])" );
		return data;
	}
}