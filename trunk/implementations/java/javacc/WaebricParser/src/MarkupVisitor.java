public class MarkupVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTMarkup node, Object data){
		int numChildren = node.jjtGetNumChildren();
		
		ast += "";
	  	// Markup is a call if parent is mapping and markup has arguments		
		if ((node.jjtGetNumChildren() == 2) && (node.parent.toString().equals("Mapping"))){
			ast += "call(";
		}
		
	  	for ( int currentChild = 0; currentChild < numChildren; currentChild++ ) {
  			// if list
	  		if (currentChild > 0){
  				ast += ", ";
  			}
	  		if (node.jjtGetChild(currentChild).toString().equals("Designator")){
	  			DesignatorVisitor designatorVisitor = new DesignatorVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(designatorVisitor, null);
	  			ast += designatorVisitor.getAST();
	  		} else
	  		if (node.jjtGetChild(currentChild).toString().equals("Arguments")){
	  			ArgumentsVisitor argumentsVisitor = new ArgumentsVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(argumentsVisitor, null);
	  			ast += argumentsVisitor.getAST();
	  		}
	    }
	  	// Markup is a call if parent is mapping and markup has arguments
		if ((node.jjtGetNumChildren() == 2) && (node.parent.toString().equals("Mapping"))){
			ast += ")";
		}
		
	  	ast += "";
		return data;
	}
}