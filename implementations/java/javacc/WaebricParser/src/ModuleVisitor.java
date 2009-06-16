public class ModuleVisitor extends WaebricParserVisitorAdapter {	
	public Object visit(ASTModule node, Object data){
		int numChildren = node.jjtGetNumChildren();
		
		addToAST( "module(" );
		
	  	for ( int currentChild = 0; currentChild < numChildren; currentChild++ ) {
	  		if (node.jjtGetChild(currentChild).toString().equals("ModuleId")){
	  			ModuleIdVisitor moduleidVisitor = new ModuleIdVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(moduleidVisitor, null);
	  			addToAST( moduleidVisitor.getAST() + ", [" );
	  		} 
	  		else if (node.jjtGetChild(currentChild).toString().equals("ModuleElement")){
	  			ModuleElementVisitor importVisitor = new ModuleElementVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(importVisitor, null);
	  			
	  			if (currentChild > 1) {
	  				addToAST( ", " );
	  			}
	  			addToAST( importVisitor.getAST() );
	  		}
	    }
	  	
	  	addToAST( "])" );
		return data;
	}
}
