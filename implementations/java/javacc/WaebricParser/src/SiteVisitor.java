public class SiteVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTSite node, Object data){
		int numChildren = node.jjtGetNumChildren();
		
		ast += "site([";
		
	  	for ( int currentChild = 0; currentChild < numChildren; currentChild++ ) {
	  		if (node.jjtGetChild(currentChild).toString().equals("Mappings")){
	  			MappingsVisitor mappingsVisitor = new MappingsVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(mappingsVisitor, null);
	  			ast += mappingsVisitor.getAST();
	  		}
	    }
	  	
	  	ast += "])";
		return data;
	}
}