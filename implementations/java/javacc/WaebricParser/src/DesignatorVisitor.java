public class DesignatorVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTDesignator node, Object data){
		int numChildren = node.jjtGetNumChildren();
		
		addToAST( "tag(" + node.image + ", [" );
		
	  	for ( int currentChild = 0; currentChild < numChildren; currentChild++ ) {
  			// if list
	  		if (currentChild > 0){
  				addToAST( ", " );
  			}
	  		if (node.jjtGetChild(currentChild).toString().equals("Attribute")){
	  			AttributeVisitor attributeVisitor = new AttributeVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(attributeVisitor, null);
	  			addToAST( attributeVisitor.getAST() );
	  		}
	    }
	  	
	  	addToAST( "])" );
		return data;
	}
}
