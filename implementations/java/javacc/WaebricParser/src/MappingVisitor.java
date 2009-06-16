public class MappingVisitor extends WaebricParserVisitorAdapter {	
	public Object visit(ASTMapping node, Object data){
		int numChildren = node.jjtGetNumChildren();

		addToAST( "mapping(" );
		
	  	for ( int currentChild = 0; currentChild < numChildren; currentChild++ ) {
  			// if list
	  		if (currentChild > 0){
  				addToAST( ", " );
  			}
	  		if (node.jjtGetChild(currentChild).toString().equals("Path")){
	  			PathVisitor pathVisitor = new PathVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(pathVisitor, null);
	  			addToAST( pathVisitor.getAST() ); 
	  		} 
	  		else if (node.jjtGetChild(currentChild).toString().equals("Markup")){
	  			MarkupVisitor markupVisitor = new MarkupVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(markupVisitor, null);
	  			addToAST( markupVisitor.getAST() );
	  		}
	    }
	  	
	  	addToAST( ")" );
		return data;
	}
}