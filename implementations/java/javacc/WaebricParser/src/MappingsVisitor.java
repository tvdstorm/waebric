public class MappingsVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTMappings node, Object data){
		int numChildren = node.jjtGetNumChildren();
		
		ast += "[";
		
	  	for ( int currentChild = 0; currentChild < numChildren; currentChild++ ) {
	  		if (node.jjtGetChild(currentChild).toString().equals("Mapping")){
	  			MappingVisitor mappingVisitor = new MappingVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(mappingVisitor, null);
	  			ast += mappingVisitor.getAST();
	  		}
	    }
	  	
	  	ast += "]";
	  	
		return data;
	}
}