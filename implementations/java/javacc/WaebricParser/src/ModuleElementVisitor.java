public class ModuleElementVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTModuleElement node, Object data){
		int numChildren = node.jjtGetNumChildren();
		
		addToAST( "" );
		
	  	for ( int currentChild = 0; currentChild < numChildren; currentChild++ ) {
  			// if list
	  		if (currentChild > 0){
  				addToAST( ", " );
  			}
	  		if (node.jjtGetChild(currentChild).toString().equals("Import")){
	  			ImportVisitor importVisitor = new ImportVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(importVisitor, null);
	  			addToAST( importVisitor.getAST() );
	  		} 
	  		else if (node.jjtGetChild(currentChild).toString().equals("Site")){
	  			SiteVisitor siteVisitor = new SiteVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(siteVisitor, null);			
	  			addToAST( siteVisitor.getAST() );
	  		} 
	  		else if (node.jjtGetChild(currentChild).toString().equals("FunctionDef")){
	  			FunctionDefVisitor functionDefVisitor = new FunctionDefVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(functionDefVisitor, null);			
	  			addToAST( functionDefVisitor.getAST() );
	  		}
	    }
	  	
	  	addToAST( "" );
		return data;
	}
}