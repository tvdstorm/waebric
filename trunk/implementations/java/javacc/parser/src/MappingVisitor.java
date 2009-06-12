public class MappingVisitor extends WaebricParserVisitorAdapter {
	private String ast = "mapping(";
	
	public Object visit(ASTMapping node, Object data){
		int numChildren = node.jjtGetNumChildren();
		
		ast += "";
		
	  	for ( int currentChild = 0; currentChild < numChildren; currentChild++ ) {
  			// if list
	  		if (currentChild > 0){
  				ast += ", ";
  			}
	  		if (node.jjtGetChild(currentChild).toString().equals("Path")){
	  			PathVisitor pathVisitor = new PathVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(pathVisitor, null);
	  			ast += pathVisitor.getAST();
	  		} else
	  		if (node.jjtGetChild(currentChild).toString().equals("Markup")){
	  			MarkupVisitor markupVisitor = new MarkupVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(markupVisitor, null);
	  			ast += markupVisitor.getAST();
	  		}
	    }
	  	
	  	ast += ")";
		return data;
	}
	
	public String getAST(){
		return ast;
	}
}