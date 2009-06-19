public class DesignatorVisitor extends WaebricParserVisitorAdapter {
	private static final int FIRST_CHILD = 0;
	
	public Object visit(ASTDesignator node, Object data){
		addToAST( "tag(" + addQuotes( node.image ) + ", [" );
		
		int numChildren = node.jjtGetNumChildren();
	  	for ( int currentChild = FIRST_CHILD; currentChild < numChildren; currentChild++ ) {
  			// if list
	  		if (FIRST_CHILD < currentChild){
  				addToAST( ", " );
  			}
	  		if (node.jjtGetChild(currentChild).toString().equals(NODE_ATTRIBUTE)){
	  			AttributeVisitor attributeVisitor = new AttributeVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(attributeVisitor, null);
	  			addToAST( attributeVisitor.getAST() );
	  		}
	    }
	  	
	  	addToAST( "])" );
		return data;
	}
}
