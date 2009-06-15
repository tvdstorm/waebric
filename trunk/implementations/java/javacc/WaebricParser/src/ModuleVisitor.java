public class ModuleVisitor extends WaebricParserVisitorAdapter {	
	public Object visit(ASTModule node, Object data){
		int numChildren = node.jjtGetNumChildren();
		
		ast += "module(";
		
	  	for ( int currentChild = 0; currentChild < numChildren; currentChild++ ) {
	  		if (node.jjtGetChild(currentChild).toString().equals("ModuleId")){
	  			ModuleIdVisitor moduleidVisitor = new ModuleIdVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(moduleidVisitor, null);
	  			ast += moduleidVisitor.getAST() + ", [";
	  		} 
	  		else if (node.jjtGetChild(currentChild).toString().equals("ModuleElement")){
	  			ModuleElementVisitor importVisitor = new ModuleElementVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(importVisitor, null);
	  			
	  			if (currentChild > 1) {
	  				ast += ", ";
	  			}
	  			ast += importVisitor.getAST();
	  		}
	    }
	  	
	  	ast += "])";
		return data;
	}
}
