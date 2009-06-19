public class ModulesVisitor extends WaebricParserVisitorAdapter {
	private static final int FIRST_CHILD = 0;
	
	public Object visit(ASTModules node, Object data){
		int numChildren = node.jjtGetNumChildren();

	  	for ( int currentChild = FIRST_CHILD; currentChild < numChildren; currentChild++ ) {
	  		if ( node.jjtGetChild(currentChild).toString().equals(NODE_MODULE) ){
	  			ModuleVisitor moduleVisitor = new ModuleVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(moduleVisitor, null);
	  			addToAST( moduleVisitor.getAST() );
	  		}
	    }
		return data;
	}
}
