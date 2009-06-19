public class ModuleVisitor extends WaebricParserVisitorAdapter {
	private static final int FIRST_CHILD = 0;
	
	public Object visit(ASTModule node, Object data){
		addToAST( "module(" );

		int numChildren = node.jjtGetNumChildren();		
	  	for ( int currentChild = FIRST_CHILD; currentChild < numChildren; currentChild++ ) {
	  		if ( node.jjtGetChild(currentChild).toString().equals(NODE_MODULEID) ){
	  			ModuleIdVisitor moduleidVisitor = new ModuleIdVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(moduleidVisitor, null);
	  			addToAST( moduleidVisitor.getAST() + ", [" );
	  		} 
	  		else if ( node.jjtGetChild(currentChild).toString().equals(NODE_MODULEELEMENT) ){
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
