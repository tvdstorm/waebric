public class DesignatorVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTDesignator node, Object data){
		int numChildren = node.jjtGetNumChildren();
		
		ast += "tag(";
		
		ast += node.image + ", [";
		
	  	for ( int currentChild = 0; currentChild < numChildren; currentChild++ ) {
  			// if list
	  		if (currentChild > 0){
  				ast += ", ";
  			}
	  		if (node.jjtGetChild(currentChild).toString().equals("Attribute")){
	  			AttributeVisitor attributeVisitor = new AttributeVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(attributeVisitor, null);
	  			ast += attributeVisitor.getAST();
	  		}
	    }
	  	
	  	ast += "])";
		return data;
	}
}
