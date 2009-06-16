public class ImportVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTImport node, Object data){
		int numChildren = node.jjtGetNumChildren();
		
		addToAST( "import(" );
		
	  	for ( int currentChild = 0; currentChild < numChildren; currentChild++ ) {
	  		if (node.jjtGetChild(currentChild).toString().equals("ModuleId")){
	  			ModuleIdVisitor moduleidVisitor = new ModuleIdVisitor();
	  			node.jjtAccept(moduleidVisitor, null);
	  			addToAST( moduleidVisitor.getAST() );
	  		}
	    }
	  	
	  	addToAST( ")" );
		return data;
	}
}