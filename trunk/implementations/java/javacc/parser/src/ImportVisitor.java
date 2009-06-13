public class ImportVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTImport node, Object data){
		int numChildren = node.jjtGetNumChildren();
		
		ast += "import(";
		
	  	for ( int currentChild = 0; currentChild < numChildren; currentChild++ ) {
	  		if (node.jjtGetChild(currentChild).toString().equals("ModuleId")){
	  			ModuleIdVisitor moduleidVisitor = new ModuleIdVisitor();
	  			node.jjtAccept(moduleidVisitor, null);
	  			ast += moduleidVisitor.getAST();
	  		}
	    }
	  	
	  	ast += ")";
		return data;
	}
}