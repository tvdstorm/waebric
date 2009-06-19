public class ArgumentsVisitor extends WaebricParserVisitorAdapter {
	private static final int FIRST_CHILD = 0;
	
	public Object visit(ASTArguments node, Object data){
		int numChildren = node.jjtGetNumChildren();
		
		addToAST( "args([" );
		
		/**
		 * This method controls which visitors can be used for scanning the children of Arguments()
		 * @param node: holds the Arguments node and all its children.
		 */
		for ( int currentChild = FIRST_CHILD; currentChild < numChildren; currentChild++ ) {
  			// if list
	  		if (currentChild > FIRST_CHILD){
  				addToAST( ", " );
  			}
	  		if (node.jjtGetChild(currentChild).toString().equals(NODE_ARGUMENT)){
	  			ArgumentVisitor argumentVisitor = new ArgumentVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(argumentVisitor, null);
	  			addToAST( argumentVisitor.getAST() );
	  		}
	    }
	  	
	  	addToAST( "])" );
		return data;
	}
}