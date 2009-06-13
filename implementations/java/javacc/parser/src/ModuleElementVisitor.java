public class ModuleElementVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTModuleElement node, Object data){
		int numChildren = node.jjtGetNumChildren();
		
		ast += "";
		
	  	for ( int currentChild = 0; currentChild < numChildren; currentChild++ ) {
  			// if list
	  		if (currentChild > 0){
  				ast += ", ";
  			}
	  		if (node.jjtGetChild(currentChild).toString().equals("Import")){
	  			ImportVisitor importVisitor = new ImportVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(importVisitor, null);
	  			ast += importVisitor.getAST();
	  		} else
	  		if (node.jjtGetChild(currentChild).toString().equals("Site")){
	  			SiteVisitor siteVisitor = new SiteVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(siteVisitor, null);			
	  			ast += siteVisitor.getAST();
	  		} else
	  		if (node.jjtGetChild(currentChild).toString().equals("FunctionDef")){
	  			FunctionDefVisitor functionDefVisitor = new FunctionDefVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(functionDefVisitor, null);			
	  			ast += functionDefVisitor.getAST();
	  		}
	    }
	  	
	  	ast += "";
		return data;
	}
}